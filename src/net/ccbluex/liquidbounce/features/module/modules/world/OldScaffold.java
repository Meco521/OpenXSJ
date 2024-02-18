/*      */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*      */ import java.awt.Color;
/*      */ import kotlin.Metadata;
/*      */ import kotlin.jvm.internal.Intrinsics;
/*      */ import kotlin.math.MathKt;
/*      */ import kotlin.text.StringsKt;
/*      */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*      */ import net.ccbluex.liquidbounce.event.EventState;
/*      */ import net.ccbluex.liquidbounce.event.EventTarget;
/*      */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*      */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*      */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*      */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*      */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.PlaceRotation;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*      */ import net.ccbluex.liquidbounce.utils.block.PlaceInfo;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import net.minecraft.client.settings.GameSettings;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ 
/*      */ @ModuleInfo(name = "OldScaffold", description = "Auto Place Block", category = ModuleCategory.WORLD)
/*      */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000®\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\b\n\002\020\013\n\002\b\005\n\002\020\t\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\t\n\002\030\002\n\000\n\002\030\002\n\002\b#\n\002\020\016\n\002\b\004\n\002\030\002\n\002\b\t\n\002\020\006\n\000\n\002\020\007\n\000\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\b\027\030\0002\0020\001B\005¢\006\002\020\002J\020\020a\032\0020b2\006\020c\032\0020dH\002J\020\020e\032\0020f2\006\020g\032\0020\026H\002J\b\020h\032\0020fH\026J\b\020i\032\0020fH\026J\020\020j\032\0020f2\006\020k\032\0020lH\007J\020\020m\032\0020f2\006\020k\032\0020nH\007J\020\020o\032\0020f2\006\020k\032\0020pH\007J\022\020q\032\0020f2\b\020k\032\004\030\0010rH\007J\020\020s\032\0020f2\006\020k\032\0020tH\007J\020\020u\032\0020f2\006\020k\032\0020vH\007J\020\020w\032\0020f2\006\020k\032\0020xH\003J\006\020y\032\0020fJ\030\020z\032\0020\0262\006\020{\032\0020|2\006\020}\032\0020\026H\002J\020\020~\032\0020f2\006\020\032\0020-H\002J\007\020\001\032\0020fR\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\004X\004¢\006\002\n\000R\021\020\021\032\0020\r8F¢\006\006\032\004\b\022\020\023R\016\020\024\032\0020\tX\004¢\006\002\n\000R\016\020\025\032\0020\026X\016¢\006\002\n\000R\016\020\027\032\0020\026X\016¢\006\002\n\000R\023\020\030\032\004\030\0010\007¢\006\b\n\000\032\004\b\031\020\032R\016\020\033\032\0020\034X\016¢\006\002\n\000R\016\020\035\032\0020\036X\004¢\006\002\n\000R\016\020\037\032\0020\004X\004¢\006\002\n\000R\016\020 \032\0020\026X\016¢\006\002\n\000R\016\020!\032\0020\007X\004¢\006\002\n\000R\016\020\"\032\0020#X\004¢\006\002\n\000R\016\020$\032\0020\tX\004¢\006\002\n\000R\016\020%\032\0020\026X\016¢\006\002\n\000R\016\020&\032\0020\026X\016¢\006\002\n\000R\016\020'\032\0020\tX\004¢\006\002\n\000R\016\020(\032\0020\tX\004¢\006\002\n\000R\016\020)\032\0020\004X\004¢\006\002\n\000R\016\020*\032\0020\rX\016¢\006\002\n\000R\016\020+\032\0020\rX\016¢\006\002\n\000R\020\020,\032\004\030\0010-X\016¢\006\002\n\000R\016\020.\032\0020/X\016¢\006\002\n\000R\016\0200\032\0020\007X\004¢\006\002\n\000R\016\0201\032\0020\004X\004¢\006\002\n\000R\016\0202\032\0020\tX\004¢\006\002\n\000R\016\0203\032\0020#X\004¢\006\002\n\000R\016\0204\032\0020\tX\004¢\006\002\n\000R\016\0205\032\0020#X\004¢\006\002\n\000R\016\0206\032\0020#X\004¢\006\002\n\000R\016\0207\032\0020\007X\004¢\006\002\n\000R\016\0208\032\0020\026X\016¢\006\002\n\000R\016\0209\032\0020\004X\004¢\006\002\n\000R\016\020:\032\0020\007X\004¢\006\002\n\000R\016\020;\032\0020\004X\004¢\006\002\n\000R\016\020<\032\0020\007X\004¢\006\002\n\000R\016\020=\032\0020\rX\016¢\006\002\n\000R\016\020>\032\0020\004X\004¢\006\002\n\000R\016\020?\032\0020\004X\004¢\006\002\n\000R\021\020@\032\0020\004¢\006\b\n\000\032\004\bA\020BR\016\020C\032\0020\tX\004¢\006\002\n\000R\016\020D\032\0020\007X\004¢\006\002\n\000R\016\020E\032\0020\004X\004¢\006\002\n\000R\016\020F\032\0020\026X\016¢\006\002\n\000R\016\020G\032\0020\004X\004¢\006\002\n\000R\016\020H\032\0020\rX\016¢\006\002\n\000R\016\020I\032\0020#X\004¢\006\002\n\000R\016\020J\032\0020\004X\004¢\006\002\n\000R\016\020K\032\0020#X\004¢\006\002\n\000R\021\020L\032\0020\007¢\006\b\n\000\032\004\bM\020\032R\021\020N\032\0020\004¢\006\b\n\000\032\004\bO\020BR\016\020P\032\0020\007X\004¢\006\002\n\000R\016\020Q\032\0020\004X\004¢\006\002\n\000R\024\020R\032\0020S8VX\004¢\006\006\032\004\bT\020UR\016\020V\032\0020\007X\004¢\006\002\n\000R\020\020W\032\004\030\0010XX\016¢\006\002\n\000R\016\020Y\032\0020#X\004¢\006\002\n\000R\016\020Z\032\0020#X\004¢\006\002\n\000R\016\020[\032\0020#X\016¢\006\002\n\000R\016\020\\\032\0020\026X\016¢\006\002\n\000R\016\020]\032\0020\007X\004¢\006\002\n\000R\016\020^\032\0020#X\004¢\006\002\n\000R\016\020_\032\0020#X\004¢\006\002\n\000R\016\020`\032\0020\036X\004¢\006\002\n\000¨\006\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/OldScaffold;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "FallFastplace", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Fastplace", "RotConditionValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "Rotairticks", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "airSafeValue", "airticks", "airtime", "", "autoBlockValue", "autojump", "autovalue", "blocksAmount", "getBlocksAmount", "()I", "blocksToEagleValue", "canPlace", "", "canRot", "counterDisplayValue", "getCounterDisplayValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "delay", "", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "downValue", "eagleSneaking", "eagleValue", "edgeDistanceValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "expandLengthValue", "f", "facesBlock", "falldowndelay", "keepLengthValue", "keepRotationValue", "lastSlot", "launchY", "lockRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "lockRotationTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "lockpitch", "markValue", "maxDelayValue", "maxTurnSpeedValue", "minDelayValue", "minDistValue", "minTurnSpeedValue", "modeValue", "n", "omniDirectionalExpand", "placeConditionValue", "placeDelay", "placeModeValue", "placedBlocksWithoutEagle", "rotationsValue", "safeWalkValue", "sameYValue", "getSameYValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "searchAccuracyValue", "searchMode", "searchValue", "shouldGoDown", "silentRotationValue", "slot", "slowSpeed", "slowValue", "speedModifierValue", "sprintModeValue", "getSprintModeValue", "sprintValue", "getSprintValue", "strafeMode", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "tagmode", "targetPlace", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "timerValue", "xzRangeValue", "yRangeValue", "zitterDirection", "zitterMode", "zitterSpeed", "zitterStrength", "zitterTimer", "calcStepSize", "", "range", "", "findBlock", "", "expand", "onDisable", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "place", "search", "blockPosition", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "raycast", "setRotation", "rotation", "update", "XSJClient"})
/*      */ public class OldScaffold extends Module {
/*   46 */   private final ListValue tagmode = new ListValue("Tag", new String[] { "Normal", "Telly" }, "Telly");
/*   47 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal");
/*      */ 
/*      */   
/*   50 */   private final IntegerValue maxDelayValue = new OldScaffold$maxDelayValue$1("MaxDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/OldScaffold$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class OldScaffold$maxDelayValue$1 extends IntegerValue { OldScaffold$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(int oldValue, int newValue) {
/*   52 */       int minDelay = ((Number)OldScaffold.this.minDelayValue.get()).intValue();
/*   53 */       if (minDelay > newValue) {
/*   54 */         set(Integer.valueOf(minDelay));
/*      */       }
/*      */     } }
/*      */ 
/*      */   
/*   59 */   private final IntegerValue minDelayValue = new OldScaffold$minDelayValue$1("MinDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/OldScaffold$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class OldScaffold$minDelayValue$1 extends IntegerValue { OldScaffold$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(int oldValue, int newValue) {
/*   61 */       int maxDelay = ((Number)OldScaffold.this.maxDelayValue.get()).intValue();
/*   62 */       if (maxDelay < newValue)
/*   63 */         set(Integer.valueOf(maxDelay)); 
/*      */     } }
/*      */ 
/*      */   
/*   67 */   private final IntegerValue falldowndelay = new IntegerValue("FallDownDelay", 0, 0, 1000);
/*      */   
/*   69 */   private final BoolValue placeDelay = new BoolValue("PlaceDelay", true);
/*      */ 
/*      */   
/*   72 */   private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "Off", "Pick", "Spoof", "Switch" }, "Spoof");
/*      */   @NotNull
/*   74 */   private final BoolValue sprintValue = new BoolValue("Sprint", true); @NotNull public final BoolValue getSprintValue() { return this.sprintValue; } @NotNull
/*   75 */   private final ListValue sprintModeValue = new ListValue("SprintMode", new String[] { "off", "ground", "air" }, "air"); @NotNull public final ListValue getSprintModeValue() { return this.sprintModeValue; }
/*   76 */    private final BoolValue swingValue = new BoolValue("Swing", true);
/*   77 */   private final BoolValue searchValue = new BoolValue("Search", true);
/*   78 */   private final BoolValue downValue = new BoolValue("Down", true);
/*   79 */   private final ListValue placeModeValue = new ListValue("PlaceTiming", new String[] { "Pre", "Post" }, "Post");
/*   80 */   private final ListValue placeConditionValue = new ListValue("PlaceCondition", new String[] { "Always", "DelayAir", "FallDown" }, "Always");
/*   81 */   private final ListValue RotConditionValue = new ListValue("RotCondition", new String[] { "Always", "DelayAir", "FallDown" }, "Always");
/*      */   private boolean f;
/*      */   private boolean n;
/*      */   private boolean canPlace;
/*      */   private boolean canRot;
/*      */   private int airtime;
/*   87 */   private final IntegerValue airticks = new IntegerValue("PlaceAirTime", 0, 0, 10);
/*   88 */   private final IntegerValue Rotairticks = new IntegerValue("RotAirTime", 0, 0, 10);
/*      */ 
/*      */   
/*   91 */   private final ListValue eagleValue = new ListValue("Eagle", new String[] { "Normal", "Silent", "Off" }, "Normal");
/*   92 */   private final IntegerValue blocksToEagleValue = new IntegerValue("BlocksToEagle", 0, 0, 10);
/*   93 */   private final FloatValue edgeDistanceValue = new FloatValue("EagleEdgeDistance", 0.0F, 0.0F, 0.5F);
/*      */ 
/*      */   
/*   96 */   private final BoolValue omniDirectionalExpand = new BoolValue("OmniDirectionalExpand", false);
/*   97 */   private final IntegerValue expandLengthValue = new IntegerValue("ExpandLength", 1, 1, 6);
/*      */ 
/*      */   
/*  100 */   private final ListValue strafeMode = new ListValue("Strafe", new String[] { "Off", "AAC" }, "Off");
/*  101 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/*  102 */   private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true);
/*  103 */   private final BoolValue keepRotationValue = new BoolValue("KeepRotation", true);
/*  104 */   private final IntegerValue keepLengthValue = new IntegerValue("KeepRotationLength", 0, 0, 20);
/*      */ 
/*      */   
/*  107 */   private final ListValue searchMode = new ListValue("XYZSearch", new String[] { "Auto", "AutoCenter", "Manual" }, "AutoCenter");
/*  108 */   private final FloatValue xzRangeValue = new FloatValue("xzRange", 0.8F, 0.0F, 1.0F);
/*  109 */   private FloatValue yRangeValue = new FloatValue("yRange", 0.8F, 0.0F, 1.0F);
/*  110 */   private final FloatValue minDistValue = new FloatValue("MinDist", 0.0F, 0.0F, 0.2F);
/*      */ 
/*      */   
/*  113 */   private final IntegerValue searchAccuracyValue = new OldScaffold$searchAccuracyValue$1("SearchAccuracy", 8, 1, 16); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/OldScaffold$searchAccuracyValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class OldScaffold$searchAccuracyValue$1 extends IntegerValue { OldScaffold$searchAccuracyValue$1(String $super_call_param$0, int $super_call_param$1, int $super_call_param$2, int $super_call_param$3) { super($super_call_param$0, $super_call_param$1, $super_call_param$2, $super_call_param$3); }
/*      */      protected void onChanged(int oldValue, int newValue) {
/*  115 */       if (getMaximum() < newValue) {
/*  116 */         set(Integer.valueOf(getMaximum()));
/*  117 */       } else if (getMinimum() > newValue) {
/*  118 */         set(Integer.valueOf(getMinimum()));
/*      */       } 
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*  124 */   private final FloatValue maxTurnSpeedValue = new OldScaffold$maxTurnSpeedValue$1("MaxTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/OldScaffold$maxTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class OldScaffold$maxTurnSpeedValue$1 extends FloatValue { OldScaffold$maxTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(float oldValue, float newValue) {
/*  126 */       float v = ((Number)OldScaffold.this.minTurnSpeedValue.get()).floatValue();
/*  127 */       if (v > newValue) set(Float.valueOf(v)); 
/*  128 */       if (getMaximum() < newValue) {
/*  129 */         set(Float.valueOf(getMaximum()));
/*  130 */       } else if (getMinimum() > newValue) {
/*  131 */         set(Float.valueOf(getMinimum()));
/*      */       } 
/*      */     } }
/*      */   
/*  135 */   private final FloatValue minTurnSpeedValue = new OldScaffold$minTurnSpeedValue$1("MinTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/OldScaffold$minTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class OldScaffold$minTurnSpeedValue$1 extends FloatValue { OldScaffold$minTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(float oldValue, float newValue) {
/*  137 */       float v = ((Number)OldScaffold.this.maxTurnSpeedValue.get()).floatValue();
/*  138 */       if (v < newValue) set(Float.valueOf(v)); 
/*  139 */       if (getMaximum() < newValue) {
/*  140 */         set(Float.valueOf(getMaximum()));
/*  141 */       } else if (getMinimum() > newValue) {
/*  142 */         set(Float.valueOf(getMinimum()));
/*      */       } 
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*  148 */   private final ListValue zitterMode = new ListValue("Zitter", new String[] { "Off", "Teleport", "Smooth" }, "Off");
/*  149 */   private final FloatValue zitterSpeed = new FloatValue("ZitterSpeed", 0.13F, 0.1F, 0.3F);
/*  150 */   private final FloatValue zitterStrength = new FloatValue("ZitterStrength", 0.05F, 0.0F, 0.2F);
/*      */ 
/*      */   
/*  153 */   private final FloatValue timerValue = new FloatValue("Timer", 1.0F, 0.1F, 10.0F);
/*  154 */   private final FloatValue speedModifierValue = new FloatValue("SpeedModifier", 1.0F, 0.0F, 2.0F);
/*  155 */   private final BoolValue slowValue = new BoolValue("Slow", false);
/*  156 */   private final FloatValue slowSpeed = new FloatValue("SlowSpeed", 0.6F, 0.2F, 0.8F);
/*  157 */   private final BoolValue autojump = new BoolValue("AutoJump", true);
/*  158 */   private final ListValue lockpitch = new ListValue("TellyPitchFix", new String[] { "OnEnabler", "OnUpdate" }, "OnEnabler");
/*  159 */   private final BoolValue autovalue = new BoolValue("AutoSameY", false);
/*      */   @NotNull
/*  161 */   private final BoolValue sameYValue = new BoolValue("SameY", false); @NotNull public final BoolValue getSameYValue() { return this.sameYValue; }
/*  162 */    private final BoolValue safeWalkValue = new BoolValue("SafeWalk", true);
/*  163 */   private final BoolValue airSafeValue = new BoolValue("AirSafe", false);
/*  164 */   private final BoolValue FallFastplace = new BoolValue("Fallfastplace", false);
/*  165 */   private final BoolValue Fastplace = new BoolValue("fastplace", false);
/*      */   @Nullable
/*  167 */   public final ListValue getCounterDisplayValue() { return this.counterDisplayValue; } @Nullable
/*  168 */   private final ListValue counterDisplayValue = new ListValue("Counter", new String[] { "Off", "Simple", "Advanced", "Sigma", "Novoline", "Rise" }, "Simple");
/*  169 */   private final BoolValue markValue = new BoolValue("Mark", false);
/*      */   
/*      */   private int lastSlot;
/*      */   
/*      */   private PlaceInfo targetPlace;
/*      */   
/*      */   private Rotation lockRotation;
/*  176 */   private TickTimer lockRotationTimer = new TickTimer();
/*      */ 
/*      */   
/*      */   private int launchY;
/*      */ 
/*      */   
/*      */   private boolean facesBlock;
/*      */ 
/*      */   
/*      */   private int slot;
/*      */   
/*      */   private boolean zitterDirection;
/*      */   
/*  189 */   private final MSTimer delayTimer = new MSTimer();
/*  190 */   private final MSTimer zitterTimer = new MSTimer();
/*      */   
/*      */   private long delay;
/*      */   
/*      */   private int placedBlocksWithoutEagle;
/*      */   
/*      */   private boolean eagleSneaking;
/*      */   
/*      */   private boolean shouldGoDown;
/*      */ 
/*      */   
/*      */   public void onEnable() {
/*  202 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*  203 */       this.canPlace = false;
/*  204 */       this.canRot = false;
/*  205 */       this.f = false;
/*  206 */       this.airtime = 0;
/*  207 */       this.launchY = MathKt.roundToInt(player.getPosY());
/*  208 */       this.slot = player.getInventory().getCurrentItem();
/*  209 */       this.facesBlock = false;
/*  210 */       if (Intrinsics.areEqual(this.lockpitch.get(), "OnEnabler")) {
/*  211 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setRotationPitch(26.5F);
/*      */       } 
/*      */       return; }
/*      */     
/*      */     MinecraftInstance.mc.getThePlayer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   private final void onUpdate(UpdateEvent event) {
/*      */     // Byte code:
/*      */     //   0: bipush #57
/*      */     //   2: invokestatic isKeyDown : (I)Z
/*      */     //   5: ifeq -> 38
/*      */     //   8: aload_0
/*      */     //   9: getfield autovalue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   12: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   15: checkcast java/lang/Boolean
/*      */     //   18: invokevirtual booleanValue : ()Z
/*      */     //   21: ifeq -> 38
/*      */     //   24: aload_0
/*      */     //   25: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   28: iconst_0
/*      */     //   29: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*      */     //   32: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   35: goto -> 49
/*      */     //   38: aload_0
/*      */     //   39: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   42: iconst_1
/*      */     //   43: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*      */     //   46: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   49: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   52: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   57: dup
/*      */     //   58: ifnull -> 64
/*      */     //   61: goto -> 66
/*      */     //   64: pop
/*      */     //   65: return
/*      */     //   66: astore_2
/*      */     //   67: aload_0
/*      */     //   68: getfield autojump : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   71: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   74: checkcast java/lang/Boolean
/*      */     //   77: invokevirtual booleanValue : ()Z
/*      */     //   80: ifeq -> 215
/*      */     //   83: invokestatic isMoving : ()Z
/*      */     //   86: ifeq -> 215
/*      */     //   89: aload_2
/*      */     //   90: invokeinterface getOnGround : ()Z
/*      */     //   95: ifeq -> 215
/*      */     //   98: aload_2
/*      */     //   99: invokeinterface isSneaking : ()Z
/*      */     //   104: ifne -> 215
/*      */     //   107: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   110: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   115: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   120: invokeinterface isKeyDown : ()Z
/*      */     //   125: ifne -> 215
/*      */     //   128: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   131: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   136: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   141: invokeinterface isKeyDown : ()Z
/*      */     //   146: ifne -> 215
/*      */     //   149: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   152: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   157: dup
/*      */     //   158: ifnonnull -> 164
/*      */     //   161: invokestatic throwNpe : ()V
/*      */     //   164: aload_2
/*      */     //   165: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   168: aload_2
/*      */     //   169: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   174: dconst_0
/*      */     //   175: ldc2_w -0.5
/*      */     //   178: dconst_0
/*      */     //   179: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   184: ldc2_w -0.001
/*      */     //   187: dconst_0
/*      */     //   188: ldc2_w -0.001
/*      */     //   191: invokeinterface expand : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   196: invokeinterface getCollidingBoundingBoxes : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)Ljava/util/Collection;
/*      */     //   201: invokeinterface isEmpty : ()Z
/*      */     //   206: ifeq -> 215
/*      */     //   209: aload_2
/*      */     //   210: invokeinterface jump : ()V
/*      */     //   215: aload_0
/*      */     //   216: getfield sprintValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   219: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   222: checkcast java/lang/Boolean
/*      */     //   225: invokevirtual booleanValue : ()Z
/*      */     //   228: ifeq -> 411
/*      */     //   231: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   234: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   239: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   242: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   247: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   252: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*      */     //   257: ifne -> 279
/*      */     //   260: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   263: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   268: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   273: iconst_0
/*      */     //   274: invokeinterface setPressed : (Z)V
/*      */     //   279: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   282: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   287: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   290: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   295: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   300: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*      */     //   305: ifeq -> 327
/*      */     //   308: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   311: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   316: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   321: iconst_1
/*      */     //   322: invokeinterface setPressed : (Z)V
/*      */     //   327: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   330: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   335: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   340: invokeinterface isKeyDown : ()Z
/*      */     //   345: ifeq -> 369
/*      */     //   348: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   351: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   356: dup
/*      */     //   357: ifnonnull -> 363
/*      */     //   360: invokestatic throwNpe : ()V
/*      */     //   363: iconst_1
/*      */     //   364: invokeinterface setSprinting : (Z)V
/*      */     //   369: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   372: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   377: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   382: invokeinterface isKeyDown : ()Z
/*      */     //   387: ifne -> 411
/*      */     //   390: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   393: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   398: dup
/*      */     //   399: ifnonnull -> 405
/*      */     //   402: invokestatic throwNpe : ()V
/*      */     //   405: iconst_0
/*      */     //   406: invokeinterface setSprinting : (Z)V
/*      */     //   411: aload_0
/*      */     //   412: getfield lockpitch : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   415: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   418: checkcast java/lang/String
/*      */     //   421: ldc_w 'OnUpdate'
/*      */     //   424: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   427: ifeq -> 452
/*      */     //   430: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   433: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   438: dup
/*      */     //   439: ifnonnull -> 445
/*      */     //   442: invokestatic throwNpe : ()V
/*      */     //   445: ldc 26.5
/*      */     //   447: invokeinterface setRotationPitch : (F)V
/*      */     //   452: aload_2
/*      */     //   453: invokeinterface getOnGround : ()Z
/*      */     //   458: ifne -> 476
/*      */     //   461: aload_0
/*      */     //   462: dup
/*      */     //   463: getfield airtime : I
/*      */     //   466: dup
/*      */     //   467: istore_3
/*      */     //   468: iconst_1
/*      */     //   469: iadd
/*      */     //   470: putfield airtime : I
/*      */     //   473: goto -> 591
/*      */     //   476: aload_0
/*      */     //   477: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   480: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   483: checkcast java/lang/String
/*      */     //   486: ldc_w 'falldown'
/*      */     //   489: iconst_1
/*      */     //   490: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   493: ifne -> 516
/*      */     //   496: aload_0
/*      */     //   497: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   500: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   503: checkcast java/lang/String
/*      */     //   506: ldc_w 'delayair'
/*      */     //   509: iconst_1
/*      */     //   510: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   513: ifeq -> 586
/*      */     //   516: aload_0
/*      */     //   517: lconst_0
/*      */     //   518: putfield delay : J
/*      */     //   521: aload_0
/*      */     //   522: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   525: invokevirtual reset : ()V
/*      */     //   528: aload_0
/*      */     //   529: iconst_0
/*      */     //   530: putfield eagleSneaking : Z
/*      */     //   533: aload_0
/*      */     //   534: iconst_0
/*      */     //   535: putfield shouldGoDown : Z
/*      */     //   538: aload_0
/*      */     //   539: iconst_0
/*      */     //   540: putfield canPlace : Z
/*      */     //   543: aload_0
/*      */     //   544: iconst_0
/*      */     //   545: putfield canRot : Z
/*      */     //   548: aload_0
/*      */     //   549: iconst_0
/*      */     //   550: putfield f : Z
/*      */     //   553: aload_0
/*      */     //   554: aload_2
/*      */     //   555: invokeinterface getPosY : ()D
/*      */     //   560: invokestatic roundToInt : (D)I
/*      */     //   563: putfield launchY : I
/*      */     //   566: aload_0
/*      */     //   567: aload_2
/*      */     //   568: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   573: invokeinterface getCurrentItem : ()I
/*      */     //   578: putfield slot : I
/*      */     //   581: aload_0
/*      */     //   582: iconst_0
/*      */     //   583: putfield facesBlock : Z
/*      */     //   586: aload_0
/*      */     //   587: iconst_0
/*      */     //   588: putfield airtime : I
/*      */     //   591: aload_0
/*      */     //   592: aload_0
/*      */     //   593: getfield airtime : I
/*      */     //   596: aload_0
/*      */     //   597: getfield airticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   600: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   603: checkcast java/lang/Number
/*      */     //   606: invokevirtual intValue : ()I
/*      */     //   609: if_icmple -> 616
/*      */     //   612: iconst_1
/*      */     //   613: goto -> 617
/*      */     //   616: iconst_0
/*      */     //   617: putfield f : Z
/*      */     //   620: aload_0
/*      */     //   621: aload_0
/*      */     //   622: getfield airtime : I
/*      */     //   625: aload_0
/*      */     //   626: getfield Rotairticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   629: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   632: checkcast java/lang/Number
/*      */     //   635: invokevirtual intValue : ()I
/*      */     //   638: if_icmple -> 645
/*      */     //   641: iconst_1
/*      */     //   642: goto -> 646
/*      */     //   645: iconst_0
/*      */     //   646: putfield n : Z
/*      */     //   649: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   652: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   657: aload_0
/*      */     //   658: getfield timerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   661: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   664: checkcast java/lang/Number
/*      */     //   667: invokevirtual floatValue : ()F
/*      */     //   670: invokeinterface setTimerSpeed : (F)V
/*      */     //   675: aload_0
/*      */     //   676: aload_0
/*      */     //   677: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   680: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   683: checkcast java/lang/String
/*      */     //   686: ldc_w 'falldown'
/*      */     //   689: iconst_1
/*      */     //   690: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   693: ifeq -> 722
/*      */     //   696: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   699: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   704: dup
/*      */     //   705: ifnonnull -> 711
/*      */     //   708: invokestatic throwNpe : ()V
/*      */     //   711: invokeinterface getFallDistance : ()F
/*      */     //   716: iconst_0
/*      */     //   717: i2f
/*      */     //   718: fcmpl
/*      */     //   719: ifgt -> 792
/*      */     //   722: aload_0
/*      */     //   723: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   726: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   729: checkcast java/lang/String
/*      */     //   732: ldc_w 'always'
/*      */     //   735: iconst_1
/*      */     //   736: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   739: ifne -> 792
/*      */     //   742: aload_0
/*      */     //   743: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   746: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   749: checkcast java/lang/String
/*      */     //   752: ldc_w 'delayair'
/*      */     //   755: iconst_1
/*      */     //   756: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   759: ifeq -> 796
/*      */     //   762: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   765: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   770: dup
/*      */     //   771: ifnonnull -> 777
/*      */     //   774: invokestatic throwNpe : ()V
/*      */     //   777: invokeinterface getOnGround : ()Z
/*      */     //   782: ifne -> 796
/*      */     //   785: aload_0
/*      */     //   786: getfield f : Z
/*      */     //   789: ifeq -> 796
/*      */     //   792: iconst_1
/*      */     //   793: goto -> 797
/*      */     //   796: iconst_0
/*      */     //   797: putfield canPlace : Z
/*      */     //   800: aload_0
/*      */     //   801: aload_0
/*      */     //   802: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   805: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   808: checkcast java/lang/String
/*      */     //   811: ldc_w 'falldown'
/*      */     //   814: iconst_1
/*      */     //   815: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   818: ifeq -> 847
/*      */     //   821: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   824: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   829: dup
/*      */     //   830: ifnonnull -> 836
/*      */     //   833: invokestatic throwNpe : ()V
/*      */     //   836: invokeinterface getFallDistance : ()F
/*      */     //   841: iconst_0
/*      */     //   842: i2f
/*      */     //   843: fcmpl
/*      */     //   844: ifgt -> 917
/*      */     //   847: aload_0
/*      */     //   848: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   851: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   854: checkcast java/lang/String
/*      */     //   857: ldc_w 'always'
/*      */     //   860: iconst_1
/*      */     //   861: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   864: ifne -> 917
/*      */     //   867: aload_0
/*      */     //   868: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   871: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   874: checkcast java/lang/String
/*      */     //   877: ldc_w 'delayair'
/*      */     //   880: iconst_1
/*      */     //   881: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   884: ifeq -> 921
/*      */     //   887: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   890: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   895: dup
/*      */     //   896: ifnonnull -> 902
/*      */     //   899: invokestatic throwNpe : ()V
/*      */     //   902: invokeinterface getOnGround : ()Z
/*      */     //   907: ifne -> 921
/*      */     //   910: aload_0
/*      */     //   911: getfield n : Z
/*      */     //   914: ifeq -> 921
/*      */     //   917: iconst_1
/*      */     //   918: goto -> 922
/*      */     //   921: iconst_0
/*      */     //   922: putfield canRot : Z
/*      */     //   925: aload_0
/*      */     //   926: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   929: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   932: checkcast java/lang/String
/*      */     //   935: ldc_w 'off'
/*      */     //   938: iconst_1
/*      */     //   939: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   942: ifne -> 1031
/*      */     //   945: aload_0
/*      */     //   946: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   949: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   952: checkcast java/lang/String
/*      */     //   955: ldc_w 'ground'
/*      */     //   958: iconst_1
/*      */     //   959: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   962: ifeq -> 988
/*      */     //   965: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   968: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   973: dup
/*      */     //   974: ifnonnull -> 980
/*      */     //   977: invokestatic throwNpe : ()V
/*      */     //   980: invokeinterface getOnGround : ()Z
/*      */     //   985: ifeq -> 1031
/*      */     //   988: aload_0
/*      */     //   989: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   992: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   995: checkcast java/lang/String
/*      */     //   998: ldc_w 'air'
/*      */     //   1001: iconst_1
/*      */     //   1002: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   1005: ifeq -> 1052
/*      */     //   1008: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1011: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1016: dup
/*      */     //   1017: ifnonnull -> 1023
/*      */     //   1020: invokestatic throwNpe : ()V
/*      */     //   1023: invokeinterface getOnGround : ()Z
/*      */     //   1028: ifeq -> 1052
/*      */     //   1031: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1034: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1039: dup
/*      */     //   1040: ifnonnull -> 1046
/*      */     //   1043: invokestatic throwNpe : ()V
/*      */     //   1046: iconst_0
/*      */     //   1047: invokeinterface setSprinting : (Z)V
/*      */     //   1052: aload_0
/*      */     //   1053: aload_0
/*      */     //   1054: getfield downValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1057: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1060: checkcast java/lang/Boolean
/*      */     //   1063: invokevirtual booleanValue : ()Z
/*      */     //   1066: ifeq -> 1112
/*      */     //   1069: aload_0
/*      */     //   1070: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1073: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1076: checkcast java/lang/Boolean
/*      */     //   1079: invokevirtual booleanValue : ()Z
/*      */     //   1082: ifne -> 1112
/*      */     //   1085: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1088: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*      */     //   1091: getfield field_74311_E : Lnet/minecraft/client/settings/KeyBinding;
/*      */     //   1094: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*      */     //   1097: ifeq -> 1112
/*      */     //   1100: aload_0
/*      */     //   1101: invokevirtual getBlocksAmount : ()I
/*      */     //   1104: iconst_1
/*      */     //   1105: if_icmple -> 1112
/*      */     //   1108: iconst_1
/*      */     //   1109: goto -> 1113
/*      */     //   1112: iconst_0
/*      */     //   1113: putfield shouldGoDown : Z
/*      */     //   1116: aload_0
/*      */     //   1117: getfield shouldGoDown : Z
/*      */     //   1120: ifeq -> 1142
/*      */     //   1123: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1126: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   1131: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   1136: iconst_0
/*      */     //   1137: invokeinterface setPressed : (Z)V
/*      */     //   1142: aload_0
/*      */     //   1143: getfield slowValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1146: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1149: checkcast java/lang/Boolean
/*      */     //   1152: invokevirtual booleanValue : ()Z
/*      */     //   1155: ifeq -> 1210
/*      */     //   1158: aload_2
/*      */     //   1159: aload_2
/*      */     //   1160: invokeinterface getMotionX : ()D
/*      */     //   1165: aload_0
/*      */     //   1166: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1169: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1172: checkcast java/lang/Number
/*      */     //   1175: invokevirtual doubleValue : ()D
/*      */     //   1178: dmul
/*      */     //   1179: invokeinterface setMotionX : (D)V
/*      */     //   1184: aload_2
/*      */     //   1185: aload_2
/*      */     //   1186: invokeinterface getMotionZ : ()D
/*      */     //   1191: aload_0
/*      */     //   1192: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1195: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1198: checkcast java/lang/Number
/*      */     //   1201: invokevirtual doubleValue : ()D
/*      */     //   1204: dmul
/*      */     //   1205: invokeinterface setMotionZ : (D)V
/*      */     //   1210: aload_0
/*      */     //   1211: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1214: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1217: checkcast java/lang/String
/*      */     //   1220: ldc_w 'Off'
/*      */     //   1223: iconst_1
/*      */     //   1224: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   1227: ifne -> 1689
/*      */     //   1230: aload_0
/*      */     //   1231: getfield shouldGoDown : Z
/*      */     //   1234: ifne -> 1689
/*      */     //   1237: ldc2_w 0.5
/*      */     //   1240: dstore_3
/*      */     //   1241: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*      */     //   1244: dup
/*      */     //   1245: aload_2
/*      */     //   1246: invokeinterface getPosX : ()D
/*      */     //   1251: aload_2
/*      */     //   1252: invokeinterface getPosY : ()D
/*      */     //   1257: dconst_1
/*      */     //   1258: dsub
/*      */     //   1259: aload_2
/*      */     //   1260: invokeinterface getPosZ : ()D
/*      */     //   1265: invokespecial <init> : (DDD)V
/*      */     //   1268: astore #5
/*      */     //   1270: aload_0
/*      */     //   1271: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1274: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1277: checkcast java/lang/Number
/*      */     //   1280: invokevirtual floatValue : ()F
/*      */     //   1283: iconst_0
/*      */     //   1284: i2f
/*      */     //   1285: fcmpl
/*      */     //   1286: ifle -> 1479
/*      */     //   1289: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   1292: astore #8
/*      */     //   1294: aload #8
/*      */     //   1296: arraylength
/*      */     //   1297: istore #9
/*      */     //   1299: iconst_0
/*      */     //   1300: istore #7
/*      */     //   1302: iload #7
/*      */     //   1304: iload #9
/*      */     //   1306: if_icmpge -> 1479
/*      */     //   1309: aload #8
/*      */     //   1311: iload #7
/*      */     //   1313: aaload
/*      */     //   1314: astore #6
/*      */     //   1316: aload #6
/*      */     //   1318: getstatic net/minecraft/util/EnumFacing.UP : Lnet/minecraft/util/EnumFacing;
/*      */     //   1321: if_acmpeq -> 1332
/*      */     //   1324: aload #6
/*      */     //   1326: getstatic net/minecraft/util/EnumFacing.DOWN : Lnet/minecraft/util/EnumFacing;
/*      */     //   1329: if_acmpne -> 1335
/*      */     //   1332: goto -> 1473
/*      */     //   1335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1338: aload #6
/*      */     //   1340: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   1345: astore #10
/*      */     //   1347: aload #5
/*      */     //   1349: aload #10
/*      */     //   1351: iconst_0
/*      */     //   1352: iconst_2
/*      */     //   1353: aconst_null
/*      */     //   1354: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   1357: astore #11
/*      */     //   1359: iconst_0
/*      */     //   1360: istore #12
/*      */     //   1362: aload #11
/*      */     //   1364: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*      */     //   1367: dup
/*      */     //   1368: ifnull -> 1379
/*      */     //   1371: invokeinterface isReplaceable : ()Z
/*      */     //   1376: goto -> 1381
/*      */     //   1379: pop
/*      */     //   1380: iconst_0
/*      */     //   1381: ifeq -> 1473
/*      */     //   1384: aload #6
/*      */     //   1386: getstatic net/minecraft/util/EnumFacing.NORTH : Lnet/minecraft/util/EnumFacing;
/*      */     //   1389: if_acmpeq -> 1400
/*      */     //   1392: aload #6
/*      */     //   1394: getstatic net/minecraft/util/EnumFacing.SOUTH : Lnet/minecraft/util/EnumFacing;
/*      */     //   1397: if_acmpne -> 1430
/*      */     //   1400: aload #11
/*      */     //   1402: invokevirtual getZ : ()I
/*      */     //   1405: i2d
/*      */     //   1406: ldc2_w 0.5
/*      */     //   1409: dadd
/*      */     //   1410: aload_2
/*      */     //   1411: invokeinterface getPosZ : ()D
/*      */     //   1416: dsub
/*      */     //   1417: dstore #14
/*      */     //   1419: iconst_0
/*      */     //   1420: istore #16
/*      */     //   1422: dload #14
/*      */     //   1424: invokestatic abs : (D)D
/*      */     //   1427: goto -> 1457
/*      */     //   1430: aload #11
/*      */     //   1432: invokevirtual getX : ()I
/*      */     //   1435: i2d
/*      */     //   1436: ldc2_w 0.5
/*      */     //   1439: dadd
/*      */     //   1440: aload_2
/*      */     //   1441: invokeinterface getPosX : ()D
/*      */     //   1446: dsub
/*      */     //   1447: dstore #14
/*      */     //   1449: iconst_0
/*      */     //   1450: istore #16
/*      */     //   1452: dload #14
/*      */     //   1454: invokestatic abs : (D)D
/*      */     //   1457: ldc2_w 0.5
/*      */     //   1460: dsub
/*      */     //   1461: dstore #12
/*      */     //   1463: dload #12
/*      */     //   1465: dload_3
/*      */     //   1466: dcmpg
/*      */     //   1467: ifge -> 1473
/*      */     //   1470: dload #12
/*      */     //   1472: dstore_3
/*      */     //   1473: iinc #7, 1
/*      */     //   1476: goto -> 1302
/*      */     //   1479: aload_0
/*      */     //   1480: getfield placedBlocksWithoutEagle : I
/*      */     //   1483: aload_0
/*      */     //   1484: getfield blocksToEagleValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1487: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1490: checkcast java/lang/Number
/*      */     //   1493: invokevirtual intValue : ()I
/*      */     //   1496: if_icmplt -> 1676
/*      */     //   1499: iconst_0
/*      */     //   1500: istore #7
/*      */     //   1502: aload #5
/*      */     //   1504: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*      */     //   1507: dup
/*      */     //   1508: ifnull -> 1519
/*      */     //   1511: invokeinterface isReplaceable : ()Z
/*      */     //   1516: goto -> 1521
/*      */     //   1519: pop
/*      */     //   1520: iconst_0
/*      */     //   1521: ifne -> 1561
/*      */     //   1524: aload_0
/*      */     //   1525: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1528: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1531: checkcast java/lang/Number
/*      */     //   1534: invokevirtual floatValue : ()F
/*      */     //   1537: iconst_0
/*      */     //   1538: i2f
/*      */     //   1539: fcmpl
/*      */     //   1540: ifle -> 1565
/*      */     //   1543: dload_3
/*      */     //   1544: aload_0
/*      */     //   1545: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1548: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1551: checkcast java/lang/Number
/*      */     //   1554: invokevirtual doubleValue : ()D
/*      */     //   1557: dcmpg
/*      */     //   1558: ifge -> 1565
/*      */     //   1561: iconst_1
/*      */     //   1562: goto -> 1566
/*      */     //   1565: iconst_0
/*      */     //   1566: istore #6
/*      */     //   1568: aload_0
/*      */     //   1569: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1572: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1575: checkcast java/lang/String
/*      */     //   1578: ldc_w 'Silent'
/*      */     //   1581: iconst_1
/*      */     //   1582: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   1585: ifeq -> 1648
/*      */     //   1588: aload_0
/*      */     //   1589: getfield eagleSneaking : Z
/*      */     //   1592: iload #6
/*      */     //   1594: if_icmpeq -> 1639
/*      */     //   1597: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1600: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   1605: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1608: aload_2
/*      */     //   1609: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1612: iload #6
/*      */     //   1614: ifeq -> 1623
/*      */     //   1617: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*      */     //   1620: goto -> 1626
/*      */     //   1623: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*      */     //   1626: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*      */     //   1631: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   1634: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   1639: aload_0
/*      */     //   1640: iload #6
/*      */     //   1642: putfield eagleSneaking : Z
/*      */     //   1645: goto -> 1668
/*      */     //   1648: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1651: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   1656: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   1661: iload #6
/*      */     //   1663: invokeinterface setPressed : (Z)V
/*      */     //   1668: aload_0
/*      */     //   1669: iconst_0
/*      */     //   1670: putfield placedBlocksWithoutEagle : I
/*      */     //   1673: goto -> 1689
/*      */     //   1676: aload_0
/*      */     //   1677: dup
/*      */     //   1678: getfield placedBlocksWithoutEagle : I
/*      */     //   1681: dup
/*      */     //   1682: istore #6
/*      */     //   1684: iconst_1
/*      */     //   1685: iadd
/*      */     //   1686: putfield placedBlocksWithoutEagle : I
/*      */     //   1689: aload_2
/*      */     //   1690: invokeinterface getOnGround : ()Z
/*      */     //   1695: ifeq -> 2252
/*      */     //   1698: aload_0
/*      */     //   1699: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1702: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1705: checkcast java/lang/String
/*      */     //   1708: astore_3
/*      */     //   1709: iconst_0
/*      */     //   1710: istore #4
/*      */     //   1712: aload_3
/*      */     //   1713: dup
/*      */     //   1714: ifnonnull -> 1728
/*      */     //   1717: new kotlin/TypeCastException
/*      */     //   1720: dup
/*      */     //   1721: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   1724: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   1727: athrow
/*      */     //   1728: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   1731: dup
/*      */     //   1732: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   1735: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   1738: astore_3
/*      */     //   1739: aload_3
/*      */     //   1740: invokevirtual hashCode : ()I
/*      */     //   1743: tableswitch default -> 1783, 1388740000 -> 1760
/*      */     //   1760: aload_3
/*      */     //   1761: ldc_w 'rewinside'
/*      */     //   1764: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1767: ifeq -> 1783
/*      */     //   1770: ldc_w 0.2
/*      */     //   1773: invokestatic strafe : (F)V
/*      */     //   1776: aload_2
/*      */     //   1777: dconst_0
/*      */     //   1778: invokeinterface setMotionY : (D)V
/*      */     //   1783: aload_0
/*      */     //   1784: getfield zitterMode : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1787: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1790: checkcast java/lang/String
/*      */     //   1793: astore_3
/*      */     //   1794: iconst_0
/*      */     //   1795: istore #4
/*      */     //   1797: aload_3
/*      */     //   1798: dup
/*      */     //   1799: ifnonnull -> 1813
/*      */     //   1802: new kotlin/TypeCastException
/*      */     //   1805: dup
/*      */     //   1806: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   1809: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   1812: athrow
/*      */     //   1813: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   1816: dup
/*      */     //   1817: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   1820: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   1823: astore_3
/*      */     //   1824: aload_3
/*      */     //   1825: invokevirtual hashCode : ()I
/*      */     //   1828: lookupswitch default -> 2252, -1360201941 -> 1864, -898533970 -> 1890, 109935 -> 1877
/*      */     //   1864: aload_3
/*      */     //   1865: ldc_w 'teleport'
/*      */     //   1868: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1871: ifeq -> 2252
/*      */     //   1874: goto -> 2097
/*      */     //   1877: aload_3
/*      */     //   1878: ldc_w 'off'
/*      */     //   1881: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1884: ifeq -> 2252
/*      */     //   1887: goto -> 1903
/*      */     //   1890: aload_3
/*      */     //   1891: ldc_w 'smooth'
/*      */     //   1894: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1897: ifeq -> 2252
/*      */     //   1900: goto -> 1904
/*      */     //   1903: return
/*      */     //   1904: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1907: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*      */     //   1910: getfield field_74366_z : Lnet/minecraft/client/settings/KeyBinding;
/*      */     //   1913: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*      */     //   1916: ifne -> 1938
/*      */     //   1919: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1922: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   1927: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   1932: iconst_0
/*      */     //   1933: invokeinterface setPressed : (Z)V
/*      */     //   1938: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1941: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*      */     //   1944: getfield field_74370_x : Lnet/minecraft/client/settings/KeyBinding;
/*      */     //   1947: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*      */     //   1950: ifne -> 1972
/*      */     //   1953: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1956: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   1961: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   1966: iconst_0
/*      */     //   1967: invokeinterface setPressed : (Z)V
/*      */     //   1972: aload_0
/*      */     //   1973: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   1976: ldc2_w 100
/*      */     //   1979: invokevirtual hasTimePassed : (J)Z
/*      */     //   1982: ifeq -> 2008
/*      */     //   1985: aload_0
/*      */     //   1986: aload_0
/*      */     //   1987: getfield zitterDirection : Z
/*      */     //   1990: ifne -> 1997
/*      */     //   1993: iconst_1
/*      */     //   1994: goto -> 1998
/*      */     //   1997: iconst_0
/*      */     //   1998: putfield zitterDirection : Z
/*      */     //   2001: aload_0
/*      */     //   2002: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   2005: invokevirtual reset : ()V
/*      */     //   2008: aload_0
/*      */     //   2009: getfield zitterDirection : Z
/*      */     //   2012: ifeq -> 2056
/*      */     //   2015: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2018: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   2023: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   2028: iconst_1
/*      */     //   2029: invokeinterface setPressed : (Z)V
/*      */     //   2034: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2037: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   2042: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   2047: iconst_0
/*      */     //   2048: invokeinterface setPressed : (Z)V
/*      */     //   2053: goto -> 2252
/*      */     //   2056: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2059: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   2064: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   2069: iconst_0
/*      */     //   2070: invokeinterface setPressed : (Z)V
/*      */     //   2075: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2078: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   2083: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   2088: iconst_1
/*      */     //   2089: invokeinterface setPressed : (Z)V
/*      */     //   2094: goto -> 2252
/*      */     //   2097: aload_0
/*      */     //   2098: getfield zitterSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   2101: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2104: checkcast java/lang/Number
/*      */     //   2107: invokevirtual floatValue : ()F
/*      */     //   2110: invokestatic strafe : (F)V
/*      */     //   2113: aload_2
/*      */     //   2114: invokeinterface getRotationYaw : ()F
/*      */     //   2119: f2d
/*      */     //   2120: aload_0
/*      */     //   2121: getfield zitterDirection : Z
/*      */     //   2124: ifeq -> 2133
/*      */     //   2127: ldc2_w 90.0
/*      */     //   2130: goto -> 2136
/*      */     //   2133: ldc2_w -90.0
/*      */     //   2136: dadd
/*      */     //   2137: invokestatic toRadians : (D)D
/*      */     //   2140: dstore #4
/*      */     //   2142: aload_2
/*      */     //   2143: aload_2
/*      */     //   2144: invokeinterface getMotionX : ()D
/*      */     //   2149: dstore #18
/*      */     //   2151: astore #17
/*      */     //   2153: iconst_0
/*      */     //   2154: istore #6
/*      */     //   2156: dload #4
/*      */     //   2158: invokestatic sin : (D)D
/*      */     //   2161: dstore #20
/*      */     //   2163: aload #17
/*      */     //   2165: dload #18
/*      */     //   2167: dload #20
/*      */     //   2169: aload_0
/*      */     //   2170: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   2173: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2176: checkcast java/lang/Number
/*      */     //   2179: invokevirtual doubleValue : ()D
/*      */     //   2182: dmul
/*      */     //   2183: dsub
/*      */     //   2184: invokeinterface setMotionX : (D)V
/*      */     //   2189: aload_2
/*      */     //   2190: aload_2
/*      */     //   2191: invokeinterface getMotionZ : ()D
/*      */     //   2196: dstore #18
/*      */     //   2198: astore #17
/*      */     //   2200: iconst_0
/*      */     //   2201: istore #6
/*      */     //   2203: dload #4
/*      */     //   2205: invokestatic cos : (D)D
/*      */     //   2208: dstore #20
/*      */     //   2210: aload #17
/*      */     //   2212: dload #18
/*      */     //   2214: dload #20
/*      */     //   2216: aload_0
/*      */     //   2217: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   2220: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2223: checkcast java/lang/Number
/*      */     //   2226: invokevirtual doubleValue : ()D
/*      */     //   2229: dmul
/*      */     //   2230: dadd
/*      */     //   2231: invokeinterface setMotionZ : (D)V
/*      */     //   2236: aload_0
/*      */     //   2237: aload_0
/*      */     //   2238: getfield zitterDirection : Z
/*      */     //   2241: ifne -> 2248
/*      */     //   2244: iconst_1
/*      */     //   2245: goto -> 2249
/*      */     //   2248: iconst_0
/*      */     //   2249: putfield zitterDirection : Z
/*      */     //   2252: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #217	-> 0
/*      */     //   #218	-> 24
/*      */     //   #220	-> 38
/*      */     //   #221	-> 49
/*      */     //   #222	-> 49
/*      */     //   #222	-> 64
/*      */     //   #223	-> 67
/*      */     //   #224	-> 83
/*      */     //   #225	-> 83
/*      */     //   #226	-> 83
/*      */     //   #225	-> 149
/*      */     //   #226	-> 168
/*      */     //   #225	-> 168
/*      */     //   #226	-> 168
/*      */     //   #225	-> 168
/*      */     //   #226	-> 174
/*      */     //   #225	-> 196
/*      */     //   #226	-> 201
/*      */     //   #227	-> 209
/*      */     //   #229	-> 215
/*      */     //   #230	-> 231
/*      */     //   #231	-> 260
/*      */     //   #233	-> 279
/*      */     //   #234	-> 308
/*      */     //   #236	-> 327
/*      */     //   #237	-> 348
/*      */     //   #239	-> 369
/*      */     //   #240	-> 390
/*      */     //   #243	-> 411
/*      */     //   #244	-> 430
/*      */     //   #246	-> 452
/*      */     //   #247	-> 461
/*      */     //   #249	-> 476
/*      */     //   #250	-> 516
/*      */     //   #251	-> 521
/*      */     //   #252	-> 528
/*      */     //   #253	-> 533
/*      */     //   #254	-> 538
/*      */     //   #255	-> 543
/*      */     //   #256	-> 548
/*      */     //   #257	-> 553
/*      */     //   #258	-> 566
/*      */     //   #259	-> 581
/*      */     //   #261	-> 586
/*      */     //   #263	-> 591
/*      */     //   #264	-> 591
/*      */     //   #265	-> 620
/*      */     //   #266	-> 649
/*      */     //   #267	-> 675
/*      */     //   #268	-> 800
/*      */     //   #269	-> 925
/*      */     //   #270	-> 925
/*      */     //   #271	-> 925
/*      */     //   #269	-> 925
/*      */     //   #270	-> 955
/*      */     //   #271	-> 998
/*      */     //   #273	-> 1031
/*      */     //   #275	-> 1052
/*      */     //   #276	-> 1052
/*      */     //   #277	-> 1116
/*      */     //   #278	-> 1123
/*      */     //   #280	-> 1142
/*      */     //   #281	-> 1158
/*      */     //   #282	-> 1184
/*      */     //   #285	-> 1210
/*      */     //   #286	-> 1237
/*      */     //   #287	-> 1241
/*      */     //   #288	-> 1270
/*      */     //   #289	-> 1289
/*      */     //   #290	-> 1316
/*      */     //   #291	-> 1332
/*      */     //   #293	-> 1335
/*      */     //   #294	-> 1347
/*      */     //   #295	-> 1359
/*      */     //   #1049	-> 1362
/*      */     //   #1049	-> 1379
/*      */     //   #296	-> 1384
/*      */     //   #297	-> 1400
/*      */     //   #299	-> 1430
/*      */     //   #296	-> 1457
/*      */     //   #300	-> 1457
/*      */     //   #296	-> 1461
/*      */     //   #302	-> 1463
/*      */     //   #303	-> 1470
/*      */     //   #289	-> 1473
/*      */     //   #308	-> 1479
/*      */     //   #309	-> 1499
/*      */     //   #310	-> 1499
/*      */     //   #1050	-> 1502
/*      */     //   #1050	-> 1519
/*      */     //   #310	-> 1524
/*      */     //   #309	-> 1566
/*      */     //   #311	-> 1568
/*      */     //   #312	-> 1588
/*      */     //   #313	-> 1597
/*      */     //   #314	-> 1605
/*      */     //   #315	-> 1608
/*      */     //   #316	-> 1617
/*      */     //   #318	-> 1623
/*      */     //   #315	-> 1626
/*      */     //   #314	-> 1626
/*      */     //   #313	-> 1634
/*      */     //   #323	-> 1639
/*      */     //   #325	-> 1648
/*      */     //   #326	-> 1668
/*      */     //   #327	-> 1668
/*      */     //   #329	-> 1676
/*      */     //   #330	-> 1689
/*      */     //   #332	-> 1689
/*      */     //   #333	-> 1698
/*      */     //   #334	-> 1760
/*      */     //   #335	-> 1770
/*      */     //   #336	-> 1776
/*      */     //   #338	-> 1783
/*      */     //   #339	-> 1783
/*      */     //   #362	-> 1864
/*      */     //   #340	-> 1877
/*      */     //   #343	-> 1890
/*      */     //   #341	-> 1903
/*      */     //   #344	-> 1904
/*      */     //   #345	-> 1919
/*      */     //   #347	-> 1938
/*      */     //   #348	-> 1953
/*      */     //   #350	-> 1972
/*      */     //   #351	-> 1985
/*      */     //   #352	-> 2001
/*      */     //   #354	-> 2008
/*      */     //   #355	-> 2015
/*      */     //   #356	-> 2034
/*      */     //   #358	-> 2056
/*      */     //   #359	-> 2075
/*      */     //   #360	-> 2094
/*      */     //   #363	-> 2097
/*      */     //   #364	-> 2113
/*      */     //   #365	-> 2142
/*      */     //   #365	-> 2169
/*      */     //   #366	-> 2189
/*      */     //   #366	-> 2216
/*      */     //   #367	-> 2236
/*      */     //   #369	-> 2252
/*      */     //   #371	-> 2252
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   1362	19	12	$i$f$isReplaceable	I
/*      */     //   1463	10	12	calcDif	D
/*      */     //   1359	114	11	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   1347	126	10	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   1316	160	6	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   1502	19	7	$i$f$isReplaceable	I
/*      */     //   1568	105	6	shouldEagle	Z
/*      */     //   1270	419	5	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   1241	448	3	dif	D
/*      */     //   2142	110	4	yaw	D
/*      */     //   67	2186	2	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	2253	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/OldScaffold;
/*      */     //   0	2253	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public final void onPacket(@NotNull PacketEvent event) {
/*  375 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof net.minecraft.network.play.server.SPacketDisconnect) {
/*  376 */       setState(false);
/*      */     }
/*  378 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*      */       return;
/*      */     }
/*      */     
/*  382 */     IPacket packet = event.getPacket();
/*  383 */     if (packet instanceof CPacketHeldItemChange) {
/*  384 */       this.slot = ((CPacketHeldItemChange)packet).func_149614_c();
/*      */     }
/*      */   }
/*      */   
/*      */   @EventTarget
/*      */   public final void onStrafe(@NotNull StrafeEvent event)
/*      */   {
/*  391 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*      */       return;
/*      */     }
/*  394 */     if (!this.canRot)
/*  395 */       return;  update();
/*  396 */     if (this.lockRotation != null) { Rotation rotation = this.lockRotation;
/*      */       
/*  398 */       if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue()))) {
/*  399 */         if (this.targetPlace == null) {
/*  400 */           rotation.setYaw(WMathHelper.wrapAngleTo180_float(MathKt.roundToInt(rotation.getYaw() / 45.0F) * 45.0F));
/*      */         }
/*  402 */         setRotation(rotation);
/*  403 */         this.lockRotationTimer.update();
/*      */         
/*  405 */         rotation.applyStrafeToPlayer(event);
/*  406 */         event.cancelEvent();
/*      */         
/*      */         return;
/*      */       } 
/*  410 */       if (RotationUtils.targetRotation != null) { Rotation targetRotation = RotationUtils.targetRotation;
/*  411 */         targetRotation.applyStrafeToPlayer(event);
/*  412 */         event.cancelEvent();
/*      */         return; }
/*      */       
/*      */       return; }
/*      */      } @EventTarget
/*  417 */   public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); EventState eventState = event.getEventState();
/*  418 */     if (!this.canRot)
/*      */       return; 
/*  420 */     if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue())) && this.lockRotation != null && 
/*  421 */       StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*      */       
/*  423 */       if (this.lockRotation == null) Intrinsics.throwNpe();  setRotation(this.lockRotation);
/*  424 */       if (eventState == EventState.POST) {
/*  425 */         this.lockRotationTimer.update();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  430 */     if ((this.facesBlock || !((Boolean)this.rotationsValue.get()).booleanValue()) && StringsKt.equals((String)this.placeModeValue.get(), eventState.getStateName(), true)) {
/*  431 */       if (!this.canPlace)
/*  432 */         return;  place();
/*      */     } 
/*  434 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((MinecraftInstance.mc.getThePlayer().getFallDistance() > false && ((Boolean)this.FallFastplace.get()).booleanValue()) || (this.canPlace && ((Boolean)this.Fastplace.get()).booleanValue())) {
/*  435 */       place();
/*      */     }
/*      */     
/*  438 */     if (eventState == EventState.PRE && StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*  439 */       update();
/*      */     }
/*      */ 
/*      */     
/*  443 */     if (this.targetPlace == null && ((Boolean)this.placeDelay.get()).booleanValue()) {
/*  444 */       this.delayTimer.reset();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void update() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield canRot : Z
/*      */     //   4: ifne -> 8
/*      */     //   7: return
/*      */     //   8: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   11: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   16: dup
/*      */     //   17: ifnull -> 23
/*      */     //   20: goto -> 25
/*      */     //   23: pop
/*      */     //   24: return
/*      */     //   25: astore_1
/*      */     //   26: aload_1
/*      */     //   27: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   32: ifnull -> 63
/*      */     //   35: aload_1
/*      */     //   36: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   41: dup
/*      */     //   42: ifnonnull -> 48
/*      */     //   45: invokestatic throwNpe : ()V
/*      */     //   48: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   53: instanceof net/minecraft/item/ItemBlock
/*      */     //   56: ifeq -> 63
/*      */     //   59: iconst_1
/*      */     //   60: goto -> 64
/*      */     //   63: iconst_0
/*      */     //   64: istore_2
/*      */     //   65: aload_0
/*      */     //   66: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   69: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   72: checkcast java/lang/String
/*      */     //   75: ldc_w 'off'
/*      */     //   78: iconst_1
/*      */     //   79: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   82: ifne -> 104
/*      */     //   85: invokestatic findAutoBlockBlock : ()I
/*      */     //   88: iconst_m1
/*      */     //   89: if_icmpne -> 100
/*      */     //   92: iload_2
/*      */     //   93: ifne -> 100
/*      */     //   96: iconst_1
/*      */     //   97: goto -> 113
/*      */     //   100: iconst_0
/*      */     //   101: goto -> 113
/*      */     //   104: iload_2
/*      */     //   105: ifne -> 112
/*      */     //   108: iconst_1
/*      */     //   109: goto -> 113
/*      */     //   112: iconst_0
/*      */     //   113: ifeq -> 117
/*      */     //   116: return
/*      */     //   117: aload_0
/*      */     //   118: aload_0
/*      */     //   119: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   122: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   125: checkcast java/lang/String
/*      */     //   128: ldc_w 'expand'
/*      */     //   131: iconst_1
/*      */     //   132: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   135: invokespecial findBlock : (Z)V
/*      */     //   138: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #449	-> 0
/*      */     //   #450	-> 8
/*      */     //   #450	-> 23
/*      */     //   #452	-> 26
/*      */     //   #453	-> 65
/*      */     //   #454	-> 65
/*      */     //   #453	-> 65
/*      */     //   #454	-> 75
/*      */     //   #455	-> 85
/*      */     //   #453	-> 113
/*      */     //   #457	-> 116
/*      */     //   #460	-> 117
/*      */     //   #461	-> 138
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   65	74	2	holdingItem	Z
/*      */     //   26	113	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	139	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/OldScaffold;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void setRotation(Rotation rotation) {
/*  464 */     if (!this.canRot)
/*  465 */       return;  if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*      */       
/*  467 */       if (((Boolean)this.silentRotationValue.get()).booleanValue())
/*  468 */       { RotationUtils.setTargetRotation(rotation, 0); }
/*      */       else
/*  470 */       { player.setRotationYaw(rotation.getYaw());
/*  471 */         player.setRotationPitch(rotation.getPitch()); }  return; }  MinecraftInstance.mc.getThePlayer();
/*      */   }
/*      */   public final void place() { // Byte code:
/*      */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   8: dup
/*      */     //   9: ifnull -> 15
/*      */     //   12: goto -> 17
/*      */     //   15: pop
/*      */     //   16: return
/*      */     //   17: astore_1
/*      */     //   18: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   21: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   26: dup
/*      */     //   27: ifnull -> 33
/*      */     //   30: goto -> 35
/*      */     //   33: pop
/*      */     //   34: return
/*      */     //   35: astore_2
/*      */     //   36: aload_0
/*      */     //   37: getfield canPlace : Z
/*      */     //   40: ifne -> 44
/*      */     //   43: return
/*      */     //   44: aload_0
/*      */     //   45: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   48: ifnonnull -> 75
/*      */     //   51: aload_0
/*      */     //   52: getfield placeDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   55: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   58: checkcast java/lang/Boolean
/*      */     //   61: invokevirtual booleanValue : ()Z
/*      */     //   64: ifeq -> 74
/*      */     //   67: aload_0
/*      */     //   68: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   71: invokevirtual reset : ()V
/*      */     //   74: return
/*      */     //   75: aload_0
/*      */     //   76: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   79: aload_0
/*      */     //   80: getfield delay : J
/*      */     //   83: invokevirtual hasTimePassed : (J)Z
/*      */     //   86: ifeq -> 132
/*      */     //   89: aload_0
/*      */     //   90: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   93: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   96: checkcast java/lang/Boolean
/*      */     //   99: invokevirtual booleanValue : ()Z
/*      */     //   102: ifeq -> 133
/*      */     //   105: aload_0
/*      */     //   106: getfield launchY : I
/*      */     //   109: iconst_1
/*      */     //   110: isub
/*      */     //   111: aload_0
/*      */     //   112: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   115: dup
/*      */     //   116: ifnonnull -> 122
/*      */     //   119: invokestatic throwNpe : ()V
/*      */     //   122: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   125: invokevirtual getYCoord : ()D
/*      */     //   128: d2i
/*      */     //   129: if_icmpeq -> 133
/*      */     //   132: return
/*      */     //   133: aload_1
/*      */     //   134: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   139: astore_3
/*      */     //   140: aload_3
/*      */     //   141: ifnull -> 217
/*      */     //   144: aload_3
/*      */     //   145: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   150: instanceof net/minecraft/item/ItemBlock
/*      */     //   153: ifeq -> 217
/*      */     //   156: aload_3
/*      */     //   157: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   162: dup
/*      */     //   163: ifnonnull -> 169
/*      */     //   166: invokestatic throwNpe : ()V
/*      */     //   169: dup
/*      */     //   170: ifnonnull -> 184
/*      */     //   173: new kotlin/TypeCastException
/*      */     //   176: dup
/*      */     //   177: ldc_w 'null cannot be cast to non-null type net.minecraft.item.ItemBlock'
/*      */     //   180: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   183: athrow
/*      */     //   184: checkcast net/minecraft/item/ItemBlock
/*      */     //   187: invokevirtual func_179223_d : ()Lnet/minecraft/block/Block;
/*      */     //   190: instanceof net/minecraft/block/BlockBush
/*      */     //   193: ifne -> 217
/*      */     //   196: aload_1
/*      */     //   197: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   202: dup
/*      */     //   203: ifnonnull -> 209
/*      */     //   206: invokestatic throwNpe : ()V
/*      */     //   209: invokeinterface getStackSize : ()I
/*      */     //   214: ifgt -> 634
/*      */     //   217: invokestatic findAutoBlockBlock : ()I
/*      */     //   220: istore #4
/*      */     //   222: iload #4
/*      */     //   224: iconst_m1
/*      */     //   225: if_icmpne -> 229
/*      */     //   228: return
/*      */     //   229: aload_0
/*      */     //   230: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   233: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   236: checkcast java/lang/String
/*      */     //   239: ldc_w 'Switch'
/*      */     //   242: iconst_1
/*      */     //   243: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   246: ifeq -> 330
/*      */     //   249: aload_0
/*      */     //   250: getfield slot : I
/*      */     //   253: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   256: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   261: dup
/*      */     //   262: ifnonnull -> 268
/*      */     //   265: invokestatic throwNpe : ()V
/*      */     //   268: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   273: invokeinterface getCurrentItem : ()I
/*      */     //   278: if_icmpeq -> 330
/*      */     //   281: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   284: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   289: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   292: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   295: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   300: dup
/*      */     //   301: ifnonnull -> 307
/*      */     //   304: invokestatic throwNpe : ()V
/*      */     //   307: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   312: invokeinterface getCurrentItem : ()I
/*      */     //   317: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*      */     //   322: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   325: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   330: aload_0
/*      */     //   331: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   334: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   337: checkcast java/lang/String
/*      */     //   340: astore #5
/*      */     //   342: iconst_0
/*      */     //   343: istore #6
/*      */     //   345: aload #5
/*      */     //   347: dup
/*      */     //   348: ifnonnull -> 362
/*      */     //   351: new kotlin/TypeCastException
/*      */     //   354: dup
/*      */     //   355: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   358: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   361: athrow
/*      */     //   362: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   365: dup
/*      */     //   366: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   369: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   372: astore #5
/*      */     //   374: aload #5
/*      */     //   376: invokevirtual hashCode : ()I
/*      */     //   379: lookupswitch default -> 615, -889473228 -> 462, 109935 -> 448, 3440673 -> 434, 109651721 -> 420
/*      */     //   420: aload #5
/*      */     //   422: ldc_w 'spoof'
/*      */     //   425: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   428: ifeq -> 615
/*      */     //   431: goto -> 509
/*      */     //   434: aload #5
/*      */     //   436: ldc_w 'pick'
/*      */     //   439: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   442: ifeq -> 615
/*      */     //   445: goto -> 477
/*      */     //   448: aload #5
/*      */     //   450: ldc_w 'off'
/*      */     //   453: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   456: ifeq -> 615
/*      */     //   459: goto -> 476
/*      */     //   462: aload #5
/*      */     //   464: ldc_w 'switch'
/*      */     //   467: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   470: ifeq -> 615
/*      */     //   473: goto -> 574
/*      */     //   476: return
/*      */     //   477: aload_1
/*      */     //   478: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   483: iload #4
/*      */     //   485: bipush #36
/*      */     //   487: isub
/*      */     //   488: invokeinterface setCurrentItem : (I)V
/*      */     //   493: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   496: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   501: invokeinterface updateController : ()V
/*      */     //   506: goto -> 615
/*      */     //   509: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   512: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   517: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   520: iload #4
/*      */     //   522: bipush #36
/*      */     //   524: isub
/*      */     //   525: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*      */     //   530: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   533: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   538: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   541: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   546: dup
/*      */     //   547: ifnonnull -> 553
/*      */     //   550: invokestatic throwNpe : ()V
/*      */     //   553: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*      */     //   558: iload #4
/*      */     //   560: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*      */     //   565: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   570: astore_3
/*      */     //   571: goto -> 615
/*      */     //   574: iload #4
/*      */     //   576: bipush #36
/*      */     //   578: isub
/*      */     //   579: aload_0
/*      */     //   580: getfield slot : I
/*      */     //   583: if_icmpeq -> 615
/*      */     //   586: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   589: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   594: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   597: iload #4
/*      */     //   599: bipush #36
/*      */     //   601: isub
/*      */     //   602: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*      */     //   607: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   610: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   615: aload_1
/*      */     //   616: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*      */     //   621: iload #4
/*      */     //   623: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*      */     //   628: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   633: astore_3
/*      */     //   634: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   637: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   642: aload_1
/*      */     //   643: aload_2
/*      */     //   644: aload_3
/*      */     //   645: aload_0
/*      */     //   646: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   649: dup
/*      */     //   650: ifnonnull -> 656
/*      */     //   653: invokestatic throwNpe : ()V
/*      */     //   656: invokevirtual getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   659: aload_0
/*      */     //   660: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   663: dup
/*      */     //   664: ifnonnull -> 670
/*      */     //   667: invokestatic throwNpe : ()V
/*      */     //   670: invokevirtual getEnumFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   673: aload_0
/*      */     //   674: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   677: dup
/*      */     //   678: ifnonnull -> 684
/*      */     //   681: invokestatic throwNpe : ()V
/*      */     //   684: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   687: invokeinterface onPlayerRightClick : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)Z
/*      */     //   692: ifeq -> 903
/*      */     //   695: aload_0
/*      */     //   696: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   699: invokevirtual reset : ()V
/*      */     //   702: aload_0
/*      */     //   703: aload_0
/*      */     //   704: getfield placeDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   707: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   710: checkcast java/lang/Boolean
/*      */     //   713: invokevirtual booleanValue : ()Z
/*      */     //   716: ifne -> 723
/*      */     //   719: lconst_0
/*      */     //   720: goto -> 795
/*      */     //   723: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   726: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   731: dup
/*      */     //   732: ifnonnull -> 738
/*      */     //   735: invokestatic throwNpe : ()V
/*      */     //   738: invokeinterface getFallDistance : ()F
/*      */     //   743: iconst_0
/*      */     //   744: i2f
/*      */     //   745: fcmpl
/*      */     //   746: ifle -> 766
/*      */     //   749: aload_0
/*      */     //   750: getfield falldowndelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   753: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   756: checkcast java/lang/Number
/*      */     //   759: invokevirtual intValue : ()I
/*      */     //   762: i2l
/*      */     //   763: goto -> 795
/*      */     //   766: aload_0
/*      */     //   767: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   770: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   773: checkcast java/lang/Number
/*      */     //   776: invokevirtual intValue : ()I
/*      */     //   779: aload_0
/*      */     //   780: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   783: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   786: checkcast java/lang/Number
/*      */     //   789: invokevirtual intValue : ()I
/*      */     //   792: invokestatic randomDelay : (II)J
/*      */     //   795: putfield delay : J
/*      */     //   798: aload_1
/*      */     //   799: invokeinterface getOnGround : ()Z
/*      */     //   804: ifeq -> 854
/*      */     //   807: aload_0
/*      */     //   808: getfield speedModifierValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   811: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   814: checkcast java/lang/Number
/*      */     //   817: invokevirtual floatValue : ()F
/*      */     //   820: fstore #4
/*      */     //   822: aload_1
/*      */     //   823: aload_1
/*      */     //   824: invokeinterface getMotionX : ()D
/*      */     //   829: fload #4
/*      */     //   831: f2d
/*      */     //   832: dmul
/*      */     //   833: invokeinterface setMotionX : (D)V
/*      */     //   838: aload_1
/*      */     //   839: aload_1
/*      */     //   840: invokeinterface getMotionZ : ()D
/*      */     //   845: fload #4
/*      */     //   847: f2d
/*      */     //   848: dmul
/*      */     //   849: invokeinterface setMotionZ : (D)V
/*      */     //   854: aload_0
/*      */     //   855: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   858: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   861: checkcast java/lang/Boolean
/*      */     //   864: invokevirtual booleanValue : ()Z
/*      */     //   867: ifeq -> 879
/*      */     //   870: aload_1
/*      */     //   871: invokeinterface swingItem : ()V
/*      */     //   876: goto -> 903
/*      */     //   879: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   882: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   887: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   890: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*      */     //   895: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   898: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   903: aload_0
/*      */     //   904: aconst_null
/*      */     //   905: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*      */     //   908: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   911: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #517	-> 0
/*      */     //   #517	-> 15
/*      */     //   #518	-> 18
/*      */     //   #518	-> 33
/*      */     //   #519	-> 36
/*      */     //   #520	-> 44
/*      */     //   #521	-> 51
/*      */     //   #522	-> 67
/*      */     //   #524	-> 74
/*      */     //   #527	-> 75
/*      */     //   #528	-> 132
/*      */     //   #531	-> 133
/*      */     //   #532	-> 140
/*      */     //   #533	-> 217
/*      */     //   #535	-> 222
/*      */     //   #536	-> 228
/*      */     //   #538	-> 229
/*      */     //   #539	-> 249
/*      */     //   #540	-> 281
/*      */     //   #543	-> 330
/*      */     //   #551	-> 420
/*      */     //   #547	-> 434
/*      */     //   #544	-> 448
/*      */     //   #555	-> 462
/*      */     //   #545	-> 476
/*      */     //   #548	-> 477
/*      */     //   #549	-> 493
/*      */     //   #552	-> 509
/*      */     //   #553	-> 538
/*      */     //   #556	-> 574
/*      */     //   #557	-> 586
/*      */     //   #560	-> 615
/*      */     //   #561	-> 615
/*      */     //   #564	-> 634
/*      */     //   #565	-> 642
/*      */     //   #564	-> 687
/*      */     //   #568	-> 695
/*      */     //   #569	-> 702
/*      */     //   #570	-> 719
/*      */     //   #572	-> 723
/*      */     //   #573	-> 749
/*      */     //   #575	-> 766
/*      */     //   #572	-> 795
/*      */     //   #569	-> 795
/*      */     //   #580	-> 798
/*      */     //   #581	-> 807
/*      */     //   #582	-> 822
/*      */     //   #583	-> 838
/*      */     //   #586	-> 854
/*      */     //   #587	-> 870
/*      */     //   #589	-> 879
/*      */     //   #590	-> 903
/*      */     //   #592	-> 903
/*      */     //   #593	-> 911
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   222	412	4	blockSlot	I
/*      */     //   822	32	4	modifier	F
/*      */     //   140	772	3	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   36	876	2	world	Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   18	894	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	912	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/OldScaffold; } public void onDisable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74311_E)) { MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); if (this.eagleSneaking) MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)player, ICPacketEntityAction.WAction.STOP_SNEAKING));  }  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74366_z)) MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74370_x))
/*      */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);  this.lockRotation = (Rotation)null; this.facesBlock = false; MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); this.shouldGoDown = false; if (this.slot != player.getInventory().getCurrentItem())
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(player.getInventory().getCurrentItem()));  if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe();  if (this.slot != MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem() && StringsKt.equals((String)this.autoBlockValue.get(), "spoof", true)) { if (MinecraftInstance.mc.getThePlayer() == null)
/*  477 */           Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem())); }  return; }  MinecraftInstance.mc.getThePlayer(); } private final void findBlock(boolean expand) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*  478 */       if (!this.canRot)
/*  479 */         return;  WBlockPos blockPosition = this.shouldGoDown ? (
/*  480 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/*  481 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ()) : (
/*      */         
/*  483 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ())).down()) : (
/*      */         
/*  485 */         (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? 
/*  486 */         new WBlockPos(player.getPosX(), this.launchY - 1.0D, player.getPosZ()) : (
/*  487 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/*  488 */         new WBlockPos((IEntity)player) : (
/*      */         
/*  490 */         new WBlockPos(player.getPosX(), player.getPosY(), player.getPosZ())).down()));
/*      */       
/*  492 */       if (!expand) { int $i$f$isReplaceable = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1051 */         BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0) || search(blockPosition, !this.shouldGoDown)) return;  }  if (expand) { double yaw = Math.toRadians(player.getRotationYaw() + '´'); boolean bool = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); byte b = 0; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); int i; for (b = 0, i = ((Number)this.expandLengthValue.get()).intValue(); b < i; b++) { if (search(blockPosition.add(x * b, 0, z * b), false)) return;  }  } else if (((Boolean)this.searchValue.get()).booleanValue()) { byte b; byte b1; for (b = -1, b1 = 1; b <= b1; b++) { byte b2; byte b3; for (b2 = -1, b3 = 1; b2 <= b3; b2++) { if (search(blockPosition.add(b, 0, b2), !this.shouldGoDown)) return;  }  }  }  return; }  MinecraftInstance.mc.getThePlayer(); }
/*      */   @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown) return;  if (((Boolean)this.airSafeValue.get()).booleanValue() || player.getOnGround()) event.setSafeWalk(true);  return; }  MinecraftInstance.mc.getThePlayer(); } @EventTarget public final void onRender2D(@Nullable Render2DEvent event) { // Byte code:
/*      */     //   0: new net/minecraft/client/gui/ScaledResolution
/*      */     //   3: dup
/*      */     //   4: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   7: invokespecial <init> : (Lnet/minecraft/client/Minecraft;)V
/*      */     //   10: astore_2
/*      */     //   11: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   14: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   17: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
/*      */     //   20: aload_0
/*      */     //   21: getfield slot : I
/*      */     //   24: invokevirtual func_70301_a : (I)Lnet/minecraft/item/ItemStack;
/*      */     //   27: astore_3
/*      */     //   28: fconst_0
/*      */     //   29: fstore #4
/*      */     //   31: lconst_0
/*      */     //   32: lstore #5
/*      */     //   34: invokestatic currentTimeMillis : ()J
/*      */     //   37: lload #5
/*      */     //   39: lsub
/*      */     //   40: l2f
/*      */     //   41: ldc_w 100.0
/*      */     //   44: fdiv
/*      */     //   45: fstore #4
/*      */     //   47: fload #4
/*      */     //   49: iconst_1
/*      */     //   50: i2f
/*      */     //   51: fcmpl
/*      */     //   52: iflt -> 58
/*      */     //   55: fconst_1
/*      */     //   56: fstore #4
/*      */     //   58: aload_0
/*      */     //   59: getfield counterDisplayValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   62: dup
/*      */     //   63: ifnonnull -> 69
/*      */     //   66: invokestatic throwNpe : ()V
/*      */     //   69: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   72: checkcast java/lang/String
/*      */     //   75: astore #7
/*      */     //   77: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   80: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   83: dup
/*      */     //   84: ldc_w 'mc'
/*      */     //   87: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   90: invokeinterface createScaledResolution : (Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;
/*      */     //   95: astore #8
/*      */     //   97: new java/lang/StringBuilder
/*      */     //   100: dup
/*      */     //   101: invokespecial <init> : ()V
/*      */     //   104: aload_0
/*      */     //   105: invokevirtual getBlocksAmount : ()I
/*      */     //   108: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   111: ldc_w ' blocks'
/*      */     //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   117: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   120: astore #9
/*      */     //   122: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   125: aload #9
/*      */     //   127: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*      */     //   132: istore #10
/*      */     //   134: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   137: new java/lang/StringBuilder
/*      */     //   140: dup
/*      */     //   141: invokespecial <init> : ()V
/*      */     //   144: aload_0
/*      */     //   145: invokevirtual getBlocksAmount : ()I
/*      */     //   148: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   154: ldc_w ''
/*      */     //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   160: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   163: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*      */     //   168: istore #11
/*      */     //   170: aload #7
/*      */     //   172: ldc_w 'simple'
/*      */     //   175: iconst_1
/*      */     //   176: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   179: ifeq -> 521
/*      */     //   182: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   185: new java/lang/StringBuilder
/*      */     //   188: dup
/*      */     //   189: invokespecial <init> : ()V
/*      */     //   192: aload_0
/*      */     //   193: invokevirtual getBlocksAmount : ()I
/*      */     //   196: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   202: ldc_w ''
/*      */     //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   208: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   211: aload #8
/*      */     //   213: invokeinterface getScaledWidth : ()I
/*      */     //   218: iconst_2
/*      */     //   219: idiv
/*      */     //   220: iload #11
/*      */     //   222: iconst_2
/*      */     //   223: idiv
/*      */     //   224: isub
/*      */     //   225: iconst_1
/*      */     //   226: isub
/*      */     //   227: i2f
/*      */     //   228: aload #8
/*      */     //   230: invokeinterface getScaledHeight : ()I
/*      */     //   235: iconst_2
/*      */     //   236: idiv
/*      */     //   237: bipush #36
/*      */     //   239: isub
/*      */     //   240: i2f
/*      */     //   241: ldc_w -16777216
/*      */     //   244: iconst_0
/*      */     //   245: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*      */     //   250: pop
/*      */     //   251: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   254: new java/lang/StringBuilder
/*      */     //   257: dup
/*      */     //   258: invokespecial <init> : ()V
/*      */     //   261: aload_0
/*      */     //   262: invokevirtual getBlocksAmount : ()I
/*      */     //   265: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   271: ldc_w ''
/*      */     //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   277: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   280: aload #8
/*      */     //   282: invokeinterface getScaledWidth : ()I
/*      */     //   287: iconst_2
/*      */     //   288: idiv
/*      */     //   289: iload #11
/*      */     //   291: iconst_2
/*      */     //   292: idiv
/*      */     //   293: isub
/*      */     //   294: iconst_1
/*      */     //   295: iadd
/*      */     //   296: i2f
/*      */     //   297: aload #8
/*      */     //   299: invokeinterface getScaledHeight : ()I
/*      */     //   304: iconst_2
/*      */     //   305: idiv
/*      */     //   306: bipush #36
/*      */     //   308: isub
/*      */     //   309: i2f
/*      */     //   310: ldc_w -16777216
/*      */     //   313: iconst_0
/*      */     //   314: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*      */     //   319: pop
/*      */     //   320: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   323: new java/lang/StringBuilder
/*      */     //   326: dup
/*      */     //   327: invokespecial <init> : ()V
/*      */     //   330: aload_0
/*      */     //   331: invokevirtual getBlocksAmount : ()I
/*      */     //   334: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   340: ldc_w ''
/*      */     //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   346: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   349: aload #8
/*      */     //   351: invokeinterface getScaledWidth : ()I
/*      */     //   356: iconst_2
/*      */     //   357: idiv
/*      */     //   358: iload #11
/*      */     //   360: iconst_2
/*      */     //   361: idiv
/*      */     //   362: isub
/*      */     //   363: i2f
/*      */     //   364: aload #8
/*      */     //   366: invokeinterface getScaledHeight : ()I
/*      */     //   371: iconst_2
/*      */     //   372: idiv
/*      */     //   373: bipush #35
/*      */     //   375: isub
/*      */     //   376: i2f
/*      */     //   377: ldc_w -16777216
/*      */     //   380: iconst_0
/*      */     //   381: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*      */     //   386: pop
/*      */     //   387: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   390: new java/lang/StringBuilder
/*      */     //   393: dup
/*      */     //   394: invokespecial <init> : ()V
/*      */     //   397: aload_0
/*      */     //   398: invokevirtual getBlocksAmount : ()I
/*      */     //   401: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   407: ldc_w ''
/*      */     //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   413: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   416: aload #8
/*      */     //   418: invokeinterface getScaledWidth : ()I
/*      */     //   423: iconst_2
/*      */     //   424: idiv
/*      */     //   425: iload #11
/*      */     //   427: iconst_2
/*      */     //   428: idiv
/*      */     //   429: isub
/*      */     //   430: i2f
/*      */     //   431: aload #8
/*      */     //   433: invokeinterface getScaledHeight : ()I
/*      */     //   438: iconst_2
/*      */     //   439: idiv
/*      */     //   440: bipush #37
/*      */     //   442: isub
/*      */     //   443: i2f
/*      */     //   444: ldc_w -16777216
/*      */     //   447: iconst_0
/*      */     //   448: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*      */     //   453: pop
/*      */     //   454: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   457: new java/lang/StringBuilder
/*      */     //   460: dup
/*      */     //   461: invokespecial <init> : ()V
/*      */     //   464: aload_0
/*      */     //   465: invokevirtual getBlocksAmount : ()I
/*      */     //   468: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   471: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   474: ldc_w ''
/*      */     //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   480: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   483: aload #8
/*      */     //   485: invokeinterface getScaledWidth : ()I
/*      */     //   490: i2f
/*      */     //   491: iconst_2
/*      */     //   492: i2f
/*      */     //   493: fdiv
/*      */     //   494: iload #11
/*      */     //   496: iconst_2
/*      */     //   497: idiv
/*      */     //   498: i2f
/*      */     //   499: fsub
/*      */     //   500: aload #8
/*      */     //   502: invokeinterface getScaledHeight : ()I
/*      */     //   507: iconst_2
/*      */     //   508: idiv
/*      */     //   509: bipush #36
/*      */     //   511: isub
/*      */     //   512: i2f
/*      */     //   513: iconst_m1
/*      */     //   514: iconst_0
/*      */     //   515: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*      */     //   520: pop
/*      */     //   521: aload #7
/*      */     //   523: ldc_w 'Rise'
/*      */     //   526: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   529: ifeq -> 818
/*      */     //   532: invokestatic func_179117_G : ()V
/*      */     //   535: aload_2
/*      */     //   536: invokevirtual func_78328_b : ()I
/*      */     //   539: bipush #120
/*      */     //   541: isub
/*      */     //   542: istore #12
/*      */     //   544: invokestatic glPushMatrix : ()V
/*      */     //   547: invokestatic func_179147_l : ()V
/*      */     //   550: invokestatic func_179090_x : ()V
/*      */     //   553: sipush #770
/*      */     //   556: sipush #771
/*      */     //   559: iconst_1
/*      */     //   560: iconst_0
/*      */     //   561: invokestatic func_179120_a : (IIII)V
/*      */     //   564: aload_2
/*      */     //   565: invokevirtual func_78326_a : ()I
/*      */     //   568: i2f
/*      */     //   569: fconst_2
/*      */     //   570: fdiv
/*      */     //   571: bipush #50
/*      */     //   573: i2f
/*      */     //   574: fsub
/*      */     //   575: iload #12
/*      */     //   577: bipush #10
/*      */     //   579: isub
/*      */     //   580: i2f
/*      */     //   581: ldc_w 83.0
/*      */     //   584: ldc_w 25.0
/*      */     //   587: ldc_w 3.0
/*      */     //   590: new java/awt/Color
/*      */     //   593: dup
/*      */     //   594: iconst_0
/*      */     //   595: iconst_0
/*      */     //   596: iconst_0
/*      */     //   597: invokespecial <init> : (III)V
/*      */     //   600: invokevirtual getRGB : ()I
/*      */     //   603: invokestatic drawRoundedRect : (FFFFFI)V
/*      */     //   606: invokestatic func_179098_w : ()V
/*      */     //   609: invokestatic func_179084_k : ()V
/*      */     //   612: invokestatic glPopMatrix : ()V
/*      */     //   615: aload_2
/*      */     //   616: invokevirtual func_78326_a : ()I
/*      */     //   619: i2f
/*      */     //   620: fconst_2
/*      */     //   621: fdiv
/*      */     //   622: bipush #50
/*      */     //   624: i2f
/*      */     //   625: fsub
/*      */     //   626: iload #12
/*      */     //   628: i2f
/*      */     //   629: ldc_w 10.0
/*      */     //   632: fsub
/*      */     //   633: ldc_w 83.0
/*      */     //   636: ldc_w 25.0
/*      */     //   639: ldc_w 3.0
/*      */     //   642: invokestatic blurRoundArea : (FFFFF)V
/*      */     //   645: aload_2
/*      */     //   646: invokevirtual func_78326_a : ()I
/*      */     //   649: i2f
/*      */     //   650: fconst_2
/*      */     //   651: fdiv
/*      */     //   652: bipush #50
/*      */     //   654: i2f
/*      */     //   655: fsub
/*      */     //   656: iload #12
/*      */     //   658: bipush #10
/*      */     //   660: isub
/*      */     //   661: i2f
/*      */     //   662: ldc_w 83.0
/*      */     //   665: ldc_w 25.0
/*      */     //   668: ldc_w 3.0
/*      */     //   671: new java/awt/Color
/*      */     //   674: dup
/*      */     //   675: iconst_0
/*      */     //   676: iconst_0
/*      */     //   677: iconst_0
/*      */     //   678: bipush #80
/*      */     //   680: invokespecial <init> : (IIII)V
/*      */     //   683: invokevirtual getRGB : ()I
/*      */     //   686: invokestatic drawRoundedRect : (FFFFFI)V
/*      */     //   689: aload_3
/*      */     //   690: ifnull -> 780
/*      */     //   693: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   696: aload_3
/*      */     //   697: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
/*      */     //   700: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   705: ifeq -> 780
/*      */     //   708: invokestatic func_179094_E : ()V
/*      */     //   711: invokestatic func_179091_B : ()V
/*      */     //   714: invokestatic func_179147_l : ()V
/*      */     //   717: sipush #770
/*      */     //   720: sipush #771
/*      */     //   723: iconst_1
/*      */     //   724: iconst_0
/*      */     //   725: invokestatic func_179120_a : (IIII)V
/*      */     //   728: invokestatic func_74520_c : ()V
/*      */     //   731: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   734: dup
/*      */     //   735: ldc_w 'mc2'
/*      */     //   738: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   741: invokevirtual func_175599_af : ()Lnet/minecraft/client/renderer/RenderItem;
/*      */     //   744: aload_3
/*      */     //   745: aload_2
/*      */     //   746: invokevirtual func_78326_a : ()I
/*      */     //   749: i2f
/*      */     //   750: fconst_2
/*      */     //   751: fdiv
/*      */     //   752: bipush #45
/*      */     //   754: i2f
/*      */     //   755: fsub
/*      */     //   756: f2i
/*      */     //   757: iload #12
/*      */     //   759: bipush #6
/*      */     //   761: isub
/*      */     //   762: invokevirtual func_180450_b : (Lnet/minecraft/item/ItemStack;II)V
/*      */     //   765: invokestatic func_179101_C : ()V
/*      */     //   768: invokestatic func_179084_k : ()V
/*      */     //   771: invokestatic func_74518_a : ()V
/*      */     //   774: invokestatic func_179121_F : ()V
/*      */     //   777: goto -> 812
/*      */     //   780: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   783: ldc_w '?'
/*      */     //   786: aload_2
/*      */     //   787: invokevirtual func_78326_a : ()I
/*      */     //   790: i2f
/*      */     //   791: fconst_2
/*      */     //   792: fdiv
/*      */     //   793: ldc_w 0.5
/*      */     //   796: fadd
/*      */     //   797: iload #12
/*      */     //   799: i2f
/*      */     //   800: ldc_w 54.0
/*      */     //   803: fsub
/*      */     //   804: iconst_m1
/*      */     //   805: iconst_1
/*      */     //   806: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*      */     //   811: pop
/*      */     //   812: invokestatic func_179117_G : ()V
/*      */     //   815: invokestatic glPopMatrix : ()V
/*      */     //   818: aload #7
/*      */     //   820: ldc_w 'advanced'
/*      */     //   823: iconst_1
/*      */     //   824: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   827: ifeq -> 1334
/*      */     //   830: bipush #8
/*      */     //   832: iconst_0
/*      */     //   833: aload_0
/*      */     //   834: getfield slot : I
/*      */     //   837: istore #13
/*      */     //   839: iload #13
/*      */     //   841: if_icmple -> 848
/*      */     //   844: pop
/*      */     //   845: goto -> 1001
/*      */     //   848: iload #13
/*      */     //   850: if_icmplt -> 1001
/*      */     //   853: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   856: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   861: dup
/*      */     //   862: ifnonnull -> 868
/*      */     //   865: invokestatic throwNpe : ()V
/*      */     //   868: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   873: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   878: aload_0
/*      */     //   879: getfield slot : I
/*      */     //   882: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   887: ifnull -> 1001
/*      */     //   890: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   893: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   898: dup
/*      */     //   899: ifnonnull -> 905
/*      */     //   902: invokestatic throwNpe : ()V
/*      */     //   905: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   910: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   915: aload_0
/*      */     //   916: getfield slot : I
/*      */     //   919: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   924: dup
/*      */     //   925: ifnonnull -> 931
/*      */     //   928: invokestatic throwNpe : ()V
/*      */     //   931: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*      */     //   934: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   939: ifnull -> 1001
/*      */     //   942: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   945: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   950: dup
/*      */     //   951: ifnonnull -> 957
/*      */     //   954: invokestatic throwNpe : ()V
/*      */     //   957: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   962: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   967: aload_0
/*      */     //   968: getfield slot : I
/*      */     //   971: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   976: dup
/*      */     //   977: ifnonnull -> 983
/*      */     //   980: invokestatic throwNpe : ()V
/*      */     //   983: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*      */     //   986: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   991: instanceof net/minecraft/item/ItemBlock
/*      */     //   994: ifeq -> 1001
/*      */     //   997: iconst_1
/*      */     //   998: goto -> 1002
/*      */     //   1001: iconst_0
/*      */     //   1002: istore #12
/*      */     //   1004: aload #8
/*      */     //   1006: invokeinterface getScaledWidth : ()I
/*      */     //   1011: iconst_2
/*      */     //   1012: idiv
/*      */     //   1013: iload #10
/*      */     //   1015: iconst_2
/*      */     //   1016: idiv
/*      */     //   1017: isub
/*      */     //   1018: iconst_4
/*      */     //   1019: isub
/*      */     //   1020: aload #8
/*      */     //   1022: invokeinterface getScaledHeight : ()I
/*      */     //   1027: iconst_2
/*      */     //   1028: idiv
/*      */     //   1029: bipush #40
/*      */     //   1031: isub
/*      */     //   1032: aload #8
/*      */     //   1034: invokeinterface getScaledWidth : ()I
/*      */     //   1039: iconst_2
/*      */     //   1040: idiv
/*      */     //   1041: iload #10
/*      */     //   1043: iconst_2
/*      */     //   1044: idiv
/*      */     //   1045: iadd
/*      */     //   1046: iconst_4
/*      */     //   1047: iadd
/*      */     //   1048: aload #8
/*      */     //   1050: invokeinterface getScaledHeight : ()I
/*      */     //   1055: iconst_2
/*      */     //   1056: idiv
/*      */     //   1057: bipush #39
/*      */     //   1059: isub
/*      */     //   1060: aload_0
/*      */     //   1061: invokevirtual getBlocksAmount : ()I
/*      */     //   1064: iconst_1
/*      */     //   1065: if_icmple -> 1072
/*      */     //   1068: iconst_m1
/*      */     //   1069: goto -> 1075
/*      */     //   1072: ldc_w -61424
/*      */     //   1075: invokestatic drawRect : (IIIII)V
/*      */     //   1078: aload #8
/*      */     //   1080: invokeinterface getScaledWidth : ()I
/*      */     //   1085: iconst_2
/*      */     //   1086: idiv
/*      */     //   1087: iload #10
/*      */     //   1089: iconst_2
/*      */     //   1090: idiv
/*      */     //   1091: isub
/*      */     //   1092: iconst_4
/*      */     //   1093: isub
/*      */     //   1094: aload #8
/*      */     //   1096: invokeinterface getScaledHeight : ()I
/*      */     //   1101: iconst_2
/*      */     //   1102: idiv
/*      */     //   1103: bipush #39
/*      */     //   1105: isub
/*      */     //   1106: aload #8
/*      */     //   1108: invokeinterface getScaledWidth : ()I
/*      */     //   1113: iconst_2
/*      */     //   1114: idiv
/*      */     //   1115: iload #10
/*      */     //   1117: iconst_2
/*      */     //   1118: idiv
/*      */     //   1119: iadd
/*      */     //   1120: iconst_4
/*      */     //   1121: iadd
/*      */     //   1122: aload #8
/*      */     //   1124: invokeinterface getScaledHeight : ()I
/*      */     //   1129: iconst_2
/*      */     //   1130: idiv
/*      */     //   1131: bipush #26
/*      */     //   1133: isub
/*      */     //   1134: ldc_w -1610612736
/*      */     //   1137: invokestatic drawRect : (IIIII)V
/*      */     //   1140: iload #12
/*      */     //   1142: ifeq -> 1296
/*      */     //   1145: aload #8
/*      */     //   1147: invokeinterface getScaledWidth : ()I
/*      */     //   1152: iconst_2
/*      */     //   1153: idiv
/*      */     //   1154: iload #10
/*      */     //   1156: iconst_2
/*      */     //   1157: idiv
/*      */     //   1158: isub
/*      */     //   1159: iconst_4
/*      */     //   1160: isub
/*      */     //   1161: aload #8
/*      */     //   1163: invokeinterface getScaledHeight : ()I
/*      */     //   1168: iconst_2
/*      */     //   1169: idiv
/*      */     //   1170: bipush #26
/*      */     //   1172: isub
/*      */     //   1173: aload #8
/*      */     //   1175: invokeinterface getScaledWidth : ()I
/*      */     //   1180: iconst_2
/*      */     //   1181: idiv
/*      */     //   1182: iload #10
/*      */     //   1184: iconst_2
/*      */     //   1185: idiv
/*      */     //   1186: iadd
/*      */     //   1187: iconst_4
/*      */     //   1188: iadd
/*      */     //   1189: aload #8
/*      */     //   1191: invokeinterface getScaledHeight : ()I
/*      */     //   1196: iconst_2
/*      */     //   1197: idiv
/*      */     //   1198: iconst_5
/*      */     //   1199: isub
/*      */     //   1200: ldc_w -1610612736
/*      */     //   1203: invokestatic drawRect : (IIIII)V
/*      */     //   1206: invokestatic func_179094_E : ()V
/*      */     //   1209: aload #8
/*      */     //   1211: invokeinterface getScaledWidth : ()I
/*      */     //   1216: iconst_2
/*      */     //   1217: idiv
/*      */     //   1218: bipush #8
/*      */     //   1220: isub
/*      */     //   1221: i2f
/*      */     //   1222: aload #8
/*      */     //   1224: invokeinterface getScaledHeight : ()I
/*      */     //   1229: iconst_2
/*      */     //   1230: idiv
/*      */     //   1231: bipush #25
/*      */     //   1233: isub
/*      */     //   1234: i2f
/*      */     //   1235: aload #8
/*      */     //   1237: invokeinterface getScaledWidth : ()I
/*      */     //   1242: iconst_2
/*      */     //   1243: idiv
/*      */     //   1244: bipush #8
/*      */     //   1246: isub
/*      */     //   1247: i2f
/*      */     //   1248: invokestatic func_179109_b : (FFF)V
/*      */     //   1251: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1254: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1259: dup
/*      */     //   1260: ifnonnull -> 1266
/*      */     //   1263: invokestatic throwNpe : ()V
/*      */     //   1266: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   1271: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   1276: aload_0
/*      */     //   1277: getfield slot : I
/*      */     //   1280: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   1285: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*      */     //   1288: iconst_0
/*      */     //   1289: iconst_0
/*      */     //   1290: invokestatic renderItemStack : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;II)V
/*      */     //   1293: invokestatic func_179121_F : ()V
/*      */     //   1296: invokestatic func_179117_G : ()V
/*      */     //   1299: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   1302: aload #9
/*      */     //   1304: aload #8
/*      */     //   1306: invokeinterface getScaledWidth : ()I
/*      */     //   1311: iconst_2
/*      */     //   1312: idiv
/*      */     //   1313: i2f
/*      */     //   1314: aload #8
/*      */     //   1316: invokeinterface getScaledHeight : ()I
/*      */     //   1321: iconst_2
/*      */     //   1322: idiv
/*      */     //   1323: bipush #36
/*      */     //   1325: isub
/*      */     //   1326: i2f
/*      */     //   1327: iconst_m1
/*      */     //   1328: invokeinterface drawCenteredString : (Ljava/lang/String;FFI)I
/*      */     //   1333: pop
/*      */     //   1334: aload #7
/*      */     //   1336: ldc_w 'sigma'
/*      */     //   1339: iconst_1
/*      */     //   1340: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   1343: ifeq -> 1669
/*      */     //   1346: fconst_0
/*      */     //   1347: ldc_w -14.0
/*      */     //   1350: fload #4
/*      */     //   1352: ldc_w 4.0
/*      */     //   1355: fmul
/*      */     //   1356: fsub
/*      */     //   1357: fconst_0
/*      */     //   1358: invokestatic func_179109_b : (FFF)V
/*      */     //   1361: sipush #3042
/*      */     //   1364: invokestatic glEnable : (I)V
/*      */     //   1367: sipush #3553
/*      */     //   1370: invokestatic glDisable : (I)V
/*      */     //   1373: sipush #770
/*      */     //   1376: sipush #771
/*      */     //   1379: invokestatic glBlendFunc : (II)V
/*      */     //   1382: sipush #2848
/*      */     //   1385: invokestatic glEnable : (I)V
/*      */     //   1388: ldc_w 0.15
/*      */     //   1391: ldc_w 0.15
/*      */     //   1394: ldc_w 0.15
/*      */     //   1397: fload #4
/*      */     //   1399: invokestatic glColor4f : (FFFF)V
/*      */     //   1402: bipush #6
/*      */     //   1404: invokestatic glBegin : (I)V
/*      */     //   1407: aload #8
/*      */     //   1409: invokeinterface getScaledWidth : ()I
/*      */     //   1414: iconst_2
/*      */     //   1415: idiv
/*      */     //   1416: iconst_3
/*      */     //   1417: isub
/*      */     //   1418: i2d
/*      */     //   1419: aload #8
/*      */     //   1421: invokeinterface getScaledHeight : ()I
/*      */     //   1426: bipush #60
/*      */     //   1428: isub
/*      */     //   1429: i2d
/*      */     //   1430: invokestatic glVertex2d : (DD)V
/*      */     //   1433: aload #8
/*      */     //   1435: invokeinterface getScaledWidth : ()I
/*      */     //   1440: iconst_2
/*      */     //   1441: idiv
/*      */     //   1442: i2d
/*      */     //   1443: aload #8
/*      */     //   1445: invokeinterface getScaledHeight : ()I
/*      */     //   1450: bipush #57
/*      */     //   1452: isub
/*      */     //   1453: i2d
/*      */     //   1454: invokestatic glVertex2d : (DD)V
/*      */     //   1457: aload #8
/*      */     //   1459: invokeinterface getScaledWidth : ()I
/*      */     //   1464: iconst_2
/*      */     //   1465: idiv
/*      */     //   1466: iconst_3
/*      */     //   1467: iadd
/*      */     //   1468: i2d
/*      */     //   1469: aload #8
/*      */     //   1471: invokeinterface getScaledHeight : ()I
/*      */     //   1476: bipush #60
/*      */     //   1478: isub
/*      */     //   1479: i2d
/*      */     //   1480: invokestatic glVertex2d : (DD)V
/*      */     //   1483: invokestatic glEnd : ()V
/*      */     //   1486: sipush #3553
/*      */     //   1489: invokestatic glEnable : (I)V
/*      */     //   1492: sipush #3042
/*      */     //   1495: invokestatic glDisable : (I)V
/*      */     //   1498: sipush #2848
/*      */     //   1501: invokestatic glDisable : (I)V
/*      */     //   1504: aload #8
/*      */     //   1506: invokeinterface getScaledWidth : ()I
/*      */     //   1511: i2f
/*      */     //   1512: iconst_2
/*      */     //   1513: i2f
/*      */     //   1514: fdiv
/*      */     //   1515: iload #10
/*      */     //   1517: iconst_2
/*      */     //   1518: idiv
/*      */     //   1519: i2f
/*      */     //   1520: fsub
/*      */     //   1521: iconst_4
/*      */     //   1522: i2f
/*      */     //   1523: fsub
/*      */     //   1524: aload #8
/*      */     //   1526: invokeinterface getScaledHeight : ()I
/*      */     //   1531: i2f
/*      */     //   1532: bipush #60
/*      */     //   1534: i2f
/*      */     //   1535: fsub
/*      */     //   1536: aload #8
/*      */     //   1538: invokeinterface getScaledWidth : ()I
/*      */     //   1543: i2f
/*      */     //   1544: iconst_2
/*      */     //   1545: i2f
/*      */     //   1546: fdiv
/*      */     //   1547: iload #10
/*      */     //   1549: iconst_2
/*      */     //   1550: idiv
/*      */     //   1551: i2f
/*      */     //   1552: fadd
/*      */     //   1553: iconst_4
/*      */     //   1554: i2f
/*      */     //   1555: fadd
/*      */     //   1556: aload #8
/*      */     //   1558: invokeinterface getScaledHeight : ()I
/*      */     //   1563: i2f
/*      */     //   1564: bipush #74
/*      */     //   1566: i2f
/*      */     //   1567: fsub
/*      */     //   1568: fconst_2
/*      */     //   1569: f2i
/*      */     //   1570: i2f
/*      */     //   1571: new java/awt/Color
/*      */     //   1574: dup
/*      */     //   1575: ldc_w 0.15
/*      */     //   1578: ldc_w 0.15
/*      */     //   1581: ldc_w 0.15
/*      */     //   1584: fload #4
/*      */     //   1586: invokespecial <init> : (FFFF)V
/*      */     //   1589: invokevirtual getRGB : ()I
/*      */     //   1592: invokestatic drawRoundedRect : (FFFFFI)V
/*      */     //   1595: invokestatic func_179117_G : ()V
/*      */     //   1598: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   1601: aload #9
/*      */     //   1603: aload #8
/*      */     //   1605: invokeinterface getScaledWidth : ()I
/*      */     //   1610: iconst_2
/*      */     //   1611: idiv
/*      */     //   1612: i2f
/*      */     //   1613: ldc_w 0.1
/*      */     //   1616: fadd
/*      */     //   1617: aload #8
/*      */     //   1619: invokeinterface getScaledHeight : ()I
/*      */     //   1624: bipush #70
/*      */     //   1626: isub
/*      */     //   1627: i2f
/*      */     //   1628: new java/awt/Color
/*      */     //   1631: dup
/*      */     //   1632: fconst_1
/*      */     //   1633: fconst_1
/*      */     //   1634: fconst_1
/*      */     //   1635: ldc_w 0.8
/*      */     //   1638: fload #4
/*      */     //   1640: fmul
/*      */     //   1641: invokespecial <init> : (FFFF)V
/*      */     //   1644: invokevirtual getRGB : ()I
/*      */     //   1647: iconst_0
/*      */     //   1648: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*      */     //   1653: pop
/*      */     //   1654: fconst_0
/*      */     //   1655: ldc_w 14.0
/*      */     //   1658: fload #4
/*      */     //   1660: ldc_w 4.0
/*      */     //   1663: fmul
/*      */     //   1664: fadd
/*      */     //   1665: fconst_0
/*      */     //   1666: invokestatic func_179109_b : (FFF)V
/*      */     //   1669: aload #7
/*      */     //   1671: ldc_w 'novoline'
/*      */     //   1674: iconst_1
/*      */     //   1675: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   1678: ifeq -> 1998
/*      */     //   1681: bipush #8
/*      */     //   1683: iconst_0
/*      */     //   1684: aload_0
/*      */     //   1685: getfield slot : I
/*      */     //   1688: istore #12
/*      */     //   1690: iload #12
/*      */     //   1692: if_icmple -> 1699
/*      */     //   1695: pop
/*      */     //   1696: goto -> 1938
/*      */     //   1699: iload #12
/*      */     //   1701: if_icmplt -> 1938
/*      */     //   1704: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1707: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1712: dup
/*      */     //   1713: ifnonnull -> 1719
/*      */     //   1716: invokestatic throwNpe : ()V
/*      */     //   1719: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   1724: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   1729: aload_0
/*      */     //   1730: getfield slot : I
/*      */     //   1733: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   1738: ifnull -> 1938
/*      */     //   1741: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1744: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1749: dup
/*      */     //   1750: ifnonnull -> 1756
/*      */     //   1753: invokestatic throwNpe : ()V
/*      */     //   1756: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   1761: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   1766: aload_0
/*      */     //   1767: getfield slot : I
/*      */     //   1770: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   1775: dup
/*      */     //   1776: ifnonnull -> 1782
/*      */     //   1779: invokestatic throwNpe : ()V
/*      */     //   1782: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*      */     //   1785: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   1790: ifnull -> 1938
/*      */     //   1793: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1796: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1801: dup
/*      */     //   1802: ifnonnull -> 1808
/*      */     //   1805: invokestatic throwNpe : ()V
/*      */     //   1808: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   1813: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   1818: aload_0
/*      */     //   1819: getfield slot : I
/*      */     //   1822: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   1827: dup
/*      */     //   1828: ifnonnull -> 1834
/*      */     //   1831: invokestatic throwNpe : ()V
/*      */     //   1834: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*      */     //   1837: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   1842: instanceof net/minecraft/item/ItemBlock
/*      */     //   1845: ifeq -> 1938
/*      */     //   1848: invokestatic func_179094_E : ()V
/*      */     //   1851: aload #8
/*      */     //   1853: invokeinterface getScaledWidth : ()I
/*      */     //   1858: iconst_2
/*      */     //   1859: idiv
/*      */     //   1860: bipush #22
/*      */     //   1862: isub
/*      */     //   1863: i2f
/*      */     //   1864: aload #8
/*      */     //   1866: invokeinterface getScaledHeight : ()I
/*      */     //   1871: iconst_2
/*      */     //   1872: idiv
/*      */     //   1873: bipush #16
/*      */     //   1875: iadd
/*      */     //   1876: i2f
/*      */     //   1877: aload #8
/*      */     //   1879: invokeinterface getScaledWidth : ()I
/*      */     //   1884: iconst_2
/*      */     //   1885: idiv
/*      */     //   1886: bipush #22
/*      */     //   1888: isub
/*      */     //   1889: i2f
/*      */     //   1890: invokestatic func_179109_b : (FFF)V
/*      */     //   1893: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1896: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1901: dup
/*      */     //   1902: ifnonnull -> 1908
/*      */     //   1905: invokestatic throwNpe : ()V
/*      */     //   1908: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   1913: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*      */     //   1918: aload_0
/*      */     //   1919: getfield slot : I
/*      */     //   1922: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   1927: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*      */     //   1930: iconst_0
/*      */     //   1931: iconst_0
/*      */     //   1932: invokestatic renderItemStack : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;II)V
/*      */     //   1935: invokestatic func_179121_F : ()V
/*      */     //   1938: invokestatic func_179117_G : ()V
/*      */     //   1941: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*      */     //   1944: new java/lang/StringBuilder
/*      */     //   1947: dup
/*      */     //   1948: invokespecial <init> : ()V
/*      */     //   1951: aload_0
/*      */     //   1952: invokevirtual getBlocksAmount : ()I
/*      */     //   1955: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   1958: ldc_w ' blocks'
/*      */     //   1961: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   1964: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   1967: aload #8
/*      */     //   1969: invokeinterface getScaledWidth : ()I
/*      */     //   1974: iconst_2
/*      */     //   1975: idiv
/*      */     //   1976: i2f
/*      */     //   1977: aload #8
/*      */     //   1979: invokeinterface getScaledHeight : ()I
/*      */     //   1984: iconst_2
/*      */     //   1985: idiv
/*      */     //   1986: bipush #20
/*      */     //   1988: iadd
/*      */     //   1989: i2f
/*      */     //   1990: iconst_m1
/*      */     //   1991: iconst_1
/*      */     //   1992: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*      */     //   1997: pop
/*      */     //   1998: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #649	-> 0
/*      */     //   #650	-> 11
/*      */     //   #651	-> 28
/*      */     //   #652	-> 31
/*      */     //   #653	-> 34
/*      */     //   #654	-> 47
/*      */     //   #655	-> 58
/*      */     //   #656	-> 77
/*      */     //   #657	-> 97
/*      */     //   #658	-> 122
/*      */     //   #659	-> 134
/*      */     //   #660	-> 170
/*      */     //   #661	-> 182
/*      */     //   #662	-> 185
/*      */     //   #663	-> 211
/*      */     //   #664	-> 228
/*      */     //   #665	-> 241
/*      */     //   #666	-> 244
/*      */     //   #661	-> 245
/*      */     //   #668	-> 251
/*      */     //   #669	-> 254
/*      */     //   #670	-> 280
/*      */     //   #671	-> 297
/*      */     //   #672	-> 310
/*      */     //   #673	-> 313
/*      */     //   #668	-> 314
/*      */     //   #675	-> 320
/*      */     //   #676	-> 323
/*      */     //   #677	-> 349
/*      */     //   #678	-> 364
/*      */     //   #679	-> 377
/*      */     //   #680	-> 380
/*      */     //   #675	-> 381
/*      */     //   #682	-> 387
/*      */     //   #683	-> 390
/*      */     //   #684	-> 416
/*      */     //   #685	-> 431
/*      */     //   #686	-> 444
/*      */     //   #687	-> 447
/*      */     //   #682	-> 448
/*      */     //   #689	-> 454
/*      */     //   #690	-> 457
/*      */     //   #691	-> 483
/*      */     //   #692	-> 500
/*      */     //   #693	-> 513
/*      */     //   #694	-> 514
/*      */     //   #689	-> 515
/*      */     //   #697	-> 521
/*      */     //   #698	-> 532
/*      */     //   #699	-> 535
/*      */     //   #700	-> 544
/*      */     //   #701	-> 547
/*      */     //   #702	-> 550
/*      */     //   #703	-> 553
/*      */     //   #704	-> 564
/*      */     //   #705	-> 564
/*      */     //   #706	-> 575
/*      */     //   #707	-> 581
/*      */     //   #708	-> 584
/*      */     //   #709	-> 587
/*      */     //   #710	-> 590
/*      */     //   #704	-> 603
/*      */     //   #712	-> 606
/*      */     //   #713	-> 609
/*      */     //   #714	-> 612
/*      */     //   #715	-> 615
/*      */     //   #717	-> 645
/*      */     //   #718	-> 645
/*      */     //   #719	-> 656
/*      */     //   #720	-> 662
/*      */     //   #721	-> 665
/*      */     //   #722	-> 668
/*      */     //   #723	-> 671
/*      */     //   #717	-> 686
/*      */     //   #728	-> 689
/*      */     //   #729	-> 708
/*      */     //   #730	-> 711
/*      */     //   #731	-> 714
/*      */     //   #732	-> 717
/*      */     //   #733	-> 728
/*      */     //   #734	-> 731
/*      */     //   #735	-> 744
/*      */     //   #736	-> 745
/*      */     //   #737	-> 757
/*      */     //   #734	-> 762
/*      */     //   #739	-> 765
/*      */     //   #740	-> 768
/*      */     //   #741	-> 771
/*      */     //   #742	-> 774
/*      */     //   #744	-> 780
/*      */     //   #745	-> 812
/*      */     //   #746	-> 812
/*      */     //   #747	-> 815
/*      */     //   #749	-> 818
/*      */     //   #750	-> 830
/*      */     //   #751	-> 830
/*      */     //   #750	-> 1002
/*      */     //   #752	-> 1004
/*      */     //   #753	-> 1004
/*      */     //   #754	-> 1020
/*      */     //   #755	-> 1032
/*      */     //   #756	-> 1048
/*      */     //   #757	-> 1060
/*      */     //   #752	-> 1075
/*      */     //   #759	-> 1078
/*      */     //   #760	-> 1078
/*      */     //   #761	-> 1094
/*      */     //   #762	-> 1106
/*      */     //   #763	-> 1122
/*      */     //   #764	-> 1134
/*      */     //   #759	-> 1137
/*      */     //   #766	-> 1140
/*      */     //   #767	-> 1145
/*      */     //   #768	-> 1145
/*      */     //   #769	-> 1161
/*      */     //   #770	-> 1173
/*      */     //   #771	-> 1189
/*      */     //   #772	-> 1200
/*      */     //   #767	-> 1203
/*      */     //   #774	-> 1206
/*      */     //   #775	-> 1209
/*      */     //   #776	-> 1209
/*      */     //   #777	-> 1222
/*      */     //   #778	-> 1235
/*      */     //   #775	-> 1248
/*      */     //   #780	-> 1251
/*      */     //   #781	-> 1293
/*      */     //   #783	-> 1296
/*      */     //   #784	-> 1299
/*      */     //   #785	-> 1302
/*      */     //   #786	-> 1304
/*      */     //   #787	-> 1314
/*      */     //   #788	-> 1327
/*      */     //   #784	-> 1328
/*      */     //   #791	-> 1334
/*      */     //   #792	-> 1346
/*      */     //   #794	-> 1361
/*      */     //   #795	-> 1367
/*      */     //   #796	-> 1373
/*      */     //   #797	-> 1382
/*      */     //   #798	-> 1388
/*      */     //   #799	-> 1402
/*      */     //   #800	-> 1407
/*      */     //   #801	-> 1407
/*      */     //   #802	-> 1419
/*      */     //   #800	-> 1430
/*      */     //   #804	-> 1433
/*      */     //   #805	-> 1433
/*      */     //   #806	-> 1443
/*      */     //   #804	-> 1454
/*      */     //   #808	-> 1457
/*      */     //   #809	-> 1457
/*      */     //   #810	-> 1469
/*      */     //   #808	-> 1480
/*      */     //   #812	-> 1483
/*      */     //   #813	-> 1486
/*      */     //   #814	-> 1492
/*      */     //   #815	-> 1498
/*      */     //   #817	-> 1504
/*      */     //   #818	-> 1504
/*      */     //   #819	-> 1524
/*      */     //   #820	-> 1536
/*      */     //   #821	-> 1556
/*      */     //   #822	-> 1568
/*      */     //   #823	-> 1571
/*      */     //   #817	-> 1592
/*      */     //   #825	-> 1595
/*      */     //   #826	-> 1598
/*      */     //   #827	-> 1601
/*      */     //   #828	-> 1603
/*      */     //   #829	-> 1617
/*      */     //   #830	-> 1628
/*      */     //   #831	-> 1647
/*      */     //   #826	-> 1648
/*      */     //   #833	-> 1654
/*      */     //   #835	-> 1669
/*      */     //   #836	-> 1681
/*      */     //   #838	-> 1848
/*      */     //   #839	-> 1851
/*      */     //   #840	-> 1851
/*      */     //   #841	-> 1864
/*      */     //   #842	-> 1877
/*      */     //   #839	-> 1890
/*      */     //   #844	-> 1893
/*      */     //   #845	-> 1935
/*      */     //   #847	-> 1938
/*      */     //   #848	-> 1941
/*      */     //   #849	-> 1944
/*      */     //   #850	-> 1967
/*      */     //   #851	-> 1977
/*      */     //   #852	-> 1990
/*      */     //   #853	-> 1991
/*      */     //   #848	-> 1992
/*      */     //   #856	-> 1998
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   544	274	12	height	I
/*      */     //   1004	330	12	canRenderStack	Z
/*      */     //   170	1829	11	infoWidth2	I
/*      */     //   134	1865	10	infoWidth	I
/*      */     //   122	1877	9	info	Ljava/lang/String;
/*      */     //   97	1902	8	scaledResolution	Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;
/*      */     //   77	1922	7	counterMode	Ljava/lang/String;
/*      */     //   34	1965	5	lastMS	J
/*      */     //   31	1968	4	progress	F
/*      */     //   28	1971	3	itemStack	Lnet/minecraft/item/ItemStack;
/*      */     //   11	1988	2	sr	Lnet/minecraft/client/gui/ScaledResolution;
/*      */     //   0	1999	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/OldScaffold;
/* 1052 */     //   0	1999	1	event	Lnet/ccbluex/liquidbounce/event/Render2DEvent; } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.markValue.get()).booleanValue()) return;  for (byte b1 = 0, b2 = StringsKt.equals((String)this.modeValue.get(), "Expand", true) ? (((Number)this.expandLengthValue.get()).intValue() + 1) : 2; b1 < b2; b1++) { double yaw = Math.toRadians(player.getRotationYaw()); boolean bool1 = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); boolean bool2 = false; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); WBlockPos blockPos = new WBlockPos(player.getPosX() + (x * b1), (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? (this.launchY - 1.0D) : (player.getPosY() - ((player.getPosY() == player.getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0D : 0.0D)), player.getPosZ() + (z * b1)); PlaceInfo placeInfo = PlaceInfo.Companion.get(blockPos); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) { RenderUtils.drawBlockBox(blockPos, new Color(68, 117, 255, 100), false); break; }  }  return; }
/* 1053 */      MinecraftInstance.mc.getThePlayer(); } private final boolean search(WBlockPos blockPosition, boolean raycast) { this.facesBlock = false; if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient world = MinecraftInstance.mc.getTheWorld(); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0))
/* 1054 */           return false;  double xzRV = ((Number)this.xzRangeValue.get()).floatValue(); double xzSSV = calcStepSize((float)xzRV); double yRV = ((Number)this.yRangeValue.get()).floatValue(); double ySSV = calcStepSize((float)yRV); WVec3 eyesPos = new WVec3(player.getPosX(), player.getEntityBoundingBox().getMinY() + player.getEyeHeight(), player.getPosZ()); PlaceRotation placeRotation = (PlaceRotation)null; for (EnumFacingType facingType : EnumFacingType.values()) { IEnumFacing side = MinecraftInstance.classProvider.getEnumFacing(facingType); WBlockPos neighbor = WBlockPos.offset$default(blockPosition, side, 0, 2, null); if (BlockUtils.canBeClicked(neighbor)) { WVec3 dirVec = new WVec3(side.getDirectionVec()); boolean auto = StringsKt.equals((String)this.searchMode.get(), "Auto", true); boolean center = StringsKt.equals((String)this.searchMode.get(), "AutoCenter", true); double xSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (xSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { double ySearch = auto ? 0.1D : (0.5D - yRV / 2); while (ySearch <= (auto ? 0.9D : (0.5D + yRV / 2))) { double zSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (zSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { WVec3 wVec3 = new WVec3((WVec3i)blockPosition); double d1 = center ? 0.5D : xSearch, d2 = center ? 0.5D : ySearch, z$iv = center ? 0.5D : zSearch; continue; $i$f$addVector = 0; posVec = new WVec3(SYNTHETIC_LOCAL_VARIABLE_31.getXCoord() + SYNTHETIC_LOCAL_VARIABLE_32, SYNTHETIC_LOCAL_VARIABLE_31.getYCoord() + SYNTHETIC_LOCAL_VARIABLE_34, SYNTHETIC_LOCAL_VARIABLE_31.getZCoord() + SYNTHETIC_LOCAL_VARIABLE_36); this_$iv = eyesPos; $i$f$squareDistanceTo = 0;
/* 1055 */                   d0$iv = posVec.getXCoord() - this_$iv.getXCoord();
/* 1056 */                   d1$iv = posVec.getYCoord() - this_$iv.getYCoord();
/* 1057 */                   d2$iv = posVec.getZCoord() - this_$iv.getZCoord();
/*      */                   
/* 1059 */                   distanceSqPosVec = d0$iv * d0$iv + d1$iv * d1$iv + d2$iv * d2$iv; wVec31 = posVec; vec$iv = new WVec3(dirVec.getXCoord() * 0.5D, dirVec.getYCoord() * 0.5D, dirVec.getZCoord() * 0.5D); $i$f$add = 0;
/* 1060 */                   wVec32 = wVec31; d1 = vec$iv.getXCoord(); d2 = vec$iv.getYCoord(); z$iv$iv = vec$iv.getZCoord(); i = 0;
/* 1061 */                   hitVec = new WVec3(wVec32.getXCoord() + d1, wVec32.getYCoord() + d2, wVec32.getZCoord() + z$iv$iv); }
/*      */                 
/*      */                 ySearch += auto ? 0.1D : ySSV; }
/*      */               
/*      */               xSearch += auto ? 0.1D : xzSSV; }
/*      */              }
/*      */            }
/*      */         
/*      */         if (placeRotation == null)
/*      */           return false; 
/*      */         if (((Boolean)this.rotationsValue.get()).booleanValue() && this.canRot) {
/*      */           if (((Number)this.minTurnSpeedValue.get()).floatValue() < '´') {
/*      */             Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, placeRotation.getRotation(), (float)(Math.random() * (((Number)this.maxTurnSpeedValue.get()).floatValue() - ((Number)this.minTurnSpeedValue.get()).floatValue()) + ((Number)this.minTurnSpeedValue.get()).doubleValue())), "RotationUtils.limitAngle…Float()\n                )");
/*      */             Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, placeRotation.getRotation(), (float)(Math.random() * (((Number)this.maxTurnSpeedValue.get()).floatValue() - ((Number)this.minTurnSpeedValue.get()).floatValue()) + ((Number)this.minTurnSpeedValue.get()).doubleValue()));
/*      */             if (MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(limitedRotation.getYaw())) == MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(placeRotation.getRotation().getYaw())) && MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(limitedRotation.getPitch())) == MathKt.roundToInt(10 * WMathHelper.wrapAngleTo180_float(placeRotation.getRotation().getPitch()))) {
/*      */               setRotation(placeRotation.getRotation());
/*      */               this.lockRotation = placeRotation.getRotation();
/*      */               this.facesBlock = true;
/*      */             } else {
/*      */               setRotation(limitedRotation);
/*      */               this.lockRotation = limitedRotation;
/*      */               this.facesBlock = false;
/*      */             } 
/*      */           } else {
/*      */             setRotation(placeRotation.getRotation());
/*      */             this.lockRotation = placeRotation.getRotation();
/*      */             this.facesBlock = true;
/*      */           } 
/*      */           this.lockRotationTimer.reset();
/*      */         } 
/*      */         this.targetPlace = placeRotation.getPlaceInfo();
/*      */         return true; }
/*      */       
/*      */       MinecraftInstance.mc.getTheWorld();
/*      */       return false; }
/*      */     
/*      */     MinecraftInstance.mc.getThePlayer();
/*      */     return false; }
/*      */ 
/*      */   
/*      */   private final double calcStepSize(float range) {
/*      */     double accuracy = ((Number)this.searchAccuracyValue.get()).intValue();
/*      */     accuracy += accuracy % 2;
/*      */     return (range / accuracy < 0.01D) ? 0.01D : (range / accuracy);
/*      */   }
/*      */   
/*      */   public final int getBlocksAmount() {
/*      */     int amount = 0;
/*      */     for (byte b1 = 36, b2 = 44; b1 <= b2; b1++) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getStack();
/*      */       if (itemStack != null && MinecraftInstance.classProvider.isItemBlock(itemStack.getItem())) {
/*      */         if (itemStack.getItem() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         IBlock block = itemStack.getItem().asItemBlock().getBlock();
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         IItemStack heldItem = MinecraftInstance.mc.getThePlayer().getHeldItem();
/*      */         if ((heldItem != null && Intrinsics.areEqual(heldItem, itemStack)) || (!InventoryUtils.BLOCK_BLACKLIST.contains(block) && !MinecraftInstance.classProvider.isBlockBush(block)))
/*      */           amount += itemStack.getStackSize(); 
/*      */       } 
/*      */     } 
/*      */     return amount;
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public String getTag() {
/*      */     return (String)this.tagmode.get();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\OldScaffold.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */