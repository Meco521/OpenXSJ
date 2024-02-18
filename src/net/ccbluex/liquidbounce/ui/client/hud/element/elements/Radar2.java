/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.color.CustomColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ESP;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Vector2f;
/*     */ 
/*     */ @ElementInfo(name = "Radar2")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\b\007\030\000 \0212\0020\001:\001\021B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\n\020\017\032\004\030\0010\020H\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\007X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\007X\004¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Radar2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "fovSizeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "playerShapeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "playerSizeValue", "shadowValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "sizeValue", "viewDistanceValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "Companion", "XSJClient"})
/*     */ public final class Radar2 extends Element {
/*     */   private final FloatValue sizeValue;
/*     */   private final FloatValue viewDistanceValue;
/*     */   private final ListValue playerShapeValue;
/*     */   
/*  30 */   public Radar2(double x, double y) { super(x, y, 0.0F, null, 12, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  36 */     this.sizeValue = new FloatValue("Size", 90.0F, 30.0F, 500.0F);
/*  37 */     this.viewDistanceValue = new FloatValue("View Distance", 4.0F, 0.5F, 32.0F);
/*  38 */     this.playerShapeValue = new ListValue("Player Shape", new String[] { "Rectangle", "Circle" }, "Circle");
/*  39 */     this.playerSizeValue = new FloatValue("Player Size", 5.0F, 0.5F, 20.0F);
/*  40 */     this.fovSizeValue = new FloatValue("FOV Size", 10.0F, 0.0F, 50.0F);
/*  41 */     this.shadowValue = new BoolValue("Shadow", false); } private final FloatValue playerSizeValue; private final FloatValue fovSizeValue; private final BoolValue shadowValue; private static final float SQRT_OF_TWO; @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Radar2$Companion;", "", "()V", "SQRT_OF_TWO", "", "XSJClient"}) public static final class Companion {
/*     */     private Companion() {} } @Nullable
/*  43 */   public Border drawElement() { Color gradientColor1 = new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue());
/*  44 */     Color gradientColor2 = new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue());
/*  45 */     Color gradientColor3 = new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue());
/*  46 */     Color gradientColor4 = new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue());
/*     */     
/*  48 */     IEntity renderViewEntity = MinecraftInstance.mc.getRenderViewEntity();
/*     */     
/*  50 */     float size = ((Number)this.sizeValue.get()).floatValue();
/*     */     
/*  52 */     float viewDistance = ((Number)this.viewDistanceValue.get()).floatValue() * 16.0F;
/*     */     
/*  54 */     double maxDisplayableDistanceSquare = (viewDistance + ((Number)this.fovSizeValue.get()).floatValue()) * (
/*  55 */       viewDistance + ((Number)this.fovSizeValue.get()).floatValue());
/*  56 */     float halfSize = size / 2.0F;
/*     */     
/*  58 */     RoundedUtil.drawGradientRound(0.0F, 0.0F, size, size, ((Number)CustomColor.ra.get()).floatValue(), ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2);
/*     */     
/*  60 */     if (((Boolean)this.shadowValue.get()).booleanValue()) {
/*  61 */       RenderUtils.drawShadowWithCustomAlpha(0.0F, 0.0F, size, size, 255.0F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     float f3 = (float)getX(), f2 = (float)getY(), f1 = (float)getX(); boolean bool = false; float f4 = (float)Math.ceil(size); f4 = (float)getY(); f3 += f4; f2 = f2; f1 = f1; bool = false; float f5 = (float)Math.ceil(size); RenderUtils.makeScissorBox(f1, f2, f3, f4 + f5);
/*     */     
/*  71 */     GL11.glEnable(3089);
/*     */     
/*  73 */     GL11.glPushMatrix();
/*     */     
/*  75 */     GL11.glTranslatef(halfSize, halfSize, 0.0F);
/*  76 */     if (renderViewEntity == null) Intrinsics.throwNpe();  GL11.glRotatef(renderViewEntity.getRotationYaw(), 0.0F, 0.0F, -1.0F);
/*     */     
/*  78 */     GL11.glEnable(3042);
/*  79 */     GL11.glBlendFunc(770, 771);
/*     */     
/*  81 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  83 */     GL11.glDisable(3553);
/*  84 */     GL11.glEnable(2848);
/*     */     
/*  86 */     boolean circleMode = StringsKt.equals((String)this.playerShapeValue.get(), "circle", true);
/*     */     
/*  88 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  89 */     Intrinsics.checkExpressionValueIsNotNull(tessellator, "tessellator"); BufferBuilder worldRenderer = tessellator.func_178180_c();
/*     */     
/*  91 */     if (circleMode) {
/*  92 */       GL11.glEnable(2832);
/*     */     }
/*  94 */     float playerSize = ((Number)this.playerSizeValue.get()).floatValue();
/*     */     
/*  96 */     GL11.glEnable(2881);
/*     */     
/*  98 */     worldRenderer.func_181668_a(0, DefaultVertexFormats.field_181706_f);
/*  99 */     GL11.glPointSize(playerSize);
/*     */     
/* 101 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 102 */       if (entity != null && entity != MinecraftInstance.mc.getThePlayer() && EntityUtils.isSelected(entity, false)) {
/* 103 */         Vector2f positionRelativeToPlayer = new Vector2f((float)(renderViewEntity.getPosX() - entity.getPosX()), 
/* 104 */             (float)(renderViewEntity.getPosZ() - entity.getPosZ()));
/*     */         
/* 106 */         if (maxDisplayableDistanceSquare < positionRelativeToPlayer.lengthSquared()) {
/*     */           continue;
/*     */         }
/* 109 */         boolean transform = (((Number)this.fovSizeValue.get()).floatValue() > 0.0F);
/*     */         
/* 111 */         if (transform) {
/* 112 */           GL11.glPushMatrix();
/*     */           
/* 114 */           GL11.glTranslatef(positionRelativeToPlayer.x / viewDistance * size, 
/* 115 */               positionRelativeToPlayer.y / viewDistance * size, 0.0F);
/* 116 */           GL11.glRotatef(entity.getRotationYaw(), 0.0F, 0.0F, 1.0F);
/*     */         } 
/*     */         
/* 119 */         if (Retreat.INSTANCE.getModuleManager().get(ESP.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.ESP");  Color color = ((ESP)Retreat.INSTANCE.getModuleManager().get(ESP.class)).getColor(entity);
/*     */         
/* 121 */         worldRenderer.func_181662_b((positionRelativeToPlayer.x / viewDistance * size), (
/* 122 */             positionRelativeToPlayer.y / viewDistance * size), 0.0D)
/* 123 */           .func_181666_a(color.getRed() / 255.0F, color.getGreen() / 255.0F, 
/* 124 */             color.getBlue() / 255.0F, 1.0F).func_181675_d();
/*     */ 
/*     */         
/* 127 */         if (transform) {
/* 128 */           GL11.glPopMatrix();
/*     */         }
/*     */       } 
/*     */     } 
/* 132 */     tessellator.func_78381_a();
/*     */     
/* 134 */     if (circleMode) {
/* 135 */       GL11.glDisable(2832);
/*     */     }
/*     */     
/* 138 */     GL11.glDisable(2881);
/*     */     
/* 140 */     GL11.glEnable(3553);
/* 141 */     GL11.glDisable(3042);
/* 142 */     GL11.glDisable(2848);
/*     */     
/* 144 */     GL11.glDisable(3089);
/*     */     
/* 146 */     GL11.glPopMatrix();
/*     */     
/* 148 */     return new Border(0.0F, 0.0F, size, size); }
/*     */ 
/*     */   
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   static {
/*     */     float f = 2.0F;
/*     */     boolean bool = false;
/*     */     SQRT_OF_TWO = (float)Math.sqrt(f);
/*     */   }
/*     */   
/*     */   public Radar2() {
/*     */     this(0.0D, 0.0D, 3, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Radar2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */