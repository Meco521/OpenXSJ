/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.Blink;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BlockValue;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "ChestAura", description = "Automatically opens chests around you.", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000H\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\025\032\0020\026H\026J\020\020\027\032\0020\0262\006\020\030\032\0020\031H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\027\020\005\032\b\022\004\022\0020\0070\006¢\006\b\n\000\032\004\b\b\020\tR\020\020\n\032\004\030\0010\007X\016¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\020X\004¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\016\020\024\032\0020\020X\004¢\006\002\n\000¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ChestAura;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "chestValue", "Lnet/ccbluex/liquidbounce/value/BlockValue;", "clickedBlocks", "", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getClickedBlocks", "()Ljava/util/List;", "currentBlock", "delayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "rangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "rotationsValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "throughWallsValue", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "visualSwing", "onDisable", "", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "XSJClient"})
/*     */ public final class ChestAura extends Module {
/*     */   static {
/*  25 */     ChestAura chestAura = new ChestAura();
/*     */   }
/*  27 */   private static final FloatValue rangeValue = new FloatValue("Range", 5.0F, 1.0F, 6.0F);
/*  28 */   private static final IntegerValue delayValue = new IntegerValue("Delay", 100, 50, 200);
/*  29 */   private static final BoolValue throughWallsValue = new BoolValue("ThroughWalls", true);
/*  30 */   private static final BoolValue visualSwing = new BoolValue("VisualSwing", true);
/*  31 */   private static final BlockValue chestValue = new BlockValue("Chest", access$getFunctions$p$s1046033730().getIdFromBlock(MinecraftInstance.classProvider.getBlockEnum(BlockType.CHEST)));
/*  32 */   private static final BoolValue rotationsValue = new BoolValue("Rotations", true);
/*     */   
/*     */   private static WBlockPos currentBlock;
/*  35 */   private static final MSTimer timer = new MSTimer();
/*     */   @NotNull
/*  37 */   private static final List<WBlockPos> clickedBlocks = new ArrayList<>(); public static final ChestAura INSTANCE; @NotNull public final List<WBlockPos> getClickedBlocks() { return clickedBlocks; } static { boolean bool = false; } @EventTarget public final void onMotion(@NotNull MotionEvent event) { float radius; WVec3 eyesPos; Map<Object, Object> $this$filter$iv, $this$minBy$iv; int $i$f$filter, $i$f$minBy; Map<Object, Object> map1, $this$filterTo$iv$iv; Iterable<Map.Entry<Object, Object>> $this$minBy$iv$iv; Map<Object, Object> map2, destination$iv$iv; int i, $i$f$filterTo; Iterator<Map.Entry<Object, Object>> iterator$iv$iv;
/*     */     Map<Object, Object> map3;
/*     */     Object<Object, Object> minElem$iv$iv;
/*     */     boolean bool;
/*  41 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (Retreat.INSTANCE.getModuleManager().get(Blink.class) == null) Intrinsics.throwNpe();  if (Retreat.INSTANCE.getModuleManager().get(Blink.class).getState()) {
/*     */       return;
/*     */     }
/*  44 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  45 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*     */     
/*  47 */     switch (ChestAura$WhenMappings.$EnumSwitchMapping$0[event.getEventState().ordinal()]) {
/*     */       case 1:
/*  49 */         if (MinecraftInstance.classProvider.isGuiContainer(MinecraftInstance.mc.getCurrentScreen())) {
/*  50 */           timer.reset();
/*     */         }
/*  52 */         radius = ((Number)rangeValue.get()).floatValue() + true;
/*     */         
/*  54 */         eyesPos = new WVec3(thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY() + thePlayer.getEyeHeight(), 
/*  55 */             thePlayer.getPosZ());
/*     */         
/*  57 */         $this$filter$iv = BlockUtils.searchBlocks((int)radius);
/*  58 */         $i$f$filter = 0;
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
/*  99 */         map1 = $this$filter$iv; map2 = new LinkedHashMap<>(); $i$f$filterTo = 0;
/* 100 */         map3 = map1; bool = false; for (Map.Entry element$iv$iv : map3.entrySet()) {
/* 101 */           Map.Entry it = element$iv$iv; int $i$a$-filter-ChestAura$onMotion$1 = 0; if ((access$getFunctions$p$s1046033730().getIdFromBlock((IBlock)it.getValue()) == ((Number)chestValue.get()).intValue() && !clickedBlocks.contains(it.getKey()) && BlockUtils.getCenterDistance((WBlockPos)it.getKey()) < ((Number)rangeValue.get()).doubleValue())) {
/* 102 */             map2.put(element$iv$iv.getKey(), element$iv$iv.getValue());
/*     */           }
/*     */         } 
/* 105 */         $this$filter$iv = map2; $i$f$filter = 0;
/* 106 */         $this$filterTo$iv$iv = $this$filter$iv; destination$iv$iv = new LinkedHashMap<>(); $i$f$filterTo = 0;
/* 107 */         map3 = $this$filterTo$iv$iv; bool = false; for (Map.Entry<Object, Object> element$iv$iv : map3.entrySet()) {
/* 108 */           Map.Entry<Object, Object> it = element$iv$iv; int $i$a$-filter-ChestAura$onMotion$2 = 0;
/*     */           WBlockPos blockPos = (WBlockPos)it.getKey();
/*     */           IMovingObjectPosition movingObjectPosition = theWorld.rayTraceBlocks(eyesPos, BlockExtensionKt.getVec(blockPos), false, true, false);
/*     */         } 
/* 112 */         $this$minBy$iv = destination$iv$iv; $i$f$minBy = 0;
/* 113 */         $this$minBy$iv$iv = $this$minBy$iv.entrySet(); i = 0;
/* 114 */         iterator$iv$iv = $this$minBy$iv$iv.iterator();
/*     */         
/* 116 */         minElem$iv$iv = (Object<Object, Object>)iterator$iv$iv.next();
/* 117 */         if (!iterator$iv$iv.hasNext()) {  }
/* 118 */         else { Map.Entry it = (Map.Entry)minElem$iv$iv; int $i$a$-minBy-ChestAura$onMotion$3 = 0;
/*     */ 
/*     */           
/*     */           double minValue$iv$iv = BlockUtils.getCenterDistance((WBlockPos)it.getKey()); }
/*     */ 
/*     */ 
/*     */         
/*     */         (Map.Entry<WBlockPos, ?>)(!iterator$iv$iv.hasNext() ? null : (((Boolean)throughWallsValue.get()).booleanValue() ? true : ((movingObjectPosition != null && Intrinsics.areEqual(movingObjectPosition.getBlockPos(), blockPos)) ? true : false)));
/*     */         
/* 127 */         currentBlock = ((Map.Entry<WBlockPos, ?>)(!iterator$iv$iv.hasNext() ? null : (((Boolean)throughWallsValue.get()).booleanValue() ? true : ((movingObjectPosition != null && Intrinsics.areEqual(movingObjectPosition.getBlockPos(), blockPos)) ? true : false))) != null) ? ((Map.Entry<WBlockPos, ?>)(!iterator$iv$iv.hasNext() ? null : (((Boolean)throughWallsValue.get()).booleanValue() ? true : ((movingObjectPosition != null && Intrinsics.areEqual(movingObjectPosition.getBlockPos(), blockPos)) ? true : false)))).getKey() : null;
/*     */         if (((Boolean)rotationsValue.get()).booleanValue()) {
/*     */           if (currentBlock != null) {
/*     */             if (RotationUtils.faceBlock(currentBlock) != null) {
/*     */               RotationUtils.setTargetRotation(RotationUtils.faceBlock(currentBlock).getRotation());
/*     */               break;
/*     */             } 
/*     */             RotationUtils.faceBlock(currentBlock);
/*     */             return;
/*     */           } 
/*     */           return;
/*     */         } 
/*     */         break;
/*     */       case 2:
/*     */         if (currentBlock != null && timer.hasTimePassed(((Number)delayValue.get()).intValue())) {
/*     */           if (MinecraftInstance.mc.getTheWorld() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (thePlayer.getHeldItem() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (currentBlock == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (currentBlock == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           if (MinecraftInstance.mc.getPlayerController().onPlayerRightClick(thePlayer, MinecraftInstance.mc.getTheWorld(), thePlayer.getHeldItem(), currentBlock, MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN), BlockExtensionKt.getVec(currentBlock))) {
/*     */             if (((Boolean)visualSwing.get()).booleanValue()) {
/*     */               thePlayer.swingItem();
/*     */             } else {
/*     */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketAnimation());
/*     */             } 
/*     */             if (currentBlock == null)
/*     */               Intrinsics.throwNpe(); 
/*     */             clickedBlocks.add(currentBlock);
/*     */             currentBlock = (WBlockPos)null;
/*     */             timer.reset();
/*     */           } 
/*     */         } 
/*     */         break;
/*     */     }  }
/*     */ 
/*     */   
/*     */   public void onDisable() {
/*     */     clickedBlocks.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ChestAura.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */