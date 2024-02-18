/*     */ package net.ccbluex.liquidbounce.injection.forge.mixins.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.inventory.GuiEditSign;
/*     */ import net.minecraft.tileentity.TileEntitySign;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.Style;
/*     */ import net.minecraft.util.text.TextComponentString;
/*     */ import net.minecraft.util.text.event.ClickEvent;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Overwrite;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ @Mixin({GuiEditSign.class})
/*     */ public class MixinGuiEditSign
/*     */   extends GuiScreen
/*     */ {
/*     */   @Shadow
/*     */   private int field_146851_h;
/*     */   @Final
/*     */   @Shadow
/*     */   private TileEntitySign field_146848_f;
/*     */   @Shadow
/*     */   private GuiButton field_146852_i;
/*     */   private boolean enabled;
/*     */   private GuiButton toggleButton;
/*     */   private GuiTextField signCommand1;
/*     */   private GuiTextField signCommand2;
/*     */   private GuiTextField signCommand3;
/*     */   private GuiTextField signCommand4;
/*     */   
/*     */   @Inject(method = {"initGui"}, at = {@At("RETURN")})
/*     */   private void initGui(CallbackInfo callbackInfo) {
/*  43 */     this.field_146292_n.add(this.toggleButton = new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 145, this.enabled ? "Disable Formatting codes" : "Enable Formatting codes"));
/*     */     
/*  45 */     this.signCommand1 = new GuiTextField(0, this.field_146289_q, this.field_146294_l / 2 - 100, this.field_146295_m - 15, 200, 10);
/*  46 */     this.signCommand2 = new GuiTextField(1, this.field_146289_q, this.field_146294_l / 2 - 100, this.field_146295_m - 30, 200, 10);
/*  47 */     this.signCommand3 = new GuiTextField(2, this.field_146289_q, this.field_146294_l / 2 - 100, this.field_146295_m - 45, 200, 10);
/*  48 */     this.signCommand4 = new GuiTextField(3, this.field_146289_q, this.field_146294_l / 2 - 100, this.field_146295_m - 60, 200, 10);
/*     */     
/*  50 */     this.signCommand1.func_146180_a("");
/*  51 */     this.signCommand2.func_146180_a("");
/*  52 */     this.signCommand3.func_146180_a("");
/*  53 */     this.signCommand4.func_146180_a("");
/*     */   }
/*     */   
/*     */   @Inject(method = {"actionPerformed"}, at = {@At("HEAD")})
/*     */   private void actionPerformed(GuiButton button, CallbackInfo callbackInfo) {
/*  58 */     switch (button.field_146127_k) {
/*     */       case 0:
/*  60 */         if (!this.signCommand1.func_146179_b().isEmpty()) {
/*  61 */           this.field_146848_f.field_145915_a[0].func_150255_a((new Style()).func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, this.signCommand1.func_146179_b())));
/*     */         }
/*  63 */         if (!this.signCommand2.func_146179_b().isEmpty()) {
/*  64 */           this.field_146848_f.field_145915_a[1].func_150255_a((new Style()).func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, this.signCommand2.func_146179_b())));
/*     */         }
/*  66 */         if (!this.signCommand3.func_146179_b().isEmpty()) {
/*  67 */           this.field_146848_f.field_145915_a[2].func_150255_a((new Style()).func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, this.signCommand3.func_146179_b())));
/*     */         }
/*  69 */         if (!this.signCommand4.func_146179_b().isEmpty())
/*  70 */           this.field_146848_f.field_145915_a[3].func_150255_a((new Style()).func_150241_a(new ClickEvent(ClickEvent.Action.RUN_COMMAND, this.signCommand4.func_146179_b()))); 
/*     */         break;
/*     */       case 1:
/*  73 */         this.enabled = !this.enabled;
/*  74 */         this.toggleButton.field_146126_j = this.enabled ? "Disable Formatting codes" : "Enable Formatting codes";
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"drawScreen"}, at = {@At("RETURN")})
/*     */   private void drawFields(CallbackInfo callbackInfo) {
/*  81 */     this.field_146289_q.func_78276_b("§c§lCommands §7(§f§l1.8§7)", this.field_146294_l / 2 - 100, this.field_146295_m - 75, Color.WHITE.getRGB());
/*     */     
/*  83 */     this.signCommand1.func_146194_f();
/*  84 */     this.signCommand2.func_146194_f();
/*  85 */     this.signCommand3.func_146194_f();
/*  86 */     this.signCommand4.func_146194_f();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException {
/*  91 */     this.signCommand1.func_146192_a(mouseX, mouseY, mouseButton);
/*  92 */     this.signCommand2.func_146192_a(mouseX, mouseY, mouseButton);
/*  93 */     this.signCommand3.func_146192_a(mouseX, mouseY, mouseButton);
/*  94 */     this.signCommand4.func_146192_a(mouseX, mouseY, mouseButton);
/*     */     
/*  96 */     super.func_73864_a(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overwrite
/*     */   protected void func_73869_a(char typedChar, int keyCode) throws IOException {
/* 105 */     this.signCommand1.func_146201_a(typedChar, keyCode);
/* 106 */     this.signCommand2.func_146201_a(typedChar, keyCode);
/* 107 */     this.signCommand3.func_146201_a(typedChar, keyCode);
/* 108 */     this.signCommand4.func_146201_a(typedChar, keyCode);
/*     */     
/* 110 */     if (this.signCommand1.func_146206_l() || this.signCommand2.func_146206_l() || this.signCommand3.func_146206_l() || this.signCommand4.func_146206_l()) {
/*     */       return;
/*     */     }
/* 113 */     if (keyCode == 200) {
/* 114 */       this.field_146851_h = this.field_146851_h - 1 & 0x3;
/*     */     }
/*     */     
/* 117 */     if (keyCode == 208 || keyCode == 28 || keyCode == 156) {
/* 118 */       this.field_146851_h = this.field_146851_h + 1 & 0x3;
/*     */     }
/*     */     
/* 121 */     String s = this.field_146848_f.field_145915_a[this.field_146851_h].func_150260_c();
/* 122 */     if (keyCode == 14 && s.length() > 0) {
/* 123 */       s = s.substring(0, s.length() - 1);
/*     */     }
/*     */     
/* 126 */     if ((ChatAllowedCharacters.func_71566_a(typedChar) || (this.enabled && typedChar == '§')) && this.field_146289_q.func_78256_a(s + typedChar) <= 90) {
/* 127 */       s = s + typedChar;
/*     */     }
/*     */     
/* 130 */     this.field_146848_f.field_145915_a[this.field_146851_h] = (ITextComponent)new TextComponentString(s);
/* 131 */     if (keyCode == 1)
/* 132 */       func_146284_a(this.field_146852_i); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\XSJ Client v2.3 New Year's Special Edition.jar!\net\ccbluex\liquidbounce\injection\forge\mixins\gui\MixinGuiEditSign.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */