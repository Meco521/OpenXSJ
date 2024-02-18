/*    */ package net.ccbluex.liquidbounce.features.module.modules.misc;
/*    */ import net.ccbluex.liquidbounce.value.ListValue;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import tomk.betterfps.RivensFullMath;
/*    */ import tomk.betterfps.RivensHalfMath;
/*    */ import tomk.betterfps.RivensMath;
/*    */ import tomk.betterfps.TaylorMath;
/*    */ 
/*    */ @ModuleInfo(name = "BetterFPS", category = ModuleCategory.MISC, description = ":)")
/*    */ @Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\007\n\002\b\004\b\007\030\0002\0020\001B\005¢\006\002\020\002J\025\020!\032\004\030\0010\"2\006\020#\032\0020\"¢\006\002\020$J\025\020%\032\004\030\0010\"2\006\020#\032\0020\"¢\006\002\020$R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\nR\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\r\020\016R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022R\021\020\023\032\0020\024¢\006\b\n\000\032\004\b\025\020\026R\021\020\027\032\0020\030¢\006\b\n\000\032\004\b\031\020\032R\021\020\033\032\0020\004¢\006\b\n\000\032\004\b\034\020\006R\021\020\035\032\0020\036¢\006\b\n\000\032\004\b\037\020 ¨\006&"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/modules/misc/BetterFPS;", "Lnet/ccbluex/liquidbounce/features/module/Module;", "()V", "cosMode", "Lnet/ccbluex/liquidbounce/value/ListValue;", "getCosMode", "()Lnet/ccbluex/liquidbounce/value/ListValue;", "libGDX", "Ltomk/betterfps/LibGDXMath;", "getLibGDX", "()Ltomk/betterfps/LibGDXMath;", "newMC", "Ltomk/betterfps/NewMCMath;", "getNewMC", "()Ltomk/betterfps/NewMCMath;", "rivens", "Ltomk/betterfps/RivensMath;", "getRivens", "()Ltomk/betterfps/RivensMath;", "rivensFull", "Ltomk/betterfps/RivensFullMath;", "getRivensFull", "()Ltomk/betterfps/RivensFullMath;", "rivensHalf", "Ltomk/betterfps/RivensHalfMath;", "getRivensHalf", "()Ltomk/betterfps/RivensHalfMath;", "sinMode", "getSinMode", "taylor", "Ltomk/betterfps/TaylorMath;", "getTaylor", "()Ltomk/betterfps/TaylorMath;", "cos", "", "value", "(F)Ljava/lang/Float;", "sin", "XSJClient"})
/*    */ public final class BetterFPS extends Module {
/*    */   @NotNull
/* 13 */   private final LibGDXMath libGDX = new LibGDXMath(); @NotNull public final LibGDXMath getLibGDX() { return this.libGDX; } @NotNull
/* 14 */   private final RivensFullMath rivensFull = new RivensFullMath(); @NotNull public final RivensFullMath getRivensFull() { return this.rivensFull; } @NotNull
/* 15 */   private final RivensHalfMath rivensHalf = new RivensHalfMath(); @NotNull public final RivensHalfMath getRivensHalf() { return this.rivensHalf; } @NotNull
/* 16 */   private final RivensMath rivens = new RivensMath(); @NotNull public final RivensMath getRivens() { return this.rivens; } @NotNull
/* 17 */   private final TaylorMath taylor = new TaylorMath(); @NotNull public final TaylorMath getTaylor() { return this.taylor; } @NotNull
/* 18 */   private final NewMCMath newMC = new NewMCMath(); @NotNull public final NewMCMath getNewMC() { return this.newMC; }
/*    */    @NotNull
/* 20 */   private final ListValue sinMode = new ListValue("SinMode", new String[] { "Vanilla", "Taylor", "LibGDX", "RivensFull", "RivensHalf", "Rivens", "Java", "1.16" }, "Vanilla"); @NotNull public final ListValue getSinMode() { return this.sinMode; } @NotNull
/* 21 */   private final ListValue cosMode = new ListValue("CosMode", new String[] { "Vanilla", "Taylor", "LibGDX", "RivensFull", "RivensHalf", "Rivens", "Java", "1.16" }, "Vanilla"); @NotNull public final ListValue getCosMode() { return this.cosMode; } @Nullable
/*    */   public final Float sin(float value) {
/* 23 */     String str = (String)this.sinMode.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -880692189:
/* 24 */         if (str.equals("taylor"));
/*    */         break;
/*    */ 
/*    */       
/*    */       case 3254818:
/* 29 */         if (str.equals("java")) { double d = value; boolean bool1 = false; }  break;
/* 30 */       case 1505538: if (str.equals("1.16")); break;case 463453306: if (str.equals("rivensfull")); break;case -1103027562: if (str.equals("libgdx")); break;case -930658453: if (str.equals("rivens")); break;
/* 31 */       case 463493662: if (str.equals("rivenshalf")); break; }  return null;
/*    */   } @Nullable
/*    */   public final Float cos(float value) {
/* 34 */     String str = (String)this.cosMode.get(); boolean bool = false; if (str == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String");  Intrinsics.checkExpressionValueIsNotNull(str.toLowerCase(), "(this as java.lang.String).toLowerCase()"); str = str.toLowerCase(); switch (str.hashCode()) { case -880692189:
/* 35 */         if (str.equals("taylor"));
/*    */         break;
/*    */ 
/*    */       
/*    */       case 3254818:
/* 40 */         if (str.equals("java")) { double d = value; boolean bool1 = false; }  break;
/* 41 */       case 1505538: if (str.equals("1.16")); break;case 463453306: if (str.equals("rivensfull")); break;case -1103027562: if (str.equals("libgdx")); break;case -930658453: if (str.equals("rivens")); break;
/* 42 */       case 463493662: if (str.equals("rivenshalf")); break; }  return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\modules\misc\BetterFPS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */