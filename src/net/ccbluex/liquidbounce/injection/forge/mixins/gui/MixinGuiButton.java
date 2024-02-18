/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*    */ import net.ccbluex.liquidbounce.ui.font.FontDrawer;
/*    */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import tomk.utils.SuperLib;
/*    */ import tomk.utils.animation.AnimationUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({GuiButton.class})
/*    */ public abstract class MixinGuiButton
/*    */   extends Gui
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   protected static ResourceLocation field_146122_a;
/*    */   @Shadow
/*    */   public boolean field_146125_m;
/*    */   @Shadow
/*    */   public int field_146128_h;
/*    */   @Shadow
/*    */   public int field_146129_i;
/*    */   @Shadow
/*    */   public int field_146120_f;
/*    */   @Shadow
/*    */   public int field_146121_g;
/*    */   @Shadow
/*    */   public boolean field_146124_l;
/*    */   @Shadow
/*    */   public String field_146126_j;
/*    */   @Shadow
/*    */   protected boolean field_146123_n;
/*    */   private float cut;
/*    */   private float alpha;
/* 55 */   private double animation = 0.10000000149011612D;
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   protected abstract void func_146119_b(Minecraft paramMinecraft, int paramInt1, int paramInt2);
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 64 */     if (this.field_146125_m) {
/* 65 */       FontDrawer fr = FontLoaders.F18;
/* 66 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 67 */       this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
/* 68 */       GlStateManager.func_179147_l();
/* 69 */       this.animation = AnimationUtil.moveUD((float)this.animation, this.field_146123_n ? 0.3F : 0.1F, 10.0F / Minecraft.func_175610_ah(), 4.0F / Minecraft.func_175610_ah());
/* 70 */       if (this.field_146124_l) {
/* 71 */         RenderUtils.drawGradientSideways(this.field_146128_h, ((this.field_146129_i + this.field_146121_g) - 1.5F), (this.field_146128_h + this.field_146120_f), (this.field_146129_i + this.field_146121_g), SuperLib.reAlpha((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), 0.95F), SuperLib.reAlpha((new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 0.95F));
/*    */       } else {
/* 73 */         RenderUtils.drawGradientSideways(this.field_146128_h, ((this.field_146129_i + this.field_146121_g) - 1.5F), (this.field_146128_h + this.field_146120_f), (this.field_146129_i + this.field_146121_g), SuperLib.reAlpha((new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 0.95F), SuperLib.reAlpha((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), 0.95F));
/*    */       } 
/*    */       
/* 76 */       RenderUtils.drawRect(this.field_146128_h, this.field_146129_i, (this.field_146128_h + this.field_146120_f), (this.field_146129_i + this.field_146121_g) - 1.5F, (new Color(0, 0, 0, 180)).getRGB());
/* 77 */       if (this.field_146124_l) {
/* 78 */         RenderUtils.drawRect(this.field_146128_h, this.field_146129_i, (this.field_146128_h + this.field_146120_f), (this.field_146129_i + this.field_146121_g), SuperLib.reAlpha((new Color(225, 225, 225)).getRGB(), (float)this.animation));
/*    */       } else {
/* 80 */         RenderUtils.drawRect(this.field_146128_h, this.field_146129_i, (this.field_146128_h + this.field_146120_f), (this.field_146129_i + this.field_146121_g), SuperLib.reAlpha((new Color(255, 255, 255)).getRGB(), 0.1F));
/*    */       } 
/*    */       
/* 83 */       func_146119_b(mc, mouseX, mouseY);
/* 84 */       fr.drawStringWithShadow(this.field_146126_j, (this.field_146128_h + this.field_146120_f / 2 - fr
/*    */           
/* 86 */           .getStringWidth(this.field_146126_j) / 2), this.field_146129_i + (this.field_146121_g - 5) / 2.0F - 2.0F, Color.WHITE
/* 87 */           .getRGB());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */