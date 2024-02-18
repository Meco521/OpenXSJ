/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.render;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Queues;
/*    */ import java.util.ArrayDeque;
/*    */ import java.util.ConcurrentModificationException;
/*    */ import java.util.List;
/*    */ import java.util.Queue;
/*    */ import net.minecraft.client.particle.Particle;
/*    */ import net.minecraft.client.particle.ParticleEmitter;
/*    */ import net.minecraft.client.particle.ParticleManager;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({ParticleManager.class})
/*    */ public abstract class MixinEffectRenderer
/*    */ {
/*    */   @Shadow
/*    */   @Final
/* 26 */   private final Queue<ParticleEmitter> field_178933_d = Queues.newArrayDeque();
/*    */   
/*    */   @Shadow
/*    */   @Final
/*    */   private Queue<Particle> field_187241_h;
/*    */   
/*    */   @Shadow
/*    */   @Final
/*    */   private ArrayDeque<Particle>[][] field_78876_b;
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   protected abstract void func_178922_a(int paramInt);
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   public void func_78868_a() {
/*    */     try {
/* 44 */       for (int i = 0; i < 4; i++) {
/* 45 */         func_178922_a(i);
/*    */       }
/*    */       
/* 48 */       if (!this.field_178933_d.isEmpty()) {
/* 49 */         List<ParticleEmitter> list = Lists.newArrayList();
/*    */         
/* 51 */         for (ParticleEmitter particleemitter : this.field_178933_d) {
/* 52 */           particleemitter.func_189213_a();
/*    */           
/* 54 */           if (!particleemitter.func_187113_k()) {
/* 55 */             list.add(particleemitter);
/*    */           }
/*    */         } 
/*    */         
/* 59 */         this.field_178933_d.removeAll(list);
/*    */       } 
/*    */       
/* 62 */       if (!this.field_187241_h.isEmpty()) {
/* 63 */         for (Particle particle = this.field_187241_h.poll(); particle != null; particle = this.field_187241_h.poll()) {
/* 64 */           int j = particle.func_70537_b();
/* 65 */           int k = particle.func_187111_c() ? 0 : 1;
/*    */           
/* 67 */           if (this.field_78876_b[j][k].size() >= 16384) {
/* 68 */             this.field_78876_b[j][k].removeFirst();
/*    */           }
/*    */           
/* 71 */           this.field_78876_b[j][k].add(particle);
/*    */         } 
/*    */       }
/* 74 */     } catch (ConcurrentModificationException concurrentModificationException) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\render\MixinEffectRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */