/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\007\n\002\b\007\n\002\020\006\n\002\b\020\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\006\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020#\032\0020\0062\b\020$\032\004\030\0010%H\002J0\020&\032\0020'2\006\020(\032\0020)2\006\020*\032\0020\0242\006\020+\032\0020\0242\006\020,\032\0020\0242\006\020-\032\0020\fH\026J \020.\032\0020\0062\006\020(\032\0020/2\006\0200\032\0020\f2\006\0201\032\0020\006H\026J8\0202\032\0020\0062\006\0203\032\002042\006\0205\032\0020\0242\006\0206\032\0020\0242\006\0207\032\0020\0242\006\0208\032\0020\f2\006\0209\032\0020\fH\026R$\020\007\032\0020\0062\006\020\005\032\0020\0068V@VX\016¢\006\f\032\004\b\007\020\b\"\004\b\t\020\nR\024\020\013\032\0020\f8VX\004¢\006\006\032\004\b\r\020\016R$\020\017\032\0020\f2\006\020\005\032\0020\f8V@VX\016¢\006\f\032\004\b\020\020\016\"\004\b\021\020\022R\024\020\023\032\0020\0248VX\004¢\006\006\032\004\b\025\020\026R\024\020\027\032\0020\0248VX\004¢\006\006\032\004\b\030\020\026R\024\020\031\032\0020\0248VX\004¢\006\006\032\004\b\032\020\026R\024\020\033\032\0020\0248VX\004¢\006\006\032\004\b\034\020\026R\024\020\035\032\0020\0248VX\004¢\006\006\032\004\b\036\020\026R\024\020\037\032\0020\0248VX\004¢\006\006\032\004\b \020\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b!\020\"¨\006:"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/RenderManagerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;", "wrapped", "Lnet/minecraft/client/renderer/entity/RenderManager;", "(Lnet/minecraft/client/renderer/entity/RenderManager;)V", "value", "", "isRenderShadow", "()Z", "setRenderShadow", "(Z)V", "playerViewX", "", "getPlayerViewX", "()F", "playerViewY", "getPlayerViewY", "setPlayerViewY", "(F)V", "renderPosX", "", "getRenderPosX", "()D", "renderPosY", "getRenderPosY", "renderPosZ", "getRenderPosZ", "viewerPosX", "getViewerPosX", "viewerPosY", "getViewerPosY", "viewerPosZ", "getViewerPosZ", "getWrapped", "()Lnet/minecraft/client/renderer/entity/RenderManager;", "equals", "other", "", "renderEntityAt", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "x", "y", "z", "partialTicks", "renderEntityStatic", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "renderPartialTicks", "hideDebugBox", "renderEntityWithPosYaw", "entityLivingBase", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "d", "d1", "d2", "fl", "fl1", "XSJClient"})
/*    */ public final class RenderManagerImpl implements IRenderManager {
/*    */   @NotNull
/* 11 */   public final RenderManager getWrapped() { return this.wrapped; } @NotNull private final RenderManager wrapped; public RenderManagerImpl(@NotNull RenderManager wrapped) { this.wrapped = wrapped; }
/*    */    public boolean isRenderShadow() {
/* 13 */     return this.wrapped.func_178627_a();
/*    */   } public void setRenderShadow(boolean value) {
/* 15 */     this.wrapped.func_178633_a(value);
/*    */   }
/*    */   public double getViewerPosX() {
/* 18 */     return this.wrapped.field_78730_l;
/*    */   } public double getViewerPosY() {
/* 20 */     return this.wrapped.field_78731_m;
/*    */   } public double getViewerPosZ() {
/* 22 */     return this.wrapped.field_78728_n;
/*    */   } public float getPlayerViewX() {
/* 24 */     return this.wrapped.field_78732_j;
/*    */   } public float getPlayerViewY() {
/* 26 */     return this.wrapped.field_78735_i;
/*    */   } public void setPlayerViewY(float value) {
/* 28 */     this.wrapped.func_178631_a(value);
/*    */   }
/*    */   public double getRenderPosX() {
/* 31 */     return this.wrapped.field_78725_b;
/*    */   } public double getRenderPosY() {
/* 33 */     return this.wrapped.field_78726_c;
/*    */   } public double getRenderPosZ() {
/* 35 */     return this.wrapped.field_78723_d;
/*    */   }
/*    */   
/* 38 */   public boolean renderEntityStatic(@NotNull IEntity entity, float renderPartialTicks, boolean hideDebugBox) { Intrinsics.checkParameterIsNotNull(entity, "entity"); IEntity iEntity = entity; RenderManager renderManager = this.wrapped; int $i$f$unwrap = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 59 */     Entity entity1 = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); renderManager.func_188388_a(entity1, renderPartialTicks, hideDebugBox); return true; } public void renderEntityAt(@NotNull ITileEntity entity, double x, double y, double z, float partialTicks) { Intrinsics.checkParameterIsNotNull(entity, "entity"); ITileEntity iTileEntity = entity; TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.field_147556_a; int $i$f$unwrap = 0;
/* 60 */     TileEntity tileEntity = ((TileEntityImpl)iTileEntity).getWrapped(); tileEntityRendererDispatcher.func_147549_a(tileEntity, x, y, z, partialTicks); } public boolean renderEntityWithPosYaw(@NotNull IEntityLivingBase entityLivingBase, double d, double d1, double d2, float fl, float fl1) { Intrinsics.checkParameterIsNotNull(entityLivingBase, "entityLivingBase"); IEntityLivingBase iEntityLivingBase = entityLivingBase; RenderManager renderManager = this.wrapped; int $i$f$unwrap = 0;
/* 61 */     EntityLivingBase entityLivingBase1 = ((EntityLivingBaseImpl<EntityLivingBase>)iEntityLivingBase).getWrapped(); renderManager.func_188391_a((Entity)entityLivingBase1, d, d1, d2, fl, fl1, true);
/*    */     return true; }
/*    */ 
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof RenderManagerImpl && Intrinsics.areEqual(((RenderManagerImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\RenderManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */