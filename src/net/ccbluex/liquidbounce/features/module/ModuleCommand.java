/*     */ package net.ccbluex.liquidbounce.features.module;
/*     */ 
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\b\006\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\004\030\0002\0020\001B!\022\006\020\002\032\0020\003\022\022\b\002\020\004\032\f\022\b\022\006\022\002\b\0030\0060\005¢\006\002\020\007J\033\020\f\032\0020\r2\f\020\016\032\b\022\004\022\0020\0200\017H\026¢\006\002\020\021J!\020\022\032\b\022\004\022\0020\0200\0052\f\020\016\032\b\022\004\022\0020\0200\017H\026¢\006\002\020\023R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\tR\033\020\004\032\f\022\b\022\006\022\002\b\0030\0060\005¢\006\b\n\000\032\004\b\n\020\013¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/ModuleCommand;", "Lnet/ccbluex/liquidbounce/features/command/Command;", "module", "Lnet/ccbluex/liquidbounce/features/module/Module;", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "(Lnet/ccbluex/liquidbounce/features/module/Module;Ljava/util/List;)V", "getModule", "()Lnet/ccbluex/liquidbounce/features/module/Module;", "getValues", "()Ljava/util/List;", "execute", "", "args", "", "", "([Ljava/lang/String;)V", "tabComplete", "([Ljava/lang/String;)Ljava/util/List;", "XSJClient"})
/*     */ public final class ModuleCommand extends Command {
/*     */   @NotNull
/*     */   private final Module module;
/*     */   @NotNull
/*     */   private final List<Value<?>> values;
/*     */   
/*     */   @NotNull
/*  13 */   public final Module getModule() { return this.module; } @NotNull public final List<Value<?>> getValues() { return this.values; } public ModuleCommand(@NotNull Module module, @NotNull List<Value<?>> values) {
/*  14 */     super(str2, new String[0]); this.module = module; this.values = values;
/*     */ 
/*     */     
/*  17 */     if (this.values.isEmpty())
/*  18 */       throw (Throwable)new IllegalArgumentException("Values are empty!"); 
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\0020\0012\n\020\002\032\006\022\002\b\0030\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lnet/ccbluex/liquidbounce/value/Value;", "invoke"})
/*     */   static final class ModuleCommand$execute$valueNames$2 extends Lambda implements Function1<Value<?>, String> {
/*     */     public static final ModuleCommand$execute$valueNames$2 INSTANCE = new ModuleCommand$execute$valueNames$2();
/*     */     
/*     */     @NotNull
/*     */     public final String invoke(@NotNull Value it) {
/*  27 */       Intrinsics.checkParameterIsNotNull(it, "it"); String str = it.getName(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ModuleCommand$execute$valueNames$2() {
/*     */       super(1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute(@NotNull String[] args) {
/*     */     Intrinsics.checkParameterIsNotNull(args, "args");
/*     */     Iterable<Value<?>> $this$filter$iv = this.values;
/*     */     int $i$f$filter = 0;
/* 133 */     Iterable<Value<?>> iterable1 = $this$filter$iv; Collection<Object<?>> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 134 */     for (Object<?> element$iv$iv : iterable1) { Value it = (Value)element$iv$iv; int $i$a$-filter-ModuleCommand$execute$valueNames$1 = 0; if (!(it instanceof net.ccbluex.liquidbounce.value.FontValue))
/* 135 */         destination$iv$iv.add(element$iv$iv);  }  String valueNames = CollectionsKt.joinToString$default(destination$iv$iv, "/", null, null, 0, null, ModuleCommand$execute$valueNames$2.INSTANCE, 30, null); String str1 = this.module.getName(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String moduleName = str1.toLowerCase(); if (args.length < 2) { chatSyntax((this.values.size() == 1) ? (moduleName + ' ' + valueNames + " <value>") : (moduleName + " <" + valueNames + '>')); return; }  Value<?> value = this.module.getValue(args[1]); if (value == null) { chatSyntax(moduleName + " <" + valueNames + '>'); return; }  if (value instanceof BoolValue) { boolean newValue = !((Boolean)((BoolValue)value).get()).booleanValue(); ((BoolValue)value).set(Boolean.valueOf(newValue)); chat("§7" + this.module.getName() + " §8" + args[1] + "§7 was toggled " + (newValue ? "§8on§7" : "§8off§7.")); playEdit(); } else { if (args.length < 3) { if (value instanceof IntegerValue || value instanceof FloatValue || value instanceof TextValue) { String str2 = args[1]; StringBuilder stringBuilder = (new StringBuilder()).append(moduleName).append(' '); ModuleCommand moduleCommand = this; boolean bool1 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str2.toLowerCase(); moduleCommand.chatSyntax(stringBuilder.append(str3).append(" <value>").toString()); } else if (value instanceof ListValue) { String str2 = args[1]; StringBuilder stringBuilder = (new StringBuilder()).append(moduleName).append(' '); ModuleCommand moduleCommand = this; boolean bool1 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str2.toLowerCase(); str2 = ArraysKt.joinToString$default((Object[])((ListValue)value).getValues(), "/", null, null, 0, null, null, 62, null); stringBuilder = stringBuilder.append(str3).append(" <"); moduleCommand = moduleCommand; bool1 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str3 = str2.toLowerCase(); moduleCommand.chatSyntax(stringBuilder.append(str3).append('>').toString()); }  return; }  try { Value<?> value1 = value; if (value1 instanceof BlockValue) { int id = 0; try { String str = args[2]; boolean bool2 = false; int i = Integer.parseInt(str); } catch (NumberFormatException exception) { IBlock iBlock1 = MinecraftInstance.functions.getBlockFromName(args[2]); boolean bool2 = false, bool3 = false; IBlock it = iBlock1; int $i$a$-let-ModuleCommand$execute$tmpId$1 = 0; MinecraftInstance.functions.getBlockFromName(args[2]); Integer tmpId = (MinecraftInstance.functions.getBlockFromName(args[2]) != null) ? Integer.valueOf(MinecraftInstance.functions.getIdFromBlock(it)) : null; if (tmpId == null || tmpId.intValue() <= 0) { chat("§7Block §8" + args[2] + "§7 does not exist!"); return; }  $i$f$filterTo = tmpId.intValue(); }  id = $i$f$filterTo; ((BlockValue)value).set(Integer.valueOf(id)); String str2 = args[1]; StringBuilder stringBuilder = (new StringBuilder()).append("§7").append(this.module.getName()).append(" §8"); ModuleCommand moduleCommand = this; boolean bool1 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str2.toLowerCase(); moduleCommand.chat(stringBuilder.append(str3).append("§7 was set to §8").append(BlockUtils.getBlockName(id)).append("§7.").toString()); playEdit(); return; }  if (value1 instanceof IntegerValue) { String str = args[2]; IntegerValue integerValue = (IntegerValue)value; $i$f$filterTo = 0; int i = Integer.parseInt(str); integerValue.set(Integer.valueOf(i)); } else if (value1 instanceof FloatValue) { String str = args[2]; FloatValue floatValue = (FloatValue)value; $i$f$filterTo = 0; float f = Float.parseFloat(str); floatValue.set(Float.valueOf(f)); } else if (value1 instanceof ListValue) { if (!((ListValue)value).contains(args[2])) { String str2 = args[1]; StringBuilder stringBuilder = (new StringBuilder()).append(moduleName).append(' '); ModuleCommand moduleCommand = this; $i$f$filterTo = 0; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); String str3 = str2.toLowerCase(); str2 = ArraysKt.joinToString$default((Object[])((ListValue)value).getValues(), "/", null, null, 0, null, null, 62, null); stringBuilder = stringBuilder.append(str3).append(" <"); moduleCommand = moduleCommand; $i$f$filterTo = 0; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str3 = str2.toLowerCase(); moduleCommand.chatSyntax(stringBuilder.append(str3).append('>').toString()); return; }  ((ListValue)value).set(args[2]); } else if (value1 instanceof TextValue) { Intrinsics.checkExpressionValueIsNotNull(StringUtils.toCompleteString(args, 2), "StringUtils.toCompleteString(args, 2)"); ((TextValue)value).set(StringUtils.toCompleteString(args, 2)); }  chat("§7" + this.module.getName() + " §8" + args[1] + "§7 was set to §8" + value.get() + "§7."); playEdit(); } catch (NumberFormatException e) { chat("§8" + args[2] + "§7 cannot be converted to number!"); }  }  } @NotNull public List<String> tabComplete(@NotNull String[] args) { Iterable<Value<?>> $this$filter$iv; Iterable $this$map$iv; Value<?> value; int $i$f$filter, $i$f$map; Iterable<Value<?>> iterable1; Iterable $this$filterTo$iv$iv; Collection<Object<?>> collection; Collection destination$iv$iv; Iterator<Value<?>> iterator; int $i$f$filterTo, $i$f$mapTo; Intrinsics.checkParameterIsNotNull(args, "args"); String[] arrayOfString = args; boolean bool = false; if ((arrayOfString.length == 0))
/* 136 */       return CollectionsKt.emptyList();  switch (args.length) { case 1: $this$filter$iv = this.values; $i$f$filter = 0; iterable1 = $this$filter$iv; collection = new ArrayList(); $i$f$filterTo = 0;
/* 137 */         for (Object<?> element$iv$iv : iterable1) { Value it = (Value)element$iv$iv; int $i$a$-filter-ModuleCommand$tabComplete$1 = 0; if ((!(it instanceof net.ccbluex.liquidbounce.value.FontValue) && StringsKt.startsWith(it.getName(), args[0], true)))
/* 138 */             collection.add(element$iv$iv);  }  $this$map$iv = collection; $i$f$map = 0;
/* 139 */         $this$filterTo$iv$iv = $this$map$iv; destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10)); $i$f$mapTo = 0;
/* 140 */         for (Object item$iv$iv : $this$filterTo$iv$iv)
/* 141 */         { Value value1 = (Value)item$iv$iv; Collection collection1 = destination$iv$iv; int $i$a$-map-ModuleCommand$tabComplete$2 = 0; String str = value1.getName(); boolean bool1 = false; } 
/*     */       case 2:
/* 143 */         value = this.module.getValue(args[0]); if (value instanceof BlockValue) { Iterable iterable3 = MinecraftInstance.functions.getItemRegistryKeys(); int j = 0; Iterable iterable4 = iterable3; Collection<Object> collection1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10)); int m = 0;
/* 144 */           for (Object item$iv$iv : iterable4) {
/* 145 */             IResourceLocation iResourceLocation = (IResourceLocation)item$iv$iv; Collection<Object> collection2 = collection1; int $i$a$-map-ModuleCommand$tabComplete$3 = 0; String str = iResourceLocation.getResourcePath(); boolean bool1 = false;
/* 146 */           }  Iterable iterable2 = collection1; int i = 0;
/* 147 */           Iterable $this$mapTo$iv$iv = iterable2; collection1 = new ArrayList(); int k = 0;
/* 148 */           for (Object element$iv$iv : $this$mapTo$iv$iv) { String it = (String)element$iv$iv; int $i$a$-filter-ModuleCommand$tabComplete$4 = 0; if (StringsKt.startsWith(it, args[1], true))
/* 149 */               collection1.add(element$iv$iv);  }  return (List)collection1; }
/* 150 */          if (value instanceof ListValue) { Iterable<Value<?>> $this$forEach$iv = this.values; int $i$f$forEach = 0; iterator = $this$forEach$iv.iterator(); } else {  }  if (iterator.hasNext()) { Object<?> element$iv = (Object<?>)iterator.next(); Value value1 = (Value)element$iv; int $i$a$-forEach-ModuleCommand$tabComplete$5 = 0; if (StringsKt.equals(value1.getName(), args[0], true))
/* 151 */             if (value1 instanceof ListValue) { String[] arrayOfString1 = ((ListValue)value1).getValues(); int i = 0; String[] arrayOfString2 = arrayOfString1; Collection<Object> collection1 = new ArrayList(); int j = 0; String[] arrayOfString3; int k; byte b;
/* 152 */               for (arrayOfString3 = arrayOfString2, k = arrayOfString3.length, b = 0; b < k; ) { Object element$iv$iv = arrayOfString3[b], object1 = element$iv$iv; int $i$a$-filter-ModuleCommand$tabComplete$5$1 = 0; if (StringsKt.startsWith((String)object1, args[1], true))
/* 153 */                   collection1.add(element$iv$iv);  }  return (List)collection1; }
/*     */               }
/*     */         
/*     */         return CollectionsKt.emptyList(); }
/*     */     
/*     */     return CollectionsKt.emptyList(); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\ModuleCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */