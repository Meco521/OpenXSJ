/*      */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.awt.Robot;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import kotlin.Metadata;
/*      */ import kotlin.TypeCastException;
/*      */ import kotlin.Unit;
/*      */ import kotlin.collections.CollectionsKt;
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
/*      */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*      */ import net.ccbluex.liquidbounce.event.EntityMovementEvent;
/*      */ import net.ccbluex.liquidbounce.event.EventState;
/*      */ import net.ccbluex.liquidbounce.event.EventTarget;
/*      */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*      */ import net.ccbluex.liquidbounce.event.MoveEvent;
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
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.world.GroundTelly;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold2;
/*      */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*      */ import net.ccbluex.liquidbounce.script.api.global.Chat;
/*      */ import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
/*      */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.VecRotation;
/*      */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*      */ import net.ccbluex.liquidbounce.utils.misc.PacketUtils;
/*      */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.BlendUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import net.ccbluex.liquidbounce.value.Value;
/*      */ import net.minecraft.client.settings.KeyBinding;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*      */ import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
/*      */ import net.minecraft.realms.RealmsMth;
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
/*      */ @ModuleInfo(name = "KillAura", description = "Automatically attacks targets around you. ", category = ModuleCategory.COMBAT)
/*      */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000¶\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\007\n\000\n\002\020\t\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\013\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\031\n\002\030\002\n\002\b\005\n\002\020\006\n\002\b\034\n\002\030\002\n\002\b\030\n\002\030\002\n\002\b\023\n\002\020!\n\002\b*\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\b\007\030\000 Ñ\0012\0020\001:\002Ñ\001B\005¢\006\002\020\002J\022\020°\001\032\0030±\0012\006\020>\032\00206H\002J\t\020²\001\032\0020\024H\002J\022\020³\001\032\0020\r2\007\020>\032\0030´\001H\002J\021\020µ\001\032\0020\0242\006\020>\032\00206H\002J\024\020¶\001\032\0020\0242\t\020>\032\005\030\0010´\001H\002J\n\020·\001\032\0030±\001H\026J\n\020¸\001\032\0030±\001H\026J\024\020¹\001\032\0030±\0012\b\020º\001\032\0030»\001H\007J\024\020¼\001\032\0030±\0012\b\020º\001\032\0030½\001H\007J\024\020¾\001\032\0030±\0012\b\020º\001\032\0030¿\001H\007J\024\020À\001\032\0030±\0012\b\020º\001\032\0030Á\001H\007J\024\020Â\001\032\0030±\0012\b\020º\001\032\0030Ã\001H\007J\026\020Ä\001\032\0030±\0012\n\020º\001\032\005\030\0010Å\001H\007J\024\020Æ\001\032\0030±\0012\b\020º\001\032\0030Ç\001H\007J\n\020È\001\032\0030±\001H\002J\035\020É\001\032\0030±\0012\b\020Ê\001\032\0030´\0012\007\020Ë\001\032\0020\024H\002J\n\020Ì\001\032\0030±\001H\002J\b\020Í\001\032\0030±\001J\n\020Î\001\032\0030±\001H\002J\022\020Ï\001\032\0020\0242\007\020>\032\0030´\001H\002J\n\020Ð\001\032\0030±\001H\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\004X\004¢\006\002\n\000R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\n\020\013R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\024\020\022\032\b\022\004\022\0020\0240\023X\004¢\006\002\n\000R\024\020\025\032\b\022\004\022\0020\0260\023X\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\020\020\031\032\004\030\0010\032X\016¢\006\002\n\000R\021\020\033\032\0020\034¢\006\b\n\000\032\004\b\035\020\036R\016\020\037\032\0020\tX\016¢\006\002\n\000R\027\020 \032\b\022\004\022\0020\r0\023¢\006\b\n\000\032\004\b!\020\"R\024\020#\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\032\020$\032\0020\024X\016¢\006\016\n\000\032\004\b%\020&\"\004\b'\020(R\016\020)\032\0020\tX\004¢\006\002\n\000R\025\020*\032\0020\0248Â\002X\004¢\006\006\032\004\b+\020&R\024\020,\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\024\020-\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\016\020.\032\0020\004X\004¢\006\002\n\000R\016\020/\032\0020\034X\016¢\006\002\n\000R\024\0200\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\024\0201\032\b\022\004\022\0020\0260\023X\004¢\006\002\n\000R\024\0202\032\b\022\004\022\0020\0240\023X\004¢\006\002\n\000R\016\0203\032\0020\017X\016¢\006\002\n\000R\016\0204\032\0020\tX\004¢\006\002\n\000R\034\0205\032\004\030\00106X\016¢\006\016\n\000\032\004\b7\0208\"\004\b9\020:R\016\020;\032\0020<X\016¢\006\002\n\000R\016\020=\032\0020\026X\016¢\006\002\n\000R\020\020>\032\004\030\00106X\016¢\006\002\n\000R\016\020?\032\0020<X\016¢\006\002\n\000R\016\020@\032\0020\tX\016¢\006\002\n\000R\016\020A\032\0020\tX\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\032\020C\032\0020\034X\016¢\006\016\n\000\032\004\bD\020\036\"\004\bE\020FR\024\020G\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\024\020H\032\b\022\004\022\0020\0240\023X\004¢\006\002\n\000R\024\020I\032\b\022\004\022\0020\r0\023X\004¢\006\002\n\000R\032\020J\032\0020\024X\016¢\006\016\n\000\032\004\bK\020&\"\004\bL\020(R\024\020M\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\016\020N\032\0020\004X\004¢\006\002\n\000R\016\020O\032\0020\004X\004¢\006\002\n\000R\016\020P\032\0020\tX\004¢\006\002\n\000R\021\020Q\032\0020\t¢\006\b\n\000\032\004\bR\020\013R\032\020S\032\0020\024X\016¢\006\016\n\000\032\004\bT\020&\"\004\bU\020(R\016\020V\032\0020\024X\016¢\006\002\n\000R\016\020W\032\0020\004X\004¢\006\002\n\000R\021\020X\032\0020Y¢\006\b\n\000\032\004\bZ\020[R\021\020\\\032\0020\004¢\006\b\n\000\032\004\b]\020\006R\024\020^\032\b\022\004\022\0020\0240\023X\004¢\006\002\n\000R\021\020_\032\0020\0248F¢\006\006\032\004\b_\020&R\016\020`\032\0020\024X\016¢\006\002\n\000R\024\020a\032\b\022\004\022\0020\r0\023X\004¢\006\002\n\000R\024\020b\032\b\022\004\022\0020\r0\023X\004¢\006\002\n\000R\024\020c\032\b\022\004\022\0020\r0\023X\004¢\006\002\n\000R\024\020d\032\b\022\004\022\0020\r0\023X\004¢\006\002\n\000R\032\020e\032\0020\rX\016¢\006\016\n\000\032\004\bf\020g\"\004\bh\020iR\021\020j\032\0020\004¢\006\b\n\000\032\004\bk\020\006R\016\020l\032\0020\017X\016¢\006\002\n\000R\016\020m\032\0020\017X\016¢\006\002\n\000R\020\020n\032\004\030\00106X\016¢\006\002\n\000R\024\020o\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\016\020p\032\0020\004X\004¢\006\002\n\000R\020\020q\032\004\030\0010rX\016¢\006\002\n\000R\016\020s\032\0020\021X\004¢\006\002\n\000R\016\020t\032\0020\030X\004¢\006\002\n\000R\021\020u\032\0020Y¢\006\b\n\000\032\004\bv\020[R\016\020w\032\0020\tX\004¢\006\002\n\000R\024\020x\032\0020\r8BX\004¢\006\006\032\004\by\020gR\016\020z\032\0020\tX\004¢\006\002\n\000R\021\020{\032\0020Y¢\006\b\n\000\032\004\b|\020[R\016\020}\032\0020\tX\004¢\006\002\n\000R\016\020~\032\0020\tX\004¢\006\002\n\000R\016\020\032\0020\004X\004¢\006\002\n\000R\025\020\001\032\b\022\004\022\0020\0340\023X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\026\020\001\032\t\022\004\022\0020\0340\001X\004¢\006\002\n\000R\017\020\001\032\0020\030X\004¢\006\002\n\000R\017\020\001\032\0020<X\016¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\tX\004¢\006\002\n\000R\023\020\001\032\0020\t¢\006\t\n\000\032\005\b\001\020\013R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\024\020\001\032\0020\030¢\006\n\n\000\032\006\b\001\020\001R\017\020\001\032\0020\030X\004¢\006\002\n\000R\017\020\001\032\0020\tX\004¢\006\002\n\000R\017\020\001\032\0020\tX\016¢\006\002\n\000R\023\020\001\032\0020\004¢\006\t\n\000\032\005\b\001\020\006R\036\020\001\032\0020\004X\016¢\006\021\n\000\032\005\b\001\020\006\"\006\b\001\020\001R\035\020\001\032\0020\024X\016¢\006\020\n\000\032\005\b\001\020&\"\005\b\001\020(R\025\020\001\032\b\022\004\022\0020\0240\023X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\023\020 \001\032\0020Y¢\006\t\n\000\032\005\b¡\001\020[R\017\020¢\001\032\0020\021X\004¢\006\002\n\000R\037\020£\001\032\004\030\00106X\016¢\006\020\n\000\032\005\b¤\001\0208\"\005\b¥\001\020:R\027\020¦\001\032\0020\0268VX\004¢\006\b\032\006\b§\001\020¨\001R\037\020©\001\032\004\030\00106X\016¢\006\020\n\000\032\005\bª\001\0208\"\005\b«\001\020:R\017\020¬\001\032\0020\030X\004¢\006\002\n\000R\017\020­\001\032\0020\tX\004¢\006\002\n\000R\017\020®\001\032\0020\034X\016¢\006\002\n\000R\017\020¯\001\032\0020<X\016¢\006\002\n\000¨\006Ò\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AirBypass", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getAirBypass", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "aacValue", "airRangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getAirRangeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "al", "", "attackDelay", "", "attackTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "autoBlockFacing", "Lnet/ccbluex/liquidbounce/value/Value;", "", "autoBlockPacketValue", "", "autoBlockValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bb", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "blockKey", "", "getBlockKey", "()I", "blockRange", "blockRangeValue", "getBlockRangeValue", "()Lnet/ccbluex/liquidbounce/value/Value;", "blockRate", "blockingStatus", "getBlockingStatus", "()Z", "setBlockingStatus", "(Z)V", "brightnessValue", "cancelRun", "getCancelRun", "circleAccuracy", "circleAlpha", "circleValue", "clicks", "colorAlphaValue", "colorModeValue", "colorTeam", "containerOpen", "cooldownValue", "currentTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getCurrentTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setCurrentTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "direction", "", "displayText", "entity", "espAnimation", "extraRange", "failRateValue", "failchange", "failcount", "getFailcount", "setFailcount", "(I)V", "failcountvalue", "faildebug", "failrange", "failstatus", "getFailstatus", "setFailstatus", "failtick", "fakeSharpValue", "fakeSwingValue", "fovValue", "groundRangeValue", "getGroundRangeValue", "hasnoticed", "getHasnoticed", "setHasnoticed", "hitable", "hitableValue", "hurtTimeValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getHurtTimeValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "hyt180fovfixValue", "getHyt180fovfixValue", "interactAutoBlockValue", "isBlockingChestAura", "isUp", "jelloAlphaValue", "jelloFadeSpeedValue", "jelloGradientHeightValue", "jelloWidthValue", "karange", "getKarange", "()F", "setKarange", "(F)V", "keepSprintValue", "getKeepSprintValue", "lastDeltaMS", "lastMS", "lastTarget", "limitedMultiTargetsValue", "livingRaycastValue", "markEntity", "Lnet/minecraft/entity/EntityLivingBase;", "markTimer", "markValue", "maxCPS", "getMaxCPS", "maxPredictSize", "maxRange", "getMaxRange", "maxTurnSpeed", "minCPS", "getMinCPS", "minPredictSize", "minTurnSpeed", "noInventoryAttackValue", "noInventoryDelayValue", "noScaffoldValue", "outborderValue", "packetbypassValue", "predictValue", "prevTargetEntities", "", "priorityValue", "progress", "randomCenterValue", "rangeSprintReducementValue", "rangeValue", "getRangeValue", "raycastIgnoredValue", "raycastValue", "rotationStrafeValue", "getRotationStrafeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "rotations", "saturationValue", "sblockRange", "silentRotationValue", "getSilentRotationValue", "silentfix", "getSilentfix", "setSilentfix", "(Lnet/ccbluex/liquidbounce/value/BoolValue;)V", "sprinting", "getSprinting", "setSprinting", "stopSprintAir", "swingValue", "switchDelayValue", "getSwitchDelayValue", "switchTimer", "syncEntity", "getSyncEntity", "setSyncEntity", "tag", "getTag", "()Ljava/lang/String;", "target", "getTarget", "setTarget", "targetModeValue", "throughWallsRangeValue", "tickcount", "yPos", "attackEntity", "", "canBlock", "getRange", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isAlive", "isEnemy", "onDisable", "onEnable", "onEntityMove", "event", "Lnet/ccbluex/liquidbounce/event/EntityMovementEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "runAttack", "startBlocking", "interactEntity", "interact", "stopBlocking", "update", "updateHitable", "updateRotations", "updateTarget", "Companion", "XSJClient"})
/*      */ public final class KillAura
/*      */   extends Module
/*      */ {
/*      */   private boolean failstatus;
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"post3D", "", "invoke"})
/*      */   static final class KillAura$onRender3D$1
/*      */     extends Lambda
/*      */     implements Function0<Unit>
/*      */   {
/*      */     public static final KillAura$onRender3D$1 INSTANCE = new KillAura$onRender3D$1();
/*      */     
/*      */     public final void invoke() {
/*  533 */       GL11.glDepthMask(true);
/*  534 */       GL11.glEnable(2929);
/*  535 */       GL11.glDisable(2848);
/*  536 */       GL11.glEnable(3553);
/*  537 */       GL11.glDisable(3042);
/*  538 */       GL11.glPopMatrix();
/*  539 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     }
/*      */     
/*      */     KillAura$onRender3D$1() {
/*      */       super(0);
/*      */     }
/*      */   }
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\030\n\000\n\002\020\002\n\000\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\006\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020\005\032\0020\0032\006\020\006\032\0020\0072\006\020\b\032\0020\0032\006\020\t\032\0020\0072\006\020\n\032\0020\0072\006\020\013\032\0020\0072\006\020\f\032\0020\007H\n¢\006\002\b\r"}, d2 = {"drawCircle", "", "x", "", "y", "z", "width", "", "radius", "red", "green", "blue", "alp", "invoke"})
/*      */   static final class KillAura$onRender3D$2
/*      */     extends Lambda implements Function9<Double, Double, Double, Float, Double, Float, Float, Float, Float, Unit>
/*      */   {
/*      */     public static final KillAura$onRender3D$2 INSTANCE = new KillAura$onRender3D$2();
/*      */     
/*  553 */     public final void invoke(double x, double y, double z, float width, double radius, float red, float green, float blue, float alp) { GL11.glLineWidth(width);
/*  554 */       GL11.glBegin(2);
/*  555 */       GL11.glColor4f(red, green, blue, alp);
/*  556 */       int i = 0;
/*  557 */       while (i <= 360) {
/*  558 */         double posX = x - Math.sin(i * Math.PI / '´') * radius;
/*  559 */         double posZ = z + Math.cos(i * Math.PI / '´') * radius;
/*  560 */         GL11.glVertex3d(posX, y, posZ);
/*  561 */         i++;
/*      */       } 
/*  563 */       GL11.glEnd(); } KillAura$onRender3D$2() {
/*      */       super(9);
/*      */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"pre3D", "", "invoke"})
/*      */   static final class KillAura$onRender3D$3 extends Lambda implements Function0<Unit> { public static final KillAura$onRender3D$3 INSTANCE = new KillAura$onRender3D$3();
/*  567 */     public final void invoke() { GL11.glPushMatrix();
/*  568 */       GL11.glEnable(3042);
/*  569 */       GL11.glBlendFunc(770, 771);
/*  570 */       GL11.glShadeModel(7425);
/*  571 */       GL11.glDisable(3553);
/*  572 */       GL11.glEnable(2848);
/*  573 */       GL11.glDisable(2929);
/*  574 */       GL11.glDisable(2896);
/*  575 */       GL11.glDepthMask(false);
/*  576 */       GL11.glHint(3154, 4354);
/*  577 */       GL11.glDisable(2884); } KillAura$onRender3D$3() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\004\030\0010\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"getColor", "Ljava/awt/Color;", "ent", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "invoke"})
/*      */   static final class KillAura$onRender3D$4 extends Lambda implements Function1<IEntityLivingBase, Color> { @Nullable
/*      */     public final Color invoke(@Nullable IEntityLivingBase ent) {
/*  581 */       int[] counter = { 0 };
/*  582 */       if (ent instanceof EntityLivingBase) {
/*  583 */         IEntityLivingBase entityLivingBase = ent;
/*      */         
/*  585 */         if (StringsKt.equals((String)KillAura.this.colorModeValue.get(), "Health", true)) return BlendUtils.getHealthColor(
/*  586 */               entityLivingBase.getHealth(), 
/*  587 */               entityLivingBase.getMaxHealth());
/*      */         
/*  589 */         if (((Boolean)KillAura.this.colorTeam.get()).booleanValue()) {
/*      */           
/*  591 */           if (entityLivingBase.getDisplayName() == null) Intrinsics.throwNpe();  String str1 = entityLivingBase.getDisplayName().getFormattedText(); byte b = 0; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] chars = str1.toCharArray();
/*  592 */           int color = Integer.MAX_VALUE; int i;
/*  593 */           for (b = 0, i = chars.length; b < i; b++) {
/*  594 */             if (chars[b] == '§' && b + 1 < chars.length) {
/*  595 */               int index = GameFontRenderer.Companion.getColorIndex(chars[b + 1]);
/*  596 */               if (index >= 0 && index <= 15) {
/*  597 */                 color = ColorUtils.hexColors[index]; break;
/*      */               } 
/*      */             } 
/*  600 */           }  return new Color(color);
/*      */         } 
/*      */       } 
/*  603 */       String str = (String)KillAura.this.colorModeValue.get(); switch (str.hashCode())
/*      */       { case 83201:
/*  605 */           if (str.equals("Sky")); break;
/*  606 */         case -884013110: if (str.equals("LiquidSlowly")); break;
/*  607 */         case 2029746065: if (str.equals("Custom")); break; }  return ColorUtils.fade(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), 0, 100);
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
/*      */     KillAura$onRender3D$4() {
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
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\n\n\000\n\002\020\006\n\002\b\002\020\000\032\0020\0012\006\020\002\032\0020\001H\n¢\006\002\b\003"}, d2 = {"easeInOutQuart", "", "x", "invoke"})
/*      */   static final class KillAura$onRender3D$5
/*      */     extends Lambda
/*      */     implements Function1<Double, Double>
/*      */   {
/*      */     public static final KillAura$onRender3D$5 INSTANCE = new KillAura$onRender3D$5();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     KillAura$onRender3D$5() {
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
/*      */     public final double invoke(double x) {
/*  793 */       return (x < 0.5D) ? (8 * x * x * x * x) : (true - Math.pow(-2 * x + 2, 4.0D) / 2);
/*      */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$faildebug$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura.this.failchange.get()).booleanValue(); } KillAura$faildebug$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$failrange$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura.this.failchange.get()).booleanValue(); }
/*      */     KillAura$failrange$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$failcountvalue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura.this.failchange.get()).booleanValue(); }
/*      */     KillAura$failcountvalue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$failtick$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura.this.failchange.get()).booleanValue(); }
/*      */     KillAura$failtick$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$stopSprintAir$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura.this.getKeepSprintValue().get()).booleanValue(); }
/*      */     KillAura$stopSprintAir$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$blockRangeValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.autoBlockValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "off") ^ true; }
/*      */     KillAura$blockRangeValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$autoBlockPacketValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.autoBlockValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if ((Intrinsics.areEqual(str.toLowerCase(), "off") ^ true) != 0) { str = (String)KillAura.this.autoBlockValue.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if ((Intrinsics.areEqual(str.toLowerCase(), "fake") ^ true) != 0); }  return false; }
/*      */     KillAura$autoBlockPacketValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$interactAutoBlockValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.autoBlockValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "off") ^ true; }
/*      */     KillAura$interactAutoBlockValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$autoBlockFacing$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.autoBlockValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "off") ^ true; }
/*      */     KillAura$autoBlockFacing$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$blockRate$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.autoBlockValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "off") ^ true; }
/*      */     KillAura$blockRate$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$maxPredictSize$2 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura.this.predictValue.get()).booleanValue(); }
/*      */     KillAura$maxPredictSize$2() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$minPredictSize$2 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { return ((Boolean)KillAura.this.predictValue.get()).booleanValue(); }
/*      */     KillAura$minPredictSize$2() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$noInventoryDelayValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura.this.noInventoryAttackValue.get()).booleanValue(); }
/*      */     KillAura$noInventoryDelayValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$limitedMultiTargetsValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.targetModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("multi"); }
/*      */     KillAura$limitedMultiTargetsValue$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$colorModeValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$colorModeValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$colorAlphaValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$colorAlphaValue$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$colorTeam$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$colorTeam$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$jelloAlphaValue$1 extends Lambda implements Function0<Boolean> {
/*      */     public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$jelloAlphaValue$1() { super(0); }
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$jelloWidthValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$jelloWidthValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$jelloGradientHeightValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$jelloGradientHeightValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$jelloFadeSpeedValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)KillAura.this.markValue.get(); boolean bool = false; if (str == null)
/*      */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return Intrinsics.areEqual(str.toLowerCase(), "jello"); }
/*      */     KillAura$jelloFadeSpeedValue$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$circleAlpha$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura.this.circleValue.get()).booleanValue(); }
/*      */     KillAura$circleAlpha$1() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class KillAura$circleAccuracy$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((Boolean)KillAura.this.circleValue.get()).booleanValue(); }
/*      */     KillAura$circleAccuracy$1() { super(0); } }
/*      */   public final boolean getFailstatus() { return this.failstatus; }
/*      */   public final void setFailstatus(boolean <set-?>) { this.failstatus = <set-?>; }
/*      */   @NotNull private final FloatValue groundRangeValue = new FloatValue("GroundRange", 3.7F, 1.0F, 8.0F); private int failcount;
/*      */   @NotNull public final FloatValue getGroundRangeValue() { return this.groundRangeValue; }
/*      */   public final int getFailcount() { return this.failcount; }
/*      */   public final void setFailcount(int <set-?>) { this.failcount = <set-?>; }
/*      */   @NotNull private final BoolValue AirBypass = new BoolValue("AirBypass", true);
/*      */   @NotNull public final BoolValue getAirBypass() { return this.AirBypass; }
/*      */   @NotNull private final FloatValue airRangeValue = new FloatValue("AirRange", 3.7F, 1.0F, 8.0F);
/*      */   @NotNull public final FloatValue getAirRangeValue() { return this.airRangeValue; }
/*      */   @NotNull private BoolValue silentfix = new BoolValue("silentfix", true);
/*      */   @NotNull public final BoolValue getSilentfix() { return this.silentfix; }
/*      */   public final void setSilentfix(@NotNull BoolValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.silentfix = <set-?>; }
/*      */   private boolean sprinting = true; private boolean hasnoticed; private int tickcount;
/*      */   public final boolean getSprinting() { return this.sprinting; }
/*      */   public final void setSprinting(boolean <set-?>) { this.sprinting = <set-?>; }
/*      */   public final boolean getHasnoticed() { return this.hasnoticed; }
/*      */   public final void setHasnoticed(boolean <set-?>) { this.hasnoticed = <set-?>; }
/*  882 */   @EventTarget public final void onEntityMove(@NotNull EntityMovementEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); IEntity movedEntity = event.getMovedEntity();
/*      */     
/*  884 */     if (this.target == null || (Intrinsics.areEqual(movedEntity, this.currentTarget) ^ true) != 0) {
/*      */       return;
/*      */     }
/*  887 */     updateHitable(); }
/*      */   @NotNull private final IntegerValue maxCPS = new KillAura$maxCPS$1("MaxCPS", 8, 1, 20);
/*      */   @NotNull public final IntegerValue getMaxCPS() { return this.maxCPS; }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$maxCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura$maxCPS$1 extends IntegerValue {
/*      */     KillAura$maxCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(int oldValue, int newValue) { int i = ((Number)KillAura.this.getMinCPS().get()).intValue(); if (i > newValue) set(Integer.valueOf(i));  KillAura.this.attackDelay = TimeUtils.randomClickDelay(((Number)KillAura.this.getMinCPS().get()).intValue(), ((Number)get()).intValue()); } } @NotNull private final IntegerValue minCPS = new KillAura$minCPS$1("MinCPS", 5, 1, 20); @NotNull public final IntegerValue getMinCPS() { return this.minCPS; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$minCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura$minCPS$1 extends IntegerValue {
/*      */     KillAura$minCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(int oldValue, int newValue) { int i = ((Number)KillAura.this.getMaxCPS().get()).intValue(); if (i < newValue) set(Integer.valueOf(i));  KillAura.this.attackDelay = TimeUtils.randomClickDelay(((Number)get()).intValue(), ((Number)KillAura.this.getMaxCPS().get()).intValue()); } } @NotNull private final IntegerValue hurtTimeValue = new IntegerValue("HurtTime", 10, 0, 10); @NotNull public final IntegerValue getHurtTimeValue() { return this.hurtTimeValue; } private final FloatValue cooldownValue = new FloatValue("Cooldown", 1.0F, 0.0F, 1.0F); private final BoolValue failchange = new BoolValue("AutoRange-FailAttack", true); private final Value<Boolean> faildebug = (new BoolValue("Debug", true)).displayable(new KillAura$faildebug$1()); private final Value<Float> failrange = (new FloatValue("Auto-Range", 3.0F, 0.0F, 4.0F)).displayable(new KillAura$failrange$1()); private final Value<Integer> failcountvalue = (new IntegerValue("Count-to-change", 2, 0, 5)).displayable(new KillAura$failcountvalue$1()); private final Value<Integer> failtick = (new IntegerValue("rangeKeepTick", 10, 0, 30)).displayable(new KillAura$failtick$1()); @NotNull private final FloatValue rangeValue = new FloatValue("Range", 3.7F, 1.0F, 8.0F); @NotNull public final FloatValue getRangeValue() { return this.rangeValue; } private float karange = ((Number)this.rangeValue.get()).floatValue(); public final float getKarange() { return this.karange; } public final void setKarange(float <set-?>) { this.karange = <set-?>; } private final FloatValue throughWallsRangeValue = new FloatValue("ThroughWallsRange", 3.0F, 0.0F, 8.0F); private final FloatValue rangeSprintReducementValue = new FloatValue("RangeSprintReducement", 0.0F, 0.0F, 0.4F); private final ListValue priorityValue = new ListValue("Priority", new String[] { "Health", "Distance", "Direction", "LivingTime", "HurtResitanTime" }, "Distance"); private final ListValue targetModeValue = new ListValue("TargetMode", new String[] { "Single", "Switch", "Multi" }, "Switch"); private final BoolValue swingValue = new BoolValue("Swing", true); private final BoolValue noScaffoldValue = new BoolValue("NoScaffold", false); @NotNull private final BoolValue keepSprintValue = new BoolValue("KeepSprint", false); @NotNull public final BoolValue getKeepSprintValue() { return this.keepSprintValue; } private final Value<Boolean> stopSprintAir = (new BoolValue("StopSprintOnAir", false)).displayable(new KillAura$stopSprintAir$1()); @NotNull private final BoolValue hyt180fovfixValue = new BoolValue("Hyt180FovFix", true); @NotNull public final BoolValue getHyt180fovfixValue() { return this.hyt180fovfixValue; } private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "HuaYuTing", "Range", "Off", "Fake" }, "Range"); @NotNull public final Value<Float> getBlockRangeValue() { return this.blockRangeValue; } @NotNull private final Value<Float> blockRangeValue = (new FloatValue("BlockRange", 3.0F, 0.0F, 8.0F)).displayable(new KillAura$blockRangeValue$1()); private final Value<String> autoBlockPacketValue = (new ListValue("AutoBlockPacket", new String[] { "Vanilla", "Mouse", "GameSettings", "UseItem", "DoubleC08", "Test", "TangChengHan" }, "Vanilla")).displayable(new KillAura$autoBlockPacketValue$1()); private FloatValue blockRange = new FloatValue("Test-StartBlockRange", 2.99F, 0.0F, 6.0F); private FloatValue sblockRange = new FloatValue("Test-StopBlockRange", 1.75F, 0.0F, 6.0F); private FloatValue extraRange = new FloatValue("Test-CoolDownRange", 3.05F, 0.0F, 5.0F); private final BoolValue packetbypassValue = new BoolValue("TangChenHna-SentPacket", true); private final Value<Boolean> interactAutoBlockValue = (new BoolValue("InteractAutoBlock", true)).displayable(new KillAura$interactAutoBlockValue$1()); private final Value<Boolean> autoBlockFacing = (new BoolValue("AutoBlockFacing", false)).displayable(new KillAura$autoBlockFacing$1()); private final Value<Integer> blockRate = (new IntegerValue("BlockRate", 100, 1, 100)).displayable(new KillAura$blockRate$1()); private final BoolValue raycastValue = new BoolValue("RayCast", true); private final BoolValue raycastIgnoredValue = new BoolValue("RayCastIgnored", false); private final BoolValue livingRaycastValue = new BoolValue("LivingRayCast", true); private final BoolValue aacValue = new BoolValue("AAC", false); private final FloatValue maxTurnSpeed = new KillAura$maxTurnSpeed$1("MaxTurnSpeed", 180.0F, 0.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$maxTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura$maxTurnSpeed$1 extends FloatValue {
/*      */     KillAura$maxTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura.this.minTurnSpeed.get()).floatValue(); if (v > newValue) set(Float.valueOf(v));  } } private final FloatValue minTurnSpeed = new KillAura$minTurnSpeed$1("MinTurnSpeed", 180.0F, 0.0F, 180.0F); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$minTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura$minTurnSpeed$1 extends FloatValue {
/*  894 */     KillAura$minTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura.this.maxTurnSpeed.get()).floatValue(); if (v < newValue) set(Float.valueOf(v));  } } private final BoolValue randomCenterValue = new BoolValue("RandomCenter", true); private final ListValue rotations = new ListValue("RotationMode", new String[] { "None", "New", "Liquidbounce", "BackTrack", "Test1", "Test2", "HytRotation", "VapuV1" }, "New"); private final BoolValue outborderValue = new BoolValue("Outborder", false); @NotNull private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true); @NotNull public final BoolValue getSilentRotationValue() { return this.silentRotationValue; } @NotNull private final ListValue rotationStrafeValue = new ListValue("Strafe", new String[] { "Off", "Strict", "Silent" }, "Off"); @NotNull public final ListValue getRotationStrafeValue() { return this.rotationStrafeValue; } private final FloatValue fovValue = new FloatValue("FOV", 180.0F, 0.0F, 180.0F); private final BoolValue hitableValue = new BoolValue("AlwaysHitable", true); @NotNull private final IntegerValue switchDelayValue = new IntegerValue("SwitchDelay", 300, 1, 2000); @NotNull public final IntegerValue getSwitchDelayValue() { return this.switchDelayValue; } private final BoolValue predictValue = new BoolValue("Predict", true); private final FloatValue maxPredictSize; private final FloatValue minPredictSize; private final FloatValue failRateValue; private final BoolValue fakeSwingValue; private final BoolValue noInventoryAttackValue; private final void runAttack() { if (this.target != null)
/*  895 */     { if (this.currentTarget != null)
/*  896 */       { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  897 */           if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*      */ 
/*      */             
/*  900 */             float failRate = ((Number)this.failRateValue.get()).floatValue();
/*  901 */             boolean swing = ((Boolean)this.swingValue.get()).booleanValue();
/*  902 */             boolean multi = StringsKt.equals((String)this.targetModeValue.get(), "Multi", true);
/*  903 */             boolean openInventory = (((Boolean)this.aacValue.get()).booleanValue() && MinecraftInstance.classProvider.isGuiContainer(MinecraftInstance.mc.getCurrentScreen()));
/*  904 */             boolean failHit = (failRate > false && (new Random()).nextInt(100) <= failRate);
/*      */ 
/*      */             
/*  907 */             if (openInventory) {
/*  908 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow());
/*      */             }
/*      */ 
/*      */             
/*  912 */             if (!this.hitable || failHit) {
/*  913 */               if (swing && (((Boolean)this.fakeSwingValue.get()).booleanValue() || failHit)) {
/*  914 */                 thePlayer.swingItem();
/*      */               }
/*      */             } else {
/*  917 */               if (!multi) {
/*  918 */                 if (this.currentTarget == null) Intrinsics.throwNpe();  attackEntity(this.currentTarget);
/*      */               } else {
/*  920 */                 int targets = 0;
/*      */                 
/*  922 */                 for (IEntity entity : theWorld.getLoadedEntityList()) {
/*  923 */                   double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity);
/*      */                   
/*  925 */                   if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && isEnemy(entity) && distance <= getRange(entity)) {
/*  926 */                     attackEntity(entity.asEntityLivingBase());
/*      */                     
/*  928 */                     targets++;
/*      */                     
/*  930 */                     if (((Number)this.limitedMultiTargetsValue.get()).intValue() != 0 && ((Number)this.limitedMultiTargetsValue.get()).intValue() <= targets) {
/*      */                       break;
/*      */                     }
/*      */                   } 
/*      */                 } 
/*      */               } 
/*  936 */               if (StringsKt.equals((String)this.targetModeValue.get(), "Switch", true)) {
/*  937 */                 if (this.switchTimer.hasTimePassed(((Number)this.switchDelayValue.get()).intValue())) {
/*  938 */                   if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/*  939 */                   this.switchTimer.reset();
/*      */                 } 
/*      */               } else {
/*  942 */                 if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/*      */               } 
/*      */               
/*  945 */               if (Intrinsics.areEqual(this.target, this.currentTarget)) {
/*  946 */                 this.target = (IEntityLivingBase)null;
/*      */               }
/*      */             } 
/*      */             
/*  950 */             if (openInventory)
/*  951 */             { IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createOpenInventoryPacket = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1591 */               if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY); iINetHandlerPlayClient.addToSendQueue(iPacket); }  return; }  MinecraftInstance.mc.getTheWorld(); return; }  MinecraftInstance.mc.getThePlayer(); return; }  return; }  } private final Value<Integer> noInventoryDelayValue; private final Value<Integer> limitedMultiTargetsValue; private final ListValue markValue; private final Value<String> colorModeValue; private final Value<Integer> colorAlphaValue; private final FloatValue saturationValue; private final FloatValue brightnessValue; private final Value<Boolean> colorTeam; private final Value<Float> jelloAlphaValue; private final Value<Float> jelloWidthValue; private final Value<Float> jelloGradientHeightValue; private final Value<Float> jelloFadeSpeedValue; private final BoolValue fakeSharpValue; private final BoolValue circleValue; private final Value<Integer> circleAlpha; private final Value<Integer> circleAccuracy; private final int blockKey; private final MSTimer switchTimer; @Nullable private IEntityLivingBase target; @Nullable private IEntityLivingBase currentTarget; private boolean hitable; private final List<Integer> prevTargetEntities; private IEntityLivingBase lastTarget; private double direction; private double yPos; private double progress; private long lastMS; private long lastDeltaMS; private float al; private final MSTimer attackTimer; private long attackDelay; private int clicks; private EntityLivingBase markEntity; private final MSTimer markTimer; private long containerOpen; private String displayText; private IAxisAlignedBB bb; private IEntityLivingBase entity; private boolean blockingStatus; private double espAnimation; private boolean isUp; @Nullable private IEntityLivingBase syncEntity; private static int killCounts; public static final Companion Companion = new Companion(null); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$maxPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura$maxPredictSize$1 extends FloatValue {
/*      */     KillAura$maxPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura.this.minPredictSize.get()).floatValue(); if (v > newValue) set(Float.valueOf(v));  } } public KillAura() { if ((new KillAura$maxPredictSize$1("MaxPredictSize", 1.0F, 0.1F, 5.0F)).displayable(new KillAura$maxPredictSize$2()) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.value.FloatValue");  this.maxPredictSize = (FloatValue)(new KillAura$maxPredictSize$1("MaxPredictSize", 1.0F, 0.1F, 5.0F)).displayable(new KillAura$maxPredictSize$2()); if ((new KillAura$minPredictSize$1("MinPredictSize", 1.0F, 0.1F, 5.0F)).displayable(new KillAura$minPredictSize$2()) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.value.FloatValue");  this.minPredictSize = (FloatValue)(new KillAura$minPredictSize$1("MinPredictSize", 1.0F, 0.1F, 5.0F)).displayable(new KillAura$minPredictSize$2()); this.failRateValue = new FloatValue("FailRate", 0.0F, 0.0F, 100.0F); this.fakeSwingValue = new BoolValue("FakeSwing", true); this.noInventoryAttackValue = new BoolValue("NoInvAttack", false); this.noInventoryDelayValue = (new IntegerValue("NoInvDelay", 200, 0, 500)).displayable(new KillAura$noInventoryDelayValue$1()); this.limitedMultiTargetsValue = (new IntegerValue("LimitedMultiTargets", 0, 0, 50)).displayable(new KillAura$limitedMultiTargetsValue$1()); this.markValue = new ListValue("Mark", new String[] { "Liquid", "FDP", "Block", "Jello", "Plat", "Red", "Sims", "None" }, "FDP"); this.colorModeValue = (new ListValue("JelloColor", new String[] { "Custom", "Rainbow", "Sky", "LiquidSlowly", "Fade", "Health", "Gident" }, "Custom")).displayable(new KillAura$colorModeValue$1()); this.colorAlphaValue = (new IntegerValue("JelloAlpha", 255, 0, 255)).displayable(new KillAura$colorAlphaValue$1()); this.saturationValue = new FloatValue("Saturation", 1.0F, 0.0F, 1.0F); this.brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F); this.colorTeam = (new BoolValue("JelloTeam", false)).displayable(new KillAura$colorTeam$1()); this.jelloAlphaValue = (new FloatValue("JelloEndAlphaPercent", 0.4F, 0.0F, 1.0F)).displayable(new KillAura$jelloAlphaValue$1()); this.jelloWidthValue = (new FloatValue("JelloCircleWidth", 3.0F, 0.01F, 5.0F)).displayable(new KillAura$jelloWidthValue$1()); this.jelloGradientHeightValue = (new FloatValue("JelloGradientHeight", 3.0F, 1.0F, 8.0F)).displayable(new KillAura$jelloGradientHeightValue$1()); this.jelloFadeSpeedValue = (new FloatValue("JelloFadeSpeed", 0.1F, 0.01F, 0.5F)).displayable(new KillAura$jelloFadeSpeedValue$1()); this.fakeSharpValue = new BoolValue("FakeSharp", true); this.circleValue = new BoolValue("Circle", true); this.circleAlpha = (new IntegerValue("CircleAlpha", 255, 0, 255)).displayable(new KillAura$circleAlpha$1()); this.circleAccuracy = (new IntegerValue("CircleAccuracy", 15, 0, 60)).displayable(new KillAura$circleAccuracy$1()); this.blockKey = MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().getKeyCode(); this.switchTimer = new MSTimer(); KillAura killAura = this; boolean bool = false; ArrayList<Integer> arrayList = new ArrayList(); this.direction = 1.0D; this.lastMS = System.currentTimeMillis(); this.attackTimer = new MSTimer(); this.markTimer = new MSTimer(); this.containerOpen = -1L; this.displayText = ""; this.isUp = true; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$minPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class KillAura$minPredictSize$1 extends FloatValue { KillAura$minPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); } protected void onChanged(float oldValue, float newValue) { float v = ((Number)KillAura.this.maxPredictSize.get()).floatValue(); if (v < newValue) set(Float.valueOf(v));  } } public final int getBlockKey() { return this.blockKey; } @Nullable public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; } @Nullable public final IEntityLivingBase getCurrentTarget() { return this.currentTarget; } public final void setCurrentTarget(@Nullable IEntityLivingBase <set-?>) { this.currentTarget = <set-?>; } public final boolean getBlockingStatus() { return this.blockingStatus; } public final void setBlockingStatus(boolean <set-?>) { this.blockingStatus = <set-?>; } @Nullable public final IEntityLivingBase getSyncEntity() { return this.syncEntity; } public final void setSyncEntity(@Nullable IEntityLivingBase <set-?>) { this.syncEntity = <set-?>; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\006\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R$\020\003\032\0020\0048\006@\006X\016¢\006\024\n\000\022\004\b\005\020\002\032\004\b\006\020\007\"\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$Companion;", "", "()V", "killCounts", "", "killCounts$annotations", "getKillCounts", "()I", "setKillCounts", "(I)V", "XSJClient"}) public static final class Companion { private Companion() {} public final void setKillCounts(int <set-?>) { KillAura.killCounts = <set-?>; } public final int getKillCounts() { return KillAura.killCounts; } } @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.AirBypass.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().isDead()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() > false) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { if (((Number)this.rangeValue.get()).floatValue() != ((Number)this.groundRangeValue.get()).floatValue()) this.rangeValue.set(this.groundRangeValue.get());  } else if (((Number)this.rangeValue.get()).floatValue() != ((Number)this.airRangeValue.get()).floatValue()) { this.rangeValue.set(this.airRangeValue.get()); }  }  }  }  if (this.target == null && ((Boolean)this.silentfix.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getSprinting()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getTicksExisted() % 2 == 0) this.sprinting = true;  }  }  } public void onEnable() { if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { MinecraftInstance.mc.getTheWorld(); updateTarget(); return; }  MinecraftInstance.mc.getTheWorld(); return; }  MinecraftInstance.mc.getThePlayer(); } public void onDisable() { this.target = (IEntityLivingBase)null; this.currentTarget = (IEntityLivingBase)null; this.lastTarget = (IEntityLivingBase)null; this.hitable = false; this.prevTargetEntities.clear(); this.attackTimer.reset(); this.clicks = 0; stopBlocking(); } @EventTarget public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.stopSprintAir.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { this.keepSprintValue.set(Boolean.valueOf(true)); } else { this.keepSprintValue.set(Boolean.valueOf(false)); }  }  if (event.getEventState() == EventState.POST) { if (this.target != null) { if (this.currentTarget != null) { updateHitable(); return; }  return; }  return; }  if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) update();  } @EventTarget public final void onStrafe(@NotNull StrafeEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) return;  update(); if (this.currentTarget != null && RotationUtils.targetRotation != null) { String str = (String)this.rotationStrafeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -902327211: if (str.equals("silent")) { update(); RotationUtils.targetRotation.applyStrafeToPlayer(event); event.cancelEvent(); }  break;case -891986231: if (str.equals("strict")) { if (RotationUtils.targetRotation != null) { Rotation rotation = RotationUtils.targetRotation; float yaw = rotation.component1(); float strafe = event.getStrafe(); float forward = event.getForward(); float friction = event.getFriction(); float f = strafe * strafe + forward * forward; if (f >= 1.0E-4F) { boolean bool1 = false; f = (float)Math.sqrt(f); if (f < 1.0F) f = 1.0F;  f = friction / f; strafe *= f; forward *= f; float f1 = (float)(yaw * Math.PI / 180.0F); boolean bool2 = false; float yawSin = (float)Math.sin(f1); float f2 = (float)(yaw * Math.PI / 180.0F); boolean bool3 = false; float yawCos = (float)Math.cos(f2); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); player.setMotionX(player.getMotionX() + (strafe * yawCos - forward * yawSin)); player.setMotionZ(player.getMotionZ() + (forward * yawCos + strafe * yawSin)); }  event.cancelEvent(); break; }  return; }  break; }  }  } public final void update() { // Byte code:
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
/*      */     //   24: ifne -> 158
/*      */     //   27: aload_1
/*      */     //   28: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   31: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   36: dup
/*      */     //   37: ifnonnull -> 43
/*      */     //   40: invokestatic throwNpe : ()V
/*      */     //   43: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   46: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   49: ifeq -> 158
/*      */     //   52: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   55: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   58: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   61: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   64: invokevirtual getState : ()Z
/*      */     //   67: ifne -> 158
/*      */     //   70: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   73: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   76: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   79: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   82: invokevirtual getState : ()Z
/*      */     //   85: ifne -> 158
/*      */     //   88: aload_1
/*      */     //   89: invokestatic access$getNoScaffoldValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   92: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   95: checkcast java/lang/Boolean
/*      */     //   98: invokevirtual booleanValue : ()Z
/*      */     //   101: ifeq -> 162
/*      */     //   104: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   107: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   110: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold
/*      */     //   113: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   116: invokevirtual getState : ()Z
/*      */     //   119: ifne -> 158
/*      */     //   122: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   125: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   128: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold2
/*      */     //   131: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   134: invokevirtual getState : ()Z
/*      */     //   137: ifne -> 158
/*      */     //   140: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   143: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   146: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/GroundTelly
/*      */     //   149: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   152: invokevirtual getState : ()Z
/*      */     //   155: ifeq -> 162
/*      */     //   158: iconst_1
/*      */     //   159: goto -> 163
/*      */     //   162: iconst_0
/*      */     //   163: ifne -> 226
/*      */     //   166: aload_0
/*      */     //   167: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   170: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   173: checkcast java/lang/Boolean
/*      */     //   176: invokevirtual booleanValue : ()Z
/*      */     //   179: ifeq -> 227
/*      */     //   182: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   185: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   188: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   193: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   198: ifne -> 226
/*      */     //   201: invokestatic currentTimeMillis : ()J
/*      */     //   204: aload_0
/*      */     //   205: getfield containerOpen : J
/*      */     //   208: lsub
/*      */     //   209: aload_0
/*      */     //   210: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   213: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   216: checkcast java/lang/Number
/*      */     //   219: invokevirtual longValue : ()J
/*      */     //   222: lcmp
/*      */     //   223: ifge -> 227
/*      */     //   226: return
/*      */     //   227: aload_0
/*      */     //   228: invokespecial updateTarget : ()V
/*      */     //   231: aload_0
/*      */     //   232: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   235: ifnonnull -> 243
/*      */     //   238: aload_0
/*      */     //   239: invokespecial stopBlocking : ()V
/*      */     //   242: return
/*      */     //   243: aload_0
/*      */     //   244: aload_0
/*      */     //   245: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   248: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   251: aload_0
/*      */     //   252: getfield targetModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   255: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   258: checkcast java/lang/String
/*      */     //   261: ldc_w 'Switch'
/*      */     //   264: iconst_1
/*      */     //   265: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   268: ifne -> 293
/*      */     //   271: aload_0
/*      */     //   272: aload_0
/*      */     //   273: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   276: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   279: invokespecial isEnemy : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */     //   282: ifeq -> 293
/*      */     //   285: aload_0
/*      */     //   286: aload_0
/*      */     //   287: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   290: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   293: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #410	-> 0
/*      */     //   #411	-> 0
/*      */     //   #410	-> 2
/*      */     //   #1581	-> 4
/*      */     //   #1582	-> 4
/*      */     //   #1581	-> 28
/*      */     //   #1582	-> 52
/*      */     //   #410	-> 166
/*      */     //   #411	-> 201
/*      */     //   #413	-> 226
/*      */     //   #415	-> 227
/*      */     //   #417	-> 231
/*      */     //   #418	-> 238
/*      */     //   #419	-> 242
/*      */     //   #424	-> 243
/*      */     //   #426	-> 251
/*      */     //   #427	-> 285
/*      */     //   #428	-> 293
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   2	161	1	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */     //   4	159	2	$i$f$getCancelRun	I
/*      */     //   0	294	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura; } @EventTarget public final void onTick(@Nullable TickEvent event) { if (StringsKt.equals((String)this.markValue.get(), "jello", true)) this.al = AnimationUtils.changer(this.al, (this.target != null) ? ((Number)this.jelloFadeSpeedValue.get()).floatValue() : -((Number)this.jelloFadeSpeedValue.get()).floatValue(), 0.0F, ((Number)this.colorAlphaValue.get()).floatValue() / 255.0F);  } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: aload_0
/*      */     //   8: aload_0
/*      */     //   9: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   12: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   15: checkcast java/lang/Number
/*      */     //   18: invokevirtual floatValue : ()F
/*      */     //   21: putfield karange : F
/*      */     //   24: aload_0
/*      */     //   25: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   28: ifnull -> 70
/*      */     //   31: aload_0
/*      */     //   32: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   35: dup
/*      */     //   36: ifnonnull -> 42
/*      */     //   39: invokestatic throwNpe : ()V
/*      */     //   42: invokeinterface isDead : ()Z
/*      */     //   47: ifeq -> 70
/*      */     //   50: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura.killCounts : I
/*      */     //   53: iconst_1
/*      */     //   54: iadd
/*      */     //   55: putstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura.killCounts : I
/*      */     //   58: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura.killCounts : I
/*      */     //   61: pop
/*      */     //   62: aload_0
/*      */     //   63: aconst_null
/*      */     //   64: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   67: putfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   70: aload_0
/*      */     //   71: getfield hyt180fovfixValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   74: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   77: checkcast java/lang/Boolean
/*      */     //   80: invokevirtual booleanValue : ()Z
/*      */     //   83: ifeq -> 175
/*      */     //   86: aload_0
/*      */     //   87: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   90: ifnull -> 175
/*      */     //   93: aload_0
/*      */     //   94: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   97: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   100: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   103: ldc2_w 90.0
/*      */     //   106: dcmpl
/*      */     //   107: ifle -> 144
/*      */     //   110: aload_0
/*      */     //   111: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   114: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   117: checkcast java/lang/String
/*      */     //   120: ldc_w 'Strict'
/*      */     //   123: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   126: iconst_1
/*      */     //   127: ixor
/*      */     //   128: ifeq -> 175
/*      */     //   131: aload_0
/*      */     //   132: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   135: ldc_w 'Strict'
/*      */     //   138: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   141: goto -> 175
/*      */     //   144: aload_0
/*      */     //   145: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   148: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   151: checkcast java/lang/String
/*      */     //   154: ldc_w 'Silent'
/*      */     //   157: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   160: iconst_1
/*      */     //   161: ixor
/*      */     //   162: ifeq -> 175
/*      */     //   165: aload_0
/*      */     //   166: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   169: ldc_w 'Silent'
/*      */     //   172: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   175: aload_0
/*      */     //   176: getfield failchange : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   179: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   182: checkcast java/lang/Boolean
/*      */     //   185: invokevirtual booleanValue : ()Z
/*      */     //   188: ifeq -> 450
/*      */     //   191: aload_0
/*      */     //   192: getfield failstatus : Z
/*      */     //   195: ifeq -> 450
/*      */     //   198: aload_0
/*      */     //   199: getfield failcountvalue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   202: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   205: checkcast java/lang/Number
/*      */     //   208: invokevirtual intValue : ()I
/*      */     //   211: aload_0
/*      */     //   212: getfield failcount : I
/*      */     //   215: if_icmpgt -> 450
/*      */     //   218: aload_0
/*      */     //   219: dup
/*      */     //   220: getfield tickcount : I
/*      */     //   223: iconst_1
/*      */     //   224: iadd
/*      */     //   225: putfield tickcount : I
/*      */     //   228: aload_0
/*      */     //   229: getfield hasnoticed : Z
/*      */     //   232: ifne -> 320
/*      */     //   235: aload_0
/*      */     //   236: getfield faildebug : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   239: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   242: checkcast java/lang/Boolean
/*      */     //   245: invokevirtual booleanValue : ()Z
/*      */     //   248: ifeq -> 315
/*      */     //   251: new java/lang/StringBuilder
/*      */     //   254: dup
/*      */     //   255: invokespecial <init> : ()V
/*      */     //   258: aload_0
/*      */     //   259: getfield failcount : I
/*      */     //   262: invokestatic valueOf : (I)Ljava/lang/String;
/*      */     //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   268: ldc_w '单位时间内空刀次数太多 以改至'
/*      */     //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   274: aload_0
/*      */     //   275: getfield failrange : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   278: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   281: checkcast java/lang/Number
/*      */     //   284: invokevirtual floatValue : ()F
/*      */     //   287: invokestatic valueOf : (F)Ljava/lang/String;
/*      */     //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   293: ldc_w '---'
/*      */     //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   299: aload_0
/*      */     //   300: getfield karange : F
/*      */     //   303: invokestatic valueOf : (F)Ljava/lang/String;
/*      */     //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   309: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   312: invokestatic print : (Ljava/lang/String;)V
/*      */     //   315: aload_0
/*      */     //   316: iconst_1
/*      */     //   317: putfield hasnoticed : Z
/*      */     //   320: aload_0
/*      */     //   321: aload_0
/*      */     //   322: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   325: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   328: checkcast java/lang/Number
/*      */     //   331: invokevirtual floatValue : ()F
/*      */     //   334: putfield karange : F
/*      */     //   337: aload_0
/*      */     //   338: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   341: aload_0
/*      */     //   342: getfield failrange : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   345: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   348: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   351: aload_0
/*      */     //   352: getfield tickcount : I
/*      */     //   355: aload_0
/*      */     //   356: getfield failtick : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   359: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   362: checkcast java/lang/Number
/*      */     //   365: invokevirtual intValue : ()I
/*      */     //   368: if_icmplt -> 450
/*      */     //   371: aload_0
/*      */     //   372: iconst_0
/*      */     //   373: putfield tickcount : I
/*      */     //   376: aload_0
/*      */     //   377: iconst_0
/*      */     //   378: putfield failcount : I
/*      */     //   381: aload_0
/*      */     //   382: iconst_0
/*      */     //   383: putfield failstatus : Z
/*      */     //   386: aload_0
/*      */     //   387: iconst_0
/*      */     //   388: putfield hasnoticed : Z
/*      */     //   391: aload_0
/*      */     //   392: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   395: aload_0
/*      */     //   396: getfield karange : F
/*      */     //   399: invokestatic valueOf : (F)Ljava/lang/Float;
/*      */     //   402: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   405: aload_0
/*      */     //   406: getfield faildebug : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   409: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   412: checkcast java/lang/Boolean
/*      */     //   415: invokevirtual booleanValue : ()Z
/*      */     //   418: ifeq -> 450
/*      */     //   421: new java/lang/StringBuilder
/*      */     //   424: dup
/*      */     //   425: invokespecial <init> : ()V
/*      */     //   428: ldc_w '以回调至'
/*      */     //   431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   434: aload_0
/*      */     //   435: getfield karange : F
/*      */     //   438: invokestatic valueOf : (F)Ljava/lang/String;
/*      */     //   441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   444: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   447: invokestatic print : (Ljava/lang/String;)V
/*      */     //   450: aload_0
/*      */     //   451: astore_2
/*      */     //   452: iconst_0
/*      */     //   453: istore_3
/*      */     //   454: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   457: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   462: dup
/*      */     //   463: ifnonnull -> 469
/*      */     //   466: invokestatic throwNpe : ()V
/*      */     //   469: invokeinterface isSpectator : ()Z
/*      */     //   474: ifne -> 608
/*      */     //   477: aload_2
/*      */     //   478: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   481: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   486: dup
/*      */     //   487: ifnonnull -> 493
/*      */     //   490: invokestatic throwNpe : ()V
/*      */     //   493: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   496: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   499: ifeq -> 608
/*      */     //   502: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   505: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   508: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   511: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   514: invokevirtual getState : ()Z
/*      */     //   517: ifne -> 608
/*      */     //   520: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   523: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   526: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   529: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   532: invokevirtual getState : ()Z
/*      */     //   535: ifne -> 608
/*      */     //   538: aload_2
/*      */     //   539: invokestatic access$getNoScaffoldValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   542: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   545: checkcast java/lang/Boolean
/*      */     //   548: invokevirtual booleanValue : ()Z
/*      */     //   551: ifeq -> 612
/*      */     //   554: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   557: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   560: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold
/*      */     //   563: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   566: invokevirtual getState : ()Z
/*      */     //   569: ifne -> 608
/*      */     //   572: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   575: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   578: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold2
/*      */     //   581: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   584: invokevirtual getState : ()Z
/*      */     //   587: ifne -> 608
/*      */     //   590: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   593: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   596: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/GroundTelly
/*      */     //   599: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   602: invokevirtual getState : ()Z
/*      */     //   605: ifeq -> 612
/*      */     //   608: iconst_1
/*      */     //   609: goto -> 613
/*      */     //   612: iconst_0
/*      */     //   613: ifeq -> 642
/*      */     //   616: aload_0
/*      */     //   617: aconst_null
/*      */     //   618: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   621: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   624: aload_0
/*      */     //   625: aconst_null
/*      */     //   626: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   629: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   632: aload_0
/*      */     //   633: iconst_0
/*      */     //   634: putfield hitable : Z
/*      */     //   637: aload_0
/*      */     //   638: invokespecial stopBlocking : ()V
/*      */     //   641: return
/*      */     //   642: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   645: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   648: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/StrafeFix
/*      */     //   651: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   654: dup
/*      */     //   655: ifnonnull -> 669
/*      */     //   658: new kotlin/TypeCastException
/*      */     //   661: dup
/*      */     //   662: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.StrafeFix'
/*      */     //   665: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   668: athrow
/*      */     //   669: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/StrafeFix
/*      */     //   672: aload_0
/*      */     //   673: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   676: ldc_w 'Silent'
/*      */     //   679: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   682: aload_0
/*      */     //   683: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   686: ldc_w 'Off'
/*      */     //   689: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   692: ifne -> 712
/*      */     //   695: aload_0
/*      */     //   696: getfield rotations : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   699: ldc_w 'None'
/*      */     //   702: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   705: ifne -> 712
/*      */     //   708: iconst_1
/*      */     //   709: goto -> 713
/*      */     //   712: iconst_0
/*      */     //   713: invokevirtual applyForceStrafe : (ZZ)V
/*      */     //   716: aload_0
/*      */     //   717: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   720: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   723: checkcast java/lang/Boolean
/*      */     //   726: invokevirtual booleanValue : ()Z
/*      */     //   729: ifeq -> 824
/*      */     //   732: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   735: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   738: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   743: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   748: ifne -> 776
/*      */     //   751: invokestatic currentTimeMillis : ()J
/*      */     //   754: aload_0
/*      */     //   755: getfield containerOpen : J
/*      */     //   758: lsub
/*      */     //   759: aload_0
/*      */     //   760: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   763: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   766: checkcast java/lang/Number
/*      */     //   769: invokevirtual longValue : ()J
/*      */     //   772: lcmp
/*      */     //   773: ifge -> 824
/*      */     //   776: aload_0
/*      */     //   777: aconst_null
/*      */     //   778: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   781: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   784: aload_0
/*      */     //   785: aconst_null
/*      */     //   786: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   789: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   792: aload_0
/*      */     //   793: iconst_0
/*      */     //   794: putfield hitable : Z
/*      */     //   797: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   800: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   803: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   808: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   813: ifeq -> 823
/*      */     //   816: aload_0
/*      */     //   817: invokestatic currentTimeMillis : ()J
/*      */     //   820: putfield containerOpen : J
/*      */     //   823: return
/*      */     //   824: aload_0
/*      */     //   825: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   828: ifnull -> 902
/*      */     //   831: aload_0
/*      */     //   832: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   835: ifnull -> 902
/*      */     //   838: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   841: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   846: dup
/*      */     //   847: ifnonnull -> 853
/*      */     //   850: invokestatic throwNpe : ()V
/*      */     //   853: fconst_0
/*      */     //   854: invokeinterface getCooledAttackStrength : (F)F
/*      */     //   859: aload_0
/*      */     //   860: getfield cooldownValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   863: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   866: checkcast java/lang/Number
/*      */     //   869: invokevirtual floatValue : ()F
/*      */     //   872: fcmpl
/*      */     //   873: iflt -> 902
/*      */     //   876: aload_0
/*      */     //   877: getfield clicks : I
/*      */     //   880: ifle -> 902
/*      */     //   883: aload_0
/*      */     //   884: invokespecial runAttack : ()V
/*      */     //   887: aload_0
/*      */     //   888: dup
/*      */     //   889: getfield clicks : I
/*      */     //   892: dup
/*      */     //   893: istore_2
/*      */     //   894: iconst_m1
/*      */     //   895: iadd
/*      */     //   896: putfield clicks : I
/*      */     //   899: goto -> 876
/*      */     //   902: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #446	-> 7
/*      */     //   #447	-> 24
/*      */     //   #448	-> 50
/*      */     //   #449	-> 62
/*      */     //   #452	-> 70
/*      */     //   #453	-> 93
/*      */     //   #454	-> 110
/*      */     //   #456	-> 144
/*      */     //   #457	-> 175
/*      */     //   #459	-> 175
/*      */     //   #460	-> 191
/*      */     //   #461	-> 198
/*      */     //   #462	-> 218
/*      */     //   #463	-> 228
/*      */     //   #464	-> 235
/*      */     //   #465	-> 251
/*      */     //   #466	-> 251
/*      */     //   #467	-> 274
/*      */     //   #466	-> 274
/*      */     //   #467	-> 287
/*      */     //   #465	-> 312
/*      */     //   #470	-> 315
/*      */     //   #473	-> 320
/*      */     //   #474	-> 337
/*      */     //   #476	-> 351
/*      */     //   #477	-> 371
/*      */     //   #478	-> 376
/*      */     //   #479	-> 381
/*      */     //   #480	-> 386
/*      */     //   #481	-> 391
/*      */     //   #482	-> 405
/*      */     //   #483	-> 421
/*      */     //   #490	-> 450
/*      */     //   #1583	-> 454
/*      */     //   #1584	-> 454
/*      */     //   #1583	-> 478
/*      */     //   #1584	-> 502
/*      */     //   #491	-> 616
/*      */     //   #492	-> 624
/*      */     //   #493	-> 632
/*      */     //   #494	-> 637
/*      */     //   #495	-> 641
/*      */     //   #498	-> 642
/*      */     //   #499	-> 672
/*      */     //   #500	-> 682
/*      */     //   #498	-> 713
/*      */     //   #505	-> 716
/*      */     //   #506	-> 716
/*      */     //   #505	-> 716
/*      */     //   #506	-> 751
/*      */     //   #508	-> 776
/*      */     //   #509	-> 784
/*      */     //   #510	-> 792
/*      */     //   #511	-> 797
/*      */     //   #512	-> 823
/*      */     //   #516	-> 824
/*      */     //   #518	-> 824
/*      */     //   #516	-> 838
/*      */     //   #517	-> 853
/*      */     //   #516	-> 854
/*      */     //   #518	-> 859
/*      */     //   #520	-> 876
/*      */     //   #521	-> 883
/*      */     //   #522	-> 887
/*      */     //   #520	-> 899
/*      */     //   #525	-> 902
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   452	161	2	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */     //   454	159	3	$i$f$getCancelRun	I
/*      */     //   0	903	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */     //   0	903	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent; } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$1.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$1;
/*      */     //   10: astore_2
/*      */     //   11: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$2.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$2;
/*      */     //   14: astore_3
/*      */     //   15: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$3.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$3;
/*      */     //   18: astore #4
/*      */     //   20: new net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$4
/*      */     //   23: dup
/*      */     //   24: aload_0
/*      */     //   25: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)V
/*      */     //   28: astore #5
/*      */     //   30: aload_0
/*      */     //   31: getfield circleValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   34: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   37: checkcast java/lang/Boolean
/*      */     //   40: invokevirtual booleanValue : ()Z
/*      */     //   43: ifeq -> 716
/*      */     //   46: invokestatic glPushMatrix : ()V
/*      */     //   49: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   52: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   57: dup
/*      */     //   58: ifnonnull -> 64
/*      */     //   61: invokestatic throwNpe : ()V
/*      */     //   64: invokeinterface getLastTickPosX : ()D
/*      */     //   69: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   72: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   77: dup
/*      */     //   78: ifnonnull -> 84
/*      */     //   81: invokestatic throwNpe : ()V
/*      */     //   84: invokeinterface getPosX : ()D
/*      */     //   89: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   92: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   97: dup
/*      */     //   98: ifnonnull -> 104
/*      */     //   101: invokestatic throwNpe : ()V
/*      */     //   104: invokeinterface getLastTickPosX : ()D
/*      */     //   109: dsub
/*      */     //   110: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   113: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   118: invokeinterface getRenderPartialTicks : ()F
/*      */     //   123: f2d
/*      */     //   124: dmul
/*      */     //   125: dadd
/*      */     //   126: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   129: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   134: invokeinterface getRenderPosX : ()D
/*      */     //   139: dsub
/*      */     //   140: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   143: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   148: dup
/*      */     //   149: ifnonnull -> 155
/*      */     //   152: invokestatic throwNpe : ()V
/*      */     //   155: invokeinterface getLastTickPosY : ()D
/*      */     //   160: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   163: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   168: dup
/*      */     //   169: ifnonnull -> 175
/*      */     //   172: invokestatic throwNpe : ()V
/*      */     //   175: invokeinterface getPosY : ()D
/*      */     //   180: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   183: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   188: dup
/*      */     //   189: ifnonnull -> 195
/*      */     //   192: invokestatic throwNpe : ()V
/*      */     //   195: invokeinterface getLastTickPosY : ()D
/*      */     //   200: dsub
/*      */     //   201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   204: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   209: invokeinterface getRenderPartialTicks : ()F
/*      */     //   214: f2d
/*      */     //   215: dmul
/*      */     //   216: dadd
/*      */     //   217: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   220: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   225: invokeinterface getRenderPosY : ()D
/*      */     //   230: dsub
/*      */     //   231: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   234: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   239: dup
/*      */     //   240: ifnonnull -> 246
/*      */     //   243: invokestatic throwNpe : ()V
/*      */     //   246: invokeinterface getLastTickPosZ : ()D
/*      */     //   251: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   254: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   259: dup
/*      */     //   260: ifnonnull -> 266
/*      */     //   263: invokestatic throwNpe : ()V
/*      */     //   266: invokeinterface getPosZ : ()D
/*      */     //   271: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   274: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   279: dup
/*      */     //   280: ifnonnull -> 286
/*      */     //   283: invokestatic throwNpe : ()V
/*      */     //   286: invokeinterface getLastTickPosZ : ()D
/*      */     //   291: dsub
/*      */     //   292: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   295: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   300: invokeinterface getRenderPartialTicks : ()F
/*      */     //   305: f2d
/*      */     //   306: dmul
/*      */     //   307: dadd
/*      */     //   308: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   311: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   316: invokeinterface getRenderPosZ : ()D
/*      */     //   321: dsub
/*      */     //   322: invokestatic glTranslated : (DDD)V
/*      */     //   325: sipush #3042
/*      */     //   328: invokestatic glEnable : (I)V
/*      */     //   331: sipush #2848
/*      */     //   334: invokestatic glEnable : (I)V
/*      */     //   337: sipush #3553
/*      */     //   340: invokestatic glDisable : (I)V
/*      */     //   343: sipush #2929
/*      */     //   346: invokestatic glDisable : (I)V
/*      */     //   349: sipush #770
/*      */     //   352: sipush #771
/*      */     //   355: invokestatic glBlendFunc : (II)V
/*      */     //   358: fconst_1
/*      */     //   359: invokestatic glLineWidth : (F)V
/*      */     //   362: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   365: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   368: checkcast java/lang/Number
/*      */     //   371: invokevirtual intValue : ()I
/*      */     //   374: i2f
/*      */     //   375: ldc_w 255.0
/*      */     //   378: fdiv
/*      */     //   379: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   382: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   385: checkcast java/lang/Number
/*      */     //   388: invokevirtual intValue : ()I
/*      */     //   391: i2f
/*      */     //   392: ldc_w 255.0
/*      */     //   395: fdiv
/*      */     //   396: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   399: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   402: checkcast java/lang/Number
/*      */     //   405: invokevirtual intValue : ()I
/*      */     //   408: i2f
/*      */     //   409: ldc_w 255.0
/*      */     //   412: fdiv
/*      */     //   413: aload_0
/*      */     //   414: getfield circleAlpha : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   417: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   420: checkcast java/lang/Number
/*      */     //   423: invokevirtual intValue : ()I
/*      */     //   426: i2f
/*      */     //   427: ldc_w 255.0
/*      */     //   430: fdiv
/*      */     //   431: invokestatic glColor4f : (FFFF)V
/*      */     //   434: ldc_w 90.0
/*      */     //   437: fconst_1
/*      */     //   438: fconst_0
/*      */     //   439: fconst_0
/*      */     //   440: invokestatic glRotatef : (FFFF)V
/*      */     //   443: iconst_3
/*      */     //   444: invokestatic glBegin : (I)V
/*      */     //   447: iconst_0
/*      */     //   448: istore #9
/*      */     //   450: new kotlin/ranges/IntRange
/*      */     //   453: dup
/*      */     //   454: iload #9
/*      */     //   456: sipush #360
/*      */     //   459: invokespecial <init> : (II)V
/*      */     //   462: checkcast kotlin/ranges/IntProgression
/*      */     //   465: bipush #61
/*      */     //   467: aload_0
/*      */     //   468: getfield circleAccuracy : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   471: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   474: checkcast java/lang/Number
/*      */     //   477: invokevirtual intValue : ()I
/*      */     //   480: isub
/*      */     //   481: invokestatic step : (Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;
/*      */     //   484: dup
/*      */     //   485: dup
/*      */     //   486: invokevirtual getFirst : ()I
/*      */     //   489: istore #6
/*      */     //   491: invokevirtual getLast : ()I
/*      */     //   494: istore #7
/*      */     //   496: invokevirtual getStep : ()I
/*      */     //   499: istore #8
/*      */     //   501: iload #6
/*      */     //   503: iload #7
/*      */     //   505: iload #8
/*      */     //   507: iflt -> 516
/*      */     //   510: if_icmpgt -> 619
/*      */     //   513: goto -> 519
/*      */     //   516: if_icmplt -> 619
/*      */     //   519: iload #6
/*      */     //   521: i2d
/*      */     //   522: ldc2_w 3.141592653589793
/*      */     //   525: dmul
/*      */     //   526: ldc2_w 180.0
/*      */     //   529: ddiv
/*      */     //   530: dstore #9
/*      */     //   532: iconst_0
/*      */     //   533: istore #11
/*      */     //   535: dload #9
/*      */     //   537: invokestatic cos : (D)D
/*      */     //   540: d2f
/*      */     //   541: aload_0
/*      */     //   542: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   545: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   548: checkcast java/lang/Number
/*      */     //   551: invokevirtual floatValue : ()F
/*      */     //   554: fmul
/*      */     //   555: iload #6
/*      */     //   557: i2d
/*      */     //   558: ldc2_w 3.141592653589793
/*      */     //   561: dmul
/*      */     //   562: ldc2_w 180.0
/*      */     //   565: ddiv
/*      */     //   566: dstore #9
/*      */     //   568: fstore #34
/*      */     //   570: iconst_0
/*      */     //   571: istore #11
/*      */     //   573: dload #9
/*      */     //   575: invokestatic sin : (D)D
/*      */     //   578: dstore #35
/*      */     //   580: fload #34
/*      */     //   582: dload #35
/*      */     //   584: d2f
/*      */     //   585: aload_0
/*      */     //   586: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   589: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   592: checkcast java/lang/Number
/*      */     //   595: invokevirtual floatValue : ()F
/*      */     //   598: fmul
/*      */     //   599: invokestatic glVertex2f : (FF)V
/*      */     //   602: iload #6
/*      */     //   604: iload #7
/*      */     //   606: if_icmpeq -> 619
/*      */     //   609: iload #6
/*      */     //   611: iload #8
/*      */     //   613: iadd
/*      */     //   614: istore #6
/*      */     //   616: goto -> 519
/*      */     //   619: ldc2_w 6.283185307179586
/*      */     //   622: dstore #6
/*      */     //   624: iconst_0
/*      */     //   625: istore #8
/*      */     //   627: dload #6
/*      */     //   629: invokestatic cos : (D)D
/*      */     //   632: d2f
/*      */     //   633: aload_0
/*      */     //   634: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   637: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   640: checkcast java/lang/Number
/*      */     //   643: invokevirtual floatValue : ()F
/*      */     //   646: fmul
/*      */     //   647: ldc2_w 6.283185307179586
/*      */     //   650: dstore #6
/*      */     //   652: fstore #34
/*      */     //   654: iconst_0
/*      */     //   655: istore #8
/*      */     //   657: dload #6
/*      */     //   659: invokestatic sin : (D)D
/*      */     //   662: dstore #35
/*      */     //   664: fload #34
/*      */     //   666: dload #35
/*      */     //   668: d2f
/*      */     //   669: aload_0
/*      */     //   670: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   673: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   676: checkcast java/lang/Number
/*      */     //   679: invokevirtual floatValue : ()F
/*      */     //   682: fmul
/*      */     //   683: invokestatic glVertex2f : (FF)V
/*      */     //   686: invokestatic glEnd : ()V
/*      */     //   689: sipush #3042
/*      */     //   692: invokestatic glDisable : (I)V
/*      */     //   695: sipush #3553
/*      */     //   698: invokestatic glEnable : (I)V
/*      */     //   701: sipush #2929
/*      */     //   704: invokestatic glEnable : (I)V
/*      */     //   707: sipush #2848
/*      */     //   710: invokestatic glDisable : (I)V
/*      */     //   713: invokestatic glPopMatrix : ()V
/*      */     //   716: aload_0
/*      */     //   717: astore #6
/*      */     //   719: iconst_0
/*      */     //   720: istore #7
/*      */     //   722: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   725: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   730: dup
/*      */     //   731: ifnonnull -> 737
/*      */     //   734: invokestatic throwNpe : ()V
/*      */     //   737: invokeinterface isSpectator : ()Z
/*      */     //   742: ifne -> 878
/*      */     //   745: aload #6
/*      */     //   747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   750: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   755: dup
/*      */     //   756: ifnonnull -> 762
/*      */     //   759: invokestatic throwNpe : ()V
/*      */     //   762: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   765: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   768: ifeq -> 878
/*      */     //   771: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   774: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   777: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   780: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   783: invokevirtual getState : ()Z
/*      */     //   786: ifne -> 878
/*      */     //   789: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   792: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   795: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   798: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   801: invokevirtual getState : ()Z
/*      */     //   804: ifne -> 878
/*      */     //   807: aload #6
/*      */     //   809: invokestatic access$getNoScaffoldValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   812: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   815: checkcast java/lang/Boolean
/*      */     //   818: invokevirtual booleanValue : ()Z
/*      */     //   821: ifeq -> 882
/*      */     //   824: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   827: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   830: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold
/*      */     //   833: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   836: invokevirtual getState : ()Z
/*      */     //   839: ifne -> 878
/*      */     //   842: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   845: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   848: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/Scaffold2
/*      */     //   851: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   854: invokevirtual getState : ()Z
/*      */     //   857: ifne -> 878
/*      */     //   860: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   863: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   866: ldc_w net/ccbluex/liquidbounce/features/module/modules/world/GroundTelly
/*      */     //   869: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   872: invokevirtual getState : ()Z
/*      */     //   875: ifeq -> 882
/*      */     //   878: iconst_1
/*      */     //   879: goto -> 883
/*      */     //   882: iconst_0
/*      */     //   883: ifeq -> 912
/*      */     //   886: aload_0
/*      */     //   887: aconst_null
/*      */     //   888: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   891: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   894: aload_0
/*      */     //   895: aconst_null
/*      */     //   896: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   899: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   902: aload_0
/*      */     //   903: iconst_0
/*      */     //   904: putfield hitable : Z
/*      */     //   907: aload_0
/*      */     //   908: invokespecial stopBlocking : ()V
/*      */     //   911: return
/*      */     //   912: aload_0
/*      */     //   913: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   916: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   919: checkcast java/lang/Boolean
/*      */     //   922: invokevirtual booleanValue : ()Z
/*      */     //   925: ifeq -> 1020
/*      */     //   928: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   931: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   934: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   939: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   944: ifne -> 972
/*      */     //   947: invokestatic currentTimeMillis : ()J
/*      */     //   950: aload_0
/*      */     //   951: getfield containerOpen : J
/*      */     //   954: lsub
/*      */     //   955: aload_0
/*      */     //   956: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   959: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   962: checkcast java/lang/Number
/*      */     //   965: invokevirtual longValue : ()J
/*      */     //   968: lcmp
/*      */     //   969: ifge -> 1020
/*      */     //   972: aload_0
/*      */     //   973: aconst_null
/*      */     //   974: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   977: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   980: aload_0
/*      */     //   981: aconst_null
/*      */     //   982: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   985: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   988: aload_0
/*      */     //   989: iconst_0
/*      */     //   990: putfield hitable : Z
/*      */     //   993: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   996: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   999: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1004: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1009: ifeq -> 1019
/*      */     //   1012: aload_0
/*      */     //   1013: invokestatic currentTimeMillis : ()J
/*      */     //   1016: putfield containerOpen : J
/*      */     //   1019: return
/*      */     //   1020: aload_0
/*      */     //   1021: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1024: dup
/*      */     //   1025: ifnull -> 1031
/*      */     //   1028: goto -> 1033
/*      */     //   1031: pop
/*      */     //   1032: return
/*      */     //   1033: pop
/*      */     //   1034: aload_0
/*      */     //   1035: getfield markValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   1038: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1041: checkcast java/lang/String
/*      */     //   1044: astore #6
/*      */     //   1046: iconst_0
/*      */     //   1047: istore #7
/*      */     //   1049: aload #6
/*      */     //   1051: dup
/*      */     //   1052: ifnonnull -> 1066
/*      */     //   1055: new kotlin/TypeCastException
/*      */     //   1058: dup
/*      */     //   1059: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   1062: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   1065: athrow
/*      */     //   1066: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   1069: dup
/*      */     //   1070: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   1073: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   1076: astore #6
/*      */     //   1078: aload #6
/*      */     //   1080: invokevirtual hashCode : ()I
/*      */     //   1083: lookupswitch default -> 3697, -1102567108 -> 1190, 101234 -> 1176, 112785 -> 1148, 3443503 -> 1232, 3530364 -> 1204, 93832333 -> 1218, 101009364 -> 1162
/*      */     //   1148: aload #6
/*      */     //   1150: ldc_w 'red'
/*      */     //   1153: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1156: ifeq -> 3697
/*      */     //   1159: goto -> 1601
/*      */     //   1162: aload #6
/*      */     //   1164: ldc_w 'jello'
/*      */     //   1167: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1170: ifeq -> 3697
/*      */     //   1173: goto -> 2876
/*      */     //   1176: aload #6
/*      */     //   1178: ldc_w 'fdp'
/*      */     //   1181: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1184: ifeq -> 3697
/*      */     //   1187: goto -> 2174
/*      */     //   1190: aload #6
/*      */     //   1192: ldc_w 'liquid'
/*      */     //   1195: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1198: ifeq -> 3697
/*      */     //   1201: goto -> 1246
/*      */     //   1204: aload #6
/*      */     //   1206: ldc_w 'sims'
/*      */     //   1209: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1212: ifeq -> 3697
/*      */     //   1215: goto -> 1680
/*      */     //   1218: aload #6
/*      */     //   1220: ldc_w 'block'
/*      */     //   1223: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1226: ifeq -> 3697
/*      */     //   1229: goto -> 1380
/*      */     //   1232: aload #6
/*      */     //   1234: ldc_w 'plat'
/*      */     //   1237: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1240: ifeq -> 3697
/*      */     //   1243: goto -> 1320
/*      */     //   1246: aload_0
/*      */     //   1247: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1250: dup
/*      */     //   1251: ifnonnull -> 1257
/*      */     //   1254: invokestatic throwNpe : ()V
/*      */     //   1257: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1260: aload_0
/*      */     //   1261: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1264: dup
/*      */     //   1265: ifnonnull -> 1271
/*      */     //   1268: invokestatic throwNpe : ()V
/*      */     //   1271: invokeinterface getHurtTime : ()I
/*      */     //   1276: ifgt -> 1299
/*      */     //   1279: new java/awt/Color
/*      */     //   1282: dup
/*      */     //   1283: bipush #37
/*      */     //   1285: bipush #126
/*      */     //   1287: sipush #255
/*      */     //   1290: sipush #170
/*      */     //   1293: invokespecial <init> : (IIII)V
/*      */     //   1296: goto -> 1314
/*      */     //   1299: new java/awt/Color
/*      */     //   1302: dup
/*      */     //   1303: sipush #255
/*      */     //   1306: iconst_0
/*      */     //   1307: iconst_0
/*      */     //   1308: sipush #170
/*      */     //   1311: invokespecial <init> : (IIII)V
/*      */     //   1314: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1317: goto -> 3697
/*      */     //   1320: aload_0
/*      */     //   1321: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1324: dup
/*      */     //   1325: ifnonnull -> 1331
/*      */     //   1328: invokestatic throwNpe : ()V
/*      */     //   1331: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1334: aload_0
/*      */     //   1335: getfield hitable : Z
/*      */     //   1338: ifeq -> 1360
/*      */     //   1341: new java/awt/Color
/*      */     //   1344: dup
/*      */     //   1345: bipush #37
/*      */     //   1347: bipush #126
/*      */     //   1349: sipush #255
/*      */     //   1352: bipush #70
/*      */     //   1354: invokespecial <init> : (IIII)V
/*      */     //   1357: goto -> 1374
/*      */     //   1360: new java/awt/Color
/*      */     //   1363: dup
/*      */     //   1364: sipush #255
/*      */     //   1367: iconst_0
/*      */     //   1368: iconst_0
/*      */     //   1369: bipush #70
/*      */     //   1371: invokespecial <init> : (IIII)V
/*      */     //   1374: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1377: goto -> 3697
/*      */     //   1380: aload_0
/*      */     //   1381: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1384: dup
/*      */     //   1385: ifnonnull -> 1391
/*      */     //   1388: invokestatic throwNpe : ()V
/*      */     //   1391: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1396: astore #7
/*      */     //   1398: aload_0
/*      */     //   1399: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1402: dup
/*      */     //   1403: ifnonnull -> 1409
/*      */     //   1406: invokestatic throwNpe : ()V
/*      */     //   1409: aload #7
/*      */     //   1411: ldc2_w 0.2
/*      */     //   1414: ldc2_w 0.2
/*      */     //   1417: ldc2_w 0.2
/*      */     //   1420: invokeinterface expand : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1425: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   1430: aload_0
/*      */     //   1431: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1434: dup
/*      */     //   1435: ifnonnull -> 1441
/*      */     //   1438: invokestatic throwNpe : ()V
/*      */     //   1441: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1444: aload_0
/*      */     //   1445: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1448: dup
/*      */     //   1449: ifnonnull -> 1455
/*      */     //   1452: invokestatic throwNpe : ()V
/*      */     //   1455: invokeinterface getHurtTime : ()I
/*      */     //   1460: ifgt -> 1521
/*      */     //   1463: new java/awt/Color
/*      */     //   1466: dup
/*      */     //   1467: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1470: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1473: checkcast java/lang/Number
/*      */     //   1476: invokevirtual intValue : ()I
/*      */     //   1479: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1482: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1485: checkcast java/lang/Number
/*      */     //   1488: invokevirtual intValue : ()I
/*      */     //   1491: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1494: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1497: checkcast java/lang/Number
/*      */     //   1500: invokevirtual intValue : ()I
/*      */     //   1503: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.a : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1506: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1509: checkcast java/lang/Number
/*      */     //   1512: invokevirtual intValue : ()I
/*      */     //   1515: invokespecial <init> : (IIII)V
/*      */     //   1518: goto -> 1576
/*      */     //   1521: new java/awt/Color
/*      */     //   1524: dup
/*      */     //   1525: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1528: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1531: checkcast java/lang/Number
/*      */     //   1534: invokevirtual intValue : ()I
/*      */     //   1537: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1540: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1543: checkcast java/lang/Number
/*      */     //   1546: invokevirtual intValue : ()I
/*      */     //   1549: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1552: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1555: checkcast java/lang/Number
/*      */     //   1558: invokevirtual intValue : ()I
/*      */     //   1561: getstatic net/ccbluex/liquidbounce/features/module/modules/render/AColorPalette.a : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1564: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1567: checkcast java/lang/Number
/*      */     //   1570: invokevirtual intValue : ()I
/*      */     //   1573: invokespecial <init> : (IIII)V
/*      */     //   1576: iconst_1
/*      */     //   1577: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*      */     //   1580: aload_0
/*      */     //   1581: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1584: dup
/*      */     //   1585: ifnonnull -> 1591
/*      */     //   1588: invokestatic throwNpe : ()V
/*      */     //   1591: aload #7
/*      */     //   1593: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   1598: goto -> 3697
/*      */     //   1601: aload_0
/*      */     //   1602: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1605: dup
/*      */     //   1606: ifnonnull -> 1612
/*      */     //   1609: invokestatic throwNpe : ()V
/*      */     //   1612: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1615: aload_0
/*      */     //   1616: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1619: dup
/*      */     //   1620: ifnonnull -> 1626
/*      */     //   1623: invokestatic throwNpe : ()V
/*      */     //   1626: invokeinterface getHurtTime : ()I
/*      */     //   1631: ifgt -> 1656
/*      */     //   1634: new java/awt/Color
/*      */     //   1637: dup
/*      */     //   1638: sipush #255
/*      */     //   1641: sipush #255
/*      */     //   1644: sipush #255
/*      */     //   1647: sipush #255
/*      */     //   1650: invokespecial <init> : (IIII)V
/*      */     //   1653: goto -> 1674
/*      */     //   1656: new java/awt/Color
/*      */     //   1659: dup
/*      */     //   1660: bipush #124
/*      */     //   1662: sipush #215
/*      */     //   1665: sipush #255
/*      */     //   1668: sipush #255
/*      */     //   1671: invokespecial <init> : (IIII)V
/*      */     //   1674: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1677: goto -> 3697
/*      */     //   1680: ldc_w 0.15
/*      */     //   1683: fstore #7
/*      */     //   1685: iconst_4
/*      */     //   1686: istore #8
/*      */     //   1688: invokestatic glPushMatrix : ()V
/*      */     //   1691: aload_0
/*      */     //   1692: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1695: dup
/*      */     //   1696: ifnonnull -> 1702
/*      */     //   1699: invokestatic throwNpe : ()V
/*      */     //   1702: invokeinterface getLastTickPosX : ()D
/*      */     //   1707: aload_0
/*      */     //   1708: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1711: dup
/*      */     //   1712: ifnonnull -> 1718
/*      */     //   1715: invokestatic throwNpe : ()V
/*      */     //   1718: invokeinterface getPosX : ()D
/*      */     //   1723: aload_0
/*      */     //   1724: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1727: dup
/*      */     //   1728: ifnonnull -> 1734
/*      */     //   1731: invokestatic throwNpe : ()V
/*      */     //   1734: invokeinterface getLastTickPosX : ()D
/*      */     //   1739: dsub
/*      */     //   1740: aload_1
/*      */     //   1741: invokevirtual getPartialTicks : ()F
/*      */     //   1744: f2d
/*      */     //   1745: dmul
/*      */     //   1746: dadd
/*      */     //   1747: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1750: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1755: invokeinterface getViewerPosX : ()D
/*      */     //   1760: dsub
/*      */     //   1761: aload_0
/*      */     //   1762: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1765: dup
/*      */     //   1766: ifnonnull -> 1772
/*      */     //   1769: invokestatic throwNpe : ()V
/*      */     //   1772: invokeinterface getLastTickPosY : ()D
/*      */     //   1777: aload_0
/*      */     //   1778: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1781: dup
/*      */     //   1782: ifnonnull -> 1788
/*      */     //   1785: invokestatic throwNpe : ()V
/*      */     //   1788: invokeinterface getPosY : ()D
/*      */     //   1793: aload_0
/*      */     //   1794: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1797: dup
/*      */     //   1798: ifnonnull -> 1804
/*      */     //   1801: invokestatic throwNpe : ()V
/*      */     //   1804: invokeinterface getLastTickPosY : ()D
/*      */     //   1809: dsub
/*      */     //   1810: aload_1
/*      */     //   1811: invokevirtual getPartialTicks : ()F
/*      */     //   1814: f2d
/*      */     //   1815: dmul
/*      */     //   1816: dadd
/*      */     //   1817: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1820: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1825: invokeinterface getViewerPosY : ()D
/*      */     //   1830: dsub
/*      */     //   1831: aload_0
/*      */     //   1832: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1835: dup
/*      */     //   1836: ifnonnull -> 1842
/*      */     //   1839: invokestatic throwNpe : ()V
/*      */     //   1842: invokeinterface getHeight : ()F
/*      */     //   1847: f2d
/*      */     //   1848: ldc2_w 1.1
/*      */     //   1851: dmul
/*      */     //   1852: dadd
/*      */     //   1853: aload_0
/*      */     //   1854: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1857: dup
/*      */     //   1858: ifnonnull -> 1864
/*      */     //   1861: invokestatic throwNpe : ()V
/*      */     //   1864: invokeinterface getLastTickPosZ : ()D
/*      */     //   1869: aload_0
/*      */     //   1870: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1873: dup
/*      */     //   1874: ifnonnull -> 1880
/*      */     //   1877: invokestatic throwNpe : ()V
/*      */     //   1880: invokeinterface getPosZ : ()D
/*      */     //   1885: aload_0
/*      */     //   1886: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1889: dup
/*      */     //   1890: ifnonnull -> 1896
/*      */     //   1893: invokestatic throwNpe : ()V
/*      */     //   1896: invokeinterface getLastTickPosZ : ()D
/*      */     //   1901: dsub
/*      */     //   1902: aload_1
/*      */     //   1903: invokevirtual getPartialTicks : ()F
/*      */     //   1906: f2d
/*      */     //   1907: dmul
/*      */     //   1908: dadd
/*      */     //   1909: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1912: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1917: invokeinterface getViewerPosZ : ()D
/*      */     //   1922: dsub
/*      */     //   1923: invokestatic glTranslated : (DDD)V
/*      */     //   1926: aload_0
/*      */     //   1927: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1930: dup
/*      */     //   1931: ifnonnull -> 1937
/*      */     //   1934: invokestatic throwNpe : ()V
/*      */     //   1937: invokeinterface getWidth : ()F
/*      */     //   1942: fneg
/*      */     //   1943: fconst_0
/*      */     //   1944: fconst_1
/*      */     //   1945: fconst_0
/*      */     //   1946: invokestatic glRotatef : (FFFF)V
/*      */     //   1949: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1952: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1957: dup
/*      */     //   1958: ifnonnull -> 1964
/*      */     //   1961: invokestatic throwNpe : ()V
/*      */     //   1964: invokeinterface getTicksExisted : ()I
/*      */     //   1969: i2f
/*      */     //   1970: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1973: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   1978: invokeinterface getRenderPartialTicks : ()F
/*      */     //   1983: fadd
/*      */     //   1984: iconst_5
/*      */     //   1985: i2f
/*      */     //   1986: fmul
/*      */     //   1987: fconst_0
/*      */     //   1988: fconst_1
/*      */     //   1989: fconst_0
/*      */     //   1990: invokestatic glRotatef : (FFFF)V
/*      */     //   1993: aload_0
/*      */     //   1994: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1997: dup
/*      */     //   1998: ifnonnull -> 2004
/*      */     //   2001: invokestatic throwNpe : ()V
/*      */     //   2004: invokeinterface getHurtTime : ()I
/*      */     //   2009: ifgt -> 2029
/*      */     //   2012: new java/awt/Color
/*      */     //   2015: dup
/*      */     //   2016: bipush #80
/*      */     //   2018: sipush #255
/*      */     //   2021: bipush #80
/*      */     //   2023: invokespecial <init> : (III)V
/*      */     //   2026: goto -> 2041
/*      */     //   2029: new java/awt/Color
/*      */     //   2032: dup
/*      */     //   2033: sipush #255
/*      */     //   2036: iconst_0
/*      */     //   2037: iconst_0
/*      */     //   2038: invokespecial <init> : (III)V
/*      */     //   2041: invokestatic glColor : (Ljava/awt/Color;)V
/*      */     //   2044: ldc_w 1.5
/*      */     //   2047: invokestatic enableSmoothLine : (F)V
/*      */     //   2050: new org/lwjgl/util/glu/Cylinder
/*      */     //   2053: dup
/*      */     //   2054: invokespecial <init> : ()V
/*      */     //   2057: astore #9
/*      */     //   2059: ldc_w -90.0
/*      */     //   2062: fconst_1
/*      */     //   2063: fconst_0
/*      */     //   2064: fconst_0
/*      */     //   2065: invokestatic glRotatef : (FFFF)V
/*      */     //   2068: aload #9
/*      */     //   2070: fconst_0
/*      */     //   2071: fload #7
/*      */     //   2073: ldc_w 0.3
/*      */     //   2076: iload #8
/*      */     //   2078: iconst_1
/*      */     //   2079: invokevirtual draw : (FFFII)V
/*      */     //   2082: aload #9
/*      */     //   2084: ldc_w 100012
/*      */     //   2087: invokevirtual setDrawStyle : (I)V
/*      */     //   2090: dconst_0
/*      */     //   2091: dconst_0
/*      */     //   2092: ldc2_w 0.3
/*      */     //   2095: invokestatic glTranslated : (DDD)V
/*      */     //   2098: aload #9
/*      */     //   2100: fload #7
/*      */     //   2102: fconst_0
/*      */     //   2103: ldc_w 0.3
/*      */     //   2106: iload #8
/*      */     //   2108: iconst_1
/*      */     //   2109: invokevirtual draw : (FFFII)V
/*      */     //   2112: ldc_w 90.0
/*      */     //   2115: fconst_0
/*      */     //   2116: fconst_0
/*      */     //   2117: fconst_1
/*      */     //   2118: invokestatic glRotatef : (FFFF)V
/*      */     //   2121: dconst_0
/*      */     //   2122: dconst_0
/*      */     //   2123: ldc2_w -0.3
/*      */     //   2126: invokestatic glTranslated : (DDD)V
/*      */     //   2129: aload #9
/*      */     //   2131: fconst_0
/*      */     //   2132: fload #7
/*      */     //   2134: ldc_w 0.3
/*      */     //   2137: iload #8
/*      */     //   2139: iconst_1
/*      */     //   2140: invokevirtual draw : (FFFII)V
/*      */     //   2143: dconst_0
/*      */     //   2144: dconst_0
/*      */     //   2145: ldc2_w 0.3
/*      */     //   2148: invokestatic glTranslated : (DDD)V
/*      */     //   2151: aload #9
/*      */     //   2153: fload #7
/*      */     //   2155: fconst_0
/*      */     //   2156: ldc_w 0.3
/*      */     //   2159: iload #8
/*      */     //   2161: iconst_1
/*      */     //   2162: invokevirtual draw : (FFFII)V
/*      */     //   2165: invokestatic disableSmoothLine : ()V
/*      */     //   2168: invokestatic glPopMatrix : ()V
/*      */     //   2171: goto -> 3697
/*      */     //   2174: invokestatic currentTimeMillis : ()J
/*      */     //   2177: sipush #1500
/*      */     //   2180: i2l
/*      */     //   2181: lrem
/*      */     //   2182: l2i
/*      */     //   2183: istore #7
/*      */     //   2185: iload #7
/*      */     //   2187: sipush #750
/*      */     //   2190: if_icmple -> 2197
/*      */     //   2193: iconst_1
/*      */     //   2194: goto -> 2198
/*      */     //   2197: iconst_0
/*      */     //   2198: istore #8
/*      */     //   2200: iload #7
/*      */     //   2202: i2d
/*      */     //   2203: ldc2_w 750.0
/*      */     //   2206: ddiv
/*      */     //   2207: dstore #9
/*      */     //   2209: iload #8
/*      */     //   2211: ifne -> 2224
/*      */     //   2214: iconst_1
/*      */     //   2215: i2d
/*      */     //   2216: dload #9
/*      */     //   2218: dsub
/*      */     //   2219: dstore #9
/*      */     //   2221: goto -> 2231
/*      */     //   2224: dload #9
/*      */     //   2226: iconst_1
/*      */     //   2227: i2d
/*      */     //   2228: dsub
/*      */     //   2229: dstore #9
/*      */     //   2231: dload #9
/*      */     //   2233: invokestatic easeInOutQuad : (D)D
/*      */     //   2236: dstore #9
/*      */     //   2238: invokestatic glPushMatrix : ()V
/*      */     //   2241: sipush #3553
/*      */     //   2244: invokestatic glDisable : (I)V
/*      */     //   2247: sipush #2848
/*      */     //   2250: invokestatic glEnable : (I)V
/*      */     //   2253: sipush #2881
/*      */     //   2256: invokestatic glEnable : (I)V
/*      */     //   2259: sipush #2832
/*      */     //   2262: invokestatic glEnable : (I)V
/*      */     //   2265: sipush #3042
/*      */     //   2268: invokestatic glEnable : (I)V
/*      */     //   2271: sipush #770
/*      */     //   2274: sipush #771
/*      */     //   2277: invokestatic glBlendFunc : (II)V
/*      */     //   2280: sipush #3154
/*      */     //   2283: sipush #4354
/*      */     //   2286: invokestatic glHint : (II)V
/*      */     //   2289: sipush #3155
/*      */     //   2292: sipush #4354
/*      */     //   2295: invokestatic glHint : (II)V
/*      */     //   2298: sipush #3153
/*      */     //   2301: sipush #4354
/*      */     //   2304: invokestatic glHint : (II)V
/*      */     //   2307: sipush #2929
/*      */     //   2310: invokestatic glDisable : (I)V
/*      */     //   2313: iconst_0
/*      */     //   2314: invokestatic glDepthMask : (Z)V
/*      */     //   2317: aload_0
/*      */     //   2318: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2321: dup
/*      */     //   2322: ifnonnull -> 2328
/*      */     //   2325: invokestatic throwNpe : ()V
/*      */     //   2328: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2333: astore #11
/*      */     //   2335: aload #11
/*      */     //   2337: invokeinterface getMaxX : ()D
/*      */     //   2342: aload #11
/*      */     //   2344: invokeinterface getMinX : ()D
/*      */     //   2349: dsub
/*      */     //   2350: ldc2_w 0.3
/*      */     //   2353: dadd
/*      */     //   2354: dstore #12
/*      */     //   2356: aload #11
/*      */     //   2358: invokeinterface getMaxY : ()D
/*      */     //   2363: aload #11
/*      */     //   2365: invokeinterface getMinY : ()D
/*      */     //   2370: dsub
/*      */     //   2371: dstore #14
/*      */     //   2373: aload_0
/*      */     //   2374: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2377: dup
/*      */     //   2378: ifnonnull -> 2384
/*      */     //   2381: invokestatic throwNpe : ()V
/*      */     //   2384: invokeinterface getLastTickPosX : ()D
/*      */     //   2389: aload_0
/*      */     //   2390: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2393: dup
/*      */     //   2394: ifnonnull -> 2400
/*      */     //   2397: invokestatic throwNpe : ()V
/*      */     //   2400: invokeinterface getPosX : ()D
/*      */     //   2405: aload_0
/*      */     //   2406: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2409: dup
/*      */     //   2410: ifnonnull -> 2416
/*      */     //   2413: invokestatic throwNpe : ()V
/*      */     //   2416: invokeinterface getLastTickPosX : ()D
/*      */     //   2421: dsub
/*      */     //   2422: aload_1
/*      */     //   2423: invokevirtual getPartialTicks : ()F
/*      */     //   2426: f2d
/*      */     //   2427: dmul
/*      */     //   2428: dadd
/*      */     //   2429: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2432: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2437: invokeinterface getViewerPosX : ()D
/*      */     //   2442: dsub
/*      */     //   2443: dstore #16
/*      */     //   2445: aload_0
/*      */     //   2446: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2449: dup
/*      */     //   2450: ifnonnull -> 2456
/*      */     //   2453: invokestatic throwNpe : ()V
/*      */     //   2456: invokeinterface getLastTickPosY : ()D
/*      */     //   2461: aload_0
/*      */     //   2462: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2465: dup
/*      */     //   2466: ifnonnull -> 2472
/*      */     //   2469: invokestatic throwNpe : ()V
/*      */     //   2472: invokeinterface getPosY : ()D
/*      */     //   2477: aload_0
/*      */     //   2478: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2481: dup
/*      */     //   2482: ifnonnull -> 2488
/*      */     //   2485: invokestatic throwNpe : ()V
/*      */     //   2488: invokeinterface getLastTickPosY : ()D
/*      */     //   2493: dsub
/*      */     //   2494: aload_1
/*      */     //   2495: invokevirtual getPartialTicks : ()F
/*      */     //   2498: f2d
/*      */     //   2499: dmul
/*      */     //   2500: dadd
/*      */     //   2501: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2504: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2509: invokeinterface getViewerPosY : ()D
/*      */     //   2514: dsub
/*      */     //   2515: dload #14
/*      */     //   2517: dload #9
/*      */     //   2519: dmul
/*      */     //   2520: dadd
/*      */     //   2521: dstore #18
/*      */     //   2523: aload_0
/*      */     //   2524: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2527: dup
/*      */     //   2528: ifnonnull -> 2534
/*      */     //   2531: invokestatic throwNpe : ()V
/*      */     //   2534: invokeinterface getLastTickPosZ : ()D
/*      */     //   2539: aload_0
/*      */     //   2540: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2543: dup
/*      */     //   2544: ifnonnull -> 2550
/*      */     //   2547: invokestatic throwNpe : ()V
/*      */     //   2550: invokeinterface getPosZ : ()D
/*      */     //   2555: aload_0
/*      */     //   2556: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2559: dup
/*      */     //   2560: ifnonnull -> 2566
/*      */     //   2563: invokestatic throwNpe : ()V
/*      */     //   2566: invokeinterface getLastTickPosZ : ()D
/*      */     //   2571: dsub
/*      */     //   2572: aload_1
/*      */     //   2573: invokevirtual getPartialTicks : ()F
/*      */     //   2576: f2d
/*      */     //   2577: dmul
/*      */     //   2578: dadd
/*      */     //   2579: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2582: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2587: invokeinterface getViewerPosZ : ()D
/*      */     //   2592: dsub
/*      */     //   2593: dstore #20
/*      */     //   2595: dload #12
/*      */     //   2597: ldc_w 5.0
/*      */     //   2600: f2d
/*      */     //   2601: dmul
/*      */     //   2602: d2f
/*      */     //   2603: invokestatic glLineWidth : (F)V
/*      */     //   2606: iconst_3
/*      */     //   2607: invokestatic glBegin : (I)V
/*      */     //   2610: iconst_0
/*      */     //   2611: istore #22
/*      */     //   2613: sipush #360
/*      */     //   2616: istore #23
/*      */     //   2618: iload #22
/*      */     //   2620: iload #23
/*      */     //   2622: if_icmpgt -> 2833
/*      */     //   2625: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2628: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   2633: dup
/*      */     //   2634: ifnonnull -> 2640
/*      */     //   2637: invokestatic throwNpe : ()V
/*      */     //   2640: invokeinterface getTicksExisted : ()I
/*      */     //   2645: i2d
/*      */     //   2646: ldc2_w 70.0
/*      */     //   2649: ddiv
/*      */     //   2650: iload #22
/*      */     //   2652: i2d
/*      */     //   2653: ldc2_w 50.0
/*      */     //   2656: ddiv
/*      */     //   2657: ldc2_w 1.75
/*      */     //   2660: dmul
/*      */     //   2661: dstore #25
/*      */     //   2663: dstore #36
/*      */     //   2665: iconst_0
/*      */     //   2666: istore #27
/*      */     //   2668: dload #25
/*      */     //   2670: invokestatic sin : (D)D
/*      */     //   2673: dstore #38
/*      */     //   2675: dload #36
/*      */     //   2677: dload #38
/*      */     //   2679: dadd
/*      */     //   2680: d2f
/*      */     //   2681: fconst_1
/*      */     //   2682: frem
/*      */     //   2683: ldc_w 0.7
/*      */     //   2686: fconst_1
/*      */     //   2687: invokestatic HSBtoRGB : (FFF)I
/*      */     //   2690: istore #44
/*      */     //   2692: new java/awt/Color
/*      */     //   2695: dup
/*      */     //   2696: iload #44
/*      */     //   2698: invokespecial <init> : (I)V
/*      */     //   2701: astore #24
/*      */     //   2703: aload #24
/*      */     //   2705: invokevirtual getRed : ()I
/*      */     //   2708: i2f
/*      */     //   2709: ldc_w 255.0
/*      */     //   2712: fdiv
/*      */     //   2713: aload #24
/*      */     //   2715: invokevirtual getGreen : ()I
/*      */     //   2718: i2f
/*      */     //   2719: ldc_w 255.0
/*      */     //   2722: fdiv
/*      */     //   2723: aload #24
/*      */     //   2725: invokevirtual getBlue : ()I
/*      */     //   2728: i2f
/*      */     //   2729: ldc_w 255.0
/*      */     //   2732: fdiv
/*      */     //   2733: invokestatic glColor3f : (FFF)V
/*      */     //   2736: dload #16
/*      */     //   2738: dload #12
/*      */     //   2740: iload #22
/*      */     //   2742: i2d
/*      */     //   2743: ldc2_w 6.283185307179586
/*      */     //   2746: dmul
/*      */     //   2747: ldc2_w 45.0
/*      */     //   2750: ddiv
/*      */     //   2751: dstore #25
/*      */     //   2753: dstore #36
/*      */     //   2755: dstore #34
/*      */     //   2757: iconst_0
/*      */     //   2758: istore #27
/*      */     //   2760: dload #25
/*      */     //   2762: invokestatic cos : (D)D
/*      */     //   2765: dstore #38
/*      */     //   2767: dload #34
/*      */     //   2769: dload #36
/*      */     //   2771: dload #38
/*      */     //   2773: dmul
/*      */     //   2774: dadd
/*      */     //   2775: dload #18
/*      */     //   2777: dload #20
/*      */     //   2779: dload #12
/*      */     //   2781: iload #22
/*      */     //   2783: i2d
/*      */     //   2784: ldc2_w 6.283185307179586
/*      */     //   2787: dmul
/*      */     //   2788: ldc2_w 45.0
/*      */     //   2791: ddiv
/*      */     //   2792: dstore #25
/*      */     //   2794: dstore #40
/*      */     //   2796: dstore #38
/*      */     //   2798: dstore #36
/*      */     //   2800: dstore #34
/*      */     //   2802: iconst_0
/*      */     //   2803: istore #27
/*      */     //   2805: dload #25
/*      */     //   2807: invokestatic sin : (D)D
/*      */     //   2810: dstore #42
/*      */     //   2812: dload #34
/*      */     //   2814: dload #36
/*      */     //   2816: dload #38
/*      */     //   2818: dload #40
/*      */     //   2820: dload #42
/*      */     //   2822: dmul
/*      */     //   2823: dadd
/*      */     //   2824: invokestatic glVertex3d : (DDD)V
/*      */     //   2827: iinc #22, 1
/*      */     //   2830: goto -> 2618
/*      */     //   2833: invokestatic glEnd : ()V
/*      */     //   2836: iconst_1
/*      */     //   2837: invokestatic glDepthMask : (Z)V
/*      */     //   2840: sipush #2929
/*      */     //   2843: invokestatic glEnable : (I)V
/*      */     //   2846: sipush #2848
/*      */     //   2849: invokestatic glDisable : (I)V
/*      */     //   2852: sipush #2881
/*      */     //   2855: invokestatic glDisable : (I)V
/*      */     //   2858: sipush #2832
/*      */     //   2861: invokestatic glEnable : (I)V
/*      */     //   2864: sipush #3553
/*      */     //   2867: invokestatic glEnable : (I)V
/*      */     //   2870: invokestatic glPopMatrix : ()V
/*      */     //   2873: goto -> 3697
/*      */     //   2876: aload_0
/*      */     //   2877: getfield yPos : D
/*      */     //   2880: dstore #7
/*      */     //   2882: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$5.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$5;
/*      */     //   2885: astore #9
/*      */     //   2887: aload_0
/*      */     //   2888: getfield al : F
/*      */     //   2891: fconst_0
/*      */     //   2892: fcmpl
/*      */     //   2893: ifle -> 2988
/*      */     //   2896: invokestatic currentTimeMillis : ()J
/*      */     //   2899: aload_0
/*      */     //   2900: getfield lastMS : J
/*      */     //   2903: lsub
/*      */     //   2904: ldc2_w 1000
/*      */     //   2907: lcmp
/*      */     //   2908: iflt -> 2927
/*      */     //   2911: aload_0
/*      */     //   2912: aload_0
/*      */     //   2913: getfield direction : D
/*      */     //   2916: dneg
/*      */     //   2917: putfield direction : D
/*      */     //   2920: aload_0
/*      */     //   2921: invokestatic currentTimeMillis : ()J
/*      */     //   2924: putfield lastMS : J
/*      */     //   2927: aload_0
/*      */     //   2928: getfield direction : D
/*      */     //   2931: iconst_0
/*      */     //   2932: i2d
/*      */     //   2933: dcmpl
/*      */     //   2934: ifle -> 2948
/*      */     //   2937: invokestatic currentTimeMillis : ()J
/*      */     //   2940: aload_0
/*      */     //   2941: getfield lastMS : J
/*      */     //   2944: lsub
/*      */     //   2945: goto -> 2960
/*      */     //   2948: ldc2_w 1000
/*      */     //   2951: invokestatic currentTimeMillis : ()J
/*      */     //   2954: aload_0
/*      */     //   2955: getfield lastMS : J
/*      */     //   2958: lsub
/*      */     //   2959: lsub
/*      */     //   2960: lstore #10
/*      */     //   2962: aload_0
/*      */     //   2963: lload #10
/*      */     //   2965: l2d
/*      */     //   2966: ldc2_w 1000.0
/*      */     //   2969: ddiv
/*      */     //   2970: putfield progress : D
/*      */     //   2973: aload_0
/*      */     //   2974: invokestatic currentTimeMillis : ()J
/*      */     //   2977: aload_0
/*      */     //   2978: getfield lastMS : J
/*      */     //   2981: lsub
/*      */     //   2982: putfield lastDeltaMS : J
/*      */     //   2985: goto -> 3000
/*      */     //   2988: aload_0
/*      */     //   2989: invokestatic currentTimeMillis : ()J
/*      */     //   2992: aload_0
/*      */     //   2993: getfield lastDeltaMS : J
/*      */     //   2996: lsub
/*      */     //   2997: putfield lastMS : J
/*      */     //   3000: aload_0
/*      */     //   3001: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3004: ifnull -> 3035
/*      */     //   3007: aload_0
/*      */     //   3008: aload_0
/*      */     //   3009: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3012: putfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3015: aload_0
/*      */     //   3016: aload_0
/*      */     //   3017: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3020: dup
/*      */     //   3021: ifnonnull -> 3027
/*      */     //   3024: invokestatic throwNpe : ()V
/*      */     //   3027: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3032: putfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3035: aload_0
/*      */     //   3036: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3039: ifnull -> 3049
/*      */     //   3042: aload_0
/*      */     //   3043: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3046: ifnonnull -> 3050
/*      */     //   3049: return
/*      */     //   3050: aload_0
/*      */     //   3051: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3054: dup
/*      */     //   3055: ifnonnull -> 3061
/*      */     //   3058: invokestatic throwNpe : ()V
/*      */     //   3061: invokeinterface getMaxX : ()D
/*      */     //   3066: aload_0
/*      */     //   3067: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3070: dup
/*      */     //   3071: ifnonnull -> 3077
/*      */     //   3074: invokestatic throwNpe : ()V
/*      */     //   3077: invokeinterface getMinX : ()D
/*      */     //   3082: dsub
/*      */     //   3083: dstore #10
/*      */     //   3085: aload_0
/*      */     //   3086: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3089: dup
/*      */     //   3090: ifnonnull -> 3096
/*      */     //   3093: invokestatic throwNpe : ()V
/*      */     //   3096: invokeinterface getMaxY : ()D
/*      */     //   3101: aload_0
/*      */     //   3102: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   3105: dup
/*      */     //   3106: ifnonnull -> 3112
/*      */     //   3109: invokestatic throwNpe : ()V
/*      */     //   3112: invokeinterface getMinY : ()D
/*      */     //   3117: dsub
/*      */     //   3118: dstore #12
/*      */     //   3120: aload_0
/*      */     //   3121: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3124: dup
/*      */     //   3125: ifnonnull -> 3131
/*      */     //   3128: invokestatic throwNpe : ()V
/*      */     //   3131: invokeinterface getLastTickPosX : ()D
/*      */     //   3136: aload_0
/*      */     //   3137: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3140: dup
/*      */     //   3141: ifnonnull -> 3147
/*      */     //   3144: invokestatic throwNpe : ()V
/*      */     //   3147: invokeinterface getPosX : ()D
/*      */     //   3152: aload_0
/*      */     //   3153: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3156: dup
/*      */     //   3157: ifnonnull -> 3163
/*      */     //   3160: invokestatic throwNpe : ()V
/*      */     //   3163: invokeinterface getLastTickPosX : ()D
/*      */     //   3168: dsub
/*      */     //   3169: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3172: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3177: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3182: f2d
/*      */     //   3183: dmul
/*      */     //   3184: dadd
/*      */     //   3185: dstore #14
/*      */     //   3187: aload_0
/*      */     //   3188: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3191: dup
/*      */     //   3192: ifnonnull -> 3198
/*      */     //   3195: invokestatic throwNpe : ()V
/*      */     //   3198: invokeinterface getLastTickPosY : ()D
/*      */     //   3203: aload_0
/*      */     //   3204: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3207: dup
/*      */     //   3208: ifnonnull -> 3214
/*      */     //   3211: invokestatic throwNpe : ()V
/*      */     //   3214: invokeinterface getPosY : ()D
/*      */     //   3219: aload_0
/*      */     //   3220: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3223: dup
/*      */     //   3224: ifnonnull -> 3230
/*      */     //   3227: invokestatic throwNpe : ()V
/*      */     //   3230: invokeinterface getLastTickPosY : ()D
/*      */     //   3235: dsub
/*      */     //   3236: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3239: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3244: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3249: f2d
/*      */     //   3250: dmul
/*      */     //   3251: dadd
/*      */     //   3252: dstore #16
/*      */     //   3254: aload_0
/*      */     //   3255: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3258: dup
/*      */     //   3259: ifnonnull -> 3265
/*      */     //   3262: invokestatic throwNpe : ()V
/*      */     //   3265: invokeinterface getLastTickPosZ : ()D
/*      */     //   3270: aload_0
/*      */     //   3271: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3274: dup
/*      */     //   3275: ifnonnull -> 3281
/*      */     //   3278: invokestatic throwNpe : ()V
/*      */     //   3281: invokeinterface getPosZ : ()D
/*      */     //   3286: aload_0
/*      */     //   3287: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3290: dup
/*      */     //   3291: ifnonnull -> 3297
/*      */     //   3294: invokestatic throwNpe : ()V
/*      */     //   3297: invokeinterface getLastTickPosZ : ()D
/*      */     //   3302: dsub
/*      */     //   3303: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3306: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3311: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3316: f2d
/*      */     //   3317: dmul
/*      */     //   3318: dadd
/*      */     //   3319: dstore #18
/*      */     //   3321: aload_0
/*      */     //   3322: aload #9
/*      */     //   3324: aload_0
/*      */     //   3325: getfield progress : D
/*      */     //   3328: invokevirtual invoke : (D)D
/*      */     //   3331: dload #12
/*      */     //   3333: dmul
/*      */     //   3334: putfield yPos : D
/*      */     //   3337: aload_0
/*      */     //   3338: getfield direction : D
/*      */     //   3341: iconst_0
/*      */     //   3342: i2d
/*      */     //   3343: dcmpl
/*      */     //   3344: ifle -> 3357
/*      */     //   3347: aload_0
/*      */     //   3348: getfield yPos : D
/*      */     //   3351: dload #7
/*      */     //   3353: dsub
/*      */     //   3354: goto -> 3364
/*      */     //   3357: dload #7
/*      */     //   3359: aload_0
/*      */     //   3360: getfield yPos : D
/*      */     //   3363: dsub
/*      */     //   3364: aload_0
/*      */     //   3365: getfield direction : D
/*      */     //   3368: dneg
/*      */     //   3369: dmul
/*      */     //   3370: aload_0
/*      */     //   3371: getfield jelloGradientHeightValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   3374: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3377: checkcast java/lang/Number
/*      */     //   3380: invokevirtual doubleValue : ()D
/*      */     //   3383: dmul
/*      */     //   3384: dstore #20
/*      */     //   3386: aload_0
/*      */     //   3387: getfield al : F
/*      */     //   3390: iconst_0
/*      */     //   3391: i2f
/*      */     //   3392: fcmpg
/*      */     //   3393: ifgt -> 3412
/*      */     //   3396: aload_0
/*      */     //   3397: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3400: ifnull -> 3412
/*      */     //   3403: aload_0
/*      */     //   3404: aconst_null
/*      */     //   3405: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   3408: putfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3411: return
/*      */     //   3412: aload #5
/*      */     //   3414: aload_0
/*      */     //   3415: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3418: invokevirtual invoke : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Ljava/awt/Color;
/*      */     //   3421: astore #22
/*      */     //   3423: aload #22
/*      */     //   3425: dup
/*      */     //   3426: ifnonnull -> 3432
/*      */     //   3429: invokestatic throwNpe : ()V
/*      */     //   3432: invokevirtual getRed : ()I
/*      */     //   3435: i2f
/*      */     //   3436: ldc_w 255.0
/*      */     //   3439: fdiv
/*      */     //   3440: fstore #23
/*      */     //   3442: aload #22
/*      */     //   3444: invokevirtual getGreen : ()I
/*      */     //   3447: i2f
/*      */     //   3448: ldc_w 255.0
/*      */     //   3451: fdiv
/*      */     //   3452: fstore #24
/*      */     //   3454: aload #22
/*      */     //   3456: invokevirtual getBlue : ()I
/*      */     //   3459: i2f
/*      */     //   3460: ldc_w 255.0
/*      */     //   3463: fdiv
/*      */     //   3464: fstore #25
/*      */     //   3466: aload #4
/*      */     //   3468: invokevirtual invoke : ()V
/*      */     //   3471: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3474: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3479: invokeinterface getViewerPosX : ()D
/*      */     //   3484: dneg
/*      */     //   3485: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3488: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3493: invokeinterface getViewerPosY : ()D
/*      */     //   3498: dneg
/*      */     //   3499: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3502: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3507: invokeinterface getViewerPosZ : ()D
/*      */     //   3512: dneg
/*      */     //   3513: invokestatic glTranslated : (DDD)V
/*      */     //   3516: bipush #8
/*      */     //   3518: invokestatic glBegin : (I)V
/*      */     //   3521: iconst_0
/*      */     //   3522: istore #26
/*      */     //   3524: sipush #360
/*      */     //   3527: istore #27
/*      */     //   3529: iload #26
/*      */     //   3531: iload #27
/*      */     //   3533: if_icmpgt -> 3650
/*      */     //   3536: iload #26
/*      */     //   3538: i2d
/*      */     //   3539: ldc2_w 3.141592653589793
/*      */     //   3542: dmul
/*      */     //   3543: sipush #180
/*      */     //   3546: i2d
/*      */     //   3547: ddiv
/*      */     //   3548: dstore #28
/*      */     //   3550: dload #14
/*      */     //   3552: dload #28
/*      */     //   3554: invokestatic sin : (D)D
/*      */     //   3557: dload #10
/*      */     //   3559: dmul
/*      */     //   3560: dsub
/*      */     //   3561: dstore #30
/*      */     //   3563: dload #18
/*      */     //   3565: dload #28
/*      */     //   3567: invokestatic cos : (D)D
/*      */     //   3570: dload #10
/*      */     //   3572: dmul
/*      */     //   3573: dadd
/*      */     //   3574: dstore #32
/*      */     //   3576: fload #23
/*      */     //   3578: fload #24
/*      */     //   3580: fload #25
/*      */     //   3582: fconst_0
/*      */     //   3583: invokestatic glColor4f : (FFFF)V
/*      */     //   3586: dload #30
/*      */     //   3588: dload #16
/*      */     //   3590: aload_0
/*      */     //   3591: getfield yPos : D
/*      */     //   3594: dadd
/*      */     //   3595: dload #20
/*      */     //   3597: dadd
/*      */     //   3598: dload #32
/*      */     //   3600: invokestatic glVertex3d : (DDD)V
/*      */     //   3603: fload #23
/*      */     //   3605: fload #24
/*      */     //   3607: fload #25
/*      */     //   3609: aload_0
/*      */     //   3610: getfield al : F
/*      */     //   3613: aload_0
/*      */     //   3614: getfield jelloAlphaValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   3617: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3620: checkcast java/lang/Number
/*      */     //   3623: invokevirtual floatValue : ()F
/*      */     //   3626: fmul
/*      */     //   3627: invokestatic glColor4f : (FFFF)V
/*      */     //   3630: dload #30
/*      */     //   3632: dload #16
/*      */     //   3634: aload_0
/*      */     //   3635: getfield yPos : D
/*      */     //   3638: dadd
/*      */     //   3639: dload #32
/*      */     //   3641: invokestatic glVertex3d : (DDD)V
/*      */     //   3644: iinc #26, 1
/*      */     //   3647: goto -> 3529
/*      */     //   3650: invokestatic glEnd : ()V
/*      */     //   3653: aload_3
/*      */     //   3654: dload #14
/*      */     //   3656: dload #16
/*      */     //   3658: aload_0
/*      */     //   3659: getfield yPos : D
/*      */     //   3662: dadd
/*      */     //   3663: dload #18
/*      */     //   3665: aload_0
/*      */     //   3666: getfield jelloWidthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   3669: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3672: checkcast java/lang/Number
/*      */     //   3675: invokevirtual floatValue : ()F
/*      */     //   3678: dload #10
/*      */     //   3680: fload #23
/*      */     //   3682: fload #24
/*      */     //   3684: fload #25
/*      */     //   3686: aload_0
/*      */     //   3687: getfield al : F
/*      */     //   3690: invokevirtual invoke : (DDDFDFFFF)V
/*      */     //   3693: aload_2
/*      */     //   3694: invokevirtual invoke : ()V
/*      */     //   3697: aload_0
/*      */     //   3698: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3701: ifnull -> 3803
/*      */     //   3704: aload_0
/*      */     //   3705: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   3708: aload_0
/*      */     //   3709: getfield attackDelay : J
/*      */     //   3712: invokevirtual hasTimePassed : (J)Z
/*      */     //   3715: ifeq -> 3803
/*      */     //   3718: aload_0
/*      */     //   3719: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3722: dup
/*      */     //   3723: ifnonnull -> 3729
/*      */     //   3726: invokestatic throwNpe : ()V
/*      */     //   3729: invokeinterface getHurtTime : ()I
/*      */     //   3734: aload_0
/*      */     //   3735: getfield hurtTimeValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   3738: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3741: checkcast java/lang/Number
/*      */     //   3744: invokevirtual intValue : ()I
/*      */     //   3747: if_icmpgt -> 3803
/*      */     //   3750: aload_0
/*      */     //   3751: dup
/*      */     //   3752: getfield clicks : I
/*      */     //   3755: dup
/*      */     //   3756: istore #6
/*      */     //   3758: iconst_1
/*      */     //   3759: iadd
/*      */     //   3760: putfield clicks : I
/*      */     //   3763: aload_0
/*      */     //   3764: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   3767: invokevirtual reset : ()V
/*      */     //   3770: aload_0
/*      */     //   3771: aload_0
/*      */     //   3772: getfield minCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   3775: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3778: checkcast java/lang/Number
/*      */     //   3781: invokevirtual intValue : ()I
/*      */     //   3784: aload_0
/*      */     //   3785: getfield maxCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   3788: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3791: checkcast java/lang/Number
/*      */     //   3794: invokevirtual intValue : ()I
/*      */     //   3797: invokestatic randomClickDelay : (II)J
/*      */     //   3800: putfield attackDelay : J
/*      */     //   3803: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #532	-> 7
/*      */     //   #542	-> 11
/*      */     //   #566	-> 15
/*      */     //   #580	-> 20
/*      */     //   #610	-> 30
/*      */     //   #611	-> 46
/*      */     //   #612	-> 49
/*      */     //   #613	-> 49
/*      */     //   #614	-> 140
/*      */     //   #615	-> 231
/*      */     //   #612	-> 322
/*      */     //   #617	-> 325
/*      */     //   #618	-> 331
/*      */     //   #619	-> 337
/*      */     //   #620	-> 343
/*      */     //   #621	-> 349
/*      */     //   #623	-> 358
/*      */     //   #624	-> 362
/*      */     //   #625	-> 362
/*      */     //   #626	-> 379
/*      */     //   #627	-> 396
/*      */     //   #628	-> 413
/*      */     //   #624	-> 431
/*      */     //   #630	-> 434
/*      */     //   #631	-> 443
/*      */     //   #633	-> 447
/*      */     //   #634	-> 519
/*      */     //   #635	-> 519
/*      */     //   #635	-> 540
/*      */     //   #636	-> 555
/*      */     //   #636	-> 584
/*      */     //   #634	-> 599
/*      */     //   #633	-> 602
/*      */     //   #639	-> 619
/*      */     //   #640	-> 619
/*      */     //   #640	-> 632
/*      */     //   #641	-> 647
/*      */     //   #641	-> 668
/*      */     //   #639	-> 683
/*      */     //   #644	-> 686
/*      */     //   #646	-> 689
/*      */     //   #647	-> 695
/*      */     //   #648	-> 701
/*      */     //   #649	-> 707
/*      */     //   #651	-> 713
/*      */     //   #654	-> 716
/*      */     //   #1585	-> 722
/*      */     //   #1586	-> 722
/*      */     //   #1585	-> 747
/*      */     //   #1586	-> 771
/*      */     //   #655	-> 886
/*      */     //   #656	-> 894
/*      */     //   #657	-> 902
/*      */     //   #658	-> 907
/*      */     //   #659	-> 911
/*      */     //   #662	-> 912
/*      */     //   #663	-> 912
/*      */     //   #662	-> 912
/*      */     //   #663	-> 947
/*      */     //   #665	-> 972
/*      */     //   #666	-> 980
/*      */     //   #667	-> 988
/*      */     //   #668	-> 993
/*      */     //   #669	-> 1019
/*      */     //   #672	-> 1020
/*      */     //   #672	-> 1031
/*      */     //   #674	-> 1034
/*      */     //   #694	-> 1148
/*      */     //   #790	-> 1162
/*      */     //   #729	-> 1176
/*      */     //   #675	-> 1190
/*      */     //   #701	-> 1204
/*      */     //   #687	-> 1218
/*      */     //   #682	-> 1232
/*      */     //   #676	-> 1246
/*      */     //   #677	-> 1246
/*      */     //   #678	-> 1260
/*      */     //   #676	-> 1314
/*      */     //   #682	-> 1320
/*      */     //   #683	-> 1320
/*      */     //   #684	-> 1334
/*      */     //   #682	-> 1374
/*      */     //   #688	-> 1380
/*      */     //   #689	-> 1398
/*      */     //   #690	-> 1430
/*      */     //   #691	-> 1580
/*      */     //   #695	-> 1601
/*      */     //   #696	-> 1601
/*      */     //   #697	-> 1615
/*      */     //   #695	-> 1674
/*      */     //   #702	-> 1680
/*      */     //   #703	-> 1685
/*      */     //   #704	-> 1688
/*      */     //   #705	-> 1691
/*      */     //   #706	-> 1691
/*      */     //   #707	-> 1761
/*      */     //   #708	-> 1853
/*      */     //   #705	-> 1923
/*      */     //   #710	-> 1926
/*      */     //   #711	-> 1949
/*      */     //   #712	-> 1993
/*      */     //   #713	-> 2044
/*      */     //   #714	-> 2050
/*      */     //   #715	-> 2059
/*      */     //   #716	-> 2068
/*      */     //   #717	-> 2082
/*      */     //   #718	-> 2090
/*      */     //   #719	-> 2098
/*      */     //   #720	-> 2112
/*      */     //   #721	-> 2121
/*      */     //   #722	-> 2129
/*      */     //   #723	-> 2143
/*      */     //   #724	-> 2151
/*      */     //   #725	-> 2165
/*      */     //   #726	-> 2168
/*      */     //   #730	-> 2174
/*      */     //   #731	-> 2185
/*      */     //   #732	-> 2200
/*      */     //   #734	-> 2209
/*      */     //   #735	-> 2214
/*      */     //   #737	-> 2224
/*      */     //   #738	-> 2231
/*      */     //   #739	-> 2231
/*      */     //   #740	-> 2238
/*      */     //   #741	-> 2241
/*      */     //   #742	-> 2247
/*      */     //   #743	-> 2253
/*      */     //   #744	-> 2259
/*      */     //   #745	-> 2265
/*      */     //   #746	-> 2271
/*      */     //   #747	-> 2280
/*      */     //   #748	-> 2289
/*      */     //   #749	-> 2298
/*      */     //   #750	-> 2307
/*      */     //   #751	-> 2313
/*      */     //   #753	-> 2317
/*      */     //   #754	-> 2335
/*      */     //   #755	-> 2356
/*      */     //   #756	-> 2373
/*      */     //   #757	-> 2373
/*      */     //   #756	-> 2443
/*      */     //   #758	-> 2445
/*      */     //   #759	-> 2445
/*      */     //   #758	-> 2521
/*      */     //   #760	-> 2523
/*      */     //   #761	-> 2523
/*      */     //   #760	-> 2593
/*      */     //   #762	-> 2595
/*      */     //   #763	-> 2606
/*      */     //   #764	-> 2610
/*      */     //   #765	-> 2625
/*      */     //   #766	-> 2625
/*      */     //   #767	-> 2625
/*      */     //   #767	-> 2679
/*      */     //   #768	-> 2683
/*      */     //   #769	-> 2686
/*      */     //   #766	-> 2687
/*      */     //   #765	-> 2690
/*      */     //   #772	-> 2703
/*      */     //   #773	-> 2736
/*      */     //   #774	-> 2736
/*      */     //   #774	-> 2773
/*      */     //   #775	-> 2775
/*      */     //   #776	-> 2777
/*      */     //   #776	-> 2822
/*      */     //   #773	-> 2824
/*      */     //   #764	-> 2827
/*      */     //   #779	-> 2833
/*      */     //   #781	-> 2836
/*      */     //   #782	-> 2840
/*      */     //   #783	-> 2846
/*      */     //   #784	-> 2852
/*      */     //   #785	-> 2858
/*      */     //   #786	-> 2864
/*      */     //   #787	-> 2870
/*      */     //   #791	-> 2876
/*      */     //   #792	-> 2882
/*      */     //   #795	-> 2887
/*      */     //   #796	-> 2896
/*      */     //   #797	-> 2911
/*      */     //   #798	-> 2920
/*      */     //   #800	-> 2927
/*      */     //   #801	-> 2927
/*      */     //   #800	-> 2960
/*      */     //   #802	-> 2962
/*      */     //   #803	-> 2973
/*      */     //   #805	-> 2988
/*      */     //   #806	-> 3000
/*      */     //   #808	-> 3000
/*      */     //   #809	-> 3007
/*      */     //   #810	-> 3015
/*      */     //   #813	-> 3035
/*      */     //   #815	-> 3050
/*      */     //   #816	-> 3085
/*      */     //   #817	-> 3120
/*      */     //   #818	-> 3120
/*      */     //   #817	-> 3185
/*      */     //   #819	-> 3187
/*      */     //   #820	-> 3187
/*      */     //   #819	-> 3252
/*      */     //   #821	-> 3254
/*      */     //   #822	-> 3254
/*      */     //   #821	-> 3319
/*      */     //   #824	-> 3321
/*      */     //   #826	-> 3337
/*      */     //   #827	-> 3337
/*      */     //   #826	-> 3384
/*      */     //   #829	-> 3386
/*      */     //   #830	-> 3403
/*      */     //   #831	-> 3411
/*      */     //   #834	-> 3412
/*      */     //   #835	-> 3423
/*      */     //   #836	-> 3442
/*      */     //   #837	-> 3454
/*      */     //   #839	-> 3466
/*      */     //   #842	-> 3471
/*      */     //   #843	-> 3471
/*      */     //   #844	-> 3485
/*      */     //   #845	-> 3499
/*      */     //   #842	-> 3513
/*      */     //   #848	-> 3516
/*      */     //   #850	-> 3521
/*      */     //   #851	-> 3536
/*      */     //   #852	-> 3550
/*      */     //   #853	-> 3563
/*      */     //   #854	-> 3576
/*      */     //   #855	-> 3586
/*      */     //   #856	-> 3603
/*      */     //   #857	-> 3630
/*      */     //   #850	-> 3644
/*      */     //   #860	-> 3650
/*      */     //   #862	-> 3653
/*      */     //   #864	-> 3693
/*      */     //   #866	-> 3697
/*      */     //   #868	-> 3697
/*      */     //   #869	-> 3697
/*      */     //   #868	-> 3704
/*      */     //   #869	-> 3734
/*      */     //   #871	-> 3750
/*      */     //   #872	-> 3763
/*      */     //   #873	-> 3770
/*      */     //   #875	-> 3803
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   519	97	6	i	I
/*      */     //   719	164	6	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */     //   722	161	7	$i$f$getCancelRun	I
/*      */     //   1398	200	7	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2059	112	9	c	Lorg/lwjgl/util/glu/Cylinder;
/*      */     //   1688	483	8	side	I
/*      */     //   1685	486	7	radius	F
/*      */     //   2703	124	24	rainbow	Ljava/awt/Color;
/*      */     //   2625	205	22	i	I
/*      */     //   2595	278	20	z	D
/*      */     //   2523	350	18	y	D
/*      */     //   2445	428	16	x	D
/*      */     //   2373	500	14	height	D
/*      */     //   2356	517	12	radius	D
/*      */     //   2335	538	11	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2209	664	9	drawPercent	D
/*      */     //   2200	673	8	drawMode	Z
/*      */     //   2185	688	7	drawTime	I
/*      */     //   2962	23	10	weird	J
/*      */     //   3576	68	32	posZ2	D
/*      */     //   3563	81	30	posX2	D
/*      */     //   3550	94	28	calc	D
/*      */     //   3536	111	26	i	I
/*      */     //   3466	231	25	b	F
/*      */     //   3454	243	24	g	F
/*      */     //   3442	255	23	r	F
/*      */     //   3423	274	22	colour	Ljava/awt/Color;
/*      */     //   3386	311	20	deltaY	D
/*      */     //   3321	376	18	posZ	D
/*      */     //   3254	443	16	posY	D
/*      */     //   3187	510	14	posX	D
/*      */     //   3120	577	12	height	D
/*      */     //   3085	612	10	radius	D
/*      */     //   2887	810	9	$fun$easeInOutQuart$5	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$5;
/*      */     //   2882	815	7	lastY	D
/*      */     //   30	3774	5	$fun$getColor$4	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$4;
/*      */     //   20	3784	4	$fun$pre3D$3	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$3;
/*      */     //   15	3789	3	$fun$drawCircle$2	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$2;
/*      */     //   11	3793	2	$fun$post3D$1	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$onRender3D$1;
/*      */     //   0	3804	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/* 1592 */     //   0	3804	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent; } private final void updateTarget() { this.target = (IEntityLivingBase)null; int hurtTime = ((Number)this.hurtTimeValue.get()).intValue(); float fov = ((Number)this.fovValue.get()).floatValue(); boolean switchMode = StringsKt.equals((String)this.targetModeValue.get(), "Switch", true); boolean bool1 = false; List<IEntityLivingBase> targets = new ArrayList(); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IWorldClient theWorld = MinecraftInstance.mc.getTheWorld(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer(); for (IEntity entity : theWorld.getLoadedEntityList()) { if (!MinecraftInstance.classProvider.isEntityLivingBase(entity) || !isEnemy(entity) || (switchMode && this.prevTargetEntities.contains(Integer.valueOf(entity.getEntityId())))) continue;  double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity); double entityFov = RotationUtils.getRotationDifference(entity); if (distance <= getMaxRange() && (fov == 180.0F || entityFov <= fov) && entity.asEntityLivingBase().getHurtTime() <= hurtTime) targets.add(entity.asEntityLivingBase());  }  String str = (String)this.priorityValue.get(); boolean bool2 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 288459765: if (str.equals("distance")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura$updateTarget$$inlined$sortBy$1 killAura$updateTarget$$inlined$sortBy$1 = new KillAura$updateTarget$$inlined$sortBy$1(thePlayer); CollectionsKt.sortWith(list1, killAura$updateTarget$$inlined$sortBy$1); }  }  break;
/*      */       case -1221262756:
/* 1594 */         if (str.equals("health")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura$updateTarget$$inlined$sortBy$2 killAura$updateTarget$$inlined$sortBy$2 = new KillAura$updateTarget$$inlined$sortBy$2(); CollectionsKt.sortWith(list1, killAura$updateTarget$$inlined$sortBy$2); }
/*      */            }
/*      */          break;
/*      */       case 886905078:
/* 1598 */         if (str.equals("livingtime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura$updateTarget$$inlined$sortBy$4 killAura$updateTarget$$inlined$sortBy$4 = new KillAura$updateTarget$$inlined$sortBy$4(); CollectionsKt.sortWith(list1, killAura$updateTarget$$inlined$sortBy$4); }  }  break;
/*      */       case 525193846:
/* 1600 */         if (str.equals("HurtResitanTime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura$updateTarget$$inlined$sortBy$5 killAura$updateTarget$$inlined$sortBy$5 = new KillAura$updateTarget$$inlined$sortBy$5(); CollectionsKt.sortWith(list1, killAura$updateTarget$$inlined$sortBy$5); }  }  break;case -962590849: if (str.equals("direction")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura$updateTarget$$inlined$sortBy$3 killAura$updateTarget$$inlined$sortBy$3 = new KillAura$updateTarget$$inlined$sortBy$3(); CollectionsKt.sortWith(list1, killAura$updateTarget$$inlined$sortBy$3); }  }  break; }  for (IEntityLivingBase entity : targets) { if (!updateRotations((IEntity)entity)) continue;  this.target = entity; return; }  List<Integer> list = this.prevTargetEntities; bool2 = false; if (!list.isEmpty()) { this.prevTargetEntities.clear(); updateTarget(); }  } private final boolean isEnemy(IEntity entity) { if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && entity != null && (EntityUtils.targetDead || isAlive(entity.asEntityLivingBase())) && (Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0) { if (!EntityUtils.targetInvisible && entity.isInvisible()) return false;  if (EntityUtils.targetPlayer && MinecraftInstance.classProvider.isEntityPlayer(entity)) { IEntityPlayer player = entity.asEntityPlayer(); if (player.isSpectator() || AntiBot.isBot((IEntityLivingBase)player)) return false;  if (PlayerExtensionKt.isClientFriend(player) && !Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState()) return false;  if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams");  Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class); return (!teams.getState() || !teams.isInYourTeam(entity.asEntityLivingBase())); }  return ((EntityUtils.targetMobs && PlayerExtensionKt.isMob(entity)) || (EntityUtils.targetAnimals && PlayerExtensionKt.isAnimal(entity))); }  return false; } private final void attackEntity(IEntityLivingBase entity) { // Byte code:
/*      */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   8: dup
/*      */     //   9: ifnonnull -> 15
/*      */     //   12: invokestatic throwNpe : ()V
/*      */     //   15: astore_2
/*      */     //   16: aload_1
/*      */     //   17: invokeinterface getHealth : ()F
/*      */     //   22: fstore_3
/*      */     //   23: aload_0
/*      */     //   24: getfield autoBlockPacketValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   27: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   30: checkcast java/lang/String
/*      */     //   33: ldc_w 'Vanilla'
/*      */     //   36: iconst_1
/*      */     //   37: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   40: ifne -> 119
/*      */     //   43: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   46: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   51: dup
/*      */     //   52: ifnonnull -> 58
/*      */     //   55: invokestatic throwNpe : ()V
/*      */     //   58: invokeinterface isBlocking : ()Z
/*      */     //   63: ifne -> 73
/*      */     //   66: aload_0
/*      */     //   67: getfield blockingStatus : Z
/*      */     //   70: ifeq -> 119
/*      */     //   73: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   76: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   81: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   84: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction.RELEASE_USE_ITEM : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*      */     //   87: getstatic net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos.Companion : Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos$Companion;
/*      */     //   90: invokevirtual getORIGIN : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*      */     //   93: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   96: getstatic net/ccbluex/liquidbounce/api/enums/EnumFacingType.DOWN : Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;
/*      */     //   99: invokeinterface getEnumFacing : (Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*      */     //   104: invokeinterface createCPacketPlayerDigging : (Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;)Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*      */     //   109: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   114: aload_0
/*      */     //   115: iconst_0
/*      */     //   116: putfield blockingStatus : Z
/*      */     //   119: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   122: invokevirtual getEventManager : ()Lnet/ccbluex/liquidbounce/event/EventManager;
/*      */     //   125: new net/ccbluex/liquidbounce/event/AttackEvent
/*      */     //   128: dup
/*      */     //   129: aload_1
/*      */     //   130: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   133: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   136: checkcast net/ccbluex/liquidbounce/event/Event
/*      */     //   139: invokevirtual callEvent : (Lnet/ccbluex/liquidbounce/event/Event;)V
/*      */     //   142: aload_0
/*      */     //   143: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   146: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   149: checkcast java/lang/Boolean
/*      */     //   152: invokevirtual booleanValue : ()Z
/*      */     //   155: ifeq -> 158
/*      */     //   158: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   161: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   166: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   169: aload_1
/*      */     //   170: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   173: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction.ATTACK : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;
/*      */     //   176: invokeinterface createCPacketUseEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;
/*      */     //   181: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   184: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   189: aload_0
/*      */     //   190: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   193: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   196: checkcast java/lang/Boolean
/*      */     //   199: invokevirtual booleanValue : ()Z
/*      */     //   202: ifeq -> 211
/*      */     //   205: aload_2
/*      */     //   206: invokeinterface swingItem : ()V
/*      */     //   211: aload_0
/*      */     //   212: getfield keepSprintValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   215: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   218: checkcast java/lang/Boolean
/*      */     //   221: invokevirtual booleanValue : ()Z
/*      */     //   224: ifeq -> 339
/*      */     //   227: aload_2
/*      */     //   228: invokeinterface getFallDistance : ()F
/*      */     //   233: fconst_0
/*      */     //   234: fcmpl
/*      */     //   235: ifle -> 304
/*      */     //   238: aload_2
/*      */     //   239: invokeinterface getOnGround : ()Z
/*      */     //   244: ifne -> 304
/*      */     //   247: aload_2
/*      */     //   248: invokeinterface isOnLadder : ()Z
/*      */     //   253: ifne -> 304
/*      */     //   256: aload_2
/*      */     //   257: invokeinterface isInWater : ()Z
/*      */     //   262: ifne -> 304
/*      */     //   265: aload_2
/*      */     //   266: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   269: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.BLINDNESS : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*      */     //   272: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*      */     //   277: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*      */     //   282: ifne -> 304
/*      */     //   285: aload_2
/*      */     //   286: invokeinterface isRiding : ()Z
/*      */     //   291: ifne -> 304
/*      */     //   294: aload_2
/*      */     //   295: aload_1
/*      */     //   296: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   299: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   304: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*      */     //   307: aload_2
/*      */     //   308: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   313: aload_1
/*      */     //   314: invokeinterface getCreatureAttribute : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;
/*      */     //   319: invokeinterface getModifierForCreature : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;)F
/*      */     //   324: fconst_0
/*      */     //   325: fcmpl
/*      */     //   326: ifle -> 368
/*      */     //   329: aload_2
/*      */     //   330: aload_1
/*      */     //   331: invokeinterface onEnchantmentCritical : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*      */     //   336: goto -> 368
/*      */     //   339: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   342: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*      */     //   347: invokeinterface getCurrentGameType : ()Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;
/*      */     //   352: getstatic net/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType.SPECTATOR : Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorldSettings$WGameType;
/*      */     //   355: if_acmpeq -> 368
/*      */     //   358: aload_2
/*      */     //   359: aload_1
/*      */     //   360: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   363: invokeinterface attackTargetEntityWithCurrentItem : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   368: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   371: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   374: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/Criticals
/*      */     //   377: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   380: dup
/*      */     //   381: ifnonnull -> 395
/*      */     //   384: new kotlin/TypeCastException
/*      */     //   387: dup
/*      */     //   388: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Criticals'
/*      */     //   391: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   394: athrow
/*      */     //   395: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/Criticals
/*      */     //   398: astore #4
/*      */     //   400: iconst_0
/*      */     //   401: istore #5
/*      */     //   403: iconst_2
/*      */     //   404: istore #6
/*      */     //   406: iload #5
/*      */     //   408: iload #6
/*      */     //   410: if_icmpgt -> 635
/*      */     //   413: aload_2
/*      */     //   414: invokeinterface getFallDistance : ()F
/*      */     //   419: fconst_0
/*      */     //   420: fcmpl
/*      */     //   421: ifle -> 480
/*      */     //   424: aload_2
/*      */     //   425: invokeinterface getOnGround : ()Z
/*      */     //   430: ifne -> 480
/*      */     //   433: aload_2
/*      */     //   434: invokeinterface isOnLadder : ()Z
/*      */     //   439: ifne -> 480
/*      */     //   442: aload_2
/*      */     //   443: invokeinterface isInWater : ()Z
/*      */     //   448: ifne -> 480
/*      */     //   451: aload_2
/*      */     //   452: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   455: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.BLINDNESS : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*      */     //   458: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*      */     //   463: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*      */     //   468: ifne -> 480
/*      */     //   471: aload_2
/*      */     //   472: invokeinterface getRidingEntity : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*      */     //   477: ifnull -> 541
/*      */     //   480: aload #4
/*      */     //   482: invokevirtual getState : ()Z
/*      */     //   485: ifeq -> 561
/*      */     //   488: aload #4
/*      */     //   490: invokevirtual getMsTimer : ()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   493: aload #4
/*      */     //   495: invokevirtual getDelayValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   498: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   501: checkcast java/lang/Number
/*      */     //   504: invokevirtual intValue : ()I
/*      */     //   507: i2l
/*      */     //   508: invokevirtual hasTimePassed : (J)Z
/*      */     //   511: ifeq -> 561
/*      */     //   514: aload_2
/*      */     //   515: invokeinterface isInWater : ()Z
/*      */     //   520: ifne -> 561
/*      */     //   523: aload_2
/*      */     //   524: invokeinterface isInLava : ()Z
/*      */     //   529: ifne -> 561
/*      */     //   532: aload_2
/*      */     //   533: invokeinterface isInWeb : ()Z
/*      */     //   538: ifne -> 561
/*      */     //   541: aload_2
/*      */     //   542: aload_0
/*      */     //   543: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   546: dup
/*      */     //   547: ifnonnull -> 553
/*      */     //   550: invokestatic throwNpe : ()V
/*      */     //   553: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   556: invokeinterface onCriticalHit : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V
/*      */     //   561: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*      */     //   564: aload_2
/*      */     //   565: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   570: aload_0
/*      */     //   571: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   574: dup
/*      */     //   575: ifnonnull -> 581
/*      */     //   578: invokestatic throwNpe : ()V
/*      */     //   581: invokeinterface getCreatureAttribute : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;
/*      */     //   586: invokeinterface getModifierForCreature : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;)F
/*      */     //   591: fconst_0
/*      */     //   592: fcmpl
/*      */     //   593: ifgt -> 612
/*      */     //   596: aload_0
/*      */     //   597: getfield fakeSharpValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   600: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   603: checkcast java/lang/Boolean
/*      */     //   606: invokevirtual booleanValue : ()Z
/*      */     //   609: ifeq -> 629
/*      */     //   612: aload_2
/*      */     //   613: aload_0
/*      */     //   614: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   617: dup
/*      */     //   618: ifnonnull -> 624
/*      */     //   621: invokestatic throwNpe : ()V
/*      */     //   624: invokeinterface onEnchantmentCritical : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V
/*      */     //   629: iinc #5, 1
/*      */     //   632: goto -> 406
/*      */     //   635: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   638: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   643: dup
/*      */     //   644: ifnonnull -> 650
/*      */     //   647: invokestatic throwNpe : ()V
/*      */     //   650: invokeinterface isBlocking : ()Z
/*      */     //   655: ifne -> 685
/*      */     //   658: aload_0
/*      */     //   659: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   662: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   665: checkcast java/lang/String
/*      */     //   668: ldc_w 'off'
/*      */     //   671: iconst_1
/*      */     //   672: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*      */     //   675: ifne -> 751
/*      */     //   678: aload_0
/*      */     //   679: invokespecial canBlock : ()Z
/*      */     //   682: ifeq -> 751
/*      */     //   685: aload_0
/*      */     //   686: getfield blockRate : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   689: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   692: checkcast java/lang/Number
/*      */     //   695: invokevirtual intValue : ()I
/*      */     //   698: ifle -> 729
/*      */     //   701: new java/util/Random
/*      */     //   704: dup
/*      */     //   705: invokespecial <init> : ()V
/*      */     //   708: bipush #100
/*      */     //   710: invokevirtual nextInt : (I)I
/*      */     //   713: aload_0
/*      */     //   714: getfield blockRate : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   717: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   720: checkcast java/lang/Number
/*      */     //   723: invokevirtual intValue : ()I
/*      */     //   726: if_icmple -> 730
/*      */     //   729: return
/*      */     //   730: aload_0
/*      */     //   731: aload_1
/*      */     //   732: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   735: aload_0
/*      */     //   736: getfield interactAutoBlockValue : Lnet/ccbluex/liquidbounce/value/Value;
/*      */     //   739: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   742: checkcast java/lang/Boolean
/*      */     //   745: invokevirtual booleanValue : ()Z
/*      */     //   748: invokespecial startBlocking : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)V
/*      */     //   751: aload_2
/*      */     //   752: invokeinterface resetCooldown : ()V
/*      */     //   757: new java/lang/Thread
/*      */     //   760: dup
/*      */     //   761: new net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$attackEntity$1
/*      */     //   764: dup
/*      */     //   765: aload_0
/*      */     //   766: aload_1
/*      */     //   767: fload_3
/*      */     //   768: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;F)V
/*      */     //   771: checkcast java/lang/Runnable
/*      */     //   774: invokespecial <init> : (Ljava/lang/Runnable;)V
/*      */     //   777: invokevirtual start : ()V
/*      */     //   780: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1046	-> 0
/*      */     //   #1047	-> 16
/*      */     //   #1049	-> 23
/*      */     //   #1050	-> 73
/*      */     //   #1051	-> 81
/*      */     //   #1052	-> 84
/*      */     //   #1053	-> 87
/*      */     //   #1051	-> 104
/*      */     //   #1050	-> 109
/*      */     //   #1056	-> 114
/*      */     //   #1060	-> 119
/*      */     //   #1063	-> 142
/*      */     //   #1066	-> 158
/*      */     //   #1068	-> 189
/*      */     //   #1069	-> 205
/*      */     //   #1071	-> 211
/*      */     //   #1073	-> 227
/*      */     //   #1074	-> 227
/*      */     //   #1076	-> 294
/*      */     //   #1079	-> 304
/*      */     //   #1080	-> 329
/*      */     //   #1082	-> 339
/*      */     //   #1083	-> 358
/*      */     //   #1084	-> 368
/*      */     //   #1087	-> 368
/*      */     //   #1089	-> 400
/*      */     //   #1091	-> 413
/*      */     //   #1093	-> 413
/*      */     //   #1095	-> 413
/*      */     //   #1091	-> 451
/*      */     //   #1092	-> 452
/*      */     //   #1091	-> 463
/*      */     //   #1093	-> 488
/*      */     //   #1094	-> 493
/*      */     //   #1093	-> 508
/*      */     //   #1097	-> 541
/*      */     //   #1100	-> 561
/*      */     //   #1103	-> 561
/*      */     //   #1100	-> 561
/*      */     //   #1101	-> 564
/*      */     //   #1102	-> 570
/*      */     //   #1100	-> 586
/*      */     //   #1103	-> 596
/*      */     //   #1105	-> 612
/*      */     //   #1089	-> 629
/*      */     //   #1109	-> 635
/*      */     //   #1111	-> 685
/*      */     //   #1112	-> 729
/*      */     //   #1114	-> 730
/*      */     //   #1116	-> 751
/*      */     //   #1117	-> 757
/*      */     //   #1140	-> 757
/*      */     //   #1117	-> 757
/*      */     //   #1140	-> 777
/*      */     //   #1141	-> 780
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   413	219	5	i	I
/*      */     //   400	381	4	criticals	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Criticals;
/*      */     //   23	758	3	starthealth	F
/*      */     //   16	765	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   0	781	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */     //   0	781	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class KillAura$attackEntity$1 implements Runnable {
/*      */     public final void run() { Thread.sleep(100L); if (this.$entity.getHurtTime() == 0 && this.$entity.getHealth() == this.$starthealth) { KillAura.this.setFailcount(KillAura.this.getFailcount() + 1); if (((Boolean)KillAura.this.faildebug.get()).booleanValue()) { if (this.$entity.getDisplayName() == null) Intrinsics.throwNpe();  Chat.print("Fail Attack " + this.$entity.getDisplayName().getFormattedText()); Chat.print("单位时间内已空刀" + String.valueOf(KillAura.this.getFailcount()) + "次"); }  if (!KillAura.this.getFailstatus() && KillAura.this.getFailcount() >= ((Number)KillAura.this.failcountvalue.get()).intValue()) { KillAura.this.setKarange(((Number)KillAura.this.getRangeValue().get()).floatValue()); if (((Boolean)KillAura.this.faildebug.get()).booleanValue()) Chat.print("记录杀戮距离: " + KillAura.this.getKarange());  KillAura.this.setFailstatus(true); }  }  } KillAura$attackEntity$1(IEntityLivingBase param1IEntityLivingBase, float param1Float) {} } private final boolean updateRotations(IEntity entity) { IAxisAlignedBB boundingBox = entity.getEntityBoundingBox(); if (StringsKt.equals((String)this.rotations.get(), "test1", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 wVec3 = vecRotation.component1(); Rotation rotation = vecRotation.component2(); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "test2", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 vec = vecRotation.component1(); Rotation rotation = vecRotation.component2(); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "HytRotation", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "New", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 vec = vecRotation.component1(); Rotation rotation = vecRotation.component2(); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "LiquidBounce", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 vec = vecRotation.component1(); Rotation rotation = vecRotation.component2(); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "BackTrack", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.OtherRotation(boundingBox, RotationUtils.getCenter(entity.getEntityBoundingBox()), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())), "RotationUtils.limitAngle…).toFloat()\n            )"); Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.OtherRotation(boundingBox, RotationUtils.getCenter(entity.getEntityBoundingBox()), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())); if (((Boolean)this.silentRotationValue.get()).booleanValue()) { RotationUtils.setTargetRotation(limitedRotation, ((Boolean)this.aacValue.get()).booleanValue() ? 15 : 0); } else { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  limitedRotation.toPlayer((IEntityPlayer)MinecraftInstance.mc.getThePlayer()); return true; }  }  if (StringsKt.equals((String)this.rotations.get(), "VapuV1", true)) { float yaw = 15.0F; float pitch = 15.0F; double yDifference = 0.0D; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double diffX = entity.getPosX() - MinecraftInstance.mc.getThePlayer().getPosX(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double diffZ = entity.getPosZ() - MinecraftInstance.mc.getThePlayer().getPosZ(); if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  EntityLivingBase entityLivingBase = (EntityLivingBase)entity; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = (entity instanceof EntityLivingBase) ? (entityLivingBase.field_70163_u + entityLivingBase.func_70047_e() - MinecraftInstance.mc.getThePlayer().getPosY() + MinecraftInstance.mc.getThePlayer().getEyeHeight()) : ((boundingBox.getMinY() + boundingBox.getMaxY()) / 2.0D - MinecraftInstance.mc.getThePlayer().getPosY() + MinecraftInstance.mc.getThePlayer().getEyeHeight()); double dist = RealmsMth.sqrt(diffX * diffX + diffZ * diffZ); float rotationYaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F; float rotationPitch = (float)-(Math.atan2(d1, dist) * 180.0D / Math.PI); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float var4 = RealmsMth.wrapDegrees(rotationYaw - MinecraftInstance.mc.getThePlayer().getRotationYaw()); if (var4 > yaw / 4.0F) var4 = yaw / 4.0F;  if (var4 < -(yaw / 4.0F)) var4 = -(yaw / 4.0F);  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float a = MinecraftInstance.mc.getThePlayer().getRotationYaw() + var4; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  var4 = RealmsMth.wrapDegrees(rotationPitch - MinecraftInstance.mc.getThePlayer().getRotationPitch()); if (var4 > pitch / 4.0F) var4 = pitch / 4.0F;  if (var4 < -(pitch / 4.0F)) var4 = -(pitch / 4.0F);  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float b = MinecraftInstance.mc.getThePlayer().getRotationYaw() + var4; Rotation rotation = new Rotation(a, b); if (((Boolean)this.silentRotationValue.get()).booleanValue()) { RotationUtils.setTargetRotation(rotation, ((Boolean)this.aacValue.get()).booleanValue() ? 15 : 0); } else { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  rotation.toPlayer((IEntityPlayer)MinecraftInstance.mc.getThePlayer()); return true; }  }  return true; } private final void updateHitable() { // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield hitableValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   4: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   7: checkcast java/lang/Boolean
/*      */     //   10: invokevirtual booleanValue : ()Z
/*      */     //   13: ifeq -> 22
/*      */     //   16: aload_0
/*      */     //   17: iconst_1
/*      */     //   18: putfield hitable : Z
/*      */     //   21: return
/*      */     //   22: aload_0
/*      */     //   23: getfield maxTurnSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   26: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   29: checkcast java/lang/Number
/*      */     //   32: invokevirtual floatValue : ()F
/*      */     //   35: fconst_0
/*      */     //   36: fcmpg
/*      */     //   37: ifgt -> 46
/*      */     //   40: aload_0
/*      */     //   41: iconst_1
/*      */     //   42: putfield hitable : Z
/*      */     //   45: return
/*      */     //   46: aload_0
/*      */     //   47: invokespecial getMaxRange : ()F
/*      */     //   50: f2d
/*      */     //   51: dstore_3
/*      */     //   52: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   55: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   60: dup
/*      */     //   61: ifnonnull -> 67
/*      */     //   64: invokestatic throwNpe : ()V
/*      */     //   67: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   70: aload_0
/*      */     //   71: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   74: dup
/*      */     //   75: ifnonnull -> 81
/*      */     //   78: invokestatic throwNpe : ()V
/*      */     //   81: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   84: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   87: dstore #5
/*      */     //   89: iconst_0
/*      */     //   90: istore #7
/*      */     //   92: dload_3
/*      */     //   93: dload #5
/*      */     //   95: invokestatic min : (DD)D
/*      */     //   98: iconst_1
/*      */     //   99: i2d
/*      */     //   100: dadd
/*      */     //   101: dstore_1
/*      */     //   102: aload_0
/*      */     //   103: getfield raycastValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   106: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   109: checkcast java/lang/Boolean
/*      */     //   112: invokevirtual booleanValue : ()Z
/*      */     //   115: ifeq -> 255
/*      */     //   118: dload_1
/*      */     //   119: new net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$updateHitable$raycastedEntity$1
/*      */     //   122: dup
/*      */     //   123: aload_0
/*      */     //   124: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)V
/*      */     //   127: checkcast net/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter
/*      */     //   130: invokestatic raycastEntity : (DLnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*      */     //   133: astore_3
/*      */     //   134: aload_0
/*      */     //   135: getfield raycastValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   138: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   141: checkcast java/lang/Boolean
/*      */     //   144: invokevirtual booleanValue : ()Z
/*      */     //   147: ifeq -> 218
/*      */     //   150: aload_3
/*      */     //   151: ifnull -> 218
/*      */     //   154: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   157: aload_3
/*      */     //   158: invokeinterface isEntityLivingBase : (Ljava/lang/Object;)Z
/*      */     //   163: ifeq -> 218
/*      */     //   166: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   169: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   172: ldc_w net/ccbluex/liquidbounce/features/module/modules/combat/NoFriends
/*      */     //   175: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   178: invokevirtual getState : ()Z
/*      */     //   181: ifne -> 208
/*      */     //   184: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   187: aload_3
/*      */     //   188: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*      */     //   193: ifeq -> 208
/*      */     //   196: aload_3
/*      */     //   197: invokeinterface asEntityPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*      */     //   202: invokestatic isClientFriend : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;)Z
/*      */     //   205: ifne -> 218
/*      */     //   208: aload_0
/*      */     //   209: aload_3
/*      */     //   210: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   215: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   218: aload_0
/*      */     //   219: aload_0
/*      */     //   220: getfield maxTurnSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   223: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   226: checkcast java/lang/Number
/*      */     //   229: invokevirtual floatValue : ()F
/*      */     //   232: fconst_0
/*      */     //   233: fcmpl
/*      */     //   234: ifle -> 248
/*      */     //   237: aload_0
/*      */     //   238: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   241: aload_3
/*      */     //   242: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   245: goto -> 249
/*      */     //   248: iconst_1
/*      */     //   249: putfield hitable : Z
/*      */     //   252: goto -> 270
/*      */     //   255: aload_0
/*      */     //   256: aload_0
/*      */     //   257: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   260: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   263: dload_1
/*      */     //   264: invokestatic isFaced : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;D)Z
/*      */     //   267: putfield hitable : Z
/*      */     //   270: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1383	-> 0
/*      */     //   #1384	-> 16
/*      */     //   #1385	-> 21
/*      */     //   #1388	-> 22
/*      */     //   #1389	-> 40
/*      */     //   #1390	-> 45
/*      */     //   #1393	-> 46
/*      */     //   #1393	-> 98
/*      */     //   #1395	-> 102
/*      */     //   #1396	-> 118
/*      */     //   #1409	-> 134
/*      */     //   #1410	-> 134
/*      */     //   #1412	-> 134
/*      */     //   #1409	-> 134
/*      */     //   #1410	-> 166
/*      */     //   #1411	-> 187
/*      */     //   #1410	-> 188
/*      */     //   #1412	-> 196
/*      */     //   #1414	-> 208
/*      */     //   #1416	-> 218
/*      */     //   #1418	-> 255
/*      */     //   #1419	-> 270
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   134	118	3	raycastedEntity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*      */     //   102	169	1	reach	D
/*      */     //   0	271	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura$updateHitable$raycastedEntity$1", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"}) public static final class KillAura$updateHitable$raycastedEntity$1 implements RaycastUtils.EntityFilter {
/*      */     public boolean canRaycast(@Nullable IEntity entity) { // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */       //   4: invokestatic access$getLivingRaycastValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)Lnet/ccbluex/liquidbounce/value/BoolValue;
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
/*      */       //   44: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */       //   47: aload_1
/*      */       //   48: invokestatic access$isEnemy : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */       //   51: ifne -> 146
/*      */       //   54: aload_0
/*      */       //   55: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */       //   58: invokestatic access$getRaycastIgnoredValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */       //   61: invokevirtual get : ()Ljava/lang/Object;
/*      */       //   64: checkcast java/lang/Boolean
/*      */       //   67: invokevirtual booleanValue : ()Z
/*      */       //   70: ifne -> 146
/*      */       //   73: aload_0
/*      */       //   74: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*      */       //   77: invokestatic access$getAacValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;)Lnet/ccbluex/liquidbounce/value/BoolValue;
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
/*      */       //   #1398	-> 0
/*      */       //   #1401	-> 0
/*      */       //   #1404	-> 0
/*      */       //   #1398	-> 0
/*      */       //   #1399	-> 34
/*      */       //   #1398	-> 35
/*      */       //   #1401	-> 47
/*      */       //   #1402	-> 107
/*      */       //   #1403	-> 108
/*      */       //   #1401	-> 121
/*      */       //   #1404	-> 127
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	152	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura$updateHitable$raycastedEntity$1;
/*      */       //   0	152	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity; } }
/* 1603 */   private final void startBlocking(IEntity interactEntity, boolean interact) { if (!this.blockingStatus) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), interactEntity) <= ((Number)this.blockRangeValue.get()).doubleValue()) { if (StringsKt.equals((String)this.autoBlockValue.get(), "HuaYuTing", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), interactEntity) > ((Number)this.blockRangeValue.get()).doubleValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() != null) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHeldItem().getItem() instanceof net.minecraft.item.ItemSword) if (MinecraftInstance.mc2.field_71439_g.field_110158_av == -1) { PacketUtils.sendPacketNoEvent((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -1, -1), EnumFacing.DOWN)); } else if (MinecraftInstance.mc2.field_71439_g.field_110158_av < 0.5D && MinecraftInstance.mc2.field_71439_g.field_110158_av != -1) { PacketUtils.sendPacketNoEvent((Packet)new CPacketPlayerTryUseItemOnBlock(new BlockPos(-1, -1, -1), EnumFacing.WEST, EnumHand.MAIN_HAND, 0.0F, 0.0F, 0.0F)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  WEnumHand wEnumHand1 = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getThePlayer().getSendQueue(); int $i$f$createUseItemPacket = 0; IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand1); iINetHandlerPlayClient.addToSendQueue(iPacket); if (MinecraftInstance.mc.getThePlayer() == null)
/*      */                     Intrinsics.throwNpe();  WEnumHand hand$iv = WEnumHand.OFF_HAND; iINetHandlerPlayClient = MinecraftInstance.mc.getThePlayer().getSendQueue(); $i$f$createUseItemPacket = 0;
/* 1605 */                   iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand$iv); iINetHandlerPlayClient.addToSendQueue(iPacket); }   }  }  }  if (interact) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, interactEntity.getPositionVector())); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, ICPacketUseEntity.WAction.INTERACT)); }  if (!StringsKt.equals((String)this.autoBlockValue.get(), "Fake", true)) { String str = (String)this.autoBlockPacketValue.get(); switch (str.hashCode()) { case 74534021: if (str.equals("Mouse")) (new Robot()).mousePress(4096);  break;case 1897755483: if (str.equals("Vanilla")) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.MAIN_HAND)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.OFF_HAND)); }  break;case 1516319002: if (str.equals("UseItem"))
/*      */                 KeyBinding.func_74510_a(MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().getKeyCode(), true);  break;case 1754181205: if (str.equals("GameSettings"))
/* 1607 */                 MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(true);  break;case 1197787130: if (str.equals("DoubleC08")) { WEnumHand wEnumHand1 = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createUseItemPacket = 0; IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand1); iINetHandlerPlayClient.addToSendQueue(iPacket); WEnumHand hand$iv = WEnumHand.OFF_HAND; iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler();
/*      */                 $i$f$createUseItemPacket = 0;
/* 1609 */                 iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand$iv); iINetHandlerPlayClient.addToSendQueue(iPacket); }
/*      */               
/*      */               break; }
/*      */            }
/*      */         
/*      */         this.blockingStatus = true;
/*      */         return; }
/*      */        }
/*      */      }
/*      */ 
/*      */   
/*      */   private final void stopBlocking() {
/*      */     if (this.blockingStatus)
/*      */       this.blockingStatus = false; 
/*      */   }
/*      */   
/*      */   private final boolean getCancelRun() {
/*      */     int $i$f$getCancelRun = 0;
/*      */     if (MinecraftInstance.mc.getThePlayer() == null)
/*      */       Intrinsics.throwNpe(); 
/*      */     if (!MinecraftInstance.mc.getThePlayer().isSpectator()) {
/*      */       if (MinecraftInstance.mc.getThePlayer() == null)
/*      */         Intrinsics.throwNpe(); 
/*      */       if (!isAlive((IEntityLivingBase)MinecraftInstance.mc.getThePlayer()) || Retreat.INSTANCE.getModuleManager().get(Blink.class).getState() || Retreat.INSTANCE.getModuleManager().get(FreeCam.class).getState() || (((Boolean)this.noScaffoldValue.get()).booleanValue() && (Retreat.INSTANCE.getModuleManager().get(Scaffold.class).getState() || Retreat.INSTANCE.getModuleManager().get(Scaffold2.class).getState() || Retreat.INSTANCE.getModuleManager().get(GroundTelly.class).getState())));
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
/*      */   @NotNull
/*      */   public String getTag() {
/*      */     return (String)this.targetModeValue.get();
/*      */   }
/*      */   
/*      */   public final boolean isBlockingChestAura() {
/*      */     return (getState() && this.target != null);
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\KillAura.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */