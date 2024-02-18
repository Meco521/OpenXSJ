/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.misc.Reallyhurt;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Silentmode", description = "击退模式", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\025\032\0020\026H\026J\b\020\027\032\0020\026H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006R\016\020\r\032\0020\016X.¢\006\002\n\000R\016\020\017\032\0020\020X.¢\006\002\n\000R\016\020\021\032\0020\022X.¢\006\002\n\000R\016\020\023\032\0020\024X.¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Silentmode;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "BalantairRangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getBalantairRangeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "BalantgroundRangeValue", "getBalantgroundRangeValue", "kbairRangeValue", "getKbairRangeValue", "kbgroundRangeValue", "getKbgroundRangeValue", "killAura", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "reallyhurt", "Lnet/ccbluex/liquidbounce/features/module/modules/misc/Reallyhurt;", "safeauramode", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/Safeauramode;", "superKnockback", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/SuperKnockback;", "onDisable", "", "onEnable", "XSJClient"})
/*    */ public final class Silentmode extends Module {
/*    */   private KillAura killAura;
/*    */   private SuperKnockback superKnockback;
/*    */   private Safeauramode safeauramode;
/*    */   private Reallyhurt reallyhurt;
/*    */   @NotNull
/* 21 */   private final FloatValue kbgroundRangeValue = new FloatValue("KbGroundRange", 3.55F, 1.0F, 8.0F); @NotNull public final FloatValue getKbgroundRangeValue() { return this.kbgroundRangeValue; } @NotNull
/* 22 */   private final FloatValue kbairRangeValue = new FloatValue("KbAirRange", 3.27F, 1.0F, 8.0F); @NotNull public final FloatValue getKbairRangeValue() { return this.kbairRangeValue; } @NotNull
/* 23 */   private final FloatValue BalantgroundRangeValue = new FloatValue("BalantGroundRange", 3.8F, 1.0F, 8.0F); @NotNull public final FloatValue getBalantgroundRangeValue() { return this.BalantgroundRangeValue; } @NotNull
/* 24 */   private final FloatValue BalantairRangeValue = new FloatValue("BalantAirRange", 3.5F, 1.0F, 8.0F); @NotNull public final FloatValue getBalantairRangeValue() { return this.BalantairRangeValue; }
/*    */ 
/*    */   
/*    */   public void onEnable() {
/* 28 */     if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  this.killAura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/* 29 */     if (Retreat.INSTANCE.getModuleManager().getModule(Reallyhurt.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Reallyhurt");  this.reallyhurt = (Reallyhurt)Retreat.INSTANCE.getModuleManager().getModule(Reallyhurt.class);
/* 30 */     if (Retreat.INSTANCE.getModuleManager().getModule(Safeauramode.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Safeauramode");  this.safeauramode = (Safeauramode)Retreat.INSTANCE.getModuleManager().getModule(Safeauramode.class);
/* 31 */     if (Retreat.INSTANCE.getModuleManager().getModule(SuperKnockback.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.SuperKnockback");  this.superKnockback = (SuperKnockback)Retreat.INSTANCE.getModuleManager().getModule(SuperKnockback.class);
/* 32 */     if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  this.killAura.getRotationStrafeValue().set("Silent");
/* 33 */     if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  this.killAura.getSilentfix().set(Boolean.valueOf(true));
/* 34 */     if (this.reallyhurt == null) Intrinsics.throwUninitializedPropertyAccessException("reallyhurt");  this.reallyhurt.getNormalgroundrangeValue().set(this.kbgroundRangeValue.get());
/* 35 */     if (this.reallyhurt == null) Intrinsics.throwUninitializedPropertyAccessException("reallyhurt");  this.reallyhurt.getNormalairrangeValue().set(this.kbairRangeValue.get());
/* 36 */     if (this.safeauramode == null) Intrinsics.throwUninitializedPropertyAccessException("safeauramode");  this.safeauramode.getNormalgroundrangeValue().set(this.kbgroundRangeValue.get());
/* 37 */     if (this.safeauramode == null) Intrinsics.throwUninitializedPropertyAccessException("safeauramode");  this.safeauramode.getNormalairrangeValue().set(this.kbairRangeValue.get());
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 41 */     if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  this.killAura.getRotationStrafeValue().set("Strict");
/* 42 */     if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  this.killAura.getSilentfix().set(Boolean.valueOf(false));
/* 43 */     if (this.reallyhurt == null) Intrinsics.throwUninitializedPropertyAccessException("reallyhurt");  this.reallyhurt.getNormalgroundrangeValue().set(this.BalantgroundRangeValue.get());
/* 44 */     if (this.reallyhurt == null) Intrinsics.throwUninitializedPropertyAccessException("reallyhurt");  this.reallyhurt.getNormalairrangeValue().set(this.BalantairRangeValue.get());
/* 45 */     if (this.safeauramode == null) Intrinsics.throwUninitializedPropertyAccessException("safeauramode");  this.safeauramode.getNormalgroundrangeValue().set(this.BalantgroundRangeValue.get());
/* 46 */     if (this.safeauramode == null) Intrinsics.throwUninitializedPropertyAccessException("safeauramode");  this.safeauramode.getNormalairrangeValue().set(this.BalantairRangeValue.get());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Silentmode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */