/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.lwjgl.opengl.Display;
/*    */ 
/*    */ @ModuleInfo(name = "FreeLook", description = "Freelook", category = ModuleCategory.RENDER)
/*    */ public final class Freelook
/*    */   extends Module {
/* 12 */   private static final Minecraft mc = Minecraft.func_71410_x();
/*    */   public static boolean perspectiveToggled = false;
/* 14 */   public static float cameraYaw = 0.0F;
/* 15 */   public static float cameraPitch = 0.0F;
/* 16 */   private static int previousPerspective = 0;
/*    */   
/*    */   public void onEnable() {
/* 19 */     perspectiveToggled = !perspectiveToggled;
/* 20 */     cameraYaw = mc2.field_71439_g.field_70177_z;
/* 21 */     cameraPitch = mc2.field_71439_g.field_70125_A;
/* 22 */     if (perspectiveToggled) {
/* 23 */       previousPerspective = mc.field_71474_y.field_74320_O;
/* 24 */       mc.field_71474_y.field_74320_O = 1;
/*    */     } else {
/* 26 */       mc.field_71474_y.field_74320_O = previousPerspective;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean overrideMouse() {
/* 31 */     if (mc.field_71415_G && Display.isActive()) {
/* 32 */       if (!perspectiveToggled) {
/* 33 */         return true;
/*    */       }
/*    */       
/* 36 */       mc.field_71417_B.func_74374_c();
/* 37 */       float f1 = mc.field_71474_y.field_74341_c * 0.6F + 0.2F;
/* 38 */       float f2 = f1 * f1 * f1 * 8.0F;
/* 39 */       float f3 = mc.field_71417_B.field_74377_a * f2;
/* 40 */       float f4 = mc.field_71417_B.field_74375_b * f2;
/*    */       
/* 42 */       cameraYaw += f3 * 0.15F;
/* 43 */       cameraPitch += f4 * 0.15F;
/*    */       
/* 45 */       if (cameraPitch > 90.0F) cameraPitch = 90.0F; 
/* 46 */       if (cameraPitch < -90.0F) cameraPitch = -90.0F; 
/*    */     } 
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 52 */     resetPerspective();
/*    */   }
/*    */   
/*    */   public static void resetPerspective() {
/* 56 */     perspectiveToggled = false;
/* 57 */     mc.field_71474_y.field_74320_O = previousPerspective;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Freelook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */