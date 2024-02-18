/*    */ package net.ccbluex.liquidbounce.script.api.global;
/*    */ import jdk.nashorn.api.scripting.JSObject;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\007\032\0020\b2\006\020\005\032\0020\006H\007J\020\020\t\032\0020\n2\006\020\005\032\0020\006H\007J\020\020\013\032\0020\f2\006\020\005\032\0020\006H\007J\020\020\r\032\0020\0162\006\020\005\032\0020\006H\007J\020\020\017\032\0020\0202\006\020\005\032\0020\006H\007¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/script/api/global/Setting;", "", "()V", "block", "Lnet/ccbluex/liquidbounce/value/BlockValue;", "settingInfo", "Ljdk/nashorn/api/scripting/JSObject;", "boolean", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "float", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "integer", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "list", "Lnet/ccbluex/liquidbounce/value/ListValue;", "text", "Lnet/ccbluex/liquidbounce/value/TextValue;", "XSJClient"})
/*    */ public final class Setting {
/*    */   static {
/* 10 */     Setting setting = new Setting();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final Setting INSTANCE;
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final BoolValue boolean(@NotNull JSObject settingInfo) {
/* 19 */     Intrinsics.checkParameterIsNotNull(settingInfo, "settingInfo"); if (settingInfo.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String name = (String)settingInfo.getMember("name");
/* 20 */     if (settingInfo.getMember("default") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");  boolean default = ((Boolean)settingInfo.getMember("default")).booleanValue();
/*    */     
/* 22 */     return new BoolValue(name, default);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final IntegerValue integer(@NotNull JSObject settingInfo) {
/* 32 */     Intrinsics.checkParameterIsNotNull(settingInfo, "settingInfo"); if (settingInfo.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String name = (String)settingInfo.getMember("name");
/* 33 */     if (settingInfo.getMember("default") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  int default = ((Number)settingInfo.getMember("default")).intValue();
/* 34 */     if (settingInfo.getMember("min") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  int min = ((Number)settingInfo.getMember("min")).intValue();
/* 35 */     if (settingInfo.getMember("max") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  int max = ((Number)settingInfo.getMember("max")).intValue();
/*    */     
/* 37 */     return new IntegerValue(name, default, min, max);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final FloatValue float(@NotNull JSObject settingInfo) {
/* 47 */     Intrinsics.checkParameterIsNotNull(settingInfo, "settingInfo"); if (settingInfo.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String name = (String)settingInfo.getMember("name");
/* 48 */     if (settingInfo.getMember("default") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  float default = ((Number)settingInfo.getMember("default")).floatValue();
/* 49 */     if (settingInfo.getMember("min") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  float min = ((Number)settingInfo.getMember("min")).floatValue();
/* 50 */     if (settingInfo.getMember("max") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  float max = ((Number)settingInfo.getMember("max")).floatValue();
/*    */     
/* 52 */     return new FloatValue(name, default, min, max);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final TextValue text(@NotNull JSObject settingInfo) {
/* 62 */     Intrinsics.checkParameterIsNotNull(settingInfo, "settingInfo"); if (settingInfo.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String name = (String)settingInfo.getMember("name");
/* 63 */     if (settingInfo.getMember("default") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String default = (String)settingInfo.getMember("default");
/*    */     
/* 65 */     return new TextValue(name, default);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final BlockValue block(@NotNull JSObject settingInfo) {
/* 75 */     Intrinsics.checkParameterIsNotNull(settingInfo, "settingInfo"); if (settingInfo.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String name = (String)settingInfo.getMember("name");
/* 76 */     if (settingInfo.getMember("default") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");  int default = ((Number)settingInfo.getMember("default")).intValue();
/*    */     
/* 78 */     return new BlockValue(name, default);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @JvmStatic
/*    */   @NotNull
/*    */   public static final ListValue list(@NotNull JSObject settingInfo) {
/* 89 */     Intrinsics.checkParameterIsNotNull(settingInfo, "settingInfo"); if (settingInfo.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String name = (String)settingInfo.getMember("name");
/* 90 */     if (ScriptUtils.convert(settingInfo.getMember("values"), String[].class) == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");  String[] values = (String[])ScriptUtils.convert(settingInfo.getMember("values"), String[].class);
/* 91 */     if (settingInfo.getMember("default") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String default = (String)settingInfo.getMember("default");
/*    */     
/* 93 */     return new ListValue(name, values, default);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\api\global\Setting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */