/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.Rotations;
/*    */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({ModelBiped.class})
/*    */ public class MixinModelBiped
/*    */ {
/*    */   @Shadow
/*    */   public ModelRenderer field_178723_h;
/*    */   @Shadow
/*    */   public ModelRenderer field_78116_c;
/*    */   @Shadow
/*    */   public ModelBiped.ArmPose field_187076_m;
/*    */   
/*    */   @Inject(method = {"setRotationAngles"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/client/model/ModelBiped;swingProgress:F")})
/*    */   private void revertSwordAnimation(float p_setRotationAngles_1_, float p_setRotationAngles_2_, float p_setRotationAngles_3_, float p_setRotationAngles_4_, float p_setRotationAngles_5_, float p_setRotationAngles_6_, Entity p_setRotationAngles_7_, CallbackInfo callbackInfo) {
/* 34 */     if (this.field_187076_m == ModelBiped.ArmPose.BOW_AND_ARROW) {
/* 35 */       this.field_178723_h.field_78796_g = 0.0F;
/*    */     }
/* 37 */     if (Retreat.moduleManager.getModule(Rotations.class).getState() && RotationUtils.serverRotation != null && p_setRotationAngles_7_ instanceof net.minecraft.entity.player.EntityPlayer && p_setRotationAngles_7_
/* 38 */       .equals((Minecraft.func_71410_x()).field_71439_g))
/* 39 */       this.field_78116_c.field_78795_f = RotationUtils.serverRotation.getPitch() / 57.295776F; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinModelBiped.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */