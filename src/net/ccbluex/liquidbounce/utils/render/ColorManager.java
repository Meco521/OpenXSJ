/*    */ package net.ccbluex.liquidbounce.utils.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import kotlin.jvm.JvmStatic;
/*    */ 
/*    */ 
/*    */ public class ColorManager
/*    */ {
/*    */   @JvmStatic
/*    */   public static int Astolfo(int i) {
/* 11 */     double v1 = Math.ceil((System.currentTimeMillis() + (i * 109))) / 5.0D;
/*    */     
/* 13 */     return Color.getHSBColor(((float)((v1 %= 360.0D) / 360.0D) < 0.5D) ? -((float)(v1 / 360.0D)) : (float)(v1 / 360.0D), 0.5F, 1.0F).getRGB();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\render\ColorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */