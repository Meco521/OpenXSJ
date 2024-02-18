/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ModuleInfo(name = "Crosshair", description = "skidfdp", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\024\032\0020\0252\006\020\026\032\0020\027H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\t\032\0020\n8BX\004¢\006\006\032\004\b\013\020\fR\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\016X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Crosshair;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "brightnessValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "colorAlphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "crosshairColor", "Ljava/awt/Color;", "getCrosshairColor", "()Ljava/awt/Color;", "dynamicValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "gapValue", "hitMarkerValue", "saturationValue", "sizeValue", "widthValue", "onRender2D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "XSJClient"})
/*    */ public final class Crosshair
/*    */   extends Module {
/* 30 */   private final ListValue colorModeValue = new ListValue("Color", new String[] { "Custom", "Slowly", "Rainbow" }, "Custom");
/* 31 */   private final IntegerValue colorAlphaValue = new IntegerValue("Alpha", 255, 0, 255);
/*    */ 
/*    */   
/* 34 */   private final FloatValue saturationValue = new FloatValue("Saturation", 1.0F, 0.0F, 1.0F);
/* 35 */   private final FloatValue brightnessValue = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/*    */ 
/*    */   
/* 38 */   private final FloatValue widthValue = new FloatValue("Width", 0.5F, 0.25F, 10.0F);
/* 39 */   private final FloatValue sizeValue = new FloatValue("Length", 7.0F, 0.25F, 15.0F);
/* 40 */   private final FloatValue gapValue = new FloatValue("Gap", 5.0F, 0.25F, 15.0F);
/* 41 */   private final BoolValue dynamicValue = new BoolValue("Dynamic", true);
/* 42 */   private final BoolValue hitMarkerValue = new BoolValue("HitMarker", true);
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender2D(@NotNull Render2DEvent event) {
/* 46 */     Intrinsics.checkParameterIsNotNull(event, "event"); ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/* 47 */     float width = ((Number)this.widthValue.get()).floatValue();
/* 48 */     float size = ((Number)this.sizeValue.get()).floatValue();
/* 49 */     float gap = ((Number)this.gapValue.get()).floatValue();
/* 50 */     boolean isMoving = (((Boolean)this.dynamicValue.get()).booleanValue() && MovementUtils.isMoving());
/* 51 */     GL11.glPushMatrix();
/* 52 */     RenderUtils.drawBorderedRect(sr.func_78326_a() / 2.0F - width, sr.func_78328_b() / 2.0F - gap - size - (isMoving ? 2 : false), sr.func_78326_a() / 2.0F + 1.0F + width, sr.func_78328_b() / 2.0F - gap - (isMoving ? 2 : false), 0.5F, (new Color(0, 0, 0)).getRGB(), getCrosshairColor().getRGB());
/* 53 */     RenderUtils.drawBorderedRect(sr.func_78326_a() / 2.0F - width, sr.func_78328_b() / 2.0F + gap + true + (isMoving ? 2 : false) - 0.15F, sr.func_78326_a() / 2.0F + 1.0F + width, sr.func_78328_b() / 2.0F + true + gap + size + (isMoving ? 2 : false) - 0.15F, 0.5F, (new Color(0, 0, 0)).getRGB(), getCrosshairColor().getRGB());
/* 54 */     RenderUtils.drawBorderedRect(sr.func_78326_a() / 2.0F - gap - size - (isMoving ? 2 : false) + 0.15F, sr.func_78328_b() / 2.0F - width, sr.func_78326_a() / 2.0F - gap - (isMoving ? 2 : false) + 0.15F, (sr.func_78328_b() / 2) + 1.0F + width, 0.5F, (new Color(0, 0, 0)).getRGB(), getCrosshairColor().getRGB());
/* 55 */     RenderUtils.drawBorderedRect(sr.func_78326_a() / 2.0F + true + gap + (isMoving ? 2 : false), sr.func_78328_b() / 2.0F - width, sr.func_78326_a() / 2.0F + size + gap + 1.0F + (isMoving ? 2 : false), (sr.func_78328_b() / 2) + 1.0F + width, 0.5F, (new Color(0, 0, 0)).getRGB(), getCrosshairColor().getRGB());
/* 56 */     GL11.glPopMatrix();
/* 57 */     GlStateManager.func_179117_G();
/* 58 */     IEntityLivingBase target = Retreat.INSTANCE.getCombatManager().getTarget();
/*    */ 
/*    */     
/* 61 */     if (((Boolean)this.hitMarkerValue.get()).booleanValue() && target != null && target.getHurtTime() > 0) {
/* 62 */       GL11.glPushMatrix();
/* 63 */       GlStateManager.func_179147_l();
/* 64 */       GlStateManager.func_179090_x();
/* 65 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 66 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, target.getHurtTime() / target.getMaxHurtTime());
/* 67 */       GL11.glEnable(2848);
/* 68 */       GL11.glLineWidth(1.0F);
/* 69 */       GL11.glBegin(3);
/* 70 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F + gap, sr.func_78328_b() / 2.0F + gap);
/* 71 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F + gap + size, sr.func_78328_b() / 2.0F + gap + size);
/* 72 */       GL11.glEnd();
/* 73 */       GL11.glBegin(3);
/* 74 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F - gap, sr.func_78328_b() / 2.0F - gap);
/* 75 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F - gap - size, sr.func_78328_b() / 2.0F - gap - size);
/* 76 */       GL11.glEnd();
/* 77 */       GL11.glBegin(3);
/* 78 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F - gap, sr.func_78328_b() / 2.0F + gap);
/* 79 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F - gap - size, sr.func_78328_b() / 2.0F + gap + size);
/* 80 */       GL11.glEnd();
/* 81 */       GL11.glBegin(3);
/* 82 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F + gap, sr.func_78328_b() / 2.0F - gap);
/* 83 */       GL11.glVertex2f(sr.func_78326_a() / 2.0F + gap + size, sr.func_78328_b() / 2.0F - gap - size);
/* 84 */       GL11.glEnd();
/* 85 */       GlStateManager.func_179098_w();
/* 86 */       GlStateManager.func_179084_k();
/* 87 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private final Color getCrosshairColor() {
/* 93 */     String str = (String)this.colorModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*    */     
/*    */     { case 973576630:
/* 96 */         if (str.equals("rainbow")); break;case -1349088399: if (str.equals("custom")); break;
/* 97 */       case -899450034: if (str.equals("slowly")); break; }  Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); return Color.WHITE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Crosshair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */