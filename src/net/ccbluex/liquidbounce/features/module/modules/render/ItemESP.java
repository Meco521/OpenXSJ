/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.shader.shaders.OutlineShader;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "ItemESP", description = "Allows you to see items through walls.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\007J\022\020\013\032\0020\b2\b\020\t\032\004\030\0010\fH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ItemESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "onRender2D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class ItemESP extends Module {
/* 21 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Box", "ShaderOutline" }, "Box");
/* 22 */   private final BoolValue colorRainbow = new BoolValue("Rainbow", true);
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender3D(@Nullable Render3DEvent event) {
/* 26 */     if (StringsKt.equals((String)this.modeValue.get(), "Box", true)) {
/* 27 */       Color color = ((Boolean)this.colorRainbow.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/*    */       
/* 29 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 30 */         if (!MinecraftInstance.classProvider.isEntityItem(entity) && !MinecraftInstance.classProvider.isEntityArrow(entity)) {
/*    */           continue;
/*    */         }
/* 33 */         RenderUtils.drawEntityBox(entity, color, true);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender2D(@NotNull Render2DEvent event) {
/* 40 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.modeValue.get(), "ShaderOutline", true)) {
/* 41 */       OutlineShader.OUTLINE_SHADER.startDraw(event.getPartialTicks());
/*    */       try {
/* 43 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 44 */           if (!MinecraftInstance.classProvider.isEntityItem(entity) && !MinecraftInstance.classProvider.isEntityArrow(entity)) {
/*    */             continue;
/*    */           }
/* 47 */           MinecraftInstance.mc.getRenderManager().renderEntityStatic(entity, event.getPartialTicks(), true);
/*    */         } 
/* 49 */       } catch (Exception ex) {
/* 50 */         ClientUtils.getLogger().error("An error occurred while rendering all item entities for shader esp", ex);
/*    */       } 
/*    */       
/* 53 */       OutlineShader.OUTLINE_SHADER.stopDraw(((Boolean)this.colorRainbow.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), 1.0F, 1.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ItemESP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */