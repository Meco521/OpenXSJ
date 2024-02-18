package net.ccbluex.liquidbounce.api;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.ByteBuf;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.enums.BlockType;
import net.ccbluex.liquidbounce.api.enums.EnchantmentType;
import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
import net.ccbluex.liquidbounce.api.enums.ItemType;
import net.ccbluex.liquidbounce.api.enums.MaterialType;
import net.ccbluex.liquidbounce.api.enums.StatType;
import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
import net.ccbluex.liquidbounce.api.enums.WEnumHand;
import net.ccbluex.liquidbounce.api.minecraft.block.material.IMaterial;
import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityOtherPlayerMP;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiButton;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiTextField;
import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IServerData;
import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
import net.ccbluex.liquidbounce.api.minecraft.client.render.IThreadDownloadImageData;
import net.ccbluex.liquidbounce.api.minecraft.client.render.WIImageBuffer;
import net.ccbluex.liquidbounce.api.minecraft.client.render.texture.IDynamicTexture;
import net.ccbluex.liquidbounce.api.minecraft.client.render.vertex.IVertexFormat;
import net.ccbluex.liquidbounce.api.minecraft.client.renderer.IGlStateManager;
import net.ccbluex.liquidbounce.api.minecraft.client.renderer.vertex.IVertexBuffer;
import net.ccbluex.liquidbounce.api.minecraft.client.settings.IGameSettings;
import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
import net.ccbluex.liquidbounce.api.minecraft.event.IClickEvent;
import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
import net.ccbluex.liquidbounce.api.minecraft.nbt.IJsonToNBT;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagCompound;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagDouble;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagList;
import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagString;
import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketAnimation;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketClientStatus;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketCloseWindow;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketCustomPayload;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketHeldItemChange;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketKeepAlive;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayer;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerBlockPlacement;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerPosLook;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketResourcePackStatus;
import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketUseEntity;
import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
import net.ccbluex.liquidbounce.api.minecraft.potion.IPotionEffect;
import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
import net.ccbluex.liquidbounce.api.minecraft.stats.IStatBase;
import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
import net.ccbluex.liquidbounce.api.minecraft.util.IIChatComponent;
import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
import net.ccbluex.liquidbounce.api.minecraft.util.ISession;
import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
import net.ccbluex.liquidbounce.api.minecraft.world.IWorld;
import net.ccbluex.liquidbounce.api.network.IPacketBuffer;
import net.ccbluex.liquidbounce.api.util.IWrappedFontRenderer;
import net.ccbluex.liquidbounce.api.util.WrappedCreativeTabs;
import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
import net.ccbluex.liquidbounce.api.util.WrappedGuiSlot;
import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000À\004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\006\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\022\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\b\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\be\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\bf\030\0002\0020\001J8\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\016\032\0020\r2\006\020\017\032\0020\r2\006\020\020\032\0020\r2\006\020\021\032\0020\r2\006\020\022\032\0020\rH&J\b\020\023\032\0020\024H&J\020\020\025\032\0020\0262\006\020\027\032\0020\030H&J\b\020\031\032\0020\032H&J\020\020\031\032\0020\0322\006\020\033\032\0020\034H&J\030\020\035\032\0020\0362\006\020\037\032\0020\0342\006\020 \032\0020!H&J\030\020\"\032\0020#2\006\020$\032\0020%2\006\020&\032\0020'H&J \020(\032\0020\0362\006\020)\032\0020*2\006\020+\032\0020,2\006\020-\032\0020.H&J\030\020/\032\002002\006\0201\032\002022\006\0203\032\00204H&J\020\0205\032\002062\006\020\037\032\0020\034H&J\b\0207\032\00208H&J\020\0209\032\0020:2\006\020;\032\0020<H&J\022\020=\032\0020>2\b\020?\032\004\030\0010!H'J:\020=\032\0020>2\006\020@\032\0020A2\006\020B\032\0020\0342\b\020C\032\004\030\0010!2\006\020D\032\0020E2\006\020F\032\0020E2\006\020G\032\0020EH&J \020H\032\0020\0362\006\0203\032\0020I2\006\020J\032\0020A2\006\020K\032\0020LH&J \020M\032\0020:2\006\020N\032\0020E2\006\020O\032\0020E2\006\020;\032\0020<H&J8\020P\032\0020Q2\006\020R\032\0020\r2\006\020S\032\0020\r2\006\020T\032\0020\r2\006\020N\032\0020E2\006\020O\032\0020E2\006\020;\032\0020<H&J(\020U\032\0020:2\006\020R\032\0020\r2\006\020V\032\0020\r2\006\020T\032\0020\r2\006\020;\032\0020<H&J\020\020W\032\0020\0362\006\020X\032\0020%H&J\024\020Y\032\006\022\002\b\0030Z2\006\020?\032\0020[H'J\030\020\\\032\0020]2\006\0201\032\002022\006\0203\032\0020^H&J\030\020\\\032\0020]2\006\020_\032\002022\006\020`\032\0020aH&J\020\020b\032\0020c2\006\020X\032\0020%H&J\030\020d\032\0020e2\006\020f\032\0020g2\006\020h\032\0020%H&J\020\020i\032\0020j2\006\020k\032\0020lH&J0\020m\032\002022\006\020n\032\0020o2\006\020p\032\0020\r2\006\020q\032\0020\r2\006\020r\032\0020\r2\006\020s\032\0020<H&J\030\020t\032\0020u2\006\020n\032\0020v2\006\020w\032\0020xH&J8\020y\032\0020z2\006\020{\032\0020\0342\006\020R\032\0020\0342\006\020S\032\0020\0342\006\020|\032\0020\0342\006\020}\032\0020\0342\006\020X\032\0020%H&J(\020y\032\0020z2\006\020{\032\0020\0342\006\020R\032\0020\0342\006\020S\032\0020\0342\006\020X\032\0020%H&J%\020~\032\00202\007\020\001\032\00202\b\020\001\032\0030\0012\b\020\001\032\0030\001H&J\022\020\001\032\00202\007\020\001\032\0020H&J\022\020\001\032\00202\007\020\001\032\0020H&J\034\020\001\032\00202\007\020\001\032\00202\b\020\001\032\0030\001H&J<\020\001\032\0030\0012\006\020{\032\0020\0342\b\020\001\032\0030\0012\006\020R\032\0020\0342\006\020S\032\0020\0342\006\020|\032\0020\0342\006\020}\032\0020\034H&J\022\020\001\032\00202\007\020\001\032\0020H&J<\020\001\032\0030\0012\006\020{\032\0020\0342\b\020\001\032\0030\0012\006\020R\032\0020\0342\006\020S\032\0020\0342\006\020|\032\0020\0342\006\020}\032\0020\034H&J\034\020\001\032\0020\0362\007\020\001\032\0020%2\b\020\001\032\0030\001H&J\n\020\001\032\0030\001H&J\023\020\001\032\0020!2\b\020\001\032\0030\001H&J\023\020\001\032\0020!2\b\020\001\032\0030\001H&J%\020\001\032\0020!2\b\020\001\032\0030\0012\007\020\001\032\0020\0342\007\020\001\032\0020\034H&J\n\020\001\032\0030\001H&J\022\020\001\032\0030 \0012\006\020h\032\0020\rH&J\n\020¡\001\032\0030¢\001H&J\023\020£\001\032\0030¤\0012\007\020¥\001\032\0020%H&J\023\020¦\001\032\0020'2\b\020§\001\032\0030¨\001H&J$\020©\001\032\0030ª\0012\006\020{\032\0020\0342\007\020«\001\032\0020\0342\007\020¬\001\032\0020\034H&J\023\020­\001\032\0030®\0012\007\020¯\001\032\0020%H&J\024\020°\001\032\0030±\0012\b\020²\001\032\0030³\001H&J\024\020´\001\032\0030µ\0012\b\020\001\032\0030\001H&J.\020¶\001\032\0030·\0012\007\020¸\001\032\0020%2\007\020¹\001\032\0020%2\007\020º\001\032\0020%2\007\020»\001\032\0020%H&J5\020¼\001\032\0030½\0012\n\020¾\001\032\005\030\0010¿\0012\007\020À\001\032\0020%2\n\020Á\001\032\005\030\0010®\0012\b\020Â\001\032\0030Ã\001H&J\024\020Ä\001\032\0030\0012\b\020Å\001\032\0030Æ\001H&J\024\020Ç\001\032\0030È\0012\b\020Å\001\032\0030É\001H&J\023\020Ê\001\032\0020L2\b\020Å\001\032\0030Ë\001H&J\n\020Ì\001\032\0030Í\001H&J\024\020Î\001\032\0030\0012\b\020Å\001\032\0030Ï\001H&J\024\020Ð\001\032\0030Ñ\0012\b\020Å\001\032\0030Ò\001H&J\024\020Ó\001\032\0030Ô\0012\b\020Å\001\032\0030Õ\001H&J\024\020Ö\001\032\0030×\0012\b\020Å\001\032\0030Ø\001H&J\024\020Ù\001\032\0030³\0012\b\020Å\001\032\0030Ú\001H&J\024\020Û\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020Ý\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020Þ\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ß\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020à\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020á\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020â\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ã\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ä\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020å\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020æ\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ç\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020è\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020é\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ê\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ë\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ì\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020í\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020î\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ï\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ð\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ñ\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ò\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ó\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ô\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020õ\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ö\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020÷\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ø\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ù\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ú\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020û\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ü\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ý\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020þ\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ÿ\001\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020 \002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¡\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¢\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020£\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¤\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¥\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¦\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020§\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¨\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020©\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020ª\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020«\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¬\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020­\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020®\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¯\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020°\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020±\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020²\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020³\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020´\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020µ\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¶\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020·\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¸\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¹\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020º\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020»\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¼\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020½\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\024\020¾\002\032\0020<2\t\020Ü\001\032\004\030\0010\001H&J\035\020¿\002\032\0030À\0022\007\020¸\001\032\0020%2\b\020Á\002\032\0030Â\002H&J\024\020Ã\002\032\0030\0012\b\020Ä\002\032\0030Å\002H&J\023\020Æ\002\032\00202\b\020Ç\002\032\0030È\002H&JI\020É\002\032\0030À\0022\b\020Ê\002\032\0030Ë\0022\b\020\001\032\0030\0012\006\020|\032\0020\0342\006\020}\032\0020\0342\007\020Ì\002\032\0020\0342\007\020Í\002\032\0020\0342\007\020Î\002\032\0020\034H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\t¨\006Ï\002"}, d2 = {"Lnet/ccbluex/liquidbounce/api/IClassProvider;", "", "jsonToNBTInstance", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/IJsonToNBT;", "getJsonToNBTInstance", "()Lnet/ccbluex/liquidbounce/api/minecraft/nbt/IJsonToNBT;", "tessellatorInstance", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/ITessellator;", "getTessellatorInstance", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/ITessellator;", "createAxisAlignedBB", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;", "minX", "", "minY", "minZ", "maxX", "maxY", "maxZ", "createCPacketAnimation", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketAnimation;", "createCPacketClientStatus", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus;", "state", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketClientStatus$WEnumState;", "createCPacketCloseWindow", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCloseWindow;", "windowId", "", "createCPacketCreativeInventoryAction", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "slot", "itemStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "createCPacketCustomPayload", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCustomPayload;", "channel", "", "payload", "Lnet/ccbluex/liquidbounce/api/network/IPacketBuffer;", "createCPacketEncryptionResponse", "secretKey", "Ljavax/crypto/SecretKey;", "publicKey", "Ljava/security/PublicKey;", "VerifyToken", "", "createCPacketEntityAction", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;", "player", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "wAction", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;", "createCPacketHeldItemChange", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;", "createCPacketKeepAlive", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketKeepAlive;", "createCPacketPlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;", "onGround", "", "createCPacketPlayerBlockPlacement", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;", "stack", "positionIn", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "placedBlockDirectionIn", "stackIn", "facingXIn", "", "facingYIn", "facingZIn", "createCPacketPlayerDigging", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerDigging$WAction;", "pos", "facing", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IEnumFacing;", "createCPacketPlayerLook", "yaw", "pitch", "createCPacketPlayerPosLook", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerPosLook;", "x", "y", "z", "createCPacketPlayerPosition", "negativeInfinity", "createCPacketTabComplete", "text", "createCPacketTryUseItem", "Lnet/ccbluex/liquidbounce/injection/backend/PacketImpl;", "Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;", "createCPacketUseEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketUseEntity$WAction;", "entity", "positionVector", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WVec3;", "createChatComponentText", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "createClickEvent", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent;", "action", "Lnet/ccbluex/liquidbounce/api/minecraft/event/IClickEvent$WAction;", "value", "createDynamicTexture", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/IDynamicTexture;", "image", "Ljava/awt/image/BufferedImage;", "createEntityLightningBolt", "world", "Lnet/ccbluex/liquidbounce/api/minecraft/world/IWorld;", "posX", "posY", "posZ", "effectOnly", "createEntityOtherPlayerMP", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "GameProfile", "Lcom/mojang/authlib/GameProfile;", "createGuiButton", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiButton;", "id", "width", "height", "createGuiConnecting", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "parent", "mc", "Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "serverData", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "createGuiModList", "parentScreen", "createGuiMultiplayer", "createGuiOptions", "gameSettings", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "createGuiPasswordField", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiTextField;", "iFontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "createGuiSelectWorld", "createGuiTextField", "createICPacketResourcePackStatus", "hash", "status", "Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketResourcePackStatus$WAction;", "createItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "createItemStack", "blockEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "item", "amount", "meta", "createNBTTagCompound", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "createNBTTagDouble", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagDouble;", "createNBTTagList", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "createNBTTagString", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagString;", "string", "createPacketBuffer", "buffer", "Lio/netty/buffer/ByteBuf;", "createPotionEffect", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotionEffect;", "time", "strength", "createResourceLocation", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "resourceName", "createSafeVertexBuffer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/vertex/IVertexBuffer;", "vertexFormat", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/vertex/IVertexFormat;", "createScaledResolution", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;", "createSession", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "name", "uuid", "accessToken", "accountType", "createThreadDownloadImageData", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/IThreadDownloadImageData;", "cacheFileIn", "Ljava/io/File;", "imageUrlIn", "textureResourceLocation", "imageBufferIn", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/WIImageBuffer;", "getBlockEnum", "type", "Lnet/ccbluex/liquidbounce/api/enums/BlockType;", "getEnchantmentEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;", "getEnumFacing", "Lnet/ccbluex/liquidbounce/api/enums/EnumFacingType;", "getGlStateManager", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;", "getItemEnum", "Lnet/ccbluex/liquidbounce/api/enums/ItemType;", "getMaterialEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/block/material/IMaterial;", "Lnet/ccbluex/liquidbounce/api/enums/MaterialType;", "getPotionEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;", "getStatEnum", "Lnet/ccbluex/liquidbounce/api/minecraft/stats/IStatBase;", "Lnet/ccbluex/liquidbounce/api/enums/StatType;", "getVertexFormatEnum", "Lnet/ccbluex/liquidbounce/api/enums/WDefaultVertexFormats;", "isBlockAir", "obj", "isBlockBedrock", "isBlockBush", "isBlockCactus", "isBlockCarpet", "isBlockFence", "isBlockLadder", "isBlockLiquid", "isBlockPane", "isBlockSlab", "isBlockSlime", "isBlockSnow", "isBlockStairs", "isBlockVine", "isCPacketAnimation", "isCPacketChatMessage", "isCPacketClientStatus", "isCPacketCloseWindow", "isCPacketConfirmTransaction", "isCPacketCustomPayload", "isCPacketEntityAction", "isCPacketHandshake", "isCPacketHeldItemChange", "isCPacketKeepAlive", "isCPacketPlayer", "isCPacketPlayerBlockPlacement", "isCPacketPlayerDigging", "isCPacketPlayerLook", "isCPacketPlayerPosLook", "isCPacketPlayerPosition", "isCPacketTryUseItem", "isCPacketUseEntity", "isClickGui", "isEntityAnimal", "isEntityArmorStand", "isEntityArrow", "isEntityBat", "isEntityBoat", "isEntityDragon", "isEntityFallingBlock", "isEntityFireball", "isEntityGhast", "isEntityGolem", "isEntityItem", "isEntityLivingBase", "isEntityMinecart", "isEntityMinecartChest", "isEntityMob", "isEntityPlayer", "isEntityShulker", "isEntitySlime", "isEntitySquid", "isEntityTNTPrimed", "isEntityVillager", "isGuiChat", "isGuiChest", "isGuiContainer", "isGuiGameOver", "isGuiHudDesigner", "isGuiIngameMenu", "isGuiInventory", "isItemAir", "isItemAppleGold", "isItemArmor", "isItemAxe", "isItemBed", "isItemBlock", "isItemBoat", "isItemBow", "isItemBucket", "isItemBucketMilk", "isItemEgg", "isItemEnchantedBook", "isItemEnderPearl", "isItemFishingRod", "isItemFood", "isItemMinecart", "isItemPickaxe", "isItemPotion", "isItemSnowball", "isItemSword", "isItemTool", "isSPacketAnimation", "isSPacketChat", "isSPacketCloseWindow", "isSPacketEntity", "isSPacketEntityVelocity", "isSPacketExplosion", "isSPacketPlayerPosLook", "isSPacketResourcePackSend", "isSPacketTabComplete", "isSPacketTimeUpdate", "isSPacketWindowItems", "isTileEntityChest", "isTileEntityDispenser", "isTileEntityEnderChest", "isTileEntityFurnace", "isTileEntityHopper", "isTileEntityShulkerBox", "wrapCreativeTab", "", "wrappedCreativeTabs", "Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "wrapFontRenderer", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;", "wrapGuiScreen", "guiScreen", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "wrapGuiSlot", "wrappedGuiSlot", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiSlot;", "top", "bottom", "slotHeight", "XSJClient"})
public interface IClassProvider {
  @NotNull
  ITessellator getTessellatorInstance();
  
  @NotNull
  IJsonToNBT getJsonToNBTInstance();
  
  @NotNull
  IResourceLocation createResourceLocation(@NotNull String paramString);
  
  @NotNull
  IThreadDownloadImageData createThreadDownloadImageData(@Nullable File paramFile, @NotNull String paramString, @Nullable IResourceLocation paramIResourceLocation, @NotNull WIImageBuffer paramWIImageBuffer);
  
  @NotNull
  IPacketBuffer createPacketBuffer(@NotNull ByteBuf paramByteBuf);
  
  @NotNull
  IIChatComponent createChatComponentText(@NotNull String paramString);
  
  @NotNull
  IClickEvent createClickEvent(@NotNull IClickEvent.WAction paramWAction, @NotNull String paramString);
  
  @NotNull
  IGuiTextField createGuiTextField(int paramInt1, @NotNull IFontRenderer paramIFontRenderer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  @NotNull
  IGuiTextField createGuiPasswordField(int paramInt1, @NotNull IFontRenderer paramIFontRenderer, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  @NotNull
  IGuiButton createGuiButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NotNull String paramString);
  
  @NotNull
  IGuiButton createGuiButton(int paramInt1, int paramInt2, int paramInt3, @NotNull String paramString);
  
  @NotNull
  ISession createSession(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4);
  
  @NotNull
  IDynamicTexture createDynamicTexture(@NotNull BufferedImage paramBufferedImage);
  
  @NotNull
  IEntity createEntityLightningBolt(@NotNull IWorld paramIWorld, double paramDouble1, double paramDouble2, double paramDouble3, boolean paramBoolean);
  
  @NotNull
  IItem createItem();
  
  @NotNull
  IItemStack createItemStack(@NotNull IItem paramIItem, int paramInt1, int paramInt2);
  
  @NotNull
  IItemStack createItemStack(@NotNull IItem paramIItem);
  
  @NotNull
  IItemStack createItemStack(@NotNull IBlock paramIBlock);
  
  @NotNull
  IAxisAlignedBB createAxisAlignedBB(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
  
  @NotNull
  IScaledResolution createScaledResolution(@NotNull IMinecraft paramIMinecraft);
  
  @NotNull
  INBTTagCompound createNBTTagCompound();
  
  @NotNull
  INBTTagList createNBTTagList();
  
  @NotNull
  INBTTagString createNBTTagString(@NotNull String paramString);
  
  @NotNull
  INBTTagDouble createNBTTagDouble(double paramDouble);
  
  @NotNull
  IEntityOtherPlayerMP createEntityOtherPlayerMP(@NotNull IWorldClient paramIWorldClient, @NotNull GameProfile paramGameProfile);
  
  @NotNull
  IPotionEffect createPotionEffect(int paramInt1, int paramInt2, int paramInt3);
  
  @NotNull
  IGuiScreen createGuiOptions(@NotNull IGuiScreen paramIGuiScreen, @NotNull IGameSettings paramIGameSettings);
  
  @NotNull
  IGuiScreen createGuiSelectWorld(@NotNull IGuiScreen paramIGuiScreen);
  
  @NotNull
  IGuiScreen createGuiMultiplayer(@NotNull IGuiScreen paramIGuiScreen);
  
  @NotNull
  IGuiScreen createGuiModList(@NotNull IGuiScreen paramIGuiScreen);
  
  @NotNull
  IGuiScreen createGuiConnecting(@NotNull IGuiScreen paramIGuiScreen, @NotNull IMinecraft paramIMinecraft, @NotNull IServerData paramIServerData);
  
  @NotNull
  ICPacketPlayerBlockPlacement createCPacketPlayerBlockPlacement(@NotNull WBlockPos paramWBlockPos, int paramInt, @Nullable IItemStack paramIItemStack, float paramFloat1, float paramFloat2, float paramFloat3);
  
  @NotNull
  ICPacketHeldItemChange createCPacketHeldItemChange(int paramInt);
  
  @SupportsMinecraftVersions({MinecraftVersion.MC_1_12})
  @NotNull
  ICPacketPlayerBlockPlacement createCPacketPlayerBlockPlacement(@Nullable IItemStack paramIItemStack);
  
  @NotNull
  ICPacketPlayerPosLook createCPacketPlayerPosLook(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  @NotNull
  ICPacketClientStatus createCPacketClientStatus(@NotNull ICPacketClientStatus.WEnumState paramWEnumState);
  
  @NotNull
  IPacket createCPacketPlayerDigging(@NotNull ICPacketPlayerDigging.WAction paramWAction, @NotNull WBlockPos paramWBlockPos, @NotNull IEnumFacing paramIEnumFacing);
  
  @NotNull
  ICPacketPlayer createCPacketPlayerPosition(double paramDouble1, double paramDouble2, double paramDouble3, boolean paramBoolean);
  
  @NotNull
  IPacket createICPacketResourcePackStatus(@NotNull String paramString, @NotNull ICPacketResourcePackStatus.WAction paramWAction);
  
  @NotNull
  ICPacketPlayer createCPacketPlayerLook(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  @NotNull
  ICPacketUseEntity createCPacketUseEntity(@NotNull IEntity paramIEntity, @NotNull ICPacketUseEntity.WAction paramWAction);
  
  @NotNull
  ICPacketUseEntity createCPacketUseEntity(@NotNull IEntity paramIEntity, @NotNull WVec3 paramWVec3);
  
  @NotNull
  IPacket createCPacketCreativeInventoryAction(int paramInt, @NotNull IItemStack paramIItemStack);
  
  @NotNull
  ICPacketEntityAction createCPacketEntityAction(@NotNull IEntity paramIEntity, @NotNull ICPacketEntityAction.WAction paramWAction);
  
  @NotNull
  ICPacketCustomPayload createCPacketCustomPayload(@NotNull String paramString, @NotNull IPacketBuffer paramIPacketBuffer);
  
  @NotNull
  ICPacketCloseWindow createCPacketCloseWindow(int paramInt);
  
  @NotNull
  ICPacketCloseWindow createCPacketCloseWindow();
  
  @NotNull
  ICPacketPlayer createCPacketPlayer(boolean paramBoolean);
  
  @NotNull
  IPacket createCPacketTabComplete(@NotNull String paramString);
  
  @NotNull
  ICPacketAnimation createCPacketAnimation();
  
  @NotNull
  ICPacketKeepAlive createCPacketKeepAlive();
  
  boolean isEntityAnimal(@Nullable Object paramObject);
  
  boolean isEntitySquid(@Nullable Object paramObject);
  
  boolean isEntityBat(@Nullable Object paramObject);
  
  boolean isEntityGolem(@Nullable Object paramObject);
  
  boolean isEntityMob(@Nullable Object paramObject);
  
  boolean isEntityVillager(@Nullable Object paramObject);
  
  boolean isEntitySlime(@Nullable Object paramObject);
  
  boolean isEntityGhast(@Nullable Object paramObject);
  
  boolean isEntityDragon(@Nullable Object paramObject);
  
  boolean isEntityLivingBase(@Nullable Object paramObject);
  
  boolean isEntityPlayer(@Nullable Object paramObject);
  
  boolean isEntityArmorStand(@Nullable Object paramObject);
  
  boolean isEntityTNTPrimed(@Nullable Object paramObject);
  
  boolean isEntityBoat(@Nullable Object paramObject);
  
  boolean isEntityMinecart(@Nullable Object paramObject);
  
  boolean isEntityItem(@Nullable Object paramObject);
  
  boolean isEntityArrow(@Nullable Object paramObject);
  
  boolean isEntityFallingBlock(@Nullable Object paramObject);
  
  boolean isEntityMinecartChest(@Nullable Object paramObject);
  
  boolean isEntityShulker(@Nullable Object paramObject);
  
  boolean isEntityFireball(@Nullable Object paramObject);
  
  boolean isTileEntityChest(@Nullable Object paramObject);
  
  boolean isTileEntityEnderChest(@Nullable Object paramObject);
  
  boolean isTileEntityFurnace(@Nullable Object paramObject);
  
  boolean isTileEntityDispenser(@Nullable Object paramObject);
  
  boolean isTileEntityHopper(@Nullable Object paramObject);
  
  boolean isSPacketChat(@Nullable Object paramObject);
  
  boolean isSPacketEntity(@Nullable Object paramObject);
  
  boolean isSPacketResourcePackSend(@Nullable Object paramObject);
  
  boolean isSPacketPlayerPosLook(@Nullable Object paramObject);
  
  boolean isSPacketAnimation(@Nullable Object paramObject);
  
  boolean isSPacketEntityVelocity(@Nullable Object paramObject);
  
  boolean isSPacketExplosion(@Nullable Object paramObject);
  
  boolean isSPacketCloseWindow(@Nullable Object paramObject);
  
  boolean isSPacketTabComplete(@Nullable Object paramObject);
  
  boolean isCPacketPlayer(@Nullable Object paramObject);
  
  boolean isCPacketPlayerBlockPlacement(@Nullable Object paramObject);
  
  boolean isCPacketUseEntity(@Nullable Object paramObject);
  
  boolean isCPacketCloseWindow(@Nullable Object paramObject);
  
  boolean isCPacketChatMessage(@Nullable Object paramObject);
  
  boolean isCPacketKeepAlive(@Nullable Object paramObject);
  
  boolean isCPacketPlayerPosition(@Nullable Object paramObject);
  
  boolean isCPacketPlayerPosLook(@Nullable Object paramObject);
  
  boolean isCPacketClientStatus(@Nullable Object paramObject);
  
  boolean isCPacketAnimation(@Nullable Object paramObject);
  
  boolean isCPacketEntityAction(@Nullable Object paramObject);
  
  boolean isSPacketWindowItems(@Nullable Object paramObject);
  
  boolean isCPacketHeldItemChange(@Nullable Object paramObject);
  
  boolean isCPacketPlayerLook(@Nullable Object paramObject);
  
  boolean isCPacketCustomPayload(@Nullable Object paramObject);
  
  boolean isCPacketHandshake(@Nullable Object paramObject);
  
  boolean isCPacketPlayerDigging(@Nullable Object paramObject);
  
  boolean isCPacketTryUseItem(@Nullable Object paramObject);
  
  boolean isItemSword(@Nullable Object paramObject);
  
  boolean isItemTool(@Nullable Object paramObject);
  
  boolean isItemArmor(@Nullable Object paramObject);
  
  boolean isItemPotion(@Nullable Object paramObject);
  
  boolean isItemBlock(@Nullable Object paramObject);
  
  boolean isItemBow(@Nullable Object paramObject);
  
  boolean isItemBucket(@Nullable Object paramObject);
  
  boolean isItemFood(@Nullable Object paramObject);
  
  boolean isItemBucketMilk(@Nullable Object paramObject);
  
  boolean isItemPickaxe(@Nullable Object paramObject);
  
  boolean isItemAxe(@Nullable Object paramObject);
  
  boolean isItemBed(@Nullable Object paramObject);
  
  boolean isItemEnderPearl(@Nullable Object paramObject);
  
  boolean isItemEnchantedBook(@Nullable Object paramObject);
  
  boolean isItemBoat(@Nullable Object paramObject);
  
  boolean isItemMinecart(@Nullable Object paramObject);
  
  boolean isItemAppleGold(@Nullable Object paramObject);
  
  boolean isItemSnowball(@Nullable Object paramObject);
  
  boolean isItemEgg(@Nullable Object paramObject);
  
  boolean isItemFishingRod(@Nullable Object paramObject);
  
  boolean isItemAir(@Nullable Object paramObject);
  
  boolean isBlockAir(@Nullable Object paramObject);
  
  boolean isBlockFence(@Nullable Object paramObject);
  
  boolean isBlockSnow(@Nullable Object paramObject);
  
  boolean isBlockLadder(@Nullable Object paramObject);
  
  boolean isBlockVine(@Nullable Object paramObject);
  
  boolean isBlockSlime(@Nullable Object paramObject);
  
  boolean isBlockSlab(@Nullable Object paramObject);
  
  boolean isBlockStairs(@Nullable Object paramObject);
  
  boolean isBlockCarpet(@Nullable Object paramObject);
  
  boolean isBlockPane(@Nullable Object paramObject);
  
  boolean isBlockLiquid(@Nullable Object paramObject);
  
  boolean isBlockCactus(@Nullable Object paramObject);
  
  boolean isBlockBedrock(@Nullable Object paramObject);
  
  boolean isBlockBush(@Nullable Object paramObject);
  
  boolean isGuiInventory(@Nullable Object paramObject);
  
  boolean isGuiContainer(@Nullable Object paramObject);
  
  boolean isGuiGameOver(@Nullable Object paramObject);
  
  boolean isGuiChat(@Nullable Object paramObject);
  
  boolean isGuiIngameMenu(@Nullable Object paramObject);
  
  boolean isGuiChest(@Nullable Object paramObject);
  
  boolean isGuiHudDesigner(@Nullable Object paramObject);
  
  boolean isClickGui(@Nullable Object paramObject);
  
  boolean isCPacketConfirmTransaction(@Nullable Object paramObject);
  
  @NotNull
  IPotion getPotionEnum(@NotNull PotionType paramPotionType);
  
  @NotNull
  IEnumFacing getEnumFacing(@NotNull EnumFacingType paramEnumFacingType);
  
  @NotNull
  IBlock getBlockEnum(@NotNull BlockType paramBlockType);
  
  @NotNull
  IMaterial getMaterialEnum(@NotNull MaterialType paramMaterialType);
  
  @NotNull
  IStatBase getStatEnum(@NotNull StatType paramStatType);
  
  @NotNull
  IItem getItemEnum(@NotNull ItemType paramItemType);
  
  @NotNull
  IEnchantment getEnchantmentEnum(@NotNull EnchantmentType paramEnchantmentType);
  
  @NotNull
  IVertexFormat getVertexFormatEnum(@NotNull WDefaultVertexFormats paramWDefaultVertexFormats);
  
  @NotNull
  IFontRenderer wrapFontRenderer(@NotNull IWrappedFontRenderer paramIWrappedFontRenderer);
  
  @NotNull
  IGuiScreen wrapGuiScreen(@NotNull WrappedGuiScreen paramWrappedGuiScreen);
  
  @NotNull
  IVertexBuffer createSafeVertexBuffer(@NotNull IVertexFormat paramIVertexFormat);
  
  void wrapCreativeTab(@NotNull String paramString, @NotNull WrappedCreativeTabs paramWrappedCreativeTabs);
  
  void wrapGuiSlot(@NotNull WrappedGuiSlot paramWrappedGuiSlot, @NotNull IMinecraft paramIMinecraft, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  @NotNull
  IGlStateManager getGlStateManager();
  
  @NotNull
  IPacket createCPacketEncryptionResponse(@NotNull SecretKey paramSecretKey, @NotNull PublicKey paramPublicKey, @NotNull byte[] paramArrayOfbyte);
  
  @SupportsMinecraftVersions({MinecraftVersion.MC_1_12})
  @NotNull
  PacketImpl<?> createCPacketTryUseItem(@NotNull WEnumHand paramWEnumHand);
  
  boolean isTileEntityShulkerBox(@Nullable Object paramObject);
  
  boolean isSPacketTimeUpdate(@Nullable Object paramObject);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\IClassProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */