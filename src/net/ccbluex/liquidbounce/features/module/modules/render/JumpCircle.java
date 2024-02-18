/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "JumpCircle", category = ModuleCategory.RENDER, description = "跳跃显示1")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000J\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\b\007\030\000 \0342\0020\001:\002\033\034B\005¢\006\002\020\002J\b\020\024\032\0020\025H\026J\022\020\026\032\0020\0252\b\020\027\032\004\030\0010\030H\007J\022\020\031\032\0020\0252\b\020\027\032\004\030\0010\032H\007R\034\020\003\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\016\020\t\032\0020\nX\016¢\006\002\n\000R\024\020\013\032\b\022\004\022\0020\r0\fX\004¢\006\002\n\000R\016\020\016\032\0020\nX\016¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\022X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/JumpCircle;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "allplayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getAllplayer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setAllplayer", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "allplayerlastOnGround", "", "circles", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lnet/ccbluex/liquidbounce/features/module/modules/render/JumpCircle$Circle;", "lastOnGround", "radiusValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "strengthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "widthValue", "onEnable", "", "onRender3D", "ignored", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "Circle", "Companion", "XSJClient"})
/*     */ public final class JumpCircle extends Module {
/*  21 */   private final IntegerValue radiusValue = new IntegerValue("Radius", 3, 1, 5);
/*  22 */   private final FloatValue widthValue = new FloatValue("Width", 0.5F, 0.1F, 50.0F);
/*  23 */   private final FloatValue strengthValue = new FloatValue("Strength", 0.02F, 0.01F, 0.2F);
/*  24 */   private final CopyOnWriteArrayList<Circle> circles = new CopyOnWriteArrayList<>(); private boolean lastOnGround; private boolean allplayerlastOnGround; @Nullable
/*     */   private IEntityLivingBase allplayer; @NotNull
/*     */   private static final BoolValue onlyself;
/*     */   
/*  28 */   public void onEnable() { this.lastOnGround = true;
/*  29 */     this.allplayerlastOnGround = true; }
/*     */   @Nullable
/*  31 */   public final IEntityLivingBase getAllplayer() { return this.allplayer; } public final void setAllplayer(@Nullable IEntityLivingBase <set-?>) { this.allplayer = <set-?>; }
/*     */    @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent ignored) {
/*  34 */     if (((Boolean)onlyself.get()).booleanValue()) {
/*  35 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround() && !this.lastOnGround)
/*     */       {
/*     */         
/*  38 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  39 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  40 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  41 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  42 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  43 */         if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.circles.add(new Circle(MinecraftInstance.mc.getThePlayer().getPosX(), MinecraftInstance.mc.getThePlayer().getPosY(), MinecraftInstance.mc.getThePlayer().getPosZ(), MinecraftInstance.mc.getThePlayer().getLastTickPosX(), MinecraftInstance.mc.getThePlayer().getLastTickPosY(), MinecraftInstance.mc.getThePlayer().getLastTickPosZ(), (
/*  44 */               (Number)this.widthValue.get()).floatValue()));
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  49 */       if (this.allplayer == null) Intrinsics.throwNpe();  if (this.allplayer.getOnGround() && !this.allplayerlastOnGround) {
/*     */ 
/*     */         
/*  52 */         if (this.allplayer == null) Intrinsics.throwNpe(); 
/*  53 */         if (this.allplayer == null) Intrinsics.throwNpe(); 
/*  54 */         if (this.allplayer == null) Intrinsics.throwNpe(); 
/*  55 */         if (this.allplayer == null) Intrinsics.throwNpe(); 
/*  56 */         if (this.allplayer == null) Intrinsics.throwNpe(); 
/*  57 */         if (this.allplayer == null) Intrinsics.throwNpe();  this.circles.add(new Circle(this.allplayer.getPosX(), this.allplayer.getPosY(), this.allplayer.getPosZ(), this.allplayer.getLastTickPosX(), this.allplayer.getLastTickPosY(), this.allplayer.getLastTickPosZ(), (
/*  58 */               (Number)this.widthValue.get()).floatValue()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  63 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastOnGround = MinecraftInstance.mc.getThePlayer().getOnGround();
/*  64 */     if (this.allplayer == null) Intrinsics.throwNpe();  this.allplayerlastOnGround = this.allplayer.getOnGround();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@Nullable Render3DEvent ignored) {
/*  69 */     if (!this.circles.isEmpty())
/*  70 */       for (Circle circle : this.circles) {
/*  71 */         if (circle.add(((Number)this.strengthValue.get()).floatValue()) > ((Number)this.radiusValue.get()).doubleValue()) {
/*  72 */           this.circles.remove(circle);
/*     */           continue;
/*     */         } 
/*  75 */         GL11.glPushMatrix();
/*  76 */         GL11.glTranslated(
/*  77 */             circle.getPosX() - MinecraftInstance.mc.getRenderManager().getRenderPosX(), 
/*  78 */             circle.getPosY() - MinecraftInstance.mc.getRenderManager().getRenderPosY(), 
/*  79 */             circle.getPosZ() - MinecraftInstance.mc.getRenderManager().getRenderPosZ());
/*     */         
/*  81 */         GL11.glEnable(3042);
/*  82 */         GL11.glEnable(2848);
/*  83 */         GL11.glDisable(3553);
/*  84 */         GL11.glDisable(2929);
/*  85 */         GL11.glBlendFunc(770, 771);
/*  86 */         GL11.glLineWidth(circle.getWidth());
/*  87 */         GL11.glColor4f((
/*  88 */             (Number)AColorPalette.r.get()).floatValue() / 255.0F, (
/*  89 */             (Number)AColorPalette.g.get()).floatValue() / 255.0F, (
/*  90 */             (Number)AColorPalette.b.get()).floatValue() / 255.0F, ((
/*  91 */             (Number)this.radiusValue.get()).floatValue() - circle.getRadius()) / ((Number)this.radiusValue.get()).floatValue());
/*     */ 
/*     */         
/*  94 */         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*  95 */         GL11.glBegin(3);
/*  96 */         int i = 0;
/*  97 */         while (i <= 360) {
/*     */           
/*  99 */           GL11.glVertex2f(
/* 100 */               (float)(Math.cos(i * Math.PI / 180.0D) * circle.getRadius()), 
/* 101 */               (float)(Math.sin(i * Math.PI / 180.0D) * circle.getRadius()));
/*     */           
/* 103 */           i += 5;
/*     */         } 
/* 105 */         GL11.glEnd();
/* 106 */         GL11.glDisable(3042);
/* 107 */         GL11.glEnable(3553);
/* 108 */         GL11.glEnable(2929);
/* 109 */         GL11.glDisable(2848);
/* 110 */         GL11.glPopMatrix();
/*     */       }  
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\000\n\002\020\006\n\002\b\006\n\002\020\007\n\002\b\030\b\000\030\0002\0020\001B=\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\006\020\006\032\0020\003\022\006\020\007\032\0020\003\022\006\020\b\032\0020\003\022\006\020\t\032\0020\n¢\006\002\020\013J\016\020!\032\0020\0032\006\020\032\032\0020\003R\032\020\006\032\0020\003X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\032\020\007\032\0020\003X\016¢\006\016\n\000\032\004\b\020\020\r\"\004\b\021\020\017R\032\020\b\032\0020\003X\016¢\006\016\n\000\032\004\b\022\020\r\"\004\b\023\020\017R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\024\020\r\"\004\b\025\020\017R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b\026\020\r\"\004\b\027\020\017R\032\020\005\032\0020\003X\016¢\006\016\n\000\032\004\b\030\020\r\"\004\b\031\020\017R\032\020\032\032\0020\nX\016¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036R\032\020\t\032\0020\nX\016¢\006\016\n\000\032\004\b\037\020\034\"\004\b \020\036¨\006\""}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/JumpCircle$Circle;", "", "posX", "", "posY", "posZ", "lastTickPosX", "lastTickPosY", "lastTickPosZ", "width", "", "(DDDDDDF)V", "getLastTickPosX", "()D", "setLastTickPosX", "(D)V", "getLastTickPosY", "setLastTickPosY", "getLastTickPosZ", "setLastTickPosZ", "getPosX", "setPosX", "getPosY", "setPosY", "getPosZ", "setPosZ", "radius", "getRadius", "()F", "setRadius", "(F)V", "getWidth", "setWidth", "add", "XSJClient"})
/*     */   public static final class Circle {
/*     */     private float radius; private double posX; private double posY; private double posZ;
/* 115 */     public Circle(double posX, double posY, double posZ, double lastTickPosX, double lastTickPosY, double lastTickPosZ, float width) { this.posX = posX; this.posY = posY; this.posZ = posZ; this.lastTickPosX = lastTickPosX; this.lastTickPosY = lastTickPosY; this.lastTickPosZ = lastTickPosZ; this.width = width; } private double lastTickPosX; private double lastTickPosY; private double lastTickPosZ; private float width; public final double getPosX() {
/* 116 */       return this.posX; } public final void setPosX(double <set-?>) { this.posX = <set-?>; }
/* 117 */     public final double getPosY() { return this.posY; } public final void setPosY(double <set-?>) { this.posY = <set-?>; }
/* 118 */     public final double getPosZ() { return this.posZ; } public final void setPosZ(double <set-?>) { this.posZ = <set-?>; }
/* 119 */     public final double getLastTickPosX() { return this.lastTickPosX; } public final void setLastTickPosX(double <set-?>) { this.lastTickPosX = <set-?>; }
/* 120 */     public final double getLastTickPosY() { return this.lastTickPosY; } public final void setLastTickPosY(double <set-?>) { this.lastTickPosY = <set-?>; }
/* 121 */     public final double getLastTickPosZ() { return this.lastTickPosZ; } public final void setLastTickPosZ(double <set-?>) { this.lastTickPosZ = <set-?>; }
/* 122 */     public final float getWidth() { return this.width; } public final void setWidth(float <set-?>) { this.width = <set-?>; }
/*     */     
/* 124 */     public final float getRadius() { return this.radius; } public final void setRadius(float <set-?>) { this.radius = <set-?>; }
/*     */      public final double add(double radius) {
/* 126 */       this.radius += (float)radius;
/* 127 */       return this.radius;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 132 */   public static final Companion Companion = new Companion(null); static { onlyself = new BoolValue("OnlySelf", true); } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/JumpCircle$Companion;", "", "()V", "onlyself", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getOnlyself", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "XSJClient"}) public static final class Companion { private Companion() {} @NotNull public final BoolValue getOnlyself() { return JumpCircle.onlyself; }
/*     */      }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\JumpCircle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */