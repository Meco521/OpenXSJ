/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import kotlin.Unit;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.AutoL;
/*     */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.CPSCounter;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "SessionInfo2")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\013\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\n\020\034\032\004\030\0010\035H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\016\020\022\032\0020\013X\004¢\006\002\n\000R\021\020\023\032\0020\021¢\006\b\n\000\032\004\b\024\020\025R\021\020\026\032\0020\013¢\006\b\n\000\032\004\b\027\020\030R\021\020\031\032\0020\017¢\006\b\n\000\032\004\b\032\020\033¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/SessionInfo2;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "BlurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blur", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "mode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "radiusValue", "shadowColorMode", "getShadowColorMode", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "shadowValue", "getShadowValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "shadowValueopen", "getShadowValueopen", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class SessionInfo2 extends Element {
/*     */   private final ListValue mode;
/*     */   private final BoolValue blur;
/*     */   private final FloatValue BlurStrength;
/*     */   private final IntegerValue bgValue;
/*     */   @NotNull
/*     */   private final BoolValue shadowValueopen;
/*     */   @NotNull
/*     */   private final FloatValue shadowValue;
/*     */   @NotNull
/*     */   private final ListValue shadowColorMode;
/*     */   private final FloatValue radiusValue;
/*     */   
/*     */   public SessionInfo2(double x, double y, float scale, @NotNull Side side) {
/*  32 */     super(x, y, scale, side);
/*  33 */     this.mode = new ListValue("mode", new String[] { "EN", "CN" }, "EN");
/*  34 */     this.blur = new BoolValue("Blur", true);
/*  35 */     this.BlurStrength = new FloatValue("BlurStrength", 2.0F, 0.0F, 20.0F);
/*  36 */     this.bgValue = new IntegerValue("ground-Alpha", 220, 0, 255);
/*  37 */     this.shadowValueopen = new BoolValue("shadow", true);
/*  38 */     this.shadowValue = new FloatValue("shadow-Value", 10.0F, 0.0F, 20.0F);
/*  39 */     this.shadowColorMode = new ListValue("Shadow-Color", new String[] { "Background", "Custom" }, "Background");
/*  40 */     this.radiusValue = new FloatValue("Radius", 3.1F, 0.0F, 10.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class SessionInfo2$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/*  70 */       GL11.glPushMatrix();
/*  71 */       GL11.glTranslated(SessionInfo2.this.getRenderX(), SessionInfo2.this.getRenderY(), 0.0D);
/*  72 */       GL11.glScalef(SessionInfo2.this.getScale(), SessionInfo2.this.getScale(), SessionInfo2.this.getScale());
/*     */       
/*  74 */       RenderUtils.originalRoundedRect(
/*  75 */           -5.0F, 1.0F, 180.0F, 83.0F, ((Number)SessionInfo2.this.radiusValue.get()).floatValue(), 
/*  76 */           StringsKt.equals((String)SessionInfo2.this.getShadowColorMode().get(), "background", true) ? (
/*  77 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/*  79 */           new Color(0, 0, 0)).getRGB());
/*     */       
/*  81 */       GL11.glPopMatrix();
/*     */     } SessionInfo2$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  83 */   static final class SessionInfo2$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix();
/*  84 */       GL11.glTranslated(SessionInfo2.this.getRenderX(), SessionInfo2.this.getRenderY(), 0.0D);
/*  85 */       GL11.glScalef(SessionInfo2.this.getScale(), SessionInfo2.this.getScale(), SessionInfo2.this.getScale());
/*  86 */       GlStateManager.func_179147_l();
/*  87 */       GlStateManager.func_179090_x();
/*  88 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*  89 */       RenderUtils.fastRoundedRect(-5.0F, 1.0F, 180.0F, 83.0F, ((Number)SessionInfo2.this.radiusValue.get()).floatValue());
/*  90 */       GlStateManager.func_179098_w();
/*  91 */       GlStateManager.func_179084_k();
/*  92 */       GL11.glPopMatrix(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SessionInfo2$drawElement$2() {
/*     */       super(0);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class SessionInfo2$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 193 */       GL11.glPushMatrix();
/* 194 */       GL11.glTranslated(SessionInfo2.this.getRenderX(), SessionInfo2.this.getRenderY(), 0.0D);
/* 195 */       GL11.glScalef(SessionInfo2.this.getScale(), SessionInfo2.this.getScale(), SessionInfo2.this.getScale());
/*     */       
/* 197 */       RenderUtils.originalRoundedRect(
/* 198 */           -5.0F, 1.0F, 180.0F, 83.0F, ((Number)SessionInfo2.this.radiusValue.get()).floatValue(), 
/* 199 */           StringsKt.equals((String)SessionInfo2.this.getShadowColorMode().get(), "background", true) ? (
/* 200 */           new Color(32, 30, 30)).getRGB() : (
/*     */           
/* 202 */           new Color(0, 0, 0)).getRGB());
/*     */       
/* 204 */       GL11.glPopMatrix();
/*     */     } SessionInfo2$drawElement$3() { super(0); }
/* 206 */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class SessionInfo2$drawElement$4 extends Lambda implements Function0<Unit> { SessionInfo2$drawElement$4() { super(0); } public final void invoke() { GL11.glPushMatrix();
/* 207 */       GL11.glTranslated(SessionInfo2.this.getRenderX(), SessionInfo2.this.getRenderY(), 0.0D);
/* 208 */       GL11.glScalef(SessionInfo2.this.getScale(), SessionInfo2.this.getScale(), SessionInfo2.this.getScale());
/* 209 */       GlStateManager.func_179147_l();
/* 210 */       GlStateManager.func_179090_x();
/* 211 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 212 */       RenderUtils.fastRoundedRect(-5.0F, 1.0F, 180.0F, 83.0F, ((Number)SessionInfo2.this.radiusValue.get()).floatValue());
/* 213 */       GlStateManager.func_179098_w();
/* 214 */       GlStateManager.func_179084_k();
/* 215 */       GL11.glPopMatrix(); } } @Nullable public Border drawElement() { if (StringsKt.equals((String)this.mode.get(), "EN", true)) { RenderUtils.drawRoundedRect(-5.0F, 1.0F, 180.0F, 16.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 32, ((Number)this.bgValue.get()).intValue())).getRGB()); RenderUtils.drawRoundedRect(-5.0F, 1.0F, 180.0F, 83.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 40, ((Number)this.bgValue.get()).intValue())).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); if (((Boolean)this.shadowValueopen.get()).booleanValue())
/*     */         ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new SessionInfo2$drawElement$1(), new SessionInfo2$drawElement$2());  GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); float x2 = 120.0F; if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class); SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss"); Fonts.posterama35.drawString("Played For:" + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), -3.0F, 17.0F, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("Kill:" + String.valueOf(autoL.kills()), -3, 28, (new Color(255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); Fonts.posterama35.drawString("User:" + MinecraftInstance.mc2.func_110432_I().func_111285_a(), -3, 39, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("ServerIp:" + ServerUtils.getRemoteIp(), -3, 50, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("Cps/Fps:" + String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT)) + "/" + String.valueOf(Minecraft.func_175610_ah()), -3, 61, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("My heart beats faster when I see you.", -3, 72, (new Color(255, 255, 255)).getRGB()); if (((Boolean)this.blur.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.CustomBlurRoundArea((float)getRenderX() - 5, (float)getRenderY() + true, 185.0F, 83.0F, ((Number)this.radiusValue.get()).floatValue(), 8.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  RenderUtils.drawRoundedRect(-5.0F, 1.0F, 180.0F, 16.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 32, ((Number)this.bgValue.get()).intValue())).getRGB()); RenderUtils.drawRoundedRect(-5.0F, 1.0F, 180.0F, 83.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 40, ((Number)this.bgValue.get()).intValue())).getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.posterama40.drawCenteredString("Session InFormation", 52.0F, 4.0F, Color.WHITE.getRGB()); Fonts.posterama35.drawString("Played For:" + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), -3.0F, 17.0F, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("Kill:" + String.valueOf(autoL.kills()), -3, 28, (new Color(255, 255, 255)).getRGB()); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); Fonts.posterama35.drawString("User:" + MinecraftInstance.mc2.func_110432_I().func_111285_a(), -3, 39, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("ServerIp:" + ServerUtils.getRemoteIp(), -3, 50, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("Cps/Fps:" + String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT)) + "/" + String.valueOf(Minecraft.func_175610_ah()), -3, 61, (new Color(255, 255, 255)).getRGB()); Fonts.posterama35.drawString("My heart beats faster when I see you.", -3, 72, (new Color(255, 255, 255)).getRGB()); }
/*     */      if (StringsKt.equals((String)this.mode.get(), "CN", true)) { RenderUtils.drawRoundedRect(-5.0F, 1.0F, 180.0F, 16.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 32, ((Number)this.bgValue.get()).intValue())).getRGB()); RenderUtils.drawRoundedRect(-5.0F, 1.0F, 180.0F, 83.0F, ((Number)this.radiusValue.get()).floatValue(), (new Color(0, 0, 40, ((Number)this.bgValue.get()).intValue())).getRGB()); GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); if (((Boolean)this.shadowValueopen.get()).booleanValue())
/* 219 */         ShadowUtils.shadow(((Number)this.shadowValue.get()).floatValue(), new SessionInfo2$drawElement$3(), new SessionInfo2$drawElement$4());  GL11.glPopMatrix();
/* 220 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 221 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */       
/* 223 */       float x2 = 120.0F;
/* 224 */       if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class);
/*     */       
/* 226 */       SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
/*     */ 
/*     */       
/* 229 */       FontLoaders.S20.drawString(
/* 230 */           "游玩时间:" + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 
/* 231 */           -3.0F, 
/* 232 */           17.0F, (
/* 233 */           new Color(255, 255, 255)).getRGB());
/*     */       
/* 235 */       FontLoaders.S20.drawString("人头数量:" + String.valueOf(autoL.kills()), -3, 28, (new Color(255, 255, 255)).getRGB());
/* 236 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); FontLoaders.S20.drawString("游戏名字:" + MinecraftInstance.mc2.func_110432_I().func_111285_a(), -3, 39, (new Color(255, 255, 255)).getRGB());
/* 237 */       FontLoaders.S20.drawString("服务器地址:" + ServerUtils.getRemoteIp(), -3, 50, (new Color(255, 255, 255)).getRGB());
/* 238 */       FontLoaders.S20.drawString(
/* 239 */           "点击速度/游戏帧率:" + String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT)) + "/" + 
/* 240 */           String.valueOf(Minecraft.func_175610_ah()), -3, 61, (new Color(255, 255, 255)).getRGB());
/*     */       
/* 242 */       FontLoaders.S20.drawString("当我看到你的时候我直接力了.", -3, 72, (new Color(255, 255, 255)).getRGB());
/* 243 */       if (((Boolean)this.blur.get()).booleanValue()) {
/* 244 */         GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 245 */         GL11.glPushMatrix();
/* 246 */         BlurBuffer.CustomBlurRoundArea(
/* 247 */             (float)getRenderX() - 5, 
/* 248 */             (float)getRenderY() + true, 
/* 249 */             185.0F, 
/* 250 */             83.0F, (
/* 251 */             (Number)this.radiusValue.get()).floatValue(), 8.0F);
/*     */         
/* 253 */         GL11.glPopMatrix();
/* 254 */         GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */       } 
/* 256 */       RenderUtils.drawRoundedRect(
/* 257 */           -5.0F, 
/* 258 */           1.0F, 
/* 259 */           180.0F, 
/* 260 */           16.0F, (
/* 261 */           (Number)this.radiusValue.get()).floatValue(), (
/* 262 */           new Color(0, 0, 32, ((Number)this.bgValue.get()).intValue())).getRGB());
/*     */ 
/*     */ 
/*     */       
/* 266 */       RenderUtils.drawRoundedRect(
/* 267 */           -5.0F, 
/* 268 */           1.0F, 
/* 269 */           180.0F, 
/* 270 */           83.0F, (
/* 271 */           (Number)this.radiusValue.get()).floatValue(), (
/* 272 */           new Color(0, 0, 40, ((Number)this.bgValue.get()).intValue())).getRGB());
/*     */       
/* 274 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.S22.drawCenteredString("游戏模式", 24.0D, 4.0D, Color.WHITE.getRGB());
/* 275 */       FontLoaders.S20.drawString(
/* 276 */           "游玩时间:" + DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)), 
/* 277 */           -3.0F, 
/* 278 */           17.0F, (
/* 279 */           new Color(255, 255, 255)).getRGB());
/*     */       
/* 281 */       FontLoaders.S20.drawString("人头数量:" + String.valueOf(autoL.kills()), -3, 28, (new Color(255, 255, 255)).getRGB());
/* 282 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_110432_I(), "mc2.getSession()"); FontLoaders.S20.drawString("游戏名字:" + MinecraftInstance.mc2.func_110432_I().func_111285_a(), -3, 39, (new Color(255, 255, 255)).getRGB());
/* 283 */       FontLoaders.S20.drawString("服务器地址:" + ServerUtils.getRemoteIp(), -3, 50, (new Color(255, 255, 255)).getRGB());
/* 284 */       FontLoaders.S20.drawString(
/* 285 */           "点击速度/游戏帧率:" + String.valueOf(CPSCounter.getCPS(CPSCounter.MouseButton.LEFT)) + "/" + 
/* 286 */           String.valueOf(Minecraft.func_175610_ah()), -3, 61, (new Color(255, 255, 255)).getRGB());
/*     */       
/* 288 */       FontLoaders.S20.drawString("当我看到你的时候我直接力了.", -3, 72, (new Color(255, 255, 255)).getRGB()); }
/*     */ 
/*     */     
/* 291 */     return new Border(-5.0F, 1.0F, 180.0F, 83.0F); }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public final BoolValue getShadowValueopen() {
/*     */     return this.shadowValueopen;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final FloatValue getShadowValue() {
/*     */     return this.shadowValue;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final ListValue getShadowColorMode() {
/*     */     return this.shadowColorMode;
/*     */   }
/*     */   
/*     */   public SessionInfo2() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\SessionInfo2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */