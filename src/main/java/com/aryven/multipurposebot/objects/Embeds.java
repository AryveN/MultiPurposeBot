package com.aryven.multipurposebot.objects;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class Embeds {
    public MessageEmbed tickedAdd() {
        EmbedBuilder ticketAdd = new EmbedBuilder();
        ticketAdd.setTitle("\\\uD83C\uDFAB 〃 Add users to ticket");
        ticketAdd.setDescription("Select the users you want to add.");
        ticketAdd.setColor(Color.decode("#ce5253"));
        return ticketAdd.build();
    }
    public MessageEmbed ticketError() {
        EmbedBuilder ticketError = new EmbedBuilder();
        ticketError.setTitle("\\\uD83C\uDFAB 〃 Ticket Error");
        ticketError.setDescription("The command cannot be used!");
        ticketError.setColor(Color.decode("#ce5253"));
        return ticketError.build();
    }
    public MessageEmbed ticketAddError() {
        EmbedBuilder ticketAddError = new EmbedBuilder();
        ticketAddError.setTitle("\\\uD83C\uDFAB 〃 Add users to ticket");
        ticketAddError.setDescription("You don't have the necessary role to use this command!");
        ticketAddError.setColor(Color.decode("#ce5253"));
        return ticketAddError.build();
    }
    public MessageEmbed ticketRemove() {
        EmbedBuilder ticketRemove = new EmbedBuilder();
        ticketRemove.setTitle("\\\uD83C\uDFAB 〃 Remove user from ticket");
        ticketRemove.setDescription("Select the users you want to remove.");
        ticketRemove.setColor(Color.decode("#ce5253"));
        return ticketRemove.build();
    }
    public MessageEmbed ticketRemoveError() {
        EmbedBuilder ticketRemoveError = new EmbedBuilder();
        ticketRemoveError.setTitle("\\\uD83C\uDFAB 〃 Remove user from ticket");
        ticketRemoveError.setDescription("You don't have the necessary role to use this command!");
        ticketRemoveError.setColor(Color.decode("#ce5253"));
        return ticketRemoveError.build();
    }
    public MessageEmbed ticketCreation() {
        EmbedBuilder ticketCreation = new EmbedBuilder();
        ticketCreation.setTitle("\\\uD83C\uDFAB 〃 Create a Ticket");
        ticketCreation.setDescription("If you want to create a ticket, choose one category from the menu.");
        ticketCreation.setColor(Color.decode("#ce5253"));
        return ticketCreation.build();
    }
    public MessageEmbed ticketCreationError() {
        EmbedBuilder ticketCreationError = new EmbedBuilder();
        ticketCreationError.setTitle("\\\uD83C\uDFAB 〃 Create a Ticket");
        ticketCreationError.setDescription("You don't have the necessary role to use that command!");
        ticketCreationError.setColor(Color.decode("#ce5253"));
        return ticketCreationError.build();
    }
    public MessageEmbed ticketAddUser(StringBuilder mentionedUsers) {
        EmbedBuilder ticketAddUser = new EmbedBuilder();
        ticketAddUser.setTitle("\\\uD83C\uDFAB 〃 Add user to ticket");
        ticketAddUser.setDescription("You have added the following users to the ticket: \n" + mentionedUsers);
        ticketAddUser.setColor(Color.decode("#ce5253"));
        return ticketAddUser.build();
    }
    public MessageEmbed ticketCreationCategory(String category) {
        EmbedBuilder ticketCreationCategory = new EmbedBuilder();
        ticketCreationCategory.setTitle("\\\uD83C\uDFAB 〃 Ticket Creation");
        ticketCreationCategory.setDescription("Ticket in category **" + category + "** was created.");
        ticketCreationCategory.setColor(Color.decode("#ce5253"));
        return ticketCreationCategory.build();
    }
    public MessageEmbed ticketCreated(String titleCategory) {
        EmbedBuilder ticketCreated = new EmbedBuilder();
        ticketCreated.setTitle(titleCategory);
        ticketCreated.setDescription("Your ticket has been created. Send your message and a member of the Admin team will get back to you as soon as possible.");
        ticketCreated.setColor(Color.decode("#ce5253"));
        return ticketCreated.build();
    }
    public MessageEmbed ticketClose() {
        EmbedBuilder ticketClose = new EmbedBuilder();
        ticketClose.setTitle("\uD83D\uDD12 〃 Ticket Closed");
        ticketClose.setDescription("Your ticket will be closed in 5 seconds.");
        ticketClose.setColor(Color.decode("#ce5253"));
        return ticketClose.build();
    }
    public MessageEmbed ticketArchive() {
        EmbedBuilder ticketArchive = new EmbedBuilder();
        ticketArchive.setTitle("\uD83D\uDDC3\uFE0F 〃 Ticket Archived");
        ticketArchive.setDescription("Your ticket will be archived in 5 seconds.");
        ticketArchive.setColor(Color.decode("#ce5253"));
        return ticketArchive.build();
    }
    public MessageEmbed ticketRemoveUser(StringBuilder mentionedUsers) {
        EmbedBuilder ticketRemoveUser = new EmbedBuilder();
        ticketRemoveUser.setTitle("\\\uD83C\uDFAB 〃 Remove user from ticket");
        ticketRemoveUser.setDescription("You have removed the following users from the ticket: \n" + mentionedUsers);
        ticketRemoveUser.setColor(Color.decode("#ce5253"));
        return ticketRemoveUser.build();
    }
    public MessageEmbed reactionRolesMain() {
        EmbedBuilder reactionRolesMain = new EmbedBuilder();
        reactionRolesMain.setTitle("\\\uD83E\uDD16 〃 Reaction Roles");
        reactionRolesMain.setDescription("React below to select one of the following roles: \n Script - <:lua:1111218684569071627> \n Map - \\\uD83D\uDDFA\uFE0F\n Clothes - \\\uD83D\uDC55");
        reactionRolesMain.setColor(Color.decode("#ce5253"));
        return reactionRolesMain.build();
    }
    public MessageEmbed reactionRolesGame() {
        EmbedBuilder reactionRolesGame = new EmbedBuilder();
        reactionRolesGame.setTitle("\\\uD83E\uDD16 〃 Reaction Roles");
        reactionRolesGame.setDescription("React below to select one of the following roles: \n Fivem - <:fivemLogo:1111223214631297135> \n AltV - <:altVlogo:1111219542778204160> \n RageMP - \\\uD83E\uDDE7");
        reactionRolesGame.setColor(Color.decode("#ce5253"));
        return reactionRolesGame.build();
    }
    public MessageEmbed reactionRolesFivem() {
        EmbedBuilder reactionRolesFivem = new EmbedBuilder();
        reactionRolesFivem.setTitle("\\\uD83E\uDD16 〃 Reaction Roles");
        reactionRolesFivem.setDescription("React below to select one of the following roles: \n RolePlay - <:roleplayLogo:1111220149446508577> \n Military - <:militaryhelmet:1113492250744336485> \n Drift - <:gtacar:1111219452009267250>");
        reactionRolesFivem.setColor(Color.decode("#ce5253"));
        return reactionRolesFivem.build();
    }
    public MessageEmbed reactionRolesError() {
        EmbedBuilder reactionRolesError = new EmbedBuilder();
        reactionRolesError.setTitle("❌ 〃 Reaction Roles");
        reactionRolesError.setDescription("You don't have the necessary role to use that command!");
        reactionRolesError.setColor(Color.decode("#ce5253"));
        return reactionRolesError.build();
    }
    public MessageEmbed userJoin(User joinUser) {
        EmbedBuilder userJoin = new EmbedBuilder();
        userJoin.setTitle("\uD83D\uDC4B 〃 User joined");
        userJoin.setDescription("Welcome " + joinUser.getAsMention() + ", \n Welcome to the DevCare Solutions discord server!");
        userJoin.setColor(Color.decode("#ce5253"));
        return userJoin.build();
    }
    public MessageEmbed userLeave(User leaveUser) {
        EmbedBuilder userLeave = new EmbedBuilder();
        userLeave.setTitle("\uD83D\uDC4B 〃 User left");
        userLeave.setDescription(leaveUser.getAsTag() + " left us.");
        userLeave.setColor(Color.decode("#ce5253"));
        return userLeave.build();
    }
    public MessageEmbed help() {
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("❓ 〃 Help");
        help.setDescription("All commands are slash commands. They can be invoked with /<command name>");
        help.addField("Currently available commands:", "/help - Shows this message\n/ticket-create - Creates a ticket\n/ticket-add - Adds a user to a ticket\n/ticket-remove - Removes a user from a ticket\n/reaction-roles - Creates a message with reaction roles",false);
        help.setColor(Color.decode("#ce5253"));
        return help.build();
    }
}
