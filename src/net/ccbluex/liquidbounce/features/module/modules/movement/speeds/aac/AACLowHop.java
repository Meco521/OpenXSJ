/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\026J\020\020\b\032\0020\0062\006\020\t\032\0020\nH\026J\b\020\013\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACLowHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "legitJump", "", "onEnable", "", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACLowHop extends SpeedMode {
/*    */   public AACLowHop() {
/*  7 */     super("AACLowHop");
/*    */   } private boolean legitJump;
/*    */   public void onEnable() {
/* 10 */     this.legitJump = true;
/* 11 */     super.onEnable();
/*    */   }
/*    */   
/*    */   public void onMotion() {
/* 15 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 17 */       if (MovementUtils.isMoving()) {
/* 18 */         if (thePlayer.getOnGround()) {
/* 19 */           if (this.legitJump) {
/* 20 */             thePlayer.jump();
/* 21 */             this.legitJump = false;
/*    */             return;
/*    */           } 
/* 24 */           thePlayer.setMotionY(0.343D);
/* 25 */           MovementUtils.strafe(0.534F);
/*    */         } 
/*    */       } else {
/* 28 */         this.legitJump = true;
/* 29 */         thePlayer.setMotionX(0.0D);
/* 30 */         thePlayer.setMotionZ(0.0D);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 35 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACLowHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */