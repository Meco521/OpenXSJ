/*    */ package net.ccbluex.liquidbounce.api.util;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiSlot;
/*    */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\006\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\n\n\002\020\013\n\002\b\004\b&\030\0002\0020\001B5\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005\022\006\020\007\032\0020\005\022\006\020\b\032\0020\005\022\006\020\t\032\0020\005¢\006\002\020\nJ\b\020\021\032\0020\022H&J8\020\023\032\0020\0222\006\020\024\032\0020\0052\006\020\025\032\0020\0052\006\020\026\032\0020\0052\006\020\027\032\0020\0052\006\020\030\032\0020\0052\006\020\031\032\0020\005H&J(\020\032\032\0020\0222\006\020\033\032\0020\0052\006\020\034\032\0020\0352\006\020\036\032\0020\0052\006\020\027\032\0020\005H&J\b\020\037\032\0020\005H&J\020\020 \032\0020\0352\006\020\024\032\0020\005H&R\032\020\013\032\0020\fX.¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "", "mc", "Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "width", "", "height", "top", "bottom", "slotHeight", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;IIIII)V", "represented", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiSlot;", "getRepresented", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiSlot;", "setRepresented", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiSlot;)V", "drawBackground", "", "drawSlot", "id", "x", "y", "var4", "var5", "var6", "elementClicked", "var1", "doubleClick", "", "var3", "getSize", "isSelected", "XSJClient"})
/*    */ public abstract class WrappedGuiSlot {
/*    */   public WrappedGuiSlot(@NotNull IMinecraft mc, int width, int height, int top, int bottom, int slotHeight) {
/* 12 */     WrapperImpl.INSTANCE.getClassProvider().wrapGuiSlot(this, mc, width, height, top, bottom, slotHeight);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IGuiSlot represented;
/*    */   
/*    */   public abstract boolean isSelected(int paramInt);
/*    */   
/*    */   public abstract int getSize();
/*    */   
/*    */   public abstract void elementClicked(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract void drawBackground();
/*    */   
/*    */   public abstract void drawSlot(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*    */   
/*    */   public final void setRepresented(@NotNull IGuiSlot <set-?>) {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     this.represented = <set-?>;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final IGuiSlot getRepresented() {
/*    */     if (this.represented == null)
/*    */       Intrinsics.throwUninitializedPropertyAccessException("represented"); 
/*    */     return this.represented;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\ap\\util\WrappedGuiSlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */