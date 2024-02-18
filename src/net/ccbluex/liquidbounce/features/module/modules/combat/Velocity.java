/*     */ package net.ccbluex.liquidbounce.features.module.modules.combat;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*     */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntityPlayerSP;
/*     */ import net.ccbluex.liquidbounce.event.BlockBBEvent;
/*     */ import net.ccbluex.liquidbounce.event.EventTarget;
/*     */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*     */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*     */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*     */ import net.ccbluex.liquidbounce.features.module.Module;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*     */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*     */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*     */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*     */ import net.ccbluex.liquidbounce.value.BoolValue;
/*     */ import net.ccbluex.liquidbounce.value.FloatValue;
/*     */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*     */ import net.ccbluex.liquidbounce.value.ListValue;
/*     */ import net.ccbluex.liquidbounce.value.Value;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ModuleInfo(name = "Velocity", description = "Edit your velocity", category = ModuleCategory.COMBAT)
/*     */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000x\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\007\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\n\002\020\016\n\002\b\004\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\020\0201\032\002022\006\0203\032\00204H\007J\b\0205\032\00202H\026J\020\0206\032\002022\006\0203\032\00207H\007J\020\0208\032\002022\006\0203\032\00209H\007J\020\020:\032\002022\006\0203\032\0020;H\007R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\006\032\b\022\004\022\0020\0070\004X\004¢\006\002\n\000R\034\020\b\032\004\030\0010\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\016\020\016\032\0020\007X\016¢\006\002\n\000R\016\020\017\032\0020\007X\016¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\024\020\022\032\b\022\004\022\0020\0070\004X\004¢\006\002\n\000R\024\020\023\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\024\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\025\032\b\022\004\022\0020\0070\004X\004¢\006\002\n\000R\024\020\026\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\027\032\b\022\004\022\0020\0070\004X\004¢\006\002\n\000R\016\020\030\032\0020\031X\004¢\006\002\n\000R\024\020\032\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020\033\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020\034\032\0020\007X\016¢\006\002\n\000R\016\020\035\032\0020\036X\004¢\006\002\n\000R\024\020\037\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020 \032\0020\021X\004¢\006\002\n\000R\016\020!\032\0020\021X\004¢\006\002\n\000R\024\020\"\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\016\020#\032\0020\007X\016¢\006\002\n\000R\024\020$\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\024\020%\032\0020&8VX\004¢\006\006\032\004\b'\020(R\016\020)\032\0020\007X\016¢\006\002\n\000R\016\020*\032\0020+X\016¢\006\002\n\000R\016\020,\032\0020-X\004¢\006\002\n\000R\016\020.\032\0020/X\016¢\006\002\n\000R\016\0200\032\0020\031X\004¢\006\002\n\000¨\006<"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/combat/Velocity;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "aacPushXZReducerValue", "Lnet/ccbluex/liquidbounce/value/Value;", "", "aacPushYReducerValue", "", "block", "Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "getBlock", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;", "setBlock", "(Lnet/ccbluex/liquidbounce/api/minecraft/client/block/IBlock;)V", "canCancelJump", "canCleanJump", "cobwebValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "customC06FakeLag", "customX", "customY", "customYStart", "customZ", "grimReduceNoMotionY", "horizontalValue", "Lnet/ccbluex/liquidbounce/value/FloatValue;", "hytpacketaset", "hytpacketbset", "jump", "modeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "newaac4XZReducerValue", "noFireValue", "onlyGroundValue", "reverse2StrengthValue", "reverseHurt", "reverseStrengthValue", "tag", "", "getTag", "()Ljava/lang/String;", "velocityInput", "velocityTick", "", "velocityTickValue", "Lnet/ccbluex/liquidbounce/value/IntegerValue;", "velocityTimer", "Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;", "verticalValue", "onBlockBB", "", "event", "Lnet/ccbluex/liquidbounce/event/BlockBBEvent;", "onDisable", "onJump", "Lnet/ccbluex/liquidbounce/event/JumpEvent;", "onPacket", "Lnet/ccbluex/liquidbounce/event/PacketEvent;", "onUpdate", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*     */ public final class Velocity
/*     */   extends Module
/*     */ {
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Velocity$newaac4XZReducerValue$1
/*     */     extends Lambda
/*     */     implements Function0<Boolean>
/*     */   {
/*     */     public final boolean invoke() {
/*  57 */       String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("aac4");
/*     */     }
/*     */     Velocity$newaac4XZReducerValue$1() {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  63 */   static final class Velocity$reverseStrengthValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("reverse"); } Velocity$reverseStrengthValue$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  65 */   static final class Velocity$reverse2StrengthValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("smoothreverse"); } Velocity$reverse2StrengthValue$1() {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  69 */   static final class Velocity$hytpacketaset$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (!str.toLowerCase().equals("hytpacketa")) { str = (String)Velocity.this.modeValue.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (str.toLowerCase().equals("hytpacketfix")); return false; }
/*     */        } Velocity$hytpacketaset$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  72 */   static final class Velocity$hytpacketbset$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("hytpacketa"); } Velocity$hytpacketbset$1() {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  76 */   static final class Velocity$aacPushXZReducerValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("aac4push"); } Velocity$aacPushXZReducerValue$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  78 */   static final class Velocity$aacPushYReducerValue$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("aac4push"); }
/*     */     
/*     */     Velocity$aacPushYReducerValue$1() {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*     */   static final class Velocity$grimReduceNoMotionY$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() {
/*  85 */       String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("grimreduce");
/*     */     } Velocity$grimReduceNoMotionY$1() {
/*     */       super(0);
/*     */     } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  90 */   static final class Velocity$customX$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("custom"); } Velocity$customX$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  92 */   static final class Velocity$customYStart$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("custom"); } Velocity$customYStart$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  94 */   static final class Velocity$customY$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("custom"); } Velocity$customY$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
/*  96 */   static final class Velocity$customZ$1 extends Lambda implements Function0<Boolean> { public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("custom"); } Velocity$customZ$1() { super(0); } }
/*     */   @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"\000\b\n\000\n\002\020\013\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"}) static final class Velocity$customC06FakeLag$1 extends Lambda implements Function0<Boolean> { Velocity$customC06FakeLag$1() { super(0); }
/*  98 */     public final boolean invoke() { String str = (String)Velocity.this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); return str.toLowerCase().equals("custom"); } } private final FloatValue horizontalValue = new FloatValue("Horizontal", 0.0F, 0.0F, 1.0F); private final FloatValue verticalValue = new FloatValue("Vertical", 0.0F, 0.0F, 1.0F); private final ListValue modeValue = new ListValue("Mode", new String[] { "GrimReduce", "Custom", "AAC4", "Simple", "AAC", "AACPush", "AACZero", "Reverse", "SmoothReverse", "Jump", "AAC5Reduce", "HytPacketA", "Glitch", "HytTick", "Vanilla", "HytTest", "HytNewTest", "HytPacket", "NewAAC4", "HytMotion", "NewHytMotion", "HytPacketB", "HytPacketFix", "S27" }, "Vanilla"); private final Value<Float> newaac4XZReducerValue = (new FloatValue("NewAAC4XZReducer", 0.45F, 0.0F, 1.0F)).displayable(new Velocity$newaac4XZReducerValue$1()); private final IntegerValue velocityTickValue = new IntegerValue("VelocityTick", 1, 0, 10); private final Value<Boolean> customC06FakeLag = (new BoolValue("CustomC06FakeLag", false)).displayable(new Velocity$customC06FakeLag$1()); private final Value<Float> reverseStrengthValue = (new FloatValue("ReverseStrength", 1.0F, 0.1F, 1.0F)).displayable(new Velocity$reverseStrengthValue$1()); private final Value<Float> reverse2StrengthValue = (new FloatValue("SmoothReverseStrength", 0.05F, 0.02F, 0.1F)).displayable(new Velocity$reverse2StrengthValue$1()); private final Value<Float> hytpacketaset = (new FloatValue("HytPacketASet", 0.35F, 0.1F, 1.0F)).displayable(new Velocity$hytpacketaset$1()); private final Value<Float> hytpacketbset = (new FloatValue("HytPacketBSet", 0.5F, 1.0F, 1.0F)).displayable(new Velocity$hytpacketbset$1()); private final Value<Float> aacPushXZReducerValue = (new FloatValue("AACPushXZReducer", 2.0F, 1.0F, 3.0F)).displayable(new Velocity$aacPushXZReducerValue$1()); private final Value<Boolean> aacPushYReducerValue = (new BoolValue("AACPushYReducer", true)).displayable(new Velocity$aacPushYReducerValue$1()); @Nullable
/*     */   private IBlock block; @Nullable
/*     */   public final IBlock getBlock() {
/*     */     return this.block;
/*     */   } public final void setBlock(@Nullable IBlock <set-?>) {
/*     */     this.block = <set-?>;
/* 104 */   } private final BoolValue noFireValue = new BoolValue("noFire", false); private final BoolValue cobwebValue = new BoolValue("NoCobweb", true); private final BoolValue onlyGroundValue = new BoolValue("OnlyGround", true); private final Value<Boolean> grimReduceNoMotionY = (new BoolValue("GrimNoMotionY", true)).displayable(new Velocity$grimReduceNoMotionY$1()); private final Value<Float> customX = (new FloatValue("CustomX", 0.0F, 0.0F, 1.0F)).displayable(new Velocity$customX$1()); private final Value<Boolean> customYStart = (new BoolValue("CanCustomY", false)).displayable(new Velocity$customYStart$1()); private final Value<Float> customY = (new FloatValue("CustomY", 1.0F, 1.0F, 2.0F)).displayable(new Velocity$customY$1()); private final Value<Float> customZ = (new FloatValue("CustomZ", 0.0F, 0.0F, 1.0F)).displayable(new Velocity$customZ$1()); private MSTimer velocityTimer = new MSTimer();
/*     */   
/*     */   private boolean velocityInput;
/*     */   
/*     */   private boolean canCleanJump;
/*     */   
/*     */   private int velocityTick;
/*     */   private boolean reverseHurt;
/*     */   private boolean jump;
/*     */   private boolean canCancelJump;
/*     */   
/*     */   @NotNull
/*     */   public String getTag() {
/* 117 */     return (String)this.modeValue.get();
/*     */   }
/*     */   public void onDisable() {
/* 120 */     if (MinecraftInstance.mc.getThePlayer() != null) { MinecraftInstance.mc.getThePlayer().setSpeedInAir(0.02F); } else { MinecraftInstance.mc.getThePlayer(); }
/*     */   
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
/*     */   @EventTarget
/*     */   public final void onUpdate(@NotNull UpdateEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 23
/*     */     //   21: pop
/*     */     //   22: return
/*     */     //   23: astore_2
/*     */     //   24: aload_2
/*     */     //   25: invokeinterface isInWater : ()Z
/*     */     //   30: ifne -> 51
/*     */     //   33: aload_2
/*     */     //   34: invokeinterface isInLava : ()Z
/*     */     //   39: ifne -> 51
/*     */     //   42: aload_2
/*     */     //   43: invokeinterface isInWeb : ()Z
/*     */     //   48: ifeq -> 52
/*     */     //   51: return
/*     */     //   52: aload_2
/*     */     //   53: invokeinterface isDead : ()Z
/*     */     //   58: ifne -> 178
/*     */     //   61: aload_0
/*     */     //   62: getfield noFireValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   65: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   68: checkcast java/lang/Boolean
/*     */     //   71: invokevirtual booleanValue : ()Z
/*     */     //   74: ifeq -> 100
/*     */     //   77: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   80: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   85: dup
/*     */     //   86: ifnonnull -> 92
/*     */     //   89: invokestatic throwNpe : ()V
/*     */     //   92: invokeinterface isBurning : ()Z
/*     */     //   97: ifne -> 178
/*     */     //   100: aload_0
/*     */     //   101: getfield cobwebValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   104: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   107: checkcast java/lang/Boolean
/*     */     //   110: invokevirtual booleanValue : ()Z
/*     */     //   113: ifeq -> 139
/*     */     //   116: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   119: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   124: dup
/*     */     //   125: ifnonnull -> 131
/*     */     //   128: invokestatic throwNpe : ()V
/*     */     //   131: invokeinterface isInWeb : ()Z
/*     */     //   136: ifne -> 178
/*     */     //   139: aload_0
/*     */     //   140: getfield onlyGroundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   143: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   146: checkcast java/lang/Boolean
/*     */     //   149: invokevirtual booleanValue : ()Z
/*     */     //   152: ifeq -> 179
/*     */     //   155: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   158: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   163: dup
/*     */     //   164: ifnonnull -> 170
/*     */     //   167: invokestatic throwNpe : ()V
/*     */     //   170: invokeinterface getOnGround : ()Z
/*     */     //   175: ifne -> 179
/*     */     //   178: return
/*     */     //   179: aload_0
/*     */     //   180: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   183: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   186: checkcast java/lang/String
/*     */     //   189: astore_3
/*     */     //   190: iconst_0
/*     */     //   191: istore #4
/*     */     //   193: aload_3
/*     */     //   194: dup
/*     */     //   195: ifnonnull -> 208
/*     */     //   198: new kotlin/TypeCastException
/*     */     //   201: dup
/*     */     //   202: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   204: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   207: athrow
/*     */     //   208: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   211: dup
/*     */     //   212: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   214: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   217: astore_3
/*     */     //   218: aload_3
/*     */     //   219: invokevirtual hashCode : ()I
/*     */     //   222: lookupswitch default -> 2166, -1970553484 -> 520, -1513652168 -> 508, -1466691239 -> 400, -1349088399 -> 376, -1243181771 -> 424, -1234547235 -> 436, -1234264725 -> 364, 96323 -> 352, 2986065 -> 484, 3273774 -> 496, 232843001 -> 448, 967805301 -> 460, 1099846370 -> 388, 1385917856 -> 472, 1845586417 -> 412
/*     */     //   352: aload_3
/*     */     //   353: ldc 'aac'
/*     */     //   355: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   358: ifeq -> 2166
/*     */     //   361: goto -> 1252
/*     */     //   364: aload_3
/*     */     //   365: ldc 'aaczero'
/*     */     //   367: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   370: ifeq -> 2166
/*     */     //   373: goto -> 2093
/*     */     //   376: aload_3
/*     */     //   377: ldc 'custom'
/*     */     //   379: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   382: ifeq -> 2166
/*     */     //   385: goto -> 1845
/*     */     //   388: aload_3
/*     */     //   389: ldc 'reverse'
/*     */     //   391: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   394: ifeq -> 2166
/*     */     //   397: goto -> 938
/*     */     //   400: aload_3
/*     */     //   401: ldc 'newhytmotion'
/*     */     //   403: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   406: ifeq -> 2166
/*     */     //   409: goto -> 1455
/*     */     //   412: aload_3
/*     */     //   413: ldc 'newaac4'
/*     */     //   415: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   418: ifeq -> 2166
/*     */     //   421: goto -> 1090
/*     */     //   424: aload_3
/*     */     //   425: ldc 'glitch'
/*     */     //   427: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   430: ifeq -> 2166
/*     */     //   433: goto -> 721
/*     */     //   436: aload_3
/*     */     //   437: ldc 'aacpush'
/*     */     //   439: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   442: ifeq -> 2166
/*     */     //   445: goto -> 1656
/*     */     //   448: aload_3
/*     */     //   449: ldc 'hytmotion'
/*     */     //   451: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   454: ifeq -> 2166
/*     */     //   457: goto -> 1358
/*     */     //   460: aload_3
/*     */     //   461: ldc 'grimreduce'
/*     */     //   463: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   466: ifeq -> 2166
/*     */     //   469: goto -> 645
/*     */     //   472: aload_3
/*     */     //   473: ldc 'hyttick'
/*     */     //   475: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   478: ifeq -> 2166
/*     */     //   481: goto -> 855
/*     */     //   484: aload_3
/*     */     //   485: ldc 'aac4'
/*     */     //   487: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   490: ifeq -> 2166
/*     */     //   493: goto -> 1002
/*     */     //   496: aload_3
/*     */     //   497: ldc 'jump'
/*     */     //   499: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   502: ifeq -> 2166
/*     */     //   505: goto -> 532
/*     */     //   508: aload_3
/*     */     //   509: ldc 'aac5reduce'
/*     */     //   511: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   514: ifeq -> 2166
/*     */     //   517: goto -> 759
/*     */     //   520: aload_3
/*     */     //   521: ldc 'smoothreverse'
/*     */     //   523: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   526: ifeq -> 2166
/*     */     //   529: goto -> 1158
/*     */     //   532: aload_2
/*     */     //   533: invokeinterface getHurtTime : ()I
/*     */     //   538: ifle -> 2166
/*     */     //   541: aload_2
/*     */     //   542: ldc2_w 0.42
/*     */     //   545: invokeinterface setMotionY : (D)V
/*     */     //   550: aload_2
/*     */     //   551: invokeinterface getRotationYaw : ()F
/*     */     //   556: ldc_w 0.017453292
/*     */     //   559: fmul
/*     */     //   560: fstore #4
/*     */     //   562: aload_2
/*     */     //   563: dup
/*     */     //   564: invokeinterface getMotionX : ()D
/*     */     //   569: dstore #7
/*     */     //   571: astore #6
/*     */     //   573: iconst_0
/*     */     //   574: istore #5
/*     */     //   576: fload #4
/*     */     //   578: f2d
/*     */     //   579: invokestatic sin : (D)D
/*     */     //   582: d2f
/*     */     //   583: fstore #9
/*     */     //   585: aload #6
/*     */     //   587: dload #7
/*     */     //   589: fload #9
/*     */     //   591: f2d
/*     */     //   592: ldc2_w 0.2
/*     */     //   595: dmul
/*     */     //   596: dsub
/*     */     //   597: invokeinterface setMotionX : (D)V
/*     */     //   602: aload_2
/*     */     //   603: dup
/*     */     //   604: invokeinterface getMotionZ : ()D
/*     */     //   609: dstore #7
/*     */     //   611: astore #6
/*     */     //   613: iconst_0
/*     */     //   614: istore #5
/*     */     //   616: fload #4
/*     */     //   618: f2d
/*     */     //   619: invokestatic cos : (D)D
/*     */     //   622: d2f
/*     */     //   623: fstore #9
/*     */     //   625: aload #6
/*     */     //   627: dload #7
/*     */     //   629: fload #9
/*     */     //   631: f2d
/*     */     //   632: ldc2_w 0.2
/*     */     //   635: dmul
/*     */     //   636: dadd
/*     */     //   637: invokeinterface setMotionZ : (D)V
/*     */     //   642: goto -> 2166
/*     */     //   645: aload_2
/*     */     //   646: invokeinterface getHurtTime : ()I
/*     */     //   651: ifle -> 2166
/*     */     //   654: aload_2
/*     */     //   655: dup
/*     */     //   656: invokeinterface getMotionX : ()D
/*     */     //   661: ldc2_w -1.0E-7
/*     */     //   664: dadd
/*     */     //   665: invokeinterface setMotionX : (D)V
/*     */     //   670: aload_0
/*     */     //   671: getfield grimReduceNoMotionY : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   674: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   677: checkcast java/lang/Boolean
/*     */     //   680: invokevirtual booleanValue : ()Z
/*     */     //   683: ifne -> 702
/*     */     //   686: aload_2
/*     */     //   687: dup
/*     */     //   688: invokeinterface getMotionY : ()D
/*     */     //   693: ldc2_w -1.0E-7
/*     */     //   696: dadd
/*     */     //   697: invokeinterface setMotionY : (D)V
/*     */     //   702: aload_2
/*     */     //   703: dup
/*     */     //   704: invokeinterface getMotionZ : ()D
/*     */     //   709: ldc2_w -1.0E-7
/*     */     //   712: dadd
/*     */     //   713: invokeinterface setMotionZ : (D)V
/*     */     //   718: goto -> 2166
/*     */     //   721: aload_2
/*     */     //   722: aload_0
/*     */     //   723: getfield velocityInput : Z
/*     */     //   726: invokeinterface setNoClip : (Z)V
/*     */     //   731: aload_2
/*     */     //   732: invokeinterface getHurtTime : ()I
/*     */     //   737: bipush #7
/*     */     //   739: if_icmpne -> 751
/*     */     //   742: aload_2
/*     */     //   743: ldc2_w 0.4
/*     */     //   746: invokeinterface setMotionY : (D)V
/*     */     //   751: aload_0
/*     */     //   752: iconst_0
/*     */     //   753: putfield velocityInput : Z
/*     */     //   756: goto -> 2166
/*     */     //   759: aload_2
/*     */     //   760: invokeinterface getHurtTime : ()I
/*     */     //   765: iconst_1
/*     */     //   766: if_icmple -> 808
/*     */     //   769: aload_0
/*     */     //   770: getfield velocityInput : Z
/*     */     //   773: ifeq -> 808
/*     */     //   776: aload_2
/*     */     //   777: dup
/*     */     //   778: invokeinterface getMotionX : ()D
/*     */     //   783: ldc2_w 0.81
/*     */     //   786: dmul
/*     */     //   787: invokeinterface setMotionX : (D)V
/*     */     //   792: aload_2
/*     */     //   793: dup
/*     */     //   794: invokeinterface getMotionZ : ()D
/*     */     //   799: ldc2_w 0.81
/*     */     //   802: dmul
/*     */     //   803: invokeinterface setMotionZ : (D)V
/*     */     //   808: aload_0
/*     */     //   809: getfield velocityInput : Z
/*     */     //   812: ifeq -> 2166
/*     */     //   815: aload_2
/*     */     //   816: invokeinterface getHurtTime : ()I
/*     */     //   821: iconst_5
/*     */     //   822: if_icmplt -> 834
/*     */     //   825: aload_2
/*     */     //   826: invokeinterface getOnGround : ()Z
/*     */     //   831: ifeq -> 2166
/*     */     //   834: aload_0
/*     */     //   835: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   838: ldc2_w 120
/*     */     //   841: invokevirtual hasTimePassed : (J)Z
/*     */     //   844: ifeq -> 2166
/*     */     //   847: aload_0
/*     */     //   848: iconst_0
/*     */     //   849: putfield velocityInput : Z
/*     */     //   852: goto -> 2166
/*     */     //   855: aload_0
/*     */     //   856: getfield velocityTick : I
/*     */     //   859: aload_0
/*     */     //   860: getfield velocityTickValue : Lnet/ccbluex/liquidbounce/value/IntegerValue;
/*     */     //   863: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   866: checkcast java/lang/Number
/*     */     //   869: invokevirtual intValue : ()I
/*     */     //   872: if_icmple -> 922
/*     */     //   875: aload_2
/*     */     //   876: invokeinterface getMotionY : ()D
/*     */     //   881: iconst_0
/*     */     //   882: i2d
/*     */     //   883: dcmpl
/*     */     //   884: ifle -> 894
/*     */     //   887: aload_2
/*     */     //   888: dconst_0
/*     */     //   889: invokeinterface setMotionY : (D)V
/*     */     //   894: aload_2
/*     */     //   895: dconst_0
/*     */     //   896: invokeinterface setMotionX : (D)V
/*     */     //   901: aload_2
/*     */     //   902: dconst_0
/*     */     //   903: invokeinterface setMotionZ : (D)V
/*     */     //   908: aload_2
/*     */     //   909: ldc_w -1.0E-5
/*     */     //   912: invokeinterface setJumpMovementFactor : (F)V
/*     */     //   917: aload_0
/*     */     //   918: iconst_0
/*     */     //   919: putfield velocityInput : Z
/*     */     //   922: aload_0
/*     */     //   923: getfield velocityTick : I
/*     */     //   926: iconst_1
/*     */     //   927: if_icmple -> 2166
/*     */     //   930: aload_0
/*     */     //   931: iconst_0
/*     */     //   932: putfield velocityInput : Z
/*     */     //   935: goto -> 2166
/*     */     //   938: aload_0
/*     */     //   939: getfield velocityInput : Z
/*     */     //   942: ifne -> 946
/*     */     //   945: return
/*     */     //   946: aload_2
/*     */     //   947: invokeinterface getOnGround : ()Z
/*     */     //   952: ifne -> 981
/*     */     //   955: getstatic net/ccbluex/liquidbounce/utils/MovementUtils.INSTANCE : Lnet/ccbluex/liquidbounce/utils/MovementUtils;
/*     */     //   958: invokevirtual getSpeed : ()F
/*     */     //   961: aload_0
/*     */     //   962: getfield reverseStrengthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   965: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   968: checkcast java/lang/Number
/*     */     //   971: invokevirtual floatValue : ()F
/*     */     //   974: fmul
/*     */     //   975: invokestatic strafe : (F)V
/*     */     //   978: goto -> 2166
/*     */     //   981: aload_0
/*     */     //   982: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   985: ldc2_w 80
/*     */     //   988: invokevirtual hasTimePassed : (J)Z
/*     */     //   991: ifeq -> 2166
/*     */     //   994: aload_0
/*     */     //   995: iconst_0
/*     */     //   996: putfield velocityInput : Z
/*     */     //   999: goto -> 2166
/*     */     //   1002: aload_2
/*     */     //   1003: invokeinterface getOnGround : ()Z
/*     */     //   1008: ifne -> 1061
/*     */     //   1011: aload_0
/*     */     //   1012: getfield velocityInput : Z
/*     */     //   1015: ifeq -> 2166
/*     */     //   1018: aload_2
/*     */     //   1019: ldc 0.02
/*     */     //   1021: invokeinterface setSpeedInAir : (F)V
/*     */     //   1026: aload_2
/*     */     //   1027: dup
/*     */     //   1028: invokeinterface getMotionX : ()D
/*     */     //   1033: ldc2_w 0.6
/*     */     //   1036: dmul
/*     */     //   1037: invokeinterface setMotionX : (D)V
/*     */     //   1042: aload_2
/*     */     //   1043: dup
/*     */     //   1044: invokeinterface getMotionZ : ()D
/*     */     //   1049: ldc2_w 0.6
/*     */     //   1052: dmul
/*     */     //   1053: invokeinterface setMotionZ : (D)V
/*     */     //   1058: goto -> 2166
/*     */     //   1061: aload_0
/*     */     //   1062: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1065: ldc2_w 80
/*     */     //   1068: invokevirtual hasTimePassed : (J)Z
/*     */     //   1071: ifeq -> 1087
/*     */     //   1074: aload_0
/*     */     //   1075: iconst_0
/*     */     //   1076: putfield velocityInput : Z
/*     */     //   1079: aload_2
/*     */     //   1080: ldc 0.02
/*     */     //   1082: invokeinterface setSpeedInAir : (F)V
/*     */     //   1087: goto -> 2166
/*     */     //   1090: aload_2
/*     */     //   1091: invokeinterface getHurtTime : ()I
/*     */     //   1096: ifle -> 2166
/*     */     //   1099: aload_2
/*     */     //   1100: invokeinterface getOnGround : ()Z
/*     */     //   1105: ifne -> 2166
/*     */     //   1108: aload_0
/*     */     //   1109: getfield newaac4XZReducerValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1112: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1115: checkcast java/lang/Number
/*     */     //   1118: invokevirtual floatValue : ()F
/*     */     //   1121: fstore #4
/*     */     //   1123: aload_2
/*     */     //   1124: dup
/*     */     //   1125: invokeinterface getMotionX : ()D
/*     */     //   1130: fload #4
/*     */     //   1132: f2d
/*     */     //   1133: dmul
/*     */     //   1134: invokeinterface setMotionX : (D)V
/*     */     //   1139: aload_2
/*     */     //   1140: dup
/*     */     //   1141: invokeinterface getMotionZ : ()D
/*     */     //   1146: fload #4
/*     */     //   1148: f2d
/*     */     //   1149: dmul
/*     */     //   1150: invokeinterface setMotionZ : (D)V
/*     */     //   1155: goto -> 2166
/*     */     //   1158: aload_0
/*     */     //   1159: getfield velocityInput : Z
/*     */     //   1162: ifne -> 1174
/*     */     //   1165: aload_2
/*     */     //   1166: ldc 0.02
/*     */     //   1168: invokeinterface setSpeedInAir : (F)V
/*     */     //   1173: return
/*     */     //   1174: aload_2
/*     */     //   1175: invokeinterface getHurtTime : ()I
/*     */     //   1180: ifle -> 1188
/*     */     //   1183: aload_0
/*     */     //   1184: iconst_1
/*     */     //   1185: putfield reverseHurt : Z
/*     */     //   1188: aload_2
/*     */     //   1189: invokeinterface getOnGround : ()Z
/*     */     //   1194: ifne -> 1226
/*     */     //   1197: aload_0
/*     */     //   1198: getfield reverseHurt : Z
/*     */     //   1201: ifeq -> 2166
/*     */     //   1204: aload_2
/*     */     //   1205: aload_0
/*     */     //   1206: getfield reverse2StrengthValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1209: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1212: checkcast java/lang/Number
/*     */     //   1215: invokevirtual floatValue : ()F
/*     */     //   1218: invokeinterface setSpeedInAir : (F)V
/*     */     //   1223: goto -> 2166
/*     */     //   1226: aload_0
/*     */     //   1227: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1230: ldc2_w 80
/*     */     //   1233: invokevirtual hasTimePassed : (J)Z
/*     */     //   1236: ifeq -> 1249
/*     */     //   1239: aload_0
/*     */     //   1240: iconst_0
/*     */     //   1241: putfield velocityInput : Z
/*     */     //   1244: aload_0
/*     */     //   1245: iconst_0
/*     */     //   1246: putfield reverseHurt : Z
/*     */     //   1249: goto -> 2166
/*     */     //   1252: aload_0
/*     */     //   1253: getfield velocityInput : Z
/*     */     //   1256: ifeq -> 2166
/*     */     //   1259: aload_0
/*     */     //   1260: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   1263: ldc2_w 80
/*     */     //   1266: invokevirtual hasTimePassed : (J)Z
/*     */     //   1269: ifeq -> 2166
/*     */     //   1272: aload_2
/*     */     //   1273: dup
/*     */     //   1274: invokeinterface getMotionX : ()D
/*     */     //   1279: aload_0
/*     */     //   1280: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1283: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1286: checkcast java/lang/Number
/*     */     //   1289: invokevirtual doubleValue : ()D
/*     */     //   1292: dmul
/*     */     //   1293: invokeinterface setMotionX : (D)V
/*     */     //   1298: aload_2
/*     */     //   1299: dup
/*     */     //   1300: invokeinterface getMotionZ : ()D
/*     */     //   1305: aload_0
/*     */     //   1306: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1309: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1312: checkcast java/lang/Number
/*     */     //   1315: invokevirtual doubleValue : ()D
/*     */     //   1318: dmul
/*     */     //   1319: invokeinterface setMotionZ : (D)V
/*     */     //   1324: aload_2
/*     */     //   1325: dup
/*     */     //   1326: invokeinterface getMotionY : ()D
/*     */     //   1331: aload_0
/*     */     //   1332: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   1335: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1338: checkcast java/lang/Number
/*     */     //   1341: invokevirtual doubleValue : ()D
/*     */     //   1344: dmul
/*     */     //   1345: invokeinterface setMotionY : (D)V
/*     */     //   1350: aload_0
/*     */     //   1351: iconst_0
/*     */     //   1352: putfield velocityInput : Z
/*     */     //   1355: goto -> 2166
/*     */     //   1358: aload_2
/*     */     //   1359: invokeinterface getHurtTime : ()I
/*     */     //   1364: ifle -> 2166
/*     */     //   1367: aload_2
/*     */     //   1368: invokeinterface isDead : ()Z
/*     */     //   1373: ifne -> 2166
/*     */     //   1376: aload_2
/*     */     //   1377: invokeinterface getHurtTime : ()I
/*     */     //   1382: iconst_5
/*     */     //   1383: if_icmpgt -> 2166
/*     */     //   1386: aload_2
/*     */     //   1387: dup
/*     */     //   1388: invokeinterface getMotionX : ()D
/*     */     //   1393: ldc2_w 0.4
/*     */     //   1396: dmul
/*     */     //   1397: invokeinterface setMotionX : (D)V
/*     */     //   1402: aload_2
/*     */     //   1403: dup
/*     */     //   1404: invokeinterface getMotionZ : ()D
/*     */     //   1409: ldc2_w 0.4
/*     */     //   1412: dmul
/*     */     //   1413: invokeinterface setMotionZ : (D)V
/*     */     //   1418: aload_2
/*     */     //   1419: dup
/*     */     //   1420: invokeinterface getMotionY : ()D
/*     */     //   1425: ldc_w 0.381145
/*     */     //   1428: f2d
/*     */     //   1429: dmul
/*     */     //   1430: invokeinterface setMotionY : (D)V
/*     */     //   1435: aload_2
/*     */     //   1436: dup
/*     */     //   1437: invokeinterface getMotionY : ()D
/*     */     //   1442: ldc_w 1.781145
/*     */     //   1445: f2d
/*     */     //   1446: ddiv
/*     */     //   1447: invokeinterface setMotionY : (D)V
/*     */     //   1452: goto -> 2166
/*     */     //   1455: aload_2
/*     */     //   1456: invokeinterface getHurtTime : ()I
/*     */     //   1461: ifle -> 2166
/*     */     //   1464: aload_2
/*     */     //   1465: invokeinterface isDead : ()Z
/*     */     //   1470: ifne -> 2166
/*     */     //   1473: aload_2
/*     */     //   1474: invokeinterface getOnGround : ()Z
/*     */     //   1479: ifne -> 2166
/*     */     //   1482: aload_2
/*     */     //   1483: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1486: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.MOVE_SPEED : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*     */     //   1489: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   1494: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*     */     //   1499: ifne -> 1579
/*     */     //   1502: aload_2
/*     */     //   1503: dup
/*     */     //   1504: invokeinterface getMotionX : ()D
/*     */     //   1509: ldc2_w 0.47188
/*     */     //   1512: dmul
/*     */     //   1513: invokeinterface setMotionX : (D)V
/*     */     //   1518: aload_2
/*     */     //   1519: dup
/*     */     //   1520: invokeinterface getMotionZ : ()D
/*     */     //   1525: ldc2_w 0.47188
/*     */     //   1528: dmul
/*     */     //   1529: invokeinterface setMotionZ : (D)V
/*     */     //   1534: aload_2
/*     */     //   1535: invokeinterface getMotionY : ()D
/*     */     //   1540: ldc2_w 0.42
/*     */     //   1543: dcmpg
/*     */     //   1544: ifeq -> 1560
/*     */     //   1547: aload_2
/*     */     //   1548: invokeinterface getMotionY : ()D
/*     */     //   1553: ldc2_w 0.42
/*     */     //   1556: dcmpl
/*     */     //   1557: ifle -> 2166
/*     */     //   1560: aload_2
/*     */     //   1561: dup
/*     */     //   1562: invokeinterface getMotionY : ()D
/*     */     //   1567: ldc2_w 0.4
/*     */     //   1570: dmul
/*     */     //   1571: invokeinterface setMotionY : (D)V
/*     */     //   1576: goto -> 2166
/*     */     //   1579: aload_2
/*     */     //   1580: dup
/*     */     //   1581: invokeinterface getMotionX : ()D
/*     */     //   1586: ldc2_w 0.65025
/*     */     //   1589: dmul
/*     */     //   1590: invokeinterface setMotionX : (D)V
/*     */     //   1595: aload_2
/*     */     //   1596: dup
/*     */     //   1597: invokeinterface getMotionZ : ()D
/*     */     //   1602: ldc2_w 0.65025
/*     */     //   1605: dmul
/*     */     //   1606: invokeinterface setMotionZ : (D)V
/*     */     //   1611: aload_2
/*     */     //   1612: invokeinterface getMotionY : ()D
/*     */     //   1617: ldc2_w 0.42
/*     */     //   1620: dcmpg
/*     */     //   1621: ifeq -> 1637
/*     */     //   1624: aload_2
/*     */     //   1625: invokeinterface getMotionY : ()D
/*     */     //   1630: ldc2_w 0.42
/*     */     //   1633: dcmpl
/*     */     //   1634: ifle -> 1653
/*     */     //   1637: aload_2
/*     */     //   1638: dup
/*     */     //   1639: invokeinterface getMotionY : ()D
/*     */     //   1644: ldc2_w 0.4
/*     */     //   1647: dmul
/*     */     //   1648: invokeinterface setMotionY : (D)V
/*     */     //   1653: goto -> 2166
/*     */     //   1656: aload_0
/*     */     //   1657: getfield jump : Z
/*     */     //   1660: ifeq -> 1680
/*     */     //   1663: aload_2
/*     */     //   1664: invokeinterface getOnGround : ()Z
/*     */     //   1669: ifeq -> 1784
/*     */     //   1672: aload_0
/*     */     //   1673: iconst_0
/*     */     //   1674: putfield jump : Z
/*     */     //   1677: goto -> 1784
/*     */     //   1680: aload_2
/*     */     //   1681: invokeinterface getHurtTime : ()I
/*     */     //   1686: ifle -> 1718
/*     */     //   1689: aload_2
/*     */     //   1690: invokeinterface getMotionX : ()D
/*     */     //   1695: dconst_0
/*     */     //   1696: dcmpg
/*     */     //   1697: ifeq -> 1718
/*     */     //   1700: aload_2
/*     */     //   1701: invokeinterface getMotionZ : ()D
/*     */     //   1706: dconst_0
/*     */     //   1707: dcmpg
/*     */     //   1708: ifeq -> 1718
/*     */     //   1711: aload_2
/*     */     //   1712: iconst_1
/*     */     //   1713: invokeinterface setOnGround : (Z)V
/*     */     //   1718: aload_2
/*     */     //   1719: invokeinterface getHurtResistantTime : ()I
/*     */     //   1724: ifle -> 1784
/*     */     //   1727: aload_0
/*     */     //   1728: getfield aacPushYReducerValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1731: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1734: checkcast java/lang/Boolean
/*     */     //   1737: invokevirtual booleanValue : ()Z
/*     */     //   1740: ifeq -> 1784
/*     */     //   1743: getstatic net/ccbluex/liquidbounce/Retreat.INSTANCE : Lnet/ccbluex/liquidbounce/Retreat;
/*     */     //   1746: invokevirtual getModuleManager : ()Lnet/ccbluex/liquidbounce/features/module/ModuleManager;
/*     */     //   1749: ldc_w net/ccbluex/liquidbounce/features/module/modules/movement/Speed
/*     */     //   1752: invokevirtual get : (Ljava/lang/Class;)Lnet/ccbluex/liquidbounce/features/module/Module;
/*     */     //   1755: dup
/*     */     //   1756: ifnonnull -> 1762
/*     */     //   1759: invokestatic throwNpe : ()V
/*     */     //   1762: invokevirtual getState : ()Z
/*     */     //   1765: ifne -> 1784
/*     */     //   1768: aload_2
/*     */     //   1769: dup
/*     */     //   1770: invokeinterface getMotionY : ()D
/*     */     //   1775: ldc2_w 0.014999993
/*     */     //   1778: dsub
/*     */     //   1779: invokeinterface setMotionY : (D)V
/*     */     //   1784: aload_2
/*     */     //   1785: invokeinterface getHurtResistantTime : ()I
/*     */     //   1790: bipush #19
/*     */     //   1792: if_icmplt -> 2166
/*     */     //   1795: aload_0
/*     */     //   1796: getfield aacPushXZReducerValue : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1799: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1802: checkcast java/lang/Number
/*     */     //   1805: invokevirtual floatValue : ()F
/*     */     //   1808: fstore #4
/*     */     //   1810: aload_2
/*     */     //   1811: dup
/*     */     //   1812: invokeinterface getMotionX : ()D
/*     */     //   1817: fload #4
/*     */     //   1819: f2d
/*     */     //   1820: ddiv
/*     */     //   1821: invokeinterface setMotionX : (D)V
/*     */     //   1826: aload_2
/*     */     //   1827: dup
/*     */     //   1828: invokeinterface getMotionZ : ()D
/*     */     //   1833: fload #4
/*     */     //   1835: f2d
/*     */     //   1836: ddiv
/*     */     //   1837: invokeinterface setMotionZ : (D)V
/*     */     //   1842: goto -> 2166
/*     */     //   1845: aload_2
/*     */     //   1846: invokeinterface getHurtTime : ()I
/*     */     //   1851: ifle -> 2166
/*     */     //   1854: aload_2
/*     */     //   1855: invokeinterface isDead : ()Z
/*     */     //   1860: ifne -> 2166
/*     */     //   1863: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1866: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1871: dup
/*     */     //   1872: ifnonnull -> 1878
/*     */     //   1875: invokestatic throwNpe : ()V
/*     */     //   1878: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   1881: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.MOVE_SPEED : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*     */     //   1884: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   1889: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*     */     //   1894: ifne -> 2166
/*     */     //   1897: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   1900: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   1905: dup
/*     */     //   1906: ifnonnull -> 1912
/*     */     //   1909: invokestatic throwNpe : ()V
/*     */     //   1912: invokeinterface isInWater : ()Z
/*     */     //   1917: ifne -> 2166
/*     */     //   1920: aload_2
/*     */     //   1921: dup
/*     */     //   1922: invokeinterface getMotionX : ()D
/*     */     //   1927: aload_0
/*     */     //   1928: getfield customX : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1931: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1934: checkcast java/lang/Number
/*     */     //   1937: invokevirtual doubleValue : ()D
/*     */     //   1940: dmul
/*     */     //   1941: invokeinterface setMotionX : (D)V
/*     */     //   1946: aload_2
/*     */     //   1947: dup
/*     */     //   1948: invokeinterface getMotionZ : ()D
/*     */     //   1953: aload_0
/*     */     //   1954: getfield customZ : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1957: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1960: checkcast java/lang/Number
/*     */     //   1963: invokevirtual doubleValue : ()D
/*     */     //   1966: dmul
/*     */     //   1967: invokeinterface setMotionZ : (D)V
/*     */     //   1972: aload_0
/*     */     //   1973: getfield customYStart : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1976: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1979: checkcast java/lang/Boolean
/*     */     //   1982: invokevirtual booleanValue : ()Z
/*     */     //   1985: ifeq -> 2014
/*     */     //   1988: aload_2
/*     */     //   1989: dup
/*     */     //   1990: invokeinterface getMotionY : ()D
/*     */     //   1995: aload_0
/*     */     //   1996: getfield customY : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1999: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2002: checkcast java/lang/Number
/*     */     //   2005: invokevirtual doubleValue : ()D
/*     */     //   2008: ddiv
/*     */     //   2009: invokeinterface setMotionY : (D)V
/*     */     //   2014: aload_0
/*     */     //   2015: getfield customC06FakeLag : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   2018: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   2021: checkcast java/lang/Boolean
/*     */     //   2024: invokevirtual booleanValue : ()Z
/*     */     //   2027: ifeq -> 2166
/*     */     //   2030: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   2033: invokeinterface getNetHandler : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/network/IINetHandlerPlayClient;
/*     */     //   2038: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   2041: aload_2
/*     */     //   2042: invokeinterface getPosX : ()D
/*     */     //   2047: aload_2
/*     */     //   2048: invokeinterface getPosY : ()D
/*     */     //   2053: aload_2
/*     */     //   2054: invokeinterface getPosZ : ()D
/*     */     //   2059: aload_2
/*     */     //   2060: invokeinterface getRotationYaw : ()F
/*     */     //   2065: aload_2
/*     */     //   2066: invokeinterface getRotationPitch : ()F
/*     */     //   2071: aload_2
/*     */     //   2072: invokeinterface getOnGround : ()Z
/*     */     //   2077: invokeinterface createCPacketPlayerPosLook : (DDDFFZ)Lnet/ccbluex/liquidbounce/api/minecraft/network/play/client/ICPacketPlayerPosLook;
/*     */     //   2082: checkcast net/ccbluex/liquidbounce/api/minecraft/network/IPacket
/*     */     //   2085: invokeinterface addToSendQueue : (Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;)V
/*     */     //   2090: goto -> 2166
/*     */     //   2093: aload_2
/*     */     //   2094: invokeinterface getHurtTime : ()I
/*     */     //   2099: ifle -> 2161
/*     */     //   2102: aload_0
/*     */     //   2103: getfield velocityInput : Z
/*     */     //   2106: ifeq -> 2129
/*     */     //   2109: aload_2
/*     */     //   2110: invokeinterface getOnGround : ()Z
/*     */     //   2115: ifne -> 2129
/*     */     //   2118: aload_2
/*     */     //   2119: invokeinterface getFallDistance : ()F
/*     */     //   2124: fconst_2
/*     */     //   2125: fcmpl
/*     */     //   2126: ifle -> 2130
/*     */     //   2129: return
/*     */     //   2130: aload_2
/*     */     //   2131: dup
/*     */     //   2132: invokeinterface getMotionY : ()D
/*     */     //   2137: dconst_1
/*     */     //   2138: dsub
/*     */     //   2139: invokeinterface setMotionY : (D)V
/*     */     //   2144: aload_2
/*     */     //   2145: iconst_1
/*     */     //   2146: invokeinterface setAirBorne : (Z)V
/*     */     //   2151: aload_2
/*     */     //   2152: iconst_1
/*     */     //   2153: invokeinterface setOnGround : (Z)V
/*     */     //   2158: goto -> 2166
/*     */     //   2161: aload_0
/*     */     //   2162: iconst_0
/*     */     //   2163: putfield velocityInput : Z
/*     */     //   2166: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #125	-> 6
/*     */     //   #125	-> 21
/*     */     //   #127	-> 24
/*     */     //   #128	-> 51
/*     */     //   #129	-> 52
/*     */     //   #130	-> 179
/*     */     //   #230	-> 352
/*     */     //   #310	-> 364
/*     */     //   #287	-> 376
/*     */     //   #180	-> 388
/*     */     //   #247	-> 400
/*     */     //   #203	-> 412
/*     */     //   #148	-> 424
/*     */     //   #261	-> 436
/*     */     //   #237	-> 448
/*     */     //   #140	-> 460
/*     */     //   #167	-> 472
/*     */     //   #190	-> 484
/*     */     //   #131	-> 496
/*     */     //   #157	-> 508
/*     */     //   #212	-> 520
/*     */     //   #131	-> 532
/*     */     //   #132	-> 541
/*     */     //   #134	-> 550
/*     */     //   #136	-> 562
/*     */     //   #136	-> 592
/*     */     //   #137	-> 602
/*     */     //   #137	-> 632
/*     */     //   #140	-> 645
/*     */     //   #141	-> 654
/*     */     //   #142	-> 670
/*     */     //   #143	-> 686
/*     */     //   #145	-> 702
/*     */     //   #149	-> 721
/*     */     //   #151	-> 731
/*     */     //   #152	-> 742
/*     */     //   #154	-> 751
/*     */     //   #158	-> 759
/*     */     //   #159	-> 776
/*     */     //   #160	-> 792
/*     */     //   #162	-> 808
/*     */     //   #163	-> 847
/*     */     //   #168	-> 855
/*     */     //   #169	-> 875
/*     */     //   #170	-> 894
/*     */     //   #171	-> 901
/*     */     //   #172	-> 908
/*     */     //   #173	-> 917
/*     */     //   #175	-> 922
/*     */     //   #176	-> 930
/*     */     //   #181	-> 938
/*     */     //   #182	-> 945
/*     */     //   #184	-> 946
/*     */     //   #185	-> 955
/*     */     //   #186	-> 981
/*     */     //   #187	-> 994
/*     */     //   #191	-> 1002
/*     */     //   #192	-> 1011
/*     */     //   #193	-> 1018
/*     */     //   #194	-> 1026
/*     */     //   #195	-> 1042
/*     */     //   #197	-> 1061
/*     */     //   #198	-> 1074
/*     */     //   #199	-> 1079
/*     */     //   #200	-> 1087
/*     */     //   #204	-> 1090
/*     */     //   #205	-> 1108
/*     */     //   #206	-> 1123
/*     */     //   #207	-> 1139
/*     */     //   #213	-> 1158
/*     */     //   #214	-> 1165
/*     */     //   #215	-> 1173
/*     */     //   #218	-> 1174
/*     */     //   #219	-> 1183
/*     */     //   #221	-> 1188
/*     */     //   #222	-> 1197
/*     */     //   #223	-> 1204
/*     */     //   #224	-> 1226
/*     */     //   #225	-> 1239
/*     */     //   #226	-> 1244
/*     */     //   #227	-> 1249
/*     */     //   #230	-> 1252
/*     */     //   #231	-> 1272
/*     */     //   #232	-> 1298
/*     */     //   #233	-> 1324
/*     */     //   #234	-> 1350
/*     */     //   #238	-> 1358
/*     */     //   #239	-> 1386
/*     */     //   #240	-> 1402
/*     */     //   #241	-> 1418
/*     */     //   #242	-> 1435
/*     */     //   #248	-> 1455
/*     */     //   #249	-> 1482
/*     */     //   #250	-> 1502
/*     */     //   #251	-> 1518
/*     */     //   #252	-> 1534
/*     */     //   #254	-> 1579
/*     */     //   #255	-> 1595
/*     */     //   #256	-> 1611
/*     */     //   #257	-> 1653
/*     */     //   #262	-> 1656
/*     */     //   #263	-> 1663
/*     */     //   #264	-> 1672
/*     */     //   #267	-> 1680
/*     */     //   #268	-> 1711
/*     */     //   #271	-> 1718
/*     */     //   #272	-> 1718
/*     */     //   #271	-> 1727
/*     */     //   #272	-> 1743
/*     */     //   #274	-> 1768
/*     */     //   #275	-> 1784
/*     */     //   #279	-> 1784
/*     */     //   #280	-> 1795
/*     */     //   #282	-> 1810
/*     */     //   #283	-> 1826
/*     */     //   #288	-> 1845
/*     */     //   #292	-> 1845
/*     */     //   #288	-> 1863
/*     */     //   #289	-> 1878
/*     */     //   #290	-> 1881
/*     */     //   #289	-> 1884
/*     */     //   #288	-> 1889
/*     */     //   #294	-> 1920
/*     */     //   #295	-> 1946
/*     */     //   #296	-> 1972
/*     */     //   #297	-> 2014
/*     */     //   #298	-> 2038
/*     */     //   #299	-> 2041
/*     */     //   #300	-> 2047
/*     */     //   #301	-> 2053
/*     */     //   #302	-> 2059
/*     */     //   #303	-> 2065
/*     */     //   #304	-> 2071
/*     */     //   #298	-> 2077
/*     */     //   #297	-> 2085
/*     */     //   #310	-> 2093
/*     */     //   #311	-> 2102
/*     */     //   #312	-> 2129
/*     */     //   #314	-> 2130
/*     */     //   #315	-> 2144
/*     */     //   #316	-> 2151
/*     */     //   #318	-> 2161
/*     */     //   #319	-> 2166
/*     */     //   #322	-> 2166
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   562	80	4	yaw	F
/*     */     //   1123	32	4	reduce	F
/*     */     //   1810	32	4	reduce	F
/*     */     //   24	2143	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	2167	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Velocity;
/*     */     //   0	2167	1	event	Lnet/ccbluex/liquidbounce/event/UpdateEvent;
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
/*     */   @EventTarget
/*     */   public final void onBlockBB(@NotNull BlockBBEvent event) {
/* 326 */     Intrinsics.checkParameterIsNotNull(event, "event"); this.block = event.getBlock();
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
/*     */   @EventTarget
/*     */   public final void onPacket(@NotNull PacketEvent event) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 'event'
/*     */     //   3: invokestatic checkParameterIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   9: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   14: dup
/*     */     //   15: ifnull -> 21
/*     */     //   18: goto -> 23
/*     */     //   21: pop
/*     */     //   22: return
/*     */     //   23: astore_2
/*     */     //   24: aload_1
/*     */     //   25: invokevirtual getPacket : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   28: astore_3
/*     */     //   29: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   32: aload_3
/*     */     //   33: invokeinterface isSPacketEntityVelocity : (Ljava/lang/Object;)Z
/*     */     //   38: ifeq -> 1486
/*     */     //   41: aload_3
/*     */     //   42: invokeinterface asSPacketEntityVelocity : ()Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   47: astore #4
/*     */     //   49: aload_2
/*     */     //   50: invokeinterface isDead : ()Z
/*     */     //   55: ifne -> 175
/*     */     //   58: aload_0
/*     */     //   59: getfield noFireValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   62: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   65: checkcast java/lang/Boolean
/*     */     //   68: invokevirtual booleanValue : ()Z
/*     */     //   71: ifeq -> 97
/*     */     //   74: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   77: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   82: dup
/*     */     //   83: ifnonnull -> 89
/*     */     //   86: invokestatic throwNpe : ()V
/*     */     //   89: invokeinterface isBurning : ()Z
/*     */     //   94: ifne -> 175
/*     */     //   97: aload_0
/*     */     //   98: getfield cobwebValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   101: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   104: checkcast java/lang/Boolean
/*     */     //   107: invokevirtual booleanValue : ()Z
/*     */     //   110: ifeq -> 136
/*     */     //   113: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   116: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   121: dup
/*     */     //   122: ifnonnull -> 128
/*     */     //   125: invokestatic throwNpe : ()V
/*     */     //   128: invokeinterface isInWeb : ()Z
/*     */     //   133: ifne -> 175
/*     */     //   136: aload_0
/*     */     //   137: getfield onlyGroundValue : Lnet/ccbluex/liquidbounce/value/BoolValue;
/*     */     //   140: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   143: checkcast java/lang/Boolean
/*     */     //   146: invokevirtual booleanValue : ()Z
/*     */     //   149: ifeq -> 176
/*     */     //   152: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   155: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   160: dup
/*     */     //   161: ifnonnull -> 167
/*     */     //   164: invokestatic throwNpe : ()V
/*     */     //   167: invokeinterface getOnGround : ()Z
/*     */     //   172: ifne -> 176
/*     */     //   175: return
/*     */     //   176: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   179: invokeinterface getTheWorld : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/multiplayer/IWorldClient;
/*     */     //   184: dup
/*     */     //   185: ifnull -> 207
/*     */     //   188: aload #4
/*     */     //   190: invokeinterface getEntityID : ()I
/*     */     //   195: invokeinterface getEntityByID : (I)Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntity;
/*     */     //   200: dup
/*     */     //   201: ifnull -> 207
/*     */     //   204: goto -> 209
/*     */     //   207: pop
/*     */     //   208: return
/*     */     //   209: aload_2
/*     */     //   210: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   213: iconst_1
/*     */     //   214: ixor
/*     */     //   215: ifeq -> 219
/*     */     //   218: return
/*     */     //   219: aload_0
/*     */     //   220: getfield velocityTimer : Lnet/ccbluex/liquidbounce/utils/timer/MSTimer;
/*     */     //   223: invokevirtual reset : ()V
/*     */     //   226: aload_0
/*     */     //   227: getfield modeValue : Lnet/ccbluex/liquidbounce/value/ListValue;
/*     */     //   230: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   233: checkcast java/lang/String
/*     */     //   236: astore #5
/*     */     //   238: iconst_0
/*     */     //   239: istore #6
/*     */     //   241: aload #5
/*     */     //   243: dup
/*     */     //   244: ifnonnull -> 257
/*     */     //   247: new kotlin/TypeCastException
/*     */     //   250: dup
/*     */     //   251: ldc 'null cannot be cast to non-null type java.lang.String'
/*     */     //   253: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   256: athrow
/*     */     //   257: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   260: dup
/*     */     //   261: ldc '(this as java.lang.String).toLowerCase()'
/*     */     //   263: invokestatic checkExpressionValueIsNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   266: astore #5
/*     */     //   268: aload #5
/*     */     //   270: invokevirtual hashCode : ()I
/*     */     //   273: lookupswitch default -> 1486, -1970553484 -> 602, -1657634710 -> 534, -1513652168 -> 615, -1243181771 -> 521, -1234264725 -> 425, -902286926 -> 438, -767500465 -> 507, 96323 -> 412, 112120 -> 548, 2986065 -> 575, 233102203 -> 588, 874251766 -> 452, 874251767 -> 466, 1099846370 -> 480, 1385914517 -> 493, 1385917856 -> 562
/*     */     //   412: aload #5
/*     */     //   414: ldc 'aac'
/*     */     //   416: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   419: ifeq -> 1486
/*     */     //   422: goto -> 1447
/*     */     //   425: aload #5
/*     */     //   427: ldc 'aaczero'
/*     */     //   429: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   432: ifeq -> 1486
/*     */     //   435: goto -> 1447
/*     */     //   438: aload #5
/*     */     //   440: ldc_w 'simple'
/*     */     //   443: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   446: ifeq -> 1486
/*     */     //   449: goto -> 741
/*     */     //   452: aload #5
/*     */     //   454: ldc_w 'hytpacketa'
/*     */     //   457: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   460: ifeq -> 1486
/*     */     //   463: goto -> 1251
/*     */     //   466: aload #5
/*     */     //   468: ldc_w 'hytpacketb'
/*     */     //   471: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   474: ifeq -> 1486
/*     */     //   477: goto -> 1339
/*     */     //   480: aload #5
/*     */     //   482: ldc 'reverse'
/*     */     //   484: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   487: ifeq -> 1486
/*     */     //   490: goto -> 1447
/*     */     //   493: aload #5
/*     */     //   495: ldc_w 'hyttest'
/*     */     //   498: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   501: ifeq -> 1486
/*     */     //   504: goto -> 1020
/*     */     //   507: aload #5
/*     */     //   509: ldc_w 'hytnewtest'
/*     */     //   512: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   515: ifeq -> 1486
/*     */     //   518: goto -> 1102
/*     */     //   521: aload #5
/*     */     //   523: ldc 'glitch'
/*     */     //   525: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   528: ifeq -> 1486
/*     */     //   531: goto -> 1467
/*     */     //   534: aload #5
/*     */     //   536: ldc_w 'hytpacketfix'
/*     */     //   539: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   542: ifeq -> 1486
/*     */     //   545: goto -> 849
/*     */     //   548: aload #5
/*     */     //   550: ldc_w 's27'
/*     */     //   553: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   556: ifeq -> 1486
/*     */     //   559: goto -> 635
/*     */     //   562: aload #5
/*     */     //   564: ldc 'hyttick'
/*     */     //   566: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   569: ifeq -> 1486
/*     */     //   572: goto -> 1455
/*     */     //   575: aload #5
/*     */     //   577: ldc 'aac4'
/*     */     //   579: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   582: ifeq -> 1486
/*     */     //   585: goto -> 1447
/*     */     //   588: aload #5
/*     */     //   590: ldc_w 'vanilla'
/*     */     //   593: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   596: ifeq -> 1486
/*     */     //   599: goto -> 628
/*     */     //   602: aload #5
/*     */     //   604: ldc 'smoothreverse'
/*     */     //   606: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   609: ifeq -> 1486
/*     */     //   612: goto -> 1447
/*     */     //   615: aload #5
/*     */     //   617: ldc 'aac5reduce'
/*     */     //   619: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   622: ifeq -> 1486
/*     */     //   625: goto -> 1447
/*     */     //   628: aload_1
/*     */     //   629: invokevirtual cancelEvent : ()V
/*     */     //   632: goto -> 1486
/*     */     //   635: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   638: aload_3
/*     */     //   639: invokeinterface isSPacketExplosion : (Ljava/lang/Object;)Z
/*     */     //   644: ifeq -> 651
/*     */     //   647: aload_1
/*     */     //   648: invokevirtual cancelEvent : ()V
/*     */     //   651: aload_0
/*     */     //   652: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   655: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   658: checkcast java/lang/Number
/*     */     //   661: invokevirtual floatValue : ()F
/*     */     //   664: fstore #6
/*     */     //   666: aload_0
/*     */     //   667: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   670: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   673: checkcast java/lang/Number
/*     */     //   676: invokevirtual floatValue : ()F
/*     */     //   679: fstore #7
/*     */     //   681: aload #4
/*     */     //   683: aload #4
/*     */     //   685: invokeinterface getMotionX : ()I
/*     */     //   690: i2f
/*     */     //   691: fload #6
/*     */     //   693: fmul
/*     */     //   694: f2i
/*     */     //   695: invokeinterface setMotionX : (I)V
/*     */     //   700: aload #4
/*     */     //   702: aload #4
/*     */     //   704: invokeinterface getMotionY : ()I
/*     */     //   709: i2f
/*     */     //   710: fload #7
/*     */     //   712: fmul
/*     */     //   713: f2i
/*     */     //   714: invokeinterface setMotionY : (I)V
/*     */     //   719: aload #4
/*     */     //   721: aload #4
/*     */     //   723: invokeinterface getMotionZ : ()I
/*     */     //   728: i2f
/*     */     //   729: fload #6
/*     */     //   731: fmul
/*     */     //   732: f2i
/*     */     //   733: invokeinterface setMotionZ : (I)V
/*     */     //   738: goto -> 1486
/*     */     //   741: aload_0
/*     */     //   742: getfield horizontalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   745: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   748: checkcast java/lang/Number
/*     */     //   751: invokevirtual floatValue : ()F
/*     */     //   754: fstore #6
/*     */     //   756: aload_0
/*     */     //   757: getfield verticalValue : Lnet/ccbluex/liquidbounce/value/FloatValue;
/*     */     //   760: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   763: checkcast java/lang/Number
/*     */     //   766: invokevirtual floatValue : ()F
/*     */     //   769: fstore #7
/*     */     //   771: fload #6
/*     */     //   773: fconst_0
/*     */     //   774: fcmpg
/*     */     //   775: ifne -> 789
/*     */     //   778: fload #7
/*     */     //   780: fconst_0
/*     */     //   781: fcmpg
/*     */     //   782: ifne -> 789
/*     */     //   785: aload_1
/*     */     //   786: invokevirtual cancelEvent : ()V
/*     */     //   789: aload #4
/*     */     //   791: aload #4
/*     */     //   793: invokeinterface getMotionX : ()I
/*     */     //   798: i2f
/*     */     //   799: fload #6
/*     */     //   801: fmul
/*     */     //   802: f2i
/*     */     //   803: invokeinterface setMotionX : (I)V
/*     */     //   808: aload #4
/*     */     //   810: aload #4
/*     */     //   812: invokeinterface getMotionY : ()I
/*     */     //   817: i2f
/*     */     //   818: fload #7
/*     */     //   820: fmul
/*     */     //   821: f2i
/*     */     //   822: invokeinterface setMotionY : (I)V
/*     */     //   827: aload #4
/*     */     //   829: aload #4
/*     */     //   831: invokeinterface getMotionZ : ()I
/*     */     //   836: i2f
/*     */     //   837: fload #6
/*     */     //   839: fmul
/*     */     //   840: f2i
/*     */     //   841: invokeinterface setMotionZ : (I)V
/*     */     //   846: goto -> 1486
/*     */     //   849: aload_2
/*     */     //   850: invokeinterface getHurtTime : ()I
/*     */     //   855: ifle -> 973
/*     */     //   858: aload_2
/*     */     //   859: invokeinterface isDead : ()Z
/*     */     //   864: ifne -> 973
/*     */     //   867: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   870: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   875: dup
/*     */     //   876: ifnonnull -> 882
/*     */     //   879: invokestatic throwNpe : ()V
/*     */     //   882: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.classProvider : Lnet/ccbluex/liquidbounce/api/IClassProvider;
/*     */     //   885: getstatic net/ccbluex/liquidbounce/api/minecraft/potion/PotionType.MOVE_SPEED : Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;
/*     */     //   888: invokeinterface getPotionEnum : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/PotionType;)Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;
/*     */     //   893: invokeinterface isPotionActive : (Lnet/ccbluex/liquidbounce/api/minecraft/potion/IPotion;)Z
/*     */     //   898: ifne -> 973
/*     */     //   901: getstatic net/ccbluex/liquidbounce/utils/MinecraftInstance.mc : Lnet/ccbluex/liquidbounce/api/minecraft/client/IMinecraft;
/*     */     //   904: invokeinterface getThePlayer : ()Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   909: dup
/*     */     //   910: ifnonnull -> 916
/*     */     //   913: invokestatic throwNpe : ()V
/*     */     //   916: invokeinterface isInWater : ()Z
/*     */     //   921: ifne -> 973
/*     */     //   924: aload_2
/*     */     //   925: dup
/*     */     //   926: invokeinterface getMotionX : ()D
/*     */     //   931: ldc2_w 0.4
/*     */     //   934: dmul
/*     */     //   935: invokeinterface setMotionX : (D)V
/*     */     //   940: aload_2
/*     */     //   941: dup
/*     */     //   942: invokeinterface getMotionZ : ()D
/*     */     //   947: ldc2_w 0.4
/*     */     //   950: dmul
/*     */     //   951: invokeinterface setMotionZ : (D)V
/*     */     //   956: aload_2
/*     */     //   957: dup
/*     */     //   958: invokeinterface getMotionY : ()D
/*     */     //   963: ldc_w 1.45
/*     */     //   966: f2d
/*     */     //   967: ddiv
/*     */     //   968: invokeinterface setMotionY : (D)V
/*     */     //   973: aload_2
/*     */     //   974: invokeinterface getHurtTime : ()I
/*     */     //   979: iconst_1
/*     */     //   980: if_icmpge -> 991
/*     */     //   983: aload #4
/*     */     //   985: iconst_0
/*     */     //   986: invokeinterface setMotionY : (I)V
/*     */     //   991: aload_2
/*     */     //   992: invokeinterface getHurtTime : ()I
/*     */     //   997: iconst_5
/*     */     //   998: if_icmpge -> 1486
/*     */     //   1001: aload #4
/*     */     //   1003: iconst_0
/*     */     //   1004: invokeinterface setMotionX : (I)V
/*     */     //   1009: aload #4
/*     */     //   1011: iconst_0
/*     */     //   1012: invokeinterface setMotionZ : (I)V
/*     */     //   1017: goto -> 1486
/*     */     //   1020: aload_2
/*     */     //   1021: invokeinterface getOnGround : ()Z
/*     */     //   1026: ifeq -> 1486
/*     */     //   1029: aload_0
/*     */     //   1030: iconst_0
/*     */     //   1031: putfield canCancelJump : Z
/*     */     //   1034: aload #4
/*     */     //   1036: ldc2_w 0.985114
/*     */     //   1039: d2i
/*     */     //   1040: invokeinterface setMotionX : (I)V
/*     */     //   1045: aload #4
/*     */     //   1047: ldc2_w 0.885113
/*     */     //   1050: d2i
/*     */     //   1051: invokeinterface setMotionY : (I)V
/*     */     //   1056: aload #4
/*     */     //   1058: ldc2_w 0.785112
/*     */     //   1061: d2i
/*     */     //   1062: invokeinterface setMotionZ : (I)V
/*     */     //   1067: aload_2
/*     */     //   1068: dup
/*     */     //   1069: invokeinterface getMotionX : ()D
/*     */     //   1074: ldc2_w 1.75
/*     */     //   1077: ddiv
/*     */     //   1078: invokeinterface setMotionX : (D)V
/*     */     //   1083: aload_2
/*     */     //   1084: dup
/*     */     //   1085: invokeinterface getMotionZ : ()D
/*     */     //   1090: ldc2_w 1.75
/*     */     //   1093: ddiv
/*     */     //   1094: invokeinterface setMotionZ : (D)V
/*     */     //   1099: goto -> 1486
/*     */     //   1102: aload_2
/*     */     //   1103: invokeinterface getOnGround : ()Z
/*     */     //   1108: ifeq -> 1486
/*     */     //   1111: aload_0
/*     */     //   1112: iconst_1
/*     */     //   1113: putfield velocityInput : Z
/*     */     //   1116: aload_2
/*     */     //   1117: invokeinterface getRotationYaw : ()F
/*     */     //   1122: ldc_w 0.017453292
/*     */     //   1125: fmul
/*     */     //   1126: fstore #6
/*     */     //   1128: aload #4
/*     */     //   1130: aload #4
/*     */     //   1132: invokeinterface getMotionX : ()I
/*     */     //   1137: i2d
/*     */     //   1138: ldc2_w 0.75
/*     */     //   1141: dmul
/*     */     //   1142: d2i
/*     */     //   1143: invokeinterface setMotionX : (I)V
/*     */     //   1148: aload #4
/*     */     //   1150: aload #4
/*     */     //   1152: invokeinterface getMotionZ : ()I
/*     */     //   1157: i2d
/*     */     //   1158: ldc2_w 0.75
/*     */     //   1161: dmul
/*     */     //   1162: d2i
/*     */     //   1163: invokeinterface setMotionZ : (I)V
/*     */     //   1168: aload_2
/*     */     //   1169: dup
/*     */     //   1170: invokeinterface getMotionX : ()D
/*     */     //   1175: dstore #9
/*     */     //   1177: astore #8
/*     */     //   1179: iconst_0
/*     */     //   1180: istore #7
/*     */     //   1182: fload #6
/*     */     //   1184: f2d
/*     */     //   1185: invokestatic sin : (D)D
/*     */     //   1188: d2f
/*     */     //   1189: fstore #11
/*     */     //   1191: aload #8
/*     */     //   1193: dload #9
/*     */     //   1195: fload #11
/*     */     //   1197: f2d
/*     */     //   1198: ldc2_w 0.2
/*     */     //   1201: dmul
/*     */     //   1202: dsub
/*     */     //   1203: invokeinterface setMotionX : (D)V
/*     */     //   1208: aload_2
/*     */     //   1209: dup
/*     */     //   1210: invokeinterface getMotionZ : ()D
/*     */     //   1215: dstore #9
/*     */     //   1217: astore #8
/*     */     //   1219: iconst_0
/*     */     //   1220: istore #7
/*     */     //   1222: fload #6
/*     */     //   1224: f2d
/*     */     //   1225: invokestatic cos : (D)D
/*     */     //   1228: d2f
/*     */     //   1229: fstore #11
/*     */     //   1231: aload #8
/*     */     //   1233: dload #9
/*     */     //   1235: fload #11
/*     */     //   1237: f2d
/*     */     //   1238: ldc2_w 0.2
/*     */     //   1241: dmul
/*     */     //   1242: dadd
/*     */     //   1243: invokeinterface setMotionZ : (D)V
/*     */     //   1248: goto -> 1486
/*     */     //   1251: aload #4
/*     */     //   1253: aload #4
/*     */     //   1255: invokeinterface getMotionX : ()I
/*     */     //   1260: i2f
/*     */     //   1261: aload_0
/*     */     //   1262: getfield hytpacketaset : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1265: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1268: checkcast java/lang/Number
/*     */     //   1271: invokevirtual floatValue : ()F
/*     */     //   1274: fmul
/*     */     //   1275: f2d
/*     */     //   1276: ldc2_w 1.5
/*     */     //   1279: ddiv
/*     */     //   1280: d2i
/*     */     //   1281: invokeinterface setMotionX : (I)V
/*     */     //   1286: aload #4
/*     */     //   1288: ldc2_w 0.7
/*     */     //   1291: d2i
/*     */     //   1292: invokeinterface setMotionY : (I)V
/*     */     //   1297: aload #4
/*     */     //   1299: aload #4
/*     */     //   1301: invokeinterface getMotionZ : ()I
/*     */     //   1306: i2f
/*     */     //   1307: aload_0
/*     */     //   1308: getfield hytpacketaset : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1311: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1314: checkcast java/lang/Number
/*     */     //   1317: invokevirtual floatValue : ()F
/*     */     //   1320: fmul
/*     */     //   1321: f2d
/*     */     //   1322: ldc2_w 1.5
/*     */     //   1325: ddiv
/*     */     //   1326: d2i
/*     */     //   1327: invokeinterface setMotionZ : (I)V
/*     */     //   1332: aload_1
/*     */     //   1333: invokevirtual cancelEvent : ()V
/*     */     //   1336: goto -> 1486
/*     */     //   1339: aload #4
/*     */     //   1341: aload #4
/*     */     //   1343: invokeinterface getMotionX : ()I
/*     */     //   1348: i2f
/*     */     //   1349: aload_0
/*     */     //   1350: getfield hytpacketbset : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1353: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1356: checkcast java/lang/Number
/*     */     //   1359: invokevirtual floatValue : ()F
/*     */     //   1362: fmul
/*     */     //   1363: f2d
/*     */     //   1364: ldc2_w 2.5
/*     */     //   1367: ddiv
/*     */     //   1368: d2i
/*     */     //   1369: invokeinterface setMotionX : (I)V
/*     */     //   1374: aload #4
/*     */     //   1376: aload #4
/*     */     //   1378: invokeinterface getMotionY : ()I
/*     */     //   1383: i2f
/*     */     //   1384: aload_0
/*     */     //   1385: getfield hytpacketbset : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1388: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1391: checkcast java/lang/Number
/*     */     //   1394: invokevirtual floatValue : ()F
/*     */     //   1397: fmul
/*     */     //   1398: f2d
/*     */     //   1399: ldc2_w 2.5
/*     */     //   1402: ddiv
/*     */     //   1403: d2i
/*     */     //   1404: invokeinterface setMotionY : (I)V
/*     */     //   1409: aload #4
/*     */     //   1411: aload #4
/*     */     //   1413: invokeinterface getMotionZ : ()I
/*     */     //   1418: i2f
/*     */     //   1419: aload_0
/*     */     //   1420: getfield hytpacketbset : Lnet/ccbluex/liquidbounce/value/Value;
/*     */     //   1423: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   1426: checkcast java/lang/Number
/*     */     //   1429: invokevirtual floatValue : ()F
/*     */     //   1432: fmul
/*     */     //   1433: f2d
/*     */     //   1434: ldc2_w 2.5
/*     */     //   1437: ddiv
/*     */     //   1438: d2i
/*     */     //   1439: invokeinterface setMotionZ : (I)V
/*     */     //   1444: goto -> 1486
/*     */     //   1447: aload_0
/*     */     //   1448: iconst_1
/*     */     //   1449: putfield velocityInput : Z
/*     */     //   1452: goto -> 1486
/*     */     //   1455: aload_0
/*     */     //   1456: iconst_1
/*     */     //   1457: putfield velocityInput : Z
/*     */     //   1460: aload_1
/*     */     //   1461: invokevirtual cancelEvent : ()V
/*     */     //   1464: goto -> 1486
/*     */     //   1467: aload_2
/*     */     //   1468: invokeinterface getOnGround : ()Z
/*     */     //   1473: ifne -> 1477
/*     */     //   1476: return
/*     */     //   1477: aload_0
/*     */     //   1478: iconst_1
/*     */     //   1479: putfield velocityInput : Z
/*     */     //   1482: aload_1
/*     */     //   1483: invokevirtual cancelEvent : ()V
/*     */     //   1486: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #331	-> 6
/*     */     //   #331	-> 21
/*     */     //   #333	-> 24
/*     */     //   #335	-> 29
/*     */     //   #336	-> 41
/*     */     //   #339	-> 49
/*     */     //   #340	-> 176
/*     */     //   #340	-> 207
/*     */     //   #341	-> 218
/*     */     //   #343	-> 219
/*     */     //   #345	-> 226
/*     */     //   #434	-> 412
/*     */     //   #361	-> 438
/*     */     //   #415	-> 452
/*     */     //   #424	-> 466
/*     */     //   #434	-> 480
/*     */     //   #393	-> 493
/*     */     //   #404	-> 507
/*     */     //   #442	-> 521
/*     */     //   #373	-> 534
/*     */     //   #350	-> 548
/*     */     //   #436	-> 562
/*     */     //   #434	-> 575
/*     */     //   #346	-> 588
/*     */     //   #434	-> 602
/*     */     //   #347	-> 628
/*     */     //   #351	-> 635
/*     */     //   #352	-> 647
/*     */     //   #354	-> 651
/*     */     //   #355	-> 666
/*     */     //   #356	-> 681
/*     */     //   #357	-> 700
/*     */     //   #358	-> 719
/*     */     //   #362	-> 741
/*     */     //   #363	-> 756
/*     */     //   #365	-> 771
/*     */     //   #366	-> 785
/*     */     //   #368	-> 789
/*     */     //   #369	-> 808
/*     */     //   #370	-> 827
/*     */     //   #374	-> 849
/*     */     //   #378	-> 849
/*     */     //   #374	-> 867
/*     */     //   #375	-> 882
/*     */     //   #376	-> 885
/*     */     //   #375	-> 888
/*     */     //   #374	-> 893
/*     */     //   #380	-> 924
/*     */     //   #381	-> 940
/*     */     //   #382	-> 956
/*     */     //   #384	-> 973
/*     */     //   #385	-> 983
/*     */     //   #387	-> 991
/*     */     //   #388	-> 1001
/*     */     //   #389	-> 1009
/*     */     //   #394	-> 1020
/*     */     //   #395	-> 1029
/*     */     //   #396	-> 1034
/*     */     //   #397	-> 1045
/*     */     //   #398	-> 1056
/*     */     //   #399	-> 1067
/*     */     //   #400	-> 1083
/*     */     //   #405	-> 1102
/*     */     //   #406	-> 1111
/*     */     //   #407	-> 1116
/*     */     //   #408	-> 1128
/*     */     //   #409	-> 1148
/*     */     //   #410	-> 1168
/*     */     //   #410	-> 1198
/*     */     //   #411	-> 1208
/*     */     //   #411	-> 1238
/*     */     //   #416	-> 1251
/*     */     //   #417	-> 1251
/*     */     //   #418	-> 1286
/*     */     //   #419	-> 1297
/*     */     //   #420	-> 1297
/*     */     //   #421	-> 1332
/*     */     //   #425	-> 1339
/*     */     //   #426	-> 1339
/*     */     //   #427	-> 1374
/*     */     //   #428	-> 1374
/*     */     //   #429	-> 1409
/*     */     //   #430	-> 1409
/*     */     //   #434	-> 1447
/*     */     //   #437	-> 1455
/*     */     //   #438	-> 1460
/*     */     //   #443	-> 1467
/*     */     //   #444	-> 1476
/*     */     //   #446	-> 1477
/*     */     //   #447	-> 1482
/*     */     //   #449	-> 1486
/*     */     //   #452	-> 1486
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   681	57	7	vertical	F
/*     */     //   666	72	6	horizontal	F
/*     */     //   771	75	7	vertical	F
/*     */     //   756	90	6	horizontal	F
/*     */     //   1128	120	6	yaw	F
/*     */     //   49	1437	4	packetEntityVelocity	Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketEntityVelocity;
/*     */     //   29	1458	3	packet	Lnet/ccbluex/liquidbounce/api/minecraft/network/IPacket;
/*     */     //   24	1463	2	thePlayer	Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/IEntityPlayerSP;
/*     */     //   0	1487	0	this	Lnet/ccbluex/liquidbounce/features/module/modules/combat/Velocity;
/*     */     //   0	1487	1	event	Lnet/ccbluex/liquidbounce/event/PacketEvent;
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
/*     */   @EventTarget
/*     */   public final void onJump(@NotNull JumpEvent event) {
/* 456 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  IEntityPlayerSP thePlayer = MinecraftInstance.mc.getThePlayer();
/*     */     
/* 458 */     if (thePlayer.isInWater() || thePlayer.isInLava() || thePlayer.isInWeb()) {
/*     */       return;
/*     */     }
/* 461 */     String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case -1234264725:
/* 475 */         if (str.equals("aaczero") && thePlayer.getHurtTime() > 0)
/* 476 */           event.cancelEvent(); 
/*     */         break;
/*     */       case -1234547235:
/*     */         if (str.equals("aacpush")) {
/*     */           this.jump = true;
/*     */           if (!thePlayer.isCollidedVertically())
/*     */             event.cancelEvent(); 
/*     */         } 
/*     */         break;
/*     */       case 2986065:
/*     */         if (str.equals("aac4") && thePlayer.getHurtTime() > 0)
/*     */           event.cancelEvent(); 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\combat\Velocity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */