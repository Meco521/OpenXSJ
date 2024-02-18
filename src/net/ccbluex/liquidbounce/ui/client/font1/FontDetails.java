package net.ccbluex.liquidbounce.ui.client.font1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FontDetails {
  String fontName();
  
  int fontSize() default -1;
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\font1\FontDetails.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */