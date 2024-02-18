/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.font.CFontLoad;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Speed")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\006\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\017\032\0020\020H\002J\n\020\021\032\004\030\0010\022H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Speed;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blurmodule", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getBlurmodule", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "setBlurmodule", "(Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;)V", "calculateBPS", "", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class Speed extends Element {
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   
/*  26 */   public Speed() { super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     this.OutmodeValue = new ListValue("Outmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  33 */     this.Outline = new BoolValue("Outline", true);
/*  34 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*     */     
/*  36 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.blurmodule = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class); } private final IntegerValue bgValue; @NotNull private HUD blurmodule; @NotNull public final HUD getBlurmodule() { return this.blurmodule; } public final void setBlurmodule(@NotNull HUD <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.blurmodule = <set-?>; }
/*     */   
/*     */   private final double calculateBPS() {
/*  39 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX();
/*  40 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d2 = MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ(); boolean bool = false;
/*  41 */     double bps = Math.hypot(d1, d2) * MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/*  42 */     return MathKt.roundToLong(bps * 100.0D) / 100.0D;
/*     */   } @Nullable
/*     */   public Border drawElement() {
/*  45 */     if (StringsKt.equals((String)this.OutmodeValue.get(), "old", true)) {
/*  46 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth());
/*  47 */       Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3);
/*     */ 
/*     */       
/*  50 */       if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class);
/*  51 */       if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class);
/*  52 */       Color gradientColor1 = Color.WHITE;
/*  53 */       Color gradientColor2 = Color.WHITE;
/*  54 */       Color gradientColor3 = Color.WHITE;
/*  55 */       Color gradientColor4 = Color.WHITE;
/*  56 */       gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(
/*  57 */           10, 
/*  58 */           20, 
/*  59 */           new Color((
/*  60 */             (Number)color.getColorRedValue().get()).intValue(), (
/*  61 */             (Number)color.getColorGreenValue().get()).intValue(), (
/*  62 */             (Number)color.getColorBlueValue().get()).intValue(), (
/*  63 */             (Number)color.getColoralpha().get()).intValue()), 
/*     */           
/*  65 */           new Color((
/*  66 */             (Number)color2.getColorRedValue().get()).intValue(), (
/*  67 */             (Number)color2.getColorGreenValue().get()).intValue(), (
/*  68 */             (Number)color2.getColorBlueValue().get()).intValue(), (
/*  69 */             (Number)color2.getColoralpha().get()).intValue()), 
/*     */           
/*  71 */           false);
/*     */       
/*  73 */       gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(
/*  74 */           20, 
/*  75 */           90, 
/*  76 */           new Color((
/*  77 */             (Number)color2.getColorRedValue().get()).intValue(), (
/*  78 */             (Number)color2.getColorGreenValue().get()).intValue(), (
/*  79 */             (Number)color2.getColorBlueValue().get()).intValue(), (
/*  80 */             (Number)color.getColoralpha().get()).intValue()), 
/*     */           
/*  82 */           new Color((
/*  83 */             (Number)color2.getColorRedValue().get()).intValue(), (
/*  84 */             (Number)color2.getColorGreenValue().get()).intValue(), (
/*  85 */             (Number)color2.getColorBlueValue().get()).intValue(), (
/*  86 */             (Number)color2.getColoralpha().get()).intValue()), 
/*     */           
/*  88 */           false);
/*     */       
/*  90 */       gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(
/*  91 */           20, 
/*  92 */           270, 
/*  93 */           new Color((
/*  94 */             (Number)color.getColorRedValue().get()).intValue(), (
/*  95 */             (Number)color.getColorGreenValue().get()).intValue(), (
/*  96 */             (Number)color.getColorBlueValue().get()).intValue(), (
/*  97 */             (Number)color.getColoralpha().get()).intValue()), 
/*     */           
/*  99 */           new Color((
/* 100 */             (Number)color.getColorRedValue().get()).intValue(), (
/* 101 */             (Number)color.getColorGreenValue().get()).intValue(), (
/* 102 */             (Number)color.getColorBlueValue().get()).intValue(), (
/* 103 */             (Number)color2.getColoralpha().get()).intValue()), 
/*     */           
/* 105 */           false);
/*     */       
/* 107 */       gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(
/* 108 */           20, 
/* 109 */           270, 
/* 110 */           new Color((
/* 111 */             (Number)color2.getColorRedValue().get()).intValue(), (
/* 112 */             (Number)color2.getColorGreenValue().get()).intValue(), (
/* 113 */             (Number)color2.getColorBlueValue().get()).intValue(), (
/* 114 */             (Number)color.getColoralpha().get()).intValue()), 
/*     */           
/* 116 */           new Color((
/* 117 */             (Number)color2.getColorRedValue().get()).intValue(), (
/* 118 */             (Number)color2.getColorGreenValue().get()).intValue(), (
/* 119 */             (Number)color2.getColorBlueValue().get()).intValue(), (
/* 120 */             (Number)color2.getColoralpha().get()).intValue()), 
/*     */           
/* 122 */           false);
/*     */ 
/*     */       
/* 125 */       RoundedUtil.drawGradientRound(
/* 126 */           -1.0F, 
/* 127 */           0.0F, 
/* 128 */           70.0F, 
/* 129 */           16.0F, (
/* 130 */           (Number)AColorPalette.Companion.getRa().get()).floatValue(), 
/* 131 */           gradientColor1, 
/* 132 */           gradientColor3, 
/* 133 */           gradientColor2, 
/* 134 */           gradientColor1);
/*     */ 
/*     */       
/* 137 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.CP24.drawString("C", 4.0F, 5.0F, Color.white.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawString(String.valueOf(calculateBPS()) + " m/s", 21.0F, (float)7, Color.white.getRGB());
/*     */ 
/*     */       
/* 145 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 146 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 147 */       GL11.glPushMatrix();
/* 148 */       GL11.glPopMatrix();
/* 149 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 150 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/* 152 */     if (StringsKt.equals((String)this.OutmodeValue.get(), "more", true)) {
/* 153 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth());
/* 154 */       Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3);
/*     */ 
/*     */       
/* 157 */       Color gradientColor1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue());
/* 158 */       Color gradientColor2 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue());
/* 159 */       Color gradientColor3 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue());
/* 160 */       Color gradientColor4 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue());
/*     */ 
/*     */       
/* 163 */       RoundedUtil.drawGradientRound(
/* 164 */           -1.0F, 
/* 165 */           0.0F, 
/* 166 */           70.0F, 
/* 167 */           16.0F, (
/* 168 */           (Number)AColorPalette.Companion.getRa().get()).floatValue(), 
/* 169 */           ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2);
/*     */ 
/*     */       
/* 172 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.CP24.drawString("C", 4.0F, 5.0F, Color.white.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawString(String.valueOf(calculateBPS()) + " m/s", 21.0F, (float)7, Color.white.getRGB());
/*     */ 
/*     */       
/* 180 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 181 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 182 */       GL11.glPushMatrix();
/* 183 */       GL11.glPopMatrix();
/* 184 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 185 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/* 187 */     if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline1", true)) {
/* 188 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth());
/* 189 */       Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3);
/*     */ 
/*     */       
/* 192 */       RoundedUtil.drawRound(
/* 193 */           -1.0F, 
/* 194 */           0.0F, 
/* 195 */           70.0F, 
/* 196 */           16.0F, 
/* 197 */           6.4F, 
/* 198 */           new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()));
/* 199 */       if (((Boolean)this.Outline.get()).booleanValue()) {
/* 200 */         ScaleUtils.drawOutline(5.0F, 0.0F, 64.0F, 4.0F, 6.4F, ((Number)AColorPalette.Companion.getLine().get()).floatValue(), 3.0F);
/*     */       }
/*     */ 
/*     */       
/* 204 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.CP24.drawString("C", 4.0F, 5.0F, Color.white.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawString(String.valueOf(calculateBPS()) + " m/s", 21.0F, (float)7, Color.white.getRGB());
/*     */ 
/*     */       
/* 212 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 213 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 214 */       GL11.glPushMatrix();
/* 215 */       GL11.glPopMatrix();
/* 216 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 217 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/* 219 */     if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline2", true)) {
/* 220 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth());
/* 221 */       Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3);
/*     */ 
/*     */       
/* 224 */       RoundedUtil.drawRound(
/* 225 */           -1.0F, 
/* 226 */           0.0F, 
/* 227 */           70.0F, 
/* 228 */           16.0F, 
/* 229 */           6.4F, 
/* 230 */           new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()));
/* 231 */       if (((Boolean)this.Outline.get()).booleanValue()) {
/* 232 */         ScaleUtils.drawGidentOutlinedRoundedRect3(-1.0D, 0.0D, 70.0D, 16.0D, 6.4D, ((Number)AColorPalette.Companion.getLine().get()).floatValue());
/*     */       }
/*     */ 
/*     */       
/* 236 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.CP24.drawString("C", 4.0F, 5.0F, Color.white.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 241 */       Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawString(String.valueOf(calculateBPS()) + " m/s", 21.0F, (float)7, Color.white.getRGB());
/*     */ 
/*     */       
/* 244 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 245 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 246 */       GL11.glPushMatrix();
/* 247 */       GL11.glPopMatrix();
/* 248 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 249 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */     } 
/*     */     
/* 252 */     return new Border(0.0F, -16.0F, 70.0F, 30.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Speed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */