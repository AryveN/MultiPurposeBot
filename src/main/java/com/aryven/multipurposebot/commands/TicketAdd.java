package com.aryven.multipurposebot.commands;

import com.aryven.multipurposebot.objects.ActionRows;
import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.Embeds;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import dev.mayuna.mayuslibrary.logging.Logger;

import java.util.Arrays;

public class TicketAdd extends SlashCommand {

    Embeds ticket = new Embeds();
    ActionRows actionRows = new ActionRows();

    public TicketAdd() {
        this.name = "ticket-add";
        this.help = "Adds user/users to the ticket";
        this.guildOnly = false;
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        Logger.debug("Ticket-Add command requested.");

        Object[] userRole = event.getMember().getRoles().toArray();
        String adminRole = Config.getAdminRole();
        String ticketCategory = event.getTextChannel().getParentCategory().toString();

        String otherCategory = event.getGuild().getCategoryById(Config.getOtherCategory()).toString();
        String devCategory = event.getGuild().getCategoryById(Config.getDevCategory()).toString();
        String collaborationCategory = event.getGuild().getCategoryById(Config.getCollaborationCategory()).toString();
        String questionCategory = event.getGuild().getCategoryById(Config.getQuestionCategory()).toString();

        if(ticketCategory.equals(otherCategory) || ticketCategory.equals(devCategory) || ticketCategory.equals(collaborationCategory) || ticketCategory.equals(questionCategory)) {
            if (Arrays.toString(userRole).contains(adminRole)) {
                event.deferReply().complete();
                event.getChannel().sendMessageEmbeds(ticket.tickedAdd()).addActionRow(actionRows.ticketAdd()).queue();
                event.getHook().deleteOriginal().complete();
            } else {
                event.deferReply(true).queue();
                event.getHook().sendMessageEmbeds(ticket.ticketAddError()).setEphemeral(true).queue();
            }
        } else {
            event.deferReply(true).queue();
            event.getHook().sendMessageEmbeds(ticket.ticketError()).setEphemeral(true).queue();
        }
    }

}
