/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.util;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.injection.implementations.IMixinTimer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.Timer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ @Mixin({Timer.class})
/*    */ public class MixinTimer implements IMixinTimer {
/*    */   @Shadow
/*    */   public float field_194148_c;
/*    */   @Shadow
/*    */   public float field_194147_b;
/*    */   @Shadow
/*    */   public int field_74280_b;
/* 18 */   private float timerSpeed = 1.0F;
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   private long field_74277_g;
/*    */   
/*    */   @Shadow
/*    */   private float field_194149_e;
/*    */ 
/*    */   
/*    */   @Overwrite
/*    */   public void func_74275_a() {
/* 30 */     long i = Minecraft.func_71386_F();
/* 31 */     this.field_194148_c = (float)(i - this.field_74277_g) / this.field_194149_e * this.timerSpeed;
/* 32 */     this.field_74277_g = i;
/* 33 */     this.field_194147_b += this.field_194148_c;
/* 34 */     this.field_74280_b = (int)this.field_194147_b;
/* 35 */     this.field_194147_b -= this.field_74280_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getTimerSpeed() {
/* 40 */     return this.timerSpeed;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setTimerSpeed(float timerSpeed) {
/* 45 */     this.timerSpeed = timerSpeed;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixin\\util\MixinTimer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */