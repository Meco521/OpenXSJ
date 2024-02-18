/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.ChestStealer;
/*    */ import net.ccbluex.liquidbounce.injection.implementations.IMixinGuiContainer;
/*    */ import net.ccbluex.liquidbounce.utils.render.EaseUtils;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.inventory.ClickType;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiContainer.class})
/*    */ public abstract class MixinGuiContainer
/*    */   extends MixinGuiScreen implements IMixinGuiContainer {
/*    */   private GuiButton stealButton;
/*    */   private GuiButton chestStealerButton;
/* 25 */   private float progress = 0.0F; private GuiButton invManagerButton; private GuiButton killAuraButton;
/* 26 */   private long lastMS = 0L;
/*    */   
/* 28 */   private long guiOpenTime = -1L;
/*    */   
/*    */   @Shadow
/*    */   protected abstract void func_184098_a(Slot paramSlot, int paramInt1, int paramInt2, ClickType paramClickType);
/*    */   
/*    */   @Inject(method = {"initGui"}, at = {@At("HEAD")}, cancellable = true)
/*    */   public void injectInitGui(CallbackInfo callbackInfo) {
/* 35 */     int firstY = 0;
/* 36 */     this.field_146292_n.add(this.killAuraButton = new GuiButton(1024576, 5, 5, 140, 20, "Disable KillAura"));
/* 37 */     firstY += 30;
/*    */     
/* 39 */     this.field_146292_n.add(this.invManagerButton = new GuiButton(321123, 5, 5 + firstY, 140, 20, "Disable InvCleaner"));
/* 40 */     firstY += 30;
/*    */     
/* 42 */     this.field_146292_n.add(this.chestStealerButton = new GuiButton(727, 5, 5 + firstY, 140, 20, "Disable ChestStealer"));
/* 43 */     firstY += 30;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"drawScreen"}, at = {@At("HEAD")})
/*    */   protected void drawScreenHead(CallbackInfo callbackInfo) {
/* 50 */     if (this.progress >= 1.0F) {
/* 51 */       this.progress = 1.0F;
/*    */     } else {
/* 53 */       this.progress = (float)(System.currentTimeMillis() - this.lastMS) / 300.0F;
/*    */     } 
/*    */     
/* 56 */     double trueAnim = EaseUtils.easeOutQuart(this.progress);
/* 57 */     double pct = Math.max(500L - System.currentTimeMillis() - this.guiOpenTime, 0L) / 500.0D;
/* 58 */     double scale = 1.0D - pct;
/*    */     
/* 60 */     ChestStealer cs = (ChestStealer)Retreat.moduleManager.getModule(ChestStealer.class);
/* 61 */     GL11.glTranslated((1.0D - trueAnim) * this.field_146294_l / 2.0D, (1.0D - trueAnim) * this.field_146295_m / 2.0D, 0.0D);
/* 62 */     GL11.glScaled(trueAnim, trueAnim, trueAnim);
/* 63 */     GL11.glPushMatrix();
/*    */   }
/*    */   
/*    */   @Inject(method = {"drawScreen"}, at = {@At("RETURN")}, cancellable = true)
/*    */   protected void drawScreenReturn(CallbackInfo callbackInfo) {
/* 68 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   @Inject(method = {"mouseClicked"}, at = {@At("RETURN")})
/*    */   private void mouseClicked(int mouseX, int mouseY, int mouseButton, CallbackInfo callbackInfo) {
/* 73 */     for (GuiButton aButtonList : this.field_146292_n) {
/* 74 */       GuiButton var52 = aButtonList;
/* 75 */       if (var52.func_146116_c(this.field_146297_k, mouseX, mouseY) && var52.field_146127_k == 1024576) {
/* 76 */         Retreat.moduleManager.getModule(KillAura.class).setState(false);
/*    */       }
/* 78 */       if (var52.func_146116_c(this.field_146297_k, mouseX, mouseY) && var52.field_146127_k == 321123) {
/* 79 */         Retreat.moduleManager.getModule(InventoryCleaner.class).setState(false);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void publicHandleMouseClick(Slot slot, int slotNumber, int clickedButton, ClickType clickType) {
/* 87 */     func_184098_a(slot, slotNumber, clickedButton, clickType);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */