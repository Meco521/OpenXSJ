/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderWings;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import net.ccbluex.liquidbounce.value.Value;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Wings", description = "Wings", category = ModuleCategory.RENDER, array = false)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0004\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\b\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\026\032\0020\0272\006\020\030\032\0020\031H\007R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007R\027\020\b\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\t\020\007R\027\020\n\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\013\020\007R\021\020\f\032\0020\r¢\006\b\n\000\032\004\b\016\020\017R\016\020\020\032\0020\021X\004¢\006\002\n\000R\032\020\022\032\0020\rX\016¢\006\016\n\000\032\004\b\023\020\017\"\004\b\024\020\025¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Wings;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "CB", "Lnet/ccbluex/liquidbounce/value/Value;", "", "getCB", "()Lnet/ccbluex/liquidbounce/value/Value;", "CG", "getCG", "CR", "getCR", "ColourType", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getColourType", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "onlyThirdPerson", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "wingStyle", "getWingStyle", "setWingStyle", "(Lnet/ccbluex/liquidbounce/value/ListValue;)V", "onRenderPlayer", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class Wings extends Module {
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/* 23 */   static final class Wings$CR$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((String)Wings.this.getColourType().get()).equals("Custom"); } Wings$CR$1() { super(0); } }
/* 24 */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Wings$CG$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((String)Wings.this.getColourType().get()).equals("Custom"); } Wings$CG$1() { super(0); } }
/* 25 */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Wings$CB$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return ((String)Wings.this.getColourType().get()).equals("Custom"); } Wings$CB$1() { super(0); } } private final BoolValue onlyThirdPerson = new BoolValue("OnlyThirdPerson", true); @NotNull private final ListValue ColourType = new ListValue("Color-Type", new String[] { "Custom", "Chroma", "None" }, "Chroma"); @NotNull public final ListValue getColourType() { return this.ColourType; } @NotNull private final Value<Integer> CB = (new IntegerValue("B", 255, 0, 255)).displayable(new Wings$CB$1()); @NotNull private final Value<Integer> CR = (new IntegerValue("R", 255, 0, 255)).displayable(new Wings$CR$1()); @NotNull public final Value<Integer> getCR() { return this.CR; } @NotNull public final Value<Integer> getCB() { return this.CB; }
/* 26 */   @NotNull private final Value<Integer> CG = (new IntegerValue("G", 255, 0, 255)).displayable(new Wings$CG$1()); @NotNull public final Value<Integer> getCG() { return this.CG; } @NotNull private ListValue wingStyle = new ListValue("WingStyle", new String[] { "Dragon", "Simple" }, "Dragon"); @NotNull public final ListValue getWingStyle() { return this.wingStyle; } public final void setWingStyle(@NotNull ListValue <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.wingStyle = <set-?>; }
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onRenderPlayer(@NotNull Render3DEvent event) {
/* 31 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.onlyThirdPerson.get()).booleanValue() && MinecraftInstance.mc2.field_71474_y.field_74320_O == 0)
/* 32 */       return;  RenderWings renderWings = new RenderWings();
/* 33 */     renderWings.renderWings(event.getPartialTicks());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Wings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */