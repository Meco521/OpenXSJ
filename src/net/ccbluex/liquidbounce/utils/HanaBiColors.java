/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public enum HanaBiColors {
/*  6 */   BLACK(-16711423),
/*  7 */   BLUE(-12028161),
/*  8 */   DARKBLUE(-12621684),
/*  9 */   GREEN(-9830551),
/* 10 */   DARKGREEN(-9320847),
/* 11 */   WHITE(-65794),
/* 12 */   AQUA(-7820064),
/* 13 */   DARKAQUA(-12621684),
/* 14 */   GREY(-9868951),
/* 15 */   DARKGREY(-14342875),
/* 16 */   RED(-65536),
/* 17 */   DARKRED(-8388608),
/* 18 */   ORANGE(-29696),
/* 19 */   DARKORANGE(-2263808),
/* 20 */   YELLOW(-256),
/* 21 */   DARKYELLOW(-2702025),
/* 22 */   MAGENTA(-18751),
/* 23 */   DARKMAGENTA(-2252579);
/*    */   
/*    */   public int c;
/*    */   
/*    */   HanaBiColors(int co) {
/* 28 */     this.c = co;
/*    */   }
/*    */   
/*    */   public static int getColor(Color color) {
/* 32 */     return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*    */   }
/*    */   
/*    */   public static int getColor(int brightness) {
/* 36 */     return getColor(brightness, brightness, brightness, 255);
/*    */   }
/*    */   
/*    */   public static int getColor(int brightness, int alpha) {
/* 40 */     return getColor(brightness, brightness, brightness, alpha);
/*    */   }
/*    */   
/*    */   public static int getColor(int red, int green, int blue) {
/* 44 */     return getColor(red, green, blue, 255);
/*    */   }
/*    */   
/*    */   public static int getColor(int red, int green, int blue, int alpha) {
/* 48 */     int color = 0;
/* 49 */     color |= alpha << 24;
/* 50 */     color |= red << 16;
/* 51 */     color |= green << 8;
/* 52 */     color |= blue;
/* 53 */     return color;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\HanaBiColors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */