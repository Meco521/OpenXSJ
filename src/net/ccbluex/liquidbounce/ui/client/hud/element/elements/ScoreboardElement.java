/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ElementInfo(name = "Scoreboard")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\020\021\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020)\032\0020*H\002J\b\020+\032\0020*H\002J\n\020,\032\004\030\0010-H\026J\b\020.\032\0020*H\002R\026\020\n\032\b\022\004\022\0020\f0\013X\004¢\006\004\n\002\020\rR\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\017X\004¢\006\002\n\000R\016\020\021\032\0020\017X\004¢\006\002\n\000R\016\020\022\032\0020\017X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\027\032\0020\017X\004¢\006\002\n\000R\016\020\030\032\0020\017X\004¢\006\002\n\000R\016\020\031\032\0020\024X\004¢\006\002\n\000R\016\020\032\032\0020\017X\004¢\006\002\n\000R\016\020\033\032\0020\034X\004¢\006\002\n\000R\016\020\035\032\0020\026X\004¢\006\002\n\000R\016\020\036\032\0020\024X\004¢\006\002\n\000R\016\020\037\032\0020\024X\004¢\006\002\n\000R\016\020 \032\0020\024X\004¢\006\002\n\000R\016\020!\032\0020\026X\004¢\006\002\n\000R\016\020\"\032\0020#X\004¢\006\002\n\000R\016\020$\032\0020\024X\004¢\006\002\n\000R\016\020%\032\0020\026X\004¢\006\002\n\000R\016\020&\032\0020\017X\004¢\006\002\n\000R\016\020'\032\0020\017X\004¢\006\002\n\000R\016\020(\032\0020\017X\004¢\006\002\n\000¨\006/"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/ScoreboardElement;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "allowedDomains", "", "", "[Ljava/lang/String;", "backgroundColorAlphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "backgroundColorBlueValue", "backgroundColorGreenValue", "backgroundColorRedValue", "blur", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "blurStrength", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "dblue", "dgreen", "domainrainbow", "dred", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "linewidth", "noPointValue", "noshadow", "outline", "radius", "serverValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "shadowShaderValue", "shadowStrength", "textBlueValue", "textGreenValue", "textRedValue", "backgroundColor", "Ljava/awt/Color;", "backgroundColor2", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "textColor", "XSJClient"})
/*     */ public final class ScoreboardElement extends Element {
/*     */   private final IntegerValue textRedValue;
/*     */   private final IntegerValue textGreenValue;
/*     */   private final IntegerValue textBlueValue;
/*     */   private final IntegerValue backgroundColorRedValue;
/*     */   private final IntegerValue backgroundColorGreenValue;
/*     */   private final IntegerValue backgroundColorBlueValue;
/*     */   private final IntegerValue backgroundColorAlphaValue;
/*     */   private final BoolValue noshadow;
/*     */   private final BoolValue shadowShaderValue;
/*     */   private final FloatValue shadowStrength;
/*     */   private final FloatValue radius;
/*     */   private final BoolValue domainrainbow;
/*     */   private final IntegerValue dred;
/*     */   private final IntegerValue dgreen;
/*     */   private final IntegerValue dblue;
/*     */   private final BoolValue blur;
/*     */   private final FloatValue blurStrength;
/*     */   private final BoolValue outline;
/*     */   private final FloatValue linewidth;
/*     */   private final ListValue serverValue;
/*     */   private final BoolValue noPointValue;
/*     */   private final FontValue fontValue;
/*     */   private final String[] allowedDomains;
/*     */   
/*     */   public ScoreboardElement(double x, double y, float scale, @NotNull Side side) {
/*  34 */     super(x, y, scale, side);
/*     */ 
/*     */     
/*  37 */     this.textRedValue = new IntegerValue("Text-R", 255, 0, 255);
/*  38 */     this.textGreenValue = new IntegerValue("Text-G", 255, 0, 255);
/*  39 */     this.textBlueValue = new IntegerValue("Text-B", 255, 0, 255);
/*     */     
/*  41 */     this.backgroundColorRedValue = new IntegerValue("Background-R", 0, 0, 255);
/*  42 */     this.backgroundColorGreenValue = new IntegerValue("Background-G", 0, 0, 255);
/*  43 */     this.backgroundColorBlueValue = new IntegerValue("Background-B", 0, 0, 255);
/*  44 */     this.backgroundColorAlphaValue = new IntegerValue("Background-Alpha", 95, 0, 255);
/*     */ 
/*     */     
/*  47 */     this.noshadow = new BoolValue("NoShadow", false);
/*  48 */     this.shadowShaderValue = new BoolValue("Shadow", false);
/*  49 */     this.shadowStrength = new FloatValue("Shadow-Strength", 0.0F, 0.0F, 30.0F);
/*     */     
/*  51 */     this.radius = new FloatValue("Radius", 0.0F, 0.0F, 10.0F);
/*  52 */     this.domainrainbow = new BoolValue("Domain-Rainbow", false);
/*  53 */     this.dred = new IntegerValue("Domain-R", 0, 0, 255);
/*  54 */     this.dgreen = new IntegerValue("Domain-G", 111, 0, 255);
/*  55 */     this.dblue = new IntegerValue("Domain-B", 255, 0, 255);
/*  56 */     this.blur = new BoolValue("Blur", true);
/*  57 */     this.blurStrength = new FloatValue("Blur-Strength", 2.0F, 0.0F, 50.0F);
/*  58 */     this.outline = new BoolValue("Novo-Outline", false);
/*  59 */     this.linewidth = new FloatValue("OutlineWidth", 2.0F, 0.0F, 5.0F);
/*  60 */     this.serverValue = new ListValue("ServerIp", new String[] { "None", "ClientName" }, "ClientName");
/*  61 */     this.noPointValue = new BoolValue("NoPoints", false);
/*  62 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.minecraftFont, "Fonts.minecraftFont"); this.fontValue = new FontValue("Font", Fonts.minecraftFont);
/*     */     
/*  64 */     this.allowedDomains = new String[] { ".ac", ".academy", ".accountant", ".accountants", ".actor", ".adult", ".ag", ".agency", ".ai", ".airforce", ".am", ".amsterdam", ".apartments", ".app", ".archi", ".army", ".art", ".asia", ".associates", ".at", ".attorney", ".au", ".auction", ".auto", ".autos", ".baby", ".band", ".bar", ".barcelona", ".bargains", ".bayern", ".be", ".beauty", ".beer", ".berlin", ".best", ".bet", ".bid", ".bike", ".bingo", ".bio", ".biz", ".biz.pl", ".black", ".blog", ".blue", ".boats", ".boston", ".boutique", ".build", ".builders", ".business", ".buzz", ".bz", ".ca", ".cab", ".cafe", ".camera", ".camp", ".capital", ".car", ".cards", ".care", ".careers", ".cars", ".casa", ".cash", ".casino", ".catering", ".cc", ".center", ".ceo", ".ch", ".charity", ".chat", ".cheap", ".church", ".city", ".cl", ".claims", ".cleaning", ".clinic", ".clothing", ".cloud", ".club", ".cn", ".co", ".co.in", ".co.jp", ".co.kr", ".co.nz", ".co.uk", ".co.za", ".coach", ".codes", ".coffee", ".college", ".com", ".com.ag", ".com.au", ".com.br", ".com.bz", ".com.cn", ".com.co", ".com.es", ".com.mx", ".com.pe", ".com.ph", ".com.pl", ".com.ru", ".com.tw", ".community", ".company", ".computer", ".condos", ".construction", ".consulting", ".contact", ".contractors", ".cooking", ".cool", ".country", ".coupons", ".courses", ".credit", ".creditcard", ".cricket", ".cruises", ".cymru", ".cz", ".dance", ".date", ".dating", ".de", ".deals", ".degree", ".delivery", ".democrat", ".dental", ".dentist", ".design", ".dev", ".diamonds", ".digital", ".direct", ".directory", ".discount", ".dk", ".doctor", ".dog", ".domains", ".download", ".earth", ".education", ".email", ".energy", ".engineer", ".engineering", ".enterprises", ".equipment", ".es", ".estate", ".eu", ".events", ".exchange", ".expert", ".exposed", ".express", ".fail", ".faith", ".family", ".fan", ".fans", ".farm", ".fashion", ".film", ".finance", ".financial", ".firm.in", ".fish", ".fishing", ".fit", ".fitness", ".flights", ".florist", ".fm", ".football", ".forsale", ".foundation", ".fr", ".fun", ".fund", ".furniture", ".futbol", ".fyi", ".gallery", ".games", ".garden", ".gay", ".gen.in", ".gg", ".gifts", ".gives", ".glass", ".global", ".gmbh", ".gold", ".golf", ".graphics", ".gratis", ".green", ".gripe", ".group", ".gs", ".guide", ".guru", ".hair", ".haus", ".health", ".healthcare", ".hockey", ".holdings", ".holiday", ".homes", ".horse", ".hospital", ".host", ".house", ".idv.tw", ".immo", ".immobilien", ".in", ".inc", ".ind.in", ".industries", ".info", ".info.pl", ".ink", ".institute", ".insure", ".international", ".investments", ".io", ".irish", ".ist", ".istanbul", ".it", ".jetzt", ".jewelry", ".jobs", ".jp", ".kaufen", ".kim", ".kitchen", ".kiwi", ".kr", ".la", ".land", ".law", ".lawyer", ".lease", ".legal", ".lgbt", ".life", ".lighting", ".limited", ".limo", ".live", ".llc", ".loan", ".loans", ".london", ".love", ".ltd", ".ltda", ".luxury", ".maison", ".makeup", ".management", ".market", ".marketing", ".mba", ".me", ".me.uk", ".media", ".melbourne", ".memorial", ".men", ".menu", ".miami", ".mobi", ".moda", ".moe", ".money", ".monster", ".mortgage", ".motorcycles", ".movie", ".ms", ".mx", ".nagoya", ".name", ".navy", ".ne.kr", ".net", ".net.ag", ".net.au", ".net.br", ".net.bz", ".net.cn", ".net.co", ".net.in", ".net.nz", ".net.pe", ".net.ph", ".net.pl", ".net.ru", ".network", ".news", ".ninja", ".nl", ".no", ".nom.co", ".nom.es", ".nom.pe", ".nrw", ".nyc", ".okinawa", ".one", ".onl", ".online", ".org", ".org.ag", ".org.au", ".org.cn", ".org.es", ".org.in", ".org.nz", ".org.pe", ".org.ph", ".org.pl", ".org.ru", ".org.uk", ".page", ".paris", ".partners", ".parts", ".party", ".pe", ".pet", ".ph", ".photography", ".photos", ".pictures", ".pink", ".pizza", ".pl", ".place", ".plumbing", ".plus", ".poker", ".porn", ".press", ".pro", ".productions", ".promo", ".properties", ".protection", ".pub", ".pw", ".quebec", ".quest", ".racing", ".re.kr", ".realestate", ".recipes", ".red", ".rehab", ".reise", ".reisen", ".rent", ".rentals", ".repair", ".report", ".republican", ".rest", ".restaurant", ".review", ".reviews", ".rich", ".rip", ".rocks", ".rodeo", ".ru", ".run", ".ryukyu", ".sale", ".salon", ".sarl", ".school", ".schule", ".science", ".se", ".security", ".services", ".sex", ".sg", ".sh", ".shiksha", ".shoes", ".shop", ".shopping", ".show", ".singles", ".site", ".ski", ".skin", ".soccer", ".social", ".software", ".solar", ".solutions", ".space", ".storage", ".store", ".stream", ".studio", ".study", ".style", ".supplies", ".supply", ".support", ".surf", ".surgery", ".sydney", ".systems", ".tax", ".taxi", ".team", ".tech", ".technology", ".tel", ".tennis", ".theater", ".theatre", ".tienda", ".tips", ".tires", ".today", ".tokyo", ".tools", ".tours", ".town", ".toys", ".top", ".trade", ".training", ".travel", ".tube", ".tv", ".tw", ".uk", ".university", ".uno", ".us", ".vacations", ".vegas", ".ventures", ".vet", ".viajes", ".video", ".villas", ".vin", ".vip", ".vision", ".vodka", ".vote", ".voto", ".voyage", ".wales", ".watch", ".webcam", ".website", ".wedding", ".wiki", ".win", ".wine", ".work", ".works", ".world", ".ws", ".wtf", ".xxx", ".xyz", ".yachts", ".yoga", ".yokohama", ".zone", "花雨庭", "855712180" };
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "input", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/IScore;", "apply"})
/*     */   static final class ScoreboardElement$drawElement$scores$1<T>
/*     */     implements Predicate<T>
/*     */   {
/*     */     public static final ScoreboardElement$drawElement$scores$1 INSTANCE = new ScoreboardElement$drawElement$scores$1();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean apply(@Nullable IScore input) {
/*  94 */       return (((input != null) ? input.getPlayerName() : null) != null && !StringsKt.startsWith$default(input.getPlayerName(), "#", false, 2, null));
/*     */     }
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class ScoreboardElement$drawElement$1
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     public final void invoke() {
/* 123 */       GL11.glPushMatrix();
/* 124 */       GL11.glTranslated(ScoreboardElement.this.getRenderX(), ScoreboardElement.this.getRenderY(), 0.0D);
/* 125 */       GL11.glScalef(ScoreboardElement.this.getScale(), ScoreboardElement.this.getScale(), ScoreboardElement.this.getScale());
/* 126 */       RenderUtils.drawRoundedRect(this.$l1 - 7.0F, -5.0F, 9.0F, (this.$maxHeight + this.$fontRenderer.getFontHeight() + 5), ((Number)ScoreboardElement.this.radius.get()).floatValue(), this.$backColor2);
/* 127 */       GL11.glPopMatrix();
/*     */     } ScoreboardElement$drawElement$1(int param1Int1, int param1Int2, IFontRenderer param1IFontRenderer, int param1Int3) { super(0); }
/* 129 */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class ScoreboardElement$drawElement$2 extends Lambda implements Function0<Unit> { ScoreboardElement$drawElement$2(int param1Int1, int param1Int2, IFontRenderer param1IFontRenderer, int param1Int3) { super(0); } public final void invoke() { GL11.glPushMatrix();
/* 130 */       GL11.glTranslated(ScoreboardElement.this.getRenderX(), ScoreboardElement.this.getRenderY(), 0.0D);
/* 131 */       GL11.glScalef(ScoreboardElement.this.getScale(), ScoreboardElement.this.getScale(), ScoreboardElement.this.getScale());
/* 132 */       GlStateManager.func_179147_l();
/* 133 */       GlStateManager.func_179090_x();
/* 134 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 135 */       RenderUtils.drawRoundedRect(this.$l1 - 7.0F, -5.0F, 9.0F, (this.$maxHeight + this.$fontRenderer.getFontHeight() + 5), ((Number)ScoreboardElement.this.radius.get()).floatValue(), this.$backColor2);
/* 136 */       GlStateManager.func_179098_w();
/* 137 */       GlStateManager.func_179084_k();
/* 138 */       GL11.glPopMatrix(); } } @Nullable public Border drawElement() { IScoreboard scoreboard; int maxWidth, maxHeight, index$iv; Iterator iterator; IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get(); int textColor = textColor().getRGB(); int backColor = backgroundColor().getRGB(); int backColor2 = backgroundColor2().getRGB(); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IScoreboard worldScoreboard = MinecraftInstance.mc.getTheWorld().getScoreboard(); IScoreObjective currObjective = (IScoreObjective)null; if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe();  ITeam playerTeam = worldScoreboard.getPlayersTeam(MinecraftInstance.mc.getThePlayer().getName()); if (playerTeam != null) { int colorIndex = playerTeam.getChatFormat().getColorIndex(); if (colorIndex >= 0)
/* 140 */         currObjective = worldScoreboard.getObjectiveInDisplaySlot(3 + colorIndex);  }  if (currObjective == null); if (worldScoreboard.getObjectiveInDisplaySlot(1) != null) { IScoreObjective objective = worldScoreboard.getObjectiveInDisplaySlot(1); scoreboard = objective.getScoreboard(); Object scoreCollection = scoreboard.getSortedScores(objective); ArrayList scores = Lists.newArrayList(Iterables.filter((Iterable)scoreCollection, ScoreboardElement$drawElement$scores$1.INSTANCE)); Intrinsics.checkExpressionValueIsNotNull(Lists.newArrayList(Iterables.skip(scores, scoreCollection.size() - 15)), "Lists.newArrayList(Itera…oreCollection.size - 15))"); Intrinsics.checkExpressionValueIsNotNull(scores, "scores"); scoreCollection = (scores.size() > 15) ? Lists.newArrayList(Iterables.skip(scores, scoreCollection.size() - 15)) : scores; maxWidth = fontRenderer.getStringWidth(objective.getDisplayName()); for (IScore score : scoreCollection) { ITeam scorePlayerTeam = scoreboard.getPlayersTeam(score.getPlayerName()); String width = MinecraftInstance.functions.scoreboardFormatPlayerName(scorePlayerTeam, score.getPlayerName()) + ": " + WEnumChatFormatting.RED + score.getScorePoints(); maxWidth = RangesKt.coerceAtLeast(maxWidth, fontRenderer.getStringWidth(width)); }  maxHeight = scoreCollection.size() * fontRenderer.getFontHeight(); int l1 = -maxWidth - 3 - 0; if (((Boolean)this.shadowShaderValue.get()).booleanValue()) { GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D); GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPushMatrix(); ShadowUtils.shadow(((Number)this.shadowStrength.get()).floatValue(), new ScoreboardElement$drawElement$1(l1, maxHeight, fontRenderer, backColor2), new ScoreboardElement$drawElement$2(l1, maxHeight, fontRenderer, backColor2)); GL11.glPopMatrix();
/* 141 */         GL11.glScalef(getScale(), getScale(), getScale());
/* 142 */         GL11.glTranslated(getRenderX(), getRenderY(), 0.0D); }
/*     */ 
/*     */       
/* 145 */       RenderUtils.drawRoundedRect(l1 - 7.0F, -5.0F, 9.0F, (maxHeight + fontRenderer.getFontHeight() + 5), ((Number)this.radius.get()).floatValue(), backColor);
/*     */ 
/*     */       
/* 148 */       if (((Boolean)this.blur.get()).booleanValue()) {
/* 149 */         GL11.glTranslated(-getRenderX(), -getRenderY(), 0.0D);
/* 150 */         BlurBuffer.CustomBlurRoundArea(
/* 151 */             (float)getRenderX() + l1 - 7.0F, 
/* 152 */             (float)getRenderY() - 5.0F, 
/* 153 */             -l1 + 16.0F, (
/* 154 */             maxHeight + fontRenderer.getFontHeight()) + 10.0F, (
/* 155 */             (Number)this.radius.get()).floatValue(), (
/* 156 */             (Number)this.blurStrength.get()).floatValue());
/*     */         
/* 158 */         GL11.glTranslated(getRenderX(), getRenderY(), 0.0D);
/*     */       } 
/* 160 */       if (((Boolean)this.outline.get()).booleanValue()) {
/* 161 */         RenderUtils.drawGidentOutlinedRoundedRect(l1 - 7.0D, -5.0D, 8.0D - l1 - 7.0D, (maxHeight + fontRenderer.getFontHeight() + 5) - -5.0D, ((Number)this.radius.get()).floatValue(), ((Number)this.linewidth.get()).floatValue());
/*     */       }
/*     */       
/* 164 */       if (!((Boolean)this.noshadow.get()).booleanValue()) {
/* 165 */         RenderUtils.drawShadowWithCustomAlpha(l1 - 7.0F, -5.0F, -l1 + 16.0F, (maxHeight + fontRenderer.getFontHeight()) + 10.0F, 255.0F);
/*     */       }
/* 167 */       Iterable $this$forEachIndexed$iv = (Iterable)scoreCollection; int $i$f$forEachIndexed = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 246 */       index$iv = 0;
/* 247 */       iterator = $this$forEachIndexed$iv.iterator(); } else { worldScoreboard.getObjectiveInDisplaySlot(1); return null; }  if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; IScore iScore = (IScore)item$iv; int index = j, $i$a$-forEachIndexed-ScoreboardElement$drawElement$3 = 0;
/*     */       ITeam team = scoreboard.getPlayersTeam(iScore.getPlayerName());
/*     */       String name = MinecraftInstance.functions.scoreboardFormatPlayerName(team, iScore.getPlayerName());
/*     */       String scorePoints = WEnumChatFormatting.RED + iScore.getScorePoints();
/*     */       int width = 5;
/*     */       int height = maxHeight - index * fontRenderer.getFontHeight();
/*     */       GlStateManager.func_179117_G();
/*     */       int listColor = textColor; }
/*     */     
/*     */     return new Border(-(maxWidth) - 10.0F - false, -5.0F, 9.0F, maxHeight + fontRenderer.getFontHeight()); }
/*     */ 
/*     */   
/*     */   private final Color backgroundColor() {
/*     */     return new Color(((Number)this.backgroundColorRedValue.get()).intValue(), ((Number)this.backgroundColorGreenValue.get()).intValue(), ((Number)this.backgroundColorBlueValue.get()).intValue(), ((Number)this.backgroundColorAlphaValue.get()).intValue());
/*     */   }
/*     */   
/*     */   private final Color backgroundColor2() {
/*     */     return new Color(((Number)this.backgroundColorRedValue.get()).intValue(), ((Number)this.backgroundColorGreenValue.get()).intValue(), ((Number)this.backgroundColorBlueValue.get()).intValue());
/*     */   }
/*     */   
/*     */   private final Color textColor() {
/*     */     return new Color(((Number)this.textRedValue.get()).intValue(), ((Number)this.textGreenValue.get()).intValue(), ((Number)this.textBlueValue.get()).intValue());
/*     */   }
/*     */   
/*     */   public ScoreboardElement() {
/*     */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\ScoreboardElement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */