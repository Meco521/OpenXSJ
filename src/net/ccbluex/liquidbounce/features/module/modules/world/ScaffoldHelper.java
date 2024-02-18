/*    */ package net.ccbluex.liquidbounce.features.module.modules.world;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import net.ccbluex.liquidbounce.Retreat;
/*    */ import net.ccbluex.liquidbounce.event.EventTarget;
/*    */ import net.ccbluex.liquidbounce.event.UpdateEvent;
/*    */ import net.ccbluex.liquidbounce.features.module.Module;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleCategory;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.features.module.modules.movement.Parkour;
/*    */ import net.ccbluex.liquidbounce.utils.MinecraftInstance;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ @ModuleInfo(name = "ScaffoldHelper", description = "For GrimAC", category = ModuleCategory.WORLD)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J\006\020\t\032\0020\nJ\b\020\013\032\0020\nH\026J\020\020\f\032\0020\n2\006\020\r\032\0020\016H\007R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000¨\006\017"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/world/ScaffoldHelper;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "jumpModeValue", "Lnet/ccbluex/liquidbounce/value/ListValue;", "modeValue", "scaffoldModeValue", "timerValue", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "jump", "", "onDisable", "onUpdate", "event", "Lnet/ccbluex/liquidbounce/event/UpdateEvent;", "XSJClient"})
/*    */ public final class ScaffoldHelper
/*    */   extends Module
/*    */ {
/* 25 */   private final ListValue modeValue = new ListValue("Mode", new String[] { "State" }, "State");
/*    */   
/* 27 */   private final ListValue scaffoldModeValue = new ListValue("Scaffold Mode", new String[] { "Scaffold", "Scaffold3", "Scaffold2" }, "ScaffoldNew");
/*    */   
/* 29 */   private final ListValue jumpModeValue = new ListValue("Jump Mode", new String[] { "mc", "mc2", "MotionY", "Key", "Parkour", "Off" }, "Off");
/*    */   
/* 31 */   private final BoolValue timerValue = new BoolValue("On Ground Timer", true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void jump() {
/* 40 */     if (MinecraftInstance.mc2.field_71439_g.field_70122_E || !MinecraftInstance.mc2.field_71439_g.field_70160_al) {
/* 41 */       String str = (String)this.jumpModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case 3478:
/* 42 */           if (str.equals("mc")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().jump(); }  break;
/*    */         case 1241855875:
/* 44 */           if (str.equals("motiony")) { if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  MinecraftInstance.mc.getThePlayer().setMotionY(0.42D); }  break;case 107868: if (str.equals("mc2"))
/* 45 */             MinecraftInstance.mc2.field_71439_g.func_70664_aZ();  break;case 106079: if (str.equals("key")) {
/* 46 */             MinecraftInstance.mc2.field_71474_y.field_74314_A.field_74513_e = true;
/* 47 */             MinecraftInstance.mc2.field_71474_y.field_74314_A.field_74513_e = false;
/*    */           } 
/*    */           break; }
/*    */     
/*    */     } 
/*    */   }
/*    */   public void onDisable() {
/* 54 */     String str = (String)this.scaffoldModeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*    */     
/*    */     { case -2047971588:
/* 57 */         if (str.equals("scaffold2")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold2.class) == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold2.class).setState(false); }  break;case -2047971587: if (str.equals("scaffold3")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold3.class) == null)
/*    */             Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold3.class).setState(false); }  break;case -897347594: if (str.equals("scaffold")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold.class) == null)
/* 59 */             Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold.class).setState(false); }  break; }  Retreat.INSTANCE.getModuleManager().get(Parkour.class).setState(false);
/* 60 */     Retreat.INSTANCE.getModuleManager().get(Timer.class).setState(false);
/*    */     
/* 62 */     MinecraftInstance.mc.getGameSettings().getKeyBindJump().setPressed(false);
/* 63 */     super.onDisable();
/*    */   }
/*    */   @EventTarget
/*    */   public final void onUpdate(@NotNull UpdateEvent event) {
/* 67 */     Intrinsics.checkParameterIsNotNull(event, "event"); if (Intrinsics.areEqual(this.jumpModeValue.get(), "Parkour")) {
/* 68 */       if (Retreat.INSTANCE.getModuleManager().get(Parkour.class) == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Parkour.class).setState(true);
/*    */     } else {
/* 70 */       if (Retreat.INSTANCE.getModuleManager().get(Parkour.class) == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Parkour.class).setState(false);
/* 71 */       jump();
/*    */     } 
/*    */     
/* 74 */     if (MinecraftInstance.mc.getThePlayer() == null) Intrinsics.throwNpe();  if (MinecraftInstance.mc.getThePlayer().getOnGround())
/* 75 */     { if (((Boolean)this.timerValue.get()).booleanValue()) {
/* 76 */         if (Retreat.INSTANCE.getModuleManager().get(Timer.class) == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Timer.class).setState(true);
/*    */       } 
/* 78 */       String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (Intrinsics.areEqual(str.toLowerCase(), "state"))
/* 79 */       { str = (String)this.scaffoldModeValue.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode())
/*    */         
/*    */         { case -2047971588:
/* 82 */             if (str.equals("scaffold2")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold2.class) == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold2.class).setState(false); }  break;
/*    */           case -2047971587: if (str.equals("scaffold3")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold3.class) == null)
/*    */                 Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold3.class).setState(false); }  break;
/*    */           case -897347594: if (str.equals("scaffold")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold.class) == null)
/* 86 */                 Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold.class).setState(false); }  break; }  }  } else { if (((Boolean)this.timerValue.get()).booleanValue())
/* 87 */         Retreat.INSTANCE.getModuleManager().get(Timer.class).setState(false); 
/* 88 */       String str = (String)this.modeValue.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); if (Intrinsics.areEqual(str.toLowerCase(), "state")) {
/* 89 */         str = (String)this.scaffoldModeValue.get(); bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) {
/*    */           
/*    */           case -2047971588:
/* 92 */             if (str.equals("scaffold2")) { if (Retreat.INSTANCE.getModuleManager().get(Scaffold2.class) == null) Intrinsics.throwNpe();  Retreat.INSTANCE.getModuleManager().get(Scaffold2.class).setState(true); }
/*    */             
/*    */             break;
/*    */           case -2047971587:
/*    */             if (str.equals("scaffold3")) {
/*    */               if (Retreat.INSTANCE.getModuleManager().get(Scaffold3.class) == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               Retreat.INSTANCE.getModuleManager().get(Scaffold3.class).setState(true);
/*    */             } 
/*    */             break;
/*    */           case -897347594:
/*    */             if (str.equals("scaffold")) {
/*    */               if (Retreat.INSTANCE.getModuleManager().get(Scaffold.class) == null)
/*    */                 Intrinsics.throwNpe(); 
/*    */               Retreat.INSTANCE.getModuleManager().get(Scaffold.class).setState(true);
/*    */             } 
/*    */             break;
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\world\ScaffoldHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */