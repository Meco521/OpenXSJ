/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.FunctionReference;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*    */ import net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiGameOver;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000j\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020!\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\t\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\020\013\n\000\n\002\020\000\n\002\b\004\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\006\b\026\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J\b\020\032\032\0020\033H\026J\b\020\034\032\0020\035H\026J\b\020\036\032\0020\037H\026J\020\020 \032\0020!2\006\020\"\032\0020\021H\026J\b\020#\032\0020!H\026J\023\020$\032\0020%2\b\020&\032\004\030\0010'H\002J \020(\032\0020!2\006\020)\032\0020\0212\006\020*\032\0020\0212\006\020+\032\0020,H\026J\b\020-\032\0020!H\026J\030\020.\032\0020!2\006\020/\032\002002\006\0201\032\0020\021H\026J \0202\032\0020!2\006\020)\032\0020\0212\006\020*\032\0020\0212\006\0203\032\0020\021H\026J \0204\032\0020!2\006\020)\032\0020\0212\006\020*\032\0020\0212\006\0205\032\0020\021H\026R\032\020\007\032\b\022\004\022\0020\t0\b8VX\004¢\006\006\032\004\b\n\020\013R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R$\020\022\032\0020\0212\006\020\020\032\0020\0218V@VX\016¢\006\f\032\004\b\023\020\024\"\004\b\025\020\026R$\020\027\032\0020\0212\006\020\020\032\0020\0218V@VX\016¢\006\f\032\004\b\030\020\024\"\004\b\031\020\026¨\0066"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiScreenImpl;", "T", "Lnet/minecraft/client/gui/GuiScreen;", "Lnet/ccbluex/liquidbounce/injection/backend/GuiImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "wrapped", "(Lnet/minecraft/client/gui/GuiScreen;)V", "buttonList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "getButtonList", "()Ljava/util/List;", "fontRendererObj", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "getFontRendererObj", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "value", "", "height", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "asGuiChest", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;", "asGuiContainer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiContainer;", "asGuiGameOver", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiGameOver;", "drawBackground", "", "i", "drawDefaultBackground", "equals", "", "other", "", "superDrawScreen", "mouseX", "mouseY", "partialTicks", "", "superHandleMouseInput", "superKeyTyped", "typedChar", "", "keyCode", "superMouseClicked", "mouseButton", "superMouseReleased", "state", "XSJClient"})
/*    */ public class GuiScreenImpl<T extends GuiScreen> extends GuiImpl<T> implements IGuiScreen {
/* 18 */   public GuiScreenImpl(@NotNull GuiScreen wrapped) { super((T)wrapped); } @NotNull
/*    */   public IFontRenderer getFontRendererObj() {
/* 20 */     Intrinsics.checkExpressionValueIsNotNull(((GuiScreen)getWrapped()).field_146289_q, "wrapped.fontRenderer"); FontRenderer $this$wrap$iv = ((GuiScreen)getWrapped()).field_146289_q; int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 60 */       new FontRendererImpl($this$wrap$iv);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<IGuiButton> getButtonList() {
/*    */     return (List<IGuiButton>)new WrappedMutableList(((GuiScreen)getWrapped()).field_146292_n, GuiScreenImpl$buttonList$1.INSTANCE, GuiScreenImpl$buttonList$2.INSTANCE);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IGuiContainer asGuiContainer() {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiContainer"); 
/*    */     return new GuiContainerImpl<>((GuiContainer)getWrapped());
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IGuiGameOver asGuiGameOver() {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.GuiGameOver"); 
/*    */     return new GuiGameOverImpl<>((GuiGameOver)getWrapped());
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IGuiChest asGuiChest() {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.minecraft.client.gui.inventory.GuiChest"); 
/*    */     return new GuiChestImpl<>((GuiChest)getWrapped());
/*    */   }
/*    */   
/*    */   public void superMouseReleased(int mouseX, int mouseY, int state) {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper"); 
/*    */     ((GuiScreenWrapper)getWrapped()).superMouseReleased(mouseX, mouseY, state);
/*    */   }
/*    */   
/*    */   public void drawBackground(int i) {
/*    */     ((GuiScreen)getWrapped()).func_146278_c(i);
/*    */   }
/*    */   
/*    */   public void drawDefaultBackground() {
/*    */     ((GuiScreen)getWrapped()).func_146276_q_();
/*    */   }
/*    */   
/*    */   public void superKeyTyped(char typedChar, int keyCode) {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper"); 
/*    */     ((GuiScreenWrapper)getWrapped()).superKeyTyped(typedChar, keyCode);
/*    */   }
/*    */   
/*    */   public void superHandleMouseInput() {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper"); 
/*    */     ((GuiScreenWrapper)getWrapped()).superHandleMouseInput();
/*    */   }
/*    */   
/*    */   public void superMouseClicked(int mouseX, int mouseY, int mouseButton) {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper"); 
/*    */     ((GuiScreenWrapper)getWrapped()).superMouseClicked(mouseX, mouseY, mouseButton);
/*    */   }
/*    */   
/*    */   public void superDrawScreen(int mouseX, int mouseY, float partialTicks) {
/*    */     if (getWrapped() == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper"); 
/*    */     ((GuiScreenWrapper)getWrapped()).superDrawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */   
/*    */   public int getHeight() {
/*    */     return ((GuiScreen)getWrapped()).field_146295_m;
/*    */   }
/*    */   
/*    */   public void setHeight(int value) {
/*    */     ((GuiScreen)getWrapped()).field_146295_m = value;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/*    */     return ((GuiScreen)getWrapped()).field_146294_l;
/*    */   }
/*    */   
/*    */   public void setWidth(int value) {
/*    */     ((GuiScreen)getWrapped()).field_146294_l = value;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof GuiScreenImpl && Intrinsics.areEqual(((GuiScreenImpl<GuiScreen>)other).getWrapped(), (GuiScreen)getWrapped()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiScreenImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */