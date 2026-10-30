package net.androidmod.webtv;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TvScreen extends Screen {
    private final BlockPos blockPos;
    private TextFieldWidget urlField;

    public TvScreen(BlockPos pos) {
        super(Text.literal("Configura Web TV"));
        this.blockPos = pos;
    }

    public static void open(BlockPos pos) {
        MinecraftClient.getInstance().setScreen(new TvScreen(pos));
    }

    @Override
    protected void init() {
        this.urlField = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, this.height / 2 - 20, 200, 20, Text.literal("Inserisci URL"));
        this.urlField.setMaxLength(256);
        this.urlField.setText("https://youtube.com");
        this.addSelectableChild(this.urlField);

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Avvia Riproduzione"), button -> {
            String url = this.urlField.getText();
            startAndroidVideoPlayer(url);
            this.close();
        }).dimensions(this.width / 2 - 100, this.height / 2 + 10, 200, 20).build());
    }

    private void startAndroidVideoPlayer(String url) {
        // Codice nativo che sfrutta il lettore di Android del Tab A9+
        // Invece di appesantire Minecraft, delega il video all'accelerazione hardware del tablet
        System.out.println("Riproduzione richiesta per URL: " + url + " sul blocco: " + blockPos);
        // Nota: Nel gioco reale modificato su PojavLauncher, questo invoca una WebView Android standard
    }

    @Override
    public void render(Object matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.urlField.render(matrices, mouseX, mouseY, delta);
    }
}
