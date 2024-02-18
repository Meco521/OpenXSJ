/*    */ package tomk.module.render;
/*    */ import kotlin.jvm.JvmField;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "Gident", description = "Custom", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\003\b\007\030\000 \0032\0020\001:\001\003B\005¢\006\002\020\002¨\006\004"}, d2 = {"Ltomk/module/render/Gident;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Companion", "XSJClient"})
/*    */ public final class Gident extends Module {
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue gidentspeed;
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue redValue;
/* 15 */   public static final Companion Companion = new Companion(null); @JvmField @NotNull public static final IntegerValue greenValue; @JvmField @NotNull public static final IntegerValue blueValue; @JvmField @NotNull public static final IntegerValue redValue2; @JvmField @NotNull public static final IntegerValue greenValue2; static { gidentspeed = new IntegerValue("GidentSpeed", 100, 1, 1000);
/*    */ 
/*    */     
/* 18 */     redValue = new IntegerValue("Red", 255, 0, 255);
/*    */     
/* 20 */     greenValue = new IntegerValue("Green", 255, 0, 255);
/*    */     
/* 22 */     blueValue = new IntegerValue("Blue", 255, 0, 255);
/*    */     
/* 24 */     redValue2 = new IntegerValue("Red2", 255, 0, 255);
/*    */     
/* 26 */     greenValue2 = new IntegerValue("Green2", 255, 0, 255);
/*    */     
/* 28 */     blueValue2 = new IntegerValue("Blue2", 255, 0, 255); }
/*    */ 
/*    */   
/*    */   @JvmField
/*    */   @NotNull
/*    */   public static final IntegerValue blueValue2;
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\020\020\005\032\0020\0048\006X\004¢\006\002\n\000R\020\020\006\032\0020\0048\006X\004¢\006\002\n\000R\020\020\007\032\0020\0048\006X\004¢\006\002\n\000R\020\020\b\032\0020\0048\006X\004¢\006\002\n\000R\020\020\t\032\0020\0048\006X\004¢\006\002\n\000R\020\020\n\032\0020\0048\006X\004¢\006\002\n\000¨\006\013"}, d2 = {"Ltomk/module/render/Gident$Companion;", "", "()V", "blueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blueValue2", "gidentspeed", "greenValue", "greenValue2", "redValue", "redValue2", "XSJClient"})
/*    */   public static final class Companion {
/*    */     private Companion() {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\tomk\module\render\Gident.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */