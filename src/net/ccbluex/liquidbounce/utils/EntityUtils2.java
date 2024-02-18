/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.JvmField;
/*    */ import kotlin.jvm.JvmStatic;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.network.INetworkPlayerInfo;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\b\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\t\032\0020\n2\b\020\013\032\004\030\0010\fJ\020\020\r\032\0020\n2\b\020\013\032\004\030\0010\fJ\016\020\016\032\0020\0042\006\020\017\032\0020\020J\020\020\021\032\0020\0042\b\020\022\032\004\030\0010\020J\032\020\023\032\0020\0042\b\020\017\032\004\030\0010\0202\006\020\024\032\0020\004H\007R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\005\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\006\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\007\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\b\032\0020\0048\006@\006X\016¢\006\002\n\000¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/EntityUtils2;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "targetAnimals", "", "targetDead", "targetInvisible", "targetMobs", "targetPlayer", "getPing", "", "entityPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;", "getPing2", "isFriend", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isRendered", "entityToCheck", "isSelected", "canAttackCheck", "XSJClient"})
/*    */ public final class EntityUtils2 extends MinecraftInstance {
/*    */   static {
/* 19 */     EntityUtils2 entityUtils2 = new EntityUtils2();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   public static boolean targetInvisible;
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   public static boolean targetPlayer = true;
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   public static boolean targetMobs = true;
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   public static boolean targetAnimals;
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   public static boolean targetDead;
/*    */ 
/*    */ 
/*    */   
/*    */   public static final EntityUtils2 INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   public static final boolean isSelected(@Nullable IEntity entity, boolean canAttackCheck) {
/*    */     // Byte code:
/*    */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   3: aload_0
/*    */     //   4: invokeinterface isEntityLivingBase : (Ljava/lang/Object;)Z
/*    */     //   9: ifeq -> 235
/*    */     //   12: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.targetDead : Z
/*    */     //   15: ifne -> 34
/*    */     //   18: aload_0
/*    */     //   19: dup
/*    */     //   20: ifnonnull -> 26
/*    */     //   23: invokestatic throwNpe : ()V
/*    */     //   26: invokeinterface isEntityAlive : ()Z
/*    */     //   31: ifeq -> 235
/*    */     //   34: aload_0
/*    */     //   35: ifnull -> 235
/*    */     //   38: aload_0
/*    */     //   39: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   42: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   47: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   50: iconst_1
/*    */     //   51: ixor
/*    */     //   52: ifeq -> 235
/*    */     //   55: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.targetInvisible : Z
/*    */     //   58: ifne -> 70
/*    */     //   61: aload_0
/*    */     //   62: invokeinterface isInvisible : ()Z
/*    */     //   67: ifne -> 235
/*    */     //   70: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.targetPlayer : Z
/*    */     //   73: ifeq -> 203
/*    */     //   76: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   79: aload_0
/*    */     //   80: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*    */     //   85: ifeq -> 203
/*    */     //   88: aload_0
/*    */     //   89: invokeinterface asEntityPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*    */     //   94: astore_2
/*    */     //   95: iload_1
/*    */     //   96: ifeq -> 201
/*    */     //   99: aload_2
/*    */     //   100: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   103: invokestatic isBot : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*    */     //   106: ifeq -> 111
/*    */     //   109: iconst_0
/*    */     //   110: ireturn
/*    */     //   111: aload_2
/*    */     //   112: invokestatic isClientFriend : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;)Z
/*    */     //   115: ifeq -> 137
/*    */     //   118: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   121: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   124: ldc net/ccbluex/liquidbounce/features/module/modules/combat/NoFriends
/*    */     //   126: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   129: invokevirtual getState : ()Z
/*    */     //   132: ifne -> 137
/*    */     //   135: iconst_0
/*    */     //   136: ireturn
/*    */     //   137: aload_2
/*    */     //   138: invokeinterface isSpectator : ()Z
/*    */     //   143: ifeq -> 148
/*    */     //   146: iconst_0
/*    */     //   147: ireturn
/*    */     //   148: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   151: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*    */     //   154: ldc net/ccbluex/liquidbounce/features/module/modules/misc/Teams
/*    */     //   156: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*    */     //   159: dup
/*    */     //   160: ifnonnull -> 173
/*    */     //   163: new kotlin/TypeCastException
/*    */     //   166: dup
/*    */     //   167: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams'
/*    */     //   169: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   172: athrow
/*    */     //   173: checkcast net/ccbluex/liquidbounce/features/module/modules/misc/Teams
/*    */     //   176: astore_3
/*    */     //   177: aload_3
/*    */     //   178: invokevirtual getState : ()Z
/*    */     //   181: ifeq -> 195
/*    */     //   184: aload_3
/*    */     //   185: aload_2
/*    */     //   186: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   189: invokevirtual isInYourTeam : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*    */     //   192: ifne -> 199
/*    */     //   195: iconst_1
/*    */     //   196: goto -> 200
/*    */     //   199: iconst_0
/*    */     //   200: ireturn
/*    */     //   201: iconst_1
/*    */     //   202: ireturn
/*    */     //   203: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.targetMobs : Z
/*    */     //   206: ifeq -> 216
/*    */     //   209: aload_0
/*    */     //   210: invokestatic isMob : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*    */     //   213: ifne -> 229
/*    */     //   216: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.targetAnimals : Z
/*    */     //   219: ifeq -> 233
/*    */     //   222: aload_0
/*    */     //   223: invokestatic isAnimal : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*    */     //   226: ifeq -> 233
/*    */     //   229: iconst_1
/*    */     //   230: goto -> 234
/*    */     //   233: iconst_0
/*    */     //   234: ireturn
/*    */     //   235: iconst_0
/*    */     //   236: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #38	-> 0
/*    */     //   #39	-> 0
/*    */     //   #38	-> 0
/*    */     //   #40	-> 55
/*    */     //   #41	-> 70
/*    */     //   #42	-> 88
/*    */     //   #44	-> 95
/*    */     //   #45	-> 99
/*    */     //   #46	-> 109
/*    */     //   #48	-> 111
/*    */     //   #49	-> 135
/*    */     //   #51	-> 137
/*    */     //   #52	-> 148
/*    */     //   #53	-> 177
/*    */     //   #55	-> 201
/*    */     //   #58	-> 203
/*    */     //   #61	-> 235
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   177	24	3	teams	Lnet/ccbluex/liquidbounce/features/module/modules/misc/Teams;
/*    */     //   95	108	2	entityPlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*    */     //   0	237	0	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*    */     //   0	237	1	canAttackCheck	Z
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final int getPing2(@Nullable IEntityPlayer entityPlayer) {
/* 64 */     if (entityPlayer == null) return 0; 
/* 65 */     INetworkPlayerInfo networkPlayerInfo = MinecraftInstance.mc.getNetHandler().getPlayerInfo(entityPlayer.getUniqueID());
/* 66 */     return (networkPlayerInfo != null) ? networkPlayerInfo.getResponseTime() : 0;
/*    */   }
/*    */   public final boolean isRendered(@Nullable IEntity entityToCheck) {
/* 69 */     if (MinecraftInstance.mc.getTheWorld() != null) { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (CollectionsKt.contains(MinecraftInstance.mc.getTheWorld().getLoadedEntityList(), entityToCheck)); }  return false;
/*    */   }
/*    */   public final boolean isFriend(@NotNull IEntity entity) {
/* 72 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); return (MinecraftInstance.classProvider.isEntityPlayer(entity) && entity.getName() != null && 
/* 73 */       (Retreat.INSTANCE.getFileManager()).friendsConfig.isFriend(ColorUtils.stripColor(entity.getName())));
/*    */   }
/*    */   public final int getPing(@Nullable IEntityPlayer entityPlayer) {
/* 76 */     if (entityPlayer == null) return 0; 
/* 77 */     INetworkPlayerInfo networkPlayerInfo = MinecraftInstance.mc.getNetHandler().getPlayerInfo(entityPlayer.getUniqueID());
/* 78 */     return (networkPlayerInfo != null) ? networkPlayerInfo.getResponseTime() : 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\EntityUtils2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */