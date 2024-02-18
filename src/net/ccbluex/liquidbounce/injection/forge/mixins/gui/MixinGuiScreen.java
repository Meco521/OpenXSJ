/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.misc.ComponentOnHover;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.injection.backend.ResourceLocationImplKt;
/*     */ import net.ccbluex.liquidbounce.ui.client.GuiBackground;
/*     */ import net.ccbluex.liquidbounce.utils.render.ParticleUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.BackgroundShader;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.Style;
/*     */ import net.minecraft.util.text.event.ClickEvent;
/*     */ import net.minecraft.util.text.event.HoverEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({GuiScreen.class})
/*     */ public abstract class MixinGuiScreen
/*     */ {
/*     */   @Shadow
/*     */   public Minecraft field_146297_k;
/*     */   @Shadow
/*     */   public List<GuiButton> field_146292_n;
/*     */   @Shadow
/*     */   public int field_146294_l;
/*     */   @Shadow
/*     */   public int field_146295_m;
/*     */   @Shadow
/*     */   public FontRenderer field_146289_q;
/*     */   
/*     */   @Shadow
/*     */   public void func_73876_c() {}
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_175272_a(ITextComponent paramITextComponent, int paramInt1, int paramInt2);
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_146283_a(List<String> paramList, int paramInt1, int paramInt2);
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_146276_q_();
/*     */   
/*     */   @Inject(method = {"drawWorldBackground"}, at = {@At("HEAD")})
/*     */   private void drawWorldBackground(CallbackInfo callbackInfo) {
/*  71 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/*  73 */     if (((Boolean)hud.getInventoryParticle().get()).booleanValue() && this.field_146297_k.field_71439_g != null) {
/*  74 */       ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
/*  75 */       int width = scaledResolution.func_78326_a();
/*  76 */       int height = scaledResolution.func_78328_b();
/*  77 */       ParticleUtils.drawParticles(Mouse.getX() * width / this.field_146297_k.field_71443_c, height - Mouse.getY() * height / this.field_146297_k.field_71440_d - 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"drawBackground"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void drawClientBackground(CallbackInfo callbackInfo) {
/*  86 */     GlStateManager.func_179140_f();
/*  87 */     GlStateManager.func_179106_n();
/*     */     
/*  89 */     if (GuiBackground.Companion.getEnabled()) {
/*  90 */       if (Retreat.INSTANCE.getBackground() == null) {
/*  91 */         BackgroundShader.BACKGROUND_SHADER.startShader();
/*     */         
/*  93 */         Tessellator instance = Tessellator.func_178181_a();
/*  94 */         BufferBuilder worldRenderer = instance.func_178180_c();
/*  95 */         worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
/*  96 */         worldRenderer.func_181662_b(0.0D, this.field_146295_m, 0.0D).func_181675_d();
/*  97 */         worldRenderer.func_181662_b(this.field_146294_l, this.field_146295_m, 0.0D).func_181675_d();
/*  98 */         worldRenderer.func_181662_b(this.field_146294_l, 0.0D, 0.0D).func_181675_d();
/*  99 */         worldRenderer.func_181662_b(0.0D, 0.0D, 0.0D).func_181675_d();
/* 100 */         instance.func_78381_a();
/*     */         
/* 102 */         BackgroundShader.BACKGROUND_SHADER.stopShader();
/*     */       } else {
/* 104 */         ScaledResolution scaledResolution = new ScaledResolution(this.field_146297_k);
/* 105 */         int width = scaledResolution.func_78326_a();
/* 106 */         int height = scaledResolution.func_78328_b();
/*     */         
/* 108 */         this.field_146297_k.func_110434_K().func_110577_a(ResourceLocationImplKt.unwrap(Retreat.INSTANCE.getBackground()));
/* 109 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 110 */         Gui.func_152125_a(0, 0, 0.0F, 0.0F, width, height, width, height, width, height);
/*     */       } 
/*     */       
/* 113 */       if (GuiBackground.Companion.getParticles())
/* 114 */         ParticleUtils.drawParticles(Mouse.getX() * this.field_146294_l / this.field_146297_k.field_71443_c, this.field_146295_m - Mouse.getY() * this.field_146295_m / this.field_146297_k.field_71440_d - 1); 
/* 115 */       callbackInfo.cancel();
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"drawBackground"}, at = {@At("RETURN")})
/*     */   private void drawParticles(CallbackInfo callbackInfo) {
/* 121 */     if (GuiBackground.Companion.getParticles())
/* 122 */       ParticleUtils.drawParticles(Mouse.getX() * this.field_146294_l / this.field_146297_k.field_71443_c, this.field_146295_m - Mouse.getY() * this.field_146295_m / this.field_146297_k.field_71440_d - 1); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"sendChatMessage(Ljava/lang/String;Z)V"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void messageSend(String msg, boolean addToChat, CallbackInfo callbackInfo) {
/* 127 */     if (msg.startsWith(String.valueOf(Retreat.commandManager.getPrefix())) && addToChat) {
/* 128 */       this.field_146297_k.field_71456_v.func_146158_b().func_146239_a(msg);
/*     */       
/* 130 */       Retreat.commandManager.executeCommands(msg);
/* 131 */       callbackInfo.cancel();
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"handleComponentHover"}, at = {@At("HEAD")})
/*     */   private void handleHoverOverComponent(ITextComponent component, int x, int y, CallbackInfo callbackInfo) {
/* 137 */     if (component == null || component.func_150256_b().func_150235_h() == null || !Retreat.moduleManager.getModule(ComponentOnHover.class).getState()) {
/*     */       return;
/*     */     }
/* 140 */     Style chatStyle = component.func_150256_b();
/*     */     
/* 142 */     ClickEvent clickEvent = chatStyle.func_150235_h();
/* 143 */     HoverEvent hoverEvent = chatStyle.func_150210_i();
/*     */     
/* 145 */     func_146283_a(Collections.singletonList("§c§l" + clickEvent.func_150669_a().func_150673_b().toUpperCase() + ": §a" + clickEvent.func_150668_b()), x, y - ((hoverEvent != null) ? 17 : 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   protected void func_146284_a(GuiButton button) throws IOException {
/* 154 */     injectedActionPerformed(button);
/*     */   }
/*     */   
/*     */   protected void injectedActionPerformed(GuiButton button) {}
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */