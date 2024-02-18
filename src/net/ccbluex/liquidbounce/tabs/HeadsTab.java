/*     */ package net.ccbluex.liquidbounce.tabs;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.util.WrappedCreativeTabs;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.misc.HttpUtils;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020!\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\013\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\026\020\006\032\0020\0072\f\020\b\032\b\022\004\022\0020\0050\tH\026J\b\020\n\032\0020\013H\026J\b\020\f\032\0020\rH\026J\b\020\016\032\0020\017H\026J\b\020\020\032\0020\007H\002R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\021"}, d2 = {"Lnet/ccbluex/liquidbounce/tabs/HeadsTab;", "Lnet/ccbluex/liquidbounce/api/util/WrappedCreativeTabs;", "()V", "heads", "Ljava/util/ArrayList;", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;", "displayAllReleventItems", "", "itemList", "", "getTabIconItem", "Lnet/ccbluex/liquidbounce/api/minecraft/item/IItem;", "getTranslatedTabLabel", "", "hasSearchBar", "", "loadHeads", "XSJClient"})
/*     */ public final class HeadsTab extends WrappedCreativeTabs {
/*     */   public HeadsTab() {
/*  20 */     super("Heads");
/*     */ 
/*     */     
/*  23 */     this.heads = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  29 */     getRepresentedType().setBackgroundImageName("item_search.png");
/*     */     
/*  31 */     loadHeads();
/*     */   }
/*     */ 
/*     */   
/*     */   private final ArrayList<IItemStack> heads;
/*     */   
/*     */   private final void loadHeads() {
/*     */     try {
/*  39 */       ClientUtils.getLogger().info("Loading heads...");
/*     */       
/*  41 */       JsonElement headsConfiguration = (new JsonParser()).parse(HttpUtils.get("https://cloud.liquidbounce.net/LiquidBounce/heads.json"));
/*     */       
/*  43 */       Intrinsics.checkExpressionValueIsNotNull(headsConfiguration, "headsConfiguration"); if (!headsConfiguration.isJsonObject())
/*     */         return; 
/*  45 */       JsonObject headsConf = headsConfiguration.getAsJsonObject();
/*     */       
/*  47 */       Intrinsics.checkExpressionValueIsNotNull(headsConf.get("enabled"), "headsConf.get(\"enabled\")"); if (headsConf.get("enabled").getAsBoolean())
/*  48 */       { Intrinsics.checkExpressionValueIsNotNull(headsConf.get("url"), "headsConf.get(\"url\")"); String url = headsConf.get("url").getAsString();
/*     */         
/*  50 */         ClientUtils.getLogger().info("Loading heads from " + url + "...");
/*     */         
/*  52 */         Intrinsics.checkExpressionValueIsNotNull(url, "url"); JsonElement headsElement = (new JsonParser()).parse(HttpUtils.get(url));
/*     */         
/*  54 */         Intrinsics.checkExpressionValueIsNotNull(headsElement, "headsElement"); if (!headsElement.isJsonObject()) {
/*  55 */           ClientUtils.getLogger().error("Something is wrong, the heads json is not a JsonObject!");
/*     */           
/*     */           return;
/*     */         } 
/*  59 */         JsonObject headsObject = headsElement.getAsJsonObject();
/*     */         
/*  61 */         for (Iterator<Map.Entry> iterator = headsObject.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry entry1 = iterator.next(), entry2 = entry1; boolean bool = false; JsonElement value = (JsonElement)entry2.getValue();
/*  62 */           Intrinsics.checkExpressionValueIsNotNull(value, "value"); JsonObject headElement = value.getAsJsonObject();
/*     */           
/*  64 */           Intrinsics.checkExpressionValueIsNotNull(headElement.get("name"), "headElement.get(\"name\")"); Intrinsics.checkExpressionValueIsNotNull(headElement.get("uuid"), "headElement.get(\"uuid\")"); Intrinsics.checkExpressionValueIsNotNull(headElement.get("value"), "headElement.get(\"value\")"); this.heads.add(ItemUtils.createItem("skull 1 3 {display:{Name:\"" + headElement.get("name").getAsString() + "\"},SkullOwner:{Id:\"" + headElement.get("uuid").getAsString() + "\",Properties:{textures:[{Value:\"" + headElement.get("value").getAsString() + "\"}]}}}")); }
/*     */ 
/*     */         
/*  67 */         ClientUtils.getLogger().info("Loaded " + this.heads.size() + " heads from HeadDB."); }
/*     */       else
/*  69 */       { ClientUtils.getLogger().info("Heads are disabled."); } 
/*  70 */     } catch (Exception e) {
/*  71 */       ClientUtils.getLogger().error("Error while reading heads.", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void displayAllReleventItems(@NotNull List<IItemStack> itemList) {
/*  81 */     Intrinsics.checkParameterIsNotNull(itemList, "itemList"); itemList.addAll(this.heads);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public IItem getTabIconItem() {
/*  89 */     return WrapperImpl.INSTANCE.getClassProvider().getItemEnum(ItemType.SKULL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public String getTranslatedTabLabel() {
/*  96 */     return "Heads";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSearchBar() {
/* 101 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\tabs\HeadsTab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */