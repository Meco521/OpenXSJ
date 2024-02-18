/*     */ package net.ccbluex.liquidbounce.utils;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.ClickWindowEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Listenable;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public final class InventoryUtils
/*     */   extends MinecraftInstance
/*     */   implements Listenable {
/*  21 */   public static final MSTimer CLICK_TIMER = new MSTimer();
/*  22 */   public static final List<IBlock> BLOCK_BLACKLIST = Arrays.asList(new IBlock[] { classProvider
/*  23 */         .getBlockEnum(BlockType.CHEST), classProvider.getBlockEnum(BlockType.ENDER_CHEST), classProvider.getBlockEnum(BlockType.TRAPPED_CHEST), classProvider.getBlockEnum(BlockType.ANVIL), classProvider.getBlockEnum(BlockType.SAND), classProvider.getBlockEnum(BlockType.WEB), classProvider.getBlockEnum(BlockType.TORCH), classProvider
/*  24 */         .getBlockEnum(BlockType.CRAFTING_TABLE), classProvider.getBlockEnum(BlockType.FURNACE), classProvider.getBlockEnum(BlockType.WATERLILY), classProvider.getBlockEnum(BlockType.DISPENSER), classProvider.getBlockEnum(BlockType.STONE_PRESSURE_PLATE), classProvider.getBlockEnum(BlockType.WODDEN_PRESSURE_PLATE), classProvider
/*  25 */         .getBlockEnum(BlockType.NOTEBLOCK), classProvider.getBlockEnum(BlockType.DROPPER), classProvider.getBlockEnum(BlockType.TNT), classProvider.getBlockEnum(BlockType.STANDING_BANNER), classProvider.getBlockEnum(BlockType.WALL_BANNER), classProvider.getBlockEnum(BlockType.REDSTONE_TORCH) });
/*     */ 
/*     */   
/*     */   public static boolean isBlockListBlock(IItemBlock itemBlock) {
/*  29 */     IBlock block = itemBlock.getBlock();
/*  30 */     return (BLOCK_BLACKLIST.contains(block) || !block.isFullCube(block.getDefaultState()));
/*     */   }
/*     */   
/*     */   public static int findItem2(int startSlot, int endSlot, Item item) {
/*  34 */     for (int i = startSlot; i < endSlot; i++) {
/*  35 */       IItemStack stack = mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */       
/*  37 */       if (stack != null && stack.getItem() == item)
/*  38 */         return i; 
/*     */     } 
/*  40 */     return -1;
/*     */   }
/*     */   public static int findItem(int startSlot, int endSlot, IItem item) {
/*  43 */     for (int i = startSlot; i < endSlot; i++) {
/*  44 */       IItemStack stack = mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */       
/*  46 */       if (stack != null && stack.getItem().equals(item)) {
/*  47 */         return i;
/*     */       }
/*     */     } 
/*  50 */     return -1;
/*     */   }
/*     */   
/*     */   public static boolean hasSpaceHotbar() {
/*  54 */     for (int i = 36; i < 45; i++) {
/*  55 */       IItemStack stack = mc.getThePlayer().getInventory().getStackInSlot(i);
/*     */       
/*  57 */       if (stack == null) {
/*  58 */         return true;
/*     */       }
/*     */     } 
/*  61 */     return false;
/*     */   }
/*     */   public static int findAutoBlockBlock() {
/*     */     int i;
/*  65 */     for (i = 36; i < 45; i++) {
/*  66 */       IItemStack itemStack = mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */       
/*  68 */       if (itemStack != null && classProvider.isItemBlock(itemStack.getItem()) && itemStack.getStackSize() > 0) {
/*  69 */         IItemBlock itemBlock = itemStack.getItem().asItemBlock();
/*  70 */         IBlock block = itemBlock.getBlock();
/*     */         
/*  72 */         if (block.isFullCube(block.getDefaultState()) && !BLOCK_BLACKLIST.contains(block) && 
/*  73 */           !classProvider.isBlockBush(block)) {
/*  74 */           return i;
/*     */         }
/*     */       } 
/*     */     } 
/*  78 */     for (i = 36; i < 45; i++) {
/*  79 */       IItemStack itemStack = mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */       
/*  81 */       if (itemStack != null && classProvider.isItemBlock(itemStack.getItem()) && itemStack.getStackSize() > 0) {
/*  82 */         IItemBlock itemBlock = itemStack.getItem().asItemBlock();
/*  83 */         IBlock block = itemBlock.getBlock();
/*     */         
/*  85 */         if (!BLOCK_BLACKLIST.contains(block) && !classProvider.isBlockBush(block)) {
/*  86 */           return i;
/*     */         }
/*     */       } 
/*     */     } 
/*  90 */     return -1;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onClick(ClickWindowEvent event) {
/*  95 */     CLICK_TIMER.reset();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onPacket(PacketEvent event) {
/* 100 */     IPacket packet = event.getPacket();
/*     */     
/* 102 */     if (classProvider.isCPacketPlayerBlockPlacement(packet)) {
/* 103 */       CLICK_TIMER.reset();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean handleEvents() {
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\utils\InventoryUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */