/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.ui.font.AWTFontRenderer;
/*    */ import net.minecraft.client.gui.GuiSpectator;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({GuiSpectator.class})
/*    */ public class MixinGuiSpectator {
/*    */   @Inject(method = {"renderTooltip"}, at = {@At("RETURN")})
/*    */   private void renderTooltipPost(ScaledResolution p_175264_1_, float p_175264_2_, CallbackInfo callbackInfo) {
/* 18 */     Retreat.eventManager.callEvent((Event)new Render2DEvent(p_175264_2_));
/* 19 */     AWTFontRenderer.Companion.garbageCollectionTick();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiSpectator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */