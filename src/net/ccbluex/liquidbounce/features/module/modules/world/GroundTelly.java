/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.NoFOV;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "GroundTelly", description = "GroundTelly", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\006\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\b\007\030\000 \"2\0020\001:\001\"B\005¢\006\002\020\002J\b\020\023\032\0020\024H\002J\b\020\025\032\0020\024H\002J\b\020\026\032\0020\024H\027J\b\020\027\032\0020\024H\026J\020\020\030\032\0020\0242\006\020\031\032\0020\032H\007J\022\020\033\032\0020\0242\b\020\031\032\004\030\0010\034H\007J\020\020\035\032\0020\0242\006\020\036\032\0020\037H\002J\b\020 \032\0020\024H\002J\b\020!\032\0020\024H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\024\020\b\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\004X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\rX\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\rX\004¢\006\002\n\000¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/GroundTelly;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "alwaysPitchValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "autoJumpHelper", "Lnet/ccbluex/liquidbounce/value/Value;", "", "autoJumpMode", "autoJumpValue", "autoPitchValue", "autoTimerValue", "autoYawValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "disableAllOnDisable", "disableAllOnEnable", "eventTargetSelector", "noBobValue", "scaffoldModule", "disableAll", "", "jump", "onDisable", "onEnable", "onTick", "event", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "scaffoldChange", "state", "", "setYaw", "tryJump", "Companion", "XSJClient"})
/*     */ public final class GroundTelly extends Module {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GroundTelly$autoJumpHelper$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*  25 */       return ((Boolean)GroundTelly.this.autoJumpValue.get()).booleanValue();
/*     */     }
/*     */     GroundTelly$autoJumpHelper$1() {
/*     */       super(0);
/*     */     } }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  32 */   static final class GroundTelly$autoJumpMode$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)GroundTelly.this.autoJumpValue.get()).booleanValue(); } GroundTelly$autoJumpMode$1() { super(0); } } private final ListValue scaffoldModule = new ListValue("ScaffoldModule", new String[] { "Scaffold", "Scaffold2", "Scaffold3", "Scaffold4" }, "Scaffold"); private final BoolValue autoJumpValue = new BoolValue("AutoJump", false); private final Value<String> autoJumpHelper = (new ListValue("JumpHelper", new String[] { "Parkour", "Eagle", "Test" }, "Parkour")).displayable(new GroundTelly$autoJumpHelper$1()); private final Value<String> autoJumpMode = (new ListValue("AutoJumpMode", new String[] { "MCInstanceJump", "MCInstance2Jump", "ClientMotionY" }, "MCInstanceJump")).displayable(new GroundTelly$autoJumpMode$1());
/*  33 */   private final ListValue eventTargetSelector = new ListValue(
/*  34 */       "EventSelect", new String[] {
/*  35 */         "onUpdate", 
/*  36 */         "onTick"
/*  37 */       }, "onUpdate");
/*     */ 
/*     */   
/*  40 */   private final BoolValue noBobValue = new BoolValue("NoBob", false);
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GroundTelly$Companion$noFovValue$1 extends Lambda implements Function0<Boolean> { public static final GroundTelly$Companion$noFovValue$1 INSTANCE = new GroundTelly$Companion$noFovValue$1();
/*     */     
/*  44 */     public final boolean invoke() { return !Retreat.INSTANCE.getModuleManager().getModule(NoFOV.class).getState(); } GroundTelly$Companion$noFovValue$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GroundTelly$Companion$fovValue$1 extends Lambda implements Function0<Boolean> { public static final GroundTelly$Companion$fovValue$1 INSTANCE = new GroundTelly$Companion$fovValue$1();
/*  47 */     public final boolean invoke() { return (((Boolean)GroundTelly.Companion.getNoFovValue().get()).booleanValue() && !Retreat.INSTANCE.getModuleManager().getModule(NoFOV.class).getState()); } GroundTelly$Companion$fovValue$1() { super(0); } } public static final Companion Companion = new Companion(null); static { noFovValue = (new BoolValue("NoFov", false)).displayable(GroundTelly$Companion$noFovValue$1.INSTANCE); fovValue = (new FloatValue("FOV", 1.0F, 0.0F, 1.5F)).displayable(GroundTelly$Companion$fovValue$1.INSTANCE); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\020\007\n\002\b\006\n\002\020\013\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R*\020\003\032\b\022\004\022\0020\0050\0048\006@\006X\016¢\006\024\n\000\022\004\b\006\020\002\032\004\b\007\020\b\"\004\b\t\020\nR\"\020\013\032\b\022\004\022\0020\f0\0048\006X\004¢\006\016\n\000\022\004\b\r\020\002\032\004\b\016\020\b¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/GroundTelly$Companion;", "", "()V", "fovValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "fovValue$annotations", "getFovValue", "()Lnet/ccbluex/liquidbounce/value/Value;", "setFovValue", "(Lnet/ccbluex/liquidbounce/value/Value;)V", "noFovValue", "", "noFovValue$annotations", "getNoFovValue", "XSJClient"}) public static final class Companion { private Companion() {} @NotNull public final Value<Float> getFovValue() { return GroundTelly.fovValue; } @NotNull public final Value<Boolean> getNoFovValue() { return GroundTelly.noFovValue; } public final void setFovValue(@NotNull Value <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); GroundTelly.fovValue = <set-?>; }
/*     */      }
/*     */   
/*  50 */   private final BoolValue autoTimerValue = new BoolValue("AutoTimer", false);
/*  51 */   private final BoolValue autoPitchValue = new BoolValue("setBestPitch", false);
/*  52 */   private final BoolValue alwaysPitchValue = new BoolValue("setPitch-onUpdate", false);
/*  53 */   private final ListValue autoYawValue = new ListValue("setYawMode", new String[] { "None", "onEnable", "onUpdate" }, "None");
/*  54 */   private final BoolValue disableAllOnEnable = new BoolValue("Enable-DisableAll", false);
/*  55 */   private final BoolValue disableAllOnDisable = new BoolValue("Disable-DisableAll", false); @NotNull
/*     */   private static final Value<Boolean> noFovValue; @NotNull
/*     */   private static Value<Float> fovValue; public void onEnable() {
/*  58 */     if (((Boolean)this.autoPitchValue.get()).booleanValue()) {
/*  59 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setRotationPitch(26.5F);
/*     */     } 
/*  61 */     if (((String)this.autoYawValue.get()).equals("onEnable")) setYaw();
/*     */     
/*  63 */     if (((Boolean)this.disableAllOnEnable.get()).booleanValue()) disableAll(); 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  68 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/*  70 */     if (((Boolean)this.autoPitchValue.get()).booleanValue() && ((Boolean)this.alwaysPitchValue.get()).booleanValue()) {
/*  71 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setRotationPitch(26.5F);
/*     */     } 
/*  73 */     if (((String)this.autoYawValue.get()).equals("onUpdate")) setYaw(); 
/*  74 */     if (((Boolean)this.noBobValue.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setDistanceWalkedModified(0.0F); }
/*  75 */      if (!thePlayer.isSneaking()) {
/*  76 */       IEntityPlayerSP thePlayer2 = MinecraftInstance.mc.getThePlayer();
/*  77 */       if (thePlayer2 == null) {
/*  78 */         Intrinsics.throwNpe();
/*     */       }
/*  80 */       if (thePlayer2.getOnGround()) {
/*  81 */         scaffoldChange(false);
/*  82 */         if (((Boolean)this.autoTimerValue.get()).booleanValue() && Retreat.INSTANCE.getModuleManager().getModule(Timer.class).getState()) Retreat.INSTANCE.getModuleManager().getModule(
/*  83 */               Timer.class).setState(false);
/*     */       
/*     */       } else {
/*  86 */         scaffoldChange(true);
/*  87 */         if (((Boolean)this.autoTimerValue.get()).booleanValue() && !Retreat.INSTANCE.getModuleManager().getModule(Timer.class).getState()) Retreat.INSTANCE.getModuleManager().getModule(
/*  88 */               Timer.class).setState(true);
/*     */       
/*     */       } 
/*     */     } 
/*  92 */     if (((Boolean)this.autoJumpValue.get()).booleanValue() && StringsKt.equals((String)this.eventTargetSelector.get(), "onUpdate", true)) tryJump(); 
/*     */   }
/*     */   
/*     */   private final void jump() {
/*  96 */     String str = (String)this.autoJumpMode.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     
/*     */     { case -2524840:
/*  99 */         if (str.equals("clientmotiony")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.42D); }  break;
/*     */       case 1009554137:
/*     */         if (str.equals("mcinstancejump")) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump(); }  break;
/*     */       case 1179370005:
/*     */         if (str.equals("mcinstance2jump"))
/* 105 */           MinecraftInstance.mc2.field_71439_g.func_70664_aZ();  break; }  } @EventTarget public final void onTick(@NotNull TickEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.autoJumpValue.get()).booleanValue() && StringsKt.equals((String)this.eventTargetSelector.get(), "onTick", true)) tryJump();  }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onDisable() {
/* 110 */     scaffoldChange(false);
/* 111 */     if (((Boolean)this.autoTimerValue.get()).booleanValue() && Retreat.INSTANCE.getModuleManager().getModule(Timer.class).getState()) Retreat.INSTANCE.getModuleManager().getModule(Timer.class).setState(false);
/*     */     
/* 113 */     if (((Boolean)this.disableAllOnDisable.get()).booleanValue()) disableAll(); 
/*     */   }
/*     */   
/*     */   private final void scaffoldChange(boolean state) {
/* 117 */     String str = (String)this.scaffoldModule.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */       case -2047971588:
/* 119 */         if (str.equals("scaffold2")) Retreat.INSTANCE.getModuleManager().getModule(Scaffold2.class).setState(state);  break;
/*     */       case -897347594:
/*     */         if (str.equals("scaffold"))
/*     */           Retreat.INSTANCE.getModuleManager().getModule(Scaffold.class).setState(state); 
/*     */         break;
/* 124 */     }  } private final void tryJump() { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 125 */     String str = (String)this.autoJumpHelper.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 3556498:
/* 148 */         if (str.equals("test") && 
/* 149 */           thePlayer.getOnGround() && MovementUtils.isMoving() && thePlayer.getSprinting())
/* 150 */           jump();  break;
/*     */       case 96267780: if (str.equals("eagle")) { if (MinecraftInstance.mc.getTheWorld() == null)
/*     */             Intrinsics.throwNpe();  if (Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getBlockState(new WBlockPos(thePlayer.getPosX(), thePlayer.getPosY() - 1.0D, thePlayer.getPosZ())).getBlock(), MinecraftInstance.classProvider.getBlockEnum(BlockType.AIR)) && thePlayer.getOnGround())
/*     */             jump();  }  break;
/*     */       case -793195742: if (str.equals("parkour"))
/*     */           if (MovementUtils.isMoving() && thePlayer.getOnGround() && !thePlayer.isSneaking() && !MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown() && !MinecraftInstance.mc.getGameSettings().getKeyBindJump().isKeyDown())
/*     */             if (MinecraftInstance.mc.getTheWorld() == null)
/* 157 */               Intrinsics.throwNpe();    break; }  } private final void disableAll() { Retreat.INSTANCE.getModuleManager().getModule(Scaffold.class).setState(false);
/* 158 */     Retreat.INSTANCE.getModuleManager().getModule(Scaffold2.class).setState(false); }
/*     */ 
/*     */   
/*     */   private final void setYaw() {
/* 162 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/* 163 */     String str = (String)this.autoYawValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str.toLowerCase().equals("none"))
/* 164 */       return;  double x = thePlayer.getMotionX();
/* 165 */     double y = thePlayer.getMotionZ();
/* 166 */     if (MinecraftInstance.mc.getGameSettings().getKeyBindForward().isKeyDown()) {
/*     */       
/* 168 */       if (y > 0.1D)
/*     */       {
/* 170 */         thePlayer.setRotationYaw(0.0F);
/*     */       }
/*     */       
/* 173 */       if (y < -0.1D)
/*     */       {
/* 175 */         thePlayer.setRotationYaw(180.0F);
/*     */       }
/*     */       
/* 178 */       if (x > 0.1D)
/*     */       {
/* 180 */         thePlayer.setRotationYaw(-90.0F);
/*     */       }
/*     */       
/* 183 */       if (x < -0.1D)
/*     */       {
/* 185 */         thePlayer.setRotationYaw(90.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final Value<Boolean> getNoFovValue() {
/*     */     return noFovValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public static final Value<Float> getFovValue() {
/*     */     return fovValue;
/*     */   }
/*     */   
/*     */   public static final void setFovValue(@NotNull Value<Float> <set-?>) {
/*     */     fovValue = <set-?>;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\GroundTelly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */