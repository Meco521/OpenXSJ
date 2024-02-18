/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import java.util.LinkedList;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.network.play.server.SPacketEntityVelocity;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "Velocit", description = "Grim", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\b\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\004\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\030\032\0020\031H\026J\b\020\032\032\0020\031H\026J\020\020\033\032\0020\0312\006\020\034\032\0020\035H\007J\020\020\036\032\0020\0312\006\020\034\032\0020\037H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\016\022\n\022\b\022\004\022\0020\0170\0160\rX\004¢\006\002\n\000R\030\020\020\032\f\022\b\022\006\022\002\b\0030\0160\021X\004¢\006\002\n\000R\016\020\022\032\0020\004X\016¢\006\002\n\000R\024\020\023\032\0020\0248VX\004¢\006\006\032\004\b\025\020\026R\016\020\027\032\0020\004X\016¢\006\002\n\000¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/GrimVelocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "cancelPackets", "", "getCancelPackets", "()I", "setCancelPackets", "(I)V", "grimTCancel", "getGrimTCancel", "setGrimTCancel", "inBus", "Ljava/util/LinkedList;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "packets", "Ljava/util/concurrent/LinkedBlockingQueue;", "resetPersec", "tag", "", "getTag", "()Ljava/lang/String;", "updates", "onDisable", "", "onEnable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class GrimVelocity extends Module {
/*     */   private int grimTCancel;
/*  23 */   private int cancelPackets = 2; public final int getCancelPackets() { return this.cancelPackets; } public final void setCancelPackets(int <set-?>) { this.cancelPackets = <set-?>; }
/*  24 */   public final int getGrimTCancel() { return this.grimTCancel; } public final void setGrimTCancel(int <set-?>) { this.grimTCancel = <set-?>; }
/*     */   
/*  26 */   private int resetPersec = 8;
/*     */   private int updates;
/*  28 */   private final LinkedList<Packet<INetHandlerPlayClient>> inBus = new LinkedList<>();
/*  29 */   private final LinkedBlockingQueue<Packet<?>> packets = new LinkedBlockingQueue<>();
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  33 */     if (MinecraftInstance.mc.getThePlayer() == null)
/*  34 */       return;  this.grimTCancel = 0;
/*  35 */     this.inBus.clear();
/*     */   }
/*     */   public void onDisable() {
/*  38 */     if (MinecraftInstance.mc.getThePlayer() == null)
/*  39 */       return;  this.grimTCancel = 0;
/*  40 */     this.inBus.clear();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  45 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null)
/*  46 */       return;  if (MinecraftInstance.mc.getTheWorld() == null)
/*  47 */       return;  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isDead())
/*     */       return; 
/*  49 */     IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
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
/* 105 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet<?> packet = ((PacketImpl)$this$unwrap$iv).getWrapped();
/*     */     if (packet instanceof SPacketEntityVelocity)
/*     */       if (MinecraftInstance.mc.getTheWorld() != null && MinecraftInstance.mc.getTheWorld().getEntityByID(((SPacketEntityVelocity)packet).func_149412_c()) != null) {
/*     */         if ((Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getEntityByID(((SPacketEntityVelocity)packet).func_149412_c()), MinecraftInstance.mc.getThePlayer()) ^ true) != 0)
/*     */           return; 
/*     */         event.cancelEvent();
/*     */         this.grimTCancel = this.cancelPackets;
/*     */       } else {
/*     */         MinecraftInstance.mc.getTheWorld().getEntityByID(((SPacketEntityVelocity)packet).func_149412_c());
/*     */         return;
/*     */       }  
/*     */     if (packet instanceof net.minecraft.network.play.server.SPacketExplosion) {
/*     */       event.cancelEvent();
/*     */       this.grimTCancel = this.cancelPackets;
/*     */     } 
/*     */     if (this.grimTCancel > 0) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         return; 
/*     */       if (packet instanceof net.minecraft.network.play.client.CPacketPlayer)
/*     */         event.cancelEvent(); 
/*     */       if (packet instanceof net.minecraft.network.play.client.CPacketPlayer.Position || packet instanceof net.minecraft.network.play.client.CPacketPlayer.PositionRotation || packet instanceof net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock || packet instanceof net.minecraft.network.play.client.CPacketAnimation || packet instanceof net.minecraft.network.play.client.CPacketEntityAction || packet instanceof net.minecraft.network.play.client.CPacketUseEntity) {
/*     */         event.cancelEvent();
/*     */         this.packets.add(packet);
/*     */       } 
/*     */       if (packet instanceof net.minecraft.network.play.server.SPacketConfirmTransaction || packet instanceof net.minecraft.network.play.server.SPacketPlayerAbilities) {
/*     */         event.cancelEvent();
/*     */         this.inBus.add(packet);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     int i;
/*     */     this.updates = (i = this.updates) + 1;
/*     */     if (this.resetPersec > 0 && this.updates >= 0) {
/*     */       this.updates = 0;
/*     */       if (this.grimTCancel > 0)
/*     */         this.grimTCancel = (i = this.grimTCancel) + -1; 
/*     */     } 
/*     */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */     if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */       return; 
/*     */     if (this.grimTCancel == 0) {
/*     */       while (!this.packets.isEmpty()) {
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_147114_u(), "mc2.connection!!");
/*     */         MinecraftInstance.mc2.func_147114_u().func_147298_b().func_179290_a(this.packets.take());
/*     */       } 
/*     */       while (!this.inBus.isEmpty()) {
/*     */         if ((Packet)this.inBus.poll() != null) {
/*     */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */           if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */             Intrinsics.throwNpe(); 
/*     */           ((Packet)this.inBus.poll()).func_148833_a((INetHandler)MinecraftInstance.mc2.func_147114_u());
/*     */           continue;
/*     */         } 
/*     */         (Packet)this.inBus.poll();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return "Grim";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\GrimVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */