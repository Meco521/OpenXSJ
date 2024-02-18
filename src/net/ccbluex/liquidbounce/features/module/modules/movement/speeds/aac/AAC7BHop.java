/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\026J\b\020\b\032\0020\004H\026¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC7BHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AAC7BHop extends SpeedMode {
/*    */   public AAC7BHop() {
/*  9 */     super("AAC7BHop");
/*    */   } public void onUpdate() {
/* 11 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 13 */       if (!MovementUtils.isMoving() || thePlayer.getRidingEntity() != null || thePlayer.getHurtTime() > 0) {
/*    */         return;
/*    */       }
/* 16 */       if (thePlayer.getOnGround()) {
/* 17 */         thePlayer.jump();
/* 18 */         thePlayer.setMotionY(0.405D);
/* 19 */         thePlayer.setMotionX(thePlayer.getMotionX() * 1.004D);
/* 20 */         thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.004D);
/*    */         
/*    */         return;
/*    */       } 
/* 24 */       double speed = MovementUtils.INSTANCE.getSpeed() * 1.0072D;
/* 25 */       double yaw = Math.toRadians(thePlayer.getRotationYaw());
/*    */       
/* 27 */       IEntityPlayerSP iEntityPlayerSP1 = thePlayer; boolean bool = false; double d1 = Math.sin(yaw); iEntityPlayerSP1.setMotionX(-d1 * speed);
/* 28 */       iEntityPlayerSP1 = thePlayer; bool = false; d1 = Math.cos(yaw); iEntityPlayerSP1.setMotionZ(d1 * speed);
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   } public void onMotion() {} public void onMove(@NotNull MoveEvent event) {
/* 33 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC7BHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */