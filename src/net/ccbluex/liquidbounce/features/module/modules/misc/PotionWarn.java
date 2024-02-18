/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.potion.IPotion;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "PotionWarn", description = "Check Potion Warn", category = ModuleCategory.MISC)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\020\032\0020\0212\006\020\022\032\0020\023H\007J\022\020\024\032\004\030\0010\0252\006\020\026\032\0020\006H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\004X\004¢\006\002\n\000¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/PotionWarn;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "checkDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "checkPotionName", "", "checkPotionNameValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "distanceValue", "messageDelayValue", "messageValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "ms", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "noticeDistanceValue", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "potionActiveName", "Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;", "potionName", "XSJClient"})
/*    */ public final class PotionWarn extends Module {
/* 25 */   private final ListValue checkPotionNameValue = new ListValue("CheckPotionName", new String[] { "DamageBoost", "MoveSpeed", "Jump", "Regen" }, "DamageBoost");
/* 26 */   private final IntegerValue checkDelayValue = new IntegerValue("CheckDelay", 2, 2, 100);
/* 27 */   private final IntegerValue messageDelayValue = new IntegerValue("MessageDelay", 25, 10, 100);
/* 28 */   private final BoolValue messageValue = new BoolValue("CheckMessage", true);
/* 29 */   private String checkPotionName = "";
/* 30 */   private final IntegerValue distanceValue = new IntegerValue("WarnDistance", 14, 4, 20);
/* 31 */   private final IntegerValue noticeDistanceValue = new IntegerValue("NoticeDistance", 45, 20, 100);
/*    */   
/* 33 */   private final MSTimer ms = new MSTimer();
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 37 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getTicksExisted() % ((Number)this.checkDelayValue.get()).intValue() == 0) {
/* 38 */       if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/*    */         
/* 40 */         if (entity != null && (Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0 && MinecraftInstance.classProvider.isEntityPlayer(entity)) { if (potionActiveName((String)this.checkPotionNameValue.get()) == null) Intrinsics.throwNpe();  if (entity.asEntityLivingBase().isPotionActive(potionActiveName((String)this.checkPotionNameValue.get())) && EntityUtils.isSelected(
/* 41 */               entity, 
/* 42 */               true))
/*    */           {
/*    */             
/* 45 */             if (((Boolean)this.messageValue.get()).booleanValue() && this.ms.hasTimePassed(((Number)this.messageDelayValue.get()).intValue())) {
/* 46 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getDistanceToEntity(entity) >= ((Number)this.noticeDistanceValue.get()).floatValue())
/* 47 */                 return;  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getDistanceToEntity(entity) >= ((Number)this.distanceValue.get()).floatValue()) {
/*    */ 
/*    */                 
/* 50 */                 if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*    */                 
/* 52 */                 ClientUtils.displayChatMessage("§8[§bPotionWarn§8] §c" + entity.getName() + "§f拥有§c" + this.checkPotionName + "§f药水效果，距你" + (int)MinecraftInstance.mc.getThePlayer().getDistanceToEntity(entity) + "米!");
/*    */ 
/*    */                 
/* 55 */                 this.ms.reset();
/*    */                 
/*    */                 continue;
/*    */               } 
/* 59 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*    */               
/* 61 */               ClientUtils.displayChatMessage("§8[§bPotionWarn§8] §c" + entity.getName() + "§f拥有§c" + this.checkPotionName + "§f药水效果，距你" + (int)MinecraftInstance.mc.getThePlayer().getDistanceToEntity(entity) + "米! 离你较近。");
/*    */ 
/*    */               
/* 64 */               this.ms.reset();
/*    */             } 
/*    */           } }
/*    */       
/*    */       } 
/*    */     } 
/* 70 */     String str = (String)this.checkPotionNameValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*    */       case 1086816022:
/* 72 */         if (str.equals("movespeed")) this.checkPotionName = "速度";  break;case 825451924: if (str.equals("damageboost"))
/*    */           this.checkPotionName = "力量";  break;
/* 74 */       case 108392509: if (str.equals("regen")) this.checkPotionName = "生命恢复";  break;
/*    */       case 3273774:
/*    */         if (str.equals("jump"))
/*    */           this.checkPotionName = "跳跃提升"; 
/*    */         break;
/* 79 */     }  } private final IPotion potionActiveName(String potionName) { String str = potionName; boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*    */     { case 1086816022:
/* 81 */         if (str.equals("movespeed")); break;
/*    */       case 825451924: if (str.equals("damageboost")); break;
/* 83 */       case 108392509: if (str.equals("regen")); break;
/* 84 */       case 3273774: if (str.equals("jump")); break; }  return null; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\PotionWarn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */