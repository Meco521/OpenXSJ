/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import org.lwjgl.opengl.Display;
/*    */ 
/*    */ @ModuleInfo(name = "Title", description = "Title", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\013\032\0020\f2\006\020\r\032\0020\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\006X\016¢\006\002\n\000R\016\020\b\032\0020\006X\016¢\006\002\n\000R\016\020\t\032\0020\006X\016¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/Title;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "CopywritingValue", "Lnet/ccbluex/liquidbounce/value/TextValue;", "H", "", "HM", "M", "S", "fakeNameValue", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class Title extends Module {
/* 13 */   private final TextValue fakeNameValue = new TextValue("SetTitle", "XSJ Client");
/* 14 */   private final TextValue CopywritingValue = new TextValue("Copywriting", "1.12.2");
/*    */   private int S;
/*    */   private int HM;
/*    */   private int M;
/*    */   private int H;
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 22 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.HM++;
/* 23 */     if (this.HM == 20) {
/* 24 */       this.S++;
/* 25 */       this.HM = 0;
/*    */     } 
/* 27 */     if (this.S == 60) {
/* 28 */       this.M++;
/* 29 */       this.S = 0;
/*    */     } 
/* 31 */     if (this.M == 60) {
/* 32 */       this.H++;
/* 33 */       this.M = 0;
/*    */     } 
/* 35 */     Display.setTitle((String)this.fakeNameValue.get() + " |  " + (String)this.CopywritingValue.get() + "| 凡哥/苗贺涵祝您新年快乐！ |人生有梦,各自精彩" + " | 您已成为绿色玩家" + this.H + "  时  " + this.M + "  分  " + this.S + "  秒  ");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\Title.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */