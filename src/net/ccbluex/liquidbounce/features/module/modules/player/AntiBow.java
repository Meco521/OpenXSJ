/*    */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.ccbluex.liquidbounce.utils.VecRotation;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.minecraft.entity.projectile.EntityArrow;
/*    */ 
/*    */ @ModuleInfo(name = "AntiBow", description = "躲避弓箭", category = ModuleCategory.PLAYER)
/*    */ public class AntiBow
/*    */   extends Module
/*    */ {
/* 24 */   private final FloatValue distanceValue = new FloatValue("Distance", 40.0F, 10.0F, 60.0F);
/* 25 */   private final IntegerValue moveTicks = new IntegerValue("MoveTicks", 40, 1, 100);
/* 26 */   private final BoolValue autoScaffoldValue = new BoolValue("AutoScaffold", true);
/*    */   
/* 28 */   private final List<Integer> hidedArrows = new ArrayList<>();
/*    */   private int ticks;
/*    */   
/*    */   @EventTarget
/*    */   public void onUpdate(UpdateEvent updateEvent) {
/* 33 */     for (IEntity entity : mc.getTheWorld().getLoadedEntityList()) {
/* 34 */       if (entity instanceof EntityArrow && entity.getDistanceToEntity((IEntity)mc.getThePlayer()) < ((Float)this.distanceValue.get()).floatValue()) {
/* 35 */         if (!this.hidedArrows.contains(Integer.valueOf(entity.getEntityId()))) {
/* 36 */           this.hidedArrows.add(Integer.valueOf(entity.getEntityId()));
/* 37 */           VecRotation rotation = RotationUtils.searchCenter(entity
/* 38 */               .getEntityBoundingBox(), false, false, false, false, entity
/*    */ 
/*    */ 
/*    */ 
/*    */               
/* 43 */               .getDistanceToEntity((IEntity)mc.getThePlayer()));
/* 44 */           mc.getThePlayer().setRotationYaw(rotation.getRotation().getYaw());
/* 45 */           mc.getThePlayer().setRotationPitch(rotation.getRotation().getPitch());
/* 46 */           if (((Boolean)this.autoScaffoldValue.get()).booleanValue()) {
/* 47 */             Retreat.moduleManager.getModule(Scaffold.class).setState(true);
/*    */           }
/* 49 */           EntityArrow arrow = (EntityArrow)entity;
/*    */           
/* 51 */           this.ticks = 0;
/*    */         } 
/* 53 */         if (this.ticks < ((Integer)this.moveTicks.get()).intValue()) {
/* 54 */           mc.getGameSettings().getKeyBindLeft().setPressed(true);
/*    */         }
/*    */       } 
/*    */     } 
/* 58 */     this.ticks++;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AntiBow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */