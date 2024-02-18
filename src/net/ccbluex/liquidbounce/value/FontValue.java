/*     */ package net.ccbluex.liquidbounce.value;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
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
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\002¢\006\002\020\006J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\n\020\013\032\004\030\0010\nH\026¨\006\f"}, d2 = {"Lnet/ccbluex/liquidbounce/value/FontValue;", "Lnet/ccbluex/liquidbounce/value/Value;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "valueName", "", "value", "(Ljava/lang/String;Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;)V", "fromJson", "", "element", "Lcom/google/gson/JsonElement;", "toJson", "XSJClient"})
/*     */ public final class FontValue
/*     */   extends Value<IFontRenderer>
/*     */ {
/*     */   public FontValue(@NotNull String valueName, @NotNull IFontRenderer value) {
/* 120 */     super(valueName, value);
/*     */   }
/*     */   @Nullable
/* 123 */   public JsonElement toJson() { if (Fonts.getFontDetails(getValue()) != null) { Fonts.FontInfo fontDetails = Fonts.getFontDetails(getValue());
/* 124 */       JsonObject valueObject = new JsonObject();
/* 125 */       valueObject.addProperty("fontName", fontDetails.getName());
/* 126 */       valueObject.addProperty("fontSize", Integer.valueOf(fontDetails.getFontSize()));
/* 127 */       return (JsonElement)valueObject; }
/*     */     
/*     */     Fonts.getFontDetails(getValue());
/*     */     return null; } public void fromJson(@NotNull JsonElement element) {
/* 131 */     Intrinsics.checkParameterIsNotNull(element, "element"); if (!element.isJsonObject())
/* 132 */       return;  JsonObject valueObject = element.getAsJsonObject();
/* 133 */     Intrinsics.checkExpressionValueIsNotNull(valueObject.get("fontName"), "valueObject[\"fontName\"]"); Intrinsics.checkExpressionValueIsNotNull(valueObject.get("fontSize"), "valueObject[\"fontSize\"]"); Intrinsics.checkExpressionValueIsNotNull(Fonts.getFontRenderer(valueObject.get("fontName").getAsString(), valueObject.get("fontSize").getAsInt()), "Fonts.getFontRenderer(va…Object[\"fontSize\"].asInt)"); setValue(Fonts.getFontRenderer(valueObject.get("fontName").getAsString(), valueObject.get("fontSize").getAsInt()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\value\FontValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */