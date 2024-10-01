package com.aryven.multipurposebot.objects;

import com.google.gson.JsonPrimitive;
import dev.mayuna.mayusjsonutils.JsonUtil;
import dev.mayuna.mayusjsonutils.objects.MayuJson;
import dev.mayuna.mayuslibrary.logging.Logger;
import lombok.Getter;

public class Config {

    private static @Getter String botToken = "### Bot Token Here ###";
    private static @Getter String botVersion = "### Bot Version Here ###";
    private static @Getter String botPrefix = "### Bot Prefix Here ###";
    private static @Getter String botName = "### Bot Name Here ###";
    private static @Getter String ownerId = "### Owner ID Here ###";

    private static @Getter String devCategory = "### Dev Category Here ###";
    private static @Getter String questionCategory = "### Question Category Here ###";
    private static @Getter String collaborationCategory = "### Collaboration Category Here ###";
    private static @Getter String otherCategory = "### Other Category Here ###";
    private static @Getter String archiveCategory = "### Archive Category Here ###";

    private static @Getter String welcomeChannel = "### Welcome Channel Here ###";
    private static @Getter String leaveChannel = "### Leave Channel Here ###";
    private static @Getter String reactionChannel = "### Reaction Channel Here ###";

    private static @Getter String adminRole = "### Admin Role Here ###";
    private static @Getter String luaRole = "### Lua Role Here ###";
    private static @Getter String mapsRole = "### Maps Role Here ###";
    private static @Getter String clothesRole = "### Clothes Role Here ###";
    private static @Getter String fivemRole = "### Fivem Role Here ###";
    private static @Getter String ragempRole = "### RageMP Role Here ###";
    private static @Getter String altvRole = "### AltV Role Here ###";
    private static @Getter String roleplayRole = "### RolePlay Role Here ###";
    private static @Getter String militaryRole = "### Military Role Here ###";
    private static @Getter String memberRole = "### Member Role Here ###";
    private static @Getter String driftRole = "### Drift Role Here ###";

    public static void load() {
        try {
            MayuJson json = JsonUtil.createOrLoadJsonFromFile("./bot_config.json");

            botToken = json.getOrCreate("botToken", new JsonPrimitive(botToken)).getAsString();
            botVersion = json.getOrCreate("botVersion", new JsonPrimitive(botVersion)).getAsString();
            botPrefix = json.getOrCreate("botPrefix", new JsonPrimitive(botPrefix)).getAsString();
            botName = json.getOrCreate("botName", new JsonPrimitive(botName)).getAsString();
            ownerId = json.getOrCreate("ownerId", new JsonPrimitive(ownerId)).getAsString();

            devCategory = json.getOrCreate("devCategory", new JsonPrimitive(devCategory)).getAsString();
            questionCategory = json.getOrCreate("questionCategory", new JsonPrimitive(questionCategory)).getAsString();
            collaborationCategory = json.getOrCreate("collaborationCategory", new JsonPrimitive(collaborationCategory)).getAsString();
            otherCategory = json.getOrCreate("otherCategory", new JsonPrimitive(otherCategory)).getAsString();
            archiveCategory = json.getOrCreate("archiveCategory", new JsonPrimitive(archiveCategory)).getAsString();

            welcomeChannel = json.getOrCreate("welcomeChannel", new JsonPrimitive(welcomeChannel)).getAsString();
            leaveChannel = json.getOrCreate("leaveChannel", new JsonPrimitive(leaveChannel)).getAsString();
            reactionChannel = json.getOrCreate("reactionChannel", new JsonPrimitive(reactionChannel)).getAsString();

            adminRole = json.getOrCreate("adminRole", new JsonPrimitive(adminRole)).getAsString();
            luaRole = json.getOrCreate("luaRole", new JsonPrimitive(luaRole)).getAsString();
            mapsRole = json.getOrCreate("mapsRole", new JsonPrimitive(mapsRole)).getAsString();
            clothesRole = json.getOrCreate("clothesRole", new JsonPrimitive(clothesRole)).getAsString();
            fivemRole = json.getOrCreate("fivemRole", new JsonPrimitive(fivemRole)).getAsString();
            ragempRole = json.getOrCreate("ragempRole", new JsonPrimitive(ragempRole)).getAsString();
            altvRole = json.getOrCreate("altvRole", new JsonPrimitive(altvRole)).getAsString();
            roleplayRole = json.getOrCreate("roleplayRole", new JsonPrimitive(roleplayRole)).getAsString();
            militaryRole = json.getOrCreate("militaryRole", new JsonPrimitive(militaryRole)).getAsString();
            driftRole = json.getOrCreate("driftRole", new JsonPrimitive(driftRole)).getAsString();
            memberRole = json.getOrCreate("memberRole", new JsonPrimitive(memberRole)).getAsString();

            json.saveJson();
        } catch (Exception exception){
            exception.printStackTrace();
            Logger.error("Nastala chyba při načítání bot configu!!");
        }
    }

}