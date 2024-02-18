/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.Unit;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.color.CustomUI;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AntiBlind;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.NoScoreboard;
/*     */ import net.ccbluex.liquidbounce.ui.font.AWTFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.BanCkeckHelper;
/*     */ import net.ccbluex.liquidbounce.utils.ClassUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiIngame;
/*     */ import net.minecraft.client.gui.GuiPlayerTabOverlay;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumHandSide;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import tomk.module.render.Hotbar;
/*     */ import tomk.utils.BlurBuffer;
/*     */ import tomk.utils.ShadowUtils;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({GuiIngame.class})
/*     */ public abstract class MixinGuiInGame
/*     */   extends MixinGui
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   protected static ResourceLocation field_110330_c;
/*     */   
/*     */   @Inject(method = {"renderScoreboard"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void renderScoreboard(CallbackInfo callbackInfo) {
/*  54 */     if (Retreat.moduleManager.getModule(HUD.class).getState() && NoScoreboard.INSTANCE.getState())
/*  55 */       callbackInfo.cancel(); 
/*     */   }
/*     */   @Shadow
/*     */   @Final
/*     */   protected Minecraft field_73839_d; @Shadow
/*     */   public GuiPlayerTabOverlay field_175196_v;
/*     */   
/*     */   @Overwrite
/*     */   protected void func_184048_a(ScaledResolution p_renderPotionEffects_1_) {}
/*     */   
/*     */   @Overwrite
/*     */   protected void func_180479_a(ScaledResolution sr, float partialTicks) {
/*  67 */     BanCkeckHelper.bancheckhelper = true;
/*  68 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/*  70 */     if (Minecraft.func_71410_x().func_175606_aa() instanceof EntityPlayer && hud.getState() && ((Boolean)hud.getBlackHotbarValue().get()).booleanValue()) {
/*     */       
/*  72 */       EntityPlayer entityPlayer = (EntityPlayer)this.field_73839_d.func_175606_aa();
/*  73 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  74 */       ItemStack itemstack = entityPlayer.func_184592_cb();
/*  75 */       EnumHandSide enumhandside = entityPlayer.func_184591_cq().func_188468_a();
/*  76 */       int middleScreen = sr.func_78326_a() / 2;
/*  77 */       float f = this.field_73735_i;
/*  78 */       int j = 182;
/*  79 */       int k = 91;
/*  80 */       this.field_73735_i = -90.0F;
/*  81 */       int a = 29;
/*  82 */       int b = 5;
/*  83 */       int c = 7;
/*  84 */       GlStateManager.func_179091_B();
/*  85 */       GlStateManager.func_179147_l();
/*  86 */       GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/*  87 */       RenderHelper.func_74520_c(); GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  88 */       if (((Boolean)hud.getInventoryrender().get()).booleanValue() || !hud.getState()) {
/*  89 */         ShadowUtils.shadow(6.0F, () -> {
/*     */               GL11.glPushMatrix();
/*     */               
/*     */               RenderUtils.drawRoundedRect((middleScreen - 101 + b), (sr.func_78328_b() - a), (middleScreen + 120 - c), sr.func_78328_b(), 5.0F, (new Color(0, 0, 0)).getRGB());
/*     */               
/*     */               GL11.glPopMatrix();
/*     */               return null;
/*     */             }() -> {
/*     */               GL11.glPushMatrix();
/*     */               GlStateManager.func_179147_l();
/*     */               GlStateManager.func_179090_x();
/*     */               GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */               RenderUtils.drawRoundedRect((middleScreen - 101 + b), (sr.func_78328_b() - a), (middleScreen + 120 - c), sr.func_78328_b(), 5.0F, (new Color(0, 0, 0)).getRGB());
/*     */               GlStateManager.func_179098_w();
/*     */               GlStateManager.func_179084_k();
/*     */               GL11.glPopMatrix();
/*     */               return null;
/*     */             });
/* 107 */         BlurBuffer.CustomBlurRoundArea((middleScreen - 101 + b), (sr.func_78328_b() - a), (middleScreen + 120 - c - middleScreen - 101 + b), (sr.func_78328_b() - sr.func_78328_b() - a), 5.0F, ((Float)CustomUI.blurValue.get()).floatValue());
/*     */ 
/*     */         
/* 110 */         this.field_73839_d.func_110434_K().func_110577_a(field_110330_c);
/*     */ 
/*     */         
/* 113 */         int i = sr.func_78326_a() / 2;
/* 114 */         int itemX = i - 91 + hud.getHotbarEasePos(entityPlayer.field_71071_by.field_70461_c * 20);
/*     */ 
/*     */         
/* 117 */         Hotbar.render(sr, itemX, partialTicks);
/*     */ 
/*     */ 
/*     */         
/* 121 */         this.field_73735_i = f;
/* 122 */         GlStateManager.func_179091_B();
/* 123 */         GlStateManager.func_179147_l();
/* 124 */         GlStateManager.func_187428_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/* 125 */         RenderHelper.func_74520_c();
/*     */         
/* 127 */         for (int l = 0; l < 9; l++) {
/* 128 */           int i1 = middleScreen - 90 + l * 20 + 2;
/* 129 */           int j1 = sr.func_78328_b() - 16 - 3 - 2;
/* 130 */           func_184044_a(i1 + 5, j1, partialTicks, entityPlayer, (ItemStack)entityPlayer.field_71071_by.field_70462_a.get(l));
/*     */         } 
/*     */ 
/*     */         
/* 134 */         if (this.field_73839_d.field_71474_y.field_186716_M == 2) {
/* 135 */           float f1 = this.field_73839_d.field_71439_g.func_184825_o(0.0F);
/*     */           
/* 137 */           if (f1 < 1.0F) {
/* 138 */             int i2 = sr.func_78328_b() - 20;
/* 139 */             int j2 = middleScreen + 91 + 6;
/*     */             
/* 141 */             if (enumhandside == EnumHandSide.RIGHT) {
/* 142 */               j2 = middleScreen - 91 - 22;
/*     */             }
/*     */             
/* 145 */             this.field_73839_d.func_110434_K().func_110577_a(Gui.field_110324_m);
/* 146 */             int k1 = (int)(f1 * 19.0F);
/* 147 */             GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 148 */             func_73729_b(j2, i2, 0, 94, 18, 18);
/* 149 */             func_73729_b(j2, i2 + 18 - k1, 18, 112 - k1, 18, k1);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 154 */       RenderHelper.func_74518_a();
/* 155 */       GlStateManager.func_179101_C();
/* 156 */       GlStateManager.func_179084_k();
/*     */     } 
/*     */   }
/*     */   private void callRender2DEvent(float partialTicks) {
/* 160 */     if (!ClassUtils.hasClass("net.labymod.api.LabyModAPI")) {
/* 161 */       BlurSettings blur = (BlurSettings)Retreat.moduleManager.getModule(BlurSettings.class);
/*     */       
/* 163 */       blur.blurScreen();
/*     */       
/* 165 */       Retreat.eventManager.callEvent((Event)new Render2DEvent(partialTicks));
/* 166 */       AWTFontRenderer.Companion.garbageCollectionTick();
/*     */     } 
/*     */   }
/*     */   @Inject(method = {"renderHotbar"}, at = {@At("RETURN")})
/*     */   private void renderTooltipPost(ScaledResolution sr, float partialTicks, CallbackInfo callbackInfo) {
/* 171 */     callRender2DEvent(partialTicks);
/*     */   }
/*     */   @Inject(method = {"renderExpBar"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void renderExpBar(ScaledResolution p_renderExpBar_1_, int p_renderExpBar_2_, CallbackInfo ci) {
/* 175 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 176 */     if (((Boolean)hud.hotbar.get()).booleanValue())
/* 177 */       ci.cancel(); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderPotionEffects"}, at = {@At("HEAD")}, cancellable = true)
/*     */   protected void renderPotionEffects(ScaledResolution p_renderPotionEffects_1_, CallbackInfo ci) {
/* 182 */     ci.cancel();
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderSelectedItem"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void renderSelectedItem(ScaledResolution p_renderPlayerStats_1_, CallbackInfo ci) {
/* 187 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 188 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/* 189 */       ci.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"renderPlayerStats"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void renderPlayerStats(ScaledResolution p_renderPlayerStats_1_, CallbackInfo ci) {
/* 197 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/* 198 */     if (((Boolean)hud.hotbar.get()).booleanValue()) {
/* 199 */       ci.cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"renderPumpkinOverlay"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void renderPumpkinOverlay(CallbackInfo callbackInfo) {
/* 205 */     AntiBlind antiBlind = (AntiBlind)Retreat.moduleManager.getModule(AntiBlind.class);
/*     */     
/* 207 */     if (antiBlind.getState() && ((Boolean)antiBlind.getPumpkinEffect().get()).booleanValue())
/* 208 */       callbackInfo.cancel(); 
/*     */   }
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_184044_a(int paramInt1, int paramInt2, float paramFloat, EntityPlayer paramEntityPlayer, ItemStack paramItemStack);
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiInGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */