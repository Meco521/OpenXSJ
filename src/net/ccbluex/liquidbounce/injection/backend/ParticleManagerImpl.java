/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.IParticleManager;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.minecraft.client.particle.ParticleManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.EnumParticleTypes;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\006\n\002\b\007\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\030\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\fH\026JH\020\r\032\0020\b2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\006\020\022\032\0020\0212\006\020\023\032\0020\0212\006\020\024\032\0020\0212\006\020\025\032\0020\0212\006\020\026\032\0020\0212\006\020\027\032\0020\017H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ParticleManagerImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/IParticleManager;", "wrapped", "Lnet/minecraft/client/particle/ParticleManager;", "(Lnet/minecraft/client/particle/ParticleManager;)V", "getWrapped", "()Lnet/minecraft/client/particle/ParticleManager;", "emitParticleAtEntity", "", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "buffer", "Lnet/minecraft/util/EnumParticleTypes;", "spawnEffectParticle", "particleID", "", "posX", "", "posY", "posZ", "motionX", "motionY", "motionZ", "StateId", "XSJClient"})
/*    */ public final class ParticleManagerImpl implements IParticleManager {
/*    */   @NotNull
/* 14 */   public final ParticleManager getWrapped() { return this.wrapped; } @NotNull private final ParticleManager wrapped; public ParticleManagerImpl(@NotNull ParticleManager wrapped) { this.wrapped = wrapped; } public void emitParticleAtEntity(@NotNull IEntity entity, @NotNull EnumParticleTypes buffer) {
/* 15 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); Intrinsics.checkParameterIsNotNull(buffer, "buffer"); IEntity iEntity = entity; ParticleManager particleManager = this.wrapped; int $i$f$unwrap = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 23 */     Entity entity1 = (Entity)((EntityImpl<Object>)iEntity).getWrapped(); particleManager.func_178926_a(entity1, buffer);
/*    */   }
/*    */   
/*    */   public void spawnEffectParticle(int particleID, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, int StateId) {
/*    */     this.wrapped.func_178927_a(particleID, posX, posY, posZ, motionX, motionY, motionZ, new int[] { StateId });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ParticleManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */