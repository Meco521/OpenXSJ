/*     */ package net.ccbluex.liquidbounce.ui.client.altmanager.sub.altgenerator;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*     */ import com.thealtening.api.TheAltening;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000H\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\007\030\000 \0372\0020\001:\001\037B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\r\032\0020\0162\006\020\017\032\0020\bH\026J \020\020\032\0020\0162\006\020\021\032\0020\0222\006\020\023\032\0020\0222\006\020\024\032\0020\025H\026J\b\020\026\032\0020\016H\026J\030\020\027\032\0020\0162\006\020\030\032\0020\0312\006\020\032\032\0020\022H\026J \020\033\032\0020\0162\006\020\021\032\0020\0222\006\020\023\032\0020\0222\006\020\034\032\0020\022H\026J\b\020\035\032\0020\016H\026J\b\020\036\032\0020\016H\026R\016\020\005\032\0020\006X.¢\006\002\n\000R\016\020\007\032\0020\bX.¢\006\002\n\000R\016\020\t\032\0020\bX.¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\006X.¢\006\002\n\000¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/altmanager/sub/altgenerator/GuiTheAltening;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;", "(Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;)V", "apiKeyField", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiTextField;", "generateButton", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "loginButton", "status", "", "tokenField", "actionPerformed", "", "button", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseButton", "onGuiClosed", "updateScreen", "Companion", "XSJClient"})
/*     */ public final class GuiTheAltening extends WrappedGuiScreen {
/*     */   private IGuiButton loginButton;
/*     */   private IGuiButton generateButton;
/*     */   private IGuiTextField apiKeyField;
/*     */   private IGuiTextField tokenField;
/*     */   private String status;
/*     */   private final GuiAltManager prevGui;
/*     */   @NotNull
/*     */   private static String apiKey;
/*     */   
/*     */   public GuiTheAltening(@NotNull GuiAltManager prevGui) {
/*  22 */     this.prevGui = prevGui;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     this.status = "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "account", "Lcom/thealtening/api/data/AccountData;", "kotlin.jvm.PlatformType", "accept"})
/*     */   static final class GuiTheAltening$actionPerformed$1<T>
/*     */     implements Consumer<AccountData>
/*     */   {
/*     */     public final void accept(AccountData account) {
/* 142 */       Intrinsics.checkExpressionValueIsNotNull(account, "account"); GuiTheAltening.this.status = "§aGenerated account: §b§l" + account.getUsername();
/*     */       try {
/*     */         String str;
/* 145 */         GuiTheAltening.this.status = "§cSwitching Alt Service...";
/*     */ 
/*     */         
/* 148 */         GuiAltManager.altService.switchService(AltService.EnumAltService.THEALTENING);
/*     */         
/* 150 */         GuiTheAltening.this.status = "§cLogging in...";
/*     */ 
/*     */         
/* 153 */         YggdrasilUserAuthentication yggdrasilUserAuthentication = 
/* 154 */           new YggdrasilUserAuthentication(new YggdrasilAuthenticationService(Proxy.NO_PROXY, ""), Agent.MINECRAFT);
/* 155 */         yggdrasilUserAuthentication.setUsername(account.getToken());
/* 156 */         yggdrasilUserAuthentication.setPassword("XSJ Client");
/*     */         
/* 158 */         GuiTheAltening guiTheAltening = GuiTheAltening.this; try {
/* 159 */           yggdrasilUserAuthentication.logIn();
/*     */ 
/*     */           
/* 162 */           Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthentication.selectedProfile"); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile().getName(), "yggdrasilUserAuthentication.selectedProfile.name"); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthenticat…         .selectedProfile");
/* 163 */           Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), "yggdrasilUserAuthenticat…ctedProfile.id.toString()");
/* 164 */           Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getAuthenticatedToken(), "yggdrasilUserAuthentication.authenticatedToken"); MinecraftInstance.mc.setSession(MinecraftInstance.classProvider.createSession(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang"));
/*     */           
/* 166 */           Retreat.INSTANCE.getEventManager().callEvent((Event)new SessionEvent());
/*     */ 
/*     */           
/* 169 */           Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthentication.selectedProfile"); GuiTheAltening.this.prevGui.status = "§aYour name is now §b§l" + yggdrasilUserAuthentication.getSelectedProfile().getName() + "§c.";
/* 170 */           MinecraftInstance.mc.displayGuiScreen(GuiTheAltening.this.prevGui.getRepresentedScreen());
/* 171 */           str = "";
/* 172 */         } catch (AuthenticationException authenticationException) {
/* 173 */           GuiAltManager.altService.switchService(AltService.EnumAltService.MOJANG);
/*     */           
/* 175 */           ClientUtils.getLogger().error("Failed to login.", (Throwable)authenticationException);
/* 176 */           str = "§cFailed to login: " + authenticationException.getMessage();
/*     */         }  guiTheAltening.status = str;
/* 178 */       } catch (Throwable throwable) {
/* 179 */         GuiTheAltening.this.status = "§cFailed to login. Unknown error.";
/* 180 */         ClientUtils.getLogger().error("Failed to login.", throwable);
/*     */       } 
/*     */       
/* 183 */       GuiTheAltening.access$getLoginButton$p(GuiTheAltening.this).setEnabled(true);
/* 184 */       GuiTheAltening.access$getGenerateButton$p(GuiTheAltening.this).setEnabled(true);
/*     */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\003\n\000\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\016\020\005\032\n \004*\004\030\0010\0060\006H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "err", "", "apply"})
/* 186 */   static final class GuiTheAltening$actionPerformed$2<T, U, R> implements BiFunction<T, Throwable, U> { public final void apply(Void $noName_0, Throwable err) { GuiTheAltening.this.status = "§cFailed to generate account.";
/* 187 */       ClientUtils.getLogger().error("Failed to generate account.", err); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\022\n\000\n\002\020\002\n\002\b\003\n\002\020\003\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \003*\004\030\0010\0010\0012\016\020\004\032\n \003*\004\030\0010\0050\005H\n¢\006\004\b\006\020\007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "accept", "(Lkotlin/Unit;Ljava/lang/Throwable;)V"})
/* 189 */   static final class GuiTheAltening$actionPerformed$3<T, U> implements BiConsumer<Unit, Throwable> { public final void accept(Unit $noName_0, Throwable $noName_1) { GuiTheAltening.access$getLoginButton$p(GuiTheAltening.this).setEnabled(true);
/* 190 */       GuiTheAltening.access$getGenerateButton$p(GuiTheAltening.this).setEnabled(true); } } public static final Companion Companion = new Companion(null); static { apiKey = ""; }
/*     */   public void actionPerformed(@NotNull IGuiButton button) { TheAltening altening; TheAltening.Asynchronous asynchronous; Intrinsics.checkParameterIsNotNull(button, "button"); if (!button.getEnabled())
/*     */       return;  switch (button.getId()) { case 0: MinecraftInstance.mc.displayGuiScreen(this.prevGui.getRepresentedScreen()); break;case 1: if (this.loginButton == null)
/*     */           Intrinsics.throwUninitializedPropertyAccessException("loginButton");  this.loginButton.setEnabled(false); if (this.generateButton == null)
/*     */           Intrinsics.throwUninitializedPropertyAccessException("generateButton");  this.generateButton.setEnabled(false); if (this.apiKeyField == null)
/* 195 */           Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  apiKey = this.apiKeyField.getText(); altening = new TheAltening(apiKey); asynchronous = new TheAltening.Asynchronous(altening); this.status = "§cGenerating account..."; asynchronous.getAccountData().thenAccept(new GuiTheAltening$actionPerformed$1()).handle(new GuiTheAltening$actionPerformed$2<>()).whenComplete(new GuiTheAltening$actionPerformed$3<>()); break;case 2: if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  this.loginButton.setEnabled(false);
/* 196 */         if (this.generateButton == null) Intrinsics.throwUninitializedPropertyAccessException("generateButton");  this.generateButton.setEnabled(false);
/*     */         
/* 198 */         (new Thread(new GuiTheAltening$actionPerformed$4()))
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 239 */           .start();
/*     */         break;
/*     */       case 3:
/* 242 */         MiscUtils.showURL("https://thealtening.com/?ref=liquidbounce");
/*     */         break; }
/*     */      }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/altmanager/sub/altgenerator/GuiTheAltening$Companion;", "", "()V", "apiKey", "", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     public final void setApiKey(@NotNull String <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */       GuiTheAltening.apiKey = <set-?>; }
/*     */     @NotNull
/* 251 */     public final String getApiKey() { return GuiTheAltening.apiKey; } } public void keyTyped(char typedChar, int keyCode) { if (1 == keyCode) {
/*     */       
/* 253 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui.getRepresentedScreen());
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 258 */     if (this.apiKeyField == null) Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  if (this.apiKeyField.isFocused()) { if (this.apiKeyField == null) Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  this.apiKeyField.textboxKeyTyped(typedChar, keyCode); }
/* 259 */      if (this.tokenField == null) Intrinsics.throwUninitializedPropertyAccessException("tokenField");  if (this.tokenField.isFocused()) { if (this.tokenField == null) Intrinsics.throwUninitializedPropertyAccessException("tokenField");  this.tokenField.textboxKeyTyped(typedChar, keyCode); }
/* 260 */      super.keyTyped(typedChar, keyCode); }
/*     */   public void initGui() { Keyboard.enableRepeatEvents(true); this.loginButton = MinecraftInstance.classProvider.createGuiButton(2, getRepresentedScreen().getWidth() / 2 - 100, 75, "Login"); if (this.loginButton == null) Intrinsics.throwUninitializedPropertyAccessException("loginButton");  getRepresentedScreen().getButtonList().add(this.loginButton); this.generateButton = MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, 140, "Generate"); if (this.generateButton == null) Intrinsics.throwUninitializedPropertyAccessException("generateButton");  getRepresentedScreen().getButtonList().add(this.generateButton); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(3, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() - 54, 98, 20, "Buy")); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(0, getRepresentedScreen().getWidth() / 2 + 2, getRepresentedScreen().getHeight() - 54, 98, 20, "Back")); Intrinsics.checkExpressionValueIsNotNull(Fonts.roboto40, "Fonts.roboto40"); this.tokenField = MinecraftInstance.classProvider.createGuiTextField(666, Fonts.roboto40, getRepresentedScreen().getWidth() / 2 - 100, 50, 200, 20); if (this.tokenField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("tokenField");  this.tokenField.setFocused(true); if (this.tokenField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("tokenField");  this.tokenField.setMaxStringLength(2147483647); Intrinsics.checkExpressionValueIsNotNull(Fonts.roboto40, "Fonts.roboto40"); this.apiKeyField = MinecraftInstance.classProvider.createGuiPasswordField(1337, Fonts.roboto40, getRepresentedScreen().getWidth() / 2 - 100, 115, 200, 20); if (this.apiKeyField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  this.apiKeyField.setMaxStringLength(18); if (this.apiKeyField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  this.apiKeyField.setText(apiKey); super.initGui(); }
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) { getRepresentedScreen().drawBackground(0); RenderUtils.drawRect(30.0F, 30.0F, getRepresentedScreen().getWidth() - 30.0F, getRepresentedScreen().getHeight() - 30.0F, -2147483648); Fonts.roboto35.drawCenteredString("TheAltening", getRepresentedScreen().getWidth() / 2.0F, 6.0F, 16777215); Fonts.roboto35.drawCenteredString(this.status, getRepresentedScreen().getWidth() / 2.0F, 18.0F, 16777215); if (this.apiKeyField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  this.apiKeyField.drawTextBox(); if (this.tokenField == null)
/* 268 */       Intrinsics.throwUninitializedPropertyAccessException("tokenField");  this.tokenField.drawTextBox(); Fonts.roboto40.drawCenteredString("§7Token:", getRepresentedScreen().getWidth() / 2.0F - 84, 40.0F, 16777215); Fonts.roboto40.drawCenteredString("§7API-Key:", getRepresentedScreen().getWidth() / 2.0F - 78, 105.0F, 16777215); Fonts.roboto40.drawCenteredString("§7Use coupon code 'liquidbounce' for 20% off!", getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() - 65.0F, 16777215); super.drawScreen(mouseX, mouseY, partialTicks); } public void mouseClicked(int mouseX, int mouseY, int mouseButton) { if (this.apiKeyField == null) Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  this.apiKeyField.mouseClicked(mouseX, mouseY, mouseButton);
/* 269 */     if (this.tokenField == null) Intrinsics.throwUninitializedPropertyAccessException("tokenField");  this.tokenField.mouseClicked(mouseX, mouseY, mouseButton);
/* 270 */     super.mouseClicked(mouseX, mouseY, mouseButton); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class GuiTheAltening$actionPerformed$4 implements Runnable {
/*     */     public final void run() { try { String str; GuiTheAltening.this.status = "§cSwitching Alt Service..."; GuiAltManager.altService.switchService(AltService.EnumAltService.THEALTENING); GuiTheAltening.this.status = "§cLogging in..."; YggdrasilUserAuthentication yggdrasilUserAuthentication = new YggdrasilUserAuthentication(new YggdrasilAuthenticationService(Proxy.NO_PROXY, ""), Agent.MINECRAFT); yggdrasilUserAuthentication.setUsername(GuiTheAltening.access$getTokenField$p(GuiTheAltening.this).getText()); yggdrasilUserAuthentication.setPassword("XSJ Client"); GuiTheAltening guiTheAltening = GuiTheAltening.this; try { yggdrasilUserAuthentication.logIn(); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthentication.selectedProfile"); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile().getName(), "yggdrasilUserAuthentication.selectedProfile.name"); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthenticat…         .selectedProfile"); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), "yggdrasilUserAuthenticat…ctedProfile.id.toString()"); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getAuthenticatedToken(), "yggdrasilUserAuthentication.authenticatedToken"); MinecraftInstance.mc.setSession(MinecraftInstance.classProvider.createSession(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang")); Retreat.INSTANCE.getEventManager().callEvent((Event)new SessionEvent()); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthentication.selectedProfile"); GuiTheAltening.this.prevGui.status = "§aYour name is now §b§l" + yggdrasilUserAuthentication.getSelectedProfile().getName() + "§c."; MinecraftInstance.mc.displayGuiScreen(GuiTheAltening.this.prevGui.getRepresentedScreen()); Intrinsics.checkExpressionValueIsNotNull(yggdrasilUserAuthentication.getSelectedProfile(), "yggdrasilUserAuthentication.selectedProfile"); str = "§aYour name is now §b§l" + yggdrasilUserAuthentication.getSelectedProfile().getName() + "§c."; }
/*     */         catch (AuthenticationException authenticationException) { GuiAltManager.altService.switchService(AltService.EnumAltService.MOJANG); ClientUtils.getLogger().error("Failed to login.", (Throwable)authenticationException); str = "§cFailed to login: " + authenticationException.getMessage(); }
/*     */          guiTheAltening.status = str; }
/*     */       catch (Throwable throwable)
/*     */       { ClientUtils.getLogger().error("Failed to login.", throwable); GuiTheAltening.this.status = "§cFailed to login. Unknown error."; }
/*     */        GuiTheAltening.access$getLoginButton$p(GuiTheAltening.this).setEnabled(true); GuiTheAltening.access$getGenerateButton$p(GuiTheAltening.this).setEnabled(true); } }
/* 277 */   public void updateScreen() { if (this.apiKeyField == null) Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  this.apiKeyField.updateCursorCounter();
/* 278 */     if (this.tokenField == null) Intrinsics.throwUninitializedPropertyAccessException("tokenField");  this.tokenField.updateCursorCounter();
/* 279 */     super.updateScreen(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 287 */     Keyboard.enableRepeatEvents(false);
/*     */ 
/*     */     
/* 290 */     if (this.apiKeyField == null) Intrinsics.throwUninitializedPropertyAccessException("apiKeyField");  apiKey = this.apiKeyField.getText();
/* 291 */     super.onGuiClosed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\altmanager\sub\altgenerator\GuiTheAltening.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */