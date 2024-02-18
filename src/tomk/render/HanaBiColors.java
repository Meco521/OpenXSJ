/*    */ package tomk.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public enum HanaBiColors
/*    */ {
/*  7 */   BLACK(-16711423), BLUE(-12028161), DARKBLUE(-12621684), GREEN(-9830551), DARKGREEN(-9320847), WHITE(-65794), AQUA(-7820064), DARKAQUA(-12621684), GREY(-9868951), DARKGREY(-14342875), RED(-65536), DARKRED(-8388608), ORANGE(-29696), DARKORANGE(-2263808), YELLOW(-256), DARKYELLOW(-2702025), MAGENTA(-18751), DARKMAGENTA(-2252579);
/*    */   
/*    */   public int c;
/*    */   
/*    */   HanaBiColors(int co) {
/* 12 */     this.c = co;
/*    */   }
/*    */   
/*    */   public static int getColor(Color color) {
/* 16 */     return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*    */   }
/*    */   
/*    */   public static int getColor(int brightness) {
/* 20 */     return getColor(brightness, brightness, brightness, 255);
/*    */   }
/*    */   
/*    */   public static int getColor(int brightness, int alpha) {
/* 24 */     return getColor(brightness, brightness, brightness, alpha);
/*    */   }
/*    */   
/*    */   public static int getColor(int red, int green, int blue) {
/* 28 */     return getColor(red, green, blue, 255);
/*    */   }
/*    */   
/*    */   public static int getColor(int red, int green, int blue, int alpha) {
/* 32 */     byte color = 0;
/* 33 */     int color1 = color | alpha << 24;
/*    */     
/* 35 */     color1 |= red << 16;
/* 36 */     color1 |= green << 8;
/* 37 */     color1 |= blue;
/* 38 */     return color1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\render\HanaBiColors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */