/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification;
/*    */ 
/*    */ @ModuleInfo(name = "IQBoost", description = "一瓶即可提升IQ至300，追慕大蛇倾情推荐", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/IQBoost;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class IQBoost extends Module {
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 15 */     Intrinsics.checkParameterIsNotNull(event, "event"); Retreat.INSTANCE.getHud().addNotification(new Notification("IqBoost", "已将iq提升到300", NotifyType.INFO, 0, 6000, 8, null));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\IQBoost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */