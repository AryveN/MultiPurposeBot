package com.aryven.multipurposebot.listeners;

import com.aryven.multipurposebot.objects.Embeds;
import dev.mayuna.mayuslibrary.logging.Logger;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.channel.concrete.TextChannelManager;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.List;

public class TicketAddListener extends ListenerAdapter {

    Embeds ticket = new Embeds();

    @Override
    public void onEntitySelectInteraction(EntitySelectInteractionEvent event) {
        if (event.getComponentId().equals("add-user")) {
            event.deferReply(false).queue();
            List<User> users = event.getMentions().getUsers();
            List<Member> members = event.getMentions().getMembers();
            StringBuilder mentionedUsers = new StringBuilder();
            StringBuilder userNames = new StringBuilder();

            TextChannel textChannel = event.getChannel().asTextChannel();
            TextChannelManager textChannelManager = textChannel.getManager();

            for (User user : users) {
                mentionedUsers.append(user.getAsMention()).append("\n");
                userNames.append(user.getName()).append(", ");
                try {
                    for(Member member : members) {
                        textChannelManager.putPermissionOverride(member, EnumSet.of(Permission.VIEW_CHANNEL), null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.error("Error has occured while trying to add user/users to the channel!");
                }
            }
            textChannelManager.queue();
            Logger.debug(MessageFormat.format("{0}added to channel {1}", userNames, textChannel));
            event.getChannel().sendMessageEmbeds(ticket.ticketAddUser(mentionedUsers)).queue();
            event.getMessage().delete().queue();

            event.getHook().deleteOriginal().complete();
        }
    }

}
