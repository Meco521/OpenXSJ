/*     */ package net.ccbluex.liquidbounce.ui.Verify1.font;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CFont
/*     */ {
/*  17 */   private final float imgSize = 512.0F;
/*  18 */   protected CharData[] charData = new CharData[256];
/*     */   protected Font font;
/*     */   protected boolean antiAlias;
/*     */   protected boolean fractionalMetrics;
/*  22 */   protected int fontHeight = -1;
/*  23 */   protected int charOffset = 0;
/*     */   protected DynamicTexture tex;
/*     */   
/*     */   public CFont(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  27 */     this.font = font;
/*  28 */     this.antiAlias = antiAlias;
/*  29 */     this.fractionalMetrics = fractionalMetrics;
/*  30 */     this.tex = setupTexture(font, antiAlias, fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  34 */     BufferedImage img = generateFontImage(font, antiAlias, fractionalMetrics, chars);
/*     */     try {
/*  36 */       return new DynamicTexture(img);
/*     */     }
/*  38 */     catch (Exception e) {
/*  39 */       e.printStackTrace();
/*  40 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  45 */     int imgSize = 512;
/*  46 */     BufferedImage bufferedImage = new BufferedImage(imgSize, imgSize, 2);
/*  47 */     Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
/*  48 */     g.setFont(font);
/*  49 */     g.setColor(new Color(255, 255, 255, 0));
/*  50 */     g.fillRect(0, 0, imgSize, imgSize);
/*  51 */     g.setColor(Color.WHITE);
/*  52 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*  53 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*  54 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, antiAlias ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
/*  55 */     FontMetrics fontMetrics = g.getFontMetrics();
/*  56 */     int charHeight = 0;
/*  57 */     int positionX = 0;
/*  58 */     int positionY = 1;
/*  59 */     int i = 0;
/*  60 */     while (i < chars.length) {
/*  61 */       char ch = (char)i;
/*  62 */       CharData charData = new CharData();
/*  63 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), g);
/*  64 */       charData.width = (dimensions.getBounds()).width + 8;
/*  65 */       charData.height = (dimensions.getBounds()).height;
/*  66 */       if (positionX + charData.width >= imgSize) {
/*  67 */         positionX = 0;
/*  68 */         positionY += charHeight;
/*  69 */         charHeight = 0;
/*     */       } 
/*  71 */       if (charData.height > charHeight) {
/*  72 */         charHeight = charData.height;
/*     */       }
/*  74 */       charData.storedX = positionX;
/*  75 */       charData.storedY = positionY;
/*  76 */       if (charData.height > this.fontHeight) {
/*  77 */         this.fontHeight = charData.height;
/*     */       }
/*  79 */       chars[i] = charData;
/*  80 */       g.drawString(String.valueOf(ch), positionX + 2, positionY + fontMetrics.getAscent());
/*  81 */       positionX += charData.width;
/*  82 */       i++;
/*     */     } 
/*  84 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public void drawChar(CharData[] chars, char c, float x, float y) throws ArrayIndexOutOfBoundsException {
/*     */     try {
/*  89 */       drawQuad(x, y, (chars[c]).width, (chars[c]).height, (chars[c]).storedX, (chars[c]).storedY, (chars[c]).width, (chars[c]).height);
/*     */     }
/*  91 */     catch (Exception e) {
/*  92 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/*  97 */     float renderSRCX = srcX / 512.0F;
/*  98 */     float renderSRCY = srcY / 512.0F;
/*  99 */     float renderSRCWidth = srcWidth / 512.0F;
/* 100 */     float renderSRCHeight = srcHeight / 512.0F;
/* 101 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 102 */     GL11.glVertex2d((x + width), y);
/* 103 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/* 104 */     GL11.glVertex2d(x, y);
/* 105 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 106 */     GL11.glVertex2d(x, (y + height));
/* 107 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 108 */     GL11.glVertex2d(x, (y + height));
/* 109 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 110 */     GL11.glVertex2d((x + width), (y + height));
/* 111 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 112 */     GL11.glVertex2d((x + width), y);
/*     */   }
/*     */   
/*     */   public int getStringHeight(String text) {
/* 116 */     return getHeight();
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 120 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */   
/*     */   public int getStringWidth(String text) {
/* 124 */     int width = 0;
/* 125 */     char[] arrc = text.toCharArray();
/* 126 */     int n = arrc.length;
/* 127 */     int n2 = 0;
/* 128 */     while (n2 < n) {
/* 129 */       char c = arrc[n2];
/* 130 */       if (c < this.charData.length && c >= '\000') {
/* 131 */         width += (this.charData[c]).width - 8 + this.charOffset;
/*     */       }
/* 133 */       n2++;
/*     */     } 
/* 135 */     return width / 2;
/*     */   }
/*     */   
/*     */   public boolean isAntiAlias() {
/* 139 */     return this.antiAlias;
/*     */   }
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 143 */     if (this.antiAlias != antiAlias) {
/* 144 */       this.antiAlias = antiAlias;
/* 145 */       this.tex = setupTexture(this.font, antiAlias, this.fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFractionalMetrics() {
/* 150 */     return this.fractionalMetrics;
/*     */   }
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 154 */     if (this.fractionalMetrics != fractionalMetrics) {
/* 155 */       this.fractionalMetrics = fractionalMetrics;
/* 156 */       this.tex = setupTexture(this.font, this.antiAlias, fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 161 */     return this.font;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 165 */     this.font = font;
/* 166 */     this.tex = setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected class CharData {
/*     */     public int width;
/*     */     public int height;
/*     */     public int storedX;
/*     */     public int storedY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\Verify1\font\CFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */