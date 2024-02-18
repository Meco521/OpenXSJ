/*     */ package tomk.module.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.lang.reflect.Field;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "ColorMixer", description = "Mix two colors together.", category = ModuleCategory.RENDER, canEnable = false)
/*     */ public class ColorMixer
/*     */   extends Module
/*     */ {
/*  22 */   private static float[] lastFraction = new float[0];
/*  23 */   public static Color[] lastColors = new Color[0];
/*     */   
/*  25 */   public final IntegerValue blendAmount = new IntegerValue("Mixer-Amount", 2, 2, 10)
/*     */     {
/*     */       protected void onChanged(Integer oldValue, Integer newValue) {
/*  28 */         ColorMixer.regenerateColors((oldValue != newValue));
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   public static ColorElement col2RedValue = new ColorElement(2, ColorElement.Material.RED);
/*     */   
/*  39 */   public static final ColorElement col1RedValue = new ColorElement(1, ColorElement.Material.RED);
/*  40 */   public static final ColorElement col1GreenValue = new ColorElement(1, ColorElement.Material.GREEN);
/*  41 */   public static final ColorElement col1BlueValue = new ColorElement(1, ColorElement.Material.BLUE);
/*     */   
/*  43 */   public static final ColorElement col2GreenValue = new ColorElement(2, ColorElement.Material.GREEN);
/*  44 */   public static final ColorElement col2BlueValue = new ColorElement(2, ColorElement.Material.BLUE);
/*     */   
/*  46 */   public final ColorElement col3RedValue = new ColorElement(3, ColorElement.Material.RED, this.blendAmount);
/*  47 */   public final ColorElement col3GreenValue = new ColorElement(3, ColorElement.Material.GREEN, this.blendAmount);
/*  48 */   public final ColorElement col3BlueValue = new ColorElement(3, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  50 */   public final ColorElement col4RedValue = new ColorElement(4, ColorElement.Material.RED, this.blendAmount);
/*  51 */   public final ColorElement col4GreenValue = new ColorElement(4, ColorElement.Material.GREEN, this.blendAmount);
/*  52 */   public final ColorElement col4BlueValue = new ColorElement(4, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  54 */   public final ColorElement col5RedValue = new ColorElement(5, ColorElement.Material.RED, this.blendAmount);
/*  55 */   public final ColorElement col5GreenValue = new ColorElement(5, ColorElement.Material.GREEN, this.blendAmount);
/*  56 */   public final ColorElement col5BlueValue = new ColorElement(5, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  58 */   public final ColorElement col6RedValue = new ColorElement(6, ColorElement.Material.RED, this.blendAmount);
/*  59 */   public final ColorElement col6GreenValue = new ColorElement(6, ColorElement.Material.GREEN, this.blendAmount);
/*  60 */   public final ColorElement col6BlueValue = new ColorElement(6, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  62 */   public final ColorElement col7RedValue = new ColorElement(7, ColorElement.Material.RED, this.blendAmount);
/*  63 */   public final ColorElement col7GreenValue = new ColorElement(7, ColorElement.Material.GREEN, this.blendAmount);
/*  64 */   public final ColorElement col7BlueValue = new ColorElement(7, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  66 */   public final ColorElement col8RedValue = new ColorElement(8, ColorElement.Material.RED, this.blendAmount);
/*  67 */   public final ColorElement col8GreenValue = new ColorElement(8, ColorElement.Material.GREEN, this.blendAmount);
/*  68 */   public final ColorElement col8BlueValue = new ColorElement(8, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  70 */   public final ColorElement col9RedValue = new ColorElement(9, ColorElement.Material.RED, this.blendAmount);
/*  71 */   public final ColorElement col9GreenValue = new ColorElement(9, ColorElement.Material.GREEN, this.blendAmount);
/*  72 */   public final ColorElement col9BlueValue = new ColorElement(9, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*  74 */   public final ColorElement col10RedValue = new ColorElement(10, ColorElement.Material.RED, this.blendAmount);
/*  75 */   public final ColorElement col10GreenValue = new ColorElement(10, ColorElement.Material.GREEN, this.blendAmount);
/*  76 */   public final ColorElement col10BlueValue = new ColorElement(10, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/*     */   public static Color getMixedColor(int index, int seconds) {
/*  79 */     ColorMixer colMixer = (ColorMixer)Retreat.moduleManager.getModule(ColorMixer.class);
/*  80 */     if (colMixer == null) return Color.white;
/*     */     
/*  82 */     if (lastColors.length <= 0 || lastFraction.length <= 0) regenerateColors(true);
/*     */     
/*  84 */     return BlendUtils.blendColors(lastFraction, lastColors, (float)((System.currentTimeMillis() + index) % (seconds * 1000)) / (seconds * 1000));
/*     */   }
/*     */   
/*     */   public static void regenerateColors(boolean forceValue) {
/*  88 */     ColorMixer colMixer = (ColorMixer)Retreat.moduleManager.getModule(ColorMixer.class);
/*     */     
/*  90 */     if (colMixer == null) {
/*     */       return;
/*     */     }
/*  93 */     if (forceValue || lastColors.length <= 0 || lastColors.length != ((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1) {
/*  94 */       Color[] generator = new Color[((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1];
/*     */ 
/*     */       
/*  97 */       for (int i = 1; i <= ((Integer)colMixer.blendAmount.get()).intValue(); i++) {
/*  98 */         Color result = Color.white;
/*     */         try {
/* 100 */           Field red = ColorMixer.class.getField("col" + i + "RedValue");
/* 101 */           Field green = ColorMixer.class.getField("col" + i + "GreenValue");
/* 102 */           Field blue = ColorMixer.class.getField("col" + i + "BlueValue");
/*     */           
/* 104 */           int r = ((Integer)((ColorElement)red.get(colMixer)).get()).intValue();
/* 105 */           int g = ((Integer)((ColorElement)green.get(colMixer)).get()).intValue();
/* 106 */           int b = ((Integer)((ColorElement)blue.get(colMixer)).get()).intValue();
/*     */           
/* 108 */           result = new Color(Math.max(0, Math.min(r, 255)), Math.max(0, Math.min(g, 255)), Math.max(0, Math.min(b, 255)));
/* 109 */         } catch (Exception e) {
/* 110 */           e.printStackTrace();
/*     */         } 
/*     */         
/* 113 */         generator[i - 1] = result;
/*     */       } 
/*     */       
/* 116 */       int h = ((Integer)colMixer.blendAmount.get()).intValue();
/* 117 */       for (int z = ((Integer)colMixer.blendAmount.get()).intValue() - 2; z >= 0; z--) {
/* 118 */         generator[h] = generator[z];
/* 119 */         h++;
/*     */       } 
/*     */       
/* 122 */       lastColors = generator;
/*     */     } 
/*     */ 
/*     */     
/* 126 */     if (forceValue || lastFraction.length <= 0 || lastFraction.length != ((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1) {
/*     */       
/* 128 */       float[] colorFraction = new float[((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1];
/*     */       
/* 130 */       for (int i = 0; i <= ((Integer)colMixer.blendAmount.get()).intValue() * 2 - 2; i++)
/*     */       {
/* 132 */         colorFraction[i] = i / (((Integer)colMixer.blendAmount.get()).intValue() * 2 - 2);
/*     */       }
/*     */       
/* 135 */       lastFraction = colorFraction;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\ColorMixer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */