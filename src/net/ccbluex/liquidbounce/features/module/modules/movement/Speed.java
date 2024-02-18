/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.util.Collection;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "Speed", description = "Allows you to move faster.", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\021\n\002\020\016\n\002\b\016\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020-\032\0020.H\026J\b\020/\032\0020.H\026J\020\0200\032\0020.2\006\0201\032\00202H\007J\022\0203\032\0020.2\b\0201\032\004\030\00104H\007J\022\0205\032\0020.2\b\0201\032\004\030\00106H\007J\022\0207\032\0020.2\b\0201\032\004\030\00108H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\r\020\016R\021\020\017\032\0020\004¢\006\b\n\000\032\004\b\020\020\006R\021\020\021\032\0020\004¢\006\b\n\000\032\004\b\022\020\006R\021\020\023\032\0020\004¢\006\b\n\000\032\004\b\024\020\006R\026\020\025\032\004\030\0010\0268BX\004¢\006\006\032\004\b\027\020\030R\021\020\031\032\0020\032¢\006\b\n\000\032\004\b\033\020\034R\032\020\035\032\b\022\004\022\0020\0370\0368BX\004¢\006\006\032\004\b \020!R\021\020\"\032\0020\004¢\006\b\n\000\032\004\b#\020\006R\021\020$\032\0020\f¢\006\b\n\000\032\004\b%\020\016R\021\020&\032\0020\f¢\006\b\n\000\032\004\b'\020\016R\026\020(\032\b\022\004\022\0020\0260\036X\004¢\006\004\n\002\020)R\024\020*\032\0020\0378VX\004¢\006\006\032\004\b+\020,¨\0069"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/Speed;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aacGroundTimerValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getAacGroundTimerValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "cubecraftPortLengthValue", "getCubecraftPortLengthValue", "customSpeedValue", "getCustomSpeedValue", "customStrafeValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getCustomStrafeValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "customTimerValue", "getCustomTimerValue", "customYValue", "getCustomYValue", "mineplexGroundSpeedValue", "getMineplexGroundSpeedValue", "mode", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "getMode", "()Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "modes", "", "", "getModes", "()[Ljava/lang/String;", "portMax", "getPortMax", "resetXZValue", "getResetXZValue", "resetYValue", "getResetYValue", "speedModes", "[Lnet/ccbluex/liquidbounce/features/module/modules/movement/speeds/SpeedMode;", "tag", "getTag", "()Ljava/lang/String;", "onDisable", "", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class Speed extends Module {
/*  18 */   private final SpeedMode[] speedModes = new SpeedMode[] { 
/*  19 */       (SpeedMode)new VulcanYPort(), 
/*  20 */       (SpeedMode)new VulcanYPort2Speed(), 
/*  21 */       (SpeedMode)new VulcanGroundSpeed(), 
/*  22 */       (SpeedMode)new VulcanHopSpeed(), 
/*  23 */       (SpeedMode)new VulcanHop(), 
/*  24 */       (SpeedMode)new VulcanHop2(), 
/*  25 */       (SpeedMode)new AAC4Hop(), 
/*  26 */       (SpeedMode)new AAC4SlowHop(), 
/*  27 */       (SpeedMode)new AACBHop(), 
/*  28 */       (SpeedMode)new AAC2BHop(), 
/*  29 */       (SpeedMode)new AAC3BHop(), 
/*  30 */       (SpeedMode)new AAC4BHop(), 
/*  31 */       (SpeedMode)new AAC5BHop(), 
/*  32 */       (SpeedMode)new AAC6BHop(), 
/*  33 */       (SpeedMode)new AAC7BHop(), 
/*  34 */       (SpeedMode)new AACHop3313(), 
/*  35 */       (SpeedMode)new AACHop350(), 
/*  36 */       (SpeedMode)new AACLowHop(), 
/*  37 */       (SpeedMode)new AACLowHop2(), 
/*  38 */       (SpeedMode)new AACLowHop3(), 
/*  39 */       (SpeedMode)new AACGround(), 
/*  40 */       (SpeedMode)new AACGround2(), 
/*  41 */       (SpeedMode)new AACYPort(), 
/*  42 */       (SpeedMode)new AACYPort2(), 
/*  43 */       (SpeedMode)new AACPort(), 
/*  44 */       (SpeedMode)new OldAACBHop(), 
/*  45 */       (SpeedMode)new LegitHop() };
/*     */   
/*     */   @NotNull
/*  48 */   private final ListValue modeValue = new Speed$modeValue$1("Mode", getModes(), "NCPBHop"); @NotNull public final ListValue getModeValue() { return this.modeValue; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\016\n\002\b\003*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024J\030\020\007\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\b"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/movement/Speed$modeValue$1", "Lnet/ccbluex/liquidbounce/value/ListValue;", "onChange", "", "oldValue", "", "newValue", "onChanged", "XSJClient"}) public static final class Speed$modeValue$1 extends ListValue { Speed$modeValue$1(String $super_call_param$1, String[] $super_call_param$2, String $super_call_param$3) { super($super_call_param$1, $super_call_param$2, $super_call_param$3); }
/*     */      protected void onChange(@NotNull String oldValue, @NotNull String newValue) {
/*  50 */       Intrinsics.checkParameterIsNotNull(oldValue, "oldValue"); Intrinsics.checkParameterIsNotNull(newValue, "newValue"); if (Speed.this.getState())
/*  51 */         Speed.this.onDisable(); 
/*     */     }
/*     */     
/*     */     protected void onChanged(@NotNull String oldValue, @NotNull String newValue) {
/*  55 */       Intrinsics.checkParameterIsNotNull(oldValue, "oldValue"); Intrinsics.checkParameterIsNotNull(newValue, "newValue"); if (Speed.this.getState())
/*  56 */         Speed.this.onEnable(); 
/*     */     } }
/*     */   @NotNull
/*  59 */   private final FloatValue customSpeedValue = new FloatValue("CustomSpeed", 1.6F, 0.2F, 2.0F); @NotNull public final FloatValue getCustomSpeedValue() { return this.customSpeedValue; } @NotNull
/*  60 */   private final FloatValue customYValue = new FloatValue("CustomY", 0.0F, 0.0F, 4.0F); @NotNull public final FloatValue getCustomYValue() { return this.customYValue; } @NotNull
/*  61 */   private final FloatValue customTimerValue = new FloatValue("CustomTimer", 1.0F, 0.1F, 2.0F); @NotNull public final FloatValue getCustomTimerValue() { return this.customTimerValue; } @NotNull
/*  62 */   private final BoolValue customStrafeValue = new BoolValue("CustomStrafe", true); @NotNull public final BoolValue getCustomStrafeValue() { return this.customStrafeValue; } @NotNull
/*  63 */   private final BoolValue resetXZValue = new BoolValue("CustomResetXZ", false); @NotNull public final BoolValue getResetXZValue() { return this.resetXZValue; } @NotNull
/*  64 */   private final BoolValue resetYValue = new BoolValue("CustomResetY", false); @NotNull public final BoolValue getResetYValue() { return this.resetYValue; } @NotNull
/*  65 */   private final FloatValue portMax = new FloatValue("AAC-PortLength", 1.0F, 1.0F, 20.0F); @NotNull public final FloatValue getPortMax() { return this.portMax; } @NotNull
/*  66 */   private final FloatValue aacGroundTimerValue = new FloatValue("AACGround-Timer", 3.0F, 1.1F, 10.0F); @NotNull public final FloatValue getAacGroundTimerValue() { return this.aacGroundTimerValue; } @NotNull
/*  67 */   private final FloatValue cubecraftPortLengthValue = new FloatValue("CubeCraft-PortLength", 1.0F, 0.1F, 2.0F); @NotNull public final FloatValue getCubecraftPortLengthValue() { return this.cubecraftPortLengthValue; } @NotNull
/*  68 */   private final FloatValue mineplexGroundSpeedValue = new FloatValue("MineplexGround-Speed", 0.5F, 0.1F, 1.0F); @NotNull public final FloatValue getMineplexGroundSpeedValue() { return this.mineplexGroundSpeedValue; }
/*     */ 
/*     */   
/*     */   @EventTarget
/*  72 */   public final void onUpdate(@Nullable UpdateEvent event) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  74 */       if (thePlayer.isSneaking()) {
/*     */         return;
/*     */       }
/*  77 */       if (MovementUtils.isMoving()) {
/*  78 */         thePlayer.setSprinting(true);
/*     */       }
/*     */       
/*  81 */       if (getMode() != null) { getMode().onUpdate(); } else { getMode(); }
/*     */       
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @EventTarget
/*  86 */   public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  88 */       if (thePlayer.isSneaking() || event.getEventState() != EventState.PRE) {
/*     */         return;
/*     */       }
/*  91 */       if (MovementUtils.isMoving()) {
/*  92 */         thePlayer.setSprinting(true);
/*     */       }
/*  94 */       if (getMode() != null) { getMode().onMotion(); } else { getMode(); }
/*     */       
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @EventTarget
/*  99 */   public final void onMove(@Nullable MoveEvent event) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isSneaking())
/*     */       return; 
/* 101 */     if (getMode() != null) { if (event == null) Intrinsics.throwNpe();  getMode().onMove(event); } else { getMode(); }
/*     */      }
/*     */   
/*     */   @EventTarget
/*     */   public final void onTick(@Nullable TickEvent event) {
/* 106 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isSneaking()) {
/*     */       return;
/*     */     }
/* 109 */     if (getMode() != null) { getMode().onTick(); } else { getMode(); }
/*     */   
/*     */   }
/*     */   public void onEnable() {
/* 113 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/* 116 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */     
/* 118 */     if (getMode() != null) { getMode().onEnable(); } else { getMode(); }
/*     */   
/*     */   }
/*     */   public void onDisable() {
/* 122 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/* 125 */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*     */     
/* 127 */     if (getMode() != null) { getMode().onDisable(); } else { getMode(); }
/*     */   
/*     */   } @NotNull
/*     */   public String getTag() {
/* 131 */     return (String)this.modeValue.get();
/*     */   }
/*     */   
/*     */   private final SpeedMode getMode() {
/* 135 */     String mode = (String)this.modeValue.get();
/*     */     
/* 137 */     for (SpeedMode speedMode : this.speedModes) { if (StringsKt.equals(speedMode.getModeName(), mode, true))
/* 138 */         return speedMode;  }
/*     */     
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private final String[] getModes() {
/* 145 */     List<String> list = new ArrayList();
/* 146 */     for (SpeedMode speedMode : this.speedModes) list.add(speedMode.getModeName()); 
/* 147 */     Collection<String> $this$toTypedArray$iv = list; int $i$f$toTypedArray = 0;
/*     */ 
/*     */     
/* 150 */     Collection<String> thisCollection$iv = $this$toTypedArray$iv;
/* 151 */     if (thisCollection$iv.toArray(new String[0]) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");  return thisCollection$iv.toArray(new String[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\Speed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */