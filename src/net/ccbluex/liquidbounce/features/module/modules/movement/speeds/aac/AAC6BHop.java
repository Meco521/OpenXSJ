/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\026J\b\020\b\032\0020\006H\026J\020\020\t\032\0020\0062\006\020\n\032\0020\013H\026J\b\020\f\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC6BHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "legitJump", "", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AAC6BHop extends SpeedMode {
/*    */   public AAC6BHop() {
/*  7 */     super("AAC6BHop");
/*    */   } private boolean legitJump;
/*    */   public void onUpdate() {
/* 10 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 12 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */       
/* 14 */       if (thePlayer.isInWater())
/*    */         return; 
/* 16 */       if (MovementUtils.isMoving()) {
/* 17 */         if (thePlayer.getOnGround()) {
/* 18 */           if (this.legitJump) {
/* 19 */             thePlayer.setMotionY(0.4D);
/* 20 */             MovementUtils.strafe(0.15F);
/* 21 */             thePlayer.setOnGround(false);
/* 22 */             this.legitJump = false;
/*    */             
/*    */             return;
/*    */           } 
/* 26 */           thePlayer.setMotionY(0.41D);
/* 27 */           MovementUtils.strafe(0.47458485F);
/*    */         } 
/*    */         
/* 30 */         if (thePlayer.getMotionY() < false && thePlayer.getMotionY() > -0.2D) {
/* 31 */           MinecraftInstance.mc.getTimer().setTimerSpeed((float)(1.2D + thePlayer.getMotionY()));
/*    */         }
/* 33 */         thePlayer.setSpeedInAir(0.022151F);
/*    */       } else {
/* 35 */         this.legitJump = true;
/* 36 */         thePlayer.setMotionX(0.0D);
/* 37 */         thePlayer.setMotionZ(0.0D);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   } public void onMotion() {} public void onMove(@NotNull MoveEvent event) {
/* 43 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onEnable() {
/* 45 */     this.legitJump = true;
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 49 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 50 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); } else { MinecraftInstance.mc.getThePlayer(); }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC6BHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */