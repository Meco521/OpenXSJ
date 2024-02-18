/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.Map;
/*    */ import me.utils.motionblur.MotionBlurResourceManager;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.TickEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.minecraft.client.resources.SimpleReloadableResourceManager;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "MotionBlur", category = ModuleCategory.RENDER, description = "Skid by 凡哥")
/*    */ public class MotionBlur
/*    */   extends Module
/*    */ {
/* 22 */   public static IntegerValue MOTION_BLUR_AMOUNT = new IntegerValue("BlurAmount", 2, 1, 10);
/* 23 */   int lastValue = 0;
/*    */   private Map<String, MotionBlurResourceManager> domainResourceManagers;
/*    */   
/*    */   public void onDisable() {
/* 27 */     mc.getEntityRenderer().stopUseShader();
/*    */   }
/*    */   
/*    */   public void onEnable() {
/* 31 */     if (this.domainResourceManagers == null) {
/*    */       try {
/* 33 */         Field[] fields = SimpleReloadableResourceManager.class.getDeclaredFields();
/* 34 */         for (Field field : fields) {
/* 35 */           if (field.getType() == Map.class) {
/* 36 */             field.setAccessible(true);
/* 37 */             this.domainResourceManagers = (Map<String, MotionBlurResourceManager>)field.get(mc2.func_110442_L());
/*    */             break;
/*    */           } 
/*    */         } 
/* 41 */       } catch (Exception exception) {
/* 42 */         throw new RuntimeException(exception);
/*    */       } 
/*    */     }
/*    */     
/* 46 */     if (!this.domainResourceManagers.containsKey("motionblur")) {
/* 47 */       this.domainResourceManagers.put("motionblur", new MotionBlurResourceManager());
/*    */     }
/*    */     
/* 50 */     if (isFastRenderEnabled())
/* 51 */       ClientUtils.disableFastRender(); 
/* 52 */     this.lastValue = ((Integer)MOTION_BLUR_AMOUNT.get()).intValue();
/* 53 */     applyShader();
/*    */   }
/*    */   
/*    */   public boolean isFastRenderEnabled() {
/*    */     try {
/* 58 */       Field fastRender = GameSettings.class.getDeclaredField("ofFastRender");
/* 59 */       return fastRender.getBoolean(mc2.field_71474_y);
/* 60 */     } catch (Exception exception) {
/* 61 */       return false;
/*    */     } 
/*    */   }
/*    */   public void applyShader() {
/* 65 */     mc.getEntityRenderer().loadShader2(new ResourceLocation("motionblur", "motionblur"));
/*    */   }
/*    */   @EventTarget
/*    */   public void onTick(TickEvent event) {
/* 69 */     if ((!mc2.field_71460_t.func_147702_a() || this.lastValue != ((Integer)MOTION_BLUR_AMOUNT.get()).intValue()) && mc2.field_71441_e != null && !isFastRenderEnabled()) {
/* 70 */       this.lastValue = ((Integer)MOTION_BLUR_AMOUNT.get()).intValue();
/* 71 */       applyShader();
/*    */     } 
/* 73 */     if (this.domainResourceManagers == null) {
/*    */       try {
/* 75 */         Field[] fields = SimpleReloadableResourceManager.class.getDeclaredFields();
/* 76 */         for (Field field : fields) {
/* 77 */           if (field.getType() == Map.class) {
/* 78 */             field.setAccessible(true);
/* 79 */             this.domainResourceManagers = (Map<String, MotionBlurResourceManager>)field.get(mc2.func_110442_L());
/*    */             break;
/*    */           } 
/*    */         } 
/* 83 */       } catch (Exception exception) {
/* 84 */         throw new RuntimeException(exception);
/*    */       } 
/*    */     }
/* 87 */     if (!this.domainResourceManagers.containsKey("motionblur")) {
/* 88 */       this.domainResourceManagers.put("motionblur", new MotionBlurResourceManager());
/*    */     }
/* 90 */     if (isFastRenderEnabled())
/* 91 */       ClientUtils.disableFastRender(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\MotionBlur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */