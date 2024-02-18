/*      */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import kotlin.Metadata;
/*      */ import kotlin.TypeCastException;
/*      */ import kotlin.collections.CollectionsKt;
/*      */ import kotlin.jvm.JvmStatic;
/*      */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*      */ import kotlin.jvm.internal.Intrinsics;
/*      */ import kotlin.text.StringsKt;
/*      */ import net.ccbluex.liquidbounce.Retreat;
/*      */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WMathHelper;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*      */ import net.ccbluex.liquidbounce.event.EntityMovementEvent;
/*      */ import net.ccbluex.liquidbounce.event.EventTarget;
/*      */ import net.ccbluex.liquidbounce.event.JumpEvent2;
/*      */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*      */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*      */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.misc.Teams;
/*      */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*      */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.VecRotation;
/*      */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*      */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ 
/*      */ @ModuleInfo(name = "KillAura4", category = ModuleCategory.COMBAT, description = "Skid from cat")
/*      */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000®\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\t\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\n\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\020\006\n\002\b!\n\002\020\007\n\002\b\020\n\002\020!\n\002\b\033\n\002\020\016\n\002\b\n\n\002\020\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\b\007\030\000 ¬\0012\0020\001:\002¬\001B\005¢\006\002\020\002J\022\020\001\032\0030\0012\006\0201\032\0020,H\002J\007\020\001\032\0020UJ\022\020\001\032\0020U2\007\0201\032\0030\001H\002J\021\020\001\032\0020\0322\006\0201\032\0020,H\002J\024\020\001\032\0020\0322\t\0201\032\005\030\0010\001H\002J\n\020\001\032\0030\001H\026J\n\020\001\032\0030\001H\026J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\007J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\007J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\007J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\007J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\007J\024\020\001\032\0030\0012\b\020\001\032\0030 \001H\007J\024\020¡\001\032\0030\0012\b\020\001\032\0030¢\001H\007J\n\020£\001\032\0030\001H\002J\035\020¤\001\032\0030\0012\b\020¥\001\032\0030\0012\007\020¦\001\032\0020\032H\002J\n\020§\001\032\0030\001H\002J\b\020¨\001\032\0030\001J\n\020©\001\032\0030\001H\002J\022\020ª\001\032\0020\0322\007\0201\032\0030\001H\002J\n\020«\001\032\0030\001H\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\bX\004¢\006\002\n\000R\021\020\f\032\0020\004¢\006\b\n\000\032\004\b\r\020\006R\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\016\020\022\032\0020\023X\016¢\006\002\n\000R\016\020\024\032\0020\bX\004¢\006\002\n\000R\020\020\025\032\004\030\0010\026X\016¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\016\020\031\032\0020\032X\016¢\006\002\n\000R\032\020\033\032\0020\032X\016¢\006\016\n\000\032\004\b\034\020\035\"\004\b\036\020\037R\025\020 \032\0020\0328Â\002X\004¢\006\006\032\004\b!\020\035R\025\020\"\032\0020\0328Â\002X\004¢\006\006\032\004\b#\020\035R\016\020$\032\0020%X\004¢\006\002\n\000R\016\020&\032\0020%X\004¢\006\002\n\000R\016\020'\032\0020\004X\004¢\006\002\n\000R\016\020(\032\0020\023X\016¢\006\002\n\000R\016\020)\032\0020\017X\016¢\006\002\n\000R\016\020*\032\0020\bX\004¢\006\002\n\000R\034\020+\032\004\030\0010,X\016¢\006\016\n\000\032\004\b-\020.\"\004\b/\0200R\020\0201\032\004\030\0010,X\016¢\006\002\n\000R\016\0202\032\00203X\016¢\006\002\n\000R\016\0204\032\0020\bX\004¢\006\002\n\000R\016\0205\032\0020\004X\004¢\006\002\n\000R\016\0206\032\0020\004X\004¢\006\002\n\000R\016\0207\032\0020\bX\004¢\006\002\n\000R\016\0208\032\0020\032X\016¢\006\002\n\000R\032\0209\032\0020\004X\016¢\006\016\n\000\032\004\b:\020\006\"\004\b;\020<R\016\020=\032\0020%X\004¢\006\002\n\000R\016\020>\032\0020\004X\004¢\006\002\n\000R\016\020?\032\0020\032X\016¢\006\002\n\000R\016\020@\032\0020\023X\016¢\006\002\n\000R\021\020A\032\0020\004¢\006\b\n\000\032\004\bB\020\006R\021\020C\032\0020\004¢\006\b\n\000\032\004\bD\020\006R\021\020E\032\0020\004¢\006\b\n\000\032\004\bF\020\006R\021\020G\032\0020\004¢\006\b\n\000\032\004\bH\020\006R\020\020I\032\004\030\0010,X\016¢\006\002\n\000R\016\020J\032\0020\030X\004¢\006\002\n\000R\016\020K\032\0020\004X\004¢\006\002\n\000R\016\020L\032\0020\004X\004¢\006\002\n\000R\016\020M\032\0020%X\004¢\006\002\n\000R\016\020N\032\0020\004X\004¢\006\002\n\000R\016\020O\032\0020\030X\004¢\006\002\n\000R\021\020P\032\0020%¢\006\b\n\000\032\004\bQ\020RR\016\020S\032\0020\bX\004¢\006\002\n\000R\024\020T\032\0020U8BX\004¢\006\006\032\004\bV\020WR\016\020X\032\0020\bX\004¢\006\002\n\000R\021\020Y\032\0020%¢\006\b\n\000\032\004\bZ\020RR\016\020[\032\0020\bX\004¢\006\002\n\000R\016\020\\\032\0020\bX\004¢\006\002\n\000R\016\020]\032\0020\004X\004¢\006\002\n\000R\016\020^\032\0020\004X\004¢\006\002\n\000R\016\020_\032\0020\004X\004¢\006\002\n\000R\016\020`\032\0020%X\004¢\006\002\n\000R\016\020a\032\0020\004X\004¢\006\002\n\000R\016\020b\032\0020\bX\004¢\006\002\n\000R\016\020c\032\0020\004X\004¢\006\002\n\000R\016\020d\032\0020\004X\004¢\006\002\n\000R\024\020e\032\b\022\004\022\0020\0230fX\004¢\006\002\n\000R\016\020g\032\0020\030X\004¢\006\002\n\000R\016\020h\032\0020\004X\004¢\006\002\n\000R\021\020i\032\0020\b¢\006\b\n\000\032\004\bj\020kR\016\020l\032\0020\004X\004¢\006\002\n\000R\016\020m\032\0020\004X\004¢\006\002\n\000R\021\020n\032\0020\030¢\006\b\n\000\032\004\bo\020pR\021\020q\032\0020\b¢\006\b\n\000\032\004\br\020kR\021\020s\032\0020\004¢\006\b\n\000\032\004\bt\020\006R\021\020u\032\0020\004¢\006\b\n\000\032\004\bv\020\006R\032\020w\032\0020\032X\016¢\006\016\n\000\032\004\bx\020\035\"\004\by\020\037R\016\020z\032\0020\004X\004¢\006\002\n\000R\021\020{\032\0020%¢\006\b\n\000\032\004\b|\020RR\016\020}\032\0020\021X\004¢\006\002\n\000R\035\020~\032\004\030\0010,X\016¢\006\017\n\000\032\004\b\020.\"\005\b\001\0200R\030\020\001\032\0030\0018VX\004¢\006\b\032\006\b\001\020\001R\037\020\001\032\004\030\0010,X\016¢\006\020\n\000\032\005\b\001\020.\"\005\b\001\0200R\017\020\001\032\0020\030X\004¢\006\002\n\000R\023\020\001\032\0020\004¢\006\t\n\000\032\005\b\001\020\006R\017\020\001\032\0020\bX\004¢\006\002\n\000¨\006­\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "BackBypass", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getBackBypass", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "BlockRangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "aacValue", "afterAttackValue", "airReducementValue", "alwaysblock", "getAlwaysblock", "attackDelay", "", "attackTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "b", "", "backReducementValue", "bb", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "blockModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "blocking", "", "blockingStatus", "getBlockingStatus", "()Z", "setBlockingStatus", "(Z)V", "canBlock", "getCanBlock", "cancelRun", "getCancelRun", "circleAccuracy", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "circleThickness", "circleValue", "clicks", "containerOpen", "cooldownValue", "currentTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getCurrentTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setCurrentTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "entity", "espAnimation", "", "failRateValue", "fakeSharpValue", "fakeSwingValue", "fovValue", "hitable", "hitableValue", "getHitableValue", "setHitableValue", "(Lnet/ccbluex/liquidbounce/value/BoolValue;)V", "hurtTimeValue", "interactAutoBlockValue", "isUp", "jump", "jumpfix", "getJumpfix", "jumpfixtest", "getJumpfixtest", "keepSprintValue", "getKeepSprintValue", "keepSprintnohurtValue", "getKeepSprintnohurtValue", "lastTarget", "lightingModeValue", "lightingSoundValue", "lightingValue", "limitedMultiTargetsValue", "livingRaycastValue", "markValue", "maxCPS", "getMaxCPS", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "maxPredictSize", "maxRange", "", "getMaxRange", "()F", "maxTurnSpeed", "minCPS", "getMinCPS", "minPredictSize", "minTurnSpeed", "noBlocking", "noInventory", "noInventoryAttackValue", "noInventoryDelayValue", "nodigging", "nomoveReducementValue", "outborderValue", "predictValue", "prevTargetEntities", "", "priorityValue", "randomCenterValue", "rangeValue", "getRangeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "raycastIgnoredValue", "raycastValue", "rotationStrafeValue", "getRotationStrafeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "rotationrangeValue", "getRotationrangeValue", "silentRotationValue", "getSilentRotationValue", "silentfix", "getSilentfix", "sprintmode", "getSprintmode", "setSprintmode", "swingValue", "switchDelayValue", "getSwitchDelayValue", "switchTimer", "syncEntity", "getSyncEntity", "setSyncEntity", "tag", "", "getTag", "()Ljava/lang/String;", "target", "getTarget", "setTarget", "targetModeValue", "testSilentValue", "getTestSilentValue", "throughWallsRangeValue", "attackEntity", "", "getRange", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isAlive", "isEnemy", "onDisable", "onEnable", "onEntityMove", "event", "Lnet/ccbluex/liquidbounce/event/EntityMovementEvent;", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent2;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "runAttack", "startBlocking", "interactEntity", "interact", "stopBlocking", "update", "updateHitable", "updateRotations", "updateTarget", "Companion", "XSJClient"})
/*      */ public final class KillAura4 extends Module {
/*      */   @NotNull
/*   62 */   private final IntegerValue maxCPS = new KillAura4$maxCPS$1("MaxCPS", 8, 1, 20); @NotNull public final IntegerValue getMaxCPS() { return this.maxCPS; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$maxCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura4$maxCPS$1 extends IntegerValue { KillAura4$maxCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(int oldValue, int newValue) {
/*   64 */       int i = ((Number)KillAura4.this.getMinCPS().get()).intValue();
/*   65 */       if (i > newValue) set(Integer.valueOf(i));
/*      */       
/*   67 */       KillAura4.this.attackDelay = TimeUtils.randomClickDelay(((Number)KillAura4.this.getMinCPS().get()).intValue(), ((Number)get()).intValue());
/*      */     } }
/*      */   @NotNull
/*   70 */   private final IntegerValue minCPS = new KillAura4$minCPS$1("MinCPS", 5, 1, 20); @NotNull public final IntegerValue getMinCPS() { return this.minCPS; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$minCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura4$minCPS$1 extends IntegerValue { KillAura4$minCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(int oldValue, int newValue) {
/*   72 */       int i = ((Number)KillAura4.this.getMaxCPS().get()).intValue();
/*   73 */       if (i < newValue) set(Integer.valueOf(i));
/*      */       
/*   75 */       KillAura4.this.attackDelay = TimeUtils.randomClickDelay(((Number)get()).intValue(), ((Number)KillAura4.this.getMaxCPS().get()).intValue());
/*      */     } }
/*      */   
/*   78 */   private final IntegerValue hurtTimeValue = new IntegerValue("HurtTime", 10, 0, 10);
/*   79 */   private final FloatValue cooldownValue = new FloatValue("Cooldown", 1.0F, 0.0F, 1.0F);
/*      */   
/*      */   @NotNull
/*   82 */   private final FloatValue rangeValue = new FloatValue("Range", 3.7F, 1.0F, 8.0F); @NotNull public final FloatValue getRangeValue() { return this.rangeValue; } @NotNull
/*   83 */   private final FloatValue rotationrangeValue = new FloatValue("Rotation-Range", 4.5F, 3.0F, 8.0F); @NotNull public final FloatValue getRotationrangeValue() { return this.rotationrangeValue; }
/*   84 */    private final FloatValue BlockRangeValue = new FloatValue("BlockRange", 3.0F, 0.0F, 8.0F);
/*   85 */   private final FloatValue throughWallsRangeValue = new FloatValue("ThroughWallsRange", 3.0F, 0.0F, 8.0F);
/*   86 */   private final FloatValue backReducementValue = new FloatValue("BackReducementValue", 0.15F, 0.0F, 0.4F);
/*   87 */   private final FloatValue nomoveReducementValue = new FloatValue("NomoveReducement", 0.0F, 0.0F, 0.4F);
/*   88 */   private final FloatValue airReducementValue = new FloatValue("airReducement", 0.0F, 0.0F, 0.4F);
/*      */ 
/*      */   
/*   91 */   private final ListValue priorityValue = new ListValue("Priority", new String[] { "Health", "Distance", "Direction", "LivingTime", "Armor" }, "Distance");
/*   92 */   private final ListValue targetModeValue = new ListValue("TargetMode", new String[] { "Single", "Switch", "Multi" }, "Switch"); @NotNull
/*   93 */   private final IntegerValue switchDelayValue = new IntegerValue("SwitchDelay", 0, 0, 2000); @NotNull public final IntegerValue getSwitchDelayValue() { return this.switchDelayValue; }
/*      */ 
/*      */   
/*   96 */   private final BoolValue swingValue = new BoolValue("Swing", true); @NotNull
/*   97 */   private final BoolValue keepSprintValue = new BoolValue("KeepSprint", true); @NotNull public final BoolValue getKeepSprintValue() { return this.keepSprintValue; } @NotNull
/*   98 */   private final BoolValue keepSprintnohurtValue = new BoolValue("KeepSprintNOonhurt", true); @NotNull public final BoolValue getKeepSprintnohurtValue() { return this.keepSprintnohurtValue; } @NotNull
/*   99 */   private final BoolValue BackBypass = new BoolValue("BackBypass", true); @NotNull public final BoolValue getBackBypass() { return this.BackBypass; } @NotNull
/*  100 */   private final BoolValue jumpfix = new BoolValue("jumpfix", true); @NotNull public final BoolValue getJumpfix() { return this.jumpfix; } @NotNull
/*  101 */   private final BoolValue silentfix = new BoolValue("silentfix", true); private boolean sprintmode; @NotNull public final BoolValue getSilentfix() { return this.silentfix; }
/*  102 */   public final boolean getSprintmode() { return this.sprintmode; } public final void setSprintmode(boolean <set-?>) { this.sprintmode = <set-?>; } @NotNull
/*  103 */   private final BoolValue jumpfixtest = new BoolValue("jumpfixtest", true); @NotNull public final BoolValue getJumpfixtest() { return this.jumpfixtest; } @NotNull
/*  104 */   private final BoolValue alwaysblock = new BoolValue("alwaysblock", true); @NotNull public final BoolValue getAlwaysblock() { return this.alwaysblock; } @NotNull
/*  105 */   private BoolValue hitableValue = new BoolValue("AlwaysHitable", true); @NotNull public final BoolValue getHitableValue() { return this.hitableValue; } public final void setHitableValue(@NotNull BoolValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.hitableValue = <set-?>; }
/*  106 */    private final BoolValue noBlocking = new BoolValue("NoBlocking", true);
/*  107 */   private final BoolValue nodigging = new BoolValue("Nodigging", true);
/*      */ 
/*      */   
/*  110 */   private final BoolValue afterAttackValue = new BoolValue("AutoBlock-AfterAttack", false);
/*  111 */   private final ListValue blockModeValue = new ListValue("AutoBlock", new String[] { "Off", "Grim", "Packet", "Use" }, "Grim");
/*  112 */   private final BoolValue interactAutoBlockValue = new BoolValue("InteractAutoBlock", true);
/*      */   
/*      */   private boolean blocking;
/*      */   
/*  116 */   private final BoolValue raycastValue = new BoolValue("RayCast", true);
/*  117 */   private final BoolValue raycastIgnoredValue = new BoolValue("RayCastIgnored", false);
/*  118 */   private final BoolValue livingRaycastValue = new BoolValue("LivingRayCast", true);
/*  119 */   private final BoolValue aacValue = new BoolValue("AAC", false);
/*  120 */   private final BoolValue noInventory = new BoolValue("NoInventoryGui", false); @NotNull
/*  121 */   private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true); @NotNull public final BoolValue getSilentRotationValue() { return this.silentRotationValue; } @NotNull
/*  122 */   private final BoolValue testSilentValue = new BoolValue("TestSilent", true); @NotNull public final BoolValue getTestSilentValue() { return this.testSilentValue; } @NotNull
/*  123 */   private final ListValue rotationStrafeValue = new ListValue("Strafe", new String[] { "Off", "Strict", "Silent", "Test" }, "Silent"); @NotNull public final ListValue getRotationStrafeValue() { return this.rotationStrafeValue; }
/*  124 */    private final BoolValue randomCenterValue = new BoolValue("RandomCenter", true);
/*  125 */   private final BoolValue outborderValue = new BoolValue("Outborder", false);
/*  126 */   private final FloatValue failRateValue = new FloatValue("FailRate", 0.0F, 0.0F, 100.0F);
/*  127 */   private final BoolValue fakeSwingValue = new BoolValue("FakeSwing", true);
/*  128 */   private final BoolValue noInventoryAttackValue = new BoolValue("NoInvAttack", false);
/*  129 */   private final IntegerValue noInventoryDelayValue = new IntegerValue("NoInvDelay", 200, 0, 500);
/*  130 */   private final IntegerValue limitedMultiTargetsValue = new IntegerValue("LimitedMultiTargets", 0, 0, 50);
/*      */ 
/*      */   
/*  133 */   private final FloatValue fovValue = new FloatValue("FOV", 180.0F, 0.0F, 180.0F);
/*      */   
/*  135 */   private final FloatValue maxTurnSpeed = new KillAura4$maxTurnSpeed$1("MaxTurnSpeed", 360.0F, 0.0F, 360.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$maxTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura4$maxTurnSpeed$1 extends FloatValue { KillAura4$maxTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(float oldValue, float newValue) {
/*  137 */       float v = ((Number)KillAura4.this.minTurnSpeed.get()).floatValue();
/*  138 */       if (v > newValue) set(Float.valueOf(v)); 
/*      */     } }
/*      */ 
/*      */   
/*  142 */   private final FloatValue minTurnSpeed = new KillAura4$minTurnSpeed$1("MinTurnSpeed", 360.0F, 0.0F, 360.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$minTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura4$minTurnSpeed$1 extends FloatValue { KillAura4$minTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(float oldValue, float newValue) {
/*  144 */       float v = ((Number)KillAura4.this.maxTurnSpeed.get()).floatValue();
/*  145 */       if (v < newValue) set(Float.valueOf(v));
/*      */     
/*      */     } }
/*      */ 
/*      */   
/*  150 */   private final BoolValue predictValue = new BoolValue("Predict", true);
/*      */   
/*  152 */   private final FloatValue maxPredictSize = new KillAura4$maxPredictSize$1("MaxPredictSize", 1.0F, 0.1F, 5.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$maxPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura4$maxPredictSize$1 extends FloatValue { KillAura4$maxPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(float oldValue, float newValue) {
/*  154 */       float v = ((Number)KillAura4.this.minPredictSize.get()).floatValue();
/*  155 */       if (v > newValue) set(Float.valueOf(v)); 
/*      */     } }
/*      */ 
/*      */   
/*  159 */   private final FloatValue minPredictSize = new KillAura4$minPredictSize$1("MinPredictSize", 1.0F, 0.1F, 5.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$minPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura4$minPredictSize$1 extends FloatValue { KillAura4$minPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */      protected void onChanged(float oldValue, float newValue) {
/*  161 */       float v = ((Number)KillAura4.this.maxPredictSize.get()).floatValue();
/*  162 */       if (v < newValue) set(Float.valueOf(v));
/*      */     
/*      */     } }
/*      */ 
/*      */   
/*  167 */   private final BoolValue lightingValue = new BoolValue("Lighting", false);
/*  168 */   private final ListValue lightingModeValue = new ListValue("Lighting-Mode", new String[] { "Dead", "Attack" }, "Dead");
/*  169 */   private final BoolValue lightingSoundValue = new BoolValue("Lighting-Sound", true);
/*      */ 
/*      */   
/*  172 */   private final ListValue markValue = new ListValue("Mark", new String[] { "Liquid", "CatBlock" }, "CatBlock");
/*  173 */   private final BoolValue fakeSharpValue = new BoolValue("FakeSharp", true);
/*  174 */   private final BoolValue circleValue = new BoolValue("Circle", true);
/*  175 */   private final IntegerValue circleAccuracy = new IntegerValue("CircleAccuracy", 15, 0, 60);
/*  176 */   private final IntegerValue circleThickness = new IntegerValue("circleThickness", 5, 0, 15); @Nullable
/*      */   private IEntityLivingBase target; @Nullable
/*      */   private IEntityLivingBase currentTarget; private boolean hitable; private final List<Integer> prevTargetEntities; private IEntityLivingBase lastTarget; private final MSTimer attackTimer; private long attackDelay; private int clicks; private final MSTimer switchTimer; private long containerOpen; private boolean blockingStatus; private IAxisAlignedBB bb; private IEntityLivingBase entity; private double espAnimation; private boolean isUp; @Nullable
/*      */   private IEntityLivingBase syncEntity; private int jump; private int b; private static int killCounts;
/*      */   public static final Companion Companion = new Companion(null);
/*      */   
/*      */   @Nullable
/*  183 */   public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; } @Nullable
/*  184 */   public final IEntityLivingBase getCurrentTarget() { return this.currentTarget; } public final void setCurrentTarget(@Nullable IEntityLivingBase <set-?>) { this.currentTarget = <set-?>; }
/*      */   
/*  186 */   public KillAura4() { KillAura4 killAura4 = this; boolean bool = false; ArrayList<Integer> arrayList = new ArrayList();
/*      */ 
/*      */ 
/*      */     
/*  190 */     this.attackTimer = new MSTimer();
/*      */ 
/*      */     
/*  193 */     this.switchTimer = new MSTimer();
/*      */     
/*  195 */     this.containerOpen = -1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  202 */     this.isUp = true; } public final boolean getBlockingStatus() { return this.blockingStatus; } public final void setBlockingStatus(boolean <set-?>) { this.blockingStatus = <set-?>; }
/*  203 */   @Nullable public final IEntityLivingBase getSyncEntity() { return this.syncEntity; } public final void setSyncEntity(@Nullable IEntityLivingBase <set-?>) { this.syncEntity = <set-?>; }
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\006\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R$\020\003\032\0020\0048\006@\006X\016¢\006\024\n\000\022\004\b\005\020\002\032\004\b\006\020\007\"\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$Companion;", "", "()V", "killCounts", "", "killCounts$annotations", "getKillCounts", "()I", "setKillCounts", "(I)V", "XSJClient"})
/*      */   public static final class Companion { private Companion() {}
/*  207 */     public final void setKillCounts(int <set-?>) { KillAura4.killCounts = <set-?>; } public final int getKillCounts() { return KillAura4.killCounts; }
/*      */      }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEnable()
/*      */   {
/*  214 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer();
/*  215 */       if (MinecraftInstance.mc.getTheWorld() != null) { MinecraftInstance.mc.getTheWorld();
/*      */         
/*  217 */         this.jump = 0;
/*  218 */         this.sprintmode = true;
/*  219 */         updateTarget();
/*      */         return; }
/*      */       
/*      */       MinecraftInstance.mc.getTheWorld();
/*      */       return; }
/*      */     
/*      */     MinecraftInstance.mc.getThePlayer(); } public void onDisable() {
/*  226 */     this.target = (IEntityLivingBase)null;
/*  227 */     this.currentTarget = (IEntityLivingBase)null;
/*  228 */     this.lastTarget = (IEntityLivingBase)null;
/*  229 */     this.hitable = false;
/*  230 */     this.prevTargetEntities.clear();
/*  231 */     this.attackTimer.reset();
/*  232 */     this.clicks = 0;
/*  233 */     this.sprintmode = true;
/*      */     
/*  235 */     stopBlocking();
/*  236 */     MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public final void onJump(@NotNull JumpEvent2 event) {
/*  245 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.jump = 0;
/*  246 */     if (((Boolean)this.jumpfixtest.get()).booleanValue() && 
/*  247 */       this.currentTarget != null && RotationUtils.targetRotation != null) {
/*  248 */       event.setYaw(RotationUtils.targetRotation.getYaw());
/*      */     }
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
/*      */   @EventTarget
/*      */   public final void onMotion(@NotNull MotionEvent event) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: aload_1
/*      */     //   8: invokevirtual getEventState : ()Lnet/ccbluex/liquidbounce/event/EventState;
/*      */     //   11: getstatic net/ccbluex/liquidbounce/event/EventState.POST : Lnet/ccbluex/liquidbounce/event/EventState;
/*      */     //   14: if_acmpne -> 801
/*      */     //   17: aload_0
/*      */     //   18: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   21: dup
/*      */     //   22: ifnull -> 28
/*      */     //   25: goto -> 30
/*      */     //   28: pop
/*      */     //   29: return
/*      */     //   30: pop
/*      */     //   31: aload_0
/*      */     //   32: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   35: dup
/*      */     //   36: ifnull -> 42
/*      */     //   39: goto -> 44
/*      */     //   42: pop
/*      */     //   43: return
/*      */     //   44: pop
/*      */     //   45: aload_0
/*      */     //   46: invokespecial updateHitable : ()V
/*      */     //   49: aload_0
/*      */     //   50: getfield blockModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   53: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   56: checkcast java/lang/String
/*      */     //   59: ldc_w 'Grim'
/*      */     //   62: iconst_1
/*      */     //   63: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   66: ifeq -> 240
/*      */     //   69: aload_0
/*      */     //   70: astore_2
/*      */     //   71: iconst_0
/*      */     //   72: istore_3
/*      */     //   73: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   76: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   81: dup
/*      */     //   82: ifnonnull -> 88
/*      */     //   85: invokestatic throwNpe : ()V
/*      */     //   88: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   93: ifnull -> 195
/*      */     //   96: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   99: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   102: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   107: dup
/*      */     //   108: ifnonnull -> 114
/*      */     //   111: invokestatic throwNpe : ()V
/*      */     //   114: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   119: dup
/*      */     //   120: ifnonnull -> 126
/*      */     //   123: invokestatic throwNpe : ()V
/*      */     //   126: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   131: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*      */     //   136: ifeq -> 195
/*      */     //   139: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   142: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   147: dup
/*      */     //   148: ifnonnull -> 154
/*      */     //   151: invokestatic throwNpe : ()V
/*      */     //   154: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   157: aload_2
/*      */     //   158: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   161: dup
/*      */     //   162: ifnonnull -> 168
/*      */     //   165: invokestatic throwNpe : ()V
/*      */     //   168: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   171: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   174: aload_2
/*      */     //   175: invokestatic access$getBlockRangeValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   178: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   181: checkcast java/lang/Number
/*      */     //   184: invokevirtual doubleValue : ()D
/*      */     //   187: dcmpg
/*      */     //   188: ifgt -> 195
/*      */     //   191: iconst_1
/*      */     //   192: goto -> 196
/*      */     //   195: iconst_0
/*      */     //   196: ifeq -> 240
/*      */     //   199: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   202: dup
/*      */     //   203: ldc_w 'mc2'
/*      */     //   206: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   209: invokevirtual func_147114_u : ()Lnet/minecraft/client/network/NetHandlerPlayClient;
/*      */     //   212: dup
/*      */     //   213: ifnonnull -> 219
/*      */     //   216: invokestatic throwNpe : ()V
/*      */     //   219: new net/minecraft/network/play/client/CPacketPlayerTryUseItem
/*      */     //   222: dup
/*      */     //   223: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*      */     //   226: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*      */     //   229: checkcast net/minecraft/network/Packet
/*      */     //   232: invokevirtual func_147297_a : (Lnet/minecraft/network/Packet;)V
/*      */     //   235: aload_0
/*      */     //   236: iconst_1
/*      */     //   237: putfield blockingStatus : Z
/*      */     //   240: aload_0
/*      */     //   241: getfield blockModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   244: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   247: checkcast java/lang/String
/*      */     //   250: ldc_w 'Packet'
/*      */     //   253: iconst_1
/*      */     //   254: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   257: ifeq -> 459
/*      */     //   260: aload_0
/*      */     //   261: astore_2
/*      */     //   262: iconst_0
/*      */     //   263: istore_3
/*      */     //   264: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   267: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   272: dup
/*      */     //   273: ifnonnull -> 279
/*      */     //   276: invokestatic throwNpe : ()V
/*      */     //   279: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   284: ifnull -> 386
/*      */     //   287: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   290: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   293: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   298: dup
/*      */     //   299: ifnonnull -> 305
/*      */     //   302: invokestatic throwNpe : ()V
/*      */     //   305: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   310: dup
/*      */     //   311: ifnonnull -> 317
/*      */     //   314: invokestatic throwNpe : ()V
/*      */     //   317: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   322: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*      */     //   327: ifeq -> 386
/*      */     //   330: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   333: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   338: dup
/*      */     //   339: ifnonnull -> 345
/*      */     //   342: invokestatic throwNpe : ()V
/*      */     //   345: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   348: aload_2
/*      */     //   349: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   352: dup
/*      */     //   353: ifnonnull -> 359
/*      */     //   356: invokestatic throwNpe : ()V
/*      */     //   359: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   362: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   365: aload_2
/*      */     //   366: invokestatic access$getBlockRangeValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   369: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   372: checkcast java/lang/Number
/*      */     //   375: invokevirtual doubleValue : ()D
/*      */     //   378: dcmpg
/*      */     //   379: ifgt -> 386
/*      */     //   382: iconst_1
/*      */     //   383: goto -> 387
/*      */     //   386: iconst_0
/*      */     //   387: ifeq -> 459
/*      */     //   390: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   393: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   398: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   401: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   404: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   409: dup
/*      */     //   410: ifnonnull -> 416
/*      */     //   413: invokestatic throwNpe : ()V
/*      */     //   416: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   421: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   426: dup
/*      */     //   427: ifnonnull -> 441
/*      */     //   430: new kotlin/TypeCastException
/*      */     //   433: dup
/*      */     //   434: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemStack'
/*      */     //   437: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   440: athrow
/*      */     //   441: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*      */     //   446: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   449: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   454: aload_0
/*      */     //   455: iconst_1
/*      */     //   456: putfield blockingStatus : Z
/*      */     //   459: aload_0
/*      */     //   460: getfield blockModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   463: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   466: checkcast java/lang/String
/*      */     //   469: ldc_w 'Use'
/*      */     //   472: iconst_1
/*      */     //   473: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   476: ifeq -> 684
/*      */     //   479: aload_0
/*      */     //   480: astore_2
/*      */     //   481: iconst_0
/*      */     //   482: istore_3
/*      */     //   483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   486: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   491: dup
/*      */     //   492: ifnonnull -> 498
/*      */     //   495: invokestatic throwNpe : ()V
/*      */     //   498: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   503: ifnull -> 605
/*      */     //   506: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   509: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   512: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   517: dup
/*      */     //   518: ifnonnull -> 524
/*      */     //   521: invokestatic throwNpe : ()V
/*      */     //   524: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   529: dup
/*      */     //   530: ifnonnull -> 536
/*      */     //   533: invokestatic throwNpe : ()V
/*      */     //   536: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   541: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*      */     //   546: ifeq -> 605
/*      */     //   549: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   552: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   557: dup
/*      */     //   558: ifnonnull -> 564
/*      */     //   561: invokestatic throwNpe : ()V
/*      */     //   564: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   567: aload_2
/*      */     //   568: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   571: dup
/*      */     //   572: ifnonnull -> 578
/*      */     //   575: invokestatic throwNpe : ()V
/*      */     //   578: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   581: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   584: aload_2
/*      */     //   585: invokestatic access$getBlockRangeValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   588: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   591: checkcast java/lang/Number
/*      */     //   594: invokevirtual doubleValue : ()D
/*      */     //   597: dcmpg
/*      */     //   598: ifgt -> 605
/*      */     //   601: iconst_1
/*      */     //   602: goto -> 606
/*      */     //   605: iconst_0
/*      */     //   606: ifeq -> 684
/*      */     //   609: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   612: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   617: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   620: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   625: dup
/*      */     //   626: ifnonnull -> 632
/*      */     //   629: invokestatic throwNpe : ()V
/*      */     //   632: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*      */     //   637: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   642: astore_2
/*      */     //   643: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.MAIN_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*      */     //   646: astore_3
/*      */     //   647: astore #5
/*      */     //   649: iconst_0
/*      */     //   650: istore #4
/*      */     //   652: nop
/*      */     //   653: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*      */     //   656: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   659: aload_3
/*      */     //   660: invokeinterface createCPacketTryUseItem : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;
/*      */     //   665: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   668: astore #6
/*      */     //   670: aload #5
/*      */     //   672: aload #6
/*      */     //   674: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   679: aload_0
/*      */     //   680: iconst_1
/*      */     //   681: putfield blockingStatus : Z
/*      */     //   684: aload_0
/*      */     //   685: getfield switchTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   688: aload_0
/*      */     //   689: getfield switchDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   692: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   695: checkcast java/lang/Number
/*      */     //   698: invokevirtual intValue : ()I
/*      */     //   701: i2l
/*      */     //   702: invokevirtual hasTimePassed : (J)Z
/*      */     //   705: ifne -> 729
/*      */     //   708: aload_0
/*      */     //   709: getfield targetModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   712: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   715: checkcast java/lang/String
/*      */     //   718: ldc_w 'Switch'
/*      */     //   721: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   724: iconst_1
/*      */     //   725: ixor
/*      */     //   726: ifeq -> 800
/*      */     //   729: aload_0
/*      */     //   730: getfield prevTargetEntities : Ljava/util/List;
/*      */     //   733: aload_0
/*      */     //   734: getfield aacValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   737: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   740: checkcast java/lang/Boolean
/*      */     //   743: invokevirtual booleanValue : ()Z
/*      */     //   746: ifeq -> 768
/*      */     //   749: aload_0
/*      */     //   750: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   753: dup
/*      */     //   754: ifnonnull -> 760
/*      */     //   757: invokestatic throwNpe : ()V
/*      */     //   760: invokeinterface getEntityId : ()I
/*      */     //   765: goto -> 784
/*      */     //   768: aload_0
/*      */     //   769: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   772: dup
/*      */     //   773: ifnonnull -> 779
/*      */     //   776: invokestatic throwNpe : ()V
/*      */     //   779: invokeinterface getEntityId : ()I
/*      */     //   784: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   787: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   792: pop
/*      */     //   793: aload_0
/*      */     //   794: getfield switchTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   797: invokevirtual reset : ()V
/*      */     //   800: return
/*      */     //   801: aload_0
/*      */     //   802: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   805: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   808: checkcast java/lang/String
/*      */     //   811: ldc_w 'Off'
/*      */     //   814: iconst_1
/*      */     //   815: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   818: ifeq -> 825
/*      */     //   821: aload_0
/*      */     //   822: invokevirtual update : ()V
/*      */     //   825: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #255	-> 7
/*      */     //   #256	-> 17
/*      */     //   #256	-> 28
/*      */     //   #257	-> 31
/*      */     //   #257	-> 42
/*      */     //   #260	-> 45
/*      */     //   #264	-> 49
/*      */     //   #1055	-> 73
/*      */     //   #265	-> 199
/*      */     //   #266	-> 235
/*      */     //   #268	-> 240
/*      */     //   #1056	-> 264
/*      */     //   #269	-> 390
/*      */     //   #270	-> 454
/*      */     //   #272	-> 459
/*      */     //   #1057	-> 483
/*      */     //   #273	-> 609
/*      */     //   #1058	-> 652
/*      */     //   #1059	-> 652
/*      */     //   #1062	-> 653
/*      */     //   #1059	-> 668
/*      */     //   #273	-> 674
/*      */     //   #274	-> 679
/*      */     //   #276	-> 684
/*      */     //   #277	-> 729
/*      */     //   #278	-> 793
/*      */     //   #281	-> 800
/*      */     //   #284	-> 801
/*      */     //   #285	-> 821
/*      */     //   #286	-> 825
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   71	125	2	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   73	123	3	$i$f$getCanBlock	I
/*      */     //   262	125	2	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   264	123	3	$i$f$getCanBlock	I
/*      */     //   481	125	2	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   483	123	3	$i$f$getCanBlock	I
/*      */     //   649	19	2	itemStack$iv	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   649	19	3	hand$iv	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*      */     //   652	16	4	$i$f$createUseItemPacket	I
/*      */     //   0	826	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   0	826	1	event	Lnet/ccbluex/liquidbounce/event/MotionEvent;
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
/*      */   @EventTarget
/*      */   public final void onStrafe(@NotNull StrafeEvent event) {
/*  293 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) {
/*      */       return;
/*      */     }
/*  296 */     update();
/*      */     
/*  298 */     if (this.currentTarget != null && RotationUtils.targetRotation != null) {
/*  299 */       String str = (String)this.rotationStrafeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case -902327211:
/*  328 */           if (str.equals("silent")) {
/*  329 */             update();
/*  330 */             RotationUtils.targetRotation.applyStrafeToPlayer(event);
/*  331 */             event.cancelEvent();
/*      */           }  break;
/*      */         case 3556498:
/*  334 */           if (str.equals("test")) {
/*  335 */             if (RotationUtils.targetRotation != null) { Rotation rotation = RotationUtils.targetRotation; float yaw = rotation.component1();
/*  336 */               float strafe = event.getStrafe();
/*  337 */               float forward = event.getForward();
/*  338 */               float friction = event.getFriction();
/*  339 */               float factor = strafe * strafe + forward * forward;
/*      */               
/*  341 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  int angleDiff = (int)((WMathHelper.wrapAngleTo180_float(MinecraftInstance.mc.getThePlayer().getRotationYaw() - yaw - 22.5F - 135.0F) + 180.0D) / 45.0D);
/*      */               
/*  343 */               float calcYaw = ((Boolean)this.testSilentValue.get()).booleanValue() ? (yaw + 45.0F * angleDiff) : yaw;
/*      */               
/*  345 */               float calcMoveDir = Math.max(Math.abs(strafe), Math.abs(forward));
/*  346 */               float f1 = calcMoveDir * calcMoveDir;
/*  347 */               float f2 = f1 / Math.min(1.0F, f1 * 2.0F); boolean bool1 = false; float calcMultiplier = (float)Math.sqrt(f2);
/*      */               
/*  349 */               if (((Boolean)this.testSilentValue.get()).booleanValue()) {
/*  350 */                 switch (angleDiff) { case 1: case 3: case 5: case 7:
/*      */                   case 9:
/*  352 */                     if ((Math.abs(forward) > 0.005D || Math.abs(strafe) > 0.005D) && (Math.abs(forward) <= 0.005D || Math.abs(strafe) <= 0.005D)) {
/*  353 */                       friction /= calcMultiplier; break;
/*  354 */                     }  if (Math.abs(forward) > 0.005D && Math.abs(strafe) > 0.005D) {
/*  355 */                       friction *= calcMultiplier;
/*      */                     }
/*      */                     break; }
/*      */               
/*      */               }
/*  360 */               if (factor >= 1.0E-4F) {
/*  361 */                 boolean bool2 = false; float f = (float)Math.sqrt(factor);
/*      */                 
/*  363 */                 if (f < 1.0F) {
/*  364 */                   f = 1.0F;
/*      */                 }
/*      */                 
/*  367 */                 f = friction / f;
/*  368 */                 strafe *= f;
/*  369 */                 forward *= f;
/*      */                 
/*  371 */                 float f3 = (float)(calcYaw * Math.PI / 180.0F); boolean bool3 = false; float yawSin = (float)Math.sin(f3);
/*  372 */                 float f4 = (float)(calcYaw * Math.PI / 180.0F); boolean bool4 = false; float yawCos = (float)Math.cos(f4);
/*      */                 
/*  374 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionX(MinecraftInstance.mc.getThePlayer().getMotionX() + (strafe * yawCos - forward * yawSin));
/*  375 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionZ(MinecraftInstance.mc.getThePlayer().getMotionZ() + (forward * yawCos + strafe * yawSin));
/*      */               } 
/*  377 */               event.cancelEvent();
/*      */               break; }
/*      */             
/*      */             return;
/*      */           } 
/*      */           break;
/*      */         case -891986231:
/*      */           if (str.equals("strict")) {
/*      */             if (RotationUtils.targetRotation != null) {
/*      */               Rotation rotation = RotationUtils.targetRotation;
/*      */               float yaw = rotation.component1();
/*      */               float f1 = event.getStrafe();
/*      */               float f2 = event.getForward();
/*      */               float f3 = event.getFriction();
/*      */               float f4 = f1 * f1 + f2 * f2;
/*      */               if (f4 >= 1.0E-4F) {
/*      */                 boolean bool1 = false;
/*      */                 f4 = (float)Math.sqrt(f4);
/*      */                 if (f4 < 1.0F) {
/*      */                   f4 = 1.0F;
/*      */                 }
/*      */                 f4 = f3 / f4;
/*      */                 f1 *= f4;
/*      */                 f2 *= f4;
/*      */                 float f5 = (float)(yaw * Math.PI / 180.0F);
/*      */                 boolean bool2 = false;
/*      */                 float yawSin = (float)Math.sin(f5);
/*      */                 float f6 = (float)(yaw * Math.PI / 180.0F);
/*      */                 boolean bool3 = false;
/*      */                 float yawCos = (float)Math.cos(f6);
/*      */                 if (MinecraftInstance.mc.getThePlayer() == null) {
/*      */                   Intrinsics.throwNpe();
/*      */                 }
/*      */                 IEntityPlayerSP iEntityPlayerSP = MinecraftInstance.mc.getThePlayer();
/*      */                 iEntityPlayerSP.setMotionX(iEntityPlayerSP.getMotionX() + (f1 * yawCos - f2 * yawSin));
/*      */                 iEntityPlayerSP.setMotionZ(iEntityPlayerSP.getMotionZ() + (f2 * yawCos + f1 * yawSin));
/*      */               } 
/*      */               event.cancelEvent();
/*      */               break;
/*      */             } 
/*      */             return;
/*      */           } 
/*      */           break;
/*      */       } 
/*      */     } 
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
/*      */   public final void update() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: astore_1
/*      */     //   2: iconst_0
/*      */     //   3: istore_2
/*      */     //   4: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   7: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   12: dup
/*      */     //   13: ifnonnull -> 19
/*      */     //   16: invokestatic throwNpe : ()V
/*      */     //   19: invokeinterface isSpectator : ()Z
/*      */     //   24: ifne -> 368
/*      */     //   27: aload_1
/*      */     //   28: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   31: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   36: dup
/*      */     //   37: ifnonnull -> 43
/*      */     //   40: invokestatic throwNpe : ()V
/*      */     //   43: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   46: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   49: ifeq -> 368
/*      */     //   52: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   55: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   58: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   61: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   64: invokevirtual getState : ()Z
/*      */     //   67: ifne -> 368
/*      */     //   70: aload_1
/*      */     //   71: invokestatic access$getB$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)I
/*      */     //   74: ifgt -> 368
/*      */     //   77: aload_1
/*      */     //   78: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   81: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   84: checkcast java/lang/Boolean
/*      */     //   87: invokevirtual booleanValue : ()Z
/*      */     //   90: ifeq -> 157
/*      */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   96: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   101: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   106: invokeinterface isKeyDown : ()Z
/*      */     //   111: ifeq -> 157
/*      */     //   114: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   117: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   120: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   125: dup
/*      */     //   126: ifnonnull -> 132
/*      */     //   129: invokestatic throwNpe : ()V
/*      */     //   132: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   137: dup
/*      */     //   138: ifnonnull -> 144
/*      */     //   141: invokestatic throwNpe : ()V
/*      */     //   144: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   149: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   154: ifne -> 368
/*      */     //   157: aload_1
/*      */     //   158: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   161: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   164: checkcast java/lang/Boolean
/*      */     //   167: invokevirtual booleanValue : ()Z
/*      */     //   170: ifeq -> 239
/*      */     //   173: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   176: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   181: dup
/*      */     //   182: ifnonnull -> 188
/*      */     //   185: invokestatic throwNpe : ()V
/*      */     //   188: invokeinterface isUsingItem : ()Z
/*      */     //   193: ifeq -> 239
/*      */     //   196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   199: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   202: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   207: dup
/*      */     //   208: ifnonnull -> 214
/*      */     //   211: invokestatic throwNpe : ()V
/*      */     //   214: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   219: dup
/*      */     //   220: ifnonnull -> 226
/*      */     //   223: invokestatic throwNpe : ()V
/*      */     //   226: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   231: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   236: ifne -> 368
/*      */     //   239: aload_1
/*      */     //   240: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   243: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   246: checkcast java/lang/Boolean
/*      */     //   249: invokevirtual booleanValue : ()Z
/*      */     //   252: ifeq -> 316
/*      */     //   255: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   258: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   261: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest
/*      */     //   264: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   267: invokevirtual getState : ()Z
/*      */     //   270: ifeq -> 316
/*      */     //   273: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   276: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   279: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   284: dup
/*      */     //   285: ifnonnull -> 291
/*      */     //   288: invokestatic throwNpe : ()V
/*      */     //   291: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   296: dup
/*      */     //   297: ifnonnull -> 303
/*      */     //   300: invokestatic throwNpe : ()V
/*      */     //   303: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   308: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   313: ifne -> 368
/*      */     //   316: aload_1
/*      */     //   317: invokestatic access$getNodigging$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   320: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   323: checkcast java/lang/Boolean
/*      */     //   326: invokevirtual booleanValue : ()Z
/*      */     //   329: ifeq -> 350
/*      */     //   332: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   335: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   340: invokeinterface getCurBlockDamageMP : ()F
/*      */     //   345: fconst_0
/*      */     //   346: fcmpg
/*      */     //   347: ifne -> 368
/*      */     //   350: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   353: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   356: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   359: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   362: invokevirtual getState : ()Z
/*      */     //   365: ifeq -> 372
/*      */     //   368: iconst_1
/*      */     //   369: goto -> 373
/*      */     //   372: iconst_0
/*      */     //   373: ifne -> 436
/*      */     //   376: aload_0
/*      */     //   377: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   380: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   383: checkcast java/lang/Boolean
/*      */     //   386: invokevirtual booleanValue : ()Z
/*      */     //   389: ifeq -> 437
/*      */     //   392: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   395: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   398: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   403: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   408: ifne -> 436
/*      */     //   411: invokestatic currentTimeMillis : ()J
/*      */     //   414: aload_0
/*      */     //   415: getfield containerOpen : J
/*      */     //   418: lsub
/*      */     //   419: aload_0
/*      */     //   420: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   423: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   426: checkcast java/lang/Number
/*      */     //   429: invokevirtual longValue : ()J
/*      */     //   432: lcmp
/*      */     //   433: ifge -> 437
/*      */     //   436: return
/*      */     //   437: aload_0
/*      */     //   438: invokespecial updateTarget : ()V
/*      */     //   441: aload_0
/*      */     //   442: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   445: ifnonnull -> 453
/*      */     //   448: aload_0
/*      */     //   449: invokespecial stopBlocking : ()V
/*      */     //   452: return
/*      */     //   453: aload_0
/*      */     //   454: aload_0
/*      */     //   455: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   458: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   461: aload_0
/*      */     //   462: getfield targetModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   465: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   468: checkcast java/lang/String
/*      */     //   471: ldc_w 'Switch'
/*      */     //   474: iconst_1
/*      */     //   475: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   478: ifne -> 503
/*      */     //   481: aload_0
/*      */     //   482: aload_0
/*      */     //   483: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   486: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   489: invokespecial isEnemy : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */     //   492: ifeq -> 503
/*      */     //   495: aload_0
/*      */     //   496: aload_0
/*      */     //   497: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   500: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   503: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #385	-> 0
/*      */     //   #386	-> 0
/*      */     //   #385	-> 2
/*      */     //   #1063	-> 4
/*      */     //   #1064	-> 4
/*      */     //   #1065	-> 4
/*      */     //   #1066	-> 4
/*      */     //   #1067	-> 4
/*      */     //   #1068	-> 4
/*      */     //   #1069	-> 4
/*      */     //   #1070	-> 4
/*      */     //   #1063	-> 28
/*      */     //   #1064	-> 52
/*      */     //   #1066	-> 77
/*      */     //   #1067	-> 157
/*      */     //   #1068	-> 239
/*      */     //   #1069	-> 316
/*      */     //   #1070	-> 350
/*      */     //   #385	-> 376
/*      */     //   #386	-> 411
/*      */     //   #387	-> 436
/*      */     //   #389	-> 437
/*      */     //   #392	-> 441
/*      */     //   #393	-> 448
/*      */     //   #394	-> 452
/*      */     //   #401	-> 453
/*      */     //   #403	-> 461
/*      */     //   #404	-> 495
/*      */     //   #405	-> 503
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   2	371	1	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   4	369	2	$i$f$getCancelRun	I
/*      */     //   0	504	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
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
/*      */   @EventTarget
/*      */   public final void onUpdate(@NotNull UpdateEvent event) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   10: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   15: dup
/*      */     //   16: ifnull -> 22
/*      */     //   19: goto -> 24
/*      */     //   22: pop
/*      */     //   23: return
/*      */     //   24: astore_2
/*      */     //   25: aload_0
/*      */     //   26: getfield rotationrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   29: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   32: checkcast java/lang/Number
/*      */     //   35: invokevirtual floatValue : ()F
/*      */     //   38: aload_0
/*      */     //   39: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   42: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   45: checkcast java/lang/Number
/*      */     //   48: invokevirtual floatValue : ()F
/*      */     //   51: fcmpg
/*      */     //   52: ifge -> 69
/*      */     //   55: aload_0
/*      */     //   56: getfield rotationrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   59: aload_0
/*      */     //   60: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   63: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   66: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   69: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   72: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   75: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   80: dup
/*      */     //   81: ifnonnull -> 87
/*      */     //   84: invokestatic throwNpe : ()V
/*      */     //   87: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   92: dup
/*      */     //   93: ifnonnull -> 99
/*      */     //   96: invokestatic throwNpe : ()V
/*      */     //   99: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   104: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   109: ifeq -> 144
/*      */     //   112: aload_0
/*      */     //   113: getfield noBlocking : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   116: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   119: checkcast java/lang/Boolean
/*      */     //   122: invokevirtual booleanValue : ()Z
/*      */     //   125: ifeq -> 144
/*      */     //   128: aload_0
/*      */     //   129: getfield fovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   132: ldc_w 60.0
/*      */     //   135: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   138: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   141: goto -> 157
/*      */     //   144: aload_0
/*      */     //   145: getfield fovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   148: ldc_w 180.0
/*      */     //   151: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   154: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   157: aload_0
/*      */     //   158: dup
/*      */     //   159: getfield jump : I
/*      */     //   162: dup
/*      */     //   163: istore_3
/*      */     //   164: iconst_1
/*      */     //   165: iadd
/*      */     //   166: putfield jump : I
/*      */     //   169: aload_0
/*      */     //   170: getfield noBlocking : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   173: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   176: checkcast java/lang/Boolean
/*      */     //   179: invokevirtual booleanValue : ()Z
/*      */     //   182: ifeq -> 257
/*      */     //   185: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   188: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   193: dup
/*      */     //   194: ifnonnull -> 200
/*      */     //   197: invokestatic throwNpe : ()V
/*      */     //   200: invokeinterface isUsingItem : ()Z
/*      */     //   205: ifeq -> 257
/*      */     //   208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   211: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   214: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   219: dup
/*      */     //   220: ifnonnull -> 226
/*      */     //   223: invokestatic throwNpe : ()V
/*      */     //   226: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   231: dup
/*      */     //   232: ifnonnull -> 238
/*      */     //   235: invokestatic throwNpe : ()V
/*      */     //   238: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   243: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   248: ifeq -> 257
/*      */     //   251: aload_0
/*      */     //   252: bipush #20
/*      */     //   254: putfield b : I
/*      */     //   257: aload_0
/*      */     //   258: getfield BackBypass : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   261: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   264: checkcast java/lang/Boolean
/*      */     //   267: invokevirtual booleanValue : ()Z
/*      */     //   270: ifeq -> 323
/*      */     //   273: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   276: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   281: invokeinterface getKeyBindBack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   286: invokeinterface isKeyDown : ()Z
/*      */     //   291: ifeq -> 310
/*      */     //   294: aload_0
/*      */     //   295: getfield fovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   298: ldc_w 30.0
/*      */     //   301: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   304: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   307: goto -> 323
/*      */     //   310: aload_0
/*      */     //   311: getfield fovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   314: ldc_w 180.0
/*      */     //   317: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   320: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   323: aload_0
/*      */     //   324: getfield lightingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   327: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   330: checkcast java/lang/Boolean
/*      */     //   333: invokevirtual booleanValue : ()Z
/*      */     //   336: ifeq -> 898
/*      */     //   339: aload_0
/*      */     //   340: getfield lightingModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   343: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   346: checkcast java/lang/String
/*      */     //   349: astore_3
/*      */     //   350: iconst_0
/*      */     //   351: istore #4
/*      */     //   353: aload_3
/*      */     //   354: dup
/*      */     //   355: ifnonnull -> 369
/*      */     //   358: new kotlin/TypeCastException
/*      */     //   361: dup
/*      */     //   362: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   365: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   368: athrow
/*      */     //   369: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   372: dup
/*      */     //   373: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   376: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   379: astore_3
/*      */     //   380: aload_3
/*      */     //   381: invokevirtual hashCode : ()I
/*      */     //   384: lookupswitch default -> 898, -1407259064 -> 412, 3079268 -> 425
/*      */     //   412: aload_3
/*      */     //   413: ldc_w 'attack'
/*      */     //   416: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   419: ifeq -> 898
/*      */     //   422: goto -> 775
/*      */     //   425: aload_3
/*      */     //   426: ldc_w 'dead'
/*      */     //   429: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   432: ifeq -> 898
/*      */     //   435: aload_0
/*      */     //   436: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   439: ifnull -> 612
/*      */     //   442: aload_0
/*      */     //   443: aload_0
/*      */     //   444: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   447: ifnonnull -> 457
/*      */     //   450: aload_0
/*      */     //   451: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   454: goto -> 606
/*      */     //   457: aload_0
/*      */     //   458: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   461: dup
/*      */     //   462: ifnonnull -> 468
/*      */     //   465: invokestatic throwNpe : ()V
/*      */     //   468: invokeinterface getHealth : ()F
/*      */     //   473: iconst_0
/*      */     //   474: i2f
/*      */     //   475: fcmpg
/*      */     //   476: ifgt -> 602
/*      */     //   479: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   482: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   487: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   490: dup
/*      */     //   491: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   494: dup
/*      */     //   495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   498: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   501: checkcast net/minecraft/world/World
/*      */     //   504: aload_0
/*      */     //   505: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   508: dup
/*      */     //   509: ifnonnull -> 515
/*      */     //   512: invokestatic throwNpe : ()V
/*      */     //   515: invokeinterface getPosX : ()D
/*      */     //   520: aload_0
/*      */     //   521: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   524: dup
/*      */     //   525: ifnonnull -> 531
/*      */     //   528: invokestatic throwNpe : ()V
/*      */     //   531: invokeinterface getPosY : ()D
/*      */     //   536: aload_0
/*      */     //   537: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   540: dup
/*      */     //   541: ifnonnull -> 547
/*      */     //   544: invokestatic throwNpe : ()V
/*      */     //   547: invokeinterface getPosZ : ()D
/*      */     //   552: iconst_1
/*      */     //   553: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   556: checkcast net/minecraft/entity/Entity
/*      */     //   559: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   562: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   567: aload_0
/*      */     //   568: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   571: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   574: checkcast java/lang/Boolean
/*      */     //   577: invokevirtual booleanValue : ()Z
/*      */     //   580: ifeq -> 602
/*      */     //   583: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   586: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   591: ldc_w 'entity.lightning.impact'
/*      */     //   594: ldc_w 0.5
/*      */     //   597: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   602: aload_0
/*      */     //   603: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   606: putfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   609: goto -> 898
/*      */     //   612: aload_0
/*      */     //   613: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   616: ifnull -> 772
/*      */     //   619: aload_0
/*      */     //   620: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   623: dup
/*      */     //   624: ifnonnull -> 630
/*      */     //   627: invokestatic throwNpe : ()V
/*      */     //   630: invokeinterface getHealth : ()F
/*      */     //   635: iconst_0
/*      */     //   636: i2f
/*      */     //   637: fcmpg
/*      */     //   638: ifgt -> 772
/*      */     //   641: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   644: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   649: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   652: dup
/*      */     //   653: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   656: dup
/*      */     //   657: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   660: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   663: checkcast net/minecraft/world/World
/*      */     //   666: aload_0
/*      */     //   667: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   670: dup
/*      */     //   671: ifnonnull -> 677
/*      */     //   674: invokestatic throwNpe : ()V
/*      */     //   677: invokeinterface getPosX : ()D
/*      */     //   682: aload_0
/*      */     //   683: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   686: dup
/*      */     //   687: ifnonnull -> 693
/*      */     //   690: invokestatic throwNpe : ()V
/*      */     //   693: invokeinterface getPosY : ()D
/*      */     //   698: aload_0
/*      */     //   699: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   702: dup
/*      */     //   703: ifnonnull -> 709
/*      */     //   706: invokestatic throwNpe : ()V
/*      */     //   709: invokeinterface getPosZ : ()D
/*      */     //   714: iconst_1
/*      */     //   715: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   718: checkcast net/minecraft/entity/Entity
/*      */     //   721: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   724: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   729: aload_0
/*      */     //   730: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   733: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   736: checkcast java/lang/Boolean
/*      */     //   739: invokevirtual booleanValue : ()Z
/*      */     //   742: ifeq -> 764
/*      */     //   745: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   748: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   753: ldc_w 'entity.lightning.impact'
/*      */     //   756: ldc_w 0.5
/*      */     //   759: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   764: aload_0
/*      */     //   765: aload_0
/*      */     //   766: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   769: putfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   772: goto -> 898
/*      */     //   775: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   778: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   783: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   786: dup
/*      */     //   787: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   790: dup
/*      */     //   791: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   794: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   797: checkcast net/minecraft/world/World
/*      */     //   800: aload_0
/*      */     //   801: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   804: dup
/*      */     //   805: ifnonnull -> 811
/*      */     //   808: invokestatic throwNpe : ()V
/*      */     //   811: invokeinterface getPosX : ()D
/*      */     //   816: aload_0
/*      */     //   817: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   820: dup
/*      */     //   821: ifnonnull -> 827
/*      */     //   824: invokestatic throwNpe : ()V
/*      */     //   827: invokeinterface getPosY : ()D
/*      */     //   832: aload_0
/*      */     //   833: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   836: dup
/*      */     //   837: ifnonnull -> 843
/*      */     //   840: invokestatic throwNpe : ()V
/*      */     //   843: invokeinterface getPosZ : ()D
/*      */     //   848: iconst_1
/*      */     //   849: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   852: checkcast net/minecraft/entity/Entity
/*      */     //   855: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   858: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   863: aload_0
/*      */     //   864: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   867: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   870: checkcast java/lang/Boolean
/*      */     //   873: invokevirtual booleanValue : ()Z
/*      */     //   876: ifeq -> 898
/*      */     //   879: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   882: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   887: ldc_w 'entity.lightning.impact'
/*      */     //   890: ldc_w 0.5
/*      */     //   893: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   898: aload_0
/*      */     //   899: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   902: ifnull -> 949
/*      */     //   905: aload_0
/*      */     //   906: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   909: dup
/*      */     //   910: ifnonnull -> 916
/*      */     //   913: invokestatic throwNpe : ()V
/*      */     //   916: invokeinterface isDead : ()Z
/*      */     //   921: ifeq -> 949
/*      */     //   924: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura.Companion : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$Companion;
/*      */     //   927: dup
/*      */     //   928: dup
/*      */     //   929: invokevirtual getKillCounts : ()I
/*      */     //   932: iconst_1
/*      */     //   933: iadd
/*      */     //   934: invokevirtual setKillCounts : (I)V
/*      */     //   937: invokevirtual getKillCounts : ()I
/*      */     //   940: pop
/*      */     //   941: aload_0
/*      */     //   942: aconst_null
/*      */     //   943: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   946: putfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   949: aload_0
/*      */     //   950: astore_3
/*      */     //   951: iconst_0
/*      */     //   952: istore #4
/*      */     //   954: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   957: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   962: dup
/*      */     //   963: ifnonnull -> 969
/*      */     //   966: invokestatic throwNpe : ()V
/*      */     //   969: invokeinterface isSpectator : ()Z
/*      */     //   974: ifne -> 1318
/*      */     //   977: aload_3
/*      */     //   978: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   981: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   986: dup
/*      */     //   987: ifnonnull -> 993
/*      */     //   990: invokestatic throwNpe : ()V
/*      */     //   993: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   996: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   999: ifeq -> 1318
/*      */     //   1002: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1005: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1008: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   1011: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1014: invokevirtual getState : ()Z
/*      */     //   1017: ifne -> 1318
/*      */     //   1020: aload_3
/*      */     //   1021: invokestatic access$getB$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)I
/*      */     //   1024: ifgt -> 1318
/*      */     //   1027: aload_3
/*      */     //   1028: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1031: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1034: checkcast java/lang/Boolean
/*      */     //   1037: invokevirtual booleanValue : ()Z
/*      */     //   1040: ifeq -> 1107
/*      */     //   1043: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1046: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   1051: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   1056: invokeinterface isKeyDown : ()Z
/*      */     //   1061: ifeq -> 1107
/*      */     //   1064: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1067: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1070: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1075: dup
/*      */     //   1076: ifnonnull -> 1082
/*      */     //   1079: invokestatic throwNpe : ()V
/*      */     //   1082: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   1087: dup
/*      */     //   1088: ifnonnull -> 1094
/*      */     //   1091: invokestatic throwNpe : ()V
/*      */     //   1094: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   1099: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   1104: ifne -> 1318
/*      */     //   1107: aload_3
/*      */     //   1108: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1111: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1114: checkcast java/lang/Boolean
/*      */     //   1117: invokevirtual booleanValue : ()Z
/*      */     //   1120: ifeq -> 1189
/*      */     //   1123: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1126: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1131: dup
/*      */     //   1132: ifnonnull -> 1138
/*      */     //   1135: invokestatic throwNpe : ()V
/*      */     //   1138: invokeinterface isUsingItem : ()Z
/*      */     //   1143: ifeq -> 1189
/*      */     //   1146: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1149: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1152: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1157: dup
/*      */     //   1158: ifnonnull -> 1164
/*      */     //   1161: invokestatic throwNpe : ()V
/*      */     //   1164: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   1169: dup
/*      */     //   1170: ifnonnull -> 1176
/*      */     //   1173: invokestatic throwNpe : ()V
/*      */     //   1176: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   1181: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   1186: ifne -> 1318
/*      */     //   1189: aload_3
/*      */     //   1190: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1193: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1196: checkcast java/lang/Boolean
/*      */     //   1199: invokevirtual booleanValue : ()Z
/*      */     //   1202: ifeq -> 1266
/*      */     //   1205: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1208: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1211: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest
/*      */     //   1214: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1217: invokevirtual getState : ()Z
/*      */     //   1220: ifeq -> 1266
/*      */     //   1223: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1226: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1229: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1234: dup
/*      */     //   1235: ifnonnull -> 1241
/*      */     //   1238: invokestatic throwNpe : ()V
/*      */     //   1241: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   1246: dup
/*      */     //   1247: ifnonnull -> 1253
/*      */     //   1250: invokestatic throwNpe : ()V
/*      */     //   1253: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   1258: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   1263: ifne -> 1318
/*      */     //   1266: aload_3
/*      */     //   1267: invokestatic access$getNodigging$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1270: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1273: checkcast java/lang/Boolean
/*      */     //   1276: invokevirtual booleanValue : ()Z
/*      */     //   1279: ifeq -> 1300
/*      */     //   1282: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1285: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   1290: invokeinterface getCurBlockDamageMP : ()F
/*      */     //   1295: fconst_0
/*      */     //   1296: fcmpg
/*      */     //   1297: ifne -> 1318
/*      */     //   1300: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1303: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1306: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   1309: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1312: invokevirtual getState : ()Z
/*      */     //   1315: ifeq -> 1322
/*      */     //   1318: iconst_1
/*      */     //   1319: goto -> 1323
/*      */     //   1322: iconst_0
/*      */     //   1323: ifeq -> 1352
/*      */     //   1326: aload_0
/*      */     //   1327: aconst_null
/*      */     //   1328: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1331: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1334: aload_0
/*      */     //   1335: aconst_null
/*      */     //   1336: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1339: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1342: aload_0
/*      */     //   1343: iconst_0
/*      */     //   1344: putfield hitable : Z
/*      */     //   1347: aload_0
/*      */     //   1348: invokespecial stopBlocking : ()V
/*      */     //   1351: return
/*      */     //   1352: aload_0
/*      */     //   1353: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1356: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1359: checkcast java/lang/Boolean
/*      */     //   1362: invokevirtual booleanValue : ()Z
/*      */     //   1365: ifeq -> 1460
/*      */     //   1368: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1371: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1374: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1379: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1384: ifne -> 1412
/*      */     //   1387: invokestatic currentTimeMillis : ()J
/*      */     //   1390: aload_0
/*      */     //   1391: getfield containerOpen : J
/*      */     //   1394: lsub
/*      */     //   1395: aload_0
/*      */     //   1396: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1399: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1402: checkcast java/lang/Number
/*      */     //   1405: invokevirtual longValue : ()J
/*      */     //   1408: lcmp
/*      */     //   1409: ifge -> 1460
/*      */     //   1412: aload_0
/*      */     //   1413: aconst_null
/*      */     //   1414: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1417: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1420: aload_0
/*      */     //   1421: aconst_null
/*      */     //   1422: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1425: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1428: aload_0
/*      */     //   1429: iconst_0
/*      */     //   1430: putfield hitable : Z
/*      */     //   1433: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1436: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1439: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1444: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1449: ifeq -> 1459
/*      */     //   1452: aload_0
/*      */     //   1453: invokestatic currentTimeMillis : ()J
/*      */     //   1456: putfield containerOpen : J
/*      */     //   1459: return
/*      */     //   1460: aload_0
/*      */     //   1461: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1464: ifnull -> 1538
/*      */     //   1467: aload_0
/*      */     //   1468: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1471: ifnull -> 1538
/*      */     //   1474: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1477: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1482: dup
/*      */     //   1483: ifnonnull -> 1489
/*      */     //   1486: invokestatic throwNpe : ()V
/*      */     //   1489: fconst_0
/*      */     //   1490: invokeinterface getCooledAttackStrength : (F)F
/*      */     //   1495: aload_0
/*      */     //   1496: getfield cooldownValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1499: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1502: checkcast java/lang/Number
/*      */     //   1505: invokevirtual floatValue : ()F
/*      */     //   1508: fcmpl
/*      */     //   1509: iflt -> 1538
/*      */     //   1512: aload_0
/*      */     //   1513: getfield clicks : I
/*      */     //   1516: ifle -> 1538
/*      */     //   1519: aload_0
/*      */     //   1520: invokespecial runAttack : ()V
/*      */     //   1523: aload_0
/*      */     //   1524: dup
/*      */     //   1525: getfield clicks : I
/*      */     //   1528: dup
/*      */     //   1529: istore_3
/*      */     //   1530: iconst_m1
/*      */     //   1531: iadd
/*      */     //   1532: putfield clicks : I
/*      */     //   1535: goto -> 1512
/*      */     //   1538: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #414	-> 7
/*      */     //   #414	-> 22
/*      */     //   #415	-> 25
/*      */     //   #416	-> 55
/*      */     //   #418	-> 69
/*      */     //   #419	-> 128
/*      */     //   #421	-> 144
/*      */     //   #422	-> 157
/*      */     //   #423	-> 157
/*      */     //   #424	-> 169
/*      */     //   #425	-> 251
/*      */     //   #428	-> 257
/*      */     //   #429	-> 273
/*      */     //   #430	-> 294
/*      */     //   #432	-> 323
/*      */     //   #433	-> 339
/*      */     //   #464	-> 412
/*      */     //   #434	-> 425
/*      */     //   #435	-> 435
/*      */     //   #436	-> 442
/*      */     //   #437	-> 450
/*      */     //   #439	-> 457
/*      */     //   #440	-> 479
/*      */     //   #441	-> 487
/*      */     //   #442	-> 491
/*      */     //   #443	-> 504
/*      */     //   #442	-> 553
/*      */     //   #441	-> 559
/*      */     //   #440	-> 562
/*      */     //   #446	-> 567
/*      */     //   #448	-> 602
/*      */     //   #436	-> 606
/*      */     //   #451	-> 612
/*      */     //   #452	-> 641
/*      */     //   #453	-> 649
/*      */     //   #454	-> 653
/*      */     //   #455	-> 666
/*      */     //   #454	-> 715
/*      */     //   #453	-> 721
/*      */     //   #452	-> 724
/*      */     //   #458	-> 729
/*      */     //   #459	-> 764
/*      */     //   #461	-> 772
/*      */     //   #465	-> 775
/*      */     //   #466	-> 783
/*      */     //   #467	-> 787
/*      */     //   #468	-> 800
/*      */     //   #467	-> 849
/*      */     //   #466	-> 855
/*      */     //   #465	-> 858
/*      */     //   #471	-> 863
/*      */     //   #473	-> 898
/*      */     //   #475	-> 898
/*      */     //   #476	-> 924
/*      */     //   #477	-> 941
/*      */     //   #480	-> 949
/*      */     //   #1071	-> 954
/*      */     //   #1072	-> 954
/*      */     //   #1073	-> 954
/*      */     //   #1074	-> 954
/*      */     //   #1075	-> 954
/*      */     //   #1076	-> 954
/*      */     //   #1077	-> 954
/*      */     //   #1078	-> 954
/*      */     //   #1071	-> 978
/*      */     //   #1072	-> 1002
/*      */     //   #1074	-> 1027
/*      */     //   #1075	-> 1107
/*      */     //   #1076	-> 1189
/*      */     //   #1077	-> 1266
/*      */     //   #1078	-> 1300
/*      */     //   #481	-> 1326
/*      */     //   #482	-> 1334
/*      */     //   #483	-> 1342
/*      */     //   #484	-> 1347
/*      */     //   #485	-> 1351
/*      */     //   #487	-> 1352
/*      */     //   #488	-> 1352
/*      */     //   #487	-> 1352
/*      */     //   #488	-> 1387
/*      */     //   #489	-> 1412
/*      */     //   #490	-> 1420
/*      */     //   #491	-> 1428
/*      */     //   #492	-> 1433
/*      */     //   #493	-> 1459
/*      */     //   #497	-> 1460
/*      */     //   #498	-> 1512
/*      */     //   #499	-> 1519
/*      */     //   #500	-> 1523
/*      */     //   #498	-> 1535
/*      */     //   #503	-> 1538
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   951	372	3	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   954	369	4	$i$f$getCancelRun	I
/*      */     //   25	1514	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	1539	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   0	1539	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*      */   @EventTarget
/*      */   public final void onRender3D(@NotNull Render3DEvent event) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: aload_0
/*      */     //   8: getfield circleValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   14: checkcast java/lang/Boolean
/*      */     //   17: invokevirtual booleanValue : ()Z
/*      */     //   20: ifeq -> 619
/*      */     //   23: invokestatic glPushMatrix : ()V
/*      */     //   26: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   29: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   34: dup
/*      */     //   35: ifnonnull -> 41
/*      */     //   38: invokestatic throwNpe : ()V
/*      */     //   41: invokeinterface getLastTickPosX : ()D
/*      */     //   46: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   49: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   54: dup
/*      */     //   55: ifnonnull -> 61
/*      */     //   58: invokestatic throwNpe : ()V
/*      */     //   61: invokeinterface getPosX : ()D
/*      */     //   66: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   69: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   74: dup
/*      */     //   75: ifnonnull -> 81
/*      */     //   78: invokestatic throwNpe : ()V
/*      */     //   81: invokeinterface getLastTickPosX : ()D
/*      */     //   86: dsub
/*      */     //   87: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   90: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   95: invokeinterface getRenderPartialTicks : ()F
/*      */     //   100: f2d
/*      */     //   101: dmul
/*      */     //   102: dadd
/*      */     //   103: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   106: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   111: invokeinterface getRenderPosX : ()D
/*      */     //   116: dsub
/*      */     //   117: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   120: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   125: dup
/*      */     //   126: ifnonnull -> 132
/*      */     //   129: invokestatic throwNpe : ()V
/*      */     //   132: invokeinterface getLastTickPosY : ()D
/*      */     //   137: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   140: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   145: dup
/*      */     //   146: ifnonnull -> 152
/*      */     //   149: invokestatic throwNpe : ()V
/*      */     //   152: invokeinterface getPosY : ()D
/*      */     //   157: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   160: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   165: dup
/*      */     //   166: ifnonnull -> 172
/*      */     //   169: invokestatic throwNpe : ()V
/*      */     //   172: invokeinterface getLastTickPosY : ()D
/*      */     //   177: dsub
/*      */     //   178: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   181: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   186: invokeinterface getRenderPartialTicks : ()F
/*      */     //   191: f2d
/*      */     //   192: dmul
/*      */     //   193: dadd
/*      */     //   194: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   197: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   202: invokeinterface getRenderPosY : ()D
/*      */     //   207: dsub
/*      */     //   208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   211: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   216: dup
/*      */     //   217: ifnonnull -> 223
/*      */     //   220: invokestatic throwNpe : ()V
/*      */     //   223: invokeinterface getLastTickPosZ : ()D
/*      */     //   228: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   231: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   236: dup
/*      */     //   237: ifnonnull -> 243
/*      */     //   240: invokestatic throwNpe : ()V
/*      */     //   243: invokeinterface getPosZ : ()D
/*      */     //   248: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   251: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   256: dup
/*      */     //   257: ifnonnull -> 263
/*      */     //   260: invokestatic throwNpe : ()V
/*      */     //   263: invokeinterface getLastTickPosZ : ()D
/*      */     //   268: dsub
/*      */     //   269: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   272: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   277: invokeinterface getRenderPartialTicks : ()F
/*      */     //   282: f2d
/*      */     //   283: dmul
/*      */     //   284: dadd
/*      */     //   285: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   288: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   293: invokeinterface getRenderPosZ : ()D
/*      */     //   298: dsub
/*      */     //   299: invokestatic glTranslated : (DDD)V
/*      */     //   302: sipush #3042
/*      */     //   305: invokestatic glEnable : (I)V
/*      */     //   308: sipush #2848
/*      */     //   311: invokestatic glEnable : (I)V
/*      */     //   314: sipush #3553
/*      */     //   317: invokestatic glDisable : (I)V
/*      */     //   320: sipush #2929
/*      */     //   323: invokestatic glDisable : (I)V
/*      */     //   326: sipush #770
/*      */     //   329: sipush #771
/*      */     //   332: invokestatic glBlendFunc : (II)V
/*      */     //   335: aload_0
/*      */     //   336: getfield circleThickness : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   339: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   342: checkcast java/lang/Number
/*      */     //   345: invokevirtual intValue : ()I
/*      */     //   348: i2f
/*      */     //   349: invokestatic glLineWidth : (F)V
/*      */     //   352: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   355: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   358: checkcast java/lang/Number
/*      */     //   361: invokevirtual intValue : ()I
/*      */     //   364: i2f
/*      */     //   365: ldc_w 255.0
/*      */     //   368: fdiv
/*      */     //   369: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   372: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   375: checkcast java/lang/Number
/*      */     //   378: invokevirtual intValue : ()I
/*      */     //   381: i2f
/*      */     //   382: ldc_w 255.0
/*      */     //   385: fdiv
/*      */     //   386: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   389: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   392: checkcast java/lang/Number
/*      */     //   395: invokevirtual intValue : ()I
/*      */     //   398: i2f
/*      */     //   399: ldc_w 255.0
/*      */     //   402: fdiv
/*      */     //   403: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.a : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   406: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   409: checkcast java/lang/Number
/*      */     //   412: invokevirtual intValue : ()I
/*      */     //   415: i2f
/*      */     //   416: ldc_w 255.0
/*      */     //   419: fdiv
/*      */     //   420: invokestatic glColor4f : (FFFF)V
/*      */     //   423: ldc_w 90.0
/*      */     //   426: fconst_1
/*      */     //   427: fconst_0
/*      */     //   428: fconst_0
/*      */     //   429: invokestatic glRotatef : (FFFF)V
/*      */     //   432: iconst_3
/*      */     //   433: invokestatic glBegin : (I)V
/*      */     //   436: ldc2_w 6.283185307179586
/*      */     //   439: aload_0
/*      */     //   440: getfield circleAccuracy : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   443: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   446: checkcast java/lang/Number
/*      */     //   449: invokevirtual doubleValue : ()D
/*      */     //   452: ddiv
/*      */     //   453: dstore_2
/*      */     //   454: iconst_0
/*      */     //   455: istore #4
/*      */     //   457: aload_0
/*      */     //   458: getfield circleAccuracy : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   461: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   464: checkcast java/lang/Number
/*      */     //   467: invokevirtual intValue : ()I
/*      */     //   470: istore #5
/*      */     //   472: iload #4
/*      */     //   474: iload #5
/*      */     //   476: if_icmpge -> 572
/*      */     //   479: aload_0
/*      */     //   480: getfield rotationrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   483: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   486: checkcast java/lang/Number
/*      */     //   489: invokevirtual doubleValue : ()D
/*      */     //   492: iload #4
/*      */     //   494: i2d
/*      */     //   495: dload_2
/*      */     //   496: dmul
/*      */     //   497: dstore #7
/*      */     //   499: dstore #24
/*      */     //   501: iconst_0
/*      */     //   502: istore #9
/*      */     //   504: dload #7
/*      */     //   506: invokestatic cos : (D)D
/*      */     //   509: dstore #26
/*      */     //   511: dload #24
/*      */     //   513: dload #26
/*      */     //   515: dmul
/*      */     //   516: d2f
/*      */     //   517: fstore #6
/*      */     //   519: aload_0
/*      */     //   520: getfield rotationrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   523: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   526: checkcast java/lang/Number
/*      */     //   529: invokevirtual doubleValue : ()D
/*      */     //   532: iload #4
/*      */     //   534: i2d
/*      */     //   535: dload_2
/*      */     //   536: dmul
/*      */     //   537: dstore #8
/*      */     //   539: dstore #24
/*      */     //   541: iconst_0
/*      */     //   542: istore #10
/*      */     //   544: dload #8
/*      */     //   546: invokestatic sin : (D)D
/*      */     //   549: dstore #26
/*      */     //   551: dload #24
/*      */     //   553: dload #26
/*      */     //   555: dmul
/*      */     //   556: d2f
/*      */     //   557: fstore #7
/*      */     //   559: fload #6
/*      */     //   561: fload #7
/*      */     //   563: invokestatic glVertex2f : (FF)V
/*      */     //   566: iinc #4, 1
/*      */     //   569: goto -> 472
/*      */     //   572: aload_0
/*      */     //   573: getfield rotationrangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   576: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   579: checkcast java/lang/Number
/*      */     //   582: invokevirtual floatValue : ()F
/*      */     //   585: fconst_0
/*      */     //   586: invokestatic glVertex2f : (FF)V
/*      */     //   589: invokestatic glEnd : ()V
/*      */     //   592: sipush #3042
/*      */     //   595: invokestatic glDisable : (I)V
/*      */     //   598: sipush #3553
/*      */     //   601: invokestatic glEnable : (I)V
/*      */     //   604: sipush #2929
/*      */     //   607: invokestatic glEnable : (I)V
/*      */     //   610: sipush #2848
/*      */     //   613: invokestatic glDisable : (I)V
/*      */     //   616: invokestatic glPopMatrix : ()V
/*      */     //   619: aload_0
/*      */     //   620: astore_2
/*      */     //   621: iconst_0
/*      */     //   622: istore_3
/*      */     //   623: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   626: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   631: dup
/*      */     //   632: ifnonnull -> 638
/*      */     //   635: invokestatic throwNpe : ()V
/*      */     //   638: invokeinterface isSpectator : ()Z
/*      */     //   643: ifne -> 987
/*      */     //   646: aload_2
/*      */     //   647: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   650: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   655: dup
/*      */     //   656: ifnonnull -> 662
/*      */     //   659: invokestatic throwNpe : ()V
/*      */     //   662: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   665: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   668: ifeq -> 987
/*      */     //   671: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   674: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   677: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   680: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   683: invokevirtual getState : ()Z
/*      */     //   686: ifne -> 987
/*      */     //   689: aload_2
/*      */     //   690: invokestatic access$getB$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)I
/*      */     //   693: ifgt -> 987
/*      */     //   696: aload_2
/*      */     //   697: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   700: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   703: checkcast java/lang/Boolean
/*      */     //   706: invokevirtual booleanValue : ()Z
/*      */     //   709: ifeq -> 776
/*      */     //   712: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   715: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   720: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   725: invokeinterface isKeyDown : ()Z
/*      */     //   730: ifeq -> 776
/*      */     //   733: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   736: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   739: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   744: dup
/*      */     //   745: ifnonnull -> 751
/*      */     //   748: invokestatic throwNpe : ()V
/*      */     //   751: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   756: dup
/*      */     //   757: ifnonnull -> 763
/*      */     //   760: invokestatic throwNpe : ()V
/*      */     //   763: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   768: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   773: ifne -> 987
/*      */     //   776: aload_2
/*      */     //   777: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   780: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   783: checkcast java/lang/Boolean
/*      */     //   786: invokevirtual booleanValue : ()Z
/*      */     //   789: ifeq -> 858
/*      */     //   792: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   795: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   800: dup
/*      */     //   801: ifnonnull -> 807
/*      */     //   804: invokestatic throwNpe : ()V
/*      */     //   807: invokeinterface isUsingItem : ()Z
/*      */     //   812: ifeq -> 858
/*      */     //   815: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   818: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   821: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   826: dup
/*      */     //   827: ifnonnull -> 833
/*      */     //   830: invokestatic throwNpe : ()V
/*      */     //   833: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   838: dup
/*      */     //   839: ifnonnull -> 845
/*      */     //   842: invokestatic throwNpe : ()V
/*      */     //   845: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   850: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   855: ifne -> 987
/*      */     //   858: aload_2
/*      */     //   859: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   862: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   865: checkcast java/lang/Boolean
/*      */     //   868: invokevirtual booleanValue : ()Z
/*      */     //   871: ifeq -> 935
/*      */     //   874: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   877: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   880: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest
/*      */     //   883: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   886: invokevirtual getState : ()Z
/*      */     //   889: ifeq -> 935
/*      */     //   892: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   895: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   898: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   903: dup
/*      */     //   904: ifnonnull -> 910
/*      */     //   907: invokestatic throwNpe : ()V
/*      */     //   910: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   915: dup
/*      */     //   916: ifnonnull -> 922
/*      */     //   919: invokestatic throwNpe : ()V
/*      */     //   922: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   927: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   932: ifne -> 987
/*      */     //   935: aload_2
/*      */     //   936: invokestatic access$getNodigging$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   939: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   942: checkcast java/lang/Boolean
/*      */     //   945: invokevirtual booleanValue : ()Z
/*      */     //   948: ifeq -> 969
/*      */     //   951: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   954: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   959: invokeinterface getCurBlockDamageMP : ()F
/*      */     //   964: fconst_0
/*      */     //   965: fcmpg
/*      */     //   966: ifne -> 987
/*      */     //   969: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   972: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   975: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   978: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   981: invokevirtual getState : ()Z
/*      */     //   984: ifeq -> 991
/*      */     //   987: iconst_1
/*      */     //   988: goto -> 992
/*      */     //   991: iconst_0
/*      */     //   992: ifeq -> 1021
/*      */     //   995: aload_0
/*      */     //   996: aconst_null
/*      */     //   997: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1000: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1003: aload_0
/*      */     //   1004: aconst_null
/*      */     //   1005: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1008: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1011: aload_0
/*      */     //   1012: iconst_0
/*      */     //   1013: putfield hitable : Z
/*      */     //   1016: aload_0
/*      */     //   1017: invokespecial stopBlocking : ()V
/*      */     //   1020: return
/*      */     //   1021: aload_0
/*      */     //   1022: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1025: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1028: checkcast java/lang/Boolean
/*      */     //   1031: invokevirtual booleanValue : ()Z
/*      */     //   1034: ifeq -> 1129
/*      */     //   1037: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1040: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1043: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1048: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1053: ifne -> 1081
/*      */     //   1056: invokestatic currentTimeMillis : ()J
/*      */     //   1059: aload_0
/*      */     //   1060: getfield containerOpen : J
/*      */     //   1063: lsub
/*      */     //   1064: aload_0
/*      */     //   1065: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1068: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1071: checkcast java/lang/Number
/*      */     //   1074: invokevirtual longValue : ()J
/*      */     //   1077: lcmp
/*      */     //   1078: ifge -> 1129
/*      */     //   1081: aload_0
/*      */     //   1082: aconst_null
/*      */     //   1083: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1086: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1089: aload_0
/*      */     //   1090: aconst_null
/*      */     //   1091: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1094: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1097: aload_0
/*      */     //   1098: iconst_0
/*      */     //   1099: putfield hitable : Z
/*      */     //   1102: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1105: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1108: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1113: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1118: ifeq -> 1128
/*      */     //   1121: aload_0
/*      */     //   1122: invokestatic currentTimeMillis : ()J
/*      */     //   1125: putfield containerOpen : J
/*      */     //   1128: return
/*      */     //   1129: aload_0
/*      */     //   1130: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1133: dup
/*      */     //   1134: ifnull -> 1140
/*      */     //   1137: goto -> 1142
/*      */     //   1140: pop
/*      */     //   1141: return
/*      */     //   1142: pop
/*      */     //   1143: aload_0
/*      */     //   1144: getfield markValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1147: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1150: checkcast java/lang/String
/*      */     //   1153: astore_2
/*      */     //   1154: iconst_0
/*      */     //   1155: istore_3
/*      */     //   1156: aload_2
/*      */     //   1157: dup
/*      */     //   1158: ifnonnull -> 1172
/*      */     //   1161: new kotlin/TypeCastException
/*      */     //   1164: dup
/*      */     //   1165: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   1168: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   1171: athrow
/*      */     //   1172: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   1175: dup
/*      */     //   1176: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   1179: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   1182: astore_2
/*      */     //   1183: aload_2
/*      */     //   1184: invokevirtual hashCode : ()I
/*      */     //   1187: lookupswitch default -> 2170, -1102567108 -> 1212, 47889015 -> 1225
/*      */     //   1212: aload_2
/*      */     //   1213: ldc_w 'liquid'
/*      */     //   1216: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1219: ifeq -> 2170
/*      */     //   1222: goto -> 1238
/*      */     //   1225: aload_2
/*      */     //   1226: ldc_w 'catblock'
/*      */     //   1229: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1232: ifeq -> 2170
/*      */     //   1235: goto -> 1312
/*      */     //   1238: aload_0
/*      */     //   1239: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1242: dup
/*      */     //   1243: ifnonnull -> 1249
/*      */     //   1246: invokestatic throwNpe : ()V
/*      */     //   1249: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1252: aload_0
/*      */     //   1253: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1256: dup
/*      */     //   1257: ifnonnull -> 1263
/*      */     //   1260: invokestatic throwNpe : ()V
/*      */     //   1263: invokeinterface getHurtTime : ()I
/*      */     //   1268: ifgt -> 1291
/*      */     //   1271: new java/awt/Color
/*      */     //   1274: dup
/*      */     //   1275: bipush #37
/*      */     //   1277: bipush #126
/*      */     //   1279: sipush #255
/*      */     //   1282: sipush #170
/*      */     //   1285: invokespecial <init> : (IIII)V
/*      */     //   1288: goto -> 1306
/*      */     //   1291: new java/awt/Color
/*      */     //   1294: dup
/*      */     //   1295: sipush #255
/*      */     //   1298: iconst_0
/*      */     //   1299: iconst_0
/*      */     //   1300: sipush #170
/*      */     //   1303: invokespecial <init> : (IIII)V
/*      */     //   1306: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1309: goto -> 2170
/*      */     //   1312: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1315: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1320: dup
/*      */     //   1321: ifnonnull -> 1327
/*      */     //   1324: invokestatic throwNpe : ()V
/*      */     //   1327: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1330: aload_0
/*      */     //   1331: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1334: dup
/*      */     //   1335: ifnonnull -> 1341
/*      */     //   1338: invokestatic throwNpe : ()V
/*      */     //   1341: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1344: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   1347: aload_0
/*      */     //   1348: invokespecial getMaxRange : ()F
/*      */     //   1351: f2d
/*      */     //   1352: dcmpl
/*      */     //   1353: ifle -> 1392
/*      */     //   1356: aload_0
/*      */     //   1357: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1360: dup
/*      */     //   1361: ifnonnull -> 1367
/*      */     //   1364: invokestatic throwNpe : ()V
/*      */     //   1367: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1370: new java/awt/Color
/*      */     //   1373: dup
/*      */     //   1374: iconst_0
/*      */     //   1375: sipush #255
/*      */     //   1378: bipush #60
/*      */     //   1380: sipush #255
/*      */     //   1383: invokespecial <init> : (IIII)V
/*      */     //   1386: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1389: goto -> 2170
/*      */     //   1392: aload_0
/*      */     //   1393: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1396: dup
/*      */     //   1397: ifnonnull -> 1403
/*      */     //   1400: invokestatic throwNpe : ()V
/*      */     //   1403: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1408: astore_3
/*      */     //   1409: aload_0
/*      */     //   1410: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1413: dup
/*      */     //   1414: ifnonnull -> 1420
/*      */     //   1417: invokestatic throwNpe : ()V
/*      */     //   1420: aload_3
/*      */     //   1421: ldc2_w 0.2
/*      */     //   1424: ldc2_w 0.2
/*      */     //   1427: ldc2_w 0.2
/*      */     //   1430: invokeinterface expand : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1435: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   1440: aload_0
/*      */     //   1441: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1444: dup
/*      */     //   1445: ifnonnull -> 1451
/*      */     //   1448: invokestatic throwNpe : ()V
/*      */     //   1451: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1454: new java/awt/Color
/*      */     //   1457: dup
/*      */     //   1458: sipush #255
/*      */     //   1461: iconst_0
/*      */     //   1462: iconst_0
/*      */     //   1463: sipush #255
/*      */     //   1466: invokespecial <init> : (IIII)V
/*      */     //   1469: iconst_1
/*      */     //   1470: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*      */     //   1473: aload_0
/*      */     //   1474: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1477: dup
/*      */     //   1478: ifnonnull -> 1484
/*      */     //   1481: invokestatic throwNpe : ()V
/*      */     //   1484: aload_3
/*      */     //   1485: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   1490: invokestatic currentTimeMillis : ()J
/*      */     //   1493: sipush #1500
/*      */     //   1496: i2l
/*      */     //   1497: lrem
/*      */     //   1498: l2i
/*      */     //   1499: istore #4
/*      */     //   1501: iload #4
/*      */     //   1503: sipush #750
/*      */     //   1506: if_icmple -> 1513
/*      */     //   1509: iconst_1
/*      */     //   1510: goto -> 1514
/*      */     //   1513: iconst_0
/*      */     //   1514: istore #5
/*      */     //   1516: iload #4
/*      */     //   1518: i2d
/*      */     //   1519: ldc2_w 750.0
/*      */     //   1522: ddiv
/*      */     //   1523: dstore #6
/*      */     //   1525: iload #5
/*      */     //   1527: ifne -> 1540
/*      */     //   1530: iconst_1
/*      */     //   1531: i2d
/*      */     //   1532: dload #6
/*      */     //   1534: dsub
/*      */     //   1535: dstore #6
/*      */     //   1537: goto -> 1547
/*      */     //   1540: dload #6
/*      */     //   1542: iconst_1
/*      */     //   1543: i2d
/*      */     //   1544: dsub
/*      */     //   1545: dstore #6
/*      */     //   1547: getstatic net/ccbluex/liquidbounce/utils/render/EaseUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;
/*      */     //   1550: dload #6
/*      */     //   1552: invokevirtual easeInOutQuad : (D)D
/*      */     //   1555: dstore #6
/*      */     //   1557: invokestatic glPushMatrix : ()V
/*      */     //   1560: sipush #3553
/*      */     //   1563: invokestatic glDisable : (I)V
/*      */     //   1566: sipush #2848
/*      */     //   1569: invokestatic glEnable : (I)V
/*      */     //   1572: sipush #2881
/*      */     //   1575: invokestatic glEnable : (I)V
/*      */     //   1578: sipush #2832
/*      */     //   1581: invokestatic glEnable : (I)V
/*      */     //   1584: sipush #3042
/*      */     //   1587: invokestatic glEnable : (I)V
/*      */     //   1590: sipush #770
/*      */     //   1593: sipush #771
/*      */     //   1596: invokestatic glBlendFunc : (II)V
/*      */     //   1599: sipush #3154
/*      */     //   1602: sipush #4354
/*      */     //   1605: invokestatic glHint : (II)V
/*      */     //   1608: sipush #3155
/*      */     //   1611: sipush #4354
/*      */     //   1614: invokestatic glHint : (II)V
/*      */     //   1617: sipush #3153
/*      */     //   1620: sipush #4354
/*      */     //   1623: invokestatic glHint : (II)V
/*      */     //   1626: sipush #2929
/*      */     //   1629: invokestatic glDisable : (I)V
/*      */     //   1632: iconst_0
/*      */     //   1633: invokestatic glDepthMask : (Z)V
/*      */     //   1636: aload_3
/*      */     //   1637: invokeinterface getMaxX : ()D
/*      */     //   1642: aload_3
/*      */     //   1643: invokeinterface getMinX : ()D
/*      */     //   1648: dsub
/*      */     //   1649: ldc2_w 0.3
/*      */     //   1652: dadd
/*      */     //   1653: dstore #8
/*      */     //   1655: aload_3
/*      */     //   1656: invokeinterface getMaxY : ()D
/*      */     //   1661: aload_3
/*      */     //   1662: invokeinterface getMinY : ()D
/*      */     //   1667: dsub
/*      */     //   1668: dstore #10
/*      */     //   1670: aload_0
/*      */     //   1671: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1674: dup
/*      */     //   1675: ifnonnull -> 1681
/*      */     //   1678: invokestatic throwNpe : ()V
/*      */     //   1681: invokeinterface getLastTickPosX : ()D
/*      */     //   1686: aload_0
/*      */     //   1687: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1690: dup
/*      */     //   1691: ifnonnull -> 1697
/*      */     //   1694: invokestatic throwNpe : ()V
/*      */     //   1697: invokeinterface getPosX : ()D
/*      */     //   1702: aload_0
/*      */     //   1703: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1706: dup
/*      */     //   1707: ifnonnull -> 1713
/*      */     //   1710: invokestatic throwNpe : ()V
/*      */     //   1713: invokeinterface getLastTickPosX : ()D
/*      */     //   1718: dsub
/*      */     //   1719: aload_1
/*      */     //   1720: invokevirtual getPartialTicks : ()F
/*      */     //   1723: f2d
/*      */     //   1724: dmul
/*      */     //   1725: dadd
/*      */     //   1726: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1729: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1734: invokeinterface getViewerPosX : ()D
/*      */     //   1739: dsub
/*      */     //   1740: dstore #12
/*      */     //   1742: aload_0
/*      */     //   1743: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1746: dup
/*      */     //   1747: ifnonnull -> 1753
/*      */     //   1750: invokestatic throwNpe : ()V
/*      */     //   1753: invokeinterface getLastTickPosY : ()D
/*      */     //   1758: aload_0
/*      */     //   1759: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1762: dup
/*      */     //   1763: ifnonnull -> 1769
/*      */     //   1766: invokestatic throwNpe : ()V
/*      */     //   1769: invokeinterface getPosY : ()D
/*      */     //   1774: aload_0
/*      */     //   1775: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1778: dup
/*      */     //   1779: ifnonnull -> 1785
/*      */     //   1782: invokestatic throwNpe : ()V
/*      */     //   1785: invokeinterface getLastTickPosY : ()D
/*      */     //   1790: dsub
/*      */     //   1791: aload_1
/*      */     //   1792: invokevirtual getPartialTicks : ()F
/*      */     //   1795: f2d
/*      */     //   1796: dmul
/*      */     //   1797: dadd
/*      */     //   1798: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1801: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1806: invokeinterface getViewerPosY : ()D
/*      */     //   1811: dsub
/*      */     //   1812: dload #10
/*      */     //   1814: dload #6
/*      */     //   1816: dmul
/*      */     //   1817: dadd
/*      */     //   1818: dstore #14
/*      */     //   1820: aload_0
/*      */     //   1821: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1824: dup
/*      */     //   1825: ifnonnull -> 1831
/*      */     //   1828: invokestatic throwNpe : ()V
/*      */     //   1831: invokeinterface getLastTickPosZ : ()D
/*      */     //   1836: aload_0
/*      */     //   1837: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1840: dup
/*      */     //   1841: ifnonnull -> 1847
/*      */     //   1844: invokestatic throwNpe : ()V
/*      */     //   1847: invokeinterface getPosZ : ()D
/*      */     //   1852: aload_0
/*      */     //   1853: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1856: dup
/*      */     //   1857: ifnonnull -> 1863
/*      */     //   1860: invokestatic throwNpe : ()V
/*      */     //   1863: invokeinterface getLastTickPosZ : ()D
/*      */     //   1868: dsub
/*      */     //   1869: aload_1
/*      */     //   1870: invokevirtual getPartialTicks : ()F
/*      */     //   1873: f2d
/*      */     //   1874: dmul
/*      */     //   1875: dadd
/*      */     //   1876: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1879: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1884: invokeinterface getViewerPosZ : ()D
/*      */     //   1889: dsub
/*      */     //   1890: dstore #16
/*      */     //   1892: dload #8
/*      */     //   1894: ldc_w 5.0
/*      */     //   1897: f2d
/*      */     //   1898: dmul
/*      */     //   1899: d2f
/*      */     //   1900: invokestatic glLineWidth : (F)V
/*      */     //   1903: iconst_3
/*      */     //   1904: invokestatic glBegin : (I)V
/*      */     //   1907: iconst_0
/*      */     //   1908: istore #18
/*      */     //   1910: sipush #360
/*      */     //   1913: istore #19
/*      */     //   1915: iload #18
/*      */     //   1917: iload #19
/*      */     //   1919: if_icmpgt -> 2130
/*      */     //   1922: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1925: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1930: dup
/*      */     //   1931: ifnonnull -> 1937
/*      */     //   1934: invokestatic throwNpe : ()V
/*      */     //   1937: invokeinterface getTicksExisted : ()I
/*      */     //   1942: i2d
/*      */     //   1943: ldc2_w 70.0
/*      */     //   1946: ddiv
/*      */     //   1947: iload #18
/*      */     //   1949: i2d
/*      */     //   1950: ldc2_w 50.0
/*      */     //   1953: ddiv
/*      */     //   1954: ldc2_w 1.75
/*      */     //   1957: dmul
/*      */     //   1958: dstore #21
/*      */     //   1960: dstore #26
/*      */     //   1962: iconst_0
/*      */     //   1963: istore #23
/*      */     //   1965: dload #21
/*      */     //   1967: invokestatic sin : (D)D
/*      */     //   1970: dstore #28
/*      */     //   1972: dload #26
/*      */     //   1974: dload #28
/*      */     //   1976: dadd
/*      */     //   1977: d2f
/*      */     //   1978: fconst_1
/*      */     //   1979: frem
/*      */     //   1980: ldc_w 0.7
/*      */     //   1983: fconst_1
/*      */     //   1984: invokestatic HSBtoRGB : (FFF)I
/*      */     //   1987: istore #34
/*      */     //   1989: new java/awt/Color
/*      */     //   1992: dup
/*      */     //   1993: iload #34
/*      */     //   1995: invokespecial <init> : (I)V
/*      */     //   1998: astore #20
/*      */     //   2000: aload #20
/*      */     //   2002: invokevirtual getRed : ()I
/*      */     //   2005: i2f
/*      */     //   2006: ldc_w 255.0
/*      */     //   2009: fdiv
/*      */     //   2010: aload #20
/*      */     //   2012: invokevirtual getGreen : ()I
/*      */     //   2015: i2f
/*      */     //   2016: ldc_w 255.0
/*      */     //   2019: fdiv
/*      */     //   2020: aload #20
/*      */     //   2022: invokevirtual getBlue : ()I
/*      */     //   2025: i2f
/*      */     //   2026: ldc_w 255.0
/*      */     //   2029: fdiv
/*      */     //   2030: invokestatic glColor3f : (FFF)V
/*      */     //   2033: dload #12
/*      */     //   2035: dload #8
/*      */     //   2037: iload #18
/*      */     //   2039: i2d
/*      */     //   2040: ldc2_w 6.283185307179586
/*      */     //   2043: dmul
/*      */     //   2044: ldc2_w 45.0
/*      */     //   2047: ddiv
/*      */     //   2048: dstore #21
/*      */     //   2050: dstore #26
/*      */     //   2052: dstore #24
/*      */     //   2054: iconst_0
/*      */     //   2055: istore #23
/*      */     //   2057: dload #21
/*      */     //   2059: invokestatic cos : (D)D
/*      */     //   2062: dstore #28
/*      */     //   2064: dload #24
/*      */     //   2066: dload #26
/*      */     //   2068: dload #28
/*      */     //   2070: dmul
/*      */     //   2071: dadd
/*      */     //   2072: dload #14
/*      */     //   2074: dload #16
/*      */     //   2076: dload #8
/*      */     //   2078: iload #18
/*      */     //   2080: i2d
/*      */     //   2081: ldc2_w 6.283185307179586
/*      */     //   2084: dmul
/*      */     //   2085: ldc2_w 45.0
/*      */     //   2088: ddiv
/*      */     //   2089: dstore #21
/*      */     //   2091: dstore #30
/*      */     //   2093: dstore #28
/*      */     //   2095: dstore #26
/*      */     //   2097: dstore #24
/*      */     //   2099: iconst_0
/*      */     //   2100: istore #23
/*      */     //   2102: dload #21
/*      */     //   2104: invokestatic sin : (D)D
/*      */     //   2107: dstore #32
/*      */     //   2109: dload #24
/*      */     //   2111: dload #26
/*      */     //   2113: dload #28
/*      */     //   2115: dload #30
/*      */     //   2117: dload #32
/*      */     //   2119: dmul
/*      */     //   2120: dadd
/*      */     //   2121: invokestatic glVertex3d : (DDD)V
/*      */     //   2124: iinc #18, 1
/*      */     //   2127: goto -> 1915
/*      */     //   2130: invokestatic glEnd : ()V
/*      */     //   2133: iconst_1
/*      */     //   2134: invokestatic glDepthMask : (Z)V
/*      */     //   2137: sipush #2929
/*      */     //   2140: invokestatic glEnable : (I)V
/*      */     //   2143: sipush #2848
/*      */     //   2146: invokestatic glDisable : (I)V
/*      */     //   2149: sipush #2881
/*      */     //   2152: invokestatic glDisable : (I)V
/*      */     //   2155: sipush #2832
/*      */     //   2158: invokestatic glEnable : (I)V
/*      */     //   2161: sipush #3553
/*      */     //   2164: invokestatic glEnable : (I)V
/*      */     //   2167: invokestatic glPopMatrix : ()V
/*      */     //   2170: aload_0
/*      */     //   2171: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2174: ifnull -> 2275
/*      */     //   2177: aload_0
/*      */     //   2178: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   2181: aload_0
/*      */     //   2182: getfield attackDelay : J
/*      */     //   2185: invokevirtual hasTimePassed : (J)Z
/*      */     //   2188: ifeq -> 2275
/*      */     //   2191: aload_0
/*      */     //   2192: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2195: dup
/*      */     //   2196: ifnonnull -> 2202
/*      */     //   2199: invokestatic throwNpe : ()V
/*      */     //   2202: invokeinterface getHurtTime : ()I
/*      */     //   2207: aload_0
/*      */     //   2208: getfield hurtTimeValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   2211: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2214: checkcast java/lang/Number
/*      */     //   2217: invokevirtual intValue : ()I
/*      */     //   2220: if_icmpgt -> 2275
/*      */     //   2223: aload_0
/*      */     //   2224: dup
/*      */     //   2225: getfield clicks : I
/*      */     //   2228: dup
/*      */     //   2229: istore_2
/*      */     //   2230: iconst_1
/*      */     //   2231: iadd
/*      */     //   2232: putfield clicks : I
/*      */     //   2235: aload_0
/*      */     //   2236: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   2239: invokevirtual reset : ()V
/*      */     //   2242: aload_0
/*      */     //   2243: aload_0
/*      */     //   2244: getfield minCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   2247: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2250: checkcast java/lang/Number
/*      */     //   2253: invokevirtual intValue : ()I
/*      */     //   2256: aload_0
/*      */     //   2257: getfield maxCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   2260: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2263: checkcast java/lang/Number
/*      */     //   2266: invokevirtual intValue : ()I
/*      */     //   2269: invokestatic randomClickDelay : (II)J
/*      */     //   2272: putfield attackDelay : J
/*      */     //   2275: aload_0
/*      */     //   2276: getfield targetModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   2279: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   2282: checkcast java/lang/String
/*      */     //   2285: ldc_w 'Multi'
/*      */     //   2288: iconst_1
/*      */     //   2289: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   2292: ifne -> 2322
/*      */     //   2295: aload_0
/*      */     //   2296: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2299: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   2302: ldc2_w 0.67
/*      */     //   2305: getstatic java/awt/Color.RED : Ljava/awt/Color;
/*      */     //   2308: dup
/*      */     //   2309: ldc_w 'Color.RED'
/*      */     //   2312: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   2315: invokevirtual getRGB : ()I
/*      */     //   2318: iconst_1
/*      */     //   2319: invokestatic drawCircleESP : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;DIZ)V
/*      */     //   2322: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #509	-> 7
/*      */     //   #510	-> 23
/*      */     //   #511	-> 26
/*      */     //   #512	-> 26
/*      */     //   #513	-> 117
/*      */     //   #514	-> 208
/*      */     //   #511	-> 299
/*      */     //   #516	-> 302
/*      */     //   #517	-> 308
/*      */     //   #518	-> 314
/*      */     //   #519	-> 320
/*      */     //   #520	-> 326
/*      */     //   #522	-> 335
/*      */     //   #523	-> 352
/*      */     //   #524	-> 352
/*      */     //   #525	-> 369
/*      */     //   #526	-> 386
/*      */     //   #527	-> 403
/*      */     //   #523	-> 420
/*      */     //   #529	-> 423
/*      */     //   #530	-> 432
/*      */     //   #532	-> 436
/*      */     //   #534	-> 454
/*      */     //   #535	-> 479
/*      */     //   #535	-> 515
/*      */     //   #536	-> 519
/*      */     //   #536	-> 555
/*      */     //   #537	-> 559
/*      */     //   #534	-> 566
/*      */     //   #539	-> 572
/*      */     //   #541	-> 589
/*      */     //   #543	-> 592
/*      */     //   #544	-> 598
/*      */     //   #545	-> 604
/*      */     //   #546	-> 610
/*      */     //   #548	-> 616
/*      */     //   #551	-> 619
/*      */     //   #1079	-> 623
/*      */     //   #1080	-> 623
/*      */     //   #1081	-> 623
/*      */     //   #1082	-> 623
/*      */     //   #1083	-> 623
/*      */     //   #1084	-> 623
/*      */     //   #1085	-> 623
/*      */     //   #1086	-> 623
/*      */     //   #1079	-> 647
/*      */     //   #1080	-> 671
/*      */     //   #1082	-> 696
/*      */     //   #1083	-> 776
/*      */     //   #1084	-> 858
/*      */     //   #1085	-> 935
/*      */     //   #1086	-> 969
/*      */     //   #552	-> 995
/*      */     //   #553	-> 1003
/*      */     //   #554	-> 1011
/*      */     //   #555	-> 1016
/*      */     //   #556	-> 1020
/*      */     //   #559	-> 1021
/*      */     //   #560	-> 1021
/*      */     //   #559	-> 1021
/*      */     //   #560	-> 1056
/*      */     //   #562	-> 1081
/*      */     //   #563	-> 1089
/*      */     //   #564	-> 1097
/*      */     //   #565	-> 1102
/*      */     //   #566	-> 1128
/*      */     //   #569	-> 1129
/*      */     //   #569	-> 1140
/*      */     //   #570	-> 1143
/*      */     //   #571	-> 1212
/*      */     //   #574	-> 1225
/*      */     //   #572	-> 1238
/*      */     //   #575	-> 1312
/*      */     //   #576	-> 1356
/*      */     //   #578	-> 1392
/*      */     //   #579	-> 1409
/*      */     //   #580	-> 1440
/*      */     //   #581	-> 1440
/*      */     //   #582	-> 1454
/*      */     //   #583	-> 1469
/*      */     //   #580	-> 1470
/*      */     //   #585	-> 1473
/*      */     //   #586	-> 1490
/*      */     //   #587	-> 1501
/*      */     //   #588	-> 1516
/*      */     //   #590	-> 1525
/*      */     //   #591	-> 1530
/*      */     //   #593	-> 1540
/*      */     //   #594	-> 1547
/*      */     //   #595	-> 1547
/*      */     //   #596	-> 1557
/*      */     //   #597	-> 1560
/*      */     //   #598	-> 1566
/*      */     //   #599	-> 1572
/*      */     //   #600	-> 1578
/*      */     //   #601	-> 1584
/*      */     //   #602	-> 1590
/*      */     //   #603	-> 1599
/*      */     //   #604	-> 1608
/*      */     //   #605	-> 1617
/*      */     //   #606	-> 1626
/*      */     //   #607	-> 1632
/*      */     //   #609	-> 1636
/*      */     //   #610	-> 1655
/*      */     //   #611	-> 1670
/*      */     //   #612	-> 1670
/*      */     //   #611	-> 1740
/*      */     //   #613	-> 1742
/*      */     //   #614	-> 1742
/*      */     //   #613	-> 1818
/*      */     //   #615	-> 1820
/*      */     //   #616	-> 1820
/*      */     //   #615	-> 1890
/*      */     //   #617	-> 1892
/*      */     //   #618	-> 1903
/*      */     //   #619	-> 1907
/*      */     //   #620	-> 1922
/*      */     //   #621	-> 1922
/*      */     //   #622	-> 1922
/*      */     //   #622	-> 1976
/*      */     //   #623	-> 1980
/*      */     //   #624	-> 1983
/*      */     //   #621	-> 1984
/*      */     //   #620	-> 1987
/*      */     //   #627	-> 2000
/*      */     //   #628	-> 2033
/*      */     //   #629	-> 2033
/*      */     //   #629	-> 2070
/*      */     //   #630	-> 2072
/*      */     //   #631	-> 2074
/*      */     //   #631	-> 2119
/*      */     //   #628	-> 2121
/*      */     //   #619	-> 2124
/*      */     //   #634	-> 2130
/*      */     //   #636	-> 2133
/*      */     //   #637	-> 2137
/*      */     //   #638	-> 2143
/*      */     //   #639	-> 2149
/*      */     //   #640	-> 2155
/*      */     //   #641	-> 2161
/*      */     //   #642	-> 2167
/*      */     //   #643	-> 2170
/*      */     //   #645	-> 2170
/*      */     //   #646	-> 2170
/*      */     //   #647	-> 2170
/*      */     //   #646	-> 2177
/*      */     //   #647	-> 2207
/*      */     //   #648	-> 2223
/*      */     //   #649	-> 2235
/*      */     //   #650	-> 2242
/*      */     //   #652	-> 2275
/*      */     //   #653	-> 2295
/*      */     //   #654	-> 2322
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   559	7	7	y	F
/*      */     //   519	47	6	x	F
/*      */     //   479	90	4	i	I
/*      */     //   454	165	2	theta	D
/*      */     //   621	371	2	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   623	369	3	$i$f$getCancelRun	I
/*      */     //   2000	124	20	rainbow	Ljava/awt/Color;
/*      */     //   1922	205	18	i	I
/*      */     //   1892	278	16	z	D
/*      */     //   1820	350	14	y	D
/*      */     //   1742	428	12	x	D
/*      */     //   1670	500	10	height	D
/*      */     //   1655	515	8	radius	D
/*      */     //   1525	645	6	drawPercent	D
/*      */     //   1516	654	5	drawMode	Z
/*      */     //   1501	669	4	drawTime	I
/*      */     //   1409	761	3	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   0	2323	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   0	2323	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
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
/*      */   @EventTarget
/*      */   public final void onEntityMove(@NotNull EntityMovementEvent event) {
/*  662 */     Intrinsics.checkParameterIsNotNull(event, "event"); IEntity movedEntity = event.getMovedEntity();
/*      */     
/*  664 */     if (this.target == null || (Intrinsics.areEqual(movedEntity, this.currentTarget) ^ true) != 0) {
/*      */       return;
/*      */     }
/*  667 */     updateHitable();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void runAttack()
/*      */   {
/*  675 */     if (this.target != null) {
/*  676 */       if (this.currentTarget != null) {
/*  677 */         if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  678 */           if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*      */ 
/*      */ 
/*      */             
/*  682 */             float failRate = ((Number)this.failRateValue.get()).floatValue();
/*  683 */             boolean swing = ((Boolean)this.swingValue.get()).booleanValue();
/*  684 */             boolean multi = StringsKt.equals((String)this.targetModeValue.get(), "Multi", true);
/*  685 */             boolean openInventory = (((Boolean)this.noInventory.get()).booleanValue() && MinecraftInstance.classProvider.isGuiContainer(MinecraftInstance.mc.getCurrentScreen()));
/*  686 */             boolean failHit = (failRate > false && (new Random()).nextInt(100) <= failRate);
/*      */ 
/*      */             
/*  689 */             if (openInventory) {
/*  690 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow());
/*      */             }
/*      */             
/*  693 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.target == null) Intrinsics.throwNpe();  if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)this.target) > getMaxRange())
/*  694 */               return;  if (!this.hitable || failHit) {
/*  695 */               if (swing && (((Boolean)this.fakeSwingValue.get()).booleanValue() || failHit)) {
/*  696 */                 thePlayer.swingItem();
/*      */               }
/*      */             } else {
/*  699 */               if (!multi) {
/*  700 */                 if (this.currentTarget == null) Intrinsics.throwNpe();  attackEntity(this.currentTarget);
/*      */               } else {
/*  702 */                 int targets = 0;
/*      */                 
/*  704 */                 for (IEntity entity : theWorld.getLoadedEntityList()) {
/*  705 */                   double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity);
/*      */                   
/*  707 */                   if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && isEnemy(entity) && distance <= getRange(entity)) {
/*  708 */                     attackEntity(entity.asEntityLivingBase());
/*      */                     
/*  710 */                     targets++;
/*      */                     
/*  712 */                     if (((Number)this.limitedMultiTargetsValue.get()).intValue() != 0 && ((Number)this.limitedMultiTargetsValue.get()).intValue() <= targets) {
/*      */                       break;
/*      */                     }
/*      */                   } 
/*      */                 } 
/*      */               } 
/*  718 */               if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/*      */               
/*  720 */               if (Intrinsics.areEqual(this.target, this.currentTarget))
/*  721 */                 this.target = (IEntityLivingBase)null; 
/*      */             }  return; }
/*      */            MinecraftInstance.mc.getTheWorld();
/*      */           return; }
/*      */         
/*      */         MinecraftInstance.mc.getThePlayer();
/*      */         return;
/*      */       } 
/*      */       return;
/*  730 */     }  } private final void updateTarget() { this.target = (IEntityLivingBase)null;
/*      */ 
/*      */     
/*  733 */     int hurtTime = ((Number)this.hurtTimeValue.get()).intValue();
/*  734 */     float fov = ((Number)this.fovValue.get()).floatValue();
/*  735 */     boolean switchMode = StringsKt.equals((String)this.targetModeValue.get(), "Switch", true);
/*      */ 
/*      */     
/*  738 */     boolean bool1 = false; List<IEntityLivingBase> targets = new ArrayList();
/*      */     
/*  740 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*  741 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*      */     
/*  743 */     for (IEntity entity : theWorld.getLoadedEntityList()) {
/*  744 */       if (!MinecraftInstance.classProvider.isEntityLivingBase(entity) || !isEnemy(entity) || (switchMode && this.prevTargetEntities.contains(Integer.valueOf(entity.getEntityId())))) {
/*      */         continue;
/*      */       }
/*  747 */       double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity);
/*  748 */       double entityFov = RotationUtils.getRotationDifference(entity);
/*      */       
/*  750 */       if (distance <= ((Number)this.rotationrangeValue.get()).doubleValue() && (fov == 180.0F || entityFov <= fov) && entity.asEntityLivingBase().getHurtTime() <= hurtTime) {
/*  751 */         targets.add(entity.asEntityLivingBase());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  756 */     String str = (String)this.priorityValue.get(); boolean bool2 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 288459765:
/*  757 */         if (str.equals("distance")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1087 */           if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura4$updateTarget$$inlined$sortBy$1 killAura4$updateTarget$$inlined$sortBy$1 = new KillAura4$updateTarget$$inlined$sortBy$1(thePlayer); CollectionsKt.sortWith(list1, killAura4$updateTarget$$inlined$sortBy$1); }
/*      */            }
/*      */         
/*      */         break;
/*      */       case -3488356:
/*      */         if (str.equals("hytarmor"))
/*      */         { List<IEntityLivingBase> $this$sortBy$iv = targets;
/*      */           int $i$f$sortBy = 0;
/* 1095 */           if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura4$updateTarget$$inlined$sortBy$5 killAura4$updateTarget$$inlined$sortBy$5 = new KillAura4$updateTarget$$inlined$sortBy$5(); CollectionsKt.sortWith(list1, killAura4$updateTarget$$inlined$sortBy$5); }  }  break;case -1221262756: if (str.equals("health")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura4$updateTarget$$inlined$sortBy$2 killAura4$updateTarget$$inlined$sortBy$2 = new KillAura4$updateTarget$$inlined$sortBy$2(); CollectionsKt.sortWith(list1, killAura4$updateTarget$$inlined$sortBy$2); }  }  break;case 886905078: if (str.equals("livingtime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura4$updateTarget$$inlined$sortBy$4 killAura4$updateTarget$$inlined$sortBy$4 = new KillAura4$updateTarget$$inlined$sortBy$4(); CollectionsKt.sortWith(list1, killAura4$updateTarget$$inlined$sortBy$4); }  }  break;case -962590849: if (str.equals("direction")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura4$updateTarget$$inlined$sortBy$3 killAura4$updateTarget$$inlined$sortBy$3 = new KillAura4$updateTarget$$inlined$sortBy$3(); CollectionsKt.sortWith(list1, killAura4$updateTarget$$inlined$sortBy$3); }  }  break; }  for (IEntityLivingBase entity : targets) { if (!updateRotations((IEntity)entity)) continue;  this.target = entity; return; }  List<Integer> list = this.prevTargetEntities; bool2 = false; if (!list.isEmpty()) { this.prevTargetEntities.clear(); updateTarget(); }  } private final void startBlocking(IEntity interactEntity, boolean interact) { if (interact) { MinecraftInstance.mc.getRenderViewEntity(); WVec3 positionEye = (MinecraftInstance.mc.getRenderViewEntity() != null) ? MinecraftInstance.mc.getRenderViewEntity().getPositionEyes(1.0F) : null; double expandSize = interactEntity.getCollisionBorderSize(); IAxisAlignedBB boundingBox = interactEntity.getEntityBoundingBox().expand(expandSize, expandSize, expandSize); if (RotationUtils.targetRotation == null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe();  }  Rotation rotation = new Rotation(MinecraftInstance.mc.getThePlayer().getRotationYaw(), MinecraftInstance.mc.getThePlayer().getRotationPitch()); float f1 = rotation.component1(), pitch = rotation.component2(); float f2 = -f1 * 0.017453292F - (float)Math.PI; boolean bool1 = false; float yawCos = (float)Math.cos(f2); float f3 = -f1 * 0.017453292F - (float)Math.PI; boolean bool2 = false; float yawSin = (float)Math.sin(f3); float f4 = -pitch * 0.017453292F; boolean bool3 = false; float pitchCos = -((float)Math.cos(f4)); float f5 = -pitch * 0.017453292F; boolean bool4 = false; float pitchSin = (float)Math.sin(f5); double d1 = getMaxRange(); if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe();  double d2 = PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), interactEntity); boolean bool5 = false; double range = Math.min(d1, d2) + true; if (positionEye == null)
/* 1098 */         Intrinsics.throwNpe();  WVec3 wVec31 = positionEye; d2 = (yawSin * pitchCos) * range; double d3 = pitchSin * range, z$iv = (yawCos * pitchCos) * range; int $i$f$addVector = 0; WVec3 lookAt = new WVec3(wVec31.getXCoord() + d2, wVec31.getYCoord() + d3, wVec31.getZCoord() + z$iv); if (boundingBox.calculateIntercept(positionEye, lookAt) != null) { IMovingObjectPosition movingObject = boundingBox.calculateIntercept(positionEye, lookAt); WVec3 hitVec = movingObject.getHitVec(); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, new WVec3(hitVec.getXCoord() - interactEntity.getPosX(), hitVec.getYCoord() - interactEntity.getPosY(), hitVec.getZCoord() - interactEntity.getPosZ()))); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, ICPacketUseEntity.WAction.INTERACT)); } else { boundingBox.calculateIntercept(positionEye, lookAt); return; }  }
/*      */      if (MinecraftInstance.mc.getThePlayer() == null)
/* 1100 */       Intrinsics.throwNpe();  IItemStack iItemStack = MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand(); WEnumHand wEnumHand = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createUseItemPacket = 0; IPacket iPacket = 
/*      */ 
/*      */       
/* 1103 */       (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand);
/*      */     iINetHandlerPlayClient.addToSendQueue(iPacket);
/*      */     this.blockingStatus = true; }
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public final void onMove(@NotNull MoveEvent event) {
/*      */     Intrinsics.checkParameterIsNotNull(event, "event");
/*      */     if (this.target == null && ((Boolean)this.silentfix.get()).booleanValue()) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (!MinecraftInstance.mc.getThePlayer().getSprinting()) {
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         if (MinecraftInstance.mc.getThePlayer().getTicksExisted() % 19 == 0)
/*      */           this.sprintmode = true; 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private final boolean isEnemy(IEntity entity) {
/*      */     if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && entity != null && (EntityUtils.targetDead || isAlive(entity.asEntityLivingBase())) && (Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0) {
/*      */       if (!EntityUtils.targetInvisible && entity.isInvisible())
/*      */         return false; 
/*      */       if (EntityUtils.targetPlayer && MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/*      */         IEntityPlayer player = entity.asEntityPlayer();
/*      */         if (player.isSpectator() || AntiBot.isBot((IEntityLivingBase)player))
/*      */           return false; 
/*      */         if (PlayerExtensionKt.isClientFriend(player) && !Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState())
/*      */           return false; 
/*      */         if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null)
/*      */           throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams"); 
/*      */         Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class);
/*      */         return (!teams.getState() || !teams.isInYourTeam(entity.asEntityLivingBase()));
/*      */       } 
/*      */       return ((EntityUtils.targetMobs && PlayerExtensionKt.isMob(entity)) || (EntityUtils.targetAnimals && PlayerExtensionKt.isAnimal(entity)));
/*      */     } 
/*      */     return false;
/*      */   }
/*      */   
/*      */   private final void attackEntity(IEntityLivingBase entity) {
/*      */     // Byte code:
/*      */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   8: dup
/*      */     //   9: ifnonnull -> 15
/*      */     //   12: invokestatic throwNpe : ()V
/*      */     //   15: astore_2
/*      */     //   16: aload_2
/*      */     //   17: invokeinterface isBlocking : ()Z
/*      */     //   22: ifne -> 52
/*      */     //   25: aload_0
/*      */     //   26: getfield blockModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   29: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   32: checkcast java/lang/String
/*      */     //   35: ldc_w 'Off'
/*      */     //   38: iconst_1
/*      */     //   39: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   42: ifne -> 114
/*      */     //   45: aload_0
/*      */     //   46: getfield blockingStatus : Z
/*      */     //   49: ifeq -> 114
/*      */     //   52: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   55: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   60: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   63: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*      */     //   66: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*      */     //   69: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   72: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   75: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   78: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   83: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*      */     //   88: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   93: aload_0
/*      */     //   94: getfield afterAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   97: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   100: checkcast java/lang/Boolean
/*      */     //   103: invokevirtual booleanValue : ()Z
/*      */     //   106: ifeq -> 114
/*      */     //   109: aload_0
/*      */     //   110: iconst_0
/*      */     //   111: putfield blockingStatus : Z
/*      */     //   114: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   117: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*      */     //   120: new net/ccbluex/liquidbounce/event/AttackEvent
/*      */     //   123: dup
/*      */     //   124: aload_1
/*      */     //   125: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   128: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   131: checkcast net/ccbluex/liquidbounce/event/Event
/*      */     //   134: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*      */     //   137: aload_0
/*      */     //   138: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   141: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   144: checkcast java/lang/Boolean
/*      */     //   147: invokevirtual booleanValue : ()Z
/*      */     //   150: ifeq -> 153
/*      */     //   153: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   156: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   161: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   164: aload_1
/*      */     //   165: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   168: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*      */     //   171: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*      */     //   176: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   179: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   184: aload_0
/*      */     //   185: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   188: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   191: checkcast java/lang/Boolean
/*      */     //   194: invokevirtual booleanValue : ()Z
/*      */     //   197: ifeq -> 206
/*      */     //   200: aload_2
/*      */     //   201: invokeinterface swingItem : ()V
/*      */     //   206: aload_0
/*      */     //   207: getfield keepSprintValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   210: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   213: checkcast java/lang/Boolean
/*      */     //   216: invokevirtual booleanValue : ()Z
/*      */     //   219: ifeq -> 374
/*      */     //   222: aload_0
/*      */     //   223: getfield keepSprintnohurtValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   226: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   229: checkcast java/lang/Boolean
/*      */     //   232: invokevirtual booleanValue : ()Z
/*      */     //   235: ifeq -> 262
/*      */     //   238: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   241: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   246: dup
/*      */     //   247: ifnonnull -> 253
/*      */     //   250: invokestatic throwNpe : ()V
/*      */     //   253: invokeinterface getHurtTime : ()I
/*      */     //   258: ifle -> 262
/*      */     //   261: return
/*      */     //   262: aload_2
/*      */     //   263: invokeinterface getFallDistance : ()F
/*      */     //   268: fconst_0
/*      */     //   269: fcmpl
/*      */     //   270: ifle -> 339
/*      */     //   273: aload_2
/*      */     //   274: invokeinterface getOnGround : ()Z
/*      */     //   279: ifne -> 339
/*      */     //   282: aload_2
/*      */     //   283: invokeinterface isOnLadder : ()Z
/*      */     //   288: ifne -> 339
/*      */     //   291: aload_2
/*      */     //   292: invokeinterface isInWater : ()Z
/*      */     //   297: ifne -> 339
/*      */     //   300: aload_2
/*      */     //   301: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   304: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.BLINDNESS : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*      */     //   307: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*      */     //   312: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*      */     //   317: ifne -> 339
/*      */     //   320: aload_2
/*      */     //   321: invokeinterface isRiding : ()Z
/*      */     //   326: ifne -> 339
/*      */     //   329: aload_2
/*      */     //   330: aload_1
/*      */     //   331: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   334: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   339: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*      */     //   342: aload_2
/*      */     //   343: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   348: aload_1
/*      */     //   349: invokeinterface getCreatureAttribute : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;
/*      */     //   354: invokeinterface getModifierForCreature : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;)F
/*      */     //   359: fconst_0
/*      */     //   360: fcmpl
/*      */     //   361: ifle -> 403
/*      */     //   364: aload_2
/*      */     //   365: aload_1
/*      */     //   366: invokeinterface onEnchantmentCritical : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*      */     //   371: goto -> 403
/*      */     //   374: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   377: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   382: invokeinterface getCurrentGameType : ()Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;
/*      */     //   387: getstatic net/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType.SPECTATOR : Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;
/*      */     //   390: if_acmpeq -> 403
/*      */     //   393: aload_2
/*      */     //   394: aload_1
/*      */     //   395: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   398: invokeinterface attackTargetEntityWithCurrentItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   403: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   406: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   409: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/Criticals
/*      */     //   412: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   415: dup
/*      */     //   416: ifnonnull -> 430
/*      */     //   419: new kotlin/TypeCastException
/*      */     //   422: dup
/*      */     //   423: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Criticals'
/*      */     //   426: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   429: athrow
/*      */     //   430: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/Criticals
/*      */     //   433: astore_3
/*      */     //   434: iconst_0
/*      */     //   435: istore #4
/*      */     //   437: iconst_2
/*      */     //   438: istore #5
/*      */     //   440: iload #4
/*      */     //   442: iload #5
/*      */     //   444: if_icmpgt -> 666
/*      */     //   447: aload_2
/*      */     //   448: invokeinterface getFallDistance : ()F
/*      */     //   453: fconst_0
/*      */     //   454: fcmpl
/*      */     //   455: ifle -> 514
/*      */     //   458: aload_2
/*      */     //   459: invokeinterface getOnGround : ()Z
/*      */     //   464: ifne -> 514
/*      */     //   467: aload_2
/*      */     //   468: invokeinterface isOnLadder : ()Z
/*      */     //   473: ifne -> 514
/*      */     //   476: aload_2
/*      */     //   477: invokeinterface isInWater : ()Z
/*      */     //   482: ifne -> 514
/*      */     //   485: aload_2
/*      */     //   486: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   489: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.BLINDNESS : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*      */     //   492: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*      */     //   497: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*      */     //   502: ifne -> 514
/*      */     //   505: aload_2
/*      */     //   506: invokeinterface getRidingEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*      */     //   511: ifnull -> 572
/*      */     //   514: aload_3
/*      */     //   515: invokevirtual getState : ()Z
/*      */     //   518: ifeq -> 592
/*      */     //   521: aload_3
/*      */     //   522: invokevirtual getMsTimer : ()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   525: aload_3
/*      */     //   526: invokevirtual getDelayValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   529: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   532: checkcast java/lang/Number
/*      */     //   535: invokevirtual intValue : ()I
/*      */     //   538: i2l
/*      */     //   539: invokevirtual hasTimePassed : (J)Z
/*      */     //   542: ifeq -> 592
/*      */     //   545: aload_2
/*      */     //   546: invokeinterface isInWater : ()Z
/*      */     //   551: ifne -> 592
/*      */     //   554: aload_2
/*      */     //   555: invokeinterface isInLava : ()Z
/*      */     //   560: ifne -> 592
/*      */     //   563: aload_2
/*      */     //   564: invokeinterface isInWeb : ()Z
/*      */     //   569: ifne -> 592
/*      */     //   572: aload_2
/*      */     //   573: aload_0
/*      */     //   574: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   577: dup
/*      */     //   578: ifnonnull -> 584
/*      */     //   581: invokestatic throwNpe : ()V
/*      */     //   584: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   587: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   592: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*      */     //   595: aload_2
/*      */     //   596: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   601: aload_0
/*      */     //   602: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   605: dup
/*      */     //   606: ifnonnull -> 612
/*      */     //   609: invokestatic throwNpe : ()V
/*      */     //   612: invokeinterface getCreatureAttribute : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;
/*      */     //   617: invokeinterface getModifierForCreature : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;)F
/*      */     //   622: fconst_0
/*      */     //   623: fcmpl
/*      */     //   624: ifgt -> 643
/*      */     //   627: aload_0
/*      */     //   628: getfield fakeSharpValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   631: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   634: checkcast java/lang/Boolean
/*      */     //   637: invokevirtual booleanValue : ()Z
/*      */     //   640: ifeq -> 660
/*      */     //   643: aload_2
/*      */     //   644: aload_0
/*      */     //   645: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   648: dup
/*      */     //   649: ifnonnull -> 655
/*      */     //   652: invokestatic throwNpe : ()V
/*      */     //   655: invokeinterface onEnchantmentCritical : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*      */     //   660: iinc #4, 1
/*      */     //   663: goto -> 440
/*      */     //   666: aload_0
/*      */     //   667: getfield blockModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   670: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   673: checkcast java/lang/String
/*      */     //   676: ldc_w 'packet'
/*      */     //   679: iconst_1
/*      */     //   680: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   683: ifeq -> 850
/*      */     //   686: aload_2
/*      */     //   687: invokeinterface isBlocking : ()Z
/*      */     //   692: ifne -> 829
/*      */     //   695: aload_0
/*      */     //   696: astore #4
/*      */     //   698: iconst_0
/*      */     //   699: istore #5
/*      */     //   701: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   704: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   709: dup
/*      */     //   710: ifnonnull -> 716
/*      */     //   713: invokestatic throwNpe : ()V
/*      */     //   716: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   721: ifnull -> 825
/*      */     //   724: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   727: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   730: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   735: dup
/*      */     //   736: ifnonnull -> 742
/*      */     //   739: invokestatic throwNpe : ()V
/*      */     //   742: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   747: dup
/*      */     //   748: ifnonnull -> 754
/*      */     //   751: invokestatic throwNpe : ()V
/*      */     //   754: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   759: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*      */     //   764: ifeq -> 825
/*      */     //   767: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   770: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   775: dup
/*      */     //   776: ifnonnull -> 782
/*      */     //   779: invokestatic throwNpe : ()V
/*      */     //   782: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   785: aload #4
/*      */     //   787: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   790: dup
/*      */     //   791: ifnonnull -> 797
/*      */     //   794: invokestatic throwNpe : ()V
/*      */     //   797: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   800: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   803: aload #4
/*      */     //   805: invokestatic access$getBlockRangeValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   808: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   811: checkcast java/lang/Number
/*      */     //   814: invokevirtual doubleValue : ()D
/*      */     //   817: dcmpg
/*      */     //   818: ifgt -> 825
/*      */     //   821: iconst_1
/*      */     //   822: goto -> 826
/*      */     //   825: iconst_0
/*      */     //   826: ifeq -> 850
/*      */     //   829: aload_0
/*      */     //   830: aload_1
/*      */     //   831: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   834: aload_0
/*      */     //   835: getfield interactAutoBlockValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   838: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   841: checkcast java/lang/Boolean
/*      */     //   844: invokevirtual booleanValue : ()Z
/*      */     //   847: invokespecial startBlocking : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)V
/*      */     //   850: nop
/*      */     //   851: aload_2
/*      */     //   852: invokeinterface resetCooldown : ()V
/*      */     //   857: nop
/*      */     //   858: nop
/*      */     //   859: aload_2
/*      */     //   860: invokeinterface resetCooldown : ()V
/*      */     //   865: nop
/*      */     //   866: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #821	-> 0
/*      */     //   #823	-> 16
/*      */     //   #824	-> 52
/*      */     //   #825	-> 63
/*      */     //   #826	-> 66
/*      */     //   #824	-> 83
/*      */     //   #827	-> 93
/*      */     //   #831	-> 114
/*      */     //   #834	-> 137
/*      */     //   #838	-> 153
/*      */     //   #840	-> 184
/*      */     //   #841	-> 200
/*      */     //   #843	-> 206
/*      */     //   #844	-> 222
/*      */     //   #846	-> 262
/*      */     //   #847	-> 262
/*      */     //   #848	-> 329
/*      */     //   #851	-> 339
/*      */     //   #852	-> 364
/*      */     //   #854	-> 374
/*      */     //   #855	-> 393
/*      */     //   #856	-> 403
/*      */     //   #859	-> 403
/*      */     //   #861	-> 434
/*      */     //   #863	-> 447
/*      */     //   #864	-> 447
/*      */     //   #863	-> 485
/*      */     //   #864	-> 489
/*      */     //   #863	-> 492
/*      */     //   #864	-> 521
/*      */     //   #865	-> 572
/*      */     //   #868	-> 592
/*      */     //   #869	-> 643
/*      */     //   #861	-> 660
/*      */     //   #873	-> 666
/*      */     //   #1097	-> 701
/*      */     //   #874	-> 829
/*      */     //   #876	-> 850
/*      */     //   #877	-> 850
/*      */     //   #878	-> 851
/*      */     //   #877	-> 857
/*      */     //   #881	-> 858
/*      */     //   #882	-> 858
/*      */     //   #883	-> 859
/*      */     //   #882	-> 865
/*      */     //   #885	-> 866
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   447	216	4	i	I
/*      */     //   698	128	4	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   701	125	5	$i$f$getCanBlock	I
/*      */     //   434	433	3	criticals	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;
/*      */     //   16	851	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	867	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   0	867	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */   }
/*      */   
/*      */   private final boolean updateRotations(IEntity entity) {
/*      */     if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F)
/*      */       return true; 
/*      */     IAxisAlignedBB boundingBox = entity.getEntityBoundingBox();
/*      */     if (((Boolean)this.silentfix.get()).booleanValue()) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.mc.getThePlayer().getSprinting() && StringsKt.equals((String)this.rotationStrafeValue.get(), "Silent", true)) {
/*      */         this.sprintmode = false;
/*      */         return false;
/*      */       } 
/*      */       this.sprintmode = true;
/*      */     } 
/*      */     if (((Boolean)this.jumpfix.get()).booleanValue() && this.jump == 0)
/*      */       return false; 
/*      */     if (((Boolean)this.predictValue.get()).booleanValue())
/*      */       boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue())); 
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (RotationUtils.newSearchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), ((Number)this.rotationrangeValue.get()).floatValue()) != null) {
/*      */       VecRotation vecRotation = RotationUtils.newSearchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), ((Number)this.rotationrangeValue.get()).floatValue());
/*      */       Rotation rotation = vecRotation.component2();
/*      */     } 
/*      */     RotationUtils.newSearchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), ((Number)this.rotationrangeValue.get()).floatValue());
/*      */     return false;
/*      */   }
/*      */   
/*      */   private final void updateHitable() {
/*      */     if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F || ((Boolean)this.hitableValue.get()).booleanValue()) {
/*      */       this.hitable = true;
/*      */       return;
/*      */     } 
/*      */     if (this.target == null || MinecraftInstance.mc.getThePlayer() == null) {
/*      */       this.hitable = false;
/*      */       return;
/*      */     } 
/*      */     double reach = getMaxRange();
/*      */     if (((Boolean)this.raycastValue.get()).booleanValue()) {
/*      */       IEntity raycastedEntity = RaycastUtils.raycastEntity(reach, new KillAura4$updateHitable$raycastedEntity$1());
/*      */       if (((Boolean)this.raycastValue.get()).booleanValue() && raycastedEntity != null && MinecraftInstance.classProvider.isEntityLivingBase(raycastedEntity) && (Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState() || !MinecraftInstance.classProvider.isEntityPlayer(raycastedEntity) || !PlayerExtensionKt.isClientFriend(raycastedEntity.asEntityPlayer())))
/*      */         this.currentTarget = raycastedEntity.asEntityLivingBase(); 
/*      */       this.hitable = (((Number)this.maxTurnSpeed.get()).floatValue() > 0.0F) ? Intrinsics.areEqual(this.currentTarget, raycastedEntity) : true;
/*      */     } else {
/*      */       this.hitable = RotationUtils.isFaced((IEntity)this.currentTarget, reach);
/*      */     } 
/*      */   }
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$updateHitable$raycastedEntity$1", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"})
/*      */   public static final class KillAura4$updateHitable$raycastedEntity$1 implements RaycastUtils.EntityFilter {
/*      */     public boolean canRaycast(@Nullable IEntity entity) {
/*      */       // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */       //   4: invokestatic access$getLivingRaycastValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */       //   7: invokevirtual get : ()Ljava/lang/Object;
/*      */       //   10: checkcast java/lang/Boolean
/*      */       //   13: invokevirtual booleanValue : ()Z
/*      */       //   16: ifeq -> 43
/*      */       //   19: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */       //   22: aload_1
/*      */       //   23: invokeinterface isEntityLivingBase : (Ljava/lang/Object;)Z
/*      */       //   28: ifeq -> 150
/*      */       //   31: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */       //   34: aload_1
/*      */       //   35: invokeinterface isEntityArmorStand : (Ljava/lang/Object;)Z
/*      */       //   40: ifne -> 150
/*      */       //   43: aload_0
/*      */       //   44: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */       //   47: aload_1
/*      */       //   48: invokestatic access$isEnemy : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */       //   51: ifne -> 146
/*      */       //   54: aload_0
/*      */       //   55: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */       //   58: invokestatic access$getRaycastIgnoredValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */       //   61: invokevirtual get : ()Ljava/lang/Object;
/*      */       //   64: checkcast java/lang/Boolean
/*      */       //   67: invokevirtual booleanValue : ()Z
/*      */       //   70: ifne -> 146
/*      */       //   73: aload_0
/*      */       //   74: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */       //   77: invokestatic access$getAacValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */       //   80: invokevirtual get : ()Ljava/lang/Object;
/*      */       //   83: checkcast java/lang/Boolean
/*      */       //   86: invokevirtual booleanValue : ()Z
/*      */       //   89: ifeq -> 150
/*      */       //   92: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */       //   95: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*      */       //   100: dup
/*      */       //   101: ifnonnull -> 107
/*      */       //   104: invokestatic throwNpe : ()V
/*      */       //   107: aload_1
/*      */       //   108: aload_1
/*      */       //   109: dup
/*      */       //   110: ifnonnull -> 116
/*      */       //   113: invokestatic throwNpe : ()V
/*      */       //   116: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */       //   121: invokeinterface getEntitiesWithinAABBExcludingEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)Ljava/util/Collection;
/*      */       //   126: astore_2
/*      */       //   127: iconst_0
/*      */       //   128: istore_3
/*      */       //   129: aload_2
/*      */       //   130: invokeinterface isEmpty : ()Z
/*      */       //   135: ifne -> 142
/*      */       //   138: iconst_1
/*      */       //   139: goto -> 143
/*      */       //   142: iconst_0
/*      */       //   143: ifeq -> 150
/*      */       //   146: iconst_1
/*      */       //   147: goto -> 151
/*      */       //   150: iconst_0
/*      */       //   151: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #946	-> 0
/*      */       //   #947	-> 0
/*      */       //   #946	-> 0
/*      */       //   #947	-> 47
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	152	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4$updateHitable$raycastedEntity$1;
/*      */       //   0	152	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*      */     }
/*      */   }
/*      */   
/*      */   private final void stopBlocking() {
/*      */     if (this.blockingStatus) {
/*      */       if (!((Boolean)this.alwaysblock.get()).booleanValue())
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN))); 
/*      */       this.blockingStatus = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private final boolean getCancelRun() {
/*      */     // Byte code:
/*      */     //   0: ldc 0
/*      */     //   2: istore_1
/*      */     //   3: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   6: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   11: dup
/*      */     //   12: ifnonnull -> 18
/*      */     //   15: invokestatic throwNpe : ()V
/*      */     //   18: invokeinterface isSpectator : ()Z
/*      */     //   23: ifne -> 367
/*      */     //   26: aload_0
/*      */     //   27: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   30: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   35: dup
/*      */     //   36: ifnonnull -> 42
/*      */     //   39: invokestatic throwNpe : ()V
/*      */     //   42: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   45: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   48: ifeq -> 367
/*      */     //   51: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   54: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   57: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   60: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   63: invokevirtual getState : ()Z
/*      */     //   66: ifne -> 367
/*      */     //   69: aload_0
/*      */     //   70: invokestatic access$getB$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)I
/*      */     //   73: ifgt -> 367
/*      */     //   76: aload_0
/*      */     //   77: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   80: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   83: checkcast java/lang/Boolean
/*      */     //   86: invokevirtual booleanValue : ()Z
/*      */     //   89: ifeq -> 156
/*      */     //   92: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   95: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*      */     //   100: invokeinterface getKeyBindUseItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*      */     //   105: invokeinterface isKeyDown : ()Z
/*      */     //   110: ifeq -> 156
/*      */     //   113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   116: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   119: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   124: dup
/*      */     //   125: ifnonnull -> 131
/*      */     //   128: invokestatic throwNpe : ()V
/*      */     //   131: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   136: dup
/*      */     //   137: ifnonnull -> 143
/*      */     //   140: invokestatic throwNpe : ()V
/*      */     //   143: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   148: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   153: ifne -> 367
/*      */     //   156: aload_0
/*      */     //   157: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   160: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   163: checkcast java/lang/Boolean
/*      */     //   166: invokevirtual booleanValue : ()Z
/*      */     //   169: ifeq -> 238
/*      */     //   172: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   175: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   180: dup
/*      */     //   181: ifnonnull -> 187
/*      */     //   184: invokestatic throwNpe : ()V
/*      */     //   187: invokeinterface isUsingItem : ()Z
/*      */     //   192: ifeq -> 238
/*      */     //   195: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   198: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   201: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   206: dup
/*      */     //   207: ifnonnull -> 213
/*      */     //   210: invokestatic throwNpe : ()V
/*      */     //   213: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   218: dup
/*      */     //   219: ifnonnull -> 225
/*      */     //   222: invokestatic throwNpe : ()V
/*      */     //   225: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   230: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   235: ifne -> 367
/*      */     //   238: aload_0
/*      */     //   239: invokestatic access$getNoBlocking$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   242: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   245: checkcast java/lang/Boolean
/*      */     //   248: invokevirtual booleanValue : ()Z
/*      */     //   251: ifeq -> 315
/*      */     //   254: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   257: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   260: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/ScaffoldTest
/*      */     //   263: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   266: invokevirtual getState : ()Z
/*      */     //   269: ifeq -> 315
/*      */     //   272: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   275: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   278: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   283: dup
/*      */     //   284: ifnonnull -> 290
/*      */     //   287: invokestatic throwNpe : ()V
/*      */     //   290: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   295: dup
/*      */     //   296: ifnonnull -> 302
/*      */     //   299: invokestatic throwNpe : ()V
/*      */     //   302: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   307: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*      */     //   312: ifne -> 367
/*      */     //   315: aload_0
/*      */     //   316: invokestatic access$getNodigging$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   319: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   322: checkcast java/lang/Boolean
/*      */     //   325: invokevirtual booleanValue : ()Z
/*      */     //   328: ifeq -> 349
/*      */     //   331: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   334: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   339: invokeinterface getCurBlockDamageMP : ()F
/*      */     //   344: fconst_0
/*      */     //   345: fcmpg
/*      */     //   346: ifne -> 367
/*      */     //   349: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   352: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   355: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   358: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   361: invokevirtual getState : ()Z
/*      */     //   364: ifeq -> 371
/*      */     //   367: iconst_1
/*      */     //   368: goto -> 372
/*      */     //   371: iconst_0
/*      */     //   372: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1008	-> 3
/*      */     //   #1009	-> 3
/*      */     //   #1010	-> 3
/*      */     //   #1011	-> 3
/*      */     //   #1012	-> 3
/*      */     //   #1013	-> 3
/*      */     //   #1014	-> 3
/*      */     //   #1015	-> 3
/*      */     //   #1008	-> 27
/*      */     //   #1009	-> 51
/*      */     //   #1011	-> 76
/*      */     //   #1012	-> 156
/*      */     //   #1013	-> 238
/*      */     //   #1014	-> 315
/*      */     //   #1015	-> 349
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   0	373	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura4;
/*      */     //   3	370	1	$i$f$getCancelRun	I
/*      */   }
/*      */   
/*      */   private final boolean isAlive(IEntityLivingBase entity) {
/*      */     return ((entity.isEntityAlive() && entity.getHealth() > false) || (((Boolean)this.aacValue.get()).booleanValue() && entity.getHurtTime() > 5));
/*      */   }
/*      */   
/*      */   private final boolean getCanBlock() {
/*      */     int $i$f$getCanBlock = 0;
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.classProvider.isItemSword(MinecraftInstance.mc.getThePlayer().getHeldItem().getItem())) {
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         if (getTarget() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)getTarget()) <= ((Number)this.BlockRangeValue.get()).doubleValue());
/*      */       } 
/*      */     } 
/*      */     return false;
/*      */   }
/*      */   
/*      */   public final float getRange() {
/*      */     return (MinecraftInstance.mc.getThePlayer() == null || MinecraftInstance.mc.getTheWorld() == null || MinecraftInstance.mc2.field_71441_e == null || MinecraftInstance.mc2.field_71439_g == null) ? ((Number)this.rangeValue.get()).floatValue() : ((Number)this.rangeValue.get()).floatValue();
/*      */   }
/*      */   
/*      */   private final float getRange(IEntity entity) {
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer().getHurtTime() > 0) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (!MinecraftInstance.mc.getThePlayer().getOnGround());
/*      */     } 
/*      */     return ((PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) >= ((Number)this.throughWallsRangeValue.get()).doubleValue()) ? ((Number)this.rangeValue.get()).floatValue() : ((Number)this.throughWallsRangeValue.get()).floatValue()) - (!MinecraftInstance.mc.getThePlayer().getSprinting() ? ((Number)this.nomoveReducementValue.get()).floatValue() : 0.0F) - (MinecraftInstance.mc.getGameSettings().getKeyBindBack().isKeyDown() ? ((Number)this.backReducementValue.get()).floatValue() : 0.0F) - 0.0F;
/*      */   }
/*      */   
/*      */   private final float getMaxRange() {
/*      */     float f1 = getRange(), f2 = 3.0F;
/*      */     boolean bool = false;
/*      */     return Math.max(f1, f2);
/*      */   }
/*      */   
/*      */   @NotNull
/*      */   public String getTag() {
/*      */     return (String)this.targetModeValue.get();
/*      */   }
/*      */   
/*      */   public static final int getKillCounts() {
/*      */     return killCounts;
/*      */   }
/*      */   
/*      */   public static final void setKillCounts(int <set-?>) {
/*      */     killCounts = <set-?>;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\KillAura4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */