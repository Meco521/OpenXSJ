package net.ccbluex.liquidbounce.api.minecraft.network.play.server;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\020\021\n\002\020\016\n\002\b\003\bf\030\0002\0020\001R\030\020\002\032\b\022\004\022\0020\0040\003X¦\004¢\006\006\032\004\b\005\020\006¨\006\007"}, d2 = {"Lnet/ccbluex/liquidbounce/api/minecraft/network/play/server/ISPacketTabComplete;", "", "completions", "", "", "getCompletions", "()[Ljava/lang/String;", "XSJClient"})
public interface ISPacketTabComplete {
  @NotNull
  String[] getCompletions();
}


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\api\minecraft\network\play\server\ISPacketTabComplete.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */