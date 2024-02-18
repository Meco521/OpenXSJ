/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import com.mojang.authlib.Agent;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*     */ import com.thealtening.AltService;
/*     */ import com.thealtening.api.TheAltening;
/*     */ import com.thealtening.api.data.AccountData;
/*     */ import java.net.Proxy;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.ccbluex.liquidbounce.Retreat;
/*     */ import net.ccbluex.liquidbounce.event.Event;
/*     */ import net.ccbluex.liquidbounce.event.SessionEvent;
/*     */ import net.ccbluex.liquidbounce.features.special.AntiForge;
/*     */ import net.ccbluex.liquidbounce.features.special.AutoReconnect;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.GuiAltManager;
/*     */ import net.ccbluex.liquidbounce.ui.client.altmanager.sub.altgenerator.GuiTheAltening;
/*     */ import net.ccbluex.liquidbounce.utils.ClientUtils;
/*     */ import net.ccbluex.liquidbounce.utils.ServerUtils;
/*     */ import net.ccbluex.liquidbounce.utils.login.LoginUtils;
/*     */ import net.ccbluex.liquidbounce.utils.login.MinecraftAccount;
/*     */ import net.ccbluex.liquidbounce.utils.misc.RandomUtils;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiDisconnected;
/*     */ import net.minecraft.util.Session;
/*     */ import net.minecraftforge.fml.client.config.GuiSlider;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ @Mixin({GuiDisconnected.class})
/*     */ public abstract class MixinGuiDisconnected extends MixinGuiScreen {
/*  37 */   private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0");
/*     */   
/*     */   @Shadow
/*     */   private int field_175353_i;
/*     */   
/*     */   private GuiButton reconnectButton;
/*     */   private GuiSlider autoReconnectDelaySlider;
/*     */   private GuiButton forgeBypassButton;
/*     */   private int reconnectTimer;
/*     */   
/*     */   @Inject(method = {"initGui"}, at = {@At("RETURN")})
/*     */   private void initGui(CallbackInfo callbackInfo) {
/*  49 */     this.reconnectTimer = 0;
/*  50 */     this.field_146292_n.add(this.reconnectButton = new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b + 22, 98, 20, "Reconnect"));
/*     */     
/*  52 */     drawReconnectDelaySlider();
/*     */     
/*  54 */     this.field_146292_n.add(new GuiButton(3, this.field_146294_l / 2 - 100, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b + 44, 98, 20, GuiTheAltening.Companion.getApiKey().isEmpty() ? "Random alt" : "New TheAltening alt"));
/*  55 */     this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 + 2, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b + 44, 98, 20, "Random username"));
/*  56 */     this.field_146292_n.add(this.forgeBypassButton = new GuiButton(5, this.field_146294_l / 2 - 100, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b + 66, "Bypass AntiForge: " + (AntiForge.enabled ? "On" : "Off")));
/*     */     
/*  58 */     updateSliderText();
/*     */   } @Inject(method = {"actionPerformed"}, at = {@At("HEAD")})
/*     */   private void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
/*     */     List<MinecraftAccount> accounts;
/*     */     MinecraftAccount minecraftAccount;
/*  63 */     switch (button.field_146127_k) {
/*     */       case 1:
/*  65 */         ServerUtils.connectToLastServer();
/*     */         break;
/*     */       case 3:
/*  68 */         if (!GuiTheAltening.Companion.getApiKey().isEmpty()) {
/*  69 */           String apiKey = GuiTheAltening.Companion.getApiKey();
/*  70 */           TheAltening theAltening = new TheAltening(apiKey);
/*     */           
/*     */           try {
/*  73 */             AccountData account = theAltening.getAccountData();
/*  74 */             GuiAltManager.altService.switchService(AltService.EnumAltService.THEALTENING);
/*     */             
/*  76 */             YggdrasilUserAuthentication yggdrasilUserAuthentication = new YggdrasilUserAuthentication(new YggdrasilAuthenticationService(Proxy.NO_PROXY, ""), Agent.MINECRAFT);
/*  77 */             yggdrasilUserAuthentication.setUsername(account.getToken());
/*  78 */             yggdrasilUserAuthentication.setPassword("XSJ Client");
/*  79 */             yggdrasilUserAuthentication.logIn();
/*     */             
/*  81 */             this.field_146297_k.field_71449_j = new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang");
/*  82 */             Retreat.eventManager.callEvent((Event)new SessionEvent());
/*  83 */             ServerUtils.connectToLastServer();
/*     */             break;
/*  85 */           } catch (Throwable throwable) {
/*  86 */             ClientUtils.getLogger().error("Failed to login into random account from TheAltening.", throwable);
/*     */           } 
/*     */         } 
/*     */         
/*  90 */         accounts = Retreat.fileManager.accountsConfig.getAccounts();
/*  91 */         if (accounts.isEmpty())
/*     */           break; 
/*  93 */         minecraftAccount = accounts.get((new Random()).nextInt(accounts.size()));
/*  94 */         GuiAltManager.login(minecraftAccount);
/*  95 */         ServerUtils.connectToLastServer();
/*     */         break;
/*     */       case 4:
/*  98 */         LoginUtils.loginCracked(RandomUtils.randomString(RandomUtils.nextInt(5, 16)));
/*  99 */         ServerUtils.connectToLastServer();
/*     */         break;
/*     */       case 5:
/* 102 */         AntiForge.enabled = !AntiForge.enabled;
/* 103 */         this.forgeBypassButton.field_146126_j = "Bypass AntiForge: " + (AntiForge.enabled ? "On" : "Off");
/* 104 */         Retreat.fileManager.saveConfig(Retreat.fileManager.valuesConfig);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 111 */     if (AutoReconnect.INSTANCE.isEnabled()) {
/* 112 */       this.reconnectTimer++;
/* 113 */       if (this.reconnectTimer > AutoReconnect.INSTANCE.getDelay() / 50)
/* 114 */         ServerUtils.connectToLastServer(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"drawScreen"}, at = {@At("RETURN")})
/*     */   private void drawScreen(CallbackInfo callbackInfo) {
/* 120 */     if (AutoReconnect.INSTANCE.isEnabled()) {
/* 121 */       updateReconnectButton();
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawReconnectDelaySlider() {
/* 126 */     this.field_146292_n.add(this
/*     */ 
/*     */         
/* 129 */         .autoReconnectDelaySlider = new GuiSlider(2, this.field_146294_l / 2 + 2, this.field_146295_m / 2 + this.field_175353_i / 2 + this.field_146289_q.field_78288_b + 22, 98, 20, "AutoReconnect: ", "ms", 1000.0D, 60000.0D, AutoReconnect.INSTANCE.getDelay(), false, true, guiSlider -> {
/*     */             AutoReconnect.INSTANCE.setDelay(guiSlider.getValueInt());
/*     */             this.reconnectTimer = 0;
/*     */             updateReconnectButton();
/*     */             updateSliderText();
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateSliderText() {
/* 140 */     if (this.autoReconnectDelaySlider == null) {
/*     */       return;
/*     */     }
/* 143 */     if (!AutoReconnect.INSTANCE.isEnabled()) {
/* 144 */       this.autoReconnectDelaySlider.field_146126_j = "AutoReconnect: Off";
/*     */     } else {
/* 146 */       this.autoReconnectDelaySlider.field_146126_j = "AutoReconnect: " + DECIMAL_FORMAT.format(AutoReconnect.INSTANCE.getDelay() / 1000.0D) + "s";
/*     */     } 
/*     */   }
/*     */   
/*     */   private void updateReconnectButton() {
/* 151 */     if (this.reconnectButton != null)
/* 152 */       this.reconnectButton.field_146126_j = "Reconnect" + (AutoReconnect.INSTANCE.isEnabled() ? (" (" + (AutoReconnect.INSTANCE.getDelay() / 1000 - this.reconnectTimer / 20) + ")") : ""); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiDisconnected.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */