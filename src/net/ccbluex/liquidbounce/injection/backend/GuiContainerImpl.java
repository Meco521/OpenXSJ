/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.ccbluex.liquidbounce.api.minecraft.inventory.ISlot;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\b\026\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\0032\0020\004B\r\022\006\020\005\032\0028\000¢\006\002\020\006J(\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0202\006\020\022\032\0020\020H\026R\026\020\007\032\004\030\0010\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GuiContainerImpl;", "T", "Lnet/minecraft/client/gui/inventory/GuiContainer;", "Lnet/ccbluex/liquidbounce/injection/backend/GuiScreenImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/inventory/IGuiContainer;", "wrapped", "(Lnet/minecraft/client/gui/inventory/GuiContainer;)V", "inventorySlots", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "getInventorySlots", "()Lnet/ccbluex/liquidbounce/api/minecraft/inventory/IContainer;", "handleMouseClick", "", "slot", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "slotNumber", "", "clickedButton", "clickType", "XSJClient"})
/*    */ public class GuiContainerImpl<T extends GuiContainer> extends GuiScreenImpl<T> implements IGuiContainer {
/* 11 */   public GuiContainerImpl(@NotNull GuiContainer wrapped) { super((T)wrapped); }
/*    */    @Nullable
/*    */   public IContainer getInventorySlots() {
/* 14 */     Container $this$wrap$iv = ((GuiContainer)getWrapped()).field_147002_h; int $i$f$wrap = 0; return (((GuiContainer)getWrapped()).field_147002_h != null) ? 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 29 */       new ContainerImpl($this$wrap$iv) : null;
/*    */   }
/*    */   
/*    */   public void handleMouseClick(@NotNull ISlot slot, int slotNumber, int clickedButton, int clickType) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'slot'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: invokevirtual getWrapped : ()Lnet/minecraft/client/gui/Gui;
/*    */     //   10: dup
/*    */     //   11: ifnonnull -> 24
/*    */     //   14: new kotlin/TypeCastException
/*    */     //   17: dup
/*    */     //   18: ldc 'null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.implementations.IMixinGuiContainer'
/*    */     //   20: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   23: athrow
/*    */     //   24: checkcast net/ccbluex/liquidbounce/injection/implementations/IMixinGuiContainer
/*    */     //   27: aload_1
/*    */     //   28: astore #5
/*    */     //   30: astore #7
/*    */     //   32: iconst_0
/*    */     //   33: istore #6
/*    */     //   35: aload #5
/*    */     //   37: checkcast net/ccbluex/liquidbounce/injection/backend/SlotImpl
/*    */     //   40: invokevirtual getWrapped : ()Lnet/minecraft/inventory/Slot;
/*    */     //   43: astore #8
/*    */     //   45: aload #7
/*    */     //   47: aload #8
/*    */     //   49: iload_2
/*    */     //   50: iload_3
/*    */     //   51: iload #4
/*    */     //   53: istore #5
/*    */     //   55: istore #10
/*    */     //   57: istore #9
/*    */     //   59: astore #8
/*    */     //   61: astore #7
/*    */     //   63: iconst_0
/*    */     //   64: istore #6
/*    */     //   66: iload #5
/*    */     //   68: tableswitch default -> 154, 0 -> 112, 1 -> 118, 2 -> 124, 3 -> 130, 4 -> 136, 5 -> 142, 6 -> 148
/*    */     //   112: getstatic net/minecraft/inventory/ClickType.PICKUP : Lnet/minecraft/inventory/ClickType;
/*    */     //   115: goto -> 185
/*    */     //   118: getstatic net/minecraft/inventory/ClickType.QUICK_MOVE : Lnet/minecraft/inventory/ClickType;
/*    */     //   121: goto -> 185
/*    */     //   124: getstatic net/minecraft/inventory/ClickType.SWAP : Lnet/minecraft/inventory/ClickType;
/*    */     //   127: goto -> 185
/*    */     //   130: getstatic net/minecraft/inventory/ClickType.CLONE : Lnet/minecraft/inventory/ClickType;
/*    */     //   133: goto -> 185
/*    */     //   136: getstatic net/minecraft/inventory/ClickType.THROW : Lnet/minecraft/inventory/ClickType;
/*    */     //   139: goto -> 185
/*    */     //   142: getstatic net/minecraft/inventory/ClickType.QUICK_CRAFT : Lnet/minecraft/inventory/ClickType;
/*    */     //   145: goto -> 185
/*    */     //   148: getstatic net/minecraft/inventory/ClickType.PICKUP_ALL : Lnet/minecraft/inventory/ClickType;
/*    */     //   151: goto -> 185
/*    */     //   154: new java/lang/IllegalArgumentException
/*    */     //   157: dup
/*    */     //   158: new java/lang/StringBuilder
/*    */     //   161: dup
/*    */     //   162: invokespecial <init> : ()V
/*    */     //   165: ldc 'Invalid mode '
/*    */     //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   170: iload #5
/*    */     //   172: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   175: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   178: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   181: checkcast java/lang/Throwable
/*    */     //   184: athrow
/*    */     //   185: astore #11
/*    */     //   187: aload #7
/*    */     //   189: aload #8
/*    */     //   191: iload #9
/*    */     //   193: iload #10
/*    */     //   195: aload #11
/*    */     //   197: invokeinterface publicHandleMouseClick : (Lnet/minecraft/inventory/Slot;IILnet/minecraft/inventory/ClickType;)V
/*    */     //   202: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 6
/*    */     //   #19	-> 35
/*    */     //   #12	-> 49
/*    */     //   #20	-> 66
/*    */     //   #21	-> 112
/*    */     //   #22	-> 118
/*    */     //   #23	-> 124
/*    */     //   #24	-> 130
/*    */     //   #25	-> 136
/*    */     //   #26	-> 142
/*    */     //   #27	-> 148
/*    */     //   #28	-> 154
/*    */     //   #12	-> 197
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   32	11	5	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*    */     //   35	8	6	$i$f$unwrap	I
/*    */     //   63	122	5	$this$toClickType$iv	I
/*    */     //   66	119	6	$i$f$toClickType	I
/*    */     //   0	203	0	this	Lnet/ccbluex/liquidbounce/injection/backend/GuiContainerImpl;
/*    */     //   0	203	1	slot	Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;
/*    */     //   0	203	2	slotNumber	I
/*    */     //   0	203	3	clickedButton	I
/*    */     //   0	203	4	clickType	I
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GuiContainerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */