/*     */ package net.ccbluex.liquidbounce.features.module.modules.movement;
/*     */ import java.awt.Color;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.SuperKnockback;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.Wtap;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.Rotation;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "GrimStrafe", description = "skid", category = ModuleCategory.MOVEMENT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000|\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\005\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020,\032\0020-H\026J\b\020.\032\0020-H\026J\020\020/\032\0020-2\006\0200\032\00201H\007J\020\0202\032\0020-2\006\0200\032\00203H\007J\020\0204\032\0020-2\006\0200\032\00205H\007J\020\0206\032\0020-2\006\0200\032\00207H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\016\020\t\032\0020\nX\004¢\006\002\n\000R\026\020\013\032\b\022\004\022\0020\r0\fX\004¢\006\004\n\002\020\016R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022R\016\020\023\032\0020\020X\004¢\006\002\n\000R\021\020\024\032\0020\025¢\006\b\n\000\032\004\b\026\020\027R\016\020\030\032\0020\031X.¢\006\002\n\000R\016\020\032\032\0020\020X\004¢\006\002\n\000R\016\020\033\032\0020\nX\004¢\006\002\n\000R\016\020\034\032\0020\nX\004¢\006\002\n\000R\016\020\035\032\0020\nX\004¢\006\002\n\000R\021\020\036\032\0020\020¢\006\b\n\000\032\004\b\037\020\022R\016\020 \032\0020!X\004¢\006\002\n\000R\016\020\"\032\0020\nX\004¢\006\002\n\000R\016\020#\032\0020\nX\004¢\006\002\n\000R\016\020$\032\0020%X.¢\006\002\n\000R\016\020&\032\0020!X\004¢\006\002\n\000R\016\020'\032\0020(X.¢\006\002\n\000R\016\020)\032\0020\nX\004¢\006\002\n\000R\016\020*\032\0020+X.¢\006\002\n\000¨\0068"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/movement/GrimStrafe;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "getA", "()I", "setA", "(I)V", "autoSpeed", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "binds", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "[Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "extrarange", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "getExtrarange", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "fixfovValue", "jumpdelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "getJumpdelayValue", "()Lnet/ccbluex/liquidbounce/value/IntegerValue;", "killAura", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;", "lineWidthValue", "nokbplusValue", "onGroundValue", "onlysprint", "radius", "getRadius", "renderModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "silent", "silentback", "speed", "Lnet/ccbluex/liquidbounce/features/module/modules/movement/Speed;", "strafeModeValue", "superKnockback", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/SuperKnockback;", "thirdPersonViewValue", "wtap", "Lnet/ccbluex/liquidbounce/features/module/modules/combat/Wtap;", "onDisable", "", "onEnable", "onMove", "event", "Lnet/ccbluex/liquidbounce/event/MoveEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onStrafe", "Lnet/ccbluex/liquidbounce/event/StrafeEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class GrimStrafe extends Module {
/*     */   @NotNull
/*  29 */   private final FloatValue radius = new FloatValue("Radius", 2.0F, 0.1F, 4.0F); @NotNull public final FloatValue getRadius() { return this.radius; } @NotNull
/*  30 */   private final FloatValue extrarange = new FloatValue("extrarange", 0.4F, 0.1F, 1.0F); @NotNull public final FloatValue getExtrarange() { return this.extrarange; } @NotNull
/*  31 */   private final IntegerValue jumpdelayValue = new IntegerValue("Legitjumpdelay", 3, 0, 20); @NotNull public final IntegerValue getJumpdelayValue() { return this.jumpdelayValue; }
/*  32 */    private final BoolValue onGroundValue = new BoolValue("OnlyOnGround", false);
/*  33 */   private final BoolValue nokbplusValue = new BoolValue("Nokbplus", true);
/*  34 */   private final BoolValue autoSpeed = new BoolValue("AutoSpeed ", false);
/*  35 */   private final BoolValue thirdPersonViewValue = new BoolValue("ThirdPersonView", false);
/*  36 */   private final ListValue renderModeValue = new ListValue("RenderMode", new String[] { "Circle", "Polygon", "None" }, "Polygon");
/*  37 */   private final ListValue strafeModeValue = new ListValue("strafeMode", new String[] { "Keybind", "Legit" }, "Legit");
/*  38 */   private final FloatValue lineWidthValue = new FloatValue("LineWidth", 1.0F, 1.0F, 10.0F);
/*  39 */   private final FloatValue fixfovValue = new FloatValue("FixFOV", 90.0F, 0.0F, 180.0F);
/*  40 */   private final BoolValue silent = new BoolValue("silent", true);
/*  41 */   private final BoolValue silentback = new BoolValue("silentback", true);
/*  42 */   private final BoolValue onlysprint = new BoolValue("onlysprint", true);
/*     */   private KillAura killAura; private Speed speed; private SuperKnockback superKnockback;
/*     */   private Wtap wtap;
/*     */   private int a;
/*     */   
/*  47 */   public final int getA() { return this.a; } public final void setA(int <set-?>) { this.a = <set-?>; }
/*  48 */    private final IKeyBinding[] binds = new IKeyBinding[] {
/*  49 */       MinecraftInstance.mc.getGameSettings().getKeyBindForward(), 
/*  50 */       MinecraftInstance.mc.getGameSettings().getKeyBindLeft(), 
/*  51 */       MinecraftInstance.mc.getGameSettings().getKeyBindBack(), 
/*  52 */       MinecraftInstance.mc.getGameSettings().getKeyBindRight() };
/*     */   
/*     */   public void onEnable() {
/*  55 */     if (Retreat.INSTANCE.getModuleManager().getModule(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  this.killAura = (KillAura)Retreat.INSTANCE.getModuleManager().getModule(KillAura.class);
/*  56 */     if (Retreat.INSTANCE.getModuleManager().getModule(Speed.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.movement.Speed");  this.speed = (Speed)Retreat.INSTANCE.getModuleManager().getModule(Speed.class);
/*  57 */     if (Retreat.INSTANCE.getModuleManager().getModule(Wtap.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.Wtap");  this.wtap = (Wtap)Retreat.INSTANCE.getModuleManager().getModule(Wtap.class);
/*  58 */     if (Retreat.INSTANCE.getModuleManager().getModule(SuperKnockback.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.SuperKnockback");  this.superKnockback = (SuperKnockback)Retreat.INSTANCE.getModuleManager().getModule(SuperKnockback.class);
/*  59 */     if (!((Boolean)this.silent.get()).booleanValue()) { if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  this.killAura.getSilentRotationValue().set(Boolean.valueOf(false)); }
/*  60 */      if (((Boolean)this.autoSpeed.get()).booleanValue()) { if (this.speed == null) Intrinsics.throwUninitializedPropertyAccessException("speed");  this.speed.setState(true); }
/*  61 */      if (this.wtap == null) Intrinsics.throwUninitializedPropertyAccessException("wtap");  if (this.wtap.getState() && ((Boolean)this.nokbplusValue.get()).booleanValue()) { if (this.superKnockback == null) Intrinsics.throwUninitializedPropertyAccessException("superKnockback");  this.superKnockback.getModeValue().set("hytpacket"); }
/*  62 */      this.a = 0;
/*     */   }
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*  66 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  IEntityLivingBase target = this.killAura.getTarget();
/*  67 */     if ((Intrinsics.areEqual(this.renderModeValue.get(), "None") ^ true) != 0) {
/*  68 */       if (target == null)
/*  69 */         return;  int[] counter = { 0 };
/*  70 */       if (StringsKt.equals((String)this.renderModeValue.get(), "Circle", true)) {
/*  71 */         GL11.glPushMatrix();
/*  72 */         GL11.glDisable(3553);
/*  73 */         GL11.glEnable(2848);
/*  74 */         GL11.glEnable(2881);
/*  75 */         GL11.glEnable(2832);
/*  76 */         GL11.glEnable(3042);
/*  77 */         GL11.glBlendFunc(770, 771);
/*  78 */         GL11.glHint(3154, 4354);
/*  79 */         GL11.glHint(3155, 4354);
/*  80 */         GL11.glHint(3153, 4354);
/*  81 */         GL11.glDisable(2929);
/*  82 */         GL11.glDepthMask(false);
/*  83 */         GL11.glLineWidth(((Number)this.lineWidthValue.get()).floatValue());
/*  84 */         GL11.glBegin(3);
/*  85 */         double x = target.getLastTickPosX() + (target.getPosX() - target.getLastTickPosX()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosX();
/*  86 */         double y = target.getLastTickPosY() + (target.getPosY() - target.getLastTickPosY()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosY();
/*  87 */         double z = target.getLastTickPosZ() + (target.getPosZ() - target.getLastTickPosZ()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosZ(); byte b; char c;
/*  88 */         for (b = 0, c = 'ŧ'; b <= c; b++) {
/*     */ 
/*     */           
/*  91 */           if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double d1 = b / 50.0D * 1.75D, d3 = MinecraftInstance.mc.getThePlayer().getTicksExisted() / 70.0D; boolean bool = false; double d4 = Math.sin(d1); int i = Color.HSBtoRGB((float)((d3 + d4) % 1.0F), 
/*  92 */               0.7F, 
/*  93 */               1.0F);
/*     */           
/*     */           Color rainbow = new Color(i);
/*  96 */           GL11.glColor3f(rainbow.getRed() / 255.0F, rainbow.getGreen() / 255.0F, rainbow.getBlue() / 255.0F);
/*     */           
/*  98 */           d1 = b * 6.283185307179586D / 45.0D; d3 = ((Number)this.radius.get()).doubleValue(); double d2 = x; bool = false; d4 = Math.cos(d1);
/*     */           
/* 100 */           d1 = b * 6.283185307179586D / 45.0D; double d5 = ((Number)this.radius.get()).doubleValue(); d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */         } 
/*     */         
/* 103 */         GL11.glEnd();
/* 104 */         GL11.glDepthMask(true);
/* 105 */         GL11.glEnable(2929);
/* 106 */         GL11.glDisable(2848);
/* 107 */         GL11.glDisable(2881);
/* 108 */         GL11.glEnable(2832);
/* 109 */         GL11.glEnable(3553);
/* 110 */         GL11.glPopMatrix();
/*     */       } else {
/* 112 */         float rad = ((Number)this.radius.get()).floatValue();
/* 113 */         GL11.glPushMatrix();
/* 114 */         GL11.glDisable(3553);
/* 115 */         RenderUtils.startDrawing();
/* 116 */         GL11.glDisable(2929);
/* 117 */         GL11.glDepthMask(false);
/* 118 */         GL11.glLineWidth(((Number)this.lineWidthValue.get()).floatValue());
/* 119 */         GL11.glBegin(3);
/* 120 */         double x = target.getLastTickPosX() + (target.getPosX() - target.getLastTickPosX()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosX();
/* 121 */         double y = target.getLastTickPosY() + (target.getPosY() - target.getLastTickPosY()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosY();
/* 122 */         double z = target.getLastTickPosZ() + (target.getPosZ() - target.getLastTickPosZ()) * event.getPartialTicks() - MinecraftInstance.mc.getRenderManager().getViewerPosZ();
/* 123 */         for (byte b1 = 0, b2 = 10; b1 <= b2; b1++) {
/* 124 */           counter[0] = counter[0] + 1;
/* 125 */           Color rainbow = new Color(ColorManager.astolfoRainbow(counter[0] * 100, 5, 107));
/*     */           
/* 127 */           GL11.glColor3f(rainbow.getRed() / 255.0F, rainbow.getGreen() / 255.0F, rainbow.getBlue() / 255.0F);
/* 128 */           if (rad < 0.8D && rad > 0.0D) {
/* 129 */             double d1 = b1 * 6.283185307179586D / 3.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 131 */             d1 = b1 * 6.283185307179586D / 3.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/* 133 */           if (rad < 1.5D && rad > 0.7D) {
/* 134 */             counter[0] = counter[0] + 1;
/* 135 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 137 */             double d1 = b1 * 6.283185307179586D / 4.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 139 */             d1 = b1 * 6.283185307179586D / 4.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/* 142 */           if (rad < 2.0D && rad > 1.4D) {
/* 143 */             counter[0] = counter[0] + 1;
/* 144 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 146 */             double d1 = b1 * 6.283185307179586D / 5.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 148 */             d1 = b1 * 6.283185307179586D / 5.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/* 151 */           if (rad < 2.4D && rad > 1.9D) {
/* 152 */             counter[0] = counter[0] + 1;
/* 153 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 155 */             double d1 = b1 * 6.283185307179586D / 6.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 157 */             d1 = b1 * 6.283185307179586D / 6.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/* 160 */           if (rad < 2.7D && rad > 2.3D) {
/* 161 */             counter[0] = counter[0] + 1;
/* 162 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 164 */             double d1 = b1 * 6.283185307179586D / 7.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 166 */             d1 = b1 * 6.283185307179586D / 7.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/* 169 */           if (rad < 6.0D && rad > 2.6D) {
/* 170 */             counter[0] = counter[0] + 1;
/* 171 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 173 */             double d1 = b1 * 6.283185307179586D / 8.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 175 */             d1 = b1 * 6.283185307179586D / 8.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/* 178 */           if (rad < 7.0D && rad > 5.9D) {
/* 179 */             counter[0] = counter[0] + 1;
/* 180 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 182 */             double d1 = b1 * 6.283185307179586D / 9.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 184 */             d1 = b1 * 6.283185307179586D / 9.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */           
/* 187 */           if (rad < 11.0D && rad > 6.9D) {
/* 188 */             counter[0] = counter[0] + 1;
/* 189 */             RenderUtils.glColor(new Color(80, 255, 255, 200));
/*     */             
/* 191 */             double d1 = b1 * 6.283185307179586D / 10.0D, d3 = rad, d2 = x; boolean bool = false; double d4 = Math.cos(d1);
/*     */             
/* 193 */             d1 = b1 * 6.283185307179586D / 10.0D; double d5 = rad; d4 = z; d3 = y; d2 = d2 + d3 * d4; bool = false; double d6 = Math.sin(d1); GL11.glVertex3d(d2, d3, d4 + d5 * d6);
/*     */           } 
/*     */         } 
/*     */         
/* 197 */         GL11.glEnd();
/* 198 */         GL11.glDepthMask(true);
/* 199 */         GL11.glEnable(2929);
/* 200 */         RenderUtils.stopDrawing();
/* 201 */         GL11.glEnable(3553);
/* 202 */         GL11.glPopMatrix();
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
/*     */   @EventTarget
/*     */   public final void onMove(@NotNull MoveEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield onGroundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   13: checkcast java/lang/Boolean
/*     */     //   16: invokevirtual booleanValue : ()Z
/*     */     //   19: ifeq -> 45
/*     */     //   22: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   25: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   30: dup
/*     */     //   31: ifnonnull -> 37
/*     */     //   34: invokestatic throwNpe : ()V
/*     */     //   37: invokeinterface getOnGround : ()Z
/*     */     //   42: ifeq -> 126
/*     */     //   45: aload_0
/*     */     //   46: getfield thirdPersonViewValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   49: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   52: checkcast java/lang/Boolean
/*     */     //   55: invokevirtual booleanValue : ()Z
/*     */     //   58: ifne -> 62
/*     */     //   61: return
/*     */     //   62: aload_0
/*     */     //   63: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   66: dup
/*     */     //   67: ifnonnull -> 75
/*     */     //   70: ldc 'killAura'
/*     */     //   72: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   75: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   78: ifnull -> 94
/*     */     //   81: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   84: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   87: iconst_3
/*     */     //   88: putfield field_74320_O : I
/*     */     //   91: goto -> 204
/*     */     //   94: aload_0
/*     */     //   95: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   98: dup
/*     */     //   99: ifnonnull -> 107
/*     */     //   102: ldc 'killAura'
/*     */     //   104: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   107: invokevirtual getState : ()Z
/*     */     //   110: ifne -> 123
/*     */     //   113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   116: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   119: iconst_0
/*     */     //   120: putfield field_74320_O : I
/*     */     //   123: goto -> 204
/*     */     //   126: aload_0
/*     */     //   127: getfield thirdPersonViewValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   130: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   133: checkcast java/lang/Boolean
/*     */     //   136: invokevirtual booleanValue : ()Z
/*     */     //   139: ifne -> 143
/*     */     //   142: return
/*     */     //   143: aload_0
/*     */     //   144: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   147: dup
/*     */     //   148: ifnonnull -> 156
/*     */     //   151: ldc 'killAura'
/*     */     //   153: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   156: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   159: ifnull -> 175
/*     */     //   162: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   165: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   168: iconst_3
/*     */     //   169: putfield field_74320_O : I
/*     */     //   172: goto -> 204
/*     */     //   175: aload_0
/*     */     //   176: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   179: dup
/*     */     //   180: ifnonnull -> 188
/*     */     //   183: ldc 'killAura'
/*     */     //   185: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   188: invokevirtual getState : ()Z
/*     */     //   191: ifne -> 204
/*     */     //   194: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc2 : Lnet/minecraft/client/Minecraft;
/*     */     //   197: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
/*     */     //   200: iconst_0
/*     */     //   201: putfield field_74320_O : I
/*     */     //   204: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #208	-> 6
/*     */     //   #209	-> 45
/*     */     //   #210	-> 61
/*     */     //   #211	-> 62
/*     */     //   #212	-> 81
/*     */     //   #213	-> 94
/*     */     //   #214	-> 113
/*     */     //   #215	-> 123
/*     */     //   #217	-> 126
/*     */     //   #218	-> 143
/*     */     //   #219	-> 162
/*     */     //   #220	-> 175
/*     */     //   #221	-> 194
/*     */     //   #222	-> 204
/*     */     //   #223	-> 204
/*     */     //   #224	-> 204
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	205	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/GrimStrafe;
/*     */     //   0	205	1	event	Lnet/ccbluex/liquidbounce/event/MoveEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onStrafe(@NotNull StrafeEvent event) {
/* 227 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (StringsKt.equals((String)this.strafeModeValue.get(), "Legit", true)) {
/* 228 */       if (RotationUtils.targetRotation != null) {
/* 229 */         MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(true);
/* 230 */         MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(true);
/* 231 */         if (RotationUtils.targetRotation != null) { Rotation rotation = RotationUtils.targetRotation; float yaw = rotation.component1();
/* 232 */           float strafe = event.getStrafe();
/* 233 */           float forward = event.getForward();
/* 234 */           float friction = event.getFriction();
/*     */           
/* 236 */           float f = strafe * strafe + forward * forward;
/*     */           
/* 238 */           if (f >= 1.0E-4F) {
/* 239 */             boolean bool1 = false; f = (float)Math.sqrt(f);
/*     */             
/* 241 */             if (f < 1.0F) {
/* 242 */               f = 1.0F;
/*     */             }
/* 244 */             f = friction / f;
/* 245 */             strafe *= f;
/* 246 */             forward *= f;
/*     */             
/* 248 */             float f1 = (float)(yaw * Math.PI / 180.0F); boolean bool2 = false; float yawSin = (float)Math.sin(f1);
/* 249 */             float f2 = (float)(yaw * Math.PI / 180.0F); boolean bool3 = false; float yawCos = (float)Math.cos(f2);
/*     */             
/* 251 */             if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP player = MinecraftInstance.mc.getThePlayer();
/*     */             
/* 253 */             player.setMotionX(player.getMotionX() + (strafe * yawCos - forward * yawSin));
/* 254 */             player.setMotionZ(player.getMotionZ() + (forward * yawCos + strafe * yawSin));
/*     */           } 
/* 256 */           event.cancelEvent(); return; }
/*     */          return;
/* 258 */       }  MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindLeft()));
/* 259 */       MinecraftInstance.mc.getGameSettings().getKeyBindForward().setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindForward()));
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
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield strafeModeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   10: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   13: checkcast java/lang/String
/*     */     //   16: ldc_w 'Keybind'
/*     */     //   19: iconst_1
/*     */     //   20: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   23: ifeq -> 704
/*     */     //   26: aload_0
/*     */     //   27: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   30: dup
/*     */     //   31: ifnonnull -> 39
/*     */     //   34: ldc 'killAura'
/*     */     //   36: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   39: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   42: ifnonnull -> 95
/*     */     //   45: aload_0
/*     */     //   46: getfield a : I
/*     */     //   49: ifeq -> 95
/*     */     //   52: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   55: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   60: invokeinterface getKeyBindBack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   65: iconst_0
/*     */     //   66: invokeinterface setPressed : (Z)V
/*     */     //   71: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   74: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   79: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   84: iconst_0
/*     */     //   85: invokeinterface setPressed : (Z)V
/*     */     //   90: aload_0
/*     */     //   91: iconst_0
/*     */     //   92: putfield a : I
/*     */     //   95: aload_0
/*     */     //   96: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   99: dup
/*     */     //   100: ifnonnull -> 108
/*     */     //   103: ldc 'killAura'
/*     */     //   105: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   108: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   111: ifnonnull -> 115
/*     */     //   114: return
/*     */     //   115: aload_0
/*     */     //   116: iconst_1
/*     */     //   117: putfield a : I
/*     */     //   120: aload_0
/*     */     //   121: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   124: dup
/*     */     //   125: ifnonnull -> 133
/*     */     //   128: ldc 'killAura'
/*     */     //   130: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   133: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   136: dup
/*     */     //   137: ifnonnull -> 143
/*     */     //   140: invokestatic throwNpe : ()V
/*     */     //   143: invokeinterface isDead : ()Z
/*     */     //   148: ifne -> 185
/*     */     //   151: aload_0
/*     */     //   152: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   155: dup
/*     */     //   156: ifnonnull -> 164
/*     */     //   159: ldc 'killAura'
/*     */     //   161: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   164: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   167: dup
/*     */     //   168: ifnonnull -> 174
/*     */     //   171: invokestatic throwNpe : ()V
/*     */     //   174: invokeinterface getHealth : ()F
/*     */     //   179: iconst_0
/*     */     //   180: i2f
/*     */     //   181: fcmpg
/*     */     //   182: ifgt -> 242
/*     */     //   185: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   188: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   193: invokeinterface getKeyBindBack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   198: iconst_0
/*     */     //   199: invokeinterface setPressed : (Z)V
/*     */     //   204: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   207: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   212: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   217: iconst_0
/*     */     //   218: invokeinterface setPressed : (Z)V
/*     */     //   223: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   226: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   231: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   236: iconst_1
/*     */     //   237: invokeinterface setPressed : (Z)V
/*     */     //   242: aload_0
/*     */     //   243: getfield killAura : Lnet/ccbluex/liquidbounce/features/module/modules/combat/KillAura;
/*     */     //   246: dup
/*     */     //   247: ifnonnull -> 255
/*     */     //   250: ldc 'killAura'
/*     */     //   252: invokestatic throwUninitializedPropertyAccessException : (Ljava/lang/String;)V
/*     */     //   255: invokevirtual getTarget : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   258: dup
/*     */     //   259: ifnonnull -> 265
/*     */     //   262: invokestatic throwNpe : ()V
/*     */     //   265: astore_2
/*     */     //   266: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   269: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   274: dup
/*     */     //   275: ifnonnull -> 281
/*     */     //   278: invokestatic throwNpe : ()V
/*     */     //   281: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   284: aload_2
/*     */     //   285: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   288: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   291: aload_0
/*     */     //   292: getfield radius : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   295: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   298: checkcast java/lang/Number
/*     */     //   301: invokevirtual doubleValue : ()D
/*     */     //   304: dcmpg
/*     */     //   305: ifgt -> 427
/*     */     //   308: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   311: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   316: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   321: invokeinterface isKeyDown : ()Z
/*     */     //   326: ifeq -> 368
/*     */     //   329: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   332: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   337: dup
/*     */     //   338: ifnonnull -> 344
/*     */     //   341: invokestatic throwNpe : ()V
/*     */     //   344: invokeinterface getSprinting : ()Z
/*     */     //   349: ifeq -> 368
/*     */     //   352: aload_0
/*     */     //   353: getfield onlysprint : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   356: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   359: checkcast java/lang/Boolean
/*     */     //   362: invokevirtual booleanValue : ()Z
/*     */     //   365: ifne -> 405
/*     */     //   368: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   371: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   376: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   381: invokeinterface isKeyDown : ()Z
/*     */     //   386: ifeq -> 480
/*     */     //   389: aload_0
/*     */     //   390: getfield onlysprint : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   393: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   396: checkcast java/lang/Boolean
/*     */     //   399: invokevirtual booleanValue : ()Z
/*     */     //   402: ifne -> 480
/*     */     //   405: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   408: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   413: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   418: iconst_0
/*     */     //   419: invokeinterface setPressed : (Z)V
/*     */     //   424: goto -> 480
/*     */     //   427: aload_0
/*     */     //   428: getfield binds : [Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   431: astore #5
/*     */     //   433: aload #5
/*     */     //   435: arraylength
/*     */     //   436: istore #6
/*     */     //   438: iconst_0
/*     */     //   439: istore #4
/*     */     //   441: iload #4
/*     */     //   443: iload #6
/*     */     //   445: if_icmpge -> 480
/*     */     //   448: aload #5
/*     */     //   450: iload #4
/*     */     //   452: aaload
/*     */     //   453: astore_3
/*     */     //   454: aload_3
/*     */     //   455: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   458: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   463: aload_3
/*     */     //   464: invokeinterface isKeyDown : (Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;)Z
/*     */     //   469: invokeinterface setPressed : (Z)V
/*     */     //   474: iinc #4, 1
/*     */     //   477: goto -> 441
/*     */     //   480: aload_0
/*     */     //   481: getfield silent : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   484: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   487: checkcast java/lang/Boolean
/*     */     //   490: invokevirtual booleanValue : ()Z
/*     */     //   493: ifeq -> 577
/*     */     //   496: aload_0
/*     */     //   497: getfield silentback : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   500: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   503: checkcast java/lang/Boolean
/*     */     //   506: invokevirtual booleanValue : ()Z
/*     */     //   509: ifeq -> 577
/*     */     //   512: aload_2
/*     */     //   513: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   516: invokestatic getRotationDifference : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   519: aload_0
/*     */     //   520: getfield fixfovValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   523: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   526: checkcast java/lang/Number
/*     */     //   529: invokevirtual doubleValue : ()D
/*     */     //   532: dcmpl
/*     */     //   533: ifle -> 577
/*     */     //   536: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   539: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   544: invokeinterface getKeyBindBack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   549: iconst_1
/*     */     //   550: invokeinterface setPressed : (Z)V
/*     */     //   555: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   558: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   563: invokeinterface getKeyBindForward : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   568: iconst_0
/*     */     //   569: invokeinterface setPressed : (Z)V
/*     */     //   574: goto -> 628
/*     */     //   577: aload_0
/*     */     //   578: getfield silent : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   581: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   584: checkcast java/lang/Boolean
/*     */     //   587: invokevirtual booleanValue : ()Z
/*     */     //   590: ifeq -> 628
/*     */     //   593: aload_0
/*     */     //   594: getfield silentback : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   597: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   600: checkcast java/lang/Boolean
/*     */     //   603: invokevirtual booleanValue : ()Z
/*     */     //   606: ifeq -> 628
/*     */     //   609: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   612: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   617: invokeinterface getKeyBindBack : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   622: iconst_0
/*     */     //   623: invokeinterface setPressed : (Z)V
/*     */     //   628: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   631: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   636: dup
/*     */     //   637: ifnonnull -> 643
/*     */     //   640: invokestatic throwNpe : ()V
/*     */     //   643: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   646: aload_2
/*     */     //   647: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   650: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   653: aload_0
/*     */     //   654: getfield radius : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   657: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   660: checkcast java/lang/Number
/*     */     //   663: invokevirtual floatValue : ()F
/*     */     //   666: aload_0
/*     */     //   667: getfield extrarange : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   670: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   673: checkcast java/lang/Number
/*     */     //   676: invokevirtual floatValue : ()F
/*     */     //   679: fadd
/*     */     //   680: f2d
/*     */     //   681: dcmpg
/*     */     //   682: ifgt -> 704
/*     */     //   685: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   688: invokeinterface getGameSettings : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;
/*     */     //   693: invokeinterface getKeyBindLeft : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   698: iconst_1
/*     */     //   699: invokeinterface setPressed : (Z)V
/*     */     //   704: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #267	-> 6
/*     */     //   #268	-> 26
/*     */     //   #269	-> 52
/*     */     //   #270	-> 71
/*     */     //   #271	-> 90
/*     */     //   #273	-> 95
/*     */     //   #274	-> 115
/*     */     //   #275	-> 120
/*     */     //   #276	-> 185
/*     */     //   #277	-> 204
/*     */     //   #278	-> 223
/*     */     //   #280	-> 242
/*     */     //   #281	-> 266
/*     */     //   #282	-> 308
/*     */     //   #283	-> 308
/*     */     //   #282	-> 352
/*     */     //   #283	-> 389
/*     */     //   #285	-> 405
/*     */     //   #288	-> 427
/*     */     //   #289	-> 454
/*     */     //   #288	-> 474
/*     */     //   #291	-> 480
/*     */     //   #292	-> 480
/*     */     //   #293	-> 536
/*     */     //   #294	-> 555
/*     */     //   #295	-> 577
/*     */     //   #296	-> 609
/*     */     //   #297	-> 628
/*     */     //   #298	-> 628
/*     */     //   #299	-> 685
/*     */     //   #302	-> 704
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   454	23	3	bind	Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;
/*     */     //   266	438	2	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	705	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/movement/GrimStrafe;
/*     */     //   0	705	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   public void onDisable() {
/* 305 */     MinecraftInstance.mc2.field_71474_y.field_74320_O = 0;
/* 306 */     MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindLeft()));
/* 307 */     MinecraftInstance.mc.getGameSettings().getKeyBindBack().setPressed(MinecraftInstance.mc.getGameSettings().isKeyDown(MinecraftInstance.mc.getGameSettings().getKeyBindBack()));
/* 308 */     if (this.killAura == null) Intrinsics.throwUninitializedPropertyAccessException("killAura");  this.killAura.getSilentRotationValue().set(Boolean.valueOf(true));
/* 309 */     if (((Boolean)this.autoSpeed.get()).booleanValue()) { if (this.speed == null) Intrinsics.throwUninitializedPropertyAccessException("speed");  this.speed.setState(false); }
/* 310 */      if (this.wtap == null) Intrinsics.throwUninitializedPropertyAccessException("wtap");  if (this.wtap.getState() && ((Boolean)this.nokbplusValue.get()).booleanValue()) { if (this.superKnockback == null) Intrinsics.throwUninitializedPropertyAccessException("superKnockback");  this.superKnockback.getModeValue().set("WTap"); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\movement\GrimStrafe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */