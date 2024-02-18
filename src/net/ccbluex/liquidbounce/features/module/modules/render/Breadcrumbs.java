/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import java.util.LinkedList;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ModuleInfo(name = "Breadcrumbs", description = "Leaves a trail behind you.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\020\023\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\013H\026J\022\020\r\032\0020\0132\b\020\016\032\004\030\0010\017H\007J\022\020\020\032\0020\0132\b\020\016\032\004\030\0010\021H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Breadcrumbs;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getColorRainbow", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "positions", "Ljava/util/LinkedList;", "", "onDisable", "", "onEnable", "onRender3D", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Breadcrumbs extends Module {
/*    */   @NotNull
/* 20 */   private final BoolValue colorRainbow = new BoolValue("Rainbow", false); @NotNull public final BoolValue getColorRainbow() { return this.colorRainbow; }
/* 21 */    private final LinkedList<double[]> positions = (LinkedList)new LinkedList<>();
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender3D(@Nullable Render3DEvent event) {
/* 25 */     Color color = ((Boolean)this.colorRainbow.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/*    */     
/* 27 */     LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Breadcrumbs$onRender3D$1 = 0;
/* 28 */       GL11.glPushMatrix();
/* 29 */       GL11.glDisable(3553);
/* 30 */       GL11.glBlendFunc(770, 771);
/* 31 */       GL11.glEnable(2848);
/* 32 */       GL11.glEnable(3042);
/* 33 */       GL11.glDisable(2929);
/*    */       
/* 35 */       MinecraftInstance.mc.getEntityRenderer().disableLightmap();
/*    */       
/* 37 */       GL11.glBegin(3);
/* 38 */       RenderUtils.glColor(color);
/*    */       
/* 40 */       double renderPosX = MinecraftInstance.mc.getRenderManager().getViewerPosX();
/* 41 */       double renderPosY = MinecraftInstance.mc.getRenderManager().getViewerPosY();
/* 42 */       double renderPosZ = MinecraftInstance.mc.getRenderManager().getViewerPosZ();
/*    */       
/* 44 */       for (double[] pos : this.positions) {
/* 45 */         GL11.glVertex3d(pos[0] - renderPosX, pos[1] - renderPosY, pos[2] - renderPosZ);
/*    */       }
/* 47 */       GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
/* 48 */       GL11.glEnd();
/* 49 */       GL11.glEnable(2929);
/* 50 */       GL11.glDisable(2848);
/* 51 */       GL11.glDisable(3042);
/* 52 */       GL11.glEnable(3553);
/* 53 */       GL11.glPopMatrix();
/* 54 */       Unit unit = Unit.INSTANCE;
/*    */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/*    */   
/*    */   } @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 59 */     LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Breadcrumbs$onUpdate$1 = 0;
/* 60 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  (new double[3])[0] = MinecraftInstance.mc.getThePlayer().getPosX(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  (new double[3])[1] = MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().getMinY(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  null = this.positions.add(new double[] { 0, 0, MinecraftInstance.mc.getThePlayer().getPosZ() });
/*    */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/*    */   
/*    */   }
/*    */   
/* 65 */   public void onEnable() { if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */       
/* 67 */       LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Breadcrumbs$onEnable$1 = 0;
/* 68 */         this.positions.add(new double[] { thePlayer.getPosX(), 
/* 69 */               thePlayer.getEntityBoundingBox().getMinY() + (thePlayer.getEyeHeight() * 0.5F), 
/* 70 */               thePlayer.getPosZ() });
/*    */         
/* 72 */         null = this.positions.add(new double[] { thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY(), thePlayer.getPosZ() }); /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/*    */       
/* 74 */       super.onEnable();
/*    */       return; }
/*    */     
/*    */     MinecraftInstance.mc.getThePlayer(); } public void onDisable() {
/* 78 */     LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Breadcrumbs$onDisable$1 = 0; this.positions.clear(); Unit unit = Unit.INSTANCE; /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/* 79 */      super.onDisable();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Breadcrumbs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */