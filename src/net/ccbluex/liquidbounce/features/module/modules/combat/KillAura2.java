/*      */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*      */ 
/*      */ import courage.utils.BlendUtils;
/*      */ import courage.utils.PlayerUtil;
/*      */ import courage.utils.render.GLUtils;
/*      */ import java.awt.Color;
/*      */ import java.awt.Robot;
/*      */ import java.lang.annotation.Annotation;
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
/*      */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*      */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorldSettings;
/*      */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*      */ import net.ccbluex.liquidbounce.event.EntityMovementEvent;
/*      */ import net.ccbluex.liquidbounce.event.Event;
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
/*      */ import net.ccbluex.liquidbounce.features.module.modules.render.FreeCam;
/*      */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*      */ import net.ccbluex.liquidbounce.ui.font.GameFontRenderer;
/*      */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*      */ import net.ccbluex.liquidbounce.utils.RaycastUtils;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.VecRotation;
/*      */ import net.ccbluex.liquidbounce.utils.extensions.PlayerExtensionKt;
/*      */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*      */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import net.minecraft.client.settings.KeyBinding;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
/*      */ import net.minecraft.util.EnumFacing;
/*      */ import net.minecraft.util.EnumHand;
/*      */ import net.minecraft.util.math.BlockPos;
/*      */ import org.jetbrains.annotations.NotNull;
/*      */ import org.jetbrains.annotations.Nullable;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ import org.lwjgl.util.glu.Cylinder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @ModuleInfo(name = "KillAura2", description = "Automatically attacks targets around you.", category = ModuleCategory.COMBAT)
/*      */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000¼\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\007\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\b\n\002\030\002\n\002\b\017\n\002\030\002\n\002\b\002\n\002\020\006\n\000\n\002\020\016\n\002\b%\n\002\030\002\n\002\b\021\n\002\020!\n\002\b\037\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\b\007\030\000 »\0012\0020\001:\002»\001B\005¢\006\002\020\002J\022\020\001\032\0030\0012\006\020>\032\00208H\002J\t\020\001\032\0020\037H\002J%\020\001\032\0030\0012\006\020>\032\002082\007\020\001\032\0020\0332\b\020\001\032\0030\001H\002J$\020\001\032\0030\0012\006\020>\032\002082\007\020\001\032\0020\0172\007\020\001\032\0020\017H\002J\022\020\001\032\0020\0172\007\020>\032\0030\001H\002J\021\020 \001\032\0020\0372\006\020>\032\00208H\002J\024\020¡\001\032\0020\0372\t\020>\032\005\030\0010\001H\002J\n\020¢\001\032\0030\001H\026J\n\020£\001\032\0030\001H\026J\024\020¤\001\032\0030\0012\b\020¥\001\032\0030¦\001H\007J\024\020§\001\032\0030\0012\b\020¥\001\032\0030¨\001H\007J\024\020©\001\032\0030\0012\b\020¥\001\032\0030ª\001H\007J\024\020«\001\032\0030\0012\b\020¥\001\032\0030\001H\007J\024\020¬\001\032\0030\0012\b\020¥\001\032\0030­\001H\007J\026\020®\001\032\0030\0012\n\020¥\001\032\005\030\0010¯\001H\007J\024\020°\001\032\0030\0012\b\020¥\001\032\0030±\001H\007J\n\020²\001\032\0030\001H\002J\035\020³\001\032\0030\0012\b\020´\001\032\0030\0012\007\020µ\001\032\0020\037H\002J\n\020¶\001\032\0030\001H\002J\b\020·\001\032\0030\001J\n\020¸\001\032\0030\001H\002J\022\020¹\001\032\0020\0372\007\020>\032\0030\001H\002J\n\020º\001\032\0030\001H\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\021\020\013\032\0020\b¢\006\b\n\000\032\004\b\f\020\rR\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\021X\016¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\026X\004¢\006\002\n\000R\020\020\030\032\004\030\0010\031X\016¢\006\002\n\000R\021\020\032\032\0020\033¢\006\b\n\000\032\004\b\034\020\035R\032\020\036\032\0020\037X\016¢\006\016\n\000\032\004\b \020!\"\004\b\"\020#R\016\020$\032\0020\bX\004¢\006\002\n\000R\025\020%\032\0020\0378Â\002X\004¢\006\006\032\004\b&\020!R\016\020'\032\0020(X\004¢\006\002\n\000R\016\020)\032\0020(X\004¢\006\002\n\000R\016\020*\032\0020(X\004¢\006\002\n\000R\016\020+\032\0020(X\004¢\006\002\n\000R\016\020,\032\0020(X\004¢\006\002\n\000R\016\020-\032\0020\004X\004¢\006\002\n\000R\016\020.\032\0020\033X\016¢\006\002\n\000R\016\020/\032\0020(X\004¢\006\002\n\000R\016\0200\032\0020(X\004¢\006\002\n\000R\016\0201\032\0020(X\004¢\006\002\n\000R\016\0202\032\0020\026X\004¢\006\002\n\000R\016\0203\032\0020(X\004¢\006\002\n\000R\016\0204\032\0020\004X\004¢\006\002\n\000R\016\0205\032\0020\021X\016¢\006\002\n\000R\016\0206\032\0020\bX\004¢\006\002\n\000R\020\0207\032\004\030\00108X\016¢\006\002\n\000R\016\0209\032\0020\004X\004¢\006\002\n\000R\016\020:\032\0020;X\016¢\006\002\n\000R\016\020<\032\0020=X\016¢\006\002\n\000R\020\020>\032\004\030\00108X\016¢\006\002\n\000R\016\020?\032\0020;X\016¢\006\002\n\000R\016\020@\032\0020\bX\004¢\006\002\n\000R\016\020A\032\0020\004X\004¢\006\002\n\000R\016\020B\032\0020\004X\004¢\006\002\n\000R\016\020C\032\0020\bX\004¢\006\002\n\000R\021\020D\032\0020\b¢\006\b\n\000\032\004\bE\020\rR\016\020F\032\0020\037X\016¢\006\002\n\000R\016\020G\032\0020\004X\004¢\006\002\n\000R\021\020H\032\0020(¢\006\b\n\000\032\004\bI\020JR\016\020K\032\0020\004X\004¢\006\002\n\000R\016\020L\032\0020\004X\004¢\006\002\n\000R\021\020M\032\0020\0378F¢\006\006\032\004\bM\020!R\016\020N\032\0020\037X\016¢\006\002\n\000R\016\020O\032\0020\bX\004¢\006\002\n\000R\016\020P\032\0020\bX\004¢\006\002\n\000R\016\020Q\032\0020\bX\004¢\006\002\n\000R\016\020R\032\0020\bX\004¢\006\002\n\000R\032\020S\032\0020\017X\016¢\006\016\n\000\032\004\bT\020U\"\004\bV\020WR\021\020X\032\0020\004¢\006\b\n\000\032\004\bY\020\006R\016\020Z\032\0020\021X\016¢\006\002\n\000R\016\020[\032\0020\021X\016¢\006\002\n\000R\020\020\\\032\004\030\00108X\016¢\006\002\n\000R\016\020]\032\0020\026X\004¢\006\002\n\000R\016\020^\032\0020\004X\004¢\006\002\n\000R\016\020_\032\0020\004X\004¢\006\002\n\000R\016\020`\032\0020(X\004¢\006\002\n\000R\016\020a\032\0020\004X\004¢\006\002\n\000R\020\020b\032\004\030\0010cX\016¢\006\002\n\000R\016\020d\032\0020\023X\004¢\006\002\n\000R\016\020e\032\0020\026X\004¢\006\002\n\000R\021\020f\032\0020(¢\006\b\n\000\032\004\bg\020JR\016\020h\032\0020\bX\004¢\006\002\n\000R\024\020i\032\0020\0178BX\004¢\006\006\032\004\bj\020UR\016\020k\032\0020\bX\004¢\006\002\n\000R\021\020l\032\0020(¢\006\b\n\000\032\004\bm\020JR\016\020n\032\0020\bX\004¢\006\002\n\000R\016\020o\032\0020\bX\004¢\006\002\n\000R\016\020p\032\0020\004X\004¢\006\002\n\000R\016\020q\032\0020(X\004¢\006\002\n\000R\016\020r\032\0020\004X\004¢\006\002\n\000R\016\020s\032\0020\004X\004¢\006\002\n\000R\024\020t\032\b\022\004\022\0020\0330uX\004¢\006\002\n\000R\016\020v\032\0020\026X\004¢\006\002\n\000R\016\020w\032\0020;X\016¢\006\002\n\000R\016\020x\032\0020\004X\004¢\006\002\n\000R\016\020y\032\0020\bX\004¢\006\002\n\000R\021\020z\032\0020\b¢\006\b\n\000\032\004\b{\020\rR\016\020|\032\0020\004X\004¢\006\002\n\000R\016\020}\032\0020\004X\004¢\006\002\n\000R\016\020~\032\0020\026X\004¢\006\002\n\000R\016\020\032\0020\026X\004¢\006\002\n\000R\017\020\001\032\0020\bX\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020\004X\004¢\006\002\n\000R\017\020\001\032\0020(X\004¢\006\002\n\000R\017\020\001\032\0020\023X\004¢\006\002\n\000R!\020\001\032\004\030\00108X\016¢\006\022\n\000\032\006\b\001\020\001\"\006\b\001\020\001R\027\020\001\032\0020=8VX\004¢\006\b\032\006\b\001\020\001R!\020\001\032\004\030\00108X\016¢\006\022\n\000\032\006\b\001\020\001\"\006\b\001\020\001R\017\020\001\032\0020\026X\004¢\006\002\n\000R\017\020\001\032\0020\bX\004¢\006\002\n\000R\017\020\001\032\0020\026X\004¢\006\002\n\000R\017\020\001\032\0020;X\016¢\006\002\n\000¨\006¼\001"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AirBypass", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getAirBypass", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "BlockRangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "aacValue", "afterAttackValue", "airRangeValue", "getAirRangeValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "al", "", "attackDelay", "", "attackTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "autoBlockFacing", "autoBlockPacketValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "autoBlockValue", "bb", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "blockKey", "", "getBlockKey", "()I", "blockingStatus", "", "getBlockingStatus", "()Z", "setBlockingStatus", "(Z)V", "brightnessValue", "cancelRun", "getCancelRun", "circleAccuracy", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "circleAlpha", "circleBlue", "circleGreen", "circleRed", "circleValue", "clicks", "colorAlphaValue", "colorBlueValue", "colorGreenValue", "colorModeValue", "colorRedValue", "colorTeam", "containerOpen", "cooldownValue", "currentTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "delayedBlockValue", "direction", "", "displayText", "", "entity", "espAnimation", "failRateValue", "fakeSharpValue", "fakeSwingValue", "fovValue", "groundRangeValue", "getGroundRangeValue", "hitable", "hitableValue", "hurtTimeValue", "getHurtTimeValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "hyt180fovfixValue", "interactAutoBlockValue", "isBlockingChestAura", "isUp", "jelloAlphaValue", "jelloFadeSpeedValue", "jelloGradientHeightValue", "jelloWidthValue", "karange", "getKarange", "()F", "setKarange", "(F)V", "keepSprintValue", "getKeepSprintValue", "lastDeltaMS", "lastMS", "lastTarget", "lightingModeValue", "lightingSoundValue", "lightingValue", "limitedMultiTargetsValue", "livingRaycastValue", "markEntity", "Lnet/minecraft/entity/EntityLivingBase;", "markTimer", "markValue", "maxCPS", "getMaxCPS", "maxPredictSize", "maxRange", "getMaxRange", "maxTurnSpeed", "minCPS", "getMinCPS", "minPredictSize", "minTurnSpeed", "noInventoryAttackValue", "noInventoryDelayValue", "outborderValue", "predictValue", "prevTargetEntities", "", "priorityValue", "progress", "randomCenterValue", "rangeSprintReducementValue", "rangeValue", "getRangeValue", "raycastIgnoredValue", "raycastValue", "rotationStrafeValue", "rotations", "saturationValue", "silentRotationValue", "stopSprintAir", "switchDelayValue", "switchTimer", "syncEntity", "getSyncEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setSyncEntity", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "tag", "getTag", "()Ljava/lang/String;", "target", "getTarget", "setTarget", "targetModeValue", "throughWallsRangeValue", "vanillamode", "yPos", "attackEntity", "", "canBlock", "drawESP", "color", "e", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "esp", "partialTicks", "radius", "getRange", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isAlive", "isEnemy", "onDisable", "onEnable", "onEntityMove", "event", "Lnet/ccbluex/liquidbounce/event/EntityMovementEvent;", "onMotion", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onRender3D", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onTick", "Lnet/ccbluex/liquidbounce/event/TickEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "runAttack", "startBlocking", "interactEntity", "interact", "stopBlocking", "update", "updateHitable", "updateRotations", "updateTarget", "Companion", "XSJClient"})
/*      */ public final class KillAura2
/*      */   extends Module
/*      */ {
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"post3D", "", "invoke"})
/*      */   static final class KillAura2$onRender3D$1
/*      */     extends Lambda
/*      */     implements Function0<Unit>
/*      */   {
/*      */     public static final KillAura2$onRender3D$1 INSTANCE = new KillAura2$onRender3D$1();
/*      */     
/*      */     public final void invoke() {
/*  579 */       GL11.glDepthMask(true);
/*  580 */       GL11.glEnable(2929);
/*  581 */       GL11.glDisable(2848);
/*  582 */       GL11.glEnable(3553);
/*  583 */       GL11.glDisable(3042);
/*  584 */       GL11.glPopMatrix();
/*  585 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     }
/*      */     
/*      */     KillAura2$onRender3D$1() {
/*      */       super(0);
/*      */     }
/*      */   }
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\030\n\000\n\002\020\002\n\000\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\006\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0032\006\020\005\032\0020\0032\006\020\006\032\0020\0072\006\020\b\032\0020\0032\006\020\t\032\0020\0072\006\020\n\032\0020\0072\006\020\013\032\0020\0072\006\020\f\032\0020\007H\n¢\006\002\b\r"}, d2 = {"drawCircle", "", "x", "", "y", "z", "width", "", "radius", "red", "green", "blue", "alp", "invoke"})
/*      */   static final class KillAura2$onRender3D$2
/*      */     extends Lambda implements Function9<Double, Double, Double, Float, Double, Float, Float, Float, Float, Unit>
/*      */   {
/*      */     public static final KillAura2$onRender3D$2 INSTANCE = new KillAura2$onRender3D$2();
/*      */     
/*  599 */     public final void invoke(double x, double y, double z, float width, double radius, float red, float green, float blue, float alp) { GL11.glLineWidth(width);
/*  600 */       GL11.glBegin(2);
/*  601 */       GL11.glColor4f(red, green, blue, alp);
/*  602 */       int i = 0;
/*  603 */       while (i <= 360) {
/*  604 */         double posX = x - Math.sin(i * Math.PI / '´') * radius;
/*  605 */         double posZ = z + Math.cos(i * Math.PI / '´') * radius;
/*  606 */         GL11.glVertex3d(posX, y, posZ);
/*  607 */         i++;
/*      */       } 
/*  609 */       GL11.glEnd(); } KillAura2$onRender3D$2() { super(9); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"pre3D", "", "invoke"})
/*      */   static final class KillAura2$onRender3D$3 extends Lambda implements Function0<Unit> { public static final KillAura2$onRender3D$3 INSTANCE = new KillAura2$onRender3D$3();
/*  612 */     public final void invoke() { GL11.glPushMatrix();
/*  613 */       GL11.glEnable(3042);
/*  614 */       GL11.glBlendFunc(770, 771);
/*  615 */       GL11.glShadeModel(7425);
/*  616 */       GL11.glDisable(3553);
/*  617 */       GL11.glEnable(2848);
/*  618 */       GL11.glDisable(2929);
/*  619 */       GL11.glDisable(2896);
/*  620 */       GL11.glDepthMask(false);
/*  621 */       GL11.glHint(3154, 4354);
/*  622 */       GL11.glDisable(2884); } KillAura2$onRender3D$3() { super(0); } }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\004\030\0010\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"getColor", "Ljava/awt/Color;", "ent", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "invoke"})
/*      */   static final class KillAura2$onRender3D$4 extends Lambda implements Function1<IEntityLivingBase, Color> { @Nullable
/*  625 */     public final Color invoke(@Nullable IEntityLivingBase ent) { int[] counter = { 0 };
/*  626 */       if (ent instanceof EntityLivingBase) {
/*  627 */         IEntityLivingBase entityLivingBase = ent;
/*      */         
/*  629 */         if (StringsKt.equals((String)KillAura2.this.colorModeValue.get(), "Health", true)) return BlendUtils.getHealthColor(
/*  630 */               entityLivingBase.getHealth(), 
/*  631 */               entityLivingBase.getMaxHealth());
/*      */         
/*  633 */         if (((Boolean)KillAura2.this.colorTeam.get()).booleanValue()) {
/*      */           
/*  635 */           if (entityLivingBase.getDisplayName() == null) Intrinsics.throwNpe();  String str1 = entityLivingBase.getDisplayName().getFormattedText(); byte b = 0; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] chars = str1.toCharArray();
/*  636 */           int color = Integer.MAX_VALUE; int i;
/*  637 */           for (b = 0, i = chars.length; b < i; b++) {
/*  638 */             if (chars[b] == '§' && b + 1 < chars.length) {
/*  639 */               int index = GameFontRenderer.Companion.getColorIndex(chars[b + 1]);
/*  640 */               if (index >= 0 && index <= 15) {
/*  641 */                 color = ColorUtils.hexColors[index]; break;
/*      */               } 
/*      */             } 
/*  644 */           }  return new Color(color);
/*      */         } 
/*      */       } 
/*  647 */       String str = (String)KillAura2.this.colorModeValue.get(); switch (str.hashCode())
/*      */       
/*      */       { 
/*      */         
/*      */         case 83201:
/*  652 */           if (str.equals("Sky")); break;
/*  653 */         case -884013110: if (str.equals("LiquidSlowly")); break;case -1656737386: if (str.equals("Rainbow")); break;
/*  654 */         case 2029746065: if (str.equals("Custom")); break; }  return ColorUtils.fade(new Color(((Number)KillAura2.this.colorRedValue.get()).intValue(), ((Number)KillAura2.this.colorGreenValue.get()).intValue(), ((Number)KillAura2.this.colorBlueValue.get()).intValue()), 0, 100); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     KillAura2$onRender3D$4() {
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
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\n\n\000\n\002\020\006\n\002\b\002\020\000\032\0020\0012\006\020\002\032\0020\001H\n¢\006\002\b\003"}, d2 = {"easeInOutQuart", "", "x", "invoke"})
/*      */   static final class KillAura2$onRender3D$5
/*      */     extends Lambda
/*      */     implements Function1<Double, Double>
/*      */   {
/*      */     public static final KillAura2$onRender3D$5 INSTANCE = new KillAura2$onRender3D$5();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     KillAura2$onRender3D$5() {
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
/*      */     public final double invoke(double x) {
/*  803 */       return (x < 0.5D) ? (8 * x * x * x * x) : (true - Math.pow(-2 * x + 2, 4.0D) / 2);
/*      */     }
/*      */   } @NotNull
/*      */   private final IntegerValue maxCPS = new KillAura2$maxCPS$1("MaxCPS", 8, 1, 20);
/*      */   @NotNull
/*      */   public final IntegerValue getMaxCPS() {
/*      */     return this.maxCPS;
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$maxCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*      */   public static final class KillAura2$maxCPS$1 extends IntegerValue { KillAura2$maxCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) {
/*      */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*      */     }
/*      */     protected void onChanged(int oldValue, int newValue) {
/*      */       int i = ((Number)KillAura2.this.getMinCPS().get()).intValue();
/*      */       if (i > newValue)
/*      */         set(Integer.valueOf(i)); 
/*      */       KillAura2.this.attackDelay = TimeUtils.randomClickDelay(((Number)KillAura2.this.getMinCPS().get()).intValue(), ((Number)get()).intValue());
/*      */     } }
/*      */   @NotNull
/*      */   private final IntegerValue minCPS = new KillAura2$minCPS$1("MinCPS", 5, 1, 20);
/*      */   @NotNull
/*      */   public final IntegerValue getMinCPS() {
/*      */     return this.minCPS;
/*      */   }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$minCPS$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*      */   public static final class KillAura2$minCPS$1 extends IntegerValue {
/*      */     KillAura2$minCPS$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) {
/*      */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*      */     }
/*      */     protected void onChanged(int oldValue, int newValue) {
/*      */       int i = ((Number)KillAura2.this.getMaxCPS().get()).intValue();
/*      */       if (i < newValue)
/*      */         set(Integer.valueOf(i)); 
/*      */       KillAura2.this.attackDelay = TimeUtils.randomClickDelay(((Number)get()).intValue(), ((Number)KillAura2.this.getMaxCPS().get()).intValue());
/*      */     }
/*      */   }
/*      */   @NotNull
/*      */   private final IntegerValue hurtTimeValue = new IntegerValue("HurtTime", 10, 0, 10);
/*      */   @NotNull
/*      */   public final IntegerValue getHurtTimeValue() {
/*      */     return this.hurtTimeValue;
/*      */   }
/*      */   private final FloatValue cooldownValue = new FloatValue("Cooldown", 1.0F, 0.0F, 1.0F); @NotNull
/*      */   private final FloatValue rangeValue = new FloatValue("Range", 3.7F, 1.0F, 8.0F);
/*      */   @NotNull
/*      */   public final FloatValue getRangeValue() {
/*      */     return this.rangeValue;
/*      */   }
/*      */   private float karange = ((Number)this.rangeValue.get()).floatValue();
/*      */   public final float getKarange() {
/*      */     return this.karange;
/*      */   }
/*      */   public final void setKarange(float <set-?>) {
/*      */     this.karange = <set-?>;
/*      */   }
/*      */   @NotNull
/*      */   private final FloatValue groundRangeValue = new FloatValue("GroundRange", 3.7F, 1.0F, 8.0F);
/*      */   @NotNull
/*      */   public final FloatValue getGroundRangeValue() {
/*      */     return this.groundRangeValue;
/*      */   }
/*      */   @NotNull
/*      */   private final FloatValue airRangeValue = new FloatValue("AirRange", 3.7F, 1.0F, 8.0F);
/*      */   @NotNull
/*      */   public final FloatValue getAirRangeValue() {
/*      */     return this.airRangeValue;
/*      */   }
/*      */   private final FloatValue throughWallsRangeValue = new FloatValue("ThroughWallsRange", 3.0F, 0.0F, 8.0F); private final FloatValue rangeSprintReducementValue = new FloatValue("RangeSprintReducement", 0.0F, 0.0F, 0.4F); private final ListValue priorityValue = new ListValue("Priority", new String[] { "Health", "Distance", "Direction", "LivingTime", "HurtResitanTime" }, "Distance"); private final ListValue targetModeValue = new ListValue("TargetMode", new String[] { "Single", "Switch", "Multi" }, "Switch"); @NotNull
/*      */   private final BoolValue keepSprintValue = new BoolValue("KeepSprint", true);
/*      */   @NotNull
/*      */   public final BoolValue getKeepSprintValue() {
/*      */     return this.keepSprintValue;
/*      */   }
/*      */   private final BoolValue stopSprintAir = new BoolValue("StopSprintOnAir", true); @NotNull
/*      */   private final BoolValue AirBypass = new BoolValue("AirBypass", true);
/*      */   @NotNull
/*      */   public final BoolValue getAirBypass() {
/*      */     return this.AirBypass;
/*      */   }
/*      */   private final BoolValue hyt180fovfixValue = new BoolValue("Hyt180FovFix", true); private final ListValue autoBlockValue = new ListValue("AutoBlock", new String[] { "HuaYuTing", "AllTime", "Range", "Off" }, "Off"); private final FloatValue BlockRangeValue = new FloatValue("BlockRange", 3.0F, 0.0F, 8.0F); private final ListValue autoBlockPacketValue = new ListValue("AutoBlockPacket", new String[] { "Vanilla", "Fake", "Mouse", "GameSettings", "UseItem" }, "Vanilla"); private final ListValue vanillamode = new ListValue("VanillaMode", new String[] { "TryUseItem", "UseItem", "CPacketPlayerBlockPlacement" }, "TryUseItem"); private final BoolValue interactAutoBlockValue = new BoolValue("InteractAutoBlock", true); private final BoolValue delayedBlockValue = new BoolValue("AutoBlock-AfterTck", false); private final BoolValue afterAttackValue = new BoolValue("AutoBlock-AfterAttack", false); private final BoolValue autoBlockFacing = new BoolValue("AutoBlockFacing", false);
/*      */   private final BoolValue raycastValue = new BoolValue("RayCast", true);
/*      */   private final BoolValue raycastIgnoredValue = new BoolValue("RayCastIgnored", false);
/*      */   private final BoolValue livingRaycastValue = new BoolValue("LivingRayCast", true);
/*      */   private final BoolValue aacValue = new BoolValue("AAC", false);
/*      */   private final FloatValue maxTurnSpeed = new KillAura2$maxTurnSpeed$1("MaxTurnSpeed", 180.0F, 0.0F, 180.0F);
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$maxTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*      */   public static final class KillAura2$maxTurnSpeed$1 extends FloatValue { KillAura2$maxTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) {
/*      */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*      */     }
/*      */     
/*      */     protected void onChanged(float oldValue, float newValue) {
/*      */       float v = ((Number)KillAura2.this.minTurnSpeed.get()).floatValue();
/*      */       if (v > newValue)
/*      */         set(Float.valueOf(v)); 
/*      */     } }
/*      */   
/*      */   private final FloatValue minTurnSpeed = new KillAura2$minTurnSpeed$1("MinTurnSpeed", 180.0F, 0.0F, 180.0F);
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$minTurnSpeed$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*      */   public static final class KillAura2$minTurnSpeed$1 extends FloatValue { KillAura2$minTurnSpeed$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) {
/*      */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*      */     }
/*      */     
/*      */     protected void onChanged(float oldValue, float newValue) {
/*      */       float v = ((Number)KillAura2.this.maxTurnSpeed.get()).floatValue();
/*      */       if (v < newValue)
/*      */         set(Float.valueOf(v)); 
/*      */     } }
/*      */   
/*      */   private final BoolValue lightingValue = new BoolValue("Lighting", false);
/*      */   private final ListValue lightingModeValue = new ListValue("Lighting-Mode", new String[] { "Dead", "Attack" }, "Dead");
/*      */   private final BoolValue lightingSoundValue = new BoolValue("Lighting-Sound", true);
/*      */   private final BoolValue randomCenterValue = new BoolValue("RandomCenter", true);
/*      */   private final ListValue rotations = new ListValue("RotationMode", new String[] { "None", "New", "Liquidbounce", "BackTrack", "Test", "Test1", "Test2", "HytRotation", "Down" }, "New");
/*      */   private final BoolValue outborderValue = new BoolValue("Outborder", false);
/*      */   private final BoolValue silentRotationValue = new BoolValue("SilentRotation", true);
/*      */   private final ListValue rotationStrafeValue = new ListValue("Strafe", new String[] { "Off", "Strict", "Silent" }, "Off");
/*      */   private final FloatValue fovValue = new FloatValue("FOV", 180.0F, 0.0F, 180.0F);
/*      */   private final BoolValue hitableValue = new BoolValue("AlwaysHitable", true);
/*      */   private final IntegerValue switchDelayValue = new IntegerValue("SwitchDelay", 300, 1, 2000);
/*      */   private final BoolValue predictValue = new BoolValue("Predict", true);
/*      */   private final FloatValue maxPredictSize = new KillAura2$maxPredictSize$1("MaxPredictSize", 1.0F, 0.1F, 5.0F);
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$maxPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*      */   public static final class KillAura2$maxPredictSize$1 extends FloatValue { KillAura2$maxPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) {
/*      */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*      */     }
/*      */     
/*      */     protected void onChanged(float oldValue, float newValue) {
/*      */       float v = ((Number)KillAura2.this.minPredictSize.get()).floatValue();
/*      */       if (v > newValue)
/*      */         set(Float.valueOf(v)); 
/*      */     } }
/*      */   
/*      */   private final FloatValue minPredictSize = new KillAura2$minPredictSize$1("MinPredictSize", 1.0F, 0.1F, 5.0F);
/*      */   
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$minPredictSize$1", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*      */   public static final class KillAura2$minPredictSize$1 extends FloatValue { KillAura2$minPredictSize$1(String $super_call_param$1, float $super_call_param$2, float $super_call_param$3, float $super_call_param$4) {
/*      */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*      */     }
/*      */     
/*      */     protected void onChanged(float oldValue, float newValue) {
/*      */       float v = ((Number)KillAura2.this.maxPredictSize.get()).floatValue();
/*      */       if (v < newValue)
/*      */         set(Float.valueOf(v)); 
/*      */     } }
/*      */   
/*      */   private final FloatValue failRateValue = new FloatValue("FailRate", 0.0F, 0.0F, 100.0F);
/*      */   private final BoolValue fakeSwingValue = new BoolValue("FakeSwing", true);
/*      */   private final BoolValue noInventoryAttackValue = new BoolValue("NoInvAttack", false);
/*      */   private final IntegerValue noInventoryDelayValue = new IntegerValue("NoInvDelay", 200, 0, 500);
/*      */   private final IntegerValue limitedMultiTargetsValue = new IntegerValue("LimitedMultiTargets", 0, 0, 50);
/*      */   private final ListValue markValue = new ListValue("Mark", new String[] { "Liquid", "FDP", "Block", "Jello", "Plat", "Red", "Sims", "None" }, "FDP");
/*      */   
/*      */   @EventTarget
/*  959 */   public final void onEntityMove(@NotNull EntityMovementEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); IEntity movedEntity = event.getMovedEntity();
/*      */     
/*  961 */     if (this.target == null || (Intrinsics.areEqual(movedEntity, this.currentTarget) ^ true) != 0) {
/*      */       return;
/*      */     }
/*  964 */     updateHitable(); }
/*      */   
/*      */   private final ListValue colorModeValue = new ListValue("JelloColor", new String[] { "Custom", "Rainbow", "Sky", "LiquidSlowly", "Fade", "Health", "Gident" }, "Custom"); private final IntegerValue colorRedValue = new IntegerValue("JelloRed", 255, 0, 255); private final IntegerValue colorGreenValue = new IntegerValue("JelloGreen", 255, 0, 255); private final IntegerValue colorBlueValue = new IntegerValue("JelloBlue", 255, 0, 255); private final IntegerValue colorAlphaValue = new IntegerValue("JelloAlpha", 255, 0, 255); private final FloatValue saturationValue = new FloatValue("Saturation", 1.0F, 0.0F, 1.0F); private final FloatValue brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F); private final BoolValue colorTeam = new BoolValue("JelloTeam", false); private final FloatValue jelloAlphaValue = new FloatValue("JelloEndAlphaPercent", 0.4F, 0.0F, 1.0F); private final FloatValue jelloWidthValue = new FloatValue("JelloCircleWidth", 3.0F, 0.01F, 5.0F); private final FloatValue jelloGradientHeightValue = new FloatValue("JelloGradientHeight", 3.0F, 1.0F, 8.0F); private final FloatValue jelloFadeSpeedValue = new FloatValue("JelloFadeSpeed", 0.1F, 0.01F, 0.5F); private final BoolValue fakeSharpValue = new BoolValue("FakeSharp", true); private final BoolValue circleValue = new BoolValue("Circle", true); private final IntegerValue circleRed = new IntegerValue("CircleRed", 255, 0, 255); private final IntegerValue circleGreen = new IntegerValue("CircleGreen", 255, 0, 255); private final IntegerValue circleBlue = new IntegerValue("CircleBlue", 255, 0, 255); private final IntegerValue circleAlpha = new IntegerValue("CircleAlpha", 255, 0, 255); private final IntegerValue circleAccuracy = new IntegerValue("CircleAccuracy", 15, 0, 60); private final int blockKey = MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().getKeyCode(); public final int getBlockKey() {
/*      */     return this.blockKey;
/*      */   }
/*      */   private final MSTimer switchTimer = new MSTimer(); @Nullable
/*      */   private IEntityLivingBase target; private IEntityLivingBase currentTarget; private boolean hitable; private final List<Integer> prevTargetEntities; private IEntityLivingBase lastTarget; private double direction; private double yPos; private double progress; private long lastMS; private long lastDeltaMS; private float al;
/*  971 */   private final void runAttack() { if (this.target != null)
/*  972 */     { if (this.currentTarget != null)
/*  973 */       { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  974 */           if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*      */ 
/*      */             
/*  977 */             float failRate = ((Number)this.failRateValue.get()).floatValue();
/*  978 */             boolean swing = true;
/*  979 */             boolean multi = StringsKt.equals((String)this.targetModeValue.get(), "Multi", true);
/*  980 */             boolean openInventory = (((Boolean)this.aacValue.get()).booleanValue() && MinecraftInstance.classProvider.isGuiContainer(MinecraftInstance.mc.getCurrentScreen()));
/*  981 */             boolean failHit = (failRate > false && (new Random()).nextInt(100) <= failRate);
/*      */ 
/*      */             
/*  984 */             if (openInventory) {
/*  985 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow());
/*      */             }
/*      */ 
/*      */             
/*  989 */             if (!this.hitable || failHit) {
/*  990 */               if (((Boolean)this.fakeSwingValue.get()).booleanValue() || failHit) {
/*  991 */                 thePlayer.swingItem();
/*      */               }
/*      */             } else {
/*  994 */               if (!multi) {
/*  995 */                 if (this.currentTarget == null) Intrinsics.throwNpe();  attackEntity(this.currentTarget);
/*      */               } else {
/*  997 */                 int targets = 0;
/*      */                 
/*  999 */                 for (IEntity entity : theWorld.getLoadedEntityList()) {
/* 1000 */                   double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity);
/*      */                   
/* 1002 */                   if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && isEnemy(entity) && distance <= getRange(entity)) {
/* 1003 */                     attackEntity(entity.asEntityLivingBase());
/*      */                     
/* 1005 */                     targets++;
/*      */                     
/* 1007 */                     if (((Number)this.limitedMultiTargetsValue.get()).intValue() != 0 && ((Number)this.limitedMultiTargetsValue.get()).intValue() <= targets) {
/*      */                       break;
/*      */                     }
/*      */                   } 
/*      */                 } 
/*      */               } 
/* 1013 */               if (StringsKt.equals((String)this.targetModeValue.get(), "Switch", true)) {
/* 1014 */                 if (this.switchTimer.hasTimePassed(((Number)this.switchDelayValue.get()).intValue())) {
/* 1015 */                   if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/* 1016 */                   this.switchTimer.reset();
/*      */                 } 
/*      */               } else {
/* 1019 */                 if (this.target == null) Intrinsics.throwNpe();  if (this.currentTarget == null) Intrinsics.throwNpe();  this.prevTargetEntities.add(Integer.valueOf(((Boolean)this.aacValue.get()).booleanValue() ? this.target.getEntityId() : this.currentTarget.getEntityId()));
/*      */               } 
/*      */               
/* 1022 */               if (Intrinsics.areEqual(this.target, this.currentTarget)) {
/* 1023 */                 this.target = (IEntityLivingBase)null;
/*      */               }
/*      */             } 
/*      */             
/* 1027 */             if (openInventory)
/* 1028 */             { IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createOpenInventoryPacket = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1628 */               if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY); iINetHandlerPlayClient.addToSendQueue(iPacket); }  return; }  MinecraftInstance.mc.getTheWorld(); return; }  MinecraftInstance.mc.getThePlayer(); return; }  return; }  } private final MSTimer attackTimer; private long attackDelay; private int clicks; private EntityLivingBase markEntity; private final MSTimer markTimer; private long containerOpen; private String displayText; private IAxisAlignedBB bb; private IEntityLivingBase entity; private boolean blockingStatus; private double espAnimation; private boolean isUp; @Nullable private IEntityLivingBase syncEntity; private static int killCounts; public static final Companion Companion = new Companion(null); @Nullable public final IEntityLivingBase getTarget() { return this.target; } public final void setTarget(@Nullable IEntityLivingBase <set-?>) { this.target = <set-?>; } public KillAura2() { KillAura2 killAura2 = this; boolean bool = false; ArrayList<Integer> arrayList = new ArrayList(); this.direction = 1.0D; this.lastMS = System.currentTimeMillis(); this.attackTimer = new MSTimer(); this.markTimer = new MSTimer(); this.containerOpen = -1L; this.displayText = ""; this.isUp = true; } public final boolean getBlockingStatus() { return this.blockingStatus; } public final void setBlockingStatus(boolean <set-?>) { this.blockingStatus = <set-?>; } @Nullable public final IEntityLivingBase getSyncEntity() { return this.syncEntity; } public final void setSyncEntity(@Nullable IEntityLivingBase <set-?>) { this.syncEntity = <set-?>; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\006\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R$\020\003\032\0020\0048\006@\006X\016¢\006\024\n\000\022\004\b\005\020\002\032\004\b\006\020\007\"\004\b\b\020\t¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$Companion;", "", "()V", "killCounts", "", "killCounts$annotations", "getKillCounts", "()I", "setKillCounts", "(I)V", "XSJClient"}) public static final class Companion {
/*      */     private Companion() {} public final void setKillCounts(int <set-?>) { KillAura2.killCounts = <set-?>; } public final int getKillCounts() { return KillAura2.killCounts; } } public void onEnable() { if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer(); if (MinecraftInstance.mc.getTheWorld() != null) { MinecraftInstance.mc.getTheWorld(); updateTarget(); return; }  MinecraftInstance.mc.getTheWorld(); return; }  MinecraftInstance.mc.getThePlayer(); } public void onDisable() { this.target = (IEntityLivingBase)null; this.currentTarget = (IEntityLivingBase)null; this.lastTarget = (IEntityLivingBase)null; this.hitable = false; this.prevTargetEntities.clear(); this.attackTimer.reset(); this.clicks = 0; stopBlocking(); } @EventTarget public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.stopSprintAir.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { this.keepSprintValue.set(Boolean.valueOf(true)); } else { this.keepSprintValue.set(Boolean.valueOf(false)); }  }  if (event.getEventState() == EventState.POST) { if (this.target != null) { if (this.currentTarget != null) { updateHitable(); if (!StringsKt.equals((String)this.autoBlockValue.get(), "off", true) && ((Boolean)this.delayedBlockValue.get()).booleanValue() && canBlock()) { if (this.currentTarget == null) Intrinsics.throwNpe();  startBlocking((IEntity)this.currentTarget, ((Boolean)this.interactAutoBlockValue.get()).booleanValue()); }  return; }  return; }  return; }  if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) update();  } @EventTarget public final void onStrafe(@NotNull StrafeEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.rotationStrafeValue.get(), "Off", true)) return;  update(); if (this.currentTarget != null && RotationUtils.targetRotation != null) { String str = (String)this.rotationStrafeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -902327211: if (str.equals("silent")) { update(); RotationUtils.targetRotation.applyStrafeToPlayer(event); event.cancelEvent(); }  break;case -891986231: if (str.equals("strict")) { if (RotationUtils.targetRotation != null) { Rotation rotation = RotationUtils.targetRotation; float yaw = rotation.component1(); float strafe = event.getStrafe(); float forward = event.getForward(); float friction = event.getFriction(); float f = strafe * strafe + forward * forward; if (f >= 1.0E-4F) { boolean bool1 = false; f = (float)Math.sqrt(f); if (f < 1.0F) f = 1.0F;  f = friction / f; strafe *= f; forward *= f; float f1 = (float)(yaw * Math.PI / 180.0F); boolean bool2 = false; float yawSin = (float)Math.sin(f1); float f2 = (float)(yaw * Math.PI / 180.0F); boolean bool3 = false; float yawCos = (float)Math.cos(f2); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer(); player.setMotionX(player.getMotionX() + (strafe * yawCos - forward * yawSin)); player.setMotionZ(player.getMotionZ() + (forward * yawCos + strafe * yawSin)); }  event.cancelEvent(); break; }  return; }  break; }  }  } public final void update() { // Byte code:
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
/*      */     //   46: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
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
/*      */     //   #370	-> 0
/*      */     //   #371	-> 0
/*      */     //   #370	-> 2
/*      */     //   #1614	-> 4
/*      */     //   #1615	-> 4
/*      */     //   #1614	-> 28
/*      */     //   #1615	-> 52
/*      */     //   #370	-> 96
/*      */     //   #371	-> 131
/*      */     //   #372	-> 156
/*      */     //   #374	-> 157
/*      */     //   #376	-> 161
/*      */     //   #377	-> 168
/*      */     //   #378	-> 172
/*      */     //   #384	-> 173
/*      */     //   #386	-> 181
/*      */     //   #387	-> 215
/*      */     //   #388	-> 223
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   2	91	1	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */     //   4	89	2	$i$f$getCancelRun	I
/*      */     //   0	224	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2; } @EventTarget public final void onTick(@Nullable TickEvent event) { if (StringsKt.equals((String)this.markValue.get(), "jello", true)) this.al = AnimationUtils.changer(this.al, (this.target != null) ? ((Number)this.jelloFadeSpeedValue.get()).floatValue() : -((Number)this.jelloFadeSpeedValue.get()).floatValue(), 0.0F, ((Number)this.colorAlphaValue.get()).floatValue() / 255.0F);  } @EventTarget public final void onMove(@NotNull MoveEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.AirBypass.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) { if (((Number)this.rangeValue.get()).floatValue() != ((Number)this.groundRangeValue.get()).floatValue()) this.rangeValue.set(this.groundRangeValue.get());  } else if (((Number)this.rangeValue.get()).floatValue() != ((Number)this.airRangeValue.get()).floatValue()) { this.rangeValue.set(this.airRangeValue.get()); }  }  } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: aload_0
/*      */     //   8: getfield AirBypass : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   14: checkcast java/lang/Boolean
/*      */     //   17: invokevirtual booleanValue : ()Z
/*      */     //   20: ifeq -> 118
/*      */     //   23: aload_0
/*      */     //   24: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   27: dup
/*      */     //   28: ifnonnull -> 34
/*      */     //   31: invokestatic throwNpe : ()V
/*      */     //   34: invokeinterface getPosY : ()D
/*      */     //   39: d2i
/*      */     //   40: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   43: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   46: getfield field_70163_u : D
/*      */     //   49: d2i
/*      */     //   50: if_icmple -> 87
/*      */     //   53: aload_0
/*      */     //   54: getfield rotations : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   57: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   60: checkcast java/lang/String
/*      */     //   63: ldc_w 'Down'
/*      */     //   66: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   69: iconst_1
/*      */     //   70: ixor
/*      */     //   71: ifeq -> 118
/*      */     //   74: aload_0
/*      */     //   75: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   78: ldc_w 'Down'
/*      */     //   81: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   84: goto -> 118
/*      */     //   87: aload_0
/*      */     //   88: getfield rotations : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   91: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   94: checkcast java/lang/String
/*      */     //   97: ldc_w 'Test'
/*      */     //   100: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   103: iconst_1
/*      */     //   104: ixor
/*      */     //   105: ifeq -> 118
/*      */     //   108: aload_0
/*      */     //   109: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   112: ldc_w 'Test'
/*      */     //   115: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   118: aload_0
/*      */     //   119: getfield hyt180fovfixValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   122: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   125: checkcast java/lang/Boolean
/*      */     //   128: invokevirtual booleanValue : ()Z
/*      */     //   131: ifeq -> 216
/*      */     //   134: aload_0
/*      */     //   135: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   138: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   141: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*      */     //   144: ldc2_w 90.0
/*      */     //   147: dcmpl
/*      */     //   148: ifle -> 185
/*      */     //   151: aload_0
/*      */     //   152: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   155: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   158: checkcast java/lang/String
/*      */     //   161: ldc_w 'Strict'
/*      */     //   164: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   167: iconst_1
/*      */     //   168: ixor
/*      */     //   169: ifeq -> 216
/*      */     //   172: aload_0
/*      */     //   173: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   176: ldc_w 'Strict'
/*      */     //   179: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   182: goto -> 216
/*      */     //   185: aload_0
/*      */     //   186: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   189: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   192: checkcast java/lang/String
/*      */     //   195: ldc_w 'Silent'
/*      */     //   198: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   201: iconst_1
/*      */     //   202: ixor
/*      */     //   203: ifeq -> 216
/*      */     //   206: aload_0
/*      */     //   207: getfield rotationStrafeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   210: ldc_w 'Silent'
/*      */     //   213: invokevirtual set : (Ljava/lang/Object;)V
/*      */     //   216: aload_0
/*      */     //   217: getfield lightingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   220: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   223: checkcast java/lang/Boolean
/*      */     //   226: invokevirtual booleanValue : ()Z
/*      */     //   229: ifeq -> 790
/*      */     //   232: aload_0
/*      */     //   233: getfield lightingModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   236: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   239: checkcast java/lang/String
/*      */     //   242: astore_2
/*      */     //   243: iconst_0
/*      */     //   244: istore_3
/*      */     //   245: aload_2
/*      */     //   246: dup
/*      */     //   247: ifnonnull -> 261
/*      */     //   250: new kotlin/TypeCastException
/*      */     //   253: dup
/*      */     //   254: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   257: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   260: athrow
/*      */     //   261: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   264: dup
/*      */     //   265: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   268: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   271: astore_2
/*      */     //   272: aload_2
/*      */     //   273: invokevirtual hashCode : ()I
/*      */     //   276: lookupswitch default -> 790, -1407259064 -> 304, 3079268 -> 317
/*      */     //   304: aload_2
/*      */     //   305: ldc_w 'attack'
/*      */     //   308: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   311: ifeq -> 790
/*      */     //   314: goto -> 667
/*      */     //   317: aload_2
/*      */     //   318: ldc_w 'dead'
/*      */     //   321: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   324: ifeq -> 790
/*      */     //   327: aload_0
/*      */     //   328: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   331: ifnull -> 504
/*      */     //   334: aload_0
/*      */     //   335: aload_0
/*      */     //   336: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   339: ifnonnull -> 349
/*      */     //   342: aload_0
/*      */     //   343: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   346: goto -> 498
/*      */     //   349: aload_0
/*      */     //   350: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   353: dup
/*      */     //   354: ifnonnull -> 360
/*      */     //   357: invokestatic throwNpe : ()V
/*      */     //   360: invokeinterface getHealth : ()F
/*      */     //   365: iconst_0
/*      */     //   366: i2f
/*      */     //   367: fcmpg
/*      */     //   368: ifgt -> 494
/*      */     //   371: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   374: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   379: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   382: dup
/*      */     //   383: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   386: dup
/*      */     //   387: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   390: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   393: checkcast net/minecraft/world/World
/*      */     //   396: aload_0
/*      */     //   397: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   400: dup
/*      */     //   401: ifnonnull -> 407
/*      */     //   404: invokestatic throwNpe : ()V
/*      */     //   407: invokeinterface getPosX : ()D
/*      */     //   412: aload_0
/*      */     //   413: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   416: dup
/*      */     //   417: ifnonnull -> 423
/*      */     //   420: invokestatic throwNpe : ()V
/*      */     //   423: invokeinterface getPosY : ()D
/*      */     //   428: aload_0
/*      */     //   429: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   432: dup
/*      */     //   433: ifnonnull -> 439
/*      */     //   436: invokestatic throwNpe : ()V
/*      */     //   439: invokeinterface getPosZ : ()D
/*      */     //   444: iconst_1
/*      */     //   445: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   448: checkcast net/minecraft/entity/Entity
/*      */     //   451: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   454: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   459: aload_0
/*      */     //   460: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   463: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   466: checkcast java/lang/Boolean
/*      */     //   469: invokevirtual booleanValue : ()Z
/*      */     //   472: ifeq -> 494
/*      */     //   475: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   478: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   483: ldc_w 'entity.lightning.impact'
/*      */     //   486: ldc_w 0.5
/*      */     //   489: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   494: aload_0
/*      */     //   495: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   498: putfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   501: goto -> 790
/*      */     //   504: aload_0
/*      */     //   505: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   508: ifnull -> 664
/*      */     //   511: aload_0
/*      */     //   512: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   515: dup
/*      */     //   516: ifnonnull -> 522
/*      */     //   519: invokestatic throwNpe : ()V
/*      */     //   522: invokeinterface getHealth : ()F
/*      */     //   527: iconst_0
/*      */     //   528: i2f
/*      */     //   529: fcmpg
/*      */     //   530: ifgt -> 664
/*      */     //   533: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   536: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   541: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   544: dup
/*      */     //   545: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   548: dup
/*      */     //   549: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   552: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   555: checkcast net/minecraft/world/World
/*      */     //   558: aload_0
/*      */     //   559: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   562: dup
/*      */     //   563: ifnonnull -> 569
/*      */     //   566: invokestatic throwNpe : ()V
/*      */     //   569: invokeinterface getPosX : ()D
/*      */     //   574: aload_0
/*      */     //   575: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   578: dup
/*      */     //   579: ifnonnull -> 585
/*      */     //   582: invokestatic throwNpe : ()V
/*      */     //   585: invokeinterface getPosY : ()D
/*      */     //   590: aload_0
/*      */     //   591: getfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   594: dup
/*      */     //   595: ifnonnull -> 601
/*      */     //   598: invokestatic throwNpe : ()V
/*      */     //   601: invokeinterface getPosZ : ()D
/*      */     //   606: iconst_1
/*      */     //   607: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   610: checkcast net/minecraft/entity/Entity
/*      */     //   613: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   616: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   621: aload_0
/*      */     //   622: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   625: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   628: checkcast java/lang/Boolean
/*      */     //   631: invokevirtual booleanValue : ()Z
/*      */     //   634: ifeq -> 656
/*      */     //   637: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   640: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   645: ldc_w 'entity.lightning.impact'
/*      */     //   648: ldc_w 0.5
/*      */     //   651: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   656: aload_0
/*      */     //   657: aload_0
/*      */     //   658: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   661: putfield lastTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   664: goto -> 790
/*      */     //   667: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   670: invokeinterface getNetHandler2 : ()Lnet/minecraft/network/play/INetHandlerPlayClient;
/*      */     //   675: new net/minecraft/network/play/server/SPacketSpawnGlobalEntity
/*      */     //   678: dup
/*      */     //   679: new net/minecraft/entity/effect/EntityLightningBolt
/*      */     //   682: dup
/*      */     //   683: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   686: getfield field_71441_e : Lnet/minecraft/client/multiplayer/WorldClient;
/*      */     //   689: checkcast net/minecraft/world/World
/*      */     //   692: aload_0
/*      */     //   693: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   696: dup
/*      */     //   697: ifnonnull -> 703
/*      */     //   700: invokestatic throwNpe : ()V
/*      */     //   703: invokeinterface getPosX : ()D
/*      */     //   708: aload_0
/*      */     //   709: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   712: dup
/*      */     //   713: ifnonnull -> 719
/*      */     //   716: invokestatic throwNpe : ()V
/*      */     //   719: invokeinterface getPosY : ()D
/*      */     //   724: aload_0
/*      */     //   725: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   728: dup
/*      */     //   729: ifnonnull -> 735
/*      */     //   732: invokestatic throwNpe : ()V
/*      */     //   735: invokeinterface getPosZ : ()D
/*      */     //   740: iconst_1
/*      */     //   741: invokespecial <init> : (Lnet/minecraft/world/World;DDDZ)V
/*      */     //   744: checkcast net/minecraft/entity/Entity
/*      */     //   747: invokespecial <init> : (Lnet/minecraft/entity/Entity;)V
/*      */     //   750: invokeinterface func_147292_a : (Lnet/minecraft/network/play/server/SPacketSpawnGlobalEntity;)V
/*      */     //   755: aload_0
/*      */     //   756: getfield lightingSoundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   759: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   762: checkcast java/lang/Boolean
/*      */     //   765: invokevirtual booleanValue : ()Z
/*      */     //   768: ifeq -> 790
/*      */     //   771: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   774: invokeinterface getSoundHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;
/*      */     //   779: ldc_w 'entity.lightning.impact'
/*      */     //   782: ldc_w 0.5
/*      */     //   785: invokeinterface playSound : (Ljava/lang/String;F)V
/*      */     //   790: aload_0
/*      */     //   791: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   794: ifnull -> 836
/*      */     //   797: aload_0
/*      */     //   798: getfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   801: dup
/*      */     //   802: ifnonnull -> 808
/*      */     //   805: invokestatic throwNpe : ()V
/*      */     //   808: invokeinterface isDead : ()Z
/*      */     //   813: ifeq -> 836
/*      */     //   816: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2.killCounts : I
/*      */     //   819: iconst_1
/*      */     //   820: iadd
/*      */     //   821: putstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2.killCounts : I
/*      */     //   824: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2.killCounts : I
/*      */     //   827: pop
/*      */     //   828: aload_0
/*      */     //   829: aconst_null
/*      */     //   830: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   833: putfield syncEntity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   836: aload_0
/*      */     //   837: astore_2
/*      */     //   838: iconst_0
/*      */     //   839: istore_3
/*      */     //   840: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   843: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   848: dup
/*      */     //   849: ifnonnull -> 855
/*      */     //   852: invokestatic throwNpe : ()V
/*      */     //   855: invokeinterface isSpectator : ()Z
/*      */     //   860: ifne -> 924
/*      */     //   863: aload_2
/*      */     //   864: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   867: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   872: dup
/*      */     //   873: ifnonnull -> 879
/*      */     //   876: invokestatic throwNpe : ()V
/*      */     //   879: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   882: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   885: ifeq -> 924
/*      */     //   888: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   891: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   894: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   897: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   900: invokevirtual getState : ()Z
/*      */     //   903: ifne -> 924
/*      */     //   906: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   909: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   912: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   915: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   918: invokevirtual getState : ()Z
/*      */     //   921: ifeq -> 928
/*      */     //   924: iconst_1
/*      */     //   925: goto -> 929
/*      */     //   928: iconst_0
/*      */     //   929: ifeq -> 958
/*      */     //   932: aload_0
/*      */     //   933: aconst_null
/*      */     //   934: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   937: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   940: aload_0
/*      */     //   941: aconst_null
/*      */     //   942: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   945: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   948: aload_0
/*      */     //   949: iconst_0
/*      */     //   950: putfield hitable : Z
/*      */     //   953: aload_0
/*      */     //   954: invokespecial stopBlocking : ()V
/*      */     //   957: return
/*      */     //   958: aload_0
/*      */     //   959: getfield autoBlockValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   962: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   965: checkcast java/lang/String
/*      */     //   968: ldc_w 'HuaYuTing'
/*      */     //   971: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   974: ifeq -> 1253
/*      */     //   977: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   980: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   985: dup
/*      */     //   986: ifnonnull -> 992
/*      */     //   989: invokestatic throwNpe : ()V
/*      */     //   992: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   997: ifnull -> 1253
/*      */     //   1000: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1003: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1008: dup
/*      */     //   1009: ifnonnull -> 1015
/*      */     //   1012: invokestatic throwNpe : ()V
/*      */     //   1015: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*      */     //   1020: dup
/*      */     //   1021: ifnonnull -> 1027
/*      */     //   1024: invokestatic throwNpe : ()V
/*      */     //   1027: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*      */     //   1032: instanceof net/minecraft/item/ItemSword
/*      */     //   1035: ifeq -> 1253
/*      */     //   1038: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1041: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   1044: getfield field_110158_av : I
/*      */     //   1047: iconst_m1
/*      */     //   1048: if_icmpne -> 1083
/*      */     //   1051: new net/minecraft/network/play/client/CPacketPlayerDigging
/*      */     //   1054: dup
/*      */     //   1055: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.RELEASE_USE_ITEM : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*      */     //   1058: new net/minecraft/util/math/BlockPos
/*      */     //   1061: dup
/*      */     //   1062: iconst_m1
/*      */     //   1063: iconst_m1
/*      */     //   1064: iconst_m1
/*      */     //   1065: invokespecial <init> : (III)V
/*      */     //   1068: getstatic net/minecraft/util/EnumFacing.DOWN : Lnet/minecraft/util/EnumFacing;
/*      */     //   1071: invokespecial <init> : (Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)V
/*      */     //   1074: checkcast net/minecraft/network/Packet
/*      */     //   1077: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*      */     //   1080: goto -> 1253
/*      */     //   1083: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1086: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   1089: getfield field_110158_av : I
/*      */     //   1092: i2d
/*      */     //   1093: ldc2_w 0.5
/*      */     //   1096: dcmpg
/*      */     //   1097: ifge -> 1253
/*      */     //   1100: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*      */     //   1103: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*      */     //   1106: getfield field_110158_av : I
/*      */     //   1109: iconst_m1
/*      */     //   1110: if_icmpeq -> 1253
/*      */     //   1113: new net/minecraft/network/play/client/CPacketPlayerTryUseItemOnBlock
/*      */     //   1116: dup
/*      */     //   1117: new net/minecraft/util/math/BlockPos
/*      */     //   1120: dup
/*      */     //   1121: iconst_m1
/*      */     //   1122: iconst_m1
/*      */     //   1123: iconst_m1
/*      */     //   1124: invokespecial <init> : (III)V
/*      */     //   1127: getstatic net/minecraft/util/EnumFacing.WEST : Lnet/minecraft/util/EnumFacing;
/*      */     //   1130: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*      */     //   1133: fconst_0
/*      */     //   1134: fconst_0
/*      */     //   1135: fconst_0
/*      */     //   1136: invokespecial <init> : (Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/EnumHand;FFF)V
/*      */     //   1139: checkcast net/minecraft/network/Packet
/*      */     //   1142: invokestatic sendPacketNoEvent : (Lnet/minecraft/network/Packet;)V
/*      */     //   1145: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1148: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1153: dup
/*      */     //   1154: ifnonnull -> 1160
/*      */     //   1157: invokestatic throwNpe : ()V
/*      */     //   1160: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   1165: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.MAIN_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*      */     //   1168: astore_2
/*      */     //   1169: astore #4
/*      */     //   1171: iconst_0
/*      */     //   1172: istore_3
/*      */     //   1173: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*      */     //   1176: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1179: aload_2
/*      */     //   1180: invokeinterface createCPacketTryUseItem : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;
/*      */     //   1185: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   1188: astore #5
/*      */     //   1190: aload #4
/*      */     //   1192: aload #5
/*      */     //   1194: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   1199: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1202: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1207: dup
/*      */     //   1208: ifnonnull -> 1214
/*      */     //   1211: invokestatic throwNpe : ()V
/*      */     //   1214: invokeinterface getSendQueue : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*      */     //   1219: getstatic net/ccbluex/liquidbounce/api/enums/WEnumHand.OFF_HAND : Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*      */     //   1222: astore_2
/*      */     //   1223: astore #4
/*      */     //   1225: iconst_0
/*      */     //   1226: istore_3
/*      */     //   1227: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*      */     //   1230: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1233: aload_2
/*      */     //   1234: invokeinterface createCPacketTryUseItem : (Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;)Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;
/*      */     //   1239: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*      */     //   1242: astore #5
/*      */     //   1244: aload #4
/*      */     //   1246: aload #5
/*      */     //   1248: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*      */     //   1253: aload_0
/*      */     //   1254: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   1257: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1260: checkcast java/lang/Boolean
/*      */     //   1263: invokevirtual booleanValue : ()Z
/*      */     //   1266: ifeq -> 1361
/*      */     //   1269: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1272: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1275: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1280: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1285: ifne -> 1313
/*      */     //   1288: invokestatic currentTimeMillis : ()J
/*      */     //   1291: aload_0
/*      */     //   1292: getfield containerOpen : J
/*      */     //   1295: lsub
/*      */     //   1296: aload_0
/*      */     //   1297: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   1300: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1303: checkcast java/lang/Number
/*      */     //   1306: invokevirtual longValue : ()J
/*      */     //   1309: lcmp
/*      */     //   1310: ifge -> 1361
/*      */     //   1313: aload_0
/*      */     //   1314: aconst_null
/*      */     //   1315: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1318: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1321: aload_0
/*      */     //   1322: aconst_null
/*      */     //   1323: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   1326: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1329: aload_0
/*      */     //   1330: iconst_0
/*      */     //   1331: putfield hitable : Z
/*      */     //   1334: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   1337: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1340: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   1345: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   1350: ifeq -> 1360
/*      */     //   1353: aload_0
/*      */     //   1354: invokestatic currentTimeMillis : ()J
/*      */     //   1357: putfield containerOpen : J
/*      */     //   1360: return
/*      */     //   1361: aload_0
/*      */     //   1362: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1365: ifnull -> 1439
/*      */     //   1368: aload_0
/*      */     //   1369: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1372: ifnull -> 1439
/*      */     //   1375: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1378: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1383: dup
/*      */     //   1384: ifnonnull -> 1390
/*      */     //   1387: invokestatic throwNpe : ()V
/*      */     //   1390: fconst_0
/*      */     //   1391: invokeinterface getCooledAttackStrength : (F)F
/*      */     //   1396: aload_0
/*      */     //   1397: getfield cooldownValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   1400: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   1403: checkcast java/lang/Number
/*      */     //   1406: invokevirtual floatValue : ()F
/*      */     //   1409: fcmpl
/*      */     //   1410: iflt -> 1439
/*      */     //   1413: aload_0
/*      */     //   1414: getfield clicks : I
/*      */     //   1417: ifle -> 1439
/*      */     //   1420: aload_0
/*      */     //   1421: invokespecial runAttack : ()V
/*      */     //   1424: aload_0
/*      */     //   1425: dup
/*      */     //   1426: getfield clicks : I
/*      */     //   1429: dup
/*      */     //   1430: istore_2
/*      */     //   1431: iconst_m1
/*      */     //   1432: iadd
/*      */     //   1433: putfield clicks : I
/*      */     //   1436: goto -> 1413
/*      */     //   1439: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #415	-> 7
/*      */     //   #416	-> 23
/*      */     //   #417	-> 53
/*      */     //   #419	-> 87
/*      */     //   #420	-> 118
/*      */     //   #423	-> 118
/*      */     //   #424	-> 134
/*      */     //   #425	-> 151
/*      */     //   #427	-> 185
/*      */     //   #428	-> 216
/*      */     //   #431	-> 216
/*      */     //   #432	-> 232
/*      */     //   #455	-> 304
/*      */     //   #433	-> 317
/*      */     //   #434	-> 327
/*      */     //   #435	-> 334
/*      */     //   #436	-> 342
/*      */     //   #438	-> 349
/*      */     //   #439	-> 371
/*      */     //   #440	-> 396
/*      */     //   #439	-> 445
/*      */     //   #441	-> 459
/*      */     //   #443	-> 494
/*      */     //   #435	-> 498
/*      */     //   #446	-> 504
/*      */     //   #447	-> 533
/*      */     //   #448	-> 558
/*      */     //   #447	-> 607
/*      */     //   #449	-> 621
/*      */     //   #450	-> 656
/*      */     //   #452	-> 664
/*      */     //   #456	-> 667
/*      */     //   #457	-> 692
/*      */     //   #456	-> 741
/*      */     //   #458	-> 755
/*      */     //   #460	-> 790
/*      */     //   #463	-> 790
/*      */     //   #464	-> 816
/*      */     //   #465	-> 828
/*      */     //   #468	-> 836
/*      */     //   #1616	-> 840
/*      */     //   #1617	-> 840
/*      */     //   #1616	-> 864
/*      */     //   #1617	-> 888
/*      */     //   #469	-> 932
/*      */     //   #470	-> 940
/*      */     //   #471	-> 948
/*      */     //   #472	-> 953
/*      */     //   #473	-> 957
/*      */     //   #475	-> 958
/*      */     //   #476	-> 977
/*      */     //   #477	-> 1038
/*      */     //   #478	-> 1051
/*      */     //   #479	-> 1083
/*      */     //   #480	-> 1113
/*      */     //   #481	-> 1145
/*      */     //   #482	-> 1165
/*      */     //   #483	-> 1165
/*      */     //   #482	-> 1169
/*      */     //   #1618	-> 1173
/*      */     //   #1619	-> 1173
/*      */     //   #481	-> 1194
/*      */     //   #486	-> 1199
/*      */     //   #487	-> 1219
/*      */     //   #488	-> 1219
/*      */     //   #487	-> 1223
/*      */     //   #1620	-> 1227
/*      */     //   #1621	-> 1227
/*      */     //   #486	-> 1248
/*      */     //   #491	-> 1253
/*      */     //   #495	-> 1253
/*      */     //   #496	-> 1253
/*      */     //   #495	-> 1253
/*      */     //   #496	-> 1288
/*      */     //   #497	-> 1313
/*      */     //   #498	-> 1321
/*      */     //   #499	-> 1329
/*      */     //   #500	-> 1334
/*      */     //   #501	-> 1360
/*      */     //   #505	-> 1361
/*      */     //   #506	-> 1413
/*      */     //   #507	-> 1420
/*      */     //   #508	-> 1424
/*      */     //   #506	-> 1436
/*      */     //   #511	-> 1439
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   838	91	2	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */     //   840	89	3	$i$f$getCancelRun	I
/*      */     //   1171	17	2	hand$iv	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*      */     //   1173	15	3	$i$f$createUseItemPacket	I
/*      */     //   1225	17	2	hand$iv	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*      */     //   1227	15	3	$i$f$createUseItemPacket	I
/*      */     //   0	1440	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */     //   0	1440	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent; } private final void esp(IEntityLivingBase entity, float partialTicks, float radius) { GL11.glPushMatrix(); GL11.glDisable(3553); GLUtils.startSmooth(); GL11.glDisable(2929); GL11.glDepthMask(false); GL11.glLineWidth(1.0F); GL11.glBegin(3); double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * partialTicks - MinecraftInstance.mc.getRenderManager().getViewerPosX(); double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * partialTicks - MinecraftInstance.mc.getRenderManager().getViewerPosY(); double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * partialTicks - MinecraftInstance.mc.getRenderManager().getViewerPosZ(); byte b; char c; for (b = 0, c = 'Ũ'; b <= c; b++) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = b / 50.0D * 1.75D, d3 = MinecraftInstance.mc.getThePlayer().getTicksExisted() / 70.0D; boolean bool = false; double d4 = Math.sin(d1); int i = Color.HSBtoRGB((float)(d3 + d4) % 1.0F, 0.7F, 1.0F); Color rainbow = new Color(i); GL11.glColor3f(rainbow.getRed() / 255.0F, rainbow.getGreen() / 255.0F, rainbow.getBlue() / 255.0F); d1 = b * 6.283185307179586D / 45.0D; d3 = radius; double d2 = x; bool = false; d4 = Math.cos(d1); d1 = b * 6.283185307179586D / 45.0D; double d5 = radius; d4 = z; d3 = y + this.espAnimation; d2 += d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6); }  GL11.glEnd(); GL11.glDepthMask(true); GL11.glEnable(2929); GLUtils.endSmooth(); GL11.glEnable(3553); GL11.glPopMatrix(); } private final void drawESP(IEntityLivingBase entity, int color, Render3DEvent e) { double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * e.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX(); double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * e.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY(); double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * e.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ(); float radius = 0.15F; int side = 4; GL11.glPushMatrix(); GL11.glTranslated(x, y + 2, z); GL11.glRotatef(-entity.getWidth(), 0.0F, 1.0F, 0.0F); RenderUtils.glColor1(color); RenderUtils.enableSmoothLine(1.5F); Cylinder c = new Cylinder(); GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F); c.setDrawStyle(100012); RenderUtils.glColor(new Color(80, 255, 80, 200)); c.draw(0.0F, radius, 0.3F, side, 1); c.setDrawStyle(100012); GL11.glTranslated(0.0D, 0.0D, 0.3D); c.draw(radius, 0.0F, 0.3F, side, 1); GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F); c.setDrawStyle(100011); GL11.glTranslated(0.0D, 0.0D, -0.3D); RenderUtils.glColor1(color); c.draw(0.0F, radius, 0.3F, side, 1); c.setDrawStyle(100011); GL11.glTranslated(0.0D, 0.0D, 0.3D); c.draw(radius, 0.0F, 0.3F, side, 1); RenderUtils.disableSmoothLine(); GL11.glPopMatrix(); } @EventTarget public final void onRender3D(@NotNull Render3DEvent event) { // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ldc_w 'event'
/*      */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   7: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$1.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$1;
/*      */     //   10: astore_2
/*      */     //   11: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$2.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$2;
/*      */     //   14: astore_3
/*      */     //   15: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$3.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$3;
/*      */     //   18: astore #4
/*      */     //   20: new net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$4
/*      */     //   23: dup
/*      */     //   24: aload_0
/*      */     //   25: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;)V
/*      */     //   28: astore #5
/*      */     //   30: aload_0
/*      */     //   31: getfield circleValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   34: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   37: checkcast java/lang/Boolean
/*      */     //   40: invokevirtual booleanValue : ()Z
/*      */     //   43: ifeq -> 719
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
/*      */     //   362: aload_0
/*      */     //   363: getfield circleRed : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   366: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   369: checkcast java/lang/Number
/*      */     //   372: invokevirtual intValue : ()I
/*      */     //   375: i2f
/*      */     //   376: ldc_w 255.0
/*      */     //   379: fdiv
/*      */     //   380: aload_0
/*      */     //   381: getfield circleGreen : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   384: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   387: checkcast java/lang/Number
/*      */     //   390: invokevirtual intValue : ()I
/*      */     //   393: i2f
/*      */     //   394: ldc_w 255.0
/*      */     //   397: fdiv
/*      */     //   398: aload_0
/*      */     //   399: getfield circleBlue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   402: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   405: checkcast java/lang/Number
/*      */     //   408: invokevirtual intValue : ()I
/*      */     //   411: i2f
/*      */     //   412: ldc_w 255.0
/*      */     //   415: fdiv
/*      */     //   416: aload_0
/*      */     //   417: getfield circleAlpha : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   420: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   423: checkcast java/lang/Number
/*      */     //   426: invokevirtual intValue : ()I
/*      */     //   429: i2f
/*      */     //   430: ldc_w 255.0
/*      */     //   433: fdiv
/*      */     //   434: invokestatic glColor4f : (FFFF)V
/*      */     //   437: ldc_w 90.0
/*      */     //   440: fconst_1
/*      */     //   441: fconst_0
/*      */     //   442: fconst_0
/*      */     //   443: invokestatic glRotatef : (FFFF)V
/*      */     //   446: iconst_3
/*      */     //   447: invokestatic glBegin : (I)V
/*      */     //   450: iconst_0
/*      */     //   451: istore #9
/*      */     //   453: new kotlin/ranges/IntRange
/*      */     //   456: dup
/*      */     //   457: iload #9
/*      */     //   459: sipush #360
/*      */     //   462: invokespecial <init> : (II)V
/*      */     //   465: checkcast kotlin/ranges/IntProgression
/*      */     //   468: bipush #61
/*      */     //   470: aload_0
/*      */     //   471: getfield circleAccuracy : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   474: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   477: checkcast java/lang/Number
/*      */     //   480: invokevirtual intValue : ()I
/*      */     //   483: isub
/*      */     //   484: invokestatic step : (Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;
/*      */     //   487: dup
/*      */     //   488: dup
/*      */     //   489: invokevirtual getFirst : ()I
/*      */     //   492: istore #6
/*      */     //   494: invokevirtual getLast : ()I
/*      */     //   497: istore #7
/*      */     //   499: invokevirtual getStep : ()I
/*      */     //   502: istore #8
/*      */     //   504: iload #6
/*      */     //   506: iload #7
/*      */     //   508: iload #8
/*      */     //   510: iflt -> 519
/*      */     //   513: if_icmpgt -> 622
/*      */     //   516: goto -> 522
/*      */     //   519: if_icmplt -> 622
/*      */     //   522: iload #6
/*      */     //   524: i2d
/*      */     //   525: ldc2_w 3.141592653589793
/*      */     //   528: dmul
/*      */     //   529: ldc2_w 180.0
/*      */     //   532: ddiv
/*      */     //   533: dstore #9
/*      */     //   535: iconst_0
/*      */     //   536: istore #11
/*      */     //   538: dload #9
/*      */     //   540: invokestatic cos : (D)D
/*      */     //   543: d2f
/*      */     //   544: aload_0
/*      */     //   545: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   548: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   551: checkcast java/lang/Number
/*      */     //   554: invokevirtual floatValue : ()F
/*      */     //   557: fmul
/*      */     //   558: iload #6
/*      */     //   560: i2d
/*      */     //   561: ldc2_w 3.141592653589793
/*      */     //   564: dmul
/*      */     //   565: ldc2_w 180.0
/*      */     //   568: ddiv
/*      */     //   569: dstore #9
/*      */     //   571: fstore #34
/*      */     //   573: iconst_0
/*      */     //   574: istore #11
/*      */     //   576: dload #9
/*      */     //   578: invokestatic sin : (D)D
/*      */     //   581: dstore #35
/*      */     //   583: fload #34
/*      */     //   585: dload #35
/*      */     //   587: d2f
/*      */     //   588: aload_0
/*      */     //   589: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   592: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   595: checkcast java/lang/Number
/*      */     //   598: invokevirtual floatValue : ()F
/*      */     //   601: fmul
/*      */     //   602: invokestatic glVertex2f : (FF)V
/*      */     //   605: iload #6
/*      */     //   607: iload #7
/*      */     //   609: if_icmpeq -> 622
/*      */     //   612: iload #6
/*      */     //   614: iload #8
/*      */     //   616: iadd
/*      */     //   617: istore #6
/*      */     //   619: goto -> 522
/*      */     //   622: ldc2_w 6.283185307179586
/*      */     //   625: dstore #6
/*      */     //   627: iconst_0
/*      */     //   628: istore #8
/*      */     //   630: dload #6
/*      */     //   632: invokestatic cos : (D)D
/*      */     //   635: d2f
/*      */     //   636: aload_0
/*      */     //   637: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   640: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   643: checkcast java/lang/Number
/*      */     //   646: invokevirtual floatValue : ()F
/*      */     //   649: fmul
/*      */     //   650: ldc2_w 6.283185307179586
/*      */     //   653: dstore #6
/*      */     //   655: fstore #34
/*      */     //   657: iconst_0
/*      */     //   658: istore #8
/*      */     //   660: dload #6
/*      */     //   662: invokestatic sin : (D)D
/*      */     //   665: dstore #35
/*      */     //   667: fload #34
/*      */     //   669: dload #35
/*      */     //   671: d2f
/*      */     //   672: aload_0
/*      */     //   673: getfield rangeValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   676: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   679: checkcast java/lang/Number
/*      */     //   682: invokevirtual floatValue : ()F
/*      */     //   685: fmul
/*      */     //   686: invokestatic glVertex2f : (FF)V
/*      */     //   689: invokestatic glEnd : ()V
/*      */     //   692: sipush #3042
/*      */     //   695: invokestatic glDisable : (I)V
/*      */     //   698: sipush #3553
/*      */     //   701: invokestatic glEnable : (I)V
/*      */     //   704: sipush #2929
/*      */     //   707: invokestatic glEnable : (I)V
/*      */     //   710: sipush #2848
/*      */     //   713: invokestatic glDisable : (I)V
/*      */     //   716: invokestatic glPopMatrix : ()V
/*      */     //   719: aload_0
/*      */     //   720: astore #6
/*      */     //   722: iconst_0
/*      */     //   723: istore #7
/*      */     //   725: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   728: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   733: dup
/*      */     //   734: ifnonnull -> 740
/*      */     //   737: invokestatic throwNpe : ()V
/*      */     //   740: invokeinterface isSpectator : ()Z
/*      */     //   745: ifne -> 810
/*      */     //   748: aload #6
/*      */     //   750: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   753: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   758: dup
/*      */     //   759: ifnonnull -> 765
/*      */     //   762: invokestatic throwNpe : ()V
/*      */     //   765: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   768: invokestatic access$isAlive : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*      */     //   771: ifeq -> 810
/*      */     //   774: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   777: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   780: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/Blink
/*      */     //   783: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   786: invokevirtual getState : ()Z
/*      */     //   789: ifne -> 810
/*      */     //   792: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*      */     //   795: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*      */     //   798: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/FreeCam
/*      */     //   801: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*      */     //   804: invokevirtual getState : ()Z
/*      */     //   807: ifeq -> 814
/*      */     //   810: iconst_1
/*      */     //   811: goto -> 815
/*      */     //   814: iconst_0
/*      */     //   815: ifeq -> 844
/*      */     //   818: aload_0
/*      */     //   819: aconst_null
/*      */     //   820: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   823: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   826: aload_0
/*      */     //   827: aconst_null
/*      */     //   828: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   831: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   834: aload_0
/*      */     //   835: iconst_0
/*      */     //   836: putfield hitable : Z
/*      */     //   839: aload_0
/*      */     //   840: invokespecial stopBlocking : ()V
/*      */     //   843: return
/*      */     //   844: aload_0
/*      */     //   845: getfield noInventoryAttackValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */     //   848: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   851: checkcast java/lang/Boolean
/*      */     //   854: invokevirtual booleanValue : ()Z
/*      */     //   857: ifeq -> 952
/*      */     //   860: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   863: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   866: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   871: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   876: ifne -> 904
/*      */     //   879: invokestatic currentTimeMillis : ()J
/*      */     //   882: aload_0
/*      */     //   883: getfield containerOpen : J
/*      */     //   886: lsub
/*      */     //   887: aload_0
/*      */     //   888: getfield noInventoryDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   891: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   894: checkcast java/lang/Number
/*      */     //   897: invokevirtual longValue : ()J
/*      */     //   900: lcmp
/*      */     //   901: ifge -> 952
/*      */     //   904: aload_0
/*      */     //   905: aconst_null
/*      */     //   906: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   909: putfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   912: aload_0
/*      */     //   913: aconst_null
/*      */     //   914: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   917: putfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   920: aload_0
/*      */     //   921: iconst_0
/*      */     //   922: putfield hitable : Z
/*      */     //   925: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*      */     //   928: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   931: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*      */     //   936: invokeinterface isGuiContainer : (Ljava/lang/Object;)Z
/*      */     //   941: ifeq -> 951
/*      */     //   944: aload_0
/*      */     //   945: invokestatic currentTimeMillis : ()J
/*      */     //   948: putfield containerOpen : J
/*      */     //   951: return
/*      */     //   952: aload_0
/*      */     //   953: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   956: dup
/*      */     //   957: ifnull -> 963
/*      */     //   960: goto -> 965
/*      */     //   963: pop
/*      */     //   964: return
/*      */     //   965: pop
/*      */     //   966: aload_0
/*      */     //   967: getfield markValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*      */     //   970: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   973: checkcast java/lang/String
/*      */     //   976: astore #6
/*      */     //   978: iconst_0
/*      */     //   979: istore #7
/*      */     //   981: aload #6
/*      */     //   983: dup
/*      */     //   984: ifnonnull -> 998
/*      */     //   987: new kotlin/TypeCastException
/*      */     //   990: dup
/*      */     //   991: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*      */     //   994: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   997: athrow
/*      */     //   998: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   1001: dup
/*      */     //   1002: ldc_w '(this as java.lang.String).toLowerCase()'
/*      */     //   1005: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*      */     //   1008: astore #6
/*      */     //   1010: aload #6
/*      */     //   1012: invokevirtual hashCode : ()I
/*      */     //   1015: lookupswitch default -> 3528, -1102567108 -> 1122, 101234 -> 1108, 112785 -> 1080, 3443503 -> 1164, 3530364 -> 1136, 93832333 -> 1150, 101009364 -> 1094
/*      */     //   1080: aload #6
/*      */     //   1082: ldc_w 'red'
/*      */     //   1085: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1088: ifeq -> 3528
/*      */     //   1091: goto -> 1429
/*      */     //   1094: aload #6
/*      */     //   1096: ldc_w 'jello'
/*      */     //   1099: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1102: ifeq -> 3528
/*      */     //   1105: goto -> 2707
/*      */     //   1108: aload #6
/*      */     //   1110: ldc_w 'fdp'
/*      */     //   1113: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1116: ifeq -> 3528
/*      */     //   1119: goto -> 2002
/*      */     //   1122: aload #6
/*      */     //   1124: ldc_w 'liquid'
/*      */     //   1127: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1130: ifeq -> 3528
/*      */     //   1133: goto -> 1178
/*      */     //   1136: aload #6
/*      */     //   1138: ldc_w 'sims'
/*      */     //   1141: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1144: ifeq -> 3528
/*      */     //   1147: goto -> 1508
/*      */     //   1150: aload #6
/*      */     //   1152: ldc_w 'block'
/*      */     //   1155: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1158: ifeq -> 3528
/*      */     //   1161: goto -> 1312
/*      */     //   1164: aload #6
/*      */     //   1166: ldc_w 'plat'
/*      */     //   1169: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   1172: ifeq -> 3528
/*      */     //   1175: goto -> 1252
/*      */     //   1178: aload_0
/*      */     //   1179: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1182: dup
/*      */     //   1183: ifnonnull -> 1189
/*      */     //   1186: invokestatic throwNpe : ()V
/*      */     //   1189: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1192: aload_0
/*      */     //   1193: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1196: dup
/*      */     //   1197: ifnonnull -> 1203
/*      */     //   1200: invokestatic throwNpe : ()V
/*      */     //   1203: invokeinterface getHurtTime : ()I
/*      */     //   1208: ifgt -> 1231
/*      */     //   1211: new java/awt/Color
/*      */     //   1214: dup
/*      */     //   1215: bipush #37
/*      */     //   1217: bipush #126
/*      */     //   1219: sipush #255
/*      */     //   1222: sipush #170
/*      */     //   1225: invokespecial <init> : (IIII)V
/*      */     //   1228: goto -> 1246
/*      */     //   1231: new java/awt/Color
/*      */     //   1234: dup
/*      */     //   1235: sipush #255
/*      */     //   1238: iconst_0
/*      */     //   1239: iconst_0
/*      */     //   1240: sipush #170
/*      */     //   1243: invokespecial <init> : (IIII)V
/*      */     //   1246: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1249: goto -> 3528
/*      */     //   1252: aload_0
/*      */     //   1253: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1256: dup
/*      */     //   1257: ifnonnull -> 1263
/*      */     //   1260: invokestatic throwNpe : ()V
/*      */     //   1263: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1266: aload_0
/*      */     //   1267: getfield hitable : Z
/*      */     //   1270: ifeq -> 1292
/*      */     //   1273: new java/awt/Color
/*      */     //   1276: dup
/*      */     //   1277: bipush #37
/*      */     //   1279: bipush #126
/*      */     //   1281: sipush #255
/*      */     //   1284: bipush #70
/*      */     //   1286: invokespecial <init> : (IIII)V
/*      */     //   1289: goto -> 1306
/*      */     //   1292: new java/awt/Color
/*      */     //   1295: dup
/*      */     //   1296: sipush #255
/*      */     //   1299: iconst_0
/*      */     //   1300: iconst_0
/*      */     //   1301: bipush #70
/*      */     //   1303: invokespecial <init> : (IIII)V
/*      */     //   1306: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1309: goto -> 3528
/*      */     //   1312: aload_0
/*      */     //   1313: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1316: dup
/*      */     //   1317: ifnonnull -> 1323
/*      */     //   1320: invokestatic throwNpe : ()V
/*      */     //   1323: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1328: astore #7
/*      */     //   1330: aload_0
/*      */     //   1331: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1334: dup
/*      */     //   1335: ifnonnull -> 1341
/*      */     //   1338: invokestatic throwNpe : ()V
/*      */     //   1341: aload #7
/*      */     //   1343: ldc2_w 0.2
/*      */     //   1346: ldc2_w 0.2
/*      */     //   1349: ldc2_w 0.2
/*      */     //   1352: invokeinterface expand : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1357: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   1362: aload_0
/*      */     //   1363: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1366: dup
/*      */     //   1367: ifnonnull -> 1373
/*      */     //   1370: invokestatic throwNpe : ()V
/*      */     //   1373: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1376: aload_0
/*      */     //   1377: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1380: dup
/*      */     //   1381: ifnonnull -> 1387
/*      */     //   1384: invokestatic throwNpe : ()V
/*      */     //   1387: invokeinterface getHurtTime : ()I
/*      */     //   1392: ifgt -> 1401
/*      */     //   1395: getstatic java/awt/Color.GREEN : Ljava/awt/Color;
/*      */     //   1398: goto -> 1404
/*      */     //   1401: getstatic java/awt/Color.RED : Ljava/awt/Color;
/*      */     //   1404: iconst_1
/*      */     //   1405: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*      */     //   1408: aload_0
/*      */     //   1409: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1412: dup
/*      */     //   1413: ifnonnull -> 1419
/*      */     //   1416: invokestatic throwNpe : ()V
/*      */     //   1419: aload #7
/*      */     //   1421: invokeinterface setEntityBoundingBox : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;)V
/*      */     //   1426: goto -> 3528
/*      */     //   1429: aload_0
/*      */     //   1430: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1433: dup
/*      */     //   1434: ifnonnull -> 1440
/*      */     //   1437: invokestatic throwNpe : ()V
/*      */     //   1440: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*      */     //   1443: aload_0
/*      */     //   1444: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1447: dup
/*      */     //   1448: ifnonnull -> 1454
/*      */     //   1451: invokestatic throwNpe : ()V
/*      */     //   1454: invokeinterface getHurtTime : ()I
/*      */     //   1459: ifgt -> 1484
/*      */     //   1462: new java/awt/Color
/*      */     //   1465: dup
/*      */     //   1466: sipush #255
/*      */     //   1469: sipush #255
/*      */     //   1472: sipush #255
/*      */     //   1475: sipush #255
/*      */     //   1478: invokespecial <init> : (IIII)V
/*      */     //   1481: goto -> 1502
/*      */     //   1484: new java/awt/Color
/*      */     //   1487: dup
/*      */     //   1488: bipush #124
/*      */     //   1490: sipush #215
/*      */     //   1493: sipush #255
/*      */     //   1496: sipush #255
/*      */     //   1499: invokespecial <init> : (IIII)V
/*      */     //   1502: invokestatic drawPlatform : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;)V
/*      */     //   1505: goto -> 3528
/*      */     //   1508: ldc_w 0.15
/*      */     //   1511: fstore #7
/*      */     //   1513: iconst_4
/*      */     //   1514: istore #8
/*      */     //   1516: invokestatic glPushMatrix : ()V
/*      */     //   1519: aload_0
/*      */     //   1520: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1523: dup
/*      */     //   1524: ifnonnull -> 1530
/*      */     //   1527: invokestatic throwNpe : ()V
/*      */     //   1530: invokeinterface getLastTickPosX : ()D
/*      */     //   1535: aload_0
/*      */     //   1536: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1539: dup
/*      */     //   1540: ifnonnull -> 1546
/*      */     //   1543: invokestatic throwNpe : ()V
/*      */     //   1546: invokeinterface getPosX : ()D
/*      */     //   1551: aload_0
/*      */     //   1552: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1555: dup
/*      */     //   1556: ifnonnull -> 1562
/*      */     //   1559: invokestatic throwNpe : ()V
/*      */     //   1562: invokeinterface getLastTickPosX : ()D
/*      */     //   1567: dsub
/*      */     //   1568: aload_1
/*      */     //   1569: invokevirtual getPartialTicks : ()F
/*      */     //   1572: f2d
/*      */     //   1573: dmul
/*      */     //   1574: dadd
/*      */     //   1575: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1578: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1583: invokeinterface getViewerPosX : ()D
/*      */     //   1588: dsub
/*      */     //   1589: aload_0
/*      */     //   1590: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1593: dup
/*      */     //   1594: ifnonnull -> 1600
/*      */     //   1597: invokestatic throwNpe : ()V
/*      */     //   1600: invokeinterface getLastTickPosY : ()D
/*      */     //   1605: aload_0
/*      */     //   1606: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1609: dup
/*      */     //   1610: ifnonnull -> 1616
/*      */     //   1613: invokestatic throwNpe : ()V
/*      */     //   1616: invokeinterface getPosY : ()D
/*      */     //   1621: aload_0
/*      */     //   1622: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1625: dup
/*      */     //   1626: ifnonnull -> 1632
/*      */     //   1629: invokestatic throwNpe : ()V
/*      */     //   1632: invokeinterface getLastTickPosY : ()D
/*      */     //   1637: dsub
/*      */     //   1638: aload_1
/*      */     //   1639: invokevirtual getPartialTicks : ()F
/*      */     //   1642: f2d
/*      */     //   1643: dmul
/*      */     //   1644: dadd
/*      */     //   1645: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1648: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1653: invokeinterface getViewerPosY : ()D
/*      */     //   1658: dsub
/*      */     //   1659: aload_0
/*      */     //   1660: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1663: dup
/*      */     //   1664: ifnonnull -> 1670
/*      */     //   1667: invokestatic throwNpe : ()V
/*      */     //   1670: invokeinterface getHeight : ()F
/*      */     //   1675: f2d
/*      */     //   1676: ldc2_w 1.1
/*      */     //   1679: dmul
/*      */     //   1680: dadd
/*      */     //   1681: aload_0
/*      */     //   1682: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1685: dup
/*      */     //   1686: ifnonnull -> 1692
/*      */     //   1689: invokestatic throwNpe : ()V
/*      */     //   1692: invokeinterface getLastTickPosZ : ()D
/*      */     //   1697: aload_0
/*      */     //   1698: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1701: dup
/*      */     //   1702: ifnonnull -> 1708
/*      */     //   1705: invokestatic throwNpe : ()V
/*      */     //   1708: invokeinterface getPosZ : ()D
/*      */     //   1713: aload_0
/*      */     //   1714: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1717: dup
/*      */     //   1718: ifnonnull -> 1724
/*      */     //   1721: invokestatic throwNpe : ()V
/*      */     //   1724: invokeinterface getLastTickPosZ : ()D
/*      */     //   1729: dsub
/*      */     //   1730: aload_1
/*      */     //   1731: invokevirtual getPartialTicks : ()F
/*      */     //   1734: f2d
/*      */     //   1735: dmul
/*      */     //   1736: dadd
/*      */     //   1737: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1740: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   1745: invokeinterface getViewerPosZ : ()D
/*      */     //   1750: dsub
/*      */     //   1751: invokestatic glTranslated : (DDD)V
/*      */     //   1754: aload_0
/*      */     //   1755: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1758: dup
/*      */     //   1759: ifnonnull -> 1765
/*      */     //   1762: invokestatic throwNpe : ()V
/*      */     //   1765: invokeinterface getWidth : ()F
/*      */     //   1770: fneg
/*      */     //   1771: fconst_0
/*      */     //   1772: fconst_1
/*      */     //   1773: fconst_0
/*      */     //   1774: invokestatic glRotatef : (FFFF)V
/*      */     //   1777: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1780: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   1785: dup
/*      */     //   1786: ifnonnull -> 1792
/*      */     //   1789: invokestatic throwNpe : ()V
/*      */     //   1792: invokeinterface getTicksExisted : ()I
/*      */     //   1797: i2f
/*      */     //   1798: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   1801: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   1806: invokeinterface getRenderPartialTicks : ()F
/*      */     //   1811: fadd
/*      */     //   1812: iconst_5
/*      */     //   1813: i2f
/*      */     //   1814: fmul
/*      */     //   1815: fconst_0
/*      */     //   1816: fconst_1
/*      */     //   1817: fconst_0
/*      */     //   1818: invokestatic glRotatef : (FFFF)V
/*      */     //   1821: aload_0
/*      */     //   1822: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   1825: dup
/*      */     //   1826: ifnonnull -> 1832
/*      */     //   1829: invokestatic throwNpe : ()V
/*      */     //   1832: invokeinterface getHurtTime : ()I
/*      */     //   1837: ifgt -> 1857
/*      */     //   1840: new java/awt/Color
/*      */     //   1843: dup
/*      */     //   1844: bipush #80
/*      */     //   1846: sipush #255
/*      */     //   1849: bipush #80
/*      */     //   1851: invokespecial <init> : (III)V
/*      */     //   1854: goto -> 1869
/*      */     //   1857: new java/awt/Color
/*      */     //   1860: dup
/*      */     //   1861: sipush #255
/*      */     //   1864: iconst_0
/*      */     //   1865: iconst_0
/*      */     //   1866: invokespecial <init> : (III)V
/*      */     //   1869: invokestatic glColor : (Ljava/awt/Color;)V
/*      */     //   1872: ldc_w 1.5
/*      */     //   1875: invokestatic enableSmoothLine : (F)V
/*      */     //   1878: new org/lwjgl/util/glu/Cylinder
/*      */     //   1881: dup
/*      */     //   1882: invokespecial <init> : ()V
/*      */     //   1885: astore #9
/*      */     //   1887: ldc_w -90.0
/*      */     //   1890: fconst_1
/*      */     //   1891: fconst_0
/*      */     //   1892: fconst_0
/*      */     //   1893: invokestatic glRotatef : (FFFF)V
/*      */     //   1896: aload #9
/*      */     //   1898: fconst_0
/*      */     //   1899: fload #7
/*      */     //   1901: ldc_w 0.3
/*      */     //   1904: iload #8
/*      */     //   1906: iconst_1
/*      */     //   1907: invokevirtual draw : (FFFII)V
/*      */     //   1910: aload #9
/*      */     //   1912: ldc_w 100012
/*      */     //   1915: invokevirtual setDrawStyle : (I)V
/*      */     //   1918: dconst_0
/*      */     //   1919: dconst_0
/*      */     //   1920: ldc2_w 0.3
/*      */     //   1923: invokestatic glTranslated : (DDD)V
/*      */     //   1926: aload #9
/*      */     //   1928: fload #7
/*      */     //   1930: fconst_0
/*      */     //   1931: ldc_w 0.3
/*      */     //   1934: iload #8
/*      */     //   1936: iconst_1
/*      */     //   1937: invokevirtual draw : (FFFII)V
/*      */     //   1940: ldc_w 90.0
/*      */     //   1943: fconst_0
/*      */     //   1944: fconst_0
/*      */     //   1945: fconst_1
/*      */     //   1946: invokestatic glRotatef : (FFFF)V
/*      */     //   1949: dconst_0
/*      */     //   1950: dconst_0
/*      */     //   1951: ldc2_w -0.3
/*      */     //   1954: invokestatic glTranslated : (DDD)V
/*      */     //   1957: aload #9
/*      */     //   1959: fconst_0
/*      */     //   1960: fload #7
/*      */     //   1962: ldc_w 0.3
/*      */     //   1965: iload #8
/*      */     //   1967: iconst_1
/*      */     //   1968: invokevirtual draw : (FFFII)V
/*      */     //   1971: dconst_0
/*      */     //   1972: dconst_0
/*      */     //   1973: ldc2_w 0.3
/*      */     //   1976: invokestatic glTranslated : (DDD)V
/*      */     //   1979: aload #9
/*      */     //   1981: fload #7
/*      */     //   1983: fconst_0
/*      */     //   1984: ldc_w 0.3
/*      */     //   1987: iload #8
/*      */     //   1989: iconst_1
/*      */     //   1990: invokevirtual draw : (FFFII)V
/*      */     //   1993: invokestatic disableSmoothLine : ()V
/*      */     //   1996: invokestatic glPopMatrix : ()V
/*      */     //   1999: goto -> 3528
/*      */     //   2002: invokestatic currentTimeMillis : ()J
/*      */     //   2005: sipush #1500
/*      */     //   2008: i2l
/*      */     //   2009: lrem
/*      */     //   2010: l2i
/*      */     //   2011: istore #7
/*      */     //   2013: iload #7
/*      */     //   2015: sipush #750
/*      */     //   2018: if_icmple -> 2025
/*      */     //   2021: iconst_1
/*      */     //   2022: goto -> 2026
/*      */     //   2025: iconst_0
/*      */     //   2026: istore #8
/*      */     //   2028: iload #7
/*      */     //   2030: i2d
/*      */     //   2031: ldc2_w 750.0
/*      */     //   2034: ddiv
/*      */     //   2035: dstore #9
/*      */     //   2037: iload #8
/*      */     //   2039: ifne -> 2052
/*      */     //   2042: iconst_1
/*      */     //   2043: i2d
/*      */     //   2044: dload #9
/*      */     //   2046: dsub
/*      */     //   2047: dstore #9
/*      */     //   2049: goto -> 2059
/*      */     //   2052: dload #9
/*      */     //   2054: iconst_1
/*      */     //   2055: i2d
/*      */     //   2056: dsub
/*      */     //   2057: dstore #9
/*      */     //   2059: getstatic net/ccbluex/liquidbounce/utils/render/EaseUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/EaseUtils;
/*      */     //   2062: dload #9
/*      */     //   2064: invokevirtual easeInOutQuad : (D)D
/*      */     //   2067: dstore #9
/*      */     //   2069: invokestatic glPushMatrix : ()V
/*      */     //   2072: sipush #3553
/*      */     //   2075: invokestatic glDisable : (I)V
/*      */     //   2078: sipush #2848
/*      */     //   2081: invokestatic glEnable : (I)V
/*      */     //   2084: sipush #2881
/*      */     //   2087: invokestatic glEnable : (I)V
/*      */     //   2090: sipush #2832
/*      */     //   2093: invokestatic glEnable : (I)V
/*      */     //   2096: sipush #3042
/*      */     //   2099: invokestatic glEnable : (I)V
/*      */     //   2102: sipush #770
/*      */     //   2105: sipush #771
/*      */     //   2108: invokestatic glBlendFunc : (II)V
/*      */     //   2111: sipush #3154
/*      */     //   2114: sipush #4354
/*      */     //   2117: invokestatic glHint : (II)V
/*      */     //   2120: sipush #3155
/*      */     //   2123: sipush #4354
/*      */     //   2126: invokestatic glHint : (II)V
/*      */     //   2129: sipush #3153
/*      */     //   2132: sipush #4354
/*      */     //   2135: invokestatic glHint : (II)V
/*      */     //   2138: sipush #2929
/*      */     //   2141: invokestatic glDisable : (I)V
/*      */     //   2144: iconst_0
/*      */     //   2145: invokestatic glDepthMask : (Z)V
/*      */     //   2148: aload_0
/*      */     //   2149: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2152: dup
/*      */     //   2153: ifnonnull -> 2159
/*      */     //   2156: invokestatic throwNpe : ()V
/*      */     //   2159: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2164: astore #11
/*      */     //   2166: aload #11
/*      */     //   2168: invokeinterface getMaxX : ()D
/*      */     //   2173: aload #11
/*      */     //   2175: invokeinterface getMinX : ()D
/*      */     //   2180: dsub
/*      */     //   2181: ldc2_w 0.3
/*      */     //   2184: dadd
/*      */     //   2185: dstore #12
/*      */     //   2187: aload #11
/*      */     //   2189: invokeinterface getMaxY : ()D
/*      */     //   2194: aload #11
/*      */     //   2196: invokeinterface getMinY : ()D
/*      */     //   2201: dsub
/*      */     //   2202: dstore #14
/*      */     //   2204: aload_0
/*      */     //   2205: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2208: dup
/*      */     //   2209: ifnonnull -> 2215
/*      */     //   2212: invokestatic throwNpe : ()V
/*      */     //   2215: invokeinterface getLastTickPosX : ()D
/*      */     //   2220: aload_0
/*      */     //   2221: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2224: dup
/*      */     //   2225: ifnonnull -> 2231
/*      */     //   2228: invokestatic throwNpe : ()V
/*      */     //   2231: invokeinterface getPosX : ()D
/*      */     //   2236: aload_0
/*      */     //   2237: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2240: dup
/*      */     //   2241: ifnonnull -> 2247
/*      */     //   2244: invokestatic throwNpe : ()V
/*      */     //   2247: invokeinterface getLastTickPosX : ()D
/*      */     //   2252: dsub
/*      */     //   2253: aload_1
/*      */     //   2254: invokevirtual getPartialTicks : ()F
/*      */     //   2257: f2d
/*      */     //   2258: dmul
/*      */     //   2259: dadd
/*      */     //   2260: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2263: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2268: invokeinterface getViewerPosX : ()D
/*      */     //   2273: dsub
/*      */     //   2274: dstore #16
/*      */     //   2276: aload_0
/*      */     //   2277: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2280: dup
/*      */     //   2281: ifnonnull -> 2287
/*      */     //   2284: invokestatic throwNpe : ()V
/*      */     //   2287: invokeinterface getLastTickPosY : ()D
/*      */     //   2292: aload_0
/*      */     //   2293: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2296: dup
/*      */     //   2297: ifnonnull -> 2303
/*      */     //   2300: invokestatic throwNpe : ()V
/*      */     //   2303: invokeinterface getPosY : ()D
/*      */     //   2308: aload_0
/*      */     //   2309: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2312: dup
/*      */     //   2313: ifnonnull -> 2319
/*      */     //   2316: invokestatic throwNpe : ()V
/*      */     //   2319: invokeinterface getLastTickPosY : ()D
/*      */     //   2324: dsub
/*      */     //   2325: aload_1
/*      */     //   2326: invokevirtual getPartialTicks : ()F
/*      */     //   2329: f2d
/*      */     //   2330: dmul
/*      */     //   2331: dadd
/*      */     //   2332: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2335: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2340: invokeinterface getViewerPosY : ()D
/*      */     //   2345: dsub
/*      */     //   2346: dload #14
/*      */     //   2348: dload #9
/*      */     //   2350: dmul
/*      */     //   2351: dadd
/*      */     //   2352: dstore #18
/*      */     //   2354: aload_0
/*      */     //   2355: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2358: dup
/*      */     //   2359: ifnonnull -> 2365
/*      */     //   2362: invokestatic throwNpe : ()V
/*      */     //   2365: invokeinterface getLastTickPosZ : ()D
/*      */     //   2370: aload_0
/*      */     //   2371: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2374: dup
/*      */     //   2375: ifnonnull -> 2381
/*      */     //   2378: invokestatic throwNpe : ()V
/*      */     //   2381: invokeinterface getPosZ : ()D
/*      */     //   2386: aload_0
/*      */     //   2387: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2390: dup
/*      */     //   2391: ifnonnull -> 2397
/*      */     //   2394: invokestatic throwNpe : ()V
/*      */     //   2397: invokeinterface getLastTickPosZ : ()D
/*      */     //   2402: dsub
/*      */     //   2403: aload_1
/*      */     //   2404: invokevirtual getPartialTicks : ()F
/*      */     //   2407: f2d
/*      */     //   2408: dmul
/*      */     //   2409: dadd
/*      */     //   2410: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2413: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   2418: invokeinterface getViewerPosZ : ()D
/*      */     //   2423: dsub
/*      */     //   2424: dstore #20
/*      */     //   2426: dload #12
/*      */     //   2428: ldc_w 5.0
/*      */     //   2431: f2d
/*      */     //   2432: dmul
/*      */     //   2433: d2f
/*      */     //   2434: invokestatic glLineWidth : (F)V
/*      */     //   2437: iconst_3
/*      */     //   2438: invokestatic glBegin : (I)V
/*      */     //   2441: iconst_0
/*      */     //   2442: istore #22
/*      */     //   2444: sipush #360
/*      */     //   2447: istore #23
/*      */     //   2449: iload #22
/*      */     //   2451: iload #23
/*      */     //   2453: if_icmpgt -> 2664
/*      */     //   2456: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   2459: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*      */     //   2464: dup
/*      */     //   2465: ifnonnull -> 2471
/*      */     //   2468: invokestatic throwNpe : ()V
/*      */     //   2471: invokeinterface getTicksExisted : ()I
/*      */     //   2476: i2d
/*      */     //   2477: ldc2_w 70.0
/*      */     //   2480: ddiv
/*      */     //   2481: iload #22
/*      */     //   2483: i2d
/*      */     //   2484: ldc2_w 50.0
/*      */     //   2487: ddiv
/*      */     //   2488: ldc2_w 1.75
/*      */     //   2491: dmul
/*      */     //   2492: dstore #25
/*      */     //   2494: dstore #36
/*      */     //   2496: iconst_0
/*      */     //   2497: istore #27
/*      */     //   2499: dload #25
/*      */     //   2501: invokestatic sin : (D)D
/*      */     //   2504: dstore #38
/*      */     //   2506: dload #36
/*      */     //   2508: dload #38
/*      */     //   2510: dadd
/*      */     //   2511: d2f
/*      */     //   2512: fconst_1
/*      */     //   2513: frem
/*      */     //   2514: ldc_w 0.7
/*      */     //   2517: fconst_1
/*      */     //   2518: invokestatic HSBtoRGB : (FFF)I
/*      */     //   2521: istore #44
/*      */     //   2523: new java/awt/Color
/*      */     //   2526: dup
/*      */     //   2527: iload #44
/*      */     //   2529: invokespecial <init> : (I)V
/*      */     //   2532: astore #24
/*      */     //   2534: aload #24
/*      */     //   2536: invokevirtual getRed : ()I
/*      */     //   2539: i2f
/*      */     //   2540: ldc_w 255.0
/*      */     //   2543: fdiv
/*      */     //   2544: aload #24
/*      */     //   2546: invokevirtual getGreen : ()I
/*      */     //   2549: i2f
/*      */     //   2550: ldc_w 255.0
/*      */     //   2553: fdiv
/*      */     //   2554: aload #24
/*      */     //   2556: invokevirtual getBlue : ()I
/*      */     //   2559: i2f
/*      */     //   2560: ldc_w 255.0
/*      */     //   2563: fdiv
/*      */     //   2564: invokestatic glColor3f : (FFF)V
/*      */     //   2567: dload #16
/*      */     //   2569: dload #12
/*      */     //   2571: iload #22
/*      */     //   2573: i2d
/*      */     //   2574: ldc2_w 6.283185307179586
/*      */     //   2577: dmul
/*      */     //   2578: ldc2_w 45.0
/*      */     //   2581: ddiv
/*      */     //   2582: dstore #25
/*      */     //   2584: dstore #36
/*      */     //   2586: dstore #34
/*      */     //   2588: iconst_0
/*      */     //   2589: istore #27
/*      */     //   2591: dload #25
/*      */     //   2593: invokestatic cos : (D)D
/*      */     //   2596: dstore #38
/*      */     //   2598: dload #34
/*      */     //   2600: dload #36
/*      */     //   2602: dload #38
/*      */     //   2604: dmul
/*      */     //   2605: dadd
/*      */     //   2606: dload #18
/*      */     //   2608: dload #20
/*      */     //   2610: dload #12
/*      */     //   2612: iload #22
/*      */     //   2614: i2d
/*      */     //   2615: ldc2_w 6.283185307179586
/*      */     //   2618: dmul
/*      */     //   2619: ldc2_w 45.0
/*      */     //   2622: ddiv
/*      */     //   2623: dstore #25
/*      */     //   2625: dstore #40
/*      */     //   2627: dstore #38
/*      */     //   2629: dstore #36
/*      */     //   2631: dstore #34
/*      */     //   2633: iconst_0
/*      */     //   2634: istore #27
/*      */     //   2636: dload #25
/*      */     //   2638: invokestatic sin : (D)D
/*      */     //   2641: dstore #42
/*      */     //   2643: dload #34
/*      */     //   2645: dload #36
/*      */     //   2647: dload #38
/*      */     //   2649: dload #40
/*      */     //   2651: dload #42
/*      */     //   2653: dmul
/*      */     //   2654: dadd
/*      */     //   2655: invokestatic glVertex3d : (DDD)V
/*      */     //   2658: iinc #22, 1
/*      */     //   2661: goto -> 2449
/*      */     //   2664: invokestatic glEnd : ()V
/*      */     //   2667: iconst_1
/*      */     //   2668: invokestatic glDepthMask : (Z)V
/*      */     //   2671: sipush #2929
/*      */     //   2674: invokestatic glEnable : (I)V
/*      */     //   2677: sipush #2848
/*      */     //   2680: invokestatic glDisable : (I)V
/*      */     //   2683: sipush #2881
/*      */     //   2686: invokestatic glDisable : (I)V
/*      */     //   2689: sipush #2832
/*      */     //   2692: invokestatic glEnable : (I)V
/*      */     //   2695: sipush #3553
/*      */     //   2698: invokestatic glEnable : (I)V
/*      */     //   2701: invokestatic glPopMatrix : ()V
/*      */     //   2704: goto -> 3528
/*      */     //   2707: aload_0
/*      */     //   2708: getfield yPos : D
/*      */     //   2711: dstore #7
/*      */     //   2713: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$5.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$5;
/*      */     //   2716: astore #9
/*      */     //   2718: aload_0
/*      */     //   2719: getfield al : F
/*      */     //   2722: fconst_0
/*      */     //   2723: fcmpl
/*      */     //   2724: ifle -> 2819
/*      */     //   2727: invokestatic currentTimeMillis : ()J
/*      */     //   2730: aload_0
/*      */     //   2731: getfield lastMS : J
/*      */     //   2734: lsub
/*      */     //   2735: ldc2_w 1000
/*      */     //   2738: lcmp
/*      */     //   2739: iflt -> 2758
/*      */     //   2742: aload_0
/*      */     //   2743: aload_0
/*      */     //   2744: getfield direction : D
/*      */     //   2747: dneg
/*      */     //   2748: putfield direction : D
/*      */     //   2751: aload_0
/*      */     //   2752: invokestatic currentTimeMillis : ()J
/*      */     //   2755: putfield lastMS : J
/*      */     //   2758: aload_0
/*      */     //   2759: getfield direction : D
/*      */     //   2762: iconst_0
/*      */     //   2763: i2d
/*      */     //   2764: dcmpl
/*      */     //   2765: ifle -> 2779
/*      */     //   2768: invokestatic currentTimeMillis : ()J
/*      */     //   2771: aload_0
/*      */     //   2772: getfield lastMS : J
/*      */     //   2775: lsub
/*      */     //   2776: goto -> 2791
/*      */     //   2779: ldc2_w 1000
/*      */     //   2782: invokestatic currentTimeMillis : ()J
/*      */     //   2785: aload_0
/*      */     //   2786: getfield lastMS : J
/*      */     //   2789: lsub
/*      */     //   2790: lsub
/*      */     //   2791: lstore #10
/*      */     //   2793: aload_0
/*      */     //   2794: lload #10
/*      */     //   2796: l2d
/*      */     //   2797: ldc2_w 1000.0
/*      */     //   2800: ddiv
/*      */     //   2801: putfield progress : D
/*      */     //   2804: aload_0
/*      */     //   2805: invokestatic currentTimeMillis : ()J
/*      */     //   2808: aload_0
/*      */     //   2809: getfield lastMS : J
/*      */     //   2812: lsub
/*      */     //   2813: putfield lastDeltaMS : J
/*      */     //   2816: goto -> 2831
/*      */     //   2819: aload_0
/*      */     //   2820: invokestatic currentTimeMillis : ()J
/*      */     //   2823: aload_0
/*      */     //   2824: getfield lastDeltaMS : J
/*      */     //   2827: lsub
/*      */     //   2828: putfield lastMS : J
/*      */     //   2831: aload_0
/*      */     //   2832: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2835: ifnull -> 2866
/*      */     //   2838: aload_0
/*      */     //   2839: aload_0
/*      */     //   2840: getfield target : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2843: putfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2846: aload_0
/*      */     //   2847: aload_0
/*      */     //   2848: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2851: dup
/*      */     //   2852: ifnonnull -> 2858
/*      */     //   2855: invokestatic throwNpe : ()V
/*      */     //   2858: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2863: putfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2866: aload_0
/*      */     //   2867: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2870: ifnull -> 2880
/*      */     //   2873: aload_0
/*      */     //   2874: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2877: ifnonnull -> 2881
/*      */     //   2880: return
/*      */     //   2881: aload_0
/*      */     //   2882: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2885: dup
/*      */     //   2886: ifnonnull -> 2892
/*      */     //   2889: invokestatic throwNpe : ()V
/*      */     //   2892: invokeinterface getMaxX : ()D
/*      */     //   2897: aload_0
/*      */     //   2898: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2901: dup
/*      */     //   2902: ifnonnull -> 2908
/*      */     //   2905: invokestatic throwNpe : ()V
/*      */     //   2908: invokeinterface getMinX : ()D
/*      */     //   2913: dsub
/*      */     //   2914: dstore #10
/*      */     //   2916: aload_0
/*      */     //   2917: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2920: dup
/*      */     //   2921: ifnonnull -> 2927
/*      */     //   2924: invokestatic throwNpe : ()V
/*      */     //   2927: invokeinterface getMaxY : ()D
/*      */     //   2932: aload_0
/*      */     //   2933: getfield bb : Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2936: dup
/*      */     //   2937: ifnonnull -> 2943
/*      */     //   2940: invokestatic throwNpe : ()V
/*      */     //   2943: invokeinterface getMinY : ()D
/*      */     //   2948: dsub
/*      */     //   2949: dstore #12
/*      */     //   2951: aload_0
/*      */     //   2952: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2955: dup
/*      */     //   2956: ifnonnull -> 2962
/*      */     //   2959: invokestatic throwNpe : ()V
/*      */     //   2962: invokeinterface getLastTickPosX : ()D
/*      */     //   2967: aload_0
/*      */     //   2968: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2971: dup
/*      */     //   2972: ifnonnull -> 2978
/*      */     //   2975: invokestatic throwNpe : ()V
/*      */     //   2978: invokeinterface getPosX : ()D
/*      */     //   2983: aload_0
/*      */     //   2984: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   2987: dup
/*      */     //   2988: ifnonnull -> 2994
/*      */     //   2991: invokestatic throwNpe : ()V
/*      */     //   2994: invokeinterface getLastTickPosX : ()D
/*      */     //   2999: dsub
/*      */     //   3000: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3003: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3008: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3013: f2d
/*      */     //   3014: dmul
/*      */     //   3015: dadd
/*      */     //   3016: dstore #14
/*      */     //   3018: aload_0
/*      */     //   3019: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3022: dup
/*      */     //   3023: ifnonnull -> 3029
/*      */     //   3026: invokestatic throwNpe : ()V
/*      */     //   3029: invokeinterface getLastTickPosY : ()D
/*      */     //   3034: aload_0
/*      */     //   3035: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3038: dup
/*      */     //   3039: ifnonnull -> 3045
/*      */     //   3042: invokestatic throwNpe : ()V
/*      */     //   3045: invokeinterface getPosY : ()D
/*      */     //   3050: aload_0
/*      */     //   3051: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3054: dup
/*      */     //   3055: ifnonnull -> 3061
/*      */     //   3058: invokestatic throwNpe : ()V
/*      */     //   3061: invokeinterface getLastTickPosY : ()D
/*      */     //   3066: dsub
/*      */     //   3067: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3070: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3075: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3080: f2d
/*      */     //   3081: dmul
/*      */     //   3082: dadd
/*      */     //   3083: dstore #16
/*      */     //   3085: aload_0
/*      */     //   3086: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3089: dup
/*      */     //   3090: ifnonnull -> 3096
/*      */     //   3093: invokestatic throwNpe : ()V
/*      */     //   3096: invokeinterface getLastTickPosZ : ()D
/*      */     //   3101: aload_0
/*      */     //   3102: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3105: dup
/*      */     //   3106: ifnonnull -> 3112
/*      */     //   3109: invokestatic throwNpe : ()V
/*      */     //   3112: invokeinterface getPosZ : ()D
/*      */     //   3117: aload_0
/*      */     //   3118: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3121: dup
/*      */     //   3122: ifnonnull -> 3128
/*      */     //   3125: invokestatic throwNpe : ()V
/*      */     //   3128: invokeinterface getLastTickPosZ : ()D
/*      */     //   3133: dsub
/*      */     //   3134: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3137: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*      */     //   3142: invokeinterface getRenderPartialTicks : ()F
/*      */     //   3147: f2d
/*      */     //   3148: dmul
/*      */     //   3149: dadd
/*      */     //   3150: dstore #18
/*      */     //   3152: aload_0
/*      */     //   3153: aload #9
/*      */     //   3155: aload_0
/*      */     //   3156: getfield progress : D
/*      */     //   3159: invokevirtual invoke : (D)D
/*      */     //   3162: dload #12
/*      */     //   3164: dmul
/*      */     //   3165: putfield yPos : D
/*      */     //   3168: aload_0
/*      */     //   3169: getfield direction : D
/*      */     //   3172: iconst_0
/*      */     //   3173: i2d
/*      */     //   3174: dcmpl
/*      */     //   3175: ifle -> 3188
/*      */     //   3178: aload_0
/*      */     //   3179: getfield yPos : D
/*      */     //   3182: dload #7
/*      */     //   3184: dsub
/*      */     //   3185: goto -> 3195
/*      */     //   3188: dload #7
/*      */     //   3190: aload_0
/*      */     //   3191: getfield yPos : D
/*      */     //   3194: dsub
/*      */     //   3195: aload_0
/*      */     //   3196: getfield direction : D
/*      */     //   3199: dneg
/*      */     //   3200: dmul
/*      */     //   3201: aload_0
/*      */     //   3202: getfield jelloGradientHeightValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   3205: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3208: checkcast java/lang/Number
/*      */     //   3211: invokevirtual doubleValue : ()D
/*      */     //   3214: dmul
/*      */     //   3215: dstore #20
/*      */     //   3217: aload_0
/*      */     //   3218: getfield al : F
/*      */     //   3221: iconst_0
/*      */     //   3222: i2f
/*      */     //   3223: fcmpg
/*      */     //   3224: ifgt -> 3243
/*      */     //   3227: aload_0
/*      */     //   3228: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3231: ifnull -> 3243
/*      */     //   3234: aload_0
/*      */     //   3235: aconst_null
/*      */     //   3236: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*      */     //   3239: putfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3242: return
/*      */     //   3243: aload #5
/*      */     //   3245: aload_0
/*      */     //   3246: getfield entity : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3249: invokevirtual invoke : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Ljava/awt/Color;
/*      */     //   3252: astore #22
/*      */     //   3254: aload #22
/*      */     //   3256: dup
/*      */     //   3257: ifnonnull -> 3263
/*      */     //   3260: invokestatic throwNpe : ()V
/*      */     //   3263: invokevirtual getRed : ()I
/*      */     //   3266: i2f
/*      */     //   3267: ldc_w 255.0
/*      */     //   3270: fdiv
/*      */     //   3271: fstore #23
/*      */     //   3273: aload #22
/*      */     //   3275: invokevirtual getGreen : ()I
/*      */     //   3278: i2f
/*      */     //   3279: ldc_w 255.0
/*      */     //   3282: fdiv
/*      */     //   3283: fstore #24
/*      */     //   3285: aload #22
/*      */     //   3287: invokevirtual getBlue : ()I
/*      */     //   3290: i2f
/*      */     //   3291: ldc_w 255.0
/*      */     //   3294: fdiv
/*      */     //   3295: fstore #25
/*      */     //   3297: aload #4
/*      */     //   3299: invokevirtual invoke : ()V
/*      */     //   3302: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3305: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3310: invokeinterface getViewerPosX : ()D
/*      */     //   3315: dneg
/*      */     //   3316: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3319: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3324: invokeinterface getViewerPosY : ()D
/*      */     //   3329: dneg
/*      */     //   3330: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*      */     //   3333: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*      */     //   3338: invokeinterface getViewerPosZ : ()D
/*      */     //   3343: dneg
/*      */     //   3344: invokestatic glTranslated : (DDD)V
/*      */     //   3347: bipush #8
/*      */     //   3349: invokestatic glBegin : (I)V
/*      */     //   3352: iconst_0
/*      */     //   3353: istore #26
/*      */     //   3355: sipush #360
/*      */     //   3358: istore #27
/*      */     //   3360: iload #26
/*      */     //   3362: iload #27
/*      */     //   3364: if_icmpgt -> 3481
/*      */     //   3367: iload #26
/*      */     //   3369: i2d
/*      */     //   3370: ldc2_w 3.141592653589793
/*      */     //   3373: dmul
/*      */     //   3374: sipush #180
/*      */     //   3377: i2d
/*      */     //   3378: ddiv
/*      */     //   3379: dstore #28
/*      */     //   3381: dload #14
/*      */     //   3383: dload #28
/*      */     //   3385: invokestatic sin : (D)D
/*      */     //   3388: dload #10
/*      */     //   3390: dmul
/*      */     //   3391: dsub
/*      */     //   3392: dstore #30
/*      */     //   3394: dload #18
/*      */     //   3396: dload #28
/*      */     //   3398: invokestatic cos : (D)D
/*      */     //   3401: dload #10
/*      */     //   3403: dmul
/*      */     //   3404: dadd
/*      */     //   3405: dstore #32
/*      */     //   3407: fload #23
/*      */     //   3409: fload #24
/*      */     //   3411: fload #25
/*      */     //   3413: fconst_0
/*      */     //   3414: invokestatic glColor4f : (FFFF)V
/*      */     //   3417: dload #30
/*      */     //   3419: dload #16
/*      */     //   3421: aload_0
/*      */     //   3422: getfield yPos : D
/*      */     //   3425: dadd
/*      */     //   3426: dload #20
/*      */     //   3428: dadd
/*      */     //   3429: dload #32
/*      */     //   3431: invokestatic glVertex3d : (DDD)V
/*      */     //   3434: fload #23
/*      */     //   3436: fload #24
/*      */     //   3438: fload #25
/*      */     //   3440: aload_0
/*      */     //   3441: getfield al : F
/*      */     //   3444: aload_0
/*      */     //   3445: getfield jelloAlphaValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   3448: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3451: checkcast java/lang/Number
/*      */     //   3454: invokevirtual floatValue : ()F
/*      */     //   3457: fmul
/*      */     //   3458: invokestatic glColor4f : (FFFF)V
/*      */     //   3461: dload #30
/*      */     //   3463: dload #16
/*      */     //   3465: aload_0
/*      */     //   3466: getfield yPos : D
/*      */     //   3469: dadd
/*      */     //   3470: dload #32
/*      */     //   3472: invokestatic glVertex3d : (DDD)V
/*      */     //   3475: iinc #26, 1
/*      */     //   3478: goto -> 3360
/*      */     //   3481: invokestatic glEnd : ()V
/*      */     //   3484: aload_3
/*      */     //   3485: dload #14
/*      */     //   3487: dload #16
/*      */     //   3489: aload_0
/*      */     //   3490: getfield yPos : D
/*      */     //   3493: dadd
/*      */     //   3494: dload #18
/*      */     //   3496: aload_0
/*      */     //   3497: getfield jelloWidthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*      */     //   3500: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3503: checkcast java/lang/Number
/*      */     //   3506: invokevirtual floatValue : ()F
/*      */     //   3509: dload #10
/*      */     //   3511: fload #23
/*      */     //   3513: fload #24
/*      */     //   3515: fload #25
/*      */     //   3517: aload_0
/*      */     //   3518: getfield al : F
/*      */     //   3521: invokevirtual invoke : (DDDFDFFFF)V
/*      */     //   3524: aload_2
/*      */     //   3525: invokevirtual invoke : ()V
/*      */     //   3528: aload_0
/*      */     //   3529: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3532: ifnull -> 3634
/*      */     //   3535: aload_0
/*      */     //   3536: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   3539: aload_0
/*      */     //   3540: getfield attackDelay : J
/*      */     //   3543: invokevirtual hasTimePassed : (J)Z
/*      */     //   3546: ifeq -> 3634
/*      */     //   3549: aload_0
/*      */     //   3550: getfield currentTarget : Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*      */     //   3553: dup
/*      */     //   3554: ifnonnull -> 3560
/*      */     //   3557: invokestatic throwNpe : ()V
/*      */     //   3560: invokeinterface getHurtTime : ()I
/*      */     //   3565: aload_0
/*      */     //   3566: getfield hurtTimeValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   3569: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3572: checkcast java/lang/Number
/*      */     //   3575: invokevirtual intValue : ()I
/*      */     //   3578: if_icmpgt -> 3634
/*      */     //   3581: aload_0
/*      */     //   3582: dup
/*      */     //   3583: getfield clicks : I
/*      */     //   3586: dup
/*      */     //   3587: istore #6
/*      */     //   3589: iconst_1
/*      */     //   3590: iadd
/*      */     //   3591: putfield clicks : I
/*      */     //   3594: aload_0
/*      */     //   3595: getfield attackTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*      */     //   3598: invokevirtual reset : ()V
/*      */     //   3601: aload_0
/*      */     //   3602: aload_0
/*      */     //   3603: getfield minCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   3606: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3609: checkcast java/lang/Number
/*      */     //   3612: invokevirtual intValue : ()I
/*      */     //   3615: aload_0
/*      */     //   3616: getfield maxCPS : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*      */     //   3619: invokevirtual get : ()Ljava/lang/Object;
/*      */     //   3622: checkcast java/lang/Number
/*      */     //   3625: invokevirtual intValue : ()I
/*      */     //   3628: invokestatic randomClickDelay : (II)J
/*      */     //   3631: putfield attackDelay : J
/*      */     //   3634: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #578	-> 7
/*      */     //   #588	-> 11
/*      */     //   #611	-> 15
/*      */     //   #624	-> 20
/*      */     //   #657	-> 30
/*      */     //   #658	-> 46
/*      */     //   #659	-> 49
/*      */     //   #660	-> 49
/*      */     //   #661	-> 140
/*      */     //   #662	-> 231
/*      */     //   #659	-> 322
/*      */     //   #664	-> 325
/*      */     //   #665	-> 331
/*      */     //   #666	-> 337
/*      */     //   #667	-> 343
/*      */     //   #668	-> 349
/*      */     //   #670	-> 358
/*      */     //   #671	-> 362
/*      */     //   #672	-> 437
/*      */     //   #673	-> 446
/*      */     //   #675	-> 450
/*      */     //   #676	-> 522
/*      */     //   #676	-> 543
/*      */     //   #676	-> 587
/*      */     //   #675	-> 605
/*      */     //   #678	-> 622
/*      */     //   #678	-> 635
/*      */     //   #678	-> 671
/*      */     //   #680	-> 689
/*      */     //   #682	-> 692
/*      */     //   #683	-> 698
/*      */     //   #684	-> 704
/*      */     //   #685	-> 710
/*      */     //   #687	-> 716
/*      */     //   #690	-> 719
/*      */     //   #1622	-> 725
/*      */     //   #1623	-> 725
/*      */     //   #1622	-> 750
/*      */     //   #1623	-> 774
/*      */     //   #691	-> 818
/*      */     //   #692	-> 826
/*      */     //   #693	-> 834
/*      */     //   #694	-> 839
/*      */     //   #695	-> 843
/*      */     //   #698	-> 844
/*      */     //   #699	-> 844
/*      */     //   #698	-> 844
/*      */     //   #699	-> 879
/*      */     //   #700	-> 904
/*      */     //   #701	-> 912
/*      */     //   #702	-> 920
/*      */     //   #703	-> 925
/*      */     //   #704	-> 951
/*      */     //   #707	-> 952
/*      */     //   #707	-> 963
/*      */     //   #709	-> 966
/*      */     //   #723	-> 1080
/*      */     //   #800	-> 1094
/*      */     //   #753	-> 1108
/*      */     //   #710	-> 1122
/*      */     //   #726	-> 1136
/*      */     //   #717	-> 1150
/*      */     //   #713	-> 1164
/*      */     //   #711	-> 1178
/*      */     //   #713	-> 1252
/*      */     //   #714	-> 1252
/*      */     //   #715	-> 1266
/*      */     //   #713	-> 1306
/*      */     //   #718	-> 1312
/*      */     //   #719	-> 1330
/*      */     //   #720	-> 1362
/*      */     //   #721	-> 1408
/*      */     //   #724	-> 1429
/*      */     //   #727	-> 1508
/*      */     //   #728	-> 1513
/*      */     //   #729	-> 1516
/*      */     //   #730	-> 1519
/*      */     //   #731	-> 1519
/*      */     //   #732	-> 1589
/*      */     //   #733	-> 1681
/*      */     //   #730	-> 1751
/*      */     //   #735	-> 1754
/*      */     //   #736	-> 1777
/*      */     //   #737	-> 1821
/*      */     //   #738	-> 1872
/*      */     //   #739	-> 1878
/*      */     //   #740	-> 1887
/*      */     //   #741	-> 1896
/*      */     //   #742	-> 1910
/*      */     //   #743	-> 1918
/*      */     //   #744	-> 1926
/*      */     //   #745	-> 1940
/*      */     //   #746	-> 1949
/*      */     //   #747	-> 1957
/*      */     //   #748	-> 1971
/*      */     //   #749	-> 1979
/*      */     //   #750	-> 1993
/*      */     //   #751	-> 1996
/*      */     //   #754	-> 2002
/*      */     //   #755	-> 2013
/*      */     //   #756	-> 2028
/*      */     //   #758	-> 2037
/*      */     //   #759	-> 2042
/*      */     //   #761	-> 2052
/*      */     //   #762	-> 2059
/*      */     //   #763	-> 2059
/*      */     //   #764	-> 2069
/*      */     //   #765	-> 2072
/*      */     //   #766	-> 2078
/*      */     //   #767	-> 2084
/*      */     //   #768	-> 2090
/*      */     //   #769	-> 2096
/*      */     //   #770	-> 2102
/*      */     //   #771	-> 2111
/*      */     //   #772	-> 2120
/*      */     //   #773	-> 2129
/*      */     //   #774	-> 2138
/*      */     //   #775	-> 2144
/*      */     //   #777	-> 2148
/*      */     //   #778	-> 2166
/*      */     //   #779	-> 2187
/*      */     //   #780	-> 2204
/*      */     //   #781	-> 2276
/*      */     //   #782	-> 2354
/*      */     //   #783	-> 2426
/*      */     //   #784	-> 2437
/*      */     //   #785	-> 2441
/*      */     //   #786	-> 2456
/*      */     //   #786	-> 2510
/*      */     //   #787	-> 2534
/*      */     //   #788	-> 2567
/*      */     //   #788	-> 2604
/*      */     //   #788	-> 2653
/*      */     //   #785	-> 2658
/*      */     //   #790	-> 2664
/*      */     //   #792	-> 2667
/*      */     //   #793	-> 2671
/*      */     //   #794	-> 2677
/*      */     //   #795	-> 2683
/*      */     //   #796	-> 2689
/*      */     //   #797	-> 2695
/*      */     //   #798	-> 2701
/*      */     //   #801	-> 2707
/*      */     //   #802	-> 2713
/*      */     //   #805	-> 2718
/*      */     //   #806	-> 2727
/*      */     //   #807	-> 2742
/*      */     //   #808	-> 2751
/*      */     //   #810	-> 2758
/*      */     //   #811	-> 2758
/*      */     //   #810	-> 2791
/*      */     //   #812	-> 2793
/*      */     //   #813	-> 2804
/*      */     //   #815	-> 2819
/*      */     //   #816	-> 2831
/*      */     //   #818	-> 2831
/*      */     //   #819	-> 2838
/*      */     //   #820	-> 2846
/*      */     //   #823	-> 2866
/*      */     //   #825	-> 2881
/*      */     //   #826	-> 2916
/*      */     //   #827	-> 2951
/*      */     //   #828	-> 2951
/*      */     //   #827	-> 3016
/*      */     //   #829	-> 3018
/*      */     //   #830	-> 3018
/*      */     //   #829	-> 3083
/*      */     //   #831	-> 3085
/*      */     //   #832	-> 3085
/*      */     //   #831	-> 3150
/*      */     //   #834	-> 3152
/*      */     //   #836	-> 3168
/*      */     //   #837	-> 3168
/*      */     //   #836	-> 3215
/*      */     //   #839	-> 3217
/*      */     //   #840	-> 3234
/*      */     //   #841	-> 3242
/*      */     //   #844	-> 3243
/*      */     //   #845	-> 3254
/*      */     //   #846	-> 3273
/*      */     //   #847	-> 3285
/*      */     //   #849	-> 3297
/*      */     //   #852	-> 3302
/*      */     //   #853	-> 3302
/*      */     //   #854	-> 3316
/*      */     //   #855	-> 3330
/*      */     //   #852	-> 3344
/*      */     //   #858	-> 3347
/*      */     //   #860	-> 3352
/*      */     //   #861	-> 3367
/*      */     //   #862	-> 3381
/*      */     //   #863	-> 3394
/*      */     //   #864	-> 3407
/*      */     //   #865	-> 3417
/*      */     //   #866	-> 3434
/*      */     //   #867	-> 3461
/*      */     //   #860	-> 3475
/*      */     //   #870	-> 3481
/*      */     //   #872	-> 3484
/*      */     //   #874	-> 3524
/*      */     //   #945	-> 3528
/*      */     //   #947	-> 3528
/*      */     //   #948	-> 3528
/*      */     //   #947	-> 3535
/*      */     //   #948	-> 3565
/*      */     //   #949	-> 3581
/*      */     //   #950	-> 3594
/*      */     //   #951	-> 3601
/*      */     //   #953	-> 3634
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   522	97	6	i	I
/*      */     //   722	93	6	this_$iv	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */     //   725	90	7	$i$f$getCancelRun	I
/*      */     //   1330	96	7	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   1887	112	9	c	Lorg/lwjgl/util/glu/Cylinder;
/*      */     //   1516	483	8	side	I
/*      */     //   1513	486	7	radius	F
/*      */     //   2534	124	24	rainbow	Ljava/awt/Color;
/*      */     //   2456	205	22	i	I
/*      */     //   2426	278	20	z	D
/*      */     //   2354	350	18	y	D
/*      */     //   2276	428	16	x	D
/*      */     //   2204	500	14	height	D
/*      */     //   2187	517	12	radius	D
/*      */     //   2166	538	11	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*      */     //   2037	667	9	drawPercent	D
/*      */     //   2028	676	8	drawMode	Z
/*      */     //   2013	691	7	drawTime	I
/*      */     //   2793	23	10	weird	J
/*      */     //   3407	68	32	posZ2	D
/*      */     //   3394	81	30	posX2	D
/*      */     //   3381	94	28	calc	D
/*      */     //   3367	111	26	i	I
/*      */     //   3297	231	25	b	F
/*      */     //   3285	243	24	g	F
/*      */     //   3273	255	23	r	F
/*      */     //   3254	274	22	colour	Ljava/awt/Color;
/*      */     //   3217	311	20	deltaY	D
/*      */     //   3152	376	18	posZ	D
/*      */     //   3085	443	16	posY	D
/*      */     //   3018	510	14	posX	D
/*      */     //   2951	577	12	height	D
/*      */     //   2916	612	10	radius	D
/*      */     //   2718	810	9	$fun$easeInOutQuart$5	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$5;
/*      */     //   2713	815	7	lastY	D
/*      */     //   30	3605	5	$fun$getColor$4	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$4;
/*      */     //   20	3615	4	$fun$pre3D$3	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$3;
/*      */     //   15	3620	3	$fun$drawCircle$2	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$2;
/*      */     //   11	3624	2	$fun$post3D$1	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$onRender3D$1;
/*      */     //   0	3635	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/* 1629 */     //   0	3635	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent; } private final void updateTarget() { this.target = (IEntityLivingBase)null; int hurtTime = ((Number)this.hurtTimeValue.get()).intValue(); float fov = ((Number)this.fovValue.get()).floatValue(); boolean switchMode = StringsKt.equals((String)this.targetModeValue.get(), "Switch", true); boolean bool1 = false; List<IEntityLivingBase> targets = new ArrayList(); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IWorldClient theWorld = MinecraftInstance.mc.getTheWorld(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer(); for (IEntity entity : theWorld.getLoadedEntityList()) { if (!MinecraftInstance.classProvider.isEntityLivingBase(entity) || !isEnemy(entity) || (switchMode && this.prevTargetEntities.contains(Integer.valueOf(entity.getEntityId())))) continue;  double distance = PlayerExtensionKt.getDistanceToEntityBox((IEntity)thePlayer, entity); double entityFov = RotationUtils.getRotationDifference(entity); if (distance <= getMaxRange() && (fov == 180.0F || entityFov <= fov) && entity.asEntityLivingBase().getHurtTime() <= hurtTime) targets.add(entity.asEntityLivingBase());  }  String str = (String)this.priorityValue.get(); boolean bool2 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 288459765: if (str.equals("distance")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura2$updateTarget$$inlined$sortBy$1 killAura2$updateTarget$$inlined$sortBy$1 = new KillAura2$updateTarget$$inlined$sortBy$1(thePlayer); CollectionsKt.sortWith(list1, killAura2$updateTarget$$inlined$sortBy$1); }  }  break;
/*      */       case -1221262756:
/* 1631 */         if (str.equals("health")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura2$updateTarget$$inlined$sortBy$2 killAura2$updateTarget$$inlined$sortBy$2 = new KillAura2$updateTarget$$inlined$sortBy$2(); CollectionsKt.sortWith(list1, killAura2$updateTarget$$inlined$sortBy$2); }
/*      */            }
/*      */          break;
/*      */       case 886905078:
/* 1635 */         if (str.equals("livingtime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura2$updateTarget$$inlined$sortBy$4 killAura2$updateTarget$$inlined$sortBy$4 = new KillAura2$updateTarget$$inlined$sortBy$4(); CollectionsKt.sortWith(list1, killAura2$updateTarget$$inlined$sortBy$4); }  }  break;
/*      */       case 525193846:
/* 1637 */         if (str.equals("HurtResitanTime")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura2$updateTarget$$inlined$sortBy$5 killAura2$updateTarget$$inlined$sortBy$5 = new KillAura2$updateTarget$$inlined$sortBy$5(); CollectionsKt.sortWith(list1, killAura2$updateTarget$$inlined$sortBy$5); }  }  break;case -962590849: if (str.equals("direction")) { List<IEntityLivingBase> $this$sortBy$iv = targets; int $i$f$sortBy = 0; if ($this$sortBy$iv.size() > 1) { List<IEntityLivingBase> list1 = $this$sortBy$iv; boolean bool = false; KillAura2$updateTarget$$inlined$sortBy$3 killAura2$updateTarget$$inlined$sortBy$3 = new KillAura2$updateTarget$$inlined$sortBy$3(); CollectionsKt.sortWith(list1, killAura2$updateTarget$$inlined$sortBy$3); }  }  break; }  for (IEntityLivingBase entity : targets) { if (!updateRotations((IEntity)entity)) continue;  this.target = entity; return; }  List<Integer> list = this.prevTargetEntities; bool2 = false; if (!list.isEmpty()) { this.prevTargetEntities.clear(); updateTarget(); }  } private final boolean isEnemy(IEntity entity) { if (MinecraftInstance.classProvider.isEntityLivingBase(entity) && entity != null && (EntityUtils.targetDead || isAlive(entity.asEntityLivingBase())) && (Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0) { if (!EntityUtils.targetInvisible && entity.isInvisible()) return false;  if (EntityUtils.targetPlayer && MinecraftInstance.classProvider.isEntityPlayer(entity)) { IEntityPlayer player = entity.asEntityPlayer(); if (player.isSpectator() || AntiBot.isBot((IEntityLivingBase)player)) return false;  if (PlayerExtensionKt.isClientFriend(player) && !Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState()) return false;  if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams");  Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class); return (!teams.getState() || !teams.isInYourTeam(entity.asEntityLivingBase())); }  return ((EntityUtils.targetMobs && PlayerExtensionKt.isMob(entity)) || (EntityUtils.targetAnimals && PlayerExtensionKt.isAnimal(entity))); }  return false; } private final void attackEntity(IEntityLivingBase entity) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer(); if (!StringsKt.equals((String)this.autoBlockPacketValue.get(), "Vanilla", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isBlocking() || this.blockingStatus) { MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN))); if (((Boolean)this.afterAttackValue.get()).booleanValue()) this.blockingStatus = false;  }  }  Retreat.INSTANCE.getEventManager().callEvent((Event)new AttackEvent((IEntity)entity)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity((IEntity)entity, ICPacketUseEntity.WAction.ATTACK)); thePlayer.swingItem(); if (((Boolean)this.keepSprintValue.get()).booleanValue()) { if (thePlayer.getFallDistance() > 0.0F && !thePlayer.getOnGround() && !thePlayer.isOnLadder() && !thePlayer.isInWater() && !thePlayer.isPotionActive(MinecraftInstance.classProvider.getPotionEnum(PotionType.BLINDNESS)) && !thePlayer.isRiding()) thePlayer.onCriticalHit((IEntity)entity);  if (MinecraftInstance.functions.getModifierForCreature(thePlayer.getHeldItem(), entity.getCreatureAttribute()) > 0.0F) thePlayer.onEnchantmentCritical(entity);  } else if (MinecraftInstance.mc.getPlayerController().getCurrentGameType() != IWorldSettings.WGameType.SPECTATOR) { thePlayer.attackTargetEntityWithCurrentItem((IEntity)entity); }  if (Retreat.INSTANCE.getModuleManager().get(Criticals.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Criticals");  Criticals criticals = (Criticals)Retreat.INSTANCE.getModuleManager().get(Criticals.class); for (byte b1 = 0, b2 = 2; b1 <= b2; b1++) { if ((thePlayer.getFallDistance() > 0.0F && !thePlayer.getOnGround() && !thePlayer.isOnLadder() && !thePlayer.isInWater() && !thePlayer.isPotionActive(MinecraftInstance.classProvider.getPotionEnum(PotionType.BLINDNESS)) && thePlayer.getRidingEntity() == null) || (criticals.getState() && criticals.getMsTimer().hasTimePassed(((Number)criticals.getDelayValue().get()).intValue()) && !thePlayer.isInWater() && !thePlayer.isInLava() && !thePlayer.isInWeb())) { if (this.target == null) Intrinsics.throwNpe();  thePlayer.onCriticalHit((IEntity)this.target); }  if (this.target == null) Intrinsics.throwNpe();  if (MinecraftInstance.functions.getModifierForCreature(thePlayer.getHeldItem(), this.target.getCreatureAttribute()) > 0.0F || ((Boolean)this.fakeSharpValue.get()).booleanValue()) { if (this.target == null) Intrinsics.throwNpe();  thePlayer.onEnchantmentCritical(this.target); }  }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().isBlocking() || (!StringsKt.equals((String)this.autoBlockValue.get(), "off", true) && canBlock())) { if (((Boolean)this.delayedBlockValue.get()).booleanValue()) return;  startBlocking((IEntity)entity, ((Boolean)this.interactAutoBlockValue.get()).booleanValue()); }  thePlayer.resetCooldown(); } private final boolean updateRotations(IEntity entity) { IAxisAlignedBB boundingBox = entity.getEntityBoundingBox(); if (StringsKt.equals((String)this.rotations.get(), "Test", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "test1", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 wVec3 = vecRotation.component1(); Rotation rotation = vecRotation.component2(); Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.getNCPRotations(RotationUtils.getCenter(entity.getEntityBoundingBox()), false), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())), "RotationUtils.limitAngle…rnSpeed.get()).toFloat())"); Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.getNCPRotations(RotationUtils.getCenter(entity.getEntityBoundingBox()), false), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "test2", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 vec = vecRotation.component1(); Rotation rotation = vecRotation.component2(); Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.toRotation(RotationUtils.getCenter(entity.getEntityBoundingBox()), false), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())), "RotationUtils.limitAngle…rnSpeed.get()).toFloat())"); Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.toRotation(RotationUtils.getCenter(entity.getEntityBoundingBox()), false), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "HytRotation", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "Down", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); Rotation rotation = vecRotation.component2(); }  RotationUtils.lockView(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "New", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 vec = vecRotation.component1(); Rotation rotation = vecRotation.component2(); Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.getNewRotations(RotationUtils.getCenter(entity.getEntityBoundingBox()), false), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())), "RotationUtils.limitAngle…rnSpeed.get()).toFloat())"); Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.getNewRotations(RotationUtils.getCenter(entity.getEntityBoundingBox()), false), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "LiquidBounce", true)) { if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) return true;  if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()) != null) { VecRotation vecRotation = RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); WVec3 vec = vecRotation.component1(); Rotation rotation = vecRotation.component2(); }  RotationUtils.searchCenter(boundingBox, (((Boolean)this.outborderValue.get()).booleanValue() && !this.attackTimer.hasTimePassed(this.attackDelay / 2L)), ((Boolean)this.randomCenterValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()); return false; }  if (StringsKt.equals((String)this.rotations.get(), "BackTrack", true)) { if (((Boolean)this.predictValue.get()).booleanValue()) boundingBox = boundingBox.offset((entity.getPosX() - entity.getPrevPosX()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosY() - entity.getPrevPosY()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()), (entity.getPosZ() - entity.getPrevPosZ()) * RandomUtils.INSTANCE.nextFloat(((Number)this.minPredictSize.get()).floatValue(), ((Number)this.maxPredictSize.get()).floatValue()));  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.OtherRotation(boundingBox, RotationUtils.getCenter(entity.getEntityBoundingBox()), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())), "RotationUtils.limitAngle…rnSpeed.get()).toFloat())"); Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, RotationUtils.OtherRotation(boundingBox, RotationUtils.getCenter(entity.getEntityBoundingBox()), ((Boolean)this.predictValue.get()).booleanValue(), (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), entity) < ((Number)this.throughWallsRangeValue.get()).doubleValue()), getMaxRange()), (float)(Math.random() * (((Number)this.maxTurnSpeed.get()).floatValue() - ((Number)this.minTurnSpeed.get()).floatValue()) + ((Number)this.minTurnSpeed.get()).doubleValue())); if (((Boolean)this.silentRotationValue.get()).booleanValue()) { RotationUtils.setTargetRotation(limitedRotation, ((Boolean)this.aacValue.get()).booleanValue() ? 15 : 0); } else { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  limitedRotation.toPlayer((IEntityPlayer)MinecraftInstance.mc.getThePlayer()); return true; }  }  return true; } private final void updateHitable() { if (((Boolean)this.hitableValue.get()).booleanValue()) { this.hitable = true; return; }  if (((Number)this.maxTurnSpeed.get()).floatValue() <= 0.0F) { this.hitable = true; return; }  double d1 = getMaxRange(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.target == null) Intrinsics.throwNpe();  double d2 = PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), (IEntity)this.target); boolean bool = false; double reach = Math.min(d1, d2) + true; if (((Boolean)this.raycastValue.get()).booleanValue()) { IEntity raycastedEntity = RaycastUtils.raycastEntity(reach, new KillAura2$updateHitable$raycastedEntity$1()); if (((Boolean)this.raycastValue.get()).booleanValue() && raycastedEntity != null && MinecraftInstance.classProvider.isEntityLivingBase(raycastedEntity) && (Retreat.INSTANCE.getModuleManager().get(NoFriends.class).getState() || !MinecraftInstance.classProvider.isEntityPlayer(raycastedEntity) || !PlayerExtensionKt.isClientFriend(raycastedEntity.asEntityPlayer()))) this.currentTarget = raycastedEntity.asEntityLivingBase();  this.hitable = (((Number)this.maxTurnSpeed.get()).floatValue() > 0.0F) ? Intrinsics.areEqual(this.currentTarget, raycastedEntity) : true; } else { this.hitable = RotationUtils.isFaced((IEntity)this.currentTarget, reach); }  }
/*      */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\027\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\022\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\026¨\006\006"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$updateHitable$raycastedEntity$1", "Lnet/ccbluex/liquidbounce/utils/RaycastUtils$EntityFilter;", "canRaycast", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "XSJClient"}) public static final class KillAura2$updateHitable$raycastedEntity$1 implements RaycastUtils.EntityFilter {
/*      */     public boolean canRaycast(@Nullable IEntity entity) { // Byte code:
/*      */       //   0: aload_0
/*      */       //   1: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */       //   4: invokestatic access$getLivingRaycastValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;)Lnet/ccbluex/liquidbounce/value/BoolValue;
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
/*      */       //   44: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */       //   47: aload_1
/*      */       //   48: invokestatic access$isEnemy : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Z
/*      */       //   51: ifne -> 146
/*      */       //   54: aload_0
/*      */       //   55: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */       //   58: invokestatic access$getRaycastIgnoredValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;)Lnet/ccbluex/liquidbounce/value/BoolValue;
/*      */       //   61: invokevirtual get : ()Ljava/lang/Object;
/*      */       //   64: checkcast java/lang/Boolean
/*      */       //   67: invokevirtual booleanValue : ()Z
/*      */       //   70: ifne -> 146
/*      */       //   73: aload_0
/*      */       //   74: getfield this$0 : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;
/*      */       //   77: invokestatic access$getAacValue$p : (Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2;)Lnet/ccbluex/liquidbounce/value/BoolValue;
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
/*      */       //   #1435	-> 0
/*      */       //   #1436	-> 0
/*      */       //   #1435	-> 0
/*      */       //   #1436	-> 47
/*      */       // Local variable table:
/*      */       //   start	length	slot	name	descriptor
/*      */       //   0	152	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura2$updateHitable$raycastedEntity$1;
/*      */       //   0	152	1	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity; } }
/* 1640 */   private final void startBlocking(IEntity interactEntity, boolean interact) { if (Retreat.INSTANCE.getModuleManager().get(Annotation.class).getState()) { if (this.autoBlockValue.equals("Range")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (PlayerExtensionKt.getDistanceToEntityBox((IEntity)MinecraftInstance.mc.getThePlayer(), interactEntity) > ((Number)this.BlockRangeValue.get()).doubleValue()) return;  }  if (this.blockingStatus) return;  if (interact) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, interactEntity.getPositionVector())); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketUseEntity(interactEntity, ICPacketUseEntity.WAction.INTERACT)); }  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "UseItem", true)) KeyBinding.func_74510_a(MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().getKeyCode(), true);  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "GameSettings", true)) MinecraftInstance.mc.getGameSettings().getKeyBindUseItem().setPressed(true);  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Mouse", true)) (new Robot()).mousePress(4096);  if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Vanilla", true)) { if (StringsKt.equals((String)this.vanillamode.get(), "TryUseItem", true)) { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.MAIN_HAND)); MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.OFF_HAND)); }  if (StringsKt.equals((String)this.vanillamode.get(), "UseItem", true)) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  WEnumHand wEnumHand1 = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getThePlayer().getSendQueue(); int $i$f$createUseItemPacket = 0; IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand1); iINetHandlerPlayClient.addToSendQueue(iPacket); if (MinecraftInstance.mc.getThePlayer() == null)
/*      */             Intrinsics.throwNpe();  WEnumHand hand$iv = WEnumHand.OFF_HAND; iINetHandlerPlayClient = MinecraftInstance.mc.getThePlayer().getSendQueue(); $i$f$createUseItemPacket = 0;
/* 1642 */           iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(hand$iv); iINetHandlerPlayClient.addToSendQueue(iPacket); }
/*      */         
/*      */         if (StringsKt.equals((String)this.vanillamode.get(), "OldC08", true)) {
/*      */           if (MinecraftInstance.mc.getThePlayer() == null)
/*      */             Intrinsics.throwNpe(); 
/*      */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(new WBlockPos(-0.5534147541D, -0.5534147541D, -0.5534147541D), 255, MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand(), 0.0F, 0.0F, 0.0F));
/*      */         }  }
/*      */       
/*      */       if (StringsKt.equals((String)this.vanillamode.get(), "CPacketPlayerBlockPlacement", true)) {
/*      */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*      */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerTryUseItemOnBlock(new BlockPos(-0.5534147541D, -0.5534147541D, -0.5534147541D), EnumFacing.WEST, EnumHand.OFF_HAND, 0.0F, 0.0F, 0.0F));
/*      */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*      */         if (MinecraftInstance.mc2.func_147114_u() == null)
/*      */           Intrinsics.throwNpe(); 
/*      */         MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketPlayerTryUseItemOnBlock(new BlockPos(-0.5534147541D, -0.5534147541D, -0.5534147541D), EnumFacing.WEST, EnumHand.MAIN_HAND, 0.0F, 0.0F, 0.0F));
/*      */       }  }
/*      */     
/*      */     this.blockingStatus = true; }
/*      */ 
/*      */   
/*      */   private final void stopBlocking() {
/*      */     if (this.blockingStatus) {
/*      */       if (StringsKt.equals((String)this.autoBlockPacketValue.get(), "Vanilla", true))
/*      */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, PlayerUtil.isMoving() ? new WBlockPos(-1, -1, -1) : WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN))); 
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


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\KillAura2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */