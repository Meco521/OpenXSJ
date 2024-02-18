/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.resources;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.authlib.minecraft.MinecraftProfileTexture;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.misc.NameProtect;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.SkinManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({SkinManager.class})
/*    */ public class MixinSkinManager
/*    */ {
/*    */   @Inject(method = {"loadSkinFromCache"}, cancellable = true, at = {@At("HEAD")})
/*    */   private void injectSkinProtect(GameProfile gameProfile, CallbackInfoReturnable<Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>> cir) {
/* 23 */     if (gameProfile == null) {
/*    */       return;
/*    */     }
/* 26 */     NameProtect nameProtect = (NameProtect)Retreat.moduleManager.getModule(NameProtect.class);
/*    */     
/* 28 */     if (nameProtect.getState() && ((Boolean)nameProtect.skinProtectValue.get()).booleanValue() && ((
/* 29 */       (Boolean)nameProtect.allPlayersValue.get()).booleanValue() || Objects.equals(gameProfile.getId(), Minecraft.func_71410_x().func_110432_I().func_148256_e().getId()))) {
/* 30 */       cir.setReturnValue(new HashMap<>());
/* 31 */       cir.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\resources\MixinSkinManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */