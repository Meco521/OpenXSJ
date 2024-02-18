/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.entity;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.EventState;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*     */ import net.ccbluex.liquidbounce.event.PushOutEvent;
/*     */ import net.ccbluex.liquidbounce.event.SlowDownEvent;
/*     */ import net.ccbluex.liquidbounce.event.StepConfirmEvent;
/*     */ import net.ccbluex.liquidbounce.event.StepEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.StrafeFix;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.exploit.AntiHunger;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.exploit.PortalMenu;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.InventoryMove;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.NoSlow;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Sneak;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.NoSwing;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.world.OldScaffold;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold2;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.PositionedSoundRecord;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.IJumpingMount;
/*     */ import net.minecraft.entity.MoverType;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemElytra;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketAnimation;
/*     */ import net.minecraft.network.play.client.CPacketEntityAction;
/*     */ import net.minecraft.network.play.client.CPacketPlayer;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.MovementInput;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ import net.minecraftforge.client.ForgeHooksClient;
/*     */ import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({EntityPlayerSP.class})
/*     */ public abstract class MixinEntityPlayerSP
/*     */   extends MixinAbstractClientPlayer
/*     */ {
/*     */   @Shadow
/*     */   public boolean field_175171_bO;
/*     */   @Shadow
/*     */   public int field_71157_e;
/*     */   @Shadow
/*     */   public float field_71086_bY;
/*     */   @Shadow
/*     */   public float field_71080_cy;
/*     */   @Shadow
/*     */   public MovementInput field_71158_b;
/*     */   @Shadow
/*     */   public float field_110321_bQ;
/*     */   @Shadow
/*     */   public int field_110320_a;
/*     */   @Shadow
/*     */   @Final
/*     */   public NetHandlerPlayClient field_71174_a;
/*     */   @Shadow
/*     */   protected int field_71156_d;
/*     */   @Shadow
/*     */   protected Minecraft field_71159_c;
/*     */   @Shadow
/*     */   private boolean field_175170_bN;
/*     */   @Shadow
/*     */   private double field_175172_bI;
/*     */   @Shadow
/*     */   private int field_175168_bP;
/*     */   @Shadow
/*     */   private double field_175166_bJ;
/*     */   @Shadow
/*     */   private double field_175167_bK;
/*     */   @Shadow
/*     */   private float field_175164_bL;
/*     */   
/*     */   @Overwrite
/*     */   public void func_175161_p() {
/* 163 */     StrafeFix strafeFix = (StrafeFix)Retreat.moduleManager.getModule(StrafeFix.class);
/* 164 */     strafeFix.updateOverwrite();
/*     */     
/* 166 */     Retreat.eventManager.callEvent((Event)new MotionEvent(EventState.PRE, true));
/*     */     
/* 168 */     InventoryMove inventoryMove = (InventoryMove)Retreat.moduleManager.getModule(InventoryMove.class);
/* 169 */     Sneak sneak = (Sneak)Retreat.moduleManager.getModule(Sneak.class);
/* 170 */     boolean fakeSprint = ((inventoryMove.getState() && ((Boolean)inventoryMove.getAacAdditionProValue().get()).booleanValue()) || Retreat.moduleManager.getModule(AntiHunger.class).getState() || (sneak.getState() && (!MovementUtils.isMoving() || !((Boolean)sneak.stopMoveValue.get()).booleanValue()) && ((String)sneak.modeValue.get()).equalsIgnoreCase("MineSecure")));
/*     */     
/* 172 */     boolean clientSprintState = (func_70051_ag() && !fakeSprint);
/*     */     
/* 174 */     if (clientSprintState != this.field_175171_bO) {
/* 175 */       if (clientSprintState) {
/* 176 */         this.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)this, CPacketEntityAction.Action.START_SPRINTING));
/*     */       } else {
/* 178 */         this.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)this, CPacketEntityAction.Action.STOP_SPRINTING));
/*     */       } 
/*     */       
/* 181 */       this.field_175171_bO = clientSprintState;
/*     */     } 
/*     */     
/* 184 */     boolean flag1 = func_70093_af();
/*     */     
/* 186 */     if (flag1 != this.field_175170_bN && (!sneak.getState() || ((String)sneak.modeValue.get()).equalsIgnoreCase("Legit"))) {
/* 187 */       if (flag1) {
/* 188 */         this.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)this, CPacketEntityAction.Action.START_SNEAKING));
/*     */       } else {
/* 190 */         this.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)this, CPacketEntityAction.Action.STOP_SNEAKING));
/*     */       } 
/*     */       
/* 193 */       this.field_175170_bN = flag1;
/*     */     } 
/*     */     
/* 196 */     if (func_175160_A()) {
/* 197 */       float yaw = this.field_70177_z;
/* 198 */       float pitch = this.field_70125_A;
/* 199 */       float lastReportedYaw = RotationUtils.serverRotation.getYaw();
/* 200 */       float lastReportedPitch = RotationUtils.serverRotation.getPitch();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       if (RotationUtils.targetRotation != null) {
/* 210 */         yaw = RotationUtils.targetRotation.getYaw();
/* 211 */         pitch = RotationUtils.targetRotation.getPitch();
/*     */       } 
/*     */       
/* 214 */       AxisAlignedBB axisalignedbb = func_174813_aQ();
/* 215 */       double xDiff = this.field_70165_t - this.field_175172_bI;
/* 216 */       double yDiff = axisalignedbb.field_72338_b - this.field_175166_bJ;
/* 217 */       double zDiff = this.field_70161_v - this.field_175167_bK;
/* 218 */       double yawDiff = (yaw - lastReportedYaw);
/* 219 */       double pitchDiff = (pitch - lastReportedPitch);
/*     */       
/* 221 */       this.field_175168_bP++;
/*     */       
/* 223 */       boolean flag2 = (xDiff * xDiff + yDiff * yDiff + zDiff * zDiff > 9.0E-4D || this.field_175168_bP >= 20);
/* 224 */       boolean flag3 = (yawDiff != 0.0D || pitchDiff != 0.0D);
/*     */       
/* 226 */       if (func_184218_aH()) {
/* 227 */         this.field_71174_a.func_147297_a((Packet)new CPacketPlayer.PositionRotation(this.field_70159_w, -999.0D, this.field_70179_y, this.field_70177_z, this.field_70125_A, this.field_70122_E));
/* 228 */         flag2 = false;
/* 229 */       } else if (flag2 && flag3) {
/* 230 */         this.field_71174_a.func_147297_a((Packet)new CPacketPlayer.PositionRotation(this.field_70165_t, axisalignedbb.field_72338_b, this.field_70161_v, this.field_70177_z, this.field_70125_A, this.field_70122_E));
/* 231 */       } else if (flag2) {
/* 232 */         this.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(this.field_70165_t, axisalignedbb.field_72338_b, this.field_70161_v, this.field_70122_E));
/* 233 */       } else if (flag3) {
/* 234 */         this.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Rotation(this.field_70177_z, this.field_70125_A, this.field_70122_E));
/* 235 */       } else if (this.field_184841_cd != this.field_70122_E) {
/* 236 */         this.field_71174_a.func_147297_a((Packet)new CPacketPlayer(this.field_70122_E));
/*     */       } 
/*     */       
/* 239 */       if (flag2) {
/* 240 */         this.field_175172_bI = this.field_70165_t;
/* 241 */         this.field_175166_bJ = axisalignedbb.field_72338_b;
/* 242 */         this.field_175167_bK = this.field_70161_v;
/* 243 */         this.field_175168_bP = 0;
/*     */       } 
/*     */       
/* 246 */       if (flag3) {
/* 247 */         this.field_175164_bL = this.field_70177_z;
/* 248 */         this.field_175165_bM = this.field_70125_A;
/*     */       } 
/*     */       
/* 251 */       this.field_184841_cd = this.field_70122_E;
/* 252 */       this.field_189811_cr = this.field_71159_c.field_71474_y.field_189989_R;
/*     */     } 
/*     */     
/* 255 */     Retreat.eventManager.callEvent((Event)new MotionEvent(EventState.POST, true)); } @Shadow private float field_175165_bM; @Shadow private int field_189812_cs; @Shadow private boolean field_189813_ct; @Shadow private boolean field_184841_cd; @Shadow private boolean field_189811_cr; @Shadow public abstract void func_184185_a(SoundEvent paramSoundEvent, float paramFloat1, float paramFloat2); @Shadow public abstract void func_70031_b(boolean paramBoolean); @Shadow protected abstract boolean func_145771_j(double paramDouble1, double paramDouble2, double paramDouble3); @Shadow public abstract void func_71016_p(); @Shadow protected abstract void func_110318_g(); @Shadow public abstract boolean func_110317_t(); @Shadow public abstract boolean func_70093_af(); @Shadow protected abstract boolean func_175160_A(); @Shadow
/*     */   public abstract void func_71053_j(); @Shadow
/*     */   public abstract boolean func_184587_cr(); @Shadow
/*     */   public abstract float func_110319_bJ(); @Shadow
/*     */   protected abstract void func_189810_i(float paramFloat1, float paramFloat2); @Inject(method = {"swingArm"}, at = {@At("HEAD")}, cancellable = true)
/* 260 */   private void swingItem(EnumHand hand, CallbackInfo callbackInfo) { NoSwing noSwing = (NoSwing)Retreat.moduleManager.getModule(NoSwing.class);
/*     */     
/* 262 */     if (noSwing.getState()) {
/* 263 */       callbackInfo.cancel();
/*     */       
/* 265 */       if (!((Boolean)noSwing.getServerSideValue().get()).booleanValue())
/* 266 */         this.field_71174_a.func_147297_a((Packet)new CPacketAnimation(hand)); 
/*     */     }  }
/*     */ 
/*     */   
/*     */   @Inject(method = {"pushOutOfBlocks"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void onPushOutOfBlocks(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
/* 272 */     PushOutEvent event = new PushOutEvent();
/* 273 */     if (this.field_70145_X) event.cancelEvent(); 
/* 274 */     Retreat.eventManager.callEvent((Event)event);
/*     */     
/* 276 */     if (event.isCancelled()) {
/* 277 */       callbackInfoReturnable.setReturnValue(Boolean.valueOf(false));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public void func_70636_d() {
/*     */     try {
/* 286 */       Retreat.eventManager.callEvent((Event)new UpdateEvent());
/* 287 */     } catch (Throwable e) {
/* 288 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 291 */     this.field_71157_e++;
/*     */     
/* 293 */     if (this.field_71156_d > 0) {
/* 294 */       this.field_71156_d--;
/*     */     }
/*     */     
/* 297 */     this.field_71080_cy = this.field_71086_bY;
/*     */     
/* 299 */     if (this.field_71087_bX) {
/* 300 */       if (this.field_71159_c.field_71462_r != null && !this.field_71159_c.field_71462_r.func_73868_f() && !Retreat.moduleManager.getModule(PortalMenu.class).getState()) {
/* 301 */         if (this.field_71159_c.field_71462_r instanceof net.minecraft.client.gui.inventory.GuiContainer) {
/* 302 */           func_71053_j();
/*     */         }
/*     */         
/* 305 */         this.field_71159_c.func_147108_a(null);
/*     */       } 
/*     */       
/* 308 */       if (this.field_71086_bY == 0.0F) {
/* 309 */         this.field_71159_c.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_184371_a(SoundEvents.field_187814_ei, this.field_70146_Z.nextFloat() * 0.4F + 0.8F));
/*     */       }
/*     */       
/* 312 */       this.field_71086_bY += 0.0125F;
/*     */       
/* 314 */       if (this.field_71086_bY >= 1.0F) {
/* 315 */         this.field_71086_bY = 1.0F;
/*     */       }
/*     */       
/* 318 */       this.field_71087_bX = false;
/* 319 */     } else if (func_70644_a(MobEffects.field_76431_k) && func_70660_b(MobEffects.field_76431_k).func_76459_b() > 60) {
/* 320 */       this.field_71086_bY += 0.006666667F;
/*     */       
/* 322 */       if (this.field_71086_bY > 1.0F) {
/* 323 */         this.field_71086_bY = 1.0F;
/*     */       }
/*     */     } else {
/* 326 */       if (this.field_71086_bY > 0.0F) {
/* 327 */         this.field_71086_bY -= 0.05F;
/*     */       }
/*     */       
/* 330 */       if (this.field_71086_bY < 0.0F) {
/* 331 */         this.field_71086_bY = 0.0F;
/*     */       }
/*     */     } 
/*     */     
/* 335 */     if (this.field_71088_bW > 0) {
/* 336 */       this.field_71088_bW--;
/*     */     }
/*     */     
/* 339 */     boolean flag = this.field_71158_b.field_78901_c;
/* 340 */     boolean flag1 = this.field_71158_b.field_78899_d;
/* 341 */     float f = 0.8F;
/* 342 */     boolean flag2 = (this.field_71158_b.field_192832_b >= 0.8F);
/* 343 */     this.field_71158_b.func_78898_a();
/* 344 */     NoSlow noSlow = (NoSlow)Retreat.moduleManager.getModule(NoSlow.class);
/* 345 */     KillAura killAura = (KillAura)Retreat.moduleManager.getModule(KillAura.class);
/*     */     
/* 347 */     ForgeHooksClient.onInputUpdate((EntityPlayer)this, this.field_71158_b);
/* 348 */     this.field_71159_c.func_193032_ao().func_193293_a(this.field_71158_b);
/*     */     
/* 350 */     if (func_184587_cr() || (func_184586_b(EnumHand.MAIN_HAND).func_77973_b() instanceof net.minecraft.item.ItemSword && killAura.getBlockingStatus() && !func_184218_aH())) {
/* 351 */       SlowDownEvent slowDownEvent = new SlowDownEvent(0.2F, 0.2F);
/* 352 */       Retreat.eventManager.callEvent((Event)slowDownEvent);
/* 353 */       this.field_71158_b.field_78902_a *= slowDownEvent.getStrafe();
/* 354 */       this.field_71158_b.field_192832_b *= slowDownEvent.getForward();
/* 355 */       this.field_71156_d = 0;
/*     */     } 
/*     */     
/* 358 */     boolean flag3 = false;
/*     */     
/* 360 */     if (this.field_189812_cs > 0) {
/* 361 */       this.field_189812_cs--;
/* 362 */       flag3 = true;
/* 363 */       this.field_71158_b.field_78901_c = true;
/*     */     } 
/*     */     
/* 366 */     AxisAlignedBB axisalignedbb = func_174813_aQ();
/* 367 */     PlayerSPPushOutOfBlocksEvent event = new PlayerSPPushOutOfBlocksEvent((EntityPlayer)this, axisalignedbb);
/* 368 */     if (!MinecraftForge.EVENT_BUS.post((Event)event)) {
/* 369 */       axisalignedbb = event.getEntityBoundingBox();
/* 370 */       func_145771_j(this.field_70165_t - this.field_70130_N * 0.35D, axisalignedbb.field_72338_b + 0.5D, this.field_70161_v + this.field_70130_N * 0.35D);
/* 371 */       func_145771_j(this.field_70165_t - this.field_70130_N * 0.35D, axisalignedbb.field_72338_b + 0.5D, this.field_70161_v - this.field_70130_N * 0.35D);
/* 372 */       func_145771_j(this.field_70165_t + this.field_70130_N * 0.35D, axisalignedbb.field_72338_b + 0.5D, this.field_70161_v - this.field_70130_N * 0.35D);
/* 373 */       func_145771_j(this.field_70165_t + this.field_70130_N * 0.35D, axisalignedbb.field_72338_b + 0.5D, this.field_70161_v + this.field_70130_N * 0.35D);
/*     */     } 
/* 375 */     Sprint sprint = (Sprint)Retreat.moduleManager.getModule(Sprint.class);
/*     */     
/* 377 */     boolean flag4 = (!((Boolean)sprint.foodValue.get()).booleanValue() || func_71024_bL().func_75116_a() > 6.0F || this.field_71075_bZ.field_75101_c);
/*     */     
/* 379 */     if (this.field_70122_E && !flag1 && !flag2 && this.field_71158_b.field_192832_b >= 0.8F && !func_70051_ag() && flag4 && !func_184587_cr() && !func_70644_a(MobEffects.field_76440_q)) {
/* 380 */       if (this.field_71156_d <= 0 && !this.field_71159_c.field_71474_y.field_151444_V.func_151470_d()) {
/* 381 */         this.field_71156_d = 7;
/*     */       } else {
/* 383 */         func_70031_b(true);
/*     */       } 
/*     */     }
/*     */     
/* 387 */     if (!func_70051_ag() && this.field_71158_b.field_192832_b >= 0.8F && flag4 && (noSlow.getState() || !func_184587_cr()) && !func_70644_a(MobEffects.field_76440_q) && this.field_71159_c.field_71474_y.field_151444_V.func_151470_d()) {
/* 388 */       func_70031_b(true);
/*     */     }
/*     */     
/* 391 */     Scaffold scaffold = (Scaffold)Retreat.moduleManager.getModule(Scaffold.class);
/* 392 */     Scaffold2 scaffold2 = (Scaffold2)Retreat.moduleManager.getModule(Scaffold2.class);
/* 393 */     OldScaffold oldscaffold = (OldScaffold)Retreat.moduleManager.getModule(OldScaffold.class);
/* 394 */     if (oldscaffold.getState() && !((Boolean)oldscaffold.getSprintValue().get()).booleanValue())
/* 395 */       func_70031_b(false); 
/* 396 */     if ((scaffold.getState() && !((Boolean)scaffold.getSprintValue().get()).booleanValue()) || (sprint.getState() && ((Boolean)sprint.checkServerSide.get()).booleanValue() && (this.field_70122_E || !((Boolean)sprint.checkServerSideGround.get()).booleanValue()) && !((Boolean)sprint.allDirectionsValue.get()).booleanValue() && RotationUtils.targetRotation != null && RotationUtils.getRotationDifference(new Rotation(this.field_71159_c.field_71439_g.field_70177_z, this.field_71159_c.field_71439_g.field_70125_A)) > 30.0D))
/* 397 */       func_70031_b(false); 
/* 398 */     if ((scaffold2.getState() && !((Boolean)scaffold2.getSprintValue().get()).booleanValue()) || (sprint.getState() && ((Boolean)sprint.checkServerSide.get()).booleanValue() && (this.field_70122_E || !((Boolean)sprint.checkServerSideGround.get()).booleanValue()) && !((Boolean)sprint.allDirectionsValue.get()).booleanValue() && RotationUtils.targetRotation != null && RotationUtils.getRotationDifference(new Rotation(this.field_71159_c.field_71439_g.field_70177_z, this.field_71159_c.field_71439_g.field_70125_A)) > 30.0D)) {
/* 399 */       func_70031_b(false);
/*     */     }
/* 401 */     if (oldscaffold.getState()) {
/* 402 */       if (Objects.equals(oldscaffold.getSprintModeValue().get(), "ground")) {
/* 403 */         if (this.field_71159_c.field_71439_g.field_70122_E) {
/* 404 */           func_70031_b(true);
/*     */         } else {
/* 406 */           func_70031_b(false);
/*     */         } 
/*     */       }
/* 409 */       if (Objects.equals(oldscaffold.getSprintModeValue().get(), "air")) {
/* 410 */         if (!this.field_71159_c.field_71439_g.field_70122_E) {
/* 411 */           func_70031_b(true);
/*     */         } else {
/* 413 */           func_70031_b(false);
/*     */         } 
/*     */       }
/* 416 */       if (Objects.equals(oldscaffold.getSprintModeValue().get(), "off")) {
/* 417 */         func_70031_b(false);
/*     */       }
/*     */     } 
/*     */     
/* 421 */     if (func_70051_ag() && (this.field_71158_b.field_192832_b < 0.8F || this.field_70123_F || !flag4)) {
/* 422 */       func_70031_b(false);
/*     */     }
/*     */     
/* 425 */     if (this.field_71075_bZ.field_75101_c) {
/* 426 */       if (this.field_71159_c.field_71442_b.func_178887_k()) {
/* 427 */         if (!this.field_71075_bZ.field_75100_b) {
/* 428 */           this.field_71075_bZ.field_75100_b = true;
/* 429 */           func_71016_p();
/*     */         } 
/* 431 */       } else if (!flag && this.field_71158_b.field_78901_c && !flag3) {
/* 432 */         if (this.field_71101_bC == 0) {
/* 433 */           this.field_71101_bC = 7;
/*     */         } else {
/* 435 */           this.field_71075_bZ.field_75100_b = !this.field_71075_bZ.field_75100_b;
/* 436 */           func_71016_p();
/* 437 */           this.field_71101_bC = 0;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 442 */     if (this.field_71158_b.field_78901_c && !flag && !this.field_70122_E && this.field_70181_x < 0.0D && !func_184613_cA() && !this.field_71075_bZ.field_75100_b) {
/* 443 */       ItemStack itemstack = func_184582_a(EntityEquipmentSlot.CHEST);
/*     */       
/* 445 */       if (itemstack.func_77973_b() == Items.field_185160_cR && ItemElytra.func_185069_d(itemstack)) {
/* 446 */         this.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)this, CPacketEntityAction.Action.START_FALL_FLYING));
/*     */       }
/*     */     } 
/*     */     
/* 450 */     this.field_189813_ct = func_184613_cA();
/*     */     
/* 452 */     if (this.field_71075_bZ.field_75100_b && func_175160_A()) {
/* 453 */       if (this.field_71158_b.field_78899_d) {
/* 454 */         this.field_71158_b.field_78902_a = (float)(this.field_71158_b.field_78902_a / 0.3D);
/* 455 */         this.field_71158_b.field_192832_b = (float)(this.field_71158_b.field_192832_b / 0.3D);
/* 456 */         this.field_70181_x -= (this.field_71075_bZ.func_75093_a() * 3.0F);
/*     */       } 
/*     */       
/* 459 */       if (this.field_71158_b.field_78901_c) {
/* 460 */         this.field_70181_x += (this.field_71075_bZ.func_75093_a() * 3.0F);
/*     */       }
/*     */     } 
/*     */     
/* 464 */     if (func_110317_t()) {
/* 465 */       IJumpingMount ijumpingmount = (IJumpingMount)func_184187_bx();
/*     */       
/* 467 */       if (this.field_110320_a < 0) {
/* 468 */         this.field_110320_a++;
/*     */         
/* 470 */         if (this.field_110320_a == 0) {
/* 471 */           this.field_110321_bQ = 0.0F;
/*     */         }
/*     */       } 
/*     */       
/* 475 */       if (flag && !this.field_71158_b.field_78901_c) {
/* 476 */         this.field_110320_a = -10;
/* 477 */         ijumpingmount.func_110206_u(MathHelper.func_76141_d(func_110319_bJ() * 100.0F));
/* 478 */         func_110318_g();
/* 479 */       } else if (!flag && this.field_71158_b.field_78901_c) {
/* 480 */         this.field_110320_a = 0;
/* 481 */         this.field_110321_bQ = 0.0F;
/* 482 */       } else if (flag) {
/* 483 */         this.field_110320_a++;
/*     */         
/* 485 */         if (this.field_110320_a < 10) {
/* 486 */           this.field_110321_bQ = this.field_110320_a * 0.1F;
/*     */         } else {
/* 488 */           this.field_110321_bQ = 0.8F + 2.0F / (this.field_110320_a - 9) * 0.1F;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 492 */       this.field_110321_bQ = 0.0F;
/*     */     } 
/*     */     
/* 495 */     super.func_70636_d();
/*     */     
/* 497 */     if (this.field_70122_E && this.field_71075_bZ.field_75100_b && !this.field_71159_c.field_71442_b.func_178887_k()) {
/* 498 */       this.field_71075_bZ.field_75100_b = false;
/* 499 */       func_71016_p();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public void func_70091_d(MoverType type, double x, double y, double z) {
/* 508 */     MoveEvent moveEvent = new MoveEvent(x, y, z);
/* 509 */     Retreat.eventManager.callEvent((Event)moveEvent);
/*     */     
/* 511 */     if (moveEvent.isCancelled()) {
/*     */       return;
/*     */     }
/* 514 */     x = moveEvent.getX();
/* 515 */     y = moveEvent.getY();
/* 516 */     z = moveEvent.getZ();
/*     */     
/* 518 */     if (this.field_70145_X) {
/* 519 */       func_174826_a(func_174813_aQ().func_72317_d(x, y, z));
/* 520 */       func_174829_m();
/*     */     } else {
/* 522 */       if (type == MoverType.PISTON) {
/* 523 */         long i = this.field_70170_p.func_82737_E();
/*     */         
/* 525 */         if (i != this.field_191506_aJ) {
/* 526 */           Arrays.fill(this.field_191505_aI, 0.0D);
/* 527 */           this.field_191506_aJ = i;
/*     */         } 
/*     */         
/* 530 */         if (x != 0.0D) {
/* 531 */           int j = EnumFacing.Axis.X.ordinal();
/* 532 */           double d0 = MathHelper.func_151237_a(x + this.field_191505_aI[j], -0.51D, 0.51D);
/* 533 */           x = d0 - this.field_191505_aI[j];
/* 534 */           this.field_191505_aI[j] = d0;
/*     */           
/* 536 */           if (Math.abs(x) <= 9.999999747378752E-6D) {
/*     */             return;
/*     */           }
/* 539 */         } else if (y != 0.0D) {
/* 540 */           int l4 = EnumFacing.Axis.Y.ordinal();
/* 541 */           double d12 = MathHelper.func_151237_a(y + this.field_191505_aI[l4], -0.51D, 0.51D);
/* 542 */           y = d12 - this.field_191505_aI[l4];
/* 543 */           this.field_191505_aI[l4] = d12;
/*     */           
/* 545 */           if (Math.abs(y) <= 9.999999747378752E-6D) {
/*     */             return;
/*     */           }
/*     */         } else {
/* 549 */           if (z == 0.0D) {
/*     */             return;
/*     */           }
/*     */           
/* 553 */           int i5 = EnumFacing.Axis.Z.ordinal();
/* 554 */           double d13 = MathHelper.func_151237_a(z + this.field_191505_aI[i5], -0.51D, 0.51D);
/* 555 */           z = d13 - this.field_191505_aI[i5];
/* 556 */           this.field_191505_aI[i5] = d13;
/*     */           
/* 558 */           if (Math.abs(z) <= 9.999999747378752E-6D) {
/*     */             return;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 564 */       this.field_70170_p.field_72984_F.func_76320_a("move");
/* 565 */       double d10 = this.field_70165_t;
/* 566 */       double d11 = this.field_70163_u;
/* 567 */       double d1 = this.field_70161_v;
/*     */       
/* 569 */       if (this.field_70134_J) {
/* 570 */         this.field_70134_J = false;
/* 571 */         x *= 0.25D;
/* 572 */         y *= 0.05000000074505806D;
/* 573 */         z *= 0.25D;
/* 574 */         this.field_70159_w = 0.0D;
/* 575 */         this.field_70181_x = 0.0D;
/* 576 */         this.field_70179_y = 0.0D;
/*     */       } 
/*     */       
/* 579 */       double d2 = x;
/* 580 */       double d3 = y;
/* 581 */       double d4 = z;
/*     */ 
/*     */       
/* 584 */       if ((type == MoverType.SELF || type == MoverType.PLAYER) && ((this.field_70122_E && func_70093_af()) || moveEvent.isSafeWalk()) && this instanceof EntityPlayer) {
/* 585 */         for (double d5 = 0.05D; x != 0.0D && this.field_70170_p.func_184144_a((Entity)this, func_174813_aQ().func_72317_d(x, -this.field_70138_W, 0.0D)).isEmpty(); d2 = x) {
/* 586 */           if (x < 0.05D && x >= -0.05D) {
/* 587 */             x = 0.0D;
/* 588 */           } else if (x > 0.0D) {
/* 589 */             x -= 0.05D;
/*     */           } else {
/* 591 */             x += 0.05D;
/*     */           } 
/*     */         } 
/*     */         
/* 595 */         for (; z != 0.0D && this.field_70170_p.func_184144_a((Entity)this, func_174813_aQ().func_72317_d(0.0D, -this.field_70138_W, z)).isEmpty(); d4 = z) {
/* 596 */           if (z < 0.05D && z >= -0.05D) {
/* 597 */             z = 0.0D;
/* 598 */           } else if (z > 0.0D) {
/* 599 */             z -= 0.05D;
/*     */           } else {
/* 601 */             z += 0.05D;
/*     */           } 
/*     */         } 
/*     */         
/* 605 */         for (; x != 0.0D && z != 0.0D && this.field_70170_p.func_184144_a((Entity)this, func_174813_aQ().func_72317_d(x, -this.field_70138_W, z)).isEmpty(); d4 = z) {
/* 606 */           if (x < 0.05D && x >= -0.05D) {
/* 607 */             x = 0.0D;
/* 608 */           } else if (x > 0.0D) {
/* 609 */             x -= 0.05D;
/*     */           } else {
/* 611 */             x += 0.05D;
/*     */           } 
/*     */           
/* 614 */           d2 = x;
/*     */           
/* 616 */           if (z < 0.05D && z >= -0.05D) {
/* 617 */             z = 0.0D;
/* 618 */           } else if (z > 0.0D) {
/* 619 */             z -= 0.05D;
/*     */           } else {
/* 621 */             z += 0.05D;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 626 */       List<AxisAlignedBB> list1 = this.field_70170_p.func_184144_a((Entity)this, func_174813_aQ().func_72321_a(x, y, z));
/* 627 */       AxisAlignedBB axisalignedbb = func_174813_aQ();
/*     */       
/* 629 */       if (y != 0.0D) {
/* 630 */         int k = 0;
/*     */         
/* 632 */         for (int l = list1.size(); k < l; k++) {
/* 633 */           y = ((AxisAlignedBB)list1.get(k)).func_72323_b(func_174813_aQ(), y);
/*     */         }
/*     */         
/* 636 */         func_174826_a(func_174813_aQ().func_72317_d(0.0D, y, 0.0D));
/*     */       } 
/*     */       
/* 639 */       if (x != 0.0D) {
/* 640 */         int j5 = 0;
/*     */         
/* 642 */         for (int l5 = list1.size(); j5 < l5; j5++) {
/* 643 */           x = ((AxisAlignedBB)list1.get(j5)).func_72316_a(func_174813_aQ(), x);
/*     */         }
/*     */         
/* 646 */         if (x != 0.0D) {
/* 647 */           func_174826_a(func_174813_aQ().func_72317_d(x, 0.0D, 0.0D));
/*     */         }
/*     */       } 
/*     */       
/* 651 */       if (z != 0.0D) {
/* 652 */         int k5 = 0;
/*     */         
/* 654 */         for (int i6 = list1.size(); k5 < i6; k5++) {
/* 655 */           z = ((AxisAlignedBB)list1.get(k5)).func_72322_c(func_174813_aQ(), z);
/*     */         }
/*     */         
/* 658 */         if (z != 0.0D) {
/* 659 */           func_174826_a(func_174813_aQ().func_72317_d(0.0D, 0.0D, z));
/*     */         }
/*     */       } 
/*     */       
/* 663 */       boolean flag = (this.field_70122_E || (d3 != y && d3 < 0.0D));
/*     */       
/* 665 */       if (this.field_70138_W > 0.0F && flag && (d2 != x || d4 != z)) {
/* 666 */         StepEvent stepEvent = new StepEvent(this.field_70138_W);
/* 667 */         Retreat.eventManager.callEvent((Event)stepEvent);
/*     */         
/* 669 */         double d14 = x;
/* 670 */         double d6 = y;
/* 671 */         double d7 = z;
/* 672 */         AxisAlignedBB axisalignedbb1 = func_174813_aQ();
/* 673 */         func_174826_a(axisalignedbb);
/* 674 */         y = stepEvent.getStepHeight();
/* 675 */         List<AxisAlignedBB> list = this.field_70170_p.func_184144_a((Entity)this, func_174813_aQ().func_72321_a(d2, y, d4));
/* 676 */         AxisAlignedBB axisalignedbb2 = func_174813_aQ();
/* 677 */         AxisAlignedBB axisalignedbb3 = axisalignedbb2.func_72321_a(d2, 0.0D, d4);
/* 678 */         double d8 = y;
/* 679 */         int j1 = 0;
/*     */         
/* 681 */         for (int k1 = list.size(); j1 < k1; j1++) {
/* 682 */           d8 = ((AxisAlignedBB)list.get(j1)).func_72323_b(axisalignedbb3, d8);
/*     */         }
/*     */         
/* 685 */         axisalignedbb2 = axisalignedbb2.func_72317_d(0.0D, d8, 0.0D);
/* 686 */         double d18 = d2;
/* 687 */         int l1 = 0;
/*     */         
/* 689 */         for (int i2 = list.size(); l1 < i2; l1++) {
/* 690 */           d18 = ((AxisAlignedBB)list.get(l1)).func_72316_a(axisalignedbb2, d18);
/*     */         }
/*     */         
/* 693 */         axisalignedbb2 = axisalignedbb2.func_72317_d(d18, 0.0D, 0.0D);
/* 694 */         double d19 = d4;
/* 695 */         int j2 = 0;
/*     */         
/* 697 */         for (int k2 = list.size(); j2 < k2; j2++) {
/* 698 */           d19 = ((AxisAlignedBB)list.get(j2)).func_72322_c(axisalignedbb2, d19);
/*     */         }
/*     */         
/* 701 */         axisalignedbb2 = axisalignedbb2.func_72317_d(0.0D, 0.0D, d19);
/* 702 */         AxisAlignedBB axisalignedbb4 = func_174813_aQ();
/* 703 */         double d20 = y;
/* 704 */         int l2 = 0;
/*     */         
/* 706 */         for (int i3 = list.size(); l2 < i3; l2++) {
/* 707 */           d20 = ((AxisAlignedBB)list.get(l2)).func_72323_b(axisalignedbb4, d20);
/*     */         }
/*     */         
/* 710 */         axisalignedbb4 = axisalignedbb4.func_72317_d(0.0D, d20, 0.0D);
/* 711 */         double d21 = d2;
/* 712 */         int j3 = 0;
/*     */         
/* 714 */         for (int k3 = list.size(); j3 < k3; j3++) {
/* 715 */           d21 = ((AxisAlignedBB)list.get(j3)).func_72316_a(axisalignedbb4, d21);
/*     */         }
/*     */         
/* 718 */         axisalignedbb4 = axisalignedbb4.func_72317_d(d21, 0.0D, 0.0D);
/* 719 */         double d22 = d4;
/* 720 */         int l3 = 0;
/*     */         
/* 722 */         for (int i4 = list.size(); l3 < i4; l3++) {
/* 723 */           d22 = ((AxisAlignedBB)list.get(l3)).func_72322_c(axisalignedbb4, d22);
/*     */         }
/*     */         
/* 726 */         axisalignedbb4 = axisalignedbb4.func_72317_d(0.0D, 0.0D, d22);
/* 727 */         double d23 = d18 * d18 + d19 * d19;
/* 728 */         double d9 = d21 * d21 + d22 * d22;
/*     */         
/* 730 */         if (d23 > d9) {
/* 731 */           x = d18;
/* 732 */           z = d19;
/* 733 */           y = -d8;
/* 734 */           func_174826_a(axisalignedbb2);
/*     */         } else {
/* 736 */           x = d21;
/* 737 */           z = d22;
/* 738 */           y = -d20;
/* 739 */           func_174826_a(axisalignedbb4);
/*     */         } 
/*     */         
/* 742 */         int j4 = 0;
/*     */         
/* 744 */         for (int k4 = list.size(); j4 < k4; j4++) {
/* 745 */           y = ((AxisAlignedBB)list.get(j4)).func_72323_b(func_174813_aQ(), y);
/*     */         }
/*     */         
/* 748 */         func_174826_a(func_174813_aQ().func_72317_d(0.0D, y, 0.0D));
/*     */         
/* 750 */         if (d14 * d14 + d7 * d7 >= x * x + z * z) {
/* 751 */           x = d14;
/* 752 */           y = d6;
/* 753 */           z = d7;
/* 754 */           func_174826_a(axisalignedbb1);
/*     */         } else {
/* 756 */           Retreat.eventManager.callEvent((Event)new StepConfirmEvent());
/*     */         } 
/*     */       } 
/*     */       
/* 760 */       this.field_70170_p.field_72984_F.func_76319_b();
/* 761 */       this.field_70170_p.field_72984_F.func_76320_a("rest");
/* 762 */       func_174829_m();
/* 763 */       this.field_70123_F = (d2 != x || d4 != z);
/* 764 */       this.field_70124_G = (d3 != y);
/* 765 */       this.field_70122_E = (this.field_70124_G && d3 < 0.0D);
/* 766 */       this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/* 767 */       int j6 = MathHelper.func_76128_c(this.field_70165_t);
/* 768 */       int i1 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D);
/* 769 */       int k6 = MathHelper.func_76128_c(this.field_70161_v);
/* 770 */       BlockPos blockpos = new BlockPos(j6, i1, k6);
/* 771 */       IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos);
/*     */       
/* 773 */       if (iblockstate.func_185904_a() == Material.field_151579_a) {
/* 774 */         BlockPos blockpos1 = blockpos.func_177977_b();
/* 775 */         IBlockState iblockstate1 = this.field_70170_p.func_180495_p(blockpos1);
/* 776 */         Block block1 = iblockstate1.func_177230_c();
/*     */         
/* 778 */         if (block1 instanceof net.minecraft.block.BlockFence || block1 instanceof net.minecraft.block.BlockWall || block1 instanceof net.minecraft.block.BlockFenceGate) {
/* 779 */           iblockstate = iblockstate1;
/* 780 */           blockpos = blockpos1;
/*     */         } 
/*     */       } 
/*     */       
/* 784 */       func_184231_a(y, this.field_70122_E, iblockstate, blockpos);
/*     */       
/* 786 */       if (d2 != x) {
/* 787 */         this.field_70159_w = 0.0D;
/*     */       }
/*     */       
/* 790 */       if (d4 != z) {
/* 791 */         this.field_70179_y = 0.0D;
/*     */       }
/*     */       
/* 794 */       Block block = iblockstate.func_177230_c();
/*     */       
/* 796 */       if (d3 != y) {
/* 797 */         block.func_176216_a(this.field_70170_p, (Entity)this);
/*     */       }
/*     */       
/* 800 */       if (func_70041_e_() && (!this.field_70122_E || !func_70093_af() || !(this instanceof EntityPlayer)) && !func_184218_aH()) {
/* 801 */         double d15 = this.field_70165_t - d10;
/* 802 */         double d16 = this.field_70163_u - d11;
/* 803 */         double d17 = this.field_70161_v - d1;
/*     */         
/* 805 */         if (block != Blocks.field_150468_ap) {
/* 806 */           d16 = 0.0D;
/*     */         }
/*     */         
/* 809 */         if (block != null && this.field_70122_E) {
/* 810 */           block.func_176199_a(this.field_70170_p, blockpos, (Entity)this);
/*     */         }
/*     */         
/* 813 */         this.field_70140_Q = (float)(this.field_70140_Q + MathHelper.func_76133_a(d15 * d15 + d17 * d17) * 0.6D);
/* 814 */         this.field_82151_R = (float)(this.field_82151_R + MathHelper.func_76133_a(d15 * d15 + d16 * d16 + d17 * d17) * 0.6D);
/*     */         
/* 816 */         if (this.field_82151_R > this.field_70150_b && iblockstate.func_185904_a() != Material.field_151579_a) {
/* 817 */           this.field_70150_b = (int)this.field_82151_R + 1;
/*     */           
/* 819 */           if (func_70090_H()) {
/* 820 */             Entity entity = (func_184207_aI() && func_184179_bs() != null) ? func_184179_bs() : (Entity)this;
/* 821 */             float f = (entity == this) ? 0.35F : 0.4F;
/* 822 */             float f1 = MathHelper.func_76133_a(entity.field_70159_w * entity.field_70159_w * 0.20000000298023224D + entity.field_70181_x * entity.field_70181_x + entity.field_70179_y * entity.field_70179_y * 0.20000000298023224D) * f;
/*     */             
/* 824 */             if (f1 > 1.0F) {
/* 825 */               f1 = 1.0F;
/*     */             }
/*     */             
/* 828 */             func_184185_a(func_184184_Z(), f1, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
/*     */           } else {
/* 830 */             func_180429_a(blockpos, block);
/*     */           } 
/* 832 */         } else if (this.field_82151_R > this.field_191959_ay && func_191957_ae() && iblockstate.func_185904_a() == Material.field_151579_a) {
/* 833 */           this.field_191959_ay = func_191954_d(this.field_82151_R);
/*     */         } 
/*     */       } 
/*     */       
/*     */       try {
/* 838 */         func_145775_I();
/* 839 */       } catch (Throwable throwable) {
/* 840 */         CrashReport crashreport = CrashReport.func_85055_a(throwable, "Checking entity block collision");
/* 841 */         CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
/* 842 */         func_85029_a(crashreportcategory);
/* 843 */         throw new ReportedException(crashreport);
/*     */       } 
/*     */       
/* 846 */       boolean flag1 = func_70026_G();
/*     */       
/* 848 */       if (this.field_70170_p.func_147470_e(func_174813_aQ().func_186664_h(0.001D))) {
/* 849 */         func_70081_e(1);
/*     */         
/* 851 */         if (!flag1) {
/* 852 */           this.field_190534_ay++;
/*     */           
/* 854 */           if (this.field_190534_ay == 0) {
/* 855 */             func_70015_d(8);
/*     */           }
/*     */         } 
/* 858 */       } else if (this.field_190534_ay <= 0) {
/* 859 */         this.field_190534_ay = -func_190531_bD();
/*     */       } 
/*     */       
/* 862 */       if (flag1 && func_70027_ad()) {
/* 863 */         func_184185_a(SoundEvents.field_187541_bC, 0.7F, 1.6F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
/* 864 */         this.field_190534_ay = -func_190531_bD();
/*     */       } 
/*     */       
/* 867 */       this.field_70170_p.field_72984_F.func_76319_b();
/*     */     } 
/*     */     
/* 870 */     func_189810_i((float)(this.field_70165_t - this.field_70165_t), (float)(this.field_70161_v - this.field_70161_v));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\entity\MixinEntityPlayerSP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */