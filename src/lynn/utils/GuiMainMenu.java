/*     */ package lynn.utils;
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedGuiScreen;
/*     */ import net.ccbluex.liquidbounce.ui.client.GuiBackground;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiLanguage;
/*     */ import net.minecraft.client.gui.GuiOptions;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiWorldSelection;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\013\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\016\n\002\b\004\030\0002\0020\001B\005¢\006\002\020\002J \020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\027H\026J\b\020\030\032\0020\022H\026J.\020\031\032\0020\0222\006\020\032\032\0020\0332\006\020\034\032\0020\0272\006\020\035\032\0020\0272\006\020\023\032\0020\0242\006\020\025\032\0020\024J \020\036\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0242\006\020\026\032\0020\024H\024R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\032\020\f\032\0020\004X\016¢\006\016\n\000\032\004\b\r\020\006\"\004\b\016\020\bR\020\020\017\032\004\030\0010\020X\016¢\006\002\n\000¨\006\037"}, d2 = {"Llynn/utils/GuiMainMenu;", "Lnet/minecraft/client/gui/GuiScreen;", "()V", "color1", "Ljava/awt/Color;", "getColor1", "()Ljava/awt/Color;", "setColor1", "(Ljava/awt/Color;)V", "color2", "getColor2", "setColor2", "color3", "getColor3", "setColor3", "sr", "Lnet/minecraft/client/gui/ScaledResolution;", "drawScreen", "", "mouseX", "", "mouseY", "p", "", "initGui", "isHoveredText", "text", "", "x", "y", "mouseClicked", "XSJClient"})
/*     */ public final class GuiMainMenu extends GuiScreen {
/*     */   @NotNull
/*  21 */   private Color color1 = new Color(30, 30, 30, 255); private ScaledResolution sr; @NotNull public final Color getColor1() { return this.color1; } public final void setColor1(@NotNull Color <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.color1 = <set-?>; } @NotNull
/*  22 */   private Color color2 = new Color(30, 30, 30, 255); @NotNull public final Color getColor2() { return this.color2; } public final void setColor2(@NotNull Color <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.color2 = <set-?>; } @NotNull
/*  23 */   private Color color3 = new Color(30, 30, 30, 255); @NotNull public final Color getColor3() { return this.color3; } public final void setColor3(@NotNull Color <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.color3 = <set-?>; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float p) {
/*  28 */     ScaledResolution sr = new ScaledResolution(this.field_146297_k);
/*  29 */     RenderUtils.drawImage(new ResourceLocation("tomk/bg1.png"), 0, 0, sr.func_78326_a(), sr.func_78328_b());
/*  30 */     this.field_146294_l = sr.func_78326_a();
/*  31 */     this.field_146295_m = sr.func_78328_b();
/*  32 */     BlurBuffer.CustomBlurRoundArea(0.0F, 0.0F, this.field_146294_l, 30.0F, 6.0F, 10.0F);
/*  33 */     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
/*  34 */     String time2 = sdf.format(Long.valueOf(System.currentTimeMillis()));
/*  35 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.ico50.drawCenteredString("XSJ Client " + time2, 125.0F, 9.0F, Color.WHITE.getRGB());
/*     */ 
/*     */     
/*  38 */     isHoveredText("Single Players", 20.0F, this.field_146295_m - 110.0F, mouseX, mouseY);
/*  39 */     isHoveredText("Multi Players", 180.0F, this.field_146295_m - 110.0F, mouseX, mouseY);
/*  40 */     isHoveredText("Settings", 340.0F, this.field_146295_m - 110.0F, mouseX, mouseY);
/*  41 */     isHoveredText("Language", this.field_146294_l - 100.0F, 10.0F, mouseX, mouseY);
/*  42 */     isHoveredText("BackGround", this.field_146294_l - 130.0F - Fonts.productSans40.getStringWidth("Language"), 10.0F, mouseX, mouseY);
/*  43 */     isHoveredText("AltManager", this.field_146294_l - 190.0F - Fonts.productSans40.getStringWidth("BackGround"), 10.0F, mouseX, mouseY);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void isHoveredText(@NotNull String text, float x, float y, int mouseX, int mouseY) {
/*  48 */     Intrinsics.checkParameterIsNotNull(text, "text"); if (Intrinsics.areEqual(text, "AltManager")) {
/*  49 */       if (RenderUtils.isHovered(
/*  50 */           x, y, Fonts.productSans40.getStringWidth("Language"), 
/*  51 */           Fonts.productSans40.getFontHeight(), mouseX, mouseY)) {
/*     */ 
/*     */         
/*  54 */         Fonts.productSans40.drawString("AltManager", x, y, (new Color(255, 255, 255, 255)).getRGB());
/*     */       } else {
/*  56 */         Fonts.productSans40.drawString("AltManager", x, y, (new Color(146, 146, 146, 255)).getRGB());
/*     */       } 
/*     */     }
/*  59 */     if (Intrinsics.areEqual(text, "Language")) {
/*  60 */       if (RenderUtils.isHovered(
/*  61 */           x, y, Fonts.productSans40.getStringWidth("Language"), 
/*  62 */           Fonts.productSans40.getFontHeight(), mouseX, mouseY)) {
/*     */ 
/*     */         
/*  65 */         Fonts.productSans40.drawString("Language", x, y, (new Color(255, 255, 255, 255)).getRGB());
/*     */       } else {
/*  67 */         Fonts.productSans40.drawString("Language", x, y, (new Color(146, 146, 146, 255)).getRGB());
/*     */       } 
/*     */     }
/*  70 */     if (Intrinsics.areEqual(text, "BackGround")) {
/*  71 */       if (RenderUtils.isHovered(
/*  72 */           x, y, Fonts.productSans40.getStringWidth("BackGround"), 
/*  73 */           Fonts.productSans40.getFontHeight(), mouseX, mouseY)) {
/*     */ 
/*     */         
/*  76 */         Fonts.productSans40.drawString("BackGround", x, y, (new Color(255, 255, 255, 255)).getRGB());
/*     */       } else {
/*  78 */         Fonts.productSans40.drawString("BackGround", x, y, (new Color(146, 146, 146, 255)).getRGB());
/*     */       } 
/*     */     }
/*     */     
/*  82 */     if (Intrinsics.areEqual(text, "Single Players")) {
/*  83 */       if (RenderUtils.isHovered(x, y, 150.0F, 80.0F, mouseX, mouseY)) {
/*  84 */         Fonts.hicon45.drawString("F", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/*  85 */         Fonts.productSans40.drawString(
/*  86 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/*  87 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/*  89 */         Fonts.productSans30.drawString(
/*  90 */             "The world of one.", 
/*  91 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/*  92 */             y + 30.0F, (
/*  93 */             new Color(255, 255, 255)).getRGB());
/*     */         
/*  95 */         Fonts.productSans30.drawString(
/*  96 */             "You can do anything", 
/*  97 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/*  98 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/*  99 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 101 */         Fonts.productSans30.drawString(
/* 102 */             "want in this world.", 
/* 103 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 104 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 105 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 107 */         BlurBuffer.CustomBlurRoundArea(x - 3, y - 3, 156.0F, 83.0F, 3.0F, 10.0F);
/* 108 */         RenderUtils.drawRoundedRect3(x - 3, y - 3, 156.0F, 83.0F, 3.0F, (new Color(0, 0, 0, 30)).getRGB());
/* 109 */         Fonts.hicon45.drawString("F", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 110 */         Fonts.productSans40.drawString(
/* 111 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 112 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 114 */         Fonts.productSans30.drawString(
/* 115 */             "The world of one.", 
/* 116 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 117 */             y + 30.0F, (
/* 118 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 120 */         Fonts.productSans30.drawString(
/* 121 */             "You can do anything", 
/* 122 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 123 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 124 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 126 */         Fonts.productSans30.drawString(
/* 127 */             "want in this world.", 
/* 128 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 129 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 130 */             new Color(255, 255, 255)).getRGB());
/*     */       } else {
/*     */         
/* 133 */         Fonts.hicon45.drawString("F", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 134 */         Fonts.productSans40.drawString(
/* 135 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 136 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 138 */         Fonts.productSans30.drawString(
/* 139 */             "The world of one.", 
/* 140 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 141 */             y + 30.0F, (
/* 142 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 144 */         Fonts.productSans30.drawString(
/* 145 */             "You can do anything", 
/* 146 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 147 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 148 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 150 */         Fonts.productSans30.drawString(
/* 151 */             "want in this world.", 
/* 152 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 153 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 154 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 156 */         BlurBuffer.CustomBlurRoundArea(x, y, 150.0F, 80.0F, 3.0F, 50.0F);
/* 157 */         Fonts.hicon45.drawString("F", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 158 */         Fonts.productSans40.drawString(
/* 159 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 160 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 162 */         Fonts.productSans30.drawString(
/* 163 */             "The world of one.", 
/* 164 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 165 */             y + 30.0F, (
/* 166 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 168 */         Fonts.productSans30.drawString(
/* 169 */             "You can do anything", 
/* 170 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 171 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 172 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 174 */         Fonts.productSans30.drawString(
/* 175 */             "want in this world.", 
/* 176 */             x + 10.0F + Fonts.hicon45.getStringWidth("F"), 
/* 177 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 178 */             new Color(255, 255, 255)).getRGB());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 184 */     if (Intrinsics.areEqual(text, "Multi Players"))
/*     */     {
/* 186 */       if (RenderUtils.isHovered(x, y, 150.0F, 80.0F, mouseX, mouseY)) {
/* 187 */         Fonts.hicon45.drawString("H", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 188 */         Fonts.productSans40.drawString(
/* 189 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("H"), 
/* 190 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 192 */         Fonts.productSans30.drawString(
/* 193 */             "You have access to other", 
/* 194 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 195 */             y + 30.0F, (
/* 196 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 198 */         Fonts.productSans30.drawString(
/* 199 */             "people's servers.", 
/* 200 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 201 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 202 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 204 */         Fonts.productSans30.drawString(
/* 205 */             "And defeated using Client.", 
/* 206 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 207 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 208 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 210 */         BlurBuffer.CustomBlurRoundArea(x - 3, y - 3, 156.0F, 83.0F, 3.0F, 10.0F);
/* 211 */         RenderUtils.drawRoundedRect3(x - 3, y - 3, 156.0F, 83.0F, 3.0F, (new Color(0, 0, 0, 30)).getRGB());
/* 212 */         Fonts.hicon45.drawString("H", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 213 */         Fonts.productSans40.drawString(
/* 214 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("H"), 
/* 215 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 217 */         Fonts.productSans30.drawString(
/* 218 */             "You have access to other", 
/* 219 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 220 */             y + 30.0F, (
/* 221 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 223 */         Fonts.productSans30.drawString(
/* 224 */             "people's servers.", 
/* 225 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 226 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 227 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 229 */         Fonts.productSans30.drawString(
/* 230 */             "And defeated using Client.", 
/* 231 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 232 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 233 */             new Color(255, 255, 255)).getRGB());
/*     */       }
/*     */       else {
/*     */         
/* 237 */         Fonts.hicon45.drawString("H", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 238 */         Fonts.productSans40.drawString(
/* 239 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("H"), 
/* 240 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 242 */         Fonts.productSans30.drawString(
/* 243 */             "You have access to other", 
/* 244 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 245 */             y + 30.0F, (
/* 246 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 248 */         Fonts.productSans30.drawString(
/* 249 */             "people's servers.", 
/* 250 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 251 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 252 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 254 */         Fonts.productSans30.drawString(
/* 255 */             "And defeated using Client.", 
/* 256 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 257 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 258 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 260 */         BlurBuffer.CustomBlurRoundArea(x, y, 150.0F, 80.0F, 3.0F, 10.0F);
/* 261 */         Fonts.hicon45.drawString("H", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 262 */         Fonts.productSans40.drawString(
/* 263 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("H"), 
/* 264 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 266 */         Fonts.productSans30.drawString(
/* 267 */             "You have access to other", 
/* 268 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 269 */             y + 30.0F, (
/* 270 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 272 */         Fonts.productSans30.drawString(
/* 273 */             "people's servers.", 
/* 274 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 275 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 276 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 278 */         Fonts.productSans30.drawString(
/* 279 */             "And defeated using Client.", 
/* 280 */             x + 4.0F + Fonts.hicon45.getStringWidth("H"), 
/* 281 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 282 */             new Color(255, 255, 255)).getRGB());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 288 */     if (Intrinsics.areEqual(text, "Settings")) {
/* 289 */       if (RenderUtils.isHovered(x, y, 150.0F, 80.0F, mouseX, mouseY)) {
/* 290 */         Fonts.hicon45.drawString("K", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 291 */         Fonts.productSans40.drawString(
/* 292 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("K"), 
/* 293 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 295 */         Fonts.productSans30.drawString(
/* 296 */             "About the client Settings", 
/* 297 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 298 */             y + 30.0F, (
/* 299 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 301 */         Fonts.productSans30.drawString(
/* 302 */             "You can a lot of things", 
/* 303 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 304 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 305 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 307 */         Fonts.productSans30.drawString(
/* 308 */             "on the client here.", 
/* 309 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 310 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 311 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 313 */         BlurBuffer.CustomBlurRoundArea(x - 3, y - 3, 156.0F, 83.0F, 3.0F, 10.0F);
/* 314 */         RenderUtils.drawRoundedRect3(x - 3, y - 3, 156.0F, 83.0F, 3.0F, (new Color(0, 0, 0, 30)).getRGB());
/* 315 */         Fonts.hicon45.drawString("K", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 316 */         Fonts.productSans40.drawString(
/* 317 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("K"), 
/* 318 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 320 */         Fonts.productSans30.drawString(
/* 321 */             "About the client Settings", 
/* 322 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 323 */             y + 30.0F, (
/* 324 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 326 */         Fonts.productSans30.drawString(
/* 327 */             "You can a lot of things", 
/* 328 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 329 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 330 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 332 */         Fonts.productSans30.drawString(
/* 333 */             "on the client here.", 
/* 334 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 335 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 336 */             new Color(255, 255, 255)).getRGB());
/*     */       } else {
/*     */         
/* 339 */         Fonts.hicon45.drawString("K", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 340 */         Fonts.productSans40.drawString(
/* 341 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("K"), 
/* 342 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 344 */         Fonts.productSans30.drawString(
/* 345 */             "About the client Settings", 
/* 346 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 347 */             y + 30.0F, (
/* 348 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 350 */         Fonts.productSans30.drawString(
/* 351 */             "You can a lot of things", 
/* 352 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 353 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 354 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 356 */         Fonts.productSans30.drawString(
/* 357 */             "on the client here.", 
/* 358 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 359 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 360 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 362 */         BlurBuffer.CustomBlurRoundArea(x, y, 150.0F, 80.0F, 3.0F, 10.0F);
/* 363 */         Fonts.hicon45.drawString("K", x + 10.0F, y + 5.0F, (new Color(255, 255, 255, 200)).getRGB());
/* 364 */         Fonts.productSans40.drawString(
/* 365 */             text, x + 10.0F + Fonts.hicon45.getStringWidth("K"), 
/* 366 */             y + 10.0F, (new Color(255, 255, 255, 200)).getRGB());
/*     */         
/* 368 */         Fonts.productSans30.drawString(
/* 369 */             "About the client Settings", 
/* 370 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 371 */             y + 30.0F, (
/* 372 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 374 */         Fonts.productSans30.drawString(
/* 375 */             "You can a lot of things", 
/* 376 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 377 */             y + 30.0F + Fonts.productSans30.getFontHeight(), (
/* 378 */             new Color(255, 255, 255)).getRGB());
/*     */         
/* 380 */         Fonts.productSans30.drawString(
/* 381 */             "on the client here.", 
/* 382 */             x + 4.0F + Fonts.hicon45.getStringWidth("K"), 
/* 383 */             y + 30.0F + (Fonts.productSans30.getFontHeight() * 2), (
/* 384 */             new Color(255, 255, 255)).getRGB());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 393 */     this.sr = new ScaledResolution(this.field_146297_k);
/* 394 */     super.func_73866_w_();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int mouseX, int mouseY, int p) throws IOException {
/* 400 */     if (RenderUtils.isHovered(this.field_146294_l - 130.0F - Fonts.productSans40.getStringWidth("Language"), 10.0F, Fonts.productSans40.getStringWidth("Language"), 
/* 401 */         Fonts.productSans40.getFontHeight(), mouseX, mouseY)) {
/*     */       
/* 403 */       if (MinecraftInstance.mc.getCurrentScreen() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiBackground(MinecraftInstance.mc.getCurrentScreen())));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 408 */     if (RenderUtils.isHovered(this.field_146294_l - 190.0F - Fonts.productSans40.getStringWidth("AltManager"), 10.0F, Fonts.productSans40.getStringWidth("AltManager"), 
/* 409 */         Fonts.productSans40.getFontHeight(), mouseX, mouseY)) {
/* 410 */       MinecraftInstance.mc.displayGuiScreen(MinecraftInstance.classProvider.wrapGuiScreen((WrappedGuiScreen)new GuiAltManager()));
/*     */     }
/*     */ 
/*     */     
/* 414 */     if (RenderUtils.isHovered(this.field_146294_l - 100.0F, 10.0F, Fonts.productSans40.getStringWidth("Language"), 
/* 415 */         Fonts.productSans40.getFontHeight(), mouseX, mouseY)) {
/* 416 */       Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); this.field_146297_k.func_147108_a((GuiScreen)new GuiLanguage(this, (Minecraft.func_71410_x()).field_71474_y, Minecraft.func_71410_x().func_135016_M()));
/*     */     } 
/*     */     
/* 419 */     if (RenderUtils.isHovered(20.0F, this.field_146295_m - 110.0F, 150.0F, 80.0F, mouseX, mouseY)) {
/* 420 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiWorldSelection(this));
/*     */     }
/* 422 */     if (RenderUtils.isHovered(180.0F, this.field_146295_m - 110.0F, 150.0F, 80.0F, mouseX, mouseY))
/*     */     {
/* 424 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiMultiplayer(this));
/*     */     }
/* 426 */     if (RenderUtils.isHovered(340.0F, this.field_146295_m - 110.0F, 150.0F, 80.0F, mouseX, mouseY))
/*     */     {
/* 428 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiOptions(this, (Minecraft.func_71410_x()).field_71474_y));
/*     */     }
/*     */ 
/*     */     
/* 432 */     super.func_73864_a(mouseX, mouseY, p);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\lyn\\utils\GuiMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */