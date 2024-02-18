/*     */ package net.ccbluex.liquidbounce.value;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\020\007\n\000\n\002\020\016\n\002\b\b\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\004\n\000\n\002\030\002\n\000\b\026\030\0002\b\022\004\022\0020\0020\001B)\022\006\020\003\032\0020\004\022\006\020\005\032\0020\002\022\b\b\002\020\006\032\0020\002\022\b\b\002\020\007\032\0020\002¢\006\002\020\bJ\020\020\f\032\0020\r2\006\020\016\032\0020\017H\026J\016\020\020\032\0020\r2\006\020\021\032\0020\022J\b\020\023\032\0020\024H\026R\021\020\007\032\0020\002¢\006\b\n\000\032\004\b\t\020\nR\021\020\006\032\0020\002¢\006\b\n\000\032\004\b\013\020\n¨\006\025"}, d2 = {"Lnet/ccbluex/liquidbounce/value/FloatValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "", "value", "minimum", "maximum", "(Ljava/lang/String;FFF)V", "getMaximum", "()F", "getMinimum", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "set", "newValue", "", "toJson", "Lcom/google/gson/JsonPrimitive;", "XSJClient"})
/*     */ public class FloatValue
/*     */   extends Value<Float>
/*     */ {
/*     */   private final float minimum;
/*     */   private final float maximum;
/*     */   
/*     */   public final float getMinimum() {
/*  89 */     return this.minimum; } public final float getMaximum() { return this.maximum; } public FloatValue(@NotNull String name, float value, float minimum, float maximum) {
/*  90 */     super(name, Float.valueOf(value)); this.minimum = minimum; this.maximum = maximum;
/*     */   }
/*     */   public final void set(@NotNull Number newValue) {
/*  93 */     Intrinsics.checkParameterIsNotNull(newValue, "newValue"); set(Float.valueOf(newValue.floatValue()));
/*     */   } @NotNull
/*     */   public JsonPrimitive toJson() {
/*  96 */     return new JsonPrimitive(getValue());
/*     */   }
/*     */   public void fromJson(@NotNull JsonElement element) {
/*  99 */     Intrinsics.checkParameterIsNotNull(element, "element"); if (element.isJsonPrimitive())
/* 100 */       setValue(Float.valueOf(element.getAsFloat())); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\value\FloatValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */