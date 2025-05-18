package dev.rosewood.myplugin.config;

import dev.rosewood.myplugin.MyPlugin;
import dev.rosewood.rosegarden.config.RoseSetting;

import dev.rosewood.rosegarden.config.SettingHolder;
import dev.rosewood.rosegarden.config.SettingSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import static dev.rosewood.rosegarden.config.SettingSerializers.*;

public class SettingKey implements SettingHolder {

    public static final SettingKey INSTANCE = new SettingKey();
    private static final List<RoseSetting<?>> KEYS = new ArrayList<>();

    public static final RoseSetting<ConfigurationSection> EXAMPLE_SECTION = create("example-section", "This is an example section");
    public static final RoseSetting<String> EXAMPLE_STRING = create("example-section.example-string", STRING, "value", "This is an example string");
    public static final RoseSetting<Integer> EXAMPLE_INT = create("example-section.example-int", INTEGER, 1, "This is an example integer");
    public static final RoseSetting<Boolean> EXAMPLE_BOOLEAN = create("example-section.example-boolean", BOOLEAN, true, "This is an example boolean");
    public static final RoseSetting<Double> EXAMPLE_DOUBLE = create("example-section.example-double", DOUBLE, 1.0, "This is an example double");
    public static final RoseSetting<List<String>> EXAMPLE_LIST = create("example-section.example-list", STRING_LIST, List.of("value1", "value2"), "This is an example list");

    private static <T> RoseSetting<T> create(String key, SettingSerializer<T> serializer, T defaultValue, String... comments) {
        RoseSetting<T> setting = RoseSetting.ofBackedValue(key, MyPlugin.getInstance(), serializer, defaultValue, comments);
        KEYS.add(setting);
        return setting;
    }

    private static RoseSetting<ConfigurationSection> create(String key, String... comments) {
        RoseSetting<ConfigurationSection> setting = RoseSetting.ofBackedSection(key, MyPlugin.getInstance(), comments);
        KEYS.add(setting);
        return setting;
    }

    public static List<RoseSetting<?>> getKeys() {
        return Collections.unmodifiableList(KEYS);
    }

    private SettingKey() { }

    @Override
    public List<RoseSetting<?>> get() {
        return KEYS;
    }

}
