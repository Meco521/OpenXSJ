/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\020\020\007\032\0020\0062\006\020\b\032\0020\tH\026J\b\020\n\032\0020\006H\026J\b\020\013\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC3BHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "legitJump", "", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class AAC3BHop extends SpeedMode {
/*    */   public AAC3BHop() {
/*  7 */     super("AAC3BHop");
/*    */   }
/*    */   private boolean legitJump;
/*    */   public void onTick() {
/* 11 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 13 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */       
/* 15 */       if (thePlayer.isInWater()) {
/*    */         return;
/*    */       }
/* 18 */       if (MovementUtils.isMoving()) {
/*    */         
/* 20 */         if (thePlayer.getOnGround()) {
/* 21 */           if (this.legitJump) {
/* 22 */             thePlayer.jump();
/* 23 */             this.legitJump = false;
/*    */             
/*    */             return;
/*    */           } 
/* 27 */           thePlayer.setMotionY(0.3852D);
/* 28 */           thePlayer.setOnGround(false);
/*    */           
/* 30 */           MovementUtils.strafe(0.374F);
/*    */         }
/* 32 */         else if (thePlayer.getMotionY() < 0.0D) {
/* 33 */           thePlayer.setSpeedInAir(0.0201F);
/* 34 */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.02F);
/*    */         } else {
/* 36 */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.01F);
/*    */         } 
/*    */       } else {
/* 39 */         this.legitJump = true;
/* 40 */         thePlayer.setMotionX(0.0D);
/* 41 */         thePlayer.setMotionZ(0.0D);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   } public void onMotion() {} public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 47 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC3BHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */