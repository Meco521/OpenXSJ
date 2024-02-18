/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function4;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.server.ISPacketEntityVelocity;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.misc.Teams;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.Blink;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "Criticals", description = "Automatically deals critical hits.", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000t\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\r\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\016\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\0205\032\0020\0252\006\0206\032\00207H\002J\022\0208\032\0020\0252\b\0206\032\004\030\00109H\002J\020\020:\032\0020;2\006\020<\032\0020=H\007J\b\020>\032\0020;H\026J\020\020?\032\0020;2\006\020<\032\0020@H\007J\020\020A\032\0020;2\006\020<\032\0020BH\007J\020\020C\032\0020;2\006\020<\032\0020DH\007R\016\020\003\032\0020\004X\016¢\006\002\n\000R\032\020\005\032\0020\004X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\016\020\n\032\0020\004X\016¢\006\002\n\000R\016\020\013\032\0020\004X\016¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\021\020\020\032\0020\021¢\006\b\n\000\032\004\b\022\020\023R\032\020\024\032\0020\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031R\032\020\032\032\0020\025X\016¢\006\016\n\000\032\004\b\033\020\027\"\004\b\034\020\031R\016\020\035\032\0020\021X\004¢\006\002\n\000R\016\020\036\032\0020\004X\016¢\006\002\n\000R\032\020\037\032\0020\004X\016¢\006\016\n\000\032\004\b \020\007\"\004\b!\020\tR\021\020\"\032\0020#¢\006\b\n\000\032\004\b$\020%R\021\020&\032\0020'¢\006\b\n\000\032\004\b(\020)R\021\020*\032\0020#¢\006\b\n\000\032\004\b+\020%R\016\020,\032\0020\017X\004¢\006\002\n\000R\021\020-\032\0020'¢\006\b\n\000\032\004\b.\020)R\026\020/\032\004\030\001008VX\004¢\006\006\032\004\b1\0202R\016\0203\032\0020\rX\004¢\006\002\n\000R\016\0204\032\0020\025X\016¢\006\002\n\000¨\006E"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "airtick", "", "attacks", "getAttacks", "()I", "setAttacks", "(I)V", "blinktick", "counter", "criticalsrangevaule", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "debug", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getDelayValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "dolag", "", "getDolag", "()Z", "setDolag", "(Z)V", "dotimercri", "getDotimercri", "setDotimercri", "hurtTimeValue", "jump", "lagtick", "getLagtick", "setLagtick", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getMsTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "packet", "getPacket", "ramd", "restVL", "getRestVL", "tag", "", "getTag", "()Ljava/lang/String;", "timervalue", "velocityInput", "isAlive", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "isEnemy", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onEnable", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "XSJClient"})
/*     */ public final class Criticals
/*     */   extends Module
/*     */ {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\020\006\n\002\b\003\n\002\020\013\n\000\020\000\032\0020\0012\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\0032\006\020\006\032\0020\007H\n¢\006\002\b\b"}, d2 = {"sendCriticalPacket", "", "xOffset", "", "yOffset", "zOffset", "ground", "", "invoke"})
/*     */   static final class Criticals$onAttack$1
/*     */     extends Lambda
/*     */     implements Function4<Double, Double, Double, Boolean, Unit>
/*     */   {
/*     */     public final void invoke(double xOffset, double yOffset, double zOffset, boolean ground) {
/* 127 */       double posX = this.$thePlayer.getPosX() + xOffset;
/* 128 */       double posY = this.$thePlayer.getPosY() + yOffset;
/* 129 */       double posZ = this.$thePlayer.getPosZ() + zOffset;
/* 130 */       if (Intrinsics.areEqual(Criticals.this.getPacket().get(), "C06")) {
/* 131 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosLook(posX, posY, posZ, this.$thePlayer.getRotationYaw(), this.$thePlayer.getRotationPitch(), ground));
/*     */       } else {
/* 133 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(posX, posY, posZ, ground));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Criticals$onAttack$1(IEntityPlayerSP param1IEntityPlayerSP) {
/*     */       super(4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final ListValue modeValue = new ListValue("Mode", new String[] { 
/*     */         "Legit", "TimerJump", "newpacket", "non-calculable", "invalid", "nanopacket", "verussmart", "Jumppacket", "Packet4", "C03", 
/*     */         "Packet", "Packet2", "Packet3", "Vulcan", "AAC4ByHyt", "SpartanSemi", "NcpPacket", "Vanilla", "AAC4", "AAC5", 
/*     */         "VerusSmart", "NoGround", "Hop", "TPHop", "Jump", "LowJump", "Visual" }, "TimerJump");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final ListValue getModeValue() {
/*     */     return this.modeValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final IntegerValue delayValue = new IntegerValue("Delay", 0, 0, 500);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final IntegerValue getDelayValue() {
/*     */     return this.delayValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue timervalue = new FloatValue("TimerValue", 0.75F, 0.1F, 1.0F);
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue criticalsrangevaule = new FloatValue("Criticalsrange", 2.0F, 0.1F, 6.0F);
/*     */ 
/*     */   
/*     */   private final IntegerValue hurtTimeValue = new IntegerValue("HurtTime", 10, 0, 10);
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final ListValue packet = new ListValue("PacketMode", new String[] { "C04", "C06" }, "C04");
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final ListValue getPacket() {
/*     */     return this.packet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue debug = new BoolValue("Debug", true);
/*     */ 
/*     */   
/*     */   private final BoolValue ramd = new BoolValue("Rnd Lv", true);
/*     */ 
/*     */   
/*     */   private boolean velocityInput;
/*     */ 
/*     */   
/*     */   private int attacks;
/*     */ 
/*     */   
/*     */   private int lagtick;
/*     */ 
/*     */   
/*     */   private boolean dolag;
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getAttacks() {
/*     */     return this.attacks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setAttacks(int <set-?>) {
/*     */     this.attacks = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLagtick() {
/*     */     return this.lagtick;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLagtick(int <set-?>) {
/*     */     this.lagtick = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean getDolag() {
/*     */     return this.dolag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setDolag(boolean <set-?>) {
/*     */     this.dolag = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final MSTimer msTimer = new MSTimer();
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final MSTimer getMsTimer() {
/*     */     return this.msTimer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final MSTimer restVL = new MSTimer();
/*     */ 
/*     */   
/*     */   private int counter;
/*     */ 
/*     */   
/*     */   private int blinktick;
/*     */ 
/*     */   
/*     */   private int jump;
/*     */ 
/*     */   
/*     */   private int airtick;
/*     */ 
/*     */   
/*     */   private boolean dotimercri;
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final MSTimer getRestVL() {
/*     */     return this.restVL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*     */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */     if (StringsKt.equals((String)this.modeValue.get(), "NoGround", true)) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */         Intrinsics.throwNpe();
/*     */       }
/*     */       MinecraftInstance.mc.getThePlayer().jump();
/*     */     } 
/*     */     if (StringsKt.equals((String)this.modeValue.get(), "C03", true)) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */         Intrinsics.throwNpe();
/*     */       }
/*     */       MinecraftInstance.mc.getThePlayer().jump();
/*     */     } 
/*     */     this.lagtick = 0;
/*     */     this.dolag = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull MotionEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (!MinecraftInstance.mc2.field_71439_g.field_70122_E) {
/*     */       int j;
/*     */       this.airtick = (j = this.airtick) + 1;
/*     */     } else {
/*     */       this.airtick = 0;
/*     */     } 
/*     */     if (Retreat.INSTANCE.getModuleManager().get(Blink.class) == null) {
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.Blink");
/*     */     }
/*     */     Blink blink = (Blink)Retreat.INSTANCE.getModuleManager().get(Blink.class);
/*     */     if (blink.getState()) {
/*     */       this.blinktick = 100;
/*     */     } else {
/*     */       int j;
/*     */       this.blinktick = (j = this.blinktick) + -1;
/*     */     } 
/*     */     if (this.dotimercri) {
/*     */       if (this.airtick == 1) {
/*     */         MinecraftInstance.mc2.field_71474_y.field_74314_A.field_74513_e = false;
/*     */       }
/*     */       int j = this.airtick;
/*     */       if (6 > j) {
/*     */         10;
/*     */       } else if (10 >= j && !MinecraftInstance.mc2.field_71439_g.field_70122_E) {
/*     */         MinecraftInstance.mc.getTimer().setTimerSpeed(((Number)this.timervalue.get()).floatValue());
/*     */       } 
/*     */       if (this.airtick > 10 || this.airtick == 0 || MinecraftInstance.mc2.field_71439_g.field_70122_E) {
/*     */         MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */         this.dotimercri = false;
/*     */       } 
/*     */     } 
/*     */     int i;
/*     */     this.jump = (i = this.jump) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean isAlive(IEntityLivingBase entity) {
/*     */     return (entity.isEntityAlive() && entity.getHealth() > false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean isEnemy(IEntity entity) {
/*     */     if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && entity != null && (EntityUtils.targetDead || isAlive(entity.asEntityLivingBase())) && (Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0) {
/*     */       if (!EntityUtils.targetInvisible && entity.isInvisible()) {
/*     */         return false;
/*     */       }
/*     */       if (EntityUtils.targetPlayer && MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/*     */         IEntityPlayer player = entity.asEntityPlayer();
/*     */         if (player.isSpectator() || AntiBot.isBot((IEntityLivingBase)player)) {
/*     */           return false;
/*     */         }
/*     */         if (PlayerExtensionKt.isClientFriend(player) && !Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState()) {
/*     */           return false;
/*     */         }
/*     */         if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null) {
/*     */           throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams");
/*     */         }
/*     */         Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class);
/*     */         return (!teams.getState() || !teams.isInYourTeam(entity.asEntityLivingBase()));
/*     */       } 
/*     */       return ((EntityUtils.targetMobs && PlayerExtensionKt.isMob(entity)) || (EntityUtils.targetAnimals && PlayerExtensionKt.isAnimal(entity)));
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean getDotimercri() {
/*     */     return this.dotimercri;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setDotimercri(boolean <set-?>) {
/*     */     this.dotimercri = <set-?>;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     this.jump = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnonnull -> 21
/*     */     //   18: invokestatic throwNpe : ()V
/*     */     //   21: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   24: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.JUMP : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*     */     //   27: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   32: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*     */     //   37: ifeq -> 41
/*     */     //   40: return
/*     */     //   41: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   44: aload_1
/*     */     //   45: invokevirtual getTargetEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   48: invokeinterface isEntityLivingBase : (Ljava/lang/Object;)Z
/*     */     //   53: ifeq -> 5514
/*     */     //   56: aload_0
/*     */     //   57: aload_1
/*     */     //   58: invokevirtual getTargetEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   61: invokespecial isEnemy : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*     */     //   64: ifeq -> 5514
/*     */     //   67: aload_1
/*     */     //   68: invokevirtual getTargetEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   71: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   74: bipush #80
/*     */     //   76: i2d
/*     */     //   77: dcmpg
/*     */     //   78: ifge -> 5514
/*     */     //   81: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   84: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   89: dup
/*     */     //   90: ifnonnull -> 96
/*     */     //   93: invokestatic throwNpe : ()V
/*     */     //   96: aload_1
/*     */     //   97: invokevirtual getTargetEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   100: dup
/*     */     //   101: ifnonnull -> 107
/*     */     //   104: invokestatic throwNpe : ()V
/*     */     //   107: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*     */     //   112: aload_0
/*     */     //   113: getfield criticalsrangevaule : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   116: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   119: checkcast java/lang/Number
/*     */     //   122: invokevirtual floatValue : ()F
/*     */     //   125: fcmpg
/*     */     //   126: ifgt -> 5514
/*     */     //   129: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   132: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   137: dup
/*     */     //   138: ifnull -> 144
/*     */     //   141: goto -> 146
/*     */     //   144: pop
/*     */     //   145: return
/*     */     //   146: astore_2
/*     */     //   147: aload_1
/*     */     //   148: invokevirtual getTargetEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   151: dup
/*     */     //   152: ifnonnull -> 158
/*     */     //   155: invokestatic throwNpe : ()V
/*     */     //   158: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   163: astore_3
/*     */     //   164: new net/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1
/*     */     //   167: dup
/*     */     //   168: aload_0
/*     */     //   169: aload_2
/*     */     //   170: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   173: astore #4
/*     */     //   175: aload_2
/*     */     //   176: invokeinterface getOnGround : ()Z
/*     */     //   181: ifeq -> 293
/*     */     //   184: aload_2
/*     */     //   185: invokeinterface isOnLadder : ()Z
/*     */     //   190: ifne -> 293
/*     */     //   193: aload_2
/*     */     //   194: invokeinterface isInWeb : ()Z
/*     */     //   199: ifne -> 293
/*     */     //   202: aload_2
/*     */     //   203: invokeinterface isInWater : ()Z
/*     */     //   208: ifne -> 293
/*     */     //   211: aload_2
/*     */     //   212: invokeinterface isInLava : ()Z
/*     */     //   217: ifne -> 293
/*     */     //   220: aload_2
/*     */     //   221: invokeinterface getRidingEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   226: ifnonnull -> 293
/*     */     //   229: aload_3
/*     */     //   230: invokeinterface getHurtTime : ()I
/*     */     //   235: aload_0
/*     */     //   236: getfield hurtTimeValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   239: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   242: checkcast java/lang/Number
/*     */     //   245: invokevirtual intValue : ()I
/*     */     //   248: if_icmpgt -> 293
/*     */     //   251: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   254: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   257: ldc_w net/ccbluex/liquidbounce/features/module/modules/movement/Fly
/*     */     //   260: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   263: invokevirtual getState : ()Z
/*     */     //   266: ifne -> 293
/*     */     //   269: aload_0
/*     */     //   270: getfield msTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   273: aload_0
/*     */     //   274: getfield delayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   277: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   280: checkcast java/lang/Number
/*     */     //   283: invokevirtual intValue : ()I
/*     */     //   286: i2l
/*     */     //   287: invokevirtual hasTimePassed : (J)Z
/*     */     //   290: ifne -> 294
/*     */     //   293: return
/*     */     //   294: aload_2
/*     */     //   295: invokeinterface getPosX : ()D
/*     */     //   300: dstore #5
/*     */     //   302: aload_2
/*     */     //   303: invokeinterface getPosY : ()D
/*     */     //   308: dstore #7
/*     */     //   310: aload_2
/*     */     //   311: invokeinterface getPosZ : ()D
/*     */     //   316: dstore #9
/*     */     //   318: aload_0
/*     */     //   319: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   322: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   325: checkcast java/lang/String
/*     */     //   328: astore #11
/*     */     //   330: iconst_0
/*     */     //   331: istore #12
/*     */     //   333: aload #11
/*     */     //   335: dup
/*     */     //   336: ifnonnull -> 350
/*     */     //   339: new kotlin/TypeCastException
/*     */     //   342: dup
/*     */     //   343: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   346: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   349: athrow
/*     */     //   350: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   353: dup
/*     */     //   354: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   357: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   360: astore #11
/*     */     //   362: aload #11
/*     */     //   364: invokevirtual hashCode : ()I
/*     */     //   367: lookupswitch default -> 5507, -1362618874 -> 680, -995865464 -> 652, -891664989 -> 806, -807058262 -> 736, -807058261 -> 694, -807058260 -> 624, -805359837 -> 876, -684807295 -> 708, 103497 -> 596, 2001010 -> 666, 2986065 -> 862, 3273774 -> 904, 53924083 -> 582, 102851513 -> 792, 110568525 -> 834, 112097665 -> 722, 216546856 -> 568, 233102203 -> 890, 233694774 -> 848, 357158274 -> 638, 1394468072 -> 750, 1570934811 -> 820, 1959784951 -> 778, 2092298300 -> 610
/*     */     //   568: aload #11
/*     */     //   570: ldc_w 'newpacket'
/*     */     //   573: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   576: ifeq -> 5507
/*     */     //   579: goto -> 1978
/*     */     //   582: aload #11
/*     */     //   584: ldc_w 'timerjump'
/*     */     //   587: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   590: ifeq -> 5507
/*     */     //   593: goto -> 918
/*     */     //   596: aload #11
/*     */     //   598: ldc_w 'hop'
/*     */     //   601: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   604: ifeq -> 5507
/*     */     //   607: goto -> 4536
/*     */     //   610: aload #11
/*     */     //   612: ldc_w 'nanopacket'
/*     */     //   615: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   618: ifeq -> 5507
/*     */     //   621: goto -> 1652
/*     */     //   624: aload #11
/*     */     //   626: ldc_w 'packet4'
/*     */     //   629: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   632: ifeq -> 5507
/*     */     //   635: goto -> 2131
/*     */     //   638: aload #11
/*     */     //   640: ldc_w 'lowjump'
/*     */     //   643: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   646: ifeq -> 5507
/*     */     //   649: goto -> 4723
/*     */     //   652: aload #11
/*     */     //   654: ldc_w 'packet'
/*     */     //   657: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   660: ifeq -> 5507
/*     */     //   663: goto -> 1833
/*     */     //   666: aload #11
/*     */     //   668: ldc_w 'AAC5'
/*     */     //   671: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   674: ifeq -> 5507
/*     */     //   677: goto -> 2603
/*     */     //   680: aload #11
/*     */     //   682: ldc_w 'non-calculable'
/*     */     //   685: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   688: ifeq -> 5507
/*     */     //   691: goto -> 2249
/*     */     //   694: aload #11
/*     */     //   696: ldc_w 'packet3'
/*     */     //   699: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   702: ifeq -> 5507
/*     */     //   705: goto -> 5251
/*     */     //   708: aload #11
/*     */     //   710: ldc_w 'spartansemi'
/*     */     //   713: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   716: ifeq -> 5507
/*     */     //   719: goto -> 3010
/*     */     //   722: aload #11
/*     */     //   724: ldc_w 'verus'
/*     */     //   727: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   730: ifeq -> 5507
/*     */     //   733: goto -> 4735
/*     */     //   736: aload #11
/*     */     //   738: ldc_w 'packet2'
/*     */     //   741: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   744: ifeq -> 5507
/*     */     //   747: goto -> 4938
/*     */     //   750: aload #11
/*     */     //   752: ldc_w 'verussmart'
/*     */     //   755: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   758: ifeq -> 764
/*     */     //   761: goto -> 2500
/*     */     //   764: aload #11
/*     */     //   766: ldc_w 'verussmart'
/*     */     //   769: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   772: ifeq -> 5507
/*     */     //   775: goto -> 4325
/*     */     //   778: aload #11
/*     */     //   780: ldc_w 'invalid'
/*     */     //   783: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   786: ifeq -> 5507
/*     */     //   789: goto -> 2392
/*     */     //   792: aload #11
/*     */     //   794: ldc_w 'legit'
/*     */     //   797: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   800: ifeq -> 5507
/*     */     //   803: goto -> 4688
/*     */     //   806: aload #11
/*     */     //   808: ldc_w 'ncppacket'
/*     */     //   811: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   814: ifeq -> 5507
/*     */     //   817: goto -> 3187
/*     */     //   820: aload #11
/*     */     //   822: ldc_w 'aac4byhyt'
/*     */     //   825: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   828: ifeq -> 5507
/*     */     //   831: goto -> 3413
/*     */     //   834: aload #11
/*     */     //   836: ldc_w 'tphop'
/*     */     //   839: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   842: ifeq -> 5507
/*     */     //   845: goto -> 4564
/*     */     //   848: aload #11
/*     */     //   850: ldc_w 'jumppacket'
/*     */     //   853: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   856: ifeq -> 5507
/*     */     //   859: goto -> 1101
/*     */     //   862: aload #11
/*     */     //   864: ldc_w 'aac4'
/*     */     //   867: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   870: ifeq -> 5507
/*     */     //   873: goto -> 3770
/*     */     //   876: aload #11
/*     */     //   878: ldc_w 'vulcan'
/*     */     //   881: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   884: ifeq -> 5507
/*     */     //   887: goto -> 4117
/*     */     //   890: aload #11
/*     */     //   892: ldc_w 'vanilla'
/*     */     //   895: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   898: ifeq -> 5507
/*     */     //   901: goto -> 3589
/*     */     //   904: aload #11
/*     */     //   906: ldc_w 'jump'
/*     */     //   909: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   912: ifeq -> 5507
/*     */     //   915: goto -> 4653
/*     */     //   918: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   921: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   924: ldc net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*     */     //   926: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   929: dup
/*     */     //   930: ifnonnull -> 943
/*     */     //   933: new kotlin/TypeCastException
/*     */     //   936: dup
/*     */     //   937: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.Blink'
/*     */     //   939: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   942: athrow
/*     */     //   943: checkcast net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*     */     //   946: astore #12
/*     */     //   948: aload #12
/*     */     //   950: invokevirtual getState : ()Z
/*     */     //   953: ifne -> 1066
/*     */     //   956: aload_0
/*     */     //   957: getfield blinktick : I
/*     */     //   960: ifgt -> 1066
/*     */     //   963: aload_2
/*     */     //   964: invokeinterface getOnGround : ()Z
/*     */     //   969: ifeq -> 5507
/*     */     //   972: aload_0
/*     */     //   973: getfield jump : I
/*     */     //   976: bipush #10
/*     */     //   978: if_icmple -> 5507
/*     */     //   981: aload_0
/*     */     //   982: getfield airtick : I
/*     */     //   985: ifne -> 5507
/*     */     //   988: aload_0
/*     */     //   989: getfield dotimercri : Z
/*     */     //   992: ifne -> 5507
/*     */     //   995: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   998: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   1001: getfield field_70737_aN : I
/*     */     //   1004: ifne -> 5507
/*     */     //   1007: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1010: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1013: getfield field_74314_A : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1016: iconst_1
/*     */     //   1017: putfield field_74513_e : Z
/*     */     //   1020: aload_0
/*     */     //   1021: iconst_0
/*     */     //   1022: putfield jump : I
/*     */     //   1025: aload_0
/*     */     //   1026: iconst_0
/*     */     //   1027: putfield airtick : I
/*     */     //   1030: aload_0
/*     */     //   1031: iconst_1
/*     */     //   1032: putfield dotimercri : Z
/*     */     //   1035: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1038: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1043: fconst_2
/*     */     //   1044: aload_0
/*     */     //   1045: getfield timervalue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1048: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1051: checkcast java/lang/Number
/*     */     //   1054: invokevirtual floatValue : ()F
/*     */     //   1057: fsub
/*     */     //   1058: invokeinterface setTimerSpeed : (F)V
/*     */     //   1063: goto -> 5507
/*     */     //   1066: aload_2
/*     */     //   1067: invokeinterface getOnGround : ()Z
/*     */     //   1072: ifeq -> 1098
/*     */     //   1075: aload_0
/*     */     //   1076: getfield jump : I
/*     */     //   1079: bipush #10
/*     */     //   1081: if_icmple -> 1098
/*     */     //   1084: aload_2
/*     */     //   1085: ldc2_w 0.41999998688698
/*     */     //   1088: invokeinterface setMotionY : (D)V
/*     */     //   1093: aload_0
/*     */     //   1094: iconst_0
/*     */     //   1095: putfield jump : I
/*     */     //   1098: goto -> 5507
/*     */     //   1101: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1104: dup
/*     */     //   1105: ldc_w 'mc2'
/*     */     //   1108: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1111: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1114: dup
/*     */     //   1115: ifnonnull -> 1121
/*     */     //   1118: invokestatic throwNpe : ()V
/*     */     //   1121: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1124: dup
/*     */     //   1125: iconst_0
/*     */     //   1126: bipush #100
/*     */     //   1128: iconst_1
/*     */     //   1129: invokespecial <init> : (ISZ)V
/*     */     //   1132: checkcast net/minecraft/network/Packet
/*     */     //   1135: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1138: aload #4
/*     */     //   1140: dconst_0
/*     */     //   1141: ldc2_w 0.41999998688698
/*     */     //   1144: dconst_0
/*     */     //   1145: iconst_0
/*     */     //   1146: iconst_5
/*     */     //   1147: aconst_null
/*     */     //   1148: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1151: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1154: dup
/*     */     //   1155: ldc_w 'mc2'
/*     */     //   1158: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1161: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1164: dup
/*     */     //   1165: ifnonnull -> 1171
/*     */     //   1168: invokestatic throwNpe : ()V
/*     */     //   1171: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1174: dup
/*     */     //   1175: iconst_0
/*     */     //   1176: bipush #100
/*     */     //   1178: iconst_1
/*     */     //   1179: invokespecial <init> : (ISZ)V
/*     */     //   1182: checkcast net/minecraft/network/Packet
/*     */     //   1185: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1188: aload #4
/*     */     //   1190: dconst_0
/*     */     //   1191: ldc2_w 0.7531999805212
/*     */     //   1194: dconst_0
/*     */     //   1195: iconst_0
/*     */     //   1196: iconst_5
/*     */     //   1197: aconst_null
/*     */     //   1198: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1204: dup
/*     */     //   1205: ldc_w 'mc2'
/*     */     //   1208: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1211: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1214: dup
/*     */     //   1215: ifnonnull -> 1221
/*     */     //   1218: invokestatic throwNpe : ()V
/*     */     //   1221: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1224: dup
/*     */     //   1225: iconst_0
/*     */     //   1226: bipush #100
/*     */     //   1228: iconst_1
/*     */     //   1229: invokespecial <init> : (ISZ)V
/*     */     //   1232: checkcast net/minecraft/network/Packet
/*     */     //   1235: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1238: aload #4
/*     */     //   1240: dconst_0
/*     */     //   1241: ldc2_w 1.00133597911214
/*     */     //   1244: dconst_0
/*     */     //   1245: iconst_0
/*     */     //   1246: iconst_5
/*     */     //   1247: aconst_null
/*     */     //   1248: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1251: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1254: dup
/*     */     //   1255: ldc_w 'mc2'
/*     */     //   1258: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1261: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1264: dup
/*     */     //   1265: ifnonnull -> 1271
/*     */     //   1268: invokestatic throwNpe : ()V
/*     */     //   1271: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1274: dup
/*     */     //   1275: iconst_0
/*     */     //   1276: bipush #100
/*     */     //   1278: iconst_1
/*     */     //   1279: invokespecial <init> : (ISZ)V
/*     */     //   1282: checkcast net/minecraft/network/Packet
/*     */     //   1285: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1288: aload #4
/*     */     //   1290: dconst_0
/*     */     //   1291: ldc2_w 1.16610926093821
/*     */     //   1294: dconst_0
/*     */     //   1295: iconst_0
/*     */     //   1296: iconst_5
/*     */     //   1297: aconst_null
/*     */     //   1298: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1301: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1304: dup
/*     */     //   1305: ldc_w 'mc2'
/*     */     //   1308: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1311: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1314: dup
/*     */     //   1315: ifnonnull -> 1321
/*     */     //   1318: invokestatic throwNpe : ()V
/*     */     //   1321: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1324: dup
/*     */     //   1325: iconst_0
/*     */     //   1326: bipush #100
/*     */     //   1328: iconst_1
/*     */     //   1329: invokespecial <init> : (ISZ)V
/*     */     //   1332: checkcast net/minecraft/network/Packet
/*     */     //   1335: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1338: aload #4
/*     */     //   1340: dconst_0
/*     */     //   1341: ldc2_w 1.24918707874468
/*     */     //   1344: dconst_0
/*     */     //   1345: iconst_0
/*     */     //   1346: iconst_5
/*     */     //   1347: aconst_null
/*     */     //   1348: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1351: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1354: dup
/*     */     //   1355: ldc_w 'mc2'
/*     */     //   1358: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1361: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1364: dup
/*     */     //   1365: ifnonnull -> 1371
/*     */     //   1368: invokestatic throwNpe : ()V
/*     */     //   1371: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1374: dup
/*     */     //   1375: iconst_0
/*     */     //   1376: bipush #100
/*     */     //   1378: iconst_1
/*     */     //   1379: invokespecial <init> : (ISZ)V
/*     */     //   1382: checkcast net/minecraft/network/Packet
/*     */     //   1385: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1388: aload #4
/*     */     //   1390: dconst_0
/*     */     //   1391: ldc2_w 1.1707870772188
/*     */     //   1394: dconst_0
/*     */     //   1395: iconst_0
/*     */     //   1396: iconst_5
/*     */     //   1397: aconst_null
/*     */     //   1398: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1401: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1404: dup
/*     */     //   1405: ldc_w 'mc2'
/*     */     //   1408: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1411: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1414: dup
/*     */     //   1415: ifnonnull -> 1421
/*     */     //   1418: invokestatic throwNpe : ()V
/*     */     //   1421: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1424: dup
/*     */     //   1425: iconst_0
/*     */     //   1426: bipush #100
/*     */     //   1428: iconst_1
/*     */     //   1429: invokespecial <init> : (ISZ)V
/*     */     //   1432: checkcast net/minecraft/network/Packet
/*     */     //   1435: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1438: aload #4
/*     */     //   1440: dconst_0
/*     */     //   1441: ldc2_w 1.0155550727022
/*     */     //   1444: dconst_0
/*     */     //   1445: iconst_0
/*     */     //   1446: iconst_5
/*     */     //   1447: aconst_null
/*     */     //   1448: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1451: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1454: dup
/*     */     //   1455: ldc_w 'mc2'
/*     */     //   1458: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1461: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1464: dup
/*     */     //   1465: ifnonnull -> 1471
/*     */     //   1468: invokestatic throwNpe : ()V
/*     */     //   1471: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1474: dup
/*     */     //   1475: iconst_0
/*     */     //   1476: bipush #100
/*     */     //   1478: iconst_1
/*     */     //   1479: invokespecial <init> : (ISZ)V
/*     */     //   1482: checkcast net/minecraft/network/Packet
/*     */     //   1485: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1488: aload #4
/*     */     //   1490: dconst_0
/*     */     //   1491: ldc2_w 0.78502770378924
/*     */     //   1494: dconst_0
/*     */     //   1495: iconst_0
/*     */     //   1496: iconst_5
/*     */     //   1497: aconst_null
/*     */     //   1498: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1501: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1504: dup
/*     */     //   1505: ldc_w 'mc2'
/*     */     //   1508: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1511: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1514: dup
/*     */     //   1515: ifnonnull -> 1521
/*     */     //   1518: invokestatic throwNpe : ()V
/*     */     //   1521: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1524: dup
/*     */     //   1525: iconst_0
/*     */     //   1526: bipush #100
/*     */     //   1528: iconst_1
/*     */     //   1529: invokespecial <init> : (ISZ)V
/*     */     //   1532: checkcast net/minecraft/network/Packet
/*     */     //   1535: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1538: aload #4
/*     */     //   1540: dconst_0
/*     */     //   1541: ldc2_w 0.4807108763317
/*     */     //   1544: dconst_0
/*     */     //   1545: iconst_0
/*     */     //   1546: iconst_5
/*     */     //   1547: aconst_null
/*     */     //   1548: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1551: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1554: dup
/*     */     //   1555: ldc_w 'mc2'
/*     */     //   1558: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1561: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1564: dup
/*     */     //   1565: ifnonnull -> 1571
/*     */     //   1568: invokestatic throwNpe : ()V
/*     */     //   1571: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1574: dup
/*     */     //   1575: iconst_0
/*     */     //   1576: bipush #100
/*     */     //   1578: iconst_1
/*     */     //   1579: invokespecial <init> : (ISZ)V
/*     */     //   1582: checkcast net/minecraft/network/Packet
/*     */     //   1585: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1588: aload #4
/*     */     //   1590: dconst_0
/*     */     //   1591: ldc2_w 0.10408037809304
/*     */     //   1594: dconst_0
/*     */     //   1595: iconst_0
/*     */     //   1596: iconst_5
/*     */     //   1597: aconst_null
/*     */     //   1598: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1601: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1604: dup
/*     */     //   1605: ldc_w 'mc2'
/*     */     //   1608: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1611: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1614: dup
/*     */     //   1615: ifnonnull -> 1621
/*     */     //   1618: invokestatic throwNpe : ()V
/*     */     //   1621: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   1624: dup
/*     */     //   1625: iconst_0
/*     */     //   1626: bipush #100
/*     */     //   1628: iconst_1
/*     */     //   1629: invokespecial <init> : (ISZ)V
/*     */     //   1632: checkcast net/minecraft/network/Packet
/*     */     //   1635: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1638: aload #4
/*     */     //   1640: dconst_0
/*     */     //   1641: dconst_0
/*     */     //   1642: dconst_0
/*     */     //   1643: iconst_1
/*     */     //   1644: iconst_5
/*     */     //   1645: aconst_null
/*     */     //   1646: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   1649: goto -> 5507
/*     */     //   1652: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1655: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1660: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1663: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1666: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1671: dup
/*     */     //   1672: ifnonnull -> 1678
/*     */     //   1675: invokestatic throwNpe : ()V
/*     */     //   1678: invokeinterface getPosX : ()D
/*     */     //   1683: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1686: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1691: dup
/*     */     //   1692: ifnonnull -> 1698
/*     */     //   1695: invokestatic throwNpe : ()V
/*     */     //   1698: invokeinterface getPosY : ()D
/*     */     //   1703: ldc2_w 0.42
/*     */     //   1706: dadd
/*     */     //   1707: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1710: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1715: dup
/*     */     //   1716: ifnonnull -> 1722
/*     */     //   1719: invokestatic throwNpe : ()V
/*     */     //   1722: invokeinterface getPosZ : ()D
/*     */     //   1727: iconst_0
/*     */     //   1728: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1733: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1736: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1741: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1744: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1749: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1752: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1755: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1760: dup
/*     */     //   1761: ifnonnull -> 1767
/*     */     //   1764: invokestatic throwNpe : ()V
/*     */     //   1767: invokeinterface getPosX : ()D
/*     */     //   1772: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1775: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1780: dup
/*     */     //   1781: ifnonnull -> 1787
/*     */     //   1784: invokestatic throwNpe : ()V
/*     */     //   1787: invokeinterface getPosY : ()D
/*     */     //   1792: ldc2_w 8.0E-15
/*     */     //   1795: dadd
/*     */     //   1796: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1799: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1804: dup
/*     */     //   1805: ifnonnull -> 1811
/*     */     //   1808: invokestatic throwNpe : ()V
/*     */     //   1811: invokeinterface getPosZ : ()D
/*     */     //   1816: iconst_1
/*     */     //   1817: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1822: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1825: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1830: goto -> 5507
/*     */     //   1833: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1836: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1841: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1844: dload #5
/*     */     //   1846: dload #7
/*     */     //   1848: ldc2_w 0.0625
/*     */     //   1851: dadd
/*     */     //   1852: dload #9
/*     */     //   1854: iconst_1
/*     */     //   1855: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1860: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1863: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1868: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1871: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1876: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1879: dload #5
/*     */     //   1881: dload #7
/*     */     //   1883: dload #9
/*     */     //   1885: iconst_0
/*     */     //   1886: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1891: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1894: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1899: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1902: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1907: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1910: dload #5
/*     */     //   1912: dload #7
/*     */     //   1914: ldc2_w 1.1E-5
/*     */     //   1917: dadd
/*     */     //   1918: dload #9
/*     */     //   1920: iconst_0
/*     */     //   1921: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1926: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1929: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1934: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1937: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1942: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1945: dload #5
/*     */     //   1947: dload #7
/*     */     //   1949: dload #9
/*     */     //   1951: iconst_0
/*     */     //   1952: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   1957: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1960: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1965: aload_2
/*     */     //   1966: aload_3
/*     */     //   1967: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   1970: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   1975: goto -> 5507
/*     */     //   1978: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1981: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1986: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1989: dload #5
/*     */     //   1991: dload #7
/*     */     //   1993: ldc2_w 0.05250000001304
/*     */     //   1996: dadd
/*     */     //   1997: dload #9
/*     */     //   1999: iconst_1
/*     */     //   2000: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2005: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2008: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2013: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2016: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2021: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2024: dload #5
/*     */     //   2026: dload #7
/*     */     //   2028: ldc2_w 0.00150000001304
/*     */     //   2031: dadd
/*     */     //   2032: dload #9
/*     */     //   2034: iconst_0
/*     */     //   2035: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2040: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2043: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2048: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2051: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2056: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2059: dload #5
/*     */     //   2061: dload #7
/*     */     //   2063: ldc2_w 0.01400000001304
/*     */     //   2066: dadd
/*     */     //   2067: dload #9
/*     */     //   2069: iconst_0
/*     */     //   2070: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2075: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2078: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2083: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2086: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2091: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2094: dload #5
/*     */     //   2096: dload #7
/*     */     //   2098: ldc2_w 0.00150000001304
/*     */     //   2101: dadd
/*     */     //   2102: dload #9
/*     */     //   2104: iconst_0
/*     */     //   2105: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2110: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2113: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2118: aload_2
/*     */     //   2119: aload_3
/*     */     //   2120: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   2123: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   2128: goto -> 5507
/*     */     //   2131: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2134: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2139: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2142: dload #5
/*     */     //   2144: dload #7
/*     */     //   2146: ldc2_w 0.11
/*     */     //   2149: dadd
/*     */     //   2150: dload #9
/*     */     //   2152: iconst_0
/*     */     //   2153: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2158: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2161: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2166: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2169: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2174: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2177: dload #5
/*     */     //   2179: dload #7
/*     */     //   2181: ldc2_w 0.1100013579
/*     */     //   2184: dadd
/*     */     //   2185: dload #9
/*     */     //   2187: iconst_0
/*     */     //   2188: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2193: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2196: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2204: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2209: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2212: dload #5
/*     */     //   2214: dload #7
/*     */     //   2216: ldc2_w 1.3579E-6
/*     */     //   2219: dadd
/*     */     //   2220: dload #9
/*     */     //   2222: iconst_0
/*     */     //   2223: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2228: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2231: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2236: aload_2
/*     */     //   2237: aload_3
/*     */     //   2238: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   2241: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   2246: goto -> 5507
/*     */     //   2249: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2252: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2257: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2260: dload #5
/*     */     //   2262: dload #7
/*     */     //   2264: ldc2_w 1.0E-5
/*     */     //   2267: dadd
/*     */     //   2268: dload #9
/*     */     //   2270: iconst_0
/*     */     //   2271: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2276: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2279: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2284: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2287: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2292: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2295: dload #5
/*     */     //   2297: dload #7
/*     */     //   2299: ldc2_w 1.0E-7
/*     */     //   2302: dadd
/*     */     //   2303: dload #9
/*     */     //   2305: iconst_0
/*     */     //   2306: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2311: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2314: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2319: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2322: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2327: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2330: dload #5
/*     */     //   2332: dload #7
/*     */     //   2334: ldc2_w 1.0E-6
/*     */     //   2337: dsub
/*     */     //   2338: dload #9
/*     */     //   2340: iconst_0
/*     */     //   2341: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2346: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2349: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2354: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2357: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2362: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2365: dload #5
/*     */     //   2367: dload #7
/*     */     //   2369: ldc2_w 1.0E-4
/*     */     //   2372: dsub
/*     */     //   2373: dload #9
/*     */     //   2375: iconst_0
/*     */     //   2376: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2381: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2384: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2389: goto -> 5507
/*     */     //   2392: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2395: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2400: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2403: dload #5
/*     */     //   2405: dload #7
/*     */     //   2407: ldc2_w 1.0E27
/*     */     //   2410: dadd
/*     */     //   2411: dload #9
/*     */     //   2413: iconst_0
/*     */     //   2414: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2419: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2422: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2427: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2430: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2435: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2438: dload #5
/*     */     //   2440: dload #7
/*     */     //   2442: ldc2_w 1.0E68
/*     */     //   2445: dsub
/*     */     //   2446: dload #9
/*     */     //   2448: iconst_0
/*     */     //   2449: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2454: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2457: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2462: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2465: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2470: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2473: dload #5
/*     */     //   2475: dload #7
/*     */     //   2477: ldc2_w 1.0E41
/*     */     //   2480: dadd
/*     */     //   2481: dload #9
/*     */     //   2483: iconst_0
/*     */     //   2484: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2489: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2492: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2497: goto -> 5507
/*     */     //   2500: aload_0
/*     */     //   2501: dup
/*     */     //   2502: getfield counter : I
/*     */     //   2505: dup
/*     */     //   2506: istore #12
/*     */     //   2508: iconst_1
/*     */     //   2509: iadd
/*     */     //   2510: putfield counter : I
/*     */     //   2513: aload_0
/*     */     //   2514: getfield counter : I
/*     */     //   2517: iconst_1
/*     */     //   2518: if_icmpne -> 2587
/*     */     //   2521: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2524: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2529: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2532: dload #5
/*     */     //   2534: dload #7
/*     */     //   2536: ldc2_w 0.001
/*     */     //   2539: dadd
/*     */     //   2540: dload #9
/*     */     //   2542: iconst_1
/*     */     //   2543: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2548: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2551: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2556: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2559: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2564: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2567: dload #5
/*     */     //   2569: dload #7
/*     */     //   2571: dload #9
/*     */     //   2573: iconst_0
/*     */     //   2574: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2579: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2582: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2587: aload_0
/*     */     //   2588: getfield counter : I
/*     */     //   2591: iconst_5
/*     */     //   2592: if_icmplt -> 5507
/*     */     //   2595: aload_0
/*     */     //   2596: iconst_0
/*     */     //   2597: putfield counter : I
/*     */     //   2600: goto -> 5507
/*     */     //   2603: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2606: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2611: dup
/*     */     //   2612: ifnonnull -> 2618
/*     */     //   2615: invokestatic throwNpe : ()V
/*     */     //   2618: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2623: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2626: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2629: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2634: dup
/*     */     //   2635: ifnonnull -> 2641
/*     */     //   2638: invokestatic throwNpe : ()V
/*     */     //   2641: invokeinterface getPosX : ()D
/*     */     //   2646: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2649: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2654: dup
/*     */     //   2655: ifnonnull -> 2661
/*     */     //   2658: invokestatic throwNpe : ()V
/*     */     //   2661: invokeinterface getPosY : ()D
/*     */     //   2666: ldc2_w 0.0625
/*     */     //   2669: dadd
/*     */     //   2670: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2673: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2678: dup
/*     */     //   2679: ifnonnull -> 2685
/*     */     //   2682: invokestatic throwNpe : ()V
/*     */     //   2685: invokeinterface getPosZ : ()D
/*     */     //   2690: iconst_0
/*     */     //   2691: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2696: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2699: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2704: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2707: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2712: dup
/*     */     //   2713: ifnonnull -> 2719
/*     */     //   2716: invokestatic throwNpe : ()V
/*     */     //   2719: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2724: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2727: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2730: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2735: dup
/*     */     //   2736: ifnonnull -> 2742
/*     */     //   2739: invokestatic throwNpe : ()V
/*     */     //   2742: invokeinterface getPosX : ()D
/*     */     //   2747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2750: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2755: dup
/*     */     //   2756: ifnonnull -> 2762
/*     */     //   2759: invokestatic throwNpe : ()V
/*     */     //   2762: invokeinterface getPosY : ()D
/*     */     //   2767: ldc2_w 0.09858
/*     */     //   2770: dadd
/*     */     //   2771: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2774: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2779: dup
/*     */     //   2780: ifnonnull -> 2786
/*     */     //   2783: invokestatic throwNpe : ()V
/*     */     //   2786: invokeinterface getPosZ : ()D
/*     */     //   2791: iconst_0
/*     */     //   2792: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2797: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2800: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2805: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2808: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2813: dup
/*     */     //   2814: ifnonnull -> 2820
/*     */     //   2817: invokestatic throwNpe : ()V
/*     */     //   2820: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2825: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2828: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2831: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2836: dup
/*     */     //   2837: ifnonnull -> 2843
/*     */     //   2840: invokestatic throwNpe : ()V
/*     */     //   2843: invokeinterface getPosX : ()D
/*     */     //   2848: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2851: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2856: dup
/*     */     //   2857: ifnonnull -> 2863
/*     */     //   2860: invokestatic throwNpe : ()V
/*     */     //   2863: invokeinterface getPosY : ()D
/*     */     //   2868: ldc2_w 0.04114514
/*     */     //   2871: dadd
/*     */     //   2872: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2875: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2880: dup
/*     */     //   2881: ifnonnull -> 2887
/*     */     //   2884: invokestatic throwNpe : ()V
/*     */     //   2887: invokeinterface getPosZ : ()D
/*     */     //   2892: iconst_0
/*     */     //   2893: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2898: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2901: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2906: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2909: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2914: dup
/*     */     //   2915: ifnonnull -> 2921
/*     */     //   2918: invokestatic throwNpe : ()V
/*     */     //   2921: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2926: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2929: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2932: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2937: dup
/*     */     //   2938: ifnonnull -> 2944
/*     */     //   2941: invokestatic throwNpe : ()V
/*     */     //   2944: invokeinterface getPosX : ()D
/*     */     //   2949: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2952: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2957: dup
/*     */     //   2958: ifnonnull -> 2964
/*     */     //   2961: invokestatic throwNpe : ()V
/*     */     //   2964: invokeinterface getPosY : ()D
/*     */     //   2969: ldc2_w 0.025
/*     */     //   2972: dadd
/*     */     //   2973: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2976: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2981: dup
/*     */     //   2982: ifnonnull -> 2988
/*     */     //   2985: invokestatic throwNpe : ()V
/*     */     //   2988: invokeinterface getPosZ : ()D
/*     */     //   2993: iconst_0
/*     */     //   2994: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   2999: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3002: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3007: goto -> 5507
/*     */     //   3010: aload_0
/*     */     //   3011: dup
/*     */     //   3012: getfield attacks : I
/*     */     //   3015: dup
/*     */     //   3016: istore #12
/*     */     //   3018: iconst_1
/*     */     //   3019: iadd
/*     */     //   3020: putfield attacks : I
/*     */     //   3023: aload_0
/*     */     //   3024: getfield attacks : I
/*     */     //   3027: bipush #6
/*     */     //   3029: if_icmple -> 5507
/*     */     //   3032: aload #4
/*     */     //   3034: dconst_0
/*     */     //   3035: ldc2_w 0.01
/*     */     //   3038: dconst_0
/*     */     //   3039: iconst_0
/*     */     //   3040: iconst_5
/*     */     //   3041: aconst_null
/*     */     //   3042: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   3045: aload #4
/*     */     //   3047: dconst_0
/*     */     //   3048: ldc2_w 1.0E-10
/*     */     //   3051: dconst_0
/*     */     //   3052: iconst_0
/*     */     //   3053: iconst_5
/*     */     //   3054: aconst_null
/*     */     //   3055: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   3058: aload #4
/*     */     //   3060: dconst_0
/*     */     //   3061: ldc2_w 0.114514
/*     */     //   3064: dconst_0
/*     */     //   3065: iconst_0
/*     */     //   3066: iconst_5
/*     */     //   3067: aconst_null
/*     */     //   3068: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   3071: aload_0
/*     */     //   3072: iconst_0
/*     */     //   3073: putfield attacks : I
/*     */     //   3076: aload_0
/*     */     //   3077: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   3080: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3083: checkcast java/lang/Boolean
/*     */     //   3086: invokevirtual booleanValue : ()Z
/*     */     //   3089: ifeq -> 3145
/*     */     //   3092: aload_2
/*     */     //   3093: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3096: new java/lang/StringBuilder
/*     */     //   3099: dup
/*     */     //   3100: invokespecial <init> : ()V
/*     */     //   3103: ldc_w '[Crit] '
/*     */     //   3106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3109: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3112: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3117: dup
/*     */     //   3118: ifnonnull -> 3124
/*     */     //   3121: invokestatic throwNpe : ()V
/*     */     //   3124: invokeinterface getTicksExisted : ()I
/*     */     //   3129: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   3132: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3135: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   3140: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   3145: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3148: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3153: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3156: dload #5
/*     */     //   3158: dload #7
/*     */     //   3160: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   3163: invokevirtual getOffset : ()F
/*     */     //   3166: f2d
/*     */     //   3167: dadd
/*     */     //   3168: dload #9
/*     */     //   3170: iconst_0
/*     */     //   3171: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3176: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3179: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3184: goto -> 5507
/*     */     //   3187: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3190: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3195: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3198: dload #5
/*     */     //   3200: dload #7
/*     */     //   3202: ldc2_w 0.11
/*     */     //   3205: dadd
/*     */     //   3206: dload #9
/*     */     //   3208: iconst_0
/*     */     //   3209: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3214: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3217: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3222: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3225: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3230: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3233: dload #5
/*     */     //   3235: dload #7
/*     */     //   3237: ldc2_w 0.1100013579
/*     */     //   3240: dadd
/*     */     //   3241: dload #9
/*     */     //   3243: iconst_0
/*     */     //   3244: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3249: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3252: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3257: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3260: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3265: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3268: dload #5
/*     */     //   3270: dload #7
/*     */     //   3272: ldc2_w 1.3579E-6
/*     */     //   3275: dadd
/*     */     //   3276: dload #9
/*     */     //   3278: iconst_0
/*     */     //   3279: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3284: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3287: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3292: aload_2
/*     */     //   3293: aload_3
/*     */     //   3294: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   3297: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   3302: aload_0
/*     */     //   3303: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   3306: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3309: checkcast java/lang/Boolean
/*     */     //   3312: invokevirtual booleanValue : ()Z
/*     */     //   3315: ifeq -> 3371
/*     */     //   3318: aload_2
/*     */     //   3319: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3322: new java/lang/StringBuilder
/*     */     //   3325: dup
/*     */     //   3326: invokespecial <init> : ()V
/*     */     //   3329: ldc_w '[Crit] '
/*     */     //   3332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3338: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3343: dup
/*     */     //   3344: ifnonnull -> 3350
/*     */     //   3347: invokestatic throwNpe : ()V
/*     */     //   3350: invokeinterface getTicksExisted : ()I
/*     */     //   3355: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   3358: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3361: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   3366: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   3371: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3374: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3379: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3382: dload #5
/*     */     //   3384: dload #7
/*     */     //   3386: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   3389: invokevirtual getOffset : ()F
/*     */     //   3392: f2d
/*     */     //   3393: dadd
/*     */     //   3394: dload #9
/*     */     //   3396: iconst_0
/*     */     //   3397: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3402: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3405: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3410: goto -> 5507
/*     */     //   3413: aload_0
/*     */     //   3414: dup
/*     */     //   3415: getfield attacks : I
/*     */     //   3418: dup
/*     */     //   3419: istore #12
/*     */     //   3421: iconst_1
/*     */     //   3422: iadd
/*     */     //   3423: putfield attacks : I
/*     */     //   3426: aload_0
/*     */     //   3427: getfield attacks : I
/*     */     //   3430: iconst_5
/*     */     //   3431: if_icmple -> 5507
/*     */     //   3434: aload #4
/*     */     //   3436: dconst_0
/*     */     //   3437: ldc2_w 0.0114514
/*     */     //   3440: dconst_0
/*     */     //   3441: iconst_0
/*     */     //   3442: iconst_5
/*     */     //   3443: aconst_null
/*     */     //   3444: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   3447: aload #4
/*     */     //   3449: dconst_0
/*     */     //   3450: ldc2_w 0.0019
/*     */     //   3453: dconst_0
/*     */     //   3454: iconst_0
/*     */     //   3455: iconst_5
/*     */     //   3456: aconst_null
/*     */     //   3457: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   3460: aload #4
/*     */     //   3462: dconst_0
/*     */     //   3463: ldc2_w 1.0E-6
/*     */     //   3466: dconst_0
/*     */     //   3467: iconst_0
/*     */     //   3468: iconst_5
/*     */     //   3469: aconst_null
/*     */     //   3470: invokestatic invoke$default : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;DDDZILjava/lang/Object;)V
/*     */     //   3473: aload_0
/*     */     //   3474: iconst_0
/*     */     //   3475: putfield attacks : I
/*     */     //   3478: aload_0
/*     */     //   3479: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   3482: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3485: checkcast java/lang/Boolean
/*     */     //   3488: invokevirtual booleanValue : ()Z
/*     */     //   3491: ifeq -> 3547
/*     */     //   3494: aload_2
/*     */     //   3495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3498: new java/lang/StringBuilder
/*     */     //   3501: dup
/*     */     //   3502: invokespecial <init> : ()V
/*     */     //   3505: ldc_w '[Crit] '
/*     */     //   3508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3511: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3514: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3519: dup
/*     */     //   3520: ifnonnull -> 3526
/*     */     //   3523: invokestatic throwNpe : ()V
/*     */     //   3526: invokeinterface getTicksExisted : ()I
/*     */     //   3531: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   3534: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3537: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   3542: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   3547: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3550: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3555: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3558: dload #5
/*     */     //   3560: dload #7
/*     */     //   3562: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   3565: invokevirtual getOffset : ()F
/*     */     //   3568: f2d
/*     */     //   3569: dadd
/*     */     //   3570: dload #9
/*     */     //   3572: iconst_0
/*     */     //   3573: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3578: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3581: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3586: goto -> 5507
/*     */     //   3589: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3592: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3597: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3600: dload #5
/*     */     //   3602: dload #7
/*     */     //   3604: ldc2_w 0.05250000001304
/*     */     //   3607: dadd
/*     */     //   3608: dload #9
/*     */     //   3610: iconst_0
/*     */     //   3611: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3616: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3619: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3624: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3627: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3632: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3635: dload #5
/*     */     //   3637: dload #7
/*     */     //   3639: ldc2_w 0.00150000001304
/*     */     //   3642: dadd
/*     */     //   3643: dload #9
/*     */     //   3645: iconst_0
/*     */     //   3646: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3651: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3654: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3659: aload_0
/*     */     //   3660: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   3663: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3666: checkcast java/lang/Boolean
/*     */     //   3669: invokevirtual booleanValue : ()Z
/*     */     //   3672: ifeq -> 3728
/*     */     //   3675: aload_2
/*     */     //   3676: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3679: new java/lang/StringBuilder
/*     */     //   3682: dup
/*     */     //   3683: invokespecial <init> : ()V
/*     */     //   3686: ldc_w '[Crit] '
/*     */     //   3689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3692: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3695: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3700: dup
/*     */     //   3701: ifnonnull -> 3707
/*     */     //   3704: invokestatic throwNpe : ()V
/*     */     //   3707: invokeinterface getTicksExisted : ()I
/*     */     //   3712: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   3715: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3718: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   3723: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   3728: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3731: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3736: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3739: dload #5
/*     */     //   3741: dload #7
/*     */     //   3743: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   3746: invokevirtual getOffset : ()F
/*     */     //   3749: f2d
/*     */     //   3750: dadd
/*     */     //   3751: dload #9
/*     */     //   3753: iconst_0
/*     */     //   3754: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3759: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3762: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3767: goto -> 5507
/*     */     //   3770: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3773: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3778: dup
/*     */     //   3779: ifnonnull -> 3785
/*     */     //   3782: invokestatic throwNpe : ()V
/*     */     //   3785: dup
/*     */     //   3786: invokeinterface getMotionZ : ()D
/*     */     //   3791: iconst_0
/*     */     //   3792: i2d
/*     */     //   3793: dmul
/*     */     //   3794: invokeinterface setMotionZ : (D)V
/*     */     //   3799: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3802: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3807: dup
/*     */     //   3808: ifnonnull -> 3814
/*     */     //   3811: invokestatic throwNpe : ()V
/*     */     //   3814: dup
/*     */     //   3815: invokeinterface getMotionX : ()D
/*     */     //   3820: iconst_0
/*     */     //   3821: i2d
/*     */     //   3822: dmul
/*     */     //   3823: invokeinterface setMotionX : (D)V
/*     */     //   3828: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3831: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3836: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3839: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3842: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3847: dup
/*     */     //   3848: ifnonnull -> 3854
/*     */     //   3851: invokestatic throwNpe : ()V
/*     */     //   3854: invokeinterface getPosX : ()D
/*     */     //   3859: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3862: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3867: dup
/*     */     //   3868: ifnonnull -> 3874
/*     */     //   3871: invokestatic throwNpe : ()V
/*     */     //   3874: invokeinterface getPosY : ()D
/*     */     //   3879: ldc2_w 3.0E-14
/*     */     //   3882: dadd
/*     */     //   3883: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3886: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3891: dup
/*     */     //   3892: ifnonnull -> 3898
/*     */     //   3895: invokestatic throwNpe : ()V
/*     */     //   3898: invokeinterface getPosZ : ()D
/*     */     //   3903: iconst_1
/*     */     //   3904: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3909: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   3912: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   3917: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3920: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   3925: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   3928: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3931: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3936: dup
/*     */     //   3937: ifnonnull -> 3943
/*     */     //   3940: invokestatic throwNpe : ()V
/*     */     //   3943: invokeinterface getPosX : ()D
/*     */     //   3948: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3951: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3956: dup
/*     */     //   3957: ifnonnull -> 3963
/*     */     //   3960: invokestatic throwNpe : ()V
/*     */     //   3963: invokeinterface getPosY : ()D
/*     */     //   3968: ldc2_w 8.0E-15
/*     */     //   3971: dadd
/*     */     //   3972: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3975: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3980: dup
/*     */     //   3981: ifnonnull -> 3987
/*     */     //   3984: invokestatic throwNpe : ()V
/*     */     //   3987: invokeinterface getPosZ : ()D
/*     */     //   3992: iconst_1
/*     */     //   3993: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   3998: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4001: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4006: aload_0
/*     */     //   4007: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4010: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4013: checkcast java/lang/Boolean
/*     */     //   4016: invokevirtual booleanValue : ()Z
/*     */     //   4019: ifeq -> 4075
/*     */     //   4022: aload_2
/*     */     //   4023: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4026: new java/lang/StringBuilder
/*     */     //   4029: dup
/*     */     //   4030: invokespecial <init> : ()V
/*     */     //   4033: ldc_w '[Crit] '
/*     */     //   4036: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4039: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4042: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   4047: dup
/*     */     //   4048: ifnonnull -> 4054
/*     */     //   4051: invokestatic throwNpe : ()V
/*     */     //   4054: invokeinterface getTicksExisted : ()I
/*     */     //   4059: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   4062: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4065: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   4070: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   4075: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4078: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4083: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4086: dload #5
/*     */     //   4088: dload #7
/*     */     //   4090: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   4093: invokevirtual getOffset : ()F
/*     */     //   4096: f2d
/*     */     //   4097: dadd
/*     */     //   4098: dload #9
/*     */     //   4100: iconst_0
/*     */     //   4101: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4106: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4109: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4114: goto -> 5507
/*     */     //   4117: aload_0
/*     */     //   4118: dup
/*     */     //   4119: getfield attacks : I
/*     */     //   4122: dup
/*     */     //   4123: istore #12
/*     */     //   4125: iconst_1
/*     */     //   4126: iadd
/*     */     //   4127: putfield attacks : I
/*     */     //   4130: aload_0
/*     */     //   4131: getfield attacks : I
/*     */     //   4134: bipush #6
/*     */     //   4136: if_icmple -> 5507
/*     */     //   4139: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4142: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4147: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4150: dload #5
/*     */     //   4152: dload #7
/*     */     //   4154: ldc2_w 0.2
/*     */     //   4157: dadd
/*     */     //   4158: dload #9
/*     */     //   4160: iconst_0
/*     */     //   4161: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4166: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4169: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4174: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4177: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4182: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4185: dload #5
/*     */     //   4187: dload #7
/*     */     //   4189: ldc2_w 0.1216
/*     */     //   4192: dadd
/*     */     //   4193: dload #9
/*     */     //   4195: iconst_0
/*     */     //   4196: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4201: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4204: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4209: aload_0
/*     */     //   4210: iconst_0
/*     */     //   4211: putfield attacks : I
/*     */     //   4214: aload_0
/*     */     //   4215: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4218: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4221: checkcast java/lang/Boolean
/*     */     //   4224: invokevirtual booleanValue : ()Z
/*     */     //   4227: ifeq -> 4283
/*     */     //   4230: aload_2
/*     */     //   4231: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4234: new java/lang/StringBuilder
/*     */     //   4237: dup
/*     */     //   4238: invokespecial <init> : ()V
/*     */     //   4241: ldc_w '[Crit] '
/*     */     //   4244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4247: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4250: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   4255: dup
/*     */     //   4256: ifnonnull -> 4262
/*     */     //   4259: invokestatic throwNpe : ()V
/*     */     //   4262: invokeinterface getTicksExisted : ()I
/*     */     //   4267: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   4270: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4273: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   4278: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   4283: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4286: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4291: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4294: dload #5
/*     */     //   4296: dload #7
/*     */     //   4298: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   4301: invokevirtual getOffset : ()F
/*     */     //   4304: f2d
/*     */     //   4305: dadd
/*     */     //   4306: dload #9
/*     */     //   4308: iconst_0
/*     */     //   4309: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4314: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4317: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4322: goto -> 5507
/*     */     //   4325: aload_0
/*     */     //   4326: dup
/*     */     //   4327: getfield counter : I
/*     */     //   4330: dup
/*     */     //   4331: istore #12
/*     */     //   4333: iconst_1
/*     */     //   4334: iadd
/*     */     //   4335: putfield counter : I
/*     */     //   4338: aload_0
/*     */     //   4339: getfield counter : I
/*     */     //   4342: iconst_1
/*     */     //   4343: if_icmpne -> 4412
/*     */     //   4346: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4349: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4354: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4357: dload #5
/*     */     //   4359: dload #7
/*     */     //   4361: ldc2_w 0.001
/*     */     //   4364: dadd
/*     */     //   4365: dload #9
/*     */     //   4367: iconst_1
/*     */     //   4368: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4373: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4376: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4381: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4384: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4389: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4392: dload #5
/*     */     //   4394: dload #7
/*     */     //   4396: dload #9
/*     */     //   4398: iconst_0
/*     */     //   4399: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4404: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4407: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4412: aload_0
/*     */     //   4413: getfield counter : I
/*     */     //   4416: iconst_5
/*     */     //   4417: if_icmplt -> 4425
/*     */     //   4420: aload_0
/*     */     //   4421: iconst_0
/*     */     //   4422: putfield counter : I
/*     */     //   4425: aload_0
/*     */     //   4426: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4429: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4432: checkcast java/lang/Boolean
/*     */     //   4435: invokevirtual booleanValue : ()Z
/*     */     //   4438: ifeq -> 4494
/*     */     //   4441: aload_2
/*     */     //   4442: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4445: new java/lang/StringBuilder
/*     */     //   4448: dup
/*     */     //   4449: invokespecial <init> : ()V
/*     */     //   4452: ldc_w '[Crit] '
/*     */     //   4455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4458: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4461: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   4466: dup
/*     */     //   4467: ifnonnull -> 4473
/*     */     //   4470: invokestatic throwNpe : ()V
/*     */     //   4473: invokeinterface getTicksExisted : ()I
/*     */     //   4478: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   4481: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4484: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   4489: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   4494: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4497: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4502: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4505: dload #5
/*     */     //   4507: dload #7
/*     */     //   4509: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   4512: invokevirtual getOffset : ()F
/*     */     //   4515: f2d
/*     */     //   4516: dadd
/*     */     //   4517: dload #9
/*     */     //   4519: iconst_0
/*     */     //   4520: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4525: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4528: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4533: goto -> 5507
/*     */     //   4536: aload_2
/*     */     //   4537: ldc2_w 0.1
/*     */     //   4540: invokeinterface setMotionY : (D)V
/*     */     //   4545: aload_2
/*     */     //   4546: ldc_w 0.1
/*     */     //   4549: invokeinterface setFallDistance : (F)V
/*     */     //   4554: aload_2
/*     */     //   4555: iconst_0
/*     */     //   4556: invokeinterface setOnGround : (Z)V
/*     */     //   4561: goto -> 5507
/*     */     //   4564: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4567: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4572: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4575: dload #5
/*     */     //   4577: dload #7
/*     */     //   4579: ldc2_w 0.02
/*     */     //   4582: dadd
/*     */     //   4583: dload #9
/*     */     //   4585: iconst_0
/*     */     //   4586: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4591: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4594: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4599: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4602: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4607: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4610: dload #5
/*     */     //   4612: dload #7
/*     */     //   4614: ldc2_w 0.01
/*     */     //   4617: dadd
/*     */     //   4618: dload #9
/*     */     //   4620: iconst_0
/*     */     //   4621: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4626: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4629: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4634: aload_2
/*     */     //   4635: dload #5
/*     */     //   4637: dload #7
/*     */     //   4639: ldc2_w 0.01
/*     */     //   4642: dadd
/*     */     //   4643: dload #9
/*     */     //   4645: invokeinterface setPosition : (DDD)V
/*     */     //   4650: goto -> 5507
/*     */     //   4653: aload_2
/*     */     //   4654: invokeinterface getOnGround : ()Z
/*     */     //   4659: ifeq -> 5507
/*     */     //   4662: aload_0
/*     */     //   4663: getfield jump : I
/*     */     //   4666: bipush #10
/*     */     //   4668: if_icmple -> 5507
/*     */     //   4671: aload_2
/*     */     //   4672: ldc2_w 0.42
/*     */     //   4675: invokeinterface setMotionY : (D)V
/*     */     //   4680: aload_0
/*     */     //   4681: iconst_0
/*     */     //   4682: putfield jump : I
/*     */     //   4685: goto -> 5507
/*     */     //   4688: aload_2
/*     */     //   4689: invokeinterface getOnGround : ()Z
/*     */     //   4694: ifeq -> 5507
/*     */     //   4697: aload_0
/*     */     //   4698: getfield jump : I
/*     */     //   4701: bipush #10
/*     */     //   4703: if_icmple -> 5507
/*     */     //   4706: aload_2
/*     */     //   4707: ldc2_w 0.41999998688698
/*     */     //   4710: invokeinterface setMotionY : (D)V
/*     */     //   4715: aload_0
/*     */     //   4716: iconst_0
/*     */     //   4717: putfield jump : I
/*     */     //   4720: goto -> 5507
/*     */     //   4723: aload_2
/*     */     //   4724: ldc2_w 0.3425
/*     */     //   4727: invokeinterface setMotionY : (D)V
/*     */     //   4732: goto -> 5507
/*     */     //   4735: aload_0
/*     */     //   4736: dup
/*     */     //   4737: getfield attacks : I
/*     */     //   4740: dup
/*     */     //   4741: istore #12
/*     */     //   4743: iconst_1
/*     */     //   4744: iadd
/*     */     //   4745: putfield attacks : I
/*     */     //   4748: aload_0
/*     */     //   4749: getfield attacks : I
/*     */     //   4752: iconst_4
/*     */     //   4753: if_icmple -> 5507
/*     */     //   4756: aload_0
/*     */     //   4757: iconst_0
/*     */     //   4758: putfield attacks : I
/*     */     //   4761: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4764: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4769: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4772: dload #5
/*     */     //   4774: dload #7
/*     */     //   4776: ldc2_w 0.001
/*     */     //   4779: dadd
/*     */     //   4780: dload #9
/*     */     //   4782: iconst_0
/*     */     //   4783: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4788: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4791: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4796: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4799: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4804: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4807: dload #5
/*     */     //   4809: dload #7
/*     */     //   4811: dload #9
/*     */     //   4813: iconst_0
/*     */     //   4814: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4819: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4822: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4827: aload_0
/*     */     //   4828: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4831: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4834: checkcast java/lang/Boolean
/*     */     //   4837: invokevirtual booleanValue : ()Z
/*     */     //   4840: ifeq -> 4843
/*     */     //   4843: aload_2
/*     */     //   4844: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4847: new java/lang/StringBuilder
/*     */     //   4850: dup
/*     */     //   4851: invokespecial <init> : ()V
/*     */     //   4854: ldc_w '[Crit] '
/*     */     //   4857: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   4860: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4863: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   4868: dup
/*     */     //   4869: ifnonnull -> 4875
/*     */     //   4872: invokestatic throwNpe : ()V
/*     */     //   4875: invokeinterface getTicksExisted : ()I
/*     */     //   4880: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   4883: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   4886: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   4891: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   4896: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   4899: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   4904: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   4907: dload #5
/*     */     //   4909: dload #7
/*     */     //   4911: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   4914: invokevirtual getOffset : ()F
/*     */     //   4917: f2d
/*     */     //   4918: dadd
/*     */     //   4919: dload #9
/*     */     //   4921: iconst_0
/*     */     //   4922: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   4927: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   4930: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   4935: goto -> 5507
/*     */     //   4938: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*     */     //   4941: invokevirtual nextBoolean : ()Z
/*     */     //   4944: istore #12
/*     */     //   4946: iconst_0
/*     */     //   4947: istore #13
/*     */     //   4949: aload_0
/*     */     //   4950: getfield restVL : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   4953: ldc2_w 20000
/*     */     //   4956: invokevirtual hasTimePassed : (J)Z
/*     */     //   4959: ifeq -> 5002
/*     */     //   4962: aload_0
/*     */     //   4963: getfield ramd : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4966: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   4969: checkcast java/lang/Boolean
/*     */     //   4972: invokevirtual booleanValue : ()Z
/*     */     //   4975: ifeq -> 5002
/*     */     //   4978: aload_2
/*     */     //   4979: invokeinterface getTicksExisted : ()I
/*     */     //   4984: iconst_2
/*     */     //   4985: irem
/*     */     //   4986: ifne -> 5002
/*     */     //   4989: iconst_1
/*     */     //   4990: istore #13
/*     */     //   4992: aload_0
/*     */     //   4993: getfield restVL : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   4996: invokevirtual reset : ()V
/*     */     //   4999: goto -> 5019
/*     */     //   5002: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5005: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   5010: fconst_1
/*     */     //   5011: invokeinterface setTimerSpeed : (F)V
/*     */     //   5016: iconst_0
/*     */     //   5017: istore #13
/*     */     //   5019: iconst_4
/*     */     //   5020: newarray double
/*     */     //   5022: dup
/*     */     //   5023: iconst_0
/*     */     //   5024: ldc2_w 0.0266040404
/*     */     //   5027: dastore
/*     */     //   5028: dup
/*     */     //   5029: iconst_1
/*     */     //   5030: ldc2_w 0.0113711
/*     */     //   5033: dastore
/*     */     //   5034: dup
/*     */     //   5035: iconst_2
/*     */     //   5036: ldc2_w 0.025993600000000002
/*     */     //   5039: dastore
/*     */     //   5040: dup
/*     */     //   5041: iconst_3
/*     */     //   5042: ldc2_w 0.0376651233
/*     */     //   5045: dastore
/*     */     //   5046: astore #14
/*     */     //   5048: iconst_2
/*     */     //   5049: newarray double
/*     */     //   5051: dup
/*     */     //   5052: iconst_0
/*     */     //   5053: ldc2_w 0.1
/*     */     //   5056: dastore
/*     */     //   5057: dup
/*     */     //   5058: iconst_1
/*     */     //   5059: ldc2_w 0.023
/*     */     //   5062: dastore
/*     */     //   5063: astore #15
/*     */     //   5065: iload #12
/*     */     //   5067: ifeq -> 5507
/*     */     //   5070: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5073: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   5078: iload #13
/*     */     //   5080: ifeq -> 5089
/*     */     //   5083: ldc_w 0.8
/*     */     //   5086: goto -> 5090
/*     */     //   5089: fconst_1
/*     */     //   5090: invokeinterface setTimerSpeed : (F)V
/*     */     //   5095: iload #13
/*     */     //   5097: ifeq -> 5105
/*     */     //   5100: aload #15
/*     */     //   5102: goto -> 5107
/*     */     //   5105: aload #14
/*     */     //   5107: astore #19
/*     */     //   5109: aload #19
/*     */     //   5111: arraylength
/*     */     //   5112: istore #20
/*     */     //   5114: iconst_0
/*     */     //   5115: istore #18
/*     */     //   5117: iload #18
/*     */     //   5119: iload #20
/*     */     //   5121: if_icmpge -> 5507
/*     */     //   5124: aload #19
/*     */     //   5126: iload #18
/*     */     //   5128: daload
/*     */     //   5129: dstore #16
/*     */     //   5131: aload_0
/*     */     //   5132: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   5135: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5138: checkcast java/lang/Boolean
/*     */     //   5141: invokevirtual booleanValue : ()Z
/*     */     //   5144: ifeq -> 5211
/*     */     //   5147: aload_2
/*     */     //   5148: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   5151: iload #13
/*     */     //   5153: ifeq -> 5180
/*     */     //   5156: new java/lang/StringBuilder
/*     */     //   5159: dup
/*     */     //   5160: invokespecial <init> : ()V
/*     */     //   5163: ldc_w '[Crit w/ ResetLV]'
/*     */     //   5166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   5169: dload #16
/*     */     //   5171: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   5174: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   5177: goto -> 5201
/*     */     //   5180: new java/lang/StringBuilder
/*     */     //   5183: dup
/*     */     //   5184: invokespecial <init> : ()V
/*     */     //   5187: ldc_w '[Crit]'
/*     */     //   5190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   5193: dload #16
/*     */     //   5195: invokevirtual append : (D)Ljava/lang/StringBuilder;
/*     */     //   5198: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   5201: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   5206: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   5211: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5214: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   5219: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   5222: dload #5
/*     */     //   5224: dload #7
/*     */     //   5226: dload #16
/*     */     //   5228: dadd
/*     */     //   5229: dload #9
/*     */     //   5231: iconst_0
/*     */     //   5232: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   5237: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   5240: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   5245: iinc #18, 1
/*     */     //   5248: goto -> 5117
/*     */     //   5251: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*     */     //   5254: invokevirtual nextBoolean : ()Z
/*     */     //   5257: istore #12
/*     */     //   5259: iconst_4
/*     */     //   5260: newarray double
/*     */     //   5262: dup
/*     */     //   5263: iconst_0
/*     */     //   5264: ldc2_w 0.0200304
/*     */     //   5267: dastore
/*     */     //   5268: dup
/*     */     //   5269: iconst_1
/*     */     //   5270: ldc2_w 0.0113711
/*     */     //   5273: dastore
/*     */     //   5274: dup
/*     */     //   5275: iconst_2
/*     */     //   5276: ldc2_w 0.02159936000000332
/*     */     //   5279: dastore
/*     */     //   5280: dup
/*     */     //   5281: iconst_3
/*     */     //   5282: ldc2_w 0.00276651233
/*     */     //   5285: dastore
/*     */     //   5286: astore #13
/*     */     //   5288: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5291: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   5296: dup
/*     */     //   5297: ifnonnull -> 5303
/*     */     //   5300: invokestatic throwNpe : ()V
/*     */     //   5303: invokeinterface getMotionX : ()D
/*     */     //   5308: invokestatic abs : (D)D
/*     */     //   5311: ldc2_w 0.1
/*     */     //   5314: dcmpg
/*     */     //   5315: iflt -> 5348
/*     */     //   5318: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5321: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   5326: dup
/*     */     //   5327: ifnonnull -> 5333
/*     */     //   5330: invokestatic throwNpe : ()V
/*     */     //   5333: invokeinterface getMotionZ : ()D
/*     */     //   5338: invokestatic abs : (D)D
/*     */     //   5341: ldc2_w 0.1
/*     */     //   5344: dcmpg
/*     */     //   5345: ifge -> 5352
/*     */     //   5348: iconst_1
/*     */     //   5349: goto -> 5353
/*     */     //   5352: iconst_0
/*     */     //   5353: istore #14
/*     */     //   5355: iload #12
/*     */     //   5357: ifeq -> 5507
/*     */     //   5360: aload_0
/*     */     //   5361: getfield velocityInput : Z
/*     */     //   5364: ifne -> 5507
/*     */     //   5367: iload #14
/*     */     //   5369: ifeq -> 5507
/*     */     //   5372: aload #13
/*     */     //   5374: astore #18
/*     */     //   5376: aload #18
/*     */     //   5378: arraylength
/*     */     //   5379: istore #19
/*     */     //   5381: iconst_0
/*     */     //   5382: istore #17
/*     */     //   5384: iload #17
/*     */     //   5386: iload #19
/*     */     //   5388: if_icmpge -> 5507
/*     */     //   5391: aload #18
/*     */     //   5393: iload #17
/*     */     //   5395: daload
/*     */     //   5396: dstore #15
/*     */     //   5398: aload_0
/*     */     //   5399: getfield debug : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   5402: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   5405: checkcast java/lang/Boolean
/*     */     //   5408: invokevirtual booleanValue : ()Z
/*     */     //   5411: ifeq -> 5467
/*     */     //   5414: aload_2
/*     */     //   5415: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   5418: new java/lang/StringBuilder
/*     */     //   5421: dup
/*     */     //   5422: invokespecial <init> : ()V
/*     */     //   5425: ldc_w '[Crit] '
/*     */     //   5428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   5431: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5434: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   5439: dup
/*     */     //   5440: ifnonnull -> 5446
/*     */     //   5443: invokestatic throwNpe : ()V
/*     */     //   5446: invokeinterface getTicksExisted : ()I
/*     */     //   5451: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   5454: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   5457: invokeinterface createChatComponentText : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   5462: invokeinterface addChatMessage : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;)V
/*     */     //   5467: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   5470: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   5475: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   5478: dload #5
/*     */     //   5480: dload #7
/*     */     //   5482: dload #15
/*     */     //   5484: dadd
/*     */     //   5485: dload #9
/*     */     //   5487: iconst_0
/*     */     //   5488: invokeinterface createCPacketPlayerPosition : (DDDZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*     */     //   5493: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   5496: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   5501: iinc #17, 1
/*     */     //   5504: goto -> 5384
/*     */     //   5507: aload_0
/*     */     //   5508: getfield msTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   5511: invokevirtual reset : ()V
/*     */     //   5514: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #122	-> 6
/*     */     //   #123	-> 41
/*     */     //   #124	-> 129
/*     */     //   #124	-> 144
/*     */     //   #125	-> 147
/*     */     //   #126	-> 164
/*     */     //   #136	-> 175
/*     */     //   #137	-> 175
/*     */     //   #138	-> 175
/*     */     //   #137	-> 235
/*     */     //   #138	-> 251
/*     */     //   #139	-> 293
/*     */     //   #141	-> 294
/*     */     //   #142	-> 302
/*     */     //   #143	-> 310
/*     */     //   #145	-> 318
/*     */     //   #199	-> 568
/*     */     //   #146	-> 582
/*     */     //   #339	-> 596
/*     */     //   #188	-> 610
/*     */     //   #206	-> 624
/*     */     //   #362	-> 638
/*     */     //   #192	-> 652
/*     */     //   #234	-> 666
/*     */     //   #212	-> 680
/*     */     //   #396	-> 694
/*     */     //   #265	-> 708
/*     */     //   #363	-> 722
/*     */     //   #374	-> 736
/*     */     //   #225	-> 750
/*     */     //   #327	-> 764
/*     */     //   #219	-> 778
/*     */     //   #356	-> 792
/*     */     //   #278	-> 806
/*     */     //   #287	-> 820
/*     */     //   #345	-> 834
/*     */     //   #164	-> 848
/*     */     //   #306	-> 862
/*     */     //   #316	-> 876
/*     */     //   #299	-> 890
/*     */     //   #350	-> 904
/*     */     //   #147	-> 918
/*     */     //   #148	-> 948
/*     */     //   #149	-> 963
/*     */     //   #151	-> 1007
/*     */     //   #152	-> 1020
/*     */     //   #153	-> 1025
/*     */     //   #154	-> 1030
/*     */     //   #155	-> 1035
/*     */     //   #158	-> 1066
/*     */     //   #159	-> 1084
/*     */     //   #160	-> 1093
/*     */     //   #162	-> 1098
/*     */     //   #165	-> 1101
/*     */     //   #166	-> 1138
/*     */     //   #167	-> 1151
/*     */     //   #168	-> 1188
/*     */     //   #169	-> 1201
/*     */     //   #170	-> 1238
/*     */     //   #171	-> 1251
/*     */     //   #172	-> 1288
/*     */     //   #173	-> 1301
/*     */     //   #174	-> 1338
/*     */     //   #175	-> 1351
/*     */     //   #176	-> 1388
/*     */     //   #177	-> 1401
/*     */     //   #178	-> 1438
/*     */     //   #179	-> 1451
/*     */     //   #180	-> 1488
/*     */     //   #181	-> 1501
/*     */     //   #182	-> 1538
/*     */     //   #183	-> 1551
/*     */     //   #184	-> 1588
/*     */     //   #185	-> 1601
/*     */     //   #186	-> 1638
/*     */     //   #189	-> 1652
/*     */     //   #190	-> 1741
/*     */     //   #193	-> 1833
/*     */     //   #194	-> 1868
/*     */     //   #195	-> 1899
/*     */     //   #196	-> 1934
/*     */     //   #197	-> 1965
/*     */     //   #200	-> 1978
/*     */     //   #201	-> 2013
/*     */     //   #202	-> 2048
/*     */     //   #203	-> 2083
/*     */     //   #204	-> 2118
/*     */     //   #207	-> 2131
/*     */     //   #208	-> 2166
/*     */     //   #209	-> 2201
/*     */     //   #210	-> 2236
/*     */     //   #213	-> 2249
/*     */     //   #214	-> 2284
/*     */     //   #215	-> 2319
/*     */     //   #216	-> 2354
/*     */     //   #220	-> 2392
/*     */     //   #221	-> 2427
/*     */     //   #222	-> 2462
/*     */     //   #226	-> 2500
/*     */     //   #227	-> 2513
/*     */     //   #228	-> 2521
/*     */     //   #229	-> 2556
/*     */     //   #231	-> 2587
/*     */     //   #232	-> 2595
/*     */     //   #235	-> 2603
/*     */     //   #236	-> 2623
/*     */     //   #237	-> 2626
/*     */     //   #236	-> 2691
/*     */     //   #235	-> 2699
/*     */     //   #240	-> 2704
/*     */     //   #241	-> 2724
/*     */     //   #242	-> 2727
/*     */     //   #243	-> 2747
/*     */     //   #244	-> 2771
/*     */     //   #245	-> 2791
/*     */     //   #241	-> 2792
/*     */     //   #240	-> 2800
/*     */     //   #248	-> 2805
/*     */     //   #249	-> 2825
/*     */     //   #250	-> 2828
/*     */     //   #251	-> 2848
/*     */     //   #252	-> 2872
/*     */     //   #253	-> 2892
/*     */     //   #249	-> 2893
/*     */     //   #248	-> 2901
/*     */     //   #256	-> 2906
/*     */     //   #257	-> 2926
/*     */     //   #258	-> 2929
/*     */     //   #259	-> 2949
/*     */     //   #260	-> 2973
/*     */     //   #261	-> 2993
/*     */     //   #257	-> 2994
/*     */     //   #256	-> 3002
/*     */     //   #266	-> 3010
/*     */     //   #267	-> 3023
/*     */     //   #268	-> 3032
/*     */     //   #269	-> 3045
/*     */     //   #270	-> 3058
/*     */     //   #271	-> 3071
/*     */     //   #272	-> 3076
/*     */     //   #273	-> 3092
/*     */     //   #274	-> 3145
/*     */     //   #279	-> 3187
/*     */     //   #280	-> 3222
/*     */     //   #281	-> 3257
/*     */     //   #282	-> 3292
/*     */     //   #283	-> 3302
/*     */     //   #284	-> 3318
/*     */     //   #285	-> 3371
/*     */     //   #288	-> 3413
/*     */     //   #289	-> 3426
/*     */     //   #290	-> 3434
/*     */     //   #291	-> 3447
/*     */     //   #292	-> 3460
/*     */     //   #293	-> 3473
/*     */     //   #294	-> 3478
/*     */     //   #295	-> 3494
/*     */     //   #296	-> 3547
/*     */     //   #300	-> 3589
/*     */     //   #301	-> 3624
/*     */     //   #302	-> 3659
/*     */     //   #303	-> 3675
/*     */     //   #304	-> 3728
/*     */     //   #307	-> 3770
/*     */     //   #308	-> 3799
/*     */     //   #309	-> 3828
/*     */     //   #310	-> 3917
/*     */     //   #311	-> 4006
/*     */     //   #312	-> 4022
/*     */     //   #313	-> 4075
/*     */     //   #317	-> 4117
/*     */     //   #318	-> 4130
/*     */     //   #319	-> 4139
/*     */     //   #320	-> 4174
/*     */     //   #321	-> 4209
/*     */     //   #322	-> 4214
/*     */     //   #323	-> 4230
/*     */     //   #324	-> 4283
/*     */     //   #328	-> 4325
/*     */     //   #329	-> 4338
/*     */     //   #330	-> 4346
/*     */     //   #331	-> 4381
/*     */     //   #333	-> 4412
/*     */     //   #334	-> 4420
/*     */     //   #335	-> 4425
/*     */     //   #336	-> 4441
/*     */     //   #337	-> 4494
/*     */     //   #340	-> 4536
/*     */     //   #341	-> 4545
/*     */     //   #342	-> 4554
/*     */     //   #346	-> 4564
/*     */     //   #347	-> 4599
/*     */     //   #348	-> 4634
/*     */     //   #351	-> 4653
/*     */     //   #352	-> 4671
/*     */     //   #353	-> 4680
/*     */     //   #357	-> 4688
/*     */     //   #358	-> 4706
/*     */     //   #359	-> 4715
/*     */     //   #362	-> 4723
/*     */     //   #364	-> 4735
/*     */     //   #365	-> 4748
/*     */     //   #366	-> 4756
/*     */     //   #367	-> 4761
/*     */     //   #368	-> 4796
/*     */     //   #369	-> 4827
/*     */     //   #370	-> 4843
/*     */     //   #371	-> 4896
/*     */     //   #375	-> 4938
/*     */     //   #376	-> 4946
/*     */     //   #377	-> 4949
/*     */     //   #378	-> 4989
/*     */     //   #379	-> 4992
/*     */     //   #381	-> 5002
/*     */     //   #382	-> 5016
/*     */     //   #383	-> 5019
/*     */     //   #385	-> 5019
/*     */     //   #386	-> 5048
/*     */     //   #387	-> 5065
/*     */     //   #388	-> 5070
/*     */     //   #389	-> 5095
/*     */     //   #390	-> 5131
/*     */     //   #391	-> 5147
/*     */     //   #392	-> 5211
/*     */     //   #389	-> 5245
/*     */     //   #397	-> 5251
/*     */     //   #398	-> 5259
/*     */     //   #399	-> 5288
/*     */     //   #400	-> 5355
/*     */     //   #401	-> 5372
/*     */     //   #402	-> 5398
/*     */     //   #403	-> 5414
/*     */     //   #404	-> 5467
/*     */     //   #401	-> 5501
/*     */     //   #408	-> 5507
/*     */     //   #410	-> 5507
/*     */     //   #412	-> 5514
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   948	150	12	blink	Lnet/ccbluex/liquidbounce/features/module/modules/player/Blink;
/*     */     //   5131	117	16	offset	D
/*     */     //   5065	186	15	vlResetOffset	[D
/*     */     //   5048	203	14	noramlOffset	[D
/*     */     //   4949	302	13	resetLVBoolean	Z
/*     */     //   4946	305	12	randomCritBoolean	Z
/*     */     //   5398	106	15	offset	D
/*     */     //   5355	152	14	movecheck	Z
/*     */     //   5288	219	13	noramlOffset	[D
/*     */     //   5259	248	12	randomCritBoolean	Z
/*     */     //   318	5196	9	z	D
/*     */     //   310	5204	7	y	D
/*     */     //   302	5212	5	x	D
/*     */     //   175	5339	4	$fun$sendCriticalPacket$1	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals$onAttack$1;
/*     */     //   164	5350	3	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   147	5367	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	5515	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;
/*     */     //   0	5515	1	event	Lnet/ccbluex/liquidbounce/event/AttackEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 416 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*     */     
/* 418 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 419 */       if (MinecraftInstance.classProvider.isSPacketEntityVelocity(packet)) {
/* 420 */         ISPacketEntityVelocity packetEntityVelocity = packet.asSPacketEntityVelocity();
/* 421 */         if (MinecraftInstance.mc.getTheWorld() != null && MinecraftInstance.mc.getTheWorld().getEntityByID(packetEntityVelocity.getEntityID()) != null) { if ((Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getEntityByID(packetEntityVelocity.getEntityID()), thePlayer) ^ true) != 0) {
/*     */             return;
/*     */           }
/*     */ 
/*     */           
/* 426 */           this.velocityInput = false; }
/*     */         else
/*     */         { MinecraftInstance.mc.getTheWorld().getEntityByID(packetEntityVelocity.getEntityID()); return; }
/*     */       
/* 430 */       }  if (MinecraftInstance.classProvider.isCPacketPlayer(packet) && StringsKt.equals((String)this.modeValue.get(), "NoGround", true)) {
/* 431 */         packet.asCPacketPlayer().setOnGround(false);
/*     */       }
/* 433 */       if (MinecraftInstance.classProvider.isCPacketPlayer(packet) && StringsKt.equals((String)this.modeValue.get(), "C03", true)) {
/* 434 */         packet.asCPacketPlayer().setOnGround(false);
/*     */       }
/* 436 */       if (StringsKt.equals((String)this.modeValue.get(), "C03", true)) {
/* 437 */         MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(false);
/* 438 */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);
/* 439 */         MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);
/* 440 */         MinecraftInstance.mc.getGameSettings().getKeyBindBack().setPressed(false);
/* 441 */         MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false);
/* 442 */         MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false);
/* 443 */         if (MinecraftInstance.classProvider.isCPacketPlayer(event.getPacket()))
/* 444 */           event.cancelEvent(); 
/*     */       } 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @Nullable
/*     */   public String getTag() {
/* 450 */     return StringsKt.contains$default((CharSequence)this.modeValue.get(), "Packet", false, 2, null) ? "Packet" : (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Criticals.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */