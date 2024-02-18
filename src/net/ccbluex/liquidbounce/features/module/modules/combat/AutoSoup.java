/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*     */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.network.IINetHandlerPlayClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*     */ import net.ccbluex.liquidbounce.injection.backend.WrapperImpl;
/*     */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ 
/*     */ @ModuleInfo(name = "AutoSoup", description = "Makes you automatically eat soup whenever your health is low.", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\022\020\022\032\0020\0232\b\020\024\032\004\030\0010\025H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\nX\004¢\006\002\n\000R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R\016\020\020\032\0020\021X\004¢\006\002\n\000¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoSoup;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "bowlValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "delayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "healthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "openInventoryValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "simulateInventoryValue", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class AutoSoup extends Module {
/*  25 */   private final FloatValue healthValue = new FloatValue("Health", 15.0F, 0.0F, 20.0F);
/*  26 */   private final IntegerValue delayValue = new IntegerValue("Delay", 150, 0, 500);
/*  27 */   private final BoolValue openInventoryValue = new BoolValue("OpenInv", false);
/*  28 */   private final BoolValue simulateInventoryValue = new BoolValue("SimulateInventory", true);
/*  29 */   private final ListValue bowlValue = new ListValue("Bowl", new String[] { "Drop", "Move", "Stay" }, "Drop");
/*     */   
/*  31 */   private final MSTimer timer = new MSTimer();
/*     */   @NotNull
/*     */   public String getTag() {
/*  34 */     return String.valueOf(((Number)this.healthValue.get()).floatValue());
/*     */   }
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/*  38 */     if (!this.timer.hasTimePassed(((Number)this.delayValue.get()).intValue())) {
/*     */       return;
/*     */     }
/*  41 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  43 */       int soupInHotbar = InventoryUtils.findItem(36, 45, MinecraftInstance.classProvider.getItemEnum(ItemType.MUSHROOM_STEW));
/*     */       
/*  45 */       if (thePlayer.getHealth() <= ((Number)this.healthValue.get()).floatValue() && soupInHotbar != -1)
/*  46 */       { MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(soupInHotbar - 36));
/*  47 */         WEnumHand wEnumHand = WEnumHand.MAIN_HAND; IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createUseItemPacket = 0;
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
/*     */         
/* 107 */         IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketTryUseItem(wEnumHand); iINetHandlerPlayClient.addToSendQueue(iPacket); if (StringsKt.equals((String)this.bowlValue.get(), "Drop", true))
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.DROP_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN)));  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(thePlayer.getInventory().getCurrentItem())); this.timer.reset(); return; }  int bowlInHotbar = InventoryUtils.findItem(36, 45, MinecraftInstance.classProvider.getItemEnum(ItemType.BOWL)); if (StringsKt.equals((String)this.bowlValue.get(), "Move", true) && bowlInHotbar != -1) { if (((Boolean)this.openInventoryValue.get()).booleanValue() && !MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen()))
/*     */           return;  boolean bowlMovable = false; for (byte b1 = 9, b2 = 36; b1 <= b2; b1++) { IItemStack itemStack = thePlayer.getInventory().getStackInSlot(b1); if (itemStack == null) { bowlMovable = true; break; }
/*     */            if (Intrinsics.areEqual(itemStack.getItem(), MinecraftInstance.classProvider.getItemEnum(ItemType.BOWL)) && itemStack.getStackSize() < 64) { bowlMovable = true; break; }
/*     */            }
/* 112 */          if (bowlMovable) { boolean openInventory = (!MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen()) && ((Boolean)this.simulateInventoryValue.get()).booleanValue()); if (openInventory) { IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createOpenInventoryPacket = 0; if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY); iINetHandlerPlayClient.addToSendQueue(iPacket); }
/*     */            MinecraftInstance.mc.getPlayerController().windowClick(0, bowlInHotbar, 0, 1, thePlayer); }
/*     */          }
/*     */        int soupInInventory = InventoryUtils.findItem(9, 36, MinecraftInstance.classProvider.getItemEnum(ItemType.MUSHROOM_STEW)); if (soupInInventory != -1 && InventoryUtils.hasSpaceHotbar()) { if (((Boolean)this.openInventoryValue.get()).booleanValue() && !MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen()))
/*     */           return;  boolean openInventory = (!MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen()) && ((Boolean)this.simulateInventoryValue.get()).booleanValue()); if (openInventory) {
/* 117 */           IINetHandlerPlayClient iINetHandlerPlayClient = MinecraftInstance.mc.getNetHandler(); int $i$f$createOpenInventoryPacket = 0; if (Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer() == null) Intrinsics.throwNpe();  IPacket iPacket = (IPacket)WrapperImpl.INSTANCE.getClassProvider().createCPacketEntityAction((IEntity)Retreat.INSTANCE.getWrapper().getMinecraft().getThePlayer(), ICPacketEntityAction.WAction.OPEN_INVENTORY);
/*     */           iINetHandlerPlayClient.addToSendQueue(iPacket);
/*     */         } 
/*     */         MinecraftInstance.mc.getPlayerController().windowClick(0, soupInInventory, 0, 1, thePlayer);
/*     */         if (openInventory)
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow()); 
/*     */         this.timer.reset(); }
/*     */       
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoSoup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */