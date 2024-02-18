/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\026J\b\020\b\032\0020\006H\026J\020\020\t\032\0020\0062\006\020\n\032\0020\013H\026J\b\020\f\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACLowHop2;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "legitJump", "", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACLowHop2 extends SpeedMode {
/*    */   public AACLowHop2() {
/*  7 */     super("AACLowHop2");
/*    */   }
/*    */   private boolean legitJump;
/*    */   public void onEnable() {
/* 11 */     this.legitJump = true;
/* 12 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 16 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */   
/*    */   public void onMotion() {
/* 20 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 22 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */       
/* 24 */       if (thePlayer.isInWater()) {
/*    */         return;
/*    */       }
/* 27 */       if (MovementUtils.isMoving()) {
/* 28 */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.09F);
/*    */         
/* 30 */         if (thePlayer.getOnGround()) {
/* 31 */           if (this.legitJump) {
/* 32 */             thePlayer.jump();
/* 33 */             this.legitJump = false;
/*    */             
/*    */             return;
/*    */           } 
/*    */           
/* 38 */           thePlayer.setMotionY(0.343D);
/* 39 */           MovementUtils.strafe(0.534F);
/*    */         } 
/*    */       } else {
/* 42 */         this.legitJump = true;
/* 43 */         thePlayer.setMotionX(0.0D);
/* 44 */         thePlayer.setMotionZ(0.0D);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 49 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACLowHop2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */