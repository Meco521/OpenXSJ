/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "RangeFix", description = "自动调整你的Range", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\013\032\0020\f2\006\020\r\032\0020\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/RangeFix;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AirRange", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "DeBug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "GroundRange", "nomove", "nomoverange", "slow", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class RangeFix extends Module {
/* 19 */   private final BoolValue nomove = new BoolValue("SlowMoveRange", true);
/* 20 */   private final FloatValue nomoverange = new FloatValue("SlowMoveRange", 2.9F, 0.0F, 8.0F);
/* 21 */   private final FloatValue slow = new FloatValue("MaxMoveSpeed", 0.1F, 0.0F, 10.0F);
/* 22 */   private final FloatValue AirRange = new FloatValue("AirRange", 3.3F, 0.0F, 5.0F);
/* 23 */   private final FloatValue GroundRange = new FloatValue("GroundRange", 3.6F, 0.0F, 5.0F);
/* 24 */   private final BoolValue DeBug = new BoolValue("DeBug", false);
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 27 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 28 */     if (Retreat.INSTANCE.getModuleManager().get(KillAura3.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura3");  KillAura3 killAura3 = (KillAura3)Retreat.INSTANCE.getModuleManager().get(KillAura3.class);
/* 29 */     if (!((Boolean)this.nomove.get()).booleanValue() || MovementUtils.INSTANCE.getSpeed() > ((Number)this.slow.get()).floatValue()) {
/* 30 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && ((Number)killAura.getRangeValue().get()).floatValue() != ((Number)this.GroundRange.get()).floatValue()) {
/* 31 */         killAura.getRangeValue().set(this.GroundRange.get());
/* 32 */         killAura3.getRangeValue().set(this.GroundRange.get());
/* 33 */         if (((Boolean)this.DeBug.get()).booleanValue()) {
/* 34 */           ClientUtils.displayChatMessage("§cRangeFix:KillAura Range -> " + ((Number)this.GroundRange.get()).floatValue() + ".");
/*    */         }
/*    */       } 
/* 37 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround() && ((Number)killAura.getRangeValue().get()).floatValue() != ((Number)this.AirRange.get()).floatValue()) {
/* 38 */         killAura.getRangeValue().set(this.AirRange.get());
/* 39 */         killAura3.getRangeValue().set(this.AirRange.get());
/* 40 */         if (((Boolean)this.DeBug.get()).booleanValue()) {
/* 41 */           ClientUtils.displayChatMessage("§cRangeFix:KillAura Range -> " + ((Number)this.AirRange.get()).floatValue() + ".");
/*    */         }
/*    */       } 
/*    */     } 
/* 45 */     if (((Boolean)this.nomove.get()).booleanValue() && MovementUtils.INSTANCE.getSpeed() < ((Number)this.slow.get()).floatValue() && ((Number)killAura.getRangeValue().get()).floatValue() != ((Number)this.nomoverange.get()).floatValue()) {
/* 46 */       killAura.getRangeValue().set(this.nomoverange.get());
/* 47 */       killAura3.getRangeValue().set(this.nomoverange.get());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\RangeFix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */