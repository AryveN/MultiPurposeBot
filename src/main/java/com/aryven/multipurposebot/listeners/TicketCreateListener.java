package com.aryven.multipurposebot.listeners;

import com.aryven.multipurposebot.objects.ActionRows;
import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.Embeds;
import dev.mayuna.mayuslibrary.logging.Logger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketCreateListener extends ListenerAdapter {

    Embeds ticket = new Embeds();
    ActionRows actionRows = new ActionRows();

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        if (event.getComponentId().equals("category-selection")) {
            event.deferReply(true).queue();

            String categorySelection = event.getValues().get(0);
            Member member = event.getMember();
            Category ticketCategory = null;
            String category = null;
            String titleCategory = null;
            Category devCategory = event.getGuild().getCategoryById(Config.getDevCategory());
            Category questionCategory = event.getGuild().getCategoryById(Config.getQuestionCategory());
            Category collaborationCategory = event.getGuild().getCategoryById(Config.getCollaborationCategory());
            Category otherCategory = event.getGuild().getCategoryById(Config.getOtherCategory());

            switch (categorySelection) {
                case "dev":
                    ticketCategory = devCategory;
                    category = "DEV ⌨️";
                    titleCategory = "⌨️ 〃 Dev Ticket Created";
                    break;
                case "otazka":
                    ticketCategory = questionCategory;
                    category = "Otázka ❓";
                    titleCategory = "❓ 〃 Otázka Ticket Created";
                    break;
                case "spoluprace":
                    ticketCategory = collaborationCategory;
                    category = "Spolupráce \uD83D\uDCB0";
                    titleCategory = "💰 〃 Spolupráce Ticket Created";
                    break;
                case "ostatni":
                    ticketCategory = otherCategory;
                    category = "Ostatní \uD83D\uDD00";
                    titleCategory = "\uD83D\uDD00 〃 Ostatní Ticket Created";
                    break;
            }

            Guild guild = event.getGuild();
            Logger.info(titleCategory + " by " + member.getUser().getName());
            event.getHook().sendMessageEmbeds(ticket.ticketCreationCategory(category)).setEphemeral(true).queue();

            try{
                String finalTitleCategory = titleCategory;
                ticketCategory.createTextChannel("ticket-" + categorySelection + "-" + member.getUser().getName())
                        .addPermissionOverride(member, EnumSet.of(Permission.VIEW_CHANNEL), null)
                        .addPermissionOverride(guild.getPublicRole(), null, EnumSet.of(Permission.VIEW_CHANNEL))
                        .addPermissionOverride(guild.getRoleById(Config.getAdminRole()), EnumSet.of(Permission.VIEW_CHANNEL), null)
                        .queue(channel -> {
                            channel.sendMessageEmbeds(ticket.ticketCreated(finalTitleCategory)).addActionRow(actionRows.ticketArchive(), actionRows.ticketClose()).queue();
                            channel.sendMessage(member.getUser().getAsMention() + "<@&" + Config.getAdminRole() + ">").queue();
                        });
            } catch (Exception e) {
                e.printStackTrace();
                Logger.error("Error has occured while trying to create ticket channel!");
            }

        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("close")) {
            event.deferReply(true).queue();
            Logger.info("Ticket closed by " + event.getMember().getUser().getName());
            event.getHook().sendMessageEmbeds(ticket.ticketClose()).queue();
            event.getChannel().delete().queueAfter(5, TimeUnit.SECONDS);
        } else if (event.getComponentId().equals("archive")) {
            Category archiveCategory = event.getGuild().getCategoryById(Config.getArchiveCategory());
            event.deferReply(true).queue();
            Logger.debug("Ticket archived by " + event.getMember().getUser().getName());
            event.getHook().sendMessageEmbeds(ticket.ticketArchive()).queue();
            event.getChannel().asTextChannel().getManager().setParent(archiveCategory).queueAfter(5, TimeUnit.SECONDS);
            String channel = event.getChannel().getId();
            Guild guild = event.getGuild();
            List<PermissionOverride> overrides = guild.getTextChannelById(channel).getMemberPermissionOverrides();
            try{
                for(PermissionOverride override : overrides) {
                    override.delete().queueAfter(6,TimeUnit.SECONDS);
                }
                Logger.debug("Ticket " + event.getChannel().getName() + " was archived");
            } catch (Exception e) {
                e.printStackTrace();
                Logger.error("Error has occured while trying to archive ticket channel!");
            }
        }
    }
}
