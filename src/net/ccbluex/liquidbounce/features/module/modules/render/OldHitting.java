/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "OldHitting", description = "faq", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\006\b\007\030\000 \r2\0020\001:\001\rB\005¢\006\002\020\002J\006\020\013\032\0020\004J\006\020\f\032\0020\006R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\024\020\007\032\0020\b8VX\004¢\006\006\032\004\b\t\020\n¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/OldHitting;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "onlySword", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "tag", "", "getTag", "()Ljava/lang/String;", "getModeValue", "getOnlySword", "Companion", "XSJClient"})
/*    */ public final class OldHitting extends Module {
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue SpeedSwing;
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static FloatValue itemPosX;
/* 14 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "MineCraft", "Reverse", "Strange", "ETB", "Test", "Jello", "SigmaOld", "Zoom", "Push", "SideDown" }, "MineCraft"); @JvmField @NotNull public static FloatValue itemPosY; @JvmField
/*    */   @NotNull
/* 16 */   public static FloatValue itemPosZ; private final BoolValue onlySword = new BoolValue("Only-Sword", true); @JvmField @NotNull public static FloatValue Scale; @JvmField @Nullable public static final ListValue guiAnimations; @JvmField
/*    */   @NotNull
/*    */   public static final ListValue tabAnimations; @NotNull
/* 19 */   public final ListValue getModeValue() { return this.modeValue; }
/*    */   
/*    */   @NotNull
/*    */   public final BoolValue getOnlySword() {
/* 23 */     return this.onlySword;
/*    */   }
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000R\020\020\005\032\0020\0068\006X\004¢\006\002\n\000R\022\020\007\032\004\030\0010\b8\006X\004¢\006\002\n\000R\022\020\t\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\n\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\013\032\0020\0048\006@\006X\016¢\006\002\n\000R\020\020\f\032\0020\b8\006X\004¢\006\002\n\000¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/OldHitting$Companion;", "", "()V", "Scale", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "SpeedSwing", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "guiAnimations", "Lnet/ccbluex/liquidbounce/value/ListValue;", "itemPosX", "itemPosY", "itemPosZ", "tabAnimations", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {} }
/* 28 */   public static final Companion Companion = new Companion(null); static { SpeedSwing = new IntegerValue("SpeedSwing", 4, 0, 20);
/*    */     
/* 30 */     itemPosX = new FloatValue("itemPosX", 0.0F, -1.0F, 1.0F);
/*    */     
/* 32 */     itemPosY = new FloatValue("itemPosY", 0.0F, -1.0F, 1.0F);
/*    */     
/* 34 */     itemPosZ = new FloatValue("itemPosZ", 0.0F, -1.0F, 1.0F);
/*    */     
/* 36 */     Scale = new FloatValue("Scale", 1.0F, 0.0F, 2.0F);
/*    */     
/* 38 */     guiAnimations = new ListValue("Container-Animation", new String[] { "None", "Zoom", "VSlide", "HSlide", "HVSlide" }, "Zoom");
/*    */     
/* 40 */     tabAnimations = new ListValue("Tab-Animation", new String[] { "None", "Zoom", "Slide" }, "Zoom"); }
/*    */    @NotNull
/*    */   public String getTag() {
/* 43 */     return (String)this.modeValue.get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\OldHitting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */