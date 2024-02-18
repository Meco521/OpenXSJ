/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.world;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.render.ProphuntESP;
/*    */ import net.ccbluex.liquidbounce.injection.backend.ChunkImplKt;
/*    */ import net.ccbluex.liquidbounce.injection.backend.utils.BackendExtentionsKt;
/*    */ import net.ccbluex.liquidbounce.utils.render.MiniMapRegister;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({Chunk.class})
/*    */ public class MixinChunk
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   public int field_76635_g;
/*    */   @Shadow
/*    */   @Final
/*    */   public int field_76647_h;
/*    */   
/*    */   @Inject(method = {"setBlockState"}, at = {@At("HEAD")})
/*    */   private void setProphuntBlock(BlockPos pos, IBlockState state, CallbackInfoReturnable callbackInfo) {
/* 36 */     MiniMapRegister.INSTANCE.updateChunk(ChunkImplKt.wrap((Chunk)this));
/*    */     
/* 38 */     ProphuntESP prophuntESP = (ProphuntESP)Retreat.moduleManager.getModule(ProphuntESP.class);
/*    */     
/* 40 */     if (((ProphuntESP)Objects.<ProphuntESP>requireNonNull(prophuntESP)).getState()) {
/* 41 */       synchronized (prophuntESP.getBlocks()) {
/* 42 */         prophuntESP.getBlocks().put(BackendExtentionsKt.wrap(pos), Long.valueOf(System.currentTimeMillis()));
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"onUnload"}, at = {@At("HEAD")})
/*    */   private void injectFillChunk(CallbackInfo ci) {
/* 49 */     MiniMapRegister.INSTANCE.unloadChunk(this.field_76635_g, this.field_76647_h);
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"read"}, at = {@At("RETURN")})
/*    */   private void injectFillChunk(PacketBuffer buf, int availableSections, boolean groundUpContinuous, CallbackInfo ci) {
/* 55 */     MiniMapRegister.INSTANCE.updateChunk(ChunkImplKt.wrap((Chunk)this));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\world\MixinChunk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */