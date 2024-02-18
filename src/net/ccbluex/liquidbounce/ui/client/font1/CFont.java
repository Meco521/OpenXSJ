/*     */ package net.ccbluex.liquidbounce.ui.client.font1;
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
/*     */   protected Font font;
/*     */   protected boolean antiAlias;
/*     */   protected boolean fractionalMetrics;
/*     */   protected DynamicTexture tex;
/*  21 */   private final float imgSize = 512.0F;
/*  22 */   protected CharData[] charData = new CharData[256];
/*  23 */   protected int fontHeight = -1;
/*  24 */   protected int charOffset = 0;
/*     */   
/*     */   public CFont(Font font, boolean antiAlias, boolean fractionalMetrics) {
/*  27 */     this.font = font;
/*  28 */     this.antiAlias = antiAlias;
/*  29 */     this.fractionalMetrics = fractionalMetrics;
/*  30 */     this.tex = setupTexture(font, antiAlias, fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected DynamicTexture setupTexture(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*     */     try {
/*  35 */       return new DynamicTexture(generateFontImage(font, antiAlias, fractionalMetrics, chars));
/*  36 */     } catch (Exception e) {
/*  37 */       e.printStackTrace();
/*  38 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected BufferedImage generateFontImage(Font font, boolean antiAlias, boolean fractionalMetrics, CharData[] chars) {
/*  43 */     BufferedImage bufferedImage = new BufferedImage(512, 512, 2);
/*  44 */     Graphics2D g = (Graphics2D)bufferedImage.getGraphics();
/*  45 */     g.setFont(font);
/*  46 */     g.setColor(new Color(255, 255, 255, 0));
/*  47 */     g.fillRect(0, 0, 512, 512);
/*  48 */     g.setColor(Color.WHITE);
/*  49 */     g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, fractionalMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
/*  50 */     g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*  51 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, antiAlias ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
/*  52 */     FontMetrics fontMetrics = g.getFontMetrics();
/*  53 */     int charHeight = 0;
/*  54 */     int positionX = 0;
/*  55 */     int positionY = 1;
/*  56 */     for (int i = 0; i < chars.length; i++) {
/*  57 */       char ch = (char)i;
/*  58 */       CharData charData = new CharData();
/*  59 */       Rectangle2D dimensions = fontMetrics.getStringBounds(String.valueOf(ch), g);
/*  60 */       charData.width = (dimensions.getBounds()).width + 8;
/*  61 */       charData.height = (dimensions.getBounds()).height;
/*  62 */       if (positionX + charData.width >= 512) {
/*  63 */         positionX = 0;
/*  64 */         positionY += charHeight;
/*  65 */         charHeight = 0;
/*     */       } 
/*  67 */       if (charData.height > charHeight) {
/*  68 */         charHeight = charData.height;
/*     */       }
/*  70 */       charData.storedX = positionX;
/*  71 */       charData.storedY = positionY;
/*  72 */       if (charData.height > this.fontHeight) {
/*  73 */         this.fontHeight = charData.height;
/*     */       }
/*  75 */       chars[i] = charData;
/*  76 */       g.drawString(String.valueOf(ch), positionX + 2, positionY + fontMetrics.getAscent());
/*  77 */       positionX += charData.width;
/*     */     } 
/*  79 */     return bufferedImage;
/*     */   }
/*     */   
/*     */   public void drawChar(CharData[] chars, char c, float x, float y) throws ArrayIndexOutOfBoundsException {
/*     */     try {
/*  84 */       drawQuad(x, y, (chars[c]).width, (chars[c]).height, (chars[c]).storedX, (chars[c]).storedY, (chars[c]).width, (chars[c]).height);
/*  85 */     } catch (Exception e) {
/*  86 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void drawQuad(float x, float y, float width, float height, float srcX, float srcY, float srcWidth, float srcHeight) {
/*  91 */     float renderSRCX = srcX / 512.0F;
/*  92 */     float renderSRCY = srcY / 512.0F;
/*  93 */     float renderSRCWidth = srcWidth / 512.0F;
/*  94 */     float renderSRCHeight = srcHeight / 512.0F;
/*  95 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/*  96 */     GL11.glVertex2d((x + width), y);
/*  97 */     GL11.glTexCoord2f(renderSRCX, renderSRCY);
/*  98 */     GL11.glVertex2d(x, y);
/*  99 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 100 */     GL11.glVertex2d(x, (y + height));
/* 101 */     GL11.glTexCoord2f(renderSRCX, renderSRCY + renderSRCHeight);
/* 102 */     GL11.glVertex2d(x, (y + height));
/* 103 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY + renderSRCHeight);
/* 104 */     GL11.glVertex2d((x + width), (y + height));
/* 105 */     GL11.glTexCoord2f(renderSRCX + renderSRCWidth, renderSRCY);
/* 106 */     GL11.glVertex2d((x + width), y);
/*     */   }
/*     */   
/*     */   public int getStringHeight(String text) {
/* 110 */     return getHeight();
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 114 */     return (this.fontHeight - 8) / 2;
/*     */   }
/*     */   
/*     */   public int getStringWidth(String text) {
/* 118 */     int width = 0;
/* 119 */     char[] arrc = text.toCharArray();
/* 120 */     for (char c : arrc) {
/* 121 */       if (c < this.charData.length && c >= '\000') {
/* 122 */         width += (this.charData[c]).width - 8 + this.charOffset;
/*     */       }
/*     */     } 
/* 125 */     return width / 2;
/*     */   }
/*     */   
/*     */   public boolean isAntiAlias() {
/* 129 */     return this.antiAlias;
/*     */   }
/*     */   
/*     */   public void setAntiAlias(boolean antiAlias) {
/* 133 */     if (this.antiAlias != antiAlias) {
/* 134 */       this.antiAlias = antiAlias;
/* 135 */       this.tex = setupTexture(this.font, antiAlias, this.fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isFractionalMetrics() {
/* 140 */     return this.fractionalMetrics;
/*     */   }
/*     */   
/*     */   public void setFractionalMetrics(boolean fractionalMetrics) {
/* 144 */     if (this.fractionalMetrics != fractionalMetrics) {
/* 145 */       this.fractionalMetrics = fractionalMetrics;
/* 146 */       this.tex = setupTexture(this.font, this.antiAlias, fractionalMetrics, this.charData);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 151 */     return this.font;
/*     */   }
/*     */   
/*     */   public void setFont(Font font) {
/* 155 */     this.font = font;
/* 156 */     this.tex = setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
/*     */   }
/*     */   
/*     */   protected class CharData {
/*     */     public int width;
/*     */     public int height;
/*     */     public int storedX;
/*     */     public int storedY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\font1\CFont.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */