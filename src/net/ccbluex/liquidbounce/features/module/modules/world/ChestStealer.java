/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.inventory.IGuiChest;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.inventory.ISlot;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.item.ItemUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "ChestStealer", description = "Automatically steals all items from a chest.", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000j\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\t\n\002\b\006\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\033\032\0020\0202\006\020\034\032\0020\035H\002J\030\020\036\032\0020\0372\006\020 \032\0020\0352\006\020!\032\0020\"H\002J\020\020#\032\0020\0372\006\020$\032\0020%H\003J\022\020&\032\0020\0372\b\020$\032\004\030\0010'H\007J\033\020(\032\0020\0202\b\020)\032\004\030\0010*2\006\020+\032\0020,H\bR\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\016\020\f\032\0020\rX\016¢\006\002\n\000R\016\020\016\032\0020\007X\004¢\006\002\n\000R\024\020\017\032\0020\0208BX\004¢\006\006\032\004\b\021\020\022R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\004X\004¢\006\002\n\000R\016\020\025\032\0020\026X\016¢\006\002\n\000R\016\020\027\032\0020\026X\016¢\006\002\n\000R\016\020\030\032\0020\tX\004¢\006\002\n\000R\016\020\031\032\0020\tX\004¢\006\002\n\000R\016\020\032\032\0020\tX\004¢\006\002\n\000¨\006-"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ChestStealer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoCloseMaxDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "autoCloseMinDelayValue", "autoCloseTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "autoCloseValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "chestTitleValue", "closeOnFullValue", "contentReceived", "", "delayTimer", "fullInventory", "", "getFullInventory", "()Z", "maxDelayValue", "minDelayValue", "nextCloseDelay", "", "nextDelay", "noCompassValue", "onlyItemsValue", "takeRandomizedValue", "isEmpty", "chest", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;", "move", "", "screen", "slot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "shouldTake", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "inventoryCleaner", "Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;", "XSJClient"})
/*     */ public final class ChestStealer extends Module {
/*  28 */   private final IntegerValue maxDelayValue = new ChestStealer$maxDelayValue$1("MaxDelay", 200, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ChestStealer$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ChestStealer$maxDelayValue$1 extends IntegerValue { ChestStealer$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  30 */       int i = ((Number)ChestStealer.this.minDelayValue.get()).intValue();
/*  31 */       if (i > newValue) {
/*  32 */         set(Integer.valueOf(i));
/*     */       }
/*  34 */       ChestStealer.this.nextDelay = TimeUtils.randomDelay(((Number)ChestStealer.this.minDelayValue.get()).intValue(), ((Number)get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  38 */   private final IntegerValue minDelayValue = new ChestStealer$minDelayValue$1("MinDelay", 150, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ChestStealer$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ChestStealer$minDelayValue$1 extends IntegerValue { ChestStealer$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  40 */       int i = ((Number)ChestStealer.this.maxDelayValue.get()).intValue();
/*     */       
/*  42 */       if (i < newValue) {
/*  43 */         set(Integer.valueOf(i));
/*     */       }
/*  45 */       ChestStealer.this.nextDelay = TimeUtils.randomDelay(((Number)get()).intValue(), ((Number)ChestStealer.this.maxDelayValue.get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  49 */   private final BoolValue takeRandomizedValue = new BoolValue("TakeRandomized", false);
/*  50 */   private final BoolValue onlyItemsValue = new BoolValue("OnlyItems", false);
/*  51 */   private final BoolValue noCompassValue = new BoolValue("NoCompass", false);
/*  52 */   private final BoolValue autoCloseValue = new BoolValue("AutoClose", true);
/*     */   
/*  54 */   private final IntegerValue autoCloseMaxDelayValue = new ChestStealer$autoCloseMaxDelayValue$1("AutoCloseMaxDelay", 0, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ChestStealer$autoCloseMaxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ChestStealer$autoCloseMaxDelayValue$1 extends IntegerValue { ChestStealer$autoCloseMaxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  56 */       int i = ((Number)ChestStealer.this.autoCloseMinDelayValue.get()).intValue();
/*  57 */       if (i > newValue) set(Integer.valueOf(i)); 
/*  58 */       ChestStealer.this.nextCloseDelay = TimeUtils.randomDelay(((Number)ChestStealer.this.autoCloseMinDelayValue.get()).intValue(), ((Number)get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  62 */   private final IntegerValue autoCloseMinDelayValue = new ChestStealer$autoCloseMinDelayValue$1("AutoCloseMinDelay", 0, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/world/ChestStealer$autoCloseMinDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class ChestStealer$autoCloseMinDelayValue$1 extends IntegerValue { ChestStealer$autoCloseMinDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  64 */       int i = ((Number)ChestStealer.this.autoCloseMaxDelayValue.get()).intValue();
/*  65 */       if (i < newValue) set(Integer.valueOf(i)); 
/*  66 */       ChestStealer.this.nextCloseDelay = TimeUtils.randomDelay(((Number)get()).intValue(), ((Number)ChestStealer.this.autoCloseMaxDelayValue.get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  70 */   private final BoolValue closeOnFullValue = new BoolValue("CloseOnFull", true);
/*  71 */   private final BoolValue chestTitleValue = new BoolValue("ChestTitle", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   private final MSTimer delayTimer = new MSTimer();
/*  78 */   private long nextDelay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*     */   
/*  80 */   private final MSTimer autoCloseTimer = new MSTimer();
/*  81 */   private long nextCloseDelay = TimeUtils.randomDelay(((Number)this.autoCloseMinDelayValue.get()).intValue(), ((Number)this.autoCloseMaxDelayValue.get()).intValue());
/*     */   private int contentReceived;
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@Nullable Render3DEvent event)
/*     */   {
/*  87 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/*  89 */     if (!MinecraftInstance.classProvider.isGuiChest(MinecraftInstance.mc.getCurrentScreen()) || MinecraftInstance.mc.getCurrentScreen() == null || !this.delayTimer.hasTimePassed(this.nextDelay)) {
/*  90 */       this.autoCloseTimer.reset();
/*     */       
/*     */       return;
/*     */     } 
/*  94 */     if (MinecraftInstance.mc.getCurrentScreen() == null) Intrinsics.throwNpe();  IGuiChest screen = MinecraftInstance.mc.getCurrentScreen().asGuiChest();
/*     */ 
/*     */     
/*  97 */     if (((Boolean)this.noCompassValue.get()).booleanValue()) { thePlayer.getInventory().getCurrentItemInHand().getItem(); if (Intrinsics.areEqual((thePlayer.getInventory().getCurrentItemInHand() != null && thePlayer.getInventory().getCurrentItemInHand().getItem() != null) ? thePlayer.getInventory().getCurrentItemInHand().getItem().getUnlocalizedName() : null, "item.compass")) {
/*     */         return;
/*     */       } }
/*     */     
/* 101 */     if (((Boolean)this.chestTitleValue.get()).booleanValue()) if (screen.getLowerChestInventory() != null) { if (screen.getLowerChestInventory() == null) Intrinsics.throwNpe();  if (MinecraftInstance.functions.getObjectFromItemRegistry(MinecraftInstance.classProvider.createResourceLocation("minecraft:chest")) == null) Intrinsics.throwNpe();  if (!StringsKt.contains$default(screen.getLowerChestInventory().getName(), MinecraftInstance.classProvider.createItemStack(MinecraftInstance.functions.getObjectFromItemRegistry(MinecraftInstance.classProvider.createResourceLocation("minecraft:chest"))).getDisplayName(), false, 2, null))
/*     */           return;  }
/*     */       else
/*     */       { return; }
/* 105 */         if (Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner");  InventoryCleaner inventoryCleaner = (InventoryCleaner)Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class);
/*     */ 
/*     */     
/* 108 */     if (!isEmpty(screen) && (!((Boolean)this.closeOnFullValue.get()).booleanValue() || !getFullInventory()))
/* 109 */     { this.autoCloseTimer.reset();
/*     */ 
/*     */       
/* 112 */       if (((Boolean)this.takeRandomizedValue.get()).booleanValue()) {
/*     */         while (true) {
/* 114 */           byte b1 = 0; List<ISlot> items = new ArrayList();
/*     */           int i;
/* 116 */           for (b1 = 0, i = screen.getInventoryRows() * 9; b1 < i; b1++) {
/* 117 */             if (screen.getInventorySlots() == null) Intrinsics.throwNpe();  ISlot iSlot = screen.getInventorySlots().getSlot(b1);
/*     */             
/* 119 */             IItemStack stack = iSlot.getStack();
/*     */             
/* 121 */             if (stack != null && (!((Boolean)this.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1))) {
/* 122 */               items.add(iSlot);
/*     */             }
/*     */           } 
/* 125 */           int randomSlot = Random.Default.nextInt(items.size());
/* 126 */           ISlot slot = items.get(randomSlot);
/*     */           
/* 128 */           move(screen, slot);
/* 129 */           if (this.delayTimer.hasTimePassed(this.nextDelay)) { List<ISlot> list = items; boolean bool = false; if (!(!list.isEmpty() ? 1 : 0))
/*     */               break;  continue; }
/*     */            break;
/*     */         }  return;
/*     */       }  byte b; int slotIndex;
/* 134 */       for (b = 0, slotIndex = screen.getInventoryRows() * 9; b < slotIndex; b++)
/* 135 */       { if (screen.getInventorySlots() == null) Intrinsics.throwNpe();  ISlot slot = screen.getInventorySlots().getSlot(b);
/*     */         
/* 137 */         IItemStack stack = slot.getStack();
/*     */         
/* 139 */         if (this.delayTimer.hasTimePassed(this.nextDelay)) { ChestStealer this_$iv = this; int $i$f$shouldTake = 0;
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
/* 185 */           if ((stack != null && !ItemUtils.isStackEmpty(stack) && (!((Boolean)this_$iv.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1)))) move(screen, slot);  }  }  } else if (((Boolean)this.autoCloseValue.get()).booleanValue()) { if (screen.getInventorySlots() == null) Intrinsics.throwNpe();  if (screen.getInventorySlots().getWindowId() == this.contentReceived && this.autoCloseTimer.hasTimePassed(this.nextCloseDelay)) { thePlayer.closeScreen(); this.nextCloseDelay = TimeUtils.randomDelay(((Number)this.autoCloseMinDelayValue.get()).intValue(), ((Number)this.autoCloseMaxDelayValue.get()).intValue()); }  }  } private final boolean isEmpty(IGuiChest chest) { if (Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner");  InventoryCleaner inventoryCleaner = (InventoryCleaner)Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class); byte b; int i; for (b = 0, i = chest.getInventoryRows() * 9; b < i; b++) { if (chest.getInventorySlots() == null)
/* 186 */         Intrinsics.throwNpe();  ISlot slot = chest.getInventorySlots().getSlot(b); IItemStack stack = slot.getStack(); ChestStealer this_$iv = this; int $i$f$shouldTake = 0; if ((stack != null && !ItemUtils.isStackEmpty(stack) && (!((Boolean)this_$iv.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1))))
/*     */         return false;  }
/*     */     
/*     */     return true; }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   private final void onPacket(PacketEvent event) {
/*     */     IPacket packet = event.getPacket();
/*     */     if (MinecraftInstance.classProvider.isSPacketWindowItems(packet))
/*     */       this.contentReceived = packet.asSPacketWindowItems().getWindowId(); 
/*     */   }
/*     */   
/*     */   private final boolean shouldTake(IItemStack stack, InventoryCleaner inventoryCleaner) {
/*     */     int $i$f$shouldTake = 0;
/*     */     return (stack != null && !ItemUtils.isStackEmpty(stack) && (!((Boolean)this.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1)));
/*     */   }
/*     */   
/*     */   private final void move(IGuiChest screen, ISlot slot) {
/*     */     screen.handleMouseClick(slot, slot.getSlotNumber(), 0, 1);
/*     */     this.delayTimer.reset();
/*     */     this.nextDelay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*     */   }
/*     */   
/*     */   private final boolean getFullInventory() {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnull -> 109
/*     */     //   12: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   17: dup
/*     */     //   18: ifnull -> 109
/*     */     //   21: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   26: dup
/*     */     //   27: ifnull -> 109
/*     */     //   30: checkcast java/lang/Iterable
/*     */     //   33: astore_1
/*     */     //   34: iconst_0
/*     */     //   35: istore_2
/*     */     //   36: aload_1
/*     */     //   37: instanceof java/util/Collection
/*     */     //   40: ifeq -> 59
/*     */     //   43: aload_1
/*     */     //   44: checkcast java/util/Collection
/*     */     //   47: invokeinterface isEmpty : ()Z
/*     */     //   52: ifeq -> 59
/*     */     //   55: iconst_1
/*     */     //   56: goto -> 111
/*     */     //   59: aload_1
/*     */     //   60: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   65: astore_3
/*     */     //   66: aload_3
/*     */     //   67: invokeinterface hasNext : ()Z
/*     */     //   72: ifeq -> 105
/*     */     //   75: aload_3
/*     */     //   76: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   81: astore #4
/*     */     //   83: aload #4
/*     */     //   85: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   88: astore #5
/*     */     //   90: iconst_0
/*     */     //   91: istore #6
/*     */     //   93: aload #5
/*     */     //   95: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   98: ifeq -> 66
/*     */     //   101: iconst_0
/*     */     //   102: goto -> 111
/*     */     //   105: iconst_1
/*     */     //   106: goto -> 111
/*     */     //   109: pop
/*     */     //   110: iconst_0
/*     */     //   111: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #183	-> 0
/*     */     //   #187	-> 36
/*     */     //   #188	-> 59
/*     */     //   #183	-> 95
/*     */     //   #189	-> 105
/*     */     //   #183	-> 109
/*     */     //   #183	-> 110
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   90	8	5	p1	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   93	5	6	$i$a$-unknown-ChestStealer$fullInventory$1	I
/*     */     //   83	22	4	element$iv	Ljava/lang/Object;
/*     */     //   34	72	1	$this$none$iv	Ljava/lang/Iterable;
/*     */     //   36	70	2	$i$f$none	I
/*     */     //   0	112	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/world/ChestStealer;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ChestStealer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */