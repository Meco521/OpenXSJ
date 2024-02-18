/*     */ package net.ccbluex.liquidbounce.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CFontLoad
/*     */ {
/*  15 */   public static CFontRenderer newforever17 = new CFontRenderer(newgetforeverfont(17), true, true);
/*  16 */   public static CFontRenderer newforeverbold17 = new CFontRenderer(newgetforeverfontbold(20), true, true);
/*  17 */   public static CFontRenderer newforever20 = new CFontRenderer(newgetforeverfont(18), true, true);
/*  18 */   public static CFontRenderer newforever16 = new CFontRenderer(newgetforeverfont(16), true, true);
/*     */   
/*  20 */   public static CFontRenderer newforever24 = new CFontRenderer(newgetforeverfont(24), true, true);
/*     */   
/*  22 */   public static CFontRenderer for16 = new CFontRenderer(getnovologo(16), true, true);
/*  23 */   public static CFontRenderer for14 = new CFontRenderer(getnovologo(10), true, true);
/*     */   
/*  25 */   public static CFontRenderer for18 = new CFontRenderer(getnovologo(18), true, true);
/*  26 */   public static CFontRenderer for22 = new CFontRenderer(getnovologo(22), true, true);
/*  27 */   public static CFontRenderer for20 = new CFontRenderer(getnovologo(20), true, true);
/*     */   
/*  29 */   public static CFontRenderer forico24 = new CFontRenderer(forico(24), true, true);
/*  30 */   public static CFontRenderer foricotwo24 = new CFontRenderer(forico2(24), true, true);
/*  31 */   public static CFontRenderer clientfont45 = new CFontRenderer(getclientfont(45), true, true);
/*  32 */   public static CFontRenderer CP24 = new CFontRenderer(gtforico2(24), true, true);
/*  33 */   public static CFontRenderer WL24 = new CFontRenderer(gtforico3(24), true, true);
/*  34 */   public static CFontRenderer clientfont20 = new CFontRenderer(getclientfont(17), true, true);
/*     */   
/*     */   private static Font getforeverfont(int size) {
/*     */     try {
/*  38 */       InputStream inputStream = new FileInputStream(new File(Retreat.fileManager.fontsDir, "forever.ttf"));
/*  39 */       Font awtClientFont = Font.createFont(0, inputStream);
/*  40 */       awtClientFont = awtClientFont.deriveFont(0, size);
/*  41 */       inputStream.close();
/*  42 */       return awtClientFont;
/*  43 */     } catch (Exception e) {
/*  44 */       e.printStackTrace();
/*     */       
/*  46 */       return new Font("default", 0, size);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Font gtforico2(int size) {
/*     */     Font font;
/*     */     try {
/*  53 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/hicon.ttf")).func_110527_b();
/*     */       
/*  55 */       font = Font.createFont(0, ex);
/*  56 */       font = font.deriveFont(0, size);
/*  57 */     } catch (Exception exception) {
/*  58 */       exception.printStackTrace();
/*  59 */       System.out.println("Error loading font");
/*  60 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/*  63 */     return font;
/*     */   }
/*     */   
/*     */   private static Font gtforico3(int size) {
/*     */     Font font;
/*     */     try {
/*  69 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/icomoon.ttf")).func_110527_b();
/*     */       
/*  71 */       font = Font.createFont(0, ex);
/*  72 */       font = font.deriveFont(0, size);
/*  73 */     } catch (Exception exception) {
/*  74 */       exception.printStackTrace();
/*  75 */       System.out.println("Error loading font");
/*  76 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/*  79 */     return font;
/*     */   }
/*     */   
/*     */   private static Font getclientfont(int size) {
/*     */     Font font;
/*     */     try {
/*  85 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/clientfont.ttf")).func_110527_b();
/*     */       
/*  87 */       font = Font.createFont(0, ex);
/*  88 */       font = font.deriveFont(0, size);
/*  89 */     } catch (Exception exception) {
/*  90 */       exception.printStackTrace();
/*  91 */       System.out.println("Error loading font");
/*  92 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/*  95 */     return font;
/*     */   }
/*     */   
/*     */   private static Font getnovologo(int size) {
/*     */     Font font;
/*     */     try {
/* 101 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/for.ttf")).func_110527_b();
/*     */       
/* 103 */       font = Font.createFont(0, ex);
/* 104 */       font = font.deriveFont(0, size);
/* 105 */     } catch (Exception exception) {
/* 106 */       exception.printStackTrace();
/* 107 */       System.out.println("Error loading font");
/* 108 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 111 */     return font;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Font forico(int size) {
/*     */     Font font;
/*     */     try {
/* 118 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/forico.ttf")).func_110527_b();
/*     */       
/* 120 */       font = Font.createFont(0, ex);
/* 121 */       font = font.deriveFont(0, size);
/* 122 */     } catch (Exception exception) {
/* 123 */       exception.printStackTrace();
/* 124 */       System.out.println("Error loading font");
/* 125 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 128 */     return font;
/*     */   }
/*     */   
/*     */   private static Font forico2(int size) {
/*     */     Font font;
/*     */     try {
/* 134 */       InputStream ex = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/forico2.ttf")).func_110527_b();
/*     */       
/* 136 */       font = Font.createFont(0, ex);
/* 137 */       font = font.deriveFont(0, size);
/* 138 */     } catch (Exception exception) {
/* 139 */       exception.printStackTrace();
/* 140 */       System.out.println("Error loading font");
/* 141 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 144 */     return font;
/*     */   }
/*     */   
/*     */   private static Font newgetforeverfont(int size) {
/*     */     try {
/* 149 */       InputStream inputStream = new FileInputStream(new File(Retreat.fileManager.fontsDir, "foreverfont.ttf"));
/* 150 */       Font awtClientFont = Font.createFont(0, inputStream);
/* 151 */       awtClientFont = awtClientFont.deriveFont(0, size);
/* 152 */       inputStream.close();
/* 153 */       return awtClientFont;
/* 154 */     } catch (Exception e) {
/* 155 */       e.printStackTrace();
/*     */       
/* 157 */       return new Font("default", 0, size);
/*     */     } 
/*     */   }
/*     */   private static Font newgetforeverfontico(int size) {
/*     */     try {
/* 162 */       InputStream inputStream = new FileInputStream(new File(Retreat.fileManager.fontsDir, "foreverfontboldico.ttf"));
/* 163 */       Font awtClientFont = Font.createFont(0, inputStream);
/* 164 */       awtClientFont = awtClientFont.deriveFont(0, size);
/* 165 */       inputStream.close();
/* 166 */       return awtClientFont;
/* 167 */     } catch (Exception e) {
/* 168 */       e.printStackTrace();
/*     */       
/* 170 */       return new Font("default", 0, size);
/*     */     } 
/*     */   }
/*     */   private static Font newgetforeverfontbold(int size) {
/*     */     try {
/* 175 */       InputStream inputStream = new FileInputStream(new File(Retreat.fileManager.fontsDir, "foreverfontbold.ttf"));
/* 176 */       Font awtClientFont = Font.createFont(0, inputStream);
/* 177 */       awtClientFont = awtClientFont.deriveFont(0, size);
/* 178 */       inputStream.close();
/* 179 */       return awtClientFont;
/* 180 */     } catch (Exception e) {
/* 181 */       e.printStackTrace();
/*     */       
/* 183 */       return new Font("default", 0, size);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\font\CFontLoad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */