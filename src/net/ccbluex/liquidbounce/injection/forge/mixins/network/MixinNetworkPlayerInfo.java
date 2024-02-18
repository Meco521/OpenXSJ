/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.network;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.misc.NameProtect;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.network.NetworkPlayerInfo;
/*    */ import net.minecraft.client.resources.DefaultPlayerSkin;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({NetworkPlayerInfo.class})
/*    */ public class MixinNetworkPlayerInfo
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private GameProfile field_178867_a;
/*    */   
/*    */   @Inject(method = {"getLocationSkin"}, cancellable = true, at = {@At("HEAD")})
/*    */   private void injectSkinProtect(CallbackInfoReturnable<ResourceLocation> cir) {
/* 27 */     NameProtect nameProtect = (NameProtect)Retreat.moduleManager.getModule(NameProtect.class);
/*    */     
/* 29 */     if (nameProtect.getState() && ((Boolean)nameProtect.skinProtectValue.get()).booleanValue() && ((
/* 30 */       (Boolean)nameProtect.allPlayersValue.get()).booleanValue() || Objects.equals(this.field_178867_a.getId(), Minecraft.func_71410_x().func_110432_I().func_148256_e().getId()))) {
/* 31 */       cir.setReturnValue(DefaultPlayerSkin.func_177334_a(this.field_178867_a.getId()));
/* 32 */       cir.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\network\MixinNetworkPlayerInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */