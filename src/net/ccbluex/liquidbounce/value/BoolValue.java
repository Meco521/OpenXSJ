/*    */ package net.ccbluex.liquidbounce.value;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonPrimitive;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0000\n\002\030\002\n\002\030\002\n\002\020\013\n\000\n\002\020\016\n\002\b\003\n\002\020\007\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\026\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\002¢\006\002\020\006J\020\020\r\032\0020\0162\006\020\017\032\0020\020H\026J\b\020\021\032\0020\022H\026R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\f¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/value/BoolValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "", "name", "", "value", "(Ljava/lang/String;Z)V", "tempX", "", "getTempX", "()F", "setTempX", "(F)V", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "toJson", "Lcom/google/gson/JsonPrimitive;", "XSJClient"})
/*    */ public class BoolValue
/*    */   extends Value<Boolean>
/*    */ {
/*    */   private float tempX;
/*    */   
/*    */   public BoolValue(@NotNull String name, boolean value) {
/* 55 */     super(name, Boolean.valueOf(value));
/* 56 */     this.tempX = 35.0F; } public final float getTempX() { return this.tempX; } public final void setTempX(float <set-?>) { this.tempX = <set-?>; } @NotNull
/*    */   public JsonPrimitive toJson() {
/* 58 */     return new JsonPrimitive(getValue());
/*    */   }
/*    */   public void fromJson(@NotNull JsonElement element) {
/* 61 */     Intrinsics.checkParameterIsNotNull(element, "element"); if (element.isJsonPrimitive())
/* 62 */       setValue(Boolean.valueOf((element.getAsBoolean() || StringsKt.equals(element.getAsString(), "true", true)))); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\value\BoolValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */