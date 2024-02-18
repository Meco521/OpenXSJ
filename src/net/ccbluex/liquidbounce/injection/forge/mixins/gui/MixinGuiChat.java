/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiChat;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.lwjgl.input.Mouse;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({GuiChat.class})
/*    */ public abstract class MixinGuiChat
/*    */   extends MixinGuiScreen
/*    */ {
/*    */   @Shadow
/*    */   protected GuiTextField field_146415_a;
/*    */   private float yPosOfInputField;
/* 28 */   private float fade = 0.0F;
/*    */   
/*    */   @Shadow
/*    */   public abstract void func_184072_a(String... paramVarArgs);
/*    */   
/*    */   @Inject(method = {"initGui"}, at = {@At("RETURN")})
/*    */   private void init(CallbackInfo callbackInfo) {
/* 35 */     this.field_146415_a.field_146210_g = this.field_146295_m + 1;
/* 36 */     this.yPosOfInputField = this.field_146415_a.field_146210_g;
/*    */   }
/*    */   
/*    */   @Inject(method = {"keyTyped"}, at = {@At("RETURN")})
/*    */   private void updateLength(CallbackInfo callbackInfo) {
/* 41 */     if (!this.field_146415_a.func_146179_b().startsWith(String.valueOf(Retreat.commandManager.getPrefix())))
/* 42 */       return;  Retreat.commandManager.autoComplete(this.field_146415_a.func_146179_b());
/*    */     
/* 44 */     if (!this.field_146415_a.func_146179_b().startsWith(Retreat.commandManager.getPrefix() + "lc")) {
/* 45 */       this.field_146415_a.func_146203_f(10000);
/*    */     } else {
/* 47 */       this.field_146415_a.func_146203_f(100);
/*    */     } 
/*    */   }
/*    */   @Inject(method = {"updateScreen"}, at = {@At("HEAD")})
/*    */   private void updateScreen(CallbackInfo callbackInfo) {
/* 52 */     int delta = RenderUtils.deltaTime;
/*    */     
/* 54 */     if (this.fade < 14.0F) this.fade += 0.4F * delta; 
/* 55 */     if (this.fade > 14.0F) this.fade = 14.0F;
/*    */     
/* 57 */     if (this.yPosOfInputField > (this.field_146295_m - 12)) this.yPosOfInputField -= 0.4F * delta; 
/* 58 */     if (this.yPosOfInputField < (this.field_146295_m - 12)) this.yPosOfInputField = (this.field_146295_m - 12);
/*    */     
/* 60 */     this.field_146415_a.field_146210_g = (int)this.yPosOfInputField;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 71 */     Gui.func_73734_a(2, this.field_146295_m - (int)this.fade, this.field_146294_l - 2, this.field_146295_m, -2147483648);
/* 72 */     this.field_146415_a.func_146194_f();
/*    */     
/* 74 */     if ((Retreat.commandManager.getLatestAutoComplete()).length > 0 && !this.field_146415_a.func_146179_b().isEmpty() && this.field_146415_a.func_146179_b().startsWith(String.valueOf(Retreat.commandManager.getPrefix()))) {
/* 75 */       String[] latestAutoComplete = Retreat.commandManager.getLatestAutoComplete();
/* 76 */       String[] textArray = this.field_146415_a.func_146179_b().split(" ");
/* 77 */       String trimmedString = latestAutoComplete[0].replaceFirst("(?i)" + textArray[textArray.length - 1], "");
/*    */       
/* 79 */       this.field_146297_k.field_71466_p.func_175063_a(trimmedString, (this.field_146415_a.field_146209_f + this.field_146297_k.field_71466_p.func_78256_a(this.field_146415_a.func_146179_b())), this.field_146415_a.field_146210_g, (new Color(165, 165, 165)).getRGB());
/*    */     } 
/*    */ 
/*    */     
/* 83 */     ITextComponent ichatcomponent = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
/*    */     
/* 85 */     if (ichatcomponent != null)
/* 86 */       func_175272_a(ichatcomponent, mouseX, mouseY); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiChat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */