/*     */ package net.ccbluex.liquidbounce.tomk;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.utils.novoline.ScaleUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Client
/*     */ {
/*  18 */   instance; public long startTime;
/*     */   
/*     */   Client() {
/*  21 */     this.startTime = System.currentTimeMillis();
/*     */   }
/*     */   public static String title; public static final String name = "XSJSense";
/*     */   
/*     */   public static void drawOutline(float x, float y, float width, float height, float radius, float line, float offset) {
/*  26 */     ScaleUtils.enableRender2D();
/*  27 */     GL11.glLineWidth(line);
/*  28 */     GL11.glBegin(3);
/*  29 */     float edgeRadius = radius;
/*  30 */     float centerX = x + edgeRadius;
/*  31 */     float centerY = y + edgeRadius;
/*  32 */     int vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F);
/*     */     
/*  34 */     int colorI = 0;
/*     */     
/*  36 */     centerX = width;
/*  37 */     centerY = height + edgeRadius;
/*  38 */     vertices = (int)Math.min(Math.max(edgeRadius, 10.0F), 90.0F); int i;
/*  39 */     for (i = 0; i <= vertices; i++) {
/*  40 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  41 */       double angleRadians = 6.283185307179586D * i / (vertices * 4);
/*  42 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  43 */       colorI++;
/*     */     } 
/*     */     
/*  46 */     GL11.glEnd();
/*  47 */     GL11.glLineWidth(line);
/*  48 */     GL11.glBegin(3);
/*  49 */     centerX = width + edgeRadius;
/*  50 */     centerY = height + edgeRadius;
/*  51 */     for (i = 0; i <= height - y; i++) {
/*  52 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  53 */       GL11.glVertex2d(centerX, (centerY - i));
/*  54 */       colorI++;
/*     */     } 
/*  56 */     GL11.glEnd();
/*  57 */     GL11.glLineWidth(line);
/*  58 */     GL11.glBegin(3);
/*  59 */     centerX = width;
/*  60 */     centerY = y + edgeRadius;
/*  61 */     for (i = 0; i <= vertices; i++) {
/*  62 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  63 */       double angleRadians = 6.283185307179586D * (i + 90) / (vertices * 4);
/*  64 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  65 */       colorI++;
/*     */     } 
/*  67 */     GL11.glEnd();
/*  68 */     GL11.glLineWidth(line);
/*  69 */     GL11.glBegin(3);
/*  70 */     centerX = width;
/*  71 */     centerY = y;
/*  72 */     for (i = 0; i <= width - x; i++) {
/*  73 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  74 */       GL11.glVertex2d((centerX - i), centerY);
/*  75 */       colorI++;
/*     */     } 
/*  77 */     GL11.glEnd();
/*  78 */     GL11.glLineWidth(line);
/*  79 */     GL11.glBegin(3);
/*  80 */     centerX = x;
/*  81 */     centerY = y + edgeRadius;
/*  82 */     for (i = 0; i <= vertices; i++) {
/*  83 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/*  84 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY + Math.cos(angleRadians) * edgeRadius);
/*  85 */       colorI++;
/*     */     } 
/*  87 */     colorI = 0;
/*  88 */     GL11.glEnd();
/*  89 */     GL11.glLineWidth(line);
/*  90 */     GL11.glBegin(3);
/*  91 */     centerX = width;
/*  92 */     centerY = height + vertices + offset;
/*  93 */     for (i = 0; i <= width - x; i++) {
/*  94 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/*  95 */       GL11.glVertex2d((centerX - i), centerY);
/*  96 */       colorI++;
/*     */     } 
/*  98 */     GL11.glEnd();
/*  99 */     GL11.glLineWidth(line);
/* 100 */     GL11.glBegin(3);
/* 101 */     centerX = x;
/* 102 */     centerY = height + edgeRadius;
/* 103 */     for (i = 0; i <= vertices; i++) {
/* 104 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 105 */       double angleRadians = 6.283185307179586D * (i + 180) / (vertices * 4);
/* 106 */       GL11.glVertex2d(centerX + Math.sin(angleRadians) * edgeRadius, centerY - Math.cos(angleRadians) * edgeRadius);
/* 107 */       colorI++;
/*     */     } 
/* 109 */     GL11.glEnd();
/* 110 */     GL11.glLineWidth(line);
/* 111 */     GL11.glBegin(3);
/* 112 */     centerX = x - edgeRadius;
/* 113 */     centerY = height + edgeRadius;
/*     */     
/* 115 */     for (i = 0; i <= height - y; i++) {
/* 116 */       ScaleUtils.setColor(ScaleUtils.fadeBetween((new Color(((Integer)AColorPalette.r.get()).intValue(), ((Integer)AColorPalette.g.get()).intValue(), ((Integer)AColorPalette.b.get()).intValue())).getRGB(), (new Color(((Integer)AColorPalette.r2.get()).intValue(), ((Integer)AColorPalette.g2.get()).intValue(), ((Integer)AColorPalette.b2.get()).intValue())).getRGB(), 10L * colorI));
/* 117 */       GL11.glVertex2d(centerX, (centerY - i));
/* 118 */       colorI++;
/*     */     } 
/* 120 */     GL11.glEnd();
/* 121 */     ScaleUtils.disableRender2D();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   private void onPacket(PacketEvent event) {
/* 126 */     if (event.getPacket() instanceof net.minecraft.network.handshake.client.C00Handshake)
/* 127 */       this.startTime = System.currentTimeMillis(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\tomk\Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */