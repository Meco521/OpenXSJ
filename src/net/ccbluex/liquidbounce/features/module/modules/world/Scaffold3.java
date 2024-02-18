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
/*     */ @ModuleInfo(name = "Scaffold3", description = "Sk1d by 凡哥.", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000®\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\006\n\002\020\013\n\002\b\003\n\002\020\t\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\002\b \n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\006\n\000\n\002\020\007\n\000\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020X\032\0020Y2\006\020Z\032\0020[H\002J\020\020\\\032\0020]2\006\020^\032\0020\024H\002J\b\020_\032\0020]H\026J\b\020`\032\0020]H\026J\020\020a\032\0020]2\006\020b\032\0020cH\007J\020\020d\032\0020]2\006\020b\032\0020eH\007J\020\020f\032\0020]2\006\020b\032\0020gH\007J\020\020h\032\0020]2\006\020b\032\0020iH\007J\020\020j\032\0020]2\006\020b\032\0020kH\007J\020\020l\032\0020]2\006\020b\032\0020mH\007J\020\020n\032\0020]2\006\020b\032\0020oH\003J\006\020p\032\0020]J\030\020q\032\0020\0242\006\020r\032\0020s2\006\020t\032\0020\024H\002J\020\020u\032\0020]2\006\020v\032\0020(H\002J\006\020w\032\0020]R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\021\020\017\032\0020\r8F¢\006\006\032\004\b\020\020\021R\016\020\022\032\0020\tX\004¢\006\002\n\000R\016\020\023\032\0020\024X\016¢\006\002\n\000R\016\020\025\032\0020\024X\016¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\016\020\027\032\0020\030X\016¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\024X\016¢\006\002\n\000R\016\020\035\032\0020\007X\004¢\006\002\n\000R\016\020\036\032\0020\037X\004¢\006\002\n\000R\016\020 \032\0020\tX\004¢\006\002\n\000R\016\020!\032\0020\024X\016¢\006\002\n\000R\016\020\"\032\0020\024X\016¢\006\002\n\000R\016\020#\032\0020\tX\004¢\006\002\n\000R\016\020$\032\0020\tX\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\rX\016¢\006\002\n\000R\020\020'\032\004\030\0010(X\016¢\006\002\n\000R\016\020)\032\0020*X\016¢\006\002\n\000R\016\020+\032\0020\004X\004¢\006\002\n\000R\016\020,\032\0020\tX\004¢\006\002\n\000R\016\020-\032\0020\037X\004¢\006\002\n\000R\016\020.\032\0020\tX\004¢\006\002\n\000R\016\020/\032\0020\037X\004¢\006\002\n\000R\016\0200\032\0020\037X\004¢\006\002\n\000R\016\0201\032\0020\007X\004¢\006\002\n\000R\016\0202\032\0020\024X\016¢\006\002\n\000R\016\0203\032\0020\004X\004¢\006\002\n\000R\016\0204\032\0020\007X\004¢\006\002\n\000R\016\0205\032\0020\004X\004¢\006\002\n\000R\016\0206\032\0020\007X\004¢\006\002\n\000R\016\0207\032\0020\rX\016¢\006\002\n\000R\016\0208\032\0020\004X\004¢\006\002\n\000R\016\0209\032\0020\004X\004¢\006\002\n\000R\016\020:\032\0020\004X\004¢\006\002\n\000R\016\020;\032\0020\tX\004¢\006\002\n\000R\016\020<\032\0020\007X\004¢\006\002\n\000R\016\020=\032\0020\004X\004¢\006\002\n\000R\016\020>\032\0020\024X\016¢\006\002\n\000R\016\020?\032\0020\004X\004¢\006\002\n\000R\016\020@\032\0020\rX\016¢\006\002\n\000R\016\020A\032\0020\037X\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\037X\004¢\006\002\n\000R\016\020D\032\0020\007X\004¢\006\002\n\000R\021\020E\032\0020\004¢\006\b\n\000\032\004\bF\020GR\016\020H\032\0020\007X\004¢\006\002\n\000R\016\020I\032\0020\004X\004¢\006\002\n\000R\024\020J\032\0020K8VX\004¢\006\006\032\004\bL\020MR\020\020N\032\004\030\0010OX\016¢\006\002\n\000R\016\020P\032\0020\037X\004¢\006\002\n\000R\016\020Q\032\0020\037X\004¢\006\002\n\000R\016\020R\032\0020\037X\016¢\006\002\n\000R\016\020S\032\0020\024X\016¢\006\002\n\000R\016\020T\032\0020\007X\004¢\006\002\n\000R\016\020U\032\0020\037X\004¢\006\002\n\000R\016\020V\032\0020\037X\004¢\006\002\n\000R\016\020W\032\0020\032X\004¢\006\002\n\000¨\006x"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold3;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "FallFastplace", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Fastplace", "RotConditionValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "Rotairticks", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "airSafeValue", "airticks", "airtime", "", "autoBlockValue", "blocksAmount", "getBlocksAmount", "()I", "blocksToEagleValue", "canPlace", "", "canRot", "counterDisplayValue", "delay", "", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "downValue", "eagleSneaking", "eagleValue", "edgeDistanceValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "expandLengthValue", "f", "facesBlock", "falldowndelay", "keepLengthValue", "keepRotationValue", "launchY", "lockRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "lockRotationTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "markValue", "maxDelayValue", "maxTurnSpeedValue", "minDelayValue", "minDistValue", "minTurnSpeedValue", "modeValue", "n", "omniDirectionalExpand", "placeConditionValue", "placeDelay", "placeModeValue", "placedBlocksWithoutEagle", "rotationsValue", "safeWalkValue", "sameYValue", "searchAccuracyValue", "searchMode", "searchValue", "shouldGoDown", "silentRotationValue", "slot", "slowSpeed", "slowValue", "speedModifierValue", "sprintModeValue", "sprintValue", "getSprintValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "strafeMode", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "targetPlace", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "timerValue", "xzRangeValue", "yRangeValue", "zitterDirection", "zitterMode", "zitterSpeed", "zitterStrength", "zitterTimer", "calcStepSize", "", "range", "", "findBlock", "", "expand", "onDisable", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "place", "search", "blockPosition", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "raycast", "setRotation", "rotation", "update", "XSJClient"})
/*     */ public final class Scaffold3 extends Module {
/*  53 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal");
/*     */ 
/*     */   
/*  56 */   private final IntegerValue maxDelayValue = new Scaffold3$maxDelayValue$1("MaxDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold3$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold3$maxDelayValue$1 extends IntegerValue { Scaffold3$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  58 */       int minDelay = ((Number)Scaffold3.this.minDelayValue.get()).intValue();
/*  59 */       if (minDelay > newValue) {
/*  60 */         set(Integer.valueOf(minDelay));
/*     */       }
/*     */     } }
/*     */ 
/*     */   
/*  65 */   private final IntegerValue minDelayValue = new Scaffold3$minDelayValue$1("MinDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold3$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold3$minDelayValue$1 extends IntegerValue { Scaffold3$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  67 */       int maxDelay = ((Number)Scaffold3.this.maxDelayValue.get()).intValue();
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
/*  78 */   private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "Off", "Pick", "Spoof", "Switch" }, "Spoof");
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
/* 111 */   private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true);
/* 112 */   private final BoolValue keepRotationValue = new BoolValue("KeepRotation", true);
/* 113 */   private final IntegerValue keepLengthValue = new IntegerValue("KeepRotationLength", 0, 0, 20);
/*     */ 
/*     */   
/* 116 */   private final ListValue searchMode = new ListValue("XYZSearch", new String[] { "Auto", "AutoCenter", "Manual" }, "AutoCenter");
/* 117 */   private final FloatValue xzRangeValue = new FloatValue("xzRange", 0.8F, 0.0F, 1.0F);
/* 118 */   private FloatValue yRangeValue = new FloatValue("yRange", 0.8F, 0.0F, 1.0F);
/* 119 */   private final FloatValue minDistValue = new FloatValue("MinDist", 0.0F, 0.0F, 0.2F);
/*     */ 
/*     */   
/* 122 */   private final IntegerValue searchAccuracyValue = new Scaffold3$searchAccuracyValue$1("SearchAccuracy", 8, 1, 16); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold3$searchAccuracyValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold3$searchAccuracyValue$1 extends IntegerValue { Scaffold3$searchAccuracyValue$1(String $super_call_param$0, int $super_call_param$1, int $super_call_param$2, int $super_call_param$3) { super($super_call_param$0, $super_call_param$1, $super_call_param$2, $super_call_param$3); }
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
/* 133 */   private final FloatValue maxTurnSpeedValue = new Scaffold3$maxTurnSpeedValue$1("MaxTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold3$maxTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold3$maxTurnSpeedValue$1 extends FloatValue { Scaffold3$maxTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 135 */       float v = ((Number)Scaffold3.this.minTurnSpeedValue.get()).floatValue();
/* 136 */       if (v > newValue) set(Float.valueOf(v)); 
/* 137 */       if (getMaximum() < newValue) {
/* 138 */         set(Float.valueOf(getMaximum()));
/* 139 */       } else if (getMinimum() > newValue) {
/* 140 */         set(Float.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */   
/* 144 */   private final FloatValue minTurnSpeedValue = new Scaffold3$minTurnSpeedValue$1("MinTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold3$minTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold3$minTurnSpeedValue$1 extends FloatValue { Scaffold3$minTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 146 */       float v = ((Number)Scaffold3.this.maxTurnSpeedValue.get()).floatValue();
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
/* 163 */   private final FloatValue speedModifierValue = new FloatValue("SpeedModifier", 1.0F, 0.0F, 2.0F);
/* 164 */   private final BoolValue slowValue = new BoolValue("Slow", false);
/* 165 */   private final FloatValue slowSpeed = new FloatValue("SlowSpeed", 0.6F, 0.2F, 0.8F);
/*     */ 
/*     */   
/* 168 */   private final BoolValue sameYValue = new BoolValue("SameY", false);
/* 169 */   private final BoolValue safeWalkValue = new BoolValue("SafeWalk", true);
/* 170 */   private final BoolValue airSafeValue = new BoolValue("AirSafe", false);
/* 171 */   private final BoolValue FallFastplace = new BoolValue("Fallfastplace", false);
/* 172 */   private final BoolValue Fastplace = new BoolValue("fastplace", false);
/*     */   
/* 174 */   private final BoolValue counterDisplayValue = new BoolValue("Counter", true);
/* 175 */   private final BoolValue markValue = new BoolValue("Mark", false);
/*     */ 
/*     */   
/*     */   private PlaceInfo targetPlace;
/*     */   
/*     */   private Rotation lockRotation;
/*     */   
/* 182 */   private TickTimer lockRotationTimer = new TickTimer();
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
/* 195 */   private final MSTimer delayTimer = new MSTimer();
/* 196 */   private final MSTimer zitterTimer = new MSTimer();
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
/* 208 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 209 */       this.canPlace = false;
/* 210 */       this.canRot = false;
/* 211 */       this.f = false;
/* 212 */       this.airtime = 0;
/* 213 */       this.launchY = MathKt.roundToInt(player.getPosY());
/* 214 */       this.slot = player.getInventory().getCurrentItem();
/* 215 */       this.facesBlock = false;
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
/*     */   @EventTarget
/*     */   private final void onUpdate(UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnull -> 15
/*     */     //   12: goto -> 17
/*     */     //   15: pop
/*     */     //   16: return
/*     */     //   17: astore_2
/*     */     //   18: aload_2
/*     */     //   19: invokeinterface getOnGround : ()Z
/*     */     //   24: ifne -> 42
/*     */     //   27: aload_0
/*     */     //   28: dup
/*     */     //   29: getfield airtime : I
/*     */     //   32: dup
/*     */     //   33: istore_3
/*     */     //   34: iconst_1
/*     */     //   35: iadd
/*     */     //   36: putfield airtime : I
/*     */     //   39: goto -> 155
/*     */     //   42: aload_0
/*     */     //   43: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   46: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   49: checkcast java/lang/String
/*     */     //   52: ldc 'falldown'
/*     */     //   54: iconst_1
/*     */     //   55: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   58: ifne -> 80
/*     */     //   61: aload_0
/*     */     //   62: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   65: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   68: checkcast java/lang/String
/*     */     //   71: ldc 'delayair'
/*     */     //   73: iconst_1
/*     */     //   74: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   77: ifeq -> 150
/*     */     //   80: aload_0
/*     */     //   81: lconst_0
/*     */     //   82: putfield delay : J
/*     */     //   85: aload_0
/*     */     //   86: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   89: invokevirtual reset : ()V
/*     */     //   92: aload_0
/*     */     //   93: iconst_0
/*     */     //   94: putfield eagleSneaking : Z
/*     */     //   97: aload_0
/*     */     //   98: iconst_0
/*     */     //   99: putfield shouldGoDown : Z
/*     */     //   102: aload_0
/*     */     //   103: iconst_0
/*     */     //   104: putfield canPlace : Z
/*     */     //   107: aload_0
/*     */     //   108: iconst_0
/*     */     //   109: putfield canRot : Z
/*     */     //   112: aload_0
/*     */     //   113: iconst_0
/*     */     //   114: putfield f : Z
/*     */     //   117: aload_0
/*     */     //   118: aload_2
/*     */     //   119: invokeinterface getPosY : ()D
/*     */     //   124: invokestatic roundToInt : (D)I
/*     */     //   127: putfield launchY : I
/*     */     //   130: aload_0
/*     */     //   131: aload_2
/*     */     //   132: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   137: invokeinterface getCurrentItem : ()I
/*     */     //   142: putfield slot : I
/*     */     //   145: aload_0
/*     */     //   146: iconst_0
/*     */     //   147: putfield facesBlock : Z
/*     */     //   150: aload_0
/*     */     //   151: iconst_0
/*     */     //   152: putfield airtime : I
/*     */     //   155: aload_0
/*     */     //   156: aload_0
/*     */     //   157: getfield airtime : I
/*     */     //   160: aload_0
/*     */     //   161: getfield airticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   164: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   167: checkcast java/lang/Number
/*     */     //   170: invokevirtual intValue : ()I
/*     */     //   173: if_icmple -> 180
/*     */     //   176: iconst_1
/*     */     //   177: goto -> 181
/*     */     //   180: iconst_0
/*     */     //   181: putfield f : Z
/*     */     //   184: aload_0
/*     */     //   185: aload_0
/*     */     //   186: getfield airtime : I
/*     */     //   189: aload_0
/*     */     //   190: getfield Rotairticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   193: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   196: checkcast java/lang/Number
/*     */     //   199: invokevirtual intValue : ()I
/*     */     //   202: if_icmple -> 209
/*     */     //   205: iconst_1
/*     */     //   206: goto -> 210
/*     */     //   209: iconst_0
/*     */     //   210: putfield n : Z
/*     */     //   213: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   216: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   221: aload_0
/*     */     //   222: getfield timerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   225: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   228: checkcast java/lang/Number
/*     */     //   231: invokevirtual floatValue : ()F
/*     */     //   234: invokeinterface setTimerSpeed : (F)V
/*     */     //   239: aload_0
/*     */     //   240: aload_0
/*     */     //   241: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   244: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   247: checkcast java/lang/String
/*     */     //   250: ldc 'falldown'
/*     */     //   252: iconst_1
/*     */     //   253: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   256: ifeq -> 285
/*     */     //   259: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   262: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   267: dup
/*     */     //   268: ifnonnull -> 274
/*     */     //   271: invokestatic throwNpe : ()V
/*     */     //   274: invokeinterface getFallDistance : ()F
/*     */     //   279: iconst_0
/*     */     //   280: i2f
/*     */     //   281: fcmpl
/*     */     //   282: ifgt -> 354
/*     */     //   285: aload_0
/*     */     //   286: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   289: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   292: checkcast java/lang/String
/*     */     //   295: ldc_w 'always'
/*     */     //   298: iconst_1
/*     */     //   299: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   302: ifne -> 354
/*     */     //   305: aload_0
/*     */     //   306: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   309: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   312: checkcast java/lang/String
/*     */     //   315: ldc 'delayair'
/*     */     //   317: iconst_1
/*     */     //   318: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   321: ifeq -> 358
/*     */     //   324: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   327: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   332: dup
/*     */     //   333: ifnonnull -> 339
/*     */     //   336: invokestatic throwNpe : ()V
/*     */     //   339: invokeinterface getOnGround : ()Z
/*     */     //   344: ifne -> 358
/*     */     //   347: aload_0
/*     */     //   348: getfield f : Z
/*     */     //   351: ifeq -> 358
/*     */     //   354: iconst_1
/*     */     //   355: goto -> 359
/*     */     //   358: iconst_0
/*     */     //   359: putfield canPlace : Z
/*     */     //   362: aload_0
/*     */     //   363: aload_0
/*     */     //   364: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   367: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   370: checkcast java/lang/String
/*     */     //   373: ldc 'falldown'
/*     */     //   375: iconst_1
/*     */     //   376: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   379: ifeq -> 408
/*     */     //   382: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   385: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   390: dup
/*     */     //   391: ifnonnull -> 397
/*     */     //   394: invokestatic throwNpe : ()V
/*     */     //   397: invokeinterface getFallDistance : ()F
/*     */     //   402: iconst_0
/*     */     //   403: i2f
/*     */     //   404: fcmpl
/*     */     //   405: ifgt -> 477
/*     */     //   408: aload_0
/*     */     //   409: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   412: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   415: checkcast java/lang/String
/*     */     //   418: ldc_w 'always'
/*     */     //   421: iconst_1
/*     */     //   422: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   425: ifne -> 477
/*     */     //   428: aload_0
/*     */     //   429: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   432: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   435: checkcast java/lang/String
/*     */     //   438: ldc 'delayair'
/*     */     //   440: iconst_1
/*     */     //   441: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   444: ifeq -> 481
/*     */     //   447: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   450: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   455: dup
/*     */     //   456: ifnonnull -> 462
/*     */     //   459: invokestatic throwNpe : ()V
/*     */     //   462: invokeinterface getOnGround : ()Z
/*     */     //   467: ifne -> 481
/*     */     //   470: aload_0
/*     */     //   471: getfield n : Z
/*     */     //   474: ifeq -> 481
/*     */     //   477: iconst_1
/*     */     //   478: goto -> 482
/*     */     //   481: iconst_0
/*     */     //   482: putfield canRot : Z
/*     */     //   485: aload_0
/*     */     //   486: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   489: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   492: checkcast java/lang/String
/*     */     //   495: ldc_w 'off'
/*     */     //   498: iconst_1
/*     */     //   499: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   502: ifne -> 591
/*     */     //   505: aload_0
/*     */     //   506: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   509: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   512: checkcast java/lang/String
/*     */     //   515: ldc_w 'ground'
/*     */     //   518: iconst_1
/*     */     //   519: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   522: ifeq -> 548
/*     */     //   525: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   528: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   533: dup
/*     */     //   534: ifnonnull -> 540
/*     */     //   537: invokestatic throwNpe : ()V
/*     */     //   540: invokeinterface getOnGround : ()Z
/*     */     //   545: ifeq -> 591
/*     */     //   548: aload_0
/*     */     //   549: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   552: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   555: checkcast java/lang/String
/*     */     //   558: ldc_w 'air'
/*     */     //   561: iconst_1
/*     */     //   562: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   565: ifeq -> 612
/*     */     //   568: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   571: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   576: dup
/*     */     //   577: ifnonnull -> 583
/*     */     //   580: invokestatic throwNpe : ()V
/*     */     //   583: invokeinterface getOnGround : ()Z
/*     */     //   588: ifeq -> 612
/*     */     //   591: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   594: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   599: dup
/*     */     //   600: ifnonnull -> 606
/*     */     //   603: invokestatic throwNpe : ()V
/*     */     //   606: iconst_0
/*     */     //   607: invokeinterface setSprinting : (Z)V
/*     */     //   612: aload_0
/*     */     //   613: aload_0
/*     */     //   614: getfield downValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   617: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   620: checkcast java/lang/Boolean
/*     */     //   623: invokevirtual booleanValue : ()Z
/*     */     //   626: ifeq -> 672
/*     */     //   629: aload_0
/*     */     //   630: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   633: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   636: checkcast java/lang/Boolean
/*     */     //   639: invokevirtual booleanValue : ()Z
/*     */     //   642: ifne -> 672
/*     */     //   645: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   648: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   651: getfield field_74311_E : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   654: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   657: ifeq -> 672
/*     */     //   660: aload_0
/*     */     //   661: invokevirtual getBlocksAmount : ()I
/*     */     //   664: iconst_1
/*     */     //   665: if_icmple -> 672
/*     */     //   668: iconst_1
/*     */     //   669: goto -> 673
/*     */     //   672: iconst_0
/*     */     //   673: putfield shouldGoDown : Z
/*     */     //   676: aload_0
/*     */     //   677: getfield shouldGoDown : Z
/*     */     //   680: ifeq -> 702
/*     */     //   683: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   686: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   691: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   696: iconst_0
/*     */     //   697: invokeinterface setPressed : (Z)V
/*     */     //   702: aload_0
/*     */     //   703: getfield slowValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   706: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   709: checkcast java/lang/Boolean
/*     */     //   712: invokevirtual booleanValue : ()Z
/*     */     //   715: ifeq -> 770
/*     */     //   718: aload_2
/*     */     //   719: aload_2
/*     */     //   720: invokeinterface getMotionX : ()D
/*     */     //   725: aload_0
/*     */     //   726: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   729: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   732: checkcast java/lang/Number
/*     */     //   735: invokevirtual doubleValue : ()D
/*     */     //   738: dmul
/*     */     //   739: invokeinterface setMotionX : (D)V
/*     */     //   744: aload_2
/*     */     //   745: aload_2
/*     */     //   746: invokeinterface getMotionZ : ()D
/*     */     //   751: aload_0
/*     */     //   752: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   755: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   758: checkcast java/lang/Number
/*     */     //   761: invokevirtual doubleValue : ()D
/*     */     //   764: dmul
/*     */     //   765: invokeinterface setMotionZ : (D)V
/*     */     //   770: aload_0
/*     */     //   771: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   774: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   777: checkcast java/lang/String
/*     */     //   780: ldc_w 'Off'
/*     */     //   783: iconst_1
/*     */     //   784: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   787: ifne -> 1249
/*     */     //   790: aload_0
/*     */     //   791: getfield shouldGoDown : Z
/*     */     //   794: ifne -> 1249
/*     */     //   797: ldc2_w 0.5
/*     */     //   800: dstore_3
/*     */     //   801: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   804: dup
/*     */     //   805: aload_2
/*     */     //   806: invokeinterface getPosX : ()D
/*     */     //   811: aload_2
/*     */     //   812: invokeinterface getPosY : ()D
/*     */     //   817: dconst_1
/*     */     //   818: dsub
/*     */     //   819: aload_2
/*     */     //   820: invokeinterface getPosZ : ()D
/*     */     //   825: invokespecial <init> : (DDD)V
/*     */     //   828: astore #5
/*     */     //   830: aload_0
/*     */     //   831: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   834: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   837: checkcast java/lang/Number
/*     */     //   840: invokevirtual floatValue : ()F
/*     */     //   843: iconst_0
/*     */     //   844: i2f
/*     */     //   845: fcmpl
/*     */     //   846: ifle -> 1039
/*     */     //   849: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   852: astore #8
/*     */     //   854: aload #8
/*     */     //   856: arraylength
/*     */     //   857: istore #9
/*     */     //   859: iconst_0
/*     */     //   860: istore #7
/*     */     //   862: iload #7
/*     */     //   864: iload #9
/*     */     //   866: if_icmpge -> 1039
/*     */     //   869: aload #8
/*     */     //   871: iload #7
/*     */     //   873: aaload
/*     */     //   874: astore #6
/*     */     //   876: aload #6
/*     */     //   878: getstatic net/minecraft/util/EnumFacing.UP : Lnet/minecraft/util/EnumFacing;
/*     */     //   881: if_acmpeq -> 892
/*     */     //   884: aload #6
/*     */     //   886: getstatic net/minecraft/util/EnumFacing.DOWN : Lnet/minecraft/util/EnumFacing;
/*     */     //   889: if_acmpne -> 895
/*     */     //   892: goto -> 1033
/*     */     //   895: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   898: aload #6
/*     */     //   900: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   905: astore #10
/*     */     //   907: aload #5
/*     */     //   909: aload #10
/*     */     //   911: iconst_0
/*     */     //   912: iconst_2
/*     */     //   913: aconst_null
/*     */     //   914: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   917: astore #11
/*     */     //   919: iconst_0
/*     */     //   920: istore #12
/*     */     //   922: aload #11
/*     */     //   924: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   927: dup
/*     */     //   928: ifnull -> 939
/*     */     //   931: invokeinterface isReplaceable : ()Z
/*     */     //   936: goto -> 941
/*     */     //   939: pop
/*     */     //   940: iconst_0
/*     */     //   941: ifeq -> 1033
/*     */     //   944: aload #6
/*     */     //   946: getstatic net/minecraft/util/EnumFacing.NORTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   949: if_acmpeq -> 960
/*     */     //   952: aload #6
/*     */     //   954: getstatic net/minecraft/util/EnumFacing.SOUTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   957: if_acmpne -> 990
/*     */     //   960: aload #11
/*     */     //   962: invokevirtual getZ : ()I
/*     */     //   965: i2d
/*     */     //   966: ldc2_w 0.5
/*     */     //   969: dadd
/*     */     //   970: aload_2
/*     */     //   971: invokeinterface getPosZ : ()D
/*     */     //   976: dsub
/*     */     //   977: dstore #14
/*     */     //   979: iconst_0
/*     */     //   980: istore #16
/*     */     //   982: dload #14
/*     */     //   984: invokestatic abs : (D)D
/*     */     //   987: goto -> 1017
/*     */     //   990: aload #11
/*     */     //   992: invokevirtual getX : ()I
/*     */     //   995: i2d
/*     */     //   996: ldc2_w 0.5
/*     */     //   999: dadd
/*     */     //   1000: aload_2
/*     */     //   1001: invokeinterface getPosX : ()D
/*     */     //   1006: dsub
/*     */     //   1007: dstore #14
/*     */     //   1009: iconst_0
/*     */     //   1010: istore #16
/*     */     //   1012: dload #14
/*     */     //   1014: invokestatic abs : (D)D
/*     */     //   1017: ldc2_w 0.5
/*     */     //   1020: dsub
/*     */     //   1021: dstore #12
/*     */     //   1023: dload #12
/*     */     //   1025: dload_3
/*     */     //   1026: dcmpg
/*     */     //   1027: ifge -> 1033
/*     */     //   1030: dload #12
/*     */     //   1032: dstore_3
/*     */     //   1033: iinc #7, 1
/*     */     //   1036: goto -> 862
/*     */     //   1039: aload_0
/*     */     //   1040: getfield placedBlocksWithoutEagle : I
/*     */     //   1043: aload_0
/*     */     //   1044: getfield blocksToEagleValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1047: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1050: checkcast java/lang/Number
/*     */     //   1053: invokevirtual intValue : ()I
/*     */     //   1056: if_icmplt -> 1236
/*     */     //   1059: iconst_0
/*     */     //   1060: istore #7
/*     */     //   1062: aload #5
/*     */     //   1064: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1067: dup
/*     */     //   1068: ifnull -> 1079
/*     */     //   1071: invokeinterface isReplaceable : ()Z
/*     */     //   1076: goto -> 1081
/*     */     //   1079: pop
/*     */     //   1080: iconst_0
/*     */     //   1081: ifne -> 1121
/*     */     //   1084: aload_0
/*     */     //   1085: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1088: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1091: checkcast java/lang/Number
/*     */     //   1094: invokevirtual floatValue : ()F
/*     */     //   1097: iconst_0
/*     */     //   1098: i2f
/*     */     //   1099: fcmpl
/*     */     //   1100: ifle -> 1125
/*     */     //   1103: dload_3
/*     */     //   1104: aload_0
/*     */     //   1105: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1108: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1111: checkcast java/lang/Number
/*     */     //   1114: invokevirtual doubleValue : ()D
/*     */     //   1117: dcmpg
/*     */     //   1118: ifge -> 1125
/*     */     //   1121: iconst_1
/*     */     //   1122: goto -> 1126
/*     */     //   1125: iconst_0
/*     */     //   1126: istore #6
/*     */     //   1128: aload_0
/*     */     //   1129: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1132: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1135: checkcast java/lang/String
/*     */     //   1138: ldc_w 'Silent'
/*     */     //   1141: iconst_1
/*     */     //   1142: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1145: ifeq -> 1208
/*     */     //   1148: aload_0
/*     */     //   1149: getfield eagleSneaking : Z
/*     */     //   1152: iload #6
/*     */     //   1154: if_icmpeq -> 1199
/*     */     //   1157: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1160: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1165: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1168: aload_2
/*     */     //   1169: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   1172: iload #6
/*     */     //   1174: ifeq -> 1183
/*     */     //   1177: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1180: goto -> 1186
/*     */     //   1183: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1186: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   1191: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1194: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1199: aload_0
/*     */     //   1200: iload #6
/*     */     //   1202: putfield eagleSneaking : Z
/*     */     //   1205: goto -> 1228
/*     */     //   1208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1211: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1216: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1221: iload #6
/*     */     //   1223: invokeinterface setPressed : (Z)V
/*     */     //   1228: aload_0
/*     */     //   1229: iconst_0
/*     */     //   1230: putfield placedBlocksWithoutEagle : I
/*     */     //   1233: goto -> 1249
/*     */     //   1236: aload_0
/*     */     //   1237: dup
/*     */     //   1238: getfield placedBlocksWithoutEagle : I
/*     */     //   1241: dup
/*     */     //   1242: istore #6
/*     */     //   1244: iconst_1
/*     */     //   1245: iadd
/*     */     //   1246: putfield placedBlocksWithoutEagle : I
/*     */     //   1249: aload_2
/*     */     //   1250: invokeinterface getOnGround : ()Z
/*     */     //   1255: ifeq -> 1812
/*     */     //   1258: aload_0
/*     */     //   1259: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1262: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1265: checkcast java/lang/String
/*     */     //   1268: astore_3
/*     */     //   1269: iconst_0
/*     */     //   1270: istore #4
/*     */     //   1272: aload_3
/*     */     //   1273: dup
/*     */     //   1274: ifnonnull -> 1288
/*     */     //   1277: new kotlin/TypeCastException
/*     */     //   1280: dup
/*     */     //   1281: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1284: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1287: athrow
/*     */     //   1288: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1291: dup
/*     */     //   1292: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1295: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1298: astore_3
/*     */     //   1299: aload_3
/*     */     //   1300: invokevirtual hashCode : ()I
/*     */     //   1303: tableswitch default -> 1343, 1388740000 -> 1320
/*     */     //   1320: aload_3
/*     */     //   1321: ldc_w 'rewinside'
/*     */     //   1324: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1327: ifeq -> 1343
/*     */     //   1330: ldc_w 0.2
/*     */     //   1333: invokestatic strafe : (F)V
/*     */     //   1336: aload_2
/*     */     //   1337: dconst_0
/*     */     //   1338: invokeinterface setMotionY : (D)V
/*     */     //   1343: aload_0
/*     */     //   1344: getfield zitterMode : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1347: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1350: checkcast java/lang/String
/*     */     //   1353: astore_3
/*     */     //   1354: iconst_0
/*     */     //   1355: istore #4
/*     */     //   1357: aload_3
/*     */     //   1358: dup
/*     */     //   1359: ifnonnull -> 1373
/*     */     //   1362: new kotlin/TypeCastException
/*     */     //   1365: dup
/*     */     //   1366: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1369: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1372: athrow
/*     */     //   1373: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1376: dup
/*     */     //   1377: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1380: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1383: astore_3
/*     */     //   1384: aload_3
/*     */     //   1385: invokevirtual hashCode : ()I
/*     */     //   1388: lookupswitch default -> 1812, -1360201941 -> 1424, -898533970 -> 1450, 109935 -> 1437
/*     */     //   1424: aload_3
/*     */     //   1425: ldc_w 'teleport'
/*     */     //   1428: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1431: ifeq -> 1812
/*     */     //   1434: goto -> 1657
/*     */     //   1437: aload_3
/*     */     //   1438: ldc_w 'off'
/*     */     //   1441: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1444: ifeq -> 1812
/*     */     //   1447: goto -> 1463
/*     */     //   1450: aload_3
/*     */     //   1451: ldc_w 'smooth'
/*     */     //   1454: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1457: ifeq -> 1812
/*     */     //   1460: goto -> 1464
/*     */     //   1463: return
/*     */     //   1464: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1467: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1470: getfield field_74366_z : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1473: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1476: ifne -> 1498
/*     */     //   1479: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1482: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1487: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1492: iconst_0
/*     */     //   1493: invokeinterface setPressed : (Z)V
/*     */     //   1498: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1501: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1504: getfield field_74370_x : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1507: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1510: ifne -> 1532
/*     */     //   1513: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1516: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1521: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1526: iconst_0
/*     */     //   1527: invokeinterface setPressed : (Z)V
/*     */     //   1532: aload_0
/*     */     //   1533: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1536: ldc2_w 100
/*     */     //   1539: invokevirtual hasTimePassed : (J)Z
/*     */     //   1542: ifeq -> 1568
/*     */     //   1545: aload_0
/*     */     //   1546: aload_0
/*     */     //   1547: getfield zitterDirection : Z
/*     */     //   1550: ifne -> 1557
/*     */     //   1553: iconst_1
/*     */     //   1554: goto -> 1558
/*     */     //   1557: iconst_0
/*     */     //   1558: putfield zitterDirection : Z
/*     */     //   1561: aload_0
/*     */     //   1562: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1565: invokevirtual reset : ()V
/*     */     //   1568: aload_0
/*     */     //   1569: getfield zitterDirection : Z
/*     */     //   1572: ifeq -> 1616
/*     */     //   1575: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1578: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1583: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1588: iconst_1
/*     */     //   1589: invokeinterface setPressed : (Z)V
/*     */     //   1594: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1597: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1602: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1607: iconst_0
/*     */     //   1608: invokeinterface setPressed : (Z)V
/*     */     //   1613: goto -> 1812
/*     */     //   1616: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1619: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1624: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1629: iconst_0
/*     */     //   1630: invokeinterface setPressed : (Z)V
/*     */     //   1635: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1638: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1643: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1648: iconst_1
/*     */     //   1649: invokeinterface setPressed : (Z)V
/*     */     //   1654: goto -> 1812
/*     */     //   1657: aload_0
/*     */     //   1658: getfield zitterSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1661: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1664: checkcast java/lang/Number
/*     */     //   1667: invokevirtual floatValue : ()F
/*     */     //   1670: invokestatic strafe : (F)V
/*     */     //   1673: aload_2
/*     */     //   1674: invokeinterface getRotationYaw : ()F
/*     */     //   1679: f2d
/*     */     //   1680: aload_0
/*     */     //   1681: getfield zitterDirection : Z
/*     */     //   1684: ifeq -> 1693
/*     */     //   1687: ldc2_w 90.0
/*     */     //   1690: goto -> 1696
/*     */     //   1693: ldc2_w -90.0
/*     */     //   1696: dadd
/*     */     //   1697: invokestatic toRadians : (D)D
/*     */     //   1700: dstore #4
/*     */     //   1702: aload_2
/*     */     //   1703: aload_2
/*     */     //   1704: invokeinterface getMotionX : ()D
/*     */     //   1709: dstore #18
/*     */     //   1711: astore #17
/*     */     //   1713: iconst_0
/*     */     //   1714: istore #6
/*     */     //   1716: dload #4
/*     */     //   1718: invokestatic sin : (D)D
/*     */     //   1721: dstore #20
/*     */     //   1723: aload #17
/*     */     //   1725: dload #18
/*     */     //   1727: dload #20
/*     */     //   1729: aload_0
/*     */     //   1730: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1733: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1736: checkcast java/lang/Number
/*     */     //   1739: invokevirtual doubleValue : ()D
/*     */     //   1742: dmul
/*     */     //   1743: dsub
/*     */     //   1744: invokeinterface setMotionX : (D)V
/*     */     //   1749: aload_2
/*     */     //   1750: aload_2
/*     */     //   1751: invokeinterface getMotionZ : ()D
/*     */     //   1756: dstore #18
/*     */     //   1758: astore #17
/*     */     //   1760: iconst_0
/*     */     //   1761: istore #6
/*     */     //   1763: dload #4
/*     */     //   1765: invokestatic cos : (D)D
/*     */     //   1768: dstore #20
/*     */     //   1770: aload #17
/*     */     //   1772: dload #18
/*     */     //   1774: dload #20
/*     */     //   1776: aload_0
/*     */     //   1777: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1780: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1783: checkcast java/lang/Number
/*     */     //   1786: invokevirtual doubleValue : ()D
/*     */     //   1789: dmul
/*     */     //   1790: dadd
/*     */     //   1791: invokeinterface setMotionZ : (D)V
/*     */     //   1796: aload_0
/*     */     //   1797: aload_0
/*     */     //   1798: getfield zitterDirection : Z
/*     */     //   1801: ifne -> 1808
/*     */     //   1804: iconst_1
/*     */     //   1805: goto -> 1809
/*     */     //   1808: iconst_0
/*     */     //   1809: putfield zitterDirection : Z
/*     */     //   1812: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #221	-> 0
/*     */     //   #221	-> 15
/*     */     //   #222	-> 18
/*     */     //   #223	-> 27
/*     */     //   #225	-> 42
/*     */     //   #226	-> 80
/*     */     //   #227	-> 85
/*     */     //   #228	-> 92
/*     */     //   #229	-> 97
/*     */     //   #230	-> 102
/*     */     //   #231	-> 107
/*     */     //   #232	-> 112
/*     */     //   #233	-> 117
/*     */     //   #234	-> 130
/*     */     //   #235	-> 145
/*     */     //   #237	-> 150
/*     */     //   #239	-> 155
/*     */     //   #240	-> 155
/*     */     //   #241	-> 184
/*     */     //   #242	-> 213
/*     */     //   #243	-> 239
/*     */     //   #244	-> 362
/*     */     //   #245	-> 485
/*     */     //   #246	-> 485
/*     */     //   #247	-> 485
/*     */     //   #245	-> 485
/*     */     //   #246	-> 515
/*     */     //   #247	-> 558
/*     */     //   #249	-> 591
/*     */     //   #251	-> 612
/*     */     //   #252	-> 612
/*     */     //   #253	-> 676
/*     */     //   #254	-> 683
/*     */     //   #256	-> 702
/*     */     //   #257	-> 718
/*     */     //   #258	-> 744
/*     */     //   #261	-> 770
/*     */     //   #262	-> 797
/*     */     //   #263	-> 801
/*     */     //   #264	-> 830
/*     */     //   #265	-> 849
/*     */     //   #266	-> 876
/*     */     //   #267	-> 892
/*     */     //   #269	-> 895
/*     */     //   #270	-> 907
/*     */     //   #271	-> 919
/*     */     //   #843	-> 922
/*     */     //   #843	-> 939
/*     */     //   #272	-> 944
/*     */     //   #273	-> 960
/*     */     //   #275	-> 990
/*     */     //   #272	-> 1017
/*     */     //   #276	-> 1017
/*     */     //   #272	-> 1021
/*     */     //   #278	-> 1023
/*     */     //   #279	-> 1030
/*     */     //   #265	-> 1033
/*     */     //   #284	-> 1039
/*     */     //   #285	-> 1059
/*     */     //   #286	-> 1059
/*     */     //   #844	-> 1062
/*     */     //   #844	-> 1079
/*     */     //   #286	-> 1084
/*     */     //   #285	-> 1126
/*     */     //   #287	-> 1128
/*     */     //   #288	-> 1148
/*     */     //   #289	-> 1157
/*     */     //   #290	-> 1165
/*     */     //   #291	-> 1168
/*     */     //   #292	-> 1177
/*     */     //   #294	-> 1183
/*     */     //   #291	-> 1186
/*     */     //   #290	-> 1186
/*     */     //   #289	-> 1194
/*     */     //   #299	-> 1199
/*     */     //   #301	-> 1208
/*     */     //   #302	-> 1228
/*     */     //   #303	-> 1228
/*     */     //   #305	-> 1236
/*     */     //   #306	-> 1249
/*     */     //   #308	-> 1249
/*     */     //   #309	-> 1258
/*     */     //   #310	-> 1320
/*     */     //   #311	-> 1330
/*     */     //   #312	-> 1336
/*     */     //   #314	-> 1343
/*     */     //   #315	-> 1343
/*     */     //   #338	-> 1424
/*     */     //   #316	-> 1437
/*     */     //   #319	-> 1450
/*     */     //   #317	-> 1463
/*     */     //   #320	-> 1464
/*     */     //   #321	-> 1479
/*     */     //   #323	-> 1498
/*     */     //   #324	-> 1513
/*     */     //   #326	-> 1532
/*     */     //   #327	-> 1545
/*     */     //   #328	-> 1561
/*     */     //   #330	-> 1568
/*     */     //   #331	-> 1575
/*     */     //   #332	-> 1594
/*     */     //   #334	-> 1616
/*     */     //   #335	-> 1635
/*     */     //   #336	-> 1654
/*     */     //   #339	-> 1657
/*     */     //   #340	-> 1673
/*     */     //   #341	-> 1702
/*     */     //   #341	-> 1729
/*     */     //   #342	-> 1749
/*     */     //   #342	-> 1776
/*     */     //   #343	-> 1796
/*     */     //   #345	-> 1812
/*     */     //   #347	-> 1812
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   922	19	12	$i$f$isReplaceable	I
/*     */     //   1023	10	12	calcDif	D
/*     */     //   919	114	11	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   907	126	10	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   876	160	6	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1062	19	7	$i$f$isReplaceable	I
/*     */     //   1128	105	6	shouldEagle	Z
/*     */     //   830	419	5	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   801	448	3	dif	D
/*     */     //   1702	110	4	yaw	D
/*     */     //   18	1795	2	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1813	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold3;
/*     */     //   0	1813	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 351 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof net.minecraft.network.play.server.SPacketDisconnect) {
/* 352 */       setState(false);
/*     */     }
/* 354 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 358 */     IPacket packet = event.getPacket();
/* 359 */     if (packet instanceof CPacketHeldItemChange) {
/* 360 */       this.slot = ((CPacketHeldItemChange)packet).func_149614_c();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event)
/*     */   {
/* 367 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       return;
/*     */     }
/* 370 */     if (!this.canRot)
/* 371 */       return;  update();
/* 372 */     if (this.lockRotation != null) { Rotation rotation = this.lockRotation;
/*     */       
/* 374 */       if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue()))) {
/* 375 */         if (this.targetPlace == null) {
/* 376 */           rotation.setYaw(WMathHelper.wrapAngleTo180_float(MathKt.roundToInt(rotation.getYaw() / 45.0F) * 45.0F));
/*     */         }
/* 378 */         setRotation(rotation);
/* 379 */         this.lockRotationTimer.update();
/*     */         
/* 381 */         rotation.applyStrafeToPlayer(event);
/* 382 */         event.cancelEvent();
/*     */         
/*     */         return;
/*     */       } 
/* 386 */       if (RotationUtils.targetRotation != null) { Rotation targetRotation = RotationUtils.targetRotation;
/* 387 */         targetRotation.applyStrafeToPlayer(event);
/* 388 */         event.cancelEvent();
/*     */         return; }
/*     */       
/*     */       return; }
/*     */      } @EventTarget
/* 393 */   public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); EventState eventState = event.getEventState();
/* 394 */     if (!this.canRot)
/*     */       return; 
/* 396 */     if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue())) && this.lockRotation != null && 
/* 397 */       StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       
/* 399 */       if (this.lockRotation == null) Intrinsics.throwNpe();  setRotation(this.lockRotation);
/* 400 */       if (eventState == EventState.POST) {
/* 401 */         this.lockRotationTimer.update();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 406 */     if ((this.facesBlock || !((Boolean)this.rotationsValue.get()).booleanValue()) && StringsKt.equals((String)this.placeModeValue.get(), eventState.getStateName(), true)) {
/* 407 */       if (!this.canPlace)
/* 408 */         return;  place();
/*     */     } 
/* 410 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((MinecraftInstance.mc.getThePlayer().getFallDistance() > false && ((Boolean)this.FallFastplace.get()).booleanValue()) || (this.canPlace && ((Boolean)this.Fastplace.get()).booleanValue())) {
/* 411 */       place();
/*     */     }
/*     */     
/* 414 */     if (eventState == EventState.PRE && StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/* 415 */       update();
/*     */     }
/*     */ 
/*     */     
/* 419 */     if (this.targetPlace == null && ((Boolean)this.placeDelay.get()).booleanValue()) {
/* 420 */       this.delayTimer.reset();
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
/*     */     //   #425	-> 0
/*     */     //   #426	-> 8
/*     */     //   #426	-> 23
/*     */     //   #428	-> 26
/*     */     //   #429	-> 65
/*     */     //   #430	-> 65
/*     */     //   #429	-> 65
/*     */     //   #430	-> 75
/*     */     //   #431	-> 85
/*     */     //   #429	-> 113
/*     */     //   #433	-> 116
/*     */     //   #436	-> 117
/*     */     //   #437	-> 138
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   65	74	2	holdingItem	Z
/*     */     //   26	113	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	139	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void setRotation(Rotation rotation) {
/* 440 */     if (!this.canRot)
/* 441 */       return;  if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 443 */       if (((Boolean)this.silentRotationValue.get()).booleanValue())
/* 444 */       { RotationUtils.setTargetRotation(rotation, 0); }
/*     */       else
/* 446 */       { player.setRotationYaw(rotation.getYaw());
/* 447 */         player.setRotationPitch(rotation.getPitch()); }  return; }  MinecraftInstance.mc.getThePlayer();
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
/*     */     //   214: ifgt -> 513
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
/*     */     //   278: lookupswitch default -> 494, -889473228 -> 362, 109935 -> 348, 3440673 -> 334, 109651721 -> 320
/*     */     //   320: aload #5
/*     */     //   322: ldc_w 'spoof'
/*     */     //   325: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   328: ifeq -> 494
/*     */     //   331: goto -> 409
/*     */     //   334: aload #5
/*     */     //   336: ldc_w 'pick'
/*     */     //   339: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   342: ifeq -> 494
/*     */     //   345: goto -> 377
/*     */     //   348: aload #5
/*     */     //   350: ldc_w 'off'
/*     */     //   353: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   356: ifeq -> 494
/*     */     //   359: goto -> 376
/*     */     //   362: aload #5
/*     */     //   364: ldc_w 'switch'
/*     */     //   367: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   370: ifeq -> 494
/*     */     //   373: goto -> 453
/*     */     //   376: return
/*     */     //   377: aload_1
/*     */     //   378: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   383: iload #4
/*     */     //   385: bipush #36
/*     */     //   387: isub
/*     */     //   388: invokeinterface setCurrentItem : (I)V
/*     */     //   393: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   396: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   401: invokeinterface updateController : ()V
/*     */     //   406: goto -> 494
/*     */     //   409: iload #4
/*     */     //   411: bipush #36
/*     */     //   413: isub
/*     */     //   414: aload_0
/*     */     //   415: getfield slot : I
/*     */     //   418: if_icmpeq -> 494
/*     */     //   421: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   424: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   429: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   432: iload #4
/*     */     //   434: bipush #36
/*     */     //   436: isub
/*     */     //   437: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   442: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   445: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   450: goto -> 494
/*     */     //   453: iload #4
/*     */     //   455: bipush #36
/*     */     //   457: isub
/*     */     //   458: aload_0
/*     */     //   459: getfield slot : I
/*     */     //   462: if_icmpeq -> 494
/*     */     //   465: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   468: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   473: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   476: iload #4
/*     */     //   478: bipush #36
/*     */     //   480: isub
/*     */     //   481: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   486: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   489: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   494: aload_1
/*     */     //   495: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   500: iload #4
/*     */     //   502: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   507: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   512: astore_3
/*     */     //   513: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   516: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   521: aload_1
/*     */     //   522: aload_2
/*     */     //   523: aload_3
/*     */     //   524: aload_0
/*     */     //   525: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   528: dup
/*     */     //   529: ifnonnull -> 535
/*     */     //   532: invokestatic throwNpe : ()V
/*     */     //   535: invokevirtual getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   538: aload_0
/*     */     //   539: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   542: dup
/*     */     //   543: ifnonnull -> 549
/*     */     //   546: invokestatic throwNpe : ()V
/*     */     //   549: invokevirtual getEnumFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   552: aload_0
/*     */     //   553: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   556: dup
/*     */     //   557: ifnonnull -> 563
/*     */     //   560: invokestatic throwNpe : ()V
/*     */     //   563: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*     */     //   566: invokeinterface onPlayerRightClick : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)Z
/*     */     //   571: ifeq -> 782
/*     */     //   574: aload_0
/*     */     //   575: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   578: invokevirtual reset : ()V
/*     */     //   581: aload_0
/*     */     //   582: aload_0
/*     */     //   583: getfield placeDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   586: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   589: checkcast java/lang/Boolean
/*     */     //   592: invokevirtual booleanValue : ()Z
/*     */     //   595: ifne -> 602
/*     */     //   598: lconst_0
/*     */     //   599: goto -> 674
/*     */     //   602: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   605: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   610: dup
/*     */     //   611: ifnonnull -> 617
/*     */     //   614: invokestatic throwNpe : ()V
/*     */     //   617: invokeinterface getFallDistance : ()F
/*     */     //   622: iconst_0
/*     */     //   623: i2f
/*     */     //   624: fcmpl
/*     */     //   625: ifle -> 645
/*     */     //   628: aload_0
/*     */     //   629: getfield falldowndelay : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   632: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   635: checkcast java/lang/Number
/*     */     //   638: invokevirtual intValue : ()I
/*     */     //   641: i2l
/*     */     //   642: goto -> 674
/*     */     //   645: aload_0
/*     */     //   646: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   649: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   652: checkcast java/lang/Number
/*     */     //   655: invokevirtual intValue : ()I
/*     */     //   658: aload_0
/*     */     //   659: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   662: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   665: checkcast java/lang/Number
/*     */     //   668: invokevirtual intValue : ()I
/*     */     //   671: invokestatic randomDelay : (II)J
/*     */     //   674: putfield delay : J
/*     */     //   677: aload_1
/*     */     //   678: invokeinterface getOnGround : ()Z
/*     */     //   683: ifeq -> 733
/*     */     //   686: aload_0
/*     */     //   687: getfield speedModifierValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   690: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   693: checkcast java/lang/Number
/*     */     //   696: invokevirtual floatValue : ()F
/*     */     //   699: fstore #4
/*     */     //   701: aload_1
/*     */     //   702: aload_1
/*     */     //   703: invokeinterface getMotionX : ()D
/*     */     //   708: fload #4
/*     */     //   710: f2d
/*     */     //   711: dmul
/*     */     //   712: invokeinterface setMotionX : (D)V
/*     */     //   717: aload_1
/*     */     //   718: aload_1
/*     */     //   719: invokeinterface getMotionZ : ()D
/*     */     //   724: fload #4
/*     */     //   726: f2d
/*     */     //   727: dmul
/*     */     //   728: invokeinterface setMotionZ : (D)V
/*     */     //   733: aload_0
/*     */     //   734: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   737: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   740: checkcast java/lang/Boolean
/*     */     //   743: invokevirtual booleanValue : ()Z
/*     */     //   746: ifeq -> 758
/*     */     //   749: aload_1
/*     */     //   750: invokeinterface swingItem : ()V
/*     */     //   755: goto -> 782
/*     */     //   758: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   761: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   766: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   769: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*     */     //   774: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   777: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   782: aload_0
/*     */     //   783: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   786: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   789: checkcast java/lang/String
/*     */     //   792: ldc_w 'Switch'
/*     */     //   795: iconst_1
/*     */     //   796: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   799: ifeq -> 855
/*     */     //   802: aload_0
/*     */     //   803: getfield slot : I
/*     */     //   806: aload_1
/*     */     //   807: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   812: invokeinterface getCurrentItem : ()I
/*     */     //   817: if_icmpeq -> 855
/*     */     //   820: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   823: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   828: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   831: aload_1
/*     */     //   832: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   837: invokeinterface getCurrentItem : ()I
/*     */     //   842: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*     */     //   847: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   850: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   855: aload_0
/*     */     //   856: aconst_null
/*     */     //   857: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*     */     //   860: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   863: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #493	-> 0
/*     */     //   #493	-> 15
/*     */     //   #494	-> 18
/*     */     //   #494	-> 33
/*     */     //   #495	-> 36
/*     */     //   #496	-> 44
/*     */     //   #497	-> 51
/*     */     //   #498	-> 67
/*     */     //   #500	-> 74
/*     */     //   #503	-> 75
/*     */     //   #504	-> 132
/*     */     //   #507	-> 133
/*     */     //   #508	-> 140
/*     */     //   #509	-> 217
/*     */     //   #511	-> 222
/*     */     //   #512	-> 228
/*     */     //   #515	-> 229
/*     */     //   #523	-> 320
/*     */     //   #519	-> 334
/*     */     //   #516	-> 348
/*     */     //   #528	-> 362
/*     */     //   #517	-> 376
/*     */     //   #520	-> 377
/*     */     //   #521	-> 393
/*     */     //   #524	-> 409
/*     */     //   #525	-> 421
/*     */     //   #529	-> 453
/*     */     //   #530	-> 465
/*     */     //   #533	-> 494
/*     */     //   #534	-> 494
/*     */     //   #537	-> 513
/*     */     //   #538	-> 521
/*     */     //   #537	-> 566
/*     */     //   #541	-> 574
/*     */     //   #542	-> 581
/*     */     //   #543	-> 598
/*     */     //   #545	-> 602
/*     */     //   #546	-> 628
/*     */     //   #548	-> 645
/*     */     //   #545	-> 674
/*     */     //   #542	-> 674
/*     */     //   #553	-> 677
/*     */     //   #554	-> 686
/*     */     //   #555	-> 701
/*     */     //   #556	-> 717
/*     */     //   #559	-> 733
/*     */     //   #560	-> 749
/*     */     //   #562	-> 758
/*     */     //   #563	-> 782
/*     */     //   #565	-> 782
/*     */     //   #566	-> 802
/*     */     //   #567	-> 820
/*     */     //   #570	-> 855
/*     */     //   #571	-> 863
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   222	291	4	blockSlot	I
/*     */     //   701	32	4	modifier	F
/*     */     //   140	724	3	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   36	828	2	world	Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   18	846	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	864	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold3; } public void onDisable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74311_E)) { MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); if (this.eagleSneaking)
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)player, ICPacketEntityAction.WAction.STOP_SNEAKING));  }  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74366_z))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74370_x))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);  this.lockRotation = (Rotation)null; this.facesBlock = false; MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); this.shouldGoDown = false; if (this.slot != player.getInventory().getCurrentItem())
/* 453 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(player.getInventory().getCurrentItem()));  return; }  MinecraftInstance.mc.getThePlayer(); } private final void findBlock(boolean expand) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 454 */       if (!this.canRot)
/* 455 */         return;  WBlockPos blockPosition = this.shouldGoDown ? (
/* 456 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 457 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ()) : (
/*     */         
/* 459 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ())).down()) : (
/*     */         
/* 461 */         (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? 
/* 462 */         new WBlockPos(player.getPosX(), this.launchY - 1.0D, player.getPosZ()) : (
/* 463 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 464 */         new WBlockPos((IEntity)player) : (
/*     */         
/* 466 */         new WBlockPos(player.getPosX(), player.getPosY(), player.getPosZ())).down()));
/*     */       
/* 468 */       if (!expand) { int $i$f$isReplaceable = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 845 */         BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0) || search(blockPosition, !this.shouldGoDown)) return;  }  if (expand) { double yaw = Math.toRadians(player.getRotationYaw() + '´'); boolean bool = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); byte b = 0; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); int i; for (b = 0, i = ((Number)this.expandLengthValue.get()).intValue(); b < i; b++) { if (search(blockPosition.add(x * b, 0, z * b), false)) return;  }  } else if (((Boolean)this.searchValue.get()).booleanValue()) { byte b; byte b1; for (b = -1, b1 = 1; b <= b1; b++) { byte b2; byte b3; for (b2 = -1, b3 = 1; b2 <= b3; b2++) { if (search(blockPosition.add(b, 0, b2), !this.shouldGoDown)) return;  }  }  }  return; }  MinecraftInstance.mc.getThePlayer(); }
/* 846 */   @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown) return;  if (((Boolean)this.airSafeValue.get()).booleanValue() || player.getOnGround()) event.setSafeWalk(true);  return; }  MinecraftInstance.mc.getThePlayer(); } @EventTarget public final void onRender2D(@NotNull Render2DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.counterDisplayValue.get()).booleanValue()) { GL11.glPushMatrix(); if (Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay");  BlockOverlay blockOverlay = (BlockOverlay)Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class); if (blockOverlay.getState() && ((Boolean)blockOverlay.getInfoValue().get()).booleanValue() && blockOverlay.getCurrentBlock() != null) GL11.glTranslatef(0.0F, 15.0F, 0.0F);  String info = "Blocks: §7" + getBlocksAmount(); ScaledResolution scaledResolution = new ScaledResolution(MinecraftInstance.mc2); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawBorderedRect((scaledResolution.func_78326_a() / 2) - 2, (scaledResolution.func_78328_b() / 2) + 5, (scaledResolution.func_78326_a() / 2 + Fonts.font40.getStringWidth(info)) + 2, (scaledResolution.func_78328_b() / 2) + 16, 3.0F, Color.BLACK.getRGB(), Color.BLACK.getRGB()); GlStateManager.func_179117_G(); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(info, scaledResolution.func_78326_a() / 2, (scaledResolution.func_78328_b() / 2) + 7, Color.WHITE.getRGB()); GL11.glPopMatrix(); }  } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.markValue.get()).booleanValue()) return;  for (byte b1 = 0, b2 = StringsKt.equals((String)this.modeValue.get(), "Expand", true) ? (((Number)this.expandLengthValue.get()).intValue() + 1) : 2; b1 < b2; b1++) { double yaw = Math.toRadians(player.getRotationYaw()); boolean bool1 = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); boolean bool2 = false; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); WBlockPos blockPos = new WBlockPos(player.getPosX() + (x * b1), (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? (this.launchY - 1.0D) : (player.getPosY() - ((player.getPosY() == player.getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0D : 0.0D)), player.getPosZ() + (z * b1)); PlaceInfo placeInfo = PlaceInfo.Companion.get(blockPos); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) { RenderUtils.drawBlockBox(blockPos, new Color(68, 117, 255, 100), false); break; }  }  return; }
/* 847 */      MinecraftInstance.mc.getThePlayer(); } private final boolean search(WBlockPos blockPosition, boolean raycast) { this.facesBlock = false; if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient world = MinecraftInstance.mc.getTheWorld(); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0))
/* 848 */           return false;  double xzRV = ((Number)this.xzRangeValue.get()).floatValue(); double xzSSV = calcStepSize((float)xzRV); double yRV = ((Number)this.yRangeValue.get()).floatValue(); double ySSV = calcStepSize((float)yRV); WVec3 eyesPos = new WVec3(player.getPosX(), player.getEntityBoundingBox().getMinY() + player.getEyeHeight(), player.getPosZ()); PlaceRotation placeRotation = (PlaceRotation)null; for (EnumFacingType facingType : EnumFacingType.values()) { IEnumFacing side = MinecraftInstance.classProvider.getEnumFacing(facingType); WBlockPos neighbor = WBlockPos.offset$default(blockPosition, side, 0, 2, null); if (BlockUtils.canBeClicked(neighbor)) { WVec3 dirVec = new WVec3(side.getDirectionVec()); boolean auto = StringsKt.equals((String)this.searchMode.get(), "Auto", true); boolean center = StringsKt.equals((String)this.searchMode.get(), "AutoCenter", true); double xSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (xSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { double ySearch = auto ? 0.1D : (0.5D - yRV / 2); while (ySearch <= (auto ? 0.9D : (0.5D + yRV / 2))) { double zSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (zSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { WVec3 wVec3 = new WVec3((WVec3i)blockPosition); double d1 = center ? 0.5D : xSearch, d2 = center ? 0.5D : ySearch, z$iv = center ? 0.5D : zSearch; continue; $i$f$addVector = 0; posVec = new WVec3(SYNTHETIC_LOCAL_VARIABLE_31.getXCoord() + SYNTHETIC_LOCAL_VARIABLE_32, SYNTHETIC_LOCAL_VARIABLE_31.getYCoord() + SYNTHETIC_LOCAL_VARIABLE_34, SYNTHETIC_LOCAL_VARIABLE_31.getZCoord() + SYNTHETIC_LOCAL_VARIABLE_36); this_$iv = eyesPos; $i$f$squareDistanceTo = 0;
/* 849 */                   d0$iv = posVec.getXCoord() - this_$iv.getXCoord();
/* 850 */                   d1$iv = posVec.getYCoord() - this_$iv.getYCoord();
/* 851 */                   d2$iv = posVec.getZCoord() - this_$iv.getZCoord();
/*     */                   
/* 853 */                   distanceSqPosVec = d0$iv * d0$iv + d1$iv * d1$iv + d2$iv * d2$iv; wVec31 = posVec; vec$iv = new WVec3(dirVec.getXCoord() * 0.5D, dirVec.getYCoord() * 0.5D, dirVec.getZCoord() * 0.5D); $i$f$add = 0;
/* 854 */                   wVec32 = wVec31; d1 = vec$iv.getXCoord(); d2 = vec$iv.getYCoord(); z$iv$iv = vec$iv.getZCoord(); i = 0;
/* 855 */                   hitVec = new WVec3(wVec32.getXCoord() + d1, wVec32.getYCoord() + d2, wVec32.getZCoord() + z$iv$iv); }
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Scaffold3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */