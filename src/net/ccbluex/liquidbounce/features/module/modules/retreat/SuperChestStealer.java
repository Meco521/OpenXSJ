/*     */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.IExtractedFunctions;
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
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.injection.backend.ItemStackImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketClickWindow;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @ModuleInfo(name = "SuperChestStealer", description = "Automatically steals all items from a chest.", category = ModuleCategory.RETREAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000t\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\006\n\002\030\002\n\000\n\002\020\013\n\002\b\006\n\002\020\t\n\002\b\022\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020.\032\0020\0262\006\020/\032\00200H\002J\030\0201\032\002022\006\0203\032\002002\006\0204\032\00205H\002J\b\0206\032\00202H\026J\020\0207\032\002022\006\0208\032\00209H\007J\020\020:\032\002022\006\0208\032\0020;H\003J\022\020<\032\002022\b\0208\032\004\030\0010=H\007J\020\020>\032\002022\006\0208\032\0020?H\007J\016\020@\032\002022\006\0203\032\0020AR\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\013\032\0020\tX\004¢\006\002\n\000R\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\016\020\022\032\0020\007X\004¢\006\002\n\000R\016\020\023\032\0020\024X\004¢\006\002\n\000R\024\020\025\032\0020\0268BX\004¢\006\006\032\004\b\027\020\030R\016\020\031\032\0020\tX\004¢\006\002\n\000R\016\020\032\032\0020\004X\004¢\006\002\n\000R\016\020\033\032\0020\004X\004¢\006\002\n\000R\016\020\034\032\0020\035X\016¢\006\002\n\000R\016\020\036\032\0020\035X\016¢\006\002\n\000R\016\020\037\032\0020\tX\004¢\006\002\n\000R\016\020 \032\0020\tX\004¢\006\002\n\000R\032\020!\032\0020\026X\016¢\006\016\n\000\032\004\b\"\020\030\"\004\b#\020$R\016\020%\032\0020\tX\004¢\006\002\n\000R\021\020&\032\0020\t¢\006\b\n\000\032\004\b'\020(R\021\020)\032\0020\t¢\006\b\n\000\032\004\b*\020(R\021\020+\032\0020\t¢\006\b\n\000\032\004\b,\020(R\016\020-\032\0020\tX\004¢\006\002\n\000¨\006B"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autoCloseMaxDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "autoCloseMinDelayValue", "autoCloseTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "autoCloseValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "chestTitleValue", "closeOnFullValue", "contentReceived", "", "getContentReceived", "()I", "setContentReceived", "(I)V", "delayTimer", "eventModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "fullInventory", "", "getFullInventory", "()Z", "instantexploit", "maxDelayValue", "minDelayValue", "nextCloseDelay", "", "nextDelay", "noCompassValue", "noDuplicateValue", "once", "getOnce", "setOnce", "(Z)V", "onlyItemsValue", "showStringValue", "getShowStringValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "silenceValue", "getSilenceValue", "stillDisplayValue", "getStillDisplayValue", "takeRandomizedValue", "isEmpty", "chest", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;", "move", "", "screen", "slot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "onDisable", "onMotion", "event", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "performStealer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;", "XSJClient"})
/*     */ public final class SuperChestStealer extends Module {
/*  37 */   private final IntegerValue maxDelayValue = new SuperChestStealer$maxDelayValue$1("MaxDelay", 200, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class SuperChestStealer$maxDelayValue$1 extends IntegerValue { SuperChestStealer$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  39 */       int i = ((Number)SuperChestStealer.this.minDelayValue.get()).intValue();
/*  40 */       if (i > newValue) {
/*  41 */         set(Integer.valueOf(i));
/*     */       }
/*  43 */       SuperChestStealer.this.nextDelay = TimeUtils.randomDelay(((Number)SuperChestStealer.this.minDelayValue.get()).intValue(), ((Number)get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  47 */   private final IntegerValue minDelayValue = new SuperChestStealer$minDelayValue$1("MinDelay", 150, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class SuperChestStealer$minDelayValue$1 extends IntegerValue { SuperChestStealer$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  49 */       int i = ((Number)SuperChestStealer.this.maxDelayValue.get()).intValue();
/*     */       
/*  51 */       if (i < newValue) {
/*  52 */         set(Integer.valueOf(i));
/*     */       }
/*  54 */       SuperChestStealer.this.nextDelay = TimeUtils.randomDelay(((Number)get()).intValue(), ((Number)SuperChestStealer.this.maxDelayValue.get()).intValue());
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
/*  70 */   private final IntegerValue autoCloseMaxDelayValue = new SuperChestStealer$autoCloseMaxDelayValue$1("AutoCloseMaxDelay", 0, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer$autoCloseMaxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class SuperChestStealer$autoCloseMaxDelayValue$1 extends IntegerValue { SuperChestStealer$autoCloseMaxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  72 */       int i = ((Number)SuperChestStealer.this.autoCloseMinDelayValue.get()).intValue();
/*  73 */       if (i > newValue) set(Integer.valueOf(i)); 
/*  74 */       SuperChestStealer.this.nextCloseDelay = TimeUtils.randomDelay(((Number)SuperChestStealer.this.autoCloseMinDelayValue.get()).intValue(), ((Number)get()).intValue());
/*     */     } }
/*     */ 
/*     */   
/*  78 */   private final IntegerValue autoCloseMinDelayValue = new SuperChestStealer$autoCloseMinDelayValue$1("AutoCloseMinDelay", 0, 0, 400); @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer$autoCloseMinDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"}) public static final class SuperChestStealer$autoCloseMinDelayValue$1 extends IntegerValue { SuperChestStealer$autoCloseMinDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) { super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4); }
/*     */      protected void onChanged(int oldValue, int newValue) {
/*  80 */       int i = ((Number)SuperChestStealer.this.autoCloseMaxDelayValue.get()).intValue();
/*  81 */       if (i < newValue) set(Integer.valueOf(i)); 
/*  82 */       SuperChestStealer.this.nextCloseDelay = TimeUtils.randomDelay(((Number)get()).intValue(), ((Number)SuperChestStealer.this.autoCloseMaxDelayValue.get()).intValue());
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
/*  97 */   private long nextCloseDelay = TimeUtils.randomDelay(((Number)this.autoCloseMinDelayValue.get()).intValue(), ((Number)this.autoCloseMaxDelayValue.get()).intValue());
/*     */   private int contentReceived; private boolean once;
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
/* 112 */         performStealer(screen); 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getCurrentScreen(); } @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 117 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.instantexploit.get()).booleanValue() && 
/* 118 */       MinecraftInstance.classProvider.isGuiChest(MinecraftInstance.mc.getCurrentScreen())) {
/* 119 */       MinecraftInstance.mc.getCurrentScreen(); IGuiChest chest = (MinecraftInstance.mc.getCurrentScreen() != null) ? MinecraftInstance.mc.getCurrentScreen().asGuiChest() : null;
/* 120 */       if (((chest != null) ? Integer.valueOf(chest.getInventoryRows()) : null) == null) Intrinsics.throwNpe();  int rows = ((chest != null) ? Integer.valueOf(chest.getInventoryRows()) : null).intValue() * 9; byte b; int i;
/* 121 */       for (b = 0, i = rows; b < i; b++) {
/* 122 */         if (chest == null) Intrinsics.throwNpe();  chest.getInventorySlots(); ISlot slot = (chest.getInventorySlots() != null) ? chest.getInventorySlots().getSlot(b) : null;
/* 123 */         if (slot == null) Intrinsics.throwNpe();  if (slot.getHasStack()) {
/* 124 */           Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() != null) {
/*     */             
/* 126 */             chest.getInventorySlots(); if (((chest.getInventorySlots() != null) ? Integer.valueOf(chest.getInventorySlots().getWindowId()) : null) == null) Intrinsics.throwNpe();
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
/* 262 */             if (iItemStack == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ItemStackImpl");  ItemStack itemStack1 = ((ItemStackImpl)iItemStack).getWrapped(); short s = (short)1; ItemStack itemStack2 = itemStack1; ClickType clickType2 = clickType1; boolean bool2 = bool1; byte b2 = b1; int k = j; netHandlerPlayClient.func_147297_a((Packet)new CPacketClickWindow(k, b2, bool2, clickType2, itemStack2, s));
/*     */           } else {
/*     */             MinecraftInstance.mc2.func_147114_u();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       if (MinecraftInstance.mc.getThePlayer() != null) {
/*     */         MinecraftInstance.mc.getThePlayer().closeScreen();
/*     */       } else {
/*     */         MinecraftInstance.mc.getThePlayer();
/*     */       } 
/*     */     } 
/*     */     if (MinecraftInstance.mc.getCurrentScreen() != null) {
/*     */       IGuiScreen screen = MinecraftInstance.mc.getCurrentScreen();
/*     */       if (StringsKt.equals((String)this.eventModeValue.get(), "update", true))
/*     */         performStealer(screen); 
/*     */       return;
/*     */     } 
/*     */     MinecraftInstance.mc.getCurrentScreen();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     if (MinecraftInstance.mc.getCurrentScreen() != null) {
/*     */       IGuiScreen screen = MinecraftInstance.mc.getCurrentScreen();
/*     */       if (StringsKt.equals((String)this.eventModeValue.get(), "motion" + event.getEventState().getStateName(), true))
/*     */         performStealer(screen); 
/*     */       return;
/*     */     } 
/*     */     MinecraftInstance.mc.getCurrentScreen();
/*     */   }
/*     */   
/*     */   public final void performStealer(@NotNull IGuiScreen screen) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'screen'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield once : Z
/*     */     //   11: ifeq -> 32
/*     */     //   14: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   17: aload_1
/*     */     //   18: invokeinterface isGuiChest : (Ljava/lang/Object;)Z
/*     */     //   23: ifne -> 32
/*     */     //   26: aload_0
/*     */     //   27: iconst_0
/*     */     //   28: invokevirtual setState : (Z)V
/*     */     //   31: return
/*     */     //   32: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   35: aload_1
/*     */     //   36: invokeinterface isGuiChest : (Ljava/lang/Object;)Z
/*     */     //   41: ifeq -> 58
/*     */     //   44: aload_0
/*     */     //   45: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   48: aload_0
/*     */     //   49: getfield nextDelay : J
/*     */     //   52: invokevirtual hasTimePassed : (J)Z
/*     */     //   55: ifne -> 66
/*     */     //   58: aload_0
/*     */     //   59: getfield autoCloseTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   62: invokevirtual reset : ()V
/*     */     //   65: return
/*     */     //   66: aload_0
/*     */     //   67: getfield once : Z
/*     */     //   70: ifne -> 147
/*     */     //   73: aload_0
/*     */     //   74: getfield noCompassValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   77: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   80: checkcast java/lang/Boolean
/*     */     //   83: invokevirtual booleanValue : ()Z
/*     */     //   86: ifeq -> 147
/*     */     //   89: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   92: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   97: dup
/*     */     //   98: ifnonnull -> 104
/*     */     //   101: invokestatic throwNpe : ()V
/*     */     //   104: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   109: invokeinterface getCurrentItemInHand : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   114: dup
/*     */     //   115: ifnull -> 135
/*     */     //   118: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   123: dup
/*     */     //   124: ifnull -> 135
/*     */     //   127: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   132: goto -> 137
/*     */     //   135: pop
/*     */     //   136: aconst_null
/*     */     //   137: ldc_w 'item.compass'
/*     */     //   140: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   143: ifeq -> 147
/*     */     //   146: return
/*     */     //   147: aload_0
/*     */     //   148: getfield once : Z
/*     */     //   151: ifne -> 262
/*     */     //   154: aload_0
/*     */     //   155: getfield chestTitleValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   158: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   161: checkcast java/lang/Boolean
/*     */     //   164: invokevirtual booleanValue : ()Z
/*     */     //   167: ifeq -> 262
/*     */     //   170: aload_1
/*     */     //   171: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   176: invokeinterface getLowerChestInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IIInventory;
/*     */     //   181: ifnull -> 261
/*     */     //   184: aload_1
/*     */     //   185: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   190: invokeinterface getLowerChestInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IIInventory;
/*     */     //   195: dup
/*     */     //   196: ifnonnull -> 202
/*     */     //   199: invokestatic throwNpe : ()V
/*     */     //   202: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   207: checkcast java/lang/CharSequence
/*     */     //   210: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   213: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*     */     //   216: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   219: ldc_w 'minecraft:chest'
/*     */     //   222: invokeinterface createResourceLocation : (Ljava/lang/String;)Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   227: invokeinterface getObjectFromItemRegistry : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   232: dup
/*     */     //   233: ifnonnull -> 239
/*     */     //   236: invokestatic throwNpe : ()V
/*     */     //   239: invokeinterface createItemStack : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   244: invokeinterface getDisplayName : ()Ljava/lang/String;
/*     */     //   249: checkcast java/lang/CharSequence
/*     */     //   252: iconst_0
/*     */     //   253: iconst_2
/*     */     //   254: aconst_null
/*     */     //   255: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
/*     */     //   258: ifne -> 262
/*     */     //   261: return
/*     */     //   262: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   265: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   268: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner
/*     */     //   271: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   274: dup
/*     */     //   275: ifnonnull -> 289
/*     */     //   278: new kotlin/TypeCastException
/*     */     //   281: dup
/*     */     //   282: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner'
/*     */     //   285: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   288: athrow
/*     */     //   289: checkcast net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner
/*     */     //   292: astore_2
/*     */     //   293: aload_0
/*     */     //   294: aload_1
/*     */     //   295: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   300: invokespecial isEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;)Z
/*     */     //   303: ifne -> 1595
/*     */     //   306: aload_0
/*     */     //   307: getfield closeOnFullValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   310: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   313: checkcast java/lang/Boolean
/*     */     //   316: invokevirtual booleanValue : ()Z
/*     */     //   319: ifeq -> 329
/*     */     //   322: aload_0
/*     */     //   323: invokespecial getFullInventory : ()Z
/*     */     //   326: ifne -> 1595
/*     */     //   329: aload_0
/*     */     //   330: getfield autoCloseTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   333: invokevirtual reset : ()V
/*     */     //   336: aload_0
/*     */     //   337: getfield takeRandomizedValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   340: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   343: checkcast java/lang/Boolean
/*     */     //   346: invokevirtual booleanValue : ()Z
/*     */     //   349: ifeq -> 1032
/*     */     //   352: iconst_0
/*     */     //   353: istore_3
/*     */     //   354: iconst_0
/*     */     //   355: istore #5
/*     */     //   357: new java/util/ArrayList
/*     */     //   360: dup
/*     */     //   361: invokespecial <init> : ()V
/*     */     //   364: checkcast java/util/List
/*     */     //   367: astore #4
/*     */     //   369: iconst_0
/*     */     //   370: istore #5
/*     */     //   372: aload_1
/*     */     //   373: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   378: invokeinterface getInventoryRows : ()I
/*     */     //   383: bipush #9
/*     */     //   385: imul
/*     */     //   386: istore #6
/*     */     //   388: iload #5
/*     */     //   390: iload #6
/*     */     //   392: if_icmpge -> 919
/*     */     //   395: aload_1
/*     */     //   396: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   401: invokeinterface getInventorySlots : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   406: dup
/*     */     //   407: ifnull -> 420
/*     */     //   410: iload #5
/*     */     //   412: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   417: goto -> 422
/*     */     //   420: pop
/*     */     //   421: aconst_null
/*     */     //   422: astore #7
/*     */     //   424: aload #7
/*     */     //   426: dup
/*     */     //   427: ifnull -> 438
/*     */     //   430: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   435: goto -> 440
/*     */     //   438: pop
/*     */     //   439: aconst_null
/*     */     //   440: dup
/*     */     //   441: ifnonnull -> 447
/*     */     //   444: invokestatic throwNpe : ()V
/*     */     //   447: ifnull -> 913
/*     */     //   450: aload_0
/*     */     //   451: getfield onlyItemsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   454: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   457: checkcast java/lang/Boolean
/*     */     //   460: invokevirtual booleanValue : ()Z
/*     */     //   463: ifeq -> 500
/*     */     //   466: aload #7
/*     */     //   468: dup
/*     */     //   469: ifnull -> 480
/*     */     //   472: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   477: goto -> 482
/*     */     //   480: pop
/*     */     //   481: aconst_null
/*     */     //   482: dup
/*     */     //   483: ifnonnull -> 489
/*     */     //   486: invokestatic throwNpe : ()V
/*     */     //   489: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   494: instanceof net/minecraft/item/ItemBlock
/*     */     //   497: ifne -> 913
/*     */     //   500: aload_0
/*     */     //   501: getfield noDuplicateValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   504: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   507: checkcast java/lang/Boolean
/*     */     //   510: invokevirtual booleanValue : ()Z
/*     */     //   513: ifeq -> 858
/*     */     //   516: aload #7
/*     */     //   518: dup
/*     */     //   519: ifnull -> 530
/*     */     //   522: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   527: goto -> 532
/*     */     //   530: pop
/*     */     //   531: aconst_null
/*     */     //   532: dup
/*     */     //   533: ifnonnull -> 539
/*     */     //   536: invokestatic throwNpe : ()V
/*     */     //   539: invokeinterface getStackSize : ()I
/*     */     //   544: iconst_1
/*     */     //   545: if_icmpgt -> 858
/*     */     //   548: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   551: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   556: dup
/*     */     //   557: ifnull -> 843
/*     */     //   560: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   565: dup
/*     */     //   566: ifnull -> 843
/*     */     //   569: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   574: dup
/*     */     //   575: ifnull -> 843
/*     */     //   578: checkcast java/lang/Iterable
/*     */     //   581: astore #8
/*     */     //   583: iconst_0
/*     */     //   584: istore #9
/*     */     //   586: aload #8
/*     */     //   588: astore #10
/*     */     //   590: new java/util/ArrayList
/*     */     //   593: dup
/*     */     //   594: invokespecial <init> : ()V
/*     */     //   597: checkcast java/util/Collection
/*     */     //   600: astore #11
/*     */     //   602: iconst_0
/*     */     //   603: istore #12
/*     */     //   605: aload #10
/*     */     //   607: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   612: astore #13
/*     */     //   614: aload #13
/*     */     //   616: invokeinterface hasNext : ()Z
/*     */     //   621: ifeq -> 679
/*     */     //   624: aload #13
/*     */     //   626: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   631: astore #14
/*     */     //   633: aload #14
/*     */     //   635: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   638: astore #15
/*     */     //   640: iconst_0
/*     */     //   641: istore #16
/*     */     //   643: aload #15
/*     */     //   645: ifnull -> 662
/*     */     //   648: aload #15
/*     */     //   650: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   655: ifnull -> 662
/*     */     //   658: iconst_1
/*     */     //   659: goto -> 663
/*     */     //   662: iconst_0
/*     */     //   663: ifeq -> 614
/*     */     //   666: aload #11
/*     */     //   668: aload #14
/*     */     //   670: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   675: pop
/*     */     //   676: goto -> 614
/*     */     //   679: aload #11
/*     */     //   681: checkcast java/util/List
/*     */     //   684: checkcast java/lang/Iterable
/*     */     //   687: astore #8
/*     */     //   689: iconst_0
/*     */     //   690: istore #9
/*     */     //   692: aload #8
/*     */     //   694: astore #10
/*     */     //   696: new java/util/ArrayList
/*     */     //   699: dup
/*     */     //   700: aload #8
/*     */     //   702: bipush #10
/*     */     //   704: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
/*     */     //   707: invokespecial <init> : (I)V
/*     */     //   710: checkcast java/util/Collection
/*     */     //   713: astore #11
/*     */     //   715: iconst_0
/*     */     //   716: istore #12
/*     */     //   718: aload #10
/*     */     //   720: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   725: astore #13
/*     */     //   727: aload #13
/*     */     //   729: invokeinterface hasNext : ()Z
/*     */     //   734: ifeq -> 798
/*     */     //   737: aload #13
/*     */     //   739: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   744: astore #14
/*     */     //   746: aload #11
/*     */     //   748: aload #14
/*     */     //   750: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   753: astore #15
/*     */     //   755: astore #17
/*     */     //   757: iconst_0
/*     */     //   758: istore #16
/*     */     //   760: aload #15
/*     */     //   762: dup
/*     */     //   763: ifnull -> 774
/*     */     //   766: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   771: goto -> 776
/*     */     //   774: pop
/*     */     //   775: aconst_null
/*     */     //   776: dup
/*     */     //   777: ifnonnull -> 783
/*     */     //   780: invokestatic throwNpe : ()V
/*     */     //   783: astore #18
/*     */     //   785: aload #17
/*     */     //   787: aload #18
/*     */     //   789: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   794: pop
/*     */     //   795: goto -> 727
/*     */     //   798: aload #11
/*     */     //   800: checkcast java/util/List
/*     */     //   803: checkcast java/lang/Iterable
/*     */     //   806: aload #7
/*     */     //   808: dup
/*     */     //   809: ifnull -> 820
/*     */     //   812: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   817: goto -> 822
/*     */     //   820: pop
/*     */     //   821: aconst_null
/*     */     //   822: dup
/*     */     //   823: ifnonnull -> 829
/*     */     //   826: invokestatic throwNpe : ()V
/*     */     //   829: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   834: invokestatic contains : (Ljava/lang/Iterable;Ljava/lang/Object;)Z
/*     */     //   837: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   840: goto -> 845
/*     */     //   843: pop
/*     */     //   844: aconst_null
/*     */     //   845: dup
/*     */     //   846: ifnonnull -> 852
/*     */     //   849: invokestatic throwNpe : ()V
/*     */     //   852: invokevirtual booleanValue : ()Z
/*     */     //   855: ifne -> 913
/*     */     //   858: aload_2
/*     */     //   859: invokevirtual getState : ()Z
/*     */     //   862: ifeq -> 896
/*     */     //   865: aload_2
/*     */     //   866: aload #7
/*     */     //   868: dup
/*     */     //   869: ifnull -> 880
/*     */     //   872: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   877: goto -> 882
/*     */     //   880: pop
/*     */     //   881: aconst_null
/*     */     //   882: dup
/*     */     //   883: ifnonnull -> 889
/*     */     //   886: invokestatic throwNpe : ()V
/*     */     //   889: iconst_m1
/*     */     //   890: invokevirtual isUseful : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)Z
/*     */     //   893: ifeq -> 913
/*     */     //   896: aload #4
/*     */     //   898: aload #7
/*     */     //   900: dup
/*     */     //   901: ifnonnull -> 907
/*     */     //   904: invokestatic throwNpe : ()V
/*     */     //   907: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   912: pop
/*     */     //   913: iinc #5, 1
/*     */     //   916: goto -> 388
/*     */     //   919: getstatic kotlin/random/Random.Default : Lkotlin/random/Random$Default;
/*     */     //   922: aload #4
/*     */     //   924: invokeinterface size : ()I
/*     */     //   929: invokevirtual nextInt : (I)I
/*     */     //   932: istore #5
/*     */     //   934: aload #4
/*     */     //   936: iload #5
/*     */     //   938: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   943: checkcast net/ccbluex/liquidbounce/api/minecraft/inventory/ISlot
/*     */     //   946: astore #6
/*     */     //   948: aload_0
/*     */     //   949: aload_1
/*     */     //   950: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   955: aload #6
/*     */     //   957: invokespecial move : (Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;)V
/*     */     //   960: aload_0
/*     */     //   961: getfield nextDelay : J
/*     */     //   964: lconst_0
/*     */     //   965: lcmp
/*     */     //   966: ifeq -> 983
/*     */     //   969: aload_0
/*     */     //   970: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   973: aload_0
/*     */     //   974: getfield nextDelay : J
/*     */     //   977: invokevirtual hasTimePassed : (J)Z
/*     */     //   980: ifeq -> 985
/*     */     //   983: iconst_1
/*     */     //   984: istore_3
/*     */     //   985: aload_0
/*     */     //   986: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   989: aload_0
/*     */     //   990: getfield nextDelay : J
/*     */     //   993: invokevirtual hasTimePassed : (J)Z
/*     */     //   996: ifeq -> 1031
/*     */     //   999: aload #4
/*     */     //   1001: checkcast java/util/Collection
/*     */     //   1004: astore #7
/*     */     //   1006: iconst_0
/*     */     //   1007: istore #8
/*     */     //   1009: aload #7
/*     */     //   1011: invokeinterface isEmpty : ()Z
/*     */     //   1016: ifne -> 1023
/*     */     //   1019: iconst_1
/*     */     //   1020: goto -> 1024
/*     */     //   1023: iconst_0
/*     */     //   1024: ifeq -> 1031
/*     */     //   1027: iload_3
/*     */     //   1028: ifeq -> 354
/*     */     //   1031: return
/*     */     //   1032: iconst_0
/*     */     //   1033: istore_3
/*     */     //   1034: aload_1
/*     */     //   1035: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   1040: invokeinterface getInventoryRows : ()I
/*     */     //   1045: bipush #9
/*     */     //   1047: imul
/*     */     //   1048: istore #4
/*     */     //   1050: iload_3
/*     */     //   1051: iload #4
/*     */     //   1053: if_icmpge -> 1795
/*     */     //   1056: aload_1
/*     */     //   1057: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   1062: invokeinterface getInventorySlots : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   1067: dup
/*     */     //   1068: ifnull -> 1080
/*     */     //   1071: iload_3
/*     */     //   1072: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   1077: goto -> 1082
/*     */     //   1080: pop
/*     */     //   1081: aconst_null
/*     */     //   1082: astore #5
/*     */     //   1084: aload_0
/*     */     //   1085: getfield delayTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1088: aload_0
/*     */     //   1089: getfield nextDelay : J
/*     */     //   1092: invokevirtual hasTimePassed : (J)Z
/*     */     //   1095: ifeq -> 1589
/*     */     //   1098: aload #5
/*     */     //   1100: dup
/*     */     //   1101: ifnull -> 1112
/*     */     //   1104: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1109: goto -> 1114
/*     */     //   1112: pop
/*     */     //   1113: aconst_null
/*     */     //   1114: dup
/*     */     //   1115: ifnonnull -> 1121
/*     */     //   1118: invokestatic throwNpe : ()V
/*     */     //   1121: ifnull -> 1589
/*     */     //   1124: aload_0
/*     */     //   1125: getfield onlyItemsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1128: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1131: checkcast java/lang/Boolean
/*     */     //   1134: invokevirtual booleanValue : ()Z
/*     */     //   1137: ifeq -> 1174
/*     */     //   1140: aload #5
/*     */     //   1142: dup
/*     */     //   1143: ifnull -> 1154
/*     */     //   1146: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1151: goto -> 1156
/*     */     //   1154: pop
/*     */     //   1155: aconst_null
/*     */     //   1156: dup
/*     */     //   1157: ifnonnull -> 1163
/*     */     //   1160: invokestatic throwNpe : ()V
/*     */     //   1163: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1168: instanceof net/minecraft/item/ItemBlock
/*     */     //   1171: ifne -> 1589
/*     */     //   1174: aload_0
/*     */     //   1175: getfield noDuplicateValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1178: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1181: checkcast java/lang/Boolean
/*     */     //   1184: invokevirtual booleanValue : ()Z
/*     */     //   1187: ifeq -> 1532
/*     */     //   1190: aload #5
/*     */     //   1192: dup
/*     */     //   1193: ifnull -> 1204
/*     */     //   1196: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1201: goto -> 1206
/*     */     //   1204: pop
/*     */     //   1205: aconst_null
/*     */     //   1206: dup
/*     */     //   1207: ifnonnull -> 1213
/*     */     //   1210: invokestatic throwNpe : ()V
/*     */     //   1213: invokeinterface getStackSize : ()I
/*     */     //   1218: iconst_1
/*     */     //   1219: if_icmpgt -> 1532
/*     */     //   1222: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1225: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1230: dup
/*     */     //   1231: ifnull -> 1517
/*     */     //   1234: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1239: dup
/*     */     //   1240: ifnull -> 1517
/*     */     //   1243: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1248: dup
/*     */     //   1249: ifnull -> 1517
/*     */     //   1252: checkcast java/lang/Iterable
/*     */     //   1255: astore #6
/*     */     //   1257: iconst_0
/*     */     //   1258: istore #7
/*     */     //   1260: aload #6
/*     */     //   1262: astore #8
/*     */     //   1264: new java/util/ArrayList
/*     */     //   1267: dup
/*     */     //   1268: invokespecial <init> : ()V
/*     */     //   1271: checkcast java/util/Collection
/*     */     //   1274: astore #9
/*     */     //   1276: iconst_0
/*     */     //   1277: istore #10
/*     */     //   1279: aload #8
/*     */     //   1281: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1286: astore #11
/*     */     //   1288: aload #11
/*     */     //   1290: invokeinterface hasNext : ()Z
/*     */     //   1295: ifeq -> 1353
/*     */     //   1298: aload #11
/*     */     //   1300: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1305: astore #12
/*     */     //   1307: aload #12
/*     */     //   1309: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1312: astore #13
/*     */     //   1314: iconst_0
/*     */     //   1315: istore #14
/*     */     //   1317: aload #13
/*     */     //   1319: ifnull -> 1336
/*     */     //   1322: aload #13
/*     */     //   1324: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1329: ifnull -> 1336
/*     */     //   1332: iconst_1
/*     */     //   1333: goto -> 1337
/*     */     //   1336: iconst_0
/*     */     //   1337: ifeq -> 1288
/*     */     //   1340: aload #9
/*     */     //   1342: aload #12
/*     */     //   1344: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   1349: pop
/*     */     //   1350: goto -> 1288
/*     */     //   1353: aload #9
/*     */     //   1355: checkcast java/util/List
/*     */     //   1358: checkcast java/lang/Iterable
/*     */     //   1361: astore #6
/*     */     //   1363: iconst_0
/*     */     //   1364: istore #7
/*     */     //   1366: aload #6
/*     */     //   1368: astore #8
/*     */     //   1370: new java/util/ArrayList
/*     */     //   1373: dup
/*     */     //   1374: aload #6
/*     */     //   1376: bipush #10
/*     */     //   1378: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
/*     */     //   1381: invokespecial <init> : (I)V
/*     */     //   1384: checkcast java/util/Collection
/*     */     //   1387: astore #9
/*     */     //   1389: iconst_0
/*     */     //   1390: istore #10
/*     */     //   1392: aload #8
/*     */     //   1394: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1399: astore #11
/*     */     //   1401: aload #11
/*     */     //   1403: invokeinterface hasNext : ()Z
/*     */     //   1408: ifeq -> 1472
/*     */     //   1411: aload #11
/*     */     //   1413: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1418: astore #12
/*     */     //   1420: aload #9
/*     */     //   1422: aload #12
/*     */     //   1424: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1427: astore #13
/*     */     //   1429: astore #17
/*     */     //   1431: iconst_0
/*     */     //   1432: istore #14
/*     */     //   1434: aload #13
/*     */     //   1436: dup
/*     */     //   1437: ifnull -> 1448
/*     */     //   1440: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1445: goto -> 1450
/*     */     //   1448: pop
/*     */     //   1449: aconst_null
/*     */     //   1450: dup
/*     */     //   1451: ifnonnull -> 1457
/*     */     //   1454: invokestatic throwNpe : ()V
/*     */     //   1457: astore #18
/*     */     //   1459: aload #17
/*     */     //   1461: aload #18
/*     */     //   1463: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   1468: pop
/*     */     //   1469: goto -> 1401
/*     */     //   1472: aload #9
/*     */     //   1474: checkcast java/util/List
/*     */     //   1477: checkcast java/lang/Iterable
/*     */     //   1480: aload #5
/*     */     //   1482: dup
/*     */     //   1483: ifnull -> 1494
/*     */     //   1486: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1491: goto -> 1496
/*     */     //   1494: pop
/*     */     //   1495: aconst_null
/*     */     //   1496: dup
/*     */     //   1497: ifnonnull -> 1503
/*     */     //   1500: invokestatic throwNpe : ()V
/*     */     //   1503: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1508: invokestatic contains : (Ljava/lang/Iterable;Ljava/lang/Object;)Z
/*     */     //   1511: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   1514: goto -> 1519
/*     */     //   1517: pop
/*     */     //   1518: aconst_null
/*     */     //   1519: dup
/*     */     //   1520: ifnonnull -> 1526
/*     */     //   1523: invokestatic throwNpe : ()V
/*     */     //   1526: invokevirtual booleanValue : ()Z
/*     */     //   1529: ifne -> 1589
/*     */     //   1532: aload_2
/*     */     //   1533: invokevirtual getState : ()Z
/*     */     //   1536: ifeq -> 1570
/*     */     //   1539: aload_2
/*     */     //   1540: aload #5
/*     */     //   1542: dup
/*     */     //   1543: ifnull -> 1554
/*     */     //   1546: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1551: goto -> 1556
/*     */     //   1554: pop
/*     */     //   1555: aconst_null
/*     */     //   1556: dup
/*     */     //   1557: ifnonnull -> 1563
/*     */     //   1560: invokestatic throwNpe : ()V
/*     */     //   1563: iconst_m1
/*     */     //   1564: invokevirtual isUseful : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)Z
/*     */     //   1567: ifeq -> 1589
/*     */     //   1570: aload_0
/*     */     //   1571: aload_1
/*     */     //   1572: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   1577: aload #5
/*     */     //   1579: dup
/*     */     //   1580: ifnonnull -> 1586
/*     */     //   1583: invokestatic throwNpe : ()V
/*     */     //   1586: invokespecial move : (Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;)V
/*     */     //   1589: iinc #3, 1
/*     */     //   1592: goto -> 1050
/*     */     //   1595: aload_0
/*     */     //   1596: getfield autoCloseValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1599: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1602: checkcast java/lang/Boolean
/*     */     //   1605: invokevirtual booleanValue : ()Z
/*     */     //   1608: ifeq -> 1795
/*     */     //   1611: aload_1
/*     */     //   1612: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   1617: invokeinterface getInventorySlots : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   1622: dup
/*     */     //   1623: ifnonnull -> 1629
/*     */     //   1626: invokestatic throwNpe : ()V
/*     */     //   1629: invokeinterface getWindowId : ()I
/*     */     //   1634: aload_0
/*     */     //   1635: getfield contentReceived : I
/*     */     //   1638: if_icmpne -> 1795
/*     */     //   1641: aload_0
/*     */     //   1642: getfield autoCloseTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1645: aload_0
/*     */     //   1646: getfield nextCloseDelay : J
/*     */     //   1649: invokevirtual hasTimePassed : (J)Z
/*     */     //   1652: ifeq -> 1795
/*     */     //   1655: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1658: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1663: dup
/*     */     //   1664: ifnull -> 1678
/*     */     //   1667: invokeinterface closeScreen : ()V
/*     */     //   1672: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
/*     */     //   1675: goto -> 1680
/*     */     //   1678: pop
/*     */     //   1679: aconst_null
/*     */     //   1680: pop
/*     */     //   1681: aload_0
/*     */     //   1682: getfield silenceValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1685: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1688: checkcast java/lang/Boolean
/*     */     //   1691: invokevirtual booleanValue : ()Z
/*     */     //   1694: ifeq -> 1744
/*     */     //   1697: aload_0
/*     */     //   1698: getfield stillDisplayValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1701: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1704: checkcast java/lang/Boolean
/*     */     //   1707: invokevirtual booleanValue : ()Z
/*     */     //   1710: ifne -> 1744
/*     */     //   1713: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1716: invokevirtual getHud : ()Lnet/ccbluex/liquidbounce/ui/client/hud/HUD;
/*     */     //   1719: new net/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification
/*     */     //   1722: dup
/*     */     //   1723: ldc_w 'ChestStealer'
/*     */     //   1726: ldc_w 'Closed chest.'
/*     */     //   1729: getstatic net/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType.INFO : Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;
/*     */     //   1732: iconst_0
/*     */     //   1733: iconst_0
/*     */     //   1734: bipush #24
/*     */     //   1736: aconst_null
/*     */     //   1737: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/NotifyType;IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
/*     */     //   1740: invokevirtual addNotification : (Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;)Z
/*     */     //   1743: pop
/*     */     //   1744: aload_0
/*     */     //   1745: aload_0
/*     */     //   1746: getfield autoCloseMinDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1749: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1752: checkcast java/lang/Number
/*     */     //   1755: invokevirtual intValue : ()I
/*     */     //   1758: aload_0
/*     */     //   1759: getfield autoCloseMaxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1762: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1765: checkcast java/lang/Number
/*     */     //   1768: invokevirtual intValue : ()I
/*     */     //   1771: invokestatic randomDelay : (II)J
/*     */     //   1774: putfield nextCloseDelay : J
/*     */     //   1777: aload_0
/*     */     //   1778: getfield once : Z
/*     */     //   1781: ifeq -> 1795
/*     */     //   1784: aload_0
/*     */     //   1785: iconst_0
/*     */     //   1786: putfield once : Z
/*     */     //   1789: aload_0
/*     */     //   1790: iconst_0
/*     */     //   1791: invokevirtual setState : (Z)V
/*     */     //   1794: return
/*     */     //   1795: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #154	-> 7
/*     */     //   #156	-> 26
/*     */     //   #157	-> 31
/*     */     //   #160	-> 32
/*     */     //   #161	-> 58
/*     */     //   #162	-> 65
/*     */     //   #166	-> 66
/*     */     //   #167	-> 146
/*     */     //   #170	-> 147
/*     */     //   #171	-> 210
/*     */     //   #173	-> 210
/*     */     //   #171	-> 210
/*     */     //   #172	-> 213
/*     */     //   #171	-> 239
/*     */     //   #170	-> 255
/*     */     //   #174	-> 261
/*     */     //   #177	-> 262
/*     */     //   #180	-> 293
/*     */     //   #181	-> 329
/*     */     //   #184	-> 336
/*     */     //   #185	-> 352
/*     */     //   #186	-> 354
/*     */     //   #187	-> 354
/*     */     //   #187	-> 367
/*     */     //   #189	-> 369
/*     */     //   #190	-> 395
/*     */     //   #192	-> 424
/*     */     //   #263	-> 586
/*     */     //   #264	-> 605
/*     */     //   #192	-> 643
/*     */     //   #265	-> 679
/*     */     //   #192	-> 689
/*     */     //   #266	-> 692
/*     */     //   #267	-> 718
/*     */     //   #268	-> 746
/*     */     //   #192	-> 760
/*     */     //   #267	-> 795
/*     */     //   #269	-> 798
/*     */     //   #192	-> 806
/*     */     //   #193	-> 896
/*     */     //   #189	-> 913
/*     */     //   #196	-> 919
/*     */     //   #197	-> 934
/*     */     //   #199	-> 948
/*     */     //   #200	-> 960
/*     */     //   #201	-> 983
/*     */     //   #202	-> 985
/*     */     //   #203	-> 1031
/*     */     //   #207	-> 1032
/*     */     //   #208	-> 1056
/*     */     //   #210	-> 1084
/*     */     //   #211	-> 1084
/*     */     //   #210	-> 1084
/*     */     //   #211	-> 1124
/*     */     //   #270	-> 1260
/*     */     //   #271	-> 1279
/*     */     //   #211	-> 1317
/*     */     //   #272	-> 1353
/*     */     //   #211	-> 1363
/*     */     //   #273	-> 1366
/*     */     //   #274	-> 1392
/*     */     //   #275	-> 1420
/*     */     //   #211	-> 1434
/*     */     //   #274	-> 1469
/*     */     //   #276	-> 1472
/*     */     //   #211	-> 1480
/*     */     //   #212	-> 1570
/*     */     //   #207	-> 1589
/*     */     //   #215	-> 1595
/*     */     //   #216	-> 1655
/*     */     //   #218	-> 1681
/*     */     //   #219	-> 1744
/*     */     //   #221	-> 1777
/*     */     //   #222	-> 1784
/*     */     //   #223	-> 1789
/*     */     //   #224	-> 1794
/*     */     //   #226	-> 1795
/*     */     //   #227	-> 1795
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   640	23	15	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   643	20	16	$i$a$-filter-SuperChestStealer$performStealer$1	I
/*     */     //   633	43	14	element$iv$iv	Ljava/lang/Object;
/*     */     //   602	79	10	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   602	79	11	destination$iv$iv	Ljava/util/Collection;
/*     */     //   605	76	12	$i$f$filterTo	I
/*     */     //   583	101	8	$this$filter$iv	Ljava/lang/Iterable;
/*     */     //   586	98	9	$i$f$filter	I
/*     */     //   757	26	15	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   760	23	16	$i$a$-map-SuperChestStealer$performStealer$2	I
/*     */     //   746	49	14	item$iv$iv	Ljava/lang/Object;
/*     */     //   715	85	10	$this$mapTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   715	85	11	destination$iv$iv	Ljava/util/Collection;
/*     */     //   718	82	12	$i$f$mapTo	I
/*     */     //   689	114	8	$this$map$iv	Ljava/lang/Iterable;
/*     */     //   692	111	9	$i$f$map	I
/*     */     //   424	489	7	slot	Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   395	521	5	slotIndex	I
/*     */     //   948	83	6	slot	Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   934	97	5	randomSlot	I
/*     */     //   369	662	4	items	Ljava/util/List;
/*     */     //   354	678	3	noLoop	Z
/*     */     //   1314	23	13	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1317	20	14	$i$a$-filter-SuperChestStealer$performStealer$3	I
/*     */     //   1307	43	12	element$iv$iv	Ljava/lang/Object;
/*     */     //   1276	79	8	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   1276	79	9	destination$iv$iv	Ljava/util/Collection;
/*     */     //   1279	76	10	$i$f$filterTo	I
/*     */     //   1257	101	6	$this$filter$iv	Ljava/lang/Iterable;
/*     */     //   1260	98	7	$i$f$filter	I
/*     */     //   1431	26	13	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1434	23	14	$i$a$-map-SuperChestStealer$performStealer$4	I
/*     */     //   1420	49	12	item$iv$iv	Ljava/lang/Object;
/*     */     //   1389	85	8	$this$mapTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   1389	85	9	destination$iv$iv	Ljava/util/Collection;
/*     */     //   1392	82	10	$i$f$mapTo	I
/*     */     //   1363	114	6	$this$map$iv	Ljava/lang/Iterable;
/*     */     //   1366	111	7	$i$f$map	I
/*     */     //   1084	505	5	slot	Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   1056	536	3	slotIndex	I
/*     */     //   293	1503	2	inventoryCleaner	Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;
/*     */     //   0	1796	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer;
/*     */     //   0	1796	1	screen	Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   private final void onPacket(PacketEvent event) {
/*     */     IPacket packet = event.getPacket();
/*     */     if (MinecraftInstance.classProvider.isSPacketWindowItems(packet))
/*     */       this.contentReceived = packet.asSPacketWindowItems().getWindowId(); 
/*     */   }
/*     */   
/*     */   private final void move(IGuiChest screen, ISlot slot) {
/*     */     screen.handleMouseClick(slot, slot.getSlotNumber(), 0, 1);
/*     */     this.delayTimer.reset();
/*     */     this.nextDelay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*     */   }
/*     */   
/*     */   private final boolean isEmpty(IGuiChest chest) {
/*     */     // Byte code:
/*     */     //   0: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   3: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   6: ldc_w net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner
/*     */     //   9: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   12: dup
/*     */     //   13: ifnonnull -> 27
/*     */     //   16: new kotlin/TypeCastException
/*     */     //   19: dup
/*     */     //   20: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.player.InventoryCleaner'
/*     */     //   23: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   26: athrow
/*     */     //   27: checkcast net/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner
/*     */     //   30: astore_2
/*     */     //   31: iconst_0
/*     */     //   32: istore_3
/*     */     //   33: aload_1
/*     */     //   34: invokeinterface getInventoryRows : ()I
/*     */     //   39: bipush #9
/*     */     //   41: imul
/*     */     //   42: istore #4
/*     */     //   44: iload_3
/*     */     //   45: iload #4
/*     */     //   47: if_icmpge -> 558
/*     */     //   50: aload_1
/*     */     //   51: invokeinterface asGuiChest : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */     //   56: invokeinterface getInventorySlots : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   61: dup
/*     */     //   62: ifnull -> 74
/*     */     //   65: iload_3
/*     */     //   66: invokeinterface getSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   71: goto -> 76
/*     */     //   74: pop
/*     */     //   75: aconst_null
/*     */     //   76: astore #5
/*     */     //   78: aload #5
/*     */     //   80: dup
/*     */     //   81: ifnull -> 92
/*     */     //   84: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   89: goto -> 94
/*     */     //   92: pop
/*     */     //   93: aconst_null
/*     */     //   94: dup
/*     */     //   95: ifnonnull -> 101
/*     */     //   98: invokestatic throwNpe : ()V
/*     */     //   101: ifnull -> 552
/*     */     //   104: aload_0
/*     */     //   105: getfield onlyItemsValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   108: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   111: checkcast java/lang/Boolean
/*     */     //   114: invokevirtual booleanValue : ()Z
/*     */     //   117: ifeq -> 154
/*     */     //   120: aload #5
/*     */     //   122: dup
/*     */     //   123: ifnull -> 134
/*     */     //   126: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   131: goto -> 136
/*     */     //   134: pop
/*     */     //   135: aconst_null
/*     */     //   136: dup
/*     */     //   137: ifnonnull -> 143
/*     */     //   140: invokestatic throwNpe : ()V
/*     */     //   143: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   148: instanceof net/minecraft/item/ItemBlock
/*     */     //   151: ifne -> 552
/*     */     //   154: aload_0
/*     */     //   155: getfield noDuplicateValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   158: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   161: checkcast java/lang/Boolean
/*     */     //   164: invokevirtual booleanValue : ()Z
/*     */     //   167: ifeq -> 512
/*     */     //   170: aload #5
/*     */     //   172: dup
/*     */     //   173: ifnull -> 184
/*     */     //   176: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   181: goto -> 186
/*     */     //   184: pop
/*     */     //   185: aconst_null
/*     */     //   186: dup
/*     */     //   187: ifnonnull -> 193
/*     */     //   190: invokestatic throwNpe : ()V
/*     */     //   193: invokeinterface getStackSize : ()I
/*     */     //   198: iconst_1
/*     */     //   199: if_icmpgt -> 512
/*     */     //   202: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   205: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   210: dup
/*     */     //   211: ifnull -> 497
/*     */     //   214: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   219: dup
/*     */     //   220: ifnull -> 497
/*     */     //   223: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   228: dup
/*     */     //   229: ifnull -> 497
/*     */     //   232: checkcast java/lang/Iterable
/*     */     //   235: astore #6
/*     */     //   237: iconst_0
/*     */     //   238: istore #7
/*     */     //   240: aload #6
/*     */     //   242: astore #8
/*     */     //   244: new java/util/ArrayList
/*     */     //   247: dup
/*     */     //   248: invokespecial <init> : ()V
/*     */     //   251: checkcast java/util/Collection
/*     */     //   254: astore #9
/*     */     //   256: iconst_0
/*     */     //   257: istore #10
/*     */     //   259: aload #8
/*     */     //   261: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   266: astore #11
/*     */     //   268: aload #11
/*     */     //   270: invokeinterface hasNext : ()Z
/*     */     //   275: ifeq -> 333
/*     */     //   278: aload #11
/*     */     //   280: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   285: astore #12
/*     */     //   287: aload #12
/*     */     //   289: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   292: astore #13
/*     */     //   294: iconst_0
/*     */     //   295: istore #14
/*     */     //   297: aload #13
/*     */     //   299: ifnull -> 316
/*     */     //   302: aload #13
/*     */     //   304: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   309: ifnull -> 316
/*     */     //   312: iconst_1
/*     */     //   313: goto -> 317
/*     */     //   316: iconst_0
/*     */     //   317: ifeq -> 268
/*     */     //   320: aload #9
/*     */     //   322: aload #12
/*     */     //   324: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   329: pop
/*     */     //   330: goto -> 268
/*     */     //   333: aload #9
/*     */     //   335: checkcast java/util/List
/*     */     //   338: checkcast java/lang/Iterable
/*     */     //   341: astore #6
/*     */     //   343: iconst_0
/*     */     //   344: istore #7
/*     */     //   346: aload #6
/*     */     //   348: astore #8
/*     */     //   350: new java/util/ArrayList
/*     */     //   353: dup
/*     */     //   354: aload #6
/*     */     //   356: bipush #10
/*     */     //   358: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
/*     */     //   361: invokespecial <init> : (I)V
/*     */     //   364: checkcast java/util/Collection
/*     */     //   367: astore #9
/*     */     //   369: iconst_0
/*     */     //   370: istore #10
/*     */     //   372: aload #8
/*     */     //   374: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   379: astore #11
/*     */     //   381: aload #11
/*     */     //   383: invokeinterface hasNext : ()Z
/*     */     //   388: ifeq -> 452
/*     */     //   391: aload #11
/*     */     //   393: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   398: astore #12
/*     */     //   400: aload #9
/*     */     //   402: aload #12
/*     */     //   404: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   407: astore #13
/*     */     //   409: astore #15
/*     */     //   411: iconst_0
/*     */     //   412: istore #14
/*     */     //   414: aload #13
/*     */     //   416: dup
/*     */     //   417: ifnull -> 428
/*     */     //   420: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   425: goto -> 430
/*     */     //   428: pop
/*     */     //   429: aconst_null
/*     */     //   430: dup
/*     */     //   431: ifnonnull -> 437
/*     */     //   434: invokestatic throwNpe : ()V
/*     */     //   437: astore #16
/*     */     //   439: aload #15
/*     */     //   441: aload #16
/*     */     //   443: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   448: pop
/*     */     //   449: goto -> 381
/*     */     //   452: aload #9
/*     */     //   454: checkcast java/util/List
/*     */     //   457: checkcast java/lang/Iterable
/*     */     //   460: aload #5
/*     */     //   462: dup
/*     */     //   463: ifnull -> 474
/*     */     //   466: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   471: goto -> 476
/*     */     //   474: pop
/*     */     //   475: aconst_null
/*     */     //   476: dup
/*     */     //   477: ifnonnull -> 483
/*     */     //   480: invokestatic throwNpe : ()V
/*     */     //   483: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   488: invokestatic contains : (Ljava/lang/Iterable;Ljava/lang/Object;)Z
/*     */     //   491: invokestatic valueOf : (Z)Ljava/lang/Boolean;
/*     */     //   494: goto -> 499
/*     */     //   497: pop
/*     */     //   498: aconst_null
/*     */     //   499: dup
/*     */     //   500: ifnonnull -> 506
/*     */     //   503: invokestatic throwNpe : ()V
/*     */     //   506: invokevirtual booleanValue : ()Z
/*     */     //   509: ifne -> 552
/*     */     //   512: aload_2
/*     */     //   513: invokevirtual getState : ()Z
/*     */     //   516: ifeq -> 550
/*     */     //   519: aload_2
/*     */     //   520: aload #5
/*     */     //   522: dup
/*     */     //   523: ifnull -> 534
/*     */     //   526: invokeinterface getStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   531: goto -> 536
/*     */     //   534: pop
/*     */     //   535: aconst_null
/*     */     //   536: dup
/*     */     //   537: ifnonnull -> 543
/*     */     //   540: invokestatic throwNpe : ()V
/*     */     //   543: iconst_m1
/*     */     //   544: invokevirtual isUseful : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)Z
/*     */     //   547: ifeq -> 552
/*     */     //   550: iconst_0
/*     */     //   551: ireturn
/*     */     //   552: iinc #3, 1
/*     */     //   555: goto -> 44
/*     */     //   558: iconst_1
/*     */     //   559: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #244	-> 0
/*     */     //   #246	-> 31
/*     */     //   #247	-> 50
/*     */     //   #249	-> 78
/*     */     //   #250	-> 78
/*     */     //   #251	-> 78
/*     */     //   #249	-> 104
/*     */     //   #277	-> 240
/*     */     //   #278	-> 259
/*     */     //   #249	-> 297
/*     */     //   #279	-> 333
/*     */     //   #250	-> 343
/*     */     //   #280	-> 346
/*     */     //   #281	-> 372
/*     */     //   #282	-> 400
/*     */     //   #250	-> 414
/*     */     //   #281	-> 449
/*     */     //   #283	-> 452
/*     */     //   #251	-> 460
/*     */     //   #252	-> 550
/*     */     //   #246	-> 552
/*     */     //   #255	-> 558
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   294	23	13	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   297	20	14	$i$a$-filter-SuperChestStealer$isEmpty$1	I
/*     */     //   287	43	12	element$iv$iv	Ljava/lang/Object;
/*     */     //   256	79	8	$this$filterTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   256	79	9	destination$iv$iv	Ljava/util/Collection;
/*     */     //   259	76	10	$i$f$filterTo	I
/*     */     //   237	101	6	$this$filter$iv	Ljava/lang/Iterable;
/*     */     //   240	98	7	$i$f$filter	I
/*     */     //   411	26	13	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   414	23	14	$i$a$-map-SuperChestStealer$isEmpty$2	I
/*     */     //   400	49	12	item$iv$iv	Ljava/lang/Object;
/*     */     //   369	85	8	$this$mapTo$iv$iv	Ljava/lang/Iterable;
/*     */     //   369	85	9	destination$iv$iv	Ljava/util/Collection;
/*     */     //   372	82	10	$i$f$mapTo	I
/*     */     //   343	114	6	$this$map$iv	Ljava/lang/Iterable;
/*     */     //   346	111	7	$i$f$map	I
/*     */     //   78	474	5	slot	Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*     */     //   50	505	3	i	I
/*     */     //   31	529	2	inventoryCleaner	Lnet/ccbluex/liquidbounce/features/module/modules/player/InventoryCleaner;
/*     */     //   0	560	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer;
/*     */     //   0	560	1	chest	Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiChest;
/*     */   }
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
/*     */     //   #259	-> 0
/*     */     //   #284	-> 36
/*     */     //   #285	-> 59
/*     */     //   #259	-> 93
/*     */     //   #286	-> 110
/*     */     //   #259	-> 129
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   90	13	5	it	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   93	10	6	$i$a$-none-SuperChestStealer$fullInventory$1	I
/*     */     //   83	27	4	element$iv	Ljava/lang/Object;
/*     */     //   34	77	1	$this$none$iv	Ljava/lang/Iterable;
/*     */     //   36	75	2	$i$f$none	I
/*     */     //   0	130	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/retreat/SuperChestStealer;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\SuperChestStealer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */