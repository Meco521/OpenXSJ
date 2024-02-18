/*    */ package net.ccbluex.liquidbounce.features.module.modules.hyt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "AutoSave", description = "自动急救平台 ", category = ModuleCategory.HYT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\021\032\0020\022H\026J\022\020\023\032\0020\0222\b\020\024\032\004\030\0010\025H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\003\020\005\"\004\b\006\020\007R\016\020\b\032\0020\tX\004¢\006\002\n\000R\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\004X\016¢\006\002\n\000¨\006\026"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/hyt/HytAuto;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "maxFallDistValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "tried", "onEnable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class HytAuto extends Module {
/* 18 */   private final FloatValue maxFallDistValue = new FloatValue("MaxFallDistance", 10.0F, 5.0F, 20.0F);
/* 19 */   private boolean isEnabled; public final boolean isEnabled() { return this.isEnabled; } public final void setEnabled(boolean <set-?>) { this.isEnabled = <set-?>; }
/* 20 */    private final MSTimer timer = new MSTimer(); private boolean tried;
/*    */   
/*    */   public void onEnable() {
/* 23 */     this.tried = false;
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 27 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 28 */       this.tried = false;
/*    */     }
/* 30 */     if (!this.isEnabled) {
/* 31 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > ((Number)this.maxFallDistValue.get()).floatValue() && !this.tried) {
/* 32 */         int fireRodInHotbar = InventoryUtils.findItem(36, 45, MinecraftInstance.classProvider.getItemEnum(ItemType.BLAZE_ROD));
/*    */         
/* 34 */         if (fireRodInHotbar != -1) {
/* 35 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(fireRodInHotbar - 36));
/* 36 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.OFF_HAND));
/* 37 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/* 38 */           alert("§b自动急救平台§7>> true!");
/* 39 */           this.isEnabled = true;
/* 40 */           this.timer.reset();
/*    */         }
/*    */       
/*    */       } 
/* 44 */     } else if (this.timer.hasTimePassed(12000L)) {
/* 45 */       this.isEnabled = false;
/*    */     } 
/*    */   }
/*    */   @NotNull
/*    */   public String getTag() {
/* 50 */     return "Bypass";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\hyt\HytAuto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */