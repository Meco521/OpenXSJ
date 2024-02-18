/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.minecraft.client.renderer.RenderItem;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\007\n\002\b\006\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\021H\002J \020\022\032\0020\0232\006\020\024\032\0020\0252\006\020\026\032\0020\0272\006\020\030\032\0020\027H\026J \020\031\032\0020\0232\006\020\024\032\0020\0252\006\020\026\032\0020\0272\006\020\030\032\0020\027H\026J(\020\032\032\0020\0232\006\020\033\032\0020\0342\006\020\024\032\0020\0252\006\020\026\032\0020\0272\006\020\030\032\0020\027H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R$\020\t\032\0020\b2\006\020\007\032\0020\b8V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\r¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/RenderItemImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/entity/IRenderItem;", "wrapped", "Lnet/minecraft/client/renderer/RenderItem;", "(Lnet/minecraft/client/renderer/RenderItem;)V", "getWrapped", "()Lnet/minecraft/client/renderer/RenderItem;", "value", "", "zLevel", "getZLevel", "()F", "setZLevel", "(F)V", "equals", "", "other", "", "renderItemAndEffectIntoGUI", "", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "x", "", "y", "renderItemIntoGUI", "renderItemOverlays", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "XSJClient"})
/*    */ public final class RenderItemImpl implements IRenderItem {
/*    */   @NotNull
/*  9 */   public final RenderItem getWrapped() { return this.wrapped; } @NotNull private final RenderItem wrapped; public RenderItemImpl(@NotNull RenderItem wrapped) { this.wrapped = wrapped; }
/*    */    public float getZLevel() {
/* 11 */     return this.wrapped.field_77023_b;
/*    */   } public void setZLevel(float value) {
/* 13 */     this.wrapped.field_77023_b = value;
/*    */   }
/*    */   
/* 16 */   public void renderItemAndEffectIntoGUI(@NotNull IItemStack stack, int x, int y) { Intrinsics.checkParameterIsNotNull(stack, "stack"); IItemStack iItemStack = stack; RenderItem renderItem = this.wrapped; int $i$f$unwrap = 0;
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
/* 30 */     ItemStack itemStack = ((ItemStackImpl)iItemStack).getWrapped(); renderItem.func_180450_b(itemStack, x, y); } public void renderItemIntoGUI(@NotNull IItemStack stack, int x, int y) { Intrinsics.checkParameterIsNotNull(stack, "stack"); IItemStack iItemStack = stack; RenderItem renderItem = this.wrapped; int $i$f$unwrap = 0;
/* 31 */     ItemStack itemStack = ((ItemStackImpl)iItemStack).getWrapped(); renderItem.func_175042_a(itemStack, x, y); } public void renderItemOverlays(@NotNull IFontRenderer fontRenderer, @NotNull IItemStack stack, int x, int y) { Intrinsics.checkParameterIsNotNull(fontRenderer, "fontRenderer"); Intrinsics.checkParameterIsNotNull(stack, "stack"); IFontRenderer iFontRenderer = fontRenderer; RenderItem renderItem = this.wrapped; int $i$f$unwrap = 0;
/* 32 */     FontRenderer fontRenderer1 = ((FontRendererImpl)iFontRenderer).getWrapped(); IItemStack iItemStack = stack; fontRenderer1 = fontRenderer1; renderItem = renderItem; $i$f$unwrap = 0;
/* 33 */     ItemStack itemStack = ((ItemStackImpl)iItemStack).getWrapped(); renderItem.func_175030_a(fontRenderer1, itemStack, x, y); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof RenderItemImpl && Intrinsics.areEqual(((RenderItemImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\RenderItemImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */