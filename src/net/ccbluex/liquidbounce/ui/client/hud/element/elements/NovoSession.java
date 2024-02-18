/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import java.awt.Color;
/*     */ 
/*     */ @ElementInfo(name = "NovoSession")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000|\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\000\n\002\030\002\n\002\b\t\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\006\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\025\n\002\b\002\n\002\020\002\n\000\b\007\030\0002\0020\001B#\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006¢\006\002\020\007J\b\0204\032\00205H\026J\016\0206\032\002072\006\0208\032\00207J\016\0206\032\002072\006\0208\032\0020\rJ\020\0209\032\0020\r2\006\020:\032\0020\rH\002J\006\020;\032\0020\006J\b\020<\032\0020=H\002J\b\020>\032\0020\031H\002J\b\020?\032\0020@H\026R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\n\020\013R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\032\020\020\032\0020\006X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\032\020\025\032\0020\006X\016¢\006\016\n\000\032\004\b\026\020\022\"\004\b\027\020\024R\032\020\030\032\0020\031X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035R\021\020\036\032\0020\037¢\006\b\n\000\032\004\b \020!R\021\020\"\032\0020#¢\006\b\n\000\032\004\b$\020%R\021\020&\032\0020'¢\006\b\n\000\032\004\b(\020)R\024\020*\032\0020+XD¢\006\b\n\000\032\004\b,\020-R\032\020.\032\0020\031X\016¢\006\016\n\000\032\004\b/\020\033\"\004\b0\020\035R\016\0201\032\00202X\004¢\006\002\n\000R\016\0203\032\0020'X\004¢\006\002\n\000¨\006A"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NovoSession;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "(DDF)V", "AutoPlay", "Lnet/ccbluex/liquidbounce/features/module/modules/hyt/AutoPlay;", "getAutoPlay", "()Lnet/ccbluex/liquidbounce/features/module/modules/hyt/AutoPlay;", "GameInfoRows", "", "alpha2", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "borderHeight", "getBorderHeight", "()F", "setBorderHeight", "(F)V", "borderWidth", "getBorderWidth", "setBorderWidth", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "hudMod", "Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "getHudMod", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/HUD;", "kills", "Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL;", "getKills", "()Lnet/ccbluex/liquidbounce/features/module/modules/player/AutoL;", "lineValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getLineValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "shadowNoCutValue", "", "getShadowNoCutValue", "()Z", "startTime", "getStartTime", "setStartTime", "textshadowStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "textshadowValue", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "getColor", "Ljava/awt/Color;", "color", "getColorAtIndex", "i", "getFadeProgress", "getPlayTime", "", "getTimeDiff", "shader", "", "XSJClient"})
/*     */ public final class NovoSession extends Element {
/*     */   @NotNull
/*     */   private final BoolValue lineValue;
/*     */   private final IntegerValue alpha2;
/*     */   private final BoolValue textshadowValue;
/*     */   private final FloatValue textshadowStrength;
/*     */   private final boolean shadowNoCutValue = true;
/*     */   private int GameInfoRows;
/*     */   private float borderWidth;
/*     */   private float borderHeight;
/*     */   @NotNull
/*     */   private final HUD hudMod;
/*     */   @NotNull
/*     */   private final AutoL kills;
/*     */   @NotNull
/*     */   private final AutoPlay AutoPlay;
/*     */   private long startTime;
/*     */   private long endTime;
/*     */   
/*     */   public NovoSession(double x, double y, float scale) {
/*  26 */     super(x, y, scale, null, 8, null);
/*  27 */     this.lineValue = new BoolValue("NewNovoline-Line", true);
/*  28 */     this.alpha2 = new IntegerValue("New-BG-Alpha", 40, 0, 255);
/*  29 */     this.textshadowValue = new BoolValue("Text-Shadow", false);
/*  30 */     this.textshadowStrength = new FloatValue("Text-Shadow-Strength", 5.0F, 0.01F, 8.0F);
/*  31 */     this.shadowNoCutValue = true;
/*     */ 
/*     */ 
/*     */     
/*  35 */     if (Retreat.INSTANCE.getModuleManager().getModule(HUD.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.HUD");  this.hudMod = (HUD)Retreat.INSTANCE.getModuleManager().getModule(HUD.class);
/*  36 */     if (Retreat.INSTANCE.getModuleManager().getModule(AutoL.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.AutoL");  this.kills = (AutoL)Retreat.INSTANCE.getModuleManager().getModule(AutoL.class);
/*  37 */     if (Retreat.INSTANCE.getModuleManager().getModule(AutoPlay.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.hyt.AutoPlay");  this.AutoPlay = (AutoPlay)Retreat.INSTANCE.getModuleManager().getModule(AutoPlay.class);
/*  38 */     this.startTime = System.currentTimeMillis();
/*  39 */     this.endTime = -1L;
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class NovoSession$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     NovoSession$drawElement$1() {
/*     */       super(0);
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
/*     */     public final void invoke() {
/*  88 */       GL11.glPushMatrix();
/*  89 */       GL11.glTranslated(NovoSession.this.getRenderX(), NovoSession.this.getRenderY(), 0.0D);
/*  90 */       if (((Boolean)NovoSession.this.getLineValue().get()).booleanValue()) {
/*  91 */         byte b = 0; int i = ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() - 1; if (b <= i)
/*  92 */           while (true) { double barStart = b / ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() * 150.6D;
/*  93 */             double barEnd = (b + 1) / ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() * 150.6D;
/*  94 */             RenderUtils.drawGradientSideways(false + barStart, false, false + barEnd, 1.2D, NovoSession.this.getColorAtIndex(b), NovoSession.this.getColorAtIndex(b + 1)); if (b != i) { b++; continue; }
/*     */              break; }
/*     */            
/*  97 */       }  GL11.glPopMatrix();
/*  98 */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class NovoSession$drawElement$2 extends Lambda implements Function0<Unit> { public static final NovoSession$drawElement$2 INSTANCE = new NovoSession$drawElement$2(); public final void invoke() {} NovoSession$drawElement$2() { super(0); } } @NotNull public final BoolValue getLineValue() { return this.lineValue; } public final boolean getShadowNoCutValue() { return this.shadowNoCutValue; } public final float getBorderWidth() { return this.borderWidth; } public final void setBorderWidth(float <set-?>) { this.borderWidth = <set-?>; } public final float getBorderHeight() { return this.borderHeight; } public final void setBorderHeight(float <set-?>) { this.borderHeight = <set-?>; } @NotNull public final HUD getHudMod() { return this.hudMod; } @NotNull public Border drawElement() { int Borderx1 = 0; int Bordery1 = 0; int Borderx2 = 0; int Bordery2 = 0; IFontRenderer fontRenderer = Fonts.productSans35; float y2 = (Fonts.productSans35.getFontHeight() * 5) + 11.0F; SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss"); int[] playTime = getPlayTime(); String playtimeString = String.valueOf(playTime[0]) + "h " + playTime[1] + "m " + playTime[2] + "s"; int length2 = 138; Borderx1 += 0; Bordery1 += this.GameInfoRows * 18 + 12; Borderx2 += 150; Bordery2 += 80; this.borderWidth = 137.5F; this.borderHeight = 63.800003F; if (((Boolean)this.textshadowValue.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.textshadowStrength.get()).floatValue(), new NovoSession$drawElement$1(), NovoSession$drawElement$2.INSTANCE);
/*  99 */       GL11.glPopMatrix();
/* 100 */       GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */ 
/*     */     
/* 103 */     RenderUtils.drawRoundedRect2(0.0F, 0.0F, 150.5F, 59.800003F, 0.0F, 6, (new Color(0, 0, 0, ((Number)this.alpha2.get()).intValue())).getRGB());
/*     */     
/* 105 */     if (((Boolean)this.lineValue.get()).booleanValue()) {
/* 106 */       byte b = 0; int i = ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() - 1; if (b <= i)
/* 107 */         while (true) { double barStart = b / ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() * 150.6D;
/* 108 */           double barEnd = (b + 1) / ((Number)AColorPalette.Companion.getGradientLoopValue().get()).intValue() * 150.6D;
/* 109 */           RenderUtils.drawGradientSideways(false + barStart, false, false + barEnd, 1.2D, getColorAtIndex(b), getColorAtIndex(b + 1)); if (b != i) {
/*     */             b++; continue;
/*     */           }  break; }
/*     */          
/*     */     } 
/* 114 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont17.drawString("Session Info", 53.25F, 6.4F, Color.WHITE.getRGB(), true);
/*     */ 
/*     */ 
/*     */     
/* 118 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); UiFonts.Novoicon_25.drawString("b", 4.4F, 17.7F, Color.WHITE.getRGB(), true);
/*     */     
/* 120 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString("Play Time", 7.7000003F + UiFonts.Novoicon_25.getStringWidth("b") - 0.5F, 17.6F, Color.WHITE.getRGB(), true);
/*     */ 
/*     */     
/* 123 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString(String.valueOf(DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L))), 146.3F - Fonts.Newuifont15.getStringWidth(String.valueOf(DATE_FORMAT.format(new Date(System.currentTimeMillis() - Recorder.INSTANCE.getStartTime() - 28800000L)))), 17.6F, Color.WHITE.getRGB(), true);
/*     */     
/* 125 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); UiFonts.Novoicon_25.drawString("c", 4.4F, 28.7F, Color.WHITE.getRGB(), true);
/*     */     
/* 127 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString("Kills", 7.7000003F + UiFonts.Novoicon_25.getStringWidth("c") - 0.5F, 28.6F, Color.WHITE.getRGB(), true);
/*     */     
/* 129 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString(String.valueOf(this.kills.getKill()), 146.3F - Fonts.Newuifont15.getStringWidth(String.valueOf(this.kills.getKill())), 28.6F, Color.WHITE.getRGB(), true);
/*     */     
/* 131 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); UiFonts.Novoicon_25.drawString("d", 4.4F, 39.7F, Color.WHITE.getRGB(), true);
/*     */     
/* 133 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString("Wins", 7.7000003F + UiFonts.Novoicon_25.getStringWidth("d") - 0.5F, 39.600002F, Color.WHITE.getRGB(), true);
/*     */     
/* 135 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString(String.valueOf(this.AutoPlay.getWin()), 146.3F - Fonts.Newuifont15.getStringWidth(String.valueOf(this.AutoPlay.getTotalPlayed())), 39.600002F, Color.WHITE.getRGB(), true);
/*     */     
/* 137 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); UiFonts.Novoicon_25.drawString("a", 4.4F, 50.7F, Color.WHITE.getRGB());
/*     */     
/* 139 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString("Bans staff/wd", 7.7000003F + UiFonts.Novoicon_25.getStringWidth("a") - 0.5F, 50.600002F, Color.WHITE.getRGB(), true);
/*     */     
/* 141 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.Newuifont15.drawString(String.valueOf(this.AutoPlay.getBan()) + "/" + String.valueOf(this.AutoPlay.getBan()), 146.3F - Fonts.Newuifont15.getStringWidth(String.valueOf(this.AutoPlay.getBan()) + "/" + String.valueOf(this.AutoPlay.getBan())), 50.600002F, Color.WHITE.getRGB(), true);
/* 142 */     return new Border(-2.0F, -6.0F, 150.0F, y2 + 10.0F); }
/*     */   @NotNull public final AutoL getKills() { return this.kills; }
/* 144 */   @NotNull public final AutoPlay getAutoPlay() { return this.AutoPlay; } public final long getStartTime() { return this.startTime; } public final void setStartTime(long <set-?>) { this.startTime = <set-?>; } public final long getEndTime() { return this.endTime; } public final void setEndTime(long <set-?>) { this.endTime = <set-?>; } private final int[] getPlayTime() { long diff = getTimeDiff(); long diffSeconds = 0L; long diffMinutes = 0L; long diffHours = 0L; if (diff > 0L) { diffSeconds = diff / 1000L % 60L; diffMinutes = diff / 60000L % 60L; diffHours = diff / 3600000L % 24L; }  return new int[] { (int)diffHours, (int)diffMinutes, (int)diffSeconds }; } private final long getTimeDiff() { return ((this.endTime == -1L) ? System.currentTimeMillis() : this.endTime) - this.startTime; } public void shader() { RenderUtils.drawRoundedRect2(0.0F, 0.0F, 150.5F, 59.800003F, 0.0F, 6, -1); } public final float getFadeProgress() { return 0.0F; } @NotNull
/* 145 */   public final Color getColor(@NotNull Color color) { Intrinsics.checkParameterIsNotNull(color, "color"); return ColorUtils.reAlpha(color, color.getAlpha() / 255.0F * (1.0F - getFadeProgress())); } @NotNull
/* 146 */   public final Color getColor(int color) { return getColor(new Color(color)); }
/*     */    private final int getColorAtIndex(int i) {
/* 148 */     String str = (String)AColorPalette.colorModeValue.get(); switch (str.hashCode())
/*     */     { case 83201:
/* 150 */         if (str.equals("Sky")); break;case -1656737386: if (str.equals("Rainbow")); break;
/* 151 */       case -1815582866: if (str.equals("Slowly")) if (ColorUtils.LiquidSlowly(System.nanoTime(), i * ((Number)AColorPalette.Companion.getGradientDistanceValue().get()).intValue(), ((Number)AColorPalette.Companion.getSaturationValue().get()).floatValue(), ((Number)AColorPalette.Companion.getBrightnessValue().get()).floatValue()) == null) Intrinsics.throwNpe();   break;
/*     */       case 2132719113:
/* 153 */         if (str.equals("Gident")) Intrinsics.checkExpressionValueIsNotNull(RenderUtils.getGradientOffset(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue()), new Color(((Number)AColorPalette.r2.get()).intValue(), ((Number)AColorPalette.g2.get()).intValue(), (
/* 154 */                   (Number)AColorPalette.b2.get()).intValue(), 1), Math.abs(System.currentTimeMillis() / (
/* 155 */                   (Number)AColorPalette.gradientSpeed.get()).intValue() + (i * ((Number)AColorPalette.Companion.getGradientDistanceValue().get()).intValue())) / 10), "RenderUtils.getGradientO…stanceValue.get()) / 10))");  break;
/* 156 */       case 2181788: if (str.equals("Fade")); break; }  return getColor(-1).getRGB();
/*     */   }
/*     */   
/*     */   public NovoSession() {
/*     */     this(0.0D, 0.0D, 0.0F, 7, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\NovoSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */