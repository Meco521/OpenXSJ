/*     */ package net.ccbluex.liquidbounce.features.module;
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\007\n\002\b\005\n\002\020\013\n\002\b\006\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\021\n\002\020\b\n\002\b\034\n\002\020 \n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\t\b\026\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\020\020K\032\0020L2\006\020M\032\0020\030H\024J\026\020N\032\b\022\002\b\003\030\0010H2\006\020O\032\0020\030H\026J\b\020P\032\0020\013H\026J\b\020Q\032\0020LH\026J\b\020R\032\0020LH\026J\020\020S\032\0020L2\006\020?\032\0020\013H\026J\006\020T\032\0020LR\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR$\020\n\032\0020\0132\006\020\n\032\0020\013@FX\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\016\020\020\032\0020\013X\004¢\006\002\n\000R\032\020\021\032\0020\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R\021\020\027\032\0020\0308F¢\006\006\032\004\b\031\020\032R\032\020\033\032\0020\030X\016¢\006\016\n\000\032\004\b\034\020\032\"\004\b\035\020\036R\032\020\037\032\0020\013X\016¢\006\016\n\000\032\004\b \020\r\"\004\b!\020\017R\032\020\"\032\0020\005X\016¢\006\016\n\000\032\004\b#\020\007\"\004\b$\020\tR\021\020%\032\0020\005¢\006\b\n\000\032\004\b&\020\007R\032\020'\032\0020\013X\016¢\006\016\n\000\032\004\b'\020\r\"\004\b(\020\017R$\020)\032\0020*2\006\020)\032\0020*@FX\016¢\006\016\n\000\032\004\b+\020,\"\004\b-\020.R\032\020/\032\0020\005X\016¢\006\016\n\000\032\004\b0\020\007\"\004\b1\020\tR\032\0202\032\0020\030X\016¢\006\016\n\000\032\004\b3\020\032\"\004\b4\020\036R\032\0205\032\0020\013X\016¢\006\016\n\000\032\004\b6\020\r\"\004\b7\020\017R\032\0208\032\0020\005X\016¢\006\016\n\000\032\004\b9\020\007\"\004\b:\020\tR\032\020;\032\0020\005X\016¢\006\016\n\000\032\004\b<\020\007\"\004\b=\020\tR$\020?\032\0020\0132\006\020>\032\0020\013@FX\016¢\006\016\n\000\032\004\b@\020\r\"\004\bA\020\017R\026\020B\032\004\030\0010\0308VX\004¢\006\006\032\004\bC\020\032R\021\020D\032\0020\0308F¢\006\006\032\004\bE\020\032R\036\020F\032\f\022\b\022\006\022\002\b\0030H0G8VX\004¢\006\006\032\004\bI\020J¨\006U"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/Module;", "Lnet/ccbluex/liquidbounce/utils/MinecraftInstance;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "array", "", "getArray", "()Z", "setArray", "(Z)V", "canEnable", "category", "Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "getCategory", "()Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "setCategory", "(Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;)V", "colorlessTagName", "", "getColorlessTagName", "()Ljava/lang/String;", "description", "getDescription", "setDescription", "(Ljava/lang/String;)V", "expanded", "getExpanded", "setExpanded", "higt", "getHigt", "setHigt", "hue", "getHue", "isSupported", "setSupported", "keyBind", "", "getKeyBind", "()I", "setKeyBind", "(I)V", "keyBindY", "getKeyBindY", "setKeyBindY", "name", "getName", "setName", "nameBreak", "getNameBreak", "setNameBreak", "slide", "getSlide", "setSlide", "slideStep", "getSlideStep", "setSlideStep", "value", "state", "getState", "setState", "tag", "getTag", "tagName", "getTagName", "values", "", "Lnet/ccbluex/liquidbounce/value/Value;", "getValues", "()Ljava/util/List;", "alert", "", "msg", "getValue", "valueName", "handleEvents", "onDisable", "onEnable", "onToggle", "toggle", "XSJClient"})
/*     */ public class Module extends MinecraftInstance implements Listenable { private boolean isSupported;
/*     */   private boolean expanded;
/*     */   private float keyBindY;
/*     */   private float alpha;
/*     */   @NotNull
/*     */   private String name;
/*     */   @NotNull
/*     */   private String description;
/*     */   @NotNull
/*     */   private ModuleCategory category;
/*     */   private int keyBind;
/*     */   
/*  15 */   public final boolean isSupported() { return this.isSupported; } public final void setSupported(boolean <set-?>) { this.isSupported = <set-?>; }
/*     */ 
/*     */   
/*  18 */   public final boolean getExpanded() { return this.expanded; } public final void setExpanded(boolean <set-?>) { this.expanded = <set-?>; }
/*  19 */   public final float getKeyBindY() { return this.keyBindY; } public final void setKeyBindY(float <set-?>) { this.keyBindY = <set-?>; }
/*  20 */   public float getAlpha() { return this.alpha; } public void setAlpha(float <set-?>) { this.alpha = <set-?>; } @NotNull
/*  21 */   public final String getName() { return this.name; } public final void setName(@NotNull String <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.name = <set-?>; } @NotNull
/*  22 */   public final String getDescription() { return this.description; } public final void setDescription(@NotNull String <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.description = <set-?>; } @NotNull
/*  23 */   public final ModuleCategory getCategory() { return this.category; } public final void setCategory(@NotNull ModuleCategory <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.category = <set-?>; } public final int getKeyBind() {
/*  24 */     return this.keyBind;
/*     */   } public final void setKeyBind(int keyBind) {
/*  26 */     this.keyBind = keyBind;
/*     */     
/*  28 */     if (!Retreat.INSTANCE.isStarting())
/*  29 */       Retreat.INSTANCE.getFileManager().saveConfig((Retreat.INSTANCE.getFileManager()).valuesConfig); 
/*     */   } private boolean array = true; private final boolean canEnable; private float slideStep; private boolean state; private final float hue; private float slide; private boolean nameBreak; private float higt; public final boolean getArray() {
/*  31 */     return this.array;
/*     */   } public final void setArray(boolean array) {
/*  33 */     this.array = array;
/*     */     
/*  35 */     if (!Retreat.INSTANCE.isStarting())
/*  36 */       Retreat.INSTANCE.getFileManager().saveConfig((Retreat.INSTANCE.getFileManager()).valuesConfig); 
/*     */   }
/*     */   
/*     */   public final float getSlideStep() {
/*  40 */     return this.slideStep; } public final void setSlideStep(float <set-?>) { this.slideStep = <set-?>; }
/*     */   public final boolean getState() {
/*     */     return this.state;
/*  43 */   } public Module() { if (getClass().getAnnotation(ModuleInfo.class) == null) Intrinsics.throwNpe();  ModuleInfo moduleInfo = getClass().getAnnotation(ModuleInfo.class);
/*     */     
/*  45 */     this.name = moduleInfo.name();
/*  46 */     this.description = moduleInfo.description();
/*  47 */     this.category = moduleInfo.category();
/*  48 */     setKeyBind(moduleInfo.keyBind());
/*  49 */     setArray(moduleInfo.array());
/*  50 */     this.canEnable = moduleInfo.canEnable();
/*  51 */     this.isSupported = ArraysKt.contains((Object[])moduleInfo.supportedVersions(), Backend.INSTANCE.getREPRESENTED_BACKEND_VERSION());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.hue = (float)Math.random(); } public final void setState(boolean value) { if (this.state == value) return;  onToggle(value); if (!Retreat.INSTANCE.isStarting()) { switch (Retreat.INSTANCE.getModuleManager().getToggleSoundMode()) { case 1: if (value) MinecraftInstance.mc.getSoundHandler().playSound("minecraft:block.anvil.break", 0.1F);  break;case 2: (value ? Retreat.INSTANCE.getTipSoundManager().getEnableSound() : Retreat.INSTANCE.getTipSoundManager().getDisableSound()).asyncPlay(); break; }  if (value) { Retreat.INSTANCE.getHud().addNotification(new Notification(this.name, "Enabled", NotifyType.SUCCESS, 0, 0, 24, null)); } else { Retreat.INSTANCE.getHud().addNotification(new Notification(this.name, "Disabled", NotifyType.ERROR, 0, 0, 24, null)); }  }  if (value) { onEnable(); if (this.canEnable) this.state = true;  } else { onDisable(); this.state = false; }  Retreat.INSTANCE.getFileManager().saveConfig((Retreat.INSTANCE.getFileManager()).valuesConfig); } public final float getHue() { return this.hue; }
/*  94 */   public final float getSlide() { return this.slide; } public final void setSlide(float <set-?>) { this.slide = <set-?>; }
/*  95 */   public final boolean getNameBreak() { return this.nameBreak; } public final void setNameBreak(boolean <set-?>) { this.nameBreak = <set-?>; }
/*  96 */   public final float getHigt() { return this.higt; } public final void setHigt(float <set-?>) { this.higt = <set-?>; } protected void alert(@NotNull String msg) {
/*  97 */     Intrinsics.checkParameterIsNotNull(msg, "msg"); ClientUtils.displayChatMessage(msg);
/*     */   } @Nullable
/*     */   public String getTag() {
/* 100 */     return null;
/*     */   } @NotNull
/*     */   public final String getTagName() {
/* 103 */     return this.name + ((getTag() == null) ? "" : (" §7" + getTag()));
/*     */   } @NotNull
/*     */   public final String getColorlessTagName() {
/* 106 */     return this.name + ((getTag() == null) ? "" : (" " + ColorUtils.stripColor(getTag())));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void toggle() {
/* 112 */     setState(!this.state);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onToggle(boolean state) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDisable() {}
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public Value<?> getValue(@NotNull String valueName) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'valueName'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: invokevirtual getValues : ()Ljava/util/List;
/*     */     //   11: checkcast java/lang/Iterable
/*     */     //   14: astore_2
/*     */     //   15: iconst_0
/*     */     //   16: istore_3
/*     */     //   17: aload_2
/*     */     //   18: astore #4
/*     */     //   20: iconst_0
/*     */     //   21: istore #5
/*     */     //   23: aload #4
/*     */     //   25: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   30: astore #6
/*     */     //   32: aload #6
/*     */     //   34: invokeinterface hasNext : ()Z
/*     */     //   39: ifeq -> 79
/*     */     //   42: aload #6
/*     */     //   44: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   49: astore #7
/*     */     //   51: aload #7
/*     */     //   53: checkcast net/ccbluex/liquidbounce/value/Value
/*     */     //   56: astore #8
/*     */     //   58: iconst_0
/*     */     //   59: istore #9
/*     */     //   61: aload #8
/*     */     //   63: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   66: aload_1
/*     */     //   67: iconst_1
/*     */     //   68: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   71: ifeq -> 32
/*     */     //   74: aload #7
/*     */     //   76: goto -> 80
/*     */     //   79: aconst_null
/*     */     //   80: checkcast net/ccbluex/liquidbounce/value/Value
/*     */     //   83: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #133	-> 7
/*     */     //   #133	-> 61
/*     */     //   #133	-> 71
/*     */     //   #133	-> 83
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   58	13	8	it	Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   61	10	9	$i$a$-find-Module$getValue$1	I
/*     */     //   0	84	0	this	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   0	84	1	valueName	Ljava/lang/String;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public List<Value<?>> getValues() {
/* 139 */     Intrinsics.checkExpressionValueIsNotNull(getClass().getDeclaredFields(), "javaClass.declaredFields"); Field[] arrayOfField1 = getClass().getDeclaredFields(); int $i$f$map = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     Field[] arrayOfField2 = arrayOfField1; Collection<Object> collection1 = new ArrayList(arrayOfField1.length); int $i$f$mapTo = 0;
/* 150 */     for (Field item$iv$iv : arrayOfField2) {
/* 151 */       Object object1 = item$iv$iv; Collection<Object> collection = collection1; int $i$a$-map-Module$values$1 = 0; Intrinsics.checkExpressionValueIsNotNull(object1, "valueField"); object1.setAccessible(true); Object object2 = object1.get(this); collection.add(object2);
/* 152 */     }  Iterable $this$filterIsInstance$iv = collection1; int $i$f$filterIsInstance = 0;
/* 153 */     Iterable iterable1 = $this$filterIsInstance$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterIsInstanceTo = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     for (Object element$iv$iv : iterable1) { if (element$iv$iv instanceof Value) destination$iv$iv.add(element$iv$iv);  }
/* 161 */      return (List)destination$iv$iv;
/*     */   }
/*     */   
/*     */   public boolean handleEvents() {
/*     */     return this.state;
/*     */   } }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */