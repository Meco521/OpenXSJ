package net.ccbluex.liquidbounce.ui.client.hud.element;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Retention(AnnotationRetention.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000 \n\002\030\002\n\002\020\033\n\000\n\002\020\016\n\000\n\002\020\013\n\002\b\003\n\002\020\b\n\002\b\005\b\002\030\0002\0020\001B:\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005\022\b\b\002\020\006\032\0020\005\022\b\b\002\020\007\032\0020\005\022\b\b\002\020\b\032\0020\t\022\b\b\002\020\n\032\0020\005R\017\020\n\032\0020\005¢\006\006\032\004\b\n\020\013R\017\020\007\032\0020\005¢\006\006\032\004\b\007\020\013R\017\020\006\032\0020\005¢\006\006\032\004\b\006\020\013R\017\020\002\032\0020\003¢\006\006\032\004\b\002\020\fR\017\020\b\032\0020\t¢\006\006\032\004\b\b\020\rR\017\020\004\032\0020\005¢\006\006\032\004\b\004\020\013¨\006\016"}, d2 = {"Lnet/ccbluex/liquidbounce/ui/client/hud/element/ElementInfo;", "", "name", "", "single", "", "force", "disableScale", "priority", "", "blur", "()Z", "()Ljava/lang/String;", "()I", "XSJClient"})
public @interface ElementInfo {
  String name();
  
  boolean single() default false;
  
  boolean force() default false;
  
  boolean disableScale() default false;
  
  int priority() default 0;
  
  boolean blur() default false;
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\hud\element\ElementInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */