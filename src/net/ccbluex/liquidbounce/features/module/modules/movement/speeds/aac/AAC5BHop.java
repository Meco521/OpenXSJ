/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\020\020\007\032\0020\0062\006\020\b\032\0020\tH\026J\b\020\n\032\0020\006H\026J\b\020\013\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC5BHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "legitJump", "", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class AAC5BHop extends SpeedMode {
/*    */   public AAC5BHop() {
/*  7 */     super("AAC5BHop");
/*    */   } private boolean legitJump; public void onMotion() {}
/*    */   public void onUpdate() {}
/*    */   public void onMove(@NotNull MoveEvent event) {
/* 11 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onTick() {
/* 13 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 15 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */       
/* 17 */       if (thePlayer.isInWater()) {
/*    */         return;
/*    */       }
/* 20 */       if (MovementUtils.isMoving()) {
/*    */         
/* 22 */         if (thePlayer.getOnGround()) {
/* 23 */           if (this.legitJump) {
/* 24 */             thePlayer.jump();
/* 25 */             this.legitJump = false;
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 30 */           thePlayer.setMotionY(0.41D);
/* 31 */           thePlayer.setOnGround(false);
/*    */           
/* 33 */           MovementUtils.strafe(0.374F);
/*    */         }
/* 35 */         else if (thePlayer.getMotionY() < 0.0D) {
/* 36 */           thePlayer.setSpeedInAir(0.0201F);
/* 37 */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.02F);
/*    */         } else {
/* 39 */           MinecraftInstance.mc.getTimer().setTimerSpeed(1.01F);
/*    */         } 
/*    */       } else {
/* 42 */         this.legitJump = true;
/* 43 */         thePlayer.setMotionX(0.0D);
/* 44 */         thePlayer.setMotionZ(0.0D);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC5BHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */