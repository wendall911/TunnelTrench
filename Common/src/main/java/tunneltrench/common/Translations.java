package tunneltrench.common;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import org.slf4j.helpers.MessageFormatter;

public class Translations {

    private static final Joiner LINE_JOINER = Joiner.on("\n");
    private static final Map<String, String> translations = Maps.newHashMap();

    static {
        translations.put("general.title", "General Settings");
        translations.put("general", "General settings section description.");
        translations.put("debugenabled", joiner(
            "Show debug info.",
            "And do other stuff."
        ));
        translations.put("items", "Item Settings");
        translations.put("disableexampleitem", "Disable example item.");
        translations.put("exampleitemdurability", "Example item durability.");
    }

    public static String get(String key) {
        return translations.getOrDefault(key, key);
    }

    public static String get(String key, String... values) {
        return MessageFormatter.arrayFormat(translations.getOrDefault(key, key), values).getMessage();
    }

    private static String joiner(String... string) {
        return LINE_JOINER.join(string);
    }

}
