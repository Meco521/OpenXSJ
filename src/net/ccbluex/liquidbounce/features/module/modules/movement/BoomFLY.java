/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "BoomFLY", category = ModuleCategory.MOVEMENT, description = "爆炸伤害飞行")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\b\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\r\032\0020\016H\026J\016\020\017\032\0020\0162\006\020\020\032\0020\021J\020\020\022\032\0020\0162\006\020\020\032\0020\023H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\016\020\t\032\0020\nX\016¢\006\002\n\000R\016\020\013\032\0020\nX\016¢\006\002\n\000R\016\020\f\032\0020\004X\016¢\006\002\n\000¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/BoomFLY;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "hasReported", "", "getHasReported", "()Z", "setHasReported", "(Z)V", "s", "", "tick", "velocitypacket", "onEnable", "", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class BoomFLY extends Module {
/*    */   private int tick;
/*    */   private int s;
/*    */   
/* 21 */   public final boolean getHasReported() { return this.hasReported; } private boolean hasReported; private boolean velocitypacket; public final void setHasReported(boolean <set-?>) { this.hasReported = <set-?>; }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 26 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 27 */       int i; this.tick = (i = this.tick) + 1;
/*    */     } else {
/* 29 */       this.tick = 0;
/* 30 */       this.s = 0;
/*    */     } 
/* 32 */     if (this.tick >= 20) {
/* 33 */       this.s++;
/* 34 */       this.tick = 0;
/* 35 */       this.hasReported = false;
/*    */     } 
/* 37 */     if (this.s >= 1 && !this.hasReported) {
/* 38 */       ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§b§d您已飞行了" + this.s + '秒');
/* 39 */       this.hasReported = true;
/*    */     } 
/* 41 */     if (this.velocitypacket) {
/* 42 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setPositionAndRotation(MinecraftInstance.mc.getThePlayer().getPosX() + 50, MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ() + 50, MinecraftInstance.mc.getThePlayer().getRotationYaw(), MinecraftInstance.mc.getThePlayer().getRotationPitch());
/* 43 */       this.velocitypacket = false;
/*    */     } 
/*    */   }
/*    */   public void onEnable() {
/* 47 */     this.velocitypacket = false;
/*    */   }
/*    */   
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 51 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*    */     
/* 53 */     if (packet instanceof net.minecraft.network.play.server.SPacketExplosion)
/* 54 */       this.velocitypacket = true; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\BoomFLY.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */