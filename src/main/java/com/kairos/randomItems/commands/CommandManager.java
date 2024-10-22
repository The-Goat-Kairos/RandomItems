package com.kairos.randomItems.commands;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("UnstableApiUsage")
public class CommandManager {
    private final JavaPlugin plugin;

    private final UUID elfUUID = UUID.fromString("30ee7c7b-f49f-4ac1-ab45-a84a59f2cb1b");
    private final UUID kairosUUID = UUID.fromString("30ee7c7b-f49f-4ac1-ab45-a84a59f2cb1b"); //b65d109b-deea-45d4-b4c1-debf10eb9146

    public CommandManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        LifecycleEventManager<@NotNull Plugin> manager = plugin.getLifecycleManager();

        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();

            commands.register(
                    Commands.literal("startevenement")
                            .requires(stuff -> stuff.getSender().getName().equals("elfelf123") || stuff.getSender().getName().equals("GoatNuisance"))
                            .executes(StartEvent::execute)
                            .build(),
                    "Begint het evenement!",
                    List.of("")
            );

            commands.register(
                    Commands.literal("stopevenement")
                            .requires(stuff -> stuff.getSender().getName().equals("elfelf123") || stuff.getSender().getName().equals("GoatNuisance"))
                            .executes(StopEvent::execute)
                            .build(),
                    "Stopt het evenement.",
                    List.of("")
            );

            commands.register(
                    Commands.literal("klok")
                            .requires(stuff -> stuff.getSender().getName().equals("elfelf123") || stuff.getSender().getName().equals("GoatNuisance"))
                            .then(
                                    Commands.argument("tijd", ArgumentTypes.time(20)) //Min tijd in Ticks (20 ticks is 1 s)
                                            .executes(Clock::execute)
                            ).build(),
                    "Verandert de tijd tussen elke drop.",
                    List.of("")
            );
        });
    }
}
