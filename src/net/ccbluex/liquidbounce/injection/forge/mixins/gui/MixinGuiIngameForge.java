/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Animations;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.AnimationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraftforge.client.GuiIngameForge;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.Slice;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({GuiIngameForge.class})
/*     */ public abstract class MixinGuiIngameForge
/*     */   extends MixinGuiInGame
/*     */ {
/*  41 */   public float xScale = 0.0F;
/*     */ 
/*     */   
/*     */   @Shadow(remap = false)
/*     */   abstract boolean pre(RenderGameOverlayEvent.ElementType paramElementType);
/*     */ 
/*     */   
/*     */   @Inject(method = {"renderChat"}, slice = {@Slice(from = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/common/eventhandler/EventBus;post(Lnet/minecraftforge/fml/common/eventhandler/Event;)Z", ordinal = 0, remap = false))}, at = {@At(value = "RETURN", ordinal = 0)}, remap = false)
/*     */   private void fixProfilerSectionNotEnding(int width, int height, CallbackInfo ci) {
/*  50 */     Minecraft mc = Minecraft.func_71410_x();
/*  51 */     if (mc.field_71424_I.func_76322_c().endsWith("chat"))
/*  52 */       mc.field_71424_I.func_76319_b(); 
/*     */   } @Shadow(remap = false)
/*     */   abstract void post(RenderGameOverlayEvent.ElementType paramElementType);
/*     */   @Inject(method = {"renderExperience"}, at = {@At("HEAD")}, remap = false)
/*     */   private void enableExperienceAlpha(int filled, int top, CallbackInfo ci) {
/*  57 */     GlStateManager.func_179141_d();
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderExperience"}, at = {@At("RETURN")}, remap = false)
/*     */   private void disableExperienceAlpha(int filled, int top, CallbackInfo ci) {
/*  62 */     GlStateManager.func_179118_c();
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderExperience"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/*     */   private void renderExperience(int width, int height, CallbackInfo ci) {
/*  67 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*  68 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/*  69 */       ci.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"renderToolHighlight"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/*     */   protected void renderToolHighlight(ScaledResolution res, CallbackInfo ci) {
/*  76 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*  77 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/*  78 */       ci.cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderFood"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/*     */   private void renderPlayerStats(int width, int height, CallbackInfo ci) {
/*  84 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*  85 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/*  86 */       ci.cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderHealth"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/*     */   private void renderHealth(int width, int height, CallbackInfo ci) {
/*  92 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*  93 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/*  94 */       ci.cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderArmor"}, at = {@At("HEAD")}, cancellable = true, remap = false)
/*     */   private void renderArmor(int width, int height, CallbackInfo ci) {
/* 100 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 101 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/* 102 */       ci.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite(remap = false)
/*     */   protected void renderPlayerList(int width, int height) {
/* 111 */     Minecraft mc = Minecraft.func_71410_x();
/* 112 */     ScoreObjective scoreobjective = mc.field_71441_e.func_96441_U().func_96539_a(0);
/* 113 */     NetHandlerPlayClient handler = MinecraftInstance.mc2.field_71439_g.field_71174_a;
/* 114 */     if (!mc.func_71387_A() || handler.func_175106_d().size() > 1 || scoreobjective != null) {
/*     */       
/* 116 */       this.xScale = AnimationUtils.animate(mc.field_71474_y.field_74321_H.func_151470_d() ? 100.0F : 0.0F, this.xScale, ((String)Animations.tabAnimations.get()).equalsIgnoreCase("none") ? 1.0F : (0.0125F * RenderUtils.deltaTime));
/* 117 */       float rescaled = this.xScale / 100.0F;
/* 118 */       boolean displayable = (rescaled > 0.0F);
/* 119 */       this.field_175196_v.func_175246_a(displayable);
/* 120 */       if (!displayable || pre(RenderGameOverlayEvent.ElementType.PLAYER_LIST))
/* 121 */         return;  GlStateManager.func_179094_E();
/* 122 */       switch (((String)Animations.tabAnimations.get()).toLowerCase()) {
/*     */         case "zoom":
/* 124 */           GlStateManager.func_179109_b(width / 2.0F * (1.0F - rescaled), 0.0F, 0.0F);
/* 125 */           GlStateManager.func_179152_a(rescaled, rescaled, rescaled);
/*     */           break;
/*     */         case "slide":
/* 128 */           GlStateManager.func_179152_a(1.0F, rescaled, 1.0F);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 134 */       this.field_175196_v.func_175249_a(width, mc.field_71441_e.func_96441_U(), scoreobjective);
/* 135 */       GlStateManager.func_179121_F();
/* 136 */       post(RenderGameOverlayEvent.ElementType.PLAYER_LIST);
/*     */     }
/*     */     else {
/*     */       
/* 140 */       this.field_175196_v.func_175246_a(false);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiIngameForge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */