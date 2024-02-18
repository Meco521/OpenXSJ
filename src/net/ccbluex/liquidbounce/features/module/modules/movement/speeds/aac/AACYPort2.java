/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\026J\b\020\b\032\0020\004H\026¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACYPort2;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACYPort2 extends SpeedMode {
/*    */   public AACYPort2() {
/*  7 */     super("AACYPort2");
/*    */   }
/*  9 */   public void onMotion() { if (MovementUtils.isMoving()) {
/* 10 */       if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */         
/* 12 */         thePlayer.setCameraPitch(0.0F);
/* 13 */         if (thePlayer.getOnGround())
/* 14 */         { thePlayer.jump();
/* 15 */           thePlayer.setMotionY(0.3851D);
/* 16 */           thePlayer.setMotionX(thePlayer.getMotionX() * 1.01D);
/* 17 */           thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.01D); }
/* 18 */         else { thePlayer.setMotionY(-0.21D); }
/*    */          return; }
/*    */       
/*    */       MinecraftInstance.mc.getThePlayer();
/*    */       return;
/* 23 */     }  } public void onUpdate() {} public void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACYPort2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */