/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemPotion;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotionEffect;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.misc.FallingPlayer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ 
/*     */ @ModuleInfo(name = "AutoPot", description = "Automatically throws healing potions.", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000H\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\016\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\030\020\025\032\0020\0172\006\020\026\032\0020\0172\006\020\027\032\0020\017H\002J\020\020\030\032\0020\0312\006\020\032\032\0020\033H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\017X\016¢\006\002\n\000R\016\020\020\032\0020\rX\004¢\006\002\n\000R\026\020\021\032\004\030\0010\0228VX\004¢\006\006\032\004\b\023\020\024¨\006\034"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoPot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "groundDistanceValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "healthValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "openInventoryValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "potion", "", "simulateInventory", "tag", "", "getTag", "()Ljava/lang/String;", "findPotion", "startSlot", "endSlot", "onMotion", "", "motionEvent", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "XSJClient"})
/*     */ public final class AutoPot extends Module {
/*  25 */   private final FloatValue healthValue = new FloatValue("Health", 15.0F, 1.0F, 20.0F);
/*  26 */   private final IntegerValue delayValue = new IntegerValue("Delay", 500, 500, 1000);
/*     */   
/*  28 */   private final BoolValue openInventoryValue = new BoolValue("OpenInv", false);
/*  29 */   private final BoolValue simulateInventory = new BoolValue("SimulateInventory", true);
/*     */   
/*  31 */   private final FloatValue groundDistanceValue = new FloatValue("GroundDistance", 2.0F, 0.0F, 5.0F);
/*  32 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Jump", "Port" }, "Normal");
/*     */   
/*  34 */   private final MSTimer msTimer = new MSTimer();
/*  35 */   private int potion = -1;
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent motionEvent) {
/*  39 */     Intrinsics.checkParameterIsNotNull(motionEvent, "motionEvent"); if (!this.msTimer.hasTimePassed(((Number)this.delayValue.get()).intValue()) || MinecraftInstance.mc.getPlayerController().isInCreativeMode()) {
/*     */       return;
/*     */     }
/*  42 */     if (MinecraftInstance.mc.getThePlayer() != null) { int potionInHotbar, potionInInventory; IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  44 */       switch (AutoPot$WhenMappings.$EnumSwitchMapping$0[motionEvent.getEventState().ordinal()]) {
/*     */         
/*     */         case 1:
/*  47 */           potionInHotbar = findPotion(36, 45);
/*     */           
/*  49 */           if (thePlayer.getHealth() <= ((Number)this.healthValue.get()).floatValue() && potionInHotbar != -1) {
/*  50 */             if (thePlayer.getOnGround()) {
/*  51 */               String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */                 case 3446913:
/*  53 */                   if (str.equals("port")) thePlayer.moveEntity(0.0D, 0.42D, 0.0D);  break;
/*     */                 case 3273774:
/*     */                   if (str.equals("jump"))
/*     */                     thePlayer.jump();  break;
/*     */               } 
/*  58 */             }  FallingPlayer fallingPlayer = new FallingPlayer(
/*  59 */                 thePlayer.getPosX(), 
/*  60 */                 thePlayer.getPosY(), 
/*  61 */                 thePlayer.getPosZ(), 
/*  62 */                 thePlayer.getMotionX(), 
/*  63 */                 thePlayer.getMotionY(), 
/*  64 */                 thePlayer.getMotionZ(), 
/*  65 */                 thePlayer.getRotationYaw(), 
/*  66 */                 thePlayer.getMoveStrafing(), 
/*  67 */                 thePlayer.getMoveForward());
/*     */ 
/*     */             
/*  70 */             fallingPlayer.findCollision(20); WBlockPos collisionBlock = (fallingPlayer.findCollision(20) != null) ? fallingPlayer.findCollision(20).getPos() : null;
/*     */             
/*  72 */             if (thePlayer.getPosY() - ((collisionBlock != null) ? collisionBlock.getY() : false) >= ((Number)this.groundDistanceValue.get()).doubleValue()) {
/*     */               return;
/*     */             }
/*  75 */             this.potion = potionInHotbar;
/*  76 */             MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(this.potion - 36));
/*     */             
/*  78 */             if (thePlayer.getRotationPitch() <= 80.0F) {
/*  79 */               RotationUtils.setTargetRotation(new Rotation(thePlayer.getRotationYaw(), RandomUtils.INSTANCE.nextFloat(80.0F, 90.0F)));
/*     */             }
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/*  85 */           potionInInventory = findPotion(9, 36);
/*  86 */           if (potionInInventory != -1 && InventoryUtils.hasSpaceHotbar())
/*  87 */           { if (((Boolean)this.openInventoryValue.get()).booleanValue() && !MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen())) {
/*     */               return;
/*     */             }
/*  90 */             boolean openInventory = (!MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen()) && ((Boolean)this.simulateInventory.get()).booleanValue());
/*     */             
/*  92 */             if (openInventory)
/*  93 */             { IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createOpenInventoryPacket = 0;
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
/* 152 */               if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY); iINetHandlerPlayClient.addToSendQueue(iPacket); }  MinecraftInstance.mc.getPlayerController().windowClick(0, potionInInventory, 0, 1, thePlayer); if (openInventory)
/*     */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow());  this.msTimer.reset(); }  break;
/* 154 */         case 2: if (this.potion >= 0 && RotationUtils.serverRotation.getPitch() >= 75.0F) { IItemStack itemStack = thePlayer.getInventory().getStackInSlot(this.potion); if (itemStack != null) { WEnumHand wEnumHand = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createUseItemPacket = 0; IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand); iINetHandlerPlayClient.addToSendQueue(iPacket);
/*     */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(thePlayer.getInventory().getCurrentItem()));
/*     */               this.msTimer.reset(); }
/*     */             
/*     */             this.potion = -1; }
/*     */           
/*     */           break;
/*     */       } 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */   
/*     */   private final int findPotion(int startSlot, int endSlot) {
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     for (int i = startSlot, j = endSlot; i < j; i++) {
/*     */       IItemStack stack = thePlayer.getInventoryContainer().getSlot(i).getStack();
/*     */       if (stack != null && MinecraftInstance.classProvider.isItemPotion(stack.getItem()) && stack.isSplash()) {
/*     */         if (stack.getItem() == null)
/*     */           Intrinsics.throwNpe(); 
/*     */         IItemPotion itemPotion = stack.getItem().asItemPotion();
/*     */         for (IPotionEffect potionEffect : itemPotion.getEffects(stack)) {
/*     */           if (potionEffect.getPotionID() == MinecraftInstance.classProvider.getPotionEnum(PotionType.HEAL).getId())
/*     */             return i; 
/*     */         } 
/*     */         if (!thePlayer.isPotionActive(MinecraftInstance.classProvider.getPotionEnum(PotionType.REGENERATION)))
/*     */           for (IPotionEffect potionEffect : itemPotion.getEffects(stack)) {
/*     */             if (potionEffect.getPotionID() == MinecraftInstance.classProvider.getPotionEnum(PotionType.REGENERATION).getId())
/*     */               return i; 
/*     */           }  
/*     */       } 
/*     */     } 
/*     */     return -1;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getTag() {
/*     */     return String.valueOf(((Number)this.healthValue.get()).floatValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoPot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */