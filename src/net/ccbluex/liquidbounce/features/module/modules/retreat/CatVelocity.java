/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
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
/*     */ @ModuleInfo(name = "CatVelocity", description = "idk", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\b\n\002\020\006\n\002\b\r\n\002\020\b\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\f\n\002\020\016\n\002\b\006\n\002\030\002\n\002\b\016\n\002\020\007\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J \020K\032\0020\t2\006\020\b\032\0020#2\006\020L\032\0020\0252\b\b\002\020M\032\0020\tJ\b\020N\032\0020OH\002J\b\020P\032\0020QH\026J\b\020R\032\0020QH\026J\020\020S\032\0020Q2\006\020T\032\0020UH\007J\020\020V\032\0020Q2\006\020T\032\0020WH\007J\020\020X\032\0020Q2\006\020T\032\0020YH\007J\020\020Z\032\0020Q2\006\020T\032\0020[H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\fX\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\006X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\fX\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\025X\016¢\006\002\n\000R\016\020\026\032\0020\025X\016¢\006\002\n\000R\016\020\027\032\0020\006X\004¢\006\002\n\000R\032\020\030\032\0020\tX\016¢\006\016\n\000\032\004\b\031\020\032\"\004\b\033\020\034R\032\020\035\032\0020\tX\016¢\006\016\n\000\032\004\b\036\020\032\"\004\b\037\020\034R\016\020 \032\0020\006X\004¢\006\002\n\000R\016\020!\032\0020\tX\016¢\006\002\n\000R\016\020\"\032\0020#X\016¢\006\002\n\000R\016\020$\032\0020\004X\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\004X\004¢\006\002\n\000R\016\020'\032\0020(X\004¢\006\002\n\000R\016\020)\032\0020\006X\004¢\006\002\n\000R\016\020*\032\0020\004X\004¢\006\002\n\000R\020\020+\032\004\030\0010,X\016¢\006\002\n\000R\016\020-\032\0020\006X\004¢\006\002\n\000R\016\020.\032\0020#X\016¢\006\002\n\000R\032\020/\032\0020\025X\016¢\006\016\n\000\032\004\b0\0201\"\004\b2\0203R\016\0204\032\0020\006X\004¢\006\002\n\000R\016\0205\032\0020\tX\016¢\006\002\n\000R\016\0206\032\0020\006X\004¢\006\002\n\000R\016\0207\032\0020\004X\004¢\006\002\n\000R\024\0208\032\002098VX\004¢\006\006\032\004\b:\020;R\016\020<\032\0020\tX\016¢\006\002\n\000R\016\020=\032\0020\tX\016¢\006\002\n\000R\016\020>\032\0020\tX\016¢\006\002\n\000R\016\020?\032\0020@X\016¢\006\002\n\000R\016\020A\032\0020\006X\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\025X\016¢\006\002\n\000R\032\020D\032\0020\025X\016¢\006\016\n\000\032\004\bE\0201\"\004\bF\0203R\016\020G\032\0020\025X\016¢\006\002\n\000R\032\020H\032\0020\025X\016¢\006\016\n\000\032\004\bI\0201\"\004\bJ\0203¨\006\\"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/CatVelocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Auto", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "aacPushXZReducerValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "airReducerValue", "attack", "", "attackValue", "attacktimes", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "clickCount", "clickFakeSwing", "clickOnPacket", "clickRange", "clickSwing", "clickTime", "cpsbypass", "d1", "", "d2", "distance", "doinrange", "getDoinrange", "()Z", "setDoinrange", "(Z)V", "dosprint", "getDosprint", "setDosprint", "horizontalValue", "jump", "jumped", "", "legitFaceValue", "legitPush", "legitStrafeValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msValue", "onlyinRange", "pos", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "pushValue", "pushtick", "radiansYaw", "getRadiansYaw", "()D", "setRadiansYaw", "(D)V", "reverse2StrengthValue", "reverseHurt", "reverseStrengthValue", "stapreduce", "tag", "", "getTag", "()Ljava/lang/String;", "velocityInput", "velocityInput2", "velocityInput3", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "verticalValue", "wtapreduce", "x", "xx", "getXx", "setXx", "z", "zz", "getZz", "setZz", "attackRayTrace", "range", "doAttack", "getMoveYaw", "", "onDisable", "", "onEnable", "onJump", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class CatVelocity
/*     */   extends Module
/*     */ {
/*  40 */   private final FloatValue horizontalValue = new FloatValue("Horizontal", 0.79F, 0.0F, 1.0F);
/*  41 */   private final FloatValue verticalValue = new FloatValue("Vertical", 0.0F, 0.0F, 1.0F);
/*  42 */   private final FloatValue airReducerValue = new FloatValue("airReducer", 0.95F, 0.0F, 1.0F);
/*     */   
/*  44 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Simple", "AAC", "AACPush", "AACZero", 
/*  45 */         "Reverse", "SmoothReverse", "Jump", "Glitch", "Smart", "HytPit", "Grim", "Click", "Noxz" }, "Smart");
/*     */ 
/*     */   
/*  48 */   private final FloatValue reverseStrengthValue = new FloatValue("ReverseStrength", 1.0F, 0.1F, 1.0F);
/*  49 */   private final FloatValue reverse2StrengthValue = new FloatValue("SmoothReverseStrength", 0.05F, 0.02F, 0.1F);
/*     */ 
/*     */   
/*  52 */   private final FloatValue aacPushXZReducerValue = new FloatValue("AACPushXZReducer", 2.0F, 1.0F, 3.0F);
/*  53 */   private final FloatValue msValue = new FloatValue("msValue", 80.0F, 1.0F, 500.0F);
/*     */ 
/*     */   
/*  56 */   private final BoolValue wtapreduce = new BoolValue("Wtap reduce", false);
/*  57 */   private final BoolValue stapreduce = new BoolValue("Stap reduce", true);
/*  58 */   private final BoolValue legitPush = new BoolValue("Legit Push", false);
/*  59 */   private final BoolValue attackValue = new BoolValue("Attack Reduce", true);
/*  60 */   private final BoolValue cpsbypass = new BoolValue("Cps Bypass", true);
/*  61 */   private final IntegerValue attacktimes = new IntegerValue("Attack Times", 5, 1, 50);
/*  62 */   private final BoolValue legitFaceValue = new BoolValue("Legit Face", false);
/*  63 */   private final BoolValue legitStrafeValue = new BoolValue("Legit Strafe", false);
/*  64 */   private final FloatValue pushValue = new FloatValue("PushSpeed", 0.0F, 0.0F, 1.0F);
/*  65 */   private final BoolValue Auto = new BoolValue("Auto Reduce", true);
/*  66 */   private final BoolValue onlyinRange = new BoolValue("Only InRange", true);
/*  67 */   private final FloatValue distance = new FloatValue("inRange", 4.0F, 0.0F, 6.0F);
/*     */ 
/*     */ 
/*     */   
/*  71 */   private final IntegerValue clickCount = new IntegerValue("ClickCount", 2, 1, 10);
/*  72 */   private final IntegerValue clickTime = new IntegerValue("ClickMinHurtTime", 8, 1, 10);
/*  73 */   private final FloatValue clickRange = new FloatValue("ClickRange", 3.0F, 2.5F, 7.0F);
/*  74 */   private final BoolValue clickOnPacket = new BoolValue("ClickOnPacket", true);
/*  75 */   private final BoolValue clickSwing = new BoolValue("ClickSwing", false);
/*  76 */   private final BoolValue clickFakeSwing = new BoolValue("ClickFakeSwing", true);
/*     */   private double radiansYaw; private double xx; private double zz;
/*     */   private int jumped;
/*     */   
/*  80 */   public final double getRadiansYaw() { return this.radiansYaw; } public final void setRadiansYaw(double <set-?>) { this.radiansYaw = <set-?>; }
/*  81 */   public final double getXx() { return this.xx; } public final void setXx(double <set-?>) { this.xx = <set-?>; }
/*  82 */   public final double getZz() { return this.zz; } public final void setZz(double <set-?>) { this.zz = <set-?>; }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dosprint = true;
/*     */   
/*     */   public final boolean getDosprint() {
/*  89 */     return this.dosprint; } public final void setDosprint(boolean <set-?>) { this.dosprint = <set-?>; }
/*  90 */   private boolean doinrange = true; public final boolean getDoinrange() { return this.doinrange; } public final void setDoinrange(boolean <set-?>) { this.doinrange = <set-?>; }
/*  91 */    private MSTimer velocityTimer = new MSTimer();
/*     */   
/*     */   private boolean velocityInput;
/*     */   
/*     */   private boolean velocityInput2;
/*     */   
/*     */   private boolean velocityInput3;
/*     */   
/*     */   private double x;
/*     */   
/*     */   private double z;
/*     */   
/*     */   private double d1;
/*     */   
/*     */   private double d2;
/*     */   
/*     */   private int pushtick;
/*     */   
/*     */   private WBlockPos pos;
/*     */   
/*     */   private boolean reverseHurt;
/*     */   private boolean jump;
/*     */   private boolean attack;
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/* 117 */     return (String)this.modeValue.get();
/*     */   }
/*     */   public void onDisable() {
/* 120 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); } else { MinecraftInstance.mc.getThePlayer(); }
/* 121 */      this.velocityInput = false;
/* 122 */     this.velocityInput2 = false;
/* 123 */     this.attack = false;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/* 127 */     this.velocityInput = false;
/* 128 */     this.velocityInput2 = false;
/* 129 */     this.attack = false;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event) {
/* 134 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 109549001:
/* 135 */         if (str.equals("smart")) {
/* 136 */           if (this.pos != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0)
/*     */             
/*     */             { 
/* 139 */               if (this.pos == null) Intrinsics.throwNpe();  if (this.pos == null) Intrinsics.throwNpe();  if (this.pos == null) Intrinsics.throwNpe();  Rotation rot = RotationUtils.getRotations(this.pos.getX(), this.pos.getY(), this.pos.getZ());
/* 140 */               if (((Boolean)this.legitFaceValue.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround())
/* 141 */                   RotationUtils.setTargetRotation(rot);  }
/*     */               
/* 143 */               float yaw = rot.getYaw();
/* 144 */               if (((Boolean)this.legitStrafeValue.get()).booleanValue())
/* 145 */               { float speed = MovementUtils.INSTANCE.getSpeed();
/* 146 */                 double yaw1 = Math.toRadians(yaw);
/* 147 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP iEntityPlayerSP = MinecraftInstance.mc.getThePlayer(); boolean bool1 = false; double d1 = Math.sin(yaw1); iEntityPlayerSP.setMotionX(-d1 * speed);
/* 148 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  iEntityPlayerSP = MinecraftInstance.mc.getThePlayer(); bool1 = false; d1 = Math.cos(yaw1); iEntityPlayerSP.setMotionZ(d1 * speed); }  break; }  }  return;
/*     */         }  break;
/*     */       case 3181391:
/* 151 */         if (str.equals("grim")) {
/* 152 */           this.radiansYaw = Math.toRadians(getMoveYaw());
/* 153 */           this.xx = -Math.sin(this.radiansYaw) * 0.2873D;
/* 154 */           this.zz = Math.cos(this.radiansYaw) * 0.2873D;
/* 155 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX() + this.x, MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ() + this.z, false));
/* 156 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerPosition(MinecraftInstance.mc.getThePlayer().getPosX() + this.x, MinecraftInstance.mc.getThePlayer().getPosY() - 999.0D, MinecraftInstance.mc.getThePlayer().getPosZ() + this.z, true));
/*     */         }  break;
/*     */       case -1202222792:
/* 159 */         if (str.equals("hytpit")) {
/* 160 */           if (this.pos != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0) {
/*     */ 
/*     */               
/* 163 */               if (this.pos == null) Intrinsics.throwNpe();  if (this.pos == null) Intrinsics.throwNpe();  if (this.pos == null) Intrinsics.throwNpe();  Rotation rot = RotationUtils.getRotations(this.pos.getX(), this.pos.getY(), this.pos.getZ());
/* 164 */               if (((Boolean)this.legitFaceValue.get()).booleanValue()) {
/* 165 */                 RotationUtils.setTargetRotation(rot);
/*     */               }
/* 167 */               float yaw = rot.getYaw();
/* 168 */               if (((Boolean)this.legitStrafeValue.get()).booleanValue()) {
/* 169 */                 float speed = MovementUtils.INSTANCE.getSpeed();
/* 170 */                 double yaw1 = Math.toRadians(yaw);
/* 171 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP iEntityPlayerSP = MinecraftInstance.mc.getThePlayer(); boolean bool1 = false; double d1 = Math.sin(yaw1); iEntityPlayerSP.setMotionX(-d1 * speed);
/* 172 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  iEntityPlayerSP = MinecraftInstance.mc.getThePlayer(); bool1 = false; d1 = Math.cos(yaw1); iEntityPlayerSP.setMotionZ(d1 * speed);
/*     */               } 
/*     */               break;
/*     */             }  }
/*     */           
/*     */           return;
/*     */         } 
/*     */         break; }
/*     */   
/*     */   }
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 23
/*     */     //   21: pop
/*     */     //   22: return
/*     */     //   23: astore_2
/*     */     //   24: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   27: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   30: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   33: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   36: dup
/*     */     //   37: ifnonnull -> 51
/*     */     //   40: new kotlin/TypeCastException
/*     */     //   43: dup
/*     */     //   44: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   47: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   50: athrow
/*     */     //   51: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   54: astore_3
/*     */     //   55: aload_0
/*     */     //   56: getfield wtapreduce : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   59: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   62: checkcast java/lang/Boolean
/*     */     //   65: invokevirtual booleanValue : ()Z
/*     */     //   68: ifeq -> 140
/*     */     //   71: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   74: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   79: dup
/*     */     //   80: ifnonnull -> 86
/*     */     //   83: invokestatic throwNpe : ()V
/*     */     //   86: invokeinterface getHurtTime : ()I
/*     */     //   91: bipush #9
/*     */     //   93: if_icmpge -> 140
/*     */     //   96: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   99: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   104: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   109: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   112: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   117: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   120: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   125: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   130: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   135: invokeinterface setPressed : (Z)V
/*     */     //   140: aload_2
/*     */     //   141: invokeinterface isInWater : ()Z
/*     */     //   146: ifne -> 167
/*     */     //   149: aload_2
/*     */     //   150: invokeinterface isInLava : ()Z
/*     */     //   155: ifne -> 167
/*     */     //   158: aload_2
/*     */     //   159: invokeinterface isInWeb : ()Z
/*     */     //   164: ifeq -> 168
/*     */     //   167: return
/*     */     //   168: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   171: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   176: dup
/*     */     //   177: ifnonnull -> 183
/*     */     //   180: invokestatic throwNpe : ()V
/*     */     //   183: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   188: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   193: astore #5
/*     */     //   195: aload #5
/*     */     //   197: invokeinterface hasNext : ()Z
/*     */     //   202: ifeq -> 339
/*     */     //   205: aload #5
/*     */     //   207: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   212: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   215: astore #4
/*     */     //   217: aload #4
/*     */     //   219: astore #6
/*     */     //   221: iconst_0
/*     */     //   222: istore #7
/*     */     //   224: aload #6
/*     */     //   226: dup
/*     */     //   227: ifnonnull -> 241
/*     */     //   230: new kotlin/TypeCastException
/*     */     //   233: dup
/*     */     //   234: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityImpl<*>'
/*     */     //   237: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   240: athrow
/*     */     //   241: checkcast net/ccbluex/liquidbounce/injection/backend/EntityImpl
/*     */     //   244: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   247: instanceof net/minecraft/entity/EntityLivingBase
/*     */     //   250: ifeq -> 331
/*     */     //   253: aload #4
/*     */     //   255: invokeinterface getEntityId : ()I
/*     */     //   260: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   263: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   268: dup
/*     */     //   269: ifnonnull -> 275
/*     */     //   272: invokestatic throwNpe : ()V
/*     */     //   275: invokeinterface getEntityId : ()I
/*     */     //   280: if_icmpeq -> 331
/*     */     //   283: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   286: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   291: dup
/*     */     //   292: ifnonnull -> 298
/*     */     //   295: invokestatic throwNpe : ()V
/*     */     //   298: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   301: aload #4
/*     */     //   303: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   306: aload_0
/*     */     //   307: getfield distance : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   310: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   313: checkcast java/lang/Number
/*     */     //   316: invokevirtual doubleValue : ()D
/*     */     //   319: dcmpg
/*     */     //   320: ifgt -> 331
/*     */     //   323: aload_0
/*     */     //   324: iconst_1
/*     */     //   325: putfield doinrange : Z
/*     */     //   328: goto -> 336
/*     */     //   331: aload_0
/*     */     //   332: iconst_0
/*     */     //   333: putfield doinrange : Z
/*     */     //   336: goto -> 195
/*     */     //   339: aload_0
/*     */     //   340: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   343: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   346: checkcast java/lang/String
/*     */     //   349: astore #4
/*     */     //   351: iconst_0
/*     */     //   352: istore #5
/*     */     //   354: aload #4
/*     */     //   356: dup
/*     */     //   357: ifnonnull -> 370
/*     */     //   360: new kotlin/TypeCastException
/*     */     //   363: dup
/*     */     //   364: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   366: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   369: athrow
/*     */     //   370: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   373: dup
/*     */     //   374: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   376: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   379: astore #4
/*     */     //   381: aload #4
/*     */     //   383: invokevirtual hashCode : ()I
/*     */     //   386: lookupswitch default -> 3229, -1970553484 -> 622, -1243181771 -> 512, -1234547235 -> 540, -1234264725 -> 526, -1202222792 -> 609, 96323 -> 498, 3273774 -> 595, 3387523 -> 484, 94750088 -> 568, 109549001 -> 582, 1099846370 -> 554
/*     */     //   484: aload #4
/*     */     //   486: ldc_w 'noxz'
/*     */     //   489: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   492: ifeq -> 3229
/*     */     //   495: goto -> 883
/*     */     //   498: aload #4
/*     */     //   500: ldc_w 'aac'
/*     */     //   503: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   506: ifeq -> 3229
/*     */     //   509: goto -> 2747
/*     */     //   512: aload #4
/*     */     //   514: ldc_w 'glitch'
/*     */     //   517: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   520: ifeq -> 3229
/*     */     //   523: goto -> 2551
/*     */     //   526: aload #4
/*     */     //   528: ldc_w 'aaczero'
/*     */     //   531: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   534: ifeq -> 3229
/*     */     //   537: goto -> 3156
/*     */     //   540: aload #4
/*     */     //   542: ldc_w 'aacpush'
/*     */     //   545: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   548: ifeq -> 3229
/*     */     //   551: goto -> 3033
/*     */     //   554: aload #4
/*     */     //   556: ldc_w 'reverse'
/*     */     //   559: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   562: ifeq -> 3229
/*     */     //   565: goto -> 2589
/*     */     //   568: aload #4
/*     */     //   570: ldc_w 'click'
/*     */     //   573: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   576: ifeq -> 3229
/*     */     //   579: goto -> 758
/*     */     //   582: aload #4
/*     */     //   584: ldc 'smart'
/*     */     //   586: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   589: ifeq -> 3229
/*     */     //   592: goto -> 1281
/*     */     //   595: aload #4
/*     */     //   597: ldc_w 'jump'
/*     */     //   600: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   603: ifeq -> 3229
/*     */     //   606: goto -> 636
/*     */     //   609: aload #4
/*     */     //   611: ldc 'hytpit'
/*     */     //   613: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   616: ifeq -> 3229
/*     */     //   619: goto -> 2307
/*     */     //   622: aload #4
/*     */     //   624: ldc_w 'smoothreverse'
/*     */     //   627: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   630: ifeq -> 3229
/*     */     //   633: goto -> 2653
/*     */     //   636: aload_2
/*     */     //   637: invokeinterface getHurtTime : ()I
/*     */     //   642: ifle -> 3229
/*     */     //   645: aload_2
/*     */     //   646: invokeinterface getOnGround : ()Z
/*     */     //   651: ifeq -> 3229
/*     */     //   654: aload_2
/*     */     //   655: ldc2_w 0.4199999
/*     */     //   658: invokeinterface setMotionY : (D)V
/*     */     //   663: aload_2
/*     */     //   664: invokeinterface getRotationYaw : ()F
/*     */     //   669: ldc_w 0.017453292
/*     */     //   672: fmul
/*     */     //   673: fstore #5
/*     */     //   675: aload_2
/*     */     //   676: dup
/*     */     //   677: invokeinterface getMotionX : ()D
/*     */     //   682: dstore #9
/*     */     //   684: astore #8
/*     */     //   686: iconst_0
/*     */     //   687: istore #6
/*     */     //   689: fload #5
/*     */     //   691: f2d
/*     */     //   692: invokestatic sin : (D)D
/*     */     //   695: d2f
/*     */     //   696: fstore #11
/*     */     //   698: aload #8
/*     */     //   700: dload #9
/*     */     //   702: fload #11
/*     */     //   704: f2d
/*     */     //   705: ldc2_w 0.2
/*     */     //   708: dmul
/*     */     //   709: dsub
/*     */     //   710: invokeinterface setMotionX : (D)V
/*     */     //   715: aload_2
/*     */     //   716: dup
/*     */     //   717: invokeinterface getMotionZ : ()D
/*     */     //   722: dstore #9
/*     */     //   724: astore #8
/*     */     //   726: iconst_0
/*     */     //   727: istore #6
/*     */     //   729: fload #5
/*     */     //   731: f2d
/*     */     //   732: invokestatic cos : (D)D
/*     */     //   735: d2f
/*     */     //   736: fstore #11
/*     */     //   738: aload #8
/*     */     //   740: dload #9
/*     */     //   742: fload #11
/*     */     //   744: f2d
/*     */     //   745: ldc2_w 0.2
/*     */     //   748: dmul
/*     */     //   749: dadd
/*     */     //   750: invokeinterface setMotionZ : (D)V
/*     */     //   755: goto -> 3229
/*     */     //   758: aload_0
/*     */     //   759: getfield velocityInput : Z
/*     */     //   762: ifeq -> 875
/*     */     //   765: aload_2
/*     */     //   766: invokeinterface getHurtTime : ()I
/*     */     //   771: aload_0
/*     */     //   772: getfield clickTime : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   775: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   778: checkcast java/lang/Number
/*     */     //   781: invokevirtual intValue : ()I
/*     */     //   784: if_icmplt -> 875
/*     */     //   787: aload_0
/*     */     //   788: aload_0
/*     */     //   789: getfield clickCount : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   792: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   795: checkcast java/lang/Number
/*     */     //   798: invokevirtual intValue : ()I
/*     */     //   801: aload_0
/*     */     //   802: getfield clickRange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   805: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   808: checkcast java/lang/Number
/*     */     //   811: invokevirtual floatValue : ()F
/*     */     //   814: f2d
/*     */     //   815: aload_2
/*     */     //   816: invokeinterface getSprinting : ()Z
/*     */     //   821: invokevirtual attackRayTrace : (IDZ)Z
/*     */     //   824: ifne -> 3229
/*     */     //   827: aload_0
/*     */     //   828: getfield clickFakeSwing : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   831: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   834: checkcast java/lang/Boolean
/*     */     //   837: invokevirtual booleanValue : ()Z
/*     */     //   840: ifeq -> 867
/*     */     //   843: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   846: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   851: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   854: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   859: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   862: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   867: aload_0
/*     */     //   868: iconst_0
/*     */     //   869: putfield velocityInput : Z
/*     */     //   872: goto -> 3229
/*     */     //   875: aload_0
/*     */     //   876: iconst_0
/*     */     //   877: putfield velocityInput : Z
/*     */     //   880: goto -> 3229
/*     */     //   883: aload_0
/*     */     //   884: getfield velocityInput : Z
/*     */     //   887: ifeq -> 1215
/*     */     //   890: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   893: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   898: dup
/*     */     //   899: ifnonnull -> 905
/*     */     //   902: invokestatic throwNpe : ()V
/*     */     //   905: invokeinterface getOnGround : ()Z
/*     */     //   910: ifeq -> 1016
/*     */     //   913: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   916: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   921: dup
/*     */     //   922: ifnonnull -> 928
/*     */     //   925: invokestatic throwNpe : ()V
/*     */     //   928: invokeinterface getHurtTime : ()I
/*     */     //   933: bipush #9
/*     */     //   935: if_icmpne -> 1016
/*     */     //   938: aload_0
/*     */     //   939: getfield jumped : I
/*     */     //   942: iconst_2
/*     */     //   943: if_icmple -> 954
/*     */     //   946: aload_0
/*     */     //   947: iconst_0
/*     */     //   948: putfield jumped : I
/*     */     //   951: goto -> 1090
/*     */     //   954: aload_0
/*     */     //   955: dup
/*     */     //   956: dup
/*     */     //   957: getfield jumped : I
/*     */     //   960: iconst_1
/*     */     //   961: iadd
/*     */     //   962: putfield jumped : I
/*     */     //   965: getfield jumped : I
/*     */     //   968: pop
/*     */     //   969: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   972: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   977: dup
/*     */     //   978: ifnonnull -> 984
/*     */     //   981: invokestatic throwNpe : ()V
/*     */     //   984: invokeinterface getTicksExisted : ()I
/*     */     //   989: iconst_5
/*     */     //   990: irem
/*     */     //   991: ifeq -> 1013
/*     */     //   994: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   997: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1002: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1007: iconst_1
/*     */     //   1008: invokeinterface setPressed : (Z)V
/*     */     //   1013: goto -> 1090
/*     */     //   1016: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1019: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1024: dup
/*     */     //   1025: ifnonnull -> 1031
/*     */     //   1028: invokestatic throwNpe : ()V
/*     */     //   1031: invokeinterface getHurtTime : ()I
/*     */     //   1036: bipush #8
/*     */     //   1038: if_icmpne -> 1090
/*     */     //   1041: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1044: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1049: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1054: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1057: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1062: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1065: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1070: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1075: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   1080: invokeinterface setPressed : (Z)V
/*     */     //   1085: aload_0
/*     */     //   1086: iconst_0
/*     */     //   1087: putfield velocityInput : Z
/*     */     //   1090: aload_0
/*     */     //   1091: getfield attack : Z
/*     */     //   1094: ifeq -> 1215
/*     */     //   1097: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1100: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1105: dup
/*     */     //   1106: ifnonnull -> 1112
/*     */     //   1109: invokestatic throwNpe : ()V
/*     */     //   1112: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   1117: invokeinterface getMoveForward : ()F
/*     */     //   1122: ldc_w 0.9
/*     */     //   1125: fcmpl
/*     */     //   1126: ifle -> 1210
/*     */     //   1129: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1132: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1137: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1142: invokeinterface isKeyDown : ()Z
/*     */     //   1147: ifeq -> 1210
/*     */     //   1150: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1153: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1158: dup
/*     */     //   1159: ifnonnull -> 1165
/*     */     //   1162: invokestatic throwNpe : ()V
/*     */     //   1165: dup
/*     */     //   1166: invokeinterface getMotionX : ()D
/*     */     //   1171: ldc2_w 0.08
/*     */     //   1174: dmul
/*     */     //   1175: invokeinterface setMotionX : (D)V
/*     */     //   1180: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1183: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1188: dup
/*     */     //   1189: ifnonnull -> 1195
/*     */     //   1192: invokestatic throwNpe : ()V
/*     */     //   1195: dup
/*     */     //   1196: invokeinterface getMotionZ : ()D
/*     */     //   1201: ldc2_w 0.08
/*     */     //   1204: dmul
/*     */     //   1205: invokeinterface setMotionZ : (D)V
/*     */     //   1210: aload_0
/*     */     //   1211: iconst_0
/*     */     //   1212: putfield attack : Z
/*     */     //   1215: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1218: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1223: dup
/*     */     //   1224: ifnonnull -> 1230
/*     */     //   1227: invokestatic throwNpe : ()V
/*     */     //   1230: invokeinterface getHurtTime : ()I
/*     */     //   1235: ifne -> 3229
/*     */     //   1238: aload_0
/*     */     //   1239: getfield cpsbypass : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1242: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1245: checkcast java/lang/Boolean
/*     */     //   1248: invokevirtual booleanValue : ()Z
/*     */     //   1251: ifeq -> 3229
/*     */     //   1254: aload_3
/*     */     //   1255: invokevirtual getMinCPS : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1258: bipush #11
/*     */     //   1260: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1263: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1266: aload_3
/*     */     //   1267: invokevirtual getMaxCPS : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1270: bipush #14
/*     */     //   1272: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1275: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1278: goto -> 3229
/*     */     //   1281: aload_0
/*     */     //   1282: getfield velocityInput : Z
/*     */     //   1285: ifeq -> 1488
/*     */     //   1288: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1291: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1296: dup
/*     */     //   1297: ifnonnull -> 1303
/*     */     //   1300: invokestatic throwNpe : ()V
/*     */     //   1303: invokeinterface getOnGround : ()Z
/*     */     //   1308: ifeq -> 1414
/*     */     //   1311: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1314: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1319: dup
/*     */     //   1320: ifnonnull -> 1326
/*     */     //   1323: invokestatic throwNpe : ()V
/*     */     //   1326: invokeinterface getHurtTime : ()I
/*     */     //   1331: bipush #9
/*     */     //   1333: if_icmpne -> 1414
/*     */     //   1336: aload_0
/*     */     //   1337: getfield jumped : I
/*     */     //   1340: iconst_2
/*     */     //   1341: if_icmple -> 1352
/*     */     //   1344: aload_0
/*     */     //   1345: iconst_0
/*     */     //   1346: putfield jumped : I
/*     */     //   1349: goto -> 1488
/*     */     //   1352: aload_0
/*     */     //   1353: dup
/*     */     //   1354: dup
/*     */     //   1355: getfield jumped : I
/*     */     //   1358: iconst_1
/*     */     //   1359: iadd
/*     */     //   1360: putfield jumped : I
/*     */     //   1363: getfield jumped : I
/*     */     //   1366: pop
/*     */     //   1367: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1370: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1375: dup
/*     */     //   1376: ifnonnull -> 1382
/*     */     //   1379: invokestatic throwNpe : ()V
/*     */     //   1382: invokeinterface getTicksExisted : ()I
/*     */     //   1387: iconst_5
/*     */     //   1388: irem
/*     */     //   1389: ifeq -> 1411
/*     */     //   1392: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1395: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1400: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1405: iconst_1
/*     */     //   1406: invokeinterface setPressed : (Z)V
/*     */     //   1411: goto -> 1488
/*     */     //   1414: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1417: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1422: dup
/*     */     //   1423: ifnonnull -> 1429
/*     */     //   1426: invokestatic throwNpe : ()V
/*     */     //   1429: invokeinterface getHurtTime : ()I
/*     */     //   1434: bipush #8
/*     */     //   1436: if_icmpne -> 1488
/*     */     //   1439: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1442: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1447: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1452: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1455: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1460: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1463: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1468: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1473: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   1478: invokeinterface setPressed : (Z)V
/*     */     //   1483: aload_0
/*     */     //   1484: iconst_0
/*     */     //   1485: putfield velocityInput : Z
/*     */     //   1488: aload_0
/*     */     //   1489: getfield velocityInput2 : Z
/*     */     //   1492: ifeq -> 1626
/*     */     //   1495: aload_0
/*     */     //   1496: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1499: aload_0
/*     */     //   1500: getfield msValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1503: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1506: checkcast java/lang/Number
/*     */     //   1509: invokevirtual floatValue : ()F
/*     */     //   1512: f2l
/*     */     //   1513: invokevirtual hasTimePassed : (J)Z
/*     */     //   1516: ifeq -> 1626
/*     */     //   1519: aload_0
/*     */     //   1520: getfield doinrange : Z
/*     */     //   1523: ifne -> 1543
/*     */     //   1526: aload_0
/*     */     //   1527: getfield onlyinRange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1530: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1533: checkcast java/lang/Boolean
/*     */     //   1536: invokevirtual booleanValue : ()Z
/*     */     //   1539: ifeq -> 1543
/*     */     //   1542: return
/*     */     //   1543: aload_2
/*     */     //   1544: dup
/*     */     //   1545: invokeinterface getMotionX : ()D
/*     */     //   1550: aload_0
/*     */     //   1551: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1554: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1557: checkcast java/lang/Number
/*     */     //   1560: invokevirtual doubleValue : ()D
/*     */     //   1563: dmul
/*     */     //   1564: invokeinterface setMotionX : (D)V
/*     */     //   1569: aload_2
/*     */     //   1570: dup
/*     */     //   1571: invokeinterface getMotionZ : ()D
/*     */     //   1576: aload_0
/*     */     //   1577: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1580: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1583: checkcast java/lang/Number
/*     */     //   1586: invokevirtual doubleValue : ()D
/*     */     //   1589: dmul
/*     */     //   1590: invokeinterface setMotionZ : (D)V
/*     */     //   1595: aload_2
/*     */     //   1596: dup
/*     */     //   1597: invokeinterface getMotionY : ()D
/*     */     //   1602: aload_0
/*     */     //   1603: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1606: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1609: checkcast java/lang/Number
/*     */     //   1612: invokevirtual doubleValue : ()D
/*     */     //   1615: dmul
/*     */     //   1616: invokeinterface setMotionY : (D)V
/*     */     //   1621: aload_0
/*     */     //   1622: iconst_0
/*     */     //   1623: putfield velocityInput2 : Z
/*     */     //   1626: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1629: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1634: dup
/*     */     //   1635: ifnonnull -> 1641
/*     */     //   1638: invokestatic throwNpe : ()V
/*     */     //   1641: invokeinterface getHurtTime : ()I
/*     */     //   1646: ifle -> 1760
/*     */     //   1649: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1652: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1657: dup
/*     */     //   1658: ifnonnull -> 1664
/*     */     //   1661: invokestatic throwNpe : ()V
/*     */     //   1664: dup
/*     */     //   1665: invokeinterface getMotionX : ()D
/*     */     //   1670: ldc2_w -1.0E-7
/*     */     //   1673: dadd
/*     */     //   1674: invokeinterface setMotionX : (D)V
/*     */     //   1679: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1682: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1687: dup
/*     */     //   1688: ifnonnull -> 1694
/*     */     //   1691: invokestatic throwNpe : ()V
/*     */     //   1694: dup
/*     */     //   1695: invokeinterface getMotionY : ()D
/*     */     //   1700: ldc2_w -1.0E-7
/*     */     //   1703: dadd
/*     */     //   1704: invokeinterface setMotionY : (D)V
/*     */     //   1709: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1712: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1717: dup
/*     */     //   1718: ifnonnull -> 1724
/*     */     //   1721: invokestatic throwNpe : ()V
/*     */     //   1724: dup
/*     */     //   1725: invokeinterface getMotionZ : ()D
/*     */     //   1730: ldc2_w -1.0E-7
/*     */     //   1733: dadd
/*     */     //   1734: invokeinterface setMotionZ : (D)V
/*     */     //   1739: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1742: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1747: dup
/*     */     //   1748: ifnonnull -> 1754
/*     */     //   1751: invokestatic throwNpe : ()V
/*     */     //   1754: iconst_1
/*     */     //   1755: invokeinterface setAirBorne : (Z)V
/*     */     //   1760: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1763: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1768: dup
/*     */     //   1769: ifnonnull -> 1775
/*     */     //   1772: invokestatic throwNpe : ()V
/*     */     //   1775: invokeinterface getOnGround : ()Z
/*     */     //   1780: ifne -> 1946
/*     */     //   1783: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1786: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1791: dup
/*     */     //   1792: ifnonnull -> 1798
/*     */     //   1795: invokestatic throwNpe : ()V
/*     */     //   1798: invokeinterface getHurtTime : ()I
/*     */     //   1803: ifle -> 1946
/*     */     //   1806: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1809: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1814: dup
/*     */     //   1815: ifnonnull -> 1821
/*     */     //   1818: invokestatic throwNpe : ()V
/*     */     //   1821: invokeinterface getHurtTime : ()I
/*     */     //   1826: iconst_5
/*     */     //   1827: if_icmpgt -> 1946
/*     */     //   1830: aload_0
/*     */     //   1831: getfield velocityInput3 : Z
/*     */     //   1834: ifeq -> 1946
/*     */     //   1837: aload_0
/*     */     //   1838: getfield doinrange : Z
/*     */     //   1841: ifne -> 1861
/*     */     //   1844: aload_0
/*     */     //   1845: getfield onlyinRange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1848: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1851: checkcast java/lang/Boolean
/*     */     //   1854: invokevirtual booleanValue : ()Z
/*     */     //   1857: ifeq -> 1861
/*     */     //   1860: return
/*     */     //   1861: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1864: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1869: dup
/*     */     //   1870: ifnonnull -> 1876
/*     */     //   1873: invokestatic throwNpe : ()V
/*     */     //   1876: dup
/*     */     //   1877: invokeinterface getMotionX : ()D
/*     */     //   1882: aload_0
/*     */     //   1883: getfield airReducerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1886: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1889: checkcast java/lang/Number
/*     */     //   1892: invokevirtual doubleValue : ()D
/*     */     //   1895: dmul
/*     */     //   1896: invokeinterface setMotionX : (D)V
/*     */     //   1901: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1904: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1909: dup
/*     */     //   1910: ifnonnull -> 1916
/*     */     //   1913: invokestatic throwNpe : ()V
/*     */     //   1916: dup
/*     */     //   1917: invokeinterface getMotionZ : ()D
/*     */     //   1922: aload_0
/*     */     //   1923: getfield airReducerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1926: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1929: checkcast java/lang/Number
/*     */     //   1932: invokevirtual doubleValue : ()D
/*     */     //   1935: dmul
/*     */     //   1936: invokeinterface setMotionZ : (D)V
/*     */     //   1941: aload_0
/*     */     //   1942: iconst_0
/*     */     //   1943: putfield velocityInput3 : Z
/*     */     //   1946: aload_0
/*     */     //   1947: getfield legitPush : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1950: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1953: checkcast java/lang/Boolean
/*     */     //   1956: invokevirtual booleanValue : ()Z
/*     */     //   1959: ifne -> 1963
/*     */     //   1962: return
/*     */     //   1963: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1966: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1971: dup
/*     */     //   1972: ifnonnull -> 1978
/*     */     //   1975: invokestatic throwNpe : ()V
/*     */     //   1978: invokeinterface getOnGround : ()Z
/*     */     //   1983: ifeq -> 2060
/*     */     //   1986: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1989: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1994: dup
/*     */     //   1995: ifnonnull -> 2001
/*     */     //   1998: invokestatic throwNpe : ()V
/*     */     //   2001: invokeinterface getHurtTime : ()I
/*     */     //   2006: ifne -> 2060
/*     */     //   2009: aload_0
/*     */     //   2010: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2013: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2018: dup
/*     */     //   2019: ifnonnull -> 2025
/*     */     //   2022: invokestatic throwNpe : ()V
/*     */     //   2025: invokeinterface getPosX : ()D
/*     */     //   2030: putfield x : D
/*     */     //   2033: aload_0
/*     */     //   2034: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2037: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2042: dup
/*     */     //   2043: ifnonnull -> 2049
/*     */     //   2046: invokestatic throwNpe : ()V
/*     */     //   2049: invokeinterface getPosZ : ()D
/*     */     //   2054: putfield z : D
/*     */     //   2057: goto -> 2170
/*     */     //   2060: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2063: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2068: dup
/*     */     //   2069: ifnonnull -> 2075
/*     */     //   2072: invokestatic throwNpe : ()V
/*     */     //   2075: invokeinterface getOnGround : ()Z
/*     */     //   2080: ifne -> 2170
/*     */     //   2083: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2086: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2091: dup
/*     */     //   2092: ifnonnull -> 2098
/*     */     //   2095: invokestatic throwNpe : ()V
/*     */     //   2098: invokeinterface getHurtTime : ()I
/*     */     //   2103: iconst_5
/*     */     //   2104: if_icmpne -> 2170
/*     */     //   2107: aload_0
/*     */     //   2108: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2111: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2116: dup
/*     */     //   2117: ifnonnull -> 2123
/*     */     //   2120: invokestatic throwNpe : ()V
/*     */     //   2123: invokeinterface getPosX : ()D
/*     */     //   2128: aload_0
/*     */     //   2129: getfield x : D
/*     */     //   2132: dsub
/*     */     //   2133: putfield d1 : D
/*     */     //   2136: aload_0
/*     */     //   2137: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2140: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2145: dup
/*     */     //   2146: ifnonnull -> 2152
/*     */     //   2149: invokestatic throwNpe : ()V
/*     */     //   2152: invokeinterface getPosZ : ()D
/*     */     //   2157: aload_0
/*     */     //   2158: getfield z : D
/*     */     //   2161: dsub
/*     */     //   2162: putfield d2 : D
/*     */     //   2165: aload_0
/*     */     //   2166: iconst_5
/*     */     //   2167: putfield pushtick : I
/*     */     //   2170: aload_0
/*     */     //   2171: getfield doinrange : Z
/*     */     //   2174: ifne -> 2194
/*     */     //   2177: aload_0
/*     */     //   2178: getfield onlyinRange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   2181: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2184: checkcast java/lang/Boolean
/*     */     //   2187: invokevirtual booleanValue : ()Z
/*     */     //   2190: ifeq -> 2194
/*     */     //   2193: return
/*     */     //   2194: aload_0
/*     */     //   2195: getfield pushtick : I
/*     */     //   2198: ifle -> 3229
/*     */     //   2201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2204: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2209: dup
/*     */     //   2210: ifnonnull -> 2216
/*     */     //   2213: invokestatic throwNpe : ()V
/*     */     //   2216: dup
/*     */     //   2217: invokeinterface getMotionX : ()D
/*     */     //   2222: aload_0
/*     */     //   2223: getfield d1 : D
/*     */     //   2226: aload_0
/*     */     //   2227: getfield pushValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2230: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2233: checkcast java/lang/Number
/*     */     //   2236: invokevirtual doubleValue : ()D
/*     */     //   2239: dmul
/*     */     //   2240: dsub
/*     */     //   2241: invokeinterface setMotionX : (D)V
/*     */     //   2246: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2249: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2254: dup
/*     */     //   2255: ifnonnull -> 2261
/*     */     //   2258: invokestatic throwNpe : ()V
/*     */     //   2261: dup
/*     */     //   2262: invokeinterface getMotionZ : ()D
/*     */     //   2267: aload_0
/*     */     //   2268: getfield d2 : D
/*     */     //   2271: aload_0
/*     */     //   2272: getfield pushValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2275: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2278: checkcast java/lang/Number
/*     */     //   2281: invokevirtual doubleValue : ()D
/*     */     //   2284: dmul
/*     */     //   2285: dsub
/*     */     //   2286: invokeinterface setMotionZ : (D)V
/*     */     //   2291: aload_0
/*     */     //   2292: dup
/*     */     //   2293: getfield pushtick : I
/*     */     //   2296: dup
/*     */     //   2297: istore #5
/*     */     //   2299: iconst_m1
/*     */     //   2300: iadd
/*     */     //   2301: putfield pushtick : I
/*     */     //   2304: goto -> 3229
/*     */     //   2307: aload_0
/*     */     //   2308: getfield velocityInput : Z
/*     */     //   2311: ifeq -> 3229
/*     */     //   2314: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2317: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2322: dup
/*     */     //   2323: ifnonnull -> 2329
/*     */     //   2326: invokestatic throwNpe : ()V
/*     */     //   2329: invokeinterface getOnGround : ()Z
/*     */     //   2334: ifeq -> 2474
/*     */     //   2337: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2340: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2345: dup
/*     */     //   2346: ifnonnull -> 2352
/*     */     //   2349: invokestatic throwNpe : ()V
/*     */     //   2352: invokeinterface getHurtTime : ()I
/*     */     //   2357: bipush #9
/*     */     //   2359: if_icmpne -> 2474
/*     */     //   2362: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2365: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2370: dup
/*     */     //   2371: ifnonnull -> 2377
/*     */     //   2374: invokestatic throwNpe : ()V
/*     */     //   2377: invokeinterface getSprinting : ()Z
/*     */     //   2382: ifeq -> 2474
/*     */     //   2385: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2388: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   2393: ifnonnull -> 2474
/*     */     //   2396: aload_0
/*     */     //   2397: getfield jumped : I
/*     */     //   2400: iconst_2
/*     */     //   2401: if_icmple -> 2412
/*     */     //   2404: aload_0
/*     */     //   2405: iconst_0
/*     */     //   2406: putfield jumped : I
/*     */     //   2409: goto -> 3229
/*     */     //   2412: aload_0
/*     */     //   2413: dup
/*     */     //   2414: dup
/*     */     //   2415: getfield jumped : I
/*     */     //   2418: iconst_1
/*     */     //   2419: iadd
/*     */     //   2420: putfield jumped : I
/*     */     //   2423: getfield jumped : I
/*     */     //   2426: pop
/*     */     //   2427: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2430: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2435: dup
/*     */     //   2436: ifnonnull -> 2442
/*     */     //   2439: invokestatic throwNpe : ()V
/*     */     //   2442: invokeinterface getTicksExisted : ()I
/*     */     //   2447: iconst_5
/*     */     //   2448: irem
/*     */     //   2449: ifeq -> 2471
/*     */     //   2452: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2455: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2460: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2465: iconst_1
/*     */     //   2466: invokeinterface setPressed : (Z)V
/*     */     //   2471: goto -> 3229
/*     */     //   2474: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2477: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2482: dup
/*     */     //   2483: ifnonnull -> 2489
/*     */     //   2486: invokestatic throwNpe : ()V
/*     */     //   2489: invokeinterface getHurtTime : ()I
/*     */     //   2494: bipush #8
/*     */     //   2496: if_icmpne -> 2548
/*     */     //   2499: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2502: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2507: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2512: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2515: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2520: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2523: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2528: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2533: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   2538: invokeinterface setPressed : (Z)V
/*     */     //   2543: aload_0
/*     */     //   2544: iconst_0
/*     */     //   2545: putfield velocityInput : Z
/*     */     //   2548: goto -> 3229
/*     */     //   2551: aload_2
/*     */     //   2552: aload_0
/*     */     //   2553: getfield velocityInput : Z
/*     */     //   2556: invokeinterface setNoClip : (Z)V
/*     */     //   2561: aload_2
/*     */     //   2562: invokeinterface getHurtTime : ()I
/*     */     //   2567: bipush #7
/*     */     //   2569: if_icmpne -> 2581
/*     */     //   2572: aload_2
/*     */     //   2573: ldc2_w 0.4
/*     */     //   2576: invokeinterface setMotionY : (D)V
/*     */     //   2581: aload_0
/*     */     //   2582: iconst_0
/*     */     //   2583: putfield velocityInput : Z
/*     */     //   2586: goto -> 3229
/*     */     //   2589: aload_0
/*     */     //   2590: getfield velocityInput : Z
/*     */     //   2593: ifne -> 2597
/*     */     //   2596: return
/*     */     //   2597: aload_2
/*     */     //   2598: invokeinterface getOnGround : ()Z
/*     */     //   2603: ifne -> 2632
/*     */     //   2606: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*     */     //   2609: invokevirtual getSpeed : ()F
/*     */     //   2612: aload_0
/*     */     //   2613: getfield reverseStrengthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2616: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2619: checkcast java/lang/Number
/*     */     //   2622: invokevirtual floatValue : ()F
/*     */     //   2625: fmul
/*     */     //   2626: invokestatic strafe : (F)V
/*     */     //   2629: goto -> 3229
/*     */     //   2632: aload_0
/*     */     //   2633: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   2636: ldc2_w 80
/*     */     //   2639: invokevirtual hasTimePassed : (J)Z
/*     */     //   2642: ifeq -> 3229
/*     */     //   2645: aload_0
/*     */     //   2646: iconst_0
/*     */     //   2647: putfield velocityInput : Z
/*     */     //   2650: goto -> 3229
/*     */     //   2653: aload_0
/*     */     //   2654: getfield velocityInput : Z
/*     */     //   2657: ifne -> 2669
/*     */     //   2660: aload_2
/*     */     //   2661: ldc 0.02
/*     */     //   2663: invokeinterface setSpeedInAir : (F)V
/*     */     //   2668: return
/*     */     //   2669: aload_2
/*     */     //   2670: invokeinterface getHurtTime : ()I
/*     */     //   2675: ifle -> 2683
/*     */     //   2678: aload_0
/*     */     //   2679: iconst_1
/*     */     //   2680: putfield reverseHurt : Z
/*     */     //   2683: aload_2
/*     */     //   2684: invokeinterface getOnGround : ()Z
/*     */     //   2689: ifne -> 2721
/*     */     //   2692: aload_0
/*     */     //   2693: getfield reverseHurt : Z
/*     */     //   2696: ifeq -> 3229
/*     */     //   2699: aload_2
/*     */     //   2700: aload_0
/*     */     //   2701: getfield reverse2StrengthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2704: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2707: checkcast java/lang/Number
/*     */     //   2710: invokevirtual floatValue : ()F
/*     */     //   2713: invokeinterface setSpeedInAir : (F)V
/*     */     //   2718: goto -> 3229
/*     */     //   2721: aload_0
/*     */     //   2722: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   2725: ldc2_w 80
/*     */     //   2728: invokevirtual hasTimePassed : (J)Z
/*     */     //   2731: ifeq -> 2744
/*     */     //   2734: aload_0
/*     */     //   2735: iconst_0
/*     */     //   2736: putfield velocityInput : Z
/*     */     //   2739: aload_0
/*     */     //   2740: iconst_0
/*     */     //   2741: putfield reverseHurt : Z
/*     */     //   2744: goto -> 3229
/*     */     //   2747: aload_0
/*     */     //   2748: getfield velocityInput : Z
/*     */     //   2751: ifeq -> 3229
/*     */     //   2754: aload_0
/*     */     //   2755: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   2758: ldc2_w 80
/*     */     //   2761: invokevirtual hasTimePassed : (J)Z
/*     */     //   2764: ifeq -> 2845
/*     */     //   2767: aload_2
/*     */     //   2768: dup
/*     */     //   2769: invokeinterface getMotionX : ()D
/*     */     //   2774: aload_0
/*     */     //   2775: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2778: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2781: checkcast java/lang/Number
/*     */     //   2784: invokevirtual doubleValue : ()D
/*     */     //   2787: dmul
/*     */     //   2788: invokeinterface setMotionX : (D)V
/*     */     //   2793: aload_2
/*     */     //   2794: dup
/*     */     //   2795: invokeinterface getMotionZ : ()D
/*     */     //   2800: aload_0
/*     */     //   2801: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2804: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2807: checkcast java/lang/Number
/*     */     //   2810: invokevirtual doubleValue : ()D
/*     */     //   2813: dmul
/*     */     //   2814: invokeinterface setMotionZ : (D)V
/*     */     //   2819: aload_2
/*     */     //   2820: dup
/*     */     //   2821: invokeinterface getMotionY : ()D
/*     */     //   2826: aload_0
/*     */     //   2827: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2830: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2833: checkcast java/lang/Number
/*     */     //   2836: invokevirtual doubleValue : ()D
/*     */     //   2839: dmul
/*     */     //   2840: invokeinterface setMotionY : (D)V
/*     */     //   2845: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2848: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2853: dup
/*     */     //   2854: ifnonnull -> 2860
/*     */     //   2857: invokestatic throwNpe : ()V
/*     */     //   2860: invokeinterface getOnGround : ()Z
/*     */     //   2865: ifeq -> 2914
/*     */     //   2868: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2871: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2876: dup
/*     */     //   2877: ifnonnull -> 2883
/*     */     //   2880: invokestatic throwNpe : ()V
/*     */     //   2883: invokeinterface getSprinting : ()Z
/*     */     //   2888: ifeq -> 3025
/*     */     //   2891: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2894: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2899: dup
/*     */     //   2900: ifnonnull -> 2906
/*     */     //   2903: invokestatic throwNpe : ()V
/*     */     //   2906: invokeinterface jump : ()V
/*     */     //   2911: goto -> 3025
/*     */     //   2914: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2917: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2922: dup
/*     */     //   2923: ifnonnull -> 2929
/*     */     //   2926: invokestatic throwNpe : ()V
/*     */     //   2929: dup
/*     */     //   2930: invokeinterface getMotionX : ()D
/*     */     //   2935: ldc2_w -1.0E-7
/*     */     //   2938: dadd
/*     */     //   2939: invokeinterface setMotionX : (D)V
/*     */     //   2944: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2947: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2952: dup
/*     */     //   2953: ifnonnull -> 2959
/*     */     //   2956: invokestatic throwNpe : ()V
/*     */     //   2959: dup
/*     */     //   2960: invokeinterface getMotionY : ()D
/*     */     //   2965: ldc2_w -1.0E-7
/*     */     //   2968: dadd
/*     */     //   2969: invokeinterface setMotionY : (D)V
/*     */     //   2974: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2977: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   2982: dup
/*     */     //   2983: ifnonnull -> 2989
/*     */     //   2986: invokestatic throwNpe : ()V
/*     */     //   2989: dup
/*     */     //   2990: invokeinterface getMotionZ : ()D
/*     */     //   2995: ldc2_w -1.0E-7
/*     */     //   2998: dadd
/*     */     //   2999: invokeinterface setMotionZ : (D)V
/*     */     //   3004: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3007: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   3012: dup
/*     */     //   3013: ifnonnull -> 3019
/*     */     //   3016: invokestatic throwNpe : ()V
/*     */     //   3019: iconst_1
/*     */     //   3020: invokeinterface setAirBorne : (Z)V
/*     */     //   3025: aload_0
/*     */     //   3026: iconst_0
/*     */     //   3027: putfield velocityInput : Z
/*     */     //   3030: goto -> 3229
/*     */     //   3033: aload_0
/*     */     //   3034: getfield jump : Z
/*     */     //   3037: ifeq -> 3057
/*     */     //   3040: aload_2
/*     */     //   3041: invokeinterface getOnGround : ()Z
/*     */     //   3046: ifeq -> 3095
/*     */     //   3049: aload_0
/*     */     //   3050: iconst_0
/*     */     //   3051: putfield jump : Z
/*     */     //   3054: goto -> 3095
/*     */     //   3057: aload_2
/*     */     //   3058: invokeinterface getHurtTime : ()I
/*     */     //   3063: ifle -> 3095
/*     */     //   3066: aload_2
/*     */     //   3067: invokeinterface getMotionX : ()D
/*     */     //   3072: dconst_0
/*     */     //   3073: dcmpg
/*     */     //   3074: ifeq -> 3095
/*     */     //   3077: aload_2
/*     */     //   3078: invokeinterface getMotionZ : ()D
/*     */     //   3083: dconst_0
/*     */     //   3084: dcmpg
/*     */     //   3085: ifeq -> 3095
/*     */     //   3088: aload_2
/*     */     //   3089: iconst_1
/*     */     //   3090: invokeinterface setOnGround : (Z)V
/*     */     //   3095: aload_2
/*     */     //   3096: invokeinterface getHurtResistantTime : ()I
/*     */     //   3101: bipush #19
/*     */     //   3103: if_icmplt -> 3229
/*     */     //   3106: aload_0
/*     */     //   3107: getfield aacPushXZReducerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   3110: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   3113: checkcast java/lang/Number
/*     */     //   3116: invokevirtual floatValue : ()F
/*     */     //   3119: fstore #5
/*     */     //   3121: aload_2
/*     */     //   3122: dup
/*     */     //   3123: invokeinterface getMotionX : ()D
/*     */     //   3128: fload #5
/*     */     //   3130: f2d
/*     */     //   3131: ddiv
/*     */     //   3132: invokeinterface setMotionX : (D)V
/*     */     //   3137: aload_2
/*     */     //   3138: dup
/*     */     //   3139: invokeinterface getMotionZ : ()D
/*     */     //   3144: fload #5
/*     */     //   3146: f2d
/*     */     //   3147: ddiv
/*     */     //   3148: invokeinterface setMotionZ : (D)V
/*     */     //   3153: goto -> 3229
/*     */     //   3156: aload_2
/*     */     //   3157: invokeinterface getHurtTime : ()I
/*     */     //   3162: ifle -> 3224
/*     */     //   3165: aload_0
/*     */     //   3166: getfield velocityInput : Z
/*     */     //   3169: ifeq -> 3192
/*     */     //   3172: aload_2
/*     */     //   3173: invokeinterface getOnGround : ()Z
/*     */     //   3178: ifne -> 3192
/*     */     //   3181: aload_2
/*     */     //   3182: invokeinterface getFallDistance : ()F
/*     */     //   3187: fconst_2
/*     */     //   3188: fcmpl
/*     */     //   3189: ifle -> 3193
/*     */     //   3192: return
/*     */     //   3193: aload_2
/*     */     //   3194: dup
/*     */     //   3195: invokeinterface getMotionY : ()D
/*     */     //   3200: dconst_1
/*     */     //   3201: dsub
/*     */     //   3202: invokeinterface setMotionY : (D)V
/*     */     //   3207: aload_2
/*     */     //   3208: iconst_1
/*     */     //   3209: invokeinterface setAirBorne : (Z)V
/*     */     //   3214: aload_2
/*     */     //   3215: iconst_1
/*     */     //   3216: invokeinterface setOnGround : (Z)V
/*     */     //   3221: goto -> 3229
/*     */     //   3224: aload_0
/*     */     //   3225: iconst_0
/*     */     //   3226: putfield velocityInput : Z
/*     */     //   3229: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #180	-> 6
/*     */     //   #180	-> 21
/*     */     //   #181	-> 24
/*     */     //   #183	-> 55
/*     */     //   #184	-> 96
/*     */     //   #186	-> 140
/*     */     //   #187	-> 167
/*     */     //   #188	-> 168
/*     */     //   #189	-> 217
/*     */     //   #191	-> 217
/*     */     //   #189	-> 217
/*     */     //   #568	-> 224
/*     */     //   #189	-> 283
/*     */     //   #190	-> 301
/*     */     //   #189	-> 303
/*     */     //   #191	-> 306
/*     */     //   #193	-> 323
/*     */     //   #195	-> 331
/*     */     //   #196	-> 336
/*     */     //   #188	-> 336
/*     */     //   #198	-> 339
/*     */     //   #215	-> 484
/*     */     //   #352	-> 498
/*     */     //   #315	-> 512
/*     */     //   #386	-> 526
/*     */     //   #368	-> 540
/*     */     //   #324	-> 554
/*     */     //   #208	-> 568
/*     */     //   #245	-> 582
/*     */     //   #200	-> 595
/*     */     //   #299	-> 609
/*     */     //   #334	-> 622
/*     */     //   #200	-> 636
/*     */     //   #201	-> 654
/*     */     //   #203	-> 663
/*     */     //   #205	-> 675
/*     */     //   #205	-> 705
/*     */     //   #206	-> 715
/*     */     //   #206	-> 745
/*     */     //   #208	-> 758
/*     */     //   #209	-> 787
/*     */     //   #210	-> 827
/*     */     //   #211	-> 867
/*     */     //   #213	-> 875
/*     */     //   #217	-> 883
/*     */     //   #218	-> 890
/*     */     //   #219	-> 938
/*     */     //   #220	-> 946
/*     */     //   #222	-> 954
/*     */     //   #223	-> 969
/*     */     //   #224	-> 1013
/*     */     //   #225	-> 1016
/*     */     //   #226	-> 1041
/*     */     //   #227	-> 1085
/*     */     //   #228	-> 1090
/*     */     //   #229	-> 1090
/*     */     //   #230	-> 1097
/*     */     //   #231	-> 1150
/*     */     //   #232	-> 1180
/*     */     //   #234	-> 1210
/*     */     //   #237	-> 1215
/*     */     //   #239	-> 1238
/*     */     //   #240	-> 1254
/*     */     //   #241	-> 1266
/*     */     //   #247	-> 1281
/*     */     //   #248	-> 1288
/*     */     //   #249	-> 1336
/*     */     //   #250	-> 1344
/*     */     //   #252	-> 1352
/*     */     //   #253	-> 1367
/*     */     //   #254	-> 1411
/*     */     //   #255	-> 1414
/*     */     //   #256	-> 1439
/*     */     //   #257	-> 1483
/*     */     //   #258	-> 1488
/*     */     //   #261	-> 1488
/*     */     //   #262	-> 1519
/*     */     //   #263	-> 1543
/*     */     //   #264	-> 1569
/*     */     //   #265	-> 1595
/*     */     //   #266	-> 1621
/*     */     //   #269	-> 1626
/*     */     //   #270	-> 1649
/*     */     //   #271	-> 1679
/*     */     //   #272	-> 1709
/*     */     //   #273	-> 1739
/*     */     //   #276	-> 1760
/*     */     //   #277	-> 1837
/*     */     //   #278	-> 1861
/*     */     //   #279	-> 1901
/*     */     //   #280	-> 1941
/*     */     //   #283	-> 1946
/*     */     //   #284	-> 1963
/*     */     //   #285	-> 2009
/*     */     //   #286	-> 2033
/*     */     //   #287	-> 2060
/*     */     //   #288	-> 2107
/*     */     //   #289	-> 2136
/*     */     //   #290	-> 2165
/*     */     //   #291	-> 2170
/*     */     //   #292	-> 2170
/*     */     //   #293	-> 2194
/*     */     //   #294	-> 2201
/*     */     //   #295	-> 2246
/*     */     //   #296	-> 2291
/*     */     //   #301	-> 2307
/*     */     //   #302	-> 2314
/*     */     //   #303	-> 2396
/*     */     //   #304	-> 2404
/*     */     //   #306	-> 2412
/*     */     //   #307	-> 2427
/*     */     //   #308	-> 2471
/*     */     //   #309	-> 2474
/*     */     //   #310	-> 2499
/*     */     //   #311	-> 2543
/*     */     //   #312	-> 2548
/*     */     //   #316	-> 2551
/*     */     //   #318	-> 2561
/*     */     //   #319	-> 2572
/*     */     //   #321	-> 2581
/*     */     //   #325	-> 2589
/*     */     //   #326	-> 2596
/*     */     //   #328	-> 2597
/*     */     //   #329	-> 2606
/*     */     //   #330	-> 2632
/*     */     //   #331	-> 2645
/*     */     //   #335	-> 2653
/*     */     //   #336	-> 2660
/*     */     //   #337	-> 2668
/*     */     //   #340	-> 2669
/*     */     //   #341	-> 2678
/*     */     //   #343	-> 2683
/*     */     //   #344	-> 2692
/*     */     //   #345	-> 2699
/*     */     //   #346	-> 2721
/*     */     //   #347	-> 2734
/*     */     //   #348	-> 2739
/*     */     //   #349	-> 2744
/*     */     //   #352	-> 2747
/*     */     //   #353	-> 2754
/*     */     //   #354	-> 2767
/*     */     //   #355	-> 2793
/*     */     //   #356	-> 2819
/*     */     //   #358	-> 2845
/*     */     //   #360	-> 2914
/*     */     //   #361	-> 2944
/*     */     //   #362	-> 2974
/*     */     //   #363	-> 3004
/*     */     //   #364	-> 3025
/*     */     //   #365	-> 3025
/*     */     //   #369	-> 3033
/*     */     //   #370	-> 3040
/*     */     //   #371	-> 3049
/*     */     //   #374	-> 3057
/*     */     //   #375	-> 3088
/*     */     //   #376	-> 3095
/*     */     //   #379	-> 3095
/*     */     //   #380	-> 3106
/*     */     //   #382	-> 3121
/*     */     //   #383	-> 3137
/*     */     //   #386	-> 3156
/*     */     //   #387	-> 3165
/*     */     //   #388	-> 3192
/*     */     //   #390	-> 3193
/*     */     //   #391	-> 3207
/*     */     //   #392	-> 3214
/*     */     //   #394	-> 3224
/*     */     //   #395	-> 3229
/*     */     //   #396	-> 3229
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   221	26	6	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   224	23	7	$i$f$unwrap	I
/*     */     //   217	119	4	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   675	80	5	yaw	F
/*     */     //   3121	32	5	reduce	F
/*     */     //   55	3175	3	aura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   24	3206	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	3230	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/CatVelocity;
/*     */     //   0	3230	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*     */   }
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 23
/*     */     //   21: pop
/*     */     //   22: return
/*     */     //   23: astore_2
/*     */     //   24: aload_1
/*     */     //   25: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   28: astore_3
/*     */     //   29: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   32: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   35: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   38: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   41: dup
/*     */     //   42: ifnonnull -> 56
/*     */     //   45: new kotlin/TypeCastException
/*     */     //   48: dup
/*     */     //   49: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   52: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   55: athrow
/*     */     //   56: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   59: astore #4
/*     */     //   61: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   64: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   67: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/Silentmode
/*     */     //   70: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   73: dup
/*     */     //   74: ifnonnull -> 88
/*     */     //   77: new kotlin/TypeCastException
/*     */     //   80: dup
/*     */     //   81: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Silentmode'
/*     */     //   84: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   87: athrow
/*     */     //   88: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/Silentmode
/*     */     //   91: astore #5
/*     */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   96: aload_3
/*     */     //   97: invokeinterface isSPacketEntityVelocity : (Ljava/lang/Object;)Z
/*     */     //   102: ifeq -> 1700
/*     */     //   105: aload_3
/*     */     //   106: invokeinterface asSPacketEntityVelocity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   111: astore #6
/*     */     //   113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   116: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   121: dup
/*     */     //   122: ifnull -> 144
/*     */     //   125: aload #6
/*     */     //   127: invokeinterface getEntityID : ()I
/*     */     //   132: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   137: dup
/*     */     //   138: ifnull -> 144
/*     */     //   141: goto -> 146
/*     */     //   144: pop
/*     */     //   145: return
/*     */     //   146: aload_2
/*     */     //   147: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   150: iconst_1
/*     */     //   151: ixor
/*     */     //   152: ifeq -> 156
/*     */     //   155: return
/*     */     //   156: aload_0
/*     */     //   157: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   160: invokevirtual reset : ()V
/*     */     //   163: aload_0
/*     */     //   164: getfield wtapreduce : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   167: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   170: checkcast java/lang/Boolean
/*     */     //   173: invokevirtual booleanValue : ()Z
/*     */     //   176: ifeq -> 198
/*     */     //   179: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   182: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   187: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   192: iconst_0
/*     */     //   193: invokeinterface setPressed : (Z)V
/*     */     //   198: aload_0
/*     */     //   199: getfield stapreduce : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   202: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   205: checkcast java/lang/Boolean
/*     */     //   208: invokevirtual booleanValue : ()Z
/*     */     //   211: ifeq -> 235
/*     */     //   214: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   217: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   222: dup
/*     */     //   223: ifnonnull -> 229
/*     */     //   226: invokestatic throwNpe : ()V
/*     */     //   229: iconst_0
/*     */     //   230: invokeinterface setSprinting : (Z)V
/*     */     //   235: aload_0
/*     */     //   236: getfield attackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   239: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   242: checkcast java/lang/Boolean
/*     */     //   245: invokevirtual booleanValue : ()Z
/*     */     //   248: ifeq -> 449
/*     */     //   251: aload #4
/*     */     //   253: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   256: ifnull -> 449
/*     */     //   259: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   262: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   267: dup
/*     */     //   268: ifnonnull -> 274
/*     */     //   271: invokestatic throwNpe : ()V
/*     */     //   274: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   277: aload #4
/*     */     //   279: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   282: dup
/*     */     //   283: ifnonnull -> 289
/*     */     //   286: invokestatic throwNpe : ()V
/*     */     //   289: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   292: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   295: ldc2_w 3.01
/*     */     //   298: dcmpg
/*     */     //   299: ifgt -> 449
/*     */     //   302: aload #5
/*     */     //   304: invokevirtual getState : ()Z
/*     */     //   307: ifne -> 449
/*     */     //   310: aload_0
/*     */     //   311: getfield attacktimes : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   314: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   317: checkcast java/lang/Number
/*     */     //   320: invokevirtual intValue : ()I
/*     */     //   323: istore #7
/*     */     //   325: iconst_0
/*     */     //   326: istore #8
/*     */     //   328: iconst_0
/*     */     //   329: istore #9
/*     */     //   331: iconst_0
/*     */     //   332: istore #9
/*     */     //   334: iload #7
/*     */     //   336: istore #10
/*     */     //   338: iload #9
/*     */     //   340: iload #10
/*     */     //   342: if_icmpge -> 449
/*     */     //   345: iload #9
/*     */     //   347: istore #11
/*     */     //   349: iconst_0
/*     */     //   350: istore #12
/*     */     //   352: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   355: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   360: dup
/*     */     //   361: ifnonnull -> 367
/*     */     //   364: invokestatic throwNpe : ()V
/*     */     //   367: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   372: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   375: aload #4
/*     */     //   377: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   380: dup
/*     */     //   381: ifnonnull -> 387
/*     */     //   384: invokestatic throwNpe : ()V
/*     */     //   387: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   390: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   393: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   398: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   401: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   406: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   409: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   414: dup
/*     */     //   415: ifnonnull -> 421
/*     */     //   418: invokestatic throwNpe : ()V
/*     */     //   421: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   426: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   429: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   434: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   437: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   442: nop
/*     */     //   443: iinc #9, 1
/*     */     //   446: goto -> 338
/*     */     //   449: aload_0
/*     */     //   450: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   453: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   456: checkcast java/lang/String
/*     */     //   459: astore #7
/*     */     //   461: iconst_0
/*     */     //   462: istore #8
/*     */     //   464: aload #7
/*     */     //   466: dup
/*     */     //   467: ifnonnull -> 480
/*     */     //   470: new kotlin/TypeCastException
/*     */     //   473: dup
/*     */     //   474: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   476: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   479: athrow
/*     */     //   480: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   483: dup
/*     */     //   484: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   486: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   489: astore #7
/*     */     //   491: aload #7
/*     */     //   493: invokevirtual hashCode : ()I
/*     */     //   496: lookupswitch default -> 1700, -1970553484 -> 699, -1243181771 -> 616, -1234264725 -> 630, -1202222792 -> 713, -902286926 -> 644, 96323 -> 602, 3387523 -> 588, 94750088 -> 672, 109549001 -> 686, 1099846370 -> 658
/*     */     //   588: aload #7
/*     */     //   590: ldc_w 'noxz'
/*     */     //   593: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   596: ifeq -> 1700
/*     */     //   599: goto -> 833
/*     */     //   602: aload #7
/*     */     //   604: ldc_w 'aac'
/*     */     //   607: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   610: ifeq -> 1700
/*     */     //   613: goto -> 1673
/*     */     //   616: aload #7
/*     */     //   618: ldc_w 'glitch'
/*     */     //   621: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   624: ifeq -> 1700
/*     */     //   627: goto -> 1681
/*     */     //   630: aload #7
/*     */     //   632: ldc_w 'aaczero'
/*     */     //   635: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   638: ifeq -> 1700
/*     */     //   641: goto -> 1673
/*     */     //   644: aload #7
/*     */     //   646: ldc_w 'simple'
/*     */     //   649: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   652: ifeq -> 1700
/*     */     //   655: goto -> 1583
/*     */     //   658: aload #7
/*     */     //   660: ldc_w 'reverse'
/*     */     //   663: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   666: ifeq -> 1700
/*     */     //   669: goto -> 1673
/*     */     //   672: aload #7
/*     */     //   674: ldc_w 'click'
/*     */     //   677: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   680: ifeq -> 1700
/*     */     //   683: goto -> 726
/*     */     //   686: aload #7
/*     */     //   688: ldc 'smart'
/*     */     //   690: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   693: ifeq -> 1700
/*     */     //   696: goto -> 1113
/*     */     //   699: aload #7
/*     */     //   701: ldc_w 'smoothreverse'
/*     */     //   704: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   707: ifeq -> 1700
/*     */     //   710: goto -> 1673
/*     */     //   713: aload #7
/*     */     //   715: ldc 'hytpit'
/*     */     //   717: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   720: ifeq -> 1700
/*     */     //   723: goto -> 1673
/*     */     //   726: aload #6
/*     */     //   728: invokeinterface getMotionX : ()I
/*     */     //   733: ifne -> 747
/*     */     //   736: aload #6
/*     */     //   738: invokeinterface getMotionZ : ()I
/*     */     //   743: ifne -> 747
/*     */     //   746: return
/*     */     //   747: aload_0
/*     */     //   748: aload_0
/*     */     //   749: getfield clickCount : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   752: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   755: checkcast java/lang/Number
/*     */     //   758: invokevirtual intValue : ()I
/*     */     //   761: aload_0
/*     */     //   762: getfield clickRange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   765: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   768: checkcast java/lang/Number
/*     */     //   771: invokevirtual floatValue : ()F
/*     */     //   774: f2d
/*     */     //   775: aload_0
/*     */     //   776: getfield clickOnPacket : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   779: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   782: checkcast java/lang/Boolean
/*     */     //   785: invokevirtual booleanValue : ()Z
/*     */     //   788: ifeq -> 818
/*     */     //   791: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   794: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   799: dup
/*     */     //   800: ifnonnull -> 806
/*     */     //   803: invokestatic throwNpe : ()V
/*     */     //   806: invokeinterface getSprinting : ()Z
/*     */     //   811: ifeq -> 818
/*     */     //   814: iconst_1
/*     */     //   815: goto -> 819
/*     */     //   818: iconst_0
/*     */     //   819: invokevirtual attackRayTrace : (IDZ)Z
/*     */     //   822: ifeq -> 1700
/*     */     //   825: aload_0
/*     */     //   826: iconst_1
/*     */     //   827: putfield velocityInput : Z
/*     */     //   830: goto -> 1700
/*     */     //   833: aload_0
/*     */     //   834: iconst_1
/*     */     //   835: putfield velocityInput : Z
/*     */     //   838: aload #4
/*     */     //   840: invokevirtual getState : ()Z
/*     */     //   843: ifeq -> 1700
/*     */     //   846: aload #4
/*     */     //   848: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   851: ifnull -> 1700
/*     */     //   854: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   857: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   862: dup
/*     */     //   863: ifnonnull -> 869
/*     */     //   866: invokestatic throwNpe : ()V
/*     */     //   869: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   872: aload #4
/*     */     //   874: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   877: dup
/*     */     //   878: ifnonnull -> 884
/*     */     //   881: invokestatic throwNpe : ()V
/*     */     //   884: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   887: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   890: ldc2_w 3.0
/*     */     //   893: dcmpg
/*     */     //   894: ifgt -> 1700
/*     */     //   897: aload_0
/*     */     //   898: getfield cpsbypass : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   901: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   904: checkcast java/lang/Boolean
/*     */     //   907: invokevirtual booleanValue : ()Z
/*     */     //   910: ifeq -> 939
/*     */     //   913: aload #4
/*     */     //   915: invokevirtual getMinCPS : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   918: bipush #8
/*     */     //   920: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   923: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   926: aload #4
/*     */     //   928: invokevirtual getMaxCPS : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   931: bipush #9
/*     */     //   933: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   936: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   939: bipush #6
/*     */     //   941: istore #8
/*     */     //   943: iconst_0
/*     */     //   944: istore #9
/*     */     //   946: iconst_0
/*     */     //   947: istore #10
/*     */     //   949: iconst_0
/*     */     //   950: istore #10
/*     */     //   952: iload #8
/*     */     //   954: istore #11
/*     */     //   956: iload #10
/*     */     //   958: iload #11
/*     */     //   960: if_icmpge -> 1105
/*     */     //   963: iload #10
/*     */     //   965: istore #12
/*     */     //   967: iconst_0
/*     */     //   968: istore #13
/*     */     //   970: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   973: dup
/*     */     //   974: ldc_w 'mc2'
/*     */     //   977: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   980: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   983: dup
/*     */     //   984: ifnonnull -> 990
/*     */     //   987: invokestatic throwNpe : ()V
/*     */     //   990: new net/minecraft/network/play/client/CPacketConfirmTransaction
/*     */     //   993: dup
/*     */     //   994: bipush #100
/*     */     //   996: bipush #100
/*     */     //   998: iconst_1
/*     */     //   999: invokespecial <init> : (ISZ)V
/*     */     //   1002: checkcast net/minecraft/network/Packet
/*     */     //   1005: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1008: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1011: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1016: dup
/*     */     //   1017: ifnonnull -> 1023
/*     */     //   1020: invokestatic throwNpe : ()V
/*     */     //   1023: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1028: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1031: aload #4
/*     */     //   1033: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   1036: dup
/*     */     //   1037: ifnonnull -> 1043
/*     */     //   1040: invokestatic throwNpe : ()V
/*     */     //   1043: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   1046: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   1049: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   1054: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1057: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1062: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1065: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1070: dup
/*     */     //   1071: ifnonnull -> 1077
/*     */     //   1074: invokestatic throwNpe : ()V
/*     */     //   1077: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1082: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1085: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   1090: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1093: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1098: nop
/*     */     //   1099: iinc #10, 1
/*     */     //   1102: goto -> 956
/*     */     //   1105: aload_0
/*     */     //   1106: iconst_1
/*     */     //   1107: putfield attack : Z
/*     */     //   1110: goto -> 1700
/*     */     //   1113: aload_0
/*     */     //   1114: iconst_1
/*     */     //   1115: putfield velocityInput : Z
/*     */     //   1118: aload_0
/*     */     //   1119: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1122: dup
/*     */     //   1123: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1126: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1131: dup
/*     */     //   1132: ifnonnull -> 1138
/*     */     //   1135: invokestatic throwNpe : ()V
/*     */     //   1138: invokeinterface getPosX : ()D
/*     */     //   1143: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1146: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1151: dup
/*     */     //   1152: ifnonnull -> 1158
/*     */     //   1155: invokestatic throwNpe : ()V
/*     */     //   1158: invokeinterface getPosY : ()D
/*     */     //   1163: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1166: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1171: dup
/*     */     //   1172: ifnonnull -> 1178
/*     */     //   1175: invokestatic throwNpe : ()V
/*     */     //   1178: invokeinterface getPosZ : ()D
/*     */     //   1183: invokespecial <init> : (DDD)V
/*     */     //   1186: putfield pos : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1189: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1192: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1197: dup
/*     */     //   1198: ifnonnull -> 1204
/*     */     //   1201: invokestatic throwNpe : ()V
/*     */     //   1204: invokeinterface getOnGround : ()Z
/*     */     //   1209: ifeq -> 1505
/*     */     //   1212: aload #6
/*     */     //   1214: invokeinterface getMotionX : ()I
/*     */     //   1219: sipush #3600
/*     */     //   1222: if_icmpgt -> 1505
/*     */     //   1225: aload #6
/*     */     //   1227: invokeinterface getMotionY : ()I
/*     */     //   1232: sipush #3600
/*     */     //   1235: if_icmpgt -> 1505
/*     */     //   1238: aload #6
/*     */     //   1240: invokeinterface getMotionZ : ()I
/*     */     //   1245: sipush #3600
/*     */     //   1248: if_icmpgt -> 1505
/*     */     //   1251: aload_0
/*     */     //   1252: getfield Auto : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1255: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1258: checkcast java/lang/Boolean
/*     */     //   1261: invokevirtual booleanValue : ()Z
/*     */     //   1264: ifeq -> 1500
/*     */     //   1267: aload #6
/*     */     //   1269: invokeinterface getMotionX : ()I
/*     */     //   1274: sipush #2800
/*     */     //   1277: if_icmpgt -> 1322
/*     */     //   1280: aload #6
/*     */     //   1282: invokeinterface getMotionY : ()I
/*     */     //   1287: sipush #2800
/*     */     //   1290: if_icmpgt -> 1322
/*     */     //   1293: aload #6
/*     */     //   1295: invokeinterface getMotionZ : ()I
/*     */     //   1300: sipush #2800
/*     */     //   1303: if_icmpgt -> 1322
/*     */     //   1306: aload_0
/*     */     //   1307: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1310: ldc_w 0.4
/*     */     //   1313: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1316: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1319: goto -> 1500
/*     */     //   1322: aload #6
/*     */     //   1324: invokeinterface getMotionX : ()I
/*     */     //   1329: sipush #3000
/*     */     //   1332: if_icmpgt -> 1377
/*     */     //   1335: aload #6
/*     */     //   1337: invokeinterface getMotionY : ()I
/*     */     //   1342: sipush #3000
/*     */     //   1345: if_icmpgt -> 1377
/*     */     //   1348: aload #6
/*     */     //   1350: invokeinterface getMotionZ : ()I
/*     */     //   1355: sipush #3000
/*     */     //   1358: if_icmpgt -> 1377
/*     */     //   1361: aload_0
/*     */     //   1362: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1365: ldc_w 0.55
/*     */     //   1368: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1371: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1374: goto -> 1500
/*     */     //   1377: aload #6
/*     */     //   1379: invokeinterface getMotionX : ()I
/*     */     //   1384: sipush #3200
/*     */     //   1387: if_icmpgt -> 1432
/*     */     //   1390: aload #6
/*     */     //   1392: invokeinterface getMotionY : ()I
/*     */     //   1397: sipush #3200
/*     */     //   1400: if_icmpgt -> 1432
/*     */     //   1403: aload #6
/*     */     //   1405: invokeinterface getMotionZ : ()I
/*     */     //   1410: sipush #3200
/*     */     //   1413: if_icmpgt -> 1432
/*     */     //   1416: aload_0
/*     */     //   1417: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1420: ldc_w 0.65
/*     */     //   1423: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1426: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1429: goto -> 1500
/*     */     //   1432: aload #6
/*     */     //   1434: invokeinterface getMotionX : ()I
/*     */     //   1439: sipush #3400
/*     */     //   1442: if_icmpgt -> 1487
/*     */     //   1445: aload #6
/*     */     //   1447: invokeinterface getMotionY : ()I
/*     */     //   1452: sipush #3400
/*     */     //   1455: if_icmpgt -> 1487
/*     */     //   1458: aload #6
/*     */     //   1460: invokeinterface getMotionZ : ()I
/*     */     //   1465: sipush #3400
/*     */     //   1468: if_icmpgt -> 1487
/*     */     //   1471: aload_0
/*     */     //   1472: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1475: ldc_w 0.74
/*     */     //   1478: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1481: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1484: goto -> 1500
/*     */     //   1487: aload_0
/*     */     //   1488: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1491: ldc_w 0.79
/*     */     //   1494: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1497: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1500: aload_0
/*     */     //   1501: iconst_1
/*     */     //   1502: putfield velocityInput2 : Z
/*     */     //   1505: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1508: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1513: dup
/*     */     //   1514: ifnonnull -> 1520
/*     */     //   1517: invokestatic throwNpe : ()V
/*     */     //   1520: invokeinterface getOnGround : ()Z
/*     */     //   1525: ifne -> 1700
/*     */     //   1528: aload #6
/*     */     //   1530: invokeinterface getMotionX : ()I
/*     */     //   1535: sipush #3100
/*     */     //   1538: if_icmpgt -> 1700
/*     */     //   1541: aload #6
/*     */     //   1543: invokeinterface getMotionY : ()I
/*     */     //   1548: sipush #3100
/*     */     //   1551: if_icmpgt -> 1700
/*     */     //   1554: aload #6
/*     */     //   1556: invokeinterface getMotionZ : ()I
/*     */     //   1561: sipush #3100
/*     */     //   1564: if_icmpgt -> 1700
/*     */     //   1567: aload #4
/*     */     //   1569: invokevirtual getState : ()Z
/*     */     //   1572: ifeq -> 1700
/*     */     //   1575: aload_0
/*     */     //   1576: iconst_1
/*     */     //   1577: putfield velocityInput3 : Z
/*     */     //   1580: goto -> 1700
/*     */     //   1583: aload_0
/*     */     //   1584: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1587: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1590: checkcast java/lang/Number
/*     */     //   1593: invokevirtual floatValue : ()F
/*     */     //   1596: fstore #8
/*     */     //   1598: aload_0
/*     */     //   1599: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1602: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1605: checkcast java/lang/Number
/*     */     //   1608: invokevirtual floatValue : ()F
/*     */     //   1611: fstore #9
/*     */     //   1613: aload #6
/*     */     //   1615: aload #6
/*     */     //   1617: invokeinterface getMotionX : ()I
/*     */     //   1622: i2f
/*     */     //   1623: fload #8
/*     */     //   1625: fmul
/*     */     //   1626: f2i
/*     */     //   1627: invokeinterface setMotionX : (I)V
/*     */     //   1632: aload #6
/*     */     //   1634: aload #6
/*     */     //   1636: invokeinterface getMotionY : ()I
/*     */     //   1641: i2f
/*     */     //   1642: fload #9
/*     */     //   1644: fmul
/*     */     //   1645: f2i
/*     */     //   1646: invokeinterface setMotionY : (I)V
/*     */     //   1651: aload #6
/*     */     //   1653: aload #6
/*     */     //   1655: invokeinterface getMotionZ : ()I
/*     */     //   1660: i2f
/*     */     //   1661: fload #8
/*     */     //   1663: fmul
/*     */     //   1664: f2i
/*     */     //   1665: invokeinterface setMotionZ : (I)V
/*     */     //   1670: goto -> 1700
/*     */     //   1673: aload_0
/*     */     //   1674: iconst_1
/*     */     //   1675: putfield velocityInput : Z
/*     */     //   1678: goto -> 1700
/*     */     //   1681: aload_2
/*     */     //   1682: invokeinterface getOnGround : ()Z
/*     */     //   1687: ifne -> 1691
/*     */     //   1690: return
/*     */     //   1691: aload_0
/*     */     //   1692: iconst_1
/*     */     //   1693: putfield velocityInput : Z
/*     */     //   1696: aload_1
/*     */     //   1697: invokevirtual cancelEvent : ()V
/*     */     //   1700: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #401	-> 6
/*     */     //   #401	-> 21
/*     */     //   #403	-> 24
/*     */     //   #404	-> 29
/*     */     //   #405	-> 61
/*     */     //   #407	-> 93
/*     */     //   #408	-> 105
/*     */     //   #410	-> 113
/*     */     //   #410	-> 144
/*     */     //   #411	-> 155
/*     */     //   #413	-> 156
/*     */     //   #415	-> 163
/*     */     //   #417	-> 198
/*     */     //   #418	-> 214
/*     */     //   #420	-> 235
/*     */     //   #421	-> 310
/*     */     //   #422	-> 352
/*     */     //   #423	-> 372
/*     */     //   #424	-> 375
/*     */     //   #425	-> 390
/*     */     //   #423	-> 393
/*     */     //   #422	-> 401
/*     */     //   #428	-> 406
/*     */     //   #429	-> 442
/*     */     //   #421	-> 443
/*     */     //   #432	-> 449
/*     */     //   #443	-> 588
/*     */     //   #493	-> 602
/*     */     //   #495	-> 616
/*     */     //   #493	-> 630
/*     */     //   #484	-> 644
/*     */     //   #493	-> 658
/*     */     //   #433	-> 672
/*     */     //   #463	-> 686
/*     */     //   #493	-> 699
/*     */     //   #434	-> 726
/*     */     //   #435	-> 747
/*     */     //   #436	-> 748
/*     */     //   #437	-> 761
/*     */     //   #438	-> 775
/*     */     //   #435	-> 819
/*     */     //   #441	-> 825
/*     */     //   #444	-> 833
/*     */     //   #445	-> 838
/*     */     //   #446	-> 897
/*     */     //   #447	-> 913
/*     */     //   #448	-> 926
/*     */     //   #450	-> 939
/*     */     //   #451	-> 970
/*     */     //   #452	-> 1008
/*     */     //   #453	-> 1028
/*     */     //   #454	-> 1031
/*     */     //   #455	-> 1046
/*     */     //   #453	-> 1049
/*     */     //   #452	-> 1057
/*     */     //   #458	-> 1062
/*     */     //   #459	-> 1098
/*     */     //   #450	-> 1099
/*     */     //   #460	-> 1105
/*     */     //   #464	-> 1113
/*     */     //   #465	-> 1118
/*     */     //   #466	-> 1189
/*     */     //   #467	-> 1251
/*     */     //   #468	-> 1267
/*     */     //   #469	-> 1306
/*     */     //   #470	-> 1322
/*     */     //   #471	-> 1361
/*     */     //   #472	-> 1377
/*     */     //   #473	-> 1416
/*     */     //   #474	-> 1432
/*     */     //   #475	-> 1471
/*     */     //   #477	-> 1487
/*     */     //   #478	-> 1500
/*     */     //   #480	-> 1500
/*     */     //   #482	-> 1505
/*     */     //   #485	-> 1583
/*     */     //   #486	-> 1598
/*     */     //   #488	-> 1613
/*     */     //   #489	-> 1632
/*     */     //   #490	-> 1651
/*     */     //   #493	-> 1673
/*     */     //   #496	-> 1681
/*     */     //   #497	-> 1690
/*     */     //   #499	-> 1691
/*     */     //   #500	-> 1696
/*     */     //   #502	-> 1700
/*     */     //   #504	-> 1700
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   349	93	11	it	I
/*     */     //   352	90	12	$i$a$-repeat-CatVelocity$onPacket$1	I
/*     */     //   967	131	12	it	I
/*     */     //   970	128	13	$i$a$-repeat-CatVelocity$onPacket$2	I
/*     */     //   1613	57	9	vertical	F
/*     */     //   1598	72	8	horizontal	F
/*     */     //   113	1587	6	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   93	1608	5	silentmode	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Silentmode;
/*     */     //   61	1640	4	aura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   29	1672	3	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   24	1677	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1701	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/CatVelocity;
/*     */     //   0	1701	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
/*     */   }
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
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 508 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 510 */     if (thePlayer == null || thePlayer.isInWater() || thePlayer.isInLava() || thePlayer.isInWeb()) {
/*     */       return;
/*     */     }
/* 513 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */       
/*     */       case -1234264725:
/* 518 */         if (str.equals("aaczero") && thePlayer.getHurtTime() > 0)
/* 519 */           event.cancelEvent();  break;
/*     */       case -1234547235:
/*     */         if (str.equals("aacpush"))
/*     */           this.jump = true; 
/*     */         break;
/* 524 */     }  } private final float getMoveYaw() { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float moveYaw = MinecraftInstance.mc.getThePlayer().getRotationYaw();
/* 525 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveForward() != 0.0F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveStrafing() == 0.0F)
/* 526 */       { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  moveYaw += ((MinecraftInstance.mc.getThePlayer().getMoveForward() > false) ? false : '´');
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
/* 537 */         return moveYaw; }  }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveForward() != 0.0F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveStrafing() != 0.0F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveForward() > false) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  moveYaw += ((MinecraftInstance.mc.getThePlayer().getMoveStrafing() > false) ? -45 : 45); } else { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  moveYaw -= ((MinecraftInstance.mc.getThePlayer().getMoveStrafing() > false) ? -45 : 45); }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  moveYaw += ((MinecraftInstance.mc.getThePlayer().getMoveForward() > false) ? false : '´'); return moveYaw; }  }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveStrafing() != 0.0F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMoveForward() == 0.0F) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  moveYaw += ((MinecraftInstance.mc.getThePlayer().getMoveStrafing() > false) ? -90 : 90); }  }  return moveYaw; }
/*     */   
/*     */   public final boolean attackRayTrace(int attack, double range, boolean doAttack) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: ifnonnull -> 13
/*     */     //   11: iconst_0
/*     */     //   12: ireturn
/*     */     //   13: dload_2
/*     */     //   14: iconst_1
/*     */     //   15: i2d
/*     */     //   16: dadd
/*     */     //   17: new net/ccbluex/liquidbounce/features/module/modules/retreat/CatVelocity$attackRayTrace$raycastedEntity$1
/*     */     //   20: dup
/*     */     //   21: invokespecial <init> : ()V
/*     */     //   24: checkcast net/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter
/*     */     //   27: invokestatic raycastEntity : (DLnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   30: astore #5
/*     */     //   32: aload #5
/*     */     //   34: dup
/*     */     //   35: ifnull -> 242
/*     */     //   38: astore #6
/*     */     //   40: iconst_0
/*     */     //   41: istore #7
/*     */     //   43: iconst_0
/*     */     //   44: istore #8
/*     */     //   46: aload #6
/*     */     //   48: astore #9
/*     */     //   50: iconst_0
/*     */     //   51: istore #10
/*     */     //   53: aload #9
/*     */     //   55: instanceof net/minecraft/entity/player/EntityPlayer
/*     */     //   58: ifne -> 63
/*     */     //   61: iconst_1
/*     */     //   62: ireturn
/*     */     //   63: iload #4
/*     */     //   65: ifeq -> 240
/*     */     //   68: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   71: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*     */     //   74: new net/ccbluex/liquidbounce/event/AttackEvent
/*     */     //   77: dup
/*     */     //   78: aload #9
/*     */     //   80: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   83: checkcast net/ccbluex/liquidbounce/event/Event
/*     */     //   86: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*     */     //   89: iload_1
/*     */     //   90: istore #11
/*     */     //   92: iconst_0
/*     */     //   93: istore #12
/*     */     //   95: iconst_0
/*     */     //   96: istore #13
/*     */     //   98: iconst_0
/*     */     //   99: istore #13
/*     */     //   101: iload #11
/*     */     //   103: istore #14
/*     */     //   105: iload #13
/*     */     //   107: iload #14
/*     */     //   109: if_icmpge -> 218
/*     */     //   112: iload #13
/*     */     //   114: istore #15
/*     */     //   116: iconst_0
/*     */     //   117: istore #16
/*     */     //   119: aload_0
/*     */     //   120: getfield clickSwing : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   123: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   126: checkcast java/lang/Boolean
/*     */     //   129: invokevirtual booleanValue : ()Z
/*     */     //   132: ifeq -> 158
/*     */     //   135: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   138: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   143: dup
/*     */     //   144: ifnonnull -> 150
/*     */     //   147: invokestatic throwNpe : ()V
/*     */     //   150: invokeinterface swingItem : ()V
/*     */     //   155: goto -> 182
/*     */     //   158: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   161: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   166: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   169: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   174: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   177: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   182: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   185: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   190: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   193: aload #9
/*     */     //   195: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   198: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   203: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   206: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   211: nop
/*     */     //   212: iinc #13, 1
/*     */     //   215: goto -> 105
/*     */     //   218: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   221: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   226: dup
/*     */     //   227: ifnonnull -> 233
/*     */     //   230: invokestatic throwNpe : ()V
/*     */     //   233: aload #9
/*     */     //   235: invokeinterface attackTargetEntityWithCurrentItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   240: iconst_1
/*     */     //   241: ireturn
/*     */     //   242: pop
/*     */     //   243: iconst_0
/*     */     //   244: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #541	-> 0
/*     */     //   #542	-> 13
/*     */     //   #550	-> 32
/*     */     //   #551	-> 53
/*     */     //   #552	-> 63
/*     */     //   #553	-> 68
/*     */     //   #554	-> 89
/*     */     //   #555	-> 119
/*     */     //   #556	-> 158
/*     */     //   #557	-> 182
/*     */     //   #558	-> 211
/*     */     //   #554	-> 212
/*     */     //   #559	-> 218
/*     */     //   #561	-> 240
/*     */     //   #550	-> 242
/*     */     //   #563	-> 243
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   116	95	15	$noName_0	I
/*     */     //   119	92	16	$i$a$-repeat-CatVelocity$attackRayTrace$1$1	I
/*     */     //   50	192	9	it	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   53	189	10	$i$a$-let-CatVelocity$attackRayTrace$1	I
/*     */     //   32	213	5	raycastedEntity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   0	245	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/CatVelocity;
/*     */     //   0	245	1	attack	I
/*     */     //   0	245	2	range	D
/*     */     //   0	245	4	doAttack	Z
/*     */   }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/CatVelocity$attackRayTrace$raycastedEntity$1", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*     */   public static final class CatVelocity$attackRayTrace$raycastedEntity$1 implements RaycastUtils.EntityFilter { public boolean canRaycast(@Nullable IEntity entity) {
/* 544 */       return (entity != null && entity instanceof net.minecraft.entity.EntityLivingBase);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\CatVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */