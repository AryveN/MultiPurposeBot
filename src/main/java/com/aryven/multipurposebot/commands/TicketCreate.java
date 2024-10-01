package com.aryven.multipurposebot.commands;

import com.aryven.multipurposebot.objects.ActionRows;
import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.Embeds;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import dev.mayuna.mayuslibrary.logging.Logger;

import java.util.Arrays;

public class TicketCreate extends SlashCommand {

    public TicketCreate() {
        this.name = "ticket-create";
        this.help = "Command to create a ticket selection message";
        this.guildOnly = false;
    }

    Embeds ticket = new Embeds();
    ActionRows actionRows = new ActionRows();

    @Override
    protected void execute(SlashCommandEvent event) {
        Logger.debug("Ticket-Create command requested.");

        Object[] userRole = event.getMember().getRoles().toArray();
        String adminRole = Config.getAdminRole();

        if (Arrays.toString(userRole).contains(adminRole)) {
            event.deferReply().complete();
            event.getChannel().sendMessageEmbeds(ticket.ticketCreation()).addActionRow(actionRows.ticketCreation()).queue();
            event.getHook().deleteOriginal().complete();
        } else {
            event.deferReply(true).queue();
            event.getHook().sendMessageEmbeds(ticket.ticketCreationError()).setEphemeral(true).queue();
        }
    }
}