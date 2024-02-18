/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*    */ 
/*    */ public final class TabUtils
/*    */ {
/*    */   public static void tab(IGuiTextField... textFields) {
/*  8 */     for (int i = 0; i < textFields.length; i++) {
/*  9 */       IGuiTextField textField = textFields[i];
/*    */       
/* 11 */       if (textField.isFocused()) {
/* 12 */         textField.setFocused(false);
/* 13 */         i++;
/*    */         
/* 15 */         if (i >= textFields.length) {
/* 16 */           i = 0;
/*    */         }
/* 18 */         textFields[i].setFocused(true);
/*    */         break;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\TabUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */