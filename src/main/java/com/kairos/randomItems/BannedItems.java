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
            Material.DEBUG_STICK
    ));
}
