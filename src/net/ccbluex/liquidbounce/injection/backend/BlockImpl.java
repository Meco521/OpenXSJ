/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000p\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\005\n\002\020\007\n\002\b\b\n\002\020\013\n\002\b\004\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\001\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\032\020\030\032\0020\0312\b\020\032\032\004\030\0010\0062\006\020\033\032\0020\031H\026J\023\020\034\032\0020\0312\b\020\035\032\004\030\0010\036H\002J\"\020\037\032\004\030\0010 2\006\020!\032\0020\"2\006\020#\032\0020$2\006\020\032\032\0020\006H\026J\020\020%\032\0020&2\006\020'\032\0020\001H\026J \020(\032\0020&2\006\020)\032\0020\0062\006\020*\032\0020+2\006\020,\032\0020$H\026J\022\020-\032\004\030\0010.2\006\020\032\032\0020\006H\026J \020/\032\0020\0202\006\0200\032\002012\006\020*\032\0020\"2\006\0202\032\0020$H\026J \0203\032\0020 2\006\020!\032\0020\"2\006\020)\032\0020\0062\006\0202\032\0020$H\026J\020\0204\032\0020\0312\006\020\032\032\0020\006H\026J\020\0205\032\0020\0312\006\020)\032\0020\006H\026J\030\0206\032\002072\006\020!\032\0020\"2\006\0202\032\0020$H\026R\026\020\005\032\004\030\0010\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\n8VX\004¢\006\006\032\004\b\016\020\fR$\020\021\032\0020\0202\006\020\017\032\0020\0208V@VX\016¢\006\f\032\004\b\022\020\023\"\004\b\024\020\025R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\026\020\027¨\0068"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/BlockImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "wrapped", "Lnet/minecraft/block/Block;", "(Lnet/minecraft/block/Block;)V", "defaultState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "getDefaultState", "()Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "localizedName", "", "getLocalizedName", "()Ljava/lang/String;", "registryName", "getRegistryName", "value", "", "slipperiness", "getSlipperiness", "()F", "setSlipperiness", "(F)V", "getWrapped", "()Lnet/minecraft/block/Block;", "canCollideCheck", "", "state", "hitIfLiquid", "equals", "other", "", "getCollisionBoundingBox", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "world", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "pos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getIdFromBlock", "", "block", "getMapColor", "blockState", "theWorld", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "bp", "getMaterial", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "getPlayerRelativeBlockHardness", "thePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "blockPos", "getSelectedBoundingBox", "isFullCube", "isTranslucent", "setBlockBoundsBasedOnState", "", "XSJClient"})
/*    */ public final class BlockImpl implements IBlock {
/*    */   @NotNull
/* 15 */   public final Block getWrapped() { return this.wrapped; } @NotNull private final Block wrapped; public BlockImpl(@NotNull Block wrapped) { this.wrapped = wrapped; } @NotNull
/*    */   public String getRegistryName() {
/* 17 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_149739_a(), "wrapped.unlocalizedName"); return this.wrapped.func_149739_a();
/*    */   } public float getSlipperiness() {
/* 19 */     return this.wrapped.field_149765_K;
/*    */   } public void setSlipperiness(float value) {
/* 21 */     this.wrapped.field_149765_K = value;
/*    */   }
/*    */   @Nullable
/* 24 */   public IIBlockState getDefaultState() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_176223_P(), "wrapped.defaultState"); return new IBlockStateImpl(this.wrapped.func_176223_P()); }
/*    */   @NotNull
/* 26 */   public String getLocalizedName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_149732_F(), "wrapped.localizedName"); return this.wrapped.func_149732_F(); }
/*    */   @NotNull
/* 28 */   public IAxisAlignedBB getSelectedBoundingBox(@NotNull IWorld world, @NotNull IIBlockState blockState, @NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(world, "world"); Intrinsics.checkParameterIsNotNull(blockState, "blockState"); Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); IIBlockState iIBlockState = blockState; Block block = this.wrapped; int $i$f$unwrap = 0;
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
/* 52 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); IWorld iWorld = world; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 53 */     IBlockAccess iBlockAccess = (IBlockAccess)((WorldImpl<Object>)iWorld).getWrapped(); WBlockPos wBlockPos1 = blockPos; iBlockAccess = iBlockAccess; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 54 */     BlockPos blockPos2 = new BlockPos(wBlockPos1.getX(), wBlockPos1.getY(), wBlockPos1.getZ()); WBlockPos $this$unwrap$iv = blockPos; AxisAlignedBB axisAlignedBB1 = block.func_185496_a(iBlockState, iBlockAccess, blockPos2); $i$f$unwrap = 0;
/* 55 */     BlockPos blockPos1 = new BlockPos($this$unwrap$iv.getX(), $this$unwrap$iv.getY(), $this$unwrap$iv.getZ()); Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB1.func_186670_a(blockPos1), "wrapped.getBoundingBox(b…offset(blockPos.unwrap())"); AxisAlignedBB axisAlignedBB2 = axisAlignedBB1.func_186670_a(blockPos1); return new AxisAlignedBBImpl(axisAlignedBB2); } @Nullable public IAxisAlignedBB getCollisionBoundingBox(@NotNull IWorld world, @NotNull WBlockPos pos, @NotNull IIBlockState state) { Intrinsics.checkParameterIsNotNull(world, "world"); Intrinsics.checkParameterIsNotNull(pos, "pos"); Intrinsics.checkParameterIsNotNull(state, "state"); IIBlockState iIBlockState = state; Block block = this.wrapped; int $i$f$unwrap = 0;
/* 56 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); IWorld iWorld = world; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 57 */     IBlockAccess iBlockAccess = (IBlockAccess)((WorldImpl<Object>)iWorld).getWrapped(); WBlockPos wBlockPos = pos; iBlockAccess = iBlockAccess; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 58 */     BlockPos blockPos = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); AxisAlignedBB $this$wrap$iv = block.func_180646_a(iBlockState, iBlockAccess, blockPos); int $i$f$wrap = 0; block.func_180646_a(iBlockState, iBlockAccess, blockPos); return (block.func_180646_a(iBlockState, iBlockAccess, blockPos) != null) ? 
/* 59 */       new AxisAlignedBBImpl($this$wrap$iv) : null; } public boolean canCollideCheck(@Nullable IIBlockState state, boolean hitIfLiquid) { IIBlockState iIBlockState = state; Block block = this.wrapped; int $i$f$unwrap = 0;
/* 60 */     if (iIBlockState == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.IBlockStateImpl");  IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); return this.wrapped.func_176209_a((state != null) ? iBlockState : null, hitIfLiquid); } @NotNull public Void setBlockBoundsBasedOnState(@NotNull IWorld world, @NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(world, "world"); Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); Backend this_$iv = Backend.INSTANCE; int $i$f$BACKEND_UNSUPPORTED = 0;
/* 61 */     throw (Throwable)new NotImplementedError("1.12.2 doesn't support this feature'"); } public float getPlayerRelativeBlockHardness(@NotNull IEntityPlayerSP thePlayer, @NotNull IWorld theWorld, @NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(thePlayer, "thePlayer"); Intrinsics.checkParameterIsNotNull(theWorld, "theWorld"); Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); IIBlockState iIBlockState = theWorld.getBlockState(blockPos); Block block = this.wrapped; int $i$f$unwrap = 0;
/* 62 */     if (iIBlockState == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.IBlockStateImpl");  IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); IEntityPlayerSP iEntityPlayerSP = thePlayer; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 63 */     EntityPlayerSP entityPlayerSP = ((EntityPlayerSPImpl<EntityPlayerSP>)iEntityPlayerSP).getWrapped(); IWorld iWorld = theWorld; EntityPlayer entityPlayer = (EntityPlayer)entityPlayerSP; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 64 */     World world = (World)((WorldImpl<Object>)iWorld).getWrapped(); WBlockPos wBlockPos = blockPos; world = world; entityPlayer = entityPlayer; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 65 */     BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); return block.func_180647_a(iBlockState, entityPlayer, world, blockPos1); } public int getIdFromBlock(@NotNull IBlock block) { Intrinsics.checkParameterIsNotNull(block, "block"); IBlock $this$unwrap$iv = block; int $i$f$unwrap = 0;
/* 66 */     return Block.func_149682_b(((BlockImpl)$this$unwrap$iv).getWrapped()); } public boolean isTranslucent(@NotNull IIBlockState blockState) { Intrinsics.checkParameterIsNotNull(blockState, "blockState"); IIBlockState iIBlockState = blockState; Block block = this.wrapped; int $i$f$unwrap = 0;
/* 67 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); return block.func_149751_l(iBlockState); } public int getMapColor(@NotNull IIBlockState blockState, @NotNull IWorldClient theWorld, @NotNull WBlockPos bp) { Intrinsics.checkParameterIsNotNull(blockState, "blockState"); Intrinsics.checkParameterIsNotNull(theWorld, "theWorld"); Intrinsics.checkParameterIsNotNull(bp, "bp"); IIBlockState iIBlockState = blockState; Block block = this.wrapped; int $i$f$unwrap = 0;
/* 68 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); IWorldClient iWorldClient = theWorld; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 69 */     WorldClient worldClient = ((WorldClientImpl)iWorldClient).getWrapped(); WBlockPos wBlockPos = bp; IBlockAccess iBlockAccess = (IBlockAccess)worldClient; iBlockState = iBlockState; block = block; $i$f$unwrap = 0;
/* 70 */     BlockPos blockPos = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); return (block.func_180659_g(iBlockState, iBlockAccess, blockPos)).field_76291_p; } @Nullable public IMaterial getMaterial(@NotNull IIBlockState state) { Intrinsics.checkParameterIsNotNull(state, "state"); IIBlockState iIBlockState = state; Block block = this.wrapped; int $i$f$unwrap = 0;
/* 71 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); Intrinsics.checkExpressionValueIsNotNull(block.func_149688_o(iBlockState), "wrapped.getMaterial(state.unwrap())"); Material $this$wrap$iv = block.func_149688_o(iBlockState); int $i$f$wrap = 0;
/* 72 */     return new MaterialImpl($this$wrap$iv); } public boolean isFullCube(@NotNull IIBlockState state) { Intrinsics.checkParameterIsNotNull(state, "state"); IIBlockState iIBlockState = state; Block block = this.wrapped; int $i$f$unwrap = 0;
/* 73 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); return block.func_149686_d(iBlockState); }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof BlockImpl && Intrinsics.areEqual(((BlockImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\BlockImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */