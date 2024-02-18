/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.entity;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.ClickWindowEvent;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.exploit.AbortBreaking;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.NoSlow;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Animations;
/*     */ import net.ccbluex.liquidbounce.injection.backend.EntityImplKt;
/*     */ import net.ccbluex.liquidbounce.injection.backend.utils.BackendExtentionsKt;
/*     */ import net.ccbluex.liquidbounce.utils.render.BlockAnimationUtils;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketPlayerDigging;
/*     */ import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
/*     */ import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.GameType;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({PlayerControllerMP.class})
/*     */ public abstract class MixinPlayerControllerMP {
/*     */   @Shadow
/*     */   protected Minecraft field_78776_a;
/*     */   @Shadow
/*  60 */   private GameType field_78779_k = GameType.SURVIVAL;
/*     */   
/*     */   @Shadow
/*     */   private NetHandlerPlayClient field_78774_b;
/*     */   
/*     */   @Shadow
/*     */   public abstract void func_78750_j();
/*     */   
/*     */   @Shadow
/*     */   public abstract float func_78757_d();
/*     */   
/*     */   @Inject(method = {"attackEntity"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/PlayerControllerMP;syncCurrentPlayItem()V")})
/*     */   private void attackEntity(EntityPlayer entityPlayer, Entity targetEntity, CallbackInfo callbackInfo) {
/*  73 */     Retreat.eventManager.callEvent((Event)new AttackEvent(EntityImplKt.wrap(targetEntity)));
/*     */   }
/*     */   
/*     */   @Inject(method = {"getIsHittingBlock"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void getIsHittingBlock(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
/*  78 */     if (Retreat.moduleManager.getModule(AbortBreaking.class).getState())
/*  79 */       callbackInfoReturnable.setReturnValue(Boolean.valueOf(false)); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"windowClick"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void windowClick(int windowId, int slotId, int mouseButton, ClickType type, EntityPlayer player, CallbackInfoReturnable<ItemStack> callbackInfo) {
/*  84 */     ClickWindowEvent event = new ClickWindowEvent(windowId, slotId, mouseButton, BackendExtentionsKt.toInt(type));
/*  85 */     Retreat.eventManager.callEvent((Event)event);
/*     */     
/*  87 */     if (event.isCancelled()) {
/*  88 */       callbackInfo.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public EnumActionResult func_187099_a(EntityPlayerSP player, WorldClient worldIn, BlockPos pos, EnumFacing direction, Vec3d vec, EnumHand hand) {
/*  97 */     func_78750_j();
/*  98 */     ItemStack itemstack = player.func_184586_b(hand);
/*  99 */     float f = (float)(vec.field_72450_a - pos.func_177958_n());
/* 100 */     float f1 = (float)(vec.field_72448_b - pos.func_177956_o());
/* 101 */     float f2 = (float)(vec.field_72449_c - pos.func_177952_p());
/* 102 */     boolean flag = false;
/* 103 */     if (!this.field_78776_a.field_71441_e.func_175723_af().func_177746_a(pos)) {
/* 104 */       return EnumActionResult.FAIL;
/*     */     }
/* 106 */     PlayerInteractEvent.RightClickBlock event = ForgeHooks.onRightClickBlock((EntityPlayer)player, hand, pos, direction, ForgeHooks.rayTraceEyeHitVec((EntityLivingBase)player, (func_78757_d() + 1.0F)));
/* 107 */     if (event.isCanceled()) {
/* 108 */       this.field_78774_b.func_147297_a((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
/* 109 */       return event.getCancellationResult();
/*     */     } 
/* 111 */     EnumActionResult result = EnumActionResult.PASS;
/* 112 */     if (this.field_78779_k != GameType.SPECTATOR) {
/* 113 */       EnumActionResult ret = itemstack.onItemUseFirst((EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2);
/* 114 */       if (ret != EnumActionResult.PASS) {
/* 115 */         this.field_78774_b.func_147297_a((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
/* 116 */         return ret;
/*     */       } 
/*     */       
/* 119 */       IBlockState iblockstate = worldIn.func_180495_p(pos);
/* 120 */       boolean bypass = (player.func_184614_ca().doesSneakBypassUse((IBlockAccess)worldIn, pos, (EntityPlayer)player) && player.func_184592_cb().doesSneakBypassUse((IBlockAccess)worldIn, pos, (EntityPlayer)player));
/* 121 */       if (!player.func_70093_af() || bypass || event.getUseBlock() == Event.Result.ALLOW) {
/* 122 */         if (event.getUseBlock() != Event.Result.DENY) {
/* 123 */           flag = iblockstate.func_177230_c().func_180639_a((World)worldIn, pos, iblockstate, (EntityPlayer)player, hand, direction, f, f1, f2);
/*     */         }
/*     */         
/* 126 */         if (flag) {
/* 127 */           result = EnumActionResult.SUCCESS;
/*     */         }
/*     */       } 
/*     */       
/* 131 */       if (!flag && itemstack.func_77973_b() instanceof ItemBlock) {
/* 132 */         ItemBlock itemblock = (ItemBlock)itemstack.func_77973_b();
/* 133 */         if (!itemblock.func_179222_a((World)worldIn, pos, direction, (EntityPlayer)player, itemstack)) {
/* 134 */           return EnumActionResult.FAIL;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     this.field_78774_b.func_147297_a((Packet)new CPacketPlayerTryUseItemOnBlock(pos, direction, hand, f, f1, f2));
/* 140 */     if ((flag || this.field_78779_k == GameType.SPECTATOR) && event.getUseItem() != Event.Result.ALLOW)
/* 141 */       return EnumActionResult.SUCCESS; 
/* 142 */     if (itemstack.func_190926_b())
/* 143 */       return EnumActionResult.PASS; 
/* 144 */     if (player.func_184811_cZ().func_185141_a(itemstack.func_77973_b())) {
/* 145 */       return EnumActionResult.PASS;
/*     */     }
/* 147 */     if (itemstack.func_77973_b() instanceof ItemBlock && !player.func_189808_dh()) {
/* 148 */       Block block = ((ItemBlock)itemstack.func_77973_b()).func_179223_d();
/* 149 */       if (block instanceof net.minecraft.block.BlockCommandBlock || block instanceof net.minecraft.block.BlockStructure) {
/* 150 */         return EnumActionResult.FAIL;
/*     */       }
/*     */     } 
/*     */     
/* 154 */     if (this.field_78779_k.func_77145_d()) {
/* 155 */       int i = itemstack.func_77960_j();
/* 156 */       int j = itemstack.func_190916_E();
/* 157 */       if (event.getUseItem() != Event.Result.DENY) {
/* 158 */         EnumActionResult enumactionresult = itemstack.func_179546_a((EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2);
/* 159 */         itemstack.func_77964_b(i);
/* 160 */         itemstack.func_190920_e(j);
/* 161 */         return enumactionresult;
/*     */       } 
/* 163 */       return result;
/*     */     } 
/*     */     
/* 166 */     ItemStack copyForUse = itemstack.func_77946_l();
/* 167 */     if (event.getUseItem() != Event.Result.DENY) {
/* 168 */       result = itemstack.func_179546_a((EntityPlayer)player, (World)worldIn, pos, hand, direction, f, f1, f2);
/*     */     }
/*     */     
/* 171 */     if (itemstack.func_190926_b()) {
/* 172 */       ForgeEventFactory.onPlayerDestroyItem((EntityPlayer)player, copyForUse, hand);
/*     */     }
/*     */     
/* 175 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public EnumActionResult func_187101_a(EntityPlayer player, World worldIn, EnumHand hand) {
/* 188 */     Animations ot = (Animations)Retreat.moduleManager.getModule(Animations.class);
/* 189 */     ItemStack itemstack = player.func_184586_b(hand);
/* 190 */     ItemStack shield = new ItemStack(Items.field_185159_cQ);
/* 191 */     if (this.field_78779_k == GameType.SPECTATOR) {
/* 192 */       return EnumActionResult.PASS;
/*     */     }
/* 194 */     func_78750_j();
/* 195 */     if (ot.getState() && this.field_78776_a.field_71439_g.func_184614_ca().func_77973_b() instanceof net.minecraft.item.ItemSword) {
/* 196 */       this.field_78774_b.func_147297_a((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
/*     */     } else {
/* 198 */       this.field_78774_b.func_147297_a((Packet)new CPacketPlayerTryUseItem(hand));
/*     */     } 
/* 200 */     BlockAnimationUtils.thePlayerisBlocking = Boolean.valueOf(true);
/*     */     
/* 202 */     if (player.func_184811_cZ().func_185141_a(itemstack.func_77973_b())) {
/* 203 */       return EnumActionResult.PASS;
/*     */     }
/* 205 */     EnumActionResult cancelResult = ForgeHooks.onItemRightClick(player, hand);
/* 206 */     if (cancelResult != null) {
/* 207 */       return cancelResult;
/*     */     }
/* 209 */     int i = itemstack.func_190916_E();
/* 210 */     ActionResult<ItemStack> actionresult = itemstack.func_77957_a(worldIn, player, hand);
/* 211 */     ItemStack itemstack1 = (ItemStack)actionresult.func_188398_b();
/* 212 */     if (itemstack1 != itemstack || itemstack1.func_190916_E() != i) {
/* 213 */       player.func_184611_a(hand, itemstack1);
/* 214 */       if (itemstack1.func_190926_b()) {
/* 215 */         ForgeEventFactory.onPlayerDestroyItem(player, itemstack, hand);
/*     */       }
/*     */     } 
/*     */     
/* 219 */     return actionresult.func_188397_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public void func_78766_c(EntityPlayer playerIn) {
/* 231 */     NoSlow noSlow = (NoSlow)Retreat.moduleManager.getModule(NoSlow.class);
/* 232 */     BlockAnimationUtils.thePlayerisBlocking = Boolean.valueOf(false);
/* 233 */     func_78750_j();
/* 234 */     this.field_78774_b.func_147297_a((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
/* 235 */     playerIn.func_184597_cx();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\entity\MixinPlayerControllerMP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */