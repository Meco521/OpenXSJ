/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*    */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*    */ import net.ccbluex.liquidbounce.features.special.AntiForge;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiAntiForge
/*    */   extends WrappedGuiScreen
/*    */ {
/*    */   private final IGuiScreen prevGui;
/*    */   private IGuiButton enabledButton;
/*    */   private IGuiButton fmlButton;
/*    */   private IGuiButton proxyButton;
/*    */   private IGuiButton payloadButton;
/*    */   
/*    */   public GuiAntiForge(IGuiScreen prevGui) {
/* 23 */     this.prevGui = prevGui;
/*    */   }
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 28 */     this.representedScreen.getButtonList().add(this.enabledButton = classProvider.createGuiButton(1, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 35, "Enabled (" + (AntiForge.enabled ? "On" : "Off") + ")"));
/* 29 */     this.representedScreen.getButtonList().add(this.fmlButton = classProvider.createGuiButton(2, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 50 + 25, "Block FML (" + (AntiForge.blockFML ? "On" : "Off") + ")"));
/* 30 */     this.representedScreen.getButtonList().add(this.proxyButton = classProvider.createGuiButton(3, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 50 + 50, "Block FML Proxy Packet (" + (AntiForge.blockProxyPacket ? "On" : "Off") + ")"));
/* 31 */     this.representedScreen.getButtonList().add(this.payloadButton = classProvider.createGuiButton(4, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 50 + 75, "Block Payload Packets (" + (AntiForge.blockPayloadPackets ? "On" : "Off") + ")"));
/*    */     
/* 33 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(0, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 55 + 100 + 5, "Back"));
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionPerformed(IGuiButton button) {
/* 38 */     switch (button.getId()) {
/*    */       case 1:
/* 40 */         AntiForge.enabled = !AntiForge.enabled;
/* 41 */         this.enabledButton.setDisplayString("Enabled (" + (AntiForge.enabled ? "On" : "Off") + ")");
/* 42 */         Retreat.fileManager.saveConfig(Retreat.fileManager.valuesConfig);
/*    */         break;
/*    */       case 2:
/* 45 */         AntiForge.blockFML = !AntiForge.blockFML;
/* 46 */         this.enabledButton.setDisplayString("Block FML (" + (AntiForge.blockFML ? "On" : "Off") + ")");
/* 47 */         Retreat.fileManager.saveConfig(Retreat.fileManager.valuesConfig);
/*    */         break;
/*    */       case 3:
/* 50 */         AntiForge.blockProxyPacket = !AntiForge.blockProxyPacket;
/* 51 */         this.enabledButton.setDisplayString("Block FML Proxy Packet (" + (AntiForge.blockProxyPacket ? "On" : "Off") + ")");
/* 52 */         Retreat.fileManager.saveConfig(Retreat.fileManager.valuesConfig);
/*    */         break;
/*    */       case 4:
/* 55 */         AntiForge.blockPayloadPackets = !AntiForge.blockPayloadPackets;
/* 56 */         this.enabledButton.setDisplayString("Block Payload Packets (" + (AntiForge.blockPayloadPackets ? "On" : "Off") + ")");
/* 57 */         Retreat.fileManager.saveConfig(Retreat.fileManager.valuesConfig);
/*    */         break;
/*    */       case 0:
/* 60 */         mc.displayGuiScreen(this.prevGui);
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 67 */     this.representedScreen.drawBackground(0);
/* 68 */     Fonts.robotoBold180.drawCenteredString("AntiForge", (int)(this.representedScreen.getWidth() / 2.0F), (int)(this.representedScreen.getHeight() / 8.0F + 5.0F), 4673984, true);
/*    */     
/* 70 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ 
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/* 75 */     if (1 == keyCode) {
/* 76 */       mc.displayGuiScreen(this.prevGui);
/*    */       
/*    */       return;
/*    */     } 
/* 80 */     super.keyTyped(typedChar, keyCode);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\GuiAntiForge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */