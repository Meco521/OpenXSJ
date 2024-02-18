/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.Chams;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.NameTags;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.TrueSight;
/*    */ import net.ccbluex.liquidbounce.injection.backend.EntityLivingBaseImplKt;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderLivingBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({RenderLivingBase.class})
/*    */ public abstract class MixinRendererLivingEntity
/*    */   extends MixinRender
/*    */ {
/*    */   @Shadow
/*    */   protected ModelBase field_77045_g;
/*    */   
/*    */   @Inject(method = {"doRender"}, at = {@At("HEAD")})
/*    */   private <T extends EntityLivingBase> void injectChamsPre(T entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo callbackInfo) {
/* 39 */     Chams chams = (Chams)Retreat.moduleManager.getModule(Chams.class);
/*    */     
/* 41 */     if (chams.getState() && ((Boolean)chams.getTargetsValue().get()).booleanValue() && EntityUtils.isSelected((IEntity)EntityLivingBaseImplKt.wrap((EntityLivingBase)entity), false)) {
/* 42 */       GL11.glEnable(32823);
/* 43 */       GL11.glPolygonOffset(1.0F, -1000000.0F);
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"doRender"}, at = {@At("RETURN")})
/*    */   private <T extends EntityLivingBase> void injectChamsPost(T entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo callbackInfo) {
/* 49 */     Chams chams = (Chams)Retreat.moduleManager.getModule(Chams.class);
/*    */     
/* 51 */     if (chams.getState() && ((Boolean)chams.getTargetsValue().get()).booleanValue() && EntityUtils.isSelected((IEntity)EntityLivingBaseImplKt.wrap((EntityLivingBase)entity), false)) {
/* 52 */       GL11.glPolygonOffset(1.0F, 1000000.0F);
/* 53 */       GL11.glDisable(32823);
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"canRenderName"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private <T extends EntityLivingBase> void canRenderName(T entity, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
/* 59 */     if (Retreat.moduleManager.getModule(NameTags.class).getState() && EntityUtils.isSelected((IEntity)EntityLivingBaseImplKt.wrap((EntityLivingBase)entity), false)) {
/* 60 */       callbackInfoReturnable.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   protected <T extends EntityLivingBase> void func_77036_a(T entitylivingbaseIn, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float scaleFactor) {
/* 68 */     boolean visible = !entitylivingbaseIn.func_82150_aj();
/* 69 */     TrueSight trueSight = (TrueSight)Retreat.moduleManager.getModule(TrueSight.class);
/* 70 */     boolean semiVisible = (!visible && (!entitylivingbaseIn.func_98034_c((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g) || (trueSight.getState() && ((Boolean)trueSight.getEntitiesValue().get()).booleanValue())));
/*    */     
/* 72 */     if (visible || semiVisible) {
/* 73 */       if (!func_180548_c((Entity)entitylivingbaseIn)) {
/*    */         return;
/*    */       }
/* 76 */       if (semiVisible) {
/* 77 */         GlStateManager.func_179094_E();
/* 78 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.15F);
/* 79 */         GlStateManager.func_179132_a(false);
/* 80 */         GL11.glEnable(3042);
/* 81 */         GlStateManager.func_179112_b(770, 771);
/* 82 */         GlStateManager.func_179092_a(516, 0.003921569F);
/*    */       } 
/*    */ 
/*    */       
/* 86 */       this.field_77045_g.func_78088_a((Entity)entitylivingbaseIn, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, scaleFactor);
/*    */       
/* 88 */       if (semiVisible) {
/* 89 */         GlStateManager.func_179084_k();
/* 90 */         GlStateManager.func_179092_a(516, 0.1F);
/* 91 */         GlStateManager.func_179121_F();
/* 92 */         GlStateManager.func_179132_a(true);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinRendererLivingEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */