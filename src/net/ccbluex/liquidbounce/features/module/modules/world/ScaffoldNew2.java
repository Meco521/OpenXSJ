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
/*     */ @ModuleInfo(name = "ScaffoldNew2", description = "skid", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000®\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\006\n\002\020\013\n\002\b\003\n\002\020\t\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\002\b \n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\006\n\000\n\002\020\007\n\000\n\002\020\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020X\032\0020Y2\006\020Z\032\0020[H\002J\020\020\\\032\0020]2\006\020^\032\0020\024H\002J\b\020_\032\0020]H\026J\b\020`\032\0020]H\026J\020\020a\032\0020]2\006\020b\032\0020cH\007J\020\020d\032\0020]2\006\020b\032\0020eH\007J\020\020f\032\0020]2\006\020b\032\0020gH\007J\020\020h\032\0020]2\006\020b\032\0020iH\007J\020\020j\032\0020]2\006\020b\032\0020kH\007J\020\020l\032\0020]2\006\020b\032\0020mH\007J\020\020n\032\0020]2\006\020b\032\0020oH\003J\006\020p\032\0020]J\030\020q\032\0020\0242\006\020r\032\0020s2\006\020t\032\0020\024H\002J\020\020u\032\0020]2\006\020v\032\0020(H\002J\006\020w\032\0020]R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\021\020\017\032\0020\r8F¢\006\006\032\004\b\020\020\021R\016\020\022\032\0020\tX\004¢\006\002\n\000R\016\020\023\032\0020\024X\016¢\006\002\n\000R\016\020\025\032\0020\024X\016¢\006\002\n\000R\016\020\026\032\0020\004X\004¢\006\002\n\000R\016\020\027\032\0020\030X\016¢\006\002\n\000R\016\020\031\032\0020\032X\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\024X\016¢\006\002\n\000R\016\020\035\032\0020\007X\004¢\006\002\n\000R\016\020\036\032\0020\037X\004¢\006\002\n\000R\016\020 \032\0020\tX\004¢\006\002\n\000R\016\020!\032\0020\024X\016¢\006\002\n\000R\016\020\"\032\0020\024X\016¢\006\002\n\000R\016\020#\032\0020\tX\004¢\006\002\n\000R\016\020$\032\0020\tX\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\rX\016¢\006\002\n\000R\020\020'\032\004\030\0010(X\016¢\006\002\n\000R\016\020)\032\0020*X\016¢\006\002\n\000R\016\020+\032\0020\004X\004¢\006\002\n\000R\016\020,\032\0020\tX\004¢\006\002\n\000R\016\020-\032\0020\037X\004¢\006\002\n\000R\016\020.\032\0020\tX\004¢\006\002\n\000R\016\020/\032\0020\037X\004¢\006\002\n\000R\016\0200\032\0020\037X\004¢\006\002\n\000R\016\0201\032\0020\007X\004¢\006\002\n\000R\016\0202\032\0020\024X\016¢\006\002\n\000R\016\0203\032\0020\004X\004¢\006\002\n\000R\016\0204\032\0020\007X\004¢\006\002\n\000R\016\0205\032\0020\004X\004¢\006\002\n\000R\016\0206\032\0020\007X\004¢\006\002\n\000R\016\0207\032\0020\rX\016¢\006\002\n\000R\016\0208\032\0020\004X\004¢\006\002\n\000R\016\0209\032\0020\004X\004¢\006\002\n\000R\016\020:\032\0020\004X\004¢\006\002\n\000R\016\020;\032\0020\tX\004¢\006\002\n\000R\016\020<\032\0020\007X\004¢\006\002\n\000R\016\020=\032\0020\004X\004¢\006\002\n\000R\016\020>\032\0020\024X\016¢\006\002\n\000R\016\020?\032\0020\004X\004¢\006\002\n\000R\016\020@\032\0020\rX\016¢\006\002\n\000R\016\020A\032\0020\037X\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\037X\004¢\006\002\n\000R\016\020D\032\0020\007X\004¢\006\002\n\000R\021\020E\032\0020\004¢\006\b\n\000\032\004\bF\020GR\016\020H\032\0020\007X\004¢\006\002\n\000R\016\020I\032\0020\004X\004¢\006\002\n\000R\024\020J\032\0020K8VX\004¢\006\006\032\004\bL\020MR\020\020N\032\004\030\0010OX\016¢\006\002\n\000R\016\020P\032\0020\037X\004¢\006\002\n\000R\016\020Q\032\0020\037X\004¢\006\002\n\000R\016\020R\032\0020\037X\016¢\006\002\n\000R\016\020S\032\0020\024X\016¢\006\002\n\000R\016\020T\032\0020\007X\004¢\006\002\n\000R\016\020U\032\0020\037X\004¢\006\002\n\000R\016\020V\032\0020\037X\004¢\006\002\n\000R\016\020W\032\0020\032X\004¢\006\002\n\000¨\006x"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "FallFastplace", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "Fastplace", "RotConditionValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "Rotairticks", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "airSafeValue", "airticks", "airtime", "", "autoBlockValue", "blocksAmount", "getBlocksAmount", "()I", "blocksToEagleValue", "canPlace", "", "canRot", "counterDisplayValue", "delay", "", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "downValue", "eagleSneaking", "eagleValue", "edgeDistanceValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "expandLengthValue", "f", "facesBlock", "falldowndelay", "keepLengthValue", "keepRotationValue", "launchY", "lockRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "lockRotationTimer", "Lnet/ccbluex/liquidbounce/utils/timer/TickTimer;", "markValue", "maxDelayValue", "maxTurnSpeedValue", "minDelayValue", "minDistValue", "minTurnSpeedValue", "modeValue", "n", "omniDirectionalExpand", "placeConditionValue", "placeDelay", "placeModeValue", "placedBlocksWithoutEagle", "rotationsValue", "safeWalkValue", "sameYValue", "searchAccuracyValue", "searchMode", "searchValue", "shouldGoDown", "silentRotationValue", "slot", "slowSpeed", "slowValue", "speedModifierValue", "sprintModeValue", "sprintValue", "getSprintValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "strafeMode", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "targetPlace", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "timerValue", "xzRangeValue", "yRangeValue", "zitterDirection", "zitterMode", "zitterSpeed", "zitterStrength", "zitterTimer", "calcStepSize", "", "range", "", "findBlock", "", "expand", "onDisable", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "place", "search", "blockPosition", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "raycast", "setRotation", "rotation", "update", "XSJClient"})
/*     */ public final class ScaffoldNew2 extends Module {
/*  53 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal");
/*     */ 
/*     */   
/*  56 */   private final IntegerValue maxDelayValue = new ScaffoldNew2$maxDelayValue$1("MaxDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew2$maxDelayValue$1 extends IntegerValue { ScaffoldNew2$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  58 */       int minDelay = ((Number)ScaffoldNew2.this.minDelayValue.get()).intValue();
/*  59 */       if (minDelay > newValue) {
/*  60 */         set(Integer.valueOf(minDelay));
/*     */       }
/*     */     } }
/*     */ 
/*     */   
/*  65 */   private final IntegerValue minDelayValue = new ScaffoldNew2$minDelayValue$1("MinDelay", 0, 0, 1000); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew2$minDelayValue$1 extends IntegerValue { ScaffoldNew2$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  67 */       int maxDelay = ((Number)ScaffoldNew2.this.maxDelayValue.get()).intValue();
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
/* 122 */   private final IntegerValue searchAccuracyValue = new ScaffoldNew2$searchAccuracyValue$1("SearchAccuracy", 8, 1, 16); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2$searchAccuracyValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew2$searchAccuracyValue$1 extends IntegerValue { ScaffoldNew2$searchAccuracyValue$1(String $super_call_param$0, int $super_call_param$1, int $super_call_param$2, int $super_call_param$3) { super($super_call_param$0, $super_call_param$1, $super_call_param$2, $super_call_param$3); }
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
/* 133 */   private final FloatValue maxTurnSpeedValue = new ScaffoldNew2$maxTurnSpeedValue$1("MaxTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2$maxTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew2$maxTurnSpeedValue$1 extends FloatValue { ScaffoldNew2$maxTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 135 */       float v = ((Number)ScaffoldNew2.this.minTurnSpeedValue.get()).floatValue();
/* 136 */       if (v > newValue) set(Float.valueOf(v)); 
/* 137 */       if (getMaximum() < newValue) {
/* 138 */         set(Float.valueOf(getMaximum()));
/* 139 */       } else if (getMinimum() > newValue) {
/* 140 */         set(Float.valueOf(getMinimum()));
/*     */       } 
/*     */     } }
/*     */   
/* 144 */   private final FloatValue minTurnSpeedValue = new ScaffoldNew2$minTurnSpeedValue$1("MinTurnSpeed", 180.0F, 1.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2$minTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ScaffoldNew2$minTurnSpeedValue$1 extends FloatValue { ScaffoldNew2$minTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(float oldValue, float newValue) {
/* 146 */       float v = ((Number)ScaffoldNew2.this.maxTurnSpeedValue.get()).floatValue();
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
/*     */     //   0: aload_0
/*     */     //   1: getfield sprintValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   4: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   7: checkcast java/lang/Boolean
/*     */     //   10: invokevirtual booleanValue : ()Z
/*     */     //   13: ifeq -> 196
/*     */     //   16: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   19: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   24: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   27: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   32: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   37: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   42: ifne -> 64
/*     */     //   45: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   48: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   53: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   58: iconst_0
/*     */     //   59: invokeinterface setPressed : (Z)V
/*     */     //   64: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   67: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   72: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   75: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   80: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   85: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   90: ifeq -> 112
/*     */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   96: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   101: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   106: iconst_1
/*     */     //   107: invokeinterface setPressed : (Z)V
/*     */     //   112: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   115: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   120: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   125: invokeinterface isKeyDown : ()Z
/*     */     //   130: ifeq -> 154
/*     */     //   133: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   136: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   141: dup
/*     */     //   142: ifnonnull -> 148
/*     */     //   145: invokestatic throwNpe : ()V
/*     */     //   148: iconst_1
/*     */     //   149: invokeinterface setSprinting : (Z)V
/*     */     //   154: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   157: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   162: invokeinterface getKeyBindSprint : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   167: invokeinterface isKeyDown : ()Z
/*     */     //   172: ifne -> 196
/*     */     //   175: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   178: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   183: dup
/*     */     //   184: ifnonnull -> 190
/*     */     //   187: invokestatic throwNpe : ()V
/*     */     //   190: iconst_0
/*     */     //   191: invokeinterface setSprinting : (Z)V
/*     */     //   196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   199: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   204: dup
/*     */     //   205: ifnull -> 211
/*     */     //   208: goto -> 213
/*     */     //   211: pop
/*     */     //   212: return
/*     */     //   213: astore_2
/*     */     //   214: aload_2
/*     */     //   215: invokeinterface getOnGround : ()Z
/*     */     //   220: ifne -> 238
/*     */     //   223: aload_0
/*     */     //   224: dup
/*     */     //   225: getfield airtime : I
/*     */     //   228: dup
/*     */     //   229: istore_3
/*     */     //   230: iconst_1
/*     */     //   231: iadd
/*     */     //   232: putfield airtime : I
/*     */     //   235: goto -> 353
/*     */     //   238: aload_0
/*     */     //   239: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   242: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   245: checkcast java/lang/String
/*     */     //   248: ldc_w 'falldown'
/*     */     //   251: iconst_1
/*     */     //   252: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   255: ifne -> 278
/*     */     //   258: aload_0
/*     */     //   259: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   262: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   265: checkcast java/lang/String
/*     */     //   268: ldc_w 'delayair'
/*     */     //   271: iconst_1
/*     */     //   272: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   275: ifeq -> 348
/*     */     //   278: aload_0
/*     */     //   279: lconst_0
/*     */     //   280: putfield delay : J
/*     */     //   283: aload_0
/*     */     //   284: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   287: invokevirtual reset : ()V
/*     */     //   290: aload_0
/*     */     //   291: iconst_0
/*     */     //   292: putfield eagleSneaking : Z
/*     */     //   295: aload_0
/*     */     //   296: iconst_0
/*     */     //   297: putfield shouldGoDown : Z
/*     */     //   300: aload_0
/*     */     //   301: iconst_0
/*     */     //   302: putfield canPlace : Z
/*     */     //   305: aload_0
/*     */     //   306: iconst_0
/*     */     //   307: putfield canRot : Z
/*     */     //   310: aload_0
/*     */     //   311: iconst_0
/*     */     //   312: putfield f : Z
/*     */     //   315: aload_0
/*     */     //   316: aload_2
/*     */     //   317: invokeinterface getPosY : ()D
/*     */     //   322: invokestatic roundToInt : (D)I
/*     */     //   325: putfield launchY : I
/*     */     //   328: aload_0
/*     */     //   329: aload_2
/*     */     //   330: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   335: invokeinterface getCurrentItem : ()I
/*     */     //   340: putfield slot : I
/*     */     //   343: aload_0
/*     */     //   344: iconst_0
/*     */     //   345: putfield facesBlock : Z
/*     */     //   348: aload_0
/*     */     //   349: iconst_0
/*     */     //   350: putfield airtime : I
/*     */     //   353: aload_0
/*     */     //   354: aload_0
/*     */     //   355: getfield airtime : I
/*     */     //   358: aload_0
/*     */     //   359: getfield airticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   362: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   365: checkcast java/lang/Number
/*     */     //   368: invokevirtual intValue : ()I
/*     */     //   371: if_icmple -> 378
/*     */     //   374: iconst_1
/*     */     //   375: goto -> 379
/*     */     //   378: iconst_0
/*     */     //   379: putfield f : Z
/*     */     //   382: aload_0
/*     */     //   383: aload_0
/*     */     //   384: getfield airtime : I
/*     */     //   387: aload_0
/*     */     //   388: getfield Rotairticks : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   391: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   394: checkcast java/lang/Number
/*     */     //   397: invokevirtual intValue : ()I
/*     */     //   400: if_icmple -> 407
/*     */     //   403: iconst_1
/*     */     //   404: goto -> 408
/*     */     //   407: iconst_0
/*     */     //   408: putfield n : Z
/*     */     //   411: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   414: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   419: aload_0
/*     */     //   420: getfield timerValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   423: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   426: checkcast java/lang/Number
/*     */     //   429: invokevirtual floatValue : ()F
/*     */     //   432: invokeinterface setTimerSpeed : (F)V
/*     */     //   437: aload_0
/*     */     //   438: aload_0
/*     */     //   439: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   442: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   445: checkcast java/lang/String
/*     */     //   448: ldc_w 'falldown'
/*     */     //   451: iconst_1
/*     */     //   452: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   455: ifeq -> 484
/*     */     //   458: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   461: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   466: dup
/*     */     //   467: ifnonnull -> 473
/*     */     //   470: invokestatic throwNpe : ()V
/*     */     //   473: invokeinterface getFallDistance : ()F
/*     */     //   478: iconst_0
/*     */     //   479: i2f
/*     */     //   480: fcmpl
/*     */     //   481: ifgt -> 554
/*     */     //   484: aload_0
/*     */     //   485: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   488: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   491: checkcast java/lang/String
/*     */     //   494: ldc_w 'always'
/*     */     //   497: iconst_1
/*     */     //   498: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   501: ifne -> 554
/*     */     //   504: aload_0
/*     */     //   505: getfield placeConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   508: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   511: checkcast java/lang/String
/*     */     //   514: ldc_w 'delayair'
/*     */     //   517: iconst_1
/*     */     //   518: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   521: ifeq -> 558
/*     */     //   524: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   527: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   532: dup
/*     */     //   533: ifnonnull -> 539
/*     */     //   536: invokestatic throwNpe : ()V
/*     */     //   539: invokeinterface getOnGround : ()Z
/*     */     //   544: ifne -> 558
/*     */     //   547: aload_0
/*     */     //   548: getfield f : Z
/*     */     //   551: ifeq -> 558
/*     */     //   554: iconst_1
/*     */     //   555: goto -> 559
/*     */     //   558: iconst_0
/*     */     //   559: putfield canPlace : Z
/*     */     //   562: aload_0
/*     */     //   563: aload_0
/*     */     //   564: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   567: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   570: checkcast java/lang/String
/*     */     //   573: ldc_w 'falldown'
/*     */     //   576: iconst_1
/*     */     //   577: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   580: ifeq -> 609
/*     */     //   583: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   586: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   591: dup
/*     */     //   592: ifnonnull -> 598
/*     */     //   595: invokestatic throwNpe : ()V
/*     */     //   598: invokeinterface getFallDistance : ()F
/*     */     //   603: iconst_0
/*     */     //   604: i2f
/*     */     //   605: fcmpl
/*     */     //   606: ifgt -> 679
/*     */     //   609: aload_0
/*     */     //   610: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   613: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   616: checkcast java/lang/String
/*     */     //   619: ldc_w 'always'
/*     */     //   622: iconst_1
/*     */     //   623: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   626: ifne -> 679
/*     */     //   629: aload_0
/*     */     //   630: getfield RotConditionValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   633: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   636: checkcast java/lang/String
/*     */     //   639: ldc_w 'delayair'
/*     */     //   642: iconst_1
/*     */     //   643: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   646: ifeq -> 683
/*     */     //   649: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   652: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   657: dup
/*     */     //   658: ifnonnull -> 664
/*     */     //   661: invokestatic throwNpe : ()V
/*     */     //   664: invokeinterface getOnGround : ()Z
/*     */     //   669: ifne -> 683
/*     */     //   672: aload_0
/*     */     //   673: getfield n : Z
/*     */     //   676: ifeq -> 683
/*     */     //   679: iconst_1
/*     */     //   680: goto -> 684
/*     */     //   683: iconst_0
/*     */     //   684: putfield canRot : Z
/*     */     //   687: aload_0
/*     */     //   688: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   691: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   694: checkcast java/lang/String
/*     */     //   697: ldc_w 'off'
/*     */     //   700: iconst_1
/*     */     //   701: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   704: ifne -> 793
/*     */     //   707: aload_0
/*     */     //   708: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   711: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   714: checkcast java/lang/String
/*     */     //   717: ldc_w 'ground'
/*     */     //   720: iconst_1
/*     */     //   721: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   724: ifeq -> 750
/*     */     //   727: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   730: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   735: dup
/*     */     //   736: ifnonnull -> 742
/*     */     //   739: invokestatic throwNpe : ()V
/*     */     //   742: invokeinterface getOnGround : ()Z
/*     */     //   747: ifeq -> 793
/*     */     //   750: aload_0
/*     */     //   751: getfield sprintModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   754: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   757: checkcast java/lang/String
/*     */     //   760: ldc_w 'air'
/*     */     //   763: iconst_1
/*     */     //   764: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   767: ifeq -> 814
/*     */     //   770: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   773: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   778: dup
/*     */     //   779: ifnonnull -> 785
/*     */     //   782: invokestatic throwNpe : ()V
/*     */     //   785: invokeinterface getOnGround : ()Z
/*     */     //   790: ifeq -> 814
/*     */     //   793: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   796: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   801: dup
/*     */     //   802: ifnonnull -> 808
/*     */     //   805: invokestatic throwNpe : ()V
/*     */     //   808: iconst_0
/*     */     //   809: invokeinterface setSprinting : (Z)V
/*     */     //   814: aload_0
/*     */     //   815: aload_0
/*     */     //   816: getfield downValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   819: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   822: checkcast java/lang/Boolean
/*     */     //   825: invokevirtual booleanValue : ()Z
/*     */     //   828: ifeq -> 874
/*     */     //   831: aload_0
/*     */     //   832: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   835: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   838: checkcast java/lang/Boolean
/*     */     //   841: invokevirtual booleanValue : ()Z
/*     */     //   844: ifne -> 874
/*     */     //   847: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   850: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   853: getfield field_74311_E : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   856: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   859: ifeq -> 874
/*     */     //   862: aload_0
/*     */     //   863: invokevirtual getBlocksAmount : ()I
/*     */     //   866: iconst_1
/*     */     //   867: if_icmple -> 874
/*     */     //   870: iconst_1
/*     */     //   871: goto -> 875
/*     */     //   874: iconst_0
/*     */     //   875: putfield shouldGoDown : Z
/*     */     //   878: aload_0
/*     */     //   879: getfield shouldGoDown : Z
/*     */     //   882: ifeq -> 904
/*     */     //   885: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   888: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   893: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   898: iconst_0
/*     */     //   899: invokeinterface setPressed : (Z)V
/*     */     //   904: aload_0
/*     */     //   905: getfield slowValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   908: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   911: checkcast java/lang/Boolean
/*     */     //   914: invokevirtual booleanValue : ()Z
/*     */     //   917: ifeq -> 972
/*     */     //   920: aload_2
/*     */     //   921: aload_2
/*     */     //   922: invokeinterface getMotionX : ()D
/*     */     //   927: aload_0
/*     */     //   928: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   931: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   934: checkcast java/lang/Number
/*     */     //   937: invokevirtual doubleValue : ()D
/*     */     //   940: dmul
/*     */     //   941: invokeinterface setMotionX : (D)V
/*     */     //   946: aload_2
/*     */     //   947: aload_2
/*     */     //   948: invokeinterface getMotionZ : ()D
/*     */     //   953: aload_0
/*     */     //   954: getfield slowSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   957: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   960: checkcast java/lang/Number
/*     */     //   963: invokevirtual doubleValue : ()D
/*     */     //   966: dmul
/*     */     //   967: invokeinterface setMotionZ : (D)V
/*     */     //   972: aload_0
/*     */     //   973: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   976: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   979: checkcast java/lang/String
/*     */     //   982: ldc_w 'Off'
/*     */     //   985: iconst_1
/*     */     //   986: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   989: ifne -> 1451
/*     */     //   992: aload_0
/*     */     //   993: getfield shouldGoDown : Z
/*     */     //   996: ifne -> 1451
/*     */     //   999: ldc2_w 0.5
/*     */     //   1002: dstore_3
/*     */     //   1003: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*     */     //   1006: dup
/*     */     //   1007: aload_2
/*     */     //   1008: invokeinterface getPosX : ()D
/*     */     //   1013: aload_2
/*     */     //   1014: invokeinterface getPosY : ()D
/*     */     //   1019: dconst_1
/*     */     //   1020: dsub
/*     */     //   1021: aload_2
/*     */     //   1022: invokeinterface getPosZ : ()D
/*     */     //   1027: invokespecial <init> : (DDD)V
/*     */     //   1030: astore #5
/*     */     //   1032: aload_0
/*     */     //   1033: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1036: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1039: checkcast java/lang/Number
/*     */     //   1042: invokevirtual floatValue : ()F
/*     */     //   1045: iconst_0
/*     */     //   1046: i2f
/*     */     //   1047: fcmpl
/*     */     //   1048: ifle -> 1241
/*     */     //   1051: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1054: astore #8
/*     */     //   1056: aload #8
/*     */     //   1058: arraylength
/*     */     //   1059: istore #9
/*     */     //   1061: iconst_0
/*     */     //   1062: istore #7
/*     */     //   1064: iload #7
/*     */     //   1066: iload #9
/*     */     //   1068: if_icmpge -> 1241
/*     */     //   1071: aload #8
/*     */     //   1073: iload #7
/*     */     //   1075: aaload
/*     */     //   1076: astore #6
/*     */     //   1078: aload #6
/*     */     //   1080: getstatic net/minecraft/util/EnumFacing.UP : Lnet/minecraft/util/EnumFacing;
/*     */     //   1083: if_acmpeq -> 1094
/*     */     //   1086: aload #6
/*     */     //   1088: getstatic net/minecraft/util/EnumFacing.DOWN : Lnet/minecraft/util/EnumFacing;
/*     */     //   1091: if_acmpne -> 1097
/*     */     //   1094: goto -> 1235
/*     */     //   1097: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1100: aload #6
/*     */     //   1102: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1107: astore #10
/*     */     //   1109: aload #5
/*     */     //   1111: aload #10
/*     */     //   1113: iconst_0
/*     */     //   1114: iconst_2
/*     */     //   1115: aconst_null
/*     */     //   1116: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1119: astore #11
/*     */     //   1121: iconst_0
/*     */     //   1122: istore #12
/*     */     //   1124: aload #11
/*     */     //   1126: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1129: dup
/*     */     //   1130: ifnull -> 1141
/*     */     //   1133: invokeinterface isReplaceable : ()Z
/*     */     //   1138: goto -> 1143
/*     */     //   1141: pop
/*     */     //   1142: iconst_0
/*     */     //   1143: ifeq -> 1235
/*     */     //   1146: aload #6
/*     */     //   1148: getstatic net/minecraft/util/EnumFacing.NORTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   1151: if_acmpeq -> 1162
/*     */     //   1154: aload #6
/*     */     //   1156: getstatic net/minecraft/util/EnumFacing.SOUTH : Lnet/minecraft/util/EnumFacing;
/*     */     //   1159: if_acmpne -> 1192
/*     */     //   1162: aload #11
/*     */     //   1164: invokevirtual getZ : ()I
/*     */     //   1167: i2d
/*     */     //   1168: ldc2_w 0.5
/*     */     //   1171: dadd
/*     */     //   1172: aload_2
/*     */     //   1173: invokeinterface getPosZ : ()D
/*     */     //   1178: dsub
/*     */     //   1179: dstore #14
/*     */     //   1181: iconst_0
/*     */     //   1182: istore #16
/*     */     //   1184: dload #14
/*     */     //   1186: invokestatic abs : (D)D
/*     */     //   1189: goto -> 1219
/*     */     //   1192: aload #11
/*     */     //   1194: invokevirtual getX : ()I
/*     */     //   1197: i2d
/*     */     //   1198: ldc2_w 0.5
/*     */     //   1201: dadd
/*     */     //   1202: aload_2
/*     */     //   1203: invokeinterface getPosX : ()D
/*     */     //   1208: dsub
/*     */     //   1209: dstore #14
/*     */     //   1211: iconst_0
/*     */     //   1212: istore #16
/*     */     //   1214: dload #14
/*     */     //   1216: invokestatic abs : (D)D
/*     */     //   1219: ldc2_w 0.5
/*     */     //   1222: dsub
/*     */     //   1223: dstore #12
/*     */     //   1225: dload #12
/*     */     //   1227: dload_3
/*     */     //   1228: dcmpg
/*     */     //   1229: ifge -> 1235
/*     */     //   1232: dload #12
/*     */     //   1234: dstore_3
/*     */     //   1235: iinc #7, 1
/*     */     //   1238: goto -> 1064
/*     */     //   1241: aload_0
/*     */     //   1242: getfield placedBlocksWithoutEagle : I
/*     */     //   1245: aload_0
/*     */     //   1246: getfield blocksToEagleValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1249: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1252: checkcast java/lang/Number
/*     */     //   1255: invokevirtual intValue : ()I
/*     */     //   1258: if_icmplt -> 1438
/*     */     //   1261: iconst_0
/*     */     //   1262: istore #7
/*     */     //   1264: aload #5
/*     */     //   1266: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*     */     //   1269: dup
/*     */     //   1270: ifnull -> 1281
/*     */     //   1273: invokeinterface isReplaceable : ()Z
/*     */     //   1278: goto -> 1283
/*     */     //   1281: pop
/*     */     //   1282: iconst_0
/*     */     //   1283: ifne -> 1323
/*     */     //   1286: aload_0
/*     */     //   1287: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1290: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1293: checkcast java/lang/Number
/*     */     //   1296: invokevirtual floatValue : ()F
/*     */     //   1299: iconst_0
/*     */     //   1300: i2f
/*     */     //   1301: fcmpl
/*     */     //   1302: ifle -> 1327
/*     */     //   1305: dload_3
/*     */     //   1306: aload_0
/*     */     //   1307: getfield edgeDistanceValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1310: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1313: checkcast java/lang/Number
/*     */     //   1316: invokevirtual doubleValue : ()D
/*     */     //   1319: dcmpg
/*     */     //   1320: ifge -> 1327
/*     */     //   1323: iconst_1
/*     */     //   1324: goto -> 1328
/*     */     //   1327: iconst_0
/*     */     //   1328: istore #6
/*     */     //   1330: aload_0
/*     */     //   1331: getfield eagleValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1334: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1337: checkcast java/lang/String
/*     */     //   1340: ldc_w 'Silent'
/*     */     //   1343: iconst_1
/*     */     //   1344: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1347: ifeq -> 1410
/*     */     //   1350: aload_0
/*     */     //   1351: getfield eagleSneaking : Z
/*     */     //   1354: iload #6
/*     */     //   1356: if_icmpeq -> 1401
/*     */     //   1359: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1362: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1367: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1370: aload_2
/*     */     //   1371: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   1374: iload #6
/*     */     //   1376: ifeq -> 1385
/*     */     //   1379: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.START_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1382: goto -> 1388
/*     */     //   1385: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.STOP_SNEAKING : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   1388: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   1393: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   1396: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   1401: aload_0
/*     */     //   1402: iload #6
/*     */     //   1404: putfield eagleSneaking : Z
/*     */     //   1407: goto -> 1430
/*     */     //   1410: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1413: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1418: invokeinterface getKeyBindSneak : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1423: iload #6
/*     */     //   1425: invokeinterface setPressed : (Z)V
/*     */     //   1430: aload_0
/*     */     //   1431: iconst_0
/*     */     //   1432: putfield placedBlocksWithoutEagle : I
/*     */     //   1435: goto -> 1451
/*     */     //   1438: aload_0
/*     */     //   1439: dup
/*     */     //   1440: getfield placedBlocksWithoutEagle : I
/*     */     //   1443: dup
/*     */     //   1444: istore #6
/*     */     //   1446: iconst_1
/*     */     //   1447: iadd
/*     */     //   1448: putfield placedBlocksWithoutEagle : I
/*     */     //   1451: aload_2
/*     */     //   1452: invokeinterface getOnGround : ()Z
/*     */     //   1457: ifeq -> 2016
/*     */     //   1460: aload_0
/*     */     //   1461: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1464: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1467: checkcast java/lang/String
/*     */     //   1470: astore_3
/*     */     //   1471: iconst_0
/*     */     //   1472: istore #4
/*     */     //   1474: aload_3
/*     */     //   1475: dup
/*     */     //   1476: ifnonnull -> 1490
/*     */     //   1479: new kotlin/TypeCastException
/*     */     //   1482: dup
/*     */     //   1483: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1486: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1489: athrow
/*     */     //   1490: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1493: dup
/*     */     //   1494: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1497: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1500: astore_3
/*     */     //   1501: aload_3
/*     */     //   1502: invokevirtual hashCode : ()I
/*     */     //   1505: tableswitch default -> 1547, 1388740000 -> 1524
/*     */     //   1524: aload_3
/*     */     //   1525: ldc_w 'rewinside'
/*     */     //   1528: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1531: ifeq -> 1547
/*     */     //   1534: ldc_w 0.2
/*     */     //   1537: invokestatic strafe : (F)V
/*     */     //   1540: aload_2
/*     */     //   1541: dconst_0
/*     */     //   1542: invokeinterface setMotionY : (D)V
/*     */     //   1547: aload_0
/*     */     //   1548: getfield zitterMode : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   1551: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1554: checkcast java/lang/String
/*     */     //   1557: astore_3
/*     */     //   1558: iconst_0
/*     */     //   1559: istore #4
/*     */     //   1561: aload_3
/*     */     //   1562: dup
/*     */     //   1563: ifnonnull -> 1577
/*     */     //   1566: new kotlin/TypeCastException
/*     */     //   1569: dup
/*     */     //   1570: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   1573: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   1576: athrow
/*     */     //   1577: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   1580: dup
/*     */     //   1581: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   1584: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1587: astore_3
/*     */     //   1588: aload_3
/*     */     //   1589: invokevirtual hashCode : ()I
/*     */     //   1592: lookupswitch default -> 2016, -1360201941 -> 1628, -898533970 -> 1654, 109935 -> 1641
/*     */     //   1628: aload_3
/*     */     //   1629: ldc_w 'teleport'
/*     */     //   1632: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1635: ifeq -> 2016
/*     */     //   1638: goto -> 1861
/*     */     //   1641: aload_3
/*     */     //   1642: ldc_w 'off'
/*     */     //   1645: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1648: ifeq -> 2016
/*     */     //   1651: goto -> 1667
/*     */     //   1654: aload_3
/*     */     //   1655: ldc_w 'smooth'
/*     */     //   1658: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   1661: ifeq -> 2016
/*     */     //   1664: goto -> 1668
/*     */     //   1667: return
/*     */     //   1668: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1671: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1674: getfield field_74366_z : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1677: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1680: ifne -> 1702
/*     */     //   1683: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1686: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1691: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1696: iconst_0
/*     */     //   1697: invokeinterface setPressed : (Z)V
/*     */     //   1702: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   1705: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   1708: getfield field_74370_x : Lnet/minecraft/client/settings/KeyBinding;
/*     */     //   1711: invokestatic func_100015_a : (Lnet/minecraft/client/settings/KeyBinding;)Z
/*     */     //   1714: ifne -> 1736
/*     */     //   1717: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1720: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1725: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1730: iconst_0
/*     */     //   1731: invokeinterface setPressed : (Z)V
/*     */     //   1736: aload_0
/*     */     //   1737: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1740: ldc2_w 100
/*     */     //   1743: invokevirtual hasTimePassed : (J)Z
/*     */     //   1746: ifeq -> 1772
/*     */     //   1749: aload_0
/*     */     //   1750: aload_0
/*     */     //   1751: getfield zitterDirection : Z
/*     */     //   1754: ifne -> 1761
/*     */     //   1757: iconst_1
/*     */     //   1758: goto -> 1762
/*     */     //   1761: iconst_0
/*     */     //   1762: putfield zitterDirection : Z
/*     */     //   1765: aload_0
/*     */     //   1766: getfield zitterTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1769: invokevirtual reset : ()V
/*     */     //   1772: aload_0
/*     */     //   1773: getfield zitterDirection : Z
/*     */     //   1776: ifeq -> 1820
/*     */     //   1779: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1782: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1787: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1792: iconst_1
/*     */     //   1793: invokeinterface setPressed : (Z)V
/*     */     //   1798: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1801: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1806: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1811: iconst_0
/*     */     //   1812: invokeinterface setPressed : (Z)V
/*     */     //   1817: goto -> 2016
/*     */     //   1820: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1823: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1828: invokeinterface getKeyBindRight : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1833: iconst_0
/*     */     //   1834: invokeinterface setPressed : (Z)V
/*     */     //   1839: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1842: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   1847: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   1852: iconst_1
/*     */     //   1853: invokeinterface setPressed : (Z)V
/*     */     //   1858: goto -> 2016
/*     */     //   1861: aload_0
/*     */     //   1862: getfield zitterSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1865: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1868: checkcast java/lang/Number
/*     */     //   1871: invokevirtual floatValue : ()F
/*     */     //   1874: invokestatic strafe : (F)V
/*     */     //   1877: aload_2
/*     */     //   1878: invokeinterface getRotationYaw : ()F
/*     */     //   1883: f2d
/*     */     //   1884: aload_0
/*     */     //   1885: getfield zitterDirection : Z
/*     */     //   1888: ifeq -> 1897
/*     */     //   1891: ldc2_w 90.0
/*     */     //   1894: goto -> 1900
/*     */     //   1897: ldc2_w -90.0
/*     */     //   1900: dadd
/*     */     //   1901: invokestatic toRadians : (D)D
/*     */     //   1904: dstore #4
/*     */     //   1906: aload_2
/*     */     //   1907: aload_2
/*     */     //   1908: invokeinterface getMotionX : ()D
/*     */     //   1913: dstore #18
/*     */     //   1915: astore #17
/*     */     //   1917: iconst_0
/*     */     //   1918: istore #6
/*     */     //   1920: dload #4
/*     */     //   1922: invokestatic sin : (D)D
/*     */     //   1925: dstore #20
/*     */     //   1927: aload #17
/*     */     //   1929: dload #18
/*     */     //   1931: dload #20
/*     */     //   1933: aload_0
/*     */     //   1934: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1937: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1940: checkcast java/lang/Number
/*     */     //   1943: invokevirtual doubleValue : ()D
/*     */     //   1946: dmul
/*     */     //   1947: dsub
/*     */     //   1948: invokeinterface setMotionX : (D)V
/*     */     //   1953: aload_2
/*     */     //   1954: aload_2
/*     */     //   1955: invokeinterface getMotionZ : ()D
/*     */     //   1960: dstore #18
/*     */     //   1962: astore #17
/*     */     //   1964: iconst_0
/*     */     //   1965: istore #6
/*     */     //   1967: dload #4
/*     */     //   1969: invokestatic cos : (D)D
/*     */     //   1972: dstore #20
/*     */     //   1974: aload #17
/*     */     //   1976: dload #18
/*     */     //   1978: dload #20
/*     */     //   1980: aload_0
/*     */     //   1981: getfield zitterStrength : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1984: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1987: checkcast java/lang/Number
/*     */     //   1990: invokevirtual doubleValue : ()D
/*     */     //   1993: dmul
/*     */     //   1994: dadd
/*     */     //   1995: invokeinterface setMotionZ : (D)V
/*     */     //   2000: aload_0
/*     */     //   2001: aload_0
/*     */     //   2002: getfield zitterDirection : Z
/*     */     //   2005: ifne -> 2012
/*     */     //   2008: iconst_1
/*     */     //   2009: goto -> 2013
/*     */     //   2012: iconst_0
/*     */     //   2013: putfield zitterDirection : Z
/*     */     //   2016: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #221	-> 0
/*     */     //   #222	-> 16
/*     */     //   #223	-> 45
/*     */     //   #225	-> 64
/*     */     //   #226	-> 93
/*     */     //   #228	-> 112
/*     */     //   #229	-> 133
/*     */     //   #231	-> 154
/*     */     //   #232	-> 175
/*     */     //   #235	-> 196
/*     */     //   #235	-> 211
/*     */     //   #236	-> 214
/*     */     //   #237	-> 223
/*     */     //   #239	-> 238
/*     */     //   #240	-> 278
/*     */     //   #241	-> 283
/*     */     //   #242	-> 290
/*     */     //   #243	-> 295
/*     */     //   #244	-> 300
/*     */     //   #245	-> 305
/*     */     //   #246	-> 310
/*     */     //   #247	-> 315
/*     */     //   #248	-> 328
/*     */     //   #249	-> 343
/*     */     //   #251	-> 348
/*     */     //   #253	-> 353
/*     */     //   #254	-> 353
/*     */     //   #255	-> 382
/*     */     //   #256	-> 411
/*     */     //   #257	-> 437
/*     */     //   #258	-> 562
/*     */     //   #259	-> 687
/*     */     //   #260	-> 687
/*     */     //   #261	-> 687
/*     */     //   #259	-> 687
/*     */     //   #260	-> 717
/*     */     //   #261	-> 760
/*     */     //   #263	-> 793
/*     */     //   #265	-> 814
/*     */     //   #266	-> 814
/*     */     //   #267	-> 878
/*     */     //   #268	-> 885
/*     */     //   #270	-> 904
/*     */     //   #271	-> 920
/*     */     //   #272	-> 946
/*     */     //   #275	-> 972
/*     */     //   #276	-> 999
/*     */     //   #277	-> 1003
/*     */     //   #278	-> 1032
/*     */     //   #279	-> 1051
/*     */     //   #280	-> 1078
/*     */     //   #281	-> 1094
/*     */     //   #283	-> 1097
/*     */     //   #284	-> 1109
/*     */     //   #285	-> 1121
/*     */     //   #867	-> 1124
/*     */     //   #867	-> 1141
/*     */     //   #286	-> 1146
/*     */     //   #287	-> 1162
/*     */     //   #289	-> 1192
/*     */     //   #286	-> 1219
/*     */     //   #290	-> 1219
/*     */     //   #286	-> 1223
/*     */     //   #292	-> 1225
/*     */     //   #293	-> 1232
/*     */     //   #279	-> 1235
/*     */     //   #298	-> 1241
/*     */     //   #299	-> 1261
/*     */     //   #300	-> 1261
/*     */     //   #868	-> 1264
/*     */     //   #868	-> 1281
/*     */     //   #300	-> 1286
/*     */     //   #299	-> 1328
/*     */     //   #301	-> 1330
/*     */     //   #302	-> 1350
/*     */     //   #303	-> 1359
/*     */     //   #304	-> 1367
/*     */     //   #305	-> 1370
/*     */     //   #306	-> 1379
/*     */     //   #308	-> 1385
/*     */     //   #305	-> 1388
/*     */     //   #304	-> 1388
/*     */     //   #303	-> 1396
/*     */     //   #313	-> 1401
/*     */     //   #315	-> 1410
/*     */     //   #316	-> 1430
/*     */     //   #317	-> 1430
/*     */     //   #319	-> 1438
/*     */     //   #320	-> 1451
/*     */     //   #322	-> 1451
/*     */     //   #323	-> 1460
/*     */     //   #324	-> 1524
/*     */     //   #325	-> 1534
/*     */     //   #326	-> 1540
/*     */     //   #328	-> 1547
/*     */     //   #329	-> 1547
/*     */     //   #352	-> 1628
/*     */     //   #330	-> 1641
/*     */     //   #333	-> 1654
/*     */     //   #331	-> 1667
/*     */     //   #334	-> 1668
/*     */     //   #335	-> 1683
/*     */     //   #337	-> 1702
/*     */     //   #338	-> 1717
/*     */     //   #340	-> 1736
/*     */     //   #341	-> 1749
/*     */     //   #342	-> 1765
/*     */     //   #344	-> 1772
/*     */     //   #345	-> 1779
/*     */     //   #346	-> 1798
/*     */     //   #348	-> 1820
/*     */     //   #349	-> 1839
/*     */     //   #350	-> 1858
/*     */     //   #353	-> 1861
/*     */     //   #354	-> 1877
/*     */     //   #355	-> 1906
/*     */     //   #355	-> 1933
/*     */     //   #356	-> 1953
/*     */     //   #356	-> 1980
/*     */     //   #357	-> 2000
/*     */     //   #359	-> 2016
/*     */     //   #361	-> 2016
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   1124	19	12	$i$f$isReplaceable	I
/*     */     //   1225	10	12	calcDif	D
/*     */     //   1121	114	11	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1109	126	10	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   1078	160	6	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*     */     //   1264	19	7	$i$f$isReplaceable	I
/*     */     //   1330	105	6	shouldEagle	Z
/*     */     //   1032	419	5	blockPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   1003	448	3	dif	D
/*     */     //   1906	110	4	yaw	D
/*     */     //   214	1803	2	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	2017	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2;
/*     */     //   0	2017	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 365 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof net.minecraft.network.play.server.SPacketDisconnect) {
/* 366 */       setState(false);
/*     */     }
/* 368 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 372 */     IPacket packet = event.getPacket();
/* 373 */     if (packet instanceof CPacketHeldItemChange) {
/* 374 */       this.slot = ((CPacketHeldItemChange)packet).func_149614_c();
/*     */     }
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event)
/*     */   {
/* 381 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       return;
/*     */     }
/* 384 */     if (!this.canRot)
/* 385 */       return;  update();
/* 386 */     if (this.lockRotation != null) { Rotation rotation = this.lockRotation;
/*     */       
/* 388 */       if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue()))) {
/* 389 */         if (this.targetPlace == null) {
/* 390 */           rotation.setYaw(WMathHelper.wrapAngleTo180_float(MathKt.roundToInt(rotation.getYaw() / 45.0F) * 45.0F));
/*     */         }
/* 392 */         setRotation(rotation);
/* 393 */         this.lockRotationTimer.update();
/*     */         
/* 395 */         rotation.applyStrafeToPlayer(event);
/* 396 */         event.cancelEvent();
/*     */         
/*     */         return;
/*     */       } 
/* 400 */       if (RotationUtils.targetRotation != null) { Rotation targetRotation = RotationUtils.targetRotation;
/* 401 */         targetRotation.applyStrafeToPlayer(event);
/* 402 */         event.cancelEvent();
/*     */         return; }
/*     */       
/*     */       return; }
/*     */      } @EventTarget
/* 407 */   public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); EventState eventState = event.getEventState();
/* 408 */     if (!this.canRot)
/*     */       return; 
/* 410 */     if (((Boolean)this.rotationsValue.get()).booleanValue() && (((Boolean)this.keepRotationValue.get()).booleanValue() || !this.lockRotationTimer.hasTimePassed(((Number)this.keepLengthValue.get()).intValue())) && this.lockRotation != null && 
/* 411 */       StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/*     */       
/* 413 */       if (this.lockRotation == null) Intrinsics.throwNpe();  setRotation(this.lockRotation);
/* 414 */       if (eventState == EventState.POST) {
/* 415 */         this.lockRotationTimer.update();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 420 */     if ((this.facesBlock || !((Boolean)this.rotationsValue.get()).booleanValue()) && StringsKt.equals((String)this.placeModeValue.get(), eventState.getStateName(), true)) {
/* 421 */       if (!this.canPlace)
/* 422 */         return;  place();
/*     */     } 
/* 424 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((MinecraftInstance.mc.getThePlayer().getFallDistance() > false && ((Boolean)this.FallFastplace.get()).booleanValue()) || (this.canPlace && ((Boolean)this.Fastplace.get()).booleanValue())) {
/* 425 */       place();
/*     */     }
/*     */     
/* 428 */     if (eventState == EventState.PRE && StringsKt.equals((String)this.strafeMode.get(), "Off", true)) {
/* 429 */       update();
/*     */     }
/*     */ 
/*     */     
/* 433 */     if (this.targetPlace == null && ((Boolean)this.placeDelay.get()).booleanValue()) {
/* 434 */       this.delayTimer.reset();
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
/*     */     //   #439	-> 0
/*     */     //   #440	-> 8
/*     */     //   #440	-> 23
/*     */     //   #442	-> 26
/*     */     //   #443	-> 65
/*     */     //   #444	-> 65
/*     */     //   #443	-> 65
/*     */     //   #444	-> 75
/*     */     //   #445	-> 85
/*     */     //   #443	-> 113
/*     */     //   #447	-> 116
/*     */     //   #450	-> 117
/*     */     //   #451	-> 138
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   65	74	2	holdingItem	Z
/*     */     //   26	113	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	139	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void setRotation(Rotation rotation) {
/* 454 */     if (!this.canRot)
/* 455 */       return;  if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 457 */       if (((Boolean)this.silentRotationValue.get()).booleanValue())
/* 458 */       { RotationUtils.setTargetRotation(rotation, 0); }
/*     */       else
/* 460 */       { player.setRotationYaw(rotation.getYaw());
/* 461 */         player.setRotationPitch(rotation.getPitch()); }  return; }  MinecraftInstance.mc.getThePlayer();
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
/*     */     //   984: aconst_null
/*     */     //   985: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*     */     //   988: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*     */     //   991: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #507	-> 0
/*     */     //   #507	-> 15
/*     */     //   #508	-> 18
/*     */     //   #508	-> 33
/*     */     //   #509	-> 36
/*     */     //   #510	-> 44
/*     */     //   #511	-> 51
/*     */     //   #512	-> 67
/*     */     //   #514	-> 74
/*     */     //   #517	-> 75
/*     */     //   #518	-> 132
/*     */     //   #521	-> 133
/*     */     //   #522	-> 140
/*     */     //   #523	-> 217
/*     */     //   #525	-> 222
/*     */     //   #526	-> 228
/*     */     //   #529	-> 229
/*     */     //   #539	-> 328
/*     */     //   #533	-> 342
/*     */     //   #530	-> 356
/*     */     //   #544	-> 370
/*     */     //   #549	-> 384
/*     */     //   #531	-> 398
/*     */     //   #534	-> 399
/*     */     //   #535	-> 411
/*     */     //   #536	-> 427
/*     */     //   #540	-> 443
/*     */     //   #541	-> 455
/*     */     //   #545	-> 487
/*     */     //   #546	-> 499
/*     */     //   #550	-> 531
/*     */     //   #551	-> 543
/*     */     //   #552	-> 573
/*     */     //   #553	-> 586
/*     */     //   #556	-> 615
/*     */     //   #557	-> 615
/*     */     //   #560	-> 634
/*     */     //   #561	-> 642
/*     */     //   #560	-> 687
/*     */     //   #564	-> 695
/*     */     //   #565	-> 702
/*     */     //   #566	-> 719
/*     */     //   #568	-> 723
/*     */     //   #569	-> 749
/*     */     //   #571	-> 766
/*     */     //   #568	-> 795
/*     */     //   #565	-> 795
/*     */     //   #576	-> 798
/*     */     //   #577	-> 807
/*     */     //   #578	-> 822
/*     */     //   #579	-> 838
/*     */     //   #582	-> 854
/*     */     //   #583	-> 870
/*     */     //   #585	-> 879
/*     */     //   #586	-> 903
/*     */     //   #588	-> 903
/*     */     //   #589	-> 923
/*     */     //   #590	-> 941
/*     */     //   #591	-> 970
/*     */     //   #594	-> 983
/*     */     //   #595	-> 991
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   222	412	4	blockSlot	I
/*     */     //   822	32	4	modifier	F
/*     */     //   140	852	3	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   36	956	2	world	Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   18	974	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	992	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldNew2; } public void onDisable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74311_E)) { MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); if (this.eagleSneaking)
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)player, ICPacketEntityAction.WAction.STOP_SNEAKING));  }  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74366_z))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);  if (!GameSettings.func_100015_a(MinecraftInstance.mc2.field_71474_y.field_74370_x))
/*     */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);  this.lockRotation = (Rotation)null; this.facesBlock = false; MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F); this.shouldGoDown = false; if (this.slot != player.getInventory().getCurrentItem())
/* 467 */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(player.getInventory().getCurrentItem()));  return; }  MinecraftInstance.mc.getThePlayer(); } private final void findBlock(boolean expand) { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/* 468 */       if (!this.canRot)
/* 469 */         return;  WBlockPos blockPosition = this.shouldGoDown ? (
/* 470 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 471 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ()) : (
/*     */         
/* 473 */         new WBlockPos(player.getPosX(), player.getPosY() - 0.6D, player.getPosZ())).down()) : (
/*     */         
/* 475 */         (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? 
/* 476 */         new WBlockPos(player.getPosX(), this.launchY - 1.0D, player.getPosZ()) : (
/* 477 */         (player.getPosY() == MathKt.roundToInt(player.getPosY()) + 0.5D) ? 
/* 478 */         new WBlockPos((IEntity)player) : (
/*     */         
/* 480 */         new WBlockPos(player.getPosX(), player.getPosY(), player.getPosZ())).down()));
/*     */       
/* 482 */       if (!expand) { int $i$f$isReplaceable = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 869 */         BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0) || search(blockPosition, !this.shouldGoDown)) return;  }  if (expand) { double yaw = Math.toRadians(player.getRotationYaw() + '´'); boolean bool = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); byte b = 0; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); int i; for (b = 0, i = ((Number)this.expandLengthValue.get()).intValue(); b < i; b++) { if (search(blockPosition.add(x * b, 0, z * b), false)) return;  }  } else if (((Boolean)this.searchValue.get()).booleanValue()) { byte b; byte b1; for (b = -1, b1 = 1; b <= b1; b++) { byte b2; byte b3; for (b2 = -1, b3 = 1; b2 <= b3; b2++) { if (search(blockPosition.add(b, 0, b2), !this.shouldGoDown)) return;  }  }  }  return; }  MinecraftInstance.mc.getThePlayer(); }
/* 870 */   @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown) return;  if (((Boolean)this.airSafeValue.get()).booleanValue() || player.getOnGround()) event.setSafeWalk(true);  return; }  MinecraftInstance.mc.getThePlayer(); } @EventTarget public final void onRender2D(@NotNull Render2DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.counterDisplayValue.get()).booleanValue()) { GL11.glPushMatrix(); if (Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.BlockOverlay");  BlockOverlay blockOverlay = (BlockOverlay)Retreat.INSTANCE.getModuleManager().getModule(BlockOverlay.class); if (blockOverlay.getState() && ((Boolean)blockOverlay.getInfoValue().get()).booleanValue() && blockOverlay.getCurrentBlock() != null) GL11.glTranslatef(0.0F, 15.0F, 0.0F);  String info = "Blocks: §7" + getBlocksAmount(); ScaledResolution scaledResolution = new ScaledResolution(MinecraftInstance.mc2); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawBorderedRect((scaledResolution.func_78326_a() / 2) - 2, (scaledResolution.func_78328_b() / 2) + 5, (scaledResolution.func_78326_a() / 2 + Fonts.font40.getStringWidth(info)) + 2, (scaledResolution.func_78328_b() / 2) + 16, 3.0F, Color.BLACK.getRGB(), Color.BLACK.getRGB()); GlStateManager.func_179117_G(); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.font40.drawString(info, scaledResolution.func_78326_a() / 2, (scaledResolution.func_78328_b() / 2) + 7, Color.WHITE.getRGB()); GL11.glPopMatrix(); }  } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (!((Boolean)this.markValue.get()).booleanValue()) return;  for (byte b1 = 0, b2 = StringsKt.equals((String)this.modeValue.get(), "Expand", true) ? (((Number)this.expandLengthValue.get()).intValue() + 1) : 2; b1 < b2; b1++) { double yaw = Math.toRadians(player.getRotationYaw()); boolean bool1 = false; int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? -MathKt.roundToInt(Math.sin(yaw)) : player.getHorizontalFacing().getDirectionVec().getX(); boolean bool2 = false; int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? MathKt.roundToInt(Math.cos(yaw)) : player.getHorizontalFacing().getDirectionVec().getZ(); WBlockPos blockPos = new WBlockPos(player.getPosX() + (x * b1), (((Boolean)this.sameYValue.get()).booleanValue() && this.launchY <= player.getPosY()) ? (this.launchY - 1.0D) : (player.getPosY() - ((player.getPosY() == player.getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0D : 0.0D)), player.getPosZ() + (z * b1)); PlaceInfo placeInfo = PlaceInfo.Companion.get(blockPos); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) { RenderUtils.drawBlockBox(blockPos, new Color(68, 117, 255, 100), false); break; }  }  return; }
/* 871 */      MinecraftInstance.mc.getThePlayer(); } private final boolean search(WBlockPos blockPosition, boolean raycast) { this.facesBlock = false; if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient world = MinecraftInstance.mc.getTheWorld(); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPosition); if (!((BlockUtils.getMaterial(blockPosition) != null) ? BlockUtils.getMaterial(blockPosition).isReplaceable() : 0))
/* 872 */           return false;  double xzRV = ((Number)this.xzRangeValue.get()).floatValue(); double xzSSV = calcStepSize((float)xzRV); double yRV = ((Number)this.yRangeValue.get()).floatValue(); double ySSV = calcStepSize((float)yRV); WVec3 eyesPos = new WVec3(player.getPosX(), player.getEntityBoundingBox().getMinY() + player.getEyeHeight(), player.getPosZ()); PlaceRotation placeRotation = (PlaceRotation)null; for (EnumFacingType facingType : EnumFacingType.values()) { IEnumFacing side = MinecraftInstance.classProvider.getEnumFacing(facingType); WBlockPos neighbor = WBlockPos.offset$default(blockPosition, side, 0, 2, null); if (BlockUtils.canBeClicked(neighbor)) { WVec3 dirVec = new WVec3(side.getDirectionVec()); boolean auto = StringsKt.equals((String)this.searchMode.get(), "Auto", true); boolean center = StringsKt.equals((String)this.searchMode.get(), "AutoCenter", true); double xSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (xSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { double ySearch = auto ? 0.1D : (0.5D - yRV / 2); while (ySearch <= (auto ? 0.9D : (0.5D + yRV / 2))) { double zSearch = auto ? 0.1D : (0.5D - xzRV / 2); while (zSearch <= (auto ? 0.9D : (0.5D + xzRV / 2))) { WVec3 wVec3 = new WVec3((WVec3i)blockPosition); double d1 = center ? 0.5D : xSearch, d2 = center ? 0.5D : ySearch, z$iv = center ? 0.5D : zSearch; continue; $i$f$addVector = 0; posVec = new WVec3(SYNTHETIC_LOCAL_VARIABLE_31.getXCoord() + SYNTHETIC_LOCAL_VARIABLE_32, SYNTHETIC_LOCAL_VARIABLE_31.getYCoord() + SYNTHETIC_LOCAL_VARIABLE_34, SYNTHETIC_LOCAL_VARIABLE_31.getZCoord() + SYNTHETIC_LOCAL_VARIABLE_36); this_$iv = eyesPos; $i$f$squareDistanceTo = 0;
/* 873 */                   d0$iv = posVec.getXCoord() - this_$iv.getXCoord();
/* 874 */                   d1$iv = posVec.getYCoord() - this_$iv.getYCoord();
/* 875 */                   d2$iv = posVec.getZCoord() - this_$iv.getZCoord();
/*     */                   
/* 877 */                   distanceSqPosVec = d0$iv * d0$iv + d1$iv * d1$iv + d2$iv * d2$iv; wVec31 = posVec; vec$iv = new WVec3(dirVec.getXCoord() * 0.5D, dirVec.getYCoord() * 0.5D, dirVec.getZCoord() * 0.5D); $i$f$add = 0;
/* 878 */                   wVec32 = wVec31; d1 = vec$iv.getXCoord(); d2 = vec$iv.getYCoord(); z$iv$iv = vec$iv.getZCoord(); i = 0;
/* 879 */                   hitVec = new WVec3(wVec32.getXCoord() + d1, wVec32.getYCoord() + d2, wVec32.getZCoord() + z$iv$iv); }
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ScaffoldNew2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */