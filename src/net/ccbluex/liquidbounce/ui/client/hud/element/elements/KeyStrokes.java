/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ import java.awt.Color;
/*    */ import java.util.ArrayList;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*    */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ 
/*    */ @ElementInfo(name = "KeyStrokes")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\n\020\025\032\004\030\0010\026H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\036\020\t\032\022\022\004\022\0020\0130\nj\b\022\004\022\0020\013`\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000R\016\020\020\032\0020\016X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\004X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/KeyStrokes;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "animSpeedValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "highLightPercent", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "keys", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/KeyStroke;", "Lkotlin/collections/ArrayList;", "outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "outlineBoldValue", "outlineRainbow", "textAlphaValue", "textBlueValue", "textGreenValue", "textRedValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class KeyStrokes extends Element {
/*    */   private final ArrayList<KeyStroke> keys;
/*    */   private final IntegerValue textRedValue;
/*    */   private final IntegerValue textGreenValue;
/*    */   private final IntegerValue textBlueValue;
/*    */   private final IntegerValue textAlphaValue;
/*    */   
/*    */   public KeyStrokes() {
/* 25 */     super(5.0D, 25.0D, 1.25F, Side.Companion.default());
/* 26 */     this.keys = new ArrayList<>();
/*    */ 
/*    */     
/* 29 */     this.textRedValue = new IntegerValue("TextRed", 255, 0, 255);
/* 30 */     this.textGreenValue = new IntegerValue("TextGreen", 255, 0, 255);
/* 31 */     this.textBlueValue = new IntegerValue("TextBlue", 255, 0, 255);
/* 32 */     this.textAlphaValue = new IntegerValue("TextAlpha", 255, 0, 255);
/* 33 */     this.highLightPercent = new FloatValue("HighLightPercent", 0.5F, 0.0F, 1.0F);
/* 34 */     this.animSpeedValue = new IntegerValue("AnimationSpeed", 300, 0, 700);
/* 35 */     this.outline = new BoolValue("Outline", false);
/* 36 */     this.outlineBoldValue = new IntegerValue("OutlineBold", 1, 0, 5);
/* 37 */     this.outlineRainbow = new BoolValue("OutLineRainbow", false);
/* 38 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.font35, "Fonts.font35"); this.fontValue = new FontValue("Font", Fonts.font35);
/*    */ 
/*    */     
/* 41 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74351_w, "mc2.gameSettings.keyBindForward"); this.keys.add((new KeyStroke(MinecraftInstance.mc2.field_71474_y.field_74351_w, 16, 0, 15, 15)).initKeyName());
/* 42 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74370_x, "mc2.gameSettings.keyBindLeft"); this.keys.add((new KeyStroke(MinecraftInstance.mc2.field_71474_y.field_74370_x, 0, 16, 15, 15)).initKeyName());
/* 43 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74368_y, "mc2.gameSettings.keyBindBack"); this.keys.add((new KeyStroke(MinecraftInstance.mc2.field_71474_y.field_74368_y, 16, 16, 15, 15)).initKeyName());
/* 44 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74366_z, "mc2.gameSettings.keyBindRight"); this.keys.add((new KeyStroke(MinecraftInstance.mc2.field_71474_y.field_74366_z, 32, 16, 15, 15)).initKeyName());
/* 45 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74312_F, "mc2.gameSettings.keyBindAttack"); this.keys.add((new KeyStroke(MinecraftInstance.mc2.field_71474_y.field_74312_F, 0, 32, 23, 15)).initKeyName("L"));
/* 46 */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71474_y.field_74313_G, "mc2.gameSettings.keyBindUseItem"); this.keys.add((new KeyStroke(MinecraftInstance.mc2.field_71474_y.field_74313_G, 24, 32, 23, 15)).initKeyName("R"));
/*    */   }
/*    */   private final FloatValue highLightPercent; private final IntegerValue animSpeedValue; private final BoolValue outline; private final IntegerValue outlineBoldValue; private final BoolValue outlineRainbow; private final FontValue fontValue;
/*    */   
/*    */   @Nullable
/*    */   public Border drawElement() {
/* 52 */     if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class);
/* 53 */     if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class);
/* 54 */     Color gradientColor1 = Color.WHITE;
/* 55 */     Color gradientColor2 = Color.WHITE;
/* 56 */     Color gradientColor3 = Color.WHITE;
/* 57 */     Color gradientColor4 = Color.WHITE;
/* 58 */     gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/* 59 */     gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/* 60 */     gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/* 61 */     gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/*    */     
/* 63 */     Color textColor = ((Boolean)this.outlineRainbow.get()).booleanValue() ? 
/*    */ 
/*    */       
/* 66 */       ColorUtils.INSTANCE.rainbowWithAlpha(((Number)this.textAlphaValue.get()).intValue()) : 
/*    */       
/* 68 */       new Color(((Number)this.textRedValue.get()).intValue(), ((Number)this.textGreenValue.get()).intValue(), ((Number)this.textBlueValue.get()).intValue(), ((Number)this.textAlphaValue.get()).intValue());
/*    */ 
/*    */     
/* 71 */     for (KeyStroke keyStroke : this.keys) {
/* 72 */       Intrinsics.checkExpressionValueIsNotNull(gradientColor2, "gradientColor2"); keyStroke.render(((Number)this.animSpeedValue.get()).intValue(), gradientColor2, textColor, ((Number)this.highLightPercent.get()).floatValue(), ((Boolean)this.outline.get()).booleanValue(), ((Number)this.outlineBoldValue.get()).intValue(), (IFontRenderer)this.fontValue.get(), (float)getRenderX(), (float)getRenderY(), getScale());
/*    */     } 
/*    */     
/* 75 */     return new Border(0.0F, 0.0F, 47.0F, 47.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\KeyStrokes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */