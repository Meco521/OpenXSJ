/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Aura3RangeHelper", description = "智能控制杀戮range但是help的是Killaura3", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\007\n\002\b\b\n\002\030\002\n\002\b\b\n\002\020\b\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020'\032\0020(2\006\020)\032\0020*H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\016\020\t\032\0020\nX\004¢\006\002\n\000R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006R\021\020\r\032\0020\004¢\006\b\n\000\032\004\b\016\020\006R\032\020\017\032\0020\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\032\020\025\032\0020\020X\016¢\006\016\n\000\032\004\b\026\020\022\"\004\b\027\020\024R\016\020\030\032\0020\031X\004¢\006\002\n\000R\016\020\032\032\0020\031X\004¢\006\002\n\000R\032\020\033\032\0020\020X\016¢\006\016\n\000\032\004\b\034\020\022\"\004\b\035\020\024R\032\020\036\032\0020\020X\016¢\006\016\n\000\032\004\b\037\020\022\"\004\b \020\024R\032\020!\032\0020\"X\016¢\006\016\n\000\032\004\b#\020$\"\004\b%\020&¨\006+"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Aura3RangeHelper;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AirFov", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getAirFov", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "AirRange", "getAirRange", "Debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "GroundFov", "getGroundFov", "GroundRange", "getGroundRange", "fovGround", "", "getFovGround", "()F", "setFovGround", "(F)V", "fovair", "getFovair", "setFovair", "hurttime", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "hurttime2", "kaGround", "getKaGround", "setKaGround", "kaair", "getKaair", "setKaair", "ticks", "", "getTicks", "()I", "setTicks", "(I)V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Aura3RangeHelper extends Module {
/* 17 */   private final IntegerValue hurttime = new IntegerValue("hurttime", 9, 1, 10);
/* 18 */   private final IntegerValue hurttime2 = new IntegerValue("hurttime2", 10, 1, 10); @NotNull
/* 19 */   private final FloatValue AirRange = new FloatValue("AirRange", 3.0F, 0.0F, 5.0F); @NotNull public final FloatValue getAirRange() { return this.AirRange; }
/* 20 */    private float kaair = ((Number)this.AirRange.get()).floatValue(); public final float getKaair() { return this.kaair; } public final void setKaair(float <set-?>) { this.kaair = <set-?>; } @NotNull
/* 21 */   private final FloatValue GroundRange = new FloatValue("GroundRange", 3.5F, 0.0F, 5.0F); @NotNull public final FloatValue getGroundRange() { return this.GroundRange; }
/* 22 */    private float kaGround = ((Number)this.GroundRange.get()).floatValue(); public final float getKaGround() { return this.kaGround; } public final void setKaGround(float <set-?>) { this.kaGround = <set-?>; } @NotNull
/* 23 */   private final FloatValue AirFov = new FloatValue("AirFov", 180.0F, 0.0F, 180.0F); @NotNull public final FloatValue getAirFov() { return this.AirFov; }
/* 24 */    private float fovair = ((Number)this.AirFov.get()).floatValue(); public final float getFovair() { return this.fovair; } public final void setFovair(float <set-?>) { this.fovair = <set-?>; } @NotNull
/* 25 */   private final FloatValue GroundFov = new FloatValue("GroundFov", 180.0F, 0.0F, 180.0F); @NotNull public final FloatValue getGroundFov() { return this.GroundFov; }
/* 26 */    private float fovGround = ((Number)this.GroundFov.get()).floatValue(); public final float getFovGround() { return this.fovGround; } public final void setFovGround(float <set-?>) { this.fovGround = <set-?>; }
/* 27 */    private final BoolValue Debug = new BoolValue("Debug", true);
/* 28 */   private int ticks; public final int getTicks() { return this.ticks; } public final void setTicks(int <set-?>) { this.ticks = <set-?>; }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 32 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isAirBorne()) {
/* 33 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 34 */       killAura.getRangeValue().set(this.AirRange.get());
/* 35 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 36 */         ClientUtils.displayChatMessage("Kafix -> set ka range " + String.valueOf(((Number)this.AirRange.getValue()).floatValue()));
/*    */       }
/*    */     } 
/* 39 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 40 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 41 */       killAura.getRangeValue().set(this.GroundRange.get());
/* 42 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 43 */         ClientUtils.displayChatMessage("Kafix -> set ka range " + String.valueOf(((Number)this.GroundRange.getValue()).floatValue()));
/*    */       }
/*    */     } 
/*    */     
/* 47 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isAirBorne()) {
/* 48 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura3.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura3");  KillAura3 killAura3 = (KillAura3)Retreat.INSTANCE.getModuleManager().get(KillAura3.class);
/* 49 */       killAura3.getFovValue().set(this.AirFov.get());
/* 50 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 51 */         ClientUtils.displayChatMessage("Kafix -> set ka fov " + String.valueOf(((Number)this.AirFov.getValue()).floatValue()));
/*    */       }
/*    */     } 
/* 54 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 55 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura3.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura3");  KillAura3 killAura3 = (KillAura3)Retreat.INSTANCE.getModuleManager().get(KillAura3.class);
/* 56 */       killAura3.getFovValue().set(this.GroundFov.get());
/* 57 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 58 */         ClientUtils.displayChatMessage("Kafix -> set ka fov " + String.valueOf(((Number)this.GroundFov.getValue()).floatValue()));
/*    */       }
/*    */     } 
/*    */     int i;
/* 62 */     this.ticks = (i = this.ticks) + 1;
/* 63 */     if (this.ticks == 1) {
/* 64 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 65 */       killAura.getHurtTimeValue().set(this.hurttime.get());
/* 66 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 67 */         ClientUtils.displayChatMessage("Kafix -> set ka hurttime " + String.valueOf(((Number)this.hurttime.getValue()).intValue()));
/*    */       }
/*    */     } 
/* 70 */     if (this.ticks == 2) {
/* 71 */       if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 72 */       killAura.getHurtTimeValue().set(this.hurttime2.get());
/* 73 */       if (((Boolean)this.Debug.get()).booleanValue()) {
/* 74 */         ClientUtils.displayChatMessage("Kafix -> set ka hurttime " + String.valueOf(((Number)this.hurttime2.getValue()).intValue()));
/*    */       }
/*    */     } 
/*    */     
/* 78 */     if (this.ticks == 3)
/* 79 */       this.ticks = 0; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Aura3RangeHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */