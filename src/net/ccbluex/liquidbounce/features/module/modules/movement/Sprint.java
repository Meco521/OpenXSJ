/*    */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.ccbluex.liquidbounce.utils.Rotation;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ 
/*    */ @ModuleInfo(name = "Sprint", description = "Automatically sprints all the time.", category = ModuleCategory.MOVEMENT)
/*    */ public class Sprint
/*    */   extends Module
/*    */ {
/* 18 */   public final BoolValue allDirectionsValue = new BoolValue("AllDirections", true);
/* 19 */   public final BoolValue blindnessValue = new BoolValue("Blindness", true);
/* 20 */   public final BoolValue foodValue = new BoolValue("Food", true);
/*    */   
/* 22 */   public final BoolValue checkServerSide = new BoolValue("CheckServerSide", false);
/* 23 */   public final BoolValue checkServerSideGround = new BoolValue("CheckServerSideOnlyGround", false);
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(UpdateEvent event) {
/* 27 */     if (!MovementUtils.isMoving() || mc.getThePlayer().isSneaking() || (((Boolean)this.blindnessValue
/* 28 */       .get()).booleanValue() && mc.getThePlayer().isPotionActive(classProvider.getPotionEnum(PotionType.BLINDNESS))) || (((Boolean)this.foodValue
/* 29 */       .get()).booleanValue() && mc.getThePlayer().getFoodStats().getFoodLevel() <= 6.0F && !mc.getThePlayer().getCapabilities().getAllowFlying()) || (((Boolean)this.checkServerSide
/* 30 */       .get()).booleanValue() && (mc.getThePlayer().getOnGround() || !((Boolean)this.checkServerSideGround.get()).booleanValue()) && 
/* 31 */       !((Boolean)this.allDirectionsValue.get()).booleanValue() && RotationUtils.targetRotation != null && 
/* 32 */       RotationUtils.getRotationDifference(new Rotation(mc.getThePlayer().getRotationYaw(), mc.getThePlayer().getRotationPitch())) > 30.0D)) {
/* 33 */       mc.getThePlayer().setSprinting(false);
/*    */       
/*    */       return;
/*    */     } 
/* 37 */     if (((Boolean)this.allDirectionsValue.get()).booleanValue() || mc.getThePlayer().getMovementInput().getMoveForward() >= 0.8F)
/* 38 */       mc.getThePlayer().setSprinting(true); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\Sprint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */