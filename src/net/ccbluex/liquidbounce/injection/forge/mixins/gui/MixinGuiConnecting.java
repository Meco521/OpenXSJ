/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import net.ccbluex.liquidbounce.injection.backend.ServerDataImplKt;
/*     */ import net.ccbluex.liquidbounce.ui.font.Fonts;
/*     */ import net.ccbluex.liquidbounce.utils.ServerUtils;
/*     */ import net.ccbluex.liquidbounce.utils.render.RenderUtils;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiDisconnected;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.multiplayer.GuiConnecting;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.network.NetHandlerLoginClient;
/*     */ import net.minecraft.network.EnumConnectionState;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.handshake.client.C00Handshake;
/*     */ import net.minecraft.network.login.client.CPacketLoginStart;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.TextComponentTranslation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ @Mixin({GuiConnecting.class})
/*     */ public abstract class MixinGuiConnecting
/*     */   extends GuiScreen
/*     */ {
/*     */   @Shadow
/*     */   @Final
/*     */   private static AtomicInteger field_146372_a;
/*     */   @Shadow
/*     */   @Final
/*     */   private static Logger field_146370_f;
/*     */   
/*     */   @Inject(method = {"connect"}, at = {@At("HEAD")})
/*     */   private void headConnect(String ip, int port, CallbackInfo callbackInfo) {
/*  54 */     ServerUtils.serverData = ServerDataImplKt.wrap(new ServerData("", ip + ":" + port, false));
/*     */   }
/*     */   @Shadow
/*     */   private NetworkManager field_146371_g; @Shadow
/*     */   private boolean field_146373_h; @Shadow
/*     */   @Final
/*     */   private GuiScreen field_146374_i;
/*     */   @Overwrite
/*     */   private void func_146367_a(String ip, int port) {
/*  63 */     field_146370_f.info("Connecting to " + ip + ", " + port);
/*     */     
/*  65 */     (new Thread(() -> {
/*     */           InetAddress inetaddress = null;
/*     */           
/*     */           try {
/*     */             if (this.field_146373_h) {
/*     */               return;
/*     */             }
/*     */             
/*     */             inetaddress = InetAddress.getByName(ip);
/*     */             this.field_146371_g = NetworkManager.func_181124_a(inetaddress, port, this.field_146297_k.field_71474_y.func_181148_f());
/*     */             this.field_146371_g.func_150719_a((INetHandler)new NetHandlerLoginClient(this.field_146371_g, this.field_146297_k, this.field_146374_i));
/*     */             this.field_146371_g.func_179290_a((Packet)new C00Handshake(ip, port, EnumConnectionState.LOGIN, true));
/*     */             this.field_146371_g.func_179290_a((Packet)new CPacketLoginStart(this.field_146297_k.func_110432_I().func_148256_e()));
/*  78 */           } catch (UnknownHostException unknownhostexception) {
/*     */             if (this.field_146373_h) {
/*     */               return;
/*     */             }
/*     */             field_146370_f.error("Couldn't connect to server", unknownhostexception);
/*     */             this.field_146297_k.func_147108_a((GuiScreen)new GuiDisconnected(this.field_146374_i, "connect.failed", (ITextComponent)new TextComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host" })));
/*  84 */           } catch (Exception exception) {
/*     */             if (this.field_146373_h) {
/*     */               return;
/*     */             }
/*     */             
/*     */             field_146370_f.error("Couldn't connect to server", exception);
/*     */             
/*     */             String s = exception.toString();
/*     */             
/*     */             if (inetaddress != null) {
/*     */               String s1 = inetaddress + ":" + port;
/*     */               s = s.replaceAll(s1, "");
/*     */             } 
/*     */             this.field_146297_k.func_147108_a((GuiScreen)new GuiDisconnected(this.field_146374_i, "connect.failed", (ITextComponent)new TextComponentTranslation("disconnect.genericReason", new Object[] { s })));
/*     */           } 
/*  99 */         }"Server Connector #" + field_146372_a.incrementAndGet())).start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 108 */     ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
/*     */     
/* 110 */     func_146276_q_();
/*     */     
/* 112 */     RenderUtils.drawLoadingCircle((scaledResolution.func_78326_a() / 2), (scaledResolution.func_78328_b() / 4 + 70));
/*     */     
/* 114 */     String ip = "Unknown";
/*     */     
/* 116 */     ServerData serverData = this.field_146297_k.func_147104_D();
/* 117 */     if (serverData != null) {
/* 118 */       ip = serverData.field_78845_b;
/*     */     }
/* 120 */     Fonts.roboto40.drawCenteredString("Connecting to", (scaledResolution.func_78326_a() / 2), (scaledResolution.func_78328_b() / 4 + 110), 16777215, true);
/* 121 */     Fonts.roboto35.drawCenteredString(ip, (scaledResolution.func_78326_a() / 2), (scaledResolution.func_78328_b() / 4 + 120), 5407227, true);
/*     */     
/* 123 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiConnecting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */