/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.enums.ItemType;
/*    */ import net.ccbluex.liquidbounce.api.enums.WEnumHand;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "AutoPlatform", description = "自动急救平台", category = ModuleCategory.RETREAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0008\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\021\032\0020\0222\006\020\023\032\0020\013H\024J\b\020\024\032\0020\022H\026J\022\020\025\032\0020\0222\b\020\026\032\004\030\0010\027H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\003\020\005\"\004\b\006\020\007R\016\020\b\032\0020\tX\004¢\006\002\n\000R\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\004X\016¢\006\002\n\000¨\006\030"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/AutoPlatform;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "maxFallDistValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "tried", "alert", "", "s", "onEnable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class AutoPlatform
/*    */   extends Module {
/* 25 */   private final FloatValue maxFallDistValue = new FloatValue("MaxFallDistance", 10.0F, 5.0F, 20.0F);
/* 26 */   private boolean isEnabled; public final boolean isEnabled() { return this.isEnabled; } public final void setEnabled(boolean <set-?>) { this.isEnabled = <set-?>; }
/* 27 */    private final MSTimer timer = new MSTimer(); private boolean tried;
/*    */   
/*    */   public void onEnable() {
/* 30 */     this.tried = false;
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 34 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/* 35 */       this.tried = false;
/*    */     }
/* 37 */     if (!this.isEnabled) {
/* 38 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getFallDistance() > ((Number)this.maxFallDistValue.get()).floatValue() && !this.tried) {
/* 39 */         int fireRodInHotbar = InventoryUtils.findItem(36, 45, MinecraftInstance.classProvider.getItemEnum(ItemType.BLAZE_ROD));
/*    */         
/* 41 */         if (fireRodInHotbar != -1) {
/* 42 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(fireRodInHotbar - 36));
/* 43 */           MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketTryUseItem(WEnumHand.OFF_HAND));
/* 44 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketHeldItemChange(MinecraftInstance.mc.getThePlayer().getInventory().getCurrentItem()));
/* 45 */           alert("§b自动急救平台§7>> true!");
/* 46 */           this.isEnabled = true;
/* 47 */           this.timer.reset();
/*    */         }
/*    */       
/*    */       }
/*    */     
/* 52 */     } else if (this.timer.hasTimePassed(12000L)) {
/* 53 */       this.isEnabled = false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void alert(@NotNull String s) {
/* 59 */     Intrinsics.checkParameterIsNotNull(s, "s"); String str = "Not yet implemented"; boolean bool = false; throw (Throwable)new NotImplementedError("An operation is not implemented: " + str);
/*    */   }
/*    */   @NotNull
/*    */   public String getTag() {
/* 63 */     return "Bypass";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\AutoPlatform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */