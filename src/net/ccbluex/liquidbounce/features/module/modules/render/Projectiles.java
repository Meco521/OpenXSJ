/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.enums.WDefaultVertexFormats;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.block.state.IIBlockState;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.multiplayer.IWorldClient;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.ITessellator;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.render.IWorldRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItem;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.Cylinder;
/*     */ 
/*     */ @ModuleInfo(name = "Projectiles", description = "Allows you to see where arrows will land.", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\007\n\000\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J \020\005\032\004\030\0010\0062\006\020\007\032\0020\0062\006\020\b\032\0020\0062\006\020\t\032\0020\nJ\020\020\013\032\0020\f2\006\020\r\032\0020\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/Projectiles;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "interpolateHSB", "Ljava/awt/Color;", "startColor", "endColor", "process", "", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "XSJClient"})
/*     */ public final class Projectiles extends Module {
/*  31 */   private final ListValue colorMode = new ListValue("Color", new String[] { "Custom", "BowPower", "Rainbow" }, "Custom");
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*  35 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*  36 */       if (MinecraftInstance.mc.getTheWorld() != null) { IWorldClient theWorld = MinecraftInstance.mc.getTheWorld();
/*     */         
/*  38 */         if (thePlayer.getHeldItem() != null) { IItemStack heldItem = thePlayer.getHeldItem();
/*     */           
/*  40 */           IItem item = heldItem.getItem();
/*  41 */           IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/*  42 */           boolean isBow = false;
/*  43 */           float motionFactor = 1.5F;
/*  44 */           float motionSlowdown = 0.99F;
/*  45 */           float gravity = 0.0F;
/*  46 */           float size = 0.0F;
/*     */ 
/*     */           
/*  49 */           if (MinecraftInstance.classProvider.isItemBow(item)) {
/*  50 */             if (!thePlayer.isUsingItem()) {
/*     */               return;
/*     */             }
/*  53 */             isBow = true;
/*  54 */             gravity = 0.05F;
/*  55 */             size = 0.3F;
/*     */ 
/*     */             
/*  58 */             float power = thePlayer.getItemInUseDuration() / 20.0F;
/*  59 */             power = (power * power + power * 2.0F) / 3.0F;
/*  60 */             if (power < 0.1F) {
/*     */               return;
/*     */             }
/*  63 */             if (power > 1.0F) {
/*  64 */               power = 1.0F;
/*     */             }
/*  66 */             motionFactor = power * 3.0F;
/*  67 */           } else if (MinecraftInstance.classProvider.isItemFishingRod(item)) {
/*  68 */             gravity = 0.04F;
/*  69 */             size = 0.25F;
/*  70 */             motionSlowdown = 0.92F;
/*  71 */           } else if (MinecraftInstance.classProvider.isItemPotion(item) && heldItem.isSplash()) {
/*  72 */             gravity = 0.05F;
/*  73 */             size = 0.25F;
/*  74 */             motionFactor = 0.5F;
/*     */           } else {
/*  76 */             if (!MinecraftInstance.classProvider.isItemSnowball(item) && !MinecraftInstance.classProvider.isItemEnderPearl(item) && !MinecraftInstance.classProvider.isItemEgg(item)) {
/*     */               return;
/*     */             }
/*  79 */             gravity = 0.03F;
/*  80 */             size = 0.25F;
/*     */           } 
/*     */ 
/*     */           
/*  84 */           float yaw = (RotationUtils.targetRotation != null) ? 
/*  85 */             RotationUtils.targetRotation.getYaw() : 
/*     */             
/*  87 */             thePlayer.getRotationYaw();
/*     */           
/*  89 */           float pitch = (RotationUtils.targetRotation != null) ? 
/*  90 */             RotationUtils.targetRotation.getPitch() : 
/*     */             
/*  92 */             thePlayer.getRotationPitch();
/*     */           
/*  94 */           float yawRadians = yaw / 180.0F * (float)Math.PI;
/*  95 */           float pitchRadians = pitch / 180.0F * (float)Math.PI;
/*     */ 
/*     */           
/*  98 */           double d2 = renderManager.getRenderPosX(); boolean bool1 = false; float f4 = (float)Math.cos(yawRadians); double posX = d2 - (f4 * 0.16F);
/*  99 */           double posY = renderManager.getRenderPosY() + thePlayer.getEyeHeight() - 0.10000000149011612D;
/* 100 */           d2 = renderManager.getRenderPosZ(); boolean bool2 = false; f4 = (float)Math.sin(yawRadians); double posZ = d2 - (f4 * 0.16F);
/*     */ 
/*     */           
/* 103 */           boolean bool3 = false; float f2 = -((float)Math.sin(yawRadians)); bool3 = false; float f3 = (float)Math.cos(pitchRadians); double motionX = (f2 * f3) * (
/* 104 */             isBow ? 1.0D : 0.4D);
/*     */ 
/*     */           
/* 107 */           float f1 = (pitch + ((MinecraftInstance.classProvider.isItemPotion(item) && heldItem.isSplash()) ? -20 : false)) / 180.0F * 3.1415927F; boolean bool4 = false; double motionY = -((float)Math.sin(f1)) * (isBow ? 1.0D : 0.4D);
/* 108 */           boolean bool5 = false; f2 = (float)Math.cos(yawRadians); bool5 = false; f3 = (float)Math.cos(pitchRadians); double motionZ = (f2 * f3) * (
/* 109 */             isBow ? 1.0D : 0.4D);
/* 110 */           double d1 = motionX * motionX + motionY * motionY + motionZ * motionZ; boolean bool6 = false; double distance = Math.sqrt(d1);
/*     */           
/* 112 */           motionX /= distance;
/* 113 */           motionY /= distance;
/* 114 */           motionZ /= distance;
/* 115 */           motionX *= motionFactor;
/* 116 */           motionY *= motionFactor;
/* 117 */           motionZ *= motionFactor;
/*     */ 
/*     */           
/* 120 */           IMovingObjectPosition landingPosition = (IMovingObjectPosition)null;
/* 121 */           boolean hasLanded = false;
/* 122 */           boolean hitEntity = false;
/*     */           
/* 124 */           ITessellator tessellator = MinecraftInstance.classProvider.getTessellatorInstance();
/* 125 */           IWorldRenderer worldRenderer = tessellator.getWorldRenderer();
/*     */ 
/*     */           
/* 128 */           GL11.glDepthMask(false);
/* 129 */           RenderUtils.enableGlCap(new int[] { 3042, 2848 });
/* 130 */           RenderUtils.disableGlCap(new int[] { 2929, 3008, 3553 });
/* 131 */           GL11.glBlendFunc(770, 771);
/* 132 */           GL11.glHint(3154, 4354);
/* 133 */           String str = (String)this.colorMode.get(); boolean bool7 = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */             
/*     */             case 973576630:
/* 140 */               if (str.equals("rainbow"))
/* 141 */                 RenderUtils.glColor(ColorUtils.rainbow());  break;
/*     */             case -1349088399: if (str.equals("custom"))
/*     */                 RenderUtils.glColor(new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue(), 255));  break;
/* 144 */             case -2055857797: if (str.equals("bowpower")) { Intrinsics.checkExpressionValueIsNotNull(Color.RED, "Color.RED"); Intrinsics.checkExpressionValueIsNotNull(Color.GREEN, "Color.GREEN"); RenderUtils.glColor(interpolateHSB(Color.RED, Color.GREEN, motionFactor / 30 * 10)); }  break; }  GL11.glLineWidth(2.0F);
/*     */           
/* 146 */           worldRenderer.begin(3, MinecraftInstance.classProvider.getVertexFormatEnum(WDefaultVertexFormats.POSITION));
/*     */           
/* 148 */           while (!hasLanded && posY > 0.0D) {
/*     */             
/* 150 */             WVec3 posBefore = new WVec3(posX, posY, posZ);
/* 151 */             WVec3 posAfter = new WVec3(posX + motionX, posY + motionY, posZ + motionZ);
/*     */ 
/*     */             
/* 154 */             landingPosition = theWorld.rayTraceBlocks(posBefore, posAfter, false, 
/* 155 */                 true, false);
/*     */ 
/*     */             
/* 158 */             posBefore = new WVec3(posX, posY, posZ);
/* 159 */             posAfter = new WVec3(posX + motionX, posY + motionY, posZ + motionZ);
/*     */ 
/*     */             
/* 162 */             if (landingPosition != null) {
/* 163 */               hasLanded = true;
/* 164 */               posAfter = new WVec3(landingPosition.getHitVec().getXCoord(), landingPosition.getHitVec().getYCoord(), landingPosition.getHitVec().getZCoord());
/*     */             } 
/*     */ 
/*     */             
/* 168 */             IAxisAlignedBB arrowBox = MinecraftInstance.classProvider.createAxisAlignedBB(posX - size, posY - size, posZ - size, posX + size, 
/* 169 */                 posY + size, posZ + size).addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D);
/*     */             
/* 171 */             double d3 = (arrowBox.getMinX() - 2.0D) / 16.0D; boolean bool8 = false; int chunkMinX = (int)Math.floor(d3);
/* 172 */             double d4 = (arrowBox.getMaxX() + 2.0D) / 16.0D; boolean bool9 = false; int chunkMaxX = (int)Math.floor(d4);
/* 173 */             double d5 = (arrowBox.getMinZ() - 2.0D) / 16.0D; int i = 0, chunkMinZ = (int)Math.floor(d5);
/* 174 */             double d6 = (arrowBox.getMaxZ() + 2.0D) / 16.0D; int j = 0, chunkMaxZ = (int)Math.floor(d6);
/*     */ 
/*     */             
/* 177 */             i = 0; List collidedEntities = new ArrayList();
/*     */             
/* 179 */             i = chunkMinX; j = chunkMaxX; if (i <= j)
/* 180 */               while (true) { int k = chunkMinZ, m = chunkMaxZ; if (k <= m)
/* 181 */                   while (true) { theWorld.getChunkFromChunkCoords(i, k)
/* 182 */                       .getEntitiesWithinAABBForEntity(thePlayer, arrowBox, collidedEntities, null); if (k != m) { k++; continue; }  break; }
/*     */                     if (i != j) { i++; continue; }
/*     */                  break; }
/* 185 */                 for (IEntity possibleEntity : collidedEntities) {
/* 186 */               if (possibleEntity.canBeCollidedWith() && (Intrinsics.areEqual(possibleEntity, thePlayer) ^ true) != 0) {
/* 187 */                 IAxisAlignedBB possibleEntityBoundingBox = possibleEntity.getEntityBoundingBox()
/* 188 */                   .expand(size, size, size);
/*     */                 
/* 190 */                 if (possibleEntityBoundingBox
/* 191 */                   .calculateIntercept(posBefore, posAfter) != null) { IMovingObjectPosition possibleEntityLanding = possibleEntityBoundingBox.calculateIntercept(posBefore, posAfter);
/*     */                   
/* 193 */                   hitEntity = true;
/* 194 */                   hasLanded = true;
/* 195 */                   landingPosition = possibleEntityLanding; continue; }
/*     */                 
/*     */                 possibleEntityBoundingBox.calculateIntercept(posBefore, posAfter);
/*     */               } 
/*     */             } 
/* 200 */             posX += motionX;
/* 201 */             posY += motionY;
/* 202 */             posZ += motionZ;
/*     */             
/* 204 */             IIBlockState blockState = theWorld.getBlockState(new WBlockPos(posX, posY, posZ));
/*     */ 
/*     */             
/* 207 */             if (Intrinsics.areEqual(blockState.getBlock().getMaterial(blockState), MinecraftInstance.classProvider.getMaterialEnum(MaterialType.WATER))) {
/*     */               
/* 209 */               motionX *= 0.6D;
/* 210 */               motionY *= 0.6D;
/* 211 */               motionZ *= 0.6D;
/*     */             } else {
/* 213 */               motionX *= motionSlowdown;
/* 214 */               motionY *= motionSlowdown;
/* 215 */               motionZ *= motionSlowdown;
/*     */             } 
/*     */             
/* 218 */             motionY -= gravity;
/*     */ 
/*     */             
/* 221 */             worldRenderer.pos(posX - renderManager.getRenderPosX(), posY - renderManager.getRenderPosY(), 
/* 222 */                 posZ - renderManager.getRenderPosZ()).endVertex();
/*     */           } 
/*     */ 
/*     */           
/* 226 */           tessellator.draw();
/* 227 */           GL11.glPushMatrix();
/* 228 */           GL11.glTranslated(posX - renderManager.getRenderPosX(), posY - renderManager.getRenderPosY(), 
/* 229 */               posZ - renderManager.getRenderPosZ());
/*     */           
/* 231 */           if (landingPosition != null) {
/*     */             
/* 233 */             if (landingPosition.getSideHit() == null) Intrinsics.throwNpe();  switch (landingPosition.getSideHit().getAxisOrdinal()) { case 0:
/* 234 */                 GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F); break;
/* 235 */               case 2: GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*     */                 break; }
/*     */ 
/*     */             
/* 239 */             if (hitEntity) {
/* 240 */               RenderUtils.glColor(new Color(255, 0, 0, 150));
/*     */             }
/*     */           } 
/*     */           
/* 244 */           GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/*     */           
/* 246 */           Cylinder cylinder = new Cylinder();
/* 247 */           cylinder.setDrawStyle(100011);
/* 248 */           cylinder.draw(0.2F, 0.0F, 0.0F, 60, 1);
/*     */           
/* 250 */           GL11.glPopMatrix();
/* 251 */           GL11.glDepthMask(true);
/* 252 */           RenderUtils.resetCaps();
/* 253 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); return; }
/*     */          thePlayer.getHeldItem(); return; }
/*     */        MinecraftInstance.mc.getTheWorld(); return; }
/*     */     
/* 257 */     MinecraftInstance.mc.getThePlayer(); } @Nullable public final Color interpolateHSB(@NotNull Color startColor, @NotNull Color endColor, float process) { Intrinsics.checkParameterIsNotNull(startColor, "startColor"); Intrinsics.checkParameterIsNotNull(endColor, "endColor"); float[] startHSB = Color.RGBtoHSB(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), null);
/* 258 */     float[] endHSB = Color.RGBtoHSB(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), null);
/*     */     
/* 260 */     float brightness = (startHSB[2] + endHSB[2]) / 2;
/* 261 */     float saturation = (startHSB[1] + endHSB[1]) / 2;
/*     */     
/* 263 */     float hueMax = (startHSB[0] > endHSB[0]) ? startHSB[0] : endHSB[0];
/* 264 */     float hueMin = (startHSB[0] > endHSB[0]) ? endHSB[0] : startHSB[0];
/*     */     
/* 266 */     float hue = (hueMax - hueMin) * process + hueMin;
/* 267 */     return Color.getHSBColor(hue, saturation, brightness); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\Projectiles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */