/*    */ package net.ccbluex.liquidbounce.cape;
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.misc.HttpUtils;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\005\032\0020\006J\020\020\007\032\004\030\0010\b2\006\020\t\032\0020\nJ\006\020\013\032\0020\fR\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/cape/CapeAPI;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "()V", "capeService", "Lnet/ccbluex/liquidbounce/cape/CapeService;", "hasCapeService", "", "loadCape", "Lnet/ccbluex/liquidbounce/cape/CapeInfo;", "uuid", "Ljava/util/UUID;", "registerCapeService", "", "XSJClient"})
/*    */ public final class CapeAPI extends MinecraftInstance {
/*    */   static {
/* 19 */     CapeAPI capeAPI = new CapeAPI();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static CapeService capeService;
/*    */   
/*    */   public static final CapeAPI INSTANCE;
/*    */ 
/*    */   
/*    */   public final void registerCapeService() {
/* 30 */     Intrinsics.checkExpressionValueIsNotNull((new JsonParser()).parse(HttpUtils.get("https://cloud.liquidbounce.net/LiquidBounce/capes.json")), "JsonParser()\n           …IENT_CLOUD}/capes.json\"))"); JsonObject jsonObject = (new JsonParser()).parse(HttpUtils.get("https://cloud.liquidbounce.net/LiquidBounce/capes.json")).getAsJsonObject();
/* 31 */     Intrinsics.checkExpressionValueIsNotNull(jsonObject.get("serviceType"), "jsonObject.get(\"serviceType\")"); String serviceType = jsonObject.get("serviceType").getAsString();
/*    */ 
/*    */     
/* 34 */     Intrinsics.checkExpressionValueIsNotNull(serviceType, "serviceType"); String str1 = serviceType; boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode()) { case 96794:
/* 35 */         if (str1.equals("api"))
/* 36 */         { Intrinsics.checkExpressionValueIsNotNull(jsonObject.get("api"), "jsonObject.get(\"api\")"); Intrinsics.checkExpressionValueIsNotNull(jsonObject.get("api").getAsJsonObject().get("url"), "jsonObject.get(\"api\").asJsonObject.get(\"url\")"); String url = jsonObject.get("api").getAsJsonObject().get("url").getAsString();
/*    */           
/* 38 */           Intrinsics.checkExpressionValueIsNotNull(url, "url"); capeService = new ServiceAPI(url);
/* 39 */           ClientUtils.getLogger().info("Registered " + url + " as '" + serviceType + "' service type."); }  break;
/*    */       case 3322014:
/* 41 */         if (str1.equals("list")) {
/* 42 */           HashMap<Object, Object> users = new HashMap<>();
/*    */           
/* 44 */           Intrinsics.checkExpressionValueIsNotNull(jsonObject.get("users"), "jsonObject.get(\"users\")"); for (Iterator<Map.Entry> iterator = jsonObject.get("users").getAsJsonObject().entrySet().iterator(); iterator.hasNext(); ) { Map.Entry entry1 = iterator.next(), entry2 = entry1; boolean bool1 = false; String str = (String)entry2.getKey(); entry2 = entry1; bool1 = false; JsonElement value = (JsonElement)entry2.getValue();
/* 45 */             Intrinsics.checkExpressionValueIsNotNull(str, "key"); Intrinsics.checkExpressionValueIsNotNull(value, "value"); Intrinsics.checkExpressionValueIsNotNull(value.getAsString(), "value.asString"); users.put(str, value.getAsString());
/* 46 */             ClientUtils.getLogger().info("Loaded user cape for '" + str + "'."); }
/*    */ 
/*    */           
/* 49 */           capeService = new ServiceList((Map)users);
/* 50 */           ClientUtils.getLogger().info("Registered '" + serviceType + "' service type.");
/*    */         } 
/*    */         break; }
/*    */     
/* 54 */     ClientUtils.getLogger().info("Loaded.");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public final CapeInfo loadCape(@NotNull UUID uuid) {
/* 65 */     Intrinsics.checkParameterIsNotNull(uuid, "uuid"); if (capeService != null) { if (capeService.getCape(uuid) != null) { String url = capeService.getCape(uuid);
/*    */ 
/*    */         
/* 68 */         String str1 = "capes/%s.png"; Object[] arrayOfObject = { uuid.toString() }; IClassProvider iClassProvider = Retreat.INSTANCE.getWrapper().getClassProvider(); boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)), "java.lang.String.format(this, *args)"); String str2 = String.format(str1, Arrays.copyOf(arrayOfObject, arrayOfObject.length)); IResourceLocation resourceLocation = iClassProvider.createResourceLocation(str2);
/* 69 */         CapeInfo capeInfo = new CapeInfo(resourceLocation, false, 2, null);
/* 70 */         IThreadDownloadImageData threadDownloadImageData = Retreat.INSTANCE.getWrapper().getClassProvider().createThreadDownloadImageData(null, url, null, new CapeAPI$loadCape$threadDownloadImageData$1(capeInfo));
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
/* 82 */         MinecraftInstance.mc.getTextureManager().loadTexture(resourceLocation, (IAbstractTexture)threadDownloadImageData);
/*    */         
/* 84 */         return capeInfo; }
/*    */       
/*    */       capeService.getCape(uuid);
/*    */       return null; }
/*    */     
/*    */     return null;
/*    */   }
/*    */   public final boolean hasCapeService() {
/* 92 */     return (capeService != null);
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000*\001\000\b\n\030\0002\0020\001J\024\020\002\032\004\030\0010\0032\b\020\004\032\004\030\0010\003H\026J\b\020\005\032\0020\006H\026¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/cape/CapeAPI$loadCape$threadDownloadImageData$1", "Lnet/ccbluex/liquidbounce/api/minecraft/client/render/WIImageBuffer;", "parseUserSkin", "Ljava/awt/image/BufferedImage;", "image", "skinAvailable", "", "XSJClient"})
/*    */   public static final class CapeAPI$loadCape$threadDownloadImageData$1 implements WIImageBuffer {
/*    */     CapeAPI$loadCape$threadDownloadImageData$1(CapeInfo $captured_local_variable$0) {}
/*    */     
/*    */     @Nullable
/*    */     public BufferedImage parseUserSkin(@Nullable BufferedImage image) {
/*    */       return image;
/*    */     }
/*    */     
/*    */     public void skinAvailable() {
/*    */       this.$capeInfo.setCapeAvailable(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\cape\CapeAPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */