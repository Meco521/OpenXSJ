/*      */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import kotlin.Metadata;
/*      */ import kotlin.TypeCastException;
/*      */ import kotlin.Unit;
/*      */ import kotlin.jvm.functions.Function0;
/*      */ import kotlin.jvm.internal.Intrinsics;
/*      */ import kotlin.jvm.internal.Lambda;
/*      */ import kotlin.text.StringsKt;
/*      */ import net.ccbluex.liquidbounce.Retreat;
/*      */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*      */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*      */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketHeldItemChange;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.event.EventState;
/*      */ import net.ccbluex.liquidbounce.event.EventTarget;
/*      */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*      */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*      */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*      */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*      */ import net.ccbluex.liquidbounce.features.module.Module;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*      */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType;
/*      */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*      */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*      */ import net.ccbluex.liquidbounce.utils.block.PlaceInfo;
/*      */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import net.ccbluex.liquidbounce.value.Value;
/*      */ import net.minecraft.client.renderer.GlStateManager;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ @ModuleInfo(name = "Scaffold", description = "Auto Place Block", category = ModuleCategory.WORLD)
/*      */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000º\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\007\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\036\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\n\n\002\020\006\n\002\b\b\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\b\027\030\0002\0020\001B\005¢\006\002\020\002J\020\020[\032\0020\\2\006\020]\032\0020\\H\002J\020\020^\032\0020\n2\006\020_\032\0020\036H\002J\b\020`\032\0020\036H\002J \020a\032\0020\n2\006\020b\032\0020M2\006\020c\032\0020M2\006\020d\032\0020eH\002J\b\020f\032\0020\nH\026J\b\020g\032\0020\nH\026J\020\020h\032\0020\n2\006\020i\032\0020jH\007J\020\020k\032\0020\n2\006\020i\032\0020lH\007J\020\020m\032\0020\n2\006\020i\032\0020nH\007J\022\020o\032\0020\n2\b\020i\032\004\030\0010pH\007J\022\020q\032\0020\n2\b\020i\032\004\030\0010rH\007J\020\020s\032\0020\n2\006\020i\032\0020tH\003J\022\020u\032\0020\n2\b\020i\032\004\030\0010vH\007J\b\020w\032\0020\nH\002J\030\020x\032\0020\0362\006\020y\032\0020\0162\006\020z\032\0020\036H\002J\020\020{\032\0020\n2\006\020|\032\0020(H\002J\030\020{\032\0020\n2\006\020|\032\0020(2\006\020}\032\0020\022H\002J\030\020~\032\0020\n2\006\020A\032\0020\0222\006\020\032\0020\022H\002J\t\020\001\032\0020\nH\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\024\020\t\032\0020\n8BX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0168BX\004¢\006\006\032\004\b\017\020\020R\024\020\021\032\0020\0228BX\004¢\006\006\032\004\b\023\020\024R\024\020\025\032\b\022\004\022\0020\0220\026X\004¢\006\002\n\000R\016\020\027\032\0020\004X\004¢\006\002\n\000R\016\020\030\032\0020\031X\016¢\006\002\n\000R\016\020\032\032\0020\033X\004¢\006\002\n\000R\016\020\034\032\0020\004X\004¢\006\002\n\000R\016\020\035\032\0020\036X\016¢\006\002\n\000R\016\020\037\032\0020\006X\004¢\006\002\n\000R\024\020 \032\b\022\004\022\0020!0\026X\004¢\006\002\n\000R\024\020\"\032\b\022\004\022\0020\0220\026X\004¢\006\002\n\000R\016\020#\032\0020\036X\016¢\006\002\n\000R\024\020$\032\b\022\004\022\0020\0220\026X\004¢\006\002\n\000R\016\020%\032\0020\004X\004¢\006\002\n\000R\016\020&\032\0020\022X\016¢\006\002\n\000R\020\020'\032\004\030\0010(X\016¢\006\002\n\000R\020\020)\032\004\030\0010(X\016¢\006\002\n\000R\016\020*\032\0020\004X\004¢\006\002\n\000R\016\020+\032\0020,X\004¢\006\002\n\000R\016\020-\032\0020.X\004¢\006\002\n\000R\016\020/\032\0020,X\004¢\006\002\n\000R\016\0200\032\0020.X\004¢\006\002\n\000R\021\0201\032\0020\006¢\006\b\n\000\032\004\b2\0203R\016\0204\032\0020\004X\004¢\006\002\n\000R\016\0205\032\0020\006X\004¢\006\002\n\000R\016\0206\032\0020\004X\004¢\006\002\n\000R\016\0207\032\0020\022X\016¢\006\002\n\000R\016\0208\032\0020!X\016¢\006\002\n\000R\016\0209\032\0020\006X\004¢\006\002\n\000R\016\020:\032\0020\004X\004¢\006\002\n\000R\016\020;\032\0020\004X\004¢\006\002\n\000R\016\020<\032\0020\004X\004¢\006\002\n\000R\016\020=\032\0020,X\004¢\006\002\n\000R\016\020>\032\0020\004X\004¢\006\002\n\000R\016\020?\032\0020\036X\016¢\006\002\n\000R\016\020@\032\0020\004X\004¢\006\002\n\000R\016\020A\032\0020\022X\016¢\006\002\n\000R\024\020B\032\b\022\004\022\0020!0\026X\004¢\006\002\n\000R\016\020C\032\0020\004X\004¢\006\002\n\000R\016\020D\032\0020\004X\004¢\006\002\n\000R\016\020E\032\0020.X\004¢\006\002\n\000R\021\020F\032\0020\004¢\006\b\n\000\032\004\bG\020HR\024\020I\032\b\022\004\022\0020!0\026X\004¢\006\002\n\000R\024\020J\032\b\022\004\022\0020!0\026X\004¢\006\002\n\000R\016\020K\032\0020\004X\004¢\006\002\n\000R\024\020L\032\0020M8VX\004¢\006\006\032\004\bN\020OR\020\020P\032\004\030\0010QX\016¢\006\002\n\000R\016\020R\032\0020.X\004¢\006\002\n\000R\016\020S\032\0020.X\004¢\006\002\n\000R\016\020T\032\0020.X\004¢\006\002\n\000R\016\020U\032\0020\036X\016¢\006\002\n\000R\024\020V\032\b\022\004\022\0020M0\026X\004¢\006\002\n\000R\024\020W\032\b\022\004\022\0020!0\026X\004¢\006\002\n\000R\024\020X\032\b\022\004\022\0020!0\026X\004¢\006\002\n\000R\016\020Y\032\0020\033X\004¢\006\002\n\000R\016\020Z\032\0020\004X\004¢\006\002\n\000¨\006\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "airSafeValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "autoBlockValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "autoJumpValue", "autoTimer", "bestBlocks", "", "getBestBlocks", "()Lkotlin/Unit;", "blockPosUnder", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getBlockPosUnder", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "blocksAmount", "", "getBlocksAmount", "()I", "blocksToEagleValue", "Lnet/ccbluex/liquidbounce/value/Value;", "counterDisplayValue", "delay", "", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "downValue", "eagleSneaking", "", "eagleValue", "edgeDistanceValue", "", "expandLengthValue", "facesBlock", "keepLengthValue", "keepRotationValue", "launchY", "limitedRotation", "Lnet/ccbluex/liquidbounce/utils/Rotation;", "lockRotation", "markValue", "maxDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "maxTurnSpeedValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "minDelayValue", "minTurnSpeedValue", "modeValue", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "noBlockDisablerValue", "placeModeValue", "placeableDelay", "placedBlocksWithoutEagle", "progress", "rotationModeValue", "rotationStrafeValue", "safeWalkValue", "sameYValue", "searchAccuracyValue", "searchValue", "shouldGoDown", "silentRotation", "slot", "slowSpeed", "slowValue", "smartSpeedValue", "speedModifierValue", "sprintValue", "getSprintValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "staticPitchValue", "staticYawOffsetValue", "swingValue", "tag", "", "getTag", "()Ljava/lang/String;", "targetPlace", "Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;", "timerValue", "xzRangeValue", "yRangeValue", "zitterDirection", "zitterModeValue", "zitterSpeed", "zitterStrength", "zitterTimer", "zitterValue", "calcStepSize", "", "range", "findBlock", "expand", "invCheck", "notificationsTransform", "name", "s", "error", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;", "onDisable", "onEnable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "place", "search", "blockPosition", "checks", "setRotation", "rotation", "keepRotation", "swap", "hotbarNum", "update", "XSJClient"})
/*      */ public class Scaffold extends Module {
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$maxDelayValue$2 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*   63 */       return ((Boolean)Scaffold.this.placeableDelay.get()).booleanValue();
/*      */     } Scaffold$maxDelayValue$2() {
/*      */       super(0);
/*      */     } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$minDelayValue$2 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*   69 */       return ((Boolean)Scaffold.this.placeableDelay.get()).booleanValue();
/*      */     }
/*      */ 
/*      */     
/*      */     Scaffold$minDelayValue$2() {
/*      */       super(0);
/*      */     } }
/*      */ 
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$blocksToEagleValue$1
/*      */     extends Lambda
/*      */     implements Function0<Boolean>
/*      */   {
/*      */     public final boolean invoke() {
/*   84 */       String str = (String)Scaffold.this.eagleValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return !str.toLowerCase().equals("off");
/*      */     } Scaffold$blocksToEagleValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*   86 */   static final class Scaffold$edgeDistanceValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Scaffold.this.eagleValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return !str.toLowerCase().equals("off"); } Scaffold$edgeDistanceValue$1() {
/*      */       super(0);
/*      */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$expandLengthValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*   90 */       String str = (String)Scaffold.this.getModeValue().get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("expand");
/*      */     }
/*      */     
/*      */     Scaffold$expandLengthValue$1() {
/*      */       super(0);
/*      */     } }
/*      */ 
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$keepLengthValue$1 extends Lambda implements Function0<Boolean> {
/*  100 */     public final boolean invoke() { return ((Boolean)Scaffold.this.keepRotationValue.get()).booleanValue(); } Scaffold$keepLengthValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  102 */   static final class Scaffold$staticPitchValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((String)Scaffold.this.rotationModeValue.get()).equals("StaticPitch"); } Scaffold$staticPitchValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  104 */   static final class Scaffold$staticYawOffsetValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((String)Scaffold.this.rotationModeValue.get()).equals("StaticYaw"); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Scaffold$staticYawOffsetValue$1() {
/*      */       super(0);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$zitterModeValue$1
/*      */     extends Lambda
/*      */     implements Function0<Boolean>
/*      */   {
/*      */     public final boolean invoke() {
/*  148 */       return ((Boolean)Scaffold.this.zitterValue.get()).booleanValue();
/*  149 */     } Scaffold$zitterModeValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Scaffold$zitterSpeed$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)Scaffold.this.zitterValue.get()).booleanValue(); } Scaffold$zitterSpeed$1() { super(0); } }
/*  150 */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Scaffold$zitterStrength$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)Scaffold.this.zitterValue.get()).booleanValue(); }
/*      */     
/*      */     Scaffold$zitterStrength$1() {
/*      */       super(0);
/*      */     } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*      */   static final class Scaffold$slowSpeed$1 extends Lambda implements Function0<Boolean> { Scaffold$slowSpeed$1() {
/*      */       super(0);
/*      */     }
/*      */     
/*  160 */     public final boolean invoke() { return ((Boolean)Scaffold.this.slowValue.get()).booleanValue(); } } @NotNull private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal"); @NotNull public final ListValue getModeValue() { return this.modeValue; } private final BoolValue noBlockDisablerValue = new BoolValue("NoBlockDisabler", false); private final BoolValue placeableDelay = new BoolValue("PlaceableDelay", false); private final IntegerValue maxDelayValue; private final IntegerValue minDelayValue; private final ListValue autoBlockValue; @NotNull private final BoolValue sprintValue; private final BoolValue swingValue; private final BoolValue searchValue; private final BoolValue downValue; private final ListValue placeModeValue; private final ListValue eagleValue; private final Value<Integer> blocksToEagleValue; private final Value<Float> edgeDistanceValue; private final Value<Integer> expandLengthValue; private final BoolValue rotationStrafeValue; private final ListValue rotationModeValue; private final BoolValue silentRotation; private final BoolValue keepRotationValue; private final Value<Integer> keepLengthValue; private final Value<Float> staticPitchValue; private final Value<Float> staticYawOffsetValue; private final FloatValue xzRangeValue; private final FloatValue yRangeValue; private final IntegerValue searchAccuracyValue; private final FloatValue maxTurnSpeedValue; private final FloatValue minTurnSpeedValue; private final BoolValue zitterValue; public Scaffold() { if ((new Scaffold$maxDelayValue$1("MaxDelay", 0, 0, 1000)).displayable(new Scaffold$maxDelayValue$2()) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.value.IntegerValue");  this.maxDelayValue = (IntegerValue)(new Scaffold$maxDelayValue$1("MaxDelay", 0, 0, 1000)).displayable(new Scaffold$maxDelayValue$2()); if ((new Scaffold$minDelayValue$1("MinDelay", 0, 0, 1000)).displayable(new Scaffold$minDelayValue$2()) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.value.IntegerValue");  this.minDelayValue = (IntegerValue)(new Scaffold$minDelayValue$1("MinDelay", 0, 0, 1000)).displayable(new Scaffold$minDelayValue$2()); this.autoBlockValue = new ListValue("AutoBlock", new String[] { "Off", "Spoof", "Pick", "Switch" }, "Spoof"); this.sprintValue = new BoolValue("Sprint", true); this.swingValue = new BoolValue("Swing", true); this.searchValue = new BoolValue("Search", true); this.downValue = new BoolValue("Down", true); this.placeModeValue = new ListValue("PlaceTiming", new String[] { "Pre", "Post" }, "Post"); this.eagleValue = new ListValue("Eagle", new String[] { "Normal", "EdgeDistance", "Silent", "Off" }, "Off"); this.blocksToEagleValue = (new IntegerValue("BlocksToEagle", 0, 0, 10)).displayable(new Scaffold$blocksToEagleValue$1()); this.edgeDistanceValue = (new FloatValue("EagleEdgeDistance", 0.2F, 0.0F, 0.5F)).displayable(new Scaffold$edgeDistanceValue$1()); this.expandLengthValue = (new IntegerValue("ExpandLength", 5, 1, 6)).displayable(new Scaffold$expandLengthValue$1()); this.rotationStrafeValue = new BoolValue("RotationStrafe", false); this.rotationModeValue = new ListValue("RotationMode", new String[] { "Normal", "Static", "StaticPitch", "StaticYaw", "Off" }, "Normal"); this.silentRotation = new BoolValue("SilentRotation", true); this.keepRotationValue = new BoolValue("KeepRotation", false); this.keepLengthValue = (new IntegerValue("KeepRotationLength", 0, 0, 20)).displayable(new Scaffold$keepLengthValue$1()); this.staticPitchValue = (new FloatValue("StaticPitchOffset", 86.0F, 70.0F, 90.0F)).displayable(new Scaffold$staticPitchValue$1()); this.staticYawOffsetValue = (new FloatValue("StaticYawOffset", 0.0F, 0.0F, 90.0F)).displayable(new Scaffold$staticYawOffsetValue$1()); this.xzRangeValue = new FloatValue("xzRange", 0.8F, 0.1F, 1.0F); this.yRangeValue = new FloatValue("yRange", 0.8F, 0.1F, 1.0F); this.searchAccuracyValue = new Scaffold$searchAccuracyValue$1("SearchAccuracy", 8, 1, 24); this.maxTurnSpeedValue = new Scaffold$maxTurnSpeedValue$1("MaxTurnSpeed", 180.0F, 1.0F, 180.0F); this.minTurnSpeedValue = new Scaffold$minTurnSpeedValue$1("MinTurnSpeed", 180.0F, 1.0F, 180.0F); this.zitterValue = new BoolValue("Zitter", false); this.zitterModeValue = (new ListValue("ZitterMode", new String[] { "Teleport", "Smooth" }, "Teleport")).displayable(new Scaffold$zitterModeValue$1()); this.zitterSpeed = (new FloatValue("ZitterSpeed", 0.13F, 0.1F, 0.3F)).displayable(new Scaffold$zitterSpeed$1()); this.zitterStrength = (new FloatValue("ZitterStrength", 0.072F, 0.05F, 0.2F)).displayable(new Scaffold$zitterStrength$1()); this.timerValue = new FloatValue("Timer", 1.0F, 0.1F, 10.0F); this.speedModifierValue = new FloatValue("SpeedModifier", 1.0F, 0.0F, 2.0F); this.slowValue = new Scaffold$slowValue$1("Slow", false); this.slowSpeed = (new FloatValue("SlowSpeed", 0.6F, 0.2F, 0.8F)).displayable(new Scaffold$slowSpeed$1());
/*      */     
/*  162 */     this.sameYValue = new BoolValue("SameY", false);
/*  163 */     this.smartSpeedValue = new BoolValue("SmartSpeed", false);
/*  164 */     this.autoJumpValue = new BoolValue("AutoJump", false);
/*  165 */     this.safeWalkValue = new BoolValue("SafeWalk", true);
/*  166 */     this.airSafeValue = new BoolValue("AirSafe", false);
/*      */ 
/*      */     
/*  169 */     this.counterDisplayValue = new BoolValue("Counter", true);
/*  170 */     this.markValue = new BoolValue("Mark", false);
/*  171 */     this.autoTimer = new BoolValue("AutoTimer", false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  194 */     this.delayTimer = new MSTimer();
/*  195 */     this.zitterTimer = new MSTimer(); }
/*      */   private final Value<String> zitterModeValue;
/*      */   private final Value<Float> zitterSpeed;
/*      */   private final Value<Float> zitterStrength;
/*      */   private final FloatValue timerValue;
/*      */   private final FloatValue speedModifierValue;
/*      */   private final BoolValue slowValue;
/*      */   private final Value<Float> slowSpeed;
/*      */   private float progress; private final BoolValue sameYValue; private final BoolValue smartSpeedValue; private final BoolValue autoJumpValue; private final BoolValue safeWalkValue; private final BoolValue airSafeValue; private final BoolValue counterDisplayValue; private final BoolValue markValue; private final BoolValue autoTimer; private PlaceInfo targetPlace; private int launchY; private Rotation lockRotation; private Rotation limitedRotation; private boolean facesBlock; private int slot; private boolean zitterDirection; private final MSTimer delayTimer; private final MSTimer zitterTimer; private long delay; private int placedBlocksWithoutEagle; private boolean eagleSneaking; private boolean shouldGoDown; @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold$maxDelayValue$1 extends IntegerValue {
/*      */     Scaffold$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(int oldValue, int newValue) { int i = ((Number)Scaffold.this.minDelayValue.get()).intValue(); if (i > newValue) set(Integer.valueOf(i));  } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold$minDelayValue$1 extends IntegerValue {
/*      */     Scaffold$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(int oldValue, int newValue) { int i = ((Number)Scaffold.this.maxDelayValue.get()).intValue(); if (i < newValue) set(Integer.valueOf(i));  } } @NotNull public final BoolValue getSprintValue() { return this.sprintValue; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold$searchAccuracyValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold$searchAccuracyValue$1 extends IntegerValue {
/*      */     Scaffold$searchAccuracyValue$1(String $super_call_param$0, int $super_call_param$1, int $super_call_param$2, int $super_call_param$3) { super($super_call_param$0, $super_call_param$1, $super_call_param$2, $super_call_param$3); } protected void onChanged(int oldValue, int newValue) { if (getMaximum() < newValue) { set(Integer.valueOf(getMaximum())); } else if (getMinimum() > newValue) { set(Integer.valueOf(getMinimum())); }  } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold$maxTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold$maxTurnSpeedValue$1 extends FloatValue {
/*      */     Scaffold$maxTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)Scaffold.this.minTurnSpeedValue.get()).floatValue(); if (v > newValue) set(Float.valueOf(v));  if (getMaximum() < newValue) { set(Float.valueOf(getMaximum())); } else if (getMinimum() > newValue) { set(Float.valueOf(getMinimum())); }  } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold$minTurnSpeedValue$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold$minTurnSpeedValue$1 extends FloatValue {
/*      */     Scaffold$minTurnSpeedValue$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)Scaffold.this.maxTurnSpeedValue.get()).floatValue(); if (v < newValue) set(Float.valueOf(v));  if (getMaximum() < newValue) { set(Float.valueOf(getMaximum())); } else if (getMinimum() > newValue) { set(Float.valueOf(getMinimum())); }  } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/Scaffold$slowValue$1", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class Scaffold$slowValue$1 extends BoolValue {
/*  209 */     Scaffold$slowValue$1(String $super_call_param$1, boolean $super_call_param$2) { super($super_call_param$1, $super_call_param$2); } protected void onChanged(boolean oldValue, boolean newValue) { if (newValue) Scaffold.this.getSprintValue().set(Boolean.valueOf(false));  } } public void onEnable() { if (MinecraftInstance.mc.getThePlayer() == null)
/*  210 */       return;  if (((Boolean)this.autoTimer.get()).booleanValue()) {
/*  211 */       if (Retreat.INSTANCE.getModuleManager().getModule(
/*  212 */           Timer.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.Timer");  Timer timer = (Timer)Retreat.INSTANCE.getModuleManager().getModule(Timer.class);
/*      */       
/*  214 */       timer.setState(true);
/*      */     } 
/*  216 */     this.progress = 0.0F;
/*  217 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.launchY = (int)MinecraftInstance.mc.getThePlayer().getPosY(); }
/*      */ 
/*      */ 
/*      */   
/*      */   private final WBlockPos getBlockPosUnder() {
/*  222 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  223 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  224 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return new WBlockPos(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY() - 1.0D, MinecraftInstance.mc.getThePlayer().getPosZ());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  232 */     if (((Boolean)this.noBlockDisablerValue.get()).booleanValue() && 
/*  233 */       getBlocksAmount() == 0) {
/*  234 */       notificationsTransform(getName(), "Blocks < 0", NotifyType.ERROR);
/*  235 */       setState(false);
/*  236 */       MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*  237 */       if (Retreat.INSTANCE.getModuleManager().getModule(GroundTelly.class).getState()) {
/*  238 */         notificationsTransform(getName(), "AutoDisabled GroundTelly", NotifyType.ERROR);
/*  239 */         Retreat.INSTANCE.getModuleManager().getModule(GroundTelly.class).setState(false);
/*      */       } 
/*      */     } 
/*      */     
/*  243 */     MinecraftInstance.mc.getTimer().setTimerSpeed(((Number)this.timerValue.get()).floatValue());
/*  244 */     if (((Boolean)this.autoJumpValue.get()).booleanValue() && !((Boolean)this.noBlockDisablerValue.get()).booleanValue()) {
/*  245 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && MovementUtils.isMoving()) {
/*  246 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump();
/*      */       } 
/*      */     } 
/*  249 */     getBestBlocks();
/*      */     
/*  251 */     this.shouldGoDown = (((Boolean)this.downValue.get()).booleanValue() && !((Boolean)this.sameYValue.get()).booleanValue() && MinecraftInstance.mc.getGameSettings().getKeyBindSneak().isKeyDown() && getBlocksAmount() > 1);
/*  252 */     if (this.shouldGoDown) MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false); 
/*  253 */     if (((Boolean)this.slowValue.get()).booleanValue()) {
/*  254 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() * ((Number)this.slowSpeed.get()).doubleValue());
/*  255 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() * ((Number)this.slowSpeed.get()).doubleValue());
/*      */     } 
/*  257 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround())
/*  258 */     { String mode = (String)this.modeValue.get();
/*      */ 
/*      */       
/*  261 */       if (StringsKt.equals(mode, "Rewinside", true)) {
/*  262 */         MovementUtils.strafe(0.2F);
/*  263 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.0D);
/*      */       } 
/*      */ 
/*      */       
/*  267 */       if (((Boolean)this.zitterValue.get()).booleanValue() && StringsKt.equals((String)this.zitterModeValue.get(), "smooth", true)) {
/*  268 */         if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindRight()))
/*  269 */           MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false); 
/*  270 */         if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindLeft())) MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false); 
/*  271 */         if (this.zitterTimer.hasTimePassed(100L)) {
/*  272 */           this.zitterDirection = !this.zitterDirection;
/*  273 */           this.zitterTimer.reset();
/*      */         } 
/*  275 */         if (this.zitterDirection) {
/*  276 */           MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(true);
/*  277 */           MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);
/*      */         } else {
/*  279 */           MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);
/*  280 */           MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(true);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  285 */       if (!StringsKt.equals((String)this.eagleValue.get(), "Off", true) && !this.shouldGoDown)
/*  286 */       { double dif = 0.5D;
/*  287 */         if (StringsKt.equals((String)this.eagleValue.get(), "EdgeDistance", true) && !this.shouldGoDown)
/*  288 */           for (byte b1 = 0, b2 = 3; b1 <= b2; b1++)
/*  289 */           { Scaffold scaffold1; WBlockPos blockPos; boolean bool1; PlaceInfo placeInfo; boolean bool2; int $i$f$isReplaceable; Scaffold $this$run; int $i$a$-run-Scaffold$onUpdate$1; int $i$a$-run-Scaffold$onUpdate$5; int $i$a$-run-Scaffold$onUpdate$8; switch (b1)
/*      */             { case 0:
/*  291 */                 scaffold1 = this; bool1 = false; bool2 = false; $this$run = scaffold1; $i$a$-run-Scaffold$onUpdate$1 = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 1:
/*  354 */                 scaffold1 = this; bool1 = false; bool2 = false; $this$run = scaffold1; $i$a$-run-Scaffold$onUpdate$5 = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 2:
/*  402 */                 scaffold1 = this; bool1 = false; bool2 = false; $this$run = scaffold1; $i$a$-run-Scaffold$onUpdate$8 = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               case 3:
/*  436 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  437 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  438 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  blockPos = new WBlockPos(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY() - ((MinecraftInstance.mc.getThePlayer().getPosY() == (int)MinecraftInstance.mc.getThePlayer().getPosY() + 0.5D) ? 0.0D : 1.0D), MinecraftInstance.mc.getThePlayer().getPosZ() + true);
/*      */                 
/*  440 */                 placeInfo = PlaceInfo.Companion.get(blockPos);
/*  441 */                 $i$f$isReplaceable = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1006 */                 BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double calcDif = MinecraftInstance.mc.getThePlayer().getPosZ() - blockPos.getZ(); calcDif -= 0.5D; }  break; }  continue; }   if (this.placedBlocksWithoutEagle >= ((Number)this.blocksToEagleValue.get()).intValue()) { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  boolean shouldEagle = (Intrinsics.areEqual(MinecraftInstance.mc.getTheWorld().getBlockState(new WBlockPos(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY() - 1.0D, MinecraftInstance.mc.getThePlayer().getPosZ())).getBlock(), MinecraftInstance.classProvider.getBlockEnum(BlockType.AIR)) || (dif < ((Number)this.edgeDistanceValue.get()).doubleValue() && StringsKt.equals((String)this.eagleValue.get(), "EdgeDistance", true))); if (StringsKt.equals((String)this.eagleValue.get(), "Silent", true) && !this.shouldGoDown) { if (this.eagleSneaking != shouldEagle) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), shouldEagle ? ICPacketEntityAction.WAction.START_SNEAKING : ICPacketEntityAction.WAction.STOP_SNEAKING)); }  this.eagleSneaking = shouldEagle; } else { MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(shouldEagle); }  this.placedBlocksWithoutEagle = 0; } else { int i; this.placedBlocksWithoutEagle = (i = this.placedBlocksWithoutEagle) + 1; }  }  if (((Boolean)this.zitterValue.get()).booleanValue() && StringsKt.equals((String)this.zitterModeValue.get(), "teleport", true)) { MovementUtils.strafe(((Number)this.zitterSpeed.get()).floatValue()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double yaw = Math.toRadians(MinecraftInstance.mc.getThePlayer().getRotationYaw() + (this.zitterDirection ? 90.0D : -90.0D)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() - Math.sin(yaw) * ((Number)this.zitterStrength.get()).doubleValue()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() + Math.cos(yaw) * ((Number)this.zitterStrength.get()).doubleValue()); this.zitterDirection = !this.zitterDirection; }  }  if (this.shouldGoDown) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.launchY = (int)MinecraftInstance.mc.getThePlayer().getPosY() - 1; } 
/*      */   } private final void notificationsTransform(String name, String s, NotifyType error) {} @EventTarget public final void onPacket(@NotNull PacketEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) return;  IPacket packet = event.getPacket(); if (MinecraftInstance.classProvider.isCPacketHeldItemChange(packet)) { ICPacketHeldItemChange packetHeldItemChange = packet.asCPacketHeldItemChange(); this.slot = packetHeldItemChange.getSlotId(); }  } @EventTarget private final void onStrafe(StrafeEvent event) { if (!((Boolean)this.rotationStrafeValue.get()).booleanValue()) return;  RotationUtils.serverRotation.applyStrafeToPlayer(event); event.cancelEvent(); }
/* 1008 */   @EventTarget public final void onRender3D(@Nullable Render3DEvent event) { if (!((Boolean)this.markValue.get()).booleanValue()) return;  for (byte b1 = 0, b2 = StringsKt.equals((String)this.modeValue.get(), "Expand", true) ? (((Number)this.expandLengthValue.get()).intValue() + 1) : 2; b1 < b2; b1++) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  WBlockPos blockPos = new WBlockPos(MinecraftInstance.mc.getThePlayer().getPosX() + (Intrinsics.areEqual(MinecraftInstance.mc.getThePlayer().getHorizontalFacing(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.WEST)) ? -b1 : (Intrinsics.areEqual(MinecraftInstance.mc.getThePlayer().getHorizontalFacing(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.EAST)) ? b1 : false)), MinecraftInstance.mc.getThePlayer().getPosY() - ((MinecraftInstance.mc.getThePlayer().getPosY() == (int)MinecraftInstance.mc.getThePlayer().getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0F : 0.0F), MinecraftInstance.mc.getThePlayer().getPosZ() + (Intrinsics.areEqual(MinecraftInstance.mc.getThePlayer().getHorizontalFacing(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.NORTH)) ? -b1 : (Intrinsics.areEqual(MinecraftInstance.mc.getThePlayer().getHorizontalFacing(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.SOUTH)) ? b1 : false))); PlaceInfo placeInfo = PlaceInfo.Companion.get(blockPos); int $i$f$isReplaceable = 0; BlockUtils.getMaterial(blockPos); if (((BlockUtils.getMaterial(blockPos) != null) ? BlockUtils.getMaterial(blockPos).isReplaceable() : false) && placeInfo != null) {
/*      */         RenderUtils.drawBlockBox(blockPos, new Color(255, 255, 255, 50), true);
/*      */         break;
/*      */       }  }
/*      */      }
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public final void onMotion(@NotNull MotionEvent event) {
/*      */     Intrinsics.checkParameterIsNotNull(event, "event");
/*      */     EventState eventState = event.getEventState();
/*      */     if (!StringsKt.equals((String)this.rotationModeValue.get(), "Off", true) && ((Boolean)this.keepRotationValue.get()).booleanValue() && this.lockRotation != null) {
/*      */       if (this.lockRotation == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       setRotation(this.lockRotation);
/*      */     } 
/*      */     if ((this.facesBlock || StringsKt.equals((String)this.rotationModeValue.get(), "Off", true)) && StringsKt.equals((String)this.placeModeValue.get(), eventState.getStateName(), true))
/*      */       place(); 
/*      */     if (eventState == EventState.PRE)
/*      */       update(); 
/*      */     if (this.targetPlace == null && ((Boolean)this.placeableDelay.get()).booleanValue())
/*      */       this.delayTimer.reset(); 
/*      */   }
/*      */   
/*      */   private final void update() {
/*      */     // Byte code:
/*      */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   8: dup
/*      */     //   9: ifnonnull -> 15
/*      */     //   12: invokestatic throwNpe : ()V
/*      */     //   15: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   20: ifnull -> 70
/*      */     //   23: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   26: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   29: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   34: dup
/*      */     //   35: ifnonnull -> 41
/*      */     //   38: invokestatic throwNpe : ()V
/*      */     //   41: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   46: dup
/*      */     //   47: ifnonnull -> 53
/*      */     //   50: invokestatic throwNpe : ()V
/*      */     //   53: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   58: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   63: ifeq -> 70
/*      */     //   66: iconst_1
/*      */     //   67: goto -> 71
/*      */     //   70: iconst_0
/*      */     //   71: istore_1
/*      */     //   72: aload_0
/*      */     //   73: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   76: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   79: checkcast java/lang/String
/*      */     //   82: ldc_w 'Off'
/*      */     //   85: iconst_1
/*      */     //   86: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   89: ifne -> 111
/*      */     //   92: invokestatic findAutoBlockBlock : ()I
/*      */     //   95: iconst_m1
/*      */     //   96: if_icmpne -> 107
/*      */     //   99: iload_1
/*      */     //   100: ifne -> 107
/*      */     //   103: iconst_1
/*      */     //   104: goto -> 120
/*      */     //   107: iconst_0
/*      */     //   108: goto -> 120
/*      */     //   111: iload_1
/*      */     //   112: ifne -> 119
/*      */     //   115: iconst_1
/*      */     //   116: goto -> 120
/*      */     //   119: iconst_0
/*      */     //   120: ifeq -> 124
/*      */     //   123: return
/*      */     //   124: aload_0
/*      */     //   125: aload_0
/*      */     //   126: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   129: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   132: checkcast java/lang/String
/*      */     //   135: ldc_w 'expand'
/*      */     //   138: iconst_1
/*      */     //   139: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   142: invokespecial findBlock : (Z)V
/*      */     //   145: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #534	-> 0
/*      */     //   #535	-> 26
/*      */     //   #534	-> 58
/*      */     //   #537	-> 72
/*      */     //   #538	-> 72
/*      */     //   #537	-> 72
/*      */     //   #538	-> 82
/*      */     //   #539	-> 92
/*      */     //   #537	-> 120
/*      */     //   #540	-> 123
/*      */     //   #541	-> 124
/*      */     //   #542	-> 145
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   72	74	1	isHeldItemBlock	Z
/*      */     //   0	146	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold;
/*      */   }
/*      */   
/*      */   private final void setRotation(Rotation rotation, int keepRotation) {
/*      */     if (((Boolean)this.silentRotation.get()).booleanValue()) {
/*      */       RotationUtils.setTargetRotation(rotation, keepRotation);
/*      */     } else {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       MinecraftInstance.mc.getThePlayer().setRotationYaw(rotation.getYaw());
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       MinecraftInstance.mc.getThePlayer().setRotationPitch(rotation.getPitch());
/*      */     } 
/*      */   }
/*      */   
/*      */   private final void setRotation(Rotation rotation) {
/*      */     setRotation(rotation, 0);
/*      */   }
/*      */   
/*      */   private final void findBlock(boolean expand) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield shouldGoDown : Z
/*      */     //   4: ifeq -> 208
/*      */     //   7: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   10: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   15: dup
/*      */     //   16: ifnonnull -> 22
/*      */     //   19: invokestatic throwNpe : ()V
/*      */     //   22: invokeinterface getPosY : ()D
/*      */     //   27: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   30: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   35: dup
/*      */     //   36: ifnonnull -> 42
/*      */     //   39: invokestatic throwNpe : ()V
/*      */     //   42: invokeinterface getPosY : ()D
/*      */     //   47: d2i
/*      */     //   48: i2d
/*      */     //   49: ldc2_w 0.5
/*      */     //   52: dadd
/*      */     //   53: dcmpg
/*      */     //   54: ifne -> 131
/*      */     //   57: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*      */     //   60: dup
/*      */     //   61: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   64: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   69: dup
/*      */     //   70: ifnonnull -> 76
/*      */     //   73: invokestatic throwNpe : ()V
/*      */     //   76: invokeinterface getPosX : ()D
/*      */     //   81: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   84: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   89: dup
/*      */     //   90: ifnonnull -> 96
/*      */     //   93: invokestatic throwNpe : ()V
/*      */     //   96: invokeinterface getPosY : ()D
/*      */     //   101: ldc2_w 0.6
/*      */     //   104: dsub
/*      */     //   105: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   108: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   113: dup
/*      */     //   114: ifnonnull -> 120
/*      */     //   117: invokestatic throwNpe : ()V
/*      */     //   120: invokeinterface getPosZ : ()D
/*      */     //   125: invokespecial <init> : (DDD)V
/*      */     //   128: goto -> 529
/*      */     //   131: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*      */     //   134: dup
/*      */     //   135: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   138: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   143: dup
/*      */     //   144: ifnonnull -> 150
/*      */     //   147: invokestatic throwNpe : ()V
/*      */     //   150: invokeinterface getPosX : ()D
/*      */     //   155: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   158: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   163: dup
/*      */     //   164: ifnonnull -> 170
/*      */     //   167: invokestatic throwNpe : ()V
/*      */     //   170: invokeinterface getPosY : ()D
/*      */     //   175: ldc2_w 0.6
/*      */     //   178: dsub
/*      */     //   179: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   182: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   187: dup
/*      */     //   188: ifnonnull -> 194
/*      */     //   191: invokestatic throwNpe : ()V
/*      */     //   194: invokeinterface getPosZ : ()D
/*      */     //   199: invokespecial <init> : (DDD)V
/*      */     //   202: invokevirtual down : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   205: goto -> 529
/*      */     //   208: aload_0
/*      */     //   209: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   212: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   215: checkcast java/lang/Boolean
/*      */     //   218: invokevirtual booleanValue : ()Z
/*      */     //   221: ifne -> 324
/*      */     //   224: aload_0
/*      */     //   225: getfield autoJumpValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   228: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   231: checkcast java/lang/Boolean
/*      */     //   234: invokevirtual booleanValue : ()Z
/*      */     //   237: ifne -> 274
/*      */     //   240: aload_0
/*      */     //   241: getfield smartSpeedValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   244: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   247: checkcast java/lang/Boolean
/*      */     //   250: invokevirtual booleanValue : ()Z
/*      */     //   253: ifeq -> 381
/*      */     //   256: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   259: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   262: ldc_w net/ccbluex/liquidbounce/features/module/modules/movement/Speed
/*      */     //   265: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   268: invokevirtual getState : ()Z
/*      */     //   271: ifeq -> 381
/*      */     //   274: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   277: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   282: invokeinterface getKeyBindJump : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   287: invokeinterface isKeyDown : ()Z
/*      */     //   292: ifne -> 381
/*      */     //   295: aload_0
/*      */     //   296: getfield launchY : I
/*      */     //   299: i2d
/*      */     //   300: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   303: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   308: dup
/*      */     //   309: ifnonnull -> 315
/*      */     //   312: invokestatic throwNpe : ()V
/*      */     //   315: invokeinterface getPosY : ()D
/*      */     //   320: dcmpg
/*      */     //   321: ifgt -> 381
/*      */     //   324: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*      */     //   327: dup
/*      */     //   328: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   331: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   336: dup
/*      */     //   337: ifnonnull -> 343
/*      */     //   340: invokestatic throwNpe : ()V
/*      */     //   343: invokeinterface getPosX : ()D
/*      */     //   348: aload_0
/*      */     //   349: getfield launchY : I
/*      */     //   352: iconst_1
/*      */     //   353: isub
/*      */     //   354: i2d
/*      */     //   355: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   358: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   363: dup
/*      */     //   364: ifnonnull -> 370
/*      */     //   367: invokestatic throwNpe : ()V
/*      */     //   370: invokeinterface getPosZ : ()D
/*      */     //   375: invokespecial <init> : (DDD)V
/*      */     //   378: goto -> 529
/*      */     //   381: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   384: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   389: dup
/*      */     //   390: ifnonnull -> 396
/*      */     //   393: invokestatic throwNpe : ()V
/*      */     //   396: invokeinterface getPosY : ()D
/*      */     //   401: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   404: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   409: dup
/*      */     //   410: ifnonnull -> 416
/*      */     //   413: invokestatic throwNpe : ()V
/*      */     //   416: invokeinterface getPosY : ()D
/*      */     //   421: d2i
/*      */     //   422: i2d
/*      */     //   423: ldc2_w 0.5
/*      */     //   426: dadd
/*      */     //   427: dcmpg
/*      */     //   428: ifne -> 459
/*      */     //   431: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*      */     //   434: dup
/*      */     //   435: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   438: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   443: dup
/*      */     //   444: ifnonnull -> 450
/*      */     //   447: invokestatic throwNpe : ()V
/*      */     //   450: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   453: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   456: goto -> 529
/*      */     //   459: new net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos
/*      */     //   462: dup
/*      */     //   463: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   466: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   471: dup
/*      */     //   472: ifnonnull -> 478
/*      */     //   475: invokestatic throwNpe : ()V
/*      */     //   478: invokeinterface getPosX : ()D
/*      */     //   483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   486: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   491: dup
/*      */     //   492: ifnonnull -> 498
/*      */     //   495: invokestatic throwNpe : ()V
/*      */     //   498: invokeinterface getPosY : ()D
/*      */     //   503: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   506: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   511: dup
/*      */     //   512: ifnonnull -> 518
/*      */     //   515: invokestatic throwNpe : ()V
/*      */     //   518: invokeinterface getPosZ : ()D
/*      */     //   523: invokespecial <init> : (DDD)V
/*      */     //   526: invokevirtual down : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   529: astore_2
/*      */     //   530: iload_1
/*      */     //   531: ifne -> 578
/*      */     //   534: iconst_0
/*      */     //   535: istore_3
/*      */     //   536: aload_2
/*      */     //   537: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*      */     //   540: dup
/*      */     //   541: ifnull -> 552
/*      */     //   544: invokeinterface isReplaceable : ()Z
/*      */     //   549: goto -> 554
/*      */     //   552: pop
/*      */     //   553: iconst_0
/*      */     //   554: ifeq -> 577
/*      */     //   557: aload_0
/*      */     //   558: aload_2
/*      */     //   559: aload_0
/*      */     //   560: getfield shouldGoDown : Z
/*      */     //   563: ifne -> 570
/*      */     //   566: iconst_1
/*      */     //   567: goto -> 571
/*      */     //   570: iconst_0
/*      */     //   571: invokespecial search : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Z)Z
/*      */     //   574: ifeq -> 578
/*      */     //   577: return
/*      */     //   578: iload_1
/*      */     //   579: ifeq -> 793
/*      */     //   582: iconst_0
/*      */     //   583: istore_3
/*      */     //   584: aload_0
/*      */     //   585: getfield expandLengthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   588: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   591: checkcast java/lang/Number
/*      */     //   594: invokevirtual intValue : ()I
/*      */     //   597: istore #4
/*      */     //   599: iload_3
/*      */     //   600: iload #4
/*      */     //   602: if_icmpge -> 873
/*      */     //   605: aload_0
/*      */     //   606: aload_2
/*      */     //   607: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   610: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   615: dup
/*      */     //   616: ifnonnull -> 622
/*      */     //   619: invokestatic throwNpe : ()V
/*      */     //   622: invokeinterface getHorizontalFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   627: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   630: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.WEST : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   633: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   638: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   641: ifeq -> 649
/*      */     //   644: iload_3
/*      */     //   645: ineg
/*      */     //   646: goto -> 691
/*      */     //   649: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   652: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   657: dup
/*      */     //   658: ifnonnull -> 664
/*      */     //   661: invokestatic throwNpe : ()V
/*      */     //   664: invokeinterface getHorizontalFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   669: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   672: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.EAST : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   675: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   680: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   683: ifeq -> 690
/*      */     //   686: iload_3
/*      */     //   687: goto -> 691
/*      */     //   690: iconst_0
/*      */     //   691: iconst_0
/*      */     //   692: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   695: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   700: dup
/*      */     //   701: ifnonnull -> 707
/*      */     //   704: invokestatic throwNpe : ()V
/*      */     //   707: invokeinterface getHorizontalFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   712: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   715: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.NORTH : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   718: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   723: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   726: ifeq -> 734
/*      */     //   729: iload_3
/*      */     //   730: ineg
/*      */     //   731: goto -> 776
/*      */     //   734: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   737: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   742: dup
/*      */     //   743: ifnonnull -> 749
/*      */     //   746: invokestatic throwNpe : ()V
/*      */     //   749: invokeinterface getHorizontalFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   754: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   757: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.SOUTH : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   760: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   765: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   768: ifeq -> 775
/*      */     //   771: iload_3
/*      */     //   772: goto -> 776
/*      */     //   775: iconst_0
/*      */     //   776: invokevirtual add : (III)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   779: iconst_0
/*      */     //   780: invokespecial search : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Z)Z
/*      */     //   783: ifeq -> 787
/*      */     //   786: return
/*      */     //   787: iinc #3, 1
/*      */     //   790: goto -> 599
/*      */     //   793: aload_0
/*      */     //   794: getfield searchValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   797: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   800: checkcast java/lang/Boolean
/*      */     //   803: invokevirtual booleanValue : ()Z
/*      */     //   806: ifeq -> 873
/*      */     //   809: iconst_m1
/*      */     //   810: istore_3
/*      */     //   811: iconst_1
/*      */     //   812: istore #4
/*      */     //   814: iload_3
/*      */     //   815: iload #4
/*      */     //   817: if_icmpgt -> 873
/*      */     //   820: iconst_m1
/*      */     //   821: istore #5
/*      */     //   823: iconst_1
/*      */     //   824: istore #6
/*      */     //   826: iload #5
/*      */     //   828: iload #6
/*      */     //   830: if_icmpgt -> 867
/*      */     //   833: aload_0
/*      */     //   834: aload_2
/*      */     //   835: iload_3
/*      */     //   836: iconst_0
/*      */     //   837: iload #5
/*      */     //   839: invokevirtual add : (III)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   842: aload_0
/*      */     //   843: getfield shouldGoDown : Z
/*      */     //   846: ifne -> 853
/*      */     //   849: iconst_1
/*      */     //   850: goto -> 854
/*      */     //   853: iconst_0
/*      */     //   854: invokespecial search : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Z)Z
/*      */     //   857: ifeq -> 861
/*      */     //   860: return
/*      */     //   861: iinc #5, 1
/*      */     //   864: goto -> 826
/*      */     //   867: iinc #3, 1
/*      */     //   870: goto -> 814
/*      */     //   873: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #566	-> 0
/*      */     //   #567	-> 0
/*      */     //   #568	-> 61
/*      */     //   #567	-> 125
/*      */     //   #569	-> 131
/*      */     //   #571	-> 131
/*      */     //   #569	-> 131
/*      */     //   #570	-> 135
/*      */     //   #569	-> 199
/*      */     //   #571	-> 202
/*      */     //   #567	-> 205
/*      */     //   #571	-> 208
/*      */     //   #573	-> 208
/*      */     //   #571	-> 208
/*      */     //   #573	-> 208
/*      */     //   #571	-> 208
/*      */     //   #572	-> 262
/*      */     //   #571	-> 265
/*      */     //   #574	-> 324
/*      */     //   #575	-> 328
/*      */     //   #574	-> 375
/*      */     //   #576	-> 381
/*      */     //   #577	-> 435
/*      */     //   #576	-> 453
/*      */     //   #578	-> 459
/*      */     //   #576	-> 529
/*      */     //   #571	-> 529
/*      */     //   #567	-> 529
/*      */     //   #566	-> 529
/*      */     //   #579	-> 530
/*      */     //   #1007	-> 536
/*      */     //   #1007	-> 552
/*      */     //   #579	-> 558
/*      */     //   #580	-> 578
/*      */     //   #581	-> 582
/*      */     //   #582	-> 605
/*      */     //   #583	-> 606
/*      */     //   #584	-> 607
/*      */     //   #585	-> 672
/*      */     //   #584	-> 675
/*      */     //   #587	-> 686
/*      */     //   #584	-> 691
/*      */     //   #588	-> 691
/*      */     //   #589	-> 692
/*      */     //   #590	-> 757
/*      */     //   #589	-> 760
/*      */     //   #592	-> 771
/*      */     //   #589	-> 776
/*      */     //   #583	-> 776
/*      */     //   #593	-> 779
/*      */     //   #582	-> 780
/*      */     //   #595	-> 786
/*      */     //   #581	-> 787
/*      */     //   #597	-> 793
/*      */     //   #598	-> 809
/*      */     //   #599	-> 873
/*      */     //   #600	-> 873
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   536	18	3	$i$f$isReplaceable	I
/*      */     //   605	185	3	i	I
/*      */     //   833	31	5	z	I
/*      */     //   820	50	3	x	I
/*      */     //   530	344	2	blockPosition	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   0	874	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold;
/*      */     //   0	874	1	expand	Z
/*      */   }
/*      */   
/*      */   private final void place() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   4: ifnonnull -> 31
/*      */     //   7: aload_0
/*      */     //   8: getfield placeableDelay : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   14: checkcast java/lang/Boolean
/*      */     //   17: invokevirtual booleanValue : ()Z
/*      */     //   20: ifeq -> 30
/*      */     //   23: aload_0
/*      */     //   24: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   27: invokevirtual reset : ()V
/*      */     //   30: return
/*      */     //   31: aload_0
/*      */     //   32: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   35: aload_0
/*      */     //   36: getfield delay : J
/*      */     //   39: invokevirtual hasTimePassed : (J)Z
/*      */     //   42: ifeq -> 88
/*      */     //   45: aload_0
/*      */     //   46: getfield sameYValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   49: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   52: checkcast java/lang/Boolean
/*      */     //   55: invokevirtual booleanValue : ()Z
/*      */     //   58: ifeq -> 89
/*      */     //   61: aload_0
/*      */     //   62: getfield launchY : I
/*      */     //   65: iconst_1
/*      */     //   66: isub
/*      */     //   67: aload_0
/*      */     //   68: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   71: dup
/*      */     //   72: ifnonnull -> 78
/*      */     //   75: invokestatic throwNpe : ()V
/*      */     //   78: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   81: invokevirtual getYCoord : ()D
/*      */     //   84: d2i
/*      */     //   85: if_icmpeq -> 89
/*      */     //   88: return
/*      */     //   89: iconst_0
/*      */     //   90: istore_1
/*      */     //   91: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   94: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   99: dup
/*      */     //   100: ifnonnull -> 106
/*      */     //   103: invokestatic throwNpe : ()V
/*      */     //   106: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   111: astore_2
/*      */     //   112: aload_2
/*      */     //   113: ifnull -> 202
/*      */     //   116: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   119: aload_2
/*      */     //   120: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   125: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   130: ifeq -> 202
/*      */     //   133: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   136: aload_2
/*      */     //   137: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   142: dup
/*      */     //   143: ifnonnull -> 149
/*      */     //   146: invokestatic throwNpe : ()V
/*      */     //   149: invokeinterface asItemBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;
/*      */     //   154: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*      */     //   159: invokeinterface isBlockBush : (Ljava/lang/Object;)Z
/*      */     //   164: ifne -> 202
/*      */     //   167: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   170: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   175: dup
/*      */     //   176: ifnonnull -> 182
/*      */     //   179: invokestatic throwNpe : ()V
/*      */     //   182: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   187: dup
/*      */     //   188: ifnonnull -> 194
/*      */     //   191: invokestatic throwNpe : ()V
/*      */     //   194: invokeinterface getStackSize : ()I
/*      */     //   199: ifgt -> 495
/*      */     //   202: aload_0
/*      */     //   203: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   206: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   209: checkcast java/lang/String
/*      */     //   212: ldc_w 'Off'
/*      */     //   215: iconst_1
/*      */     //   216: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   219: ifeq -> 223
/*      */     //   222: return
/*      */     //   223: invokestatic findAutoBlockBlock : ()I
/*      */     //   226: istore_1
/*      */     //   227: iload_1
/*      */     //   228: iconst_m1
/*      */     //   229: if_icmpne -> 233
/*      */     //   232: return
/*      */     //   233: aload_0
/*      */     //   234: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   237: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   240: checkcast java/lang/String
/*      */     //   243: ldc_w 'Pick'
/*      */     //   246: iconst_1
/*      */     //   247: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   250: ifeq -> 281
/*      */     //   253: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   256: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   261: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   264: iload_1
/*      */     //   265: bipush #36
/*      */     //   267: isub
/*      */     //   268: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*      */     //   273: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   276: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   281: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   284: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   289: invokeinterface updateController : ()V
/*      */     //   294: aload_0
/*      */     //   295: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   298: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   301: checkcast java/lang/String
/*      */     //   304: ldc_w 'Spoof'
/*      */     //   307: iconst_1
/*      */     //   308: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   311: ifeq -> 356
/*      */     //   314: iload_1
/*      */     //   315: bipush #36
/*      */     //   317: isub
/*      */     //   318: aload_0
/*      */     //   319: getfield slot : I
/*      */     //   322: if_icmpeq -> 463
/*      */     //   325: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   328: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   333: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   336: iload_1
/*      */     //   337: bipush #36
/*      */     //   339: isub
/*      */     //   340: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*      */     //   345: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   348: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   353: goto -> 463
/*      */     //   356: aload_0
/*      */     //   357: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   360: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   363: checkcast java/lang/String
/*      */     //   366: ldc_w 'Switch'
/*      */     //   369: iconst_1
/*      */     //   370: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   373: ifeq -> 421
/*      */     //   376: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   379: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   384: dup
/*      */     //   385: ifnonnull -> 391
/*      */     //   388: invokestatic throwNpe : ()V
/*      */     //   391: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   396: iload_1
/*      */     //   397: bipush #36
/*      */     //   399: isub
/*      */     //   400: invokeinterface setCurrentItem : (I)V
/*      */     //   405: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   408: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   413: invokeinterface updateController : ()V
/*      */     //   418: goto -> 463
/*      */     //   421: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   424: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   429: dup
/*      */     //   430: ifnonnull -> 436
/*      */     //   433: invokestatic throwNpe : ()V
/*      */     //   436: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   441: iload_1
/*      */     //   442: bipush #36
/*      */     //   444: isub
/*      */     //   445: invokeinterface setCurrentItem : (I)V
/*      */     //   450: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   453: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   458: invokeinterface updateController : ()V
/*      */     //   463: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   466: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   471: dup
/*      */     //   472: ifnonnull -> 478
/*      */     //   475: invokestatic throwNpe : ()V
/*      */     //   478: invokeinterface getInventoryContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*      */     //   483: iload_1
/*      */     //   484: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*      */     //   489: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   494: astore_2
/*      */     //   495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   498: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   503: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   506: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   511: dup
/*      */     //   512: ifnonnull -> 518
/*      */     //   515: invokestatic throwNpe : ()V
/*      */     //   518: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   521: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   526: dup
/*      */     //   527: ifnonnull -> 533
/*      */     //   530: invokestatic throwNpe : ()V
/*      */     //   533: aload_2
/*      */     //   534: aload_0
/*      */     //   535: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   538: dup
/*      */     //   539: ifnonnull -> 545
/*      */     //   542: invokestatic throwNpe : ()V
/*      */     //   545: invokevirtual getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   548: aload_0
/*      */     //   549: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   552: dup
/*      */     //   553: ifnonnull -> 559
/*      */     //   556: invokestatic throwNpe : ()V
/*      */     //   559: invokevirtual getEnumFacing : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   562: aload_0
/*      */     //   563: getfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   566: dup
/*      */     //   567: ifnonnull -> 573
/*      */     //   570: invokestatic throwNpe : ()V
/*      */     //   573: invokevirtual getVec3 : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   576: invokeinterface onPlayerRightClick : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)Z
/*      */     //   581: ifeq -> 810
/*      */     //   584: aload_0
/*      */     //   585: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   588: invokevirtual reset : ()V
/*      */     //   591: aload_0
/*      */     //   592: aload_0
/*      */     //   593: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   596: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   599: checkcast java/lang/Number
/*      */     //   602: invokevirtual intValue : ()I
/*      */     //   605: aload_0
/*      */     //   606: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   609: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   612: checkcast java/lang/Number
/*      */     //   615: invokevirtual intValue : ()I
/*      */     //   618: invokestatic randomDelay : (II)J
/*      */     //   621: putfield delay : J
/*      */     //   624: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   627: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   632: dup
/*      */     //   633: ifnonnull -> 639
/*      */     //   636: invokestatic throwNpe : ()V
/*      */     //   639: invokeinterface getOnGround : ()Z
/*      */     //   644: ifeq -> 747
/*      */     //   647: aload_0
/*      */     //   648: getfield speedModifierValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   651: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   654: checkcast java/lang/Number
/*      */     //   657: invokevirtual floatValue : ()F
/*      */     //   660: fstore_3
/*      */     //   661: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   664: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   669: dup
/*      */     //   670: ifnonnull -> 676
/*      */     //   673: invokestatic throwNpe : ()V
/*      */     //   676: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   679: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   684: dup
/*      */     //   685: ifnonnull -> 691
/*      */     //   688: invokestatic throwNpe : ()V
/*      */     //   691: invokeinterface getMotionX : ()D
/*      */     //   696: fload_3
/*      */     //   697: f2d
/*      */     //   698: dmul
/*      */     //   699: invokeinterface setMotionX : (D)V
/*      */     //   704: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   707: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   712: dup
/*      */     //   713: ifnonnull -> 719
/*      */     //   716: invokestatic throwNpe : ()V
/*      */     //   719: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   722: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   727: dup
/*      */     //   728: ifnonnull -> 734
/*      */     //   731: invokestatic throwNpe : ()V
/*      */     //   734: invokeinterface getMotionZ : ()D
/*      */     //   739: fload_3
/*      */     //   740: f2d
/*      */     //   741: dmul
/*      */     //   742: invokeinterface setMotionZ : (D)V
/*      */     //   747: aload_0
/*      */     //   748: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   751: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   754: checkcast java/lang/Boolean
/*      */     //   757: invokevirtual booleanValue : ()Z
/*      */     //   760: ifeq -> 786
/*      */     //   763: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   766: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   771: dup
/*      */     //   772: ifnonnull -> 778
/*      */     //   775: invokestatic throwNpe : ()V
/*      */     //   778: invokeinterface swingItem : ()V
/*      */     //   783: goto -> 810
/*      */     //   786: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   789: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   794: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   797: invokeinterface createCPacketAnimation : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;
/*      */     //   802: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   805: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   810: aload_0
/*      */     //   811: aconst_null
/*      */     //   812: checkcast net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*      */     //   815: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   818: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #606	-> 0
/*      */     //   #607	-> 7
/*      */     //   #608	-> 30
/*      */     //   #610	-> 31
/*      */     //   #611	-> 89
/*      */     //   #612	-> 91
/*      */     //   #613	-> 112
/*      */     //   #614	-> 112
/*      */     //   #617	-> 112
/*      */     //   #613	-> 116
/*      */     //   #614	-> 133
/*      */     //   #615	-> 136
/*      */     //   #616	-> 136
/*      */     //   #615	-> 136
/*      */     //   #616	-> 136
/*      */     //   #615	-> 136
/*      */     //   #616	-> 149
/*      */     //   #614	-> 159
/*      */     //   #619	-> 202
/*      */     //   #620	-> 223
/*      */     //   #621	-> 227
/*      */     //   #622	-> 233
/*      */     //   #623	-> 233
/*      */     //   #622	-> 233
/*      */     //   #623	-> 243
/*      */     //   #624	-> 253
/*      */     //   #625	-> 281
/*      */     //   #626	-> 294
/*      */     //   #627	-> 314
/*      */     //   #628	-> 333
/*      */     //   #629	-> 336
/*      */     //   #628	-> 340
/*      */     //   #627	-> 348
/*      */     //   #632	-> 356
/*      */     //   #633	-> 376
/*      */     //   #634	-> 405
/*      */     //   #636	-> 421
/*      */     //   #637	-> 450
/*      */     //   #638	-> 463
/*      */     //   #639	-> 463
/*      */     //   #641	-> 495
/*      */     //   #642	-> 503
/*      */     //   #643	-> 518
/*      */     //   #644	-> 533
/*      */     //   #645	-> 534
/*      */     //   #646	-> 548
/*      */     //   #647	-> 562
/*      */     //   #641	-> 576
/*      */     //   #650	-> 584
/*      */     //   #651	-> 591
/*      */     //   #652	-> 624
/*      */     //   #653	-> 647
/*      */     //   #654	-> 661
/*      */     //   #655	-> 704
/*      */     //   #657	-> 747
/*      */     //   #666	-> 810
/*      */     //   #667	-> 818
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   661	86	3	modifier	F
/*      */     //   112	707	2	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   91	728	1	blockSlot	I
/*      */     //   0	819	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold;
/*      */   }
/*      */   
/*      */   public void onDisable() {
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       return; 
/*      */     if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindSneak())) {
/*      */       MinecraftInstance.mc.getGameSettings().getKeyBindSneak().setPressed(false);
/*      */       if (this.eagleSneaking) {
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SNEAKING));
/*      */       } 
/*      */     } 
/*      */     if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindRight()))
/*      */       MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false); 
/*      */     if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindLeft()))
/*      */       MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false); 
/*      */     if (((Boolean)this.autoTimer.get()).booleanValue()) {
/*      */       if (Retreat.INSTANCE.getModuleManager().getModule(Timer.class) == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.Timer"); 
/*      */       Timer timer = (Timer)Retreat.INSTANCE.getModuleManager().getModule(Timer.class);
/*      */       timer.setState(false);
/*      */     } 
/*      */     this.lockRotation = (Rotation)null;
/*      */     this.limitedRotation = (Rotation)null;
/*      */     this.facesBlock = false;
/*      */     MinecraftInstance.mc.getTimer().setTimerSpeed(1.0F);
/*      */     this.shouldGoDown = false;
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (this.slot != MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/*      */     } 
/*      */   }
/*      */   
/*      */   @EventTarget
/*      */   public final void onMove(@NotNull MoveEvent event) {
/*      */     Intrinsics.checkParameterIsNotNull(event, "event");
/*      */     if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown)
/*      */       return; 
/*      */     if (!((Boolean)this.airSafeValue.get()).booleanValue()) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/*      */         event.setSafeWalk(true);
/*      */         return;
/*      */       } 
/*      */       return;
/*      */     } 
/*      */     event.setSafeWalk(true);
/*      */   }
/*      */   
/*      */   @EventTarget
/*      */   public final void onRender2D(@Nullable Render2DEvent event) {
/*      */     if (((Boolean)this.counterDisplayValue.get()).booleanValue()) {
/*      */       int blockSlot = InventoryUtils.findAutoBlockBlock();
/*      */       if (blockSlot == -1)
/*      */         return; 
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(blockSlot).getStack();
/*      */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");
/*      */       IScaledResolution res = MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc);
/*      */       GL11.glPushMatrix();
/*      */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */       RenderHelper.func_74520_c();
/*      */       GlStateManager.func_179094_E();
/*      */       GlStateManager.func_179118_c();
/*      */       GlStateManager.func_179086_m(256);
/*      */       MinecraftInstance.mc.getRenderItem().setZLevel(-150.0F);
/*      */       if (itemStack == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       MinecraftInstance.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, res.getScaledWidth() / 2 - 17, res.getScaledHeight() / 2 + 11);
/*      */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE");
/*      */       Fonts.font40.drawStringWithShadow(String.valueOf(getBlocksAmount()), res.getScaledWidth() / 2 + 5, res.getScaledHeight() / 2 + 16, Color.WHITE.getRGB());
/*      */       MinecraftInstance.mc.getRenderItem().setZLevel(0.0F);
/*      */       GlStateManager.func_179084_k();
/*      */       GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/*      */       GlStateManager.func_179097_i();
/*      */       GlStateManager.func_179140_f();
/*      */       GlStateManager.func_179126_j();
/*      */       GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
/*      */       GlStateManager.func_179141_d();
/*      */       GlStateManager.func_179121_F();
/*      */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */   
/*      */   private final boolean search(WBlockPos blockPosition, boolean checks) {
/*      */     // Byte code:
/*      */     //   0: iconst_0
/*      */     //   1: istore_3
/*      */     //   2: aload_1
/*      */     //   3: invokestatic getMaterial : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;
/*      */     //   6: dup
/*      */     //   7: ifnull -> 18
/*      */     //   10: invokeinterface isReplaceable : ()Z
/*      */     //   15: goto -> 20
/*      */     //   18: pop
/*      */     //   19: iconst_0
/*      */     //   20: ifne -> 25
/*      */     //   23: iconst_0
/*      */     //   24: ireturn
/*      */     //   25: aload_0
/*      */     //   26: getfield rotationModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   29: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   32: checkcast java/lang/String
/*      */     //   35: ldc_w 'Static'
/*      */     //   38: iconst_1
/*      */     //   39: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   42: istore_3
/*      */     //   43: iload_3
/*      */     //   44: ifne -> 67
/*      */     //   47: aload_0
/*      */     //   48: getfield rotationModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   51: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   54: checkcast java/lang/String
/*      */     //   57: ldc_w 'StaticPitch'
/*      */     //   60: iconst_1
/*      */     //   61: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   64: ifeq -> 71
/*      */     //   67: iconst_1
/*      */     //   68: goto -> 72
/*      */     //   71: iconst_0
/*      */     //   72: istore #4
/*      */     //   74: iload_3
/*      */     //   75: ifne -> 98
/*      */     //   78: aload_0
/*      */     //   79: getfield rotationModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   82: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   85: checkcast java/lang/String
/*      */     //   88: ldc_w 'StaticYaw'
/*      */     //   91: iconst_1
/*      */     //   92: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   95: ifeq -> 102
/*      */     //   98: iconst_1
/*      */     //   99: goto -> 103
/*      */     //   102: iconst_0
/*      */     //   103: istore #5
/*      */     //   105: aload_0
/*      */     //   106: getfield staticPitchValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   109: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   112: checkcast java/lang/Number
/*      */     //   115: invokevirtual floatValue : ()F
/*      */     //   118: fstore #6
/*      */     //   120: aload_0
/*      */     //   121: getfield staticYawOffsetValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   124: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   127: checkcast java/lang/Number
/*      */     //   130: invokevirtual floatValue : ()F
/*      */     //   133: fstore #7
/*      */     //   135: aload_0
/*      */     //   136: getfield xzRangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   139: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   142: checkcast java/lang/Number
/*      */     //   145: invokevirtual floatValue : ()F
/*      */     //   148: f2d
/*      */     //   149: dstore #8
/*      */     //   151: aload_0
/*      */     //   152: dload #8
/*      */     //   154: invokespecial calcStepSize : (D)D
/*      */     //   157: dstore #10
/*      */     //   159: aload_0
/*      */     //   160: getfield yRangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   163: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   166: checkcast java/lang/Number
/*      */     //   169: invokevirtual floatValue : ()F
/*      */     //   172: f2d
/*      */     //   173: dstore #12
/*      */     //   175: aload_0
/*      */     //   176: dload #12
/*      */     //   178: invokespecial calcStepSize : (D)D
/*      */     //   181: dstore #14
/*      */     //   183: dconst_0
/*      */     //   184: dstore #16
/*      */     //   186: dconst_0
/*      */     //   187: dstore #18
/*      */     //   189: dconst_0
/*      */     //   190: dstore #20
/*      */     //   192: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   195: dup
/*      */     //   196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   199: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   204: dup
/*      */     //   205: ifnonnull -> 211
/*      */     //   208: invokestatic throwNpe : ()V
/*      */     //   211: invokeinterface getPosX : ()D
/*      */     //   216: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   219: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   224: dup
/*      */     //   225: ifnonnull -> 231
/*      */     //   228: invokestatic throwNpe : ()V
/*      */     //   231: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   236: invokeinterface getMinY : ()D
/*      */     //   241: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   244: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   249: dup
/*      */     //   250: ifnonnull -> 256
/*      */     //   253: invokestatic throwNpe : ()V
/*      */     //   256: invokeinterface getEyeHeight : ()F
/*      */     //   261: f2d
/*      */     //   262: dadd
/*      */     //   263: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   266: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   271: dup
/*      */     //   272: ifnonnull -> 278
/*      */     //   275: invokestatic throwNpe : ()V
/*      */     //   278: invokeinterface getPosZ : ()D
/*      */     //   283: invokespecial <init> : (DDD)V
/*      */     //   286: astore #22
/*      */     //   288: aconst_null
/*      */     //   289: checkcast net/ccbluex/liquidbounce/utils/PlaceRotation
/*      */     //   292: astore #23
/*      */     //   294: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   297: astore #26
/*      */     //   299: aload #26
/*      */     //   301: arraylength
/*      */     //   302: istore #27
/*      */     //   304: iconst_0
/*      */     //   305: istore #25
/*      */     //   307: iload #25
/*      */     //   309: iload #27
/*      */     //   311: if_icmpge -> 1366
/*      */     //   314: aload #26
/*      */     //   316: iload #25
/*      */     //   318: aaload
/*      */     //   319: astore #24
/*      */     //   321: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   324: aload #24
/*      */     //   326: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   331: astore #28
/*      */     //   333: aload_1
/*      */     //   334: aload #28
/*      */     //   336: iconst_0
/*      */     //   337: iconst_2
/*      */     //   338: aconst_null
/*      */     //   339: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   342: astore #29
/*      */     //   344: aload #29
/*      */     //   346: invokestatic canBeClicked : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Z
/*      */     //   349: ifne -> 355
/*      */     //   352: goto -> 1360
/*      */     //   355: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   358: dup
/*      */     //   359: aload #28
/*      */     //   361: invokeinterface getDirectionVec : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;
/*      */     //   366: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*      */     //   369: astore #30
/*      */     //   371: ldc2_w 0.5
/*      */     //   374: dload #8
/*      */     //   376: iconst_2
/*      */     //   377: i2d
/*      */     //   378: ddiv
/*      */     //   379: dsub
/*      */     //   380: dstore #31
/*      */     //   382: dload #31
/*      */     //   384: ldc2_w 0.5
/*      */     //   387: dload #8
/*      */     //   389: iconst_2
/*      */     //   390: i2d
/*      */     //   391: ddiv
/*      */     //   392: dadd
/*      */     //   393: dcmpg
/*      */     //   394: ifgt -> 1360
/*      */     //   397: ldc2_w 0.5
/*      */     //   400: dload #12
/*      */     //   402: iconst_2
/*      */     //   403: i2d
/*      */     //   404: ddiv
/*      */     //   405: dsub
/*      */     //   406: dstore #33
/*      */     //   408: dload #33
/*      */     //   410: ldc2_w 0.5
/*      */     //   413: dload #12
/*      */     //   415: iconst_2
/*      */     //   416: i2d
/*      */     //   417: ddiv
/*      */     //   418: dadd
/*      */     //   419: dcmpg
/*      */     //   420: ifgt -> 1350
/*      */     //   423: ldc2_w 0.5
/*      */     //   426: dload #8
/*      */     //   428: iconst_2
/*      */     //   429: i2d
/*      */     //   430: ddiv
/*      */     //   431: dsub
/*      */     //   432: dstore #35
/*      */     //   434: dload #35
/*      */     //   436: ldc2_w 0.5
/*      */     //   439: dload #8
/*      */     //   441: iconst_2
/*      */     //   442: i2d
/*      */     //   443: ddiv
/*      */     //   444: dadd
/*      */     //   445: dcmpg
/*      */     //   446: ifgt -> 1340
/*      */     //   449: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   452: dup
/*      */     //   453: aload_1
/*      */     //   454: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WVec3i
/*      */     //   457: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*      */     //   460: astore #38
/*      */     //   462: iconst_0
/*      */     //   463: istore #39
/*      */     //   465: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   468: dup
/*      */     //   469: aload #38
/*      */     //   471: invokevirtual getXCoord : ()D
/*      */     //   474: dload #31
/*      */     //   476: dadd
/*      */     //   477: aload #38
/*      */     //   479: invokevirtual getYCoord : ()D
/*      */     //   482: dload #33
/*      */     //   484: dadd
/*      */     //   485: aload #38
/*      */     //   487: invokevirtual getZCoord : ()D
/*      */     //   490: dload #35
/*      */     //   492: dadd
/*      */     //   493: invokespecial <init> : (DDD)V
/*      */     //   496: astore #37
/*      */     //   498: aload #22
/*      */     //   500: astore #40
/*      */     //   502: iconst_0
/*      */     //   503: istore #41
/*      */     //   505: aload #37
/*      */     //   507: invokevirtual getXCoord : ()D
/*      */     //   510: aload #40
/*      */     //   512: invokevirtual getXCoord : ()D
/*      */     //   515: dsub
/*      */     //   516: dstore #42
/*      */     //   518: aload #37
/*      */     //   520: invokevirtual getYCoord : ()D
/*      */     //   523: aload #40
/*      */     //   525: invokevirtual getYCoord : ()D
/*      */     //   528: dsub
/*      */     //   529: dstore #44
/*      */     //   531: aload #37
/*      */     //   533: invokevirtual getZCoord : ()D
/*      */     //   536: aload #40
/*      */     //   538: invokevirtual getZCoord : ()D
/*      */     //   541: dsub
/*      */     //   542: dstore #46
/*      */     //   544: dload #42
/*      */     //   546: dload #42
/*      */     //   548: dmul
/*      */     //   549: dload #44
/*      */     //   551: dload #44
/*      */     //   553: dmul
/*      */     //   554: dadd
/*      */     //   555: dload #46
/*      */     //   557: dload #46
/*      */     //   559: dmul
/*      */     //   560: dadd
/*      */     //   561: dstore #38
/*      */     //   563: aload #37
/*      */     //   565: astore #41
/*      */     //   567: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   570: dup
/*      */     //   571: aload #30
/*      */     //   573: invokevirtual getXCoord : ()D
/*      */     //   576: ldc2_w 0.5
/*      */     //   579: dmul
/*      */     //   580: aload #30
/*      */     //   582: invokevirtual getYCoord : ()D
/*      */     //   585: ldc2_w 0.5
/*      */     //   588: dmul
/*      */     //   589: aload #30
/*      */     //   591: invokevirtual getZCoord : ()D
/*      */     //   594: ldc2_w 0.5
/*      */     //   597: dmul
/*      */     //   598: invokespecial <init> : (DDD)V
/*      */     //   601: astore #42
/*      */     //   603: iconst_0
/*      */     //   604: istore #43
/*      */     //   606: aload #41
/*      */     //   608: astore #44
/*      */     //   610: aload #42
/*      */     //   612: invokevirtual getXCoord : ()D
/*      */     //   615: dstore #45
/*      */     //   617: aload #42
/*      */     //   619: invokevirtual getYCoord : ()D
/*      */     //   622: dstore #47
/*      */     //   624: aload #42
/*      */     //   626: invokevirtual getZCoord : ()D
/*      */     //   629: dstore #49
/*      */     //   631: iconst_0
/*      */     //   632: istore #51
/*      */     //   634: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   637: dup
/*      */     //   638: aload #44
/*      */     //   640: invokevirtual getXCoord : ()D
/*      */     //   643: dload #45
/*      */     //   645: dadd
/*      */     //   646: aload #44
/*      */     //   648: invokevirtual getYCoord : ()D
/*      */     //   651: dload #47
/*      */     //   653: dadd
/*      */     //   654: aload #44
/*      */     //   656: invokevirtual getZCoord : ()D
/*      */     //   659: dload #49
/*      */     //   661: dadd
/*      */     //   662: invokespecial <init> : (DDD)V
/*      */     //   665: nop
/*      */     //   666: astore #40
/*      */     //   668: iload_2
/*      */     //   669: ifeq -> 936
/*      */     //   672: aload #22
/*      */     //   674: astore #41
/*      */     //   676: iconst_0
/*      */     //   677: istore #42
/*      */     //   679: aload #40
/*      */     //   681: invokevirtual getXCoord : ()D
/*      */     //   684: aload #41
/*      */     //   686: invokevirtual getXCoord : ()D
/*      */     //   689: dsub
/*      */     //   690: dstore #43
/*      */     //   692: aload #40
/*      */     //   694: invokevirtual getYCoord : ()D
/*      */     //   697: aload #41
/*      */     //   699: invokevirtual getYCoord : ()D
/*      */     //   702: dsub
/*      */     //   703: dstore #45
/*      */     //   705: aload #40
/*      */     //   707: invokevirtual getZCoord : ()D
/*      */     //   710: aload #41
/*      */     //   712: invokevirtual getZCoord : ()D
/*      */     //   715: dsub
/*      */     //   716: dstore #47
/*      */     //   718: dload #43
/*      */     //   720: dload #43
/*      */     //   722: dmul
/*      */     //   723: dload #45
/*      */     //   725: dload #45
/*      */     //   727: dmul
/*      */     //   728: dadd
/*      */     //   729: dload #47
/*      */     //   731: dload #47
/*      */     //   733: dmul
/*      */     //   734: dadd
/*      */     //   735: ldc2_w 18.0
/*      */     //   738: dcmpl
/*      */     //   739: ifgt -> 926
/*      */     //   742: dload #38
/*      */     //   744: aload #22
/*      */     //   746: astore #41
/*      */     //   748: aload #37
/*      */     //   750: astore #42
/*      */     //   752: dstore #63
/*      */     //   754: iconst_0
/*      */     //   755: istore #43
/*      */     //   757: aload #42
/*      */     //   759: astore #44
/*      */     //   761: aload #30
/*      */     //   763: invokevirtual getXCoord : ()D
/*      */     //   766: dstore #45
/*      */     //   768: aload #30
/*      */     //   770: invokevirtual getYCoord : ()D
/*      */     //   773: dstore #47
/*      */     //   775: aload #30
/*      */     //   777: invokevirtual getZCoord : ()D
/*      */     //   780: dstore #49
/*      */     //   782: iconst_0
/*      */     //   783: istore #51
/*      */     //   785: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   788: dup
/*      */     //   789: aload #44
/*      */     //   791: invokevirtual getXCoord : ()D
/*      */     //   794: dload #45
/*      */     //   796: dadd
/*      */     //   797: aload #44
/*      */     //   799: invokevirtual getYCoord : ()D
/*      */     //   802: dload #47
/*      */     //   804: dadd
/*      */     //   805: aload #44
/*      */     //   807: invokevirtual getZCoord : ()D
/*      */     //   810: dload #49
/*      */     //   812: dadd
/*      */     //   813: invokespecial <init> : (DDD)V
/*      */     //   816: nop
/*      */     //   817: astore #65
/*      */     //   819: dload #63
/*      */     //   821: aload #65
/*      */     //   823: astore #42
/*      */     //   825: dstore #63
/*      */     //   827: iconst_0
/*      */     //   828: istore #43
/*      */     //   830: aload #42
/*      */     //   832: invokevirtual getXCoord : ()D
/*      */     //   835: aload #41
/*      */     //   837: invokevirtual getXCoord : ()D
/*      */     //   840: dsub
/*      */     //   841: dstore #44
/*      */     //   843: aload #42
/*      */     //   845: invokevirtual getYCoord : ()D
/*      */     //   848: aload #41
/*      */     //   850: invokevirtual getYCoord : ()D
/*      */     //   853: dsub
/*      */     //   854: dstore #46
/*      */     //   856: aload #42
/*      */     //   858: invokevirtual getZCoord : ()D
/*      */     //   861: aload #41
/*      */     //   863: invokevirtual getZCoord : ()D
/*      */     //   866: dsub
/*      */     //   867: dstore #48
/*      */     //   869: dload #44
/*      */     //   871: dload #44
/*      */     //   873: dmul
/*      */     //   874: dload #46
/*      */     //   876: dload #46
/*      */     //   878: dmul
/*      */     //   879: dadd
/*      */     //   880: dload #48
/*      */     //   882: dload #48
/*      */     //   884: dmul
/*      */     //   885: dadd
/*      */     //   886: dstore #65
/*      */     //   888: dload #63
/*      */     //   890: dload #65
/*      */     //   892: dcmpl
/*      */     //   893: ifgt -> 926
/*      */     //   896: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   899: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   904: dup
/*      */     //   905: ifnonnull -> 911
/*      */     //   908: invokestatic throwNpe : ()V
/*      */     //   911: aload #22
/*      */     //   913: aload #40
/*      */     //   915: iconst_0
/*      */     //   916: iconst_1
/*      */     //   917: iconst_0
/*      */     //   918: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*      */     //   923: ifnull -> 936
/*      */     //   926: dload #35
/*      */     //   928: dload #10
/*      */     //   930: dadd
/*      */     //   931: dstore #35
/*      */     //   933: goto -> 434
/*      */     //   936: iconst_0
/*      */     //   937: istore #41
/*      */     //   939: iload #5
/*      */     //   941: ifeq -> 948
/*      */     //   944: iconst_2
/*      */     //   945: goto -> 949
/*      */     //   948: iconst_1
/*      */     //   949: istore #42
/*      */     //   951: iload #41
/*      */     //   953: iload #42
/*      */     //   955: if_icmpge -> 1330
/*      */     //   958: iload #5
/*      */     //   960: ifeq -> 972
/*      */     //   963: iload #41
/*      */     //   965: ifne -> 972
/*      */     //   968: dconst_0
/*      */     //   969: goto -> 983
/*      */     //   972: aload #40
/*      */     //   974: invokevirtual getXCoord : ()D
/*      */     //   977: aload #22
/*      */     //   979: invokevirtual getXCoord : ()D
/*      */     //   982: dsub
/*      */     //   983: dstore #43
/*      */     //   985: aload #40
/*      */     //   987: invokevirtual getYCoord : ()D
/*      */     //   990: aload #22
/*      */     //   992: invokevirtual getYCoord : ()D
/*      */     //   995: dsub
/*      */     //   996: dstore #45
/*      */     //   998: iload #5
/*      */     //   1000: ifeq -> 1013
/*      */     //   1003: iload #41
/*      */     //   1005: iconst_1
/*      */     //   1006: if_icmpne -> 1013
/*      */     //   1009: dconst_0
/*      */     //   1010: goto -> 1024
/*      */     //   1013: aload #40
/*      */     //   1015: invokevirtual getZCoord : ()D
/*      */     //   1018: aload #22
/*      */     //   1020: invokevirtual getZCoord : ()D
/*      */     //   1023: dsub
/*      */     //   1024: dstore #47
/*      */     //   1026: dload #43
/*      */     //   1028: dload #43
/*      */     //   1030: dmul
/*      */     //   1031: dload #47
/*      */     //   1033: dload #47
/*      */     //   1035: dmul
/*      */     //   1036: dadd
/*      */     //   1037: invokestatic sqrt : (D)D
/*      */     //   1040: dstore #49
/*      */     //   1042: iload #4
/*      */     //   1044: ifeq -> 1052
/*      */     //   1047: fload #6
/*      */     //   1049: goto -> 1067
/*      */     //   1052: dload #45
/*      */     //   1054: dload #49
/*      */     //   1056: invokestatic atan2 : (DD)D
/*      */     //   1059: invokestatic toDegrees : (D)D
/*      */     //   1062: d2f
/*      */     //   1063: fneg
/*      */     //   1064: invokestatic wrapAngleTo180_float : (F)F
/*      */     //   1067: fstore #51
/*      */     //   1069: new net/ccbluex/liquidbounce/utils/Rotation
/*      */     //   1072: dup
/*      */     //   1073: dload #47
/*      */     //   1075: dload #43
/*      */     //   1077: invokestatic atan2 : (DD)D
/*      */     //   1080: invokestatic toDegrees : (D)D
/*      */     //   1083: d2f
/*      */     //   1084: ldc_w 90.0
/*      */     //   1087: fsub
/*      */     //   1088: iload #5
/*      */     //   1090: ifeq -> 1098
/*      */     //   1093: fload #7
/*      */     //   1095: goto -> 1099
/*      */     //   1098: fconst_0
/*      */     //   1099: fadd
/*      */     //   1100: invokestatic wrapAngleTo180_float : (F)F
/*      */     //   1103: fload #51
/*      */     //   1105: invokespecial <init> : (FF)V
/*      */     //   1108: astore #52
/*      */     //   1110: aload #52
/*      */     //   1112: invokestatic getVectorForRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1115: astore #53
/*      */     //   1117: aload #22
/*      */     //   1119: astore #55
/*      */     //   1121: aload #53
/*      */     //   1123: invokevirtual getXCoord : ()D
/*      */     //   1126: iconst_4
/*      */     //   1127: i2d
/*      */     //   1128: dmul
/*      */     //   1129: dstore #56
/*      */     //   1131: aload #53
/*      */     //   1133: invokevirtual getYCoord : ()D
/*      */     //   1136: iconst_4
/*      */     //   1137: i2d
/*      */     //   1138: dmul
/*      */     //   1139: dstore #58
/*      */     //   1141: aload #53
/*      */     //   1143: invokevirtual getZCoord : ()D
/*      */     //   1146: iconst_4
/*      */     //   1147: i2d
/*      */     //   1148: dmul
/*      */     //   1149: dstore #60
/*      */     //   1151: iconst_0
/*      */     //   1152: istore #62
/*      */     //   1154: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1157: dup
/*      */     //   1158: aload #55
/*      */     //   1160: invokevirtual getXCoord : ()D
/*      */     //   1163: dload #56
/*      */     //   1165: dadd
/*      */     //   1166: aload #55
/*      */     //   1168: invokevirtual getYCoord : ()D
/*      */     //   1171: dload #58
/*      */     //   1173: dadd
/*      */     //   1174: aload #55
/*      */     //   1176: invokevirtual getZCoord : ()D
/*      */     //   1179: dload #60
/*      */     //   1181: dadd
/*      */     //   1182: invokespecial <init> : (DDD)V
/*      */     //   1185: astore #54
/*      */     //   1187: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1190: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   1195: dup
/*      */     //   1196: ifnonnull -> 1202
/*      */     //   1199: invokestatic throwNpe : ()V
/*      */     //   1202: aload #22
/*      */     //   1204: aload #54
/*      */     //   1206: iconst_0
/*      */     //   1207: iconst_0
/*      */     //   1208: iconst_1
/*      */     //   1209: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*      */     //   1214: astore #55
/*      */     //   1216: aload #55
/*      */     //   1218: dup
/*      */     //   1219: ifnonnull -> 1225
/*      */     //   1222: invokestatic throwNpe : ()V
/*      */     //   1225: invokeinterface getTypeOfHit : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;
/*      */     //   1230: getstatic net/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType.BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;
/*      */     //   1233: if_acmpne -> 1258
/*      */     //   1236: aload #55
/*      */     //   1238: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   1243: dup
/*      */     //   1244: ifnonnull -> 1250
/*      */     //   1247: invokestatic throwNpe : ()V
/*      */     //   1250: aload #29
/*      */     //   1252: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1255: ifne -> 1261
/*      */     //   1258: goto -> 1324
/*      */     //   1261: aload #23
/*      */     //   1263: ifnull -> 1283
/*      */     //   1266: aload #52
/*      */     //   1268: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/utils/Rotation;)D
/*      */     //   1271: aload #23
/*      */     //   1273: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1276: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/utils/Rotation;)D
/*      */     //   1279: dcmpg
/*      */     //   1280: ifge -> 1312
/*      */     //   1283: new net/ccbluex/liquidbounce/utils/PlaceRotation
/*      */     //   1286: dup
/*      */     //   1287: new net/ccbluex/liquidbounce/utils/block/PlaceInfo
/*      */     //   1290: dup
/*      */     //   1291: aload #29
/*      */     //   1293: aload #28
/*      */     //   1295: invokeinterface getOpposite : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   1300: aload #40
/*      */     //   1302: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;)V
/*      */     //   1305: aload #52
/*      */     //   1307: invokespecial <init> : (Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;Lnet/ccbluex/liquidbounce/utils/Rotation;)V
/*      */     //   1310: astore #23
/*      */     //   1312: dload #31
/*      */     //   1314: dstore #16
/*      */     //   1316: dload #33
/*      */     //   1318: dstore #18
/*      */     //   1320: dload #35
/*      */     //   1322: dstore #20
/*      */     //   1324: iinc #41, 1
/*      */     //   1327: goto -> 951
/*      */     //   1330: dload #35
/*      */     //   1332: dload #10
/*      */     //   1334: dadd
/*      */     //   1335: dstore #35
/*      */     //   1337: goto -> 434
/*      */     //   1340: dload #33
/*      */     //   1342: dload #14
/*      */     //   1344: dadd
/*      */     //   1345: dstore #33
/*      */     //   1347: goto -> 408
/*      */     //   1350: dload #31
/*      */     //   1352: dload #10
/*      */     //   1354: dadd
/*      */     //   1355: dstore #31
/*      */     //   1357: goto -> 382
/*      */     //   1360: iinc #25, 1
/*      */     //   1363: goto -> 307
/*      */     //   1366: aload #23
/*      */     //   1368: ifnonnull -> 1373
/*      */     //   1371: iconst_0
/*      */     //   1372: ireturn
/*      */     //   1373: aload_0
/*      */     //   1374: getfield rotationModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1377: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1380: checkcast java/lang/String
/*      */     //   1383: ldc_w 'Off'
/*      */     //   1386: iconst_1
/*      */     //   1387: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   1390: ifne -> 2277
/*      */     //   1393: aload_0
/*      */     //   1394: getfield minTurnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1397: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1400: checkcast java/lang/Number
/*      */     //   1403: invokevirtual floatValue : ()F
/*      */     //   1406: sipush #180
/*      */     //   1409: i2f
/*      */     //   1410: fcmpg
/*      */     //   1411: ifge -> 2241
/*      */     //   1414: aload_0
/*      */     //   1415: getstatic net/ccbluex/liquidbounce/utils/RotationUtils.serverRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1418: aload #23
/*      */     //   1420: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1423: invokestatic random : ()D
/*      */     //   1426: aload_0
/*      */     //   1427: getfield maxTurnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1430: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1433: checkcast java/lang/Number
/*      */     //   1436: invokevirtual floatValue : ()F
/*      */     //   1439: aload_0
/*      */     //   1440: getfield minTurnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1443: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1446: checkcast java/lang/Number
/*      */     //   1449: invokevirtual floatValue : ()F
/*      */     //   1452: fsub
/*      */     //   1453: f2d
/*      */     //   1454: dmul
/*      */     //   1455: aload_0
/*      */     //   1456: getfield minTurnSpeedValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1459: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1462: checkcast java/lang/Number
/*      */     //   1465: invokevirtual doubleValue : ()D
/*      */     //   1468: dadd
/*      */     //   1469: d2f
/*      */     //   1470: invokestatic limitAngleChange : (Lnet/ccbluex/liquidbounce/utils/Rotation;Lnet/ccbluex/liquidbounce/utils/Rotation;F)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1473: putfield limitedRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1476: aload_0
/*      */     //   1477: aload_0
/*      */     //   1478: getfield limitedRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1481: dup
/*      */     //   1482: ifnonnull -> 1488
/*      */     //   1485: invokestatic throwNpe : ()V
/*      */     //   1488: aload_0
/*      */     //   1489: getfield keepLengthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1492: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1495: checkcast java/lang/Number
/*      */     //   1498: invokevirtual intValue : ()I
/*      */     //   1501: invokespecial setRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;I)V
/*      */     //   1504: aload_0
/*      */     //   1505: aload_0
/*      */     //   1506: getfield limitedRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1509: putfield lockRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1512: aload_0
/*      */     //   1513: iconst_0
/*      */     //   1514: putfield facesBlock : Z
/*      */     //   1517: invokestatic values : ()[Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   1520: astore #26
/*      */     //   1522: aload #26
/*      */     //   1524: arraylength
/*      */     //   1525: istore #27
/*      */     //   1527: iconst_0
/*      */     //   1528: istore #25
/*      */     //   1530: iload #25
/*      */     //   1532: iload #27
/*      */     //   1534: if_icmpge -> 2277
/*      */     //   1537: aload #26
/*      */     //   1539: iload #25
/*      */     //   1541: aaload
/*      */     //   1542: astore #24
/*      */     //   1544: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1547: aload #24
/*      */     //   1549: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   1554: astore #28
/*      */     //   1556: aload_1
/*      */     //   1557: aload #28
/*      */     //   1559: iconst_0
/*      */     //   1560: iconst_2
/*      */     //   1561: aconst_null
/*      */     //   1562: invokestatic offset$default : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;IILjava/lang/Object;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   1565: astore #29
/*      */     //   1567: aload #29
/*      */     //   1569: invokestatic canBeClicked : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;)Z
/*      */     //   1572: ifne -> 1578
/*      */     //   1575: goto -> 2235
/*      */     //   1578: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1581: dup
/*      */     //   1582: aload #28
/*      */     //   1584: invokeinterface getDirectionVec : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;
/*      */     //   1589: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*      */     //   1592: astore #30
/*      */     //   1594: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1597: dup
/*      */     //   1598: aload_1
/*      */     //   1599: checkcast net/ccbluex/liquidbounce/api/minecraft/util/WVec3i
/*      */     //   1602: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3i;)V
/*      */     //   1605: astore #32
/*      */     //   1607: iconst_0
/*      */     //   1608: istore #33
/*      */     //   1610: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1613: dup
/*      */     //   1614: aload #32
/*      */     //   1616: invokevirtual getXCoord : ()D
/*      */     //   1619: dload #16
/*      */     //   1621: dadd
/*      */     //   1622: aload #32
/*      */     //   1624: invokevirtual getYCoord : ()D
/*      */     //   1627: dload #18
/*      */     //   1629: dadd
/*      */     //   1630: aload #32
/*      */     //   1632: invokevirtual getZCoord : ()D
/*      */     //   1635: dload #20
/*      */     //   1637: dadd
/*      */     //   1638: invokespecial <init> : (DDD)V
/*      */     //   1641: astore #31
/*      */     //   1643: aload #22
/*      */     //   1645: astore #34
/*      */     //   1647: iconst_0
/*      */     //   1648: istore #35
/*      */     //   1650: aload #31
/*      */     //   1652: invokevirtual getXCoord : ()D
/*      */     //   1655: aload #34
/*      */     //   1657: invokevirtual getXCoord : ()D
/*      */     //   1660: dsub
/*      */     //   1661: dstore #36
/*      */     //   1663: aload #31
/*      */     //   1665: invokevirtual getYCoord : ()D
/*      */     //   1668: aload #34
/*      */     //   1670: invokevirtual getYCoord : ()D
/*      */     //   1673: dsub
/*      */     //   1674: dstore #38
/*      */     //   1676: aload #31
/*      */     //   1678: invokevirtual getZCoord : ()D
/*      */     //   1681: aload #34
/*      */     //   1683: invokevirtual getZCoord : ()D
/*      */     //   1686: dsub
/*      */     //   1687: dstore #40
/*      */     //   1689: dload #36
/*      */     //   1691: dload #36
/*      */     //   1693: dmul
/*      */     //   1694: dload #38
/*      */     //   1696: dload #38
/*      */     //   1698: dmul
/*      */     //   1699: dadd
/*      */     //   1700: dload #40
/*      */     //   1702: dload #40
/*      */     //   1704: dmul
/*      */     //   1705: dadd
/*      */     //   1706: dstore #32
/*      */     //   1708: aload #31
/*      */     //   1710: astore #35
/*      */     //   1712: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1715: dup
/*      */     //   1716: aload #30
/*      */     //   1718: invokevirtual getXCoord : ()D
/*      */     //   1721: ldc2_w 0.5
/*      */     //   1724: dmul
/*      */     //   1725: aload #30
/*      */     //   1727: invokevirtual getYCoord : ()D
/*      */     //   1730: ldc2_w 0.5
/*      */     //   1733: dmul
/*      */     //   1734: aload #30
/*      */     //   1736: invokevirtual getZCoord : ()D
/*      */     //   1739: ldc2_w 0.5
/*      */     //   1742: dmul
/*      */     //   1743: invokespecial <init> : (DDD)V
/*      */     //   1746: astore #36
/*      */     //   1748: iconst_0
/*      */     //   1749: istore #37
/*      */     //   1751: aload #35
/*      */     //   1753: astore #38
/*      */     //   1755: aload #36
/*      */     //   1757: invokevirtual getXCoord : ()D
/*      */     //   1760: dstore #39
/*      */     //   1762: aload #36
/*      */     //   1764: invokevirtual getYCoord : ()D
/*      */     //   1767: dstore #41
/*      */     //   1769: aload #36
/*      */     //   1771: invokevirtual getZCoord : ()D
/*      */     //   1774: dstore #43
/*      */     //   1776: iconst_0
/*      */     //   1777: istore #45
/*      */     //   1779: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1782: dup
/*      */     //   1783: aload #38
/*      */     //   1785: invokevirtual getXCoord : ()D
/*      */     //   1788: dload #39
/*      */     //   1790: dadd
/*      */     //   1791: aload #38
/*      */     //   1793: invokevirtual getYCoord : ()D
/*      */     //   1796: dload #41
/*      */     //   1798: dadd
/*      */     //   1799: aload #38
/*      */     //   1801: invokevirtual getZCoord : ()D
/*      */     //   1804: dload #43
/*      */     //   1806: dadd
/*      */     //   1807: invokespecial <init> : (DDD)V
/*      */     //   1810: nop
/*      */     //   1811: astore #34
/*      */     //   1813: iload_2
/*      */     //   1814: ifeq -> 2074
/*      */     //   1817: aload #22
/*      */     //   1819: astore #35
/*      */     //   1821: iconst_0
/*      */     //   1822: istore #36
/*      */     //   1824: aload #34
/*      */     //   1826: invokevirtual getXCoord : ()D
/*      */     //   1829: aload #35
/*      */     //   1831: invokevirtual getXCoord : ()D
/*      */     //   1834: dsub
/*      */     //   1835: dstore #37
/*      */     //   1837: aload #34
/*      */     //   1839: invokevirtual getYCoord : ()D
/*      */     //   1842: aload #35
/*      */     //   1844: invokevirtual getYCoord : ()D
/*      */     //   1847: dsub
/*      */     //   1848: dstore #39
/*      */     //   1850: aload #34
/*      */     //   1852: invokevirtual getZCoord : ()D
/*      */     //   1855: aload #35
/*      */     //   1857: invokevirtual getZCoord : ()D
/*      */     //   1860: dsub
/*      */     //   1861: dstore #41
/*      */     //   1863: dload #37
/*      */     //   1865: dload #37
/*      */     //   1867: dmul
/*      */     //   1868: dload #39
/*      */     //   1870: dload #39
/*      */     //   1872: dmul
/*      */     //   1873: dadd
/*      */     //   1874: dload #41
/*      */     //   1876: dload #41
/*      */     //   1878: dmul
/*      */     //   1879: dadd
/*      */     //   1880: ldc2_w 18.0
/*      */     //   1883: dcmpl
/*      */     //   1884: ifgt -> 2071
/*      */     //   1887: dload #32
/*      */     //   1889: aload #22
/*      */     //   1891: astore #35
/*      */     //   1893: aload #31
/*      */     //   1895: astore #36
/*      */     //   1897: dstore #63
/*      */     //   1899: iconst_0
/*      */     //   1900: istore #37
/*      */     //   1902: aload #36
/*      */     //   1904: astore #38
/*      */     //   1906: aload #30
/*      */     //   1908: invokevirtual getXCoord : ()D
/*      */     //   1911: dstore #39
/*      */     //   1913: aload #30
/*      */     //   1915: invokevirtual getYCoord : ()D
/*      */     //   1918: dstore #41
/*      */     //   1920: aload #30
/*      */     //   1922: invokevirtual getZCoord : ()D
/*      */     //   1925: dstore #43
/*      */     //   1927: iconst_0
/*      */     //   1928: istore #45
/*      */     //   1930: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   1933: dup
/*      */     //   1934: aload #38
/*      */     //   1936: invokevirtual getXCoord : ()D
/*      */     //   1939: dload #39
/*      */     //   1941: dadd
/*      */     //   1942: aload #38
/*      */     //   1944: invokevirtual getYCoord : ()D
/*      */     //   1947: dload #41
/*      */     //   1949: dadd
/*      */     //   1950: aload #38
/*      */     //   1952: invokevirtual getZCoord : ()D
/*      */     //   1955: dload #43
/*      */     //   1957: dadd
/*      */     //   1958: invokespecial <init> : (DDD)V
/*      */     //   1961: nop
/*      */     //   1962: astore #65
/*      */     //   1964: dload #63
/*      */     //   1966: aload #65
/*      */     //   1968: astore #36
/*      */     //   1970: dstore #63
/*      */     //   1972: iconst_0
/*      */     //   1973: istore #37
/*      */     //   1975: aload #36
/*      */     //   1977: invokevirtual getXCoord : ()D
/*      */     //   1980: aload #35
/*      */     //   1982: invokevirtual getXCoord : ()D
/*      */     //   1985: dsub
/*      */     //   1986: dstore #38
/*      */     //   1988: aload #36
/*      */     //   1990: invokevirtual getYCoord : ()D
/*      */     //   1993: aload #35
/*      */     //   1995: invokevirtual getYCoord : ()D
/*      */     //   1998: dsub
/*      */     //   1999: dstore #40
/*      */     //   2001: aload #36
/*      */     //   2003: invokevirtual getZCoord : ()D
/*      */     //   2006: aload #35
/*      */     //   2008: invokevirtual getZCoord : ()D
/*      */     //   2011: dsub
/*      */     //   2012: dstore #42
/*      */     //   2014: dload #38
/*      */     //   2016: dload #38
/*      */     //   2018: dmul
/*      */     //   2019: dload #40
/*      */     //   2021: dload #40
/*      */     //   2023: dmul
/*      */     //   2024: dadd
/*      */     //   2025: dload #42
/*      */     //   2027: dload #42
/*      */     //   2029: dmul
/*      */     //   2030: dadd
/*      */     //   2031: dstore #65
/*      */     //   2033: dload #63
/*      */     //   2035: dload #65
/*      */     //   2037: dcmpl
/*      */     //   2038: ifgt -> 2071
/*      */     //   2041: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2044: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   2049: dup
/*      */     //   2050: ifnonnull -> 2056
/*      */     //   2053: invokestatic throwNpe : ()V
/*      */     //   2056: aload #22
/*      */     //   2058: aload #34
/*      */     //   2060: iconst_0
/*      */     //   2061: iconst_1
/*      */     //   2062: iconst_0
/*      */     //   2063: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*      */     //   2068: ifnull -> 2074
/*      */     //   2071: goto -> 2235
/*      */     //   2074: aload_0
/*      */     //   2075: getfield limitedRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   2078: invokestatic getVectorForRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;)Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   2081: astore #35
/*      */     //   2083: aload #22
/*      */     //   2085: astore #37
/*      */     //   2087: aload #35
/*      */     //   2089: invokevirtual getXCoord : ()D
/*      */     //   2092: iconst_4
/*      */     //   2093: i2d
/*      */     //   2094: dmul
/*      */     //   2095: dstore #38
/*      */     //   2097: aload #35
/*      */     //   2099: invokevirtual getYCoord : ()D
/*      */     //   2102: iconst_4
/*      */     //   2103: i2d
/*      */     //   2104: dmul
/*      */     //   2105: dstore #40
/*      */     //   2107: aload #35
/*      */     //   2109: invokevirtual getZCoord : ()D
/*      */     //   2112: iconst_4
/*      */     //   2113: i2d
/*      */     //   2114: dmul
/*      */     //   2115: dstore #42
/*      */     //   2117: iconst_0
/*      */     //   2118: istore #44
/*      */     //   2120: new net/ccbluex/liquidbounce/api/minecraft/util/WVec3
/*      */     //   2123: dup
/*      */     //   2124: aload #37
/*      */     //   2126: invokevirtual getXCoord : ()D
/*      */     //   2129: dload #38
/*      */     //   2131: dadd
/*      */     //   2132: aload #37
/*      */     //   2134: invokevirtual getYCoord : ()D
/*      */     //   2137: dload #40
/*      */     //   2139: dadd
/*      */     //   2140: aload #37
/*      */     //   2142: invokevirtual getZCoord : ()D
/*      */     //   2145: dload #42
/*      */     //   2147: dadd
/*      */     //   2148: invokespecial <init> : (DDD)V
/*      */     //   2151: astore #36
/*      */     //   2153: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2156: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */     //   2161: dup
/*      */     //   2162: ifnonnull -> 2168
/*      */     //   2165: invokestatic throwNpe : ()V
/*      */     //   2168: aload #22
/*      */     //   2170: aload #36
/*      */     //   2172: iconst_0
/*      */     //   2173: iconst_0
/*      */     //   2174: iconst_1
/*      */     //   2175: invokeinterface rayTraceBlocks : (Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;ZZZ)Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*      */     //   2180: astore #37
/*      */     //   2182: aload #37
/*      */     //   2184: dup
/*      */     //   2185: ifnonnull -> 2191
/*      */     //   2188: invokestatic throwNpe : ()V
/*      */     //   2191: invokeinterface getTypeOfHit : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;
/*      */     //   2196: getstatic net/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType.BLOCK : Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition$WMovingObjectType;
/*      */     //   2199: if_acmpne -> 2224
/*      */     //   2202: aload #37
/*      */     //   2204: invokeinterface getBlockPos : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   2209: dup
/*      */     //   2210: ifnonnull -> 2216
/*      */     //   2213: invokestatic throwNpe : ()V
/*      */     //   2216: aload #29
/*      */     //   2218: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   2221: ifne -> 2227
/*      */     //   2224: goto -> 2235
/*      */     //   2227: aload_0
/*      */     //   2228: iconst_1
/*      */     //   2229: putfield facesBlock : Z
/*      */     //   2232: goto -> 2277
/*      */     //   2235: iinc #25, 1
/*      */     //   2238: goto -> 1530
/*      */     //   2241: aload_0
/*      */     //   2242: aload #23
/*      */     //   2244: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   2247: aload_0
/*      */     //   2248: getfield keepLengthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   2251: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2254: checkcast java/lang/Number
/*      */     //   2257: invokevirtual intValue : ()I
/*      */     //   2260: invokespecial setRotation : (Lnet/ccbluex/liquidbounce/utils/Rotation;I)V
/*      */     //   2263: aload_0
/*      */     //   2264: aload #23
/*      */     //   2266: invokevirtual getRotation : ()Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   2269: putfield lockRotation : Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   2272: aload_0
/*      */     //   2273: iconst_1
/*      */     //   2274: putfield facesBlock : Z
/*      */     //   2277: aload_0
/*      */     //   2278: aload #23
/*      */     //   2280: invokevirtual getPlaceInfo : ()Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   2283: putfield targetPlace : Lnet/ccbluex/liquidbounce/utils/block/PlaceInfo;
/*      */     //   2286: iconst_1
/*      */     //   2287: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #782	-> 0
/*      */     //   #1009	-> 2
/*      */     //   #1009	-> 18
/*      */     //   #782	-> 23
/*      */     //   #784	-> 25
/*      */     //   #785	-> 43
/*      */     //   #786	-> 74
/*      */     //   #787	-> 105
/*      */     //   #788	-> 120
/*      */     //   #791	-> 135
/*      */     //   #792	-> 151
/*      */     //   #793	-> 159
/*      */     //   #794	-> 175
/*      */     //   #795	-> 183
/*      */     //   #796	-> 186
/*      */     //   #797	-> 189
/*      */     //   #798	-> 192
/*      */     //   #799	-> 196
/*      */     //   #800	-> 216
/*      */     //   #801	-> 263
/*      */     //   #798	-> 283
/*      */     //   #803	-> 288
/*      */     //   #804	-> 294
/*      */     //   #805	-> 321
/*      */     //   #806	-> 333
/*      */     //   #807	-> 344
/*      */     //   #808	-> 355
/*      */     //   #809	-> 371
/*      */     //   #810	-> 382
/*      */     //   #811	-> 397
/*      */     //   #812	-> 408
/*      */     //   #813	-> 423
/*      */     //   #814	-> 434
/*      */     //   #815	-> 449
/*      */     //   #1010	-> 465
/*      */     //   #815	-> 496
/*      */     //   #816	-> 498
/*      */     //   #1011	-> 505
/*      */     //   #1012	-> 518
/*      */     //   #1013	-> 531
/*      */     //   #1015	-> 544
/*      */     //   #816	-> 561
/*      */     //   #817	-> 563
/*      */     //   #1016	-> 606
/*      */     //   #1017	-> 634
/*      */     //   #1016	-> 665
/*      */     //   #817	-> 666
/*      */     //   #818	-> 668
/*      */     //   #820	-> 668
/*      */     //   #818	-> 672
/*      */     //   #1018	-> 679
/*      */     //   #1019	-> 692
/*      */     //   #1020	-> 705
/*      */     //   #1022	-> 718
/*      */     //   #818	-> 744
/*      */     //   #819	-> 748
/*      */     //   #1023	-> 757
/*      */     //   #1024	-> 785
/*      */     //   #1023	-> 816
/*      */     //   #818	-> 825
/*      */     //   #1025	-> 830
/*      */     //   #1026	-> 843
/*      */     //   #1027	-> 856
/*      */     //   #1029	-> 869
/*      */     //   #820	-> 896
/*      */     //   #822	-> 926
/*      */     //   #823	-> 933
/*      */     //   #827	-> 936
/*      */     //   #828	-> 958
/*      */     //   #829	-> 985
/*      */     //   #830	-> 998
/*      */     //   #831	-> 1026
/*      */     //   #832	-> 1042
/*      */     //   #833	-> 1052
/*      */     //   #838	-> 1052
/*      */     //   #833	-> 1052
/*      */     //   #834	-> 1052
/*      */     //   #835	-> 1052
/*      */     //   #836	-> 1054
/*      */     //   #834	-> 1056
/*      */     //   #833	-> 1059
/*      */     //   #838	-> 1062
/*      */     //   #833	-> 1063
/*      */     //   #832	-> 1064
/*      */     //   #840	-> 1069
/*      */     //   #841	-> 1073
/*      */     //   #842	-> 1073
/*      */     //   #843	-> 1088
/*      */     //   #842	-> 1099
/*      */     //   #841	-> 1100
/*      */     //   #844	-> 1103
/*      */     //   #840	-> 1105
/*      */     //   #846	-> 1110
/*      */     //   #847	-> 1117
/*      */     //   #848	-> 1121
/*      */     //   #849	-> 1131
/*      */     //   #850	-> 1141
/*      */     //   #847	-> 1151
/*      */     //   #1030	-> 1154
/*      */     //   #847	-> 1185
/*      */     //   #852	-> 1187
/*      */     //   #853	-> 1216
/*      */     //   #854	-> 1250
/*      */     //   #853	-> 1252
/*      */     //   #856	-> 1258
/*      */     //   #857	-> 1261
/*      */     //   #858	-> 1271
/*      */     //   #857	-> 1276
/*      */     //   #861	-> 1283
/*      */     //   #863	-> 1312
/*      */     //   #864	-> 1316
/*      */     //   #865	-> 1320
/*      */     //   #827	-> 1324
/*      */     //   #867	-> 1330
/*      */     //   #814	-> 1337
/*      */     //   #869	-> 1340
/*      */     //   #812	-> 1347
/*      */     //   #871	-> 1350
/*      */     //   #810	-> 1357
/*      */     //   #804	-> 1360
/*      */     //   #874	-> 1366
/*      */     //   #875	-> 1373
/*      */     //   #876	-> 1393
/*      */     //   #877	-> 1414
/*      */     //   #878	-> 1415
/*      */     //   #879	-> 1418
/*      */     //   #880	-> 1423
/*      */     //   #877	-> 1470
/*      */     //   #882	-> 1476
/*      */     //   #883	-> 1504
/*      */     //   #884	-> 1512
/*      */     //   #885	-> 1517
/*      */     //   #886	-> 1544
/*      */     //   #887	-> 1556
/*      */     //   #888	-> 1567
/*      */     //   #889	-> 1578
/*      */     //   #890	-> 1594
/*      */     //   #1031	-> 1610
/*      */     //   #890	-> 1641
/*      */     //   #891	-> 1643
/*      */     //   #1032	-> 1650
/*      */     //   #1033	-> 1663
/*      */     //   #1034	-> 1676
/*      */     //   #1036	-> 1689
/*      */     //   #891	-> 1706
/*      */     //   #892	-> 1708
/*      */     //   #1037	-> 1751
/*      */     //   #1038	-> 1779
/*      */     //   #1037	-> 1810
/*      */     //   #892	-> 1811
/*      */     //   #893	-> 1813
/*      */     //   #895	-> 1813
/*      */     //   #893	-> 1817
/*      */     //   #1039	-> 1824
/*      */     //   #1040	-> 1837
/*      */     //   #1041	-> 1850
/*      */     //   #1043	-> 1863
/*      */     //   #893	-> 1889
/*      */     //   #894	-> 1893
/*      */     //   #1044	-> 1902
/*      */     //   #1045	-> 1930
/*      */     //   #1044	-> 1961
/*      */     //   #893	-> 1970
/*      */     //   #1046	-> 1975
/*      */     //   #1047	-> 1988
/*      */     //   #1048	-> 2001
/*      */     //   #1050	-> 2014
/*      */     //   #895	-> 2041
/*      */     //   #896	-> 2071
/*      */     //   #897	-> 2074
/*      */     //   #898	-> 2083
/*      */     //   #899	-> 2087
/*      */     //   #900	-> 2097
/*      */     //   #901	-> 2107
/*      */     //   #898	-> 2117
/*      */     //   #1051	-> 2120
/*      */     //   #898	-> 2151
/*      */     //   #903	-> 2153
/*      */     //   #904	-> 2182
/*      */     //   #905	-> 2216
/*      */     //   #904	-> 2218
/*      */     //   #907	-> 2224
/*      */     //   #908	-> 2227
/*      */     //   #909	-> 2232
/*      */     //   #885	-> 2235
/*      */     //   #912	-> 2241
/*      */     //   #913	-> 2263
/*      */     //   #914	-> 2272
/*      */     //   #915	-> 2277
/*      */     //   #917	-> 2277
/*      */     //   #918	-> 2286
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   2	18	3	$i$f$isReplaceable	I
/*      */     //   462	34	38	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   465	31	39	$i$f$addVector	I
/*      */     //   544	17	46	d2$iv	D
/*      */     //   531	30	44	d1$iv	D
/*      */     //   518	43	42	d0$iv	D
/*      */     //   502	59	40	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   505	56	41	$i$f$squareDistanceTo	I
/*      */     //   631	34	44	this_$iv$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   631	34	45	x$iv$iv	D
/*      */     //   631	34	47	y$iv$iv	D
/*      */     //   631	34	49	z$iv$iv	D
/*      */     //   634	31	51	$i$f$addVector	I
/*      */     //   603	63	41	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   603	63	42	vec$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   606	60	43	$i$f$add	I
/*      */     //   718	17	47	d2$iv	D
/*      */     //   705	30	45	d1$iv	D
/*      */     //   692	43	43	d0$iv	D
/*      */     //   676	59	41	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   679	56	42	$i$f$squareDistanceTo	I
/*      */     //   782	34	44	this_$iv$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   782	34	45	x$iv$iv	D
/*      */     //   782	34	47	y$iv$iv	D
/*      */     //   782	34	49	z$iv$iv	D
/*      */     //   785	31	51	$i$f$addVector	I
/*      */     //   754	63	42	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   757	60	43	$i$f$add	I
/*      */     //   869	17	48	d2$iv	D
/*      */     //   856	30	46	d1$iv	D
/*      */     //   843	43	44	d0$iv	D
/*      */     //   827	59	41	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   827	59	42	vec$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   830	56	43	$i$f$squareDistanceTo	I
/*      */     //   1151	34	55	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1151	34	56	x$iv	D
/*      */     //   1151	34	58	y$iv	D
/*      */     //   1151	34	60	z$iv	D
/*      */     //   1154	31	62	$i$f$addVector	I
/*      */     //   1216	108	55	obj	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*      */     //   1187	137	54	vector	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1117	207	53	rotationVector	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1110	214	52	rotation	Lnet/ccbluex/liquidbounce/utils/Rotation;
/*      */     //   1069	255	51	pitch	F
/*      */     //   1042	282	49	diffXZ	D
/*      */     //   1026	298	47	diffZ	D
/*      */     //   998	326	45	diffY	D
/*      */     //   985	339	43	diffX	D
/*      */     //   958	369	41	i	I
/*      */     //   668	669	40	hitVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   563	774	38	distanceSqPosVec	D
/*      */     //   498	839	37	posVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   434	913	35	zSearch	D
/*      */     //   408	949	33	ySearch	D
/*      */     //   382	978	31	xSearch	D
/*      */     //   371	989	30	dirVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   344	1016	29	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   333	1027	28	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   321	1042	24	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   1607	34	32	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1610	31	33	$i$f$addVector	I
/*      */     //   1689	17	40	d2$iv	D
/*      */     //   1676	30	38	d1$iv	D
/*      */     //   1663	43	36	d0$iv	D
/*      */     //   1647	59	34	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1650	56	35	$i$f$squareDistanceTo	I
/*      */     //   1776	34	38	this_$iv$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1776	34	39	x$iv$iv	D
/*      */     //   1776	34	41	y$iv$iv	D
/*      */     //   1776	34	43	z$iv$iv	D
/*      */     //   1779	31	45	$i$f$addVector	I
/*      */     //   1748	63	35	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1748	63	36	vec$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1751	60	37	$i$f$add	I
/*      */     //   1863	17	41	d2$iv	D
/*      */     //   1850	30	39	d1$iv	D
/*      */     //   1837	43	37	d0$iv	D
/*      */     //   1821	59	35	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1824	56	36	$i$f$squareDistanceTo	I
/*      */     //   1927	34	38	this_$iv$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1927	34	39	x$iv$iv	D
/*      */     //   1927	34	41	y$iv$iv	D
/*      */     //   1927	34	43	z$iv$iv	D
/*      */     //   1930	31	45	$i$f$addVector	I
/*      */     //   1899	63	36	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1902	60	37	$i$f$add	I
/*      */     //   2014	17	42	d2$iv	D
/*      */     //   2001	30	40	d1$iv	D
/*      */     //   1988	43	38	d0$iv	D
/*      */     //   1972	59	35	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1972	59	36	vec$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1975	56	37	$i$f$squareDistanceTo	I
/*      */     //   2117	34	37	this_$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   2117	34	38	x$iv	D
/*      */     //   2117	34	40	y$iv	D
/*      */     //   2117	34	42	z$iv	D
/*      */     //   2120	31	44	$i$f$addVector	I
/*      */     //   2182	53	37	obj	Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;
/*      */     //   2153	82	36	vector	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   2083	152	35	rotationVector	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1813	422	34	hitVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1708	527	32	distanceSqPosVec	D
/*      */     //   1643	592	31	posVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1594	641	30	dirVec	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   1567	668	29	neighbor	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   1556	679	28	side	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   1544	694	24	facingType	Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   294	1994	23	placeRotation	Lnet/ccbluex/liquidbounce/utils/PlaceRotation;
/*      */     //   288	2000	22	eyesPos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;
/*      */     //   192	2096	20	zSearchFace	D
/*      */     //   189	2099	18	ySearchFace	D
/*      */     //   186	2102	16	xSearchFace	D
/*      */     //   183	2105	14	ySSV	D
/*      */     //   175	2113	12	yRV	D
/*      */     //   159	2129	10	xzSSV	D
/*      */     //   151	2137	8	xzRV	D
/*      */     //   135	2153	7	staticYawOffset	F
/*      */     //   120	2168	6	staticPitch	F
/*      */     //   105	2183	5	staticYawMode	Z
/*      */     //   74	2214	4	staticPitchMode	Z
/*      */     //   43	2245	3	staticMode	Z
/*      */     //   0	2288	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/Scaffold;
/*      */     //   0	2288	1	blockPosition	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   0	2288	2	checks	Z
/*      */   }
/*      */   
/*      */   private final double calcStepSize(double range) {
/*      */     double accuracy = ((Number)this.searchAccuracyValue.get()).intValue();
/*      */     accuracy += accuracy % 2;
/*      */     return (range / accuracy < 0.01D) ? 0.01D : (range / accuracy);
/*      */   }
/*      */   
/*      */   private final int getBlocksAmount() {
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
/*      */     return (String)this.modeValue.get();
/*      */   }
/*      */   
/*      */   private final Unit getBestBlocks() {
/*      */     if (getBlocksAmount() == 0)
/*      */       return Unit.INSTANCE; 
/*      */     if (MinecraftInstance.functions.getItemById(261) == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     IItemStack is = MinecraftInstance.classProvider.createItemStack(MinecraftInstance.functions.getItemById(261));
/*      */     for (byte b1 = 9, b2 = 35; b1 <= b2; b1++) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getHasStack()) {
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         IItemStack item = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getStack();
/*      */         int count = 0;
/*      */         if (item instanceof net.ccbluex.liquidbounce.api.minecraft.item.IItemBlock) {
/*      */           for (byte b3 = 36, b4 = 44; b3 <= b4; b3++) {
/*      */             if (MinecraftInstance.mc.getThePlayer() == null)
/*      */               Intrinsics.throwNpe(); 
/*      */             if (MinecraftInstance.functions.canAddItemToSlot(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b3), is, true)) {
/*      */               swap(b1, b3 - 36);
/*      */               count++;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */           if (count == 0)
/*      */             swap(b1, 7); 
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     return invCheck() ? Unit.INSTANCE : Unit.INSTANCE;
/*      */   }
/*      */   
/*      */   private final void swap(int slot, int hotbarNum) {
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     MinecraftInstance.mc.getPlayerController().windowClick(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(), slot, hotbarNum, 2, MinecraftInstance.mc.getThePlayer());
/*      */   }
/*      */   
/*      */   private final boolean invCheck() {
/*      */     for (byte b1 = 36, b2 = 44; b1 <= b2; b1++) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getHasStack()) {
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         if (MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getStack() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         IItem item = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(b1).getStack().getItem();
/*      */         if (MinecraftInstance.classProvider.isItemBlock(item))
/*      */           return false; 
/*      */       } 
/*      */     } 
/*      */     return true;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\Scaffold.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */