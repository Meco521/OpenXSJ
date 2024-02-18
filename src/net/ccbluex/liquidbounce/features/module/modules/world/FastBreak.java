/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ 
/*    */ @ModuleInfo(name = "FastBreak", description = "Allows you to break blocks faster.", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/FastBreak;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "breakDamage", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class FastBreak extends Module {
/* 13 */   private final FloatValue breakDamage = new FloatValue("BreakDamage", 0.8F, 0.1F, 1.0F);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 17 */     Intrinsics.checkParameterIsNotNull(event, "event"); MinecraftInstance.mc.getPlayerController().setBlockHitDelay(0);
/*    */     
/* 19 */     if (MinecraftInstance.mc.getPlayerController().getCurBlockDamageMP() > ((Number)this.breakDamage.get()).floatValue()) {
/* 20 */       MinecraftInstance.mc.getPlayerController().setCurBlockDamageMP(1.0F);
/*    */     }
/* 22 */     if (Fucker.INSTANCE.getCurrentDamage() > ((Number)this.breakDamage.get()).floatValue()) {
/* 23 */       Fucker.INSTANCE.setCurrentDamage(1.0F);
/*    */     }
/* 25 */     if (Nuker.Companion.getCurrentDamage() > ((Number)this.breakDamage.get()).floatValue())
/* 26 */       Nuker.Companion.setCurrentDamage(1.0F); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\FastBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */