/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketPlayerDigging;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AutoBow", description = "Automatically shoots an arrow whenever your bow is fully loaded.", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/AutoBow;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "waitForBowAimbot", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoBow extends Module {
/* 17 */   private final BoolValue waitForBowAimbot = new BoolValue("WaitForBowAimbot", true);
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 21 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (Retreat.INSTANCE.getModuleManager().get(BowAimbot.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.BowAimbot");  BowAimbot bowAimbot = (BowAimbot)Retreat.INSTANCE.getModuleManager().get(BowAimbot.class);
/*    */     
/* 23 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */ 
/*    */     
/* 26 */     if (thePlayer.isUsingItem()) { thePlayer.getHeldItem(); if (MinecraftInstance.classProvider.isItemBow((thePlayer.getHeldItem() != null) ? thePlayer.getHeldItem().getItem() : null) && thePlayer.getItemInUseDuration() > 20 && (!((Boolean)this.waitForBowAimbot.get()).booleanValue() || !bowAimbot.getState() || bowAimbot.hasTarget())) {
/* 27 */         thePlayer.stopUsingItem();
/* 28 */         MinecraftInstance.mc.getNetHandler().addToSendQueue(MinecraftInstance.classProvider.createCPacketPlayerDigging(ICPacketPlayerDigging.WAction.RELEASE_USE_ITEM, WBlockPos.Companion.getORIGIN(), MinecraftInstance.classProvider.getEnumFacing(EnumFacingType.DOWN)));
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\AutoBow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */