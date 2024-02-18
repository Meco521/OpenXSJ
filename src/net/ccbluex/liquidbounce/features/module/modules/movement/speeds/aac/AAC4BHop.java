/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.aac;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\b\020\005\032\0020\006H\026J\b\020\007\032\0020\006H\026J\b\020\b\032\0020\006H\026J\020\020\t\032\0020\0062\006\020\n\032\0020\013H\026J\b\020\f\032\0020\006H\026J\b\020\r\032\0020\006H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/aac/AAC4BHop;", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "()V", "legitHop", "", "onDisable", "", "onEnable", "onMotion", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "onUpdate", "XSJClient"})
/*    */ public final class AAC4BHop extends SpeedMode {
/*    */   public AAC4BHop() {
/*  7 */     super("AAC4BHop");
/*    */   }
/*    */   private boolean legitHop;
/*    */   public void onDisable() {
/* 11 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F);
/*    */   }
/*    */   
/*    */   public void onTick() {
/* 15 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 17 */       if (MovementUtils.isMoving())
/* 18 */       { if (this.legitHop) {
/* 19 */           if (thePlayer.getOnGround()) {
/* 20 */             thePlayer.jump();
/* 21 */             thePlayer.setOnGround(false);
/* 22 */             this.legitHop = false;
/*    */           } 
/*    */           return;
/*    */         } 
/* 26 */         if (thePlayer.getOnGround())
/* 27 */         { thePlayer.setOnGround(false);
/* 28 */           MovementUtils.strafe(0.375F);
/* 29 */           thePlayer.jump();
/* 30 */           thePlayer.setMotionY(0.41D); }
/* 31 */         else { thePlayer.setSpeedInAir(0.0211F); }
/*    */          }
/* 33 */       else { thePlayer.setMotionX(0.0D);
/* 34 */         thePlayer.setMotionZ(0.0D);
/* 35 */         this.legitHop = true; }
/*    */       
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   } public void onMotion() {} public void onUpdate() {} public void onMove(@NotNull MoveEvent event) {
/* 41 */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */   } public void onEnable() {
/* 43 */     this.legitHop = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\speeds\aac\AAC4BHop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */