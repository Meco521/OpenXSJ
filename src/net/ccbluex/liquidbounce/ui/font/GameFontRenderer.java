/*     */ package net.ccbluex.liquidbounce.ui.font;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.event.TextEvent;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\020\b\n\002\b\t\n\002\020\016\n\000\n\002\020\007\n\002\b\003\n\002\020\013\n\002\b\t\n\002\020\f\n\002\b\005\030\000 ,2\0020\001:\001,B\r\022\006\020\002\032\0020\003¢\006\002\020\004J(\020\026\032\0020\0162\006\020\027\032\0020\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\016H\026J0\020\026\032\0020\0162\006\020\027\032\0020\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\0162\006\020\035\032\0020\036H\026J(\020\037\032\0020\0162\006\020 \032\0020\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\016H\026J*\020!\032\0020\0162\b\020\027\032\004\030\0010\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\016H\026J2\020!\032\0020\0162\b\020 \032\004\030\0010\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\0162\006\020\035\032\0020\036H\026J*\020\"\032\0020\0162\b\020 \032\004\030\0010\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\016H\026J<\020#\032\0020\0162\b\020 \032\004\030\0010\0302\006\020\031\032\0020\0322\006\020\033\032\0020\0322\006\020\034\032\0020\0162\006\020$\032\0020\0362\b\b\002\020%\032\0020\036H\002J\020\020&\032\0020\0162\006\020'\032\0020(H\026J\020\020)\032\0020\0162\006\020*\032\0020(H\026J\022\020+\032\0020\0162\b\020 \032\004\030\0010\030H\026R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\006X\016¢\006\002\n\000R\032\020\b\032\0020\006X\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\021\020\r\032\0020\016¢\006\b\n\000\032\004\b\017\020\020R\021\020\021\032\0020\0168F¢\006\006\032\004\b\022\020\020R\016\020\023\032\0020\006X\016¢\006\002\n\000R\021\020\024\032\0020\0168F¢\006\006\032\004\b\025\020\020¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;", "Lnet/ccbluex/liquidbounce/api/util/IWrappedFontRenderer;", "font", "Ljava/awt/Font;", "(Ljava/awt/Font;)V", "boldFont", "Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;", "boldItalicFont", "defaultFont", "getDefaultFont", "()Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;", "setDefaultFont", "(Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;)V", "fontHeight", "", "getFontHeight", "()I", "height", "getHeight", "italicFont", "size", "getSize", "drawCenteredString", "s", "", "x", "", "y", "color", "shadow", "", "drawCenteredStringWithShadow", "text", "drawString", "drawStringWithShadow", "drawText", "ignoreColor", "rainbow", "getCharWidth", "character", "", "getColorCode", "charCode", "getStringWidth", "Companion", "XSJClient"})
/*     */ public final class GameFontRenderer implements IWrappedFontRenderer {
/*     */   private final int fontHeight;
/*     */   @NotNull
/*     */   private AWTFontRenderer defaultFont;
/*     */   private AWTFontRenderer boldFont;
/*     */   private AWTFontRenderer italicFont;
/*     */   private AWTFontRenderer boldItalicFont;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*  19 */   public GameFontRenderer(@NotNull Font font) { this.defaultFont = new AWTFontRenderer(font, 0, 0, 6, null);
/*  20 */     Intrinsics.checkExpressionValueIsNotNull(font.deriveFont(1), "font.deriveFont(Font.BOLD)"); this.boldFont = new AWTFontRenderer(font.deriveFont(1), 0, 0, 6, null);
/*  21 */     Intrinsics.checkExpressionValueIsNotNull(font.deriveFont(2), "font.deriveFont(Font.ITALIC)"); this.italicFont = new AWTFontRenderer(font.deriveFont(2), 0, 0, 6, null);
/*  22 */     Intrinsics.checkExpressionValueIsNotNull(font.deriveFont(3), "font.deriveFont(Font.BOLD or Font.ITALIC)"); this.boldItalicFont = new AWTFontRenderer(font.deriveFont(3), 0, 0, 6, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  31 */     this.fontHeight = getHeight(); }
/*     */   public final int getFontHeight() { return this.fontHeight; }
/*     */   @NotNull
/*  34 */   public final AWTFontRenderer getDefaultFont() { return this.defaultFont; } public int drawString(@Nullable String s, float x, float y, int color) { return drawString(s, x, y, color, false); }
/*     */   public final void setDefaultFont(@NotNull AWTFontRenderer <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.defaultFont = <set-?>; }
/*  36 */   public final int getHeight() { return this.defaultFont.getHeight(); } public final int getSize() { return this.defaultFont.getFont().getSize(); } public int drawStringWithShadow(@Nullable String text, float x, float y, int color) { return drawString(text, x, y, color, true); }
/*     */    public int drawCenteredString(@NotNull String s, float x, float y, int color, boolean shadow) {
/*  38 */     Intrinsics.checkParameterIsNotNull(s, "s"); return drawString(s, x - getStringWidth(s) / 2.0F, y, color, shadow);
/*     */   }
/*     */   public int drawCenteredString(@NotNull String s, float x, float y, int color) {
/*  41 */     Intrinsics.checkParameterIsNotNull(s, "s"); return drawStringWithShadow(s, x - getStringWidth(s) / 2.0F, y, color);
/*     */   }
/*     */   
/*  44 */   public int drawString(@Nullable String text, float x, float y, int color, boolean shadow) { String currentText = text;
/*     */     
/*  46 */     TextEvent event = new TextEvent(currentText);
/*  47 */     Retreat.INSTANCE.getEventManager().callEvent((Event)event);
/*  48 */     if (event.getText() != null) { currentText = event.getText();
/*     */       
/*  50 */       float currY = y - 3.0F;
/*     */       
/*  52 */       boolean rainbow = RainbowFontShader.INSTANCE.isInUse();
/*     */       
/*  54 */       if (shadow) {
/*  55 */         GL20.glUseProgram(0);
/*  56 */         if (((String)CustomFont.shadowValue.get()).equals("LiquidBounce")) {
/*  57 */           drawText$default(this, currentText, x + 1.0F, currY + 1.0F, (new Color(0, 0, 0, 150)).getRGB(), true, false, 32, null);
/*  58 */         } else if (((String)CustomFont.shadowValue.get()).equals("Default")) {
/*  59 */           drawText$default(this, currentText, x + 0.5F, currY + 0.5F, (new Color(0, 0, 0, 130)).getRGB(), true, false, 32, null);
/*  60 */         } else if (((String)CustomFont.shadowValue.get()).equals("Custom")) {
/*  61 */           drawText$default(this, currentText, x + ((Number)CustomFont.shadowstrenge.get()).floatValue(), currY + ((Number)CustomFont.shadowstrenge.get()).floatValue(), (new Color(20, 20, 20, 200)).getRGB(), true, false, 32, null);
/*  62 */         } else if (((String)CustomFont.shadowValue.get()).equals("Outline")) {
/*  63 */           drawText$default(this, currentText, x + 0.5F, currY + 0.5F, (new Color(0, 0, 0, 130)).getRGB(), true, false, 32, null);
/*  64 */           drawText$default(this, currentText, x - 0.5F, currY - 0.5F, (new Color(0, 0, 0, 130)).getRGB(), true, false, 32, null);
/*  65 */           drawText$default(this, currentText, x + 0.5F, currY - 0.5F, (new Color(0, 0, 0, 130)).getRGB(), true, false, 32, null);
/*  66 */           drawText$default(this, currentText, x - 0.5F, currY + 0.5F, (new Color(0, 0, 0, 130)).getRGB(), true, false, 32, null);
/*     */         } 
/*     */       } 
/*  69 */       return drawText(currentText, x, currY, color, false, rainbow); }
/*     */     
/*     */     event.getText();
/*     */     return 0; } public int drawCenteredStringWithShadow(@NotNull String text, float x, float y, int color) {
/*  73 */     Intrinsics.checkParameterIsNotNull(text, "text"); return drawCenteredString(text, x, y, color, true);
/*     */   }
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
/*     */   private final int drawText(String text, float x, float y, int color, boolean ignoreColor, boolean rainbow) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 6
/*     */     //   4: iconst_0
/*     */     //   5: ireturn
/*     */     //   6: aload_1
/*     */     //   7: checkcast java/lang/CharSequence
/*     */     //   10: astore #7
/*     */     //   12: iconst_0
/*     */     //   13: istore #8
/*     */     //   15: aload #7
/*     */     //   17: invokeinterface length : ()I
/*     */     //   22: ifne -> 29
/*     */     //   25: iconst_1
/*     */     //   26: goto -> 30
/*     */     //   29: iconst_0
/*     */     //   30: ifeq -> 36
/*     */     //   33: fload_2
/*     */     //   34: f2i
/*     */     //   35: ireturn
/*     */     //   36: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/RainbowFontShader;
/*     */     //   39: invokevirtual getProgramId : ()I
/*     */     //   42: istore #7
/*     */     //   44: iload #6
/*     */     //   46: ifeq -> 54
/*     */     //   49: iload #7
/*     */     //   51: invokestatic glUseProgram : (I)V
/*     */     //   54: fload_2
/*     */     //   55: f2d
/*     */     //   56: ldc2_w 1.5
/*     */     //   59: dsub
/*     */     //   60: fload_3
/*     */     //   61: f2d
/*     */     //   62: ldc2_w 0.5
/*     */     //   65: dadd
/*     */     //   66: dconst_0
/*     */     //   67: invokestatic glTranslated : (DDD)V
/*     */     //   70: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   73: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   76: invokeinterface getGlStateManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;
/*     */     //   81: invokeinterface enableAlpha : ()V
/*     */     //   86: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   89: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   92: invokeinterface getGlStateManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;
/*     */     //   97: invokeinterface enableBlend : ()V
/*     */     //   102: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   105: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   108: invokeinterface getGlStateManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;
/*     */     //   113: sipush #770
/*     */     //   116: sipush #771
/*     */     //   119: iconst_1
/*     */     //   120: iconst_0
/*     */     //   121: invokeinterface tryBlendFuncSeparate : (IIII)V
/*     */     //   126: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   129: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   132: invokeinterface getGlStateManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;
/*     */     //   137: invokeinterface enableTexture2D : ()V
/*     */     //   142: iload #4
/*     */     //   144: istore #8
/*     */     //   146: iload #8
/*     */     //   148: ldc_w -67108864
/*     */     //   151: iand
/*     */     //   152: ifne -> 163
/*     */     //   155: iload #8
/*     */     //   157: ldc_w -16777216
/*     */     //   160: ior
/*     */     //   161: istore #8
/*     */     //   163: iload #8
/*     */     //   165: istore #9
/*     */     //   167: iload #8
/*     */     //   169: bipush #24
/*     */     //   171: ishr
/*     */     //   172: sipush #255
/*     */     //   175: iand
/*     */     //   176: istore #10
/*     */     //   178: aload_1
/*     */     //   179: checkcast java/lang/CharSequence
/*     */     //   182: ldc_w '§'
/*     */     //   185: checkcast java/lang/CharSequence
/*     */     //   188: iconst_0
/*     */     //   189: iconst_2
/*     */     //   190: aconst_null
/*     */     //   191: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   194: ifeq -> 854
/*     */     //   197: aload_1
/*     */     //   198: checkcast java/lang/CharSequence
/*     */     //   201: iconst_1
/*     */     //   202: anewarray java/lang/String
/*     */     //   205: dup
/*     */     //   206: iconst_0
/*     */     //   207: ldc_w '§'
/*     */     //   210: aastore
/*     */     //   211: iconst_0
/*     */     //   212: iconst_0
/*     */     //   213: bipush #6
/*     */     //   215: aconst_null
/*     */     //   216: invokestatic split$default : (Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
/*     */     //   219: astore #11
/*     */     //   221: aload_0
/*     */     //   222: getfield defaultFont : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   225: astore #12
/*     */     //   227: dconst_0
/*     */     //   228: dstore #33
/*     */     //   230: iconst_0
/*     */     //   231: istore #13
/*     */     //   233: iconst_0
/*     */     //   234: istore #14
/*     */     //   236: iconst_0
/*     */     //   237: istore #15
/*     */     //   239: iconst_0
/*     */     //   240: istore #16
/*     */     //   242: iconst_0
/*     */     //   243: istore #17
/*     */     //   245: aload #11
/*     */     //   247: checkcast java/lang/Iterable
/*     */     //   250: astore #18
/*     */     //   252: iconst_0
/*     */     //   253: istore #19
/*     */     //   255: iconst_0
/*     */     //   256: istore #20
/*     */     //   258: aload #18
/*     */     //   260: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   265: astore #21
/*     */     //   267: aload #21
/*     */     //   269: invokeinterface hasNext : ()Z
/*     */     //   274: ifeq -> 851
/*     */     //   277: aload #21
/*     */     //   279: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   284: astore #22
/*     */     //   286: iload #20
/*     */     //   288: iinc #20, 1
/*     */     //   291: istore #23
/*     */     //   293: iconst_0
/*     */     //   294: istore #24
/*     */     //   296: iload #23
/*     */     //   298: ifge -> 304
/*     */     //   301: invokestatic throwIndexOverflow : ()V
/*     */     //   304: iload #23
/*     */     //   306: istore #25
/*     */     //   308: iload #25
/*     */     //   310: aload #22
/*     */     //   312: checkcast java/lang/String
/*     */     //   315: astore #26
/*     */     //   317: istore #27
/*     */     //   319: iconst_0
/*     */     //   320: istore #28
/*     */     //   322: aload #26
/*     */     //   324: checkcast java/lang/CharSequence
/*     */     //   327: astore #29
/*     */     //   329: iconst_0
/*     */     //   330: istore #30
/*     */     //   332: aload #29
/*     */     //   334: invokeinterface length : ()I
/*     */     //   339: ifne -> 346
/*     */     //   342: iconst_1
/*     */     //   343: goto -> 347
/*     */     //   346: iconst_0
/*     */     //   347: ifeq -> 353
/*     */     //   350: goto -> 847
/*     */     //   353: iload #27
/*     */     //   355: ifne -> 386
/*     */     //   358: aload #12
/*     */     //   360: aload #26
/*     */     //   362: dload #33
/*     */     //   364: dconst_0
/*     */     //   365: iload #8
/*     */     //   367: invokevirtual drawString : (Ljava/lang/String;DDI)V
/*     */     //   370: dload #33
/*     */     //   372: aload #12
/*     */     //   374: aload #26
/*     */     //   376: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   379: i2d
/*     */     //   380: dadd
/*     */     //   381: dstore #33
/*     */     //   383: goto -> 846
/*     */     //   386: aload #26
/*     */     //   388: astore #30
/*     */     //   390: iconst_1
/*     */     //   391: istore #31
/*     */     //   393: iconst_0
/*     */     //   394: istore #32
/*     */     //   396: aload #30
/*     */     //   398: dup
/*     */     //   399: ifnonnull -> 413
/*     */     //   402: new kotlin/TypeCastException
/*     */     //   405: dup
/*     */     //   406: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   409: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   412: athrow
/*     */     //   413: iload #31
/*     */     //   415: invokevirtual substring : (I)Ljava/lang/String;
/*     */     //   418: dup
/*     */     //   419: ldc_w '(this as java.lang.String).substring(startIndex)'
/*     */     //   422: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   425: astore #29
/*     */     //   427: aload #26
/*     */     //   429: iconst_0
/*     */     //   430: invokevirtual charAt : (I)C
/*     */     //   433: istore #30
/*     */     //   435: getstatic net/ccbluex/liquidbounce/ui/font/GameFontRenderer.Companion : Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer$Companion;
/*     */     //   438: iload #30
/*     */     //   440: invokevirtual getColorIndex : (C)I
/*     */     //   443: istore #31
/*     */     //   445: bipush #15
/*     */     //   447: iconst_0
/*     */     //   448: iload #31
/*     */     //   450: istore #32
/*     */     //   452: iload #32
/*     */     //   454: if_icmple -> 461
/*     */     //   457: pop
/*     */     //   458: goto -> 512
/*     */     //   461: iload #32
/*     */     //   463: if_icmplt -> 512
/*     */     //   466: iload #5
/*     */     //   468: ifne -> 494
/*     */     //   471: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.hexColors : [I
/*     */     //   474: iload #31
/*     */     //   476: iaload
/*     */     //   477: iload #10
/*     */     //   479: bipush #24
/*     */     //   481: ishl
/*     */     //   482: ior
/*     */     //   483: istore #8
/*     */     //   485: iload #6
/*     */     //   487: ifeq -> 494
/*     */     //   490: iconst_0
/*     */     //   491: invokestatic glUseProgram : (I)V
/*     */     //   494: iconst_0
/*     */     //   495: istore #14
/*     */     //   497: iconst_0
/*     */     //   498: istore #15
/*     */     //   500: iconst_0
/*     */     //   501: istore #13
/*     */     //   503: iconst_0
/*     */     //   504: istore #17
/*     */     //   506: iconst_0
/*     */     //   507: istore #16
/*     */     //   509: goto -> 630
/*     */     //   512: iload #31
/*     */     //   514: bipush #16
/*     */     //   516: if_icmpne -> 525
/*     */     //   519: iconst_1
/*     */     //   520: istore #13
/*     */     //   522: goto -> 630
/*     */     //   525: iload #31
/*     */     //   527: bipush #17
/*     */     //   529: if_icmpne -> 538
/*     */     //   532: iconst_1
/*     */     //   533: istore #14
/*     */     //   535: goto -> 630
/*     */     //   538: iload #31
/*     */     //   540: bipush #18
/*     */     //   542: if_icmpne -> 551
/*     */     //   545: iconst_1
/*     */     //   546: istore #16
/*     */     //   548: goto -> 630
/*     */     //   551: iload #31
/*     */     //   553: bipush #19
/*     */     //   555: if_icmpne -> 564
/*     */     //   558: iconst_1
/*     */     //   559: istore #17
/*     */     //   561: goto -> 630
/*     */     //   564: iload #31
/*     */     //   566: bipush #20
/*     */     //   568: if_icmpne -> 577
/*     */     //   571: iconst_1
/*     */     //   572: istore #15
/*     */     //   574: goto -> 630
/*     */     //   577: iload #31
/*     */     //   579: bipush #21
/*     */     //   581: if_icmpne -> 630
/*     */     //   584: iload #4
/*     */     //   586: istore #8
/*     */     //   588: iload #8
/*     */     //   590: ldc_w -67108864
/*     */     //   593: iand
/*     */     //   594: ifne -> 605
/*     */     //   597: iload #8
/*     */     //   599: ldc_w -16777216
/*     */     //   602: ior
/*     */     //   603: istore #8
/*     */     //   605: iload #6
/*     */     //   607: ifeq -> 615
/*     */     //   610: iload #7
/*     */     //   612: invokestatic glUseProgram : (I)V
/*     */     //   615: iconst_0
/*     */     //   616: istore #14
/*     */     //   618: iconst_0
/*     */     //   619: istore #15
/*     */     //   621: iconst_0
/*     */     //   622: istore #13
/*     */     //   624: iconst_0
/*     */     //   625: istore #17
/*     */     //   627: iconst_0
/*     */     //   628: istore #16
/*     */     //   630: iload #14
/*     */     //   632: ifeq -> 647
/*     */     //   635: iload #15
/*     */     //   637: ifeq -> 647
/*     */     //   640: aload_0
/*     */     //   641: getfield boldItalicFont : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   644: goto -> 675
/*     */     //   647: iload #14
/*     */     //   649: ifeq -> 659
/*     */     //   652: aload_0
/*     */     //   653: getfield boldFont : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   656: goto -> 675
/*     */     //   659: iload #15
/*     */     //   661: ifeq -> 671
/*     */     //   664: aload_0
/*     */     //   665: getfield italicFont : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   668: goto -> 675
/*     */     //   671: aload_0
/*     */     //   672: getfield defaultFont : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   675: astore #12
/*     */     //   677: aload #12
/*     */     //   679: iload #13
/*     */     //   681: ifeq -> 695
/*     */     //   684: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   687: aload #29
/*     */     //   689: invokevirtual randomMagicText : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   692: goto -> 697
/*     */     //   695: aload #29
/*     */     //   697: dload #33
/*     */     //   699: dconst_0
/*     */     //   700: iload #8
/*     */     //   702: invokevirtual drawString : (Ljava/lang/String;DDI)V
/*     */     //   705: iload #16
/*     */     //   707: ifeq -> 769
/*     */     //   710: dload #33
/*     */     //   712: ldc2_w 2.0
/*     */     //   715: ddiv
/*     */     //   716: iconst_1
/*     */     //   717: i2d
/*     */     //   718: dadd
/*     */     //   719: aload #12
/*     */     //   721: invokevirtual getHeight : ()I
/*     */     //   724: i2d
/*     */     //   725: ldc2_w 3.0
/*     */     //   728: ddiv
/*     */     //   729: dload #33
/*     */     //   731: aload #12
/*     */     //   733: aload #29
/*     */     //   735: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   738: i2d
/*     */     //   739: dadd
/*     */     //   740: ldc2_w 2.0
/*     */     //   743: ddiv
/*     */     //   744: iconst_1
/*     */     //   745: i2d
/*     */     //   746: dadd
/*     */     //   747: aload #12
/*     */     //   749: invokevirtual getHeight : ()I
/*     */     //   752: i2d
/*     */     //   753: ldc2_w 3.0
/*     */     //   756: ddiv
/*     */     //   757: aload_0
/*     */     //   758: getfield fontHeight : I
/*     */     //   761: i2f
/*     */     //   762: ldc_w 16.0
/*     */     //   765: fdiv
/*     */     //   766: invokestatic drawLine : (DDDDF)V
/*     */     //   769: iload #17
/*     */     //   771: ifeq -> 833
/*     */     //   774: dload #33
/*     */     //   776: ldc2_w 2.0
/*     */     //   779: ddiv
/*     */     //   780: iconst_1
/*     */     //   781: i2d
/*     */     //   782: dadd
/*     */     //   783: aload #12
/*     */     //   785: invokevirtual getHeight : ()I
/*     */     //   788: i2d
/*     */     //   789: ldc2_w 2.0
/*     */     //   792: ddiv
/*     */     //   793: dload #33
/*     */     //   795: aload #12
/*     */     //   797: aload #29
/*     */     //   799: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   802: i2d
/*     */     //   803: dadd
/*     */     //   804: ldc2_w 2.0
/*     */     //   807: ddiv
/*     */     //   808: iconst_1
/*     */     //   809: i2d
/*     */     //   810: dadd
/*     */     //   811: aload #12
/*     */     //   813: invokevirtual getHeight : ()I
/*     */     //   816: i2d
/*     */     //   817: ldc2_w 2.0
/*     */     //   820: ddiv
/*     */     //   821: aload_0
/*     */     //   822: getfield fontHeight : I
/*     */     //   825: i2f
/*     */     //   826: ldc_w 16.0
/*     */     //   829: fdiv
/*     */     //   830: invokestatic drawLine : (DDDDF)V
/*     */     //   833: dload #33
/*     */     //   835: aload #12
/*     */     //   837: aload #29
/*     */     //   839: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   842: i2d
/*     */     //   843: dadd
/*     */     //   844: dstore #33
/*     */     //   846: nop
/*     */     //   847: nop
/*     */     //   848: goto -> 267
/*     */     //   851: goto -> 866
/*     */     //   854: aload_0
/*     */     //   855: getfield defaultFont : Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   858: aload_1
/*     */     //   859: dconst_0
/*     */     //   860: dconst_0
/*     */     //   861: iload #8
/*     */     //   863: invokevirtual drawString : (Ljava/lang/String;DDI)V
/*     */     //   866: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   869: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   872: invokeinterface getGlStateManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/renderer/IGlStateManager;
/*     */     //   877: invokeinterface disableBlend : ()V
/*     */     //   882: fload_2
/*     */     //   883: f2d
/*     */     //   884: ldc2_w 1.5
/*     */     //   887: dsub
/*     */     //   888: dneg
/*     */     //   889: fload_3
/*     */     //   890: f2d
/*     */     //   891: ldc2_w 0.5
/*     */     //   894: dadd
/*     */     //   895: dneg
/*     */     //   896: dconst_0
/*     */     //   897: invokestatic glTranslated : (DDD)V
/*     */     //   900: fconst_1
/*     */     //   901: fconst_1
/*     */     //   902: fconst_1
/*     */     //   903: fconst_1
/*     */     //   904: invokestatic glColor4f : (FFFF)V
/*     */     //   907: fload_2
/*     */     //   908: aload_0
/*     */     //   909: aload_1
/*     */     //   910: invokevirtual getStringWidth : (Ljava/lang/String;)I
/*     */     //   913: i2f
/*     */     //   914: fadd
/*     */     //   915: f2i
/*     */     //   916: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #77	-> 0
/*     */     //   #78	-> 4
/*     */     //   #79	-> 6
/*     */     //   #80	-> 33
/*     */     //   #82	-> 36
/*     */     //   #84	-> 44
/*     */     //   #85	-> 49
/*     */     //   #87	-> 54
/*     */     //   #88	-> 70
/*     */     //   #89	-> 86
/*     */     //   #90	-> 102
/*     */     //   #91	-> 126
/*     */     //   #93	-> 142
/*     */     //   #95	-> 146
/*     */     //   #96	-> 155
/*     */     //   #98	-> 163
/*     */     //   #100	-> 167
/*     */     //   #102	-> 178
/*     */     //   #103	-> 197
/*     */     //   #105	-> 221
/*     */     //   #107	-> 227
/*     */     //   #110	-> 230
/*     */     //   #111	-> 233
/*     */     //   #112	-> 236
/*     */     //   #113	-> 239
/*     */     //   #114	-> 242
/*     */     //   #116	-> 245
/*     */     //   #274	-> 255
/*     */     //   #275	-> 258
/*     */     //   #275	-> 310
/*     */     //   #117	-> 322
/*     */     //   #118	-> 350
/*     */     //   #120	-> 353
/*     */     //   #121	-> 358
/*     */     //   #122	-> 370
/*     */     //   #124	-> 386
/*     */     //   #124	-> 425
/*     */     //   #125	-> 427
/*     */     //   #127	-> 435
/*     */     //   #128	-> 445
/*     */     //   #129	-> 466
/*     */     //   #130	-> 471
/*     */     //   #132	-> 485
/*     */     //   #133	-> 490
/*     */     //   #136	-> 494
/*     */     //   #137	-> 497
/*     */     //   #138	-> 500
/*     */     //   #139	-> 503
/*     */     //   #140	-> 506
/*     */     //   #142	-> 512
/*     */     //   #143	-> 525
/*     */     //   #144	-> 538
/*     */     //   #145	-> 551
/*     */     //   #146	-> 564
/*     */     //   #147	-> 577
/*     */     //   #148	-> 584
/*     */     //   #150	-> 588
/*     */     //   #151	-> 597
/*     */     //   #153	-> 605
/*     */     //   #154	-> 610
/*     */     //   #156	-> 615
/*     */     //   #157	-> 618
/*     */     //   #158	-> 621
/*     */     //   #159	-> 624
/*     */     //   #160	-> 627
/*     */     //   #162	-> 630
/*     */     //   #164	-> 630
/*     */     //   #165	-> 640
/*     */     //   #166	-> 647
/*     */     //   #167	-> 652
/*     */     //   #168	-> 659
/*     */     //   #169	-> 664
/*     */     //   #171	-> 671
/*     */     //   #168	-> 675
/*     */     //   #166	-> 675
/*     */     //   #164	-> 675
/*     */     //   #173	-> 677
/*     */     //   #175	-> 705
/*     */     //   #176	-> 710
/*     */     //   #177	-> 729
/*     */     //   #178	-> 757
/*     */     //   #176	-> 766
/*     */     //   #180	-> 769
/*     */     //   #181	-> 774
/*     */     //   #182	-> 793
/*     */     //   #183	-> 821
/*     */     //   #181	-> 830
/*     */     //   #185	-> 833
/*     */     //   #186	-> 846
/*     */     //   #187	-> 846
/*     */     //   #276	-> 851
/*     */     //   #190	-> 854
/*     */     //   #191	-> 866
/*     */     //   #193	-> 866
/*     */     //   #194	-> 882
/*     */     //   #195	-> 900
/*     */     //   #197	-> 907
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   445	185	31	colorIndex	I
/*     */     //   435	411	30	type	C
/*     */     //   427	419	29	words	Ljava/lang/String;
/*     */     //   319	528	27	index	I
/*     */     //   319	528	26	part	Ljava/lang/String;
/*     */     //   322	525	28	$i$a$-forEachIndexed-GameFontRenderer$drawText$1	I
/*     */     //   286	562	22	item$iv	Ljava/lang/Object;
/*     */     //   258	593	20	index$iv	I
/*     */     //   252	599	18	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   255	596	19	$i$f$forEachIndexed	I
/*     */     //   245	606	17	underline	Z
/*     */     //   242	609	16	strikeThrough	Z
/*     */     //   239	612	15	italic	Z
/*     */     //   236	615	14	bold	Z
/*     */     //   233	618	13	randomCase	Z
/*     */     //   230	621	33	width	D
/*     */     //   227	624	12	currentFont	Ljava/lang/Object;
/*     */     //   221	630	11	parts	Ljava/util/List;
/*     */     //   178	739	10	alpha	I
/*     */     //   167	750	9	defaultColor	I
/*     */     //   146	771	8	currentColor	I
/*     */     //   44	873	7	rainbowShaderId	I
/*     */     //   0	917	0	this	Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;
/*     */     //   0	917	1	text	Ljava/lang/String;
/*     */     //   0	917	2	x	F
/*     */     //   0	917	3	y	F
/*     */     //   0	917	4	color	I
/*     */     //   0	917	5	ignoreColor	Z
/*     */     //   0	917	6	rainbow	Z
/*     */   }
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
/*     */   public int getColorCode(char charCode)
/*     */   {
/* 201 */     return ColorUtils.hexColors[Companion.getColorIndex(charCode)]; } public int getStringWidth(@Nullable String text) {
/*     */     int width, index$iv;
/*     */     Iterator iterator;
/* 204 */     String currentText = text;
/*     */     
/* 206 */     TextEvent event = new TextEvent(currentText);
/* 207 */     Retreat.INSTANCE.getEventManager().callEvent((Event)event);
/* 208 */     if (event.getText() != null) { currentText = event.getText();
/*     */       
/* 210 */       if (StringsKt.contains$default(currentText, "§", false, 2, null))
/* 211 */       { List parts = StringsKt.split$default(currentText, new String[] { "§" }, false, 0, 6, null);
/*     */         
/* 213 */         Object currentFont = this.defaultFont;
/* 214 */         width = 0;
/* 215 */         boolean bold = false;
/* 216 */         boolean italic = false;
/*     */         
/* 218 */         Iterable $this$forEachIndexed$iv = parts; int $i$f$forEachIndexed = 0;
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
/* 277 */         index$iv = 0;
/* 278 */         iterator = $this$forEachIndexed$iv.iterator(); } else { return this.defaultFont.getStringWidth(currentText) / 1; }  } else { event.getText(); return 0; }  if (iterator.hasNext()) { Object item$iv = iterator.next(); int i = index$iv++; boolean bool1 = false; if (i < 0) CollectionsKt.throwIndexOverflow();  int j = i; String str1 = (String)item$iv; int index = j, $i$a$-forEachIndexed-GameFontRenderer$getStringWidth$1 = 0;
/*     */       String str2 = str1;
/*     */       boolean bool2 = false; }
/*     */   
/*     */   }
/*     */   
/*     */   public int getCharWidth(char character) {
/*     */     return getStringWidth(String.valueOf(character));
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   public static final int getColorIndex(char type) {
/*     */     return Companion.getColorIndex(type);
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\000\n\002\020\f\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer$Companion;", "", "()V", "getColorIndex", "", "type", "", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     
/*     */     @JvmStatic
/*     */     public final int getColorIndex(char type) {
/*     */       char c1 = type;
/*     */       char c2 = c1;
/*     */       if ('0' > c2) {
/*     */         '9';
/*     */       } else if ('9' >= c2) {
/*     */       
/*     */       } 
/*     */       c2 = c1;
/*     */       if ('a' > c2) {
/*     */         'f';
/*     */       } else if ('f' >= c2) {
/*     */       
/*     */       } 
/*     */       c2 = c1;
/*     */       if ('k' > c2) {
/*     */         'o';
/*     */       } else if ('o' >= c2) {
/*     */       
/*     */       } 
/*     */       return (c1 == 'r') ? 21 : -1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\font\GameFontRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */