/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IGuiScreen;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.inventory.IGuiChest;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.inventory.ISlot;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.item.ItemUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "StealerPlus", description = "Packet", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\006\n\002\030\002\n\000\n\002\020\013\n\002\b\006\n\002\020\t\n\002\b\022\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020.\032\0020\0262\006\020/\032\00200H\002J\030\0201\032\002022\006\0203\032\002002\006\0204\032\00205H\002J\b\0206\032\00202H\026J\020\0207\032\002022\006\0208\032\00209H\007J\020\020:\032\002022\006\0208\032\0020;H\003J\022\020<\032\002022\b\0208\032\004\030\0010=H\007J\020\020>\032\002022\006\0208\032\0020?H\007J\016\020@\032\002022\006\0203\032\0020AJ\033\020B\032\0020\0262\b\020C\032\004\030\0010D2\006\020E\032\0020FH\bR\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\016\020\022\032\0020\007X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\024\020\025\032\0020\0268BX\004¢\006\006\032\004\b\027\020\030R\016\020\031\032\0020\tX\004¢\006\002\n\000R\016\020\032\032\0020\004X\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\035X\016¢\006\002\n\000R\016\020\036\032\0020\035X\016¢\006\002\n\000R\016\020\037\032\0020\tX\004¢\006\002\n\000R\016\020 \032\0020\tX\004¢\006\002\n\000R\032\020!\032\0020\026X\016¢\006\016\n\000\032\004\b\"\020\030\"\004\b#\020$R\016\020%\032\0020\tX\004¢\006\002\n\000R\021\020&\032\0020\t¢\006\b\n\000\032\004\b'\020(R\021\020)\032\0020\t¢\006\b\n\000\032\004\b*\020(R\021\020+\032\0020\t¢\006\b\n\000\032\004\b,\020(R\016\020-\032\0020\tX\004¢\006\002\n\000¨\006G"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/StealerPlus;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoCloseMaxDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "autoCloseMinDelayValue", "autoCloseTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "autoCloseValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "chestTitleValue", "closeOnFullValue", "contentReceived", "", "getContentReceived", "()I", "setContentReceived", "(I)V", "delayTimer", "eventModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "fullInventory", "", "getFullInventory", "()Z", "instantexploit", "maxDelayValue", "minDelayValue", "nextCloseDelay", "", "nextDelay", "noCompassValue", "noDuplicateValue", "once", "getOnce", "setOnce", "(Z)V", "onlyItemsValue", "showStringValue", "getShowStringValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "silenceValue", "getSilenceValue", "stillDisplayValue", "getStillDisplayValue", "takeRandomizedValue", "isEmpty", "chest", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;", "move", "", "screen", "slot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "onDisable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "performStealer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "shouldTake", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "inventoryCleaner", "Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;", "XSJClient"})
/*     */ public final class StealerPlus extends Module {
/*  37 */   private final IntegerValue maxDelayValue = new StealerPlus$maxDelayValue$1("MaxDelay", 200, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/StealerPlus$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class StealerPlus$maxDelayValue$1 extends IntegerValue { StealerPlus$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  39 */       int i = ((Number)StealerPlus.this.minDelayValue.get()).intValue();
/*  40 */       if (i > newValue) {
/*  41 */         set(Integer.valueOf(i));
/*     */       }
/*  43 */       StealerPlus.this.nextDelay = TimeUtils.randomDelay(((Number)StealerPlus.this.minDelayValue.get()).intValue(), ((Number)get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  47 */   private final IntegerValue minDelayValue = new StealerPlus$minDelayValue$1("MinDelay", 150, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/StealerPlus$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class StealerPlus$minDelayValue$1 extends IntegerValue { StealerPlus$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  49 */       int i = ((Number)StealerPlus.this.maxDelayValue.get()).intValue();
/*     */       
/*  51 */       if (i < newValue) {
/*  52 */         set(Integer.valueOf(i));
/*     */       }
/*  54 */       StealerPlus.this.nextDelay = TimeUtils.randomDelay(((Number)get()).intValue(), ((Number)StealerPlus.this.maxDelayValue.get()).intValue());
/*     */     } }
/*     */   
/*  57 */   private final BoolValue instantexploit = new BoolValue("UsePacket", true);
/*     */   
/*  59 */   private final ListValue eventModeValue = new ListValue("OnEvent", new String[] { "Render3D", "Update", "MotionPre", "MotionPost" }, "Render3D");
/*     */   
/*  61 */   private final BoolValue takeRandomizedValue = new BoolValue("TakeRandomized", false);
/*  62 */   private final BoolValue onlyItemsValue = new BoolValue("OnlyItems", false);
/*  63 */   private final BoolValue noCompassValue = new BoolValue("NoCompass", false);
/*  64 */   private final BoolValue noDuplicateValue = new BoolValue("NoDuplicateNonStackable", false);
/*  65 */   private final BoolValue autoCloseValue = new BoolValue("AutoClose", true); @NotNull
/*  66 */   private final BoolValue silenceValue = new BoolValue("SilentMode", true); @NotNull public final BoolValue getSilenceValue() { return this.silenceValue; } @NotNull
/*  67 */   private final BoolValue showStringValue = new BoolValue("Silent-ShowString", false); @NotNull public final BoolValue getShowStringValue() { return this.showStringValue; } @NotNull
/*  68 */   private final BoolValue stillDisplayValue = new BoolValue("Silent-StillDisplay", false); @NotNull public final BoolValue getStillDisplayValue() { return this.stillDisplayValue; }
/*     */   
/*  70 */   private final IntegerValue autoCloseMaxDelayValue = new StealerPlus$autoCloseMaxDelayValue$1("AutoCloseMaxDelay", 0, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/StealerPlus$autoCloseMaxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class StealerPlus$autoCloseMaxDelayValue$1 extends IntegerValue { StealerPlus$autoCloseMaxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  72 */       int i = ((Number)StealerPlus.this.autoCloseMinDelayValue.get()).intValue();
/*  73 */       if (i > newValue) set(Integer.valueOf(i)); 
/*  74 */       StealerPlus.this.nextCloseDelay = TimeUtils.randomDelay(((Number)StealerPlus.this.autoCloseMinDelayValue.get()).intValue(), ((Number)get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  78 */   private final IntegerValue autoCloseMinDelayValue = new StealerPlus$autoCloseMinDelayValue$1("AutoCloseMinDelay", 0, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/StealerPlus$autoCloseMinDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class StealerPlus$autoCloseMinDelayValue$1 extends IntegerValue { StealerPlus$autoCloseMinDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  80 */       int i = ((Number)StealerPlus.this.autoCloseMaxDelayValue.get()).intValue();
/*  81 */       if (i < newValue) set(Integer.valueOf(i)); 
/*  82 */       StealerPlus.this.nextCloseDelay = TimeUtils.randomDelay(((Number)get()).intValue(), ((Number)StealerPlus.this.autoCloseMaxDelayValue.get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  86 */   private final BoolValue closeOnFullValue = new BoolValue("CloseOnFull", true);
/*  87 */   private final BoolValue chestTitleValue = new BoolValue("ChestTitle", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   private final MSTimer delayTimer = new MSTimer();
/*  94 */   private long nextDelay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*     */   
/*  96 */   private final MSTimer autoCloseTimer = new MSTimer();
/*  97 */   private long nextCloseDelay = TimeUtils.randomDelay(((Number)this.autoCloseMinDelayValue.get()).intValue(), ((Number)this.autoCloseMaxDelayValue.get()).intValue()); private int contentReceived; private boolean once;
/*     */   
/*  99 */   public final int getContentReceived() { return this.contentReceived; } public final void setContentReceived(int <set-?>) { this.contentReceived = <set-?>; }
/*     */   
/* 101 */   public final boolean getOnce() { return this.once; } public final void setOnce(boolean <set-?>) { this.once = <set-?>; }
/*     */   
/*     */   public void onDisable() {
/* 104 */     this.once = false;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@Nullable Render3DEvent event) {
/* 109 */     if (MinecraftInstance.mc.getCurrentScreen() != null) { IGuiScreen screen = MinecraftInstance.mc.getCurrentScreen();
/*     */       
/* 111 */       if (StringsKt.equals((String)this.eventModeValue.get(), "render3d", true))
/* 112 */         performStealer(screen);  return; }
/*     */      MinecraftInstance.mc.getCurrentScreen();
/*     */   } @EventTarget public final void onMotion(@NotNull MotionEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getCurrentScreen() != null) {
/*     */       IGuiScreen screen = MinecraftInstance.mc.getCurrentScreen(); if (StringsKt.equals((String)this.eventModeValue.get(), "motion" + event.getEventState().getStateName(), true))
/*     */         performStealer(screen);  return;
/* 117 */     }  MinecraftInstance.mc.getCurrentScreen(); } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.instantexploit.get()).booleanValue() && 
/* 118 */       MinecraftInstance.classProvider.isGuiChest(MinecraftInstance.mc.getCurrentScreen()))
/* 119 */     { MinecraftInstance.mc.getCurrentScreen(); IGuiChest chest = (MinecraftInstance.mc.getCurrentScreen() != null) ? MinecraftInstance.mc.getCurrentScreen().asGuiChest() : null;
/* 120 */       if (((chest != null) ? Integer.valueOf(chest.getInventoryRows()) : null) == null) Intrinsics.throwNpe();  int rows = ((chest != null) ? Integer.valueOf(chest.getInventoryRows()) : null).intValue() * 9; byte b; int i;
/* 121 */       for (b = 0, i = rows; b < i; b++)
/* 122 */       { if (chest == null) Intrinsics.throwNpe();  chest.getInventorySlots(); ISlot slot = (chest.getInventorySlots() != null) ? chest.getInventorySlots().getSlot(b) : null;
/* 123 */         if (slot == null) Intrinsics.throwNpe();  if (slot.getHasStack())
/* 124 */         { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() != null)
/*     */           
/* 126 */           { chest.getInventorySlots(); if (((chest.getInventorySlots() != null) ? Integer.valueOf(chest.getInventorySlots().getWindowId()) : null) == null) Intrinsics.throwNpe();
/*     */ 
/*     */ 
/*     */             
/* 130 */             if (slot.getStack() == null) Intrinsics.throwNpe();  IItemStack iItemStack = slot.getStack(); ClickType clickType1 = ClickType.QUICK_MOVE; boolean bool1 = false; byte b1 = b; int j = ((chest.getInventorySlots() != null) ? Integer.valueOf(chest.getInventorySlots().getWindowId()) : null).intValue(); NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc2.func_147114_u(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 269 */             if (iItemStack == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ItemStackImpl");  ItemStack itemStack1 = ((ItemStackImpl)iItemStack).getWrapped(); short s = (short)1; ItemStack itemStack2 = itemStack1; ClickType clickType2 = clickType1; boolean bool2 = bool1; byte b2 = b1; int k = j; netHandlerPlayClient.func_147297_a((Packet)new CPacketClickWindow(k, b2, bool2, clickType2, itemStack2, s)); } else { MinecraftInstance.mc2.func_147114_u(); }  }  }  }  if (MinecraftInstance.mc.getCurrentScreen() != null) { IGuiScreen screen = MinecraftInstance.mc.getCurrentScreen(); if (StringsKt.equals((String)this.eventModeValue.get(), "update", true)) performStealer(screen);  return; }  MinecraftInstance.mc.getCurrentScreen(); } public final void performStealer(@NotNull IGuiScreen screen) { Intrinsics.checkParameterIsNotNull(screen, "screen"); if (this.once && !MinecraftInstance.classProvider.isGuiChest(screen)) { setState(false); return; }  if (!MinecraftInstance.classProvider.isGuiChest(screen) || !this.delayTimer.hasTimePassed(this.nextDelay)) { this.autoCloseTimer.reset(); return; }  if (!this.once && ((Boolean)this.noCompassValue.get()).booleanValue()) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand().getItem(); if (Intrinsics.areEqual((MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand() != null && MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand().getItem() != null) ? MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItemInHand().getItem().getUnlocalizedName() : null, "item.compass")) return;  }  if (!this.once && ((Boolean)this.chestTitleValue.get()).booleanValue()) if (screen.asGuiChest().getLowerChestInventory() != null) { if (screen.asGuiChest().getLowerChestInventory() == null) Intrinsics.throwNpe();  if (MinecraftInstance.functions.getObjectFromItemRegistry(MinecraftInstance.classProvider.createResourceLocation("minecraft:chest")) == null) Intrinsics.throwNpe();  if (!StringsKt.contains$default(screen.asGuiChest().getLowerChestInventory().getName(), MinecraftInstance.classProvider.createItemStack(MinecraftInstance.functions.getObjectFromItemRegistry(MinecraftInstance.classProvider.createResourceLocation("minecraft:chest"))).getDisplayName(), false, 2, null)) return;  } else { return; }   if (Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner");  InventoryCleaner inventoryCleaner = (InventoryCleaner)Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class); if (!isEmpty(screen.asGuiChest()) && (!((Boolean)this.closeOnFullValue.get()).booleanValue() || !getFullInventory())) { this.autoCloseTimer.reset(); if (((Boolean)this.takeRandomizedValue.get()).booleanValue()) { boolean noLoop = false; while (true) { byte b1 = 0; List<ISlot> items = new ArrayList(); int j; for (b1 = 0, j = screen.asGuiChest().getInventoryRows() * 9; b1 < j; b1++) { screen.asGuiChest().getInventorySlots(); ISlot iSlot = (screen.asGuiChest().getInventorySlots() != null) ? screen.asGuiChest().getInventorySlots().getSlot(b1) : null; if (iSlot == null) Intrinsics.throwNpe();  IItemStack stack = iSlot.getStack(); if (stack != null && (!((Boolean)this.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1))) items.add(iSlot);  }  int randomSlot = Random.Default.nextInt(items.size()); ISlot slot = items.get(randomSlot); move(screen.asGuiChest(), slot); if (this.nextDelay == 0L || this.delayTimer.hasTimePassed(this.nextDelay)) noLoop = true;  if (this.delayTimer.hasTimePassed(this.nextDelay)) { List<ISlot> list = items; boolean bool = false; if (!(!list.isEmpty() ? 1 : 0) || noLoop) break;  continue; }  break; }  return; }  byte b; int i; for (b = 0, i = screen.asGuiChest().getInventoryRows() * 9; b < i; b++) { screen.asGuiChest().getInventorySlots(); ISlot slot = (screen.asGuiChest().getInventorySlots() != null) ? screen.asGuiChest().getInventorySlots().getSlot(b) : null; if (slot == null)
/* 270 */           Intrinsics.throwNpe();  IItemStack stack = slot.getStack(); if (this.delayTimer.hasTimePassed(this.nextDelay)) { StealerPlus this_$iv = this; int $i$f$shouldTake = 0; if ((stack != null && !ItemUtils.isStackEmpty(stack) && (!((Boolean)this_$iv.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1)))) move(screen.asGuiChest(), slot);  }  }  } else if (((Boolean)this.autoCloseValue.get()).booleanValue()) { if (screen.asGuiChest().getInventorySlots() == null) Intrinsics.throwNpe();  if (screen.asGuiChest().getInventorySlots().getWindowId() == this.contentReceived && this.autoCloseTimer.hasTimePassed(this.nextCloseDelay)) { if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().closeScreen(); } else { MinecraftInstance.mc.getThePlayer(); }  if (((Boolean)this.silenceValue.get()).booleanValue() && !((Boolean)this.stillDisplayValue.get()).booleanValue()) Retreat.INSTANCE.getHud().addNotification(new Notification("ChestStealer", "Closed chest.", NotifyType.INFO, 0, 0, 24, null));  this.nextCloseDelay = TimeUtils.randomDelay(((Number)this.autoCloseMinDelayValue.get()).intValue(), ((Number)this.autoCloseMaxDelayValue.get()).intValue()); if (this.once) { this.once = false; setState(false); return; }  }  }  } @EventTarget private final void onPacket(PacketEvent event) { IPacket packet = event.getPacket(); if (MinecraftInstance.classProvider.isSPacketWindowItems(packet)) this.contentReceived = packet.asSPacketWindowItems().getWindowId();  } private final boolean shouldTake(IItemStack stack, InventoryCleaner inventoryCleaner) { int $i$f$shouldTake = 0; return (stack != null && !ItemUtils.isStackEmpty(stack) && (!((Boolean)this.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1))); } private final void move(IGuiChest screen, ISlot slot) { screen.handleMouseClick(slot, slot.getSlotNumber(), 0, 1); this.delayTimer.reset(); this.nextDelay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue()); }
/* 271 */   private final boolean isEmpty(IGuiChest chest) { if (Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner");  InventoryCleaner inventoryCleaner = (InventoryCleaner)Retreat.INSTANCE.getModuleManager().get(InventoryCleaner.class); byte b; int i; for (b = 0, i = chest.getInventoryRows() * 9; b < i; b++) { if (chest.getInventorySlots() == null) Intrinsics.throwNpe();  ISlot slot = chest.getInventorySlots().getSlot(b); IItemStack stack = slot.getStack(); StealerPlus this_$iv = this; int $i$f$shouldTake = 0; if ((stack != null && !ItemUtils.isStackEmpty(stack) && (!((Boolean)this_$iv.onlyItemsValue.get()).booleanValue() || !MinecraftInstance.classProvider.isItemBlock(stack.getItem())) && (!inventoryCleaner.getState() || inventoryCleaner.isUseful(stack, -1))))
/*     */         return false;  }
/*     */     
/*     */     return true; }
/*     */ 
/*     */   
/*     */   private final boolean getFullInventory() {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   3: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   8: dup
/*     */     //   9: ifnull -> 117
/*     */     //   12: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   17: dup
/*     */     //   18: ifnull -> 117
/*     */     //   21: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   26: dup
/*     */     //   27: ifnull -> 117
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
/*     */     //   72: ifeq -> 110
/*     */     //   75: aload_3
/*     */     //   76: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   81: astore #4
/*     */     //   83: aload #4
/*     */     //   85: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   88: astore #5
/*     */     //   90: iconst_0
/*     */     //   91: istore #6
/*     */     //   93: aload #5
/*     */     //   95: ifnonnull -> 102
/*     */     //   98: iconst_1
/*     */     //   99: goto -> 103
/*     */     //   102: iconst_0
/*     */     //   103: ifeq -> 66
/*     */     //   106: iconst_0
/*     */     //   107: goto -> 111
/*     */     //   110: iconst_1
/*     */     //   111: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   114: goto -> 119
/*     */     //   117: pop
/*     */     //   118: aconst_null
/*     */     //   119: dup
/*     */     //   120: ifnonnull -> 126
/*     */     //   123: invokestatic throwNpe : ()V
/*     */     //   126: invokevirtual booleanValue : ()Z
/*     */     //   129: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #266	-> 0
/*     */     //   #272	-> 36
/*     */     //   #273	-> 59
/*     */     //   #266	-> 93
/*     */     //   #274	-> 110
/*     */     //   #266	-> 129
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   90	13	5	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   93	10	6	$i$a$-none-StealerPlus$fullInventory$1	I
/*     */     //   83	27	4	element$iv	Ljava/lang/Object;
/*     */     //   34	77	1	$this$none$iv	Ljava/lang/Iterable;
/*     */     //   36	75	2	$i$f$none	I
/*     */     //   0	130	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/StealerPlus;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\StealerPlus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */