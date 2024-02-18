/*     */ package net.ccbluex.liquidbounce.features.module.modules.player;
/*     */ import java.awt.Color;
/*     */ import java.util.LinkedList;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityOtherPlayerMP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.AColorPalette;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Breadcrumbs;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "Blink", description = "Fix By potatochips", category = ModuleCategory.PLAYER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\020\023\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\030\032\0020\031H\002J\b\020\032\032\0020\031H\026J\b\020\033\032\0020\031H\026J\020\020\034\032\0020\0312\006\020\035\032\0020\036H\007J\022\020\037\032\0020\0312\b\020\035\032\004\030\0010 H\007J\022\020!\032\0020\0312\b\020\035\032\004\030\0010\"H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\020\020\007\032\004\030\0010\bX\016¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\0130\nX\004¢\006\002\n\000R\024\020\f\032\b\022\004\022\0020\0160\rX\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\004X\004¢\006\002\n\000R\024\020\024\032\0020\0258VX\004¢\006\006\032\004\b\026\020\027¨\006#"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/player/Blink;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "cancelC0f", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "disableLogger", "", "fakePlayer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityOtherPlayerMP;", "packets", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;", "positions", "Ljava/util/LinkedList;", "", "pulseDelayValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "pulseTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "pulseValue", "tag", "", "getTag", "()Ljava/lang/String;", "blink", "", "onDisable", "onEnable", "onPacket", "event", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class Blink extends Module {
/*  34 */   private final LinkedBlockingQueue<IPacket> packets = new LinkedBlockingQueue<>();
/*     */   private IEntityOtherPlayerMP fakePlayer;
/*     */   private boolean disableLogger;
/*  37 */   private final LinkedList<double[]> positions = (LinkedList)new LinkedList<>();
/*  38 */   private final BoolValue pulseValue = new BoolValue("Pulse", false);
/*  39 */   private final IntegerValue pulseDelayValue = new IntegerValue("PulseDelay", 1000, 500, 5000);
/*  40 */   private final MSTimer pulseTimer = new MSTimer();
/*  41 */   private final BoolValue cancelC0f = new BoolValue("cancelC0f", true);
/*     */   
/*     */   public void onEnable() {
/*  44 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  46 */       if (!((Boolean)this.pulseValue.get()).booleanValue()) {
/*  47 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  IEntityOtherPlayerMP faker = MinecraftInstance.classProvider.createEntityOtherPlayerMP(MinecraftInstance.mc.getTheWorld(), thePlayer.getGameProfile());
/*     */ 
/*     */         
/*  50 */         faker.setRotationYawHead(thePlayer.getRotationYawHead());
/*  51 */         faker.setRenderYawOffset(thePlayer.getRenderYawOffset());
/*  52 */         faker.copyLocationAndAnglesFrom(thePlayer);
/*  53 */         faker.setRotationYawHead(thePlayer.getRotationYawHead());
/*  54 */         if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getTheWorld().addEntityToWorld(-1337, (IEntity)faker);
/*     */ 
/*     */         
/*  57 */         this.fakePlayer = faker;
/*     */       } 
/*  59 */       LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Blink$onEnable$1 = 0;
/*  60 */         this.positions.add(new double[] { thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY() + (thePlayer.getEyeHeight() / 2), thePlayer.getPosZ() });
/*  61 */         null = this.positions.add(new double[] { thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY(), thePlayer.getPosZ() }); /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/*     */       
/*  63 */       this.pulseTimer.reset();
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); } public void onDisable() {
/*  67 */     if (MinecraftInstance.mc.getThePlayer() == null) {
/*     */       return;
/*     */     }
/*  70 */     blink();
/*     */     
/*  72 */     IEntityOtherPlayerMP faker = this.fakePlayer;
/*     */     
/*  74 */     if (faker != null) {
/*  75 */       if (MinecraftInstance.mc.getTheWorld() != null) { MinecraftInstance.mc.getTheWorld().removeEntityFromWorld(faker.getEntityId()); } else { MinecraftInstance.mc.getTheWorld(); }
/*  76 */        this.fakePlayer = (IEntityOtherPlayerMP)null;
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*  82 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket packet = event.getPacket();
/*     */     
/*  84 */     if (MinecraftInstance.mc.getThePlayer() == null || this.disableLogger) {
/*     */       return;
/*     */     }
/*  87 */     if (MinecraftInstance.classProvider.isCPacketPlayer(packet)) {
/*  88 */       event.cancelEvent();
/*     */     }
/*  90 */     if (MinecraftInstance.classProvider.isCPacketPlayerPosition(packet) || MinecraftInstance.classProvider.isCPacketPlayerPosLook(packet) || 
/*  91 */       MinecraftInstance.classProvider.isCPacketPlayerBlockPlacement(packet) || 
/*  92 */       MinecraftInstance.classProvider.isCPacketAnimation(packet) || 
/*  93 */       MinecraftInstance.classProvider.isCPacketEntityAction(packet) || MinecraftInstance.classProvider.isCPacketUseEntity(packet)) {
/*  94 */       event.cancelEvent();
/*  95 */       this.packets.add(packet);
/*     */     } 
/*  97 */     if (MinecraftInstance.classProvider.isCPacketConfirmTransaction(packet) && ((Boolean)this.cancelC0f.get()).booleanValue()) {
/*  98 */       event.cancelEvent();
/*  99 */       this.packets.add(packet);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@Nullable UpdateEvent event) {
/* 106 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/* 108 */       LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Blink$onUpdate$1 = 0; null = this.positions.add(new double[] { thePlayer.getPosX(), thePlayer.getEntityBoundingBox().getMinY(), thePlayer.getPosZ() }); /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/* 109 */        if (((Boolean)this.pulseValue.get()).booleanValue() && this.pulseTimer.hasTimePassed(((Number)this.pulseDelayValue.get()).intValue())) {
/* 110 */         blink();
/* 111 */         this.pulseTimer.reset();
/*     */       } 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer(); }
/*     */   @EventTarget
/* 117 */   public final void onRender3D(@Nullable Render3DEvent event) { Breadcrumbs breadcrumbs = (Breadcrumbs)Retreat.INSTANCE.getModuleManager().getModule(Breadcrumbs.class);
/* 118 */     if (breadcrumbs == null) Intrinsics.throwNpe();  Color color = ((Boolean)breadcrumbs.getColorRainbow().get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/* 119 */     LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Blink$onRender3D$1 = 0;
/* 120 */       GL11.glPushMatrix();
/* 121 */       GL11.glDisable(3553);
/* 122 */       GL11.glBlendFunc(770, 771);
/* 123 */       GL11.glEnable(2848);
/* 124 */       GL11.glEnable(3042);
/* 125 */       GL11.glDisable(2929);
/* 126 */       MinecraftInstance.mc.getEntityRenderer().disableLightmap();
/* 127 */       GL11.glBegin(3);
/* 128 */       RenderUtils.glColor(color);
/* 129 */       double renderPosX = MinecraftInstance.mc.getRenderManager().getViewerPosX();
/* 130 */       double renderPosY = MinecraftInstance.mc.getRenderManager().getViewerPosY();
/* 131 */       double renderPosZ = MinecraftInstance.mc.getRenderManager().getViewerPosZ();
/* 132 */       for (double[] pos : this.positions) GL11.glVertex3d(pos[0] - renderPosX, pos[1] - renderPosY, pos[2] - renderPosZ); 
/* 133 */       GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
/* 134 */       GL11.glEnd();
/* 135 */       GL11.glEnable(2929);
/* 136 */       GL11.glDisable(2848);
/* 137 */       GL11.glDisable(3042);
/* 138 */       GL11.glEnable(3553);
/* 139 */       GL11.glPopMatrix();
/* 140 */       Unit unit = Unit.INSTANCE;
/*     */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/*     */      } @NotNull
/*     */   public String getTag() {
/* 144 */     return String.valueOf(this.packets.size());
/*     */   }
/*     */   private final void blink() {
/*     */     try {
/* 148 */       this.disableLogger = true;
/*     */       
/* 150 */       while (!this.packets.isEmpty()) {
/* 151 */         Intrinsics.checkExpressionValueIsNotNull(this.packets.take(), "packets.take()"); MinecraftInstance.mc.getNetHandler().getNetworkManager().sendPacket(this.packets.take());
/*     */       } 
/*     */       
/* 154 */       this.disableLogger = false;
/* 155 */     } catch (Exception e) {
/* 156 */       e.printStackTrace();
/* 157 */       this.disableLogger = false;
/*     */     } 
/* 159 */     LinkedList<double[]> linkedList = this.positions; boolean bool = false; synchronized (false) { int $i$a$-synchronized-Blink$blink$1 = 0; this.positions.clear(); Unit unit = Unit.INSTANCE;
/*     */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/LinkedList<ObjectType{D, dimension=1}>}, name=null} */ }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\player\Blink.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */