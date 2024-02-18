/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import kotlin.Unit;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "ProphuntESP", description = "Allows you to see disguised players in PropHunt.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020%\n\002\030\002\n\002\020\t\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\017\032\0020\020H\026J\022\020\021\032\0020\0202\b\020\022\032\004\030\0010\023H\007R\035\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004¢\006\b\n\000\032\004\b\007\020\bR\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\nX\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\nX\004¢\006\002\n\000¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ProphuntESP;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "blocks", "", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "", "getBlocks", "()Ljava/util/Map;", "colorBlueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorGreenValue", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "colorRedValue", "onDisable", "", "onRender3D", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*    */ public final class ProphuntESP extends Module {
/*    */   @NotNull
/* 18 */   private final Map<WBlockPos, Long> blocks = new HashMap<>(); @NotNull public final Map<WBlockPos, Long> getBlocks() { return this.blocks; }
/*    */   
/* 20 */   private final IntegerValue colorRedValue = new IntegerValue("R", 0, 0, 255);
/* 21 */   private final IntegerValue colorGreenValue = new IntegerValue("G", 90, 0, 255);
/* 22 */   private final IntegerValue colorBlueValue = new IntegerValue("B", 255, 0, 255);
/* 23 */   private final BoolValue colorRainbow = new BoolValue("Rainbow", false);
/*    */   
/*    */   public void onDisable() {
/* 26 */     Map<WBlockPos, Long> map = this.blocks; boolean bool = false; synchronized (false) { int $i$a$-synchronized-ProphuntESP$onDisable$1 = 0; this.blocks.clear(); Unit unit = Unit.INSTANCE;
/*    */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Map<[ObjectType{net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos}, ObjectType{java/lang/Long}]>}, name=null} */ }
/*    */   
/*    */   } @EventTarget
/*    */   public final void onRender3D(@Nullable Render3DEvent event) {
/* 31 */     Color color = ((Boolean)this.colorRainbow.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue());
/* 32 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 33 */       if (!MinecraftInstance.classProvider.isEntityFallingBlock(Boolean.valueOf(MinecraftInstance.classProvider.isEntityFallingBlock(entity)))) {
/*    */         continue;
/*    */       }
/* 36 */       RenderUtils.drawEntityBox(entity, color, true);
/*    */     } 
/* 38 */     Map<WBlockPos, Long> map = this.blocks; boolean bool = false; synchronized (false) { int $i$a$-synchronized-ProphuntESP$onRender3D$1 = 0;
/* 39 */       Iterator<Map.Entry> iterator = this.blocks.entrySet().iterator();
/*    */       
/* 41 */       while (iterator.hasNext()) {
/* 42 */         Map.Entry entry = iterator.next();
/*    */         
/* 44 */         if (System.currentTimeMillis() - ((Number)entry.getValue()).longValue() > 2000L) {
/* 45 */           iterator.remove();
/*    */           
/*    */           continue;
/*    */         } 
/* 49 */         RenderUtils.drawBlockBox((WBlockPos)entry.getKey(), color, true);
/*    */       } 
/* 51 */       Unit unit = Unit.INSTANCE;
/*    */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Map<[ObjectType{net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos}, ObjectType{java/lang/Long}]>}, name=null} */ }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ProphuntESP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */