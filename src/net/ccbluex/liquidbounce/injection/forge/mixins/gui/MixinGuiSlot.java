/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.injection.implementations.IMixinGuiSlot;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiSlot;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({GuiSlot.class})
/*     */ public abstract class MixinGuiSlot implements IMixinGuiSlot {
/*     */   @Shadow
/*     */   public int field_148152_e;
/*     */   @Shadow
/*     */   public int field_148153_b;
/*     */   @Shadow
/*     */   public int field_148155_a;
/*     */   @Shadow
/*     */   public int field_148151_d;
/*     */   @Shadow
/*     */   public int field_148154_c;
/*     */   @Shadow
/*     */   public int field_148158_l;
/*     */   @Shadow
/*     */   protected int field_148150_g;
/*     */   @Shadow
/*     */   protected int field_148162_h;
/*     */   @Shadow
/*     */   protected float field_148169_q;
/*     */   @Shadow
/*     */   protected boolean field_148165_u;
/*     */   @Shadow
/*     */   @Final
/*     */   protected Minecraft field_148161_k;
/*     */   @Shadow
/*     */   protected boolean field_178041_q;
/*  50 */   private int listWidth = 220;
/*     */   
/*     */   private boolean enableScissor = false;
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_148123_a();
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_148121_k();
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_148129_a(int paramInt1, int paramInt2, Tessellator paramTessellator);
/*     */   
/*     */   @Shadow
/*     */   protected abstract int func_148138_e();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_192638_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_148136_c(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   @Shadow
/*     */   public abstract int func_148135_f();
/*     */   
/*     */   @Shadow
/*     */   protected abstract void drawContainerBackground(Tessellator paramTessellator);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_148142_b(int paramInt1, int paramInt2);
/*     */   
/*     */   @Overwrite
/*     */   public void func_148128_a(int mouseXIn, int mouseYIn, float partialTicks) {
/*  86 */     if (this.field_178041_q) {
/*  87 */       this.field_148150_g = mouseXIn;
/*  88 */       this.field_148162_h = mouseYIn;
/*  89 */       func_148123_a();
/*  90 */       int i = func_148137_d();
/*  91 */       int j = i + 6;
/*  92 */       func_148121_k();
/*  93 */       GlStateManager.func_179140_f();
/*  94 */       GlStateManager.func_179106_n();
/*  95 */       Tessellator tessellator = Tessellator.func_178181_a();
/*  96 */       BufferBuilder bufferbuilder = tessellator.func_178180_c();
/*     */ 
/*     */       
/*  99 */       int k = this.field_148152_e + this.field_148155_a / 2 - func_148139_c() / 2 + 2;
/* 100 */       int l = this.field_148153_b + 4 - (int)this.field_148169_q;
/*     */       
/* 102 */       if (this.field_148165_u) {
/* 103 */         func_148129_a(k, l, tessellator);
/*     */       }
/*     */       
/* 106 */       RenderUtils.makeScissorBox(this.field_148152_e, this.field_148153_b, this.field_148151_d, this.field_148154_c);
/*     */       
/* 108 */       GL11.glEnable(3089);
/*     */       
/* 110 */       func_192638_a(k, l, mouseXIn, mouseYIn, partialTicks);
/*     */       
/* 112 */       GL11.glDisable(3089);
/*     */       
/* 114 */       ScaledResolution scaledResolution = new ScaledResolution(this.field_148161_k);
/*     */       
/* 116 */       GlStateManager.func_179097_i();
/* 117 */       Gui.func_73734_a(0, 0, scaledResolution.func_78326_a(), this.field_148153_b, -2147483648);
/* 118 */       Gui.func_73734_a(0, this.field_148154_c, scaledResolution.func_78326_a(), this.field_148158_l, -2147483648);
/*     */       
/* 120 */       GL11.glEnable(3042);
/* 121 */       GlStateManager.func_179120_a(770, 771, 0, 1);
/* 122 */       GlStateManager.func_179118_c();
/* 123 */       GlStateManager.func_179103_j(7425);
/* 124 */       GlStateManager.func_179090_x();
/* 125 */       int i1 = 4;
/* 126 */       bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181706_f);
/* 127 */       bufferbuilder.func_181662_b(this.field_148152_e, (this.field_148153_b + i1), 0.0D).func_181669_b(0, 0, 0, 0).func_181675_d();
/* 128 */       bufferbuilder.func_181662_b(this.field_148151_d, (this.field_148153_b + i1), 0.0D).func_181669_b(0, 0, 0, 0).func_181675_d();
/* 129 */       bufferbuilder.func_181662_b(this.field_148151_d, this.field_148153_b, 0.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 130 */       bufferbuilder.func_181662_b(this.field_148152_e, this.field_148153_b, 0.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 131 */       tessellator.func_78381_a();
/* 132 */       bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181706_f);
/* 133 */       bufferbuilder.func_181662_b(this.field_148152_e, this.field_148154_c, 0.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 134 */       bufferbuilder.func_181662_b(this.field_148151_d, this.field_148154_c, 0.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 135 */       bufferbuilder.func_181662_b(this.field_148151_d, (this.field_148154_c - i1), 0.0D).func_181669_b(0, 0, 0, 0).func_181675_d();
/* 136 */       bufferbuilder.func_181662_b(this.field_148152_e, (this.field_148154_c - i1), 0.0D).func_181669_b(0, 0, 0, 0).func_181675_d();
/* 137 */       tessellator.func_78381_a();
/* 138 */       int j1 = func_148135_f();
/*     */       
/* 140 */       if (j1 > 0) {
/* 141 */         int k1 = (this.field_148154_c - this.field_148153_b) * (this.field_148154_c - this.field_148153_b) / func_148138_e();
/* 142 */         k1 = MathHelper.func_76125_a(k1, 32, this.field_148154_c - this.field_148153_b - 8);
/* 143 */         int l1 = (int)this.field_148169_q * (this.field_148154_c - this.field_148153_b - k1) / j1 + this.field_148153_b;
/*     */         
/* 145 */         if (l1 < this.field_148153_b) {
/* 146 */           l1 = this.field_148153_b;
/*     */         }
/*     */         
/* 149 */         bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 150 */         bufferbuilder.func_181662_b(i, this.field_148154_c, 0.0D).func_187315_a(0.0D, 1.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 151 */         bufferbuilder.func_181662_b(j, this.field_148154_c, 0.0D).func_187315_a(1.0D, 1.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 152 */         bufferbuilder.func_181662_b(j, this.field_148153_b, 0.0D).func_187315_a(1.0D, 0.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 153 */         bufferbuilder.func_181662_b(i, this.field_148153_b, 0.0D).func_187315_a(0.0D, 0.0D).func_181669_b(0, 0, 0, 255).func_181675_d();
/* 154 */         tessellator.func_78381_a();
/* 155 */         bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 156 */         bufferbuilder.func_181662_b(i, (l1 + k1), 0.0D).func_187315_a(0.0D, 1.0D).func_181669_b(128, 128, 128, 255).func_181675_d();
/* 157 */         bufferbuilder.func_181662_b(j, (l1 + k1), 0.0D).func_187315_a(1.0D, 1.0D).func_181669_b(128, 128, 128, 255).func_181675_d();
/* 158 */         bufferbuilder.func_181662_b(j, l1, 0.0D).func_187315_a(1.0D, 0.0D).func_181669_b(128, 128, 128, 255).func_181675_d();
/* 159 */         bufferbuilder.func_181662_b(i, l1, 0.0D).func_187315_a(0.0D, 0.0D).func_181669_b(128, 128, 128, 255).func_181675_d();
/* 160 */         tessellator.func_78381_a();
/* 161 */         bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 162 */         bufferbuilder.func_181662_b(i, (l1 + k1 - 1), 0.0D).func_187315_a(0.0D, 1.0D).func_181669_b(192, 192, 192, 255).func_181675_d();
/* 163 */         bufferbuilder.func_181662_b((j - 1), (l1 + k1 - 1), 0.0D).func_187315_a(1.0D, 1.0D).func_181669_b(192, 192, 192, 255).func_181675_d();
/* 164 */         bufferbuilder.func_181662_b((j - 1), l1, 0.0D).func_187315_a(1.0D, 0.0D).func_181669_b(192, 192, 192, 255).func_181675_d();
/* 165 */         bufferbuilder.func_181662_b(i, l1, 0.0D).func_187315_a(0.0D, 0.0D).func_181669_b(192, 192, 192, 255).func_181675_d();
/* 166 */         tessellator.func_78381_a();
/*     */       } 
/*     */       
/* 169 */       func_148142_b(mouseXIn, mouseYIn);
/* 170 */       GlStateManager.func_179098_w();
/* 171 */       GlStateManager.func_179103_j(7424);
/* 172 */       GlStateManager.func_179141_d();
/* 173 */       GlStateManager.func_179084_k();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   protected int func_148137_d() {
/* 183 */     return this.field_148155_a - 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnableScissor(boolean enableScissor) {
/* 188 */     this.enableScissor = enableScissor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public int func_148139_c() {
/* 197 */     return this.listWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setListWidth(int listWidth) {
/* 202 */     this.listWidth = listWidth;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiSlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */