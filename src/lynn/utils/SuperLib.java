/*    */ package lynn.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class SuperLib {
/*    */   public static String removeColorCode(String text) {
/*  7 */     String finalText = text;
/*  8 */     if (text.contains("§")) {
/*  9 */       for (int i = 0; i < finalText.length(); i++) {
/* 10 */         if (Character.toString(finalText.charAt(i)).equals("§")) {
/*    */           try {
/* 12 */             String part1 = finalText.substring(0, i);
/* 13 */             String part2 = finalText.substring(Math.min(i + 2, finalText.length()));
/* 14 */             finalText = part1 + part2;
/* 15 */           } catch (Exception exception) {}
/*    */         }
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/* 21 */     return finalText;
/*    */   }
/*    */   
/*    */   public static int reAlpha(int color, float alpha) {
/* 25 */     Color c = new Color(color);
/* 26 */     float r = 0.003921569F * c.getRed();
/* 27 */     float g = 0.003921569F * c.getGreen();
/* 28 */     float b = 0.003921569F * c.getBlue();
/* 29 */     return (new Color(r, g, b, alpha)).getRGB();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\SuperLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */