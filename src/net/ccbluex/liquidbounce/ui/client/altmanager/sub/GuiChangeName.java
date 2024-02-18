/*     */ package net.ccbluex.liquidbounce.ui.client.altmanager.sub;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.SessionEvent;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ public class GuiChangeName
/*     */   extends WrappedGuiScreen {
/*     */   private final GuiAltManager prevGui;
/*     */   private IGuiTextField name;
/*     */   private String status;
/*     */   
/*     */   public GuiChangeName(GuiAltManager gui) {
/*  22 */     this.prevGui = gui;
/*     */   }
/*     */   
/*     */   public void initGui() {
/*  26 */     Keyboard.enableRepeatEvents(true);
/*  27 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(1, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 96, "Change"));
/*  28 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(0, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 120, "Back"));
/*     */     
/*  30 */     this.name = classProvider.createGuiTextField(2, Fonts.roboto40, this.representedScreen.getWidth() / 2 - 100, 60, 200, 20);
/*  31 */     this.name.setFocused(true);
/*  32 */     this.name.setText(mc.getSession().getUsername());
/*  33 */     this.name.setMaxStringLength(16);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  38 */     this.representedScreen.drawBackground(0);
/*  39 */     RenderUtils.drawRect(30, 30, this.representedScreen.getWidth() - 30, this.representedScreen.getHeight() - 30, -2147483648);
/*     */     
/*  41 */     Fonts.roboto40.drawCenteredString("Change Name", this.representedScreen.getWidth() / 2.0F, 34.0F, 16777215);
/*  42 */     Fonts.roboto40.drawCenteredString((this.status == null) ? "" : this.status, this.representedScreen.getWidth() / 2.0F, this.representedScreen.getHeight() / 4.0F + 84.0F, 16777215);
/*  43 */     this.name.drawTextBox();
/*     */     
/*  45 */     if (this.name.getText().isEmpty() && !this.name.isFocused()) {
/*  46 */       Fonts.roboto40.drawCenteredString("§7Username", this.representedScreen.getWidth() / 2.0F - 74.0F, 66.0F, 16777215);
/*     */     }
/*  48 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(IGuiButton button) throws IOException {
/*  53 */     switch (button.getId()) {
/*     */       case 0:
/*  55 */         mc.displayGuiScreen(this.prevGui.representedScreen);
/*     */         break;
/*     */       case 1:
/*  58 */         if (this.name.getText().isEmpty()) {
/*  59 */           this.status = "§cEnter a name!";
/*     */           
/*     */           return;
/*     */         } 
/*  63 */         if (!this.name.getText().equalsIgnoreCase(mc.getSession().getUsername())) {
/*  64 */           this.status = "§cJust change the upper and lower case!";
/*     */           
/*     */           return;
/*     */         } 
/*  68 */         mc.setSession(classProvider.createSession(this.name.getText(), mc.getSession().getPlayerId(), mc.getSession().getToken(), mc.getSession().getSessionType()));
/*  69 */         Retreat.eventManager.callEvent((Event)new SessionEvent());
/*  70 */         this.status = "§aChanged name to §7" + this.name.getText() + "§c.";
/*  71 */         this.prevGui.status = this.status;
/*  72 */         mc.displayGuiScreen(this.prevGui.representedScreen);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/*  79 */     if (1 == keyCode) {
/*  80 */       mc.displayGuiScreen(this.prevGui.getRepresentedScreen());
/*     */       
/*     */       return;
/*     */     } 
/*  84 */     if (this.name.isFocused())
/*  85 */       this.name.textboxKeyTyped(typedChar, keyCode); 
/*  86 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/*  91 */     this.name.mouseClicked(mouseX, mouseY, mouseButton);
/*  92 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/*  97 */     this.name.updateCursorCounter();
/*  98 */     super.updateScreen();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 103 */     Keyboard.enableRepeatEvents(false);
/* 104 */     super.onGuiClosed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\altmanager\sub\GuiChangeName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */