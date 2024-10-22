package com.kairos.randomItems.commands;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CommandManager {
    private final JavaPlugin plugin;

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        LifecycleEventManager<@NotNull Plugin> manager = plugin.getLifecycleManager();

        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register(
                    Commands.literal("startevenement")
                            .executes(StartEvent::execute)
                            .build(),
                    "Begint het evenement!",
                    List.of("startevent")
            );

            commands.register(
                    Commands.literal("stopevenement")
                            .executes(StopEvent::execute)
                            .build(),
                    "Stopt het evenement.",
                    List.of("stopevent")
            );

            commands.register(
                    Commands.literal("klok")
                            .then(
                                    Commands.argument("tijd", ArgumentTypes.time(20)) //Min tijd in Ticks (20 ticks is 1 s)
                                            .executes(Clock::execute)
                            ).build(),
                    "Verandert de tijd tussen elke drop.",
                    List.of("clock")
            );
        });
    }
}
