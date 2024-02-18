/*    */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.IMinecraft;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*    */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*    */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.client.CPacketPlayer;
/*    */ 
/*    */ @ModuleInfo(name = "NoC03Fix", description = "取消C03包修复By Kid皇帝", category = ModuleCategory.COMBAT)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\0020\bH\026J\b\020\t\032\0020\bH\026J\022\020\n\032\0020\b2\b\020\013\032\004\030\0010\fH\007J\020\020\r\032\0020\b2\006\020\013\032\0020\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/NoC03Fix;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "c03ingrangeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "nomove", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "onDisable", "", "onEnable", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "XSJClient"})
/*    */ public final class NoC03Fix extends Module {
/* 17 */   private final FloatValue c03ingrangeValue = new FloatValue("C03Range", 5.7F, 0.0F, 8.0F);
/* 18 */   private final BoolValue nomove = new BoolValue("NoMove", true);
/*    */   
/*    */   public void onEnable() {
/* 21 */     if (Retreat.INSTANCE.getModuleManager().get(RangeFix.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.RangeFix");  RangeFix RangeFix = (RangeFix)Retreat.INSTANCE.getModuleManager().get(RangeFix.class);
/* 22 */     RangeFix.setState(false);
/* 23 */     if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  KillAura killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class);
/* 24 */     killAura.getRangeValue().set(this.c03ingrangeValue.get());
/*    */   }
/*    */   
/*    */   public void onDisable() {
/* 28 */     if (Retreat.INSTANCE.getModuleManager().get(RangeFix.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.RangeFix");  RangeFix RangeFix = (RangeFix)Retreat.INSTANCE.getModuleManager().get(RangeFix.class);
/* 29 */     RangeFix.setState(true);
/*    */   }
/*    */   @EventTarget
/*    */   public final void onPacket(@NotNull PacketEvent event) {
/* 33 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
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
/* 51 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped(); if (packet instanceof CPacketPlayer) {
/* 52 */       Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft iMinecraft = MinecraftInstance.mc; CPacketPlayer cPacketPlayer = (CPacketPlayer)packet; $i$f$unwrap = 0; if (iMinecraft == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  Minecraft minecraft = ((MinecraftImpl)iMinecraft).getWrapped(); cPacketPlayer.field_149479_a = minecraft.field_71439_g.field_70165_t + 1000.0D; event.cancelEvent();
/* 53 */     }  if (packet instanceof SPacketEntityVelocity) { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc, "mc"); IMinecraft iMinecraft = MinecraftInstance.mc; int i = ((SPacketEntityVelocity)packet).func_149412_c(); $i$f$unwrap = 0; if (iMinecraft == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.MinecraftImpl");  Minecraft minecraft = ((MinecraftImpl)iMinecraft).getWrapped(); Intrinsics.checkExpressionValueIsNotNull(minecraft.field_71439_g, "mc.unwrap().player"); if (i == minecraft.field_71439_g.func_145782_y())
/*    */         event.cancelEvent();  }
/*    */   
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onMove(@Nullable MoveEvent event) {
/*    */     if (((Boolean)this.nomove.get()).booleanValue())
/*    */       if (event != null) {
/*    */         event.zero();
/*    */       } else {
/*    */       
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\NoC03Fix.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */