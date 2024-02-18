/*     */ package net.ccbluex.liquidbounce.value;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import java.util.Arrays;
/*     */ import java.util.function.Predicate;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.JvmField;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
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
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\020\016\n\002\b\002\n\002\020\021\n\002\b\003\n\002\020\007\n\002\b\005\n\002\020\013\n\002\b\b\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\b\026\030\0002\b\022\004\022\0020\0020\001B#\022\006\020\003\032\0020\002\022\f\020\004\032\b\022\004\022\0020\0020\005\022\006\020\006\032\0020\002¢\006\002\020\007J\020\020\027\032\0020\0302\006\020\006\032\0020\002H\026J\023\020\031\032\0020\0172\b\020\032\032\004\030\0010\002H\002J\020\020\033\032\0020\0302\006\020\034\032\0020\035H\026J\b\020\036\032\0020\037H\026R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\022\020\016\032\0020\0178\006@\006X\016¢\006\002\n\000R\022\020\020\032\0020\0178\006@\006X\016¢\006\002\n\000R\032\020\021\032\0020\tX\016¢\006\016\n\000\032\004\b\022\020\013\"\004\b\023\020\rR\031\020\004\032\b\022\004\022\0020\0020\005¢\006\n\n\002\020\026\032\004\b\024\020\025¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/value/ListValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "values", "", "value", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "open", "", "openList", "rotate", "getRotate", "setRotate", "getValues", "()[Ljava/lang/String;", "[Ljava/lang/String;", "changeValue", "", "contains", "string", "fromJson", "element", "Lcom/google/gson/JsonElement;", "toJson", "Lcom/google/gson/JsonPrimitive;", "XSJClient"})
/*     */ public class ListValue
/*     */   extends Value<String>
/*     */ {
/*     */   private float height;
/*     */   private float rotate;
/*     */   @JvmField
/*     */   public boolean open;
/*     */   @JvmField
/*     */   public boolean openList;
/*     */   @NotNull
/*     */   private final String[] values;
/*     */   
/*     */   @NotNull
/*     */   public final String[] getValues() {
/* 145 */     return this.values; } public ListValue(@NotNull String name, @NotNull String[] values, @NotNull String value) { super(name, value); this.values = values;
/* 146 */     this.height = 15.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     setValue(value); }
/*     */    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "s", "", "test"})
/*     */   static final class ListValue$contains$1<T> implements Predicate<String> {
/*     */     ListValue$contains$1(String param1String) {}
/* 158 */     public final boolean test(@NotNull String s) { Intrinsics.checkParameterIsNotNull(s, "s"); return StringsKt.equals(s, this.$string, true); } } public final float getHeight() { return this.height; } public final void setHeight(float <set-?>) { this.height = <set-?>; } public final boolean contains(@Nullable String string) { return Arrays.<String>stream(this.values).anyMatch(new ListValue$contains$1(string)); } public final float getRotate() { return this.rotate; } public final void setRotate(float <set-?>) {
/*     */     this.rotate = <set-?>;
/*     */   }
/*     */   public void changeValue(@NotNull String value) {
/* 162 */     Intrinsics.checkParameterIsNotNull(value, "value"); for (String element : this.values) {
/* 163 */       if (StringsKt.equals(element, value, true)) {
/* 164 */         setValue(element);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   } @NotNull
/*     */   public JsonPrimitive toJson() {
/* 170 */     return new JsonPrimitive(getValue());
/*     */   }
/*     */   public void fromJson(@NotNull JsonElement element) {
/* 173 */     Intrinsics.checkParameterIsNotNull(element, "element"); if (element.isJsonPrimitive()) { Intrinsics.checkExpressionValueIsNotNull(element.getAsString(), "element.asString"); changeValue(element.getAsString()); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\value\ListValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */