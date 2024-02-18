/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000V\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\000\n\002\020\001\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002J\020\020\021\032\0020\0222\006\020\023\032\0020\024H\026J0\020\025\032\0020\0262\006\020\027\032\0020\0302\006\020\031\032\0020\0322\f\020\033\032\b\022\004\022\0020\0350\0342\b\020\036\032\004\030\0010\037H\026J\030\020 \032\0020\b2\006\020\007\032\0020\b2\006\020\013\032\0020\bH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\nR\024\020\013\032\0020\b8VX\004¢\006\006\032\004\b\f\020\n¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ChunkImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IChunk;", "wrapped", "Lnet/minecraft/world/chunk/Chunk;", "(Lnet/minecraft/world/chunk/Chunk;)V", "getWrapped", "()Lnet/minecraft/world/chunk/Chunk;", "x", "", "getX", "()I", "z", "getZ", "equals", "", "other", "", "getBlockState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getEntitiesWithinAABBForEntity", "", "thePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "arrowBox", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "collidedEntities", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "nothing", "", "getHeightValue", "XSJClient"})
/*    */ public final class ChunkImpl implements IChunk {
/*    */   @NotNull
/* 15 */   public final Chunk getWrapped() { return this.wrapped; } @NotNull private final Chunk wrapped; public ChunkImpl(@NotNull Chunk wrapped) { this.wrapped = wrapped; }
/*    */    public int getX() {
/* 17 */     return this.wrapped.field_76635_g;
/*    */   } public int getZ() {
/* 19 */     return this.wrapped.field_76647_h;
/*    */   }
/*    */   
/* 22 */   public void getEntitiesWithinAABBForEntity(@NotNull IEntityPlayerSP thePlayer, @NotNull IAxisAlignedBB arrowBox, @NotNull List collidedEntities, @Nullable Void nothing) { Intrinsics.checkParameterIsNotNull(thePlayer, "thePlayer"); Intrinsics.checkParameterIsNotNull(arrowBox, "arrowBox"); Intrinsics.checkParameterIsNotNull(collidedEntities, "collidedEntities"); IEntityPlayerSP iEntityPlayerSP = thePlayer; Chunk chunk = this.wrapped; int $i$f$unwrap = 0;
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
/* 36 */     EntityPlayerSP entityPlayerSP = ((EntityPlayerSPImpl<EntityPlayerSP>)iEntityPlayerSP).getWrapped(); IAxisAlignedBB iAxisAlignedBB = arrowBox; Entity entity = (Entity)entityPlayerSP; chunk = chunk; $i$f$unwrap = 0;
/* 37 */     AxisAlignedBB axisAlignedBB = ((AxisAlignedBBImpl)iAxisAlignedBB).getWrapped(); chunk.func_177414_a(entity, axisAlignedBB, (List)new WrappedMutableList(collidedEntities, ChunkImpl$getEntitiesWithinAABBForEntity$1.INSTANCE, ChunkImpl$getEntitiesWithinAABBForEntity$2.INSTANCE), null); } public int getHeightValue(int x, int z) { return this.wrapped.func_76611_b(x, z); }
/* 38 */   @NotNull public IIBlockState getBlockState(@NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); WBlockPos wBlockPos = blockPos; Chunk chunk = this.wrapped; int $i$f$unwrap = 0; BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); Intrinsics.checkExpressionValueIsNotNull(chunk.func_177435_g(blockPos1), "wrapped.getBlockState(blockPos.unwrap())"); IBlockState $this$wrap$iv = chunk.func_177435_g(blockPos1); int $i$f$wrap = 0;
/* 39 */     return new IBlockStateImpl($this$wrap$iv); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof ChunkImpl && Intrinsics.areEqual(((ChunkImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ChunkImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */