/*      */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import net.ccbluex.liquidbounce.Retreat;
/*      */ import net.ccbluex.liquidbounce.api.enums.BlockType;
/*      */ import net.ccbluex.liquidbounce.api.enums.EnumFacingType;
/*      */ import net.ccbluex.liquidbounce.api.enums.StatType;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.block.IBlock;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.client.entity.IEntity;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemBlock;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.item.IItemStack;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.IPacket;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketEntityAction;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.network.play.client.ICPacketHeldItemChange;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IEnumFacing;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IMovingObjectPosition;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.IScaledResolution;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WBlockPos;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3;
/*      */ import net.ccbluex.liquidbounce.api.minecraft.util.WVec3i;
/*      */ import net.ccbluex.liquidbounce.event.EventState;
/*      */ import net.ccbluex.liquidbounce.event.EventTarget;
/*      */ import net.ccbluex.liquidbounce.event.JumpEvent;
/*      */ import net.ccbluex.liquidbounce.event.MotionEvent;
/*      */ import net.ccbluex.liquidbounce.event.MoveEvent;
/*      */ import net.ccbluex.liquidbounce.event.PacketEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render2DEvent;
/*      */ import net.ccbluex.liquidbounce.event.Render3DEvent;
/*      */ import net.ccbluex.liquidbounce.event.StrafeEvent;
/*      */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*      */ import net.ccbluex.liquidbounce.features.module.Module;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*      */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*      */ import net.ccbluex.liquidbounce.features.module.modules.movement.Speed;
/*      */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification;
/*      */ import net.ccbluex.liquidbounce.ui.client.hud.element.elements.NotifyType;
/*      */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*      */ import net.ccbluex.liquidbounce.utils.InventoryUtils;
/*      */ import net.ccbluex.liquidbounce.utils.MovementUtils;
/*      */ import net.ccbluex.liquidbounce.utils.PlaceRotation;
/*      */ import net.ccbluex.liquidbounce.utils.Rotation;
/*      */ import net.ccbluex.liquidbounce.utils.RotationUtils;
/*      */ import net.ccbluex.liquidbounce.utils.VecRotation;
/*      */ import net.ccbluex.liquidbounce.utils.block.BlockUtils;
/*      */ import net.ccbluex.liquidbounce.utils.block.PlaceInfo;
/*      */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*      */ import net.ccbluex.liquidbounce.utils.timer.MSTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TickTimer;
/*      */ import net.ccbluex.liquidbounce.utils.timer.TimeUtils;
/*      */ import net.ccbluex.liquidbounce.value.BoolValue;
/*      */ import net.ccbluex.liquidbounce.value.FloatValue;
/*      */ import net.ccbluex.liquidbounce.value.IntegerValue;
/*      */ import net.ccbluex.liquidbounce.value.ListValue;
/*      */ import net.minecraft.client.renderer.GlStateManager;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.util.math.MathHelper;
/*      */ import org.apache.commons.lang3.RandomUtils;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ @ModuleInfo(name = "ScaffoldLB", description = "Automatically places blocks beneath your feet.", category = ModuleCategory.WORLD)
/*      */ public class ScaffoldLB extends Module {
/*   62 */   private final BoolValue towerEnabled = new BoolValue("EnableTower", false);
/*   63 */   private final ListValue towerModeValue = new ListValue("TowerMode", new String[] { "Jump", "Motion", "ConstantMotion", "MotionTP", "Packet", "Teleport", "AAC3.3.9", "AAC3.6.4", "Verus" }, "Motion");
/*      */ 
/*      */   
/*   66 */   private final ListValue towerPlaceModeValue = new ListValue("Tower-PlaceTiming", new String[] { "Pre", "Post" }, "Post");
/*   67 */   private final BoolValue stopWhenBlockAbove = new BoolValue("StopWhenBlockAbove", false);
/*   68 */   private final BoolValue onJumpValue = new BoolValue("OnJump", false);
/*   69 */   private final BoolValue noMoveOnlyValue = new BoolValue("NoMove", true);
/*      */   
/*   71 */   private final FloatValue towerTimerValue = new FloatValue("TowerTimer", 1.0F, 0.1F, 10.0F);
/*      */ 
/*      */   
/*   74 */   private final FloatValue jumpMotionValue = new FloatValue("JumpMotion", 0.42F, 0.3681289F, 0.79F);
/*   75 */   private final IntegerValue jumpDelayValue = new IntegerValue("JumpDelay", 0, 0, 20);
/*      */ 
/*      */   
/*   78 */   private final FloatValue constantMotionValue = new FloatValue("ConstantMotion", 0.42F, 0.1F, 1.0F);
/*   79 */   private final FloatValue constantMotionJumpGroundValue = new FloatValue("ConstantMotionJumpGround", 0.79F, 0.76F, 1.0F);
/*      */ 
/*      */   
/*   82 */   private final FloatValue teleportHeightValue = new FloatValue("TeleportHeight", 1.15F, 0.1F, 5.0F);
/*   83 */   private final IntegerValue teleportDelayValue = new IntegerValue("TeleportDelay", 0, 0, 20);
/*   84 */   private final BoolValue teleportGroundValue = new BoolValue("TeleportGround", true);
/*   85 */   private final BoolValue teleportNoMotionValue = new BoolValue("TeleportNoMotion", false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   91 */   public final ListValue modeValue = new ListValue("Mode", new String[] { "Normal", "Rewinside", "Expand" }, "Normal");
/*      */ 
/*      */   
/*   94 */   private final BoolValue placeableDelay = new BoolValue("PlaceableDelay", false);
/*   95 */   private final IntegerValue maxDelayValue = new IntegerValue("MaxDelay", 0, 0, 1000)
/*      */     {
/*      */       protected void onChanged(Integer oldValue, Integer newValue) {
/*   98 */         int i = ((Integer)ScaffoldLB.this.minDelayValue.get()).intValue();
/*      */         
/*  100 */         if (i > newValue.intValue())
/*  101 */           set(Integer.valueOf(i)); 
/*      */       }
/*      */     };
/*      */   
/*  105 */   private final IntegerValue minDelayValue = new IntegerValue("MinDelay", 0, 0, 1000)
/*      */     {
/*      */       protected void onChanged(Integer oldValue, Integer newValue) {
/*  108 */         int i = ((Integer)ScaffoldLB.this.maxDelayValue.get()).intValue();
/*      */         
/*  110 */         if (i < newValue.intValue()) {
/*  111 */           set(Integer.valueOf(i));
/*      */         }
/*      */       }
/*      */     };
/*      */   
/*  116 */   private final BoolValue smartDelay = new BoolValue("SmartDelay", true);
/*      */ 
/*      */   
/*  119 */   private final ListValue autoBlockMode = new ListValue("AutoBlock", new String[] { "Spoof", "Switch", "Matrix", "Off" }, "Spoof");
/*  120 */   private final BoolValue stayAutoBlock = new BoolValue("StayAutoBlock", false);
/*      */ 
/*      */   
/*  123 */   public final ListValue sprintModeValue = new ListValue("SprintMode", new String[] { "Same", "Ground", "Air", "PlaceOff" }, "Air");
/*      */   
/*  125 */   public final BoolValue sprintValue = new BoolValue("Sprint", true);
/*  126 */   private final BoolValue swingValue = new BoolValue("Swing", true);
/*  127 */   private final BoolValue downValue = new BoolValue("Down", false);
/*  128 */   private final BoolValue searchValue = new BoolValue("Search", true);
/*  129 */   private final ListValue placeModeValue = new ListValue("PlaceTiming", new String[] { "Pre", "Post" }, "Post");
/*      */ 
/*      */   
/*  132 */   private final BoolValue eagleValue = new BoolValue("Eagle", false);
/*  133 */   private final BoolValue eagleSilentValue = new BoolValue("EagleSilent", false);
/*  134 */   private final IntegerValue blocksToEagleValue = new IntegerValue("BlocksToEagle", 0, 0, 10);
/*  135 */   private final FloatValue eagleEdgeDistanceValue = new FloatValue("EagleEdgeDistance", 0.2F, 0.0F, 0.5F);
/*      */ 
/*      */   
/*  138 */   private final BoolValue omniDirectionalExpand = new BoolValue("OmniDirectionalExpand", true);
/*  139 */   private final IntegerValue expandLengthValue = new IntegerValue("ExpandLength", 5, 1, 6);
/*      */ 
/*      */   
/*  142 */   private final IntegerValue searchAccuracyValue = new IntegerValue("SearchAccuracy", 8, 1, 24)
/*      */     {
/*      */       protected void onChanged(Integer oldValue, Integer newValue) {
/*  145 */         if (getMaximum() < newValue.intValue()) {
/*  146 */           set(Integer.valueOf(getMaximum()));
/*  147 */         } else if (getMinimum() > newValue.intValue()) {
/*  148 */           set(Integer.valueOf(getMinimum()));
/*      */         } 
/*      */       }
/*      */     };
/*  152 */   private final FloatValue xzRangeValue = new FloatValue("xzRange", 0.8F, 0.1F, 1.0F);
/*  153 */   private final FloatValue yRangeValue = new FloatValue("yRange", 0.8F, 0.1F, 1.0F);
/*      */   
/*  155 */   private final BoolValue rotationsValue = new BoolValue("Rotations", true);
/*  156 */   private final BoolValue noHitCheckValue = new BoolValue("NoHitCheck", false);
/*  157 */   private final BoolValue Pitchlimit = new BoolValue("Pitchlimit", true);
/*  158 */   private final FloatValue PitchlimitValue = new FloatValue("PitchlimitValue", 25.0F, -180.0F, 180.0F);
/*  159 */   public final ListValue rotationModeValue = new ListValue("RotationMode", new String[] { "Hypixel", "Normal", "AAC", "Static", "Static2", "Static3", "Custom" }, "Normal");
/*  160 */   public final ListValue rotationLookupValue = new ListValue("RotationLookup", new String[] { "Normal", "AAC", "Same" }, "Normal");
/*      */ 
/*      */   
/*  163 */   private final FloatValue maxTurnSpeed = new FloatValue("MaxTurnSpeed", 180.0F, 0.0F, 180.0F)
/*      */     {
/*      */       protected void onChanged(Float oldValue, Float newValue) {
/*  166 */         float i = ((Float)ScaffoldLB.this.minTurnSpeed.get()).floatValue();
/*      */         
/*  168 */         if (i > newValue.floatValue())
/*  169 */           set(Float.valueOf(i)); 
/*      */       }
/*      */     };
/*      */   
/*  173 */   private final FloatValue minTurnSpeed = new FloatValue("MinTurnSpeed", 180.0F, 0.0F, 180.0F)
/*      */     {
/*      */       protected void onChanged(Float oldValue, Float newValue) {
/*  176 */         float i = ((Float)ScaffoldLB.this.maxTurnSpeed.get()).floatValue();
/*      */         
/*  178 */         if (i < newValue.floatValue())
/*  179 */           set(Float.valueOf(i)); 
/*      */       }
/*      */     };
/*  182 */   private final IntegerValue HypixelYawValue = new IntegerValue("HypixelYaw", 180, -360, 360);
/*  183 */   private final IntegerValue HypixelPitchValue = new IntegerValue("HypixelPitch", 79, 60, 100);
/*  184 */   private final FloatValue staticPitchValue = new FloatValue("Static-Pitch", 86.0F, 80.0F, 90.0F);
/*      */   
/*  186 */   private final FloatValue customYawValue = new FloatValue("Custom-Yaw", 135.0F, -180.0F, 180.0F);
/*  187 */   private final FloatValue customPitchValue = new FloatValue("Custom-Pitch", 86.0F, -90.0F, 90.0F);
/*  188 */   private final BoolValue keepRotOnJumpValue = new BoolValue("KeepRotOnJump", true);
/*      */   
/*  190 */   private final BoolValue keepRotationValue = new BoolValue("KeepRotation", false);
/*  191 */   private final IntegerValue keepLengthValue = new IntegerValue("KeepRotationLength", 0, 0, 20);
/*  192 */   private final ListValue placeConditionValue = new ListValue("Place-Condition", new String[] { "Air", "FallDown", "NegativeMotion", "Always" }, "Always");
/*      */   
/*  194 */   private final BoolValue rotationStrafeValue = new BoolValue("RotationStrafe", false);
/*      */ 
/*      */   
/*  197 */   private final BoolValue zitterValue = new BoolValue("Zitter", false);
/*  198 */   private final ListValue zitterModeValue = new ListValue("ZitterMode", new String[] { "Teleport", "Smooth" }, "Teleport");
/*  199 */   private final FloatValue zitterSpeed = new FloatValue("ZitterSpeed", 0.13F, 0.1F, 0.3F);
/*  200 */   private final FloatValue zitterStrength = new FloatValue("ZitterStrength", 0.072F, 0.05F, 0.2F);
/*  201 */   private final IntegerValue zitterDelay = new IntegerValue("ZitterDelay", 100, 0, 500);
/*      */ 
/*      */   
/*  204 */   private final FloatValue timerValue = new FloatValue("Timer", 1.0F, 0.1F, 10.0F);
/*  205 */   public final FloatValue speedModifierValue = new FloatValue("SpeedModifier", 1.0F, 0.0F, 2.0F);
/*      */   
/*  207 */   private final BoolValue customSpeedValue = new BoolValue("CustomSpeed", false);
/*  208 */   private final FloatValue customMoveSpeedValue = new FloatValue("CustomMoveSpeed", 0.3F, 0.0F, 5.0F);
/*      */ 
/*      */   
/*  211 */   private final BoolValue sameYValue = new BoolValue("SameY", false);
/*  212 */   private final BoolValue autoJumpValue = new BoolValue("AutoJump", false);
/*  213 */   private final BoolValue smartSpeedValue = new BoolValue("SmartSpeed", false);
/*  214 */   private final BoolValue safeWalkValue = new BoolValue("SafeWalk", true);
/*  215 */   private final BoolValue airSafeValue = new BoolValue("AirSafe", false);
/*  216 */   private final BoolValue autoDisableSpeedValue = new BoolValue("AutoDisable-Speed", true);
/*      */ 
/*      */   
/*  219 */   public final ListValue counterDisplayValue = new ListValue("Counter", new String[] { "Off", "Simple", "Advanced", "Sigma", "Novoline" }, "Simple");
/*      */   
/*  221 */   private final BoolValue markValue = new BoolValue("Mark", false);
/*  222 */   private final IntegerValue redValue = new IntegerValue("Red", 0, 0, 255);
/*  223 */   private final IntegerValue greenValue = new IntegerValue("Green", 120, 0, 255);
/*  224 */   private final IntegerValue blueValue = new IntegerValue("Blue", 255, 0, 255);
/*  225 */   private final IntegerValue alphaValue = new IntegerValue("Alpha", 120, 0, 255);
/*      */ 
/*      */   
/*      */   private PlaceInfo targetPlace;
/*      */ 
/*      */   
/*      */   private PlaceInfo towerPlace;
/*      */ 
/*      */   
/*      */   private int launchY;
/*      */ 
/*      */   
/*      */   private boolean faceBlock;
/*      */ 
/*      */   
/*      */   private Rotation lockRotation;
/*      */   
/*      */   private Rotation lookupRotation;
/*      */   
/*      */   private int slot;
/*      */   
/*      */   private int lastSlot;
/*      */   
/*      */   private boolean zitterDirection;
/*      */   
/*  250 */   private final MSTimer delayTimer = new MSTimer();
/*  251 */   private final MSTimer zitterTimer = new MSTimer();
/*      */   
/*      */   private long delay;
/*      */   
/*  255 */   private int placedBlocksWithoutEagle = 0;
/*      */ 
/*      */   
/*      */   private boolean eagleSneaking;
/*      */   
/*      */   private boolean shouldGoDown = false;
/*      */   
/*  262 */   private float progress = 0.0F;
/*  263 */   private long lastMS = 0L;
/*      */ 
/*      */   
/*  266 */   private final TickTimer timer = new TickTimer();
/*  267 */   private double jumpGround = 0.0D;
/*  268 */   private int verusState = 0;
/*      */   private boolean verusJumped = false;
/*      */   
/*      */   public boolean isTowerOnly() {
/*  272 */     return (((Boolean)this.towerEnabled.get()).booleanValue() && !((Boolean)this.onJumpValue.get()).booleanValue());
/*      */   }
/*      */   
/*      */   public boolean towerActivation() {
/*  276 */     return (((Boolean)this.towerEnabled.get()).booleanValue() && (!((Boolean)this.onJumpValue.get()).booleanValue() || mc.getGameSettings().getKeyBindJump().isKeyDown()) && (!((Boolean)this.noMoveOnlyValue.get()).booleanValue() || !MovementUtils.isMoving()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onEnable() {
/*  284 */     if (mc.getThePlayer() == null)
/*      */       return; 
/*  286 */     this.progress = 0.0F;
/*  287 */     this.launchY = (int)mc.getThePlayer().getPosY();
/*  288 */     this.lastSlot = mc.getThePlayer().getInventory().getCurrentItem();
/*  289 */     this.slot = mc.getThePlayer().getInventory().getCurrentItem();
/*      */     
/*  291 */     if (((Boolean)this.autoDisableSpeedValue.get()).booleanValue() && Retreat.moduleManager.getModule(Speed.class).getState()) {
/*  292 */       Retreat.moduleManager.getModule(Speed.class).setState(false);
/*  293 */       Retreat.hud.addNotification(new Notification("Scaffold", "Speed is disabled to prevent flags/errors.", NotifyType.INFO, 500, 1000));
/*      */     } 
/*      */     
/*  296 */     this.faceBlock = false;
/*  297 */     this.lastMS = System.currentTimeMillis();
/*      */   }
/*      */ 
/*      */   
/*      */   private void fakeJump() {
/*  302 */     mc.getThePlayer().setAirBorne(true);
/*  303 */     mc.getThePlayer().triggerAchievement(classProvider.getStatEnum(StatType.JUMP_STAT));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void move(MotionEvent event) {
/*  310 */     if (((Boolean)this.Pitchlimit.get()).booleanValue()) mc.getThePlayer().setRotationPitch(((Float)this.PitchlimitValue.get()).floatValue()); 
/*  311 */     switch (((String)this.towerModeValue.get()).toLowerCase()) {
/*      */       case "jump":
/*  313 */         if (mc.getThePlayer().getOnGround() && this.timer.hasTimePassed(((Integer)this.jumpDelayValue.get()).intValue())) {
/*  314 */           fakeJump();
/*  315 */           mc.getThePlayer().setMotionY(((Float)this.jumpMotionValue.get()).floatValue());
/*  316 */           this.timer.reset();
/*      */         } 
/*      */         break;
/*      */       case "motion":
/*  320 */         if (mc.getThePlayer().getOnGround()) {
/*  321 */           fakeJump();
/*  322 */           mc.getThePlayer().setMotionY(0.42D); break;
/*  323 */         }  if (mc.getThePlayer().getMotionY() < 0.1D) mc.getThePlayer().setMotionY(0.3D); 
/*      */         break;
/*      */       case "motiontp":
/*  326 */         if (mc.getThePlayer().getOnGround()) {
/*  327 */           fakeJump();
/*  328 */           mc.getThePlayer().setMotionY(0.42D); break;
/*  329 */         }  if (mc.getThePlayer().getMotionY() < 0.23D)
/*  330 */           mc.getThePlayer().setPosition(mc.getThePlayer().getPosX(), (int)mc.getThePlayer().getPosY(), mc.getThePlayer().getPosZ()); 
/*      */         break;
/*      */       case "packet":
/*  333 */         if (mc.getThePlayer().getOnGround() && this.timer.hasTimePassed(2)) {
/*  334 */           fakeJump();
/*  335 */           mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketPlayerPosition(mc.getThePlayer().getPosX(), mc
/*  336 */                 .getThePlayer().getPosY() + 0.42D, mc.getThePlayer().getPosZ(), false));
/*  337 */           mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketPlayerPosition(mc.getThePlayer().getPosX(), mc
/*  338 */                 .getThePlayer().getPosY() + 0.76D, mc.getThePlayer().getPosZ(), false));
/*  339 */           mc.getThePlayer().setPosition(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY() + 1.08D, mc.getThePlayer().getPosZ());
/*  340 */           this.timer.reset();
/*      */         } 
/*      */         break;
/*      */       case "teleport":
/*  344 */         if (((Boolean)this.teleportNoMotionValue.get()).booleanValue()) {
/*  345 */           mc.getThePlayer().setMotionY(0.0D);
/*      */         }
/*  347 */         if ((mc.getThePlayer().getOnGround() || !((Boolean)this.teleportGroundValue.get()).booleanValue()) && this.timer.hasTimePassed(((Integer)this.teleportDelayValue.get()).intValue())) {
/*  348 */           fakeJump();
/*  349 */           mc.getThePlayer().setPositionAndUpdate(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY() + ((Float)this.teleportHeightValue.get()).floatValue(), mc.getThePlayer().getPosZ());
/*  350 */           this.timer.reset();
/*      */         } 
/*      */         break;
/*      */       case "constantmotion":
/*  354 */         if (mc.getThePlayer().getOnGround()) {
/*  355 */           fakeJump();
/*  356 */           this.jumpGround = mc.getThePlayer().getPosY();
/*  357 */           mc.getThePlayer().setMotionY(((Float)this.constantMotionValue.get()).floatValue());
/*      */         } 
/*      */         
/*  360 */         if (mc.getThePlayer().getPosY() > this.jumpGround + ((Float)this.constantMotionJumpGroundValue.get()).floatValue()) {
/*  361 */           fakeJump();
/*  362 */           mc.getThePlayer().setPosition(mc.getThePlayer().getPosX(), (int)mc.getThePlayer().getPosY(), mc.getThePlayer().getPosZ());
/*  363 */           mc.getThePlayer().setMotionY(((Float)this.constantMotionValue.get()).floatValue());
/*  364 */           this.jumpGround = mc.getThePlayer().getPosY();
/*      */         } 
/*      */         break;
/*      */       case "aac3.3.9":
/*  368 */         if (mc.getThePlayer().getOnGround()) {
/*  369 */           fakeJump();
/*  370 */           mc.getThePlayer().setMotionY(0.4001D);
/*      */         } 
/*  372 */         mc.getTimer().setTimerSpeed(1.0F);
/*      */         
/*  374 */         if (mc.getThePlayer().getMotionY() < 0.0D) {
/*  375 */           mc.getThePlayer().setMotionY(-9.45E-6D);
/*  376 */           mc.getTimer().setTimerSpeed(1.6F);
/*      */         } 
/*      */         break;
/*      */       case "aac3.6.4":
/*  380 */         if (mc.getThePlayer().getTicksExisted() % 4 == 1) {
/*  381 */           mc.getThePlayer().setMotionY(0.4195464D);
/*  382 */           mc.getThePlayer().setPosition(mc.getThePlayer().getPosX() - 0.035D, mc.getThePlayer().getPosY(), mc.getThePlayer().getPosZ()); break;
/*  383 */         }  if (mc.getThePlayer().getTicksExisted() % 4 == 0) {
/*  384 */           mc.getThePlayer().setMotionY(-0.5D);
/*  385 */           mc.getThePlayer().setPosition(mc.getThePlayer().getPosX() + 0.035D, mc.getThePlayer().getPosY(), mc.getThePlayer().getPosZ());
/*      */         } 
/*      */         break;
/*      */       case "verus":
/*  389 */         if (!mc.getTheWorld().getCollidingBoundingBoxes((IEntity)mc.getThePlayer(), mc.getThePlayer().getEntityBoundingBox().offset(0.0D, -0.01D, 0.0D)).isEmpty() && mc.getThePlayer().getOnGround() && mc.getThePlayer().isCollidedVertically()) {
/*  390 */           this.verusState = 0;
/*  391 */           this.verusJumped = true;
/*      */         } 
/*  393 */         if (this.verusJumped) {
/*  394 */           MovementUtils.strafe();
/*  395 */           switch (this.verusState) {
/*      */             case 0:
/*  397 */               fakeJump();
/*  398 */               mc.getThePlayer().setMotionY(0.41999998688697815D);
/*  399 */               this.verusState++;
/*      */               break;
/*      */             case 1:
/*  402 */               this.verusState++;
/*      */               break;
/*      */             case 2:
/*  405 */               this.verusState++;
/*      */               break;
/*      */             case 3:
/*  408 */               mc.getThePlayer().setOnGround(true);
/*  409 */               mc.getThePlayer().setMotionY(0.0D);
/*  410 */               this.verusState++;
/*      */               break;
/*      */             case 4:
/*  413 */               this.verusState++;
/*      */               break;
/*      */           } 
/*  416 */           this.verusJumped = false;
/*      */         } 
/*  418 */         this.verusJumped = true;
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public void onUpdate(UpdateEvent event) {
/*  430 */     if (towerActivation()) {
/*  431 */       this.shouldGoDown = false;
/*  432 */       mc.getGameSettings().getKeyBindSneak().setPressed(false);
/*  433 */       mc.getThePlayer().setSprinting(false);
/*      */       return;
/*      */     } 
/*  436 */     if (((String)this.sprintModeValue.get()).equalsIgnoreCase("PlaceOff")) {
/*  437 */       if (mc.getThePlayer().getOnGround());
/*  438 */       mc.getThePlayer().setSprinting(true);
/*  439 */       mc.getThePlayer().setMotionX(mc.getThePlayer().getMotionX() * 1.0D);
/*  440 */       mc.getThePlayer().setMotionZ(mc.getThePlayer().getMotionZ() * 1.0D);
/*      */     } 
/*  442 */     mc.getTimer().setTimerSpeed(((Float)this.timerValue.get()).floatValue());
/*  443 */     this.shouldGoDown = (((Boolean)this.downValue.get()).booleanValue() && !((Boolean)this.sameYValue.get()).booleanValue() && mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindSneak()) && getBlocksAmount() > 1);
/*  444 */     if (this.shouldGoDown) {
/*  445 */       mc.getGameSettings().getKeyBindSneak().setPressed(false);
/*      */     }
/*      */     
/*  448 */     if (((Boolean)this.customSpeedValue.get()).booleanValue()) {
/*  449 */       MovementUtils.strafe(((Float)this.customMoveSpeedValue.get()).floatValue());
/*      */     }
/*  451 */     if (mc.getThePlayer().getOnGround()) {
/*  452 */       String mode = (String)this.modeValue.get();
/*      */ 
/*      */       
/*  455 */       if (mode.equalsIgnoreCase("Rewinside")) {
/*  456 */         MovementUtils.strafe(0.2F);
/*  457 */         mc.getThePlayer().setMotionY(0.0D);
/*      */       } 
/*      */ 
/*      */       
/*  461 */       if (((Boolean)this.zitterValue.get()).booleanValue() && ((String)this.zitterModeValue.get()).equalsIgnoreCase("smooth")) {
/*  462 */         if (mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindRight())) {
/*  463 */           mc.getGameSettings().getKeyBindRight().setPressed(false);
/*      */         }
/*  465 */         if (mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindLeft())) {
/*  466 */           mc.getGameSettings().getKeyBindLeft().setPressed(false);
/*      */         }
/*  468 */         if (this.zitterTimer.hasTimePassed(((Integer)this.zitterDelay.get()).intValue())) {
/*  469 */           this.zitterDirection = !this.zitterDirection;
/*  470 */           this.zitterTimer.reset();
/*      */         } 
/*      */         
/*  473 */         if (this.zitterDirection) {
/*  474 */           mc.getGameSettings().getKeyBindRight().setPressed(true);
/*  475 */           mc.getGameSettings().getKeyBindLeft().setPressed(false);
/*      */         } else {
/*  477 */           mc.getGameSettings().getKeyBindRight().setPressed(false);
/*  478 */           mc.getGameSettings().getKeyBindLeft().setPressed(true);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  483 */       if (((Boolean)this.eagleValue.get()).booleanValue() && !this.shouldGoDown) {
/*  484 */         double dif = 0.5D;
/*  485 */         if (((Float)this.eagleEdgeDistanceValue.get()).floatValue() > 0.0F)
/*  486 */           for (int i = 0; i < 4; i++) {
/*  487 */             WBlockPos WBlockPos = new WBlockPos(mc.getThePlayer().getPosX() + ((i == 0) ? -1 : ((i == 1) ? true : false)), mc.getThePlayer().getPosY() - ((mc.getThePlayer().getPosY() == (int)mc.getThePlayer().getPosY() + 0.5D) ? 0.0D : 1.0D), mc.getThePlayer().getPosZ() + ((i == 2) ? -1 : ((i == 3) ? true : false)));
/*  488 */             PlaceInfo placeInfo = PlaceInfo.get(WBlockPos);
/*  489 */             if (BlockUtils.isReplaceable(WBlockPos) && placeInfo != null) {
/*  490 */               double calcDif = (i > 1) ? (mc.getThePlayer().getPosZ() - WBlockPos.getZ()) : (mc.getThePlayer().getPosX() - WBlockPos.getX());
/*  491 */               calcDif -= 0.5D;
/*      */               
/*  493 */               if (calcDif < 0.0D)
/*  494 */                 calcDif *= -1.0D; 
/*  495 */               calcDif -= 0.5D;
/*      */               
/*  497 */               if (calcDif < dif) {
/*  498 */                 dif = calcDif;
/*      */               }
/*      */             } 
/*      */           }  
/*  502 */         if (this.placedBlocksWithoutEagle >= ((Integer)this.blocksToEagleValue.get()).intValue()) {
/*      */           
/*  504 */           boolean shouldEagle = (mc.getTheWorld().getBlockState(new WBlockPos(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY() - 1.0D, mc.getThePlayer().getPosZ())).getBlock().equals(classProvider.getBlockEnum(BlockType.AIR)) || dif < ((Float)this.eagleEdgeDistanceValue.get()).floatValue());
/*      */           
/*  506 */           if (((Boolean)this.eagleSilentValue.get()).booleanValue()) {
/*  507 */             if (this.eagleSneaking != shouldEagle) {
/*  508 */               mc.getNetHandler().addToSendQueue((IPacket)classProvider
/*  509 */                   .createCPacketEntityAction((IEntity)mc.getThePlayer(), shouldEagle ? ICPacketEntityAction.WAction.START_SNEAKING : ICPacketEntityAction.WAction.STOP_SNEAKING));
/*      */             }
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  515 */             this.eagleSneaking = shouldEagle;
/*      */           } else {
/*  517 */             mc.getGameSettings().getKeyBindSneak().setPressed(shouldEagle);
/*      */           } 
/*  519 */           this.placedBlocksWithoutEagle = 0;
/*      */         } else {
/*  521 */           this.placedBlocksWithoutEagle++;
/*      */         } 
/*      */       } 
/*      */       
/*  525 */       if (((Boolean)this.zitterValue.get()).booleanValue() && ((String)this.zitterModeValue.get()).equalsIgnoreCase("teleport")) {
/*  526 */         MovementUtils.strafe(((Float)this.zitterSpeed.get()).floatValue());
/*      */ 
/*      */         
/*  529 */         double yaw = Math.toRadians(mc.getThePlayer().getRotationYaw() + (this.zitterDirection ? 90.0D : -90.0D));
/*  530 */         mc.getThePlayer().setMotionX(-Math.sin(yaw) * ((Float)this.zitterStrength.get()).floatValue());
/*  531 */         mc.getThePlayer().setMotionZ(Math.cos(yaw) * ((Float)this.zitterStrength.get()).floatValue());
/*  532 */         this.zitterDirection = !this.zitterDirection;
/*      */       } 
/*      */     } 
/*      */     
/*  536 */     if (((String)this.sprintModeValue.get()).equalsIgnoreCase("off") || (((String)this.sprintModeValue.get()).equalsIgnoreCase("ground") && !mc.getThePlayer().getOnGround()) || (((String)this.sprintModeValue.get()).equalsIgnoreCase("air") && mc.getThePlayer().getOnGround())) {
/*  537 */       mc.getThePlayer().setSprinting(true);
/*      */     }
/*      */ 
/*      */     
/*  541 */     if (this.shouldGoDown) {
/*  542 */       this.launchY = (int)mc.getThePlayer().getPosY() - 1;
/*  543 */     } else if (!((Boolean)this.sameYValue.get()).booleanValue()) {
/*  544 */       if ((!((Boolean)this.autoJumpValue.get()).booleanValue() && (!((Boolean)this.smartSpeedValue.get()).booleanValue() || !Retreat.moduleManager.getModule(Speed.class).getState())) || mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindJump()) || mc.getThePlayer().getPosY() < this.launchY) this.launchY = (int)mc.getThePlayer().getPosY(); 
/*  545 */       if (((Boolean)this.autoJumpValue.get()).booleanValue() && !Retreat.moduleManager.getModule(Speed.class).getState() && MovementUtils.isMoving() && mc.getThePlayer().getOnGround()) {
/*  546 */         mc.getThePlayer().jump();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   @EventTarget
/*      */   public void onPacket(PacketEvent event) {
/*  553 */     if (mc.getThePlayer() == null) {
/*      */       return;
/*      */     }
/*  556 */     IPacket packet = event.getPacket();
/*      */ 
/*      */     
/*  559 */     if (classProvider.isCPacketHeldItemChange(packet)) {
/*  560 */       ICPacketHeldItemChange packetHeldItemChange = packet.asCPacketHeldItemChange();
/*      */       
/*  562 */       this.slot = packetHeldItemChange.getSlotId();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public void onStrafe(StrafeEvent event) {
/*  569 */     if (this.lookupRotation != null && ((Boolean)this.rotationStrafeValue.get()).booleanValue()) {
/*  570 */       int dif = (int)((MathHelper.func_76142_g(mc.getThePlayer().getRotationYaw() - this.lookupRotation.getYaw() - 23.5F - 135.0F) + 180.0F) / 45.0F);
/*      */       
/*  572 */       float yaw = this.lookupRotation.getYaw();
/*  573 */       float strafe = event.getStrafe();
/*  574 */       float forward = event.getForward();
/*  575 */       float friction = event.getFriction();
/*  576 */       float calcForward = 0.0F;
/*  577 */       float calcStrafe = 0.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  585 */       switch (dif) {
/*      */         case 0:
/*  587 */           calcForward = forward;
/*  588 */           calcStrafe = strafe;
/*      */           break;
/*      */         
/*      */         case 1:
/*  592 */           calcForward += forward;
/*  593 */           calcStrafe -= forward;
/*  594 */           calcForward += strafe;
/*  595 */           calcStrafe += strafe;
/*      */           break;
/*      */         
/*      */         case 2:
/*  599 */           calcForward = strafe;
/*  600 */           calcStrafe = -forward;
/*      */           break;
/*      */         
/*      */         case 3:
/*  604 */           calcForward -= forward;
/*  605 */           calcStrafe -= forward;
/*  606 */           calcForward += strafe;
/*  607 */           calcStrafe -= strafe;
/*      */           break;
/*      */         
/*      */         case 4:
/*  611 */           calcForward = -forward;
/*  612 */           calcStrafe = -strafe;
/*      */           break;
/*      */         
/*      */         case 5:
/*  616 */           calcForward -= forward;
/*  617 */           calcStrafe += forward;
/*  618 */           calcForward -= strafe;
/*  619 */           calcStrafe -= strafe;
/*      */           break;
/*      */         
/*      */         case 6:
/*  623 */           calcForward = -strafe;
/*  624 */           calcStrafe = forward;
/*      */           break;
/*      */         
/*      */         case 7:
/*  628 */           calcForward += forward;
/*  629 */           calcStrafe += forward;
/*  630 */           calcForward -= strafe;
/*  631 */           calcStrafe += strafe;
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/*  636 */       if (calcForward > 1.0F || (calcForward < 0.9F && calcForward > 0.3F) || calcForward < -1.0F || (calcForward > -0.9F && calcForward < -0.3F)) {
/*  637 */         calcForward *= 0.5F;
/*      */       }
/*      */       
/*  640 */       if (calcStrafe > 1.0F || (calcStrafe < 0.9F && calcStrafe > 0.3F) || calcStrafe < -1.0F || (calcStrafe > -0.9F && calcStrafe < -0.3F)) {
/*  641 */         calcStrafe *= 0.5F;
/*      */       }
/*      */       
/*  644 */       float f = calcStrafe * calcStrafe + calcForward * calcForward;
/*      */       
/*  646 */       if (f >= 1.0E-4F) {
/*  647 */         f = MathHelper.func_76129_c(f);
/*      */         
/*  649 */         if (f < 1.0F) {
/*  650 */           f = 1.0F;
/*      */         }
/*  652 */         f = friction / f;
/*  653 */         calcStrafe *= f;
/*  654 */         calcForward *= f;
/*      */         
/*  656 */         float yawSin = MathHelper.func_76126_a((float)(yaw * Math.PI / 180.0D));
/*  657 */         float yawCos = MathHelper.func_76134_b((float)(yaw * Math.PI / 180.0D));
/*      */         
/*  659 */         mc.getThePlayer().setMotionX((calcStrafe * yawCos - calcForward * yawSin));
/*  660 */         mc.getThePlayer().setMotionZ((calcForward * yawCos + calcStrafe * yawSin));
/*      */       } 
/*  662 */       event.cancelEvent();
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean shouldPlace() {
/*  667 */     boolean placeWhenAir = ((String)this.placeConditionValue.get()).equalsIgnoreCase("air");
/*  668 */     boolean placeWhenFall = ((String)this.placeConditionValue.get()).equalsIgnoreCase("falldown");
/*  669 */     boolean placeWhenNegativeMotion = ((String)this.placeConditionValue.get()).equalsIgnoreCase("negativemotion");
/*  670 */     boolean alwaysPlace = ((String)this.placeConditionValue.get()).equalsIgnoreCase("always");
/*  671 */     return (towerActivation() || alwaysPlace || (placeWhenAir && !mc.getThePlayer().getOnGround()) || (placeWhenFall && mc.getThePlayer().getFallDistance() > 0.0F) || (placeWhenNegativeMotion && mc.getThePlayer().getMotionY() < 0.0D));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public void onMotion(MotionEvent event) {
/*  681 */     if (((Boolean)this.rotationsValue.get()).booleanValue() && ((Boolean)this.keepRotationValue.get()).booleanValue() && this.lockRotation != null) {
/*  682 */       RotationUtils.setTargetRotation(RotationUtils.limitAngleChange(RotationUtils.serverRotation, this.lockRotation, RandomUtils.nextFloat(((Float)this.minTurnSpeed.get()).floatValue(), ((Float)this.maxTurnSpeed.get()).floatValue())));
/*      */     }
/*  684 */     String mode = (String)this.modeValue.get();
/*  685 */     EventState eventState = event.getEventState();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  694 */     if ((!((Boolean)this.rotationsValue.get()).booleanValue() || ((Boolean)this.noHitCheckValue.get()).booleanValue() || this.faceBlock) && ((String)this.placeModeValue.get()).equalsIgnoreCase(eventState.getStateName()) && !towerActivation()) {
/*  695 */       place(false);
/*      */     }
/*      */     
/*  698 */     if (eventState == EventState.PRE && !towerActivation()) {
/*  699 */       if (!shouldPlace() || (!((String)this.autoBlockMode.get()).equalsIgnoreCase("Off") ? (InventoryUtils.findAutoBlockBlock() == -1) : (mc.getThePlayer().getHeldItem() == null || 
/*  700 */         !(mc.getThePlayer().getHeldItem().getItem() instanceof net.minecraft.item.ItemBlock)))) {
/*      */         return;
/*      */       }
/*  703 */       findBlock((mode.equalsIgnoreCase("expand") && !towerActivation()));
/*      */     } 
/*      */     
/*  706 */     if (this.targetPlace == null && (
/*  707 */       (Boolean)this.placeableDelay.get()).booleanValue()) {
/*  708 */       this.delayTimer.reset();
/*      */     }
/*      */     
/*  711 */     if (!towerActivation()) {
/*  712 */       this.verusState = 0;
/*  713 */       this.towerPlace = null;
/*      */       
/*      */       return;
/*      */     } 
/*  717 */     mc.getTimer().setTimerSpeed(((Float)this.towerTimerValue.get()).floatValue());
/*      */     
/*  719 */     if (((String)this.towerPlaceModeValue.get()).equalsIgnoreCase(eventState.getStateName())) place(true);
/*      */     
/*  721 */     if (eventState == EventState.PRE) {
/*  722 */       this.towerPlace = null;
/*  723 */       this.timer.update();
/*      */       
/*  725 */       boolean isHeldItemBlock = (mc.getThePlayer().getHeldItem() != null && mc.getThePlayer().getHeldItem().getItem() instanceof net.minecraft.item.ItemBlock);
/*  726 */       if (InventoryUtils.findAutoBlockBlock() != -1 || isHeldItemBlock) {
/*  727 */         this.launchY = (int)mc.getThePlayer().getPosY();
/*      */         
/*  729 */         if (((String)this.towerModeValue.get()).equalsIgnoreCase("verus") || !((Boolean)this.stopWhenBlockAbove.get()).booleanValue() || BlockUtils.getBlock(new WBlockPos(mc.getThePlayer().getPosX(), mc
/*  730 */               .getThePlayer().getPosY() + 2.0D, mc.getThePlayer().getPosZ())) instanceof net.minecraft.block.BlockAir) {
/*  731 */           move(event);
/*      */         }
/*  733 */         WBlockPos WBlockPos = new WBlockPos(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY() - 1.0D, mc.getThePlayer().getPosZ());
/*  734 */         if (mc.getTheWorld().getBlockState(WBlockPos).getBlock() instanceof net.minecraft.block.BlockAir && 
/*  735 */           search(WBlockPos, true, true) && ((Boolean)this.rotationsValue.get()).booleanValue()) {
/*  736 */           VecRotation vecRotation = RotationUtils.faceBlock(WBlockPos);
/*      */           
/*  738 */           if (vecRotation != null) {
/*  739 */             RotationUtils.setTargetRotation(RotationUtils.limitAngleChange(RotationUtils.serverRotation, vecRotation.getRotation(), RandomUtils.nextFloat(((Float)this.minTurnSpeed.get()).floatValue(), ((Float)this.maxTurnSpeed.get()).floatValue())));
/*  740 */             this.towerPlace.setVec3(vecRotation.getVec());
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void findBlock(boolean expand) {
/*  756 */     WBlockPos WBlockPosition = this.shouldGoDown ? ((mc.getThePlayer().getPosY() == (int)mc.getThePlayer().getPosY() + 0.5D) ? new WBlockPos(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY() - 0.6D, mc.getThePlayer().getPosZ()) : (new WBlockPos(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY() - 0.6D, mc.getThePlayer().getPosZ())).down()) : ((!towerActivation() && (((Boolean)this.sameYValue.get()).booleanValue() || ((((Boolean)this.autoJumpValue.get()).booleanValue() || (((Boolean)this.smartSpeedValue.get()).booleanValue() && Retreat.moduleManager.getModule(Speed.class).getState())) && mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindJump()))) && this.launchY <= mc.getThePlayer().getPosY()) ? new WBlockPos(mc.getThePlayer().getPosX(), (this.launchY - 1), mc.getThePlayer().getPosZ()) : ((mc.getThePlayer().getPosY() == (int)mc.getThePlayer().getPosY() + 0.5D) ? new WBlockPos((IEntity)mc.getThePlayer()) : (new WBlockPos(mc.getThePlayer().getPosX(), mc.getThePlayer().getPosY(), mc.getThePlayer().getPosZ())).down()));
/*      */     
/*  758 */     if (!expand && (!BlockUtils.isReplaceable(WBlockPosition) || search(WBlockPosition, !this.shouldGoDown, false))) {
/*      */       return;
/*      */     }
/*  761 */     if (expand) {
/*  762 */       double yaw = Math.toRadians(mc.getThePlayer().getRotationYaw());
/*  763 */       int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? (int)Math.round(-Math.sin(yaw)) : mc.getThePlayer().getHorizontalFacing().getDirectionVec().getX();
/*  764 */       int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? (int)Math.round(Math.cos(yaw)) : mc.getThePlayer().getHorizontalFacing().getDirectionVec().getZ();
/*      */       
/*  766 */       for (int i = 0; i < ((Integer)this.expandLengthValue.get()).intValue(); i++) {
/*  767 */         if (search(WBlockPosition.add(x * i, 0, z * i), false, false))
/*      */           return; 
/*      */       } 
/*  770 */     } else if (((Boolean)this.searchValue.get()).booleanValue()) {
/*  771 */       for (int x = -1; x <= 1; x++) {
/*  772 */         for (int z = -1; z <= 1; z++) {
/*  773 */           if (search(WBlockPosition.add(x, 0, z), !this.shouldGoDown, false)) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void place(boolean towerActive) {
/*  782 */     if (((String)this.sprintModeValue.get()).equalsIgnoreCase("PlaceOff")) {
/*  783 */       mc.getThePlayer().setSprinting(false);
/*  784 */       mc.getThePlayer().setMotionX(mc.getThePlayer().getMotionX() * 1.0D);
/*  785 */       mc.getThePlayer().setMotionZ(mc.getThePlayer().getMotionZ() * 1.0D);
/*      */     } 
/*  787 */     if ((towerActive ? this.towerPlace : this.targetPlace) == null) {
/*  788 */       if (((Boolean)this.placeableDelay.get()).booleanValue()) {
/*  789 */         this.delayTimer.reset();
/*      */       }
/*      */       return;
/*      */     } 
/*  793 */     if (!towerActivation() && (!this.delayTimer.hasTimePassed(this.delay) || (((Boolean)this.smartDelay.get()).booleanValue() && mc.getRightClickDelayTimer() > 0) || ((((Boolean)this.sameYValue.get()).booleanValue() || ((((Boolean)this.autoJumpValue.get()).booleanValue() || (((Boolean)this.smartSpeedValue.get()).booleanValue() && Retreat.moduleManager.getModule(Speed.class).getState())) && mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindJump()))) && this.launchY - 1 != (int)(towerActive ? this.towerPlace : this.targetPlace).getVec3().getYCoord()))) {
/*      */       return;
/*      */     }
/*  796 */     int blockSlot = -1;
/*  797 */     IItemStack itemStack = mc.getThePlayer().getHeldItem();
/*      */     
/*  799 */     if (mc.getThePlayer().getHeldItem() == null || !(mc.getThePlayer().getHeldItem().getItem() instanceof net.minecraft.item.ItemBlock)) {
/*  800 */       if (((String)this.autoBlockMode.get()).equalsIgnoreCase("Off")) {
/*      */         return;
/*      */       }
/*  803 */       blockSlot = InventoryUtils.findAutoBlockBlock();
/*      */       
/*  805 */       if (blockSlot == -1) {
/*      */         return;
/*      */       }
/*      */       
/*  809 */       if (((String)this.autoBlockMode.get()).equalsIgnoreCase("Matrix") && blockSlot - 36 != this.slot) {
/*  810 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(blockSlot - 36));
/*      */       }
/*      */       
/*  813 */       if (((String)this.autoBlockMode.get()).equalsIgnoreCase("Spoof")) {
/*  814 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(blockSlot - 36));
/*  815 */         itemStack = mc.getThePlayer().getInventoryContainer().getSlot(blockSlot).getStack();
/*      */       } else {
/*  817 */         mc.getThePlayer().getInventory().setCurrentItem(blockSlot - 36);
/*  818 */         mc.getPlayerController().updateController();
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  823 */     if (itemStack != null && itemStack.getItem() != null && itemStack.getItem() instanceof net.minecraft.item.ItemBlock) {
/*  824 */       IItemBlock itemBlock = itemStack.getItem().asItemBlock();
/*  825 */       IBlock block = itemBlock.getBlock();
/*  826 */       if (InventoryUtils.BLOCK_BLACKLIST.contains(block) || !block.isFullCube(block.getDefaultState()) || itemStack.getStackSize() <= 0)
/*      */         return; 
/*      */     } 
/*  829 */     if (mc.getPlayerController().onPlayerRightClick(mc.getThePlayer(), mc.getTheWorld(), itemStack, (towerActive ? this.towerPlace : this.targetPlace).getBlockPos(), (towerActive ? this.towerPlace : this.targetPlace)
/*  830 */         .getEnumFacing(), (towerActive ? this.towerPlace : this.targetPlace).getVec3())) {
/*  831 */       this.delayTimer.reset();
/*  832 */       this.delay = !((Boolean)this.placeableDelay.get()).booleanValue() ? 0L : TimeUtils.randomDelay(((Integer)this.minDelayValue.get()).intValue(), ((Integer)this.maxDelayValue.get()).intValue());
/*      */       
/*  834 */       if (mc.getThePlayer().getOnGround()) {
/*  835 */         float modifier = ((Float)this.speedModifierValue.get()).floatValue();
/*      */ 
/*      */         
/*  838 */         mc.getThePlayer().setMotionX(mc.getThePlayer().getMotionX() * modifier);
/*  839 */         mc.getThePlayer().setMotionZ(mc.getThePlayer().getMotionZ() * modifier);
/*      */       } 
/*      */       
/*  842 */       if (((Boolean)this.swingValue.get()).booleanValue()) {
/*  843 */         mc.getThePlayer().swingItem();
/*      */       } else {
/*  845 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketAnimation());
/*      */       } 
/*      */     } 
/*      */     
/*  849 */     if (towerActive) {
/*  850 */       this.towerPlace = null;
/*      */     } else {
/*  852 */       this.targetPlace = null;
/*      */     } 
/*  854 */     if (!((Boolean)this.stayAutoBlock.get()).booleanValue() && blockSlot >= 0 && !((String)this.autoBlockMode.get()).equalsIgnoreCase("Switch")) {
/*  855 */       mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(mc.getThePlayer().getInventory().getCurrentItem()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onDisable() {
/*  864 */     if (mc.getThePlayer() == null)
/*      */       return; 
/*  866 */     if (mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindSneak())) {
/*  867 */       mc.getGameSettings().getKeyBindSneak().setPressed(false);
/*      */       
/*  869 */       if (this.eagleSneaking) {
/*  870 */         mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketEntityAction((IEntity)mc.getThePlayer(), ICPacketEntityAction.WAction.STOP_SNEAKING));
/*      */       }
/*      */     } 
/*  873 */     if (mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindRight())) {
/*  874 */       mc.getGameSettings().getKeyBindRight().setPressed(false);
/*      */     }
/*  876 */     if (mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindLeft())) {
/*  877 */       mc.getGameSettings().getKeyBindLeft().setPressed(false);
/*      */     }
/*  879 */     this.lockRotation = null;
/*  880 */     this.lookupRotation = null;
/*  881 */     mc.getTimer().setTimerSpeed(1.0F);
/*  882 */     this.shouldGoDown = false;
/*  883 */     this.faceBlock = false;
/*      */     
/*  885 */     if (this.lastSlot != mc.getThePlayer().getInventory().getCurrentItem() && ((String)this.autoBlockMode.get()).equalsIgnoreCase("switch")) {
/*  886 */       mc.getThePlayer().getInventory().setCurrentItem(this.lastSlot);
/*  887 */       mc.getPlayerController().updateController();
/*      */     } 
/*      */     
/*  890 */     if (this.slot != mc.getThePlayer().getInventory().getCurrentItem() && ((String)this.autoBlockMode.get()).equalsIgnoreCase("spoof")) {
/*  891 */       mc.getNetHandler().addToSendQueue((IPacket)classProvider.createCPacketHeldItemChange(mc.getThePlayer().getInventory().getCurrentItem()));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public void onMove(MoveEvent event) {
/*  901 */     if (!((Boolean)this.safeWalkValue.get()).booleanValue() || this.shouldGoDown) {
/*      */       return;
/*      */     }
/*  904 */     if (((Boolean)this.airSafeValue.get()).booleanValue() || mc.getThePlayer().getOnGround())
/*  905 */       event.setSafeWalk(true); 
/*      */   }
/*      */   
/*      */   @EventTarget
/*      */   public void onJump(JumpEvent event) {
/*  910 */     if (towerActivation()) {
/*  911 */       event.cancelEvent();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public void onRender2D(Render2DEvent event) {
/*  921 */     this.progress = (float)(System.currentTimeMillis() - this.lastMS) / 100.0F;
/*  922 */     if (this.progress >= 1.0F) this.progress = 1.0F;
/*      */     
/*  924 */     String counterMode = (String)this.counterDisplayValue.get();
/*  925 */     IScaledResolution scaledResolution = classProvider.createScaledResolution(mc);
/*      */     
/*  927 */     String info = getBlocksAmount() + " blocks";
/*  928 */     int infoWidth = Fonts.font25.getStringWidth(info);
/*  929 */     int infoWidth2 = Fonts.minecraftFont.getStringWidth(getBlocksAmount() + "");
/*  930 */     if (counterMode.equalsIgnoreCase("simple")) {
/*  931 */       Fonts.minecraftFont.drawString(getBlocksAmount() + "", (scaledResolution.getScaledWidth() / 2 - infoWidth2 / 2 - 1), (scaledResolution.getScaledHeight() / 2 - 36), -16777216, false);
/*  932 */       Fonts.minecraftFont.drawString(getBlocksAmount() + "", (scaledResolution.getScaledWidth() / 2 - infoWidth2 / 2 + 1), (scaledResolution.getScaledHeight() / 2 - 36), -16777216, false);
/*  933 */       Fonts.minecraftFont.drawString(getBlocksAmount() + "", (scaledResolution.getScaledWidth() / 2 - infoWidth2 / 2), (scaledResolution.getScaledHeight() / 2 - 35), -16777216, false);
/*  934 */       Fonts.minecraftFont.drawString(getBlocksAmount() + "", (scaledResolution.getScaledWidth() / 2 - infoWidth2 / 2), (scaledResolution.getScaledHeight() / 2 - 37), -16777216, false);
/*  935 */       Fonts.minecraftFont.drawString(getBlocksAmount() + "", (scaledResolution.getScaledWidth() / 2 - infoWidth2 / 2), (scaledResolution.getScaledHeight() / 2 - 36), -1, false);
/*      */     } 
/*  937 */     if (counterMode.equalsIgnoreCase("advanced")) {
/*  938 */       boolean canRenderStack = (this.slot >= 0 && this.slot < 9 && mc.getThePlayer().getInventory().getMainInventory().get(this.slot) != null && ((IItemStack)mc.getThePlayer().getInventory().getMainInventory().get(this.slot)).getItem() != null && ((IItemStack)mc.getThePlayer().getInventory().getMainInventory().get(this.slot)).getItem() instanceof net.minecraft.item.ItemBlock);
/*      */       
/*  940 */       RenderUtils.drawRect(scaledResolution.getScaledWidth() / 2 - infoWidth / 2 - 4, scaledResolution.getScaledHeight() / 2 - 40, scaledResolution.getScaledWidth() / 2 + infoWidth / 2 + 4, scaledResolution.getScaledHeight() / 2 - 39, (getBlocksAmount() > 1) ? -1 : -61424);
/*  941 */       RenderUtils.drawRect(scaledResolution.getScaledWidth() / 2 - infoWidth / 2 - 4, scaledResolution.getScaledHeight() / 2 - 39, scaledResolution.getScaledWidth() / 2 + infoWidth / 2 + 4, scaledResolution.getScaledHeight() / 2 - 26, -1610612736);
/*      */       
/*  943 */       if (canRenderStack) {
/*  944 */         RenderUtils.drawRect(scaledResolution.getScaledWidth() / 2 - infoWidth / 2 - 4, scaledResolution.getScaledHeight() / 2 - 26, scaledResolution.getScaledWidth() / 2 + infoWidth / 2 + 4, scaledResolution.getScaledHeight() / 2 - 5, -1610612736);
/*  945 */         GlStateManager.func_179094_E();
/*  946 */         GlStateManager.func_179109_b((scaledResolution.getScaledWidth() / 2 - 8), (scaledResolution.getScaledHeight() / 2 - 25), (scaledResolution.getScaledWidth() / 2 - 8));
/*  947 */         renderItemStack((IItemStack)mc.getThePlayer().getInventory().getMainInventory().get(this.slot), 0, 0);
/*  948 */         GlStateManager.func_179121_F();
/*      */       } 
/*  950 */       GlStateManager.func_179117_G();
/*      */       
/*  952 */       Fonts.font25.drawCenteredString(info, (scaledResolution.getScaledWidth() / 2), (scaledResolution.getScaledHeight() / 2 - 36), -1);
/*      */     } 
/*      */     
/*  955 */     if (counterMode.equalsIgnoreCase("sigma")) {
/*  956 */       GlStateManager.func_179109_b(0.0F, -14.0F - this.progress * 4.0F, 0.0F);
/*      */       
/*  958 */       GL11.glEnable(3042);
/*  959 */       GL11.glDisable(3553);
/*  960 */       GL11.glBlendFunc(770, 771);
/*  961 */       GL11.glEnable(2848);
/*  962 */       GL11.glColor4f(0.15F, 0.15F, 0.15F, this.progress);
/*  963 */       GL11.glBegin(6);
/*  964 */       GL11.glVertex2d((scaledResolution.getScaledWidth() / 2 - 3), (scaledResolution.getScaledHeight() - 60));
/*  965 */       GL11.glVertex2d((scaledResolution.getScaledWidth() / 2), (scaledResolution.getScaledHeight() - 57));
/*  966 */       GL11.glVertex2d((scaledResolution.getScaledWidth() / 2 + 3), (scaledResolution.getScaledHeight() - 60));
/*  967 */       GL11.glEnd();
/*  968 */       GL11.glEnable(3553);
/*  969 */       GL11.glDisable(3042);
/*  970 */       GL11.glDisable(2848);
/*      */       
/*  972 */       RenderUtils.drawRoundedRect(scaledResolution.getScaledWidth() / 2.0F - (infoWidth / 2) - 4.0F, scaledResolution.getScaledHeight() - 60.0F, scaledResolution.getScaledWidth() / 2.0F + (infoWidth / 2) + 4.0F, scaledResolution.getScaledHeight() - 74.0F, 2.0F, (new Color(0.15F, 0.15F, 0.15F, this.progress)).getRGB());
/*  973 */       GlStateManager.func_179117_G();
/*  974 */       Fonts.font25.drawCenteredString(info, (scaledResolution.getScaledWidth() / 2) + 0.1F, (scaledResolution.getScaledHeight() - 70), (new Color(1.0F, 1.0F, 1.0F, 0.8F * this.progress)).getRGB(), false);
/*  975 */       GlStateManager.func_179109_b(0.0F, 14.0F + this.progress * 4.0F, 0.0F);
/*      */     } 
/*      */     
/*  978 */     if (counterMode.equalsIgnoreCase("novoline")) {
/*  979 */       if (this.slot >= 0 && this.slot < 9 && mc.getThePlayer().getInventory().getMainInventory().get(this.slot) != null && ((IItemStack)mc.getThePlayer().getInventory().getMainInventory().get(this.slot)).getItem() != null && ((IItemStack)mc.getThePlayer().getInventory().getMainInventory().get(this.slot)).getItem() instanceof net.minecraft.item.ItemBlock) {
/*      */         
/*  981 */         GlStateManager.func_179094_E();
/*  982 */         GlStateManager.func_179109_b((scaledResolution.getScaledWidth() / 2 - 22), (scaledResolution.getScaledHeight() / 2 + 16), (scaledResolution.getScaledWidth() / 2 - 22));
/*  983 */         renderItemStack((IItemStack)mc.getThePlayer().getInventory().getMainInventory().get(this.slot), 0, 0);
/*  984 */         GlStateManager.func_179121_F();
/*      */       } 
/*  986 */       GlStateManager.func_179117_G();
/*      */       
/*  988 */       Fonts.minecraftFont.drawString(getBlocksAmount() + " blocks", (scaledResolution.getScaledWidth() / 2), (scaledResolution.getScaledHeight() / 2 + 20), -1, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void renderItemStack(IItemStack stack, int x, int y) {
/*  993 */     GlStateManager.func_179094_E();
/*  994 */     GlStateManager.func_179091_B();
/*  995 */     GlStateManager.func_179147_l();
/*  996 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/*  997 */     RenderHelper.func_74520_c();
/*  998 */     mc.getRenderItem().renderItemAndEffectIntoGUI(stack, x, y);
/*  999 */     mc.getRenderItem().renderItemOverlays(mc.getFontRendererObj(), stack, x, y);
/* 1000 */     RenderHelper.func_74518_a();
/* 1001 */     GlStateManager.func_179101_C();
/* 1002 */     GlStateManager.func_179084_k();
/* 1003 */     GlStateManager.func_179121_F();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @EventTarget
/*      */   public void onRender3D(Render3DEvent event) {
/* 1013 */     if (!((Boolean)this.markValue.get()).booleanValue()) {
/*      */       return;
/*      */     }
/* 1016 */     double yaw = Math.toRadians(mc.getThePlayer().getRotationYaw());
/* 1017 */     int x = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? (int)Math.round(-Math.sin(yaw)) : mc.getThePlayer().getHorizontalFacing().getDirectionVec().getX();
/* 1018 */     int z = ((Boolean)this.omniDirectionalExpand.get()).booleanValue() ? (int)Math.round(Math.cos(yaw)) : mc.getThePlayer().getHorizontalFacing().getDirectionVec().getZ();
/*      */     
/* 1020 */     for (int i = 0; i < ((((String)this.modeValue.get()).equalsIgnoreCase("Expand") && !towerActivation()) ? (((Integer)this.expandLengthValue.get()).intValue() + 1) : 2); i++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1029 */       WBlockPos WBlockPos = new WBlockPos(mc.getThePlayer().getPosX() + (x * i), (!towerActivation() && (((Boolean)this.sameYValue.get()).booleanValue() || ((((Boolean)this.autoJumpValue.get()).booleanValue() || (((Boolean)this.smartSpeedValue.get()).booleanValue() && Retreat.moduleManager.getModule(Speed.class).getState())) && mc.getGameSettings().isKeyDown(mc.getGameSettings().getKeyBindJump()))) && this.launchY <= mc.getThePlayer().getPosY()) ? (this.launchY - 1) : (mc.getThePlayer().getPosY() - ((mc.getThePlayer().getPosY() == (int)mc.getThePlayer().getPosY() + 0.5D) ? 0.0D : 1.0D) - (this.shouldGoDown ? 1.0D : 0.0D)), mc.getThePlayer().getPosZ() + (z * i));
/* 1030 */       PlaceInfo placeInfo = PlaceInfo.get(WBlockPos);
/*      */       
/* 1032 */       if (BlockUtils.isReplaceable(WBlockPos) && placeInfo != null) {
/* 1033 */         RenderUtils.drawBlockBox(WBlockPos, new Color(((Integer)this.redValue.get()).intValue(), ((Integer)this.greenValue.get()).intValue(), ((Integer)this.blueValue.get()).intValue(), ((Integer)this.alphaValue.get()).intValue()), false);
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private double calcStepSize(double range) {
/* 1039 */     double accuracy = ((Integer)this.searchAccuracyValue.get()).intValue();
/* 1040 */     accuracy += accuracy % 2.0D;
/* 1041 */     if (range / accuracy < 0.01D)
/* 1042 */       return 0.01D; 
/* 1043 */     return range / accuracy;
/*      */   }
/*      */   private boolean search(WBlockPos WBlockPosition, boolean checks) {
/* 1046 */     return search(WBlockPosition, checks, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean search(WBlockPos blockPosition, boolean checks, boolean towerActive) {
/* 1057 */     this.faceBlock = false;
/*      */     
/* 1059 */     double xzRV = ((Float)this.xzRangeValue.get()).floatValue();
/* 1060 */     double xzSSV = calcStepSize(xzRV);
/* 1061 */     double yRV = ((Float)this.yRangeValue.get()).floatValue();
/* 1062 */     double ySSV = calcStepSize(yRV);
/*      */     
/* 1064 */     double xSearchFace = 0.0D;
/* 1065 */     double ySearchFace = 0.0D;
/* 1066 */     double zSearchFace = 0.0D;
/* 1067 */     if (!BlockUtils.isReplaceable(blockPosition)) {
/* 1068 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1073 */     boolean staticYawMode = (((String)this.rotationLookupValue.get()).equalsIgnoreCase("AAC") || (((String)this.rotationLookupValue.get()).equalsIgnoreCase("same") && (((String)this.rotationModeValue.get()).equalsIgnoreCase("AAC") || (((String)this.rotationModeValue.get()).contains("Static") && !((String)this.rotationModeValue.get()).equalsIgnoreCase("static3")))));
/*      */     
/* 1075 */     WVec3 eyesPos = new WVec3(mc.getThePlayer().getPosX(), mc.getThePlayer().getEntityBoundingBox().getMinY() + mc.getThePlayer().getEyeHeight(), mc.getThePlayer().getPosZ());
/*      */     
/* 1077 */     PlaceRotation placeRotation = null;
/*      */     
/* 1079 */     for (EnumFacingType facingType : EnumFacingType.values()) {
/* 1080 */       IEnumFacing side = classProvider.getEnumFacing(facingType);
/* 1081 */       WBlockPos neighbor = blockPosition.offset(side);
/*      */       
/* 1083 */       if (BlockUtils.canBeClicked(neighbor)) {
/*      */ 
/*      */         
/* 1086 */         WVec3 dirVec = new WVec3(side.getDirectionVec());
/*      */         double xSearch;
/* 1088 */         for (xSearch = 0.5D - xzRV / 2.0D; xSearch <= 0.5D + xzRV / 2.0D; xSearch += xzSSV) {
/* 1089 */           double ySearch; for (ySearch = 0.5D - yRV / 2.0D; ySearch <= 0.5D + yRV / 2.0D; ySearch += ySSV) {
/* 1090 */             double zSearch; for (zSearch = 0.5D - xzRV / 2.0D; zSearch <= 0.5D + xzRV / 2.0D; zSearch += xzSSV) {
/* 1091 */               WVec3 posVec = (new WVec3((WVec3i)blockPosition)).addVector(xSearch, ySearch, zSearch);
/* 1092 */               double distanceSqPosVec = eyesPos.squareDistanceTo(posVec);
/* 1093 */               WVec3 hitVec = posVec.add(new WVec3(dirVec.getXCoord() * 0.5D, dirVec.getYCoord() * 0.5D, dirVec.getZCoord() * 0.5D));
/*      */               
/* 1095 */               if (!checks || (eyesPos.squareDistanceTo(hitVec) <= 18.0D && distanceSqPosVec <= eyesPos.squareDistanceTo(posVec.add(dirVec)) && mc.getTheWorld().rayTraceBlocks(eyesPos, hitVec, false, true, false) == null))
/*      */               {
/*      */ 
/*      */                 
/* 1099 */                 for (int i = 0; i < (staticYawMode ? 2 : 1); i++) {
/* 1100 */                   double diffX = (staticYawMode && i == 0) ? 0.0D : (hitVec.getXCoord() - eyesPos.getXCoord());
/* 1101 */                   double diffY = hitVec.getYCoord() - eyesPos.getYCoord();
/* 1102 */                   double diffZ = (staticYawMode && i == 1) ? 0.0D : (hitVec.getZCoord() - eyesPos.getZCoord());
/*      */                   
/* 1104 */                   double diffXZ = MathHelper.func_76133_a(diffX * diffX + diffZ * diffZ);
/*      */ 
/*      */ 
/*      */                   
/* 1108 */                   Rotation rotation = new Rotation(MathHelper.func_76142_g((float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0F), MathHelper.func_76142_g((float)-Math.toDegrees(Math.atan2(diffY, diffXZ))));
/*      */ 
/*      */                   
/* 1111 */                   this.lookupRotation = rotation;
/*      */                   
/* 1113 */                   if (((String)this.rotationModeValue.get()).equalsIgnoreCase("hypixel") && (((Boolean)this.keepRotOnJumpValue.get()).booleanValue() || !mc.getGameSettings().getKeyBindJump().isKeyDown())) {
/* 1114 */                     rotation = new Rotation(mc.getThePlayer().getRotationYaw() + ((mc.getThePlayer().getMovementInput().getMoveForward() > 0.0F) ? '´' : false) + ((Integer)this.HypixelYawValue.get()).intValue(), ((Integer)this.HypixelPitchValue.get()).intValue());
/*      */                   }
/* 1116 */                   if (((String)this.rotationModeValue.get()).equalsIgnoreCase("static") && (((Boolean)this.keepRotOnJumpValue.get()).booleanValue() || !mc.getGameSettings().getKeyBindJump().isKeyDown())) {
/* 1117 */                     rotation = new Rotation(MovementUtils.getScaffoldRotation(mc.getThePlayer().getRotationYaw(), mc.getThePlayer().getMoveForward()), ((Float)this.staticPitchValue.get()).floatValue());
/*      */                   }
/* 1119 */                   if ((((String)this.rotationModeValue.get()).equalsIgnoreCase("static2") || ((String)this.rotationModeValue.get()).equalsIgnoreCase("static3")) && (((Boolean)this.keepRotOnJumpValue.get()).booleanValue() || !mc.getGameSettings().getKeyBindJump().isKeyDown())) {
/* 1120 */                     rotation = new Rotation(rotation.getYaw(), ((Float)this.staticPitchValue.get()).floatValue());
/*      */                   }
/* 1122 */                   if (((String)this.rotationModeValue.get()).equalsIgnoreCase("custom") && (((Boolean)this.keepRotOnJumpValue.get()).booleanValue() || !mc.getGameSettings().getKeyBindJump().isKeyDown())) {
/* 1123 */                     rotation = new Rotation(mc.getThePlayer().getRotationYaw() + ((Float)this.customYawValue.get()).floatValue(), ((Float)this.customPitchValue.get()).floatValue());
/*      */                   }
/* 1125 */                   WVec3 rotationVector = RotationUtils.getVectorForRotation(((String)this.rotationLookupValue.get()).equalsIgnoreCase("same") ? rotation : this.lookupRotation);
/* 1126 */                   WVec3 vector = eyesPos.addVector(rotationVector.getXCoord() * 4.0D, rotationVector.getYCoord() * 4.0D, rotationVector.getZCoord() * 4.0D);
/* 1127 */                   IMovingObjectPosition obj = mc.getTheWorld().rayTraceBlocks(eyesPos, vector, false, false, true);
/*      */                   
/* 1129 */                   if (obj.getTypeOfHit() == IMovingObjectPosition.WMovingObjectType.BLOCK && obj.getBlockPos().equals(neighbor))
/*      */                   {
/*      */                     
/* 1132 */                     if (placeRotation == null || RotationUtils.getRotationDifference(rotation) < RotationUtils.getRotationDifference(placeRotation.getRotation()))
/* 1133 */                       placeRotation = new PlaceRotation(new PlaceInfo(neighbor, side.getOpposite(), hitVec), rotation);  } 
/*      */                 }  } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/* 1140 */     if (placeRotation == null) return false;
/*      */     
/* 1142 */     if (((Boolean)this.rotationsValue.get()).booleanValue()) {
/* 1143 */       if (((Float)this.minTurnSpeed.get()).floatValue() < 180.0F) {
/* 1144 */         Rotation limitedRotation = RotationUtils.limitAngleChange(RotationUtils.serverRotation, placeRotation.getRotation(), RandomUtils.nextFloat(((Float)this.minTurnSpeed.get()).floatValue(), ((Float)this.maxTurnSpeed.get()).floatValue()));
/* 1145 */         if ((int)(10.0F * MathHelper.func_76142_g(limitedRotation.getYaw())) == (int)(10.0F * MathHelper.func_76142_g(placeRotation.getRotation().getYaw())) && 
/* 1146 */           (int)(10.0F * MathHelper.func_76142_g(limitedRotation.getPitch())) == (int)(10.0F * MathHelper.func_76142_g(placeRotation.getRotation().getPitch()))) {
/* 1147 */           RotationUtils.setTargetRotation(placeRotation.getRotation(), ((Integer)this.keepLengthValue.get()).intValue());
/* 1148 */           this.lockRotation = placeRotation.getRotation();
/* 1149 */           this.faceBlock = true;
/*      */         } else {
/* 1151 */           RotationUtils.setTargetRotation(limitedRotation, ((Integer)this.keepLengthValue.get()).intValue());
/* 1152 */           this.lockRotation = limitedRotation;
/* 1153 */           this.faceBlock = false;
/*      */         } 
/*      */       } else {
/* 1156 */         RotationUtils.setTargetRotation(placeRotation.getRotation(), ((Integer)this.keepLengthValue.get()).intValue());
/* 1157 */         this.lockRotation = placeRotation.getRotation();
/* 1158 */         this.faceBlock = true;
/*      */       } 
/*      */       
/* 1161 */       if (((String)this.rotationLookupValue.get()).equalsIgnoreCase("same")) {
/* 1162 */         this.lookupRotation = this.lockRotation;
/*      */       }
/*      */     } 
/* 1165 */     if (towerActive) {
/* 1166 */       this.towerPlace = placeRotation.getPlaceInfo();
/*      */     } else {
/* 1168 */       this.targetPlace = placeRotation.getPlaceInfo();
/*      */     } 
/* 1170 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getBlocksAmount() {
/* 1177 */     int amount = 0;
/* 1178 */     for (int i = 36; i < 45; i++) {
/* 1179 */       IItemStack itemStack = mc.getThePlayer().getInventoryContainer().getSlot(i).getStack();
/*      */       
/* 1181 */       if (itemStack != null && classProvider.isItemBlock(itemStack.getItem())) {
/* 1182 */         IBlock block = itemStack.getItem().asItemBlock().getBlock();
/*      */         
/* 1184 */         IItemStack heldItem = mc.getThePlayer().getHeldItem();
/*      */         
/* 1186 */         if ((heldItem != null && heldItem.equals(itemStack)) || (!InventoryUtils.BLOCK_BLACKLIST.contains(block) && !classProvider.isBlockBush(block))) {
/* 1187 */           amount += itemStack.getStackSize();
/*      */         }
/*      */       } 
/*      */     } 
/* 1191 */     return amount;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getTag() {
/* 1196 */     return towerActivation() ? ("Tower, " + (String)this.towerPlaceModeValue.get()) : (String)this.placeModeValue.get();
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ScaffoldLB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */