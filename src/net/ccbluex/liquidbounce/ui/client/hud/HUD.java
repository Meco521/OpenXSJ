/*     */ package net.ccbluex.liquidbounce.ui.client.hud;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\f\n\000\n\002\020\b\n\002\b\016\b\026\030\000 &2\0020\001:\001&B\005¢\006\002\020\002J\016\020\016\032\0020\0002\006\020\017\032\0020\005J\016\020\020\032\0020\0212\006\020\022\032\0020\nJ\006\020\023\032\0020\024J\026\020\025\032\0020\0242\006\020\026\032\0020\0272\006\020\030\032\0020\031J\036\020\032\032\0020\0242\006\020\033\032\0020\0312\006\020\034\032\0020\0312\006\020\035\032\0020\031J\026\020\036\032\0020\0242\006\020\033\032\0020\0312\006\020\034\032\0020\031J\006\020\037\032\0020\024J\016\020 \032\0020\0002\006\020\017\032\0020\005J\016\020!\032\0020\0212\006\020\022\032\0020\nJ\016\020\"\032\0020\0242\006\020#\032\0020\021J\016\020$\032\0020\0242\006\020#\032\0020\021J\006\020%\032\0020\024R\031\020\003\032\b\022\004\022\0020\0050\004¢\006\n\n\002\b\b\032\004\b\006\020\007R\027\020\t\032\b\022\004\022\0020\n0\004¢\006\b\n\000\032\004\b\013\020\007R\027\020\f\032\b\022\004\022\0020\n0\004¢\006\b\n\000\032\004\b\r\020\007¨\006'"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "elements", "", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "getElements", "()Ljava/util/List;", "elements$1", "notifications", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;", "getNotifications", "notifications2", "getNotifications2", "addElement", "element", "addNotification", "", "notification", "clearElements", "", "handleKey", "c", "", "keyCode", "", "handleMouseClick", "mouseX", "mouseY", "button", "handleMouseMove", "handleMouseReleased", "removeElement", "removeNotification", "render", "designer", "renderShader", "update", "Companion", "XSJClient"})
/*     */ public class HUD extends MinecraftInstance {
/*     */   @NotNull
/*     */   private final List<Element> elements$1;
/*     */   @NotNull
/*     */   private final List<Notification> notifications;
/*     */   
/*  14 */   public HUD() { HUD hUD = this; boolean bool = false; ArrayList<Element> arrayList = new ArrayList();
/*  15 */     hUD = this; bool = false; hUD.notifications = (List)(arrayList = new ArrayList<>());
/*  16 */     hUD = this; bool = false; hUD.notifications2 = (List)(arrayList = new ArrayList<>()); } @NotNull private final List<Notification> notifications2; @NotNull private static final Class<? extends Element>[] elements; @NotNull public final List<Element> getElements() { return this.elements$1; } @NotNull public final List<Notification> getNotifications() { return this.notifications; } @NotNull public final List<Notification> getNotifications2() { return this.notifications2; }
/*     */ 
/*     */ 
/*     */   
/*  20 */   public static final Companion Companion = new Companion(null); static { elements = (Class<? extends Element>[])new Class[] { 
/*  21 */         IP.class, 
/*  22 */         MS.class, 
/*  23 */         CPS.class, 
/*  24 */         XYZ.class, 
/*  25 */         Text.class, 
/*  26 */         Kill.class, 
/*  27 */         Text2.class, 
/*  28 */         Armor.class, 
/*  29 */         Clock.class, 
/*  30 */         Radar.class, 
/*  31 */         Image.class, 
/*  32 */         Speed.class, 
/*  33 */         Model.class, 
/*  34 */         Target.class, 
/*  35 */         Hotbar.class, 
/*  36 */         QQlogo.class, 
/*  37 */         Radar2.class, 
/*  38 */         Radar3.class, 
/*  39 */         TabGUI.class, 
/*  40 */         QQLogo2.class, 
/*  41 */         Effects.class, 
/*  42 */         TabGUI2.class, 
/*  43 */         GameInfo.class, 
/*  44 */         KeyBinds.class, 
/*  45 */         Username.class, 
/*  46 */         GameInfo2.class, 
/*  47 */         GameInfo3.class, 
/*  48 */         GameInfo4.class, 
/*  49 */         GameInfo5.class, 
/*  50 */         NovoArmor.class, 
/*  51 */         TargetHud.class, 
/*  52 */         RenderFps.class, 
/*  53 */         HealthHud.class, 
/*  54 */         Arraylist.class, 
/*  55 */         AutoPlayGG.class, 
/*  56 */         PlayerList.class, 
/*  57 */         TargetHud2.class, 
/*  58 */         TargetHud3.class, 
/*  59 */         KeyStrokes.class, 
/*  60 */         Inventory5.class, 
/*  61 */         DisSession.class, 
/*  62 */         NewEffects.class, 
/*  63 */         SpeedGraph.class, 
/*  64 */         BanChecker.class, 
/*  65 */         NewEffects2.class, 
/*  66 */         NovoSession.class, 
/*  67 */         SpeedGraph2.class, 
/*  68 */         SessionInfo.class, 
/*  69 */         Ka4TargetHud.class, 
/*  70 */         PlayerHealth.class, 
/*  71 */         SessionInfo2.class, 
/*  72 */         SessionInfo3.class, 
/*  73 */         SessionInfo4.class, 
/*  74 */         NovoKeyBinds.class, 
/*  75 */         VapeArraylist.class, 
/*  76 */         Notifications.class, 
/*  77 */         ScoreboardElement.class }; }
/*     */    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\021\n\002\030\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\n\032\0020\013H\007R!\020\003\032\020\022\f\022\n\022\006\b\001\022\0020\0060\0050\004¢\006\n\n\002\020\t\032\004\b\007\020\b¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/HUD$Companion;", "", "()V", "elements", "", "Ljava/lang/Class;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "getElements", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "createDefault", "Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;", "XSJClient"})
/*     */   public static final class Companion { private Companion() {} @NotNull
/*     */     public final Class<? extends Element>[] getElements() {
/*     */       return HUD.elements;
/*     */     }
/*     */     @JvmStatic
/*     */     @NotNull
/*     */     public final HUD createDefault() {
/*  86 */       return (new HUD()).addElement((Element)new Arraylist(0.0D, 0.0D, 0.0F, null, 15, null)).addElement((Element)new ScoreboardElement(0.0D, 0.0D, 0.0F, null, 15, null)).addElement((Element)new Notifications(0.0D, 0.0D, 0.0F, null, 15, null));
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void render(boolean designer)
/*     */   {
/*  93 */     Iterable<Element> $this$sortedBy$iv = this.elements$1; int $i$f$sortedBy = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     Iterable<Element> iterable1 = $this$sortedBy$iv; boolean bool = false; HUD$render$$inlined$sortedBy$1 hUD$render$$inlined$sortedBy$1 = new HUD$render$$inlined$sortedBy$1(); Iterable $this$forEach$iv = CollectionsKt.sortedWith(iterable1, hUD$render$$inlined$sortedBy$1); int $i$f$forEach = 0;
/* 273 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); Element it = (Element)element$iv; int $i$a$-forEach-HUD$render$2 = 0; GL11.glPushMatrix(); }
/*     */      } public final void renderShader(boolean designer) { Iterable<Element> $this$sortedBy$iv = this.elements$1; int $i$f$sortedBy = 0;
/* 275 */     Iterable<Element> iterable1 = $this$sortedBy$iv; boolean bool = false; HUD$renderShader$$inlined$sortedBy$1 hUD$renderShader$$inlined$sortedBy$1 = new HUD$renderShader$$inlined$sortedBy$1(); Iterable $this$forEach$iv = CollectionsKt.sortedWith(iterable1, hUD$renderShader$$inlined$sortedBy$1); int $i$f$forEach = 0;
/* 276 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); Element it = (Element)element$iv; int $i$a$-forEach-HUD$renderShader$2 = 0;
/*     */       GL11.glPushMatrix(); }
/*     */      }
/*     */ 
/*     */   
/*     */   public final void update() {
/*     */     for (Element element : this.elements$1)
/*     */       element.updateElement(); 
/*     */   }
/*     */   
/*     */   public final void handleMouseClick(int mouseX, int mouseY, int button) {
/*     */     for (Element element : this.elements$1)
/*     */       element.handleMouseClick((mouseX / element.getScale()) - element.getRenderX(), (mouseY / element.getScale()) - element.getRenderY(), button); 
/*     */     if (button == 0)
/*     */       for (Element element : CollectionsKt.reversed(this.elements$1)) {
/*     */         if (!element.isInBorder((mouseX / element.getScale()) - element.getRenderX(), (mouseY / element.getScale()) - element.getRenderY()))
/*     */           continue; 
/*     */         element.setDrag(true);
/*     */         this.elements$1.remove(element);
/*     */         this.elements$1.add(element);
/*     */       }  
/*     */   }
/*     */   
/*     */   public final void handleMouseReleased() {
/*     */     for (Element element : this.elements$1)
/*     */       element.setDrag(false); 
/*     */   }
/*     */   
/*     */   public final void handleMouseMove(int mouseX, int mouseY) {
/*     */     if (!MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen()))
/*     */       return; 
/*     */     Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc");
/*     */     IScaledResolution scaledResolution = MinecraftInstance.classProvider.createScaledResolution(MinecraftInstance.mc);
/*     */     for (Element element : this.elements$1) {
/*     */       float scaledX = mouseX / element.getScale();
/*     */       float scaledY = mouseY / element.getScale();
/*     */       float prevMouseX = element.getPrevMouseX();
/*     */       float prevMouseY = element.getPrevMouseY();
/*     */       element.setPrevMouseX(scaledX);
/*     */       element.setPrevMouseY(scaledY);
/*     */       if (element.getDrag()) {
/*     */         float moveX = scaledX - prevMouseX;
/*     */         float moveY = scaledY - prevMouseY;
/*     */         if (moveX == 0.0F && moveY == 0.0F)
/*     */           continue; 
/*     */         if (element.getBorder() != null) {
/*     */           Border border = element.getBorder();
/*     */           float f1 = border.getX(), f2 = border.getX2();
/*     */           boolean bool1 = false;
/*     */           float minX = Math.min(f1, f2) + true;
/*     */           f2 = border.getY();
/*     */           float f3 = border.getY2();
/*     */           boolean bool2 = false;
/*     */           float minY = Math.min(f2, f3) + true;
/*     */           f3 = border.getX();
/*     */           float f4 = border.getX2();
/*     */           boolean bool3 = false;
/*     */           float maxX = Math.max(f3, f4) - true;
/*     */           f4 = border.getY();
/*     */           float f5 = border.getY2();
/*     */           boolean bool4 = false;
/*     */           float maxY = Math.max(f4, f5) - true;
/*     */           float width = scaledResolution.getScaledWidth() / element.getScale();
/*     */           float height = scaledResolution.getScaledHeight() / element.getScale();
/*     */           if ((element.getRenderX() + minX + moveX >= 0.0D || moveX > false) && (element.getRenderX() + maxX + moveX <= width || moveX < false))
/*     */             element.setRenderX(moveX); 
/*     */           if ((element.getRenderY() + minY + moveY >= 0.0D || moveY > false) && (element.getRenderY() + maxY + moveY <= height || moveY < false))
/*     */             element.setRenderY(moveY); 
/*     */           continue;
/*     */         } 
/*     */         element.getBorder();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void handleKey(char c, int keyCode) {
/*     */     for (Element element : this.elements$1)
/*     */       element.handleKey(c, keyCode); 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final HUD addElement(@NotNull Element element) {
/*     */     Intrinsics.checkParameterIsNotNull(element, "element");
/*     */     this.elements$1.add(element);
/*     */     element.updateElement();
/*     */     return this;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final HUD removeElement(@NotNull Element element) {
/*     */     Intrinsics.checkParameterIsNotNull(element, "element");
/*     */     element.destroyElement();
/*     */     this.elements$1.remove(element);
/*     */     return this;
/*     */   }
/*     */   
/*     */   public final void clearElements() {
/*     */     for (Element element : this.elements$1)
/*     */       element.destroyElement(); 
/*     */     this.elements$1.clear();
/*     */   }
/*     */   
/*     */   public final boolean addNotification(@NotNull Notification notification) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'notification'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield elements$1 : Ljava/util/List;
/*     */     //   11: checkcast java/lang/Iterable
/*     */     //   14: astore_2
/*     */     //   15: iconst_0
/*     */     //   16: istore_3
/*     */     //   17: aload_2
/*     */     //   18: instanceof java/util/Collection
/*     */     //   21: ifeq -> 40
/*     */     //   24: aload_2
/*     */     //   25: checkcast java/util/Collection
/*     */     //   28: invokeinterface isEmpty : ()Z
/*     */     //   33: ifeq -> 40
/*     */     //   36: iconst_0
/*     */     //   37: goto -> 90
/*     */     //   40: aload_2
/*     */     //   41: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   46: astore #4
/*     */     //   48: aload #4
/*     */     //   50: invokeinterface hasNext : ()Z
/*     */     //   55: ifeq -> 89
/*     */     //   58: aload #4
/*     */     //   60: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   65: astore #5
/*     */     //   67: aload #5
/*     */     //   69: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*     */     //   72: astore #6
/*     */     //   74: iconst_0
/*     */     //   75: istore #7
/*     */     //   77: aload #6
/*     */     //   79: instanceof net/ccbluex/liquidbounce/ui/client/hud/element/elements/Notifications
/*     */     //   82: ifeq -> 48
/*     */     //   85: iconst_1
/*     */     //   86: goto -> 90
/*     */     //   89: iconst_0
/*     */     //   90: ifeq -> 110
/*     */     //   93: aload_0
/*     */     //   94: getfield notifications : Ljava/util/List;
/*     */     //   97: aload_1
/*     */     //   98: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   103: ifeq -> 110
/*     */     //   106: iconst_1
/*     */     //   107: goto -> 111
/*     */     //   110: iconst_0
/*     */     //   111: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #264	-> 7
/*     */     //   #278	-> 17
/*     */     //   #279	-> 40
/*     */     //   #264	-> 77
/*     */     //   #280	-> 89
/*     */     //   #264	-> 93
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   74	8	6	it	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*     */     //   77	5	7	$i$a$-any-HUD$addNotification$1	I
/*     */     //   67	22	5	element$iv	Ljava/lang/Object;
/*     */     //   15	75	2	$this$any$iv	Ljava/lang/Iterable;
/*     */     //   17	73	3	$i$f$any	I
/*     */     //   0	112	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   0	112	1	notification	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;
/*     */   }
/*     */   
/*     */   public final boolean removeNotification(@NotNull Notification notification) {
/*     */     Intrinsics.checkParameterIsNotNull(notification, "notification");
/*     */     return this.notifications.remove(notification);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final HUD createDefault() {
/*     */     return Companion.createDefault();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\HUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */