/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR\024\020\013\032\0020\f8VX\004¢\006\006\032\004\b\r\020\016R\024\020\017\032\0020\0208VX\004¢\006\006\032\004\b\021\020\022¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/CPacketPlayerDiggingImpl;", "T", "Lnet/minecraft/network/play/client/CPacketPlayerDigging;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging;", "wrapped", "(Lnet/minecraft/network/play/client/CPacketPlayerDigging;)V", "action", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;", "getAction", "()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;", "facing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getFacing", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "position", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getPosition", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"})
/*    */ public final class CPacketPlayerDiggingImpl<T extends CPacketPlayerDigging> extends PacketImpl<T> implements ICPacketPlayerDigging {
/*    */   public CPacketPlayerDiggingImpl(@NotNull CPacketPlayerDigging wrapped) {
/*  9 */     super((T)wrapped);
/*    */   } @NotNull
/*    */   public WBlockPos getPosition() {
/* 12 */     Intrinsics.checkExpressionValueIsNotNull(((CPacketPlayerDigging)getWrapped()).func_179715_a(), "wrapped.position"); Intrinsics.checkExpressionValueIsNotNull(((CPacketPlayerDigging)getWrapped()).func_179715_a(), "wrapped.position"); Intrinsics.checkExpressionValueIsNotNull(((CPacketPlayerDigging)getWrapped()).func_179715_a(), "wrapped.position"); return new WBlockPos(((CPacketPlayerDigging)getWrapped()).func_179715_a().func_177958_n(), ((CPacketPlayerDigging)getWrapped()).func_179715_a().func_177956_o(), ((CPacketPlayerDigging)getWrapped()).func_179715_a().func_177952_p());
/*    */   }
/*    */   @NotNull
/* 15 */   public IEnumFacing getFacing() { Intrinsics.checkExpressionValueIsNotNull(((CPacketPlayerDigging)getWrapped()).func_179714_b(), "wrapped.facing"); EnumFacing $this$wrap$iv = ((CPacketPlayerDigging)getWrapped()).func_179714_b(); int $i$f$wrap = 0; return 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 24 */       new EnumFacingImpl($this$wrap$iv); } @NotNull public ICPacketPlayerDigging.WAction getAction() { Intrinsics.checkExpressionValueIsNotNull(((CPacketPlayerDigging)getWrapped()).func_180762_c(), "wrapped.action"); CPacketPlayerDigging.Action $this$wrap$iv = ((CPacketPlayerDigging)getWrapped()).func_180762_c(); int $i$f$wrap = 0;
/* 25 */     switch (BackendExtentionsKt.WhenMappings.$EnumSwitchMapping$9[$this$wrap$iv.ordinal()]) { case 1: 
/*    */       case 2: 
/*    */       case 3: 
/*    */       case 4: 
/*    */       case 5: 
/*    */       case 6: 
/*    */       case 7:
/* 32 */        }  throw new NoWhenBranchMatchedException(); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\CPacketPlayerDiggingImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */