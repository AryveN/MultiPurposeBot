package com.aryven.multipurposebot.commands;

import com.aryven.multipurposebot.objects.ActionRows;
import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.Embeds;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import dev.mayuna.mayuslibrary.logging.Logger;

import java.util.Arrays;

public class TicketRemove extends SlashCommand {

    public TicketRemove() {
        this.name = "ticket-remove";
        this.help = "Removes user/users from the ticket";
        this.guildOnly = false;
    }

    Embeds ticket = new Embeds();
    ActionRows actionRows = new ActionRows();

    @Override
    protected void execute(SlashCommandEvent event) {
        Logger.debug("Ticket-Remove command requested.");

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
                event.getChannel().sendMessageEmbeds(ticket.ticketRemove()).addActionRow(actionRows.ticketRemove()).queue();

                event.getHook().deleteOriginal().complete();
            } else {
                event.deferReply(true).queue();
                event.getHook().sendMessageEmbeds(ticket.ticketRemoveError()).setEphemeral(true).queue();
            }
        } else {
            event.deferReply(true).queue();
            event.getHook().sendMessageEmbeds(ticket.ticketError()).setEphemeral(true).queue();
        }
    }
}
