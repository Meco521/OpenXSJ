/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.injection.backend.FontRendererImpl;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraftforge.fml.client.config.GuiButtonExt;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({GuiButtonExt.class})
/*    */ public abstract class MixinGuiButtonExt
/*    */   extends GuiButton
/*    */ {
/*    */   private float cut;
/*    */   private float alpha;
/*    */   
/*    */   public MixinGuiButtonExt(int p_i1020_1_, int p_i1020_2_, int p_i1020_3_, String p_i1020_4_) {
/* 27 */     super(p_i1020_1_, p_i1020_2_, p_i1020_3_, p_i1020_4_);
/*    */   }
/*    */ 
/*    */   
/*    */   public MixinGuiButtonExt(int p_i46323_1_, int p_i46323_2_, int p_i46323_3_, int p_i46323_4_, int p_i46323_5_, String p_i46323_6_) {
/* 32 */     super(p_i46323_1_, p_i46323_2_, p_i46323_3_, p_i46323_4_, p_i46323_5_, p_i46323_6_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 41 */     if (this.field_146125_m) {
/*    */       
/* 43 */       FontRenderer fontRenderer = mc.func_135016_M().func_135042_a() ? mc.field_71466_p : ((FontRendererImpl)Fonts.roboto35).getWrapped();
/* 44 */       this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
/*    */ 
/*    */       
/* 47 */       int delta = RenderUtils.deltaTime;
/*    */       
/* 49 */       if (this.field_146124_l && this.field_146123_n) {
/* 50 */         this.cut += 0.05F * delta;
/*    */         
/* 52 */         if (this.cut >= 4.0F) this.cut = 4.0F;
/*    */         
/* 54 */         this.alpha += 0.3F * delta;
/*    */         
/* 56 */         if (this.alpha >= 210.0F) this.alpha = 210.0F; 
/*    */       } else {
/* 58 */         this.cut -= 0.05F * delta;
/*    */         
/* 60 */         if (this.cut <= 0.0F) this.cut = 0.0F;
/*    */         
/* 62 */         this.alpha -= 0.3F * delta;
/*    */         
/* 64 */         if (this.alpha <= 120.0F) this.alpha = 120.0F;
/*    */       
/*    */       } 
/* 67 */       Gui.func_73734_a(this.field_146128_h + (int)this.cut, this.field_146129_i, this.field_146128_h + this.field_146120_f - (int)this.cut, this.field_146129_i + this.field_146121_g, this.field_146124_l ? (new Color(0.0F, 0.0F, 0.0F, this.alpha / 255.0F))
/*    */           
/* 69 */           .getRGB() : (new Color(0.5F, 0.5F, 0.5F, 0.5F))
/* 70 */           .getRGB());
/*    */       
/* 72 */       mc.func_110434_K().func_110577_a(field_146122_a);
/* 73 */       func_146119_b(mc, mouseX, mouseY);
/*    */       
/* 75 */       fontRenderer.func_175063_a(this.field_146126_j, (this.field_146128_h + this.field_146120_f / 2 - fontRenderer
/*    */           
/* 77 */           .func_78256_a(this.field_146126_j) / 2), this.field_146129_i + (this.field_146121_g - 5) / 2.0F, 14737632);
/*    */       
/* 79 */       GlStateManager.func_179117_G();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiButtonExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */