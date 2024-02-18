/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ 
/*    */ @ModuleInfo(name = "NoClip", description = "Allows you to freely move through walls (A sandblock has to fall on your head).", category = ModuleCategory.MOVEMENT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0042\006\020\006\032\0020\007H\007¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/NoClip;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class NoClip extends Module {
/*    */   public void onDisable() {
/* 13 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setNoClip(false); } else { MinecraftInstance.mc.getThePlayer(); }
/*    */   
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 18 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 20 */       thePlayer.setNoClip(true);
/* 21 */       thePlayer.setFallDistance(0.0F);
/* 22 */       thePlayer.setOnGround(false);
/*    */       
/* 24 */       thePlayer.getCapabilities().setFlying(false);
/* 25 */       thePlayer.setMotionX(0.0D);
/* 26 */       thePlayer.setMotionY(0.0D);
/* 27 */       thePlayer.setMotionZ(0.0D);
/*    */       
/* 29 */       float speed = 0.32F;
/*    */       
/* 31 */       thePlayer.setJumpMovementFactor(speed);
/*    */       
/* 33 */       if (MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown()) {
/* 34 */         thePlayer.setMotionY(thePlayer.getMotionY() + speed);
/*    */       }
/* 36 */       if (MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown())
/* 37 */         thePlayer.setMotionY(thePlayer.getMotionY() - speed); 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\NoClip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */