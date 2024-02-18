/*    */ package net.ccbluex.liquidbounce.features.module.modules.retreat;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IServerData;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.combat.AutoPot;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.Sneak;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.world.ChestAura;
/*    */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.minecraft.network.play.client.CPacketConfirmTransaction;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "PostDisabler", category = ModuleCategory.RETREAT, description = "Post disabler for HYT GrimAC Skid by 凡哥")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\r¨\006\022"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/retreat/PostDisabler;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "autopotvaule", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "chestrvaule", "debug", "sneakvaule", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "setTimer", "(Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;)V", "onPacket", "", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class PostDisabler extends Module {
/*    */   @NotNull
/* 25 */   private MSTimer timer = new MSTimer(); @NotNull public final MSTimer getTimer() { return this.timer; } public final void setTimer(@NotNull MSTimer <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>"); this.timer = <set-?>; }
/* 26 */    private final BoolValue chestrvaule = new BoolValue("ChestAura", true);
/* 27 */   private final BoolValue sneakvaule = new BoolValue("sneak", true);
/* 28 */   private final BoolValue autopotvaule = new BoolValue("autopot", true);
/* 29 */   private final BoolValue debug = new BoolValue("Debug", false);
/*    */ 
/*    */ 
/*    */   
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 35 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (Retreat.INSTANCE.getModuleManager().get(ChestAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.ChestAura");  ChestAura chestAura = (ChestAura)Retreat.INSTANCE.getModuleManager().get(ChestAura.class);
/* 36 */     if (Retreat.INSTANCE.getModuleManager().get(Sneak.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.movement.Sneak");  Sneak sneak = (Sneak)Retreat.INSTANCE.getModuleManager().get(Sneak.class);
/* 37 */     if (Retreat.INSTANCE.getModuleManager().get(AutoPot.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.AutoPot");  AutoPot autopot = (AutoPot)Retreat.INSTANCE.getModuleManager().get(AutoPot.class);
/* 38 */     IServerData serverData = MinecraftInstance.mc.getCurrentServerData();
/* 39 */     if (((((Boolean)this.chestrvaule.get()).booleanValue() && chestAura.getState()) || (((Boolean)this.sneakvaule.get()).booleanValue() && sneak.getState()) || (autopot.getState() && ((Boolean)this.autopotvaule.get()).booleanValue())) && 
/* 40 */       serverData != null) {
/* 41 */       long pingTime = serverData.getPingToServer();
/* 42 */       if (MinecraftInstance.classProvider.isCPacketPlayer(event.getPacket()) && 
/* 43 */         this.timer.hasTimePassed(pingTime)) {
/* 44 */         Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2, "mc2"); if (MinecraftInstance.mc2.func_147114_u() == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.func_147114_u(), "mc2.connection!!"); MinecraftInstance.mc2.func_147114_u().func_147298_b().func_179290_a((Packet)new CPacketConfirmTransaction());
/* 45 */         if (((Boolean)this.debug.get()).booleanValue()) {
/* 46 */           ClientUtils.displayChatMessage("§b[§bXSJ Client]§dsent");
/*    */         }
/* 48 */         this.timer.reset();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\retreat\PostDisabler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */