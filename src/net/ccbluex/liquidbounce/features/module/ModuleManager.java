/*     */ package net.ccbluex.liquidbounce.features.module;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import liying.module.misc.AntiHacker;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.KeyEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.combat.SuperKnockback;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.player.Blink;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.BlurSettings;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.Crosshair;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.render.CustomFont;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000^\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\005\n\002\020\b\n\002\b\005\n\002\020\007\n\002\b\005\n\002\020\002\n\002\b\007\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\021\n\002\b\004\030\0002\0020\001B\005¢\006\002\020\002J\025\020\036\032\0020\0372\006\020 \032\0020\006H\000¢\006\002\b!J\025\020\"\032\0020\0062\n\020#\032\006\022\002\b\0030\005H\002J\022\020$\032\0020\0062\n\020%\032\006\022\002\b\0030\005J\022\020$\032\004\030\0010\0062\b\020&\032\004\030\0010'J\b\020(\032\0020\rH\026J\020\020)\032\0020\0372\006\020*\032\0020+H\003J\030\020,\032\0020\0372\016\020%\032\n\022\006\b\001\022\0020\0060\005H\002J\016\020,\032\0020\0372\006\020 \032\0020\006J\006\020-\032\0020\037J1\020-\032\0020\0372\"\020\b\032\022\022\016\b\001\022\n\022\006\b\001\022\0020\0060\0050.\"\n\022\006\b\001\022\0020\0060\005H\007¢\006\002\020/J\016\0200\032\0020\0372\006\020 \032\0020\006J\006\0201\032\0020\037R2\020\003\032&\022\b\022\006\022\002\b\0030\005\022\004\022\0020\0060\004j\022\022\b\022\006\022\002\b\0030\005\022\004\022\0020\006`\007X\004¢\006\002\n\000R\027\020\b\032\b\022\004\022\0020\0060\t¢\006\b\n\000\032\004\b\n\020\013R\032\020\f\032\0020\rX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\032\020\030\032\0020\031X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035¨\0062"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/ModuleManager;", "Lnet/ccbluex/liquidbounce/event/Listenable;", "()V", "moduleClassMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "Lkotlin/collections/HashMap;", "modules", "Ljava/util/TreeSet;", "getModules", "()Ljava/util/TreeSet;", "shouldNotify", "", "getShouldNotify", "()Z", "setShouldNotify", "(Z)V", "toggleSoundMode", "", "getToggleSoundMode", "()I", "setToggleSoundMode", "(I)V", "toggleVolume", "", "getToggleVolume", "()F", "setToggleVolume", "(F)V", "generateCommand", "", "module", "generateCommand$XSJClient", "get", "clazz", "getModule", "moduleClass", "moduleName", "", "handleEvents", "onKey", "event", "Lnet/ccbluex/liquidbounce/event/KeyEvent;", "registerModule", "registerModules", "", "([Ljava/lang/Class;)V", "unregisterModule", "unregisterallModule", "XSJClient"})
/*     */ public final class ModuleManager implements Listenable {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\020\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\016\020\005\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "module1", "Lnet/ccbluex/liquidbounce/features/module/Module;", "kotlin.jvm.PlatformType", "module2", "compare"})
/*  27 */   static final class ModuleManager$modules$1<T> implements Comparator<E> { public final int compare(Module module1, Module module2) { return module1.getName().compareTo(module2.getName()); } public static final ModuleManager$modules$1 INSTANCE = new ModuleManager$modules$1(); } @NotNull private final TreeSet<Module> modules = new TreeSet<>(ModuleManager$modules$1.INSTANCE); private final HashMap<Class<?>, Module> moduleClassMap; private int toggleSoundMode; private boolean shouldNotify; private float toggleVolume; @NotNull public final TreeSet<Module> getModules() { return this.modules; }
/*  28 */   public ModuleManager() { ModuleManager moduleManager = this; boolean bool = false; HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */     
/*  32 */     Retreat.INSTANCE.getEventManager().registerListener(this); } public final int getToggleSoundMode() { return this.toggleSoundMode; } public final void setToggleSoundMode(int <set-?>) { this.toggleSoundMode = <set-?>; } public final boolean getShouldNotify() { return this.shouldNotify; }
/*     */   public final void setShouldNotify(boolean <set-?>) { this.shouldNotify = <set-?>; }
/*  34 */   public final float getToggleVolume() { return this.toggleVolume; } public final void setToggleVolume(float <set-?>) { this.toggleVolume = <set-?>; }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void registerModules() {
/*  39 */     ClientUtils.getLogger().info("[ModuleManager] Loading modules...");
/*     */     
/*  41 */     registerModules((Class<? extends Module>[])new Class[] { 
/*  42 */           AutoL5.class, 
/*  43 */           PlayerSize.class, 
/*  44 */           Stuck.class, 
/*  45 */           StrengthDetect.class, 
/*  46 */           Trails.class, 
/*  47 */           OldScaffold.class, 
/*  48 */           WarNoSlow.class, 
/*  49 */           ThemeChange.class, 
/*  50 */           NoC03Fix.class, 
/*  51 */           RangeFix.class, 
/*  52 */           IQBoost.class, 
/*  53 */           TestNoSlow.class, 
/*  54 */           NoxzVelo.class, 
/*  55 */           NoxzVelo2.class, 
/*  56 */           HealthHUD.class, 
/*  57 */           PacketDisabler.class, 
/*  58 */           JumpCircle3.class, 
/*  59 */           PacketMonitor.class, 
/*  60 */           GrimVelocity.class, 
/*  61 */           Silentmode.class, 
/*  62 */           ScaffoldTest.class, 
/*  63 */           RetreatClient.class, 
/*  64 */           BlurSettings.class, 
/*  65 */           ESP2D.class, 
/*  66 */           AntiHacker.class, 
/*  67 */           FoodNoslow.class, 
/*  68 */           HYTAutoBlock.class, 
/*  69 */           SuperKnockback.class, 
/*  70 */           Crosshair.class, 
/*  71 */           BlurSettings.class, 
/*  72 */           CustomFont.class, 
/*  73 */           CustomHUD.class, 
/*  74 */           AutoL2.class, 
/*  75 */           AutoL4.class, 
/*  76 */           Blockin.class, 
/*  77 */           BetterHotBar.class, 
/*  78 */           GrimacDestructor.class, 
/*  79 */           HytPUBGMoveDis.class, 
/*  80 */           NoS32.class, 
/*  81 */           NoC0F.class, 
/*  82 */           AutoL3.class, 
/*  83 */           BugUP.class, 
/*  84 */           BufferSpeed.class, 
/*  85 */           AirLadder.class, 
/*  86 */           IceSpeed.class, 
/*  87 */           HighJump.class, 
/*  88 */           KeepSprint.class, 
/*  89 */           PerfectHorseJump.class, 
/*  90 */           BoomFLY.class, 
/*  91 */           TickBase.class, 
/*  92 */           LegitReach.class, 
/*  93 */           LegitAutoBlock.class, 
/*  94 */           BackTrack.class, 
/*  95 */           AutoRunaway.class, 
/*  96 */           AutoSkyWars.class, 
/*  97 */           Aura3RangeHelper.class, 
/*  98 */           KillAura3.class, 
/*  99 */           KillAura4.class, 
/* 100 */           LegitAura.class, 
/* 101 */           Ignite.class, 
/* 102 */           AntiHacker.class, 
/* 103 */           NameTags2.class, 
/* 104 */           PlayerHealthSend.class, 
/* 105 */           ItemPhysics.class, 
/* 106 */           VisualColor.class, 
/* 107 */           ESP3.class, 
/* 108 */           AntiBow.class, 
/* 109 */           AutoGG.class, 
/* 110 */           InvManager.class, 
/* 111 */           RetreatNoSlow.class, 
/* 112 */           Freelook.class, 
/* 113 */           BlockESP2.class, 
/* 114 */           GrimStrafe.class, 
/* 115 */           Wtap.class, 
/* 116 */           Reallyhurt.class, 
/* 117 */           Safeauramode.class, 
/* 118 */           HytAntiFireBall.class, 
/* 119 */           Timer2.class, 
/* 120 */           ScaffoldNew2.class, 
/* 121 */           ScaffoldNew.class, 
/* 122 */           Parkour2.class, 
/* 123 */           NoC0B.class, 
/* 124 */           MotionBlur.class, 
/* 125 */           AttackEffects.class, 
/* 126 */           StealerPlus.class, 
/* 127 */           ScaffoldLB.class, 
/* 128 */           Selfrescue.class, 
/* 129 */           EntitySpeed.class, 
/* 130 */           Cape.class, 
/* 131 */           FollowTargetHud.class, 
/* 132 */           FakeFPS.class, 
/* 133 */           GodLightSync.class, 
/* 134 */           SkidHYTVelocity.class, 
/* 135 */           NoBadPacket.class, 
/* 136 */           NewGUI.class, 
/* 137 */           XSJAntiKB.class, 
/* 138 */           DisablerHYT.class, 
/* 139 */           NoSlowfix.class, 
/* 140 */           ScaffoldHelper.class, 
/* 141 */           Scaffold3.class, 
/* 142 */           ESP2.class, 
/* 143 */           OldHitting.class, 
/* 144 */           HYTAutoArmor.class, 
/* 145 */           KillAura2.class, 
/* 146 */           JumpCircle2.class, 
/* 147 */           AutoPlatform.class, 
/* 148 */           AttackParticle.class, 
/* 149 */           PictureColor2.class, 
/* 150 */           PictureColor.class, 
/* 151 */           NewGrimVelocity.class, 
/* 152 */           SuperChestStealer.class, 
/* 153 */           TestHYTVelocity.class, 
/* 154 */           FastBreakDisabler.class, 
/* 155 */           PostDisabler.class, 
/* 156 */           NewHYTNoSlow.class, 
/* 157 */           SkidCivBreak.class, 
/* 158 */           AntiFakePlayerPlus.class, 
/* 159 */           ColorMixer.class, 
/* 160 */           KillAura.class, 
/* 161 */           CustomUI.class, 
/* 162 */           Crosshair.class, 
/* 163 */           CustomColor.class, 
/* 164 */           SuperKnockback.class, 
/* 165 */           StrafeFix.class, 
/* 166 */           AntiFakePlayer.class, 
/* 167 */           PotionWarn.class, 
/* 168 */           GroundTelly.class, 
/* 169 */           Blink.class, 
/* 170 */           HytAuto.class, 
/* 171 */           BlurSettings.class, 
/* 172 */           GlowESP.class, 
/* 173 */           JumpCircle.class, 
/* 174 */           HytAntiBot.class, 
/* 175 */           AsianHat.class, 
/* 176 */           Scaffold2.class, 
/* 177 */           MemoryFix.class, 
/* 178 */           GrimNoSlow.class, 
/* 179 */           AColorPalette.class, 
/* 180 */           LogoFix.class, 
/* 181 */           SuperKnockback.class, 
/* 182 */           ChatTranslator.class, 
/* 183 */           Ambience.class, 
/* 184 */           HytDisabler.class, 
/* 185 */           NoLagBack.class, 
/* 186 */           HytAutoLeos.class, 
/* 187 */           AutoPlay.class, 
/* 188 */           AutoL.class, 
/* 189 */           XSJVelocity.class, 
/* 190 */           Postdis.class, 
/* 191 */           CatVelocity.class, 
/* 192 */           AntiHunger.class, 
/* 193 */           NoC03.class, 
/* 194 */           HytGapple.class, 
/* 195 */           HytGetName.class, 
/* 196 */           CustomFont.class, 
/* 197 */           DMGParticle.class, 
/* 198 */           BetterFPS.class, 
/* 199 */           Title.class, 
/* 200 */           AutoArmor.class, 
/* 201 */           AutoBow.class, 
/* 202 */           AutoPot.class, 
/* 203 */           AutoSoup.class, 
/* 204 */           AutoWeapon.class, 
/* 205 */           BowAimbot.class, 
/* 206 */           Criticals.class, 
/* 207 */           Trigger.class, 
/* 208 */           Fly.class, 
/* 209 */           ClickGUI.class, 
/* 210 */           InventoryMove.class, 
/* 211 */           LiquidWalk.class, 
/* 212 */           SafeWalk.class, 
/* 213 */           Strafe.class, 
/* 214 */           Sprint.class, 
/* 215 */           Teams.class, 
/* 216 */           NoRotateSet.class, 
/* 217 */           ChestStealer.class, 
/* 218 */           Scaffold.class, 
/* 219 */           CivBreak.class, 
/* 220 */           Tower.class, 
/* 221 */           FastBreak.class, 
/* 222 */           FastPlace.class, 
/* 223 */           ESP.class, 
/*     */           
/* 225 */           HytSpeed.class, 
/* 226 */           NoSlow.class, 
/* 227 */           Velocity.class, 
/* 228 */           Speed.class, 
/* 229 */           Tracers.class, 
/* 230 */           NameTags.class, 
/* 231 */           FastUse.class, 
/* 232 */           Teleport.class, 
/* 233 */           Fullbright.class, 
/* 234 */           ItemESP.class, 
/* 235 */           StorageESP.class, 
/* 236 */           Projectiles.class, 
/* 237 */           NoClip.class, 
/* 238 */           Nuker.class, 
/* 239 */           PingSpoof.class, 
/* 240 */           FastClimb.class, 
/* 241 */           AutoRespawn.class, 
/* 242 */           AutoTool.class, 
/* 243 */           NoWeb.class, 
/* 244 */           Spammer.class, 
/* 245 */           Regen.class, 
/* 246 */           NoFall.class, 
/* 247 */           Blink.class, 
/* 248 */           NameProtect.class, 
/* 249 */           NoHurtCam.class, 
/* 250 */           MidClick.class, 
/* 251 */           XRay.class, 
/* 252 */           Timer.class, 
/* 253 */           Sneak.class, 
/* 254 */           FreeCam.class, 
/* 255 */           Aimbot.class, 
/* 256 */           Eagle.class, 
/* 257 */           HitBox.class, 
/* 258 */           Plugins.class, 
/* 259 */           ConsoleSpammer.class, 
/* 260 */           Parkour.class, 
/* 261 */           FastBow.class, 
/* 262 */           AutoClicker.class, 
/* 263 */           NoBob.class, 
/* 264 */           BlockOverlay.class, 
/* 265 */           NoFriends.class, 
/* 266 */           BlockESP.class, 
/* 267 */           Chams.class, 
/* 268 */           Clip.class, 
/* 269 */           Phase.class, 
/* 270 */           ServerCrasher.class, 
/* 271 */           NoFOV.class, 
/* 272 */           TNTBlock.class, 
/* 273 */           InventoryCleaner.class, 
/* 274 */           TrueSight.class, 
/* 275 */           AntiBlind.class, 
/* 276 */           NoSwing.class, 
/* 277 */           Breadcrumbs.class, 
/* 278 */           AbortBreaking.class, 
/* 279 */           PotionSaver.class, 
/* 280 */           CameraClip.class, 
/* 281 */           NoPitchLimit.class, 
/* 282 */           Liquids.class, 
/* 283 */           AtAllProvider.class, 
/* 284 */           TeleportHit.class, 
/* 285 */           ForceUnicodeChat.class, 
/* 286 */           ItemTeleport.class, 
/* 287 */           ProphuntESP.class, 
/* 288 */           AutoFish.class, 
/* 289 */           Damage.class, 
/* 290 */           KeepContainer.class, 
/* 291 */           VehicleOneHit.class, 
/* 292 */           Reach.class, 
/* 293 */           Rotations.class, 
/* 294 */           NoJumpDelay.class, 
/* 295 */           AntiAFK.class, 
/* 296 */           HUD.class, 
/* 297 */           TNTESP.class, 
/* 298 */           ComponentOnHover.class, 
/* 299 */           ResourcePackSpoof.class, 
/* 300 */           NoSlowBreak.class, 
/* 301 */           PortalMenu.class, 
/* 302 */           EnchantEffect.class, 
/* 303 */           SpeedMine.class, 
/* 304 */           AutoHead.class, 
/* 305 */           TargetStrafe.class, 
/* 306 */           Wings.class, 
/* 307 */           NoClickDelay.class, 
/* 308 */           Animations.class });
/*     */ 
/*     */ 
/*     */     
/* 312 */     registerModule((Module)NoScoreboard.INSTANCE);
/* 313 */     registerModule((Module)Fucker.INSTANCE);
/* 314 */     registerModule((Module)ChestAura.INSTANCE);
/* 315 */     registerModule((Module)AntiBot.INSTANCE);
/*     */     
/* 317 */     ClientUtils.getLogger().info("[ModuleManager] Loaded " + this.modules.size() + " modules.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void registerModule(@NotNull Module module) {
/* 324 */     Intrinsics.checkParameterIsNotNull(module, "module"); if (!module.isSupported())
/*     */       return; 
/* 326 */     TreeSet<Module> treeSet = this.modules; boolean bool = false; treeSet.add(module);
/* 327 */     this.moduleClassMap.put(module.getClass(), module);
/*     */     
/* 329 */     generateCommand$XSJClient(module);
/* 330 */     Retreat.INSTANCE.getEventManager().registerListener(module);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void registerModule(Class moduleClass) {
/*     */     try {
/* 338 */       Intrinsics.checkExpressionValueIsNotNull(moduleClass.newInstance(), "moduleClass.newInstance()"); registerModule((Module)moduleClass.newInstance());
/* 339 */     } catch (Throwable e) {
/* 340 */       ClientUtils.getLogger()
/* 341 */         .error("Failed to load module: " + moduleClass.getName() + " (" + e.getClass().getName() + ": " + e.getMessage() + ')');
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SafeVarargs
/*     */   public final void registerModules(@NotNull Class... modules) {
/* 350 */     Intrinsics.checkParameterIsNotNull(modules, "modules"); Class[] arrayOfClass1 = modules; ModuleManager moduleManager = this; int $i$f$forEach = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Class[] arrayOfClass2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 408 */     for (arrayOfClass2 = arrayOfClass1, i = arrayOfClass2.length, b = 0; b < i; moduleManager.registerModule((Class<? extends Module>)object1), b++) { Object element$iv = arrayOfClass2[b], object1 = element$iv; int $i$a$-unknown-ModuleManager$registerModules$1 = 0; } 
/*     */   } public final void unregisterallModule() { this.modules.clear(); this.moduleClassMap.clear(); } public final void unregisterModule(@NotNull Module module) { Intrinsics.checkParameterIsNotNull(module, "module"); this.modules.remove(module); this.moduleClassMap.remove(module.getClass()); Retreat.INSTANCE.getEventManager().unregisterListener(module); } public final void generateCommand$XSJClient(@NotNull Module module) { Intrinsics.checkParameterIsNotNull(module, "module"); List<Value<?>> values = module.getValues(); if (values.isEmpty()) return;  Retreat.INSTANCE.getCommandManager().registerCommand(new ModuleCommand(module, values)); } @NotNull public final Module getModule(@NotNull Class moduleClass) { Intrinsics.checkParameterIsNotNull(moduleClass, "moduleClass"); if (this.moduleClassMap.get(moduleClass) == null) Intrinsics.throwNpe();  Intrinsics.checkExpressionValueIsNotNull(this.moduleClassMap.get(moduleClass), "moduleClassMap[moduleClass]!!"); return this.moduleClassMap.get(moduleClass); } @NotNull public final Module get(@NotNull Class<?> clazz) { Intrinsics.checkParameterIsNotNull(clazz, "clazz"); return getModule(clazz); } @Nullable public final Module getModule(@Nullable String moduleName) { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield modules : Ljava/util/TreeSet;
/*     */     //   4: checkcast java/lang/Iterable
/*     */     //   7: astore_2
/*     */     //   8: iconst_0
/*     */     //   9: istore_3
/*     */     //   10: aload_2
/*     */     //   11: astore #4
/*     */     //   13: iconst_0
/*     */     //   14: istore #5
/*     */     //   16: aload #4
/*     */     //   18: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   23: astore #6
/*     */     //   25: aload #6
/*     */     //   27: invokeinterface hasNext : ()Z
/*     */     //   32: ifeq -> 72
/*     */     //   35: aload #6
/*     */     //   37: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   42: astore #7
/*     */     //   44: aload #7
/*     */     //   46: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   49: astore #8
/*     */     //   51: iconst_0
/*     */     //   52: istore #9
/*     */     //   54: aload #8
/*     */     //   56: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   59: aload_1
/*     */     //   60: iconst_1
/*     */     //   61: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
/*     */     //   64: ifeq -> 25
/*     */     //   67: aload #7
/*     */     //   69: goto -> 73
/*     */     //   72: aconst_null
/*     */     //   73: checkcast net/ccbluex/liquidbounce/features/module/Module
/*     */     //   76: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #393	-> 0
/*     */     //   #393	-> 54
/*     */     //   #393	-> 64
/*     */     //   #393	-> 76
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   51	13	8	it	Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   54	10	9	$i$a$-find-ModuleManager$getModule$1	I
/*     */     //   0	77	0	this	Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   0	77	1	moduleName	Ljava/lang/String; }
/* 410 */   @EventTarget private final void onKey(KeyEvent event) { Iterable<Module> $this$filter$iv = this.modules; int $i$f$filter = 0; Iterable<Module> iterable1 = $this$filter$iv; Collection<Object> destination$iv$iv = new ArrayList(); int $i$f$filterTo = 0;
/* 411 */     for (Module element$iv$iv : iterable1) { Module it = element$iv$iv; int $i$a$-filter-ModuleManager$onKey$1 = 0; if ((it.getKeyBind() == event.getKey()))
/* 412 */         destination$iv$iv.add(element$iv$iv);  }  Iterable $this$forEach$iv = destination$iv$iv; int $i$f$forEach = 0;
/* 413 */     Iterator iterator = $this$forEach$iv.iterator(); if (iterator.hasNext()) { Object element$iv = iterator.next(); Module it = (Module)element$iv; int $i$a$-forEach-ModuleManager$onKey$2 = 0;
/*     */       it.toggle(); }
/*     */      }
/*     */ 
/*     */   
/*     */   public boolean handleEvents() {
/*     */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\ModuleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */