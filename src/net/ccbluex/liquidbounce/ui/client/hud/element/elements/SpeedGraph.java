/*    */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.ArrayList;
/*    */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.ranges.RangesKt;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*    */ import net.ccbluex.liquidbounce.ui.client.hud.element.Side;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.value.FloatValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @ElementInfo(name = "SpeedGraph")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000F\n\002\030\002\n\002\030\002\n\000\n\002\020\006\n\002\b\002\n\002\020\007\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\b\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B-\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b¢\006\002\020\tJ\b\020\030\032\0020\031H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\013X\004¢\006\002\n\000R\016\020\r\032\0020\013X\004¢\006\002\n\000R\016\020\016\032\0020\013X\004¢\006\002\n\000R\016\020\017\032\0020\020X\016¢\006\002\n\000R\036\020\021\032\022\022\004\022\0020\0030\022j\b\022\004\022\0020\003`\023X\004¢\006\002\n\000R\016\020\024\032\0020\025X\004¢\006\002\n\000R\016\020\026\032\0020\013X\004¢\006\002\n\000R\016\020\027\032\0020\025X\004¢\006\002\n\000¨\006\032"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/SpeedGraph;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "x", "", "y", "scale", "", "side", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Side;", "(DDFLnet/ccbluex/liquidbounce/ui/client/hud/element/Side;)V", "colorBlueValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "colorGreenValue", "colorRedValue", "height", "lastTick", "", "speedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "thickness", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "width", "yMultiplier", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "XSJClient"})
/*    */ public final class SpeedGraph extends Element {
/*    */   private final FloatValue yMultiplier;
/*    */   private final IntegerValue height;
/*    */   private final IntegerValue width;
/*    */   private final FloatValue thickness;
/*    */   private final IntegerValue colorRedValue;
/*    */   
/* 27 */   public SpeedGraph(double x, double y, float scale, @NotNull Side side) { super(x, y, scale, side);
/*    */     
/* 29 */     this.yMultiplier = new FloatValue("yMultiplier", 7.0F, 1.0F, 20.0F);
/* 30 */     this.height = new IntegerValue("Height", 50, 30, 150);
/* 31 */     this.width = new IntegerValue("Width", 150, 100, 300);
/* 32 */     this.thickness = new FloatValue("Thickness", 2.0F, 1.0F, 3.0F);
/* 33 */     this.colorRedValue = new IntegerValue("R", 0, 0, 255);
/* 34 */     this.colorGreenValue = new IntegerValue("G", 111, 0, 255);
/* 35 */     this.colorBlueValue = new IntegerValue("B", 255, 0, 255);
/*    */     
/* 37 */     this.speedList = new ArrayList<>();
/* 38 */     this.lastTick = -1; }
/*    */   private final IntegerValue colorGreenValue; private final IntegerValue colorBlueValue; private final ArrayList<Double> speedList; private int lastTick; public SpeedGraph() { this(0.0D, 0.0D, 0.0F, null, 15, null); } @NotNull
/*    */   public Border drawElement() {
/* 41 */     int width = ((Number)this.width.get()).intValue();
/* 42 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (this.lastTick != MinecraftInstance.mc.getThePlayer().getTicksExisted()) {
/* 43 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  this.lastTick = MinecraftInstance.mc.getThePlayer().getTicksExisted();
/* 44 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double z2 = MinecraftInstance.mc.getThePlayer().getPosZ();
/* 45 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double z1 = MinecraftInstance.mc.getThePlayer().getPrevPosZ();
/* 46 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double x2 = MinecraftInstance.mc.getThePlayer().getPosX();
/* 47 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double x1 = MinecraftInstance.mc.getThePlayer().getPrevPosX();
/* 48 */       double d1 = (z2 - z1) * (z2 - z1) + (x2 - x1) * (x2 - x1); boolean bool = false; double speed = Math.sqrt(d1);
/* 49 */       if (speed < false) {
/* 50 */         speed = -speed;
/*    */       }
/* 52 */       this.speedList.add(Double.valueOf(speed));
/* 53 */       while (this.speedList.size() > width) {
/* 54 */         this.speedList.remove(0);
/*    */       }
/*    */     } 
/* 57 */     GL11.glBlendFunc(770, 771);
/* 58 */     GL11.glEnable(3042);
/* 59 */     GL11.glEnable(2848);
/* 60 */     GL11.glLineWidth(((Number)this.thickness.get()).floatValue());
/* 61 */     GL11.glDisable(3553);
/* 62 */     GL11.glDisable(2929);
/* 63 */     GL11.glDepthMask(false);
/*    */     
/* 65 */     GL11.glBegin(1);
/*    */     
/* 67 */     int size = this.speedList.size();
/*    */     
/* 69 */     int start = (size > width) ? (size - width) : 0;
/* 70 */     for (int i = start, j = size - 1; i < j; i++) {
/* 71 */       double y = ((Number)this.speedList.get(i)).doubleValue() * 10 * ((Number)this.yMultiplier.get()).doubleValue();
/* 72 */       double y1 = ((Number)this.speedList.get(i + 1)).doubleValue() * 10 * ((Number)this.yMultiplier.get()).doubleValue();
/*    */       
/* 74 */       RenderUtils.glColor(new Color(((Number)this.colorRedValue.get()).intValue(), ((Number)this.colorGreenValue.get()).intValue(), ((Number)this.colorBlueValue.get()).intValue(), 255));
/* 75 */       GL11.glVertex2d(i - start, (((Number)this.height.get()).intValue() + 1) - RangesKt.coerceAtMost(y, ((Number)this.height.get()).intValue()));
/* 76 */       GL11.glVertex2d(i + 1.0D - start, (((Number)this.height.get()).intValue() + 1) - RangesKt.coerceAtMost(y1, ((Number)this.height.get()).intValue()));
/*    */     } 
/*    */     
/* 79 */     GL11.glEnd();
/*    */     
/* 81 */     GL11.glEnable(3553);
/* 82 */     GL11.glDisable(2848);
/* 83 */     GL11.glEnable(2929);
/* 84 */     GL11.glDepthMask(true);
/* 85 */     GL11.glDisable(3042);
/* 86 */     GlStateManager.func_179117_G();
/*    */     
/* 88 */     return new Border(0.0F, 0.0F, width, ((Number)this.height.get()).intValue() + 2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\SpeedGraph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */