/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\b\020\005\032\0020\004H\026J\020\020\006\032\0020\0042\006\020\007\032\0020\bH\026J\b\020\t\032\0020\004H\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AACBHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onDisable", "", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class AACBHop extends SpeedMode {
/*    */   public AACBHop() {
/*  9 */     super("AACBHop");
/*    */   }
/* 11 */   public void onMotion() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 13 */       if (thePlayer.isInWater()) {
/*    */         return;
/*    */       }
/* 16 */       if (MovementUtils.isMoving()) {
/* 17 */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.08F);
/*    */         
/* 19 */         if (thePlayer.getOnGround()) {
/* 20 */           thePlayer.setMotionY(0.399D);
/* 21 */           float f = thePlayer.getRotationYaw() * 0.017453292F;
/* 22 */           double d = thePlayer.getMotionX(); IEntityPlayerSP iEntityPlayerSP = thePlayer; boolean bool = false; float f1 = (float)Math.sin(f); iEntityPlayerSP.setMotionX(d - (f1 * 0.2F));
/* 23 */           d = thePlayer.getMotionZ(); iEntityPlayerSP = thePlayer; bool = false; f1 = (float)Math.cos(f); iEntityPlayerSP.setMotionZ(d + (f1 * 0.2F));
/* 24 */           MinecraftInstance.mc.getTimer().setTimerSpeed(2.0F);
/*    */         } else {
/* 26 */           thePlayer.setMotionY(thePlayer.getMotionY() * 0.97D);
/* 27 */           thePlayer.setMotionX(thePlayer.getMotionX() * 1.008D);
/* 28 */           thePlayer.setMotionZ(thePlayer.getMotionZ() * 1.008D);
/*    */         } 
/*    */       } else {
/* 31 */         thePlayer.setMotionX(0.0D);
/* 32 */         thePlayer.setMotionZ(0.0D);
/* 33 */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */       } 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 38 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onDisable() {
/* 40 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AACBHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */