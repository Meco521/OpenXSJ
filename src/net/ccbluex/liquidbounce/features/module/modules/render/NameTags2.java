/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.renderer.entity.IRenderManager;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.ITimer;
/*     */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*     */ import net.ccbluex.liquidbounce.ui.font.AWTFontRenderer;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.FontValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @ModuleInfo(name = "NameTags2", description = "Changes the scale of the nametags so you can always read them.", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\016\032\0020\0172\006\020\020\032\0020\021H\007J\030\020\022\032\0020\0172\006\020\023\032\0020\0242\006\020\025\032\0020\026H\002R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\004X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000¨\006\027"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags2;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "armorValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "borderValue", "clearNamesValue", "distanceValue", "fontValue", "Lnet/ccbluex/liquidbounce/value/FontValue;", "healthValue", "pingValue", "scaleValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "onRender3D", "", "event", "Lnet/ccbluex/liquidbounce/event/Render3DEvent;", "renderNameTag", "entity", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "tag", "", "XSJClient"})
/*     */ public final class NameTags2 extends Module {
/*     */   public NameTags2() {
/*  27 */     this.healthValue = new BoolValue("Health", true);
/*  28 */     this.pingValue = new BoolValue("Ping", true);
/*  29 */     this.distanceValue = new BoolValue("Distance", false);
/*  30 */     this.armorValue = new BoolValue("Armor", true);
/*  31 */     this.clearNamesValue = new BoolValue("ClearNames", false);
/*  32 */     Intrinsics.checkExpressionValueIsNotNull(Fonts.roboto40, "Fonts.roboto40"); this.fontValue = new FontValue("Font", Fonts.roboto40);
/*  33 */     this.borderValue = new BoolValue("Border", true);
/*  34 */     this.scaleValue = new FloatValue("Scale", 1.0F, 1.0F, 4.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final BoolValue healthValue;
/*     */ 
/*     */   
/*     */   private final BoolValue pingValue;
/*     */ 
/*     */   
/*     */   private final BoolValue distanceValue;
/*     */ 
/*     */   
/*     */   private final BoolValue armorValue;
/*     */ 
/*     */   
/*     */   private final BoolValue clearNamesValue;
/*     */ 
/*     */   
/*     */   private final FontValue fontValue;
/*     */ 
/*     */   
/*     */   private final BoolValue borderValue;
/*     */ 
/*     */   
/*     */   private final FloatValue scaleValue;
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
/*     */     //   80: ifeq -> 193
/*     */     //   83: aload_3
/*     */     //   84: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   89: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   92: astore_2
/*     */     //   93: aload_2
/*     */     //   94: iconst_0
/*     */     //   95: invokestatic isSelected : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Z)Z
/*     */     //   98: ifne -> 104
/*     */     //   101: goto -> 190
/*     */     //   104: aload_0
/*     */     //   105: aload_2
/*     */     //   106: invokeinterface asEntityLivingBase : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   111: aload_0
/*     */     //   112: getfield clearNamesValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   115: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   118: checkcast java/lang/Boolean
/*     */     //   121: invokevirtual booleanValue : ()Z
/*     */     //   124: ifeq -> 163
/*     */     //   127: aload_2
/*     */     //   128: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   133: dup
/*     */     //   134: ifnull -> 145
/*     */     //   137: invokeinterface getUnformattedText : ()Ljava/lang/String;
/*     */     //   142: goto -> 147
/*     */     //   145: pop
/*     */     //   146: aconst_null
/*     */     //   147: invokestatic stripColor : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   150: dup
/*     */     //   151: ifnull -> 157
/*     */     //   154: goto -> 187
/*     */     //   157: pop
/*     */     //   158: pop
/*     */     //   159: pop
/*     */     //   160: goto -> 190
/*     */     //   163: aload_2
/*     */     //   164: invokeinterface getDisplayName : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IIChatComponent;
/*     */     //   169: dup
/*     */     //   170: ifnull -> 176
/*     */     //   173: goto -> 182
/*     */     //   176: pop
/*     */     //   177: pop
/*     */     //   178: pop
/*     */     //   179: goto -> 190
/*     */     //   182: invokeinterface getUnformattedText : ()Ljava/lang/String;
/*     */     //   187: invokespecial renderNameTag : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;Ljava/lang/String;)V
/*     */     //   190: goto -> 74
/*     */     //   193: invokestatic glPopMatrix : ()V
/*     */     //   196: invokestatic glPopAttrib : ()V
/*     */     //   199: fconst_1
/*     */     //   200: fconst_1
/*     */     //   201: fconst_1
/*     */     //   202: fconst_1
/*     */     //   203: invokestatic glColor4f : (FFFF)V
/*     */     //   206: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #38	-> 6
/*     */     //   #39	-> 12
/*     */     //   #42	-> 15
/*     */     //   #43	-> 21
/*     */     //   #45	-> 27
/*     */     //   #48	-> 33
/*     */     //   #49	-> 39
/*     */     //   #51	-> 48
/*     */     //   #52	-> 93
/*     */     //   #53	-> 101
/*     */     //   #55	-> 104
/*     */     //   #56	-> 111
/*     */     //   #57	-> 127
/*     */     //   #57	-> 157
/*     */     //   #59	-> 163
/*     */     //   #59	-> 176
/*     */     //   #56	-> 187
/*     */     //   #55	-> 187
/*     */     //   #51	-> 190
/*     */     //   #63	-> 193
/*     */     //   #64	-> 196
/*     */     //   #67	-> 199
/*     */     //   #68	-> 206
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   93	97	2	entity	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   0	207	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/render/NameTags2;
/*     */     //   0	207	1	event	Lnet/ccbluex/liquidbounce/event/Render3DEvent;
/*     */   }
/*     */ 
/*     */   
/*     */   private final void renderNameTag(IEntityLivingBase entity, String tag) {
/*  71 */     if (MinecraftInstance.mc.getThePlayer() != null) { IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */       
/*  73 */       IFontRenderer fontRenderer = (IFontRenderer)this.fontValue.get();
/*     */ 
/*     */       
/*  76 */       boolean bot = AntiBot.isBot(entity);
/*  77 */       String nameColor = bot ? "§3" : (entity.isInvisible() ? "§6" : (entity.isSneaking() ? "§4" : "§7"));
/*  78 */       int ping = MinecraftInstance.classProvider.isEntityPlayer(entity) ? EntityUtils.getPing(entity.asEntityPlayer()) : 0;
/*     */       
/*  80 */       String distanceText = ((Boolean)this.distanceValue.get()).booleanValue() ? ("§7" + MathKt.roundToInt(thePlayer.getDistanceToEntity((IEntity)entity)) + "m ") : "";
/*  81 */       String pingText = (((Boolean)this.pingValue.get()).booleanValue() && MinecraftInstance.classProvider.isEntityPlayer(entity)) ? (((ping > 200) ? "§c" : ((ping > 100) ? "§e" : "§a")) + ping + "ms §7") : "";
/*  82 */       String healthText = ((Boolean)this.healthValue.get()).booleanValue() ? ("§7§c " + (int)entity.getHealth() + " HP") : "";
/*  83 */       String botText = bot ? " §c§lBot" : "";
/*     */       
/*  85 */       String text = distanceText + pingText + nameColor + tag + healthText + botText;
/*     */ 
/*     */       
/*  88 */       GL11.glPushMatrix();
/*     */ 
/*     */       
/*  91 */       ITimer timer = MinecraftInstance.mc.getTimer();
/*  92 */       IRenderManager renderManager = MinecraftInstance.mc.getRenderManager();
/*     */ 
/*     */       
/*  95 */       GL11.glTranslated(
/*  96 */           entity.getLastTickPosX() + (entity.getPosX() - entity.getLastTickPosX()) * timer.getRenderPartialTicks() - renderManager.getRenderPosX(), 
/*  97 */           entity.getLastTickPosY() + (entity.getPosY() - entity.getLastTickPosY()) * timer.getRenderPartialTicks() - renderManager.getRenderPosY() + entity.getEyeHeight() + 0.55D, 
/*  98 */           entity.getLastTickPosZ() + (entity.getPosZ() - entity.getLastTickPosZ()) * timer.getRenderPartialTicks() - renderManager.getRenderPosZ());
/*     */ 
/*     */       
/* 101 */       GL11.glRotatef(-MinecraftInstance.mc.getRenderManager().getPlayerViewY(), 0.0F, 1.0F, 0.0F);
/* 102 */       GL11.glRotatef(MinecraftInstance.mc.getRenderManager().getPlayerViewX(), 1.0F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */       
/* 106 */       float distance = thePlayer.getDistanceToEntity((IEntity)entity) * 0.25F;
/*     */       
/* 108 */       if (distance < 1.0F) {
/* 109 */         distance = 1.0F;
/*     */       }
/* 111 */       float scale = distance / 100.0F * ((Number)this.scaleValue.get()).floatValue();
/*     */       
/* 113 */       GL11.glScalef(-scale, -scale, scale);
/*     */       
/* 115 */       AWTFontRenderer.Companion.setAssumeNonVolatile(true);
/*     */ 
/*     */       
/* 118 */       float width = fontRenderer.getStringWidth(text) * 0.5F;
/*     */       
/* 120 */       GL11.glDisable(3553);
/* 121 */       GL11.glEnable(3042);
/*     */       
/* 123 */       if (((Boolean)this.borderValue.get()).booleanValue()) {
/* 124 */         RenderUtils.quickDrawBorderedRect(-width - 2.0F, -2.0F, width + 4.0F, fontRenderer.getFontHeight() + 2.0F, 2.0F, (new Color(255, 255, 255, 90)).getRGB(), -2147483648);
/*     */       } else {
/* 126 */         RenderUtils.quickDrawRect(-width - 2.0F, -2.0F, width + 4.0F, fontRenderer.getFontHeight() + 2.0F, -2147483648);
/*     */       } 
/* 128 */       GL11.glEnable(3553);
/*     */       
/* 130 */       fontRenderer.drawString(text, 1.0F + -width, Intrinsics.areEqual(fontRenderer, Fonts.minecraftFont) ? 1.0F : 1.5F, 
/* 131 */           16777215, true);
/*     */       
/* 133 */       AWTFontRenderer.Companion.setAssumeNonVolatile(false);
/*     */       
/* 135 */       if (((Boolean)this.armorValue.get()).booleanValue() && MinecraftInstance.classProvider.isEntityPlayer(entity)) {
/* 136 */         MinecraftInstance.mc.getRenderItem().setZLevel(-147.0F);
/*     */         
/* 138 */         int[] indices = { 0, 1, 2, 3, 5, 4 };
/*     */         
/* 140 */         for (int index : indices) {
/* 141 */           if (entity.getEquipmentInSlot(index) != null) { IItemStack equipmentInSlot = entity.getEquipmentInSlot(index);
/*     */             
/* 143 */             MinecraftInstance.mc.getRenderItem().renderItemAndEffectIntoGUI(equipmentInSlot, -50 + index * 20, -22); }
/*     */           else { entity.getEquipmentInSlot(index); }
/*     */         
/* 146 */         }  GlStateManager.func_179141_d();
/* 147 */         GlStateManager.func_179084_k();
/* 148 */         GlStateManager.func_179098_w();
/*     */       } 
/*     */ 
/*     */       
/* 152 */       GL11.glPopMatrix();
/*     */       return; }
/*     */     
/*     */     MinecraftInstance.mc.getThePlayer();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\NameTags2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */