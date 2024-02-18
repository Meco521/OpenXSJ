/*     */ package net.ccbluex.liquidbounce.ui.client.altmanager.sub;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpRequestBase;
/*     */ import org.apache.http.message.BasicHeader;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\007\030\000 \0352\0020\001:\001\035B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\013\032\0020\f2\006\020\r\032\0020\006H\026J \020\016\032\0020\f2\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\022\032\0020\023H\026J\b\020\024\032\0020\fH\026J\030\020\025\032\0020\f2\006\020\026\032\0020\0272\006\020\030\032\0020\020H\026J \020\031\032\0020\f2\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\032\032\0020\020H\026J\b\020\033\032\0020\fH\026J\b\020\034\032\0020\fH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\005\032\0020\006X.¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX.¢\006\002\n\000¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/altmanager/sub/GuiDonatorCape;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "prevGui", "Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;", "(Lnet/ccbluex/liquidbounce/ui/client/altmanager/GuiAltManager;)V", "stateButton", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "status", "", "transferCodeField", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiTextField;", "actionPerformed", "", "button", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseButton", "onGuiClosed", "updateScreen", "Companion", "XSJClient"})
/*     */ public final class GuiDonatorCape extends WrappedGuiScreen {
/*     */   private IGuiButton stateButton;
/*     */   private IGuiTextField transferCodeField;
/*     */   private String status;
/*     */   
/*     */   public GuiDonatorCape(@NotNull GuiAltManager prevGui) {
/*  19 */     this.prevGui = prevGui;
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
/*  34 */     this.status = "";
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
/*     */   private final GuiAltManager prevGui;
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
/*     */   @NotNull
/*     */   private static String transferCode;
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
/*     */   private static boolean capeEnabled;
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GuiDonatorCape$actionPerformed$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     GuiDonatorCape$actionPerformed$1() {
/*     */       super(0);
/*     */     }
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
/*     */     public final void invoke() {
/* 101 */       CloseableHttpClient httpClient = HttpClients.createDefault();
/* 102 */       BasicHeader[] headers = {
/* 103 */           new BasicHeader("Content-Type", "application/json"), 
/* 104 */           new BasicHeader("Authorization", GuiDonatorCape.access$getTransferCodeField$p(GuiDonatorCape.this).getText())
/*     */         };
/* 106 */       HttpRequestBase request = GuiDonatorCape.Companion.getCapeEnabled() ? 
/* 107 */         (HttpRequestBase)new HttpDelete("http://capes.liquidbounce.net/api/v1/cape/self") : 
/*     */         
/* 109 */         (HttpRequestBase)new HttpPut("http://capes.liquidbounce.net/api/v1/cape/self");
/*     */       
/* 111 */       request.setHeaders((Header[])headers);
/* 112 */       CloseableHttpResponse response = httpClient.execute((HttpUriRequest)request);
/* 113 */       Intrinsics.checkExpressionValueIsNotNull(response, "response"); Intrinsics.checkExpressionValueIsNotNull(response.getStatusLine(), "response.statusLine"); int statusCode = response.getStatusLine().getStatusCode();
/*     */ 
/*     */       
/* 116 */       GuiDonatorCape.Companion.setCapeEnabled(!GuiDonatorCape.Companion.getCapeEnabled());
/* 117 */       GuiDonatorCape.this.status = (statusCode == 204) ? (GuiDonatorCape.Companion.getCapeEnabled() ? 
/* 118 */         "§aSuccessfully enabled cape" : 
/*     */         
/* 120 */         "§aSuccessfully disabled cape") : (
/*     */ 
/*     */         
/* 123 */         "§cFailed to toggle cape (" + statusCode + ')');
/*     */ 
/*     */       
/* 126 */       GuiDonatorCape.access$getStateButton$p(GuiDonatorCape.this).setEnabled(true); } } public static final Companion Companion = new Companion(null); public void actionPerformed(@NotNull IGuiButton button) { Intrinsics.checkParameterIsNotNull(button, "button"); if (!button.getEnabled())
/*     */       return;  switch (button.getId()) { case 0: MinecraftInstance.mc.displayGuiScreen(this.prevGui.getRepresentedScreen()); break;
/*     */       case 1: if (this.stateButton == null)
/*     */           Intrinsics.throwUninitializedPropertyAccessException("stateButton");  this.stateButton.setEnabled(false); ThreadsKt.thread$default(false, false, null, null, 0, new GuiDonatorCape$actionPerformed$1(), 31, null); break;
/* 130 */       case 2: MiscUtils.showURL("https://donate.liquidbounce.net");
/*     */         break; }
/*     */      }
/*     */   static { transferCode = "";
/*     */     capeEnabled = true; }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\016\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/altmanager/sub/GuiDonatorCape$Companion;", "", "()V", "capeEnabled", "", "getCapeEnabled", "()Z", "setCapeEnabled", "(Z)V", "transferCode", "", "getTransferCode", "()Ljava/lang/String;", "setTransferCode", "(Ljava/lang/String;)V", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     @NotNull
/*     */     public final String getTransferCode() { return GuiDonatorCape.transferCode; }
/*     */     public final void setTransferCode(@NotNull String <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */       GuiDonatorCape.transferCode = <set-?>; }
/* 142 */     public final boolean getCapeEnabled() { return GuiDonatorCape.capeEnabled; } public final void setCapeEnabled(boolean <set-?>) { GuiDonatorCape.capeEnabled = <set-?>; } } public void keyTyped(char typedChar, int keyCode) { if (1 == keyCode) {
/*     */       
/* 144 */       MinecraftInstance.mc.displayGuiScreen(this.prevGui.getRepresentedScreen());
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 151 */     if (this.transferCodeField == null) Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  if (this.transferCodeField.isFocused()) { if (this.transferCodeField == null) Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  this.transferCodeField.textboxKeyTyped(typedChar, keyCode); }
/*     */ 
/*     */     
/* 154 */     super.keyTyped(typedChar, keyCode); } public void initGui() { Keyboard.enableRepeatEvents(true); this.stateButton = MinecraftInstance.classProvider.createGuiButton(1, getRepresentedScreen().getWidth() / 2 - 100, 105, "Disable Cape"); if (this.stateButton == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("stateButton");  getRepresentedScreen().getButtonList().add(this.stateButton); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(2, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 96, "Donate to get Cape")); getRepresentedScreen().getButtonList().add(MinecraftInstance.classProvider.createGuiButton(0, getRepresentedScreen().getWidth() / 2 - 100, getRepresentedScreen().getHeight() / 4 + 120, "Back")); Intrinsics.checkExpressionValueIsNotNull(Fonts.roboto40, "Fonts.roboto40"); this.transferCodeField = MinecraftInstance.classProvider.createGuiPasswordField(666, Fonts.roboto40, getRepresentedScreen().getWidth() / 2 - 100, 80, 200, 20); if (this.transferCodeField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  this.transferCodeField.setFocused(true); if (this.transferCodeField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  this.transferCodeField.setMaxStringLength(2147483647);
/*     */     if (this.transferCodeField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("transferCodeField"); 
/*     */     this.transferCodeField.setText(transferCode);
/*     */     super.initGui(); }
/* 162 */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) { if (this.transferCodeField == null) Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  this.transferCodeField.mouseClicked(mouseX, mouseY, mouseButton);
/*     */ 
/*     */     
/* 165 */     super.mouseClicked(mouseX, mouseY, mouseButton); } public void drawScreen(int mouseX, int mouseY, float partialTicks) { getRepresentedScreen().drawBackground(0); RenderUtils.drawRect(30.0F, 30.0F, getRepresentedScreen().getWidth() - 30.0F, getRepresentedScreen().getHeight() - 30.0F, -2147483648); Fonts.roboto35.drawCenteredString("Donator Cape", getRepresentedScreen().getWidth() / 2.0F, 36.0F, 16777215); Fonts.roboto35.drawCenteredString(this.status, getRepresentedScreen().getWidth() / 2.0F, getRepresentedScreen().getHeight() / 4.0F + 80, 16777215); if (this.transferCodeField == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  this.transferCodeField.drawTextBox();
/*     */     Fonts.roboto40.drawCenteredString("§7Transfer Code:", getRepresentedScreen().getWidth() / 2.0F - 65, 66.0F, 16777215);
/*     */     if (this.stateButton == null)
/*     */       Intrinsics.throwUninitializedPropertyAccessException("stateButton"); 
/*     */     this.stateButton.setDisplayString(capeEnabled ? "Disable Cape" : "Enable Cape");
/*     */     super.drawScreen(mouseX, mouseY, partialTicks); }
/* 172 */   public void updateScreen() { if (this.transferCodeField == null) Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  this.transferCodeField.updateCursorCounter();
/* 173 */     super.updateScreen(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 181 */     Keyboard.enableRepeatEvents(false);
/*     */ 
/*     */     
/* 184 */     if (this.transferCodeField == null) Intrinsics.throwUninitializedPropertyAccessException("transferCodeField");  transferCode = this.transferCodeField.getText();
/*     */ 
/*     */     
/* 187 */     super.onGuiClosed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\altmanager\sub\GuiDonatorCape.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */