/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "SpeedMine", description = "faq", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\007\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\023\032\0020\0242\006\020\025\032\0020\026H\007J\022\020\027\032\0020\0242\b\020\025\032\004\030\0010\030H\007R\034\020\003\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000R\034\020\r\032\004\030\0010\016X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/SpeedMine;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "blockPos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getBlockPos", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "setBlockPos", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)V", "bzs", "", "bzx", "", "facing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "getFacing", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "setFacing", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class SpeedMine extends Module {
/*    */   private boolean bzs;
/*    */   private float bzx;
/*    */   
/*    */   @Nullable
/* 20 */   public final WBlockPos getBlockPos() { return this.blockPos; } @Nullable private WBlockPos blockPos; @Nullable private IEnumFacing facing; public final void setBlockPos(@Nullable WBlockPos <set-?>) { this.blockPos = <set-?>; } @Nullable
/* 21 */   public final IEnumFacing getFacing() { return this.facing; } public final void setFacing(@Nullable IEnumFacing <set-?>) { this.facing = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 25 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 26 */     if (MinecraftInstance.classProvider.isCPacketPlayerDigging(packet)) {
/* 27 */       IPacket packets = (IPacket)packet.asCPacketPlayerDigging();
/* 28 */       if (packet.asCPacketPlayerDigging().getAction() == ICPacketPlayerDigging.WAction.START_DESTROY_BLOCK) {
/* 29 */         this.bzs = true;
/* 30 */         this.blockPos = packets.asCPacketPlayerDigging().getPosition();
/* 31 */         this.facing = packet.asCPacketPlayerDigging().getFacing();
/* 32 */         this.bzx = 0.0F;
/* 33 */       } else if (packet.asCPacketPlayerDigging().getAction() == ICPacketPlayerDigging.WAction.ABORT_DESTROY_BLOCK || packet.asCPacketPlayerDigging().getAction() == ICPacketPlayerDigging.WAction.STOP_DESTROY_BLOCK) {
/* 34 */         this.bzs = false;
/* 35 */         this.blockPos = (WBlockPos)null;
/* 36 */         this.facing = (IEnumFacing)null;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 43 */     if (MinecraftInstance.mc.getPlayerController().extendedReach()) {
/* 44 */       MinecraftInstance.mc.getPlayerController().setBlockHitDelay(0);
/* 45 */     } else if (this.bzs) {
/* 46 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (this.blockPos == null) Intrinsics.throwNpe();  IBlock block = MinecraftInstance.mc.getTheWorld().getBlockState(this.blockPos).getBlock();
/* 47 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (this.blockPos == null) Intrinsics.throwNpe();  this.bzx += (float)(block.getPlayerRelativeBlockHardness(MinecraftInstance.mc.getThePlayer(), (IWorld)MinecraftInstance.mc.getTheWorld(), this.blockPos) * 1.4D);
/* 48 */       if (this.bzx >= 1.0F) {
/* 49 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150350_a, "Blocks.AIR"); MinecraftInstance.mc.getTheWorld().setBlockState(this.blockPos, Blocks.field_150350_a.func_176223_P(), 11);
/* 50 */         if (this.blockPos == null) Intrinsics.throwNpe();  if (this.facing == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.STOP_DESTROY_BLOCK, this.blockPos, this.facing));
/* 51 */         this.bzx = 0.0F;
/* 52 */         this.bzs = false;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\SpeedMine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */