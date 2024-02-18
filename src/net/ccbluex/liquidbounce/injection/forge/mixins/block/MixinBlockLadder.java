/*    */ package net.ccbluex.liquidbounce.injection.forge.mixins.block;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.FastClimb;
/*    */ import net.minecraft.block.BlockLadder;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.properties.PropertyDirection;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Overwrite;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ @Mixin({BlockLadder.class})
/*    */ public abstract class MixinBlockLadder
/*    */   extends MixinBlock
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   public static PropertyDirection field_176382_a;
/*    */   @Shadow
/*    */   @Final
/*    */   protected static AxisAlignedBB field_185690_e;
/*    */   @Shadow
/*    */   @Final
/*    */   protected static AxisAlignedBB field_185689_d;
/*    */   @Shadow
/*    */   @Final
/*    */   protected static AxisAlignedBB field_185688_c;
/*    */   @Shadow
/*    */   @Final
/*    */   protected static AxisAlignedBB field_185687_b;
/*    */   
/*    */   @Overwrite
/*    */   public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) {
/* 50 */     if (state.func_177230_c() instanceof BlockLadder) {
/* 51 */       FastClimb fastClimb = (FastClimb)Retreat.moduleManager.getModule(FastClimb.class);
/* 52 */       boolean fastLadder = (((FastClimb)Objects.<FastClimb>requireNonNull(fastClimb)).getState() && ((String)fastClimb.getModeValue().get()).equalsIgnoreCase("AAC3.0.0"));
/* 53 */       float f = 0.99F;
/*    */       
/* 55 */       if (fastLadder) {
/* 56 */         switch ((EnumFacing)state.func_177229_b((IProperty)field_176382_a)) {
/*    */           case NORTH:
/* 58 */             return new AxisAlignedBB(0.0D, 0.0D, 0.009999990463256836D, 1.0D, 1.0D, 1.0D);
/*    */           case SOUTH:
/* 60 */             return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.9900000095367432D);
/*    */           case WEST:
/* 62 */             return new AxisAlignedBB(0.009999990463256836D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*    */         } 
/*    */         
/* 65 */         return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.9900000095367432D, 1.0D, 1.0D);
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 71 */     switch ((EnumFacing)state.func_177229_b((IProperty)field_176382_a)) {
/*    */       case NORTH:
/* 73 */         return field_185690_e;
/*    */       case SOUTH:
/* 75 */         return field_185689_d;
/*    */       case WEST:
/* 77 */         return field_185688_c;
/*    */     } 
/*    */     
/* 80 */     return field_185687_b;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\block\MixinBlockLadder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */