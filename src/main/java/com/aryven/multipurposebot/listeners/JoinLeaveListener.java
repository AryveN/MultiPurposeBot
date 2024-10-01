package com.aryven.multipurposebot.listeners;

import com.aryven.multipurposebot.objects.Config;
import com.aryven.multipurposebot.objects.Embeds;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class JoinLeaveListener extends ListenerAdapter {

    Embeds embed = new Embeds();

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        User user = event.getUser();
        TextChannel channel = event.getGuild().getTextChannelById(Config.getWelcomeChannel());
        Role memberRole = event.getGuild().getRoleById(Config.getMemberRole());

        event.getGuild().addRoleToMember(user, memberRole).queue();
        channel.sendMessageEmbeds(embed.userJoin(user)).queue();
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        User user = event.getUser();
        TextChannel channel = event.getGuild().getTextChannelById(Config.getLeaveChannel());

        channel.sendMessageEmbeds(embed.userLeave(user)).queue();
    }
}
