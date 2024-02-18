/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "AntiAFK", description = "Prevents you from getting kicked for being AFK.", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000P\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\004\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\n\020\026\032\004\030\0010\027H\002J\b\020\030\032\0020\031H\026J\020\020\032\032\0020\0312\006\020\033\032\0020\034H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\006X\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\022X\016¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\016\020\024\032\0020\020X\004¢\006\002\n\000R\016\020\025\032\0020\006X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/AntiAFK;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "delayTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "jumpValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "moveValue", "randomTimerDelay", "", "rotateValue", "rotationAngleValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "rotationDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "shouldMove", "", "swingDelayTimer", "swingDelayValue", "swingValue", "getRandomMoveKeyBind", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "onDisable", "", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class AntiAFK extends Module {
/*  19 */   private final MSTimer swingDelayTimer = new MSTimer();
/*  20 */   private final MSTimer delayTimer = new MSTimer();
/*     */   
/*  22 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Old", "Random", "Custom" }, "Random");
/*     */   
/*  24 */   private final IntegerValue swingDelayValue = new IntegerValue("SwingDelay", 100, 0, 1000);
/*  25 */   private final IntegerValue rotationDelayValue = new IntegerValue("RotationDelay", 100, 0, 1000);
/*  26 */   private final FloatValue rotationAngleValue = new FloatValue("RotationAngle", 1.0F, -180.0F, 180.0F);
/*     */   
/*  28 */   private final BoolValue jumpValue = new BoolValue("Jump", true);
/*  29 */   private final BoolValue moveValue = new BoolValue("Move", true);
/*  30 */   private final BoolValue rotateValue = new BoolValue("Rotate", true);
/*  31 */   private final BoolValue swingValue = new BoolValue("Swing", true);
/*     */   
/*     */   private boolean shouldMove;
/*  34 */   private long randomTimerDelay = 500L;
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  38 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  40 */       String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case -938285885:
/*  49 */           if (str.equals("random"))
/*  50 */           { if (getRandomMoveKeyBind() == null) Intrinsics.throwNpe();  getRandomMoveKeyBind().setPressed(this.shouldMove);
/*     */             
/*  52 */             if (!this.delayTimer.hasTimePassed(this.randomTimerDelay))
/*  53 */               return;  this.shouldMove = false;
/*  54 */             this.randomTimerDelay = 500L;
/*  55 */             switch (RandomUtils.nextInt(0, 6))
/*     */             { case 0:
/*  57 */                 if (thePlayer.getOnGround()) thePlayer.jump(); 
/*  58 */                 this.delayTimer.reset();
/*     */                 break;
/*     */               case 1:
/*  61 */                 if (!thePlayer.isSwingInProgress()) thePlayer.swingItem(); 
/*  62 */                 this.delayTimer.reset();
/*     */                 break;
/*     */               case 2:
/*  65 */                 this.randomTimerDelay = RandomUtils.nextInt(0, 1000);
/*  66 */                 this.shouldMove = true;
/*  67 */                 this.delayTimer.reset();
/*     */                 break;
/*     */               case 3:
/*  70 */                 thePlayer.getInventory().setCurrentItem(RandomUtils.nextInt(0, 9));
/*  71 */                 MinecraftInstance.mc.getPlayerController().updateController();
/*  72 */                 this.delayTimer.reset();
/*     */                 break;
/*     */               case 4:
/*  75 */                 thePlayer.setRotationYaw(thePlayer.getRotationYaw() + RandomUtils.INSTANCE.nextFloat(-180.0F, 180.0F));
/*  76 */                 this.delayTimer.reset();
/*     */                 break;
/*     */               case 5:
/*  79 */                 if (thePlayer.getRotationPitch() <= -90 || thePlayer.getRotationPitch() >= 90) thePlayer.setRotationPitch(0.0F); 
/*  80 */                 thePlayer.setRotationPitch(thePlayer.getRotationPitch() + RandomUtils.INSTANCE.nextFloat(-10.0F, 10.0F));
/*  81 */                 this.delayTimer.reset(); break; }  }  break;
/*     */         case 110119:
/*     */           if (str.equals("old")) { MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(true); if (this.delayTimer.hasTimePassed(500L)) { thePlayer.setRotationYaw(thePlayer.getRotationYaw() + 180.0F); this.delayTimer.reset(); }  }  break;
/*     */         case -1349088399:
/*  85 */           if (str.equals("custom")) {
/*  86 */             if (((Boolean)this.moveValue.get()).booleanValue()) {
/*  87 */               MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(true);
/*     */             }
/*  89 */             if (((Boolean)this.jumpValue.get()).booleanValue() && thePlayer.getOnGround()) {
/*  90 */               thePlayer.jump();
/*     */             }
/*  92 */             if (((Boolean)this.rotateValue.get()).booleanValue() && this.delayTimer.hasTimePassed(((Number)this.rotationDelayValue.get()).intValue())) {
/*  93 */               thePlayer.setRotationYaw(thePlayer.getRotationYaw() + ((Number)this.rotationAngleValue.get()).floatValue());
/*  94 */               if (thePlayer.getRotationPitch() <= -90 || thePlayer.getRotationPitch() >= 90) thePlayer.setRotationPitch(0.0F); 
/*  95 */               thePlayer.setRotationPitch(thePlayer.getRotationPitch() + RandomUtils.INSTANCE.nextFloat(0.0F, 1.0F) * 2 - true);
/*  96 */               this.delayTimer.reset();
/*     */             } 
/*     */             
/*  99 */             if (((Boolean)this.swingValue.get()).booleanValue() && !thePlayer.isSwingInProgress() && this.swingDelayTimer.hasTimePassed(((Number)this.swingDelayValue.get()).intValue())) {
/* 100 */               thePlayer.swingItem();
/* 101 */               this.swingDelayTimer.reset();
/*     */             } 
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       return; }
/*     */     
/* 108 */     MinecraftInstance.mc.getThePlayer(); } private final IKeyBinding getRandomMoveKeyBind() { switch (RandomUtils.nextInt(0, 4)) {
/*     */       case 0:
/* 110 */         return MinecraftInstance.mc.getGameSettings().getKeyBindRight();
/*     */       
/*     */       case 1:
/* 113 */         return MinecraftInstance.mc.getGameSettings().getKeyBindLeft();
/*     */       
/*     */       case 2:
/* 116 */         return MinecraftInstance.mc.getGameSettings().getKeyBindBack();
/*     */       
/*     */       case 3:
/* 119 */         return MinecraftInstance.mc.getGameSettings().getKeyBindForward();
/*     */     } 
/*     */     
/* 122 */     return null; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDisable() {
/* 128 */     if (!MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindForward()))
/* 129 */       MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(false); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\AntiAFK.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */