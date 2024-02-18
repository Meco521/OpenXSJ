/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.vulcan;
/*    */ import java.util.Objects;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventState;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\026J\b\020\b\032\0020\006H\026J\016\020\b\032\0020\0062\006\020\t\032\0020\nJ\020\020\013\032\0020\0062\006\020\t\032\0020\fH\026J\b\020\r\032\0020\006H\026J\b\020\016\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/vulcan/VulcanHop2;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "groundTick", "", "onDisable", "", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class VulcanHop2 extends SpeedMode {
/*    */   public VulcanHop2() {
/* 18 */     super("VulcanHop2");
/*    */   } private int groundTick;
/*    */   public void onTick() {}
/*    */   public void onMotion() {}
/*    */   public final void onMotion(@NotNull MotionEvent event) {
/* 23 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (Retreat.INSTANCE.getModuleManager().getModule(Speed.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.movement.Speed");  Speed speed = (Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class);
/* 24 */     if (speed == null || event.getEventState() != EventState.PRE)
/* 25 */       return;  int L = 0;
/* 26 */     if (MovementUtils.isMoving()) {
/* 27 */       if (Objects.requireNonNull(MinecraftInstance.mc.getThePlayer()) == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getTimer().setTimerSpeed((Objects.requireNonNull(MinecraftInstance.mc.getThePlayer()).getMotionY() > false) ? 1.65F : 0.73F);
/* 28 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 29 */         if (this.groundTick >= 0) {
/* 30 */           MovementUtils.strafe(0.483F);
/*    */         }
/* 32 */         if (0.42D != 0.0D) {
/* 33 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.42D);
/*    */         }  int i;
/* 35 */         this.groundTick = (i = this.groundTick) + 1;
/*    */       } else {
/* 37 */         this.groundTick = 0;
/* 38 */         L += (int)0.0D;
/* 39 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(L);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onEnable() {
/* 45 */     super.onEnable();
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 49 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 50 */     super.onDisable();
/*    */   }
/*    */   public void onUpdate() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 54 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\vulcan\VulcanHop2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */