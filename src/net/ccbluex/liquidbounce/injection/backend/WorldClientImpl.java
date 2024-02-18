/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.FunctionReference;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000T\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\036\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\002\b\002\030\0002\b\022\004\022\0020\0020\0012\0020\003B\r\022\006\020\004\032\0020\002¢\006\002\020\005J\030\020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\bH\026J\020\020\026\032\0020\0222\006\020\023\032\0020\024H\026J \020\027\032\0020\0222\006\020\023\032\0020\0242\006\020\030\032\0020\0312\006\020\032\032\0020\024H\026J\b\020\033\032\0020\022H\026J$\020\034\032\0020\0352\b\020\030\032\004\030\0010\0312\b\020\036\032\004\030\0010\0372\006\020 \032\0020\024H\026R\032\020\006\032\b\022\004\022\0020\b0\0078VX\004¢\006\006\032\004\b\t\020\nR\032\020\013\032\b\022\004\022\0020\f0\0078VX\004¢\006\006\032\004\b\r\020\nR\032\020\016\032\b\022\004\022\0020\0170\0078VX\004¢\006\006\032\004\b\020\020\n¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/WorldClientImpl;", "Lnet/ccbluex/liquidbounce/injection/backend/WorldImpl;", "Lnet/minecraft/client/multiplayer/WorldClient;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "wrapped", "(Lnet/minecraft/client/multiplayer/WorldClient;)V", "loadedEntityList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getLoadedEntityList", "()Ljava/util/Collection;", "loadedTileEntityList", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "getLoadedTileEntityList", "playerEntities", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "getPlayerEntities", "addEntityToWorld", "", "entityId", "", "fakePlayer", "removeEntityFromWorld", "sendBlockBreakProgress", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "damage", "sendQuittingDisconnectingPacket", "setBlockState", "", "blockstate", "Lnet/minecraft/block/state/IBlockState;", "size", "XSJClient"})
/*    */ public final class WorldClientImpl extends WorldImpl<WorldClient> implements IWorldClient {
/* 18 */   public WorldClientImpl(@NotNull WorldClient wrapped) { super(wrapped); }
/*    */   @NotNull
/* 20 */   public Collection<IEntityPlayer> getPlayerEntities() { return (Collection<IEntityPlayer>)new WrappedCollection((getWrapped()).field_73010_i, WorldClientImpl$playerEntities$1.INSTANCE, WorldClientImpl$playerEntities$2.INSTANCE); }
/*    */   @NotNull
/* 22 */   public Collection<IEntity> getLoadedEntityList() { return (Collection<IEntity>)new WrappedCollection((getWrapped()).field_72996_f, WorldClientImpl$loadedEntityList$1.INSTANCE, WorldClientImpl$loadedEntityList$2.INSTANCE); } @NotNull
/*    */   public Collection<ITileEntity> getLoadedTileEntityList() {
/* 24 */     return (Collection<ITileEntity>)new WrappedCollection((getWrapped()).field_147482_g, WorldClientImpl$loadedTileEntityList$1.INSTANCE, WorldClientImpl$loadedTileEntityList$2.INSTANCE);
/*    */   } public void sendQuittingDisconnectingPacket() {
/* 26 */     getWrapped().func_72882_A();
/*    */   }
/* 28 */   public void sendBlockBreakProgress(int entityId, @NotNull WBlockPos blockPos, int damage) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); WBlockPos wBlockPos = blockPos; int i = entityId; WorldClient worldClient = getWrapped(); int $i$f$unwrap = 0;
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
/* 42 */     BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); worldClient.func_175715_c(i, blockPos1, damage); } public void addEntityToWorld(int entityId, @NotNull IEntity fakePlayer) { Intrinsics.checkParameterIsNotNull(fakePlayer, "fakePlayer"); IEntity iEntity = fakePlayer; int i = entityId; WorldClient worldClient = getWrapped(); int $i$f$unwrap = 0;
/* 43 */     Entity entity = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); worldClient.func_73027_a(i, entity); }
/*    */ 
/*    */   
/*    */   public void removeEntityFromWorld(int entityId) {
/*    */     getWrapped().func_73028_b(entityId);
/*    */   }
/*    */   
/*    */   public boolean setBlockState(@Nullable WBlockPos blockPos, @Nullable IBlockState blockstate, int size) {
/*    */     if (blockPos == null)
/*    */       Intrinsics.throwNpe(); 
/*    */     return getWrapped().func_180501_a(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ()), blockstate, size);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\WorldClientImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */