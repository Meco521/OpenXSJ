/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.TextValue;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "StrengthDetect", category = ModuleCategory.MISC, description = "StrengthDetect")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020!\n\002\020\016\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\013\032\0020\f2\006\020\r\032\0020\016H\002J\b\020\017\032\0020\fH\026J\020\020\020\032\0020\f2\006\020\021\032\0020\022H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\024\020\b\032\0020\0078VX\004¢\006\006\032\004\b\t\020\n¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/StrengthDetect;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "msg", "Lnet/ccbluex/liquidbounce/value/TextValue;", "notied", "", "", "tag", "getTag", "()Ljava/lang/String;", "action", "", "entity", "Lnet/minecraft/entity/player/EntityPlayer;", "onDisable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class StrengthDetect extends Module {
/* 17 */   private final TextValue msg = new TextValue("AutoTextMessage", "力量"); private final List<String> notied; public StrengthDetect() {
/* 18 */     StrengthDetect strengthDetect = this; boolean bool = false; ArrayList<String> arrayList = new ArrayList();
/*    */   }
/*    */   
/*    */   @EventTarget
/* 22 */   public final void onUpdate(@NotNull UpdateEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71441_e.field_73010_i, "mc2.world.playerEntities"); Iterable $this$forEach$iv = MinecraftInstance.mc2.field_71441_e.field_73010_i; int $i$f$forEach = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 64 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); EntityPlayer entity = (EntityPlayer)element$iv; int $i$a$-forEach-StrengthDetect$onUpdate$1 = 0; Intrinsics.checkExpressionValueIsNotNull(entity, "entity"); action(entity); }
/*    */      } private final void action(EntityPlayer entity) { boolean hasStrength = false; Intrinsics.checkExpressionValueIsNotNull(entity.func_70651_bq(), "entity.activePotionEffects"); Iterable $this$forEach$iv = entity.func_70651_bq(); int $i$f$forEach = 0;
/* 66 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); PotionEffect potionEffect = (PotionEffect)element$iv; int $i$a$-forEach-StrengthDetect$action$1 = 0;
/*    */       Intrinsics.checkExpressionValueIsNotNull(potionEffect, "potionEffect");
/*    */       if (Intrinsics.areEqual(potionEffect.func_188419_a(), MobEffects.field_76420_g)) {
/*    */         hasStrength = true;
/*    */         if (!this.notied.contains(entity.func_70005_c_())) {
/*    */           Intrinsics.checkExpressionValueIsNotNull(entity.func_70005_c_(), "entity.name");
/*    */           this.notied.add(entity.func_70005_c_());
/*    */           Retreat.INSTANCE.getHud().addNotification(new Notification("Strength!", StringsKt.replace$default(entity.func_70005_c_() + (String)this.msg.get() + " 剩余" + (potionEffect.func_76459_b() / 20 / 60) + '分' + (potionEffect.func_76459_b() / 20 % 60) + '秒', 'L', 'Ｌ', false, 4, null), NotifyType.INFO, 0, 0, 24, null));
/*    */         } 
/*    */       }  }
/*    */     
/*    */     if (!hasStrength && this.notied.contains(entity.func_70005_c_()))
/*    */       this.notied.remove(entity.func_70005_c_());  }
/*    */ 
/*    */   
/*    */   public void onDisable() {
/*    */     this.notied.clear();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getTag() {
/*    */     List<String> list = this.notied;
/*    */     StringBuilder stringBuilder = new StringBuilder();
/*    */     boolean bool = false;
/*    */     int i = list.size();
/*    */     return stringBuilder.append(i).append(" Players").toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\StrengthDetect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */