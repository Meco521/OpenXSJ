/*    */ package net.ccbluex.liquidbounce.utils;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.awt.Color;
/*    */ import java.security.PublicKey;
/*    */ import javax.crypto.SecretKey;
/*    */ import kotlin.Unit;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.INetworkManager;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.login.server.ISPacketEncryptionRequest;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public final class ClientUtils
/*    */   extends MinecraftInstance {
/* 20 */   private static final Logger logger = LogManager.getLogger("LiquidBounce");
/*    */   
/*    */   public static Logger getLogger() {
/* 23 */     return logger;
/*    */   }
/*    */   
/*    */   public static void disableFastRender() {
/* 27 */     Retreat.wrapper.getFunctions().disableFastRender();
/*    */   }
/*    */   
/*    */   public static void sendEncryption(INetworkManager networkManager, SecretKey secretKey, PublicKey publicKey, ISPacketEncryptionRequest encryptionRequest) {
/* 31 */     networkManager.sendPacket(classProvider.createCPacketEncryptionResponse(secretKey, publicKey, encryptionRequest.getVerifyToken()), () -> {
/*    */           networkManager.enableEncryption(secretKey);
/*    */           return null;
/*    */         });
/*    */   }
/*    */   
/*    */   public static WVec3 getVectorForRotation(float p_getVectorForRotation_1_, float p_getVectorForRotation_2_) {
/* 38 */     float f = (float)Math.cos((-p_getVectorForRotation_2_ * 0.017453292F - 3.1415927F));
/* 39 */     float f1 = (float)Math.sin((-p_getVectorForRotation_2_ * 0.017453292F - 3.1415927F));
/* 40 */     float f2 = (float)Math.cos((-p_getVectorForRotation_1_ * 0.017453292F));
/* 41 */     float f3 = (float)Math.sin((-p_getVectorForRotation_1_ * 0.017453292F));
/* 42 */     return new WVec3((f1 * f2), f3, (f * f2));
/*    */   }
/*    */   public static void displayChatMessage(String message) {
/* 45 */     if (mc.getThePlayer() == null) {
/* 46 */       getLogger().info("(MCChat)" + message);
/*    */       
/*    */       return;
/*    */     } 
/* 50 */     JsonObject jsonObject = new JsonObject();
/* 51 */     jsonObject.addProperty("text", message);
/*    */     
/* 53 */     mc.getThePlayer().addChatMessage(Retreat.wrapper.getFunctions().jsonToComponent(jsonObject.toString()));
/*    */   }
/*    */   
/*    */   public static int reAlpha(int color, float alpha) {
/* 57 */     Color c = new Color(color);
/* 58 */     float r = 0.003921569F * c.getRed();
/* 59 */     float g = 0.003921569F * c.getGreen();
/* 60 */     float b = 0.003921569F * c.getBlue();
/* 61 */     return (new Color(r, g, b, alpha)).getRGB();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\ClientUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */