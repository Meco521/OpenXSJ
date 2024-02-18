/*     */ package net.ccbluex.liquidbounce.script.remapper;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\020\016\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\013\032\0020\fJ\b\020\r\032\0020\fH\002J\032\020\016\032\0020\0052\n\020\017\032\006\022\002\b\0030\0202\006\020\021\032\0020\005J\"\020\022\032\0020\0052\n\020\017\032\006\022\002\b\0030\0202\006\020\021\032\0020\0052\006\020\023\032\0020\005RR\020\003\032F\022\004\022\0020\005\022\020\022\016\022\004\022\0020\005\022\004\022\0020\0050\0040\004j*\022\004\022\0020\005\022 \022\036\022\004\022\0020\005\022\004\022\0020\0050\004j\016\022\004\022\0020\005\022\004\022\0020\005`\006`\006X\004¢\006\002\n\000RR\020\007\032F\022\004\022\0020\005\022\020\022\016\022\004\022\0020\005\022\004\022\0020\0050\0040\004j*\022\004\022\0020\005\022 \022\036\022\004\022\0020\005\022\004\022\0020\0050\004j\016\022\004\022\0020\005\022\004\022\0020\005`\006`\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\005XT¢\006\002\n\000¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/script/remapper/Remapper;", "", "()V", "fields", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "methods", "srgFile", "Ljava/io/File;", "srgName", "loadSrg", "", "parseSrg", "remapField", "clazz", "Ljava/lang/Class;", "name", "remapMethod", "desc", "XSJClient"})
/*     */ public final class Remapper {
/*     */   static {
/*  15 */     Remapper remapper = new Remapper();
/*     */   }
/*     */   private static final String srgName = "stable_22";
/*  18 */   private static final File srgFile = new File((Retreat.INSTANCE.getFileManager()).dir, "mcp-stable_22.srg");
/*     */   
/*  20 */   private static final HashMap<String, HashMap<String, String>> fields = new HashMap<>(); static { boolean bool = false; }
/*  21 */    private static final HashMap<String, HashMap<String, String>> methods = new HashMap<>(); public static final Remapper INSTANCE; static { bool = false; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void loadSrg() {
/*  28 */     if (!srgFile.exists()) {
/*     */       
/*  30 */       srgFile.createNewFile();
/*     */       
/*  32 */       ClientUtils.getLogger().info("[Remapper] Extracting stable_22 srg...");
/*  33 */       Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x(), "Minecraft.getMinecraft()"); Intrinsics.checkExpressionValueIsNotNull(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/mcp-stable_22.srg")), "Minecraft.getMinecraft()…tomk/mcp-stable_22.srg\"))"); FileUtils.copyInputStreamToFile(Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("tomk/mcp-stable_22.srg")).func_110527_b(), srgFile);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  38 */     ClientUtils.getLogger().info("[Remapper] Loading srg...");
/*  39 */     parseSrg();
/*  40 */     ClientUtils.getLogger().info("[Remapper] Loaded srg.");
/*     */   }
/*     */   
/*     */   private final void parseSrg() {
/*  44 */     Iterable $this$forEach$iv = FilesKt.readLines$default(srgFile, null, 1, null); int $i$f$forEach = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); String it = (String)element$iv; int $i$a$-forEach-Remapper$parseSrg$1 = 0;
/*     */       List args = StringsKt.split$default(it, new String[] { " " }, false, 0, 6, null); }
/*     */   
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String remapField(@NotNull Class clazz, @NotNull String name) {
/*     */     Intrinsics.checkParameterIsNotNull(clazz, "clazz");
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     if (!fields.containsKey(clazz.getName()))
/*     */       return name; 
/*     */     if (fields.get(clazz.getName()) == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(fields.get(clazz.getName()).getOrDefault(name, name), "fields[clazz.name]!!.getOrDefault(name, name)");
/*     */     return fields.get(clazz.getName()).getOrDefault(name, name);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String remapMethod(@NotNull Class clazz, @NotNull String name, @NotNull String desc) {
/*     */     Intrinsics.checkParameterIsNotNull(clazz, "clazz");
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     Intrinsics.checkParameterIsNotNull(desc, "desc");
/*     */     if (!methods.containsKey(clazz.getName()))
/*     */       return name; 
/*     */     if (methods.get(clazz.getName()) == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     Intrinsics.checkExpressionValueIsNotNull(methods.get(clazz.getName()).getOrDefault(name + desc, name), "methods[clazz.name]!!.ge…efault(name + desc, name)");
/*     */     return methods.get(clazz.getName()).getOrDefault(name + desc, name);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\remapper\Remapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */