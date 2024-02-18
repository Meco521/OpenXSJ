/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.IntStream;
/*     */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.CrossVersionUtilsKt;
/*     */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.item.ArmorComparator;
/*     */ import net.ccbluex.liquidbounce.utils.item.ArmorPiece;
/*     */ import net.ccbluex.liquidbounce.utils.item.ItemUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "AutoArmor", description = "Automatically equips the best armor in your inventory.", category = ModuleCategory.COMBAT)
/*     */ public class AutoArmor
/*     */   extends Module
/*     */ {
/*  35 */   public static final ArmorComparator ARMOR_COMPARATOR = new ArmorComparator();
/*  36 */   private final IntegerValue minDelayValue = new IntegerValue("MinDelay", 100, 0, 400)
/*     */     {
/*     */       protected void onChanged(Integer oldValue, Integer newValue)
/*     */       {
/*  40 */         int maxDelay = ((Integer)AutoArmor.this.maxDelayValue.get()).intValue();
/*     */         
/*  42 */         if (maxDelay < newValue.intValue()) set(Integer.valueOf(maxDelay)); 
/*     */       }
/*     */     };
/*  45 */   private final IntegerValue maxDelayValue = new IntegerValue("MaxDelay", 200, 0, 400)
/*     */     {
/*     */       protected void onChanged(Integer oldValue, Integer newValue) {
/*  48 */         int minDelay = ((Integer)AutoArmor.this.minDelayValue.get()).intValue();
/*     */         
/*  50 */         if (minDelay > newValue.intValue()) set(Integer.valueOf(minDelay)); 
/*     */       }
/*     */     };
/*  53 */   private final BoolValue invOpenValue = new BoolValue("InvOpen", false);
/*  54 */   private final BoolValue simulateInventory = new BoolValue("SimulateInventory", true);
/*  55 */   private final BoolValue noMoveValue = new BoolValue("NoMove", false);
/*  56 */   private final IntegerValue itemDelayValue = new IntegerValue("ItemDelay", 0, 0, 5000);
/*  57 */   private final BoolValue hotbarValue = new BoolValue("Hotbar", true);
/*     */   
/*     */   private long delay;
/*     */   
/*     */   private boolean locked = false;
/*     */   
/*     */   @EventTarget
/*     */   public void onRender3D(Render3DEvent event) {
/*  65 */     if (!InventoryUtils.CLICK_TIMER.hasTimePassed(this.delay) || mc.getThePlayer() == null || (mc.getThePlayer().getOpenContainer() != null && mc.getThePlayer().getOpenContainer().getWindowId() != 0)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     Map<Integer, List<ArmorPiece>> armorPieces = (Map<Integer, List<ArmorPiece>>)IntStream.range(0, 36).filter(i -> { IItemStack itemStack = mc.getThePlayer().getInventory().getStackInSlot(i); return (itemStack != null && classProvider.isItemArmor(itemStack.getItem()) && (i < 9 || System.currentTimeMillis() - itemStack.getItemDelay() >= ((Integer)this.itemDelayValue.get()).intValue())); }).mapToObj(i -> new ArmorPiece(mc.getThePlayer().getInventory().getStackInSlot(i), i)).collect(Collectors.groupingBy(ArmorPiece::getArmorType));
/*     */     
/*  75 */     ArmorPiece[] bestArmor = new ArmorPiece[4];
/*     */     
/*  77 */     for (Map.Entry<Integer, List<ArmorPiece>> armorEntry : armorPieces.entrySet()) {
/*  78 */       bestArmor[((Integer)armorEntry.getKey()).intValue()] = ((List<ArmorPiece>)armorEntry.getValue()).stream().max((Comparator<? super ArmorPiece>)ARMOR_COMPARATOR).orElse(null);
/*     */     }
/*     */ 
/*     */     
/*  82 */     for (int i = 0; i < 4; i++) {
/*  83 */       ArmorPiece armorPiece = bestArmor[i];
/*     */       
/*  85 */       if (armorPiece != null) {
/*     */         
/*  87 */         int armorSlot = 3 - i;
/*     */         
/*  89 */         ArmorPiece oldArmor = new ArmorPiece(mc.getThePlayer().getInventory().armorItemInSlot(armorSlot), -1);
/*     */         
/*  91 */         if (ItemUtils.isStackEmpty(oldArmor.getItemStack()) || !classProvider.isItemArmor(oldArmor.getItemStack().getItem()) || ARMOR_COMPARATOR.compare(oldArmor, armorPiece) < 0) {
/*  92 */           if (!ItemUtils.isStackEmpty(oldArmor.getItemStack()) && move(8 - 3 - armorSlot, true)) {
/*  93 */             this.locked = true;
/*     */             
/*     */             return;
/*     */           } 
/*  97 */           if (ItemUtils.isStackEmpty(mc.getThePlayer().getInventory().armorItemInSlot(armorSlot)) && move(armorPiece.getSlot(), false)) {
/*  98 */             this.locked = true;
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 104 */     this.locked = false;
/*     */   }
/*     */   
/*     */   public boolean isLocked() {
/* 108 */     return (getState() && this.locked);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean move(int item, boolean isArmorSlot) {
/* 119 */     if (!isArmorSlot && item < 9 && ((Boolean)this.hotbarValue.get()).booleanValue() && !classProvider.isGuiInventory(mc.getCurrentScreen())) {
/* 120 */       mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(item));
/* 121 */       mc.getNetHandler().addToSendQueue(CrossVersionUtilsKt.createUseItemPacket(WEnumHand.MAIN_HAND));
/* 122 */       mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(mc.getThePlayer().getInventory().getCurrentItem()));
/*     */       
/* 124 */       this.delay = TimeUtils.randomDelay(((Integer)this.minDelayValue.get()).intValue(), ((Integer)this.maxDelayValue.get()).intValue());
/*     */       
/* 126 */       return true;
/* 127 */     }  if ((!((Boolean)this.noMoveValue.get()).booleanValue() || !MovementUtils.isMoving()) && (!((Boolean)this.invOpenValue.get()).booleanValue() || classProvider.isGuiInventory(mc.getCurrentScreen())) && item != -1) {
/* 128 */       boolean openInventory = (((Boolean)this.simulateInventory.get()).booleanValue() && !classProvider.isGuiInventory(mc.getCurrentScreen()));
/*     */       
/* 130 */       if (openInventory) mc.getNetHandler().addToSendQueue(CrossVersionUtilsKt.createOpenInventoryPacket());
/*     */       
/* 132 */       boolean full = isArmorSlot;
/*     */       
/* 134 */       if (full) {
/* 135 */         for (IItemStack iItemStack : mc.getThePlayer().getInventory().getMainInventory()) {
/* 136 */           if (ItemUtils.isStackEmpty(iItemStack)) {
/* 137 */             full = false;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 143 */       if (full) {
/* 144 */         mc.getPlayerController().windowClick(mc.getThePlayer().getInventoryContainer().getWindowId(), item, 1, 4, mc.getThePlayer());
/*     */       } else {
/* 146 */         mc.getPlayerController().windowClick(mc.getThePlayer().getInventoryContainer().getWindowId(), isArmorSlot ? item : ((item < 9) ? (item + 36) : item), 0, 1, mc.getThePlayer());
/*     */       } 
/*     */       
/* 149 */       this.delay = TimeUtils.randomDelay(((Integer)this.minDelayValue.get()).intValue(), ((Integer)this.maxDelayValue.get()).intValue());
/*     */       
/* 151 */       if (openInventory) mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketCloseWindow());
/*     */       
/* 153 */       return true;
/*     */     } 
/*     */     
/* 156 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */