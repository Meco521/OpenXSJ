/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import me.utils.PacketUtils;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.BlinkUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ import net.minecraft.network.play.server.SPacketEntity;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "LegitReach", category = ModuleCategory.COMBAT, description = "合法长臂")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000V\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\025\032\0020\026H\002J\020\020\027\032\0020\0262\006\020\030\032\0020\031H\007J\b\020\032\032\0020\026H\026J\020\020\033\032\0020\0262\006\020\030\032\0020\034H\007J\022\020\035\032\0020\0262\b\020\030\032\004\030\0010\036H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\034\020\005\032\004\030\0010\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\016\020\013\032\0020\fX\004¢\006\002\n\000R\032\020\r\032\016\022\n\022\b\022\004\022\0020\0200\0170\016X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000¨\006\037"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/LegitReach;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aura", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "currentTarget", "Lnet/minecraft/entity/EntityLivingBase;", "getCurrentTarget", "()Lnet/minecraft/entity/EntityLivingBase;", "setCurrentTarget", "(Lnet/minecraft/entity/EntityLivingBase;)V", "mode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "packets", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lnet/minecraft/network/Packet;", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "pulseDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "pulseTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "clearPackets", "", "onAttack", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class LegitReach extends Module {
/* 30 */   private final ListValue mode = new ListValue("Mode", new String[] { "TargetPackets" }, "TargetPackets"); @Nullable
/* 31 */   private EntityLivingBase currentTarget; private final BoolValue aura = new BoolValue("Aura", false); @Nullable
/* 32 */   public final EntityLivingBase getCurrentTarget() { return this.currentTarget; } public final void setCurrentTarget(@Nullable EntityLivingBase <set-?>) { this.currentTarget = <set-?>; }
/* 33 */    private final MSTimer pulseTimer = new MSTimer();
/* 34 */   private final IntegerValue pulseDelayValue = new IntegerValue("PulseDelay", 200, 50, 500);
/*    */   
/* 36 */   private final LinkedBlockingQueue<Packet<INetHandlerPlayClient>> packets = new LinkedBlockingQueue<>();
/*    */   
/*    */   public void onDisable() {
/* 39 */     clearPackets();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private final void clearPackets() {
/* 45 */     while (!this.packets.isEmpty()) {
/* 46 */       if (this.packets.take() == null) throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.Packet<net.minecraft.network.play.INetHandlerPlayClient?>");  PacketUtils.handleSendPacket(this.packets.take());
/*    */     } 
/* 48 */     BlinkUtils.releasePacket$default(BlinkUtils.INSTANCE, null, false, 0, 0, 15, null);
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 53 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.aura.get()).booleanValue()) { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) Intrinsics.throwNpe();  if (!Retreat.INSTANCE.getModuleManager().get(KillAura.class).getState())
/* 54 */         return;  }  if ((Intrinsics.areEqual(event.getTargetEntity(), this.currentTarget) ^ true) != 0) {
/* 55 */       clearPackets();
/* 56 */       this.currentTarget = (EntityLivingBase)event.getTargetEntity();
/*    */     } 
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 61 */     if (((Boolean)this.aura.get()).booleanValue()) { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) Intrinsics.throwNpe();  if (!Retreat.INSTANCE.getModuleManager().get(KillAura.class).getState())
/* 62 */         return;  }  if (this.pulseTimer.hasTimePassed(((Number)this.pulseDelayValue.get()).intValue())) {
/* 63 */       this.pulseTimer.reset();
/* 64 */       clearPackets();
/*    */     } 
/*    */   }
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 69 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/* 70 */     if (((Boolean)this.aura.get()).booleanValue()) { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) Intrinsics.throwNpe();  if (!Retreat.INSTANCE.getModuleManager().get(KillAura.class).getState())
/*    */         return;  }
/* 72 */      if (this.mode.equals("TargetPackets") && 
/* 73 */       packet instanceof SPacketEntity && Retreat.INSTANCE.getCombatManager().getInCombat() && 
/* 74 */       Intrinsics.areEqual(((SPacketEntity)packet).func_149065_a((World)MinecraftInstance.mc2.field_71441_e), this.currentTarget)) {
/* 75 */       event.cancelEvent();
/* 76 */       this.packets.add((Packet<INetHandlerPlayClient>)packet);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\LegitReach.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */