/*     */ package net.ccbluex.liquidbounce.ui.client.altmanager;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.thealtening.AltService;
/*     */ import java.awt.Color;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.datatransfer.StringSelection;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.file.FileConfig;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.sub.GuiAdd;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.sub.GuiChangeName;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.sub.altgenerator.GuiTheAltening;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.login.LoginUtils;
/*     */ import net.ccbluex.liquidbounce.utils.login.MinecraftAccount;
/*     */ import net.ccbluex.liquidbounce.utils.misc.HttpUtils;
/*     */ import net.ccbluex.liquidbounce.utils.misc.MiscUtils;
/*     */ 
/*     */ public class GuiAltManager extends WrappedGuiScreen {
/*  36 */   public static final AltService altService = new AltService();
/*  37 */   private static final Map<String, Boolean> GENERATORS = new HashMap<>();
/*     */   private IGuiScreen prevGui;
/*  39 */   public String status = "§7Idle...";
/*     */   private IGuiButton loginButton;
/*     */   private IGuiButton randomButton;
/*     */   private GuiList altsList;
/*     */   private IGuiTextField searchField;
/*     */   
/*     */   public GuiAltManager() {
/*  46 */     this.prevGui = this.prevGui;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadGenerators() {
/*     */     try {
/*  52 */       JsonElement jsonElement = (new JsonParser()).parse(HttpUtils.get("https://cloud.liquidbounce.net/LiquidBounce/generators.json"));
/*     */ 
/*     */       
/*  55 */       if (jsonElement.isJsonObject()) {
/*     */         
/*  57 */         JsonObject jsonObject = jsonElement.getAsJsonObject();
/*     */         
/*  59 */         jsonObject.entrySet().forEach(stringJsonElementEntry -> (Boolean)GENERATORS.put((String)stringJsonElementEntry.getKey(), Boolean.valueOf(((JsonElement)stringJsonElementEntry.getValue()).getAsBoolean())));
/*     */       } 
/*  61 */     } catch (Throwable throwable) {
/*     */       
/*  63 */       ClientUtils.getLogger().error("Failed to load enabled generators.", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String login(MinecraftAccount minecraftAccount) {
/*  68 */     if (minecraftAccount == null) {
/*  69 */       return "";
/*     */     }
/*  71 */     if (altService.getCurrentService() != AltService.EnumAltService.MOJANG) {
/*     */       try {
/*  73 */         altService.switchService(AltService.EnumAltService.MOJANG);
/*  74 */       } catch (NoSuchFieldException|IllegalAccessException e) {
/*  75 */         ClientUtils.getLogger().error("Something went wrong while trying to switch alt service.", e);
/*     */       } 
/*     */     }
/*     */     
/*  79 */     if (minecraftAccount.isCracked()) {
/*  80 */       LoginUtils.loginCracked(minecraftAccount.getName());
/*  81 */       return "§cYour name is now §8" + minecraftAccount.getName() + "§c.";
/*     */     } 
/*     */     
/*  84 */     LoginUtils.LoginResult result = LoginUtils.login(minecraftAccount.getName(), minecraftAccount.getPassword());
/*  85 */     if (result == LoginUtils.LoginResult.LOGGED) {
/*  86 */       String userName = mc.getSession().getUsername();
/*  87 */       minecraftAccount.setAccountName(userName);
/*  88 */       Retreat.fileManager.saveConfig((FileConfig)Retreat.fileManager.accountsConfig);
/*  89 */       return "§cYour name is now §f§l" + userName + "§c.";
/*     */     } 
/*     */     
/*  92 */     if (result == LoginUtils.LoginResult.WRONG_PASSWORD) {
/*  93 */       return "§cWrong password.";
/*     */     }
/*  95 */     if (result == LoginUtils.LoginResult.NO_CONTACT) {
/*  96 */       return "§cCannot contact authentication server.";
/*     */     }
/*  98 */     if (result == LoginUtils.LoginResult.INVALID_ACCOUNT_DATA) {
/*  99 */       return "§cInvalid username or password.";
/*     */     }
/* 101 */     if (result == LoginUtils.LoginResult.MIGRATED) {
/* 102 */       return "§cAccount migrated.";
/*     */     }
/* 104 */     return "";
/*     */   }
/*     */   
/*     */   public void initGui() {
/* 108 */     int textFieldWidth = Math.max(this.representedScreen.getWidth() / 8, 70);
/*     */     
/* 110 */     this.searchField = classProvider.createGuiTextField(2, Fonts.roboto40, this.representedScreen.getWidth() - textFieldWidth - 10, 10, textFieldWidth, 20);
/* 111 */     this.searchField.setMaxStringLength(2147483647);
/*     */     
/* 113 */     this.altsList = new GuiList(this.representedScreen);
/* 114 */     this.altsList.represented.registerScrollButtons(7, 8);
/*     */     
/* 116 */     int index = -1;
/*     */     
/* 118 */     for (int i = 0; i < Retreat.fileManager.accountsConfig.getAccounts().size(); i++) {
/* 119 */       MinecraftAccount minecraftAccount = Retreat.fileManager.accountsConfig.getAccounts().get(i);
/*     */       
/* 121 */       if (minecraftAccount != null && (((minecraftAccount.getPassword() == null || minecraftAccount.getPassword().isEmpty()) && minecraftAccount.getName() != null && minecraftAccount.getName().equals(mc.getSession().getUsername())) || (minecraftAccount.getAccountName() != null && minecraftAccount.getAccountName().equals(mc.getSession().getUsername())))) {
/* 122 */         index = i;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 127 */     this.altsList.elementClicked(index, false, 0, 0);
/* 128 */     this.altsList.represented.scrollBy(index * this.altsList.represented.getSlotHeight());
/*     */     
/* 130 */     int j = 22;
/* 131 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(1, this.representedScreen.getWidth() - 80, j + 24, 70, 20, "Add"));
/* 132 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(2, this.representedScreen.getWidth() - 80, j + 48, 70, 20, "Remove"));
/* 133 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(7, this.representedScreen.getWidth() - 80, j + 72, 70, 20, "Import"));
/* 134 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(12, this.representedScreen.getWidth() - 80, j + 96, 70, 20, "Export"));
/* 135 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(8, this.representedScreen.getWidth() - 80, j + 120, 70, 20, "Copy"));
/*     */     
/* 137 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(0, this.representedScreen.getWidth() - 80, this.representedScreen.getHeight() - 65, 70, 20, "Back"));
/*     */     
/* 139 */     this.representedScreen.getButtonList().add(this.loginButton = classProvider.createGuiButton(3, 5, j + 24, 90, 20, "Login"));
/* 140 */     this.representedScreen.getButtonList().add(this.randomButton = classProvider.createGuiButton(4, 5, j + 48, 90, 20, "Random"));
/* 141 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(6, 5, j + 72, 90, 20, "Direct Login"));
/* 142 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(88, 5, j + 96, 90, 20, "Change Name"));
/*     */     
/* 144 */     if (((Boolean)GENERATORS.getOrDefault("thealtening", Boolean.valueOf(true))).booleanValue())
/* 145 */       this.representedScreen.getButtonList().add(classProvider.createGuiButton(9, 5, j + 144 + 5, 90, 20, "TheAltening")); 
/* 146 */     this.representedScreen.getButtonList().add(classProvider.createGuiButton(11, 5, j + 192 + 10, 90, 20, "Cape"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 151 */     this.representedScreen.drawBackground(0);
/*     */     
/* 153 */     this.altsList.represented.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 155 */     Fonts.roboto40.drawCenteredString("AltManager", this.representedScreen.getWidth() / 2.0F, 6.0F, 16777215);
/* 156 */     Fonts.roboto35.drawCenteredString(this.searchField.getText().isEmpty() ? (Retreat.fileManager.accountsConfig.getAccounts().size() + " Alts") : (this.altsList.accounts.size() + " Search Results"), this.representedScreen.getWidth() / 2.0F, 18.0F, 16777215);
/* 157 */     Fonts.roboto35.drawCenteredString(this.status, this.representedScreen.getWidth() / 2.0F, 32.0F, 16777215);
/* 158 */     Fonts.roboto35.drawStringWithShadow("§7User: §a" + mc.getSession().getUsername(), 6, 6, 16777215);
/* 159 */     Fonts.roboto35.drawStringWithShadow("§7Type: §a" + ((altService.getCurrentService() == AltService.EnumAltService.THEALTENING) ? "TheAltening" : (UserUtils.INSTANCE.isValidTokenOffline(mc.getSession().getToken()) ? "Premium" : "Cracked")), 6, 15, 16777215);
/*     */     
/* 161 */     this.searchField.drawTextBox();
/*     */     
/* 163 */     if (this.searchField.getText().isEmpty() && !this.searchField.isFocused()) {
/* 164 */       Fonts.roboto40.drawStringWithShadow("§7Search...", this.searchField.getXPosition() + 4, 17, 16777215);
/*     */     }
/*     */     
/* 167 */     super.drawScreen(mouseX, mouseY, partialTicks); } public void actionPerformed(IGuiButton button) throws IOException { int randomInteger; Thread thread; File file;
/*     */     FileReader fileReader;
/*     */     BufferedReader bufferedReader;
/*     */     String line;
/*     */     File selectedFile;
/* 172 */     if (!button.getEnabled()) {
/*     */       return;
/*     */     }
/* 175 */     switch (button.getId()) {
/*     */       case 0:
/* 177 */         mc.displayGuiScreen(this.prevGui);
/*     */         break;
/*     */       case 1:
/* 180 */         mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiAdd(this)));
/*     */         break;
/*     */       case 2:
/* 183 */         if (this.altsList.getSelectedSlot() != -1 && this.altsList.getSelectedSlot() < this.altsList.getSize()) {
/* 184 */           Retreat.fileManager.accountsConfig.removeAccount(this.altsList.accounts.get(this.altsList.getSelectedSlot()));
/* 185 */           Retreat.fileManager.saveConfig((FileConfig)Retreat.fileManager.accountsConfig);
/* 186 */           this.status = "§aThe account has been removed.";
/*     */           
/* 188 */           this.altsList.updateAccounts(this.searchField.getText()); break;
/*     */         } 
/* 190 */         this.status = "§cSelect an account.";
/*     */         break;
/*     */       case 3:
/* 193 */         if (this.altsList.getSelectedSlot() != -1 && this.altsList.getSelectedSlot() < this.altsList.getSize()) {
/* 194 */           this.loginButton.setEnabled(false);
/* 195 */           this.randomButton.setEnabled(false);
/*     */           
/* 197 */           Thread thread1 = new Thread(() -> { MinecraftAccount minecraftAccount = this.altsList.accounts.get(this.altsList.getSelectedSlot()); this.status = "§aLogging in..."; this.status = login(minecraftAccount); this.loginButton.setEnabled(true); this.randomButton.setEnabled(true); }"AltLogin");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 205 */           thread1.start(); break;
/*     */         } 
/* 207 */         this.status = "§cSelect an account.";
/*     */         break;
/*     */       case 4:
/* 210 */         if (this.altsList.accounts.size() <= 0) {
/* 211 */           this.status = "§cThe list is empty.";
/*     */           
/*     */           return;
/*     */         } 
/* 215 */         randomInteger = (new Random()).nextInt(this.altsList.accounts.size());
/*     */         
/* 217 */         if (randomInteger < this.altsList.getSize()) {
/* 218 */           this.altsList.selectedSlot = randomInteger;
/*     */         }
/* 220 */         this.loginButton.setEnabled(false);
/* 221 */         this.randomButton.setEnabled(false);
/*     */         
/* 223 */         thread = new Thread(() -> { MinecraftAccount minecraftAccount = this.altsList.accounts.get(randomInteger); this.status = "§aLogging in..."; this.status = login(minecraftAccount); this.loginButton.setEnabled(true); this.randomButton.setEnabled(true); }"AltLogin");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 231 */         thread.start();
/*     */         break;
/*     */       case 6:
/* 234 */         mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiDirectLogin(this)));
/*     */         break;
/*     */       case 7:
/* 237 */         file = MiscUtils.openFileChooser();
/*     */         
/* 239 */         if (file == null) {
/*     */           return;
/*     */         }
/* 242 */         fileReader = new FileReader(file);
/* 243 */         bufferedReader = new BufferedReader(fileReader);
/*     */ 
/*     */         
/* 246 */         while ((line = bufferedReader.readLine()) != null) {
/* 247 */           String[] accountData = line.split(":", 2);
/*     */           
/* 249 */           if (!Retreat.fileManager.accountsConfig.accountExists(accountData[0])) {
/* 250 */             if (accountData.length > 1) {
/* 251 */               Retreat.fileManager.accountsConfig.addAccount(accountData[0], accountData[1]); continue;
/*     */             } 
/* 253 */             Retreat.fileManager.accountsConfig.addAccount(accountData[0]);
/*     */           } 
/*     */         } 
/*     */         
/* 257 */         fileReader.close();
/* 258 */         bufferedReader.close();
/*     */         
/* 260 */         this.altsList.updateAccounts(this.searchField.getText());
/* 261 */         Retreat.fileManager.saveConfig((FileConfig)Retreat.fileManager.accountsConfig);
/* 262 */         this.status = "§aThe accounts were imported successfully.";
/*     */         break;
/*     */       case 8:
/* 265 */         if (this.altsList.getSelectedSlot() != -1 && this.altsList.getSelectedSlot() < this.altsList.getSize()) {
/* 266 */           MinecraftAccount minecraftAccount = this.altsList.accounts.get(this.altsList.getSelectedSlot());
/*     */           
/* 268 */           if (minecraftAccount == null) {
/*     */             break;
/*     */           }
/* 271 */           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(minecraftAccount.getName() + ":" + minecraftAccount.getPassword()), null);
/* 272 */           this.status = "§aCopied account into your clipboard."; break;
/*     */         } 
/* 274 */         this.status = "§cSelect an account.";
/*     */         break;
/*     */       case 88:
/* 277 */         mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiChangeName(this)));
/*     */         break;
/*     */       case 9:
/* 280 */         mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiTheAltening(this)));
/*     */         break;
/*     */       case 11:
/* 283 */         mc.displayGuiScreen(classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiDonatorCape(this)));
/*     */         break;
/*     */       case 12:
/* 286 */         if (Retreat.fileManager.accountsConfig.getAccounts().size() == 0) {
/* 287 */           this.status = "§cThe list is empty.";
/*     */           
/*     */           return;
/*     */         } 
/* 291 */         selectedFile = MiscUtils.saveFileChooser();
/*     */         
/* 293 */         if (selectedFile == null || selectedFile.isDirectory()) {
/*     */           return;
/*     */         }
/*     */         try {
/* 297 */           if (!selectedFile.exists()) {
/* 298 */             selectedFile.createNewFile();
/*     */           }
/* 300 */           FileWriter fileWriter = new FileWriter(selectedFile);
/*     */           
/* 302 */           for (MinecraftAccount account : Retreat.fileManager.accountsConfig.getAccounts()) {
/* 303 */             if (account.isCracked()) {
/* 304 */               fileWriter.write(account.getName() + "\r\n"); continue;
/*     */             } 
/* 306 */             fileWriter.write(account.getName() + ":" + account.getPassword() + "\r\n");
/*     */           } 
/*     */ 
/*     */           
/* 310 */           fileWriter.flush();
/* 311 */           fileWriter.close();
/* 312 */           JOptionPane.showMessageDialog(null, "Exported successfully!", "AltManager", 1);
/* 313 */         } catch (Exception e) {
/* 314 */           e.printStackTrace();
/* 315 */           MiscUtils.showErrorPopup("Error", "Exception class: " + e.getClass().getName() + "\nMessage: " + e.getMessage());
/*     */         } 
/*     */         break;
/*     */     }  }
/*     */ 
/*     */   
/*     */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/*     */     int i;
/* 323 */     if (this.searchField.isFocused()) {
/* 324 */       this.searchField.textboxKeyTyped(typedChar, keyCode);
/* 325 */       this.altsList.updateAccounts(this.searchField.getText());
/*     */     } 
/*     */     
/* 328 */     switch (keyCode) {
/*     */       case 1:
/* 330 */         mc.displayGuiScreen(this.prevGui);
/*     */         return;
/*     */       case 200:
/* 333 */         i = this.altsList.getSelectedSlot() - 1;
/* 334 */         if (i < 0)
/* 335 */           i = 0; 
/* 336 */         this.altsList.elementClicked(i, false, 0, 0);
/*     */         break;
/*     */       
/*     */       case 208:
/* 340 */         i = this.altsList.getSelectedSlot() + 1;
/* 341 */         if (i >= this.altsList.getSize())
/* 342 */           i = this.altsList.getSize() - 1; 
/* 343 */         this.altsList.elementClicked(i, false, 0, 0);
/*     */         break;
/*     */       
/*     */       case 28:
/* 347 */         this.altsList.elementClicked(this.altsList.getSelectedSlot(), true, 0, 0);
/*     */         break;
/*     */       
/*     */       case 209:
/* 351 */         this.altsList.represented.scrollBy(this.representedScreen.getHeight() - 100);
/*     */         break;
/*     */       
/*     */       case 201:
/* 355 */         this.altsList.represented.scrollBy(-this.representedScreen.getHeight() + 100);
/*     */         return;
/*     */     } 
/*     */ 
/*     */     
/* 360 */     this.representedScreen.superKeyTyped(typedChar, keyCode);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleMouseInput() throws IOException {
/* 365 */     this.representedScreen.superHandleMouseInput();
/*     */     
/* 367 */     this.altsList.represented.handleMouseInput();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 372 */     this.searchField.mouseClicked(mouseX, mouseY, mouseButton);
/*     */     
/* 374 */     this.representedScreen.superMouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 379 */     this.searchField.updateCursorCounter();
/*     */   }
/*     */   
/*     */   private class GuiList extends WrappedGuiSlot {
/*     */     private List<MinecraftAccount> accounts;
/*     */     private int selectedSlot;
/*     */     
/*     */     GuiList(IGuiScreen prevGui) {
/* 387 */       super(MinecraftInstance.mc, prevGui.getWidth(), prevGui.getHeight(), 40, prevGui.getHeight() - 40, 30);
/*     */       
/* 389 */       updateAccounts(null);
/*     */     }
/*     */     
/*     */     private void updateAccounts(String search) {
/* 393 */       if (search == null || search.isEmpty()) {
/* 394 */         this.accounts = Retreat.fileManager.accountsConfig.getAccounts();
/*     */         
/*     */         return;
/*     */       } 
/* 398 */       search = search.toLowerCase();
/*     */       
/* 400 */       this.accounts = new ArrayList<>();
/*     */       
/* 402 */       for (MinecraftAccount account : Retreat.fileManager.accountsConfig.getAccounts()) {
/* 403 */         if ((account.getName() != null && account.getName().toLowerCase().contains(search)) || (account
/* 404 */           .getAccountName() != null && account.getAccountName().toLowerCase().contains(search))) {
/* 405 */           this.accounts.add(account);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSelected(int id) {
/* 413 */       return (this.selectedSlot == id);
/*     */     }
/*     */     
/*     */     int getSelectedSlot() {
/* 417 */       if (this.selectedSlot > this.accounts.size())
/* 418 */         this.selectedSlot = -1; 
/* 419 */       return this.selectedSlot;
/*     */     }
/*     */     
/*     */     public void setSelectedSlot(int selectedSlot) {
/* 423 */       this.selectedSlot = selectedSlot;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 428 */       return this.accounts.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void elementClicked(int var1, boolean doubleClick, int var3, int var4) {
/* 433 */       this.selectedSlot = var1;
/*     */       
/* 435 */       if (doubleClick) {
/* 436 */         if (GuiAltManager.this.altsList.getSelectedSlot() != -1 && GuiAltManager.this.altsList.getSelectedSlot() < GuiAltManager.this.altsList.getSize() && GuiAltManager.this.loginButton.getEnabled()) {
/* 437 */           GuiAltManager.this.loginButton.setEnabled(false);
/* 438 */           GuiAltManager.this.randomButton.setEnabled(false);
/*     */           
/* 440 */           (new Thread(() -> { MinecraftAccount minecraftAccount = this.accounts.get(GuiAltManager.this.altsList.getSelectedSlot()); GuiAltManager.this.status = "§aLogging in..."; GuiAltManager.this.status = "§c" + GuiAltManager.login(minecraftAccount); GuiAltManager.this.loginButton.setEnabled(true); GuiAltManager.this.randomButton.setEnabled(true); }"AltManagerLogin"))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 447 */             .start();
/*     */         } else {
/* 449 */           GuiAltManager.this.status = "§cSelect an account.";
/*     */         } 
/*     */       }
/*     */     }
/*     */     
/*     */     public void drawSlot(int id, int x, int y, int var4, int var5, int var6) {
/* 455 */       MinecraftAccount minecraftAccount = this.accounts.get(id);
/*     */       
/* 457 */       Fonts.roboto40.drawCenteredString((minecraftAccount.getAccountName() == null) ? minecraftAccount.getName() : minecraftAccount.getAccountName(), (GuiAltManager.this.representedScreen.getWidth() / 2), (y + 2), Color.WHITE.getRGB(), true);
/* 458 */       Fonts.roboto40.drawCenteredString(minecraftAccount.isCracked() ? "Cracked" : ((minecraftAccount.getAccountName() == null) ? "Premium" : minecraftAccount.getName()), (GuiAltManager.this.representedScreen.getWidth() / 2), (y + 15), minecraftAccount.isCracked() ? Color.GRAY.getRGB() : ((minecraftAccount.getAccountName() == null) ? Color.GREEN.getRGB() : Color.LIGHT_GRAY.getRGB()), true);
/*     */     }
/*     */     
/*     */     public void drawBackground() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\altmanager\GuiAltManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */