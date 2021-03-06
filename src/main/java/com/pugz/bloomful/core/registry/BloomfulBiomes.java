package com.pugz.bloomful.core.registry;

import com.pugz.bloomful.common.world.biome.WisteriaForestBiome;
import com.pugz.bloomful.common.world.biome.WisteriaForestHillsBiome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = "bloomful", bus = Mod.EventBusSubscriber.Bus.MOD)
public class BloomfulBiomes {
	public static final DeferredRegister<Biome> BIOMES =  new DeferredRegister<>(ForgeRegistries.BIOMES, "bloomful");

    public static final RegistryObject<Biome> WISTERIA_FOREST = BIOMES.register("wisteria_forest", () -> new WisteriaForestBiome(new Biome.Builder().surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.7F).downfall(0.8F).waterColor(4159204).waterFogColor(329011).parent(null)));
    public static final RegistryObject<Biome> WISTERIA_FOREST_HILLS = BIOMES.register("wisteria_forest_hills", () -> new WisteriaForestHillsBiome(new Biome.Builder().surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.45F).scale(0.3F).temperature(0.7F).downfall(0.8F).waterColor(4159204).waterFogColor(329011).parent(null)));

    public static void registerBiomesToDictionary() {
        BiomeDictionary.addTypes(WISTERIA_FOREST.get(), BiomeDictionary.Type.RARE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(WISTERIA_FOREST.get(), 2));
        BiomeDictionary.addTypes(WISTERIA_FOREST_HILLS.get(), BiomeDictionary.Type.RARE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(WISTERIA_FOREST_HILLS.get(), 1));
    }

    /*public static void registerBiomeSpawns() {
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            biome.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityRegistry.BUTTERFLY, 8, 4, 8));
        }
    }*/
}