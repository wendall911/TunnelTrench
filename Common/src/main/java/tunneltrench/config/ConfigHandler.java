package tunneltrench.config;

import org.apache.commons.lang3.tuple.Pair;

import technology.roughness.whitenoise.config.WhiteNoiseConfigSpec;

import tunneltrench.common.Translations;

public class ConfigHandler {

    public static final WhiteNoiseConfigSpec CLIENT_SPEC;
    public static final WhiteNoiseConfigSpec COMMON_SPEC;

    private static final Client CLIENT;
    private static final Common COMMON;
    private static boolean loaded = false;

    static {
        final Pair<Client, WhiteNoiseConfigSpec> specPairClient = new WhiteNoiseConfigSpec.Builder().configure(Client::new);
        final Pair<Common, WhiteNoiseConfigSpec> specPairCommon = new WhiteNoiseConfigSpec.Builder().configure(Common::new);

        CLIENT_SPEC = specPairClient.getRight();
        CLIENT = specPairClient.getLeft();
        COMMON_SPEC = specPairCommon.getRight();
        COMMON = specPairCommon.getLeft();
    }

    public static void init() {
        loaded = true;
    }

    public static class Client {

        public Client(WhiteNoiseConfigSpec.Builder builder) {
        }

    }

    public static class Common {

        public final WhiteNoiseConfigSpec.BooleanValue debugEnabled;
        private final WhiteNoiseConfigSpec.BooleanValue disableExampleItem;
        private final WhiteNoiseConfigSpec.IntValue exampleItemDurability;

        public Common(WhiteNoiseConfigSpec.Builder builder) {
            builder.push("General");

            debugEnabled = builder
                .worldRestart()
                .comment(getTranslation("debugenabled"))
                .define("debugEnabled", false);

            builder.push("Items");

            disableExampleItem = builder
                .comment(getTranslation("disableexampleitem"))
                .clientRestart()
                .define("disableExampleItem", false);
            exampleItemDurability = builder
                .comment(getTranslation("exampleitemdurability"))
                .clientRestart()
                .defineInRange("exampleItemDurability", 15, 1, 100);
        }

        public static boolean debugEnabled() {
            return COMMON.debugEnabled.get();
        }

        public static boolean disableExampleItem() {
            if (loaded) {
                return COMMON.disableExampleItem.get();
            }

            return false;
        }

        public static int exampleItemDurability() {
            return COMMON.exampleItemDurability.get();
        }

        public static boolean getConfigValue(String key) {
            return switch (key) {
                case "disableExampleItem" -> disableExampleItem();
                default -> false;
            };
        }

    }

    private static String getTranslation(String key) {
        return Translations.get(key);
    }

    private static String getTranslation(String key, String... values) {
        return Translations.get(key, values);
    }

}
