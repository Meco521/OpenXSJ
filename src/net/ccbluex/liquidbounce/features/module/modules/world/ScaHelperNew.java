/*     */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Parkour;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Parkour2;
/*     */ import net.ccbluex.liquidbounce.features.module.modules.movement.Sprint;
/*     */ import net.ccbluex.liquidbounce.injection.backend.PacketImpl;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.minecraft.network.Packet;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @ModuleInfo(name = "ScaHelperNew", description = "For GrimAC", category = ModuleCategory.WORLD)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\b\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\n\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\037\032\0020 J\b\020!\032\0020 H\026J\b\020\"\032\0020 H\026J\020\020#\032\0020 2\006\020$\032\0020%H\007J\020\020&\032\0020 2\006\020$\032\0020'H\007J\020\020(\032\0020 2\006\020$\032\0020)H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\004X\016¢\006\016\n\000\032\004\b\n\020\006\"\004\b\013\020\bR\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\016\032\0020\rX\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\023\032\0020\rX\004¢\006\002\n\000R\032\020\024\032\0020\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031R\032\020\032\032\0020\004X\016¢\006\016\n\000\032\004\b\033\020\006\"\004\b\034\020\bR\016\020\035\032\0020\020X\004¢\006\002\n\000R\016\020\036\032\0020\020X\004¢\006\002\n\000¨\006*"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaHelperNew;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "a", "", "getA", "()I", "setA", "(I)V", "b", "getB", "setB", "jumpModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "modeValue", "noC0BValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "rotationpitch", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "scaffoldModeValue", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "ticks", "getTicks", "setTicks", "timer2Value", "timerValue", "jump", "", "onDisable", "onEnable", "onJump", "event", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class ScaHelperNew extends Module {
/*  28 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "State" }, "State");
/*     */   
/*  30 */   private final ListValue scaffoldModeValue = new ListValue("Scaffold Mode", new String[] { "Scaffold", "ScaffoldNew", "ScaffoldLB", "Scaffoldmix" }, "ScaffoldNew");
/*     */   
/*  32 */   private final ListValue jumpModeValue = new ListValue("Jump Mode", new String[] { "mc", "mc2", "MotionY", "Key", "Parkour", "Off", "Parkour2" }, "Off");
/*     */   
/*  34 */   private final BoolValue timerValue = new BoolValue("On Ground Timer", true);
/*     */   
/*  36 */   private final BoolValue timer2Value = new BoolValue("Air Timer", true);
/*     */   
/*  38 */   private final BoolValue noC0BValue = new BoolValue("noC0B", true);
/*     */   
/*  40 */   private final IntegerValue rotationpitch = new IntegerValue("rotationpitch", 25, -180, 180);
/*     */   private boolean stop; private int ticks;
/*     */   
/*  43 */   public final boolean getStop() { return this.stop; } public final void setStop(boolean <set-?>) { this.stop = <set-?>; }
/*  44 */   public final int getTicks() { return this.ticks; } public final void setTicks(int <set-?>) { this.ticks = <set-?>; }
/*     */   
/*  46 */   private int a = 1; private int b; public final int getA() { return this.a; } public final void setA(int <set-?>) { this.a = <set-?>; }
/*  47 */   public final int getB() { return this.b; } public final void setB(int <set-?>) { this.b = <set-?>; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void jump() {
/*  55 */     if (MinecraftInstance.mc2.field_71439_g.field_70122_E || !MinecraftInstance.mc2.field_71439_g.field_70160_al) {
/*  56 */       String str = (String)this.jumpModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 3478:
/*  57 */           if (str.equals("mc")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump(); }  break;
/*     */         case 1241855875:
/*  59 */           if (str.equals("motiony")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.42D); }  break;case 107868: if (str.equals("mc2"))
/*  60 */             MinecraftInstance.mc2.field_71439_g.func_70664_aZ();  break;case 106079: if (str.equals("key")) {
/*  61 */             MinecraftInstance.mc2.field_71474_y.field_74314_A.field_74513_e = true;
/*  62 */             MinecraftInstance.mc2.field_71474_y.field_74314_A.field_74513_e = false;
/*     */           } 
/*     */           break; }
/*     */     
/*     */     } 
/*     */   }
/*     */   public void onDisable() {
/*  69 */     this.ticks = 0;
/*  70 */     this.stop = false;
/*  71 */     Retreat.INSTANCE.getModuleManager().get(Sprint.class).setState(true);
/*  72 */     Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(false);
/*  73 */     String str = (String)this.scaffoldModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */       
/*     */       case 937392108:
/*  76 */         if (str.equals("scaffoldlb")) Retreat.INSTANCE.getModuleManager().get(ScaffoldLB.class).setState(false);  break;case -897347594: if (str.equals("scaffold")) Retreat.INSTANCE.getModuleManager().get(Scaffold.class).setState(false);  break;case -1005613590: if (str.equals("scaffoldnew"))
/*  77 */           Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(false);  break;case -1005614426: if (str.equals("scaffoldmix")) {
/*  78 */           Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(false);
/*  79 */           Retreat.INSTANCE.getModuleManager().get(ScaffoldNew2.class).setState(false);
/*     */         }  break;
/*     */     } 
/*  82 */     Retreat.INSTANCE.getModuleManager().get(Parkour.class).setState(false);
/*  83 */     Retreat.INSTANCE.getModuleManager().get(Parkour2.class).setState(false);
/*  84 */     Retreat.INSTANCE.getModuleManager().get(Timer.class).setState(false);
/*  85 */     Retreat.INSTANCE.getModuleManager().get(Timer2.class).setState(false);
/*     */     
/*  87 */     MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false);
/*  88 */     super.onDisable();
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/*  93 */     Intrinsics.checkParameterIsNotNull(event, "event"); Retreat.INSTANCE.getModuleManager().get(Sprint.class).setState(false);
/*  94 */     this.a = 0;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/*  98 */     this.b = 0;
/*  99 */     this.ticks = 0;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/* 104 */     Intrinsics.checkParameterIsNotNull(event, "event"); IPacket $this$unwrap$iv = event.getPacket(); int $i$f$unwrap = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     if ($this$unwrap$iv == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet packet = ((PacketImpl)$this$unwrap$iv).getWrapped(); if (((Boolean)this.noC0BValue.get()).booleanValue()) {
/* 186 */       IPacket iPacket = event.getPacket(); int i = 0; if (iPacket == null) throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.injection.backend.PacketImpl<*>");  Packet e = ((PacketImpl)iPacket).getWrapped();
/*     */       if (e instanceof net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction)
/*     */         event.cancelEvent(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     Intrinsics.checkParameterIsNotNull(event, "event");
/*     */     this.ticks++;
/*     */     if (this.ticks > 10) {
/*     */       this.stop = true;
/*     */     } else {
/*     */       this.stop = false;
/*     */     } 
/*     */     this.b++;
/*     */     if (Retreat.INSTANCE.getModuleManager().get(Timer.class) == null)
/*     */       throw new TypeCastException("null cannot be cast to non-null type net.ccbluex.liquidbounce.features.module.modules.world.Timer"); 
/*     */     Timer timer = (Timer)Retreat.INSTANCE.getModuleManager().get(Timer.class);
/*     */     if (this.b <= 37) {
/*     */       timer.getSpeedValue().set(Double.valueOf(0.65D));
/*     */     } else {
/*     */       timer.getSpeedValue().set(Double.valueOf(1.0D));
/*     */     } 
/*     */     MinecraftInstance.mc.getGameSettings().getKeyBindLeft().setPressed(false);
/*     */     MinecraftInstance.mc.getGameSettings().getKeyBindBack().setPressed(false);
/*     */     MinecraftInstance.mc.getGameSettings().getKeyBindRight().setPressed(false);
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     MinecraftInstance.mc.getThePlayer().setRotationPitch(((Number)this.rotationpitch.get()).intValue());
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer().getOnGround() && this.a == 1) {
/*     */       Retreat.INSTANCE.getModuleManager().get(Sprint.class).setState(true);
/*     */     } else {
/*     */       Retreat.INSTANCE.getModuleManager().get(Sprint.class).setState(false);
/*     */       this.a = 1;
/*     */     } 
/*     */     if (Intrinsics.areEqual(this.jumpModeValue.get(), "Parkour")) {
/*     */       Retreat.INSTANCE.getModuleManager().get(Parkour.class).setState(true);
/*     */     } else {
/*     */       Retreat.INSTANCE.getModuleManager().get(Parkour.class).setState(false);
/*     */       jump();
/*     */     } 
/*     */     if (Intrinsics.areEqual(this.jumpModeValue.get(), "Parkour2")) {
/*     */       Retreat.INSTANCE.getModuleManager().get(Parkour2.class).setState(true);
/*     */     } else {
/*     */       Retreat.INSTANCE.getModuleManager().get(Parkour2.class).setState(false);
/*     */       jump();
/*     */     } 
/*     */     if (MinecraftInstance.mc.getThePlayer() == null)
/*     */       Intrinsics.throwNpe(); 
/*     */     if (MinecraftInstance.mc.getThePlayer().getOnGround()) {
/*     */       if (((Boolean)this.timerValue.get()).booleanValue())
/*     */         Retreat.INSTANCE.getModuleManager().get(Timer.class).setState(true); 
/*     */       if (((Boolean)this.timer2Value.get()).booleanValue())
/*     */         Retreat.INSTANCE.getModuleManager().get(Timer2.class).setState(false); 
/*     */       String str = (String)this.modeValue.get();
/*     */       boolean bool = false;
/*     */       if (str == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */       Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */       if (Intrinsics.areEqual(str.toLowerCase(), "state")) {
/*     */         str = (String)this.scaffoldModeValue.get();
/*     */         bool = false;
/*     */         if (str == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */         Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */         str = str.toLowerCase();
/*     */         switch (str.hashCode()) {
/*     */           case 937392108:
/*     */             if (str.equals("scaffoldlb"))
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldLB.class).setState(false); 
/*     */             break;
/*     */           case -897347594:
/*     */             if (str.equals("scaffold"))
/*     */               Retreat.INSTANCE.getModuleManager().get(Scaffold.class).setState(false); 
/*     */             break;
/*     */           case -1005613590:
/*     */             if (str.equals("scaffoldnew"))
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(false); 
/*     */             break;
/*     */           case -1005614426:
/*     */             if (str.equals("scaffoldmix")) {
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(false);
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldNew2.class).setState(false);
/*     */             } 
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       if (((Boolean)this.timerValue.get()).booleanValue())
/*     */         Retreat.INSTANCE.getModuleManager().get(Timer.class).setState(false); 
/*     */       if (((Boolean)this.timer2Value.get()).booleanValue())
/*     */         Retreat.INSTANCE.getModuleManager().get(Timer2.class).setState(true); 
/*     */       String str = (String)this.modeValue.get();
/*     */       boolean bool = false;
/*     */       if (str == null)
/*     */         throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */       Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */       if (Intrinsics.areEqual(str.toLowerCase(), "state")) {
/*     */         str = (String)this.scaffoldModeValue.get();
/*     */         bool = false;
/*     */         if (str == null)
/*     */           throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); 
/*     */         Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()");
/*     */         str = str.toLowerCase();
/*     */         switch (str.hashCode()) {
/*     */           case 937392108:
/*     */             if (str.equals("scaffoldlb"))
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldLB.class).setState(true); 
/*     */             break;
/*     */           case -897347594:
/*     */             if (str.equals("scaffold"))
/*     */               Retreat.INSTANCE.getModuleManager().get(Scaffold.class).setState(true); 
/*     */             break;
/*     */           case -1005613590:
/*     */             if (str.equals("scaffoldnew"))
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(true); 
/*     */             break;
/*     */           case -1005614426:
/*     */             if (str.equals("scaffoldmix")) {
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldNew.class).setState(true);
/*     */               Retreat.INSTANCE.getModuleManager().get(ScaffoldNew2.class).setState(true);
/*     */             } 
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ScaHelperNew.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */