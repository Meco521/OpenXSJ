/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Reach", description = "Increases your reach.", category = ModuleCategory.PLAYER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\007\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\n8F¢\006\006\032\004\b\013\020\f¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/Reach;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "buildReachValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getBuildReachValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "combatReachValue", "getCombatReachValue", "maxRange", "", "getMaxRange", "()F", "XSJClient"})
/*    */ public final class Reach extends Module {
/*    */   @NotNull
/* 11 */   private final FloatValue combatReachValue = new FloatValue("CombatReach", 3.5F, 3.0F, 7.0F); @NotNull public final FloatValue getCombatReachValue() { return this.combatReachValue; } @NotNull
/* 12 */   private final FloatValue buildReachValue = new FloatValue("BuildReach", 5.0F, 4.5F, 7.0F); @NotNull public final FloatValue getBuildReachValue() { return this.buildReachValue; }
/*    */ 
/*    */   
/*    */   public final float getMaxRange() {
/* 16 */     float combatRange = ((Number)this.combatReachValue.get()).floatValue();
/* 17 */     float buildRange = ((Number)this.buildReachValue.get()).floatValue();
/*    */     
/* 19 */     return (combatRange > buildRange) ? combatRange : buildRange;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\Reach.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */