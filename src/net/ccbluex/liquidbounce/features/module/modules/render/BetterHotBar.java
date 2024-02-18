/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ import java.awt.Color;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import me.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.util.IResourceLocation;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.EntityUtils2;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "BetterHotBar", category = ModuleCategory.RENDER, description = "更好的物品栏")
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\013\n\002\020\006\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\033\032\0020\034J\016\020\035\032\0020\0362\006\020\037\032\0020\006J\016\020 \032\0020\0362\006\020\037\032\0020\006J\020\020!\032\0020\0362\006\020\"\032\0020#H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\004X\004¢\006\002\n\000R\016\020\t\032\0020\006X\016¢\006\002\n\000R\016\020\n\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\006X\016¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\006X\016¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\rX\004¢\006\002\n\000R\016\020\022\032\0020\006X\016¢\006\002\n\000R\016\020\023\032\0020\006X\016¢\006\002\n\000R\016\020\024\032\0020\rX\004¢\006\002\n\000R\016\020\025\032\0020\006X\016¢\006\002\n\000R\016\020\026\032\0020\006X\016¢\006\002\n\000R\016\020\027\032\0020\006X\016¢\006\002\n\000R\016\020\030\032\0020\004X\004¢\006\002\n\000R\016\020\031\032\0020\004X\004¢\006\002\n\000R\016\020\032\032\0020\004X\004¢\006\002\n\000¨\006$"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/BetterHotBar;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "AlphaValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "Black", "Lnet/ccbluex/liquidbounce/api/minecraft/util/IResourceLocation;", "BlueValue", "GreenValue", "Lite", "RedValue", "bluecat", "colorModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "crygirl", "fontvalue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "girlvalue", "happygirl", "liuli", "modeValue", "move0", "move1", "move2", "offsetValue", "rainbowIndex", "rainbowSpeed", "calculateBPS", "", "drawgirl", "", "resource", "drawhud", "onRender", "event", "Lnet/ccbluex/liquidbounce/event/Render2DEvent;", "XSJClient"})
/*     */ public final class BetterHotBar extends Module {
/*  21 */   private final ListValue modeValue = new ListValue("bar", new String[] { "Black", "Lite", "Off" }, "Off");
/*  22 */   private final BoolValue fontvalue = new BoolValue("Info", true);
/*  23 */   private final ListValue girlvalue = new ListValue("girl", new String[] { "Crygirl", "Happygirl", "Move0", "Move1", "Move2", "Bluecat", "Liuli", "Off" }, "Off");
/*  24 */   private final ListValue colorModeValue = new ListValue("InfoColor", new String[] { "Custom", "GodLightSync", "novo", "rainbow", "skyrainbow", "anptherrainbow" }, "Custom");
/*  25 */   private final IntegerValue RedValue = new IntegerValue("R", 255, 0, 255);
/*  26 */   private final IntegerValue GreenValue = new IntegerValue("G", 255, 0, 255);
/*  27 */   private final IntegerValue BlueValue = new IntegerValue("B", 255, 0, 255);
/*  28 */   private final IntegerValue AlphaValue = new IntegerValue("A", 255, 0, 255);
/*  29 */   private final IntegerValue rainbowSpeed = new IntegerValue("RainbowSpeed", 10, 1, 10);
/*  30 */   private final IntegerValue rainbowIndex = new IntegerValue("RainbowIndex", 1, 1, 20);
/*  31 */   private final IntegerValue offsetValue = new IntegerValue("Y-Offset", 36, -50, 100);
/*     */ 
/*     */   
/*  34 */   private IResourceLocation Black = MinecraftInstance.classProvider.createResourceLocation("tomk/hud/betterhud1.png");
/*  35 */   private IResourceLocation Lite = MinecraftInstance.classProvider.createResourceLocation("tomk/hud/betterhud2.png");
/*  36 */   private IResourceLocation crygirl = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/crygirl.png");
/*  37 */   private IResourceLocation happygirl = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/happygirl.png");
/*  38 */   private IResourceLocation bluecat = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/bluecat.png");
/*  39 */   private IResourceLocation liuli = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/liuli.png");
/*  40 */   private IResourceLocation move0 = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/0.png");
/*  41 */   private IResourceLocation move1 = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/1.png");
/*  42 */   private IResourceLocation move2 = MinecraftInstance.classProvider.createResourceLocation("tomk/girls/2.png");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onRender(@NotNull Render2DEvent event) {
/*  49 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.colorModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*     */     { case 973576630:
/*  51 */         if (str.equals("rainbow"));
/*     */       case 404830547:
/*  53 */         if (str.equals("anotherrainbow"));
/*  54 */       case 1027608501: if (str.equals("godlightsync"));case 3387450: if (str.equals("novo"));case 151913845: if (str.equals("skyrainbow"))
/*  55 */           Intrinsics.checkExpressionValueIsNotNull(RenderUtils.skyRainbow(((Number)this.rainbowIndex.get()).intValue(), 1.0F, 1.0F), "me.utils.render.RenderUt…inbowIndex.get(), 1F, 1F)"); default: break; }  int TextColor = (new Color(((Number)this.RedValue.get()).intValue(), ((Number)this.GreenValue.get()).intValue(), ((Number)this.BlueValue.get()).intValue(), 1)).getRGB();
/*     */     
/*  57 */     str = (String)this.modeValue.get(); switch (str.hashCode())
/*     */     { case 2368718:
/*  59 */         if (str.equals("Lite")) drawhud(this.Lite);  break;
/*     */       case 64266207:
/*     */         if (str.equals("Black"))
/*  62 */           drawhud(this.Black);  break; }  str = (String)this.girlvalue.get(); switch (str.hashCode())
/*     */     
/*     */     { 
/*     */ 
/*     */       
/*     */       case 74534497:
/*  68 */         if (str.equals("Move2")) drawgirl(this.move2);  break;case 74534496: if (str.equals("Move1")) drawgirl(this.move1);  break;case -1583120538: if (str.equals("Crygirl"))
/*  69 */           drawgirl(this.crygirl);  break;case 73431541: if (str.equals("Liuli")) drawgirl(this.liuli);  break;case 1648808220: if (str.equals("Bluecat"))
/*     */           drawgirl(this.bluecat);  break;case 74534495: if (str.equals("Move0"))
/*     */           drawgirl(this.move0);  break;
/*     */       case -96243364: if (str.equals("Happygirl"))
/*  73 */           drawgirl(this.happygirl);  break; }  if (((Boolean)this.fontvalue.get()).booleanValue()) {
/*     */       
/*  75 */       Fonts.sfbold35.drawStringWithShadow("FPS:" + Minecraft.func_175610_ah(), 5.0F, (
/*  76 */           495 + ((Number)this.offsetValue.get()).intValue()), TextColor);
/*     */ 
/*     */       
/*  79 */       Fonts.sfbold35.drawStringWithShadow("Ping:" + EntityUtils2.INSTANCE.getPing((IEntityPlayer)MinecraftInstance.mc.getThePlayer()), 
/*  80 */           5.0F, (520 + ((Number)this.offsetValue.get()).intValue()), TextColor);
/*     */ 
/*     */       
/*  83 */       Fonts.sfbold35.drawStringWithShadow("BPS:" + calculateBPS(), 5.0F, (
/*  84 */           540 + ((Number)this.offsetValue.get()).intValue()), TextColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double calculateBPS() {
/*  92 */     if (MinecraftInstance.mc.getThePlayer() != null) {
/*     */       
/*  94 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe(); 
/*  95 */       if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  double bps = Math.hypot(MinecraftInstance.mc.getThePlayer().getPosX() - MinecraftInstance.mc.getThePlayer().getPrevPosX(), MinecraftInstance.mc.getThePlayer().getPosZ() - MinecraftInstance.mc.getThePlayer().getPrevPosZ()) * 
/*  96 */         MinecraftInstance.mc.getTimer().getTimerSpeed() * 20;
/*  97 */       return Math.round(bps * 100.0D) / 100.0D;
/*     */     } 
/*  99 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public final void drawhud(@NotNull IResourceLocation resource) {
/* 103 */     Intrinsics.checkParameterIsNotNull(resource, "resource"); RenderUtils.drawImage(resource, -8, 487 + ((Number)this.offsetValue.get()).intValue(), 1920, 45); } public final void drawgirl(@NotNull IResourceLocation resource) {
/* 104 */     Intrinsics.checkParameterIsNotNull(resource, "resource"); RenderUtils.drawImage(resource, 570, 415 + ((Number)this.offsetValue.get()).intValue(), 100, 100);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\BetterHotBar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */