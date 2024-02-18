/*     */ package net.ccbluex.liquidbounce.script.api;
/*     */ 
/*     */ import jdk.nashorn.api.scripting.JSObject;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "ScriptModule", description = "Empty", category = ModuleCategory.MISC)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000È\001\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\f\n\002\020 \n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\000\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\034\020\035\032\0020\0362\006\020\037\032\0020\0062\n\b\002\020 \032\004\030\0010!H\002J\026\020\"\032\0020\0362\006\020\037\032\0020\0062\006\020#\032\0020\003J\020\020$\032\0020\0362\006\020%\032\0020&H\007J\020\020'\032\0020\0362\006\020(\032\0020)H\007J\b\020*\032\0020\036H\026J\b\020+\032\0020\036H\026J\020\020,\032\0020\0362\006\020-\032\0020.H\007J\020\020/\032\0020\0362\006\0200\032\00201H\007J\020\0202\032\0020\0362\006\0203\032\00204H\007J\020\0205\032\0020\0362\006\0206\032\00207H\007J\020\0208\032\0020\0362\006\0209\032\0020:H\007J\020\020;\032\0020\0362\006\020<\032\0020=H\007J\020\020>\032\0020\0362\006\020?\032\0020@H\007J\020\020A\032\0020\0362\006\020B\032\0020CH\007J\020\020D\032\0020\0362\006\020E\032\0020FH\007J\020\020G\032\0020\0362\006\020H\032\0020IH\007J\020\020J\032\0020\0362\006\020K\032\0020LH\007J\020\020M\032\0020\0362\006\020N\032\0020OH\007J\020\020P\032\0020\0362\006\020Q\032\0020RH\007J\020\020S\032\0020\0362\006\020T\032\0020UH\007R\020\020\005\032\004\030\0010\006X\016¢\006\002\n\000R2\020\007\032&\022\004\022\0020\006\022\b\022\006\022\002\b\0030\t0\bj\022\022\004\022\0020\006\022\b\022\006\022\002\b\0030\t`\nX\004¢\006\002\n\000R*\020\013\032\036\022\004\022\0020\006\022\004\022\0020\0030\fj\016\022\004\022\0020\006\022\004\022\0020\003`\rX\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R?\020\016\032&\022\004\022\0020\006\022\b\022\006\022\002\b\0030\t0\bj\022\022\004\022\0020\006\022\b\022\006\022\002\b\0030\t`\n8FX\002¢\006\f\n\004\b\021\020\022\032\004\b\017\020\020R(\020\024\032\004\030\0010\0062\b\020\023\032\004\030\0010\0068V@VX\016¢\006\f\032\004\b\025\020\026\"\004\b\027\020\030R\036\020\031\032\f\022\b\022\006\022\002\b\0030\t0\0328VX\004¢\006\006\032\004\b\033\020\034¨\006V"}, d2 = {"Lnet/ccbluex/liquidbounce/script/api/ScriptModule;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "moduleObject", "Ljdk/nashorn/api/scripting/JSObject;", "(Ljdk/nashorn/api/scripting/JSObject;)V", "_tag", "", "_values", "Ljava/util/LinkedHashMap;", "Lnet/ccbluex/liquidbounce/value/Value;", "Lkotlin/collections/LinkedHashMap;", "events", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "settings", "getSettings", "()Ljava/util/LinkedHashMap;", "settings$delegate", "Lkotlin/Lazy;", "value", "tag", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "values", "", "getValues", "()Ljava/util/List;", "callEvent", "", "eventName", "payload", "", "on", "handler", "onAttack", "attackEvent", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "onClickBlock", "clickBlockEvent", "Lnet/ccbluex/liquidbounce/event/ClickBlockEvent;", "onDisable", "onEnable", "onJump", "jumpEvent", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onKey", "keyEvent", "Lnet/ccbluex/liquidbounce/event/KeyEvent;", "onMotion", "motionEvent", "Lnet/ccbluex/liquidbounce/event/MotionEvent;", "onMove", "moveEvent", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "packetEvent", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender2D", "render2DEvent", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "render3DEvent", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onSession", "sessionEvent", "Lnet/ccbluex/liquidbounce/event/SessionEvent;", "onSlowDown", "slowDownEvent", "Lnet/ccbluex/liquidbounce/event/SlowDownEvent;", "onStep", "stepEvent", "Lnet/ccbluex/liquidbounce/event/StepEvent;", "onStepConfirm", "stepConfirmEvent", "Lnet/ccbluex/liquidbounce/event/StepConfirmEvent;", "onStrafe", "strafeEvent", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "updateEvent", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "worldEvent", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "XSJClient"})
/*     */ public final class ScriptModule extends Module {
/*     */   private final HashMap<String, JSObject> events;
/*     */   private final LinkedHashMap<String, Value<?>> _values;
/*     */   
/*  13 */   public ScriptModule(@NotNull JSObject moduleObject) { this.moduleObject = moduleObject;
/*     */     
/*  15 */     this.events = new HashMap<>();
/*  16 */     this._values = new LinkedHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  22 */     this.settings$delegate = LazyKt.lazy(new ScriptModule$settings$2());
/*     */ 
/*     */     
/*  25 */     if (this.moduleObject.getMember("name") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  setName((String)this.moduleObject.getMember("name"));
/*  26 */     if (this.moduleObject.getMember("description") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  setDescription((String)this.moduleObject.getMember("description"));
/*     */     
/*  28 */     if (this.moduleObject.getMember("category") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  String categoryString = (String)this.moduleObject.getMember("category");
/*  29 */     for (ModuleCategory category : ModuleCategory.values()) {
/*  30 */       if (StringsKt.equals(categoryString, category.getDisplayName(), true))
/*  31 */         setCategory(category); 
/*     */     } 
/*  33 */     if (this.moduleObject.hasMember("settings")) {
/*  34 */       if (this.moduleObject.getMember("settings") == null) throw new TypeCastException("null cannot be cast to non-null type jdk.nashorn.api.scripting.JSObject");  JSObject settings = (JSObject)this.moduleObject.getMember("settings");
/*     */       
/*  36 */       for (String settingName : settings.keySet()) {
/*  37 */         Intrinsics.checkExpressionValueIsNotNull(settingName, "settingName"); if (settings.getMember(settingName) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.value.Value<*>");  this._values.put(settingName, (Value)settings.getMember(settingName));
/*     */       } 
/*     */     } 
/*  40 */     if (this.moduleObject.hasMember("tag")) {
/*  41 */       if (this.moduleObject.getMember("tag") == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.String");  this._tag = (String)this.moduleObject.getMember("tag");
/*     */     }  }
/*     */   private String _tag;
/*     */   @NotNull private final Lazy settings$delegate; private final JSObject moduleObject; @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\024\n\000\n\002\030\002\n\002\020\016\n\002\030\002\n\002\030\002\n\000\020\000\032&\022\004\022\0020\002\022\b\022\006\022\002\b\0030\0030\001j\022\022\004\022\0020\002\022\b\022\006\022\002\b\0030\003`\004H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "Ljava/util/LinkedHashMap;", "", "Lnet/ccbluex/liquidbounce/value/Value;", "Lkotlin/collections/LinkedHashMap;", "invoke"}) static final class ScriptModule$settings$2 extends Lambda implements Function0<LinkedHashMap<String, Value<?>>> {
/*     */     @NotNull public final LinkedHashMap<String, Value<?>> invoke() { return ScriptModule.this._values; } ScriptModule$settings$2() { super(0); } } @NotNull
/*  46 */   public List<Value<?>> getValues() { Intrinsics.checkExpressionValueIsNotNull(this._values.values(), "_values.values"); return CollectionsKt.toList(this._values.values()); }
/*     */   
/*     */   @Nullable
/*     */   public String getTag() {
/*  50 */     return this._tag;
/*     */   } public void setTag(@Nullable String value) {
/*  52 */     this._tag = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void on(@NotNull String eventName, @NotNull JSObject handler) {
/*  61 */     Intrinsics.checkParameterIsNotNull(eventName, "eventName"); Intrinsics.checkParameterIsNotNull(handler, "handler"); this.events.put(eventName, handler);
/*     */   }
/*     */   public void onEnable() {
/*  64 */     callEvent$default(this, "enable", (Object)null, 2, (Object)null);
/*     */   } public void onDisable() {
/*  66 */     callEvent$default(this, "disable", (Object)null, 2, (Object)null);
/*     */   } @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent updateEvent) {
/*  69 */     Intrinsics.checkParameterIsNotNull(updateEvent, "updateEvent"); callEvent$default(this, "update", (Object)null, 2, (Object)null);
/*     */   } @EventTarget
/*     */   public final void onMotion(@NotNull MotionEvent motionEvent) {
/*  72 */     Intrinsics.checkParameterIsNotNull(motionEvent, "motionEvent"); callEvent("motion", motionEvent);
/*     */   } @EventTarget
/*     */   public final void onRender2D(@NotNull Render2DEvent render2DEvent) {
/*  75 */     Intrinsics.checkParameterIsNotNull(render2DEvent, "render2DEvent"); callEvent("render2D", render2DEvent);
/*     */   } @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent render3DEvent) {
/*  78 */     Intrinsics.checkParameterIsNotNull(render3DEvent, "render3DEvent"); callEvent("render3D", render3DEvent);
/*     */   } @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent packetEvent) {
/*  81 */     Intrinsics.checkParameterIsNotNull(packetEvent, "packetEvent"); callEvent("packet", packetEvent);
/*     */   } @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent jumpEvent) {
/*  84 */     Intrinsics.checkParameterIsNotNull(jumpEvent, "jumpEvent"); callEvent("jump", jumpEvent);
/*     */   } @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent attackEvent) {
/*  87 */     Intrinsics.checkParameterIsNotNull(attackEvent, "attackEvent"); callEvent("attack", attackEvent);
/*     */   } @EventTarget
/*     */   public final void onKey(@NotNull KeyEvent keyEvent) {
/*  90 */     Intrinsics.checkParameterIsNotNull(keyEvent, "keyEvent"); callEvent("key", keyEvent);
/*     */   } @EventTarget
/*     */   public final void onMove(@NotNull MoveEvent moveEvent) {
/*  93 */     Intrinsics.checkParameterIsNotNull(moveEvent, "moveEvent"); callEvent("move", moveEvent);
/*     */   } @EventTarget
/*     */   public final void onStep(@NotNull StepEvent stepEvent) {
/*  96 */     Intrinsics.checkParameterIsNotNull(stepEvent, "stepEvent"); callEvent("step", stepEvent);
/*     */   } @EventTarget
/*     */   public final void onStepConfirm(@NotNull StepConfirmEvent stepConfirmEvent) {
/*  99 */     Intrinsics.checkParameterIsNotNull(stepConfirmEvent, "stepConfirmEvent"); callEvent$default(this, "stepConfirm", (Object)null, 2, (Object)null);
/*     */   } @EventTarget
/*     */   public final void onWorld(@NotNull WorldEvent worldEvent) {
/* 102 */     Intrinsics.checkParameterIsNotNull(worldEvent, "worldEvent"); callEvent("world", worldEvent);
/*     */   } @EventTarget
/*     */   public final void onSession(@NotNull SessionEvent sessionEvent) {
/* 105 */     Intrinsics.checkParameterIsNotNull(sessionEvent, "sessionEvent"); callEvent$default(this, "session", (Object)null, 2, (Object)null);
/*     */   } @EventTarget
/*     */   public final void onClickBlock(@NotNull ClickBlockEvent clickBlockEvent) {
/* 108 */     Intrinsics.checkParameterIsNotNull(clickBlockEvent, "clickBlockEvent"); callEvent("clickBlock", clickBlockEvent);
/*     */   } @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent strafeEvent) {
/* 111 */     Intrinsics.checkParameterIsNotNull(strafeEvent, "strafeEvent"); callEvent("strafe", strafeEvent);
/*     */   } @EventTarget
/*     */   public final void onSlowDown(@NotNull SlowDownEvent slowDownEvent) {
/* 114 */     Intrinsics.checkParameterIsNotNull(slowDownEvent, "slowDownEvent"); callEvent("slowDown", slowDownEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void callEvent(String eventName, Object payload) {
/*     */     try {
/* 123 */       if ((JSObject)this.events.get(eventName) != null) { ((JSObject)this.events.get(eventName)).call(this.moduleObject, new Object[] { payload }); } else { (JSObject)this.events.get(eventName); } 
/* 124 */     } catch (Throwable throwable) {
/* 125 */       ClientUtils.getLogger().error("[ScriptAPI] Exception in module '" + getName() + "'!", throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final LinkedHashMap<String, Value<?>> getSettings() {
/*     */     Lazy lazy = this.settings$delegate;
/*     */     ScriptModule scriptModule = this;
/*     */     KProperty kProperty = $$delegatedProperties[0];
/*     */     boolean bool = false;
/*     */     return (LinkedHashMap<String, Value<?>>)lazy.getValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\script\api\ScriptModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */