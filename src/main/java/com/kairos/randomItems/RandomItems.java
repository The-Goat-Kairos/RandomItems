package com.kairos.randomItems;

import com.kairos.randomItems.commands.Clock;
import com.kairos.randomItems.commands.CommandManager;
import com.kairos.randomItems.commands.StartEvent;
import com.kairos.randomItems.commands.StopEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomItems extends JavaPlugin {
    public static RandomItemGiver itemGiver;

    @Override
    public void onEnable() {
        itemGiver = new RandomItemGiver(this);

        StartEvent.setItemGiver(itemGiver);
        StopEvent.setItemGiver(itemGiver);
        Clock.setItemGiver(itemGiver);

        CommandManager manager = new CommandManager(this); //Command Manager
        manager.registerCommands();

        // Was het slim om geen globale game class te maken? Nee. Heb ik spijt? Ehhhh
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
