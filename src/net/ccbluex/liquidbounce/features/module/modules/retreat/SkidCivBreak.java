/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.ClickBlockEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "SkidCivBreak", description = "kid.", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\007\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\007J\b\020\020\032\0020\rH\026J\020\020\021\032\0020\r2\006\020\016\032\0020\022H\007J\020\020\023\032\0020\r2\006\020\016\032\0020\024H\007J\020\020\025\032\0020\r2\006\020\016\032\0020\026H\007J\020\020\027\032\0020\r2\006\020\016\032\0020\030H\007R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SkidCivBreak;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "breakDamage", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "breaking", "", "range", "speed", "", "onBlockClick", "", "event", "Lnet/ccbluex/liquidbounce/event/ClickBlockEvent;", "onEnable", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class SkidCivBreak extends Module {
/*  25 */   private final FloatValue breakDamage = new FloatValue("BreakDamage", 0.0F, 0.0F, 2.0F);
/*  26 */   private final FloatValue range = new FloatValue("Range", 5.0F, 1.0F, 6.0F);
/*     */   private WBlockPos blockPos;
/*     */   private boolean breaking;
/*     */   private float speed;
/*     */   
/*     */   public void onEnable() {
/*  32 */     this.blockPos = (WBlockPos)null;
/*  33 */     this.breaking = false;
/*  34 */     this.speed = 0.0F;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onBlockClick(@NotNull ClickBlockEvent event) {
/*  39 */     Intrinsics.checkParameterIsNotNull(event, "event"); WBlockPos wBlockPos1 = event.getClickedBlock(); IClassProvider iClassProvider = MinecraftInstance.classProvider; boolean bool1 = false, bool2 = false; WBlockPos it = wBlockPos1; int $i$a$-let-SkidCivBreak$onBlockClick$1 = 0; IBlock iBlock = BlockUtils.getBlock(it); event.getClickedBlock(); if (MinecraftInstance.classProvider.isBlockBedrock((event.getClickedBlock() != null) ? iBlock : null)) {
/*     */       return;
/*     */     }
/*     */     
/*  43 */     this.blockPos = event.getClickedBlock();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  48 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.breaking) {
/*  49 */       float f1, f2 = this.speed; SkidCivBreak skidCivBreak = this; try {
/*  50 */         if (this.blockPos == null) Intrinsics.throwNpe();  if (this.blockPos.getBlock() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (this.blockPos == null) Intrinsics.throwNpe();  f1 = this.blockPos.getBlock().getPlayerRelativeBlockHardness(MinecraftInstance.mc.getThePlayer(), (IWorld)MinecraftInstance.mc.getTheWorld(), this.blockPos);
/*  51 */       } catch (Exception exception) {
/*  52 */         exception.printStackTrace(); return;
/*     */       } 
/*     */       skidCivBreak.speed = f2 + f1;
/*  55 */       if (this.speed > ((Number)this.breakDamage.get()).floatValue()) { if (this.blockPos == null) Intrinsics.throwNpe();  if (BlockUtils.getCenterDistance(this.blockPos) <= ((Number)this.range.get()).doubleValue()) {
/*     */           try {
/*  57 */             if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150350_a, "Blocks.AIR"); MinecraftInstance.mc.getTheWorld().setBlockState(this.blockPos, Blocks.field_150350_a.func_176223_P(), 11);
/*  58 */           } catch (Exception ex) {
/*  59 */             ex.printStackTrace();
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  65 */           if (this.blockPos == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.STOP_DESTROY_BLOCK, this.blockPos, 
/*  66 */                 MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN)));
/*     */         }  }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  76 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*  77 */     if (MinecraftInstance.classProvider.isCPacketPlayerDigging(packet)) {
/*  78 */       if (packet.asCPacketPlayerDigging().getAction() == ICPacketPlayerDigging.WAction.START_DESTROY_BLOCK) {
/*  79 */         this.breaking = true;
/*  80 */         this.speed = 0.0F;
/*     */       } 
/*  82 */       if (packet.asCPacketPlayerDigging().getAction() == ICPacketPlayerDigging.WAction.STOP_DESTROY_BLOCK) {
/*  83 */         this.blockPos = (WBlockPos)null;
/*  84 */         this.breaking = false;
/*  85 */         this.speed = 0.0F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*  92 */     Intrinsics.checkParameterIsNotNull(event, "event"); switch (SkidCivBreak$WhenMappings.$EnumSwitchMapping$0[event.getEventState().ordinal()]) {
/*     */       case 1:
/*  94 */         if (this.breaking) {
/*  95 */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() != null) { MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketConfirmTransaction(0, (short)0, true)); } else { MinecraftInstance.mc2.func_147114_u(); }
/*  96 */            MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketAnimation());
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 104 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.blockPos != null) { RenderUtils.drawBlockBox(this.blockPos, Color.RED, true);
/*     */       return; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\SkidCivBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */