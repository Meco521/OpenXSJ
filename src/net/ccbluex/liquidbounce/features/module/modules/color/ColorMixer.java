/*     */ package net.ccbluex.liquidbounce.features.module.modules.color;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.lang.reflect.Field;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.render.BlendUtils;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "ColorMixer", description = "Mix two colors together.", category = ModuleCategory.COLOR, canEnable = false)
/*     */ public class ColorMixer
/*     */   extends Module
/*     */ {
/*  21 */   public static final ColorElement col1RedValue = new ColorElement(1, ColorElement.Material.RED);
/*  22 */   public static final ColorElement col1GreenValue = new ColorElement(1, ColorElement.Material.GREEN);
/*  23 */   public static final ColorElement col1BlueValue = new ColorElement(1, ColorElement.Material.BLUE);
/*  24 */   public static final ColorElement col2GreenValue = new ColorElement(2, ColorElement.Material.GREEN); public final IntegerValue blendAmount = new IntegerValue("Mixer-Amount", 2, 2, 10)
/*     */     {
/*     */       protected void onChanged(Integer oldValue, Integer newValue) {
/*  27 */         ColorMixer.regenerateColors((oldValue != newValue));
/*     */       }
/*     */     };
/*  30 */   public static final ColorElement col2BlueValue = new ColorElement(2, ColorElement.Material.BLUE);
/*  31 */   public static Color[] lastColors = new Color[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static ColorElement col2RedValue = new ColorElement(2, ColorElement.Material.RED);
/*  39 */   private static float[] lastFraction = new float[0];
/*     */   
/*     */   public static Color getMixedColor(int index, int seconds) {
/*  42 */     ColorMixer colMixer = (ColorMixer)Retreat.moduleManager.getModule(ColorMixer.class);
/*  43 */     if (colMixer == null) return Color.white;
/*     */     
/*  45 */     if (lastColors.length <= 0 || lastFraction.length <= 0) {
/*  46 */       regenerateColors(true);
/*     */     }
/*  48 */     return BlendUtils.blendColors(lastFraction, lastColors, (float)((System.currentTimeMillis() + index) % (seconds * 1000)) / (seconds * 1000));
/*     */   }
/*     */   
/*     */   public static void regenerateColors(boolean forceValue) {
/*  52 */     ColorMixer colMixer = (ColorMixer)Retreat.moduleManager.getModule(ColorMixer.class);
/*     */     
/*  54 */     if (colMixer == null) {
/*     */       return;
/*     */     }
/*  57 */     if (forceValue || lastColors.length <= 0 || lastColors.length != ((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1) {
/*  58 */       Color[] generator = new Color[((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1];
/*     */ 
/*     */       
/*  61 */       for (int i = 1; i <= ((Integer)colMixer.blendAmount.get()).intValue(); i++) {
/*  62 */         Color result = Color.white;
/*     */         try {
/*  64 */           Field red = ColorMixer.class.getField("col" + i + "RedValue");
/*  65 */           Field green = ColorMixer.class.getField("col" + i + "GreenValue");
/*  66 */           Field blue = ColorMixer.class.getField("col" + i + "BlueValue");
/*     */           
/*  68 */           int r = ((Integer)((ColorElement)red.get(colMixer)).get()).intValue();
/*  69 */           int g = ((Integer)((ColorElement)green.get(colMixer)).get()).intValue();
/*  70 */           int b = ((Integer)((ColorElement)blue.get(colMixer)).get()).intValue();
/*     */           
/*  72 */           result = new Color(Math.max(0, Math.min(r, 255)), Math.max(0, Math.min(g, 255)), Math.max(0, Math.min(b, 255)));
/*  73 */         } catch (Exception e) {
/*  74 */           e.printStackTrace();
/*     */         } 
/*     */         
/*  77 */         generator[i - 1] = result;
/*     */       } 
/*     */       
/*  80 */       int h = ((Integer)colMixer.blendAmount.get()).intValue();
/*  81 */       for (int z = ((Integer)colMixer.blendAmount.get()).intValue() - 2; z >= 0; z--) {
/*  82 */         generator[h] = generator[z];
/*  83 */         h++;
/*     */       } 
/*     */       
/*  86 */       lastColors = generator;
/*     */     } 
/*     */ 
/*     */     
/*  90 */     if (forceValue || lastFraction.length <= 0 || lastFraction.length != ((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1) {
/*     */       
/*  92 */       float[] colorFraction = new float[((Integer)colMixer.blendAmount.get()).intValue() * 2 - 1];
/*     */       
/*  94 */       for (int i = 0; i <= ((Integer)colMixer.blendAmount.get()).intValue() * 2 - 2; i++) {
/*  95 */         colorFraction[i] = i / (((Integer)colMixer.blendAmount.get()).intValue() * 2 - 2);
/*     */       }
/*     */       
/*  98 */       lastFraction = colorFraction;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 104 */   public final ColorElement col3RedValue = new ColorElement(3, ColorElement.Material.RED, this.blendAmount);
/* 105 */   public final ColorElement col3GreenValue = new ColorElement(3, ColorElement.Material.GREEN, this.blendAmount);
/* 106 */   public final ColorElement col3BlueValue = new ColorElement(3, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 108 */   public final ColorElement col4RedValue = new ColorElement(4, ColorElement.Material.RED, this.blendAmount);
/* 109 */   public final ColorElement col4GreenValue = new ColorElement(4, ColorElement.Material.GREEN, this.blendAmount);
/* 110 */   public final ColorElement col4BlueValue = new ColorElement(4, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 112 */   public final ColorElement col5RedValue = new ColorElement(5, ColorElement.Material.RED, this.blendAmount);
/* 113 */   public final ColorElement col5GreenValue = new ColorElement(5, ColorElement.Material.GREEN, this.blendAmount);
/* 114 */   public final ColorElement col5BlueValue = new ColorElement(5, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 116 */   public final ColorElement col6RedValue = new ColorElement(6, ColorElement.Material.RED, this.blendAmount);
/* 117 */   public final ColorElement col6GreenValue = new ColorElement(6, ColorElement.Material.GREEN, this.blendAmount);
/* 118 */   public final ColorElement col6BlueValue = new ColorElement(6, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 120 */   public final ColorElement col7RedValue = new ColorElement(7, ColorElement.Material.RED, this.blendAmount);
/* 121 */   public final ColorElement col7GreenValue = new ColorElement(7, ColorElement.Material.GREEN, this.blendAmount);
/* 122 */   public final ColorElement col7BlueValue = new ColorElement(7, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 124 */   public final ColorElement col8RedValue = new ColorElement(8, ColorElement.Material.RED, this.blendAmount);
/* 125 */   public final ColorElement col8GreenValue = new ColorElement(8, ColorElement.Material.GREEN, this.blendAmount);
/* 126 */   public final ColorElement col8BlueValue = new ColorElement(8, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 128 */   public final ColorElement col9RedValue = new ColorElement(9, ColorElement.Material.RED, this.blendAmount);
/* 129 */   public final ColorElement col9GreenValue = new ColorElement(9, ColorElement.Material.GREEN, this.blendAmount);
/* 130 */   public final ColorElement col9BlueValue = new ColorElement(9, ColorElement.Material.BLUE, this.blendAmount);
/*     */   
/* 132 */   public final ColorElement col10RedValue = new ColorElement(10, ColorElement.Material.RED, this.blendAmount);
/* 133 */   public final ColorElement col10GreenValue = new ColorElement(10, ColorElement.Material.GREEN, this.blendAmount);
/* 134 */   public final ColorElement col10BlueValue = new ColorElement(10, ColorElement.Material.BLUE, this.blendAmount);
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\color\ColorMixer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */