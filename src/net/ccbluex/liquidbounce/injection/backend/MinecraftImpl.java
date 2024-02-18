/*     */ package net.ccbluex.liquidbounce.injection.backend;
/*     */ 
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.ISession;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.SoundHandler;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.particle.ParticleManager;
/*     */ import net.minecraft.client.renderer.RenderGlobal;
/*     */ import net.minecraft.client.renderer.RenderItem;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.Session;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000â\001\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\003\n\002\020\000\n\002\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\022\020t\032\0020u2\b\020v\032\004\030\0010\006H\026J\023\020w\032\0020.2\b\020x\032\004\030\0010yH\002J\b\020z\032\0020uH\026J\b\020{\032\0020uH\026J\b\020|\032\0020uH\026R\026\020\005\032\004\030\0010\0068VX\004¢\006\006\032\004\b\007\020\bR\026\020\t\032\004\030\0010\n8VX\004¢\006\006\032\004\b\013\020\fR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R\024\020\021\032\0020\0228VX\004¢\006\006\032\004\b\023\020\024R\024\020\025\032\0020\0228VX\004¢\006\006\032\004\b\026\020\024R\024\020\027\032\0020\0228VX\004¢\006\006\032\004\b\030\020\024R\024\020\031\032\0020\0328VX\004¢\006\006\032\004\b\033\020\034R\024\020\035\032\0020\0368VX\004¢\006\006\032\004\b\037\020 R\024\020!\032\0020\"8VX\004¢\006\006\032\004\b#\020$R\024\020%\032\0020&8VX\004¢\006\006\032\004\b'\020(R\024\020)\032\0020*8VX\004¢\006\006\032\004\b+\020,R\024\020-\032\0020.8VX\004¢\006\006\032\004\b-\020/R\024\0200\032\0020.8VX\004¢\006\006\032\004\b0\020/R\024\0201\032\002028VX\004¢\006\006\032\004\b3\0204R\024\0205\032\002068VX\004¢\006\006\032\004\b7\0208R\026\0209\032\004\030\0010:8VX\004¢\006\006\032\004\b;\020<R\024\020=\032\0020>8VX\004¢\006\006\032\004\b?\020@R\024\020A\032\0020B8VX\004¢\006\006\032\004\bC\020DR\024\020E\032\0020F8VX\004¢\006\006\032\004\bG\020HR\024\020I\032\0020J8VX\004¢\006\006\032\004\bK\020LR(\020O\032\004\030\0010N2\b\020M\032\004\030\0010N8V@VX\016¢\006\f\032\004\bP\020Q\"\004\bR\020SR$\020T\032\0020\0222\006\020M\032\0020\0228V@VX\016¢\006\f\032\004\bU\020\024\"\004\bV\020WR$\020Y\032\0020X2\006\020M\032\0020X8V@VX\016¢\006\f\032\004\bZ\020[\"\004\b\\\020]R\024\020^\032\0020_8VX\004¢\006\006\032\004\b`\020aR\024\020b\032\0020c8VX\004¢\006\006\032\004\bd\020eR\026\020f\032\004\030\0010g8VX\004¢\006\006\032\004\bh\020iR\026\020j\032\004\030\0010k8VX\004¢\006\006\032\004\bl\020mR\024\020n\032\0020o8VX\004¢\006\006\032\004\bp\020qR\021\020\002\032\0020\003¢\006\b\n\000\032\004\br\020s¨\006}"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/MinecraftImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;", "wrapped", "Lnet/minecraft/client/Minecraft;", "(Lnet/minecraft/client/Minecraft;)V", "currentScreen", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "getCurrentScreen", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "currentServerData", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "getCurrentServerData", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IServerData;", "dataDir", "Ljava/io/File;", "getDataDir", "()Ljava/io/File;", "debugFPS", "", "getDebugFPS", "()I", "displayHeight", "getDisplayHeight", "displayWidth", "getDisplayWidth", "effectRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/IParticleManager;", "getEffectRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/IParticleManager;", "entityRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IEntityRenderer;", "getEntityRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IEntityRenderer;", "fontRendererObj", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "getFontRendererObj", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "framebuffer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IFramebuffer;", "getFramebuffer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/shader/IFramebuffer;", "gameSettings", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "getGameSettings", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "isFullScreen", "", "()Z", "isIntegratedServerRunning", "netHandler", "Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "getNetHandler", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;", "netHandler2", "Lnet/minecraft/network/play/INetHandlerPlayClient;", "getNetHandler2", "()Lnet/minecraft/network/play/INetHandlerPlayClient;", "objectMouseOver", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "getObjectMouseOver", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovingObjectPosition;", "playerController", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;", "getPlayerController", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;", "renderGlobal", "Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IRenderGlobal;", "getRenderGlobal", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IRenderGlobal;", "renderItem", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/entity/IRenderItem;", "getRenderItem", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/entity/IRenderItem;", "renderManager", "Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;", "getRenderManager", "()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;", "value", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "renderViewEntity", "getRenderViewEntity", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "setRenderViewEntity", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)V", "rightClickDelayTimer", "getRightClickDelayTimer", "setRightClickDelayTimer", "(I)V", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "session", "getSession", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;", "setSession", "(Lnet/ccbluex/liquidbounce/api/minecraft/util/ISession;)V", "soundHandler", "Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;", "getSoundHandler", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/audio/ISoundHandler;", "textureManager", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;", "getTextureManager", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;", "thePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "getThePlayer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;", "theWorld", "Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "getTheWorld", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;", "timer", "Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;", "getWrapped", "()Lnet/minecraft/client/Minecraft;", "displayGuiScreen", "", "screen", "equals", "other", "", "rightClickMouse", "shutdown", "toggleFullscreen", "XSJClient"})
/*     */ public final class MinecraftImpl implements IMinecraft {
/*     */   @NotNull
/*  29 */   public final Minecraft getWrapped() { return this.wrapped; } @NotNull private final Minecraft wrapped; public MinecraftImpl(@NotNull Minecraft wrapped) { this.wrapped = wrapped; }
/*     */   @NotNull
/*  31 */   public IFramebuffer getFramebuffer() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_147110_a(), "wrapped.framebuffer"); Framebuffer $this$wrap$iv = this.wrapped.func_147110_a(); int $i$f$wrap = 0; return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       new FramebufferImpl($this$wrap$iv); } public boolean isFullScreen() { return this.wrapped.func_71372_G(); } @NotNull public File getDataDir() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71412_D, "wrapped.mcDataDir"); return this.wrapped.field_71412_D; } public int getDebugFPS() { return Minecraft.func_175610_ah(); }
/* 109 */   @NotNull public IRenderGlobal getRenderGlobal() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71438_f, "wrapped.renderGlobal"); RenderGlobal $this$wrap$iv = this.wrapped.field_71438_f; int $i$f$wrap = 0; return new RenderGlobalImpl($this$wrap$iv); } @NotNull public IRenderItem getRenderItem() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_175599_af(), "wrapped.renderItem"); RenderItem $this$wrap$iv = this.wrapped.func_175599_af(); int $i$f$wrap = 0;
/* 110 */     return new RenderItemImpl($this$wrap$iv); } public int getDisplayWidth() { return this.wrapped.field_71443_c; } public int getDisplayHeight() { return this.wrapped.field_71440_d; }
/* 111 */   @NotNull public IEntityRenderer getEntityRenderer() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71460_t, "wrapped.entityRenderer"); EntityRenderer $this$wrap$iv = this.wrapped.field_71460_t; int $i$f$wrap = 0; return new EntityRendererImpl($this$wrap$iv); } public int getRightClickDelayTimer() { return this.wrapped.field_71467_ac; } public void setRightClickDelayTimer(int value) { this.wrapped.field_71467_ac = value; }
/* 112 */   @NotNull public ISession getSession() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71449_j, "wrapped.session"); Session $this$wrap$iv = this.wrapped.field_71449_j; int $i$f$wrap = 0; return new SessionImpl($this$wrap$iv); } public void setSession(@NotNull ISession value) { Intrinsics.checkParameterIsNotNull(value, "value"); ISession iSession = value; Minecraft minecraft = this.wrapped; int $i$f$unwrap = 0;
/* 113 */     Session session = ((SessionImpl)iSession).getWrapped(); } @NotNull public ISoundHandler getSoundHandler() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_147118_V(), "wrapped.soundHandler"); SoundHandler $this$wrap$iv = this.wrapped.func_147118_V(); int $i$f$wrap = 0;
/* 114 */     return new SoundHandlerImpl($this$wrap$iv); } @Nullable public IMovingObjectPosition getObjectMouseOver() { RayTraceResult $this$wrap$iv = this.wrapped.field_71476_x; int $i$f$wrap = 0;
/* 115 */     return (this.wrapped.field_71476_x != null) ? new MovingObjectPositionImpl($this$wrap$iv) : null; } @NotNull public ITimer getTimer() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71428_T, "wrapped.timer"); Timer $this$wrap$iv = this.wrapped.field_71428_T; int $i$f$wrap = 0;
/* 116 */     return new TimerImpl($this$wrap$iv); } @NotNull public IRenderManager getRenderManager() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_175598_ae(), "wrapped.renderManager"); RenderManager $this$wrap$iv = this.wrapped.func_175598_ae(); int $i$f$wrap = 0;
/* 117 */     return new RenderManagerImpl($this$wrap$iv); } @NotNull public IPlayerControllerMP getPlayerController() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71442_b, "wrapped.playerController"); PlayerControllerMP $this$wrap$iv = this.wrapped.field_71442_b; int $i$f$wrap = 0;
/* 118 */     return new PlayerControllerMPImpl($this$wrap$iv); } @Nullable public IGuiScreen getCurrentScreen() { GuiScreen $this$wrap$iv = this.wrapped.field_71462_r; int $i$f$wrap = 0;
/* 119 */     return (this.wrapped.field_71462_r != null) ? new GuiScreenImpl<>($this$wrap$iv) : null; } @Nullable public IEntity getRenderViewEntity() { Entity $this$wrap$iv = this.wrapped.func_175606_aa(); int $i$f$wrap = 0; this.wrapped.func_175606_aa();
/* 120 */     return (this.wrapped.func_175606_aa() != null) ? new EntityImpl<>($this$wrap$iv) : null; } public void setRenderViewEntity(@Nullable IEntity value) { IEntity iEntity = value; Minecraft minecraft = this.wrapped; int $i$f$unwrap = 0;
/* 121 */     if (iEntity == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityImpl<*>");  Entity entity = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); this.wrapped.func_175607_a((value != null) ? entity : null); } @NotNull public IINetHandlerPlayClient getNetHandler() { if (this.wrapped.func_147114_u() == null)
/* 122 */       Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_147114_u(), "wrapped.connection!!"); NetHandlerPlayClient $this$wrap$iv = this.wrapped.func_147114_u(); int $i$f$wrap = 0; return new INetHandlerPlayClientImpl($this$wrap$iv); } @NotNull public INetHandlerPlayClient getNetHandler2() { if (this.wrapped.func_147114_u() == null)
/* 123 */       Intrinsics.throwNpe();  NetHandlerPlayClient netHandlerPlayClient1 = this.wrapped.func_147114_u(); boolean bool1 = false, bool2 = false; NetHandlerPlayClient it = netHandlerPlayClient1; int $i$a$-also-MinecraftImpl$netHandler2$1 = 0; IMinecraft $this$unwrap$iv = this; int $i$f$unwrap = 0; if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  ((MinecraftImpl)$this$unwrap$iv).getWrapped(); Intrinsics.checkExpressionValueIsNotNull(netHandlerPlayClient1, "wrapped.connection!!.also { unwrap() }"); return (INetHandlerPlayClient)netHandlerPlayClient1; } @Nullable public IWorldClient getTheWorld() { WorldClient $this$wrap$iv = this.wrapped.field_71441_e; int $i$f$wrap = 0;
/* 124 */     return (this.wrapped.field_71441_e != null) ? new WorldClientImpl($this$wrap$iv) : null; } @Nullable public IEntityPlayerSP getThePlayer() { EntityPlayerSP $this$wrap$iv = this.wrapped.field_71439_g; int $i$f$wrap = 0;
/* 125 */     return (this.wrapped.field_71439_g != null) ? new EntityPlayerSPImpl<>($this$wrap$iv) : null; } @NotNull public ITextureManager getTextureManager() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_110434_K(), "wrapped.textureManager"); TextureManager $this$wrap$iv = this.wrapped.func_110434_K(); int $i$f$wrap = 0;
/* 126 */     return new TextureManagerImpl($this$wrap$iv); } public boolean isIntegratedServerRunning() { return this.wrapped.func_71387_A(); }
/* 127 */   @Nullable public IServerData getCurrentServerData() { ServerData $this$wrap$iv = this.wrapped.func_147104_D(); int $i$f$wrap = 0; this.wrapped.func_147104_D(); return (this.wrapped.func_147104_D() != null) ? new ServerDataImpl($this$wrap$iv) : null; } @NotNull public IGameSettings getGameSettings() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71474_y, "wrapped.gameSettings"); return new GameSettingsImpl(this.wrapped.field_71474_y); }
/* 128 */   @NotNull public IFontRenderer getFontRendererObj() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71466_p, "wrapped.fontRenderer"); FontRenderer $this$wrap$iv = this.wrapped.field_71466_p; int $i$f$wrap = 0; return new FontRendererImpl($this$wrap$iv); } @NotNull public IParticleManager getEffectRenderer() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_71452_i, "wrapped.effectRenderer"); ParticleManager $this$wrap$iv = this.wrapped.field_71452_i; int $i$f$wrap = 0;
/* 129 */     return new ParticleManagerImpl($this$wrap$iv); } public void displayGuiScreen(@Nullable IGuiScreen screen) { IGuiScreen iGuiScreen = screen; Minecraft minecraft = this.wrapped; int $i$f$unwrap = 0;
/* 130 */     if (iGuiScreen == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.GuiScreenImpl<*>");  GuiScreen guiScreen = ((GuiScreenImpl<GuiScreen>)iGuiScreen).getWrapped(); this.wrapped.func_147108_a((screen != null) ? guiScreen : null); }
/*     */ 
/*     */   
/*     */   public void rightClickMouse() {
/*     */     this.wrapped.func_147121_ag();
/*     */   }
/*     */   
/*     */   public void shutdown() {
/*     */     this.wrapped.func_71400_g();
/*     */   }
/*     */   
/*     */   public void toggleFullscreen() {
/*     */     this.wrapped.func_71352_k();
/*     */   }
/*     */   
/*     */   public boolean equals(@Nullable Object other) {
/*     */     return (other instanceof MinecraftImpl && Intrinsics.areEqual(((MinecraftImpl)other).wrapped, this.wrapped));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\MinecraftImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */