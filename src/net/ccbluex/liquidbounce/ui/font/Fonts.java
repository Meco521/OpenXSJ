/*     */ package net.ccbluex.liquidbounce.ui.font;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class Fonts
/*     */   extends MinecraftInstance {
/*     */   @FontDetails(fontName = "NewTenacity", fontSize = 20)
/*     */   public static IFontRenderer newtenacity40;
/*     */   @FontDetails(fontName = "micon30", fontSize = 30)
/*     */   public static GameFontRenderer micon30;
/*     */   @FontDetails(fontName = "MenuIcon", fontSize = 45)
/*     */   public static IFontRenderer hicon45;
/*     */   @FontDetails(fontName = "Newgct", fontSize = 15)
/*     */   public static IFontRenderer gct;
/*     */   @FontDetails(fontName = "Chinese", fontSize = 16)
/*     */   public static GameFontRenderer Chinese16;
/*     */   @FontDetails(fontName = "Posteraaa", fontSize = 35)
/*     */   public static IFontRenderer Posterama35;
/*     */   @FontDetails(fontName = "SFUI Regular", fontSize = 120)
/*     */   public static IFontRenderer fontSFUI120;
/*     */   @FontDetails(fontName = "SellenaBrush", fontSize = 70)
/*     */   public static IFontRenderer sellena100;
/*     */   @FontDetails(fontName = "SFUI Regular", fontSize = 56)
/*     */   public static IFontRenderer fontSFUI56;
/*     */   @FontDetails(fontName = "Newuifont", fontSize = 17)
/*     */   public static IFontRenderer Newuifont25;
/*     */   @FontDetails(fontName = "Bnk", fontSize = 35)
/*     */   public static IFontRenderer Bnk40;
/*     */   @FontDetails(fontName = "micon15", fontSize = 15)
/*     */   public static GameFontRenderer micon15;
/*     */   @FontDetails(fontName = "SFUI35", fontSize = 35)
/*     */   public static GameFontRenderer SFUI35;
/*     */   @FontDetails(fontName = "hicon", fontSize = 12)
/*     */   public static IFontRenderer icon25;
/*     */   @FontDetails(fontName = "NewTenacity", fontSize = 23)
/*     */   public static IFontRenderer newtenacity45;
/*     */   @FontDetails(fontName = "comfortaa", fontSize = 30)
/*     */   public static IFontRenderer com30;
/*     */   @FontDetails(fontName = "comfortaa", fontSize = 35)
/*     */   public static IFontRenderer com35;
/*     */   @FontDetails(fontName = "cf", fontSize = 20)
/*     */   public static IFontRenderer cf40;
/*     */   @FontDetails(fontName = "Minecraft Font")
/*  54 */   public static final IFontRenderer minecraftFont = mc.getFontRendererObj();
/*     */   
/*     */   @FontDetails(fontName = "yangzi", fontSize = 20)
/*     */   public static IFontRenderer icon50;
/*     */   
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 18)
/*     */   public static IFontRenderer roboto35;
/*     */   
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 20)
/*     */   public static IFontRenderer roboto40;
/*     */   
/*     */   @FontDetails(fontName = "Rubik", fontSize = 15)
/*     */   public static IFontRenderer rubik30;
/*     */   
/*     */   @FontDetails(fontName = "Rubik", fontSize = 18)
/*     */   public static IFontRenderer rubik35;
/*     */   @FontDetails(fontName = "Rubik", fontSize = 20)
/*     */   public static IFontRenderer rubik40;
/*     */   @FontDetails(fontName = "Rubik", fontSize = 23)
/*     */   public static IFontRenderer rubik45;
/*     */   @FontDetails(fontName = "Rubik", fontSize = 13)
/*     */   public static IFontRenderer rubik26;
/*     */   @FontDetails(fontName = "flux", fontSize = 18)
/*     */   public static IFontRenderer flux;
/*     */   @FontDetails(fontName = "flux", fontSize = 23)
/*     */   public static IFontRenderer flux45;
/*     */   @FontDetails(fontName = "Tenacity", fontSize = 40)
/*     */   public static IFontRenderer tenacity80;
/*     */   @FontDetails(fontName = "Tenacity", fontSize = 80)
/*     */   public static IFontRenderer tenacity100;
/*     */   @FontDetails(fontName = "Tenacity", fontSize = 20)
/*     */   public static IFontRenderer tenacity40;
/*     */   @FontDetails(fontName = "Tenacity", fontSize = 10)
/*     */   public static IFontRenderer tenacity20;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 15)
/*     */   public static IFontRenderer tenacitybold30;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 13)
/*     */   public static IFontRenderer tenacitybold25;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 18)
/*     */   public static IFontRenderer tenacitybold35;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 20)
/*     */   public static IFontRenderer tenacitybold40;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 21)
/*     */   public static IFontRenderer tenacitybold42;
/*     */   @FontDetails(fontName = "Roboto Bold", fontSize = 90)
/*     */   public static IFontRenderer robotoBold180;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 18)
/*     */   public static IFontRenderer productSans35;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 20)
/*     */   public static IFontRenderer productSans40;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 37)
/*     */   public static IFontRenderer productSans70;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 40)
/*     */   public static IFontRenderer productSans80;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 26)
/*     */   public static IFontRenderer productSans52;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 15)
/*     */   public static IFontRenderer productSans30;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 13)
/*     */   public static IFontRenderer productSans26;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 23)
/*     */   public static IFontRenderer productSans45;
/*     */   @FontDetails(fontName = "Product Sans", fontSize = 25)
/*     */   public static IFontRenderer productSans50;
/*     */   @FontDetails(fontName = "Notification Icon", fontSize = 35)
/*     */   public static IFontRenderer notificationIcon70;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 25)
/*     */   public static IFontRenderer tenacitybold50;
/*     */   @FontDetails(fontName = "Tenacitybold", fontSize = 21)
/*     */   public static IFontRenderer tenacitybold43;
/*     */   @FontDetails(fontName = "Tenacitycheck", fontSize = 30)
/*     */   public static IFontRenderer tenacitycheck60;
/*     */   @FontDetails(fontName = "Posterama", fontSize = 15)
/*     */   public static IFontRenderer posterama30;
/*     */   @FontDetails(fontName = "Posterama", fontSize = 18)
/*     */   public static IFontRenderer posterama35;
/*     */   @FontDetails(fontName = "Posterama", fontSize = 20)
/*     */   public static IFontRenderer posterama40;
/*     */   @FontDetails(fontName = "NB", fontSize = 18)
/*     */   public static IFontRenderer nbicon18;
/*     */   @FontDetails(fontName = "NB", fontSize = 20)
/*     */   public static IFontRenderer nbicon20;
/*     */   @FontDetails(fontName = "NB", fontSize = 40)
/*     */   public static IFontRenderer nbicon40;
/*     */   @FontDetails(fontName = "NB", fontSize = 45)
/*     */   public static IFontRenderer nbicon45;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 13)
/*     */   public static IFontRenderer font25;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 15)
/*     */   public static IFontRenderer font30;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 18)
/*     */   public static IFontRenderer font35;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 20)
/*     */   public static IFontRenderer font40;
/*     */   @FontDetails(fontName = "sfbold35", fontSize = 40)
/*     */   public static GameFontRenderer sfbold35;
/*     */   @FontDetails(fontName = "comfortaa", fontSize = 96)
/*     */   public static IFontRenderer com96;
/*     */   @FontDetails(fontName = "SFUI Regular", fontSize = 35)
/*     */   public static IFontRenderer fontSFUI35;
/*     */   @FontDetails(fontName = "Bold", fontSize = 30)
/*     */   public static IFontRenderer bold30;
/*     */   @FontDetails(fontName = "Bold", fontSize = 35)
/*     */   public static IFontRenderer bold35;
/*     */   @FontDetails(fontName = "Chinese", fontSize = 18)
/*     */   public static GameFontRenderer Chinese18;
/*     */   @FontDetails(fontName = "sfbold100", fontSize = 40)
/*     */   public static GameFontRenderer sfbold100;
/*     */   @FontDetails(fontName = "sfbold80", fontSize = 40)
/*     */   public static GameFontRenderer sfbold80;
/*     */   @FontDetails(fontName = "sfbold40", fontSize = 40)
/*     */   public static GameFontRenderer sfbold40;
/*     */   @FontDetails(fontName = "sfbold30", fontSize = 40)
/*     */   public static GameFontRenderer sfbold30;
/*     */   @FontDetails(fontName = "sfbold28", fontSize = 28)
/*     */   public static GameFontRenderer sfbold28;
/*     */   @FontDetails(fontName = "sfbold28", fontSize = 12)
/*     */   public static GameFontRenderer sfbold12;
/*     */   @FontDetails(fontName = "sfbold28", fontSize = 25)
/*     */   public static GameFontRenderer sfbold25;
/*     */   @FontDetails(fontName = "MiSans", fontSize = 18)
/*     */   public static IFontRenderer misans35;
/*     */   @FontDetails(fontName = "MiSans", fontSize = 20)
/*     */   public static IFontRenderer misans40;
/*     */   @FontDetails(fontName = "MiSans", fontSize = 15)
/*     */   public static IFontRenderer misans30;
/*     */   @FontDetails(fontName = "MiSans", fontSize = 10)
/*     */   public static IFontRenderer misans20;
/*     */   @FontDetails(fontName = "MiSans", fontSize = 13)
/*     */   public static IFontRenderer misans25;
/*     */   @FontDetails(fontName = "MiSans", fontSize = 16)
/*     */   public static IFontRenderer misans32;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 22)
/*     */   public static IFontRenderer font43;
/*     */   @FontDetails(fontName = "Rise", fontSize = 80)
/*     */   public static IFontRenderer rise100;
/*     */   @FontDetails(fontName = "Rise", fontSize = 18)
/*     */   public static IFontRenderer rise35;
/*     */   @FontDetails(fontName = "Rise", fontSize = 15)
/*     */   public static IFontRenderer rise30;
/*     */   @FontDetails(fontName = "Rise", fontSize = 13)
/*     */   public static IFontRenderer rise25;
/*     */   @FontDetails(fontName = "Rise", fontSize = 20)
/*     */   public static IFontRenderer rise40;
/*     */   @FontDetails(fontName = "Rise", fontSize = 23)
/*     */   public static IFontRenderer rise45;
/*     */   @FontDetails(fontName = "Rise", fontSize = 25)
/*     */   public static IFontRenderer rise50;
/*     */   @FontDetails(fontName = "Rise", fontSize = 30)
/*     */   public static IFontRenderer riseGuilogin;
/*     */   @FontDetails(fontName = "Title", fontSize = 15)
/*     */   public static IFontRenderer title30;
/*     */   @FontDetails(fontName = "Title", fontSize = 13)
/*     */   public static IFontRenderer title25;
/*     */   @FontDetails(fontName = "Title", fontSize = 18)
/*     */   public static IFontRenderer title35;
/*     */   @FontDetails(fontName = "Title", fontSize = 20)
/*     */   public static IFontRenderer title40;
/*     */   @FontDetails(fontName = "Neverlose900", fontSize = 18)
/*     */   public static IFontRenderer never900_35;
/*     */   @FontDetails(fontName = "Neverlose900", fontSize = 20)
/*     */   public static IFontRenderer never900_40;
/*     */   @FontDetails(fontName = "Neverlose900", fontSize = 23)
/*     */   public static IFontRenderer never900_45;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 80)
/*     */   public static IFontRenderer font80;
/*     */   @FontDetails(fontName = "Newuifont", fontSize = 15)
/*     */   public static IFontRenderer Newuifont12;
/*     */   @FontDetails(fontName = "Newuifont", fontSize = 17)
/*     */   public static IFontRenderer Newuifont17;
/*     */   @FontDetails(fontName = "Novoicon", fontSize = 25)
/*     */   public static IFontRenderer Novoicon_25;
/*     */   @FontDetails(fontName = "Newuifont", fontSize = 15)
/*     */   public static IFontRenderer Newuifont15;
/*     */   @FontDetails(fontName = "Newbold", fontSize = 20)
/*     */   public static IFontRenderer NewBold20;
/*     */   @FontDetails(fontName = "Roboto Medium", fontSize = 35)
/*     */   public static IFontRenderer font50;
/*     */   @FontDetails(fontName = "MenuIcon", fontSize = 50)
/*     */   public static IFontRenderer ico50;
/*     */   @FontDetails(fontName = "Notion 40", fontSize = 40)
/*     */   public static IFontRenderer no40;
/*     */   
/*     */   public static void loadFonts() {
/* 238 */     long l = System.currentTimeMillis();
/*     */     
/* 240 */     ClientUtils.getLogger().info("Loading Fonts.");
/* 241 */     Bnk40 = getFont("bnk.ttf", 53);
/* 242 */     icon25 = getFont("hicon.ttf", 12);
/* 243 */     icon50 = getFont("hicon.ttf", 20);
/* 244 */     font50 = getFont("sfui.ttf", 50);
/* 245 */     hicon45 = getFont("hicon.ttf", 45);
/* 246 */     ico50 = getFont("ico.ttf", 50);
/* 247 */     fontSFUI120 = classProvider.wrapFontRenderer(new GameFontRenderer(getsfui(120)));
/* 248 */     font80 = classProvider.wrapFontRenderer(new GameFontRenderer(getsfui(80)));
/* 249 */     NewBold20 = getFont("huahuo.ttf", 20);
/* 250 */     Novoicon_25 = getFont("novosession.ttf", 25);
/* 251 */     Newuifont15 = getFont("tenacitybold.ttf", 15);
/* 252 */     Newuifont17 = getFont("tenacitybold.ttf", 17);
/* 253 */     Newuifont12 = getFont("tenacitybold.ttf", 13);
/* 254 */     Newuifont25 = getFont("tenacitybold.ttf", 18);
/* 255 */     Chinese16 = new GameFontRenderer(getsfbold(37));
/* 256 */     newtenacity40 = getFont("gcf.ttf", 20);
/* 257 */     newtenacity45 = getFont("gcf.ttf", 23);
/* 258 */     tenacity80 = getFont("bold.ttf", 40);
/* 259 */     tenacity100 = getFont("bold.ttf", 80);
/* 260 */     tenacity40 = getFont("bold.ttf", 20);
/* 261 */     tenacity20 = getFont("bold.ttf", 10);
/* 262 */     micon15 = new GameFontRenderer(gets3(25));
/* 263 */     sellena100 = getFont("SellenaBrush.ttf", 70);
/* 264 */     tenacitybold25 = getFont("bold.ttf", 13);
/* 265 */     tenacitybold30 = getFont("bold.ttf", 15);
/* 266 */     tenacitybold35 = getFont("bold.ttf", 18);
/* 267 */     tenacitybold40 = getFont("bold.ttf", 20);
/* 268 */     tenacitybold42 = getFont("bold.ttf", 21);
/* 269 */     gct = getFont("gcf.ttf", 16);
/* 270 */     micon30 = new GameFontRenderer(gets3(40));
/*     */     
/* 272 */     tenacitybold50 = getFont("bold.ttf", 25);
/* 273 */     Posterama35 = classProvider.wrapFontRenderer(new GameFontRenderer(getPosterama(35)));
/* 274 */     cf40 = getFont("clientfont.ttf", 20);
/* 275 */     never900_35 = getFont("neverlose900.ttf", 18);
/* 276 */     never900_40 = getFont("neverlose900.ttf", 20);
/* 277 */     never900_45 = getFont("neverlose900.ttf", 23);
/* 278 */     title25 = getFont("title.ttf", 13);
/* 279 */     title30 = getFont("title.ttf", 15);
/* 280 */     title35 = getFont("title.ttf", 18);
/* 281 */     title40 = getFont("title.ttf", 20);
/* 282 */     rise100 = getFont("notosans1.ttf", 80);
/* 283 */     rise40 = getFont("notosans1.ttf", 20);
/* 284 */     rise45 = getFont("notosans1.ttf", 23);
/* 285 */     rise35 = getFont("notosans1.ttf", 18);
/* 286 */     rise30 = getFont("notosans1.ttf", 15);
/* 287 */     rise25 = getFont("notosans1.ttf", 13);
/* 288 */     rise50 = getFont("notosans1.ttf", 25);
/* 289 */     rubik26 = getFont("rubik.ttf", 13);
/* 290 */     rubik30 = getFont("rubik.ttf", 15);
/* 291 */     rubik35 = getFont("rubik.ttf", 18);
/* 292 */     rubik40 = getFont("rubik.ttf", 20);
/* 293 */     rubik45 = getFont("rubik.ttf", 23);
/* 294 */     SFUI35 = new GameFontRenderer(getsfui(40));
/* 295 */     Chinese18 = new GameFontRenderer(getsfbold(38));
/* 296 */     bold30 = getFont("blod.ttf", 15);
/* 297 */     bold35 = getFont("blod.ttf", 13);
/* 298 */     com96 = getFont("comfortaa.ttf", 13);
/* 299 */     fontSFUI35 = getFont("sfuidisplayregular.ttf", 13);
/* 300 */     font25 = getFont("sfui.ttf", 13);
/* 301 */     font30 = getFont("sfui.ttf", 15);
/* 302 */     font35 = getFont("sfui.ttf", 18);
/* 303 */     font40 = getFont("sfui.ttf", 20);
/* 304 */     font43 = getFont("sfui.ttf", 22);
/* 305 */     roboto35 = getFont("roboto-medium.ttf", 18);
/* 306 */     roboto40 = getFont("roboto-medium.ttf", 20);
/* 307 */     robotoBold180 = getFont("roboto-bold.ttf", 90);
/* 308 */     productSans35 = getFont("product-sans.ttf", 18);
/* 309 */     productSans40 = getFont("product-sans.ttf", 20);
/* 310 */     productSans70 = getFont("product-sans.ttf", 37);
/* 311 */     productSans80 = getFont("product-sans.ttf", 40);
/* 312 */     productSans35 = getFont("product-sans.ttf", 18);
/* 313 */     productSans52 = getFont("product-sans.ttf", 26);
/* 314 */     productSans26 = getFont("product-sans.ttf", 13);
/* 315 */     productSans30 = getFont("product-sans.ttf", 14);
/* 316 */     productSans40 = getFont("product-sans.ttf", 20);
/* 317 */     productSans45 = getFont("product-sans.ttf", 23);
/* 318 */     productSans50 = getFont("product-sans.ttf", 25);
/* 319 */     productSans80 = getFont("product-sans.ttf", 40);
/* 320 */     notificationIcon70 = getFont("notification-icon.ttf", 35);
/* 321 */     posterama30 = getFont("posterama.ttf", 15);
/* 322 */     posterama35 = getFont("posterama.ttf", 18);
/* 323 */     posterama40 = getFont("posterama.ttf", 20);
/* 324 */     tenacity40 = getFont("tenacitybold.ttf", 40);
/* 325 */     tenacity80 = getFont("tenacitybold.ttf", 40);
/* 326 */     tenacitybold30 = getFont("tenacitybold.ttf", 15);
/* 327 */     tenacitybold35 = getFont("tenacitybold.ttf", 18);
/* 328 */     tenacitybold40 = getFont("tenacitybold.ttf", 20);
/* 329 */     tenacitybold43 = getFont("tenacitybold.ttf", 21);
/* 330 */     tenacitycheck60 = getFont("tenacitycheck.ttf", 30);
/* 331 */     flux = getFont("fluxicon.ttf", 18);
/* 332 */     flux45 = getFont("fluxicon.ttf", 23);
/* 333 */     com30 = classProvider.wrapFontRenderer(new GameFontRenderer(getCom(30)));
/* 334 */     com35 = classProvider.wrapFontRenderer(new GameFontRenderer(getCom(35)));
/* 335 */     sfbold100 = new GameFontRenderer(getsfbold(100));
/* 336 */     sfbold80 = new GameFontRenderer(getsfbold(80));
/* 337 */     sfbold40 = new GameFontRenderer(getsfbold(40));
/* 338 */     sfbold35 = new GameFontRenderer(getsfbold(35));
/* 339 */     sfbold30 = new GameFontRenderer(getsfbold(30));
/* 340 */     sfbold28 = new GameFontRenderer(getsfbold(28));
/* 341 */     sfbold12 = new GameFontRenderer(getsfbold(15));
/* 342 */     sfbold25 = new GameFontRenderer(getsfbold(22));
/* 343 */     fontSFUI56 = classProvider.wrapFontRenderer(new GameFontRenderer(getsfui(56)));
/* 344 */     nbicon18 = getFont("newicon.ttf", 18);
/* 345 */     nbicon20 = getFont("newicon.ttf", 23);
/* 346 */     nbicon40 = getFont("newicon.ttf", 40);
/* 347 */     nbicon45 = getFont("newicon.ttf", 45);
/* 348 */     misans35 = getFont("misans.ttf", 18);
/* 349 */     misans40 = getFont("misans.ttf", 20);
/* 350 */     misans30 = getFont("misans.ttf", 15);
/* 351 */     misans20 = getFont("misans.ttf", 10);
/* 352 */     misans25 = getFont("misans.ttf", 13);
/* 353 */     misans32 = getFont("misans.ttf", 16);
/* 354 */     misans40 = getFont("misans.ttf", 20);
/* 355 */     no40 = getFont("notion.ttf", 40);
/* 356 */     ClientUtils.getLogger().info("Loaded Fonts. (" + (System.currentTimeMillis() - l) + "ms)");
/*     */   }
/*     */   private static Font gets3(int size) {
/*     */     Font font;
/*     */     try {
/* 361 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("liquidbounce/font/micon.ttf")).func_110527_b();
/* 362 */       font = Font.createFont(0, is);
/* 363 */       font = font.deriveFont(0, size);
/* 364 */     } catch (Exception ex) {
/* 365 */       ex.printStackTrace();
/* 366 */       System.out.println("Error loading font");
/* 367 */       font = new Font("Posterama", 0, size);
/*     */     } 
/* 369 */     return font;
/*     */   }
/*     */   
/*     */   public static IFontRenderer getFontRenderer(String name, int size) {
/* 373 */     for (Field field : Fonts.class.getDeclaredFields()) {
/*     */       try {
/* 375 */         field.setAccessible(true);
/*     */         
/* 377 */         Object o = field.get(null);
/*     */         
/* 379 */         if (o instanceof IFontRenderer) {
/* 380 */           FontDetails fontDetails = field.<FontDetails>getAnnotation(FontDetails.class);
/*     */           
/* 382 */           if (fontDetails.fontName().equals(name) && fontDetails.fontSize() == size)
/* 383 */             return (IFontRenderer)o; 
/*     */         } 
/* 385 */       } catch (IllegalAccessException e) {
/* 386 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 390 */     return getFont("default", 35);
/*     */   }
/*     */   
/*     */   public static FontInfo getFontDetails(IFontRenderer fontRenderer) {
/* 394 */     for (Field field : Fonts.class.getDeclaredFields()) {
/*     */       try {
/* 396 */         field.setAccessible(true);
/*     */         
/* 398 */         Object o = field.get(null);
/*     */         
/* 400 */         System.out.println((field.get(null) == null));
/*     */         
/* 402 */         if (o.equals(fontRenderer)) {
/* 403 */           FontDetails fontDetails = field.<FontDetails>getAnnotation(FontDetails.class);
/*     */           
/* 405 */           return new FontInfo(fontDetails.fontName(), fontDetails.fontSize());
/*     */         } 
/* 407 */       } catch (IllegalAccessException e) {
/* 408 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 412 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<IFontRenderer> getFonts() {
/* 417 */     List<IFontRenderer> fonts = new ArrayList<>();
/*     */     
/* 419 */     for (Field fontField : Fonts.class.getDeclaredFields()) {
/*     */       try {
/* 421 */         fontField.setAccessible(true);
/*     */         
/* 423 */         Object fontObj = fontField.get(null);
/*     */         
/* 425 */         if (fontObj instanceof IFontRenderer) fonts.add((IFontRenderer)fontObj); 
/* 426 */       } catch (IllegalAccessException e) {
/* 427 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 431 */     return fonts;
/*     */   }
/*     */   private static Font gett(int size) {
/*     */     Font font;
/*     */     try {
/* 436 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/tenacitybold.ttf")).func_110527_b();
/* 437 */       font = Font.createFont(0, is);
/* 438 */       font = font.deriveFont(0, size);
/* 439 */     } catch (Exception ex) {
/* 440 */       ex.printStackTrace();
/* 441 */       System.out.println("Error loading font");
/* 442 */       font = new Font("Posterama", 0, size);
/*     */     } 
/* 444 */     return font;
/*     */   }
/*     */   private static Font getPosterama(int size) {
/*     */     Font font;
/*     */     try {
/* 449 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("CatBounce/font/PosteramaText-Regular.otf")).func_110527_b();
/* 450 */       font = Font.createFont(0, is);
/* 451 */       font = font.deriveFont(0, size);
/* 452 */     } catch (Exception ex) {
/* 453 */       ex.printStackTrace();
/* 454 */       System.out.println("Error loading font");
/* 455 */       font = new Font("Posterama", 0, size);
/*     */     } 
/* 457 */     return font;
/*     */   }
/*     */   private static Font getsfui(int size) {
/*     */     Font font;
/*     */     try {
/* 462 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/sfui.ttf")).func_110527_b();
/* 463 */       font = Font.createFont(0, is);
/* 464 */       font = font.deriveFont(0, size);
/* 465 */     } catch (Exception ex) {
/* 466 */       ex.printStackTrace();
/* 467 */       System.out.println("Error loading font");
/* 468 */       font = new Font("Sfui", 0, size);
/*     */     } 
/* 470 */     return font;
/*     */   }
/*     */   private static Font getsfbold(int size) {
/*     */     Font font;
/*     */     try {
/* 475 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/fz.ttf")).func_110527_b();
/* 476 */       font = Font.createFont(0, is);
/* 477 */       font = font.deriveFont(0, size);
/* 478 */     } catch (Exception ex) {
/* 479 */       ex.printStackTrace();
/* 480 */       System.out.println("Error loading font");
/* 481 */       font = new Font("Posterama", 0, size);
/*     */     } 
/* 483 */     return font;
/*     */   }
/*     */   private static Font getCom(int size) {
/*     */     Font font;
/*     */     try {
/* 488 */       InputStream is = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/font/comfortaa.ttf")).func_110527_b();
/* 489 */       font = Font.createFont(0, is);
/* 490 */       font = font.deriveFont(0, size);
/* 491 */     } catch (Exception ex) {
/* 492 */       ex.printStackTrace();
/* 493 */       System.out.println("Error loading font");
/* 494 */       font = new Font("default", 0, size);
/*     */     } 
/* 496 */     return font;
/*     */   }
/*     */   
/*     */   private static IFontRenderer getFont(String fontName, int size) {
/*     */     Font font;
/*     */     try {
/* 502 */       InputStream inputStream = minecraft.func_110442_L().func_110536_a(new ResourceLocation("tomk/font/" + fontName)).func_110527_b();
/* 503 */       Font awtClientFont = Font.createFont(0, inputStream);
/* 504 */       awtClientFont = awtClientFont.deriveFont(0, size);
/* 505 */       inputStream.close();
/* 506 */       font = awtClientFont;
/* 507 */     } catch (Exception e) {
/* 508 */       e.printStackTrace();
/* 509 */       font = new Font("default", 0, size);
/*     */     } 
/*     */     
/* 512 */     return classProvider.wrapFontRenderer(new GameFontRenderer(font));
/*     */   }
/*     */   
/*     */   public static class FontInfo {
/*     */     private final String name;
/*     */     private final int fontSize;
/*     */     
/*     */     public FontInfo(String name, int fontSize) {
/* 520 */       this.name = name;
/* 521 */       this.fontSize = fontSize;
/*     */     }
/*     */     
/*     */     public FontInfo(Font font) {
/* 525 */       this(font.getName(), font.getSize());
/*     */     }
/*     */     
/*     */     public String getName() {
/* 529 */       return this.name;
/*     */     }
/*     */     
/*     */     public int getFontSize() {
/* 533 */       return this.fontSize;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/* 538 */       if (this == o) return true; 
/* 539 */       if (o == null || getClass() != o.getClass()) return false;
/*     */       
/* 541 */       FontInfo fontInfo = (FontInfo)o;
/*     */       
/* 543 */       if (this.fontSize != fontInfo.fontSize) return false; 
/* 544 */       return Objects.equals(this.name, fontInfo.name);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 549 */       int result = (this.name != null) ? this.name.hashCode() : 0;
/* 550 */       result = 31 * result + this.fontSize;
/* 551 */       return result;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\Fonts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */