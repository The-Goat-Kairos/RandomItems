package com.kairos.randomItems.commands;

import com.kairos.randomItems.Disaster;
import com.kairos.randomItems.RandomItemGiver;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.Duration;

@SuppressWarnings("UnstableApiUsage")
public class StopEvent {
    private static RandomItemGiver itemGiver;
    private final static Disaster disaster = new Disaster();

    public static void setItemGiver(RandomItemGiver giver) {
        itemGiver = giver;
    }

    public static int execute(CommandContext<CommandSourceStack> ctx) {
        for (Player player : Bukkit.getOnlinePlayers()) {
//          player.sendPlainMessage("EVENEMENT STOPT!!!!!");
            disaster.applyDisasterEffect(player);
        }
        itemGiver.stopEvent();

        return Command.SINGLE_SUCCESS;
    }
}
