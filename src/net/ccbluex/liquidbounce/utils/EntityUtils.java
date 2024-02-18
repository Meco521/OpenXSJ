/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.network.INetworkPlayerInfo;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.scoreboard.ITeam;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.NoFriends;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.misc.Teams;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ 
/*    */ public final class EntityUtils
/*    */   extends MinecraftInstance {
/*    */   public static boolean targetInvisible = false;
/*    */   public static boolean targetPlayer = true;
/*    */   public static boolean targetMobs = true;
/*    */   public static boolean targetAnimals = false;
/*    */   public static boolean targetDead = false;
/*    */   
/*    */   public static boolean isSelected(IEntity entity, boolean canAttackCheck) {
/* 23 */     if (classProvider.isEntityLivingBase(entity) && (targetDead || entity.isEntityAlive()) && entity != null && !entity.equals(mc.getThePlayer()) && (
/* 24 */       targetInvisible || !entity.isInvisible())) {
/* 25 */       if (targetPlayer && classProvider.isEntityPlayer(entity)) {
/* 26 */         IEntityPlayer entityPlayer = entity.asEntityPlayer();
/*    */         
/* 28 */         if (canAttackCheck) {
/* 29 */           if (AntiBot.isBot((IEntityLivingBase)entityPlayer)) {
/* 30 */             return false;
/*    */           }
/* 32 */           if (isFriend((IEntity)entityPlayer) && !Retreat.moduleManager.getModule(NoFriends.class).getState()) {
/* 33 */             return false;
/*    */           }
/* 35 */           if (entityPlayer.isSpectator()) {
/* 36 */             return false;
/*    */           }
/* 38 */           Teams teams = (Teams)Retreat.moduleManager.getModule(Teams.class);
/* 39 */           return (!teams.getState() || !teams.isInYourTeam((IEntityLivingBase)entityPlayer));
/*    */         } 
/*    */         
/* 42 */         return true;
/*    */       } 
/*    */       
/* 45 */       return ((targetMobs && isMob(entity)) || (targetAnimals && isAnimal(entity)));
/*    */     } 
/*    */ 
/*    */     
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean isFriend(IEntity entity) {
/* 53 */     return (classProvider.isEntityPlayer(entity) && entity.getName() != null && Retreat.fileManager.friendsConfig
/* 54 */       .isFriend(ColorUtils.stripColor(entity.getName())));
/*    */   }
/*    */   
/*    */   public static boolean isAnimal(IEntity entity) {
/* 58 */     return (classProvider.isEntityAnimal(entity) || classProvider.isEntitySquid(entity) || classProvider.isEntityGolem(entity) || classProvider
/* 59 */       .isEntityBat(entity));
/*    */   }
/*    */   
/*    */   public static boolean isMob(IEntity entity) {
/* 63 */     return (classProvider.isEntityMob(entity) || classProvider.isEntityVillager(entity) || classProvider.isEntitySlime(entity) || classProvider
/* 64 */       .isEntityGhast(entity) || classProvider.isEntityDragon(entity) || classProvider.isEntityShulker(entity));
/*    */   }
/*    */   
/*    */   public static String getName(INetworkPlayerInfo networkPlayerInfoIn) {
/* 68 */     if (networkPlayerInfoIn.getDisplayName() != null) {
/* 69 */       return networkPlayerInfoIn.getDisplayName().getFormattedText();
/*    */     }
/* 71 */     ITeam team = networkPlayerInfoIn.getPlayerTeam();
/* 72 */     String name = networkPlayerInfoIn.getGameProfile().getName();
/*    */     
/* 74 */     return (team == null) ? name : team.formatString(name);
/*    */   }
/*    */   
/*    */   public static int getPing(IEntityPlayer entityPlayer) {
/* 78 */     if (entityPlayer == null) {
/* 79 */       return 0;
/*    */     }
/* 81 */     INetworkPlayerInfo networkPlayerInfo = mc.getNetHandler().getPlayerInfo(entityPlayer.getUniqueID());
/*    */     
/* 83 */     return (networkPlayerInfo == null) ? 0 : networkPlayerInfo.getResponseTime();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\EntityUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */