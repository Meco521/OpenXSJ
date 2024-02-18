/*    */ package net.ccbluex.liquidbounce.value;
/*    */ 
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\016\n\002\b\003\n\002\020\013\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\t\b&\030\000*\004\b\000\020\0012\0020\002B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0028\000¢\006\002\020\006J\025\020\024\032\0020\0252\006\020\005\032\0028\000H\026¢\006\002\020\022J\032\020\007\032\b\022\004\022\0028\0000\0002\f\020\026\032\b\022\004\022\0020\b0\fJ\020\020\027\032\0020\0252\006\020\030\032\0020\031H&J\013\020\032\032\0028\000¢\006\002\020\020J\035\020\033\032\0020\0252\006\020\034\032\0028\0002\006\020\035\032\0028\000H\024¢\006\002\020\036J\035\020\037\032\0020\0252\006\020\034\032\0028\0002\006\020\035\032\0028\000H\024¢\006\002\020\036J\023\020 \032\0020\0252\006\020\035\032\0028\000¢\006\002\020\022J\n\020!\032\004\030\0010\031H&R\021\020\007\032\0020\b8F¢\006\006\032\004\b\t\020\nR\024\020\013\032\b\022\004\022\0020\b0\fX\016¢\006\002\n\000R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\r\020\016R\034\020\005\032\0028\000X\016¢\006\020\n\002\020\023\032\004\b\017\020\020\"\004\b\021\020\022¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/value/Value;", "T", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "displayable", "", "getDisplayable", "()Z", "displayableFunc", "Lkotlin/Function0;", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "changeValue", "", "func", "fromJson", "element", "Lcom/google/gson/JsonElement;", "get", "onChange", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onChanged", "set", "toJson", "XSJClient"})
/*    */ public abstract class Value<T> {
/*    */   private Function0<Boolean> displayableFunc;
/*    */   
/*    */   @NotNull
/* 12 */   public final String getName() { return this.name; } @NotNull private final String name; private T value; public final T getValue() { return this.value; } public final void setValue(Object <set-?>) { this.value = (T)<set-?>; } public Value(@NotNull String name, Object value) { this.name = name; this.value = (T)value;
/* 13 */     this.displayableFunc = Value$displayableFunc$1.INSTANCE; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\n\n\000\n\002\020\013\n\002\b\002\020\000\032\0020\001\"\004\b\000\020\002H\n¢\006\002\b\003"}, d2 = {"<anonymous>", "", "T", "invoke"}) static final class Value$displayableFunc$1 extends Lambda implements Function0<Boolean> { public static final Value$displayableFunc$1 INSTANCE = new Value$displayableFunc$1(); public final boolean invoke() { return true; } Value$displayableFunc$1() { super(0); } }
/*    */   @NotNull
/*    */   public final Value<T> displayable(@NotNull Function0<Boolean> func) {
/* 16 */     Intrinsics.checkParameterIsNotNull(func, "func"); this.displayableFunc = func;
/* 17 */     return this;
/*    */   }
/*    */   
/*    */   public final boolean getDisplayable() {
/* 21 */     return ((Boolean)this.displayableFunc.invoke()).booleanValue();
/*    */   }
/*    */   public final void set(Object newValue) {
/* 24 */     if (Intrinsics.areEqual(newValue, this.value)) {
/*    */       return;
/*    */     }
/* 27 */     Object oldValue = get();
/*    */     
/*    */     try {
/* 30 */       onChange((T)oldValue, (T)newValue);
/* 31 */       changeValue((T)newValue);
/* 32 */       onChanged((T)oldValue, (T)newValue);
/* 33 */       Retreat.INSTANCE.getFileManager().saveConfig((Retreat.INSTANCE.getFileManager()).valuesConfig);
/* 34 */     } catch (Exception e) {
/* 35 */       ClientUtils.getLogger().error("[ValueSystem (" + this.name + ")]: " + e.getClass().getName() + " (" + e.getMessage() + ") [" + oldValue + " >> " + newValue + ']');
/*    */     } 
/*    */   }
/*    */   public final T get() {
/* 39 */     return this.value;
/*    */   }
/*    */   public void changeValue(Object value) {
/* 42 */     this.value = (T)value;
/*    */   }
/*    */   
/*    */   protected void onChange(Object oldValue, Object newValue) {}
/*    */   
/*    */   protected void onChanged(Object oldValue, Object newValue) {}
/*    */   
/*    */   @Nullable
/*    */   public abstract JsonElement toJson();
/*    */   
/*    */   public abstract void fromJson(@NotNull JsonElement paramJsonElement);
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\value\Value.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */