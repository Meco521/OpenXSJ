package net.ccbluex.liquidbounce.ui.client.clickgui.style;

import net.ccbluex.liquidbounce.ui.client.clickgui.Panel;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ButtonElement;
import net.ccbluex.liquidbounce.ui.client.clickgui.elements.ModuleElement;
import net.ccbluex.liquidbounce.utils.MinecraftInstance;

public abstract class Style extends MinecraftInstance {
  public abstract void drawPanel(int paramInt1, int paramInt2, Panel paramPanel);
  
  public abstract void drawDescription(int paramInt1, int paramInt2, String paramString);
  
  public abstract void drawButtonElement(int paramInt1, int paramInt2, ButtonElement paramButtonElement);
  
  public abstract void drawModuleElement(int paramInt1, int paramInt2, ModuleElement paramModuleElement);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounc\\ui\client\clickgui\style\Style.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */