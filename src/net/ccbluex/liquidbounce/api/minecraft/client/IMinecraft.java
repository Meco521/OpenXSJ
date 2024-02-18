package net.ccbluex.liquidbounce.api.minecraft.client;

import java.io.File;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.IParticleManager;
import net.ccbluex.liquidbounce.api.minecraft.client.audio.ISoundHandler;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IPlayerControllerMP;
import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IServerData;
import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
import net.ccbluex.liquidbounce.api.minecraft.client.render.entity.IRenderItem;
import net.ccbluex.liquidbounce.api.minecraft.client.render.texture.ITextureManager;
import net.ccbluex.liquidbounce.api.minecraft.client.renderer.IEntityRenderer;
import net.ccbluex.liquidbounce.api.minecraft.client.renderer.IRenderGlobal;
import net.ccbluex.liquidbounce.api.minecraft.client.settings.IGameSettings;
import net.ccbluex.liquidbounce.api.minecraft.client.shader.IFramebuffer;
import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
import net.ccbluex.liquidbounce.api.minecraft.util.ISession;
import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
import net.minecraft.network.play.INetHandlerPlayClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Ò\001\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\005\bf\030\0002\0020\001J\022\020n\032\0020o2\b\020p\032\004\030\0010\003H&J\b\020q\032\0020oH&J\b\020r\032\0020oH&J\b\020s\032\0020oH&R\024\020\002\032\004\030\0010\003X¦\004¢\006\006\032\004\b\004\020\005R\024\020\006\032\004\030\0010\007X¦\004¢\006\006\032\004\b\b\020\tR\022\020\n\032\0020\013X¦\004¢\006\006\032\004\b\f\020\rR\022\020\016\032\0020\017X¦\004¢\006\006\032\004\b\020\020\021R\022\020\022\032\0020\017X¦\004¢\006\006\032\004\b\023\020\021R\022\020\024\032\0020\017X¦\004¢\006\006\032\004\b\025\020\021R\022\020\026\032\0020\027X¦\004¢\006\006\032\004\b\030\020\031R\022\020\032\032\0020\033X¦\004¢\006\006\032\004\b\034\020\035R\022\020\036\032\0020\037X¦\004¢\006\006\032\004\b \020!R\022\020\"\032\0020#X¦\004¢\006\006\032\004\b$\020%R\022\020&\032\0020'X¦\004¢\006\006\032\004\b(\020)R\022\020*\032\0020+X¦\004¢\006\006\032\004\b*\020,R\022\020-\032\0020+X¦\004¢\006\006\032\004\b-\020,R\022\020.\032\0020/X¦\004¢\006\006\032\004\b0\0201R\022\0202\032\00203X¦\004¢\006\006\032\004\b4\0205R\024\0206\032\004\030\00107X¦\004¢\006\006\032\004\b8\0209R\022\020:\032\0020;X¦\004¢\006\006\032\004\b<\020=R\022\020>\032\0020?X¦\004¢\006\006\032\004\b@\020AR\022\020B\032\0020CX¦\004¢\006\006\032\004\bD\020ER\022\020F\032\0020GX¦\004¢\006\006\032\004\bH\020IR\032\020J\032\004\030\0010KX¦\016¢\006\f\032\004\bL\020M\"\004\bN\020OR\030\020P\032\0020\017X¦\016¢\006\f\032\004\bQ\020\021\"\004\bR\020SR\030\020T\032\0020UX¦\016¢\006\f\032\004\bV\020W\"\004\bX\020YR\022\020Z\032\0020[X¦\004¢\006\006\032\004\b\\\020]R\022\020^\032\0020_X¦\004¢\006\006\032\004\b`\020aR\024\020b\032\004\030\0010cX¦\004¢\006\006\032\004\bd\020eR\024\020f\032\004\030\0010gX¦\004¢\006\006\032\004\bh\020iR\022\020j\032\0020kX¦\004¢\006\006\032\004\bl\020m¨\006t"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "", "currentScreen", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "getCurrentScreen", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "currentServerData", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "getCurrentServerData", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "dataDir", "Ljava/io/File;", "getDataDir", "()Ljava/io/File;", "debugFPS", "", "getDebugFPS", "()I", "displayHeight", "getDisplayHeight", "displayWidth", "getDisplayWidth", "effectRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/IParticleManager;", "getEffectRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/IParticleManager;", "entityRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IEntityRenderer;", "getEntityRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IEntityRenderer;", "fontRendererObj", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "getFontRendererObj", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "framebuffer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IFramebuffer;", "getFramebuffer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IFramebuffer;", "gameSettings", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "getGameSettings", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "isFullScreen", "", "()Z", "isIntegratedServerRunning", "netHandler", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "getNetHandler", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "netHandler2", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "getNetHandler2", "()Lnet/minecraft/network/play/INetHandlerPlayClient;", "objectMouseOver", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "getObjectMouseOver", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "playerController", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;", "getPlayerController", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;", "renderGlobal", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IRenderGlobal;", "getRenderGlobal", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IRenderGlobal;", "renderItem", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/entity/IRenderItem;", "getRenderItem", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/entity/IRenderItem;", "renderManager", "Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;", "getRenderManager", "()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;", "renderViewEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "getRenderViewEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "setRenderViewEntity", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V", "rightClickDelayTimer", "getRightClickDelayTimer", "setRightClickDelayTimer", "(I)V", "session", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "getSession", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "setSession", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;)V", "soundHandler", "Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;", "getSoundHandler", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;", "textureManager", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;", "getTextureManager", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;", "thePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "getThePlayer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "theWorld", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "getTheWorld", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "timer", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;", "displayGuiScreen", "", "screen", "rightClickMouse", "shutdown", "toggleFullscreen", "XSJClient"})
public interface IMinecraft {
  @NotNull
  IFramebuffer getFramebuffer();
  
  boolean isFullScreen();
  
  @NotNull
  File getDataDir();
  
  int getDebugFPS();
  
  @NotNull
  IRenderGlobal getRenderGlobal();
  
  @NotNull
  IRenderItem getRenderItem();
  
  int getDisplayWidth();
  
  int getDisplayHeight();
  
  @NotNull
  IEntityRenderer getEntityRenderer();
  
  int getRightClickDelayTimer();
  
  void setRightClickDelayTimer(int paramInt);
  
  @NotNull
  ISession getSession();
  
  void setSession(@NotNull ISession paramISession);
  
  @NotNull
  ISoundHandler getSoundHandler();
  
  @Nullable
  IMovingObjectPosition getObjectMouseOver();
  
  @NotNull
  ITimer getTimer();
  
  @NotNull
  IRenderManager getRenderManager();
  
  @NotNull
  IPlayerControllerMP getPlayerController();
  
  @Nullable
  IGuiScreen getCurrentScreen();
  
  @Nullable
  IEntity getRenderViewEntity();
  
  void setRenderViewEntity(@Nullable IEntity paramIEntity);
  
  @NotNull
  IINetHandlerPlayClient getNetHandler();
  
  @NotNull
  INetHandlerPlayClient getNetHandler2();
  
  @Nullable
  IWorldClient getTheWorld();
  
  @Nullable
  IEntityPlayerSP getThePlayer();
  
  @NotNull
  ITextureManager getTextureManager();
  
  boolean isIntegratedServerRunning();
  
  @Nullable
  IServerData getCurrentServerData();
  
  @NotNull
  IGameSettings getGameSettings();
  
  @NotNull
  IFontRenderer getFontRendererObj();
  
  @NotNull
  IParticleManager getEffectRenderer();
  
  void displayGuiScreen(@Nullable IGuiScreen paramIGuiScreen);
  
  void rightClickMouse();
  
  void shutdown();
  
  void toggleFullscreen();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\IMinecraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */