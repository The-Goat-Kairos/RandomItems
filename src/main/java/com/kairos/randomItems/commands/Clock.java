package com.kairos.randomItems.commands;

import com.kairos.randomItems.RandomItemGiver;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import io.papermc.paper.command.brigadier.CommandSourceStack;

@SuppressWarnings("UnstableApiUsage")
public class Clock {
    private static RandomItemGiver itemGiver;

    public static void setItemGiver(RandomItemGiver giver) {
        itemGiver = giver;
    }

    public static int execute(CommandContext<CommandSourceStack> ctx) {
        int time = ctx.getArgument("tijd", Integer.class);
        itemGiver.setTimer(time);
        itemGiver.startEvent();

        ctx.getSource().getSender().sendPlainMessage("De tijd tussen elke item is nu: " + time / 20 + ".");

        return Command.SINGLE_SUCCESS;
    }
}
