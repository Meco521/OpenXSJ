/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.util.HashMap;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "PlayerHealthSend", description = "Debug Health", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\b\n\002\020\007\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\n\032\0020\013H\026J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\007R*\020\003\032\036\022\004\022\0020\005\022\004\022\0020\0060\004j\016\022\004\022\0020\005\022\004\022\0020\006`\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006\020"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/PlayerHealthSend;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "healthData", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/TimeUtils;", "handleEvents", "", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class PlayerHealthSend extends Module {
/* 23 */   private final TimeUtils timer = new TimeUtils();
/* 24 */   private final HashMap<Integer, Float> healthData = new HashMap<>();
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 27 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 28 */       if (MinecraftInstance.classProvider.isEntityLivingBase(event) && EntityUtils.isSelected(entity, true)) {
/* 29 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(this.healthData.getOrDefault(Integer.valueOf(MinecraftInstance.mc.getThePlayer().getEntityId()), Float.valueOf(MinecraftInstance.mc.getThePlayer().getMaxHealth())), "healthData.getOrDefault(…mc.thePlayer!!.maxHealth)"); float lastHealth = this.healthData.getOrDefault(Integer.valueOf(MinecraftInstance.mc.getThePlayer().getEntityId()), Float.valueOf(MinecraftInstance.mc.getThePlayer().getMaxHealth())).floatValue();
/* 30 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.healthData.put(Integer.valueOf(MinecraftInstance.mc.getThePlayer().getEntityId()), Float.valueOf(MinecraftInstance.mc.getThePlayer().getHealth()));
/* 31 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (lastHealth == MinecraftInstance.mc.getThePlayer().getHealth())
/* 32 */           continue;  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (lastHealth > MinecraftInstance.mc.getThePlayer().getHealth()) {
/* 33 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  ClientUtils.displayChatMessage("§c扣除血量§a" + (lastHealth - MinecraftInstance.mc.getThePlayer().getHealth()) + "HP" + " §f| " + "§c当前血量§a" + MinecraftInstance.mc.getThePlayer().getHealth() + "HP"); continue;
/*    */         } 
/* 35 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  float f1 = lastHealth - MinecraftInstance.mc.getThePlayer().getHealth(); StringBuilder stringBuilder = (new StringBuilder()).append("§c增加血量§a"); boolean bool = false; float f2 = Math.abs(f1); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  ClientUtils.displayChatMessage(stringBuilder.append(f2).append("HP").append(" §f| ").append("§c当前血量§a").append(MinecraftInstance.mc.getThePlayer().getHealth()).append("HP").toString());
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 40 */     if (this.timer.delay(220.0F)) {
/* 41 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getHealth() < 10.0F)
/* 42 */         Retreat.INSTANCE.getHud().addNotification(new Notification("XSJ Sense", "苗贺涵提醒您：您没血了", NotifyType.WARNING, 0, 0, 24, null)); 
/*    */     } 
/* 44 */     this.timer.reset();
/*    */   }
/*    */   public boolean handleEvents() {
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\PlayerHealthSend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */