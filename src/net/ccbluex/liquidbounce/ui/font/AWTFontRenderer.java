/*     */ package net.ccbluex.liquidbounce.ui.font;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\\\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\030\002\n\002\020\016\n\002\030\002\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\013\n\002\020\002\n\002\b\003\n\002\020\007\n\002\b\002\n\002\030\002\n\000\n\002\020\f\n\002\b\002\n\002\020\006\n\002\b\006\b\007\030\000 ,2\0020\001:\002+,B!\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005\022\b\b\002\020\006\032\0020\005¢\006\002\020\007J\b\020\032\032\0020\033H\002J \020\034\032\0020\0332\006\020\035\032\0020\0172\006\020\036\032\0020\0372\006\020 \032\0020\037H\002J\020\020!\032\0020\"2\006\020#\032\0020$H\002J&\020%\032\0020\0332\006\020&\032\0020\n2\006\020\036\032\0020'2\006\020 \032\0020'2\006\020(\032\0020\005J\016\020)\032\0020\0052\006\020&\032\0020\nJ\030\020*\032\0020\0332\006\020\004\032\0020\0052\006\020\006\032\0020\005H\002R*\020\b\032\036\022\004\022\0020\n\022\004\022\0020\0130\tj\016\022\004\022\0020\n\022\004\022\0020\013`\fX\004¢\006\002\n\000R\030\020\r\032\n\022\006\022\004\030\0010\0170\016X\004¢\006\004\n\002\020\020R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\021\020\022R\016\020\023\032\0020\005X\016¢\006\002\n\000R\021\020\024\032\0020\0058F¢\006\006\032\004\b\025\020\026R\016\020\027\032\0020\005X\016¢\006\002\n\000R\016\020\030\032\0020\005X\016¢\006\002\n\000R\016\020\031\032\0020\005X\016¢\006\002\n\000¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "font", "Ljava/awt/Font;", "startChar", "", "stopChar", "(Ljava/awt/Font;II)V", "cachedStrings", "Ljava/util/HashMap;", "", "Lnet/ccbluex/liquidbounce/ui/font/CachedFont;", "Lkotlin/collections/HashMap;", "charLocations", "", "Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer$CharLocation;", "[Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer$CharLocation;", "getFont", "()Ljava/awt/Font;", "fontHeight", "height", "getHeight", "()I", "textureHeight", "textureID", "textureWidth", "collectGarbage", "", "drawChar", "char", "x", "", "y", "drawCharToImage", "Ljava/awt/image/BufferedImage;", "ch", "", "drawString", "text", "", "color", "getStringWidth", "renderBitmap", "CharLocation", "Companion", "XSJClient"})
/*     */ public final class AWTFontRenderer extends MinecraftInstance {
/*     */   private int fontHeight;
/*     */   private final CharLocation[] charLocations;
/*     */   private final HashMap<String, CachedFont> cachedStrings;
/*     */   private int textureID;
/*     */   private int textureWidth;
/*     */   private int textureHeight;
/*     */   
/*     */   @NotNull
/*  21 */   public final Font getFont() { return this.font; } @NotNull private final Font font; private static boolean assumeNonVolatile; @NotNull private static final ArrayList<AWTFontRenderer> activeFontRenderers; private static int gcTicks; private static final int GC_TICKS = 600; private static final int CACHED_FONT_REMOVAL_TIME = 30000; public AWTFontRenderer(@NotNull Font font, int startChar, int stopChar) { this.font = font;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     this.fontHeight = -1;
/*  53 */     this.charLocations = new CharLocation[stopChar];
/*     */     
/*  55 */     this.cachedStrings = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     renderBitmap(startChar, stopChar);
/*     */     
/*  67 */     activeFontRenderers.add(this); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\006\n\002\020\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\023\032\0020\024R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R!\020\006\032\022\022\004\022\0020\b0\007j\b\022\004\022\0020\b`\t¢\006\b\n\000\032\004\b\n\020\013R\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\016\020\022\032\0020\004X\016¢\006\002\n\000¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer$Companion;", "", "()V", "CACHED_FONT_REMOVAL_TIME", "", "GC_TICKS", "activeFontRenderers", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;", "Lkotlin/collections/ArrayList;", "getActiveFontRenderers", "()Ljava/util/ArrayList;", "assumeNonVolatile", "", "getAssumeNonVolatile", "()Z", "setAssumeNonVolatile", "(Z)V", "gcTicks", "garbageCollectionTick", "", "XSJClient"})
/*     */   public static final class Companion
/*     */   {
/*     */     private Companion() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean getAssumeNonVolatile() {
/*     */       return AWTFontRenderer.assumeNonVolatile;
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
/*     */     public final void setAssumeNonVolatile(boolean <set-?>) {
/*     */       AWTFontRenderer.assumeNonVolatile = <set-?>;
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
/*     */     @NotNull
/*     */     public final ArrayList<AWTFontRenderer> getActiveFontRenderers() {
/*     */       return AWTFontRenderer.activeFontRenderers;
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
/*     */     public final void garbageCollectionTick()
/*     */     {
/*     */       Iterator<AWTFontRenderer> iterator;
/*     */       int i;
/*     */       AWTFontRenderer.gcTicks = (i = AWTFontRenderer.gcTicks) + 1;
/*     */       if (i > 600)
/*     */       { Iterable<AWTFontRenderer> $this$forEach$iv = getActiveFontRenderers();
/*     */         int $i$f$forEach = 0;
/* 288 */         iterator = $this$forEach$iv.iterator(); } else { return; }  if (iterator.hasNext()) { Object element$iv = iterator.next(); AWTFontRenderer it = (AWTFontRenderer)element$iv; int $i$a$-forEach-AWTFontRenderer$Companion$garbageCollectionTick$1 = 0; it.collectGarbage(); }  AWTFontRenderer.gcTicks = 0; } } public static final Companion Companion = new Companion(null); static { activeFontRenderers = new ArrayList<>(); } private final void collectGarbage() { long currentTime = System.currentTimeMillis(); Map<String, CachedFont> $this$filter$iv = this.cachedStrings; int $i$f$filter = 0; Map<String, CachedFont> map1 = $this$filter$iv; Map<Object, Object> destination$iv$iv = new LinkedHashMap<>(); int $i$f$filterTo = 0;
/* 289 */     Map<String, CachedFont> map2 = map1; boolean bool2 = false; for (Map.Entry<String, CachedFont> element$iv$iv : map2.entrySet()) {
/* 290 */       Map.Entry<String, CachedFont> it = element$iv$iv; int $i$a$-filter-AWTFontRenderer$collectGarbage$1 = 0; if ((currentTime - ((CachedFont)it.getValue()).getLastUsage() > 30000L)) {
/* 291 */         destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
/*     */       }
/*     */     } 
/* 294 */     Map<Object, Object> $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 295 */     Map<Object, Object> $this$filterTo$iv$iv = $this$forEach$iv; boolean bool1 = false; Iterator<Map.Entry> iterator = $this$filterTo$iv$iv.entrySet().iterator(); if (iterator.hasNext()) { Map.Entry element$iv = iterator.next(), it = element$iv; int $i$a$-forEach-AWTFontRenderer$collectGarbage$2 = 0;
/*     */       GL11.glDeleteLists(((CachedFont)it.getValue()).getDisplayList(), 1);
/*     */       ((CachedFont)it.getValue()).setDeleted(true);
/*     */       this.cachedStrings.remove(it.getKey()); }
/*     */      }
/*     */ 
/*     */   
/*     */   public final int getHeight() {
/*     */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */   
/*     */   public final void drawString(@NotNull String text, double x, double y, int color) {
/*     */     Intrinsics.checkParameterIsNotNull(text, "text");
/*     */     double scale = 0.5D;
/*     */     double reverse = true / scale;
/*     */     GL11.glPushMatrix();
/*     */     GL11.glScaled(scale, scale, scale);
/*     */     GL11.glTranslated(x * 2.0F, y * 2.0D - 2.0D, 0.0D);
/*     */     MinecraftInstance.classProvider.getGlStateManager().bindTexture(this.textureID);
/*     */     float red = (color >> 16 & 0xFF) / 255.0F;
/*     */     float green = (color >> 8 & 0xFF) / 255.0F;
/*     */     float blue = (color & 0xFF) / 255.0F;
/*     */     float alpha = (color >> 24 & 0xFF) / 255.0F;
/*     */     GL11.glColor4f(red, green, blue, alpha);
/*     */     double currX = 0.0D;
/*     */     CachedFont cached = this.cachedStrings.get(text);
/*     */     if (cached != null) {
/*     */       GL11.glCallList(cached.getDisplayList());
/*     */       cached.setLastUsage(System.currentTimeMillis());
/*     */       GL11.glPopMatrix();
/*     */       return;
/*     */     } 
/*     */     int list = -1;
/*     */     if (assumeNonVolatile) {
/*     */       list = GL11.glGenLists(1);
/*     */       GL11.glNewList(list, 4865);
/*     */     } 
/*     */     GL11.glBegin(7);
/*     */     String str = text;
/*     */     boolean bool = false;
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()");
/*     */     for (char char : str.toCharArray()) {
/*     */       if (char >= this.charLocations.length) {
/*     */         GL11.glEnd();
/*     */         GL11.glScaled(reverse, reverse, reverse);
/*     */         MinecraftInstance.mc.getFontRendererObj().drawString(String.valueOf(char), (float)currX * (float)scale + true, 2.0F, color, false);
/*     */         currX += MinecraftInstance.mc.getFontRendererObj().getStringWidth(String.valueOf(char)) * reverse;
/*     */         GL11.glScaled(scale, scale, scale);
/*     */         MinecraftInstance.classProvider.getGlStateManager().bindTexture(this.textureID);
/*     */         GL11.glColor4f(red, green, blue, alpha);
/*     */         GL11.glBegin(7);
/*     */       } else if (this.charLocations[char] != null) {
/*     */         CharLocation fontChar = this.charLocations[char];
/*     */         drawChar(fontChar, (float)currX, 0.0F);
/*     */         currX += (fontChar.getWidth() - ((Number)CustomFont.fontWidthValue.get()).intValue());
/*     */       } else {
/*     */         this.charLocations[char];
/*     */       } 
/*     */     } 
/*     */     GL11.glEnd();
/*     */     if (assumeNonVolatile) {
/*     */       this.cachedStrings.put(text, new CachedFont(list, System.currentTimeMillis(), false, 4, null));
/*     */       GL11.glEndList();
/*     */     } 
/*     */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private final void drawChar(CharLocation char, float x, float y) {
/*     */     float width = char.getWidth();
/*     */     float height = char.getHeight();
/*     */     float srcX = char.getX();
/*     */     float srcY = char.getY();
/*     */     float renderX = srcX / this.textureWidth;
/*     */     float renderY = srcY / this.textureHeight;
/*     */     float renderWidth = width / this.textureWidth;
/*     */     float renderHeight = height / this.textureHeight;
/*     */     GL11.glTexCoord2f(renderX, renderY);
/*     */     GL11.glVertex2f(x, y);
/*     */     GL11.glTexCoord2f(renderX, renderY + renderHeight);
/*     */     GL11.glVertex2f(x, y + height);
/*     */     GL11.glTexCoord2f(renderX + renderWidth, renderY + renderHeight);
/*     */     GL11.glVertex2f(x + width, y + height);
/*     */     GL11.glTexCoord2f(renderX + renderWidth, renderY);
/*     */     GL11.glVertex2f(x + width, y);
/*     */   }
/*     */   
/*     */   private final void renderBitmap(int startChar, int stopChar) {
/*     */     BufferedImage[] fontImages = new BufferedImage[stopChar];
/*     */     int rowHeight = 0;
/*     */     int charX = 0;
/*     */     int charY = 0;
/*     */     for (int i = startChar, j = stopChar; i < j; i++) {
/*     */       BufferedImage fontImage = drawCharToImage((char)i);
/*     */       CharLocation fontChar = new CharLocation(charX, charY, fontImage.getWidth(), fontImage.getHeight());
/*     */       if (fontChar.getHeight() > this.fontHeight)
/*     */         this.fontHeight = fontChar.getHeight(); 
/*     */       if (fontChar.getHeight() > rowHeight)
/*     */         rowHeight = fontChar.getHeight(); 
/*     */       this.charLocations[i] = fontChar;
/*     */       fontImages[i] = fontImage;
/*     */       charX += fontChar.getWidth();
/*     */       if (charX > 2048) {
/*     */         if (charX > this.textureWidth)
/*     */           this.textureWidth = charX; 
/*     */         charX = 0;
/*     */         charY += rowHeight;
/*     */         rowHeight = 0;
/*     */       } 
/*     */     } 
/*     */     this.textureHeight = charY + rowHeight;
/*     */     BufferedImage bufferedImage = new BufferedImage(this.textureWidth, this.textureHeight, 2);
/*     */     if (bufferedImage.getGraphics() == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.awt.Graphics2D"); 
/*     */     Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
/*     */     graphics2D.setFont(this.font);
/*     */     graphics2D.setColor(new Color(255, 255, 255, 0));
/*     */     graphics2D.fillRect(0, 0, this.textureWidth, this.textureHeight);
/*     */     graphics2D.setColor(Color.white);
/*     */     for (int k = startChar, m = stopChar; k < m; k++) {
/*     */       if (fontImages[k] != null && this.charLocations[k] != null) {
/*     */         if (this.charLocations[k] == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         if (this.charLocations[k] == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         graphics2D.drawImage(fontImages[k], this.charLocations[k].getX(), this.charLocations[k].getY(), (ImageObserver)null);
/*     */       } 
/*     */     } 
/*     */     this.textureID = TextureUtil.func_110989_a(TextureUtil.func_110996_a(), bufferedImage, true, true);
/*     */   }
/*     */   
/*     */   private final BufferedImage drawCharToImage(char ch) {
/*     */     if ((new BufferedImage(1, 1, 2)).getGraphics() == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.awt.Graphics2D"); 
/*     */     Graphics2D graphics2D = (Graphics2D)(new BufferedImage(1, 1, 2)).getGraphics();
/*     */     graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */     graphics2D.setFont(this.font);
/*     */     FontMetrics fontMetrics = graphics2D.getFontMetrics();
/*     */     int charWidth = fontMetrics.charWidth(ch) + 8;
/*     */     if (charWidth <= 0)
/*     */       charWidth = 7; 
/*     */     Intrinsics.checkExpressionValueIsNotNull(fontMetrics, "fontMetrics");
/*     */     int charHeight = fontMetrics.getHeight() + 3;
/*     */     if (charHeight <= 0)
/*     */       charHeight = this.font.getSize(); 
/*     */     BufferedImage fontImage = new BufferedImage(charWidth, charHeight, 2);
/*     */     if (fontImage.getGraphics() == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type java.awt.Graphics2D"); 
/*     */     Graphics2D graphics = (Graphics2D)fontImage.getGraphics();
/*     */     graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */     graphics.setFont(this.font);
/*     */     graphics.setColor(Color.WHITE);
/*     */     graphics.drawString(String.valueOf(ch), 3, 1 + fontMetrics.getAscent());
/*     */     return fontImage;
/*     */   }
/*     */   
/*     */   public final int getStringWidth(@NotNull String text) {
/*     */     Intrinsics.checkParameterIsNotNull(text, "text");
/*     */     int width = 0;
/*     */     String str = text;
/*     */     boolean bool = false;
/*     */     Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()");
/*     */     for (char c : str.toCharArray()) {
/*     */       if (this.charLocations[(c < this.charLocations.length) ? c : 3] != null) {
/*     */         CharLocation fontChar = this.charLocations[(c < this.charLocations.length) ? c : 3];
/*     */         width += fontChar.getWidth() - ((Number)CustomFont.fontWidthValue.get()).intValue();
/*     */       } else {
/*     */         this.charLocations[(c < this.charLocations.length) ? c : 3];
/*     */       } 
/*     */     } 
/*     */     return width / 2;
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\024\n\002\020\013\n\002\b\003\n\002\020\016\n\000\b\b\030\0002\0020\001B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\006\020\006\032\0020\003¢\006\002\020\007J\t\020\022\032\0020\003HÆ\003J\t\020\023\032\0020\003HÆ\003J\t\020\024\032\0020\003HÆ\003J\t\020\025\032\0020\003HÆ\003J1\020\026\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\0032\b\b\002\020\006\032\0020\003HÆ\001J\023\020\027\032\0020\0302\b\020\031\032\004\030\0010\001HÖ\003J\t\020\032\032\0020\003HÖ\001J\t\020\033\032\0020\034HÖ\001R\032\020\006\032\0020\003X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\032\020\005\032\0020\003X\016¢\006\016\n\000\032\004\b\f\020\t\"\004\b\r\020\013R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\016\020\t\"\004\b\017\020\013R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b\020\020\t\"\004\b\021\020\013¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer$CharLocation;", "", "x", "", "y", "width", "height", "(IIII)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "XSJClient"})
/*     */   private static final class CharLocation {
/*     */     private int x;
/*     */     private int y;
/*     */     private int width;
/*     */     private int height;
/*     */     
/*     */     public final int getX() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public final void setX(int <set-?>) {
/*     */       this.x = <set-?>;
/*     */     }
/*     */     
/*     */     public final int getY() {
/*     */       return this.y;
/*     */     }
/*     */     
/*     */     public final void setY(int <set-?>) {
/*     */       this.y = <set-?>;
/*     */     }
/*     */     
/*     */     public final int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public final void setWidth(int <set-?>) {
/*     */       this.width = <set-?>;
/*     */     }
/*     */     
/*     */     public final int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public final void setHeight(int <set-?>) {
/*     */       this.height = <set-?>;
/*     */     }
/*     */     
/*     */     public CharLocation(int x, int y, int width, int height) {
/*     */       this.x = x;
/*     */       this.y = y;
/*     */       this.width = width;
/*     */       this.height = height;
/*     */     }
/*     */     
/*     */     public final int component1() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public final int component2() {
/*     */       return this.y;
/*     */     }
/*     */     
/*     */     public final int component3() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public final int component4() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final CharLocation copy(int x, int y, int width, int height) {
/*     */       return new CharLocation(x, y, width, height);
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public String toString() {
/*     */       return "CharLocation(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ")";
/*     */     }
/*     */     
/*     */     public int hashCode() {
/*     */       return ((Integer.hashCode(this.x) * 31 + Integer.hashCode(this.y)) * 31 + Integer.hashCode(this.width)) * 31 + Integer.hashCode(this.height);
/*     */     }
/*     */     
/*     */     public boolean equals(@Nullable Object param1Object) {
/*     */       if (this != param1Object) {
/*     */         if (param1Object instanceof CharLocation) {
/*     */           CharLocation charLocation = (CharLocation)param1Object;
/*     */           if (this.x == charLocation.x && this.y == charLocation.y && this.width == charLocation.width && this.height == charLocation.height)
/*     */             return true; 
/*     */         } 
/*     */       } else {
/*     */         return true;
/*     */       } 
/*     */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\AWTFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */