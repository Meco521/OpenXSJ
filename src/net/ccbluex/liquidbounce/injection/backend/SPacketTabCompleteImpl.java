/*   */ package net.ccbluex.liquidbounce.injection.backend;
/*   */ 
/*   */ import net.minecraft.network.play.server.SPacketTabComplete;
/*   */ 
/*   */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\021\n\002\020\016\n\002\b\003\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006R\032\020\007\032\b\022\004\022\0020\t0\b8VX\004¢\006\006\032\004\b\n\020\013¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SPacketTabCompleteImpl;", "T", "Lnet/minecraft/network/play/server/SPacketTabComplete;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketTabComplete;", "wrapped", "(Lnet/minecraft/network/play/server/SPacketTabComplete;)V", "completions", "", "", "getCompletions", "()[Ljava/lang/String;", "XSJClient"})
/*   */ public final class SPacketTabCompleteImpl<T extends SPacketTabComplete> extends PacketImpl<T> implements ISPacketTabComplete {
/* 7 */   public SPacketTabCompleteImpl(@NotNull SPacketTabComplete wrapped) { super((T)wrapped); } @NotNull
/*   */   public String[] getCompletions() {
/* 9 */     Intrinsics.checkExpressionValueIsNotNull(((SPacketTabComplete)getWrapped()).func_149630_c(), "wrapped.matches"); return ((SPacketTabComplete)getWrapped()).func_149630_c();
/*   */   }
/*   */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketTabCompleteImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */