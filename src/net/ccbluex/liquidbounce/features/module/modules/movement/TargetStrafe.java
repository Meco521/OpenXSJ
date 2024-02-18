/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import tomk.module.render.ColorManager;
/*     */ 
/*     */ @ModuleInfo(name = "TargetStrafe", description = "Never", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Z\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\013\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\007\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020#\032\0020$2\b\020%\032\004\030\0010&J\020\020'\032\0020(2\006\020%\032\0020&H\002J\030\020)\032\0020$2\006\020*\032\0020\0042\006\020+\032\0020\004H\002J\020\020,\032\0020-2\006\020.\032\0020/H\007J\020\0200\032\0020-2\006\020.\032\00201H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\021\020\t\032\0020\n¢\006\b\n\000\032\004\b\013\020\fR\021\020\r\032\0020\016¢\006\b\n\000\032\004\b\017\020\020R\021\020\021\032\0020\n¢\006\b\n\000\032\004\b\022\020\fR\021\020\023\032\0020\n¢\006\b\n\000\032\004\b\024\020\fR\021\020\025\032\0020\n¢\006\b\n\000\032\004\b\026\020\fR\021\020\027\032\0020\n¢\006\b\n\000\032\004\b\030\020\fR\021\020\031\032\0020\032¢\006\b\n\000\032\004\b\033\020\034R\021\020\035\032\0020\036¢\006\b\n\000\032\004\b\037\020 R\021\020!\032\0020\n¢\006\b\n\000\032\004\b\"\020\f¨\0062"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/TargetStrafe;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "direction", "", "getDirection", "()I", "setDirection", "(I)V", "holdSpaceValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getHoldSpaceValue", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "killAura", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "getKillAura", "()Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "onGroundValue", "getOnGroundValue", "onlyPitSpeedValue", "getOnlyPitSpeedValue", "onlySpeedValue", "getOnlySpeedValue", "onlyflyValue", "getOnlyflyValue", "radiusValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getRadiusValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "renderModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getRenderModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "thirdPersonViewValue", "getThirdPersonViewValue", "canStrafe", "", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getStrafeDistance", "", "isVoid", "xPos", "zPos", "onMove", "", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*     */ public final class TargetStrafe extends Module {
/*     */   @NotNull
/*  27 */   private final ListValue renderModeValue = new ListValue("RenderMode", new String[] { "Circle", "Pentagon", "None" }, "Pentagon"); @NotNull public final ListValue getRenderModeValue() { return this.renderModeValue; } @NotNull
/*  28 */   private final BoolValue thirdPersonViewValue = new BoolValue("ThirdPersonView", false); @NotNull public final BoolValue getThirdPersonViewValue() { return this.thirdPersonViewValue; } @NotNull
/*  29 */   private final FloatValue radiusValue = new FloatValue("Radius", 0.1F, 0.5F, 5.0F); @NotNull public final FloatValue getRadiusValue() { return this.radiusValue; } @NotNull
/*  30 */   private final BoolValue onGroundValue = new BoolValue("OnlyOnGround", false); @NotNull public final BoolValue getOnGroundValue() { return this.onGroundValue; } @NotNull
/*  31 */   private final BoolValue holdSpaceValue = new BoolValue("HoldSpace", false); @NotNull public final BoolValue getHoldSpaceValue() { return this.holdSpaceValue; } @NotNull
/*  32 */   private final BoolValue onlySpeedValue = new BoolValue("OnlySpeed", false); @NotNull public final BoolValue getOnlySpeedValue() { return this.onlySpeedValue; } @NotNull
/*  33 */   private final BoolValue onlyPitSpeedValue = new BoolValue("OnlyPitSpeed", false); @NotNull public final BoolValue getOnlyPitSpeedValue() { return this.onlyPitSpeedValue; } @NotNull
/*  34 */   private final BoolValue onlyflyValue = new BoolValue("keyFly", false); @NotNull public final BoolValue getOnlyflyValue() { return this.onlyflyValue; }
/*  35 */    private int direction = -1; @NotNull private final KillAura killAura; public final int getDirection() { return this.direction; } public final void setDirection(int <set-?>) { this.direction = <set-?>; } @NotNull
/*  36 */   public final KillAura getKillAura() { return this.killAura; } public TargetStrafe() { if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  this.killAura = (KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*  44 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if ((MinecraftInstance.mc.getThePlayer().getOnGround() && ((Boolean)this.onGroundValue.get()).booleanValue()) || !((Boolean)this.onGroundValue.get()).booleanValue()) {
/*  45 */       if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  IEntityLivingBase target = this.killAura.getTarget();
/*  46 */       if ((Intrinsics.areEqual(this.renderModeValue.get(), "None") ^ true) != 0 && canStrafe(target)) {
/*  47 */         if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null)
/*  48 */           return;  int[] counter = { 0 };
/*  49 */         if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  IEntityLivingBase iEntityLivingBase = this.killAura.getTarget();
/*  50 */         if (StringsKt.equals((String)this.renderModeValue.get(), "Circle", true)) {
/*  51 */           GL11.glPushMatrix();
/*  52 */           GL11.glDisable(3553);
/*  53 */           GL11.glEnable(2848);
/*  54 */           GL11.glEnable(2881);
/*  55 */           GL11.glEnable(2832);
/*  56 */           GL11.glEnable(3042);
/*  57 */           GL11.glBlendFunc(770, 771);
/*  58 */           GL11.glHint(3154, 4354);
/*  59 */           GL11.glHint(3155, 4354);
/*  60 */           GL11.glHint(3153, 4354);
/*  61 */           GL11.glDisable(2929);
/*  62 */           GL11.glDepthMask(false);
/*  63 */           GL11.glLineWidth(1.0F);
/*  64 */           GL11.glBegin(3);
/*     */           
/*  66 */           if (iEntityLivingBase == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  double x = iEntityLivingBase.getLastTickPosX() + (this.killAura.getTarget().getPosX() - this.killAura.getTarget().getLastTickPosX()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosX();
/*     */           
/*  68 */           if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  double y = this.killAura.getTarget().getLastTickPosY() + (this.killAura.getTarget().getPosY() - this.killAura.getTarget().getLastTickPosY()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosY();
/*     */           
/*  70 */           if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  double z = this.killAura.getTarget().getLastTickPosZ() + (this.killAura.getTarget().getPosZ() - this.killAura.getTarget().getLastTickPosZ()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosZ(); byte b; char c;
/*  71 */           for (b = 0, c = 'ŧ'; b <= c; b++) {
/*     */ 
/*     */             
/*  74 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = b / 50.0D * 1.75D, d3 = MinecraftInstance.mc.getThePlayer().getTicksExisted() / 70.0D; boolean bool = false; double d4 = Math.sin(d1); int i = Color.HSBtoRGB((float)((d3 + d4) % 1.0F), 
/*  75 */                 0.7F, 
/*  76 */                 1.0F);
/*     */             
/*     */             Color rainbow = new Color(i);
/*  79 */             GL11.glColor3f(rainbow.getRed() / 255.0F, rainbow.getGreen() / 255.0F, rainbow.getBlue() / 255.0F);
/*     */             
/*  81 */             d1 = b * 6.283185307179586D / 45.0D; d3 = ((Number)this.radiusValue.get()).doubleValue(); double d2 = x; bool = false; d4 = Math.cos(d1);
/*     */             
/*  83 */             d1 = b * 6.283185307179586D / 45.0D; double d5 = ((Number)this.radiusValue.get()).doubleValue(); d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/*  86 */           GL11.glEnd();
/*  87 */           GL11.glDepthMask(true);
/*  88 */           GL11.glEnable(2929);
/*  89 */           GL11.glDisable(2848);
/*  90 */           GL11.glDisable(2881);
/*  91 */           GL11.glEnable(2832);
/*  92 */           GL11.glEnable(3553);
/*  93 */           GL11.glPopMatrix();
/*     */         } else {
/*  95 */           float rad = ((Number)this.radiusValue.get()).floatValue();
/*  96 */           if (iEntityLivingBase == null) {
/*     */             return;
/*     */           }
/*  99 */           GL11.glPushMatrix();
/* 100 */           GL11.glDisable(3553);
/* 101 */           RenderUtils.startDrawing();
/* 102 */           GL11.glDisable(2929);
/* 103 */           GL11.glDepthMask(false);
/* 104 */           GL11.glLineWidth(1.0F);
/* 105 */           GL11.glBegin(3);
/*     */           
/* 107 */           if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  double x = this.killAura.getTarget().getLastTickPosX() + (this.killAura.getTarget().getPosX() - this.killAura.getTarget().getLastTickPosX()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosX();
/*     */           
/* 109 */           if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  double y = this.killAura.getTarget().getLastTickPosY() + (this.killAura.getTarget().getPosY() - this.killAura.getTarget().getLastTickPosY()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosY();
/*     */           
/* 111 */           if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  if (this.killAura.getTarget() == null) Intrinsics.throwNpe();  double z = this.killAura.getTarget().getLastTickPosZ() + (this.killAura.getTarget().getPosZ() - this.killAura.getTarget().getLastTickPosZ()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosZ();
/* 112 */           for (byte b1 = 0, b2 = 10; b1 <= b2; b1++) {
/* 113 */             counter[0] = counter[0] + 1;
/* 114 */             Color rainbow = new Color(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */             
/* 116 */             GL11.glColor3f(rainbow.getRed() / 255.0F, rainbow.getGreen() / 255.0F, rainbow.getBlue() / 255.0F);
/* 117 */             if (rad < 0.8D && rad > 0.0D) {
/* 118 */               double d1 = b1 * 6.283185307179586D / 3.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 120 */               d1 = b1 * 6.283185307179586D / 3.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/* 122 */             if (rad < 1.5D && rad > 0.7D) {
/* 123 */               counter[0] = counter[0] + 1;
/* 124 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 126 */               double d1 = b1 * 6.283185307179586D / 4.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 128 */               d1 = b1 * 6.283185307179586D / 4.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */             
/* 131 */             if (rad < 2.0D && rad > 1.4D) {
/* 132 */               counter[0] = counter[0] + 1;
/* 133 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 135 */               double d1 = b1 * 6.283185307179586D / 5.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 137 */               d1 = b1 * 6.283185307179586D / 5.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */             
/* 140 */             if (rad < 2.4D && rad > 1.9D) {
/* 141 */               counter[0] = counter[0] + 1;
/* 142 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 144 */               double d1 = b1 * 6.283185307179586D / 6.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 146 */               d1 = b1 * 6.283185307179586D / 6.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */             
/* 149 */             if (rad < 2.7D && rad > 2.3D) {
/* 150 */               counter[0] = counter[0] + 1;
/* 151 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 153 */               double d1 = b1 * 6.283185307179586D / 7.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 155 */               d1 = b1 * 6.283185307179586D / 7.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */             
/* 158 */             if (rad < 6.0D && rad > 2.6D) {
/* 159 */               counter[0] = counter[0] + 1;
/* 160 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 162 */               double d1 = b1 * 6.283185307179586D / 8.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 164 */               d1 = b1 * 6.283185307179586D / 8.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */             
/* 167 */             if (rad < 7.0D && rad > 5.9D) {
/* 168 */               counter[0] = counter[0] + 1;
/* 169 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 171 */               double d1 = b1 * 6.283185307179586D / 9.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 173 */               d1 = b1 * 6.283185307179586D / 9.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */             
/* 176 */             if (rad < 11.0D && rad > 6.9D) {
/* 177 */               counter[0] = counter[0] + 1;
/* 178 */               RenderUtils.glColor4(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */               
/* 180 */               double d1 = b1 * 6.283185307179586D / 10.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */               
/* 182 */               d1 = b1 * 6.283185307179586D / 10.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */             } 
/*     */           } 
/*     */           
/* 186 */           GL11.glEnd();
/* 187 */           GL11.glDepthMask(true);
/* 188 */           GL11.glEnable(2929);
/* 189 */           RenderUtils.stopDrawing();
/* 190 */           GL11.glEnable(3553);
/* 191 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onMove(@NotNull MoveEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnonnull -> 21
/*     */     //   18: invokestatic throwNpe : ()V
/*     */     //   21: invokeinterface getOnGround : ()Z
/*     */     //   26: ifeq -> 45
/*     */     //   29: aload_0
/*     */     //   30: getfield onGroundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   33: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   36: checkcast java/lang/Boolean
/*     */     //   39: invokevirtual booleanValue : ()Z
/*     */     //   42: ifne -> 61
/*     */     //   45: aload_0
/*     */     //   46: getfield onGroundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   49: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   52: checkcast java/lang/Boolean
/*     */     //   55: invokevirtual booleanValue : ()Z
/*     */     //   58: ifne -> 937
/*     */     //   61: aload_0
/*     */     //   62: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   65: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   68: dup
/*     */     //   69: ifnonnull -> 75
/*     */     //   72: invokestatic throwNpe : ()V
/*     */     //   75: astore_2
/*     */     //   76: aload_0
/*     */     //   77: aload_2
/*     */     //   78: invokevirtual canStrafe : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*     */     //   81: ifne -> 85
/*     */     //   84: return
/*     */     //   85: iconst_0
/*     */     //   86: istore_3
/*     */     //   87: iconst_m1
/*     */     //   88: istore #4
/*     */     //   90: iconst_0
/*     */     //   91: istore #5
/*     */     //   93: iload #4
/*     */     //   95: ifgt -> 134
/*     */     //   98: iconst_m1
/*     */     //   99: istore #6
/*     */     //   101: iconst_0
/*     */     //   102: istore #7
/*     */     //   104: iload #6
/*     */     //   106: ifgt -> 128
/*     */     //   109: aload_0
/*     */     //   110: iload #4
/*     */     //   112: iload #6
/*     */     //   114: invokespecial isVoid : (II)Z
/*     */     //   117: ifeq -> 122
/*     */     //   120: iconst_1
/*     */     //   121: istore_3
/*     */     //   122: iinc #6, 1
/*     */     //   125: goto -> 104
/*     */     //   128: iinc #4, 1
/*     */     //   131: goto -> 93
/*     */     //   134: aload_0
/*     */     //   135: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   138: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   141: dup
/*     */     //   142: ifnonnull -> 148
/*     */     //   145: invokestatic throwNpe : ()V
/*     */     //   148: invokestatic getRotationFromEyeHasPrev : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Lnet/ccbluex/liquidbounce/utils/Rotation;
/*     */     //   151: invokevirtual getYaw : ()F
/*     */     //   154: fstore #4
/*     */     //   156: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   159: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   164: dup
/*     */     //   165: ifnonnull -> 171
/*     */     //   168: invokestatic throwNpe : ()V
/*     */     //   171: invokeinterface isCollidedHorizontally : ()Z
/*     */     //   176: ifne -> 183
/*     */     //   179: iload_3
/*     */     //   180: ifeq -> 193
/*     */     //   183: aload_0
/*     */     //   184: dup
/*     */     //   185: getfield direction : I
/*     */     //   188: iconst_m1
/*     */     //   189: imul
/*     */     //   190: putfield direction : I
/*     */     //   193: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   196: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   201: dup
/*     */     //   202: ifnonnull -> 208
/*     */     //   205: invokestatic throwNpe : ()V
/*     */     //   208: invokeinterface getMoveStrafing : ()F
/*     */     //   213: fconst_0
/*     */     //   214: fcmpg
/*     */     //   215: ifeq -> 247
/*     */     //   218: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   221: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   226: dup
/*     */     //   227: ifnonnull -> 233
/*     */     //   230: invokestatic throwNpe : ()V
/*     */     //   233: invokeinterface getMoveStrafing : ()F
/*     */     //   238: aload_0
/*     */     //   239: getfield direction : I
/*     */     //   242: i2f
/*     */     //   243: fmul
/*     */     //   244: goto -> 252
/*     */     //   247: aload_0
/*     */     //   248: getfield direction : I
/*     */     //   251: i2f
/*     */     //   252: fstore #5
/*     */     //   254: invokestatic isBlockUnder : ()Z
/*     */     //   257: ifne -> 263
/*     */     //   260: fconst_0
/*     */     //   261: fstore #5
/*     */     //   263: bipush #45
/*     */     //   265: i2f
/*     */     //   266: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   269: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   274: dup
/*     */     //   275: ifnonnull -> 281
/*     */     //   278: invokestatic throwNpe : ()V
/*     */     //   281: aload_0
/*     */     //   282: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   285: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   288: dup
/*     */     //   289: ifnonnull -> 295
/*     */     //   292: invokestatic throwNpe : ()V
/*     */     //   295: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   298: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*     */     //   303: fdiv
/*     */     //   304: fstore #6
/*     */     //   306: ldc_w 45.0
/*     */     //   309: aload_0
/*     */     //   310: aload_0
/*     */     //   311: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   314: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   317: dup
/*     */     //   318: ifnonnull -> 324
/*     */     //   321: invokestatic throwNpe : ()V
/*     */     //   324: invokespecial getStrafeDistance : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)F
/*     */     //   327: fdiv
/*     */     //   328: f2d
/*     */     //   329: dstore #7
/*     */     //   331: fconst_0
/*     */     //   332: fstore #9
/*     */     //   334: fload #5
/*     */     //   336: iconst_0
/*     */     //   337: i2f
/*     */     //   338: fcmpl
/*     */     //   339: ifle -> 522
/*     */     //   342: aload_0
/*     */     //   343: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   346: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   349: dup
/*     */     //   350: ifnonnull -> 356
/*     */     //   353: invokestatic throwNpe : ()V
/*     */     //   356: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   361: invokeinterface getMinY : ()D
/*     */     //   366: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   369: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   374: dup
/*     */     //   375: ifnonnull -> 381
/*     */     //   378: invokestatic throwNpe : ()V
/*     */     //   381: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   386: invokeinterface getMaxY : ()D
/*     */     //   391: dcmpl
/*     */     //   392: ifgt -> 448
/*     */     //   395: aload_0
/*     */     //   396: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   399: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   402: dup
/*     */     //   403: ifnonnull -> 409
/*     */     //   406: invokestatic throwNpe : ()V
/*     */     //   409: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   414: invokeinterface getMaxY : ()D
/*     */     //   419: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   422: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   427: dup
/*     */     //   428: ifnonnull -> 434
/*     */     //   431: invokestatic throwNpe : ()V
/*     */     //   434: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   439: invokeinterface getMinY : ()D
/*     */     //   444: dcmpg
/*     */     //   445: ifge -> 510
/*     */     //   448: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   451: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   456: dup
/*     */     //   457: ifnonnull -> 463
/*     */     //   460: invokestatic throwNpe : ()V
/*     */     //   463: aload_0
/*     */     //   464: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   467: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   470: dup
/*     */     //   471: ifnonnull -> 477
/*     */     //   474: invokestatic throwNpe : ()V
/*     */     //   477: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   480: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*     */     //   485: aload_0
/*     */     //   486: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   489: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   492: checkcast java/lang/Number
/*     */     //   495: invokevirtual floatValue : ()F
/*     */     //   498: fcmpg
/*     */     //   499: ifge -> 510
/*     */     //   502: fload #4
/*     */     //   504: fload #6
/*     */     //   506: fneg
/*     */     //   507: fadd
/*     */     //   508: fstore #4
/*     */     //   510: fload #9
/*     */     //   512: dload #7
/*     */     //   514: d2f
/*     */     //   515: fneg
/*     */     //   516: fadd
/*     */     //   517: fstore #9
/*     */     //   519: goto -> 705
/*     */     //   522: fload #5
/*     */     //   524: iconst_0
/*     */     //   525: i2f
/*     */     //   526: fcmpg
/*     */     //   527: ifge -> 705
/*     */     //   530: aload_0
/*     */     //   531: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   534: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   537: dup
/*     */     //   538: ifnonnull -> 544
/*     */     //   541: invokestatic throwNpe : ()V
/*     */     //   544: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   549: invokeinterface getMinY : ()D
/*     */     //   554: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   557: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   562: dup
/*     */     //   563: ifnonnull -> 569
/*     */     //   566: invokestatic throwNpe : ()V
/*     */     //   569: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   574: invokeinterface getMaxY : ()D
/*     */     //   579: dcmpl
/*     */     //   580: ifgt -> 636
/*     */     //   583: aload_0
/*     */     //   584: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   587: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   590: dup
/*     */     //   591: ifnonnull -> 597
/*     */     //   594: invokestatic throwNpe : ()V
/*     */     //   597: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   602: invokeinterface getMaxY : ()D
/*     */     //   607: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   610: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   615: dup
/*     */     //   616: ifnonnull -> 622
/*     */     //   619: invokestatic throwNpe : ()V
/*     */     //   622: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   627: invokeinterface getMinY : ()D
/*     */     //   632: dcmpg
/*     */     //   633: ifge -> 697
/*     */     //   636: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   639: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   644: dup
/*     */     //   645: ifnonnull -> 651
/*     */     //   648: invokestatic throwNpe : ()V
/*     */     //   651: aload_0
/*     */     //   652: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   655: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   658: dup
/*     */     //   659: ifnonnull -> 665
/*     */     //   662: invokestatic throwNpe : ()V
/*     */     //   665: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   668: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*     */     //   673: aload_0
/*     */     //   674: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   677: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   680: checkcast java/lang/Number
/*     */     //   683: invokevirtual floatValue : ()F
/*     */     //   686: fcmpg
/*     */     //   687: ifge -> 697
/*     */     //   690: fload #4
/*     */     //   692: fload #6
/*     */     //   694: fadd
/*     */     //   695: fstore #4
/*     */     //   697: fload #9
/*     */     //   699: dload #7
/*     */     //   701: d2f
/*     */     //   702: fadd
/*     */     //   703: fstore #9
/*     */     //   705: iconst_2
/*     */     //   706: newarray double
/*     */     //   708: dup
/*     */     //   709: iconst_0
/*     */     //   710: fload #4
/*     */     //   712: ldc_w 90.0
/*     */     //   715: fadd
/*     */     //   716: fload #9
/*     */     //   718: fadd
/*     */     //   719: f2d
/*     */     //   720: invokestatic toRadians : (D)D
/*     */     //   723: dstore #11
/*     */     //   725: istore #20
/*     */     //   727: astore #19
/*     */     //   729: astore #18
/*     */     //   731: iconst_0
/*     */     //   732: istore #13
/*     */     //   734: dload #11
/*     */     //   736: invokestatic cos : (D)D
/*     */     //   739: dstore #21
/*     */     //   741: aload #18
/*     */     //   743: aload #19
/*     */     //   745: iload #20
/*     */     //   747: dload #21
/*     */     //   749: dastore
/*     */     //   750: dup
/*     */     //   751: iconst_1
/*     */     //   752: fload #4
/*     */     //   754: ldc_w 90.0
/*     */     //   757: fadd
/*     */     //   758: fload #9
/*     */     //   760: fadd
/*     */     //   761: f2d
/*     */     //   762: invokestatic toRadians : (D)D
/*     */     //   765: dstore #11
/*     */     //   767: istore #20
/*     */     //   769: astore #19
/*     */     //   771: astore #18
/*     */     //   773: iconst_0
/*     */     //   774: istore #13
/*     */     //   776: dload #11
/*     */     //   778: invokestatic sin : (D)D
/*     */     //   781: dstore #21
/*     */     //   783: aload #18
/*     */     //   785: aload #19
/*     */     //   787: iload #20
/*     */     //   789: dload #21
/*     */     //   791: dastore
/*     */     //   792: astore #10
/*     */     //   794: aload_1
/*     */     //   795: invokevirtual getX : ()D
/*     */     //   798: dstore #13
/*     */     //   800: ldc2_w 2.0
/*     */     //   803: dstore #15
/*     */     //   805: iconst_0
/*     */     //   806: istore #17
/*     */     //   808: dload #13
/*     */     //   810: dload #15
/*     */     //   812: invokestatic pow : (DD)D
/*     */     //   815: aload_1
/*     */     //   816: invokevirtual getZ : ()D
/*     */     //   819: dstore #13
/*     */     //   821: ldc2_w 2.0
/*     */     //   824: dstore #15
/*     */     //   826: dstore #18
/*     */     //   828: iconst_0
/*     */     //   829: istore #17
/*     */     //   831: dload #13
/*     */     //   833: dload #15
/*     */     //   835: invokestatic pow : (DD)D
/*     */     //   838: dstore #20
/*     */     //   840: dload #18
/*     */     //   842: dload #20
/*     */     //   844: dadd
/*     */     //   845: dstore #13
/*     */     //   847: iconst_0
/*     */     //   848: istore #15
/*     */     //   850: dload #13
/*     */     //   852: invokestatic sqrt : (D)D
/*     */     //   855: dstore #11
/*     */     //   857: iconst_2
/*     */     //   858: newarray double
/*     */     //   860: dup
/*     */     //   861: iconst_0
/*     */     //   862: dload #11
/*     */     //   864: aload #10
/*     */     //   866: iconst_0
/*     */     //   867: daload
/*     */     //   868: dmul
/*     */     //   869: dastore
/*     */     //   870: dup
/*     */     //   871: iconst_1
/*     */     //   872: dload #11
/*     */     //   874: aload #10
/*     */     //   876: iconst_1
/*     */     //   877: daload
/*     */     //   878: dmul
/*     */     //   879: dastore
/*     */     //   880: astore #13
/*     */     //   882: aload_1
/*     */     //   883: aload #13
/*     */     //   885: iconst_0
/*     */     //   886: daload
/*     */     //   887: invokevirtual setX : (D)V
/*     */     //   890: aload_1
/*     */     //   891: aload #13
/*     */     //   893: iconst_1
/*     */     //   894: daload
/*     */     //   895: invokevirtual setZ : (D)V
/*     */     //   898: aload_0
/*     */     //   899: getfield thirdPersonViewValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   902: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   905: checkcast java/lang/Boolean
/*     */     //   908: invokevirtual booleanValue : ()Z
/*     */     //   911: ifne -> 915
/*     */     //   914: return
/*     */     //   915: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   918: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   921: aload_0
/*     */     //   922: aload_2
/*     */     //   923: invokevirtual canStrafe : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*     */     //   926: ifeq -> 933
/*     */     //   929: iconst_3
/*     */     //   930: goto -> 934
/*     */     //   933: iconst_0
/*     */     //   934: putfield field_74320_O : I
/*     */     //   937: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #203	-> 6
/*     */     //   #204	-> 61
/*     */     //   #205	-> 76
/*     */     //   #206	-> 85
/*     */     //   #207	-> 87
/*     */     //   #209	-> 134
/*     */     //   #211	-> 156
/*     */     //   #213	-> 193
/*     */     //   #214	-> 193
/*     */     //   #213	-> 252
/*     */     //   #215	-> 254
/*     */     //   #217	-> 263
/*     */     //   #218	-> 306
/*     */     //   #220	-> 331
/*     */     //   #222	-> 334
/*     */     //   #223	-> 342
/*     */     //   #225	-> 342
/*     */     //   #223	-> 448
/*     */     //   #224	-> 463
/*     */     //   #223	-> 480
/*     */     //   #225	-> 485
/*     */     //   #226	-> 502
/*     */     //   #227	-> 510
/*     */     //   #228	-> 522
/*     */     //   #229	-> 530
/*     */     //   #231	-> 530
/*     */     //   #229	-> 636
/*     */     //   #230	-> 651
/*     */     //   #229	-> 668
/*     */     //   #231	-> 673
/*     */     //   #232	-> 690
/*     */     //   #233	-> 697
/*     */     //   #234	-> 705
/*     */     //   #236	-> 705
/*     */     //   #237	-> 709
/*     */     //   #238	-> 751
/*     */     //   #236	-> 792
/*     */     //   #240	-> 794
/*     */     //   #240	-> 815
/*     */     //   #240	-> 844
/*     */     //   #240	-> 855
/*     */     //   #242	-> 857
/*     */     //   #243	-> 861
/*     */     //   #244	-> 871
/*     */     //   #242	-> 880
/*     */     //   #247	-> 882
/*     */     //   #248	-> 890
/*     */     //   #250	-> 898
/*     */     //   #251	-> 915
/*     */     //   #253	-> 937
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   109	16	6	z	I
/*     */     //   98	33	4	x	I
/*     */     //   882	55	13	asLast	[D
/*     */     //   857	80	11	moveSpeed	D
/*     */     //   794	143	10	doSomeMath	[D
/*     */     //   334	603	9	mathStrafe	F
/*     */     //   331	606	7	moveAssist	D
/*     */     //   306	631	6	rotAssist	F
/*     */     //   254	683	5	targetStrafe	F
/*     */     //   156	781	4	yaw	F
/*     */     //   87	850	3	aroundVoid	Z
/*     */     //   76	861	2	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	938	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/TargetStrafe;
/*     */     //   0	938	1	event	Lnet/ccbluex/liquidbounce/event/MoveEvent;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canStrafe(@Nullable IEntityLivingBase target) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 134
/*     */     //   4: aload_0
/*     */     //   5: getfield holdSpaceValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   8: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   11: checkcast java/lang/Boolean
/*     */     //   14: invokevirtual booleanValue : ()Z
/*     */     //   17: ifeq -> 48
/*     */     //   20: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   23: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   28: dup
/*     */     //   29: ifnonnull -> 35
/*     */     //   32: invokestatic throwNpe : ()V
/*     */     //   35: invokeinterface getMovementInput : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IMovementInput;
/*     */     //   40: invokeinterface getJump : ()Z
/*     */     //   45: ifeq -> 134
/*     */     //   48: aload_0
/*     */     //   49: getfield onlySpeedValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   52: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   55: checkcast java/lang/Boolean
/*     */     //   58: invokevirtual booleanValue : ()Z
/*     */     //   61: ifeq -> 130
/*     */     //   64: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   67: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   70: ldc_w net/ccbluex/liquidbounce/features/module/modules/movement/Speed
/*     */     //   73: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   76: dup
/*     */     //   77: ifnonnull -> 83
/*     */     //   80: invokestatic throwNpe : ()V
/*     */     //   83: invokevirtual getState : ()Z
/*     */     //   86: ifne -> 130
/*     */     //   89: aload_0
/*     */     //   90: getfield onlyflyValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   93: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   96: checkcast java/lang/Boolean
/*     */     //   99: invokevirtual booleanValue : ()Z
/*     */     //   102: ifeq -> 134
/*     */     //   105: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   108: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   111: ldc_w net/ccbluex/liquidbounce/features/module/modules/movement/Fly
/*     */     //   114: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   117: dup
/*     */     //   118: ifnonnull -> 124
/*     */     //   121: invokestatic throwNpe : ()V
/*     */     //   124: invokevirtual getState : ()Z
/*     */     //   127: ifeq -> 134
/*     */     //   130: iconst_1
/*     */     //   131: goto -> 135
/*     */     //   134: iconst_0
/*     */     //   135: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #257	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	136	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/TargetStrafe;
/*     */     //   0	136	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final float getStrafeDistance(IEntityLivingBase target) {
/* 261 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/* 262 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();
/*     */     
/* 264 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  return RangesKt.coerceAtLeast(MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)target) - ((Number)this.radiusValue.get()).floatValue(), MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)target) - MinecraftInstance.mc.getThePlayer().getDistanceToEntity((IEntity)target) - ((Number)this.radiusValue.get()).floatValue() / ((Number)this.radiusValue.get()).floatValue() * 2);
/*     */   }
/*     */ 
/*     */   
/*     */   private final boolean isVoid(int xPos, int zPos) {
/* 269 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getPosY() < 0.0D) return true; 
/* 270 */     int off = 0; while (true) {
/* 271 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (off < (int)MinecraftInstance.mc.getThePlayer().getPosY() + 2) {
/* 272 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IAxisAlignedBB bb = MinecraftInstance.mc.getThePlayer().getEntityBoundingBox().offset(xPos, -(off), zPos);
/* 273 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getTheWorld().getCollidingBoundingBoxes((IEntity)MinecraftInstance.mc.getThePlayer(), bb).isEmpty()) {
/* 274 */           off += 2;
/*     */           continue;
/*     */         } 
/* 277 */         return false;
/*     */       }  break;
/* 279 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\TargetStrafe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */