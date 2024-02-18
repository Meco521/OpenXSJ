/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.math.MathKt;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.event.EventState;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.KeyEvent;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.PlaceRotation;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.PlaceInfo;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "ScaffoldTest", description = "自动搭路Test", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Â\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\013\n\002\020\013\n\002\b\003\n\002\020\t\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\036\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\016\n\002\020\006\n\000\n\002\020\007\n\000\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020c\032\0020d2\006\020e\032\0020fH\002J\020\020g\032\0020h2\006\020i\032\0020\031H\002J\b\020j\032\0020hH\026J\b\020k\032\0020hH\026J\020\020l\032\0020h2\006\020m\032\0020nH\007J\020\020o\032\0020h2\006\020m\032\0020pH\007J\020\020q\032\0020h2\006\020m\032\0020rH\007J\020\020s\032\0020h2\006\020m\032\0020tH\007J\020\020u\032\0020h2\006\020m\032\0020vH\007J\020\020w\032\0020h2\006\020m\032\0020xH\007J\020\020y\032\0020h2\006\020m\032\0020zH\007J\020\020{\032\0020h2\006\020m\032\0020|H\007J\020\020}\032\0020h2\006\020m\032\0020~H\007J\006\020\032\0020hJ\034\020\001\032\0020\0312\b\020\001\032\0030\0012\007\020\001\032\0020\031H\002J\022\020\001\032\0020h2\007\020\001\032\00200H\002J\007\020\001\032\0020hR\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\032\020\016\032\0020\004X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\016\020\023\032\0020\007X\004¢\006\002\n\000R\021\020\024\032\0020\r8F¢\006\006\032\004\b\025\020\026R\016\020\027\032\0020\tX\004¢\006\002\n\000R\016\020\030\032\0020\031X\016¢\006\002\n\000R\016\020\032\032\0020\031X\016¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\035X\016¢\006\002\n\000R\016\020\036\032\0020\037X\004¢\006\002\n\000R\016\020 \032\0020\004X\004¢\006\002\n\000R\016\020!\032\0020\031X\016¢\006\002\n\000R\016\020\"\032\0020\007X\004¢\006\002\n\000R\016\020#\032\0020$X\004¢\006\002\n\000R\016\020%\032\0020\tX\004¢\006\002\n\000R\016\020&\032\0020\031X\016¢\006\002\n\000R\016\020'\032\0020\031X\016¢\006\002\n\000R\016\020(\032\0020\tX\004¢\006\002\n\000R\016\020)\032\0020\tX\004¢\006\002\n\000R\016\020*\032\0020\004X\004¢\006\002\n\000R\016\020+\032\0020,X\004¢\006\002\n\000R\016\020-\032\0020\rX\016¢\006\002\n\000R\016\020.\032\0020\rX\016¢\006\002\n\000R\020\020/\032\004\030\00100X\016¢\006\002\n\000R\016\0201\032\00202X\016¢\006\002\n\000R\016\0203\032\0020\004X\004¢\006\002\n\000R\016\0204\032\0020\tX\004¢\006\002\n\000R\016\0205\032\0020$X\004¢\006\002\n\000R\016\0206\032\0020\tX\004¢\006\002\n\000R\016\0207\032\0020$X\004¢\006\002\n\000R\016\0208\032\0020$X\004¢\006\002\n\000R\016\0209\032\0020\007X\004¢\006\002\n\000R\016\020:\032\0020\031X\016¢\006\002\n\000R\016\020;\032\0020\004X\004¢\006\002\n\000R\016\020<\032\0020\007X\004¢\006\002\n\000R\016\020=\032\0020\004X\004¢\006\002\n\000R\016\020>\032\0020\007X\004¢\006\002\n\000R\016\020?\032\0020\rX\016¢\006\002\n\000R\016\020@\032\0020$X\004¢\006\002\n\000R\016\020A\032\0020\004X\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\004X\004¢\006\002\n\000R\016\020D\032\0020\tX\004¢\006\002\n\000R\016\020E\032\0020\007X\004¢\006\002\n\000R\016\020F\032\0020\004X\004¢\006\002\n\000R\016\020G\032\0020\031X\016¢\006\002\n\000R\016\020H\032\0020\004X\004¢\006\002\n\000R\016\020I\032\0020\rX\016¢\006\002\n\000R\016\020J\032\0020$X\004¢\006\002\n\000R\016\020K\032\0020\004X\004¢\006\002\n\000R\016\020L\032\0020$X\004¢\006\002\n\000R\016\020M\032\0020\007X\004¢\006\002\n\000R\016\020N\032\0020\007X\004¢\006\002\n\000R\016\020O\032\0020\004X\004¢\006\002\n\000R\024\020P\032\0020Q8VX\004¢\006\006\032\004\bR\020SR\020\020T\032\004\030\0010UX\016¢\006\002\n\000R\016\020V\032\0020\rX\016¢\006\002\n\000R\016\020W\032\0020$X\004¢\006\002\n\000R\016\020X\032\0020\004X\004¢\006\002\n\000R\032\020Y\032\0020\004X\016¢\006\016\n\000\032\004\bZ\020\020\"\004\b[\020\022R\016\020\\\032\0020$X\004¢\006\002\n\000R\016\020]\032\0020$X\016¢\006\002\n\000R\016\020^\032\0020\031X\016¢\006\002\n\000R\016\020_\032\0020\007X\004¢\006\002\n\000R\016\020`\032\0020$X\004¢\006\002\n\000R\016\020a\032\0020$X\004¢\006\002\n\000R\016\020b\032\0020\037X\004¢\006\002\n\000¨\006\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "FallFastplace", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Fastplace", "RotConditionValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "Rotairticks", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "airSafeValue", "airticks", "airtime", "", "aparkour", "getAparkour", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "setAparkour", "(Lnet/ccbluex/liquidbounce/value/BoolValue;)V", "autoBlockValue", "blocksAmount", "getBlocksAmount", "()I", "blocksToEagleValue", "canPlace", "", "canRot", "counterDisplayValue", "delay", "", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "downValue", "eagleSneaking", "eagleValue", "edgeDistanceValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "expandLengthValue", "f", "facesBlock", "falldowndelay", "keepLengthValue", "keepRotationValue", "keyName", "Lnet/ccbluex/liquidbounce/value/TextValue;", "keydown", "launchY", "lockRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "lockRotationTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "markValue", "maxDelayValue", "maxTurnSpeedValue", "minDelayValue", "minDistValue", "minTurnSpeedValue", "modeValue", "n", "omniDirectionalExpand", "placeConditionValue", "placeDelay", "placeModeValue", "placedBlocksWithoutEagle", "rotationpitch", "rotationsValue", "safeWalkValue", "sameYValue", "searchAccuracyValue", "searchMode", "searchValue", "shouldGoDown", "silentRotationValue", "slot", "slowSpeed", "slowValue", "speedModifierValue", "sprintModeValue", "strafeMode", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "targetPlace", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "ticks", "timerValue", "timeronground", "up", "getUp", "setUp", "xzRangeValue", "yRangeValue", "zitterDirection", "zitterMode", "zitterSpeed", "zitterStrength", "zitterTimer", "calcStepSize", "", "range", "", "findBlock", "", "expand", "onDisable", "onEnable", "onJump", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onhold", "Lnet/ccbluex/liquidbounce/event/KeyEvent;", "place", "search", "blockPosition", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "raycast", "setRotation", "rotation", "update", "XSJClient"})
/*     */ public final class ScaffoldTest extends Module {
/*  47 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal");
/*  48 */   private final FloatValue rotationpitch = new FloatValue("rotationpitch", 25.0F, -180.0F, 180.0F); @NotNull
/*  49 */   private BoolValue aparkour = new BoolValue("AutoJump", false); @NotNull public final BoolValue getAparkour() { return this.aparkour; } public final void setAparkour(@NotNull BoolValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.aparkour = <set-?>; } @NotNull
/*  50 */   private BoolValue up = new BoolValue("Up", false); @NotNull public final BoolValue getUp() { return this.up; } public final void setUp(@NotNull BoolValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.up = <set-?>; }
/*  51 */    private final TextValue keyName = new TextValue("UpKeyName", "F");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   private final IntegerValue maxDelayValue = new ScaffoldTest$maxDelayValue$1("MaxDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldTest$maxDelayValue$1 extends IntegerValue { ScaffoldTest$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  58 */       int minDelay = ((Number)ScaffoldTest.this.minDelayValue.get()).intValue();
/*  59 */       if (minDelay > newValue) {
/*  60 */         set(Integer.valueOf(minDelay));
/*     */       }
/*     */     } }
/*     */ 
/*     */   
/*  65 */   private final IntegerValue minDelayValue = new ScaffoldTest$minDelayValue$1("MinDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldTest$minDelayValue$1 extends IntegerValue { ScaffoldTest$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  67 */       int maxDelay = ((Number)ScaffoldTest.this.maxDelayValue.get()).intValue();
/*  68 */       if (maxDelay < newValue)
/*  69 */         set(Integer.valueOf(maxDelay)); 
/*     */     } }
/*     */ 
/*     */   
/*  73 */   private final IntegerValue falldowndelay = new IntegerValue("FallDownDelay", 0, 0, 1000);
/*     */   
/*  75 */   private final BoolValue placeDelay = new BoolValue("PlaceDelay", true);
/*     */ 
/*     */   
/*  78 */   private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "Off", "Pick", "Spoof", "Switch" }, "Pick");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private final ListValue sprintModeValue = new ListValue("SprintMode", new String[] { "Normal", "Telly" }, "Telly");
/*  84 */   private final BoolValue swingValue = new BoolValue("Swing", true);
/*  85 */   private final BoolValue searchValue = new BoolValue("Search", true);
/*  86 */   private final BoolValue downValue = new BoolValue("Down", true);
/*  87 */   private final ListValue placeModeValue = new ListValue("PlaceTiming", new String[] { "Pre", "Post" }, "Post");
/*  88 */   private final ListValue placeConditionValue = new ListValue("PlaceCondition", new String[] { "Always", "DelayAir", "FallDown" }, "Always");
/*  89 */   private final ListValue RotConditionValue = new ListValue("RotCondition", new String[] { "Always", "DelayAir", "FallDown" }, "Always");
/*     */   private boolean f;
/*     */   private boolean n;
/*     */   private boolean canPlace;
/*     */   private boolean canRot;
/*     */   private int airtime;
/*  95 */   private final IntegerValue airticks = new IntegerValue("PlaceAirTime", 0, 0, 10);
/*  96 */   private final IntegerValue Rotairticks = new IntegerValue("RotAirTime", 0, 0, 10);
/*     */ 
/*     */   
/*  99 */   private final ListValue eagleValue = new ListValue("Eagle", new String[] { "Normal", "Silent", "Off" }, "Normal");
/* 100 */   private final IntegerValue blocksToEagleValue = new IntegerValue("BlocksToEagle", 0, 0, 10);
/* 101 */   private final FloatValue edgeDistanceValue = new FloatValue("EagleEdgeDistance", 0.0F, 0.0F, 0.5F);
/*     */ 
/*     */   
/* 104 */   private final BoolValue omniDirectionalExpand = new BoolValue("OmniDirectionalExpand", false);
/* 105 */   private final IntegerValue expandLengthValue = new IntegerValue("ExpandLength", 1, 1, 6);
/*     */ 
/*     */   
/* 108 */   private final ListValue strafeMode = new ListValue("Strafe", new String[] { "Off", "AAC" }, "Off");
/* 109 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/* 110 */   private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true);
/* 111 */   private final BoolValue keepRotationValue = new BoolValue("KeepRotation", true);
/* 112 */   private final IntegerValue keepLengthValue = new IntegerValue("KeepRotationLength", 0, 0, 20);
/*     */ 
/*     */ 
/*     */   
/* 116 */   private final ListValue searchMode = new ListValue("XYZSearch", new String[] { "Auto", "AutoCenter" }, "AutoCenter");
/* 117 */   private final FloatValue xzRangeValue = new FloatValue("xzRange", 0.8F, 0.0F, 1.0F);
/* 118 */   private FloatValue yRangeValue = new FloatValue("yRange", 0.8F, 0.0F, 1.0F);
/* 119 */   private final FloatValue minDistValue = new FloatValue("MinDist", 0.0F, 0.0F, 0.2F);
/*     */ 
/*     */   
/* 122 */   private final IntegerValue searchAccuracyValue = new ScaffoldTest$searchAccuracyValue$1("SearchAccuracy", 8, 1, 16); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest$searchAccuracyValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldTest$searchAccuracyValue$1 extends IntegerValue { ScaffoldTest$searchAccuracyValue$1(String $super_call_param$0, int $super_call_param$1, int $super_call_param$2, int $super_call_param$3) { super($super_call_param$0, $super_call_param$1, $super_call_param$2, $super_call_param$3); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/* 124 */       if (getMaximum() < newValue) {
/* 125 */         set(Integer.valueOf(getMaximum()));
/* 126 */       } else if (getMinimum() > newValue) {
/* 127 */         set(Integer.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/* 133 */   private final FloatValue maxTurnSpeedValue = new ScaffoldTest$maxTurnSpeedValue$1("MaxTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest$maxTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldTest$maxTurnSpeedValue$1 extends FloatValue { ScaffoldTest$maxTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 135 */       float v = ((Number)ScaffoldTest.this.minTurnSpeedValue.get()).floatValue();
/* 136 */       if (v > newValue) set(Float.valueOf(v)); 
/* 137 */       if (getMaximum() < newValue) {
/* 138 */         set(Float.valueOf(getMaximum()));
/* 139 */       } else if (getMinimum() > newValue) {
/* 140 */         set(Float.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */   
/* 144 */   private final FloatValue minTurnSpeedValue = new ScaffoldTest$minTurnSpeedValue$1("MinTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest$minTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldTest$minTurnSpeedValue$1 extends FloatValue { ScaffoldTest$minTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 146 */       float v = ((Number)ScaffoldTest.this.maxTurnSpeedValue.get()).floatValue();
/* 147 */       if (v < newValue) set(Float.valueOf(v)); 
/* 148 */       if (getMaximum() < newValue) {
/* 149 */         set(Float.valueOf(getMaximum()));
/* 150 */       } else if (getMinimum() > newValue) {
/* 151 */         set(Float.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/* 157 */   private final ListValue zitterMode = new ListValue("Zitter", new String[] { "Off", "Teleport", "Smooth" }, "Off");
/* 158 */   private final FloatValue zitterSpeed = new FloatValue("ZitterSpeed", 0.13F, 0.1F, 0.3F);
/* 159 */   private final FloatValue zitterStrength = new FloatValue("ZitterStrength", 0.05F, 0.0F, 0.2F);
/*     */ 
/*     */   
/* 162 */   private final FloatValue timerValue = new FloatValue("Timer", 1.0F, 0.1F, 10.0F);
/* 163 */   private final BoolValue timeronground = new BoolValue("Timeronground", false);
/* 164 */   private final FloatValue speedModifierValue = new FloatValue("SpeedModifier", 1.0F, 0.0F, 2.0F);
/* 165 */   private final BoolValue slowValue = new BoolValue("Slow", false);
/* 166 */   private final FloatValue slowSpeed = new FloatValue("SlowSpeed", 0.6F, 0.2F, 0.8F);
/*     */ 
/*     */   
/* 169 */   private final BoolValue sameYValue = new BoolValue("SameY", false);
/* 170 */   private final BoolValue safeWalkValue = new BoolValue("SafeWalk", true);
/* 171 */   private final BoolValue airSafeValue = new BoolValue("AirSafe", false);
/* 172 */   private final BoolValue FallFastplace = new BoolValue("Fallfastplace", false);
/* 173 */   private final BoolValue Fastplace = new BoolValue("fastplace", false);
/*     */   
/* 175 */   private final BoolValue counterDisplayValue = new BoolValue("Counter", true);
/* 176 */   private final BoolValue markValue = new BoolValue("Mark", false);
/*     */ 
/*     */   
/*     */   private PlaceInfo targetPlace;
/*     */   
/*     */   private Rotation lockRotation;
/*     */   
/* 183 */   private TickTimer lockRotationTimer = new TickTimer();
/*     */ 
/*     */   
/*     */   private int launchY;
/*     */ 
/*     */   
/*     */   private boolean facesBlock;
/*     */ 
/*     */   
/*     */   private int slot;
/*     */   
/*     */   private boolean zitterDirection;
/*     */   
/* 196 */   private final MSTimer delayTimer = new MSTimer();
/* 197 */   private final MSTimer zitterTimer = new MSTimer();
/*     */   
/*     */   private long delay;
/*     */   
/*     */   private int ticks;
/*     */   
/*     */   private int placedBlocksWithoutEagle;
/*     */   
/*     */   private boolean eagleSneaking;
/*     */   
/*     */   private boolean shouldGoDown;
/*     */   private int keydown;
/*     */   
/*     */   public void onEnable()
/*     */   {
/* 212 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 213 */       this.canPlace = false;
/* 214 */       this.canRot = false;
/* 215 */       this.f = false;
/* 216 */       this.airtime = 0;
/* 217 */       this.launchY = MathKt.roundToInt(player.getPosY());
/* 218 */       this.slot = player.getInventory().getCurrentItem();
/* 219 */       this.facesBlock = false;
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 224 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.ticks = 1;
/* 225 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { int i; this.airtime = (i = this.airtime) + 1; }
/*     */   
/*     */   } @EventTarget
/*     */   public final void onhold(@NotNull KeyEvent event) {
/* 229 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str1 = (String)this.keyName.get(); int i = event.getKey(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toUpperCase(), "(this as java.lang.String).toUpperCase()"); String str2 = str1.toUpperCase(); if (i == Keyboard.getKeyIndex(str2) && MinecraftInstance.mc.getGameSettings().getKeyBindForward().isKeyDown()) {
/* 230 */       this.keydown = 1;
/*     */     } else {
/* 232 */       this.keydown = 0;
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
/*     */     //   24: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   27: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   32: invokeinterface getKeyBindBack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   37: iconst_0
/*     */     //   38: invokeinterface setPressed : (Z)V
/*     */     //   43: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   46: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   51: dup
/*     */     //   52: ifnonnull -> 58
/*     */     //   55: invokestatic throwNpe : ()V
/*     */     //   58: aload_0
/*     */     //   59: getfield rotationpitch : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   62: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   65: checkcast java/lang/Number
/*     */     //   68: invokevirtual floatValue : ()F
/*     */     //   71: invokeinterface setRotationPitch : (F)V
/*     */     //   76: aload_0
/*     */     //   77: getfield aparkour : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   80: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   83: checkcast java/lang/Boolean
/*     */     //   86: invokevirtual booleanValue : ()Z
/*     */     //   89: ifeq -> 245
/*     */     //   92: invokestatic isMoving : ()Z
/*     */     //   95: ifeq -> 201
/*     */     //   98: aload_2
/*     */     //   99: invokeinterface getOnGround : ()Z
/*     */     //   104: ifeq -> 201
/*     */     //   107: aload_2
/*     */     //   108: invokeinterface isSneaking : ()Z
/*     */     //   113: ifne -> 201
/*     */     //   116: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   119: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   124: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   129: invokeinterface isKeyDown : ()Z
/*     */     //   134: ifne -> 201
/*     */     //   137: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   140: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   145: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   150: invokeinterface isKeyDown : ()Z
/*     */     //   155: ifne -> 201
/*     */     //   158: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   161: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   166: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   171: invokeinterface isKeyDown : ()Z
/*     */     //   176: ifeq -> 201
/*     */     //   179: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   182: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   187: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   192: iconst_1
/*     */     //   193: invokeinterface setPressed : (Z)V
/*     */     //   198: goto -> 245
/*     */     //   201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   204: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   209: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   214: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   217: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   222: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   225: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   230: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   235: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   240: invokeinterface setPressed : (Z)V
/*     */     //   245: aload_0
/*     */     //   246: getfield up : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   249: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   252: checkcast java/lang/Boolean
/*     */     //   255: invokevirtual booleanValue : ()Z
/*     */     //   258: ifeq -> 377
/*     */     //   261: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   264: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   269: dup
/*     */     //   270: ifnonnull -> 276
/*     */     //   273: invokestatic throwNpe : ()V
/*     */     //   276: invokeinterface getOnGround : ()Z
/*     */     //   281: ifeq -> 377
/*     */     //   284: aload_0
/*     */     //   285: getfield keydown : I
/*     */     //   288: iconst_1
/*     */     //   289: if_icmpne -> 336
/*     */     //   292: aload_0
/*     */     //   293: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   296: ldc_w 'Always'
/*     */     //   299: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   302: aload_0
/*     */     //   303: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   306: ldc_w 'Always'
/*     */     //   309: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   312: aload_0
/*     */     //   313: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   316: iconst_0
/*     */     //   317: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   320: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   323: aload_0
/*     */     //   324: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   327: ldc_w 'Normal'
/*     */     //   330: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   333: goto -> 377
/*     */     //   336: aload_0
/*     */     //   337: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   340: iconst_1
/*     */     //   341: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   344: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   347: aload_0
/*     */     //   348: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   351: ldc_w 'DelayAir'
/*     */     //   354: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   357: aload_0
/*     */     //   358: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   361: ldc_w 'DelayAir'
/*     */     //   364: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   367: aload_0
/*     */     //   368: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   371: ldc_w 'Telly'
/*     */     //   374: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   377: aload_2
/*     */     //   378: invokeinterface getOnGround : ()Z
/*     */     //   383: ifne -> 401
/*     */     //   386: aload_0
/*     */     //   387: dup
/*     */     //   388: getfield airtime : I
/*     */     //   391: dup
/*     */     //   392: istore_3
/*     */     //   393: iconst_1
/*     */     //   394: iadd
/*     */     //   395: putfield airtime : I
/*     */     //   398: goto -> 516
/*     */     //   401: aload_0
/*     */     //   402: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   405: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   408: checkcast java/lang/String
/*     */     //   411: ldc_w 'falldown'
/*     */     //   414: iconst_1
/*     */     //   415: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   418: ifne -> 441
/*     */     //   421: aload_0
/*     */     //   422: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   425: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   428: checkcast java/lang/String
/*     */     //   431: ldc_w 'delayair'
/*     */     //   434: iconst_1
/*     */     //   435: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   438: ifeq -> 511
/*     */     //   441: aload_0
/*     */     //   442: lconst_0
/*     */     //   443: putfield delay : J
/*     */     //   446: aload_0
/*     */     //   447: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   450: invokevirtual reset : ()V
/*     */     //   453: aload_0
/*     */     //   454: iconst_0
/*     */     //   455: putfield eagleSneaking : Z
/*     */     //   458: aload_0
/*     */     //   459: iconst_0
/*     */     //   460: putfield shouldGoDown : Z
/*     */     //   463: aload_0
/*     */     //   464: iconst_0
/*     */     //   465: putfield canPlace : Z
/*     */     //   468: aload_0
/*     */     //   469: iconst_0
/*     */     //   470: putfield canRot : Z
/*     */     //   473: aload_0
/*     */     //   474: iconst_0
/*     */     //   475: putfield f : Z
/*     */     //   478: aload_0
/*     */     //   479: aload_2
/*     */     //   480: invokeinterface getPosY : ()D
/*     */     //   485: invokestatic roundToInt : (D)I
/*     */     //   488: putfield launchY : I
/*     */     //   491: aload_0
/*     */     //   492: aload_2
/*     */     //   493: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   498: invokeinterface getCurrentItem : ()I
/*     */     //   503: putfield slot : I
/*     */     //   506: aload_0
/*     */     //   507: iconst_0
/*     */     //   508: putfield facesBlock : Z
/*     */     //   511: aload_0
/*     */     //   512: iconst_0
/*     */     //   513: putfield airtime : I
/*     */     //   516: aload_0
/*     */     //   517: aload_0
/*     */     //   518: getfield airtime : I
/*     */     //   521: aload_0
/*     */     //   522: getfield airticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   525: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   528: checkcast java/lang/Number
/*     */     //   531: invokevirtual intValue : ()I
/*     */     //   534: if_icmple -> 541
/*     */     //   537: iconst_1
/*     */     //   538: goto -> 542
/*     */     //   541: iconst_0
/*     */     //   542: putfield f : Z
/*     */     //   545: aload_0
/*     */     //   546: aload_0
/*     */     //   547: getfield airtime : I
/*     */     //   550: aload_0
/*     */     //   551: getfield Rotairticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   554: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   557: checkcast java/lang/Number
/*     */     //   560: invokevirtual intValue : ()I
/*     */     //   563: if_icmple -> 570
/*     */     //   566: iconst_1
/*     */     //   567: goto -> 571
/*     */     //   570: iconst_0
/*     */     //   571: putfield n : Z
/*     */     //   574: aload_0
/*     */     //   575: getfield timeronground : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   578: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   581: checkcast java/lang/Boolean
/*     */     //   584: invokevirtual booleanValue : ()Z
/*     */     //   587: ifeq -> 613
/*     */     //   590: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   593: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   598: dup
/*     */     //   599: ifnonnull -> 605
/*     */     //   602: invokestatic throwNpe : ()V
/*     */     //   605: invokeinterface getOnGround : ()Z
/*     */     //   610: ifne -> 629
/*     */     //   613: aload_0
/*     */     //   614: getfield timeronground : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   617: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   620: checkcast java/lang/Boolean
/*     */     //   623: invokevirtual booleanValue : ()Z
/*     */     //   626: ifne -> 655
/*     */     //   629: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   632: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   637: aload_0
/*     */     //   638: getfield timerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   641: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   644: checkcast java/lang/Number
/*     */     //   647: invokevirtual floatValue : ()F
/*     */     //   650: invokeinterface setTimerSpeed : (F)V
/*     */     //   655: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   658: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   663: dup
/*     */     //   664: ifnonnull -> 670
/*     */     //   667: invokestatic throwNpe : ()V
/*     */     //   670: invokeinterface getOnGround : ()Z
/*     */     //   675: ifeq -> 683
/*     */     //   678: aload_0
/*     */     //   679: iconst_0
/*     */     //   680: putfield ticks : I
/*     */     //   683: aload_0
/*     */     //   684: aload_0
/*     */     //   685: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   688: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   691: checkcast java/lang/String
/*     */     //   694: ldc_w 'falldown'
/*     */     //   697: iconst_1
/*     */     //   698: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   701: ifeq -> 730
/*     */     //   704: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   707: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   712: dup
/*     */     //   713: ifnonnull -> 719
/*     */     //   716: invokestatic throwNpe : ()V
/*     */     //   719: invokeinterface getFallDistance : ()F
/*     */     //   724: iconst_0
/*     */     //   725: i2f
/*     */     //   726: fcmpl
/*     */     //   727: ifgt -> 800
/*     */     //   730: aload_0
/*     */     //   731: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   734: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   737: checkcast java/lang/String
/*     */     //   740: ldc_w 'always'
/*     */     //   743: iconst_1
/*     */     //   744: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   747: ifne -> 800
/*     */     //   750: aload_0
/*     */     //   751: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   754: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   757: checkcast java/lang/String
/*     */     //   760: ldc_w 'delayair'
/*     */     //   763: iconst_1
/*     */     //   764: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   767: ifeq -> 804
/*     */     //   770: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   773: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   778: dup
/*     */     //   779: ifnonnull -> 785
/*     */     //   782: invokestatic throwNpe : ()V
/*     */     //   785: invokeinterface getOnGround : ()Z
/*     */     //   790: ifne -> 804
/*     */     //   793: aload_0
/*     */     //   794: getfield f : Z
/*     */     //   797: ifeq -> 804
/*     */     //   800: iconst_1
/*     */     //   801: goto -> 805
/*     */     //   804: iconst_0
/*     */     //   805: putfield canPlace : Z
/*     */     //   808: aload_0
/*     */     //   809: aload_0
/*     */     //   810: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   813: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   816: checkcast java/lang/String
/*     */     //   819: ldc_w 'falldown'
/*     */     //   822: iconst_1
/*     */     //   823: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   826: ifeq -> 855
/*     */     //   829: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   832: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   837: dup
/*     */     //   838: ifnonnull -> 844
/*     */     //   841: invokestatic throwNpe : ()V
/*     */     //   844: invokeinterface getFallDistance : ()F
/*     */     //   849: iconst_0
/*     */     //   850: i2f
/*     */     //   851: fcmpl
/*     */     //   852: ifgt -> 925
/*     */     //   855: aload_0
/*     */     //   856: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   859: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   862: checkcast java/lang/String
/*     */     //   865: ldc_w 'always'
/*     */     //   868: iconst_1
/*     */     //   869: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   872: ifne -> 925
/*     */     //   875: aload_0
/*     */     //   876: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   879: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   882: checkcast java/lang/String
/*     */     //   885: ldc_w 'delayair'
/*     */     //   888: iconst_1
/*     */     //   889: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   892: ifeq -> 929
/*     */     //   895: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   898: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   903: dup
/*     */     //   904: ifnonnull -> 910
/*     */     //   907: invokestatic throwNpe : ()V
/*     */     //   910: invokeinterface getOnGround : ()Z
/*     */     //   915: ifne -> 929
/*     */     //   918: aload_0
/*     */     //   919: getfield n : Z
/*     */     //   922: ifeq -> 929
/*     */     //   925: iconst_1
/*     */     //   926: goto -> 930
/*     */     //   929: iconst_0
/*     */     //   930: putfield canRot : Z
/*     */     //   933: aload_0
/*     */     //   934: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   937: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   940: checkcast java/lang/String
/*     */     //   943: ldc_w 'Telly'
/*     */     //   946: iconst_1
/*     */     //   947: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   950: ifeq -> 961
/*     */     //   953: aload_0
/*     */     //   954: getfield ticks : I
/*     */     //   957: iconst_1
/*     */     //   958: if_icmpeq -> 981
/*     */     //   961: aload_0
/*     */     //   962: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   965: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   968: checkcast java/lang/String
/*     */     //   971: ldc_w 'off'
/*     */     //   974: iconst_1
/*     */     //   975: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   978: ifeq -> 1005
/*     */     //   981: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   984: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   989: dup
/*     */     //   990: ifnonnull -> 996
/*     */     //   993: invokestatic throwNpe : ()V
/*     */     //   996: iconst_0
/*     */     //   997: invokeinterface setSprinting : (Z)V
/*     */     //   1002: goto -> 1046
/*     */     //   1005: aload_0
/*     */     //   1006: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1009: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1012: checkcast java/lang/String
/*     */     //   1015: ldc_w 'Telly'
/*     */     //   1018: iconst_1
/*     */     //   1019: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1022: ifeq -> 1046
/*     */     //   1025: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1028: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1033: dup
/*     */     //   1034: ifnonnull -> 1040
/*     */     //   1037: invokestatic throwNpe : ()V
/*     */     //   1040: iconst_1
/*     */     //   1041: invokeinterface setSprinting : (Z)V
/*     */     //   1046: aload_0
/*     */     //   1047: aload_0
/*     */     //   1048: getfield downValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1051: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1054: checkcast java/lang/Boolean
/*     */     //   1057: invokevirtual booleanValue : ()Z
/*     */     //   1060: ifeq -> 1106
/*     */     //   1063: aload_0
/*     */     //   1064: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1067: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1070: checkcast java/lang/Boolean
/*     */     //   1073: invokevirtual booleanValue : ()Z
/*     */     //   1076: ifne -> 1106
/*     */     //   1079: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1082: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1085: getfield field_74311_E : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1088: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1091: ifeq -> 1106
/*     */     //   1094: aload_0
/*     */     //   1095: invokevirtual getBlocksAmount : ()I
/*     */     //   1098: iconst_1
/*     */     //   1099: if_icmple -> 1106
/*     */     //   1102: iconst_1
/*     */     //   1103: goto -> 1107
/*     */     //   1106: iconst_0
/*     */     //   1107: putfield shouldGoDown : Z
/*     */     //   1110: aload_0
/*     */     //   1111: getfield shouldGoDown : Z
/*     */     //   1114: ifeq -> 1136
/*     */     //   1117: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1120: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1125: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1130: iconst_0
/*     */     //   1131: invokeinterface setPressed : (Z)V
/*     */     //   1136: aload_0
/*     */     //   1137: getfield slowValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1140: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1143: checkcast java/lang/Boolean
/*     */     //   1146: invokevirtual booleanValue : ()Z
/*     */     //   1149: ifeq -> 1204
/*     */     //   1152: aload_2
/*     */     //   1153: aload_2
/*     */     //   1154: invokeinterface getMotionX : ()D
/*     */     //   1159: aload_0
/*     */     //   1160: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1163: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1166: checkcast java/lang/Number
/*     */     //   1169: invokevirtual doubleValue : ()D
/*     */     //   1172: dmul
/*     */     //   1173: invokeinterface setMotionX : (D)V
/*     */     //   1178: aload_2
/*     */     //   1179: aload_2
/*     */     //   1180: invokeinterface getMotionZ : ()D
/*     */     //   1185: aload_0
/*     */     //   1186: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1189: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1192: checkcast java/lang/Number
/*     */     //   1195: invokevirtual doubleValue : ()D
/*     */     //   1198: dmul
/*     */     //   1199: invokeinterface setMotionZ : (D)V
/*     */     //   1204: aload_0
/*     */     //   1205: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1208: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1211: checkcast java/lang/String
/*     */     //   1214: ldc_w 'Off'
/*     */     //   1217: iconst_1
/*     */     //   1218: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1221: ifne -> 1683
/*     */     //   1224: aload_0
/*     */     //   1225: getfield shouldGoDown : Z
/*     */     //   1228: ifne -> 1683
/*     */     //   1231: ldc2_w 0.5
/*     */     //   1234: dstore_3
/*     */     //   1235: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1238: dup
/*     */     //   1239: aload_2
/*     */     //   1240: invokeinterface getPosX : ()D
/*     */     //   1245: aload_2
/*     */     //   1246: invokeinterface getPosY : ()D
/*     */     //   1251: dconst_1
/*     */     //   1252: dsub
/*     */     //   1253: aload_2
/*     */     //   1254: invokeinterface getPosZ : ()D
/*     */     //   1259: invokespecial <init> : (DDD)V
/*     */     //   1262: astore #5
/*     */     //   1264: aload_0
/*     */     //   1265: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1268: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1271: checkcast java/lang/Number
/*     */     //   1274: invokevirtual floatValue : ()F
/*     */     //   1277: iconst_0
/*     */     //   1278: i2f
/*     */     //   1279: fcmpl
/*     */     //   1280: ifle -> 1473
/*     */     //   1283: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1286: astore #8
/*     */     //   1288: aload #8
/*     */     //   1290: arraylength
/*     */     //   1291: istore #9
/*     */     //   1293: iconst_0
/*     */     //   1294: istore #7
/*     */     //   1296: iload #7
/*     */     //   1298: iload #9
/*     */     //   1300: if_icmpge -> 1473
/*     */     //   1303: aload #8
/*     */     //   1305: iload #7
/*     */     //   1307: aaload
/*     */     //   1308: astore #6
/*     */     //   1310: aload #6
/*     */     //   1312: getstatic net/minecraft/util/EnumFacing.UP : Lnet/minecraft/util/EnumFacing;
/*     */     //   1315: if_acmpeq -> 1326
/*     */     //   1318: aload #6
/*     */     //   1320: getstatic net/minecraft/util/EnumFacing.DOWN : Lnet/minecraft/util/EnumFacing;
/*     */     //   1323: if_acmpne -> 1329
/*     */     //   1326: goto -> 1467
/*     */     //   1329: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1332: aload #6
/*     */     //   1334: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1339: astore #10
/*     */     //   1341: aload #5
/*     */     //   1343: aload #10
/*     */     //   1345: iconst_0
/*     */     //   1346: iconst_2
/*     */     //   1347: aconst_null
/*     */     //   1348: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1351: astore #11
/*     */     //   1353: iconst_0
/*     */     //   1354: istore #12
/*     */     //   1356: aload #11
/*     */     //   1358: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1361: dup
/*     */     //   1362: ifnull -> 1373
/*     */     //   1365: invokeinterface isReplaceable : ()Z
/*     */     //   1370: goto -> 1375
/*     */     //   1373: pop
/*     */     //   1374: iconst_0
/*     */     //   1375: ifeq -> 1467
/*     */     //   1378: aload #6
/*     */     //   1380: getstatic net/minecraft/util/EnumFacing.NORTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   1383: if_acmpeq -> 1394
/*     */     //   1386: aload #6
/*     */     //   1388: getstatic net/minecraft/util/EnumFacing.SOUTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   1391: if_acmpne -> 1424
/*     */     //   1394: aload #11
/*     */     //   1396: invokevirtual getZ : ()I
/*     */     //   1399: i2d
/*     */     //   1400: ldc2_w 0.5
/*     */     //   1403: dadd
/*     */     //   1404: aload_2
/*     */     //   1405: invokeinterface getPosZ : ()D
/*     */     //   1410: dsub
/*     */     //   1411: dstore #14
/*     */     //   1413: iconst_0
/*     */     //   1414: istore #16
/*     */     //   1416: dload #14
/*     */     //   1418: invokestatic abs : (D)D
/*     */     //   1421: goto -> 1451
/*     */     //   1424: aload #11
/*     */     //   1426: invokevirtual getX : ()I
/*     */     //   1429: i2d
/*     */     //   1430: ldc2_w 0.5
/*     */     //   1433: dadd
/*     */     //   1434: aload_2
/*     */     //   1435: invokeinterface getPosX : ()D
/*     */     //   1440: dsub
/*     */     //   1441: dstore #14
/*     */     //   1443: iconst_0
/*     */     //   1444: istore #16
/*     */     //   1446: dload #14
/*     */     //   1448: invokestatic abs : (D)D
/*     */     //   1451: ldc2_w 0.5
/*     */     //   1454: dsub
/*     */     //   1455: dstore #12
/*     */     //   1457: dload #12
/*     */     //   1459: dload_3
/*     */     //   1460: dcmpg
/*     */     //   1461: ifge -> 1467
/*     */     //   1464: dload #12
/*     */     //   1466: dstore_3
/*     */     //   1467: iinc #7, 1
/*     */     //   1470: goto -> 1296
/*     */     //   1473: aload_0
/*     */     //   1474: getfield placedBlocksWithoutEagle : I
/*     */     //   1477: aload_0
/*     */     //   1478: getfield blocksToEagleValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1481: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1484: checkcast java/lang/Number
/*     */     //   1487: invokevirtual intValue : ()I
/*     */     //   1490: if_icmplt -> 1670
/*     */     //   1493: iconst_0
/*     */     //   1494: istore #7
/*     */     //   1496: aload #5
/*     */     //   1498: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1501: dup
/*     */     //   1502: ifnull -> 1513
/*     */     //   1505: invokeinterface isReplaceable : ()Z
/*     */     //   1510: goto -> 1515
/*     */     //   1513: pop
/*     */     //   1514: iconst_0
/*     */     //   1515: ifne -> 1555
/*     */     //   1518: aload_0
/*     */     //   1519: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1522: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1525: checkcast java/lang/Number
/*     */     //   1528: invokevirtual floatValue : ()F
/*     */     //   1531: iconst_0
/*     */     //   1532: i2f
/*     */     //   1533: fcmpl
/*     */     //   1534: ifle -> 1559
/*     */     //   1537: dload_3
/*     */     //   1538: aload_0
/*     */     //   1539: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1542: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1545: checkcast java/lang/Number
/*     */     //   1548: invokevirtual doubleValue : ()D
/*     */     //   1551: dcmpg
/*     */     //   1552: ifge -> 1559
/*     */     //   1555: iconst_1
/*     */     //   1556: goto -> 1560
/*     */     //   1559: iconst_0
/*     */     //   1560: istore #6
/*     */     //   1562: aload_0
/*     */     //   1563: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1566: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1569: checkcast java/lang/String
/*     */     //   1572: ldc_w 'Silent'
/*     */     //   1575: iconst_1
/*     */     //   1576: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1579: ifeq -> 1642
/*     */     //   1582: aload_0
/*     */     //   1583: getfield eagleSneaking : Z
/*     */     //   1586: iload #6
/*     */     //   1588: if_icmpeq -> 1633
/*     */     //   1591: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1594: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1599: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1602: aload_2
/*     */     //   1603: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   1606: iload #6
/*     */     //   1608: ifeq -> 1617
/*     */     //   1611: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1614: goto -> 1620
/*     */     //   1617: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1620: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   1625: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1628: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1633: aload_0
/*     */     //   1634: iload #6
/*     */     //   1636: putfield eagleSneaking : Z
/*     */     //   1639: goto -> 1662
/*     */     //   1642: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1645: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1650: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1655: iload #6
/*     */     //   1657: invokeinterface setPressed : (Z)V
/*     */     //   1662: aload_0
/*     */     //   1663: iconst_0
/*     */     //   1664: putfield placedBlocksWithoutEagle : I
/*     */     //   1667: goto -> 1683
/*     */     //   1670: aload_0
/*     */     //   1671: dup
/*     */     //   1672: getfield placedBlocksWithoutEagle : I
/*     */     //   1675: dup
/*     */     //   1676: istore #6
/*     */     //   1678: iconst_1
/*     */     //   1679: iadd
/*     */     //   1680: putfield placedBlocksWithoutEagle : I
/*     */     //   1683: aload_2
/*     */     //   1684: invokeinterface getOnGround : ()Z
/*     */     //   1689: ifeq -> 2248
/*     */     //   1692: aload_0
/*     */     //   1693: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1696: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1699: checkcast java/lang/String
/*     */     //   1702: astore_3
/*     */     //   1703: iconst_0
/*     */     //   1704: istore #4
/*     */     //   1706: aload_3
/*     */     //   1707: dup
/*     */     //   1708: ifnonnull -> 1722
/*     */     //   1711: new kotlin/TypeCastException
/*     */     //   1714: dup
/*     */     //   1715: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1718: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1721: athrow
/*     */     //   1722: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1725: dup
/*     */     //   1726: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1729: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1732: astore_3
/*     */     //   1733: aload_3
/*     */     //   1734: invokevirtual hashCode : ()I
/*     */     //   1737: tableswitch default -> 1779, 1388740000 -> 1756
/*     */     //   1756: aload_3
/*     */     //   1757: ldc_w 'rewinside'
/*     */     //   1760: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1763: ifeq -> 1779
/*     */     //   1766: ldc_w 0.2
/*     */     //   1769: invokestatic strafe : (F)V
/*     */     //   1772: aload_2
/*     */     //   1773: dconst_0
/*     */     //   1774: invokeinterface setMotionY : (D)V
/*     */     //   1779: aload_0
/*     */     //   1780: getfield zitterMode : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1783: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1786: checkcast java/lang/String
/*     */     //   1789: astore_3
/*     */     //   1790: iconst_0
/*     */     //   1791: istore #4
/*     */     //   1793: aload_3
/*     */     //   1794: dup
/*     */     //   1795: ifnonnull -> 1809
/*     */     //   1798: new kotlin/TypeCastException
/*     */     //   1801: dup
/*     */     //   1802: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1805: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1808: athrow
/*     */     //   1809: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1812: dup
/*     */     //   1813: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1816: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1819: astore_3
/*     */     //   1820: aload_3
/*     */     //   1821: invokevirtual hashCode : ()I
/*     */     //   1824: lookupswitch default -> 2248, -1360201941 -> 1860, -898533970 -> 1886, 109935 -> 1873
/*     */     //   1860: aload_3
/*     */     //   1861: ldc_w 'teleport'
/*     */     //   1864: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1867: ifeq -> 2248
/*     */     //   1870: goto -> 2093
/*     */     //   1873: aload_3
/*     */     //   1874: ldc_w 'off'
/*     */     //   1877: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1880: ifeq -> 2248
/*     */     //   1883: goto -> 1899
/*     */     //   1886: aload_3
/*     */     //   1887: ldc_w 'smooth'
/*     */     //   1890: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1893: ifeq -> 2248
/*     */     //   1896: goto -> 1900
/*     */     //   1899: return
/*     */     //   1900: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1903: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1906: getfield field_74366_z : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1909: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1912: ifne -> 1934
/*     */     //   1915: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1918: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1923: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1928: iconst_0
/*     */     //   1929: invokeinterface setPressed : (Z)V
/*     */     //   1934: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1937: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1940: getfield field_74370_x : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1943: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1946: ifne -> 1968
/*     */     //   1949: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1952: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1957: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1962: iconst_0
/*     */     //   1963: invokeinterface setPressed : (Z)V
/*     */     //   1968: aload_0
/*     */     //   1969: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1972: ldc2_w 100
/*     */     //   1975: invokevirtual hasTimePassed : (J)Z
/*     */     //   1978: ifeq -> 2004
/*     */     //   1981: aload_0
/*     */     //   1982: aload_0
/*     */     //   1983: getfield zitterDirection : Z
/*     */     //   1986: ifne -> 1993
/*     */     //   1989: iconst_1
/*     */     //   1990: goto -> 1994
/*     */     //   1993: iconst_0
/*     */     //   1994: putfield zitterDirection : Z
/*     */     //   1997: aload_0
/*     */     //   1998: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   2001: invokevirtual reset : ()V
/*     */     //   2004: aload_0
/*     */     //   2005: getfield zitterDirection : Z
/*     */     //   2008: ifeq -> 2052
/*     */     //   2011: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2014: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2019: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2024: iconst_1
/*     */     //   2025: invokeinterface setPressed : (Z)V
/*     */     //   2030: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2033: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2038: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2043: iconst_0
/*     */     //   2044: invokeinterface setPressed : (Z)V
/*     */     //   2049: goto -> 2248
/*     */     //   2052: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2055: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2060: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2065: iconst_0
/*     */     //   2066: invokeinterface setPressed : (Z)V
/*     */     //   2071: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2074: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   2079: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   2084: iconst_1
/*     */     //   2085: invokeinterface setPressed : (Z)V
/*     */     //   2090: goto -> 2248
/*     */     //   2093: aload_0
/*     */     //   2094: getfield zitterSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2097: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2100: checkcast java/lang/Number
/*     */     //   2103: invokevirtual floatValue : ()F
/*     */     //   2106: invokestatic strafe : (F)V
/*     */     //   2109: aload_2
/*     */     //   2110: invokeinterface getRotationYaw : ()F
/*     */     //   2115: f2d
/*     */     //   2116: aload_0
/*     */     //   2117: getfield zitterDirection : Z
/*     */     //   2120: ifeq -> 2129
/*     */     //   2123: ldc2_w 90.0
/*     */     //   2126: goto -> 2132
/*     */     //   2129: ldc2_w -90.0
/*     */     //   2132: dadd
/*     */     //   2133: invokestatic toRadians : (D)D
/*     */     //   2136: dstore #4
/*     */     //   2138: aload_2
/*     */     //   2139: aload_2
/*     */     //   2140: invokeinterface getMotionX : ()D
/*     */     //   2145: dstore #18
/*     */     //   2147: astore #17
/*     */     //   2149: iconst_0
/*     */     //   2150: istore #6
/*     */     //   2152: dload #4
/*     */     //   2154: invokestatic sin : (D)D
/*     */     //   2157: dstore #20
/*     */     //   2159: aload #17
/*     */     //   2161: dload #18
/*     */     //   2163: dload #20
/*     */     //   2165: aload_0
/*     */     //   2166: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2169: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2172: checkcast java/lang/Number
/*     */     //   2175: invokevirtual doubleValue : ()D
/*     */     //   2178: dmul
/*     */     //   2179: dsub
/*     */     //   2180: invokeinterface setMotionX : (D)V
/*     */     //   2185: aload_2
/*     */     //   2186: aload_2
/*     */     //   2187: invokeinterface getMotionZ : ()D
/*     */     //   2192: dstore #18
/*     */     //   2194: astore #17
/*     */     //   2196: iconst_0
/*     */     //   2197: istore #6
/*     */     //   2199: dload #4
/*     */     //   2201: invokestatic cos : (D)D
/*     */     //   2204: dstore #20
/*     */     //   2206: aload #17
/*     */     //   2208: dload #18
/*     */     //   2210: dload #20
/*     */     //   2212: aload_0
/*     */     //   2213: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2216: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2219: checkcast java/lang/Number
/*     */     //   2222: invokevirtual doubleValue : ()D
/*     */     //   2225: dmul
/*     */     //   2226: dadd
/*     */     //   2227: invokeinterface setMotionZ : (D)V
/*     */     //   2232: aload_0
/*     */     //   2233: aload_0
/*     */     //   2234: getfield zitterDirection : Z
/*     */     //   2237: ifne -> 2244
/*     */     //   2240: iconst_1
/*     */     //   2241: goto -> 2245
/*     */     //   2244: iconst_0
/*     */     //   2245: putfield zitterDirection : Z
/*     */     //   2248: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #240	-> 6
/*     */     //   #240	-> 21
/*     */     //   #241	-> 24
/*     */     //   #242	-> 43
/*     */     //   #243	-> 76
/*     */     //   #244	-> 92
/*     */     //   #245	-> 179
/*     */     //   #247	-> 201
/*     */     //   #248	-> 245
/*     */     //   #250	-> 245
/*     */     //   #251	-> 284
/*     */     //   #252	-> 292
/*     */     //   #253	-> 302
/*     */     //   #254	-> 312
/*     */     //   #255	-> 323
/*     */     //   #257	-> 336
/*     */     //   #258	-> 347
/*     */     //   #259	-> 357
/*     */     //   #260	-> 367
/*     */     //   #261	-> 377
/*     */     //   #263	-> 377
/*     */     //   #264	-> 386
/*     */     //   #266	-> 401
/*     */     //   #267	-> 441
/*     */     //   #268	-> 446
/*     */     //   #269	-> 453
/*     */     //   #270	-> 458
/*     */     //   #271	-> 463
/*     */     //   #272	-> 468
/*     */     //   #273	-> 473
/*     */     //   #274	-> 478
/*     */     //   #275	-> 491
/*     */     //   #276	-> 506
/*     */     //   #278	-> 511
/*     */     //   #280	-> 516
/*     */     //   #281	-> 516
/*     */     //   #282	-> 545
/*     */     //   #283	-> 574
/*     */     //   #284	-> 655
/*     */     //   #285	-> 678
/*     */     //   #288	-> 683
/*     */     //   #289	-> 808
/*     */     //   #290	-> 933
/*     */     //   #292	-> 981
/*     */     //   #293	-> 1005
/*     */     //   #294	-> 1025
/*     */     //   #295	-> 1046
/*     */     //   #297	-> 1046
/*     */     //   #298	-> 1046
/*     */     //   #299	-> 1110
/*     */     //   #300	-> 1117
/*     */     //   #302	-> 1136
/*     */     //   #303	-> 1152
/*     */     //   #304	-> 1178
/*     */     //   #307	-> 1204
/*     */     //   #308	-> 1231
/*     */     //   #309	-> 1235
/*     */     //   #310	-> 1264
/*     */     //   #311	-> 1283
/*     */     //   #312	-> 1310
/*     */     //   #313	-> 1326
/*     */     //   #315	-> 1329
/*     */     //   #316	-> 1341
/*     */     //   #317	-> 1353
/*     */     //   #880	-> 1356
/*     */     //   #880	-> 1373
/*     */     //   #318	-> 1378
/*     */     //   #319	-> 1394
/*     */     //   #321	-> 1424
/*     */     //   #318	-> 1451
/*     */     //   #322	-> 1451
/*     */     //   #318	-> 1455
/*     */     //   #324	-> 1457
/*     */     //   #325	-> 1464
/*     */     //   #311	-> 1467
/*     */     //   #330	-> 1473
/*     */     //   #331	-> 1493
/*     */     //   #332	-> 1493
/*     */     //   #881	-> 1496
/*     */     //   #881	-> 1513
/*     */     //   #332	-> 1518
/*     */     //   #331	-> 1560
/*     */     //   #333	-> 1562
/*     */     //   #334	-> 1582
/*     */     //   #335	-> 1591
/*     */     //   #336	-> 1599
/*     */     //   #337	-> 1602
/*     */     //   #338	-> 1611
/*     */     //   #340	-> 1617
/*     */     //   #337	-> 1620
/*     */     //   #336	-> 1620
/*     */     //   #335	-> 1628
/*     */     //   #345	-> 1633
/*     */     //   #347	-> 1642
/*     */     //   #348	-> 1662
/*     */     //   #349	-> 1662
/*     */     //   #351	-> 1670
/*     */     //   #352	-> 1683
/*     */     //   #354	-> 1683
/*     */     //   #355	-> 1692
/*     */     //   #356	-> 1756
/*     */     //   #357	-> 1766
/*     */     //   #358	-> 1772
/*     */     //   #360	-> 1779
/*     */     //   #361	-> 1779
/*     */     //   #384	-> 1860
/*     */     //   #362	-> 1873
/*     */     //   #365	-> 1886
/*     */     //   #363	-> 1899
/*     */     //   #366	-> 1900
/*     */     //   #367	-> 1915
/*     */     //   #369	-> 1934
/*     */     //   #370	-> 1949
/*     */     //   #372	-> 1968
/*     */     //   #373	-> 1981
/*     */     //   #374	-> 1997
/*     */     //   #376	-> 2004
/*     */     //   #377	-> 2011
/*     */     //   #378	-> 2030
/*     */     //   #380	-> 2052
/*     */     //   #381	-> 2071
/*     */     //   #382	-> 2090
/*     */     //   #385	-> 2093
/*     */     //   #386	-> 2109
/*     */     //   #387	-> 2138
/*     */     //   #387	-> 2165
/*     */     //   #388	-> 2185
/*     */     //   #388	-> 2212
/*     */     //   #389	-> 2232
/*     */     //   #391	-> 2248
/*     */     //   #393	-> 2248
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   1356	19	12	$i$f$isReplaceable	I
/*     */     //   1457	10	12	calcDif	D
/*     */     //   1353	114	11	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1341	126	10	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1310	160	6	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1496	19	7	$i$f$isReplaceable	I
/*     */     //   1562	105	6	shouldEagle	Z
/*     */     //   1264	419	5	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1235	448	3	dif	D
/*     */     //   2138	110	4	yaw	D
/*     */     //   24	2225	2	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	2249	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest;
/*     */     //   0	2249	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 397 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof net.minecraft.network.play.server.SPacketDisconnect) {
/* 398 */       setState(false);
/*     */     }
/* 400 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 404 */     IPacket packet = event.getPacket();
/* 405 */     if (packet instanceof CPacketHeldItemChange) {
/* 406 */       this.slot = ((CPacketHeldItemChange)packet).func_149614_c();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event)
/*     */   {
/* 413 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       return;
/*     */     }
/* 416 */     if (!this.canRot)
/* 417 */       return;  update();
/* 418 */     if (this.lockRotation != null) { Rotation rotation = this.lockRotation;
/*     */       
/* 420 */       if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue()))) {
/* 421 */         if (this.targetPlace == null) {
/* 422 */           rotation.setYaw(WMathHelper.wrapAngleTo180_float(MathKt.roundToInt(rotation.getYaw() / 45.0F) * 45.0F));
/*     */         }
/* 424 */         setRotation(rotation);
/* 425 */         this.lockRotationTimer.update();
/*     */         
/* 427 */         rotation.applyStrafeToPlayer(event);
/* 428 */         event.cancelEvent();
/*     */         
/*     */         return;
/*     */       } 
/* 432 */       if (RotationUtils.targetRotation != null) { Rotation targetRotation = RotationUtils.targetRotation;
/* 433 */         targetRotation.applyStrafeToPlayer(event);
/* 434 */         event.cancelEvent();
/*     */         return; }
/*     */       
/*     */       return; }
/*     */      } @EventTarget
/* 439 */   public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); EventState eventState = event.getEventState();
/* 440 */     if (!this.canRot)
/*     */       return; 
/* 442 */     if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue())) && this.lockRotation != null && 
/* 443 */       StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       
/* 445 */       if (this.lockRotation == null) Intrinsics.throwNpe();  setRotation(this.lockRotation);
/* 446 */       if (eventState == EventState.POST) {
/* 447 */         this.lockRotationTimer.update();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 452 */     if ((this.facesBlock || !((Boolean)this.rotationsValue.get()).booleanValue()) && StringsKt.equals((String)this.placeModeValue.get(), eventState.getStateName(), true)) {
/* 453 */       if (!this.canPlace)
/* 454 */         return;  place();
/*     */     } 
/* 456 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((MinecraftInstance.mc.getThePlayer().getFallDistance() > false && ((Boolean)this.FallFastplace.get()).booleanValue()) || (this.canPlace && ((Boolean)this.Fastplace.get()).booleanValue())) {
/* 457 */       place();
/*     */     }
/*     */     
/* 460 */     if (eventState == EventState.PRE && StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/* 461 */       update();
/*     */     }
/*     */ 
/*     */     
/* 465 */     if (this.targetPlace == null && ((Boolean)this.placeDelay.get()).booleanValue()) {
/* 466 */       this.delayTimer.reset();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield canRot : Z
/*     */     //   4: ifne -> 8
/*     */     //   7: return
/*     */     //   8: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   11: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   16: dup
/*     */     //   17: ifnull -> 23
/*     */     //   20: goto -> 25
/*     */     //   23: pop
/*     */     //   24: return
/*     */     //   25: astore_1
/*     */     //   26: aload_1
/*     */     //   27: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   32: ifnull -> 63
/*     */     //   35: aload_1
/*     */     //   36: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   41: dup
/*     */     //   42: ifnonnull -> 48
/*     */     //   45: invokestatic throwNpe : ()V
/*     */     //   48: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   53: instanceof net/minecraft/item/ItemBlock
/*     */     //   56: ifeq -> 63
/*     */     //   59: iconst_1
/*     */     //   60: goto -> 64
/*     */     //   63: iconst_0
/*     */     //   64: istore_2
/*     */     //   65: aload_0
/*     */     //   66: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   69: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   72: checkcast java/lang/String
/*     */     //   75: ldc_w 'off'
/*     */     //   78: iconst_1
/*     */     //   79: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   82: ifne -> 104
/*     */     //   85: invokestatic findAutoBlockBlock : ()I
/*     */     //   88: iconst_m1
/*     */     //   89: if_icmpne -> 100
/*     */     //   92: iload_2
/*     */     //   93: ifne -> 100
/*     */     //   96: iconst_1
/*     */     //   97: goto -> 113
/*     */     //   100: iconst_0
/*     */     //   101: goto -> 113
/*     */     //   104: iload_2
/*     */     //   105: ifne -> 112
/*     */     //   108: iconst_1
/*     */     //   109: goto -> 113
/*     */     //   112: iconst_0
/*     */     //   113: ifeq -> 117
/*     */     //   116: return
/*     */     //   117: aload_0
/*     */     //   118: aload_0
/*     */     //   119: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   122: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   125: checkcast java/lang/String
/*     */     //   128: ldc_w 'expand'
/*     */     //   131: iconst_1
/*     */     //   132: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   135: invokespecial findBlock : (Z)V
/*     */     //   138: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #471	-> 0
/*     */     //   #472	-> 8
/*     */     //   #472	-> 23
/*     */     //   #474	-> 26
/*     */     //   #475	-> 65
/*     */     //   #476	-> 65
/*     */     //   #475	-> 65
/*     */     //   #476	-> 75
/*     */     //   #477	-> 85
/*     */     //   #475	-> 113
/*     */     //   #479	-> 116
/*     */     //   #482	-> 117
/*     */     //   #483	-> 138
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   65	74	2	holdingItem	Z
/*     */     //   26	113	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	139	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void setRotation(Rotation rotation) {
/* 487 */     if (!this.canRot)
/* 488 */       return;  if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 490 */       if (((Boolean)this.silentRotationValue.get()).booleanValue())
/* 491 */       { RotationUtils.setTargetRotation(rotation, 0); }
/*     */       else
/* 493 */       { player.setRotationYaw(rotation.getYaw());
/* 494 */         player.setRotationPitch(rotation.getPitch()); }  return; }  MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */   public final void place() { // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnull -> 15
/*     */     //   12: goto -> 17
/*     */     //   15: pop
/*     */     //   16: return
/*     */     //   17: astore_1
/*     */     //   18: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   21: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   26: dup
/*     */     //   27: ifnull -> 33
/*     */     //   30: goto -> 35
/*     */     //   33: pop
/*     */     //   34: return
/*     */     //   35: astore_2
/*     */     //   36: aload_0
/*     */     //   37: getfield canPlace : Z
/*     */     //   40: ifne -> 44
/*     */     //   43: return
/*     */     //   44: aload_0
/*     */     //   45: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   48: ifnonnull -> 75
/*     */     //   51: aload_0
/*     */     //   52: getfield placeDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   55: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   58: checkcast java/lang/Boolean
/*     */     //   61: invokevirtual booleanValue : ()Z
/*     */     //   64: ifeq -> 74
/*     */     //   67: aload_0
/*     */     //   68: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   71: invokevirtual reset : ()V
/*     */     //   74: return
/*     */     //   75: aload_0
/*     */     //   76: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   79: aload_0
/*     */     //   80: getfield delay : J
/*     */     //   83: invokevirtual hasTimePassed : (J)Z
/*     */     //   86: ifeq -> 132
/*     */     //   89: aload_0
/*     */     //   90: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   93: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   96: checkcast java/lang/Boolean
/*     */     //   99: invokevirtual booleanValue : ()Z
/*     */     //   102: ifeq -> 133
/*     */     //   105: aload_0
/*     */     //   106: getfield launchY : I
/*     */     //   109: iconst_1
/*     */     //   110: isub
/*     */     //   111: aload_0
/*     */     //   112: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   115: dup
/*     */     //   116: ifnonnull -> 122
/*     */     //   119: invokestatic throwNpe : ()V
/*     */     //   122: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   125: invokevirtual getYCoord : ()D
/*     */     //   128: d2i
/*     */     //   129: if_icmpeq -> 133
/*     */     //   132: return
/*     */     //   133: aload_1
/*     */     //   134: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   139: astore_3
/*     */     //   140: aload_3
/*     */     //   141: ifnull -> 217
/*     */     //   144: aload_3
/*     */     //   145: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   150: instanceof net/minecraft/item/ItemBlock
/*     */     //   153: ifeq -> 217
/*     */     //   156: aload_3
/*     */     //   157: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   162: dup
/*     */     //   163: ifnonnull -> 169
/*     */     //   166: invokestatic throwNpe : ()V
/*     */     //   169: dup
/*     */     //   170: ifnonnull -> 184
/*     */     //   173: new kotlin/TypeCastException
/*     */     //   176: dup
/*     */     //   177: ldc_w 'null cannot be cast to non-null type net.minecraft.item.ItemBlock'
/*     */     //   180: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   183: athrow
/*     */     //   184: checkcast net/minecraft/item/ItemBlock
/*     */     //   187: invokevirtual func_179223_d : ()Lnet/minecraft/block/Block;
/*     */     //   190: instanceof net/minecraft/block/BlockBush
/*     */     //   193: ifne -> 217
/*     */     //   196: aload_1
/*     */     //   197: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   202: dup
/*     */     //   203: ifnonnull -> 209
/*     */     //   206: invokestatic throwNpe : ()V
/*     */     //   209: invokeinterface getStackSize : ()I
/*     */     //   214: ifgt -> 540
/*     */     //   217: invokestatic findAutoBlockBlock : ()I
/*     */     //   220: istore #4
/*     */     //   222: iload #4
/*     */     //   224: iconst_m1
/*     */     //   225: if_icmpne -> 229
/*     */     //   228: return
/*     */     //   229: aload_0
/*     */     //   230: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   233: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   236: checkcast java/lang/String
/*     */     //   239: astore #5
/*     */     //   241: iconst_0
/*     */     //   242: istore #6
/*     */     //   244: aload #5
/*     */     //   246: dup
/*     */     //   247: ifnonnull -> 261
/*     */     //   250: new kotlin/TypeCastException
/*     */     //   253: dup
/*     */     //   254: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   257: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   260: athrow
/*     */     //   261: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   264: dup
/*     */     //   265: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   268: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   271: astore #5
/*     */     //   273: aload #5
/*     */     //   275: invokevirtual hashCode : ()I
/*     */     //   278: lookupswitch default -> 521, -889473228 -> 362, 109935 -> 348, 3440673 -> 334, 109651721 -> 320
/*     */     //   320: aload #5
/*     */     //   322: ldc_w 'spoof'
/*     */     //   325: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   328: ifeq -> 521
/*     */     //   331: goto -> 435
/*     */     //   334: aload #5
/*     */     //   336: ldc_w 'pick'
/*     */     //   339: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   342: ifeq -> 521
/*     */     //   345: goto -> 377
/*     */     //   348: aload #5
/*     */     //   350: ldc_w 'off'
/*     */     //   353: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   356: ifeq -> 521
/*     */     //   359: goto -> 376
/*     */     //   362: aload #5
/*     */     //   364: ldc_w 'switch'
/*     */     //   367: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   370: ifeq -> 521
/*     */     //   373: goto -> 479
/*     */     //   376: return
/*     */     //   377: iload #4
/*     */     //   379: bipush #36
/*     */     //   381: isub
/*     */     //   382: aload_0
/*     */     //   383: getfield slot : I
/*     */     //   386: if_icmpeq -> 521
/*     */     //   389: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   392: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   397: dup
/*     */     //   398: ifnonnull -> 404
/*     */     //   401: invokestatic throwNpe : ()V
/*     */     //   404: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   409: iload #4
/*     */     //   411: bipush #36
/*     */     //   413: isub
/*     */     //   414: invokeinterface setCurrentItem : (I)V
/*     */     //   419: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   422: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   427: invokeinterface updateController : ()V
/*     */     //   432: goto -> 521
/*     */     //   435: iload #4
/*     */     //   437: bipush #36
/*     */     //   439: isub
/*     */     //   440: aload_0
/*     */     //   441: getfield slot : I
/*     */     //   444: if_icmpeq -> 521
/*     */     //   447: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   450: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   455: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   458: iload #4
/*     */     //   460: bipush #36
/*     */     //   462: isub
/*     */     //   463: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   468: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   471: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   476: goto -> 521
/*     */     //   479: iload #4
/*     */     //   481: bipush #36
/*     */     //   483: isub
/*     */     //   484: aload_0
/*     */     //   485: getfield slot : I
/*     */     //   488: if_icmpeq -> 521
/*     */     //   491: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   494: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   499: dup
/*     */     //   500: ifnonnull -> 506
/*     */     //   503: invokestatic throwNpe : ()V
/*     */     //   506: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   511: iload #4
/*     */     //   513: bipush #36
/*     */     //   515: isub
/*     */     //   516: invokeinterface setCurrentItem : (I)V
/*     */     //   521: aload_1
/*     */     //   522: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   527: iload #4
/*     */     //   529: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   534: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   539: astore_3
/*     */     //   540: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   543: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   548: aload_1
/*     */     //   549: aload_2
/*     */     //   550: aload_3
/*     */     //   551: aload_0
/*     */     //   552: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   555: dup
/*     */     //   556: ifnonnull -> 562
/*     */     //   559: invokestatic throwNpe : ()V
/*     */     //   562: invokevirtual getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   565: aload_0
/*     */     //   566: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   569: dup
/*     */     //   570: ifnonnull -> 576
/*     */     //   573: invokestatic throwNpe : ()V
/*     */     //   576: invokevirtual getEnumFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   579: aload_0
/*     */     //   580: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   583: dup
/*     */     //   584: ifnonnull -> 590
/*     */     //   587: invokestatic throwNpe : ()V
/*     */     //   590: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   593: invokeinterface onPlayerRightClick : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)Z
/*     */     //   598: ifeq -> 809
/*     */     //   601: aload_0
/*     */     //   602: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   605: invokevirtual reset : ()V
/*     */     //   608: aload_0
/*     */     //   609: aload_0
/*     */     //   610: getfield placeDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   613: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   616: checkcast java/lang/Boolean
/*     */     //   619: invokevirtual booleanValue : ()Z
/*     */     //   622: ifne -> 629
/*     */     //   625: lconst_0
/*     */     //   626: goto -> 701
/*     */     //   629: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   632: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   637: dup
/*     */     //   638: ifnonnull -> 644
/*     */     //   641: invokestatic throwNpe : ()V
/*     */     //   644: invokeinterface getFallDistance : ()F
/*     */     //   649: iconst_0
/*     */     //   650: i2f
/*     */     //   651: fcmpl
/*     */     //   652: ifle -> 672
/*     */     //   655: aload_0
/*     */     //   656: getfield falldowndelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   659: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   662: checkcast java/lang/Number
/*     */     //   665: invokevirtual intValue : ()I
/*     */     //   668: i2l
/*     */     //   669: goto -> 701
/*     */     //   672: aload_0
/*     */     //   673: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   676: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   679: checkcast java/lang/Number
/*     */     //   682: invokevirtual intValue : ()I
/*     */     //   685: aload_0
/*     */     //   686: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   689: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   692: checkcast java/lang/Number
/*     */     //   695: invokevirtual intValue : ()I
/*     */     //   698: invokestatic randomDelay : (II)J
/*     */     //   701: putfield delay : J
/*     */     //   704: aload_1
/*     */     //   705: invokeinterface getOnGround : ()Z
/*     */     //   710: ifeq -> 760
/*     */     //   713: aload_0
/*     */     //   714: getfield speedModifierValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   717: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   720: checkcast java/lang/Number
/*     */     //   723: invokevirtual floatValue : ()F
/*     */     //   726: fstore #4
/*     */     //   728: aload_1
/*     */     //   729: aload_1
/*     */     //   730: invokeinterface getMotionX : ()D
/*     */     //   735: fload #4
/*     */     //   737: f2d
/*     */     //   738: dmul
/*     */     //   739: invokeinterface setMotionX : (D)V
/*     */     //   744: aload_1
/*     */     //   745: aload_1
/*     */     //   746: invokeinterface getMotionZ : ()D
/*     */     //   751: fload #4
/*     */     //   753: f2d
/*     */     //   754: dmul
/*     */     //   755: invokeinterface setMotionZ : (D)V
/*     */     //   760: aload_0
/*     */     //   761: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   764: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   767: checkcast java/lang/Boolean
/*     */     //   770: invokevirtual booleanValue : ()Z
/*     */     //   773: ifeq -> 785
/*     */     //   776: aload_1
/*     */     //   777: invokeinterface swingItem : ()V
/*     */     //   782: goto -> 809
/*     */     //   785: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   788: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   793: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   796: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   801: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   804: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   809: aload_0
/*     */     //   810: aconst_null
/*     */     //   811: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*     */     //   814: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   817: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #541	-> 0
/*     */     //   #541	-> 15
/*     */     //   #542	-> 18
/*     */     //   #542	-> 33
/*     */     //   #543	-> 36
/*     */     //   #544	-> 44
/*     */     //   #545	-> 51
/*     */     //   #546	-> 67
/*     */     //   #548	-> 74
/*     */     //   #551	-> 75
/*     */     //   #552	-> 132
/*     */     //   #555	-> 133
/*     */     //   #556	-> 140
/*     */     //   #557	-> 217
/*     */     //   #559	-> 222
/*     */     //   #560	-> 228
/*     */     //   #563	-> 229
/*     */     //   #573	-> 320
/*     */     //   #567	-> 334
/*     */     //   #564	-> 348
/*     */     //   #578	-> 362
/*     */     //   #565	-> 376
/*     */     //   #568	-> 377
/*     */     //   #569	-> 389
/*     */     //   #570	-> 419
/*     */     //   #574	-> 435
/*     */     //   #575	-> 447
/*     */     //   #579	-> 479
/*     */     //   #580	-> 491
/*     */     //   #583	-> 521
/*     */     //   #584	-> 521
/*     */     //   #587	-> 540
/*     */     //   #588	-> 548
/*     */     //   #587	-> 593
/*     */     //   #591	-> 601
/*     */     //   #592	-> 608
/*     */     //   #593	-> 625
/*     */     //   #595	-> 629
/*     */     //   #596	-> 655
/*     */     //   #598	-> 672
/*     */     //   #595	-> 701
/*     */     //   #592	-> 701
/*     */     //   #603	-> 704
/*     */     //   #604	-> 713
/*     */     //   #605	-> 728
/*     */     //   #606	-> 744
/*     */     //   #609	-> 760
/*     */     //   #610	-> 776
/*     */     //   #612	-> 785
/*     */     //   #613	-> 809
/*     */     //   #616	-> 809
/*     */     //   #617	-> 817
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   222	318	4	blockSlot	I
/*     */     //   728	32	4	modifier	F
/*     */     //   140	678	3	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   36	782	2	world	Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   18	800	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	818	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest; } public void onDisable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74311_E)) { MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); if (this.eagleSneaking)
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)player, ICPacketEntityAction.WAction.STOP_SNEAKING));  }  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74366_z))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74370_x))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);  this.lockRotation = (Rotation)null; this.facesBlock = false; MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); this.shouldGoDown = false; if (this.slot != player.getInventory().getCurrentItem())
/*     */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(player.getInventory().getCurrentItem()));  return; }
/* 501 */      MinecraftInstance.mc.getThePlayer(); } private final void findBlock(boolean expand) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 502 */       if (!this.canRot)
/* 503 */         return;  WBlockPos blockPosition = this.shouldGoDown ? (
/* 504 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 505 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ()) : (
/*     */         
/* 507 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ())).down()) : (
/*     */         
/* 509 */         (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? 
/* 510 */         new WBlockPos(player.getPosX(), this.launchY - 1.0D, player.getPosZ()) : (
/* 511 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 512 */         new WBlockPos((IEntity)player) : (
/*     */         
/* 514 */         new WBlockPos(player.getPosX(), player.getPosY(), player.getPosZ())).down()));
/*     */       
/* 516 */       if (!expand) { int $i$f$isReplaceable = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 882 */         BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0) || search(blockPosition, !this.shouldGoDown)) return;  }  if (expand) { double yaw = Math.toRadians(player.getRotationYaw() + '´'); boolean bool = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); byte b = 0; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); int i; for (b = 0, i = ((Number)this.expandLengthValue.get()).intValue(); b < i; b++) { if (search(blockPosition.add(x * b, 0, z * b), false)) return;  }  } else if (((Boolean)this.searchValue.get()).booleanValue()) { byte b; byte b1; for (b = -1, b1 = 1; b <= b1; b++) { byte b2; byte b3; for (b2 = -1, b3 = 1; b2 <= b3; b2++) { if (search(blockPosition.add(b, 0, b2), !this.shouldGoDown)) return;  }  }  }  return; }  MinecraftInstance.mc.getThePlayer(); }
/* 883 */   @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown) return;  if (((Boolean)this.airSafeValue.get()).booleanValue() || player.getOnGround()) event.setSafeWalk(true);  return; }  MinecraftInstance.mc.getThePlayer(); } @EventTarget public final void onRender2D(@NotNull Render2DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.counterDisplayValue.get()).booleanValue()) { GL11.glPushMatrix(); if (Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay");  BlockOverlay blockOverlay = (BlockOverlay)Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class); if (blockOverlay.getState() && ((Boolean)blockOverlay.getInfoValue().get()).booleanValue() && blockOverlay.getCurrentBlock() != null) GL11.glTranslatef(0.0F, 15.0F, 0.0F);  String info = "Blocks: §7" + getBlocksAmount(); ScaledResolution scaledResolution = new ScaledResolution(MinecraftInstance.mc2); GlStateManager.func_179117_G(); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(info, scaledResolution.func_78326_a() / 2, (scaledResolution.func_78328_b() / 2) + 7, Color.WHITE.getRGB()); GL11.glPopMatrix(); }  } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.markValue.get()).booleanValue()) return;  for (byte b1 = 0, b2 = StringsKt.equals((String)this.modeValue.get(), "Expand", true) ? (((Number)this.expandLengthValue.get()).intValue() + 1) : 2; b1 < b2; b1++) { double yaw = Math.toRadians(player.getRotationYaw()); boolean bool1 = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); boolean bool2 = false; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); WBlockPos blockPos = new WBlockPos(player.getPosX() + (x * b1), (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? (this.launchY - 1.0D) : (player.getPosY() - ((player.getPosY() == player.getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0D : 0.0D)), player.getPosZ() + (z * b1)); PlaceInfo placeInfo = PlaceInfo.Companion.get(blockPos); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) { RenderUtils.drawBlockBox(blockPos, new Color(68, 117, 255, 100), false); break; }  }  return; }
/* 884 */      MinecraftInstance.mc.getThePlayer(); } private final boolean search(WBlockPos blockPosition, boolean raycast) { this.facesBlock = false; if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient world = MinecraftInstance.mc.getTheWorld(); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0))
/* 885 */           return false;  double xzRV = ((Number)this.xzRangeValue.get()).floatValue(); double xzSSV = calcStepSize((float)xzRV); double yRV = ((Number)this.yRangeValue.get()).floatValue(); double ySSV = calcStepSize((float)yRV); WVec3 eyesPos = new WVec3(player.getPosX(), player.getEntityBoundingBox().getMinY() + player.getEyeHeight(), player.getPosZ()); PlaceRotation placeRotation = (PlaceRotation)null; for (EnumFacingType facingType : EnumFacingType.values()) { IEnumFacing side = MinecraftInstance.classProvider.getEnumFacing(facingType); WBlockPos neighbor = WBlockPos.offset$default(blockPosition, side, 0, 2, null); if (BlockUtils.canBeClicked(neighbor)) { WVec3 dirVec = new WVec3(side.getDirectionVec()); boolean auto = StringsKt.equals((String)this.searchMode.get(), "Auto", true); boolean center = StringsKt.equals((String)this.searchMode.get(), "AutoCenter", true); double xSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (xSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { double ySearch = auto ? 0.1D : (0.5D - yRV / 2); while (ySearch <= (auto ? 0.9D : (0.5D + yRV / 2))) { double zSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (zSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { WVec3 wVec3 = new WVec3((WVec3i)blockPosition); double d1 = center ? 0.5D : xSearch, d2 = center ? 0.5D : ySearch, z$iv = center ? 0.5D : zSearch; continue; $i$f$addVector = 0; posVec = new WVec3(SYNTHETIC_LOCAL_VARIABLE_31.getXCoord() + SYNTHETIC_LOCAL_VARIABLE_32, SYNTHETIC_LOCAL_VARIABLE_31.getYCoord() + SYNTHETIC_LOCAL_VARIABLE_34, SYNTHETIC_LOCAL_VARIABLE_31.getZCoord() + SYNTHETIC_LOCAL_VARIABLE_36); this_$iv = eyesPos; $i$f$squareDistanceTo = 0;
/* 886 */                   d0$iv = posVec.getXCoord() - this_$iv.getXCoord();
/* 887 */                   d1$iv = posVec.getYCoord() - this_$iv.getYCoord();
/* 888 */                   d2$iv = posVec.getZCoord() - this_$iv.getZCoord();
/*     */                   
/* 890 */                   distanceSqPosVec = d0$iv * d0$iv + d1$iv * d1$iv + d2$iv * d2$iv; wVec31 = posVec; vec$iv = new WVec3(dirVec.getXCoord() * 0.5D, dirVec.getYCoord() * 0.5D, dirVec.getZCoord() * 0.5D); $i$f$add = 0;
/* 891 */                   wVec32 = wVec31; d1 = vec$iv.getXCoord(); d2 = vec$iv.getYCoord(); z$iv$iv = vec$iv.getZCoord(); i = 0;
/* 892 */                   hitVec = new WVec3(wVec32.getXCoord() + d1, wVec32.getYCoord() + d2, wVec32.getZCoord() + z$iv$iv); }
/*     */                 
/*     */                 ySearch += auto ? 0.1D : ySSV; }
/*     */               
/*     */               xSearch += auto ? 0.1D : xzSSV; }
/*     */              }
/*     */            }
/*     */         
/*     */         if (placeRotation == null)
/*     */           return false; 
/*     */         if (((Boolean)this.rotationsValue.get()).booleanValue() && this.canRot) {
/*     */           if (((Number)this.minTurnSpeedValue.get()).floatValue() < '´') {
/*     */             Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, placeRotation.getRotation(), (float)(Math.random() * (((Number)this.maxTurnSpeedValue.get()).floatValue() - ((Number)this.minTurnSpeedValue.get()).floatValue()) + ((Number)this.minTurnSpeedValue.get()).doubleValue())), "RotationUtils.limitAngle…Float()\n                )");
/*     */             Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, placeRotation.getRotation(), (float)(Math.random() * (((Number)this.maxTurnSpeedValue.get()).floatValue() - ((Number)this.minTurnSpeedValue.get()).floatValue()) + ((Number)this.minTurnSpeedValue.get()).doubleValue()));
/*     */             if (MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(limitedRotation.getYaw())) == MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(placeRotation.getRotation().getYaw())) && MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(limitedRotation.getPitch())) == MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(placeRotation.getRotation().getPitch()))) {
/*     */               setRotation(placeRotation.getRotation());
/*     */               this.lockRotation = placeRotation.getRotation();
/*     */               this.facesBlock = true;
/*     */             } else {
/*     */               setRotation(limitedRotation);
/*     */               this.lockRotation = limitedRotation;
/*     */               this.facesBlock = false;
/*     */             } 
/*     */           } else {
/*     */             setRotation(placeRotation.getRotation());
/*     */             this.lockRotation = placeRotation.getRotation();
/*     */             this.facesBlock = true;
/*     */           } 
/*     */           this.lockRotationTimer.reset();
/*     */         } 
/*     */         this.targetPlace = placeRotation.getPlaceInfo();
/*     */         return true; }
/*     */       
/*     */       MinecraftInstance.mc.getTheWorld();
/*     */       return false; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */     return false; }
/*     */ 
/*     */   
/*     */   private final double calcStepSize(float range) {
/*     */     double accuracy = ((Number)this.searchAccuracyValue.get()).intValue();
/*     */     accuracy += accuracy % 2;
/*     */     return (range / accuracy < 0.01D) ? 0.01D : (range / accuracy);
/*     */   }
/*     */   
/*     */   public final int getBlocksAmount() {
/*     */     int amount = 0;
/*     */     for (byte b1 = 36, b2 = 44; b1 <= b2; b1++) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getStack();
/*     */       if (itemStack != null && MinecraftInstance.classProvider.isItemBlock(itemStack.getItem())) {
/*     */         if (itemStack.getItem() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         IBlock block = itemStack.getItem().asItemBlock().getBlock();
/*     */         if (MinecraftInstance.mc.getThePlayer() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         IItemStack heldItem = MinecraftInstance.mc.getThePlayer().getHeldItem();
/*     */         if ((heldItem != null && Intrinsics.areEqual(heldItem, itemStack)) || (!InventoryUtils.BLOCK_BLACKLIST.contains(block) && !MinecraftInstance.classProvider.isBlockBush(block)))
/*     */           amount += itemStack.getStackSize(); 
/*     */       } 
/*     */     } 
/*     */     return amount;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/*     */     return (String)this.sprintModeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ScaffoldTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */