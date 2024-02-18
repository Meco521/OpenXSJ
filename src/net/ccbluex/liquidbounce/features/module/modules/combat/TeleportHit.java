/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import javax.vecmath.Vector3d;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.ccbluex.liquidbounce.event.EventState;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*    */ import net.ccbluex.liquidbounce.utils.Rotation;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ 
/*    */ @ModuleInfo(name = "TeleportHit", description = "Allows to hit entities from far away.", category = ModuleCategory.COMBAT)
/*    */ public class TeleportHit extends Module {
/*    */   @EventTarget
/*    */   public void onMotion(MotionEvent event) {
/* 23 */     if (event.getEventState() != EventState.PRE) {
/*    */       return;
/*    */     }
/* 26 */     IEntity facedEntity = RaycastUtils.raycastEntity(100.0D, classProvider::isEntityLivingBase);
/*    */     
/* 28 */     IEntityPlayerSP thePlayer = mc.getThePlayer();
/*    */     
/* 30 */     if (thePlayer == null) {
/*    */       return;
/*    */     }
/* 33 */     if (mc.getGameSettings().getKeyBindAttack().isKeyDown() && EntityUtils.isSelected(facedEntity, true) && facedEntity.getDistanceSqToEntity((IEntity)thePlayer) >= 1.0D) {
/* 34 */       this.targetEntity = facedEntity.asEntityLivingBase();
/*    */     }
/* 36 */     if (this.targetEntity != null)
/* 37 */     { if (!this.shouldHit) {
/* 38 */         this.shouldHit = true;
/*    */         
/*    */         return;
/*    */       } 
/* 42 */       if (thePlayer.getFallDistance() > 0.0F) {
/* 43 */         WVec3 rotationVector = RotationUtils.getVectorForRotation(new Rotation(thePlayer.getRotationYaw(), 0.0F));
/* 44 */         double x = thePlayer.getPosX() + rotationVector.getXCoord() * (thePlayer.getDistanceToEntity((IEntity)this.targetEntity) - 1.0F);
/* 45 */         double z = thePlayer.getPosZ() + rotationVector.getZCoord() * (thePlayer.getDistanceToEntity((IEntity)this.targetEntity) - 1.0F);
/* 46 */         double y = this.targetEntity.getPosition().getY() + 0.25D;
/*    */         
/* 48 */         PathUtils.findPath(x, y + 1.0D, z, 4.0D).forEach(pos -> mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketPlayerPosition(pos.getX(), pos.getY(), pos.getZ(), false)));
/*    */         
/* 50 */         thePlayer.swingItem();
/* 51 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketUseEntity((IEntity)this.targetEntity, ICPacketUseEntity.WAction.ATTACK));
/* 52 */         thePlayer.onCriticalHit((IEntity)this.targetEntity);
/* 53 */         this.shouldHit = false;
/* 54 */         this.targetEntity = null;
/* 55 */       } else if (thePlayer.getOnGround()) {
/* 56 */         thePlayer.jump();
/*    */       }  }
/* 58 */     else { this.shouldHit = false; }
/*    */   
/*    */   }
/*    */   
/*    */   private IEntityLivingBase targetEntity;
/*    */   private boolean shouldHit;
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\TeleportHit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */