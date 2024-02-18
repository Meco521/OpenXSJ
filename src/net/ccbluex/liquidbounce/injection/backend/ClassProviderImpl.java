/*     */ package net.ccbluex.liquidbounce.injection.backend;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.security.PublicKey;
/*     */ import javax.crypto.SecretKey;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.NoWhenBranchMatchedException;
/*     */ import kotlin.NotImplementedError;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*     */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*     */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*     */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.block.material.IMaterial;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IServerData;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.WIImageBuffer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.vertex.IVertexFormat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.settings.IGameSettings;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.event.IClickEvent;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketClientStatus;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketCloseWindow;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerBlockPlacement;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
/*     */ import net.ccbluex.liquidbounce.api.network.IPacketBuffer;
/*     */ import net.ccbluex.liquidbounce.api.util.IWrappedFontRenderer;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedCreativeTabs;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiSlot;
/*     */ import net.ccbluex.liquidbounce.injection.backend.utils.CreativeTabsWrapper;
/*     */ import net.ccbluex.liquidbounce.injection.backend.utils.GuiScreenWrapper;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityOtherPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.GuiWorldSelection;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.vertex.VertexBuffer;
/*     */ import net.minecraft.client.renderer.vertex.VertexFormat;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagDouble;
/*     */ import net.minecraft.nbt.NBTTagString;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.client.CPacketAnimation;
/*     */ import net.minecraft.network.play.client.CPacketCloseWindow;
/*     */ import net.minecraft.network.play.client.CPacketCustomPayload;
/*     */ import net.minecraft.network.play.client.CPacketHeldItemChange;
/*     */ import net.minecraft.network.play.client.CPacketKeepAlive;
/*     */ import net.minecraft.network.play.client.CPacketPlayer;
/*     */ import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
/*     */ import net.minecraft.network.play.client.CPacketUseEntity;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.world.World;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Ì\004\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\006\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\000\n\002\bc\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J8\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0162\006\020\020\032\0020\0162\006\020\021\032\0020\0162\006\020\022\032\0020\0162\006\020\023\032\0020\016H\026J\b\020\024\032\0020\025H\026J\020\020\026\032\0020\0272\006\020\030\032\0020\031H\026J\b\020\032\032\0020\033H\026J\020\020\032\032\0020\0332\006\020\034\032\0020\035H\026J\030\020\036\032\0020\0372\006\020 \032\0020\0352\006\020!\032\0020\"H\026J\030\020#\032\0020$2\006\020%\032\0020&2\006\020'\032\0020(H\026J \020)\032\0020\0372\006\020*\032\0020+2\006\020,\032\0020-2\006\020.\032\0020/H\026J\030\0200\032\002012\006\0202\032\002032\006\0204\032\00205H\026J\020\0206\032\002072\006\020 \032\0020\035H\026J\b\0208\032\00209H\026J\020\020:\032\0020;2\006\020<\032\0020=H\026J\022\020>\032\0020?2\b\020@\032\004\030\0010\"H\026J:\020>\032\0020?2\006\020A\032\0020B2\006\020C\032\0020\0352\b\020D\032\004\030\0010\"2\006\020E\032\0020F2\006\020G\032\0020F2\006\020H\032\0020FH\026J \020I\032\0020\0372\006\0204\032\0020J2\006\020K\032\0020B2\006\020L\032\0020MH\026J \020N\032\0020;2\006\020O\032\0020F2\006\020P\032\0020F2\006\020<\032\0020=H\026J8\020Q\032\0020R2\006\020S\032\0020\0162\006\020T\032\0020\0162\006\020U\032\0020\0162\006\020O\032\0020F2\006\020P\032\0020F2\006\020<\032\0020=H\026J(\020V\032\0020;2\006\020S\032\0020\0162\006\020T\032\0020\0162\006\020U\032\0020\0162\006\020<\032\0020=H\026J\020\020W\032\0020\0372\006\020X\032\0020&H\026J\024\020Y\032\006\022\002\b\0030Z2\006\020[\032\0020\\H\026J\030\020]\032\0020^2\006\0202\032\002032\006\0204\032\0020_H\026J\030\020]\032\0020^2\006\020`\032\002032\006\020a\032\0020bH\026J\020\020c\032\0020d2\006\020X\032\0020&H\026J\030\020e\032\0020f2\006\020g\032\0020h2\006\020i\032\0020&H\026J\020\020j\032\0020k2\006\020l\032\0020mH\026J0\020n\032\002032\006\020o\032\0020p2\006\020q\032\0020\0162\006\020r\032\0020\0162\006\020s\032\0020\0162\006\020t\032\0020=H\026J\030\020u\032\0020v2\006\020o\032\0020w2\006\020x\032\0020yH\026J8\020z\032\0020{2\006\020|\032\0020\0352\006\020S\032\0020\0352\006\020T\032\0020\0352\006\020}\032\0020\0352\006\020~\032\0020\0352\006\020X\032\0020&H\026J(\020z\032\0020{2\006\020|\032\0020\0352\006\020S\032\0020\0352\006\020T\032\0020\0352\006\020X\032\0020&H\026J'\020\032\0030\0012\b\020\001\032\0030\0012\b\020\001\032\0030\0012\b\020\001\032\0030\001H\026J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\026J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\026J\036\020\001\032\0030\0012\b\020\001\032\0030\0012\b\020\001\032\0030\001H\026J<\020\001\032\0030\0012\006\020|\032\0020\0352\b\020\001\032\0030\0012\006\020S\032\0020\0352\006\020T\032\0020\0352\006\020}\032\0020\0352\006\020~\032\0020\035H\026J\024\020\001\032\0030\0012\b\020\001\032\0030\001H\026J<\020\001\032\0030\0012\006\020|\032\0020\0352\b\020\001\032\0030\0012\006\020S\032\0020\0352\006\020T\032\0020\0352\006\020}\032\0020\0352\006\020~\032\0020\035H\026J\034\020\001\032\0020\0372\007\020\001\032\0020&2\b\020\001\032\0030\001H\026J\n\020\001\032\0030\001H\026J\023\020\001\032\0020\"2\b\020\001\032\0030\001H\026J\023\020\001\032\0020\"2\b\020\001\032\0030\001H\026J%\020\001\032\0020\"2\b\020\001\032\0030\0012\007\020\001\032\0020\0352\007\020\001\032\0020\035H\026J\n\020\001\032\0030\001H\026J\022\020 \001\032\0030¡\0012\006\020i\032\0020\016H\026J\n\020¢\001\032\0030£\001H\026J\023\020¤\001\032\0030¥\0012\007\020¦\001\032\0020&H\026J\023\020§\001\032\0020(2\b\020¨\001\032\0030©\001H\026J$\020ª\001\032\0030«\0012\006\020|\032\0020\0352\007\020¬\001\032\0020\0352\007\020­\001\032\0020\035H\026J\023\020®\001\032\0030¯\0012\007\020°\001\032\0020&H\026J\024\020±\001\032\0030²\0012\b\020³\001\032\0030´\001H\026J\024\020µ\001\032\0030¶\0012\b\020\001\032\0030\001H\026J.\020·\001\032\0030¸\0012\007\020¹\001\032\0020&2\007\020º\001\032\0020&2\007\020»\001\032\0020&2\007\020¼\001\032\0020&H\026J5\020½\001\032\0030¾\0012\n\020¿\001\032\005\030\0010À\0012\007\020Á\001\032\0020&2\n\020Â\001\032\005\030\0010¯\0012\b\020Ã\001\032\0030Ä\001H\026J\024\020Å\001\032\0030\0012\b\020Æ\001\032\0030Ç\001H\026J\024\020È\001\032\0030É\0012\b\020Æ\001\032\0030Ê\001H\026J\023\020Ë\001\032\0020M2\b\020Æ\001\032\0030Ì\001H\026J\n\020Í\001\032\0030Î\001H\026J\024\020Ï\001\032\0030\0012\b\020Æ\001\032\0030Ð\001H\026J\024\020Ñ\001\032\0030Ò\0012\b\020Æ\001\032\0030Ó\001H\026J\024\020Ô\001\032\0030Õ\0012\b\020Æ\001\032\0030Ö\001H\026J\024\020×\001\032\0030Ø\0012\b\020Æ\001\032\0030Ù\001H\026J\024\020Ú\001\032\0030´\0012\b\020Æ\001\032\0030Û\001H\026J\025\020Ü\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ß\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020à\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020á\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020â\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ã\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ä\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020å\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020æ\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ç\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020è\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020é\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ê\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ë\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ì\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020í\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020î\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ï\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ð\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ñ\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ò\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ó\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ô\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020õ\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ö\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020÷\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ø\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ù\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ú\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020û\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ü\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ý\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020þ\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ÿ\001\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020 \002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¡\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¢\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020£\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¤\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¥\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¦\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020§\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¨\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020©\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020ª\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020«\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¬\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020­\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020®\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¯\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020°\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020±\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020²\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020³\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020´\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020µ\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¶\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020·\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¸\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¹\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020º\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020»\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¼\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020½\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¾\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020¿\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\025\020À\002\032\0020=2\n\020Ý\001\032\005\030\0010Þ\001H\026J\035\020Á\002\032\0030Â\0022\007\020¹\001\032\0020&2\b\020Ã\002\032\0030Ä\002H\026J\024\020Å\002\032\0030\0012\b\020Æ\002\032\0030Ç\002H\026J\024\020È\002\032\0030\0012\b\020É\002\032\0030Ê\002H\026JI\020Ë\002\032\0030Â\0022\b\020Ì\002\032\0030Í\0022\b\020\001\032\0030\0012\006\020}\032\0020\0352\006\020~\032\0020\0352\007\020Î\002\032\0020\0352\007\020Ï\002\032\0020\0352\007\020Ð\002\032\0020\035H\026R\024\020\003\032\0020\0048VX\004¢\006\006\032\004\b\005\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\n¨\006Ñ\002"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;", "Lnet/ccbluex/liquidbounce/api/IClassProvider;", "()V", "jsonToNBTInstance", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/IJsonToNBT;", "getJsonToNBTInstance", "()Lnet/ccbluex/liquidbounce/api/minecraft/nbt/IJsonToNBT;", "tessellatorInstance", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/ITessellator;", "getTessellatorInstance", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/ITessellator;", "createAxisAlignedBB", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "minX", "", "minY", "minZ", "maxX", "maxY", "maxZ", "createCPacketAnimation", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;", "createCPacketClientStatus", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus;", "state", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus$WEnumState;", "createCPacketCloseWindow", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCloseWindow;", "windowId", "", "createCPacketCreativeInventoryAction", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "slot", "itemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "createCPacketCustomPayload", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCustomPayload;", "channel", "", "payload", "Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "createCPacketEncryptionResponse", "secretKey", "Ljavax/crypto/SecretKey;", "publicKey", "Ljava/security/PublicKey;", "verifyToken", "", "createCPacketEntityAction", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;", "player", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "wAction", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;", "createCPacketHeldItemChange", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;", "createCPacketKeepAlive", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketKeepAlive;", "createCPacketPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "onGround", "", "createCPacketPlayerBlockPlacement", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;", "stack", "positionIn", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "placedBlockDirectionIn", "stackIn", "facingXIn", "", "facingYIn", "facingZIn", "createCPacketPlayerDigging", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;", "pos", "facing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "createCPacketPlayerLook", "yaw", "pitch", "createCPacketPlayerPosLook", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerPosLook;", "x", "y", "z", "createCPacketPlayerPosition", "createCPacketTabComplete", "text", "createCPacketTryUseItem", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "hand", "Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;", "createCPacketUseEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "entity", "positionVector", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "createChatComponentText", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "createClickEvent", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;", "action", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent$WAction;", "value", "createDynamicTexture", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/IDynamicTexture;", "image", "Ljava/awt/image/BufferedImage;", "createEntityLightningBolt", "world", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "posX", "posY", "posZ", "effectOnly", "createEntityOtherPlayerMP", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "gameProfile", "Lcom/mojang/authlib/GameProfile;", "createGuiButton", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "id", "width", "height", "createGuiConnecting", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "parent", "mc", "Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "serverData", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "createGuiModList", "parentScreen", "createGuiMultiplayer", "createGuiOptions", "gameSettings", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "createGuiPasswordField", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiTextField;", "iFontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "createGuiSelectWorld", "createGuiTextField", "createICPacketResourcePackStatus", "hash", "status", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketResourcePackStatus$WAction;", "createItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "createItemStack", "blockEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "item", "amount", "meta", "createNBTTagCompound", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "createNBTTagDouble", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagDouble;", "createNBTTagList", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "createNBTTagString", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagString;", "string", "createPacketBuffer", "buffer", "Lio/netty/buffer/ByteBuf;", "createPotionEffect", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "time", "strength", "createResourceLocation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "resourceName", "createSafeVertexBuffer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/vertex/IVertexBuffer;", "vertexFormat", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "createScaledResolution", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;", "createSession", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "name", "uuid", "accessToken", "accountType", "createThreadDownloadImageData", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IThreadDownloadImageData;", "cacheFileIn", "Ljava/io/File;", "imageUrlIn", "textureResourceLocation", "imageBufferIn", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/WIImageBuffer;", "getBlockEnum", "type", "Lnet/ccbluex/liquidbounce/api/enums/BlockType;", "getEnchantmentEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;", "getEnumFacing", "Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;", "getGlStateManager", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;", "getItemEnum", "Lnet/ccbluex/liquidbounce/api/enums/ItemType;", "getMaterialEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "Lnet/ccbluex/liquidbounce/api/enums/MaterialType;", "getPotionEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;", "getStatEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/stats/IStatBase;", "Lnet/ccbluex/liquidbounce/api/enums/StatType;", "getVertexFormatEnum", "Lnet/ccbluex/liquidbounce/api/enums/WDefaultVertexFormats;", "isBlockAir", "obj", "", "isBlockBedrock", "isBlockBush", "isBlockCactus", "isBlockCarpet", "isBlockFence", "isBlockLadder", "isBlockLiquid", "isBlockPane", "isBlockSlab", "isBlockSlime", "isBlockSnow", "isBlockStairs", "isBlockVine", "isCPacketAnimation", "isCPacketChatMessage", "isCPacketClientStatus", "isCPacketCloseWindow", "isCPacketConfirmTransaction", "isCPacketCustomPayload", "isCPacketEntityAction", "isCPacketHandshake", "isCPacketHeldItemChange", "isCPacketKeepAlive", "isCPacketPlayer", "isCPacketPlayerBlockPlacement", "isCPacketPlayerDigging", "isCPacketPlayerLook", "isCPacketPlayerPosLook", "isCPacketPlayerPosition", "isCPacketTryUseItem", "isCPacketUseEntity", "isClickGui", "isEntityAnimal", "isEntityArmorStand", "isEntityArrow", "isEntityBat", "isEntityBoat", "isEntityDragon", "isEntityFallingBlock", "isEntityFireball", "isEntityGhast", "isEntityGolem", "isEntityItem", "isEntityLivingBase", "isEntityMinecart", "isEntityMinecartChest", "isEntityMob", "isEntityPlayer", "isEntityShulker", "isEntitySlime", "isEntitySquid", "isEntityTNTPrimed", "isEntityVillager", "isGuiChat", "isGuiChest", "isGuiContainer", "isGuiGameOver", "isGuiHudDesigner", "isGuiIngameMenu", "isGuiInventory", "isItemAir", "isItemAppleGold", "isItemArmor", "isItemAxe", "isItemBed", "isItemBlock", "isItemBoat", "isItemBow", "isItemBucket", "isItemBucketMilk", "isItemEgg", "isItemEnchantedBook", "isItemEnderPearl", "isItemFishingRod", "isItemFood", "isItemMinecart", "isItemPickaxe", "isItemPotion", "isItemSnowball", "isItemSword", "isItemTool", "isSPacketAnimation", "isSPacketChat", "isSPacketCloseWindow", "isSPacketEntity", "isSPacketEntityVelocity", "isSPacketExplosion", "isSPacketPlayerPosLook", "isSPacketResourcePackSend", "isSPacketTabComplete", "isSPacketTimeUpdate", "isSPacketWindowItems", "isTileEntityChest", "isTileEntityDispenser", "isTileEntityEnderChest", "isTileEntityFurnace", "isTileEntityHopper", "isTileEntityShulkerBox", "wrapCreativeTab", "", "wrappedCreativeTabs", "Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "wrapFontRenderer", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;", "wrapGuiScreen", "clickGui", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "wrapGuiSlot", "wrappedGuiSlot", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "top", "bottom", "slotHeight", "XSJClient"})
/*     */ public final class ClassProviderImpl implements IClassProvider {
/*     */   public static final ClassProviderImpl INSTANCE;
/*     */   
/* 104 */   static { ClassProviderImpl classProviderImpl = new ClassProviderImpl(); }
/*     */   @NotNull
/* 106 */   public ITessellator getTessellatorInstance() { Intrinsics.checkExpressionValueIsNotNull(Tessellator.func_178181_a(), "Tessellator.getInstance()"); return new TessellatorImpl(Tessellator.func_178181_a()); }
/*     */   @NotNull
/* 108 */   public IJsonToNBT getJsonToNBTInstance() { return JsonToNBTImpl.INSTANCE; } @NotNull
/*     */   public IResourceLocation createResourceLocation(@NotNull String resourceName) {
/* 110 */     Intrinsics.checkParameterIsNotNull(resourceName, "resourceName"); return new ResourceLocationImpl(new ResourceLocation(resourceName));
/*     */   }
/*     */   @NotNull
/* 113 */   public IThreadDownloadImageData createThreadDownloadImageData(@Nullable File cacheFileIn, @NotNull String imageUrlIn, @Nullable IResourceLocation textureResourceLocation, @NotNull WIImageBuffer imageBufferIn) { Intrinsics.checkParameterIsNotNull(imageUrlIn, "imageUrlIn"); Intrinsics.checkParameterIsNotNull(imageBufferIn, "imageBufferIn"); IResourceLocation iResourceLocation = textureResourceLocation; String str1 = imageUrlIn; File file1 = cacheFileIn; int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 597 */     if (iResourceLocation == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ResourceLocationImpl");  ResourceLocation resourceLocation1 = ((ResourceLocationImpl)iResourceLocation).getWrapped(); ClassProviderImpl$createThreadDownloadImageData$1 classProviderImpl$createThreadDownloadImageData$1 = new ClassProviderImpl$createThreadDownloadImageData$1(imageBufferIn); ResourceLocation resourceLocation2 = (textureResourceLocation != null) ? resourceLocation1 : null; String str2 = imageUrlIn; File file2 = cacheFileIn; ThreadDownloadImageData threadDownloadImageData = new ThreadDownloadImageData(file2, str2, resourceLocation2, classProviderImpl$createThreadDownloadImageData$1); return new ThreadDownloadImageDataImpl<>(threadDownloadImageData); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000*\001\000\b\n\030\0002\0020\001J\024\020\002\032\004\030\0010\0032\b\020\004\032\004\030\0010\003H\026J\b\020\005\032\0020\006H\026¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl$createThreadDownloadImageData$1", "Lnet/minecraft/client/renderer/IImageBuffer;", "parseUserSkin", "Ljava/awt/image/BufferedImage;", "image", "skinAvailable", "", "XSJClient"}) public static final class ClassProviderImpl$createThreadDownloadImageData$1 implements IImageBuffer {
/*     */     ClassProviderImpl$createThreadDownloadImageData$1(WIImageBuffer $captured_local_variable$0) {} @Nullable public BufferedImage func_78432_a(@Nullable BufferedImage image) { return this.$imageBufferIn.parseUserSkin(image); } public void func_152634_a() { this.$imageBufferIn.skinAvailable(); } } @NotNull public IPacketBuffer createPacketBuffer(@NotNull ByteBuf buffer) { Intrinsics.checkParameterIsNotNull(buffer, "buffer"); return new PacketBufferImpl(new PacketBuffer(buffer)); } public boolean isEntityFireball(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.projectile.EntityFireball); } @NotNull public IIChatComponent createChatComponentText(@NotNull String text) { Intrinsics.checkParameterIsNotNull(text, "text"); return new IChatComponentImpl((ITextComponent)new TextComponentString(text)); }
/*     */   @NotNull public IClickEvent createClickEvent(@NotNull IClickEvent.WAction action, @NotNull String value) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'action'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_2
/*     */     //   8: ldc_w 'value'
/*     */     //   11: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   14: aload_1
/*     */     //   15: astore_3
/*     */     //   16: iconst_0
/*     */     //   17: istore #4
/*     */     //   19: aload_3
/*     */     //   20: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$11 : [I
/*     */     //   23: swap
/*     */     //   24: invokevirtual ordinal : ()I
/*     */     //   27: iaload
/*     */     //   28: tableswitch default -> 54, 1 -> 48
/*     */     //   48: getstatic net/minecraft/util/text/event/ClickEvent$Action.OPEN_URL : Lnet/minecraft/util/text/event/ClickEvent$Action;
/*     */     //   51: goto -> 62
/*     */     //   54: new kotlin/NoWhenBranchMatchedException
/*     */     //   57: dup
/*     */     //   58: invokespecial <init> : ()V
/*     */     //   61: athrow
/*     */     //   62: astore #9
/*     */     //   64: aload #9
/*     */     //   66: aload_2
/*     */     //   67: astore #10
/*     */     //   69: astore #11
/*     */     //   71: new net/minecraft/util/text/event/ClickEvent
/*     */     //   74: dup
/*     */     //   75: aload #11
/*     */     //   77: aload #10
/*     */     //   79: invokespecial <init> : (Lnet/minecraft/util/text/event/ClickEvent$Action;Ljava/lang/String;)V
/*     */     //   82: astore #12
/*     */     //   84: new net/ccbluex/liquidbounce/injection/backend/ClickEventImpl
/*     */     //   87: dup
/*     */     //   88: aload #12
/*     */     //   90: invokespecial <init> : (Lnet/minecraft/util/text/event/ClickEvent;)V
/*     */     //   93: checkcast net/ccbluex/liquidbounce/api/minecraft/event/IClickEvent
/*     */     //   96: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #124	-> 14
/*     */     //   #598	-> 19
/*     */     //   #599	-> 48
/*     */     //   #124	-> 66
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   16	46	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent$WAction;
/*     */     //   19	43	4	$i$f$unwrap	I
/*     */     //   0	97	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	97	1	action	Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent$WAction;
/*     */     //   0	97	2	value	Ljava/lang/String; }
/* 600 */   @NotNull public IGuiTextField createGuiTextField(int id, @NotNull IFontRenderer iFontRenderer, int x, int y, int width, int height) { Intrinsics.checkParameterIsNotNull(iFontRenderer, "iFontRenderer"); IFontRenderer iFontRenderer1 = iFontRenderer; int i = id, $i$f$unwrap = 0; FontRenderer fontRenderer1 = ((FontRendererImpl)iFontRenderer1).getWrapped(); int j = height, k = width, m = y, n = x; FontRenderer fontRenderer2 = fontRenderer1; int i1 = i; GuiTextField guiTextField = new GuiTextField(i1, fontRenderer2, n, m, k, j); return new GuiTextFieldImpl(guiTextField); } @NotNull public IGuiTextField createGuiPasswordField(int id, @NotNull IFontRenderer iFontRenderer, int x, int y, int width, int height) { Intrinsics.checkParameterIsNotNull(iFontRenderer, "iFontRenderer"); IFontRenderer iFontRenderer1 = iFontRenderer; int i = id, $i$f$unwrap = 0;
/* 601 */     FontRenderer fontRenderer1 = ((FontRendererImpl)iFontRenderer1).getWrapped(); int j = height, k = width, m = y, n = x; FontRenderer fontRenderer2 = fontRenderer1; int i1 = i; GuiTextField guiTextField = (GuiTextField)new GuiPasswordField(i1, fontRenderer2, n, m, k, j); return new GuiTextFieldImpl(guiTextField); } @NotNull public IGuiButton createGuiButton(int id, int x, int y, int width, int height, @NotNull String text) { Intrinsics.checkParameterIsNotNull(text, "text"); return new GuiButtonImpl(new GuiButton(id, x, y, width, height, text)); } @NotNull public IGuiButton createGuiButton(int id, int x, int y, @NotNull String text) { Intrinsics.checkParameterIsNotNull(text, "text"); return new GuiButtonImpl(new GuiButton(id, x, y, text)); } @NotNull public ISession createSession(@NotNull String name, @NotNull String uuid, @NotNull String accessToken, @NotNull String accountType) { Intrinsics.checkParameterIsNotNull(name, "name"); Intrinsics.checkParameterIsNotNull(uuid, "uuid"); Intrinsics.checkParameterIsNotNull(accessToken, "accessToken"); Intrinsics.checkParameterIsNotNull(accountType, "accountType"); return new SessionImpl(new Session(name, uuid, accessToken, accountType)); } @NotNull public IDynamicTexture createDynamicTexture(@NotNull BufferedImage image) { Intrinsics.checkParameterIsNotNull(image, "image"); return new DynamicTextureImpl<>(new DynamicTexture(image)); } @NotNull public IItem createItem() { return new ItemImpl<>(new Item()); }
/* 602 */   @NotNull public IItemStack createItemStack(@NotNull IItem item, int amount, int meta) { Intrinsics.checkParameterIsNotNull(item, "item"); IItem $this$unwrap$iv = item; int $i$f$unwrap = 0; Item item1 = (Item)((ItemImpl<Object>)$this$unwrap$iv).getWrapped(); int i = meta, j = amount; Item item2 = item1; ItemStack itemStack = new ItemStack(item2, j, i); return new ItemStackImpl(itemStack); } @NotNull public IEntity createEntityLightningBolt(@NotNull IWorld world, double posX, double posY, double posZ, boolean effectOnly) { Intrinsics.checkParameterIsNotNull(world, "world"); IWorld $this$unwrap$iv = world; int $i$f$unwrap = 0;
/* 603 */     World world1 = (World)((WorldImpl<Object>)$this$unwrap$iv).getWrapped(); boolean bool = effectOnly; double d1 = posZ, d2 = posY, d3 = posX; World world2 = world1; Entity $this$wrap$iv = (Entity)new EntityLightningBolt(world2, d3, d2, d1, bool); int $i$f$wrap = 0;
/* 604 */     return new EntityImpl<>($this$wrap$iv); } @NotNull public IItemStack createItemStack(@NotNull IItem item) { Intrinsics.checkParameterIsNotNull(item, "item"); IItem $this$unwrap$iv = item; int $i$f$unwrap = 0;
/* 605 */     Item item1 = (Item)((ItemImpl<Object>)$this$unwrap$iv).getWrapped(); Item item2 = item1; ItemStack itemStack = new ItemStack(item2); return new ItemStackImpl(itemStack); } @NotNull public IItemStack createItemStack(@NotNull IBlock blockEnum) { Intrinsics.checkParameterIsNotNull(blockEnum, "blockEnum"); IBlock $this$unwrap$iv = blockEnum; int $i$f$unwrap = 0;
/* 606 */     Block block1 = ((BlockImpl)$this$unwrap$iv).getWrapped(); Block block2 = block1; ItemStack itemStack = new ItemStack(block2); return new ItemStackImpl(itemStack); } @NotNull public IAxisAlignedBB createAxisAlignedBB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) { return new AxisAlignedBBImpl(new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ)); }
/* 607 */   @NotNull public IScaledResolution createScaledResolution(@NotNull IMinecraft mc) { Intrinsics.checkParameterIsNotNull(mc, "mc"); IMinecraft $this$unwrap$iv = mc; int $i$f$unwrap = 0; Minecraft minecraft1 = ((MinecraftImpl)$this$unwrap$iv).getWrapped(); Minecraft minecraft2 = minecraft1; ScaledResolution scaledResolution = new ScaledResolution(minecraft2); return new ScaledResolutionImpl(scaledResolution); } @NotNull public INBTTagCompound createNBTTagCompound() { return new NBTTagCompoundImpl(new NBTTagCompound()); } @NotNull public INBTTagList createNBTTagList() { return new NBTTagListImpl(new NBTTagList()); } @NotNull public INBTTagString createNBTTagString(@NotNull String string) { Intrinsics.checkParameterIsNotNull(string, "string"); return new NBTTagStringImpl<>(new NBTTagString(string)); } @NotNull public INBTTagDouble createNBTTagDouble(double value) { return new NBTTagDoubleImpl<>(new NBTTagDouble(value)); }
/* 608 */   @NotNull public IEntityOtherPlayerMP createEntityOtherPlayerMP(@NotNull IWorldClient world, @NotNull GameProfile gameProfile) { Intrinsics.checkParameterIsNotNull(world, "world"); Intrinsics.checkParameterIsNotNull(gameProfile, "gameProfile"); IWorldClient $this$unwrap$iv = world; int $i$f$unwrap = 0; WorldClient worldClient = ((WorldClientImpl)$this$unwrap$iv).getWrapped(); GameProfile gameProfile1 = gameProfile; World world1 = (World)worldClient; EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(world1, gameProfile1); return new EntityOtherPlayerMPImpl<>(entityOtherPlayerMP); } @NotNull public IPotionEffect createPotionEffect(int id, int time, int strength) { return new PotionEffectImpl(new PotionEffect(Potion.func_188412_a(id), time, strength)); }
/* 609 */   @NotNull public IGuiScreen createGuiOptions(@NotNull IGuiScreen parentScreen, @NotNull IGameSettings gameSettings) { Intrinsics.checkParameterIsNotNull(parentScreen, "parentScreen"); Intrinsics.checkParameterIsNotNull(gameSettings, "gameSettings"); IGuiScreen $this$unwrap$iv = parentScreen; int $i$f$unwrap = 0; GuiScreen guiScreen1 = ((GuiScreenImpl<GuiScreen>)$this$unwrap$iv).getWrapped(); IGameSettings iGameSettings = gameSettings; guiScreen1 = guiScreen1; $i$f$unwrap = 0;
/* 610 */     GameSettings gameSettings1 = ((GameSettingsImpl)iGameSettings).getWrapped(); GameSettings gameSettings2 = gameSettings1; GuiScreen guiScreen2 = guiScreen1, guiScreen3 = (GuiScreen)new GuiOptions(guiScreen2, gameSettings2); return new GuiScreenImpl<>(guiScreen3); } @NotNull public IGuiScreen createGuiSelectWorld(@NotNull IGuiScreen parentScreen) { Intrinsics.checkParameterIsNotNull(parentScreen, "parentScreen"); IGuiScreen $this$unwrap$iv = parentScreen; int $i$f$unwrap = 0;
/* 611 */     GuiScreen guiScreen1 = ((GuiScreenImpl<GuiScreen>)$this$unwrap$iv).getWrapped(); GuiScreen guiScreen2 = guiScreen1, guiScreen3 = (GuiScreen)new GuiWorldSelection(guiScreen2); return new GuiScreenImpl<>(guiScreen3); } @NotNull public IGuiScreen createGuiMultiplayer(@NotNull IGuiScreen parentScreen) { Intrinsics.checkParameterIsNotNull(parentScreen, "parentScreen"); IGuiScreen $this$unwrap$iv = parentScreen; int $i$f$unwrap = 0;
/* 612 */     GuiScreen guiScreen1 = ((GuiScreenImpl<GuiScreen>)$this$unwrap$iv).getWrapped(); GuiScreen guiScreen2 = guiScreen1, guiScreen3 = (GuiScreen)new GuiMultiplayer(guiScreen2); return new GuiScreenImpl<>(guiScreen3); } @NotNull public IGuiScreen createGuiModList(@NotNull IGuiScreen parentScreen) { Intrinsics.checkParameterIsNotNull(parentScreen, "parentScreen"); IGuiScreen $this$unwrap$iv = parentScreen; int $i$f$unwrap = 0;
/* 613 */     GuiScreen guiScreen1 = ((GuiScreenImpl<GuiScreen>)$this$unwrap$iv).getWrapped(); GuiScreen guiScreen2 = guiScreen1, guiScreen3 = (GuiScreen)new GuiModList(guiScreen2); return new GuiScreenImpl<>(guiScreen3); } @NotNull public IGuiScreen createGuiConnecting(@NotNull IGuiScreen parent, @NotNull IMinecraft mc, @NotNull IServerData serverData) { Intrinsics.checkParameterIsNotNull(parent, "parent"); Intrinsics.checkParameterIsNotNull(mc, "mc"); Intrinsics.checkParameterIsNotNull(serverData, "serverData"); IGuiScreen $this$unwrap$iv = parent; int $i$f$unwrap = 0;
/* 614 */     GuiScreen guiScreen1 = ((GuiScreenImpl<GuiScreen>)$this$unwrap$iv).getWrapped(); IMinecraft iMinecraft = mc; guiScreen1 = guiScreen1; $i$f$unwrap = 0;
/* 615 */     Minecraft minecraft1 = ((MinecraftImpl)iMinecraft).getWrapped(); IServerData iServerData = serverData; minecraft1 = minecraft1; guiScreen1 = guiScreen1; $i$f$unwrap = 0;
/* 616 */     ServerData serverData1 = ((ServerDataImpl)iServerData).getWrapped(); ServerData serverData2 = serverData1; Minecraft minecraft2 = minecraft1; GuiScreen guiScreen2 = guiScreen1, guiScreen3 = (GuiScreen)new GuiConnecting(guiScreen2, minecraft2, serverData2); return new GuiScreenImpl<>(guiScreen3); } @NotNull public ICPacketHeldItemChange createCPacketHeldItemChange(int slot) { return new CPacketHeldItemChangeImpl<>(new CPacketHeldItemChange(slot)); }
/* 617 */   @NotNull public ICPacketPlayerBlockPlacement createCPacketPlayerBlockPlacement(@Nullable IItemStack stack) { Backend this_$iv = Backend.INSTANCE; int $i$f$BACKEND_UNSUPPORTED = 0; throw (Throwable)new NotImplementedError("1.12.2 doesn't support this feature'"); } @NotNull public ICPacketPlayerBlockPlacement createCPacketPlayerBlockPlacement(@NotNull WBlockPos positionIn, int placedBlockDirectionIn, @Nullable IItemStack stackIn, float facingXIn, float facingYIn, float facingZIn) { Intrinsics.checkParameterIsNotNull(positionIn, "positionIn"); WBlockPos $this$unwrap$iv = positionIn; int $i$f$unwrap = 0;
/* 618 */     BlockPos blockPos1 = new BlockPos($this$unwrap$iv.getX(), $this$unwrap$iv.getY(), $this$unwrap$iv.getZ()); float f1 = facingZIn, f2 = facingYIn, f3 = facingXIn; EnumHand enumHand = EnumHand.MAIN_HAND; EnumFacing enumFacing = EnumFacing.values()[placedBlockDirectionIn]; BlockPos blockPos2 = blockPos1;
/*     */     CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock = new CPacketPlayerTryUseItemOnBlock(blockPos2, enumFacing, enumHand, f3, f2, f1);
/*     */     return new CPacketPlayerBlockPlacementImpl<>(cPacketPlayerTryUseItemOnBlock); } @NotNull public ICPacketPlayerPosLook createCPacketPlayerPosLook(double x, double y, double z, float yaw, float pitch, boolean onGround) { return new CPacketPlayerPosLookImpl<>(new CPacketPlayer.PositionRotation(x, y, z, yaw, pitch, onGround)); }
/*     */   @NotNull public ICPacketClientStatus createCPacketClientStatus(@NotNull ICPacketClientStatus.WEnumState state) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'state'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_1
/*     */     //   8: astore_2
/*     */     //   9: iconst_0
/*     */     //   10: istore_3
/*     */     //   11: aload_2
/*     */     //   12: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$12 : [I
/*     */     //   15: swap
/*     */     //   16: invokevirtual ordinal : ()I
/*     */     //   19: iaload
/*     */     //   20: tableswitch default -> 82, 1 -> 48, 2 -> 54, 3 -> 60
/*     */     //   48: getstatic net/minecraft/network/play/client/CPacketClientStatus$State.PERFORM_RESPAWN : Lnet/minecraft/network/play/client/CPacketClientStatus$State;
/*     */     //   51: goto -> 90
/*     */     //   54: getstatic net/minecraft/network/play/client/CPacketClientStatus$State.REQUEST_STATS : Lnet/minecraft/network/play/client/CPacketClientStatus$State;
/*     */     //   57: goto -> 90
/*     */     //   60: getstatic net/ccbluex/liquidbounce/injection/backend/Backend.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/Backend;
/*     */     //   63: astore #4
/*     */     //   65: iconst_0
/*     */     //   66: istore #5
/*     */     //   68: new kotlin/NotImplementedError
/*     */     //   71: dup
/*     */     //   72: ldc_w '1.12.2 doesn't support this feature''
/*     */     //   75: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   78: checkcast java/lang/Throwable
/*     */     //   81: athrow
/*     */     //   82: new kotlin/NoWhenBranchMatchedException
/*     */     //   85: dup
/*     */     //   86: invokespecial <init> : ()V
/*     */     //   89: athrow
/*     */     //   90: astore #10
/*     */     //   92: aload #10
/*     */     //   94: astore #11
/*     */     //   96: new net/minecraft/network/play/client/CPacketClientStatus
/*     */     //   99: dup
/*     */     //   100: aload #11
/*     */     //   102: invokespecial <init> : (Lnet/minecraft/network/play/client/CPacketClientStatus$State;)V
/*     */     //   105: astore #12
/*     */     //   107: new net/ccbluex/liquidbounce/injection/backend/CPacketClientStatusImpl
/*     */     //   110: dup
/*     */     //   111: aload #12
/*     */     //   113: invokespecial <init> : (Lnet/minecraft/network/play/client/CPacketClientStatus;)V
/*     */     //   116: checkcast net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus
/*     */     //   119: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #181	-> 7
/*     */     //   #619	-> 11
/*     */     //   #620	-> 48
/*     */     //   #621	-> 54
/*     */     //   #622	-> 60
/*     */     //   #623	-> 68
/*     */     //   #181	-> 94
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   68	14	5	$i$f$BACKEND_UNSUPPORTED	I
/*     */     //   9	81	2	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus$WEnumState;
/*     */     //   11	79	3	$i$f$unwrap	I
/*     */     //   0	120	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	120	1	state	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus$WEnumState; }
/*     */   @NotNull public IPacket createCPacketPlayerDigging(@NotNull ICPacketPlayerDigging.WAction wAction, @NotNull WBlockPos pos, @NotNull IEnumFacing facing) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'wAction'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_2
/*     */     //   8: ldc_w 'pos'
/*     */     //   11: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   14: aload_3
/*     */     //   15: ldc_w 'facing'
/*     */     //   18: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   21: aload_1
/*     */     //   22: astore #4
/*     */     //   24: iconst_0
/*     */     //   25: istore #5
/*     */     //   27: aload #4
/*     */     //   29: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$10 : [I
/*     */     //   32: swap
/*     */     //   33: invokevirtual ordinal : ()I
/*     */     //   36: iaload
/*     */     //   37: tableswitch default -> 122, 1 -> 80, 2 -> 86, 3 -> 92, 4 -> 98, 5 -> 104, 6 -> 110, 7 -> 116
/*     */     //   80: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.START_DESTROY_BLOCK : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   83: goto -> 130
/*     */     //   86: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.ABORT_DESTROY_BLOCK : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   89: goto -> 130
/*     */     //   92: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.STOP_DESTROY_BLOCK : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   95: goto -> 130
/*     */     //   98: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.DROP_ALL_ITEMS : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   101: goto -> 130
/*     */     //   104: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.DROP_ITEM : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   107: goto -> 130
/*     */     //   110: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.RELEASE_USE_ITEM : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   113: goto -> 130
/*     */     //   116: getstatic net/minecraft/network/play/client/CPacketPlayerDigging$Action.SWAP_HELD_ITEMS : Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;
/*     */     //   119: goto -> 130
/*     */     //   122: new kotlin/NoWhenBranchMatchedException
/*     */     //   125: dup
/*     */     //   126: invokespecial <init> : ()V
/*     */     //   129: athrow
/*     */     //   130: astore #10
/*     */     //   132: aload #10
/*     */     //   134: aload_2
/*     */     //   135: astore #4
/*     */     //   137: astore #10
/*     */     //   139: iconst_0
/*     */     //   140: istore #5
/*     */     //   142: new net/minecraft/util/math/BlockPos
/*     */     //   145: dup
/*     */     //   146: aload #4
/*     */     //   148: invokevirtual getX : ()I
/*     */     //   151: aload #4
/*     */     //   153: invokevirtual getY : ()I
/*     */     //   156: aload #4
/*     */     //   158: invokevirtual getZ : ()I
/*     */     //   161: invokespecial <init> : (III)V
/*     */     //   164: astore #11
/*     */     //   166: aload #10
/*     */     //   168: aload #11
/*     */     //   170: aload_3
/*     */     //   171: astore #4
/*     */     //   173: astore #11
/*     */     //   175: astore #10
/*     */     //   177: iconst_0
/*     */     //   178: istore #5
/*     */     //   180: aload #4
/*     */     //   182: checkcast net/ccbluex/liquidbounce/injection/backend/EnumFacingImpl
/*     */     //   185: invokevirtual getWrapped : ()Lnet/minecraft/util/EnumFacing;
/*     */     //   188: astore #12
/*     */     //   190: aload #10
/*     */     //   192: aload #11
/*     */     //   194: aload #12
/*     */     //   196: astore #13
/*     */     //   198: astore #14
/*     */     //   200: astore #15
/*     */     //   202: new net/minecraft/network/play/client/CPacketPlayerDigging
/*     */     //   205: dup
/*     */     //   206: aload #15
/*     */     //   208: aload #14
/*     */     //   210: aload #13
/*     */     //   212: invokespecial <init> : (Lnet/minecraft/network/play/client/CPacketPlayerDigging$Action;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;)V
/*     */     //   215: checkcast net/minecraft/network/Packet
/*     */     //   218: astore #16
/*     */     //   220: new net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   223: dup
/*     */     //   224: aload #16
/*     */     //   226: invokespecial <init> : (Lnet/minecraft/network/Packet;)V
/*     */     //   229: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   232: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #183	-> 21
/*     */     //   #624	-> 27
/*     */     //   #625	-> 80
/*     */     //   #626	-> 86
/*     */     //   #627	-> 92
/*     */     //   #628	-> 98
/*     */     //   #629	-> 104
/*     */     //   #630	-> 110
/*     */     //   #631	-> 116
/*     */     //   #183	-> 134
/*     */     //   #632	-> 142
/*     */     //   #183	-> 170
/*     */     //   #633	-> 180
/*     */     //   #183	-> 196
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   24	106	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   27	103	5	$i$f$unwrap	I
/*     */     //   139	25	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   142	22	5	$i$f$unwrap	I
/*     */     //   177	11	4	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;
/*     */     //   180	8	5	$i$f$unwrap	I
/*     */     //   0	233	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	233	1	wAction	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;
/*     */     //   0	233	2	pos	Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;
/*     */     //   0	233	3	facing	Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing; }
/*     */   @NotNull public PacketImpl<?> createCPacketTryUseItem(@NotNull WEnumHand hand) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'hand'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_1
/*     */     //   8: astore_2
/*     */     //   9: iconst_0
/*     */     //   10: istore_3
/*     */     //   11: aload_2
/*     */     //   12: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$16 : [I
/*     */     //   15: swap
/*     */     //   16: invokevirtual ordinal : ()I
/*     */     //   19: iaload
/*     */     //   20: tableswitch default -> 56, 1 -> 44, 2 -> 50
/*     */     //   44: getstatic net/minecraft/util/EnumHand.MAIN_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   47: goto -> 64
/*     */     //   50: getstatic net/minecraft/util/EnumHand.OFF_HAND : Lnet/minecraft/util/EnumHand;
/*     */     //   53: goto -> 64
/*     */     //   56: new kotlin/NoWhenBranchMatchedException
/*     */     //   59: dup
/*     */     //   60: invokespecial <init> : ()V
/*     */     //   63: athrow
/*     */     //   64: astore #8
/*     */     //   66: aload #8
/*     */     //   68: astore #9
/*     */     //   70: new net/minecraft/network/play/client/CPacketPlayerTryUseItem
/*     */     //   73: dup
/*     */     //   74: aload #9
/*     */     //   76: invokespecial <init> : (Lnet/minecraft/util/EnumHand;)V
/*     */     //   79: checkcast net/minecraft/network/Packet
/*     */     //   82: astore #10
/*     */     //   84: new net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   87: dup
/*     */     //   88: aload #10
/*     */     //   90: invokespecial <init> : (Lnet/minecraft/network/Packet;)V
/*     */     //   93: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #185	-> 7
/*     */     //   #634	-> 11
/*     */     //   #635	-> 44
/*     */     //   #636	-> 50
/*     */     //   #185	-> 68
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   9	55	2	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;
/*     */     //   11	53	3	$i$f$unwrap	I
/*     */     //   0	94	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	94	1	hand	Lnet/ccbluex/liquidbounce/api/enums/WEnumHand; }
/*     */   @NotNull public ICPacketPlayer createCPacketPlayerPosition(double x, double y, double z, boolean onGround) { return new CPacketPlayerImpl<>((CPacketPlayer)new CPacketPlayer.Position(x, y, z, onGround)); }
/*     */   @NotNull public IPacket createICPacketResourcePackStatus(@NotNull String hash, @NotNull ICPacketResourcePackStatus.WAction status) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'hash'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_2
/*     */     //   8: ldc_w 'status'
/*     */     //   11: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   14: aload_2
/*     */     //   15: astore_3
/*     */     //   16: iconst_0
/*     */     //   17: istore #4
/*     */     //   19: aload_3
/*     */     //   20: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$13 : [I
/*     */     //   23: swap
/*     */     //   24: invokevirtual ordinal : ()I
/*     */     //   27: iaload
/*     */     //   28: tableswitch default -> 84, 1 -> 60, 2 -> 66, 3 -> 72, 4 -> 78
/*     */     //   60: getstatic net/minecraft/network/play/client/CPacketResourcePackStatus$Action.SUCCESSFULLY_LOADED : Lnet/minecraft/network/play/client/CPacketResourcePackStatus$Action;
/*     */     //   63: goto -> 92
/*     */     //   66: getstatic net/minecraft/network/play/client/CPacketResourcePackStatus$Action.DECLINED : Lnet/minecraft/network/play/client/CPacketResourcePackStatus$Action;
/*     */     //   69: goto -> 92
/*     */     //   72: getstatic net/minecraft/network/play/client/CPacketResourcePackStatus$Action.FAILED_DOWNLOAD : Lnet/minecraft/network/play/client/CPacketResourcePackStatus$Action;
/*     */     //   75: goto -> 92
/*     */     //   78: getstatic net/minecraft/network/play/client/CPacketResourcePackStatus$Action.ACCEPTED : Lnet/minecraft/network/play/client/CPacketResourcePackStatus$Action;
/*     */     //   81: goto -> 92
/*     */     //   84: new kotlin/NoWhenBranchMatchedException
/*     */     //   87: dup
/*     */     //   88: invokespecial <init> : ()V
/*     */     //   91: athrow
/*     */     //   92: astore #9
/*     */     //   94: aload #9
/*     */     //   96: astore #10
/*     */     //   98: new net/minecraft/network/play/client/CPacketResourcePackStatus
/*     */     //   101: dup
/*     */     //   102: aload #10
/*     */     //   104: invokespecial <init> : (Lnet/minecraft/network/play/client/CPacketResourcePackStatus$Action;)V
/*     */     //   107: checkcast net/minecraft/network/Packet
/*     */     //   110: astore #11
/*     */     //   112: new net/ccbluex/liquidbounce/injection/backend/PacketImpl
/*     */     //   115: dup
/*     */     //   116: aload #11
/*     */     //   118: invokespecial <init> : (Lnet/minecraft/network/Packet;)V
/*     */     //   121: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   124: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #189	-> 14
/*     */     //   #637	-> 19
/*     */     //   #638	-> 60
/*     */     //   #639	-> 66
/*     */     //   #640	-> 72
/*     */     //   #641	-> 78
/*     */     //   #189	-> 96
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   16	76	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketResourcePackStatus$WAction;
/*     */     //   19	73	4	$i$f$unwrap	I
/*     */     //   0	125	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	125	1	hash	Ljava/lang/String;
/*     */     //   0	125	2	status	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketResourcePackStatus$WAction; }
/*     */   @NotNull public ICPacketPlayer createCPacketPlayerLook(float yaw, float pitch, boolean onGround) { return new CPacketPlayerImpl<>((CPacketPlayer)new CPacketPlayer.Rotation(yaw, pitch, onGround)); }
/*     */   @NotNull public ICPacketUseEntity createCPacketUseEntity(@NotNull IEntity player, @NotNull ICPacketUseEntity.WAction wAction) { IEntity $this$unwrap$iv;
/*     */     Backend this_$iv;
/*     */     int $i$f$unwrap, $i$f$BACKEND_UNSUPPORTED;
/*     */     Entity entity1;
/*     */     EnumHand enumHand;
/*     */     Entity entity2;
/*     */     CPacketUseEntity cPacketUseEntity1;
/*     */     Entity entity3;
/*     */     CPacketUseEntity cPacketUseEntity2;
/*     */     Intrinsics.checkParameterIsNotNull(player, "player");
/*     */     Intrinsics.checkParameterIsNotNull(wAction, "wAction");
/*     */     switch (ClassProviderImpl$WhenMappings.$EnumSwitchMapping$0[wAction.ordinal()])
/*     */     { case 1:
/*     */         $this$unwrap$iv = player;
/*     */         $i$f$unwrap = 0;
/* 642 */         entity1 = (Entity)((EntityImpl<Object>)$this$unwrap$iv).getWrapped(); enumHand = EnumHand.MAIN_HAND; entity2 = entity1; cPacketUseEntity1 = new CPacketUseEntity(entity2, enumHand);
/* 643 */       case 2: $this$unwrap$iv = player; $i$f$unwrap = 0; entity1 = ((EntityImpl<Entity>)$this$unwrap$iv).getWrapped(); entity3 = entity1; cPacketUseEntity2 = new CPacketUseEntity(entity3);
/* 644 */       case 3: this_$iv = Backend.INSTANCE; $i$f$BACKEND_UNSUPPORTED = 0; throw (Throwable)new NotImplementedError("1.12.2 doesn't support this feature'"); }  throw new NoWhenBranchMatchedException(); } @NotNull public ICPacketUseEntity createCPacketUseEntity(@NotNull IEntity entity, @NotNull WVec3 positionVector) { Intrinsics.checkParameterIsNotNull(entity, "entity"); Intrinsics.checkParameterIsNotNull(positionVector, "positionVector"); IEntity $this$unwrap$iv = entity; int $i$f$unwrap = 0;
/* 645 */     Entity entity1 = (Entity)((EntityImpl<Object>)$this$unwrap$iv).getWrapped(); WVec3 wVec3 = positionVector; EnumHand enumHand1 = EnumHand.MAIN_HAND; entity1 = entity1; $i$f$unwrap = 0;
/* 646 */     Vec3d vec3d1 = new Vec3d(wVec3.getXCoord(), wVec3.getYCoord(), wVec3.getZCoord()); Vec3d vec3d2 = vec3d1; EnumHand enumHand2 = enumHand1; Entity entity2 = entity1; CPacketUseEntity cPacketUseEntity = new CPacketUseEntity(entity2, enumHand2, vec3d2); return new CPacketUseEntityImpl<>(cPacketUseEntity); } @NotNull public IPacket createCPacketCreativeInventoryAction(int slot, @NotNull IItemStack itemStack) { Intrinsics.checkParameterIsNotNull(itemStack, "itemStack"); IItemStack iItemStack = itemStack; int i = slot, $i$f$unwrap = 0;
/* 647 */     ItemStack itemStack1 = ((ItemStackImpl)iItemStack).getWrapped(); ItemStack itemStack2 = itemStack1; int j = i; Packet packet = (Packet)new CPacketCreativeInventoryAction(j, itemStack2); return new PacketImpl<>(packet); }
/*     */   @NotNull public ICPacketEntityAction createCPacketEntityAction(@NotNull IEntity player, @NotNull ICPacketEntityAction.WAction wAction) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'player'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_2
/*     */     //   8: ldc_w 'wAction'
/*     */     //   11: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   14: aload_1
/*     */     //   15: astore_3
/*     */     //   16: iconst_0
/*     */     //   17: istore #4
/*     */     //   19: aload_3
/*     */     //   20: checkcast net/ccbluex/liquidbounce/injection/backend/EntityImpl
/*     */     //   23: invokevirtual getWrapped : ()Lnet/minecraft/entity/Entity;
/*     */     //   26: astore #9
/*     */     //   28: aload #9
/*     */     //   30: aload_2
/*     */     //   31: astore_3
/*     */     //   32: astore #9
/*     */     //   34: iconst_0
/*     */     //   35: istore #4
/*     */     //   37: aload_3
/*     */     //   38: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$14 : [I
/*     */     //   41: swap
/*     */     //   42: invokevirtual ordinal : ()I
/*     */     //   45: iaload
/*     */     //   46: tableswitch default -> 120, 1 -> 84, 2 -> 90, 3 -> 96, 4 -> 102, 5 -> 108, 6 -> 114
/*     */     //   84: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SNEAKING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   87: goto -> 128
/*     */     //   90: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SNEAKING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   93: goto -> 128
/*     */     //   96: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SLEEPING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   99: goto -> 128
/*     */     //   102: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.START_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   105: goto -> 128
/*     */     //   108: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.STOP_SPRINTING : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   111: goto -> 128
/*     */     //   114: getstatic net/minecraft/network/play/client/CPacketEntityAction$Action.OPEN_INVENTORY : Lnet/minecraft/network/play/client/CPacketEntityAction$Action;
/*     */     //   117: goto -> 128
/*     */     //   120: new kotlin/NoWhenBranchMatchedException
/*     */     //   123: dup
/*     */     //   124: invokespecial <init> : ()V
/*     */     //   127: athrow
/*     */     //   128: astore #10
/*     */     //   130: aload #9
/*     */     //   132: aload #10
/*     */     //   134: astore #11
/*     */     //   136: astore #12
/*     */     //   138: new net/minecraft/network/play/client/CPacketEntityAction
/*     */     //   141: dup
/*     */     //   142: aload #12
/*     */     //   144: aload #11
/*     */     //   146: invokespecial <init> : (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/CPacketEntityAction$Action;)V
/*     */     //   149: astore #13
/*     */     //   151: new net/ccbluex/liquidbounce/injection/backend/CPacketEntityActionImpl
/*     */     //   154: dup
/*     */     //   155: aload #13
/*     */     //   157: invokespecial <init> : (Lnet/minecraft/network/play/client/CPacketEntityAction;)V
/*     */     //   160: checkcast net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction
/*     */     //   163: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #205	-> 14
/*     */     //   #648	-> 19
/*     */     //   #205	-> 30
/*     */     //   #649	-> 37
/*     */     //   #650	-> 84
/*     */     //   #651	-> 90
/*     */     //   #652	-> 96
/*     */     //   #653	-> 102
/*     */     //   #654	-> 108
/*     */     //   #655	-> 114
/*     */     //   #205	-> 134
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   16	10	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   19	7	4	$i$f$unwrap	I
/*     */     //   34	94	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   37	91	4	$i$f$unwrap	I
/*     */     //   0	164	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	164	1	player	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   0	164	2	wAction	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction; }
/*     */   @NotNull public ICPacketCloseWindow createCPacketCloseWindow(int windowId) { return new CPacketCloseWindowImpl<>(new CPacketCloseWindow(windowId)); }
/*     */   @NotNull public ICPacketCloseWindow createCPacketCloseWindow() { return new CPacketCloseWindowImpl<>(new CPacketCloseWindow()); }
/*     */   @NotNull public ICPacketPlayer createCPacketPlayer(boolean onGround) { return new CPacketPlayerImpl<>(new CPacketPlayer(onGround)); }
/*     */   @NotNull public IPacket createCPacketTabComplete(@NotNull String text) { Intrinsics.checkParameterIsNotNull(text, "text"); return new PacketImpl<>((Packet)new CPacketTabComplete(text, null, false)); }
/*     */   @NotNull public ICPacketAnimation createCPacketAnimation() { return new CPacketAnimationImpl<>(new CPacketAnimation(EnumHand.MAIN_HAND)); }
/*     */   @NotNull public ICPacketKeepAlive createCPacketKeepAlive() { return new CPacketKeepAliveImpl<>(new CPacketKeepAlive()); }
/*     */   public boolean isEntityAnimal(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.passive.EntityAnimal); }
/* 656 */   public boolean isEntitySquid(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.passive.EntitySquid); } public boolean isEntityBat(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.passive.EntityBat); } public boolean isEntityGolem(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.monster.EntityGolem); } public boolean isEntityMob(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.monster.EntityMob); } public boolean isEntityVillager(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.passive.EntityVillager); } public boolean isEntitySlime(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.monster.EntitySlime); } public boolean isEntityGhast(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.monster.EntityGhast); } public boolean isEntityDragon(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.boss.EntityDragon); } public boolean isEntityLivingBase(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.EntityLivingBase); } public boolean isEntityPlayer(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.player.EntityPlayer); } public boolean isEntityArmorStand(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityArmorStand); } public boolean isEntityTNTPrimed(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityTNTPrimed); } public boolean isEntityBoat(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityBoat); } public boolean isEntityMinecart(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityMinecart); } public boolean isEntityItem(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityItem); } public boolean isEntityArrow(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.projectile.EntityArrow); } public boolean isEntityFallingBlock(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityFallingBlock); } public boolean isEntityMinecartChest(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.item.EntityMinecartChest); } public boolean isEntityShulker(@Nullable Object obj) { return (obj instanceof EntityImpl && ((EntityImpl)obj).getWrapped() instanceof net.minecraft.entity.monster.EntityShulker); } public boolean isTileEntityChest(@Nullable Object obj) { return (obj instanceof TileEntityImpl && ((TileEntityImpl)obj).getWrapped() instanceof net.minecraft.tileentity.TileEntityChest); } public boolean isTileEntityEnderChest(@Nullable Object obj) { return (obj instanceof TileEntityImpl && ((TileEntityImpl)obj).getWrapped() instanceof net.minecraft.tileentity.TileEntityEnderChest); } public boolean isTileEntityFurnace(@Nullable Object obj) { return (obj instanceof TileEntityImpl && ((TileEntityImpl)obj).getWrapped() instanceof net.minecraft.tileentity.TileEntityFurnace); } public boolean isTileEntityDispenser(@Nullable Object obj) { return (obj instanceof TileEntityImpl && ((TileEntityImpl)obj).getWrapped() instanceof net.minecraft.tileentity.TileEntityDispenser); } public boolean isTileEntityHopper(@Nullable Object obj) { return (obj instanceof TileEntityImpl && ((TileEntityImpl)obj).getWrapped() instanceof net.minecraft.tileentity.TileEntityHopper); } public boolean isTileEntityShulkerBox(@Nullable Object obj) { return (obj instanceof TileEntityImpl && ((TileEntityImpl)obj).getWrapped() instanceof net.minecraft.tileentity.TileEntityShulkerBox); } public boolean isSPacketTimeUpdate(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketTimeUpdate); } public boolean isSPacketChat(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketChat); } public boolean isSPacketEntity(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketEntity); } public boolean isSPacketResourcePackSend(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketResourcePackSend); } public boolean isSPacketPlayerPosLook(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketPlayerPosLook); } public boolean isSPacketAnimation(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketAnimation); } public boolean isSPacketEntityVelocity(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketEntityVelocity); } public boolean isSPacketExplosion(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketEntityVelocity); } public boolean isSPacketCloseWindow(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketCloseWindow); } public boolean isSPacketTabComplete(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketTabComplete); } public boolean isCPacketPlayer(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketPlayer); } public boolean isCPacketPlayerBlockPlacement(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketPlayerTryUseItemOnBlock); } public boolean isCPacketUseEntity(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketUseEntity); } public boolean isCPacketCloseWindow(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketCloseWindow); } public boolean isCPacketChatMessage(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.client.CPacketChatMessage); } public boolean isCPacketKeepAlive(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketKeepAlive); } public boolean isCPacketPlayerPosition(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketPlayer.Position); } public boolean isCPacketPlayerPosLook(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketPlayer.PositionRotation); } public boolean isCPacketClientStatus(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.client.CPacketClientStatus); } public boolean isCPacketAnimation(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketAnimation); } public boolean isCPacketEntityAction(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.client.CPacketEntityAction); } @NotNull public ICPacketCustomPayload createCPacketCustomPayload(@NotNull String channel, @NotNull IPacketBuffer payload) { Intrinsics.checkParameterIsNotNull(channel, "channel"); Intrinsics.checkParameterIsNotNull(payload, "payload"); IPacketBuffer iPacketBuffer = payload; String str1 = channel; int $i$f$unwrap = 0; PacketBuffer packetBuffer1 = ((PacketBufferImpl)iPacketBuffer).getWrapped(); PacketBuffer packetBuffer2 = packetBuffer1; String str2 = str1; CPacketCustomPayload cPacketCustomPayload = new CPacketCustomPayload(str2, packetBuffer2); return new CPacketCustomPayloadImpl<>(cPacketCustomPayload); }
/*     */   public boolean isSPacketWindowItems(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.server.SPacketWindowItems); }
/*     */   public boolean isCPacketHeldItemChange(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketHeldItemChange); }
/*     */   public boolean isCPacketPlayerLook(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketPlayer.Rotation); }
/*     */   public boolean isCPacketCustomPayload(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof CPacketCustomPayload); }
/*     */   public boolean isCPacketHandshake(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.handshake.client.C00Handshake); }
/*     */   public boolean isCPacketPlayerDigging(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.client.CPacketPlayerDigging); }
/*     */   public boolean isCPacketTryUseItem(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.client.CPacketPlayerTryUseItem); }
/*     */   public boolean isItemSword(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemSword); }
/*     */   public boolean isItemTool(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemTool); }
/*     */   public boolean isItemArmor(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemArmor); }
/*     */   public boolean isItemPotion(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemPotion); }
/*     */   public boolean isItemBlock(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemBlock); }
/*     */   public boolean isItemBow(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemBow); }
/*     */   public boolean isItemBucket(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemBucket); }
/*     */   public boolean isItemFood(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemFood); }
/*     */   public boolean isItemBucketMilk(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemBucketMilk); }
/*     */   public boolean isItemPickaxe(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemPickaxe); }
/*     */   public boolean isItemAxe(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemAxe); }
/*     */   public boolean isItemBed(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemBed); }
/*     */   public boolean isItemEnderPearl(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemEnderPearl); }
/*     */   public boolean isItemEnchantedBook(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemEnchantedBook); }
/*     */   public boolean isItemBoat(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemBoat); }
/*     */   public boolean isItemMinecart(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemMinecart); }
/*     */   public boolean isItemAppleGold(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemAppleGold); }
/*     */   public boolean isItemSnowball(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemSnowball); }
/*     */   public boolean isItemEgg(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemEgg); }
/*     */   public boolean isItemFishingRod(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemFishingRod); }
/*     */   public boolean isItemAir(@Nullable Object obj) { return (obj instanceof ItemImpl && ((ItemImpl)obj).getWrapped() instanceof net.minecraft.item.ItemAir); }
/*     */   public boolean isBlockAir(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockAir); }
/*     */   public boolean isBlockFence(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockFence); }
/*     */   public boolean isBlockSnow(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockSnow); }
/*     */   public boolean isBlockLadder(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockLadder); }
/*     */   public boolean isBlockVine(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockVine); }
/*     */   public boolean isBlockSlime(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockSlime); }
/*     */   public boolean isBlockSlab(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockSlab); }
/*     */   public boolean isBlockStairs(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockStairs); }
/*     */   public boolean isBlockCarpet(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockCarpet); }
/*     */   public boolean isBlockPane(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockPane); }
/*     */   public boolean isBlockLiquid(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockLiquid); }
/*     */   public boolean isBlockCactus(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockCactus); }
/*     */   public boolean isBlockBedrock(@Nullable Object obj) { return (obj instanceof BlockImpl && Intrinsics.areEqual(((BlockImpl)obj).getWrapped(), Blocks.field_150357_h)); }
/*     */   public boolean isBlockBush(@Nullable Object obj) { return (obj instanceof BlockImpl && ((BlockImpl)obj).getWrapped() instanceof net.minecraft.block.BlockBush); }
/*     */   public boolean isGuiInventory(@Nullable Object obj) { return (obj instanceof GuiImpl && ((GuiImpl)obj).getWrapped() instanceof net.minecraft.client.gui.inventory.GuiInventory); }
/*     */   public boolean isGuiContainer(@Nullable Object obj) { return (obj instanceof GuiImpl && ((GuiImpl)obj).getWrapped() instanceof net.minecraft.client.gui.inventory.GuiContainer); }
/*     */   public boolean isGuiGameOver(@Nullable Object obj) { return (obj instanceof GuiImpl && ((GuiImpl)obj).getWrapped() instanceof net.minecraft.client.gui.GuiGameOver); }
/*     */   public boolean isGuiChat(@Nullable Object obj) { return (obj instanceof GuiImpl && ((GuiImpl)obj).getWrapped() instanceof net.minecraft.client.gui.GuiChat); }
/*     */   public boolean isGuiIngameMenu(@Nullable Object obj) { return (obj instanceof GuiImpl && ((GuiImpl)obj).getWrapped() instanceof net.minecraft.client.gui.GuiIngameMenu); }
/*     */   public boolean isGuiChest(@Nullable Object obj) { return (obj instanceof GuiImpl && ((GuiImpl)obj).getWrapped() instanceof net.minecraft.client.gui.inventory.GuiChest); }
/*     */   public boolean isGuiHudDesigner(@Nullable Object obj) { return (obj instanceof GuiScreenImpl && ((GuiScreenImpl)obj).getWrapped() instanceof GuiScreenWrapper && ((GuiScreenWrapper)((GuiScreenImpl)obj).getWrapped()).getWrapped() instanceof net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner); }
/*     */   public boolean isClickGui(@Nullable Object obj) { return (obj instanceof GuiScreenImpl && ((GuiScreenImpl)obj).getWrapped() instanceof GuiScreenWrapper && ((GuiScreenWrapper)((GuiScreenImpl)obj).getWrapped()).getWrapped() instanceof net.ccbluex.liquidbounce.ui.client.clickgui.ClickGui); }
/*     */   public boolean isCPacketConfirmTransaction(@Nullable Object obj) { return (obj instanceof PacketImpl && ((PacketImpl)obj).getWrapped() instanceof net.minecraft.network.play.client.CPacketConfirmTransaction); }
/*     */   @NotNull public IPotion getPotionEnum(@NotNull PotionType type) { boolean bool; Intrinsics.checkParameterIsNotNull(type, "type"); switch (ClassProviderImpl$WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12: case 13: bool = false; throw (Throwable)new NotImplementedError(null, 1, null);case 14: case 15:  }  throw new NoWhenBranchMatchedException(); }
/*     */   @NotNull public IEnumFacing getEnumFacing(@NotNull EnumFacingType type) { Intrinsics.checkParameterIsNotNull(type, "type"); switch (ClassProviderImpl$WhenMappings.$EnumSwitchMapping$2[type.ordinal()]) { case 1: case 2: case 3: case 4: case 5: case 6:  }  throw new NoWhenBranchMatchedException(); } @NotNull public IBlock getBlockEnum(@NotNull BlockType type) { Block $this$wrap$iv; int $i$f$wrap; Intrinsics.checkParameterIsNotNull(type, "type"); switch (ClassProviderImpl$WhenMappings.$EnumSwitchMapping$3[type.ordinal()]) { case 1: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150381_bn, "Blocks.ENCHANTING_TABLE"); $this$wrap$iv = Blocks.field_150381_bn; $i$f$wrap = 0;case 2: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150486_ae, "Blocks.CHEST"); $this$wrap$iv = (Block)Blocks.field_150486_ae; $i$f$wrap = 0;case 3: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150477_bB, "Blocks.ENDER_CHEST"); $this$wrap$iv = Blocks.field_150477_bB; $i$f$wrap = 0;case 4: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150447_bR, "Blocks.TRAPPED_CHEST"); $this$wrap$iv = Blocks.field_150447_bR; $i$f$wrap = 0;case 5: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150467_bQ, "Blocks.ANVIL"); $this$wrap$iv = Blocks.field_150467_bQ; $i$f$wrap = 0;case 6: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150354_m, "Blocks.SAND"); $this$wrap$iv = (Block)Blocks.field_150354_m; $i$f$wrap = 0;case 7: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150321_G, "Blocks.WEB"); $this$wrap$iv = Blocks.field_150321_G; $i$f$wrap = 0;case 8: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150478_aa, "Blocks.TORCH"); $this$wrap$iv = Blocks.field_150478_aa; $i$f$wrap = 0;case 9: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150462_ai, "Blocks.CRAFTING_TABLE"); $this$wrap$iv = Blocks.field_150462_ai; $i$f$wrap = 0;case 10: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150460_al, "Blocks.FURNACE"); $this$wrap$iv = Blocks.field_150460_al; $i$f$wrap = 0;case 11: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150392_bi, "Blocks.WATERLILY"); $this$wrap$iv = Blocks.field_150392_bi; $i$f$wrap = 0;case 12: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150367_z, "Blocks.DISPENSER"); $this$wrap$iv = Blocks.field_150367_z; $i$f$wrap = 0;case 13: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150456_au, "Blocks.STONE_PRESSURE_PLATE"); $this$wrap$iv = Blocks.field_150456_au; $i$f$wrap = 0;case 14: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150452_aw, "Blocks.WOODEN_PRESSURE_PLATE"); $this$wrap$iv = Blocks.field_150452_aw; $i$f$wrap = 0;case 15: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150335_W, "Blocks.TNT"); $this$wrap$iv = Blocks.field_150335_W; $i$f$wrap = 0;case 16: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_180393_cK, "Blocks.STANDING_BANNER"); $this$wrap$iv = Blocks.field_180393_cK; $i$f$wrap = 0;case 17: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_180394_cL, "Blocks.WALL_BANNER"); $this$wrap$iv = Blocks.field_180394_cL; $i$f$wrap = 0;case 18: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150429_aA, "Blocks.REDSTONE_TORCH"); $this$wrap$iv = Blocks.field_150429_aA; $i$f$wrap = 0;case 19: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150323_B, "Blocks.NOTEBLOCK"); $this$wrap$iv = Blocks.field_150323_B; $i$f$wrap = 0;case 20: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150409_cd, "Blocks.DROPPER"); $this$wrap$iv = Blocks.field_150409_cd; $i$f$wrap = 0;case 21: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150431_aC, "Blocks.SNOW_LAYER"); $this$wrap$iv = Blocks.field_150431_aC; $i$f$wrap = 0;case 22: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150350_a, "Blocks.AIR"); $this$wrap$iv = Blocks.field_150350_a; $i$f$wrap = 0;case 23: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150403_cj, "Blocks.PACKED_ICE"); $this$wrap$iv = Blocks.field_150403_cj; $i$f$wrap = 0;case 24: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150432_aD, "Blocks.ICE"); $this$wrap$iv = Blocks.field_150432_aD; $i$f$wrap = 0;case 25: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150355_j, "Blocks.WATER"); $this$wrap$iv = (Block)Blocks.field_150355_j; $i$f$wrap = 0;case 26: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_180401_cv, "Blocks.BARRIER"); $this$wrap$iv = Blocks.field_180401_cv; $i$f$wrap = 0;case 27: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150358_i, "Blocks.FLOWING_WATER"); $this$wrap$iv = (Block)Blocks.field_150358_i; $i$f$wrap = 0;case 28: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150365_q, "Blocks.COAL_ORE"); $this$wrap$iv = Blocks.field_150365_q; $i$f$wrap = 0;case 29: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150366_p, "Blocks.IRON_ORE"); $this$wrap$iv = Blocks.field_150366_p; $i$f$wrap = 0;case 30: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150352_o, "Blocks.GOLD_ORE"); $this$wrap$iv = Blocks.field_150352_o; $i$f$wrap = 0;case 31: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150450_ax, "Blocks.REDSTONE_ORE"); $this$wrap$iv = Blocks.field_150450_ax; $i$f$wrap = 0;case 32: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150369_x, "Blocks.LAPIS_ORE"); $this$wrap$iv = Blocks.field_150369_x; $i$f$wrap = 0;case 33: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150482_ag, "Blocks.DIAMOND_ORE"); $this$wrap$iv = Blocks.field_150482_ag; $i$f$wrap = 0;case 34: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150412_bA, "Blocks.EMERALD_ORE"); $this$wrap$iv = Blocks.field_150412_bA; $i$f$wrap = 0;case 35: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150449_bY, "Blocks.QUARTZ_ORE"); $this$wrap$iv = Blocks.field_150449_bY; $i$f$wrap = 0;case 36: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150435_aG, "Blocks.CLAY"); $this$wrap$iv = Blocks.field_150435_aG; $i$f$wrap = 0;case 37: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150426_aN, "Blocks.GLOWSTONE"); $this$wrap$iv = Blocks.field_150426_aN; $i$f$wrap = 0;case 38: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150468_ap, "Blocks.LADDER"); $this$wrap$iv = Blocks.field_150468_ap; $i$f$wrap = 0;case 39: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150402_ci, "Blocks.COAL_BLOCK"); $this$wrap$iv = Blocks.field_150402_ci; $i$f$wrap = 0;case 40: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150339_S, "Blocks.IRON_BLOCK"); $this$wrap$iv = Blocks.field_150339_S; $i$f$wrap = 0;case 41: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150340_R, "Blocks.GOLD_BLOCK"); $this$wrap$iv = Blocks.field_150340_R; $i$f$wrap = 0;case 42: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150484_ah, "Blocks.DIAMOND_BLOCK"); $this$wrap$iv = Blocks.field_150484_ah; $i$f$wrap = 0;case 43: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150475_bE, "Blocks.EMERALD_BLOCK"); $this$wrap$iv = Blocks.field_150475_bE; $i$f$wrap = 0;case 44: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150451_bX, "Blocks.REDSTONE_BLOCK"); $this$wrap$iv = Blocks.field_150451_bX; $i$f$wrap = 0;case 45: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150368_y, "Blocks.LAPIS_BLOCK"); $this$wrap$iv = Blocks.field_150368_y; $i$f$wrap = 0;case 46: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150480_ab, "Blocks.FIRE"); $this$wrap$iv = (Block)Blocks.field_150480_ab; $i$f$wrap = 0;case 47: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150341_Y, "Blocks.MOSSY_COBBLESTONE"); $this$wrap$iv = Blocks.field_150341_Y; $i$f$wrap = 0;case 48: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150474_ac, "Blocks.MOB_SPAWNER"); $this$wrap$iv = Blocks.field_150474_ac; $i$f$wrap = 0;case 49: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150378_br, "Blocks.END_PORTAL_FRAME"); $this$wrap$iv = Blocks.field_150378_br; $i$f$wrap = 0;case 50: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150342_X, "Blocks.BOOKSHELF"); $this$wrap$iv = Blocks.field_150342_X; $i$f$wrap = 0;case 51: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150483_bI, "Blocks.COMMAND_BLOCK"); $this$wrap$iv = Blocks.field_150483_bI; $i$f$wrap = 0;case 52: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150353_l, "Blocks.LAVA"); $this$wrap$iv = (Block)Blocks.field_150353_l; $i$f$wrap = 0;case 53: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150356_k, "Blocks.FLOWING_LAVA"); $this$wrap$iv = (Block)Blocks.field_150356_k; $i$f$wrap = 0;
/*     */       case 54: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150470_am, "Blocks.LIT_FURNACE"); $this$wrap$iv = Blocks.field_150470_am; $i$f$wrap = 0;
/*     */       case 55: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150380_bt, "Blocks.DRAGON_EGG"); $this$wrap$iv = Blocks.field_150380_bt; $i$f$wrap = 0;
/*     */       case 56: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150420_aW, "Blocks.BROWN_MUSHROOM_BLOCK"); $this$wrap$iv = Blocks.field_150420_aW; $i$f$wrap = 0;
/*     */       case 57: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150419_aX, "Blocks.RED_MUSHROOM_BLOCK"); $this$wrap$iv = Blocks.field_150419_aX; $i$f$wrap = 0;
/* 714 */       case 58: Intrinsics.checkExpressionValueIsNotNull(Blocks.field_150458_ak, "Blocks.FARMLAND"); $this$wrap$iv = Blocks.field_150458_ak; $i$f$wrap = 0; }  throw new NoWhenBranchMatchedException(); } @NotNull public IMaterial getMaterialEnum(@NotNull MaterialType type) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'type'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: new net/ccbluex/liquidbounce/injection/backend/MaterialImpl
/*     */     //   10: dup
/*     */     //   11: aload_1
/*     */     //   12: getstatic net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl$WhenMappings.$EnumSwitchMapping$4 : [I
/*     */     //   15: swap
/*     */     //   16: invokevirtual ordinal : ()I
/*     */     //   19: iaload
/*     */     //   20: tableswitch default -> 66, 1 -> 48, 2 -> 54, 3 -> 60
/*     */     //   48: getstatic net/minecraft/block/material/Material.field_151579_a : Lnet/minecraft/block/material/Material;
/*     */     //   51: goto -> 74
/*     */     //   54: getstatic net/minecraft/block/material/Material.field_151586_h : Lnet/minecraft/block/material/Material;
/*     */     //   57: goto -> 74
/*     */     //   60: getstatic net/minecraft/block/material/Material.field_151587_i : Lnet/minecraft/block/material/Material;
/*     */     //   63: goto -> 74
/*     */     //   66: new kotlin/NoWhenBranchMatchedException
/*     */     //   69: dup
/*     */     //   70: invokespecial <init> : ()V
/*     */     //   73: athrow
/*     */     //   74: dup
/*     */     //   75: ldc_w 'when (type) {\\n          …al.LAVA\\n                }'
/*     */     //   78: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   81: invokespecial <init> : (Lnet/minecraft/block/material/Material;)V
/*     */     //   84: checkcast net/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial
/*     */     //   87: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #510	-> 7
/*     */     //   #511	-> 11
/*     */     //   #512	-> 48
/*     */     //   #513	-> 54
/*     */     //   #514	-> 60
/*     */     //   #511	-> 74
/*     */     //   #510	-> 81
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	88	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	88	1	type	Lnet/ccbluex/liquidbounce/api/enums/MaterialType; } @NotNull public IStatBase getStatEnum(@NotNull StatType type) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'type'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: new net/ccbluex/liquidbounce/injection/backend/StatBaseImpl
/*     */     //   10: dup
/*     */     //   11: aload_1
/*     */     //   12: getstatic net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl$WhenMappings.$EnumSwitchMapping$5 : [I
/*     */     //   15: swap
/*     */     //   16: invokevirtual ordinal : ()I
/*     */     //   19: iaload
/*     */     //   20: tableswitch default -> 46, 1 -> 40
/*     */     //   40: getstatic net/minecraft/stats/StatList.field_75953_u : Lnet/minecraft/stats/StatBase;
/*     */     //   43: goto -> 54
/*     */     //   46: new kotlin/NoWhenBranchMatchedException
/*     */     //   49: dup
/*     */     //   50: invokespecial <init> : ()V
/*     */     //   53: athrow
/*     */     //   54: dup
/*     */     //   55: ldc_w 'when (type) {\\n          …st.JUMP\\n                }'
/*     */     //   58: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   61: invokespecial <init> : (Lnet/minecraft/stats/StatBase;)V
/*     */     //   64: checkcast net/ccbluex/liquidbounce/api/minecraft/stats/IStatBase
/*     */     //   67: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #520	-> 7
/*     */     //   #521	-> 11
/*     */     //   #522	-> 40
/*     */     //   #521	-> 54
/*     */     //   #520	-> 61
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	68	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	68	1	type	Lnet/ccbluex/liquidbounce/api/enums/StatType; } @NotNull public IItem getItemEnum(@NotNull ItemType type) { Intrinsics.checkParameterIsNotNull(type, "type"); switch (ClassProviderImpl$WhenMappings.$EnumSwitchMapping$6[type.ordinal()]) { case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11:  }  throw new NoWhenBranchMatchedException(); } @NotNull public IEnchantment getEnchantmentEnum(@NotNull EnchantmentType type) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'type'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: new net/ccbluex/liquidbounce/injection/backend/EnchantmentImpl
/*     */     //   10: dup
/*     */     //   11: aload_1
/*     */     //   12: getstatic net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl$WhenMappings.$EnumSwitchMapping$7 : [I
/*     */     //   15: swap
/*     */     //   16: invokevirtual ordinal : ()I
/*     */     //   19: iaload
/*     */     //   20: tableswitch default -> 146, 1 -> 80, 2 -> 86, 3 -> 92, 4 -> 98, 5 -> 104, 6 -> 110, 7 -> 116, 8 -> 122, 9 -> 128, 10 -> 134, 11 -> 140
/*     */     //   80: getstatic net/minecraft/init/Enchantments.field_185302_k : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   83: goto -> 154
/*     */     //   86: getstatic net/minecraft/init/Enchantments.field_185309_u : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   89: goto -> 154
/*     */     //   92: getstatic net/minecraft/init/Enchantments.field_180310_c : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   95: goto -> 154
/*     */     //   98: getstatic net/minecraft/init/Enchantments.field_180309_e : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   101: goto -> 154
/*     */     //   104: getstatic net/minecraft/init/Enchantments.field_180308_g : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   107: goto -> 154
/*     */     //   110: getstatic net/minecraft/init/Enchantments.field_92091_k : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   113: goto -> 154
/*     */     //   116: getstatic net/minecraft/init/Enchantments.field_77329_d : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   119: goto -> 154
/*     */     //   122: getstatic net/minecraft/init/Enchantments.field_185298_f : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   125: goto -> 154
/*     */     //   128: getstatic net/minecraft/init/Enchantments.field_185299_g : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   131: goto -> 154
/*     */     //   134: getstatic net/minecraft/init/Enchantments.field_185297_d : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   137: goto -> 154
/*     */     //   140: getstatic net/minecraft/init/Enchantments.field_185307_s : Lnet/minecraft/enchantment/Enchantment;
/*     */     //   143: goto -> 154
/*     */     //   146: new kotlin/NoWhenBranchMatchedException
/*     */     //   149: dup
/*     */     //   150: invokespecial <init> : ()V
/*     */     //   153: athrow
/*     */     //   154: dup
/*     */     //   155: ldc_w 'when (type) {\\n          …REAKING\\n                }'
/*     */     //   158: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   161: invokespecial <init> : (Lnet/minecraft/enchantment/Enchantment;)V
/*     */     //   164: checkcast net/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment
/*     */     //   167: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #546	-> 7
/*     */     //   #547	-> 11
/*     */     //   #548	-> 80
/*     */     //   #549	-> 86
/*     */     //   #550	-> 92
/*     */     //   #551	-> 98
/*     */     //   #552	-> 104
/*     */     //   #553	-> 110
/*     */     //   #554	-> 116
/*     */     //   #555	-> 122
/*     */     //   #556	-> 128
/*     */     //   #557	-> 134
/*     */     //   #558	-> 140
/*     */     //   #547	-> 154
/*     */     //   #546	-> 161
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	168	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	168	1	type	Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType; } @NotNull public IVertexFormat getVertexFormatEnum(@NotNull WDefaultVertexFormats type) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'type'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: new net/ccbluex/liquidbounce/injection/backend/VertexFormatImpl
/*     */     //   10: dup
/*     */     //   11: aload_1
/*     */     //   12: getstatic net/ccbluex/liquidbounce/injection/backend/ClassProviderImpl$WhenMappings.$EnumSwitchMapping$8 : [I
/*     */     //   15: swap
/*     */     //   16: invokevirtual ordinal : ()I
/*     */     //   19: iaload
/*     */     //   20: tableswitch default -> 66, 1 -> 48, 2 -> 54, 3 -> 60
/*     */     //   48: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.field_181705_e : Lnet/minecraft/client/renderer/vertex/VertexFormat;
/*     */     //   51: goto -> 74
/*     */     //   54: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.field_181707_g : Lnet/minecraft/client/renderer/vertex/VertexFormat;
/*     */     //   57: goto -> 74
/*     */     //   60: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.field_181706_f : Lnet/minecraft/client/renderer/vertex/VertexFormat;
/*     */     //   63: goto -> 74
/*     */     //   66: new kotlin/NoWhenBranchMatchedException
/*     */     //   69: dup
/*     */     //   70: invokespecial <init> : ()V
/*     */     //   73: athrow
/*     */     //   74: dup
/*     */     //   75: ldc_w 'when (type) {\\n          …N_COLOR\\n                }'
/*     */     //   78: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   81: invokespecial <init> : (Lnet/minecraft/client/renderer/vertex/VertexFormat;)V
/*     */     //   84: checkcast net/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat
/*     */     //   87: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #564	-> 7
/*     */     //   #565	-> 11
/*     */     //   #566	-> 48
/*     */     //   #567	-> 54
/*     */     //   #568	-> 60
/*     */     //   #565	-> 74
/*     */     //   #564	-> 81
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	88	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ClassProviderImpl;
/*     */     //   0	88	1	type	Lnet/ccbluex/liquidbounce/api/enums/WDefaultVertexFormats; } @NotNull public IFontRenderer wrapFontRenderer(@NotNull IWrappedFontRenderer fontRenderer) { Intrinsics.checkParameterIsNotNull(fontRenderer, "fontRenderer"); return new FontRendererImpl((FontRenderer)new FontRendererWrapper(fontRenderer)); } @NotNull public IGuiScreen wrapGuiScreen(@NotNull WrappedGuiScreen clickGui) { Intrinsics.checkParameterIsNotNull(clickGui, "clickGui"); GuiScreenImpl<GuiScreen> instance = new GuiScreenImpl<>((GuiScreen)new GuiScreenWrapper(clickGui)); clickGui.setRepresentedScreen(instance); return instance; }
/* 715 */   @NotNull public IVertexBuffer createSafeVertexBuffer(@NotNull IVertexFormat vertexFormat) { Intrinsics.checkParameterIsNotNull(vertexFormat, "vertexFormat"); IVertexFormat $this$unwrap$iv = vertexFormat; int $i$f$unwrap = 0; VertexFormat vertexFormat1 = ((VertexFormatImpl)$this$unwrap$iv).getWrapped(); VertexFormat vertexFormat2 = vertexFormat1; VertexBuffer $this$wrap$iv = (VertexBuffer)new SafeVertexBuffer(vertexFormat2); int $i$f$wrap = 0;
/* 716 */     return new VertexBufferImpl($this$wrap$iv); }
/*     */ 
/*     */   
/*     */   public void wrapCreativeTab(@NotNull String name, @NotNull WrappedCreativeTabs wrappedCreativeTabs) {
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     Intrinsics.checkParameterIsNotNull(wrappedCreativeTabs, "wrappedCreativeTabs");
/*     */     wrappedCreativeTabs.setRepresentedType(new CreativeTabsImpl((CreativeTabs)new CreativeTabsWrapper(wrappedCreativeTabs, name)));
/*     */   }
/*     */   
/*     */   public void wrapGuiSlot(@NotNull WrappedGuiSlot wrappedGuiSlot, @NotNull IMinecraft mc, int width, int height, int top, int bottom, int slotHeight) {
/*     */     Intrinsics.checkParameterIsNotNull(wrappedGuiSlot, "wrappedGuiSlot");
/*     */     Intrinsics.checkParameterIsNotNull(mc, "mc");
/*     */     new GuiSlotWrapper(wrappedGuiSlot, mc, width, height, top, bottom, slotHeight);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public IGlStateManager getGlStateManager() {
/*     */     return GlStateManagerImpl.INSTANCE;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public IPacket createCPacketEncryptionResponse(@NotNull SecretKey secretKey, @NotNull PublicKey publicKey, @NotNull byte[] verifyToken) {
/*     */     Intrinsics.checkParameterIsNotNull(secretKey, "secretKey");
/*     */     Intrinsics.checkParameterIsNotNull(publicKey, "publicKey");
/*     */     Intrinsics.checkParameterIsNotNull(verifyToken, "verifyToken");
/*     */     return new PacketImpl<>((Packet)new CPacketEncryptionResponse(secretKey, publicKey, verifyToken));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ClassProviderImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */