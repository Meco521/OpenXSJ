/*    */ package lynn.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.api.FontManager;
/*    */ import net.ccbluex.liquidbounce.ui.client.fonts.impl.SimpleFontManager;
/*    */ import net.ccbluex.liquidbounce.ui.client.newdropdown.SideGui.SideGui;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ 
/*    */ 
/*    */ public class ClientMain
/*    */ {
/*    */   private static ClientMain INSTANCE;
/*    */   
/*    */   public static ClientMain getInstance() {
/*    */     try {
/* 15 */       if (INSTANCE == null) INSTANCE = new ClientMain(); 
/* 16 */       return INSTANCE;
/* 17 */     } catch (Throwable t) {
/* 18 */       ClientUtils.getLogger().warn(t);
/* 19 */       throw t;
/*    */     } 
/*    */   }
/*    */   
/* 23 */   public FontManager fontManager = SimpleFontManager.create();
/*    */   public FontManager getFontManager() {
/* 25 */     return this.fontManager;
/*    */   }
/*    */   
/* 28 */   private final SideGui sideGui = new SideGui();
/*    */   
/*    */   public SideGui getSideGui() {
/* 31 */     return this.sideGui;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\ClientMain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */