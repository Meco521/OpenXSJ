/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\006\032\0020\007H\026J\b\020\b\032\0020\007H\026J\020\020\t\032\0020\0072\006\020\n\032\0020\013H\026J\b\020\f\032\0020\007H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\004X\016¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACLowHop3;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "firstJump", "", "waitForGround", "onEnable", "", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACLowHop3 extends SpeedMode {
/*    */   private boolean firstJump;
/*    */   
/*    */   public AACLowHop3() {
/*  9 */     super("AACLowHop3");
/*    */   }
/*    */   private boolean waitForGround;
/*    */   public void onEnable() {
/* 13 */     this.firstJump = true;
/*    */   }
/*    */   
/*    */   public void onMotion() {
/* 17 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 19 */       if (MovementUtils.isMoving()) {
/* 20 */         if (thePlayer.getHurtTime() <= 0) {
/* 21 */           if (thePlayer.getOnGround()) {
/* 22 */             this.waitForGround = false;
/* 23 */             if (!this.firstJump) this.firstJump = true; 
/* 24 */             thePlayer.jump();
/* 25 */             thePlayer.setMotionY(0.41D);
/*    */           } else {
/* 27 */             if (this.waitForGround)
/* 28 */               return;  if (thePlayer.isCollidedHorizontally())
/* 29 */               return;  this.firstJump = false;
/* 30 */             thePlayer.setMotionY(thePlayer.getMotionY() - 0.0149D);
/*    */           } 
/* 32 */           if (!thePlayer.isCollidedHorizontally()) MovementUtils.forward(this.firstJump ? 0.0016D : 0.001799D); 
/*    */         } else {
/* 34 */           this.firstJump = true;
/* 35 */           this.waitForGround = true;
/*    */         } 
/*    */       } else {
/* 38 */         thePlayer.setMotionZ(0.0D);
/* 39 */         thePlayer.setMotionX(0.0D);
/*    */       } 
/* 41 */       double speed = MovementUtils.INSTANCE.getSpeed();
/* 42 */       double d1 = MovementUtils.getDirection(); IEntityPlayerSP iEntityPlayerSP1 = thePlayer; boolean bool = false; double d2 = Math.sin(d1); iEntityPlayerSP1.setMotionX(-(d2 * speed));
/* 43 */       d1 = MovementUtils.getDirection(); iEntityPlayerSP1 = thePlayer; bool = false; d2 = Math.cos(d1); iEntityPlayerSP1.setMotionZ(d2 * speed);
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 47 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACLowHop3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */