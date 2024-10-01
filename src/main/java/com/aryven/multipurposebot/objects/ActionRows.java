package com.aryven.multipurposebot.objects;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class ActionRows {

    public EntitySelectMenu ticketAdd() {
        EntitySelectMenu ticketAdd = EntitySelectMenu.create("add-user", EntitySelectMenu.SelectTarget.USER)
                .setPlaceholder("Select user")
                .setMinValues(1)
                .setMaxValues(10)
                .build();
        return ticketAdd;
    }

    public StringSelectMenu ticketCreation() {
        StringSelectMenu categorySelection = StringSelectMenu.create("category-selection")
                .setPlaceholder("Select category")
                .addOptions(SelectOption.of("DEV", "dev")
                        .withEmoji(Emoji.fromUnicode("\u2328\uFE0F"))
                        .withDefault(false))
                .addOptions(SelectOption.of("Question", "otazka")
                        .withEmoji(Emoji.fromUnicode("\u2753"))
                        .withDefault(false))
                .addOptions(SelectOption.of("Collaboration", "spoluprace")
                        .withEmoji(Emoji.fromUnicode("\uD83D\uDCB0"))
                        .withDefault(false))
                .addOptions(SelectOption.of("Other", "ostatni")
                        .withEmoji(Emoji.fromUnicode("\uD83D\uDD00"))
                        .withDefault(false))
                .build();
        return categorySelection;
    }
    public EntitySelectMenu ticketRemove() {
        EntitySelectMenu ticketRemove = EntitySelectMenu.create("remove-user", EntitySelectMenu.SelectTarget.USER)
                .setPlaceholder("Select user")
                .setMinValues(1)
                .setMaxValues(10)
                .build();
        return ticketRemove;
    }
    public Button ticketClose() {
        Button ticketClose = Button.danger("close", "Close Ticket")
                        .withEmoji(Emoji.fromUnicode(	"\uD83D\uDD12"));
        return ticketClose;
    }
    public Button ticketArchive() {
        Button ticketArchive = Button.secondary("archive", "Archive Ticket")
                .withEmoji(Emoji.fromUnicode("\uD83D\uDDC3\uFE0F"));
        return ticketArchive;
    }

}
