/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import tomk.utils.Translate;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\b\n\002\b\004\030\0002\0020\001B\005¢\006\002\020\002J&\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0042\006\020\022\032\0020\0042\006\020\023\032\0020\004R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\013\020\f¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/hotbarutil;", "", "()V", "size", "", "getSize", "()F", "setSize", "(F)V", "translate", "Ltomk/utils/Translate;", "getTranslate", "()Ltomk/utils/Translate;", "renderHotbarItem", "", "index", "", "xPos", "yPos", "partialTicks", "XSJClient"})
/*    */ public final class hotbarutil {
/*    */   @NotNull
/* 13 */   private final Translate translate = new Translate(0.0F, 0.0F); @NotNull public final Translate getTranslate() { return this.translate; }
/* 14 */    private float size = 1.0F; public final float getSize() { return this.size; } public final void setSize(float <set-?>) { this.size = <set-?>; }
/*    */ 
/*    */   
/*    */   public final void renderHotbarItem(int index, float xPos, float yPos, float partialTicks) {
/* 18 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IItemStack itemStack = (IItemStack)MinecraftInstance.mc.getThePlayer().getInventory().getMainInventory().get(index);
/* 19 */     if (itemStack != null) {
/* 20 */       float lvt_7_1_ = itemStack.getAnimationsToGo() - partialTicks;
/* 21 */       if (lvt_7_1_ > 0.0F) {
/* 22 */         GlStateManager.func_179094_E();
/* 23 */         float lvt_8_1_ = 1.0F + lvt_7_1_ / 5.0F;
/* 24 */         GlStateManager.func_179109_b(xPos + 8, yPos + 12, 0.0F);
/* 25 */         GlStateManager.func_179152_a(1.0F / lvt_8_1_, (lvt_8_1_ + 1.0F) / 2.0F, 1.0F);
/* 26 */         GlStateManager.func_179109_b(-(xPos + 8), -(yPos + 12), 0.0F);
/*    */       } 
/* 28 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); RenderUtils.drawTexturedRect(xPos - 7, yPos - 7, 30.0F, 30.0F, "hotbar", MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc));
/* 29 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); RenderUtils.drawTexturedRect(xPos - 7, yPos - 7, 30.0F, 30.0F, "hotbar", MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc));
/* 30 */       MinecraftInstance.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, (int)xPos, (int)yPos);
/* 31 */       if (lvt_7_1_ > 0.0F) {
/* 32 */         GlStateManager.func_179121_F();
/*    */       }
/* 34 */       Intrinsics.checkExpressionValueIsNotNull(Fonts.font35, "Fonts.font35"); MinecraftInstance.mc.getRenderItem().renderItemOverlays(Fonts.font35, itemStack, (int)xPos, (int)yPos);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\hotbarutil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */