package com.kairos.randomItems;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public interface BannedItems {
    Set<Material> BANNED_MATERIALS = new HashSet<>(Set.of(
            Material.AIR,
            Material.VOID_AIR,
            Material.ENCHANTED_BOOK,
            Material.TRIAL_SPAWNER,
            Material.TRIAL_KEY,
            Material.OMINOUS_TRIAL_KEY,
            Material.KNOWLEDGE_BOOK,
            Material.SPAWNER,
            Material.SCULK_SHRIEKER,
            Material.SNIFFER_EGG,
            Material.FARMLAND,
            Material.DIRT_PATH,
            Material.COMMAND_BLOCK,
            Material.COMMAND_BLOCK_MINECART,
            Material.REPEATING_COMMAND_BLOCK,
            Material.CHAIN_COMMAND_BLOCK,
            Material.STRUCTURE_BLOCK,
            Material.STRUCTURE_VOID,
            Material.LIGHT,
            Material.JIGSAW,
            Material.DEBUG_STICK,
            Material.WALL_TORCH,

            // AAAA
            Material.POTTED_ACACIA_SAPLING,
            Material.POTTED_ALLIUM,
            Material.POTTED_BAMBOO,
            Material.SOUL_FIRE,
            Material.FIRE,
            Material.COCOA,
            Material.POTTED_CACTUS,
            Material.POTTED_AZALEA_BUSH,
            Material.POTTED_AZURE_BLUET,
            Material.POTTED_OAK_SAPLING,
            Material.POTTED_DARK_OAK_SAPLING,
            Material.POTTED_SPRUCE_SAPLING,
            Material.POTTED_BIRCH_SAPLING,
            Material.POTTED_FLOWERING_AZALEA_BUSH,
            Material.TRIPWIRE,
            Material.REDSTONE_WIRE
    ));
}
