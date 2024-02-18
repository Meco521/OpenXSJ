/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ModuleInfo(name = "BlockOverlay", description = "Allows you to change the design of the block overlay.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\007J\020\020\020\032\0020\r2\006\020\016\032\0020\021H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\023\020\005\032\004\030\0010\0068F¢\006\006\032\004\b\007\020\bR\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\013¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/BlockOverlay;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "currentBlock", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "getCurrentBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "infoValue", "getInfoValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "onRender2D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class BlockOverlay extends Module {
/* 24 */   private final BoolValue colorRainbow = new BoolValue("Rainbow", false); @NotNull
/* 25 */   private final BoolValue infoValue = new BoolValue("Info", false); @NotNull public final BoolValue getInfoValue() { return this.infoValue; }
/*    */ 
/*    */   
/*    */   @Nullable
/* 29 */   public final WBlockPos getCurrentBlock() { if (MinecraftInstance.mc.getObjectMouseOver() != null && MinecraftInstance.mc.getObjectMouseOver().getBlockPos() != null) { WBlockPos blockPos = MinecraftInstance.mc.getObjectMouseOver().getBlockPos();
/*    */       
/* 31 */       if (BlockUtils.canBeClicked(blockPos)) { if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getTheWorld().getWorldBorder().contains(blockPos))
/* 32 */           return blockPos;  }
/*    */       
/* 34 */       return null; }
/*    */     
/*    */     MinecraftInstance.mc.getObjectMouseOver().getBlockPos();
/*    */     return null; }
/*    */   @EventTarget
/* 39 */   public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (getCurrentBlock() != null) { WBlockPos blockPos = getCurrentBlock();
/*    */       
/* 41 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IBlock block = MinecraftInstance.mc.getTheWorld().getBlockState(blockPos).getBlock();
/* 42 */       float partialTicks = event.getPartialTicks();
/*    */       
/* 44 */       Color color = ((Boolean)this.colorRainbow.get()).booleanValue() ? ColorUtils.rainbow(0.4F) : new Color(((Number)AColorPalette.r.get()).intValue(), (
/* 45 */           (Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), (int)102.0F);
/*    */       
/* 47 */       MinecraftInstance.classProvider.getGlStateManager().enableBlend();
/* 48 */       MinecraftInstance.classProvider.getGlStateManager().tryBlendFuncSeparate(770, 771, 1, 0);
/* 49 */       RenderUtils.glColor(color);
/* 50 */       GL11.glLineWidth(2.0F);
/* 51 */       MinecraftInstance.classProvider.getGlStateManager().disableTexture2D();
/* 52 */       GL11.glDepthMask(false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 59 */       if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */         
/* 61 */         double x = thePlayer.getLastTickPosX() + (thePlayer.getPosX() - thePlayer.getLastTickPosX()) * partialTicks;
/* 62 */         double y = thePlayer.getLastTickPosY() + (thePlayer.getPosY() - thePlayer.getLastTickPosY()) * partialTicks;
/* 63 */         double z = thePlayer.getLastTickPosZ() + (thePlayer.getPosZ() - thePlayer.getLastTickPosZ()) * partialTicks;
/*    */         
/* 65 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IAxisAlignedBB axisAlignedBB = block.getSelectedBoundingBox((IWorld)MinecraftInstance.mc.getTheWorld(), MinecraftInstance.mc.getTheWorld().getBlockState(blockPos), blockPos)
/* 66 */           .expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D)
/* 67 */           .offset(-x, -y, -z);
/*    */         
/* 69 */         RenderUtils.drawSelectionBoundingBox(axisAlignedBB);
/* 70 */         RenderUtils.drawFilledBox(axisAlignedBB);
/* 71 */         GL11.glDepthMask(true);
/* 72 */         MinecraftInstance.classProvider.getGlStateManager().enableTexture2D();
/* 73 */         MinecraftInstance.classProvider.getGlStateManager().disableBlend();
/* 74 */         MinecraftInstance.classProvider.getGlStateManager().resetColor(); return; }
/*    */       
/*    */       MinecraftInstance.mc.getThePlayer();
/*    */       return; }
/*    */     
/* 79 */     getCurrentBlock(); } @EventTarget public final void onRender2D(@NotNull Render2DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.infoValue.get()).booleanValue()) {
/* 80 */       if (getCurrentBlock() != null) { WBlockPos blockPos = getCurrentBlock();
/* 81 */         if (BlockUtils.getBlock(blockPos) != null) { IBlock block = BlockUtils.getBlock(blockPos);
/*    */           
/* 83 */           String info = block.getLocalizedName() + " §7ID: " + access$getFunctions$p$s1046033730().getIdFromBlock(block);
/* 84 */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IScaledResolution scaledResolution = MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 91 */           Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.drawBorderedRect((scaledResolution.getScaledWidth() / 2) - 2.0F, (scaledResolution.getScaledHeight() / 2) + 5.0F, (scaledResolution.getScaledWidth() / 2 + Fonts.roboto40.getStringWidth(info)) + 2.0F, (scaledResolution.getScaledHeight() / 2) + 16.0F, 3.0F, Color.BLACK.getRGB(), Color.BLACK.getRGB());
/*    */ 
/*    */           
/* 94 */           MinecraftInstance.classProvider.getGlStateManager().resetColor();
/* 95 */           Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.roboto40.drawString(info, scaledResolution.getScaledWidth() / 2.0F, scaledResolution.getScaledHeight() / 2.0F + 7.0F, Color.WHITE.getRGB(), false);
/*    */           return; }
/*    */         
/*    */         BlockUtils.getBlock(blockPos);
/*    */         return; }
/*    */       
/*    */       getCurrentBlock();
/*    */       return;
/*    */     }  }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\BlockOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */