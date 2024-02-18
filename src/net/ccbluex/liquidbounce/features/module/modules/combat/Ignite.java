/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*     */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ 
/*     */ @ModuleInfo(name = "Ignite", description = "自动打火鸡", category = ModuleCategory.COMBAT)
/*     */ public class Ignite extends Module {
/*  27 */   private final BoolValue lighterValue = new BoolValue("Lighter", true);
/*  28 */   private final BoolValue lavaBucketValue = new BoolValue("Lava", true);
/*     */   
/*  30 */   private final MSTimer msTimer = new MSTimer();
/*     */   
/*     */   @EventTarget
/*     */   public void onUpdate(UpdateEvent event) {
/*  34 */     if (!this.msTimer.hasTimePassed(500L)) {
/*     */       return;
/*     */     }
/*  37 */     IEntityPlayerSP thePlayer = mc.getThePlayer();
/*  38 */     IWorldClient theWorld = mc.getTheWorld();
/*     */     
/*  40 */     if (thePlayer == null || theWorld == null) {
/*     */       return;
/*     */     }
/*     */     
/*  44 */     int lighterInHotbar = ((Boolean)this.lighterValue.get()).booleanValue() ? InventoryUtils.findItem(36, 45, classProvider.getItemEnum(ItemType.FLINT_AND_STEEL)) : -1;
/*     */     
/*  46 */     int lavaInHotbar = ((Boolean)this.lavaBucketValue.get()).booleanValue() ? InventoryUtils.findItem(26, 45, classProvider.getItemEnum(ItemType.LAVA_BUCKET)) : -1;
/*     */     
/*  48 */     if (lighterInHotbar == -1 && lavaInHotbar == -1) {
/*     */       return;
/*     */     }
/*  51 */     int fireInHotbar = (lighterInHotbar != -1) ? lighterInHotbar : lavaInHotbar;
/*     */     
/*  53 */     for (IEntity entity : theWorld.getLoadedEntityList()) {
/*  54 */       if (EntityUtils.isSelected(entity, true) && !entity.isBurning()) {
/*  55 */         WBlockPos blockPos = entity.getPosition();
/*     */         
/*  57 */         if (mc.getThePlayer().getDistanceSq(blockPos) >= 22.3D || 
/*  58 */           !BlockUtils.isReplaceable(blockPos) || 
/*  59 */           !classProvider.isBlockAir(BlockUtils.getBlock(blockPos))) {
/*     */           continue;
/*     */         }
/*  62 */         RotationUtils.keepCurrentRotation = true;
/*     */         
/*  64 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(fireInHotbar - 36));
/*     */         
/*  66 */         IItemStack itemStack = mc.getThePlayer().getInventory().getStackInSlot(fireInHotbar);
/*     */         
/*  68 */         if (classProvider.isItemBucket(itemStack.getItem())) {
/*  69 */           double diffX = blockPos.getX() + 0.5D - mc.getThePlayer().getPosX();
/*     */ 
/*     */           
/*  72 */           double diffY = blockPos.getY() + 0.5D - thePlayer.getEntityBoundingBox().getMinY() + thePlayer.getEyeHeight();
/*  73 */           double diffZ = blockPos.getZ() + 0.5D - thePlayer.getPosZ();
/*  74 */           double sqrt = Math.sqrt(diffX * diffX + diffZ * diffZ);
/*  75 */           float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
/*  76 */           float pitch = (float)-(Math.atan2(diffY, sqrt) * 180.0D / Math.PI);
/*     */           
/*  78 */           mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketPlayerLook(thePlayer
/*  79 */                 .getRotationYaw() + 
/*  80 */                 WMathHelper.wrapAngleTo180_float(yaw - thePlayer.getRotationYaw()), thePlayer
/*  81 */                 .getRotationPitch() + 
/*  82 */                 WMathHelper.wrapAngleTo180_float(pitch - thePlayer.getRotationPitch()), thePlayer
/*  83 */                 .getOnGround()));
/*     */           
/*  85 */           mc.getPlayerController().sendUseItem((IEntityPlayer)thePlayer, (IWorld)theWorld, itemStack);
/*     */         } else {
/*  87 */           for (EnumFacingType enumFacingType : EnumFacingType.values()) {
/*  88 */             IEnumFacing side = classProvider.getEnumFacing(enumFacingType);
/*     */             
/*  90 */             WBlockPos neighbor = blockPos.offset(side);
/*     */             
/*  92 */             if (BlockUtils.canBeClicked(neighbor)) {
/*     */               
/*  94 */               double diffX = neighbor.getX() + 0.5D - thePlayer.getPosX();
/*     */ 
/*     */               
/*  97 */               double diffY = neighbor.getY() + 0.5D - thePlayer.getEntityBoundingBox().getMinY() + thePlayer.getEyeHeight();
/*  98 */               double diffZ = neighbor.getZ() + 0.5D - thePlayer.getPosZ();
/*  99 */               double sqrt = Math.sqrt(diffX * diffX + diffZ * diffZ);
/* 100 */               float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
/* 101 */               float pitch = (float)-(Math.atan2(diffY, sqrt) * 180.0D / Math.PI);
/*     */               
/* 103 */               mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketPlayerLook(thePlayer
/* 104 */                     .getRotationYaw() + 
/* 105 */                     WMathHelper.wrapAngleTo180_float(yaw - thePlayer.getRotationYaw()), thePlayer
/* 106 */                     .getRotationPitch() + 
/* 107 */                     WMathHelper.wrapAngleTo180_float(pitch - thePlayer.getRotationPitch()), thePlayer
/* 108 */                     .getOnGround()));
/*     */               
/* 110 */               if (mc.getPlayerController().onPlayerRightClick(thePlayer, theWorld, itemStack, neighbor, side
/* 111 */                   .getOpposite(), new WVec3(side.getDirectionVec()))) {
/* 112 */                 thePlayer.swingItem();
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 118 */         mc.getNetHandler()
/* 119 */           .addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(thePlayer.getInventory().getCurrentItem()));
/* 120 */         RotationUtils.keepCurrentRotation = false;
/* 121 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider
/* 122 */             .createCPacketPlayerLook(thePlayer.getRotationYaw(), thePlayer.getRotationPitch(), thePlayer.getOnGround()));
/*     */ 
/*     */         
/* 125 */         this.msTimer.reset();
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Ignite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */