/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityOtherPlayerMP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorldSettings;
/*    */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "BackTrack", description = "Suspends all movement packets. like VAPE", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000T\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\035\032\0020\0362\006\020\037\032\0020\006H\002J\020\020 \032\0020\0362\006\020!\032\0020\"H\007J\b\020#\032\0020\036H\026J\020\020$\032\0020\0362\006\020!\032\0020%H\007J\b\020&\032\0020\036H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\034\020\005\032\004\030\0010\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\034\020\013\032\004\030\0010\fX\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\021\020\024\032\0020\025¢\006\b\n\000\032\004\b\026\020\027R\016\020\030\032\0020\023X\004¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\034X\016¢\006\002\n\000¨\006'"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/BackTrack;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aura", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "currentTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getCurrentTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setCurrentTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "fakePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "getFakePlayer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "setFakePlayer", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;)V", "intavetest", "intavetesthurttime", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "killaura", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "getKillaura", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "pulseDelayValue", "pulseTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "shown", "", "attackEntity", "", "entity", "onAttack", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "removeFakePlayer", "XSJClient"})
/*    */ public final class BackTrack extends Module {
/*    */   @Nullable
/*    */   private IEntityOtherPlayerMP fakePlayer;
/*    */   
/*    */   @Nullable
/* 29 */   public final IEntityOtherPlayerMP getFakePlayer() { return this.fakePlayer; } public final void setFakePlayer(@Nullable IEntityOtherPlayerMP <set-?>) { this.fakePlayer = <set-?>; }
/*    */   
/* 31 */   private final BoolValue aura = new BoolValue("Aura", false);
/*    */   
/* 33 */   private final IntegerValue pulseDelayValue = new IntegerValue("PulseDelay", 1000, 5, 2000);
/*    */   
/* 35 */   private final BoolValue intavetest = new BoolValue("IntaveTest", false);
/*    */   
/* 37 */   private final IntegerValue intavetesthurttime = new IntegerValue("Value", 5, 0, 100); @Nullable
/* 38 */   private IEntityLivingBase currentTarget; private boolean shown; private final MSTimer pulseTimer = new MSTimer(); @NotNull private final KillAura killaura; @Nullable
/* 39 */   public final IEntityLivingBase getCurrentTarget() { return this.currentTarget; } public final void setCurrentTarget(@Nullable IEntityLivingBase <set-?>) { this.currentTarget = <set-?>; }
/*    */   
/*    */   @NotNull
/* 42 */   public final KillAura getKillaura() { return this.killaura; } public BackTrack() { if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  this.killaura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class); }
/*    */   
/*    */   public void onDisable() {
/* 45 */     removeFakePlayer();
/*    */   }
/*    */   
/*    */   private final void removeFakePlayer() {
/*    */     try {
/* 50 */       this.currentTarget = (IEntityLivingBase)null;
/* 51 */       if (MinecraftInstance.mc.getTheWorld() != null) { if (this.fakePlayer != null) { MinecraftInstance.mc.getTheWorld().removeEntityFromWorld(this.fakePlayer.getEntityId());
/* 52 */           this.fakePlayer = (IEntityOtherPlayerMP)null; return; }  return; }  MinecraftInstance.mc.getTheWorld(); return;
/* 53 */     } catch (NullPointerException t) {
/* 54 */       ClientUtils.getLogger().error("Failed removing fakePlayer " + t);
/*    */     } 
/*    */   }
/*    */   
/*    */   private final void attackEntity(IEntityLivingBase entity) {
/* 59 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 60 */       thePlayer.swingItem();
/* 61 */       MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity((IEntity)entity, ICPacketUseEntity.WAction.ATTACK));
/* 62 */       if (MinecraftInstance.mc.getPlayerController().getCurrentGameType() != IWorldSettings.WGameType.SPECTATOR)
/* 63 */         thePlayer.attackTargetEntityWithCurrentItem((IEntity)entity); 
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } @EventTarget
/*    */   public final void onAttack(@NotNull AttackEvent event) {
/* 68 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.fakePlayer == null) {
/* 69 */       this.currentTarget = (IEntityLivingBase)event.getTargetEntity();
/* 70 */       this.shown = false;
/*    */     } else {
/* 72 */       if (Intrinsics.areEqual(event.getTargetEntity(), this.fakePlayer)) {
/* 73 */         if (this.currentTarget != null) { attackEntity(this.currentTarget); return; }
/*    */          return;
/* 75 */       }  this.fakePlayer = (IEntityOtherPlayerMP)null;
/* 76 */       this.currentTarget = (IEntityLivingBase)event.getTargetEntity();
/* 77 */       this.shown = false;
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'event'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getfield aura : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   13: checkcast java/lang/Boolean
/*    */     //   16: invokevirtual booleanValue : ()Z
/*    */     //   19: ifeq -> 89
/*    */     //   22: aload_0
/*    */     //   23: getfield killaura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*    */     //   26: invokevirtual getState : ()Z
/*    */     //   29: ifne -> 89
/*    */     //   32: aload_0
/*    */     //   33: aconst_null
/*    */     //   34: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*    */     //   37: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   40: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   43: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*    */     //   48: dup
/*    */     //   49: ifnull -> 55
/*    */     //   52: goto -> 57
/*    */     //   55: pop
/*    */     //   56: return
/*    */     //   57: aload_0
/*    */     //   58: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   61: dup
/*    */     //   62: ifnull -> 68
/*    */     //   65: goto -> 70
/*    */     //   68: pop
/*    */     //   69: return
/*    */     //   70: invokeinterface getEntityId : ()I
/*    */     //   75: invokeinterface removeEntityFromWorld : (I)V
/*    */     //   80: nop
/*    */     //   81: aload_0
/*    */     //   82: aconst_null
/*    */     //   83: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP
/*    */     //   86: putfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   89: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   92: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   97: ifnonnull -> 101
/*    */     //   100: return
/*    */     //   101: aload_0
/*    */     //   102: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   105: ifnull -> 183
/*    */     //   108: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.INSTANCE : Lnet/ccbluex/liquidbounce/utils/EntityUtils2;
/*    */     //   111: aload_0
/*    */     //   112: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   115: dup
/*    */     //   116: ifnull -> 125
/*    */     //   119: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   122: goto -> 127
/*    */     //   125: pop
/*    */     //   126: return
/*    */     //   127: invokevirtual isRendered : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*    */     //   130: ifeq -> 183
/*    */     //   133: aload_0
/*    */     //   134: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   137: dup
/*    */     //   138: ifnull -> 144
/*    */     //   141: goto -> 146
/*    */     //   144: pop
/*    */     //   145: return
/*    */     //   146: invokeinterface isDead : ()Z
/*    */     //   151: ifne -> 179
/*    */     //   154: getstatic net/ccbluex/liquidbounce/utils/EntityUtils2.INSTANCE : Lnet/ccbluex/liquidbounce/utils/EntityUtils2;
/*    */     //   157: aload_0
/*    */     //   158: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   161: dup
/*    */     //   162: ifnull -> 171
/*    */     //   165: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*    */     //   168: goto -> 173
/*    */     //   171: pop
/*    */     //   172: return
/*    */     //   173: invokevirtual isRendered : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*    */     //   176: ifne -> 183
/*    */     //   179: aload_0
/*    */     //   180: invokespecial removeFakePlayer : ()V
/*    */     //   183: aload_0
/*    */     //   184: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   187: ifnull -> 319
/*    */     //   190: aload_0
/*    */     //   191: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   194: ifnull -> 319
/*    */     //   197: aload_0
/*    */     //   198: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   201: dup
/*    */     //   202: ifnull -> 208
/*    */     //   205: goto -> 210
/*    */     //   208: pop
/*    */     //   209: return
/*    */     //   210: aload_0
/*    */     //   211: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   214: dup
/*    */     //   215: ifnull -> 221
/*    */     //   218: goto -> 223
/*    */     //   221: pop
/*    */     //   222: return
/*    */     //   223: invokeinterface getHealth : ()F
/*    */     //   228: invokeinterface setHealth : (F)V
/*    */     //   233: iconst_0
/*    */     //   234: istore_3
/*    */     //   235: new kotlin/ranges/IntRange
/*    */     //   238: dup
/*    */     //   239: iload_3
/*    */     //   240: iconst_4
/*    */     //   241: invokespecial <init> : (II)V
/*    */     //   244: checkcast java/lang/Iterable
/*    */     //   247: invokestatic toList : (Ljava/lang/Iterable;)Ljava/util/List;
/*    */     //   250: checkcast java/util/Collection
/*    */     //   253: invokestatic toIntArray : (Ljava/util/Collection;)[I
/*    */     //   256: astore_2
/*    */     //   257: aload_2
/*    */     //   258: astore #5
/*    */     //   260: aload #5
/*    */     //   262: arraylength
/*    */     //   263: istore #6
/*    */     //   265: iconst_0
/*    */     //   266: istore #4
/*    */     //   268: iload #4
/*    */     //   270: iload #6
/*    */     //   272: if_icmpge -> 319
/*    */     //   275: aload #5
/*    */     //   277: iload #4
/*    */     //   279: iaload
/*    */     //   280: istore_3
/*    */     //   281: aload_0
/*    */     //   282: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   285: dup
/*    */     //   286: ifnull -> 292
/*    */     //   289: goto -> 294
/*    */     //   292: pop
/*    */     //   293: return
/*    */     //   294: iload_3
/*    */     //   295: invokeinterface getEquipmentInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   300: dup
/*    */     //   301: ifnull -> 307
/*    */     //   304: goto -> 311
/*    */     //   307: pop
/*    */     //   308: goto -> 313
/*    */     //   311: astore #7
/*    */     //   313: iinc #4, 1
/*    */     //   316: goto -> 268
/*    */     //   319: aload_0
/*    */     //   320: getfield intavetest : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   323: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   326: checkcast java/lang/Boolean
/*    */     //   329: invokevirtual booleanValue : ()Z
/*    */     //   332: ifeq -> 531
/*    */     //   335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   338: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   343: dup
/*    */     //   344: ifnonnull -> 350
/*    */     //   347: invokestatic throwNpe : ()V
/*    */     //   350: invokeinterface getTicksExisted : ()I
/*    */     //   355: aload_0
/*    */     //   356: getfield intavetesthurttime : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   359: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   362: checkcast java/lang/Number
/*    */     //   365: invokevirtual intValue : ()I
/*    */     //   368: irem
/*    */     //   369: ifne -> 531
/*    */     //   372: aload_0
/*    */     //   373: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   376: ifnull -> 521
/*    */     //   379: aload_0
/*    */     //   380: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   383: dup
/*    */     //   384: ifnull -> 390
/*    */     //   387: goto -> 392
/*    */     //   390: pop
/*    */     //   391: return
/*    */     //   392: aload_0
/*    */     //   393: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   396: dup
/*    */     //   397: ifnull -> 403
/*    */     //   400: goto -> 405
/*    */     //   403: pop
/*    */     //   404: return
/*    */     //   405: invokeinterface getRotationYawHead : ()F
/*    */     //   410: invokeinterface setRotationYawHead : (F)V
/*    */     //   415: aload_0
/*    */     //   416: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   419: dup
/*    */     //   420: ifnull -> 426
/*    */     //   423: goto -> 428
/*    */     //   426: pop
/*    */     //   427: return
/*    */     //   428: aload_0
/*    */     //   429: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   432: dup
/*    */     //   433: ifnull -> 439
/*    */     //   436: goto -> 441
/*    */     //   439: pop
/*    */     //   440: return
/*    */     //   441: invokeinterface getRenderYawOffset : ()F
/*    */     //   446: invokeinterface setRenderYawOffset : (F)V
/*    */     //   451: aload_0
/*    */     //   452: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   455: dup
/*    */     //   456: ifnull -> 462
/*    */     //   459: goto -> 464
/*    */     //   462: pop
/*    */     //   463: return
/*    */     //   464: aload_0
/*    */     //   465: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   468: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP
/*    */     //   471: dup
/*    */     //   472: ifnull -> 478
/*    */     //   475: goto -> 480
/*    */     //   478: pop
/*    */     //   479: return
/*    */     //   480: invokeinterface copyLocationAndAnglesFrom : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*    */     //   485: aload_0
/*    */     //   486: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   489: dup
/*    */     //   490: ifnull -> 496
/*    */     //   493: goto -> 498
/*    */     //   496: pop
/*    */     //   497: return
/*    */     //   498: aload_0
/*    */     //   499: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   502: dup
/*    */     //   503: ifnull -> 509
/*    */     //   506: goto -> 511
/*    */     //   509: pop
/*    */     //   510: return
/*    */     //   511: invokeinterface getRotationYawHead : ()F
/*    */     //   516: invokeinterface setRotationYawHead : (F)V
/*    */     //   521: aload_0
/*    */     //   522: getfield pulseTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   525: invokevirtual reset : ()V
/*    */     //   528: goto -> 727
/*    */     //   531: aload_0
/*    */     //   532: getfield intavetest : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   535: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   538: checkcast java/lang/Boolean
/*    */     //   541: invokevirtual booleanValue : ()Z
/*    */     //   544: ifne -> 727
/*    */     //   547: aload_0
/*    */     //   548: getfield pulseTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   551: aload_0
/*    */     //   552: getfield pulseDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   555: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   558: checkcast java/lang/Number
/*    */     //   561: invokevirtual intValue : ()I
/*    */     //   564: i2l
/*    */     //   565: invokevirtual hasTimePassed : (J)Z
/*    */     //   568: ifeq -> 727
/*    */     //   571: aload_0
/*    */     //   572: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   575: ifnull -> 720
/*    */     //   578: aload_0
/*    */     //   579: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   582: dup
/*    */     //   583: ifnull -> 589
/*    */     //   586: goto -> 591
/*    */     //   589: pop
/*    */     //   590: return
/*    */     //   591: aload_0
/*    */     //   592: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   595: dup
/*    */     //   596: ifnull -> 602
/*    */     //   599: goto -> 604
/*    */     //   602: pop
/*    */     //   603: return
/*    */     //   604: invokeinterface getRotationYawHead : ()F
/*    */     //   609: invokeinterface setRotationYawHead : (F)V
/*    */     //   614: aload_0
/*    */     //   615: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   618: dup
/*    */     //   619: ifnull -> 625
/*    */     //   622: goto -> 627
/*    */     //   625: pop
/*    */     //   626: return
/*    */     //   627: aload_0
/*    */     //   628: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   631: dup
/*    */     //   632: ifnull -> 638
/*    */     //   635: goto -> 640
/*    */     //   638: pop
/*    */     //   639: return
/*    */     //   640: invokeinterface getRenderYawOffset : ()F
/*    */     //   645: invokeinterface setRenderYawOffset : (F)V
/*    */     //   650: aload_0
/*    */     //   651: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   654: dup
/*    */     //   655: ifnull -> 661
/*    */     //   658: goto -> 663
/*    */     //   661: pop
/*    */     //   662: return
/*    */     //   663: aload_0
/*    */     //   664: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   667: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP
/*    */     //   670: dup
/*    */     //   671: ifnull -> 677
/*    */     //   674: goto -> 679
/*    */     //   677: pop
/*    */     //   678: return
/*    */     //   679: invokeinterface copyLocationAndAnglesFrom : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*    */     //   684: aload_0
/*    */     //   685: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   688: dup
/*    */     //   689: ifnull -> 695
/*    */     //   692: goto -> 697
/*    */     //   695: pop
/*    */     //   696: return
/*    */     //   697: aload_0
/*    */     //   698: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   701: dup
/*    */     //   702: ifnull -> 708
/*    */     //   705: goto -> 710
/*    */     //   708: pop
/*    */     //   709: return
/*    */     //   710: invokeinterface getRotationYawHead : ()F
/*    */     //   715: invokeinterface setRotationYawHead : (F)V
/*    */     //   720: aload_0
/*    */     //   721: getfield pulseTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   724: invokevirtual reset : ()V
/*    */     //   727: aload_0
/*    */     //   728: getfield shown : Z
/*    */     //   731: ifne -> 1204
/*    */     //   734: aload_0
/*    */     //   735: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   738: ifnull -> 1204
/*    */     //   741: aload_0
/*    */     //   742: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   745: dup
/*    */     //   746: ifnull -> 752
/*    */     //   749: goto -> 754
/*    */     //   752: pop
/*    */     //   753: return
/*    */     //   754: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*    */     //   759: ifnull -> 1204
/*    */     //   762: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   765: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   770: aload_0
/*    */     //   771: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   774: dup
/*    */     //   775: ifnull -> 781
/*    */     //   778: goto -> 783
/*    */     //   781: pop
/*    */     //   782: return
/*    */     //   783: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*    */     //   788: dup
/*    */     //   789: ifnull -> 795
/*    */     //   792: goto -> 797
/*    */     //   795: pop
/*    */     //   796: return
/*    */     //   797: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*    */     //   802: ifnull -> 1204
/*    */     //   805: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   808: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   813: aload_0
/*    */     //   814: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   817: dup
/*    */     //   818: ifnull -> 824
/*    */     //   821: goto -> 826
/*    */     //   824: pop
/*    */     //   825: return
/*    */     //   826: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*    */     //   831: dup
/*    */     //   832: ifnull -> 838
/*    */     //   835: goto -> 840
/*    */     //   838: pop
/*    */     //   839: return
/*    */     //   840: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*    */     //   845: dup
/*    */     //   846: ifnonnull -> 852
/*    */     //   849: invokestatic throwNpe : ()V
/*    */     //   852: invokeinterface getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   857: ifnull -> 1204
/*    */     //   860: new net/minecraft/client/entity/EntityOtherPlayerMP
/*    */     //   863: dup
/*    */     //   864: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   867: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*    */     //   870: dup
/*    */     //   871: ifnull -> 880
/*    */     //   874: checkcast net/minecraft/world/World
/*    */     //   877: goto -> 882
/*    */     //   880: pop
/*    */     //   881: return
/*    */     //   882: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   885: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   890: aload_0
/*    */     //   891: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   894: dup
/*    */     //   895: ifnull -> 901
/*    */     //   898: goto -> 903
/*    */     //   901: pop
/*    */     //   902: return
/*    */     //   903: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*    */     //   908: dup
/*    */     //   909: ifnull -> 915
/*    */     //   912: goto -> 917
/*    */     //   915: pop
/*    */     //   916: return
/*    */     //   917: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*    */     //   922: dup
/*    */     //   923: ifnonnull -> 929
/*    */     //   926: invokestatic throwNpe : ()V
/*    */     //   929: invokeinterface getGameProfile : ()Lcom/mojang/authlib/GameProfile;
/*    */     //   934: dup
/*    */     //   935: ifnull -> 941
/*    */     //   938: goto -> 943
/*    */     //   941: pop
/*    */     //   942: return
/*    */     //   943: invokespecial <init> : (Lnet/minecraft/world/World;Lcom/mojang/authlib/GameProfile;)V
/*    */     //   946: astore_2
/*    */     //   947: aload_2
/*    */     //   948: aload_0
/*    */     //   949: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   952: dup
/*    */     //   953: ifnull -> 959
/*    */     //   956: goto -> 961
/*    */     //   959: pop
/*    */     //   960: return
/*    */     //   961: invokeinterface getRotationYawHead : ()F
/*    */     //   966: putfield field_70759_as : F
/*    */     //   969: aload_2
/*    */     //   970: aload_0
/*    */     //   971: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   974: dup
/*    */     //   975: ifnull -> 981
/*    */     //   978: goto -> 983
/*    */     //   981: pop
/*    */     //   982: return
/*    */     //   983: invokeinterface getRenderYawOffset : ()F
/*    */     //   988: putfield field_70761_aq : F
/*    */     //   991: aload_2
/*    */     //   992: aload_0
/*    */     //   993: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   996: dup
/*    */     //   997: ifnonnull -> 1011
/*    */     //   1000: new kotlin/TypeCastException
/*    */     //   1003: dup
/*    */     //   1004: ldc_w 'null cannot be cast to non-null type net.minecraft.entity.EntityLivingBase'
/*    */     //   1007: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   1010: athrow
/*    */     //   1011: checkcast net/minecraft/entity/EntityLivingBase
/*    */     //   1014: dup
/*    */     //   1015: ifnull -> 1024
/*    */     //   1018: checkcast net/minecraft/entity/Entity
/*    */     //   1021: goto -> 1026
/*    */     //   1024: pop
/*    */     //   1025: return
/*    */     //   1026: invokevirtual func_82149_j : (Lnet/minecraft/entity/Entity;)V
/*    */     //   1029: aload_2
/*    */     //   1030: aload_0
/*    */     //   1031: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   1034: dup
/*    */     //   1035: ifnull -> 1041
/*    */     //   1038: goto -> 1043
/*    */     //   1041: pop
/*    */     //   1042: return
/*    */     //   1043: invokeinterface getRotationYawHead : ()F
/*    */     //   1048: putfield field_70759_as : F
/*    */     //   1051: aload_2
/*    */     //   1052: aload_0
/*    */     //   1053: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   1056: dup
/*    */     //   1057: ifnull -> 1063
/*    */     //   1060: goto -> 1065
/*    */     //   1063: pop
/*    */     //   1064: return
/*    */     //   1065: invokeinterface getHealth : ()F
/*    */     //   1070: invokevirtual func_70606_j : (F)V
/*    */     //   1073: iconst_0
/*    */     //   1074: istore #4
/*    */     //   1076: new kotlin/ranges/IntRange
/*    */     //   1079: dup
/*    */     //   1080: iload #4
/*    */     //   1082: iconst_4
/*    */     //   1083: invokespecial <init> : (II)V
/*    */     //   1086: checkcast java/lang/Iterable
/*    */     //   1089: invokestatic toList : (Ljava/lang/Iterable;)Ljava/util/List;
/*    */     //   1092: checkcast java/util/Collection
/*    */     //   1095: invokestatic toIntArray : (Ljava/util/Collection;)[I
/*    */     //   1098: astore_3
/*    */     //   1099: aload_3
/*    */     //   1100: astore #6
/*    */     //   1102: aload #6
/*    */     //   1104: arraylength
/*    */     //   1105: istore #7
/*    */     //   1107: iconst_0
/*    */     //   1108: istore #5
/*    */     //   1110: iload #5
/*    */     //   1112: iload #7
/*    */     //   1114: if_icmpge -> 1163
/*    */     //   1117: aload #6
/*    */     //   1119: iload #5
/*    */     //   1121: iaload
/*    */     //   1122: istore #4
/*    */     //   1124: aload_0
/*    */     //   1125: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*    */     //   1128: dup
/*    */     //   1129: ifnull -> 1135
/*    */     //   1132: goto -> 1137
/*    */     //   1135: pop
/*    */     //   1136: return
/*    */     //   1137: iload #4
/*    */     //   1139: invokeinterface getEquipmentInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   1144: dup
/*    */     //   1145: ifnull -> 1151
/*    */     //   1148: goto -> 1155
/*    */     //   1151: pop
/*    */     //   1152: goto -> 1157
/*    */     //   1155: astore #8
/*    */     //   1157: iinc #5, 1
/*    */     //   1160: goto -> 1110
/*    */     //   1163: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*    */     //   1166: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*    */     //   1169: dup
/*    */     //   1170: ifnull -> 1176
/*    */     //   1173: goto -> 1178
/*    */     //   1176: pop
/*    */     //   1177: return
/*    */     //   1178: sipush #-1337
/*    */     //   1181: aload_2
/*    */     //   1182: checkcast net/minecraft/entity/Entity
/*    */     //   1185: invokevirtual func_73027_a : (ILnet/minecraft/entity/Entity;)V
/*    */     //   1188: aload_0
/*    */     //   1189: getfield fakePlayer : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;
/*    */     //   1192: aload_2
/*    */     //   1193: if_acmpne -> 1199
/*    */     //   1196: goto -> 1199
/*    */     //   1199: aload_0
/*    */     //   1200: iconst_1
/*    */     //   1201: putfield shown : Z
/*    */     //   1204: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #84	-> 6
/*    */     //   #85	-> 32
/*    */     //   #86	-> 40
/*    */     //   #86	-> 55
/*    */     //   #86	-> 68
/*    */     //   #86	-> 80
/*    */     //   #87	-> 81
/*    */     //   #89	-> 89
/*    */     //   #90	-> 100
/*    */     //   #91	-> 101
/*    */     //   #91	-> 125
/*    */     //   #91	-> 144
/*    */     //   #92	-> 157
/*    */     //   #92	-> 171
/*    */     //   #91	-> 173
/*    */     //   #95	-> 179
/*    */     //   #97	-> 183
/*    */     //   #98	-> 197
/*    */     //   #98	-> 208
/*    */     //   #98	-> 221
/*    */     //   #99	-> 233
/*    */     //   #100	-> 257
/*    */     //   #101	-> 281
/*    */     //   #101	-> 292
/*    */     //   #101	-> 307
/*    */     //   #100	-> 313
/*    */     //   #104	-> 319
/*    */     //   #105	-> 372
/*    */     //   #106	-> 379
/*    */     //   #106	-> 390
/*    */     //   #106	-> 403
/*    */     //   #107	-> 415
/*    */     //   #107	-> 426
/*    */     //   #107	-> 439
/*    */     //   #108	-> 451
/*    */     //   #108	-> 462
/*    */     //   #108	-> 478
/*    */     //   #109	-> 485
/*    */     //   #109	-> 496
/*    */     //   #109	-> 509
/*    */     //   #111	-> 521
/*    */     //   #112	-> 531
/*    */     //   #113	-> 571
/*    */     //   #114	-> 578
/*    */     //   #114	-> 589
/*    */     //   #114	-> 602
/*    */     //   #115	-> 614
/*    */     //   #115	-> 625
/*    */     //   #115	-> 638
/*    */     //   #116	-> 650
/*    */     //   #116	-> 661
/*    */     //   #116	-> 677
/*    */     //   #117	-> 684
/*    */     //   #117	-> 695
/*    */     //   #117	-> 708
/*    */     //   #119	-> 720
/*    */     //   #120	-> 727
/*    */     //   #122	-> 727
/*    */     //   #124	-> 727
/*    */     //   #122	-> 752
/*    */     //   #122	-> 753
/*    */     //   #123	-> 770
/*    */     //   #123	-> 781
/*    */     //   #123	-> 795
/*    */     //   #122	-> 797
/*    */     //   #124	-> 805
/*    */     //   #124	-> 824
/*    */     //   #124	-> 838
/*    */     //   #126	-> 860
/*    */     //   #127	-> 864
/*    */     //   #127	-> 880
/*    */     //   #128	-> 882
/*    */     //   #128	-> 901
/*    */     //   #128	-> 915
/*    */     //   #128	-> 941
/*    */     //   #126	-> 943
/*    */     //   #131	-> 947
/*    */     //   #131	-> 959
/*    */     //   #132	-> 969
/*    */     //   #132	-> 981
/*    */     //   #133	-> 991
/*    */     //   #133	-> 1024
/*    */     //   #134	-> 1029
/*    */     //   #134	-> 1041
/*    */     //   #135	-> 1051
/*    */     //   #135	-> 1063
/*    */     //   #136	-> 1073
/*    */     //   #137	-> 1099
/*    */     //   #138	-> 1124
/*    */     //   #138	-> 1135
/*    */     //   #138	-> 1151
/*    */     //   #137	-> 1157
/*    */     //   #140	-> 1163
/*    */     //   #140	-> 1176
/*    */     //   #142	-> 1188
/*    */     //   #143	-> 1199
/*    */     //   #145	-> 1204
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   281	35	3	index	I
/*    */     //   257	62	2	indices	[I
/*    */     //   1124	36	4	index	I
/*    */     //   1099	105	3	indices	[I
/*    */     //   947	257	2	faker	Lnet/minecraft/client/entity/EntityOtherPlayerMP;
/*    */     //   0	1205	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/BackTrack;
/*    */     //   0	1205	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\BackTrack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */