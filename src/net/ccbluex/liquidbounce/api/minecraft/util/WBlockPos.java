/*    */ package net.ccbluex.liquidbounce.api.minecraft.util;
/*    */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\004\n\002\030\002\n\000\n\002\020\b\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\030\000 \0312\0020\001:\001\031B\037\b\026\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006B\017\b\026\022\006\020\007\032\0020\b¢\006\002\020\tB\035\022\006\020\002\032\0020\n\022\006\020\004\032\0020\n\022\006\020\005\032\0020\n¢\006\002\020\013J\036\020\f\032\0020\0002\006\020\002\032\0020\n2\006\020\004\032\0020\n2\006\020\005\032\0020\nJ\006\020\r\032\0020\000J\016\020\r\032\0020\0002\006\020\016\032\0020\nJ\006\020\017\032\0020\000J\016\020\017\032\0020\0002\006\020\016\032\0020\nJ\b\020\020\032\004\030\0010\021J\006\020\022\032\0020\000J\016\020\022\032\0020\0002\006\020\016\032\0020\nJ\032\020\023\032\0020\0002\006\020\024\032\0020\0252\b\b\002\020\016\032\0020\nH\007J\006\020\026\032\0020\000J\016\020\026\032\0020\0002\006\020\016\032\0020\nJ\006\020\027\032\0020\000J\016\020\027\032\0020\0002\006\020\016\032\0020\nJ\006\020\030\032\0020\000J\016\020\030\032\0020\0002\006\020\016\032\0020\n¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "x", "", "y", "z", "(DDD)V", "source", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V", "", "(III)V", "add", "down", "n", "east", "getBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "north", "offset", "side", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "south", "up", "west", "Companion", "XSJClient"})
/*    */ public final class WBlockPos extends WVec3i {
/*    */   public WBlockPos(int x, int y, int z) {
/* 10 */     super(x, y, z);
/*    */   } @NotNull
/* 12 */   private static final WBlockPos ORIGIN; public static final Companion Companion = new Companion(null); static { ORIGIN = new WBlockPos(0, 0, 0); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;", "", "()V", "ORIGIN", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getORIGIN", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "XSJClient"}) public static final class Companion { @NotNull public final WBlockPos getORIGIN() { return WBlockPos.ORIGIN; }
/*    */      private Companion() {} }
/*    */   public WBlockPos(double x, double y, double z) {
/* 15 */     this(i, j, (int)d3);
/*    */   } public WBlockPos(@NotNull IEntity source) {
/* 17 */     this(source.getPosX(), source.getPosY(), source.getPosZ());
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public final WBlockPos add(int x, int y, int z) {
/* 23 */     return (x == 0 && y == 0 && z == 0) ? this : new WBlockPos(getX() + x, getY() + y, getZ() + z);
/*    */   }
/*    */   @JvmOverloads
/*    */   @NotNull
/*    */   public final WBlockPos offset(@NotNull IEnumFacing side, int n) {
/* 28 */     Intrinsics.checkParameterIsNotNull(side, "side"); return (n == 0) ? this : new WBlockPos(getX() + side.getDirectionVec().getX() * n, getY() + side.getDirectionVec().getY() * n, getZ() + side.getDirectionVec().getZ() * n);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos up() {
/* 32 */     return up(1);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos up(int n) {
/* 36 */     return offset(WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.UP), n);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos down() {
/* 40 */     return down(1);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos down(int n) {
/* 44 */     return offset(WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.DOWN), n);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos west() {
/* 48 */     return west(1);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos west(int n) {
/* 52 */     return offset(WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.WEST), n);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos east() {
/* 56 */     return east(1);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos east(int n) {
/* 60 */     return offset(WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.EAST), n);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos north() {
/* 64 */     return north(1);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos north(int n) {
/* 68 */     return offset(WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.NORTH), n);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos south() {
/* 72 */     return south(1);
/*    */   }
/*    */   @NotNull
/*    */   public final WBlockPos south(int n) {
/* 76 */     return offset(WrapperImpl.INSTANCE.getClassProvider().getEnumFacing(EnumFacingType.SOUTH), n);
/*    */   } @Nullable
/*    */   public final IBlock getBlock() {
/* 79 */     return BlockUtils.getBlock(this);
/*    */   }
/*    */   
/*    */   @JvmOverloads
/*    */   @NotNull
/*    */   public final WBlockPos offset(@NotNull IEnumFacing side) {
/*    */     return offset$default(this, side, 0, 2, (Object)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraf\\util\WBlockPos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */