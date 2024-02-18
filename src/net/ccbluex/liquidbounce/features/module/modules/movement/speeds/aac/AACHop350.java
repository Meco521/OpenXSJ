/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\b\020\004\032\0020\005H\026J\b\020\006\032\0020\007H\026J\b\020\b\032\0020\007H\026J\b\020\t\032\0020\007H\026J\020\020\t\032\0020\0072\006\020\n\032\0020\013H\007J\020\020\f\032\0020\0072\006\020\n\032\0020\rH\026J\b\020\016\032\0020\007H\026¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACHop350;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "handleEvents", "", "onDisable", "", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACHop350 extends SpeedMode implements Listenable {
/*    */   public AACHop350() {
/*  8 */     super("AACHop3.5.0");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 51 */     Retreat.INSTANCE.getEventManager().registerListener(this);
/*    */   }
/*    */   
/*    */   public void onMotion() {}
/*    */   
/*    */   public void onUpdate() {}
/*    */   
/*    */   public void onMove(@NotNull MoveEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onMotion(@NotNull MotionEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*    */       IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       if (event.getEventState() == EventState.POST && MovementUtils.isMoving() && !thePlayer.isInWater() && !thePlayer.isInLava()) {
/*    */         thePlayer.setJumpMovementFactor(thePlayer.getJumpMovementFactor() + 0.00208F);
/*    */         if (thePlayer.getFallDistance() <= 1.0F)
/*    */           if (thePlayer.getOnGround()) {
/*    */             thePlayer.jump();
/*    */             thePlayer.setMotionX(thePlayer.getMotionX() * 1.0118F);
/*    */             thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.0118F);
/*    */           } else {
/*    */             thePlayer.setMotionY(thePlayer.getMotionY() - 0.0147F);
/*    */             thePlayer.setMotionX(thePlayer.getMotionX() * 1.00138F);
/*    */             thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.00138F);
/*    */           }  
/*    */       } 
/*    */       return;
/*    */     } 
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */   
/*    */   public void onEnable() {
/*    */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*    */       IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       if (thePlayer.getOnGround()) {
/*    */         thePlayer.setMotionZ(0.0D);
/*    */         thePlayer.setMotionX(thePlayer.getMotionZ());
/*    */       } 
/*    */       return;
/*    */     } 
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */   
/*    */   public void onDisable() {
/*    */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*    */       MinecraftInstance.mc.getThePlayer().setJumpMovementFactor(0.02F);
/*    */     } else {
/*    */       MinecraftInstance.mc.getThePlayer();
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean handleEvents() {
/*    */     return isActive();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACHop350.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */