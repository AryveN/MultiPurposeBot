package com.aryven.multipurposebot.commands;

import com.aryven.multipurposebot.objects.Embeds;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

public class Help extends SlashCommand {

    public Help() {
        this.name = "help";
        this.help = "If you need any help with commands you can find it here";
        this.guildOnly = false;
    }

    Embeds embeds = new Embeds();

    @Override
    protected void execute(SlashCommandEvent event) {
        event.deferReply(true).queue();
        event.getHook().sendMessageEmbeds(embeds.help()).setEphemeral(true).queue();
    }
}
