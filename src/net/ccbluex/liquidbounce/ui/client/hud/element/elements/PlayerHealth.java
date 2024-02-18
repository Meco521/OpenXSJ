/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.math.BigDecimal;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.color.CustomColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.HUD;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ 
/*     */ @ElementInfo(name = "PlayerHealth")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\n\020\017\032\004\030\0010\020H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/PlayerHealth;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blurmodule", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getBlurmodule", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "setBlurmodule", "(Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;)V", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class PlayerHealth extends Element {
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   private final IntegerValue bgValue;
/*     */   @NotNull
/*     */   private HUD blurmodule;
/*     */   
/*  23 */   public PlayerHealth() { super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  28 */     this.OutmodeValue = new ListValue("bgmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  29 */     this.Outline = new BoolValue("Outline", true);
/*  30 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*     */ 
/*     */     
/*  33 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.blurmodule = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class); } @NotNull public final HUD getBlurmodule() { return this.blurmodule; } public final void setBlurmodule(@NotNull HUD <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.blurmodule = <set-?>; }
/*     */   
/*     */   @Nullable
/*     */   public Border drawElement() {
/*  37 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  BigDecimal bd = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth());
/*  38 */     Intrinsics.checkExpressionValueIsNotNull(bd.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bd = bd.setScale(1, 3);
/*  39 */     String str = (String)this.OutmodeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 66125872:
/* 143 */         if (str.equals("outline2"))
/* 144 */         { RoundedUtil.drawRound(
/* 145 */               -1.0F, 
/* 146 */               0.0F, 
/* 147 */               77.0F, 
/* 148 */               16.0F, 
/* 149 */               6.4F, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue()));
/*     */           
/* 151 */           if (((Boolean)this.Outline.get()).booleanValue())
/* 152 */             ScaleUtils.drawGidentOutlinedRoundedRect3(-1.0D, 0.0D, 77.0D, 16.0D, 6.4D, ((Number)CustomColor.line.get()).floatValue());  }  break;case 110119: if (str.equals("old")) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  BigDecimal bigDecimal = new BigDecimal(MinecraftInstance.mc.getThePlayer().getHealth()); Intrinsics.checkExpressionValueIsNotNull(bigDecimal.setScale(1, 3), "bd.setScale(1, BigDecimal.ROUND_FLOOR)"); bigDecimal = bigDecimal.setScale(1, 3); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class); if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null)
/* 155 */             throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class); Color gradientColor1 = Color.WHITE; Color gradientColor2 = Color.WHITE; Color gradientColor3 = Color.WHITE; Color gradientColor4 = Color.WHITE; gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false); RoundedUtil.drawGradientRound(-1.0F, 0.0F, 77.0F, 16.0F, ((Number)CustomColor.ra.get()).floatValue(), gradientColor1, gradientColor3, gradientColor2, gradientColor1); }  break;case 3357525: if (str.equals("more"))
/* 156 */         { Color gradientColor1 = 
/* 157 */             new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue());
/* 158 */           Color gradientColor2 = 
/* 159 */             new Color(((Number)CustomColor.r.get()).intValue(), ((Number)CustomColor.g.get()).intValue(), ((Number)CustomColor.b.get()).intValue(), ((Number)CustomColor.a.get()).intValue());
/* 160 */           Color gradientColor3 = 
/* 161 */             new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue());
/* 162 */           Color gradientColor4 = 
/* 163 */             new Color(((Number)CustomColor.r2.get()).intValue(), ((Number)CustomColor.g2.get()).intValue(), ((Number)CustomColor.b2.get()).intValue(), ((Number)CustomColor.a2.get()).intValue());
/*     */           
/* 165 */           RoundedUtil.drawGradientRound(
/* 166 */               -1.0F, 
/* 167 */               0.0F, 
/* 168 */               77.0F, 
/* 169 */               16.0F, ((Number)CustomColor.ra.get()).floatValue(), 
/* 170 */               ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2); }  break;
/*     */       case 66125871:
/*     */         if (str.equals("outline1")) { RoundedUtil.drawRound(-1.0F, 0.0F, 77.0F, 16.0F, 6.4F, new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())); if (((Boolean)this.Outline.get()).booleanValue())
/*     */             ScaleUtils.drawOutline(5.0F, 0.0F, 71.0F, 4.0F, 6.4F, ((Number)CustomColor.line.get()).floatValue(), 3.0F);  }
/*     */          break;
/* 175 */     }  Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.foricotwo24.drawStringWithShadow("H", 5.0D, 5.0D, Color.white.getRGB());
/* 176 */     Intrinsics.checkExpressionValueIsNotNull(Color.white, "Color.white"); CFontLoad.for18.drawStringWithShadow(bd + " Health", 21.0D, 7, Color.white.getRGB());
/*     */ 
/*     */     
/* 179 */     return new Border(0.0F, -16.0F, 70.0F, 30.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\PlayerHealth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */