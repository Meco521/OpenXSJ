/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "HytSpeed", description = "AsOne & 司马人", category = ModuleCategory.HYT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\b\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\032\032\0020\033J\b\020\034\032\0020\033H\026J\b\020\035\032\0020\033H\026J\020\020\036\032\0020\0332\006\020\037\032\0020 H\007J\022\020!\032\0020\0332\b\020\037\032\004\030\0010\"H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\016\020\t\032\0020\nX\004¢\006\002\n\000R\027\020\013\032\b\022\004\022\0020\r0\f¢\006\b\n\000\032\004\b\016\020\017R\016\020\020\032\0020\nX\004¢\006\002\n\000R\032\020\021\032\0020\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R\032\020\027\032\0020\022X\016¢\006\016\n\000\032\004\b\030\020\024\"\004\b\031\020\026¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytSpeed;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "doAsFly", "", "getDoAsFly", "()Z", "setDoAsFly", "(Z)V", "motionY", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "packets", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "getPackets", "()Ljava/util/concurrent/LinkedBlockingQueue;", "speed", "stage", "", "getStage", "()I", "setStage", "(I)V", "timer", "getTimer", "setTimer", "move", "", "onDisable", "onEnable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class HytSpeed extends Module {
/* 20 */   private final FloatValue speed = new FloatValue("Speed", 0.5F, 0.15F, 8.0F); private boolean doAsFly; private int stage;
/* 21 */   private final FloatValue motionY = new FloatValue("MotionY", 0.42F, 0.1F, 2.0F); private int timer; public final boolean getDoAsFly() {
/* 22 */     return this.doAsFly; } public final void setDoAsFly(boolean <set-?>) { this.doAsFly = <set-?>; }
/* 23 */   public final int getStage() { return this.stage; } public final void setStage(int <set-?>) { this.stage = <set-?>; }
/* 24 */   public final int getTimer() { return this.timer; } public final void setTimer(int <set-?>) { this.timer = <set-?>; } @NotNull
/* 25 */   private final LinkedBlockingQueue<IPacket> packets = new LinkedBlockingQueue<>(); @NotNull public final LinkedBlockingQueue<IPacket> getPackets() { return this.packets; }
/*    */   
/*    */   public final void move() {
/* 28 */     if (MovementUtils.isMoving()) {
/* 29 */       MovementUtils.strafe(((Number)this.speed.get()).floatValue());
/* 30 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(((Number)this.motionY.get()).floatValue());
/*    */       
/* 32 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double dir = (MinecraftInstance.mc.getThePlayer().getRotationYaw() / '´') * Math.PI;
/* 33 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionY() < false) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(-0.05D); }
/* 34 */        if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP iEntityPlayerSP = MinecraftInstance.mc.getThePlayer(); boolean bool = false; double d1 = Math.sin(dir); iEntityPlayerSP.setMotionX(-d1 * ((Number)this.speed.get()).doubleValue());
/* 35 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  iEntityPlayerSP = MinecraftInstance.mc.getThePlayer(); bool = false; d1 = Math.cos(dir); iEntityPlayerSP.setMotionZ(d1 * ((Number)this.speed.get()).doubleValue());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 41 */     this.timer = 0;
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 45 */     this.doAsFly = false;
/* 46 */     if (this.packets.size() > 0) {
/* 47 */       for (IPacket packet : this.packets) {
/* 48 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(packet, "packet"); MinecraftInstance.mc.getThePlayer().getSendQueue().addToSendQueue(packet);
/* 49 */         this.packets.remove(packet);
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 56 */     if (!MovementUtils.isMoving()) { this.timer = 0; } else { int i; this.timer = (i = this.timer) + 1; }
/* 57 */      if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && this.timer > 1) {
/* 58 */       this.doAsFly = true;
/* 59 */       this.stage = 0;
/* 60 */       move();
/*    */     } 
/* 62 */     if (this.stage >= 1) {
/* 63 */       this.doAsFly = false;
/* 64 */       if (this.packets.size() > 0) {
/* 65 */         for (IPacket packet : this.packets) {
/* 66 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(packet, "packet"); MinecraftInstance.mc.getThePlayer().getSendQueue().addToSendQueue(packet);
/* 67 */           this.packets.remove(packet);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 75 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (!this.doAsFly)
/* 76 */       return;  IPacket packet = event.getPacket();
/* 77 */     if (MinecraftInstance.classProvider.isCPacketPlayerPosition(packet) || MinecraftInstance.classProvider.isCPacketPlayerPosLook(packet) || MinecraftInstance.classProvider.isCPacketPlayer(
/* 78 */         packet)) {
/*    */ 
/*    */       
/* 81 */       event.cancelEvent();
/* 82 */       this.packets.add(packet); int i;
/* 83 */       this.stage = (i = this.stage) + 1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytSpeed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */