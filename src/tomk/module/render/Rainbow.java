/*    */ package tomk.module.render;
/*    */ import kotlin.jvm.JvmField;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Rainbow", category = ModuleCategory.RENDER, canEnable = false, description = "Custom")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\003\b\007\030\000 \0032\0020\001:\001\003B\005¢\006\002\020\002¨\006\004"}, d2 = {"Ltomk/module/render/Rainbow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Companion", "XSJClient"})
/*    */ public final class Rainbow extends Module {
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final FloatValue rainbowStart;
/* 13 */   public static final Companion Companion = new Companion(null); @JvmField @NotNull public static final FloatValue rainbowStop; @JvmField @NotNull public static final FloatValue rainbowSaturation; @JvmField @NotNull public static final FloatValue rainbowBrightness; static { rainbowStart = new FloatValue("Start", 0.1F, 0.0F, 1.0F);
/*    */     
/* 15 */     rainbowStop = new FloatValue("Stop", 0.2F, 0.0F, 1.0F);
/*    */     
/* 17 */     rainbowSaturation = new FloatValue("Saturation", 0.7F, 0.0F, 1.0F);
/*    */     
/* 19 */     rainbowBrightness = new FloatValue("Brightness", 1.0F, 0.0F, 1.0F);
/*    */     
/* 21 */     rainbowSpeed = new IntegerValue("Speed", 1500, 500, 7000); }
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue rainbowSpeed;
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\020\020\005\032\0020\0048\006X\004¢\006\002\n\000R\020\020\006\032\0020\0078\006X\004¢\006\002\n\000R\020\020\b\032\0020\0048\006X\004¢\006\002\n\000R\020\020\t\032\0020\0048\006X\004¢\006\002\n\000¨\006\n"}, d2 = {"Ltomk/module/render/Rainbow$Companion;", "", "()V", "rainbowBrightness", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "rainbowSaturation", "rainbowSpeed", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "rainbowStart", "rainbowStop", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\Rainbow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */