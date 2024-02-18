/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.jvm.internal.Ref;
/*     */ import kotlin.jvm.internal.StringCompanionObject;
/*     */ import kotlin.math.MathKt;
/*     */ import lynn.utils.ShadowUtils;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.event.ShaderEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.ui.client.font1.CFontRenderer;
/*     */ import net.ccbluex.liquidbounce.ui.client.font1.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.ui.client.fonts.impl.Fonts;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.DrRenderUtils;
/*     */ import net.ccbluex.liquidbounce.ui.client.newdropdown.utils.render.GradientUtil;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.ServerUtils;
/*     */ import net.ccbluex.liquidbounce.utils.misc.MathUtils;
/*     */ import net.ccbluex.liquidbounce.utils.novoline.ScaleUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RoundedUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.BloomUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.ColorUtil;
/*     */ import net.ccbluex.liquidbounce.utils.render.tenacity.RenderCallback;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.TextValue;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ @ModuleInfo(name = "LogoFix", description = ":)", category = ModuleCategory.RENDER, keyBind = 34)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000z\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020%\n\002\020\016\n\000\n\002\020\021\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\013\n\002\030\002\n\002\b\017\n\002\020\013\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\006\n\000\n\002\020\002\n\002\b\005\n\002\020\b\n\002\b\003\n\002\020\007\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\0209\032\0020:H\002J\033\020;\032\0020<2\f\020\f\032\b\022\004\022\0020\0160\rH\002¢\006\002\020=J\006\020>\032\0020\016J\006\020?\032\0020\016J\016\020@\032\0020\0162\006\020A\032\0020\016J\016\020@\032\0020\0162\006\020A\032\0020BJ\020\020C\032\0020B2\006\020D\032\0020BH\002J\006\020E\032\0020FJ\030\020G\032\0020\0162\006\020H\032\0020\0162\006\020I\032\0020\016H\002J\022\020J\032\0020<2\b\020K\032\004\030\0010LH\007J\022\020M\032\0020<2\b\020K\032\004\030\0010NH\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\016\022\004\022\0020\013\022\004\022\0020\0130\nX\004¢\006\002\n\000R\027\020\f\032\b\022\004\022\0020\0160\r8F¢\006\006\032\004\b\017\020\020R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\026\020\025\032\n \026*\004\030\0010\0160\016X\016¢\006\002\n\000R\020\020\027\032\004\030\0010\016X\016¢\006\002\n\000R\032\020\030\032\0020\004X\016¢\006\016\n\000\032\004\b\031\020\006\"\004\b\032\020\bR\026\020\033\032\n \026*\004\030\0010\0160\016X\016¢\006\002\n\000R\020\020\034\032\004\030\0010\016X\016¢\006\002\n\000R\020\020\035\032\004\030\0010\016X\016¢\006\002\n\000R\020\020\036\032\004\030\0010\016X\016¢\006\002\n\000R\021\020\037\032\0020 ¢\006\b\n\000\032\004\b!\020\"R\021\020#\032\0020 ¢\006\b\n\000\032\004\b$\020\"R\021\020%\032\0020\024¢\006\b\n\000\032\004\b&\020'R\016\020(\032\0020 X\004¢\006\002\n\000R\032\020)\032\0020\004X\016¢\006\016\n\000\032\004\b*\020\006\"\004\b+\020\bR\021\020,\032\0020 ¢\006\b\n\000\032\004\b-\020\"R\020\020.\032\004\030\0010\016X\016¢\006\002\n\000R\024\020/\032\00200XD¢\006\b\n\000\032\004\b1\0202R\016\0203\032\00204X\004¢\006\002\n\000R\026\0205\032\004\030\0010\0138VX\004¢\006\006\032\004\b6\0207R\020\0208\032\004\030\0010\016X\016¢\006\002\n\000¨\006O"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/LogoFix;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "b", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getB", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "setB", "(Lnet/ccbluex/liquidbounce/value/IntegerValue;)V", "bottomLeftText", "", "", "clientColors", "", "Ljava/awt/Color;", "getClientColors", "()[Ljava/awt/Color;", "clientName", "Lnet/ccbluex/liquidbounce/value/TextValue;", "colorMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "firstColor", "kotlin.jvm.PlatformType", "fourthColor", "g", "getG", "setG", "gradientColor1", "gradientColor2", "gradientColor3", "gradientColor4", "hueInterpolation", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getHueInterpolation", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "infoValue", "getInfoValue", "logoValue", "getLogoValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "novoshadow", "r", "getR", "setR", "sColors", "getSColors", "secondColor", "shadowNoCutValue", "", "getShadowNoCutValue", "()Z", "shadowValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "getTag", "()Ljava/lang/String;", "thirdColor", "calculateBPS", "", "drawInfo", "", "([Ljava/awt/Color;)V", "getAlternateClientColor", "getClientColor", "getColor", "color", "", "getColorAtIndex", "i", "getFadeProgress", "", "mixColors", "color1", "color2", "onRender2D", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onShader", "Lnet/ccbluex/liquidbounce/event/ShaderEvent;", "XSJClient"})
/*     */ public final class LogoFix
/*     */   extends Module
/*     */ {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class LogoFix$onRender2D$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 374 */       GL11.glPushMatrix();
/* 375 */       GL11.glTranslated(6.0D, false, 0.0D);
/* 376 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 377 */       RoundedUtil.newdrawGradientRounde(0.0F, 5.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + Fonts.SF.SF_16.SF_16.stringWidth(" | " + (String)this.$username.element + " | " + (String)this.$servername.element + " | " + this.$times + " | " + (String)this.$fps.element)) + 3.0F + 5.0F, 12.0F, 4.0F, DrRenderUtils.applyOpacity(this.$gradientColor4, 1.0F), this.$gradientColor1, this.$gradientColor3, this.$gradientColor2);
/* 378 */       GL11.glPopMatrix();
/*     */     } LogoFix$onRender2D$1(Ref.ObjectRef param1ObjectRef1, Ref.ObjectRef param1ObjectRef2, String param1String, Ref.ObjectRef param1ObjectRef3, Color param1Color1, Color param1Color2, Color param1Color3, Color param1Color4) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class LogoFix$onRender2D$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 381 */       if (!LogoFix.this.getShadowNoCutValue()) {
/* 382 */         GL11.glPushMatrix();
/* 383 */         GL11.glTranslated(false, false, 0.0D);
/* 384 */         GlStateManager.func_179120_a(770, 771, 1, 0);
/* 385 */         RoundedUtil.newdrawGradientRounde(6.0F, 5.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + Fonts.SF.SF_16.SF_16.stringWidth(" | " + (String)this.$username.element + " | " + (String)this.$servername.element + " | " + this.$times + " | " + (String)this.$fps.element)) + 3.0F + 5.0F, 12.0F, 4.0F, DrRenderUtils.applyOpacity(this.$gradientColor4, 1.0F), this.$gradientColor1, this.$gradientColor3, this.$gradientColor2);
/* 386 */         GL11.glPopMatrix();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     LogoFix$onRender2D$2(Ref.ObjectRef param1ObjectRef1, Ref.ObjectRef param1ObjectRef2, String param1String, Ref.ObjectRef param1ObjectRef3, Color param1Color1, Color param1Color2, Color param1Color3, Color param1Color4) {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class LogoFix$onRender2D$4
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     LogoFix$onRender2D$4(Ref.ObjectRef param1ObjectRef1, Ref.ObjectRef param1ObjectRef2, String param1String, Ref.ObjectRef param1ObjectRef3) {
/*     */       super(0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void invoke() {
/* 415 */       GL11.glPushMatrix();
/* 416 */       GL11.glTranslated(6.0D, false, 0.0D);
/* 417 */       Fonts.SF.SF_16.SF_16.drawString(
/* 418 */           "| " + (String)this.$username.element + " | " + (String)this.$servername.element + " | " + this.$times + " | " + (String)this.$fps.element, 
/* 419 */           Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + 11 - 5, 
/* 420 */           9, 
/* 421 */           -1);
/*     */       
/* 423 */       GL11.glPopMatrix();
/* 424 */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class LogoFix$onRender2D$5 extends Lambda implements Function0<Unit> { public static final LogoFix$onRender2D$5 INSTANCE = new LogoFix$onRender2D$5(); public final void invoke() {} LogoFix$onRender2D$5() { super(0); } } @NotNull private final ListValue logoValue = new ListValue("Logo", new String[] { "New", "Outline", "Onlooker", "Neverlose", "Neverlose2", "Fluger", "Retreat", "Novoline", "Jello" }, "Neverlose2"); @NotNull public final ListValue getLogoValue() { return this.logoValue; } private final ListValue colorMode = new ListValue("LogoColorMode", new String[] { "Rainbow", "Light Rainbow", "Gident" }, "Gident"); private final TextValue clientName = new TextValue("ClientName", "XSJ Sense"); @NotNull private final BoolValue infoValue = new BoolValue("Info", true); @NotNull public final BoolValue getInfoValue() { return this.infoValue; } @NotNull private final BoolValue sColors = new BoolValue("Colors", true); @NotNull public final BoolValue getSColors() { return this.sColors; } @NotNull private final BoolValue hueInterpolation = new BoolValue("hueInterpolation", false); @NotNull public final BoolValue getHueInterpolation() { return this.hueInterpolation; } private final BoolValue novoshadow = new BoolValue("Shadow", true); private final FloatValue shadowValue = new FloatValue("ShadowStrength", 10.0F, 0.0F, 20.0F); @NotNull private IntegerValue r = new IntegerValue("r", 160, 0, 255); @NotNull public final IntegerValue getR() { return this.r; } public final void setR(@NotNull IntegerValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.r = <set-?>; } @NotNull private IntegerValue g = new IntegerValue("b", 50, 0, 255); @NotNull public final IntegerValue getG() { return this.g; } public final void setG(@NotNull IntegerValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.g = <set-?>; } @EventTarget public final void onRender2D(@Nullable Render2DEvent event) { int sigmaY = 4; int sigmaX = 8; Color[] clientColors = getClientColors(); String str = (String)this.logoValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 1098373575: if (str.equals("retreat")) { if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hudMod = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class); Color gradientColor1 = RenderUtils.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue()); Color gradientColor2 = RenderUtils.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue()); Color gradientColor3 = RenderUtils.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue()); Color gradientColor4 = RenderUtils.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)hudMod.getHueInterpolation().get()).booleanValue()); Ref.ObjectRef objectRef1 = new Ref.ObjectRef(); objectRef1.element = MinecraftInstance.mc.getSession().getUsername(); Ref.ObjectRef objectRef2 = new Ref.ObjectRef(); objectRef2.element = ServerUtils.getRemoteIp(); Ref.ObjectRef objectRef3 = new Ref.ObjectRef(); objectRef3.element = String.valueOf(Minecraft.func_175610_ah()) + "fps"; Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); if (((Boolean)this.novoshadow.get()).booleanValue()) { GL11.glTranslated(-0.0F, -0.0F, 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new LogoFix$onRender2D$1(objectRef1, objectRef2, times, objectRef3, gradientColor4, gradientColor1, gradientColor3, gradientColor2), new LogoFix$onRender2D$2(objectRef1, objectRef2, times, objectRef3, gradientColor4, gradientColor1, gradientColor3, gradientColor2)); GL11.glPopMatrix(); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glTranslated(false, false, 0.0D); }  RoundedUtil.drawRound(6.0F, 5.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + Fonts.SF.SF_16.SF_16.stringWidth(" | " + (String)objectRef1.element + " | " + (String)objectRef2.element + " | " + times + " | " + (String)objectRef3.element)) + 3.0F + 5.0F, 12.0F, 4.0F, new Color(0, 0, 0, 210)); GlStateManager.func_179117_G(); GradientUtil.applyGradientHorizontal(9.0F, 9.0F, FontLoaders.SF16.getStringWidth((String)this.clientName.get()), 20.0F, 1.0F, clientColors[1], clientColors[0], new LogoFix$onRender2D$3()); GlStateManager.func_179117_G(); Fonts.SF.SF_16.SF_16.drawString("| " + (String)objectRef1.element + " | " + (String)objectRef2.element + " | " + times + " | " + (String)objectRef3.element, Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + 11, 9, -1); GL11.glTranslated(-0.0F, -0.0F, 0.0D); GL11.glPushMatrix(); ShadowUtils.shadow(5.0F, new LogoFix$onRender2D$4(objectRef1, objectRef2, times, objectRef3), LogoFix$onRender2D$5.INSTANCE);
/* 425 */           GL11.glPopMatrix();
/* 426 */           GL11.glTranslated(false, false, 0.0D); }  break;
/*     */       case -969905247:
/* 428 */         if (str.equals("neverlose")) {
/* 429 */           String username = MinecraftInstance.mc.getSession().getUsername();
/* 430 */           String servername = ServerUtils.getRemoteIp();
/* 431 */           String fps = String.valueOf(Minecraft.func_175610_ah()) + "fps";
/* 432 */           Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime());
/*     */           
/* 434 */           RoundedUtil.drawRound(6.0F, 5.0F, (
/* 435 */               Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + 
/* 436 */               Fonts.SF.SF_16.SF_16.stringWidth(" | " + username + " | " + servername + " | " + times + " | " + fps)) + 
/* 437 */               3.0F + 5.0F, 12.0F, 2.0F, 
/* 438 */               new Color(0, 0, 0, 100));
/*     */           
/* 440 */           GlStateManager.func_179117_G();
/*     */           
/* 442 */           Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString(
/* 443 */               "Retreat", 
/* 444 */               9, 
/* 445 */               7, (
/* 446 */               new Color(24, 114, 165)).getRGB());
/*     */           
/* 448 */           Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString("Retreat", 8, 7, -1);
/* 449 */           Fonts.SF.SF_16.SF_16.drawString(
/* 450 */               " | " + username + " | " + servername + " | " + times + " | " + fps, 
/* 451 */               Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + 11, 
/* 452 */               8, 
/* 453 */               -1);
/*     */         }  break;
/*     */       case 108960:
/* 456 */         if (str.equals("new")) {
/* 457 */           GradientUtil.applyGradientHorizontal(5.0F, 5.0F, 
/* 458 */               FontLoaders.T40.getStringWidth((String)this.clientName.get()), 20.0F, 1.0F, clientColors[0], clientColors[1], new LogoFix$onRender2D$6());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 464 */           GlStateManager.func_179117_G();
/* 465 */           FontLoaders.T18.drawString("v2.3 New Year's Special Edition", (FontLoaders.T40.getStringWidth((String)this.clientName.get()) + 4), 5.0F, 
/* 466 */               clientColors[1].getRGB());
/*     */         } 
/*     */         break;
/*     */       case 101009364:
/* 470 */         if (str.equals("jello")) {
/* 471 */           Intrinsics.checkExpressionValueIsNotNull(FontLoaders.jellolight18, "FontLoaders.jellolight18"); CFontRenderer fr = FontLoaders.jellolight18;
/*     */           
/* 473 */           RenderUtils.drawShadowImage(
/* 474 */               sigmaX - 12 - fr.getStringWidth("Retreat") / 2 - 8, 
/* 475 */               sigmaY + 1, 
/* 476 */               125, 
/* 477 */               50, 
/* 478 */               new ResourceLocation("tomk/shadow/arraylistshadow.png"));
/*     */           
/* 480 */           GlStateManager.func_179117_G();
/* 481 */           FontLoaders.jellolightBig.drawString("Retreat", 8.0F, 5.0F, (new Color(255, 255, 255, 130)).getRGB());
/* 482 */           FontLoaders.jellolight18.drawCenteredString(
/* 483 */               "Jello", 
/* 484 */               18.0D, 
/* 485 */               32.0D, (
/* 486 */               new Color(255, 255, 255, 170)).getRGB());
/*     */         } 
/*     */         break;
/*     */       case 1648341806:
/* 490 */         if (str.equals("novoline"))
/* 491 */         { int[] counter = { 0 };
/* 492 */           String username = MinecraftInstance.mc.getSession().getUsername();
/* 493 */           String servername = ServerUtils.getRemoteIp();
/* 494 */           String fps = String.valueOf(Minecraft.func_175610_ah()) + "fps";
/* 495 */           Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime());
/* 496 */           int x1 = Fonts.SF.SF_16.SF_16.stringWidth("| ") + 1;
/* 497 */           int x2 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(username)) + 3;
/* 498 */           int x3 = Fonts.SF.SF_16.SF_16.stringWidth("|") + 3;
/* 499 */           int x4 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(servername)) - 1;
/* 500 */           int x5 = Fonts.SF.SF_16.SF_16.stringWidth("|") + 3;
/* 501 */           int x6 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(times)) + 6;
/* 502 */           int x7 = Fonts.SF.SF_16.SF_16.stringWidth("|") + 2;
/* 503 */           int x8 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(fps)) + 3;
/* 504 */           RenderUtils.drawRoundedRect2(6.0F, 5.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + 
/* 505 */               x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8) + 7.0F, 12.0F, 0.0F, (new Color(0, 0, 0, 100)).getRGB());
/* 506 */           int startX = 6;
/* 507 */           byte b = 0; int i = ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() - 1; if (b <= i)
/* 508 */             while (true) { double barStart = startX + b / ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() * ((Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8) + 7.0F);
/* 509 */               double barEnd = startX + (b + 1) / ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() * ((Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8) + 7.0F);
/* 510 */               RenderUtils.drawGradientSideways(barStart, 4, false + barEnd, 5.0D, getColorAtIndex(b), getColorAtIndex(b + 1)); if (b != i) { b++; continue; }
/*     */                break; }
/* 512 */               GradientUtil.applyGradientHorizontal(9.0F, 9.0F, 
/* 513 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()), 20.0F, 1.0F, clientColors[1], clientColors[0], new LogoFix$onRender2D$7());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 521 */           GlStateManager.func_179117_G();
/*     */ 
/*     */           
/* 524 */           Fonts.SF.SF_16.SF_16.drawString(
/* 525 */               "|", 
/* 526 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + 11, 
/* 527 */               9, (new Color(100, 100, 100)).getRGB());
/*     */ 
/*     */           
/* 530 */           Fonts.SF.SF_16.SF_16.drawString(
/* 531 */               String.valueOf(username), 
/* 532 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + x1 + 11, 
/* 533 */               9, 
/* 534 */               -1);
/*     */ 
/*     */           
/* 537 */           Fonts.SF.SF_16.SF_16.drawString(
/* 538 */               "|", 
/* 539 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + x1 + x2 + 11, 
/* 540 */               9, (
/* 541 */               new Color(100, 100, 100)).getRGB());
/*     */ 
/*     */           
/* 544 */           Fonts.SF.SF_16.SF_16.drawString(
/* 545 */               String.valueOf(servername), 
/* 546 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + x1 + x2 + x3 + 11, 
/* 547 */               9, 
/* 548 */               -1);
/*     */ 
/*     */           
/* 551 */           Fonts.SF.SF_16.SF_16.drawString(
/* 552 */               "|", 
/* 553 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + x1 + x2 + x3 + x4 + 15, 
/* 554 */               9, (
/* 555 */               new Color(100, 100, 100)).getRGB());
/*     */ 
/*     */           
/* 558 */           Fonts.SF.SF_16.SF_16.drawString(
/* 559 */               String.valueOf(times), 
/* 560 */               Fonts.tenacitybold35.getStringWidth((String)this.clientName.get()) + x1 + x2 + x3 + x4 + x5 + 11, 
/* 561 */               9, 
/* 562 */               -1);
/*     */ 
/*     */           
/* 565 */           Fonts.SF.SF_16.SF_16.drawString(
/* 566 */               "|", 
/* 567 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + x1 + x2 + x3 + x4 + x5 + x6 + 11, 
/* 568 */               9, (
/* 569 */               new Color(100, 100, 100)).getRGB());
/*     */ 
/*     */           
/* 572 */           Fonts.SF.SF_16.SF_16.drawString(
/* 573 */               String.valueOf(fps), 
/* 574 */               FontLoaders.SF16.getStringWidth((String)this.clientName.get()) + x1 + x2 + x3 + x4 + x5 + x6 + x7 + 11, 
/* 575 */               9, 
/* 576 */               -1);
/*     */           
/* 578 */           GlStateManager.func_179117_G(); }  break;case -1106245566: if (str.equals("outline")) { String username = MinecraftInstance.mc.getSession().getUsername(); String servername = ServerUtils.getRemoteIp(); String fps = String.valueOf(Minecraft.func_175610_ah()) + "fps"; Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); RoundedUtil.drawRound(4.7F, 6.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("XSJ") + Fonts.SF.SF_16.SF_16.stringWidth(" §8| §f" + username + " §8| §f" + servername + " §8| §f" + times + " §8| §f" + fps)) + 3.0F + 6.0F - 0.4F, 11.2F, 4.0F, new Color(0, 0, 0, 50)); GlStateManager.func_179117_G(); Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString("XSJ", 6, 8, -1); Fonts.SF.SF_16.SF_16.drawString(" §8| §f" + username + " §8| §f" + servername + " §8| §f" + times + " §8| §f" + fps, Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("XSJ") + 9, 9, -1); ScaleUtils.drawOutline2(8.0F, 5.1F, Fonts.SF.SF_16.SF_16.stringWidth(" §8| §f" + username + " §8| §f" + servername + " §8| §f" + times + " §8| §f" + fps) + 85.0F, 9.2F, 4.0F, 2.4F, -2.0F); }  break;case -1271465851: if (str.equals("fluger")) { int animationA = 0; boolean animate = false; float xA = 10.0F; float yA = 10.0F; float heightA = 10.0F; Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String str1 = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); String str2 = MinecraftInstance.mc.getSession().getUsername(); String str3 = "XSJ | Time: " + str1 + " | User: " + str2; int textWidth = Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth(str3); float widthA = (textWidth + 11); int xe = 0; animationA++; if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null)
/*     */             throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  HUD hud = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class); this.gradientColor1 = RenderUtils.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)hud.getHueInterpolation().get()).booleanValue()); this.gradientColor2 = RenderUtils.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)hud.getHueInterpolation().get()).booleanValue()); this.gradientColor3 = RenderUtils.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)hud.getHueInterpolation().get()).booleanValue()); this.gradientColor4 = RenderUtils.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)hud.getHueInterpolation().get()).booleanValue()); int i = MathUtils.clamp_int(animationA, 0, 255); RoundedUtil.drawGradientRound(xA, yA, widthA, heightA, 4.0F, DrRenderUtils.applyOpacity(this.gradientColor4, 0.85F), this.gradientColor1, this.gradientColor3, this.gradientColor2); GlStateManager.func_179117_G(); Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString(str3, xA + 5.0F, yA + 2.5F, -1); }  break;
/*     */       case -2291535: if (str.equals("neverlose2")) { Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String str1 = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); int i = Fonts.Newuiicon.Newuiicon116.Newuiicon116.stringWidth("d") + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(MinecraftInstance.mc2.func_110432_I().func_111285_a()); int xee = i + FontLoaders.ICON18.getStringWidth("Q") + 5; if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  int xeee = xee + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(String.valueOf(EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()))) + 3; int xeeee = xeee + FontLoaders.ICONS18.getStringWidth("f") + 4; int j = xeeee + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(String.valueOf(Minecraft.func_175610_ah())) + 2; int k = j + FontLoaders.HICONS18.getStringWidth("B") - 1; int m = k + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(str1) + 20; RoundedUtil.drawRound(6.0F, 5.0F, 48.0F, 15.0F, 5.0F, new Color(0, 20, 40, 215)); Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString("XSJ", 9, 10, (new Color(24, 114, 165)).getRGB()); Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.drawString("XSJ", 8, 10, -1); RoundedUtil.drawRound(60.0F, 5.0F, 8 + m, 15.0F, 5.0F, new Color(0, 20, 40, 215)); Fonts.Newuiicon.Newuiicon116.Newuiicon116.drawString("d", 62, (int)11.5D, (new Color(6, 180, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.drawString(MinecraftInstance.mc2.func_110432_I().func_111285_a(), 72, (int)11.5D, (new Color(255, 255, 255)).getRGB()); FontLoaders.ICON18.drawString("Q", 69.5F + i, 10.8F, (new Color(6, 180, 255)).getRGB()); if (MinecraftInstance.mc.getThePlayer() == null)
/* 582 */             Intrinsics.throwNpe();  Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.drawString(String.valueOf(EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer())) + " ms", 67 + xee, (int)11.5D, (new Color(255, 255, 255)).getRGB()); FontLoaders.ICONS18.drawString("f", 80.0F + xeee, 11.0F, (new Color(6, 180, 255)).getRGB()); Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.drawString(String.valueOf(Minecraft.func_175610_ah()), 79 + xeeee, (int)11.5D, (new Color(255, 255, 255)).getRGB()); FontLoaders.HICONS18.drawString("B", 80.1F + j, 11.0F, (new Color(6, 180, 255)).getRGB()); Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.drawString(str1, 83 + k, (int)11.5D, (new Color(255, 255, 255)).getRGB()); GlStateManager.func_179117_G(); }  break; }  if (((Boolean)this.infoValue.get()).booleanValue())
/* 583 */       drawInfo(clientColors);  }
/*     */   @NotNull private IntegerValue b = new IntegerValue("g", 255, 0, 255);
/*     */   @NotNull public final IntegerValue getB() { return this.b; }
/*     */   public final void setB(@NotNull IntegerValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/* 587 */     this.b = <set-?>; } private final Map<String, String> bottomLeftText = new LinkedHashMap<>(); private Color gradientColor1 = Color.WHITE; private Color gradientColor2 = Color.WHITE; private Color gradientColor3 = Color.WHITE; private Color gradientColor4 = Color.WHITE; private final boolean shadowNoCutValue = true; public final boolean getShadowNoCutValue() { return this.shadowNoCutValue; } private Color firstColor = Color.BLACK; private final Color mixColors(Color color1, Color color2) { if (((Boolean)this.sColors.get()).booleanValue())
/* 588 */     { Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorsBackAndForth(
/* 589 */             15, 
/* 590 */             1, 
/* 591 */             color1, 
/* 592 */             color2, (
/* 593 */             (Boolean)this.hueInterpolation.get()).booleanValue()), "ColorUtil.interpolateCol…ation.get()\n            )"); }
/*     */     else
/*     */     
/* 596 */     { Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorC(color1, color2, 0.0F), "ColorUtil.interpolateColorC(color1, color2, 0F)"); }  return ColorUtil.interpolateColorC(color1, color2, 0.0F); } private Color secondColor = Color.BLACK; private Color thirdColor = Color.BLACK; private Color fourthColor = Color.BLACK; @EventTarget public final void onShader(@Nullable ShaderEvent event) { this.firstColor = ColorUtil.interpolateColorsBackAndForth(15, 0, getClientColor(), getAlternateClientColor(), ((Boolean)this.hueInterpolation.get()).booleanValue()); this.secondColor = ColorUtil.interpolateColorsBackAndForth(15, 90, getClientColor(), getAlternateClientColor(), ((Boolean)this.hueInterpolation.get()).booleanValue()); this.thirdColor = ColorUtil.interpolateColorsBackAndForth(15, 180, getClientColor(), getAlternateClientColor(), ((Boolean)this.hueInterpolation.get()).booleanValue()); this.fourthColor = ColorUtil.interpolateColorsBackAndForth(15, 270, getClientColor(), getAlternateClientColor(), ((Boolean)this.hueInterpolation.get()).booleanValue()); String str = (String)this.logoValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -969905247: if (str.equals("neverlose")) { String username = MinecraftInstance.mc.getSession().getUsername(); String servername = ServerUtils.getRemoteIp(); String fps = String.valueOf(Minecraft.func_175610_ah()) + "fps"; Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); RenderUtils.drawRoundedRect2(6.0F, 5.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + Fonts.SF.SF_16.SF_16.stringWidth(" | " + username + " | " + servername + " | " + times + " | " + fps)) + 3.0F + 5.0F, 12.0F, 2.0F, (new Color(0, 0, 0)).getRGB()); GlStateManager.func_179117_G(); }  break;case 1648341806: if (str.equals("novoline")) { String username = MinecraftInstance.mc.getSession().getUsername(); String servername = ServerUtils.getRemoteIp(); String fps = String.valueOf(Minecraft.func_175610_ah()) + "fps"; Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); int x1 = Fonts.SF.SF_16.SF_16.stringWidth("| ") + 1; int x2 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(username)) + 3; int x3 = Fonts.SF.SF_16.SF_16.stringWidth("|") + 3; int x4 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(servername)) - 1; int x5 = Fonts.SF.SF_16.SF_16.stringWidth("|") + 3; int x6 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(times)) + 6; int x7 = Fonts.SF.SF_16.SF_16.stringWidth("|") + 2; int x8 = Fonts.SF.SF_16.SF_16.stringWidth(String.valueOf(fps)) + 3; RenderUtils.drawRoundedRect2(6.0F, 5.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8) + 7.0F, 12.0F, 0.0F, (new Color(0, 0, 0)).getRGB()); GlStateManager.func_179117_G(); }  break;case 108960: if (str.equals("new")) { GradientUtil.applyGradientHorizontal(5.0F, 5.0F, FontLoaders.T40.getStringWidth((String)this.clientName.get()), 20.0F, 1.0F, getClientColors()[0], getClientColors()[1], new LogoFix$onShader$1()); GlStateManager.func_179117_G(); FontLoaders.T18.drawString("v2.3 New Year's Special Edition", (FontLoaders.T40.getStringWidth((String)this.clientName.get()) + 4), 5.0F, getClientColors()[1].getRGB()); }  break;case -1106245566: if (str.equals("outline")) { String username = MinecraftInstance.mc.getSession().getUsername(); String servername = ServerUtils.getRemoteIp(); String fps = String.valueOf(Minecraft.func_175610_ah()) + "fps"; Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String times = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); if (((Boolean)BlurSettings.logoGlow.get()).booleanValue()) { RoundedUtil.drawGradientRound(4.7F, 6.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + Fonts.SF.SF_16.SF_16.stringWidth(" §8| §f" + username + " §8| §f" + servername + " §8| §f" + times + " §8| §f" + fps)) + 3.0F + 6.0F - 0.4F, 11.2F, 4.0F, ColorUtil.applyOpacity(this.fourthColor, 1.0F), this.firstColor, this.secondColor, this.thirdColor); } else { RoundedUtil.drawRound(4.7F, 6.0F, (Fonts.SFBOLD.SFBOLD_18.SFBOLD_18.stringWidth("Retreat") + Fonts.SF.SF_16.SF_16.stringWidth(" §8| §f" + username + " §8| §f" + servername + " §8| §f" + times + " §8| §f" + fps)) + 3.0F + 6.0F - 0.4F, 11.2F, 4.0F, new Color(0, 0, 0)); }  GlStateManager.func_179117_G(); }  break;case -2291535: if (str.equals("neverlose2")) { Intrinsics.checkExpressionValueIsNotNull(Calendar.getInstance(), "Calendar.getInstance()"); String timeB = (new SimpleDateFormat("HH:mm")).format(Calendar.getInstance().getTime()); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); int xe = Fonts.Newuiicon.Newuiicon116.Newuiicon116.stringWidth("d") + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(MinecraftInstance.mc2.func_110432_I().func_111285_a()); int xee = xe + FontLoaders.ICON18.getStringWidth("Q") + 5; if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  int xeee = xee + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(String.valueOf(EntityUtils.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()))) + 3; int xeeee = xeee + FontLoaders.ICONS18.getStringWidth("f") + 4; int xeees = xeeee + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(String.valueOf(Minecraft.func_175610_ah())) + 2; int xeeess = xeees + FontLoaders.HICONS18.getStringWidth("B") - 1; int x = xeeess + Fonts.SFBOLD.SFBOLD_15.SFBOLD_15.stringWidth(timeB) + 20; RenderUtils.drawRoundedRect2(6.0F, 5.0F, 48.0F, 15.0F, 6.0F, (new Color(0, 0, 0)).getRGB()); GlStateManager.func_179117_G(); RenderUtils.drawRoundedRect2(60.0F, 5.0F, 8 + x, 15.0F, 6.0F, (new Color(0, 0, 0)).getRGB()); GlStateManager.func_179117_G(); }  break; }  if (((Boolean)this.infoValue.get()).booleanValue()) drawInfo(getClientColors());  } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class LogoFix$onShader$1 implements Runnable {
/*     */     public final void run() { RenderUtils.setAlphaLimit(0.0F); BloomUtil.drawAndBloom(new RenderCallback() { public final void render() { FontLoaders.T40.drawStringWithShadow((String)LogoFix.this.clientName.get(), 5.0D, 5.0D, (new Color(0, 0, 0, 0)).getRGB()); } }); } } private final void drawInfo(Color[] clientColors) { ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x()); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.bottomLeftText.put("XYZ:", String.valueOf(MathKt.roundToLong(MinecraftInstance.mc.getThePlayer().getPosX())) + " " + MathKt.roundToLong(MinecraftInstance.mc.getThePlayer().getPosY()) + " " + MathKt.roundToLong(MinecraftInstance.mc.getThePlayer().getPosZ())); this.bottomLeftText.put("Speed:", String.valueOf(calculateBPS())); this.bottomLeftText.put("FPS:", String.valueOf(Minecraft.func_175610_ah())); float yOffset = false; Intrinsics.checkExpressionValueIsNotNull(FontLoaders.SF18, "FontLoaders.SF18"); float height = ((FontLoaders.SF18.getHeight() + 2) * this.bottomLeftText.keySet().size()); float width = FontLoaders.SF18.getStringWidth("XYZ:"); GradientUtil.applyGradientVertical(2.0F, sr.func_78328_b() - height + yOffset, width, height, 1.0F, clientColors[0], clientColors[1], new LogoFix$drawInfo$1(yOffset, sr)); StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE; String str1 = "XSJ Client-v2.3 New Year's Special Edition"; Object[] arrayOfObject = new Object[0]; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(format, *args)"); String text = String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); Intrinsics.checkExpressionValueIsNotNull(FontLoaders.SF18, "FontLoaders.SF18"); GradientUtil.applyGradientHorizontal((MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledWidth() - FontLoaders.SF18.getStringWidth(text) - 1), (MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledHeight() - FontLoaders.SF18.getHeight() - 1), FontLoaders.SF18.getStringWidth(text), 9.0F, 1.0F, clientColors[0], clientColors[1], new LogoFix$drawInfo$2(text)); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class LogoFix$drawInfo$1 implements Runnable {
/*     */     public final void run() { RenderUtils.setAlphaLimit(0.0F); Ref.FloatRef floatRef = new Ref.FloatRef(); Intrinsics.checkExpressionValueIsNotNull(FontLoaders.SF18, "FontLoaders.SF18"); floatRef.element = (FontLoaders.SF18.getHeight() + 2) + this.$yOffset; Iterator<Map.Entry> iterator; Map map; boolean bool; for (map = LogoFix.this.bottomLeftText, bool = false, iterator = map.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry entry1 = iterator.next(), entry2 = entry1; boolean bool1 = false; String str1 = (String)entry2.getKey(); entry2 = entry1; bool1 = false; String value = (String)entry2.getValue(); BloomUtil.drawAndBloom(new RenderCallback(str1, value, floatRef) { public final void render() { FontLoaders.SF18.drawString(this.$key + this.$value, 2.0F, LogoFix$drawInfo$1.this.$sr.func_78328_b() - this.$boldFontMovement.element, -1); } }); Intrinsics.checkExpressionValueIsNotNull(FontLoaders.SF18, "FontLoaders.SF18"); floatRef.element += (FontLoaders.SF18.getHeight() + 2); }  } LogoFix$drawInfo$1(float param1Float, ScaledResolution param1ScaledResolution) {} } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class LogoFix$drawInfo$2 implements Runnable {
/*     */     public final void run() { RenderUtils.setAlphaLimit(0.0F); BloomUtil.drawAndBloom(new RenderCallback() { public final void render() { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); Intrinsics.checkExpressionValueIsNotNull(FontLoaders.SF18, "FontLoaders.SF18"); FontLoaders.SF18.drawString(LogoFix$drawInfo$2.this.$text, (float)(MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledWidth() - FontLoaders.SF18.getStringWidth(LogoFix$drawInfo$2.this.$text) - 1), (float)(MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc).getScaledHeight() - FontLoaders.SF18.getHeight() - 1), -1); } }); } LogoFix$drawInfo$2(String param1String) {} } private final double calculateBPS() { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX(); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d2 = MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ(); boolean bool = false; double bps = Math.hypot(d1, d2) * MinecraftInstance.mc.getTimer().getTimerSpeed() * 20; return MathKt.roundToLong(bps * 100.0D) / 100.0D; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class LogoFix$onRender2D$3 implements Runnable {
/*     */     public final void run() { RenderUtils.setAlphaLimit(0.0F); BloomUtil.drawAndBloom(new RenderCallback() { public final void render() { FontLoaders.SF16.drawStringWithShadow((String)LogoFix.this.clientName.get(), 9.0D, 9.0D, (new Color(0, 0, 0, 0)).getRGB()); } }); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class LogoFix$onRender2D$6 implements Runnable {
/* 601 */     public final void run() { RenderUtils.setAlphaLimit(0.0F); BloomUtil.drawAndBloom(new RenderCallback() { public final void render() { FontLoaders.T40.drawStringWithShadow2((String)LogoFix.this.clientName.get(), 5.0D, 5.0D, (new Color(0, 0, 0, 0)).getRGB()); } }); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class LogoFix$onRender2D$7 implements Runnable { public final void run() { RenderUtils.setAlphaLimit(0.0F); BloomUtil.drawAndBloom(new RenderCallback() { public final void render() { FontLoaders.SF16.drawStringWithShadow((String)LogoFix.this.clientName.get(), 9.0D, 9.0D, (new Color(0, 0, 0, 0)).getRGB()); } }); } } @NotNull public final Color getClientColor() { return new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()); }
/*     */   
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor() {
/* 605 */     return new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue());
/*     */   } @NotNull
/*     */   public final Color[] getClientColors() {
/* 608 */     Color firstColor = null;
/* 609 */     Color secondColor = null;
/* 610 */     String str = (String)this.colorMode.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 1378677932:
/* 611 */         if (str.equals("light rainbow"))
/* 612 */         { Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 1, 0.6F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 1, .6f, 1f, 1f)"); firstColor = ColorUtil.rainbow(15, 1, 0.6F, 1.0F, 1.0F);
/* 613 */           Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 40, 0.6F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 40, .6f, 1f, 1f)"); secondColor = ColorUtil.rainbow(15, 40, 0.6F, 1.0F, 1.0F);
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
/* 631 */           return new Color[] { firstColor, secondColor }; }  break;case -1246115351: if (str.equals("gident")) { firstColor = mixColors(getClientColor(), getAlternateClientColor()); secondColor = mixColors(getAlternateClientColor(), getClientColor()); return new Color[] { firstColor, secondColor }; }  break;case 973576630: if (str.equals("rainbow")) { Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 1, 1.0F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 1, 1f, 1f, 1f)"); firstColor = ColorUtil.rainbow(15, 1, 1.0F, 1.0F, 1.0F); Intrinsics.checkExpressionValueIsNotNull(ColorUtil.rainbow(15, 40, 1.0F, 1.0F, 1.0F), "ColorUtil.rainbow(15, 40, 1f, 1f, 1f)"); secondColor = ColorUtil.rainbow(15, 40, 1.0F, 1.0F, 1.0F); return new Color[] { firstColor, secondColor }; }  break; }  firstColor = new Color(-1); secondColor = new Color(-1); return new Color[] { firstColor, secondColor };
/*     */   }
/* 633 */   public final float getFadeProgress() { return 0.0F; } @NotNull
/* 634 */   public final Color getColor(@NotNull Color color) { Intrinsics.checkParameterIsNotNull(color, "color"); return ColorUtils.reAlpha(color, color.getAlpha() / 255.0F * (1.0F - getFadeProgress())); } @NotNull
/* 635 */   public final Color getColor(int color) { return getColor(new Color(color)); }
/*     */    private final int getColorAtIndex(int i) {
/* 637 */     String str = (String)AColorPalette.colorModeValue.get(); switch (str.hashCode())
/*     */     { case 83201:
/* 639 */         if (str.equals("Sky")); break;case -1656737386: if (str.equals("Rainbow")); break;
/* 640 */       case -1815582866: if (str.equals("Slowly")) if (ColorUtils.LiquidSlowly(System.nanoTime(), i * ((Number)AColorPalette.Companion.getGradientDistanceValue().get()).intValue(), ((Number)AColorPalette.Companion.getSaturationValue().get()).floatValue(), ((Number)AColorPalette.Companion.getBrightnessValue().get()).floatValue()) == null) Intrinsics.throwNpe();   break;
/*     */       case 2132719113:
/* 642 */         if (str.equals("Gident")) Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), (
/* 643 */                   (Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / (
/* 644 */                   (Number)AColorPalette.gradientSpeed.get()).intValue() + (i * ((Number)AColorPalette.Companion.getGradientDistanceValue().get()).intValue())) / 10), "RenderUtils.getGradientO…stanceValue.get()) / 10))");  break;
/* 645 */       case 2181788: if (str.equals("Fade")); break; }  return getColor(-1).getRGB();
/*     */   }
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public String getTag() {
/* 651 */     return (String)this.logoValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\LogoFix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */