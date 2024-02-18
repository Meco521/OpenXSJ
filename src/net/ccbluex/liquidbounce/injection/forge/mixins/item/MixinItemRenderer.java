/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.item;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Animations;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AntiBlind;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.EnumHandSide;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraftforge.client.ForgeHooksClient;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({ItemRenderer.class})
/*     */ public abstract class MixinItemRenderer
/*     */ {
/*  41 */   float delay = 0.0F;
/*  42 */   MSTimer rotateTimer = new MSTimer();
/*     */   @Shadow
/*     */   private ItemStack field_187467_d;
/*     */   @Shadow
/*     */   private ItemStack field_187468_e;
/*     */   @Shadow
/*     */   private float field_187469_f;
/*     */   @Shadow
/*     */   private float field_187470_g;
/*     */   @Shadow
/*     */   private float field_187471_h;
/*     */   @Shadow
/*     */   private float field_187472_i;
/*     */   @Shadow
/*     */   @Final
/*     */   private Minecraft field_78455_a;
/*     */   
/*     */   private static void jello(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  60 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  61 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/*  62 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/*  63 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/*  64 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  65 */     float var13 = MathHelper.func_76126_a(swingProgress * swingProgress * 3.1415927F);
/*  66 */     float var14 = MathHelper.func_76126_a(MathHelper.func_76129_c(swingProgress) * 3.1415927F);
/*  67 */     GlStateManager.func_179114_b(var13 * -35.0F, 0.0F, 0.0F, 0.0F);
/*  68 */     GlStateManager.func_179114_b(var14 * 0.0F, 0.0F, 0.0F, 0.0F);
/*  69 */     GlStateManager.func_179114_b(var14 * 20.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private static void sigmaold(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  73 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  74 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/*  75 */     GlStateManager.func_179109_b(0.0F, equippedProg * -0.6F, 0.0F);
/*  76 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/*  77 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/*  78 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  79 */     float var3 = MathHelper.func_76126_a(swingProgress * swingProgress * 3.1415927F);
/*  80 */     float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(swingProgress) * 3.1415927F);
/*  81 */     GlStateManager.func_179114_b(var3 * -15.0F, 0.0F, 1.0F, 0.2F);
/*  82 */     GlStateManager.func_179114_b(var4 * -10.0F, 0.2F, 0.1F, 1.0F);
/*  83 */     GlStateManager.func_179114_b(var4 * -30.0F, 1.3F, 0.1F, 0.2F);
/*     */   }
/*     */   
/*     */   private static void WindMill(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/*  87 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/*  88 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/*  89 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/*  90 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/*  91 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/*  92 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/*  93 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/*  94 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/*  95 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/*  96 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/*  97 */     GlStateManager.func_179114_b((float)(f1 * -50.0D), 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void Push(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 102 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/* 103 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/* 104 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/* 105 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 106 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 107 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/* 108 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 109 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 110 */     GlStateManager.func_179114_b((float)(f * -10.0D), 1.0F, 1.0F, 1.0F);
/* 111 */     GlStateManager.func_179114_b((float)(f1 * -10.0D), 1.0F, 1.0F, 1.0F);
/* 112 */     GlStateManager.func_179114_b((float)(f1 * -10.0D), 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private static void Flux(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 116 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/* 117 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/* 118 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/* 119 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 120 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 121 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/* 122 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 123 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 124 */     GlStateManager.func_179114_b((float)(f * -30.0D), 1.0F, 1.0F, 1.0F);
/* 125 */     GlStateManager.func_179114_b((float)(f1 * -15.0D), 1.0F, 1.0F, 1.0F);
/* 126 */     GlStateManager.func_179114_b((float)(f1 * -15.0D), 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void test(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 131 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/* 132 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/* 133 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/* 134 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 135 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 136 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/* 137 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 138 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 139 */     GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, -1.0F);
/* 140 */     GlStateManager.func_179114_b(-10.0F, 1.0F, 0.0F, -1.0F);
/* 141 */     GlStateManager.func_179114_b((float)(f1 * -40.0D), 1.0F, -0.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private static void transformSideFirstPersonBlock(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 145 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/* 146 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/* 147 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/* 148 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 149 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 150 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/* 151 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 152 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 153 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/* 154 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/* 155 */     GlStateManager.func_179114_b((float)(f1 * -80.0D), 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   private static void SmoothBlock(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 159 */     int side = (p_187459_1_ == EnumHandSide.RIGHT) ? 1 : -1;
/* 160 */     GlStateManager.func_179137_b(side * 0.56D, -0.52D + equippedProg * -0.6D, -0.72D);
/* 161 */     GlStateManager.func_179137_b(side * -0.1414214D, 0.08D, 0.1414214D);
/* 162 */     GlStateManager.func_179114_b(-102.25F, 1.0F, 0.0F, 0.0F);
/* 163 */     GlStateManager.func_179114_b(side * 13.365F, 0.0F, 1.0F, 0.0F);
/* 164 */     GlStateManager.func_179114_b(side * 78.05F, 0.0F, 0.0F, 1.0F);
/* 165 */     double f = Math.sin((swingProgress * swingProgress) * Math.PI);
/* 166 */     double f1 = Math.sin(Math.sqrt(swingProgress) * Math.PI);
/* 167 */     GlStateManager.func_179114_b((float)(f * -20.0D), 0.0F, 1.0F, 0.0F);
/* 168 */     GlStateManager.func_179114_b((float)(f1 * -20.0D), 0.0F, 0.0F, 1.0F);
/* 169 */     GlStateManager.func_179114_b((float)(f1 * -30.0D), 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_187463_a(float paramFloat1, float paramFloat2, float paramFloat3);
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_187453_a(EnumHandSide paramEnumHandSide, float paramFloat);
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_187454_a(float paramFloat, EnumHandSide paramEnumHandSide, ItemStack paramItemStack);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_187456_a(float paramFloat1, float paramFloat2, EnumHandSide paramEnumHandSide);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_187465_a(float paramFloat1, EnumHandSide paramEnumHandSide, float paramFloat2, ItemStack paramItemStack);
/*     */   
/*     */   @Shadow
/*     */   protected abstract void func_187459_b(EnumHandSide paramEnumHandSide, float paramFloat);
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_187462_a(EntityLivingBase paramEntityLivingBase, ItemStack paramItemStack, ItemCameraTransforms.TransformType paramTransformType, boolean paramBoolean);
/*     */   
/*     */   private void doItemRenderGLTranslate() {
/* 197 */     GlStateManager.func_179109_b(((Float)Animations.xhValue.get()).floatValue(), ((Float)Animations.yhValue.get()).floatValue(), ((Float)Animations.zhValue.get()).floatValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public void func_187457_a(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_) {
/* 206 */     boolean flag = (hand == EnumHand.MAIN_HAND);
/* 207 */     EnumHandSide enumhandside = flag ? player.func_184591_cq() : player.func_184591_cq().func_188468_a();
/* 208 */     GlStateManager.func_179094_E();
/*     */     
/* 210 */     if (stack.func_190926_b()) {
/* 211 */       if (flag && !player.func_82150_aj()) {
/* 212 */         func_187456_a(p_187457_7_, p_187457_5_, enumhandside);
/*     */       }
/* 214 */     } else if (stack.func_77973_b() instanceof net.minecraft.item.ItemMap) {
/* 215 */       if (flag && this.field_187468_e.func_190926_b()) {
/* 216 */         func_187463_a(p_187457_3_, p_187457_7_, p_187457_5_);
/*     */       } else {
/* 218 */         func_187465_a(p_187457_7_, enumhandside, p_187457_5_, stack);
/*     */       }
/*     */     
/* 221 */     } else if (!(stack.func_77973_b() instanceof net.minecraft.item.ItemShield)) {
/*     */       
/* 223 */       KillAura killAura = (KillAura)Retreat.moduleManager.getModule(KillAura.class);
/*     */       
/* 225 */       Animations anim = (Animations)Retreat.moduleManager.getModule(Animations.class);
/*     */       
/* 227 */       boolean flag1 = (enumhandside == EnumHandSide.RIGHT);
/*     */       
/* 229 */       if (player.func_184587_cr() && player.func_184605_cv() > 0 && player.func_184600_cs() == hand) {
/* 230 */         float f5, f6; int j = flag1 ? 1 : -1;
/*     */         
/* 232 */         EnumAction enumaction = killAura.getBlockingStatus() ? EnumAction.BLOCK : stack.func_77975_n();
/*     */         
/* 234 */         switch (enumaction) {
/*     */           case NONE:
/* 236 */             func_187459_b(enumhandside, p_187457_7_);
/*     */             break;
/*     */           case BLOCK:
/* 239 */             transformSideFirstPersonBlock(enumhandside, p_187457_7_, p_187457_5_);
/*     */             break;
/*     */           
/*     */           case EAT:
/*     */           case DRINK:
/* 244 */             func_187454_a(p_187457_2_, enumhandside, stack);
/* 245 */             func_187459_b(enumhandside, p_187457_7_);
/*     */             break;
/*     */           case BOW:
/* 248 */             func_187459_b(enumhandside, p_187457_7_);
/* 249 */             GlStateManager.func_179109_b(j * -0.2785682F, 0.18344387F, 0.15731531F);
/* 250 */             GlStateManager.func_179114_b(-13.935F, 1.0F, 0.0F, 0.0F);
/* 251 */             GlStateManager.func_179114_b(j * 35.3F, 0.0F, 1.0F, 0.0F);
/* 252 */             GlStateManager.func_179114_b(j * -9.785F, 0.0F, 0.0F, 1.0F);
/* 253 */             f5 = stack.func_77988_m() - this.field_78455_a.field_71439_g.func_184605_cv() - p_187457_2_ + 1.0F;
/* 254 */             f6 = f5 / 20.0F;
/* 255 */             f6 = (f6 * f6 + f6 * 2.0F) / 3.0F;
/*     */             
/* 257 */             if (f6 > 1.0F) {
/* 258 */               f6 = 1.0F;
/*     */             }
/*     */             
/* 261 */             if (f6 > 0.1F) {
/* 262 */               float f7 = MathHelper.func_76126_a((f5 - 0.1F) * 1.3F);
/* 263 */               float f3 = f6 - 0.1F;
/* 264 */               float f4 = f7 * f3;
/* 265 */               GlStateManager.func_179109_b(f4 * 0.0F, f4 * 0.004F, f4 * 0.0F);
/*     */             } 
/*     */             
/* 268 */             GlStateManager.func_179109_b(f6 * 0.0F, f6 * 0.0F, f6 * 0.04F);
/* 269 */             GlStateManager.func_179152_a(1.0F, 1.0F, 1.0F + f6 * 0.2F);
/* 270 */             GlStateManager.func_179114_b(j * 45.0F, 0.0F, -1.0F, 0.0F);
/*     */             break;
/*     */         } 
/* 273 */       } else if (this.field_78455_a.field_71439_g.func_184614_ca().func_77973_b() != null && this.field_78455_a.field_71439_g.func_184614_ca().func_77973_b() instanceof net.minecraft.item.ItemSword && ((killAura
/* 274 */         .getTarget() != null && killAura.getBlockingStatus()) || this.field_78455_a.field_71474_y.field_74313_G.field_74513_e) && anim
/* 275 */         .getState()) {
/* 276 */         GlStateManager.func_179109_b(((Float)Animations.xValue.get()).floatValue(), ((Float)Animations.yValue.get()).floatValue(), ((Float)Animations.zValue.get()).floatValue());
/* 277 */         float SP = ((Boolean)Animations.SPValue.get()).booleanValue() ? p_187457_7_ : 0.0F;
/* 278 */         if (((String)Animations.Sword.get()).equals("1.7")) {
/* 279 */           transformSideFirstPersonBlock(enumhandside, SP, p_187457_5_);
/*     */         }
/* 281 */         if (((String)Animations.Sword.get()).equals("Old")) {
/* 282 */           transformSideFirstPersonBlock(enumhandside, -0.1F + SP, p_187457_5_);
/*     */         }
/*     */         
/* 285 */         if (((String)Animations.Sword.get()).equals("Push")) {
/* 286 */           Push(enumhandside, SP, p_187457_5_);
/*     */         }
/* 288 */         if (((String)Animations.Sword.get()).equals("WindMill")) {
/* 289 */           WindMill(enumhandside, -0.2F + SP, p_187457_5_);
/*     */         }
/*     */         
/* 292 */         if (((String)Animations.Sword.get()).equals("Smooth")) {
/* 293 */           SmoothBlock(enumhandside, SP, p_187457_5_);
/*     */         }
/*     */         
/* 296 */         if (((String)Animations.Sword.get()).equals("Flux")) {
/* 297 */           Flux(enumhandside, SP, p_187457_5_);
/*     */         }
/* 299 */         if (((String)Animations.Sword.get()).equals("test")) {
/* 300 */           test(enumhandside, SP, p_187457_5_);
/*     */         }
/* 302 */         if (((String)Animations.Sword.get()).equals("BigGod")) {
/* 303 */           ETB(enumhandside, SP, p_187457_5_);
/*     */         }
/*     */         
/* 306 */         if (((String)Animations.Sword.get()).equals("avatar")) {
/* 307 */           avatar(enumhandside, SP, p_187457_5_);
/*     */         }
/* 309 */         if (((String)Animations.Sword.get()).equals("SigmaOld")) {
/* 310 */           sigmaold(enumhandside, SP, p_187457_5_);
/*     */         }
/* 312 */         if (((String)Animations.Sword.get()).equals("Tap")) {
/* 313 */           tap(enumhandside, SP, p_187457_5_);
/*     */         }
/* 315 */         if (((String)Animations.Sword.get()).equals("Zoom")) {
/* 316 */           Zoom(enumhandside, SP, p_187457_5_);
/*     */         }
/* 318 */         if (((String)Animations.Sword.get()).equals("Jello")) {
/* 319 */           jello(enumhandside, SP, p_187457_5_);
/*     */         }
/* 321 */         GlStateManager.func_179152_a(((Float)Animations.scaleValue.get()).floatValue(), ((Float)Animations.scaleValue.get()).floatValue(), ((Float)Animations.scaleValue.get()).floatValue());
/*     */       } else {
/* 323 */         if (((Boolean)Animations.heldValue.get()).booleanValue()) {
/* 324 */           GlStateManager.func_179109_b(((Float)Animations.xhValue.get()).floatValue(), ((Float)Animations.yhValue.get()).floatValue(), ((Float)Animations.zhValue.get()).floatValue());
/*     */         }
/* 326 */         float f = -0.4F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_187457_5_) * 3.1415927F);
/* 327 */         float f1 = 0.2F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_187457_5_) * 6.2831855F);
/* 328 */         float f2 = -0.2F * MathHelper.func_76126_a(p_187457_5_ * 3.1415927F);
/* 329 */         int i = flag1 ? 1 : -1;
/* 330 */         GlStateManager.func_179109_b(i * f, f1, f2);
/* 331 */         func_187459_b(enumhandside, p_187457_7_);
/* 332 */         func_187453_a(enumhandside, p_187457_5_);
/* 333 */         rotateItemAnim();
/* 334 */         if (((Boolean)Animations.heldValue.get()).booleanValue()) {
/* 335 */           GlStateManager.func_179152_a(((Float)Animations.scalehValue.get()).floatValue(), ((Float)Animations.scalehValue.get()).floatValue(), ((Float)Animations.scalehValue.get()).floatValue());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 340 */       func_187462_a((EntityLivingBase)player, stack, flag1 ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !flag1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 345 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   private void Zoom(float p_178096_1_, float p_178096_2_) {
/* 349 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/* 350 */     GlStateManager.func_179109_b(0.0F, p_178096_1_ * -0.6F, 0.0F);
/* 351 */     GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
/* 352 */     float var3 = MathHelper.func_76126_a(p_178096_2_ * p_178096_2_ * 3.1415927F);
/* 353 */     float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(p_178096_2_) * 3.1415927F);
/* 354 */     GlStateManager.func_179114_b(var3 * -20.0F, 0.0F, 0.0F, 0.0F);
/* 355 */     GlStateManager.func_179114_b(var4 * -20.0F, 0.0F, 0.0F, 0.0F);
/* 356 */     GlStateManager.func_179114_b(var4 * -20.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   private void tap(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 360 */     float smooth = swingProgress * 0.8F - swingProgress * swingProgress * 0.8F;
/* 361 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/* 362 */     GlStateManager.func_179109_b(0.0F, equippedProg * -0.15F, 0.0F);
/* 363 */     GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
/* 364 */     float var3 = MathHelper.func_76126_a(swingProgress * swingProgress * 3.1415927F);
/* 365 */     float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(swingProgress) * 3.1415927F);
/* 366 */     GlStateManager.func_179114_b(smooth * -90.0F, 0.0F, 1.0F, 0.0F);
/* 367 */     GlStateManager.func_179152_a(0.37F, 0.37F, 0.37F);
/*     */   }
/*     */   
/*     */   private void rotateItemAnim() {
/* 371 */     if (((String)Animations.transformFirstPersonRotate.get()).equalsIgnoreCase("RotateY")) {
/* 372 */       GlStateManager.func_179114_b(this.delay, 0.0F, 1.0F, 0.0F);
/*     */     }
/* 374 */     if (((String)Animations.transformFirstPersonRotate.get()).equalsIgnoreCase("RotateXY")) {
/* 375 */       GlStateManager.func_179114_b(this.delay, 1.0F, 1.0F, 0.0F);
/*     */     }
/*     */     
/* 378 */     if (((String)Animations.transformFirstPersonRotate.get()).equalsIgnoreCase("Custom")) {
/* 379 */       GlStateManager.func_179114_b(this.delay, ((Float)Animations.customRotate1.get()).floatValue(), ((Float)Animations.customRotate2.get()).floatValue(), ((Float)Animations.customRotate3.get()).floatValue());
/*     */     }
/*     */     
/* 382 */     if (this.rotateTimer.hasTimePassed(1L)) {
/* 383 */       this.delay++;
/* 384 */       this.delay += ((Float)Animations.SpeedRotate.get()).floatValue();
/* 385 */       this.rotateTimer.reset();
/*     */     } 
/* 387 */     if (this.delay > 360.0F) {
/* 388 */       this.delay = 0.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void Zoom(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 394 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/* 395 */     GlStateManager.func_179109_b(0.0F, equippedProg * -0.6F, 0.0F);
/* 396 */     GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
/* 397 */     float var3 = MathHelper.func_76126_a(swingProgress * swingProgress * 3.1415927F);
/* 398 */     float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(swingProgress) * 3.1415927F);
/* 399 */     GlStateManager.func_179114_b(var3 * -20.0F, 0.0F, 0.0F, 0.0F);
/* 400 */     GlStateManager.func_179114_b(var4 * -20.0F, 0.0F, 0.0F, 0.0F);
/* 401 */     GlStateManager.func_179114_b(var4 * -20.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   private void ETB(EnumHandSide p_187459_1_, float equipProgress, float swingProgress) {
/* 405 */     GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
/* 406 */     GlStateManager.func_179109_b(0.0F, equipProgress * -0.6F, 0.0F);
/* 407 */     GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
/* 408 */     double f = Math.sin((swingProgress * swingProgress * 3.1415927F));
/* 409 */     double f1 = Math.sin(Math.sqrt(swingProgress) * 3.1415927410125732D);
/* 410 */     GlStateManager.func_179114_b((float)(f * -34.0D), 0.0F, 1.0F, 0.2F);
/* 411 */     GlStateManager.func_179114_b((float)(f1 * -20.700000762939453D), 0.2F, 0.1F, 1.0F);
/* 412 */     GlStateManager.func_179114_b((float)(f1 * -68.5999984741211D), 1.3F, 0.1F, 0.2F);
/*     */   }
/*     */   
/*     */   private void avatar(EnumHandSide p_187459_1_, float equippedProg, float swingProgress) {
/* 416 */     GlStateManager.func_179109_b(0.0F, 0.0F, 0.0F);
/* 417 */     GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
/* 418 */     float f = MathHelper.func_76126_a(swingProgress * swingProgress * 3.1415927F);
/* 419 */     float f2 = MathHelper.func_76126_a(MathHelper.func_76129_c(swingProgress) * 3.1415927F);
/* 420 */     GlStateManager.func_179114_b(f * -20.0F, 0.0F, 1.0F, 0.0F);
/* 421 */     GlStateManager.func_179114_b(f2 * -20.0F, 0.0F, 0.0F, 1.0F);
/* 422 */     GlStateManager.func_179114_b(f2 * -40.0F, 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"renderFireInFirstPerson"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void renderFireInFirstPerson(CallbackInfo callbackInfo) {
/* 432 */     AntiBlind antiBlind = (AntiBlind)Retreat.moduleManager.getModule(AntiBlind.class);
/*     */     
/* 434 */     if (antiBlind.getState() && ((Boolean)antiBlind.getFireEffect().get()).booleanValue()) callbackInfo.cancel(); 
/*     */   }
/*     */   
/*     */   @Overwrite
/*     */   public void func_78441_a() {
/* 439 */     Animations oldhiting = (Animations)Retreat.moduleManager.getModule(Animations.class);
/*     */     
/* 441 */     this.field_187470_g = this.field_187469_f;
/* 442 */     this.field_187472_i = this.field_187471_h;
/* 443 */     EntityPlayerSP entityplayersp = this.field_78455_a.field_71439_g;
/* 444 */     ItemStack itemstack = entityplayersp.func_184614_ca();
/* 445 */     ItemStack itemstack1 = entityplayersp.func_184592_cb();
/* 446 */     if (entityplayersp.func_184838_M()) {
/* 447 */       this.field_187469_f = MathHelper.func_76131_a(this.field_187469_f - 0.4F, 0.0F, 1.0F);
/* 448 */       this.field_187471_h = MathHelper.func_76131_a(this.field_187471_h - 0.4F, 0.0F, 1.0F);
/*     */     } else {
/* 450 */       float f = entityplayersp.func_184825_o(1.0F);
/* 451 */       boolean requipM = ForgeHooksClient.shouldCauseReequipAnimation(this.field_187467_d, itemstack, entityplayersp.field_71071_by.field_70461_c);
/* 452 */       boolean requipO = ForgeHooksClient.shouldCauseReequipAnimation(this.field_187468_e, itemstack1, -1);
/* 453 */       if (!requipM && !Objects.equals(this.field_187467_d, itemstack)) {
/* 454 */         this.field_187467_d = itemstack;
/*     */       }
/*     */       
/* 457 */       if (!requipM && !Objects.equals(this.field_187468_e, itemstack1)) {
/* 458 */         this.field_187468_e = itemstack1;
/*     */       }
/*     */       
/* 461 */       float number = ((Boolean)Animations.oldSPValue.get()).booleanValue() ? 1.0F : (f * f * f);
/* 462 */       this.field_187469_f += MathHelper.func_76131_a((!requipM ? number : 0.0F) - this.field_187469_f, -0.4F, 0.4F);
/* 463 */       this.field_187471_h += MathHelper.func_76131_a((!requipO ? true : false) - this.field_187471_h, -0.4F, 0.4F);
/*     */     } 
/*     */     
/* 466 */     if (this.field_187469_f < 0.1F) {
/* 467 */       this.field_187467_d = itemstack;
/*     */     }
/*     */     
/* 470 */     if (this.field_187471_h < 0.1F)
/* 471 */       this.field_187468_e = itemstack1; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\item\MixinItemRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */