/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.block;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import javax.annotation.Nullable;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.BlockBBEvent;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.Criticals;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.NoFall;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.XRay;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.world.NoSlowBreak;
/*     */ import net.ccbluex.liquidbounce.injection.backend.AxisAlignedBBImplKt;
/*     */ import net.ccbluex.liquidbounce.injection.backend.BlockImplKt;
/*     */ import net.ccbluex.liquidbounce.injection.backend.utils.BackendExtentionsKt;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.BlockStateContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({Block.class})
/*     */ public abstract class MixinBlock
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   protected BlockStateContainer field_176227_L;
/*     */   
/*     */   @Overwrite
/*     */   protected static void func_185492_a(BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable AxisAlignedBB blockBox) {
/*  53 */     if (blockBox != null) {
/*  54 */       AxisAlignedBB axisalignedbb = blockBox.func_186670_a(pos);
/*     */       
/*  56 */       WorldClient world = (Minecraft.func_71410_x()).field_71441_e;
/*     */       
/*  58 */       if (world != null) {
/*  59 */         BlockBBEvent blockBBEvent = new BlockBBEvent(BackendExtentionsKt.wrap(pos), BlockImplKt.wrap(world.func_180495_p(pos).func_177230_c()), AxisAlignedBBImplKt.wrap(axisalignedbb));
/*  60 */         Retreat.eventManager.callEvent((Event)blockBBEvent);
/*     */         
/*  62 */         axisalignedbb = (blockBBEvent.getBoundingBox() == null) ? null : AxisAlignedBBImplKt.unwrap(blockBBEvent.getBoundingBox());
/*     */       } 
/*     */       
/*  65 */       if (axisalignedbb != null && entityBox.func_72326_a(axisalignedbb)) {
/*  66 */         collidingBoxes.add(axisalignedbb);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Shadow
/*     */   public abstract AxisAlignedBB func_180646_a(IBlockState paramIBlockState, IBlockAccess paramIBlockAccess, BlockPos paramBlockPos);
/*     */   
/*     */   @Shadow
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
/*  77 */     return null;
/*     */   }
/*     */   
/*     */   @Inject(method = {"shouldSideBeRendered"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void shouldSideBeRendered(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
/*  82 */     XRay xray = (XRay)Retreat.moduleManager.getModule(XRay.class);
/*     */     
/*  84 */     if (((XRay)Objects.<XRay>requireNonNull(xray)).getState())
/*     */     {
/*  86 */       callbackInfoReturnable.setReturnValue(Boolean.valueOf(xray.getXrayBlocks().contains(BlockImplKt.wrap((Block)this)))); } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"getAmbientOcclusionLightValue"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void getAmbientOcclusionLightValue(CallbackInfoReturnable<Float> floatCallbackInfoReturnable) {
/*  91 */     if (((Module)Objects.<Module>requireNonNull(Retreat.moduleManager.getModule(XRay.class))).getState())
/*  92 */       floatCallbackInfoReturnable.setReturnValue(Float.valueOf(1.0F)); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"getPlayerRelativeBlockHardness"}, at = {@At("RETURN")}, cancellable = true)
/*     */   public void modifyBreakSpeed(IBlockState state, EntityPlayer playerIn, World worldIn, BlockPos pos, CallbackInfoReturnable<Float> callbackInfo) {
/*  97 */     float f = ((Float)callbackInfo.getReturnValue()).floatValue();
/*     */ 
/*     */     
/* 100 */     NoSlowBreak noSlowBreak = (NoSlowBreak)Retreat.moduleManager.getModule(NoSlowBreak.class);
/* 101 */     if (((NoSlowBreak)Objects.<NoSlowBreak>requireNonNull(noSlowBreak)).getState()) {
/* 102 */       if (((Boolean)noSlowBreak.getWaterValue().get()).booleanValue() && playerIn.func_70055_a(Material.field_151586_h) && 
/* 103 */         !EnchantmentHelper.func_185287_i((EntityLivingBase)playerIn)) {
/* 104 */         f *= 5.0F;
/*     */       }
/*     */       
/* 107 */       if (((Boolean)noSlowBreak.getAirValue().get()).booleanValue() && !playerIn.field_70122_E) {
/* 108 */         f *= 5.0F;
/*     */       }
/* 110 */     } else if (playerIn.field_70122_E) {
/* 111 */       NoFall noFall = (NoFall)Retreat.moduleManager.getModule(NoFall.class);
/* 112 */       Criticals criticals = (Criticals)Retreat.moduleManager.getModule(Criticals.class);
/*     */       
/* 114 */       if ((((NoFall)Objects.<NoFall>requireNonNull(noFall)).getState() && ((String)noFall.modeValue.get()).equalsIgnoreCase("NoGround")) || ((
/* 115 */         (Criticals)Objects.<Criticals>requireNonNull(criticals)).getState() && ((String)criticals.getModeValue().get()).equalsIgnoreCase("NoGround"))) {
/* 116 */         f /= 5.0F;
/*     */       }
/*     */     } 
/*     */     
/* 120 */     callbackInfo.setReturnValue(Float.valueOf(f));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\block\MixinBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */