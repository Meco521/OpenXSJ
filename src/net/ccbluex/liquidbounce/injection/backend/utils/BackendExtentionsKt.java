/*     */ package net.ccbluex.liquidbounce.injection.backend.utils;
/*     */ 
/*     */ import kotlin.NoWhenBranchMatchedException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.WEnumPlayerModelParts;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WEnumChatFormatting;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3i;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorldSettings;
/*     */ import net.minecraft.entity.player.EnumPlayerModelParts;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*     */ import net.minecraft.network.play.client.CPacketUseEntity;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.util.math.Vec3i;
/*     */ import net.minecraft.world.GameType;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\000\001\n\000\n\002\030\002\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\004*\0020\002H\b\032\r\020\005\032\0020\002*\0020\001H\b\032\r\020\006\032\0020\007*\0020\bH\b\032\r\020\006\032\0020\t*\0020\nH\b\032\r\020\006\032\0020\013*\0020\fH\b\032\r\020\006\032\0020\r*\0020\016H\b\032\r\020\006\032\0020\017*\0020\020H\b\032\r\020\006\032\0020\021*\0020\022H\b\032\r\020\006\032\0020\023*\0020\024H\b\032\r\020\006\032\0020\025*\0020\026H\b\032\r\020\006\032\0020\027*\0020\030H\b\032\r\020\006\032\0020\031*\0020\032H\b\032\r\020\006\032\0020\033*\0020\034H\b\032\r\020\006\032\0020\035*\0020\036H\b\032\r\020\006\032\0020\037*\0020 H\b\032\r\020!\032\0020\n*\0020\tH\b\032\r\020!\032\0020\022*\0020\021H\b\032\r\020!\032\0020\026*\0020\025H\b\032\r\020!\032\0020\030*\0020\027H\b\032\r\020!\032\0020\"*\0020#H\b\032\r\020!\032\0020\034*\0020\033H\b\032\r\020!\032\0020\036*\0020\035H\b\032\r\020!\032\0020\032*\0020\031H\b\032\r\020!\032\0020 *\0020\037H\b¨\006$"}, d2 = {"toClickType", "Lnet/minecraft/inventory/ClickType;", "", "toEntityEquipmentSlot", "Lnet/minecraft/inventory/EntityEquipmentSlot;", "toInt", "unwrap", "Lnet/minecraft/util/EnumHand;", "Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;", "Lnet/minecraft/entity/player/EnumPlayerModelParts;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/WEnumPlayerModelParts;", "Lnet/minecraft/util/text/event/ClickEvent$Action;", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent$WAction;", "Lnet/minecraft/network/play/client/CPacketClientStatus$State;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus$WEnumState;", "Lnet/minecraft/network/play/client/CPacketEntityAction$Action;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;", "Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;", "Lnet/minecraft/network/play/client/CPacketResourcePackStatus$Action;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketResourcePackStatus$WAction;", "Lnet/minecraft/network/play/client/CPacketUseEntity$Action;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "Lnet/minecraft/util/math/BlockPos;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "Lnet/minecraft/util/text/TextFormatting;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WEnumChatFormatting;", "Lnet/minecraft/util/math/Vec3d;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "Lnet/minecraft/util/math/Vec3i;", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;", "Lnet/minecraft/world/GameType;", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;", "wrap", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;", "Lnet/minecraft/util/math/RayTraceResult$Type;", "XSJClient"})
/*     */ public final class BackendExtentionsKt {
/*     */   @NotNull
/*  26 */   public static final Vec3d unwrap(@NotNull WVec3 $this$unwrap) { int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return new Vec3d($this$unwrap.getXCoord(), $this$unwrap.getYCoord(), $this$unwrap.getZCoord()); } @NotNull
/*  27 */   public static final Vec3i unwrap(@NotNull WVec3i $this$unwrap) { int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return new Vec3i($this$unwrap.getX(), $this$unwrap.getY(), $this$unwrap.getZ()); } @NotNull
/*  28 */   public static final BlockPos unwrap(@NotNull WBlockPos $this$unwrap) { int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); return new BlockPos($this$unwrap.getX(), $this$unwrap.getY(), $this$unwrap.getZ()); }
/*     */   @NotNull
/*  30 */   public static final WBlockPos wrap(@NotNull BlockPos $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new WBlockPos($this$wrap.func_177958_n(), $this$wrap.func_177956_o(), $this$wrap.func_177952_p()); } @NotNull
/*  31 */   public static final WVec3 wrap(@NotNull Vec3d $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new WVec3($this$wrap.field_72450_a, $this$wrap.field_72448_b, $this$wrap.field_72449_c); } @NotNull
/*  32 */   public static final WVec3i wrap(@NotNull Vec3i $this$wrap) { int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); return new WVec3i($this$wrap.func_177958_n(), $this$wrap.func_177956_o(), $this$wrap.func_177952_p()); }
/*     */    @NotNull
/*     */   public static final IMovingObjectPosition.WMovingObjectType wrap(@NotNull RayTraceResult.Type $this$wrap) {
/*  35 */     int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$0[$this$wrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3:
/*  38 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final EnumPlayerModelParts unwrap(@NotNull WEnumPlayerModelParts $this$unwrap) {
/*  43 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$1[$this$unwrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7:
/*  50 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final WEnumPlayerModelParts wrap(@NotNull EnumPlayerModelParts $this$wrap) {
/*  55 */     int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$2[$this$wrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7:
/*  62 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final WEnumChatFormatting wrap(@NotNull TextFormatting $this$wrap) {
/*  67 */     int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$3[$this$wrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7: 
/*     */       case 8: 
/*     */       case 9: 
/*     */       case 10: 
/*     */       case 11: 
/*     */       case 12: 
/*     */       case 13: 
/*     */       case 14: 
/*     */       case 15: 
/*     */       case 16: 
/*     */       case 17: 
/*     */       case 18: 
/*     */       case 19: 
/*     */       case 20: 
/*     */       case 21: 
/*     */       case 22:
/*  89 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final TextFormatting unwrap(@NotNull WEnumChatFormatting $this$unwrap) {
/*  94 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$4[$this$unwrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7: 
/*     */       case 8: 
/*     */       case 9: 
/*     */       case 10: 
/*     */       case 11: 
/*     */       case 12: 
/*     */       case 13: 
/*     */       case 14: 
/*     */       case 15: 
/*     */       case 16: 
/*     */       case 17: 
/*     */       case 18: 
/*     */       case 19: 
/*     */       case 20: 
/*     */       case 21: 
/*     */       case 22:
/* 116 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public static final GameType unwrap(@NotNull IWorldSettings.WGameType $this$unwrap) {
/* 122 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$5[$this$unwrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5:
/* 127 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final IWorldSettings.WGameType wrap(@NotNull GameType $this$wrap) {
/* 132 */     int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$6[$this$wrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5:
/* 137 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final ICPacketUseEntity.WAction wrap(@NotNull CPacketUseEntity.Action $this$wrap) {
/* 142 */     int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$7[$this$wrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3:
/* 145 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final CPacketUseEntity.Action unwrap(@NotNull ICPacketUseEntity.WAction $this$unwrap) {
/* 150 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$8[$this$unwrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3:
/* 153 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final ICPacketPlayerDigging.WAction wrap(@NotNull CPacketPlayerDigging.Action $this$wrap) {
/* 158 */     int $i$f$wrap = 0; Intrinsics.checkParameterIsNotNull($this$wrap, "$this$wrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$9[$this$wrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7:
/* 165 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final CPacketPlayerDigging.Action unwrap(@NotNull ICPacketPlayerDigging.WAction $this$unwrap) {
/* 170 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$10[$this$unwrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7:
/* 177 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final ClickEvent.Action unwrap(@NotNull IClickEvent.WAction $this$unwrap) {
/* 182 */     int $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$11[$this$unwrap.ordinal()]) { case 1:
/* 183 */        }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   @NotNull
/*     */   public static final CPacketClientStatus.State unwrap(@NotNull ICPacketClientStatus.WEnumState $this$unwrap) {
/*     */     Backend backend;
/* 188 */     int $i$f$BACKEND_UNSUPPORTED, $i$f$unwrap = 0; Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap"); switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$12[$this$unwrap.ordinal()]) { case 1: 
/*     */       case 2: 
/*     */       case 3:
/* 191 */         backend = Backend.INSTANCE; $i$f$BACKEND_UNSUPPORTED = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 259 */         throw (Throwable)new NotImplementedError("1.12.2 doesn't support this feature'"); }  throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final CPacketResourcePackStatus.Action unwrap(@NotNull ICPacketResourcePackStatus.WAction $this$unwrap) {
/*     */     int $i$f$unwrap = 0;
/*     */     Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap");
/*     */     switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$13[$this$unwrap.ordinal()]) {
/*     */       case 1:
/*     */       
/*     */       case 2:
/*     */       
/*     */       case 3:
/*     */       
/*     */       case 4:
/*     */       
/*     */     } 
/*     */     throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final CPacketEntityAction.Action unwrap(@NotNull ICPacketEntityAction.WAction $this$unwrap) {
/*     */     int $i$f$unwrap = 0;
/*     */     Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap");
/*     */     switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$14[$this$unwrap.ordinal()]) {
/*     */       case 1:
/*     */       
/*     */       case 2:
/*     */       
/*     */       case 3:
/*     */       
/*     */       case 4:
/*     */       
/*     */       case 5:
/*     */       
/*     */       case 6:
/*     */       
/*     */     } 
/*     */     throw new NoWhenBranchMatchedException();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final EntityEquipmentSlot toEntityEquipmentSlot(int $this$toEntityEquipmentSlot) {
/*     */     int $i$f$toEntityEquipmentSlot = 0;
/*     */     switch ($this$toEntityEquipmentSlot) {
/*     */       case 0:
/*     */       
/*     */       case 1:
/*     */       
/*     */       case 2:
/*     */       
/*     */       case 3:
/*     */       
/*     */       case 4:
/*     */       
/*     */       case 5:
/*     */       
/*     */     } 
/*     */     throw (Throwable)new IllegalArgumentException("Invalid armorType " + $this$toEntityEquipmentSlot);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final ClickType toClickType(int $this$toClickType) {
/*     */     int $i$f$toClickType = 0;
/*     */     switch ($this$toClickType) {
/*     */       case 0:
/*     */       
/*     */       case 1:
/*     */       
/*     */       case 2:
/*     */       
/*     */       case 3:
/*     */       
/*     */       case 4:
/*     */       
/*     */       case 5:
/*     */       
/*     */       case 6:
/*     */       
/*     */     } 
/*     */     throw (Throwable)new IllegalArgumentException("Invalid mode " + $this$toClickType);
/*     */   }
/*     */   
/*     */   public static final int toInt(@NotNull ClickType $this$toInt) {
/*     */     int $i$f$toInt = 0;
/*     */     Intrinsics.checkParameterIsNotNull($this$toInt, "$this$toInt");
/*     */     switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$15[$this$toInt.ordinal()]) {
/*     */       case 1:
/*     */       
/*     */       case 2:
/*     */       
/*     */       case 3:
/*     */       
/*     */       case 4:
/*     */       
/*     */       case 5:
/*     */       
/*     */       case 6:
/*     */       
/*     */       case 7:
/*     */       
/*     */     } 
/*     */     throw (Throwable)new IllegalArgumentException("Invalid mode " + $this$toInt);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final EnumHand unwrap(@NotNull WEnumHand $this$unwrap) {
/*     */     int $i$f$unwrap = 0;
/*     */     Intrinsics.checkParameterIsNotNull($this$unwrap, "$this$unwrap");
/*     */     switch (BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$16[$this$unwrap.ordinal()]) {
/*     */       case 1:
/*     */       
/*     */       case 2:
/*     */       
/*     */     } 
/*     */     throw new NoWhenBranchMatchedException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backen\\utils\BackendExtentionsKt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */