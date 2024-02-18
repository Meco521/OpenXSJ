/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import courage.render.DrawArc;
/*     */ import courage.utils.info.Recorder;
/*     */ import java.awt.Color;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.AutoL;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2;
/*     */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "GameInfo")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000D\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\002\b\r\n\002\030\002\n\002\b\005\n\002\030\002\n\000\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\020#\032\0020$H\026R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\tX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\032\020\017\032\0020\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\016\020\025\032\0020\016X\004¢\006\002\n\000R\016\020\026\032\0020\016X\004¢\006\002\n\000R\032\020\027\032\0020\020X\016¢\006\016\n\000\032\004\b\030\020\022\"\004\b\031\020\024R\016\020\032\032\0020\016X\004¢\006\002\n\000R\016\020\033\032\0020\tX\004¢\006\002\n\000R\016\020\034\032\0020\016X\004¢\006\002\n\000R\021\020\035\032\0020\036¢\006\b\n\000\032\004\b\037\020 R\021\020!\032\0020\036¢\006\b\n\000\032\004\b\"\020 ¨\006%"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/GameInfo;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "Outline", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "OutmodeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "bV", "bgValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "minute", "", "getMinute", "()J", "setMinute", "(J)V", "sa", "sb", "second", "getSecond", "setSecond", "sg", "shadow", "sr", "time1", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTime1", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "time2", "getTime2", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*     */ public final class GameInfo extends Element {
/*     */   private final BoolValue bV;
/*     */   private final ListValue OutmodeValue;
/*     */   private final BoolValue Outline;
/*     */   private final IntegerValue bgValue;
/*     */   private final BoolValue shadow;
/*     */   private final IntegerValue sr;
/*     */   private final IntegerValue sg;
/*     */   private final IntegerValue sb;
/*     */   private final IntegerValue sa;
/*     */   private long minute;
/*     */   private long second;
/*     */   @NotNull
/*     */   private final MSTimer time2;
/*     */   @NotNull
/*     */   private final MSTimer time1;
/*     */   
/*     */   public GameInfo(double x, double y, float scale) {
/*  39 */     super(x, y, scale, null, 8, null);
/*  40 */     this.bV = new BoolValue("blur", false);
/*     */     
/*  42 */     this.OutmodeValue = new ListValue("Outmode", new String[] { "Outline1", "Outline2", "old", "more" }, "Outline1");
/*  43 */     this.Outline = new BoolValue("Outline", true);
/*  44 */     this.bgValue = new IntegerValue("Background-Alpha", 120, 0, 255);
/*  45 */     this.shadow = new BoolValue("Shadow", false);
/*  46 */     this.sr = new IntegerValue("Shadow-Red", 0, 0, 255);
/*  47 */     this.sg = new IntegerValue("Shadow-Green", 0, 0, 255);
/*  48 */     this.sb = new IntegerValue("Shadow-Blue", 0, 0, 255);
/*  49 */     this.sa = new IntegerValue("Shadow-Alpna", 0, 0, 255);
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.time2 = new MSTimer();
/*  54 */     this.time1 = new MSTimer();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   static final class GameInfo$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 179 */       GL11.glPushMatrix();
/* 180 */       GL11.glTranslated(GameInfo.this.getRenderX(), GameInfo.this.getRenderY(), 0.0D);
/* 181 */       GL11.glScalef(GameInfo.this.getScale(), GameInfo.this.getScale(), GameInfo.this.getScale());
/* 182 */       RenderUtils.originalRoundedRect(
/* 183 */           -6.0F, 
/* 184 */           0.0F, 146.0F, 68.0F, 
/* 185 */           6.4F, (new Color(((Number)GameInfo.this.sr.get()).intValue(), ((Number)GameInfo.this.sg.get()).intValue(), ((Number)GameInfo.this.sb.get()).intValue(), ((Number)GameInfo.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 188 */       GL11.glPopMatrix();
/*     */     } GameInfo$drawElement$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GameInfo$drawElement$2 extends Lambda implements Function0<Unit> { public final void invoke() {
/* 191 */       GL11.glPushMatrix();
/* 192 */       GL11.glTranslated(GameInfo.this.getRenderX(), GameInfo.this.getRenderY(), 0.0D);
/* 193 */       GL11.glScalef(GameInfo.this.getScale(), GameInfo.this.getScale(), GameInfo.this.getScale());
/* 194 */       GlStateManager.func_179147_l();
/* 195 */       GlStateManager.func_179090_x();
/* 196 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 198 */       RenderUtils.originalRoundedRect(
/* 199 */           -6.0F, 
/* 200 */           0.0F, 146.0F, 68.0F, 
/* 201 */           6.4F, (new Color(((Number)GameInfo.this.sr.get()).intValue(), ((Number)GameInfo.this.sg.get()).intValue(), ((Number)GameInfo.this.sb.get()).intValue(), ((Number)GameInfo.this.sa.get()).intValue())).getRGB());
/* 202 */       GlStateManager.func_179098_w();
/* 203 */       GlStateManager.func_179084_k();
/* 204 */       GL11.glPopMatrix();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     GameInfo$drawElement$2() {
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
/*     */   static final class GameInfo$drawElement$3
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 304 */       GL11.glPushMatrix();
/* 305 */       GL11.glTranslated(GameInfo.this.getRenderX(), GameInfo.this.getRenderY(), 0.0D);
/* 306 */       GL11.glScalef(GameInfo.this.getScale(), GameInfo.this.getScale(), GameInfo.this.getScale());
/* 307 */       RenderUtils.originalRoundedRect(
/* 308 */           -6.0F, 
/* 309 */           0.0F, 146.0F, 68.0F, 
/* 310 */           6.4F, (new Color(((Number)GameInfo.this.sr.get()).intValue(), ((Number)GameInfo.this.sg.get()).intValue(), ((Number)GameInfo.this.sb.get()).intValue(), ((Number)GameInfo.this.sa.get()).intValue())).getRGB());
/*     */ 
/*     */       
/* 313 */       GL11.glPopMatrix();
/*     */     } GameInfo$drawElement$3() { super(0); }
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 316 */   static final class GameInfo$drawElement$4 extends Lambda implements Function0<Unit> { GameInfo$drawElement$4() { super(0); } public final void invoke() { GL11.glPushMatrix();
/* 317 */       GL11.glTranslated(GameInfo.this.getRenderX(), GameInfo.this.getRenderY(), 0.0D);
/* 318 */       GL11.glScalef(GameInfo.this.getScale(), GameInfo.this.getScale(), GameInfo.this.getScale());
/* 319 */       GlStateManager.func_179147_l();
/* 320 */       GlStateManager.func_179090_x();
/* 321 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/*     */       
/* 323 */       RenderUtils.originalRoundedRect(
/* 324 */           -6.0F, 
/* 325 */           0.0F, 146.0F, 68.0F, 
/* 326 */           6.4F, (new Color(((Number)GameInfo.this.sr.get()).intValue(), ((Number)GameInfo.this.sg.get()).intValue(), ((Number)GameInfo.this.sb.get()).intValue(), ((Number)GameInfo.this.sa.get()).intValue())).getRGB());
/* 327 */       GlStateManager.func_179098_w();
/* 328 */       GlStateManager.func_179084_k();
/* 329 */       GL11.glPopMatrix(); } } @NotNull public Border drawElement() { Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(2.0F, (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), 2.0F + FontLoaders.S22.getStringWidth("Session"), Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB()); if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Players Killed: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 3.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(autoL.kills()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Players Killed: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 4.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Win: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 3.0F + 4.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getWin()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Win: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 8.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Total: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 3.0F + 8.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getTotalPlayed()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Total: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 12.0F), Color.WHITE.getRGB()); if (((Boolean)this.bV.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); BlurBuffer.CustomBlurRoundArea((float)getRenderX() - 6, (float)getRenderY(), 152.0F, 68.0F, 6.4F, 10.0F); GL11.glPopMatrix(); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline1", true)) { RenderUtils.drawRoundedRect(-6.0F, 0.0F, 146.0F, 68.0F, 6.4F, (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawOutline(0.0F, 0.0F, 140.0F, 55.0F, 6.4F, ((Number)AColorPalette.Companion.getLine().get()).floatValue(), 3.0F);  double d1 = 145.0D; double d2 = (Fonts.tenacitybold35.getFontHeight() * 5 + 18) * 1.15D; long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart(); long hour = durationInMillis / 3600000L % 24L; float arc = 0.0F; if (this.time2.hasTimePassed(1000L)) { if (this.second == 59L) this.minute++;  this.second++; this.time2.reset(); }  if (this.second > 60L) this.second = 0L;  if (this.minute != 59L) { if (this.minute != 0L) { arc = (float)(360.0D / (59L / this.minute)); } else { arc = 0.0F; }  } else { this.minute = 0L; this.second = 0L; }  GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Session", 2.0F, 2.5F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Play Time", (float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), 2.5F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB18.drawCenteredString(this.minute + ':' + this.second, ((float)d1 - 2.0F) - (FontLoaders.S22.getStringWidth("Play Time") / 2.0F), (float)(d2 / 2.0F - 2.0F) + 3.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), (float)d1 - 2.0F, Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); DrawArc.drawArc((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, (float)(d2 / 2.0F) + 3.0F, 22.0D, Color.WHITE.getRGB(), 0, 360.0D, 6.0F); DrawArc.drawArc((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, (float)(d2 / 2.0F) + 3.0F, 22.0D, (new Color(0, 95, 255)).getRGB(), 0, arc, 6.0F); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(2.0F, (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), 2.0F + FontLoaders.S22.getStringWidth("Session"), Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB()); if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL1 = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Players Killed: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 3.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(autoL1.kills()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Players Killed: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 4.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Win: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 3.0F + 4.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getWin()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Win: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 8.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Total: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 3.0F + 8.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getTotalPlayed()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Total: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 12.0F), Color.WHITE.getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo$drawElement$1(), new GameInfo$drawElement$2()); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }  if (StringsKt.equals((String)this.OutmodeValue.get(), "Outline2", true)) { RenderUtils.drawRoundedRect(-6.0F, 0.0F, 146.0F, 68.0F, 6.4F, (new Color(0, 0, 0, ((Number)this.bgValue.get()).intValue())).getRGB()); if (((Boolean)this.Outline.get()).booleanValue()) ScaleUtils.drawGidentOutlinedRoundedRect3(-6.0D, 0.0D, 152.0D, 68.0D, 6.4D, ((Number)AColorPalette.Companion.getLine().get()).floatValue());  double d1 = 145.0D; double d2 = (Fonts.tenacitybold35.getFontHeight() * 5 + 18) * 1.15D; long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart(); long hour = durationInMillis / 3600000L % 24L; float arc = 0.0F; if (this.time2.hasTimePassed(1000L)) { if (this.second == 59L) this.minute++;  this.second++; this.time2.reset(); }  if (this.second > 60L)
/*     */         this.second = 0L;  if (this.minute != 59L) { if (this.minute != 0L) { arc = (float)(360.0D / (59L / this.minute)); } else { arc = 0.0F; }  } else { this.minute = 0L; this.second = 0L; }  GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); GL11.glPopMatrix(); GL11.glScalef(getScale(), getScale(), getScale()); GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Session", 2.0F, 2.5F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Play Time", (float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), 2.5F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB18.drawCenteredString(this.minute + ':' + this.second, ((float)d1 - 2.0F) - (FontLoaders.S22.getStringWidth("Play Time") / 2.0F), (float)(d2 / 2.0F - 2.0F) + 3.0F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), (float)d1 - 2.0F, Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); DrawArc.drawArc((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, (float)(d2 / 2.0F) + 3.0F, 22.0D, Color.WHITE.getRGB(), 0, 360.0D, 6.0F); DrawArc.drawArc((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, (float)(d2 / 2.0F) + 3.0F, 22.0D, (new Color(0, 95, 255)).getRGB(), 0, arc, 6.0F); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(2.0F, (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), 2.0F + FontLoaders.S22.getStringWidth("Session"), Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB()); if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null)
/* 331 */         throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL1 = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Players Killed: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 3.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(autoL1.kills()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Players Killed: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 4.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Win: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 3.0F + 4.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getWin()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Win: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 8.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Total: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 3.0F + 8.0F), Color.WHITE.getRGB()); Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getTotalPlayed()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Total: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 12.0F), Color.WHITE.getRGB()); }  if (((Boolean)this.shadow.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(8.0F, new GameInfo$drawElement$3(), new GameInfo$drawElement$4()); GL11.glPopMatrix();
/* 332 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 333 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */     
/* 335 */     if (StringsKt.equals((String)this.OutmodeValue.get(), "old", true)) {
/* 336 */       if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class);
/* 337 */       if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class);
/* 338 */       Color gradientColor1 = Color.WHITE;
/* 339 */       Color gradientColor2 = Color.WHITE;
/* 340 */       Color gradientColor3 = Color.WHITE;
/* 341 */       Color gradientColor4 = Color.WHITE;
/* 342 */       gradientColor1 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(10, 20, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/* 343 */       gradientColor2 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 90, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/* 344 */       gradientColor3 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color.getColorRedValue().get()).intValue(), ((Number)color.getColorGreenValue().get()).intValue(), ((Number)color.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/* 345 */       gradientColor4 = ColorUtils.INSTANCE.interpolateColorsBackAndForth(20, 270, new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color.getColoralpha().get()).intValue()), new Color(((Number)color2.getColorRedValue().get()).intValue(), ((Number)color2.getColorGreenValue().get()).intValue(), ((Number)color2.getColorBlueValue().get()).intValue(), ((Number)color2.getColoralpha().get()).intValue()), false);
/*     */ 
/*     */       
/* 348 */       RoundedUtil.drawGradientRound(-6.0F, 0.0F, 150.0F, 68.0F, ((Number)AColorPalette.Companion.getRa().get()).floatValue(), gradientColor1, gradientColor3, gradientColor2, gradientColor1);
/*     */       
/* 350 */       double d1 = 145.0D;
/* 351 */       double d2 = (Fonts.tenacitybold35.getFontHeight() * 5 + 18) * 1.15D;
/* 352 */       long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart();
/* 353 */       long hour = durationInMillis / 3600000L % 24L;
/* 354 */       float arc = 0.0F;
/*     */ 
/*     */       
/* 357 */       if (this.time2.hasTimePassed(1000L)) {
/* 358 */         if (this.second == 59L) {
/* 359 */           this.minute++;
/*     */         }
/* 361 */         this.second++;
/* 362 */         this.time2.reset();
/*     */       } 
/*     */       
/* 365 */       if (this.second > 60L) {
/* 366 */         this.second = 0L;
/*     */       }
/*     */       
/* 369 */       if (this.minute != 59L) {
/* 370 */         if (this.minute != 0L) {
/* 371 */           arc = (float)(360.0D / (59L / this.minute));
/*     */         } else {
/* 373 */           arc = 0.0F;
/*     */         } 
/*     */       } else {
/*     */         
/* 377 */         this.minute = 0L;
/* 378 */         this.second = 0L;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 384 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 385 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 386 */       GL11.glPushMatrix();
/*     */       
/* 388 */       GL11.glPopMatrix();
/* 389 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 390 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */ 
/*     */       
/* 393 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Session", 2.0F, 2.5F, Color.WHITE.getRGB());
/* 394 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Play Time", (float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), 2.5F, Color.WHITE.getRGB());
/* 395 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB18.drawCenteredString(this.minute + ':' + this.second, ((float)d1 - 2.0F) - (FontLoaders.S22.getStringWidth("Play Time") / 2.0F), (float)(d2 / 2.0F - 2.0F) + 3.0F, Color.WHITE.getRGB());
/*     */       
/* 397 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), (float)d1 - 2.0F, Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 402 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); DrawArc.drawArc((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, (float)(d2 / 2.0F) + 3.0F, 22.0D, Color.WHITE.getRGB(), 
/* 403 */           0, 
/* 404 */           360.0D, 
/* 405 */           6.0F);
/*     */       
/* 407 */       DrawArc.drawArc(
/* 408 */           (float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, 
/* 409 */           (float)(d2 / 2.0F) + 3.0F, 
/* 410 */           22.0D, (
/* 411 */           new Color(0, 95, 255)).getRGB(), 
/* 412 */           0, 
/* 413 */           arc, 
/* 414 */           6.0F);
/*     */ 
/*     */ 
/*     */       
/* 418 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(2.0F, (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), 2.0F + FontLoaders.S22.getStringWidth("Session"), Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB());
/* 419 */       if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL1 = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class);
/*     */       
/* 421 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Players Killed: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 3.0F), Color.WHITE.getRGB());
/*     */       
/* 423 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(autoL1.kills()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Players Killed: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 4.0F), Color.WHITE.getRGB());
/*     */       
/* 425 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Win: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 3.0F + 4.0F), Color.WHITE.getRGB());
/*     */       
/* 427 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getWin()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Win: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 8.0F), Color.WHITE.getRGB());
/*     */       
/* 429 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Total: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 3.0F + 8.0F), Color.WHITE.getRGB());
/*     */       
/* 431 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getTotalPlayed()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Total: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 12.0F), Color.WHITE.getRGB());
/*     */     } 
/* 433 */     if (StringsKt.equals((String)this.OutmodeValue.get(), "more", true)) {
/* 434 */       if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor");  PictureColor color = (PictureColor)Retreat.INSTANCE.getModuleManager().getModule(PictureColor.class);
/* 435 */       if (Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2");  PictureColor2 color2 = (PictureColor2)Retreat.INSTANCE.getModuleManager().getModule(PictureColor2.class);
/* 436 */       Color gradientColor1 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue());
/* 437 */       Color gradientColor2 = new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), ((Number)AColorPalette.a.get()).intValue());
/* 438 */       Color gradientColor3 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue());
/* 439 */       Color gradientColor4 = new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), ((Number)AColorPalette.b2.get()).intValue(), ((Number)AColorPalette.Companion.getA2().get()).intValue());
/*     */       
/* 441 */       RoundedUtil.drawGradientRound(-6.0F, 0.0F, 150.0F, 68.0F, ((Number)AColorPalette.Companion.getRa().get()).floatValue(), 
/* 442 */           ColorUtil.applyOpacity(gradientColor4, 0.85F), gradientColor1, gradientColor3, gradientColor2);
/*     */ 
/*     */ 
/*     */       
/* 446 */       double d1 = 145.0D;
/* 447 */       double d2 = (Fonts.tenacitybold35.getFontHeight() * 5 + 18) * 1.15D;
/* 448 */       long durationInMillis = System.currentTimeMillis() - Retreat.INSTANCE.getPlayTimeStart();
/* 449 */       long hour = durationInMillis / 3600000L % 24L;
/* 450 */       float arc = 0.0F;
/*     */ 
/*     */       
/* 453 */       if (this.time2.hasTimePassed(1000L)) {
/* 454 */         if (this.second == 59L) {
/* 455 */           this.minute++;
/*     */         }
/* 457 */         this.second++;
/* 458 */         this.time2.reset();
/*     */       } 
/*     */       
/* 461 */       if (this.second > 60L) {
/* 462 */         this.second = 0L;
/*     */       }
/*     */       
/* 465 */       if (this.minute != 59L) {
/* 466 */         if (this.minute != 0L) {
/* 467 */           arc = (float)(360.0D / (59L / this.minute));
/*     */         } else {
/* 469 */           arc = 0.0F;
/*     */         } 
/*     */       } else {
/*     */         
/* 473 */         this.minute = 0L;
/* 474 */         this.second = 0L;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 480 */       GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 481 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 482 */       GL11.glPushMatrix();
/*     */       
/* 484 */       GL11.glPopMatrix();
/* 485 */       GL11.glScalef(getScale(), getScale(), getScale());
/* 486 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */ 
/*     */       
/* 489 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Session", 2.0F, 2.5F, Color.WHITE.getRGB());
/* 490 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB20.drawString("Play Time", (float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), 2.5F, Color.WHITE.getRGB());
/* 491 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.SB18.drawCenteredString(this.minute + ':' + this.second, ((float)d1 - 2.0F) - (FontLoaders.S22.getStringWidth("Play Time") / 2.0F), (float)(d2 / 2.0F - 2.0F) + 3.0F, Color.WHITE.getRGB());
/*     */       
/* 493 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time"), (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), (float)d1 - 2.0F, Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 498 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); DrawArc.drawArc((float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, (float)(d2 / 2.0F) + 3.0F, 22.0D, Color.WHITE.getRGB(), 
/* 499 */           0, 
/* 500 */           360.0D, 
/* 501 */           6.0F);
/*     */       
/* 503 */       DrawArc.drawArc(
/* 504 */           (float)d1 - 2.0F - FontLoaders.S22.getStringWidth("Play Time") / 2.0F, 
/* 505 */           (float)(d2 / 2.0F) + 3.0F, 
/* 506 */           22.0D, (
/* 507 */           new Color(0, 95, 255)).getRGB(), 
/* 508 */           0, 
/* 509 */           arc, 
/* 510 */           6.0F);
/*     */ 
/*     */ 
/*     */       
/* 514 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); RenderUtils.drawRect(2.0F, (float)((Fonts.tenacitybold35.getFontHeight() + 2.5F) + 0.0D), 2.0F + FontLoaders.S22.getStringWidth("Session"), Fonts.tenacitybold35.getFontHeight() + 2.5F + 1.16F, Color.WHITE.getRGB());
/* 515 */       if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  AutoL autoL1 = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class);
/*     */       
/* 517 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Players Killed: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 3.0F), Color.WHITE.getRGB());
/*     */       
/* 519 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(autoL1.kills()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Players Killed: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 2) * 1.15D + 4.0F), Color.WHITE.getRGB());
/*     */       
/* 521 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Win: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 3.0F + 4.0F), Color.WHITE.getRGB());
/*     */       
/* 523 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getWin()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Win: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 3) * 1.15D + 8.0F), Color.WHITE.getRGB());
/*     */       
/* 525 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow("Total: ", 2, (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 3.0F + 8.0F), Color.WHITE.getRGB());
/*     */       
/* 527 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.tenacitybold35.drawStringWithShadow(String.valueOf(Recorder.INSTANCE.getTotalPlayed()), (int)(4.0F + Fonts.tenacitybold35.getStringWidth("Total: ".toString())), (int)((Fonts.tenacitybold35.getFontHeight() * 4) * 1.15D + 12.0F), Color.WHITE.getRGB());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 533 */     double x2 = 145.0D;
/* 534 */     double y2 = (Fonts.tenacitybold35.getFontHeight() * 5 + 18) * 1.15D;
/* 535 */     return new Border(-2.0F, 0.0F, (float)x2, (float)y2); }
/*     */ 
/*     */   
/*     */   public final long getMinute() {
/*     */     return this.minute;
/*     */   }
/*     */   
/*     */   public final void setMinute(long <set-?>) {
/*     */     this.minute = <set-?>;
/*     */   }
/*     */   
/*     */   public final long getSecond() {
/*     */     return this.second;
/*     */   }
/*     */   
/*     */   public final void setSecond(long <set-?>) {
/*     */     this.second = <set-?>;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final MSTimer getTime2() {
/*     */     return this.time2;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final MSTimer getTime1() {
/*     */     return this.time1;
/*     */   }
/*     */   
/*     */   public GameInfo() {
/*     */     this(0.0D, 0.0D, 0.0F, 7, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\GameInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */