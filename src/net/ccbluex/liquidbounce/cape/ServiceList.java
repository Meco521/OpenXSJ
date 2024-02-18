/*    */ package net.ccbluex.liquidbounce.cape;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
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
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\000\n\002\020$\n\002\020\016\n\002\b\003\n\002\030\002\n\000\030\0002\0020\001B\031\022\022\020\002\032\016\022\004\022\0020\004\022\004\022\0020\0040\003¢\006\002\020\005J\022\020\006\032\004\030\0010\0042\006\020\007\032\0020\bH\026R\032\020\002\032\016\022\004\022\0020\004\022\004\022\0020\0040\003X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/cape/ServiceList;", "Lnet/ccbluex/liquidbounce/cape/CapeService;", "users", "", "", "(Ljava/util/Map;)V", "getCape", "uuid", "Ljava/util/UUID;", "XSJClient"})
/*    */ public final class ServiceList
/*    */   implements CapeService
/*    */ {
/*    */   private final Map<String, String> users;
/*    */   
/*    */   public ServiceList(@NotNull Map<String, String> users) {
/* 30 */     this.users = users;
/*    */   }
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public String getCape(@NotNull UUID uuid) {
/* 36 */     Intrinsics.checkParameterIsNotNull(uuid, "uuid"); Intrinsics.checkExpressionValueIsNotNull(uuid.toString(), "uuid.toString()"); return this.users.get(StringsKt.replace$default(uuid.toString(), "-", "", false, 4, null));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\cape\ServiceList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */