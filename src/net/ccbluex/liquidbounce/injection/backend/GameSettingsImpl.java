/*    */ package net.ccbluex.liquidbounce.injection.backend;
/*    */ 
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.WEnumPlayerModelParts;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.settings.IKeyBinding;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraft.entity.player.EnumPlayerModelParts;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000N\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\007\n\002\020\007\n\002\b\005\n\002\020\b\n\002\b\006\n\002\030\002\n\002\b\023\n\002\020\"\n\002\030\002\n\002\b\n\n\002\020\000\n\002\b\003\n\002\020\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\023\0209\032\0020\0062\b\020:\032\004\030\0010;H\002J\020\020<\032\0020\0062\006\020=\032\0020\033H\026J\030\020>\032\0020?2\006\020.\032\002002\006\020@\032\0020\006H\026R\024\020\005\032\0020\0068VX\004¢\006\006\032\004\b\007\020\bR$\020\n\032\0020\0062\006\020\t\032\0020\0068V@VX\016¢\006\f\032\004\b\013\020\b\"\004\b\f\020\rR$\020\017\032\0020\0162\006\020\t\032\0020\0168V@VX\016¢\006\f\032\004\b\020\020\021\"\004\b\022\020\023R$\020\025\032\0020\0242\006\020\t\032\0020\0248V@VX\016¢\006\f\032\004\b\026\020\027\"\004\b\030\020\031R\024\020\032\032\0020\0338VX\004¢\006\006\032\004\b\034\020\035R\024\020\036\032\0020\0338VX\004¢\006\006\032\004\b\037\020\035R\024\020 \032\0020\0338VX\004¢\006\006\032\004\b!\020\035R\024\020\"\032\0020\0338VX\004¢\006\006\032\004\b#\020\035R\024\020$\032\0020\0338VX\004¢\006\006\032\004\b%\020\035R\024\020&\032\0020\0338VX\004¢\006\006\032\004\b'\020\035R\024\020(\032\0020\0338VX\004¢\006\006\032\004\b)\020\035R\024\020*\032\0020\0338VX\004¢\006\006\032\004\b+\020\035R\024\020,\032\0020\0338VX\004¢\006\006\032\004\b-\020\035R\032\020.\032\b\022\004\022\002000/8VX\004¢\006\006\032\004\b1\0202R\024\0203\032\0020\0168VX\004¢\006\006\032\004\b4\020\021R\024\0205\032\0020\0248VX\004¢\006\006\032\004\b6\020\027R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b7\0208¨\006A"}, d2 = {"Lnet/ccbluex/liquidbounce/injection/backend/GameSettingsImpl;", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "wrapped", "Lnet/minecraft/client/settings/GameSettings;", "(Lnet/minecraft/client/settings/GameSettings;)V", "advancedItemTooltips", "", "getAdvancedItemTooltips", "()Z", "value", "entityShadows", "getEntityShadows", "setEntityShadows", "(Z)V", "", "gammaSetting", "getGammaSetting", "()F", "setGammaSetting", "(F)V", "", "guiScale", "getGuiScale", "()I", "setGuiScale", "(I)V", "keyBindAttack", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "getKeyBindAttack", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "keyBindBack", "getKeyBindBack", "keyBindForward", "getKeyBindForward", "keyBindJump", "getKeyBindJump", "keyBindLeft", "getKeyBindLeft", "keyBindRight", "getKeyBindRight", "keyBindSneak", "getKeyBindSneak", "keyBindSprint", "getKeyBindSprint", "keyBindUseItem", "getKeyBindUseItem", "modelParts", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/WEnumPlayerModelParts;", "getModelParts", "()Ljava/util/Set;", "mouseSensitivity", "getMouseSensitivity", "thirdPersonView", "getThirdPersonView", "getWrapped", "()Lnet/minecraft/client/settings/GameSettings;", "equals", "other", "", "isKeyDown", "key", "setModelPartEnabled", "", "enabled", "XSJClient"})
/*    */ public final class GameSettingsImpl implements IGameSettings {
/*    */   @NotNull
/* 13 */   public final GameSettings getWrapped() { return this.wrapped; } @NotNull private final GameSettings wrapped; public GameSettingsImpl(@NotNull GameSettings wrapped) { this.wrapped = wrapped; }
/*    */    public boolean getEntityShadows() {
/* 15 */     return this.wrapped.field_181151_V;
/*    */   } public void setEntityShadows(boolean value) {
/* 17 */     this.wrapped.field_181151_V = value;
/*    */   }
/*    */   public int getThirdPersonView() {
/* 20 */     return this.wrapped.field_74320_O;
/*    */   } public int getGuiScale() {
/* 22 */     return (int)this.wrapped.field_74333_Y;
/*    */   } public void setGuiScale(int value) {
/* 24 */     this.wrapped.field_74333_Y = value;
/*    */   }
/*    */   
/*    */   public float getGammaSetting() {
/* 28 */     return this.wrapped.field_74333_Y;
/*    */   } public void setGammaSetting(float value) {
/* 30 */     this.wrapped.field_74333_Y = value;
/*    */   } @NotNull
/*    */   public Set<WEnumPlayerModelParts> getModelParts() {
/* 33 */     Intrinsics.checkExpressionValueIsNotNull(this.wrapped.func_178876_d(), "wrapped.modelParts"); return (Set<WEnumPlayerModelParts>)new WrappedSet(this.wrapped.func_178876_d(), GameSettingsImpl$modelParts$1.INSTANCE, GameSettingsImpl$modelParts$2.INSTANCE);
/*    */   }
/* 35 */   public float getMouseSensitivity() { return this.wrapped.field_74341_c; }
/*    */   @NotNull
/* 37 */   public IKeyBinding getKeyBindAttack() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74312_F, "wrapped.keyBindAttack"); KeyBinding $this$wrap$iv = this.wrapped.field_74312_F; int $i$f$wrap = 0; return 
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
/* 68 */       new KeyBindingImpl($this$wrap$iv); } public boolean getAdvancedItemTooltips() { return this.wrapped.field_82882_x; }
/* 69 */   @NotNull public IKeyBinding getKeyBindUseItem() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74313_G, "wrapped.keyBindUseItem"); KeyBinding $this$wrap$iv = this.wrapped.field_74313_G; int $i$f$wrap = 0; return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindJump() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74314_A, "wrapped.keyBindJump"); KeyBinding $this$wrap$iv = this.wrapped.field_74314_A; int $i$f$wrap = 0;
/* 70 */     return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindSneak() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74311_E, "wrapped.keyBindSneak"); KeyBinding $this$wrap$iv = this.wrapped.field_74311_E; int $i$f$wrap = 0;
/* 71 */     return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindForward() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74351_w, "wrapped.keyBindForward"); KeyBinding $this$wrap$iv = this.wrapped.field_74351_w; int $i$f$wrap = 0;
/* 72 */     return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindBack() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74368_y, "wrapped.keyBindBack"); KeyBinding $this$wrap$iv = this.wrapped.field_74368_y; int $i$f$wrap = 0;
/* 73 */     return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindRight() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74366_z, "wrapped.keyBindRight"); KeyBinding $this$wrap$iv = this.wrapped.field_74366_z; int $i$f$wrap = 0;
/* 74 */     return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindLeft() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_74370_x, "wrapped.keyBindLeft"); KeyBinding $this$wrap$iv = this.wrapped.field_74370_x; int $i$f$wrap = 0;
/* 75 */     return new KeyBindingImpl($this$wrap$iv); } @NotNull public IKeyBinding getKeyBindSprint() { Intrinsics.checkExpressionValueIsNotNull(this.wrapped.field_151444_V, "wrapped.keyBindSprint"); KeyBinding $this$wrap$iv = this.wrapped.field_151444_V; int $i$f$wrap = 0;
/* 76 */     return new KeyBindingImpl($this$wrap$iv); } public boolean isKeyDown(@NotNull IKeyBinding key) { Intrinsics.checkParameterIsNotNull(key, "key"); IKeyBinding $this$unwrap$iv = key; int $i$f$unwrap = 0;
/* 77 */     return GameSettings.func_100015_a(((KeyBindingImpl)$this$unwrap$iv).getWrapped()); }
/*    */ 
/*    */   
/*    */   public void setModelPartEnabled(@NotNull WEnumPlayerModelParts modelParts, boolean enabled) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 'modelParts'
/*    */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getfield wrapped : Lnet/minecraft/client/settings/GameSettings;
/*    */     //   10: aload_1
/*    */     //   11: astore_3
/*    */     //   12: astore #5
/*    */     //   14: iconst_0
/*    */     //   15: istore #4
/*    */     //   17: aload_3
/*    */     //   18: getstatic net/ccbluex/liquidbounce/injection/backend/utils/BackendExtentionsKt$WhenMappings.$EnumSwitchMapping$1 : [I
/*    */     //   21: swap
/*    */     //   22: invokevirtual ordinal : ()I
/*    */     //   25: iaload
/*    */     //   26: tableswitch default -> 110, 1 -> 68, 2 -> 74, 3 -> 80, 4 -> 86, 5 -> 92, 6 -> 98, 7 -> 104
/*    */     //   68: getstatic net/minecraft/entity/player/EnumPlayerModelParts.CAPE : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   71: goto -> 118
/*    */     //   74: getstatic net/minecraft/entity/player/EnumPlayerModelParts.JACKET : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   77: goto -> 118
/*    */     //   80: getstatic net/minecraft/entity/player/EnumPlayerModelParts.LEFT_SLEEVE : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   83: goto -> 118
/*    */     //   86: getstatic net/minecraft/entity/player/EnumPlayerModelParts.RIGHT_SLEEVE : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   89: goto -> 118
/*    */     //   92: getstatic net/minecraft/entity/player/EnumPlayerModelParts.LEFT_PANTS_LEG : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   95: goto -> 118
/*    */     //   98: getstatic net/minecraft/entity/player/EnumPlayerModelParts.RIGHT_PANTS_LEG : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   101: goto -> 118
/*    */     //   104: getstatic net/minecraft/entity/player/EnumPlayerModelParts.HAT : Lnet/minecraft/entity/player/EnumPlayerModelParts;
/*    */     //   107: goto -> 118
/*    */     //   110: new kotlin/NoWhenBranchMatchedException
/*    */     //   113: dup
/*    */     //   114: invokespecial <init> : ()V
/*    */     //   117: athrow
/*    */     //   118: astore #6
/*    */     //   120: aload #5
/*    */     //   122: aload #6
/*    */     //   124: iload_2
/*    */     //   125: invokevirtual func_178878_a : (Lnet/minecraft/entity/player/EnumPlayerModelParts;Z)V
/*    */     //   128: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #59	-> 6
/*    */     //   #78	-> 17
/*    */     //   #79	-> 68
/*    */     //   #80	-> 74
/*    */     //   #81	-> 80
/*    */     //   #82	-> 86
/*    */     //   #83	-> 92
/*    */     //   #84	-> 98
/*    */     //   #85	-> 104
/*    */     //   #59	-> 124
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   14	104	3	$this$unwrap$iv	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/WEnumPlayerModelParts;
/*    */     //   17	101	4	$i$f$unwrap	I
/*    */     //   0	129	0	this	Lnet/ccbluex/liquidbounce/injection/backend/GameSettingsImpl;
/*    */     //   0	129	1	modelParts	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/WEnumPlayerModelParts;
/*    */     //   0	129	2	enabled	Z
/*    */   }
/*    */   
/*    */   public boolean equals(@Nullable Object other) {
/*    */     return (other instanceof GameSettingsImpl && Intrinsics.areEqual(((GameSettingsImpl)other).wrapped, this.wrapped));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\backend\GameSettingsImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */