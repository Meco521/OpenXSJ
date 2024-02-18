/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*    */ import net.minecraft.client.renderer.entity.RenderLivingBase;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumHandSide;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({LayerHeldItem.class})
/*    */ public abstract class MixinLayerHeldItem
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   protected RenderLivingBase<?> field_177206_a;
/*    */   
/*    */   @Shadow
/*    */   protected abstract void func_188358_a(EntityLivingBase paramEntityLivingBase, ItemStack paramItemStack, ItemCameraTransforms.TransformType paramTransformType, EnumHandSide paramEnumHandSide);
/*    */   
/*    */   @Overwrite
/*    */   public void func_177141_a(EntityLivingBase entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
/* 35 */     boolean flag = (entitylivingbaseIn.func_184591_cq() == EnumHandSide.RIGHT);
/* 36 */     ItemStack itemstack = flag ? entitylivingbaseIn.func_184592_cb() : entitylivingbaseIn.func_184614_ca();
/* 37 */     ItemStack itemstack1 = flag ? entitylivingbaseIn.func_184614_ca() : entitylivingbaseIn.func_184592_cb();
/*    */     
/* 39 */     if (!itemstack.func_190926_b() || !itemstack1.func_190926_b()) {
/* 40 */       GlStateManager.func_179094_E();
/*    */       
/* 42 */       if ((this.field_177206_a.func_177087_b()).field_78091_s) {
/* 43 */         float f = 0.5F;
/* 44 */         GlStateManager.func_179109_b(0.0F, 0.75F, 0.0F);
/* 45 */         GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/*    */       } 
/*    */       
/* 48 */       func_188358_a(entitylivingbaseIn, itemstack1, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
/* 49 */       func_188358_a(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
/* 50 */       GlStateManager.func_179121_F();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinLayerHeldItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */