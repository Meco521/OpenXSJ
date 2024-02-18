/*    */ package net.ccbluex.liquidbounce.cape;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.UUID;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.StringCompanionObject;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\005\032\0020\0032\006\020\006\032\0020\007H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\b"}, d2 = {"Lnet/ccbluex/liquidbounce/cape/ServiceAPI;", "Lnet/ccbluex/liquidbounce/cape/CapeService;", "baseURL", "", "(Ljava/lang/String;)V", "getCape", "uuid", "Ljava/util/UUID;", "XSJClient"})
/*    */ public final class ServiceAPI
/*    */   implements CapeService
/*    */ {
/*    */   private final String baseURL;
/*    */   
/*    */   public ServiceAPI(@NotNull String baseURL) {
/* 20 */     this.baseURL = baseURL;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getCape(@NotNull UUID uuid) {
/* 26 */     Intrinsics.checkParameterIsNotNull(uuid, "uuid"); StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE; String str = this.baseURL; Object[] arrayOfObject = { uuid }; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(format, *args)"); return String.format(str, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\cape\ServiceAPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */