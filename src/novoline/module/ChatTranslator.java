/*    */ package novoline.module;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.util.HashMap;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.network.play.server.SPacketChat;
/*    */ import org.apache.http.client.methods.CloseableHttpResponse;
/*    */ import org.apache.http.client.methods.HttpGet;
/*    */ import org.apache.http.impl.client.CloseableHttpClient;
/*    */ import org.apache.http.impl.client.HttpClients;
/*    */ import org.apache.http.util.EntityUtils;
/*    */ 
/*    */ @ModuleInfo(name = "ChatTranslator", category = ModuleCategory.MISC, description = "翻译")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\020\016\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\006\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\r\032\0020\0162\006\020\017\032\0020\007H\002J\020\020\020\032\0020\0072\006\020\017\032\0020\007H\002J\020\020\021\032\0020\0072\006\020\022\032\0020\007H\002J\020\020\023\032\0020\0162\006\020\024\032\0020\025H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R*\020\005\032\036\022\004\022\0020\007\022\004\022\0020\0070\006j\016\022\004\022\0020\007\022\004\022\0020\007`\bX\004¢\006\002\n\000R\026\020\t\032\n \013*\004\030\0010\n0\nX\004¢\006\002\n\000R\016\020\f\032\0020\004X\004¢\006\002\n\000¨\006\026"}, d2 = {"Lnovoline/module/ChatTranslator;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "apiValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "cache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "client", "Lorg/apache/http/impl/client/CloseableHttpClient;", "kotlin.jvm.PlatformType", "languageValue", "doTranslate", "", "msg", "getLink", "getResult", "data", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class ChatTranslator extends Module {
/* 24 */   private final ListValue languageValue = new ListValue("Language", new String[] { "Chinese", "English" }, "Chinese");
/* 25 */   private final ListValue apiValue = new ListValue("API", new String[] { "Google", "Bing", "YouDao" }, "Bing");
/*    */   
/* 27 */   private final CloseableHttpClient client = HttpClients.createDefault();
/* 28 */   private final HashMap<String, String> cache = new HashMap<>();
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 32 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getPacket() instanceof SPacketChat) {
/* 33 */       Intrinsics.checkExpressionValueIsNotNull(((SPacketChat)event.getPacket()).func_148915_c(), "event.packet.chatComponent"); String msg = ((SPacketChat)event.getPacket()).func_148915_c().func_150254_d();
/* 34 */       HashMap<String, String> hashMap1 = this.cache; boolean bool1 = false; HashMap<String, String> hashMap2 = hashMap1; boolean bool2 = false; if (!hashMap2.containsKey(msg)) {
/* 35 */         Intrinsics.checkExpressionValueIsNotNull(msg, "msg"); doTranslate(msg);
/*    */       } else {
/* 37 */         if (this.cache.get(msg) == null) Intrinsics.throwNpe();  ClientUtils.displayChatMessage(this.cache.containsKey(msg) ? msg : this.cache.get(msg));
/*    */       } 
/*    */       
/* 40 */       event.cancelEvent();
/*    */     } 
/*    */   }
/*    */   
/*    */   private final String getLink(String msg) {
/* 45 */     String message = StringsKt.replace$default(msg, " ", "%20", false, 4, null);
/* 46 */     String str1 = (String)this.apiValue.get(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode()) { case -1240244679:
/* 47 */         if (str1.equals("google")); break;
/* 48 */       case 3023936: if (str1.equals("bing")); break;
/* 49 */       case -724744429: if (str1.equals("youdao")); break; }
/* 50 */      return "";
/*    */   }
/*    */ 
/*    */   
/*    */   private final String getResult(String data) {
/* 55 */     String str = (String)this.apiValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -1240244679:
/* 56 */         if (str.equals("google"))
/* 57 */         { Intrinsics.checkExpressionValueIsNotNull((new JsonParser()).parse(data), "JsonParser().parse(data)"); JsonObject json = (new JsonParser()).parse(data).getAsJsonObject();
/* 58 */           Intrinsics.checkExpressionValueIsNotNull(json.get("sentences"), "json.get(\"sentences\")"); Intrinsics.checkExpressionValueIsNotNull(json.get("sentences").getAsJsonArray().get(0), "json.get(\"sentences\").asJsonArray.get(0)"); Intrinsics.checkExpressionValueIsNotNull(json.get("sentences").getAsJsonArray().get(0).getAsJsonObject().get("trans"), "json.get(\"sentences\").as…asJsonObject.get(\"trans\")"); Intrinsics.checkExpressionValueIsNotNull(json.get("sentences").getAsJsonArray().get(0).getAsJsonObject().get("trans").getAsString(), "json.get(\"sentences\").as…ect.get(\"trans\").asString"); return json.get("sentences").getAsJsonArray().get(0).getAsJsonObject().get("trans").getAsString(); }  break;
/*    */       case 3023936:
/* 60 */         if (str.equals("bing"))
/*    */         {
/*    */           
/* 63 */           return StringsKt.replace$default(StringsKt.replace$default(data, "<string xmlns=\"http://schemas.microsoft.com/2003/10/Serialization/\">", "", false, 4, null), "</string>", "", false, 4, null); }  break;
/*    */       case -724744429:
/* 65 */         if (str.equals("youdao")) {
/* 66 */           Intrinsics.checkExpressionValueIsNotNull((new JsonParser()).parse(data), "JsonParser().parse(data)"); JsonObject json = (new JsonParser()).parse(data).getAsJsonObject();
/* 67 */           Intrinsics.checkExpressionValueIsNotNull(json.get("translateResult"), "json.get(\"translateResult\")"); Intrinsics.checkExpressionValueIsNotNull(json.get("translateResult").getAsJsonArray().get(0), "json.get(\"translateResult\").asJsonArray.get(0)"); Intrinsics.checkExpressionValueIsNotNull(json.get("translateResult").getAsJsonArray().get(0).getAsJsonArray().get(0), "json.get(\"translateResul…get(0).asJsonArray.get(0)"); Intrinsics.checkExpressionValueIsNotNull(json.get("translateResult").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonObject().get("tgt"), "json.get(\"translateResul…).asJsonObject.get(\"tgt\")"); Intrinsics.checkExpressionValueIsNotNull(json.get("translateResult").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonObject().get("tgt").getAsString(), "json.get(\"translateResul…bject.get(\"tgt\").asString"); return json.get("translateResult").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonObject().get("tgt").getAsString();
/*    */         }  break; }
/*    */     
/* 70 */     return "WRONG VALUE";
/*    */   }
/*    */   
/*    */   private final void doTranslate(String msg) {
/* 74 */     (new Thread(new ChatTranslator$doTranslate$1(msg)))
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
/* 90 */       .start();
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*    */   static final class ChatTranslator$doTranslate$1 implements Runnable {
/*    */     public final void run() {
/*    */       try {
/*    */         HttpGet request = new HttpGet(ChatTranslator.this.getLink(this.$msg));
/*    */         CloseableHttpResponse response = ChatTranslator.this.client.execute((HttpUriRequest)request);
/*    */         Intrinsics.checkExpressionValueIsNotNull(response, "response");
/*    */         Intrinsics.checkExpressionValueIsNotNull(response.getStatusLine(), "response.statusLine");
/*    */         if (response.getStatusLine().getStatusCode() != 200) {
/*    */           Intrinsics.checkExpressionValueIsNotNull(response.getStatusLine(), "response.statusLine");
/*    */           throw (Throwable)new IllegalStateException("resp code: " + response.getStatusLine().getStatusCode() + " != 200");
/*    */         } 
/*    */         Intrinsics.checkExpressionValueIsNotNull(EntityUtils.toString(response.getEntity()), "EntityUtils.toString(response.entity)");
/*    */         String result = ChatTranslator.this.getResult(EntityUtils.toString(response.getEntity()));
/*    */         ChatTranslator.this.cache.put(this.$msg, result);
/*    */         ClientUtils.displayChatMessage(result);
/*    */       } catch (Exception e) {
/*    */         e.printStackTrace();
/*    */         ClientUtils.displayChatMessage(this.$msg);
/*    */       } 
/*    */     }
/*    */     
/*    */     ChatTranslator$doTranslate$1(String param1String) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\novoline\module\ChatTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */