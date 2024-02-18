/*    */ package net.ccbluex.liquidbounce.features.special;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Listenable;
/*    */ import net.ccbluex.liquidbounce.event.SessionEvent;
/*    */ import net.ccbluex.liquidbounce.ui.client.altmanager.sub.GuiDonatorCape;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.client.methods.CloseableHttpResponse;
/*    */ import org.apache.http.client.methods.HttpPatch;
/*    */ import org.apache.http.entity.StringEntity;
/*    */ import org.apache.http.impl.client.CloseableHttpClient;
/*    */ import org.apache.http.impl.client.HttpClients;
/*    */ import org.apache.http.message.BasicHeader;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\"\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\b\020\004\032\0020\005H\026J\020\020\006\032\0020\0072\006\020\b\032\0020\tH\007¨\006\n"}, d2 = {"Lnet/ccbluex/liquidbounce/features/special/DonatorCape;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "handleEvents", "", "onSession", "", "event", "Lnet/ccbluex/liquidbounce/event/SessionEvent;", "XSJClient"})
/*    */ public final class DonatorCape extends MinecraftInstance implements Listenable {
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*    */   static final class DonatorCape$onSession$1 extends Lambda implements Function0<Unit> {
/*    */     public static final DonatorCape$onSession$1 INSTANCE = new DonatorCape$onSession$1();
/*    */     
/*    */     DonatorCape$onSession$1() {
/*    */       super(0);
/*    */     }
/*    */     
/*    */     public final void invoke() {
/* 33 */       String uuid = MinecraftInstance.mc.getSession().getPlayerId();
/* 34 */       String username = MinecraftInstance.mc.getSession().getUsername();
/*    */       
/* 36 */       CloseableHttpClient httpClient = HttpClients.createDefault();
/* 37 */       BasicHeader[] headers = {
/* 38 */           new BasicHeader("Content-Type", "application/json"), 
/* 39 */           new BasicHeader("Authorization", GuiDonatorCape.Companion.getTransferCode())
/*    */         };
/* 41 */       HttpPatch request = new HttpPatch("http://capes.liquidbounce.net/api/v1/cape/self");
/* 42 */       request.setHeaders((Header[])headers);
/*    */       
/* 44 */       JSONObject body = new JSONObject();
/* 45 */       body.put("uuid", uuid);
/* 46 */       request.setEntity((HttpEntity)new StringEntity(body.toString()));
/*    */       
/* 48 */       CloseableHttpResponse response = httpClient.execute((HttpUriRequest)request);
/* 49 */       Intrinsics.checkExpressionValueIsNotNull(response, "response"); Intrinsics.checkExpressionValueIsNotNull(response.getStatusLine(), "response.statusLine"); int statusCode = response.getStatusLine().getStatusCode();
/*    */       
/* 51 */       ClientUtils.getLogger().info(
/* 52 */           (statusCode == 204) ? (
/* 53 */           "[Donator Cape] Successfully transferred cape to " + uuid + " (" + username + ')') : (
/*    */           
/* 55 */           "[Donator Cape] Failed to transfer cape (" + statusCode + ')'));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean handleEvents() {
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onSession(@NotNull SessionEvent event) {
/*    */     Intrinsics.checkParameterIsNotNull(event, "event");
/*    */     if (GuiDonatorCape.Companion.getCapeEnabled()) {
/*    */       CharSequence charSequence = GuiDonatorCape.Companion.getTransferCode();
/*    */       boolean bool = false;
/*    */       if (!((charSequence.length() == 0) ? 1 : 0) && UserUtils.INSTANCE.isValidTokenOffline(MinecraftInstance.mc.getSession().getToken())) {
/*    */         ThreadsKt.thread$default(false, false, null, null, 0, DonatorCape$onSession$1.INSTANCE, 31, null);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\special\DonatorCape.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */