/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
/*    */ import net.minecraft.network.play.server.SPacketEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J\022\020\013\032\004\030\0010\f2\006\020\r\032\0020\016H\026R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/SPacketEntityImpl;", "T", "Lnet/minecraft/network/play/server/SPacketEntity;", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntity;", "wrapped", "(Lnet/minecraft/network/play/server/SPacketEntity;)V", "onGround", "", "getOnGround", "()Z", "getEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "world", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "XSJClient"})
/*    */ public final class SPacketEntityImpl<T extends SPacketEntity> extends PacketImpl<T> implements ISPacketEntity {
/*    */   public SPacketEntityImpl(@NotNull SPacketEntity wrapped) {
/*  9 */     super((T)wrapped);
/*    */   }
/* 11 */   public boolean getOnGround() { return ((SPacketEntity)getWrapped()).func_179742_g(); } @Nullable
/*    */   public IEntity getEntity(@NotNull IWorld world) {
/* 13 */     Intrinsics.checkParameterIsNotNull(world, "world"); IWorld iWorld = world; SPacketEntity sPacketEntity = (SPacketEntity)getWrapped(); int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 18 */     World world1 = (World)((WorldImpl<Object>)iWorld).getWrapped(); Entity $this$wrap$iv = sPacketEntity.func_149065_a(world1); int $i$f$wrap = 0; sPacketEntity.func_149065_a(world1); return (sPacketEntity.func_149065_a(world1) != null) ? 
/* 19 */       new EntityImpl<>($this$wrap$iv) : null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\SPacketEntityImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */