/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.utils.render.EaseUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ChatLine;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiNewChat;
/*     */ import net.minecraft.client.gui.GuiUtilRenderComponents;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.TextComponentString;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mixin({GuiNewChat.class})
/*     */ public abstract class MixinGuiNewChat
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   private Minecraft field_146247_f;
/*     */   @Shadow
/*     */   @Final
/*     */   private List<ChatLine> field_146253_i;
/*     */   @Shadow
/*     */   private int field_146250_j;
/*     */   @Shadow
/*     */   private boolean field_146251_k;
/*     */   
/*     */   @Shadow
/*     */   public abstract int func_146232_i();
/*     */   
/*     */   @Shadow
/*     */   public abstract boolean func_146241_e();
/*     */   
/*     */   @Shadow
/*     */   public abstract float func_146244_h();
/*     */   
/*     */   @Shadow
/*     */   public abstract int func_146228_f();
/*     */   
/*     */   @Inject(method = {"drawChat"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void drawChat(int p_drawChat_1_, CallbackInfo callbackInfo) {
/*  58 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/*  60 */     if (hud.getState() && ((Boolean)hud.getFontChatValue().get()).booleanValue()) {
/*  61 */       callbackInfo.cancel();
/*  62 */       if (this.field_146247_f.field_71474_y.field_74343_n != EntityPlayer.EnumChatVisibility.HIDDEN) {
/*  63 */         int lvt_2_1_ = func_146232_i();
/*  64 */         boolean lvt_3_1_ = false;
/*  65 */         int lvt_4_1_ = 0;
/*  66 */         int lvt_5_1_ = this.field_146253_i.size();
/*  67 */         float lvt_6_1_ = this.field_146247_f.field_71474_y.field_74357_r * 0.9F + 0.1F;
/*  68 */         if (lvt_5_1_ > 0) {
/*  69 */           if (func_146241_e()) {
/*  70 */             lvt_3_1_ = true;
/*     */           }
/*     */           
/*  73 */           float lvt_7_1_ = func_146244_h();
/*  74 */           int lvt_8_1_ = MathHelper.func_76123_f(func_146228_f() / lvt_7_1_);
/*  75 */           GlStateManager.func_179094_E();
/*  76 */           GlStateManager.func_179109_b(2.0F, 20.0F, 0.0F);
/*  77 */           GlStateManager.func_179152_a(lvt_7_1_, lvt_7_1_, 1.0F);
/*     */ 
/*     */           
/*     */           int lvt_9_1_;
/*     */           
/*  82 */           for (lvt_9_1_ = 0; lvt_9_1_ + this.field_146250_j < this.field_146253_i.size() && lvt_9_1_ < lvt_2_1_; lvt_9_1_++) {
/*  83 */             ChatLine lvt_10_1_ = this.field_146253_i.get(lvt_9_1_ + this.field_146250_j);
/*  84 */             if (lvt_10_1_ != null) {
/*  85 */               int lvt_11_1_ = p_drawChat_1_ - lvt_10_1_.func_74540_b();
/*  86 */               if (lvt_11_1_ < 200 || lvt_3_1_) {
/*  87 */                 double lvt_12_1_ = lvt_11_1_ / 200.0D;
/*  88 */                 lvt_12_1_ = 1.0D - lvt_12_1_;
/*  89 */                 lvt_12_1_ *= 10.0D;
/*  90 */                 lvt_12_1_ = MathHelper.func_151237_a(lvt_12_1_, 0.0D, 1.0D);
/*  91 */                 lvt_12_1_ *= lvt_12_1_;
/*  92 */                 int lvt_14_1_ = (int)(255.0D * lvt_12_1_);
/*  93 */                 if (lvt_3_1_) {
/*  94 */                   lvt_14_1_ = 255;
/*     */                 }
/*     */                 
/*  97 */                 lvt_14_1_ = (int)(lvt_14_1_ * lvt_6_1_);
/*  98 */                 lvt_4_1_++;
/*  99 */                 if (lvt_14_1_ > 3) {
/* 100 */                   int lvt_15_1_ = 0;
/* 101 */                   int lvt_16_1_ = -lvt_9_1_ * 9;
/* 102 */                   if (((Boolean)hud.getChatAnimValue().get()).booleanValue() && !lvt_3_1_) {
/* 103 */                     if (lvt_11_1_ <= 20) {
/* 104 */                       GL11.glTranslatef((float)(-(lvt_8_1_ + 4) * EaseUtils.INSTANCE.easeInQuart(1.0D - (lvt_11_1_ + this.field_146247_f.field_71428_T.field_194147_b) / 20.0D)), 0.0F, 0.0F);
/*     */                     }
/* 106 */                     if (lvt_11_1_ >= 180) {
/* 107 */                       GL11.glTranslatef((float)(-(lvt_8_1_ + 4) * EaseUtils.INSTANCE.easeInQuart((lvt_11_1_ + this.field_146247_f.field_71428_T.field_194147_b - 180.0F) / 20.0D)), 0.0F, 0.0F);
/*     */                     }
/*     */                   } 
/* 110 */                   if (((Boolean)hud.getChatRect().get()).booleanValue()) {
/* 111 */                     Gui.func_73734_a(lvt_15_1_, lvt_16_1_ - 15, lvt_15_1_ + lvt_8_1_ + 4, lvt_16_1_ - 6, lvt_14_1_ / 2 << 24);
/*     */                   }
/*     */                   
/* 114 */                   GlStateManager.func_179147_l();
/* 115 */                   GlStateManager.func_179141_d();
/*     */                   
/* 117 */                   String lvt_17_1_ = lvt_10_1_.func_151461_a().func_150254_d();
/* 118 */                   FontLoaders.C18.drawStringWithShadow(lvt_17_1_, (lvt_15_1_ + 2), (lvt_16_1_ - 14), 16777215 + (lvt_14_1_ << 24));
/* 119 */                   GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 120 */                   GlStateManager.func_179117_G();
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 126 */           if (lvt_3_1_) {
/* 127 */             lvt_9_1_ = FontLoaders.C18.FONT_HEIGHT;
/* 128 */             GlStateManager.func_179109_b(-3.0F, 0.0F, 0.0F);
/* 129 */             int lvt_10_2_ = lvt_5_1_ * lvt_9_1_ + lvt_5_1_;
/* 130 */             int lvt_11_1_ = lvt_4_1_ * lvt_9_1_ + lvt_4_1_;
/* 131 */             int lvt_12_2_ = this.field_146250_j * lvt_11_1_ / lvt_5_1_;
/* 132 */             int lvt_13_1_ = lvt_11_1_ * lvt_11_1_ / lvt_10_2_;
/* 133 */             if (lvt_10_2_ != lvt_11_1_) {
/* 134 */               int lvt_14_1_ = (lvt_12_2_ > 0) ? 170 : 96;
/* 135 */               int lvt_15_2_ = this.field_146251_k ? 13382451 : 3355562;
/* 136 */               Gui.func_73734_a(0, -lvt_12_2_, 2, -lvt_12_2_ - lvt_13_1_, lvt_15_2_ + (lvt_14_1_ << 24));
/* 137 */               Gui.func_73734_a(2, -lvt_12_2_, 1, -lvt_12_2_ - lvt_13_1_, 13421772 + (lvt_14_1_ << 24));
/*     */             } 
/*     */           } 
/*     */           
/* 141 */           GlStateManager.func_179121_F();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"getChatComponent"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void getChatComponent(int p_getChatComponent_1_, int p_getChatComponent_2_, CallbackInfoReturnable<ITextComponent> callbackInfo) {
/* 188 */     HUD hud = (HUD)Retreat.moduleManager.getModule(HUD.class);
/*     */     
/* 190 */     if (hud.getState() && ((Boolean)hud.getFontChatValue().get()).booleanValue()) {
/* 191 */       if (func_146241_e()) {
/* 192 */         ScaledResolution lvt_3_1_ = new ScaledResolution(this.field_146247_f);
/* 193 */         int lvt_4_1_ = lvt_3_1_.func_78325_e();
/* 194 */         float lvt_5_1_ = func_146244_h();
/* 195 */         int lvt_6_1_ = p_getChatComponent_1_ / lvt_4_1_ - 3;
/* 196 */         int lvt_7_1_ = p_getChatComponent_2_ / lvt_4_1_ - 27;
/* 197 */         lvt_6_1_ = MathHelper.func_76141_d(lvt_6_1_ / lvt_5_1_);
/* 198 */         lvt_7_1_ = MathHelper.func_76141_d(lvt_7_1_ / lvt_5_1_);
/* 199 */         if (lvt_6_1_ >= 0 && lvt_7_1_ >= 0) {
/* 200 */           int lvt_8_1_ = Math.min(func_146232_i(), this.field_146253_i.size());
/* 201 */           if (lvt_6_1_ <= MathHelper.func_76141_d(func_146228_f() / func_146244_h()) && lvt_7_1_ < FontLoaders.C18.FONT_HEIGHT * lvt_8_1_ + lvt_8_1_) {
/* 202 */             int lvt_9_1_ = lvt_7_1_ / FontLoaders.C18.FONT_HEIGHT + this.field_146250_j;
/* 203 */             if (lvt_9_1_ >= 0 && lvt_9_1_ < this.field_146253_i.size()) {
/* 204 */               ChatLine lvt_10_1_ = this.field_146253_i.get(lvt_9_1_);
/* 205 */               int lvt_11_1_ = 0;
/*     */               
/* 207 */               for (ITextComponent lvt_13_1_ : lvt_10_1_.func_151461_a()) {
/* 208 */                 if (lvt_13_1_ instanceof TextComponentString) {
/* 209 */                   lvt_11_1_ += FontLoaders.C18.getStringWidth(GuiUtilRenderComponents.func_178909_a(((TextComponentString)lvt_13_1_).func_150265_g(), false));
/* 210 */                   if (lvt_11_1_ > lvt_6_1_) {
/* 211 */                     callbackInfo.setReturnValue(lvt_13_1_);
/*     */ 
/*     */                     
/*     */                     return;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 223 */       callbackInfo.setReturnValue(null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiNewChat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */