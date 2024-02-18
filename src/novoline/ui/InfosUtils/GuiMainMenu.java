/*     */ package novoline.ui.InfosUtils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.EaseUtils2;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import novoline.font.Fonts;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\b\n\002\b\006\030\0002\0020\001B\005¢\006\002\020\002J \020\027\032\0020\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\017H\026J\b\020\035\032\0020\030H\026J \020\036\032\0020\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\037\032\0020\032H\024R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\006X\016¢\006\002\n\000R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\017X\016¢\006\002\n\000R\034\020\021\032\004\030\0010\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026¨\006 "}, d2 = {"Lnovoline/ui/InfosUtils/GuiMainMenu;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "Alt", "", "lastMS", "", "lastMS2", "mc", "Lnet/minecraft/client/Minecraft;", "getMc", "()Lnet/minecraft/client/Minecraft;", "setMc", "(Lnet/minecraft/client/Minecraft;)V", "progress", "", "progress2", "sr", "Lnet/minecraft/client/gui/ScaledResolution;", "getSr", "()Lnet/minecraft/client/gui/ScaledResolution;", "setSr", "(Lnet/minecraft/client/gui/ScaledResolution;)V", "drawScreen", "", "mouseX", "", "mouseY", "partialTicks", "initGui", "mouseClicked", "mouseButton", "XSJClient"})
/*     */ public final class GuiMainMenu extends GuiScreen {
/*     */   @NotNull
/*     */   private Minecraft mc;
/*     */   @Nullable
/*     */   private ScaledResolution sr;
/*     */   private float progress;
/*     */   
/*  25 */   public GuiMainMenu() { Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); this.mc = Minecraft.func_71410_x(); } private float progress2; private boolean Alt; private long lastMS; private long lastMS2; @NotNull public final Minecraft getMc() { return this.mc; } public final void setMc(@NotNull Minecraft <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.mc = <set-?>; } @Nullable
/*  26 */   public final ScaledResolution getSr() { return this.sr; } public final void setSr(@Nullable ScaledResolution <set-?>) { this.sr = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  33 */     this.sr = new ScaledResolution(Minecraft.func_71410_x());
/*  34 */     this.lastMS = System.currentTimeMillis();
/*  35 */     this.progress = 0.0F;
/*     */   }
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/*  39 */     func_146278_c(0);
/*  40 */     ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
/*  41 */     int Color6 = (new Color(255, 255, 255)).getRGB();
/*  42 */     int Color7 = (new Color(255, 255, 255)).getRGB();
/*     */     
/*  44 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.NovolineIcon.NovolineIcon45.NovolineIcon45, "Fonts.NovolineIcon.NovolineIcon45.NovolineIcon45"); RenderUtils.drawCircle2(sr.func_78326_a() - 10.0F - 15.0F - 1.5F + (Fonts.NovolineIcon.NovolineIcon45.NovolineIcon45.stringWidth("G") / 2), 8.0F + (Fonts.NovolineIcon.NovolineIcon45.NovolineIcon45.getHeight() / 2), 13.0F, (new Color(24, 24, 24)).getRGB());
/*     */ 
/*     */ 
/*     */     
/*  48 */     Fonts.font35.drawCenteredString(
/*  49 */         "TomkClient 1.12.2", 
/*  50 */         sr.func_78326_a() / 2.0F, 
/*  51 */         sr.func_78328_b() - 5.0F - Fonts.font35.getFontHeight(), (
/*  52 */         new Color(200, 200, 200)).getRGB(), true);
/*     */     
/*  54 */     this.progress = (this.progress >= 1.0F) ? 1.0F : ((float)(System.currentTimeMillis() - this.lastMS) / 2000.0F);
/*     */     
/*  56 */     double trueAnim = EaseUtils2.easeOutQuart(this.progress);
/*     */     
/*  58 */     GL11.glTranslated(0.0D, (true - trueAnim) * -sr.func_78328_b(), 0.0D);
/*  59 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.NovolineIcon.NovolineIcon75.NovolineIcon75, "Fonts.NovolineIcon.NovolineIcon75.NovolineIcon75"); Fonts.tenacity100.drawCenteredString("TomkClient", sr.func_78326_a() / 2.0F, sr.func_78328_b() / 2.0F - 55 - 20 - Fonts.NovolineIcon.NovolineIcon75.NovolineIcon75.getHeight(), (
/*  60 */         new Color(110, 183, 225)).getRGB(), true);
/*     */     
/*  62 */     BlurBuffer.CustomBlurRoundArea(sr.func_78326_a() / 2.0F - 12 - 45 - 10, sr.func_78328_b() / 2.0F - 67, '', 115, 12.0F, 40.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     int Color = (new Color(39, 120, 186)).getRGB();
/*  71 */     if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F - 60, 119, 20.0F, mouseX, mouseY)) {
/*  72 */       Color = (new Color(63, 186, 213)).getRGB();
/*     */     }
/*     */ 
/*     */     
/*  76 */     Fonts.font35.drawCenteredString("SinglePlayer", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F - 55, 
/*  77 */         Color, true);
/*     */ 
/*     */     
/*  80 */     int Color2 = (new Color(39, 120, 186)).getRGB();
/*  81 */     if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F - 33, 119, 20.0F, mouseX, mouseY)) {
/*  82 */       Color2 = (new Color(63, 186, 213)).getRGB();
/*     */     }
/*     */ 
/*     */     
/*  86 */     Fonts.font35.drawCenteredString("MultiPlayer", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F - 28, 
/*  87 */         Color2, true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     int Color4 = (new Color(39, 120, 186)).getRGB();
/*  93 */     if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F - 6, 119, 20.0F, mouseX, mouseY)) {
/*  94 */       Color4 = (new Color(63, 186, 213)).getRGB();
/*     */     }
/*     */ 
/*     */     
/*  98 */     Fonts.font35.drawCenteredString("Alts", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F - true, 
/*  99 */         Color4, true);
/*     */ 
/*     */     
/* 102 */     int Color5 = (new Color(39, 120, 186)).getRGB();
/* 103 */     if (RenderUtils.isHovered(sr.func_78326_a() / 2.0F - 12 - 45 - 5, sr.func_78328_b() / 2.0F + 21, 119, 20.0F, mouseX, mouseY)) {
/* 104 */       Color5 = (new Color(63, 186, 213)).getRGB();
/*     */     }
/* 106 */     Fonts.font35.drawCenteredString("Shutdown", sr.func_78326_a() / 2.0F - 2.5F, sr.func_78328_b() / 2.0F + 26, 
/* 107 */         Color5, true);
/*     */ 
/*     */     
/* 110 */     RoundedUtil.drawRoundOutline(sr.func_78326_a() / 2.0F - 12 - 45 - 10, sr.func_78328_b() / 2.0F - 67, '', 115, 12.0F, 0.3F, new Color(240, 240, 240, 0), new Color(17, 34, 54));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 115 */     this.progress = (this.progress >= 1.0F) ? 1.0F : ((float)(System.currentTimeMillis() - this.lastMS) / 2000.0F);
/*     */     
/* 117 */     double trueAnim = EaseUtils2.easeOutQuart(this.progress);
/*     */     
/* 119 */     GL11.glTranslated(0.0D, (true - trueAnim) * -this.field_146295_m, 0.0D);
/*     */     
/* 121 */     if (this.sr == null) Intrinsics.throwNpe(); 
/* 122 */     if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F - 60, 
/* 123 */         119, 
/* 124 */         20.0F, 
/* 125 */         mouseX, 
/* 126 */         mouseY))
/*     */     {
/*     */       
/* 129 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiWorldSelection(this));
/*     */     }
/*     */     
/* 132 */     if (this.sr == null) Intrinsics.throwNpe(); 
/* 133 */     if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F - 33, 
/* 134 */         119, 
/* 135 */         20.0F, 
/* 136 */         mouseX, 
/* 137 */         mouseY))
/*     */     {
/*     */       
/* 140 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiMultiplayer(this));
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
/* 152 */     if (this.sr == null) Intrinsics.throwNpe(); 
/* 153 */     if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F - 6, 
/* 154 */         119, 
/* 155 */         20.0F, 
/* 156 */         mouseX, 
/* 157 */         mouseY)) {
/*     */ 
/*     */       
/* 160 */       Retreat.INSTANCE.getWrapper().getMinecraft().displayGuiScreen(Retreat.INSTANCE.getWrapper().getClassProvider().wrapGuiScreen((WrappedGuiScreen)new GuiAltManager()));
/*     */       
/* 162 */       this.Alt = !this.Alt;
/*     */     } 
/* 164 */     if (this.sr == null) Intrinsics.throwNpe(); 
/* 165 */     if (this.sr == null) Intrinsics.throwNpe();  if (RenderUtils.isHovered(this.sr.func_78326_a() / 2.0F - 12 - 45 - 5, this.sr.func_78328_b() / 2.0F + 21, 
/* 166 */         119, 
/* 167 */         20.0F, mouseX, mouseY))
/* 168 */       Minecraft.func_71410_x().func_71400_g(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novolin\\ui\InfosUtils\GuiMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */