package net.androidmod.webtv;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class WebTVMod implements ModInitializer {
    public static final String MOD_ID = "webtv";
    
    // Registriamo il blocco TV con le proprietà del ferro (resistente)
    public static final Block TV_BLOCK = new TvBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tv_block"), TV_BLOCK);
        System.out.println("Android Web TV inizializzata correttamente per dispositivi mobili!");
    }
}
