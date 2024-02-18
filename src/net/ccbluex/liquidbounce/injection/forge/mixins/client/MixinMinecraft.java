/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.client;
/*     */ 
/*     */ import java.awt.AWTException;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.Wrapper;
/*     */ import net.ccbluex.liquidbounce.event.ClickBlockEvent;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.KeyEvent;
/*     */ import net.ccbluex.liquidbounce.event.ScreenEvent;
/*     */ import net.ccbluex.liquidbounce.event.TickEvent;
/*     */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.AutoClicker;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.exploit.AbortBreaking;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.world.FastPlace;
/*     */ import net.ccbluex.liquidbounce.injection.backend.EnumFacingImplKt;
/*     */ import net.ccbluex.liquidbounce.injection.backend.GuiScreenImplKt;
/*     */ import net.ccbluex.liquidbounce.injection.backend.WorldClientImplKt;
/*     */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*     */ import net.ccbluex.liquidbounce.injection.backend.utils.BackendExtentionsKt;
/*     */ import net.ccbluex.liquidbounce.ui.client.ButtonLogin;
/*     */ import net.ccbluex.liquidbounce.utils.CPSCounter;
/*     */ import net.ccbluex.liquidbounce.utils.render.IconUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.MiniMapRegister;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.particle.ParticleManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.Util;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.Sys;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.Display;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import tomk.utils.animation.AnimationUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({Minecraft.class})
/*     */ public abstract class MixinMinecraft
/*     */ {
/*     */   @Shadow
/*     */   public GuiScreen field_71462_r;
/*     */   @Shadow
/*     */   public boolean field_71454_w;
/*     */   @Shadow
/*     */   public RayTraceResult field_71476_x;
/*     */   @Shadow
/*     */   public WorldClient field_71441_e;
/*     */   @Shadow
/*     */   public EntityPlayerSP field_71439_g;
/*     */   @Shadow
/*     */   public ParticleManager field_71452_i;
/*  80 */   private long lastFrame = getTime(); @Shadow public PlayerControllerMP field_71442_b; @Shadow public int field_71443_c; @Shadow
/*     */   public int field_71440_d; @Shadow
/*     */   public int field_71467_ac; @Shadow
/*     */   public GameSettings field_71474_y; @Shadow
/*     */   private int field_71429_W; @Inject(method = {"run"}, at = {@At("HEAD")})
/*  85 */   private void init(CallbackInfo callbackInfo) throws IOException, AWTException { if (this.field_71443_c < 1067) {
/*  86 */       this.field_71443_c = 1067;
/*     */     }
/*  88 */     if (this.field_71440_d < 622) {
/*  89 */       this.field_71440_d = 622;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"<init>"}, at = {@At("RETURN")})
/*     */   private void injectWrapperInitializer(CallbackInfo ci) {
/*  96 */     Retreat.wrapper = (Wrapper)WrapperImpl.INSTANCE;
/*     */   }
/*     */   
/*     */   @Inject(method = {"init"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;checkGLError(Ljava/lang/String;)V", ordinal = 2, shift = At.Shift.AFTER)})
/*     */   private void startGame(CallbackInfo callbackInfo) {
/* 101 */     Retreat.INSTANCE.startClient();
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"init"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V", shift = At.Shift.AFTER)})
/*     */   private void afterMainScreen(CallbackInfo callbackInfo) {}
/*     */   
/*     */   @Inject(method = {"createDisplay"}, at = {@At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V", shift = At.Shift.AFTER)})
/*     */   private void createDisplay(CallbackInfo callbackInfo) throws IOException {
/* 110 */     Display.setTitle(" XSJ Client ");
/*     */   }
/*     */   
/*     */   @Inject(method = {"displayGuiScreen"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;currentScreen:Lnet/minecraft/client/gui/GuiScreen;", shift = At.Shift.AFTER)})
/*     */   private void displayGuiScreen(CallbackInfo callbackInfo) {
/* 115 */     if (this.field_71462_r instanceof net.minecraft.client.gui.GuiMainMenu || (this.field_71462_r != null && this.field_71462_r.getClass().getName().startsWith("net.labymod") && this.field_71462_r.getClass().getSimpleName().equals("ModGuiMainMenu"))) {
/* 116 */       this.field_71462_r = (GuiScreen)new ButtonLogin();
/* 117 */       ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
/* 118 */       this.field_71462_r.func_146280_a(Minecraft.func_71410_x(), scaledResolution.func_78326_a(), scaledResolution.func_78328_b());
/* 119 */       this.field_71454_w = false;
/*     */     } 
/* 121 */     Retreat.eventManager.callEvent((Event)new ScreenEvent((this.field_71462_r == null) ? null : GuiScreenImplKt.wrap(this.field_71462_r)));
/*     */   }
/*     */   
/*     */   @Inject(method = {"runGameLoop"}, at = {@At("HEAD")})
/*     */   private void runGameLoop(CallbackInfo callbackInfo) {
/* 126 */     long currentTime = getTime();
/* 127 */     int deltaTime = (int)(currentTime - this.lastFrame);
/* 128 */     this.lastFrame = currentTime;
/*     */     
/* 130 */     AnimationUtils.delta = deltaTime;
/*     */     
/* 132 */     RenderUtils.deltaTime = deltaTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTime() {
/* 137 */     return Sys.getTime() * 1000L / Sys.getTimerResolution();
/*     */   }
/*     */   
/*     */   @Inject(method = {"runTick"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;joinPlayerCounter:I", shift = At.Shift.BEFORE)})
/*     */   private void onTick(CallbackInfo callbackInfo) {
/* 142 */     Retreat.eventManager.callEvent((Event)new TickEvent());
/*     */   }
/*     */   
/*     */   @Inject(method = {"runTickKeyboard"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V", shift = At.Shift.AFTER)})
/*     */   private void onKey(CallbackInfo callbackInfo) {
/* 147 */     if (Keyboard.getEventKeyState() && this.field_71462_r == null)
/* 148 */       Retreat.eventManager.callEvent((Event)new KeyEvent((Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + 256) : Keyboard.getEventKey())); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"sendClickBlockToController"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/math/RayTraceResult;getBlockPos()Lnet/minecraft/util/math/BlockPos;")})
/*     */   private void onClickBlock(CallbackInfo callbackInfo) {
/* 153 */     IBlockState blockState = this.field_71441_e.func_180495_p(this.field_71476_x.func_178782_a());
/*     */     
/* 155 */     if (this.field_71429_W == 0 && blockState.func_177230_c().func_149688_o(blockState) != Material.field_151579_a) {
/* 156 */       Retreat.eventManager.callEvent((Event)new ClickBlockEvent(BackendExtentionsKt.wrap(this.field_71476_x.func_178782_a()), EnumFacingImplKt.wrap(this.field_71476_x.field_178784_b)));
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"setWindowIcon"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void setWindowIcon(CallbackInfo callbackInfo) {
/* 162 */     if (Util.func_110647_a() != Util.EnumOS.OSX) {
/* 163 */       ByteBuffer[] liquidBounceFavicon = IconUtils.getFavicon();
/* 164 */       if (liquidBounceFavicon != null) {
/* 165 */         Display.setIcon(liquidBounceFavicon);
/* 166 */         callbackInfo.cancel();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"shutdown"}, at = {@At("HEAD")})
/*     */   private void shutdown(CallbackInfo callbackInfo) {
/* 173 */     Retreat.INSTANCE.stopClient();
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"clickMouse"}, at = {@At("HEAD")})
/*     */   private void clickMouse(CallbackInfo callbackInfo) {
/* 179 */     CPSCounter.registerClick(CPSCounter.MouseButton.LEFT);
/*     */     
/* 181 */     if (Retreat.moduleManager.getModule(AutoClicker.class).getState())
/* 182 */       this.field_71429_W = 0; 
/*     */   }
/*     */   
/*     */   @Inject(method = {"middleClickMouse"}, at = {@At("HEAD")})
/*     */   private void middleClickMouse(CallbackInfo ci) {
/* 187 */     CPSCounter.registerClick(CPSCounter.MouseButton.MIDDLE);
/*     */   }
/*     */   
/*     */   @Inject(method = {"rightClickMouse"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;rightClickDelayTimer:I", shift = At.Shift.AFTER)})
/*     */   private void rightClickMouse(CallbackInfo callbackInfo) {
/* 192 */     CPSCounter.registerClick(CPSCounter.MouseButton.RIGHT);
/*     */     
/* 194 */     FastPlace fastPlace = (FastPlace)Retreat.moduleManager.getModule(FastPlace.class);
/*     */     
/* 196 */     if (fastPlace.getState())
/* 197 */       this.field_71467_ac = ((Integer)fastPlace.getSpeedValue().get()).intValue(); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"}, at = {@At("HEAD")})
/*     */   private void loadWorld(WorldClient p_loadWorld_1_, String p_loadWorld_2_, CallbackInfo callbackInfo) {
/* 202 */     if (this.field_71441_e != null) {
/* 203 */       MiniMapRegister.INSTANCE.unloadAllChunks();
/*     */     }
/*     */     
/* 206 */     Retreat.eventManager.callEvent((Event)new WorldEvent((p_loadWorld_1_ == null) ? null : WorldClientImplKt.wrap(p_loadWorld_1_)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   private void func_147115_a(boolean leftClick) {
/* 215 */     if (!leftClick) {
/* 216 */       this.field_71429_W = 0;
/*     */     }
/* 218 */     if (this.field_71429_W <= 0 && !this.field_71439_g.func_184587_cr()) {
/* 219 */       if (leftClick && this.field_71476_x != null && this.field_71476_x.field_72313_a == RayTraceResult.Type.BLOCK) {
/* 220 */         BlockPos blockPos = this.field_71476_x.func_178782_a();
/*     */         
/* 222 */         if (this.field_71429_W == 0) {
/* 223 */           Retreat.eventManager.callEvent((Event)new ClickBlockEvent(BackendExtentionsKt.wrap(blockPos), EnumFacingImplKt.wrap(this.field_71476_x.field_178784_b)));
/*     */         }
/*     */         
/* 226 */         IBlockState bs = this.field_71441_e.func_180495_p(blockPos);
/*     */         
/* 228 */         if (bs.func_177230_c().func_149688_o(bs) != Material.field_151579_a && this.field_71442_b.func_180512_c(blockPos, this.field_71476_x.field_178784_b)) {
/* 229 */           this.field_71452_i.func_180532_a(blockPos, this.field_71476_x.field_178784_b);
/* 230 */           this.field_71439_g.func_184609_a(EnumHand.MAIN_HAND);
/*     */         } 
/* 232 */       } else if (!Retreat.moduleManager.getModule(AbortBreaking.class).getState()) {
/* 233 */         this.field_71442_b.func_78767_c();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public int func_90020_K() {
/* 244 */     return (this.field_71441_e == null && this.field_71462_r != null) ? 90 : this.field_71474_y.field_74350_i;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\client\MixinMinecraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */