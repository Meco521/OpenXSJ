/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventState;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketEntityAction;
/*     */ import net.minecraft.network.play.client.CPacketUseEntity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "TestHYTVelocity", description = "Allows you to modify the amount of knockback you take.", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\016\n\002\030\002\n\002\b\022\n\002\020\016\n\002\b\007\n\002\030\002\n\000\n\002\020\007\n\002\b\f\n\002\020\006\n\002\b\f\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020[\032\0020\\2\006\020]\032\0020^H\007J\b\020_\032\0020\\H\026J\020\020`\032\0020\\2\006\020]\032\0020aH\007J\020\020b\032\0020\\2\006\020]\032\0020cH\007J\020\020d\032\0020\\2\006\020]\032\0020eH\007J\020\020f\032\0020\\2\006\020]\032\0020gH\007J\020\020h\032\0020\\2\006\020]\032\0020iH\007J\020\020j\032\0020\\2\006\020]\032\0020kH\007J\006\020l\032\0020\\J \020m\032\0020\0262\006\020N\032\0020\0262\006\020T\032\0020\0262\006\020X\032\0020\026H\002R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\016¢\006\002\n\000R\032\020\n\032\0020\004X\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\016\020\017\032\0020\bX\004¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\016\020\022\032\0020\004X\016¢\006\002\n\000R\016\020\023\032\0020\bX\004¢\006\002\n\000R\016\020\024\032\0020\bX\004¢\006\002\n\000R\016\020\025\032\0020\026X\016¢\006\002\n\000R\032\020\027\032\0020\026X\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\016\020\034\032\0020\bX\004¢\006\002\n\000R\016\020\035\032\0020\006X\004¢\006\002\n\000R\016\020\036\032\0020\006X\004¢\006\002\n\000R\032\020\037\032\0020\004X\016¢\006\016\n\000\032\004\b \020\f\"\004\b!\020\016R\016\020\"\032\0020\004X\016¢\006\002\n\000R\016\020#\032\0020\004X\016¢\006\002\n\000R\021\020$\032\0020%¢\006\b\n\000\032\004\b&\020'R\021\020(\032\0020\b¢\006\b\n\000\032\004\b)\020*R\016\020+\032\0020\026X\016¢\006\002\n\000R\016\020,\032\0020\026X\016¢\006\002\n\000R\016\020-\032\0020\026X\016¢\006\002\n\000R\016\020.\032\0020\004X\016¢\006\002\n\000R\016\020/\032\0020\006X\004¢\006\002\n\000R\016\0200\032\0020\004X\016¢\006\002\n\000R\016\0201\032\0020\006X\004¢\006\002\n\000R\016\0202\032\0020\004X\016¢\006\002\n\000R\032\0203\032\0020\004X\016¢\006\016\n\000\032\004\b4\020\f\"\004\b5\020\016R\016\0206\032\0020\004X\016¢\006\002\n\000R\024\0207\032\002088VX\004¢\006\006\032\004\b9\020:R\016\020;\032\0020\021X\004¢\006\002\n\000R\032\020<\032\0020\004X\016¢\006\016\n\000\032\004\b=\020\f\"\004\b>\020\016R\016\020?\032\0020@X\016¢\006\002\n\000R\032\020A\032\0020BX\016¢\006\016\n\000\032\004\bC\020D\"\004\bE\020FR\032\020G\032\0020BX\016¢\006\016\n\000\032\004\bH\020D\"\004\bI\020FR\032\020J\032\0020BX\016¢\006\016\n\000\032\004\bK\020D\"\004\bL\020FR\016\020M\032\0020\006X\004¢\006\002\n\000R\032\020N\032\0020OX\016¢\006\016\n\000\032\004\bP\020Q\"\004\bR\020SR\032\020T\032\0020OX\016¢\006\016\n\000\032\004\bU\020Q\"\004\bV\020SR\016\020W\032\0020\bX\004¢\006\002\n\000R\032\020X\032\0020OX\016¢\006\016\n\000\032\004\bY\020Q\"\004\bZ\020S¨\006n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "aacPushXZReducerValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "aacPushYReducerValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "air", "attacked", "getAttacked", "()Z", "setAttacked", "(Z)V", "autoStop", "c02", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "cancel", "fix", "grimCancelC03", "grimNoAntiKB", "", "grimReduce", "getGrimReduce", "()I", "setGrimReduce", "(I)V", "grimTimer", "grimTimerSpeed", "horizontalValue", "isvel", "getIsvel", "setIsvel", "jump", "lag", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "noKillAuraAttack", "getNoKillAuraAttack", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "notarget", "packetx", "packetz", "press", "reverse2StrengthValue", "reverseHurt", "reverseStrengthValue", "sendc02", "sendsprint", "getSendsprint", "setSendsprint", "sprint", "tag", "", "getTag", "()Ljava/lang/String;", "timerHurtTime", "velocityInput", "getVelocityInput", "setVelocityInput", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "velx", "", "getVelx", "()F", "setVelx", "(F)V", "vely", "getVely", "setVely", "velz", "getVelz", "setVelz", "verticalValue", "x", "", "getX", "()D", "setX", "(D)V", "y", "getY", "setY", "y1", "z", "getZ", "setZ", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onDisable", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "reduce", "reduceXZ", "XSJClient"})
/*     */ public final class TestHYTVelocity extends Module {
/*  40 */   private final FloatValue horizontalValue = new FloatValue("Horizontal", 0.0F, 0.0F, 1.0F);
/*  41 */   private final FloatValue verticalValue = new FloatValue("Vertical", 0.0F, 0.0F, 1.0F); @NotNull
/*  42 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Simple", "AAC", "AACPush", "AACZero", 
/*  43 */         "Reverse", "SmoothReverse", "Jump", "Glitch", "GrimReduce", "Grim", "GrimA", "GrimAC", "GrimACPro", "NewGrim", "NewGrimAC" }, "Simple");
/*     */   @NotNull
/*  45 */   public final ListValue getModeValue() { return this.modeValue; } private final BoolValue fix = new BoolValue("Fix", false);
/*     */   
/*  47 */   private final FloatValue reverseStrengthValue = new FloatValue("ReverseStrength", 1.0F, 0.1F, 1.0F);
/*  48 */   private final FloatValue reverse2StrengthValue = new FloatValue("SmoothReverseStrength", 0.05F, 0.02F, 0.1F);
/*     */ 
/*     */   
/*  51 */   private final FloatValue aacPushXZReducerValue = new FloatValue("AACPushXZReducer", 2.0F, 1.0F, 3.0F);
/*  52 */   private final BoolValue aacPushYReducerValue = new BoolValue("AACPushYReducer", true);
/*     */ 
/*     */   
/*  55 */   private final IntegerValue c02 = new IntegerValue("C02", 4, 0, 10);
/*  56 */   private final BoolValue autoStop = new BoolValue("Auto", true); @NotNull
/*  57 */   private final BoolValue noKillAuraAttack = new BoolValue("NoKillauraAttack", true); @NotNull public final BoolValue getNoKillAuraAttack() { return this.noKillAuraAttack; }
/*  58 */    private final BoolValue y1 = new BoolValue("y1", false);
/*     */   private boolean isvel; private float velx; private float velz; private float vely; private boolean attacked;
/*  60 */   public final boolean getIsvel() { return this.isvel; } public final void setIsvel(boolean <set-?>) { this.isvel = <set-?>; }
/*  61 */   public final float getVelx() { return this.velx; } public final void setVelx(float <set-?>) { this.velx = <set-?>; }
/*  62 */   public final float getVelz() { return this.velz; } public final void setVelz(float <set-?>) { this.velz = <set-?>; }
/*  63 */   public final float getVely() { return this.vely; } public final void setVely(float <set-?>) { this.vely = <set-?>; }
/*  64 */   public final boolean getAttacked() { return this.attacked; } public final void setAttacked(boolean <set-?>) { this.attacked = <set-?>; }
/*     */ 
/*     */   
/*  67 */   private final BoolValue grimCancelC03 = new BoolValue("GrimCancel", false);
/*  68 */   private final BoolValue grimTimer = new BoolValue("GrimLowTimer", false);
/*  69 */   private final FloatValue grimTimerSpeed = new FloatValue("GrimTimerSpeed", 0.5F, 0.01F, 1.0F);
/*  70 */   private final IntegerValue timerHurtTime = new IntegerValue("GrimTimerHurtTime", 0, 0, 10);
/*     */   private int grimNoAntiKB; private int notarget; private int packetx; private int packetz;
/*     */   private boolean cancel;
/*     */   private boolean lag;
/*     */   private boolean sendc02;
/*     */   private boolean a;
/*     */   private boolean sendsprint;
/*     */   private boolean sprint;
/*     */   
/*  79 */   public final boolean getSendsprint() { return this.sendsprint; } public final void setSendsprint(boolean <set-?>) { this.sendsprint = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   private MSTimer velocityTimer = new MSTimer();
/*  86 */   private boolean velocityInput; private boolean reverseHurt; private boolean jump; private boolean press; private int grimReduce; private boolean air; private double x; public final boolean getVelocityInput() { return this.velocityInput; } public final void setVelocityInput(boolean <set-?>) { this.velocityInput = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getGrimReduce() {
/*  96 */     return this.grimReduce; } public final void setGrimReduce(int <set-?>) { this.grimReduce = <set-?>; }
/*     */ 
/*     */   
/*     */   public final double getX() {
/* 100 */     return this.x; } public final void setX(double <set-?>) { this.x = <set-?>; }
/* 101 */    private double y = -0.1D; private double z; public final double getY() { return this.y; } public final void setY(double <set-?>) { this.y = <set-?>; }
/* 102 */   public final double getZ() { return this.z; } public final void setZ(double <set-?>) { this.z = <set-?>; } @NotNull
/*     */   public String getTag() {
/* 104 */     return (String)this.modeValue.get();
/*     */   }
/*     */   public void onDisable() {
/* 107 */     this.packetx = 0;
/* 108 */     this.packetz = 0;
/* 109 */     this.cancel = false;
/* 110 */     this.grimNoAntiKB = 0;
/* 111 */     this.sendc02 = false;
/* 112 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); } else { MinecraftInstance.mc.getThePlayer(); }
/* 113 */      this.grimReduce = 0;
/* 114 */     this.velocityInput = false;
/* 115 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/* 116 */     this.press = false;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 121 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInWater()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInLava()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInWeb())
/*     */         
/* 123 */         { if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */             return;
/*     */           }
/* 126 */           if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/*     */           
/* 128 */           String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 98623218:
/* 156 */               if (str.equals("grima") && 
/* 157 */                 this.velocityInput) {
/* 158 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() == 0) {
/* 159 */                   this.velocityInput = false;
/*     */                 }
/*     */               } 
/*     */               break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 96323:
/* 268 */               if (str.equals("aac") && this.velocityInput && this.velocityTimer.hasTimePassed(80L)) {
/* 269 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * ((Number)this.horizontalValue.get()).doubleValue());
/* 270 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() * ((Number)this.horizontalValue.get()).doubleValue());
/*     */                 
/* 272 */                 this.velocityInput = false;
/*     */               } 
/*     */               break;
/*     */ 
/*     */ 
/*     */             
/*     */             case -1243181771:
/*     */               if (str.equals("glitch")) {
/*     */                 if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */                   Intrinsics.throwNpe();
/*     */                 }
/*     */                 MinecraftInstance.mc.getThePlayer().setNoClip(this.velocityInput);
/*     */                 if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */                   Intrinsics.throwNpe();
/*     */                 }
/*     */                 if (MinecraftInstance.mc.getThePlayer().getHurtTime() == 7) {
/*     */                   if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */                     Intrinsics.throwNpe();
/*     */                   }
/*     */                   MinecraftInstance.mc.getThePlayer().setMotionY(0.4D);
/*     */                 } 
/*     */                 this.velocityInput = false;
/*     */               } 
/*     */               break;
/*     */ 
/*     */             
/*     */             case -1234264725:
/* 299 */               if (str.equals("aaczero")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0) {
/* 300 */                   if (this.velocityInput) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() <= 2.0F)
/*     */                       
/*     */                       { 
/* 303 */                         MinecraftInstance.mc2.field_71439_g.func_70016_h(0.0D, -1.0D, 0.0D);
/* 304 */                         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setOnGround(true); break; }  }  }
/*     */                    return;
/* 306 */                 }  this.velocityInput = false; }  break;case -1234547235: if (str.equals("aacpush")) { if (this.jump) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) this.jump = false;  } else { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionX() != 0.0D) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getMotionZ() != 0.0D) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setOnGround(true); }  }  }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtResistantTime() > 0 && ((Boolean)this.aacPushYReducerValue.get()).booleanValue()) { if (Retreat.INSTANCE.getModuleManager().get(Speed.class) == null) Intrinsics.throwNpe();  if (!Retreat.INSTANCE.getModuleManager().get(Speed.class).getState()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(MinecraftInstance.mc.getThePlayer().getMotionY() - 0.014999993D); }  }  }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtResistantTime() >= 19) { float reduce = ((Number)this.aacPushXZReducerValue.get()).floatValue(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() / reduce); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() / reduce); }  }  break;case 967805301: if (str.equals("grimreduce")) { if (this.grimReduce == 0 && this.velocityInput) { killAura.getKeepSprintValue().set(Boolean.valueOf(false)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() == 0) { killAura.getKeepSprintValue().set(Boolean.valueOf(true)); this.velocityInput = false; }  }  }  if (this.grimReduce != 0) { if (MinecraftInstance.mc == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() == 0.0F || this.air) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * (true - this.grimReduce * 0.01D)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() * (true - this.grimReduce * 0.01D)); }  }  }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround() && this.press) { MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74314_A)); this.press = false; }  }  break;case -1237647439: if (str.equals("grimac")) for (Entity entity : MinecraftInstance.mc2.field_71441_e.field_72996_f) { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killaura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class); if (killaura.getTarget() != null) { Intrinsics.checkExpressionValueIsNotNull(entity, "entity"); if (killaura.getTarget() == null) Intrinsics.throwNpe();  if (entity.func_145782_y() == killaura.getTarget().getEntityId() && MinecraftInstance.mc2.field_71439_g.field_70737_aN == 9) { if (!MinecraftInstance.mc2.field_71439_g.field_175171_bO && !this.a) { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketEntityAction((Entity)MinecraftInstance.mc2.field_71439_g, CPacketEntityAction.Action.START_SPRINTING)); this.a = true; }  byte b1; boolean bool1; byte b2; byte b3; for (b1 = 5, bool1 = false, b2 = 0, b2 = 0, b3 = b1; b2 < b3; ) { int it = b2, $i$a$-repeat-TestHYTVelocity$onUpdate$1 = 0; Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketUseEntity(entity)); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketAnimation(EnumHand.MAIN_HAND)); MinecraftInstance.mc2.field_71439_g.field_70159_w *= 0.6D; MinecraftInstance.mc2.field_71439_g.field_70179_y *= 0.6D; b2++; }  Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74370_x, "mc2.gameSettings.keyBindLeft"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74366_z, "mc2.gameSettings.keyBindRight"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74368_y, "mc2.gameSettings.keyBindBack"); if (this.a && (MinecraftInstance.mc2.field_71474_y.field_74370_x.func_151470_d() || MinecraftInstance.mc2.field_71474_y.field_74366_z.func_151470_d() || MinecraftInstance.mc2.field_71474_y.field_74368_y.func_151470_d())) { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketEntityAction((Entity)MinecraftInstance.mc2.field_71439_g, CPacketEntityAction.Action.STOP_SPRINTING)); }  break; }  }  }   break;case 1099846370: if (str.equals("reverse")) { if (!this.velocityInput) return;  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) { MovementUtils.strafe(MovementUtils.INSTANCE.getSpeed() * ((Number)this.reverseStrengthValue.get()).floatValue()); break; }  if (this.velocityTimer.hasTimePassed(80L)) this.velocityInput = false;  }  break;case 1539492188: if (str.equals("grimacpro") && this.isvel) { if (this.attacked) { if (this.attacked) if (MathHelper.func_76129_c(this.velx * this.velx + this.velz * this.velz) <= 2) { if (MinecraftInstance.mc2.field_71439_g.field_70122_E) { MinecraftInstance.mc2.field_71439_g.field_70159_w = this.velx * 1.0E-4D; MinecraftInstance.mc2.field_71439_g.field_70179_y = this.velz * 1.0E-4D; } else { MinecraftInstance.mc2.field_71439_g.field_70159_w = this.velx * 0.02D; MinecraftInstance.mc2.field_71439_g.field_70179_y = this.velz * 0.02D; }  } else { MinecraftInstance.mc2.field_71439_g.field_70159_w = this.velx * 0.15D; MinecraftInstance.mc2.field_71439_g.field_70179_y = this.velz * 0.15D; }   this.attacked = false; } else { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74314_A, "mc2.gameSettings.keyBindJump"); if (MinecraftInstance.mc2.field_71439_g.field_70737_aN == 6 && MinecraftInstance.mc2.field_71439_g.field_70122_E && !MinecraftInstance.mc2.field_71474_y.field_74314_A.func_151470_d()) MinecraftInstance.mc2.field_71439_g.field_71158_b.field_78901_c = true;  }  if (MinecraftInstance.mc2.field_71439_g.field_70737_aN == 0) this.isvel = false;  }  break;case -25235119: if (str.equals("newgrimac") && this.velocityInput) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() == 0) this.velocityInput = false;  }  break;case 3273774: if (str.equals("jump")) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround() && this.press) { MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74314_A)); this.press = false; }  }  break;case -1970553484: if (str.equals("smoothreverse")) { if (!this.velocityInput) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                     Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); return; }  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0)
/*     */                   this.reverseHurt = true;  if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                   Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround()) { if (this.reverseHurt) { if (MinecraftInstance.mc.getThePlayer() == null)
/* 312 */                       Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setSpeedInAir(((Number)this.reverse2StrengthValue.get()).floatValue()); }  break; }  if (this.velocityTimer.hasTimePassed(80L)) { this.velocityInput = false; this.reverseHurt = false; }  }  break; }  return; }  }  }  } @EventTarget public final void onAttack(@NotNull AttackEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 98623218:
/* 313 */         if (str.equals("grima") && 
/* 314 */           this.velocityInput) {
/* 315 */           if (((Boolean)this.y1.get()).booleanValue())
/* 316 */             MinecraftInstance.mc2.field_71439_g.field_70181_x *= 0.6D; 
/* 317 */           MinecraftInstance.mc2.field_71439_g.field_70159_w *= 0.6D;
/* 318 */           MinecraftInstance.mc2.field_71439_g.field_70179_y *= 0.6D;
/*     */         }  break;
/*     */       case -25235119:
/* 321 */         if (str.equals("newgrimac") && 
/* 322 */           this.velocityInput) {
/* 323 */           if (((Boolean)this.fix.get()).booleanValue())
/* 324 */             MinecraftInstance.mc2.field_71439_g.field_70181_x *= 0.6D; 
/* 325 */           MinecraftInstance.mc2.field_71439_g.field_70159_w *= 0.6D;
/* 326 */           MinecraftInstance.mc2.field_71439_g.field_70179_y *= 0.6D;
/*     */         } 
/*     */         break; }
/*     */      }
/*     */   
/*     */   public final void reduce() {
/* 332 */     MinecraftInstance.mc2.field_71439_g.field_70159_w *= 0.15F;
/* 333 */     MinecraftInstance.mc2.field_71439_g.field_70179_y *= 0.15F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onTick(@NotNull TickEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   9: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   12: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   14: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   17: dup
/*     */     //   18: ifnonnull -> 32
/*     */     //   21: new kotlin/TypeCastException
/*     */     //   24: dup
/*     */     //   25: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   28: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   31: athrow
/*     */     //   32: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   35: astore_2
/*     */     //   36: aload_0
/*     */     //   37: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   40: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   43: checkcast java/lang/String
/*     */     //   46: astore_3
/*     */     //   47: iconst_0
/*     */     //   48: istore #4
/*     */     //   50: aload_3
/*     */     //   51: dup
/*     */     //   52: ifnonnull -> 66
/*     */     //   55: new kotlin/TypeCastException
/*     */     //   58: dup
/*     */     //   59: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   62: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   65: athrow
/*     */     //   66: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   69: dup
/*     */     //   70: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   73: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   76: astore_3
/*     */     //   77: aload_3
/*     */     //   78: invokevirtual hashCode : ()I
/*     */     //   81: lookupswitch default -> 1599, -25235119 -> 150, 3181391 -> 163, 98623218 -> 124, 1845781743 -> 137
/*     */     //   124: aload_3
/*     */     //   125: ldc_w 'grima'
/*     */     //   128: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   131: ifeq -> 1599
/*     */     //   134: goto -> 176
/*     */     //   137: aload_3
/*     */     //   138: ldc_w 'newgrim'
/*     */     //   141: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   144: ifeq -> 1599
/*     */     //   147: goto -> 396
/*     */     //   150: aload_3
/*     */     //   151: ldc_w 'newgrimac'
/*     */     //   154: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   157: ifeq -> 1599
/*     */     //   160: goto -> 837
/*     */     //   163: aload_3
/*     */     //   164: ldc_w 'grim'
/*     */     //   167: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   170: ifeq -> 1599
/*     */     //   173: goto -> 1238
/*     */     //   176: aload_0
/*     */     //   177: getfield velocityInput : Z
/*     */     //   180: ifeq -> 1599
/*     */     //   183: ldc2_w 3.0
/*     */     //   186: dstore #4
/*     */     //   188: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.serverRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   191: dup
/*     */     //   192: ifnonnull -> 198
/*     */     //   195: invokestatic throwNpe : ()V
/*     */     //   198: astore #6
/*     */     //   200: getstatic net/ccbluex/liquidbounce/utils/RaycastUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/RaycastUtils;
/*     */     //   203: dload #4
/*     */     //   205: aload #6
/*     */     //   207: invokevirtual getYaw : ()F
/*     */     //   210: aload #6
/*     */     //   212: invokevirtual getPitch : ()F
/*     */     //   215: new net/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity$onTick$raycastedEntity$1
/*     */     //   218: dup
/*     */     //   219: invokespecial <init> : ()V
/*     */     //   222: checkcast net/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter
/*     */     //   225: invokevirtual raycastEntity : (DFFLnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   228: astore #7
/*     */     //   230: aload #7
/*     */     //   232: ifnull -> 1599
/*     */     //   235: aload #7
/*     */     //   237: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   240: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   245: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   248: iconst_1
/*     */     //   249: ixor
/*     */     //   250: ifeq -> 1599
/*     */     //   253: aload_0
/*     */     //   254: getfield c02 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   257: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   260: checkcast java/lang/Number
/*     */     //   263: invokevirtual intValue : ()I
/*     */     //   266: istore #8
/*     */     //   268: iconst_0
/*     */     //   269: istore #9
/*     */     //   271: iconst_0
/*     */     //   272: istore #10
/*     */     //   274: iconst_0
/*     */     //   275: istore #10
/*     */     //   277: iload #8
/*     */     //   279: istore #11
/*     */     //   281: iload #10
/*     */     //   283: iload #11
/*     */     //   285: if_icmpge -> 372
/*     */     //   288: iload #10
/*     */     //   290: istore #12
/*     */     //   292: iconst_0
/*     */     //   293: istore #13
/*     */     //   295: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   298: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*     */     //   301: new net/ccbluex/liquidbounce/event/AttackEvent
/*     */     //   304: dup
/*     */     //   305: aload #7
/*     */     //   307: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   310: checkcast net/ccbluex/liquidbounce/event/Event
/*     */     //   313: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*     */     //   316: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   319: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   324: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   327: aload #7
/*     */     //   329: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   332: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   337: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   340: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   345: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   348: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   353: dup
/*     */     //   354: ifnonnull -> 360
/*     */     //   357: invokestatic throwNpe : ()V
/*     */     //   360: invokeinterface swingItem : ()V
/*     */     //   365: nop
/*     */     //   366: iinc #10, 1
/*     */     //   369: goto -> 281
/*     */     //   372: aload_0
/*     */     //   373: getfield autoStop : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   376: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   379: checkcast java/lang/Boolean
/*     */     //   382: invokevirtual booleanValue : ()Z
/*     */     //   385: ifeq -> 1599
/*     */     //   388: aload_0
/*     */     //   389: iconst_0
/*     */     //   390: putfield velocityInput : Z
/*     */     //   393: goto -> 1599
/*     */     //   396: aload_0
/*     */     //   397: getfield velocityInput : Z
/*     */     //   400: ifeq -> 1599
/*     */     //   403: ldc2_w 3.0
/*     */     //   406: dstore #4
/*     */     //   408: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.serverRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   411: dup
/*     */     //   412: ifnonnull -> 418
/*     */     //   415: invokestatic throwNpe : ()V
/*     */     //   418: astore #6
/*     */     //   420: getstatic net/ccbluex/liquidbounce/utils/RaycastUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/RaycastUtils;
/*     */     //   423: dload #4
/*     */     //   425: aload #6
/*     */     //   427: invokevirtual getYaw : ()F
/*     */     //   430: aload #6
/*     */     //   432: invokevirtual getPitch : ()F
/*     */     //   435: new net/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity$onTick$raycastedEntity$2
/*     */     //   438: dup
/*     */     //   439: invokespecial <init> : ()V
/*     */     //   442: checkcast net/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter
/*     */     //   445: invokevirtual raycastEntity : (DFFLnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   448: astore #7
/*     */     //   450: aload #7
/*     */     //   452: ifnull -> 829
/*     */     //   455: aload #7
/*     */     //   457: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   460: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   465: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   468: iconst_1
/*     */     //   469: ixor
/*     */     //   470: ifeq -> 829
/*     */     //   473: aload_0
/*     */     //   474: getfield sprint : Z
/*     */     //   477: ifne -> 690
/*     */     //   480: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   483: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   486: getfield field_71174_a : Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   489: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   492: dup
/*     */     //   493: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   496: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   499: checkcast net/minecraft/entity/Entity
/*     */     //   502: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   505: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   508: checkcast net/minecraft/network/Packet
/*     */     //   511: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   514: aload_0
/*     */     //   515: getfield c02 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   518: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   521: checkcast java/lang/Number
/*     */     //   524: invokevirtual intValue : ()I
/*     */     //   527: istore #8
/*     */     //   529: iconst_0
/*     */     //   530: istore #9
/*     */     //   532: iconst_0
/*     */     //   533: istore #10
/*     */     //   535: iconst_0
/*     */     //   536: istore #10
/*     */     //   538: iload #8
/*     */     //   540: istore #11
/*     */     //   542: iload #10
/*     */     //   544: iload #11
/*     */     //   546: if_icmpge -> 649
/*     */     //   549: iload #10
/*     */     //   551: istore #12
/*     */     //   553: iconst_0
/*     */     //   554: istore #13
/*     */     //   556: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   559: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*     */     //   562: new net/ccbluex/liquidbounce/event/AttackEvent
/*     */     //   565: dup
/*     */     //   566: aload #7
/*     */     //   568: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   571: checkcast net/ccbluex/liquidbounce/event/Event
/*     */     //   574: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*     */     //   577: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   580: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   585: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   588: aload #7
/*     */     //   590: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   593: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   598: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   601: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   606: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   609: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   614: dup
/*     */     //   615: ifnonnull -> 621
/*     */     //   618: invokestatic throwNpe : ()V
/*     */     //   621: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   626: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   629: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   634: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   637: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   642: nop
/*     */     //   643: iinc #10, 1
/*     */     //   646: goto -> 542
/*     */     //   649: aload_0
/*     */     //   650: invokevirtual reduce : ()V
/*     */     //   653: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   656: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   659: getfield field_71174_a : Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   662: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   665: dup
/*     */     //   666: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   669: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   672: checkcast net/minecraft/entity/Entity
/*     */     //   675: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   678: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   681: checkcast net/minecraft/network/Packet
/*     */     //   684: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   687: goto -> 829
/*     */     //   690: aload_0
/*     */     //   691: getfield c02 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   694: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   697: checkcast java/lang/Number
/*     */     //   700: invokevirtual intValue : ()I
/*     */     //   703: istore #8
/*     */     //   705: iconst_0
/*     */     //   706: istore #9
/*     */     //   708: iconst_0
/*     */     //   709: istore #10
/*     */     //   711: iconst_0
/*     */     //   712: istore #10
/*     */     //   714: iload #8
/*     */     //   716: istore #11
/*     */     //   718: iload #10
/*     */     //   720: iload #11
/*     */     //   722: if_icmpge -> 825
/*     */     //   725: iload #10
/*     */     //   727: istore #12
/*     */     //   729: iconst_0
/*     */     //   730: istore #13
/*     */     //   732: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   735: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*     */     //   738: new net/ccbluex/liquidbounce/event/AttackEvent
/*     */     //   741: dup
/*     */     //   742: aload #7
/*     */     //   744: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   747: checkcast net/ccbluex/liquidbounce/event/Event
/*     */     //   750: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*     */     //   753: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   756: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   761: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   764: aload #7
/*     */     //   766: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   769: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   774: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   777: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   782: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   785: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   790: dup
/*     */     //   791: ifnonnull -> 797
/*     */     //   794: invokestatic throwNpe : ()V
/*     */     //   797: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   802: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   805: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   810: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   813: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   818: nop
/*     */     //   819: iinc #10, 1
/*     */     //   822: goto -> 718
/*     */     //   825: aload_0
/*     */     //   826: invokevirtual reduce : ()V
/*     */     //   829: aload_0
/*     */     //   830: iconst_0
/*     */     //   831: putfield velocityInput : Z
/*     */     //   834: goto -> 1599
/*     */     //   837: aload_0
/*     */     //   838: getfield velocityInput : Z
/*     */     //   841: ifeq -> 1599
/*     */     //   844: ldc2_w 3.0
/*     */     //   847: dstore #4
/*     */     //   849: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.serverRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   852: dup
/*     */     //   853: ifnonnull -> 859
/*     */     //   856: invokestatic throwNpe : ()V
/*     */     //   859: astore #6
/*     */     //   861: getstatic net/ccbluex/liquidbounce/utils/RaycastUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/RaycastUtils;
/*     */     //   864: dload #4
/*     */     //   866: aload #6
/*     */     //   868: invokevirtual getYaw : ()F
/*     */     //   871: aload #6
/*     */     //   873: invokevirtual getPitch : ()F
/*     */     //   876: new net/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity$onTick$raycastedEntity$3
/*     */     //   879: dup
/*     */     //   880: invokespecial <init> : ()V
/*     */     //   883: checkcast net/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter
/*     */     //   886: invokevirtual raycastEntity : (DFFLnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   889: astore #7
/*     */     //   891: aload #7
/*     */     //   893: ifnull -> 1599
/*     */     //   896: aload #7
/*     */     //   898: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   901: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   906: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   909: iconst_1
/*     */     //   910: ixor
/*     */     //   911: ifeq -> 1599
/*     */     //   914: aload_0
/*     */     //   915: getfield sprint : Z
/*     */     //   918: ifne -> 1111
/*     */     //   921: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   924: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   927: getfield field_71174_a : Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   930: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   933: dup
/*     */     //   934: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   937: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   940: checkcast net/minecraft/entity/Entity
/*     */     //   943: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   946: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   949: checkcast net/minecraft/network/Packet
/*     */     //   952: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   955: aload_0
/*     */     //   956: getfield c02 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   959: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   962: checkcast java/lang/Number
/*     */     //   965: invokevirtual intValue : ()I
/*     */     //   968: istore #8
/*     */     //   970: iconst_0
/*     */     //   971: istore #9
/*     */     //   973: iconst_0
/*     */     //   974: istore #10
/*     */     //   976: iconst_0
/*     */     //   977: istore #10
/*     */     //   979: iload #8
/*     */     //   981: istore #11
/*     */     //   983: iload #10
/*     */     //   985: iload #11
/*     */     //   987: if_icmpge -> 1074
/*     */     //   990: iload #10
/*     */     //   992: istore #12
/*     */     //   994: iconst_0
/*     */     //   995: istore #13
/*     */     //   997: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1000: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*     */     //   1003: new net/ccbluex/liquidbounce/event/AttackEvent
/*     */     //   1006: dup
/*     */     //   1007: aload #7
/*     */     //   1009: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   1012: checkcast net/ccbluex/liquidbounce/event/Event
/*     */     //   1015: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*     */     //   1018: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1021: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1026: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1029: aload #7
/*     */     //   1031: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   1034: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   1039: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1042: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1047: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1050: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1055: dup
/*     */     //   1056: ifnonnull -> 1062
/*     */     //   1059: invokestatic throwNpe : ()V
/*     */     //   1062: invokeinterface swingItem : ()V
/*     */     //   1067: nop
/*     */     //   1068: iinc #10, 1
/*     */     //   1071: goto -> 983
/*     */     //   1074: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1077: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   1080: getfield field_71174_a : Lnet/minecraft/client/network/NetHandlerPlayClient;
/*     */     //   1083: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   1086: dup
/*     */     //   1087: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1090: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   1093: checkcast net/minecraft/entity/Entity
/*     */     //   1096: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   1099: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   1102: checkcast net/minecraft/network/Packet
/*     */     //   1105: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*     */     //   1108: goto -> 1599
/*     */     //   1111: aload_0
/*     */     //   1112: getfield c02 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1115: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1118: checkcast java/lang/Number
/*     */     //   1121: invokevirtual intValue : ()I
/*     */     //   1124: istore #8
/*     */     //   1126: iconst_0
/*     */     //   1127: istore #9
/*     */     //   1129: iconst_0
/*     */     //   1130: istore #10
/*     */     //   1132: iconst_0
/*     */     //   1133: istore #10
/*     */     //   1135: iload #8
/*     */     //   1137: istore #11
/*     */     //   1139: iload #10
/*     */     //   1141: iload #11
/*     */     //   1143: if_icmpge -> 1230
/*     */     //   1146: iload #10
/*     */     //   1148: istore #12
/*     */     //   1150: iconst_0
/*     */     //   1151: istore #13
/*     */     //   1153: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1156: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*     */     //   1159: new net/ccbluex/liquidbounce/event/AttackEvent
/*     */     //   1162: dup
/*     */     //   1163: aload #7
/*     */     //   1165: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*     */     //   1168: checkcast net/ccbluex/liquidbounce/event/Event
/*     */     //   1171: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*     */     //   1174: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1177: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1182: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1185: aload #7
/*     */     //   1187: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*     */     //   1190: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*     */     //   1195: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1198: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1203: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1206: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1211: dup
/*     */     //   1212: ifnonnull -> 1218
/*     */     //   1215: invokestatic throwNpe : ()V
/*     */     //   1218: invokeinterface swingItem : ()V
/*     */     //   1223: nop
/*     */     //   1224: iinc #10, 1
/*     */     //   1227: goto -> 1139
/*     */     //   1230: aload_0
/*     */     //   1231: iconst_0
/*     */     //   1232: putfield velocityInput : Z
/*     */     //   1235: goto -> 1599
/*     */     //   1238: aload_0
/*     */     //   1239: getfield grimTimer : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1242: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1245: checkcast java/lang/Boolean
/*     */     //   1248: invokevirtual booleanValue : ()Z
/*     */     //   1251: ifeq -> 1327
/*     */     //   1254: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1257: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1262: dup
/*     */     //   1263: ifnonnull -> 1269
/*     */     //   1266: invokestatic throwNpe : ()V
/*     */     //   1269: invokeinterface getHurtTime : ()I
/*     */     //   1274: ifle -> 1327
/*     */     //   1277: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1280: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1285: dup
/*     */     //   1286: ifnonnull -> 1292
/*     */     //   1289: invokestatic throwNpe : ()V
/*     */     //   1292: invokeinterface getHurtTime : ()I
/*     */     //   1297: aload_0
/*     */     //   1298: getfield timerHurtTime : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1301: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1304: checkcast java/lang/Number
/*     */     //   1307: invokevirtual intValue : ()I
/*     */     //   1310: if_icmple -> 1327
/*     */     //   1313: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1316: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1321: fconst_1
/*     */     //   1322: invokeinterface setTimerSpeed : (F)V
/*     */     //   1327: aload_0
/*     */     //   1328: getfield cancel : Z
/*     */     //   1331: ifeq -> 1428
/*     */     //   1334: aload_2
/*     */     //   1335: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   1338: ifnonnull -> 1370
/*     */     //   1341: aload_0
/*     */     //   1342: dup
/*     */     //   1343: getfield notarget : I
/*     */     //   1346: dup
/*     */     //   1347: istore #4
/*     */     //   1349: iconst_1
/*     */     //   1350: iadd
/*     */     //   1351: putfield notarget : I
/*     */     //   1354: aload_0
/*     */     //   1355: getfield notarget : I
/*     */     //   1358: iconst_5
/*     */     //   1359: if_icmple -> 1375
/*     */     //   1362: aload_0
/*     */     //   1363: iconst_0
/*     */     //   1364: putfield cancel : Z
/*     */     //   1367: goto -> 1375
/*     */     //   1370: aload_0
/*     */     //   1371: iconst_0
/*     */     //   1372: putfield notarget : I
/*     */     //   1375: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1378: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1383: dup
/*     */     //   1384: ifnonnull -> 1390
/*     */     //   1387: invokestatic throwNpe : ()V
/*     */     //   1390: invokeinterface getHurtTime : ()I
/*     */     //   1395: ifeq -> 1423
/*     */     //   1398: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1401: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1406: dup
/*     */     //   1407: ifnonnull -> 1413
/*     */     //   1410: invokestatic throwNpe : ()V
/*     */     //   1413: invokeinterface getHurtTime : ()I
/*     */     //   1418: bipush #10
/*     */     //   1420: if_icmple -> 1428
/*     */     //   1423: aload_0
/*     */     //   1424: iconst_0
/*     */     //   1425: putfield cancel : Z
/*     */     //   1428: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1431: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1436: dup
/*     */     //   1437: ifnonnull -> 1443
/*     */     //   1440: invokestatic throwNpe : ()V
/*     */     //   1443: invokeinterface getHurtTime : ()I
/*     */     //   1448: ifne -> 1599
/*     */     //   1451: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1454: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1459: dup
/*     */     //   1460: ifnonnull -> 1466
/*     */     //   1463: invokestatic throwNpe : ()V
/*     */     //   1466: invokeinterface getFallDistance : ()F
/*     */     //   1471: f2d
/*     */     //   1472: dconst_0
/*     */     //   1473: dcmpl
/*     */     //   1474: ifgt -> 1500
/*     */     //   1477: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1480: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1485: dup
/*     */     //   1486: ifnonnull -> 1492
/*     */     //   1489: invokestatic throwNpe : ()V
/*     */     //   1492: invokeinterface getOnGround : ()Z
/*     */     //   1497: ifeq -> 1599
/*     */     //   1500: aload_0
/*     */     //   1501: getfield velocityInput : Z
/*     */     //   1504: ifeq -> 1599
/*     */     //   1507: aload_0
/*     */     //   1508: getfield cancel : Z
/*     */     //   1511: ifne -> 1599
/*     */     //   1514: aload_0
/*     */     //   1515: getfield grimTimer : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1518: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1521: checkcast java/lang/Boolean
/*     */     //   1524: invokevirtual booleanValue : ()Z
/*     */     //   1527: ifeq -> 1544
/*     */     //   1530: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1533: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1538: fconst_1
/*     */     //   1539: invokeinterface setTimerSpeed : (F)V
/*     */     //   1544: aload_0
/*     */     //   1545: getfield grimCancelC03 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1548: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1551: checkcast java/lang/Boolean
/*     */     //   1554: invokevirtual booleanValue : ()Z
/*     */     //   1557: ifeq -> 1594
/*     */     //   1560: aload_0
/*     */     //   1561: dup
/*     */     //   1562: getfield grimNoAntiKB : I
/*     */     //   1565: dup
/*     */     //   1566: istore #4
/*     */     //   1568: iconst_1
/*     */     //   1569: iadd
/*     */     //   1570: putfield grimNoAntiKB : I
/*     */     //   1573: aload_0
/*     */     //   1574: getfield grimNoAntiKB : I
/*     */     //   1577: iconst_4
/*     */     //   1578: if_icmple -> 1599
/*     */     //   1581: aload_0
/*     */     //   1582: iconst_0
/*     */     //   1583: putfield grimNoAntiKB : I
/*     */     //   1586: aload_0
/*     */     //   1587: iconst_0
/*     */     //   1588: putfield velocityInput : Z
/*     */     //   1591: goto -> 1599
/*     */     //   1594: aload_0
/*     */     //   1595: iconst_0
/*     */     //   1596: putfield velocityInput : Z
/*     */     //   1599: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #338	-> 6
/*     */     //   #342	-> 36
/*     */     //   #343	-> 124
/*     */     //   #371	-> 137
/*     */     //   #429	-> 150
/*     */     //   #487	-> 163
/*     */     //   #344	-> 176
/*     */     //   #345	-> 183
/*     */     //   #346	-> 188
/*     */     //   #348	-> 200
/*     */     //   #355	-> 230
/*     */     //   #356	-> 253
/*     */     //   #357	-> 295
/*     */     //   #358	-> 316
/*     */     //   #359	-> 324
/*     */     //   #360	-> 327
/*     */     //   #361	-> 329
/*     */     //   #359	-> 332
/*     */     //   #358	-> 340
/*     */     //   #364	-> 345
/*     */     //   #365	-> 365
/*     */     //   #356	-> 366
/*     */     //   #366	-> 372
/*     */     //   #367	-> 388
/*     */     //   #372	-> 396
/*     */     //   #373	-> 403
/*     */     //   #374	-> 408
/*     */     //   #376	-> 420
/*     */     //   #377	-> 423
/*     */     //   #378	-> 425
/*     */     //   #379	-> 430
/*     */     //   #380	-> 435
/*     */     //   #376	-> 445
/*     */     //   #387	-> 450
/*     */     //   #388	-> 473
/*     */     //   #389	-> 480
/*     */     //   #390	-> 489
/*     */     //   #391	-> 493
/*     */     //   #392	-> 502
/*     */     //   #390	-> 505
/*     */     //   #389	-> 511
/*     */     //   #395	-> 514
/*     */     //   #396	-> 556
/*     */     //   #397	-> 577
/*     */     //   #398	-> 585
/*     */     //   #399	-> 588
/*     */     //   #400	-> 590
/*     */     //   #398	-> 593
/*     */     //   #397	-> 601
/*     */     //   #403	-> 606
/*     */     //   #404	-> 642
/*     */     //   #395	-> 643
/*     */     //   #405	-> 649
/*     */     //   #406	-> 653
/*     */     //   #407	-> 662
/*     */     //   #408	-> 666
/*     */     //   #409	-> 675
/*     */     //   #407	-> 678
/*     */     //   #406	-> 684
/*     */     //   #413	-> 690
/*     */     //   #414	-> 732
/*     */     //   #415	-> 753
/*     */     //   #416	-> 761
/*     */     //   #417	-> 764
/*     */     //   #418	-> 766
/*     */     //   #416	-> 769
/*     */     //   #415	-> 777
/*     */     //   #421	-> 782
/*     */     //   #422	-> 818
/*     */     //   #413	-> 819
/*     */     //   #423	-> 825
/*     */     //   #424	-> 829
/*     */     //   #426	-> 829
/*     */     //   #430	-> 837
/*     */     //   #431	-> 844
/*     */     //   #432	-> 849
/*     */     //   #434	-> 861
/*     */     //   #435	-> 864
/*     */     //   #436	-> 866
/*     */     //   #437	-> 871
/*     */     //   #438	-> 876
/*     */     //   #434	-> 886
/*     */     //   #445	-> 891
/*     */     //   #446	-> 914
/*     */     //   #447	-> 921
/*     */     //   #448	-> 930
/*     */     //   #449	-> 934
/*     */     //   #450	-> 943
/*     */     //   #448	-> 946
/*     */     //   #447	-> 952
/*     */     //   #453	-> 955
/*     */     //   #454	-> 997
/*     */     //   #455	-> 1018
/*     */     //   #456	-> 1026
/*     */     //   #457	-> 1029
/*     */     //   #458	-> 1031
/*     */     //   #456	-> 1034
/*     */     //   #455	-> 1042
/*     */     //   #461	-> 1047
/*     */     //   #462	-> 1067
/*     */     //   #453	-> 1068
/*     */     //   #463	-> 1074
/*     */     //   #464	-> 1083
/*     */     //   #465	-> 1087
/*     */     //   #466	-> 1096
/*     */     //   #464	-> 1099
/*     */     //   #463	-> 1105
/*     */     //   #470	-> 1111
/*     */     //   #471	-> 1153
/*     */     //   #472	-> 1174
/*     */     //   #473	-> 1182
/*     */     //   #474	-> 1185
/*     */     //   #475	-> 1187
/*     */     //   #473	-> 1190
/*     */     //   #472	-> 1198
/*     */     //   #478	-> 1203
/*     */     //   #479	-> 1223
/*     */     //   #470	-> 1224
/*     */     //   #480	-> 1230
/*     */     //   #481	-> 1235
/*     */     //   #488	-> 1238
/*     */     //   #489	-> 1277
/*     */     //   #490	-> 1313
/*     */     //   #492	-> 1327
/*     */     //   #493	-> 1334
/*     */     //   #494	-> 1341
/*     */     //   #495	-> 1354
/*     */     //   #496	-> 1362
/*     */     //   #499	-> 1370
/*     */     //   #500	-> 1375
/*     */     //   #502	-> 1375
/*     */     //   #503	-> 1423
/*     */     //   #506	-> 1428
/*     */     //   #507	-> 1514
/*     */     //   #508	-> 1530
/*     */     //   #509	-> 1544
/*     */     //   #510	-> 1560
/*     */     //   #511	-> 1573
/*     */     //   #512	-> 1581
/*     */     //   #513	-> 1586
/*     */     //   #516	-> 1594
/*     */     //   #517	-> 1599
/*     */     //   #520	-> 1599
/*     */     //   #521	-> 1599
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   292	73	12	it	I
/*     */     //   295	70	13	$i$a$-repeat-TestHYTVelocity$onTick$1	I
/*     */     //   230	163	7	raycastedEntity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   200	193	6	currentRotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   188	205	4	reach	D
/*     */     //   553	89	12	it	I
/*     */     //   556	86	13	$i$a$-repeat-TestHYTVelocity$onTick$2	I
/*     */     //   729	89	12	it	I
/*     */     //   732	86	13	$i$a$-repeat-TestHYTVelocity$onTick$3	I
/*     */     //   450	384	7	raycastedEntity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   420	414	6	currentRotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   408	426	4	reach	D
/*     */     //   994	73	12	it	I
/*     */     //   997	70	13	$i$a$-repeat-TestHYTVelocity$onTick$4	I
/*     */     //   1150	73	12	it	I
/*     */     //   1153	70	13	$i$a$-repeat-TestHYTVelocity$onTick$5	I
/*     */     //   891	344	7	raycastedEntity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   861	374	6	currentRotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   849	386	4	reach	D
/*     */     //   36	1564	2	killAura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   0	1600	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity;
/*     */     //   0	1600	1	event	Lnet/ccbluex/liquidbounce/event/TickEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity$onTick$raycastedEntity$1", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*     */   public static final class TestHYTVelocity$onTick$raycastedEntity$1
/*     */     implements RaycastUtils.EntityFilter
/*     */   {
/*     */     public boolean canRaycast(@Nullable IEntity entity) {
/* 350 */       return true;
/*     */     }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity$onTick$raycastedEntity$2", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*     */   public static final class TestHYTVelocity$onTick$raycastedEntity$2
/*     */     implements RaycastUtils.EntityFilter
/*     */   {
/*     */     public boolean canRaycast(@Nullable IEntity entity) {
/* 382 */       return true;
/*     */     }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity$onTick$raycastedEntity$3", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*     */   public static final class TestHYTVelocity$onTick$raycastedEntity$3
/*     */     implements RaycastUtils.EntityFilter
/*     */   {
/*     */     public boolean canRaycast(@Nullable IEntity entity) {
/* 440 */       return true;
/*     */     }
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
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   10: astore_3
/*     */     //   11: iconst_0
/*     */     //   12: istore #4
/*     */     //   14: aload_3
/*     */     //   15: dup
/*     */     //   16: ifnonnull -> 30
/*     */     //   19: new kotlin/TypeCastException
/*     */     //   22: dup
/*     */     //   23: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*     */     //   26: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   29: athrow
/*     */     //   30: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   33: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*     */     //   36: astore_2
/*     */     //   37: aload_0
/*     */     //   38: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   41: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   44: checkcast java/lang/String
/*     */     //   47: astore_3
/*     */     //   48: iconst_0
/*     */     //   49: istore #4
/*     */     //   51: aload_3
/*     */     //   52: dup
/*     */     //   53: ifnonnull -> 67
/*     */     //   56: new kotlin/TypeCastException
/*     */     //   59: dup
/*     */     //   60: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   63: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   66: athrow
/*     */     //   67: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   70: dup
/*     */     //   71: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   74: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   77: astore_3
/*     */     //   78: aload_3
/*     */     //   79: invokevirtual hashCode : ()I
/*     */     //   82: lookupswitch default -> 761, -1237647439 -> 116, 3181391 -> 142, 1539492188 -> 129
/*     */     //   116: aload_3
/*     */     //   117: ldc_w 'grimac'
/*     */     //   120: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   123: ifeq -> 761
/*     */     //   126: goto -> 576
/*     */     //   129: aload_3
/*     */     //   130: ldc_w 'grimacpro'
/*     */     //   133: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   136: ifeq -> 761
/*     */     //   139: goto -> 155
/*     */     //   142: aload_3
/*     */     //   143: ldc_w 'grim'
/*     */     //   146: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   149: ifeq -> 761
/*     */     //   152: goto -> 665
/*     */     //   155: aload_1
/*     */     //   156: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   159: astore #5
/*     */     //   161: iconst_0
/*     */     //   162: istore #6
/*     */     //   164: aload #5
/*     */     //   166: dup
/*     */     //   167: ifnonnull -> 181
/*     */     //   170: new kotlin/TypeCastException
/*     */     //   173: dup
/*     */     //   174: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*     */     //   177: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   180: athrow
/*     */     //   181: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   184: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*     */     //   187: astore #4
/*     */     //   189: aload #4
/*     */     //   191: instanceof net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   194: ifeq -> 761
/*     */     //   197: aload #4
/*     */     //   199: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   202: invokevirtual func_149412_c : ()I
/*     */     //   205: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   208: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   211: dup
/*     */     //   212: ldc_w 'mc2.player'
/*     */     //   215: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   218: invokevirtual func_145782_y : ()I
/*     */     //   221: if_icmpeq -> 225
/*     */     //   224: return
/*     */     //   225: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   228: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   231: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   233: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   236: dup
/*     */     //   237: ifnonnull -> 251
/*     */     //   240: new kotlin/TypeCastException
/*     */     //   243: dup
/*     */     //   244: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura'
/*     */     //   247: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   250: athrow
/*     */     //   251: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura
/*     */     //   254: astore #5
/*     */     //   256: aload #5
/*     */     //   258: invokevirtual getCurrentTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   261: dup
/*     */     //   262: ifnonnull -> 268
/*     */     //   265: invokestatic throwNpe : ()V
/*     */     //   268: astore #7
/*     */     //   270: iconst_0
/*     */     //   271: istore #8
/*     */     //   273: aload #7
/*     */     //   275: dup
/*     */     //   276: ifnonnull -> 290
/*     */     //   279: new kotlin/TypeCastException
/*     */     //   282: dup
/*     */     //   283: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityLivingBaseImpl<*>'
/*     */     //   286: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   289: athrow
/*     */     //   290: checkcast net/ccbluex/liquidbounce/injection/backend/EntityLivingBaseImpl
/*     */     //   293: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   296: checkcast net/minecraft/entity/EntityLivingBase
/*     */     //   299: astore #6
/*     */     //   301: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   304: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   307: aload #6
/*     */     //   309: checkcast net/minecraft/entity/Entity
/*     */     //   312: invokevirtual func_70032_d : (Lnet/minecraft/entity/Entity;)F
/*     */     //   315: f2d
/*     */     //   316: ldc2_w 3.01
/*     */     //   319: dcmpg
/*     */     //   320: ifge -> 761
/*     */     //   323: aload #6
/*     */     //   325: invokevirtual func_70089_S : ()Z
/*     */     //   328: ifeq -> 761
/*     */     //   331: aload_0
/*     */     //   332: iconst_1
/*     */     //   333: putfield isvel : Z
/*     */     //   336: iconst_0
/*     */     //   337: istore #7
/*     */     //   339: iconst_5
/*     */     //   340: istore #8
/*     */     //   342: iload #7
/*     */     //   344: iload #8
/*     */     //   346: if_icmpgt -> 517
/*     */     //   349: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   352: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   355: getfield field_175171_bO : Z
/*     */     //   358: ifeq -> 407
/*     */     //   361: invokestatic isMoving : ()Z
/*     */     //   364: ifeq -> 407
/*     */     //   367: invokestatic sendPacketC0F : ()V
/*     */     //   370: new net/minecraft/network/play/client/CPacketAnimation
/*     */     //   373: dup
/*     */     //   374: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   377: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*     */     //   380: checkcast net/minecraft/network/Packet
/*     */     //   383: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   386: new net/minecraft/network/play/client/CPacketUseEntity
/*     */     //   389: dup
/*     */     //   390: aload #6
/*     */     //   392: checkcast net/minecraft/entity/Entity
/*     */     //   395: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*     */     //   398: checkcast net/minecraft/network/Packet
/*     */     //   401: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   404: goto -> 511
/*     */     //   407: invokestatic sendPacketC0F : ()V
/*     */     //   410: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   413: dup
/*     */     //   414: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   417: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   420: checkcast net/minecraft/entity/Entity
/*     */     //   423: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   426: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   429: checkcast net/minecraft/network/Packet
/*     */     //   432: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   435: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   438: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   441: dup
/*     */     //   442: ldc_w 'mc2.player'
/*     */     //   445: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   448: iconst_0
/*     */     //   449: invokevirtual func_70031_b : (Z)V
/*     */     //   452: new net/minecraft/network/play/client/CPacketAnimation
/*     */     //   455: dup
/*     */     //   456: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   459: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*     */     //   462: checkcast net/minecraft/network/Packet
/*     */     //   465: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   468: new net/minecraft/network/play/client/CPacketUseEntity
/*     */     //   471: dup
/*     */     //   472: aload #6
/*     */     //   474: checkcast net/minecraft/entity/Entity
/*     */     //   477: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*     */     //   480: checkcast net/minecraft/network/Packet
/*     */     //   483: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   486: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   489: dup
/*     */     //   490: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   493: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*     */     //   496: checkcast net/minecraft/entity/Entity
/*     */     //   499: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   502: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   505: checkcast net/minecraft/network/Packet
/*     */     //   508: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*     */     //   511: iinc #7, 1
/*     */     //   514: goto -> 342
/*     */     //   517: aload_0
/*     */     //   518: aload #4
/*     */     //   520: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   523: invokevirtual func_149411_d : ()I
/*     */     //   526: i2f
/*     */     //   527: ldc_w 8000.0
/*     */     //   530: fdiv
/*     */     //   531: putfield velx : F
/*     */     //   534: aload_0
/*     */     //   535: aload #4
/*     */     //   537: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   540: invokevirtual func_149409_f : ()I
/*     */     //   543: i2f
/*     */     //   544: ldc_w 8000.0
/*     */     //   547: fdiv
/*     */     //   548: putfield velz : F
/*     */     //   551: aload_0
/*     */     //   552: aload #4
/*     */     //   554: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   557: invokevirtual func_149410_e : ()I
/*     */     //   560: i2f
/*     */     //   561: ldc_w 8000.0
/*     */     //   564: fdiv
/*     */     //   565: putfield vely : F
/*     */     //   568: aload_0
/*     */     //   569: iconst_1
/*     */     //   570: putfield attacked : Z
/*     */     //   573: goto -> 761
/*     */     //   576: aload_1
/*     */     //   577: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   580: astore #5
/*     */     //   582: iconst_0
/*     */     //   583: istore #6
/*     */     //   585: aload #5
/*     */     //   587: dup
/*     */     //   588: ifnonnull -> 602
/*     */     //   591: new kotlin/TypeCastException
/*     */     //   594: dup
/*     */     //   595: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>'
/*     */     //   598: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   601: athrow
/*     */     //   602: checkcast net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   605: invokevirtual getWrapped : ()Lnet/minecraft/network/Packet;
/*     */     //   608: astore #4
/*     */     //   610: aload #4
/*     */     //   612: instanceof net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   615: ifeq -> 635
/*     */     //   618: aload #4
/*     */     //   620: checkcast net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   623: invokevirtual func_180764_b : ()Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   626: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   629: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   632: ifne -> 657
/*     */     //   635: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   638: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   641: getfield field_74351_w : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   644: dup
/*     */     //   645: ldc_w 'mc2.gameSettings.keyBindForward'
/*     */     //   648: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   651: invokevirtual func_151470_d : ()Z
/*     */     //   654: ifeq -> 761
/*     */     //   657: aload_0
/*     */     //   658: iconst_0
/*     */     //   659: putfield a : Z
/*     */     //   662: goto -> 761
/*     */     //   665: aload_0
/*     */     //   666: getfield grimCancelC03 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   669: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   672: checkcast java/lang/Boolean
/*     */     //   675: invokevirtual booleanValue : ()Z
/*     */     //   678: ifeq -> 709
/*     */     //   681: aload_2
/*     */     //   682: instanceof net/minecraft/network/play/client/CPacketPlayer
/*     */     //   685: ifeq -> 709
/*     */     //   688: aload_2
/*     */     //   689: checkcast net/minecraft/network/play/client/CPacketPlayer
/*     */     //   692: getfield field_149481_i : Z
/*     */     //   695: ifne -> 709
/*     */     //   698: aload_0
/*     */     //   699: getfield cancel : Z
/*     */     //   702: ifeq -> 709
/*     */     //   705: aload_1
/*     */     //   706: invokevirtual cancelEvent : ()V
/*     */     //   709: aload_2
/*     */     //   710: instanceof net/minecraft/network/play/client/CPacketPlayer
/*     */     //   713: ifeq -> 761
/*     */     //   716: aload_0
/*     */     //   717: getfield velocityInput : Z
/*     */     //   720: ifeq -> 761
/*     */     //   723: aload_0
/*     */     //   724: getfield lag : Z
/*     */     //   727: ifeq -> 761
/*     */     //   730: aload_2
/*     */     //   731: checkcast net/minecraft/network/play/client/CPacketPlayer
/*     */     //   734: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   737: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   742: dup
/*     */     //   743: ifnonnull -> 749
/*     */     //   746: invokestatic throwNpe : ()V
/*     */     //   749: invokeinterface getPosX : ()D
/*     */     //   754: ldc2_w 1000.0
/*     */     //   757: dadd
/*     */     //   758: putfield field_149479_a : D
/*     */     //   761: aload_2
/*     */     //   762: instanceof net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   765: ifeq -> 1606
/*     */     //   768: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   771: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   776: ifnull -> 828
/*     */     //   779: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   782: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   787: dup
/*     */     //   788: ifnull -> 810
/*     */     //   791: aload_2
/*     */     //   792: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   795: invokevirtual func_149412_c : ()I
/*     */     //   798: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   803: dup
/*     */     //   804: ifnull -> 810
/*     */     //   807: goto -> 812
/*     */     //   810: pop
/*     */     //   811: return
/*     */     //   812: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   815: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   820: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   823: iconst_1
/*     */     //   824: ixor
/*     */     //   825: ifeq -> 829
/*     */     //   828: return
/*     */     //   829: aload_0
/*     */     //   830: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   833: invokevirtual reset : ()V
/*     */     //   836: aload_0
/*     */     //   837: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   840: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   845: dup
/*     */     //   846: ifnonnull -> 852
/*     */     //   849: invokestatic throwNpe : ()V
/*     */     //   852: invokeinterface getPosX : ()D
/*     */     //   857: putfield x : D
/*     */     //   860: aload_0
/*     */     //   861: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   864: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   869: dup
/*     */     //   870: ifnonnull -> 876
/*     */     //   873: invokestatic throwNpe : ()V
/*     */     //   876: invokeinterface getPosY : ()D
/*     */     //   881: putfield y : D
/*     */     //   884: aload_0
/*     */     //   885: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   888: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   893: dup
/*     */     //   894: ifnonnull -> 900
/*     */     //   897: invokestatic throwNpe : ()V
/*     */     //   900: invokeinterface getPosZ : ()D
/*     */     //   905: putfield z : D
/*     */     //   908: aload_0
/*     */     //   909: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   912: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   915: checkcast java/lang/String
/*     */     //   918: astore_3
/*     */     //   919: iconst_0
/*     */     //   920: istore #4
/*     */     //   922: aload_3
/*     */     //   923: dup
/*     */     //   924: ifnonnull -> 938
/*     */     //   927: new kotlin/TypeCastException
/*     */     //   930: dup
/*     */     //   931: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   934: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   937: athrow
/*     */     //   938: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   941: dup
/*     */     //   942: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   945: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   948: astore_3
/*     */     //   949: aload_3
/*     */     //   950: invokevirtual hashCode : ()I
/*     */     //   953: lookupswitch default -> 1606, -1970553484 -> 1177, -1243181771 -> 1086, -1234264725 -> 1099, -902286926 -> 1125, -25235119 -> 1164, 96323 -> 1060, 3181391 -> 1190, 3273774 -> 1203, 98623218 -> 1073, 967805301 -> 1112, 1099846370 -> 1151, 1845781743 -> 1138
/*     */     //   1060: aload_3
/*     */     //   1061: ldc_w 'aac'
/*     */     //   1064: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1067: ifeq -> 1606
/*     */     //   1070: goto -> 1406
/*     */     //   1073: aload_3
/*     */     //   1074: ldc_w 'grima'
/*     */     //   1077: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1080: ifeq -> 1606
/*     */     //   1083: goto -> 1406
/*     */     //   1086: aload_3
/*     */     //   1087: ldc_w 'glitch'
/*     */     //   1090: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1093: ifeq -> 1606
/*     */     //   1096: goto -> 1565
/*     */     //   1099: aload_3
/*     */     //   1100: ldc_w 'aaczero'
/*     */     //   1103: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1106: ifeq -> 1606
/*     */     //   1109: goto -> 1406
/*     */     //   1112: aload_3
/*     */     //   1113: ldc_w 'grimreduce'
/*     */     //   1116: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1119: ifeq -> 1606
/*     */     //   1122: goto -> 1216
/*     */     //   1125: aload_3
/*     */     //   1126: ldc_w 'simple'
/*     */     //   1129: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1132: ifeq -> 1606
/*     */     //   1135: goto -> 1298
/*     */     //   1138: aload_3
/*     */     //   1139: ldc_w 'newgrim'
/*     */     //   1142: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1145: ifeq -> 1606
/*     */     //   1148: goto -> 1282
/*     */     //   1151: aload_3
/*     */     //   1152: ldc_w 'reverse'
/*     */     //   1155: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1158: ifeq -> 1606
/*     */     //   1161: goto -> 1406
/*     */     //   1164: aload_3
/*     */     //   1165: ldc_w 'newgrimac'
/*     */     //   1168: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1171: ifeq -> 1606
/*     */     //   1174: goto -> 1290
/*     */     //   1177: aload_3
/*     */     //   1178: ldc_w 'smoothreverse'
/*     */     //   1181: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1184: ifeq -> 1606
/*     */     //   1187: goto -> 1406
/*     */     //   1190: aload_3
/*     */     //   1191: ldc_w 'grim'
/*     */     //   1194: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1197: ifeq -> 1606
/*     */     //   1200: goto -> 1414
/*     */     //   1203: aload_3
/*     */     //   1204: ldc_w 'jump'
/*     */     //   1207: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1210: ifeq -> 1606
/*     */     //   1213: goto -> 1601
/*     */     //   1216: aload_0
/*     */     //   1217: aload_0
/*     */     //   1218: aload_2
/*     */     //   1219: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1222: getfield field_149415_b : I
/*     */     //   1225: aload_2
/*     */     //   1226: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1229: getfield field_149416_c : I
/*     */     //   1232: aload_2
/*     */     //   1233: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1236: getfield field_149414_d : I
/*     */     //   1239: invokespecial reduceXZ : (III)I
/*     */     //   1242: putfield grimReduce : I
/*     */     //   1245: aload_0
/*     */     //   1246: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1249: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1254: dup
/*     */     //   1255: ifnonnull -> 1261
/*     */     //   1258: invokestatic throwNpe : ()V
/*     */     //   1261: invokeinterface getOnGround : ()Z
/*     */     //   1266: putfield air : Z
/*     */     //   1269: aload_0
/*     */     //   1270: iconst_1
/*     */     //   1271: putfield press : Z
/*     */     //   1274: aload_0
/*     */     //   1275: iconst_1
/*     */     //   1276: putfield velocityInput : Z
/*     */     //   1279: goto -> 1606
/*     */     //   1282: aload_0
/*     */     //   1283: iconst_1
/*     */     //   1284: putfield velocityInput : Z
/*     */     //   1287: goto -> 1606
/*     */     //   1290: aload_0
/*     */     //   1291: iconst_1
/*     */     //   1292: putfield velocityInput : Z
/*     */     //   1295: goto -> 1606
/*     */     //   1298: aload_0
/*     */     //   1299: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1302: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1305: checkcast java/lang/Number
/*     */     //   1308: invokevirtual floatValue : ()F
/*     */     //   1311: fstore #4
/*     */     //   1313: aload_0
/*     */     //   1314: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1317: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1320: checkcast java/lang/Number
/*     */     //   1323: invokevirtual floatValue : ()F
/*     */     //   1326: fstore #5
/*     */     //   1328: fload #4
/*     */     //   1330: fconst_0
/*     */     //   1331: fcmpg
/*     */     //   1332: ifne -> 1346
/*     */     //   1335: fload #5
/*     */     //   1337: fconst_0
/*     */     //   1338: fcmpg
/*     */     //   1339: ifne -> 1346
/*     */     //   1342: aload_1
/*     */     //   1343: invokevirtual cancelEvent : ()V
/*     */     //   1346: aload_2
/*     */     //   1347: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1350: aload_2
/*     */     //   1351: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1354: invokevirtual func_149411_d : ()I
/*     */     //   1357: i2f
/*     */     //   1358: fload #4
/*     */     //   1360: fmul
/*     */     //   1361: f2i
/*     */     //   1362: putfield field_149415_b : I
/*     */     //   1365: aload_2
/*     */     //   1366: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1369: aload_2
/*     */     //   1370: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1373: invokevirtual func_149410_e : ()I
/*     */     //   1376: i2f
/*     */     //   1377: fload #5
/*     */     //   1379: fmul
/*     */     //   1380: f2i
/*     */     //   1381: putfield field_149416_c : I
/*     */     //   1384: aload_2
/*     */     //   1385: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1388: aload_2
/*     */     //   1389: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1392: invokevirtual func_149409_f : ()I
/*     */     //   1395: i2f
/*     */     //   1396: fload #4
/*     */     //   1398: fmul
/*     */     //   1399: f2i
/*     */     //   1400: putfield field_149414_d : I
/*     */     //   1403: goto -> 1606
/*     */     //   1406: aload_0
/*     */     //   1407: iconst_1
/*     */     //   1408: putfield velocityInput : Z
/*     */     //   1411: goto -> 1606
/*     */     //   1414: aload_0
/*     */     //   1415: getfield velocityInput : Z
/*     */     //   1418: ifeq -> 1422
/*     */     //   1421: return
/*     */     //   1422: aload_2
/*     */     //   1423: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1426: getfield field_149415_b : I
/*     */     //   1429: istore #4
/*     */     //   1431: iconst_0
/*     */     //   1432: istore #5
/*     */     //   1434: iload #4
/*     */     //   1436: invokestatic abs : (I)I
/*     */     //   1439: sipush #1000
/*     */     //   1442: if_icmpge -> 1469
/*     */     //   1445: aload_2
/*     */     //   1446: checkcast net/minecraft/network/play/server/SPacketEntityVelocity
/*     */     //   1449: getfield field_149414_d : I
/*     */     //   1452: istore #4
/*     */     //   1454: iconst_0
/*     */     //   1455: istore #5
/*     */     //   1457: iload #4
/*     */     //   1459: invokestatic abs : (I)I
/*     */     //   1462: sipush #1000
/*     */     //   1465: if_icmpge -> 1469
/*     */     //   1468: return
/*     */     //   1469: aload_0
/*     */     //   1470: getfield grimCancelC03 : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1473: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1476: checkcast java/lang/Boolean
/*     */     //   1479: invokevirtual booleanValue : ()Z
/*     */     //   1482: ifeq -> 1495
/*     */     //   1485: aload_0
/*     */     //   1486: iconst_0
/*     */     //   1487: putfield grimNoAntiKB : I
/*     */     //   1490: aload_0
/*     */     //   1491: iconst_1
/*     */     //   1492: putfield cancel : Z
/*     */     //   1495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1498: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1503: dup
/*     */     //   1504: ifnonnull -> 1510
/*     */     //   1507: invokestatic throwNpe : ()V
/*     */     //   1510: invokeinterface jump : ()V
/*     */     //   1515: aload_0
/*     */     //   1516: getfield grimTimer : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1519: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1522: checkcast java/lang/Boolean
/*     */     //   1525: invokevirtual booleanValue : ()Z
/*     */     //   1528: ifeq -> 1557
/*     */     //   1531: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1534: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   1539: aload_0
/*     */     //   1540: getfield grimTimerSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1543: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1546: checkcast java/lang/Number
/*     */     //   1549: invokevirtual floatValue : ()F
/*     */     //   1552: invokeinterface setTimerSpeed : (F)V
/*     */     //   1557: aload_0
/*     */     //   1558: iconst_1
/*     */     //   1559: putfield velocityInput : Z
/*     */     //   1562: goto -> 1606
/*     */     //   1565: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1568: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1573: dup
/*     */     //   1574: ifnonnull -> 1580
/*     */     //   1577: invokestatic throwNpe : ()V
/*     */     //   1580: invokeinterface getOnGround : ()Z
/*     */     //   1585: ifne -> 1589
/*     */     //   1588: return
/*     */     //   1589: aload_0
/*     */     //   1590: iconst_1
/*     */     //   1591: putfield velocityInput : Z
/*     */     //   1594: aload_1
/*     */     //   1595: invokevirtual cancelEvent : ()V
/*     */     //   1598: goto -> 1606
/*     */     //   1601: aload_0
/*     */     //   1602: iconst_1
/*     */     //   1603: putfield press : Z
/*     */     //   1606: aload_2
/*     */     //   1607: instanceof net/minecraft/network/play/server/SPacketExplosion
/*     */     //   1610: ifeq -> 1617
/*     */     //   1613: aload_1
/*     */     //   1614: invokevirtual cancelEvent : ()V
/*     */     //   1617: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #525	-> 6
/*     */     //   #705	-> 14
/*     */     //   #525	-> 36
/*     */     //   #528	-> 37
/*     */     //   #572	-> 116
/*     */     //   #529	-> 129
/*     */     //   #578	-> 142
/*     */     //   #530	-> 155
/*     */     //   #706	-> 164
/*     */     //   #530	-> 187
/*     */     //   #531	-> 189
/*     */     //   #532	-> 197
/*     */     //   #533	-> 225
/*     */     //   #534	-> 256
/*     */     //   #707	-> 273
/*     */     //   #534	-> 299
/*     */     //   #535	-> 301
/*     */     //   #537	-> 331
/*     */     //   #538	-> 336
/*     */     //   #539	-> 349
/*     */     //   #540	-> 367
/*     */     //   #541	-> 370
/*     */     //   #542	-> 386
/*     */     //   #544	-> 407
/*     */     //   #545	-> 410
/*     */     //   #546	-> 410
/*     */     //   #547	-> 414
/*     */     //   #548	-> 423
/*     */     //   #546	-> 426
/*     */     //   #545	-> 432
/*     */     //   #551	-> 435
/*     */     //   #552	-> 452
/*     */     //   #553	-> 468
/*     */     //   #554	-> 486
/*     */     //   #555	-> 486
/*     */     //   #556	-> 490
/*     */     //   #557	-> 499
/*     */     //   #555	-> 502
/*     */     //   #554	-> 508
/*     */     //   #560	-> 511
/*     */     //   #538	-> 511
/*     */     //   #563	-> 517
/*     */     //   #564	-> 534
/*     */     //   #565	-> 551
/*     */     //   #566	-> 568
/*     */     //   #573	-> 576
/*     */     //   #708	-> 585
/*     */     //   #573	-> 608
/*     */     //   #574	-> 610
/*     */     //   #575	-> 657
/*     */     //   #579	-> 665
/*     */     //   #580	-> 681
/*     */     //   #581	-> 705
/*     */     //   #584	-> 709
/*     */     //   #585	-> 730
/*     */     //   #588	-> 761
/*     */     //   #590	-> 761
/*     */     //   #591	-> 768
/*     */     //   #591	-> 810
/*     */     //   #592	-> 828
/*     */     //   #594	-> 829
/*     */     //   #596	-> 836
/*     */     //   #597	-> 860
/*     */     //   #598	-> 884
/*     */     //   #600	-> 908
/*     */     //   #621	-> 1060
/*     */     //   #640	-> 1086
/*     */     //   #621	-> 1099
/*     */     //   #601	-> 1112
/*     */     //   #609	-> 1125
/*     */     //   #607	-> 1138
/*     */     //   #621	-> 1151
/*     */     //   #608	-> 1164
/*     */     //   #621	-> 1177
/*     */     //   #623	-> 1190
/*     */     //   #648	-> 1203
/*     */     //   #602	-> 1216
/*     */     //   #603	-> 1245
/*     */     //   #604	-> 1269
/*     */     //   #605	-> 1274
/*     */     //   #607	-> 1282
/*     */     //   #608	-> 1290
/*     */     //   #610	-> 1298
/*     */     //   #611	-> 1313
/*     */     //   #613	-> 1328
/*     */     //   #614	-> 1342
/*     */     //   #616	-> 1346
/*     */     //   #617	-> 1365
/*     */     //   #618	-> 1384
/*     */     //   #621	-> 1406
/*     */     //   #624	-> 1414
/*     */     //   #625	-> 1421
/*     */     //   #626	-> 1422
/*     */     //   #626	-> 1445
/*     */     //   #627	-> 1468
/*     */     //   #628	-> 1469
/*     */     //   #629	-> 1485
/*     */     //   #630	-> 1490
/*     */     //   #633	-> 1495
/*     */     //   #634	-> 1515
/*     */     //   #635	-> 1531
/*     */     //   #637	-> 1557
/*     */     //   #641	-> 1565
/*     */     //   #642	-> 1588
/*     */     //   #644	-> 1589
/*     */     //   #645	-> 1594
/*     */     //   #649	-> 1601
/*     */     //   #651	-> 1606
/*     */     //   #654	-> 1606
/*     */     //   #656	-> 1613
/*     */     //   #658	-> 1617
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   11	25	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   14	22	4	$i$f$unwrap	I
/*     */     //   161	26	5	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   164	23	6	$i$f$unwrap	I
/*     */     //   270	29	7	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   273	26	8	$i$f$unwrap	I
/*     */     //   349	165	7	i	I
/*     */     //   301	272	6	targets	Lnet/minecraft/entity/EntityLivingBase;
/*     */     //   256	317	5	killAura	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   189	384	4	packet	Lnet/minecraft/network/Packet;
/*     */     //   582	26	5	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   585	23	6	$i$f$unwrap	I
/*     */     //   610	52	4	packet	Lnet/minecraft/network/Packet;
/*     */     //   1328	75	5	vertical	F
/*     */     //   1313	90	4	horizontal	F
/*     */     //   37	1581	2	packet	Lnet/minecraft/network/Packet;
/*     */     //   0	1618	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/TestHYTVelocity;
/*     */     //   0	1618	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */   private final int reduceXZ(int x, int y, int z) {
/* 661 */     return (x < 3200 && y < 2890 && z < 3200) ? 
/* 662 */       35 : (
/* 663 */       (x < 3200 && y < 3200 && z < 3200) ? 
/* 664 */       20 : 
/*     */       
/* 666 */       0);
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/* 672 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.lag = (event.getEventState() == EventState.PRE);
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 677 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInWater()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInLava()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isInWeb())
/*     */           
/*     */           { 
/* 680 */             String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */             
/*     */             { 
/*     */ 
/*     */ 
/*     */               
/*     */               case -1234264725:
/* 687 */                 if (str.equals("aaczero")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0)
/* 688 */                     event.cancelEvent();  }  break;
/*     */               case -1234547235:
/*     */                 if (str.equals("aacpush")) { this.jump = true; if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                     Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isCollidedVertically())
/*     */                     event.cancelEvent();  }  break; }  return; }  }  }
/*     */        }
/* 694 */      } @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 3181391:
/* 695 */         if (str.equals("grim") && 
/* 696 */           this.cancel)
/* 697 */           event.cancelEvent(); 
/*     */         break; }
/*     */      }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\TestHYTVelocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */