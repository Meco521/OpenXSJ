/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.random.Random;
/*     */ import kotlin.ranges.IntRange;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.event.WorldEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.Sphere;
/*     */ 
/*     */ @ModuleInfo(name = "Trails", category = ModuleCategory.RENDER, description = "尾巴")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000n\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\020\b\n\002\b\002\n\002\020%\n\002\020!\n\002\030\002\n\002\b\003\n\002\020\007\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001:\001(B\005¢\006\002\020\002J\b\020\034\032\0020\035H\026J\020\020\036\032\0020\0352\006\020\037\032\0020 H\007J\020\020!\032\0020\0352\006\020\037\032\0020\"H\007J\020\020#\032\0020\0352\006\020\037\032\0020$H\007J\020\020%\032\0020\0352\006\020&\032\0020'H\002R\021\020\003\032\0020\0048F¢\006\006\032\004\b\005\020\006R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\nX\004¢\006\002\n\000R\016\020\f\032\0020\bX\004¢\006\002\n\000R\016\020\r\032\0020\nX\004¢\006\002\n\000R\024\020\016\032\b\022\004\022\0020\0200\017X\004¢\006\002\n\000R\016\020\021\032\0020\nX\004¢\006\002\n\000R \020\022\032\024\022\004\022\0020\020\022\n\022\b\022\004\022\0020\0250\0240\023X\004¢\006\002\n\000R\016\020\026\032\0020\bX\004¢\006\002\n\000R\016\020\027\032\0020\020X\004¢\006\002\n\000R\024\020\030\032\b\022\004\022\0020\0310\017X\004¢\006\002\n\000R\016\020\032\032\0020\033X\004¢\006\002\n\000¨\006)"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Trails;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "color", "Ljava/awt/Color;", "getColor", "()Ljava/awt/Color;", "colorAlphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorRainbowValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "drawThePlayerValue", "fadeTimeValue", "fadeValue", "lineWidthValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "onlyThirdPerson", "points", "", "", "Lnet/ccbluex/liquidbounce/features/module/modules/render/Trails$BreadcrumbPoint;", "precisionValue", "sphereList", "sphereScaleValue", "", "typeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "onDisable", "", "onRender3D", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "onWorld", "Lnet/ccbluex/liquidbounce/event/WorldEvent;", "updatePoints", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "BreadcrumbPoint", "XSJClient"})
/*     */ public final class Trails extends Module {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  35 */   static final class Trails$sphereScaleValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return (Trails.this.typeValue.equals("Sphere") || Trails.this.typeValue.equals("Rise")); } Trails$sphereScaleValue$1() { super(0); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Trails$lineWidthValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return Trails.this.typeValue.equals("Line"); } Trails$lineWidthValue$1() { super(0); } } private final ListValue typeValue = new ListValue("Type", new String[] { "Line", "Rect", "heart", "lava", "smoke", "cloud", "flame", "slime", "water", "firework" }, "Lava"); private final IntegerValue colorAlphaValue = new IntegerValue("Alpha", 255, 0, 255); private final BoolValue colorRainbowValue = new BoolValue("Rainbow", false); private final BoolValue fadeValue = new BoolValue("Fade", true); private final BoolValue drawThePlayerValue = new BoolValue("DrawThePlayer", true); private final IntegerValue fadeTimeValue = new IntegerValue("FadeTime", 2, 1, 20); private final IntegerValue precisionValue = new IntegerValue("Precision", 2, 1, 20); private final Value<Integer> lineWidthValue = (new IntegerValue("LineWidth", 1, 1, 10)).displayable(new Trails$lineWidthValue$1()); private final Value<Float> sphereScaleValue = (new FloatValue("SphereScale", 0.6F, 0.1F, 2.0F)).displayable(new Trails$sphereScaleValue$1());
/*  36 */   private final BoolValue onlyThirdPerson = new BoolValue("OnlyThirdPerson", false);
/*  37 */   private final Map<Integer, List<BreadcrumbPoint>> points; private final int sphereList; public Trails() { Trails trails = this; boolean bool = false; LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     this.sphereList = GL11.glGenLists(1);
/*     */ 
/*     */     
/*  45 */     GL11.glNewList(this.sphereList, 4864);
/*     */     
/*  47 */     Sphere shaft = new Sphere();
/*  48 */     shaft.setDrawStyle(100012);
/*  49 */     shaft.draw(0.3F, 25, 10);
/*     */     
/*  51 */     GL11.glEndList(); }
/*     */   @NotNull
/*     */   public final Color getColor() {
/*     */     return ((Boolean)this.colorRainbowValue.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/*     */   } @EventTarget
/*  56 */   public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (((Boolean)this.onlyThirdPerson.get()).booleanValue() && MinecraftInstance.mc.getGameSettings().getThirdPersonView() == 0)
/*     */       return; 
/*  58 */     int fTime = ((Number)this.fadeTimeValue.get()).intValue() * 1000;
/*  59 */     long fadeSec = System.currentTimeMillis() - fTime;
/*  60 */     float colorAlpha = ((Number)this.colorAlphaValue.get()).floatValue() / 255.0F;
/*     */     
/*  62 */     GL11.glPushMatrix();
/*  63 */     GL11.glDisable(3553);
/*  64 */     GL11.glBlendFunc(770, 771);
/*  65 */     GL11.glEnable(3042);
/*  66 */     GL11.glDisable(2929);
/*  67 */     MinecraftInstance.mc.getEntityRenderer().disableLightmap();
/*  68 */     double renderPosX = MinecraftInstance.mc.getRenderManager().getViewerPosX();
/*  69 */     double renderPosY = MinecraftInstance.mc.getRenderManager().getViewerPosY();
/*  70 */     double renderPosZ = MinecraftInstance.mc.getRenderManager().getViewerPosZ();
/*  71 */     Map<Integer, List<BreadcrumbPoint>> $this$forEach$iv = this.points; int $i$f$forEach = 0;
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
/*     */ 
/*     */ 
/*     */     
/* 246 */     Map<Integer, List<BreadcrumbPoint>> map1 = $this$forEach$iv; boolean bool = false; Iterator<Map.Entry> iterator = map1.entrySet().iterator(); if (iterator.hasNext()) { Map.Entry element$iv = iterator.next(), $dstr$_u24__u24$mutableList = element$iv; int $i$a$-forEach-Trails$onRender3D$1 = 0; Map.Entry entry1 = $dstr$_u24__u24$mutableList; boolean bool1 = false; List mutableList = (List)entry1.getValue(); double lastPosX = 114514.0D; double lastPosY = 114514.0D; double lastPosZ = 114514.0D; String str = (String)this.typeValue.get(); boolean bool2 = false; }  GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D); GL11.glEnable(2929); GL11.glDisable(3042); GL11.glEnable(3553); GL11.glPopMatrix(); } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); boolean bool1 = true; IntRange intRange = new IntRange(bool1, 8); boolean bool2 = false; int a1in8chance = RangesKt.random(intRange, (Random)Random.Default); boolean ifrender = false; if (a1in8chance == 1 && MovementUtils.isMoving() && MinecraftInstance.mc.getGameSettings().getThirdPersonView() != 0) { ifrender = true; } else { ifrender = false; }  String str = (String)this.typeValue.get(); boolean bool3 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 94756405: if (str.equals("cloud") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.CLOUD); }  break;case 3314400: if (str.equals("lava") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.LAVA); }  break;case -562711993: if (str.equals("firework") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.FIREWORKS_SPARK); }  break;case 109562223: if (str.equals("smoke")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.REDSTONE); }  break;case 97513267: if (str.equals("flame") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.FLAME); }  break;case 112903447: if (str.equals("water") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.WATER_SPLASH); }  break;case 99151942: if (str.equals("heart") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null)
/*     */             Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.HEART); }  break;case 109526728: if (str.equals("slime") && ifrender) { if (MinecraftInstance.mc.getThePlayer() == null)
/* 248 */             Intrinsics.throwNpe();  MinecraftInstance.mc.getEffectRenderer().emitParticleAtEntity((IEntity)MinecraftInstance.mc.getThePlayer(), EnumParticleTypes.SLIME); }  break; }  Map<Integer, List<BreadcrumbPoint>> $this$forEach$iv = this.points; int $i$f$forEach = 0; Map<Integer, List<BreadcrumbPoint>> map1 = $this$forEach$iv; boolean bool4 = false; Iterator<Map.Entry> iterator = map1.entrySet().iterator(); if (iterator.hasNext()) { Map.Entry element$iv = iterator.next(), $dstr$id$_u24__u24 = element$iv; int $i$a$-forEach-Trails$onUpdate$1 = 0; Map.Entry entry1 = $dstr$id$_u24__u24; boolean bool = false; int id = ((Number)entry1.getKey()).intValue();
/*     */       if (MinecraftInstance.mc.getTheWorld() == null)
/*     */         Intrinsics.throwNpe();  }
/*     */     
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer().getTicksExisted() % ((Number)this.precisionValue.get()).intValue() != 0)
/*     */       return; 
/*     */     if (((Boolean)this.drawThePlayerValue.get()).booleanValue()) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       updatePoints((IEntityLivingBase)MinecraftInstance.mc.getThePlayer());
/*     */     }  }
/*     */ 
/*     */   
/*     */   private final void updatePoints(IEntityLivingBase entity) {
/*     */     if ((List)this.points.get(Integer.valueOf(entity.getEntityId())) == null) {
/*     */       (List)this.points.get(Integer.valueOf(entity.getEntityId()));
/*     */       boolean bool1 = false;
/*     */       ArrayList<BreadcrumbPoint> arrayList = new ArrayList();
/*     */       boolean bool2 = false, bool3 = false;
/*     */       List<BreadcrumbPoint> it = arrayList;
/*     */       int $i$a$-also-Trails$updatePoints$1 = 0;
/*     */       this.points.put(Integer.valueOf(entity.getEntityId()), it);
/*     */     } 
/*     */     arrayList.add(new BreadcrumbPoint(entity.getPosX(), entity.getEntityBoundingBox().getMinY(), entity.getPosZ(), System.currentTimeMillis(), getColor().getRGB()));
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onWorld(@NotNull WorldEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     this.points.clear();
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*     */     this.points.clear();
/*     */   }
/*     */   
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\000\n\000\n\002\020\006\n\002\b\003\n\002\020\t\n\000\n\002\020\b\n\002\b\n\030\0002\0020\001B-\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t¢\006\002\020\nR\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\013\020\fR\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\r\020\016R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\017\020\020R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\021\020\020R\021\020\005\032\0020\003¢\006\b\n\000\032\004\b\022\020\020¨\006\023"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Trails$BreadcrumbPoint;", "", "x", "", "y", "z", "time", "", "color", "", "(DDDJI)V", "getColor", "()I", "getTime", "()J", "getX", "()D", "getY", "getZ", "XSJClient"})
/*     */   public static final class BreadcrumbPoint {
/*     */     private final double x;
/*     */     private final double y;
/*     */     private final double z;
/*     */     private final long time;
/*     */     private final int color;
/*     */     
/*     */     public final double getX() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public final double getY() {
/*     */       return this.y;
/*     */     }
/*     */     
/*     */     public final double getZ() {
/*     */       return this.z;
/*     */     }
/*     */     
/*     */     public final long getTime() {
/*     */       return this.time;
/*     */     }
/*     */     
/*     */     public final int getColor() {
/*     */       return this.color;
/*     */     }
/*     */     
/*     */     public BreadcrumbPoint(double x, double y, double z, long time, int color) {
/*     */       this.x = x;
/*     */       this.y = y;
/*     */       this.z = z;
/*     */       this.time = time;
/*     */       this.color = color;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Trails.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */