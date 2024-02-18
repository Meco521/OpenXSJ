/*     */ package net.ccbluex.liquidbounce.utils.block;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\016\n\000\n\002\020\b\n\000\n\002\020\006\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020$\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007J*\020\007\032\0020\0042\006\020\b\032\0020\t2\030\020\n\032\024\022\006\022\004\030\0010\f\022\004\022\0020\0040\013j\002`\rH\007J*\020\016\032\0020\0042\006\020\b\032\0020\t2\030\020\n\032\024\022\006\022\004\030\0010\f\022\004\022\0020\0040\013j\002`\rH\007J\022\020\017\032\004\030\0010\f2\006\020\005\032\0020\006H\007J\020\020\020\032\0020\0212\006\020\022\032\0020\023H\007J\020\020\024\032\0020\0252\006\020\005\032\0020\006H\007J\022\020\026\032\004\030\0010\0272\006\020\005\032\0020\006H\007J\022\020\030\032\004\030\0010\0312\006\020\005\032\0020\006H\007J\020\020\032\032\0020\0042\006\020\005\032\0020\006H\007J\021\020\033\032\0020\0042\006\020\005\032\0020\006H\bJ\034\020\034\032\016\022\004\022\0020\006\022\004\022\0020\f0\0352\006\020\036\032\0020\023H\007¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/block/BlockUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "canBeClicked", "", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "collideBlock", "axisAlignedBB", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "collide", "Lkotlin/Function1;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "Lnet/ccbluex/liquidbounce/utils/block/Collidable;", "collideBlockIntersects", "getBlock", "getBlockName", "", "id", "", "getCenterDistance", "", "getMaterial", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "getState", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "isFullBlock", "isReplaceable", "searchBlocks", "", "radius", "XSJClient"})
/*     */ public final class BlockUtils extends MinecraftInstance {
/*     */   public static final BlockUtils INSTANCE;
/*     */   
/*     */   static {
/*  13 */     BlockUtils blockUtils = new BlockUtils();
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @Nullable
/*     */   public static final IBlock getBlock(@NotNull WBlockPos blockPos) {
/*  19 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); MinecraftInstance.mc.getTheWorld().getBlockState(blockPos); return (MinecraftInstance.mc.getTheWorld() != null && MinecraftInstance.mc.getTheWorld().getBlockState(blockPos) != null) ? MinecraftInstance.mc.getTheWorld().getBlockState(blockPos).getBlock() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   @Nullable
/*     */   public static final IMaterial getMaterial(@NotNull WBlockPos blockPos) {
/*  26 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); IIBlockState state = getState(blockPos);
/*     */     
/*  28 */     state.getBlock(); return (state != null && state.getBlock() != null) ? state.getBlock().getMaterial(state) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final boolean isReplaceable(@NotNull WBlockPos blockPos) {
/*  35 */     int $i$f$isReplaceable = 0; Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); getMaterial(blockPos); return (getMaterial(blockPos) != null) ? getMaterial(blockPos).isReplaceable() : false;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @Nullable
/*     */   public static final IIBlockState getState(@NotNull WBlockPos blockPos) {
/*  41 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); MinecraftInstance.mc.getTheWorld(); return (MinecraftInstance.mc.getTheWorld() != null) ? MinecraftInstance.mc.getTheWorld().getBlockState(blockPos) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final boolean canBeClicked(@NotNull WBlockPos blockPos) {
/*  47 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); getBlock(blockPos); if ((getBlock(blockPos) != null) ? getBlock(blockPos).canCollideCheck(getState(blockPos), false) : false)
/*  48 */     { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getTheWorld().getWorldBorder().contains(blockPos)); }  return false;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String getBlockName(int id) {
/*  54 */     if (access$getFunctions$p$s1046033730().getBlockById(id) == null) Intrinsics.throwNpe();  return access$getFunctions$p$s1046033730().getBlockById(id).getLocalizedName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final boolean isFullBlock(@NotNull WBlockPos blockPos) {
/*  61 */     Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); if (getBlock(blockPos) != null) { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (getState(blockPos) != null) { if (getBlock(blockPos).getCollisionBoundingBox((IWorld)MinecraftInstance.mc.getTheWorld(), blockPos, getState(blockPos)) != null) { IAxisAlignedBB axisAlignedBB = getBlock(blockPos).getCollisionBoundingBox((IWorld)MinecraftInstance.mc.getTheWorld(), blockPos, getState(blockPos));
/*     */ 
/*     */           
/*  64 */           return (axisAlignedBB.getMaxX() - axisAlignedBB.getMinX() == 1.0D && axisAlignedBB.getMaxY() - axisAlignedBB.getMinY() == 1.0D && axisAlignedBB.getMaxZ() - axisAlignedBB.getMinZ() == 1.0D); }
/*     */          getBlock(blockPos).getCollisionBoundingBox((IWorld)MinecraftInstance.mc.getTheWorld(), blockPos, getState(blockPos));
/*     */         return false; }
/*     */       
/*     */       getState(blockPos);
/*     */       return false; }
/*     */     
/*     */     getBlock(blockPos);
/*  72 */     return false; } @JvmStatic public static final double getCenterDistance(@NotNull WBlockPos blockPos) { Intrinsics.checkParameterIsNotNull(blockPos, "blockPos"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return MinecraftInstance.mc.getThePlayer().getDistance(blockPos.getX() + 0.5D, blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D); }
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Map<WBlockPos, IBlock> searchBlocks(int radius) {
/*  79 */     boolean bool = false; Map<Object, Object> blocks = new LinkedHashMap<>();
/*     */     
/*  81 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  83 */       int i = radius, j = -radius + 1; if (i >= j)
/*  84 */         while (true) { int k = radius, m = -radius + 1; if (k >= m)
/*  85 */             while (true) { int n = radius, i1 = -radius + 1; if (n >= i1)
/*  86 */                 while (true) { WBlockPos blockPos = new WBlockPos((int)thePlayer.getPosX() + i, (int)thePlayer.getPosY() + k, 
/*  87 */                       (int)thePlayer.getPosZ() + n);
/*  88 */                   if (getBlock(blockPos) != null) { IBlock block = getBlock(blockPos);
/*     */                     
/*  90 */                     blocks.put(blockPos, block); } else { getBlock(blockPos); }  if (n != i1) { n--; continue; }  break; }
/*     */                   if (k != m) { k--; continue; }
/*     */                break; }
/*     */               if (i != j) { i--; continue; }
/*     */            break; }
/*  95 */           return (Map)blocks; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */     return (Map)blocks;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final boolean collideBlock(@NotNull IAxisAlignedBB axisAlignedBB, @NotNull Function1 collide) {
/* 103 */     Intrinsics.checkParameterIsNotNull(axisAlignedBB, "axisAlignedBB"); Intrinsics.checkParameterIsNotNull(collide, "collide"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 105 */     double d = thePlayer.getEntityBoundingBox().getMinX(); boolean bool = false; long l1 = (int)Math.floor(d); long l2;
/* 106 */     for (d = thePlayer.getEntityBoundingBox().getMaxX(), bool = false, l2 = (int)Math.floor(d) + 1L; l1 < l2; x = l1 + 1L) {
/* 107 */       long x; double d1 = thePlayer.getEntityBoundingBox().getMinZ(); boolean bool1 = false; int i = (int)Math.floor(d1); int j;
/* 108 */       for (d1 = thePlayer.getEntityBoundingBox().getMaxZ(), bool1 = false, j = (int)Math.floor(d1) + 1; i < j; i++) {
/* 109 */         IBlock block = getBlock(new WBlockPos(l1, axisAlignedBB.getMinY(), i));
/*     */         
/* 111 */         if (!((Boolean)collide.invoke(block)).booleanValue()) {
/* 112 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @JvmStatic
/*     */   public static final boolean collideBlockIntersects(@NotNull IAxisAlignedBB axisAlignedBB, @NotNull Function1 collide) {
/* 124 */     Intrinsics.checkParameterIsNotNull(axisAlignedBB, "axisAlignedBB"); Intrinsics.checkParameterIsNotNull(collide, "collide"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 125 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IWorldClient world = MinecraftInstance.mc.getTheWorld();
/*     */     
/* 127 */     double d = thePlayer.getEntityBoundingBox().getMinX(); boolean bool = false; int i = (int)Math.floor(d); int j;
/* 128 */     for (d = thePlayer.getEntityBoundingBox().getMaxX(), bool = false, j = (int)Math.floor(d) + 1; i < j; i++) {
/* 129 */       double d1 = thePlayer.getEntityBoundingBox().getMinZ(); boolean bool1 = false; int k = (int)Math.floor(d1); int m;
/* 130 */       for (d1 = thePlayer.getEntityBoundingBox().getMaxZ(), bool1 = false, m = (int)Math.floor(d1) + 1; k < m; k++) {
/* 131 */         WBlockPos blockPos = new WBlockPos(i, axisAlignedBB.getMinY(), k);
/* 132 */         IBlock block = getBlock(blockPos);
/*     */         
/* 134 */         if (((Boolean)collide.invoke(block)).booleanValue()) {
/* 135 */           if (getState(blockPos) != null) { IIBlockState iIBlockState1 = getState(blockPos); boolean bool2 = false, bool3 = false; IIBlockState it = iIBlockState1; int $i$a$-let-BlockUtils$collideBlockIntersects$boundingBox$1 = 0; if (((block != null) ? block.getCollisionBoundingBox((IWorld)world, blockPos, it) : null) != null) { Object object = (block != null) ? block.getCollisionBoundingBox((IWorld)world, blockPos, it) : null;
/*     */ 
/*     */               
/* 138 */               if (thePlayer.getEntityBoundingBox().intersectsWith((IAxisAlignedBB)object))
/* 139 */                 return true;  continue; }  }
/*     */            (block != null) ? block.getCollisionBoundingBox((IWorld)world, blockPos, it) : null;
/*     */         }  continue;
/*     */       } 
/* 143 */     }  return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\block\BlockUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */