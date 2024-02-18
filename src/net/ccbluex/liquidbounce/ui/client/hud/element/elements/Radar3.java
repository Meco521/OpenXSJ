/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Vector2f;
/*     */ 
/*     */ @ElementInfo(name = "Radar3")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\016\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\002\b\007\030\000 42\0020\001:\0014B\031\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005J\n\020,\032\004\030\0010-H\026J\006\020.\032\0020\023J\006\020/\032\0020\023J\006\0200\032\0020\023J\006\0201\032\0020\023J\b\0202\032\00203H\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\007X\004¢\006\002\n\000R\016\020\t\032\0020\007X\004¢\006\002\n\000R\016\020\n\032\0020\007X\004¢\006\002\n\000R\016\020\013\032\0020\007X\004¢\006\002\n\000R\016\020\f\032\0020\007X\004¢\006\002\n\000R\016\020\r\032\0020\007X\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\026\020\022\032\n \024*\004\030\0010\0230\023X\016¢\006\002\n\000R\026\020\025\032\n \024*\004\030\0010\0230\023X\016¢\006\002\n\000R\020\020\026\032\004\030\0010\023X\016¢\006\002\n\000R\020\020\027\032\004\030\0010\023X\016¢\006\002\n\000R\016\020\030\032\0020\017X\004¢\006\002\n\000R\021\020\031\032\0020\032¢\006\b\n\000\032\004\b\033\020\034R\021\020\035\032\0020\036¢\006\b\n\000\032\004\b\037\020 R\016\020!\032\0020\021X\004¢\006\002\n\000R\016\020\"\032\0020\036X\004¢\006\002\n\000R\016\020#\032\0020\017X\004¢\006\002\n\000R\016\020$\032\0020\007X\004¢\006\002\n\000R\020\020%\032\004\030\0010\023X\016¢\006\002\n\000R\020\020&\032\004\030\0010\023X\016¢\006\002\n\000R\016\020'\032\0020\017X\004¢\006\002\n\000R\016\020(\032\0020\017X\004¢\006\002\n\000R\020\020)\032\004\030\0010\023X\016¢\006\002\n\000R\020\020*\032\004\030\0010\023X\016¢\006\002\n\000R\016\020+\032\0020\017X\004¢\006\002\n\000¨\0065"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Radar3;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "(DD)V", "Alpha", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "Alpha2", "alpha", "borderAlphaValue", "borderBlueValue", "borderGreenValue", "borderRedValue", "borderStrengthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "borderValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "firstColor", "Ljava/awt/Color;", "kotlin.jvm.PlatformType", "firstColor2", "fourthColor", "fourthColor2", "fovSizeValue", "hud", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHud", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "modes", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModes", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "novoshadow", "playerShapeValue", "playerSizeValue", "radius", "secondColor", "secondColor2", "shadowValue", "sizeValue", "thirdColor", "thirdColor2", "viewDistanceValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getAlternateClientColor", "getAlternateClientColor2", "getClientColor", "getClientColor2", "shader", "", "Companion", "XSJClient"})
/*     */ public final class Radar3 extends Element {
/*     */   @NotNull
/*     */   private final ListValue modes;
/*     */   private final IntegerValue alpha;
/*     */   private final IntegerValue radius;
/*     */   private final IntegerValue Alpha;
/*     */   private final IntegerValue Alpha2;
/*     */   private final BoolValue novoshadow;
/*     */   private final FloatValue shadowValue;
/*     */   
/*     */   public Radar3(double x, double y) {
/*  38 */     super(x, y, 0.0F, null, 12, null);
/*     */ 
/*     */ 
/*     */     
/*  42 */     this.modes = new ListValue("Mode", new String[] { "Soar", "Tenacity", "New" }, "New");
/*  43 */     this.alpha = new IntegerValue("Color Alpha", 240, 0, 255);
/*  44 */     this.radius = new IntegerValue("radius", 5, 0, 10);
/*  45 */     this.Alpha = new IntegerValue(" Soar-Alpha", 210, 0, 255);
/*  46 */     this.Alpha2 = new IntegerValue("Alpha", 40, 0, 255);
/*  47 */     this.novoshadow = new BoolValue("Shadow", true);
/*  48 */     this.shadowValue = new FloatValue("ShadowStrength", 10.0F, 0.0F, 20.0F);
/*  49 */     this.sizeValue = new FloatValue("Size", 90.0F, 30.0F, 500.0F);
/*  50 */     this.viewDistanceValue = new FloatValue("View Distance", 4.0F, 0.5F, 32.0F);
/*  51 */     this.playerShapeValue = new ListValue("Player Shape", new String[] { "Rectangle", "Circle" }, "Triangle");
/*  52 */     this.playerSizeValue = new FloatValue("Player Size", 2.0F, 0.5F, 20.0F);
/*  53 */     this.fovSizeValue = new FloatValue("FOV Size", 10.0F, 0.0F, 50.0F);
/*  54 */     this.borderValue = new BoolValue("Border", true);
/*  55 */     this.borderStrengthValue = new FloatValue("Border Strength", 1.5F, 1.0F, 5.0F);
/*  56 */     this.borderRedValue = new IntegerValue("Border Red", 255, 0, 255);
/*  57 */     this.borderGreenValue = new IntegerValue("Border Green", 255, 0, 255);
/*  58 */     this.borderBlueValue = new IntegerValue("Border Blue", 255, 0, 255);
/*  59 */     this.borderAlphaValue = new IntegerValue("Border Alpha", 120, 0, 255);
/*  60 */     this.firstColor = Color.BLACK;
/*  61 */     this.secondColor = Color.BLACK;
/*  62 */     this.thirdColor = Color.BLACK;
/*  63 */     this.fourthColor = Color.BLACK;
/*     */     
/*  65 */     this.firstColor2 = Color.BLACK;
/*  66 */     this.secondColor2 = Color.BLACK;
/*  67 */     this.thirdColor2 = Color.BLACK;
/*  68 */     this.fourthColor2 = Color.BLACK;
/*  69 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hud = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue sizeValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue viewDistanceValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final ListValue playerShapeValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue playerSizeValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue fovSizeValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue borderValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final FloatValue borderStrengthValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue borderRedValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue borderGreenValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue borderBlueValue;
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue borderAlphaValue;
/*     */ 
/*     */   
/*     */   private Color firstColor;
/*     */ 
/*     */   
/*     */   private Color secondColor;
/*     */ 
/*     */   
/*     */   private Color thirdColor;
/*     */ 
/*     */   
/*     */   private Color fourthColor;
/*     */ 
/*     */   
/*     */   private Color firstColor2;
/*     */ 
/*     */   
/*     */   private Color secondColor2;
/*     */ 
/*     */   
/*     */   private Color thirdColor2;
/*     */ 
/*     */   
/*     */   private Color fourthColor2;
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   private final HUD hud;
/*     */ 
/*     */   
/*     */   private static final float SQRT_OF_TWO;
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Radar3$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 156 */       GL11.glPushMatrix();
/* 157 */       GL11.glTranslated(Radar3.this.getRenderX(), Radar3.this.getRenderY(), 0.0D);
/* 158 */       RoundedUtil.drawGradientRound(0.0F, 0.0F, ((Number)Radar3.this.sizeValue.get()).floatValue(), ((Number)Radar3.this.sizeValue.get()).floatValue(), ((Number)Radar3.this.radius.get()).intValue(), DrRenderUtils.applyOpacity(Radar3.this.fourthColor, 1.0F), Radar3.this.firstColor, Radar3.this.secondColor, Radar3.this.thirdColor);
/*     */       
/* 160 */       GL11.glPopMatrix();
/*     */     } Radar3$drawElement$1() { super(0); }
/* 162 */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Radar3$drawElement$2 extends Lambda implements Function0<Unit> { Radar3$drawElement$2(boolean param1Boolean) { super(0); } public final void invoke() { if (!this.$shadowNoCutValue) {
/* 163 */         GL11.glPushMatrix();
/* 164 */         GL11.glTranslated(Radar3.this.getRenderX(), Radar3.this.getRenderY(), 0.0D);
/* 165 */         RoundedUtil.drawGradientRound(0.0F, 0.0F, ((Number)Radar3.this.sizeValue.get()).floatValue(), ((Number)Radar3.this.sizeValue.get()).floatValue(), ((Number)Radar3.this.radius.get()).intValue(), DrRenderUtils.applyOpacity(Radar3.this.fourthColor, 1.0F), Radar3.this.firstColor, Radar3.this.secondColor, Radar3.this.thirdColor);
/*     */         
/* 167 */         GL11.glPopMatrix();
/*     */       }  } } @Nullable public Border drawElement() { this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.firstColor2 = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor2(), getAlternateClientColor2(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.secondColor2 = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor2(), getAlternateClientColor2(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.thirdColor2 = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor2(), getAlternateClientColor2(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); this.fourthColor2 = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor2(), getAlternateClientColor2(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue()); boolean shadowNoCutValue = true; if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hud = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class); float width = 140.0F; String str = (String)this.modes.get();
/*     */     boolean bool1 = false;
/*     */     if (str == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str = str.toLowerCase();
/*     */     switch (str.hashCode())
/*     */     { case 108960:
/* 177 */         if (str.equals("new"))
/* 178 */         { float f = ((Number)this.sizeValue.get()).floatValue();
/* 179 */           RenderUtils.drawRoundedRectfix(0.0F, 0.0F, f, f, ((Number)this.radius.get()).intValue(), (new Color(0, 0, 0, ((Number)this.Alpha2.get()).intValue())).getRGB());
/*     */           
/* 181 */           RenderUtils.drawRoundedRectfix(0.0F, -21.0F, f, 15.0F, ((Number)this.radius.get()).intValue(), (new Color(0, 20, 40, 225)).getRGB());
/*     */           
/* 183 */           UiFonts.Newuiicon318.drawString("e", 3.0F, -16.8F, (new Color(6, 180, 255)).getRGB());
/* 184 */           Fonts.Newuifont17.drawString("Radar", 13.3F, -16.9F, (new Color(255, 255, 255)).getRGB()); }  break;
/*     */       case -1307030705: if (str.equals("tenacity")) { float f = ((Number)this.sizeValue.get()).floatValue(); RoundedUtil.drawGradientRound(0.0F, 0.0F, f, f, ((Number)this.radius.get()).intValue(), ColorUtil.applyOpacity(this.fourthColor2, 1.0F), this.firstColor2, this.secondColor2, this.thirdColor2); }  break;
/*     */       case 3535757:
/* 187 */         if (str.equals("soar")) { float f = ((Number)this.sizeValue.get()).floatValue(); if (((Boolean)this.novoshadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new Radar3$drawElement$1(), new Radar3$drawElement$2(shadowNoCutValue)); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  }  break; }  if ((String)this.modes.get() == "Soar") {
/* 188 */       RoundedUtil.drawRound(0.0F, 0.0F, ((Number)this.sizeValue.get()).floatValue(), ((Number)this.sizeValue.get()).floatValue(), ((Number)this.radius.get()).intValue(), new Color(0, 0, 0, ((Number)this.Alpha.get()).intValue()));
/*     */     }
/* 190 */     GlStateManager.func_179117_G();
/* 191 */     IEntity renderViewEntity = MinecraftInstance.mc.getRenderViewEntity();
/*     */     
/* 193 */     float size = ((Number)this.sizeValue.get()).floatValue();
/*     */     
/* 195 */     float viewDistance = ((Number)this.viewDistanceValue.get()).floatValue() * 16.0F;
/*     */     
/* 197 */     double maxDisplayableDistanceSquare = (viewDistance + ((Number)this.fovSizeValue.get()).floatValue()) * (
/* 198 */       viewDistance + ((Number)this.fovSizeValue.get()).floatValue());
/* 199 */     float halfSize = size / 2.0F;
/*     */     
/* 201 */     if (((Boolean)this.borderValue.get()).booleanValue()) {
/* 202 */       float strength = ((Number)this.borderStrengthValue.get()).floatValue() / 2.0F;
/* 203 */       int borderColor = (new Color(((Number)this.borderRedValue.get()).intValue(), ((Number)this.borderGreenValue.get()).intValue(), ((Number)this.borderBlueValue.get()).intValue(), ((Number)this.borderAlphaValue.get()).intValue())).getRGB();
/*     */ 
/*     */       
/* 206 */       RenderUtils.drawRect(halfSize - strength, 0.0F, halfSize + strength, size, borderColor);
/*     */       
/* 208 */       RenderUtils.drawRect(0.0F, halfSize - strength, halfSize - strength, halfSize + strength, borderColor);
/* 209 */       RenderUtils.drawRect(halfSize + strength, halfSize - strength, size, halfSize + strength, borderColor);
/*     */       
/* 211 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */ 
/*     */     
/* 215 */     float f3 = (float)getX(), f2 = (float)getY(), f1 = (float)getX(); boolean bool2 = false; float f4 = (float)Math.ceil(size); f4 = (float)getY(); f3 += f4; f2 = f2; f1 = f1; bool2 = false; float f5 = (float)Math.ceil(size); RenderUtils.makeScissorBox(f1, f2, f3, f4 + f5);
/*     */     
/* 217 */     GL11.glEnable(3089);
/*     */     
/* 219 */     GL11.glPushMatrix();
/*     */     
/* 221 */     GL11.glTranslatef(halfSize, halfSize, 0.0F);
/* 222 */     if (renderViewEntity == null) Intrinsics.throwNpe();  GL11.glRotatef(renderViewEntity.getRotationYaw(), 0.0F, 0.0F, -1.0F);
/*     */     
/* 224 */     GL11.glEnable(3042);
/* 225 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 227 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 229 */     GL11.glDisable(3553);
/* 230 */     GL11.glEnable(2848);
/*     */     
/* 232 */     boolean circleMode = StringsKt.equals((String)this.playerShapeValue.get(), "circle", true);
/*     */     
/* 234 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 235 */     Intrinsics.checkExpressionValueIsNotNull(tessellator, "tessellator"); BufferBuilder worldRenderer = tessellator.func_178180_c();
/*     */     
/* 237 */     if (circleMode) {
/* 238 */       GL11.glEnable(2832);
/*     */     }
/* 240 */     float playerSize = ((Number)this.playerSizeValue.get()).floatValue();
/*     */     
/* 242 */     GL11.glEnable(2881);
/*     */     
/* 244 */     worldRenderer.func_181668_a(0, DefaultVertexFormats.field_181706_f);
/* 245 */     GL11.glPointSize(playerSize);
/*     */     
/* 247 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 248 */       if (entity != null && entity != MinecraftInstance.mc.getThePlayer() && EntityUtils.isSelected(entity, false)) {
/* 249 */         Vector2f positionRelativeToPlayer = new Vector2f((float)(renderViewEntity.getPosX() - entity.getPosX()), 
/* 250 */             (float)(renderViewEntity.getPosZ() - entity.getPosZ()));
/*     */         
/* 252 */         if (maxDisplayableDistanceSquare < positionRelativeToPlayer.lengthSquared()) {
/*     */           continue;
/*     */         }
/* 255 */         boolean transform = (((Number)this.fovSizeValue.get()).floatValue() > 0.0F);
/*     */         
/* 257 */         if (transform) {
/* 258 */           GL11.glPushMatrix();
/*     */           
/* 260 */           GL11.glTranslatef(positionRelativeToPlayer.x / viewDistance * size, 
/* 261 */               positionRelativeToPlayer.y / viewDistance * size, 0.0F);
/* 262 */           GL11.glRotatef(entity.getRotationYaw(), 0.0F, 0.0F, 1.0F);
/*     */         } 
/*     */         
/* 265 */         if (Retreat.INSTANCE.getModuleManager().get(ESP.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.ESP");  Color color = ((ESP)Retreat.INSTANCE.getModuleManager().get(ESP.class)).getColor(entity);
/*     */         
/* 267 */         worldRenderer.func_181662_b((positionRelativeToPlayer.x / viewDistance * size), (
/* 268 */             positionRelativeToPlayer.y / viewDistance * size), 0.0D)
/* 269 */           .func_181666_a(color.getRed() / 255.0F, color.getGreen() / 255.0F, 
/* 270 */             color.getBlue() / 255.0F, 1.0F).func_181675_d();
/*     */ 
/*     */         
/* 273 */         if (transform) {
/* 274 */           GL11.glPopMatrix();
/*     */         }
/*     */       } 
/*     */     } 
/* 278 */     tessellator.func_78381_a();
/*     */     
/* 280 */     if (circleMode) {
/* 281 */       GL11.glDisable(2832);
/*     */     }
/*     */     
/* 284 */     GL11.glDisable(2881);
/*     */     
/* 286 */     GL11.glEnable(3553);
/* 287 */     GL11.glDisable(3042);
/* 288 */     GL11.glDisable(2848);
/*     */     
/* 290 */     GL11.glDisable(3089);
/*     */     
/* 292 */     GL11.glPopMatrix();
/*     */     
/* 294 */     return new Border(0.0F, 0.0F, size, size); }
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\007\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Radar3$Companion;", "", "()V", "SQRT_OF_TWO", "", "XSJClient"})
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
/*     */   public final ListValue getModes() {
/*     */     return this.modes;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final HUD getHud() {
/*     */     return this.hud;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Color getClientColor() {
/*     */     return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor() {
/*     */     return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), 255);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Color getClientColor2() {
/*     */     return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)this.alpha.get()).intValue());
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor2() {
/*     */     return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)this.alpha.get()).intValue());
/*     */   }
/*     */   
/*     */   public void shader() {
/*     */     this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue());
/*     */     this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue());
/*     */     this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue());
/*     */     this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)this.hud.getHueInterpolation().get()).booleanValue());
/*     */     String str = (String)this.modes.get();
/*     */     boolean bool = false;
/*     */     if (str == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */     str = str.toLowerCase();
/*     */     switch (str.hashCode()) {
/*     */       case 108960:
/*     */         if (str.equals("new")) {
/*     */           float size = ((Number)this.sizeValue.get()).floatValue();
/*     */           RenderUtils.drawRoundedRectfix(0.0F, 0.0F, size, size, ((Number)this.radius.get()).intValue(), (new Color(0, 0, 0)).getRGB());
/*     */           RenderUtils.drawRoundedRectfix(0.0F, -21.0F, size, 15.0F, ((Number)this.radius.get()).intValue(), (new Color(0, 0, 0)).getRGB());
/*     */         } 
/*     */         break;
/*     */       case -1307030705:
/*     */         if (str.equals("tenacity")) {
/*     */           float size = ((Number)this.sizeValue.get()).floatValue();
/*     */           if (((Boolean)BlurSettings.RadarGlow.get()).booleanValue()) {
/*     */             RoundedUtil.drawGradientRound(0.0F, 0.0F, size, size, ((Number)this.radius.get()).intValue(), ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor);
/*     */             break;
/*     */           } 
/*     */           RoundedUtil.drawRound(0.0F, 0.0F, size, size, ((Number)this.radius.get()).intValue(), new Color(0, 0, 0));
/*     */         } 
/*     */         break;
/*     */       case 3535757:
/*     */         if (str.equals("soar")) {
/*     */           float size = ((Number)this.sizeValue.get()).floatValue();
/*     */           if (((Boolean)BlurSettings.RadarGlow.get()).booleanValue()) {
/*     */             RoundedUtil.drawGradientRound(0.0F, 0.0F, ((Number)this.sizeValue.get()).floatValue(), ((Number)this.sizeValue.get()).floatValue(), ((Number)this.radius.get()).intValue(), ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor);
/*     */             break;
/*     */           } 
/*     */           RoundedUtil.drawRound(0.0F, 0.0F, ((Number)this.sizeValue.get()).floatValue(), ((Number)this.sizeValue.get()).floatValue(), ((Number)this.radius.get()).intValue(), new Color(0, 0, 0));
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Radar3() {
/*     */     this(0.0D, 0.0D, 3, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Radar3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */