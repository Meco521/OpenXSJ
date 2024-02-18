/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.minecraft.util.TabCompleter;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({TabCompleter.class})
/*    */ public abstract class MixinTabCompleter
/*    */ {
/*    */   @Shadow
/*    */   protected List<String> field_186849_f;
/*    */   @Shadow
/*    */   protected boolean field_186847_d;
/*    */   @Shadow
/*    */   protected boolean field_186846_c;
/*    */   
/*    */   @Inject(method = {"complete"}, at = {@At("HEAD")})
/*    */   private void complete(CallbackInfo ci) {
/* 31 */     this.field_186849_f.sort(
/* 32 */         Comparator.comparing(s -> Boolean.valueOf(!Retreat.fileManager.friendsConfig.isFriend(s))));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"requestCompletions"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void handleClientCommandCompletion(String prefix, CallbackInfo callbackInfo) {
/* 43 */     if (Retreat.commandManager.autoComplete(prefix)) {
/* 44 */       this.field_186847_d = true;
/*    */       
/* 46 */       String[] latestAutoComplete = Retreat.commandManager.getLatestAutoComplete();
/*    */       
/* 48 */       if (prefix.toLowerCase().endsWith(latestAutoComplete[latestAutoComplete.length - 1].toLowerCase())) {
/*    */         return;
/*    */       }
/* 51 */       func_186840_a(latestAutoComplete);
/*    */       
/* 53 */       callbackInfo.cancel();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"setCompletions"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/TabCompleter;complete()V", shift = At.Shift.BEFORE)}, cancellable = true)
/*    */   private void onAutocompleteResponse(String[] autoCompleteResponse, CallbackInfo callbackInfo) {
/* 66 */     if ((Retreat.commandManager.getLatestAutoComplete()).length != 0) callbackInfo.cancel(); 
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   public abstract void func_186840_a(String... paramVarArgs);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinTabCompleter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */