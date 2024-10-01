package com.aryven.multipurposebot;

import com.aryven.multipurposebot.commands.*;
import com.aryven.multipurposebot.listeners.*;
import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.customColoring;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import dev.mayuna.mayuslibrary.console.colors.Color;
import dev.mayuna.mayuslibrary.logging.Logger;
import lombok.Getter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    private static @Getter CommandClientBuilder builder;
    public static void main(String[] args) {
        Config.load();

        //Log settings
        Logger.setColoring(new customColoring());
        Logger.setTimePattern("HH:mm:ss");
        Logger.setFormat("[{type} | {time} | " + Config.getBotName() + " | " + Config.getBotVersion() + "]" + Color.RESET + " {text}");

        Logger.info("""
                                                          \s
                                                          \s
                  ██████  ███████ ██████  ███████  ██████   ██████ ███████ ███████  ██████ ██   ██\s
                  ██   ██ ██      ██   ██ ██      ██    ██ ██         ███  ██      ██      ██   ██\s
                  ██████  █████   ██████  █████   ██    ██ ██        ███   █████   ██      ███████\s
                  ██      ██      ██   ██ ██      ██    ██ ██       ███    ██      ██      ██   ██\s
                  ██      ███████ ██   ██ ██       ██████   ██████ ███████ ███████  ██████ ██   ██\s
                """);
        Logger.info("## Made by AryveN ##");
        Logger.info("System Starting...");

        Logger.info("Loading commands...");
        loadCommands();
        Logger.info("Commands loaded.");

        Logger.info("Trying to login...");
        try {

            builder.setOwnerId(Config.getOwnerId());
            builder.setPrefix(Config.getBotPrefix());
            builder.setActivity(Activity.listening("/help"));
            builder.setStatus(OnlineStatus.ONLINE);
            builder.useHelpBuilder(false);
            builder.build();

            CommandClient commandClient = builder.build();

            JDABuilder.createDefault(Config.getBotToken())
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                    .enableIntents(GatewayIntent.GUILD_PRESENCES)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .enableIntents(GatewayIntent.DIRECT_MESSAGES)
                    .enableIntents(GatewayIntent.DIRECT_MESSAGE_REACTIONS)
                    .addEventListeners(commandClient, new TicketCreateListener(), new TicketAddListener(), new TicketRemoveListener(), new ReactionRolesListener(), new JoinLeaveListener())
                    .build().awaitReady();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error has occured while trying to login!");
        }

        Logger.info("Loading done!");
    }

    private static void loadCommands() {
        builder = new CommandClientBuilder();
        builder.addSlashCommand(new TicketCreate());
        builder.addSlashCommand(new TicketAdd());
        builder.addSlashCommand(new TicketRemove());
        builder.addSlashCommand(new Help());
        builder.addSlashCommand(new ReactionRoles());
    }
}