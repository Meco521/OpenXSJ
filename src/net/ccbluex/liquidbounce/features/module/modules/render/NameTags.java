/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.ui.font.FontLoaders;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.ColorUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "NameTags", description = "Changes the scale of the nametags so you can always read them.", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\020\b\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\024\032\0020\0252\006\020\026\032\0020\027H\007J\030\020\030\032\0020\0252\006\020\031\032\0020\0322\006\020\033\032\0020\034H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\004X\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\f0\013X\004¢\006\002\n\000R\024\020\r\032\b\022\004\022\0020\0160\013X\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\004X\004¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "armorValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "borderValue", "botValue", "clearNamesValue", "distanceValue", "healthValue", "jelloAlphaValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "jelloColorValue", "", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "pingValue", "scaleValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renderNameTag", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "tag", "", "XSJClient"})
/*     */ public final class NameTags extends Module {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class NameTags$jelloColorValue$1 extends Lambda implements Function0<Boolean> { NameTags$jelloColorValue$1() {
/*     */       super(0);
/*     */     }
/*     */     
/*  38 */     public final boolean invoke() { return NameTags.this.modeValue.equals("Jello"); } } @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  39 */   static final class NameTags$jelloAlphaValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { return NameTags.this.modeValue.equals("Jello"); } NameTags$jelloAlphaValue$1() { super(0); } } private final ListValue modeValue = new ListValue("Mode", new String[] { "Simple", "Liquid", "Jello" }, "Liquid"); private final BoolValue healthValue = new BoolValue("Health", true); private final Value<Integer> jelloAlphaValue = (new IntegerValue("Alpha", 170, 0, 255)).displayable(new NameTags$jelloAlphaValue$1());
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue pingValue = new BoolValue("Ping", true);
/*     */ 
/*     */   
/*     */   private final BoolValue botValue = new BoolValue("Bots", true);
/*     */ 
/*     */   
/*     */   private final BoolValue distanceValue = new BoolValue("Distance", false);
/*     */ 
/*     */   
/*     */   private final BoolValue armorValue = new BoolValue("Armor", true);
/*     */ 
/*     */   
/*     */   private final BoolValue clearNamesValue = new BoolValue("ClearNames", false);
/*     */ 
/*     */   
/*     */   private final BoolValue borderValue = new BoolValue("Border", true);
/*     */ 
/*     */   
/*     */   private final FloatValue scaleValue = new FloatValue("Scale", 1.0F, 1.0F, 4.0F);
/*     */ 
/*     */   
/*     */   private final Value<Boolean> jelloColorValue = (new BoolValue("JelloHPColor", true)).displayable(new NameTags$jelloColorValue$1());
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender3D(@NotNull Render3DEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: sipush #8192
/*     */     //   9: invokestatic glPushAttrib : (I)V
/*     */     //   12: invokestatic glPushMatrix : ()V
/*     */     //   15: sipush #2896
/*     */     //   18: invokestatic glDisable : (I)V
/*     */     //   21: sipush #2929
/*     */     //   24: invokestatic glDisable : (I)V
/*     */     //   27: sipush #2848
/*     */     //   30: invokestatic glEnable : (I)V
/*     */     //   33: sipush #3042
/*     */     //   36: invokestatic glEnable : (I)V
/*     */     //   39: sipush #770
/*     */     //   42: sipush #771
/*     */     //   45: invokestatic glBlendFunc : (II)V
/*     */     //   48: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   51: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   56: dup
/*     */     //   57: ifnonnull -> 63
/*     */     //   60: invokestatic throwNpe : ()V
/*     */     //   63: invokeinterface getLoadedEntityList : ()Ljava/util/Collection;
/*     */     //   68: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   73: astore_3
/*     */     //   74: aload_3
/*     */     //   75: invokeinterface hasNext : ()Z
/*     */     //   80: ifeq -> 224
/*     */     //   83: aload_3
/*     */     //   84: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   89: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   92: astore_2
/*     */     //   93: aload_2
/*     */     //   94: iconst_0
/*     */     //   95: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   98: ifne -> 104
/*     */     //   101: goto -> 221
/*     */     //   104: aload_2
/*     */     //   105: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   110: invokestatic isBot : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)Z
/*     */     //   113: ifeq -> 135
/*     */     //   116: aload_0
/*     */     //   117: getfield botValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   120: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   123: checkcast java/lang/Boolean
/*     */     //   126: invokevirtual booleanValue : ()Z
/*     */     //   129: ifne -> 135
/*     */     //   132: goto -> 221
/*     */     //   135: aload_0
/*     */     //   136: aload_2
/*     */     //   137: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   142: aload_0
/*     */     //   143: getfield clearNamesValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   146: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   149: checkcast java/lang/Boolean
/*     */     //   152: invokevirtual booleanValue : ()Z
/*     */     //   155: ifeq -> 194
/*     */     //   158: aload_2
/*     */     //   159: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   164: dup
/*     */     //   165: ifnull -> 176
/*     */     //   168: invokeinterface getUnformattedText : ()Ljava/lang/String;
/*     */     //   173: goto -> 178
/*     */     //   176: pop
/*     */     //   177: aconst_null
/*     */     //   178: invokestatic stripColor : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   181: dup
/*     */     //   182: ifnull -> 188
/*     */     //   185: goto -> 218
/*     */     //   188: pop
/*     */     //   189: pop
/*     */     //   190: pop
/*     */     //   191: goto -> 221
/*     */     //   194: aload_2
/*     */     //   195: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   200: dup
/*     */     //   201: ifnull -> 207
/*     */     //   204: goto -> 213
/*     */     //   207: pop
/*     */     //   208: pop
/*     */     //   209: pop
/*     */     //   210: goto -> 221
/*     */     //   213: invokeinterface getUnformattedText : ()Ljava/lang/String;
/*     */     //   218: invokespecial renderNameTag : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;Ljava/lang/String;)V
/*     */     //   221: goto -> 74
/*     */     //   224: invokestatic glPopMatrix : ()V
/*     */     //   227: invokestatic glPopAttrib : ()V
/*     */     //   230: fconst_1
/*     */     //   231: fconst_1
/*     */     //   232: fconst_1
/*     */     //   233: fconst_1
/*     */     //   234: invokestatic glColor4f : (FFFF)V
/*     */     //   237: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #43	-> 6
/*     */     //   #44	-> 12
/*     */     //   #47	-> 15
/*     */     //   #48	-> 21
/*     */     //   #50	-> 27
/*     */     //   #53	-> 33
/*     */     //   #54	-> 39
/*     */     //   #56	-> 48
/*     */     //   #57	-> 93
/*     */     //   #58	-> 104
/*     */     //   #60	-> 135
/*     */     //   #61	-> 142
/*     */     //   #62	-> 158
/*     */     //   #62	-> 188
/*     */     //   #64	-> 194
/*     */     //   #64	-> 207
/*     */     //   #61	-> 218
/*     */     //   #60	-> 218
/*     */     //   #56	-> 221
/*     */     //   #68	-> 224
/*     */     //   #69	-> 227
/*     */     //   #72	-> 230
/*     */     //   #73	-> 237
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   93	128	2	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   0	238	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags;
/*     */     //   0	238	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final void renderNameTag(IEntityLivingBase entity, String tag) {
/*  76 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */ 
/*     */       
/*  79 */       boolean bot = AntiBot.isBot(entity);
/*  80 */       String nameColor = bot ? "§3" : (entity.isInvisible() ? "§6" : (entity.isSneaking() ? "§4" : "§7"));
/*  81 */       int ping = MinecraftInstance.classProvider.isEntityPlayer(entity) ? EntityUtils.getPing(entity.asEntityPlayer()) : 0;
/*     */       
/*  83 */       String distanceText = ((Boolean)this.distanceValue.get()).booleanValue() ? ("§7" + MathKt.roundToInt(thePlayer.getDistanceToEntity((IEntity)entity)) + "m ") : "";
/*  84 */       String pingText = 
/*  85 */         (((Boolean)this.pingValue.get()).booleanValue() && MinecraftInstance.classProvider.isEntityPlayer(entity)) ? (((ping > 200) ? "§c" : ((ping > 100) ? "§e" : "§a")) + ping + "ms §7") : "";
/*  86 */       String healthText = ((Boolean)this.healthValue.get()).booleanValue() ? ("§7§c " + (int)entity.getHealth() + " HP") : "";
/*  87 */       String botText = bot ? " §c§lBot" : "";
/*     */       
/*  89 */       String text = distanceText + pingText + nameColor + tag + healthText + botText;
/*     */ 
/*     */       
/*  92 */       GL11.glPushMatrix();
/*     */ 
/*     */       
/*  95 */       ITimer timer = MinecraftInstance.mc.getTimer();
/*  96 */       IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/*     */ 
/*     */       
/*  99 */       GL11.glTranslated(
/* 100 */           entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX(), 
/* 101 */           entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY() + entity.getEyeHeight() + 0.55D, 
/* 102 */           entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ());
/*     */ 
/*     */       
/* 105 */       GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 106 */       GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */       
/* 110 */       float distance = thePlayer.getDistanceToEntity((IEntity)entity) * 0.25F;
/*     */       
/* 112 */       if (distance < 1.0F) {
/* 113 */         distance = 1.0F;
/*     */       }
/* 115 */       float scale = distance / 100.0F * ((Number)this.scaleValue.get()).floatValue();
/*     */       
/* 117 */       GL11.glScalef(-scale, -scale, scale);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 122 */       float width = Fonts.misans40.getStringWidth(text) * 0.5F;
/*     */       
/* 124 */       GL11.glDisable(3553);
/* 125 */       GL11.glEnable(3042);
/* 126 */       String str1 = (String)this.modeValue.get(); boolean bool = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str1 = str1.toLowerCase(); switch (str1.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 101009364:
/* 215 */           if (str1.equals("jello")) {
/*     */             
/* 217 */             Color color1 = new Color(255, 255, 255, ((Number)this.jelloAlphaValue.get()).intValue());
/* 218 */             if (entity.getDisplayName() == null) Intrinsics.throwNpe();  String name = entity.getDisplayName().getUnformattedText();
/* 219 */             if (((Boolean)this.jelloColorValue.get()).booleanValue() && StringsKt.startsWith$default(name, "§", false, 2, null)) {
/* 220 */               String str2 = name; boolean bool1 = true; byte b = 2; ColorUtils colorUtils = ColorUtils.INSTANCE; boolean bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.substring(bool1, b), "(this as java.lang.Strin…ing(startIndex, endIndex)"); String str3 = str2.substring(bool1, b); color1 = colorUtils.colorCode(str3, ((Number)this.jelloAlphaValue.get()).intValue());
/*     */             } 
/* 222 */             Color bgColor = new Color(20, 20, 20, ((Number)this.jelloAlphaValue.get()).intValue());
/* 223 */             int i = FontLoaders.F18.getStringWidth(tag) / 2;
/* 224 */             float maxWidth = i + 4.0F - -i - 4.0F;
/* 225 */             float healthPercent = entity.getHealth() / entity.getMaxHealth();
/*     */ 
/*     */ 
/*     */             
/* 229 */             RenderUtils.quickDrawRect(-i - 4.0F, -Fonts.newtenacity40.getFontHeight() * 3.0F, i + 4.0F, -3.0F, bgColor.getRGB());
/*     */ 
/*     */             
/* 232 */             if (healthPercent > true) {
/* 233 */               healthPercent = 1.0F;
/*     */             }
/*     */             
/* 236 */             RenderUtils.quickDrawRect(-i - 4.0F, -3.0F, -i - 4.0F + maxWidth * healthPercent, 0.0F, color1.getRGB());
/* 237 */             RenderUtils.quickDrawRect(-i - 4.0F + maxWidth * healthPercent, -3.0F, i + 4.0F, 0.0F, bgColor.getRGB());
/*     */             
/* 239 */             GL11.glEnable(3553);
/*     */ 
/*     */             
/* 242 */             Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); FontLoaders.F18.drawStringWithShadow(tag, -i + 1.0F, ((-FontLoaders.F18.FONT_HEIGHT * 2) + 16.0F), Color.WHITE.getRGB());
/* 243 */             GL11.glScalef(0.5F, 0.5F, 0.5F);
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 248 */             Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE"); Fonts.newtenacity40.drawString("Health: " + (int)entity.getHealth(), -i * 2, -Fonts.newtenacity40.getFontHeight() * 2, Color.WHITE.getRGB());
/*     */ 
/*     */             
/* 251 */             if (((Boolean)this.armorValue.get()).booleanValue() && MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/* 252 */               MinecraftInstance.mc.getRenderItem().setZLevel(-147.0F);
/*     */               
/* 254 */               int[] indices = {
/*     */                   
/* 256 */                   0, 
/* 257 */                   1, 
/* 258 */                   2, 
/* 259 */                   3, 
/* 260 */                   5, 
/* 261 */                   4
/*     */                 };
/*     */               
/* 264 */               for (int index : indices) {
/* 265 */                 if (entity.getEquipmentInSlot(index) != null) { IItemStack equipmentInSlot = entity.getEquipmentInSlot(index);
/*     */                   
/* 267 */                   MinecraftInstance.mc.getRenderItem().renderItemAndEffectIntoGUI(equipmentInSlot, -50 + index * 20, -22); }
/*     */                 else { entity.getEquipmentInSlot(index); }
/*     */               
/* 270 */               }  GlStateManager.func_179141_d();
/* 271 */               GlStateManager.func_179084_k();
/* 272 */               GlStateManager.func_179098_w();
/*     */             } 
/*     */ 
/*     */             
/* 276 */             GL11.glPopMatrix();
/*     */           } 
/*     */           break;
/*     */         case -1102567108:
/*     */           if (str1.equals("liquid")) {
/*     */             if (((Boolean)this.borderValue.get()).booleanValue()) {
/*     */               RenderUtils.quickDrawBorderedRect(-width - 2.0F, -2.0F, width + 4.0F, Fonts.newtenacity40.getFontHeight() + 2.0F, 2.0F, (new Color(255, 255, 255, 90)).getRGB(), -2147483648);
/*     */             } else {
/*     */               RenderUtils.quickDrawRect(-width - 2.0F, -2.0F, width + 4.0F, Fonts.newtenacity40.getFontHeight() + 2.0F, -2147483648);
/*     */             } 
/*     */             GL11.glEnable(3553);
/*     */             Fonts.newtenacity40.drawString(text, 1.0F + -width, Intrinsics.areEqual(Fonts.newtenacity40, Fonts.newtenacity40) ? 1.0F : 1.5F, 16777215, true);
/*     */             if (((Boolean)this.armorValue.get()).booleanValue() && MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/*     */               MinecraftInstance.mc.getRenderItem().setZLevel(-147.0F);
/*     */               int[] arrayOfInt = { 0, 1, 2, 3, 5, 4 };
/*     */               for (int index : arrayOfInt) {
/*     */                 if (entity.getEquipmentInSlot(index) != null) {
/*     */                   IItemStack iItemStack = entity.getEquipmentInSlot(index);
/*     */                   MinecraftInstance.mc.getRenderItem().renderItemAndEffectIntoGUI(iItemStack, -50 + index * 20, -22);
/*     */                 } else {
/*     */                   entity.getEquipmentInSlot(index);
/*     */                 } 
/*     */               } 
/*     */               GlStateManager.func_179141_d();
/*     */               GlStateManager.func_179084_k();
/*     */               GlStateManager.func_179098_w();
/*     */             } 
/*     */             GL11.glPopMatrix();
/*     */           } 
/*     */           break;
/*     */         case -902286926:
/*     */           if (str1.equals("simple")) {
/*     */             float f1 = RangesKt.coerceAtMost(entity.getHealth() / entity.getMaxHealth(), 1.0F);
/*     */             int i = RangesKt.coerceAtLeast(FontLoaders.nt18.getStringWidth(tag), 30) / 2;
/*     */             float f2 = (i * 2) + 12.0F;
/*     */             RenderUtils.quickDrawRect(-i - 6.0F, -Fonts.newtenacity40.getFontHeight() * 1.7F, i + 6.0F, -2.0F, (new Color(0, 0, 0, ((Number)this.jelloAlphaValue.get()).intValue())).getRGB());
/*     */             RenderUtils.quickDrawRect(-i - 6.0F, -2.0F, -i - 6.0F + f2 * f1, 0.0F, (new Color(((Number)AColorPalette.r.get()).intValue(), ((Number)AColorPalette.g.get()).intValue(), ((Number)AColorPalette.b.get()).intValue())).getRGB());
/*     */             RenderUtils.quickDrawRect(-i - 6.0F + f2 * f1, -2.0F, i + 6.0F, 0.0F, (new Color(0, 0, 0, ((Number)this.jelloAlphaValue.get()).intValue())).getRGB());
/*     */             GL11.glEnable(3553);
/*     */             Intrinsics.checkExpressionValueIsNotNull(Color.WHITE, "Color.WHITE");
/*     */             FontLoaders.nt18.drawStringWithShadow(tag, (int)(-FontLoaders.nt18.getStringWidth(tag) * 0.5F) + true, (int)(-Fonts.newtenacity40.getFontHeight() * 1.4F), Color.WHITE.getRGB());
/*     */             GL11.glPopMatrix();
/*     */           } 
/*     */           break;
/*     */       } 
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\NameTags.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */