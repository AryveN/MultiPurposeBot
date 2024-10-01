package com.aryven.multipurposebot.commands;

import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.Embeds;
import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import dev.mayuna.mayuslibrary.logging.Logger;
import net.dv8tion.jda.api.entities.emoji.Emoji;

import java.util.Arrays;

public class ReactionRoles extends SlashCommand {

    public ReactionRoles() {
        this.name = "reaction-roles";
        this.help = "Creates reaction roles messages";
        this.guildOnly = false;
    }

    Embeds reactionRoles = new Embeds();
    @Override
    protected void execute(SlashCommandEvent event) {
        Logger.debug("Reaction Roles command requested");

        Object[] userRole = event.getMember().getRoles().toArray();
        String adminRole = Config.getAdminRole();

        if (Arrays.toString(userRole).contains(adminRole)) {
            event.deferReply().complete();
            event.getChannel().sendMessageEmbeds(reactionRoles.reactionRolesMain()).queue(message -> {
                message.addReaction(Emoji.fromFormatted("<:lua:1111218684569071627>")).queue();
                message.addReaction(Emoji.fromUnicode("\uD83D\uDDFA\uFE0F")).queue();
                message.addReaction(Emoji.fromUnicode("\uD83D\uDC55")).queue();
            });
            event.getChannel().sendMessageEmbeds(reactionRoles.reactionRolesGame()).queue(message -> {
                message.addReaction(Emoji.fromFormatted("<:fivemLogo:1111223214631297135>")).queue();
                message.addReaction(Emoji.fromFormatted("<:altVlogo:1111219542778204160>")).queue();
                message.addReaction(Emoji.fromUnicode("\uD83E\uDDE7")).queue();
            });
            event.getChannel().sendMessageEmbeds(reactionRoles.reactionRolesFivem()).queue(message -> {
                message.addReaction(Emoji.fromFormatted("<:roleplayLogo:1111220149446508577>")).queue();
                message.addReaction(Emoji.fromUnicode("\uD83E\uDE96")).queue();
                message.addReaction(Emoji.fromFormatted("<:gtacar:1111219452009267250>")).queue();
            });
            event.getHook().deleteOriginal().complete();
        } else {
            event.deferReply(true).queue();
            event.getHook().sendMessageEmbeds(reactionRoles.reactionRolesError()).setEphemeral(true).queue();
        }
    }
}
