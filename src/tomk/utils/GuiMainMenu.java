/*     */ package tomk.utils;
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\021\n\002\030\002\n\002\b\006\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\b\n\002\b\013\030\0002\0020\001B\005¢\006\002\020\002J \020\037\032\0020 2\006\020!\032\0020\"2\006\020#\032\0020\"2\006\020$\032\0020\027H\026J\006\020%\032\0020\007J\006\020&\032\0020\007J\b\020'\032\0020 H\026J\030\020(\032\0020\0072\006\020)\032\0020\0072\006\020*\032\0020\007H\002J \020+\032\0020 2\006\020!\032\0020\"2\006\020#\032\0020\"2\006\020,\032\0020\"H\024R\016\020\003\032\0020\004X\016¢\006\002\n\000R\032\020\005\032\b\022\004\022\0020\0070\0068BX\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\0020\004XD¢\006\b\n\000\032\004\b\013\020\fR\016\020\r\032\0020\016X\016¢\006\002\n\000R\016\020\017\032\0020\016X\016¢\006\002\n\000R\032\020\020\032\0020\021X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025R\016\020\026\032\0020\027X\016¢\006\002\n\000R\016\020\030\032\0020\027X\016¢\006\002\n\000R\034\020\031\032\004\030\0010\032X\016¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036¨\006-"}, d2 = {"Ltomk/utils/GuiMainMenu;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "Alt", "", "clientColors", "", "Ljava/awt/Color;", "getClientColors", "()[Ljava/awt/Color;", "hueInterpolation", "getHueInterpolation", "()Z", "lastMS", "", "lastMS2", "mc", "Lnet/minecraft/client/Minecraft;", "getMc", "()Lnet/minecraft/client/Minecraft;", "setMc", "(Lnet/minecraft/client/Minecraft;)V", "progress", "", "progress2", "sr", "Lnet/minecraft/client/gui/ScaledResolution;", "getSr", "()Lnet/minecraft/client/gui/ScaledResolution;", "setSr", "(Lnet/minecraft/client/gui/ScaledResolution;)V", "drawScreen", "", "mouseX", "", "mouseY", "partialTicks", "getAlternateClientColor", "getClientColor", "initGui", "mixColors", "color1", "color2", "mouseClicked", "mouseButton", "XSJClient"})
/*     */ public final class GuiMainMenu extends GuiScreen {
/*     */   @NotNull
/*     */   private Minecraft mc;
/*     */   @Nullable
/*     */   private ScaledResolution sr;
/*     */   private float progress;
/*     */   private float progress2;
/*     */   private boolean Alt;
/*     */   private long lastMS;
/*     */   private long lastMS2;
/*     */   private final boolean hueInterpolation = false;
/*     */   
/*     */   public GuiMainMenu() {
/*  27 */     Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); this.mc = Minecraft.func_71410_x();
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
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class GuiMainMenu$drawScreen$7
/*     */     extends Lambda
/*     */     implements Function0<Unit>
/*     */   {
/*     */     GuiMainMenu$drawScreen$7(ScaledResolution param1ScaledResolution) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 204 */       GL11.glPushMatrix();
/* 205 */       GlStateManager.func_179147_l();
/* 206 */       GlStateManager.func_179090_x();
/* 207 */       GlStateManager.func_179120_a(770, 771, 1, 0);
/* 208 */       Fonts.font35.drawCenteredString(
/* 209 */           "By:XSJ Client-Team", 
/* 210 */           this.$sr.func_78326_a() / 2.0F - 5, 
/* 211 */           this.$sr.func_78328_b() - 5.0F - Fonts.font35.getFontHeight(), (
/* 212 */           new Color(200, 200, 200)).getRGB(), 
/* 213 */           true);
/*     */       
/* 215 */       Fonts.tenacitybold50.drawCenteredString(
/* 216 */           "v2.3 New Year's Special Edition", 70.0F, 27.0F, (
/* 217 */           new Color(235, 235, 235)).getRGB(), false);
/*     */ 
/*     */       
/* 220 */       GlStateManager.func_179098_w();
/* 221 */       GlStateManager.func_179084_k();
/* 222 */       GL11.glPopMatrix();
/*     */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class GuiMainMenu$drawScreen$6 extends Lambda implements Function0<Unit> {
/*     */     public final void invoke() { GL11.glPushMatrix(); Fonts.font35.drawCenteredString("By:XSJ Client-Team", this.$sr.func_78326_a() / 2.0F - 5, this.$sr.func_78328_b() - 5.0F - Fonts.font35.getFontHeight(), (new Color(200, 200, 200)).getRGB(), true); Fonts.tenacitybold50.drawCenteredString("v2.3 New Year's Special Edition", 70.0F, 27.0F, (new Color(235, 235, 235)).getRGB(), false); GL11.glPopMatrix(); } GuiMainMenu$drawScreen$6(ScaledResolution param1ScaledResolution) { super(0); }
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class GuiMainMenu$drawScreen$5 extends Lambda implements Function0<Unit> { public final void invoke() { GL11.glPushMatrix(); GlStateManager.func_179147_l(); GlStateManager.func_179090_x(); GlStateManager.func_179120_a(770, 771, 1, 0); RenderUtils.drawRoundedRectfix(this.$sr.func_78326_a() / 2.0F - 90, this.$sr.func_78328_b() / 2.0F - 67 - 40, 172.0F, 187.0F, 12.0F, (new Color(0, 0, 0)).getRGB()); GlStateManager.func_179098_w(); GlStateManager.func_179084_k(); GL11.glPopMatrix(); } GuiMainMenu$drawScreen$5(ScaledResolution param1ScaledResolution) { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class GuiMainMenu$drawScreen$4 extends Lambda implements Function0<Unit> {
/*     */     public final void invoke() { GL11.glPushMatrix(); RenderUtils.drawRoundedRectfix(this.$sr.func_78326_a() / 2.0F - 90, this.$sr.func_78328_b() / 2.0F - 67 - 40, 172.0F, 187.0F, 12.0F, (new Color(0, 0, 0)).getRGB()); GL11.glPopMatrix(); } GuiMainMenu$drawScreen$4(ScaledResolution param1ScaledResolution) { super(0); }
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class GuiMainMenu$drawScreen$3 extends Lambda implements Function0<Unit> { public static final GuiMainMenu$drawScreen$3 INSTANCE = new GuiMainMenu$drawScreen$3(); public final void invoke() { GL11.glPushMatrix(); GlStateManager.func_179147_l(); GlStateManager.func_179090_x(); GlStateManager.func_179120_a(770, 771, 1, 0); RenderUtils.drawRoundedRectfix(50.0F, 0.0F, 40, 40.0F, 1.0F, (new Color(0, 0, 0)).getRGB()); GlStateManager.func_179098_w(); GlStateManager.func_179084_k(); GL11.glPopMatrix(); } GuiMainMenu$drawScreen$3() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class GuiMainMenu$drawScreen$2 extends Lambda implements Function0<Unit> {
/*     */     public static final GuiMainMenu$drawScreen$2 INSTANCE = new GuiMainMenu$drawScreen$2(); public final void invoke() { GL11.glPushMatrix(); RenderUtils.drawRoundedRectfix(50.0F, 0.0F, 40, 40.0F, 1.0F, (new Color(0, 0, 0)).getRGB()); GL11.glPopMatrix(); } GuiMainMenu$drawScreen$2() { super(0); }
/* 229 */   } @NotNull public final Minecraft getMc() { return this.mc; } protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException { this.progress = (this.progress >= 1.0F) ? 1.0F : ((float)(System.currentTimeMillis() - this.lastMS) / 2000.0F);
/* 230 */     double trueAnim = EaseUtils2.easeOutQuart(this.progress);
/*     */     
/* 232 */     GL11.glTranslated(0.0D, (true - trueAnim) * -this.field_146295_m, 0.0D);
/*     */ 
/*     */     
/* 235 */     if (this.sr == null) Intrinsics.throwNpe();  if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F - 60 + 5, 119, 25.0F, 
/* 236 */         mouseX, mouseY)) {
/* 237 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiWorldSelection(this));
/*     */     }
/*     */ 
/*     */     
/* 241 */     if (this.sr == null) Intrinsics.throwNpe();  if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F - 33 + 5, 124, 20.0F, 
/* 242 */         mouseX, mouseY)) {
/* 243 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiMultiplayer(this));
/*     */     }
/*     */ 
/*     */     
/* 247 */     if (this.sr == null) Intrinsics.throwNpe();  if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F - 6 + 8, 109, 20.0F, 
/* 248 */         mouseX, mouseY)) {
/* 249 */       Retreat.INSTANCE.getWrapper().getMinecraft().displayGuiScreen(Retreat.INSTANCE.getWrapper().getClassProvider().wrapGuiScreen((WrappedGuiScreen)new GuiAltManager()));
/* 250 */       this.Alt = !this.Alt;
/*     */     } 
/*     */     
/* 253 */     if (this.sr == null) Intrinsics.throwNpe();  if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F + 21 + 12, 119, 20.0F, 
/* 254 */         mouseX, mouseY))
/* 255 */       Minecraft.func_71410_x().func_71400_g();  }
/*     */   public final void setMc(@NotNull Minecraft <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.mc = <set-?>; } @Nullable public final ScaledResolution getSr() { return this.sr; } public final void setSr(@Nullable ScaledResolution <set-?>) { this.sr = <set-?>; } public void func_73866_w_() { this.sr = new ScaledResolution(Minecraft.func_71410_x()); this.lastMS = System.currentTimeMillis(); this.progress = 0.0F; } public void func_73863_a(int mouseX, int mouseY, float partialTicks) { int i; func_146278_c(0); ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x()); int length = 2; ArrayList list = Retreat.INSTANCE.getUPDATE_LIST(); Fonts.font35.drawCenteredString("By:XSJ Client-Team", sr.func_78326_a() / 2.0F - 5, sr.func_78328_b() - 5.0F - Fonts.font35.getFontHeight(), (new Color(200, 200, 200)).getRGB(), true); this.progress = (this.progress >= 1.0F) ? 1.0F : ((float)(System.currentTimeMillis() - this.lastMS) / 2050.0F); double trueAnim = EaseUtils2.easeOutQuart(this.progress); GL11.glTranslated(0.0D, (true - trueAnim) * -sr.func_78328_b(), 0.0D); Color[] clientColors = getClientColors(); GradientUtil.applyGradientHorizontal((float)((sr.func_78326_a() / 2.0F) - 5.0D), (float)((sr.func_78328_b() / 2.0F) - 90.0D), Fonts.Bnk40.getStringWidth("XSJ Client"), 20.0F, 1.0F, clientColors[0], clientColors[1], new GuiMainMenu$drawScreen$1(sr)); GaussianBlur.startBlur(); RenderUtils.drawRoundedRectfix(50.0F, 0.0F, 40, 40.0F, 1.0F, (new Color(0, 0, 0)).getRGB()); GaussianBlur.endBlur(20.0F, 2.0F); RoundedUtil.drawRoundOutline(50.0F, -2.0F, 40, 42.0F, 1.0F, 0.05F, new Color(240, 240, 240, 18), new Color(255, 255, 255)); ShadowUtils.shadow(6.0F, GuiMainMenu$drawScreen$2.INSTANCE, GuiMainMenu$drawScreen$3.INSTANCE); Fonts.tenacitybold50.drawCenteredString("v2.3 New Year's Special Edition", 70.0F, 27.0F, (new Color(235, 235, 235)).getRGB(), false); if (RenderUtils.isHovered(50.0F, 0.0F, 40, 40.0F, mouseX, mouseY)) { GL11.glTranslated(0.0D, (true - trueAnim) * -sr.func_78328_b(), 0.0D); Iterator iterator; for (byte b = 0; iterator.hasNext(); ) { iterator.next(); length += b ? (Fonts.font40.getFontHeight() + 2) : (Fonts.font35.getFontHeight() + 2); b++; }  length = 2; for (i = 0, iterator = list.iterator(); iterator.hasNext(); ) { iterator.next(); Intrinsics.checkExpressionValueIsNotNull(list.get(i), "list[i]"); Fonts.font35.drawString((String)list.get(i), 2.0F, length + 33, (new Color(255, 255, 255, 255)).getRGB(), true); Intrinsics.checkExpressionValueIsNotNull(list.get(i), "list[i]"); Fonts.font35.drawString((String)list.get(i), 2.0F, length + 33, (new Color(255, 255, 255, 255)).getRGB(), true); length += (i <= 0) ? (Fonts.font35.getFontHeight() + 2) : (Fonts.font35.getFontHeight() + 2); i++; }  }  ShadowUtils.shadow(9.0F, new GuiMainMenu$drawScreen$4(sr), new GuiMainMenu$drawScreen$5(sr)); RoundedUtil.drawRoundOutline(sr.func_78326_a() / 2.0F - 90, sr.func_78328_b() / 2.0F - 67 - 40, 172.0F, 187.0F, 12.0F, 0.05F, new Color(240, 240, 240, 12), new Color(255, 255, 255)); int Color = (new Color(255, 255, 255)).getRGB(); int a = 0; if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F - 60 + 2, 119, 25.0F, mouseX, mouseY)) { i = (new Color(104, 104, 104)).getRGB(); a = 18; }  RoundedUtil.drawRoundOutline(sr.func_78326_a() / 2.0F - 12 - 45 - 10, sr.func_78328_b() / 2.0F - 67 + 5, '', 25, 12.0F, 0.1F, new Color(240, 240, 240, a), new Color(255, 255, 255)); Fonts.font35.drawCenteredString("SinglePlayer", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F - 55 + 2, i, true); int Color2 = (new Color(255, 255, 255)).getRGB(); int a2 = 0; if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F - 33 + 5, 124, 20.0F, mouseX, mouseY)) { Color2 = (new Color(104, 104, 104)).getRGB(); a2 = 18; }  RoundedUtil.drawRoundOutline(sr.func_78326_a() / 2.0F - 12 - 45 - 10, sr.func_78328_b() / 2.0F - 67 + 20 + 15, '', 25, 12.0F, 0.1F, new Color(240, 240, 240, a2), new Color(255, 255, 255)); Fonts.font35.drawCenteredString("MultiPlayer", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F - 13 - 10, Color2, true); int Color4 = (new Color(255, 255, 255)).getRGB(); int a3 = 0; if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F - 6 + 8, 119, 20.0F, mouseX, mouseY)) { Color4 = (new Color(104, 104, 104)).getRGB(); a3 = 18; }  RoundedUtil.drawRoundOutline(sr.func_78326_a() / 2.0F - 12 - 45 - 10, sr.func_78328_b() / 2.0F - 67 + 20 + 45, '', 25, 12.0F, 0.1F, new Color(240, 240, 240, a3), new Color(255, 255, 255)); Fonts.font35.drawCenteredString("Alts", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F - true + 8, Color4, true); int Color5 = (new Color(255, 255, 255)).getRGB(); int a4 = 0; if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F + 21 + 12, 119, 20.0F, mouseX, mouseY)) { Color5 = (new Color(104, 104, 104)).getRGB(); a4 = 18; }  RoundedUtil.drawRoundOutline(sr.func_78326_a() / 2.0F - 12 - 45 - 10, sr.func_78328_b() / 2.0F - 67 + 20 + 75, '', 25, 12.0F, 0.1F, new Color(240, 240, 240, a4), new Color(255, 255, 255)); Fonts.font35.drawCenteredString("Shutdown", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F + 26 + 12, Color5, true); ShadowUtils.shadow(6.0F, new GuiMainMenu$drawScreen$6(sr), new GuiMainMenu$drawScreen$7(sr)); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}) static final class GuiMainMenu$drawScreen$1 implements Runnable {
/*     */     public final void run() { RenderUtils.setAlphaLimit(0.0F); BloomUtil.drawAndBloom(new RenderCallback() { public final void render() { Fonts.Bnk40.drawCenteredString("XSJ Client", (float)((GuiMainMenu$drawScreen$1.this.$sr.func_78326_a() / 2.0F) - 5.0D), (float)((GuiMainMenu$drawScreen$1.this.$sr.func_78328_b() / 2.0F) - 90.0D), (new Color(0, 0, 0, 0)).getRGB()); } }
/*     */         ); } GuiMainMenu$drawScreen$1(ScaledResolution param1ScaledResolution) {}
/* 259 */   } @NotNull public final Color getClientColor() { return new Color(255, 255, 255); }
/*     */   
/*     */   @NotNull
/*     */   public final Color getAlternateClientColor() {
/* 263 */     return new Color(120, 120, 120);
/*     */   } public final boolean getHueInterpolation() {
/* 265 */     return this.hueInterpolation;
/*     */   } private final Color mixColors(Color color1, Color color2) {
/* 267 */     Intrinsics.checkExpressionValueIsNotNull(ColorUtil.interpolateColorsBackAndForth(
/* 268 */           15, 
/* 269 */           1, 
/* 270 */           color1, 
/* 271 */           color2, 
/* 272 */           this.hueInterpolation), "ColorUtil.interpolateCol…ueInterpolation\n        )"); return ColorUtil.interpolateColorsBackAndForth(15, 1, color1, color2, this.hueInterpolation);
/*     */   }
/*     */   
/*     */   private final Color[] getClientColors() {
/* 276 */     Color firstColor = null;
/* 277 */     Color secondColor = null;
/*     */     
/* 279 */     firstColor = mixColors(getClientColor(), getAlternateClientColor());
/*     */     
/* 281 */     secondColor = mixColors(getAlternateClientColor(), getClientColor());
/* 282 */     return new Color[] { firstColor, secondColor };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tom\\utils\GuiMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */