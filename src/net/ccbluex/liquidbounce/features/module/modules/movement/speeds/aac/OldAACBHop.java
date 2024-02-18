/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\026J\b\020\b\032\0020\004H\026¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/OldAACBHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "onMotion", "", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onUpdate", "XSJClient"})
/*    */ public final class OldAACBHop extends SpeedMode {
/*    */   public OldAACBHop() {
/*  7 */     super("OldAACBHop");
/*    */   }
/*  9 */   public void onMotion() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 11 */       if (MovementUtils.isMoving())
/* 12 */       { if (thePlayer.getOnGround())
/* 13 */         { MovementUtils.strafe(0.56F);
/* 14 */           thePlayer.setMotionY(0.41999998688697815D); }
/* 15 */         else { MovementUtils.strafe(MovementUtils.INSTANCE.getSpeed() * ((thePlayer.getFallDistance() > 0.4F) ? 1.0F : 1.01F)); }
/*    */          }
/* 17 */       else { thePlayer.setMotionX(0.0D);
/* 18 */         thePlayer.setMotionZ(0.0D); }
/*    */       
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 23 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\OldAACBHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */