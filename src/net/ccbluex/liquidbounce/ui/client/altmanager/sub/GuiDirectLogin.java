/*     */ package net.ccbluex.liquidbounce.ui.client.altmanager.sub;
/*     */ 
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.io.IOException;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.TabUtils;
/*     */ import net.ccbluex.liquidbounce.utils.login.MinecraftAccount;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiDirectLogin
/*     */   extends WrappedGuiScreen
/*     */ {
/*     */   private final IGuiScreen prevGui;
/*     */   private IGuiButton loginButton;
/*     */   private IGuiButton clipboardLoginButton;
/*     */   private IGuiTextField username;
/*     */   private IGuiTextField password;
/*  30 */   private String status = "§7Idle...";
/*     */   
/*     */   public GuiDirectLogin(GuiAltManager gui) {
/*  33 */     this.prevGui = gui.representedScreen;
/*     */   }
/*     */   
/*     */   public void initGui() {
/*  37 */     Keyboard.enableRepeatEvents(true);
/*  38 */     getRepresentedScreen().getButtonList().add(this.loginButton = classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 72, "Login"));
/*  39 */     getRepresentedScreen().getButtonList().add(this.clipboardLoginButton = classProvider.createGuiButton(2, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 96, "Clipboard Login"));
/*  40 */     getRepresentedScreen().getButtonList().add(classProvider.createGuiButton(0, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 120, "Back"));
/*  41 */     this.username = classProvider.createGuiTextField(2, Fonts.roboto40, getRepresentedScreen().getWidth() / 2 - 100, 60, 200, 20);
/*  42 */     this.username.setFocused(true);
/*  43 */     this.username.setMaxStringLength(2147483647);
/*  44 */     this.password = classProvider.createGuiPasswordField(3, Fonts.roboto40, getRepresentedScreen().getWidth() / 2 - 100, 85, 200, 20);
/*  45 */     this.password.setMaxStringLength(2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  50 */     getRepresentedScreen().drawBackground(0);
/*  51 */     RenderUtils.drawRect(30, 30, getRepresentedScreen().getWidth() - 30, getRepresentedScreen().getHeight() - 30, -2147483648);
/*     */     
/*  53 */     Fonts.roboto40.drawCenteredString("Direct Login", getRepresentedScreen().getWidth() / 2.0F, 34.0F, 16777215);
/*  54 */     Fonts.roboto35.drawCenteredString((this.status == null) ? "" : this.status, getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 4.0F + 60.0F, 16777215);
/*     */     
/*  56 */     this.username.drawTextBox();
/*  57 */     this.password.drawTextBox();
/*     */     
/*  59 */     if (this.username.getText().isEmpty() && !this.username.isFocused()) {
/*  60 */       Fonts.roboto40.drawCenteredString("§7Username / E-Mail", getRepresentedScreen().getWidth() / 2.0F - 55.0F, 66.0F, 16777215);
/*     */     }
/*  62 */     if (this.password.getText().isEmpty() && !this.password.isFocused())
/*  63 */       Fonts.roboto40.drawCenteredString("§7Password", getRepresentedScreen().getWidth() / 2.0F - 74.0F, 91.0F, 16777215); 
/*  64 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(IGuiButton button) throws IOException {
/*  69 */     if (!button.getEnabled())
/*     */       return; 
/*  71 */     switch (button.getId()) {
/*     */       case 0:
/*  73 */         mc.displayGuiScreen(this.prevGui);
/*     */         break;
/*     */       case 1:
/*  76 */         if (this.username.getText().isEmpty()) {
/*  77 */           this.status = "§cYou have to fill in both fields!";
/*     */           
/*     */           return;
/*     */         } 
/*  81 */         this.loginButton.setEnabled(false);
/*  82 */         this.clipboardLoginButton.setEnabled(false);
/*     */         
/*  84 */         (new Thread(() -> {
/*     */               this.status = "§aLogging in...";
/*     */               
/*     */               if (this.password.getText().isEmpty()) {
/*     */                 this.status = GuiAltManager.login(new MinecraftAccount(ColorUtils.translateAlternateColorCodes(this.username.getText())));
/*     */               } else {
/*     */                 this.status = GuiAltManager.login(new MinecraftAccount(this.username.getText(), this.password.getText()));
/*     */               } 
/*     */               this.loginButton.setEnabled(true);
/*     */               this.clipboardLoginButton.setEnabled(true);
/*  94 */             })).start();
/*     */         break;
/*     */       case 2:
/*     */         try {
/*  98 */           String clipboardData = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
/*  99 */           String[] args = clipboardData.split(":", 2);
/*     */           
/* 101 */           if (!clipboardData.contains(":") || args.length != 2) {
/* 102 */             this.status = "§cInvalid clipboard data. (Use: E-Mail:Password)";
/*     */             
/*     */             return;
/*     */           } 
/* 106 */           this.loginButton.setEnabled(false);
/* 107 */           this.clipboardLoginButton.setEnabled(false);
/*     */           
/* 109 */           (new Thread(() -> {
/*     */                 this.status = "§aLogging in...";
/*     */                 
/*     */                 this.status = GuiAltManager.login(new MinecraftAccount(args[0], args[1]));
/*     */                 
/*     */                 this.loginButton.setEnabled(true);
/*     */                 this.clipboardLoginButton.setEnabled(true);
/* 116 */               })).start();
/* 117 */         } catch (UnsupportedFlavorException e) {
/* 118 */           this.status = "§cClipboard flavor unsupported!";
/* 119 */           ClientUtils.getLogger().error("Failed to read data from clipboard.", e);
/* 120 */         } catch (IOException e) {
/* 121 */           this.status = "§cUnknown error! (See log)";
/* 122 */           ClientUtils.getLogger().error(e);
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/* 131 */     switch (keyCode) {
/*     */       case 1:
/* 133 */         mc.displayGuiScreen(this.prevGui);
/*     */         return;
/*     */       case 15:
/* 136 */         TabUtils.tab(new IGuiTextField[] { this.username, this.password });
/*     */         return;
/*     */       case 28:
/* 139 */         actionPerformed(this.loginButton);
/*     */         return;
/*     */     } 
/*     */     
/* 143 */     if (this.username.isFocused()) {
/* 144 */       this.username.textboxKeyTyped(typedChar, keyCode);
/*     */     }
/* 146 */     if (this.password.isFocused())
/* 147 */       this.password.textboxKeyTyped(typedChar, keyCode); 
/* 148 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 153 */     this.username.mouseClicked(mouseX, mouseY, mouseButton);
/* 154 */     this.password.mouseClicked(mouseX, mouseY, mouseButton);
/* 155 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 160 */     this.username.updateCursorCounter();
/* 161 */     this.password.updateCursorCounter();
/* 162 */     super.updateScreen();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 167 */     Keyboard.enableRepeatEvents(false);
/* 168 */     super.onGuiClosed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\altmanager\sub\GuiDirectLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */