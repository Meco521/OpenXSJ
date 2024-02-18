/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.enchantments.IEnchantment;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.entity.ai.attributes.IAttributeModifier;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTBase;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.nbt.INBTTagCompound;
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000v\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\b\n\002\020\t\n\002\b\t\n\002\030\002\n\002\b\n\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\036\n\002\030\002\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\003\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\030\020/\032\002002\006\0201\032\002022\006\0203\032\0020\006H\026J\026\0204\032\b\022\004\022\00206052\006\0207\032\0020\nH\026J\020\0208\032\002092\006\020:\032\0020;H\026J\b\020<\032\0020=H\026J\020\020>\032\0020\0012\006\020\t\032\0020\nH\026J\030\020?\032\002002\006\0207\032\0020\n2\006\020@\032\0020AH\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\0020\n8VX\004¢\006\006\032\004\b\013\020\fR\026\020\r\032\004\030\0010\0168VX\004¢\006\006\032\004\b\017\020\020R\026\020\021\032\004\030\0010\0228VX\004¢\006\006\032\004\b\023\020\024R$\020\026\032\0020\0062\006\020\025\032\0020\0068V@VX\016¢\006\f\032\004\b\027\020\b\"\004\b\030\020\031R\024\020\032\032\0020\0338VX\004¢\006\006\032\004\b\034\020\035R$\020\036\032\0020\0062\006\020\025\032\0020\0068V@VX\016¢\006\f\032\004\b\037\020\b\"\004\b \020\031R\024\020!\032\0020\0068VX\004¢\006\006\032\004\b\"\020\bR\024\020#\032\0020\0068VX\004¢\006\006\032\004\b$\020\bR(\020&\032\004\030\0010%2\b\020\025\032\004\030\0010%8V@VX\016¢\006\f\032\004\b'\020(\"\004\b)\020*R\024\020+\032\0020\n8VX\004¢\006\006\032\004\b,\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b-\020.¨\006B"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ItemStackImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "wrapped", "Lnet/minecraft/item/ItemStack;", "(Lnet/minecraft/item/ItemStack;)V", "animationsToGo", "", "getAnimationsToGo", "()I", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "enchantmentTagList", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "getEnchantmentTagList", "()Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagList;", "item", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getItem", "()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "value", "itemDamage", "getItemDamage", "setItemDamage", "(I)V", "itemDelay", "", "getItemDelay", "()J", "maxDamage", "getMaxDamage", "setMaxDamage", "maxItemUseDuration", "getMaxItemUseDuration", "stackSize", "getStackSize", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "tagCompound", "getTagCompound", "()Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;", "setTagCompound", "(Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTTagCompound;)V", "unlocalizedName", "getUnlocalizedName", "getWrapped", "()Lnet/minecraft/item/ItemStack;", "addEnchantment", "", "enchantment", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "level", "getAttributeModifier", "", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/ai/attributes/IAttributeModifier;", "key", "getStrVsBlock", "", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/block/state/IIBlockState;", "isSplash", "", "setStackDisplayName", "setTagInfo", "nbt", "Lnet/ccbluex/liquidbounce/api/minecraft/nbt/INBTBase;", "XSJClient"})
/*    */ public final class ItemStackImpl implements IItemStack {
/*    */   @NotNull
/*    */   private final ItemStack wrapped;
/*    */   
/*    */   @NotNull
/* 19 */   public final ItemStack getWrapped() { return this.wrapped; } public ItemStackImpl(@NotNull ItemStack wrapped) { this.wrapped = wrapped; }
/* 20 */   public float getStrVsBlock(@NotNull IIBlockState block) { Intrinsics.checkParameterIsNotNull(block, "block"); IIBlockState iIBlockState = block; ItemStack itemStack = this.wrapped; int $i$f$unwrap = 0;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 69 */     IBlockState iBlockState = ((IBlockStateImpl)iIBlockState).getWrapped(); return itemStack.func_150997_a(iBlockState); } public void setTagInfo(@NotNull String key, @NotNull INBTBase nbt) { Intrinsics.checkParameterIsNotNull(key, "key"); Intrinsics.checkParameterIsNotNull(nbt, "nbt"); INBTBase iNBTBase = nbt; String str = key; ItemStack itemStack = this.wrapped; int $i$f$unwrap = 0;
/* 70 */     NBTBase nBTBase = (NBTBase)((NBTBaseImpl<Object>)iNBTBase).getWrapped(); itemStack.func_77983_a(str, nBTBase); } @NotNull public IItemStack setStackDisplayName(@NotNull String displayName) { Intrinsics.checkParameterIsNotNull(displayName, "displayName"); Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_151001_c(displayName), "wrapped.setStackDisplayName(displayName)"); ItemStack $this$wrap$iv = this.wrapped.func_151001_c(displayName); int $i$f$wrap = 0;
/* 71 */     return new ItemStackImpl($this$wrap$iv); } public void addEnchantment(@NotNull IEnchantment enchantment, int level) { Intrinsics.checkParameterIsNotNull(enchantment, "enchantment"); IEnchantment iEnchantment = enchantment; ItemStack itemStack = this.wrapped; int $i$f$unwrap = 0;
/* 72 */     Enchantment enchantment1 = ((EnchantmentImpl)iEnchantment).getWrapped(); itemStack.func_77966_a(enchantment1, level); }
/* 73 */   @NotNull public Collection<IAttributeModifier> getAttributeModifier(@NotNull String key) { Intrinsics.checkParameterIsNotNull(key, "key"); return (Collection<IAttributeModifier>)new WrappedCollection(this.wrapped.func_111283_C(EntityEquipmentSlot.MAINHAND).get(key), ItemStackImpl$getAttributeModifier$1.INSTANCE, ItemStackImpl$getAttributeModifier$2.INSTANCE); } public boolean isSplash() { return Intrinsics.areEqual(this.wrapped.func_77973_b(), Items.field_185155_bH); } @NotNull public String getDisplayName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_82833_r(), "wrapped.displayName"); return this.wrapped.func_82833_r(); } @Nullable public INBTTagList getEnchantmentTagList() { NBTTagList $this$wrap$iv = this.wrapped.func_77986_q(); int $i$f$wrap = 0; this.wrapped.func_77986_q(); return (this.wrapped.func_77986_q() != null) ? new NBTTagListImpl($this$wrap$iv) : null; }
/* 74 */   public int getAnimationsToGo() { return this.wrapped.func_190921_D(); } @NotNull public String getUnlocalizedName() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_77977_a(), "wrapped.unlocalizedName"); return this.wrapped.func_77977_a(); } public int getMaxItemUseDuration() { return this.wrapped.func_77988_m(); } @Nullable public INBTTagCompound getTagCompound() { NBTTagCompound $this$wrap$iv = this.wrapped.func_77978_p(); int $i$f$wrap = 0; this.wrapped.func_77978_p(); return (this.wrapped.func_77978_p() != null) ? new NBTTagCompoundImpl($this$wrap$iv) : null; } public void setTagCompound(@Nullable INBTTagCompound value) { INBTTagCompound iNBTTagCompound = value; ItemStack itemStack = this.wrapped; int $i$f$unwrap = 0;
/* 75 */     if (iNBTTagCompound == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.NBTTagCompoundImpl");  NBTTagCompound nBTTagCompound = ((NBTTagCompoundImpl)iNBTTagCompound).getWrapped(); this.wrapped.func_77982_d((value != null) ? nBTTagCompound : null); } public int getMaxDamage() { return this.wrapped.func_77958_k(); } public void setMaxDamage(int value) {} public int getStackSize() { return this.wrapped.field_77994_a; } public int getItemDamage() { return this.wrapped.func_77952_i(); } public void setItemDamage(int value) { this.wrapped.func_77964_b(value); }
/* 76 */   @Nullable public IItem getItem() { Item $this$wrap$iv = this.wrapped.func_77973_b(); int $i$f$wrap = 0; this.wrapped.func_77973_b(); return (this.wrapped.func_77973_b() != null) ? new ItemImpl<>($this$wrap$iv) : null; }
/*    */ 
/*    */   
/*    */   public long getItemDelay() {
/*    */     if (this.wrapped == null)
/*    */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.implementations.IMixinItemStack"); 
/*    */     return ((IMixinItemStack)this.wrapped).getItemDelay();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ItemStackImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */