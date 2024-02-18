/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "TickBase", category = ModuleCategory.COMBAT, description = "攻击冲刺")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\021\032\0020\0222\006\020\023\032\0020\024H\007J\b\020\025\032\0020\022H\026J\b\020\026\032\0020\022H\026J\020\020\027\032\0020\0222\006\020\023\032\0020\030H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000R\021\020\r\032\0020\016¢\006\b\n\000\032\004\b\017\020\020¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/TickBase;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "BoostAmount", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getBoostAmount", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "ChargeAmount", "getChargeAmount", "Debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "ticks", "", "ticksAmount", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getTicksAmount", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onEnable", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class TickBase extends Module {
/*    */   private int ticks;
/* 21 */   private final BoolValue Debug = new BoolValue("debug", false); @NotNull
/* 22 */   private final IntegerValue ticksAmount = new IntegerValue("BoostTicks", 10, 3, 20); @NotNull public final IntegerValue getTicksAmount() { return this.ticksAmount; } @NotNull
/* 23 */   private final FloatValue BoostAmount = new FloatValue("BoostTimer", 10.0F, 1.0F, 50.0F); @NotNull public final FloatValue getBoostAmount() { return this.BoostAmount; } @NotNull
/* 24 */   private final FloatValue ChargeAmount = new FloatValue("ChargeTimer", 0.11F, 0.05F, 1.0F); @NotNull public final FloatValue getChargeAmount() { return this.ChargeAmount; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 28 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.classProvider.isEntityLivingBase(event.getTargetEntity()) && this.ticks == 0) {
/* 29 */       this.ticks = ((Number)this.ticksAmount.get()).intValue();
/* 30 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 31 */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§dAttack");
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onEnable() {
/* 37 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 38 */     if (((Boolean)this.Debug.get()).booleanValue()) {
/* 39 */       ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d复原");
/*    */     }
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 44 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 45 */     if (((Boolean)this.Debug.get()).booleanValue()) {
/* 46 */       ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§d复原");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 53 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.ticks == ((Number)this.ticksAmount.get()).intValue()) {
/* 54 */       MinecraftInstance.mc.getTimer().setTimerSpeed(((Number)this.ChargeAmount.get()).floatValue()); int i;
/* 55 */       this.ticks = (i = this.ticks) + -1;
/* 56 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 57 */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§dtick==CA");
/*    */       }
/* 59 */     } else if (this.ticks > 1) {
/* 60 */       MinecraftInstance.mc.getTimer().setTimerSpeed(((Number)this.BoostAmount.get()).floatValue()); int i;
/* 61 */       this.ticks = (i = this.ticks) + -1;
/* 62 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 63 */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§dtick>1");
/*    */       }
/* 65 */     } else if (this.ticks == 1) {
/* 66 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); int i;
/* 67 */       this.ticks = (i = this.ticks) + -1;
/* 68 */       if (((Boolean)this.Debug.get()).booleanValue())
/* 69 */         ClientUtils.displayChatMessage("§8[§c§lRetreat§8]§c§dtick==1"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\TickBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */