/*     */ package net.ccbluex.liquidbounce.font;
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
/*     */ public class CFont
/*     */ {
/*     */   public int FONT_HEIGHT;
/*     */   protected Font font;
/*  17 */   private final float imgSize = 512.0F; protected boolean antiAlias; protected boolean fractionalMetrics; protected DynamicTexture tex;
/*  18 */   protected CharData[] charData = new CharData[256];
/*  19 */   protected int fontHeight = -1;
/*  20 */   protected int charOffset = 0;
/*     */   
/*     */   public CFont(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  23 */     this.font = font;
/*  24 */     this.antiAlias = antiAlias;
/*  25 */     this.fractionalMetrics = fractionalMetrics;
/*  26 */     this.tex = setupTexture(font, antiAlias, fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*     */     try {
/*  31 */       return new DynamicTexture(generateFontImage(font, antiAlias, fractionalMetrics, chars));
/*  32 */     } catch (Exception e) {
/*  33 */       e.printStackTrace();
/*  34 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  39 */     BufferedImage bufferedImage = new BufferedImage(512, 512, 2);
/*  40 */     Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
/*  41 */     g.setFont(font);
/*  42 */     g.setColor(new Color(255, 255, 255, 0));
/*  43 */     g.fillRect(0, 0, 512, 512);
/*  44 */     g.setColor(Color.WHITE);
/*  45 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*  46 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*  47 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, antiAlias ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
/*  48 */     FontMetrics fontMetrics = g.getFontMetrics();
/*  49 */     int charHeight = 0;
/*  50 */     int positionX = 0;
/*  51 */     int positionY = 1;
/*  52 */     for (int i = 0; i < chars.length; i++) {
/*  53 */       char ch = (char)i;
/*  54 */       CharData charData = new CharData();
/*  55 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), g);
/*  56 */       charData.width = (dimensions.getBounds()).width + 8;
/*  57 */       charData.height = (dimensions.getBounds()).height;
/*  58 */       if (positionX + charData.width >= 512) {
/*  59 */         positionX = 0;
/*  60 */         positionY += charHeight;
/*  61 */         charHeight = 0;
/*     */       } 
/*  63 */       if (charData.height > charHeight) {
/*  64 */         charHeight = charData.height;
/*     */       }
/*  66 */       charData.storedX = positionX;
/*  67 */       charData.storedY = positionY;
/*  68 */       if (charData.height > this.fontHeight) {
/*  69 */         this.fontHeight = charData.height;
/*     */       }
/*  71 */       chars[i] = charData;
/*  72 */       g.drawString(String.valueOf(ch), positionX + 2, positionY + fontMetrics.getAscent());
/*  73 */       positionX += charData.width;
/*     */     } 
/*  75 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public void drawChar(CharData[] chars, char c, float x, float y) throws ArrayIndexOutOfBoundsException {
/*     */     try {
/*  80 */       drawQuad(x, y, (chars[c]).width, (chars[c]).height, (chars[c]).storedX, (chars[c]).storedY, (chars[c]).width, (chars[c]).height);
/*  81 */     } catch (Exception e) {
/*  82 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/*  87 */     float renderSRCX = srcX / 512.0F;
/*  88 */     float renderSRCY = srcY / 512.0F;
/*  89 */     float renderSRCWidth = srcWidth / 512.0F;
/*  90 */     float renderSRCHeight = srcHeight / 512.0F;
/*  91 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/*  92 */     GL11.glVertex2d((x + width), y);
/*  93 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/*  94 */     GL11.glVertex2d(x, y);
/*  95 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/*  96 */     GL11.glVertex2d(x, (y + height));
/*  97 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/*  98 */     GL11.glVertex2d(x, (y + height));
/*  99 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 100 */     GL11.glVertex2d((x + width), (y + height));
/* 101 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 102 */     GL11.glVertex2d((x + width), y);
/*     */   }
/*     */   
/*     */   public int getStringHeight(String text) {
/* 106 */     return getHeight();
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 110 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStringWidth(String text) {
/* 115 */     int width = 0;
/* 116 */     char[] arrc = text.toCharArray();
/* 117 */     for (char c : arrc) {
/* 118 */       if (c < this.charData.length && c >= '\000') {
/* 119 */         width += (this.charData[c]).width - 8 + this.charOffset;
/*     */       }
/*     */     } 
/* 122 */     return width / 2;
/*     */   }
/*     */   
/*     */   public boolean isAntiAlias() {
/* 126 */     return this.antiAlias;
/*     */   }
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 130 */     if (this.antiAlias != antiAlias) {
/* 131 */       this.antiAlias = antiAlias;
/* 132 */       this.tex = setupTexture(this.font, antiAlias, this.fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFractionalMetrics() {
/* 137 */     return this.fractionalMetrics;
/*     */   }
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 141 */     if (this.fractionalMetrics != fractionalMetrics) {
/* 142 */       this.fractionalMetrics = fractionalMetrics;
/* 143 */       this.tex = setupTexture(this.font, this.antiAlias, fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 148 */     return this.font;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 152 */     this.font = font;
/* 153 */     this.tex = setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected class CharData {
/*     */     public int width;
/*     */     public int height;
/*     */     public int storedX;
/*     */     public int storedY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\font\CFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */