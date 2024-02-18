/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*     */ 
/*     */ import com.google.common.base.Predicates;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.Reach;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.CameraClip;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.NoHurtCam;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Tracers;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ActiveRenderInfo;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.util.EntitySelectors;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.ForgeHooksClient;
/*     */ import net.minecraftforge.client.event.EntityViewRenderEvent;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ @Mixin({EntityRenderer.class})
/*     */ public abstract class MixinEntityRenderer
/*     */ {
/*     */   @Shadow
/*     */   private Entity field_78528_u;
/*     */   @Final
/*     */   @Shadow
/*     */   private Minecraft field_78531_r;
/*     */   @Final
/*     */   @Shadow
/*     */   private float field_78490_B;
/*     */   
/*     */   @Inject(method = {"renderWorldPass"}, at = {@At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z", shift = At.Shift.BEFORE)})
/*     */   private void renderWorldPass(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
/*  63 */     Retreat.eventManager.callEvent((Event)new Render3DEvent(partialTicks)); } @Shadow
/*     */   private boolean field_78500_U; @Shadow
/*     */   private float field_78491_C; @Shadow
/*     */   public abstract void func_175069_a(ResourceLocation paramResourceLocation); @Shadow
/*     */   public abstract void func_78479_a(float paramFloat, int paramInt); @Inject(method = {"hurtCameraEffect"}, at = {@At("HEAD")}, cancellable = true)
/*  68 */   private void injectHurtCameraEffect(CallbackInfo callbackInfo) { if (Retreat.moduleManager.getModule(NoHurtCam.class).getState())
/*  69 */       callbackInfo.cancel();  }
/*     */ 
/*     */   
/*     */   @Inject(method = {"orientCamera"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/util/math/Vec3d;distanceTo(Lnet/minecraft/util/math/Vec3d;)D")}, cancellable = true)
/*     */   private void cameraClip(float partialTicks, CallbackInfo callbackInfo) {
/*  74 */     if (Retreat.moduleManager.getModule(CameraClip.class).getState()) {
/*  75 */       callbackInfo.cancel();
/*     */       
/*  77 */       Entity entity = this.field_78531_r.func_175606_aa();
/*  78 */       float f = entity.func_70047_e();
/*     */       
/*  80 */       if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).func_70608_bn()) {
/*  81 */         f = (float)(f + 1.0D);
/*  82 */         GlStateManager.func_179109_b(0.0F, 0.3F, 0.0F);
/*     */         
/*  84 */         if (!this.field_78531_r.field_71474_y.field_74325_U) {
/*  85 */           BlockPos blockpos = new BlockPos(entity);
/*  86 */           IBlockState iblockstate = this.field_78531_r.field_71441_e.func_180495_p(blockpos);
/*  87 */           ForgeHooksClient.orientBedCamera((IBlockAccess)this.field_78531_r.field_71441_e, blockpos, iblockstate, entity);
/*     */           
/*  89 */           GlStateManager.func_179114_b(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * partialTicks + 180.0F, 0.0F, -1.0F, 0.0F);
/*  90 */           GlStateManager.func_179114_b(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * partialTicks, -1.0F, 0.0F, 0.0F);
/*     */         } 
/*  92 */       } else if (this.field_78531_r.field_71474_y.field_74320_O > 0) {
/*  93 */         double d3 = (this.field_78491_C + (this.field_78490_B - this.field_78491_C) * partialTicks);
/*     */         
/*  95 */         if (this.field_78531_r.field_71474_y.field_74325_U) {
/*  96 */           GlStateManager.func_179109_b(0.0F, 0.0F, (float)-d3);
/*     */         } else {
/*  98 */           float f1 = entity.field_70177_z;
/*  99 */           float f2 = entity.field_70125_A;
/*     */           
/* 101 */           if (this.field_78531_r.field_71474_y.field_74320_O == 2) {
/* 102 */             f2 += 180.0F;
/*     */           }
/* 104 */           if (this.field_78531_r.field_71474_y.field_74320_O == 2) {
/* 105 */             GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
/*     */           }
/* 107 */           GlStateManager.func_179114_b(entity.field_70125_A - f2, 1.0F, 0.0F, 0.0F);
/* 108 */           GlStateManager.func_179114_b(entity.field_70177_z - f1, 0.0F, 1.0F, 0.0F);
/* 109 */           GlStateManager.func_179109_b(0.0F, 0.0F, (float)-d3);
/* 110 */           GlStateManager.func_179114_b(f1 - entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 111 */           GlStateManager.func_179114_b(f2 - entity.field_70125_A, 1.0F, 0.0F, 0.0F);
/*     */         } 
/*     */       } else {
/* 114 */         GlStateManager.func_179109_b(0.0F, 0.0F, -0.1F);
/*     */       } 
/* 116 */       if (!this.field_78531_r.field_71474_y.field_74325_U) {
/* 117 */         float yaw = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * partialTicks + 180.0F;
/* 118 */         float pitch = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * partialTicks;
/* 119 */         float roll = 0.0F;
/* 120 */         if (entity instanceof EntityAnimal) {
/* 121 */           EntityAnimal entityanimal = (EntityAnimal)entity;
/* 122 */           yaw = entityanimal.field_70758_at + (entityanimal.field_70759_as - entityanimal.field_70758_at) * partialTicks + 180.0F;
/*     */         } 
/*     */         
/* 125 */         IBlockState block = ActiveRenderInfo.func_186703_a((World)this.field_78531_r.field_71441_e, entity, partialTicks);
/* 126 */         EntityViewRenderEvent.CameraSetup event = new EntityViewRenderEvent.CameraSetup((EntityRenderer)this, entity, block, partialTicks, yaw, pitch, roll);
/* 127 */         MinecraftForge.EVENT_BUS.post((Event)event);
/* 128 */         GlStateManager.func_179114_b(event.getRoll(), 0.0F, 0.0F, 1.0F);
/* 129 */         GlStateManager.func_179114_b(event.getPitch(), 1.0F, 0.0F, 0.0F);
/* 130 */         GlStateManager.func_179114_b(event.getYaw(), 0.0F, 1.0F, 0.0F);
/*     */       } 
/*     */       
/* 133 */       GlStateManager.func_179109_b(0.0F, -f, 0.0F);
/* 134 */       double d0 = entity.field_70169_q + (entity.field_70165_t - entity.field_70169_q) * partialTicks;
/* 135 */       double d1 = entity.field_70167_r + (entity.field_70163_u - entity.field_70167_r) * partialTicks + f;
/* 136 */       double d2 = entity.field_70166_s + (entity.field_70161_v - entity.field_70166_s) * partialTicks;
/* 137 */       this.field_78500_U = this.field_78531_r.field_71438_f.func_72721_a(d0, d1, d2, partialTicks);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"setupCameraTransform"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;applyBobbing(F)V", shift = At.Shift.BEFORE)})
/*     */   private void setupCameraViewBobbingBefore(CallbackInfo callbackInfo) {
/* 143 */     if (Retreat.moduleManager.getModule(Tracers.class).getState()) GL11.glPushMatrix(); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"setupCameraTransform"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;applyBobbing(F)V", shift = At.Shift.AFTER)})
/*     */   private void setupCameraViewBobbingAfter(CallbackInfo callbackInfo) {
/* 148 */     if (Retreat.moduleManager.getModule(Tracers.class).getState()) GL11.glPopMatrix();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public void func_78473_a(float partialTicks) {
/* 157 */     Entity entity = this.field_78531_r.func_175606_aa();
/*     */     
/* 159 */     if (entity != null && 
/* 160 */       this.field_78531_r.field_71441_e != null) {
/* 161 */       this.field_78531_r.field_71424_I.func_76320_a("pick");
/* 162 */       this.field_78531_r.field_147125_j = null;
/*     */       
/* 164 */       Reach reach = (Reach)Retreat.moduleManager.getModule(Reach.class);
/*     */       
/* 166 */       double d0 = reach.getState() ? reach.getMaxRange() : this.field_78531_r.field_71442_b.func_78757_d();
/* 167 */       this.field_78531_r.field_71476_x = entity.func_174822_a(reach.getState() ? ((Float)reach.getBuildReachValue().get()).floatValue() : d0, partialTicks);
/*     */       
/* 169 */       Vec3d vec3d = entity.func_174824_e(partialTicks);
/* 170 */       boolean flag = false;
/* 171 */       int i = 3;
/* 172 */       double d1 = d0;
/*     */       
/* 174 */       if (this.field_78531_r.field_71442_b.func_78749_i()) {
/* 175 */         d1 = 6.0D;
/* 176 */         d0 = d1;
/*     */       }
/* 178 */       else if (d0 > 3.0D) {
/* 179 */         flag = true;
/*     */       } 
/*     */ 
/*     */       
/* 183 */       if (this.field_78531_r.field_71476_x != null) {
/* 184 */         d1 = this.field_78531_r.field_71476_x.field_72307_f.func_72438_d(vec3d);
/*     */       }
/*     */       
/* 187 */       if (reach.getState()) {
/* 188 */         d1 = ((Float)reach.getCombatReachValue().get()).floatValue();
/*     */         
/* 190 */         RayTraceResult movingObjectPosition = entity.func_174822_a(d1, partialTicks);
/*     */         
/* 192 */         if (movingObjectPosition != null) d1 = movingObjectPosition.field_72307_f.func_72438_d(vec3d);
/*     */       
/*     */       } 
/* 195 */       Vec3d vec3d1 = entity.func_70676_i(1.0F);
/* 196 */       Vec3d vec3d2 = vec3d.func_72441_c(vec3d1.field_72450_a * d0, vec3d1.field_72448_b * d0, vec3d1.field_72449_c * d0);
/* 197 */       this.field_78528_u = null;
/* 198 */       Vec3d vec3d3 = null;
/* 199 */       float f = 1.0F;
/* 200 */       List<Entity> list = this.field_78531_r.field_71441_e.func_175674_a(entity, entity.func_174813_aQ().func_72321_a(vec3d1.field_72450_a * d0, vec3d1.field_72448_b * d0, vec3d1.field_72449_c * d0).func_72314_b(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.field_180132_d, p_apply_1_ -> (p_apply_1_ != null && p_apply_1_.func_70067_L())));
/* 201 */       double d2 = d1;
/*     */       
/* 203 */       for (Entity entity1 : list) {
/* 204 */         AxisAlignedBB axisalignedbb = entity1.func_174813_aQ().func_186662_g(entity1.func_70111_Y());
/* 205 */         RayTraceResult raytraceresult = axisalignedbb.func_72327_a(vec3d, vec3d2);
/*     */         
/* 207 */         if (axisalignedbb.func_72318_a(vec3d)) {
/* 208 */           if (d2 >= 0.0D) {
/* 209 */             this.field_78528_u = entity1;
/* 210 */             vec3d3 = (raytraceresult == null) ? vec3d : raytraceresult.field_72307_f;
/* 211 */             d2 = 0.0D;
/*     */           }  continue;
/* 213 */         }  if (raytraceresult != null) {
/* 214 */           double d3 = vec3d.func_72438_d(raytraceresult.field_72307_f);
/*     */           
/* 216 */           if (d3 < d2 || d2 == 0.0D) {
/* 217 */             if (entity1.func_184208_bv() == entity.func_184208_bv() && !entity1.canRiderInteract()) {
/* 218 */               if (d2 == 0.0D) {
/* 219 */                 this.field_78528_u = entity1;
/* 220 */                 vec3d3 = raytraceresult.field_72307_f;
/*     */               }  continue;
/*     */             } 
/* 223 */             this.field_78528_u = entity1;
/* 224 */             vec3d3 = raytraceresult.field_72307_f;
/* 225 */             d2 = d3;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 231 */       if (this.field_78528_u != null && flag && vec3d.func_72438_d(vec3d3) > (reach.getState() ? ((Float)reach.getCombatReachValue().get()).floatValue() : 3.0D)) {
/* 232 */         this.field_78528_u = null;
/* 233 */         this.field_78531_r.field_71476_x = new RayTraceResult(RayTraceResult.Type.MISS, vec3d3, null, new BlockPos(vec3d3));
/*     */       } 
/*     */       
/* 236 */       if (this.field_78528_u != null && (d2 < d1 || this.field_78531_r.field_71476_x == null)) {
/* 237 */         this.field_78531_r.field_71476_x = new RayTraceResult(this.field_78528_u, vec3d3);
/*     */         
/* 239 */         if (this.field_78528_u instanceof EntityLivingBase || this.field_78528_u instanceof net.minecraft.entity.item.EntityItemFrame) {
/* 240 */           this.field_78531_r.field_147125_j = this.field_78528_u;
/*     */         }
/*     */       } 
/*     */       
/* 244 */       this.field_78531_r.field_71424_I.func_76319_b();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinEntityRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */