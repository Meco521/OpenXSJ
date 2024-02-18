/*    */ package net.ccbluex.liquidbounce.value;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonPrimitive;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\020\b\n\000\n\002\020\016\n\002\b\b\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\004\n\000\n\002\030\002\n\000\b\026\030\0002\b\022\004\022\0020\0020\001B)\022\006\020\003\032\0020\004\022\006\020\005\032\0020\002\022\b\b\002\020\006\032\0020\002\022\b\b\002\020\007\032\0020\002¢\006\002\020\bJ\020\020\f\032\0020\r2\006\020\016\032\0020\017H\026J\016\020\020\032\0020\r2\006\020\021\032\0020\022J\b\020\023\032\0020\024H\026R\021\020\007\032\0020\002¢\006\b\n\000\032\004\b\t\020\nR\021\020\006\032\0020\002¢\006\b\n\000\032\004\b\013\020\n¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/value/IntegerValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "", "value", "minimum", "maximum", "(Ljava/lang/String;III)V", "getMaximum", "()I", "getMinimum", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "set", "newValue", "", "toJson", "Lcom/google/gson/JsonPrimitive;", "XSJClient"})
/*    */ public class IntegerValue
/*    */   extends Value<Integer>
/*    */ {
/*    */   private final int minimum;
/*    */   private final int maximum;
/*    */   
/*    */   public final int getMinimum() {
/* 70 */     return this.minimum; } public final int getMaximum() { return this.maximum; } public IntegerValue(@NotNull String name, int value, int minimum, int maximum) {
/* 71 */     super(name, Integer.valueOf(value)); this.minimum = minimum; this.maximum = maximum;
/*    */   }
/*    */   public final void set(@NotNull Number newValue) {
/* 74 */     Intrinsics.checkParameterIsNotNull(newValue, "newValue"); set(Integer.valueOf(newValue.intValue()));
/*    */   } @NotNull
/*    */   public JsonPrimitive toJson() {
/* 77 */     return new JsonPrimitive(getValue());
/*    */   }
/*    */   public void fromJson(@NotNull JsonElement element) {
/* 80 */     Intrinsics.checkParameterIsNotNull(element, "element"); if (element.isJsonPrimitive())
/* 81 */       setValue(Integer.valueOf(element.getAsInt())); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\value\IntegerValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */