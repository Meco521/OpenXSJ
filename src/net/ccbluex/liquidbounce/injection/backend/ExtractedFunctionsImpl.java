/*     */ package net.ccbluex.liquidbounce.injection.backend;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Collection;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.FunctionReference;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Reflection;
/*     */ import kotlin.reflect.KDeclarationContainer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.entity.IEnumCreatureAttribute;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.inventory.ISlot;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.scoreboard.ITeam;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.tileentity.ITileEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedCollection;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.registry.RegistryNamespaced;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\020\016\n\002\b\002\n\002\020\021\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\003\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\004\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J \020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\006H\026J\b\020\f\032\0020\rH\026J\b\020\016\032\0020\rH\026J\b\020\017\032\0020\rH\026J)\020\020\032\0020\0212\006\020\022\032\0020\0212\022\020\023\032\n\022\006\b\001\022\0020\0210\024\"\0020\021H\026¢\006\002\020\025J\022\020\026\032\004\030\0010\0272\006\020\030\032\0020\031H\026J\022\020\032\032\004\030\0010\0272\006\020\033\032\0020\021H\026J\016\020\034\032\b\022\004\022\0020\0360\035H\026J\022\020\037\032\004\030\0010 2\006\020!\032\0020\031H\026J\022\020\"\032\004\030\0010 2\006\020#\032\0020\021H\026J\016\020$\032\b\022\004\022\0020\0360\035H\026J\020\020%\032\0020\0312\006\020&\032\0020\027H\026J\020\020'\032\0020\0312\006\020(\032\0020)H\026J\022\020*\032\004\030\0010)2\006\020\030\032\0020\031H\026J\022\020+\032\004\030\0010)2\006\020\033\032\0020\021H\026J\016\020,\032\b\022\004\022\0020\0360\035H\026J\032\020-\032\0020.2\b\020/\032\004\030\0010\n2\006\0200\032\00201H\026J\022\0202\032\004\030\0010)2\006\0203\032\0020\036H\026J\020\0204\032\002052\006\0206\032\0020\031H\026J\020\0207\032\002082\006\0209\032\0020\021H\026J \020:\032\0020\r2\006\020;\032\0020<2\006\020=\032\0020.2\006\020>\032\0020\031H\026J\032\020?\032\0020\0212\b\020@\032\004\030\0010A2\006\020B\032\0020\021H\026J \020C\032\0020\r2\006\020D\032\0020E2\006\020F\032\0020\0212\006\020G\032\0020\021H\026J\b\020H\032\0020\rH\026J\b\020I\032\0020\rH\026R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000¨\006J"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/ExtractedFunctionsImpl;", "Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;", "()V", "fastRenderField", "Ljava/lang/reflect/Field;", "canAddItemToSlot", "", "slotIn", "Lnet/ccbluex/liquidbounce/api/minecraft/inventory/ISlot;", "stack", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "stackSizeMatters", "disableFastRender", "", "disableStandardItemLighting", "enableStandardItemLighting", "formatI18n", "", "key", "values", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getBlockById", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "id", "", "getBlockFromName", "name", "getBlockRegistryKeys", "", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "getEnchantmentById", "Lnet/ccbluex/liquidbounce/api/minecraft/enchantments/IEnchantment;", "enchantID", "getEnchantmentByLocation", "location", "getEnchantments", "getIdFromBlock", "block", "getIdFromItem", "sb", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getItemById", "getItemByName", "getItemRegistryKeys", "getModifierForCreature", "", "heldItem", "creatureAttribute", "Lnet/ccbluex/liquidbounce/api/minecraft/entity/IEnumCreatureAttribute;", "getObjectFromItemRegistry", "res", "getPotionById", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "potionID", "jsonToComponent", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;", "toString", "renderTileEntity", "tileEntity", "Lnet/ccbluex/liquidbounce/api/minecraft/tileentity/ITileEntity;", "partialTicks", "destroyStage", "scoreboardFormatPlayerName", "scorePlayerTeam", "Lnet/ccbluex/liquidbounce/api/minecraft/scoreboard/ITeam;", "playerName", "sessionServiceJoinServer", "profile", "Lcom/mojang/authlib/GameProfile;", "token", "sessionHash", "setActiveTextureDefaultTexUnit", "setActiveTextureLightMapTexUnit", "XSJClient"})
/*     */ public final class ExtractedFunctionsImpl implements IExtractedFunctions {
/*     */   private static Field fastRenderField;
/*     */   public static final ExtractedFunctionsImpl INSTANCE;
/*     */   
/*     */   static {
/*  40 */     ExtractedFunctionsImpl extractedFunctionsImpl = new ExtractedFunctionsImpl();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  45 */       Field declaredField = GameSettings.class.getDeclaredField("ofFastRender");
/*     */       
/*  47 */       fastRenderField = declaredField;
/*     */       
/*  49 */       Intrinsics.checkExpressionValueIsNotNull(declaredField, "declaredField"); if (!declaredField.isAccessible())
/*  50 */         declaredField.setAccessible(true); 
/*  51 */     } catch (NoSuchFieldException noSuchFieldException) {}
/*     */   }
/*     */   @Nullable
/*     */   public IBlock getBlockById(int id) {
/*  55 */     if (Block.func_149729_e(id) != null) { Block block1 = Block.func_149729_e(id); boolean bool1 = false, bool2 = false; Block p1 = block1; int $i$a$-unknown-ExtractedFunctionsImpl$getBlockById$1 = 0; } else { new BlockImpl(p1); }  return (IBlock)null;
/*     */   }
/*  57 */   public int getIdFromBlock(@NotNull IBlock block) { Intrinsics.checkParameterIsNotNull(block, "block"); IBlock $this$unwrap$iv = block; int $i$f$unwrap = 0; return Block.func_149682_b((
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 116 */         (BlockImpl)$this$unwrap$iv).getWrapped()); } public float getModifierForCreature(@Nullable IItemStack heldItem, @NotNull IEnumCreatureAttribute creatureAttribute) { Intrinsics.checkParameterIsNotNull(creatureAttribute, "creatureAttribute"); IItemStack $this$unwrap$iv = heldItem; int $i$f$unwrap = 0;
/* 117 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.ItemStackImpl");  IEnumCreatureAttribute iEnumCreatureAttribute = creatureAttribute; ItemStack itemStack = (heldItem != null) ? ((ItemStackImpl)$this$unwrap$iv).getWrapped() : null; $i$f$unwrap = 0;
/* 118 */     EnumCreatureAttribute enumCreatureAttribute = ((EnumCreatureAttributeImpl)iEnumCreatureAttribute).getWrapped(); return EnchantmentHelper.func_152377_a(itemStack, enumCreatureAttribute); } @Nullable public IItem getObjectFromItemRegistry(@NotNull IResourceLocation res) { Intrinsics.checkParameterIsNotNull(res, "res"); IResourceLocation iResourceLocation = res; RegistryNamespaced registryNamespaced = Item.field_150901_e; int $i$f$unwrap = 0;
/* 119 */     ResourceLocation resourceLocation = ((ResourceLocationImpl)iResourceLocation).getWrapped(); Item $this$wrap$iv = (Item)registryNamespaced.func_82594_a(resourceLocation); int $i$f$wrap = 0; (Item)registryNamespaced.func_82594_a(resourceLocation); return ((Item)registryNamespaced.func_82594_a(resourceLocation) != null) ? 
/* 120 */       new ItemImpl<>($this$wrap$iv) : null; } public void renderTileEntity(@NotNull ITileEntity tileEntity, float partialTicks, int destroyStage) { Intrinsics.checkParameterIsNotNull(tileEntity, "tileEntity"); ITileEntity iTileEntity = tileEntity; TileEntityRendererDispatcher tileEntityRendererDispatcher = TileEntityRendererDispatcher.field_147556_a; int $i$f$unwrap = 0;
/* 121 */     TileEntity tileEntity1 = ((TileEntityImpl)iTileEntity).getWrapped(); tileEntityRendererDispatcher.func_180546_a(tileEntity1, partialTicks, destroyStage); } @Nullable public IBlock getBlockFromName(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); Block $this$wrap$iv = Block.func_149684_b(name); int $i$f$wrap = 0; Block.func_149684_b(name);
/* 122 */     return (Block.func_149684_b(name) != null) ? new BlockImpl($this$wrap$iv) : null; } @Nullable public IItem getItemByName(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); if (Items.class.getField(name).get(null) == null)
/* 123 */       throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.Item");  Item $this$wrap$iv = (Item)Items.class.getField(name).get(null); int $i$f$wrap = 0; return new ItemImpl<>($this$wrap$iv); } @Nullable public IEnchantment getEnchantmentByLocation(@NotNull String location) { Intrinsics.checkParameterIsNotNull(location, "location"); Enchantment $this$wrap$iv = Enchantment.func_180305_b(location); int $i$f$wrap = 0; Enchantment.func_180305_b(location);
/* 124 */     return (Enchantment.func_180305_b(location) != null) ? new EnchantmentImpl($this$wrap$iv) : null; }
/* 125 */   @NotNull public Collection<IResourceLocation> getEnchantments() { Intrinsics.checkExpressionValueIsNotNull(Enchantment.field_185264_b, "Enchantment.REGISTRY"); return (Collection<IResourceLocation>)new WrappedCollection(Enchantment.field_185264_b.func_148742_b(), ExtractedFunctionsImpl$getEnchantments$1.INSTANCE, ExtractedFunctionsImpl$getEnchantments$2.INSTANCE); } @NotNull public Collection<IResourceLocation> getItemRegistryKeys() { Intrinsics.checkExpressionValueIsNotNull(Item.field_150901_e, "Item.REGISTRY"); return (Collection<IResourceLocation>)new WrappedCollection(Item.field_150901_e.func_148742_b(), ExtractedFunctionsImpl$getItemRegistryKeys$1.INSTANCE, ExtractedFunctionsImpl$getItemRegistryKeys$2.INSTANCE); } @NotNull public Collection<IResourceLocation> getBlockRegistryKeys() { Intrinsics.checkExpressionValueIsNotNull(Block.field_149771_c, "Block.REGISTRY"); return (Collection<IResourceLocation>)new WrappedCollection(Block.field_149771_c.func_148742_b(), ExtractedFunctionsImpl$getBlockRegistryKeys$1.INSTANCE, ExtractedFunctionsImpl$getBlockRegistryKeys$2.INSTANCE); } @Nullable public IEnchantment getEnchantmentById(int enchantID) { Enchantment $this$wrap$iv = Enchantment.func_185262_c(enchantID); int $i$f$wrap = 0; Enchantment.func_185262_c(enchantID); return (Enchantment.func_185262_c(enchantID) != null) ? new EnchantmentImpl($this$wrap$iv) : null; }
/* 126 */   public void disableStandardItemLighting() { RenderHelper.func_74518_a(); } @NotNull public String formatI18n(@NotNull String key, @NotNull String... values) { Intrinsics.checkParameterIsNotNull(key, "key"); Intrinsics.checkParameterIsNotNull(values, "values"); Intrinsics.checkExpressionValueIsNotNull(I18n.func_135052_a(key, new Object[] { values }), "I18n.format(key, values)"); return I18n.func_135052_a(key, new Object[] { values }); } public void sessionServiceJoinServer(@NotNull GameProfile profile, @NotNull String token, @NotNull String sessionHash) { Intrinsics.checkParameterIsNotNull(profile, "profile"); Intrinsics.checkParameterIsNotNull(token, "token"); Intrinsics.checkParameterIsNotNull(sessionHash, "sessionHash"); Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Minecraft.func_71410_x().func_152347_ac().joinServer(profile, token, sessionHash); } @NotNull public IPotion getPotionById(int potionID) { if (Potion.func_188412_a(potionID) == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(Potion.func_188412_a(potionID), "Potion.getPotionById(potionID)!!"); Potion $this$wrap$iv = Potion.func_188412_a(potionID); int $i$f$wrap = 0; return new PotionImpl($this$wrap$iv); } public void enableStandardItemLighting() { RenderHelper.func_74519_b(); }
/* 127 */   @NotNull public String scoreboardFormatPlayerName(@Nullable ITeam scorePlayerTeam, @NotNull String playerName) { Intrinsics.checkParameterIsNotNull(playerName, "playerName"); ITeam $this$unwrap$iv = scorePlayerTeam; int $i$f$unwrap = 0; if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.TeamImpl");  Intrinsics.checkExpressionValueIsNotNull(ScorePlayerTeam.func_96667_a((scorePlayerTeam != null) ? ((TeamImpl)$this$unwrap$iv).getWrapped() : null, playerName), "ScorePlayerTeam.formatPl…am?.unwrap(), playerName)"); return ScorePlayerTeam.func_96667_a((scorePlayerTeam != null) ? ((TeamImpl)$this$unwrap$iv).getWrapped() : null, playerName); } public void disableFastRender() { try { Field fastRenderer = fastRenderField; if (fastRenderer != null) { if (!fastRenderer.isAccessible()) fastRenderer.setAccessible(true);  fastRenderer.setBoolean((Minecraft.func_71410_x()).field_71474_y, false); }  } catch (IllegalAccessException illegalAccessException) {} }
/* 128 */   @NotNull public IIChatComponent jsonToComponent(@NotNull String toString) { Intrinsics.checkParameterIsNotNull(toString, "toString"); if (ITextComponent.Serializer.func_150699_a(toString) == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(ITextComponent.Serializer.func_150699_a(toString), "ITextComponent.Serialize…onToComponent(toString)!!"); ITextComponent $this$wrap$iv = ITextComponent.Serializer.func_150699_a(toString); int $i$f$wrap = 0; return new IChatComponentImpl($this$wrap$iv); } public void setActiveTextureLightMapTexUnit() { GlStateManager.func_179138_g(OpenGlHelper.field_77476_b); } public void setActiveTextureDefaultTexUnit() { GlStateManager.func_179138_g(OpenGlHelper.field_77478_a); }
/* 129 */   @Nullable public IItem getItemById(int id) { Intrinsics.checkExpressionValueIsNotNull(Item.func_150899_d(id), "Item.getItemById(id)"); Item $this$wrap$iv = Item.func_150899_d(id); int $i$f$wrap = 0; return new ItemImpl<>($this$wrap$iv); } public int getIdFromItem(@NotNull IItem sb) { Intrinsics.checkParameterIsNotNull(sb, "sb"); IItem $this$unwrap$iv = sb; int $i$f$unwrap = 0;
/* 130 */     return Item.func_150891_b(((ItemImpl<Item>)$this$unwrap$iv).getWrapped()); } public boolean canAddItemToSlot(@NotNull ISlot slotIn, @NotNull IItemStack stack, boolean stackSizeMatters) { Intrinsics.checkParameterIsNotNull(slotIn, "slotIn"); Intrinsics.checkParameterIsNotNull(stack, "stack"); ISlot $this$unwrap$iv = slotIn; int $i$f$unwrap = 0; IItemStack iItemStack = stack;
/* 131 */     Slot slot = ((SlotImpl)$this$unwrap$iv).getWrapped(); $i$f$unwrap = 0;
/* 132 */     ItemStack itemStack = ((ItemStackImpl)iItemStack).getWrapped(); return Container.func_94527_a(slot, itemStack, stackSizeMatters); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\ExtractedFunctionsImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */