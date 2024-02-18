/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.BlockBBEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ @ModuleInfo(name = "FastClimb", description = "Allows you to climb up ladders and vines faster.", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\r\032\0020\0162\006\020\017\032\0020\020H\007J\020\020\021\032\0020\0162\006\020\017\032\0020\022H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\f¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/FastClimb;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "speedValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "onBlockBB", "", "event", "Lnet/ccbluex/liquidbounce/event/BlockBBEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "XSJClient"})
/*     */ public final class FastClimb
/*     */   extends Module
/*     */ {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "invoke"})
/*     */   static final class FastClimb$onMove$1
/*     */     extends Lambda
/*     */     implements Function1<IBlock, Boolean>
/*     */   {
/*     */     public static final FastClimb$onMove$1 INSTANCE = new FastClimb$onMove$1();
/*     */     
/*     */     FastClimb$onMove$1() {
/*     */       super(1);
/*     */     }
/*     */     
/*     */     public final boolean invoke(@Nullable IBlock it) {
/*  60 */       return (MinecraftInstance.classProvider.isBlockLadder(it) || MinecraftInstance.classProvider.isBlockVine(it)); } } @NotNull private final ListValue modeValue = new ListValue("Mode", new String[] { "Vanilla", "Clip", "AAC3.0.0", "AAC3.0.5", "SAAC3.1.2", "AAC3.1.2" }, "Vanilla"); @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); String mode = (String)this.modeValue.get(); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer(); if (StringsKt.equals(mode, "Vanilla", true) && thePlayer.isCollidedHorizontally() && thePlayer.isOnLadder()) { event.setY(((Number)this.speedValue.get()).floatValue()); thePlayer.setMotionY(0.0D); } else if (StringsKt.equals(mode, "AAC3.0.0", true) && thePlayer.isCollidedHorizontally()) { double x = 0.0D; double z = 0.0D; IEnumFacing horizontalFacing = thePlayer.getHorizontalFacing(); if (horizontalFacing.isNorth()) { z = -0.99D; } else if (horizontalFacing.isEast()) { x = 0.99D; } else if (horizontalFacing.isSouth()) { z = 0.99D; } else if (horizontalFacing.isWest()) { x = -0.99D; }  IBlock block = BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX() + x, thePlayer.getPosY(), thePlayer.getPosZ() + z)); if (MinecraftInstance.classProvider.isBlockLadder(block) || MinecraftInstance.classProvider.isBlockVine(block)) { event.setY(0.5D); thePlayer.setMotionY(0.0D); }
/*     */          }
/*  62 */       else if (StringsKt.equals(mode, "AAC3.0.5", true) && MinecraftInstance.mc.getGameSettings().getKeyBindForward().isKeyDown() && BlockUtils.collideBlockIntersects(thePlayer.getEntityBoundingBox(), FastClimb$onMove$1.INSTANCE)) { event.setX(0.0D);
/*  63 */         event.setY(0.5D);
/*  64 */         event.setZ(0.0D);
/*     */         
/*  66 */         thePlayer.setMotionX(0.0D);
/*  67 */         thePlayer.setMotionY(0.0D);
/*  68 */         thePlayer.setMotionZ(0.0D);
/*     */          }
/*     */       
/*  71 */       else if (StringsKt.equals(mode, "SAAC3.1.2", true) && thePlayer.isCollidedHorizontally() && thePlayer.isOnLadder())
/*     */       
/*  73 */       { event.setY(0.1649D);
/*  74 */         thePlayer.setMotionY(0.0D);
/*     */          }
/*     */       
/*  77 */       else if (StringsKt.equals(mode, "AAC3.1.2", true) && thePlayer.isCollidedHorizontally() && thePlayer.isOnLadder())
/*     */       
/*  79 */       { event.setY(0.1699D);
/*  80 */         thePlayer.setMotionY(0.0D);
/*     */          }
/*     */       
/*  83 */       else if (StringsKt.equals(mode, "Clip", true) && thePlayer.isOnLadder() && MinecraftInstance.mc.getGameSettings().getKeyBindForward().isKeyDown())
/*  84 */       { int i = (int)thePlayer.getPosY(), j = (int)thePlayer.getPosY() + 8; if (i <= j)
/*  85 */           while (true) { IBlock block = BlockUtils.getBlock(new WBlockPos(thePlayer.getPosX(), i, thePlayer.getPosZ()));
/*     */             
/*  87 */             if (!MinecraftInstance.classProvider.isBlockLadder(block)) {
/*  88 */               double x = 0.0D;
/*  89 */               double z = 0.0D;
/*  90 */               IEnumFacing horizontalFacing = thePlayer.getHorizontalFacing();
/*     */ 
/*     */               
/*  93 */               if (horizontalFacing.isNorth()) { z = -1.0D; }
/*  94 */               else if (horizontalFacing.isEast()) { x = 1.0D; }
/*  95 */               else if (horizontalFacing.isSouth()) { z = 1.0D; }
/*  96 */               else if (horizontalFacing.isWest()) { x = -1.0D; }
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 101 */               thePlayer.setPosition(thePlayer.getPosX() + x, i, thePlayer.getPosZ() + z);
/*     */               break;
/*     */             } 
/* 104 */             thePlayer.setPosition(thePlayer.getPosX(), i, thePlayer.getPosZ()); if (i != j) {
/*     */               i++; continue;
/*     */             } 
/*     */             break; }
/*     */             }
/*     */       
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); }
/* 113 */   @NotNull public final ListValue getModeValue() { return this.modeValue; } private final FloatValue speedValue = new FloatValue("Speed", 0.2872F, 0.01F, 5.0F); @EventTarget public final void onBlockBB(@NotNull BlockBBEvent event) { Intrinsics.checkParameterIsNotNull(event, "event");
/* 114 */     if (MinecraftInstance.mc.getThePlayer() != null && (MinecraftInstance.classProvider.isBlockLadder(event.getBlock()) || MinecraftInstance.classProvider.isBlockVine(event.getBlock())) && StringsKt.equals((String)this.modeValue.get(), "AAC3.0.5", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isOnLadder())
/* 115 */         event.setBoundingBox((IAxisAlignedBB)null);  }
/*     */      }
/*     */    @NotNull
/*     */   public String getTag() {
/* 119 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\FastClimb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */