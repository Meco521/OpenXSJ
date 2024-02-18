/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.IntFunction;
/*     */ import java.util.function.IntPredicate;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.NotImplementedError;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.text.StringsKt;
/*     */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl;
/*     */ import net.ccbluex.liquidbounce.injection.backend.ItemStackImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*     */ import net.ccbluex.liquidbounce.utils.item.ArmorComparator;
/*     */ import net.ccbluex.liquidbounce.utils.item.ArmorPiece;
/*     */ import net.ccbluex.liquidbounce.utils.item.ItemUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketClickWindow;
/*     */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
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
/*     */ @ModuleInfo(name = "InvManager", description = "Skid 凡哥", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000v\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\021\n\002\020\016\n\002\b\002\n\002\020\013\n\002\b\006\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020$\n\002\b\006\n\002\020\002\n\000\n\002\030\002\n\002\b\004\b\007\030\000 <2\0020\001:\001<B\005¢\006\002\020\002J\020\020$\032\0020%2\006\020&\032\0020'H\002J!\020(\032\004\030\0010)2\006\020*\032\0020)2\b\020+\032\004\030\0010,H\002¢\006\002\020-J\026\020.\032\0020\0202\006\020&\032\0020,2\006\020/\032\0020)J(\020\013\032\016\022\004\022\0020)\022\004\022\0020,002\b\b\002\0201\032\0020)2\b\b\002\0202\032\0020)H\002J\030\0203\032\0020\0202\006\0204\032\0020)2\006\0205\032\0020\020H\002J\020\0206\032\002072\006\0208\032\00209H\007J\b\020:\032\00207H\002J\020\020;\032\0020\r2\006\020*\032\0020)H\002R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\026\020\013\032\b\022\004\022\0020\r0\fX\004¢\006\004\n\002\020\016R\016\020\017\032\0020\020X\016¢\006\002\n\000R\016\020\021\032\0020\nX\004¢\006\002\n\000R\016\020\022\032\0020\nX\004¢\006\002\n\000R\016\020\023\032\0020\006X\004¢\006\002\n\000R\016\020\024\032\0020\006X\004¢\006\002\n\000R\016\020\025\032\0020\006X\004¢\006\002\n\000R\024\020\026\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\030\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\031\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\032\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\033\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\034\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\035\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\036\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\024\020\037\032\b\022\004\022\0020\r0\027X\004¢\006\002\n\000R\016\020 \032\0020\006X\004¢\006\002\n\000R\016\020!\032\0020\"X\004¢\006\002\n\000R\016\020#\032\0020\006X\004¢\006\002\n\000¨\006="}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delay", "", "ignoreChainArmorValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "ignoreVehiclesValue", "invOpenValue", "itemDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "items", "", "", "[Ljava/lang/String;", "locked", "", "maxDelayValue", "minDelayValue", "noMoveValue", "randomSlotValue", "simulateInventory", "sortSlot1Value", "Lnet/ccbluex/liquidbounce/value/Value;", "sortSlot2Value", "sortSlot3Value", "sortSlot4Value", "sortSlot5Value", "sortSlot6Value", "sortSlot7Value", "sortSlot8Value", "sortSlot9Value", "sortValue", "swapArmorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "swingValue", "createUseItemPacket", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "itemStack", "Lnet/ccbluex/liquidbounce/api/enums/WEnumHand;", "findBetterItem", "", "targetSlot", "slotStack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "(ILnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Ljava/lang/Integer;", "isUseful", "slot", "", "start", "end", "move", "item", "isArmorSlot", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "sortHotbar", "type", "Companion", "XSJClient"})
/*     */ public final class InvManager
/*     */   extends Module
/*     */ {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\030\002\n\000\n\002\020\b\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;", "i", "", "apply"})
/*     */   static final class InvManager$onUpdate$armorPieces$2<R>
/*     */     implements IntFunction<ArmorPiece>
/*     */   {
/*     */     public static final InvManager$onUpdate$armorPieces$2 INSTANCE = new InvManager$onUpdate$armorPieces$2();
/*     */     
/*     */     @NotNull
/*     */     public final ArmorPiece apply(int i) {
/*  91 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return new ArmorPiece(MinecraftInstance.mc.getThePlayer().getInventory().getStackInSlot(
/*  92 */             i), 
/*  93 */           i); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\b\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "obj", "Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;", "apply"})
/*     */   static final class InvManager$onUpdate$armorPieces$3<T, R> implements Function<T, K> { public static final InvManager$onUpdate$armorPieces$3 INSTANCE = new InvManager$onUpdate$armorPieces$3(); public final int apply(@Nullable ArmorPiece obj) {
/*  95 */       if (obj == null) Intrinsics.throwNpe();  return obj.getArmorType();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "invoke"})
/*     */   static final class InvManager$findBetterItem$currentTypeChecker$1
/*     */     extends Lambda
/*     */     implements Function1<IItem, Boolean>
/*     */   {
/*     */     public static final InvManager$findBetterItem$currentTypeChecker$1 INSTANCE = new InvManager$findBetterItem$currentTypeChecker$1();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean invoke(@Nullable IItem item) {
/* 276 */       return MinecraftInstance.classProvider.isItemSword(item);
/* 277 */     } InvManager$findBetterItem$currentTypeChecker$1() { super(1); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "obj", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "invoke"}) static final class InvManager$findBetterItem$currentTypeChecker$2 extends Lambda implements Function1<IItem, Boolean> { public static final InvManager$findBetterItem$currentTypeChecker$2 INSTANCE = new InvManager$findBetterItem$currentTypeChecker$2(); public final boolean invoke(@Nullable IItem obj) { return MinecraftInstance.classProvider.isItemPickaxe(obj); } InvManager$findBetterItem$currentTypeChecker$2() { super(1); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "obj", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "invoke"}) static final class InvManager$findBetterItem$currentTypeChecker$3 extends Lambda implements Function1<IItem, Boolean> { public static final InvManager$findBetterItem$currentTypeChecker$3 INSTANCE = new InvManager$findBetterItem$currentTypeChecker$3();
/* 278 */     public final boolean invoke(@Nullable IItem obj) { return MinecraftInstance.classProvider.isItemAxe(obj); }
/*     */ 
/*     */     
/*     */     InvManager$findBetterItem$currentTypeChecker$3() {
/*     */       super(1);
/*     */     } }
/*     */ 
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot1Value$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot1Value$1() {
/*     */       super(0);
/*     */     } }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot2Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot2Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot3Value$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot3Value$1() {
/*     */       super(0);
/*     */     } }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot4Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot4Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot5Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot5Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot6Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot6Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot7Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot7Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot8Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot8Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class InvManager$sortSlot9Value$1 extends Lambda implements Function0<Boolean> {
/*     */     public final boolean invoke() {
/*     */       return ((Boolean)InvManager.this.sortValue.get()).booleanValue();
/*     */     }
/*     */     
/*     */     InvManager$sortSlot9Value$1() {
/*     */       super(0);
/*     */     }
/*     */   }
/*     */   
/*     */   private final IntegerValue maxDelayValue = new InvManager$maxDelayValue$1("MaxDelay", 600, 0, 1000);
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/InvManager$maxDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*     */   public static final class InvManager$maxDelayValue$1 extends IntegerValue {
/*     */     InvManager$maxDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) {
/*     */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*     */     }
/*     */     
/*     */     protected void onChanged(int oldValue, int newValue) {
/*     */       int minDelay = ((Number)InvManager.this.minDelayValue.get()).intValue();
/*     */       if (minDelay > newValue)
/*     */         set(Integer.valueOf(minDelay)); 
/*     */     }
/*     */   }
/*     */   
/*     */   private final IntegerValue minDelayValue = new InvManager$minDelayValue$1("MinDelay", 400, 0, 1000);
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\024¨\006\007"}, d2 = {"net/ccbluex/liquidbounce/features/module/modules/player/InvManager$minDelayValue$1", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "onChanged", "", "oldValue", "", "newValue", "XSJClient"})
/*     */   public static final class InvManager$minDelayValue$1 extends IntegerValue {
/*     */     InvManager$minDelayValue$1(String $super_call_param$1, int $super_call_param$2, int $super_call_param$3, int $super_call_param$4) {
/*     */       super($super_call_param$1, $super_call_param$2, $super_call_param$3, $super_call_param$4);
/*     */     }
/*     */     
/*     */     protected void onChanged(int oldValue, int newValue) {
/*     */       int maxDelay = ((Number)InvManager.this.maxDelayValue.get()).intValue();
/*     */       if (maxDelay < newValue)
/*     */         set(Integer.valueOf(maxDelay)); 
/*     */     }
/*     */   }
/*     */   
/*     */   private final BoolValue invOpenValue = new BoolValue("InvOpen", false);
/*     */   private final BoolValue simulateInventory = new BoolValue("SimulateInventory", true);
/*     */   private final BoolValue noMoveValue = new BoolValue("NoMove", false);
/*     */   private final BoolValue swingValue = new BoolValue("SwingItem", false);
/*     */   private final BoolValue ignoreChainArmorValue = new BoolValue("HYT-NoChainArmor", false);
/*     */   private final BoolValue ignoreVehiclesValue = new BoolValue("IgnoreVehicles", false);
/*     */   private final BoolValue randomSlotValue = new BoolValue("RandomSlot", false);
/*     */   
/* 419 */   private final Map<Integer, IItemStack> items(int start, int end) { int i = 0; Map<Object, Object> items = new LinkedHashMap<>();
/*     */     
/* 421 */     i = end - 1; int j = start; if (i >= j)
/* 422 */       while (true) { if (MinecraftInstance.mc.getThePlayer() != null && MinecraftInstance.mc.getThePlayer().getInventoryContainer() != null && MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i) != null && MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack() != null) { IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*     */           
/* 424 */           if (ItemUtils.isStackEmpty(itemStack))
/*     */             continue; 
/* 426 */           int k = i; if (36 > k) { 44; } else if (44 >= k && StringsKt.equals(type(i), "Ignore", true))
/*     */           { continue; }
/* 428 */            if (System.currentTimeMillis() - itemStack.getItemDelay() >= ((Number)this.itemDelayValue.get()).longValue()) items.put(Integer.valueOf(i), itemStack);  continue; }
/*     */          MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(i).getStack(); continue; if (i != j) { i--; continue; }
/*     */          break; }
/* 431 */         return (Map)items; }
/*     */   private final BoolValue sortValue = new BoolValue("Sort", true);
/*     */   private final IntegerValue itemDelayValue = new IntegerValue("ItemDelay", 0, 0, 5000);
/*     */   private final ListValue swapArmorModeValue = new ListValue("SwapMode", new String[] { "Packet", "WindowClick" }, "WindowClick");
/*     */   private final String[] items = new String[] { "None", "Ignore", "Sword", "Bow", "Pickaxe", "Axe", "Block", "Water", "Gapple", "Pearl" };
/*     */   private final Value<String> sortSlot1Value = (new ListValue("SortSlot-1", this.items, "Sword")).displayable(new InvManager$sortSlot1Value$1()); private final Value<String> sortSlot2Value = (new ListValue("SortSlot-2", this.items, "Block")).displayable(new InvManager$sortSlot2Value$1()); private final Value<String> sortSlot3Value = (new ListValue("SortSlot-3", this.items, "Bow")).displayable(new InvManager$sortSlot3Value$1()); private final Value<String> sortSlot4Value = (new ListValue("SortSlot-4", this.items, "Gapple")).displayable(new InvManager$sortSlot4Value$1()); private final Value<String> sortSlot5Value = (new ListValue("SortSlot-5", this.items, "None")).displayable(new InvManager$sortSlot5Value$1()); private final Value<String> sortSlot6Value = (new ListValue("SortSlot-6", this.items, "None")).displayable(new InvManager$sortSlot6Value$1()); private final Value<String> sortSlot7Value = (new ListValue("SortSlot-7", this.items, "None")).displayable(new InvManager$sortSlot7Value$1()); private final Value<String> sortSlot8Value = (new ListValue("SortSlot-8", this.items, "None")).displayable(new InvManager$sortSlot8Value$1()); private final Value<String> sortSlot9Value = (new ListValue("SortSlot-9", this.items, "None")).displayable(new InvManager$sortSlot9Value$1()); private long delay; private boolean locked; @NotNull private static final ArmorComparator ARMOR_COMPARATOR; @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { // Byte code:
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
/*     */     //   34: ifeq -> 124
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
/*     */     //   69: ifne -> 124
/*     */     //   72: aload_0
/*     */     //   73: getfield noMoveValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   76: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   79: checkcast java/lang/Boolean
/*     */     //   82: invokevirtual booleanValue : ()Z
/*     */     //   85: ifeq -> 94
/*     */     //   88: invokestatic isMoving : ()Z
/*     */     //   91: ifne -> 124
/*     */     //   94: aload_2
/*     */     //   95: invokeinterface getOpenContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   100: ifnull -> 125
/*     */     //   103: aload_2
/*     */     //   104: invokeinterface getOpenContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   109: dup
/*     */     //   110: ifnonnull -> 116
/*     */     //   113: invokestatic throwNpe : ()V
/*     */     //   116: invokeinterface getWindowId : ()I
/*     */     //   121: ifeq -> 125
/*     */     //   124: return
/*     */     //   125: getstatic net/ccbluex/liquidbounce/utils/InventoryUtils.CLICK_TIMER : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   128: aload_0
/*     */     //   129: getfield delay : J
/*     */     //   132: invokevirtual hasTimePassed : (J)Z
/*     */     //   135: ifeq -> 1021
/*     */     //   138: iconst_0
/*     */     //   139: bipush #36
/*     */     //   141: invokestatic range : (II)Ljava/util/stream/IntStream;
/*     */     //   144: new net/ccbluex/liquidbounce/features/module/modules/player/InvManager$onUpdate$armorPieces$1
/*     */     //   147: dup
/*     */     //   148: aload_0
/*     */     //   149: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;)V
/*     */     //   152: checkcast java/util/function/IntPredicate
/*     */     //   155: invokeinterface filter : (Ljava/util/function/IntPredicate;)Ljava/util/stream/IntStream;
/*     */     //   160: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager$onUpdate$armorPieces$2.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager$onUpdate$armorPieces$2;
/*     */     //   163: checkcast java/util/function/IntFunction
/*     */     //   166: invokeinterface mapToObj : (Ljava/util/function/IntFunction;)Ljava/util/stream/Stream;
/*     */     //   171: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager$onUpdate$armorPieces$3.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager$onUpdate$armorPieces$3;
/*     */     //   174: checkcast java/util/function/Function
/*     */     //   177: invokestatic groupingBy : (Ljava/util/function/Function;)Ljava/util/stream/Collector;
/*     */     //   180: invokeinterface collect : (Ljava/util/stream/Collector;)Ljava/lang/Object;
/*     */     //   185: checkcast java/util/Map
/*     */     //   188: astore_3
/*     */     //   189: iconst_4
/*     */     //   190: anewarray net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   193: astore #4
/*     */     //   195: aload_3
/*     */     //   196: dup
/*     */     //   197: ldc_w 'armorPieces'
/*     */     //   200: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   203: astore #7
/*     */     //   205: iconst_0
/*     */     //   206: istore #8
/*     */     //   208: aload #7
/*     */     //   210: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   215: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   220: astore #6
/*     */     //   222: aload #6
/*     */     //   224: invokeinterface hasNext : ()Z
/*     */     //   229: ifeq -> 325
/*     */     //   232: aload #6
/*     */     //   234: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   239: checkcast java/util/Map$Entry
/*     */     //   242: astore #5
/*     */     //   244: aload #5
/*     */     //   246: astore #9
/*     */     //   248: iconst_0
/*     */     //   249: istore #10
/*     */     //   251: aload #9
/*     */     //   253: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   258: checkcast java/lang/Integer
/*     */     //   261: astore #7
/*     */     //   263: aload #5
/*     */     //   265: astore #9
/*     */     //   267: iconst_0
/*     */     //   268: istore #10
/*     */     //   270: aload #9
/*     */     //   272: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   277: checkcast java/util/List
/*     */     //   280: astore #8
/*     */     //   282: aload #4
/*     */     //   284: aload #7
/*     */     //   286: dup
/*     */     //   287: ldc_w 'key'
/*     */     //   290: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   293: invokevirtual intValue : ()I
/*     */     //   296: aload #8
/*     */     //   298: invokeinterface stream : ()Ljava/util/stream/Stream;
/*     */     //   303: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager.ARMOR_COMPARATOR : Lnet/ccbluex/liquidbounce/utils/item/ArmorComparator;
/*     */     //   306: checkcast java/util/Comparator
/*     */     //   309: invokeinterface max : (Ljava/util/Comparator;)Ljava/util/Optional;
/*     */     //   314: aconst_null
/*     */     //   315: invokevirtual orElse : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   318: checkcast net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   321: aastore
/*     */     //   322: goto -> 222
/*     */     //   325: iconst_0
/*     */     //   326: istore #5
/*     */     //   328: iconst_3
/*     */     //   329: istore #6
/*     */     //   331: iload #5
/*     */     //   333: iload #6
/*     */     //   335: if_icmpgt -> 604
/*     */     //   338: aload #4
/*     */     //   340: iload #5
/*     */     //   342: aaload
/*     */     //   343: dup
/*     */     //   344: ifnull -> 350
/*     */     //   347: goto -> 354
/*     */     //   350: pop
/*     */     //   351: goto -> 598
/*     */     //   354: astore #7
/*     */     //   356: aload_0
/*     */     //   357: getfield ignoreChainArmorValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   360: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   363: checkcast java/lang/Boolean
/*     */     //   366: invokevirtual booleanValue : ()Z
/*     */     //   369: ifeq -> 410
/*     */     //   372: aload #7
/*     */     //   374: invokevirtual getItemStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   377: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   382: ldc_w 'item.helmetChain'
/*     */     //   385: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   388: ifne -> 410
/*     */     //   391: aload #7
/*     */     //   393: invokevirtual getItemStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   396: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   401: ldc_w 'item.leggingsChain'
/*     */     //   404: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   407: ifeq -> 426
/*     */     //   410: aload_0
/*     */     //   411: getfield ignoreChainArmorValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   414: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   417: checkcast java/lang/Boolean
/*     */     //   420: invokevirtual booleanValue : ()Z
/*     */     //   423: ifne -> 598
/*     */     //   426: iconst_3
/*     */     //   427: iload #5
/*     */     //   429: isub
/*     */     //   430: istore #8
/*     */     //   432: new net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   435: dup
/*     */     //   436: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   439: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   444: dup
/*     */     //   445: ifnonnull -> 451
/*     */     //   448: invokestatic throwNpe : ()V
/*     */     //   451: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   456: iload #8
/*     */     //   458: invokeinterface armorItemInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   463: iconst_m1
/*     */     //   464: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)V
/*     */     //   467: astore #9
/*     */     //   469: aload #9
/*     */     //   471: invokevirtual getItemStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   474: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   477: ifne -> 514
/*     */     //   480: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   483: aload #9
/*     */     //   485: invokevirtual getItemStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   488: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   493: invokeinterface isItemArmor : (Ljava/lang/Object;)Z
/*     */     //   498: ifeq -> 514
/*     */     //   501: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager.ARMOR_COMPARATOR : Lnet/ccbluex/liquidbounce/utils/item/ArmorComparator;
/*     */     //   504: aload #9
/*     */     //   506: aload #7
/*     */     //   508: invokevirtual compare : (Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;)I
/*     */     //   511: ifge -> 598
/*     */     //   514: aload #9
/*     */     //   516: invokevirtual getItemStack : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   519: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   522: ifne -> 546
/*     */     //   525: aload_0
/*     */     //   526: bipush #8
/*     */     //   528: iconst_3
/*     */     //   529: iload #8
/*     */     //   531: isub
/*     */     //   532: isub
/*     */     //   533: iconst_1
/*     */     //   534: invokespecial move : (IZ)Z
/*     */     //   537: ifeq -> 546
/*     */     //   540: aload_0
/*     */     //   541: iconst_1
/*     */     //   542: putfield locked : Z
/*     */     //   545: return
/*     */     //   546: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   549: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   554: dup
/*     */     //   555: ifnonnull -> 561
/*     */     //   558: invokestatic throwNpe : ()V
/*     */     //   561: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   566: iload #8
/*     */     //   568: invokeinterface armorItemInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   573: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   576: ifeq -> 598
/*     */     //   579: aload_0
/*     */     //   580: aload #7
/*     */     //   582: invokevirtual getSlot : ()I
/*     */     //   585: iconst_0
/*     */     //   586: invokespecial move : (IZ)Z
/*     */     //   589: ifeq -> 598
/*     */     //   592: aload_0
/*     */     //   593: iconst_1
/*     */     //   594: putfield locked : Z
/*     */     //   597: return
/*     */     //   598: iinc #5, 1
/*     */     //   601: goto -> 331
/*     */     //   604: aload_0
/*     */     //   605: iconst_0
/*     */     //   606: putfield locked : Z
/*     */     //   609: aload_0
/*     */     //   610: getfield sortValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   613: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   616: checkcast java/lang/Boolean
/*     */     //   619: invokevirtual booleanValue : ()Z
/*     */     //   622: ifeq -> 629
/*     */     //   625: aload_0
/*     */     //   626: invokespecial sortHotbar : ()V
/*     */     //   629: aload_0
/*     */     //   630: bipush #9
/*     */     //   632: bipush #45
/*     */     //   634: invokespecial items : (II)Ljava/util/Map;
/*     */     //   637: astore #6
/*     */     //   639: iconst_0
/*     */     //   640: istore #7
/*     */     //   642: aload #6
/*     */     //   644: astore #8
/*     */     //   646: new java/util/LinkedHashMap
/*     */     //   649: dup
/*     */     //   650: invokespecial <init> : ()V
/*     */     //   653: checkcast java/util/Map
/*     */     //   656: astore #9
/*     */     //   658: iconst_0
/*     */     //   659: istore #10
/*     */     //   661: aload #8
/*     */     //   663: astore #11
/*     */     //   665: iconst_0
/*     */     //   666: istore #12
/*     */     //   668: aload #11
/*     */     //   670: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   675: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   680: astore #13
/*     */     //   682: aload #13
/*     */     //   684: invokeinterface hasNext : ()Z
/*     */     //   689: ifeq -> 774
/*     */     //   692: aload #13
/*     */     //   694: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   699: checkcast java/util/Map$Entry
/*     */     //   702: astore #14
/*     */     //   704: aload #14
/*     */     //   706: astore #15
/*     */     //   708: iconst_0
/*     */     //   709: istore #16
/*     */     //   711: aload_0
/*     */     //   712: aload #15
/*     */     //   714: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   719: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   722: aload #15
/*     */     //   724: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   729: checkcast java/lang/Number
/*     */     //   732: invokevirtual intValue : ()I
/*     */     //   735: invokevirtual isUseful : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)Z
/*     */     //   738: ifne -> 745
/*     */     //   741: iconst_1
/*     */     //   742: goto -> 746
/*     */     //   745: iconst_0
/*     */     //   746: ifeq -> 771
/*     */     //   749: aload #9
/*     */     //   751: aload #14
/*     */     //   753: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   758: aload #14
/*     */     //   760: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   765: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   770: pop
/*     */     //   771: goto -> 682
/*     */     //   774: aload #9
/*     */     //   776: nop
/*     */     //   777: invokeinterface keySet : ()Ljava/util/Set;
/*     */     //   782: checkcast java/util/Collection
/*     */     //   785: invokestatic toMutableList : (Ljava/util/Collection;)Ljava/util/List;
/*     */     //   788: astore #5
/*     */     //   790: aload_0
/*     */     //   791: getfield randomSlotValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   794: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   797: checkcast java/lang/Boolean
/*     */     //   800: invokevirtual booleanValue : ()Z
/*     */     //   803: ifeq -> 818
/*     */     //   806: aload #5
/*     */     //   808: astore #6
/*     */     //   810: iconst_0
/*     */     //   811: istore #7
/*     */     //   813: aload #6
/*     */     //   815: invokestatic shuffle : (Ljava/util/List;)V
/*     */     //   818: aload #5
/*     */     //   820: invokestatic firstOrNull : (Ljava/util/List;)Ljava/lang/Object;
/*     */     //   823: checkcast java/lang/Integer
/*     */     //   826: dup
/*     */     //   827: ifnull -> 836
/*     */     //   830: invokevirtual intValue : ()I
/*     */     //   833: goto -> 840
/*     */     //   836: pop
/*     */     //   837: goto -> 1021
/*     */     //   840: istore #6
/*     */     //   842: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   845: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   848: invokeinterface getCurrentScreen : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IGuiScreen;
/*     */     //   853: invokeinterface isGuiInventory : (Ljava/lang/Object;)Z
/*     */     //   858: ifne -> 881
/*     */     //   861: aload_0
/*     */     //   862: getfield simulateInventory : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   865: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   868: checkcast java/lang/Boolean
/*     */     //   871: invokevirtual booleanValue : ()Z
/*     */     //   874: ifeq -> 881
/*     */     //   877: iconst_1
/*     */     //   878: goto -> 882
/*     */     //   881: iconst_0
/*     */     //   882: istore #7
/*     */     //   884: aload_0
/*     */     //   885: getfield swingValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   888: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   891: checkcast java/lang/Boolean
/*     */     //   894: invokevirtual booleanValue : ()Z
/*     */     //   897: ifeq -> 920
/*     */     //   900: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   903: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   908: dup
/*     */     //   909: ifnonnull -> 915
/*     */     //   912: invokestatic throwNpe : ()V
/*     */     //   915: invokeinterface swingItem : ()V
/*     */     //   920: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   923: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   928: aload_2
/*     */     //   929: invokeinterface getOpenContainer : ()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;
/*     */     //   934: dup
/*     */     //   935: ifnonnull -> 941
/*     */     //   938: invokestatic throwNpe : ()V
/*     */     //   941: invokeinterface getWindowId : ()I
/*     */     //   946: iload #6
/*     */     //   948: iconst_1
/*     */     //   949: iconst_4
/*     */     //   950: aload_2
/*     */     //   951: invokeinterface windowClick : (IIIILnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   956: iload #7
/*     */     //   958: ifeq -> 985
/*     */     //   961: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   964: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   969: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   972: invokeinterface createCPacketCloseWindow : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCloseWindow;
/*     */     //   977: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   980: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   985: aload_0
/*     */     //   986: aload_0
/*     */     //   987: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   990: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   993: checkcast java/lang/Number
/*     */     //   996: invokevirtual intValue : ()I
/*     */     //   999: aload_0
/*     */     //   1000: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   1003: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1006: checkcast java/lang/Number
/*     */     //   1009: invokevirtual intValue : ()I
/*     */     //   1012: invokestatic randomDelay : (II)J
/*     */     //   1015: putfield delay : J
/*     */     //   1018: goto -> 125
/*     */     //   1021: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #79	-> 6
/*     */     //   #79	-> 21
/*     */     //   #81	-> 24
/*     */     //   #83	-> 125
/*     */     //   #86	-> 138
/*     */     //   #95	-> 138
/*     */     //   #86	-> 138
/*     */     //   #89	-> 138
/*     */     //   #86	-> 138
/*     */     //   #89	-> 160
/*     */     //   #95	-> 171
/*     */     //   #86	-> 185
/*     */     //   #96	-> 189
/*     */     //   #97	-> 195
/*     */     //   #97	-> 258
/*     */     //   #97	-> 277
/*     */     //   #98	-> 282
/*     */     //   #97	-> 322
/*     */     //   #102	-> 325
/*     */     //   #103	-> 338
/*     */     //   #103	-> 350
/*     */     //   #104	-> 356
/*     */     //   #105	-> 426
/*     */     //   #106	-> 432
/*     */     //   #107	-> 469
/*     */     //   #110	-> 469
/*     */     //   #107	-> 469
/*     */     //   #108	-> 504
/*     */     //   #109	-> 506
/*     */     //   #107	-> 508
/*     */     //   #112	-> 514
/*     */     //   #113	-> 540
/*     */     //   #114	-> 545
/*     */     //   #116	-> 546
/*     */     //   #117	-> 580
/*     */     //   #118	-> 585
/*     */     //   #116	-> 586
/*     */     //   #121	-> 592
/*     */     //   #122	-> 597
/*     */     //   #102	-> 598
/*     */     //   #127	-> 604
/*     */     //   #129	-> 609
/*     */     //   #131	-> 629
/*     */     //   #132	-> 629
/*     */     //   #544	-> 642
/*     */     //   #545	-> 661
/*     */     //   #546	-> 704
/*     */     //   #132	-> 711
/*     */     //   #547	-> 749
/*     */     //   #545	-> 771
/*     */     //   #550	-> 774
/*     */     //   #132	-> 785
/*     */     //   #131	-> 788
/*     */     //   #135	-> 790
/*     */     //   #137	-> 818
/*     */     //   #137	-> 836
/*     */     //   #140	-> 842
/*     */     //   #144	-> 884
/*     */     //   #145	-> 920
/*     */     //   #146	-> 928
/*     */     //   #147	-> 946
/*     */     //   #148	-> 948
/*     */     //   #149	-> 949
/*     */     //   #150	-> 950
/*     */     //   #145	-> 951
/*     */     //   #152	-> 956
/*     */     //   #154	-> 985
/*     */     //   #83	-> 1018
/*     */     //   #156	-> 1021
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   282	40	8	value	Ljava/util/List;
/*     */     //   282	40	7	key	Ljava/lang/Integer;
/*     */     //   469	129	9	oldArmor	Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   432	166	8	armorSlot	I
/*     */     //   356	242	7	armorPiece	Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   338	263	5	i	I
/*     */     //   708	38	15	it	Ljava/util/Map$Entry;
/*     */     //   711	35	16	$i$a$-filter-InvManager$onUpdate$garbageItems$1	I
/*     */     //   704	67	14	element$iv$iv	Ljava/util/Map$Entry;
/*     */     //   658	118	8	$this$filterTo$iv$iv	Ljava/util/Map;
/*     */     //   658	118	9	destination$iv$iv	Ljava/util/Map;
/*     */     //   661	115	10	$i$f$filterTo	I
/*     */     //   639	138	6	$this$filter$iv	Ljava/util/Map;
/*     */     //   642	135	7	$i$f$filter	I
/*     */     //   884	134	7	openInventory	Z
/*     */     //   842	176	6	garbageItem	I
/*     */     //   790	228	5	garbageItems	Ljava/util/List;
/*     */     //   195	823	4	bestArmor	[Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   189	829	3	armorPieces	Ljava/util/Map;
/*     */     //   24	998	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1022	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;
/*     */     //   0	1022	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\013\n\000\n\002\020\b\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "i", "", "test"}) static final class InvManager$onUpdate$armorPieces$1 implements IntPredicate {
/*     */     public final boolean test(int i) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IItemStack itemStack = MinecraftInstance.mc.getThePlayer().getInventory().getStackInSlot(i); return (itemStack != null && MinecraftInstance.classProvider.isItemArmor(itemStack.getItem()) && (i < 9 || System.currentTimeMillis() - itemStack.getItemDelay() >= ((Number)InvManager.this.itemDelayValue.get()).longValue())); } } public final boolean isUseful(@NotNull IItemStack itemStack, int slot) { // Byte code:
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
/*     */     //   320: goto -> 1343
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
/*     */     //   488: goto -> 1343
/*     */     //   491: iconst_1
/*     */     //   492: goto -> 1343
/*     */     //   495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   498: aload_3
/*     */     //   499: invokeinterface isItemArmor : (Ljava/lang/Object;)Z
/*     */     //   504: ifeq -> 557
/*     */     //   507: aload_0
/*     */     //   508: getfield ignoreChainArmorValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   511: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   514: checkcast java/lang/Boolean
/*     */     //   517: invokevirtual booleanValue : ()Z
/*     */     //   520: ifeq -> 557
/*     */     //   523: aload_1
/*     */     //   524: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   529: ldc_w 'item.helmetChain'
/*     */     //   532: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   535: ifne -> 553
/*     */     //   538: aload_1
/*     */     //   539: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   544: ldc_w 'item.leggingsChain'
/*     */     //   547: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   550: ifeq -> 557
/*     */     //   553: iconst_0
/*     */     //   554: goto -> 1343
/*     */     //   557: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   560: aload_3
/*     */     //   561: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   566: ifeq -> 748
/*     */     //   569: aload_1
/*     */     //   570: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   573: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   576: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   581: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   584: istore #4
/*     */     //   586: aload_0
/*     */     //   587: iconst_0
/*     */     //   588: iconst_0
/*     */     //   589: iconst_3
/*     */     //   590: aconst_null
/*     */     //   591: invokestatic items$default : (Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;IIILjava/lang/Object;)Ljava/util/Map;
/*     */     //   594: astore #5
/*     */     //   596: iconst_0
/*     */     //   597: istore #6
/*     */     //   599: aload #5
/*     */     //   601: invokeinterface isEmpty : ()Z
/*     */     //   606: ifeq -> 613
/*     */     //   609: iconst_1
/*     */     //   610: goto -> 1343
/*     */     //   613: aload #5
/*     */     //   615: astore #7
/*     */     //   617: iconst_0
/*     */     //   618: istore #8
/*     */     //   620: aload #7
/*     */     //   622: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   627: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   632: astore #9
/*     */     //   634: aload #9
/*     */     //   636: invokeinterface hasNext : ()Z
/*     */     //   641: ifeq -> 744
/*     */     //   644: aload #9
/*     */     //   646: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   651: checkcast java/util/Map$Entry
/*     */     //   654: astore #10
/*     */     //   656: aload #10
/*     */     //   658: astore #11
/*     */     //   660: iconst_0
/*     */     //   661: istore #12
/*     */     //   663: aload #11
/*     */     //   665: astore #13
/*     */     //   667: iconst_0
/*     */     //   668: istore #14
/*     */     //   670: aload #13
/*     */     //   672: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   677: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   680: astore #15
/*     */     //   682: aload_1
/*     */     //   683: aload #15
/*     */     //   685: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   688: iconst_1
/*     */     //   689: ixor
/*     */     //   690: ifeq -> 736
/*     */     //   693: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   696: aload #15
/*     */     //   698: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   703: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   708: ifeq -> 736
/*     */     //   711: iload #4
/*     */     //   713: aload #15
/*     */     //   715: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   718: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   721: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   726: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   729: if_icmpge -> 736
/*     */     //   732: iconst_1
/*     */     //   733: goto -> 737
/*     */     //   736: iconst_0
/*     */     //   737: ifeq -> 634
/*     */     //   740: iconst_0
/*     */     //   741: goto -> 1343
/*     */     //   744: iconst_1
/*     */     //   745: goto -> 1343
/*     */     //   748: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   751: aload_3
/*     */     //   752: invokeinterface isItemArmor : (Ljava/lang/Object;)Z
/*     */     //   757: ifeq -> 981
/*     */     //   760: new net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   763: dup
/*     */     //   764: aload_1
/*     */     //   765: iload_2
/*     */     //   766: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)V
/*     */     //   769: astore #4
/*     */     //   771: aload_0
/*     */     //   772: iconst_0
/*     */     //   773: iconst_0
/*     */     //   774: iconst_3
/*     */     //   775: aconst_null
/*     */     //   776: invokestatic items$default : (Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;IIILjava/lang/Object;)Ljava/util/Map;
/*     */     //   779: astore #5
/*     */     //   781: iconst_0
/*     */     //   782: istore #6
/*     */     //   784: aload #5
/*     */     //   786: invokeinterface isEmpty : ()Z
/*     */     //   791: ifeq -> 798
/*     */     //   794: iconst_1
/*     */     //   795: goto -> 1343
/*     */     //   798: aload #5
/*     */     //   800: astore #7
/*     */     //   802: iconst_0
/*     */     //   803: istore #8
/*     */     //   805: aload #7
/*     */     //   807: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   812: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   817: astore #9
/*     */     //   819: aload #9
/*     */     //   821: invokeinterface hasNext : ()Z
/*     */     //   826: ifeq -> 977
/*     */     //   829: aload #9
/*     */     //   831: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   836: checkcast java/util/Map$Entry
/*     */     //   839: astore #10
/*     */     //   841: aload #10
/*     */     //   843: astore #11
/*     */     //   845: iconst_0
/*     */     //   846: istore #12
/*     */     //   848: aload #11
/*     */     //   850: astore #13
/*     */     //   852: iconst_0
/*     */     //   853: istore #14
/*     */     //   855: aload #13
/*     */     //   857: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   862: checkcast java/lang/Number
/*     */     //   865: invokevirtual intValue : ()I
/*     */     //   868: istore #15
/*     */     //   870: aload #11
/*     */     //   872: astore #13
/*     */     //   874: iconst_0
/*     */     //   875: istore #14
/*     */     //   877: aload #13
/*     */     //   879: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   884: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   887: astore #16
/*     */     //   889: aload #16
/*     */     //   891: aload_1
/*     */     //   892: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   895: iconst_1
/*     */     //   896: ixor
/*     */     //   897: ifeq -> 969
/*     */     //   900: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   903: aload #16
/*     */     //   905: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   910: invokeinterface isItemArmor : (Ljava/lang/Object;)Z
/*     */     //   915: ifeq -> 969
/*     */     //   918: new net/ccbluex/liquidbounce/utils/item/ArmorPiece
/*     */     //   921: dup
/*     */     //   922: aload #16
/*     */     //   924: iload #15
/*     */     //   926: invokespecial <init> : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;I)V
/*     */     //   929: astore #13
/*     */     //   931: aload #13
/*     */     //   933: invokevirtual getArmorType : ()I
/*     */     //   936: aload #4
/*     */     //   938: invokevirtual getArmorType : ()I
/*     */     //   941: if_icmpeq -> 948
/*     */     //   944: iconst_0
/*     */     //   945: goto -> 970
/*     */     //   948: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager.ARMOR_COMPARATOR : Lnet/ccbluex/liquidbounce/utils/item/ArmorComparator;
/*     */     //   951: aload #4
/*     */     //   953: aload #13
/*     */     //   955: invokevirtual compare : (Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;)I
/*     */     //   958: ifgt -> 965
/*     */     //   961: iconst_1
/*     */     //   962: goto -> 966
/*     */     //   965: iconst_0
/*     */     //   966: goto -> 970
/*     */     //   969: iconst_0
/*     */     //   970: ifeq -> 819
/*     */     //   973: iconst_0
/*     */     //   974: goto -> 1343
/*     */     //   977: iconst_1
/*     */     //   978: goto -> 1343
/*     */     //   981: aload_1
/*     */     //   982: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   987: ldc_w 'item.compass'
/*     */     //   990: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   993: ifeq -> 1134
/*     */     //   996: aload_0
/*     */     //   997: iconst_0
/*     */     //   998: bipush #45
/*     */     //   1000: invokespecial items : (II)Ljava/util/Map;
/*     */     //   1003: astore #4
/*     */     //   1005: iconst_0
/*     */     //   1006: istore #5
/*     */     //   1008: aload #4
/*     */     //   1010: invokeinterface isEmpty : ()Z
/*     */     //   1015: ifeq -> 1022
/*     */     //   1018: iconst_1
/*     */     //   1019: goto -> 1343
/*     */     //   1022: aload #4
/*     */     //   1024: astore #6
/*     */     //   1026: iconst_0
/*     */     //   1027: istore #7
/*     */     //   1029: aload #6
/*     */     //   1031: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   1036: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1041: astore #8
/*     */     //   1043: aload #8
/*     */     //   1045: invokeinterface hasNext : ()Z
/*     */     //   1050: ifeq -> 1130
/*     */     //   1053: aload #8
/*     */     //   1055: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1060: checkcast java/util/Map$Entry
/*     */     //   1063: astore #9
/*     */     //   1065: aload #9
/*     */     //   1067: astore #10
/*     */     //   1069: iconst_0
/*     */     //   1070: istore #11
/*     */     //   1072: aload #10
/*     */     //   1074: astore #12
/*     */     //   1076: iconst_0
/*     */     //   1077: istore #13
/*     */     //   1079: aload #12
/*     */     //   1081: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   1086: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1089: astore #14
/*     */     //   1091: aload_1
/*     */     //   1092: aload #14
/*     */     //   1094: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1097: iconst_1
/*     */     //   1098: ixor
/*     */     //   1099: ifeq -> 1122
/*     */     //   1102: aload #14
/*     */     //   1104: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1109: ldc_w 'item.compass'
/*     */     //   1112: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1115: ifeq -> 1122
/*     */     //   1118: iconst_1
/*     */     //   1119: goto -> 1123
/*     */     //   1122: iconst_0
/*     */     //   1123: ifeq -> 1043
/*     */     //   1126: iconst_0
/*     */     //   1127: goto -> 1343
/*     */     //   1130: iconst_1
/*     */     //   1131: goto -> 1343
/*     */     //   1134: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1137: aload_3
/*     */     //   1138: invokeinterface isItemFood : (Ljava/lang/Object;)Z
/*     */     //   1143: ifeq -> 1158
/*     */     //   1146: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1149: aload_3
/*     */     //   1150: invokeinterface isItemAppleGold : (Ljava/lang/Object;)Z
/*     */     //   1155: ifne -> 1338
/*     */     //   1158: aload_1
/*     */     //   1159: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1164: ldc_w 'item.arrow'
/*     */     //   1167: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1170: ifne -> 1338
/*     */     //   1173: aload_1
/*     */     //   1174: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1179: ldc_w 'item.slimeball'
/*     */     //   1182: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1185: ifne -> 1338
/*     */     //   1188: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1191: aload_3
/*     */     //   1192: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   1197: ifeq -> 1235
/*     */     //   1200: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1203: aload_3
/*     */     //   1204: dup
/*     */     //   1205: ifnull -> 1225
/*     */     //   1208: invokeinterface asItemBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;
/*     */     //   1213: dup
/*     */     //   1214: ifnull -> 1225
/*     */     //   1217: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1222: goto -> 1227
/*     */     //   1225: pop
/*     */     //   1226: aconst_null
/*     */     //   1227: invokeinterface isBlockBush : (Ljava/lang/Object;)Z
/*     */     //   1232: ifeq -> 1338
/*     */     //   1235: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1238: aload_3
/*     */     //   1239: invokeinterface isItemBed : (Ljava/lang/Object;)Z
/*     */     //   1244: ifne -> 1338
/*     */     //   1247: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1250: aload_3
/*     */     //   1251: invokeinterface isItemPotion : (Ljava/lang/Object;)Z
/*     */     //   1256: ifne -> 1338
/*     */     //   1259: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1262: aload_3
/*     */     //   1263: invokeinterface isItemEnderPearl : (Ljava/lang/Object;)Z
/*     */     //   1268: ifne -> 1338
/*     */     //   1271: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1274: aload_3
/*     */     //   1275: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1280: ifne -> 1338
/*     */     //   1283: aload_1
/*     */     //   1284: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1289: ldc_w 'item.stick'
/*     */     //   1292: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1295: ifne -> 1338
/*     */     //   1298: aload_0
/*     */     //   1299: getfield ignoreVehiclesValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1302: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1305: checkcast java/lang/Boolean
/*     */     //   1308: invokevirtual booleanValue : ()Z
/*     */     //   1311: ifeq -> 1342
/*     */     //   1314: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1317: aload_3
/*     */     //   1318: invokeinterface isItemBoat : (Ljava/lang/Object;)Z
/*     */     //   1323: ifne -> 1338
/*     */     //   1326: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1329: aload_3
/*     */     //   1330: invokeinterface isItemMinecart : (Ljava/lang/Object;)Z
/*     */     //   1335: ifeq -> 1342
/*     */     //   1338: iconst_1
/*     */     //   1339: goto -> 1343
/*     */     //   1342: iconst_0
/*     */     //   1343: istore_3
/*     */     //   1344: goto -> 1394
/*     */     //   1347: astore #4
/*     */     //   1349: invokestatic getLogger : ()Lorg/apache/logging/log4j/Logger;
/*     */     //   1352: new java/lang/StringBuilder
/*     */     //   1355: dup
/*     */     //   1356: invokespecial <init> : ()V
/*     */     //   1359: ldc_w '(InvManager) Failed to check item: '
/*     */     //   1362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1365: aload_1
/*     */     //   1366: invokeinterface getUnlocalizedName : ()Ljava/lang/String;
/*     */     //   1371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1374: bipush #46
/*     */     //   1376: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   1379: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1382: aload #4
/*     */     //   1384: checkcast java/lang/Throwable
/*     */     //   1387: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   1392: iconst_1
/*     */     //   1393: istore_3
/*     */     //   1394: iload_3
/*     */     //   1395: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #165	-> 7
/*     */     //   #166	-> 8
/*     */     //   #168	-> 15
/*     */     //   #169	-> 39
/*     */     //   #169	-> 54
/*     */     //   #171	-> 59
/*     */     //   #173	-> 59
/*     */     //   #172	-> 66
/*     */     //   #171	-> 86
/*     */     //   #173	-> 89
/*     */     //   #174	-> 111
/*     */     //   #176	-> 113
/*     */     //   #177	-> 127
/*     */     //   #179	-> 127
/*     */     //   #181	-> 127
/*     */     //   #177	-> 127
/*     */     //   #178	-> 161
/*     */     //   #177	-> 165
/*     */     //   #179	-> 171
/*     */     //   #180	-> 189
/*     */     //   #179	-> 193
/*     */     //   #181	-> 199
/*     */     //   #183	-> 211
/*     */     //   #184	-> 234
/*     */     //   #176	-> 236
/*     */     //   #189	-> 242
/*     */     //   #190	-> 273
/*     */     //   #191	-> 277
/*     */     //   #190	-> 289
/*     */     //   #189	-> 295
/*     */     //   #194	-> 297
/*     */     //   #551	-> 309
/*     */     //   #552	-> 323
/*     */     //   #552	-> 366
/*     */     //   #195	-> 392
/*     */     //   #197	-> 420
/*     */     //   #195	-> 420
/*     */     //   #196	-> 422
/*     */     //   #195	-> 425
/*     */     //   #197	-> 433
/*     */     //   #198	-> 456
/*     */     //   #197	-> 469
/*     */     //   #199	-> 484
/*     */     //   #553	-> 491
/*     */     //   #201	-> 495
/*     */     //   #202	-> 553
/*     */     //   #203	-> 569
/*     */     //   #204	-> 569
/*     */     //   #203	-> 584
/*     */     //   #206	-> 586
/*     */     //   #554	-> 599
/*     */     //   #555	-> 613
/*     */     //   #555	-> 656
/*     */     //   #207	-> 682
/*     */     //   #208	-> 713
/*     */     //   #207	-> 726
/*     */     //   #209	-> 737
/*     */     //   #556	-> 744
/*     */     //   #211	-> 748
/*     */     //   #212	-> 760
/*     */     //   #214	-> 771
/*     */     //   #557	-> 784
/*     */     //   #558	-> 798
/*     */     //   #558	-> 841
/*     */     //   #215	-> 889
/*     */     //   #216	-> 918
/*     */     //   #218	-> 931
/*     */     //   #219	-> 948
/*     */     //   #218	-> 966
/*     */     //   #220	-> 969
/*     */     //   #215	-> 970
/*     */     //   #220	-> 970
/*     */     //   #559	-> 977
/*     */     //   #222	-> 981
/*     */     //   #223	-> 996
/*     */     //   #560	-> 1008
/*     */     //   #561	-> 1022
/*     */     //   #561	-> 1065
/*     */     //   #223	-> 1091
/*     */     //   #562	-> 1130
/*     */     //   #224	-> 1134
/*     */     //   #226	-> 1134
/*     */     //   #228	-> 1134
/*     */     //   #230	-> 1134
/*     */     //   #224	-> 1134
/*     */     //   #225	-> 1191
/*     */     //   #224	-> 1192
/*     */     //   #226	-> 1200
/*     */     //   #227	-> 1250
/*     */     //   #226	-> 1251
/*     */     //   #228	-> 1259
/*     */     //   #229	-> 1317
/*     */     //   #228	-> 1318
/*     */     //   #230	-> 1326
/*     */     //   #222	-> 1343
/*     */     //   #211	-> 1343
/*     */     //   #202	-> 1343
/*     */     //   #201	-> 1343
/*     */     //   #168	-> 1343
/*     */     //   #231	-> 1347
/*     */     //   #232	-> 1349
/*     */     //   #234	-> 1392
/*     */     //   #165	-> 1394
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   127	112	5	i	I
/*     */     //   370	114	13	$dstr$_u24__u24$stack	Ljava/util/Map$Entry;
/*     */     //   370	114	17	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   373	111	14	$i$a$-none-InvManager$isUseful$1	I
/*     */     //   366	125	12	element$iv	Ljava/util/Map$Entry;
/*     */     //   306	186	7	$this$none$iv	Ljava/util/Map;
/*     */     //   309	183	8	$i$f$none	I
/*     */     //   297	195	5	damage	D
/*     */     //   59	433	4	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   660	77	11	$dstr$_u24__u24$stack	Ljava/util/Map$Entry;
/*     */     //   660	77	15	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   663	74	12	$i$a$-none-InvManager$isUseful$2	I
/*     */     //   656	88	10	element$iv	Ljava/util/Map$Entry;
/*     */     //   596	149	5	$this$none$iv	Ljava/util/Map;
/*     */     //   599	146	6	$i$f$none	I
/*     */     //   586	159	4	currPower	I
/*     */     //   931	35	13	armor	Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   845	125	11	$dstr$slot$stack	Ljava/util/Map$Entry;
/*     */     //   845	125	15	slot	I
/*     */     //   845	125	16	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   848	122	12	$i$a$-none-InvManager$isUseful$3	I
/*     */     //   841	136	10	element$iv	Ljava/util/Map$Entry;
/*     */     //   781	197	5	$this$none$iv	Ljava/util/Map;
/*     */     //   784	194	6	$i$f$none	I
/*     */     //   771	207	4	currArmor	Lnet/ccbluex/liquidbounce/utils/item/ArmorPiece;
/*     */     //   1069	54	10	$dstr$_u24__u24$stack	Ljava/util/Map$Entry;
/*     */     //   1069	54	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1072	51	11	$i$a$-none-InvManager$isUseful$4	I
/*     */     //   1065	65	9	element$iv	Ljava/util/Map$Entry;
/*     */     //   1005	126	4	$this$none$iv	Ljava/util/Map;
/*     */     //   1008	123	5	$i$f$none	I
/*     */     //   15	1328	3	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1349	45	4	ex	Ljava/lang/Exception;
/*     */     //   0	1396	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;
/*     */     //   0	1396	1	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   0	1396	2	slot	I
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	1344	1347	java/lang/Exception } private final void sortHotbar() { // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_1
/*     */     //   2: bipush #8
/*     */     //   4: istore_2
/*     */     //   5: iload_1
/*     */     //   6: iload_2
/*     */     //   7: if_icmpgt -> 214
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
/*     */     //   56: goto -> 208
/*     */     //   59: istore #4
/*     */     //   61: iload #4
/*     */     //   63: iload_1
/*     */     //   64: if_icmpeq -> 208
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
/*     */     //   109: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   112: invokeinterface getPlayerController : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IPlayerControllerMP;
/*     */     //   117: iconst_0
/*     */     //   118: iload #4
/*     */     //   120: bipush #9
/*     */     //   122: if_icmpge -> 133
/*     */     //   125: iload #4
/*     */     //   127: bipush #36
/*     */     //   129: iadd
/*     */     //   130: goto -> 135
/*     */     //   133: iload #4
/*     */     //   135: iload_1
/*     */     //   136: iconst_2
/*     */     //   137: aload_3
/*     */     //   138: invokeinterface windowClick : (IIIILnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;)V
/*     */     //   143: iload #5
/*     */     //   145: ifeq -> 172
/*     */     //   148: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   151: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   156: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   159: invokeinterface createCPacketCloseWindow : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketCloseWindow;
/*     */     //   164: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   167: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   172: aload_0
/*     */     //   173: aload_0
/*     */     //   174: getfield minDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   177: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   180: checkcast java/lang/Number
/*     */     //   183: invokevirtual intValue : ()I
/*     */     //   186: aload_0
/*     */     //   187: getfield maxDelayValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   190: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   193: checkcast java/lang/Number
/*     */     //   196: invokevirtual intValue : ()I
/*     */     //   199: invokestatic randomDelay : (II)J
/*     */     //   202: putfield delay : J
/*     */     //   205: goto -> 214
/*     */     //   208: iinc #1, 1
/*     */     //   211: goto -> 5
/*     */     //   214: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #246	-> 0
/*     */     //   #247	-> 10
/*     */     //   #247	-> 25
/*     */     //   #249	-> 28
/*     */     //   #249	-> 55
/*     */     //   #251	-> 61
/*     */     //   #252	-> 67
/*     */     //   #256	-> 109
/*     */     //   #257	-> 117
/*     */     //   #256	-> 138
/*     */     //   #260	-> 143
/*     */     //   #262	-> 172
/*     */     //   #263	-> 205
/*     */     //   #246	-> 208
/*     */     //   #266	-> 214
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   109	99	5	openInventory	Z
/*     */     //   61	147	4	bestItem	I
/*     */     //   28	180	3	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   10	201	1	index	I
/*     */     //   0	215	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager; } private final Integer findBetterItem(int targetSlot, IItemStack slotStack) { // Byte code:
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
/*     */     //   66: lookupswitch default -> 1796, -1253135533 -> 210, -578028723 -> 154, 97038 -> 224, 97738 -> 182, 93832333 -> 168, 106540102 -> 238, 109860349 -> 140, 112903447 -> 196
/*     */     //   140: aload #5
/*     */     //   142: ldc_w 'sword'
/*     */     //   145: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   148: ifeq -> 1796
/*     */     //   151: goto -> 252
/*     */     //   154: aload #5
/*     */     //   156: ldc_w 'pickaxe'
/*     */     //   159: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   162: ifeq -> 1796
/*     */     //   165: goto -> 252
/*     */     //   168: aload #5
/*     */     //   170: ldc_w 'block'
/*     */     //   173: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   176: ifeq -> 1796
/*     */     //   179: goto -> 948
/*     */     //   182: aload #5
/*     */     //   184: ldc_w 'bow'
/*     */     //   187: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   190: ifeq -> 1796
/*     */     //   193: goto -> 678
/*     */     //   196: aload #5
/*     */     //   198: ldc_w 'water'
/*     */     //   201: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   204: ifeq -> 1796
/*     */     //   207: goto -> 1158
/*     */     //   210: aload #5
/*     */     //   212: ldc_w 'gapple'
/*     */     //   215: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   218: ifeq -> 1796
/*     */     //   221: goto -> 1405
/*     */     //   224: aload #5
/*     */     //   226: ldc_w 'axe'
/*     */     //   229: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   232: ifeq -> 1796
/*     */     //   235: goto -> 252
/*     */     //   238: aload #5
/*     */     //   240: ldc_w 'pearl'
/*     */     //   243: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   246: ifeq -> 1796
/*     */     //   249: goto -> 1605
/*     */     //   252: nop
/*     */     //   253: aload_3
/*     */     //   254: ldc_w 'Sword'
/*     */     //   257: iconst_1
/*     */     //   258: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   261: ifeq -> 273
/*     */     //   264: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager$findBetterItem$currentTypeChecker$1.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager$findBetterItem$currentTypeChecker$1;
/*     */     //   267: checkcast kotlin/jvm/functions/Function1
/*     */     //   270: goto -> 315
/*     */     //   273: aload_3
/*     */     //   274: ldc_w 'Pickaxe'
/*     */     //   277: iconst_1
/*     */     //   278: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   281: ifeq -> 293
/*     */     //   284: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager$findBetterItem$currentTypeChecker$2.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager$findBetterItem$currentTypeChecker$2;
/*     */     //   287: checkcast kotlin/jvm/functions/Function1
/*     */     //   290: goto -> 315
/*     */     //   293: aload_3
/*     */     //   294: ldc_w 'Axe'
/*     */     //   297: iconst_1
/*     */     //   298: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   301: ifeq -> 313
/*     */     //   304: getstatic net/ccbluex/liquidbounce/features/module/modules/player/InvManager$findBetterItem$currentTypeChecker$3.INSTANCE : Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager$findBetterItem$currentTypeChecker$3;
/*     */     //   307: checkcast kotlin/jvm/functions/Function1
/*     */     //   310: goto -> 315
/*     */     //   313: aconst_null
/*     */     //   314: areturn
/*     */     //   315: astore #6
/*     */     //   317: aload #6
/*     */     //   319: aload_2
/*     */     //   320: dup
/*     */     //   321: ifnull -> 332
/*     */     //   324: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   329: goto -> 334
/*     */     //   332: pop
/*     */     //   333: aconst_null
/*     */     //   334: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   339: checkcast java/lang/Boolean
/*     */     //   342: invokevirtual booleanValue : ()Z
/*     */     //   345: ifeq -> 352
/*     */     //   348: iload_1
/*     */     //   349: goto -> 353
/*     */     //   352: iconst_m1
/*     */     //   353: istore #7
/*     */     //   355: aload #4
/*     */     //   357: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   362: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   367: checkcast java/lang/Iterable
/*     */     //   370: astore #8
/*     */     //   372: iconst_0
/*     */     //   373: istore #9
/*     */     //   375: iconst_0
/*     */     //   376: istore #10
/*     */     //   378: aload #8
/*     */     //   380: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   385: astore #11
/*     */     //   387: aload #11
/*     */     //   389: invokeinterface hasNext : ()Z
/*     */     //   394: ifeq -> 655
/*     */     //   397: aload #11
/*     */     //   399: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   404: astore #12
/*     */     //   406: iload #10
/*     */     //   408: iinc #10, 1
/*     */     //   411: istore #13
/*     */     //   413: iconst_0
/*     */     //   414: istore #14
/*     */     //   416: iload #13
/*     */     //   418: ifge -> 424
/*     */     //   421: invokestatic throwIndexOverflow : ()V
/*     */     //   424: iload #13
/*     */     //   426: istore #15
/*     */     //   428: iload #15
/*     */     //   430: aload #12
/*     */     //   432: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   435: astore #16
/*     */     //   437: istore #17
/*     */     //   439: iconst_0
/*     */     //   440: istore #18
/*     */     //   442: aload #16
/*     */     //   444: ifnull -> 650
/*     */     //   447: aload #6
/*     */     //   449: aload #16
/*     */     //   451: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   456: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   461: checkcast java/lang/Boolean
/*     */     //   464: invokevirtual booleanValue : ()Z
/*     */     //   467: ifeq -> 650
/*     */     //   470: aload_0
/*     */     //   471: iload #17
/*     */     //   473: invokespecial type : (I)Ljava/lang/String;
/*     */     //   476: aload_3
/*     */     //   477: iconst_1
/*     */     //   478: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   481: ifne -> 650
/*     */     //   484: iload #7
/*     */     //   486: iconst_m1
/*     */     //   487: if_icmpne -> 497
/*     */     //   490: iload #17
/*     */     //   492: istore #7
/*     */     //   494: goto -> 650
/*     */     //   497: aload #16
/*     */     //   499: ldc_w 'generic.attackDamage'
/*     */     //   502: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*     */     //   507: checkcast java/lang/Iterable
/*     */     //   510: invokestatic firstOrNull : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   513: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*     */     //   516: dup
/*     */     //   517: ifnull -> 528
/*     */     //   520: invokeinterface getAmount : ()D
/*     */     //   525: goto -> 530
/*     */     //   528: pop
/*     */     //   529: dconst_0
/*     */     //   530: ldc2_w 1.25
/*     */     //   533: aload #16
/*     */     //   535: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   538: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   541: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   546: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   549: i2d
/*     */     //   550: dmul
/*     */     //   551: dadd
/*     */     //   552: dstore #19
/*     */     //   554: aload #4
/*     */     //   556: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   561: iload #7
/*     */     //   563: invokeinterface getStackInSlot : (I)Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   568: dup
/*     */     //   569: ifnull -> 575
/*     */     //   572: goto -> 579
/*     */     //   575: pop
/*     */     //   576: goto -> 651
/*     */     //   579: astore #21
/*     */     //   581: aload #21
/*     */     //   583: ldc_w 'generic.attackDamage'
/*     */     //   586: invokeinterface getAttributeModifier : (Ljava/lang/String;)Ljava/util/Collection;
/*     */     //   591: checkcast java/lang/Iterable
/*     */     //   594: invokestatic firstOrNull : (Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   597: checkcast net/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier
/*     */     //   600: dup
/*     */     //   601: ifnull -> 612
/*     */     //   604: invokeinterface getAmount : ()D
/*     */     //   609: goto -> 614
/*     */     //   612: pop
/*     */     //   613: dconst_0
/*     */     //   614: ldc2_w 1.25
/*     */     //   617: aload #21
/*     */     //   619: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   622: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.SHARPNESS : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   625: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   630: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   633: i2d
/*     */     //   634: dmul
/*     */     //   635: dadd
/*     */     //   636: dstore #22
/*     */     //   638: dload #22
/*     */     //   640: dload #19
/*     */     //   642: dcmpg
/*     */     //   643: ifge -> 650
/*     */     //   646: iload #17
/*     */     //   648: istore #7
/*     */     //   650: nop
/*     */     //   651: nop
/*     */     //   652: goto -> 387
/*     */     //   655: nop
/*     */     //   656: iload #7
/*     */     //   658: iconst_m1
/*     */     //   659: if_icmpne -> 668
/*     */     //   662: iload #7
/*     */     //   664: iload_1
/*     */     //   665: if_icmpne -> 676
/*     */     //   668: iload #7
/*     */     //   670: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   673: goto -> 677
/*     */     //   676: aconst_null
/*     */     //   677: areturn
/*     */     //   678: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   681: aload_2
/*     */     //   682: dup
/*     */     //   683: ifnull -> 694
/*     */     //   686: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   691: goto -> 696
/*     */     //   694: pop
/*     */     //   695: aconst_null
/*     */     //   696: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   701: ifeq -> 708
/*     */     //   704: iload_1
/*     */     //   705: goto -> 709
/*     */     //   708: iconst_m1
/*     */     //   709: istore #6
/*     */     //   711: iload #6
/*     */     //   713: iconst_m1
/*     */     //   714: if_icmpeq -> 735
/*     */     //   717: aload_2
/*     */     //   718: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   721: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   724: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   729: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   732: goto -> 736
/*     */     //   735: iconst_0
/*     */     //   736: istore #7
/*     */     //   738: aload #4
/*     */     //   740: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   745: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   750: checkcast java/lang/Iterable
/*     */     //   753: astore #8
/*     */     //   755: iconst_0
/*     */     //   756: istore #9
/*     */     //   758: iconst_0
/*     */     //   759: istore #10
/*     */     //   761: aload #8
/*     */     //   763: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   768: astore #11
/*     */     //   770: aload #11
/*     */     //   772: invokeinterface hasNext : ()Z
/*     */     //   777: ifeq -> 931
/*     */     //   780: aload #11
/*     */     //   782: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   787: astore #12
/*     */     //   789: iload #10
/*     */     //   791: iinc #10, 1
/*     */     //   794: istore #13
/*     */     //   796: iconst_0
/*     */     //   797: istore #14
/*     */     //   799: iload #13
/*     */     //   801: ifge -> 807
/*     */     //   804: invokestatic throwIndexOverflow : ()V
/*     */     //   807: iload #13
/*     */     //   809: istore #15
/*     */     //   811: iload #15
/*     */     //   813: aload #12
/*     */     //   815: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   818: astore #16
/*     */     //   820: istore #17
/*     */     //   822: iconst_0
/*     */     //   823: istore #18
/*     */     //   825: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   828: aload #16
/*     */     //   830: dup
/*     */     //   831: ifnull -> 842
/*     */     //   834: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   839: goto -> 844
/*     */     //   842: pop
/*     */     //   843: aconst_null
/*     */     //   844: invokeinterface isItemBow : (Ljava/lang/Object;)Z
/*     */     //   849: ifeq -> 926
/*     */     //   852: aload_0
/*     */     //   853: iload #17
/*     */     //   855: invokespecial type : (I)Ljava/lang/String;
/*     */     //   858: aload_3
/*     */     //   859: iconst_1
/*     */     //   860: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   863: ifne -> 926
/*     */     //   866: iload #6
/*     */     //   868: iconst_m1
/*     */     //   869: if_icmpne -> 879
/*     */     //   872: iload #17
/*     */     //   874: istore #6
/*     */     //   876: goto -> 926
/*     */     //   879: aload #16
/*     */     //   881: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   884: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   887: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   892: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   895: istore #19
/*     */     //   897: aload #16
/*     */     //   899: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   902: getstatic net/ccbluex/liquidbounce/api/enums/EnchantmentType.POWER : Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;
/*     */     //   905: invokeinterface getEnchantmentEnum : (Lnet/ccbluex/liquidbounce/api/enums/EnchantmentType;)Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;
/*     */     //   910: invokestatic getEnchantment : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;)I
/*     */     //   913: iload #7
/*     */     //   915: if_icmple -> 926
/*     */     //   918: iload #17
/*     */     //   920: istore #6
/*     */     //   922: iload #19
/*     */     //   924: istore #7
/*     */     //   926: nop
/*     */     //   927: nop
/*     */     //   928: goto -> 770
/*     */     //   931: nop
/*     */     //   932: iload #6
/*     */     //   934: iconst_m1
/*     */     //   935: if_icmpeq -> 946
/*     */     //   938: iload #6
/*     */     //   940: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   943: goto -> 947
/*     */     //   946: aconst_null
/*     */     //   947: areturn
/*     */     //   948: aload #4
/*     */     //   950: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   955: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   960: checkcast java/lang/Iterable
/*     */     //   963: astore #6
/*     */     //   965: iconst_0
/*     */     //   966: istore #7
/*     */     //   968: iconst_0
/*     */     //   969: istore #8
/*     */     //   971: aload #6
/*     */     //   973: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   978: astore #9
/*     */     //   980: aload #9
/*     */     //   982: invokeinterface hasNext : ()Z
/*     */     //   987: ifeq -> 1155
/*     */     //   990: aload #9
/*     */     //   992: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   997: astore #10
/*     */     //   999: iload #8
/*     */     //   1001: iinc #8, 1
/*     */     //   1004: istore #11
/*     */     //   1006: iconst_0
/*     */     //   1007: istore #12
/*     */     //   1009: iload #11
/*     */     //   1011: ifge -> 1017
/*     */     //   1014: invokestatic throwIndexOverflow : ()V
/*     */     //   1017: iload #11
/*     */     //   1019: istore #13
/*     */     //   1021: iload #13
/*     */     //   1023: aload #10
/*     */     //   1025: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1028: astore #14
/*     */     //   1030: istore #15
/*     */     //   1032: iconst_0
/*     */     //   1033: istore #16
/*     */     //   1035: aload #14
/*     */     //   1037: ifnull -> 1150
/*     */     //   1040: aload #14
/*     */     //   1042: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1047: dup
/*     */     //   1048: ifnonnull -> 1054
/*     */     //   1051: invokestatic throwNpe : ()V
/*     */     //   1054: astore #17
/*     */     //   1056: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1059: aload #17
/*     */     //   1061: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   1066: ifeq -> 1150
/*     */     //   1069: getstatic net/ccbluex/liquidbounce/utils/InventoryUtils.BLOCK_BLACKLIST : Ljava/util/List;
/*     */     //   1072: aload #17
/*     */     //   1074: invokeinterface asItemBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBlock;
/*     */     //   1079: invokeinterface getBlock : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1084: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   1089: ifne -> 1150
/*     */     //   1092: aload_0
/*     */     //   1093: iload #15
/*     */     //   1095: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1098: ldc_w 'Block'
/*     */     //   1101: iconst_1
/*     */     //   1102: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1105: ifne -> 1150
/*     */     //   1108: aload_2
/*     */     //   1109: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1112: ifne -> 1128
/*     */     //   1115: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1118: aload #17
/*     */     //   1120: invokeinterface isItemBlock : (Ljava/lang/Object;)Z
/*     */     //   1125: ifne -> 1132
/*     */     //   1128: iconst_1
/*     */     //   1129: goto -> 1133
/*     */     //   1132: iconst_0
/*     */     //   1133: istore #18
/*     */     //   1135: iload #18
/*     */     //   1137: ifeq -> 1148
/*     */     //   1140: iload #15
/*     */     //   1142: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1145: goto -> 1149
/*     */     //   1148: aconst_null
/*     */     //   1149: areturn
/*     */     //   1150: nop
/*     */     //   1151: nop
/*     */     //   1152: goto -> 980
/*     */     //   1155: goto -> 1796
/*     */     //   1158: aload #4
/*     */     //   1160: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1165: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1170: checkcast java/lang/Iterable
/*     */     //   1173: astore #6
/*     */     //   1175: iconst_0
/*     */     //   1176: istore #7
/*     */     //   1178: iconst_0
/*     */     //   1179: istore #8
/*     */     //   1181: aload #6
/*     */     //   1183: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1188: astore #9
/*     */     //   1190: aload #9
/*     */     //   1192: invokeinterface hasNext : ()Z
/*     */     //   1197: ifeq -> 1402
/*     */     //   1200: aload #9
/*     */     //   1202: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1207: astore #10
/*     */     //   1209: iload #8
/*     */     //   1211: iinc #8, 1
/*     */     //   1214: istore #11
/*     */     //   1216: iconst_0
/*     */     //   1217: istore #12
/*     */     //   1219: iload #11
/*     */     //   1221: ifge -> 1227
/*     */     //   1224: invokestatic throwIndexOverflow : ()V
/*     */     //   1227: iload #11
/*     */     //   1229: istore #13
/*     */     //   1231: iload #13
/*     */     //   1233: aload #10
/*     */     //   1235: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1238: astore #14
/*     */     //   1240: istore #15
/*     */     //   1242: iconst_0
/*     */     //   1243: istore #16
/*     */     //   1245: aload #14
/*     */     //   1247: ifnull -> 1397
/*     */     //   1250: aload #14
/*     */     //   1252: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1257: dup
/*     */     //   1258: ifnonnull -> 1264
/*     */     //   1261: invokestatic throwNpe : ()V
/*     */     //   1264: astore #17
/*     */     //   1266: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1269: aload #17
/*     */     //   1271: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1276: ifeq -> 1397
/*     */     //   1279: aload #17
/*     */     //   1281: invokeinterface asItemBucket : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;
/*     */     //   1286: invokeinterface isFull : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1291: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1294: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.FLOWING_WATER : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   1297: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1302: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1305: ifeq -> 1397
/*     */     //   1308: aload_0
/*     */     //   1309: iload #15
/*     */     //   1311: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1314: ldc_w 'Water'
/*     */     //   1317: iconst_1
/*     */     //   1318: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1321: ifne -> 1397
/*     */     //   1324: aload_2
/*     */     //   1325: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1328: ifne -> 1375
/*     */     //   1331: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1334: aload #17
/*     */     //   1336: invokeinterface isItemBucket : (Ljava/lang/Object;)Z
/*     */     //   1341: ifeq -> 1375
/*     */     //   1344: aload #17
/*     */     //   1346: invokeinterface asItemBucket : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemBucket;
/*     */     //   1351: invokeinterface isFull : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1356: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1359: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.FLOWING_WATER : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*     */     //   1362: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*     */     //   1367: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1370: iconst_1
/*     */     //   1371: ixor
/*     */     //   1372: ifeq -> 1379
/*     */     //   1375: iconst_1
/*     */     //   1376: goto -> 1380
/*     */     //   1379: iconst_0
/*     */     //   1380: istore #18
/*     */     //   1382: iload #18
/*     */     //   1384: ifeq -> 1395
/*     */     //   1387: iload #15
/*     */     //   1389: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1392: goto -> 1396
/*     */     //   1395: aconst_null
/*     */     //   1396: areturn
/*     */     //   1397: nop
/*     */     //   1398: nop
/*     */     //   1399: goto -> 1190
/*     */     //   1402: goto -> 1796
/*     */     //   1405: aload #4
/*     */     //   1407: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1412: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1417: checkcast java/lang/Iterable
/*     */     //   1420: astore #6
/*     */     //   1422: iconst_0
/*     */     //   1423: istore #7
/*     */     //   1425: iconst_0
/*     */     //   1426: istore #8
/*     */     //   1428: aload #6
/*     */     //   1430: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1435: astore #9
/*     */     //   1437: aload #9
/*     */     //   1439: invokeinterface hasNext : ()Z
/*     */     //   1444: ifeq -> 1602
/*     */     //   1447: aload #9
/*     */     //   1449: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1454: astore #10
/*     */     //   1456: iload #8
/*     */     //   1458: iinc #8, 1
/*     */     //   1461: istore #11
/*     */     //   1463: iconst_0
/*     */     //   1464: istore #12
/*     */     //   1466: iload #11
/*     */     //   1468: ifge -> 1474
/*     */     //   1471: invokestatic throwIndexOverflow : ()V
/*     */     //   1474: iload #11
/*     */     //   1476: istore #13
/*     */     //   1478: iload #13
/*     */     //   1480: aload #10
/*     */     //   1482: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1485: astore #14
/*     */     //   1487: istore #15
/*     */     //   1489: iconst_0
/*     */     //   1490: istore #16
/*     */     //   1492: aload #14
/*     */     //   1494: ifnull -> 1597
/*     */     //   1497: aload #14
/*     */     //   1499: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1504: dup
/*     */     //   1505: ifnonnull -> 1511
/*     */     //   1508: invokestatic throwNpe : ()V
/*     */     //   1511: astore #17
/*     */     //   1513: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1516: aload #17
/*     */     //   1518: invokeinterface isItemAppleGold : (Ljava/lang/Object;)Z
/*     */     //   1523: ifeq -> 1597
/*     */     //   1526: aload_0
/*     */     //   1527: iload #15
/*     */     //   1529: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1532: ldc_w 'Gapple'
/*     */     //   1535: iconst_1
/*     */     //   1536: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1539: ifne -> 1597
/*     */     //   1542: aload_2
/*     */     //   1543: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1546: ifne -> 1575
/*     */     //   1549: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1552: aload_2
/*     */     //   1553: dup
/*     */     //   1554: ifnull -> 1565
/*     */     //   1557: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1562: goto -> 1567
/*     */     //   1565: pop
/*     */     //   1566: aconst_null
/*     */     //   1567: invokeinterface isItemAppleGold : (Ljava/lang/Object;)Z
/*     */     //   1572: ifne -> 1579
/*     */     //   1575: iconst_1
/*     */     //   1576: goto -> 1580
/*     */     //   1579: iconst_0
/*     */     //   1580: istore #18
/*     */     //   1582: iload #18
/*     */     //   1584: ifeq -> 1595
/*     */     //   1587: iload #15
/*     */     //   1589: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1592: goto -> 1596
/*     */     //   1595: aconst_null
/*     */     //   1596: areturn
/*     */     //   1597: nop
/*     */     //   1598: nop
/*     */     //   1599: goto -> 1437
/*     */     //   1602: goto -> 1796
/*     */     //   1605: aload #4
/*     */     //   1607: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*     */     //   1612: invokeinterface getMainInventory : ()Lnet/ccbluex/liquidbounce/api/util/IWrappedArray;
/*     */     //   1617: checkcast java/lang/Iterable
/*     */     //   1620: astore #6
/*     */     //   1622: iconst_0
/*     */     //   1623: istore #7
/*     */     //   1625: iconst_0
/*     */     //   1626: istore #8
/*     */     //   1628: aload #6
/*     */     //   1630: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   1635: astore #9
/*     */     //   1637: aload #9
/*     */     //   1639: invokeinterface hasNext : ()Z
/*     */     //   1644: ifeq -> 1795
/*     */     //   1647: aload #9
/*     */     //   1649: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   1654: astore #10
/*     */     //   1656: iload #8
/*     */     //   1658: iinc #8, 1
/*     */     //   1661: istore #11
/*     */     //   1663: iconst_0
/*     */     //   1664: istore #12
/*     */     //   1666: iload #11
/*     */     //   1668: ifge -> 1674
/*     */     //   1671: invokestatic throwIndexOverflow : ()V
/*     */     //   1674: iload #11
/*     */     //   1676: istore #13
/*     */     //   1678: iload #13
/*     */     //   1680: aload #10
/*     */     //   1682: checkcast net/ccbluex/liquidbounce/api/minecraft/item/IItemStack
/*     */     //   1685: astore #14
/*     */     //   1687: istore #15
/*     */     //   1689: iconst_0
/*     */     //   1690: istore #16
/*     */     //   1692: aload #14
/*     */     //   1694: ifnull -> 1790
/*     */     //   1697: aload #14
/*     */     //   1699: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1704: astore #17
/*     */     //   1706: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1709: aload #17
/*     */     //   1711: invokeinterface isItemEnderPearl : (Ljava/lang/Object;)Z
/*     */     //   1716: ifeq -> 1790
/*     */     //   1719: aload_0
/*     */     //   1720: iload #15
/*     */     //   1722: invokespecial type : (I)Ljava/lang/String;
/*     */     //   1725: ldc_w 'Pearl'
/*     */     //   1728: iconst_1
/*     */     //   1729: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   1732: ifne -> 1790
/*     */     //   1735: aload_2
/*     */     //   1736: invokestatic isStackEmpty : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Z
/*     */     //   1739: ifne -> 1768
/*     */     //   1742: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1745: aload_2
/*     */     //   1746: dup
/*     */     //   1747: ifnull -> 1758
/*     */     //   1750: invokeinterface getItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1755: goto -> 1760
/*     */     //   1758: pop
/*     */     //   1759: aconst_null
/*     */     //   1760: invokeinterface isItemEnderPearl : (Ljava/lang/Object;)Z
/*     */     //   1765: ifne -> 1772
/*     */     //   1768: iconst_1
/*     */     //   1769: goto -> 1773
/*     */     //   1772: iconst_0
/*     */     //   1773: istore #18
/*     */     //   1775: iload #18
/*     */     //   1777: ifeq -> 1788
/*     */     //   1780: iload #15
/*     */     //   1782: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   1785: goto -> 1789
/*     */     //   1788: aconst_null
/*     */     //   1789: areturn
/*     */     //   1790: nop
/*     */     //   1791: nop
/*     */     //   1792: goto -> 1637
/*     */     //   1795: nop
/*     */     //   1796: aconst_null
/*     */     //   1797: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #269	-> 0
/*     */     //   #271	-> 6
/*     */     //   #271	-> 21
/*     */     //   #273	-> 26
/*     */     //   #274	-> 140
/*     */     //   #344	-> 168
/*     */     //   #314	-> 182
/*     */     //   #361	-> 196
/*     */     //   #381	-> 210
/*     */     //   #274	-> 224
/*     */     //   #396	-> 238
/*     */     //   #275	-> 252
/*     */     //   #276	-> 253
/*     */     //   #277	-> 273
/*     */     //   #278	-> 293
/*     */     //   #279	-> 313
/*     */     //   #275	-> 315
/*     */     //   #282	-> 317
/*     */     //   #283	-> 352
/*     */     //   #282	-> 353
/*     */     //   #285	-> 355
/*     */     //   #563	-> 375
/*     */     //   #564	-> 378
/*     */     //   #564	-> 430
/*     */     //   #286	-> 442
/*     */     //   #287	-> 476
/*     */     //   #286	-> 478
/*     */     //   #290	-> 484
/*     */     //   #291	-> 490
/*     */     //   #293	-> 497
/*     */     //   #294	-> 497
/*     */     //   #295	-> 529
/*     */     //   #296	-> 533
/*     */     //   #295	-> 546
/*     */     //   #293	-> 552
/*     */     //   #299	-> 554
/*     */     //   #299	-> 575
/*     */     //   #300	-> 581
/*     */     //   #301	-> 581
/*     */     //   #302	-> 613
/*     */     //   #303	-> 617
/*     */     //   #302	-> 630
/*     */     //   #300	-> 636
/*     */     //   #306	-> 638
/*     */     //   #307	-> 650
/*     */     //   #309	-> 650
/*     */     //   #565	-> 655
/*     */     //   #311	-> 656
/*     */     //   #315	-> 678
/*     */     //   #316	-> 711
/*     */     //   #317	-> 717
/*     */     //   #316	-> 729
/*     */     //   #319	-> 735
/*     */     //   #316	-> 736
/*     */     //   #321	-> 738
/*     */     //   #566	-> 758
/*     */     //   #567	-> 761
/*     */     //   #567	-> 813
/*     */     //   #322	-> 825
/*     */     //   #323	-> 866
/*     */     //   #324	-> 872
/*     */     //   #326	-> 879
/*     */     //   #327	-> 879
/*     */     //   #326	-> 892
/*     */     //   #330	-> 897
/*     */     //   #332	-> 897
/*     */     //   #331	-> 897
/*     */     //   #330	-> 910
/*     */     //   #334	-> 918
/*     */     //   #335	-> 922
/*     */     //   #337	-> 926
/*     */     //   #339	-> 926
/*     */     //   #568	-> 931
/*     */     //   #341	-> 932
/*     */     //   #345	-> 948
/*     */     //   #569	-> 968
/*     */     //   #570	-> 971
/*     */     //   #570	-> 1023
/*     */     //   #346	-> 1035
/*     */     //   #347	-> 1040
/*     */     //   #349	-> 1056
/*     */     //   #351	-> 1056
/*     */     //   #349	-> 1056
/*     */     //   #350	-> 1093
/*     */     //   #349	-> 1095
/*     */     //   #351	-> 1098
/*     */     //   #353	-> 1108
/*     */     //   #355	-> 1135
/*     */     //   #358	-> 1150
/*     */     //   #571	-> 1155
/*     */     //   #362	-> 1158
/*     */     //   #572	-> 1178
/*     */     //   #573	-> 1181
/*     */     //   #573	-> 1233
/*     */     //   #363	-> 1245
/*     */     //   #364	-> 1250
/*     */     //   #366	-> 1266
/*     */     //   #368	-> 1266
/*     */     //   #366	-> 1266
/*     */     //   #367	-> 1294
/*     */     //   #366	-> 1297
/*     */     //   #368	-> 1308
/*     */     //   #370	-> 1324
/*     */     //   #371	-> 1324
/*     */     //   #372	-> 1359
/*     */     //   #371	-> 1362
/*     */     //   #370	-> 1380
/*     */     //   #375	-> 1382
/*     */     //   #378	-> 1397
/*     */     //   #574	-> 1402
/*     */     //   #382	-> 1405
/*     */     //   #575	-> 1425
/*     */     //   #576	-> 1428
/*     */     //   #576	-> 1480
/*     */     //   #383	-> 1492
/*     */     //   #384	-> 1497
/*     */     //   #386	-> 1513
/*     */     //   #387	-> 1542
/*     */     //   #388	-> 1542
/*     */     //   #387	-> 1580
/*     */     //   #390	-> 1582
/*     */     //   #393	-> 1597
/*     */     //   #577	-> 1602
/*     */     //   #397	-> 1605
/*     */     //   #578	-> 1625
/*     */     //   #579	-> 1628
/*     */     //   #579	-> 1680
/*     */     //   #398	-> 1692
/*     */     //   #399	-> 1697
/*     */     //   #401	-> 1706
/*     */     //   #402	-> 1735
/*     */     //   #403	-> 1735
/*     */     //   #402	-> 1773
/*     */     //   #405	-> 1775
/*     */     //   #408	-> 1790
/*     */     //   #580	-> 1795
/*     */     //   #410	-> 1796
/*     */     //   #412	-> 1796
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   638	12	22	bestDamage	D
/*     */     //   581	69	21	bestStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   554	96	19	currDamage	D
/*     */     //   439	212	17	index	I
/*     */     //   439	212	16	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   442	209	18	$i$a$-forEachIndexed-InvManager$findBetterItem$1	I
/*     */     //   406	246	12	item$iv	Ljava/lang/Object;
/*     */     //   378	278	10	index$iv	I
/*     */     //   372	284	8	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   375	281	9	$i$f$forEachIndexed	I
/*     */     //   355	323	7	bestWeapon	I
/*     */     //   317	361	6	currentTypeChecker	Lkotlin/jvm/functions/Function1;
/*     */     //   897	29	19	power	I
/*     */     //   822	105	17	index	I
/*     */     //   822	105	16	itemStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   825	102	18	$i$a$-forEachIndexed-InvManager$findBetterItem$2	I
/*     */     //   789	139	12	item$iv	Ljava/lang/Object;
/*     */     //   761	171	10	index$iv	I
/*     */     //   755	177	8	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   758	174	9	$i$f$forEachIndexed	I
/*     */     //   738	210	7	bestPower	I
/*     */     //   711	237	6	bestBow	I
/*     */     //   1135	15	18	replaceCurr	Z
/*     */     //   1056	94	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1032	119	15	index	I
/*     */     //   1032	119	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1035	116	16	$i$a$-forEachIndexed-InvManager$findBetterItem$3	I
/*     */     //   999	153	10	item$iv	Ljava/lang/Object;
/*     */     //   971	184	8	index$iv	I
/*     */     //   965	190	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   968	187	7	$i$f$forEachIndexed	I
/*     */     //   1382	15	18	replaceCurr	Z
/*     */     //   1266	131	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1242	156	15	index	I
/*     */     //   1242	156	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1245	153	16	$i$a$-forEachIndexed-InvManager$findBetterItem$4	I
/*     */     //   1209	190	10	item$iv	Ljava/lang/Object;
/*     */     //   1181	221	8	index$iv	I
/*     */     //   1175	227	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1178	224	7	$i$f$forEachIndexed	I
/*     */     //   1582	15	18	replaceCurr	Z
/*     */     //   1513	84	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1489	109	15	index	I
/*     */     //   1489	109	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1492	106	16	$i$a$-forEachIndexed-InvManager$findBetterItem$5	I
/*     */     //   1456	143	10	item$iv	Ljava/lang/Object;
/*     */     //   1428	174	8	index$iv	I
/*     */     //   1422	180	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1425	177	7	$i$f$forEachIndexed	I
/*     */     //   1775	15	18	replaceCurr	Z
/*     */     //   1706	84	17	item	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;
/*     */     //   1689	102	15	index	I
/*     */     //   1689	102	14	stack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1692	99	16	$i$a$-forEachIndexed-InvManager$findBetterItem$6	I
/*     */     //   1656	136	10	item$iv	Ljava/lang/Object;
/*     */     //   1628	168	8	index$iv	I
/*     */     //   1622	174	6	$this$forEachIndexed$iv	Ljava/lang/Iterable;
/*     */     //   1625	171	7	$i$f$forEachIndexed	I
/*     */     //   26	1772	4	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   6	1792	3	type	Ljava/lang/String;
/*     */     //   0	1798	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager;
/*     */     //   0	1798	1	targetSlot	I
/* 437 */     //   0	1798	2	slotStack	Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack; } private final String type(int targetSlot) { switch (targetSlot) { case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 7:
/*     */       
/*     */       case 8:
/* 447 */        }  return ""; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean move(int item, boolean isArmorSlot) {
/* 458 */     if (!isArmorSlot && item < 9 && !MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen())) {
/* 459 */       MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(item));
/* 460 */       MinecraftInstance.mc.getNetHandler().addToSendQueue(
/* 461 */           createUseItemPacket(
/* 462 */             WEnumHand.MAIN_HAND));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 467 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/*     */ 
/*     */       
/* 470 */       this.delay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/* 471 */       return true;
/* 472 */     }  if ((!((Boolean)this.noMoveValue.get()).booleanValue() || !MovementUtils.isMoving()) && (!((Boolean)this.invOpenValue.get()).booleanValue() || MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen())) && item != -1) {
/* 473 */       boolean openInventory = (((Boolean)this.simulateInventory.get()).booleanValue() && !MinecraftInstance.classProvider.isGuiInventory(MinecraftInstance.mc.getCurrentScreen()));
/*     */       
/* 475 */       boolean full = isArmorSlot;
/* 476 */       if (full) {
/* 477 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  for (IItemStack iItemStack : MinecraftInstance.mc.getThePlayer().getInventory().getMainInventory()) {
/* 478 */           if (ItemUtils.isStackEmpty(iItemStack)) {
/* 479 */             full = false;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 484 */       if (full) {
/*     */         
/* 486 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*     */ 
/*     */ 
/*     */         
/* 490 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getPlayerController().windowClick(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(), item, 1, 4, MinecraftInstance.mc.getThePlayer());
/*     */       } else {
/*     */         
/* 493 */         String str = (String)this.swapArmorModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case -995865464:
/* 500 */             if (str.equals("packet")) {
/* 501 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() != null)
/*     */               
/* 503 */               { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*     */ 
/*     */ 
/*     */                 
/* 507 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(isArmorSlot ? item : ((item < 9) ? (item + 36) : item)).getStack() == null) Intrinsics.throwNpe();  IItemStack iItemStack = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getSlot(isArmorSlot ? item : ((item < 9) ? (item + 36) : item)).getStack(); ClickType clickType1 = ClickType.QUICK_MOVE; boolean bool2 = false; int m = isArmorSlot ? item : ((item < 9) ? (item + 36) : item), k = MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(); NetHandlerPlayClient netHandlerPlayClient = MinecraftInstance.mc2.func_147114_u(); int j = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 581 */                 if (iItemStack == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ItemStackImpl");  ItemStack itemStack1 = ((ItemStackImpl)iItemStack).getWrapped(); short s = (short)1; ItemStack itemStack2 = itemStack1; ClickType clickType2 = clickType1; boolean bool3 = bool2; int n = m, i1 = k; netHandlerPlayClient.func_147297_a((Packet)new CPacketClickWindow(i1, n, bool3, clickType2, itemStack2, s)); } else { MinecraftInstance.mc2.func_147114_u(); }  if (MinecraftInstance.mc.getThePlayer() == null)
/* 582 */                 Intrinsics.throwNpe();  IEntityPlayerSP $this$unwrap$iv = MinecraftInstance.mc.getThePlayer(); int $i$f$unwrap = 0; if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>");  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP iEntityPlayerSP1 = MinecraftInstance.mc.getThePlayer(); ClickType clickType = ClickType.QUICK_MOVE; boolean bool1 = false; int i = isArmorSlot ? item : ((item < 9) ? (item + 36) : item); Container container = ((EntityPlayerSP)((EntityPlayerSPImpl)$this$unwrap$iv).getWrapped()).field_71069_bz; $i$f$unwrap = 0;
/* 583 */               if (iEntityPlayerSP1 == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.EntityPlayerSPImpl<*>");  EntityPlayerSP entityPlayerSP = (EntityPlayerSP)((EntityPlayerSPImpl)iEntityPlayerSP1).getWrapped(); container.func_184996_a(i, bool1, clickType, (EntityPlayer)entityPlayerSP);
/*     */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2");
/*     */               if (MinecraftInstance.mc2.func_147114_u() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               MinecraftInstance.mc2.func_147114_u().func_147297_a((Packet)new CPacketConfirmTransaction(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(), (short)1, true));
/*     */             } 
/*     */             break;
/*     */           case 1918230424:
/*     */             if (str.equals("windowclick")) {
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               if (MinecraftInstance.mc.getThePlayer() == null)
/*     */                 Intrinsics.throwNpe(); 
/*     */               MinecraftInstance.mc.getPlayerController().windowClick(MinecraftInstance.mc.getThePlayer().getInventoryContainer().getWindowId(), isArmorSlot ? item : ((item < 9) ? (item + 36) : item), 0, 1, MinecraftInstance.mc.getThePlayer());
/*     */             } 
/*     */             break;
/*     */         } 
/*     */         this.delay = TimeUtils.randomDelay(((Number)this.minDelayValue.get()).intValue(), ((Number)this.maxDelayValue.get()).intValue());
/*     */         if (openInventory)
/*     */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketCloseWindow()); 
/*     */         return true;
/*     */       } 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private final IPacket createUseItemPacket(WEnumHand itemStack) {
/*     */     String str = "Not yet implemented";
/*     */     boolean bool = false;
/*     */     throw (Throwable)new NotImplementedError("An operation is not implemented: " + str);
/*     */   }
/*     */   
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   static {
/*     */     ARMOR_COMPARATOR = new ArmorComparator();
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/InvManager$Companion;", "", "()V", "ARMOR_COMPARATOR", "Lnet/ccbluex/liquidbounce/utils/item/ArmorComparator;", "getARMOR_COMPARATOR", "()Lnet/ccbluex/liquidbounce/utils/item/ArmorComparator;", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {}
/*     */     
/*     */     @NotNull
/*     */     public final ArmorComparator getARMOR_COMPARATOR() {
/*     */       return InvManager.ARMOR_COMPARATOR;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\InvManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */