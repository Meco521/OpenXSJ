/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.minecraft.world.border.WorldBorder;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\000\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\023\020\013\032\0020\b2\b\020\f\032\004\030\0010\rH\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/WorldBorderImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/border/IWorldBorder;", "wrapped", "Lnet/minecraft/world/border/WorldBorder;", "(Lnet/minecraft/world/border/WorldBorder;)V", "getWrapped", "()Lnet/minecraft/world/border/WorldBorder;", "contains", "", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "equals", "other", "", "XSJClient"})
/*    */ public final class WorldBorderImpl implements IWorldBorder {
/*    */   @NotNull
/*  9 */   public final WorldBorder getWrapped() { return this.wrapped; } @NotNull private final WorldBorder wrapped; public WorldBorderImpl(@NotNull WorldBorder wrapped) { this.wrapped = wrapped; } public boolean contains(@NotNull WBlockPos blockPos) {
/* 10 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); WBlockPos wBlockPos = blockPos; WorldBorder worldBorder = this.wrapped; int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 19 */     BlockPos blockPos1 = new BlockPos(wBlockPos.getX(), wBlockPos.getY(), wBlockPos.getZ()); return worldBorder.func_177746_a(blockPos1);
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof WorldBorderImpl && Intrinsics.areEqual(((WorldBorderImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\WorldBorderImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */