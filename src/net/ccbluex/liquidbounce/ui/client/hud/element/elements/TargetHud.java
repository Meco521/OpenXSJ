/*     */ package net.ccbluex.liquidbounce.ui.client.hud.element.elements;
/*     */ 
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.util.Locale;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityLivingBase;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.gui.IFontRenderer;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Border;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.Element;
/*     */ import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @ElementInfo(name = "TargetHud")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000j\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\007\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\006\n\002\020\t\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\b\007\030\0002\0020\001B\005¢\006\002\020\002J \020$\032\0020%2\006\020&\032\0020\0322\006\020'\032\0020\0042\006\020(\032\0020\004H\002J&\020)\032\0020\0042\006\020&\032\0020\0042\006\020*\032\0020\0042\006\020+\032\0020,2\006\020-\032\0020.J \020/\032\0020%2\006\020&\032\0020\0322\006\020'\032\0020\0042\006\020(\032\0020\004H\002J\b\0200\032\00201H\026J \0202\032\0020%2\006\0203\032\002042\006\020'\032\0020.2\006\020(\032\0020.H\002J \0205\032\0020%2\006\020&\032\0020\0322\006\020'\032\0020\0042\006\020(\032\0020\004H\002J \0206\032\0020%2\006\020&\032\0020\0322\006\020'\032\0020\0042\006\020(\032\0020\004H\002J \0207\032\0020%2\006\020&\032\0020\0322\006\020'\032\0020\0042\006\020(\032\0020\004H\002J \0208\032\0020%2\006\020&\032\0020\0322\006\020'\032\0020\0042\006\020(\032\0020\004H\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\nX\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\004X\016¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\020X\004¢\006\002\n\000R\"\020\022\032\n \024*\004\030\0010\0230\023X\016¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R\034\020\031\032\004\030\0010\032X\016¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036R\016\020\037\032\0020 X\004¢\006\002\n\000R\016\020!\032\0020\nX\004¢\006\002\n\000R\016\020\"\032\0020\020X\004¢\006\002\n\000R\016\020#\032\0020\nX\004¢\006\002\n\000¨\0069"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Element;", "()V", "animProgress", "", "getAnimProgress", "()F", "setAnimProgress", "(F)V", "blur", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "cfont", "decimalFormat", "Ljava/text/DecimalFormat;", "easingHealth", "fadeSpeed", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "fadeSpeed2", "fontRenderer", "Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "kotlin.jvm.PlatformType", "getFontRenderer", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;", "setFontRenderer", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;)V", "mainTarget", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "getMainTarget", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;", "setMainTarget", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;)V", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "outline", "ra", "shadow", "astro", "", "target", "width", "height", "calculateCompensation", "current", "delta", "", "speed", "", "cou", "drawElement", "Lnet/ccbluex/liquidbounce/ui/client/hud/element/Border;", "drawHead", "skin", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "liquidbounce", "nameless", "novoline", "wtf", "XSJClient"})
/*     */ public final class TargetHud
/*     */   extends Element
/*     */ {
/*     */   private final ListValue modeValue;
/*     */   private final BoolValue shadow;
/*     */   private final BoolValue blur;
/*     */   private final BoolValue cfont;
/*     */   private final BoolValue outline;
/*     */   private final FloatValue ra;
/*     */   
/*     */   public TargetHud() {
/*  43 */     super(0.0D, 0.0D, 0.0F, null, 15, null);
/*     */     
/*  45 */     this.modeValue = new ListValue("Style", new String[] { "Novoline", "cou", "LiquidBounce", "Astro", "WTF", "Nameless" }, "LiquidBounce");
/*  46 */     this.shadow = new BoolValue("Shadow", false);
/*  47 */     this.blur = new BoolValue("Blur ", false);
/*     */     
/*  49 */     this.cfont = new BoolValue("CFont", true);
/*  50 */     this.outline = new BoolValue("Outline", false);
/*  51 */     this.ra = new FloatValue("ra", 2.0F, 1.0F, 8.0F);
/*  52 */     this.decimalFormat = new DecimalFormat("##0.00", new DecimalFormatSymbols(Locale.ENGLISH));
/*  53 */     this.fadeSpeed = new FloatValue("HP-FadeSpeed", 2.0F, 1.0F, 9.0F);
/*  54 */     this.fadeSpeed2 = new FloatValue("FadeSpeed", 2.0F, 1.0F, 9.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.fontRenderer = Fonts.font40; } private final DecimalFormat decimalFormat; private final FloatValue fadeSpeed; private final FloatValue fadeSpeed2; private float easingHealth; private IFontRenderer fontRenderer; @Nullable private IEntityLivingBase mainTarget; private float animProgress; public final IFontRenderer getFontRenderer() { return this.fontRenderer; } public final void setFontRenderer(IFontRenderer <set-?>) { this.fontRenderer = <set-?>; }
/*     */   @Nullable
/*  62 */   public final IEntityLivingBase getMainTarget() { return this.mainTarget; } public final void setMainTarget(@Nullable IEntityLivingBase <set-?>) { this.mainTarget = <set-?>; }
/*  63 */   public final float getAnimProgress() { return this.animProgress; } public final void setAnimProgress(float <set-?>) { this.animProgress = <set-?>; }
/*     */   
/*     */   public final float calculateCompensation(float target, float current, long delta, int speed) {
/*  66 */     float f1 = current;
/*  67 */     long l = delta;
/*  68 */     float diff = f1 - target;
/*  69 */     if (l < 1L) {
/*  70 */       l = 1L;
/*     */     }
/*  72 */     double xD = 0.0D;
/*  73 */     if (diff > speed) {
/*     */       
/*  75 */       xD = ((speed * l / 16L) < 0.25D) ? 0.5D : (speed * l / 16L);
/*  76 */       f1 = (float)(f1 - xD);
/*  77 */       if (f1 < target) {
/*  78 */         f1 = target;
/*     */       }
/*  80 */     } else if (diff < -speed) {
/*     */       
/*  82 */       xD = ((speed * l / 16L) < 0.25D) ? 0.5D : (speed * l / 16L);
/*  83 */       f1 = (float)(f1 + xD);
/*  84 */       if (f1 > target) {
/*  85 */         f1 = target;
/*     */       }
/*     */     } else {
/*  88 */       f1 = target;
/*     */     } 
/*  90 */     return f1;
/*     */   }
/*     */   @NotNull
/*     */   public Border drawElement() {
/*  94 */     if (((Boolean)this.cfont.get()).booleanValue()) {
/*  95 */       this.fontRenderer = Fonts.font35;
/*     */     } else {
/*  97 */       this.fontRenderer = MinecraftInstance.mc.getFontRendererObj();
/*     */     } 
/*  99 */     if (Retreat.INSTANCE.getModuleManager().get(KillAura.class) == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.combat.KillAura");  IEntityLivingBase kaTarget = ((KillAura)Retreat.INSTANCE.getModuleManager().get(KillAura.class)).getTarget();
/*     */     
/* 101 */     IEntityLivingBase actualTarget = (kaTarget != null) ? kaTarget : (
/*     */       
/* 103 */       MinecraftInstance.classProvider.isGuiHudDesigner(MinecraftInstance.mc.getCurrentScreen()) ? (IEntityLivingBase)MinecraftInstance.mc.getThePlayer() : 
/* 104 */       null);
/*     */     
/* 106 */     float width = 80.0F;
/* 107 */     String str1 = (String)this.modeValue.get(); boolean bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str1.toLowerCase().equals("novoline"))
/* 108 */     { width = 80.0F; }
/* 109 */     else { str1 = (String)this.modeValue.get(); bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str1.toLowerCase().equals("outline"))
/* 110 */       { width = 80.0F; }
/* 111 */       else { str1 = (String)this.modeValue.get(); bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str1.toLowerCase().equals("astro"))
/* 112 */         { width = 90.0F; }
/*     */         else
/* 114 */         { str1 = (String)this.modeValue.get(); bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str1.toLowerCase().equals("cou"))
/* 115 */           { width = 80.0F; }
/* 116 */           else { str1 = (String)this.modeValue.get(); bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str1.toLowerCase().equals("wtf"))
/* 117 */             { width = 100.0F; }
/* 118 */             else { str1 = (String)this.modeValue.get(); bool1 = false; if (str1 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str1.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str1.toLowerCase().equals("nameless"))
/* 119 */               { width = 100.0F; }
/*     */               else
/* 121 */               { width = 128.0F; }  }  }  }  }
/*     */        }
/* 123 */      float height = 34.0F;
/* 124 */     String str2 = (String)this.modeValue.get(); boolean bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str2.toLowerCase().equals("novoline")) {
/* 125 */       height = 34.0F;
/*     */     } else {
/*     */       
/* 128 */       str2 = (String)this.modeValue.get(); bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str2.toLowerCase().equals("cou"))
/* 129 */       { width = 34.0F; }
/* 130 */       else { str2 = (String)this.modeValue.get(); bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str2.toLowerCase().equals("astro"))
/* 131 */         { height = 40.0F; }
/* 132 */         else { str2 = (String)this.modeValue.get(); bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str2.toLowerCase().equals("wtf"))
/* 133 */           { height = 44.0F; }
/* 134 */           else { str2 = (String)this.modeValue.get(); bool2 = false; if (str2 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str2.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str2.toLowerCase().equals("nameless")) {
/* 135 */               height = 36.0F;
/*     */             } else {
/* 137 */               height = 36.0F;
/*     */             }  }
/*     */            }
/*     */          }
/*     */     
/* 142 */     }  float num = (actualTarget != null) ? 0.0F : 1.0F;
/* 143 */     float f1 = 2.0F, f2 = 10.0F - ((Number)this.fadeSpeed2.get()).floatValue(), f4 = num - this.animProgress, f3 = this.animProgress; TargetHud targetHud = this; boolean bool4 = false; float f5 = (float)Math.pow(f1, f2); targetHud.animProgress = f3 + f4 / f5 * RenderUtils.deltaTime;
/*     */     
/* 145 */     this.animProgress = RangesKt.coerceIn(this.animProgress, 0.0F, 1.0F);
/*     */     
/* 147 */     if (actualTarget != null) {
/* 148 */       this.mainTarget = actualTarget;
/* 149 */     } else if (this.animProgress >= 1.0F) {
/* 150 */       this.mainTarget = (IEntityLivingBase)null;
/*     */     } 
/*     */     
/* 153 */     if (this.mainTarget == null) {
/* 154 */       this.easingHealth = 0.0F;
/* 155 */       return new Border(0.0F, 0.0F, width, height);
/*     */     } 
/*     */     
/* 158 */     String str3 = (String)this.modeValue.get(); boolean bool3 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str3.toLowerCase().equals("novoline"))
/* 159 */     { if (this.mainTarget == null) Intrinsics.throwNpe();  str3 = this.mainTarget.getName(); IFontRenderer iFontRenderer = MinecraftInstance.mc.getFontRendererObj(); byte b = 38; bool4 = false; boolean bool = false; String p1 = str3; int $i$a$-unknown-TargetHud$drawElement$1 = 0, i = iFontRenderer.getStringWidth(p1); this.mainTarget.getName();
/*     */       
/* 161 */       width = RangesKt.coerceAtLeast(38 + ((this.mainTarget.getName() != null) ? i : 0), 80); }
/* 162 */     else { str3 = (String)this.modeValue.get(); bool3 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str3.toLowerCase().equals("astro")) {
/* 163 */         if (this.mainTarget == null) Intrinsics.throwNpe();  str3 = this.mainTarget.getName(); IFontRenderer iFontRenderer = MinecraftInstance.mc.getFontRendererObj(); byte b = 38; bool4 = false; boolean bool = false; String p1 = str3; int $i$a$-unknown-TargetHud$drawElement$2 = 0, i = iFontRenderer.getStringWidth(p1); this.mainTarget.getName();
/*     */         
/* 165 */         width = RangesKt.coerceAtLeast(38 + ((this.mainTarget.getName() != null) ? i : 0), 90);
/*     */       } else {
/* 167 */         str3 = (String)this.modeValue.get(); bool3 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str3.toLowerCase().equals("wtf")) {
/* 168 */           if (this.mainTarget == null) Intrinsics.throwNpe();  str3 = this.mainTarget.getName(); IFontRenderer iFontRenderer = MinecraftInstance.mc.getFontRendererObj(); byte b = 38; bool4 = false; boolean bool = false; String p1 = str3; int $i$a$-unknown-TargetHud$drawElement$3 = 0, i = iFontRenderer.getStringWidth(p1); this.mainTarget.getName();
/*     */           
/* 170 */           width = RangesKt.coerceAtLeast(38 + ((this.mainTarget.getName() != null) ? i : 0), 100);
/*     */         } else {
/* 172 */           str3 = (String)this.modeValue.get(); bool3 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str3.toLowerCase().equals("cou"))
/* 173 */           { if (this.mainTarget == null) Intrinsics.throwNpe();  str3 = this.mainTarget.getName(); IFontRenderer iFontRenderer = MinecraftInstance.mc.getFontRendererObj(); byte b = 38; bool4 = false; boolean bool = false; String p1 = str3; int $i$a$-unknown-TargetHud$drawElement$4 = 0, i = iFontRenderer.getStringWidth(p1); this.mainTarget.getName();
/*     */             
/* 175 */             width = RangesKt.coerceAtLeast(38 + ((this.mainTarget.getName() != null) ? i : 0), 80); }
/* 176 */           else { str3 = (String)this.modeValue.get(); bool3 = false; if (str3 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str3.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str3.toLowerCase().equals("nameless"))
/* 177 */             { if (this.mainTarget == null) Intrinsics.throwNpe();  str3 = this.mainTarget.getName(); IFontRenderer iFontRenderer = MinecraftInstance.mc.getFontRendererObj(); byte b = 38; bool4 = false; boolean bool = false; String p1 = str3; int $i$a$-unknown-TargetHud$drawElement$5 = 0, i = iFontRenderer.getStringWidth(p1); this.mainTarget.getName();
/*     */               
/* 179 */               width = RangesKt.coerceAtLeast(38 + ((this.mainTarget.getName() != null) ? i : 0), 100); }
/*     */             else
/* 181 */             { if (this.mainTarget == null) Intrinsics.throwNpe();  str3 = this.mainTarget.getName(); IFontRenderer iFontRenderer = MinecraftInstance.mc.getFontRendererObj(); byte b = 38; bool4 = false; boolean bool = false; String p1 = str3; int $i$a$-unknown-TargetHud$drawElement$6 = 0, i = iFontRenderer.getStringWidth(p1); this.mainTarget.getName();
/*     */               
/* 183 */               width = RangesKt.coerceAtLeast(38 + ((this.mainTarget.getName() != null) ? i : 0), 100); }  } 
/*     */         } 
/*     */       }  }
/* 186 */      float calcScaleX = this.animProgress;
/* 187 */     float calcScaleY = this.animProgress;
/* 188 */     float calcTranslateX = width / 2.0F * calcScaleX;
/* 189 */     float calcTranslateY = height / 2.0F * calcScaleY;
/*     */     
/* 191 */     GL11.glPushMatrix();
/* 192 */     GL11.glTranslatef(calcTranslateX, calcTranslateY, 0.0F);
/* 193 */     GL11.glScalef(1.0F - calcScaleX, 1.0F - calcScaleY, 1.0F - calcScaleX);
/* 194 */     String str4 = (String)this.modeValue.get(); boolean bool5 = false; if (str4 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str4.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str4.toLowerCase().equals("novoline"))
/* 195 */     { if (this.mainTarget == null) Intrinsics.throwNpe();  novoline(this.mainTarget, width, height); }
/* 196 */     else { str4 = (String)this.modeValue.get(); bool5 = false; if (str4 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str4.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str4.toLowerCase().equals("astro"))
/* 197 */       { if (this.mainTarget == null) Intrinsics.throwNpe();  astro(this.mainTarget, width, height); }
/* 198 */       else { str4 = (String)this.modeValue.get(); bool5 = false; if (str4 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str4.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str4.toLowerCase().equals("wtf"))
/* 199 */         { if (this.mainTarget == null) Intrinsics.throwNpe();  wtf(this.mainTarget, width, height); }
/* 200 */         else { str4 = (String)this.modeValue.get(); bool5 = false; if (str4 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str4.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str4.toLowerCase().equals("outline"))
/* 201 */           { if (this.mainTarget == null) Intrinsics.throwNpe();  wtf(this.mainTarget, width, height); }
/* 202 */           else { str4 = (String)this.modeValue.get(); bool5 = false; if (str4 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str4.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str4.toLowerCase().equals("nameless"))
/* 203 */             { if (this.mainTarget == null) Intrinsics.throwNpe();  nameless(this.mainTarget, width, height); }
/* 204 */             else { str4 = (String)this.modeValue.get(); bool5 = false; if (str4 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str4.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str4.toLowerCase().equals("cou")) {
/* 205 */                 if (this.mainTarget == null) Intrinsics.throwNpe();  cou(this.mainTarget, width, height);
/*     */               } else {
/* 207 */                 if (this.mainTarget == null) Intrinsics.throwNpe();  liquidbounce(this.mainTarget, width, height);
/*     */               }  }
/*     */              }
/*     */            }
/*     */          }
/*     */        }
/* 213 */      GL11.glPopMatrix();
/*     */     
/* 215 */     GlStateManager.func_179117_G();
/* 216 */     return new Border(0.0F, 0.0F, width, height);
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
/*     */   private final void liquidbounce(IEntityLivingBase target, float width, float height) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 811
/*     */     //   4: aload_0
/*     */     //   5: getfield easingHealth : F
/*     */     //   8: iconst_0
/*     */     //   9: i2f
/*     */     //   10: fcmpg
/*     */     //   11: iflt -> 57
/*     */     //   14: aload_0
/*     */     //   15: getfield easingHealth : F
/*     */     //   18: aload_1
/*     */     //   19: invokeinterface getMaxHealth : ()F
/*     */     //   24: fcmpl
/*     */     //   25: ifgt -> 57
/*     */     //   28: aload_0
/*     */     //   29: getfield easingHealth : F
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface getHealth : ()F
/*     */     //   38: fsub
/*     */     //   39: fstore #4
/*     */     //   41: iconst_0
/*     */     //   42: istore #5
/*     */     //   44: fload #4
/*     */     //   46: invokestatic abs : (F)F
/*     */     //   49: f2d
/*     */     //   50: ldc2_w 0.01
/*     */     //   53: dcmpg
/*     */     //   54: ifge -> 67
/*     */     //   57: aload_0
/*     */     //   58: aload_1
/*     */     //   59: invokeinterface getHealth : ()F
/*     */     //   64: putfield easingHealth : F
/*     */     //   67: dconst_0
/*     */     //   68: dconst_0
/*     */     //   69: fload_2
/*     */     //   70: f2d
/*     */     //   71: fload_3
/*     */     //   72: f2d
/*     */     //   73: new java/awt/Color
/*     */     //   76: dup
/*     */     //   77: iconst_0
/*     */     //   78: iconst_0
/*     */     //   79: iconst_0
/*     */     //   80: bipush #70
/*     */     //   82: invokespecial <init> : (IIII)V
/*     */     //   85: invokevirtual getRGB : ()I
/*     */     //   88: invokestatic rectangle : (DDDDI)V
/*     */     //   91: aload_0
/*     */     //   92: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   95: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   98: checkcast java/lang/Boolean
/*     */     //   101: invokevirtual booleanValue : ()Z
/*     */     //   104: ifeq -> 121
/*     */     //   107: fconst_0
/*     */     //   108: fconst_0
/*     */     //   109: fload_2
/*     */     //   110: f2d
/*     */     //   111: d2f
/*     */     //   112: fload_3
/*     */     //   113: f2d
/*     */     //   114: d2f
/*     */     //   115: ldc_w 255.0
/*     */     //   118: invokestatic drawShadowWithCustomAlpha : (FFFFF)V
/*     */     //   121: aload_0
/*     */     //   122: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   125: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   128: checkcast java/lang/Boolean
/*     */     //   131: invokevirtual booleanValue : ()Z
/*     */     //   134: ifeq -> 188
/*     */     //   137: aload_0
/*     */     //   138: invokevirtual getRenderX : ()D
/*     */     //   141: dneg
/*     */     //   142: aload_0
/*     */     //   143: invokevirtual getRenderY : ()D
/*     */     //   146: dneg
/*     */     //   147: dconst_0
/*     */     //   148: invokestatic glTranslated : (DDD)V
/*     */     //   151: aload_0
/*     */     //   152: invokevirtual getRenderX : ()D
/*     */     //   155: fconst_0
/*     */     //   156: f2d
/*     */     //   157: dadd
/*     */     //   158: d2f
/*     */     //   159: aload_0
/*     */     //   160: invokevirtual getRenderY : ()D
/*     */     //   163: fconst_0
/*     */     //   164: f2d
/*     */     //   165: dadd
/*     */     //   166: d2f
/*     */     //   167: fload_2
/*     */     //   168: f2d
/*     */     //   169: d2f
/*     */     //   170: fload_3
/*     */     //   171: f2d
/*     */     //   172: d2f
/*     */     //   173: invokestatic blurArea : (FFFF)V
/*     */     //   176: aload_0
/*     */     //   177: invokevirtual getRenderX : ()D
/*     */     //   180: aload_0
/*     */     //   181: invokevirtual getRenderY : ()D
/*     */     //   184: dconst_0
/*     */     //   185: invokestatic glTranslated : (DDD)V
/*     */     //   188: new java/awt/Color
/*     */     //   191: dup
/*     */     //   192: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   195: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   198: checkcast java/lang/Number
/*     */     //   201: invokevirtual intValue : ()I
/*     */     //   204: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   207: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   210: checkcast java/lang/Number
/*     */     //   213: invokevirtual intValue : ()I
/*     */     //   216: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   219: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   222: checkcast java/lang/Number
/*     */     //   225: invokevirtual intValue : ()I
/*     */     //   228: invokespecial <init> : (III)V
/*     */     //   231: astore #4
/*     */     //   233: new java/awt/Color
/*     */     //   236: dup
/*     */     //   237: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   240: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   243: checkcast java/lang/Number
/*     */     //   246: invokevirtual intValue : ()I
/*     */     //   249: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   252: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   255: checkcast java/lang/Number
/*     */     //   258: invokevirtual intValue : ()I
/*     */     //   261: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   264: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   267: checkcast java/lang/Number
/*     */     //   270: invokevirtual intValue : ()I
/*     */     //   273: invokespecial <init> : (III)V
/*     */     //   276: astore #5
/*     */     //   278: dconst_0
/*     */     //   279: dstore #6
/*     */     //   281: fload_2
/*     */     //   282: f2d
/*     */     //   283: dstore #8
/*     */     //   285: dload #6
/*     */     //   287: dneg
/*     */     //   288: ldc2_w 2.0
/*     */     //   291: dmul
/*     */     //   292: pop2
/*     */     //   293: dload #6
/*     */     //   295: fload_3
/*     */     //   296: f2d
/*     */     //   297: ldc2_w 2.0
/*     */     //   300: dsub
/*     */     //   301: dload #6
/*     */     //   303: aload_0
/*     */     //   304: getfield easingHealth : F
/*     */     //   307: aload_1
/*     */     //   308: invokeinterface getMaxHealth : ()F
/*     */     //   313: fdiv
/*     */     //   314: f2d
/*     */     //   315: dload #8
/*     */     //   317: dmul
/*     */     //   318: dadd
/*     */     //   319: fload_3
/*     */     //   320: f2d
/*     */     //   321: aload #5
/*     */     //   323: invokevirtual getRGB : ()I
/*     */     //   326: aload #4
/*     */     //   328: invokevirtual getRGB : ()I
/*     */     //   331: invokestatic drawGradientSideways : (DDDDII)V
/*     */     //   334: aload_0
/*     */     //   335: dup
/*     */     //   336: getfield easingHealth : F
/*     */     //   339: aload_1
/*     */     //   340: invokeinterface getHealth : ()F
/*     */     //   345: aload_0
/*     */     //   346: getfield easingHealth : F
/*     */     //   349: fsub
/*     */     //   350: fconst_2
/*     */     //   351: fstore #10
/*     */     //   353: ldc 10.0
/*     */     //   355: aload_0
/*     */     //   356: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   359: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   362: checkcast java/lang/Number
/*     */     //   365: invokevirtual floatValue : ()F
/*     */     //   368: fsub
/*     */     //   369: fstore #11
/*     */     //   371: fstore #18
/*     */     //   373: fstore #17
/*     */     //   375: astore #16
/*     */     //   377: iconst_0
/*     */     //   378: istore #12
/*     */     //   380: fload #10
/*     */     //   382: f2d
/*     */     //   383: fload #11
/*     */     //   385: f2d
/*     */     //   386: invokestatic pow : (DD)D
/*     */     //   389: d2f
/*     */     //   390: fstore #19
/*     */     //   392: aload #16
/*     */     //   394: fload #17
/*     */     //   396: fload #18
/*     */     //   398: fload #19
/*     */     //   400: fdiv
/*     */     //   401: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   404: i2f
/*     */     //   405: fmul
/*     */     //   406: fadd
/*     */     //   407: putfield easingHealth : F
/*     */     //   410: aload_1
/*     */     //   411: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   416: dup
/*     */     //   417: ifnull -> 457
/*     */     //   420: astore #10
/*     */     //   422: iconst_0
/*     */     //   423: istore #11
/*     */     //   425: iconst_0
/*     */     //   426: istore #12
/*     */     //   428: aload #10
/*     */     //   430: astore #13
/*     */     //   432: iconst_0
/*     */     //   433: istore #14
/*     */     //   435: aload_0
/*     */     //   436: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   439: aload #13
/*     */     //   441: bipush #36
/*     */     //   443: bipush #7
/*     */     //   445: ldc_w 16777215
/*     */     //   448: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   453: pop
/*     */     //   454: goto -> 458
/*     */     //   457: pop
/*     */     //   458: aload_0
/*     */     //   459: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   462: new java/lang/StringBuilder
/*     */     //   465: dup
/*     */     //   466: invokespecial <init> : ()V
/*     */     //   469: ldc_w 'Distance: '
/*     */     //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   475: aload_0
/*     */     //   476: getfield decimalFormat : Ljava/text/DecimalFormat;
/*     */     //   479: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   482: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   487: dup
/*     */     //   488: ifnonnull -> 494
/*     */     //   491: invokestatic throwNpe : ()V
/*     */     //   494: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   497: aload_1
/*     */     //   498: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   501: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   504: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   510: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   513: bipush #36
/*     */     //   515: bipush #19
/*     */     //   517: ldc_w 16777215
/*     */     //   520: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   525: pop
/*     */     //   526: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   529: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   534: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   537: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   542: dup
/*     */     //   543: ifnonnull -> 549
/*     */     //   546: invokestatic throwNpe : ()V
/*     */     //   549: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   554: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   559: astore #10
/*     */     //   561: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   564: aload_1
/*     */     //   565: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   570: ifeq -> 594
/*     */     //   573: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   576: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   581: aload_1
/*     */     //   582: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   587: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   592: astore #10
/*     */     //   594: aload #10
/*     */     //   596: ifnull -> 811
/*     */     //   599: aload #10
/*     */     //   601: invokeinterface getLocationSkin : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   606: astore #11
/*     */     //   608: aload_1
/*     */     //   609: invokeinterface getHurtTime : ()I
/*     */     //   614: i2f
/*     */     //   615: aload_1
/*     */     //   616: invokeinterface getHurtTime : ()I
/*     */     //   621: ifeq -> 636
/*     */     //   624: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
/*     */     //   627: getfield field_71428_T : Lnet/minecraft/util/Timer;
/*     */     //   630: getfield field_194147_b : F
/*     */     //   633: goto -> 637
/*     */     //   636: fconst_0
/*     */     //   637: fsub
/*     */     //   638: fstore #12
/*     */     //   640: fload #12
/*     */     //   642: ldc 10.0
/*     */     //   644: fdiv
/*     */     //   645: fstore #13
/*     */     //   647: fconst_1
/*     */     //   648: iconst_1
/*     */     //   649: i2f
/*     */     //   650: fload #13
/*     */     //   652: fsub
/*     */     //   653: iconst_1
/*     */     //   654: i2f
/*     */     //   655: fload #13
/*     */     //   657: fsub
/*     */     //   658: fconst_1
/*     */     //   659: invokestatic glColor4f : (FFFF)V
/*     */     //   662: fload #13
/*     */     //   664: fconst_0
/*     */     //   665: fcmpg
/*     */     //   666: ifne -> 673
/*     */     //   669: fconst_1
/*     */     //   670: goto -> 714
/*     */     //   673: fload #13
/*     */     //   675: ldc_w 0.5
/*     */     //   678: fcmpg
/*     */     //   679: ifge -> 697
/*     */     //   682: iconst_1
/*     */     //   683: i2f
/*     */     //   684: ldc_w 0.2
/*     */     //   687: fload #13
/*     */     //   689: fmul
/*     */     //   690: iconst_2
/*     */     //   691: i2f
/*     */     //   692: fmul
/*     */     //   693: fsub
/*     */     //   694: goto -> 714
/*     */     //   697: ldc_w 0.8
/*     */     //   700: ldc_w 0.2
/*     */     //   703: fload #13
/*     */     //   705: ldc_w 0.5
/*     */     //   708: fsub
/*     */     //   709: fmul
/*     */     //   710: iconst_2
/*     */     //   711: i2f
/*     */     //   712: fmul
/*     */     //   713: fadd
/*     */     //   714: fstore #14
/*     */     //   716: bipush #30
/*     */     //   718: istore #15
/*     */     //   720: invokestatic glPushMatrix : ()V
/*     */     //   723: fload #14
/*     */     //   725: fload #14
/*     */     //   727: fload #14
/*     */     //   729: invokestatic glScalef : (FFF)V
/*     */     //   732: iload #15
/*     */     //   734: i2f
/*     */     //   735: ldc_w 0.5
/*     */     //   738: fmul
/*     */     //   739: iconst_1
/*     */     //   740: i2f
/*     */     //   741: fload #14
/*     */     //   743: fsub
/*     */     //   744: fmul
/*     */     //   745: fload #14
/*     */     //   747: fdiv
/*     */     //   748: iload #15
/*     */     //   750: i2f
/*     */     //   751: ldc_w 0.5
/*     */     //   754: fmul
/*     */     //   755: iconst_1
/*     */     //   756: i2f
/*     */     //   757: fload #14
/*     */     //   759: fsub
/*     */     //   760: fmul
/*     */     //   761: fload #14
/*     */     //   763: fdiv
/*     */     //   764: fconst_0
/*     */     //   765: invokestatic glTranslatef : (FFF)V
/*     */     //   768: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   771: invokeinterface getTextureManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;
/*     */     //   776: aload #11
/*     */     //   778: invokeinterface bindTexture : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V
/*     */     //   783: iconst_2
/*     */     //   784: iconst_2
/*     */     //   785: ldc_w 8.0
/*     */     //   788: ldc_w 8.0
/*     */     //   791: bipush #8
/*     */     //   793: bipush #8
/*     */     //   795: iload #15
/*     */     //   797: iload #15
/*     */     //   799: ldc_w 64.0
/*     */     //   802: ldc_w 64.0
/*     */     //   805: invokestatic drawScaledCustomSizeModalRect : (IIFFIIIIFF)V
/*     */     //   808: invokestatic glPopMatrix : ()V
/*     */     //   811: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #220	-> 0
/*     */     //   #221	-> 4
/*     */     //   #222	-> 4
/*     */     //   #223	-> 57
/*     */     //   #228	-> 67
/*     */     //   #229	-> 91
/*     */     //   #230	-> 107
/*     */     //   #232	-> 121
/*     */     //   #233	-> 137
/*     */     //   #235	-> 151
/*     */     //   #236	-> 159
/*     */     //   #235	-> 173
/*     */     //   #239	-> 176
/*     */     //   #242	-> 188
/*     */     //   #243	-> 233
/*     */     //   #247	-> 278
/*     */     //   #248	-> 281
/*     */     //   #249	-> 285
/*     */     //   #250	-> 293
/*     */     //   #251	-> 319
/*     */     //   #250	-> 331
/*     */     //   #253	-> 334
/*     */     //   #253	-> 400
/*     */     //   #255	-> 410
/*     */     //   #255	-> 435
/*     */     //   #255	-> 454
/*     */     //   #257	-> 458
/*     */     //   #263	-> 526
/*     */     //   #264	-> 561
/*     */     //   #265	-> 573
/*     */     //   #267	-> 594
/*     */     //   #270	-> 599
/*     */     //   #272	-> 608
/*     */     //   #274	-> 640
/*     */     //   #275	-> 647
/*     */     //   #277	-> 662
/*     */     //   #278	-> 682
/*     */     //   #280	-> 697
/*     */     //   #277	-> 714
/*     */     //   #282	-> 716
/*     */     //   #284	-> 720
/*     */     //   #286	-> 723
/*     */     //   #287	-> 732
/*     */     //   #289	-> 768
/*     */     //   #290	-> 783
/*     */     //   #291	-> 799
/*     */     //   #290	-> 805
/*     */     //   #293	-> 808
/*     */     //   #296	-> 811
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   432	21	13	it	Ljava/lang/String;
/*     */     //   435	18	14	$i$a$-let-TargetHud$liquidbounce$1	I
/*     */     //   720	91	15	size	I
/*     */     //   716	95	14	scale	F
/*     */     //   647	164	13	hurtPercent	F
/*     */     //   640	171	12	renderHurtTime	F
/*     */     //   608	203	11	locationSkin	Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   561	250	10	playerInfo	Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   285	526	8	healthBar	D
/*     */     //   281	530	6	startPos	D
/*     */     //   278	533	5	c2	Ljava/awt/Color;
/*     */     //   233	578	4	c	Ljava/awt/Color;
/*     */     //   0	812	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;
/*     */     //   0	812	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	812	2	width	F
/*     */     //   0	812	3	height	F
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
/*     */   private final void novoline(IEntityLivingBase target, float width, float height) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 1466
/*     */     //   4: aload_0
/*     */     //   5: getfield easingHealth : F
/*     */     //   8: iconst_0
/*     */     //   9: i2f
/*     */     //   10: fcmpg
/*     */     //   11: iflt -> 57
/*     */     //   14: aload_0
/*     */     //   15: getfield easingHealth : F
/*     */     //   18: aload_1
/*     */     //   19: invokeinterface getMaxHealth : ()F
/*     */     //   24: fcmpl
/*     */     //   25: ifgt -> 57
/*     */     //   28: aload_0
/*     */     //   29: getfield easingHealth : F
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface getHealth : ()F
/*     */     //   38: fsub
/*     */     //   39: fstore #4
/*     */     //   41: iconst_0
/*     */     //   42: istore #5
/*     */     //   44: fload #4
/*     */     //   46: invokestatic abs : (F)F
/*     */     //   49: f2d
/*     */     //   50: ldc2_w 0.01
/*     */     //   53: dcmpg
/*     */     //   54: ifge -> 67
/*     */     //   57: aload_0
/*     */     //   58: aload_1
/*     */     //   59: invokeinterface getHealth : ()F
/*     */     //   64: putfield easingHealth : F
/*     */     //   67: new java/awt/Color
/*     */     //   70: dup
/*     */     //   71: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   74: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   77: checkcast java/lang/Number
/*     */     //   80: invokevirtual intValue : ()I
/*     */     //   83: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   86: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   89: checkcast java/lang/Number
/*     */     //   92: invokevirtual intValue : ()I
/*     */     //   95: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   98: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   101: checkcast java/lang/Number
/*     */     //   104: invokevirtual intValue : ()I
/*     */     //   107: invokespecial <init> : (III)V
/*     */     //   110: astore #4
/*     */     //   112: new java/awt/Color
/*     */     //   115: dup
/*     */     //   116: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   119: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   122: checkcast java/lang/Number
/*     */     //   125: invokevirtual intValue : ()I
/*     */     //   128: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   131: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   134: checkcast java/lang/Number
/*     */     //   137: invokevirtual intValue : ()I
/*     */     //   140: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   146: checkcast java/lang/Number
/*     */     //   149: invokevirtual intValue : ()I
/*     */     //   152: invokespecial <init> : (III)V
/*     */     //   155: astore #5
/*     */     //   157: dconst_0
/*     */     //   158: dconst_0
/*     */     //   159: fload_2
/*     */     //   160: f2d
/*     */     //   161: fload_3
/*     */     //   162: f2d
/*     */     //   163: ldc2_w 0.5
/*     */     //   166: new java/awt/Color
/*     */     //   169: dup
/*     */     //   170: iconst_0
/*     */     //   171: iconst_0
/*     */     //   172: iconst_0
/*     */     //   173: bipush #30
/*     */     //   175: invokespecial <init> : (IIII)V
/*     */     //   178: invokevirtual getRGB : ()I
/*     */     //   181: aload_0
/*     */     //   182: getfield outline : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   185: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   188: checkcast java/lang/Boolean
/*     */     //   191: invokevirtual booleanValue : ()Z
/*     */     //   194: ifeq -> 211
/*     */     //   197: aload #4
/*     */     //   199: invokevirtual getRGB : ()I
/*     */     //   202: ldc_w 0.4
/*     */     //   205: invokestatic reAlpha : (IF)I
/*     */     //   208: goto -> 226
/*     */     //   211: new java/awt/Color
/*     */     //   214: dup
/*     */     //   215: iconst_0
/*     */     //   216: iconst_0
/*     */     //   217: iconst_0
/*     */     //   218: bipush #80
/*     */     //   220: invokespecial <init> : (IIII)V
/*     */     //   223: invokevirtual getRGB : ()I
/*     */     //   226: invokestatic rectangleBordered : (DDDDDII)V
/*     */     //   229: aload_0
/*     */     //   230: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   233: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   236: checkcast java/lang/Boolean
/*     */     //   239: invokevirtual booleanValue : ()Z
/*     */     //   242: ifeq -> 259
/*     */     //   245: fconst_0
/*     */     //   246: fconst_0
/*     */     //   247: fload_2
/*     */     //   248: f2d
/*     */     //   249: d2f
/*     */     //   250: fload_3
/*     */     //   251: f2d
/*     */     //   252: d2f
/*     */     //   253: ldc_w 255.0
/*     */     //   256: invokestatic drawShadowWithCustomAlpha : (FFFFF)V
/*     */     //   259: ldc2_w 36.0
/*     */     //   262: ldc2_w 17.0
/*     */     //   265: fload_2
/*     */     //   266: f2d
/*     */     //   267: iconst_4
/*     */     //   268: i2d
/*     */     //   269: dsub
/*     */     //   270: ldc2_w 27.0
/*     */     //   273: new java/awt/Color
/*     */     //   276: dup
/*     */     //   277: bipush #35
/*     */     //   279: bipush #35
/*     */     //   281: bipush #35
/*     */     //   283: bipush #20
/*     */     //   285: invokespecial <init> : (IIII)V
/*     */     //   288: invokevirtual getRGB : ()I
/*     */     //   291: invokestatic rectangle : (DDDDI)V
/*     */     //   294: ldc2_w 36.0
/*     */     //   297: ldc2_w 17.0
/*     */     //   300: ldc2_w 36.0
/*     */     //   303: aload_0
/*     */     //   304: getfield easingHealth : F
/*     */     //   307: aload_1
/*     */     //   308: invokeinterface getMaxHealth : ()F
/*     */     //   313: fdiv
/*     */     //   314: fload_2
/*     */     //   315: bipush #40
/*     */     //   317: i2f
/*     */     //   318: fsub
/*     */     //   319: fmul
/*     */     //   320: f2d
/*     */     //   321: dadd
/*     */     //   322: ldc2_w 27.0
/*     */     //   325: aload #5
/*     */     //   327: invokevirtual getRGB : ()I
/*     */     //   330: aload #4
/*     */     //   332: invokevirtual getRGB : ()I
/*     */     //   335: invokestatic drawGradientSideways : (DDDDII)V
/*     */     //   338: aload_0
/*     */     //   339: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   342: new java/lang/StringBuilder
/*     */     //   345: dup
/*     */     //   346: invokespecial <init> : ()V
/*     */     //   349: aload_1
/*     */     //   350: invokeinterface getHealth : ()F
/*     */     //   355: aload_1
/*     */     //   356: invokeinterface getMaxHealth : ()F
/*     */     //   361: fdiv
/*     */     //   362: f2d
/*     */     //   363: ldc2_w 1000.0
/*     */     //   366: dmul
/*     */     //   367: d2i
/*     */     //   368: i2f
/*     */     //   369: ldc 10.0
/*     */     //   371: fdiv
/*     */     //   372: invokestatic valueOf : (F)Ljava/lang/String;
/*     */     //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   378: ldc_w '%'
/*     */     //   381: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   384: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   387: ldc 36.0
/*     */     //   389: fload_2
/*     */     //   390: bipush #40
/*     */     //   392: i2f
/*     */     //   393: fsub
/*     */     //   394: fconst_2
/*     */     //   395: fdiv
/*     */     //   396: fadd
/*     */     //   397: ldc_w 19.0
/*     */     //   400: iconst_m1
/*     */     //   401: iconst_1
/*     */     //   402: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*     */     //   407: pop
/*     */     //   408: aload_0
/*     */     //   409: dup
/*     */     //   410: getfield easingHealth : F
/*     */     //   413: aload_1
/*     */     //   414: invokeinterface getHealth : ()F
/*     */     //   419: aload_0
/*     */     //   420: getfield easingHealth : F
/*     */     //   423: fsub
/*     */     //   424: fconst_2
/*     */     //   425: fstore #6
/*     */     //   427: ldc 10.0
/*     */     //   429: aload_0
/*     */     //   430: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   433: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   436: checkcast java/lang/Number
/*     */     //   439: invokevirtual floatValue : ()F
/*     */     //   442: fsub
/*     */     //   443: fstore #7
/*     */     //   445: fstore #14
/*     */     //   447: fstore #13
/*     */     //   449: astore #12
/*     */     //   451: iconst_0
/*     */     //   452: istore #8
/*     */     //   454: fload #6
/*     */     //   456: f2d
/*     */     //   457: fload #7
/*     */     //   459: f2d
/*     */     //   460: invokestatic pow : (DD)D
/*     */     //   463: d2f
/*     */     //   464: fstore #15
/*     */     //   466: aload #12
/*     */     //   468: fload #13
/*     */     //   470: fload #14
/*     */     //   472: fload #15
/*     */     //   474: fdiv
/*     */     //   475: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   478: i2f
/*     */     //   479: fmul
/*     */     //   480: fadd
/*     */     //   481: putfield easingHealth : F
/*     */     //   484: aload_1
/*     */     //   485: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   490: dup
/*     */     //   491: ifnull -> 530
/*     */     //   494: astore #6
/*     */     //   496: iconst_0
/*     */     //   497: istore #7
/*     */     //   499: iconst_0
/*     */     //   500: istore #8
/*     */     //   502: aload #6
/*     */     //   504: astore #9
/*     */     //   506: iconst_0
/*     */     //   507: istore #10
/*     */     //   509: aload_0
/*     */     //   510: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   513: aload #9
/*     */     //   515: bipush #36
/*     */     //   517: iconst_5
/*     */     //   518: ldc_w 16777215
/*     */     //   521: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   526: pop
/*     */     //   527: goto -> 531
/*     */     //   530: pop
/*     */     //   531: aload_0
/*     */     //   532: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   535: new java/lang/StringBuilder
/*     */     //   538: dup
/*     */     //   539: invokespecial <init> : ()V
/*     */     //   542: aload_1
/*     */     //   543: invokeinterface getHealth : ()F
/*     */     //   548: aload_1
/*     */     //   549: invokeinterface getMaxHealth : ()F
/*     */     //   554: fdiv
/*     */     //   555: f2d
/*     */     //   556: ldc2_w 1000.0
/*     */     //   559: dmul
/*     */     //   560: d2i
/*     */     //   561: i2f
/*     */     //   562: ldc 10.0
/*     */     //   564: fdiv
/*     */     //   565: invokestatic valueOf : (F)Ljava/lang/String;
/*     */     //   568: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   571: ldc_w '%'
/*     */     //   574: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   577: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   580: ldc 36.0
/*     */     //   582: fload_2
/*     */     //   583: bipush #40
/*     */     //   585: i2f
/*     */     //   586: fsub
/*     */     //   587: fconst_2
/*     */     //   588: fdiv
/*     */     //   589: fadd
/*     */     //   590: ldc_w 19.0
/*     */     //   593: iconst_m1
/*     */     //   594: iconst_1
/*     */     //   595: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*     */     //   600: pop
/*     */     //   601: aload_0
/*     */     //   602: dup
/*     */     //   603: getfield easingHealth : F
/*     */     //   606: aload_1
/*     */     //   607: invokeinterface getHealth : ()F
/*     */     //   612: aload_0
/*     */     //   613: getfield easingHealth : F
/*     */     //   616: fsub
/*     */     //   617: fconst_2
/*     */     //   618: fstore #6
/*     */     //   620: ldc 10.0
/*     */     //   622: aload_0
/*     */     //   623: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   626: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   629: checkcast java/lang/Number
/*     */     //   632: invokevirtual floatValue : ()F
/*     */     //   635: fsub
/*     */     //   636: fstore #7
/*     */     //   638: fstore #14
/*     */     //   640: fstore #13
/*     */     //   642: astore #12
/*     */     //   644: iconst_0
/*     */     //   645: istore #8
/*     */     //   647: fload #6
/*     */     //   649: f2d
/*     */     //   650: fload #7
/*     */     //   652: f2d
/*     */     //   653: invokestatic pow : (DD)D
/*     */     //   656: d2f
/*     */     //   657: fstore #15
/*     */     //   659: aload #12
/*     */     //   661: fload #13
/*     */     //   663: fload #14
/*     */     //   665: fload #15
/*     */     //   667: fdiv
/*     */     //   668: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   671: i2f
/*     */     //   672: fmul
/*     */     //   673: fadd
/*     */     //   674: putfield easingHealth : F
/*     */     //   677: aload_1
/*     */     //   678: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   683: dup
/*     */     //   684: ifnull -> 723
/*     */     //   687: astore #6
/*     */     //   689: iconst_0
/*     */     //   690: istore #7
/*     */     //   692: iconst_0
/*     */     //   693: istore #8
/*     */     //   695: aload #6
/*     */     //   697: astore #9
/*     */     //   699: iconst_0
/*     */     //   700: istore #10
/*     */     //   702: aload_0
/*     */     //   703: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   706: aload #9
/*     */     //   708: bipush #36
/*     */     //   710: iconst_5
/*     */     //   711: ldc_w 16777215
/*     */     //   714: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   719: pop
/*     */     //   720: goto -> 724
/*     */     //   723: pop
/*     */     //   724: aload_0
/*     */     //   725: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   728: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   731: checkcast java/lang/Boolean
/*     */     //   734: invokevirtual booleanValue : ()Z
/*     */     //   737: ifeq -> 795
/*     */     //   740: aload_0
/*     */     //   741: invokevirtual getRenderX : ()D
/*     */     //   744: dneg
/*     */     //   745: aload_0
/*     */     //   746: invokevirtual getRenderY : ()D
/*     */     //   749: dneg
/*     */     //   750: dconst_0
/*     */     //   751: invokestatic glTranslated : (DDD)V
/*     */     //   754: aload_0
/*     */     //   755: invokevirtual getRenderX : ()D
/*     */     //   758: fconst_0
/*     */     //   759: f2d
/*     */     //   760: dadd
/*     */     //   761: d2f
/*     */     //   762: aload_0
/*     */     //   763: invokevirtual getRenderY : ()D
/*     */     //   766: fconst_0
/*     */     //   767: f2d
/*     */     //   768: dadd
/*     */     //   769: d2f
/*     */     //   770: fload_2
/*     */     //   771: f2d
/*     */     //   772: d2f
/*     */     //   773: fload_3
/*     */     //   774: f2d
/*     */     //   775: d2f
/*     */     //   776: fconst_1
/*     */     //   777: ldc_w 8.0
/*     */     //   780: invokestatic CustomBlurRoundArea : (FFFFFF)V
/*     */     //   783: aload_0
/*     */     //   784: invokevirtual getRenderX : ()D
/*     */     //   787: aload_0
/*     */     //   788: invokevirtual getRenderY : ()D
/*     */     //   791: dconst_0
/*     */     //   792: invokestatic glTranslated : (DDD)V
/*     */     //   795: aload_0
/*     */     //   796: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   799: new java/lang/StringBuilder
/*     */     //   802: dup
/*     */     //   803: invokespecial <init> : ()V
/*     */     //   806: aload_1
/*     */     //   807: invokeinterface getHealth : ()F
/*     */     //   812: aload_1
/*     */     //   813: invokeinterface getMaxHealth : ()F
/*     */     //   818: fdiv
/*     */     //   819: f2d
/*     */     //   820: ldc2_w 1000.0
/*     */     //   823: dmul
/*     */     //   824: d2i
/*     */     //   825: i2f
/*     */     //   826: ldc 10.0
/*     */     //   828: fdiv
/*     */     //   829: invokestatic valueOf : (F)Ljava/lang/String;
/*     */     //   832: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   835: ldc_w '%'
/*     */     //   838: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   841: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   844: ldc 36.0
/*     */     //   846: fload_2
/*     */     //   847: bipush #40
/*     */     //   849: i2f
/*     */     //   850: fsub
/*     */     //   851: fconst_2
/*     */     //   852: fdiv
/*     */     //   853: fadd
/*     */     //   854: ldc_w 19.0
/*     */     //   857: iconst_m1
/*     */     //   858: iconst_1
/*     */     //   859: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*     */     //   864: pop
/*     */     //   865: aload_0
/*     */     //   866: dup
/*     */     //   867: getfield easingHealth : F
/*     */     //   870: aload_1
/*     */     //   871: invokeinterface getHealth : ()F
/*     */     //   876: aload_0
/*     */     //   877: getfield easingHealth : F
/*     */     //   880: fsub
/*     */     //   881: fconst_2
/*     */     //   882: fstore #6
/*     */     //   884: ldc 10.0
/*     */     //   886: aload_0
/*     */     //   887: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   890: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   893: checkcast java/lang/Number
/*     */     //   896: invokevirtual floatValue : ()F
/*     */     //   899: fsub
/*     */     //   900: fstore #7
/*     */     //   902: fstore #14
/*     */     //   904: fstore #13
/*     */     //   906: astore #12
/*     */     //   908: iconst_0
/*     */     //   909: istore #8
/*     */     //   911: fload #6
/*     */     //   913: f2d
/*     */     //   914: fload #7
/*     */     //   916: f2d
/*     */     //   917: invokestatic pow : (DD)D
/*     */     //   920: d2f
/*     */     //   921: fstore #15
/*     */     //   923: aload #12
/*     */     //   925: fload #13
/*     */     //   927: fload #14
/*     */     //   929: fload #15
/*     */     //   931: fdiv
/*     */     //   932: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   935: i2f
/*     */     //   936: fmul
/*     */     //   937: fadd
/*     */     //   938: putfield easingHealth : F
/*     */     //   941: aload_1
/*     */     //   942: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   947: dup
/*     */     //   948: ifnull -> 987
/*     */     //   951: astore #6
/*     */     //   953: iconst_0
/*     */     //   954: istore #7
/*     */     //   956: iconst_0
/*     */     //   957: istore #8
/*     */     //   959: aload #6
/*     */     //   961: astore #9
/*     */     //   963: iconst_0
/*     */     //   964: istore #10
/*     */     //   966: aload_0
/*     */     //   967: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   970: aload #9
/*     */     //   972: bipush #36
/*     */     //   974: iconst_5
/*     */     //   975: ldc_w 16777215
/*     */     //   978: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   983: pop
/*     */     //   984: goto -> 988
/*     */     //   987: pop
/*     */     //   988: aload_0
/*     */     //   989: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   992: new java/lang/StringBuilder
/*     */     //   995: dup
/*     */     //   996: invokespecial <init> : ()V
/*     */     //   999: aload_1
/*     */     //   1000: invokeinterface getHealth : ()F
/*     */     //   1005: aload_1
/*     */     //   1006: invokeinterface getMaxHealth : ()F
/*     */     //   1011: fdiv
/*     */     //   1012: f2d
/*     */     //   1013: ldc2_w 1000.0
/*     */     //   1016: dmul
/*     */     //   1017: d2i
/*     */     //   1018: i2f
/*     */     //   1019: ldc 10.0
/*     */     //   1021: fdiv
/*     */     //   1022: invokestatic valueOf : (F)Ljava/lang/String;
/*     */     //   1025: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1028: ldc_w '%'
/*     */     //   1031: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1034: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1037: ldc 36.0
/*     */     //   1039: fload_2
/*     */     //   1040: bipush #40
/*     */     //   1042: i2f
/*     */     //   1043: fsub
/*     */     //   1044: fconst_2
/*     */     //   1045: fdiv
/*     */     //   1046: fadd
/*     */     //   1047: ldc_w 19.0
/*     */     //   1050: iconst_m1
/*     */     //   1051: iconst_1
/*     */     //   1052: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*     */     //   1057: pop
/*     */     //   1058: aload_0
/*     */     //   1059: dup
/*     */     //   1060: getfield easingHealth : F
/*     */     //   1063: aload_1
/*     */     //   1064: invokeinterface getHealth : ()F
/*     */     //   1069: aload_0
/*     */     //   1070: getfield easingHealth : F
/*     */     //   1073: fsub
/*     */     //   1074: fconst_2
/*     */     //   1075: fstore #6
/*     */     //   1077: ldc 10.0
/*     */     //   1079: aload_0
/*     */     //   1080: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1083: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1086: checkcast java/lang/Number
/*     */     //   1089: invokevirtual floatValue : ()F
/*     */     //   1092: fsub
/*     */     //   1093: fstore #7
/*     */     //   1095: fstore #14
/*     */     //   1097: fstore #13
/*     */     //   1099: astore #12
/*     */     //   1101: iconst_0
/*     */     //   1102: istore #8
/*     */     //   1104: fload #6
/*     */     //   1106: f2d
/*     */     //   1107: fload #7
/*     */     //   1109: f2d
/*     */     //   1110: invokestatic pow : (DD)D
/*     */     //   1113: d2f
/*     */     //   1114: fstore #15
/*     */     //   1116: aload #12
/*     */     //   1118: fload #13
/*     */     //   1120: fload #14
/*     */     //   1122: fload #15
/*     */     //   1124: fdiv
/*     */     //   1125: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   1128: i2f
/*     */     //   1129: fmul
/*     */     //   1130: fadd
/*     */     //   1131: putfield easingHealth : F
/*     */     //   1134: aload_1
/*     */     //   1135: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1140: dup
/*     */     //   1141: ifnull -> 1180
/*     */     //   1144: astore #6
/*     */     //   1146: iconst_0
/*     */     //   1147: istore #7
/*     */     //   1149: iconst_0
/*     */     //   1150: istore #8
/*     */     //   1152: aload #6
/*     */     //   1154: astore #9
/*     */     //   1156: iconst_0
/*     */     //   1157: istore #10
/*     */     //   1159: aload_0
/*     */     //   1160: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1163: aload #9
/*     */     //   1165: bipush #36
/*     */     //   1167: iconst_5
/*     */     //   1168: ldc_w 16777215
/*     */     //   1171: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   1176: pop
/*     */     //   1177: goto -> 1181
/*     */     //   1180: pop
/*     */     //   1181: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1184: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1189: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1192: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1197: dup
/*     */     //   1198: ifnonnull -> 1204
/*     */     //   1201: invokestatic throwNpe : ()V
/*     */     //   1204: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   1209: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   1214: astore #6
/*     */     //   1216: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1219: aload_1
/*     */     //   1220: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   1225: ifeq -> 1249
/*     */     //   1228: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1231: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1236: aload_1
/*     */     //   1237: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   1242: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   1247: astore #6
/*     */     //   1249: aload #6
/*     */     //   1251: ifnull -> 1466
/*     */     //   1254: aload #6
/*     */     //   1256: invokeinterface getLocationSkin : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   1261: astore #7
/*     */     //   1263: aload_1
/*     */     //   1264: invokeinterface getHurtTime : ()I
/*     */     //   1269: i2f
/*     */     //   1270: aload_1
/*     */     //   1271: invokeinterface getHurtTime : ()I
/*     */     //   1276: ifeq -> 1291
/*     */     //   1279: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
/*     */     //   1282: getfield field_71428_T : Lnet/minecraft/util/Timer;
/*     */     //   1285: getfield field_194147_b : F
/*     */     //   1288: goto -> 1292
/*     */     //   1291: fconst_0
/*     */     //   1292: fsub
/*     */     //   1293: fstore #8
/*     */     //   1295: fload #8
/*     */     //   1297: ldc 10.0
/*     */     //   1299: fdiv
/*     */     //   1300: fstore #9
/*     */     //   1302: fconst_1
/*     */     //   1303: iconst_1
/*     */     //   1304: i2f
/*     */     //   1305: fload #9
/*     */     //   1307: fsub
/*     */     //   1308: iconst_1
/*     */     //   1309: i2f
/*     */     //   1310: fload #9
/*     */     //   1312: fsub
/*     */     //   1313: fconst_1
/*     */     //   1314: invokestatic glColor4f : (FFFF)V
/*     */     //   1317: fload #9
/*     */     //   1319: fconst_0
/*     */     //   1320: fcmpg
/*     */     //   1321: ifne -> 1328
/*     */     //   1324: fconst_1
/*     */     //   1325: goto -> 1369
/*     */     //   1328: fload #9
/*     */     //   1330: ldc_w 0.5
/*     */     //   1333: fcmpg
/*     */     //   1334: ifge -> 1352
/*     */     //   1337: iconst_1
/*     */     //   1338: i2f
/*     */     //   1339: ldc_w 0.2
/*     */     //   1342: fload #9
/*     */     //   1344: fmul
/*     */     //   1345: iconst_2
/*     */     //   1346: i2f
/*     */     //   1347: fmul
/*     */     //   1348: fsub
/*     */     //   1349: goto -> 1369
/*     */     //   1352: ldc_w 0.8
/*     */     //   1355: ldc_w 0.2
/*     */     //   1358: fload #9
/*     */     //   1360: ldc_w 0.5
/*     */     //   1363: fsub
/*     */     //   1364: fmul
/*     */     //   1365: iconst_2
/*     */     //   1366: i2f
/*     */     //   1367: fmul
/*     */     //   1368: fadd
/*     */     //   1369: fstore #10
/*     */     //   1371: bipush #30
/*     */     //   1373: istore #11
/*     */     //   1375: invokestatic glPushMatrix : ()V
/*     */     //   1378: fload #10
/*     */     //   1380: fload #10
/*     */     //   1382: fload #10
/*     */     //   1384: invokestatic glScalef : (FFF)V
/*     */     //   1387: iload #11
/*     */     //   1389: i2f
/*     */     //   1390: ldc_w 0.5
/*     */     //   1393: fmul
/*     */     //   1394: iconst_1
/*     */     //   1395: i2f
/*     */     //   1396: fload #10
/*     */     //   1398: fsub
/*     */     //   1399: fmul
/*     */     //   1400: fload #10
/*     */     //   1402: fdiv
/*     */     //   1403: iload #11
/*     */     //   1405: i2f
/*     */     //   1406: ldc_w 0.5
/*     */     //   1409: fmul
/*     */     //   1410: iconst_1
/*     */     //   1411: i2f
/*     */     //   1412: fload #10
/*     */     //   1414: fsub
/*     */     //   1415: fmul
/*     */     //   1416: fload #10
/*     */     //   1418: fdiv
/*     */     //   1419: fconst_0
/*     */     //   1420: invokestatic glTranslatef : (FFF)V
/*     */     //   1423: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1426: invokeinterface getTextureManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;
/*     */     //   1431: aload #7
/*     */     //   1433: invokeinterface bindTexture : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V
/*     */     //   1438: iconst_2
/*     */     //   1439: iconst_2
/*     */     //   1440: ldc_w 8.0
/*     */     //   1443: ldc_w 8.0
/*     */     //   1446: bipush #8
/*     */     //   1448: bipush #8
/*     */     //   1450: iload #11
/*     */     //   1452: iload #11
/*     */     //   1454: ldc_w 64.0
/*     */     //   1457: ldc_w 64.0
/*     */     //   1460: invokestatic drawScaledCustomSizeModalRect : (IIFFIIIIFF)V
/*     */     //   1463: invokestatic glPopMatrix : ()V
/*     */     //   1466: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #298	-> 0
/*     */     //   #299	-> 4
/*     */     //   #300	-> 4
/*     */     //   #301	-> 57
/*     */     //   #304	-> 67
/*     */     //   #305	-> 112
/*     */     //   #309	-> 157
/*     */     //   #310	-> 181
/*     */     //   #309	-> 226
/*     */     //   #311	-> 229
/*     */     //   #312	-> 245
/*     */     //   #316	-> 259
/*     */     //   #318	-> 294
/*     */     //   #319	-> 322
/*     */     //   #318	-> 335
/*     */     //   #321	-> 338
/*     */     //   #327	-> 408
/*     */     //   #327	-> 474
/*     */     //   #329	-> 484
/*     */     //   #329	-> 509
/*     */     //   #329	-> 527
/*     */     //   #331	-> 531
/*     */     //   #337	-> 601
/*     */     //   #337	-> 667
/*     */     //   #339	-> 677
/*     */     //   #339	-> 702
/*     */     //   #339	-> 720
/*     */     //   #340	-> 724
/*     */     //   #341	-> 740
/*     */     //   #343	-> 754
/*     */     //   #344	-> 762
/*     */     //   #343	-> 780
/*     */     //   #346	-> 783
/*     */     //   #348	-> 795
/*     */     //   #354	-> 865
/*     */     //   #354	-> 931
/*     */     //   #356	-> 941
/*     */     //   #356	-> 966
/*     */     //   #356	-> 984
/*     */     //   #358	-> 988
/*     */     //   #364	-> 1058
/*     */     //   #364	-> 1124
/*     */     //   #366	-> 1134
/*     */     //   #366	-> 1159
/*     */     //   #366	-> 1177
/*     */     //   #381	-> 1181
/*     */     //   #382	-> 1216
/*     */     //   #383	-> 1228
/*     */     //   #385	-> 1249
/*     */     //   #388	-> 1254
/*     */     //   #390	-> 1263
/*     */     //   #392	-> 1295
/*     */     //   #393	-> 1302
/*     */     //   #395	-> 1317
/*     */     //   #396	-> 1337
/*     */     //   #398	-> 1352
/*     */     //   #395	-> 1369
/*     */     //   #400	-> 1371
/*     */     //   #402	-> 1375
/*     */     //   #404	-> 1378
/*     */     //   #405	-> 1387
/*     */     //   #407	-> 1423
/*     */     //   #408	-> 1438
/*     */     //   #409	-> 1454
/*     */     //   #408	-> 1460
/*     */     //   #411	-> 1463
/*     */     //   #414	-> 1466
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   506	20	9	it	Ljava/lang/String;
/*     */     //   509	17	10	$i$a$-let-TargetHud$novoline$1	I
/*     */     //   699	20	9	it	Ljava/lang/String;
/*     */     //   702	17	10	$i$a$-let-TargetHud$novoline$2	I
/*     */     //   963	20	9	it	Ljava/lang/String;
/*     */     //   966	17	10	$i$a$-let-TargetHud$novoline$3	I
/*     */     //   1156	20	9	it	Ljava/lang/String;
/*     */     //   1159	17	10	$i$a$-let-TargetHud$novoline$4	I
/*     */     //   1375	91	11	size	I
/*     */     //   1371	95	10	scale	F
/*     */     //   1302	164	9	hurtPercent	F
/*     */     //   1295	171	8	renderHurtTime	F
/*     */     //   1263	203	7	locationSkin	Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   1216	250	6	playerInfo	Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   157	1309	5	c2	Ljava/awt/Color;
/*     */     //   112	1354	4	c	Ljava/awt/Color;
/*     */     //   0	1467	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;
/*     */     //   0	1467	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	1467	2	width	F
/*     */     //   0	1467	3	height	F
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
/*     */   private final void cou(IEntityLivingBase target, float width, float height) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 1485
/*     */     //   4: aload_0
/*     */     //   5: getfield easingHealth : F
/*     */     //   8: iconst_0
/*     */     //   9: i2f
/*     */     //   10: fcmpg
/*     */     //   11: iflt -> 57
/*     */     //   14: aload_0
/*     */     //   15: getfield easingHealth : F
/*     */     //   18: aload_1
/*     */     //   19: invokeinterface getMaxHealth : ()F
/*     */     //   24: fcmpl
/*     */     //   25: ifgt -> 57
/*     */     //   28: aload_0
/*     */     //   29: getfield easingHealth : F
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface getHealth : ()F
/*     */     //   38: fsub
/*     */     //   39: fstore #4
/*     */     //   41: iconst_0
/*     */     //   42: istore #5
/*     */     //   44: fload #4
/*     */     //   46: invokestatic abs : (F)F
/*     */     //   49: f2d
/*     */     //   50: ldc2_w 0.01
/*     */     //   53: dcmpg
/*     */     //   54: ifge -> 67
/*     */     //   57: aload_0
/*     */     //   58: aload_1
/*     */     //   59: invokeinterface getHealth : ()F
/*     */     //   64: putfield easingHealth : F
/*     */     //   67: new java/awt/Color
/*     */     //   70: dup
/*     */     //   71: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   74: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   77: checkcast java/lang/Number
/*     */     //   80: invokevirtual intValue : ()I
/*     */     //   83: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   86: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   89: checkcast java/lang/Number
/*     */     //   92: invokevirtual intValue : ()I
/*     */     //   95: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   98: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   101: checkcast java/lang/Number
/*     */     //   104: invokevirtual intValue : ()I
/*     */     //   107: invokespecial <init> : (III)V
/*     */     //   110: astore #4
/*     */     //   112: new java/awt/Color
/*     */     //   115: dup
/*     */     //   116: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   119: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   122: checkcast java/lang/Number
/*     */     //   125: invokevirtual intValue : ()I
/*     */     //   128: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   131: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   134: checkcast java/lang/Number
/*     */     //   137: invokevirtual intValue : ()I
/*     */     //   140: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   146: checkcast java/lang/Number
/*     */     //   149: invokevirtual intValue : ()I
/*     */     //   152: invokespecial <init> : (III)V
/*     */     //   155: astore #5
/*     */     //   157: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   160: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   163: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/PictureColor
/*     */     //   166: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   169: dup
/*     */     //   170: ifnonnull -> 184
/*     */     //   173: new kotlin/TypeCastException
/*     */     //   176: dup
/*     */     //   177: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor'
/*     */     //   180: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   183: athrow
/*     */     //   184: checkcast net/ccbluex/liquidbounce/features/module/modules/render/PictureColor
/*     */     //   187: astore #6
/*     */     //   189: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   192: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   195: ldc_w net/ccbluex/liquidbounce/features/module/modules/render/PictureColor2
/*     */     //   198: invokevirtual getModule : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   201: dup
/*     */     //   202: ifnonnull -> 216
/*     */     //   205: new kotlin/TypeCastException
/*     */     //   208: dup
/*     */     //   209: ldc_w 'null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.render.PictureColor2'
/*     */     //   212: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   215: athrow
/*     */     //   216: checkcast net/ccbluex/liquidbounce/features/module/modules/render/PictureColor2
/*     */     //   219: astore #7
/*     */     //   221: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   224: astore #8
/*     */     //   226: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   229: astore #9
/*     */     //   231: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   234: astore #10
/*     */     //   236: getstatic java/awt/Color.WHITE : Ljava/awt/Color;
/*     */     //   239: astore #11
/*     */     //   241: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   244: bipush #10
/*     */     //   246: bipush #20
/*     */     //   248: new java/awt/Color
/*     */     //   251: dup
/*     */     //   252: aload #6
/*     */     //   254: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   257: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   260: checkcast java/lang/Number
/*     */     //   263: invokevirtual intValue : ()I
/*     */     //   266: aload #6
/*     */     //   268: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   271: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   274: checkcast java/lang/Number
/*     */     //   277: invokevirtual intValue : ()I
/*     */     //   280: aload #6
/*     */     //   282: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   285: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   288: checkcast java/lang/Number
/*     */     //   291: invokevirtual intValue : ()I
/*     */     //   294: aload #6
/*     */     //   296: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   299: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   302: checkcast java/lang/Number
/*     */     //   305: invokevirtual intValue : ()I
/*     */     //   308: invokespecial <init> : (IIII)V
/*     */     //   311: new java/awt/Color
/*     */     //   314: dup
/*     */     //   315: aload #7
/*     */     //   317: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   320: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   323: checkcast java/lang/Number
/*     */     //   326: invokevirtual intValue : ()I
/*     */     //   329: aload #7
/*     */     //   331: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   334: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   337: checkcast java/lang/Number
/*     */     //   340: invokevirtual intValue : ()I
/*     */     //   343: aload #7
/*     */     //   345: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   348: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   351: checkcast java/lang/Number
/*     */     //   354: invokevirtual intValue : ()I
/*     */     //   357: aload #7
/*     */     //   359: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   362: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   365: checkcast java/lang/Number
/*     */     //   368: invokevirtual intValue : ()I
/*     */     //   371: invokespecial <init> : (IIII)V
/*     */     //   374: iconst_0
/*     */     //   375: invokevirtual interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   378: astore #8
/*     */     //   380: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   383: bipush #20
/*     */     //   385: bipush #90
/*     */     //   387: new java/awt/Color
/*     */     //   390: dup
/*     */     //   391: aload #7
/*     */     //   393: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   396: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   399: checkcast java/lang/Number
/*     */     //   402: invokevirtual intValue : ()I
/*     */     //   405: aload #7
/*     */     //   407: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   410: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   413: checkcast java/lang/Number
/*     */     //   416: invokevirtual intValue : ()I
/*     */     //   419: aload #7
/*     */     //   421: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   424: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   427: checkcast java/lang/Number
/*     */     //   430: invokevirtual intValue : ()I
/*     */     //   433: aload #6
/*     */     //   435: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   438: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   441: checkcast java/lang/Number
/*     */     //   444: invokevirtual intValue : ()I
/*     */     //   447: invokespecial <init> : (IIII)V
/*     */     //   450: new java/awt/Color
/*     */     //   453: dup
/*     */     //   454: aload #7
/*     */     //   456: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   459: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   462: checkcast java/lang/Number
/*     */     //   465: invokevirtual intValue : ()I
/*     */     //   468: aload #7
/*     */     //   470: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   473: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   476: checkcast java/lang/Number
/*     */     //   479: invokevirtual intValue : ()I
/*     */     //   482: aload #7
/*     */     //   484: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   487: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   490: checkcast java/lang/Number
/*     */     //   493: invokevirtual intValue : ()I
/*     */     //   496: aload #7
/*     */     //   498: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   501: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   504: checkcast java/lang/Number
/*     */     //   507: invokevirtual intValue : ()I
/*     */     //   510: invokespecial <init> : (IIII)V
/*     */     //   513: iconst_0
/*     */     //   514: invokevirtual interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   517: astore #9
/*     */     //   519: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   522: bipush #20
/*     */     //   524: sipush #270
/*     */     //   527: new java/awt/Color
/*     */     //   530: dup
/*     */     //   531: aload #6
/*     */     //   533: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   536: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   539: checkcast java/lang/Number
/*     */     //   542: invokevirtual intValue : ()I
/*     */     //   545: aload #6
/*     */     //   547: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   550: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   553: checkcast java/lang/Number
/*     */     //   556: invokevirtual intValue : ()I
/*     */     //   559: aload #6
/*     */     //   561: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   564: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   567: checkcast java/lang/Number
/*     */     //   570: invokevirtual intValue : ()I
/*     */     //   573: aload #6
/*     */     //   575: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   578: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   581: checkcast java/lang/Number
/*     */     //   584: invokevirtual intValue : ()I
/*     */     //   587: invokespecial <init> : (IIII)V
/*     */     //   590: new java/awt/Color
/*     */     //   593: dup
/*     */     //   594: aload #6
/*     */     //   596: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   599: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   602: checkcast java/lang/Number
/*     */     //   605: invokevirtual intValue : ()I
/*     */     //   608: aload #6
/*     */     //   610: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   613: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   616: checkcast java/lang/Number
/*     */     //   619: invokevirtual intValue : ()I
/*     */     //   622: aload #6
/*     */     //   624: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   627: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   630: checkcast java/lang/Number
/*     */     //   633: invokevirtual intValue : ()I
/*     */     //   636: aload #7
/*     */     //   638: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   641: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   644: checkcast java/lang/Number
/*     */     //   647: invokevirtual intValue : ()I
/*     */     //   650: invokespecial <init> : (IIII)V
/*     */     //   653: iconst_0
/*     */     //   654: invokevirtual interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   657: astore #10
/*     */     //   659: getstatic net/ccbluex/liquidbounce/utils/render/ColorUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/render/ColorUtils;
/*     */     //   662: bipush #20
/*     */     //   664: sipush #270
/*     */     //   667: new java/awt/Color
/*     */     //   670: dup
/*     */     //   671: aload #7
/*     */     //   673: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   676: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   679: checkcast java/lang/Number
/*     */     //   682: invokevirtual intValue : ()I
/*     */     //   685: aload #7
/*     */     //   687: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   690: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   693: checkcast java/lang/Number
/*     */     //   696: invokevirtual intValue : ()I
/*     */     //   699: aload #7
/*     */     //   701: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   704: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   707: checkcast java/lang/Number
/*     */     //   710: invokevirtual intValue : ()I
/*     */     //   713: aload #6
/*     */     //   715: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   718: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   721: checkcast java/lang/Number
/*     */     //   724: invokevirtual intValue : ()I
/*     */     //   727: invokespecial <init> : (IIII)V
/*     */     //   730: new java/awt/Color
/*     */     //   733: dup
/*     */     //   734: aload #7
/*     */     //   736: invokevirtual getColorRedValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   739: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   742: checkcast java/lang/Number
/*     */     //   745: invokevirtual intValue : ()I
/*     */     //   748: aload #7
/*     */     //   750: invokevirtual getColorGreenValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   753: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   756: checkcast java/lang/Number
/*     */     //   759: invokevirtual intValue : ()I
/*     */     //   762: aload #7
/*     */     //   764: invokevirtual getColorBlueValue : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   767: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   770: checkcast java/lang/Number
/*     */     //   773: invokevirtual intValue : ()I
/*     */     //   776: aload #7
/*     */     //   778: invokevirtual getColoralpha : ()Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   781: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   784: checkcast java/lang/Number
/*     */     //   787: invokevirtual intValue : ()I
/*     */     //   790: invokespecial <init> : (IIII)V
/*     */     //   793: iconst_0
/*     */     //   794: invokevirtual interpolateColorsBackAndForth : (IILjava/awt/Color;Ljava/awt/Color;Z)Ljava/awt/Color;
/*     */     //   797: astore #11
/*     */     //   799: fconst_0
/*     */     //   800: fconst_0
/*     */     //   801: fload_2
/*     */     //   802: f2d
/*     */     //   803: d2f
/*     */     //   804: fload_3
/*     */     //   805: f2d
/*     */     //   806: d2f
/*     */     //   807: aload_0
/*     */     //   808: getfield ra : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   811: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   814: checkcast java/lang/Number
/*     */     //   817: invokevirtual floatValue : ()F
/*     */     //   820: aload #8
/*     */     //   822: aload #10
/*     */     //   824: aload #9
/*     */     //   826: aload #8
/*     */     //   828: invokestatic drawGradientRound : (FFFFFLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;)V
/*     */     //   831: aload_0
/*     */     //   832: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   835: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   838: checkcast java/lang/Boolean
/*     */     //   841: invokevirtual booleanValue : ()Z
/*     */     //   844: ifeq -> 861
/*     */     //   847: fconst_0
/*     */     //   848: fconst_0
/*     */     //   849: fload_2
/*     */     //   850: f2d
/*     */     //   851: d2f
/*     */     //   852: fload_3
/*     */     //   853: f2d
/*     */     //   854: d2f
/*     */     //   855: ldc_w 255.0
/*     */     //   858: invokestatic drawShadowWithCustomAlpha : (FFFFF)V
/*     */     //   861: aload_0
/*     */     //   862: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   865: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   868: checkcast java/lang/Boolean
/*     */     //   871: invokevirtual booleanValue : ()Z
/*     */     //   874: ifeq -> 928
/*     */     //   877: aload_0
/*     */     //   878: invokevirtual getRenderX : ()D
/*     */     //   881: dneg
/*     */     //   882: aload_0
/*     */     //   883: invokevirtual getRenderY : ()D
/*     */     //   886: dneg
/*     */     //   887: dconst_0
/*     */     //   888: invokestatic glTranslated : (DDD)V
/*     */     //   891: aload_0
/*     */     //   892: invokevirtual getRenderX : ()D
/*     */     //   895: fconst_0
/*     */     //   896: f2d
/*     */     //   897: dadd
/*     */     //   898: d2f
/*     */     //   899: aload_0
/*     */     //   900: invokevirtual getRenderY : ()D
/*     */     //   903: fconst_0
/*     */     //   904: f2d
/*     */     //   905: dadd
/*     */     //   906: d2f
/*     */     //   907: fload_2
/*     */     //   908: f2d
/*     */     //   909: d2f
/*     */     //   910: fload_3
/*     */     //   911: f2d
/*     */     //   912: d2f
/*     */     //   913: invokestatic blurArea : (FFFF)V
/*     */     //   916: aload_0
/*     */     //   917: invokevirtual getRenderX : ()D
/*     */     //   920: aload_0
/*     */     //   921: invokevirtual getRenderY : ()D
/*     */     //   924: dconst_0
/*     */     //   925: invokestatic glTranslated : (DDD)V
/*     */     //   928: ldc2_w 36.0
/*     */     //   931: ldc2_w 17.0
/*     */     //   934: fload_2
/*     */     //   935: f2d
/*     */     //   936: iconst_4
/*     */     //   937: i2d
/*     */     //   938: dsub
/*     */     //   939: ldc2_w 27.0
/*     */     //   942: new java/awt/Color
/*     */     //   945: dup
/*     */     //   946: bipush #35
/*     */     //   948: bipush #35
/*     */     //   950: bipush #35
/*     */     //   952: bipush #20
/*     */     //   954: invokespecial <init> : (IIII)V
/*     */     //   957: invokevirtual getRGB : ()I
/*     */     //   960: invokestatic rectangle : (DDDDI)V
/*     */     //   963: ldc2_w 36.0
/*     */     //   966: ldc2_w 17.0
/*     */     //   969: ldc2_w 36.0
/*     */     //   972: aload_0
/*     */     //   973: getfield easingHealth : F
/*     */     //   976: aload_1
/*     */     //   977: invokeinterface getMaxHealth : ()F
/*     */     //   982: fdiv
/*     */     //   983: fload_2
/*     */     //   984: bipush #40
/*     */     //   986: i2f
/*     */     //   987: fsub
/*     */     //   988: fmul
/*     */     //   989: f2d
/*     */     //   990: dadd
/*     */     //   991: ldc2_w 27.0
/*     */     //   994: aload #5
/*     */     //   996: invokevirtual getRGB : ()I
/*     */     //   999: aload #4
/*     */     //   1001: invokevirtual getRGB : ()I
/*     */     //   1004: invokestatic drawGradientSideways : (DDDDII)V
/*     */     //   1007: aload_0
/*     */     //   1008: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1011: new java/lang/StringBuilder
/*     */     //   1014: dup
/*     */     //   1015: invokespecial <init> : ()V
/*     */     //   1018: aload_1
/*     */     //   1019: invokeinterface getHealth : ()F
/*     */     //   1024: aload_1
/*     */     //   1025: invokeinterface getMaxHealth : ()F
/*     */     //   1030: fdiv
/*     */     //   1031: f2d
/*     */     //   1032: ldc2_w 1000.0
/*     */     //   1035: dmul
/*     */     //   1036: d2i
/*     */     //   1037: i2f
/*     */     //   1038: ldc 10.0
/*     */     //   1040: fdiv
/*     */     //   1041: invokestatic valueOf : (F)Ljava/lang/String;
/*     */     //   1044: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1047: ldc_w '%'
/*     */     //   1050: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   1053: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   1056: ldc 36.0
/*     */     //   1058: fload_2
/*     */     //   1059: bipush #40
/*     */     //   1061: i2f
/*     */     //   1062: fsub
/*     */     //   1063: fconst_2
/*     */     //   1064: fdiv
/*     */     //   1065: fadd
/*     */     //   1066: ldc_w 19.0
/*     */     //   1069: iconst_m1
/*     */     //   1070: iconst_1
/*     */     //   1071: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*     */     //   1076: pop
/*     */     //   1077: aload_0
/*     */     //   1078: dup
/*     */     //   1079: getfield easingHealth : F
/*     */     //   1082: aload_1
/*     */     //   1083: invokeinterface getHealth : ()F
/*     */     //   1088: aload_0
/*     */     //   1089: getfield easingHealth : F
/*     */     //   1092: fsub
/*     */     //   1093: fconst_2
/*     */     //   1094: fstore #12
/*     */     //   1096: ldc 10.0
/*     */     //   1098: aload_0
/*     */     //   1099: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1102: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1105: checkcast java/lang/Number
/*     */     //   1108: invokevirtual floatValue : ()F
/*     */     //   1111: fsub
/*     */     //   1112: fstore #13
/*     */     //   1114: fstore #20
/*     */     //   1116: fstore #19
/*     */     //   1118: astore #18
/*     */     //   1120: iconst_0
/*     */     //   1121: istore #14
/*     */     //   1123: fload #12
/*     */     //   1125: f2d
/*     */     //   1126: fload #13
/*     */     //   1128: f2d
/*     */     //   1129: invokestatic pow : (DD)D
/*     */     //   1132: d2f
/*     */     //   1133: fstore #21
/*     */     //   1135: aload #18
/*     */     //   1137: fload #19
/*     */     //   1139: fload #20
/*     */     //   1141: fload #21
/*     */     //   1143: fdiv
/*     */     //   1144: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   1147: i2f
/*     */     //   1148: fmul
/*     */     //   1149: fadd
/*     */     //   1150: putfield easingHealth : F
/*     */     //   1153: aload_1
/*     */     //   1154: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   1159: dup
/*     */     //   1160: ifnull -> 1199
/*     */     //   1163: astore #12
/*     */     //   1165: iconst_0
/*     */     //   1166: istore #13
/*     */     //   1168: iconst_0
/*     */     //   1169: istore #14
/*     */     //   1171: aload #12
/*     */     //   1173: astore #15
/*     */     //   1175: iconst_0
/*     */     //   1176: istore #16
/*     */     //   1178: aload_0
/*     */     //   1179: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   1182: aload #15
/*     */     //   1184: bipush #36
/*     */     //   1186: iconst_5
/*     */     //   1187: ldc_w 16777215
/*     */     //   1190: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   1195: pop
/*     */     //   1196: goto -> 1200
/*     */     //   1199: pop
/*     */     //   1200: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1203: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1208: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1211: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1216: dup
/*     */     //   1217: ifnonnull -> 1223
/*     */     //   1220: invokestatic throwNpe : ()V
/*     */     //   1223: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   1228: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   1233: astore #12
/*     */     //   1235: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1238: aload_1
/*     */     //   1239: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   1244: ifeq -> 1268
/*     */     //   1247: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1250: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   1255: aload_1
/*     */     //   1256: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   1261: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   1266: astore #12
/*     */     //   1268: aload #12
/*     */     //   1270: ifnull -> 1485
/*     */     //   1273: aload #12
/*     */     //   1275: invokeinterface getLocationSkin : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   1280: astore #13
/*     */     //   1282: aload_1
/*     */     //   1283: invokeinterface getHurtTime : ()I
/*     */     //   1288: i2f
/*     */     //   1289: aload_1
/*     */     //   1290: invokeinterface getHurtTime : ()I
/*     */     //   1295: ifeq -> 1310
/*     */     //   1298: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
/*     */     //   1301: getfield field_71428_T : Lnet/minecraft/util/Timer;
/*     */     //   1304: getfield field_194147_b : F
/*     */     //   1307: goto -> 1311
/*     */     //   1310: fconst_0
/*     */     //   1311: fsub
/*     */     //   1312: fstore #14
/*     */     //   1314: fload #14
/*     */     //   1316: ldc 10.0
/*     */     //   1318: fdiv
/*     */     //   1319: fstore #15
/*     */     //   1321: fconst_1
/*     */     //   1322: iconst_1
/*     */     //   1323: i2f
/*     */     //   1324: fload #15
/*     */     //   1326: fsub
/*     */     //   1327: iconst_1
/*     */     //   1328: i2f
/*     */     //   1329: fload #15
/*     */     //   1331: fsub
/*     */     //   1332: fconst_1
/*     */     //   1333: invokestatic glColor4f : (FFFF)V
/*     */     //   1336: fload #15
/*     */     //   1338: fconst_0
/*     */     //   1339: fcmpg
/*     */     //   1340: ifne -> 1347
/*     */     //   1343: fconst_1
/*     */     //   1344: goto -> 1388
/*     */     //   1347: fload #15
/*     */     //   1349: ldc_w 0.5
/*     */     //   1352: fcmpg
/*     */     //   1353: ifge -> 1371
/*     */     //   1356: iconst_1
/*     */     //   1357: i2f
/*     */     //   1358: ldc_w 0.2
/*     */     //   1361: fload #15
/*     */     //   1363: fmul
/*     */     //   1364: iconst_2
/*     */     //   1365: i2f
/*     */     //   1366: fmul
/*     */     //   1367: fsub
/*     */     //   1368: goto -> 1388
/*     */     //   1371: ldc_w 0.8
/*     */     //   1374: ldc_w 0.2
/*     */     //   1377: fload #15
/*     */     //   1379: ldc_w 0.5
/*     */     //   1382: fsub
/*     */     //   1383: fmul
/*     */     //   1384: iconst_2
/*     */     //   1385: i2f
/*     */     //   1386: fmul
/*     */     //   1387: fadd
/*     */     //   1388: fstore #16
/*     */     //   1390: bipush #30
/*     */     //   1392: istore #17
/*     */     //   1394: invokestatic glPushMatrix : ()V
/*     */     //   1397: fload #16
/*     */     //   1399: fload #16
/*     */     //   1401: fload #16
/*     */     //   1403: invokestatic glScalef : (FFF)V
/*     */     //   1406: iload #17
/*     */     //   1408: i2f
/*     */     //   1409: ldc_w 0.5
/*     */     //   1412: fmul
/*     */     //   1413: iconst_1
/*     */     //   1414: i2f
/*     */     //   1415: fload #16
/*     */     //   1417: fsub
/*     */     //   1418: fmul
/*     */     //   1419: fload #16
/*     */     //   1421: fdiv
/*     */     //   1422: iload #17
/*     */     //   1424: i2f
/*     */     //   1425: ldc_w 0.5
/*     */     //   1428: fmul
/*     */     //   1429: iconst_1
/*     */     //   1430: i2f
/*     */     //   1431: fload #16
/*     */     //   1433: fsub
/*     */     //   1434: fmul
/*     */     //   1435: fload #16
/*     */     //   1437: fdiv
/*     */     //   1438: fconst_0
/*     */     //   1439: invokestatic glTranslatef : (FFF)V
/*     */     //   1442: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1445: invokeinterface getTextureManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;
/*     */     //   1450: aload #13
/*     */     //   1452: invokeinterface bindTexture : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V
/*     */     //   1457: iconst_2
/*     */     //   1458: iconst_2
/*     */     //   1459: ldc_w 8.0
/*     */     //   1462: ldc_w 8.0
/*     */     //   1465: bipush #8
/*     */     //   1467: bipush #8
/*     */     //   1469: iload #17
/*     */     //   1471: iload #17
/*     */     //   1473: ldc_w 64.0
/*     */     //   1476: ldc_w 64.0
/*     */     //   1479: invokestatic drawScaledCustomSizeModalRect : (IIFFIIIIFF)V
/*     */     //   1482: invokestatic glPopMatrix : ()V
/*     */     //   1485: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #416	-> 0
/*     */     //   #417	-> 4
/*     */     //   #418	-> 4
/*     */     //   #419	-> 57
/*     */     //   #422	-> 67
/*     */     //   #423	-> 112
/*     */     //   #424	-> 157
/*     */     //   #425	-> 189
/*     */     //   #426	-> 221
/*     */     //   #427	-> 226
/*     */     //   #428	-> 231
/*     */     //   #429	-> 236
/*     */     //   #430	-> 241
/*     */     //   #431	-> 380
/*     */     //   #432	-> 519
/*     */     //   #433	-> 659
/*     */     //   #438	-> 799
/*     */     //   #439	-> 800
/*     */     //   #440	-> 801
/*     */     //   #441	-> 807
/*     */     //   #438	-> 828
/*     */     //   #443	-> 831
/*     */     //   #444	-> 847
/*     */     //   #446	-> 861
/*     */     //   #447	-> 877
/*     */     //   #449	-> 891
/*     */     //   #450	-> 899
/*     */     //   #449	-> 913
/*     */     //   #452	-> 916
/*     */     //   #455	-> 928
/*     */     //   #457	-> 963
/*     */     //   #458	-> 991
/*     */     //   #457	-> 1004
/*     */     //   #460	-> 1007
/*     */     //   #466	-> 1077
/*     */     //   #466	-> 1143
/*     */     //   #468	-> 1153
/*     */     //   #468	-> 1178
/*     */     //   #468	-> 1196
/*     */     //   #474	-> 1200
/*     */     //   #475	-> 1235
/*     */     //   #476	-> 1247
/*     */     //   #478	-> 1268
/*     */     //   #481	-> 1273
/*     */     //   #483	-> 1282
/*     */     //   #485	-> 1314
/*     */     //   #486	-> 1321
/*     */     //   #488	-> 1336
/*     */     //   #489	-> 1356
/*     */     //   #491	-> 1371
/*     */     //   #488	-> 1388
/*     */     //   #493	-> 1390
/*     */     //   #495	-> 1394
/*     */     //   #497	-> 1397
/*     */     //   #498	-> 1406
/*     */     //   #500	-> 1442
/*     */     //   #501	-> 1457
/*     */     //   #502	-> 1473
/*     */     //   #501	-> 1479
/*     */     //   #504	-> 1482
/*     */     //   #507	-> 1485
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   1175	20	15	it	Ljava/lang/String;
/*     */     //   1178	17	16	$i$a$-let-TargetHud$cou$1	I
/*     */     //   1394	91	17	size	I
/*     */     //   1390	95	16	scale	F
/*     */     //   1321	164	15	hurtPercent	F
/*     */     //   1314	171	14	renderHurtTime	F
/*     */     //   1282	203	13	locationSkin	Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   1235	250	12	playerInfo	Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   241	1244	11	gradientColor4	Ljava/awt/Color;
/*     */     //   236	1249	10	gradientColor3	Ljava/awt/Color;
/*     */     //   231	1254	9	gradientColor2	Ljava/awt/Color;
/*     */     //   226	1259	8	gradientColor1	Ljava/awt/Color;
/*     */     //   221	1264	7	color2	Lnet/ccbluex/liquidbounce/features/module/modules/render/PictureColor2;
/*     */     //   189	1296	6	color	Lnet/ccbluex/liquidbounce/features/module/modules/render/PictureColor;
/*     */     //   157	1328	5	c2	Ljava/awt/Color;
/*     */     //   112	1373	4	c	Ljava/awt/Color;
/*     */     //   0	1486	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;
/*     */     //   0	1486	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	1486	2	width	F
/*     */     //   0	1486	3	height	F
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
/*     */   private final void astro(IEntityLivingBase target, float width, float height) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 614
/*     */     //   4: aload_0
/*     */     //   5: getfield easingHealth : F
/*     */     //   8: iconst_0
/*     */     //   9: i2f
/*     */     //   10: fcmpg
/*     */     //   11: iflt -> 57
/*     */     //   14: aload_0
/*     */     //   15: getfield easingHealth : F
/*     */     //   18: aload_1
/*     */     //   19: invokeinterface getMaxHealth : ()F
/*     */     //   24: fcmpl
/*     */     //   25: ifgt -> 57
/*     */     //   28: aload_0
/*     */     //   29: getfield easingHealth : F
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface getHealth : ()F
/*     */     //   38: fsub
/*     */     //   39: fstore #4
/*     */     //   41: iconst_0
/*     */     //   42: istore #5
/*     */     //   44: fload #4
/*     */     //   46: invokestatic abs : (F)F
/*     */     //   49: f2d
/*     */     //   50: ldc2_w 0.01
/*     */     //   53: dcmpg
/*     */     //   54: ifge -> 67
/*     */     //   57: aload_0
/*     */     //   58: aload_1
/*     */     //   59: invokeinterface getHealth : ()F
/*     */     //   64: putfield easingHealth : F
/*     */     //   67: new java/awt/Color
/*     */     //   70: dup
/*     */     //   71: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   74: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   77: checkcast java/lang/Number
/*     */     //   80: invokevirtual intValue : ()I
/*     */     //   83: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   86: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   89: checkcast java/lang/Number
/*     */     //   92: invokevirtual intValue : ()I
/*     */     //   95: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   98: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   101: checkcast java/lang/Number
/*     */     //   104: invokevirtual intValue : ()I
/*     */     //   107: invokespecial <init> : (III)V
/*     */     //   110: astore #4
/*     */     //   112: new java/awt/Color
/*     */     //   115: dup
/*     */     //   116: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   119: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   122: checkcast java/lang/Number
/*     */     //   125: invokevirtual intValue : ()I
/*     */     //   128: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   131: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   134: checkcast java/lang/Number
/*     */     //   137: invokevirtual intValue : ()I
/*     */     //   140: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   146: checkcast java/lang/Number
/*     */     //   149: invokevirtual intValue : ()I
/*     */     //   152: invokespecial <init> : (III)V
/*     */     //   155: astore #5
/*     */     //   157: dconst_0
/*     */     //   158: dconst_0
/*     */     //   159: fload_2
/*     */     //   160: f2d
/*     */     //   161: fload_3
/*     */     //   162: f2d
/*     */     //   163: new java/awt/Color
/*     */     //   166: dup
/*     */     //   167: iconst_0
/*     */     //   168: iconst_0
/*     */     //   169: iconst_0
/*     */     //   170: bipush #120
/*     */     //   172: invokespecial <init> : (IIII)V
/*     */     //   175: invokevirtual getRGB : ()I
/*     */     //   178: invokestatic rectangle : (DDDDI)V
/*     */     //   181: aload_0
/*     */     //   182: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   185: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   188: checkcast java/lang/Boolean
/*     */     //   191: invokevirtual booleanValue : ()Z
/*     */     //   194: ifeq -> 211
/*     */     //   197: fconst_0
/*     */     //   198: fconst_0
/*     */     //   199: fload_2
/*     */     //   200: f2d
/*     */     //   201: d2f
/*     */     //   202: fload_3
/*     */     //   203: f2d
/*     */     //   204: d2f
/*     */     //   205: ldc_w 255.0
/*     */     //   208: invokestatic drawShadowWithCustomAlpha : (FFFFF)V
/*     */     //   211: aload_0
/*     */     //   212: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   215: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   218: checkcast java/lang/Boolean
/*     */     //   221: invokevirtual booleanValue : ()Z
/*     */     //   224: ifeq -> 278
/*     */     //   227: aload_0
/*     */     //   228: invokevirtual getRenderX : ()D
/*     */     //   231: dneg
/*     */     //   232: aload_0
/*     */     //   233: invokevirtual getRenderY : ()D
/*     */     //   236: dneg
/*     */     //   237: dconst_0
/*     */     //   238: invokestatic glTranslated : (DDD)V
/*     */     //   241: aload_0
/*     */     //   242: invokevirtual getRenderX : ()D
/*     */     //   245: fconst_0
/*     */     //   246: f2d
/*     */     //   247: dadd
/*     */     //   248: d2f
/*     */     //   249: aload_0
/*     */     //   250: invokevirtual getRenderY : ()D
/*     */     //   253: fconst_0
/*     */     //   254: f2d
/*     */     //   255: dadd
/*     */     //   256: d2f
/*     */     //   257: fload_2
/*     */     //   258: f2d
/*     */     //   259: d2f
/*     */     //   260: fload_3
/*     */     //   261: f2d
/*     */     //   262: d2f
/*     */     //   263: invokestatic blurArea : (FFFF)V
/*     */     //   266: aload_0
/*     */     //   267: invokevirtual getRenderX : ()D
/*     */     //   270: aload_0
/*     */     //   271: invokevirtual getRenderY : ()D
/*     */     //   274: dconst_0
/*     */     //   275: invokestatic glTranslated : (DDD)V
/*     */     //   278: ldc2_w 2.0
/*     */     //   281: fload_3
/*     */     //   282: f2d
/*     */     //   283: ldc2_w 6.0
/*     */     //   286: dsub
/*     */     //   287: ldc2_w 2.0
/*     */     //   290: fload_2
/*     */     //   291: iconst_4
/*     */     //   292: i2f
/*     */     //   293: fsub
/*     */     //   294: f2d
/*     */     //   295: dadd
/*     */     //   296: fload_3
/*     */     //   297: f2d
/*     */     //   298: ldc2_w 2.0
/*     */     //   301: dsub
/*     */     //   302: new java/awt/Color
/*     */     //   305: dup
/*     */     //   306: bipush #25
/*     */     //   308: bipush #25
/*     */     //   310: bipush #25
/*     */     //   312: bipush #70
/*     */     //   314: invokespecial <init> : (IIII)V
/*     */     //   317: invokevirtual getRGB : ()I
/*     */     //   320: invokestatic rectangle : (DDDDI)V
/*     */     //   323: ldc2_w 2.0
/*     */     //   326: fload_3
/*     */     //   327: f2d
/*     */     //   328: ldc2_w 6.0
/*     */     //   331: dsub
/*     */     //   332: ldc2_w 10.0
/*     */     //   335: aload_0
/*     */     //   336: getfield easingHealth : F
/*     */     //   339: aload_1
/*     */     //   340: invokeinterface getMaxHealth : ()F
/*     */     //   345: fdiv
/*     */     //   346: fload_2
/*     */     //   347: iconst_4
/*     */     //   348: i2f
/*     */     //   349: fsub
/*     */     //   350: fmul
/*     */     //   351: f2d
/*     */     //   352: dadd
/*     */     //   353: fload_3
/*     */     //   354: f2d
/*     */     //   355: ldc2_w 2.0
/*     */     //   358: dsub
/*     */     //   359: aload #5
/*     */     //   361: invokevirtual getRGB : ()I
/*     */     //   364: aload #4
/*     */     //   366: invokevirtual getRGB : ()I
/*     */     //   369: invokestatic drawGradientSideways : (DDDDII)V
/*     */     //   372: aload_0
/*     */     //   373: dup
/*     */     //   374: getfield easingHealth : F
/*     */     //   377: aload_1
/*     */     //   378: invokeinterface getHealth : ()F
/*     */     //   383: aload_0
/*     */     //   384: getfield easingHealth : F
/*     */     //   387: fsub
/*     */     //   388: fconst_2
/*     */     //   389: fstore #6
/*     */     //   391: ldc 10.0
/*     */     //   393: aload_0
/*     */     //   394: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   397: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   400: checkcast java/lang/Number
/*     */     //   403: invokevirtual floatValue : ()F
/*     */     //   406: fsub
/*     */     //   407: fstore #7
/*     */     //   409: fstore #13
/*     */     //   411: fstore #12
/*     */     //   413: astore #11
/*     */     //   415: iconst_0
/*     */     //   416: istore #8
/*     */     //   418: fload #6
/*     */     //   420: f2d
/*     */     //   421: fload #7
/*     */     //   423: f2d
/*     */     //   424: invokestatic pow : (DD)D
/*     */     //   427: d2f
/*     */     //   428: fstore #14
/*     */     //   430: aload #11
/*     */     //   432: fload #12
/*     */     //   434: fload #13
/*     */     //   436: fload #14
/*     */     //   438: fdiv
/*     */     //   439: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   442: i2f
/*     */     //   443: fmul
/*     */     //   444: fadd
/*     */     //   445: putfield easingHealth : F
/*     */     //   448: aload_1
/*     */     //   449: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   454: dup
/*     */     //   455: ifnull -> 494
/*     */     //   458: astore #6
/*     */     //   460: iconst_0
/*     */     //   461: istore #7
/*     */     //   463: iconst_0
/*     */     //   464: istore #8
/*     */     //   466: aload #6
/*     */     //   468: astore #9
/*     */     //   470: iconst_0
/*     */     //   471: istore #10
/*     */     //   473: aload_0
/*     */     //   474: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   477: aload #9
/*     */     //   479: bipush #34
/*     */     //   481: iconst_5
/*     */     //   482: ldc_w 16777215
/*     */     //   485: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   490: pop
/*     */     //   491: goto -> 495
/*     */     //   494: pop
/*     */     //   495: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   498: aload_1
/*     */     //   499: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   504: ifeq -> 555
/*     */     //   507: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   510: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   515: aload_1
/*     */     //   516: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   521: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   526: astore #6
/*     */     //   528: aload #6
/*     */     //   530: ifnull -> 614
/*     */     //   533: aload #6
/*     */     //   535: invokeinterface getLocationSkin : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   540: astore #7
/*     */     //   542: aload_0
/*     */     //   543: aload #7
/*     */     //   545: bipush #30
/*     */     //   547: bipush #30
/*     */     //   549: invokespecial drawHead : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;II)V
/*     */     //   552: goto -> 614
/*     */     //   555: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   558: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   563: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   566: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   571: dup
/*     */     //   572: ifnonnull -> 578
/*     */     //   575: invokestatic throwNpe : ()V
/*     */     //   578: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   583: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   588: astore #6
/*     */     //   590: aload #6
/*     */     //   592: ifnull -> 614
/*     */     //   595: aload #6
/*     */     //   597: invokeinterface getLocationSkin : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   602: astore #7
/*     */     //   604: aload_0
/*     */     //   605: aload #7
/*     */     //   607: bipush #30
/*     */     //   609: bipush #30
/*     */     //   611: invokespecial drawHead : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;II)V
/*     */     //   614: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #510	-> 0
/*     */     //   #511	-> 4
/*     */     //   #512	-> 4
/*     */     //   #513	-> 57
/*     */     //   #516	-> 67
/*     */     //   #517	-> 112
/*     */     //   #523	-> 157
/*     */     //   #524	-> 181
/*     */     //   #525	-> 197
/*     */     //   #526	-> 197
/*     */     //   #527	-> 198
/*     */     //   #528	-> 199
/*     */     //   #529	-> 202
/*     */     //   #530	-> 205
/*     */     //   #525	-> 208
/*     */     //   #534	-> 211
/*     */     //   #535	-> 227
/*     */     //   #537	-> 241
/*     */     //   #538	-> 249
/*     */     //   #537	-> 263
/*     */     //   #540	-> 266
/*     */     //   #542	-> 278
/*     */     //   #543	-> 296
/*     */     //   #542	-> 320
/*     */     //   #545	-> 323
/*     */     //   #546	-> 353
/*     */     //   #545	-> 369
/*     */     //   #554	-> 372
/*     */     //   #554	-> 438
/*     */     //   #556	-> 448
/*     */     //   #556	-> 473
/*     */     //   #556	-> 491
/*     */     //   #562	-> 495
/*     */     //   #563	-> 507
/*     */     //   #564	-> 528
/*     */     //   #567	-> 533
/*     */     //   #568	-> 542
/*     */     //   #572	-> 555
/*     */     //   #573	-> 590
/*     */     //   #576	-> 595
/*     */     //   #577	-> 604
/*     */     //   #579	-> 614
/*     */     //   #581	-> 614
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   470	20	9	it	Ljava/lang/String;
/*     */     //   473	17	10	$i$a$-let-TargetHud$astro$1	I
/*     */     //   542	10	7	locationSkin	Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   528	24	6	playerInfo	Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   604	10	7	locationSkin	Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   590	24	6	playerInfo	Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   157	457	5	c2	Ljava/awt/Color;
/*     */     //   112	502	4	c	Ljava/awt/Color;
/*     */     //   0	615	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;
/*     */     //   0	615	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	615	2	width	F
/*     */     //   0	615	3	height	F
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
/*     */   private final void wtf(IEntityLivingBase target, float width, float height) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 641
/*     */     //   4: aload_0
/*     */     //   5: getfield easingHealth : F
/*     */     //   8: iconst_0
/*     */     //   9: i2f
/*     */     //   10: fcmpg
/*     */     //   11: iflt -> 57
/*     */     //   14: aload_0
/*     */     //   15: getfield easingHealth : F
/*     */     //   18: aload_1
/*     */     //   19: invokeinterface getMaxHealth : ()F
/*     */     //   24: fcmpl
/*     */     //   25: ifgt -> 57
/*     */     //   28: aload_0
/*     */     //   29: getfield easingHealth : F
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface getHealth : ()F
/*     */     //   38: fsub
/*     */     //   39: fstore #4
/*     */     //   41: iconst_0
/*     */     //   42: istore #5
/*     */     //   44: fload #4
/*     */     //   46: invokestatic abs : (F)F
/*     */     //   49: f2d
/*     */     //   50: ldc2_w 0.01
/*     */     //   53: dcmpg
/*     */     //   54: ifge -> 67
/*     */     //   57: aload_0
/*     */     //   58: aload_1
/*     */     //   59: invokeinterface getHealth : ()F
/*     */     //   64: putfield easingHealth : F
/*     */     //   67: new java/awt/Color
/*     */     //   70: dup
/*     */     //   71: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   74: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   77: checkcast java/lang/Number
/*     */     //   80: invokevirtual intValue : ()I
/*     */     //   83: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   86: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   89: checkcast java/lang/Number
/*     */     //   92: invokevirtual intValue : ()I
/*     */     //   95: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   98: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   101: checkcast java/lang/Number
/*     */     //   104: invokevirtual intValue : ()I
/*     */     //   107: invokespecial <init> : (III)V
/*     */     //   110: astore #4
/*     */     //   112: new java/awt/Color
/*     */     //   115: dup
/*     */     //   116: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   119: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   122: checkcast java/lang/Number
/*     */     //   125: invokevirtual intValue : ()I
/*     */     //   128: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   131: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   134: checkcast java/lang/Number
/*     */     //   137: invokevirtual intValue : ()I
/*     */     //   140: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   146: checkcast java/lang/Number
/*     */     //   149: invokevirtual intValue : ()I
/*     */     //   152: invokespecial <init> : (III)V
/*     */     //   155: astore #5
/*     */     //   157: aload_0
/*     */     //   158: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   161: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   164: checkcast java/lang/Boolean
/*     */     //   167: invokevirtual booleanValue : ()Z
/*     */     //   170: ifeq -> 187
/*     */     //   173: fconst_0
/*     */     //   174: fconst_0
/*     */     //   175: fload_2
/*     */     //   176: f2d
/*     */     //   177: d2f
/*     */     //   178: fload_3
/*     */     //   179: f2d
/*     */     //   180: d2f
/*     */     //   181: ldc_w 255.0
/*     */     //   184: invokestatic drawShadowWithCustomAlpha : (FFFFF)V
/*     */     //   187: dconst_0
/*     */     //   188: dconst_0
/*     */     //   189: fload_2
/*     */     //   190: f2d
/*     */     //   191: fload_3
/*     */     //   192: f2d
/*     */     //   193: dconst_1
/*     */     //   194: new java/awt/Color
/*     */     //   197: dup
/*     */     //   198: bipush #95
/*     */     //   200: bipush #95
/*     */     //   202: bipush #95
/*     */     //   204: sipush #255
/*     */     //   207: invokespecial <init> : (IIII)V
/*     */     //   210: invokevirtual getRGB : ()I
/*     */     //   213: new java/awt/Color
/*     */     //   216: dup
/*     */     //   217: iconst_0
/*     */     //   218: iconst_0
/*     */     //   219: iconst_0
/*     */     //   220: sipush #255
/*     */     //   223: invokespecial <init> : (IIII)V
/*     */     //   226: invokevirtual getRGB : ()I
/*     */     //   229: invokestatic rectangleBordered : (DDDDDII)V
/*     */     //   232: ldc2_w 1.5
/*     */     //   235: ldc2_w 1.5
/*     */     //   238: fload_2
/*     */     //   239: f2d
/*     */     //   240: ldc2_w 1.5
/*     */     //   243: dsub
/*     */     //   244: fload_3
/*     */     //   245: f2d
/*     */     //   246: ldc2_w 1.5
/*     */     //   249: dsub
/*     */     //   250: dconst_1
/*     */     //   251: new java/awt/Color
/*     */     //   254: dup
/*     */     //   255: bipush #45
/*     */     //   257: bipush #45
/*     */     //   259: bipush #45
/*     */     //   261: sipush #255
/*     */     //   264: invokespecial <init> : (IIII)V
/*     */     //   267: invokevirtual getRGB : ()I
/*     */     //   270: new java/awt/Color
/*     */     //   273: dup
/*     */     //   274: bipush #65
/*     */     //   276: bipush #65
/*     */     //   278: bipush #65
/*     */     //   280: sipush #255
/*     */     //   283: invokespecial <init> : (IIII)V
/*     */     //   286: invokevirtual getRGB : ()I
/*     */     //   289: invokestatic rectangleBordered : (DDDDDII)V
/*     */     //   292: ldc2_w 6.0
/*     */     //   295: dstore #6
/*     */     //   297: fload_2
/*     */     //   298: f2d
/*     */     //   299: dload #6
/*     */     //   301: ldc2_w 2.0
/*     */     //   304: dmul
/*     */     //   305: dsub
/*     */     //   306: dstore #8
/*     */     //   308: dload #6
/*     */     //   310: ldc2_w 0.5
/*     */     //   313: dsub
/*     */     //   314: ldc2_w 15.5
/*     */     //   317: dload #6
/*     */     //   319: dload #8
/*     */     //   321: dadd
/*     */     //   322: ldc2_w 0.5
/*     */     //   325: dadd
/*     */     //   326: ldc2_w 26.5
/*     */     //   329: new java/awt/Color
/*     */     //   332: dup
/*     */     //   333: bipush #25
/*     */     //   335: bipush #25
/*     */     //   337: bipush #25
/*     */     //   339: sipush #255
/*     */     //   342: invokespecial <init> : (IIII)V
/*     */     //   345: invokevirtual getRGB : ()I
/*     */     //   348: invokestatic rectangle : (DDDDI)V
/*     */     //   351: dload #6
/*     */     //   353: ldc2_w 16.0
/*     */     //   356: dload #6
/*     */     //   358: aload_0
/*     */     //   359: getfield easingHealth : F
/*     */     //   362: aload_1
/*     */     //   363: invokeinterface getMaxHealth : ()F
/*     */     //   368: fdiv
/*     */     //   369: f2d
/*     */     //   370: dload #8
/*     */     //   372: dmul
/*     */     //   373: dadd
/*     */     //   374: ldc2_w 26.0
/*     */     //   377: aload #5
/*     */     //   379: invokevirtual getRGB : ()I
/*     */     //   382: aload #4
/*     */     //   384: invokevirtual getRGB : ()I
/*     */     //   387: invokestatic drawGradientSideways : (DDDDII)V
/*     */     //   390: getstatic net/ccbluex/liquidbounce/ui/font/Fonts.font35 : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   393: new java/lang/StringBuilder
/*     */     //   396: dup
/*     */     //   397: invokespecial <init> : ()V
/*     */     //   400: aload_1
/*     */     //   401: invokeinterface getHealth : ()F
/*     */     //   406: bipush #10
/*     */     //   408: i2f
/*     */     //   409: fmul
/*     */     //   410: f2i
/*     */     //   411: i2f
/*     */     //   412: ldc 10.0
/*     */     //   414: fdiv
/*     */     //   415: invokestatic valueOf : (F)Ljava/lang/String;
/*     */     //   418: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   421: ldc_w ' HP'
/*     */     //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   427: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   430: fload_2
/*     */     //   431: fconst_2
/*     */     //   432: fdiv
/*     */     //   433: ldc_w 19.0
/*     */     //   436: iconst_m1
/*     */     //   437: iconst_1
/*     */     //   438: invokeinterface drawCenteredString : (Ljava/lang/String;FFIZ)I
/*     */     //   443: pop
/*     */     //   444: aload_0
/*     */     //   445: dup
/*     */     //   446: getfield easingHealth : F
/*     */     //   449: aload_1
/*     */     //   450: invokeinterface getHealth : ()F
/*     */     //   455: aload_0
/*     */     //   456: getfield easingHealth : F
/*     */     //   459: fsub
/*     */     //   460: fconst_2
/*     */     //   461: fstore #10
/*     */     //   463: ldc 10.0
/*     */     //   465: aload_0
/*     */     //   466: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   469: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   472: checkcast java/lang/Number
/*     */     //   475: invokevirtual floatValue : ()F
/*     */     //   478: fsub
/*     */     //   479: fstore #11
/*     */     //   481: fstore #17
/*     */     //   483: fstore #16
/*     */     //   485: astore #15
/*     */     //   487: iconst_0
/*     */     //   488: istore #12
/*     */     //   490: fload #10
/*     */     //   492: f2d
/*     */     //   493: fload #11
/*     */     //   495: f2d
/*     */     //   496: invokestatic pow : (DD)D
/*     */     //   499: d2f
/*     */     //   500: fstore #18
/*     */     //   502: aload #15
/*     */     //   504: fload #16
/*     */     //   506: fload #17
/*     */     //   508: fload #18
/*     */     //   510: fdiv
/*     */     //   511: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   514: i2f
/*     */     //   515: fmul
/*     */     //   516: fadd
/*     */     //   517: putfield easingHealth : F
/*     */     //   520: aload_1
/*     */     //   521: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   526: dup
/*     */     //   527: ifnull -> 570
/*     */     //   530: astore #10
/*     */     //   532: iconst_0
/*     */     //   533: istore #11
/*     */     //   535: iconst_0
/*     */     //   536: istore #12
/*     */     //   538: aload #10
/*     */     //   540: astore #13
/*     */     //   542: iconst_0
/*     */     //   543: istore #14
/*     */     //   545: aload_0
/*     */     //   546: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   549: aload #13
/*     */     //   551: dload #6
/*     */     //   553: d2i
/*     */     //   554: iconst_2
/*     */     //   555: iadd
/*     */     //   556: bipush #6
/*     */     //   558: ldc_w 16777215
/*     */     //   561: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   566: pop
/*     */     //   567: goto -> 571
/*     */     //   570: pop
/*     */     //   571: aload_0
/*     */     //   572: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   575: new java/lang/StringBuilder
/*     */     //   578: dup
/*     */     //   579: invokespecial <init> : ()V
/*     */     //   582: ldc_w 'Distance: '
/*     */     //   585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   588: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   591: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   596: dup
/*     */     //   597: ifnonnull -> 603
/*     */     //   600: invokestatic throwNpe : ()V
/*     */     //   603: aload_1
/*     */     //   604: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   607: invokeinterface getDistanceToEntity : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)F
/*     */     //   612: f2i
/*     */     //   613: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   616: ldc_w 'm'
/*     */     //   619: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   622: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   625: dload #6
/*     */     //   627: d2i
/*     */     //   628: iconst_2
/*     */     //   629: iadd
/*     */     //   630: bipush #30
/*     */     //   632: ldc_w 16777215
/*     */     //   635: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   640: pop
/*     */     //   641: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #584	-> 0
/*     */     //   #585	-> 4
/*     */     //   #586	-> 4
/*     */     //   #587	-> 57
/*     */     //   #590	-> 67
/*     */     //   #591	-> 112
/*     */     //   #596	-> 157
/*     */     //   #597	-> 173
/*     */     //   #599	-> 187
/*     */     //   #600	-> 232
/*     */     //   #603	-> 292
/*     */     //   #604	-> 297
/*     */     //   #605	-> 308
/*     */     //   #606	-> 326
/*     */     //   #605	-> 348
/*     */     //   #608	-> 351
/*     */     //   #609	-> 374
/*     */     //   #608	-> 387
/*     */     //   #611	-> 390
/*     */     //   #617	-> 444
/*     */     //   #617	-> 510
/*     */     //   #619	-> 520
/*     */     //   #619	-> 545
/*     */     //   #619	-> 567
/*     */     //   #621	-> 571
/*     */     //   #624	-> 641
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   542	24	13	it	Ljava/lang/String;
/*     */     //   545	21	14	$i$a$-let-TargetHud$wtf$1	I
/*     */     //   308	333	8	barWidth	D
/*     */     //   297	344	6	startPos	D
/*     */     //   157	484	5	c2	Ljava/awt/Color;
/*     */     //   112	529	4	c	Ljava/awt/Color;
/*     */     //   0	642	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;
/*     */     //   0	642	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	642	2	width	F
/*     */     //   0	642	3	height	F
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
/*     */   private final void nameless(IEntityLivingBase target, float width, float height) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnull -> 819
/*     */     //   4: aload_0
/*     */     //   5: getfield easingHealth : F
/*     */     //   8: iconst_0
/*     */     //   9: i2f
/*     */     //   10: fcmpg
/*     */     //   11: iflt -> 57
/*     */     //   14: aload_0
/*     */     //   15: getfield easingHealth : F
/*     */     //   18: aload_1
/*     */     //   19: invokeinterface getMaxHealth : ()F
/*     */     //   24: fcmpl
/*     */     //   25: ifgt -> 57
/*     */     //   28: aload_0
/*     */     //   29: getfield easingHealth : F
/*     */     //   32: aload_1
/*     */     //   33: invokeinterface getHealth : ()F
/*     */     //   38: fsub
/*     */     //   39: fstore #4
/*     */     //   41: iconst_0
/*     */     //   42: istore #5
/*     */     //   44: fload #4
/*     */     //   46: invokestatic abs : (F)F
/*     */     //   49: f2d
/*     */     //   50: ldc2_w 0.01
/*     */     //   53: dcmpg
/*     */     //   54: ifge -> 67
/*     */     //   57: aload_0
/*     */     //   58: aload_1
/*     */     //   59: invokeinterface getHealth : ()F
/*     */     //   64: putfield easingHealth : F
/*     */     //   67: fconst_0
/*     */     //   68: fconst_0
/*     */     //   69: fload_2
/*     */     //   70: fload_3
/*     */     //   71: ldc_w 2.4
/*     */     //   74: f2i
/*     */     //   75: i2f
/*     */     //   76: new java/awt/Color
/*     */     //   79: dup
/*     */     //   80: iconst_0
/*     */     //   81: iconst_0
/*     */     //   82: iconst_0
/*     */     //   83: bipush #100
/*     */     //   85: invokespecial <init> : (IIII)V
/*     */     //   88: invokevirtual getRGB : ()I
/*     */     //   91: invokestatic drawRoundedRect : (FFFFFI)V
/*     */     //   94: aload_0
/*     */     //   95: getfield shadow : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   98: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   101: checkcast java/lang/Boolean
/*     */     //   104: invokevirtual booleanValue : ()Z
/*     */     //   107: ifeq -> 124
/*     */     //   110: fconst_0
/*     */     //   111: fconst_0
/*     */     //   112: fload_2
/*     */     //   113: f2d
/*     */     //   114: d2f
/*     */     //   115: fload_3
/*     */     //   116: f2d
/*     */     //   117: d2f
/*     */     //   118: ldc_w 255.0
/*     */     //   121: invokestatic drawShadowWithCustomAlpha : (FFFFF)V
/*     */     //   124: aload_0
/*     */     //   125: getfield blur : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   128: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   131: checkcast java/lang/Boolean
/*     */     //   134: invokevirtual booleanValue : ()Z
/*     */     //   137: ifeq -> 191
/*     */     //   140: aload_0
/*     */     //   141: invokevirtual getRenderX : ()D
/*     */     //   144: dneg
/*     */     //   145: aload_0
/*     */     //   146: invokevirtual getRenderY : ()D
/*     */     //   149: dneg
/*     */     //   150: dconst_0
/*     */     //   151: invokestatic glTranslated : (DDD)V
/*     */     //   154: aload_0
/*     */     //   155: invokevirtual getRenderX : ()D
/*     */     //   158: fconst_0
/*     */     //   159: f2d
/*     */     //   160: dadd
/*     */     //   161: d2f
/*     */     //   162: aload_0
/*     */     //   163: invokevirtual getRenderY : ()D
/*     */     //   166: fconst_0
/*     */     //   167: f2d
/*     */     //   168: dadd
/*     */     //   169: d2f
/*     */     //   170: fload_2
/*     */     //   171: f2d
/*     */     //   172: d2f
/*     */     //   173: fload_3
/*     */     //   174: f2d
/*     */     //   175: d2f
/*     */     //   176: invokestatic blurArea : (FFFF)V
/*     */     //   179: aload_0
/*     */     //   180: invokevirtual getRenderX : ()D
/*     */     //   183: aload_0
/*     */     //   184: invokevirtual getRenderY : ()D
/*     */     //   187: dconst_0
/*     */     //   188: invokestatic glTranslated : (DDD)V
/*     */     //   191: new java/awt/Color
/*     */     //   194: dup
/*     */     //   195: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   198: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   201: checkcast java/lang/Number
/*     */     //   204: invokevirtual intValue : ()I
/*     */     //   207: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   210: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   213: checkcast java/lang/Number
/*     */     //   216: invokevirtual intValue : ()I
/*     */     //   219: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   222: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   225: checkcast java/lang/Number
/*     */     //   228: invokevirtual intValue : ()I
/*     */     //   231: invokespecial <init> : (III)V
/*     */     //   234: astore #4
/*     */     //   236: new java/awt/Color
/*     */     //   239: dup
/*     */     //   240: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.r2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   243: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   246: checkcast java/lang/Number
/*     */     //   249: invokevirtual intValue : ()I
/*     */     //   252: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.g2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   255: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   258: checkcast java/lang/Number
/*     */     //   261: invokevirtual intValue : ()I
/*     */     //   264: getstatic net/ccbluex/liquidbounce/features/module/modules/color/CustomColor.b2 : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   267: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   270: checkcast java/lang/Number
/*     */     //   273: invokevirtual intValue : ()I
/*     */     //   276: invokespecial <init> : (III)V
/*     */     //   279: astore #5
/*     */     //   281: ldc2_w 2.0
/*     */     //   284: dstore #6
/*     */     //   286: fload_2
/*     */     //   287: f2d
/*     */     //   288: dload #6
/*     */     //   290: ldc2_w 2.0
/*     */     //   293: dmul
/*     */     //   294: dsub
/*     */     //   295: dstore #8
/*     */     //   297: dload #6
/*     */     //   299: fload_3
/*     */     //   300: f2d
/*     */     //   301: ldc2_w 3.0
/*     */     //   304: dsub
/*     */     //   305: dload #6
/*     */     //   307: aload_0
/*     */     //   308: getfield easingHealth : F
/*     */     //   311: aload_1
/*     */     //   312: invokeinterface getMaxHealth : ()F
/*     */     //   317: fdiv
/*     */     //   318: f2d
/*     */     //   319: dload #8
/*     */     //   321: dmul
/*     */     //   322: dadd
/*     */     //   323: fload_3
/*     */     //   324: f2d
/*     */     //   325: ldc2_w 2.0
/*     */     //   328: dsub
/*     */     //   329: aload #5
/*     */     //   331: invokevirtual getRGB : ()I
/*     */     //   334: aload #4
/*     */     //   336: invokevirtual getRGB : ()I
/*     */     //   339: invokestatic drawGradientSideways : (DDDDII)V
/*     */     //   342: aload_0
/*     */     //   343: dup
/*     */     //   344: getfield easingHealth : F
/*     */     //   347: aload_1
/*     */     //   348: invokeinterface getHealth : ()F
/*     */     //   353: aload_0
/*     */     //   354: getfield easingHealth : F
/*     */     //   357: fsub
/*     */     //   358: fconst_2
/*     */     //   359: fstore #10
/*     */     //   361: ldc 10.0
/*     */     //   363: aload_0
/*     */     //   364: getfield fadeSpeed : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   367: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   370: checkcast java/lang/Number
/*     */     //   373: invokevirtual floatValue : ()F
/*     */     //   376: fsub
/*     */     //   377: fstore #11
/*     */     //   379: fstore #18
/*     */     //   381: fstore #17
/*     */     //   383: astore #16
/*     */     //   385: iconst_0
/*     */     //   386: istore #12
/*     */     //   388: fload #10
/*     */     //   390: f2d
/*     */     //   391: fload #11
/*     */     //   393: f2d
/*     */     //   394: invokestatic pow : (DD)D
/*     */     //   397: d2f
/*     */     //   398: fstore #19
/*     */     //   400: aload #16
/*     */     //   402: fload #17
/*     */     //   404: fload #18
/*     */     //   406: fload #19
/*     */     //   408: fdiv
/*     */     //   409: getstatic net/ccbluex/liquidbounce/utils/render/RenderUtils.deltaTime : I
/*     */     //   412: i2f
/*     */     //   413: fmul
/*     */     //   414: fadd
/*     */     //   415: putfield easingHealth : F
/*     */     //   418: aload_1
/*     */     //   419: invokeinterface getName : ()Ljava/lang/String;
/*     */     //   424: dup
/*     */     //   425: ifnull -> 465
/*     */     //   428: astore #10
/*     */     //   430: iconst_0
/*     */     //   431: istore #11
/*     */     //   433: iconst_0
/*     */     //   434: istore #12
/*     */     //   436: aload #10
/*     */     //   438: astore #13
/*     */     //   440: iconst_0
/*     */     //   441: istore #14
/*     */     //   443: aload_0
/*     */     //   444: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   447: aload #13
/*     */     //   449: bipush #34
/*     */     //   451: bipush #7
/*     */     //   453: ldc_w 16777215
/*     */     //   456: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   461: pop
/*     */     //   462: goto -> 466
/*     */     //   465: pop
/*     */     //   466: aload_0
/*     */     //   467: getfield fontRenderer : Lnet/ccbluex/liquidbounce/api/minecraft/client/gui/IFontRenderer;
/*     */     //   470: new java/lang/StringBuilder
/*     */     //   473: dup
/*     */     //   474: invokespecial <init> : ()V
/*     */     //   477: ldc_w 'Distance: '
/*     */     //   480: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   483: aload_0
/*     */     //   484: getfield decimalFormat : Ljava/text/DecimalFormat;
/*     */     //   487: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   490: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   495: dup
/*     */     //   496: ifnonnull -> 502
/*     */     //   499: invokestatic throwNpe : ()V
/*     */     //   502: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   505: aload_1
/*     */     //   506: checkcast net/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity
/*     */     //   509: invokestatic getDistanceToEntityBox : (Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;)D
/*     */     //   512: invokevirtual format : (D)Ljava/lang/String;
/*     */     //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   518: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   521: bipush #34
/*     */     //   523: bipush #19
/*     */     //   525: ldc_w 16777215
/*     */     //   528: invokeinterface drawStringWithShadow : (Ljava/lang/String;III)I
/*     */     //   533: pop
/*     */     //   534: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   537: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   542: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   545: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   550: dup
/*     */     //   551: ifnonnull -> 557
/*     */     //   554: invokestatic throwNpe : ()V
/*     */     //   557: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   562: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   567: astore #10
/*     */     //   569: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   572: aload_1
/*     */     //   573: invokeinterface isEntityPlayer : (Ljava/lang/Object;)Z
/*     */     //   578: ifeq -> 602
/*     */     //   581: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   584: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   589: aload_1
/*     */     //   590: invokeinterface getUniqueID : ()Ljava/util/UUID;
/*     */     //   595: invokeinterface getPlayerInfo : (Ljava/util/UUID;)Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   600: astore #10
/*     */     //   602: aload #10
/*     */     //   604: ifnull -> 819
/*     */     //   607: aload #10
/*     */     //   609: invokeinterface getLocationSkin : ()Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   614: astore #11
/*     */     //   616: aload_1
/*     */     //   617: invokeinterface getHurtTime : ()I
/*     */     //   622: i2f
/*     */     //   623: aload_1
/*     */     //   624: invokeinterface getHurtTime : ()I
/*     */     //   629: ifeq -> 644
/*     */     //   632: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
/*     */     //   635: getfield field_71428_T : Lnet/minecraft/util/Timer;
/*     */     //   638: getfield field_194147_b : F
/*     */     //   641: goto -> 645
/*     */     //   644: fconst_0
/*     */     //   645: fsub
/*     */     //   646: fstore #12
/*     */     //   648: fload #12
/*     */     //   650: ldc 10.0
/*     */     //   652: fdiv
/*     */     //   653: fstore #13
/*     */     //   655: fconst_1
/*     */     //   656: iconst_1
/*     */     //   657: i2f
/*     */     //   658: fload #13
/*     */     //   660: fsub
/*     */     //   661: iconst_1
/*     */     //   662: i2f
/*     */     //   663: fload #13
/*     */     //   665: fsub
/*     */     //   666: fconst_1
/*     */     //   667: invokestatic glColor4f : (FFFF)V
/*     */     //   670: fload #13
/*     */     //   672: fconst_0
/*     */     //   673: fcmpg
/*     */     //   674: ifne -> 681
/*     */     //   677: fconst_1
/*     */     //   678: goto -> 722
/*     */     //   681: fload #13
/*     */     //   683: ldc_w 0.5
/*     */     //   686: fcmpg
/*     */     //   687: ifge -> 705
/*     */     //   690: iconst_1
/*     */     //   691: i2f
/*     */     //   692: ldc_w 0.2
/*     */     //   695: fload #13
/*     */     //   697: fmul
/*     */     //   698: iconst_2
/*     */     //   699: i2f
/*     */     //   700: fmul
/*     */     //   701: fsub
/*     */     //   702: goto -> 722
/*     */     //   705: ldc_w 0.8
/*     */     //   708: ldc_w 0.2
/*     */     //   711: fload #13
/*     */     //   713: ldc_w 0.5
/*     */     //   716: fsub
/*     */     //   717: fmul
/*     */     //   718: iconst_2
/*     */     //   719: i2f
/*     */     //   720: fmul
/*     */     //   721: fadd
/*     */     //   722: fstore #14
/*     */     //   724: bipush #30
/*     */     //   726: istore #15
/*     */     //   728: invokestatic glPushMatrix : ()V
/*     */     //   731: fload #14
/*     */     //   733: fload #14
/*     */     //   735: fload #14
/*     */     //   737: invokestatic glScalef : (FFF)V
/*     */     //   740: iload #15
/*     */     //   742: i2f
/*     */     //   743: ldc_w 0.5
/*     */     //   746: fmul
/*     */     //   747: iconst_1
/*     */     //   748: i2f
/*     */     //   749: fload #14
/*     */     //   751: fsub
/*     */     //   752: fmul
/*     */     //   753: fload #14
/*     */     //   755: fdiv
/*     */     //   756: iload #15
/*     */     //   758: i2f
/*     */     //   759: ldc_w 0.5
/*     */     //   762: fmul
/*     */     //   763: iconst_1
/*     */     //   764: i2f
/*     */     //   765: fload #14
/*     */     //   767: fsub
/*     */     //   768: fmul
/*     */     //   769: fload #14
/*     */     //   771: fdiv
/*     */     //   772: fconst_0
/*     */     //   773: invokestatic glTranslatef : (FFF)V
/*     */     //   776: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   779: invokeinterface getTextureManager : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/render/texture/ITextureManager;
/*     */     //   784: aload #11
/*     */     //   786: invokeinterface bindTexture : (Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;)V
/*     */     //   791: iconst_2
/*     */     //   792: iconst_2
/*     */     //   793: ldc_w 8.0
/*     */     //   796: ldc_w 8.0
/*     */     //   799: bipush #8
/*     */     //   801: bipush #8
/*     */     //   803: iload #15
/*     */     //   805: iload #15
/*     */     //   807: ldc_w 64.0
/*     */     //   810: ldc_w 64.0
/*     */     //   813: invokestatic drawScaledCustomSizeModalRect : (IIFFIIIIFF)V
/*     */     //   816: invokestatic glPopMatrix : ()V
/*     */     //   819: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #627	-> 0
/*     */     //   #628	-> 4
/*     */     //   #629	-> 4
/*     */     //   #630	-> 57
/*     */     //   #634	-> 67
/*     */     //   #636	-> 94
/*     */     //   #637	-> 110
/*     */     //   #639	-> 124
/*     */     //   #640	-> 140
/*     */     //   #642	-> 154
/*     */     //   #643	-> 162
/*     */     //   #642	-> 176
/*     */     //   #645	-> 179
/*     */     //   #647	-> 191
/*     */     //   #648	-> 236
/*     */     //   #652	-> 281
/*     */     //   #653	-> 286
/*     */     //   #660	-> 297
/*     */     //   #661	-> 323
/*     */     //   #660	-> 339
/*     */     //   #663	-> 342
/*     */     //   #663	-> 408
/*     */     //   #665	-> 418
/*     */     //   #665	-> 443
/*     */     //   #665	-> 462
/*     */     //   #667	-> 466
/*     */     //   #673	-> 534
/*     */     //   #674	-> 569
/*     */     //   #675	-> 581
/*     */     //   #677	-> 602
/*     */     //   #680	-> 607
/*     */     //   #682	-> 616
/*     */     //   #684	-> 648
/*     */     //   #685	-> 655
/*     */     //   #687	-> 670
/*     */     //   #688	-> 690
/*     */     //   #690	-> 705
/*     */     //   #687	-> 722
/*     */     //   #692	-> 724
/*     */     //   #694	-> 728
/*     */     //   #696	-> 731
/*     */     //   #697	-> 740
/*     */     //   #699	-> 776
/*     */     //   #700	-> 791
/*     */     //   #701	-> 807
/*     */     //   #700	-> 813
/*     */     //   #703	-> 816
/*     */     //   #706	-> 819
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   440	21	13	it	Ljava/lang/String;
/*     */     //   443	18	14	$i$a$-let-TargetHud$nameless$1	I
/*     */     //   728	91	15	size	I
/*     */     //   724	95	14	scale	F
/*     */     //   655	164	13	hurtPercent	F
/*     */     //   648	171	12	renderHurtTime	F
/*     */     //   616	203	11	locationSkin	Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;
/*     */     //   569	250	10	playerInfo	Lnet/ccbluex/liquidbounce/api/minecraft/client/network/INetworkPlayerInfo;
/*     */     //   297	522	8	barWidth	D
/*     */     //   286	533	6	startPos	D
/*     */     //   281	538	5	c2	Ljava/awt/Color;
/*     */     //   236	583	4	c	Ljava/awt/Color;
/*     */     //   0	820	0	this	Lnet/ccbluex/liquidbounce/ui/client/hud/element/elements/TargetHud;
/*     */     //   0	820	1	target	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityLivingBase;
/*     */     //   0	820	2	width	F
/*     */     //   0	820	3	height	F
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
/*     */   private final void drawHead(IResourceLocation skin, int width, int height) {
/* 710 */     MinecraftInstance.mc.getTextureManager().bindTexture(skin);
/* 711 */     RenderUtils.drawScaledCustomSizeModalRect(2, 2, 8.0F, 8.0F, 8, 8, width, height, 
/* 712 */         64.0F, 64.0F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\elements\TargetHud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */