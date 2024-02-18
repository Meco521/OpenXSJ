/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import java.awt.Color;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*    */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*    */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*    */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*    */ import net.ccbluex.liquidbounce.value.BlockValue;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @ModuleInfo(name = "BlockESP2", category = ModuleCategory.RENDER, description = "Skid")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000Z\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\022\020\032\032\0020\0332\b\020\034\032\004\030\0010\035H\007J\022\020\036\032\0020\0332\b\020\034\032\004\030\0010\037H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\024\020\016\032\b\022\004\022\0020\0200\017X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\024\020\024\032\0020\0258VX\004¢\006\006\032\004\b\026\020\027R\020\020\030\032\004\030\0010\031X\016¢\006\002\n\000¨\006 "}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/BlockESP2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "blockLimitValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "blockValue", "Lnet/ccbluex/liquidbounce/value/BlockValue;", "colorBlueValue", "colorGreenValue", "colorRainbow", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "colorRedValue", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "posList", "", "Lnet/ccbluex/liquidbounce/api/minecraft/util/WBlockPos;", "radiusValue", "searchTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "tag", "", "getTag", "()Ljava/lang/String;", "thread", "Ljava/lang/Thread;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class BlockESP2 extends Module {
/* 31 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "Box", "2D" }, "Box");
/* 32 */   private final BlockValue blockValue = new BlockValue("Block", 168);
/* 33 */   private final IntegerValue radiusValue = new IntegerValue("Radius", 40, 5, 120);
/* 34 */   private final IntegerValue blockLimitValue = new IntegerValue("BlockLimit", 256, 0, 2056);
/* 35 */   private final IntegerValue colorRedValue = new IntegerValue("R", 255, 0, 255);
/* 36 */   private final IntegerValue colorGreenValue = new IntegerValue("G", 179, 0, 255);
/* 37 */   private final IntegerValue colorBlueValue = new IntegerValue("B", 72, 0, 255);
/* 38 */   private final BoolValue colorRainbow = new BoolValue("Rainbow", false);
/* 39 */   private final MSTimer searchTimer = new MSTimer();
/* 40 */   private final List<WBlockPos> posList = new ArrayList<>();
/*    */   private Thread thread;
/*    */   
/*    */   @EventTarget
/*    */   public final void onUpdate(@Nullable UpdateEvent event) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield searchTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*    */     //   4: ldc2_w 1000
/*    */     //   7: invokevirtual hasTimePassed : (J)Z
/*    */     //   10: ifeq -> 136
/*    */     //   13: aload_0
/*    */     //   14: getfield thread : Ljava/lang/Thread;
/*    */     //   17: ifnull -> 37
/*    */     //   20: aload_0
/*    */     //   21: getfield thread : Ljava/lang/Thread;
/*    */     //   24: dup
/*    */     //   25: ifnonnull -> 31
/*    */     //   28: invokestatic throwNpe : ()V
/*    */     //   31: invokevirtual isAlive : ()Z
/*    */     //   34: ifne -> 136
/*    */     //   37: aload_0
/*    */     //   38: getfield radiusValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*    */     //   41: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   44: checkcast java/lang/Number
/*    */     //   47: invokevirtual intValue : ()I
/*    */     //   50: istore_2
/*    */     //   51: invokestatic access$getFunctions$p$s1046033730 : ()Lnet/ccbluex/liquidbounce/api/IExtractedFunctions;
/*    */     //   54: aload_0
/*    */     //   55: getfield blockValue : Lnet/ccbluex/liquidbounce/value/BlockValue;
/*    */     //   58: invokevirtual get : ()Ljava/lang/Object;
/*    */     //   61: checkcast java/lang/Number
/*    */     //   64: invokevirtual intValue : ()I
/*    */     //   67: invokeinterface getBlockById : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*    */     //   72: astore_3
/*    */     //   73: aload_3
/*    */     //   74: ifnull -> 95
/*    */     //   77: aload_3
/*    */     //   78: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*    */     //   81: getstatic net/ccbluex/liquidbounce/api/enums/BlockType.AIR : Lnet/ccbluex/liquidbounce/api/enums/BlockType;
/*    */     //   84: invokeinterface getBlockEnum : (Lnet/ccbluex/liquidbounce/api/enums/BlockType;)Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*    */     //   89: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   92: ifeq -> 96
/*    */     //   95: return
/*    */     //   96: aload_0
/*    */     //   97: new java/lang/Thread
/*    */     //   100: dup
/*    */     //   101: new net/ccbluex/liquidbounce/features/module/modules/render/BlockESP2$onUpdate$1
/*    */     //   104: dup
/*    */     //   105: aload_0
/*    */     //   106: iload_2
/*    */     //   107: aload_3
/*    */     //   108: invokespecial <init> : (Lnet/ccbluex/liquidbounce/features/module/modules/render/BlockESP2;ILnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)V
/*    */     //   111: checkcast java/lang/Runnable
/*    */     //   114: ldc 'BlockESP-BlockFinder'
/*    */     //   116: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/String;)V
/*    */     //   119: putfield thread : Ljava/lang/Thread;
/*    */     //   122: aload_0
/*    */     //   123: getfield thread : Ljava/lang/Thread;
/*    */     //   126: dup
/*    */     //   127: ifnonnull -> 133
/*    */     //   130: invokestatic throwNpe : ()V
/*    */     //   133: invokevirtual start : ()V
/*    */     //   136: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #45	-> 0
/*    */     //   #46	-> 37
/*    */     //   #47	-> 51
/*    */     //   #49	-> 73
/*    */     //   #50	-> 95
/*    */     //   #52	-> 96
/*    */     //   #77	-> 114
/*    */     //   #52	-> 116
/*    */     //   #79	-> 122
/*    */     //   #81	-> 136
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   73	63	3	selectedBlock	Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;
/*    */     //   51	85	2	radius	I
/*    */     //   0	137	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/BlockESP2;
/*    */     //   0	137	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
/*    */   }
/*    */   
/*    */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"})
/*    */   static final class BlockESP2$onUpdate$1
/*    */     implements Runnable
/*    */   {
/*    */     public final void run() {
/* 53 */       List<WBlockPos> blockList = new ArrayList();
/*    */       int j;
/* 55 */       for (int i = -this.$radius; i < j; i++) {
/* 56 */         int k = this.$radius, m = -this.$radius + 1; if (k >= m)
/* 57 */           while (true) { for (int n = -this.$radius, i1 = this.$radius; n < i1; n++) {
/* 58 */               if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*    */               
/* 60 */               int xPos = (int)thePlayer.getPosX() + i;
/* 61 */               int yPos = (int)thePlayer.getPosY() + k;
/* 62 */               int zPos = (int)thePlayer.getPosZ() + n;
/*    */               
/* 64 */               WBlockPos blockPos = new WBlockPos(xPos, yPos, zPos);
/* 65 */               IBlock block = BlockUtils.getBlock(blockPos);
/*    */               
/* 67 */               if (Intrinsics.areEqual(block, this.$selectedBlock) && blockList.size() < ((Number)BlockESP2.this.blockLimitValue.get()).intValue()) blockList.add(blockPos); 
/*    */             }  if (k != m) { k--; continue; }
/*    */              break; }
/*    */            
/* 71 */       }  BlockESP2.this.searchTimer.reset();
/*    */       
/* 73 */       List list = BlockESP2.this.posList; j = 0; synchronized (false) { int $i$a$-synchronized-BlockESP2$onUpdate$1$1 = 0;
/* 74 */         BlockESP2.this.posList.clear();
/* 75 */         boolean bool = BlockESP2.this.posList.addAll(blockList);
/*    */         /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/List}, name=null} */ }
/*    */     
/*    */     }
/*    */     
/*    */     BlockESP2$onUpdate$1(int param1Int, IBlock param1IBlock) {}
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public final void onRender3D(@Nullable Render3DEvent event) {
/* 85 */     List<WBlockPos> list = this.posList; boolean bool = false; synchronized (false) { int $i$a$-synchronized-BlockESP2$onRender3D$1 = 0;
/* 86 */       Color color = ((Boolean)this.colorRainbow.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/* 87 */       for (WBlockPos blockPos : this.posList)
/* 88 */       { String str = (String)this.modeValue.get(); boolean bool1 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*    */         { case 1650:
/* 90 */             if (str.equals("2d")) { Intrinsics.checkExpressionValueIsNotNull(Color.BLACK, "Color.BLACK"); RenderUtils.draw2D(blockPos, color.getRGB(), Color.BLACK.getRGB()); } 
/*    */           case 97739:
/*    */             if (str.equals("box"))
/* 93 */               RenderUtils.drawBlockBox(blockPos, color, true);  }  }  Unit unit = Unit.INSTANCE;
/*    */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/List<ObjectType{net/ccbluex/liquidbounce/api/minecraft/util/WBlockPos}>}, name=null} */ }
/*    */      } @NotNull
/*    */   public String getTag() {
/* 97 */     return BlockUtils.getBlockName(((Number)this.blockValue.get()).intValue());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\BlockESP2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */