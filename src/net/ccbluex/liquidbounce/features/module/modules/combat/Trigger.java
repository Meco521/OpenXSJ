/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.Metadata;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Trigger", description = "Automatically attacks the entity you are looking at.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\t\032\0020\n2\006\020\013\032\0020\fH\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\007X\004¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Trigger;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delay", "", "lastSwing", "maxCPS", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "minCPS", "onRender", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class Trigger extends Module {
/* 15 */   private final IntegerValue maxCPS = new Trigger$maxCPS$1("MaxCPS", 8, 1, 20); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/Trigger$maxCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Trigger$maxCPS$1 extends IntegerValue { Trigger$maxCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */      protected void onChanged(int oldValue, int newValue) {
/* 17 */       int i = ((Number)Trigger.this.minCPS.get()).intValue();
/* 18 */       if (i > newValue) set(Integer.valueOf(i)); 
/* 19 */       Trigger.this.delay = TimeUtils.randomClickDelay(((Number)Trigger.this.minCPS.get()).intValue(), ((Number)get()).intValue());
/*    */     } }
/*    */ 
/*    */   
/* 23 */   private final IntegerValue minCPS = new Trigger$minCPS$1("MinCPS", 5, 1, 20); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/Trigger$minCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Trigger$minCPS$1 extends IntegerValue { Trigger$minCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*    */      protected void onChanged(int oldValue, int newValue) {
/* 25 */       int i = ((Number)Trigger.this.maxCPS.get()).intValue();
/* 26 */       if (i < newValue) set(Integer.valueOf(i)); 
/* 27 */       Trigger.this.delay = TimeUtils.randomClickDelay(((Number)get()).intValue(), ((Number)Trigger.this.maxCPS.get()).intValue());
/*    */     } }
/*    */ 
/*    */   
/* 31 */   private long delay = TimeUtils.randomClickDelay(((Number)this.minCPS.get()).intValue(), ((Number)this.maxCPS.get()).intValue());
/*    */   private long lastSwing;
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender(@NotNull Render3DEvent event) {
/* 36 */     Intrinsics.checkParameterIsNotNull(event, "event"); IMovingObjectPosition objectMouseOver = MinecraftInstance.mc.getObjectMouseOver();
/*    */ 
/*    */     
/* 39 */     if (objectMouseOver != null && System.currentTimeMillis() - this.lastSwing >= this.delay && EntityUtils.isSelected(objectMouseOver.getEntityHit(), true)) {
/* 40 */       MinecraftInstance.mc.getGameSettings().getKeyBindAttack().onTick(MinecraftInstance.mc.getGameSettings().getKeyBindAttack().getKeyCode());
/*    */       
/* 42 */       this.lastSwing = System.currentTimeMillis();
/* 43 */       this.delay = TimeUtils.randomClickDelay(((Number)this.minCPS.get()).intValue(), ((Number)this.maxCPS.get()).intValue());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Trigger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */