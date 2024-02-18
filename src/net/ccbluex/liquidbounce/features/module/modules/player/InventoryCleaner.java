/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.item.ItemUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "InventoryCleaner", description = "Automatically throws away useless items.", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\021\n\002\020\016\n\002\b\007\n\002\030\002\n\002\b\n\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020$\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001B\005¢\006\002\020\002J!\020\037\032\004\030\0010 2\006\020!\032\0020 2\b\020\"\032\004\030\0010#H\002¢\006\002\020$J\026\020%\032\0020&2\006\020'\032\0020#2\006\020(\032\0020 J(\020\013\032\016\022\004\022\0020 \022\004\022\0020#0)2\b\b\002\020*\032\0020 2\b\b\002\020+\032\0020 H\002J\020\020,\032\0020-2\006\020.\032\0020/H\007J\b\0200\032\0020-H\002J\020\0201\032\0020\r2\006\020!\032\0020 H\002R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\026\020\013\032\b\022\004\022\0020\r0\fX\004¢\006\004\n\002\020\016R\016\020\017\032\0020\nX\004¢\006\002\n\000R\016\020\020\032\0020\nX\004¢\006\002\n\000R\016\020\021\032\0020\006X\004¢\006\002\n\000R\016\020\022\032\0020\006X\004¢\006\002\n\000R\016\020\023\032\0020\006X\004¢\006\002\n\000R\016\020\024\032\0020\025X\004¢\006\002\n\000R\016\020\026\032\0020\025X\004¢\006\002\n\000R\016\020\027\032\0020\025X\004¢\006\002\n\000R\016\020\030\032\0020\025X\004¢\006\002\n\000R\016\020\031\032\0020\025X\004¢\006\002\n\000R\016\020\032\032\0020\025X\004¢\006\002\n\000R\016\020\033\032\0020\025X\004¢\006\002\n\000R\016\020\034\032\0020\025X\004¢\006\002\n\000R\016\020\035\032\0020\025X\004¢\006\002\n\000R\016\020\036\032\0020\006X\004¢\006\002\n\000¨\0062"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delay", "", "hotbarValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "ignoreVehiclesValue", "invOpenValue", "itemDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "items", "", "", "[Ljava/lang/String;", "maxDelayValue", "minDelayValue", "noMoveValue", "randomSlotValue", "simulateInventory", "sortSlot1Value", "Lnet/ccbluex/liquidbounce/value/ListValue;", "sortSlot2Value", "sortSlot3Value", "sortSlot4Value", "sortSlot5Value", "sortSlot6Value", "sortSlot7Value", "sortSlot8Value", "sortSlot9Value", "sortValue", "findBetterItem", "", "targetSlot", "slotStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "(ILnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Ljava/lang/Integer;", "isUseful", "", "itemStack", "slot", "", "start", "end", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "sortHotbar", "type", "XSJClient"})
/*     */ public final class InventoryCleaner
/*     */   extends Module
/*     */ {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "invoke"})
/*     */   static final class InventoryCleaner$findBetterItem$currentTypeChecker$1
/*     */     extends Lambda
/*     */     implements Function1<IItem, Boolean>
/*     */   {
/*     */     public static final InventoryCleaner$findBetterItem$currentTypeChecker$1 INSTANCE = new InventoryCleaner$findBetterItem$currentTypeChecker$1();
/*     */     
/*     */     InventoryCleaner$findBetterItem$currentTypeChecker$1() {
/*     */       super(1);
/*     */     }
/*     */     
/*     */     public final boolean invoke(@Nullable IItem item) {
/* 222 */       return MinecraftInstance.classProvider.isItemSword(item); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "obj", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "invoke"})
/* 223 */   static final class InventoryCleaner$findBetterItem$currentTypeChecker$2 extends Lambda implements Function1<IItem, Boolean> { public static final InventoryCleaner$findBetterItem$currentTypeChecker$2 INSTANCE = new InventoryCleaner$findBetterItem$currentTypeChecker$2(); public final boolean invoke(@Nullable IItem obj) { return MinecraftInstance.classProvider.isItemPickaxe(obj); } InventoryCleaner$findBetterItem$currentTypeChecker$2() { super(1); } }
/* 224 */    @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "obj", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "invoke"}) static final class InventoryCleaner$findBetterItem$currentTypeChecker$3 extends Lambda implements Function1<IItem, Boolean> { public final boolean invoke(@Nullable IItem obj) { return MinecraftInstance.classProvider.isItemAxe(obj); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final InventoryCleaner$findBetterItem$currentTypeChecker$3 INSTANCE = new InventoryCleaner$findBetterItem$currentTypeChecker$3();
/*     */ 
/*     */ 
/*     */     
/*     */     InventoryCleaner$findBetterItem$currentTypeChecker$3() {
/*     */       super(1);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue maxDelayValue = new InventoryCleaner$maxDelayValue$1("MaxDelay", 600, 0, 1000);
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*     */   public static final class InventoryCleaner$maxDelayValue$1
/*     */     extends IntegerValue
/*     */   {
/*     */     InventoryCleaner$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) {
/*     */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void onChanged(int oldValue, int newValue) {
/*     */       int minCPS = ((Number)InventoryCleaner.this.minDelayValue.get()).intValue();
/*     */       if (minCPS > newValue) {
/*     */         set(Integer.valueOf(minCPS));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final IntegerValue minDelayValue = new InventoryCleaner$minDelayValue$1("MinDelay", 400, 0, 1000);
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*     */   public static final class InventoryCleaner$minDelayValue$1
/*     */     extends IntegerValue
/*     */   {
/*     */     InventoryCleaner$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) {
/*     */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void onChanged(int oldValue, int newValue) {
/*     */       int maxDelay = ((Number)InventoryCleaner.this.maxDelayValue.get()).intValue();
/*     */       if (maxDelay < newValue) {
/*     */         set(Integer.valueOf(maxDelay));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue invOpenValue = new BoolValue("InvOpen", false);
/*     */ 
/*     */   
/*     */   private final BoolValue simulateInventory = new BoolValue("SimulateInventory", true);
/*     */ 
/*     */   
/*     */   private final BoolValue noMoveValue = new BoolValue("NoMove", false);
/*     */ 
/*     */   
/*     */   private final BoolValue ignoreVehiclesValue = new BoolValue("IgnoreVehicles", false);
/*     */ 
/*     */   
/*     */   private final BoolValue hotbarValue = new BoolValue("Hotbar", true);
/*     */ 
/*     */   
/*     */   private final BoolValue randomSlotValue = new BoolValue("RandomSlot", false);
/*     */ 
/*     */   
/*     */   private final BoolValue sortValue = new BoolValue("Sort", true);
/*     */ 
/*     */   
/*     */   private final IntegerValue itemDelayValue = new IntegerValue("ItemDelay", 0, 0, 5000);
/*     */   
/*     */   private final String[] items = new String[] { 
/*     */       "None", "Ignore", "Sword", "Bow", "Pickaxe", "Axe", "Food", "Block", "Water", "Gapple", 
/*     */       "Pearl" };
/*     */   
/*     */   private final ListValue sortSlot1Value = new ListValue("SortSlot-1", this.items, "Sword");
/*     */   
/*     */   private final ListValue sortSlot2Value = new ListValue("SortSlot-2", this.items, "Bow");
/*     */   
/*     */   private final ListValue sortSlot3Value = new ListValue("SortSlot-3", this.items, "Pickaxe");
/*     */   
/*     */   private final ListValue sortSlot4Value = new ListValue("SortSlot-4", this.items, "Axe");
/*     */   
/*     */   private final ListValue sortSlot5Value = new ListValue("SortSlot-5", this.items, "None");
/*     */   
/*     */   private final ListValue sortSlot6Value = new ListValue("SortSlot-6", this.items, "None");
/*     */   
/*     */   private final ListValue sortSlot7Value = new ListValue("SortSlot-7", this.items, "Food");
/*     */   
/*     */   private final ListValue sortSlot8Value = new ListValue("SortSlot-8", this.items, "Block");
/*     */   
/*     */   private final ListValue sortSlot9Value = new ListValue("SortSlot-9", this.items, "Block");
/*     */   
/*     */   private long delay;
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 23
/*     */     //   21: pop
/*     */     //   22: return
/*     */     //   23: astore_2
/*     */     //   24: getstatic net/ccbluex/liquidbounce/utils/InventoryUtils.CLICK_TIMER : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   27: aload_0
/*     */     //   28: getfield delay : J
/*     */     //   31: invokevirtual hasTimePassed : (J)Z
/*     */     //   34: ifeq -> 158
/*     */     //   37: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   40: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   43: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   48: invokeinterface isGuiInventory : (Ljava/lang/Object;)Z
/*     */     //   53: ifne -> 72
/*     */     //   56: aload_0
/*     */     //   57: getfield invOpenValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   60: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   63: checkcast java/lang/Boolean
/*     */     //   66: invokevirtual booleanValue : ()Z
/*     */     //   69: ifne -> 158
/*     */     //   72: aload_0
/*     */     //   73: getfield noMoveValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   76: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   79: checkcast java/lang/Boolean
/*     */     //   82: invokevirtual booleanValue : ()Z
/*     */     //   85: ifeq -> 94
/*     */     //   88: invokestatic isMoving : ()Z
/*     */     //   91: ifne -> 158
/*     */     //   94: aload_2
/*     */     //   95: invokeinterface getOpenContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   100: ifnull -> 124
/*     */     //   103: aload_2
/*     */     //   104: invokeinterface getOpenContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   109: dup
/*     */     //   110: ifnonnull -> 116
/*     */     //   113: invokestatic throwNpe : ()V
/*     */     //   116: invokeinterface getWindowId : ()I
/*     */     //   121: ifne -> 158
/*     */     //   124: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   127: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   130: ldc net/ccbluex/liquidbounce/features/module/modules/combat/AutoArmor
/*     */     //   132: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   135: dup
/*     */     //   136: ifnonnull -> 149
/*     */     //   139: new kotlin/TypeCastException
/*     */     //   142: dup
/*     */     //   143: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.AutoArmor'
/*     */     //   145: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   148: athrow
/*     */     //   149: checkcast net/ccbluex/liquidbounce/features/module/modules/combat/AutoArmor
/*     */     //   152: invokevirtual isLocked : ()Z
/*     */     //   155: ifeq -> 159
/*     */     //   158: return
/*     */     //   159: aload_0
/*     */     //   160: getfield sortValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   163: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   166: checkcast java/lang/Boolean
/*     */     //   169: invokevirtual booleanValue : ()Z
/*     */     //   172: ifeq -> 179
/*     */     //   175: aload_0
/*     */     //   176: invokespecial sortHotbar : ()V
/*     */     //   179: getstatic net/ccbluex/liquidbounce/utils/InventoryUtils.CLICK_TIMER : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   182: aload_0
/*     */     //   183: getfield delay : J
/*     */     //   186: invokevirtual hasTimePassed : (J)Z
/*     */     //   189: ifeq -> 639
/*     */     //   192: aload_0
/*     */     //   193: bipush #9
/*     */     //   195: aload_0
/*     */     //   196: getfield hotbarValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   199: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   202: checkcast java/lang/Boolean
/*     */     //   205: invokevirtual booleanValue : ()Z
/*     */     //   208: ifeq -> 216
/*     */     //   211: bipush #45
/*     */     //   213: goto -> 218
/*     */     //   216: bipush #36
/*     */     //   218: invokespecial items : (II)Ljava/util/Map;
/*     */     //   221: astore #4
/*     */     //   223: iconst_0
/*     */     //   224: istore #5
/*     */     //   226: aload #4
/*     */     //   228: astore #6
/*     */     //   230: new java/util/LinkedHashMap
/*     */     //   233: dup
/*     */     //   234: invokespecial <init> : ()V
/*     */     //   237: checkcast java/util/Map
/*     */     //   240: astore #7
/*     */     //   242: iconst_0
/*     */     //   243: istore #8
/*     */     //   245: aload #6
/*     */     //   247: astore #9
/*     */     //   249: iconst_0
/*     */     //   250: istore #10
/*     */     //   252: aload #9
/*     */     //   254: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   259: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   264: astore #11
/*     */     //   266: aload #11
/*     */     //   268: invokeinterface hasNext : ()Z
/*     */     //   273: ifeq -> 358
/*     */     //   276: aload #11
/*     */     //   278: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   283: checkcast java/util/Map$Entry
/*     */     //   286: astore #12
/*     */     //   288: aload #12
/*     */     //   290: astore #13
/*     */     //   292: iconst_0
/*     */     //   293: istore #14
/*     */     //   295: aload_0
/*     */     //   296: aload #13
/*     */     //   298: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   303: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   306: aload #13
/*     */     //   308: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   313: checkcast java/lang/Number
/*     */     //   316: invokevirtual intValue : ()I
/*     */     //   319: invokevirtual isUseful : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)Z
/*     */     //   322: ifne -> 329
/*     */     //   325: iconst_1
/*     */     //   326: goto -> 330
/*     */     //   329: iconst_0
/*     */     //   330: ifeq -> 355
/*     */     //   333: aload #7
/*     */     //   335: aload #12
/*     */     //   337: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   342: aload #12
/*     */     //   344: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   349: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   354: pop
/*     */     //   355: goto -> 266
/*     */     //   358: aload #7
/*     */     //   360: nop
/*     */     //   361: invokeinterface keySet : ()Ljava/util/Set;
/*     */     //   366: checkcast java/util/Collection
/*     */     //   369: invokestatic toMutableList : (Ljava/util/Collection;)Ljava/util/List;
/*     */     //   372: astore_3
/*     */     //   373: aload_0
/*     */     //   374: getfield randomSlotValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   377: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   380: checkcast java/lang/Boolean
/*     */     //   383: invokevirtual booleanValue : ()Z
/*     */     //   386: ifeq -> 400
/*     */     //   389: aload_3
/*     */     //   390: astore #4
/*     */     //   392: iconst_0
/*     */     //   393: istore #5
/*     */     //   395: aload #4
/*     */     //   397: invokestatic shuffle : (Ljava/util/List;)V
/*     */     //   400: aload_3
/*     */     //   401: invokestatic firstOrNull : (Ljava/util/List;)Ljava/lang/Object;
/*     */     //   404: checkcast java/lang/Integer
/*     */     //   407: dup
/*     */     //   408: ifnull -> 417
/*     */     //   411: invokevirtual intValue : ()I
/*     */     //   414: goto -> 421
/*     */     //   417: pop
/*     */     //   418: goto -> 639
/*     */     //   421: istore #4
/*     */     //   423: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   426: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   429: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   434: invokeinterface isGuiInventory : (Ljava/lang/Object;)Z
/*     */     //   439: ifne -> 462
/*     */     //   442: aload_0
/*     */     //   443: getfield simulateInventory : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   446: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   449: checkcast java/lang/Boolean
/*     */     //   452: invokevirtual booleanValue : ()Z
/*     */     //   455: ifeq -> 462
/*     */     //   458: iconst_1
/*     */     //   459: goto -> 463
/*     */     //   462: iconst_0
/*     */     //   463: istore #5
/*     */     //   465: iload #5
/*     */     //   467: ifeq -> 538
/*     */     //   470: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   473: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   478: astore #15
/*     */     //   480: iconst_0
/*     */     //   481: istore #6
/*     */     //   483: nop
/*     */     //   484: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   487: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   490: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   493: invokevirtual getWrapper : ()Lnet/ccbluex/liquidbounce/api/Wrapper;
/*     */     //   496: invokeinterface getMinecraft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   501: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   506: dup
/*     */     //   507: ifnonnull -> 513
/*     */     //   510: invokestatic throwNpe : ()V
/*     */     //   513: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   516: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.OPEN_INVENTORY : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   519: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   524: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   527: astore #16
/*     */     //   529: aload #15
/*     */     //   531: aload #16
/*     */     //   533: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   538: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   541: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   546: aload_2
/*     */     //   547: invokeinterface getOpenContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   552: dup
/*     */     //   553: ifnonnull -> 559
/*     */     //   556: invokestatic throwNpe : ()V
/*     */     //   559: invokeinterface getWindowId : ()I
/*     */     //   564: iload #4
/*     */     //   566: iconst_1
/*     */     //   567: iconst_4
/*     */     //   568: aload_2
/*     */     //   569: invokeinterface windowClick : (IIIILnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   574: iload #5
/*     */     //   576: ifeq -> 603
/*     */     //   579: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   582: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   587: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   590: invokeinterface createCPacketCloseWindow : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCloseWindow;
/*     */     //   595: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   598: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   603: aload_0
/*     */     //   604: aload_0
/*     */     //   605: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   608: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   611: checkcast java/lang/Number
/*     */     //   614: invokevirtual intValue : ()I
/*     */     //   617: aload_0
/*     */     //   618: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   621: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   624: checkcast java/lang/Number
/*     */     //   627: invokevirtual intValue : ()I
/*     */     //   630: invokestatic randomDelay : (II)J
/*     */     //   633: putfield delay : J
/*     */     //   636: goto -> 179
/*     */     //   639: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #75	-> 6
/*     */     //   #75	-> 21
/*     */     //   #77	-> 24
/*     */     //   #78	-> 24
/*     */     //   #79	-> 24
/*     */     //   #80	-> 24
/*     */     //   #81	-> 24
/*     */     //   #77	-> 24
/*     */     //   #78	-> 37
/*     */     //   #79	-> 72
/*     */     //   #81	-> 124
/*     */     //   #82	-> 158
/*     */     //   #84	-> 159
/*     */     //   #85	-> 175
/*     */     //   #87	-> 179
/*     */     //   #88	-> 192
/*     */     //   #91	-> 192
/*     */     //   #88	-> 192
/*     */     //   #90	-> 192
/*     */     //   #88	-> 192
/*     */     //   #89	-> 192
/*     */     //   #88	-> 192
/*     */     //   #89	-> 223
/*     */     //   #393	-> 226
/*     */     //   #394	-> 245
/*     */     //   #395	-> 288
/*     */     //   #89	-> 295
/*     */     //   #396	-> 333
/*     */     //   #394	-> 355
/*     */     //   #399	-> 358
/*     */     //   #91	-> 369
/*     */     //   #88	-> 372
/*     */     //   #94	-> 373
/*     */     //   #95	-> 389
/*     */     //   #97	-> 400
/*     */     //   #97	-> 417
/*     */     //   #100	-> 423
/*     */     //   #102	-> 465
/*     */     //   #103	-> 470
/*     */     //   #400	-> 483
/*     */     //   #401	-> 483
/*     */     //   #404	-> 484
/*     */     //   #401	-> 527
/*     */     //   #103	-> 533
/*     */     //   #105	-> 538
/*     */     //   #107	-> 574
/*     */     //   #108	-> 579
/*     */     //   #110	-> 603
/*     */     //   #87	-> 636
/*     */     //   #112	-> 639
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   292	38	13	it	Ljava/util/Map$Entry;
/*     */     //   295	35	14	$i$a$-filter-InventoryCleaner$onUpdate$garbageItems$1	I
/*     */     //   288	67	12	element$iv$iv	Ljava/util/Map$Entry;
/*     */     //   242	118	6	$this$filterTo$iv$iv	Ljava/util/Map;
/*     */     //   242	118	7	destination$iv$iv	Ljava/util/Map;
/*     */     //   245	115	8	$i$f$filterTo	I
/*     */     //   223	138	4	$this$filter$iv	Ljava/util/Map;
/*     */     //   226	135	5	$i$f$filter	I
/*     */     //   483	44	6	$i$f$createOpenInventoryPacket	I
/*     */     //   465	171	5	openInventory	Z
/*     */     //   423	213	4	garbageItem	I
/*     */     //   373	263	3	garbageItems	Ljava/util/List;
/*     */     //   24	616	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	640	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;
/*     */     //   0	640	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isUseful(@NotNull IItemStack itemStack, int slot) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'itemStack'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: nop
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   14: astore_3
/*     */     //   15: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   18: aload_3
/*     */     //   19: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   24: ifne -> 39
/*     */     //   27: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   30: aload_3
/*     */     //   31: invokeinterface isItemTool : (Ljava/lang/Object;)Z
/*     */     //   36: ifeq -> 495
/*     */     //   39: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   42: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   47: dup
/*     */     //   48: ifnull -> 54
/*     */     //   51: goto -> 57
/*     */     //   54: pop
/*     */     //   55: iconst_1
/*     */     //   56: ireturn
/*     */     //   57: astore #4
/*     */     //   59: iload_2
/*     */     //   60: bipush #36
/*     */     //   62: if_icmplt -> 113
/*     */     //   65: aload_0
/*     */     //   66: iload_2
/*     */     //   67: bipush #36
/*     */     //   69: isub
/*     */     //   70: aload #4
/*     */     //   72: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   77: iload_2
/*     */     //   78: bipush #36
/*     */     //   80: isub
/*     */     //   81: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   86: invokespecial findBetterItem : (ILnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Ljava/lang/Integer;
/*     */     //   89: iload_2
/*     */     //   90: bipush #36
/*     */     //   92: isub
/*     */     //   93: istore #5
/*     */     //   95: dup
/*     */     //   96: ifnonnull -> 103
/*     */     //   99: pop
/*     */     //   100: goto -> 113
/*     */     //   103: invokevirtual intValue : ()I
/*     */     //   106: iload #5
/*     */     //   108: if_icmpne -> 113
/*     */     //   111: iconst_1
/*     */     //   112: ireturn
/*     */     //   113: iconst_0
/*     */     //   114: istore #5
/*     */     //   116: bipush #8
/*     */     //   118: istore #6
/*     */     //   120: iload #5
/*     */     //   122: iload #6
/*     */     //   124: if_icmpgt -> 242
/*     */     //   127: aload_0
/*     */     //   128: iload #5
/*     */     //   130: invokespecial type : (I)Ljava/lang/String;
/*     */     //   133: ldc_w 'sword'
/*     */     //   136: iconst_1
/*     */     //   137: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   140: ifeq -> 155
/*     */     //   143: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   146: aload_3
/*     */     //   147: invokeinterface isItemSword : (Ljava/lang/Object;)Z
/*     */     //   152: ifne -> 211
/*     */     //   155: aload_0
/*     */     //   156: iload #5
/*     */     //   158: invokespecial type : (I)Ljava/lang/String;
/*     */     //   161: ldc_w 'pickaxe'
/*     */     //   164: iconst_1
/*     */     //   165: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   168: ifeq -> 183
/*     */     //   171: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   174: aload_3
/*     */     //   175: invokeinterface isItemPickaxe : (Ljava/lang/Object;)Z
/*     */     //   180: ifne -> 211
/*     */     //   183: aload_0
/*     */     //   184: iload #5
/*     */     //   186: invokespecial type : (I)Ljava/lang/String;
/*     */     //   189: ldc_w 'axe'
/*     */     //   192: iconst_1
/*     */     //   193: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   196: ifeq -> 236
/*     */     //   199: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   202: aload_3
/*     */     //   203: invokeinterface isItemAxe : (Ljava/lang/Object;)Z
/*     */     //   208: ifeq -> 236
/*     */     //   211: aload_0
/*     */     //   212: iload #5
/*     */     //   214: aload #4
/*     */     //   216: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   221: iload #5
/*     */     //   223: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   228: invokespecial findBetterItem : (ILnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Ljava/lang/Integer;
/*     */     //   231: ifnonnull -> 236
/*     */     //   234: iconst_1
/*     */     //   235: ireturn
/*     */     //   236: iinc #5, 1
/*     */     //   239: goto -> 120
/*     */     //   242: aload_1
/*     */     //   243: ldc_w 'generic.attackDamage'
/*     */     //   246: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*     */     //   251: checkcast java/lang/Iterable
/*     */     //   254: invokestatic firstOrNull : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   257: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*     */     //   260: dup
/*     */     //   261: ifnull -> 272
/*     */     //   264: invokeinterface getAmount : ()D
/*     */     //   269: goto -> 274
/*     */     //   272: pop
/*     */     //   273: dconst_0
/*     */     //   274: ldc2_w 1.25
/*     */     //   277: aload_1
/*     */     //   278: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   281: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   284: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   289: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   292: i2d
/*     */     //   293: dmul
/*     */     //   294: dadd
/*     */     //   295: dstore #5
/*     */     //   297: aload_0
/*     */     //   298: iconst_0
/*     */     //   299: bipush #45
/*     */     //   301: invokespecial items : (II)Ljava/util/Map;
/*     */     //   304: astore #7
/*     */     //   306: iconst_0
/*     */     //   307: istore #8
/*     */     //   309: aload #7
/*     */     //   311: invokeinterface isEmpty : ()Z
/*     */     //   316: ifeq -> 323
/*     */     //   319: iconst_1
/*     */     //   320: goto -> 1285
/*     */     //   323: aload #7
/*     */     //   325: astore #9
/*     */     //   327: iconst_0
/*     */     //   328: istore #10
/*     */     //   330: aload #9
/*     */     //   332: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   337: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   342: astore #11
/*     */     //   344: aload #11
/*     */     //   346: invokeinterface hasNext : ()Z
/*     */     //   351: ifeq -> 491
/*     */     //   354: aload #11
/*     */     //   356: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   361: checkcast java/util/Map$Entry
/*     */     //   364: astore #12
/*     */     //   366: aload #12
/*     */     //   368: astore #13
/*     */     //   370: iconst_0
/*     */     //   371: istore #14
/*     */     //   373: aload #13
/*     */     //   375: astore #15
/*     */     //   377: iconst_0
/*     */     //   378: istore #16
/*     */     //   380: aload #15
/*     */     //   382: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   387: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   390: astore #17
/*     */     //   392: aload #17
/*     */     //   394: aload_1
/*     */     //   395: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   398: iconst_1
/*     */     //   399: ixor
/*     */     //   400: ifeq -> 483
/*     */     //   403: aload #17
/*     */     //   405: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   408: aload_1
/*     */     //   409: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   412: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   415: ifeq -> 483
/*     */     //   418: dload #5
/*     */     //   420: aload #17
/*     */     //   422: ldc_w 'generic.attackDamage'
/*     */     //   425: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*     */     //   430: checkcast java/lang/Iterable
/*     */     //   433: invokestatic firstOrNull : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   436: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*     */     //   439: dup
/*     */     //   440: ifnull -> 451
/*     */     //   443: invokeinterface getAmount : ()D
/*     */     //   448: goto -> 453
/*     */     //   451: pop
/*     */     //   452: dconst_0
/*     */     //   453: ldc2_w 1.25
/*     */     //   456: aload #17
/*     */     //   458: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   461: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   464: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   469: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   472: i2d
/*     */     //   473: dmul
/*     */     //   474: dadd
/*     */     //   475: dcmpg
/*     */     //   476: ifge -> 483
/*     */     //   479: iconst_1
/*     */     //   480: goto -> 484
/*     */     //   483: iconst_0
/*     */     //   484: ifeq -> 344
/*     */     //   487: iconst_0
/*     */     //   488: goto -> 1285
/*     */     //   491: iconst_1
/*     */     //   492: goto -> 1285
/*     */     //   495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   498: aload_3
/*     */     //   499: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   504: ifeq -> 686
/*     */     //   507: aload_1
/*     */     //   508: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   511: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   514: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   519: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   522: istore #4
/*     */     //   524: aload_0
/*     */     //   525: iconst_0
/*     */     //   526: iconst_0
/*     */     //   527: iconst_3
/*     */     //   528: aconst_null
/*     */     //   529: invokestatic items$default : (Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;IIILjava/lang/Object;)Ljava/util/Map;
/*     */     //   532: astore #5
/*     */     //   534: iconst_0
/*     */     //   535: istore #6
/*     */     //   537: aload #5
/*     */     //   539: invokeinterface isEmpty : ()Z
/*     */     //   544: ifeq -> 551
/*     */     //   547: iconst_1
/*     */     //   548: goto -> 1285
/*     */     //   551: aload #5
/*     */     //   553: astore #7
/*     */     //   555: iconst_0
/*     */     //   556: istore #8
/*     */     //   558: aload #7
/*     */     //   560: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   565: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   570: astore #9
/*     */     //   572: aload #9
/*     */     //   574: invokeinterface hasNext : ()Z
/*     */     //   579: ifeq -> 682
/*     */     //   582: aload #9
/*     */     //   584: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   589: checkcast java/util/Map$Entry
/*     */     //   592: astore #10
/*     */     //   594: aload #10
/*     */     //   596: astore #11
/*     */     //   598: iconst_0
/*     */     //   599: istore #12
/*     */     //   601: aload #11
/*     */     //   603: astore #13
/*     */     //   605: iconst_0
/*     */     //   606: istore #14
/*     */     //   608: aload #13
/*     */     //   610: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   615: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   618: astore #15
/*     */     //   620: aload_1
/*     */     //   621: aload #15
/*     */     //   623: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   626: iconst_1
/*     */     //   627: ixor
/*     */     //   628: ifeq -> 674
/*     */     //   631: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   634: aload #15
/*     */     //   636: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   641: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   646: ifeq -> 674
/*     */     //   649: iload #4
/*     */     //   651: aload #15
/*     */     //   653: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   656: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   659: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   664: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   667: if_icmpge -> 674
/*     */     //   670: iconst_1
/*     */     //   671: goto -> 675
/*     */     //   674: iconst_0
/*     */     //   675: ifeq -> 572
/*     */     //   678: iconst_0
/*     */     //   679: goto -> 1285
/*     */     //   682: iconst_1
/*     */     //   683: goto -> 1285
/*     */     //   686: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   689: aload_3
/*     */     //   690: invokeinterface isItemArmor : (Ljava/lang/Object;)Z
/*     */     //   695: ifeq -> 919
/*     */     //   698: new net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   701: dup
/*     */     //   702: aload_1
/*     */     //   703: iload_2
/*     */     //   704: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)V
/*     */     //   707: astore #4
/*     */     //   709: aload_0
/*     */     //   710: iconst_0
/*     */     //   711: iconst_0
/*     */     //   712: iconst_3
/*     */     //   713: aconst_null
/*     */     //   714: invokestatic items$default : (Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;IIILjava/lang/Object;)Ljava/util/Map;
/*     */     //   717: astore #5
/*     */     //   719: iconst_0
/*     */     //   720: istore #6
/*     */     //   722: aload #5
/*     */     //   724: invokeinterface isEmpty : ()Z
/*     */     //   729: ifeq -> 736
/*     */     //   732: iconst_1
/*     */     //   733: goto -> 1285
/*     */     //   736: aload #5
/*     */     //   738: astore #7
/*     */     //   740: iconst_0
/*     */     //   741: istore #8
/*     */     //   743: aload #7
/*     */     //   745: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   750: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   755: astore #9
/*     */     //   757: aload #9
/*     */     //   759: invokeinterface hasNext : ()Z
/*     */     //   764: ifeq -> 915
/*     */     //   767: aload #9
/*     */     //   769: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   774: checkcast java/util/Map$Entry
/*     */     //   777: astore #10
/*     */     //   779: aload #10
/*     */     //   781: astore #11
/*     */     //   783: iconst_0
/*     */     //   784: istore #12
/*     */     //   786: aload #11
/*     */     //   788: astore #13
/*     */     //   790: iconst_0
/*     */     //   791: istore #14
/*     */     //   793: aload #13
/*     */     //   795: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   800: checkcast java/lang/Number
/*     */     //   803: invokevirtual intValue : ()I
/*     */     //   806: istore #15
/*     */     //   808: aload #11
/*     */     //   810: astore #13
/*     */     //   812: iconst_0
/*     */     //   813: istore #14
/*     */     //   815: aload #13
/*     */     //   817: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   822: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   825: astore #16
/*     */     //   827: aload #16
/*     */     //   829: aload_1
/*     */     //   830: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   833: iconst_1
/*     */     //   834: ixor
/*     */     //   835: ifeq -> 907
/*     */     //   838: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   841: aload #16
/*     */     //   843: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   848: invokeinterface isItemArmor : (Ljava/lang/Object;)Z
/*     */     //   853: ifeq -> 907
/*     */     //   856: new net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   859: dup
/*     */     //   860: aload #16
/*     */     //   862: iload #15
/*     */     //   864: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)V
/*     */     //   867: astore #13
/*     */     //   869: aload #13
/*     */     //   871: invokevirtual getArmorType : ()I
/*     */     //   874: aload #4
/*     */     //   876: invokevirtual getArmorType : ()I
/*     */     //   879: if_icmpeq -> 886
/*     */     //   882: iconst_0
/*     */     //   883: goto -> 908
/*     */     //   886: getstatic net/ccbluex/liquidbounce/features/module/modules/combat/AutoArmor.ARMOR_COMPARATOR : Lnet/ccbluex/liquidbounce/utils/item/ArmorComparator;
/*     */     //   889: aload #4
/*     */     //   891: aload #13
/*     */     //   893: invokevirtual compare : (Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;)I
/*     */     //   896: ifgt -> 903
/*     */     //   899: iconst_1
/*     */     //   900: goto -> 904
/*     */     //   903: iconst_0
/*     */     //   904: goto -> 908
/*     */     //   907: iconst_0
/*     */     //   908: ifeq -> 757
/*     */     //   911: iconst_0
/*     */     //   912: goto -> 1285
/*     */     //   915: iconst_1
/*     */     //   916: goto -> 1285
/*     */     //   919: aload_1
/*     */     //   920: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   925: ldc_w 'item.compass'
/*     */     //   928: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   931: ifeq -> 1072
/*     */     //   934: aload_0
/*     */     //   935: iconst_0
/*     */     //   936: bipush #45
/*     */     //   938: invokespecial items : (II)Ljava/util/Map;
/*     */     //   941: astore #4
/*     */     //   943: iconst_0
/*     */     //   944: istore #5
/*     */     //   946: aload #4
/*     */     //   948: invokeinterface isEmpty : ()Z
/*     */     //   953: ifeq -> 960
/*     */     //   956: iconst_1
/*     */     //   957: goto -> 1285
/*     */     //   960: aload #4
/*     */     //   962: astore #6
/*     */     //   964: iconst_0
/*     */     //   965: istore #7
/*     */     //   967: aload #6
/*     */     //   969: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   974: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   979: astore #8
/*     */     //   981: aload #8
/*     */     //   983: invokeinterface hasNext : ()Z
/*     */     //   988: ifeq -> 1068
/*     */     //   991: aload #8
/*     */     //   993: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   998: checkcast java/util/Map$Entry
/*     */     //   1001: astore #9
/*     */     //   1003: aload #9
/*     */     //   1005: astore #10
/*     */     //   1007: iconst_0
/*     */     //   1008: istore #11
/*     */     //   1010: aload #10
/*     */     //   1012: astore #12
/*     */     //   1014: iconst_0
/*     */     //   1015: istore #13
/*     */     //   1017: aload #12
/*     */     //   1019: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1024: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1027: astore #14
/*     */     //   1029: aload_1
/*     */     //   1030: aload #14
/*     */     //   1032: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1035: iconst_1
/*     */     //   1036: ixor
/*     */     //   1037: ifeq -> 1060
/*     */     //   1040: aload #14
/*     */     //   1042: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1047: ldc_w 'item.compass'
/*     */     //   1050: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1053: ifeq -> 1060
/*     */     //   1056: iconst_1
/*     */     //   1057: goto -> 1061
/*     */     //   1060: iconst_0
/*     */     //   1061: ifeq -> 981
/*     */     //   1064: iconst_0
/*     */     //   1065: goto -> 1285
/*     */     //   1068: iconst_1
/*     */     //   1069: goto -> 1285
/*     */     //   1072: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1075: aload_3
/*     */     //   1076: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   1081: ifne -> 1280
/*     */     //   1084: aload_1
/*     */     //   1085: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1090: ldc_w 'item.arrow'
/*     */     //   1093: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1096: ifne -> 1280
/*     */     //   1099: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1102: aload_3
/*     */     //   1103: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   1108: ifeq -> 1135
/*     */     //   1111: aload_1
/*     */     //   1112: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1117: checkcast java/lang/CharSequence
/*     */     //   1120: ldc_w 'flower'
/*     */     //   1123: checkcast java/lang/CharSequence
/*     */     //   1126: iconst_0
/*     */     //   1127: iconst_2
/*     */     //   1128: aconst_null
/*     */     //   1129: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   1132: ifeq -> 1280
/*     */     //   1135: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1138: aload_3
/*     */     //   1139: invokeinterface isItemBed : (Ljava/lang/Object;)Z
/*     */     //   1144: ifne -> 1280
/*     */     //   1147: aload_1
/*     */     //   1148: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1153: ldc_w 'item.diamond'
/*     */     //   1156: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1159: ifne -> 1280
/*     */     //   1162: aload_1
/*     */     //   1163: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1168: ldc_w 'item.ingotIron'
/*     */     //   1171: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1174: ifne -> 1280
/*     */     //   1177: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1180: aload_3
/*     */     //   1181: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   1186: ifne -> 1280
/*     */     //   1189: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1192: aload_3
/*     */     //   1193: invokeinterface isItemEnderPearl : (Ljava/lang/Object;)Z
/*     */     //   1198: ifne -> 1280
/*     */     //   1201: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1204: aload_3
/*     */     //   1205: invokeinterface isItemEnchantedBook : (Ljava/lang/Object;)Z
/*     */     //   1210: ifne -> 1280
/*     */     //   1213: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1216: aload_3
/*     */     //   1217: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1222: ifne -> 1280
/*     */     //   1225: aload_1
/*     */     //   1226: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1231: ldc_w 'item.stick'
/*     */     //   1234: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1237: ifne -> 1280
/*     */     //   1240: aload_0
/*     */     //   1241: getfield ignoreVehiclesValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1244: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1247: checkcast java/lang/Boolean
/*     */     //   1250: invokevirtual booleanValue : ()Z
/*     */     //   1253: ifeq -> 1284
/*     */     //   1256: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1259: aload_3
/*     */     //   1260: invokeinterface isItemBoat : (Ljava/lang/Object;)Z
/*     */     //   1265: ifne -> 1280
/*     */     //   1268: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1271: aload_3
/*     */     //   1272: invokeinterface isItemMinecart : (Ljava/lang/Object;)Z
/*     */     //   1277: ifeq -> 1284
/*     */     //   1280: iconst_1
/*     */     //   1281: goto -> 1285
/*     */     //   1284: iconst_0
/*     */     //   1285: istore_3
/*     */     //   1286: goto -> 1336
/*     */     //   1289: astore #4
/*     */     //   1291: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   1294: new java/lang/StringBuilder
/*     */     //   1297: dup
/*     */     //   1298: invokespecial <init> : ()V
/*     */     //   1301: ldc_w '(InventoryCleaner) Failed to check item: '
/*     */     //   1304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1307: aload_1
/*     */     //   1308: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1316: bipush #46
/*     */     //   1318: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   1321: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1324: aload #4
/*     */     //   1326: checkcast java/lang/Throwable
/*     */     //   1329: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   1334: iconst_1
/*     */     //   1335: istore_3
/*     */     //   1336: iload_3
/*     */     //   1337: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #121	-> 7
/*     */     //   #122	-> 8
/*     */     //   #124	-> 15
/*     */     //   #125	-> 39
/*     */     //   #125	-> 54
/*     */     //   #127	-> 59
/*     */     //   #128	-> 111
/*     */     //   #130	-> 113
/*     */     //   #131	-> 127
/*     */     //   #132	-> 127
/*     */     //   #133	-> 127
/*     */     //   #131	-> 127
/*     */     //   #132	-> 155
/*     */     //   #133	-> 183
/*     */     //   #134	-> 211
/*     */     //   #135	-> 234
/*     */     //   #130	-> 236
/*     */     //   #140	-> 242
/*     */     //   #141	-> 273
/*     */     //   #140	-> 295
/*     */     //   #143	-> 297
/*     */     //   #405	-> 309
/*     */     //   #406	-> 323
/*     */     //   #406	-> 366
/*     */     //   #144	-> 392
/*     */     //   #145	-> 392
/*     */     //   #146	-> 452
/*     */     //   #407	-> 491
/*     */     //   #148	-> 495
/*     */     //   #149	-> 507
/*     */     //   #151	-> 524
/*     */     //   #408	-> 537
/*     */     //   #409	-> 551
/*     */     //   #409	-> 594
/*     */     //   #152	-> 620
/*     */     //   #153	-> 620
/*     */     //   #152	-> 631
/*     */     //   #153	-> 651
/*     */     //   #410	-> 682
/*     */     //   #155	-> 686
/*     */     //   #156	-> 698
/*     */     //   #158	-> 709
/*     */     //   #411	-> 722
/*     */     //   #412	-> 736
/*     */     //   #412	-> 779
/*     */     //   #159	-> 827
/*     */     //   #160	-> 856
/*     */     //   #162	-> 869
/*     */     //   #163	-> 882
/*     */     //   #165	-> 886
/*     */     //   #162	-> 904
/*     */     //   #167	-> 907
/*     */     //   #159	-> 908
/*     */     //   #167	-> 908
/*     */     //   #413	-> 915
/*     */     //   #169	-> 919
/*     */     //   #170	-> 934
/*     */     //   #414	-> 946
/*     */     //   #415	-> 960
/*     */     //   #415	-> 1003
/*     */     //   #170	-> 1029
/*     */     //   #416	-> 1068
/*     */     //   #171	-> 1072
/*     */     //   #172	-> 1072
/*     */     //   #173	-> 1072
/*     */     //   #174	-> 1072
/*     */     //   #175	-> 1072
/*     */     //   #171	-> 1072
/*     */     //   #172	-> 1099
/*     */     //   #173	-> 1135
/*     */     //   #174	-> 1177
/*     */     //   #175	-> 1240
/*     */     //   #169	-> 1285
/*     */     //   #155	-> 1285
/*     */     //   #148	-> 1285
/*     */     //   #124	-> 1285
/*     */     //   #176	-> 1289
/*     */     //   #177	-> 1291
/*     */     //   #179	-> 1334
/*     */     //   #121	-> 1336
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   127	112	5	i	I
/*     */     //   370	114	13	$dstr$_u24__u24$stack	Ljava/util/Map$Entry;
/*     */     //   370	114	17	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   373	111	14	$i$a$-none-InventoryCleaner$isUseful$1	I
/*     */     //   366	125	12	element$iv	Ljava/util/Map$Entry;
/*     */     //   306	186	7	$this$none$iv	Ljava/util/Map;
/*     */     //   309	183	8	$i$f$none	I
/*     */     //   297	195	5	damage	D
/*     */     //   59	433	4	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   598	77	11	$dstr$_u24__u24$stack	Ljava/util/Map$Entry;
/*     */     //   598	77	15	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   601	74	12	$i$a$-none-InventoryCleaner$isUseful$2	I
/*     */     //   594	88	10	element$iv	Ljava/util/Map$Entry;
/*     */     //   534	149	5	$this$none$iv	Ljava/util/Map;
/*     */     //   537	146	6	$i$f$none	I
/*     */     //   524	159	4	currPower	I
/*     */     //   869	35	13	armor	Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   783	125	11	$dstr$slot$stack	Ljava/util/Map$Entry;
/*     */     //   783	125	15	slot	I
/*     */     //   783	125	16	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   786	122	12	$i$a$-none-InventoryCleaner$isUseful$3	I
/*     */     //   779	136	10	element$iv	Ljava/util/Map$Entry;
/*     */     //   719	197	5	$this$none$iv	Ljava/util/Map;
/*     */     //   722	194	6	$i$f$none	I
/*     */     //   709	207	4	currArmor	Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   1007	54	10	$dstr$_u24__u24$stack	Ljava/util/Map$Entry;
/*     */     //   1007	54	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1010	51	11	$i$a$-none-InventoryCleaner$isUseful$4	I
/*     */     //   1003	65	9	element$iv	Ljava/util/Map$Entry;
/*     */     //   943	126	4	$this$none$iv	Ljava/util/Map;
/*     */     //   946	123	5	$i$f$none	I
/*     */     //   15	1270	3	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1291	45	4	ex	Ljava/lang/Exception;
/*     */     //   0	1338	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;
/*     */     //   0	1338	1	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   0	1338	2	slot	I
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	1286	1289	java/lang/Exception
/*     */   }
/*     */ 
/*     */   
/*     */   private final void sortHotbar() {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_1
/*     */     //   2: bipush #8
/*     */     //   4: istore_2
/*     */     //   5: iload_1
/*     */     //   6: iload_2
/*     */     //   7: if_icmpgt -> 287
/*     */     //   10: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   13: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   18: dup
/*     */     //   19: ifnull -> 25
/*     */     //   22: goto -> 27
/*     */     //   25: pop
/*     */     //   26: return
/*     */     //   27: astore_3
/*     */     //   28: aload_0
/*     */     //   29: iload_1
/*     */     //   30: aload_3
/*     */     //   31: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   36: iload_1
/*     */     //   37: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   42: invokespecial findBetterItem : (ILnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Ljava/lang/Integer;
/*     */     //   45: dup
/*     */     //   46: ifnull -> 55
/*     */     //   49: invokevirtual intValue : ()I
/*     */     //   52: goto -> 59
/*     */     //   55: pop
/*     */     //   56: goto -> 281
/*     */     //   59: istore #4
/*     */     //   61: iload #4
/*     */     //   63: iload_1
/*     */     //   64: if_icmpeq -> 281
/*     */     //   67: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   70: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   73: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   78: invokeinterface isGuiInventory : (Ljava/lang/Object;)Z
/*     */     //   83: ifne -> 106
/*     */     //   86: aload_0
/*     */     //   87: getfield simulateInventory : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   90: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   93: checkcast java/lang/Boolean
/*     */     //   96: invokevirtual booleanValue : ()Z
/*     */     //   99: ifeq -> 106
/*     */     //   102: iconst_1
/*     */     //   103: goto -> 107
/*     */     //   106: iconst_0
/*     */     //   107: istore #5
/*     */     //   109: iload #5
/*     */     //   111: ifeq -> 182
/*     */     //   114: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   117: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   122: astore #7
/*     */     //   124: iconst_0
/*     */     //   125: istore #6
/*     */     //   127: nop
/*     */     //   128: getstatic net/ccbluex/liquidbounce/injection/backend/WrapperImpl.INSTANCE : Lnet/ccbluex/liquidbounce/injection/backend/WrapperImpl;
/*     */     //   131: invokevirtual getClassProvider : ()Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   134: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   137: invokevirtual getWrapper : ()Lnet/ccbluex/liquidbounce/api/Wrapper;
/*     */     //   140: invokeinterface getMinecraft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   145: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   150: dup
/*     */     //   151: ifnonnull -> 157
/*     */     //   154: invokestatic throwNpe : ()V
/*     */     //   157: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   160: getstatic net/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction.OPEN_INVENTORY : Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;
/*     */     //   163: invokeinterface createCPacketEntityAction : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction$WAction;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketEntityAction;
/*     */     //   168: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   171: astore #8
/*     */     //   173: aload #7
/*     */     //   175: aload #8
/*     */     //   177: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   182: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   185: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   190: iconst_0
/*     */     //   191: iload #4
/*     */     //   193: bipush #9
/*     */     //   195: if_icmpge -> 206
/*     */     //   198: iload #4
/*     */     //   200: bipush #36
/*     */     //   202: iadd
/*     */     //   203: goto -> 208
/*     */     //   206: iload #4
/*     */     //   208: iload_1
/*     */     //   209: iconst_2
/*     */     //   210: aload_3
/*     */     //   211: invokeinterface windowClick : (IIIILnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   216: iload #5
/*     */     //   218: ifeq -> 245
/*     */     //   221: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   224: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   229: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   232: invokeinterface createCPacketCloseWindow : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCloseWindow;
/*     */     //   237: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   240: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   245: aload_0
/*     */     //   246: aload_0
/*     */     //   247: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   250: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   253: checkcast java/lang/Number
/*     */     //   256: invokevirtual intValue : ()I
/*     */     //   259: aload_0
/*     */     //   260: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   263: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   266: checkcast java/lang/Number
/*     */     //   269: invokevirtual intValue : ()I
/*     */     //   272: invokestatic randomDelay : (II)J
/*     */     //   275: putfield delay : J
/*     */     //   278: goto -> 287
/*     */     //   281: iinc #1, 1
/*     */     //   284: goto -> 5
/*     */     //   287: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #191	-> 0
/*     */     //   #192	-> 10
/*     */     //   #192	-> 25
/*     */     //   #194	-> 28
/*     */     //   #194	-> 55
/*     */     //   #196	-> 61
/*     */     //   #197	-> 67
/*     */     //   #199	-> 109
/*     */     //   #200	-> 114
/*     */     //   #417	-> 127
/*     */     //   #418	-> 127
/*     */     //   #421	-> 128
/*     */     //   #418	-> 171
/*     */     //   #200	-> 177
/*     */     //   #202	-> 182
/*     */     //   #203	-> 209
/*     */     //   #202	-> 211
/*     */     //   #205	-> 216
/*     */     //   #206	-> 221
/*     */     //   #208	-> 245
/*     */     //   #209	-> 278
/*     */     //   #191	-> 281
/*     */     //   #212	-> 287
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   127	44	6	$i$f$createOpenInventoryPacket	I
/*     */     //   109	172	5	openInventory	Z
/*     */     //   61	220	4	bestItem	I
/*     */     //   28	253	3	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   10	274	1	index	I
/*     */     //   0	288	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;
/*     */   }
/*     */ 
/*     */   
/*     */   private final Integer findBetterItem(int targetSlot, IItemStack slotStack) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: iload_1
/*     */     //   2: invokespecial type : (I)Ljava/lang/String;
/*     */     //   5: astore_3
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 24
/*     */     //   21: pop
/*     */     //   22: aconst_null
/*     */     //   23: areturn
/*     */     //   24: astore #4
/*     */     //   26: aload_3
/*     */     //   27: astore #5
/*     */     //   29: iconst_0
/*     */     //   30: istore #6
/*     */     //   32: aload #5
/*     */     //   34: dup
/*     */     //   35: ifnonnull -> 49
/*     */     //   38: new kotlin/TypeCastException
/*     */     //   41: dup
/*     */     //   42: ldc_w 'null cannot be cast to non-null type java.lang.String'
/*     */     //   45: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   48: athrow
/*     */     //   49: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   52: dup
/*     */     //   53: ldc_w '(this as java.lang.String).toLowerCase()'
/*     */     //   56: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   59: astore #5
/*     */     //   61: aload #5
/*     */     //   63: invokevirtual hashCode : ()I
/*     */     //   66: lookupswitch default -> 2011, -1253135533 -> 218, -578028723 -> 162, 97038 -> 246, 97738 -> 190, 3148894 -> 232, 93832333 -> 176, 106540102 -> 260, 109860349 -> 148, 112903447 -> 204
/*     */     //   148: aload #5
/*     */     //   150: ldc_w 'sword'
/*     */     //   153: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   156: ifeq -> 2011
/*     */     //   159: goto -> 274
/*     */     //   162: aload #5
/*     */     //   164: ldc_w 'pickaxe'
/*     */     //   167: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   170: ifeq -> 2011
/*     */     //   173: goto -> 274
/*     */     //   176: aload #5
/*     */     //   178: ldc_w 'block'
/*     */     //   181: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   184: ifeq -> 2011
/*     */     //   187: goto -> 1163
/*     */     //   190: aload #5
/*     */     //   192: ldc_w 'bow'
/*     */     //   195: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   198: ifeq -> 2011
/*     */     //   201: goto -> 700
/*     */     //   204: aload #5
/*     */     //   206: ldc_w 'water'
/*     */     //   209: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   212: ifeq -> 2011
/*     */     //   215: goto -> 1373
/*     */     //   218: aload #5
/*     */     //   220: ldc_w 'gapple'
/*     */     //   223: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   226: ifeq -> 2011
/*     */     //   229: goto -> 1620
/*     */     //   232: aload #5
/*     */     //   234: ldc_w 'food'
/*     */     //   237: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   240: ifeq -> 2011
/*     */     //   243: goto -> 970
/*     */     //   246: aload #5
/*     */     //   248: ldc_w 'axe'
/*     */     //   251: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   254: ifeq -> 2011
/*     */     //   257: goto -> 274
/*     */     //   260: aload #5
/*     */     //   262: ldc_w 'pearl'
/*     */     //   265: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   268: ifeq -> 2011
/*     */     //   271: goto -> 1820
/*     */     //   274: nop
/*     */     //   275: aload_3
/*     */     //   276: ldc_w 'Sword'
/*     */     //   279: iconst_1
/*     */     //   280: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   283: ifeq -> 295
/*     */     //   286: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$findBetterItem$currentTypeChecker$1.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$findBetterItem$currentTypeChecker$1;
/*     */     //   289: checkcast kotlin/jvm/functions/Function1
/*     */     //   292: goto -> 337
/*     */     //   295: aload_3
/*     */     //   296: ldc_w 'Pickaxe'
/*     */     //   299: iconst_1
/*     */     //   300: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   303: ifeq -> 315
/*     */     //   306: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$findBetterItem$currentTypeChecker$2.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$findBetterItem$currentTypeChecker$2;
/*     */     //   309: checkcast kotlin/jvm/functions/Function1
/*     */     //   312: goto -> 337
/*     */     //   315: aload_3
/*     */     //   316: ldc_w 'Axe'
/*     */     //   319: iconst_1
/*     */     //   320: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   323: ifeq -> 335
/*     */     //   326: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$findBetterItem$currentTypeChecker$3.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner$findBetterItem$currentTypeChecker$3;
/*     */     //   329: checkcast kotlin/jvm/functions/Function1
/*     */     //   332: goto -> 337
/*     */     //   335: aconst_null
/*     */     //   336: areturn
/*     */     //   337: astore #6
/*     */     //   339: aload #6
/*     */     //   341: aload_2
/*     */     //   342: dup
/*     */     //   343: ifnull -> 354
/*     */     //   346: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   351: goto -> 356
/*     */     //   354: pop
/*     */     //   355: aconst_null
/*     */     //   356: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   361: checkcast java/lang/Boolean
/*     */     //   364: invokevirtual booleanValue : ()Z
/*     */     //   367: ifeq -> 374
/*     */     //   370: iload_1
/*     */     //   371: goto -> 375
/*     */     //   374: iconst_m1
/*     */     //   375: istore #7
/*     */     //   377: aload #4
/*     */     //   379: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   384: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   389: checkcast java/lang/Iterable
/*     */     //   392: astore #8
/*     */     //   394: iconst_0
/*     */     //   395: istore #9
/*     */     //   397: iconst_0
/*     */     //   398: istore #10
/*     */     //   400: aload #8
/*     */     //   402: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   407: astore #11
/*     */     //   409: aload #11
/*     */     //   411: invokeinterface hasNext : ()Z
/*     */     //   416: ifeq -> 677
/*     */     //   419: aload #11
/*     */     //   421: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   426: astore #12
/*     */     //   428: iload #10
/*     */     //   430: iinc #10, 1
/*     */     //   433: istore #13
/*     */     //   435: iconst_0
/*     */     //   436: istore #14
/*     */     //   438: iload #13
/*     */     //   440: ifge -> 446
/*     */     //   443: invokestatic throwIndexOverflow : ()V
/*     */     //   446: iload #13
/*     */     //   448: istore #15
/*     */     //   450: iload #15
/*     */     //   452: aload #12
/*     */     //   454: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   457: astore #16
/*     */     //   459: istore #17
/*     */     //   461: iconst_0
/*     */     //   462: istore #18
/*     */     //   464: aload #16
/*     */     //   466: ifnull -> 672
/*     */     //   469: aload #6
/*     */     //   471: aload #16
/*     */     //   473: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   478: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   483: checkcast java/lang/Boolean
/*     */     //   486: invokevirtual booleanValue : ()Z
/*     */     //   489: ifeq -> 672
/*     */     //   492: aload_0
/*     */     //   493: iload #17
/*     */     //   495: invokespecial type : (I)Ljava/lang/String;
/*     */     //   498: aload_3
/*     */     //   499: iconst_1
/*     */     //   500: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   503: ifne -> 672
/*     */     //   506: iload #7
/*     */     //   508: iconst_m1
/*     */     //   509: if_icmpne -> 519
/*     */     //   512: iload #17
/*     */     //   514: istore #7
/*     */     //   516: goto -> 672
/*     */     //   519: aload #16
/*     */     //   521: ldc_w 'generic.attackDamage'
/*     */     //   524: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*     */     //   529: checkcast java/lang/Iterable
/*     */     //   532: invokestatic firstOrNull : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   535: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*     */     //   538: dup
/*     */     //   539: ifnull -> 550
/*     */     //   542: invokeinterface getAmount : ()D
/*     */     //   547: goto -> 552
/*     */     //   550: pop
/*     */     //   551: dconst_0
/*     */     //   552: ldc2_w 1.25
/*     */     //   555: aload #16
/*     */     //   557: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   560: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   563: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   568: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   571: i2d
/*     */     //   572: dmul
/*     */     //   573: dadd
/*     */     //   574: dstore #19
/*     */     //   576: aload #4
/*     */     //   578: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   583: iload #7
/*     */     //   585: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   590: dup
/*     */     //   591: ifnull -> 597
/*     */     //   594: goto -> 601
/*     */     //   597: pop
/*     */     //   598: goto -> 673
/*     */     //   601: astore #21
/*     */     //   603: aload #21
/*     */     //   605: ldc_w 'generic.attackDamage'
/*     */     //   608: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*     */     //   613: checkcast java/lang/Iterable
/*     */     //   616: invokestatic firstOrNull : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   619: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*     */     //   622: dup
/*     */     //   623: ifnull -> 634
/*     */     //   626: invokeinterface getAmount : ()D
/*     */     //   631: goto -> 636
/*     */     //   634: pop
/*     */     //   635: dconst_0
/*     */     //   636: ldc2_w 1.25
/*     */     //   639: aload #21
/*     */     //   641: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   644: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   647: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   652: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   655: i2d
/*     */     //   656: dmul
/*     */     //   657: dadd
/*     */     //   658: dstore #22
/*     */     //   660: dload #22
/*     */     //   662: dload #19
/*     */     //   664: dcmpg
/*     */     //   665: ifge -> 672
/*     */     //   668: iload #17
/*     */     //   670: istore #7
/*     */     //   672: nop
/*     */     //   673: nop
/*     */     //   674: goto -> 409
/*     */     //   677: nop
/*     */     //   678: iload #7
/*     */     //   680: iconst_m1
/*     */     //   681: if_icmpne -> 690
/*     */     //   684: iload #7
/*     */     //   686: iload_1
/*     */     //   687: if_icmpne -> 698
/*     */     //   690: iload #7
/*     */     //   692: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   695: goto -> 699
/*     */     //   698: aconst_null
/*     */     //   699: areturn
/*     */     //   700: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   703: aload_2
/*     */     //   704: dup
/*     */     //   705: ifnull -> 716
/*     */     //   708: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   713: goto -> 718
/*     */     //   716: pop
/*     */     //   717: aconst_null
/*     */     //   718: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   723: ifeq -> 730
/*     */     //   726: iload_1
/*     */     //   727: goto -> 731
/*     */     //   730: iconst_m1
/*     */     //   731: istore #6
/*     */     //   733: iload #6
/*     */     //   735: iconst_m1
/*     */     //   736: if_icmpeq -> 757
/*     */     //   739: aload_2
/*     */     //   740: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   743: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   746: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   751: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   754: goto -> 758
/*     */     //   757: iconst_0
/*     */     //   758: istore #7
/*     */     //   760: aload #4
/*     */     //   762: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   767: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   772: checkcast java/lang/Iterable
/*     */     //   775: astore #8
/*     */     //   777: iconst_0
/*     */     //   778: istore #9
/*     */     //   780: iconst_0
/*     */     //   781: istore #10
/*     */     //   783: aload #8
/*     */     //   785: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   790: astore #11
/*     */     //   792: aload #11
/*     */     //   794: invokeinterface hasNext : ()Z
/*     */     //   799: ifeq -> 953
/*     */     //   802: aload #11
/*     */     //   804: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   809: astore #12
/*     */     //   811: iload #10
/*     */     //   813: iinc #10, 1
/*     */     //   816: istore #13
/*     */     //   818: iconst_0
/*     */     //   819: istore #14
/*     */     //   821: iload #13
/*     */     //   823: ifge -> 829
/*     */     //   826: invokestatic throwIndexOverflow : ()V
/*     */     //   829: iload #13
/*     */     //   831: istore #15
/*     */     //   833: iload #15
/*     */     //   835: aload #12
/*     */     //   837: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   840: astore #16
/*     */     //   842: istore #17
/*     */     //   844: iconst_0
/*     */     //   845: istore #18
/*     */     //   847: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   850: aload #16
/*     */     //   852: dup
/*     */     //   853: ifnull -> 864
/*     */     //   856: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   861: goto -> 866
/*     */     //   864: pop
/*     */     //   865: aconst_null
/*     */     //   866: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   871: ifeq -> 948
/*     */     //   874: aload_0
/*     */     //   875: iload #17
/*     */     //   877: invokespecial type : (I)Ljava/lang/String;
/*     */     //   880: aload_3
/*     */     //   881: iconst_1
/*     */     //   882: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   885: ifne -> 948
/*     */     //   888: iload #6
/*     */     //   890: iconst_m1
/*     */     //   891: if_icmpne -> 901
/*     */     //   894: iload #17
/*     */     //   896: istore #6
/*     */     //   898: goto -> 948
/*     */     //   901: aload #16
/*     */     //   903: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   906: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   909: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   914: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   917: istore #19
/*     */     //   919: aload #16
/*     */     //   921: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   924: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   927: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   932: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   935: iload #7
/*     */     //   937: if_icmple -> 948
/*     */     //   940: iload #17
/*     */     //   942: istore #6
/*     */     //   944: iload #19
/*     */     //   946: istore #7
/*     */     //   948: nop
/*     */     //   949: nop
/*     */     //   950: goto -> 792
/*     */     //   953: nop
/*     */     //   954: iload #6
/*     */     //   956: iconst_m1
/*     */     //   957: if_icmpeq -> 968
/*     */     //   960: iload #6
/*     */     //   962: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   965: goto -> 969
/*     */     //   968: aconst_null
/*     */     //   969: areturn
/*     */     //   970: aload #4
/*     */     //   972: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   977: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   982: checkcast java/lang/Iterable
/*     */     //   985: astore #6
/*     */     //   987: iconst_0
/*     */     //   988: istore #7
/*     */     //   990: iconst_0
/*     */     //   991: istore #8
/*     */     //   993: aload #6
/*     */     //   995: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1000: astore #9
/*     */     //   1002: aload #9
/*     */     //   1004: invokeinterface hasNext : ()Z
/*     */     //   1009: ifeq -> 1160
/*     */     //   1012: aload #9
/*     */     //   1014: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1019: astore #10
/*     */     //   1021: iload #8
/*     */     //   1023: iinc #8, 1
/*     */     //   1026: istore #11
/*     */     //   1028: iconst_0
/*     */     //   1029: istore #12
/*     */     //   1031: iload #11
/*     */     //   1033: ifge -> 1039
/*     */     //   1036: invokestatic throwIndexOverflow : ()V
/*     */     //   1039: iload #11
/*     */     //   1041: istore #13
/*     */     //   1043: iload #13
/*     */     //   1045: aload #10
/*     */     //   1047: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1050: astore #14
/*     */     //   1052: istore #15
/*     */     //   1054: iconst_0
/*     */     //   1055: istore #16
/*     */     //   1057: aload #14
/*     */     //   1059: ifnull -> 1155
/*     */     //   1062: aload #14
/*     */     //   1064: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1069: astore #17
/*     */     //   1071: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1074: aload #17
/*     */     //   1076: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   1081: ifeq -> 1155
/*     */     //   1084: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1087: aload #17
/*     */     //   1089: invokeinterface isItemAppleGold : (Ljava/lang/Object;)Z
/*     */     //   1094: ifne -> 1155
/*     */     //   1097: aload_0
/*     */     //   1098: iload #15
/*     */     //   1100: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1103: ldc_w 'Food'
/*     */     //   1106: iconst_1
/*     */     //   1107: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1110: ifne -> 1155
/*     */     //   1113: aload_2
/*     */     //   1114: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1117: ifne -> 1133
/*     */     //   1120: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1123: aload #17
/*     */     //   1125: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   1130: ifne -> 1137
/*     */     //   1133: iconst_1
/*     */     //   1134: goto -> 1138
/*     */     //   1137: iconst_0
/*     */     //   1138: istore #18
/*     */     //   1140: iload #18
/*     */     //   1142: ifeq -> 1153
/*     */     //   1145: iload #15
/*     */     //   1147: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1150: goto -> 1154
/*     */     //   1153: aconst_null
/*     */     //   1154: areturn
/*     */     //   1155: nop
/*     */     //   1156: nop
/*     */     //   1157: goto -> 1002
/*     */     //   1160: goto -> 2011
/*     */     //   1163: aload #4
/*     */     //   1165: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1170: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1175: checkcast java/lang/Iterable
/*     */     //   1178: astore #6
/*     */     //   1180: iconst_0
/*     */     //   1181: istore #7
/*     */     //   1183: iconst_0
/*     */     //   1184: istore #8
/*     */     //   1186: aload #6
/*     */     //   1188: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1193: astore #9
/*     */     //   1195: aload #9
/*     */     //   1197: invokeinterface hasNext : ()Z
/*     */     //   1202: ifeq -> 1370
/*     */     //   1205: aload #9
/*     */     //   1207: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1212: astore #10
/*     */     //   1214: iload #8
/*     */     //   1216: iinc #8, 1
/*     */     //   1219: istore #11
/*     */     //   1221: iconst_0
/*     */     //   1222: istore #12
/*     */     //   1224: iload #11
/*     */     //   1226: ifge -> 1232
/*     */     //   1229: invokestatic throwIndexOverflow : ()V
/*     */     //   1232: iload #11
/*     */     //   1234: istore #13
/*     */     //   1236: iload #13
/*     */     //   1238: aload #10
/*     */     //   1240: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1243: astore #14
/*     */     //   1245: istore #15
/*     */     //   1247: iconst_0
/*     */     //   1248: istore #16
/*     */     //   1250: aload #14
/*     */     //   1252: ifnull -> 1365
/*     */     //   1255: aload #14
/*     */     //   1257: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1262: dup
/*     */     //   1263: ifnonnull -> 1269
/*     */     //   1266: invokestatic throwNpe : ()V
/*     */     //   1269: astore #17
/*     */     //   1271: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1274: aload #17
/*     */     //   1276: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   1281: ifeq -> 1365
/*     */     //   1284: getstatic net/ccbluex/liquidbounce/utils/InventoryUtils.BLOCK_BLACKLIST : Ljava/util/List;
/*     */     //   1287: aload #17
/*     */     //   1289: invokeinterface asItemBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;
/*     */     //   1294: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1299: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   1304: ifne -> 1365
/*     */     //   1307: aload_0
/*     */     //   1308: iload #15
/*     */     //   1310: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1313: ldc_w 'Block'
/*     */     //   1316: iconst_1
/*     */     //   1317: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1320: ifne -> 1365
/*     */     //   1323: aload_2
/*     */     //   1324: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1327: ifne -> 1343
/*     */     //   1330: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1333: aload #17
/*     */     //   1335: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   1340: ifne -> 1347
/*     */     //   1343: iconst_1
/*     */     //   1344: goto -> 1348
/*     */     //   1347: iconst_0
/*     */     //   1348: istore #18
/*     */     //   1350: iload #18
/*     */     //   1352: ifeq -> 1363
/*     */     //   1355: iload #15
/*     */     //   1357: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1360: goto -> 1364
/*     */     //   1363: aconst_null
/*     */     //   1364: areturn
/*     */     //   1365: nop
/*     */     //   1366: nop
/*     */     //   1367: goto -> 1195
/*     */     //   1370: goto -> 2011
/*     */     //   1373: aload #4
/*     */     //   1375: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1380: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1385: checkcast java/lang/Iterable
/*     */     //   1388: astore #6
/*     */     //   1390: iconst_0
/*     */     //   1391: istore #7
/*     */     //   1393: iconst_0
/*     */     //   1394: istore #8
/*     */     //   1396: aload #6
/*     */     //   1398: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1403: astore #9
/*     */     //   1405: aload #9
/*     */     //   1407: invokeinterface hasNext : ()Z
/*     */     //   1412: ifeq -> 1617
/*     */     //   1415: aload #9
/*     */     //   1417: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1422: astore #10
/*     */     //   1424: iload #8
/*     */     //   1426: iinc #8, 1
/*     */     //   1429: istore #11
/*     */     //   1431: iconst_0
/*     */     //   1432: istore #12
/*     */     //   1434: iload #11
/*     */     //   1436: ifge -> 1442
/*     */     //   1439: invokestatic throwIndexOverflow : ()V
/*     */     //   1442: iload #11
/*     */     //   1444: istore #13
/*     */     //   1446: iload #13
/*     */     //   1448: aload #10
/*     */     //   1450: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1453: astore #14
/*     */     //   1455: istore #15
/*     */     //   1457: iconst_0
/*     */     //   1458: istore #16
/*     */     //   1460: aload #14
/*     */     //   1462: ifnull -> 1612
/*     */     //   1465: aload #14
/*     */     //   1467: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1472: dup
/*     */     //   1473: ifnonnull -> 1479
/*     */     //   1476: invokestatic throwNpe : ()V
/*     */     //   1479: astore #17
/*     */     //   1481: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1484: aload #17
/*     */     //   1486: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1491: ifeq -> 1612
/*     */     //   1494: aload #17
/*     */     //   1496: invokeinterface asItemBucket : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;
/*     */     //   1501: invokeinterface isFull : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1506: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1509: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.FLOWING_WATER : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   1512: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1517: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1520: ifeq -> 1612
/*     */     //   1523: aload_0
/*     */     //   1524: iload #15
/*     */     //   1526: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1529: ldc_w 'Water'
/*     */     //   1532: iconst_1
/*     */     //   1533: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1536: ifne -> 1612
/*     */     //   1539: aload_2
/*     */     //   1540: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1543: ifne -> 1590
/*     */     //   1546: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1549: aload #17
/*     */     //   1551: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1556: ifeq -> 1590
/*     */     //   1559: aload #17
/*     */     //   1561: invokeinterface asItemBucket : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;
/*     */     //   1566: invokeinterface isFull : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1571: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1574: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.FLOWING_WATER : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   1577: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1582: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1585: iconst_1
/*     */     //   1586: ixor
/*     */     //   1587: ifeq -> 1594
/*     */     //   1590: iconst_1
/*     */     //   1591: goto -> 1595
/*     */     //   1594: iconst_0
/*     */     //   1595: istore #18
/*     */     //   1597: iload #18
/*     */     //   1599: ifeq -> 1610
/*     */     //   1602: iload #15
/*     */     //   1604: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1607: goto -> 1611
/*     */     //   1610: aconst_null
/*     */     //   1611: areturn
/*     */     //   1612: nop
/*     */     //   1613: nop
/*     */     //   1614: goto -> 1405
/*     */     //   1617: goto -> 2011
/*     */     //   1620: aload #4
/*     */     //   1622: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1627: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1632: checkcast java/lang/Iterable
/*     */     //   1635: astore #6
/*     */     //   1637: iconst_0
/*     */     //   1638: istore #7
/*     */     //   1640: iconst_0
/*     */     //   1641: istore #8
/*     */     //   1643: aload #6
/*     */     //   1645: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1650: astore #9
/*     */     //   1652: aload #9
/*     */     //   1654: invokeinterface hasNext : ()Z
/*     */     //   1659: ifeq -> 1817
/*     */     //   1662: aload #9
/*     */     //   1664: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1669: astore #10
/*     */     //   1671: iload #8
/*     */     //   1673: iinc #8, 1
/*     */     //   1676: istore #11
/*     */     //   1678: iconst_0
/*     */     //   1679: istore #12
/*     */     //   1681: iload #11
/*     */     //   1683: ifge -> 1689
/*     */     //   1686: invokestatic throwIndexOverflow : ()V
/*     */     //   1689: iload #11
/*     */     //   1691: istore #13
/*     */     //   1693: iload #13
/*     */     //   1695: aload #10
/*     */     //   1697: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1700: astore #14
/*     */     //   1702: istore #15
/*     */     //   1704: iconst_0
/*     */     //   1705: istore #16
/*     */     //   1707: aload #14
/*     */     //   1709: ifnull -> 1812
/*     */     //   1712: aload #14
/*     */     //   1714: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1719: dup
/*     */     //   1720: ifnonnull -> 1726
/*     */     //   1723: invokestatic throwNpe : ()V
/*     */     //   1726: astore #17
/*     */     //   1728: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1731: aload #17
/*     */     //   1733: invokeinterface isItemAppleGold : (Ljava/lang/Object;)Z
/*     */     //   1738: ifeq -> 1812
/*     */     //   1741: aload_0
/*     */     //   1742: iload #15
/*     */     //   1744: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1747: ldc_w 'Gapple'
/*     */     //   1750: iconst_1
/*     */     //   1751: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1754: ifne -> 1812
/*     */     //   1757: aload_2
/*     */     //   1758: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1761: ifne -> 1790
/*     */     //   1764: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1767: aload_2
/*     */     //   1768: dup
/*     */     //   1769: ifnull -> 1780
/*     */     //   1772: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1777: goto -> 1782
/*     */     //   1780: pop
/*     */     //   1781: aconst_null
/*     */     //   1782: invokeinterface isItemAppleGold : (Ljava/lang/Object;)Z
/*     */     //   1787: ifne -> 1794
/*     */     //   1790: iconst_1
/*     */     //   1791: goto -> 1795
/*     */     //   1794: iconst_0
/*     */     //   1795: istore #18
/*     */     //   1797: iload #18
/*     */     //   1799: ifeq -> 1810
/*     */     //   1802: iload #15
/*     */     //   1804: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1807: goto -> 1811
/*     */     //   1810: aconst_null
/*     */     //   1811: areturn
/*     */     //   1812: nop
/*     */     //   1813: nop
/*     */     //   1814: goto -> 1652
/*     */     //   1817: goto -> 2011
/*     */     //   1820: aload #4
/*     */     //   1822: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1827: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1832: checkcast java/lang/Iterable
/*     */     //   1835: astore #6
/*     */     //   1837: iconst_0
/*     */     //   1838: istore #7
/*     */     //   1840: iconst_0
/*     */     //   1841: istore #8
/*     */     //   1843: aload #6
/*     */     //   1845: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1850: astore #9
/*     */     //   1852: aload #9
/*     */     //   1854: invokeinterface hasNext : ()Z
/*     */     //   1859: ifeq -> 2010
/*     */     //   1862: aload #9
/*     */     //   1864: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1869: astore #10
/*     */     //   1871: iload #8
/*     */     //   1873: iinc #8, 1
/*     */     //   1876: istore #11
/*     */     //   1878: iconst_0
/*     */     //   1879: istore #12
/*     */     //   1881: iload #11
/*     */     //   1883: ifge -> 1889
/*     */     //   1886: invokestatic throwIndexOverflow : ()V
/*     */     //   1889: iload #11
/*     */     //   1891: istore #13
/*     */     //   1893: iload #13
/*     */     //   1895: aload #10
/*     */     //   1897: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1900: astore #14
/*     */     //   1902: istore #15
/*     */     //   1904: iconst_0
/*     */     //   1905: istore #16
/*     */     //   1907: aload #14
/*     */     //   1909: ifnull -> 2005
/*     */     //   1912: aload #14
/*     */     //   1914: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1919: astore #17
/*     */     //   1921: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1924: aload #17
/*     */     //   1926: invokeinterface isItemEnderPearl : (Ljava/lang/Object;)Z
/*     */     //   1931: ifeq -> 2005
/*     */     //   1934: aload_0
/*     */     //   1935: iload #15
/*     */     //   1937: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1940: ldc_w 'Pearl'
/*     */     //   1943: iconst_1
/*     */     //   1944: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1947: ifne -> 2005
/*     */     //   1950: aload_2
/*     */     //   1951: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1954: ifne -> 1983
/*     */     //   1957: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1960: aload_2
/*     */     //   1961: dup
/*     */     //   1962: ifnull -> 1973
/*     */     //   1965: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1970: goto -> 1975
/*     */     //   1973: pop
/*     */     //   1974: aconst_null
/*     */     //   1975: invokeinterface isItemEnderPearl : (Ljava/lang/Object;)Z
/*     */     //   1980: ifne -> 1987
/*     */     //   1983: iconst_1
/*     */     //   1984: goto -> 1988
/*     */     //   1987: iconst_0
/*     */     //   1988: istore #18
/*     */     //   1990: iload #18
/*     */     //   1992: ifeq -> 2003
/*     */     //   1995: iload #15
/*     */     //   1997: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   2000: goto -> 2004
/*     */     //   2003: aconst_null
/*     */     //   2004: areturn
/*     */     //   2005: nop
/*     */     //   2006: nop
/*     */     //   2007: goto -> 1852
/*     */     //   2010: nop
/*     */     //   2011: aconst_null
/*     */     //   2012: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #215	-> 0
/*     */     //   #217	-> 6
/*     */     //   #217	-> 21
/*     */     //   #219	-> 26
/*     */     //   #220	-> 148
/*     */     //   #293	-> 176
/*     */     //   #254	-> 190
/*     */     //   #308	-> 204
/*     */     //   #322	-> 218
/*     */     //   #279	-> 232
/*     */     //   #220	-> 246
/*     */     //   #336	-> 260
/*     */     //   #221	-> 274
/*     */     //   #222	-> 275
/*     */     //   #223	-> 295
/*     */     //   #224	-> 315
/*     */     //   #225	-> 335
/*     */     //   #221	-> 337
/*     */     //   #228	-> 339
/*     */     //   #229	-> 370
/*     */     //   #230	-> 374
/*     */     //   #228	-> 375
/*     */     //   #232	-> 377
/*     */     //   #422	-> 397
/*     */     //   #423	-> 400
/*     */     //   #423	-> 452
/*     */     //   #233	-> 464
/*     */     //   #234	-> 506
/*     */     //   #235	-> 512
/*     */     //   #237	-> 519
/*     */     //   #238	-> 551
/*     */     //   #237	-> 574
/*     */     //   #240	-> 576
/*     */     //   #241	-> 598
/*     */     //   #240	-> 601
/*     */     //   #242	-> 603
/*     */     //   #243	-> 635
/*     */     //   #242	-> 658
/*     */     //   #245	-> 660
/*     */     //   #246	-> 668
/*     */     //   #247	-> 672
/*     */     //   #249	-> 672
/*     */     //   #424	-> 677
/*     */     //   #251	-> 678
/*     */     //   #255	-> 700
/*     */     //   #256	-> 733
/*     */     //   #257	-> 739
/*     */     //   #259	-> 757
/*     */     //   #256	-> 758
/*     */     //   #261	-> 760
/*     */     //   #425	-> 780
/*     */     //   #426	-> 783
/*     */     //   #426	-> 835
/*     */     //   #262	-> 847
/*     */     //   #263	-> 888
/*     */     //   #264	-> 894
/*     */     //   #266	-> 901
/*     */     //   #268	-> 919
/*     */     //   #269	-> 940
/*     */     //   #270	-> 944
/*     */     //   #272	-> 948
/*     */     //   #274	-> 948
/*     */     //   #427	-> 953
/*     */     //   #276	-> 954
/*     */     //   #280	-> 970
/*     */     //   #428	-> 990
/*     */     //   #429	-> 993
/*     */     //   #429	-> 1045
/*     */     //   #281	-> 1057
/*     */     //   #282	-> 1062
/*     */     //   #284	-> 1071
/*     */     //   #285	-> 1113
/*     */     //   #287	-> 1140
/*     */     //   #290	-> 1155
/*     */     //   #430	-> 1160
/*     */     //   #294	-> 1163
/*     */     //   #431	-> 1183
/*     */     //   #432	-> 1186
/*     */     //   #432	-> 1238
/*     */     //   #295	-> 1250
/*     */     //   #296	-> 1255
/*     */     //   #298	-> 1271
/*     */     //   #299	-> 1271
/*     */     //   #298	-> 1271
/*     */     //   #299	-> 1307
/*     */     //   #300	-> 1323
/*     */     //   #302	-> 1350
/*     */     //   #305	-> 1365
/*     */     //   #433	-> 1370
/*     */     //   #309	-> 1373
/*     */     //   #434	-> 1393
/*     */     //   #435	-> 1396
/*     */     //   #435	-> 1448
/*     */     //   #310	-> 1460
/*     */     //   #311	-> 1465
/*     */     //   #313	-> 1481
/*     */     //   #314	-> 1539
/*     */     //   #316	-> 1597
/*     */     //   #319	-> 1612
/*     */     //   #436	-> 1617
/*     */     //   #323	-> 1620
/*     */     //   #437	-> 1640
/*     */     //   #438	-> 1643
/*     */     //   #438	-> 1695
/*     */     //   #324	-> 1707
/*     */     //   #325	-> 1712
/*     */     //   #327	-> 1728
/*     */     //   #328	-> 1757
/*     */     //   #330	-> 1797
/*     */     //   #333	-> 1812
/*     */     //   #439	-> 1817
/*     */     //   #337	-> 1820
/*     */     //   #440	-> 1840
/*     */     //   #441	-> 1843
/*     */     //   #441	-> 1895
/*     */     //   #338	-> 1907
/*     */     //   #339	-> 1912
/*     */     //   #341	-> 1921
/*     */     //   #342	-> 1950
/*     */     //   #344	-> 1990
/*     */     //   #347	-> 2005
/*     */     //   #442	-> 2010
/*     */     //   #349	-> 2011
/*     */     //   #351	-> 2011
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   660	12	22	bestDamage	D
/*     */     //   603	69	21	bestStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   576	96	19	currDamage	D
/*     */     //   461	212	17	index	I
/*     */     //   461	212	16	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   464	209	18	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$1	I
/*     */     //   428	246	12	item$iv	Ljava/lang/Object;
/*     */     //   400	278	10	index$iv	I
/*     */     //   394	284	8	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   397	281	9	$i$f$forEachIndexed	I
/*     */     //   377	323	7	bestWeapon	I
/*     */     //   339	361	6	currentTypeChecker	Lkotlin/jvm/functions/Function1;
/*     */     //   919	29	19	power	I
/*     */     //   844	105	17	index	I
/*     */     //   844	105	16	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   847	102	18	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$2	I
/*     */     //   811	139	12	item$iv	Ljava/lang/Object;
/*     */     //   783	171	10	index$iv	I
/*     */     //   777	177	8	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   780	174	9	$i$f$forEachIndexed	I
/*     */     //   760	210	7	bestPower	I
/*     */     //   733	237	6	bestBow	I
/*     */     //   1140	15	18	replaceCurr	Z
/*     */     //   1071	84	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1054	102	15	index	I
/*     */     //   1054	102	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1057	99	16	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$3	I
/*     */     //   1021	136	10	item$iv	Ljava/lang/Object;
/*     */     //   993	167	8	index$iv	I
/*     */     //   987	173	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   990	170	7	$i$f$forEachIndexed	I
/*     */     //   1350	15	18	replaceCurr	Z
/*     */     //   1271	94	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1247	119	15	index	I
/*     */     //   1247	119	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1250	116	16	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$4	I
/*     */     //   1214	153	10	item$iv	Ljava/lang/Object;
/*     */     //   1186	184	8	index$iv	I
/*     */     //   1180	190	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1183	187	7	$i$f$forEachIndexed	I
/*     */     //   1597	15	18	replaceCurr	Z
/*     */     //   1481	131	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1457	156	15	index	I
/*     */     //   1457	156	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1460	153	16	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$5	I
/*     */     //   1424	190	10	item$iv	Ljava/lang/Object;
/*     */     //   1396	221	8	index$iv	I
/*     */     //   1390	227	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1393	224	7	$i$f$forEachIndexed	I
/*     */     //   1797	15	18	replaceCurr	Z
/*     */     //   1728	84	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1704	109	15	index	I
/*     */     //   1704	109	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1707	106	16	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$6	I
/*     */     //   1671	143	10	item$iv	Ljava/lang/Object;
/*     */     //   1643	174	8	index$iv	I
/*     */     //   1637	180	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1640	177	7	$i$f$forEachIndexed	I
/*     */     //   1990	15	18	replaceCurr	Z
/*     */     //   1921	84	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1904	102	15	index	I
/*     */     //   1904	102	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1907	99	16	$i$a$-forEachIndexed-InventoryCleaner$findBetterItem$7	I
/*     */     //   1871	136	10	item$iv	Ljava/lang/Object;
/*     */     //   1843	168	8	index$iv	I
/*     */     //   1837	174	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1840	171	7	$i$f$forEachIndexed	I
/*     */     //   26	1987	4	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   6	2007	3	type	Ljava/lang/String;
/*     */     //   0	2013	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;
/*     */     //   0	2013	1	targetSlot	I
/*     */     //   0	2013	2	slotStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   private final Map<Integer, IItemStack> items(int start, int end) {
/* 358 */     int i = 0; Map<Object, Object> items = new LinkedHashMap<>();
/*     */     
/* 360 */     i = end - 1; int j = start; if (i >= j)
/* 361 */       while (true) { if (MinecraftInstance.mc.getThePlayer() != null && MinecraftInstance.mc.getThePlayer().getInventoryContainer() != null && MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i) != null && MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack() != null) { IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */           
/* 363 */           if (ItemUtils.isStackEmpty(itemStack)) {
/*     */             continue;
/*     */           }
/* 366 */           int k = i; if (36 > k) { 44; } else if (44 >= k && StringsKt.equals(type(i), "Ignore", true))
/*     */           { continue; }
/*     */           
/* 369 */           if (System.currentTimeMillis() - itemStack.getItemDelay() >= ((Number)this.itemDelayValue.get()).longValue())
/* 370 */             items.put(Integer.valueOf(i), itemStack);  continue; }
/*     */          MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack(); continue; if (i != j) { i--; continue; }
/*     */          break; }
/* 373 */         return (Map)items;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final String type(int targetSlot) {
/* 379 */     switch (targetSlot) { case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7:
/*     */       
/*     */       case 8:
/* 389 */        }  return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\InventoryCleaner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */