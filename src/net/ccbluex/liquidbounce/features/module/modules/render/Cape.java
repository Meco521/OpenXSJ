/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Cape", description = "更好的披风", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\b\007\030\0002\0020\001:\001\016B\005¢\006\002\020\002J\016\020\013\032\0020\f2\006\020\r\032\0020\bR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Cape;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "styleValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getStyleValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "tag", "", "getTag", "()Ljava/lang/String;", "getCapeLocation", "Lnet/minecraft/util/ResourceLocation;", "value", "CapeStyle", "XSJClient"})
/*    */ public final class Cape
/*    */   extends Module
/*    */ {
/*    */   @NotNull
/* 18 */   private final ListValue styleValue = new ListValue("Style", new String[] { "Lunar", "Tenacity", "Vanilla", "Skidware", "Rise6", "Paimon", "Moon", "Novoline", "Migrator", "MojangDev", "Minecon2011", "Minecon2012", "Minecon2013", "Minecon2015", "Minecon2016", "Astolfo", "Autumn", "Bilibili", "Crosssine", "Dark", "Delta", "Diablo", "Dortware", "FDP", "Jiaran", "LiquidbouncePlus" }, "loserline"); @NotNull public final ListValue getStyleValue() { return this.styleValue; }
/*    */   @NotNull
/*    */   public final ResourceLocation getCapeLocation(@NotNull String value) { ResourceLocation resourceLocation;
/* 21 */     Intrinsics.checkParameterIsNotNull(value, "value"); try {
/* 22 */       String str = value; boolean bool = false; Intrinsics.checkExpressionValueIsNotNull(str.toUpperCase(), "(this as java.lang.String).toUpperCase()"); resourceLocation = CapeStyle.valueOf(str.toUpperCase()).getLocation();
/* 23 */     } catch (IllegalArgumentException e) {
/* 24 */       resourceLocation = CapeStyle.Rise6.getLocation();
/*    */     } 
/*    */     return resourceLocation; } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\030\002\n\002\b\036\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\fj\002\b\rj\002\b\016j\002\b\017j\002\b\020j\002\b\021j\002\b\022j\002\b\023j\002\b\024j\002\b\025j\002\b\026j\002\b\027j\002\b\030j\002\b\031j\002\b\032j\002\b\033j\002\b\034j\002\b\035j\002\b\036j\002\b\037j\002\b ¨\006!"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Cape$CapeStyle;", "", "location", "Lnet/minecraft/util/ResourceLocation;", "(Ljava/lang/String;ILnet/minecraft/util/ResourceLocation;)V", "getLocation", "()Lnet/minecraft/util/ResourceLocation;", "Minecon2011", "Minecon2012", "Minecon2013", "Minecon2015", "Minecon2016", "Astolfo", "Rise6", "Skidware", "Tenacity", "Vanilla", "Paimon", "Autumn", "Bilibili", "Crosssine", "Dark", "Delta", "Diablo", "FDP", "Novoline", "LiquidbouncePlus", "MojangDev", "Moon", "Lunar", "Migrator", "Jiaran", "Dortware", "XSJClient"})
/*    */   public enum CapeStyle { @NotNull
/* 28 */     public final ResourceLocation getLocation() { return this.location; } Minecon2011, Minecon2012, Minecon2013, Minecon2015, Minecon2016, Astolfo, Rise6, Skidware, Tenacity, Vanilla, Paimon, Autumn, Bilibili, Crosssine, Dark, Delta, Diablo, FDP, Novoline, LiquidbouncePlus, MojangDev, Moon, Lunar, Migrator, Jiaran, Dortware; CapeStyle(ResourceLocation location) { this.location = location; }
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
/*    */     @NotNull
/*    */     private final ResourceLocation location; }
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
/*    */   @NotNull
/*    */   public String getTag() {
/* 58 */     return (String)this.styleValue.get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Cape.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */