/*    */ package net.ccbluex.liquidbounce.features.module.modules.render;
/*    */ import net.ccbluex.liquidbounce.features.module.ModuleInfo;
/*    */ import net.ccbluex.liquidbounce.value.BoolValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @ModuleInfo(name = "AntiBlind", description = "Cancels blindness effects.", category = ModuleCategory.RENDER)
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\b\007\030\0002\0020\001B\005¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006R\021\020\013\032\0020\004¢\006\b\n\000\032\004\b\f\020\006¨\006\r"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/render/AntiBlind;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "confusionEffect", "Lnet/ccbluex/liquidbounce/value/BoolValue;", "getConfusionEffect", "()Lnet/ccbluex/liquidbounce/value/BoolValue;", "fireEffect", "getFireEffect", "pumpkinEffect", "getPumpkinEffect", "scoreBoard", "getScoreBoard", "XSJClient"})
/*    */ public final class AntiBlind extends Module {
/*    */   @NotNull
/* 10 */   private final BoolValue confusionEffect = new BoolValue("Confusion", true); @NotNull public final BoolValue getConfusionEffect() { return this.confusionEffect; } @NotNull
/* 11 */   private final BoolValue pumpkinEffect = new BoolValue("Pumpkin", true); @NotNull public final BoolValue getPumpkinEffect() { return this.pumpkinEffect; } @NotNull
/* 12 */   private final BoolValue fireEffect = new BoolValue("RetreatClient", false); @NotNull public final BoolValue getFireEffect() { return this.fireEffect; } @NotNull
/* 13 */   private final BoolValue scoreBoard = new BoolValue("Scoreboard", false); @NotNull public final BoolValue getScoreBoard() { return this.scoreBoard; }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\render\AntiBlind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */