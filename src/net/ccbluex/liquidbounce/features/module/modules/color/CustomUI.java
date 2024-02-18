/*    */ package net.ccbluex.liquidbounce.features.module.modules.color;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.JvmField;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "CustomUI", description = "Custom", category = ModuleCategory.COLOR)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\003\b\007\030\000 \0032\0020\001:\001\003B\005¢\006\002\020\002¨\006\004"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/color/CustomUI;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Companion", "XSJClient"})
/*    */ public final class CustomUI extends Module {
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final FloatValue blurValue;
/* 18 */   public static final Companion Companion = new Companion(null); static { blurValue = new FloatValue("模糊强度", 15.0F, 0.0F, 30.0F); }
/*    */ 
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/color/CustomUI$Companion;", "", "()V", "blurValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\color\CustomUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */