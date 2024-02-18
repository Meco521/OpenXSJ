/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.init.Items;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "XSJGapple", category = ModuleCategory.HYT, description = "修复版")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\025\032\0020\0262\006\020\027\032\0020\030H\002J\b\020\031\032\0020\026H\026J\022\020\032\032\0020\0262\b\020\033\032\004\030\0010\034H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\013\020\fR\016\020\r\032\0020\016X\004¢\006\002\n\000R\024\020\017\032\0020\0208VX\004¢\006\006\032\004\b\021\020\022R\016\020\023\032\0020\024X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytGapple;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "eating", "", "healthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "noAbsorption", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "doEat", "", "warn", "", "onEnable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class HytGapple extends Module {
/*    */   @NotNull
/* 23 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Auto", "LegitAuto", "Once", "XSJ" }, "XSJ"); @NotNull public final ListValue getModeValue() { return this.modeValue; }
/*    */   
/* 25 */   private final FloatValue healthValue = new FloatValue("Health", 10.0F, 1.0F, 20.0F);
/* 26 */   private final IntegerValue delayValue = new IntegerValue("Delay", 150, 0, 1000);
/* 27 */   private final BoolValue noAbsorption = new BoolValue("NoAbsorption", true);
/* 28 */   private final MSTimer timer = new MSTimer();
/*    */   
/* 30 */   private int eating = -1;
/*    */   
/*    */   public void onEnable() {
/* 33 */     this.eating = -1;
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 38 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*    */ 
/*    */ 
/*    */       
/*    */       case 3005871:
/* 43 */         if (str.equals("auto"))
/* 44 */         { if (!this.timer.hasTimePassed(((Number)this.delayValue.get()).intValue()))
/*    */             return; 
/* 46 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() <= ((Number)this.healthValue.get()).floatValue())
/* 47 */           { doEat(false);
/* 48 */             this.timer.reset(); }  }  break;
/*    */       case 3415681: if (str.equals("once")) { doEat(true); setState(false); }  break;
/*    */       case -1961575192:
/* 51 */         if (str.equals("legitauto")) {
/* 52 */           if (this.eating == -1) {
/* 53 */             int gappleInHotbar = InventoryUtils.findItem2(36, 45, Items.field_151153_ao);
/* 54 */             if (gappleInHotbar == -1)
/* 55 */               return;  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(gappleInHotbar - 36));
/* 56 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketPlayerBlockPlacement(MinecraftInstance.mc.getThePlayer().getHeldItem()));
/* 57 */             this.eating = 0; break;
/* 58 */           }  if (this.eating > 35)
/* 59 */           { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/* 60 */             this.timer.reset(); } 
/*    */         }  break;
/*    */       case 87215:
/* 63 */         if (str.equals("XSJ")) {
/* 64 */           if (!this.timer.hasTimePassed(((Number)this.delayValue.get()).intValue()))
/*    */             return; 
/* 66 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() <= ((Number)this.healthValue.get()).floatValue()) {
/* 67 */             int headInHotbar = InventoryUtils.findItem(36, 45, MinecraftInstance.classProvider.getItemEnum(ItemType.SKULL));
/* 68 */             if (headInHotbar != -1) {
/* 69 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(headInHotbar - 36));
/* 70 */               MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.OFF_HAND));
/* 71 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/* 72 */               this.timer.reset();
/*    */             } 
/*    */           } 
/*    */         } 
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final void doEat(boolean warn) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield noAbsorption : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*    */     //   4: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   7: checkcast java/lang/Boolean
/*    */     //   10: invokevirtual booleanValue : ()Z
/*    */     //   13: ifeq -> 59
/*    */     //   16: iload_1
/*    */     //   17: ifne -> 59
/*    */     //   20: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
/*    */     //   23: getfield field_71439_g : Lnet/minecraft/client/entity/EntityPlayerSP;
/*    */     //   26: dup
/*    */     //   27: ldc_w 'Minecraft.getMinecraft().player'
/*    */     //   30: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   33: invokevirtual func_110139_bj : ()F
/*    */     //   36: f2d
/*    */     //   37: ldc2_w 10.0
/*    */     //   40: dmul
/*    */     //   41: ldc_w 10.0
/*    */     //   44: f2d
/*    */     //   45: ddiv
/*    */     //   46: invokestatic round : (D)J
/*    */     //   49: l2f
/*    */     //   50: fstore_2
/*    */     //   51: fload_2
/*    */     //   52: iconst_0
/*    */     //   53: i2f
/*    */     //   54: fcmpl
/*    */     //   55: ifle -> 59
/*    */     //   58: return
/*    */     //   59: bipush #36
/*    */     //   61: bipush #45
/*    */     //   63: getstatic net/minecraft/init/Items.field_151153_ao : Lnet/minecraft/item/Item;
/*    */     //   66: invokestatic findItem2 : (IILnet/minecraft/item/Item;)I
/*    */     //   69: istore_2
/*    */     //   70: iload_2
/*    */     //   71: iconst_m1
/*    */     //   72: if_icmpeq -> 279
/*    */     //   75: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   78: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   83: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   86: iload_2
/*    */     //   87: bipush #36
/*    */     //   89: isub
/*    */     //   90: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*    */     //   95: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   98: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   103: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   106: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   111: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   114: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   117: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   122: dup
/*    */     //   123: ifnonnull -> 129
/*    */     //   126: invokestatic throwNpe : ()V
/*    */     //   129: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*    */     //   134: invokeinterface createCPacketPlayerBlockPlacement : (Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerBlockPlacement;
/*    */     //   139: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   142: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   147: bipush #35
/*    */     //   149: istore_3
/*    */     //   150: iconst_0
/*    */     //   151: istore #4
/*    */     //   153: iconst_0
/*    */     //   154: istore #5
/*    */     //   156: iconst_0
/*    */     //   157: istore #5
/*    */     //   159: iload_3
/*    */     //   160: istore #6
/*    */     //   162: iload #5
/*    */     //   164: iload #6
/*    */     //   166: if_icmpge -> 227
/*    */     //   169: iload #5
/*    */     //   171: istore #7
/*    */     //   173: iconst_0
/*    */     //   174: istore #8
/*    */     //   176: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   179: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   184: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   187: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   190: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   195: dup
/*    */     //   196: ifnonnull -> 202
/*    */     //   199: invokestatic throwNpe : ()V
/*    */     //   202: invokeinterface getOnGround : ()Z
/*    */     //   207: invokeinterface createCPacketPlayer : (Z)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayer;
/*    */     //   212: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   215: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   220: nop
/*    */     //   221: iinc #5, 1
/*    */     //   224: goto -> 162
/*    */     //   227: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   230: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*    */     //   235: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   238: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*    */     //   241: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*    */     //   246: dup
/*    */     //   247: ifnonnull -> 253
/*    */     //   250: invokestatic throwNpe : ()V
/*    */     //   253: invokeinterface getInventory : ()Lnet/ccbluex/liquidbounce/api/minecraft/entity/player/IInventoryPlayer;
/*    */     //   258: invokeinterface getCurrentItem : ()I
/*    */     //   263: invokeinterface createCPacketHeldItemChange : (I)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketHeldItemChange;
/*    */     //   268: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*    */     //   271: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*    */     //   276: goto -> 280
/*    */     //   279: nop
/*    */     //   280: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #80	-> 0
/*    */     //   #81	-> 20
/*    */     //   #82	-> 51
/*    */     //   #83	-> 58
/*    */     //   #86	-> 59
/*    */     //   #87	-> 70
/*    */     //   #88	-> 75
/*    */     //   #89	-> 103
/*    */     //   #90	-> 147
/*    */     //   #91	-> 176
/*    */     //   #92	-> 220
/*    */     //   #90	-> 221
/*    */     //   #93	-> 227
/*    */     //   #94	-> 279
/*    */     //   #95	-> 280
/*    */     //   #96	-> 280
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   51	8	2	abAmount	F
/*    */     //   173	47	7	it	I
/*    */     //   176	44	8	$i$a$-repeat-HytGapple$doEat$1	I
/*    */     //   70	211	2	gappleInHotbar	I
/*    */     //   0	281	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytGapple;
/*    */     //   0	281	1	warn	Z
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public String getTag() {
/* 99 */     return (String)this.modeValue.get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytGapple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */