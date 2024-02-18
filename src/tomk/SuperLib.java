/*     */ package tomk;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SuperLib
/*     */ {
/*  15 */   public static int id = 0;
/*  16 */   public static int id2 = 1;
/*  17 */   private static final Minecraft mc = Minecraft.func_71410_x();
/*     */ 
/*     */   
/*     */   public static String removeColorCode(String text) {
/*  21 */     String finalText = text;
/*  22 */     if (text.contains("§")) {
/*  23 */       for (int i = 0; i < finalText.length(); i++) {
/*  24 */         if (Character.toString(finalText.charAt(i)).equals("§")) {
/*     */           try {
/*  26 */             String part1 = finalText.substring(0, i);
/*  27 */             String part2 = finalText.substring(Math.min(i + 2, finalText.length()));
/*  28 */             finalText = part1 + part2;
/*  29 */           } catch (Exception exception) {}
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  35 */     return finalText;
/*     */   }
/*     */   
/*     */   public static int reAlpha(int color, float alpha) {
/*  39 */     Color c = new Color(color);
/*  40 */     float r = 0.003921569F * c.getRed();
/*  41 */     float g = 0.003921569F * c.getGreen();
/*  42 */     float b = 0.003921569F * c.getBlue();
/*  43 */     return (new Color(r, g, b, alpha)).getRGB();
/*     */   }
/*     */   
/*     */   public static void drawImage(ResourceLocation image, int x, int y, int width, int height) {
/*  47 */     GL11.glDisable(2929);
/*  48 */     GL11.glEnable(3042);
/*  49 */     GL11.glDepthMask(false);
/*  50 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  51 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  52 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(image);
/*  53 */     Gui.func_146110_a(x, y, 0.0F, 0.0F, width, height, width, height);
/*  54 */     GL11.glDepthMask(true);
/*  55 */     GL11.glDisable(3042);
/*  56 */     GL11.glEnable(2929);
/*     */   }
/*     */   
/*     */   public static double getAnimationState(double animation, double finalState, double speed) {
/*  60 */     float add = (float)(0.01D * speed);
/*  61 */     if (animation < finalState) {
/*  62 */       if (animation + add < finalState) {
/*  63 */         animation += add;
/*     */       } else {
/*  65 */         animation = finalState;
/*     */       } 
/*  67 */     } else if (animation - add > finalState) {
/*  68 */       animation -= add;
/*     */     } else {
/*  70 */       animation = finalState;
/*     */     } 
/*  72 */     return animation;
/*     */   }
/*     */   
/*     */   public static float getAnimationState(float animation, float finalState, float speed) {
/*  76 */     float add = (float)(0.01D * speed);
/*  77 */     if (animation < finalState) {
/*  78 */       if (animation + add < finalState) {
/*  79 */         animation += add;
/*     */       } else {
/*  81 */         animation = finalState;
/*     */       } 
/*  83 */     } else if (animation - add > finalState) {
/*  84 */       animation -= add;
/*     */     } else {
/*  86 */       animation = finalState;
/*     */     } 
/*  88 */     return animation;
/*     */   }
/*     */   
/*     */   public static double getAnimationState2(double animation, double finalState, double speed) {
/*  92 */     float add = (float)(0.01D * speed);
/*  93 */     if (animation < finalState) {
/*  94 */       animation = finalState;
/*     */     }
/*  96 */     else if (animation - add > finalState) {
/*  97 */       animation -= add;
/*     */     } else {
/*  99 */       animation = finalState;
/*     */     } 
/* 101 */     return animation;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setSpeed(double speed) {
/* 106 */     mc.field_71439_g.field_70159_w = -Math.sin(MovementUtils.getDirection()) * speed;
/* 107 */     mc.field_71439_g.field_70179_y = Math.cos(MovementUtils.getDirection()) * speed;
/*     */   }
/*     */   
/*     */   public static double getSpeed() {
/* 111 */     return Math.sqrt((Minecraft.func_71410_x()).field_71439_g.field_70159_w * (Minecraft.func_71410_x()).field_71439_g.field_70159_w + (Minecraft.func_71410_x()).field_71439_g.field_70179_y * (Minecraft.func_71410_x()).field_71439_g.field_70179_y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Colors
/*     */   {
/* 118 */     BLACK(-16711423),
/* 119 */     BLUE(-12028161),
/* 120 */     DARKBLUE(-12621684),
/* 121 */     GREEN(-9830551),
/* 122 */     DARKGREEN(-9320847),
/* 123 */     WHITE(-65794),
/* 124 */     AQUA(-7820064),
/* 125 */     DARKAQUA(-12621684),
/* 126 */     GREY(-9868951),
/* 127 */     DARKGREY(-14342875),
/* 128 */     RED(-65536),
/* 129 */     DARKRED(-8388608),
/* 130 */     ORANGE(-29696),
/* 131 */     DARKORANGE(-2263808),
/* 132 */     YELLOW(-256),
/* 133 */     DARKYELLOW(-2702025),
/* 134 */     MAGENTA(-18751),
/* 135 */     DARKMAGENTA(-2252579);
/*     */     
/*     */     public int c;
/*     */     
/*     */     Colors(int co) {
/* 140 */       this.c = co;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\SuperLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */