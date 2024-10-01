package com.aryven.multipurposebot.listeners;

import com.aryven.multipurposebot.objects.Config;
import dev.mayuna.mayuslibrary.logging.Logger;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReactionRolesListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {

        String reactionChannel = Config.getReactionChannel();
        String eventChannel = event.getChannel().getId().toString();
        User user = event.getUser();

        if(eventChannel.equals(reactionChannel)) {
            switch (event.getEmoji().getName()) {
                case "lua":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getLuaRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getLuaRole()) + " added to user " + user.getName());
                    break;
                case "\uD83D\uDDFA\uFE0F":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getMapsRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getMapsRole()) + " added to user " + user.getName());
                    break;
                case "\uD83D\uDC55":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getClothesRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getClothesRole()) + " added to user " + user.getName());
                    break;
                case "fivemLogo":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getFivemRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getFivemRole()) + " added to user " + user.getName());
                    break;
                case "altVlogo":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getAltvRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getAltvRole()) + " added to user " + user.getName());
                    break;
                case "\uD83E\uDDE7":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getRagempRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getRagempRole()) + " added to user " + user.getName());
                    break;
                case "roleplayLogo":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getRoleplayRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getRoleplayRole()) + " added to user " + user.getName());
                    break;
                case "\uD83E\uDE96":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getMilitaryRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getMilitaryRole()) + " added to user " + user.getName());
                    break;
                case "gtacar":
                    event.getGuild().addRoleToMember(user, event.getGuild().getRoleById(Config.getDriftRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getDriftRole()) + " added to user " + user.getName());
                    break;
            }
        }
    }

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        String reactionChannel = Config.getReactionChannel();
        String eventChannel = event.getChannel().getId().toString();
        User user = event.getUser();

        if(eventChannel.equals(reactionChannel)) {
            switch (event.getEmoji().getName()) {
                case "lua":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getLuaRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getLuaRole()) + " removed from user " + user.getName());
                    break;
                case "\uD83D\uDDFA\uFE0F":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getMapsRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getMapsRole()) + " removed from user " + user.getName());
                    break;
                case "\uD83D\uDC55":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getClothesRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getClothesRole()) + " removed from user " + user.getName());
                    break;
                case "fivemLogo":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getFivemRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getFivemRole()) + " removed from user " + user.getName());
                    break;
                case "altVlogo":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getAltvRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getAltvRole()) + " removed from user " + user.getName());
                    break;
                case "\uD83E\uDDE7":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getRagempRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getRagempRole()) + " removed from user " + user.getName());
                    break;
                case "roleplayLogo":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getRoleplayRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getRoleplayRole()) + " removed from user " + user.getName());
                    break;
                case "\uD83E\uDE96":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getMilitaryRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getMilitaryRole()) + " removed from user " + user.getName());
                    break;
                case "gtacar":
                    event.getGuild().removeRoleFromMember(user, event.getGuild().getRoleById(Config.getDriftRole())).queue();
                    Logger.debug( event.getGuild().getRoleById(Config.getDriftRole()) + " removed from user " + user.getName());
                    break;
            }
        }
    }
}
