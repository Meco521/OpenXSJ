/*     */ package tomk.CFont;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class CFont {
/*  12 */   private final float imgSize = 512.0F;
/*  13 */   protected CharData[] charData = new CharData[256];
/*     */   protected Font font;
/*     */   protected boolean antiAlias;
/*     */   protected boolean fractionalMetrics;
/*  17 */   protected int fontHeight = -1;
/*  18 */   protected int charOffset = 0;
/*     */   protected DynamicTexture tex;
/*     */   
/*     */   public CFont(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  22 */     this.font = font;
/*  23 */     this.antiAlias = antiAlias;
/*  24 */     this.fractionalMetrics = fractionalMetrics;
/*  25 */     this.tex = setupTexture(font, antiAlias, fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  29 */     BufferedImage img = generateFontImage(font, antiAlias, fractionalMetrics, chars);
/*     */     
/*     */     try {
/*  32 */       return new DynamicTexture(img);
/*  33 */     } catch (Exception exception) {
/*  34 */       exception.printStackTrace();
/*  35 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  40 */     short imgSize = 512;
/*  41 */     BufferedImage bufferedImage = new BufferedImage(imgSize, imgSize, 2);
/*  42 */     Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
/*     */     
/*  44 */     g.setFont(font);
/*  45 */     g.setColor(new Color(255, 255, 255, 0));
/*  46 */     g.fillRect(0, 0, imgSize, imgSize);
/*  47 */     g.setColor(Color.WHITE);
/*  48 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*  49 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*  50 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, antiAlias ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
/*  51 */     FontMetrics fontMetrics = g.getFontMetrics();
/*  52 */     int charHeight = 0;
/*  53 */     int positionX = 0;
/*  54 */     int positionY = 1;
/*     */     
/*  56 */     for (int i = 0; i < chars.length; i++) {
/*  57 */       char ch = (char)i;
/*  58 */       CharData charData = new CharData();
/*  59 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), g);
/*     */       
/*  61 */       charData.width = (dimensions.getBounds()).width + 8;
/*  62 */       charData.height = (dimensions.getBounds()).height;
/*  63 */       if (positionX + charData.width >= imgSize) {
/*  64 */         positionX = 0;
/*  65 */         positionY += charHeight;
/*  66 */         charHeight = 0;
/*     */       } 
/*     */       
/*  69 */       if (charData.height > charHeight) {
/*  70 */         charHeight = charData.height;
/*     */       }
/*     */       
/*  73 */       charData.storedX = positionX;
/*  74 */       charData.storedY = positionY;
/*  75 */       if (charData.height > this.fontHeight) {
/*  76 */         this.fontHeight = charData.height;
/*     */       }
/*     */       
/*  79 */       chars[i] = charData;
/*  80 */       g.drawString(String.valueOf(ch), positionX + 2, positionY + fontMetrics.getAscent());
/*  81 */       positionX += charData.width;
/*     */     } 
/*     */     
/*  84 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public void drawChar(CharData[] chars, char c, float x, float y) throws ArrayIndexOutOfBoundsException {
/*     */     try {
/*  89 */       drawQuad(x, y, (chars[c]).width, (chars[c]).height, (chars[c]).storedX, (chars[c]).storedY, (chars[c]).width, (chars[c]).height);
/*  90 */     } catch (Exception exception) {
/*  91 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/*  97 */     float renderSRCX = srcX / 512.0F;
/*  98 */     float renderSRCY = srcY / 512.0F;
/*  99 */     float renderSRCWidth = srcWidth / 512.0F;
/* 100 */     float renderSRCHeight = srcHeight / 512.0F;
/*     */     
/* 102 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 103 */     GL11.glVertex2d((x + width), y);
/* 104 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/* 105 */     GL11.glVertex2d(x, y);
/* 106 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 107 */     GL11.glVertex2d(x, (y + height));
/* 108 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 109 */     GL11.glVertex2d(x, (y + height));
/* 110 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 111 */     GL11.glVertex2d((x + width), (y + height));
/* 112 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 113 */     GL11.glVertex2d((x + width), y);
/*     */   }
/*     */   
/*     */   public int getStringHeight(String text) {
/* 117 */     return getHeight();
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 121 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */   
/*     */   public int getStringWidth(String text) {
/* 125 */     int width = 0;
/* 126 */     char[] arrc = text.toCharArray();
/* 127 */     int n = arrc.length;
/*     */     
/* 129 */     for (int n2 = 0; n2 < n; n2++) {
/* 130 */       char c = arrc[n2];
/*     */       
/* 132 */       if (c < this.charData.length && c >= '\000') {
/* 133 */         width += (this.charData[c]).width - 8 + this.charOffset;
/*     */       }
/*     */     } 
/*     */     
/* 137 */     return width / 2;
/*     */   }
/*     */   
/*     */   public boolean isAntiAlias() {
/* 141 */     return this.antiAlias;
/*     */   }
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 145 */     if (this.antiAlias != antiAlias) {
/* 146 */       this.antiAlias = antiAlias;
/* 147 */       this.tex = setupTexture(this.font, antiAlias, this.fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFractionalMetrics() {
/* 153 */     return this.fractionalMetrics;
/*     */   }
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 157 */     if (this.fractionalMetrics != fractionalMetrics) {
/* 158 */       this.fractionalMetrics = fractionalMetrics;
/* 159 */       this.tex = setupTexture(this.font, this.antiAlias, fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Font getFont() {
/* 165 */     return this.font;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 169 */     this.font = font;
/* 170 */     this.tex = setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected class CharData {
/*     */     public int width;
/*     */     public int height;
/*     */     public int storedX;
/*     */     public int storedY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\CFont\CFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */