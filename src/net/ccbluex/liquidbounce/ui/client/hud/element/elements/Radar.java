/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.ESP;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.BufferBuilder;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Vector2f;
/*     */ 
/*     */ @ElementInfo(name = "Radar")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\002\b\007\030\000 \0322\0020\001:\001\032B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\n\020\030\032\004\030\0010\031H\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\007X\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\007X\004¢\006\002\n\000R\016\020\020\032\0020\007X\004¢\006\002\n\000R\016\020\021\032\0020\016X\004¢\006\002\n\000R\016\020\022\032\0020\007X\004¢\006\002\n\000R\021\020\023\032\0020\013¢\006\b\n\000\032\004\b\024\020\025R\016\020\026\032\0020\007X\004¢\006\002\n\000R\016\020\027\032\0020\007X\004¢\006\002\n\000¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Radar;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blur", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "fovSizeValue", "playerShapeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "playerSizeValue", "radiusValue", "shadowColorMode", "shadowValue", "shadowValueopen", "getShadowValueopen", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "sizeValue", "viewDistanceValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "Companion", "XSJClient"})
/*     */ public final class Radar extends Element {
/*     */   public Radar(double x, double y) {
/*  24 */     super(x, y, 0.0F, null, 12, null);
/*     */ 
/*     */ 
/*     */     
/*  28 */     this.sizeValue = new FloatValue("Size", 90.0F, 30.0F, 500.0F);
/*  29 */     this.viewDistanceValue = new FloatValue("View Distance", 4.0F, 0.5F, 32.0F);
/*  30 */     this.playerShapeValue = new ListValue("Player Shape", new String[] { "Rectangle", "Circle" }, "Circle");
/*  31 */     this.playerSizeValue = new FloatValue("Player Size", 5.0F, 0.5F, 20.0F);
/*  32 */     this.fovSizeValue = new FloatValue("FOV Size", 10.0F, 0.0F, 50.0F);
/*  33 */     this.blur = new BoolValue("Blur", false);
/*  34 */     this.BlurStrength = new FloatValue("BlurStrength", 5.0F, 0.0F, 20.0F);
/*  35 */     this.shadowValueopen = new BoolValue("shadow", true);
/*  36 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*  37 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Custom" }, "Background");
/*  38 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  39 */     this.radiusValue = new FloatValue("Radius", 4.25F, 0.0F, 10.0F);
/*     */   }
/*     */   
/*     */   private final FloatValue sizeValue;
/*     */   private final FloatValue viewDistanceValue;
/*     */   private final ListValue playerShapeValue;
/*     */   private final FloatValue playerSizeValue;
/*     */   private final FloatValue fovSizeValue;
/*     */   private final BoolValue blur;
/*     */   private final FloatValue BlurStrength;
/*     */   @NotNull
/*     */   private final BoolValue shadowValueopen;
/*     */   private final FloatValue shadowValue;
/*     */   private final ListValue shadowColorMode;
/*     */   private final IntegerValue bgValue;
/*     */   private final FloatValue radiusValue;
/*     */   private static final float SQRT_OF_TWO;
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Radar$drawElement$1
/*     */     extends Lambda implements Function0<Unit>
/*     */   {
/*  61 */     public final void invoke() { GL11.glPushMatrix();
/*  62 */       GL11.glTranslated(Radar.this.getRenderX(), Radar.this.getRenderY(), 0.0D);
/*  63 */       GL11.glScalef(Radar.this.getScale(), Radar.this.getScale(), Radar.this.getScale());
/*     */       
/*  65 */       RenderUtils.originalRoundedRect(
/*  66 */           1.0F, 1.0F, this.$size - true, this.$size - true, ((Number)Radar.this.radiusValue.get()).floatValue(), 
/*  67 */           StringsKt.equals((String)Radar.this.shadowColorMode.get(), "background", true) ? (
/*  68 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/*  70 */           new Color(0, 0, 0)).getRGB());
/*     */       
/*  72 */       GL11.glPopMatrix(); } Radar$drawElement$1(float param1Float) { super(0); }
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Radar$drawElement$2 extends Lambda implements Function0<Unit> {
/*  74 */     Radar$drawElement$2(float param1Float) { super(0); } public final void invoke() { GL11.glPushMatrix();
/*  75 */       GL11.glTranslated(Radar.this.getRenderX(), Radar.this.getRenderY(), 0.0D);
/*  76 */       GL11.glScalef(Radar.this.getScale(), Radar.this.getScale(), Radar.this.getScale());
/*  77 */       GlStateManager.func_179147_l();
/*  78 */       GlStateManager.func_179090_x();
/*  79 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  80 */       RenderUtils.fastRoundedRect(1.0F, 1.0F, this.$size - true, this.$size - true, ((Number)Radar.this.radiusValue.get()).floatValue());
/*  81 */       GlStateManager.func_179098_w();
/*  82 */       GlStateManager.func_179084_k();
/*  83 */       GL11.glPopMatrix(); } } @Nullable public Border drawElement() { IEntity renderViewEntity = MinecraftInstance.mc.getRenderViewEntity(); float viewDistance = ((Number)this.viewDistanceValue.get()).floatValue() * 16.0F; double maxDisplayableDistanceSquare = (viewDistance + ((Number)this.fovSizeValue.get()).floatValue()) * (viewDistance + ((Number)this.fovSizeValue.get()).floatValue()); float size = ((Number)this.sizeValue.get()).floatValue(); float halfSize = size / 2.0F; RenderUtils.drawRoundedRect(1.0F, 1.0F, size - true, size - true, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F);
/*     */     GL11.glPushMatrix();
/*     */     if (((Boolean)this.shadowValueopen.get()).booleanValue())
/*     */       ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new Radar$drawElement$1(size), new Radar$drawElement$2(size)); 
/*  87 */     GL11.glPopMatrix();
/*  88 */     GL11.glScalef(getScale(), getScale(), getScale());
/*  89 */     GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     
/*  91 */     if (((Boolean)this.blur.get()).booleanValue()) {
/*  92 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/*  93 */       GL11.glPushMatrix();
/*  94 */       BlurBuffer.CustomBlurRoundArea(
/*  95 */           (float)getRenderX() - 1.0F, 
/*  96 */           (float)getRenderY() - 2.0F, 
/*  97 */           size + 2.0F, 
/*  98 */           size + 2.0F, (
/*  99 */           (Number)this.radiusValue.get()).floatValue(), ((Number)this.BlurStrength.get()).floatValue());
/*     */       
/* 101 */       GL11.glPopMatrix();
/* 102 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     float f3 = (float)getX(), f2 = (float)getY(), f1 = (float)getX(); boolean bool = false; float f4 = (float)Math.ceil(size); f4 = (float)getY(); f3 += f4; f2 = f2; f1 = f1; bool = false; float f5 = (float)Math.ceil(size); RenderUtils.makeScissorBox(f1, f2, f3, f4 + f5);
/* 110 */     GL11.glEnable(3089);
/* 111 */     GL11.glPushMatrix();
/* 112 */     GL11.glTranslatef(halfSize, halfSize, 0.0F);
/* 113 */     if (renderViewEntity == null) Intrinsics.throwNpe();  GL11.glRotatef(renderViewEntity.getRotationYaw(), 0.0F, 0.0F, -1.0F);
/* 114 */     GL11.glEnable(3042);
/* 115 */     GL11.glBlendFunc(770, 771);
/* 116 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 117 */     GL11.glDisable(3553);
/* 118 */     GL11.glEnable(2848);
/* 119 */     boolean circleMode = StringsKt.equals((String)this.playerShapeValue.get(), "circle", true);
/* 120 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 121 */     Intrinsics.checkExpressionValueIsNotNull(tessellator, "tessellator"); BufferBuilder worldRenderer = tessellator.func_178180_c();
/* 122 */     if (circleMode) GL11.glEnable(2832); 
/* 123 */     float playerSize = ((Number)this.playerSizeValue.get()).floatValue();
/* 124 */     GL11.glEnable(2881);
/* 125 */     worldRenderer.func_181668_a(0, DefaultVertexFormats.field_181706_f);
/* 126 */     GL11.glPointSize(playerSize);
/* 127 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 128 */       if (entity != null && entity != MinecraftInstance.mc.getThePlayer() && EntityUtils.isSelected(entity, false)) {
/* 129 */         Vector2f positionRelativeToPlayer = new Vector2f((float)(renderViewEntity.getPosX() - entity.getPosX()), 
/* 130 */             (float)(renderViewEntity.getPosZ() - entity.getPosZ()));
/* 131 */         if (maxDisplayableDistanceSquare < positionRelativeToPlayer.lengthSquared())
/*     */           continue; 
/* 133 */         boolean transform = (((Number)this.fovSizeValue.get()).floatValue() > 0.0F);
/* 134 */         if (transform) {
/* 135 */           GL11.glPushMatrix();
/* 136 */           GL11.glTranslatef(positionRelativeToPlayer.x / viewDistance * size, positionRelativeToPlayer.y / viewDistance * size, 0.0F);
/* 137 */           GL11.glRotatef(entity.getRotationYaw(), 0.0F, 0.0F, 1.0F);
/*     */         } 
/* 139 */         if (Retreat.INSTANCE.getModuleManager().get(ESP.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.ESP");  Color color = ((ESP)Retreat.INSTANCE.getModuleManager().get(ESP.class)).getColor(entity);
/* 140 */         worldRenderer.func_181662_b((positionRelativeToPlayer.x / viewDistance * size), (positionRelativeToPlayer.y / viewDistance * size), 0.0D).func_181666_a(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, 1.0F).func_181675_d();
/* 141 */         if (transform) {
/* 142 */           GL11.glPopMatrix();
/*     */         }
/*     */       } 
/*     */     } 
/* 146 */     tessellator.func_78381_a();
/*     */     
/* 148 */     if (circleMode) {
/* 149 */       GL11.glDisable(2832);
/*     */     }
/*     */     
/* 152 */     GL11.glDisable(2881);
/* 153 */     GL11.glEnable(3553);
/* 154 */     GL11.glDisable(3042);
/* 155 */     GL11.glDisable(2848);
/* 156 */     GL11.glDisable(3089);
/* 157 */     GL11.glPopMatrix();
/* 158 */     return new Border(0.0F, 0.0F, size, size); }
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Radar$Companion;", "", "()V", "SQRT_OF_TWO", "", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */   }
/*     */   
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   static {
/*     */     float f = 2.0F;
/*     */     boolean bool = false;
/*     */     SQRT_OF_TWO = (float)Math.sqrt(f);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getShadowValueopen() {
/*     */     return this.shadowValueopen;
/*     */   }
/*     */   
/*     */   public Radar() {
/*     */     this(0.0D, 0.0D, 3, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Radar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */