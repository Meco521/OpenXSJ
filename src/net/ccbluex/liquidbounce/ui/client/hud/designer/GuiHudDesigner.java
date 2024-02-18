/*    */ package net.ccbluex.liquidbounce.ui.client.hud.designer;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\b\n\002\b\002\n\002\020\007\n\002\b\003\n\002\020\f\n\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J \020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\022\032\0020\023H\026J\b\020\024\032\0020\016H\026J\030\020\025\032\0020\0162\006\020\026\032\0020\0272\006\020\030\032\0020\020H\026J \020\031\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\032\032\0020\020H\026J \020\033\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\034\032\0020\020H\026J\b\020\035\032\0020\016H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\034\020\007\032\004\030\0010\bX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\f¨\006\036"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;", "Lnet/ccbluex/liquidbounce/api/util/WrappedGuiScreen;", "()V", "buttonAction", "", "editorPanel", "Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;", "selectedElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "getSelectedElement", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "setSelectedElement", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;)V", "drawScreen", "", "mouseX", "", "mouseY", "partialTicks", "", "initGui", "keyTyped", "typedChar", "", "keyCode", "mouseClicked", "mouseButton", "mouseReleased", "state", "onGuiClosed", "XSJClient"})
/*    */ public final class GuiHudDesigner extends WrappedGuiScreen {
/*    */   @Nullable
/*    */   private Element selectedElement;
/* 12 */   private EditorPanel editorPanel = new EditorPanel(this, 2, 2); private boolean buttonAction; @Nullable
/*    */   public final Element getSelectedElement() {
/* 14 */     return this.selectedElement; } public final void setSelectedElement(@Nullable Element <set-?>) { this.selectedElement = <set-?>; }
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 18 */     Keyboard.enableRepeatEvents(true);
/* 19 */     this.editorPanel = new EditorPanel(this, getRepresentedScreen().getWidth() / 2, getRepresentedScreen().getHeight() / 2);
/*    */   }
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 23 */     Retreat.INSTANCE.getHud().render(true);
/* 24 */     Retreat.INSTANCE.getHud().handleMouseMove(mouseX, mouseY);
/*    */     
/* 26 */     if (!CollectionsKt.contains(Retreat.INSTANCE.getHud().getElements(), this.selectedElement)) {
/* 27 */       this.selectedElement = (Element)null;
/*    */     }
/* 29 */     int wheel = Mouse.getDWheel();
/*    */     
/* 31 */     this.editorPanel.drawPanel(mouseX, mouseY, wheel);
/*    */     
/* 33 */     if (wheel != 0) {
/* 34 */       for (Element element : Retreat.INSTANCE.getHud().getElements()) {
/* 35 */         if (element.isInBorder((mouseX / element.getScale()) - element.getRenderX(), (
/* 36 */             mouseY / element.getScale()) - element.getRenderY())) {
/* 37 */           element.setScale(element.getScale() + ((wheel > 0) ? 0.05F : -0.05F));
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual getRepresentedScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*    */     //   4: iload_1
/*    */     //   5: iload_2
/*    */     //   6: iload_3
/*    */     //   7: invokeinterface superMouseClicked : (III)V
/*    */     //   12: aload_0
/*    */     //   13: getfield buttonAction : Z
/*    */     //   16: ifeq -> 25
/*    */     //   19: aload_0
/*    */     //   20: iconst_0
/*    */     //   21: putfield buttonAction : Z
/*    */     //   24: return
/*    */     //   25: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   28: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   31: iload_1
/*    */     //   32: iload_2
/*    */     //   33: iload_3
/*    */     //   34: invokevirtual handleMouseClick : (III)V
/*    */     //   37: iload_1
/*    */     //   38: aload_0
/*    */     //   39: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   42: invokevirtual getX : ()I
/*    */     //   45: if_icmplt -> 126
/*    */     //   48: iload_1
/*    */     //   49: aload_0
/*    */     //   50: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   53: invokevirtual getX : ()I
/*    */     //   56: aload_0
/*    */     //   57: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   60: invokevirtual getWidth : ()I
/*    */     //   63: iadd
/*    */     //   64: if_icmpgt -> 126
/*    */     //   67: iload_2
/*    */     //   68: aload_0
/*    */     //   69: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   72: invokevirtual getY : ()I
/*    */     //   75: if_icmplt -> 126
/*    */     //   78: iload_2
/*    */     //   79: aload_0
/*    */     //   80: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   83: invokevirtual getY : ()I
/*    */     //   86: aload_0
/*    */     //   87: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   90: invokevirtual getRealHeight : ()I
/*    */     //   93: istore #4
/*    */     //   95: sipush #200
/*    */     //   98: istore #5
/*    */     //   100: istore #8
/*    */     //   102: istore #7
/*    */     //   104: iconst_0
/*    */     //   105: istore #6
/*    */     //   107: iload #4
/*    */     //   109: iload #5
/*    */     //   111: invokestatic min : (II)I
/*    */     //   114: istore #9
/*    */     //   116: iload #7
/*    */     //   118: iload #8
/*    */     //   120: iload #9
/*    */     //   122: iadd
/*    */     //   123: if_icmple -> 142
/*    */     //   126: aload_0
/*    */     //   127: aconst_null
/*    */     //   128: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*    */     //   131: putfield selectedElement : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*    */     //   134: aload_0
/*    */     //   135: getfield editorPanel : Lnet/ccbluex/liquidbounce/ui/client/hud/designer/EditorPanel;
/*    */     //   138: iconst_0
/*    */     //   139: invokevirtual setCreate : (Z)V
/*    */     //   142: iload_3
/*    */     //   143: ifne -> 234
/*    */     //   146: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*    */     //   149: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*    */     //   152: invokevirtual getElements : ()Ljava/util/List;
/*    */     //   155: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   160: astore #5
/*    */     //   162: aload #5
/*    */     //   164: invokeinterface hasNext : ()Z
/*    */     //   169: ifeq -> 234
/*    */     //   172: aload #5
/*    */     //   174: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   179: checkcast net/ccbluex/liquidbounce/ui/client/hud/element/Element
/*    */     //   182: astore #4
/*    */     //   184: aload #4
/*    */     //   186: iload_1
/*    */     //   187: i2f
/*    */     //   188: aload #4
/*    */     //   190: invokevirtual getScale : ()F
/*    */     //   193: fdiv
/*    */     //   194: f2d
/*    */     //   195: aload #4
/*    */     //   197: invokevirtual getRenderX : ()D
/*    */     //   200: dsub
/*    */     //   201: iload_2
/*    */     //   202: i2f
/*    */     //   203: aload #4
/*    */     //   205: invokevirtual getScale : ()F
/*    */     //   208: fdiv
/*    */     //   209: f2d
/*    */     //   210: aload #4
/*    */     //   212: invokevirtual getRenderY : ()D
/*    */     //   215: dsub
/*    */     //   216: invokevirtual isInBorder : (DD)Z
/*    */     //   219: ifeq -> 231
/*    */     //   222: aload_0
/*    */     //   223: aload #4
/*    */     //   225: putfield selectedElement : Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*    */     //   228: goto -> 234
/*    */     //   231: goto -> 162
/*    */     //   234: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #45	-> 0
/*    */     //   #47	-> 12
/*    */     //   #48	-> 19
/*    */     //   #49	-> 24
/*    */     //   #52	-> 25
/*    */     //   #54	-> 37
/*    */     //   #55	-> 37
/*    */     //   #54	-> 49
/*    */     //   #55	-> 79
/*    */     //   #55	-> 122
/*    */     //   #56	-> 126
/*    */     //   #57	-> 134
/*    */     //   #60	-> 142
/*    */     //   #61	-> 146
/*    */     //   #62	-> 184
/*    */     //   #63	-> 222
/*    */     //   #64	-> 228
/*    */     //   #61	-> 231
/*    */     //   #68	-> 234
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   184	47	4	element	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;
/*    */     //   0	235	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/designer/GuiHudDesigner;
/*    */     //   0	235	1	mouseX	I
/*    */     //   0	235	2	mouseY	I
/*    */     //   0	235	3	mouseButton	I
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseReleased(int mouseX, int mouseY, int state) {
/* 71 */     getRepresentedScreen().superMouseReleased(mouseX, mouseY, state);
/*    */     
/* 73 */     Retreat.INSTANCE.getHud().handleMouseReleased();
/*    */   }
/*    */   
/*    */   public void onGuiClosed() {
/* 77 */     Keyboard.enableRepeatEvents(false);
/* 78 */     Retreat.INSTANCE.getFileManager().saveConfig((Retreat.INSTANCE.getFileManager()).hudConfig);
/*    */     
/* 80 */     super.onGuiClosed();
/*    */   }
/*    */   
/*    */   public void keyTyped(char typedChar, int keyCode) {
/* 84 */     switch (keyCode) { case 211:
/* 85 */         if (211 == keyCode && this.selectedElement != null) {
/* 86 */           if (this.selectedElement == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getHud().removeElement(this.selectedElement);
/*    */         }  break;
/*    */       case 1:
/* 89 */         this.selectedElement = (Element)null;
/* 90 */         this.editorPanel.setCreate(false);
/*    */         break;
/*    */       default:
/* 93 */         Retreat.INSTANCE.getHud().handleKey(typedChar, keyCode);
/*    */         break; }
/*    */     
/* 96 */     super.keyTyped(typedChar, keyCode);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\designer\GuiHudDesigner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */