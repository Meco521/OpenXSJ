/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\r\030\000 \0172\0020\001:\003\017\020\021B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "", "horizontal", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;", "vertical", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;)V", "getHorizontal", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;", "setHorizontal", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;)V", "getVertical", "()Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;", "setVertical", "(Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;)V", "Companion", "Horizontal", "Vertical", "XSJClient"})
/*     */ public final class Side
/*     */ {
/*     */   @NotNull
/*     */   private Horizontal horizontal;
/*     */   @NotNull
/*     */   private Vertical vertical;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   @NotNull
/*     */   public final Horizontal getHorizontal() {
/* 163 */     return this.horizontal; } public final void setHorizontal(@NotNull Horizontal <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.horizontal = <set-?>; } @NotNull public final Vertical getVertical() { return this.vertical; } public final void setVertical(@NotNull Vertical <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.vertical = <set-?>; } public Side(@NotNull Horizontal horizontal, @NotNull Vertical vertical) { this.horizontal = horizontal; this.vertical = vertical; }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\003\032\0020\004¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Companion;", "", "()V", "default", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "XSJClient"})
/*     */   public static final class Companion { private Companion() {}
/*     */     
/*     */     @NotNull
/*     */     public final Side default() {
/* 170 */       return new Side(Side.Horizontal.LEFT, Side.Vertical.UP);
/*     */     } }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\b\b\001\030\000 \n2\b\022\004\022\0020\0000\001:\001\nB\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\t¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;", "", "sideName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSideName", "()Ljava/lang/String;", "LEFT", "MIDDLE", "RIGHT", "Companion", "XSJClient"})
/*     */   public enum Horizontal { LEFT, MIDDLE, RIGHT;
/*     */     
/*     */     @NotNull
/* 177 */     public final String getSideName() { return this.sideName; } Horizontal(String sideName) { this.sideName = sideName; }
/*     */     @NotNull
/*     */     private final String sideName; @JvmStatic
/*     */     @Nullable
/* 181 */     public static final Horizontal getByName(@NotNull String name) { return Companion.getByName(name); } public static final Companion Companion = new Companion(null);
/*     */     @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020\003\032\004\030\0010\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal$Companion;", "", "()V", "getByName", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;", "name", "", "XSJClient"})
/*     */     public static final class Companion {
/*     */       private Companion() {}
/*     */       @JvmStatic
/*     */       @Nullable
/*     */       public final Side.Horizontal getByName(@NotNull String name) {
/*     */         // Byte code:
/*     */         //   0: aload_1
/*     */         //   1: ldc 'name'
/*     */         //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */         //   6: invokestatic values : ()[Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */         //   9: astore_2
/*     */         //   10: iconst_0
/*     */         //   11: istore_3
/*     */         //   12: aload_2
/*     */         //   13: astore #4
/*     */         //   15: iconst_0
/*     */         //   16: istore #5
/*     */         //   18: aload #4
/*     */         //   20: astore #6
/*     */         //   22: aload #6
/*     */         //   24: arraylength
/*     */         //   25: istore #7
/*     */         //   27: iconst_0
/*     */         //   28: istore #8
/*     */         //   30: iload #8
/*     */         //   32: iload #7
/*     */         //   34: if_icmpge -> 74
/*     */         //   37: aload #6
/*     */         //   39: iload #8
/*     */         //   41: aaload
/*     */         //   42: astore #9
/*     */         //   44: aload #9
/*     */         //   46: astore #10
/*     */         //   48: iconst_0
/*     */         //   49: istore #11
/*     */         //   51: aload #10
/*     */         //   53: invokevirtual getSideName : ()Ljava/lang/String;
/*     */         //   56: aload_1
/*     */         //   57: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */         //   60: ifeq -> 68
/*     */         //   63: aload #9
/*     */         //   65: goto -> 75
/*     */         //   68: iinc #8, 1
/*     */         //   71: goto -> 30
/*     */         //   74: aconst_null
/*     */         //   75: areturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #186	-> 6
/*     */         //   #186	-> 51
/*     */         //   #186	-> 60
/*     */         //   #186	-> 75
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   48	12	10	it	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal;
/*     */         //   51	9	11	$i$a$-find-Side$Horizontal$Companion$getByName$1	I
/*     */         //   0	76	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Horizontal$Companion;
/*     */         //   0	76	1	name	Ljava/lang/String;
/*     */       } } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\b\b\001\030\000 \n2\b\022\004\022\0020\0000\001:\001\nB\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\t¨\006\013"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;", "", "sideName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSideName", "()Ljava/lang/String;", "UP", "MIDDLE", "DOWN", "Companion", "XSJClient"})
/*     */   public enum Vertical { UP, MIDDLE, DOWN;
/*     */     
/*     */     @NotNull
/*     */     public final String getSideName() {
/* 195 */       return this.sideName; } Vertical(String sideName) { this.sideName = sideName; }
/*     */     
/*     */     @NotNull
/*     */     private final String sideName;
/* 199 */     public static final Companion Companion = new Companion(null);
/*     */     
/*     */     @JvmStatic
/*     */     @Nullable
/*     */     public static final Vertical getByName(@NotNull String name) {
/*     */       return Companion.getByName(name);
/*     */     }
/*     */     
/*     */     @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020\003\032\004\030\0010\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical$Companion;", "", "()V", "getByName", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;", "name", "", "XSJClient"})
/*     */     public static final class Companion {
/*     */       private Companion() {}
/*     */       
/*     */       @JvmStatic
/*     */       @Nullable
/*     */       public final Side.Vertical getByName(@NotNull String name) {
/*     */         // Byte code:
/*     */         //   0: aload_1
/*     */         //   1: ldc 'name'
/*     */         //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */         //   6: invokestatic values : ()[Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */         //   9: astore_2
/*     */         //   10: iconst_0
/*     */         //   11: istore_3
/*     */         //   12: aload_2
/*     */         //   13: astore #4
/*     */         //   15: iconst_0
/*     */         //   16: istore #5
/*     */         //   18: aload #4
/*     */         //   20: astore #6
/*     */         //   22: aload #6
/*     */         //   24: arraylength
/*     */         //   25: istore #7
/*     */         //   27: iconst_0
/*     */         //   28: istore #8
/*     */         //   30: iload #8
/*     */         //   32: iload #7
/*     */         //   34: if_icmpge -> 74
/*     */         //   37: aload #6
/*     */         //   39: iload #8
/*     */         //   41: aaload
/*     */         //   42: astore #9
/*     */         //   44: aload #9
/*     */         //   46: astore #10
/*     */         //   48: iconst_0
/*     */         //   49: istore #11
/*     */         //   51: aload #10
/*     */         //   53: invokevirtual getSideName : ()Ljava/lang/String;
/*     */         //   56: aload_1
/*     */         //   57: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */         //   60: ifeq -> 68
/*     */         //   63: aload #9
/*     */         //   65: goto -> 75
/*     */         //   68: iinc #8, 1
/*     */         //   71: goto -> 30
/*     */         //   74: aconst_null
/*     */         //   75: areturn
/*     */         // Line number table:
/*     */         //   Java source line number -> byte code offset
/*     */         //   #204	-> 6
/*     */         //   #204	-> 51
/*     */         //   #204	-> 60
/*     */         //   #204	-> 75
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	descriptor
/*     */         //   48	12	10	it	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical;
/*     */         //   51	9	11	$i$a$-find-Side$Vertical$Companion$getByName$1	I
/*     */         //   0	76	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side$Vertical$Companion;
/*     */         //   0	76	1	name	Ljava/lang/String;
/*     */       }
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\Side.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */