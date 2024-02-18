/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.block.model.IBakedModel;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "ItemPhysics", description = "物理掉落", category = ModuleCategory.RENDER)
/*     */ public class ItemPhysics
/*     */   extends Module
/*     */ {
/*     */   private final Random random;
/*     */   
/*     */   public static void handleCameraTransforms(IBakedModel model, ItemCameraTransforms.TransformType cameraTransformType) {
/*  29 */     model.func_177552_f().func_181689_a(cameraTransformType);
/*     */   }
/*     */   public ItemPhysics() {
/*  32 */     this.random = new Random();
/*     */   }
/*     */   
/*     */   public ResourceLocation getEntityTexture() {
/*  36 */     return TextureMap.field_110575_b;
/*     */   }
/*     */   
/*     */   public void setPositionAndRotation2(EntityItem item, double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
/*  40 */     item.func_70107_b(x, y, z);
/*     */   }
/*     */   public void doRender(TextureManager renderer, Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
/*     */     int i;
/*  44 */     double rotation = 2.0D;
/*  45 */     EntityItem item = (EntityItem)entity;
/*  46 */     ItemStack itemstack = item.func_92059_d();
/*     */     
/*  48 */     if (itemstack != null && itemstack.func_77973_b() != null) {
/*  49 */       i = Item.func_150891_b(itemstack.func_77973_b()) + itemstack.func_77960_j();
/*     */     } else {
/*  51 */       i = 187;
/*     */     } 
/*  53 */     this.random.setSeed(i);
/*  54 */     renderer.func_110577_a(getEntityTexture());
/*  55 */     renderer.func_110581_b(getEntityTexture()).func_174936_b(false, false);
/*  56 */     GlStateManager.func_179091_B();
/*  57 */     GlStateManager.func_179092_a(516, 0.1F);
/*  58 */     GlStateManager.func_179147_l();
/*  59 */     RenderHelper.func_74519_b();
/*  60 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  61 */     GlStateManager.func_179094_E();
/*  62 */     IBakedModel ibakedmodel = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178089_a(itemstack);
/*  63 */     boolean flag2 = ibakedmodel.func_177556_c();
/*  64 */     boolean is3D = ibakedmodel.func_177556_c();
/*  65 */     int j = getModelCount(itemstack);
/*  66 */     GlStateManager.func_179109_b((float)x, (float)y, (float)z);
/*  67 */     if (ibakedmodel.func_177556_c()) {
/*  68 */       GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/*     */     }
/*  70 */     GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*  71 */     GL11.glRotatef(item.field_70177_z, 0.0F, 0.0F, 1.0F);
/*  72 */     if (is3D) {
/*  73 */       GlStateManager.func_179137_b(0.0D, 0.0D, -0.08D);
/*     */     } else {
/*  75 */       GlStateManager.func_179137_b(0.0D, 0.0D, -0.04D);
/*     */     } 
/*  77 */     if (is3D || (mc2.func_175598_ae()).field_78733_k != null) {
/*  78 */       if (is3D) {
/*  79 */         if (!item.field_70122_E) {
/*  80 */           item.field_70125_A += (float)rotation;
/*     */         }
/*  82 */       } else if (!Double.isNaN(item.field_70165_t) && !Double.isNaN(item.field_70163_u) && !Double.isNaN(item.field_70161_v) && item.field_70170_p != null) {
/*  83 */         if (item.field_70122_E) {
/*  84 */           item.field_70125_A = 0.0F;
/*     */         } else {
/*  86 */           rotation *= 2.0D;
/*  87 */           item.field_70125_A += (float)rotation;
/*     */         } 
/*     */       } 
/*  90 */       GlStateManager.func_179114_b(item.field_70125_A, 1.0F, 0.0F, 0.0F);
/*     */     } 
/*  92 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  93 */     for (int k = 0; k < j; k++) {
/*  94 */       if (flag2) {
/*  95 */         GlStateManager.func_179094_E();
/*  96 */         if (k > 0) {
/*  97 */           float f4 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
/*  98 */           float f5 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
/*  99 */           float f6 = (this.random.nextFloat() * 2.0F - 1.0F) * 0.15F;
/* 100 */           GlStateManager.func_179109_b(f4, f5, f6);
/*     */         } 
/* 102 */         handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GROUND);
/* 103 */         mc2.func_175599_af().func_180454_a(itemstack, ibakedmodel);
/* 104 */         GlStateManager.func_179121_F();
/*     */       } else {
/* 106 */         GlStateManager.func_179094_E();
/* 107 */         if (k > 0);
/*     */         
/* 109 */         handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GROUND);
/* 110 */         Minecraft.func_71410_x().func_175599_af().func_180454_a(itemstack, ibakedmodel);
/* 111 */         GlStateManager.func_179121_F();
/* 112 */         GlStateManager.func_179109_b(0.0F, 0.0F, 0.05375F);
/*     */       } 
/*     */     } 
/* 115 */     GlStateManager.func_179121_F();
/* 116 */     GlStateManager.func_179101_C();
/* 117 */     GlStateManager.func_179084_k();
/* 118 */     renderer.func_110577_a(getEntityTexture());
/* 119 */     renderer.func_110581_b(getEntityTexture()).func_174935_a();
/*     */   }
/*     */   
/*     */   public int getModelCount(ItemStack stack) {
/* 123 */     int i = 1;
/* 124 */     if (stack.field_77994_a > 48) {
/* 125 */       i = 5;
/* 126 */     } else if (stack.field_77994_a > 32) {
/* 127 */       i = 4;
/* 128 */     } else if (stack.field_77994_a > 16) {
/* 129 */       i = 3;
/* 130 */     } else if (stack.field_77994_a > 1) {
/* 131 */       i = 2;
/*     */     } 
/* 133 */     return i;
/*     */   }
/*     */   
/*     */   enum PhysicModes {
/* 137 */     Realistic,
/* 138 */     Alpha,
/* 139 */     Simple;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ItemPhysics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */