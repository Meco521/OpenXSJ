/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\002\n\000\n\002\020\022\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\016\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\007\032\0020\b2\b\020\t\032\004\030\0010\nH\002J\020\020\013\032\0020\f2\006\020\r\032\0020\016H\026J\020\020\017\032\0020\f2\006\020\020\032\0020\021H\026J\020\020\022\032\0020\0012\006\020\023\032\0020\024H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/PacketBufferImpl;", "Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "wrapped", "Lnet/minecraft/network/PacketBuffer;", "(Lnet/minecraft/network/PacketBuffer;)V", "getWrapped", "()Lnet/minecraft/network/PacketBuffer;", "equals", "", "other", "", "writeBytes", "", "payload", "", "writeItemStackToBuffer", "itemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "writeString", "vanilla", "", "XSJClient"})
/*    */ public final class PacketBufferImpl implements IPacketBuffer {
/*    */   @NotNull
/*  8 */   public final PacketBuffer getWrapped() { return this.wrapped; } @NotNull private final PacketBuffer wrapped; public PacketBufferImpl(@NotNull PacketBuffer wrapped) { this.wrapped = wrapped; }
/*    */    public void writeBytes(@NotNull byte[] payload) {
/* 10 */     Intrinsics.checkParameterIsNotNull(payload, "payload"); this.wrapped.writeBytes(payload);
/*    */   }
/*    */   
/*    */   public void writeItemStackToBuffer(@NotNull IItemStack itemStack) {
/* 14 */     Intrinsics.checkParameterIsNotNull(itemStack, "itemStack"); IItemStack iItemStack = itemStack; PacketBuffer packetBuffer = this.wrapped; int $i$f$unwrap = 0;
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
/* 30 */     ItemStack itemStack1 = ((ItemStackImpl)iItemStack).getWrapped(); packetBuffer.func_150788_a(itemStack1);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public IPacketBuffer writeString(@NotNull String vanilla) {
/*    */     Intrinsics.checkParameterIsNotNull(vanilla, "vanilla");
/*    */     this.wrapped.func_180714_a(vanilla);
/*    */     return this;
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof PacketBufferImpl && Intrinsics.areEqual(((PacketBufferImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\PacketBufferImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */