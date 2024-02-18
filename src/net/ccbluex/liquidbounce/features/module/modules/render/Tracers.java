/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ModuleInfo(name = "Tracers", description = "Draws a line to targets around you.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\fH\002J\020\020\r\032\0020\b2\006\020\016\032\0020\017H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Tracers;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "thicknessValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "drawTraces", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "color", "Ljava/awt/Color;", "onRender3D", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class Tracers extends Module {
/* 22 */   private final ListValue colorMode = new ListValue("Color", new String[] { "Custom", "DistanceColor", "Rainbow" }, "Custom");
/*    */   
/* 24 */   private final FloatValue thicknessValue = new FloatValue("Thickness", 2.0F, 1.0F, 5.0F);
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender3D(@NotNull Render3DEvent event) {
/* 29 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 31 */       GL11.glBlendFunc(770, 771);
/* 32 */       GL11.glEnable(3042);
/* 33 */       GL11.glEnable(2848);
/* 34 */       GL11.glLineWidth(((Number)this.thicknessValue.get()).floatValue());
/* 35 */       GL11.glDisable(3553);
/* 36 */       GL11.glDisable(2929);
/* 37 */       GL11.glDepthMask(false);
/*    */       
/* 39 */       GL11.glBegin(1);
/*    */       
/* 41 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 42 */         if ((Intrinsics.areEqual(entity, thePlayer) ^ true) != 0 && EntityUtils.isSelected(entity, false)) {
/* 43 */           int dist = (int)(thePlayer.getDistanceToEntity(entity) * 2);
/*    */           
/* 45 */           if (dist > 255) dist = 255;
/*    */           
/* 47 */           String str1 = (String)this.colorMode.get(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String colorMode = str1.toLowerCase();
/* 48 */           Color color = 
/* 49 */             EntityUtils.isFriend(entity) ? new Color(0, 0, 255, 150) : (
/* 50 */             colorMode.equals("custom") ? new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 150) : (
/* 51 */             colorMode.equals("distancecolor") ? new Color(255 - dist, dist, 0, 150) : (
/* 52 */             colorMode.equals("rainbow") ? ColorUtils.rainbow() : 
/* 53 */             new Color(255, 255, 255, 150))));
/*    */ 
/*    */           
/* 56 */           drawTraces(entity, color);
/*    */         } 
/*    */       } 
/*    */       
/* 60 */       GL11.glEnd();
/*    */       
/* 62 */       GL11.glEnable(3553);
/* 63 */       GL11.glDisable(2848);
/* 64 */       GL11.glEnable(2929);
/* 65 */       GL11.glDepthMask(true);
/* 66 */       GL11.glDisable(3042);
/* 67 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } private final void drawTraces(IEntity entity, Color color) {
/* 71 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 73 */       double x = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 74 */         MinecraftInstance.mc.getRenderManager().getRenderPosX();
/* 75 */       double y = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 76 */         MinecraftInstance.mc.getRenderManager().getRenderPosY();
/* 77 */       double z = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 78 */         MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*    */       
/* 80 */       WVec3 eyeVector = (new WVec3(0.0D, 0.0D, 1.0D))
/* 81 */         .rotatePitch((float)-Math.toRadians(thePlayer.getRotationPitch()))
/* 82 */         .rotateYaw((float)-Math.toRadians(thePlayer.getRotationYaw()));
/*    */       
/* 84 */       RenderUtils.glColor(color);
/*    */       
/* 86 */       GL11.glVertex3d(eyeVector.getXCoord(), thePlayer.getEyeHeight() + eyeVector.getYCoord(), eyeVector.getZCoord());
/* 87 */       GL11.glVertex3d(x, y, z);
/* 88 */       GL11.glVertex3d(x, y, z);
/* 89 */       GL11.glVertex3d(x, y + entity.getHeight(), z);
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Tracers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */