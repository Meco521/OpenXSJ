/*      */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*      */ 
/*      */ import courage.utils.PacketUtils;
/*      */ import java.awt.Color;
/*      */ import java.awt.Robot;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import kotlin.Metadata;
/*      */ import kotlin.TypeCastException;
/*      */ import kotlin.Unit;
/*      */ import kotlin.collections.CollectionsKt;
/*      */ import kotlin.jvm.JvmField;
/*      */ import kotlin.jvm.JvmStatic;
/*      */ import kotlin.jvm.functions.Function0;
/*      */ import kotlin.jvm.functions.Function1;
/*      */ import kotlin.jvm.functions.Function9;
/*      */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*      */ import kotlin.jvm.internal.Intrinsics;
/*      */ import kotlin.jvm.internal.Lambda;
/*      */ import kotlin.text.StringsKt;
/*      */ import net.ccbluex.liquidbounce.Retreat;
/*      */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
/*      */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*      */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*      */ import net.ccbluex.liquidbounce.event.EntityMovementEvent;
/*      */ import net.ccbluex.liquidbounce.event.EventState;
/*      */ import net.ccbluex.liquidbounce.event.EventTarget;
/*      */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*      */ import net.ccbluex.liquidbounce.event.TickEvent;
/*      */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*      */ import net.ccbluex.liquidbounce.features.module.Module;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.misc.AntiBot;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.misc.Teams;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.player.Blink;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.DMGPUtil.BlendUtils;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
/*      */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*      */ import net.ccbluex.liquidbounce.script.api.global.Chat;
/*      */ import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
/*      */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*      */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.VecRotation;
/*      */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*      */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import net.ccbluex.liquidbounce.value.Value;
/*      */ import net.minecraft.client.settings.KeyBinding;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*      */ import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
/*      */ import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
/*      */ import net.minecraft.util.EnumFacing;
/*      */ import net.minecraft.util.EnumHand;
/*      */ import net.minecraft.util.math.BlockPos;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @ModuleInfo(name = "KillAura3", description = "杀戮3,可以和helper一起用", category = ModuleCategory.COMBAT)
/*      */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000®\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\020\013\n\002\b\003\n\002\020\007\n\000\n\002\030\002\n\002\b\n\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\020\b\n\002\b\020\n\002\030\002\n\002\b\002\n\002\020\006\n\002\b \n\002\030\002\n\002\b&\n\002\020!\n\002\b-\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\b\007\030\000 Õ\0012\0020\001:\002Õ\001B\005¢\006\002\020\002J\022\020¶\001\032\0030·\0012\006\020C\032\0020>H\002J\t\020¸\001\032\0020\tH\002J\022\020¹\001\032\0020\r2\007\020C\032\0030º\001H\002J\021\020»\001\032\0020\t2\006\020C\032\0020>H\002J\024\020¼\001\032\0020\t2\t\020C\032\005\030\0010º\001H\002J\n\020½\001\032\0030·\001H\026J\n\020¾\001\032\0030·\001H\026J\024\020¿\001\032\0030·\0012\b\020À\001\032\0030Á\001H\007J\024\020Â\001\032\0030·\0012\b\020À\001\032\0030Ã\001H\007J\024\020Ä\001\032\0030·\0012\b\020À\001\032\0030Å\001H\007J\024\020Æ\001\032\0030·\0012\b\020À\001\032\0030Ç\001H\007J\026\020È\001\032\0030·\0012\n\020À\001\032\005\030\0010É\001H\007J\024\020Ê\001\032\0030·\0012\b\020À\001\032\0030Ë\001H\007J\n\020Ì\001\032\0030·\001H\002J\035\020Í\001\032\0030·\0012\b\020Î\001\032\0030º\0012\007\020Ï\001\032\0020\tH\002J\n\020Ð\001\032\0030·\001H\002J\b\020Ñ\001\032\0030·\001J\n\020Ò\001\032\0030·\001H\002J\022\020Ó\001\032\0020\t2\007\020C\032\0030º\001H\002J\n\020Ô\001\032\0030·\001H\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\027\020\007\032\b\022\004\022\0020\t0\b¢\006\b\n\000\032\004\b\n\020\013R\024\020\f\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\032\020\016\032\0020\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\004X\004¢\006\002\n\000R\024\020\026\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\024\020\027\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\016\020\030\032\0020\rX\016¢\006\002\n\000R\016\020\031\032\0020\032X\016¢\006\002\n\000R\016\020\033\032\0020\034X\004¢\006\002\n\000R\024\020\035\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\024\020\036\032\b\022\004\022\0020\0370\bX\004¢\006\002\n\000R\016\020 \032\0020!X\004¢\006\002\n\000R\020\020\"\032\004\030\0010#X\016¢\006\002\n\000R\032\020$\032\0020\tX\016¢\006\016\n\000\032\004\b%\020&\"\004\b'\020(R\024\020)\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\025\020*\032\0020\t8Â\002X\004¢\006\006\032\004\b+\020&R\024\020,\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\020.\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\020/\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\0200\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\0201\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\016\0202\032\0020\004X\004¢\006\002\n\000R\016\0203\032\0020\004X\004¢\006\002\n\000R\016\0204\032\0020-X\016¢\006\002\n\000R\024\0205\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\0206\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\0207\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\0208\032\b\022\004\022\0020\0370\bX\004¢\006\002\n\000R\024\0209\032\b\022\004\022\0020-0\bX\004¢\006\002\n\000R\024\020:\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\016\020;\032\0020\032X\016¢\006\002\n\000R\016\020<\032\0020\017X\004¢\006\002\n\000R\020\020=\032\004\030\0010>X\016¢\006\002\n\000R\024\020?\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\016\020@\032\0020AX\016¢\006\002\n\000R\016\020B\032\0020!X\004¢\006\002\n\000R\020\020C\032\004\030\0010>X\016¢\006\002\n\000R\016\020D\032\0020\017X\004¢\006\002\n\000R\021\020E\032\0020\004¢\006\b\n\000\032\004\bF\020\006R\032\020G\032\0020-X\016¢\006\016\n\000\032\004\bH\020I\"\004\bJ\020KR\027\020L\032\b\022\004\022\0020-0\b¢\006\b\n\000\032\004\bM\020\013R\027\020N\032\b\022\004\022\0020\t0\b¢\006\b\n\000\032\004\bO\020\013R\027\020P\032\b\022\004\022\0020\r0\b¢\006\b\n\000\032\004\bQ\020\013R\032\020R\032\0020\tX\016¢\006\016\n\000\032\004\bS\020&\"\004\bT\020(R\027\020U\032\b\022\004\022\0020-0\b¢\006\b\n\000\032\004\bV\020\013R\016\020W\032\0020\004X\004¢\006\002\n\000R\016\020X\032\0020\004X\004¢\006\002\n\000R\021\020Y\032\0020\017¢\006\b\n\000\032\004\bZ\020\021R\024\020[\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\032\020\\\032\0020\tX\016¢\006\016\n\000\032\004\b]\020&\"\004\b^\020(R\016\020_\032\0020\tX\016¢\006\002\n\000R\016\020`\032\0020\004X\004¢\006\002\n\000R\021\020a\032\0020b¢\006\b\n\000\032\004\bc\020dR\016\020e\032\0020\004X\004¢\006\002\n\000R\030\020f\032\b\022\004\022\0020\0370\b8\006@\006X\016¢\006\002\n\000R\024\020g\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\024\020h\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\024\020i\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\024\020j\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\024\020k\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\032\020l\032\0020\rX\016¢\006\016\n\000\032\004\bm\020n\"\004\bo\020pR\021\020q\032\0020\004¢\006\b\n\000\032\004\br\020\006R\016\020s\032\0020\032X\016¢\006\002\n\000R\016\020t\032\0020\032X\016¢\006\002\n\000R\020\020u\032\004\030\0010>X\016¢\006\002\n\000R\024\020v\032\b\022\004\022\0020\0370\bX\004¢\006\002\n\000R\024\020w\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\016\020x\032\0020\004X\004¢\006\002\n\000R\016\020y\032\0020bX\004¢\006\002\n\000R\016\020z\032\0020\004X\004¢\006\002\n\000R\016\020{\032\0020!X\004¢\006\002\n\000R\016\020|\032\0020bX\004¢\006\002\n\000R\016\020}\032\0020\017X\004¢\006\002\n\000R\024\020~\032\0020\r8BX\004¢\006\006\032\004\b\020nR\017\020\001\032\0020\017X\004¢\006\002\n\000R\017\020\001\032\0020bX\004¢\006\002\n\000R\017\020\001\032\0020\017X\004¢\006\002\n\000R\017\020\001\032\0020\017X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020bX\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\026\020\001\032\t\022\004\022\0020-0\001X\004¢\006\002\n\000R\017\020\001\032\0020!X\004¢\006\002\n\000R\017\020\001\032\0020AX\016¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\017X\004¢\006\002\n\000R\023\020\001\032\0020\017¢\006\t\n\000\032\005\b\001\020\021R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\025\020\001\032\b\022\004\022\0020\0370\bX\004¢\006\002\n\000R\017\020\001\032\0020!X\004¢\006\002\n\000R\025\020\001\032\b\022\004\022\0020\r0\bX\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020bX\004¢\006\002\n\000R\017\020\001\032\0020\034X\004¢\006\002\n\000R!\020\001\032\004\030\0010>X\016¢\006\022\n\000\032\006\b\001\020\001\"\006\b\001\020\001R\027\020\001\032\0020\0378VX\004¢\006\b\032\006\b\001\020 \001R!\020¡\001\032\004\030\0010>X\016¢\006\022\n\000\032\006\b¢\001\020\001\"\006\b£\001\020\001R\024\020¤\001\032\0020!¢\006\n\n\000\032\006\b¥\001\020¦\001R\017\020§\001\032\0020\017X\004¢\006\002\n\000R\035\020¨\001\032\0020-X\016¢\006\020\n\000\032\005\b©\001\020I\"\005\bª\001\020KR\025\020«\001\032\b\022\004\022\0020\0370\bX\004¢\006\002\n\000R\031\020¬\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020­\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020®\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020¯\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020°\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020±\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\017\020²\001\032\0020AX\016¢\006\002\n\000R\031\020³\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020´\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000R\031\020µ\001\032\b\022\004\022\0020\r0\b8\006@\006X\016¢\006\002\n\000¨\006Ö\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AirBypass", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getAirBypass", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "AirBypass2", "Lnet/ccbluex/liquidbounce/value/Value;", "", "getAirBypass2", "()Lnet/ccbluex/liquidbounce/value/Value;", "BlockRangeValue", "", "CancelC03Range", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getCancelC03Range", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "setCancelC03Range", "(Lnet/ccbluex/liquidbounce/value/FloatValue;)V", "HytKillFix", "aacValue", "afterAttackValue", "airRangeValue", "al", "attackDelay", "", "attackTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "autoBlockFacing", "autoBlockPacketValue", "", "autoBlockValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bb", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "blockingStatus", "getBlockingStatus", "()Z", "setBlockingStatus", "(Z)V", "brightnessValue", "cancelRun", "getCancelRun", "circleAccuracy", "", "circleAlpha", "circleBlue", "circleGreen", "circleRed", "circleValue", "circletargetValue", "clicks", "colorAlphaValue", "colorBlueValue", "colorGreenValue", "colorModeValue", "colorRedValue", "colorTeam", "containerOpen", "cooldownValue", "currentTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "delayedBlockValue", "direction", "", "displayMode", "entity", "failRateValue", "failchange", "getFailchange", "failcount", "getFailcount", "()I", "setFailcount", "(I)V", "failcountvalue", "getFailcountvalue", "faildebug", "getFaildebug", "failrange", "getFailrange", "failstatus", "getFailstatus", "setFailstatus", "failtick", "getFailtick", "fakeSharpValue", "fakeSwingValue", "fovValue", "getFovValue", "groundRangeValue", "hasnoticed", "getHasnoticed", "setHasnoticed", "hitable", "hitableValue", "hurtTimeValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getHurtTimeValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "hyt180fovfixValue", "hyttestrotations", "interactAutoBlockValue", "jelloAlphaValue", "jelloFadeSpeedValue", "jelloGradientHeightValue", "jelloWidthValue", "karange", "getKarange", "()F", "setKarange", "(F)V", "keepSprintValue", "getKeepSprintValue", "lastDeltaMS", "lastMS", "lastTarget", "lightingModeValue", "lightingSoundValue", "lightingValue", "limitedMultiTargetsValue", "livingRaycastValue", "markValue", "maxCPS", "maxPredictSize", "maxRange", "getMaxRange", "maxTurnSpeed", "minCPS", "minPredictSize", "minTurnSpeed", "noInventoryAttackValue", "noInventoryDelayValue", "outborderValue", "predictValue", "prevTargetEntities", "", "priorityValue", "progress", "randomCenterValue", "rangeSprintReducementValue", "rangeValue", "getRangeValue", "raycastIgnoredValue", "raycastValue", "rotationStrafeValue", "rotations", "saturationValue", "silentRotationValue", "stopSprintAir", "switchDelayValue", "switchTimer", "syncEntity", "getSyncEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setSyncEntity", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "tag", "getTag", "()Ljava/lang/String;", "target", "getTarget", "setTarget", "targetModeValue", "getTargetModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "throughWallsRangeValue", "tickcount", "getTickcount", "setTickcount", "vanillamode", "xDistValue", "xMaxValue", "xMinValue", "yDistValue", "yMaxValue", "yMinValue", "yPos", "zDistValue", "zMaxValue", "zMinValue", "attackEntity", "", "canBlock", "getRange", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isAlive", "isEnemy", "onDisable", "onEnable", "onEntityMove", "event", "Lnet/ccbluex/liquidbounce/event/EntityMovementEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "runAttack", "startBlocking", "interactEntity", "interact", "stopBlocking", "update", "updateHitable", "updateRotations", "updateTarget", "Companion", "XSJClient"})
/*      */ public final class KillAura3
/*      */   extends Module
/*      */ {
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"post3D", "", "invoke"})
/*      */   static final class KillAura3$onRender3D$1
/*      */     extends Lambda
/*      */     implements Function0<Unit>
/*      */   {
/*      */     public static final KillAura3$onRender3D$1 INSTANCE = new KillAura3$onRender3D$1();
/*      */     
/*      */     public final void invoke() {
/*  588 */       GL11.glDepthMask(true);
/*  589 */       GL11.glEnable(2929);
/*  590 */       GL11.glDisable(2848);
/*  591 */       GL11.glEnable(3553);
/*  592 */       GL11.glDisable(3042);
/*  593 */       GL11.glPopMatrix();
/*  594 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     }
/*      */     
/*      */     KillAura3$onRender3D$1() {
/*      */       super(0);
/*      */     }
/*      */   }
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\030\n\000\n\002\020\002\n\000\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\006\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020\005\032\0020\0032\006\020\006\032\0020\0072\006\020\b\032\0020\0032\006\020\t\032\0020\0072\006\020\n\032\0020\0072\006\020\013\032\0020\0072\006\020\f\032\0020\007H\n¢\006\002\b\r"}, d2 = {"drawCircle", "", "x", "", "y", "z", "width", "", "radius", "red", "green", "blue", "alp", "invoke"})
/*      */   static final class KillAura3$onRender3D$2
/*      */     extends Lambda implements Function9<Double, Double, Double, Float, Double, Float, Float, Float, Float, Unit>
/*      */   {
/*      */     public static final KillAura3$onRender3D$2 INSTANCE = new KillAura3$onRender3D$2();
/*      */     
/*  608 */     public final void invoke(double x, double y, double z, float width, double radius, float red, float green, float blue, float alp) { GL11.glLineWidth(width);
/*  609 */       GL11.glBegin(2);
/*  610 */       GL11.glColor4f(red, green, blue, alp);
/*  611 */       int i = 0;
/*  612 */       while (i <= 360) {
/*  613 */         double posX = x - Math.sin(i * Math.PI / '´') * radius;
/*  614 */         double posZ = z + Math.cos(i * Math.PI / '´') * radius;
/*  615 */         GL11.glVertex3d(posX, y, posZ);
/*  616 */         i++;
/*      */       } 
/*  618 */       GL11.glEnd(); } KillAura3$onRender3D$2() { super(9); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"pre3D", "", "invoke"})
/*      */   static final class KillAura3$onRender3D$3 extends Lambda implements Function0<Unit> { public static final KillAura3$onRender3D$3 INSTANCE = new KillAura3$onRender3D$3();
/*  621 */     public final void invoke() { GL11.glPushMatrix();
/*  622 */       GL11.glEnable(3042);
/*  623 */       GL11.glBlendFunc(770, 771);
/*  624 */       GL11.glShadeModel(7425);
/*  625 */       GL11.glDisable(3553);
/*  626 */       GL11.glEnable(2848);
/*  627 */       GL11.glDisable(2929);
/*  628 */       GL11.glDisable(2896);
/*  629 */       GL11.glDepthMask(false);
/*  630 */       GL11.glHint(3154, 4354);
/*  631 */       GL11.glDisable(2884); } KillAura3$onRender3D$3() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\004\030\0010\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"getColor", "Ljava/awt/Color;", "ent", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "invoke"})
/*      */   static final class KillAura3$onRender3D$4 extends Lambda implements Function1<IEntityLivingBase, Color> { @Nullable
/*  634 */     public final Color invoke(@Nullable IEntityLivingBase ent) { int[] counter = { 0 };
/*  635 */       if (ent instanceof net.minecraft.entity.EntityLivingBase) {
/*  636 */         IEntityLivingBase entityLivingBase = ent;
/*      */         
/*  638 */         if (StringsKt.equals((String)KillAura3.this.colorModeValue.get(), "Health", true)) return BlendUtils.getHealthColor(
/*  639 */               entityLivingBase.getHealth(), 
/*  640 */               entityLivingBase.getMaxHealth());
/*      */         
/*  642 */         if (((Boolean)KillAura3.this.colorTeam.get()).booleanValue()) {
/*      */           
/*  644 */           if (entityLivingBase.getDisplayName() == null) Intrinsics.throwNpe();  String str1 = entityLivingBase.getDisplayName().getFormattedText(); byte b = 0; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] chars = str1.toCharArray();
/*  645 */           int color = Integer.MAX_VALUE; int i;
/*  646 */           for (b = 0, i = chars.length; b < i; b++) {
/*  647 */             if (chars[b] == '§' && b + 1 < chars.length) {
/*  648 */               int index = GameFontRenderer.Companion.getColorIndex(chars[b + 1]);
/*  649 */               if (index >= 0 && index <= 15) {
/*  650 */                 color = ColorUtils.hexColors[index]; break;
/*      */               } 
/*      */             } 
/*  653 */           }  return new Color(color);
/*      */         } 
/*      */       } 
/*  656 */       String str = (String)KillAura3.this.colorModeValue.get(); switch (str.hashCode())
/*      */       
/*      */       { 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 83201:
/*  664 */           if (str.equals("Sky")); break;
/*  665 */         case -884013110: if (str.equals("LiquidSlowly")); break;case -1656737386: if (str.equals("Rainbow")); break;case 2132719113: if (str.equals("Gident")); break;
/*  666 */         case 2029746065: if (str.equals("Custom")); break; }  return ColorUtils.fade(new Color(((Number)KillAura3.this.colorRedValue.get()).intValue(), ((Number)KillAura3.this.colorGreenValue.get()).intValue(), ((Number)KillAura3.this.colorBlueValue.get()).intValue()), 0, 100); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     KillAura3$onRender3D$4() {
/*      */       super(1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\n\n\000\n\002\020\006\n\002\b\002\020\000\032\0020\0012\006\020\002\032\0020\001H\n¢\006\002\b\003"}, d2 = {"easeInOutQuart", "", "x", "invoke"})
/*      */   static final class KillAura3$onRender3D$5
/*      */     extends Lambda
/*      */     implements Function1<Double, Double>
/*      */   {
/*      */     public static final KillAura3$onRender3D$5 INSTANCE = new KillAura3$onRender3D$5();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     KillAura3$onRender3D$5() {
/*      */       super(1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final double invoke(double x) {
/*  861 */       return (x < 0.5D) ? (8 * x * x * x * x) : (true - Math.pow(-2 * x + 2, 4.0D) / 2);
/*      */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$groundRangeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.HytKillFix.get()).booleanValue(); } KillAura3$groundRangeValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$airRangeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.HytKillFix.get()).booleanValue(); } KillAura3$airRangeValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$faildebug$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.getFailchange().get()).booleanValue(); } KillAura3$faildebug$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$failrange$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.getFailchange().get()).booleanValue(); } KillAura3$failrange$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$failcountvalue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.getFailchange().get()).booleanValue(); } KillAura3$failcountvalue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$failtick$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.getFailchange().get()).booleanValue(); } KillAura3$failtick$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$AirBypass2$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true); } KillAura3$AirBypass2$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$BlockRangeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$BlockRangeValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$autoBlockPacketValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$autoBlockPacketValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$vanillamode$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$vanillamode$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$interactAutoBlockValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$interactAutoBlockValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$delayedBlockValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$delayedBlockValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$afterAttackValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$afterAttackValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$autoBlockFacing$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.autoBlockValue.get(), "Off") ^ true; } KillAura3$autoBlockFacing$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$lightingModeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.lightingValue.get()).booleanValue(); } KillAura3$lightingModeValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$lightingSoundValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.lightingValue.get()).booleanValue(); } KillAura3$lightingSoundValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$hyttestrotations$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true); } KillAura3$hyttestrotations$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$xMinValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$xMinValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$xMaxValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$xMaxValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$xDistValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$xDistValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$yMinValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$yMinValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$yMaxValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$yMaxValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$yDistValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$yDistValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$zMinValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$zMinValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$zMaxValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$zMaxValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$zDistValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (StringsKt.equals((String)KillAura3.this.hyttestrotations.get(), "Custom", true) && StringsKt.equals((String)KillAura3.this.rotations.get(), "HYT", true)); } KillAura3$zDistValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$rotationStrafeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return (((Boolean)KillAura3.this.silentRotationValue.get()).booleanValue() && !KillAura3.this.rotations.equals("None")); }
/*      */     KillAura3$rotationStrafeValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$colorModeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$colorModeValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$colorRedValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$colorRedValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$colorGreenValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$colorGreenValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$colorBlueValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$colorBlueValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$colorAlphaValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$colorAlphaValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$saturationValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$saturationValue$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$brightnessValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$brightnessValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$colorTeam$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$colorTeam$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$jelloAlphaValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$jelloAlphaValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$jelloWidthValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$jelloWidthValue$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$jelloGradientHeightValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$jelloGradientHeightValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$jelloFadeSpeedValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return Intrinsics.areEqual(KillAura3.this.markValue.get(), "Jello"); }
/*      */     KillAura3$jelloFadeSpeedValue$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$circleRed$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura3.this.circleValue.get()).booleanValue(); }
/*      */     KillAura3$circleRed$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$circleGreen$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura3.this.circleValue.get()).booleanValue(); }
/*      */     KillAura3$circleGreen$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$circleBlue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura3.this.circleValue.get()).booleanValue(); }
/*      */     KillAura3$circleBlue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$circleAlpha$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura3.this.circleValue.get()).booleanValue(); }
/*      */     KillAura3$circleAlpha$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura3$circleAccuracy$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura3.this.circleValue.get()).booleanValue(); }
/*      */     KillAura3$circleAccuracy$1() { super(0); } }
/*      */   @NotNull public String getTag() { String str = (String)this.displayMode.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1644405847: if (str.equals("complicated2")); break;case 501143977: if (str.equals("complicated")); break;case -902286926: if (str.equals("simple")); break;case -976782197: if (str.equals("lesssimple")); break; }  return (String)this.targetModeValue.get() + ""; }
/*      */   private final ListValue displayMode = new ListValue("DisplayMode", new String[] { "Simple", "LessSimple", "Complicated", "Complicated2" }, "Simple"); private final IntegerValue maxCPS = new KillAura3$maxCPS$1("MaxCPS", 8, 1, 20);
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$maxCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura3$maxCPS$1 extends IntegerValue { KillAura3$maxCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */     protected void onChanged(int oldValue, int newValue) { int i = ((Number)KillAura3.this.minCPS.get()).intValue(); if (i > newValue) set(Integer.valueOf(i));  KillAura3.this.attackDelay = TimeUtils.randomClickDelay(((Number)KillAura3.this.minCPS.get()).intValue(), ((Number)get()).intValue()); } }
/*      */   private final IntegerValue minCPS = new KillAura3$minCPS$1("MinCPS", 5, 1, 20);
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$minCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura3$minCPS$1 extends IntegerValue { KillAura3$minCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*      */     protected void onChanged(int oldValue, int newValue) { int i = ((Number)KillAura3.this.maxCPS.get()).intValue(); if (i < newValue) set(Integer.valueOf(i));  KillAura3.this.attackDelay = TimeUtils.randomClickDelay(((Number)get()).intValue(), ((Number)KillAura3.this.maxCPS.get()).intValue()); } }
/*      */   @NotNull private final IntegerValue hurtTimeValue = new IntegerValue("HurtTime", 10, 0, 10);
/*  949 */   @EventTarget public final void onEntityMove(@NotNull EntityMovementEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); IEntity movedEntity = event.getMovedEntity();
/*      */     
/*  951 */     if (this.target == null || (Intrinsics.areEqual(movedEntity, this.currentTarget) ^ true) != 0) {
/*      */       return;
/*      */     }
/*  954 */     updateHitable(); }
/*      */   @NotNull public final IntegerValue getHurtTimeValue() { return this.hurtTimeValue; }
/*      */   private final FloatValue cooldownValue = new FloatValue("Cooldown", 1.0F, 0.0F, 1.0F);
/*      */   private final BoolValue HytKillFix = new BoolValue("HytKillFix", true); @NotNull private final FloatValue rangeValue = new FloatValue("Range", 3.7F, 1.0F, 8.0F); @NotNull public final FloatValue getRangeValue() { return this.rangeValue; } private final Value<Float> groundRangeValue = (new FloatValue("GroundRange", 3.4F, 1.0F, 8.0F)).displayable(new KillAura3$groundRangeValue$1()); private final Value<Float> airRangeValue = (new FloatValue("AirRange", 3.0F, 1.0F, 8.0F)).displayable(new KillAura3$airRangeValue$1()); @NotNull private FloatValue CancelC03Range = new FloatValue("CancelC03Range", 5.0F, 0.0F, 10.0F); @NotNull public final FloatValue getCancelC03Range() { return this.CancelC03Range; } public final void setCancelC03Range(@NotNull FloatValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.CancelC03Range = <set-?>; } private final FloatValue throughWallsRangeValue = new FloatValue("ThroughWallsRange", 3.0F, 0.0F, 8.0F); private final FloatValue rangeSprintReducementValue = new FloatValue("RangeSprintReducement", 0.0F, 0.0F, 0.4F); private final ListValue priorityValue = new ListValue("Priority", new String[] { "Health", "Distance", "Direction", "LivingTime", "HurtResitanTime" }, "Distance"); @NotNull private final ListValue targetModeValue = new ListValue("TargetMode", new String[] { "Single", "Switch", "Multi" }, "Switch"); @NotNull public final ListValue getTargetModeValue() { return this.targetModeValue; } @NotNull private final BoolValue failchange = new BoolValue("FailChange", true); @NotNull public final BoolValue getFailchange() { return this.failchange; } @NotNull private final Value<Boolean> faildebug = (new BoolValue("FailDebug", true)).displayable(new KillAura3$faildebug$1()); @NotNull public final Value<Boolean> getFaildebug() { return this.faildebug; } @NotNull private final Value<Float> failrange = (new FloatValue("FailRange", 3.0F, 0.0F, 4.0F)).displayable(new KillAura3$failrange$1()); @NotNull public final Value<Float> getFailrange() { return this.failrange; } @NotNull private final Value<Integer> failcountvalue = (new IntegerValue("FailCount", 2, 0, 5)).displayable(new KillAura3$failcountvalue$1()); @NotNull public final Value<Integer> getFailcountvalue() { return this.failcountvalue; } @NotNull private final Value<Integer> failtick = (new IntegerValue("FailRangeKeepTick", 15, 0, 30)).displayable(new KillAura3$failtick$1()); @NotNull public final Value<Integer> getFailtick() { return this.failtick; } @NotNull private final BoolValue keepSprintValue = new BoolValue("KeepSprint", true); @NotNull public final BoolValue getKeepSprintValue() { return this.keepSprintValue; } private final BoolValue stopSprintAir = new BoolValue("StopSprintOnAir", true); @NotNull private final BoolValue AirBypass = new BoolValue("AirBypass", true); @NotNull public final BoolValue getAirBypass() { return this.AirBypass; } @NotNull private final Value<Boolean> AirBypass2 = (new BoolValue("AirHYTRotation", true)).displayable(new KillAura3$AirBypass2$1()); @NotNull public final Value<Boolean> getAirBypass2() { return this.AirBypass2; } private final BoolValue hyt180fovfixValue = new BoolValue("HytAutoStrafeFix", true); private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "Range", "GrimAC", "Off" }, "Off"); private final Value<Float> BlockRangeValue = (new FloatValue("AutoBlockRange", 3.0F, 0.0F, 8.0F)).displayable(new KillAura3$BlockRangeValue$1()); private final Value<String> autoBlockPacketValue = (new ListValue("AutoBlockPacket", new String[] { "Vanilla", "Fake", "Mouse", "GameSettings", "UseItem" }, "Vanilla")).displayable(new KillAura3$autoBlockPacketValue$1()); private final Value<String> vanillamode = (new ListValue("VanillaMode", new String[] { "TryUseItem", "UseItem", "CPacketPlayerBlockPlacement" }, "TryUseItem")).displayable(new KillAura3$vanillamode$1()); private final Value<Boolean> interactAutoBlockValue = (new BoolValue("InteractAutoBlock", true)).displayable(new KillAura3$interactAutoBlockValue$1()); private final Value<Boolean> delayedBlockValue = (new BoolValue("AutoBlock-AfterTck", false)).displayable(new KillAura3$delayedBlockValue$1()); private final Value<Boolean> afterAttackValue = (new BoolValue("AutoBlock-AfterAttack", false)).displayable(new KillAura3$afterAttackValue$1()); private final Value<Boolean> autoBlockFacing = (new BoolValue("AutoBlockFacing", false)).displayable(new KillAura3$autoBlockFacing$1()); private final BoolValue raycastValue = new BoolValue("RayCast", true); private final BoolValue raycastIgnoredValue = new BoolValue("RayCastIgnored", false); private final BoolValue livingRaycastValue = new BoolValue("LivingRayCast", true); private final BoolValue aacValue = new BoolValue("AAC", false); private final FloatValue maxTurnSpeed = new KillAura3$maxTurnSpeed$1("MaxTurnSpeed", 180.0F, 0.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$maxTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura3$maxTurnSpeed$1 extends FloatValue {
/*      */     KillAura3$maxTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura3.this.minTurnSpeed.get()).floatValue(); if (v > newValue) set(Float.valueOf(v));  } } private final FloatValue minTurnSpeed = new KillAura3$minTurnSpeed$1("MinTurnSpeed", 180.0F, 0.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$minTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura3$minTurnSpeed$1 extends FloatValue {
/*      */     KillAura3$minTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura3.this.maxTurnSpeed.get()).floatValue(); if (v < newValue) set(Float.valueOf(v));  } } private final BoolValue lightingValue = new BoolValue("Lighting", false); private final Value<String> lightingModeValue = (new ListValue("Lighting-Mode", new String[] { "Dead", "Attack" }, "Dead")).displayable(new KillAura3$lightingModeValue$1()); private final Value<Boolean> lightingSoundValue = (new BoolValue("Lighting-Sound", true)).displayable(new KillAura3$lightingSoundValue$1()); private final BoolValue randomCenterValue = new BoolValue("RandomCenter", true); private final ListValue rotations = new ListValue("RotationMode", new String[] { "None", "HYT", "Liquidbounce", "BackTrack", "Test", "HytRotation", "Down" }, "New"); @JvmField @NotNull public Value<String> hyttestrotations = (new ListValue("HYTRotationsMode", new String[] { "Head", "Neck", "Body", "Penis", "Feet", "Knee", "Custom" }, "Head")).displayable(new KillAura3$hyttestrotations$1()); @JvmField @NotNull public Value<Float> xMinValue = (new FloatValue("xMin", 0.45F, 0.0F, 2.0F)).displayable(new KillAura3$xMinValue$1()); @JvmField @NotNull public Value<Float> xMaxValue = (new FloatValue("xMax", 0.55F, 0.0F, 2.0F)).displayable(new KillAura3$xMaxValue$1()); @JvmField @NotNull public Value<Float> xDistValue = (new FloatValue("xDist", 0.0125F, 0.0F, 2.0F)).displayable(new KillAura3$xDistValue$1()); @JvmField @NotNull public Value<Float> yMinValue = (new FloatValue("yMin", 0.65F, 0.0F, 2.0F)).displayable(new KillAura3$yMinValue$1()); @JvmField @NotNull public Value<Float> yMaxValue = (new FloatValue("yMax", 0.75F, 0.0F, 2.0F)).displayable(new KillAura3$yMaxValue$1()); @JvmField @NotNull public Value<Float> yDistValue = (new FloatValue("yDist", 0.0125F, 0.0F, 2.0F)).displayable(new KillAura3$yDistValue$1()); @JvmField @NotNull public Value<Float> zMinValue = (new FloatValue("zMin", 0.45F, 0.0F, 2.0F)).displayable(new KillAura3$zMinValue$1()); @JvmField @NotNull public Value<Float> zMaxValue = (new FloatValue("zMax", 0.55F, 0.0F, 2.0F)).displayable(new KillAura3$zMaxValue$1()); @JvmField @NotNull public Value<Float> zDistValue = (new FloatValue("zDist", 0.0125F, 0.0F, 1.0F)).displayable(new KillAura3$zDistValue$1()); private final BoolValue outborderValue = new BoolValue("Outborder", false); private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true); private final Value<String> rotationStrafeValue = (new ListValue("Strafe", new String[] { "Off", "Strict", "Silent" }, "Off")).displayable(new KillAura3$rotationStrafeValue$1()); @NotNull private final FloatValue fovValue = new FloatValue("FOV", 180.0F, 0.0F, 180.0F); @NotNull public final FloatValue getFovValue() { return this.fovValue; } private final BoolValue hitableValue = new BoolValue("AlwaysHitable", true); private final IntegerValue switchDelayValue = new IntegerValue("SwitchDelay", 300, 1, 2000); private final BoolValue predictValue = new BoolValue("Predict", true); private final FloatValue maxPredictSize = new KillAura3$maxPredictSize$1("MaxPredictSize", 1.0F, 0.1F, 5.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$maxPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura3$maxPredictSize$1 extends FloatValue {
/*      */     KillAura3$maxPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura3.this.minPredictSize.get()).floatValue(); if (v > newValue) set(Float.valueOf(v));  } } private final FloatValue minPredictSize = new KillAura3$minPredictSize$1("MinPredictSize", 1.0F, 0.1F, 5.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$minPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura3$minPredictSize$1 extends FloatValue {
/*  961 */     KillAura3$minPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura3.this.maxPredictSize.get()).floatValue(); if (v < newValue) set(Float.valueOf(v));  } } private final FloatValue failRateValue = new FloatValue("FailRate", 0.0F, 0.0F, 100.0F); private final void runAttack() { if (this.target != null)
/*  962 */     { if (this.currentTarget != null)
/*  963 */       { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  964 */           if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*      */ 
/*      */             
/*  967 */             float failRate = ((Number)this.failRateValue.get()).floatValue();
/*  968 */             boolean swing = true;
/*  969 */             boolean multi = StringsKt.equals((String)this.targetModeValue.get(), "Multi", true);
/*  970 */             boolean openInventory = (((Boolean)this.aacValue.get()).booleanValue() && MinecraftInstance.classProvider.isGuiContainer(MinecraftInstance.mc.getCurrentScreen()));
/*  971 */             boolean failHit = (failRate > false && (new Random()).nextInt(100) <= failRate);
/*      */ 
/*      */             
/*  974 */             if (openInventory) {
/*  975 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow());
/*      */             }
/*      */ 
/*      */             
/*  979 */             if (!this.hitable || failHit) {
/*  980 */               if (((Boolean)this.fakeSwingValue.get()).booleanValue() || failHit) {
/*  981 */                 thePlayer.swingItem();
/*      */               }
/*      */             } else {
/*  984 */               if (!multi) {
/*  985 */                 if (this.currentTarget == null) Intrinsics.throwNpe();  attackEntity(this.currentTarget);
/*      */               } else {
/*  987 */                 int targets = 0;
/*      */                 
/*  989 */                 for (IEntity entity : theWorld.getLoadedEntityList()) {
/*  990 */                   double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity);
/*      */                   
/*  992 */                   if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && isEnemy(entity) && distance <= getRange(entity)) {
/*  993 */                     attackEntity(entity.asEntityLivingBase());
/*      */                     
/*  995 */                     targets++;
/*      */                     
/*  997 */                     if (((Number)this.limitedMultiTargetsValue.get()).intValue() != 0 && ((Number)this.limitedMultiTargetsValue.get()).intValue() <= targets) {
/*      */                       break;
/*      */                     }
/*      */                   } 
/*      */                 } 
/*      */               } 
/* 1003 */               if (StringsKt.equals((String)this.targetModeValue.get(), "Switch", true)) {
/* 1004 */                 if (this.switchTimer.hasTimePassed(((Number)this.switchDelayValue.get()).intValue())) {
/* 1005 */                   if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/* 1006 */                   this.switchTimer.reset();
/*      */                 } 
/*      */               } else {
/* 1009 */                 if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/*      */               } 
/*      */               
/* 1012 */               if (Intrinsics.areEqual(this.target, this.currentTarget)) {
/* 1013 */                 this.target = (IEntityLivingBase)null;
/*      */               }
/*      */             } 
/*      */             
/* 1017 */             if (openInventory)
/* 1018 */             { IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createOpenInventoryPacket = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1596 */               if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY); iINetHandlerPlayClient.addToSendQueue(iPacket); }  return; }  MinecraftInstance.mc.getTheWorld(); return; }  MinecraftInstance.mc.getThePlayer(); return; }  return; }  } private final BoolValue fakeSwingValue = new BoolValue("FakeSwing", true); private final BoolValue noInventoryAttackValue = new BoolValue("NoInvAttack", false); private final IntegerValue noInventoryDelayValue = new IntegerValue("NoInvDelay", 200, 0, 500); private final IntegerValue limitedMultiTargetsValue = new IntegerValue("LimitedMultiTargets", 0, 0, 50); private final ListValue markValue = new ListValue("Mark", new String[] { "Liquid", "FDP", "Block", "Jello", "Plat", "Red", "Sims", "None" }, "FDP"); private final Value<String> colorModeValue = (new ListValue("JelloColor", new String[] { "Custom", "Rainbow", "Sky", "LiquidSlowly", "Fade", "Health", "Gident" }, "Custom")).displayable(new KillAura3$colorModeValue$1()); private final Value<Integer> colorRedValue = (new IntegerValue("JelloRed", 255, 0, 255)).displayable(new KillAura3$colorRedValue$1()); private final Value<Integer> colorGreenValue = (new IntegerValue("JelloGreen", 255, 0, 255)).displayable(new KillAura3$colorGreenValue$1()); private final Value<Integer> colorBlueValue = (new IntegerValue("JelloBlue", 255, 0, 255)).displayable(new KillAura3$colorBlueValue$1()); private final Value<Integer> colorAlphaValue = (new IntegerValue("JelloAlpha", 255, 0, 255)).displayable(new KillAura3$colorAlphaValue$1()); private final Value<Float> saturationValue = (new FloatValue("Saturation", 1.0F, 0.0F, 1.0F)).displayable(new KillAura3$saturationValue$1()); private final Value<Float> brightnessValue = (new FloatValue("Brightness", 1.0F, 0.0F, 1.0F)).displayable(new KillAura3$brightnessValue$1()); private final Value<Boolean> colorTeam = (new BoolValue("JelloTeam", false)).displayable(new KillAura3$colorTeam$1()); private final Value<Float> jelloAlphaValue = (new FloatValue("JelloEndAlphaPercent", 0.4F, 0.0F, 1.0F)).displayable(new KillAura3$jelloAlphaValue$1()); private final Value<Float> jelloWidthValue = (new FloatValue("JelloCircleWidth", 3.0F, 0.01F, 5.0F)).displayable(new KillAura3$jelloWidthValue$1()); private final Value<Float> jelloGradientHeightValue = (new FloatValue("JelloGradientHeight", 3.0F, 1.0F, 8.0F)).displayable(new KillAura3$jelloGradientHeightValue$1()); private final Value<Float> jelloFadeSpeedValue = (new FloatValue("JelloFadeSpeed", 0.1F, 0.01F, 0.5F)).displayable(new KillAura3$jelloFadeSpeedValue$1()); private final BoolValue fakeSharpValue = new BoolValue("FakeSharp", true); private final BoolValue circletargetValue = new BoolValue("CircleTarget", true); private final BoolValue circleValue = new BoolValue("Circle", true); private final Value<Integer> circleRed = (new IntegerValue("CircleRed", 255, 0, 255)).displayable(new KillAura3$circleRed$1()); private final Value<Integer> circleGreen = (new IntegerValue("CircleGreen", 255, 0, 255)).displayable(new KillAura3$circleGreen$1()); private final Value<Integer> circleBlue = (new IntegerValue("CircleBlue", 255, 0, 255)).displayable(new KillAura3$circleBlue$1()); private final Value<Integer> circleAlpha = (new IntegerValue("CircleAlpha", 255, 0, 255)).displayable(new KillAura3$circleAlpha$1()); private final Value<Integer> circleAccuracy = (new IntegerValue("CircleAccuracy", 15, 0, 60)).displayable(new KillAura3$circleAccuracy$1()); private boolean failstatus; public final boolean getFailstatus() { return this.failstatus; } public final void setFailstatus(boolean <set-?>) { this.failstatus = <set-?>; } private float karange = 3.0F; private int failcount; private int tickcount; private boolean hasnoticed; public final float getKarange() { return this.karange; } public final void setKarange(float <set-?>) { this.karange = <set-?>; } public final int getFailcount() { return this.failcount; } public final void setFailcount(int <set-?>) { this.failcount = <set-?>; } public final int getTickcount() { return this.tickcount; } public final void setTickcount(int <set-?>) { this.tickcount = <set-?>; } public final boolean getHasnoticed() { return this.hasnoticed; } public final void setHasnoticed(boolean <set-?>) { this.hasnoticed = <set-?>; } private final MSTimer switchTimer = new MSTimer(); @Nullable private IEntityLivingBase target; private IEntityLivingBase currentTarget; private boolean hitable; private final List<Integer> prevTargetEntities; private IEntityLivingBase lastTarget; private double direction; private double yPos; private double progress; private long lastMS; private long lastDeltaMS; private float al; private final MSTimer attackTimer; private long attackDelay; private int clicks; private long containerOpen; private IAxisAlignedBB bb; private IEntityLivingBase entity; private boolean blockingStatus; @Nullable private IEntityLivingBase syncEntity; private static int killCounts; public static final Companion Companion = new Companion(null); @Nullable public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; } public KillAura3() { KillAura3 killAura3 = this; boolean bool = false; ArrayList<Integer> arrayList = new ArrayList(); this.direction = 1.0D; this.lastMS = System.currentTimeMillis(); this.attackTimer = new MSTimer(); this.containerOpen = -1L; } public final boolean getBlockingStatus() { return this.blockingStatus; } public final void setBlockingStatus(boolean <set-?>) { this.blockingStatus = <set-?>; } @Nullable public final IEntityLivingBase getSyncEntity() { return this.syncEntity; } public final void setSyncEntity(@Nullable IEntityLivingBase <set-?>) { this.syncEntity = <set-?>; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\006\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R$\020\003\032\0020\0048\006@\006X\016¢\006\024\n\000\022\004\b\005\020\002\032\004\b\006\020\007\"\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$Companion;", "", "()V", "killCounts", "", "killCounts$annotations", "getKillCounts", "()I", "setKillCounts", "(I)V", "XSJClient"}) public static final class Companion {
/*      */     private Companion() {} public final void setKillCounts(int <set-?>) { KillAura3.killCounts = <set-?>; } public final int getKillCounts() { return KillAura3.killCounts; } } public void onEnable() { if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { MinecraftInstance.mc.getTheWorld(); updateTarget(); return; }  MinecraftInstance.mc.getTheWorld(); return; }  MinecraftInstance.mc.getThePlayer(); } public void onDisable() { this.target = (IEntityLivingBase)null; this.currentTarget = (IEntityLivingBase)null; this.lastTarget = (IEntityLivingBase)null; this.hitable = false; this.prevTargetEntities.clear(); this.attackTimer.reset(); this.clicks = 0; stopBlocking(); } @EventTarget public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.stopSprintAir.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { this.keepSprintValue.set(Boolean.valueOf(true)); } else { this.keepSprintValue.set(Boolean.valueOf(false)); }  }  if (event.getEventState() == EventState.POST) { if (this.target != null) { if (this.currentTarget != null) { updateHitable(); if (!StringsKt.equals((String)this.autoBlockValue.get(), "off", true) && ((Boolean)this.delayedBlockValue.get()).booleanValue() && canBlock()) { if (this.currentTarget == null) Intrinsics.throwNpe();  startBlocking((IEntity)this.currentTarget, ((Boolean)this.interactAutoBlockValue.get()).booleanValue()); }  return; }  return; }  return; }  if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) update();  } @EventTarget public final void onStrafe(@NotNull StrafeEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) return;  update(); if (this.currentTarget != null && RotationUtils.targetRotation != null) { String str = (String)this.rotationStrafeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -902327211: if (str.equals("silent")) { update(); RotationUtils.targetRotation.applyStrafeToPlayer(event); event.cancelEvent(); }  break;case -891986231: if (str.equals("strict")) { if (RotationUtils.targetRotation != null) { Rotation rotation = RotationUtils.targetRotation; float yaw = rotation.component1(); float strafe = event.getStrafe(); float forward = event.getForward(); float friction = event.getFriction(); float f = strafe * strafe + forward * forward; if (f >= 1.0E-4F) { boolean bool1 = false; f = (float)Math.sqrt(f); if (f < 1.0F) f = 1.0F;  f = friction / f; strafe *= f; forward *= f; float f1 = (float)(yaw * Math.PI / 180.0F); boolean bool2 = false; float yawSin = (float)Math.sin(f1); float f2 = (float)(yaw * Math.PI / 180.0F); boolean bool3 = false; float yawCos = (float)Math.cos(f2); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); player.setMotionX(player.getMotionX() + (strafe * yawCos - forward * yawSin)); player.setMotionZ(player.getMotionZ() + (forward * yawCos + strafe * yawSin)); }  event.cancelEvent(); break; }  return; }  break; }  }  } public final void update() { // Byte code:
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
/*      */     //   24: ifne -> 88
/*      */     //   27: aload_1
/*      */     //   28: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   31: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   36: dup
/*      */     //   37: ifnonnull -> 43
/*      */     //   40: invokestatic throwNpe : ()V
/*      */     //   43: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   46: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   49: ifeq -> 88
/*      */     //   52: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   55: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   58: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   61: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   64: invokevirtual getState : ()Z
/*      */     //   67: ifne -> 88
/*      */     //   70: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   73: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   76: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   79: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   82: invokevirtual getState : ()Z
/*      */     //   85: ifeq -> 92
/*      */     //   88: iconst_1
/*      */     //   89: goto -> 93
/*      */     //   92: iconst_0
/*      */     //   93: ifne -> 156
/*      */     //   96: aload_0
/*      */     //   97: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   100: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   103: checkcast java/lang/Boolean
/*      */     //   106: invokevirtual booleanValue : ()Z
/*      */     //   109: ifeq -> 157
/*      */     //   112: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   115: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   118: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   123: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   128: ifne -> 156
/*      */     //   131: invokestatic currentTimeMillis : ()J
/*      */     //   134: aload_0
/*      */     //   135: getfield containerOpen : J
/*      */     //   138: lsub
/*      */     //   139: aload_0
/*      */     //   140: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   146: checkcast java/lang/Number
/*      */     //   149: invokevirtual longValue : ()J
/*      */     //   152: lcmp
/*      */     //   153: ifge -> 157
/*      */     //   156: return
/*      */     //   157: aload_0
/*      */     //   158: invokespecial updateTarget : ()V
/*      */     //   161: aload_0
/*      */     //   162: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   165: ifnonnull -> 173
/*      */     //   168: aload_0
/*      */     //   169: invokespecial stopBlocking : ()V
/*      */     //   172: return
/*      */     //   173: aload_0
/*      */     //   174: aload_0
/*      */     //   175: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   178: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   181: aload_0
/*      */     //   182: getfield targetModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   185: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   188: checkcast java/lang/String
/*      */     //   191: ldc_w 'Switch'
/*      */     //   194: iconst_1
/*      */     //   195: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   198: ifne -> 223
/*      */     //   201: aload_0
/*      */     //   202: aload_0
/*      */     //   203: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   206: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   209: invokespecial isEnemy : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */     //   212: ifeq -> 223
/*      */     //   215: aload_0
/*      */     //   216: aload_0
/*      */     //   217: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   220: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   223: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #431	-> 0
/*      */     //   #432	-> 0
/*      */     //   #431	-> 2
/*      */     //   #1586	-> 4
/*      */     //   #1587	-> 4
/*      */     //   #1586	-> 28
/*      */     //   #1587	-> 52
/*      */     //   #431	-> 96
/*      */     //   #432	-> 131
/*      */     //   #433	-> 156
/*      */     //   #435	-> 157
/*      */     //   #437	-> 161
/*      */     //   #438	-> 168
/*      */     //   #439	-> 172
/*      */     //   #445	-> 173
/*      */     //   #447	-> 181
/*      */     //   #448	-> 215
/*      */     //   #449	-> 223
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   2	91	1	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */     //   4	89	2	$i$f$getCancelRun	I
/*      */     //   0	224	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3; } @EventTarget public final void onTick(@Nullable TickEvent event) { if (StringsKt.equals((String)this.markValue.get(), "jello", true)) this.al = AnimationUtils.changer(this.al, (this.target != null) ? ((Number)this.jelloFadeSpeedValue.get()).floatValue() : -((Number)this.jelloFadeSpeedValue.get()).floatValue(), 0.0F, ((Number)this.colorAlphaValue.get()).floatValue() / 255.0F);  } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   10: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   13: ldc net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3
/*      */     //   15: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   18: dup
/*      */     //   19: ifnonnull -> 33
/*      */     //   22: new kotlin/TypeCastException
/*      */     //   25: dup
/*      */     //   26: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura3'
/*      */     //   29: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   32: athrow
/*      */     //   33: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3
/*      */     //   36: astore_2
/*      */     //   37: aload_0
/*      */     //   38: getfield AirBypass2 : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   41: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   44: checkcast java/lang/Boolean
/*      */     //   47: invokevirtual booleanValue : ()Z
/*      */     //   50: ifeq -> 125
/*      */     //   53: aload_0
/*      */     //   54: getfield rotations : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   57: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   60: checkcast java/lang/String
/*      */     //   63: ldc_w 'HYT'
/*      */     //   66: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   69: ifeq -> 125
/*      */     //   72: aload_0
/*      */     //   73: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   76: dup
/*      */     //   77: ifnonnull -> 83
/*      */     //   80: invokestatic throwNpe : ()V
/*      */     //   83: invokeinterface getPosY : ()D
/*      */     //   88: d2i
/*      */     //   89: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   92: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   95: getfield field_70163_u : D
/*      */     //   98: d2i
/*      */     //   99: if_icmple -> 115
/*      */     //   102: aload_2
/*      */     //   103: getfield hyttestrotations : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   106: ldc_w 'Feet'
/*      */     //   109: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   112: goto -> 125
/*      */     //   115: aload_2
/*      */     //   116: getfield hyttestrotations : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   119: ldc_w 'Head'
/*      */     //   122: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   125: aload_0
/*      */     //   126: getfield AirBypass : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   129: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   132: checkcast java/lang/Boolean
/*      */     //   135: invokevirtual booleanValue : ()Z
/*      */     //   138: ifeq -> 236
/*      */     //   141: aload_0
/*      */     //   142: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   145: dup
/*      */     //   146: ifnonnull -> 152
/*      */     //   149: invokestatic throwNpe : ()V
/*      */     //   152: invokeinterface getPosY : ()D
/*      */     //   157: d2i
/*      */     //   158: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   161: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   164: getfield field_70163_u : D
/*      */     //   167: d2i
/*      */     //   168: if_icmple -> 205
/*      */     //   171: aload_0
/*      */     //   172: getfield rotations : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   175: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   178: checkcast java/lang/String
/*      */     //   181: ldc_w 'Down'
/*      */     //   184: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   187: iconst_1
/*      */     //   188: ixor
/*      */     //   189: ifeq -> 236
/*      */     //   192: aload_0
/*      */     //   193: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   196: ldc_w 'Down'
/*      */     //   199: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   202: goto -> 236
/*      */     //   205: aload_0
/*      */     //   206: getfield rotations : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   209: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   212: checkcast java/lang/String
/*      */     //   215: ldc_w 'Test'
/*      */     //   218: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   221: iconst_1
/*      */     //   222: ixor
/*      */     //   223: ifeq -> 236
/*      */     //   226: aload_0
/*      */     //   227: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   230: ldc_w 'Test'
/*      */     //   233: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   236: aload_0
/*      */     //   237: getfield failchange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   240: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   243: checkcast java/lang/Boolean
/*      */     //   246: invokevirtual booleanValue : ()Z
/*      */     //   249: ifeq -> 478
/*      */     //   252: aload_0
/*      */     //   253: getfield failstatus : Z
/*      */     //   256: ifeq -> 478
/*      */     //   259: aload_0
/*      */     //   260: getfield failcountvalue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   263: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   266: checkcast java/lang/Number
/*      */     //   269: invokevirtual intValue : ()I
/*      */     //   272: aload_0
/*      */     //   273: getfield failcount : I
/*      */     //   276: if_icmpgt -> 478
/*      */     //   279: aload_0
/*      */     //   280: dup
/*      */     //   281: getfield tickcount : I
/*      */     //   284: iconst_1
/*      */     //   285: iadd
/*      */     //   286: putfield tickcount : I
/*      */     //   289: aload_0
/*      */     //   290: getfield hasnoticed : Z
/*      */     //   293: ifne -> 379
/*      */     //   296: aload_0
/*      */     //   297: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   300: aload_0
/*      */     //   301: getfield failrange : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   304: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   307: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   310: aload_0
/*      */     //   311: getfield faildebug : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   314: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   317: checkcast java/lang/Boolean
/*      */     //   320: invokevirtual booleanValue : ()Z
/*      */     //   323: ifeq -> 374
/*      */     //   326: new java/lang/StringBuilder
/*      */     //   329: dup
/*      */     //   330: invokespecial <init> : ()V
/*      */     //   333: aload_0
/*      */     //   334: getfield failcount : I
/*      */     //   337: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   343: ldc_w '单位时间内空刀次数太多 以改至'
/*      */     //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   349: aload_0
/*      */     //   350: getfield failrange : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   353: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   356: checkcast java/lang/Number
/*      */     //   359: invokevirtual floatValue : ()F
/*      */     //   362: invokestatic valueOf : (F)Ljava/lang/String;
/*      */     //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   368: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   371: invokestatic print : (Ljava/lang/String;)V
/*      */     //   374: aload_0
/*      */     //   375: iconst_1
/*      */     //   376: putfield hasnoticed : Z
/*      */     //   379: aload_0
/*      */     //   380: getfield tickcount : I
/*      */     //   383: aload_0
/*      */     //   384: getfield failtick : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   387: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   390: checkcast java/lang/Number
/*      */     //   393: invokevirtual intValue : ()I
/*      */     //   396: if_icmplt -> 478
/*      */     //   399: aload_0
/*      */     //   400: iconst_0
/*      */     //   401: putfield tickcount : I
/*      */     //   404: aload_0
/*      */     //   405: iconst_0
/*      */     //   406: putfield failcount : I
/*      */     //   409: aload_0
/*      */     //   410: iconst_0
/*      */     //   411: putfield failstatus : Z
/*      */     //   414: aload_0
/*      */     //   415: iconst_0
/*      */     //   416: putfield hasnoticed : Z
/*      */     //   419: aload_0
/*      */     //   420: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   423: aload_0
/*      */     //   424: getfield karange : F
/*      */     //   427: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   430: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   433: aload_0
/*      */     //   434: getfield faildebug : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   437: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   440: checkcast java/lang/Boolean
/*      */     //   443: invokevirtual booleanValue : ()Z
/*      */     //   446: ifeq -> 478
/*      */     //   449: new java/lang/StringBuilder
/*      */     //   452: dup
/*      */     //   453: invokespecial <init> : ()V
/*      */     //   456: ldc_w '以回调至'
/*      */     //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   462: aload_0
/*      */     //   463: getfield karange : F
/*      */     //   466: invokestatic valueOf : (F)Ljava/lang/String;
/*      */     //   469: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   472: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   475: invokestatic print : (Ljava/lang/String;)V
/*      */     //   478: aload_0
/*      */     //   479: getfield hyt180fovfixValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   482: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   485: checkcast java/lang/Boolean
/*      */     //   488: invokevirtual booleanValue : ()Z
/*      */     //   491: ifeq -> 576
/*      */     //   494: aload_0
/*      */     //   495: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   498: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   501: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   504: ldc2_w 50.0
/*      */     //   507: dcmpl
/*      */     //   508: ifle -> 545
/*      */     //   511: aload_0
/*      */     //   512: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   515: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   518: checkcast java/lang/String
/*      */     //   521: ldc_w 'Strict'
/*      */     //   524: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   527: iconst_1
/*      */     //   528: ixor
/*      */     //   529: ifeq -> 576
/*      */     //   532: aload_0
/*      */     //   533: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   536: ldc_w 'Strict'
/*      */     //   539: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   542: goto -> 576
/*      */     //   545: aload_0
/*      */     //   546: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   549: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   552: checkcast java/lang/String
/*      */     //   555: ldc_w 'Silent'
/*      */     //   558: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   561: iconst_1
/*      */     //   562: ixor
/*      */     //   563: ifeq -> 576
/*      */     //   566: aload_0
/*      */     //   567: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   570: ldc_w 'Silent'
/*      */     //   573: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   576: aload_0
/*      */     //   577: getfield lightingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   580: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   583: checkcast java/lang/Boolean
/*      */     //   586: invokevirtual booleanValue : ()Z
/*      */     //   589: ifeq -> 1150
/*      */     //   592: aload_0
/*      */     //   593: getfield lightingModeValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   596: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   599: checkcast java/lang/String
/*      */     //   602: astore_3
/*      */     //   603: iconst_0
/*      */     //   604: istore #4
/*      */     //   606: aload_3
/*      */     //   607: dup
/*      */     //   608: ifnonnull -> 622
/*      */     //   611: new kotlin/TypeCastException
/*      */     //   614: dup
/*      */     //   615: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   618: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   621: athrow
/*      */     //   622: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   625: dup
/*      */     //   626: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   629: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   632: astore_3
/*      */     //   633: aload_3
/*      */     //   634: invokevirtual hashCode : ()I
/*      */     //   637: lookupswitch default -> 1150, -1407259064 -> 664, 3079268 -> 677
/*      */     //   664: aload_3
/*      */     //   665: ldc_w 'attack'
/*      */     //   668: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   671: ifeq -> 1150
/*      */     //   674: goto -> 1027
/*      */     //   677: aload_3
/*      */     //   678: ldc_w 'dead'
/*      */     //   681: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   684: ifeq -> 1150
/*      */     //   687: aload_0
/*      */     //   688: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   691: ifnull -> 864
/*      */     //   694: aload_0
/*      */     //   695: aload_0
/*      */     //   696: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   699: ifnonnull -> 709
/*      */     //   702: aload_0
/*      */     //   703: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   706: goto -> 858
/*      */     //   709: aload_0
/*      */     //   710: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   713: dup
/*      */     //   714: ifnonnull -> 720
/*      */     //   717: invokestatic throwNpe : ()V
/*      */     //   720: invokeinterface getHealth : ()F
/*      */     //   725: iconst_0
/*      */     //   726: i2f
/*      */     //   727: fcmpg
/*      */     //   728: ifgt -> 854
/*      */     //   731: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   734: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   739: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   742: dup
/*      */     //   743: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   746: dup
/*      */     //   747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   750: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   753: checkcast net/minecraft/world/World
/*      */     //   756: aload_0
/*      */     //   757: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   760: dup
/*      */     //   761: ifnonnull -> 767
/*      */     //   764: invokestatic throwNpe : ()V
/*      */     //   767: invokeinterface getPosX : ()D
/*      */     //   772: aload_0
/*      */     //   773: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   776: dup
/*      */     //   777: ifnonnull -> 783
/*      */     //   780: invokestatic throwNpe : ()V
/*      */     //   783: invokeinterface getPosY : ()D
/*      */     //   788: aload_0
/*      */     //   789: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   792: dup
/*      */     //   793: ifnonnull -> 799
/*      */     //   796: invokestatic throwNpe : ()V
/*      */     //   799: invokeinterface getPosZ : ()D
/*      */     //   804: iconst_1
/*      */     //   805: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   808: checkcast net/minecraft/entity/Entity
/*      */     //   811: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   814: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   819: aload_0
/*      */     //   820: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   823: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   826: checkcast java/lang/Boolean
/*      */     //   829: invokevirtual booleanValue : ()Z
/*      */     //   832: ifeq -> 854
/*      */     //   835: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   838: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   843: ldc_w 'entity.lightning.impact'
/*      */     //   846: ldc_w 0.5
/*      */     //   849: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   854: aload_0
/*      */     //   855: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   858: putfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   861: goto -> 1150
/*      */     //   864: aload_0
/*      */     //   865: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   868: ifnull -> 1024
/*      */     //   871: aload_0
/*      */     //   872: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   875: dup
/*      */     //   876: ifnonnull -> 882
/*      */     //   879: invokestatic throwNpe : ()V
/*      */     //   882: invokeinterface getHealth : ()F
/*      */     //   887: iconst_0
/*      */     //   888: i2f
/*      */     //   889: fcmpg
/*      */     //   890: ifgt -> 1024
/*      */     //   893: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   896: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   901: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   904: dup
/*      */     //   905: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   908: dup
/*      */     //   909: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   912: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   915: checkcast net/minecraft/world/World
/*      */     //   918: aload_0
/*      */     //   919: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   922: dup
/*      */     //   923: ifnonnull -> 929
/*      */     //   926: invokestatic throwNpe : ()V
/*      */     //   929: invokeinterface getPosX : ()D
/*      */     //   934: aload_0
/*      */     //   935: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   938: dup
/*      */     //   939: ifnonnull -> 945
/*      */     //   942: invokestatic throwNpe : ()V
/*      */     //   945: invokeinterface getPosY : ()D
/*      */     //   950: aload_0
/*      */     //   951: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   954: dup
/*      */     //   955: ifnonnull -> 961
/*      */     //   958: invokestatic throwNpe : ()V
/*      */     //   961: invokeinterface getPosZ : ()D
/*      */     //   966: iconst_1
/*      */     //   967: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   970: checkcast net/minecraft/entity/Entity
/*      */     //   973: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   976: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   981: aload_0
/*      */     //   982: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   985: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   988: checkcast java/lang/Boolean
/*      */     //   991: invokevirtual booleanValue : ()Z
/*      */     //   994: ifeq -> 1016
/*      */     //   997: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1000: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   1005: ldc_w 'entity.lightning.impact'
/*      */     //   1008: ldc_w 0.5
/*      */     //   1011: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   1016: aload_0
/*      */     //   1017: aload_0
/*      */     //   1018: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1021: putfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1024: goto -> 1150
/*      */     //   1027: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1030: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   1035: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   1038: dup
/*      */     //   1039: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   1042: dup
/*      */     //   1043: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1046: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   1049: checkcast net/minecraft/world/World
/*      */     //   1052: aload_0
/*      */     //   1053: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1056: dup
/*      */     //   1057: ifnonnull -> 1063
/*      */     //   1060: invokestatic throwNpe : ()V
/*      */     //   1063: invokeinterface getPosX : ()D
/*      */     //   1068: aload_0
/*      */     //   1069: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1072: dup
/*      */     //   1073: ifnonnull -> 1079
/*      */     //   1076: invokestatic throwNpe : ()V
/*      */     //   1079: invokeinterface getPosY : ()D
/*      */     //   1084: aload_0
/*      */     //   1085: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1088: dup
/*      */     //   1089: ifnonnull -> 1095
/*      */     //   1092: invokestatic throwNpe : ()V
/*      */     //   1095: invokeinterface getPosZ : ()D
/*      */     //   1100: iconst_1
/*      */     //   1101: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   1104: checkcast net/minecraft/entity/Entity
/*      */     //   1107: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   1110: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   1115: aload_0
/*      */     //   1116: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1119: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1122: checkcast java/lang/Boolean
/*      */     //   1125: invokevirtual booleanValue : ()Z
/*      */     //   1128: ifeq -> 1150
/*      */     //   1131: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1134: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   1139: ldc_w 'entity.lightning.impact'
/*      */     //   1142: ldc_w 0.5
/*      */     //   1145: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   1150: aload_0
/*      */     //   1151: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1154: ifnull -> 1196
/*      */     //   1157: aload_0
/*      */     //   1158: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1161: dup
/*      */     //   1162: ifnonnull -> 1168
/*      */     //   1165: invokestatic throwNpe : ()V
/*      */     //   1168: invokeinterface isDead : ()Z
/*      */     //   1173: ifeq -> 1196
/*      */     //   1176: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3.killCounts : I
/*      */     //   1179: iconst_1
/*      */     //   1180: iadd
/*      */     //   1181: putstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3.killCounts : I
/*      */     //   1184: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3.killCounts : I
/*      */     //   1187: pop
/*      */     //   1188: aload_0
/*      */     //   1189: aconst_null
/*      */     //   1190: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1193: putfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1196: aload_0
/*      */     //   1197: astore_3
/*      */     //   1198: iconst_0
/*      */     //   1199: istore #4
/*      */     //   1201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1204: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1209: dup
/*      */     //   1210: ifnonnull -> 1216
/*      */     //   1213: invokestatic throwNpe : ()V
/*      */     //   1216: invokeinterface isSpectator : ()Z
/*      */     //   1221: ifne -> 1285
/*      */     //   1224: aload_3
/*      */     //   1225: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1228: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1233: dup
/*      */     //   1234: ifnonnull -> 1240
/*      */     //   1237: invokestatic throwNpe : ()V
/*      */     //   1240: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1243: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   1246: ifeq -> 1285
/*      */     //   1249: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1252: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1255: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   1258: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1261: invokevirtual getState : ()Z
/*      */     //   1264: ifne -> 1285
/*      */     //   1267: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1270: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1273: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   1276: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1279: invokevirtual getState : ()Z
/*      */     //   1282: ifeq -> 1289
/*      */     //   1285: iconst_1
/*      */     //   1286: goto -> 1290
/*      */     //   1289: iconst_0
/*      */     //   1290: ifeq -> 1319
/*      */     //   1293: aload_0
/*      */     //   1294: aconst_null
/*      */     //   1295: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1298: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1301: aload_0
/*      */     //   1302: aconst_null
/*      */     //   1303: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1306: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1309: aload_0
/*      */     //   1310: iconst_0
/*      */     //   1311: putfield hitable : Z
/*      */     //   1314: aload_0
/*      */     //   1315: invokespecial stopBlocking : ()V
/*      */     //   1318: return
/*      */     //   1319: aload_0
/*      */     //   1320: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1323: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1326: checkcast java/lang/Boolean
/*      */     //   1329: invokevirtual booleanValue : ()Z
/*      */     //   1332: ifeq -> 1427
/*      */     //   1335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1338: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1341: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1346: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1351: ifne -> 1379
/*      */     //   1354: invokestatic currentTimeMillis : ()J
/*      */     //   1357: aload_0
/*      */     //   1358: getfield containerOpen : J
/*      */     //   1361: lsub
/*      */     //   1362: aload_0
/*      */     //   1363: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1366: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1369: checkcast java/lang/Number
/*      */     //   1372: invokevirtual longValue : ()J
/*      */     //   1375: lcmp
/*      */     //   1376: ifge -> 1427
/*      */     //   1379: aload_0
/*      */     //   1380: aconst_null
/*      */     //   1381: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1384: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1387: aload_0
/*      */     //   1388: aconst_null
/*      */     //   1389: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1392: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1395: aload_0
/*      */     //   1396: iconst_0
/*      */     //   1397: putfield hitable : Z
/*      */     //   1400: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1403: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1406: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1411: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1416: ifeq -> 1426
/*      */     //   1419: aload_0
/*      */     //   1420: invokestatic currentTimeMillis : ()J
/*      */     //   1423: putfield containerOpen : J
/*      */     //   1426: return
/*      */     //   1427: aload_0
/*      */     //   1428: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1431: ifnull -> 1505
/*      */     //   1434: aload_0
/*      */     //   1435: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1438: ifnull -> 1505
/*      */     //   1441: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1444: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1449: dup
/*      */     //   1450: ifnonnull -> 1456
/*      */     //   1453: invokestatic throwNpe : ()V
/*      */     //   1456: fconst_0
/*      */     //   1457: invokeinterface getCooledAttackStrength : (F)F
/*      */     //   1462: aload_0
/*      */     //   1463: getfield cooldownValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1466: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1469: checkcast java/lang/Number
/*      */     //   1472: invokevirtual floatValue : ()F
/*      */     //   1475: fcmpl
/*      */     //   1476: iflt -> 1505
/*      */     //   1479: aload_0
/*      */     //   1480: getfield clicks : I
/*      */     //   1483: ifle -> 1505
/*      */     //   1486: aload_0
/*      */     //   1487: invokespecial runAttack : ()V
/*      */     //   1490: aload_0
/*      */     //   1491: dup
/*      */     //   1492: getfield clicks : I
/*      */     //   1495: dup
/*      */     //   1496: istore_3
/*      */     //   1497: iconst_m1
/*      */     //   1498: iadd
/*      */     //   1499: putfield clicks : I
/*      */     //   1502: goto -> 1479
/*      */     //   1505: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #466	-> 7
/*      */     //   #467	-> 37
/*      */     //   #468	-> 53
/*      */     //   #469	-> 72
/*      */     //   #470	-> 102
/*      */     //   #472	-> 115
/*      */     //   #473	-> 125
/*      */     //   #476	-> 125
/*      */     //   #477	-> 141
/*      */     //   #478	-> 171
/*      */     //   #480	-> 205
/*      */     //   #481	-> 236
/*      */     //   #483	-> 236
/*      */     //   #484	-> 252
/*      */     //   #485	-> 259
/*      */     //   #486	-> 279
/*      */     //   #487	-> 289
/*      */     //   #488	-> 296
/*      */     //   #489	-> 310
/*      */     //   #490	-> 326
/*      */     //   #491	-> 326
/*      */     //   #490	-> 371
/*      */     //   #494	-> 374
/*      */     //   #496	-> 379
/*      */     //   #497	-> 399
/*      */     //   #498	-> 404
/*      */     //   #499	-> 409
/*      */     //   #500	-> 414
/*      */     //   #501	-> 419
/*      */     //   #502	-> 433
/*      */     //   #503	-> 449
/*      */     //   #510	-> 478
/*      */     //   #511	-> 494
/*      */     //   #512	-> 511
/*      */     //   #514	-> 545
/*      */     //   #515	-> 576
/*      */     //   #518	-> 576
/*      */     //   #519	-> 592
/*      */     //   #542	-> 664
/*      */     //   #520	-> 677
/*      */     //   #521	-> 687
/*      */     //   #522	-> 694
/*      */     //   #523	-> 702
/*      */     //   #525	-> 709
/*      */     //   #526	-> 731
/*      */     //   #527	-> 756
/*      */     //   #526	-> 805
/*      */     //   #528	-> 819
/*      */     //   #530	-> 854
/*      */     //   #522	-> 858
/*      */     //   #533	-> 864
/*      */     //   #534	-> 893
/*      */     //   #535	-> 918
/*      */     //   #534	-> 967
/*      */     //   #536	-> 981
/*      */     //   #537	-> 1016
/*      */     //   #539	-> 1024
/*      */     //   #543	-> 1027
/*      */     //   #544	-> 1052
/*      */     //   #543	-> 1101
/*      */     //   #545	-> 1115
/*      */     //   #547	-> 1150
/*      */     //   #550	-> 1150
/*      */     //   #551	-> 1176
/*      */     //   #552	-> 1188
/*      */     //   #555	-> 1196
/*      */     //   #1588	-> 1201
/*      */     //   #1589	-> 1201
/*      */     //   #1588	-> 1225
/*      */     //   #1589	-> 1249
/*      */     //   #556	-> 1293
/*      */     //   #557	-> 1301
/*      */     //   #558	-> 1309
/*      */     //   #559	-> 1314
/*      */     //   #560	-> 1318
/*      */     //   #562	-> 1319
/*      */     //   #563	-> 1319
/*      */     //   #562	-> 1319
/*      */     //   #563	-> 1354
/*      */     //   #564	-> 1379
/*      */     //   #565	-> 1387
/*      */     //   #566	-> 1395
/*      */     //   #567	-> 1400
/*      */     //   #568	-> 1426
/*      */     //   #572	-> 1427
/*      */     //   #573	-> 1479
/*      */     //   #574	-> 1486
/*      */     //   #575	-> 1490
/*      */     //   #573	-> 1502
/*      */     //   #578	-> 1505
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   1198	92	3	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */     //   1201	89	4	$i$f$getCancelRun	I
/*      */     //   37	1469	2	killaura3	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */     //   0	1506	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */     //   0	1506	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent; } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$1.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$1;
/*      */     //   10: astore_2
/*      */     //   11: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$2.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$2;
/*      */     //   14: astore_3
/*      */     //   15: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$3.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$3;
/*      */     //   18: astore #4
/*      */     //   20: new net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$4
/*      */     //   23: dup
/*      */     //   24: aload_0
/*      */     //   25: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;)V
/*      */     //   28: astore #5
/*      */     //   30: aload_0
/*      */     //   31: getfield circletargetValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   34: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   37: checkcast java/lang/Boolean
/*      */     //   40: invokevirtual booleanValue : ()Z
/*      */     //   43: ifeq -> 696
/*      */     //   46: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   49: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   52: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   55: ifnull -> 696
/*      */     //   58: invokestatic glPushMatrix : ()V
/*      */     //   61: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   64: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   67: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   70: dup
/*      */     //   71: ifnonnull -> 77
/*      */     //   74: invokestatic throwNpe : ()V
/*      */     //   77: invokeinterface getLastTickPosX : ()D
/*      */     //   82: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   85: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   88: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   91: dup
/*      */     //   92: ifnonnull -> 98
/*      */     //   95: invokestatic throwNpe : ()V
/*      */     //   98: invokeinterface getPosX : ()D
/*      */     //   103: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   106: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   109: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   112: dup
/*      */     //   113: ifnonnull -> 119
/*      */     //   116: invokestatic throwNpe : ()V
/*      */     //   119: invokeinterface getLastTickPosX : ()D
/*      */     //   124: dsub
/*      */     //   125: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   128: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   133: invokeinterface getRenderPartialTicks : ()F
/*      */     //   138: f2d
/*      */     //   139: dmul
/*      */     //   140: dadd
/*      */     //   141: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   144: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   149: invokeinterface getRenderPosX : ()D
/*      */     //   154: dsub
/*      */     //   155: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   158: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   161: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   164: dup
/*      */     //   165: ifnonnull -> 171
/*      */     //   168: invokestatic throwNpe : ()V
/*      */     //   171: invokeinterface getLastTickPosY : ()D
/*      */     //   176: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   179: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   182: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   185: dup
/*      */     //   186: ifnonnull -> 192
/*      */     //   189: invokestatic throwNpe : ()V
/*      */     //   192: invokeinterface getPosY : ()D
/*      */     //   197: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   200: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   203: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   206: dup
/*      */     //   207: ifnonnull -> 213
/*      */     //   210: invokestatic throwNpe : ()V
/*      */     //   213: invokeinterface getLastTickPosY : ()D
/*      */     //   218: dsub
/*      */     //   219: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   222: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   227: invokeinterface getRenderPartialTicks : ()F
/*      */     //   232: f2d
/*      */     //   233: dmul
/*      */     //   234: dadd
/*      */     //   235: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   238: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   243: invokeinterface getRenderPosY : ()D
/*      */     //   248: dsub
/*      */     //   249: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   252: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   255: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   258: dup
/*      */     //   259: ifnonnull -> 265
/*      */     //   262: invokestatic throwNpe : ()V
/*      */     //   265: invokeinterface getLastTickPosZ : ()D
/*      */     //   270: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   273: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   276: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   279: dup
/*      */     //   280: ifnonnull -> 286
/*      */     //   283: invokestatic throwNpe : ()V
/*      */     //   286: invokeinterface getPosZ : ()D
/*      */     //   291: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   294: invokevirtual getCombatManager : ()Lnet/ccbluex/liquidbounce/management/CombatManager;
/*      */     //   297: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   300: dup
/*      */     //   301: ifnonnull -> 307
/*      */     //   304: invokestatic throwNpe : ()V
/*      */     //   307: invokeinterface getLastTickPosZ : ()D
/*      */     //   312: dsub
/*      */     //   313: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   316: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   321: invokeinterface getRenderPartialTicks : ()F
/*      */     //   326: f2d
/*      */     //   327: dmul
/*      */     //   328: dadd
/*      */     //   329: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   332: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   337: invokeinterface getRenderPosZ : ()D
/*      */     //   342: dsub
/*      */     //   343: invokestatic glTranslated : (DDD)V
/*      */     //   346: sipush #3042
/*      */     //   349: invokestatic glEnable : (I)V
/*      */     //   352: sipush #2848
/*      */     //   355: invokestatic glEnable : (I)V
/*      */     //   358: sipush #3553
/*      */     //   361: invokestatic glDisable : (I)V
/*      */     //   364: sipush #2929
/*      */     //   367: invokestatic glDisable : (I)V
/*      */     //   370: sipush #770
/*      */     //   373: sipush #771
/*      */     //   376: invokestatic glBlendFunc : (II)V
/*      */     //   379: fconst_1
/*      */     //   380: invokestatic glLineWidth : (F)V
/*      */     //   383: aload_0
/*      */     //   384: getfield circleRed : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   387: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   390: checkcast java/lang/Number
/*      */     //   393: invokevirtual intValue : ()I
/*      */     //   396: i2f
/*      */     //   397: ldc_w 255.0
/*      */     //   400: fdiv
/*      */     //   401: aload_0
/*      */     //   402: getfield circleGreen : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   405: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   408: checkcast java/lang/Number
/*      */     //   411: invokevirtual intValue : ()I
/*      */     //   414: i2f
/*      */     //   415: ldc_w 255.0
/*      */     //   418: fdiv
/*      */     //   419: aload_0
/*      */     //   420: getfield circleBlue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   423: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   426: checkcast java/lang/Number
/*      */     //   429: invokevirtual intValue : ()I
/*      */     //   432: i2f
/*      */     //   433: ldc_w 255.0
/*      */     //   436: fdiv
/*      */     //   437: aload_0
/*      */     //   438: getfield circleAlpha : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   441: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   444: checkcast java/lang/Number
/*      */     //   447: invokevirtual intValue : ()I
/*      */     //   450: i2f
/*      */     //   451: ldc_w 255.0
/*      */     //   454: fdiv
/*      */     //   455: invokestatic glColor4f : (FFFF)V
/*      */     //   458: ldc_w 90.0
/*      */     //   461: fconst_1
/*      */     //   462: fconst_0
/*      */     //   463: fconst_0
/*      */     //   464: invokestatic glRotatef : (FFFF)V
/*      */     //   467: iconst_3
/*      */     //   468: invokestatic glBegin : (I)V
/*      */     //   471: iconst_0
/*      */     //   472: istore #9
/*      */     //   474: new kotlin/ranges/IntRange
/*      */     //   477: dup
/*      */     //   478: iload #9
/*      */     //   480: sipush #360
/*      */     //   483: invokespecial <init> : (II)V
/*      */     //   486: checkcast kotlin/ranges/IntProgression
/*      */     //   489: bipush #61
/*      */     //   491: aload_0
/*      */     //   492: getfield circleAccuracy : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   495: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   498: checkcast java/lang/Number
/*      */     //   501: invokevirtual intValue : ()I
/*      */     //   504: isub
/*      */     //   505: invokestatic step : (Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;
/*      */     //   508: dup
/*      */     //   509: dup
/*      */     //   510: invokevirtual getFirst : ()I
/*      */     //   513: istore #6
/*      */     //   515: invokevirtual getLast : ()I
/*      */     //   518: istore #7
/*      */     //   520: invokevirtual getStep : ()I
/*      */     //   523: istore #8
/*      */     //   525: iload #6
/*      */     //   527: iload #7
/*      */     //   529: iload #8
/*      */     //   531: iflt -> 540
/*      */     //   534: if_icmpgt -> 621
/*      */     //   537: goto -> 543
/*      */     //   540: if_icmplt -> 621
/*      */     //   543: iload #6
/*      */     //   545: i2d
/*      */     //   546: ldc2_w 3.141592653589793
/*      */     //   549: dmul
/*      */     //   550: ldc2_w 180.0
/*      */     //   553: ddiv
/*      */     //   554: dstore #9
/*      */     //   556: iconst_0
/*      */     //   557: istore #11
/*      */     //   559: dload #9
/*      */     //   561: invokestatic cos : (D)D
/*      */     //   564: d2f
/*      */     //   565: iconst_2
/*      */     //   566: i2f
/*      */     //   567: fmul
/*      */     //   568: iload #6
/*      */     //   570: i2d
/*      */     //   571: ldc2_w 3.141592653589793
/*      */     //   574: dmul
/*      */     //   575: ldc2_w 180.0
/*      */     //   578: ddiv
/*      */     //   579: dstore #9
/*      */     //   581: fstore #34
/*      */     //   583: iconst_0
/*      */     //   584: istore #11
/*      */     //   586: dload #9
/*      */     //   588: invokestatic sin : (D)D
/*      */     //   591: dstore #35
/*      */     //   593: fload #34
/*      */     //   595: dload #35
/*      */     //   597: d2f
/*      */     //   598: iconst_2
/*      */     //   599: i2f
/*      */     //   600: fmul
/*      */     //   601: invokestatic glVertex2f : (FF)V
/*      */     //   604: iload #6
/*      */     //   606: iload #7
/*      */     //   608: if_icmpeq -> 621
/*      */     //   611: iload #6
/*      */     //   613: iload #8
/*      */     //   615: iadd
/*      */     //   616: istore #6
/*      */     //   618: goto -> 543
/*      */     //   621: ldc2_w 6.283185307179586
/*      */     //   624: dstore #6
/*      */     //   626: iconst_0
/*      */     //   627: istore #8
/*      */     //   629: dload #6
/*      */     //   631: invokestatic cos : (D)D
/*      */     //   634: d2f
/*      */     //   635: iconst_2
/*      */     //   636: i2f
/*      */     //   637: fmul
/*      */     //   638: ldc2_w 6.283185307179586
/*      */     //   641: dstore #6
/*      */     //   643: fstore #34
/*      */     //   645: iconst_0
/*      */     //   646: istore #8
/*      */     //   648: dload #6
/*      */     //   650: invokestatic sin : (D)D
/*      */     //   653: dstore #35
/*      */     //   655: fload #34
/*      */     //   657: dload #35
/*      */     //   659: d2f
/*      */     //   660: iconst_2
/*      */     //   661: i2f
/*      */     //   662: fmul
/*      */     //   663: invokestatic glVertex2f : (FF)V
/*      */     //   666: invokestatic glEnd : ()V
/*      */     //   669: sipush #3042
/*      */     //   672: invokestatic glDisable : (I)V
/*      */     //   675: sipush #3553
/*      */     //   678: invokestatic glEnable : (I)V
/*      */     //   681: sipush #2929
/*      */     //   684: invokestatic glEnable : (I)V
/*      */     //   687: sipush #2848
/*      */     //   690: invokestatic glDisable : (I)V
/*      */     //   693: invokestatic glPopMatrix : ()V
/*      */     //   696: aload_0
/*      */     //   697: getfield circleValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   700: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   703: checkcast java/lang/Boolean
/*      */     //   706: invokevirtual booleanValue : ()Z
/*      */     //   709: ifeq -> 1385
/*      */     //   712: invokestatic glPushMatrix : ()V
/*      */     //   715: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   718: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   723: dup
/*      */     //   724: ifnonnull -> 730
/*      */     //   727: invokestatic throwNpe : ()V
/*      */     //   730: invokeinterface getLastTickPosX : ()D
/*      */     //   735: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   738: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   743: dup
/*      */     //   744: ifnonnull -> 750
/*      */     //   747: invokestatic throwNpe : ()V
/*      */     //   750: invokeinterface getPosX : ()D
/*      */     //   755: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   758: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   763: dup
/*      */     //   764: ifnonnull -> 770
/*      */     //   767: invokestatic throwNpe : ()V
/*      */     //   770: invokeinterface getLastTickPosX : ()D
/*      */     //   775: dsub
/*      */     //   776: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   779: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   784: invokeinterface getRenderPartialTicks : ()F
/*      */     //   789: f2d
/*      */     //   790: dmul
/*      */     //   791: dadd
/*      */     //   792: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   795: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   800: invokeinterface getRenderPosX : ()D
/*      */     //   805: dsub
/*      */     //   806: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   809: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   814: dup
/*      */     //   815: ifnonnull -> 821
/*      */     //   818: invokestatic throwNpe : ()V
/*      */     //   821: invokeinterface getLastTickPosY : ()D
/*      */     //   826: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   829: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   834: dup
/*      */     //   835: ifnonnull -> 841
/*      */     //   838: invokestatic throwNpe : ()V
/*      */     //   841: invokeinterface getPosY : ()D
/*      */     //   846: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   849: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   854: dup
/*      */     //   855: ifnonnull -> 861
/*      */     //   858: invokestatic throwNpe : ()V
/*      */     //   861: invokeinterface getLastTickPosY : ()D
/*      */     //   866: dsub
/*      */     //   867: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   870: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   875: invokeinterface getRenderPartialTicks : ()F
/*      */     //   880: f2d
/*      */     //   881: dmul
/*      */     //   882: dadd
/*      */     //   883: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   886: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   891: invokeinterface getRenderPosY : ()D
/*      */     //   896: dsub
/*      */     //   897: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   900: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   905: dup
/*      */     //   906: ifnonnull -> 912
/*      */     //   909: invokestatic throwNpe : ()V
/*      */     //   912: invokeinterface getLastTickPosZ : ()D
/*      */     //   917: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   920: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   925: dup
/*      */     //   926: ifnonnull -> 932
/*      */     //   929: invokestatic throwNpe : ()V
/*      */     //   932: invokeinterface getPosZ : ()D
/*      */     //   937: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   940: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   945: dup
/*      */     //   946: ifnonnull -> 952
/*      */     //   949: invokestatic throwNpe : ()V
/*      */     //   952: invokeinterface getLastTickPosZ : ()D
/*      */     //   957: dsub
/*      */     //   958: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   961: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   966: invokeinterface getRenderPartialTicks : ()F
/*      */     //   971: f2d
/*      */     //   972: dmul
/*      */     //   973: dadd
/*      */     //   974: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   977: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   982: invokeinterface getRenderPosZ : ()D
/*      */     //   987: dsub
/*      */     //   988: invokestatic glTranslated : (DDD)V
/*      */     //   991: sipush #3042
/*      */     //   994: invokestatic glEnable : (I)V
/*      */     //   997: sipush #2848
/*      */     //   1000: invokestatic glEnable : (I)V
/*      */     //   1003: sipush #3553
/*      */     //   1006: invokestatic glDisable : (I)V
/*      */     //   1009: sipush #2929
/*      */     //   1012: invokestatic glDisable : (I)V
/*      */     //   1015: sipush #770
/*      */     //   1018: sipush #771
/*      */     //   1021: invokestatic glBlendFunc : (II)V
/*      */     //   1024: fconst_1
/*      */     //   1025: invokestatic glLineWidth : (F)V
/*      */     //   1028: aload_0
/*      */     //   1029: getfield circleRed : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1032: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1035: checkcast java/lang/Number
/*      */     //   1038: invokevirtual intValue : ()I
/*      */     //   1041: i2f
/*      */     //   1042: ldc_w 255.0
/*      */     //   1045: fdiv
/*      */     //   1046: aload_0
/*      */     //   1047: getfield circleGreen : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1050: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1053: checkcast java/lang/Number
/*      */     //   1056: invokevirtual intValue : ()I
/*      */     //   1059: i2f
/*      */     //   1060: ldc_w 255.0
/*      */     //   1063: fdiv
/*      */     //   1064: aload_0
/*      */     //   1065: getfield circleBlue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1068: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1071: checkcast java/lang/Number
/*      */     //   1074: invokevirtual intValue : ()I
/*      */     //   1077: i2f
/*      */     //   1078: ldc_w 255.0
/*      */     //   1081: fdiv
/*      */     //   1082: aload_0
/*      */     //   1083: getfield circleAlpha : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1086: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1089: checkcast java/lang/Number
/*      */     //   1092: invokevirtual intValue : ()I
/*      */     //   1095: i2f
/*      */     //   1096: ldc_w 255.0
/*      */     //   1099: fdiv
/*      */     //   1100: invokestatic glColor4f : (FFFF)V
/*      */     //   1103: ldc_w 90.0
/*      */     //   1106: fconst_1
/*      */     //   1107: fconst_0
/*      */     //   1108: fconst_0
/*      */     //   1109: invokestatic glRotatef : (FFFF)V
/*      */     //   1112: iconst_3
/*      */     //   1113: invokestatic glBegin : (I)V
/*      */     //   1116: iconst_0
/*      */     //   1117: istore #9
/*      */     //   1119: new kotlin/ranges/IntRange
/*      */     //   1122: dup
/*      */     //   1123: iload #9
/*      */     //   1125: sipush #360
/*      */     //   1128: invokespecial <init> : (II)V
/*      */     //   1131: checkcast kotlin/ranges/IntProgression
/*      */     //   1134: bipush #61
/*      */     //   1136: aload_0
/*      */     //   1137: getfield circleAccuracy : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   1140: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1143: checkcast java/lang/Number
/*      */     //   1146: invokevirtual intValue : ()I
/*      */     //   1149: isub
/*      */     //   1150: invokestatic step : (Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;
/*      */     //   1153: dup
/*      */     //   1154: dup
/*      */     //   1155: invokevirtual getFirst : ()I
/*      */     //   1158: istore #6
/*      */     //   1160: invokevirtual getLast : ()I
/*      */     //   1163: istore #7
/*      */     //   1165: invokevirtual getStep : ()I
/*      */     //   1168: istore #8
/*      */     //   1170: iload #6
/*      */     //   1172: iload #7
/*      */     //   1174: iload #8
/*      */     //   1176: iflt -> 1185
/*      */     //   1179: if_icmpgt -> 1288
/*      */     //   1182: goto -> 1188
/*      */     //   1185: if_icmplt -> 1288
/*      */     //   1188: iload #6
/*      */     //   1190: i2d
/*      */     //   1191: ldc2_w 3.141592653589793
/*      */     //   1194: dmul
/*      */     //   1195: ldc2_w 180.0
/*      */     //   1198: ddiv
/*      */     //   1199: dstore #9
/*      */     //   1201: iconst_0
/*      */     //   1202: istore #11
/*      */     //   1204: dload #9
/*      */     //   1206: invokestatic cos : (D)D
/*      */     //   1209: d2f
/*      */     //   1210: aload_0
/*      */     //   1211: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1214: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1217: checkcast java/lang/Number
/*      */     //   1220: invokevirtual floatValue : ()F
/*      */     //   1223: fmul
/*      */     //   1224: iload #6
/*      */     //   1226: i2d
/*      */     //   1227: ldc2_w 3.141592653589793
/*      */     //   1230: dmul
/*      */     //   1231: ldc2_w 180.0
/*      */     //   1234: ddiv
/*      */     //   1235: dstore #9
/*      */     //   1237: fstore #34
/*      */     //   1239: iconst_0
/*      */     //   1240: istore #11
/*      */     //   1242: dload #9
/*      */     //   1244: invokestatic sin : (D)D
/*      */     //   1247: dstore #35
/*      */     //   1249: fload #34
/*      */     //   1251: dload #35
/*      */     //   1253: d2f
/*      */     //   1254: aload_0
/*      */     //   1255: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1258: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1261: checkcast java/lang/Number
/*      */     //   1264: invokevirtual floatValue : ()F
/*      */     //   1267: fmul
/*      */     //   1268: invokestatic glVertex2f : (FF)V
/*      */     //   1271: iload #6
/*      */     //   1273: iload #7
/*      */     //   1275: if_icmpeq -> 1288
/*      */     //   1278: iload #6
/*      */     //   1280: iload #8
/*      */     //   1282: iadd
/*      */     //   1283: istore #6
/*      */     //   1285: goto -> 1188
/*      */     //   1288: ldc2_w 6.283185307179586
/*      */     //   1291: dstore #6
/*      */     //   1293: iconst_0
/*      */     //   1294: istore #8
/*      */     //   1296: dload #6
/*      */     //   1298: invokestatic cos : (D)D
/*      */     //   1301: d2f
/*      */     //   1302: aload_0
/*      */     //   1303: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1306: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1309: checkcast java/lang/Number
/*      */     //   1312: invokevirtual floatValue : ()F
/*      */     //   1315: fmul
/*      */     //   1316: ldc2_w 6.283185307179586
/*      */     //   1319: dstore #6
/*      */     //   1321: fstore #34
/*      */     //   1323: iconst_0
/*      */     //   1324: istore #8
/*      */     //   1326: dload #6
/*      */     //   1328: invokestatic sin : (D)D
/*      */     //   1331: dstore #35
/*      */     //   1333: fload #34
/*      */     //   1335: dload #35
/*      */     //   1337: d2f
/*      */     //   1338: aload_0
/*      */     //   1339: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1342: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1345: checkcast java/lang/Number
/*      */     //   1348: invokevirtual floatValue : ()F
/*      */     //   1351: fmul
/*      */     //   1352: invokestatic glVertex2f : (FF)V
/*      */     //   1355: invokestatic glEnd : ()V
/*      */     //   1358: sipush #3042
/*      */     //   1361: invokestatic glDisable : (I)V
/*      */     //   1364: sipush #3553
/*      */     //   1367: invokestatic glEnable : (I)V
/*      */     //   1370: sipush #2929
/*      */     //   1373: invokestatic glEnable : (I)V
/*      */     //   1376: sipush #2848
/*      */     //   1379: invokestatic glDisable : (I)V
/*      */     //   1382: invokestatic glPopMatrix : ()V
/*      */     //   1385: aload_0
/*      */     //   1386: astore #6
/*      */     //   1388: iconst_0
/*      */     //   1389: istore #7
/*      */     //   1391: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1394: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1399: dup
/*      */     //   1400: ifnonnull -> 1406
/*      */     //   1403: invokestatic throwNpe : ()V
/*      */     //   1406: invokeinterface isSpectator : ()Z
/*      */     //   1411: ifne -> 1476
/*      */     //   1414: aload #6
/*      */     //   1416: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1419: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1424: dup
/*      */     //   1425: ifnonnull -> 1431
/*      */     //   1428: invokestatic throwNpe : ()V
/*      */     //   1431: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1434: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   1437: ifeq -> 1476
/*      */     //   1440: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1443: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1446: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   1449: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1452: invokevirtual getState : ()Z
/*      */     //   1455: ifne -> 1476
/*      */     //   1458: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   1461: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   1464: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   1467: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   1470: invokevirtual getState : ()Z
/*      */     //   1473: ifeq -> 1480
/*      */     //   1476: iconst_1
/*      */     //   1477: goto -> 1481
/*      */     //   1480: iconst_0
/*      */     //   1481: ifeq -> 1510
/*      */     //   1484: aload_0
/*      */     //   1485: aconst_null
/*      */     //   1486: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1489: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1492: aload_0
/*      */     //   1493: aconst_null
/*      */     //   1494: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1497: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1500: aload_0
/*      */     //   1501: iconst_0
/*      */     //   1502: putfield hitable : Z
/*      */     //   1505: aload_0
/*      */     //   1506: invokespecial stopBlocking : ()V
/*      */     //   1509: return
/*      */     //   1510: aload_0
/*      */     //   1511: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1514: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1517: checkcast java/lang/Boolean
/*      */     //   1520: invokevirtual booleanValue : ()Z
/*      */     //   1523: ifeq -> 1618
/*      */     //   1526: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1529: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1532: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1537: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1542: ifne -> 1570
/*      */     //   1545: invokestatic currentTimeMillis : ()J
/*      */     //   1548: aload_0
/*      */     //   1549: getfield containerOpen : J
/*      */     //   1552: lsub
/*      */     //   1553: aload_0
/*      */     //   1554: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1557: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1560: checkcast java/lang/Number
/*      */     //   1563: invokevirtual longValue : ()J
/*      */     //   1566: lcmp
/*      */     //   1567: ifge -> 1618
/*      */     //   1570: aload_0
/*      */     //   1571: aconst_null
/*      */     //   1572: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1575: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1578: aload_0
/*      */     //   1579: aconst_null
/*      */     //   1580: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1583: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1586: aload_0
/*      */     //   1587: iconst_0
/*      */     //   1588: putfield hitable : Z
/*      */     //   1591: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1594: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1597: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1602: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1607: ifeq -> 1617
/*      */     //   1610: aload_0
/*      */     //   1611: invokestatic currentTimeMillis : ()J
/*      */     //   1614: putfield containerOpen : J
/*      */     //   1617: return
/*      */     //   1618: aload_0
/*      */     //   1619: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1622: dup
/*      */     //   1623: ifnull -> 1629
/*      */     //   1626: goto -> 1631
/*      */     //   1629: pop
/*      */     //   1630: return
/*      */     //   1631: pop
/*      */     //   1632: aload_0
/*      */     //   1633: getfield markValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1636: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1639: checkcast java/lang/String
/*      */     //   1642: astore #6
/*      */     //   1644: iconst_0
/*      */     //   1645: istore #7
/*      */     //   1647: aload #6
/*      */     //   1649: dup
/*      */     //   1650: ifnonnull -> 1664
/*      */     //   1653: new kotlin/TypeCastException
/*      */     //   1656: dup
/*      */     //   1657: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   1660: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   1663: athrow
/*      */     //   1664: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   1667: dup
/*      */     //   1668: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   1671: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   1674: astore #6
/*      */     //   1676: aload #6
/*      */     //   1678: invokevirtual hashCode : ()I
/*      */     //   1681: lookupswitch default -> 4196, -1102567108 -> 1790, 101234 -> 1776, 112785 -> 1748, 3443503 -> 1832, 3530364 -> 1804, 93832333 -> 1818, 101009364 -> 1762
/*      */     //   1748: aload #6
/*      */     //   1750: ldc_w 'red'
/*      */     //   1753: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1756: ifeq -> 4196
/*      */     //   1759: goto -> 2097
/*      */     //   1762: aload #6
/*      */     //   1764: ldc_w 'jello'
/*      */     //   1767: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1770: ifeq -> 4196
/*      */     //   1773: goto -> 3375
/*      */     //   1776: aload #6
/*      */     //   1778: ldc_w 'fdp'
/*      */     //   1781: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1784: ifeq -> 4196
/*      */     //   1787: goto -> 2670
/*      */     //   1790: aload #6
/*      */     //   1792: ldc_w 'liquid'
/*      */     //   1795: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1798: ifeq -> 4196
/*      */     //   1801: goto -> 1846
/*      */     //   1804: aload #6
/*      */     //   1806: ldc_w 'sims'
/*      */     //   1809: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1812: ifeq -> 4196
/*      */     //   1815: goto -> 2176
/*      */     //   1818: aload #6
/*      */     //   1820: ldc_w 'block'
/*      */     //   1823: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1826: ifeq -> 4196
/*      */     //   1829: goto -> 1980
/*      */     //   1832: aload #6
/*      */     //   1834: ldc_w 'plat'
/*      */     //   1837: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1840: ifeq -> 4196
/*      */     //   1843: goto -> 1920
/*      */     //   1846: aload_0
/*      */     //   1847: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1850: dup
/*      */     //   1851: ifnonnull -> 1857
/*      */     //   1854: invokestatic throwNpe : ()V
/*      */     //   1857: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1860: aload_0
/*      */     //   1861: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1864: dup
/*      */     //   1865: ifnonnull -> 1871
/*      */     //   1868: invokestatic throwNpe : ()V
/*      */     //   1871: invokeinterface getHurtTime : ()I
/*      */     //   1876: ifgt -> 1899
/*      */     //   1879: new java/awt/Color
/*      */     //   1882: dup
/*      */     //   1883: bipush #37
/*      */     //   1885: bipush #126
/*      */     //   1887: sipush #255
/*      */     //   1890: sipush #170
/*      */     //   1893: invokespecial <init> : (IIII)V
/*      */     //   1896: goto -> 1914
/*      */     //   1899: new java/awt/Color
/*      */     //   1902: dup
/*      */     //   1903: sipush #255
/*      */     //   1906: iconst_0
/*      */     //   1907: iconst_0
/*      */     //   1908: sipush #170
/*      */     //   1911: invokespecial <init> : (IIII)V
/*      */     //   1914: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1917: goto -> 4196
/*      */     //   1920: aload_0
/*      */     //   1921: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1924: dup
/*      */     //   1925: ifnonnull -> 1931
/*      */     //   1928: invokestatic throwNpe : ()V
/*      */     //   1931: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1934: aload_0
/*      */     //   1935: getfield hitable : Z
/*      */     //   1938: ifeq -> 1960
/*      */     //   1941: new java/awt/Color
/*      */     //   1944: dup
/*      */     //   1945: bipush #37
/*      */     //   1947: bipush #126
/*      */     //   1949: sipush #255
/*      */     //   1952: bipush #70
/*      */     //   1954: invokespecial <init> : (IIII)V
/*      */     //   1957: goto -> 1974
/*      */     //   1960: new java/awt/Color
/*      */     //   1963: dup
/*      */     //   1964: sipush #255
/*      */     //   1967: iconst_0
/*      */     //   1968: iconst_0
/*      */     //   1969: bipush #70
/*      */     //   1971: invokespecial <init> : (IIII)V
/*      */     //   1974: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1977: goto -> 4196
/*      */     //   1980: aload_0
/*      */     //   1981: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1984: dup
/*      */     //   1985: ifnonnull -> 1991
/*      */     //   1988: invokestatic throwNpe : ()V
/*      */     //   1991: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1996: astore #7
/*      */     //   1998: aload_0
/*      */     //   1999: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2002: dup
/*      */     //   2003: ifnonnull -> 2009
/*      */     //   2006: invokestatic throwNpe : ()V
/*      */     //   2009: aload #7
/*      */     //   2011: ldc2_w 0.2
/*      */     //   2014: ldc2_w 0.2
/*      */     //   2017: ldc2_w 0.2
/*      */     //   2020: invokeinterface expand : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2025: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   2030: aload_0
/*      */     //   2031: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2034: dup
/*      */     //   2035: ifnonnull -> 2041
/*      */     //   2038: invokestatic throwNpe : ()V
/*      */     //   2041: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   2044: aload_0
/*      */     //   2045: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2048: dup
/*      */     //   2049: ifnonnull -> 2055
/*      */     //   2052: invokestatic throwNpe : ()V
/*      */     //   2055: invokeinterface getHurtTime : ()I
/*      */     //   2060: ifgt -> 2069
/*      */     //   2063: getstatic java/awt/Color.GREEN : Ljava/awt/Color;
/*      */     //   2066: goto -> 2072
/*      */     //   2069: getstatic java/awt/Color.RED : Ljava/awt/Color;
/*      */     //   2072: iconst_1
/*      */     //   2073: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*      */     //   2076: aload_0
/*      */     //   2077: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2080: dup
/*      */     //   2081: ifnonnull -> 2087
/*      */     //   2084: invokestatic throwNpe : ()V
/*      */     //   2087: aload #7
/*      */     //   2089: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   2094: goto -> 4196
/*      */     //   2097: aload_0
/*      */     //   2098: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2101: dup
/*      */     //   2102: ifnonnull -> 2108
/*      */     //   2105: invokestatic throwNpe : ()V
/*      */     //   2108: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   2111: aload_0
/*      */     //   2112: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2115: dup
/*      */     //   2116: ifnonnull -> 2122
/*      */     //   2119: invokestatic throwNpe : ()V
/*      */     //   2122: invokeinterface getHurtTime : ()I
/*      */     //   2127: ifgt -> 2152
/*      */     //   2130: new java/awt/Color
/*      */     //   2133: dup
/*      */     //   2134: sipush #255
/*      */     //   2137: sipush #255
/*      */     //   2140: sipush #255
/*      */     //   2143: sipush #255
/*      */     //   2146: invokespecial <init> : (IIII)V
/*      */     //   2149: goto -> 2170
/*      */     //   2152: new java/awt/Color
/*      */     //   2155: dup
/*      */     //   2156: bipush #124
/*      */     //   2158: sipush #215
/*      */     //   2161: sipush #255
/*      */     //   2164: sipush #255
/*      */     //   2167: invokespecial <init> : (IIII)V
/*      */     //   2170: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   2173: goto -> 4196
/*      */     //   2176: ldc_w 0.15
/*      */     //   2179: fstore #7
/*      */     //   2181: iconst_4
/*      */     //   2182: istore #8
/*      */     //   2184: invokestatic glPushMatrix : ()V
/*      */     //   2187: aload_0
/*      */     //   2188: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2191: dup
/*      */     //   2192: ifnonnull -> 2198
/*      */     //   2195: invokestatic throwNpe : ()V
/*      */     //   2198: invokeinterface getLastTickPosX : ()D
/*      */     //   2203: aload_0
/*      */     //   2204: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2207: dup
/*      */     //   2208: ifnonnull -> 2214
/*      */     //   2211: invokestatic throwNpe : ()V
/*      */     //   2214: invokeinterface getPosX : ()D
/*      */     //   2219: aload_0
/*      */     //   2220: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2223: dup
/*      */     //   2224: ifnonnull -> 2230
/*      */     //   2227: invokestatic throwNpe : ()V
/*      */     //   2230: invokeinterface getLastTickPosX : ()D
/*      */     //   2235: dsub
/*      */     //   2236: aload_1
/*      */     //   2237: invokevirtual getPartialTicks : ()F
/*      */     //   2240: f2d
/*      */     //   2241: dmul
/*      */     //   2242: dadd
/*      */     //   2243: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2246: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2251: invokeinterface getViewerPosX : ()D
/*      */     //   2256: dsub
/*      */     //   2257: aload_0
/*      */     //   2258: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2261: dup
/*      */     //   2262: ifnonnull -> 2268
/*      */     //   2265: invokestatic throwNpe : ()V
/*      */     //   2268: invokeinterface getLastTickPosY : ()D
/*      */     //   2273: aload_0
/*      */     //   2274: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2277: dup
/*      */     //   2278: ifnonnull -> 2284
/*      */     //   2281: invokestatic throwNpe : ()V
/*      */     //   2284: invokeinterface getPosY : ()D
/*      */     //   2289: aload_0
/*      */     //   2290: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2293: dup
/*      */     //   2294: ifnonnull -> 2300
/*      */     //   2297: invokestatic throwNpe : ()V
/*      */     //   2300: invokeinterface getLastTickPosY : ()D
/*      */     //   2305: dsub
/*      */     //   2306: aload_1
/*      */     //   2307: invokevirtual getPartialTicks : ()F
/*      */     //   2310: f2d
/*      */     //   2311: dmul
/*      */     //   2312: dadd
/*      */     //   2313: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2316: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2321: invokeinterface getViewerPosY : ()D
/*      */     //   2326: dsub
/*      */     //   2327: aload_0
/*      */     //   2328: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2331: dup
/*      */     //   2332: ifnonnull -> 2338
/*      */     //   2335: invokestatic throwNpe : ()V
/*      */     //   2338: invokeinterface getHeight : ()F
/*      */     //   2343: f2d
/*      */     //   2344: ldc2_w 1.1
/*      */     //   2347: dmul
/*      */     //   2348: dadd
/*      */     //   2349: aload_0
/*      */     //   2350: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2353: dup
/*      */     //   2354: ifnonnull -> 2360
/*      */     //   2357: invokestatic throwNpe : ()V
/*      */     //   2360: invokeinterface getLastTickPosZ : ()D
/*      */     //   2365: aload_0
/*      */     //   2366: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2369: dup
/*      */     //   2370: ifnonnull -> 2376
/*      */     //   2373: invokestatic throwNpe : ()V
/*      */     //   2376: invokeinterface getPosZ : ()D
/*      */     //   2381: aload_0
/*      */     //   2382: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2385: dup
/*      */     //   2386: ifnonnull -> 2392
/*      */     //   2389: invokestatic throwNpe : ()V
/*      */     //   2392: invokeinterface getLastTickPosZ : ()D
/*      */     //   2397: dsub
/*      */     //   2398: aload_1
/*      */     //   2399: invokevirtual getPartialTicks : ()F
/*      */     //   2402: f2d
/*      */     //   2403: dmul
/*      */     //   2404: dadd
/*      */     //   2405: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2408: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2413: invokeinterface getViewerPosZ : ()D
/*      */     //   2418: dsub
/*      */     //   2419: invokestatic glTranslated : (DDD)V
/*      */     //   2422: aload_0
/*      */     //   2423: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2426: dup
/*      */     //   2427: ifnonnull -> 2433
/*      */     //   2430: invokestatic throwNpe : ()V
/*      */     //   2433: invokeinterface getWidth : ()F
/*      */     //   2438: fneg
/*      */     //   2439: fconst_0
/*      */     //   2440: fconst_1
/*      */     //   2441: fconst_0
/*      */     //   2442: invokestatic glRotatef : (FFFF)V
/*      */     //   2445: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2448: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   2453: dup
/*      */     //   2454: ifnonnull -> 2460
/*      */     //   2457: invokestatic throwNpe : ()V
/*      */     //   2460: invokeinterface getTicksExisted : ()I
/*      */     //   2465: i2f
/*      */     //   2466: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2469: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   2474: invokeinterface getRenderPartialTicks : ()F
/*      */     //   2479: fadd
/*      */     //   2480: iconst_5
/*      */     //   2481: i2f
/*      */     //   2482: fmul
/*      */     //   2483: fconst_0
/*      */     //   2484: fconst_1
/*      */     //   2485: fconst_0
/*      */     //   2486: invokestatic glRotatef : (FFFF)V
/*      */     //   2489: aload_0
/*      */     //   2490: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2493: dup
/*      */     //   2494: ifnonnull -> 2500
/*      */     //   2497: invokestatic throwNpe : ()V
/*      */     //   2500: invokeinterface getHurtTime : ()I
/*      */     //   2505: ifgt -> 2525
/*      */     //   2508: new java/awt/Color
/*      */     //   2511: dup
/*      */     //   2512: bipush #80
/*      */     //   2514: sipush #255
/*      */     //   2517: bipush #80
/*      */     //   2519: invokespecial <init> : (III)V
/*      */     //   2522: goto -> 2537
/*      */     //   2525: new java/awt/Color
/*      */     //   2528: dup
/*      */     //   2529: sipush #255
/*      */     //   2532: iconst_0
/*      */     //   2533: iconst_0
/*      */     //   2534: invokespecial <init> : (III)V
/*      */     //   2537: invokestatic glColor : (Ljava/awt/Color;)V
/*      */     //   2540: ldc_w 1.5
/*      */     //   2543: invokestatic enableSmoothLine : (F)V
/*      */     //   2546: new org/lwjgl/util/glu/Cylinder
/*      */     //   2549: dup
/*      */     //   2550: invokespecial <init> : ()V
/*      */     //   2553: astore #9
/*      */     //   2555: ldc_w -90.0
/*      */     //   2558: fconst_1
/*      */     //   2559: fconst_0
/*      */     //   2560: fconst_0
/*      */     //   2561: invokestatic glRotatef : (FFFF)V
/*      */     //   2564: aload #9
/*      */     //   2566: fconst_0
/*      */     //   2567: fload #7
/*      */     //   2569: ldc_w 0.3
/*      */     //   2572: iload #8
/*      */     //   2574: iconst_1
/*      */     //   2575: invokevirtual draw : (FFFII)V
/*      */     //   2578: aload #9
/*      */     //   2580: ldc_w 100012
/*      */     //   2583: invokevirtual setDrawStyle : (I)V
/*      */     //   2586: dconst_0
/*      */     //   2587: dconst_0
/*      */     //   2588: ldc2_w 0.3
/*      */     //   2591: invokestatic glTranslated : (DDD)V
/*      */     //   2594: aload #9
/*      */     //   2596: fload #7
/*      */     //   2598: fconst_0
/*      */     //   2599: ldc_w 0.3
/*      */     //   2602: iload #8
/*      */     //   2604: iconst_1
/*      */     //   2605: invokevirtual draw : (FFFII)V
/*      */     //   2608: ldc_w 90.0
/*      */     //   2611: fconst_0
/*      */     //   2612: fconst_0
/*      */     //   2613: fconst_1
/*      */     //   2614: invokestatic glRotatef : (FFFF)V
/*      */     //   2617: dconst_0
/*      */     //   2618: dconst_0
/*      */     //   2619: ldc2_w -0.3
/*      */     //   2622: invokestatic glTranslated : (DDD)V
/*      */     //   2625: aload #9
/*      */     //   2627: fconst_0
/*      */     //   2628: fload #7
/*      */     //   2630: ldc_w 0.3
/*      */     //   2633: iload #8
/*      */     //   2635: iconst_1
/*      */     //   2636: invokevirtual draw : (FFFII)V
/*      */     //   2639: dconst_0
/*      */     //   2640: dconst_0
/*      */     //   2641: ldc2_w 0.3
/*      */     //   2644: invokestatic glTranslated : (DDD)V
/*      */     //   2647: aload #9
/*      */     //   2649: fload #7
/*      */     //   2651: fconst_0
/*      */     //   2652: ldc_w 0.3
/*      */     //   2655: iload #8
/*      */     //   2657: iconst_1
/*      */     //   2658: invokevirtual draw : (FFFII)V
/*      */     //   2661: invokestatic disableSmoothLine : ()V
/*      */     //   2664: invokestatic glPopMatrix : ()V
/*      */     //   2667: goto -> 4196
/*      */     //   2670: invokestatic currentTimeMillis : ()J
/*      */     //   2673: sipush #1500
/*      */     //   2676: i2l
/*      */     //   2677: lrem
/*      */     //   2678: l2i
/*      */     //   2679: istore #7
/*      */     //   2681: iload #7
/*      */     //   2683: sipush #750
/*      */     //   2686: if_icmple -> 2693
/*      */     //   2689: iconst_1
/*      */     //   2690: goto -> 2694
/*      */     //   2693: iconst_0
/*      */     //   2694: istore #8
/*      */     //   2696: iload #7
/*      */     //   2698: i2d
/*      */     //   2699: ldc2_w 750.0
/*      */     //   2702: ddiv
/*      */     //   2703: dstore #9
/*      */     //   2705: iload #8
/*      */     //   2707: ifne -> 2720
/*      */     //   2710: iconst_1
/*      */     //   2711: i2d
/*      */     //   2712: dload #9
/*      */     //   2714: dsub
/*      */     //   2715: dstore #9
/*      */     //   2717: goto -> 2727
/*      */     //   2720: dload #9
/*      */     //   2722: iconst_1
/*      */     //   2723: i2d
/*      */     //   2724: dsub
/*      */     //   2725: dstore #9
/*      */     //   2727: getstatic net/ccbluex/liquidbounce/utils/render/EaseUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;
/*      */     //   2730: dload #9
/*      */     //   2732: invokevirtual easeInOutQuad : (D)D
/*      */     //   2735: dstore #9
/*      */     //   2737: invokestatic glPushMatrix : ()V
/*      */     //   2740: sipush #3553
/*      */     //   2743: invokestatic glDisable : (I)V
/*      */     //   2746: sipush #2848
/*      */     //   2749: invokestatic glEnable : (I)V
/*      */     //   2752: sipush #2881
/*      */     //   2755: invokestatic glEnable : (I)V
/*      */     //   2758: sipush #2832
/*      */     //   2761: invokestatic glEnable : (I)V
/*      */     //   2764: sipush #3042
/*      */     //   2767: invokestatic glEnable : (I)V
/*      */     //   2770: sipush #770
/*      */     //   2773: sipush #771
/*      */     //   2776: invokestatic glBlendFunc : (II)V
/*      */     //   2779: sipush #3154
/*      */     //   2782: sipush #4354
/*      */     //   2785: invokestatic glHint : (II)V
/*      */     //   2788: sipush #3155
/*      */     //   2791: sipush #4354
/*      */     //   2794: invokestatic glHint : (II)V
/*      */     //   2797: sipush #3153
/*      */     //   2800: sipush #4354
/*      */     //   2803: invokestatic glHint : (II)V
/*      */     //   2806: sipush #2929
/*      */     //   2809: invokestatic glDisable : (I)V
/*      */     //   2812: iconst_0
/*      */     //   2813: invokestatic glDepthMask : (Z)V
/*      */     //   2816: aload_0
/*      */     //   2817: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2820: dup
/*      */     //   2821: ifnonnull -> 2827
/*      */     //   2824: invokestatic throwNpe : ()V
/*      */     //   2827: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2832: astore #11
/*      */     //   2834: aload #11
/*      */     //   2836: invokeinterface getMaxX : ()D
/*      */     //   2841: aload #11
/*      */     //   2843: invokeinterface getMinX : ()D
/*      */     //   2848: dsub
/*      */     //   2849: ldc2_w 0.3
/*      */     //   2852: dadd
/*      */     //   2853: dstore #12
/*      */     //   2855: aload #11
/*      */     //   2857: invokeinterface getMaxY : ()D
/*      */     //   2862: aload #11
/*      */     //   2864: invokeinterface getMinY : ()D
/*      */     //   2869: dsub
/*      */     //   2870: dstore #14
/*      */     //   2872: aload_0
/*      */     //   2873: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2876: dup
/*      */     //   2877: ifnonnull -> 2883
/*      */     //   2880: invokestatic throwNpe : ()V
/*      */     //   2883: invokeinterface getLastTickPosX : ()D
/*      */     //   2888: aload_0
/*      */     //   2889: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2892: dup
/*      */     //   2893: ifnonnull -> 2899
/*      */     //   2896: invokestatic throwNpe : ()V
/*      */     //   2899: invokeinterface getPosX : ()D
/*      */     //   2904: aload_0
/*      */     //   2905: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2908: dup
/*      */     //   2909: ifnonnull -> 2915
/*      */     //   2912: invokestatic throwNpe : ()V
/*      */     //   2915: invokeinterface getLastTickPosX : ()D
/*      */     //   2920: dsub
/*      */     //   2921: aload_1
/*      */     //   2922: invokevirtual getPartialTicks : ()F
/*      */     //   2925: f2d
/*      */     //   2926: dmul
/*      */     //   2927: dadd
/*      */     //   2928: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2931: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2936: invokeinterface getViewerPosX : ()D
/*      */     //   2941: dsub
/*      */     //   2942: dstore #16
/*      */     //   2944: aload_0
/*      */     //   2945: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2948: dup
/*      */     //   2949: ifnonnull -> 2955
/*      */     //   2952: invokestatic throwNpe : ()V
/*      */     //   2955: invokeinterface getLastTickPosY : ()D
/*      */     //   2960: aload_0
/*      */     //   2961: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2964: dup
/*      */     //   2965: ifnonnull -> 2971
/*      */     //   2968: invokestatic throwNpe : ()V
/*      */     //   2971: invokeinterface getPosY : ()D
/*      */     //   2976: aload_0
/*      */     //   2977: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2980: dup
/*      */     //   2981: ifnonnull -> 2987
/*      */     //   2984: invokestatic throwNpe : ()V
/*      */     //   2987: invokeinterface getLastTickPosY : ()D
/*      */     //   2992: dsub
/*      */     //   2993: aload_1
/*      */     //   2994: invokevirtual getPartialTicks : ()F
/*      */     //   2997: f2d
/*      */     //   2998: dmul
/*      */     //   2999: dadd
/*      */     //   3000: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3003: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3008: invokeinterface getViewerPosY : ()D
/*      */     //   3013: dsub
/*      */     //   3014: dload #14
/*      */     //   3016: dload #9
/*      */     //   3018: dmul
/*      */     //   3019: dadd
/*      */     //   3020: dstore #18
/*      */     //   3022: aload_0
/*      */     //   3023: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3026: dup
/*      */     //   3027: ifnonnull -> 3033
/*      */     //   3030: invokestatic throwNpe : ()V
/*      */     //   3033: invokeinterface getLastTickPosZ : ()D
/*      */     //   3038: aload_0
/*      */     //   3039: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3042: dup
/*      */     //   3043: ifnonnull -> 3049
/*      */     //   3046: invokestatic throwNpe : ()V
/*      */     //   3049: invokeinterface getPosZ : ()D
/*      */     //   3054: aload_0
/*      */     //   3055: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3058: dup
/*      */     //   3059: ifnonnull -> 3065
/*      */     //   3062: invokestatic throwNpe : ()V
/*      */     //   3065: invokeinterface getLastTickPosZ : ()D
/*      */     //   3070: dsub
/*      */     //   3071: aload_1
/*      */     //   3072: invokevirtual getPartialTicks : ()F
/*      */     //   3075: f2d
/*      */     //   3076: dmul
/*      */     //   3077: dadd
/*      */     //   3078: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3081: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3086: invokeinterface getViewerPosZ : ()D
/*      */     //   3091: dsub
/*      */     //   3092: dstore #20
/*      */     //   3094: dload #12
/*      */     //   3096: ldc_w 5.0
/*      */     //   3099: f2d
/*      */     //   3100: dmul
/*      */     //   3101: d2f
/*      */     //   3102: invokestatic glLineWidth : (F)V
/*      */     //   3105: iconst_3
/*      */     //   3106: invokestatic glBegin : (I)V
/*      */     //   3109: iconst_0
/*      */     //   3110: istore #22
/*      */     //   3112: sipush #360
/*      */     //   3115: istore #23
/*      */     //   3117: iload #22
/*      */     //   3119: iload #23
/*      */     //   3121: if_icmpgt -> 3332
/*      */     //   3124: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3127: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   3132: dup
/*      */     //   3133: ifnonnull -> 3139
/*      */     //   3136: invokestatic throwNpe : ()V
/*      */     //   3139: invokeinterface getTicksExisted : ()I
/*      */     //   3144: i2d
/*      */     //   3145: ldc2_w 70.0
/*      */     //   3148: ddiv
/*      */     //   3149: iload #22
/*      */     //   3151: i2d
/*      */     //   3152: ldc2_w 50.0
/*      */     //   3155: ddiv
/*      */     //   3156: ldc2_w 1.75
/*      */     //   3159: dmul
/*      */     //   3160: dstore #25
/*      */     //   3162: dstore #36
/*      */     //   3164: iconst_0
/*      */     //   3165: istore #27
/*      */     //   3167: dload #25
/*      */     //   3169: invokestatic sin : (D)D
/*      */     //   3172: dstore #38
/*      */     //   3174: dload #36
/*      */     //   3176: dload #38
/*      */     //   3178: dadd
/*      */     //   3179: d2f
/*      */     //   3180: fconst_1
/*      */     //   3181: frem
/*      */     //   3182: ldc_w 0.7
/*      */     //   3185: fconst_1
/*      */     //   3186: invokestatic HSBtoRGB : (FFF)I
/*      */     //   3189: istore #44
/*      */     //   3191: new java/awt/Color
/*      */     //   3194: dup
/*      */     //   3195: iload #44
/*      */     //   3197: invokespecial <init> : (I)V
/*      */     //   3200: astore #24
/*      */     //   3202: aload #24
/*      */     //   3204: invokevirtual getRed : ()I
/*      */     //   3207: i2f
/*      */     //   3208: ldc_w 255.0
/*      */     //   3211: fdiv
/*      */     //   3212: aload #24
/*      */     //   3214: invokevirtual getGreen : ()I
/*      */     //   3217: i2f
/*      */     //   3218: ldc_w 255.0
/*      */     //   3221: fdiv
/*      */     //   3222: aload #24
/*      */     //   3224: invokevirtual getBlue : ()I
/*      */     //   3227: i2f
/*      */     //   3228: ldc_w 255.0
/*      */     //   3231: fdiv
/*      */     //   3232: invokestatic glColor3f : (FFF)V
/*      */     //   3235: dload #16
/*      */     //   3237: dload #12
/*      */     //   3239: iload #22
/*      */     //   3241: i2d
/*      */     //   3242: ldc2_w 6.283185307179586
/*      */     //   3245: dmul
/*      */     //   3246: ldc2_w 45.0
/*      */     //   3249: ddiv
/*      */     //   3250: dstore #25
/*      */     //   3252: dstore #36
/*      */     //   3254: dstore #34
/*      */     //   3256: iconst_0
/*      */     //   3257: istore #27
/*      */     //   3259: dload #25
/*      */     //   3261: invokestatic cos : (D)D
/*      */     //   3264: dstore #38
/*      */     //   3266: dload #34
/*      */     //   3268: dload #36
/*      */     //   3270: dload #38
/*      */     //   3272: dmul
/*      */     //   3273: dadd
/*      */     //   3274: dload #18
/*      */     //   3276: dload #20
/*      */     //   3278: dload #12
/*      */     //   3280: iload #22
/*      */     //   3282: i2d
/*      */     //   3283: ldc2_w 6.283185307179586
/*      */     //   3286: dmul
/*      */     //   3287: ldc2_w 45.0
/*      */     //   3290: ddiv
/*      */     //   3291: dstore #25
/*      */     //   3293: dstore #40
/*      */     //   3295: dstore #38
/*      */     //   3297: dstore #36
/*      */     //   3299: dstore #34
/*      */     //   3301: iconst_0
/*      */     //   3302: istore #27
/*      */     //   3304: dload #25
/*      */     //   3306: invokestatic sin : (D)D
/*      */     //   3309: dstore #42
/*      */     //   3311: dload #34
/*      */     //   3313: dload #36
/*      */     //   3315: dload #38
/*      */     //   3317: dload #40
/*      */     //   3319: dload #42
/*      */     //   3321: dmul
/*      */     //   3322: dadd
/*      */     //   3323: invokestatic glVertex3d : (DDD)V
/*      */     //   3326: iinc #22, 1
/*      */     //   3329: goto -> 3117
/*      */     //   3332: invokestatic glEnd : ()V
/*      */     //   3335: iconst_1
/*      */     //   3336: invokestatic glDepthMask : (Z)V
/*      */     //   3339: sipush #2929
/*      */     //   3342: invokestatic glEnable : (I)V
/*      */     //   3345: sipush #2848
/*      */     //   3348: invokestatic glDisable : (I)V
/*      */     //   3351: sipush #2881
/*      */     //   3354: invokestatic glDisable : (I)V
/*      */     //   3357: sipush #2832
/*      */     //   3360: invokestatic glEnable : (I)V
/*      */     //   3363: sipush #3553
/*      */     //   3366: invokestatic glEnable : (I)V
/*      */     //   3369: invokestatic glPopMatrix : ()V
/*      */     //   3372: goto -> 4196
/*      */     //   3375: aload_0
/*      */     //   3376: getfield yPos : D
/*      */     //   3379: dstore #7
/*      */     //   3381: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$5.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$5;
/*      */     //   3384: astore #9
/*      */     //   3386: aload_0
/*      */     //   3387: getfield al : F
/*      */     //   3390: fconst_0
/*      */     //   3391: fcmpl
/*      */     //   3392: ifle -> 3487
/*      */     //   3395: invokestatic currentTimeMillis : ()J
/*      */     //   3398: aload_0
/*      */     //   3399: getfield lastMS : J
/*      */     //   3402: lsub
/*      */     //   3403: ldc2_w 1000
/*      */     //   3406: lcmp
/*      */     //   3407: iflt -> 3426
/*      */     //   3410: aload_0
/*      */     //   3411: aload_0
/*      */     //   3412: getfield direction : D
/*      */     //   3415: dneg
/*      */     //   3416: putfield direction : D
/*      */     //   3419: aload_0
/*      */     //   3420: invokestatic currentTimeMillis : ()J
/*      */     //   3423: putfield lastMS : J
/*      */     //   3426: aload_0
/*      */     //   3427: getfield direction : D
/*      */     //   3430: iconst_0
/*      */     //   3431: i2d
/*      */     //   3432: dcmpl
/*      */     //   3433: ifle -> 3447
/*      */     //   3436: invokestatic currentTimeMillis : ()J
/*      */     //   3439: aload_0
/*      */     //   3440: getfield lastMS : J
/*      */     //   3443: lsub
/*      */     //   3444: goto -> 3459
/*      */     //   3447: ldc2_w 1000
/*      */     //   3450: invokestatic currentTimeMillis : ()J
/*      */     //   3453: aload_0
/*      */     //   3454: getfield lastMS : J
/*      */     //   3457: lsub
/*      */     //   3458: lsub
/*      */     //   3459: lstore #10
/*      */     //   3461: aload_0
/*      */     //   3462: lload #10
/*      */     //   3464: l2d
/*      */     //   3465: ldc2_w 1000.0
/*      */     //   3468: ddiv
/*      */     //   3469: putfield progress : D
/*      */     //   3472: aload_0
/*      */     //   3473: invokestatic currentTimeMillis : ()J
/*      */     //   3476: aload_0
/*      */     //   3477: getfield lastMS : J
/*      */     //   3480: lsub
/*      */     //   3481: putfield lastDeltaMS : J
/*      */     //   3484: goto -> 3499
/*      */     //   3487: aload_0
/*      */     //   3488: invokestatic currentTimeMillis : ()J
/*      */     //   3491: aload_0
/*      */     //   3492: getfield lastDeltaMS : J
/*      */     //   3495: lsub
/*      */     //   3496: putfield lastMS : J
/*      */     //   3499: aload_0
/*      */     //   3500: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3503: ifnull -> 3534
/*      */     //   3506: aload_0
/*      */     //   3507: aload_0
/*      */     //   3508: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3511: putfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3514: aload_0
/*      */     //   3515: aload_0
/*      */     //   3516: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3519: dup
/*      */     //   3520: ifnonnull -> 3526
/*      */     //   3523: invokestatic throwNpe : ()V
/*      */     //   3526: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3531: putfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3534: aload_0
/*      */     //   3535: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3538: ifnull -> 3548
/*      */     //   3541: aload_0
/*      */     //   3542: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3545: ifnonnull -> 3549
/*      */     //   3548: return
/*      */     //   3549: aload_0
/*      */     //   3550: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3553: dup
/*      */     //   3554: ifnonnull -> 3560
/*      */     //   3557: invokestatic throwNpe : ()V
/*      */     //   3560: invokeinterface getMaxX : ()D
/*      */     //   3565: aload_0
/*      */     //   3566: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3569: dup
/*      */     //   3570: ifnonnull -> 3576
/*      */     //   3573: invokestatic throwNpe : ()V
/*      */     //   3576: invokeinterface getMinX : ()D
/*      */     //   3581: dsub
/*      */     //   3582: dstore #10
/*      */     //   3584: aload_0
/*      */     //   3585: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3588: dup
/*      */     //   3589: ifnonnull -> 3595
/*      */     //   3592: invokestatic throwNpe : ()V
/*      */     //   3595: invokeinterface getMaxY : ()D
/*      */     //   3600: aload_0
/*      */     //   3601: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3604: dup
/*      */     //   3605: ifnonnull -> 3611
/*      */     //   3608: invokestatic throwNpe : ()V
/*      */     //   3611: invokeinterface getMinY : ()D
/*      */     //   3616: dsub
/*      */     //   3617: dstore #12
/*      */     //   3619: aload_0
/*      */     //   3620: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3623: dup
/*      */     //   3624: ifnonnull -> 3630
/*      */     //   3627: invokestatic throwNpe : ()V
/*      */     //   3630: invokeinterface getLastTickPosX : ()D
/*      */     //   3635: aload_0
/*      */     //   3636: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3639: dup
/*      */     //   3640: ifnonnull -> 3646
/*      */     //   3643: invokestatic throwNpe : ()V
/*      */     //   3646: invokeinterface getPosX : ()D
/*      */     //   3651: aload_0
/*      */     //   3652: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3655: dup
/*      */     //   3656: ifnonnull -> 3662
/*      */     //   3659: invokestatic throwNpe : ()V
/*      */     //   3662: invokeinterface getLastTickPosX : ()D
/*      */     //   3667: dsub
/*      */     //   3668: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3671: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3676: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3681: f2d
/*      */     //   3682: dmul
/*      */     //   3683: dadd
/*      */     //   3684: dstore #14
/*      */     //   3686: aload_0
/*      */     //   3687: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3690: dup
/*      */     //   3691: ifnonnull -> 3697
/*      */     //   3694: invokestatic throwNpe : ()V
/*      */     //   3697: invokeinterface getLastTickPosY : ()D
/*      */     //   3702: aload_0
/*      */     //   3703: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3706: dup
/*      */     //   3707: ifnonnull -> 3713
/*      */     //   3710: invokestatic throwNpe : ()V
/*      */     //   3713: invokeinterface getPosY : ()D
/*      */     //   3718: aload_0
/*      */     //   3719: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3722: dup
/*      */     //   3723: ifnonnull -> 3729
/*      */     //   3726: invokestatic throwNpe : ()V
/*      */     //   3729: invokeinterface getLastTickPosY : ()D
/*      */     //   3734: dsub
/*      */     //   3735: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3738: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3743: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3748: f2d
/*      */     //   3749: dmul
/*      */     //   3750: dadd
/*      */     //   3751: dstore #16
/*      */     //   3753: aload_0
/*      */     //   3754: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3757: dup
/*      */     //   3758: ifnonnull -> 3764
/*      */     //   3761: invokestatic throwNpe : ()V
/*      */     //   3764: invokeinterface getLastTickPosZ : ()D
/*      */     //   3769: aload_0
/*      */     //   3770: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3773: dup
/*      */     //   3774: ifnonnull -> 3780
/*      */     //   3777: invokestatic throwNpe : ()V
/*      */     //   3780: invokeinterface getPosZ : ()D
/*      */     //   3785: aload_0
/*      */     //   3786: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3789: dup
/*      */     //   3790: ifnonnull -> 3796
/*      */     //   3793: invokestatic throwNpe : ()V
/*      */     //   3796: invokeinterface getLastTickPosZ : ()D
/*      */     //   3801: dsub
/*      */     //   3802: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3805: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3810: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3815: f2d
/*      */     //   3816: dmul
/*      */     //   3817: dadd
/*      */     //   3818: dstore #18
/*      */     //   3820: aload_0
/*      */     //   3821: aload #9
/*      */     //   3823: aload_0
/*      */     //   3824: getfield progress : D
/*      */     //   3827: invokevirtual invoke : (D)D
/*      */     //   3830: dload #12
/*      */     //   3832: dmul
/*      */     //   3833: putfield yPos : D
/*      */     //   3836: aload_0
/*      */     //   3837: getfield direction : D
/*      */     //   3840: iconst_0
/*      */     //   3841: i2d
/*      */     //   3842: dcmpl
/*      */     //   3843: ifle -> 3856
/*      */     //   3846: aload_0
/*      */     //   3847: getfield yPos : D
/*      */     //   3850: dload #7
/*      */     //   3852: dsub
/*      */     //   3853: goto -> 3863
/*      */     //   3856: dload #7
/*      */     //   3858: aload_0
/*      */     //   3859: getfield yPos : D
/*      */     //   3862: dsub
/*      */     //   3863: aload_0
/*      */     //   3864: getfield direction : D
/*      */     //   3867: dneg
/*      */     //   3868: dmul
/*      */     //   3869: aload_0
/*      */     //   3870: getfield jelloGradientHeightValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   3873: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3876: checkcast java/lang/Number
/*      */     //   3879: invokevirtual doubleValue : ()D
/*      */     //   3882: dmul
/*      */     //   3883: dstore #20
/*      */     //   3885: aload_0
/*      */     //   3886: getfield al : F
/*      */     //   3889: iconst_0
/*      */     //   3890: i2f
/*      */     //   3891: fcmpg
/*      */     //   3892: ifgt -> 3911
/*      */     //   3895: aload_0
/*      */     //   3896: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3899: ifnull -> 3911
/*      */     //   3902: aload_0
/*      */     //   3903: aconst_null
/*      */     //   3904: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   3907: putfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3910: return
/*      */     //   3911: aload #5
/*      */     //   3913: aload_0
/*      */     //   3914: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3917: invokevirtual invoke : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Ljava/awt/Color;
/*      */     //   3920: astore #22
/*      */     //   3922: aload #22
/*      */     //   3924: dup
/*      */     //   3925: ifnonnull -> 3931
/*      */     //   3928: invokestatic throwNpe : ()V
/*      */     //   3931: invokevirtual getRed : ()I
/*      */     //   3934: i2f
/*      */     //   3935: ldc_w 255.0
/*      */     //   3938: fdiv
/*      */     //   3939: fstore #23
/*      */     //   3941: aload #22
/*      */     //   3943: invokevirtual getGreen : ()I
/*      */     //   3946: i2f
/*      */     //   3947: ldc_w 255.0
/*      */     //   3950: fdiv
/*      */     //   3951: fstore #24
/*      */     //   3953: aload #22
/*      */     //   3955: invokevirtual getBlue : ()I
/*      */     //   3958: i2f
/*      */     //   3959: ldc_w 255.0
/*      */     //   3962: fdiv
/*      */     //   3963: fstore #25
/*      */     //   3965: aload #4
/*      */     //   3967: invokevirtual invoke : ()V
/*      */     //   3970: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3973: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3978: invokeinterface getViewerPosX : ()D
/*      */     //   3983: dneg
/*      */     //   3984: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3987: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3992: invokeinterface getViewerPosY : ()D
/*      */     //   3997: dneg
/*      */     //   3998: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   4001: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   4006: invokeinterface getViewerPosZ : ()D
/*      */     //   4011: dneg
/*      */     //   4012: invokestatic glTranslated : (DDD)V
/*      */     //   4015: bipush #8
/*      */     //   4017: invokestatic glBegin : (I)V
/*      */     //   4020: iconst_0
/*      */     //   4021: istore #26
/*      */     //   4023: sipush #360
/*      */     //   4026: istore #27
/*      */     //   4028: iload #26
/*      */     //   4030: iload #27
/*      */     //   4032: if_icmpgt -> 4149
/*      */     //   4035: iload #26
/*      */     //   4037: i2d
/*      */     //   4038: ldc2_w 3.141592653589793
/*      */     //   4041: dmul
/*      */     //   4042: sipush #180
/*      */     //   4045: i2d
/*      */     //   4046: ddiv
/*      */     //   4047: dstore #28
/*      */     //   4049: dload #14
/*      */     //   4051: dload #28
/*      */     //   4053: invokestatic sin : (D)D
/*      */     //   4056: dload #10
/*      */     //   4058: dmul
/*      */     //   4059: dsub
/*      */     //   4060: dstore #30
/*      */     //   4062: dload #18
/*      */     //   4064: dload #28
/*      */     //   4066: invokestatic cos : (D)D
/*      */     //   4069: dload #10
/*      */     //   4071: dmul
/*      */     //   4072: dadd
/*      */     //   4073: dstore #32
/*      */     //   4075: fload #23
/*      */     //   4077: fload #24
/*      */     //   4079: fload #25
/*      */     //   4081: fconst_0
/*      */     //   4082: invokestatic glColor4f : (FFFF)V
/*      */     //   4085: dload #30
/*      */     //   4087: dload #16
/*      */     //   4089: aload_0
/*      */     //   4090: getfield yPos : D
/*      */     //   4093: dadd
/*      */     //   4094: dload #20
/*      */     //   4096: dadd
/*      */     //   4097: dload #32
/*      */     //   4099: invokestatic glVertex3d : (DDD)V
/*      */     //   4102: fload #23
/*      */     //   4104: fload #24
/*      */     //   4106: fload #25
/*      */     //   4108: aload_0
/*      */     //   4109: getfield al : F
/*      */     //   4112: aload_0
/*      */     //   4113: getfield jelloAlphaValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   4116: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   4119: checkcast java/lang/Number
/*      */     //   4122: invokevirtual floatValue : ()F
/*      */     //   4125: fmul
/*      */     //   4126: invokestatic glColor4f : (FFFF)V
/*      */     //   4129: dload #30
/*      */     //   4131: dload #16
/*      */     //   4133: aload_0
/*      */     //   4134: getfield yPos : D
/*      */     //   4137: dadd
/*      */     //   4138: dload #32
/*      */     //   4140: invokestatic glVertex3d : (DDD)V
/*      */     //   4143: iinc #26, 1
/*      */     //   4146: goto -> 4028
/*      */     //   4149: invokestatic glEnd : ()V
/*      */     //   4152: aload_3
/*      */     //   4153: dload #14
/*      */     //   4155: dload #16
/*      */     //   4157: aload_0
/*      */     //   4158: getfield yPos : D
/*      */     //   4161: dadd
/*      */     //   4162: dload #18
/*      */     //   4164: aload_0
/*      */     //   4165: getfield jelloWidthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   4168: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   4171: checkcast java/lang/Number
/*      */     //   4174: invokevirtual floatValue : ()F
/*      */     //   4177: dload #10
/*      */     //   4179: fload #23
/*      */     //   4181: fload #24
/*      */     //   4183: fload #25
/*      */     //   4185: aload_0
/*      */     //   4186: getfield al : F
/*      */     //   4189: invokevirtual invoke : (DDDFDFFFF)V
/*      */     //   4192: aload_2
/*      */     //   4193: invokevirtual invoke : ()V
/*      */     //   4196: aload_0
/*      */     //   4197: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   4200: ifnull -> 4302
/*      */     //   4203: aload_0
/*      */     //   4204: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   4207: aload_0
/*      */     //   4208: getfield attackDelay : J
/*      */     //   4211: invokevirtual hasTimePassed : (J)Z
/*      */     //   4214: ifeq -> 4302
/*      */     //   4217: aload_0
/*      */     //   4218: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   4221: dup
/*      */     //   4222: ifnonnull -> 4228
/*      */     //   4225: invokestatic throwNpe : ()V
/*      */     //   4228: invokeinterface getHurtTime : ()I
/*      */     //   4233: aload_0
/*      */     //   4234: getfield hurtTimeValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   4237: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   4240: checkcast java/lang/Number
/*      */     //   4243: invokevirtual intValue : ()I
/*      */     //   4246: if_icmpgt -> 4302
/*      */     //   4249: aload_0
/*      */     //   4250: dup
/*      */     //   4251: getfield clicks : I
/*      */     //   4254: dup
/*      */     //   4255: istore #6
/*      */     //   4257: iconst_1
/*      */     //   4258: iadd
/*      */     //   4259: putfield clicks : I
/*      */     //   4262: aload_0
/*      */     //   4263: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   4266: invokevirtual reset : ()V
/*      */     //   4269: aload_0
/*      */     //   4270: aload_0
/*      */     //   4271: getfield minCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   4274: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   4277: checkcast java/lang/Number
/*      */     //   4280: invokevirtual intValue : ()I
/*      */     //   4283: aload_0
/*      */     //   4284: getfield maxCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   4287: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   4290: checkcast java/lang/Number
/*      */     //   4293: invokevirtual intValue : ()I
/*      */     //   4296: invokestatic randomClickDelay : (II)J
/*      */     //   4299: putfield attackDelay : J
/*      */     //   4302: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #587	-> 7
/*      */     //   #597	-> 11
/*      */     //   #620	-> 15
/*      */     //   #633	-> 20
/*      */     //   #669	-> 30
/*      */     //   #670	-> 46
/*      */     //   #671	-> 58
/*      */     //   #672	-> 61
/*      */     //   #673	-> 61
/*      */     //   #674	-> 155
/*      */     //   #675	-> 249
/*      */     //   #672	-> 343
/*      */     //   #677	-> 346
/*      */     //   #678	-> 352
/*      */     //   #679	-> 358
/*      */     //   #680	-> 364
/*      */     //   #681	-> 370
/*      */     //   #683	-> 379
/*      */     //   #684	-> 383
/*      */     //   #685	-> 383
/*      */     //   #686	-> 401
/*      */     //   #687	-> 419
/*      */     //   #688	-> 437
/*      */     //   #684	-> 455
/*      */     //   #690	-> 458
/*      */     //   #691	-> 467
/*      */     //   #693	-> 471
/*      */     //   #694	-> 543
/*      */     //   #695	-> 543
/*      */     //   #695	-> 564
/*      */     //   #696	-> 568
/*      */     //   #696	-> 597
/*      */     //   #694	-> 601
/*      */     //   #693	-> 604
/*      */     //   #699	-> 621
/*      */     //   #700	-> 621
/*      */     //   #700	-> 634
/*      */     //   #701	-> 638
/*      */     //   #701	-> 659
/*      */     //   #699	-> 663
/*      */     //   #704	-> 666
/*      */     //   #706	-> 669
/*      */     //   #707	-> 675
/*      */     //   #708	-> 681
/*      */     //   #709	-> 687
/*      */     //   #711	-> 693
/*      */     //   #715	-> 696
/*      */     //   #716	-> 712
/*      */     //   #717	-> 715
/*      */     //   #718	-> 715
/*      */     //   #719	-> 806
/*      */     //   #720	-> 897
/*      */     //   #717	-> 988
/*      */     //   #722	-> 991
/*      */     //   #723	-> 997
/*      */     //   #724	-> 1003
/*      */     //   #725	-> 1009
/*      */     //   #726	-> 1015
/*      */     //   #728	-> 1024
/*      */     //   #729	-> 1028
/*      */     //   #730	-> 1103
/*      */     //   #731	-> 1112
/*      */     //   #733	-> 1116
/*      */     //   #734	-> 1188
/*      */     //   #734	-> 1209
/*      */     //   #734	-> 1253
/*      */     //   #733	-> 1271
/*      */     //   #736	-> 1288
/*      */     //   #736	-> 1301
/*      */     //   #736	-> 1337
/*      */     //   #738	-> 1355
/*      */     //   #740	-> 1358
/*      */     //   #741	-> 1364
/*      */     //   #742	-> 1370
/*      */     //   #743	-> 1376
/*      */     //   #745	-> 1382
/*      */     //   #748	-> 1385
/*      */     //   #1590	-> 1391
/*      */     //   #1591	-> 1391
/*      */     //   #1590	-> 1416
/*      */     //   #1591	-> 1440
/*      */     //   #749	-> 1484
/*      */     //   #750	-> 1492
/*      */     //   #751	-> 1500
/*      */     //   #752	-> 1505
/*      */     //   #753	-> 1509
/*      */     //   #756	-> 1510
/*      */     //   #757	-> 1510
/*      */     //   #756	-> 1510
/*      */     //   #757	-> 1545
/*      */     //   #758	-> 1570
/*      */     //   #759	-> 1578
/*      */     //   #760	-> 1586
/*      */     //   #761	-> 1591
/*      */     //   #762	-> 1617
/*      */     //   #765	-> 1618
/*      */     //   #765	-> 1629
/*      */     //   #767	-> 1632
/*      */     //   #781	-> 1748
/*      */     //   #858	-> 1762
/*      */     //   #811	-> 1776
/*      */     //   #768	-> 1790
/*      */     //   #784	-> 1804
/*      */     //   #775	-> 1818
/*      */     //   #771	-> 1832
/*      */     //   #769	-> 1846
/*      */     //   #771	-> 1920
/*      */     //   #772	-> 1920
/*      */     //   #773	-> 1934
/*      */     //   #771	-> 1974
/*      */     //   #776	-> 1980
/*      */     //   #777	-> 1998
/*      */     //   #778	-> 2030
/*      */     //   #779	-> 2076
/*      */     //   #782	-> 2097
/*      */     //   #785	-> 2176
/*      */     //   #786	-> 2181
/*      */     //   #787	-> 2184
/*      */     //   #788	-> 2187
/*      */     //   #789	-> 2187
/*      */     //   #790	-> 2257
/*      */     //   #791	-> 2349
/*      */     //   #788	-> 2419
/*      */     //   #793	-> 2422
/*      */     //   #794	-> 2445
/*      */     //   #795	-> 2489
/*      */     //   #796	-> 2540
/*      */     //   #797	-> 2546
/*      */     //   #798	-> 2555
/*      */     //   #799	-> 2564
/*      */     //   #800	-> 2578
/*      */     //   #801	-> 2586
/*      */     //   #802	-> 2594
/*      */     //   #803	-> 2608
/*      */     //   #804	-> 2617
/*      */     //   #805	-> 2625
/*      */     //   #806	-> 2639
/*      */     //   #807	-> 2647
/*      */     //   #808	-> 2661
/*      */     //   #809	-> 2664
/*      */     //   #812	-> 2670
/*      */     //   #813	-> 2681
/*      */     //   #814	-> 2696
/*      */     //   #816	-> 2705
/*      */     //   #817	-> 2710
/*      */     //   #819	-> 2720
/*      */     //   #820	-> 2727
/*      */     //   #821	-> 2727
/*      */     //   #822	-> 2737
/*      */     //   #823	-> 2740
/*      */     //   #824	-> 2746
/*      */     //   #825	-> 2752
/*      */     //   #826	-> 2758
/*      */     //   #827	-> 2764
/*      */     //   #828	-> 2770
/*      */     //   #829	-> 2779
/*      */     //   #830	-> 2788
/*      */     //   #831	-> 2797
/*      */     //   #832	-> 2806
/*      */     //   #833	-> 2812
/*      */     //   #835	-> 2816
/*      */     //   #836	-> 2834
/*      */     //   #837	-> 2855
/*      */     //   #838	-> 2872
/*      */     //   #839	-> 2944
/*      */     //   #840	-> 3022
/*      */     //   #841	-> 3094
/*      */     //   #842	-> 3105
/*      */     //   #843	-> 3109
/*      */     //   #844	-> 3124
/*      */     //   #844	-> 3178
/*      */     //   #845	-> 3202
/*      */     //   #846	-> 3235
/*      */     //   #846	-> 3272
/*      */     //   #846	-> 3321
/*      */     //   #843	-> 3326
/*      */     //   #848	-> 3332
/*      */     //   #850	-> 3335
/*      */     //   #851	-> 3339
/*      */     //   #852	-> 3345
/*      */     //   #853	-> 3351
/*      */     //   #854	-> 3357
/*      */     //   #855	-> 3363
/*      */     //   #856	-> 3369
/*      */     //   #859	-> 3375
/*      */     //   #860	-> 3381
/*      */     //   #863	-> 3386
/*      */     //   #864	-> 3395
/*      */     //   #865	-> 3410
/*      */     //   #866	-> 3419
/*      */     //   #868	-> 3426
/*      */     //   #869	-> 3426
/*      */     //   #868	-> 3459
/*      */     //   #870	-> 3461
/*      */     //   #871	-> 3472
/*      */     //   #873	-> 3487
/*      */     //   #874	-> 3499
/*      */     //   #876	-> 3499
/*      */     //   #877	-> 3506
/*      */     //   #878	-> 3514
/*      */     //   #881	-> 3534
/*      */     //   #883	-> 3549
/*      */     //   #884	-> 3584
/*      */     //   #885	-> 3619
/*      */     //   #886	-> 3619
/*      */     //   #885	-> 3684
/*      */     //   #887	-> 3686
/*      */     //   #888	-> 3686
/*      */     //   #887	-> 3751
/*      */     //   #889	-> 3753
/*      */     //   #890	-> 3753
/*      */     //   #889	-> 3818
/*      */     //   #892	-> 3820
/*      */     //   #894	-> 3836
/*      */     //   #895	-> 3836
/*      */     //   #894	-> 3883
/*      */     //   #897	-> 3885
/*      */     //   #898	-> 3902
/*      */     //   #899	-> 3910
/*      */     //   #902	-> 3911
/*      */     //   #903	-> 3922
/*      */     //   #904	-> 3941
/*      */     //   #905	-> 3953
/*      */     //   #907	-> 3965
/*      */     //   #910	-> 3970
/*      */     //   #911	-> 3970
/*      */     //   #912	-> 3984
/*      */     //   #913	-> 3998
/*      */     //   #910	-> 4012
/*      */     //   #916	-> 4015
/*      */     //   #918	-> 4020
/*      */     //   #919	-> 4035
/*      */     //   #920	-> 4049
/*      */     //   #921	-> 4062
/*      */     //   #922	-> 4075
/*      */     //   #923	-> 4085
/*      */     //   #924	-> 4102
/*      */     //   #925	-> 4129
/*      */     //   #918	-> 4143
/*      */     //   #928	-> 4149
/*      */     //   #930	-> 4152
/*      */     //   #932	-> 4192
/*      */     //   #935	-> 4196
/*      */     //   #937	-> 4196
/*      */     //   #938	-> 4196
/*      */     //   #937	-> 4203
/*      */     //   #938	-> 4233
/*      */     //   #939	-> 4249
/*      */     //   #940	-> 4262
/*      */     //   #941	-> 4269
/*      */     //   #943	-> 4302
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   543	75	6	i	I
/*      */     //   1188	97	6	i	I
/*      */     //   1388	93	6	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */     //   1391	90	7	$i$f$getCancelRun	I
/*      */     //   1998	96	7	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2555	112	9	c	Lorg/lwjgl/util/glu/Cylinder;
/*      */     //   2184	483	8	side	I
/*      */     //   2181	486	7	radius	F
/*      */     //   3202	124	24	rainbow	Ljava/awt/Color;
/*      */     //   3124	205	22	i	I
/*      */     //   3094	278	20	z	D
/*      */     //   3022	350	18	y	D
/*      */     //   2944	428	16	x	D
/*      */     //   2872	500	14	height	D
/*      */     //   2855	517	12	radius	D
/*      */     //   2834	538	11	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2705	667	9	drawPercent	D
/*      */     //   2696	676	8	drawMode	Z
/*      */     //   2681	691	7	drawTime	I
/*      */     //   3461	23	10	weird	J
/*      */     //   4075	68	32	posZ2	D
/*      */     //   4062	81	30	posX2	D
/*      */     //   4049	94	28	calc	D
/*      */     //   4035	111	26	i	I
/*      */     //   3965	231	25	b	F
/*      */     //   3953	243	24	g	F
/*      */     //   3941	255	23	r	F
/*      */     //   3922	274	22	colour	Ljava/awt/Color;
/*      */     //   3885	311	20	deltaY	D
/*      */     //   3820	376	18	posZ	D
/*      */     //   3753	443	16	posY	D
/*      */     //   3686	510	14	posX	D
/*      */     //   3619	577	12	height	D
/*      */     //   3584	612	10	radius	D
/*      */     //   3386	810	9	$fun$easeInOutQuart$5	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$5;
/*      */     //   3381	815	7	lastY	D
/*      */     //   30	4273	5	$fun$getColor$4	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$4;
/*      */     //   20	4283	4	$fun$pre3D$3	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$3;
/*      */     //   15	4288	3	$fun$drawCircle$2	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$2;
/*      */     //   11	4292	2	$fun$post3D$1	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$onRender3D$1;
/*      */     //   0	4303	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/* 1597 */     //   0	4303	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent; } private final void updateTarget() { this.target = (IEntityLivingBase)null; int hurtTime = ((Number)this.hurtTimeValue.get()).intValue(); float fov = ((Number)this.fovValue.get()).floatValue(); boolean switchMode = StringsKt.equals((String)this.targetModeValue.get(), "Switch", true); boolean bool1 = false; List<IEntityLivingBase> targets = new ArrayList(); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IWorldClient theWorld = MinecraftInstance.mc.getTheWorld(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer(); for (IEntity entity : theWorld.getLoadedEntityList()) { if (!MinecraftInstance.classProvider.isEntityLivingBase(entity) || !isEnemy(entity) || (switchMode && this.prevTargetEntities.contains(Integer.valueOf(entity.getEntityId())))) continue;  double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity); double entityFov = RotationUtils.getRotationDifference(entity); if (distance <= getMaxRange() && (fov == 180.0F || entityFov <= fov) && entity.asEntityLivingBase().getHurtTime() <= hurtTime) targets.add(entity.asEntityLivingBase());  }  String str = (String)this.priorityValue.get(); boolean bool2 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 288459765: if (str.equals("distance")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura3$updateTarget$$inlined$sortBy$1 killAura3$updateTarget$$inlined$sortBy$1 = new KillAura3$updateTarget$$inlined$sortBy$1(thePlayer); CollectionsKt.sortWith(list1, killAura3$updateTarget$$inlined$sortBy$1); }  }  break;
/*      */       case -1221262756:
/* 1599 */         if (str.equals("health")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura3$updateTarget$$inlined$sortBy$2 killAura3$updateTarget$$inlined$sortBy$2 = new KillAura3$updateTarget$$inlined$sortBy$2(); CollectionsKt.sortWith(list1, killAura3$updateTarget$$inlined$sortBy$2); }
/*      */            }
/*      */          break;
/*      */       case 886905078:
/* 1603 */         if (str.equals("livingtime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura3$updateTarget$$inlined$sortBy$4 killAura3$updateTarget$$inlined$sortBy$4 = new KillAura3$updateTarget$$inlined$sortBy$4(); CollectionsKt.sortWith(list1, killAura3$updateTarget$$inlined$sortBy$4); }  }  break;
/*      */       case 525193846:
/* 1605 */         if (str.equals("HurtResitanTime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura3$updateTarget$$inlined$sortBy$5 killAura3$updateTarget$$inlined$sortBy$5 = new KillAura3$updateTarget$$inlined$sortBy$5(); CollectionsKt.sortWith(list1, killAura3$updateTarget$$inlined$sortBy$5); }  }  break;case -962590849: if (str.equals("direction")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura3$updateTarget$$inlined$sortBy$3 killAura3$updateTarget$$inlined$sortBy$3 = new KillAura3$updateTarget$$inlined$sortBy$3(); CollectionsKt.sortWith(list1, killAura3$updateTarget$$inlined$sortBy$3); }  }  break; }  for (IEntityLivingBase entity : targets) { if (!updateRotations((IEntity)entity)) continue;  this.target = entity; return; }  List<Integer> list = this.prevTargetEntities; bool2 = false; if (!list.isEmpty()) { this.prevTargetEntities.clear(); updateTarget(); }  } private final boolean isEnemy(IEntity entity) { if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && entity != null && (EntityUtils.targetDead || isAlive(entity.asEntityLivingBase())) && (Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0) { if (!EntityUtils.targetInvisible && entity.isInvisible()) return false;  if (EntityUtils.targetPlayer && MinecraftInstance.classProvider.isEntityPlayer(entity)) { IEntityPlayer player = entity.asEntityPlayer(); if (player.isSpectator() || AntiBot.isBot((IEntityLivingBase)player)) return false;  if (PlayerExtensionKt.isClientFriend(player) && !Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState()) return false;  if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams");  Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class); return (!teams.getState() || !teams.isInYourTeam(entity.asEntityLivingBase())); }  return ((EntityUtils.targetMobs && PlayerExtensionKt.isMob(entity)) || (EntityUtils.targetAnimals && PlayerExtensionKt.isAnimal(entity))); }  return false; } private final void attackEntity(IEntityLivingBase entity) { // Byte code:
/*      */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   8: dup
/*      */     //   9: ifnonnull -> 15
/*      */     //   12: invokestatic throwNpe : ()V
/*      */     //   15: astore_2
/*      */     //   16: aload_0
/*      */     //   17: getfield autoBlockPacketValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   20: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   23: checkcast java/lang/String
/*      */     //   26: ldc_w 'Vanilla'
/*      */     //   29: iconst_1
/*      */     //   30: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   33: ifne -> 128
/*      */     //   36: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   39: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   44: dup
/*      */     //   45: ifnonnull -> 51
/*      */     //   48: invokestatic throwNpe : ()V
/*      */     //   51: invokeinterface isBlocking : ()Z
/*      */     //   56: ifne -> 66
/*      */     //   59: aload_0
/*      */     //   60: getfield blockingStatus : Z
/*      */     //   63: ifeq -> 128
/*      */     //   66: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   69: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   74: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   77: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*      */     //   80: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*      */     //   83: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   86: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   89: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   92: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   97: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*      */     //   102: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   107: aload_0
/*      */     //   108: getfield afterAttackValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   111: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   114: checkcast java/lang/Boolean
/*      */     //   117: invokevirtual booleanValue : ()Z
/*      */     //   120: ifeq -> 128
/*      */     //   123: aload_0
/*      */     //   124: iconst_0
/*      */     //   125: putfield blockingStatus : Z
/*      */     //   128: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   131: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*      */     //   134: new net/ccbluex/liquidbounce/event/AttackEvent
/*      */     //   137: dup
/*      */     //   138: aload_1
/*      */     //   139: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   142: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   145: checkcast net/ccbluex/liquidbounce/event/Event
/*      */     //   148: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*      */     //   151: nop
/*      */     //   152: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   155: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   160: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   163: aload_1
/*      */     //   164: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   167: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*      */     //   170: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*      */     //   175: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   178: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   183: nop
/*      */     //   184: aload_2
/*      */     //   185: invokeinterface swingItem : ()V
/*      */     //   190: aload_0
/*      */     //   191: getfield keepSprintValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   194: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   197: checkcast java/lang/Boolean
/*      */     //   200: invokevirtual booleanValue : ()Z
/*      */     //   203: ifeq -> 318
/*      */     //   206: aload_2
/*      */     //   207: invokeinterface getFallDistance : ()F
/*      */     //   212: fconst_0
/*      */     //   213: fcmpl
/*      */     //   214: ifle -> 283
/*      */     //   217: aload_2
/*      */     //   218: invokeinterface getOnGround : ()Z
/*      */     //   223: ifne -> 283
/*      */     //   226: aload_2
/*      */     //   227: invokeinterface isOnLadder : ()Z
/*      */     //   232: ifne -> 283
/*      */     //   235: aload_2
/*      */     //   236: invokeinterface isInWater : ()Z
/*      */     //   241: ifne -> 283
/*      */     //   244: aload_2
/*      */     //   245: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   248: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.BLINDNESS : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*      */     //   251: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*      */     //   256: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*      */     //   261: ifne -> 283
/*      */     //   264: aload_2
/*      */     //   265: invokeinterface isRiding : ()Z
/*      */     //   270: ifne -> 283
/*      */     //   273: aload_2
/*      */     //   274: aload_1
/*      */     //   275: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   278: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   283: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*      */     //   286: aload_2
/*      */     //   287: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   292: aload_1
/*      */     //   293: invokeinterface getCreatureAttribute : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;
/*      */     //   298: invokeinterface getModifierForCreature : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;)F
/*      */     //   303: fconst_0
/*      */     //   304: fcmpl
/*      */     //   305: ifle -> 347
/*      */     //   308: aload_2
/*      */     //   309: aload_1
/*      */     //   310: invokeinterface onEnchantmentCritical : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*      */     //   315: goto -> 347
/*      */     //   318: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   321: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   326: invokeinterface getCurrentGameType : ()Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;
/*      */     //   331: getstatic net/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType.SPECTATOR : Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;
/*      */     //   334: if_acmpeq -> 347
/*      */     //   337: aload_2
/*      */     //   338: aload_1
/*      */     //   339: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   342: invokeinterface attackTargetEntityWithCurrentItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   347: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   350: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   353: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/Criticals
/*      */     //   356: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   359: dup
/*      */     //   360: ifnonnull -> 374
/*      */     //   363: new kotlin/TypeCastException
/*      */     //   366: dup
/*      */     //   367: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Criticals'
/*      */     //   370: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   373: athrow
/*      */     //   374: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/Criticals
/*      */     //   377: astore_3
/*      */     //   378: iconst_0
/*      */     //   379: istore #4
/*      */     //   381: iconst_2
/*      */     //   382: istore #5
/*      */     //   384: iload #4
/*      */     //   386: iload #5
/*      */     //   388: if_icmpgt -> 610
/*      */     //   391: aload_2
/*      */     //   392: invokeinterface getFallDistance : ()F
/*      */     //   397: fconst_0
/*      */     //   398: fcmpl
/*      */     //   399: ifle -> 458
/*      */     //   402: aload_2
/*      */     //   403: invokeinterface getOnGround : ()Z
/*      */     //   408: ifne -> 458
/*      */     //   411: aload_2
/*      */     //   412: invokeinterface isOnLadder : ()Z
/*      */     //   417: ifne -> 458
/*      */     //   420: aload_2
/*      */     //   421: invokeinterface isInWater : ()Z
/*      */     //   426: ifne -> 458
/*      */     //   429: aload_2
/*      */     //   430: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   433: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.BLINDNESS : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*      */     //   436: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*      */     //   441: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*      */     //   446: ifne -> 458
/*      */     //   449: aload_2
/*      */     //   450: invokeinterface getRidingEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*      */     //   455: ifnull -> 516
/*      */     //   458: aload_3
/*      */     //   459: invokevirtual getState : ()Z
/*      */     //   462: ifeq -> 536
/*      */     //   465: aload_3
/*      */     //   466: invokevirtual getMsTimer : ()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   469: aload_3
/*      */     //   470: invokevirtual getDelayValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   473: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   476: checkcast java/lang/Number
/*      */     //   479: invokevirtual intValue : ()I
/*      */     //   482: i2l
/*      */     //   483: invokevirtual hasTimePassed : (J)Z
/*      */     //   486: ifeq -> 536
/*      */     //   489: aload_2
/*      */     //   490: invokeinterface isInWater : ()Z
/*      */     //   495: ifne -> 536
/*      */     //   498: aload_2
/*      */     //   499: invokeinterface isInLava : ()Z
/*      */     //   504: ifne -> 536
/*      */     //   507: aload_2
/*      */     //   508: invokeinterface isInWeb : ()Z
/*      */     //   513: ifne -> 536
/*      */     //   516: aload_2
/*      */     //   517: aload_0
/*      */     //   518: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   521: dup
/*      */     //   522: ifnonnull -> 528
/*      */     //   525: invokestatic throwNpe : ()V
/*      */     //   528: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   531: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   536: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*      */     //   539: aload_2
/*      */     //   540: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   545: aload_0
/*      */     //   546: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   549: dup
/*      */     //   550: ifnonnull -> 556
/*      */     //   553: invokestatic throwNpe : ()V
/*      */     //   556: invokeinterface getCreatureAttribute : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;
/*      */     //   561: invokeinterface getModifierForCreature : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;)F
/*      */     //   566: fconst_0
/*      */     //   567: fcmpl
/*      */     //   568: ifgt -> 587
/*      */     //   571: aload_0
/*      */     //   572: getfield fakeSharpValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   575: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   578: checkcast java/lang/Boolean
/*      */     //   581: invokevirtual booleanValue : ()Z
/*      */     //   584: ifeq -> 604
/*      */     //   587: aload_2
/*      */     //   588: aload_0
/*      */     //   589: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   592: dup
/*      */     //   593: ifnonnull -> 599
/*      */     //   596: invokestatic throwNpe : ()V
/*      */     //   599: invokeinterface onEnchantmentCritical : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*      */     //   604: iinc #4, 1
/*      */     //   607: goto -> 384
/*      */     //   610: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   613: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   618: dup
/*      */     //   619: ifnonnull -> 625
/*      */     //   622: invokestatic throwNpe : ()V
/*      */     //   625: invokeinterface isBlocking : ()Z
/*      */     //   630: ifne -> 660
/*      */     //   633: aload_0
/*      */     //   634: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   637: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   640: checkcast java/lang/String
/*      */     //   643: ldc_w 'off'
/*      */     //   646: iconst_1
/*      */     //   647: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   650: ifne -> 698
/*      */     //   653: aload_0
/*      */     //   654: invokespecial canBlock : ()Z
/*      */     //   657: ifeq -> 698
/*      */     //   660: aload_0
/*      */     //   661: getfield delayedBlockValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   664: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   667: checkcast java/lang/Boolean
/*      */     //   670: invokevirtual booleanValue : ()Z
/*      */     //   673: ifeq -> 677
/*      */     //   676: return
/*      */     //   677: aload_0
/*      */     //   678: aload_1
/*      */     //   679: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   682: aload_0
/*      */     //   683: getfield interactAutoBlockValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   686: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   689: checkcast java/lang/Boolean
/*      */     //   692: invokevirtual booleanValue : ()Z
/*      */     //   695: invokespecial startBlocking : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)V
/*      */     //   698: nop
/*      */     //   699: aload_2
/*      */     //   700: invokeinterface resetCooldown : ()V
/*      */     //   705: nop
/*      */     //   706: aload_1
/*      */     //   707: invokeinterface getHealth : ()F
/*      */     //   712: fstore #4
/*      */     //   714: aload_0
/*      */     //   715: getfield failchange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   718: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   721: checkcast java/lang/Boolean
/*      */     //   724: invokevirtual booleanValue : ()Z
/*      */     //   727: ifeq -> 754
/*      */     //   730: new java/lang/Thread
/*      */     //   733: dup
/*      */     //   734: new net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$attackEntity$1
/*      */     //   737: dup
/*      */     //   738: aload_0
/*      */     //   739: aload_1
/*      */     //   740: fload #4
/*      */     //   742: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;F)V
/*      */     //   745: checkcast java/lang/Runnable
/*      */     //   748: invokespecial <init> : (Ljava/lang/Runnable;)V
/*      */     //   751: invokevirtual start : ()V
/*      */     //   754: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1110	-> 0
/*      */     //   #1112	-> 16
/*      */     //   #1113	-> 66
/*      */     //   #1114	-> 74
/*      */     //   #1115	-> 77
/*      */     //   #1116	-> 80
/*      */     //   #1114	-> 97
/*      */     //   #1113	-> 102
/*      */     //   #1119	-> 107
/*      */     //   #1123	-> 128
/*      */     //   #1126	-> 151
/*      */     //   #1129	-> 152
/*      */     //   #1131	-> 183
/*      */     //   #1132	-> 184
/*      */     //   #1134	-> 190
/*      */     //   #1136	-> 206
/*      */     //   #1137	-> 206
/*      */     //   #1139	-> 273
/*      */     //   #1142	-> 283
/*      */     //   #1143	-> 308
/*      */     //   #1145	-> 318
/*      */     //   #1146	-> 337
/*      */     //   #1147	-> 347
/*      */     //   #1150	-> 347
/*      */     //   #1152	-> 378
/*      */     //   #1154	-> 391
/*      */     //   #1156	-> 391
/*      */     //   #1158	-> 391
/*      */     //   #1154	-> 429
/*      */     //   #1155	-> 430
/*      */     //   #1154	-> 441
/*      */     //   #1156	-> 465
/*      */     //   #1157	-> 469
/*      */     //   #1156	-> 483
/*      */     //   #1160	-> 516
/*      */     //   #1163	-> 536
/*      */     //   #1166	-> 536
/*      */     //   #1163	-> 536
/*      */     //   #1164	-> 539
/*      */     //   #1165	-> 545
/*      */     //   #1163	-> 561
/*      */     //   #1166	-> 571
/*      */     //   #1168	-> 587
/*      */     //   #1152	-> 604
/*      */     //   #1172	-> 610
/*      */     //   #1173	-> 660
/*      */     //   #1174	-> 676
/*      */     //   #1177	-> 677
/*      */     //   #1180	-> 698
/*      */     //   #1181	-> 698
/*      */     //   #1182	-> 699
/*      */     //   #1181	-> 705
/*      */     //   #1184	-> 706
/*      */     //   #1185	-> 714
/*      */     //   #1186	-> 730
/*      */     //   #1205	-> 730
/*      */     //   #1186	-> 730
/*      */     //   #1205	-> 751
/*      */     //   #1207	-> 754
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   391	216	4	i	I
/*      */     //   714	41	4	starthealth	F
/*      */     //   378	377	3	criticals	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;
/*      */     //   16	739	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	755	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */     //   0	755	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class KillAura3$attackEntity$1 implements Runnable {
/*      */     public final void run() { Thread.sleep(100L); if (this.$entity.getHurtTime() == 0 && this.$entity.getHealth() == this.$starthealth) { KillAura3.this.setFailcount(KillAura3.this.getFailcount() + 1); if (((Boolean)KillAura3.this.getFaildebug().get()).booleanValue()) { if (this.$entity.getDisplayName() == null) Intrinsics.throwNpe();  Chat.print("Fail Attack " + this.$entity.getDisplayName().getFormattedText()); Chat.print("单位时间内以空刀" + String.valueOf(KillAura3.this.getFailcount()) + "次"); }  if (!KillAura3.this.getFailstatus() && KillAura3.this.getFailcount() >= ((Number)KillAura3.this.getFailcountvalue().get()).intValue()) { KillAura3.this.setKarange(((Number)KillAura3.this.getRangeValue().get()).floatValue()); if (((Boolean)KillAura3.this.getFaildebug().get()).booleanValue()) Chat.print("记录杀戮距离" + String.valueOf(KillAura3.this.getKarange()));  KillAura3.this.setFailstatus(true); }  }  } KillAura3$attackEntity$1(IEntityLivingBase param1IEntityLivingBase, float param1Float) {} } private final boolean updateRotations(IEntity entity) { IAxisAlignedBB boundingBox = entity.getEntityBoundingBox(); (new float[2])[0] = ((Number)this.minPredictSize.get()).floatValue(); (new float[2])[1] = ((Number)this.maxPredictSize.get()).floatValue(); (new float[2])[0] = 0.0F; (new float[2])[1] = 0.0F; float[] predictSize = ((Boolean)this.predictValue.get()).booleanValue() ? new float[2] : new float[2]; if (StringsKt.equals((String)this.rotations.get(), "HYT", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX() - MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(predictSize[0], predictSize[1]), (entity.getPosY() - entity.getPrevPosY() - MinecraftInstance.mc.getThePlayer().getPosY() - MinecraftInstance.mc.getThePlayer().getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(predictSize[0], predictSize[1]), (entity.getPosZ() - entity.getPrevPosZ() - MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(predictSize[0], predictSize[1])); }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.hyt(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.hyt(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.hyt(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "Test", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "HytRotation", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "Down", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView2(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView2(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView2(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "LiquidBounce", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 wVec3 = vecRotation.component1(); Rotation rotation = vecRotation.component2(); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "BackTrack", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.OtherRotation(boundingBox, RotationUtils.getCenter(entity.getEntityBoundingBox()), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())), "RotationUtils.limitAngle…rnSpeed.get()).toFloat())"); Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.OtherRotation(boundingBox, RotationUtils.getCenter(entity.getEntityBoundingBox()), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())); if (((Boolean)this.silentRotationValue.get()).booleanValue()) { RotationUtils.setTargetRotation(limitedRotation, ((Boolean)this.aacValue.get()).booleanValue() ? 15 : 0); } else { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  limitedRotation.toPlayer((IEntityPlayer)MinecraftInstance.mc.getThePlayer()); return true; }  }  return true; } private final void updateHitable() { if (((Boolean)this.hitableValue.get()).booleanValue()) { this.hitable = true; return; }  if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) { this.hitable = true; return; }  double d1 = getMaxRange(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.target == null) Intrinsics.throwNpe();  double d2 = PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)this.target); boolean bool = false; double reach = Math.min(d1, d2) + true; if (((Boolean)this.raycastValue.get()).booleanValue()) { IEntity raycastedEntity = RaycastUtils.raycastEntity(reach, new KillAura3$updateHitable$raycastedEntity$1()); if (((Boolean)this.raycastValue.get()).booleanValue() && raycastedEntity != null && MinecraftInstance.classProvider.isEntityLivingBase(raycastedEntity) && (Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState() || !MinecraftInstance.classProvider.isEntityPlayer(raycastedEntity) || !PlayerExtensionKt.isClientFriend(raycastedEntity.asEntityPlayer()))) this.currentTarget = raycastedEntity.asEntityLivingBase();  this.hitable = (((Number)this.maxTurnSpeed.get()).floatValue() > 0.0F) ? Intrinsics.areEqual(this.currentTarget, raycastedEntity) : true; } else { this.hitable = RotationUtils.isFaced((IEntity)this.currentTarget, reach); }  } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$updateHitable$raycastedEntity$1", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"}) public static final class KillAura3$updateHitable$raycastedEntity$1 implements RaycastUtils.EntityFilter {
/*      */     public boolean canRaycast(@Nullable IEntity entity) { // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */       //   4: invokestatic access$getLivingRaycastValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;)Lnet/ccbluex/liquidbounce/value/BoolValue;
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
/*      */       //   44: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */       //   47: aload_1
/*      */       //   48: invokestatic access$isEnemy : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */       //   51: ifne -> 146
/*      */       //   54: aload_0
/*      */       //   55: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */       //   58: invokestatic access$getRaycastIgnoredValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */       //   61: invokevirtual get : ()Ljava/lang/Object;
/*      */       //   64: checkcast java/lang/Boolean
/*      */       //   67: invokevirtual booleanValue : ()Z
/*      */       //   70: ifne -> 146
/*      */       //   73: aload_0
/*      */       //   74: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;
/*      */       //   77: invokestatic access$getAacValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3;)Lnet/ccbluex/liquidbounce/value/BoolValue;
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
/*      */       //   #1402	-> 0
/*      */       //   #1403	-> 0
/*      */       //   #1402	-> 0
/*      */       //   #1403	-> 47
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	152	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura3$updateHitable$raycastedEntity$1;
/*      */       //   0	152	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity; } }
/* 1608 */   private final void startBlocking(IEntity interactEntity, boolean interact) { if (StringsKt.equals((String)this.autoBlockValue.get(), "GrimAC", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), interactEntity) > ((Number)this.BlockRangeValue.get()).doubleValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() instanceof net.minecraft.item.ItemSword) if (MinecraftInstance.mc2.field_71439_g.field_110158_av == -1) { PacketUtils.sendPacketNoEvent((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -1, -1), EnumFacing.DOWN)); } else if (MinecraftInstance.mc2.field_71439_g.field_110158_av < 0.5D && MinecraftInstance.mc2.field_71439_g.field_110158_av != -1) { PacketUtils.sendPacketNoEvent((Packet)new CPacketPlayerTryUseItemOnBlock(new BlockPos(-1, -1, -1), EnumFacing.WEST, EnumHand.MAIN_HAND, 0.0F, 0.0F, 0.0F)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  WEnumHand wEnumHand1 = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getThePlayer().getSendQueue(); int $i$f$createUseItemPacket = 0; IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand1); iINetHandlerPlayClient.addToSendQueue(iPacket); if (MinecraftInstance.mc.getThePlayer() == null)
/*      */                 Intrinsics.throwNpe();  WEnumHand hand$iv = WEnumHand.OFF_HAND; iINetHandlerPlayClient = MinecraftInstance.mc.getThePlayer().getSendQueue(); $i$f$createUseItemPacket = 0;
/* 1610 */               iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand$iv); iINetHandlerPlayClient.addToSendQueue(iPacket); }   }  }  }  if (this.autoBlockValue.equals("Range")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), interactEntity) > ((Number)this.BlockRangeValue.get()).doubleValue()) return;  }  if (this.blockingStatus) return;  if (interact) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, interactEntity.getPositionVector())); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, ICPacketUseEntity.WAction.INTERACT)); }  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "UseItem", true)) KeyBinding.func_74510_a(MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().getKeyCode(), true);  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "GameSettings", true)) MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(true);  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Mouse", true))
/*      */       (new Robot()).mousePress(4096);  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Vanilla", true)) { if (StringsKt.equals((String)this.vanillamode.get(), "TryUseItem", true)) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.MAIN_HAND)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.OFF_HAND)); }  if (StringsKt.equals((String)this.vanillamode.get(), "UseItem", true)) { if (MinecraftInstance.mc.getThePlayer() == null)
/* 1612 */           Intrinsics.throwNpe();  IItemStack iItemStack1 = MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand(); WEnumHand wEnumHand1 = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createUseItemPacket = 0; IPacket iPacket = 
/*      */ 
/*      */           
/* 1615 */           (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand1); iINetHandlerPlayClient.addToSendQueue(iPacket); if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe();  IItemStack itemStack$iv = MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand(); WEnumHand hand$iv = WEnumHand.OFF_HAND; iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); $i$f$createUseItemPacket = 0;
/* 1617 */         iPacket = 
/*      */ 
/*      */           
/* 1620 */           (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand$iv);
/*      */         iINetHandlerPlayClient.addToSendQueue(iPacket); }
/*      */       
/*      */       if (StringsKt.equals((String)this.vanillamode.get(), "OldC08", true)) {
/*      */         if (MinecraftInstance.mc.getThePlayer() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(new WBlockPos(-0.5534147541D, -0.5534147541D, -0.5534147541D), 255, MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand(), 0.0F, 0.0F, 0.0F));
/*      */       } 
/*      */       if (StringsKt.equals((String)this.vanillamode.get(), "CPacketPlayerBlockPlacement", true)) {
/*      */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*      */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
/*      */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*      */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
/*      */       }  }
/*      */     
/*      */     this.blockingStatus = true; }
/*      */ 
/*      */   
/*      */   private final void stopBlocking() {
/*      */     if (this.blockingStatus) {
/*      */       if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Vanilla", true))
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, MovementUtils.isMoving() ? new WBlockPos(-1, -1, -1) : WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN))); 
/*      */       if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "UseItem", true))
/*      */         KeyBinding.func_74510_a(MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().getKeyCode(), false); 
/*      */       if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "GameSettings", true))
/*      */         MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(false); 
/*      */       if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Mouse", true))
/*      */         (new Robot()).mouseRelease(4096); 
/*      */       if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Vanilla", true))
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN))); 
/*      */       this.blockingStatus = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private final boolean getCancelRun() {
/*      */     int $i$f$getCancelRun = 0;
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (!MinecraftInstance.mc.getThePlayer().isSpectator()) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (!isAlive((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) || Retreat.INSTANCE.getModuleManager().get(Blink.class).getState() || Retreat.INSTANCE.getModuleManager().get(FreeCam.class).getState());
/*      */       return false;
/*      */     } 
/*      */   }
/*      */   
/*      */   private final boolean isAlive(IEntityLivingBase entity) {
/*      */     return ((entity.isEntityAlive() && entity.getHealth() > false) || (((Boolean)this.aacValue.get()).booleanValue() && entity.getHurtTime() > 5));
/*      */   }
/*      */   
/*      */   private final boolean canBlock() {
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (MinecraftInstance.classProvider.isItemSword(MinecraftInstance.mc.getThePlayer().getHeldItem().getItem()))
/*      */         if (((Boolean)this.autoBlockFacing.get()).booleanValue()) {
/*      */           if (this.target == null)
/*      */             Intrinsics.throwNpe(); 
/*      */           if (MinecraftInstance.mc.getThePlayer() == null)
/*      */             Intrinsics.throwNpe(); 
/*      */           if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)this.target, (IEntity)MinecraftInstance.mc.getThePlayer()) < getMaxRange()) {
/*      */             if (this.target == null)
/*      */               Intrinsics.throwNpe(); 
/*      */             if (this.target.rayTrace(getMaxRange(), 1.0F) == null)
/*      */               Intrinsics.throwNpe(); 
/*      */             return (this.target.rayTrace(getMaxRange(), 1.0F).getTypeOfHit() != IMovingObjectPosition.WMovingObjectType.MISS);
/*      */           } 
/*      */         }  
/*      */     } 
/*      */     return false;
/*      */   }
/*      */   
/*      */   private final float getMaxRange() {
/*      */     float f1 = ((Number)this.rangeValue.get()).floatValue(), f2 = ((Number)this.throughWallsRangeValue.get()).floatValue();
/*      */     boolean bool = false;
/*      */     return Math.max(f1, f2);
/*      */   }
/*      */   
/*      */   private final float getRange(IEntity entity) {
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     return ((PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) >= ((Number)this.throughWallsRangeValue.get()).doubleValue()) ? ((Number)this.rangeValue.get()).floatValue() : ((Number)this.rangeValue.get()).floatValue()) - (MinecraftInstance.mc.getThePlayer().getSprinting() ? ((Number)this.rangeSprintReducementValue.get()).floatValue() : 0.0F);
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\KillAura3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */