/*     */ package net.ccbluex.liquidbounce.ui.client.altmanager.sub;
/*     */ 
/*     */ import com.mojang.authlib.Agent;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*     */ import com.thealtening.AltService;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.io.IOException;
/*     */ import java.net.Proxy;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.file.FileConfig;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.TabUtils;
/*     */ import net.ccbluex.liquidbounce.utils.login.MinecraftAccount;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiAdd
/*     */   extends WrappedGuiScreen
/*     */ {
/*     */   private final GuiAltManager prevGui;
/*     */   private IGuiButton addButton;
/*     */   private IGuiButton clipboardButton;
/*     */   private IGuiTextField username;
/*     */   private IGuiTextField password;
/*  35 */   private String status = "§7Idle...";
/*     */   
/*     */   public GuiAdd(GuiAltManager gui) {
/*  38 */     this.prevGui = gui;
/*     */   }
/*     */   
/*     */   public void initGui() {
/*  42 */     Keyboard.enableRepeatEvents(true);
/*  43 */     this.representedScreen.getButtonList().add(this.addButton = classProvider.createGuiButton(1, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 72, "Add"));
/*  44 */     this.representedScreen.getButtonList().add(this.clipboardButton = classProvider.createGuiButton(2, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 96, "Clipboard"));
/*  45 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(0, this.representedScreen.getWidth() / 2 - 100, this.representedScreen.getHeight() / 4 + 120, "Back"));
/*  46 */     this.username = classProvider.createGuiTextField(2, Fonts.roboto40, this.representedScreen.getWidth() / 2 - 100, 60, 200, 20);
/*  47 */     this.username.setFocused(true);
/*  48 */     this.username.setMaxStringLength(2147483647);
/*  49 */     this.password = classProvider.createGuiPasswordField(3, Fonts.roboto40, this.representedScreen.getWidth() / 2 - 100, 85, 200, 20);
/*  50 */     this.password.setMaxStringLength(2147483647);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  55 */     this.representedScreen.drawBackground(0);
/*  56 */     RenderUtils.drawRect(30, 30, this.representedScreen.getWidth() - 30, this.representedScreen.getHeight() - 30, -2147483648);
/*     */     
/*  58 */     Fonts.roboto40.drawCenteredString("Add Account", this.representedScreen.getWidth() / 2.0F, 34.0F, 16777215);
/*  59 */     Fonts.roboto35.drawCenteredString((this.status == null) ? "" : this.status, this.representedScreen.getWidth() / 2.0F, this.representedScreen.getHeight() / 4.0F + 60.0F, 16777215);
/*     */     
/*  61 */     this.username.drawTextBox();
/*  62 */     this.password.drawTextBox();
/*     */     
/*  64 */     if (this.username.getText().isEmpty() && !this.username.isFocused()) {
/*  65 */       Fonts.roboto40.drawCenteredString("§7Username / E-Mail", (this.representedScreen.getWidth() / 2 - 55), 66.0F, 16777215);
/*     */     }
/*  67 */     if (this.password.getText().isEmpty() && !this.password.isFocused())
/*  68 */       Fonts.roboto40.drawCenteredString("§7Password", (this.representedScreen.getWidth() / 2 - 74), 91.0F, 16777215); 
/*  69 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(IGuiButton button) throws IOException {
/*  74 */     if (!button.getEnabled()) {
/*     */       return;
/*     */     }
/*  77 */     switch (button.getId()) {
/*     */       case 0:
/*  79 */         mc.displayGuiScreen(this.prevGui.representedScreen);
/*     */         break;
/*     */       case 1:
/*  82 */         if (Retreat.fileManager.accountsConfig.accountExists(this.username.getText())) {
/*  83 */           this.status = "§cThe account has already been added.";
/*     */           
/*     */           break;
/*     */         } 
/*  87 */         addAccount(this.username.getText(), this.password.getText());
/*     */         break;
/*     */       
/*     */       case 2:
/*     */         try {
/*  92 */           String clipboardData = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
/*  93 */           String[] accountData = clipboardData.split(":", 2);
/*     */           
/*  95 */           if (!clipboardData.contains(":") || accountData.length != 2) {
/*  96 */             this.status = "§cInvalid clipboard data. (Use: E-Mail:Password)";
/*     */             
/*     */             return;
/*     */           } 
/* 100 */           addAccount(accountData[0], accountData[1]);
/* 101 */         } catch (UnsupportedFlavorException e) {
/* 102 */           this.status = "§cClipboard flavor unsupported!";
/* 103 */           ClientUtils.getLogger().error("Failed to read data from clipboard.", e);
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/* 111 */     switch (keyCode) {
/*     */       case 1:
/* 113 */         mc.displayGuiScreen(this.prevGui.representedScreen);
/*     */         return;
/*     */       case 15:
/* 116 */         TabUtils.tab(new IGuiTextField[] { this.username, this.password });
/*     */         return;
/*     */       case 28:
/* 119 */         actionPerformed(this.addButton);
/*     */         return;
/*     */     } 
/*     */     
/* 123 */     if (this.username.isFocused()) {
/* 124 */       this.username.textboxKeyTyped(typedChar, keyCode);
/*     */     }
/* 126 */     if (this.password.isFocused())
/* 127 */       this.password.textboxKeyTyped(typedChar, keyCode); 
/* 128 */     super.keyTyped(typedChar, keyCode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 133 */     this.username.mouseClicked(mouseX, mouseY, mouseButton);
/* 134 */     this.password.mouseClicked(mouseX, mouseY, mouseButton);
/* 135 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 140 */     this.username.updateCursorCounter();
/* 141 */     this.password.updateCursorCounter();
/*     */     
/* 143 */     super.updateScreen();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 148 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */   
/*     */   private void addAccount(String name, String password) {
/* 152 */     if (Retreat.fileManager.accountsConfig.accountExists(name)) {
/* 153 */       this.status = "§cThe account has already been added.";
/*     */       
/*     */       return;
/*     */     } 
/* 157 */     this.addButton.setEnabled(false);
/* 158 */     this.clipboardButton.setEnabled(false);
/*     */     
/* 160 */     MinecraftAccount account = new MinecraftAccount(name, password);
/*     */     
/* 162 */     (new Thread(() -> {
/*     */           if (!account.isCracked()) {
/*     */             this.status = "§aChecking...";
/*     */             
/*     */             try {
/*     */               AltService.EnumAltService oldService = GuiAltManager.altService.getCurrentService();
/*     */               
/*     */               if (oldService != AltService.EnumAltService.MOJANG) {
/*     */                 GuiAltManager.altService.switchService(AltService.EnumAltService.MOJANG);
/*     */               }
/*     */               
/*     */               YggdrasilUserAuthentication userAuthentication = (YggdrasilUserAuthentication)(new YggdrasilAuthenticationService(Proxy.NO_PROXY, "")).createUserAuthentication(Agent.MINECRAFT);
/*     */               
/*     */               userAuthentication.setUsername(account.getName());
/*     */               
/*     */               userAuthentication.setPassword(account.getPassword());
/*     */               
/*     */               userAuthentication.logIn();
/*     */               
/*     */               account.setAccountName(userAuthentication.getSelectedProfile().getName());
/*     */               if (oldService == AltService.EnumAltService.THEALTENING) {
/*     */                 GuiAltManager.altService.switchService(AltService.EnumAltService.THEALTENING);
/*     */               }
/* 185 */             } catch (NullPointerException|com.mojang.authlib.exceptions.AuthenticationException|NoSuchFieldException|IllegalAccessException e) {
/*     */               this.status = "§cThe account doesn't work.";
/*     */               
/*     */               this.addButton.setEnabled(true);
/*     */               
/*     */               this.clipboardButton.setEnabled(true);
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           Retreat.fileManager.accountsConfig.getAccounts().add(account);
/*     */           Retreat.fileManager.saveConfig((FileConfig)Retreat.fileManager.accountsConfig);
/*     */           this.status = "§aThe account has been added.";
/*     */           this.prevGui.status = this.status;
/*     */           mc.displayGuiScreen(this.prevGui.representedScreen);
/* 200 */         })).start();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\altmanager\sub\GuiAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */