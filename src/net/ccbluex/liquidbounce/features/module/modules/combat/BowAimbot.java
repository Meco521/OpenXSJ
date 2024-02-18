/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ import java.awt.Color;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "BowAimbot", description = "Automatically aims at players when using a bow.", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\020\016\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\032\020\016\032\004\030\0010\f2\006\020\017\032\0020\0202\006\020\021\032\0020\022H\002J\006\020\023\032\0020\020J\b\020\024\032\0020\025H\026J\020\020\026\032\0020\0252\006\020\027\032\0020\030H\007J\020\020\031\032\0020\0252\006\020\027\032\0020\032H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\020\020\013\032\004\030\0010\fX\016¢\006\002\n\000R\016\020\r\032\0020\004X\004¢\006\002\n\000¨\006\033"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/BowAimbot;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "markValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "predictSizeValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "predictValue", "priorityValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "silentValue", "target", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "throughWallsValue", "getTarget", "throughWalls", "", "priorityMode", "", "hasTarget", "onDisable", "", "onRender3D", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class BowAimbot extends Module {
/*  21 */   private final BoolValue silentValue = new BoolValue("Silent", true);
/*  22 */   private final BoolValue predictValue = new BoolValue("Predict", true);
/*  23 */   private final BoolValue throughWallsValue = new BoolValue("ThroughWalls", false);
/*  24 */   private final FloatValue predictSizeValue = new FloatValue("PredictSize", 2.0F, 0.1F, 5.0F);
/*  25 */   private final ListValue priorityValue = new ListValue("Priority", new String[] { "Health", "Distance", "Direction" }, "Direction");
/*  26 */   private final BoolValue markValue = new BoolValue("Mark", true);
/*     */   
/*     */   private IEntity target;
/*     */   
/*     */   public void onDisable() {
/*  31 */     this.target = (IEntity)null;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  36 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.target = (IEntity)null;
/*     */     
/*  38 */     MinecraftInstance.mc.getThePlayer().getItemInUse(); if (MinecraftInstance.classProvider.isItemBow((MinecraftInstance.mc.getThePlayer() != null && MinecraftInstance.mc.getThePlayer().getItemInUse() != null) ? MinecraftInstance.mc.getThePlayer().getItemInUse().getItem() : null)) {
/*  39 */       if (getTarget(((Boolean)this.throughWallsValue.get()).booleanValue(), (String)this.priorityValue.get()) != null) { IEntity entity = getTarget(((Boolean)this.throughWallsValue.get()).booleanValue(), (String)this.priorityValue.get());
/*     */         
/*  41 */         this.target = entity;
/*  42 */         RotationUtils.faceBow(this.target, ((Boolean)this.silentValue.get()).booleanValue(), ((Boolean)this.predictValue.get()).booleanValue(), ((Number)this.predictSizeValue.get()).floatValue());
/*     */         return; }
/*     */       
/*     */       getTarget(((Boolean)this.throughWallsValue.get()).booleanValue(), (String)this.priorityValue.get());
/*     */       return;
/*     */     }  } @EventTarget
/*  48 */   public final void onRender3D(@NotNull Render3DEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); if (this.target != null && !StringsKt.equals((String)this.priorityValue.get(), "Multi", true) && ((Boolean)this.markValue.get()).booleanValue())
/*  49 */       RenderUtils.drawPlatform(this.target, new Color(37, 126, 255, 70));  }
/*     */ 
/*     */   
/*     */   private final IEntity getTarget(boolean throughWalls, String priorityMode) {
/*  53 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  Iterable $this$filter$iv = MinecraftInstance.mc.getTheWorld().getLoadedEntityList(); int $i$f$filter = 0;
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
/*  68 */     Iterable iterable1 = $this$filter$iv; Collection destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/*  69 */     for (Object element$iv$iv : iterable1) { IEntity it = (IEntity)element$iv$iv; int $i$a$-filter-BowAimbot$getTarget$targets$1 = 0; }
/*  70 */      List targets = (List)destination$iv$iv; String str = priorityMode; $i$f$filter = 0; if (str == null)
/*  71 */       throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toUpperCase(), "(this as java.lang.String).toUpperCase()"); str = str.toUpperCase(); switch (str.hashCode()) { case 1071086581: if (str.equals("DISTANCE")) { Iterable $this$minBy$iv = targets; int $i$f$minBy = 0; Iterator iterator$iv = $this$minBy$iv.iterator();
/*     */           
/*  73 */           Object minElem$iv = iterator$iv.next();
/*  74 */           if (!iterator$iv.hasNext()) {  }
/*  75 */           else { IEntity it = (IEntity)minElem$iv; int $i$a$-minBy-BowAimbot$getTarget$1 = 0; if (MinecraftInstance.mc.getThePlayer() == null)
/*     */               Intrinsics.throwNpe();  }
/*     */            }
/*     */         else
/*     */         { break; }
/*     */       
/*     */       case 1824003935:
/*     */         if (str.equals("DIRECTION")) {
/*     */           Iterable $this$minBy$iv = targets;
/*     */           int $i$f$minBy = 0;
/*  85 */           Iterator iterator$iv = $this$minBy$iv.iterator();
/*     */           
/*  87 */           Object minElem$iv = iterator$iv.next();
/*  88 */           if (!iterator$iv.hasNext()) {  }
/*  89 */           else { IEntity it = (IEntity)minElem$iv; int $i$a$-minBy-BowAimbot$getTarget$2 = 0;
/*     */             double minValue$iv = RotationUtils.getRotationDifference(it); }
/*     */         
/*     */         } else {
/*     */           break;
/*     */         } 
/*     */       case 2127033948:
/*     */         if (str.equals("HEALTH")) {
/*     */           Iterable $this$minBy$iv = targets;
/*     */           int $i$f$minBy = 0;
/*  99 */           Iterator iterator$iv = $this$minBy$iv.iterator();
/*     */           
/* 101 */           Object minElem$iv = iterator$iv.next();
/* 102 */           if (!iterator$iv.hasNext()) {  }
/* 103 */           else { IEntity it = (IEntity)minElem$iv; int $i$a$-minBy-BowAimbot$getTarget$3 = 0;
/*     */             float minValue$iv = it.asEntityLivingBase().getHealth(); }
/*     */         
/*     */         } else {
/*     */           break;
/*     */         }  }
/*     */     
/*     */     return null;
/*     */   }
/*     */   
/*     */   public final boolean hasTarget() {
/*     */     if (this.target != null) {
/*     */       if (MinecraftInstance.mc.getThePlayer() == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (this.target == null)
/*     */         Intrinsics.throwNpe(); 
/*     */       if (MinecraftInstance.mc.getThePlayer().canEntityBeSeen(this.target));
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\BowAimbot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */