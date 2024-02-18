/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IServerData;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.ui.client.GuiMainMenu;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public final class ServerUtils
/*    */   extends MinecraftInstance
/*    */ {
/*    */   public static IServerData serverData;
/*    */   
/*    */   public static void connectToLastServer() {
/* 17 */     if (serverData == null) {
/*    */       return;
/*    */     }
/* 20 */     mc.displayGuiScreen(classProvider.createGuiConnecting(classProvider.createGuiMultiplayer(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiMainMenu())), mc, serverData));
/*    */   }
/*    */   public static boolean isHypixelDomain(String s1) {
/* 23 */     int chars = 0;
/* 24 */     String str = "www.hypixel.net";
/*    */     
/* 26 */     for (char c : str.toCharArray()) {
/* 27 */       if (s1.contains(String.valueOf(c))) chars++;
/*    */     
/*    */     } 
/* 30 */     return (chars == str.length());
/*    */   }
/*    */   public static String getRemoteIp() {
/* 33 */     String serverIp = "Singleplayer";
/*    */     
/* 35 */     if (mc.getTheWorld() != null && 
/* 36 */       mc.getTheWorld().isRemote()) {
/* 37 */       IServerData serverData = mc.getCurrentServerData();
/*    */       
/* 39 */       if (serverData != null) {
/* 40 */         serverIp = serverData.getServerIP();
/*    */       }
/*    */     } 
/*    */     
/* 44 */     return serverIp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\ServerUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */