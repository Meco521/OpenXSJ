/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*     */ import net.ccbluex.liquidbounce.event.AttackEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "SuperKnockback", category = ModuleCategory.COMBAT, description = "NEW")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\025\032\0020\0262\006\020\027\032\0020\030H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\b\020\tR\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\013X\004¢\006\002\n\000R\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R\021\020\021\032\0020\022¢\006\b\n\000\032\004\b\023\020\024¨\006\031"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/SuperKnockback;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delay", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "hurtTimeValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "onlyGroundValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "onlyMoveValue", "tag", "", "getTag", "()Ljava/lang/String;", "timer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "getTimer", "()Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "onAttack", "", "event", "Lnet/ccbluex/liquidbounce/event/AttackEvent;", "XSJClient"})
/*     */ public final class SuperKnockback extends Module {
/*  20 */   private final IntegerValue hurtTimeValue = new IntegerValue("HurtTime", 10, 0, 10); @NotNull
/*  21 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "MCYC", "Test", "WTap", "Packet", "HYTPacket", "Tick" }, "Normal"); @NotNull public final ListValue getModeValue() { return this.modeValue; }
/*  22 */    private final BoolValue onlyMoveValue = new BoolValue("OnlyMove", false);
/*  23 */   private final BoolValue onlyGroundValue = new BoolValue("OnlyGround", false);
/*  24 */   private final IntegerValue delay = new IntegerValue("Delay", 0, 0, 500);
/*     */   @NotNull
/*  26 */   private final MSTimer timer = new MSTimer(); @NotNull public final MSTimer getTimer() { return this.timer; }
/*     */   
/*     */   @EventTarget
/*     */   public final void onAttack(@NotNull AttackEvent event) {
/*  30 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (event.getTargetEntity() instanceof EntityLivingBase) {
/*     */       
/*  32 */       if (((EntityLivingBase)event.getTargetEntity()).field_70737_aN <= ((Number)this.hurtTimeValue.get()).intValue() && this.timer.hasTimePassed(((Number)this.delay.get()).intValue()) && (MovementUtils.isMoving() || !((Boolean)this.onlyMoveValue.get()).booleanValue())) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (!MinecraftInstance.mc.getThePlayer().getOnGround() && ((Boolean)this.onlyGroundValue.get()).booleanValue())
/*     */           return;  }
/*     */       else { return; }
/*  35 */        String str = (String)this.modeValue.get(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case -1039745817:
/*  47 */           if (str.equals("normal"))
/*  48 */           { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) {
/*  49 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(true);
/*     */             } 
/*  51 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true);
/*  52 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING));
/*  53 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING)); }  break;
/*     */         case 3346208:
/*  55 */           if (str.equals("mcyc"))
/*  56 */           { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(false); }
/*  57 */              if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  58 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(true);
/*  59 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true); }  break;case 3556498: if (str.equals("test")) { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(true); }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING)); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING)); if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING)); if (MinecraftInstance.mc.getThePlayer() == null)
/*  61 */               Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true); }  break;case 305296331: if (str.equals("hytpacket")) {
/*  62 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) {
/*  63 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(true);
/*  64 */             }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING));
/*  65 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  66 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING));
/*  67 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  68 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING));
/*  69 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  70 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING));
/*  71 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true);
/*     */           }  break;
/*     */         case 3559837:
/*  74 */           if (str.equals("tick"))
/*  75 */           { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) {
/*  76 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(false);
/*  77 */             }  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  78 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true); }  break;
/*     */         case 3659724:
/*  80 */           if (str.equals("wtap"))
/*  81 */           { Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) {
/*  82 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(false);
/*     */             } 
/*  84 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  85 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true); }  break;
/*     */         case -995865464:
/*  87 */           if (str.equals("packet")) {
/*  88 */             Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); if (MinecraftInstance.mc2.field_71439_g.func_70051_ag()) {
/*  89 */               Intrinsics.checkExpressionValueIsNotNull(MinecraftInstance.mc2.field_71439_g, "mc2.player"); MinecraftInstance.mc2.field_71439_g.func_70031_b(true);
/*     */             } 
/*  91 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SPRINTING));
/*  92 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getNetHandler().addToSendQueue((IPacket)MinecraftInstance.classProvider.createCPacketEntityAction((IEntity)MinecraftInstance.mc.getThePlayer(), ICPacketEntityAction.WAction.START_SPRINTING));
/*  93 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setServerSprintState(true);
/*     */           }  break;
/*     */       } 
/*  96 */       this.timer.reset();
/*     */     } 
/*     */   } @NotNull
/*     */   public String getTag() {
/* 100 */     return (String)this.modeValue.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\SuperKnockback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */