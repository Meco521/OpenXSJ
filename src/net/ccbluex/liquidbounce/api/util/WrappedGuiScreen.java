/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\004\n\002\020\f\n\002\b\b\b&\030\0002\0020\001B\005¢\006\002\020\002J\020\020\t\032\0020\n2\006\020\013\032\0020\fH\026J\b\020\r\032\0020\016H\026J \020\017\032\0020\n2\006\020\020\032\0020\0212\006\020\022\032\0020\0212\006\020\023\032\0020\024H\026J\b\020\025\032\0020\nH\026J\b\020\026\032\0020\nH\026J\030\020\027\032\0020\n2\006\020\030\032\0020\0312\006\020\032\032\0020\021H\026J \020\033\032\0020\n2\006\020\020\032\0020\0212\006\020\022\032\0020\0212\006\020\034\032\0020\021H\026J \020\035\032\0020\n2\006\020\020\032\0020\0212\006\020\022\032\0020\0212\006\020\036\032\0020\021H\026J\b\020\037\032\0020\nH\026J\b\020 \032\0020\nH\026R\032\020\003\032\0020\004X.¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "representedScreen", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "getRepresentedScreen", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "setRepresentedScreen", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;)V", "actionPerformed", "", "button", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "doesGuiPauseGame", "", "drawScreen", "mouseX", "", "mouseY", "partialTicks", "", "handleMouseInput", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseButton", "mouseReleased", "state", "onGuiClosed", "updateScreen", "XSJClient"})
/*    */ public abstract class WrappedGuiScreen extends MinecraftInstance {
/*    */   @NotNull
/* 10 */   public final IGuiScreen getRepresentedScreen() { if (this.representedScreen == null) Intrinsics.throwUninitializedPropertyAccessException("representedScreen");  return this.representedScreen; } @NotNull public IGuiScreen representedScreen; public final void setRepresentedScreen(@NotNull IGuiScreen <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.representedScreen = <set-?>; }
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 13 */     if (this.representedScreen == null) Intrinsics.throwUninitializedPropertyAccessException("representedScreen");  this.representedScreen.superDrawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initGui() {}
/*    */ 
/*    */   
/*    */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 21 */     if (this.representedScreen == null) Intrinsics.throwUninitializedPropertyAccessException("representedScreen");  this.representedScreen.superMouseClicked(mouseX, mouseY, mouseButton);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateScreen() {}
/*    */   
/*    */   public void handleMouseInput() throws IOException {
/* 28 */     if (this.representedScreen == null) Intrinsics.throwUninitializedPropertyAccessException("representedScreen");  this.representedScreen.superHandleMouseInput();
/*    */   }
/*    */ 
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) throws IOException {
/* 33 */     if (this.representedScreen == null) Intrinsics.throwUninitializedPropertyAccessException("representedScreen");  this.representedScreen.superKeyTyped(typedChar, keyCode);
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionPerformed(@NotNull IGuiButton button) throws IOException {
/* 38 */     Intrinsics.checkParameterIsNotNull(button, "button");
/*    */   }
/*    */   public void onGuiClosed() {}
/*    */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 42 */     if (this.representedScreen == null) Intrinsics.throwUninitializedPropertyAccessException("representedScreen");  this.representedScreen.superMouseReleased(mouseX, mouseY, state);
/*    */   } public boolean doesGuiPauseGame() {
/* 44 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedGuiScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */