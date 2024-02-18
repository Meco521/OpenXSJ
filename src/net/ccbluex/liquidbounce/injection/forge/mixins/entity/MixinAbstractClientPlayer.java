/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.entity;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.cape.CapeInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.misc.NameProtect;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.Cape;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.NoFOV;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.resources.DefaultPlayerSkin;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({AbstractClientPlayer.class})
/*    */ public abstract class MixinAbstractClientPlayer
/*    */   extends MixinEntityPlayer
/*    */ {
/*    */   private CapeInfo capeInfo;
/*    */   
/*    */   @Inject(method = {"getLocationCape"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void getCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
/* 35 */     Cape capeMod = (Cape)Retreat.moduleManager.getModule(Cape.class);
/* 36 */     if (capeMod.getState() && Objects.equals(func_146103_bH().getName(), (Minecraft.func_71410_x()).field_71439_g.func_146103_bH().getName())) {
/* 37 */       callbackInfoReturnable.setReturnValue(capeMod.getCapeLocation((String)capeMod.getStyleValue().get()));
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"getFovModifier"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void getFovModifier(CallbackInfoReturnable<Float> callbackInfoReturnable) {
/* 43 */     NoFOV fovModule = (NoFOV)Retreat.moduleManager.getModule(NoFOV.class);
/*    */     
/* 45 */     if (((NoFOV)Objects.<NoFOV>requireNonNull(fovModule)).getState()) {
/* 46 */       float newFOV = ((Float)fovModule.getFovValue().get()).floatValue();
/*    */       
/* 48 */       if (!func_184587_cr()) {
/* 49 */         callbackInfoReturnable.setReturnValue(Float.valueOf(newFOV));
/*    */         
/*    */         return;
/*    */       } 
/* 53 */       if (func_184607_cu().func_77973_b() != Items.field_151031_f) {
/* 54 */         callbackInfoReturnable.setReturnValue(Float.valueOf(newFOV));
/*    */         
/*    */         return;
/*    */       } 
/* 58 */       int i = func_184605_cv();
/* 59 */       float f1 = i / 20.0F;
/* 60 */       f1 = (f1 > 1.0F) ? 1.0F : (f1 * f1);
/* 61 */       newFOV *= 1.0F - f1 * 0.15F;
/* 62 */       callbackInfoReturnable.setReturnValue(Float.valueOf(newFOV));
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"getLocationSkin()Lnet/minecraft/util/ResourceLocation;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void getSkin(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
/* 68 */     NameProtect nameProtect = (NameProtect)Retreat.moduleManager.getModule(NameProtect.class);
/*    */     
/* 70 */     if (((NameProtect)Objects.<NameProtect>requireNonNull(nameProtect)).getState() && ((Boolean)nameProtect.skinProtectValue.get()).booleanValue()) {
/* 71 */       if (!((Boolean)nameProtect.allPlayersValue.get()).booleanValue() && !Objects.equals(func_146103_bH().getName(), (Minecraft.func_71410_x()).field_71439_g.func_146103_bH().getName())) {
/*    */         return;
/*    */       }
/* 74 */       callbackInfoReturnable.setReturnValue(DefaultPlayerSkin.func_177334_a(func_110124_au()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\entity\MixinAbstractClientPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */