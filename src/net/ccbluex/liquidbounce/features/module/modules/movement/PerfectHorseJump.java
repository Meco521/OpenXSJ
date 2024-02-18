/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "PerfectHorseJump", category = ModuleCategory.MOVEMENT, description = "使你的马能有完美跳跃")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/PerfectHorseJump;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class PerfectHorseJump extends Module {
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 19 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 21 */       thePlayer.setHorseJumpPowerCounter(9);
/* 22 */       thePlayer.setHorseJumpPower(1.0F);
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\PerfectHorseJump.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */