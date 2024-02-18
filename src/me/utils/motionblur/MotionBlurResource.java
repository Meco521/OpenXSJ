/*    */ package me.utils.motionblur;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Locale;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.MotionBlur;
/*    */ import net.minecraft.client.resources.IResource;
/*    */ import net.minecraft.client.resources.data.IMetadataSection;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.commons.io.IOUtils;
/*    */ 
/*    */ public class MotionBlurResource
/*    */   implements IResource {
/*    */   public InputStream func_110527_b() {
/* 15 */     double amount = 0.7D + ((Integer)MotionBlur.MOTION_BLUR_AMOUNT.get()).intValue() / 100.0D * 3.0D - 0.01D;
/* 16 */     return IOUtils.toInputStream(String.format(Locale.ENGLISH, "{\"targets\":[\"swap\",\"previous\"],\"passes\":[{\"name\":\"phosphor\",\"intarget\":\"minecraft:main\",\"outtarget\":\"swap\",\"auxtargets\":[{\"name\":\"PrevSampler\",\"id\":\"previous\"}],\"uniforms\":[{\"name\":\"Phosphor\",\"values\":[%.2f, %.2f, %.2f]}]},{\"name\":\"blit\",\"intarget\":\"swap\",\"outtarget\":\"previous\"},{\"name\":\"blit\",\"intarget\":\"swap\",\"outtarget\":\"minecraft:main\"}]}", new Object[] { Double.valueOf(amount), Double.valueOf(amount), Double.valueOf(amount) }));
/*    */   }
/*    */   
/*    */   public boolean func_110528_c() {
/* 20 */     return false;
/*    */   }
/*    */   
/*    */   public IMetadataSection func_110526_a(String metadata) {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */   public ResourceLocation func_177241_a() {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public String func_177240_d() {
/* 32 */     return null;
/*    */   }
/*    */   
/*    */   public void close() throws IOException {}
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\m\\utils\motionblur\MotionBlurResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */