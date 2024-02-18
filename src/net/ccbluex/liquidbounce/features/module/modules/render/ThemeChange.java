/*     */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "ThemeChange", description = "调色板主题切换 by 凡哥 颜色预设from Tenacity&Rise", category = ModuleCategory.RENDER)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\020\t\032\0020\n2\006\020\013\032\0020\fH\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\007\020\b¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/ThemeChange;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "Theme", "Lnet/ccbluex/liquidbounce/value/ListValue;", "acolorpalette", "Lnet/ccbluex/liquidbounce/features/module/modules/render/AColorPalette;", "getAcolorpalette", "()Lnet/ccbluex/liquidbounce/features/module/modules/render/AColorPalette;", "onUpdate", "", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class ThemeChange
/*     */   extends Module
/*     */ {
/*     */   @NotNull
/*  19 */   private final AColorPalette acolorpalette = new AColorPalette(); @NotNull public final AColorPalette getAcolorpalette() { return this.acolorpalette; }
/*  20 */    private final ListValue Theme = new ListValue("themeValue", new String[] { 
/*  21 */         "Aubergine", 
/*  22 */         "Amethyst", 
/*  23 */         "Aqua", 
/*  24 */         "Banana", 
/*  25 */         "Blaze Orange", 
/*  26 */         "Blend", 
/*  27 */         "Blossom", 
/*  28 */         "Bubblegum", 
/*  29 */         "Candy Cane", 
/*  30 */         "Chambray Blue", 
/*  31 */         "Cherry", 
/*  32 */         "Coral", 
/*  33 */         "Deep Ocean", 
/*  34 */         "Digital Horizon", 
/*  35 */         "Express", 
/*  36 */         "Green Spirit", 
/*  37 */         "Lime Water", 
/*  38 */         "Lush", 
/*  39 */         "Halogen", 
/*  40 */         "Hot Pink", 
/*  41 */         "Hyper", 
/*  42 */         "Jade Green", 
/*  43 */         "Lavender", 
/*  44 */         "Lavender Amethyst", 
/*  45 */         "Magenta", 
/*  46 */         "Magic", 
/*  47 */         "May", 
/*  48 */         "Mint Blue", 
/*  49 */         "Neon Red", 
/*  50 */         "Orange Juice", 
/*  51 */         "Pacific Blue", 
/*  52 */         "Pastel", 
/*  53 */         "Purple Fire", 
/*  54 */         "Pink Blood", 
/*  55 */         "Red Coffee", 
/*  56 */         "Rosy Pink", 
/*  57 */         "Satin", 
/*  58 */         "Spearmint", 
/*  59 */         "Steel Fade", 
/*  60 */         "Sundae", 
/*  61 */         "Sunkist", 
/*  62 */         "Sunset Pink", 
/*  63 */         "Tropical Ice", 
/*  64 */         "Water", 
/*  65 */         "Winter"
/*  66 */       }, "Aubergine");
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*  71 */     Intrinsics.checkParameterIsNotNull(event, "event"); String str = (String)this.Theme.get(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 83350775:
/* 419 */         if (str.equals("Water"))
/* 420 */         { AColorPalette.r.set(Integer.valueOf(12));
/* 421 */           AColorPalette.g.set(Integer.valueOf(232));
/* 422 */           AColorPalette.b.set(Integer.valueOf(199));
/* 423 */           AColorPalette.r2.set(Integer.valueOf(12));
/* 424 */           AColorPalette.g2.set(Integer.valueOf(163));
/* 425 */           AColorPalette.b2.set(Integer.valueOf(232)); }  break;case 2048732: if (str.equals("Aqua")) { AColorPalette.r.set(Integer.valueOf(185)); AColorPalette.g.set(Integer.valueOf(250)); AColorPalette.b.set(Integer.valueOf(255)); AColorPalette.r2.set(Integer.valueOf(79)); AColorPalette.g2.set(Integer.valueOf(199)); AColorPalette.b2.set(Integer.valueOf(200)); }  break;case 976509360: if (str.equals("Candy Cane")) { AColorPalette.r.set(Integer.valueOf(255)); AColorPalette.g.set(Integer.valueOf(0)); AColorPalette.b.set(Integer.valueOf(0)); AColorPalette.r2.set(Integer.valueOf(255)); AColorPalette.g2.set(Integer.valueOf(255)); AColorPalette.b2.set(Integer.valueOf(255)); }  break;case 2017321401: if (str.equals("Cherry")) { AColorPalette.r.set(Integer.valueOf(187)); AColorPalette.g.set(Integer.valueOf(55)); AColorPalette.b.set(Integer.valueOf(125)); AColorPalette.r2.set(Integer.valueOf(251)); AColorPalette.g2.set(Integer.valueOf(211)); AColorPalette.b2.set(Integer.valueOf(233)); }  break;case 77125: if (str.equals("May")) { AColorPalette.r.set(Integer.valueOf(253)); AColorPalette.g.set(Integer.valueOf(219)); AColorPalette.b.set(Integer.valueOf(245)); AColorPalette.r2.set(Integer.valueOf(238)); AColorPalette.g2.set(Integer.valueOf(79)); AColorPalette.b2.set(Integer.valueOf(238)); }  break;case -1911512999: if (str.equals("Pastel")) { AColorPalette.r.set(Integer.valueOf(255)); AColorPalette.g.set(Integer.valueOf(109)); AColorPalette.b.set(Integer.valueOf(106)); AColorPalette.r2.set(Integer.valueOf(191)); AColorPalette.g2.set(Integer.valueOf(82)); AColorPalette.b2.set(Integer.valueOf(80)); }  break;case -1725900883: if (str.equals("Amethyst")) { AColorPalette.r.set(Integer.valueOf(144)); AColorPalette.g.set(Integer.valueOf(99)); AColorPalette.b.set(Integer.valueOf(205)); AColorPalette.r2.set(Integer.valueOf(98)); AColorPalette.g2.set(Integer.valueOf(67)); AColorPalette.b2.set(Integer.valueOf(140)); }  break;case -610519087: if (str.equals("Pacific Blue")) { AColorPalette.r.set(Integer.valueOf(5)); AColorPalette.g.set(Integer.valueOf(169)); AColorPalette.b.set(Integer.valueOf(199)); AColorPalette.r2.set(Integer.valueOf(4)); AColorPalette.g2.set(Integer.valueOf(115)); AColorPalette.b2.set(Integer.valueOf(135)); }  break;case 475916819: if (str.equals("Rosy Pink")) { AColorPalette.r.set(Integer.valueOf(255)); AColorPalette.g.set(Integer.valueOf(102)); AColorPalette.b.set(Integer.valueOf(204)); AColorPalette.r2.set(Integer.valueOf(191)); AColorPalette.g2.set(Integer.valueOf(77)); AColorPalette.b2.set(Integer.valueOf(153)); }  break;case -1321965081: if (str.equals("Lavender")) { AColorPalette.r.set(Integer.valueOf(219)); AColorPalette.g.set(Integer.valueOf(166)); AColorPalette.b.set(Integer.valueOf(247)); AColorPalette.r2.set(Integer.valueOf(152)); AColorPalette.g2.set(Integer.valueOf(115)); AColorPalette.b2.set(Integer.valueOf(172)); }  break;case 260616091: if (str.equals("Spearmint")) { AColorPalette.r.set(Integer.valueOf(97)); AColorPalette.g.set(Integer.valueOf(194)); AColorPalette.b.set(Integer.valueOf(162)); AColorPalette.r2.set(Integer.valueOf(65)); AColorPalette.g2.set(Integer.valueOf(130)); AColorPalette.b2.set(Integer.valueOf(108)); }  break;
/*     */       case 79656811: if (str.equals("Satin")) { AColorPalette.r.set(Integer.valueOf(215)); AColorPalette.g.set(Integer.valueOf(60)); AColorPalette.b.set(Integer.valueOf(67)); AColorPalette.r2.set(Integer.valueOf(140)); AColorPalette.g2.set(Integer.valueOf(23)); AColorPalette.b2.set(Integer.valueOf(39)); }  break;
/* 427 */       case -1703869723: if (str.equals("Winter")) {
/* 428 */           AColorPalette.r.set(Integer.valueOf(255));
/* 429 */           AColorPalette.g.set(Integer.valueOf(255));
/* 430 */           AColorPalette.b.set(Integer.valueOf(255));
/* 431 */           AColorPalette.r2.set(Integer.valueOf(100));
/* 432 */           AColorPalette.g2.set(Integer.valueOf(100));
/* 433 */           AColorPalette.b2.set(Integer.valueOf(100));
/*     */         } 
/*     */         break;
/*     */       case 714734988:
/*     */         if (str.equals("Blaze Orange")) {
/*     */           AColorPalette.r.set(Integer.valueOf(255));
/*     */           AColorPalette.g.set(Integer.valueOf(169));
/*     */           AColorPalette.b.set(Integer.valueOf(77));
/*     */           AColorPalette.r2.set(Integer.valueOf(255));
/*     */           AColorPalette.g2.set(Integer.valueOf(130));
/*     */           AColorPalette.b2.set(Integer.valueOf(0));
/*     */         } 
/*     */         break;
/*     */       case -667400978:
/*     */         if (str.equals("Orange Juice")) {
/*     */           AColorPalette.r.set(Integer.valueOf(252));
/*     */           AColorPalette.g.set(Integer.valueOf(74));
/*     */           AColorPalette.b.set(Integer.valueOf(26));
/*     */           AColorPalette.r2.set(Integer.valueOf(247));
/*     */           AColorPalette.g2.set(Integer.valueOf(183));
/*     */           AColorPalette.b2.set(Integer.valueOf(51));
/*     */         } 
/*     */         break;
/*     */       case -1939034764:
/*     */         if (str.equals("Halogen")) {
/*     */           AColorPalette.r.set(Integer.valueOf(255));
/*     */           AColorPalette.g.set(Integer.valueOf(65));
/*     */           AColorPalette.b.set(Integer.valueOf(108));
/*     */           AColorPalette.r2.set(Integer.valueOf(255));
/*     */           AColorPalette.g2.set(Integer.valueOf(75));
/*     */           AColorPalette.b2.set(Integer.valueOf(43));
/*     */         } 
/*     */         break;
/*     */       case 1742979707:
/*     */         if (str.equals("Red Coffee")) {
/*     */           AColorPalette.r.set(Integer.valueOf(0));
/*     */           AColorPalette.g.set(Integer.valueOf(0));
/*     */           AColorPalette.b.set(Integer.valueOf(0));
/*     */           AColorPalette.r2.set(Integer.valueOf(225));
/*     */           AColorPalette.g2.set(Integer.valueOf(34));
/*     */           AColorPalette.b2.set(Integer.valueOf(59));
/*     */         } 
/*     */         break;
/*     */       case 1507226767:
/*     */         if (str.equals("Tropical Ice")) {
/*     */           AColorPalette.r.set(Integer.valueOf(105));
/*     */           AColorPalette.g.set(Integer.valueOf(225));
/*     */           AColorPalette.b.set(Integer.valueOf(209));
/*     */           AColorPalette.r2.set(Integer.valueOf(6));
/*     */           AColorPalette.g2.set(Integer.valueOf(149));
/*     */           AColorPalette.b2.set(Integer.valueOf(255));
/*     */         } 
/*     */         break;
/*     */       case 2380222:
/*     */         if (str.equals("Lush")) {
/*     */           AColorPalette.r.set(Integer.valueOf(168));
/*     */           AColorPalette.g.set(Integer.valueOf(224));
/*     */           AColorPalette.b.set(Integer.valueOf(99));
/*     */           AColorPalette.r2.set(Integer.valueOf(86));
/*     */           AColorPalette.g2.set(Integer.valueOf(171));
/*     */           AColorPalette.b2.set(Integer.valueOf(47));
/*     */         } 
/*     */         break;
/*     */       case -1807319588:
/*     */         if (str.equals("Sundae")) {
/*     */           AColorPalette.r.set(Integer.valueOf(206));
/*     */           AColorPalette.g.set(Integer.valueOf(74));
/*     */           AColorPalette.b.set(Integer.valueOf(126));
/*     */           AColorPalette.r2.set(Integer.valueOf(122));
/*     */           AColorPalette.g2.set(Integer.valueOf(44));
/*     */           AColorPalette.b2.set(Integer.valueOf(77));
/*     */         } 
/*     */         break;
/*     */       case -139613199:
/*     */         if (str.equals("Steel Fade")) {
/*     */           AColorPalette.r.set(Integer.valueOf(66));
/*     */           AColorPalette.g.set(Integer.valueOf(134));
/*     */           AColorPalette.b.set(Integer.valueOf(244));
/*     */           AColorPalette.r2.set(Integer.valueOf(55));
/*     */           AColorPalette.g2.set(Integer.valueOf(59));
/*     */           AColorPalette.b2.set(Integer.valueOf(68));
/*     */         } 
/*     */         break;
/*     */       case -1592975085:
/*     */         if (str.equals("Bubblegum")) {
/*     */           AColorPalette.r.set(Integer.valueOf(243));
/*     */           AColorPalette.g.set(Integer.valueOf(145));
/*     */           AColorPalette.b.set(Integer.valueOf(216));
/*     */           AColorPalette.r2.set(Integer.valueOf(152));
/*     */           AColorPalette.g2.set(Integer.valueOf(165));
/*     */           AColorPalette.b2.set(Integer.valueOf(243));
/*     */         } 
/*     */         break;
/*     */       case 544265936:
/*     */         if (str.equals("Pink Blood")) {
/*     */           AColorPalette.r.set(Integer.valueOf(228));
/*     */           AColorPalette.g.set(Integer.valueOf(0));
/*     */           AColorPalette.b.set(Integer.valueOf(70));
/*     */           AColorPalette.r2.set(Integer.valueOf(255));
/*     */           AColorPalette.g2.set(Integer.valueOf(166));
/*     */           AColorPalette.b2.set(Integer.valueOf(201));
/*     */         } 
/*     */         break;
/*     */       case -705672365:
/*     */         if (str.equals("Digital Horizon")) {
/*     */           AColorPalette.r.set(Integer.valueOf(95));
/*     */           AColorPalette.g.set(Integer.valueOf(195));
/*     */           AColorPalette.b.set(Integer.valueOf(228));
/*     */           AColorPalette.r2.set(Integer.valueOf(229));
/*     */           AColorPalette.g2.set(Integer.valueOf(93));
/*     */           AColorPalette.b2.set(Integer.valueOf(135));
/*     */         } 
/*     */         break;
/*     */       case 355673936:
/*     */         if (str.equals("Express")) {
/*     */           AColorPalette.r.set(Integer.valueOf(173));
/*     */           AColorPalette.g.set(Integer.valueOf(83));
/*     */           AColorPalette.b.set(Integer.valueOf(137));
/*     */           AColorPalette.r2.set(Integer.valueOf(60));
/*     */           AColorPalette.g2.set(Integer.valueOf(16));
/*     */           AColorPalette.b2.set(Integer.valueOf(83));
/*     */         } 
/*     */         break;
/*     */       case 70209100:
/*     */         if (str.equals("Hyper")) {
/*     */           AColorPalette.r.set(Integer.valueOf(52));
/*     */           AColorPalette.g.set(Integer.valueOf(148));
/*     */           AColorPalette.b.set(Integer.valueOf(230));
/*     */           AColorPalette.r2.set(Integer.valueOf(236));
/*     */           AColorPalette.g2.set(Integer.valueOf(110));
/*     */           AColorPalette.b2.set(Integer.valueOf(173));
/*     */         } 
/*     */         break;
/*     */       case 413499846:
/*     */         if (str.equals("Lavender Amethyst")) {
/*     */           AColorPalette.r.set(Integer.valueOf(204));
/*     */           AColorPalette.g.set(Integer.valueOf(192));
/*     */           AColorPalette.b.set(Integer.valueOf(243));
/*     */           AColorPalette.r2.set(Integer.valueOf(142));
/*     */           AColorPalette.g2.set(Integer.valueOf(142));
/*     */           AColorPalette.b2.set(Integer.valueOf(253));
/*     */         } 
/*     */         break;
/*     */       case 64270385:
/*     */         if (str.equals("Blend")) {
/*     */           AColorPalette.r.set(Integer.valueOf(71));
/*     */           AColorPalette.g.set(Integer.valueOf(148));
/*     */           AColorPalette.b.set(Integer.valueOf(253));
/*     */           AColorPalette.r2.set(Integer.valueOf(71));
/*     */           AColorPalette.g2.set(Integer.valueOf(253));
/*     */           AColorPalette.b2.set(Integer.valueOf(160));
/*     */         } 
/*     */         break;
/*     */       case 74103181:
/*     */         if (str.equals("Magic")) {
/*     */           AColorPalette.r.set(Integer.valueOf(74));
/*     */           AColorPalette.g.set(Integer.valueOf(0));
/*     */           AColorPalette.b.set(Integer.valueOf(224));
/*     */           AColorPalette.r2.set(Integer.valueOf(142));
/*     */           AColorPalette.g2.set(Integer.valueOf(25));
/*     */           AColorPalette.b2.set(Integer.valueOf(226));
/*     */         } 
/*     */         break;
/*     */       case -192115605:
/*     */         if (str.equals("Sunkist")) {
/*     */           AColorPalette.r.set(Integer.valueOf(242));
/*     */           AColorPalette.g.set(Integer.valueOf(201));
/*     */           AColorPalette.b.set(Integer.valueOf(76));
/*     */           AColorPalette.r2.set(Integer.valueOf(242));
/*     */           AColorPalette.g2.set(Integer.valueOf(153));
/*     */           AColorPalette.b2.set(Integer.valueOf(74));
/*     */         } 
/*     */         break;
/*     */       case 305969236:
/*     */         if (str.equals("Aubergine")) {
/*     */           AColorPalette.r.set(Integer.valueOf(170));
/*     */           AColorPalette.g.set(Integer.valueOf(7));
/*     */           AColorPalette.b.set(Integer.valueOf(107));
/*     */           AColorPalette.r2.set(Integer.valueOf(97));
/*     */           AColorPalette.g2.set(Integer.valueOf(4));
/*     */           AColorPalette.b2.set(Integer.valueOf(95));
/*     */         } 
/*     */         break;
/*     */       case -1801391991:
/*     */         if (str.equals("Magenta")) {
/*     */           AColorPalette.r.set(Integer.valueOf(213));
/*     */           AColorPalette.g.set(Integer.valueOf(63));
/*     */           AColorPalette.b.set(Integer.valueOf(119));
/*     */           AColorPalette.r2.set(Integer.valueOf(157));
/*     */           AColorPalette.g2.set(Integer.valueOf(68));
/*     */           AColorPalette.b2.set(Integer.valueOf(110));
/*     */         } 
/*     */         break;
/*     */       case -284992087:
/*     */         if (str.equals("Hot Pink")) {
/*     */           AColorPalette.r.set(Integer.valueOf(231));
/*     */           AColorPalette.g.set(Integer.valueOf(84));
/*     */           AColorPalette.b.set(Integer.valueOf(128));
/*     */           AColorPalette.r2.set(Integer.valueOf(172));
/*     */           AColorPalette.g2.set(Integer.valueOf(79));
/*     */           AColorPalette.b2.set(Integer.valueOf(198));
/*     */         } 
/*     */         break;
/*     */       case -1229783720:
/*     */         if (str.equals("Mint Blue")) {
/*     */           AColorPalette.r.set(Integer.valueOf(66));
/*     */           AColorPalette.g.set(Integer.valueOf(158));
/*     */           AColorPalette.b.set(Integer.valueOf(157));
/*     */           AColorPalette.r2.set(Integer.valueOf(40));
/*     */           AColorPalette.g2.set(Integer.valueOf(94));
/*     */           AColorPalette.b2.set(Integer.valueOf(93));
/*     */         } 
/*     */         break;
/*     */       case -1423474420:
/*     */         if (str.equals("Lime Water")) {
/*     */           AColorPalette.r.set(Integer.valueOf(18));
/*     */           AColorPalette.g.set(Integer.valueOf(255));
/*     */           AColorPalette.b.set(Integer.valueOf(247));
/*     */           AColorPalette.r2.set(Integer.valueOf(179));
/*     */           AColorPalette.g2.set(Integer.valueOf(255));
/*     */           AColorPalette.b2.set(Integer.valueOf(171));
/*     */         } 
/*     */         break;
/*     */       case 1982479237:
/*     */         if (str.equals("Banana")) {
/*     */           AColorPalette.r.set(Integer.valueOf(253));
/*     */           AColorPalette.g.set(Integer.valueOf(236));
/*     */           AColorPalette.b.set(Integer.valueOf(177));
/*     */           AColorPalette.r2.set(Integer.valueOf(255));
/*     */           AColorPalette.g2.set(Integer.valueOf(255));
/*     */           AColorPalette.b2.set(Integer.valueOf(50));
/*     */           AColorPalette.r3.set(Integer.valueOf(255));
/*     */           AColorPalette.g3.set(Integer.valueOf(255));
/*     */           AColorPalette.b3.set(Integer.valueOf(255));
/*     */         } 
/*     */         break;
/*     */       case 597461998:
/*     */         if (str.equals("Green Spirit")) {
/*     */           AColorPalette.r.set(Integer.valueOf(159));
/*     */           AColorPalette.g.set(Integer.valueOf(226));
/*     */           AColorPalette.b.set(Integer.valueOf(191));
/*     */           AColorPalette.r2.set(Integer.valueOf(0));
/*     */           AColorPalette.g2.set(Integer.valueOf(135));
/*     */           AColorPalette.b2.set(Integer.valueOf(62));
/*     */         } 
/*     */         break;
/*     */       case -629887807:
/*     */         if (str.equals("Chambray Blue")) {
/*     */           AColorPalette.r.set(Integer.valueOf(33));
/*     */           AColorPalette.g.set(Integer.valueOf(46));
/*     */           AColorPalette.b.set(Integer.valueOf(182));
/*     */           AColorPalette.r2.set(Integer.valueOf(60));
/*     */           AColorPalette.g2.set(Integer.valueOf(82));
/*     */           AColorPalette.b2.set(Integer.valueOf(145));
/*     */         } 
/*     */         break;
/*     */       case 65295377:
/*     */         if (str.equals("Coral")) {
/*     */           AColorPalette.r.set(Integer.valueOf(244));
/*     */           AColorPalette.g.set(Integer.valueOf(168));
/*     */           AColorPalette.b.set(Integer.valueOf(150));
/*     */           AColorPalette.r2.set(Integer.valueOf(52));
/*     */           AColorPalette.g2.set(Integer.valueOf(133));
/*     */           AColorPalette.b2.set(Integer.valueOf(151));
/*     */         } 
/*     */         break;
/*     */       case -235540288:
/*     */         if (str.equals("Sunset Pink")) {
/*     */           AColorPalette.r.set(Integer.valueOf(255));
/*     */           AColorPalette.g.set(Integer.valueOf(145));
/*     */           AColorPalette.b.set(Integer.valueOf(20));
/*     */           AColorPalette.r2.set(Integer.valueOf(245));
/*     */           AColorPalette.g2.set(Integer.valueOf(105));
/*     */           AColorPalette.b2.set(Integer.valueOf(231));
/*     */         } 
/*     */         break;
/*     */       case 2024578267:
/*     */         if (str.equals("Jade Green")) {
/*     */           AColorPalette.r.set(Integer.valueOf(0));
/*     */           AColorPalette.g.set(Integer.valueOf(168));
/*     */           AColorPalette.b.set(Integer.valueOf(107));
/*     */           AColorPalette.r2.set(Integer.valueOf(0));
/*     */           AColorPalette.g2.set(Integer.valueOf(165));
/*     */           AColorPalette.b2.set(Integer.valueOf(66));
/*     */         } 
/*     */         break;
/*     */       case 1643699971:
/*     */         if (str.equals("Blossom")) {
/*     */           AColorPalette.r.set(Integer.valueOf(226));
/*     */           AColorPalette.g.set(Integer.valueOf(208));
/*     */           AColorPalette.b.set(Integer.valueOf(249));
/*     */           AColorPalette.r2.set(Integer.valueOf(49));
/*     */           AColorPalette.g2.set(Integer.valueOf(119));
/*     */           AColorPalette.b2.set(Integer.valueOf(115));
/*     */         } 
/*     */         break;
/*     */       case -1520144358:
/*     */         if (str.equals("Purple Fire")) {
/*     */           AColorPalette.r.set(Integer.valueOf(104));
/*     */           AColorPalette.g.set(Integer.valueOf(71));
/*     */           AColorPalette.b.set(Integer.valueOf(141));
/*     */           AColorPalette.r2.set(Integer.valueOf(177));
/*     */           AColorPalette.g2.set(Integer.valueOf(162));
/*     */           AColorPalette.b2.set(Integer.valueOf(202));
/*     */         } 
/*     */         break;
/*     */       case -1103801142:
/*     */         if (str.equals("Deep Ocean")) {
/*     */           AColorPalette.r.set(Integer.valueOf(60));
/*     */           AColorPalette.g.set(Integer.valueOf(82));
/*     */           AColorPalette.b.set(Integer.valueOf(145));
/*     */           AColorPalette.r2.set(Integer.valueOf(0));
/*     */           AColorPalette.g2.set(Integer.valueOf(20));
/*     */           AColorPalette.b2.set(Integer.valueOf(64));
/*     */         } 
/*     */         break;
/*     */       case 1224269639:
/*     */         if (str.equals("Neon Red")) {
/*     */           AColorPalette.r.set(Integer.valueOf(210));
/*     */           AColorPalette.g.set(Integer.valueOf(39));
/*     */           AColorPalette.b.set(Integer.valueOf(48));
/*     */           AColorPalette.r2.set(Integer.valueOf(184));
/*     */           AColorPalette.g2.set(Integer.valueOf(25));
/*     */           AColorPalette.b2.set(Integer.valueOf(42));
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\ThemeChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */