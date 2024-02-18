/*     */ package net.ccbluex.liquidbounce.ui.client.hud.designer;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import org.lwjgl.input.Mouse;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\022\n\002\020\002\n\002\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005¢\006\002\020\007J\030\020\020\032\0020\"2\006\020#\032\0020\0052\006\020$\032\0020\005H\002J\030\020%\032\0020\"2\006\020#\032\0020\0052\006\020$\032\0020\005H\002J\030\020&\032\0020\"2\006\020#\032\0020\0052\006\020$\032\0020\005H\002J\036\020'\032\0020\"2\006\020#\032\0020\0052\006\020$\032\0020\0052\006\020(\032\0020\005J\030\020)\032\0020\"2\006\020#\032\0020\0052\006\020$\032\0020\005H\002R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\020\020\016\032\004\030\0010\017X\016¢\006\002\n\000R\016\020\020\032\0020\tX\016¢\006\002\n\000R\016\020\021\032\0020\005X\016¢\006\002\n\000R\016\020\022\032\0020\005X\016¢\006\002\n\000R\036\020\024\032\0020\0052\006\020\023\032\0020\005@BX\016¢\006\b\n\000\032\004\b\025\020\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\027\032\0020\tX\016¢\006\002\n\000R\036\020\030\032\0020\0052\006\020\023\032\0020\005@BX\016¢\006\b\n\000\032\004\b\031\020\026R\016\020\032\032\0020\005X\016¢\006\002\n\000R\036\020\033\032\0020\0052\006\020\023\032\0020\005@BX\016¢\006\b\n\000\032\004\b\034\020\026R\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\035\020\026\"\004\b\036\020\037R\032\020\006\032\0020\005X\016¢\006\016\n\000\032\004\b \020\026\"\004\b!\020\037¨\006*"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "hudDesigner", "Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;", "x", "", "y", "(Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;II)V", "create", "", "getCreate", "()Z", "setCreate", "(Z)V", "currentElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "drag", "dragX", "dragY", "<set-?>", "height", "getHeight", "()I", "mouseDown", "realHeight", "getRealHeight", "scroll", "width", "getWidth", "getX", "setX", "(I)V", "getY", "setY", "", "mouseX", "mouseY", "drawCreate", "drawEditor", "drawPanel", "wheel", "drawSelection", "XSJClient"})
/*     */ public final class EditorPanel extends MinecraftInstance {
/*     */   private int width;
/*     */   private int height;
/*     */   private int realHeight;
/*     */   private boolean drag;
/*     */   private int dragX;
/*     */   private int dragY;
/*     */   
/*  19 */   public final int getX() { return this.x; } private boolean mouseDown; private int scroll; private boolean create; private Element currentElement; private final GuiHudDesigner hudDesigner; private int x; private int y; public final void setX(int <set-?>) { this.x = <set-?>; } public final int getY() { return this.y; } public final void setY(int <set-?>) { this.y = <set-?>; } public EditorPanel(@NotNull GuiHudDesigner hudDesigner, int x, int y) { this.hudDesigner = hudDesigner; this.x = x; this.y = y;
/*     */     
/*  21 */     this.width = 80;
/*     */     
/*  23 */     this.height = 20;
/*     */     
/*  25 */     this.realHeight = 20; } public final int getWidth() { return this.width; } public final int getHeight() { return this.height; } public final int getRealHeight() { return this.realHeight; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean getCreate()
/*     */   {
/*  36 */     return this.create; } public final void setCreate(boolean <set-?>) { this.create = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawPanel(int mouseX, int mouseY, int wheel) {
/*  48 */     drag(mouseX, mouseY);
/*     */ 
/*     */     
/*  51 */     if ((Intrinsics.areEqual(this.currentElement, this.hudDesigner.getSelectedElement()) ^ true) != 0)
/*  52 */       this.scroll = 0; 
/*  53 */     this.currentElement = this.hudDesigner.getSelectedElement();
/*     */ 
/*     */     
/*  56 */     int currMouseY = mouseY;
/*  57 */     boolean shouldScroll = (this.realHeight > 200);
/*     */     
/*  59 */     if (shouldScroll) {
/*  60 */       GL11.glPushMatrix();
/*  61 */       RenderUtils.makeScissorBox(this.x, this.y + 1.0F, this.x + this.width, this.y + 200.0F);
/*  62 */       GL11.glEnable(3089);
/*     */       
/*  64 */       if (this.y + 200 < currMouseY) {
/*  65 */         currMouseY = -1;
/*     */       }
/*  67 */       if (mouseX >= this.x && mouseX <= this.x + this.width && currMouseY >= this.y && currMouseY <= this.y + 200 && Mouse.hasWheel()) {
/*  68 */         if (wheel < 0 && -this.scroll + 205 <= this.realHeight) {
/*  69 */           this.scroll -= 12;
/*  70 */         } else if (wheel > 0) {
/*  71 */           this.scroll += 12;
/*  72 */           if (this.scroll > 0) this.scroll = 0;
/*     */         
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  78 */     RenderUtils.drawRect(this.x, this.y + 12, this.x + this.width, this.y + this.realHeight, (new Color(27, 34, 40)).getRGB());
/*     */     
/*  80 */     if (this.create) { drawCreate(mouseX, currMouseY); }
/*  81 */     else if (this.currentElement != null) { drawEditor(mouseX, currMouseY); }
/*  82 */     else { drawSelection(mouseX, currMouseY); }
/*     */ 
/*     */ 
/*     */     
/*  86 */     if (shouldScroll) {
/*  87 */       RenderUtils.drawRect(this.x + this.width - 5, this.y + 15, this.x + this.width - 2, this.y + 197, (
/*  88 */           new Color(41, 41, 41)).getRGB());
/*     */       
/*  90 */       float v = 'Å' * -this.scroll / (this.realHeight - 170.0F);
/*  91 */       RenderUtils.drawRect((this.x + this.width) - 5.0F, (this.y + 15) + v, (this.x + this.width) - 2.0F, (this.y + 20) + v, (
/*  92 */           new Color(37, 126, 255)).getRGB());
/*     */       
/*  94 */       GL11.glDisable(3089);
/*  95 */       GL11.glPopMatrix();
/*     */     } 
/*     */ 
/*     */     
/*  99 */     this.mouseDown = Mouse.isButtonDown(0);
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
/*     */   private final void drawCreate(int mouseX, int mouseY) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: bipush #15
/*     */     //   3: aload_0
/*     */     //   4: getfield scroll : I
/*     */     //   7: iadd
/*     */     //   8: putfield height : I
/*     */     //   11: aload_0
/*     */     //   12: bipush #15
/*     */     //   14: putfield realHeight : I
/*     */     //   17: aload_0
/*     */     //   18: bipush #90
/*     */     //   20: putfield width : I
/*     */     //   23: getstatic net/ccbluex/liquidbounce/ui/client/hud/HUD.Companion : Lnet/ccbluex/liquidbounce/ui/client/hud/HUD$Companion;
/*     */     //   26: invokevirtual getElements : ()[Ljava/lang/Class;
/*     */     //   29: astore #5
/*     */     //   31: aload #5
/*     */     //   33: arraylength
/*     */     //   34: istore #6
/*     */     //   36: iconst_0
/*     */     //   37: istore #4
/*     */     //   39: iload #4
/*     */     //   41: iload #6
/*     */     //   43: if_icmpge -> 424
/*     */     //   46: aload #5
/*     */     //   48: iload #4
/*     */     //   50: aaload
/*     */     //   51: astore_3
/*     */     //   52: aload_3
/*     */     //   53: ldc net/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo
/*     */     //   55: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
/*     */     //   58: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo
/*     */     //   61: dup
/*     */     //   62: ifnull -> 68
/*     */     //   65: goto -> 72
/*     */     //   68: pop
/*     */     //   69: goto -> 418
/*     */     //   72: astore #7
/*     */     //   74: aload #7
/*     */     //   76: invokeinterface single : ()Z
/*     */     //   81: ifeq -> 187
/*     */     //   84: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   87: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   90: invokevirtual getElements : ()Ljava/util/List;
/*     */     //   93: checkcast java/lang/Iterable
/*     */     //   96: astore #8
/*     */     //   98: iconst_0
/*     */     //   99: istore #9
/*     */     //   101: aload #8
/*     */     //   103: instanceof java/util/Collection
/*     */     //   106: ifeq -> 126
/*     */     //   109: aload #8
/*     */     //   111: checkcast java/util/Collection
/*     */     //   114: invokeinterface isEmpty : ()Z
/*     */     //   119: ifeq -> 126
/*     */     //   122: iconst_0
/*     */     //   123: goto -> 181
/*     */     //   126: aload #8
/*     */     //   128: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   133: astore #10
/*     */     //   135: aload #10
/*     */     //   137: invokeinterface hasNext : ()Z
/*     */     //   142: ifeq -> 180
/*     */     //   145: aload #10
/*     */     //   147: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   152: astore #11
/*     */     //   154: aload #11
/*     */     //   156: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*     */     //   159: astore #12
/*     */     //   161: iconst_0
/*     */     //   162: istore #13
/*     */     //   164: aload #12
/*     */     //   166: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   169: aload_3
/*     */     //   170: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   173: ifeq -> 135
/*     */     //   176: iconst_1
/*     */     //   177: goto -> 181
/*     */     //   180: iconst_0
/*     */     //   181: ifeq -> 187
/*     */     //   184: goto -> 418
/*     */     //   187: aload #7
/*     */     //   189: invokeinterface name : ()Ljava/lang/String;
/*     */     //   194: astore #8
/*     */     //   196: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   199: aload #8
/*     */     //   201: aload_0
/*     */     //   202: getfield x : I
/*     */     //   205: i2f
/*     */     //   206: fconst_2
/*     */     //   207: fadd
/*     */     //   208: aload_0
/*     */     //   209: getfield y : I
/*     */     //   212: i2f
/*     */     //   213: aload_0
/*     */     //   214: getfield height : I
/*     */     //   217: i2f
/*     */     //   218: fadd
/*     */     //   219: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   222: dup
/*     */     //   223: ldc 'Color.WHITE'
/*     */     //   225: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   228: invokevirtual getRGB : ()I
/*     */     //   231: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   236: pop
/*     */     //   237: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   240: aload #8
/*     */     //   242: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   247: istore #9
/*     */     //   249: aload_0
/*     */     //   250: getfield width : I
/*     */     //   253: iload #9
/*     */     //   255: bipush #8
/*     */     //   257: iadd
/*     */     //   258: if_icmpge -> 270
/*     */     //   261: aload_0
/*     */     //   262: iload #9
/*     */     //   264: bipush #8
/*     */     //   266: iadd
/*     */     //   267: putfield width : I
/*     */     //   270: iconst_0
/*     */     //   271: invokestatic isButtonDown : (I)Z
/*     */     //   274: ifeq -> 396
/*     */     //   277: aload_0
/*     */     //   278: getfield mouseDown : Z
/*     */     //   281: ifne -> 396
/*     */     //   284: iload_1
/*     */     //   285: aload_0
/*     */     //   286: getfield x : I
/*     */     //   289: if_icmplt -> 396
/*     */     //   292: iload_1
/*     */     //   293: aload_0
/*     */     //   294: getfield x : I
/*     */     //   297: aload_0
/*     */     //   298: getfield width : I
/*     */     //   301: iadd
/*     */     //   302: if_icmpgt -> 396
/*     */     //   305: iload_2
/*     */     //   306: aload_0
/*     */     //   307: getfield y : I
/*     */     //   310: aload_0
/*     */     //   311: getfield height : I
/*     */     //   314: iadd
/*     */     //   315: if_icmplt -> 396
/*     */     //   318: iload_2
/*     */     //   319: aload_0
/*     */     //   320: getfield y : I
/*     */     //   323: aload_0
/*     */     //   324: getfield height : I
/*     */     //   327: iadd
/*     */     //   328: bipush #10
/*     */     //   330: iadd
/*     */     //   331: if_icmpgt -> 396
/*     */     //   334: nop
/*     */     //   335: aload_3
/*     */     //   336: invokevirtual newInstance : ()Ljava/lang/Object;
/*     */     //   339: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*     */     //   342: astore #10
/*     */     //   344: aload #10
/*     */     //   346: invokevirtual createElement : ()Z
/*     */     //   349: ifeq -> 391
/*     */     //   352: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   355: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   358: aload #10
/*     */     //   360: dup
/*     */     //   361: ldc_w 'newElement'
/*     */     //   364: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   367: invokevirtual addElement : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;)Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   370: pop
/*     */     //   371: goto -> 391
/*     */     //   374: astore #10
/*     */     //   376: aload #10
/*     */     //   378: invokevirtual printStackTrace : ()V
/*     */     //   381: goto -> 391
/*     */     //   384: astore #10
/*     */     //   386: aload #10
/*     */     //   388: invokevirtual printStackTrace : ()V
/*     */     //   391: aload_0
/*     */     //   392: iconst_0
/*     */     //   393: putfield create : Z
/*     */     //   396: aload_0
/*     */     //   397: dup
/*     */     //   398: getfield height : I
/*     */     //   401: bipush #10
/*     */     //   403: iadd
/*     */     //   404: putfield height : I
/*     */     //   407: aload_0
/*     */     //   408: dup
/*     */     //   409: getfield realHeight : I
/*     */     //   412: bipush #10
/*     */     //   414: iadd
/*     */     //   415: putfield realHeight : I
/*     */     //   418: iinc #4, 1
/*     */     //   421: goto -> 39
/*     */     //   424: aload_0
/*     */     //   425: getfield x : I
/*     */     //   428: aload_0
/*     */     //   429: getfield y : I
/*     */     //   432: aload_0
/*     */     //   433: getfield x : I
/*     */     //   436: aload_0
/*     */     //   437: getfield width : I
/*     */     //   440: iadd
/*     */     //   441: aload_0
/*     */     //   442: getfield y : I
/*     */     //   445: bipush #12
/*     */     //   447: iadd
/*     */     //   448: invokestatic generateColor : ()Ljava/awt/Color;
/*     */     //   451: dup
/*     */     //   452: ldc_w 'ClickGUI.generateColor()'
/*     */     //   455: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   458: invokevirtual getRGB : ()I
/*     */     //   461: invokestatic drawRect : (IIIII)V
/*     */     //   464: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   467: ldc_w '§lCreate element'
/*     */     //   470: aload_0
/*     */     //   471: getfield x : I
/*     */     //   474: i2f
/*     */     //   475: fconst_2
/*     */     //   476: fadd
/*     */     //   477: aload_0
/*     */     //   478: getfield y : I
/*     */     //   481: i2f
/*     */     //   482: ldc_w 3.5
/*     */     //   485: fadd
/*     */     //   486: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   489: dup
/*     */     //   490: ldc 'Color.WHITE'
/*     */     //   492: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   495: invokevirtual getRGB : ()I
/*     */     //   498: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   503: pop
/*     */     //   504: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #106	-> 0
/*     */     //   #107	-> 11
/*     */     //   #108	-> 17
/*     */     //   #110	-> 23
/*     */     //   #111	-> 52
/*     */     //   #111	-> 68
/*     */     //   #113	-> 74
/*     */     //   #453	-> 101
/*     */     //   #454	-> 126
/*     */     //   #113	-> 164
/*     */     //   #455	-> 180
/*     */     //   #114	-> 184
/*     */     //   #116	-> 187
/*     */     //   #118	-> 196
/*     */     //   #120	-> 237
/*     */     //   #121	-> 249
/*     */     //   #122	-> 261
/*     */     //   #124	-> 270
/*     */     //   #125	-> 270
/*     */     //   #124	-> 270
/*     */     //   #125	-> 319
/*     */     //   #126	-> 334
/*     */     //   #127	-> 335
/*     */     //   #129	-> 344
/*     */     //   #130	-> 352
/*     */     //   #131	-> 374
/*     */     //   #132	-> 376
/*     */     //   #133	-> 384
/*     */     //   #134	-> 386
/*     */     //   #135	-> 391
/*     */     //   #136	-> 391
/*     */     //   #139	-> 396
/*     */     //   #140	-> 407
/*     */     //   #110	-> 418
/*     */     //   #143	-> 424
/*     */     //   #144	-> 464
/*     */     //   #145	-> 504
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   161	12	12	it	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*     */     //   164	9	13	$i$a$-any-EditorPanel$drawCreate$1	I
/*     */     //   154	26	11	element$iv	Ljava/lang/Object;
/*     */     //   98	83	8	$this$any$iv	Ljava/lang/Iterable;
/*     */     //   101	80	9	$i$f$any	I
/*     */     //   344	27	10	newElement	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*     */     //   376	5	10	e	Ljava/lang/InstantiationException;
/*     */     //   386	5	10	e	Ljava/lang/IllegalAccessException;
/*     */     //   249	169	9	stringWidth	I
/*     */     //   196	222	8	name	Ljava/lang/String;
/*     */     //   74	344	7	info	Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo;
/*     */     //   52	369	3	element	Ljava/lang/Class;
/*     */     //   0	505	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*     */     //   0	505	1	mouseX	I
/*     */     //   0	505	2	mouseY	I
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   334	371	374	java/lang/InstantiationException
/*     */     //   334	371	384	java/lang/IllegalAccessException
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
/*     */   private final void drawSelection(int mouseX, int mouseY) {
/* 151 */     this.height = 15 + this.scroll;
/* 152 */     this.realHeight = 15;
/* 153 */     this.width = 120;
/*     */     
/* 155 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.roboto35.drawString("§lCreate element", this.x + 2.0F, this.y + this.height, Color.WHITE.getRGB());
/* 156 */     if (Mouse.isButtonDown(0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= 
/* 157 */       this.y + this.height + 10) {
/* 158 */       this.create = true;
/*     */     }
/* 160 */     this.height += 10;
/* 161 */     this.realHeight += 10;
/*     */     
/* 163 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.roboto35.drawString("§lReset", this.x + 2, this.y + this.height, Color.WHITE.getRGB());
/* 164 */     if (Mouse.isButtonDown(0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= 
/* 165 */       this.y + this.height + 10) {
/* 166 */       Retreat.INSTANCE.setHud(HUD.Companion.createDefault());
/*     */     }
/* 168 */     this.height += 15;
/* 169 */     this.realHeight += 15;
/*     */     
/* 171 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.roboto35.drawString("§lAvailable Elements", this.x + 2.0F, this.y + this.height, Color.WHITE.getRGB());
/* 172 */     this.height += 10;
/* 173 */     this.realHeight += 10;
/*     */     
/* 175 */     for (Element element : Retreat.INSTANCE.getHud().getElements()) {
/* 176 */       Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.roboto35.drawString(element.getName(), this.x + 2, this.y + this.height, Color.WHITE.getRGB());
/*     */       
/* 178 */       int stringWidth = Fonts.roboto35.getStringWidth(element.getName());
/* 179 */       if (this.width < stringWidth + 8) {
/* 180 */         this.width = stringWidth + 8;
/*     */       }
/* 182 */       if (Mouse.isButtonDown(0) && !this.mouseDown && mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y + this.height && mouseY <= 
/* 183 */         this.y + this.height + 10) {
/* 184 */         this.hudDesigner.setSelectedElement(element);
/*     */       }
/* 186 */       this.height += 10;
/* 187 */       this.realHeight += 10;
/*     */     } 
/*     */     
/* 190 */     Intrinsics.checkExpressionValueIsNotNull(ClickGUI.generateColor(), "ClickGUI.generateColor()"); RenderUtils.drawRect(this.x, this.y, this.x + this.width, this.y + 12, ClickGUI.generateColor().getRGB());
/* 191 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 192 */     Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.roboto35.drawString("§lEditor", this.x + 2.0F, this.y + 3.5F, Color.WHITE.getRGB());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drawEditor(int mouseX, int mouseY) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_0
/*     */     //   2: getfield scroll : I
/*     */     //   5: bipush #15
/*     */     //   7: iadd
/*     */     //   8: putfield height : I
/*     */     //   11: aload_0
/*     */     //   12: bipush #15
/*     */     //   14: putfield realHeight : I
/*     */     //   17: aload_0
/*     */     //   18: getfield width : I
/*     */     //   21: istore_3
/*     */     //   22: aload_0
/*     */     //   23: bipush #100
/*     */     //   25: putfield width : I
/*     */     //   28: aload_0
/*     */     //   29: getfield currentElement : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*     */     //   32: dup
/*     */     //   33: ifnull -> 39
/*     */     //   36: goto -> 41
/*     */     //   39: pop
/*     */     //   40: return
/*     */     //   41: astore #4
/*     */     //   43: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   46: new java/lang/StringBuilder
/*     */     //   49: dup
/*     */     //   50: invokespecial <init> : ()V
/*     */     //   53: ldc_w 'X: '
/*     */     //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   59: ldc_w '%.2f'
/*     */     //   62: astore #5
/*     */     //   64: iconst_1
/*     */     //   65: anewarray java/lang/Object
/*     */     //   68: dup
/*     */     //   69: iconst_0
/*     */     //   70: aload #4
/*     */     //   72: invokevirtual getRenderX : ()D
/*     */     //   75: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   78: aastore
/*     */     //   79: astore #6
/*     */     //   81: astore #24
/*     */     //   83: astore #23
/*     */     //   85: iconst_0
/*     */     //   86: istore #7
/*     */     //   88: aload #5
/*     */     //   90: aload #6
/*     */     //   92: dup
/*     */     //   93: arraylength
/*     */     //   94: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*     */     //   97: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   100: dup
/*     */     //   101: ldc_w 'java.lang.String.format(this, *args)'
/*     */     //   104: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   107: astore #25
/*     */     //   109: aload #23
/*     */     //   111: aload #24
/*     */     //   113: aload #25
/*     */     //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   118: ldc_w ' ('
/*     */     //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   124: ldc_w '%.2f'
/*     */     //   127: astore #5
/*     */     //   129: iconst_1
/*     */     //   130: anewarray java/lang/Object
/*     */     //   133: dup
/*     */     //   134: iconst_0
/*     */     //   135: aload #4
/*     */     //   137: invokevirtual getX : ()D
/*     */     //   140: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   143: aastore
/*     */     //   144: astore #6
/*     */     //   146: astore #24
/*     */     //   148: astore #23
/*     */     //   150: iconst_0
/*     */     //   151: istore #7
/*     */     //   153: aload #5
/*     */     //   155: aload #6
/*     */     //   157: dup
/*     */     //   158: arraylength
/*     */     //   159: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*     */     //   162: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   165: dup
/*     */     //   166: ldc_w 'java.lang.String.format(this, *args)'
/*     */     //   169: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   172: astore #25
/*     */     //   174: aload #23
/*     */     //   176: aload #24
/*     */     //   178: aload #25
/*     */     //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   183: bipush #41
/*     */     //   185: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   188: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   191: aload_0
/*     */     //   192: getfield x : I
/*     */     //   195: iconst_2
/*     */     //   196: iadd
/*     */     //   197: aload_0
/*     */     //   198: getfield y : I
/*     */     //   201: aload_0
/*     */     //   202: getfield height : I
/*     */     //   205: iadd
/*     */     //   206: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   209: dup
/*     */     //   210: ldc 'Color.WHITE'
/*     */     //   212: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   215: invokevirtual getRGB : ()I
/*     */     //   218: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   223: pop
/*     */     //   224: aload_0
/*     */     //   225: dup
/*     */     //   226: getfield height : I
/*     */     //   229: bipush #10
/*     */     //   231: iadd
/*     */     //   232: putfield height : I
/*     */     //   235: aload_0
/*     */     //   236: dup
/*     */     //   237: getfield realHeight : I
/*     */     //   240: bipush #10
/*     */     //   242: iadd
/*     */     //   243: putfield realHeight : I
/*     */     //   246: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   249: new java/lang/StringBuilder
/*     */     //   252: dup
/*     */     //   253: invokespecial <init> : ()V
/*     */     //   256: ldc_w 'Y: '
/*     */     //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   262: ldc_w '%.2f'
/*     */     //   265: astore #5
/*     */     //   267: iconst_1
/*     */     //   268: anewarray java/lang/Object
/*     */     //   271: dup
/*     */     //   272: iconst_0
/*     */     //   273: aload #4
/*     */     //   275: invokevirtual getRenderY : ()D
/*     */     //   278: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   281: aastore
/*     */     //   282: astore #6
/*     */     //   284: astore #24
/*     */     //   286: astore #23
/*     */     //   288: iconst_0
/*     */     //   289: istore #7
/*     */     //   291: aload #5
/*     */     //   293: aload #6
/*     */     //   295: dup
/*     */     //   296: arraylength
/*     */     //   297: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*     */     //   300: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   303: dup
/*     */     //   304: ldc_w 'java.lang.String.format(this, *args)'
/*     */     //   307: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   310: astore #25
/*     */     //   312: aload #23
/*     */     //   314: aload #24
/*     */     //   316: aload #25
/*     */     //   318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   321: ldc_w ' ('
/*     */     //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   327: ldc_w '%.2f'
/*     */     //   330: astore #5
/*     */     //   332: iconst_1
/*     */     //   333: anewarray java/lang/Object
/*     */     //   336: dup
/*     */     //   337: iconst_0
/*     */     //   338: aload #4
/*     */     //   340: invokevirtual getY : ()D
/*     */     //   343: invokestatic valueOf : (D)Ljava/lang/Double;
/*     */     //   346: aastore
/*     */     //   347: astore #6
/*     */     //   349: astore #24
/*     */     //   351: astore #23
/*     */     //   353: iconst_0
/*     */     //   354: istore #7
/*     */     //   356: aload #5
/*     */     //   358: aload #6
/*     */     //   360: dup
/*     */     //   361: arraylength
/*     */     //   362: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*     */     //   365: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   368: dup
/*     */     //   369: ldc_w 'java.lang.String.format(this, *args)'
/*     */     //   372: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   375: astore #25
/*     */     //   377: aload #23
/*     */     //   379: aload #24
/*     */     //   381: aload #25
/*     */     //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   386: bipush #41
/*     */     //   388: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   391: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   394: aload_0
/*     */     //   395: getfield x : I
/*     */     //   398: iconst_2
/*     */     //   399: iadd
/*     */     //   400: aload_0
/*     */     //   401: getfield y : I
/*     */     //   404: aload_0
/*     */     //   405: getfield height : I
/*     */     //   408: iadd
/*     */     //   409: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   412: dup
/*     */     //   413: ldc 'Color.WHITE'
/*     */     //   415: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   418: invokevirtual getRGB : ()I
/*     */     //   421: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   426: pop
/*     */     //   427: aload_0
/*     */     //   428: dup
/*     */     //   429: getfield height : I
/*     */     //   432: bipush #10
/*     */     //   434: iadd
/*     */     //   435: putfield height : I
/*     */     //   438: aload_0
/*     */     //   439: dup
/*     */     //   440: getfield realHeight : I
/*     */     //   443: bipush #10
/*     */     //   445: iadd
/*     */     //   446: putfield realHeight : I
/*     */     //   449: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   452: new java/lang/StringBuilder
/*     */     //   455: dup
/*     */     //   456: invokespecial <init> : ()V
/*     */     //   459: ldc_w 'Scale: '
/*     */     //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   465: ldc_w '%.2f'
/*     */     //   468: astore #5
/*     */     //   470: iconst_1
/*     */     //   471: anewarray java/lang/Object
/*     */     //   474: dup
/*     */     //   475: iconst_0
/*     */     //   476: aload #4
/*     */     //   478: invokevirtual getScale : ()F
/*     */     //   481: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   484: aastore
/*     */     //   485: astore #6
/*     */     //   487: astore #24
/*     */     //   489: astore #23
/*     */     //   491: iconst_0
/*     */     //   492: istore #7
/*     */     //   494: aload #5
/*     */     //   496: aload #6
/*     */     //   498: dup
/*     */     //   499: arraylength
/*     */     //   500: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*     */     //   503: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   506: dup
/*     */     //   507: ldc_w 'java.lang.String.format(this, *args)'
/*     */     //   510: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   513: astore #25
/*     */     //   515: aload #23
/*     */     //   517: aload #24
/*     */     //   519: aload #25
/*     */     //   521: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   524: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   527: aload_0
/*     */     //   528: getfield x : I
/*     */     //   531: iconst_2
/*     */     //   532: iadd
/*     */     //   533: aload_0
/*     */     //   534: getfield y : I
/*     */     //   537: aload_0
/*     */     //   538: getfield height : I
/*     */     //   541: iadd
/*     */     //   542: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   545: dup
/*     */     //   546: ldc 'Color.WHITE'
/*     */     //   548: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   551: invokevirtual getRGB : ()I
/*     */     //   554: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   559: pop
/*     */     //   560: aload_0
/*     */     //   561: dup
/*     */     //   562: getfield height : I
/*     */     //   565: bipush #10
/*     */     //   567: iadd
/*     */     //   568: putfield height : I
/*     */     //   571: aload_0
/*     */     //   572: dup
/*     */     //   573: getfield realHeight : I
/*     */     //   576: bipush #10
/*     */     //   578: iadd
/*     */     //   579: putfield realHeight : I
/*     */     //   582: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   585: ldc_w 'H:'
/*     */     //   588: aload_0
/*     */     //   589: getfield x : I
/*     */     //   592: iconst_2
/*     */     //   593: iadd
/*     */     //   594: aload_0
/*     */     //   595: getfield y : I
/*     */     //   598: aload_0
/*     */     //   599: getfield height : I
/*     */     //   602: iadd
/*     */     //   603: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   606: dup
/*     */     //   607: ldc 'Color.WHITE'
/*     */     //   609: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   612: invokevirtual getRGB : ()I
/*     */     //   615: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   620: pop
/*     */     //   621: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   624: aload #4
/*     */     //   626: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   629: invokevirtual getHorizontal : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   632: invokevirtual getSideName : ()Ljava/lang/String;
/*     */     //   635: aload_0
/*     */     //   636: getfield x : I
/*     */     //   639: bipush #12
/*     */     //   641: iadd
/*     */     //   642: aload_0
/*     */     //   643: getfield y : I
/*     */     //   646: aload_0
/*     */     //   647: getfield height : I
/*     */     //   650: iadd
/*     */     //   651: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   654: dup
/*     */     //   655: ldc_w 'Color.GRAY'
/*     */     //   658: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   661: invokevirtual getRGB : ()I
/*     */     //   664: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   669: pop
/*     */     //   670: iconst_0
/*     */     //   671: invokestatic isButtonDown : (I)Z
/*     */     //   674: ifeq -> 914
/*     */     //   677: aload_0
/*     */     //   678: getfield mouseDown : Z
/*     */     //   681: ifne -> 914
/*     */     //   684: iload_1
/*     */     //   685: aload_0
/*     */     //   686: getfield x : I
/*     */     //   689: if_icmplt -> 914
/*     */     //   692: iload_1
/*     */     //   693: aload_0
/*     */     //   694: getfield x : I
/*     */     //   697: aload_0
/*     */     //   698: getfield width : I
/*     */     //   701: iadd
/*     */     //   702: if_icmpgt -> 914
/*     */     //   705: iload_2
/*     */     //   706: aload_0
/*     */     //   707: getfield y : I
/*     */     //   710: aload_0
/*     */     //   711: getfield height : I
/*     */     //   714: iadd
/*     */     //   715: if_icmplt -> 914
/*     */     //   718: iload_2
/*     */     //   719: aload_0
/*     */     //   720: getfield y : I
/*     */     //   723: aload_0
/*     */     //   724: getfield height : I
/*     */     //   727: iadd
/*     */     //   728: bipush #10
/*     */     //   730: iadd
/*     */     //   731: if_icmpgt -> 914
/*     */     //   734: invokestatic values : ()[Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   737: astore #5
/*     */     //   739: aload #5
/*     */     //   741: aload #4
/*     */     //   743: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   746: invokevirtual getHorizontal : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   749: invokestatic indexOf : ([Ljava/lang/Object;Ljava/lang/Object;)I
/*     */     //   752: istore #6
/*     */     //   754: aload #4
/*     */     //   756: invokevirtual getRenderX : ()D
/*     */     //   759: dstore #7
/*     */     //   761: aload #4
/*     */     //   763: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   766: aload #5
/*     */     //   768: iload #6
/*     */     //   770: iconst_1
/*     */     //   771: iadd
/*     */     //   772: aload #5
/*     */     //   774: arraylength
/*     */     //   775: if_icmplt -> 782
/*     */     //   778: iconst_0
/*     */     //   779: goto -> 786
/*     */     //   782: iload #6
/*     */     //   784: iconst_1
/*     */     //   785: iadd
/*     */     //   786: aaload
/*     */     //   787: invokevirtual setHorizontal : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;)V
/*     */     //   790: aload #4
/*     */     //   792: aload #4
/*     */     //   794: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   797: invokevirtual getHorizontal : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   800: getstatic net/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel$WhenMappings.$EnumSwitchMapping$0 : [I
/*     */     //   803: swap
/*     */     //   804: invokevirtual ordinal : ()I
/*     */     //   807: iaload
/*     */     //   808: tableswitch default -> 903, 1 -> 836, 2 -> 841, 3 -> 873
/*     */     //   836: dload #7
/*     */     //   838: goto -> 911
/*     */     //   841: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   844: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   847: dup
/*     */     //   848: ldc_w 'mc'
/*     */     //   851: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   854: invokeinterface createScaledResolution : (Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;
/*     */     //   859: invokeinterface getScaledWidth : ()I
/*     */     //   864: iconst_2
/*     */     //   865: idiv
/*     */     //   866: i2d
/*     */     //   867: dload #7
/*     */     //   869: dsub
/*     */     //   870: goto -> 911
/*     */     //   873: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   876: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   879: dup
/*     */     //   880: ldc_w 'mc'
/*     */     //   883: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   886: invokeinterface createScaledResolution : (Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;
/*     */     //   891: invokeinterface getScaledWidth : ()I
/*     */     //   896: i2d
/*     */     //   897: dload #7
/*     */     //   899: dsub
/*     */     //   900: goto -> 911
/*     */     //   903: new kotlin/NoWhenBranchMatchedException
/*     */     //   906: dup
/*     */     //   907: invokespecial <init> : ()V
/*     */     //   910: athrow
/*     */     //   911: invokevirtual setX : (D)V
/*     */     //   914: aload_0
/*     */     //   915: dup
/*     */     //   916: getfield height : I
/*     */     //   919: bipush #10
/*     */     //   921: iadd
/*     */     //   922: putfield height : I
/*     */     //   925: aload_0
/*     */     //   926: dup
/*     */     //   927: getfield realHeight : I
/*     */     //   930: bipush #10
/*     */     //   932: iadd
/*     */     //   933: putfield realHeight : I
/*     */     //   936: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   939: ldc_w 'V:'
/*     */     //   942: aload_0
/*     */     //   943: getfield x : I
/*     */     //   946: iconst_2
/*     */     //   947: iadd
/*     */     //   948: aload_0
/*     */     //   949: getfield y : I
/*     */     //   952: aload_0
/*     */     //   953: getfield height : I
/*     */     //   956: iadd
/*     */     //   957: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   960: dup
/*     */     //   961: ldc 'Color.WHITE'
/*     */     //   963: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   966: invokevirtual getRGB : ()I
/*     */     //   969: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   974: pop
/*     */     //   975: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   978: aload #4
/*     */     //   980: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   983: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   986: invokevirtual getSideName : ()Ljava/lang/String;
/*     */     //   989: aload_0
/*     */     //   990: getfield x : I
/*     */     //   993: bipush #12
/*     */     //   995: iadd
/*     */     //   996: aload_0
/*     */     //   997: getfield y : I
/*     */     //   1000: aload_0
/*     */     //   1001: getfield height : I
/*     */     //   1004: iadd
/*     */     //   1005: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   1008: dup
/*     */     //   1009: ldc_w 'Color.GRAY'
/*     */     //   1012: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1015: invokevirtual getRGB : ()I
/*     */     //   1018: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   1023: pop
/*     */     //   1024: iconst_0
/*     */     //   1025: invokestatic isButtonDown : (I)Z
/*     */     //   1028: ifeq -> 1266
/*     */     //   1031: aload_0
/*     */     //   1032: getfield mouseDown : Z
/*     */     //   1035: ifne -> 1266
/*     */     //   1038: iload_1
/*     */     //   1039: aload_0
/*     */     //   1040: getfield x : I
/*     */     //   1043: if_icmplt -> 1266
/*     */     //   1046: iload_1
/*     */     //   1047: aload_0
/*     */     //   1048: getfield x : I
/*     */     //   1051: aload_0
/*     */     //   1052: getfield width : I
/*     */     //   1055: iadd
/*     */     //   1056: if_icmpgt -> 1266
/*     */     //   1059: iload_2
/*     */     //   1060: aload_0
/*     */     //   1061: getfield y : I
/*     */     //   1064: aload_0
/*     */     //   1065: getfield height : I
/*     */     //   1068: iadd
/*     */     //   1069: if_icmplt -> 1266
/*     */     //   1072: iload_2
/*     */     //   1073: aload_0
/*     */     //   1074: getfield y : I
/*     */     //   1077: aload_0
/*     */     //   1078: getfield height : I
/*     */     //   1081: iadd
/*     */     //   1082: bipush #10
/*     */     //   1084: iadd
/*     */     //   1085: if_icmpgt -> 1266
/*     */     //   1088: invokestatic values : ()[Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1091: astore #5
/*     */     //   1093: aload #5
/*     */     //   1095: aload #4
/*     */     //   1097: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   1100: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1103: invokestatic indexOf : ([Ljava/lang/Object;Ljava/lang/Object;)I
/*     */     //   1106: istore #6
/*     */     //   1108: aload #4
/*     */     //   1110: invokevirtual getRenderY : ()D
/*     */     //   1113: dstore #7
/*     */     //   1115: aload #4
/*     */     //   1117: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   1120: aload #5
/*     */     //   1122: iload #6
/*     */     //   1124: iconst_1
/*     */     //   1125: iadd
/*     */     //   1126: aload #5
/*     */     //   1128: arraylength
/*     */     //   1129: if_icmplt -> 1136
/*     */     //   1132: iconst_0
/*     */     //   1133: goto -> 1140
/*     */     //   1136: iload #6
/*     */     //   1138: iconst_1
/*     */     //   1139: iadd
/*     */     //   1140: aaload
/*     */     //   1141: invokevirtual setVertical : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;)V
/*     */     //   1144: aload #4
/*     */     //   1146: aload #4
/*     */     //   1148: invokevirtual getSide : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;
/*     */     //   1151: invokevirtual getVertical : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1154: getstatic net/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel$WhenMappings.$EnumSwitchMapping$1 : [I
/*     */     //   1157: swap
/*     */     //   1158: invokevirtual ordinal : ()I
/*     */     //   1161: iaload
/*     */     //   1162: tableswitch default -> 1255, 1 -> 1188, 2 -> 1193, 3 -> 1225
/*     */     //   1188: dload #7
/*     */     //   1190: goto -> 1263
/*     */     //   1193: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1196: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1199: dup
/*     */     //   1200: ldc_w 'mc'
/*     */     //   1203: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1206: invokeinterface createScaledResolution : (Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;
/*     */     //   1211: invokeinterface getScaledHeight : ()I
/*     */     //   1216: iconst_2
/*     */     //   1217: idiv
/*     */     //   1218: i2d
/*     */     //   1219: dload #7
/*     */     //   1221: dsub
/*     */     //   1222: goto -> 1263
/*     */     //   1225: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1228: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1231: dup
/*     */     //   1232: ldc_w 'mc'
/*     */     //   1235: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1238: invokeinterface createScaledResolution : (Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IScaledResolution;
/*     */     //   1243: invokeinterface getScaledHeight : ()I
/*     */     //   1248: i2d
/*     */     //   1249: dload #7
/*     */     //   1251: dsub
/*     */     //   1252: goto -> 1263
/*     */     //   1255: new kotlin/NoWhenBranchMatchedException
/*     */     //   1258: dup
/*     */     //   1259: invokespecial <init> : ()V
/*     */     //   1262: athrow
/*     */     //   1263: invokevirtual setY : (D)V
/*     */     //   1266: aload_0
/*     */     //   1267: dup
/*     */     //   1268: getfield height : I
/*     */     //   1271: bipush #10
/*     */     //   1273: iadd
/*     */     //   1274: putfield height : I
/*     */     //   1277: aload_0
/*     */     //   1278: dup
/*     */     //   1279: getfield realHeight : I
/*     */     //   1282: bipush #10
/*     */     //   1284: iadd
/*     */     //   1285: putfield realHeight : I
/*     */     //   1288: aload #4
/*     */     //   1290: invokevirtual getValues : ()Ljava/util/List;
/*     */     //   1293: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1298: astore #6
/*     */     //   1300: aload #6
/*     */     //   1302: invokeinterface hasNext : ()Z
/*     */     //   1307: ifeq -> 3284
/*     */     //   1310: aload #6
/*     */     //   1312: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1317: checkcast net/ccbluex/liquidbounce/value/Value
/*     */     //   1320: astore #5
/*     */     //   1322: aload #5
/*     */     //   1324: astore #7
/*     */     //   1326: aload #7
/*     */     //   1328: instanceof net/ccbluex/liquidbounce/value/BoolValue
/*     */     //   1331: ifeq -> 1566
/*     */     //   1334: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1337: aload #5
/*     */     //   1339: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   1342: aload_0
/*     */     //   1343: getfield x : I
/*     */     //   1346: iconst_2
/*     */     //   1347: iadd
/*     */     //   1348: aload_0
/*     */     //   1349: getfield y : I
/*     */     //   1352: aload_0
/*     */     //   1353: getfield height : I
/*     */     //   1356: iadd
/*     */     //   1357: aload #5
/*     */     //   1359: checkcast net/ccbluex/liquidbounce/value/BoolValue
/*     */     //   1362: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1365: checkcast java/lang/Boolean
/*     */     //   1368: invokevirtual booleanValue : ()Z
/*     */     //   1371: ifeq -> 1389
/*     */     //   1374: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   1377: dup
/*     */     //   1378: ldc 'Color.WHITE'
/*     */     //   1380: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1383: invokevirtual getRGB : ()I
/*     */     //   1386: goto -> 1402
/*     */     //   1389: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   1392: dup
/*     */     //   1393: ldc_w 'Color.GRAY'
/*     */     //   1396: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1399: invokevirtual getRGB : ()I
/*     */     //   1402: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   1407: pop
/*     */     //   1408: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1411: aload #5
/*     */     //   1413: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   1416: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1421: istore #8
/*     */     //   1423: aload_0
/*     */     //   1424: getfield width : I
/*     */     //   1427: iload #8
/*     */     //   1429: bipush #8
/*     */     //   1431: iadd
/*     */     //   1432: if_icmpge -> 1444
/*     */     //   1435: aload_0
/*     */     //   1436: iload #8
/*     */     //   1438: bipush #8
/*     */     //   1440: iadd
/*     */     //   1441: putfield width : I
/*     */     //   1444: iconst_0
/*     */     //   1445: invokestatic isButtonDown : (I)Z
/*     */     //   1448: ifeq -> 1541
/*     */     //   1451: aload_0
/*     */     //   1452: getfield mouseDown : Z
/*     */     //   1455: ifne -> 1541
/*     */     //   1458: iload_1
/*     */     //   1459: aload_0
/*     */     //   1460: getfield x : I
/*     */     //   1463: if_icmplt -> 1541
/*     */     //   1466: iload_1
/*     */     //   1467: aload_0
/*     */     //   1468: getfield x : I
/*     */     //   1471: aload_0
/*     */     //   1472: getfield width : I
/*     */     //   1475: iadd
/*     */     //   1476: if_icmpgt -> 1541
/*     */     //   1479: iload_2
/*     */     //   1480: aload_0
/*     */     //   1481: getfield y : I
/*     */     //   1484: aload_0
/*     */     //   1485: getfield height : I
/*     */     //   1488: iadd
/*     */     //   1489: if_icmplt -> 1541
/*     */     //   1492: iload_2
/*     */     //   1493: aload_0
/*     */     //   1494: getfield y : I
/*     */     //   1497: aload_0
/*     */     //   1498: getfield height : I
/*     */     //   1501: iadd
/*     */     //   1502: bipush #10
/*     */     //   1504: iadd
/*     */     //   1505: if_icmpgt -> 1541
/*     */     //   1508: aload #5
/*     */     //   1510: checkcast net/ccbluex/liquidbounce/value/BoolValue
/*     */     //   1513: aload #5
/*     */     //   1515: checkcast net/ccbluex/liquidbounce/value/BoolValue
/*     */     //   1518: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1521: checkcast java/lang/Boolean
/*     */     //   1524: invokevirtual booleanValue : ()Z
/*     */     //   1527: ifne -> 1534
/*     */     //   1530: iconst_1
/*     */     //   1531: goto -> 1535
/*     */     //   1534: iconst_0
/*     */     //   1535: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   1538: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   1541: aload_0
/*     */     //   1542: dup
/*     */     //   1543: getfield height : I
/*     */     //   1546: bipush #10
/*     */     //   1548: iadd
/*     */     //   1549: putfield height : I
/*     */     //   1552: aload_0
/*     */     //   1553: dup
/*     */     //   1554: getfield realHeight : I
/*     */     //   1557: bipush #10
/*     */     //   1559: iadd
/*     */     //   1560: putfield realHeight : I
/*     */     //   1563: goto -> 3281
/*     */     //   1566: aload #7
/*     */     //   1568: instanceof net/ccbluex/liquidbounce/value/FloatValue
/*     */     //   1571: ifeq -> 2065
/*     */     //   1574: aload #5
/*     */     //   1576: checkcast net/ccbluex/liquidbounce/value/FloatValue
/*     */     //   1579: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1582: checkcast java/lang/Number
/*     */     //   1585: invokevirtual floatValue : ()F
/*     */     //   1588: fstore #8
/*     */     //   1590: aload #5
/*     */     //   1592: checkcast net/ccbluex/liquidbounce/value/FloatValue
/*     */     //   1595: invokevirtual getMinimum : ()F
/*     */     //   1598: fstore #9
/*     */     //   1600: aload #5
/*     */     //   1602: checkcast net/ccbluex/liquidbounce/value/FloatValue
/*     */     //   1605: invokevirtual getMaximum : ()F
/*     */     //   1608: fstore #10
/*     */     //   1610: new java/lang/StringBuilder
/*     */     //   1613: dup
/*     */     //   1614: invokespecial <init> : ()V
/*     */     //   1617: aload #5
/*     */     //   1619: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   1622: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1625: ldc_w ': §c'
/*     */     //   1628: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1631: ldc_w '%.2f'
/*     */     //   1634: astore #12
/*     */     //   1636: iconst_1
/*     */     //   1637: anewarray java/lang/Object
/*     */     //   1640: dup
/*     */     //   1641: iconst_0
/*     */     //   1642: fload #8
/*     */     //   1644: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1647: aastore
/*     */     //   1648: astore #13
/*     */     //   1650: astore #23
/*     */     //   1652: iconst_0
/*     */     //   1653: istore #14
/*     */     //   1655: aload #12
/*     */     //   1657: aload #13
/*     */     //   1659: dup
/*     */     //   1660: arraylength
/*     */     //   1661: invokestatic copyOf : ([Ljava/lang/Object;I)[Ljava/lang/Object;
/*     */     //   1664: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   1667: dup
/*     */     //   1668: ldc_w 'java.lang.String.format(this, *args)'
/*     */     //   1671: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1674: astore #24
/*     */     //   1676: aload #23
/*     */     //   1678: aload #24
/*     */     //   1680: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1683: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1686: astore #11
/*     */     //   1688: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1691: aload #11
/*     */     //   1693: aload_0
/*     */     //   1694: getfield x : I
/*     */     //   1697: iconst_2
/*     */     //   1698: iadd
/*     */     //   1699: aload_0
/*     */     //   1700: getfield y : I
/*     */     //   1703: aload_0
/*     */     //   1704: getfield height : I
/*     */     //   1707: iadd
/*     */     //   1708: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   1711: dup
/*     */     //   1712: ldc 'Color.WHITE'
/*     */     //   1714: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   1717: invokevirtual getRGB : ()I
/*     */     //   1720: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   1725: pop
/*     */     //   1726: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1729: aload #11
/*     */     //   1731: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   1736: istore #12
/*     */     //   1738: aload_0
/*     */     //   1739: getfield width : I
/*     */     //   1742: iload #12
/*     */     //   1744: bipush #8
/*     */     //   1746: iadd
/*     */     //   1747: if_icmpge -> 1759
/*     */     //   1750: aload_0
/*     */     //   1751: iload #12
/*     */     //   1753: bipush #8
/*     */     //   1755: iadd
/*     */     //   1756: putfield width : I
/*     */     //   1759: aload_0
/*     */     //   1760: getfield x : I
/*     */     //   1763: i2f
/*     */     //   1764: ldc_w 8.0
/*     */     //   1767: fadd
/*     */     //   1768: aload_0
/*     */     //   1769: getfield y : I
/*     */     //   1772: aload_0
/*     */     //   1773: getfield height : I
/*     */     //   1776: iadd
/*     */     //   1777: i2f
/*     */     //   1778: ldc_w 12.0
/*     */     //   1781: fadd
/*     */     //   1782: aload_0
/*     */     //   1783: getfield x : I
/*     */     //   1786: iload_3
/*     */     //   1787: iadd
/*     */     //   1788: i2f
/*     */     //   1789: ldc_w 8.0
/*     */     //   1792: fsub
/*     */     //   1793: aload_0
/*     */     //   1794: getfield y : I
/*     */     //   1797: aload_0
/*     */     //   1798: getfield height : I
/*     */     //   1801: iadd
/*     */     //   1802: i2f
/*     */     //   1803: ldc_w 13.0
/*     */     //   1806: fadd
/*     */     //   1807: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   1810: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   1813: aload_0
/*     */     //   1814: getfield x : I
/*     */     //   1817: i2f
/*     */     //   1818: iload_3
/*     */     //   1819: i2f
/*     */     //   1820: ldc_w 18.0
/*     */     //   1823: fsub
/*     */     //   1824: fload #8
/*     */     //   1826: fload #9
/*     */     //   1828: fsub
/*     */     //   1829: fmul
/*     */     //   1830: fload #10
/*     */     //   1832: fload #9
/*     */     //   1834: fsub
/*     */     //   1835: fdiv
/*     */     //   1836: fadd
/*     */     //   1837: fstore #13
/*     */     //   1839: ldc_w 8.0
/*     */     //   1842: fload #13
/*     */     //   1844: fadd
/*     */     //   1845: aload_0
/*     */     //   1846: getfield y : I
/*     */     //   1849: aload_0
/*     */     //   1850: getfield height : I
/*     */     //   1853: iadd
/*     */     //   1854: i2f
/*     */     //   1855: ldc_w 9.0
/*     */     //   1858: fadd
/*     */     //   1859: fload #13
/*     */     //   1861: ldc_w 11.0
/*     */     //   1864: fadd
/*     */     //   1865: aload_0
/*     */     //   1866: getfield y : I
/*     */     //   1869: aload_0
/*     */     //   1870: getfield height : I
/*     */     //   1873: iadd
/*     */     //   1874: i2f
/*     */     //   1875: ldc_w 15.0
/*     */     //   1878: fadd
/*     */     //   1879: new java/awt/Color
/*     */     //   1882: dup
/*     */     //   1883: bipush #37
/*     */     //   1885: bipush #126
/*     */     //   1887: sipush #255
/*     */     //   1890: invokespecial <init> : (III)V
/*     */     //   1893: invokevirtual getRGB : ()I
/*     */     //   1896: invokestatic drawRect : (FFFFI)V
/*     */     //   1899: iload_1
/*     */     //   1900: aload_0
/*     */     //   1901: getfield x : I
/*     */     //   1904: bipush #8
/*     */     //   1906: iadd
/*     */     //   1907: if_icmplt -> 2040
/*     */     //   1910: iload_1
/*     */     //   1911: aload_0
/*     */     //   1912: getfield x : I
/*     */     //   1915: iload_3
/*     */     //   1916: iadd
/*     */     //   1917: if_icmpgt -> 2040
/*     */     //   1920: iload_2
/*     */     //   1921: aload_0
/*     */     //   1922: getfield y : I
/*     */     //   1925: aload_0
/*     */     //   1926: getfield height : I
/*     */     //   1929: iadd
/*     */     //   1930: bipush #9
/*     */     //   1932: iadd
/*     */     //   1933: if_icmplt -> 2040
/*     */     //   1936: iload_2
/*     */     //   1937: aload_0
/*     */     //   1938: getfield y : I
/*     */     //   1941: aload_0
/*     */     //   1942: getfield height : I
/*     */     //   1945: iadd
/*     */     //   1946: bipush #15
/*     */     //   1948: iadd
/*     */     //   1949: if_icmpgt -> 2040
/*     */     //   1952: iconst_0
/*     */     //   1953: invokestatic isButtonDown : (I)Z
/*     */     //   1956: ifeq -> 2040
/*     */     //   1959: iload_1
/*     */     //   1960: aload_0
/*     */     //   1961: getfield x : I
/*     */     //   1964: isub
/*     */     //   1965: i2f
/*     */     //   1966: ldc_w 8.0
/*     */     //   1969: fsub
/*     */     //   1970: iload_3
/*     */     //   1971: i2f
/*     */     //   1972: ldc_w 18.0
/*     */     //   1975: fsub
/*     */     //   1976: fdiv
/*     */     //   1977: fstore #15
/*     */     //   1979: fconst_0
/*     */     //   1980: fstore #16
/*     */     //   1982: fconst_1
/*     */     //   1983: fstore #17
/*     */     //   1985: iconst_0
/*     */     //   1986: istore #18
/*     */     //   1988: fload #15
/*     */     //   1990: fload #16
/*     */     //   1992: fcmpg
/*     */     //   1993: ifge -> 2001
/*     */     //   1996: fload #16
/*     */     //   1998: goto -> 2016
/*     */     //   2001: fload #15
/*     */     //   2003: fload #17
/*     */     //   2005: fcmpl
/*     */     //   2006: ifle -> 2014
/*     */     //   2009: fload #17
/*     */     //   2011: goto -> 2016
/*     */     //   2014: fload #15
/*     */     //   2016: fstore #14
/*     */     //   2018: aload #5
/*     */     //   2020: checkcast net/ccbluex/liquidbounce/value/FloatValue
/*     */     //   2023: fload #9
/*     */     //   2025: fload #10
/*     */     //   2027: fload #9
/*     */     //   2029: fsub
/*     */     //   2030: fload #14
/*     */     //   2032: fmul
/*     */     //   2033: fadd
/*     */     //   2034: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   2037: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2040: aload_0
/*     */     //   2041: dup
/*     */     //   2042: getfield height : I
/*     */     //   2045: bipush #20
/*     */     //   2047: iadd
/*     */     //   2048: putfield height : I
/*     */     //   2051: aload_0
/*     */     //   2052: dup
/*     */     //   2053: getfield realHeight : I
/*     */     //   2056: bipush #20
/*     */     //   2058: iadd
/*     */     //   2059: putfield realHeight : I
/*     */     //   2062: goto -> 3281
/*     */     //   2065: aload #7
/*     */     //   2067: instanceof net/ccbluex/liquidbounce/value/IntegerValue
/*     */     //   2070: ifeq -> 2522
/*     */     //   2073: aload #5
/*     */     //   2075: checkcast net/ccbluex/liquidbounce/value/IntegerValue
/*     */     //   2078: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2081: checkcast java/lang/Number
/*     */     //   2084: invokevirtual intValue : ()I
/*     */     //   2087: istore #8
/*     */     //   2089: aload #5
/*     */     //   2091: checkcast net/ccbluex/liquidbounce/value/IntegerValue
/*     */     //   2094: invokevirtual getMinimum : ()I
/*     */     //   2097: istore #9
/*     */     //   2099: aload #5
/*     */     //   2101: checkcast net/ccbluex/liquidbounce/value/IntegerValue
/*     */     //   2104: invokevirtual getMaximum : ()I
/*     */     //   2107: istore #10
/*     */     //   2109: new java/lang/StringBuilder
/*     */     //   2112: dup
/*     */     //   2113: invokespecial <init> : ()V
/*     */     //   2116: aload #5
/*     */     //   2118: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   2121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2124: ldc_w ': §c'
/*     */     //   2127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2130: iload #8
/*     */     //   2132: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   2135: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2138: astore #11
/*     */     //   2140: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2143: aload #11
/*     */     //   2145: aload_0
/*     */     //   2146: getfield x : I
/*     */     //   2149: iconst_2
/*     */     //   2150: iadd
/*     */     //   2151: aload_0
/*     */     //   2152: getfield y : I
/*     */     //   2155: aload_0
/*     */     //   2156: getfield height : I
/*     */     //   2159: iadd
/*     */     //   2160: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   2163: dup
/*     */     //   2164: ldc 'Color.WHITE'
/*     */     //   2166: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2169: invokevirtual getRGB : ()I
/*     */     //   2172: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   2177: pop
/*     */     //   2178: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2181: aload #11
/*     */     //   2183: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   2188: istore #12
/*     */     //   2190: aload_0
/*     */     //   2191: getfield width : I
/*     */     //   2194: iload #12
/*     */     //   2196: bipush #8
/*     */     //   2198: iadd
/*     */     //   2199: if_icmpge -> 2211
/*     */     //   2202: aload_0
/*     */     //   2203: iload #12
/*     */     //   2205: bipush #8
/*     */     //   2207: iadd
/*     */     //   2208: putfield width : I
/*     */     //   2211: aload_0
/*     */     //   2212: getfield x : I
/*     */     //   2215: i2f
/*     */     //   2216: ldc_w 8.0
/*     */     //   2219: fadd
/*     */     //   2220: aload_0
/*     */     //   2221: getfield y : I
/*     */     //   2224: aload_0
/*     */     //   2225: getfield height : I
/*     */     //   2228: iadd
/*     */     //   2229: i2f
/*     */     //   2230: ldc_w 12.0
/*     */     //   2233: fadd
/*     */     //   2234: aload_0
/*     */     //   2235: getfield x : I
/*     */     //   2238: iload_3
/*     */     //   2239: iadd
/*     */     //   2240: i2f
/*     */     //   2241: ldc_w 8.0
/*     */     //   2244: fsub
/*     */     //   2245: aload_0
/*     */     //   2246: getfield y : I
/*     */     //   2249: aload_0
/*     */     //   2250: getfield height : I
/*     */     //   2253: iadd
/*     */     //   2254: i2f
/*     */     //   2255: ldc_w 13.0
/*     */     //   2258: fadd
/*     */     //   2259: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   2262: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2265: aload_0
/*     */     //   2266: getfield x : I
/*     */     //   2269: i2f
/*     */     //   2270: iload_3
/*     */     //   2271: i2f
/*     */     //   2272: ldc_w 18.0
/*     */     //   2275: fsub
/*     */     //   2276: iload #8
/*     */     //   2278: iload #9
/*     */     //   2280: isub
/*     */     //   2281: i2f
/*     */     //   2282: fmul
/*     */     //   2283: iload #10
/*     */     //   2285: iload #9
/*     */     //   2287: isub
/*     */     //   2288: i2f
/*     */     //   2289: fdiv
/*     */     //   2290: fadd
/*     */     //   2291: fstore #13
/*     */     //   2293: ldc_w 8.0
/*     */     //   2296: fload #13
/*     */     //   2298: fadd
/*     */     //   2299: aload_0
/*     */     //   2300: getfield y : I
/*     */     //   2303: aload_0
/*     */     //   2304: getfield height : I
/*     */     //   2307: iadd
/*     */     //   2308: i2f
/*     */     //   2309: ldc_w 9.0
/*     */     //   2312: fadd
/*     */     //   2313: fload #13
/*     */     //   2315: ldc_w 11.0
/*     */     //   2318: fadd
/*     */     //   2319: aload_0
/*     */     //   2320: getfield y : I
/*     */     //   2323: aload_0
/*     */     //   2324: getfield height : I
/*     */     //   2327: iadd
/*     */     //   2328: i2f
/*     */     //   2329: ldc_w 15.0
/*     */     //   2332: fadd
/*     */     //   2333: new java/awt/Color
/*     */     //   2336: dup
/*     */     //   2337: bipush #37
/*     */     //   2339: bipush #126
/*     */     //   2341: sipush #255
/*     */     //   2344: invokespecial <init> : (III)V
/*     */     //   2347: invokevirtual getRGB : ()I
/*     */     //   2350: invokestatic drawRect : (FFFFI)V
/*     */     //   2353: iload_1
/*     */     //   2354: aload_0
/*     */     //   2355: getfield x : I
/*     */     //   2358: bipush #8
/*     */     //   2360: iadd
/*     */     //   2361: if_icmplt -> 2497
/*     */     //   2364: iload_1
/*     */     //   2365: aload_0
/*     */     //   2366: getfield x : I
/*     */     //   2369: iload_3
/*     */     //   2370: iadd
/*     */     //   2371: if_icmpgt -> 2497
/*     */     //   2374: iload_2
/*     */     //   2375: aload_0
/*     */     //   2376: getfield y : I
/*     */     //   2379: aload_0
/*     */     //   2380: getfield height : I
/*     */     //   2383: iadd
/*     */     //   2384: bipush #9
/*     */     //   2386: iadd
/*     */     //   2387: if_icmplt -> 2497
/*     */     //   2390: iload_2
/*     */     //   2391: aload_0
/*     */     //   2392: getfield y : I
/*     */     //   2395: aload_0
/*     */     //   2396: getfield height : I
/*     */     //   2399: iadd
/*     */     //   2400: bipush #15
/*     */     //   2402: iadd
/*     */     //   2403: if_icmpgt -> 2497
/*     */     //   2406: iconst_0
/*     */     //   2407: invokestatic isButtonDown : (I)Z
/*     */     //   2410: ifeq -> 2497
/*     */     //   2413: iload_1
/*     */     //   2414: aload_0
/*     */     //   2415: getfield x : I
/*     */     //   2418: isub
/*     */     //   2419: i2f
/*     */     //   2420: ldc_w 8.0
/*     */     //   2423: fsub
/*     */     //   2424: iload_3
/*     */     //   2425: i2f
/*     */     //   2426: ldc_w 18.0
/*     */     //   2429: fsub
/*     */     //   2430: fdiv
/*     */     //   2431: fstore #15
/*     */     //   2433: fconst_0
/*     */     //   2434: fstore #16
/*     */     //   2436: fconst_1
/*     */     //   2437: fstore #17
/*     */     //   2439: iconst_0
/*     */     //   2440: istore #18
/*     */     //   2442: fload #15
/*     */     //   2444: fload #16
/*     */     //   2446: fcmpg
/*     */     //   2447: ifge -> 2455
/*     */     //   2450: fload #16
/*     */     //   2452: goto -> 2470
/*     */     //   2455: fload #15
/*     */     //   2457: fload #17
/*     */     //   2459: fcmpl
/*     */     //   2460: ifle -> 2468
/*     */     //   2463: fload #17
/*     */     //   2465: goto -> 2470
/*     */     //   2468: fload #15
/*     */     //   2470: fstore #14
/*     */     //   2472: aload #5
/*     */     //   2474: checkcast net/ccbluex/liquidbounce/value/IntegerValue
/*     */     //   2477: iload #9
/*     */     //   2479: i2f
/*     */     //   2480: iload #10
/*     */     //   2482: iload #9
/*     */     //   2484: isub
/*     */     //   2485: i2f
/*     */     //   2486: fload #14
/*     */     //   2488: fmul
/*     */     //   2489: fadd
/*     */     //   2490: f2i
/*     */     //   2491: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   2494: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2497: aload_0
/*     */     //   2498: dup
/*     */     //   2499: getfield height : I
/*     */     //   2502: bipush #20
/*     */     //   2504: iadd
/*     */     //   2505: putfield height : I
/*     */     //   2508: aload_0
/*     */     //   2509: dup
/*     */     //   2510: getfield realHeight : I
/*     */     //   2513: bipush #20
/*     */     //   2515: iadd
/*     */     //   2516: putfield realHeight : I
/*     */     //   2519: goto -> 3281
/*     */     //   2522: aload #7
/*     */     //   2524: instanceof net/ccbluex/liquidbounce/value/ListValue
/*     */     //   2527: ifeq -> 2856
/*     */     //   2530: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2533: aload #5
/*     */     //   2535: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   2538: aload_0
/*     */     //   2539: getfield x : I
/*     */     //   2542: iconst_2
/*     */     //   2543: iadd
/*     */     //   2544: aload_0
/*     */     //   2545: getfield y : I
/*     */     //   2548: aload_0
/*     */     //   2549: getfield height : I
/*     */     //   2552: iadd
/*     */     //   2553: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   2556: dup
/*     */     //   2557: ldc 'Color.WHITE'
/*     */     //   2559: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2562: invokevirtual getRGB : ()I
/*     */     //   2565: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   2570: pop
/*     */     //   2571: aload_0
/*     */     //   2572: dup
/*     */     //   2573: getfield height : I
/*     */     //   2576: bipush #10
/*     */     //   2578: iadd
/*     */     //   2579: putfield height : I
/*     */     //   2582: aload_0
/*     */     //   2583: dup
/*     */     //   2584: getfield realHeight : I
/*     */     //   2587: bipush #10
/*     */     //   2589: iadd
/*     */     //   2590: putfield realHeight : I
/*     */     //   2593: aload #5
/*     */     //   2595: checkcast net/ccbluex/liquidbounce/value/ListValue
/*     */     //   2598: invokevirtual getValues : ()[Ljava/lang/String;
/*     */     //   2601: astore #10
/*     */     //   2603: aload #10
/*     */     //   2605: arraylength
/*     */     //   2606: istore #11
/*     */     //   2608: iconst_0
/*     */     //   2609: istore #9
/*     */     //   2611: iload #9
/*     */     //   2613: iload #11
/*     */     //   2615: if_icmpge -> 3281
/*     */     //   2618: aload #10
/*     */     //   2620: iload #9
/*     */     //   2622: aaload
/*     */     //   2623: astore #8
/*     */     //   2625: new java/lang/StringBuilder
/*     */     //   2628: dup
/*     */     //   2629: invokespecial <init> : ()V
/*     */     //   2632: ldc_w '§c> §r'
/*     */     //   2635: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2638: aload #8
/*     */     //   2640: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2643: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2646: astore #12
/*     */     //   2648: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2651: aload #12
/*     */     //   2653: aload_0
/*     */     //   2654: getfield x : I
/*     */     //   2657: iconst_2
/*     */     //   2658: iadd
/*     */     //   2659: aload_0
/*     */     //   2660: getfield y : I
/*     */     //   2663: aload_0
/*     */     //   2664: getfield height : I
/*     */     //   2667: iadd
/*     */     //   2668: aload #8
/*     */     //   2670: aload #5
/*     */     //   2672: checkcast net/ccbluex/liquidbounce/value/ListValue
/*     */     //   2675: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2678: checkcast java/lang/String
/*     */     //   2681: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2684: ifeq -> 2702
/*     */     //   2687: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   2690: dup
/*     */     //   2691: ldc 'Color.WHITE'
/*     */     //   2693: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2696: invokevirtual getRGB : ()I
/*     */     //   2699: goto -> 2715
/*     */     //   2702: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   2705: dup
/*     */     //   2706: ldc_w 'Color.GRAY'
/*     */     //   2709: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   2712: invokevirtual getRGB : ()I
/*     */     //   2715: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   2720: pop
/*     */     //   2721: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2724: aload #12
/*     */     //   2726: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   2731: istore #13
/*     */     //   2733: aload_0
/*     */     //   2734: getfield width : I
/*     */     //   2737: iload #13
/*     */     //   2739: bipush #8
/*     */     //   2741: iadd
/*     */     //   2742: if_icmpge -> 2754
/*     */     //   2745: aload_0
/*     */     //   2746: iload #13
/*     */     //   2748: bipush #8
/*     */     //   2750: iadd
/*     */     //   2751: putfield width : I
/*     */     //   2754: iconst_0
/*     */     //   2755: invokestatic isButtonDown : (I)Z
/*     */     //   2758: ifeq -> 2828
/*     */     //   2761: aload_0
/*     */     //   2762: getfield mouseDown : Z
/*     */     //   2765: ifne -> 2828
/*     */     //   2768: iload_1
/*     */     //   2769: aload_0
/*     */     //   2770: getfield x : I
/*     */     //   2773: if_icmplt -> 2828
/*     */     //   2776: iload_1
/*     */     //   2777: aload_0
/*     */     //   2778: getfield x : I
/*     */     //   2781: aload_0
/*     */     //   2782: getfield width : I
/*     */     //   2785: iadd
/*     */     //   2786: if_icmpgt -> 2828
/*     */     //   2789: iload_2
/*     */     //   2790: aload_0
/*     */     //   2791: getfield y : I
/*     */     //   2794: aload_0
/*     */     //   2795: getfield height : I
/*     */     //   2798: iadd
/*     */     //   2799: if_icmplt -> 2828
/*     */     //   2802: iload_2
/*     */     //   2803: aload_0
/*     */     //   2804: getfield y : I
/*     */     //   2807: aload_0
/*     */     //   2808: getfield height : I
/*     */     //   2811: iadd
/*     */     //   2812: bipush #10
/*     */     //   2814: iadd
/*     */     //   2815: if_icmpgt -> 2828
/*     */     //   2818: aload #5
/*     */     //   2820: checkcast net/ccbluex/liquidbounce/value/ListValue
/*     */     //   2823: aload #8
/*     */     //   2825: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   2828: aload_0
/*     */     //   2829: dup
/*     */     //   2830: getfield height : I
/*     */     //   2833: bipush #10
/*     */     //   2835: iadd
/*     */     //   2836: putfield height : I
/*     */     //   2839: aload_0
/*     */     //   2840: dup
/*     */     //   2841: getfield realHeight : I
/*     */     //   2844: bipush #10
/*     */     //   2846: iadd
/*     */     //   2847: putfield realHeight : I
/*     */     //   2850: iinc #9, 1
/*     */     //   2853: goto -> 2611
/*     */     //   2856: aload #7
/*     */     //   2858: instanceof net/ccbluex/liquidbounce/value/FontValue
/*     */     //   2861: ifeq -> 3281
/*     */     //   2864: aload #5
/*     */     //   2866: checkcast net/ccbluex/liquidbounce/value/FontValue
/*     */     //   2869: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2872: checkcast net/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer
/*     */     //   2875: astore #8
/*     */     //   2877: nop
/*     */     //   2878: aload #8
/*     */     //   2880: invokeinterface isGameFontRenderer : ()Z
/*     */     //   2885: ifeq -> 2951
/*     */     //   2888: new java/lang/StringBuilder
/*     */     //   2891: dup
/*     */     //   2892: invokespecial <init> : ()V
/*     */     //   2895: ldc_w 'Font: '
/*     */     //   2898: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2901: aload #8
/*     */     //   2903: invokeinterface getGameFontRenderer : ()Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;
/*     */     //   2908: invokevirtual getDefaultFont : ()Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   2911: invokevirtual getFont : ()Ljava/awt/Font;
/*     */     //   2914: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   2917: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2920: ldc_w ' - '
/*     */     //   2923: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   2926: aload #8
/*     */     //   2928: invokeinterface getGameFontRenderer : ()Lnet/ccbluex/liquidbounce/ui/font/GameFontRenderer;
/*     */     //   2933: invokevirtual getDefaultFont : ()Lnet/ccbluex/liquidbounce/ui/font/AWTFontRenderer;
/*     */     //   2936: invokevirtual getFont : ()Ljava/awt/Font;
/*     */     //   2939: invokevirtual getSize : ()I
/*     */     //   2942: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   2945: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   2948: goto -> 2971
/*     */     //   2951: aload #8
/*     */     //   2953: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.minecraftFont : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2956: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2959: ifeq -> 2968
/*     */     //   2962: ldc_w 'Font: Minecraft'
/*     */     //   2965: goto -> 2971
/*     */     //   2968: ldc_w 'Font: Unknown'
/*     */     //   2971: astore #9
/*     */     //   2973: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2976: aload #9
/*     */     //   2978: aload_0
/*     */     //   2979: getfield x : I
/*     */     //   2982: iconst_2
/*     */     //   2983: iadd
/*     */     //   2984: aload_0
/*     */     //   2985: getfield y : I
/*     */     //   2988: aload_0
/*     */     //   2989: getfield height : I
/*     */     //   2992: iadd
/*     */     //   2993: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   2996: dup
/*     */     //   2997: ldc 'Color.WHITE'
/*     */     //   2999: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3002: invokevirtual getRGB : ()I
/*     */     //   3005: invokeinterface drawString : (Ljava/lang/String;III)I
/*     */     //   3010: pop
/*     */     //   3011: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3014: aload #9
/*     */     //   3016: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   3021: istore #10
/*     */     //   3023: aload_0
/*     */     //   3024: getfield width : I
/*     */     //   3027: iload #10
/*     */     //   3029: bipush #8
/*     */     //   3031: iadd
/*     */     //   3032: if_icmpge -> 3044
/*     */     //   3035: aload_0
/*     */     //   3036: iload #10
/*     */     //   3038: bipush #8
/*     */     //   3040: iadd
/*     */     //   3041: putfield width : I
/*     */     //   3044: iconst_0
/*     */     //   3045: invokestatic isButtonDown : (I)Z
/*     */     //   3048: ifeq -> 3259
/*     */     //   3051: aload_0
/*     */     //   3052: getfield mouseDown : Z
/*     */     //   3055: ifne -> 3259
/*     */     //   3058: iload_1
/*     */     //   3059: aload_0
/*     */     //   3060: getfield x : I
/*     */     //   3063: if_icmplt -> 3259
/*     */     //   3066: iload_1
/*     */     //   3067: aload_0
/*     */     //   3068: getfield x : I
/*     */     //   3071: aload_0
/*     */     //   3072: getfield width : I
/*     */     //   3075: iadd
/*     */     //   3076: if_icmpgt -> 3259
/*     */     //   3079: iload_2
/*     */     //   3080: aload_0
/*     */     //   3081: getfield y : I
/*     */     //   3084: aload_0
/*     */     //   3085: getfield height : I
/*     */     //   3088: iadd
/*     */     //   3089: if_icmplt -> 3259
/*     */     //   3092: iload_2
/*     */     //   3093: aload_0
/*     */     //   3094: getfield y : I
/*     */     //   3097: aload_0
/*     */     //   3098: getfield height : I
/*     */     //   3101: iadd
/*     */     //   3102: bipush #10
/*     */     //   3104: iadd
/*     */     //   3105: if_icmpgt -> 3259
/*     */     //   3108: invokestatic getFonts : ()Ljava/util/List;
/*     */     //   3111: astore #11
/*     */     //   3113: aload #11
/*     */     //   3115: dup
/*     */     //   3116: ldc_w 'fonts'
/*     */     //   3119: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3122: checkcast java/lang/Iterable
/*     */     //   3125: astore #12
/*     */     //   3127: iconst_0
/*     */     //   3128: istore #13
/*     */     //   3130: iconst_0
/*     */     //   3131: istore #14
/*     */     //   3133: aload #12
/*     */     //   3135: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   3140: astore #15
/*     */     //   3142: aload #15
/*     */     //   3144: invokeinterface hasNext : ()Z
/*     */     //   3149: ifeq -> 3258
/*     */     //   3152: aload #15
/*     */     //   3154: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   3159: astore #16
/*     */     //   3161: iload #14
/*     */     //   3163: iinc #14, 1
/*     */     //   3166: istore #17
/*     */     //   3168: iconst_0
/*     */     //   3169: istore #18
/*     */     //   3171: iload #17
/*     */     //   3173: ifge -> 3179
/*     */     //   3176: invokestatic throwIndexOverflow : ()V
/*     */     //   3179: iload #17
/*     */     //   3181: istore #19
/*     */     //   3183: iload #19
/*     */     //   3185: aload #16
/*     */     //   3187: checkcast net/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer
/*     */     //   3190: astore #20
/*     */     //   3192: istore #21
/*     */     //   3194: iconst_0
/*     */     //   3195: istore #22
/*     */     //   3197: aload #20
/*     */     //   3199: aload #8
/*     */     //   3201: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   3204: ifeq -> 3254
/*     */     //   3207: aload #5
/*     */     //   3209: checkcast net/ccbluex/liquidbounce/value/FontValue
/*     */     //   3212: aload #11
/*     */     //   3214: iload #21
/*     */     //   3216: iconst_1
/*     */     //   3217: iadd
/*     */     //   3218: aload #11
/*     */     //   3220: invokeinterface size : ()I
/*     */     //   3225: if_icmplt -> 3232
/*     */     //   3228: iconst_0
/*     */     //   3229: goto -> 3236
/*     */     //   3232: iload #21
/*     */     //   3234: iconst_1
/*     */     //   3235: iadd
/*     */     //   3236: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   3241: dup
/*     */     //   3242: ldc_w 'fonts[if (index + 1 >= f…s.size) 0 else index + 1]'
/*     */     //   3245: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3248: invokevirtual set : (Ljava/lang/Object;)V
/*     */     //   3251: goto -> 3254
/*     */     //   3254: nop
/*     */     //   3255: goto -> 3142
/*     */     //   3258: nop
/*     */     //   3259: aload_0
/*     */     //   3260: dup
/*     */     //   3261: getfield height : I
/*     */     //   3264: bipush #10
/*     */     //   3266: iadd
/*     */     //   3267: putfield height : I
/*     */     //   3270: aload_0
/*     */     //   3271: dup
/*     */     //   3272: getfield realHeight : I
/*     */     //   3275: bipush #10
/*     */     //   3277: iadd
/*     */     //   3278: putfield realHeight : I
/*     */     //   3281: goto -> 1300
/*     */     //   3284: aload_0
/*     */     //   3285: getfield x : I
/*     */     //   3288: aload_0
/*     */     //   3289: getfield y : I
/*     */     //   3292: aload_0
/*     */     //   3293: getfield x : I
/*     */     //   3296: aload_0
/*     */     //   3297: getfield width : I
/*     */     //   3300: iadd
/*     */     //   3301: aload_0
/*     */     //   3302: getfield y : I
/*     */     //   3305: bipush #12
/*     */     //   3307: iadd
/*     */     //   3308: invokestatic generateColor : ()Ljava/awt/Color;
/*     */     //   3311: dup
/*     */     //   3312: ldc_w 'ClickGUI.generateColor()'
/*     */     //   3315: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3318: invokevirtual getRGB : ()I
/*     */     //   3321: invokestatic drawRect : (IIIII)V
/*     */     //   3324: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3327: new java/lang/StringBuilder
/*     */     //   3330: dup
/*     */     //   3331: invokespecial <init> : ()V
/*     */     //   3334: ldc_w '§l'
/*     */     //   3337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3340: aload #4
/*     */     //   3342: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   3345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   3348: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   3351: aload_0
/*     */     //   3352: getfield x : I
/*     */     //   3355: i2f
/*     */     //   3356: fconst_2
/*     */     //   3357: fadd
/*     */     //   3358: aload_0
/*     */     //   3359: getfield y : I
/*     */     //   3362: i2f
/*     */     //   3363: ldc_w 3.5
/*     */     //   3366: fadd
/*     */     //   3367: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   3370: dup
/*     */     //   3371: ldc 'Color.WHITE'
/*     */     //   3373: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3376: invokevirtual getRGB : ()I
/*     */     //   3379: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   3384: pop
/*     */     //   3385: aload #4
/*     */     //   3387: invokevirtual getInfo : ()Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo;
/*     */     //   3390: invokeinterface force : ()Z
/*     */     //   3395: ifne -> 3525
/*     */     //   3398: aload_0
/*     */     //   3399: getfield x : I
/*     */     //   3402: aload_0
/*     */     //   3403: getfield width : I
/*     */     //   3406: iadd
/*     */     //   3407: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3410: ldc_w '§lDelete'
/*     */     //   3413: invokeinterface getStringWidth : (Ljava/lang/String;)I
/*     */     //   3418: isub
/*     */     //   3419: i2f
/*     */     //   3420: fconst_2
/*     */     //   3421: fsub
/*     */     //   3422: fstore #5
/*     */     //   3424: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.roboto35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3427: ldc_w '§lDelete'
/*     */     //   3430: fload #5
/*     */     //   3432: aload_0
/*     */     //   3433: getfield y : I
/*     */     //   3436: i2f
/*     */     //   3437: ldc_w 3.5
/*     */     //   3440: fadd
/*     */     //   3441: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   3444: dup
/*     */     //   3445: ldc 'Color.WHITE'
/*     */     //   3447: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   3450: invokevirtual getRGB : ()I
/*     */     //   3453: invokeinterface drawString : (Ljava/lang/String;FFI)I
/*     */     //   3458: pop
/*     */     //   3459: iconst_0
/*     */     //   3460: invokestatic isButtonDown : (I)Z
/*     */     //   3463: ifeq -> 3525
/*     */     //   3466: aload_0
/*     */     //   3467: getfield mouseDown : Z
/*     */     //   3470: ifne -> 3525
/*     */     //   3473: iload_1
/*     */     //   3474: i2f
/*     */     //   3475: fload #5
/*     */     //   3477: fcmpl
/*     */     //   3478: iflt -> 3525
/*     */     //   3481: iload_1
/*     */     //   3482: aload_0
/*     */     //   3483: getfield x : I
/*     */     //   3486: aload_0
/*     */     //   3487: getfield width : I
/*     */     //   3490: iadd
/*     */     //   3491: if_icmpgt -> 3525
/*     */     //   3494: iload_2
/*     */     //   3495: aload_0
/*     */     //   3496: getfield y : I
/*     */     //   3499: if_icmplt -> 3525
/*     */     //   3502: iload_2
/*     */     //   3503: aload_0
/*     */     //   3504: getfield y : I
/*     */     //   3507: bipush #10
/*     */     //   3509: iadd
/*     */     //   3510: if_icmpgt -> 3525
/*     */     //   3513: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   3516: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   3519: aload #4
/*     */     //   3521: invokevirtual removeElement : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;)Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   3524: pop
/*     */     //   3525: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #199	-> 0
/*     */     //   #200	-> 11
/*     */     //   #202	-> 17
/*     */     //   #203	-> 22
/*     */     //   #205	-> 28
/*     */     //   #205	-> 39
/*     */     //   #208	-> 43
/*     */     //   #208	-> 124
/*     */     //   #208	-> 191
/*     */     //   #209	-> 224
/*     */     //   #210	-> 235
/*     */     //   #213	-> 246
/*     */     //   #213	-> 327
/*     */     //   #213	-> 394
/*     */     //   #214	-> 427
/*     */     //   #215	-> 438
/*     */     //   #218	-> 449
/*     */     //   #218	-> 527
/*     */     //   #219	-> 560
/*     */     //   #220	-> 571
/*     */     //   #223	-> 582
/*     */     //   #224	-> 621
/*     */     //   #225	-> 635
/*     */     //   #224	-> 664
/*     */     //   #227	-> 670
/*     */     //   #228	-> 670
/*     */     //   #227	-> 670
/*     */     //   #228	-> 719
/*     */     //   #229	-> 734
/*     */     //   #230	-> 739
/*     */     //   #232	-> 754
/*     */     //   #234	-> 761
/*     */     //   #235	-> 790
/*     */     //   #236	-> 836
/*     */     //   #237	-> 841
/*     */     //   #238	-> 873
/*     */     //   #235	-> 911
/*     */     //   #242	-> 914
/*     */     //   #243	-> 925
/*     */     //   #246	-> 936
/*     */     //   #247	-> 975
/*     */     //   #248	-> 989
/*     */     //   #247	-> 1018
/*     */     //   #250	-> 1024
/*     */     //   #251	-> 1088
/*     */     //   #252	-> 1093
/*     */     //   #254	-> 1108
/*     */     //   #256	-> 1115
/*     */     //   #257	-> 1144
/*     */     //   #258	-> 1188
/*     */     //   #259	-> 1193
/*     */     //   #260	-> 1225
/*     */     //   #257	-> 1263
/*     */     //   #265	-> 1266
/*     */     //   #266	-> 1277
/*     */     //   #269	-> 1288
/*     */     //   #270	-> 1322
/*     */     //   #271	-> 1326
/*     */     //   #273	-> 1334
/*     */     //   #275	-> 1408
/*     */     //   #276	-> 1423
/*     */     //   #277	-> 1435
/*     */     //   #280	-> 1444
/*     */     //   #281	-> 1444
/*     */     //   #280	-> 1444
/*     */     //   #281	-> 1480
/*     */     //   #282	-> 1508
/*     */     //   #285	-> 1541
/*     */     //   #286	-> 1552
/*     */     //   #289	-> 1566
/*     */     //   #290	-> 1574
/*     */     //   #291	-> 1590
/*     */     //   #292	-> 1600
/*     */     //   #295	-> 1610
/*     */     //   #295	-> 1686
/*     */     //   #297	-> 1688
/*     */     //   #299	-> 1726
/*     */     //   #300	-> 1738
/*     */     //   #301	-> 1750
/*     */     //   #304	-> 1759
/*     */     //   #307	-> 1813
/*     */     //   #308	-> 1839
/*     */     //   #309	-> 1875
/*     */     //   #308	-> 1896
/*     */     //   #312	-> 1899
/*     */     //   #313	-> 1899
/*     */     //   #312	-> 1900
/*     */     //   #313	-> 1952
/*     */     //   #314	-> 1959
/*     */     //   #456	-> 1988
/*     */     //   #314	-> 2016
/*     */     //   #316	-> 2018
/*     */     //   #320	-> 2040
/*     */     //   #321	-> 2051
/*     */     //   #324	-> 2065
/*     */     //   #325	-> 2073
/*     */     //   #326	-> 2089
/*     */     //   #327	-> 2099
/*     */     //   #330	-> 2109
/*     */     //   #332	-> 2140
/*     */     //   #334	-> 2178
/*     */     //   #335	-> 2190
/*     */     //   #336	-> 2202
/*     */     //   #339	-> 2211
/*     */     //   #342	-> 2265
/*     */     //   #343	-> 2293
/*     */     //   #344	-> 2329
/*     */     //   #343	-> 2350
/*     */     //   #347	-> 2353
/*     */     //   #348	-> 2353
/*     */     //   #347	-> 2354
/*     */     //   #348	-> 2406
/*     */     //   #349	-> 2413
/*     */     //   #457	-> 2442
/*     */     //   #349	-> 2470
/*     */     //   #351	-> 2472
/*     */     //   #355	-> 2497
/*     */     //   #356	-> 2508
/*     */     //   #359	-> 2522
/*     */     //   #361	-> 2530
/*     */     //   #363	-> 2571
/*     */     //   #364	-> 2582
/*     */     //   #367	-> 2593
/*     */     //   #369	-> 2625
/*     */     //   #370	-> 2648
/*     */     //   #372	-> 2721
/*     */     //   #373	-> 2733
/*     */     //   #374	-> 2745
/*     */     //   #377	-> 2754
/*     */     //   #378	-> 2754
/*     */     //   #377	-> 2754
/*     */     //   #378	-> 2790
/*     */     //   #379	-> 2818
/*     */     //   #382	-> 2828
/*     */     //   #383	-> 2839
/*     */     //   #367	-> 2850
/*     */     //   #387	-> 2856
/*     */     //   #388	-> 2864
/*     */     //   #391	-> 2877
/*     */     //   #392	-> 2878
/*     */     //   #393	-> 2951
/*     */     //   #394	-> 2968
/*     */     //   #391	-> 2971
/*     */     //   #397	-> 2973
/*     */     //   #399	-> 3011
/*     */     //   #400	-> 3023
/*     */     //   #401	-> 3035
/*     */     //   #403	-> 3044
/*     */     //   #404	-> 3044
/*     */     //   #403	-> 3044
/*     */     //   #404	-> 3080
/*     */     //   #405	-> 3108
/*     */     //   #407	-> 3113
/*     */     //   #458	-> 3130
/*     */     //   #459	-> 3133
/*     */     //   #459	-> 3185
/*     */     //   #408	-> 3197
/*     */     //   #409	-> 3207
/*     */     //   #410	-> 3251
/*     */     //   #412	-> 3254
/*     */     //   #460	-> 3258
/*     */     //   #415	-> 3259
/*     */     //   #416	-> 3270
/*     */     //   #418	-> 3281
/*     */     //   #269	-> 3281
/*     */     //   #422	-> 3284
/*     */     //   #423	-> 3324
/*     */     //   #426	-> 3385
/*     */     //   #427	-> 3398
/*     */     //   #428	-> 3424
/*     */     //   #429	-> 3459
/*     */     //   #430	-> 3459
/*     */     //   #429	-> 3459
/*     */     //   #430	-> 3503
/*     */     //   #431	-> 3513
/*     */     //   #433	-> 3525
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   761	153	7	x	D
/*     */     //   754	160	6	currIndex	I
/*     */     //   739	175	5	values	[Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */     //   1115	151	7	y	D
/*     */     //   1108	158	6	currIndex	I
/*     */     //   1093	173	5	values	[Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */     //   1423	140	8	stringWidth	I
/*     */     //   1985	31	15	num$iv	F
/*     */     //   1985	31	16	min$iv	F
/*     */     //   1985	31	17	max$iv	F
/*     */     //   1988	28	18	$i$f$clamp_float	I
/*     */     //   2018	22	14	curr	F
/*     */     //   1839	223	13	sliderValue	F
/*     */     //   1738	324	12	stringWidth	I
/*     */     //   1688	374	11	text	Ljava/lang/String;
/*     */     //   1610	452	10	max	F
/*     */     //   1600	462	9	min	F
/*     */     //   1590	472	8	current	F
/*     */     //   2439	31	15	num$iv	F
/*     */     //   2439	31	16	min$iv	F
/*     */     //   2439	31	17	max$iv	F
/*     */     //   2442	28	18	$i$f$clamp_float	I
/*     */     //   2472	25	14	curr	F
/*     */     //   2293	226	13	sliderValue	F
/*     */     //   2190	329	12	stringWidth	I
/*     */     //   2140	379	11	text	Ljava/lang/String;
/*     */     //   2109	410	10	max	I
/*     */     //   2099	420	9	min	I
/*     */     //   2089	430	8	current	I
/*     */     //   2733	117	13	stringWidth	I
/*     */     //   2648	202	12	text	Ljava/lang/String;
/*     */     //   2625	228	8	s	Ljava/lang/String;
/*     */     //   3194	60	21	index	I
/*     */     //   3194	60	20	font	Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   3197	57	22	$i$a$-forEachIndexed-EditorPanel$drawEditor$1	I
/*     */     //   3161	94	16	item$iv	Ljava/lang/Object;
/*     */     //   3133	126	14	index$iv	I
/*     */     //   3127	132	12	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   3130	129	13	$i$f$forEachIndexed	I
/*     */     //   3113	146	11	fonts	Ljava/util/List;
/*     */     //   3023	258	10	stringWidth	I
/*     */     //   2973	308	9	text	Ljava/lang/String;
/*     */     //   2877	404	8	fontRenderer	Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1322	1959	5	value	Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   3424	101	5	deleteWidth	F
/*     */     //   43	3483	4	element	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*     */     //   22	3504	3	prevWidth	I
/*     */     //   0	3526	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*     */     //   0	3526	1	mouseX	I
/*     */     //   0	3526	2	mouseY	I
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void drag(int mouseX, int mouseY) {
/* 440 */     if (mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + 12 && Mouse.isButtonDown(0) && !this.mouseDown) {
/* 441 */       this.drag = true;
/* 442 */       this.dragX = mouseX - this.x;
/* 443 */       this.dragY = mouseY - this.y;
/*     */     } 
/*     */     
/* 446 */     if (Mouse.isButtonDown(0) && this.drag)
/* 447 */     { this.x = mouseX - this.dragX;
/* 448 */       this.y = mouseY - this.dragY; }
/* 449 */     else { this.drag = false; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\designer\EditorPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */