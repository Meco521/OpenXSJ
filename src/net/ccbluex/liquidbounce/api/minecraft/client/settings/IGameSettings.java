package net.ccbluex.liquidbounce.api.minecraft.client.settings;

import java.util.Set;
import kotlin.Metadata;
import net.ccbluex.liquidbounce.api.minecraft.client.entity.player.WEnumPlayerModelParts;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000>\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\007\n\002\020\007\n\002\b\005\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\023\n\002\020\"\n\002\030\002\n\002\b\t\n\002\020\002\n\002\b\002\bf\030\0002\0020\001J\020\0201\032\0020\0032\006\0202\032\0020\025H&J\030\0203\032\002042\006\020(\032\0020*2\006\0205\032\0020\003H&R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\030\020\006\032\0020\003X¦\016¢\006\f\032\004\b\007\020\005\"\004\b\b\020\tR\030\020\n\032\0020\013X¦\016¢\006\f\032\004\b\f\020\r\"\004\b\016\020\017R\022\020\020\032\0020\021X¦\004¢\006\006\032\004\b\022\020\023R\022\020\024\032\0020\025X¦\004¢\006\006\032\004\b\026\020\027R\022\020\030\032\0020\025X¦\004¢\006\006\032\004\b\031\020\027R\022\020\032\032\0020\025X¦\004¢\006\006\032\004\b\033\020\027R\022\020\034\032\0020\025X¦\004¢\006\006\032\004\b\035\020\027R\022\020\036\032\0020\025X¦\004¢\006\006\032\004\b\037\020\027R\022\020 \032\0020\025X¦\004¢\006\006\032\004\b!\020\027R\022\020\"\032\0020\025X¦\004¢\006\006\032\004\b#\020\027R\022\020$\032\0020\025X¦\004¢\006\006\032\004\b%\020\027R\022\020&\032\0020\025X¦\004¢\006\006\032\004\b'\020\027R\030\020(\032\b\022\004\022\0020*0)X¦\004¢\006\006\032\004\b+\020,R\022\020-\032\0020\013X¦\004¢\006\006\032\004\b.\020\rR\022\020/\032\0020\021X¦\004¢\006\006\032\004\b0\020\023¨\0066"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IGameSettings;", "", "advancedItemTooltips", "", "getAdvancedItemTooltips", "()Z", "entityShadows", "getEntityShadows", "setEntityShadows", "(Z)V", "gammaSetting", "", "getGammaSetting", "()F", "setGammaSetting", "(F)V", "guiScale", "", "getGuiScale", "()I", "keyBindAttack", "Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "getKeyBindAttack", "()Lnet/ccbluex/liquidbounce/api/minecraft/client/settings/IKeyBinding;", "keyBindBack", "getKeyBindBack", "keyBindForward", "getKeyBindForward", "keyBindJump", "getKeyBindJump", "keyBindLeft", "getKeyBindLeft", "keyBindRight", "getKeyBindRight", "keyBindSneak", "getKeyBindSneak", "keyBindSprint", "getKeyBindSprint", "keyBindUseItem", "getKeyBindUseItem", "modelParts", "", "Lnet/ccbluex/liquidbounce/api/minecraft/client/entity/player/WEnumPlayerModelParts;", "getModelParts", "()Ljava/util/Set;", "mouseSensitivity", "getMouseSensitivity", "thirdPersonView", "getThirdPersonView", "isKeyDown", "key", "setModelPartEnabled", "", "enabled", "XSJClient"})
public interface IGameSettings {
  boolean getAdvancedItemTooltips();
  
  int getThirdPersonView();
  
  boolean getEntityShadows();
  
  void setEntityShadows(boolean paramBoolean);
  
  float getGammaSetting();
  
  void setGammaSetting(float paramFloat);
  
  @NotNull
  Set<WEnumPlayerModelParts> getModelParts();
  
  float getMouseSensitivity();
  
  int getGuiScale();
  
  @NotNull
  IKeyBinding getKeyBindAttack();
  
  @NotNull
  IKeyBinding getKeyBindUseItem();
  
  @NotNull
  IKeyBinding getKeyBindJump();
  
  @NotNull
  IKeyBinding getKeyBindSneak();
  
  @NotNull
  IKeyBinding getKeyBindForward();
  
  @NotNull
  IKeyBinding getKeyBindBack();
  
  @NotNull
  IKeyBinding getKeyBindRight();
  
  @NotNull
  IKeyBinding getKeyBindLeft();
  
  @NotNull
  IKeyBinding getKeyBindSprint();
  
  boolean isKeyDown(@NotNull IKeyBinding paramIKeyBinding);
  
  void setModelPartEnabled(@NotNull WEnumPlayerModelParts paramWEnumPlayerModelParts, boolean paramBoolean);
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\client\settings\IGameSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */