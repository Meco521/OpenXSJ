/*    */ package liying.module.misc;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AntiHacker", description = "可以让开了HytGetName的人不打你", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\017\032\0020\0202\006\020\021\032\0020\022R\016\020\003\032\0020\004X\004¢\006\002\n\000R\032\020\005\032\0020\006X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\r\020\016¨\006\023"}, d2 = {"Lliying/module/misc/AntiHacker;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Name", "Lnet/ccbluex/liquidbounce/value/TextValue;", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "msTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getMsTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AntiHacker extends Module {
/*    */   static {
/* 17 */     AntiHacker antiHacker = new AntiHacker();
/*    */   }
/* 19 */   private static final TextValue Name = new TextValue("YourName", "Me");
/* 20 */   private static long delay = TimeUtils.randomDelay(500, 5000); public final long getDelay() { return delay; } public final void setDelay(long <set-?>) { delay = <set-?>; } @NotNull
/* 21 */   private static final MSTimer msTimer = new MSTimer(); @NotNull public final MSTimer getMsTimer() { return msTimer; }
/*    */    public static final AntiHacker INSTANCE;
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 24 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (msTimer.hasTimePassed(delay)) {
/* 25 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().sendChatMessage("杀死了" + Name);
/* 26 */       delay = TimeUtils.randomDelay(500, 5000);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\liying\module\misc\AntiHacker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */