/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.JvmField;
/*     */ import kotlin.jvm.internal.DefaultConstructorMarker;
/*     */ import kotlin.jvm.internal.FloatCompanionObject;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.IEntityPlayer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemArmor;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IAxisAlignedBB;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.misc.Teams;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.WorldToScreen;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.vector.Matrix4f;
/*     */ import org.lwjgl.util.vector.Vector2f;
/*     */ import org.lwjgl.util.vector.Vector3f;
/*     */ 
/*     */ @ModuleInfo(name = "ESP2", description = "ESP2 skid by 凡哥", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000b\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\b\r\n\002\020\016\n\002\b\007\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\b\007\030\000 42\0020\001:\0014B\005¢\006\002\020\002J\006\020#\032\0020$J\016\020%\032\0020&2\006\020'\032\0020(J\016\020)\032\0020*2\006\020'\032\0020+J\020\020,\032\0020$2\006\020-\032\0020.H\007J\020\020/\032\0020$2\006\020-\032\00200H\007J\020\0201\032\0020$2\006\020-\032\00202H\007J\022\0203\032\0020$2\b\020-\032\004\030\00100H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\016\020\n\032\0020\006X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\021\020\017\032\0020\006¢\006\b\n\000\032\004\b\020\020\021R\021\020\022\032\0020\004¢\006\b\n\000\032\004\b\023\020\024R\020\020\025\032\0020\f8\006X\004¢\006\002\n\000R\016\020\026\032\0020\fX\004¢\006\002\n\000R\021\020\027\032\0020\004¢\006\b\n\000\032\004\b\030\020\024R\016\020\031\032\0020\fX\004¢\006\002\n\000R\016\020\032\032\0020\fX\004¢\006\002\n\000R\024\020\033\032\0020\0348VX\004¢\006\006\032\004\b\035\020\036R\020\020\037\032\0020\f8\006X\004¢\006\002\n\000R\021\020 \032\0020\f¢\006\b\n\000\032\004\b!\020\"¨\0065"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "colorRainbowValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "csgoDirectLineValue", "csgoShowHealthValue", "csgoShowHeldItemValue", "csgoShowNameValue", "csgoWidthValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "decimalFormat", "Ljava/text/DecimalFormat;", "invisible", "getInvisible", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "modeValue", "getModeValue", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "outlineWidth", "outlineWidthValue", "portraitValue", "getPortraitValue", "shaderGlowRadiusValue", "shaderOutlineRadiusValue", "tag", "", "getTag", "()Ljava/lang/String;", "wireframeWidth", "wireframeWidthValue", "getWireframeWidthValue", "()Lnet/ccbluex/liquidbounce/value/FloatValue;", "doWireFrame", "", "getColor", "Ljava/awt/Color;", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;", "isValid", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "onRender2D", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "onRender3D", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "uppro", "Companion", "XSJClient"})
/*     */ public final class ESP2 extends Module {
/*     */   @NotNull
/*  41 */   private final ListValue modeValue = new ListValue(
/*  42 */       "Mode", 
/*  43 */       new String[] { "Box", "OtherBox", "WireFrame", "2D", "Real2D", "CSGO", "CSGO-Old", "Outline", "ShaderOutline", "ShaderGlow", "Jello", "Frame"
/*  44 */       }, "CSGO");
/*     */   @NotNull public final ListValue getModeValue() { return this.modeValue; } @NotNull
/*  46 */   private final ListValue portraitValue = new ListValue("Datou", new String[] { "none", "cxk", "yaoer", "caoxiaolong", "yuzhiwen", "xiaomayun", "daliwang", "menjiang", "xionger", "kaka", "dinzheng", "wangyuan" }, "none"); @NotNull public final ListValue getPortraitValue() { return this.portraitValue; }
/*  47 */    private final FloatValue outlineWidthValue = new FloatValue("Outline-Width", 3.0F, 0.5F, 5.0F); @NotNull
/*  48 */   private final FloatValue wireframeWidthValue = new FloatValue("WireFrame-Width", 2.0F, 0.5F, 5.0F); @NotNull public final FloatValue getWireframeWidthValue() { return this.wireframeWidthValue; }
/*  49 */    private final FloatValue shaderOutlineRadiusValue = new FloatValue("ShaderOutline-Radius", 1.35F, 1.0F, 2.0F);
/*  50 */   private final FloatValue shaderGlowRadiusValue = new FloatValue("ShaderGlow-Radius", 2.3F, 2.0F, 3.0F);
/*  51 */   private final BoolValue csgoDirectLineValue = new BoolValue("CSGO-DirectLine", false);
/*  52 */   private final BoolValue csgoShowHealthValue = new BoolValue("CSGO-ShowHealth", true);
/*  53 */   private final BoolValue csgoShowHeldItemValue = new BoolValue("CSGO-ShowHeldItem", true);
/*  54 */   private final BoolValue csgoShowNameValue = new BoolValue("CSGO-ShowName", true);
/*  55 */   private final FloatValue csgoWidthValue = new FloatValue("CSGOOld-Width", 2.0F, 0.5F, 5.0F);
/*  56 */   private final ListValue colorModeValue = new ListValue("ColorMode", new String[] { "Name", "Armor", "OFF" }, "Name");
/*  57 */   private final BoolValue colorRainbowValue = new BoolValue("Rainbow", false); @NotNull
/*  58 */   private final BoolValue invisible = new BoolValue("Invisible", false); @NotNull public final BoolValue getInvisible() { return this.invisible; }
/*     */   
/*  60 */   private final DecimalFormat decimalFormat = new DecimalFormat("0.0"); @JvmField
/*     */   @NotNull
/*  62 */   public final FloatValue outlineWidth = new FloatValue("Outline-Width", 3.0F, 0.5F, 5.0F);
/*     */   @JvmField
/*     */   @NotNull
/*  65 */   public final FloatValue wireframeWidth = new FloatValue("WireFrame-Width", 2.0F, 0.5F, 5.0F);
/*     */   @JvmField
/*     */   public static boolean renderNameTags; @EventTarget
/*  68 */   public final void uppro(@Nullable Render3DEvent event) { String mode = (String)this.portraitValue.get();
/*  69 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/*  70 */       if ((Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0 && EntityUtils.isSelected(entity, false)) {
/*  71 */         IEntityLivingBase entityLiving = entity.asEntityLivingBase();
/*  72 */         String str = mode; boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
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
/*     */           case 482449569:
/* 209 */             if (str.equals("yuzhiwen"))
/* 210 */             { double pX = 
/* 211 */                 entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 212 */                 MinecraftInstance.mc.getRenderManager().getRenderPosX();
/* 213 */               double pY = 
/* 214 */                 entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 215 */                 MinecraftInstance.mc.getRenderManager().getRenderPosY();
/* 216 */               double pZ = 
/* 217 */                 entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 218 */                 MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*     */               
/* 220 */               GL11.glPushMatrix();
/* 221 */               GL11.glTranslatef(
/* 222 */                   (float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), 
/* 223 */                   (float)pZ);
/*     */               
/* 225 */               GL11.glNormal3f(1.0F, 1.0F, 1.0F);
/* 226 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 227 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 228 */               float scale = 0.06F;
/* 229 */               GL11.glScalef(-scale, -scale, scale);
/*     */               
/* 231 */               GL11.glDisable(2896);
/* 232 */               GL11.glDisable(2929);
/* 233 */               GL11.glEnable(3042);
/* 234 */               GL11.glBlendFunc(770, 771);
/*     */               
/* 236 */               GL11.glPushMatrix();
/* 237 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               
/* 239 */               RenderUtils.drawImage2("tomk/esp/yzw.png", -8, -14, 16, 16);
/* 240 */               GL11.glPopMatrix();
/* 241 */               GL11.glPopMatrix(); } 
/*     */           case 1568445373:
/* 243 */             if (str.equals("daliwang"))
/* 244 */             { double pX = 
/* 245 */                 entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 246 */                 MinecraftInstance.mc.getRenderManager().getRenderPosX();
/* 247 */               double pY = 
/* 248 */                 entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 249 */                 MinecraftInstance.mc.getRenderManager().getRenderPosY();
/* 250 */               double pZ = 
/* 251 */                 entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 252 */                 MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*     */               
/* 254 */               GL11.glPushMatrix();
/* 255 */               GL11.glTranslatef(
/* 256 */                   (float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), 
/* 257 */                   (float)pZ);
/*     */               
/* 259 */               GL11.glNormal3f(1.0F, 1.0F, 1.0F);
/* 260 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 261 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 262 */               float scale = 0.06F;
/* 263 */               GL11.glScalef(-scale, -scale, scale);
/*     */               
/* 265 */               GL11.glDisable(2896);
/* 266 */               GL11.glDisable(2929);
/* 267 */               GL11.glEnable(3042);
/* 268 */               GL11.glBlendFunc(770, 771);
/*     */               
/* 270 */               GL11.glPushMatrix();
/* 271 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               
/* 273 */               RenderUtils.drawImage2("tomk/esp/daliwang.png", -8, -14, 16, 16);
/* 274 */               GL11.glPopMatrix();
/* 275 */               GL11.glPopMatrix(); } 
/*     */           case 114745684: if (str.equals("yaoer")) { double pX = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX(); double pY = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY(); double pZ = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ(); GL11.glPushMatrix(); GL11.glTranslatef((float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), (float)pZ); GL11.glNormal3f(1.0F, 1.0F, 1.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F); float scale = 0.06F; GL11.glScalef(-scale, -scale, scale); GL11.glDisable(2896); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glPushMatrix(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawImage2("tomk/esp/yaoer.png", -8, -14, 16, 16); GL11.glPopMatrix(); GL11.glPopMatrix(); } 
/* 277 */           case -613318619: if (str.equals("menjiang")) {
/* 278 */               double pX = 
/* 279 */                 entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 280 */                 MinecraftInstance.mc.getRenderManager().getRenderPosX();
/* 281 */               double pY = 
/* 282 */                 entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 283 */                 MinecraftInstance.mc.getRenderManager().getRenderPosY();
/* 284 */               double pZ = 
/* 285 */                 entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 286 */                 MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*     */               
/* 288 */               GL11.glPushMatrix();
/* 289 */               GL11.glTranslatef(
/* 290 */                   (float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), 
/* 291 */                   (float)pZ);
/*     */               
/* 293 */               GL11.glNormal3f(1.0F, 1.0F, 1.0F);
/* 294 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 295 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 296 */               float scale = 0.06F;
/* 297 */               GL11.glScalef(-scale, -scale, scale);
/*     */               
/* 299 */               GL11.glDisable(2896);
/* 300 */               GL11.glDisable(2929);
/* 301 */               GL11.glEnable(3042);
/* 302 */               GL11.glBlendFunc(770, 771);
/*     */               
/* 304 */               GL11.glPushMatrix();
/* 305 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               
/* 307 */               RenderUtils.drawImage2("tomk/esp/menjiang.png", -8, -14, 16, 16);
/* 308 */               GL11.glPopMatrix();
/* 309 */               GL11.glPopMatrix();
/*     */             } 
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
/*     */           case 98966:
/*     */             if (str.equals("cxk")) {
/*     */               double pX = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX();
/*     */               double pY = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY();
/*     */               double pZ = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*     */               GL11.glPushMatrix();
/*     */               GL11.glTranslatef((float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), (float)pZ);
/*     */               GL11.glNormal3f(1.0F, 1.0F, 1.0F);
/*     */               MinecraftInstance.mc2.func_175598_ae();
/*     */               GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/*     */               MinecraftInstance.mc2.func_175598_ae();
/*     */               GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/*     */               float scale = 0.06F;
/*     */               GL11.glScalef(-scale, -scale, scale);
/*     */               GL11.glDisable(2896);
/*     */               GL11.glDisable(2929);
/*     */               GL11.glEnable(3042);
/*     */               GL11.glBlendFunc(770, 771);
/*     */               GL11.glPushMatrix();
/*     */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               RenderUtils.drawImage2("tomk/esp/cxk.png", -8, -14, 16, 16);
/*     */               GL11.glPopMatrix();
/*     */               GL11.glPopMatrix();
/*     */             } 
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
/*     */           case 151055367:
/* 379 */             if (str.equals("dinzheng"))
/* 380 */             { double pX = 
/* 381 */                 entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 382 */                 MinecraftInstance.mc.getRenderManager().getRenderPosX();
/* 383 */               double pY = 
/* 384 */                 entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 385 */                 MinecraftInstance.mc.getRenderManager().getRenderPosY();
/* 386 */               double pZ = 
/* 387 */                 entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 388 */                 MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*     */               
/* 390 */               GL11.glPushMatrix();
/* 391 */               GL11.glTranslatef(
/* 392 */                   (float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), 
/* 393 */                   (float)pZ);
/*     */               
/* 395 */               GL11.glNormal3f(1.0F, 1.0F, 1.0F);
/* 396 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 397 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 398 */               float scale = 0.06F;
/* 399 */               GL11.glScalef(-scale, -scale, scale);
/*     */               
/* 401 */               GL11.glDisable(2896);
/* 402 */               GL11.glDisable(2929);
/* 403 */               GL11.glEnable(3042);
/* 404 */               GL11.glBlendFunc(770, 771);
/*     */               
/* 406 */               GL11.glPushMatrix();
/* 407 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               
/* 409 */               RenderUtils.drawImage2("tomk/esp/dinzheng.png", -8, -14, 16, 16);
/* 410 */               GL11.glPopMatrix();
/* 411 */               GL11.glPopMatrix(); } case -364658881: if (str.equals("xiaomayun")) { double pX = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX(); double pY = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY(); double pZ = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ(); GL11.glPushMatrix(); GL11.glTranslatef((float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), (float)pZ); GL11.glNormal3f(1.0F, 1.0F, 1.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F); float scale = 0.06F; GL11.glScalef(-scale, -scale, scale); GL11.glDisable(2896); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glPushMatrix(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawImage2("tomk/esp/xiaomayun.png", -8, -14, 16, 16); GL11.glPopMatrix(); GL11.glPopMatrix(); } case -2056757052: if (str.equals("xionger")) { double pX = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX(); double pY = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY(); double pZ = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ(); GL11.glPushMatrix(); GL11.glTranslatef((float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), (float)pZ); GL11.glNormal3f(1.0F, 1.0F, 1.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F); float scale = 0.06F; GL11.glScalef(-scale, -scale, scale); GL11.glDisable(2896); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glPushMatrix(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawImage2("tomk/esp/xionger.png", -8, -14, 16, 16); GL11.glPopMatrix(); GL11.glPopMatrix(); } 
/*     */           case 2109833388: if (str.equals("caoxiaolong")) { double pX = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX(); double pY = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY(); double pZ = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ(); GL11.glPushMatrix(); GL11.glTranslatef((float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), (float)pZ); GL11.glNormal3f(1.0F, 1.0F, 1.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F); float scale = 0.06F; GL11.glScalef(-scale, -scale, scale); GL11.glDisable(2896); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glPushMatrix(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawImage2("tomk/esp/caoxiaolong.png", -8, -14, 16, 16); GL11.glPopMatrix(); GL11.glPopMatrix(); } 
/* 413 */           case 377593036: if (str.equals("wangyuan")) {
/* 414 */               double pX = 
/* 415 */                 entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 416 */                 MinecraftInstance.mc.getRenderManager().getRenderPosX();
/* 417 */               double pY = 
/* 418 */                 entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 419 */                 MinecraftInstance.mc.getRenderManager().getRenderPosY();
/* 420 */               double pZ = 
/* 421 */                 entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - 
/* 422 */                 MinecraftInstance.mc.getRenderManager().getRenderPosZ();
/*     */               
/* 424 */               GL11.glPushMatrix();
/* 425 */               GL11.glTranslatef(
/* 426 */                   (float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), 
/* 427 */                   (float)pZ);
/*     */               
/* 429 */               GL11.glNormal3f(1.0F, 1.0F, 1.0F);
/* 430 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 431 */               MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/* 432 */               float scale = 0.06F;
/* 433 */               GL11.glScalef(-scale, -scale, scale);
/*     */               
/* 435 */               GL11.glDisable(2896);
/* 436 */               GL11.glDisable(2929);
/* 437 */               GL11.glEnable(3042);
/* 438 */               GL11.glBlendFunc(770, 771);
/*     */               
/* 440 */               GL11.glPushMatrix();
/* 441 */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               
/* 443 */               RenderUtils.drawImage2("tomk/esp/wangyuan.png", -8, -14, 16, 16);
/* 444 */               GL11.glPopMatrix();
/* 445 */               GL11.glPopMatrix();
/*     */             } 
/*     */           case 3284268:
/*     */             if (str.equals("kaka")) {
/*     */               double pX = entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosX(); double pY = entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosY(); double pZ = entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * MinecraftInstance.mc.getTimer().getRenderPartialTicks() - MinecraftInstance.mc.getRenderManager().getRenderPosZ(); GL11.glPushMatrix(); GL11.glTranslatef((float)pX, (float)(pY + (entity.isSneaking() ? 0.8F : 1.3F)), (float)pZ); GL11.glNormal3f(1.0F, 1.0F, 1.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F); MinecraftInstance.mc2.func_175598_ae(); GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F); float scale = 0.06F; GL11.glScalef(-scale, -scale, scale); GL11.glDisable(2896); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glPushMatrix(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); RenderUtils.drawImage2("tomk/esp/kaka.png", -8, -14, 16, 16); GL11.glPopMatrix(); GL11.glPopMatrix();
/*     */             } 
/*     */         } 
/*     */       } 
/* 453 */     }  } @EventTarget public final void onUpdate(@NotNull UpdateEvent event) { Intrinsics.checkParameterIsNotNull(event, "event"); String mode = (String)this.modeValue.get();
/* 454 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntity entity : MinecraftInstance.mc.getTheWorld().getLoadedEntityList()) {
/* 455 */       if ((Intrinsics.areEqual(entity, MinecraftInstance.mc.getThePlayer()) ^ true) != 0 && EntityUtils.isSelected(entity, false)) {
/* 456 */         IEntityLivingBase entityLiving = entity.asEntityLivingBase();
/*     */         
/* 458 */         String str = mode; boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 3175821:
/* 459 */             if (str.equals("glow")) {
/* 460 */               entityLiving.addPotionEffect(MinecraftInstance.classProvider.createPotionEffect(MinecraftInstance.classProvider.getPotionEnum(PotionType.GLOWING).getId(), 1337, 1));
/*     */             } }
/*     */       
/*     */       } 
/*     */     }  }
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
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'event'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   14: checkcast java/lang/String
/*     */     //   17: astore_3
/*     */     //   18: iconst_0
/*     */     //   19: istore #4
/*     */     //   21: aload_3
/*     */     //   22: dup
/*     */     //   23: ifnonnull -> 36
/*     */     //   26: new kotlin/TypeCastException
/*     */     //   29: dup
/*     */     //   30: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   32: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   35: athrow
/*     */     //   36: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   39: dup
/*     */     //   40: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   42: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   45: astore_2
/*     */     //   46: sipush #2982
/*     */     //   49: invokestatic getMatrix : (I)Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   52: astore_3
/*     */     //   53: sipush #2983
/*     */     //   56: invokestatic getMatrix : (I)Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   59: astore #4
/*     */     //   61: aload_2
/*     */     //   62: ldc_w 'csgo'
/*     */     //   65: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   68: ifne -> 91
/*     */     //   71: aload_2
/*     */     //   72: ldc_w 'real2d'
/*     */     //   75: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   78: ifne -> 91
/*     */     //   81: aload_2
/*     */     //   82: ldc_w 'csgo-old'
/*     */     //   85: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   88: ifeq -> 95
/*     */     //   91: iconst_1
/*     */     //   92: goto -> 96
/*     */     //   95: iconst_0
/*     */     //   96: istore #5
/*     */     //   98: iload #5
/*     */     //   100: ifeq -> 204
/*     */     //   103: sipush #8192
/*     */     //   106: invokestatic glPushAttrib : (I)V
/*     */     //   109: sipush #3042
/*     */     //   112: invokestatic glEnable : (I)V
/*     */     //   115: sipush #3553
/*     */     //   118: invokestatic glDisable : (I)V
/*     */     //   121: sipush #2929
/*     */     //   124: invokestatic glDisable : (I)V
/*     */     //   127: sipush #5889
/*     */     //   130: invokestatic glMatrixMode : (I)V
/*     */     //   133: invokestatic glPushMatrix : ()V
/*     */     //   136: invokestatic glLoadIdentity : ()V
/*     */     //   139: dconst_0
/*     */     //   140: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   143: invokeinterface getDisplayWidth : ()I
/*     */     //   148: i2d
/*     */     //   149: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   152: invokeinterface getDisplayHeight : ()I
/*     */     //   157: i2d
/*     */     //   158: dconst_0
/*     */     //   159: ldc2_w -1.0
/*     */     //   162: dconst_1
/*     */     //   163: invokestatic glOrtho : (DDDDDD)V
/*     */     //   166: sipush #5888
/*     */     //   169: invokestatic glMatrixMode : (I)V
/*     */     //   172: invokestatic glPushMatrix : ()V
/*     */     //   175: invokestatic glLoadIdentity : ()V
/*     */     //   178: sipush #2929
/*     */     //   181: invokestatic glDisable : (I)V
/*     */     //   184: sipush #770
/*     */     //   187: sipush #771
/*     */     //   190: invokestatic glBlendFunc : (II)V
/*     */     //   193: invokestatic func_179098_w : ()V
/*     */     //   196: iconst_1
/*     */     //   197: invokestatic func_179132_a : (Z)V
/*     */     //   200: fconst_1
/*     */     //   201: invokestatic glLineWidth : (F)V
/*     */     //   204: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   207: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   212: dup
/*     */     //   213: ifnonnull -> 219
/*     */     //   216: invokestatic throwNpe : ()V
/*     */     //   219: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   224: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   229: astore #7
/*     */     //   231: aload #7
/*     */     //   233: invokeinterface hasNext : ()Z
/*     */     //   238: ifeq -> 2394
/*     */     //   241: aload #7
/*     */     //   243: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   248: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   251: astore #6
/*     */     //   253: aload #6
/*     */     //   255: iconst_0
/*     */     //   256: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   259: ifeq -> 2391
/*     */     //   262: aload #6
/*     */     //   264: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   269: astore #8
/*     */     //   271: aload_0
/*     */     //   272: aload #8
/*     */     //   274: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   277: invokevirtual getColor : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Ljava/awt/Color;
/*     */     //   280: astore #9
/*     */     //   282: aload_2
/*     */     //   283: astore #10
/*     */     //   285: aload #10
/*     */     //   287: invokevirtual hashCode : ()I
/*     */     //   290: lookupswitch default -> 2391, -1518963662 -> 370, -1171135301 -> 426, -934973296 -> 384, 1650 -> 356, 97739 -> 412, 3063128 -> 398, 97692013 -> 440
/*     */     //   356: aload #10
/*     */     //   358: ldc_w '2d'
/*     */     //   361: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   364: ifeq -> 2391
/*     */     //   367: goto -> 487
/*     */     //   370: aload #10
/*     */     //   372: ldc_w 'csgo-old'
/*     */     //   375: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   378: ifeq -> 2391
/*     */     //   381: goto -> 665
/*     */     //   384: aload #10
/*     */     //   386: ldc_w 'real2d'
/*     */     //   389: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   392: ifeq -> 2391
/*     */     //   395: goto -> 665
/*     */     //   398: aload #10
/*     */     //   400: ldc_w 'csgo'
/*     */     //   403: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   406: ifeq -> 2391
/*     */     //   409: goto -> 665
/*     */     //   412: aload #10
/*     */     //   414: ldc_w 'box'
/*     */     //   417: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   420: ifeq -> 2391
/*     */     //   423: goto -> 454
/*     */     //   426: aload #10
/*     */     //   428: ldc_w 'otherbox'
/*     */     //   431: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   434: ifeq -> 2391
/*     */     //   437: goto -> 454
/*     */     //   440: aload #10
/*     */     //   442: ldc_w 'frame'
/*     */     //   445: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   448: ifeq -> 2391
/*     */     //   451: goto -> 480
/*     */     //   454: aload #6
/*     */     //   456: aload #9
/*     */     //   458: aload_2
/*     */     //   459: ldc_w 'otherbox'
/*     */     //   462: iconst_1
/*     */     //   463: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   466: ifne -> 473
/*     */     //   469: iconst_1
/*     */     //   470: goto -> 474
/*     */     //   473: iconst_0
/*     */     //   474: invokestatic drawEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Ljava/awt/Color;Z)V
/*     */     //   477: goto -> 2391
/*     */     //   480: aload_0
/*     */     //   481: invokevirtual doWireFrame : ()V
/*     */     //   484: goto -> 2391
/*     */     //   487: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   490: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   495: astore #11
/*     */     //   497: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   500: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   505: astore #12
/*     */     //   507: aload #8
/*     */     //   509: invokeinterface getLastTickPosX : ()D
/*     */     //   514: aload #8
/*     */     //   516: invokeinterface getPosX : ()D
/*     */     //   521: aload #8
/*     */     //   523: invokeinterface getLastTickPosX : ()D
/*     */     //   528: dsub
/*     */     //   529: aload #12
/*     */     //   531: invokeinterface getRenderPartialTicks : ()F
/*     */     //   536: f2d
/*     */     //   537: dmul
/*     */     //   538: dadd
/*     */     //   539: aload #11
/*     */     //   541: invokeinterface getRenderPosX : ()D
/*     */     //   546: dsub
/*     */     //   547: dstore #13
/*     */     //   549: aload #8
/*     */     //   551: invokeinterface getLastTickPosY : ()D
/*     */     //   556: aload #8
/*     */     //   558: invokeinterface getPosY : ()D
/*     */     //   563: aload #8
/*     */     //   565: invokeinterface getLastTickPosY : ()D
/*     */     //   570: dsub
/*     */     //   571: aload #12
/*     */     //   573: invokeinterface getRenderPartialTicks : ()F
/*     */     //   578: f2d
/*     */     //   579: dmul
/*     */     //   580: dadd
/*     */     //   581: aload #11
/*     */     //   583: invokeinterface getRenderPosY : ()D
/*     */     //   588: dsub
/*     */     //   589: dstore #15
/*     */     //   591: aload #8
/*     */     //   593: invokeinterface getLastTickPosZ : ()D
/*     */     //   598: aload #8
/*     */     //   600: invokeinterface getPosZ : ()D
/*     */     //   605: aload #8
/*     */     //   607: invokeinterface getLastTickPosZ : ()D
/*     */     //   612: dsub
/*     */     //   613: aload #12
/*     */     //   615: invokeinterface getRenderPartialTicks : ()F
/*     */     //   620: f2d
/*     */     //   621: dmul
/*     */     //   622: dadd
/*     */     //   623: aload #11
/*     */     //   625: invokeinterface getRenderPosZ : ()D
/*     */     //   630: dsub
/*     */     //   631: dstore #17
/*     */     //   633: aload #8
/*     */     //   635: dload #13
/*     */     //   637: dload #15
/*     */     //   639: dload #17
/*     */     //   641: aload #9
/*     */     //   643: invokevirtual getRGB : ()I
/*     */     //   646: getstatic java/awt/Color.BLACK : Ljava/awt/Color;
/*     */     //   649: dup
/*     */     //   650: ldc_w 'Color.BLACK'
/*     */     //   653: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   656: invokevirtual getRGB : ()I
/*     */     //   659: invokestatic draw2D : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;DDDII)V
/*     */     //   662: goto -> 2391
/*     */     //   665: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   668: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   673: astore #11
/*     */     //   675: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   678: invokeinterface getTimer : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   683: astore #12
/*     */     //   685: aload #8
/*     */     //   687: invokeinterface getEntityBoundingBox : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   692: aload #8
/*     */     //   694: invokeinterface getPosX : ()D
/*     */     //   699: dneg
/*     */     //   700: aload #8
/*     */     //   702: invokeinterface getPosY : ()D
/*     */     //   707: dneg
/*     */     //   708: aload #8
/*     */     //   710: invokeinterface getPosZ : ()D
/*     */     //   715: dneg
/*     */     //   716: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   721: aload #8
/*     */     //   723: invokeinterface getLastTickPosX : ()D
/*     */     //   728: aload #8
/*     */     //   730: invokeinterface getPosX : ()D
/*     */     //   735: aload #8
/*     */     //   737: invokeinterface getLastTickPosX : ()D
/*     */     //   742: dsub
/*     */     //   743: aload #12
/*     */     //   745: invokeinterface getRenderPartialTicks : ()F
/*     */     //   750: f2d
/*     */     //   751: dmul
/*     */     //   752: dadd
/*     */     //   753: aload #8
/*     */     //   755: invokeinterface getLastTickPosY : ()D
/*     */     //   760: aload #8
/*     */     //   762: invokeinterface getPosY : ()D
/*     */     //   767: aload #8
/*     */     //   769: invokeinterface getLastTickPosY : ()D
/*     */     //   774: dsub
/*     */     //   775: aload #12
/*     */     //   777: invokeinterface getRenderPartialTicks : ()F
/*     */     //   782: f2d
/*     */     //   783: dmul
/*     */     //   784: dadd
/*     */     //   785: aload #8
/*     */     //   787: invokeinterface getLastTickPosZ : ()D
/*     */     //   792: aload #8
/*     */     //   794: invokeinterface getPosZ : ()D
/*     */     //   799: aload #8
/*     */     //   801: invokeinterface getLastTickPosZ : ()D
/*     */     //   806: dsub
/*     */     //   807: aload #12
/*     */     //   809: invokeinterface getRenderPartialTicks : ()F
/*     */     //   814: f2d
/*     */     //   815: dmul
/*     */     //   816: dadd
/*     */     //   817: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   822: aload #11
/*     */     //   824: invokeinterface getRenderPosX : ()D
/*     */     //   829: dneg
/*     */     //   830: aload #11
/*     */     //   832: invokeinterface getRenderPosY : ()D
/*     */     //   837: dneg
/*     */     //   838: aload #11
/*     */     //   840: invokeinterface getRenderPosZ : ()D
/*     */     //   845: dneg
/*     */     //   846: invokeinterface offset : (DDD)Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   851: astore #13
/*     */     //   853: bipush #8
/*     */     //   855: anewarray [D
/*     */     //   858: dup
/*     */     //   859: iconst_0
/*     */     //   860: iconst_3
/*     */     //   861: newarray double
/*     */     //   863: dup
/*     */     //   864: iconst_0
/*     */     //   865: aload #13
/*     */     //   867: invokeinterface getMinX : ()D
/*     */     //   872: dastore
/*     */     //   873: dup
/*     */     //   874: iconst_1
/*     */     //   875: aload #13
/*     */     //   877: invokeinterface getMinY : ()D
/*     */     //   882: dastore
/*     */     //   883: dup
/*     */     //   884: iconst_2
/*     */     //   885: aload #13
/*     */     //   887: invokeinterface getMinZ : ()D
/*     */     //   892: dastore
/*     */     //   893: aastore
/*     */     //   894: dup
/*     */     //   895: iconst_1
/*     */     //   896: iconst_3
/*     */     //   897: newarray double
/*     */     //   899: dup
/*     */     //   900: iconst_0
/*     */     //   901: aload #13
/*     */     //   903: invokeinterface getMinX : ()D
/*     */     //   908: dastore
/*     */     //   909: dup
/*     */     //   910: iconst_1
/*     */     //   911: aload #13
/*     */     //   913: invokeinterface getMaxY : ()D
/*     */     //   918: dastore
/*     */     //   919: dup
/*     */     //   920: iconst_2
/*     */     //   921: aload #13
/*     */     //   923: invokeinterface getMinZ : ()D
/*     */     //   928: dastore
/*     */     //   929: aastore
/*     */     //   930: dup
/*     */     //   931: iconst_2
/*     */     //   932: iconst_3
/*     */     //   933: newarray double
/*     */     //   935: dup
/*     */     //   936: iconst_0
/*     */     //   937: aload #13
/*     */     //   939: invokeinterface getMaxX : ()D
/*     */     //   944: dastore
/*     */     //   945: dup
/*     */     //   946: iconst_1
/*     */     //   947: aload #13
/*     */     //   949: invokeinterface getMaxY : ()D
/*     */     //   954: dastore
/*     */     //   955: dup
/*     */     //   956: iconst_2
/*     */     //   957: aload #13
/*     */     //   959: invokeinterface getMinZ : ()D
/*     */     //   964: dastore
/*     */     //   965: aastore
/*     */     //   966: dup
/*     */     //   967: iconst_3
/*     */     //   968: iconst_3
/*     */     //   969: newarray double
/*     */     //   971: dup
/*     */     //   972: iconst_0
/*     */     //   973: aload #13
/*     */     //   975: invokeinterface getMaxX : ()D
/*     */     //   980: dastore
/*     */     //   981: dup
/*     */     //   982: iconst_1
/*     */     //   983: aload #13
/*     */     //   985: invokeinterface getMinY : ()D
/*     */     //   990: dastore
/*     */     //   991: dup
/*     */     //   992: iconst_2
/*     */     //   993: aload #13
/*     */     //   995: invokeinterface getMinZ : ()D
/*     */     //   1000: dastore
/*     */     //   1001: aastore
/*     */     //   1002: dup
/*     */     //   1003: iconst_4
/*     */     //   1004: iconst_3
/*     */     //   1005: newarray double
/*     */     //   1007: dup
/*     */     //   1008: iconst_0
/*     */     //   1009: aload #13
/*     */     //   1011: invokeinterface getMinX : ()D
/*     */     //   1016: dastore
/*     */     //   1017: dup
/*     */     //   1018: iconst_1
/*     */     //   1019: aload #13
/*     */     //   1021: invokeinterface getMinY : ()D
/*     */     //   1026: dastore
/*     */     //   1027: dup
/*     */     //   1028: iconst_2
/*     */     //   1029: aload #13
/*     */     //   1031: invokeinterface getMaxZ : ()D
/*     */     //   1036: dastore
/*     */     //   1037: aastore
/*     */     //   1038: dup
/*     */     //   1039: iconst_5
/*     */     //   1040: iconst_3
/*     */     //   1041: newarray double
/*     */     //   1043: dup
/*     */     //   1044: iconst_0
/*     */     //   1045: aload #13
/*     */     //   1047: invokeinterface getMinX : ()D
/*     */     //   1052: dastore
/*     */     //   1053: dup
/*     */     //   1054: iconst_1
/*     */     //   1055: aload #13
/*     */     //   1057: invokeinterface getMaxY : ()D
/*     */     //   1062: dastore
/*     */     //   1063: dup
/*     */     //   1064: iconst_2
/*     */     //   1065: aload #13
/*     */     //   1067: invokeinterface getMaxZ : ()D
/*     */     //   1072: dastore
/*     */     //   1073: aastore
/*     */     //   1074: dup
/*     */     //   1075: bipush #6
/*     */     //   1077: iconst_3
/*     */     //   1078: newarray double
/*     */     //   1080: dup
/*     */     //   1081: iconst_0
/*     */     //   1082: aload #13
/*     */     //   1084: invokeinterface getMaxX : ()D
/*     */     //   1089: dastore
/*     */     //   1090: dup
/*     */     //   1091: iconst_1
/*     */     //   1092: aload #13
/*     */     //   1094: invokeinterface getMaxY : ()D
/*     */     //   1099: dastore
/*     */     //   1100: dup
/*     */     //   1101: iconst_2
/*     */     //   1102: aload #13
/*     */     //   1104: invokeinterface getMaxZ : ()D
/*     */     //   1109: dastore
/*     */     //   1110: aastore
/*     */     //   1111: dup
/*     */     //   1112: bipush #7
/*     */     //   1114: iconst_3
/*     */     //   1115: newarray double
/*     */     //   1117: dup
/*     */     //   1118: iconst_0
/*     */     //   1119: aload #13
/*     */     //   1121: invokeinterface getMaxX : ()D
/*     */     //   1126: dastore
/*     */     //   1127: dup
/*     */     //   1128: iconst_1
/*     */     //   1129: aload #13
/*     */     //   1131: invokeinterface getMinY : ()D
/*     */     //   1136: dastore
/*     */     //   1137: dup
/*     */     //   1138: iconst_2
/*     */     //   1139: aload #13
/*     */     //   1141: invokeinterface getMaxZ : ()D
/*     */     //   1146: dastore
/*     */     //   1147: aastore
/*     */     //   1148: checkcast [[D
/*     */     //   1151: astore #14
/*     */     //   1153: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1156: invokeinterface getDisplayWidth : ()I
/*     */     //   1161: i2f
/*     */     //   1162: fstore #15
/*     */     //   1164: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1167: invokeinterface getDisplayHeight : ()I
/*     */     //   1172: i2f
/*     */     //   1173: fstore #16
/*     */     //   1175: fconst_0
/*     */     //   1176: fstore #17
/*     */     //   1178: fconst_0
/*     */     //   1179: fstore #18
/*     */     //   1181: aload #14
/*     */     //   1183: astore #21
/*     */     //   1185: aload #21
/*     */     //   1187: arraylength
/*     */     //   1188: istore #22
/*     */     //   1190: iconst_0
/*     */     //   1191: istore #20
/*     */     //   1193: iload #20
/*     */     //   1195: iload #22
/*     */     //   1197: if_icmpge -> 1318
/*     */     //   1200: aload #21
/*     */     //   1202: iload #20
/*     */     //   1204: aaload
/*     */     //   1205: astore #19
/*     */     //   1207: new org/lwjgl/util/vector/Vector3f
/*     */     //   1210: dup
/*     */     //   1211: aload #19
/*     */     //   1213: iconst_0
/*     */     //   1214: daload
/*     */     //   1215: d2f
/*     */     //   1216: aload #19
/*     */     //   1218: iconst_1
/*     */     //   1219: daload
/*     */     //   1220: d2f
/*     */     //   1221: aload #19
/*     */     //   1223: iconst_2
/*     */     //   1224: daload
/*     */     //   1225: d2f
/*     */     //   1226: invokespecial <init> : (FFF)V
/*     */     //   1229: aload_3
/*     */     //   1230: aload #4
/*     */     //   1232: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1235: invokeinterface getDisplayWidth : ()I
/*     */     //   1240: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1243: invokeinterface getDisplayHeight : ()I
/*     */     //   1248: invokestatic worldToScreen : (Lorg/lwjgl/util/vector/Vector3f;Lorg/lwjgl/util/vector/Matrix4f;Lorg/lwjgl/util/vector/Matrix4f;II)Lorg/lwjgl/util/vector/Vector2f;
/*     */     //   1251: dup
/*     */     //   1252: ifnull -> 1258
/*     */     //   1255: goto -> 1262
/*     */     //   1258: pop
/*     */     //   1259: goto -> 1312
/*     */     //   1262: astore #23
/*     */     //   1264: aload #23
/*     */     //   1266: getfield x : F
/*     */     //   1269: fload #15
/*     */     //   1271: invokestatic coerceAtMost : (FF)F
/*     */     //   1274: fstore #15
/*     */     //   1276: aload #23
/*     */     //   1278: getfield y : F
/*     */     //   1281: fload #16
/*     */     //   1283: invokestatic coerceAtMost : (FF)F
/*     */     //   1286: fstore #16
/*     */     //   1288: aload #23
/*     */     //   1290: getfield x : F
/*     */     //   1293: fload #17
/*     */     //   1295: invokestatic coerceAtLeast : (FF)F
/*     */     //   1298: fstore #17
/*     */     //   1300: aload #23
/*     */     //   1302: getfield y : F
/*     */     //   1305: fload #18
/*     */     //   1307: invokestatic coerceAtLeast : (FF)F
/*     */     //   1310: fstore #18
/*     */     //   1312: iinc #20, 1
/*     */     //   1315: goto -> 1193
/*     */     //   1318: fload #15
/*     */     //   1320: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1323: invokeinterface getDisplayWidth : ()I
/*     */     //   1328: i2f
/*     */     //   1329: fcmpg
/*     */     //   1330: ifeq -> 2391
/*     */     //   1333: fload #16
/*     */     //   1335: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1338: invokeinterface getDisplayHeight : ()I
/*     */     //   1343: i2f
/*     */     //   1344: fcmpg
/*     */     //   1345: ifeq -> 2391
/*     */     //   1348: fload #17
/*     */     //   1350: fconst_0
/*     */     //   1351: fcmpg
/*     */     //   1352: ifeq -> 2391
/*     */     //   1355: fload #18
/*     */     //   1357: fconst_0
/*     */     //   1358: fcmpg
/*     */     //   1359: ifeq -> 2391
/*     */     //   1362: aload_2
/*     */     //   1363: ldc_w 'csgo'
/*     */     //   1366: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   1369: ifeq -> 2075
/*     */     //   1372: aload #9
/*     */     //   1374: invokestatic glColor : (Ljava/awt/Color;)V
/*     */     //   1377: aload_0
/*     */     //   1378: getfield csgoDirectLineValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1381: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1384: checkcast java/lang/Boolean
/*     */     //   1387: invokevirtual booleanValue : ()Z
/*     */     //   1390: ifne -> 1554
/*     */     //   1393: fload #17
/*     */     //   1395: fload #15
/*     */     //   1397: fsub
/*     */     //   1398: ldc_w 3.0
/*     */     //   1401: fdiv
/*     */     //   1402: fstore #19
/*     */     //   1404: fload #18
/*     */     //   1406: fload #16
/*     */     //   1408: fsub
/*     */     //   1409: ldc_w 3.0
/*     */     //   1412: fdiv
/*     */     //   1413: fstore #20
/*     */     //   1415: iconst_3
/*     */     //   1416: invokestatic glBegin : (I)V
/*     */     //   1419: fload #15
/*     */     //   1421: fload #16
/*     */     //   1423: fload #20
/*     */     //   1425: fadd
/*     */     //   1426: invokestatic glVertex2f : (FF)V
/*     */     //   1429: fload #15
/*     */     //   1431: fload #16
/*     */     //   1433: invokestatic glVertex2f : (FF)V
/*     */     //   1436: fload #15
/*     */     //   1438: fload #19
/*     */     //   1440: fadd
/*     */     //   1441: fload #16
/*     */     //   1443: invokestatic glVertex2f : (FF)V
/*     */     //   1446: invokestatic glEnd : ()V
/*     */     //   1449: iconst_3
/*     */     //   1450: invokestatic glBegin : (I)V
/*     */     //   1453: fload #15
/*     */     //   1455: fload #18
/*     */     //   1457: fload #20
/*     */     //   1459: fsub
/*     */     //   1460: invokestatic glVertex2f : (FF)V
/*     */     //   1463: fload #15
/*     */     //   1465: fload #18
/*     */     //   1467: invokestatic glVertex2f : (FF)V
/*     */     //   1470: fload #15
/*     */     //   1472: fload #19
/*     */     //   1474: fadd
/*     */     //   1475: fload #18
/*     */     //   1477: invokestatic glVertex2f : (FF)V
/*     */     //   1480: invokestatic glEnd : ()V
/*     */     //   1483: iconst_3
/*     */     //   1484: invokestatic glBegin : (I)V
/*     */     //   1487: fload #17
/*     */     //   1489: fload #19
/*     */     //   1491: fsub
/*     */     //   1492: fload #16
/*     */     //   1494: invokestatic glVertex2f : (FF)V
/*     */     //   1497: fload #17
/*     */     //   1499: fload #16
/*     */     //   1501: invokestatic glVertex2f : (FF)V
/*     */     //   1504: fload #17
/*     */     //   1506: fload #16
/*     */     //   1508: fload #20
/*     */     //   1510: fadd
/*     */     //   1511: invokestatic glVertex2f : (FF)V
/*     */     //   1514: invokestatic glEnd : ()V
/*     */     //   1517: iconst_3
/*     */     //   1518: invokestatic glBegin : (I)V
/*     */     //   1521: fload #17
/*     */     //   1523: fload #19
/*     */     //   1525: fsub
/*     */     //   1526: fload #18
/*     */     //   1528: invokestatic glVertex2f : (FF)V
/*     */     //   1531: fload #17
/*     */     //   1533: fload #18
/*     */     //   1535: invokestatic glVertex2f : (FF)V
/*     */     //   1538: fload #17
/*     */     //   1540: fload #18
/*     */     //   1542: fload #20
/*     */     //   1544: fsub
/*     */     //   1545: invokestatic glVertex2f : (FF)V
/*     */     //   1548: invokestatic glEnd : ()V
/*     */     //   1551: goto -> 1589
/*     */     //   1554: iconst_2
/*     */     //   1555: invokestatic glBegin : (I)V
/*     */     //   1558: fload #15
/*     */     //   1560: fload #16
/*     */     //   1562: invokestatic glVertex2f : (FF)V
/*     */     //   1565: fload #15
/*     */     //   1567: fload #18
/*     */     //   1569: invokestatic glVertex2f : (FF)V
/*     */     //   1572: fload #17
/*     */     //   1574: fload #18
/*     */     //   1576: invokestatic glVertex2f : (FF)V
/*     */     //   1579: fload #17
/*     */     //   1581: fload #16
/*     */     //   1583: invokestatic glVertex2f : (FF)V
/*     */     //   1586: invokestatic glEnd : ()V
/*     */     //   1589: aload_0
/*     */     //   1590: getfield csgoShowHealthValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1593: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1596: checkcast java/lang/Boolean
/*     */     //   1599: invokevirtual booleanValue : ()Z
/*     */     //   1602: ifeq -> 1821
/*     */     //   1605: fload #18
/*     */     //   1607: fload #16
/*     */     //   1609: fsub
/*     */     //   1610: fconst_1
/*     */     //   1611: aload #8
/*     */     //   1613: invokeinterface getHealth : ()F
/*     */     //   1618: aload #8
/*     */     //   1620: invokeinterface getMaxHealth : ()F
/*     */     //   1625: fdiv
/*     */     //   1626: fsub
/*     */     //   1627: fmul
/*     */     //   1628: fstore #19
/*     */     //   1630: ldc_w 0.1
/*     */     //   1633: fconst_1
/*     */     //   1634: ldc_w 0.1
/*     */     //   1637: fconst_1
/*     */     //   1638: invokestatic glColor4f : (FFFF)V
/*     */     //   1641: bipush #7
/*     */     //   1643: invokestatic glBegin : (I)V
/*     */     //   1646: fload #17
/*     */     //   1648: fconst_2
/*     */     //   1649: fadd
/*     */     //   1650: fload #16
/*     */     //   1652: fload #19
/*     */     //   1654: fadd
/*     */     //   1655: invokestatic glVertex2f : (FF)V
/*     */     //   1658: fload #17
/*     */     //   1660: fconst_2
/*     */     //   1661: fadd
/*     */     //   1662: fload #18
/*     */     //   1664: invokestatic glVertex2f : (FF)V
/*     */     //   1667: fload #17
/*     */     //   1669: ldc_w 3.0
/*     */     //   1672: fadd
/*     */     //   1673: fload #18
/*     */     //   1675: invokestatic glVertex2f : (FF)V
/*     */     //   1678: fload #17
/*     */     //   1680: ldc_w 3.0
/*     */     //   1683: fadd
/*     */     //   1684: fload #16
/*     */     //   1686: fload #19
/*     */     //   1688: fadd
/*     */     //   1689: invokestatic glVertex2f : (FF)V
/*     */     //   1692: invokestatic glEnd : ()V
/*     */     //   1695: fconst_1
/*     */     //   1696: fconst_1
/*     */     //   1697: fconst_1
/*     */     //   1698: fconst_1
/*     */     //   1699: invokestatic glColor4f : (FFFF)V
/*     */     //   1702: sipush #3553
/*     */     //   1705: invokestatic glEnable : (I)V
/*     */     //   1708: sipush #2929
/*     */     //   1711: invokestatic glEnable : (I)V
/*     */     //   1714: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1717: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1722: new java/lang/StringBuilder
/*     */     //   1725: dup
/*     */     //   1726: invokespecial <init> : ()V
/*     */     //   1729: aload_0
/*     */     //   1730: getfield decimalFormat : Ljava/text/DecimalFormat;
/*     */     //   1733: aload #8
/*     */     //   1735: invokeinterface getHealth : ()F
/*     */     //   1740: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   1743: invokevirtual format : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   1746: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1749: ldc_w '§c❤'
/*     */     //   1752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1755: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1758: fload #17
/*     */     //   1760: ldc_w 4.0
/*     */     //   1763: fadd
/*     */     //   1764: fload #16
/*     */     //   1766: fload #19
/*     */     //   1768: fadd
/*     */     //   1769: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   1772: aload #8
/*     */     //   1774: invokeinterface getHealth : ()F
/*     */     //   1779: aload #8
/*     */     //   1781: invokeinterface getMaxHealth : ()F
/*     */     //   1786: iconst_0
/*     */     //   1787: iconst_4
/*     */     //   1788: aconst_null
/*     */     //   1789: invokestatic healthColor$default : (Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;FFIILjava/lang/Object;)Ljava/awt/Color;
/*     */     //   1792: invokevirtual getRGB : ()I
/*     */     //   1795: iconst_0
/*     */     //   1796: invokeinterface drawString : (Ljava/lang/String;FFIZ)I
/*     */     //   1801: pop
/*     */     //   1802: sipush #3553
/*     */     //   1805: invokestatic glDisable : (I)V
/*     */     //   1808: sipush #2929
/*     */     //   1811: invokestatic glDisable : (I)V
/*     */     //   1814: fconst_1
/*     */     //   1815: fconst_1
/*     */     //   1816: fconst_1
/*     */     //   1817: fconst_1
/*     */     //   1818: invokestatic glColor4f : (FFFF)V
/*     */     //   1821: aload_0
/*     */     //   1822: getfield csgoShowHeldItemValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1825: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1828: checkcast java/lang/Boolean
/*     */     //   1831: invokevirtual booleanValue : ()Z
/*     */     //   1834: ifeq -> 1969
/*     */     //   1837: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1840: aload #8
/*     */     //   1842: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   1847: ifeq -> 1969
/*     */     //   1850: aload #8
/*     */     //   1852: invokeinterface asEntityPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*     */     //   1857: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1862: dup
/*     */     //   1863: ifnull -> 1874
/*     */     //   1866: invokeinterface getDisplayName : ()Ljava/lang/String;
/*     */     //   1871: goto -> 1876
/*     */     //   1874: pop
/*     */     //   1875: aconst_null
/*     */     //   1876: ifnull -> 1969
/*     */     //   1879: sipush #3553
/*     */     //   1882: invokestatic glEnable : (I)V
/*     */     //   1885: sipush #2929
/*     */     //   1888: invokestatic glEnable : (I)V
/*     */     //   1891: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1894: aload #8
/*     */     //   1896: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   1901: ifeq -> 1957
/*     */     //   1904: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1907: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1912: aload #8
/*     */     //   1914: invokeinterface asEntityPlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/IEntityPlayer;
/*     */     //   1919: invokeinterface getHeldItem : ()Lnet/ccbluex/liquidbounce/api/minecraft/item/IItemStack;
/*     */     //   1924: dup
/*     */     //   1925: ifnonnull -> 1931
/*     */     //   1928: invokestatic throwNpe : ()V
/*     */     //   1931: invokeinterface getDisplayName : ()Ljava/lang/String;
/*     */     //   1936: fload #15
/*     */     //   1938: fload #17
/*     */     //   1940: fload #15
/*     */     //   1942: fsub
/*     */     //   1943: fconst_2
/*     */     //   1944: fdiv
/*     */     //   1945: fadd
/*     */     //   1946: fload #18
/*     */     //   1948: fconst_2
/*     */     //   1949: fadd
/*     */     //   1950: iconst_m1
/*     */     //   1951: invokeinterface drawCenteredString : (Ljava/lang/String;FFI)I
/*     */     //   1956: pop
/*     */     //   1957: sipush #3553
/*     */     //   1960: invokestatic glDisable : (I)V
/*     */     //   1963: sipush #2929
/*     */     //   1966: invokestatic glDisable : (I)V
/*     */     //   1969: aload_0
/*     */     //   1970: getfield csgoShowNameValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   1973: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1976: checkcast java/lang/Boolean
/*     */     //   1979: invokevirtual booleanValue : ()Z
/*     */     //   1982: ifeq -> 2391
/*     */     //   1985: sipush #3553
/*     */     //   1988: invokestatic glEnable : (I)V
/*     */     //   1991: sipush #2929
/*     */     //   1994: invokestatic glEnable : (I)V
/*     */     //   1997: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2000: aload #8
/*     */     //   2002: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   2007: ifeq -> 2060
/*     */     //   2010: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2013: invokeinterface getFontRendererObj : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   2018: aload #8
/*     */     //   2020: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   2025: dup
/*     */     //   2026: ifnonnull -> 2032
/*     */     //   2029: invokestatic throwNpe : ()V
/*     */     //   2032: invokeinterface getFormattedText : ()Ljava/lang/String;
/*     */     //   2037: fload #15
/*     */     //   2039: fload #17
/*     */     //   2041: fload #15
/*     */     //   2043: fsub
/*     */     //   2044: fconst_2
/*     */     //   2045: fdiv
/*     */     //   2046: fadd
/*     */     //   2047: fload #16
/*     */     //   2049: ldc_w 12.0
/*     */     //   2052: fsub
/*     */     //   2053: iconst_m1
/*     */     //   2054: invokeinterface drawCenteredString : (Ljava/lang/String;FFI)I
/*     */     //   2059: pop
/*     */     //   2060: sipush #3553
/*     */     //   2063: invokestatic glDisable : (I)V
/*     */     //   2066: sipush #2929
/*     */     //   2069: invokestatic glDisable : (I)V
/*     */     //   2072: goto -> 2391
/*     */     //   2075: aload_2
/*     */     //   2076: ldc_w 'real2d'
/*     */     //   2079: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2082: ifeq -> 2167
/*     */     //   2085: fload #15
/*     */     //   2087: iconst_1
/*     */     //   2088: i2f
/*     */     //   2089: fsub
/*     */     //   2090: fload #16
/*     */     //   2092: iconst_1
/*     */     //   2093: i2f
/*     */     //   2094: fsub
/*     */     //   2095: fload #15
/*     */     //   2097: fload #18
/*     */     //   2099: aload #9
/*     */     //   2101: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2104: fload #17
/*     */     //   2106: fload #16
/*     */     //   2108: iconst_1
/*     */     //   2109: i2f
/*     */     //   2110: fsub
/*     */     //   2111: fload #17
/*     */     //   2113: iconst_1
/*     */     //   2114: i2f
/*     */     //   2115: fadd
/*     */     //   2116: fload #18
/*     */     //   2118: iconst_1
/*     */     //   2119: i2f
/*     */     //   2120: fadd
/*     */     //   2121: aload #9
/*     */     //   2123: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2126: fload #15
/*     */     //   2128: iconst_1
/*     */     //   2129: i2f
/*     */     //   2130: fsub
/*     */     //   2131: fload #18
/*     */     //   2133: fload #17
/*     */     //   2135: fload #18
/*     */     //   2137: iconst_1
/*     */     //   2138: i2f
/*     */     //   2139: fadd
/*     */     //   2140: aload #9
/*     */     //   2142: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2145: fload #15
/*     */     //   2147: iconst_1
/*     */     //   2148: i2f
/*     */     //   2149: fsub
/*     */     //   2150: fload #16
/*     */     //   2152: iconst_1
/*     */     //   2153: i2f
/*     */     //   2154: fsub
/*     */     //   2155: fload #17
/*     */     //   2157: fload #16
/*     */     //   2159: aload #9
/*     */     //   2161: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2164: goto -> 2391
/*     */     //   2167: aload_2
/*     */     //   2168: ldc_w 'csgo-old'
/*     */     //   2171: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   2174: ifeq -> 2391
/*     */     //   2177: aload_0
/*     */     //   2178: getfield csgoWidthValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   2181: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2184: checkcast java/lang/Number
/*     */     //   2187: invokevirtual floatValue : ()F
/*     */     //   2190: fload #18
/*     */     //   2192: fload #16
/*     */     //   2194: fsub
/*     */     //   2195: bipush #50
/*     */     //   2197: i2f
/*     */     //   2198: fdiv
/*     */     //   2199: fmul
/*     */     //   2200: fstore #19
/*     */     //   2202: fload #15
/*     */     //   2204: fload #19
/*     */     //   2206: fsub
/*     */     //   2207: fload #16
/*     */     //   2209: fload #19
/*     */     //   2211: fsub
/*     */     //   2212: fload #15
/*     */     //   2214: fload #18
/*     */     //   2216: aload #9
/*     */     //   2218: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2221: fload #17
/*     */     //   2223: fload #16
/*     */     //   2225: fload #19
/*     */     //   2227: fsub
/*     */     //   2228: fload #17
/*     */     //   2230: fload #19
/*     */     //   2232: fadd
/*     */     //   2233: fload #18
/*     */     //   2235: fload #19
/*     */     //   2237: fadd
/*     */     //   2238: aload #9
/*     */     //   2240: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2243: fload #15
/*     */     //   2245: fload #19
/*     */     //   2247: fsub
/*     */     //   2248: fload #18
/*     */     //   2250: fload #17
/*     */     //   2252: fload #18
/*     */     //   2254: fload #19
/*     */     //   2256: fadd
/*     */     //   2257: aload #9
/*     */     //   2259: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2262: fload #15
/*     */     //   2264: fload #19
/*     */     //   2266: fsub
/*     */     //   2267: fload #16
/*     */     //   2269: fload #19
/*     */     //   2271: fsub
/*     */     //   2272: fload #17
/*     */     //   2274: fload #16
/*     */     //   2276: aload #9
/*     */     //   2278: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2281: fload #18
/*     */     //   2283: fload #19
/*     */     //   2285: fadd
/*     */     //   2286: fload #16
/*     */     //   2288: fsub
/*     */     //   2289: aload #8
/*     */     //   2291: invokeinterface getHealth : ()F
/*     */     //   2296: aload #8
/*     */     //   2298: invokeinterface getMaxHealth : ()F
/*     */     //   2303: fdiv
/*     */     //   2304: fmul
/*     */     //   2305: fstore #20
/*     */     //   2307: fload #15
/*     */     //   2309: fload #19
/*     */     //   2311: iconst_3
/*     */     //   2312: i2f
/*     */     //   2313: fmul
/*     */     //   2314: fsub
/*     */     //   2315: fload #16
/*     */     //   2317: fload #19
/*     */     //   2319: fsub
/*     */     //   2320: fload #15
/*     */     //   2322: fload #19
/*     */     //   2324: iconst_2
/*     */     //   2325: i2f
/*     */     //   2326: fmul
/*     */     //   2327: fsub
/*     */     //   2328: fload #18
/*     */     //   2330: fload #19
/*     */     //   2332: fadd
/*     */     //   2333: getstatic java/awt/Color.GRAY : Ljava/awt/Color;
/*     */     //   2336: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2339: fload #15
/*     */     //   2341: fload #19
/*     */     //   2343: iconst_3
/*     */     //   2344: i2f
/*     */     //   2345: fmul
/*     */     //   2346: fsub
/*     */     //   2347: fload #18
/*     */     //   2349: fload #20
/*     */     //   2351: fsub
/*     */     //   2352: fload #15
/*     */     //   2354: fload #19
/*     */     //   2356: iconst_2
/*     */     //   2357: i2f
/*     */     //   2358: fmul
/*     */     //   2359: fsub
/*     */     //   2360: fload #18
/*     */     //   2362: fload #19
/*     */     //   2364: fadd
/*     */     //   2365: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   2368: aload #8
/*     */     //   2370: invokeinterface getHealth : ()F
/*     */     //   2375: aload #8
/*     */     //   2377: invokeinterface getMaxHealth : ()F
/*     */     //   2382: iconst_0
/*     */     //   2383: iconst_4
/*     */     //   2384: aconst_null
/*     */     //   2385: invokestatic healthColor$default : (Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;FFIILjava/lang/Object;)Ljava/awt/Color;
/*     */     //   2388: invokestatic drawRect : (FFFFLjava/awt/Color;)V
/*     */     //   2391: goto -> 231
/*     */     //   2394: iload #5
/*     */     //   2396: ifeq -> 2426
/*     */     //   2399: sipush #2929
/*     */     //   2402: invokestatic glEnable : (I)V
/*     */     //   2405: sipush #5889
/*     */     //   2408: invokestatic glMatrixMode : (I)V
/*     */     //   2411: invokestatic glPopMatrix : ()V
/*     */     //   2414: sipush #5888
/*     */     //   2417: invokestatic glMatrixMode : (I)V
/*     */     //   2420: invokestatic glPopMatrix : ()V
/*     */     //   2423: invokestatic glPopAttrib : ()V
/*     */     //   2426: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #468	-> 7
/*     */     //   #468	-> 45
/*     */     //   #469	-> 46
/*     */     //   #470	-> 53
/*     */     //   #472	-> 61
/*     */     //   #473	-> 98
/*     */     //   #474	-> 103
/*     */     //   #475	-> 109
/*     */     //   #476	-> 115
/*     */     //   #477	-> 121
/*     */     //   #478	-> 127
/*     */     //   #479	-> 133
/*     */     //   #480	-> 136
/*     */     //   #481	-> 139
/*     */     //   #482	-> 166
/*     */     //   #483	-> 172
/*     */     //   #484	-> 175
/*     */     //   #485	-> 178
/*     */     //   #486	-> 184
/*     */     //   #487	-> 193
/*     */     //   #488	-> 196
/*     */     //   #489	-> 200
/*     */     //   #492	-> 204
/*     */     //   #493	-> 253
/*     */     //   #494	-> 262
/*     */     //   #495	-> 271
/*     */     //   #496	-> 282
/*     */     //   #504	-> 356
/*     */     //   #516	-> 370
/*     */     //   #497	-> 412
/*     */     //   #498	-> 440
/*     */     //   #497	-> 454
/*     */     //   #499	-> 480
/*     */     //   #505	-> 487
/*     */     //   #506	-> 497
/*     */     //   #507	-> 507
/*     */     //   #508	-> 507
/*     */     //   #507	-> 547
/*     */     //   #509	-> 549
/*     */     //   #510	-> 549
/*     */     //   #509	-> 589
/*     */     //   #511	-> 591
/*     */     //   #512	-> 591
/*     */     //   #511	-> 631
/*     */     //   #513	-> 633
/*     */     //   #517	-> 665
/*     */     //   #518	-> 675
/*     */     //   #519	-> 685
/*     */     //   #526	-> 685
/*     */     //   #519	-> 685
/*     */     //   #521	-> 685
/*     */     //   #519	-> 685
/*     */     //   #520	-> 685
/*     */     //   #519	-> 685
/*     */     //   #520	-> 692
/*     */     //   #522	-> 721
/*     */     //   #523	-> 753
/*     */     //   #524	-> 785
/*     */     //   #521	-> 817
/*     */     //   #526	-> 822
/*     */     //   #519	-> 851
/*     */     //   #527	-> 853
/*     */     //   #528	-> 859
/*     */     //   #529	-> 895
/*     */     //   #530	-> 931
/*     */     //   #531	-> 967
/*     */     //   #532	-> 1003
/*     */     //   #533	-> 1039
/*     */     //   #534	-> 1075
/*     */     //   #535	-> 1112
/*     */     //   #527	-> 1148
/*     */     //   #537	-> 1153
/*     */     //   #538	-> 1164
/*     */     //   #539	-> 1175
/*     */     //   #540	-> 1178
/*     */     //   #541	-> 1181
/*     */     //   #542	-> 1207
/*     */     //   #543	-> 1207
/*     */     //   #544	-> 1211
/*     */     //   #543	-> 1226
/*     */     //   #545	-> 1229
/*     */     //   #542	-> 1248
/*     */     //   #546	-> 1259
/*     */     //   #542	-> 1262
/*     */     //   #547	-> 1264
/*     */     //   #548	-> 1276
/*     */     //   #549	-> 1288
/*     */     //   #550	-> 1300
/*     */     //   #541	-> 1312
/*     */     //   #554	-> 1318
/*     */     //   #555	-> 1362
/*     */     //   #556	-> 1372
/*     */     //   #557	-> 1377
/*     */     //   #558	-> 1393
/*     */     //   #559	-> 1404
/*     */     //   #560	-> 1415
/*     */     //   #561	-> 1419
/*     */     //   #562	-> 1429
/*     */     //   #563	-> 1436
/*     */     //   #564	-> 1446
/*     */     //   #565	-> 1449
/*     */     //   #566	-> 1453
/*     */     //   #567	-> 1463
/*     */     //   #568	-> 1470
/*     */     //   #569	-> 1480
/*     */     //   #570	-> 1483
/*     */     //   #571	-> 1487
/*     */     //   #572	-> 1497
/*     */     //   #573	-> 1504
/*     */     //   #574	-> 1514
/*     */     //   #575	-> 1517
/*     */     //   #576	-> 1521
/*     */     //   #577	-> 1531
/*     */     //   #578	-> 1538
/*     */     //   #579	-> 1548
/*     */     //   #581	-> 1554
/*     */     //   #582	-> 1558
/*     */     //   #583	-> 1565
/*     */     //   #584	-> 1572
/*     */     //   #585	-> 1579
/*     */     //   #586	-> 1586
/*     */     //   #587	-> 1589
/*     */     //   #588	-> 1589
/*     */     //   #589	-> 1605
/*     */     //   #590	-> 1605
/*     */     //   #589	-> 1628
/*     */     //   #591	-> 1630
/*     */     //   #592	-> 1641
/*     */     //   #593	-> 1646
/*     */     //   #594	-> 1658
/*     */     //   #595	-> 1667
/*     */     //   #596	-> 1678
/*     */     //   #597	-> 1692
/*     */     //   #598	-> 1695
/*     */     //   #599	-> 1702
/*     */     //   #600	-> 1708
/*     */     //   #601	-> 1714
/*     */     //   #602	-> 1722
/*     */     //   #603	-> 1758
/*     */     //   #604	-> 1764
/*     */     //   #605	-> 1769
/*     */     //   #606	-> 1795
/*     */     //   #601	-> 1796
/*     */     //   #608	-> 1802
/*     */     //   #609	-> 1808
/*     */     //   #610	-> 1814
/*     */     //   #612	-> 1821
/*     */     //   #613	-> 1850
/*     */     //   #614	-> 1879
/*     */     //   #615	-> 1885
/*     */     //   #616	-> 1891
/*     */     //   #617	-> 1904
/*     */     //   #618	-> 1912
/*     */     //   #619	-> 1936
/*     */     //   #620	-> 1946
/*     */     //   #621	-> 1950
/*     */     //   #617	-> 1951
/*     */     //   #624	-> 1957
/*     */     //   #625	-> 1963
/*     */     //   #628	-> 1969
/*     */     //   #629	-> 1985
/*     */     //   #630	-> 1991
/*     */     //   #631	-> 1997
/*     */     //   #632	-> 2010
/*     */     //   #633	-> 2018
/*     */     //   #634	-> 2037
/*     */     //   #635	-> 2047
/*     */     //   #636	-> 2053
/*     */     //   #632	-> 2054
/*     */     //   #639	-> 2060
/*     */     //   #640	-> 2066
/*     */     //   #642	-> 2075
/*     */     //   #643	-> 2085
/*     */     //   #644	-> 2104
/*     */     //   #645	-> 2126
/*     */     //   #646	-> 2145
/*     */     //   #647	-> 2167
/*     */     //   #648	-> 2177
/*     */     //   #649	-> 2202
/*     */     //   #650	-> 2221
/*     */     //   #651	-> 2243
/*     */     //   #652	-> 2262
/*     */     //   #654	-> 2281
/*     */     //   #655	-> 2307
/*     */     //   #656	-> 2307
/*     */     //   #657	-> 2315
/*     */     //   #658	-> 2320
/*     */     //   #659	-> 2328
/*     */     //   #660	-> 2333
/*     */     //   #655	-> 2336
/*     */     //   #662	-> 2339
/*     */     //   #663	-> 2339
/*     */     //   #664	-> 2347
/*     */     //   #665	-> 2352
/*     */     //   #666	-> 2360
/*     */     //   #667	-> 2365
/*     */     //   #662	-> 2388
/*     */     //   #669	-> 2391
/*     */     //   #672	-> 2391
/*     */     //   #492	-> 2391
/*     */     //   #676	-> 2394
/*     */     //   #677	-> 2399
/*     */     //   #678	-> 2405
/*     */     //   #679	-> 2411
/*     */     //   #680	-> 2414
/*     */     //   #681	-> 2420
/*     */     //   #682	-> 2423
/*     */     //   #684	-> 2426
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   633	29	17	posZ	D
/*     */     //   591	71	15	posY	D
/*     */     //   549	113	13	posX	D
/*     */     //   507	155	12	timer	Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   497	165	11	renderManager	Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   1264	48	23	screenPos	Lorg/lwjgl/util/vector/Vector2f;
/*     */     //   1207	108	19	boxVertex	[D
/*     */     //   1415	136	20	distY	F
/*     */     //   1404	147	19	distX	F
/*     */     //   1630	191	19	barHeight	F
/*     */     //   2307	84	20	hpSize	F
/*     */     //   2202	189	19	width	F
/*     */     //   1181	1210	18	maxY	F
/*     */     //   1178	1213	17	maxX	F
/*     */     //   1175	1216	16	minY	F
/*     */     //   1164	1227	15	minX	F
/*     */     //   1153	1238	14	boxVertices	[[D
/*     */     //   853	1538	13	bb	Lnet/ccbluex/liquidbounce/api/minecraft/util/IAxisAlignedBB;
/*     */     //   685	1706	12	timer	Lnet/ccbluex/liquidbounce/api/minecraft/util/ITimer;
/*     */     //   675	1716	11	renderManager	Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   282	2109	9	color	Ljava/awt/Color;
/*     */     //   271	2120	8	entityLiving	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   253	2138	6	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   98	2329	5	need2dTranslate	Z
/*     */     //   61	2366	4	projectionMatrix	Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   53	2374	3	mvMatrix	Lorg/lwjgl/util/vector/Matrix4f;
/*     */     //   46	2381	2	mode	Ljava/lang/String;
/*     */     //   0	2427	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP2;
/*     */     //   0	2427	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
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
/*     */   public final boolean isValid(@NotNull IEntityLivingBase entity) {
/* 687 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); return (entity != MinecraftInstance.mc.getThePlayer() && entity.getHealth() > 0.0F && entity instanceof net.minecraft.entity.player.EntityPlayer && !AntiBot.isBot(
/* 688 */         entity));
/*     */   }
/*     */   
/*     */   public final void doWireFrame() {
/* 692 */     Matrix4f mvMatrix = WorldToScreen.getMatrix(2982);
/* 693 */     Matrix4f projectionMatrix = WorldToScreen.getMatrix(2983);
/* 694 */     if (MinecraftInstance.mc.getTheWorld() == null) Intrinsics.throwNpe();  for (IEntityPlayer entity : MinecraftInstance.mc.getTheWorld().getPlayerEntities()) {
/* 695 */       if (entity.asEntityLivingBase().isInvisible() && !((Boolean)this.invisible.getValue()).booleanValue()) {
/*     */         return;
/*     */       }
/* 698 */       if (isValid((IEntityLivingBase)entity)) {
/* 699 */         GL11.glPushAttrib(8192);
/* 700 */         GL11.glEnable(3042);
/* 701 */         GL11.glDisable(3553);
/* 702 */         GL11.glDisable(2929);
/* 703 */         GL11.glMatrixMode(5889);
/* 704 */         GL11.glPushMatrix();
/* 705 */         GL11.glLoadIdentity();
/* 706 */         GL11.glOrtho(0.0D, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight(), 0.0D, -1.0D, 1.0D);
/* 707 */         GL11.glMatrixMode(5888);
/* 708 */         GL11.glPushMatrix();
/* 709 */         GL11.glLoadIdentity();
/* 710 */         GL11.glDisable(2929);
/* 711 */         GL11.glBlendFunc(770, 771);
/* 712 */         GlStateManager.func_179098_w();
/* 713 */         GL11.glDepthMask(true);
/* 714 */         GL11.glLineWidth(2.0F);
/*     */         
/* 716 */         IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/* 717 */         ITimer timer = MinecraftInstance.mc.getTimer();
/* 718 */         IAxisAlignedBB bb = entity.getEntityBoundingBox()
/* 719 */           .offset(-entity.getPosX(), -entity.getPosY(), -entity.getPosZ())
/* 720 */           .offset(
/* 721 */             entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks(), 
/* 722 */             entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks(), 
/* 723 */             entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks())
/*     */           
/* 725 */           .offset(-MinecraftInstance.mc.getRenderManager().getRenderPosX(), -MinecraftInstance.mc.getRenderManager().getRenderPosY(), -MinecraftInstance.mc.getRenderManager().getRenderPosZ());
/* 726 */         double[][] boxVertices = {
/* 727 */             { bb.getMinX(), bb.getMinY(), bb.getMinZ()
/* 728 */             }, { bb.getMinX(), bb.getMaxY(), bb.getMinZ()
/* 729 */             }, { bb.getMaxX(), bb.getMaxY(), bb.getMinZ()
/* 730 */             }, { bb.getMaxX(), bb.getMinY(), bb.getMinZ()
/* 731 */             }, { bb.getMinX(), bb.getMinY(), bb.getMaxZ()
/* 732 */             }, { bb.getMinX(), bb.getMaxY(), bb.getMaxZ()
/* 733 */             }, { bb.getMaxX(), bb.getMaxY(), bb.getMaxZ()
/* 734 */             }, { bb.getMaxX(), bb.getMinY(), bb.getMaxZ() }
/*     */           };
/* 736 */         float minX = FloatCompanionObject.INSTANCE.getMAX_VALUE();
/* 737 */         float minY = FloatCompanionObject.INSTANCE.getMAX_VALUE();
/* 738 */         float maxX = -1.0F;
/* 739 */         float maxY = -1.0F;
/* 740 */         for (double[] boxVertex : boxVertices) {
/* 741 */           if (WorldToScreen.worldToScreen(
/* 742 */               new Vector3f(
/* 743 */                 (float)boxVertex[0], 
/* 744 */                 (float)boxVertex[1], 
/* 745 */                 (float)boxVertex[2]), 
/* 746 */               mvMatrix, projectionMatrix, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight()) != null) { Vector2f screenPos = WorldToScreen.worldToScreen(new Vector3f((float)boxVertex[0], (float)boxVertex[1], (float)boxVertex[2]), mvMatrix, projectionMatrix, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight());
/*     */ 
/*     */             
/* 749 */             minX = Math.min(screenPos.x, minX);
/* 750 */             minY = Math.min(screenPos.y, minY);
/* 751 */             maxX = Math.max(screenPos.x, maxX);
/* 752 */             maxY = Math.max(screenPos.y, maxY); } else { WorldToScreen.worldToScreen(new Vector3f((float)boxVertex[0], (float)boxVertex[1], (float)boxVertex[2]), mvMatrix, projectionMatrix, MinecraftInstance.mc.getDisplayWidth(), MinecraftInstance.mc.getDisplayHeight()); }
/*     */         
/* 754 */         }  if (Retreat.INSTANCE.getModuleManager().get(Teams.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.misc.Teams");  Teams teams = (Teams)Retreat.INSTANCE.getModuleManager().get(Teams.class);
/* 755 */         GL11.glEnable(2929);
/* 756 */         GL11.glMatrixMode(5889);
/* 757 */         GL11.glPopMatrix();
/* 758 */         GL11.glMatrixMode(5888);
/* 759 */         GL11.glPopMatrix();
/* 760 */         GL11.glPopAttrib();
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
/*     */   public final void onRender2D(@NotNull Render2DEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 'event'
/*     */     //   4: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   11: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   14: checkcast java/lang/String
/*     */     //   17: astore_3
/*     */     //   18: iconst_0
/*     */     //   19: istore #4
/*     */     //   21: aload_3
/*     */     //   22: dup
/*     */     //   23: ifnonnull -> 36
/*     */     //   26: new kotlin/TypeCastException
/*     */     //   29: dup
/*     */     //   30: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   32: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   35: athrow
/*     */     //   36: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   39: dup
/*     */     //   40: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   42: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   45: astore_2
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual getPartialTicks : ()F
/*     */     //   50: fstore_3
/*     */     //   51: aload_2
/*     */     //   52: ldc_w 'jello'
/*     */     //   55: iconst_1
/*     */     //   56: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   59: ifeq -> 417
/*     */     //   62: new java/util/ArrayList
/*     */     //   65: dup
/*     */     //   66: invokespecial <init> : ()V
/*     */     //   69: astore #4
/*     */     //   71: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader.GLOW_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader;
/*     */     //   74: dup
/*     */     //   75: ldc_w 'GlowShader.GLOW_SHADER'
/*     */     //   78: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   81: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   84: astore #5
/*     */     //   86: ldc_w 3.0
/*     */     //   89: fstore #6
/*     */     //   91: new java/awt/Color
/*     */     //   94: dup
/*     */     //   95: bipush #120
/*     */     //   97: bipush #120
/*     */     //   99: bipush #120
/*     */     //   101: invokespecial <init> : (III)V
/*     */     //   104: astore #7
/*     */     //   106: new java/awt/Color
/*     */     //   109: dup
/*     */     //   110: bipush #120
/*     */     //   112: iconst_0
/*     */     //   113: iconst_0
/*     */     //   114: invokespecial <init> : (III)V
/*     */     //   117: astore #8
/*     */     //   119: iconst_1
/*     */     //   120: istore #9
/*     */     //   122: iconst_0
/*     */     //   123: istore #10
/*     */     //   125: iconst_1
/*     */     //   126: istore #11
/*     */     //   128: iload #10
/*     */     //   130: iload #11
/*     */     //   132: if_icmpgt -> 416
/*     */     //   135: aload #5
/*     */     //   137: fload_3
/*     */     //   138: invokevirtual startDraw : (F)V
/*     */     //   141: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   144: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   149: dup
/*     */     //   150: ifnonnull -> 156
/*     */     //   153: invokestatic throwNpe : ()V
/*     */     //   156: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   161: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   166: astore #13
/*     */     //   168: aload #13
/*     */     //   170: invokeinterface hasNext : ()Z
/*     */     //   175: ifeq -> 255
/*     */     //   178: aload #13
/*     */     //   180: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   185: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   188: astore #12
/*     */     //   190: aload #12
/*     */     //   192: iconst_0
/*     */     //   193: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   196: ifeq -> 252
/*     */     //   199: aload #12
/*     */     //   201: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   206: astore #14
/*     */     //   208: iload #9
/*     */     //   210: ifeq -> 234
/*     */     //   213: aload #14
/*     */     //   215: invokeinterface getHurtTime : ()I
/*     */     //   220: ifle -> 234
/*     */     //   223: aload #4
/*     */     //   225: aload #14
/*     */     //   227: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   230: pop
/*     */     //   231: goto -> 252
/*     */     //   234: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   237: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   242: aload #12
/*     */     //   244: fload_3
/*     */     //   245: iconst_1
/*     */     //   246: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   251: pop
/*     */     //   252: goto -> 168
/*     */     //   255: aload #5
/*     */     //   257: aload #7
/*     */     //   259: fload #6
/*     */     //   261: fconst_1
/*     */     //   262: invokevirtual stopDraw : (Ljava/awt/Color;FF)V
/*     */     //   265: aload #4
/*     */     //   267: invokevirtual size : ()I
/*     */     //   270: ifle -> 349
/*     */     //   273: aload #5
/*     */     //   275: fload_3
/*     */     //   276: invokevirtual startDraw : (F)V
/*     */     //   279: aload #4
/*     */     //   281: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   284: astore #13
/*     */     //   286: aload #13
/*     */     //   288: invokeinterface hasNext : ()Z
/*     */     //   293: ifeq -> 339
/*     */     //   296: aload #13
/*     */     //   298: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   303: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*     */     //   306: astore #12
/*     */     //   308: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   311: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   316: aload #12
/*     */     //   318: dup
/*     */     //   319: ldc_w 'entity'
/*     */     //   322: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   325: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   328: fload_3
/*     */     //   329: iconst_1
/*     */     //   330: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   335: pop
/*     */     //   336: goto -> 286
/*     */     //   339: aload #5
/*     */     //   341: aload #8
/*     */     //   343: fload #6
/*     */     //   345: fconst_1
/*     */     //   346: invokevirtual stopDraw : (Ljava/awt/Color;FF)V
/*     */     //   349: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader.OUTLINE_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader;
/*     */     //   352: dup
/*     */     //   353: ldc_w 'OutlineShader.OUTLINE_SHADER'
/*     */     //   356: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   359: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   362: astore #5
/*     */     //   364: ldc_w 1.2
/*     */     //   367: fstore #6
/*     */     //   369: new java/awt/Color
/*     */     //   372: dup
/*     */     //   373: sipush #255
/*     */     //   376: sipush #255
/*     */     //   379: sipush #255
/*     */     //   382: sipush #170
/*     */     //   385: invokespecial <init> : (IIII)V
/*     */     //   388: astore #7
/*     */     //   390: new java/awt/Color
/*     */     //   393: dup
/*     */     //   394: sipush #255
/*     */     //   397: iconst_0
/*     */     //   398: iconst_0
/*     */     //   399: sipush #170
/*     */     //   402: invokespecial <init> : (IIII)V
/*     */     //   405: astore #8
/*     */     //   407: iconst_0
/*     */     //   408: istore #9
/*     */     //   410: iinc #10, 1
/*     */     //   413: goto -> 128
/*     */     //   416: return
/*     */     //   417: aload_2
/*     */     //   418: astore #5
/*     */     //   420: aload #5
/*     */     //   422: invokevirtual hashCode : ()I
/*     */     //   425: lookupswitch default -> 498, -1682647875 -> 452, -1310952718 -> 466
/*     */     //   452: aload #5
/*     */     //   454: ldc_w 'shaderoutline'
/*     */     //   457: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   460: ifeq -> 498
/*     */     //   463: goto -> 480
/*     */     //   466: aload #5
/*     */     //   468: ldc_w 'shaderglow'
/*     */     //   471: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   474: ifeq -> 498
/*     */     //   477: goto -> 489
/*     */     //   480: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader.OUTLINE_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/OutlineShader;
/*     */     //   483: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   486: goto -> 499
/*     */     //   489: getstatic net/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader.GLOW_SHADER : Lnet/ccbluex/liquidbounce/utils/render/shader/shaders/GlowShader;
/*     */     //   492: checkcast net/ccbluex/liquidbounce/utils/render/shader/FramebufferShader
/*     */     //   495: goto -> 499
/*     */     //   498: return
/*     */     //   499: astore #4
/*     */     //   501: aload_2
/*     */     //   502: astore #6
/*     */     //   504: aload #6
/*     */     //   506: invokevirtual hashCode : ()I
/*     */     //   509: lookupswitch default -> 596, -1682647875 -> 536, -1310952718 -> 550
/*     */     //   536: aload #6
/*     */     //   538: ldc_w 'shaderoutline'
/*     */     //   541: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   544: ifeq -> 596
/*     */     //   547: goto -> 564
/*     */     //   550: aload #6
/*     */     //   552: ldc_w 'shaderglow'
/*     */     //   555: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   558: ifeq -> 596
/*     */     //   561: goto -> 580
/*     */     //   564: aload_0
/*     */     //   565: getfield shaderOutlineRadiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   568: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   571: checkcast java/lang/Number
/*     */     //   574: invokevirtual floatValue : ()F
/*     */     //   577: goto -> 597
/*     */     //   580: aload_0
/*     */     //   581: getfield shaderGlowRadiusValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   584: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   587: checkcast java/lang/Number
/*     */     //   590: invokevirtual floatValue : ()F
/*     */     //   593: goto -> 597
/*     */     //   596: fconst_1
/*     */     //   597: fstore #5
/*     */     //   599: new java/util/HashMap
/*     */     //   602: dup
/*     */     //   603: invokespecial <init> : ()V
/*     */     //   606: checkcast java/util/Map
/*     */     //   609: astore #6
/*     */     //   611: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   614: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   619: dup
/*     */     //   620: ifnonnull -> 626
/*     */     //   623: invokestatic throwNpe : ()V
/*     */     //   626: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   631: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   636: astore #8
/*     */     //   638: aload #8
/*     */     //   640: invokeinterface hasNext : ()Z
/*     */     //   645: ifeq -> 746
/*     */     //   648: aload #8
/*     */     //   650: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   655: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   658: astore #7
/*     */     //   660: aload #7
/*     */     //   662: iconst_0
/*     */     //   663: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   666: ifeq -> 743
/*     */     //   669: aload #7
/*     */     //   671: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   676: astore #9
/*     */     //   678: aload_0
/*     */     //   679: aload #9
/*     */     //   681: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   684: invokevirtual getColor : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)Ljava/awt/Color;
/*     */     //   687: astore #10
/*     */     //   689: aload #6
/*     */     //   691: aload #10
/*     */     //   693: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*     */     //   698: ifne -> 718
/*     */     //   701: aload #6
/*     */     //   703: aload #10
/*     */     //   705: new java/util/ArrayList
/*     */     //   708: dup
/*     */     //   709: invokespecial <init> : ()V
/*     */     //   712: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   717: pop
/*     */     //   718: aload #6
/*     */     //   720: aload #10
/*     */     //   722: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   727: dup
/*     */     //   728: ifnonnull -> 734
/*     */     //   731: invokestatic throwNpe : ()V
/*     */     //   734: checkcast java/util/ArrayList
/*     */     //   737: aload #9
/*     */     //   739: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   742: pop
/*     */     //   743: goto -> 638
/*     */     //   746: aload #6
/*     */     //   748: astore #9
/*     */     //   750: iconst_0
/*     */     //   751: istore #10
/*     */     //   753: aload #9
/*     */     //   755: invokeinterface entrySet : ()Ljava/util/Set;
/*     */     //   760: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   765: astore #8
/*     */     //   767: aload #8
/*     */     //   769: invokeinterface hasNext : ()Z
/*     */     //   774: ifeq -> 906
/*     */     //   777: aload #8
/*     */     //   779: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   784: checkcast java/util/Map$Entry
/*     */     //   787: astore #7
/*     */     //   789: aload #7
/*     */     //   791: astore #11
/*     */     //   793: iconst_0
/*     */     //   794: istore #12
/*     */     //   796: aload #11
/*     */     //   798: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   803: checkcast java/awt/Color
/*     */     //   806: astore #9
/*     */     //   808: aload #7
/*     */     //   810: astore #11
/*     */     //   812: iconst_0
/*     */     //   813: istore #12
/*     */     //   815: aload #11
/*     */     //   817: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   822: checkcast java/util/ArrayList
/*     */     //   825: astore #10
/*     */     //   827: aload #4
/*     */     //   829: fload_3
/*     */     //   830: invokevirtual startDraw : (F)V
/*     */     //   833: aload #10
/*     */     //   835: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   838: astore #12
/*     */     //   840: aload #12
/*     */     //   842: invokeinterface hasNext : ()Z
/*     */     //   847: ifeq -> 893
/*     */     //   850: aload #12
/*     */     //   852: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   857: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase
/*     */     //   860: astore #11
/*     */     //   862: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   865: invokeinterface getRenderManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/renderer/entity/IRenderManager;
/*     */     //   870: aload #11
/*     */     //   872: dup
/*     */     //   873: ldc_w 'entity'
/*     */     //   876: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   879: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   882: fload_3
/*     */     //   883: iconst_1
/*     */     //   884: invokeinterface renderEntityStatic : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;FZ)Z
/*     */     //   889: pop
/*     */     //   890: goto -> 840
/*     */     //   893: aload #4
/*     */     //   895: aload #9
/*     */     //   897: fload #5
/*     */     //   899: fconst_1
/*     */     //   900: invokevirtual stopDraw : (Ljava/awt/Color;FF)V
/*     */     //   903: goto -> 767
/*     */     //   906: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #767	-> 7
/*     */     //   #767	-> 45
/*     */     //   #768	-> 46
/*     */     //   #770	-> 51
/*     */     //   #771	-> 62
/*     */     //   #772	-> 71
/*     */     //   #773	-> 86
/*     */     //   #774	-> 91
/*     */     //   #775	-> 106
/*     */     //   #776	-> 119
/*     */     //   #778	-> 122
/*     */     //   #779	-> 135
/*     */     //   #780	-> 141
/*     */     //   #781	-> 190
/*     */     //   #782	-> 199
/*     */     //   #783	-> 208
/*     */     //   #784	-> 223
/*     */     //   #785	-> 231
/*     */     //   #787	-> 234
/*     */     //   #780	-> 252
/*     */     //   #790	-> 255
/*     */     //   #793	-> 265
/*     */     //   #794	-> 273
/*     */     //   #795	-> 279
/*     */     //   #796	-> 308
/*     */     //   #795	-> 336
/*     */     //   #798	-> 339
/*     */     //   #800	-> 349
/*     */     //   #801	-> 364
/*     */     //   #802	-> 369
/*     */     //   #803	-> 390
/*     */     //   #804	-> 407
/*     */     //   #778	-> 410
/*     */     //   #806	-> 416
/*     */     //   #810	-> 417
/*     */     //   #811	-> 452
/*     */     //   #812	-> 466
/*     */     //   #811	-> 480
/*     */     //   #812	-> 489
/*     */     //   #813	-> 498
/*     */     //   #810	-> 499
/*     */     //   #815	-> 501
/*     */     //   #816	-> 536
/*     */     //   #817	-> 550
/*     */     //   #816	-> 564
/*     */     //   #817	-> 580
/*     */     //   #818	-> 596
/*     */     //   #815	-> 597
/*     */     //   #822	-> 599
/*     */     //   #823	-> 611
/*     */     //   #824	-> 660
/*     */     //   #825	-> 669
/*     */     //   #826	-> 678
/*     */     //   #827	-> 689
/*     */     //   #828	-> 701
/*     */     //   #830	-> 718
/*     */     //   #823	-> 743
/*     */     //   #835	-> 746
/*     */     //   #835	-> 803
/*     */     //   #835	-> 822
/*     */     //   #836	-> 827
/*     */     //   #837	-> 833
/*     */     //   #838	-> 862
/*     */     //   #837	-> 890
/*     */     //   #840	-> 893
/*     */     //   #835	-> 903
/*     */     //   #842	-> 906
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   208	44	14	entityLivingBase	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   190	62	12	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   308	28	12	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   135	278	10	i	I
/*     */     //   122	295	9	firstRun	Z
/*     */     //   119	298	8	hurtColor	Ljava/awt/Color;
/*     */     //   106	311	7	color	Ljava/awt/Color;
/*     */     //   91	326	6	radius	F
/*     */     //   86	331	5	shader	Lnet/ccbluex/liquidbounce/utils/render/shader/FramebufferShader;
/*     */     //   71	346	4	hurtingEntities	Ljava/util/ArrayList;
/*     */     //   689	54	10	color	Ljava/awt/Color;
/*     */     //   678	65	9	entityLiving	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   660	83	7	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   862	28	11	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   827	76	10	value	Ljava/util/ArrayList;
/*     */     //   827	76	9	key	Ljava/awt/Color;
/*     */     //   611	296	6	entityMap	Ljava/util/Map;
/*     */     //   599	308	5	radius	F
/*     */     //   501	406	4	shader	Lnet/ccbluex/liquidbounce/utils/render/shader/FramebufferShader;
/*     */     //   51	856	3	partialTicks	F
/*     */     //   46	861	2	mode	Ljava/lang/String;
/*     */     //   0	907	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP2;
/*     */     //   0	907	1	event	Lnet/ccbluex/liquidbounce/event/Render2DEvent;
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
/*     */   @NotNull
/*     */   public String getTag() {
/* 845 */     return (String)this.modeValue.get();
/*     */   } @NotNull
/*     */   public final Color getColor(@NotNull IEntity entity) {
/* 848 */     Intrinsics.checkParameterIsNotNull(entity, "entity"); if (MinecraftInstance.classProvider.isEntityLivingBase(entity)) {
/* 849 */       if (entity.asEntityLivingBase().getHurtTime() > 0) { Intrinsics.checkExpressionValueIsNotNull(Color.RED, "Color.RED"); return Color.RED; }
/* 850 */        if (EntityUtils.isFriend(entity)) { Intrinsics.checkExpressionValueIsNotNull(Color.BLUE, "Color.BLUE"); return Color.BLUE; }
/* 851 */        if (Intrinsics.areEqual(this.colorModeValue.get(), "Name")) {
/* 852 */         if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String str = entity.getDisplayName().getFormattedText(); int i = 0; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toCharArray(), "(this as java.lang.String).toCharArray()"); char[] chars = str.toCharArray();
/* 853 */         for (byte b = 0; b < i; b++) {
/* 854 */           if (chars[b] == '§' && b + 1 < chars.length)
/* 855 */           { int index = GameFontRenderer.Companion.getColorIndex(chars[b + 1]);
/* 856 */             if (index >= 0 && index <= 15)
/* 857 */               return new Color(ColorUtils.hexColors[index]);  } 
/*     */         } 
/* 859 */       } else if (Intrinsics.areEqual(this.colorModeValue.get(), "Armor") && 
/* 860 */         entity instanceof IEntityPlayer) {
/* 861 */         if ((IItemStack)((IEntityPlayer)entity).getInventory().getArmorInventory().get(3) != null) { IItemStack entityHead = (IItemStack)((IEntityPlayer)entity).getInventory().getArmorInventory().get(3);
/* 862 */           if (MinecraftInstance.classProvider.isEntityPlayer(entityHead)) {
/* 863 */             if (entityHead.getItem() == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.api.minecraft.item.IItemArmor");  IItemArmor entityItemArmor = (IItemArmor)entityHead.getItem();
/* 864 */             return new Color(entityItemArmor.getColor(entityHead));
/*     */           }  }
/*     */         else { (IItemStack)((IEntityPlayer)entity).getInventory().getArmorInventory().get(3); return new Color(2147483647); }
/*     */       
/*     */       } 
/* 869 */     }  return ((Boolean)this.colorRainbowValue.get()).booleanValue() ? ColorUtils.rainbow() : new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue());
/*     */   } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000¨\006\005"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ESP2$Companion;", "", "()V", "renderNameTags", "", "XSJClient"})
/*     */   public static final class Companion {
/*     */     private Companion() {} }
/* 873 */   public static final Companion Companion = new Companion(null); static { renderNameTags = true; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ESP2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */