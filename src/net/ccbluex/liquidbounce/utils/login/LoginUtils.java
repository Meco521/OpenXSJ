/*    */ package net.ccbluex.liquidbounce.utils.login;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.Event;
/*    */ import net.ccbluex.liquidbounce.event.SessionEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\002\n\002\b\004\bÆ\002\030\0002\0020\001:\001\fB\007\b\002¢\006\002\020\002J\034\020\003\032\0020\0042\b\020\005\032\004\030\0010\0062\b\020\007\032\004\030\0010\006H\007J\022\020\b\032\0020\t2\b\020\005\032\004\030\0010\006H\007J\020\020\n\032\0020\0042\006\020\013\032\0020\006H\007¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/login/LoginUtils;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "login", "Lnet/ccbluex/liquidbounce/utils/login/LoginUtils$LoginResult;", "username", "", "password", "loginCracked", "", "loginSessionId", "sessionId", "LoginResult", "XSJClient"})
/*    */ public final class LoginUtils extends MinecraftInstance {
/* 16 */   static { LoginUtils loginUtils = new LoginUtils(); } public static final LoginUtils INSTANCE; @JvmStatic
/*    */   @NotNull
/*    */   public static final LoginResult login(@Nullable String username, @Nullable String password) {
/*    */     LoginResult loginResult;
/* 20 */     if ((new YggdrasilAuthenticationService(Proxy.NO_PROXY, "")).createUserAuthentication(Agent.MINECRAFT) == null) throw new TypeCastException("null cannot be cast to non-null type com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication");  YggdrasilUserAuthentication userAuthentication = (YggdrasilUserAuthentication)(new YggdrasilAuthenticationService(Proxy.NO_PROXY, "")).createUserAuthentication(Agent.MINECRAFT);
/*    */     
/* 22 */     userAuthentication.setUsername(username);
/* 23 */     userAuthentication.setPassword(password);
/*    */     
/*    */     try {
/* 26 */       userAuthentication.logIn();
/* 27 */       Intrinsics.checkExpressionValueIsNotNull(userAuthentication.getSelectedProfile(), "userAuthentication.selectedProfile"); Intrinsics.checkExpressionValueIsNotNull(userAuthentication.getSelectedProfile().getName(), "userAuthentication.selectedProfile.name");
/* 28 */       Intrinsics.checkExpressionValueIsNotNull(userAuthentication.getSelectedProfile(), "userAuthentication.selectedProfile"); Intrinsics.checkExpressionValueIsNotNull(userAuthentication.getSelectedProfile().getId().toString(), "userAuthentication.selectedProfile.id.toString()"); Intrinsics.checkExpressionValueIsNotNull(userAuthentication.getAuthenticatedToken(), "userAuthentication.authenticatedToken"); MinecraftInstance.mc.setSession(MinecraftInstance.classProvider.createSession(userAuthentication.getSelectedProfile().getName(), userAuthentication.getSelectedProfile().getId().toString(), userAuthentication.getAuthenticatedToken(), "mojang"));
/* 29 */       Retreat.INSTANCE.getEventManager().callEvent((Event)new SessionEvent());
/* 30 */       loginResult = LoginResult.LOGGED;
/* 31 */     } catch (AuthenticationUnavailableException exception) {
/* 32 */       loginResult = LoginResult.NO_CONTACT;
/* 33 */     } catch (AuthenticationException exception) {
/* 34 */       if (exception.getMessage() == null) Intrinsics.throwNpe();  String message = exception.getMessage();
/* 35 */       loginResult = 
/* 36 */         StringsKt.contains(message, "invalid username or password.", true) ? LoginResult.INVALID_ACCOUNT_DATA : (
/* 37 */         StringsKt.contains(message, "account migrated", true) ? LoginResult.MIGRATED : 
/* 38 */         LoginResult.NO_CONTACT);
/*    */     }
/* 40 */     catch (NullPointerException exception) {
/* 41 */       loginResult = LoginResult.WRONG_PASSWORD;
/*    */     } 
/*    */     return loginResult;
/*    */   }
/*    */   
/*    */   @JvmStatic
/* 47 */   public static final void loginCracked(@Nullable String username) { if (username == null) Intrinsics.throwNpe();  MinecraftInstance.mc.setSession(MinecraftInstance.classProvider.createSession(username, UserUtils.INSTANCE.getUUID(username), "-", "legacy"));
/* 48 */     Retreat.INSTANCE.getEventManager().callEvent((Event)new SessionEvent()); } @JvmStatic
/*    */   @NotNull
/*    */   public static final LoginResult loginSessionId(@NotNull String sessionId) {
/*    */     String str1;
/*    */     JsonObject jsonObject1;
/* 53 */     Intrinsics.checkParameterIsNotNull(sessionId, "sessionId"); try {
/* 54 */       Intrinsics.checkExpressionValueIsNotNull(Base64.getDecoder().decode(StringsKt.split$default(sessionId, new String[] { "." }, false, 0, 6, null).get(1)), "Base64.getDecoder().deco…(sessionId.split(\".\")[1])"); byte[] arrayOfByte = Base64.getDecoder().decode(StringsKt.split$default(sessionId, new String[] { "." }, false, 0, 6, null).get(1)); Charset charset = Charsets.UTF_8; boolean bool = false; str1 = new String(arrayOfByte, charset);
/* 55 */     } catch (Exception e) {
/* 56 */       return LoginResult.FAILED_PARSE_TOKEN;
/*    */     } 
/*    */     String decodedSessionData = str1;
/*    */     try {
/* 60 */       Intrinsics.checkExpressionValueIsNotNull((new JsonParser()).parse(decodedSessionData), "JsonParser().parse(decodedSessionData)"); jsonObject1 = (new JsonParser()).parse(decodedSessionData).getAsJsonObject();
/* 61 */     } catch (Exception e) {
/* 62 */       return LoginResult.FAILED_PARSE_TOKEN;
/*    */     }  JsonObject sessionObject = jsonObject1;
/* 64 */     Intrinsics.checkExpressionValueIsNotNull(sessionObject.get("spr"), "sessionObject.get(\"spr\")"); String uuid = sessionObject.get("spr").getAsString();
/* 65 */     Intrinsics.checkExpressionValueIsNotNull(sessionObject.get("yggt"), "sessionObject.get(\"yggt\")"); String accessToken = sessionObject.get("yggt").getAsString();
/*    */     
/* 67 */     Intrinsics.checkExpressionValueIsNotNull(accessToken, "accessToken"); if (!UserUtils.INSTANCE.isValidToken(accessToken)) {
/* 68 */       return LoginResult.INVALID_ACCOUNT_DATA;
/*    */     }
/*    */     
/* 71 */     Intrinsics.checkExpressionValueIsNotNull(uuid, "uuid"); if (UserUtils.INSTANCE.getUsername(uuid) != null) { String username = UserUtils.INSTANCE.getUsername(uuid);
/*    */       
/* 73 */       MinecraftInstance.mc.setSession(MinecraftInstance.classProvider.createSession(username, uuid, accessToken, "mojang"));
/* 74 */       Retreat.INSTANCE.getEventManager().callEvent((Event)new SessionEvent());
/*    */       
/* 76 */       return LoginResult.LOGGED; }
/*    */     
/*    */     UserUtils.INSTANCE.getUsername(uuid);
/*    */     return LoginResult.INVALID_ACCOUNT_DATA;
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\b\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006j\002\b\007j\002\b\b¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/utils/login/LoginUtils$LoginResult;", "", "(Ljava/lang/String;I)V", "WRONG_PASSWORD", "NO_CONTACT", "INVALID_ACCOUNT_DATA", "MIGRATED", "LOGGED", "FAILED_PARSE_TOKEN", "XSJClient"})
/*    */   public enum LoginResult {
/*    */     WRONG_PASSWORD, NO_CONTACT, INVALID_ACCOUNT_DATA, MIGRATED, LOGGED, FAILED_PARSE_TOKEN;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\login\LoginUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */