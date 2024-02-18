/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ElementInfo(name = "Notifications", single = true)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\006\020\f\032\0020\rJ\n\020\016\032\004\030\0010\017H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notifications;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "exampleNotification", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/Notification;", "drawBoarderBlur", "", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class Notifications
/*    */   extends Element {
/*    */   public Notifications(double x, double y, float scale, @NotNull Side side) {
/* 22 */     super(x, y, scale, side);
/*    */     
/* 24 */     this.exampleNotification = new Notification("Notification", "", NotifyType.INFO, 0, 0, 24, null);
/*    */   } private final Notification exampleNotification;
/*    */   @Nullable
/*    */   public Border drawElement() {
/* 28 */     byte b = 0; List<Notification> notifications = new ArrayList();
/* 29 */     b = 0; for (Notification notify : Retreat.INSTANCE.getHud().getNotifications()) {
/* 30 */       GL11.glPushMatrix();
/*    */       
/* 32 */       if (notify.drawNotification(b, (float)getRenderX(), (float)getRenderY(), getScale(), this)) {
/* 33 */         notifications.add(notify);
/*    */       }
/*    */       
/* 36 */       GL11.glPopMatrix(); b++;
/*    */     } 
/* 38 */     for (Notification notify : notifications) {
/* 39 */       Retreat.INSTANCE.getHud().getNotifications().remove(notify);
/*    */     }
/*    */     
/* 42 */     if (MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen())) {
/* 43 */       if (!Retreat.INSTANCE.getHud().getNotifications().contains(this.exampleNotification)) {
/* 44 */         Retreat.INSTANCE.getHud().addNotification(this.exampleNotification);
/*    */       }
/* 46 */       this.exampleNotification.setFadeState(FadeState.STAY);
/* 47 */       this.exampleNotification.setDisplayTime(System.currentTimeMillis());
/*    */       
/* 49 */       return new Border(-this.exampleNotification.getWidth(), -(this.exampleNotification.getHeight()), 0.0F, 0.0F);
/*    */     } 
/*    */     
/* 52 */     return null;
/*    */   }
/*    */   
/*    */   public final void drawBoarderBlur() {}
/*    */   
/*    */   public Notifications() {
/*    */     this(0.0D, 0.0D, 0.0F, (Side)null, 15, (DefaultConstructorMarker)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\Notifications.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */