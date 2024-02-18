/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.SideGui.SideGui;
/*    */ import tomk.fonts.api.FontManager;
/*    */ import tomk.fonts.impl.SimpleFontManager;
/*    */ 
/*    */ public class ClientMain
/*    */ {
/*    */   private static ClientMain INSTANCE;
/*    */   
/*    */   public static ClientMain getInstance() {
/*    */     try {
/* 13 */       if (INSTANCE == null) INSTANCE = new ClientMain(); 
/* 14 */       return INSTANCE;
/* 15 */     } catch (Throwable t) {
/* 16 */       ClientUtils.getLogger().warn(t);
/* 17 */       throw t;
/*    */     } 
/*    */   }
/*    */   
/* 21 */   public FontManager fontManager = SimpleFontManager.create();
/*    */   public FontManager getFontManager() {
/* 23 */     return this.fontManager;
/*    */   }
/*    */   
/* 26 */   private final SideGui sideGui = new SideGui();
/*    */   
/*    */   public SideGui getSideGui() {
/* 29 */     return this.sideGui;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\ClientMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */