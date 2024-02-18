/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ import java.awt.Color;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.ClickBlockEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "CivBreak", description = "Allows you to break blocks instantly.", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\007J\020\020\022\032\0020\0172\006\020\020\032\0020\023H\007J\020\020\024\032\0020\0172\006\020\020\032\0020\025H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\020\020\005\032\004\030\0010\006X\016¢\006\002\n\000R\020\020\007\032\004\030\0010\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/CivBreak;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "airResetValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "enumFacing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "range", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "rangeResetValue", "rotationsValue", "visualSwingValue", "onBlockClick", "", "event", "Lnet/ccbluex/liquidbounce/event/ClickBlockEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "XSJClient"})
/*    */ public final class CivBreak extends Module {
/*    */   private WBlockPos blockPos;
/* 23 */   private final FloatValue range = new FloatValue("Range", 5.0F, 1.0F, 6.0F); private IEnumFacing enumFacing;
/* 24 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/* 25 */   private final BoolValue visualSwingValue = new BoolValue("VisualSwing", true);
/*    */   
/* 27 */   private final BoolValue airResetValue = new BoolValue("Air-Reset", true);
/* 28 */   private final BoolValue rangeResetValue = new BoolValue("Range-Reset", true);
/*    */   
/*    */   @EventTarget
/*    */   public final void onBlockClick(@NotNull ClickBlockEvent event)
/*    */   {
/* 33 */     Intrinsics.checkParameterIsNotNull(event, "event"); WBlockPos wBlockPos1 = event.getClickedBlock(); IClassProvider iClassProvider = MinecraftInstance.classProvider; boolean bool1 = false, bool2 = false; WBlockPos it = wBlockPos1; int $i$a$-let-CivBreak$onBlockClick$1 = 0; IBlock iBlock = BlockUtils.getBlock(it); event.getClickedBlock(); if (MinecraftInstance.classProvider.isBlockBedrock((event.getClickedBlock() != null) ? iBlock : null)) {
/*    */       return;
/*    */     }
/* 36 */     if (event.getClickedBlock() != null) { this.blockPos = event.getClickedBlock();
/* 37 */       if (event.getWEnumFacing() != null) { this.enumFacing = event.getWEnumFacing();
/*    */ 
/*    */         
/* 40 */         if (this.blockPos == null) Intrinsics.throwNpe();  if (this.enumFacing == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.START_DESTROY_BLOCK, this.blockPos, this.enumFacing));
/* 41 */         if (this.blockPos == null) Intrinsics.throwNpe();  if (this.enumFacing == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.STOP_DESTROY_BLOCK, this.blockPos, this.enumFacing)); return; }
/*    */       
/*    */       event.getWEnumFacing();
/*    */       return; }
/*    */     
/* 46 */     event.getClickedBlock(); } @EventTarget public final void onUpdate(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (this.blockPos != null) { WBlockPos pos = this.blockPos;
/*    */       
/* 48 */       if ((((Boolean)this.airResetValue.get()).booleanValue() && MinecraftInstance.classProvider.isBlockAir(BlockUtils.getBlock(pos))) || ((
/* 49 */         (Boolean)this.rangeResetValue.get()).booleanValue() && BlockUtils.getCenterDistance(pos) > ((Number)this.range.get()).doubleValue())) {
/* 50 */         this.blockPos = (WBlockPos)null;
/*    */         
/*    */         return;
/*    */       } 
/* 54 */       if (MinecraftInstance.classProvider.isBlockAir(BlockUtils.getBlock(pos)) || BlockUtils.getCenterDistance(pos) > ((Number)this.range.get()).doubleValue()) {
/*    */         return;
/*    */       }
/* 57 */       switch (CivBreak$WhenMappings.$EnumSwitchMapping$0[event.getEventState().ordinal()]) { case 1:
/* 58 */           if (((Boolean)this.rotationsValue.get()).booleanValue()) {
/* 59 */             if (RotationUtils.faceBlock(pos) != null) { RotationUtils.setTargetRotation(RotationUtils.faceBlock(pos).getRotation()); break; }  RotationUtils.faceBlock(pos); return;
/*    */           }  break;
/*    */         case 2:
/* 62 */           if (((Boolean)this.visualSwingValue.get()).booleanValue()) {
/* 63 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().swingItem();
/*    */           } else {
/* 65 */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketAnimation());
/*    */           } 
/*    */ 
/*    */           
/* 69 */           if (this.blockPos == null) Intrinsics.throwNpe();  if (this.enumFacing == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.START_DESTROY_BLOCK, this.blockPos, this.enumFacing));
/*    */           
/* 71 */           if (this.blockPos == null) Intrinsics.throwNpe();  if (this.enumFacing == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.STOP_DESTROY_BLOCK, this.blockPos, this.enumFacing));
/* 72 */           if (this.blockPos == null) Intrinsics.throwNpe();  if (this.enumFacing == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getPlayerController().clickBlock(this.blockPos, this.enumFacing);
/*    */           break; }
/*    */       
/*    */       return; }
/*    */      }
/*    */    @EventTarget
/*    */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 79 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.blockPos != null) { RenderUtils.drawBlockBox(this.blockPos, Color.RED, true);
/*    */       return; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\CivBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */