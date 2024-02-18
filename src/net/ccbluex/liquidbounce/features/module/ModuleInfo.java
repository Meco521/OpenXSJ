package net.ccbluex.liquidbounce.features.module;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import net.ccbluex.liquidbounce.api.MinecraftVersion;

@Retention(AnnotationRetention.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\0002\n\002\030\002\n\002\020\033\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\002\b\002\n\002\020\021\n\002\030\002\n\002\b\006\b\002\030\0002\0020\001BF\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b\022\b\b\002\020\t\032\0020\n\022\b\b\002\020\013\032\0020\n\022\016\b\002\020\f\032\b\022\004\022\0020\0160\rR\017\020\013\032\0020\n¢\006\006\032\004\b\013\020\017R\017\020\t\032\0020\n¢\006\006\032\004\b\t\020\017R\017\020\005\032\0020\006¢\006\006\032\004\b\005\020\020R\017\020\004\032\0020\003¢\006\006\032\004\b\004\020\021R\017\020\007\032\0020\b¢\006\006\032\004\b\007\020\022R\017\020\002\032\0020\003¢\006\006\032\004\b\002\020\021R\025\020\f\032\b\022\004\022\0020\0160\r¢\006\006\032\004\b\f\020\023¨\006\024"}, d2 = {"Lnet/ccbluex/liquidbounce/features/module/ModuleInfo;", "", "name", "", "description", "category", "Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "keyBind", "", "canEnable", "", "array", "supportedVersions", "", "Lnet/ccbluex/liquidbounce/api/MinecraftVersion;", "()Z", "()Lnet/ccbluex/liquidbounce/features/module/ModuleCategory;", "()Ljava/lang/String;", "()I", "()[Lnet/ccbluex/liquidbounce/api/MinecraftVersion;", "XSJClient"})
public @interface ModuleInfo {
  String name();
  
  String description();
  
  ModuleCategory category();
  
  int keyBind() default 0;
  
  boolean canEnable() default true;
  
  boolean array() default true;
  
  MinecraftVersion[] supportedVersions() default {MinecraftVersion.MC_1_8, MinecraftVersion.MC_1_12};
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\features\module\ModuleInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */