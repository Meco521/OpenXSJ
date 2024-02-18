/*    */ package net.ccbluex.liquidbounce.ui.client;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class HuaHuo2
/*    */   extends GuiButton
/*    */ {
/*    */   public ResourceLocation img;
/*    */   private int alpha;
/*    */   
/*    */   public HuaHuo2(ResourceLocation res, int buttonId, int x, int y, int widthIn, int hightIn, String buttonText) {
/* 18 */     super(buttonId, x, y, widthIn, hightIn, buttonText);
/* 19 */     this.img = res;
/*    */   }
/*    */   
/*    */   public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 23 */     int color = ColorUtil.interpolateColorsBackAndForth(15, 1, new Color(198, 215, 219), new Color(140, 194, 105), false).getRGB();
/* 24 */     if (this.field_146124_l) {
/* 25 */       this.field_146123_n = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
/* 26 */       int delta = RenderUtils.deltaTime;
/*    */       
/* 28 */       RenderUtils.drawImage4(this.img, this.field_146128_h, this.field_146129_i, this.field_146120_f, this.field_146121_g);
/* 29 */       RenderUtils.drawBorderedRect(this.field_146128_h, this.field_146129_i, (this.field_146128_h + this.field_146120_f), (this.field_146129_i + this.field_146121_g), 1.5F, (new Color(82, 82, 82, 0)).getRGB(), (new Color(20, 20, 20, this.alpha)).getRGB());
/* 30 */       if (this.field_146125_m && this.field_146123_n) {
/*    */         
/* 32 */         this.alpha = (int)(this.alpha + 0.3F * delta);
/* 33 */         if (this.alpha >= 135)
/* 34 */           this.alpha = 135; 
/*    */       } else {
/* 36 */         this.alpha = (int)(this.alpha - 0.3F * delta);
/* 37 */         if (this.alpha <= 10)
/* 38 */           this.alpha = 10; 
/*    */       } 
/* 40 */       Minecraft.func_71410_x().func_110434_K();
/* 41 */       func_146119_b(mc, mouseX, mouseY);
/* 42 */       GlStateManager.func_179117_G();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\HuaHuo2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */