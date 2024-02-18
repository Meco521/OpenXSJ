/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.math.MathKt;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
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
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3i;
/*     */ import net.ccbluex.liquidbounce.event.EventState;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.PlaceRotation;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*     */ import net.ccbluex.liquidbounce.utils.block.PlaceInfo;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.network.play.client.CPacketHeldItemChange;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "ScaffoldNew", description = "Skid", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000®\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\006\n\002\020\013\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\f\n\002\030\002\n\000\n\002\030\002\n\002\b!\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\006\n\000\n\002\020\007\n\000\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020[\032\0020\\2\006\020]\032\0020^H\002J\020\020_\032\0020`2\006\020a\032\0020\024H\002J\b\020b\032\0020`H\026J\b\020c\032\0020`H\026J\020\020d\032\0020`2\006\020e\032\0020fH\007J\020\020g\032\0020`2\006\020e\032\0020hH\007J\020\020i\032\0020`2\006\020e\032\0020jH\007J\020\020k\032\0020`2\006\020e\032\0020lH\007J\020\020m\032\0020`2\006\020e\032\0020nH\007J\020\020o\032\0020`2\006\020e\032\0020pH\007J\020\020q\032\0020`2\006\020e\032\0020rH\003J\006\020s\032\0020`J\030\020t\032\0020\0242\006\020u\032\0020v2\006\020w\032\0020\024H\002J\020\020x\032\0020`2\006\020y\032\0020*H\002J\006\020z\032\0020`R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\021\020\017\032\0020\r8F¢\006\006\032\004\b\020\020\021R\016\020\022\032\0020\tX\004¢\006\002\n\000R\016\020\023\032\0020\024X\016¢\006\002\n\000R\016\020\025\032\0020\024X\016¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\016\020\031\032\0020\030X\004¢\006\002\n\000R\016\020\032\032\0020\033X\016¢\006\002\n\000R\016\020\034\032\0020\035X\004¢\006\002\n\000R\016\020\036\032\0020\004X\004¢\006\002\n\000R\016\020\037\032\0020\024X\016¢\006\002\n\000R\016\020 \032\0020\007X\004¢\006\002\n\000R\016\020!\032\0020\030X\004¢\006\002\n\000R\016\020\"\032\0020\tX\004¢\006\002\n\000R\016\020#\032\0020\024X\016¢\006\002\n\000R\016\020$\032\0020\024X\016¢\006\002\n\000R\016\020%\032\0020\tX\004¢\006\002\n\000R\016\020&\032\0020\tX\004¢\006\002\n\000R\016\020'\032\0020\004X\004¢\006\002\n\000R\016\020(\032\0020\rX\016¢\006\002\n\000R\020\020)\032\004\030\0010*X\016¢\006\002\n\000R\016\020+\032\0020,X\016¢\006\002\n\000R\016\020-\032\0020\004X\004¢\006\002\n\000R\016\020.\032\0020\tX\004¢\006\002\n\000R\016\020/\032\0020\030X\004¢\006\002\n\000R\016\0200\032\0020\tX\004¢\006\002\n\000R\016\0201\032\0020\030X\004¢\006\002\n\000R\016\0202\032\0020\030X\004¢\006\002\n\000R\016\0203\032\0020\007X\004¢\006\002\n\000R\016\0204\032\0020\024X\016¢\006\002\n\000R\016\0205\032\0020\004X\004¢\006\002\n\000R\016\0206\032\0020\007X\004¢\006\002\n\000R\016\0207\032\0020\004X\004¢\006\002\n\000R\016\0208\032\0020\007X\004¢\006\002\n\000R\016\0209\032\0020\rX\016¢\006\002\n\000R\016\020:\032\0020\004X\004¢\006\002\n\000R\016\020;\032\0020\004X\004¢\006\002\n\000R\016\020<\032\0020\004X\004¢\006\002\n\000R\016\020=\032\0020\004X\004¢\006\002\n\000R\016\020>\032\0020\tX\004¢\006\002\n\000R\016\020?\032\0020\007X\004¢\006\002\n\000R\016\020@\032\0020\004X\004¢\006\002\n\000R\016\020A\032\0020\024X\016¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\rX\016¢\006\002\n\000R\016\020D\032\0020\030X\004¢\006\002\n\000R\016\020E\032\0020\004X\004¢\006\002\n\000R\016\020F\032\0020\030X\004¢\006\002\n\000R\016\020G\032\0020\007X\004¢\006\002\n\000R\021\020H\032\0020\004¢\006\b\n\000\032\004\bI\020JR\016\020K\032\0020\007X\004¢\006\002\n\000R\016\020L\032\0020\004X\004¢\006\002\n\000R\024\020M\032\0020N8VX\004¢\006\006\032\004\bO\020PR\020\020Q\032\004\030\0010RX\016¢\006\002\n\000R\016\020S\032\0020\030X\004¢\006\002\n\000R\016\020T\032\0020\030X\004¢\006\002\n\000R\016\020U\032\0020\030X\016¢\006\002\n\000R\016\020V\032\0020\024X\016¢\006\002\n\000R\016\020W\032\0020\007X\004¢\006\002\n\000R\016\020X\032\0020\030X\004¢\006\002\n\000R\016\020Y\032\0020\030X\004¢\006\002\n\000R\016\020Z\032\0020\035X\004¢\006\002\n\000¨\006{"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "FallFastplace", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Fastplace", "RotConditionValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "Rotairticks", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "airSafeValue", "airticks", "airtime", "", "autoBlockValue", "blocksAmount", "getBlocksAmount", "()I", "blocksToEagleValue", "canPlace", "", "canRot", "counterDisplayValue", "customPitchValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "customYawValue", "delay", "", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "downValue", "eagleSneaking", "eagleValue", "edgeDistanceValue", "expandLengthValue", "f", "facesBlock", "falldowndelay", "keepLengthValue", "keepRotationValue", "launchY", "lockRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "lockRotationTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "markValue", "maxDelayValue", "maxTurnSpeedValue", "minDelayValue", "minDistValue", "minTurnSpeedValue", "modeValue", "n", "omniDirectionalExpand", "placeConditionValue", "placeDelay", "placeModeValue", "placedBlocksWithoutEagle", "rotationsValue", "rotationshypValue", "safeWalkValue", "sameYValue", "searchAccuracyValue", "searchMode", "searchValue", "shouldGoDown", "silentRotationValue", "slot", "slowSpeed", "slowValue", "speedModifierValue", "sprintModeValue", "sprintValue", "getSprintValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "strafeMode", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "targetPlace", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "timerValue", "xzRangeValue", "yRangeValue", "zitterDirection", "zitterMode", "zitterSpeed", "zitterStrength", "zitterTimer", "calcStepSize", "", "range", "", "findBlock", "", "expand", "onDisable", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "place", "search", "blockPosition", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "raycast", "setRotation", "rotation", "update", "XSJClient"})
/*     */ public final class ScaffoldNew extends Module {
/*  53 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal");
/*     */ 
/*     */   
/*  56 */   private final IntegerValue maxDelayValue = new ScaffoldNew$maxDelayValue$1("MaxDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew$maxDelayValue$1 extends IntegerValue { ScaffoldNew$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  58 */       int minDelay = ((Number)ScaffoldNew.this.minDelayValue.get()).intValue();
/*  59 */       if (minDelay > newValue) {
/*  60 */         set(Integer.valueOf(minDelay));
/*     */       }
/*     */     } }
/*     */ 
/*     */   
/*  65 */   private final IntegerValue minDelayValue = new ScaffoldNew$minDelayValue$1("MinDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew$minDelayValue$1 extends IntegerValue { ScaffoldNew$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  67 */       int maxDelay = ((Number)ScaffoldNew.this.maxDelayValue.get()).intValue();
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
/*  78 */   private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "Off", "Pick", "Spoof", "Switch", "Switchfix" }, "Spoof");
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*  83 */   private final BoolValue sprintValue = new BoolValue("Sprint", true); @NotNull public final BoolValue getSprintValue() { return this.sprintValue; }
/*  84 */    private final ListValue sprintModeValue = new ListValue("SprintMode", new String[] { "off", "ground", "air" }, "air");
/*  85 */   private final BoolValue swingValue = new BoolValue("Swing", true);
/*  86 */   private final BoolValue searchValue = new BoolValue("Search", true);
/*  87 */   private final BoolValue downValue = new BoolValue("Down", true);
/*  88 */   private final ListValue placeModeValue = new ListValue("PlaceTiming", new String[] { "Pre", "Post" }, "Post");
/*  89 */   private final ListValue placeConditionValue = new ListValue("PlaceCondition", new String[] { "Always", "DelayAir", "FallDown" }, "Always");
/*  90 */   private final ListValue RotConditionValue = new ListValue("RotCondition", new String[] { "Always", "DelayAir", "FallDown" }, "Always");
/*     */   private boolean f;
/*     */   private boolean n;
/*     */   private boolean canPlace;
/*     */   private boolean canRot;
/*     */   private int airtime;
/*  96 */   private final IntegerValue airticks = new IntegerValue("PlaceAirTime", 0, 0, 10);
/*  97 */   private final IntegerValue Rotairticks = new IntegerValue("RotAirTime", 0, 0, 10);
/*     */ 
/*     */   
/* 100 */   private final ListValue eagleValue = new ListValue("Eagle", new String[] { "Normal", "Silent", "Off" }, "Normal");
/* 101 */   private final IntegerValue blocksToEagleValue = new IntegerValue("BlocksToEagle", 0, 0, 10);
/* 102 */   private final FloatValue edgeDistanceValue = new FloatValue("EagleEdgeDistance", 0.0F, 0.0F, 0.5F);
/*     */ 
/*     */   
/* 105 */   private final BoolValue omniDirectionalExpand = new BoolValue("OmniDirectionalExpand", false);
/* 106 */   private final IntegerValue expandLengthValue = new IntegerValue("ExpandLength", 1, 1, 6);
/*     */ 
/*     */   
/* 109 */   private final ListValue strafeMode = new ListValue("Strafe", new String[] { "Off", "AAC" }, "Off");
/* 110 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/* 111 */   private final BoolValue rotationshypValue = new BoolValue("Rotationshyp", true);
/* 112 */   private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true);
/* 113 */   private final BoolValue keepRotationValue = new BoolValue("KeepRotation", true);
/* 114 */   private final IntegerValue keepLengthValue = new IntegerValue("KeepRotationLength", 0, 0, 20);
/* 115 */   private final FloatValue customYawValue = new FloatValue("customYawValue", 180.0F, -360.0F, 360.0F);
/* 116 */   private final FloatValue customPitchValue = new FloatValue("customPitchValue", 79.0F, 60.0F, 100.0F);
/*     */ 
/*     */   
/* 119 */   private final ListValue searchMode = new ListValue("XYZSearch", new String[] { "Auto", "AutoCenter", "Manual" }, "AutoCenter");
/* 120 */   private final FloatValue xzRangeValue = new FloatValue("xzRange", 0.8F, 0.0F, 1.0F);
/* 121 */   private FloatValue yRangeValue = new FloatValue("yRange", 0.8F, 0.0F, 1.0F);
/* 122 */   private final FloatValue minDistValue = new FloatValue("MinDist", 0.0F, 0.0F, 0.2F);
/*     */ 
/*     */   
/* 125 */   private final IntegerValue searchAccuracyValue = new ScaffoldNew$searchAccuracyValue$1("SearchAccuracy", 8, 1, 16); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew$searchAccuracyValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew$searchAccuracyValue$1 extends IntegerValue { ScaffoldNew$searchAccuracyValue$1(String $super_call_param$0, int $super_call_param$1, int $super_call_param$2, int $super_call_param$3) { super($super_call_param$0, $super_call_param$1, $super_call_param$2, $super_call_param$3); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/* 127 */       if (getMaximum() < newValue) {
/* 128 */         set(Integer.valueOf(getMaximum()));
/* 129 */       } else if (getMinimum() > newValue) {
/* 130 */         set(Integer.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/* 136 */   private final FloatValue maxTurnSpeedValue = new ScaffoldNew$maxTurnSpeedValue$1("MaxTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew$maxTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew$maxTurnSpeedValue$1 extends FloatValue { ScaffoldNew$maxTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 138 */       float v = ((Number)ScaffoldNew.this.minTurnSpeedValue.get()).floatValue();
/* 139 */       if (v > newValue) set(Float.valueOf(v)); 
/* 140 */       if (getMaximum() < newValue) {
/* 141 */         set(Float.valueOf(getMaximum()));
/* 142 */       } else if (getMinimum() > newValue) {
/* 143 */         set(Float.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */   
/* 147 */   private final FloatValue minTurnSpeedValue = new ScaffoldNew$minTurnSpeedValue$1("MinTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew$minTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew$minTurnSpeedValue$1 extends FloatValue { ScaffoldNew$minTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 149 */       float v = ((Number)ScaffoldNew.this.maxTurnSpeedValue.get()).floatValue();
/* 150 */       if (v < newValue) set(Float.valueOf(v)); 
/* 151 */       if (getMaximum() < newValue) {
/* 152 */         set(Float.valueOf(getMaximum()));
/* 153 */       } else if (getMinimum() > newValue) {
/* 154 */         set(Float.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/* 160 */   private final ListValue zitterMode = new ListValue("Zitter", new String[] { "Off", "Teleport", "Smooth" }, "Off");
/* 161 */   private final FloatValue zitterSpeed = new FloatValue("ZitterSpeed", 0.13F, 0.1F, 0.3F);
/* 162 */   private final FloatValue zitterStrength = new FloatValue("ZitterStrength", 0.05F, 0.0F, 0.2F);
/*     */ 
/*     */   
/* 165 */   private final FloatValue timerValue = new FloatValue("Timer", 1.0F, 0.1F, 10.0F);
/* 166 */   private final FloatValue speedModifierValue = new FloatValue("SpeedModifier", 1.0F, 0.0F, 2.0F);
/* 167 */   private final BoolValue slowValue = new BoolValue("Slow", false);
/* 168 */   private final FloatValue slowSpeed = new FloatValue("SlowSpeed", 0.6F, 0.2F, 0.8F);
/*     */ 
/*     */   
/* 171 */   private final BoolValue sameYValue = new BoolValue("SameY", false);
/* 172 */   private final BoolValue safeWalkValue = new BoolValue("SafeWalk", true);
/* 173 */   private final BoolValue airSafeValue = new BoolValue("AirSafe", false);
/* 174 */   private final BoolValue FallFastplace = new BoolValue("Fallfastplace", false);
/* 175 */   private final BoolValue Fastplace = new BoolValue("fastplace", false);
/*     */   
/* 177 */   private final BoolValue counterDisplayValue = new BoolValue("Counter", true);
/* 178 */   private final BoolValue markValue = new BoolValue("Mark", false);
/*     */ 
/*     */   
/*     */   private PlaceInfo targetPlace;
/*     */   
/*     */   private Rotation lockRotation;
/*     */   
/* 185 */   private TickTimer lockRotationTimer = new TickTimer();
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
/* 198 */   private final MSTimer delayTimer = new MSTimer();
/* 199 */   private final MSTimer zitterTimer = new MSTimer();
/*     */   
/*     */   private long delay;
/*     */   
/*     */   private int placedBlocksWithoutEagle;
/*     */   
/*     */   private boolean eagleSneaking;
/*     */   
/*     */   private boolean shouldGoDown;
/*     */ 
/*     */   
/*     */   public void onEnable() {
/* 211 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 212 */       this.canPlace = false;
/* 213 */       this.canRot = false;
/* 214 */       this.f = false;
/* 215 */       this.airtime = 0;
/* 216 */       this.launchY = MathKt.roundToInt(player.getPosY());
/* 217 */       this.slot = player.getInventory().getCurrentItem();
/* 218 */       this.facesBlock = false;
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
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
/*     */   @EventTarget
/*     */   private final void onUpdate(UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   3: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   6: ldc net/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew
/*     */     //   8: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   11: dup
/*     */     //   12: ifnonnull -> 25
/*     */     //   15: new kotlin/TypeCastException
/*     */     //   18: dup
/*     */     //   19: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.ScaHelperNew'
/*     */     //   21: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   24: athrow
/*     */     //   25: checkcast net/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew
/*     */     //   28: astore_2
/*     */     //   29: aload_0
/*     */     //   30: getfield sprintValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   33: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   36: checkcast java/lang/Boolean
/*     */     //   39: invokevirtual booleanValue : ()Z
/*     */     //   42: ifeq -> 225
/*     */     //   45: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   48: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   53: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   56: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   61: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   66: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   71: ifne -> 93
/*     */     //   74: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   77: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   82: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   87: iconst_0
/*     */     //   88: invokeinterface setPressed : (Z)V
/*     */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   96: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   101: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   104: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   109: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   114: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   119: ifeq -> 141
/*     */     //   122: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   125: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   130: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   135: iconst_1
/*     */     //   136: invokeinterface setPressed : (Z)V
/*     */     //   141: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   144: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   149: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   154: invokeinterface isKeyDown : ()Z
/*     */     //   159: ifeq -> 183
/*     */     //   162: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   165: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   170: dup
/*     */     //   171: ifnonnull -> 177
/*     */     //   174: invokestatic throwNpe : ()V
/*     */     //   177: iconst_1
/*     */     //   178: invokeinterface setSprinting : (Z)V
/*     */     //   183: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   186: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   191: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   196: invokeinterface isKeyDown : ()Z
/*     */     //   201: ifne -> 225
/*     */     //   204: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   207: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   212: dup
/*     */     //   213: ifnonnull -> 219
/*     */     //   216: invokestatic throwNpe : ()V
/*     */     //   219: iconst_0
/*     */     //   220: invokeinterface setSprinting : (Z)V
/*     */     //   225: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   228: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   233: dup
/*     */     //   234: ifnull -> 240
/*     */     //   237: goto -> 242
/*     */     //   240: pop
/*     */     //   241: return
/*     */     //   242: astore_3
/*     */     //   243: aload_3
/*     */     //   244: invokeinterface getOnGround : ()Z
/*     */     //   249: ifne -> 268
/*     */     //   252: aload_0
/*     */     //   253: dup
/*     */     //   254: getfield airtime : I
/*     */     //   257: dup
/*     */     //   258: istore #4
/*     */     //   260: iconst_1
/*     */     //   261: iadd
/*     */     //   262: putfield airtime : I
/*     */     //   265: goto -> 383
/*     */     //   268: aload_0
/*     */     //   269: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   272: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   275: checkcast java/lang/String
/*     */     //   278: ldc_w 'falldown'
/*     */     //   281: iconst_1
/*     */     //   282: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   285: ifne -> 308
/*     */     //   288: aload_0
/*     */     //   289: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   292: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   295: checkcast java/lang/String
/*     */     //   298: ldc_w 'delayair'
/*     */     //   301: iconst_1
/*     */     //   302: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   305: ifeq -> 378
/*     */     //   308: aload_0
/*     */     //   309: lconst_0
/*     */     //   310: putfield delay : J
/*     */     //   313: aload_0
/*     */     //   314: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   317: invokevirtual reset : ()V
/*     */     //   320: aload_0
/*     */     //   321: iconst_0
/*     */     //   322: putfield eagleSneaking : Z
/*     */     //   325: aload_0
/*     */     //   326: iconst_0
/*     */     //   327: putfield shouldGoDown : Z
/*     */     //   330: aload_0
/*     */     //   331: iconst_0
/*     */     //   332: putfield canPlace : Z
/*     */     //   335: aload_0
/*     */     //   336: iconst_0
/*     */     //   337: putfield canRot : Z
/*     */     //   340: aload_0
/*     */     //   341: iconst_0
/*     */     //   342: putfield f : Z
/*     */     //   345: aload_0
/*     */     //   346: aload_3
/*     */     //   347: invokeinterface getPosY : ()D
/*     */     //   352: invokestatic roundToInt : (D)I
/*     */     //   355: putfield launchY : I
/*     */     //   358: aload_0
/*     */     //   359: aload_3
/*     */     //   360: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   365: invokeinterface getCurrentItem : ()I
/*     */     //   370: putfield slot : I
/*     */     //   373: aload_0
/*     */     //   374: iconst_0
/*     */     //   375: putfield facesBlock : Z
/*     */     //   378: aload_0
/*     */     //   379: iconst_0
/*     */     //   380: putfield airtime : I
/*     */     //   383: aload_0
/*     */     //   384: aload_0
/*     */     //   385: getfield airtime : I
/*     */     //   388: aload_0
/*     */     //   389: getfield airticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   392: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   395: checkcast java/lang/Number
/*     */     //   398: invokevirtual intValue : ()I
/*     */     //   401: if_icmple -> 408
/*     */     //   404: iconst_1
/*     */     //   405: goto -> 409
/*     */     //   408: iconst_0
/*     */     //   409: putfield f : Z
/*     */     //   412: aload_0
/*     */     //   413: aload_0
/*     */     //   414: getfield airtime : I
/*     */     //   417: aload_0
/*     */     //   418: getfield Rotairticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   421: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   424: checkcast java/lang/Number
/*     */     //   427: invokevirtual intValue : ()I
/*     */     //   430: if_icmple -> 437
/*     */     //   433: iconst_1
/*     */     //   434: goto -> 438
/*     */     //   437: iconst_0
/*     */     //   438: putfield n : Z
/*     */     //   441: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   444: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   449: aload_0
/*     */     //   450: getfield timerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   453: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   456: checkcast java/lang/Number
/*     */     //   459: invokevirtual floatValue : ()F
/*     */     //   462: invokeinterface setTimerSpeed : (F)V
/*     */     //   467: aload_0
/*     */     //   468: aload_0
/*     */     //   469: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   472: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   475: checkcast java/lang/String
/*     */     //   478: ldc_w 'falldown'
/*     */     //   481: iconst_1
/*     */     //   482: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   485: ifeq -> 514
/*     */     //   488: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   491: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   496: dup
/*     */     //   497: ifnonnull -> 503
/*     */     //   500: invokestatic throwNpe : ()V
/*     */     //   503: invokeinterface getFallDistance : ()F
/*     */     //   508: iconst_0
/*     */     //   509: i2f
/*     */     //   510: fcmpl
/*     */     //   511: ifgt -> 584
/*     */     //   514: aload_0
/*     */     //   515: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   518: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   521: checkcast java/lang/String
/*     */     //   524: ldc_w 'always'
/*     */     //   527: iconst_1
/*     */     //   528: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   531: ifne -> 584
/*     */     //   534: aload_0
/*     */     //   535: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   538: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   541: checkcast java/lang/String
/*     */     //   544: ldc_w 'delayair'
/*     */     //   547: iconst_1
/*     */     //   548: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   551: ifeq -> 588
/*     */     //   554: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   557: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   562: dup
/*     */     //   563: ifnonnull -> 569
/*     */     //   566: invokestatic throwNpe : ()V
/*     */     //   569: invokeinterface getOnGround : ()Z
/*     */     //   574: ifne -> 588
/*     */     //   577: aload_0
/*     */     //   578: getfield f : Z
/*     */     //   581: ifeq -> 588
/*     */     //   584: iconst_1
/*     */     //   585: goto -> 589
/*     */     //   588: iconst_0
/*     */     //   589: putfield canPlace : Z
/*     */     //   592: aload_0
/*     */     //   593: aload_0
/*     */     //   594: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   597: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   600: checkcast java/lang/String
/*     */     //   603: ldc_w 'falldown'
/*     */     //   606: iconst_1
/*     */     //   607: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   610: ifeq -> 639
/*     */     //   613: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   616: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   621: dup
/*     */     //   622: ifnonnull -> 628
/*     */     //   625: invokestatic throwNpe : ()V
/*     */     //   628: invokeinterface getFallDistance : ()F
/*     */     //   633: iconst_0
/*     */     //   634: i2f
/*     */     //   635: fcmpl
/*     */     //   636: ifgt -> 709
/*     */     //   639: aload_0
/*     */     //   640: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   643: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   646: checkcast java/lang/String
/*     */     //   649: ldc_w 'always'
/*     */     //   652: iconst_1
/*     */     //   653: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   656: ifne -> 709
/*     */     //   659: aload_0
/*     */     //   660: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   663: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   666: checkcast java/lang/String
/*     */     //   669: ldc_w 'delayair'
/*     */     //   672: iconst_1
/*     */     //   673: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   676: ifeq -> 713
/*     */     //   679: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   682: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   687: dup
/*     */     //   688: ifnonnull -> 694
/*     */     //   691: invokestatic throwNpe : ()V
/*     */     //   694: invokeinterface getOnGround : ()Z
/*     */     //   699: ifne -> 713
/*     */     //   702: aload_0
/*     */     //   703: getfield n : Z
/*     */     //   706: ifeq -> 713
/*     */     //   709: iconst_1
/*     */     //   710: goto -> 714
/*     */     //   713: iconst_0
/*     */     //   714: putfield canRot : Z
/*     */     //   717: aload_0
/*     */     //   718: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   721: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   724: checkcast java/lang/String
/*     */     //   727: ldc_w 'off'
/*     */     //   730: iconst_1
/*     */     //   731: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   734: ifne -> 823
/*     */     //   737: aload_0
/*     */     //   738: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   741: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   744: checkcast java/lang/String
/*     */     //   747: ldc_w 'ground'
/*     */     //   750: iconst_1
/*     */     //   751: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   754: ifeq -> 780
/*     */     //   757: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   760: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   765: dup
/*     */     //   766: ifnonnull -> 772
/*     */     //   769: invokestatic throwNpe : ()V
/*     */     //   772: invokeinterface getOnGround : ()Z
/*     */     //   777: ifeq -> 823
/*     */     //   780: aload_0
/*     */     //   781: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   784: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   787: checkcast java/lang/String
/*     */     //   790: ldc_w 'air'
/*     */     //   793: iconst_1
/*     */     //   794: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   797: ifeq -> 844
/*     */     //   800: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   803: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   808: dup
/*     */     //   809: ifnonnull -> 815
/*     */     //   812: invokestatic throwNpe : ()V
/*     */     //   815: invokeinterface getOnGround : ()Z
/*     */     //   820: ifeq -> 844
/*     */     //   823: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   826: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   831: dup
/*     */     //   832: ifnonnull -> 838
/*     */     //   835: invokestatic throwNpe : ()V
/*     */     //   838: iconst_0
/*     */     //   839: invokeinterface setSprinting : (Z)V
/*     */     //   844: aload_0
/*     */     //   845: aload_0
/*     */     //   846: getfield downValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   849: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   852: checkcast java/lang/Boolean
/*     */     //   855: invokevirtual booleanValue : ()Z
/*     */     //   858: ifeq -> 904
/*     */     //   861: aload_0
/*     */     //   862: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   865: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   868: checkcast java/lang/Boolean
/*     */     //   871: invokevirtual booleanValue : ()Z
/*     */     //   874: ifne -> 904
/*     */     //   877: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   880: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   883: getfield field_74311_E : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   886: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   889: ifeq -> 904
/*     */     //   892: aload_0
/*     */     //   893: invokevirtual getBlocksAmount : ()I
/*     */     //   896: iconst_1
/*     */     //   897: if_icmple -> 904
/*     */     //   900: iconst_1
/*     */     //   901: goto -> 905
/*     */     //   904: iconst_0
/*     */     //   905: putfield shouldGoDown : Z
/*     */     //   908: aload_0
/*     */     //   909: getfield shouldGoDown : Z
/*     */     //   912: ifeq -> 934
/*     */     //   915: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   918: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   923: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   928: iconst_0
/*     */     //   929: invokeinterface setPressed : (Z)V
/*     */     //   934: aload_0
/*     */     //   935: getfield slowValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   938: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   941: checkcast java/lang/Boolean
/*     */     //   944: invokevirtual booleanValue : ()Z
/*     */     //   947: ifeq -> 1002
/*     */     //   950: aload_3
/*     */     //   951: aload_3
/*     */     //   952: invokeinterface getMotionX : ()D
/*     */     //   957: aload_0
/*     */     //   958: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   961: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   964: checkcast java/lang/Number
/*     */     //   967: invokevirtual doubleValue : ()D
/*     */     //   970: dmul
/*     */     //   971: invokeinterface setMotionX : (D)V
/*     */     //   976: aload_3
/*     */     //   977: aload_3
/*     */     //   978: invokeinterface getMotionZ : ()D
/*     */     //   983: aload_0
/*     */     //   984: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   987: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   990: checkcast java/lang/Number
/*     */     //   993: invokevirtual doubleValue : ()D
/*     */     //   996: dmul
/*     */     //   997: invokeinterface setMotionZ : (D)V
/*     */     //   1002: aload_0
/*     */     //   1003: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1006: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1009: checkcast java/lang/String
/*     */     //   1012: ldc_w 'Off'
/*     */     //   1015: iconst_1
/*     */     //   1016: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1019: ifne -> 1485
/*     */     //   1022: aload_0
/*     */     //   1023: getfield shouldGoDown : Z
/*     */     //   1026: ifne -> 1485
/*     */     //   1029: ldc2_w 0.5
/*     */     //   1032: dstore #4
/*     */     //   1034: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1037: dup
/*     */     //   1038: aload_3
/*     */     //   1039: invokeinterface getPosX : ()D
/*     */     //   1044: aload_3
/*     */     //   1045: invokeinterface getPosY : ()D
/*     */     //   1050: dconst_1
/*     */     //   1051: dsub
/*     */     //   1052: aload_3
/*     */     //   1053: invokeinterface getPosZ : ()D
/*     */     //   1058: invokespecial <init> : (DDD)V
/*     */     //   1061: astore #6
/*     */     //   1063: aload_0
/*     */     //   1064: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1067: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1070: checkcast java/lang/Number
/*     */     //   1073: invokevirtual floatValue : ()F
/*     */     //   1076: iconst_0
/*     */     //   1077: i2f
/*     */     //   1078: fcmpl
/*     */     //   1079: ifle -> 1274
/*     */     //   1082: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1085: astore #9
/*     */     //   1087: aload #9
/*     */     //   1089: arraylength
/*     */     //   1090: istore #10
/*     */     //   1092: iconst_0
/*     */     //   1093: istore #8
/*     */     //   1095: iload #8
/*     */     //   1097: iload #10
/*     */     //   1099: if_icmpge -> 1274
/*     */     //   1102: aload #9
/*     */     //   1104: iload #8
/*     */     //   1106: aaload
/*     */     //   1107: astore #7
/*     */     //   1109: aload #7
/*     */     //   1111: getstatic net/minecraft/util/EnumFacing.UP : Lnet/minecraft/util/EnumFacing;
/*     */     //   1114: if_acmpeq -> 1125
/*     */     //   1117: aload #7
/*     */     //   1119: getstatic net/minecraft/util/EnumFacing.DOWN : Lnet/minecraft/util/EnumFacing;
/*     */     //   1122: if_acmpne -> 1128
/*     */     //   1125: goto -> 1268
/*     */     //   1128: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1131: aload #7
/*     */     //   1133: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1138: astore #11
/*     */     //   1140: aload #6
/*     */     //   1142: aload #11
/*     */     //   1144: iconst_0
/*     */     //   1145: iconst_2
/*     */     //   1146: aconst_null
/*     */     //   1147: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1150: astore #12
/*     */     //   1152: iconst_0
/*     */     //   1153: istore #13
/*     */     //   1155: aload #12
/*     */     //   1157: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1160: dup
/*     */     //   1161: ifnull -> 1172
/*     */     //   1164: invokeinterface isReplaceable : ()Z
/*     */     //   1169: goto -> 1174
/*     */     //   1172: pop
/*     */     //   1173: iconst_0
/*     */     //   1174: ifeq -> 1268
/*     */     //   1177: aload #7
/*     */     //   1179: getstatic net/minecraft/util/EnumFacing.NORTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   1182: if_acmpeq -> 1193
/*     */     //   1185: aload #7
/*     */     //   1187: getstatic net/minecraft/util/EnumFacing.SOUTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   1190: if_acmpne -> 1223
/*     */     //   1193: aload #12
/*     */     //   1195: invokevirtual getZ : ()I
/*     */     //   1198: i2d
/*     */     //   1199: ldc2_w 0.5
/*     */     //   1202: dadd
/*     */     //   1203: aload_3
/*     */     //   1204: invokeinterface getPosZ : ()D
/*     */     //   1209: dsub
/*     */     //   1210: dstore #15
/*     */     //   1212: iconst_0
/*     */     //   1213: istore #17
/*     */     //   1215: dload #15
/*     */     //   1217: invokestatic abs : (D)D
/*     */     //   1220: goto -> 1250
/*     */     //   1223: aload #12
/*     */     //   1225: invokevirtual getX : ()I
/*     */     //   1228: i2d
/*     */     //   1229: ldc2_w 0.5
/*     */     //   1232: dadd
/*     */     //   1233: aload_3
/*     */     //   1234: invokeinterface getPosX : ()D
/*     */     //   1239: dsub
/*     */     //   1240: dstore #15
/*     */     //   1242: iconst_0
/*     */     //   1243: istore #17
/*     */     //   1245: dload #15
/*     */     //   1247: invokestatic abs : (D)D
/*     */     //   1250: ldc2_w 0.5
/*     */     //   1253: dsub
/*     */     //   1254: dstore #13
/*     */     //   1256: dload #13
/*     */     //   1258: dload #4
/*     */     //   1260: dcmpg
/*     */     //   1261: ifge -> 1268
/*     */     //   1264: dload #13
/*     */     //   1266: dstore #4
/*     */     //   1268: iinc #8, 1
/*     */     //   1271: goto -> 1095
/*     */     //   1274: aload_0
/*     */     //   1275: getfield placedBlocksWithoutEagle : I
/*     */     //   1278: aload_0
/*     */     //   1279: getfield blocksToEagleValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1282: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1285: checkcast java/lang/Number
/*     */     //   1288: invokevirtual intValue : ()I
/*     */     //   1291: if_icmplt -> 1472
/*     */     //   1294: iconst_0
/*     */     //   1295: istore #8
/*     */     //   1297: aload #6
/*     */     //   1299: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1302: dup
/*     */     //   1303: ifnull -> 1314
/*     */     //   1306: invokeinterface isReplaceable : ()Z
/*     */     //   1311: goto -> 1316
/*     */     //   1314: pop
/*     */     //   1315: iconst_0
/*     */     //   1316: ifne -> 1357
/*     */     //   1319: aload_0
/*     */     //   1320: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1323: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1326: checkcast java/lang/Number
/*     */     //   1329: invokevirtual floatValue : ()F
/*     */     //   1332: iconst_0
/*     */     //   1333: i2f
/*     */     //   1334: fcmpl
/*     */     //   1335: ifle -> 1361
/*     */     //   1338: dload #4
/*     */     //   1340: aload_0
/*     */     //   1341: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1344: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1347: checkcast java/lang/Number
/*     */     //   1350: invokevirtual doubleValue : ()D
/*     */     //   1353: dcmpg
/*     */     //   1354: ifge -> 1361
/*     */     //   1357: iconst_1
/*     */     //   1358: goto -> 1362
/*     */     //   1361: iconst_0
/*     */     //   1362: istore #7
/*     */     //   1364: aload_0
/*     */     //   1365: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1368: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1371: checkcast java/lang/String
/*     */     //   1374: ldc_w 'Silent'
/*     */     //   1377: iconst_1
/*     */     //   1378: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1381: ifeq -> 1444
/*     */     //   1384: aload_0
/*     */     //   1385: getfield eagleSneaking : Z
/*     */     //   1388: iload #7
/*     */     //   1390: if_icmpeq -> 1435
/*     */     //   1393: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1396: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1401: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1404: aload_3
/*     */     //   1405: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   1408: iload #7
/*     */     //   1410: ifeq -> 1419
/*     */     //   1413: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1416: goto -> 1422
/*     */     //   1419: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1422: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   1427: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1430: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1435: aload_0
/*     */     //   1436: iload #7
/*     */     //   1438: putfield eagleSneaking : Z
/*     */     //   1441: goto -> 1464
/*     */     //   1444: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1447: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1452: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1457: iload #7
/*     */     //   1459: invokeinterface setPressed : (Z)V
/*     */     //   1464: aload_0
/*     */     //   1465: iconst_0
/*     */     //   1466: putfield placedBlocksWithoutEagle : I
/*     */     //   1469: goto -> 1485
/*     */     //   1472: aload_0
/*     */     //   1473: dup
/*     */     //   1474: getfield placedBlocksWithoutEagle : I
/*     */     //   1477: dup
/*     */     //   1478: istore #7
/*     */     //   1480: iconst_1
/*     */     //   1481: iadd
/*     */     //   1482: putfield placedBlocksWithoutEagle : I
/*     */     //   1485: aload_3
/*     */     //   1486: invokeinterface getOnGround : ()Z
/*     */     //   1491: ifeq -> 2059
/*     */     //   1494: aload_0
/*     */     //   1495: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1498: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1501: checkcast java/lang/String
/*     */     //   1504: astore #4
/*     */     //   1506: iconst_0
/*     */     //   1507: istore #5
/*     */     //   1509: aload #4
/*     */     //   1511: dup
/*     */     //   1512: ifnonnull -> 1526
/*     */     //   1515: new kotlin/TypeCastException
/*     */     //   1518: dup
/*     */     //   1519: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1522: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1525: athrow
/*     */     //   1526: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1529: dup
/*     */     //   1530: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1533: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1536: astore #4
/*     */     //   1538: aload #4
/*     */     //   1540: invokevirtual hashCode : ()I
/*     */     //   1543: tableswitch default -> 1584, 1388740000 -> 1560
/*     */     //   1560: aload #4
/*     */     //   1562: ldc_w 'rewinside'
/*     */     //   1565: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1568: ifeq -> 1584
/*     */     //   1571: ldc_w 0.2
/*     */     //   1574: invokestatic strafe : (F)V
/*     */     //   1577: aload_3
/*     */     //   1578: dconst_0
/*     */     //   1579: invokeinterface setMotionY : (D)V
/*     */     //   1584: aload_0
/*     */     //   1585: getfield zitterMode : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1588: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1591: checkcast java/lang/String
/*     */     //   1594: astore #4
/*     */     //   1596: iconst_0
/*     */     //   1597: istore #5
/*     */     //   1599: aload #4
/*     */     //   1601: dup
/*     */     //   1602: ifnonnull -> 1616
/*     */     //   1605: new kotlin/TypeCastException
/*     */     //   1608: dup
/*     */     //   1609: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1612: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1615: athrow
/*     */     //   1616: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1619: dup
/*     */     //   1620: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1623: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1626: astore #4
/*     */     //   1628: aload #4
/*     */     //   1630: invokevirtual hashCode : ()I
/*     */     //   1633: lookupswitch default -> 2059, -1360201941 -> 1668, -898533970 -> 1696, 109935 -> 1682
/*     */     //   1668: aload #4
/*     */     //   1670: ldc_w 'teleport'
/*     */     //   1673: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1676: ifeq -> 2059
/*     */     //   1679: goto -> 1904
/*     */     //   1682: aload #4
/*     */     //   1684: ldc_w 'off'
/*     */     //   1687: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1690: ifeq -> 2059
/*     */     //   1693: goto -> 1710
/*     */     //   1696: aload #4
/*     */     //   1698: ldc_w 'smooth'
/*     */     //   1701: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1704: ifeq -> 2059
/*     */     //   1707: goto -> 1711
/*     */     //   1710: return
/*     */     //   1711: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1714: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1717: getfield field_74366_z : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1720: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1723: ifne -> 1745
/*     */     //   1726: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1729: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1734: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1739: iconst_0
/*     */     //   1740: invokeinterface setPressed : (Z)V
/*     */     //   1745: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1748: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1751: getfield field_74370_x : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1754: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1757: ifne -> 1779
/*     */     //   1760: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1763: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1768: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1773: iconst_0
/*     */     //   1774: invokeinterface setPressed : (Z)V
/*     */     //   1779: aload_0
/*     */     //   1780: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1783: ldc2_w 100
/*     */     //   1786: invokevirtual hasTimePassed : (J)Z
/*     */     //   1789: ifeq -> 1815
/*     */     //   1792: aload_0
/*     */     //   1793: aload_0
/*     */     //   1794: getfield zitterDirection : Z
/*     */     //   1797: ifne -> 1804
/*     */     //   1800: iconst_1
/*     */     //   1801: goto -> 1805
/*     */     //   1804: iconst_0
/*     */     //   1805: putfield zitterDirection : Z
/*     */     //   1808: aload_0
/*     */     //   1809: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1812: invokevirtual reset : ()V
/*     */     //   1815: aload_0
/*     */     //   1816: getfield zitterDirection : Z
/*     */     //   1819: ifeq -> 1863
/*     */     //   1822: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1825: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1830: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1835: iconst_1
/*     */     //   1836: invokeinterface setPressed : (Z)V
/*     */     //   1841: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1844: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1849: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1854: iconst_0
/*     */     //   1855: invokeinterface setPressed : (Z)V
/*     */     //   1860: goto -> 2059
/*     */     //   1863: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1866: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1871: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1876: iconst_0
/*     */     //   1877: invokeinterface setPressed : (Z)V
/*     */     //   1882: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1885: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1890: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1895: iconst_1
/*     */     //   1896: invokeinterface setPressed : (Z)V
/*     */     //   1901: goto -> 2059
/*     */     //   1904: aload_0
/*     */     //   1905: getfield zitterSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1908: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1911: checkcast java/lang/Number
/*     */     //   1914: invokevirtual floatValue : ()F
/*     */     //   1917: invokestatic strafe : (F)V
/*     */     //   1920: aload_3
/*     */     //   1921: invokeinterface getRotationYaw : ()F
/*     */     //   1926: f2d
/*     */     //   1927: aload_0
/*     */     //   1928: getfield zitterDirection : Z
/*     */     //   1931: ifeq -> 1940
/*     */     //   1934: ldc2_w 90.0
/*     */     //   1937: goto -> 1943
/*     */     //   1940: ldc2_w -90.0
/*     */     //   1943: dadd
/*     */     //   1944: invokestatic toRadians : (D)D
/*     */     //   1947: dstore #5
/*     */     //   1949: aload_3
/*     */     //   1950: aload_3
/*     */     //   1951: invokeinterface getMotionX : ()D
/*     */     //   1956: dstore #19
/*     */     //   1958: astore #18
/*     */     //   1960: iconst_0
/*     */     //   1961: istore #7
/*     */     //   1963: dload #5
/*     */     //   1965: invokestatic sin : (D)D
/*     */     //   1968: dstore #21
/*     */     //   1970: aload #18
/*     */     //   1972: dload #19
/*     */     //   1974: dload #21
/*     */     //   1976: aload_0
/*     */     //   1977: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1980: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1983: checkcast java/lang/Number
/*     */     //   1986: invokevirtual doubleValue : ()D
/*     */     //   1989: dmul
/*     */     //   1990: dsub
/*     */     //   1991: invokeinterface setMotionX : (D)V
/*     */     //   1996: aload_3
/*     */     //   1997: aload_3
/*     */     //   1998: invokeinterface getMotionZ : ()D
/*     */     //   2003: dstore #19
/*     */     //   2005: astore #18
/*     */     //   2007: iconst_0
/*     */     //   2008: istore #7
/*     */     //   2010: dload #5
/*     */     //   2012: invokestatic cos : (D)D
/*     */     //   2015: dstore #21
/*     */     //   2017: aload #18
/*     */     //   2019: dload #19
/*     */     //   2021: dload #21
/*     */     //   2023: aload_0
/*     */     //   2024: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2027: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2030: checkcast java/lang/Number
/*     */     //   2033: invokevirtual doubleValue : ()D
/*     */     //   2036: dmul
/*     */     //   2037: dadd
/*     */     //   2038: invokeinterface setMotionZ : (D)V
/*     */     //   2043: aload_0
/*     */     //   2044: aload_0
/*     */     //   2045: getfield zitterDirection : Z
/*     */     //   2048: ifne -> 2055
/*     */     //   2051: iconst_1
/*     */     //   2052: goto -> 2056
/*     */     //   2055: iconst_0
/*     */     //   2056: putfield zitterDirection : Z
/*     */     //   2059: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #224	-> 0
/*     */     //   #225	-> 29
/*     */     //   #226	-> 45
/*     */     //   #227	-> 74
/*     */     //   #229	-> 93
/*     */     //   #230	-> 122
/*     */     //   #232	-> 141
/*     */     //   #233	-> 162
/*     */     //   #235	-> 183
/*     */     //   #236	-> 204
/*     */     //   #239	-> 225
/*     */     //   #239	-> 240
/*     */     //   #240	-> 243
/*     */     //   #241	-> 252
/*     */     //   #243	-> 268
/*     */     //   #244	-> 308
/*     */     //   #245	-> 313
/*     */     //   #246	-> 320
/*     */     //   #247	-> 325
/*     */     //   #248	-> 330
/*     */     //   #249	-> 335
/*     */     //   #250	-> 340
/*     */     //   #251	-> 345
/*     */     //   #252	-> 358
/*     */     //   #253	-> 373
/*     */     //   #255	-> 378
/*     */     //   #257	-> 383
/*     */     //   #258	-> 383
/*     */     //   #259	-> 412
/*     */     //   #260	-> 441
/*     */     //   #261	-> 467
/*     */     //   #262	-> 592
/*     */     //   #263	-> 717
/*     */     //   #264	-> 717
/*     */     //   #265	-> 717
/*     */     //   #263	-> 717
/*     */     //   #264	-> 747
/*     */     //   #265	-> 790
/*     */     //   #267	-> 823
/*     */     //   #269	-> 844
/*     */     //   #270	-> 844
/*     */     //   #271	-> 908
/*     */     //   #272	-> 915
/*     */     //   #274	-> 934
/*     */     //   #275	-> 950
/*     */     //   #276	-> 976
/*     */     //   #279	-> 1002
/*     */     //   #280	-> 1029
/*     */     //   #281	-> 1034
/*     */     //   #282	-> 1063
/*     */     //   #283	-> 1082
/*     */     //   #284	-> 1109
/*     */     //   #285	-> 1125
/*     */     //   #287	-> 1128
/*     */     //   #288	-> 1140
/*     */     //   #289	-> 1152
/*     */     //   #882	-> 1155
/*     */     //   #882	-> 1172
/*     */     //   #290	-> 1177
/*     */     //   #291	-> 1193
/*     */     //   #293	-> 1223
/*     */     //   #290	-> 1250
/*     */     //   #294	-> 1250
/*     */     //   #290	-> 1254
/*     */     //   #296	-> 1256
/*     */     //   #297	-> 1264
/*     */     //   #283	-> 1268
/*     */     //   #302	-> 1274
/*     */     //   #303	-> 1294
/*     */     //   #304	-> 1294
/*     */     //   #883	-> 1297
/*     */     //   #883	-> 1314
/*     */     //   #304	-> 1319
/*     */     //   #303	-> 1362
/*     */     //   #305	-> 1364
/*     */     //   #306	-> 1384
/*     */     //   #307	-> 1393
/*     */     //   #308	-> 1401
/*     */     //   #309	-> 1404
/*     */     //   #310	-> 1413
/*     */     //   #312	-> 1419
/*     */     //   #309	-> 1422
/*     */     //   #308	-> 1422
/*     */     //   #307	-> 1430
/*     */     //   #317	-> 1435
/*     */     //   #319	-> 1444
/*     */     //   #320	-> 1464
/*     */     //   #321	-> 1464
/*     */     //   #323	-> 1472
/*     */     //   #324	-> 1485
/*     */     //   #326	-> 1485
/*     */     //   #327	-> 1494
/*     */     //   #328	-> 1560
/*     */     //   #329	-> 1571
/*     */     //   #330	-> 1577
/*     */     //   #332	-> 1584
/*     */     //   #333	-> 1584
/*     */     //   #356	-> 1668
/*     */     //   #334	-> 1682
/*     */     //   #337	-> 1696
/*     */     //   #335	-> 1710
/*     */     //   #338	-> 1711
/*     */     //   #339	-> 1726
/*     */     //   #341	-> 1745
/*     */     //   #342	-> 1760
/*     */     //   #344	-> 1779
/*     */     //   #345	-> 1792
/*     */     //   #346	-> 1808
/*     */     //   #348	-> 1815
/*     */     //   #349	-> 1822
/*     */     //   #350	-> 1841
/*     */     //   #352	-> 1863
/*     */     //   #353	-> 1882
/*     */     //   #354	-> 1901
/*     */     //   #357	-> 1904
/*     */     //   #358	-> 1920
/*     */     //   #359	-> 1949
/*     */     //   #359	-> 1976
/*     */     //   #360	-> 1996
/*     */     //   #360	-> 2023
/*     */     //   #361	-> 2043
/*     */     //   #363	-> 2059
/*     */     //   #365	-> 2059
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   1155	19	13	$i$f$isReplaceable	I
/*     */     //   1256	12	13	calcDif	D
/*     */     //   1152	116	12	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1140	128	11	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1109	162	7	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1297	19	8	$i$f$isReplaceable	I
/*     */     //   1364	105	7	shouldEagle	Z
/*     */     //   1063	422	6	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1034	451	4	dif	D
/*     */     //   1949	110	5	yaw	D
/*     */     //   243	1817	3	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   29	2031	2	scaHelperNew	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew;
/*     */     //   0	2060	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew;
/*     */     //   0	2060	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 369 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof net.minecraft.network.play.server.SPacketDisconnect) {
/* 370 */       setState(false);
/*     */     }
/* 372 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 376 */     IPacket packet = event.getPacket();
/* 377 */     if (packet instanceof CPacketHeldItemChange) {
/* 378 */       this.slot = ((CPacketHeldItemChange)packet).func_149614_c();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event)
/*     */   {
/* 385 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       return;
/*     */     }
/* 388 */     if (!this.canRot)
/* 389 */       return;  update();
/* 390 */     if (this.lockRotation != null) { Rotation rotation = this.lockRotation;
/*     */       
/* 392 */       if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue()))) {
/* 393 */         if (this.targetPlace == null) {
/* 394 */           rotation.setYaw(WMathHelper.wrapAngleTo180_float(MathKt.roundToInt(rotation.getYaw() / 45.0F) * 45.0F));
/*     */         }
/* 396 */         setRotation(rotation);
/* 397 */         this.lockRotationTimer.update();
/*     */         
/* 399 */         rotation.applyStrafeToPlayer(event);
/* 400 */         event.cancelEvent();
/*     */         
/*     */         return;
/*     */       } 
/* 404 */       if (RotationUtils.targetRotation != null) { Rotation targetRotation = RotationUtils.targetRotation;
/* 405 */         targetRotation.applyStrafeToPlayer(event);
/* 406 */         event.cancelEvent();
/*     */         return; }
/*     */       
/*     */       return; }
/*     */      } @EventTarget
/* 411 */   public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); EventState eventState = event.getEventState();
/* 412 */     if (!this.canRot)
/*     */       return; 
/* 414 */     if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue())) && this.lockRotation != null && 
/* 415 */       StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       
/* 417 */       if (this.lockRotation == null) Intrinsics.throwNpe();  setRotation(this.lockRotation);
/* 418 */       if (eventState == EventState.POST) {
/* 419 */         this.lockRotationTimer.update();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 424 */     if ((this.facesBlock || !((Boolean)this.rotationsValue.get()).booleanValue()) && StringsKt.equals((String)this.placeModeValue.get(), eventState.getStateName(), true)) {
/* 425 */       if (!this.canPlace)
/* 426 */         return;  place();
/*     */     } 
/* 428 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((MinecraftInstance.mc.getThePlayer().getFallDistance() > false && ((Boolean)this.FallFastplace.get()).booleanValue()) || (this.canPlace && ((Boolean)this.Fastplace.get()).booleanValue())) {
/* 429 */       place();
/*     */     }
/*     */     
/* 432 */     if (eventState == EventState.PRE && StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/* 433 */       update();
/*     */     }
/*     */ 
/*     */     
/* 437 */     if (this.targetPlace == null && ((Boolean)this.placeDelay.get()).booleanValue()) {
/* 438 */       this.delayTimer.reset();
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
/*     */     //   #443	-> 0
/*     */     //   #444	-> 8
/*     */     //   #444	-> 23
/*     */     //   #446	-> 26
/*     */     //   #447	-> 65
/*     */     //   #448	-> 65
/*     */     //   #447	-> 65
/*     */     //   #448	-> 75
/*     */     //   #449	-> 85
/*     */     //   #447	-> 113
/*     */     //   #451	-> 116
/*     */     //   #454	-> 117
/*     */     //   #455	-> 138
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   65	74	2	holdingItem	Z
/*     */     //   26	113	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	139	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void setRotation(Rotation rotation) {
/* 459 */     if (!this.canRot)
/* 460 */       return;  if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 462 */       if (((Boolean)this.silentRotationValue.get()).booleanValue())
/* 463 */       { RotationUtils.setTargetRotation(rotation, 0); }
/*     */       else
/* 465 */       { player.setRotationYaw(rotation.getYaw());
/* 466 */         player.setRotationPitch(rotation.getPitch()); }  return; }  MinecraftInstance.mc.getThePlayer();
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
/*     */     //   214: ifgt -> 634
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
/*     */     //   278: lookupswitch default -> 615, -889473228 -> 384, 109935 -> 356, 3440673 -> 342, 109651721 -> 328, 1651382369 -> 370
/*     */     //   328: aload #5
/*     */     //   330: ldc_w 'spoof'
/*     */     //   333: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   336: ifeq -> 615
/*     */     //   339: goto -> 443
/*     */     //   342: aload #5
/*     */     //   344: ldc_w 'pick'
/*     */     //   347: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   350: ifeq -> 615
/*     */     //   353: goto -> 399
/*     */     //   356: aload #5
/*     */     //   358: ldc_w 'off'
/*     */     //   361: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   364: ifeq -> 615
/*     */     //   367: goto -> 398
/*     */     //   370: aload #5
/*     */     //   372: ldc_w 'switchfix'
/*     */     //   375: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   378: ifeq -> 615
/*     */     //   381: goto -> 487
/*     */     //   384: aload #5
/*     */     //   386: ldc_w 'switch'
/*     */     //   389: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   392: ifeq -> 615
/*     */     //   395: goto -> 531
/*     */     //   398: return
/*     */     //   399: iload #4
/*     */     //   401: bipush #36
/*     */     //   403: isub
/*     */     //   404: aload_0
/*     */     //   405: getfield slot : I
/*     */     //   408: if_icmpeq -> 615
/*     */     //   411: aload_1
/*     */     //   412: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   417: iload #4
/*     */     //   419: bipush #36
/*     */     //   421: isub
/*     */     //   422: invokeinterface setCurrentItem : (I)V
/*     */     //   427: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   430: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   435: invokeinterface updateController : ()V
/*     */     //   440: goto -> 615
/*     */     //   443: iload #4
/*     */     //   445: bipush #36
/*     */     //   447: isub
/*     */     //   448: aload_0
/*     */     //   449: getfield slot : I
/*     */     //   452: if_icmpeq -> 615
/*     */     //   455: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   458: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   463: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   466: iload #4
/*     */     //   468: bipush #36
/*     */     //   470: isub
/*     */     //   471: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   476: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   479: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   484: goto -> 615
/*     */     //   487: iload #4
/*     */     //   489: bipush #36
/*     */     //   491: isub
/*     */     //   492: aload_0
/*     */     //   493: getfield slot : I
/*     */     //   496: if_icmpeq -> 615
/*     */     //   499: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   502: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   507: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   510: iload #4
/*     */     //   512: bipush #36
/*     */     //   514: isub
/*     */     //   515: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   520: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   523: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   528: goto -> 615
/*     */     //   531: iload #4
/*     */     //   533: bipush #36
/*     */     //   535: isub
/*     */     //   536: aload_0
/*     */     //   537: getfield slot : I
/*     */     //   540: if_icmpeq -> 615
/*     */     //   543: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   546: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   551: dup
/*     */     //   552: ifnonnull -> 558
/*     */     //   555: invokestatic throwNpe : ()V
/*     */     //   558: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   563: iload #4
/*     */     //   565: bipush #36
/*     */     //   567: isub
/*     */     //   568: invokeinterface setCurrentItem : (I)V
/*     */     //   573: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   576: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   581: invokeinterface updateController : ()V
/*     */     //   586: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   589: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   594: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   597: iload #4
/*     */     //   599: bipush #36
/*     */     //   601: isub
/*     */     //   602: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   607: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   610: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   615: aload_1
/*     */     //   616: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   621: iload #4
/*     */     //   623: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   628: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   633: astore_3
/*     */     //   634: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   637: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   642: aload_1
/*     */     //   643: aload_2
/*     */     //   644: aload_3
/*     */     //   645: aload_0
/*     */     //   646: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   649: dup
/*     */     //   650: ifnonnull -> 656
/*     */     //   653: invokestatic throwNpe : ()V
/*     */     //   656: invokevirtual getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   659: aload_0
/*     */     //   660: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   663: dup
/*     */     //   664: ifnonnull -> 670
/*     */     //   667: invokestatic throwNpe : ()V
/*     */     //   670: invokevirtual getEnumFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   673: aload_0
/*     */     //   674: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   677: dup
/*     */     //   678: ifnonnull -> 684
/*     */     //   681: invokestatic throwNpe : ()V
/*     */     //   684: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   687: invokeinterface onPlayerRightClick : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)Z
/*     */     //   692: ifeq -> 903
/*     */     //   695: aload_0
/*     */     //   696: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   699: invokevirtual reset : ()V
/*     */     //   702: aload_0
/*     */     //   703: aload_0
/*     */     //   704: getfield placeDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   707: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   710: checkcast java/lang/Boolean
/*     */     //   713: invokevirtual booleanValue : ()Z
/*     */     //   716: ifne -> 723
/*     */     //   719: lconst_0
/*     */     //   720: goto -> 795
/*     */     //   723: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   726: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   731: dup
/*     */     //   732: ifnonnull -> 738
/*     */     //   735: invokestatic throwNpe : ()V
/*     */     //   738: invokeinterface getFallDistance : ()F
/*     */     //   743: iconst_0
/*     */     //   744: i2f
/*     */     //   745: fcmpl
/*     */     //   746: ifle -> 766
/*     */     //   749: aload_0
/*     */     //   750: getfield falldowndelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   753: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   756: checkcast java/lang/Number
/*     */     //   759: invokevirtual intValue : ()I
/*     */     //   762: i2l
/*     */     //   763: goto -> 795
/*     */     //   766: aload_0
/*     */     //   767: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   770: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   773: checkcast java/lang/Number
/*     */     //   776: invokevirtual intValue : ()I
/*     */     //   779: aload_0
/*     */     //   780: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   783: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   786: checkcast java/lang/Number
/*     */     //   789: invokevirtual intValue : ()I
/*     */     //   792: invokestatic randomDelay : (II)J
/*     */     //   795: putfield delay : J
/*     */     //   798: aload_1
/*     */     //   799: invokeinterface getOnGround : ()Z
/*     */     //   804: ifeq -> 854
/*     */     //   807: aload_0
/*     */     //   808: getfield speedModifierValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   811: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   814: checkcast java/lang/Number
/*     */     //   817: invokevirtual floatValue : ()F
/*     */     //   820: fstore #4
/*     */     //   822: aload_1
/*     */     //   823: aload_1
/*     */     //   824: invokeinterface getMotionX : ()D
/*     */     //   829: fload #4
/*     */     //   831: f2d
/*     */     //   832: dmul
/*     */     //   833: invokeinterface setMotionX : (D)V
/*     */     //   838: aload_1
/*     */     //   839: aload_1
/*     */     //   840: invokeinterface getMotionZ : ()D
/*     */     //   845: fload #4
/*     */     //   847: f2d
/*     */     //   848: dmul
/*     */     //   849: invokeinterface setMotionZ : (D)V
/*     */     //   854: aload_0
/*     */     //   855: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   858: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   861: checkcast java/lang/Boolean
/*     */     //   864: invokevirtual booleanValue : ()Z
/*     */     //   867: ifeq -> 879
/*     */     //   870: aload_1
/*     */     //   871: invokeinterface swingItem : ()V
/*     */     //   876: goto -> 903
/*     */     //   879: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   882: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   887: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   890: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   895: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   898: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   903: aload_0
/*     */     //   904: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   907: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   910: checkcast java/lang/String
/*     */     //   913: ldc_w 'Switch'
/*     */     //   916: iconst_1
/*     */     //   917: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   920: ifeq -> 983
/*     */     //   923: aload_0
/*     */     //   924: getfield slot : I
/*     */     //   927: aload_1
/*     */     //   928: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   933: invokeinterface getCurrentItem : ()I
/*     */     //   938: if_icmpeq -> 983
/*     */     //   941: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   944: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   949: dup
/*     */     //   950: ifnonnull -> 956
/*     */     //   953: invokestatic throwNpe : ()V
/*     */     //   956: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   961: aload_0
/*     */     //   962: getfield slot : I
/*     */     //   965: invokeinterface setCurrentItem : (I)V
/*     */     //   970: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   973: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   978: invokeinterface updateController : ()V
/*     */     //   983: aload_0
/*     */     //   984: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   987: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   990: checkcast java/lang/String
/*     */     //   993: ldc_w 'Switchfix'
/*     */     //   996: iconst_1
/*     */     //   997: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1000: ifeq -> 1084
/*     */     //   1003: aload_0
/*     */     //   1004: getfield slot : I
/*     */     //   1007: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1010: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1015: dup
/*     */     //   1016: ifnonnull -> 1022
/*     */     //   1019: invokestatic throwNpe : ()V
/*     */     //   1022: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1027: invokeinterface getCurrentItem : ()I
/*     */     //   1032: if_icmpeq -> 1084
/*     */     //   1035: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1038: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1043: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1046: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1049: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1054: dup
/*     */     //   1055: ifnonnull -> 1061
/*     */     //   1058: invokestatic throwNpe : ()V
/*     */     //   1061: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1066: invokeinterface getCurrentItem : ()I
/*     */     //   1071: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   1076: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1079: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1084: aload_0
/*     */     //   1085: aconst_null
/*     */     //   1086: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*     */     //   1089: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   1092: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #513	-> 0
/*     */     //   #513	-> 15
/*     */     //   #514	-> 18
/*     */     //   #514	-> 33
/*     */     //   #515	-> 36
/*     */     //   #516	-> 44
/*     */     //   #517	-> 51
/*     */     //   #518	-> 67
/*     */     //   #520	-> 74
/*     */     //   #523	-> 75
/*     */     //   #524	-> 132
/*     */     //   #527	-> 133
/*     */     //   #528	-> 140
/*     */     //   #529	-> 217
/*     */     //   #531	-> 222
/*     */     //   #532	-> 228
/*     */     //   #535	-> 229
/*     */     //   #545	-> 328
/*     */     //   #539	-> 342
/*     */     //   #536	-> 356
/*     */     //   #550	-> 370
/*     */     //   #555	-> 384
/*     */     //   #537	-> 398
/*     */     //   #540	-> 399
/*     */     //   #541	-> 411
/*     */     //   #542	-> 427
/*     */     //   #546	-> 443
/*     */     //   #547	-> 455
/*     */     //   #551	-> 487
/*     */     //   #552	-> 499
/*     */     //   #556	-> 531
/*     */     //   #557	-> 543
/*     */     //   #558	-> 573
/*     */     //   #559	-> 586
/*     */     //   #562	-> 615
/*     */     //   #563	-> 615
/*     */     //   #566	-> 634
/*     */     //   #567	-> 642
/*     */     //   #566	-> 687
/*     */     //   #570	-> 695
/*     */     //   #571	-> 702
/*     */     //   #572	-> 719
/*     */     //   #574	-> 723
/*     */     //   #575	-> 749
/*     */     //   #577	-> 766
/*     */     //   #574	-> 795
/*     */     //   #571	-> 795
/*     */     //   #582	-> 798
/*     */     //   #583	-> 807
/*     */     //   #584	-> 822
/*     */     //   #585	-> 838
/*     */     //   #588	-> 854
/*     */     //   #589	-> 870
/*     */     //   #591	-> 879
/*     */     //   #592	-> 903
/*     */     //   #594	-> 903
/*     */     //   #595	-> 923
/*     */     //   #596	-> 941
/*     */     //   #597	-> 970
/*     */     //   #600	-> 983
/*     */     //   #601	-> 1003
/*     */     //   #602	-> 1035
/*     */     //   #605	-> 1084
/*     */     //   #606	-> 1092
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   222	412	4	blockSlot	I
/*     */     //   822	32	4	modifier	F
/*     */     //   140	953	3	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   36	1057	2	world	Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   18	1075	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1093	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew; } public void onDisable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74311_E)) { MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); if (this.eagleSneaking)
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)player, ICPacketEntityAction.WAction.STOP_SNEAKING));  }  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74366_z))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74370_x))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);  this.lockRotation = (Rotation)null; this.facesBlock = false; MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); this.shouldGoDown = false; if (this.slot != player.getInventory().getCurrentItem())
/*     */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(player.getInventory().getCurrentItem()));  return; }
/* 473 */      MinecraftInstance.mc.getThePlayer(); } private final void findBlock(boolean expand) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 474 */       if (!this.canRot)
/* 475 */         return;  WBlockPos blockPosition = this.shouldGoDown ? (
/* 476 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 477 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ()) : (
/*     */         
/* 479 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ())).down()) : (
/*     */         
/* 481 */         (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? 
/* 482 */         new WBlockPos(player.getPosX(), this.launchY - 1.0D, player.getPosZ()) : (
/* 483 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 484 */         new WBlockPos((IEntity)player) : (
/*     */         
/* 486 */         new WBlockPos(player.getPosX(), player.getPosY(), player.getPosZ())).down()));
/*     */       
/* 488 */       if (!expand) { int $i$f$isReplaceable = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 884 */         BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0) || search(blockPosition, !this.shouldGoDown)) return;  }  if (expand) { double yaw = Math.toRadians(player.getRotationYaw() + '´'); boolean bool = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); byte b = 0; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); int i; for (b = 0, i = ((Number)this.expandLengthValue.get()).intValue(); b < i; b++) { if (search(blockPosition.add(x * b, 0, z * b), false)) return;  }  } else if (((Boolean)this.searchValue.get()).booleanValue()) { byte b; byte b1; for (b = -1, b1 = 1; b <= b1; b++) { byte b2; byte b3; for (b2 = -1, b3 = 1; b2 <= b3; b2++) { if (search(blockPosition.add(b, 0, b2), !this.shouldGoDown)) return;  }  }  }  return; }  MinecraftInstance.mc.getThePlayer(); }
/* 885 */   @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown) return;  if (((Boolean)this.airSafeValue.get()).booleanValue() || player.getOnGround()) event.setSafeWalk(true);  return; }  MinecraftInstance.mc.getThePlayer(); } @EventTarget public final void onRender2D(@NotNull Render2DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.counterDisplayValue.get()).booleanValue()) { GL11.glPushMatrix(); if (Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay");  BlockOverlay blockOverlay = (BlockOverlay)Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class); if (blockOverlay.getState() && ((Boolean)blockOverlay.getInfoValue().get()).booleanValue() && blockOverlay.getCurrentBlock() != null) GL11.glTranslatef(0.0F, 15.0F, 0.0F);  String info = "Blocks: §7" + getBlocksAmount(); ScaledResolution scaledResolution = new ScaledResolution(MinecraftInstance.mc2); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawBorderedRect((scaledResolution.func_78326_a() / 2) - 2, (scaledResolution.func_78328_b() / 2) + 5, (scaledResolution.func_78326_a() / 2 + Fonts.font40.getStringWidth(info)) + 2, (scaledResolution.func_78328_b() / 2) + 16, 3.0F, Color.BLACK.getRGB(), Color.BLACK.getRGB()); GlStateManager.func_179117_G(); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(info, scaledResolution.func_78326_a() / 2, (scaledResolution.func_78328_b() / 2) + 7, Color.WHITE.getRGB()); GL11.glPopMatrix(); }  } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.markValue.get()).booleanValue()) return;  for (byte b1 = 0, b2 = StringsKt.equals((String)this.modeValue.get(), "Expand", true) ? (((Number)this.expandLengthValue.get()).intValue() + 1) : 2; b1 < b2; b1++) { double yaw = Math.toRadians(player.getRotationYaw()); boolean bool1 = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); boolean bool2 = false; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); WBlockPos blockPos = new WBlockPos(player.getPosX() + (x * b1), (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? (this.launchY - 1.0D) : (player.getPosY() - ((player.getPosY() == player.getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0D : 0.0D)), player.getPosZ() + (z * b1)); PlaceInfo placeInfo = PlaceInfo.Companion.get(blockPos); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) { RenderUtils.drawBlockBox(blockPos, new Color(68, 117, 255, 100), false); break; }  }  return; }
/* 886 */      MinecraftInstance.mc.getThePlayer(); } private final boolean search(WBlockPos blockPosition, boolean raycast) { this.facesBlock = false; if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient world = MinecraftInstance.mc.getTheWorld(); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0))
/* 887 */           return false;  double xzRV = ((Number)this.xzRangeValue.get()).floatValue(); double xzSSV = calcStepSize((float)xzRV); double yRV = ((Number)this.yRangeValue.get()).floatValue(); double ySSV = calcStepSize((float)yRV); WVec3 eyesPos = new WVec3(player.getPosX(), player.getEntityBoundingBox().getMinY() + player.getEyeHeight(), player.getPosZ()); PlaceRotation placeRotation = (PlaceRotation)null; for (EnumFacingType facingType : EnumFacingType.values()) { IEnumFacing side = MinecraftInstance.classProvider.getEnumFacing(facingType); WBlockPos neighbor = WBlockPos.offset$default(blockPosition, side, 0, 2, null); if (BlockUtils.canBeClicked(neighbor)) { WVec3 dirVec = new WVec3(side.getDirectionVec()); boolean auto = StringsKt.equals((String)this.searchMode.get(), "Auto", true); boolean center = StringsKt.equals((String)this.searchMode.get(), "AutoCenter", true); double xSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (xSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { double ySearch = auto ? 0.1D : (0.5D - yRV / 2); while (ySearch <= (auto ? 0.9D : (0.5D + yRV / 2))) { double zSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (zSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { WVec3 wVec3 = new WVec3((WVec3i)blockPosition); double d1 = center ? 0.5D : xSearch, d2 = center ? 0.5D : ySearch, z$iv = center ? 0.5D : zSearch; continue; $i$f$addVector = 0; posVec = new WVec3(SYNTHETIC_LOCAL_VARIABLE_31.getXCoord() + SYNTHETIC_LOCAL_VARIABLE_32, SYNTHETIC_LOCAL_VARIABLE_31.getYCoord() + SYNTHETIC_LOCAL_VARIABLE_34, SYNTHETIC_LOCAL_VARIABLE_31.getZCoord() + SYNTHETIC_LOCAL_VARIABLE_36); this_$iv = eyesPos; $i$f$squareDistanceTo = 0;
/* 888 */                   d0$iv = posVec.getXCoord() - this_$iv.getXCoord();
/* 889 */                   d1$iv = posVec.getYCoord() - this_$iv.getYCoord();
/* 890 */                   d2$iv = posVec.getZCoord() - this_$iv.getZCoord();
/*     */                   
/* 892 */                   distanceSqPosVec = d0$iv * d0$iv + d1$iv * d1$iv + d2$iv * d2$iv; wVec31 = posVec; vec$iv = new WVec3(dirVec.getXCoord() * 0.5D, dirVec.getYCoord() * 0.5D, dirVec.getZCoord() * 0.5D); $i$f$add = 0;
/* 893 */                   wVec32 = wVec31; d1 = vec$iv.getXCoord(); d2 = vec$iv.getYCoord(); z$iv$iv = vec$iv.getZCoord(); i = 0;
/* 894 */                   hitVec = new WVec3(wVec32.getXCoord() + d1, wVec32.getYCoord() + d2, wVec32.getZCoord() + z$iv$iv); }
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
/*     */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ScaffoldNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */