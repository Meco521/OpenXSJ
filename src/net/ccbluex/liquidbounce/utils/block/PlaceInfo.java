/*    */ package net.ccbluex.liquidbounce.utils.block;
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\030\000 \0212\0020\001:\001\021B\037\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\b\b\002\020\006\032\0020\007¢\006\002\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\013\020\fR\032\020\006\032\0020\007X\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "enumFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "vec3", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)V", "getBlockPos", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getEnumFacing", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getVec3", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "setVec3", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)V", "Companion", "XSJClient"})
/*    */ public final class PlaceInfo {
/*    */   @NotNull
/*    */   private final WBlockPos blockPos;
/*    */   @NotNull
/*    */   private final IEnumFacing enumFacing;
/*    */   
/*    */   @NotNull
/* 10 */   public final WBlockPos getBlockPos() { return this.blockPos; } @NotNull private WVec3 vec3; public static final Companion Companion = new Companion(null); @NotNull public final IEnumFacing getEnumFacing() { return this.enumFacing; } public PlaceInfo(@NotNull WBlockPos blockPos, @NotNull IEnumFacing enumFacing, @NotNull WVec3 vec3) { this.blockPos = blockPos; this.enumFacing = enumFacing; this.vec3 = vec3; } @NotNull
/* 11 */   public final WVec3 getVec3() { return this.vec3; } public final void setVec3(@NotNull WVec3 <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.vec3 = <set-?>; }
/*    */    @JvmStatic
/*    */   @Nullable
/*    */   public static final PlaceInfo get(@NotNull WBlockPos blockPos) {
/*    */     return Companion.get(blockPos);
/*    */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020\003\032\004\030\0010\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo$Companion;", "", "()V", "get", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"})
/*    */   public static final class Companion { private Companion() {} @JvmStatic
/*    */     @Nullable
/*    */     public final PlaceInfo get(@NotNull WBlockPos blockPos) {
/* 20 */       Intrinsics.checkParameterIsNotNull(blockPos, "blockPos");
/* 21 */       if (BlockUtils.canBeClicked(blockPos.add(0, -1, 0)))
/* 22 */         return new PlaceInfo(blockPos.add(0, -1, 0), WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.UP), null, 4, null); 
/* 23 */       if (BlockUtils.canBeClicked(blockPos.add(0, 0, 1)))
/* 24 */         return new PlaceInfo(blockPos.add(0, 0, 1), WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.NORTH), null, 4, null); 
/* 25 */       if (BlockUtils.canBeClicked(blockPos.add(-1, 0, 0)))
/* 26 */         return new PlaceInfo(blockPos.add(-1, 0, 0), WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.EAST), null, 4, null); 
/* 27 */       if (BlockUtils.canBeClicked(blockPos.add(0, 0, -1)))
/* 28 */         return new PlaceInfo(blockPos.add(0, 0, -1), WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.SOUTH), null, 4, null); 
/* 29 */       return BlockUtils.canBeClicked(blockPos.add(1, 0, 0)) ? 
/* 30 */         new PlaceInfo(blockPos.add(1, 0, 0), WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.WEST), null, 4, null) : 
/* 31 */         null;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\block\PlaceInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */