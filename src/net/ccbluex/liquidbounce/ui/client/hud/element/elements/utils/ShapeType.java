/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\004\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\002\b\b\b\001\030\000 \0252\b\022\004\022\0020\0000\001:\001\025B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004J(\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\n2\006\020\f\032\0020\n2\006\020\r\032\0020\016H&R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\017j\002\b\020j\002\b\021j\002\b\022j\002\b\023j\002\b\024¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "SOLID_CIRCLE", "CIRCLE", "SOLID_RECT", "RECT", "SOLID_TRIANGLE", "TRIANGLE", "Companion", "XSJClient"})
/*    */ public enum ShapeType
/*    */ {
/*    */   SOLID_CIRCLE, CIRCLE, SOLID_RECT, RECT, SOLID_TRIANGLE, TRIANGLE;
/*    */   @NotNull
/*    */   private final String typeName;
/*    */   public static final Companion Companion = new Companion(null);
/*    */   
/*    */   public abstract void performRendering(float paramFloat1, float paramFloat2, float paramFloat3, @NotNull Color paramColor);
/*    */   
/*    */   @NotNull
/*    */   public final String getTypeName() {
/* 44 */     return this.typeName; } ShapeType(String typeName) { this.typeName = typeName; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\000\bÆ\001\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\tH\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$SOLID_CIRCLE;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "XSJClient"})
/* 45 */   static final class SOLID_CIRCLE extends ShapeType { SOLID_CIRCLE(String $enum_name_or_ordinal$0, int $enum_name_or_ordinal$1) { super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1, "c_solid", null); }
/*    */      public void performRendering(float x, float y, float rad, @NotNull Color col) {
/* 47 */       Intrinsics.checkParameterIsNotNull(col, "col"); RenderUtils.drawFilledCircle((int)x, (int)y, rad, col);
/*    */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\000\bÆ\001\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\tH\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$CIRCLE;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "XSJClient"})
/*    */   static final class CIRCLE extends ShapeType { CIRCLE(String $enum_name_or_ordinal$0, int $enum_name_or_ordinal$1) {
/* 50 */       super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1, "c_outline", null);
/*    */     } public void performRendering(float x, float y, float rad, @NotNull Color col) {
/* 52 */       Intrinsics.checkParameterIsNotNull(col, "col"); RenderUtils.drawCircle3(x, y, rad, 0.5F, 0, 360, col);
/*    */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\000\bÆ\001\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\tH\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$SOLID_RECT;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "XSJClient"})
/*    */   static final class SOLID_RECT extends ShapeType { SOLID_RECT(String $enum_name_or_ordinal$0, int $enum_name_or_ordinal$1) {
/* 55 */       super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1, "r_solid", null);
/*    */     } public void performRendering(float x, float y, float rad, @NotNull Color col) {
/* 57 */       Intrinsics.checkParameterIsNotNull(col, "col"); RenderUtils.drawRect(x - rad / 2.0F, y - rad / 2.0F, x + rad / 2.0F, y + rad / 2.0F, col.getRGB());
/*    */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\000\bÆ\001\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\tH\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$RECT;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "XSJClient"})
/*    */   static final class RECT extends ShapeType { RECT(String $enum_name_or_ordinal$0, int $enum_name_or_ordinal$1) {
/* 60 */       super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1, "r_outline", null);
/*    */     } public void performRendering(float x, float y, float rad, @NotNull Color col) {
/* 62 */       Intrinsics.checkParameterIsNotNull(col, "col"); RenderUtils.drawBorder(x - rad / 2.0F, y - rad / 2.0F, x + rad / 2.0F, y + rad / 2.0F, 0.5F, col.getRGB());
/*    */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\000\bÆ\001\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\tH\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$SOLID_TRIANGLE;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "XSJClient"})
/*    */   static final class SOLID_TRIANGLE extends ShapeType { SOLID_TRIANGLE(String $enum_name_or_ordinal$0, int $enum_name_or_ordinal$1) {
/* 65 */       super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1, "t_solid", null);
/*    */     } public void performRendering(float x, float y, float rad, @NotNull Color col) {
/* 67 */       Intrinsics.checkParameterIsNotNull(col, "col"); RenderUtils.drawTriAngle(x, y, rad, 3.0F, col, true);
/*    */     } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\007\n\002\b\003\n\002\030\002\n\000\bÆ\001\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\tH\026¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$TRIANGLE;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "performRendering", "", "x", "", "y", "rad", "col", "Ljava/awt/Color;", "XSJClient"})
/*    */   static final class TRIANGLE extends ShapeType { TRIANGLE(String $enum_name_or_ordinal$0, int $enum_name_or_ordinal$1) {
/* 70 */       super($enum_name_or_ordinal$0, $enum_name_or_ordinal$1, "t_outline", null);
/*    */     } public void performRendering(float x, float y, float rad, @NotNull Color col) {
/* 72 */       Intrinsics.checkParameterIsNotNull(col, "col"); RenderUtils.drawTriAngle(x, y, rad, 3.0F, col, false);
/*    */     } }
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\004\030\0010\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$Companion;", "", "()V", "getTypeFromName", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;", "name", "", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {}
/*    */     
/*    */     @Nullable
/*    */     public final ShapeType getTypeFromName(@NotNull String name) {
/*    */       // Byte code:
/*    */       //   0: aload_1
/*    */       //   1: ldc 'name'
/*    */       //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */       //   6: invokestatic values : ()[Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;
/*    */       //   9: astore_2
/*    */       //   10: iconst_0
/*    */       //   11: istore_3
/*    */       //   12: aload_2
/*    */       //   13: astore #4
/*    */       //   15: iconst_0
/*    */       //   16: istore #5
/*    */       //   18: aload #4
/*    */       //   20: astore #6
/*    */       //   22: aload #6
/*    */       //   24: arraylength
/*    */       //   25: istore #7
/*    */       //   27: iconst_0
/*    */       //   28: istore #8
/*    */       //   30: iload #8
/*    */       //   32: iload #7
/*    */       //   34: if_icmpge -> 75
/*    */       //   37: aload #6
/*    */       //   39: iload #8
/*    */       //   41: aaload
/*    */       //   42: astore #9
/*    */       //   44: aload #9
/*    */       //   46: astore #10
/*    */       //   48: iconst_0
/*    */       //   49: istore #11
/*    */       //   51: aload #10
/*    */       //   53: invokevirtual getTypeName : ()Ljava/lang/String;
/*    */       //   56: aload_1
/*    */       //   57: iconst_1
/*    */       //   58: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*    */       //   61: ifeq -> 69
/*    */       //   64: aload #9
/*    */       //   66: goto -> 76
/*    */       //   69: iinc #8, 1
/*    */       //   72: goto -> 30
/*    */       //   75: aconst_null
/*    */       //   76: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #79	-> 6
/*    */       //   #79	-> 51
/*    */       //   #79	-> 61
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   48	13	10	it	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType;
/*    */       //   51	10	11	$i$a$-find-ShapeType$Companion$getTypeFromName$1	I
/*    */       //   0	77	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/utils/ShapeType$Companion;
/*    */       //   0	77	1	name	Ljava/lang/String;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\element\\utils\ShapeType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */