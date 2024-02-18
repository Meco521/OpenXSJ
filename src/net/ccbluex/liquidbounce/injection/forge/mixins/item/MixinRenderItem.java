/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.item;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.EnchantEffect;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.RenderItem;
/*    */ import net.minecraft.client.renderer.block.model.IBakedModel;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.client.resources.IResourceManager;
/*    */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({RenderItem.class})
/*    */ public abstract class MixinRenderItem
/*    */   implements IResourceManagerReloadListener {
/*    */   @Final
/*    */   @Shadow
/* 29 */   private static final ResourceLocation field_110798_h = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*    */   
/*    */   @Final
/*    */   @Shadow
/*    */   private TextureManager field_175057_n;
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   public abstract void func_110549_a(IResourceManager paramIResourceManager);
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   protected abstract void func_191965_a(IBakedModel paramIBakedModel, int paramInt);
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   private void func_191966_a(IBakedModel p_renderEffect_1_) {
/* 46 */     EnchantEffect effect = (EnchantEffect)Retreat.moduleManager.get(EnchantEffect.class);
/*    */     
/* 48 */     Color color = ((Boolean)effect.getRainbow().get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Integer)effect.getRedValue().get()).intValue(), ((Integer)effect.getGreenValue().get()).intValue(), ((Integer)effect.getBlueValue().get()).intValue(), ((Integer)effect.getalphaValue().get()).intValue());
/* 49 */     GlStateManager.func_179132_a(false);
/* 50 */     GlStateManager.func_179143_c(514);
/* 51 */     GlStateManager.func_179140_f();
/* 52 */     GlStateManager.func_179112_b(768, 1);
/* 53 */     this.field_175057_n.func_110577_a(field_110798_h);
/* 54 */     GlStateManager.func_179128_n(5890);
/* 55 */     GlStateManager.func_179094_E();
/* 56 */     GlStateManager.func_179152_a(8.0F, 8.0F, 8.0F);
/* 57 */     float f = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F / 8.0F;
/* 58 */     GlStateManager.func_179109_b(f, 0.0F, 0.0F);
/* 59 */     GlStateManager.func_179114_b(-50.0F, 0.0F, 0.0F, 1.0F);
/* 60 */     if (effect.getState()) {
/* 61 */       func_191965_a(p_renderEffect_1_, color.getRGB());
/*    */     } else {
/* 63 */       func_191965_a(p_renderEffect_1_, -8372020);
/* 64 */     }  GlStateManager.func_179121_F();
/* 65 */     GlStateManager.func_179094_E();
/* 66 */     GlStateManager.func_179152_a(8.0F, 8.0F, 8.0F);
/* 67 */     float f1 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F / 8.0F;
/* 68 */     GlStateManager.func_179109_b(-f1, 0.0F, 0.0F);
/* 69 */     GlStateManager.func_179114_b(10.0F, 0.0F, 0.0F, 1.0F);
/* 70 */     if (effect.getState()) {
/* 71 */       func_191965_a(p_renderEffect_1_, color.getRGB());
/*    */     } else {
/* 73 */       func_191965_a(p_renderEffect_1_, -8372020);
/* 74 */     }  GlStateManager.func_179121_F();
/* 75 */     GlStateManager.func_179128_n(5888);
/* 76 */     GlStateManager.func_179112_b(770, 771);
/* 77 */     GlStateManager.func_179145_e();
/* 78 */     GlStateManager.func_179143_c(515);
/* 79 */     GlStateManager.func_179132_a(true);
/* 80 */     this.field_175057_n.func_110577_a(TextureMap.field_110575_b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\item\MixinRenderItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */