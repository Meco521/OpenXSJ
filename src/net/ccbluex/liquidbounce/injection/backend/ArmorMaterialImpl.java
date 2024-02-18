/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import net.minecraft.item.ItemArmor;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\002\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\020\013\032\0020\f2\b\020\r\032\004\030\0010\016H\002J\020\020\017\032\0020\0062\006\020\020\032\0020\006H\026J\020\020\021\032\0020\0062\006\020\020\032\0020\006H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ArmorMaterialImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/minecraft/IArmorMaterial;", "wrapped", "Lnet/minecraft/item/ItemArmor$ArmorMaterial;", "(Lnet/minecraft/item/ItemArmor$ArmorMaterial;)V", "enchantability", "", "getEnchantability", "()I", "getWrapped", "()Lnet/minecraft/item/ItemArmor$ArmorMaterial;", "equals", "", "other", "", "getDamageReductionAmount", "type", "getDurability", "XSJClient"})
/*    */ public final class ArmorMaterialImpl implements IArmorMaterial {
/*    */   @NotNull
/*  8 */   public final ItemArmor.ArmorMaterial getWrapped() { return this.wrapped; } @NotNull private final ItemArmor.ArmorMaterial wrapped; public ArmorMaterialImpl(@NotNull ItemArmor.ArmorMaterial wrapped) { this.wrapped = wrapped; }
/*    */    public int getEnchantability() {
/* 10 */     return this.wrapped.func_78045_a();
/*    */   } public int getDamageReductionAmount(int type) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield wrapped : Lnet/minecraft/item/ItemArmor$ArmorMaterial;
/*    */     //   4: iload_1
/*    */     //   5: istore_2
/*    */     //   6: astore #4
/*    */     //   8: iconst_0
/*    */     //   9: istore_3
/*    */     //   10: iload_2
/*    */     //   11: tableswitch default -> 84, 0 -> 48, 1 -> 54, 2 -> 60, 3 -> 66, 4 -> 72, 5 -> 78
/*    */     //   48: getstatic net/minecraft/inventory/EntityEquipmentSlot.FEET : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   51: goto -> 114
/*    */     //   54: getstatic net/minecraft/inventory/EntityEquipmentSlot.LEGS : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   57: goto -> 114
/*    */     //   60: getstatic net/minecraft/inventory/EntityEquipmentSlot.CHEST : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   63: goto -> 114
/*    */     //   66: getstatic net/minecraft/inventory/EntityEquipmentSlot.HEAD : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   69: goto -> 114
/*    */     //   72: getstatic net/minecraft/inventory/EntityEquipmentSlot.MAINHAND : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   75: goto -> 114
/*    */     //   78: getstatic net/minecraft/inventory/EntityEquipmentSlot.OFFHAND : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   81: goto -> 114
/*    */     //   84: new java/lang/IllegalArgumentException
/*    */     //   87: dup
/*    */     //   88: new java/lang/StringBuilder
/*    */     //   91: dup
/*    */     //   92: invokespecial <init> : ()V
/*    */     //   95: ldc 'Invalid armorType '
/*    */     //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   100: iload_2
/*    */     //   101: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   104: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   107: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   110: checkcast java/lang/Throwable
/*    */     //   113: athrow
/*    */     //   114: astore #5
/*    */     //   116: aload #4
/*    */     //   118: aload #5
/*    */     //   120: invokevirtual func_78044_b : (Lnet/minecraft/inventory/EntityEquipmentSlot;)I
/*    */     //   123: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     //   #24	-> 10
/*    */     //   #25	-> 48
/*    */     //   #26	-> 54
/*    */     //   #27	-> 60
/*    */     //   #28	-> 66
/*    */     //   #29	-> 72
/*    */     //   #30	-> 78
/*    */     //   #31	-> 84
/*    */     //   #12	-> 120
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   8	106	2	$this$toEntityEquipmentSlot$iv	I
/*    */     //   10	104	3	$i$f$toEntityEquipmentSlot	I
/*    */     //   0	124	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ArmorMaterialImpl;
/*    */     //   0	124	1	type	I
/*    */   }
/*    */   public int getDurability(int type) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield wrapped : Lnet/minecraft/item/ItemArmor$ArmorMaterial;
/*    */     //   4: iload_1
/*    */     //   5: istore_2
/*    */     //   6: astore #4
/*    */     //   8: iconst_0
/*    */     //   9: istore_3
/*    */     //   10: iload_2
/*    */     //   11: tableswitch default -> 84, 0 -> 48, 1 -> 54, 2 -> 60, 3 -> 66, 4 -> 72, 5 -> 78
/*    */     //   48: getstatic net/minecraft/inventory/EntityEquipmentSlot.FEET : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   51: goto -> 114
/*    */     //   54: getstatic net/minecraft/inventory/EntityEquipmentSlot.LEGS : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   57: goto -> 114
/*    */     //   60: getstatic net/minecraft/inventory/EntityEquipmentSlot.CHEST : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   63: goto -> 114
/*    */     //   66: getstatic net/minecraft/inventory/EntityEquipmentSlot.HEAD : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   69: goto -> 114
/*    */     //   72: getstatic net/minecraft/inventory/EntityEquipmentSlot.MAINHAND : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   75: goto -> 114
/*    */     //   78: getstatic net/minecraft/inventory/EntityEquipmentSlot.OFFHAND : Lnet/minecraft/inventory/EntityEquipmentSlot;
/*    */     //   81: goto -> 114
/*    */     //   84: new java/lang/IllegalArgumentException
/*    */     //   87: dup
/*    */     //   88: new java/lang/StringBuilder
/*    */     //   91: dup
/*    */     //   92: invokespecial <init> : ()V
/*    */     //   95: ldc 'Invalid armorType '
/*    */     //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   100: iload_2
/*    */     //   101: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*    */     //   104: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   107: invokespecial <init> : (Ljava/lang/String;)V
/*    */     //   110: checkcast java/lang/Throwable
/*    */     //   113: athrow
/*    */     //   114: astore #5
/*    */     //   116: aload #4
/*    */     //   118: aload #5
/*    */     //   120: invokevirtual func_78046_a : (Lnet/minecraft/inventory/EntityEquipmentSlot;)I
/*    */     //   123: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #15	-> 0
/*    */     //   #32	-> 10
/*    */     //   #33	-> 48
/*    */     //   #34	-> 54
/*    */     //   #35	-> 60
/*    */     //   #36	-> 66
/*    */     //   #37	-> 72
/*    */     //   #38	-> 78
/*    */     //   #39	-> 84
/*    */     //   #15	-> 120
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   8	106	2	$this$toEntityEquipmentSlot$iv	I
/*    */     //   10	104	3	$i$f$toEntityEquipmentSlot	I
/*    */     //   0	124	0	this	Lnet/ccbluex/liquidbounce/injection/backend/ArmorMaterialImpl;
/*    */     //   0	124	1	type	I
/*    */   }
/*    */   public boolean equals(@Nullable Object other) {
/* 18 */     return (other instanceof ArmorMaterialImpl && ((ArmorMaterialImpl)other).wrapped == this.wrapped);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ArmorMaterialImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */