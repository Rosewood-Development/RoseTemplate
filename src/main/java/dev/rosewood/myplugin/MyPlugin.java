package dev.rosewood.myplugin;

import dev.rosewood.myplugin.config.SettingKey;
import dev.rosewood.myplugin.manager.CommandManager;
import dev.rosewood.myplugin.manager.DataManager;
import dev.rosewood.myplugin.manager.ExampleManager;
import dev.rosewood.myplugin.manager.LocaleManager;
import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.config.SettingHolder;
import dev.rosewood.rosegarden.manager.Manager;

import java.util.List;
import org.jetbrains.annotations.Nullable;

public class MyPlugin extends RosePlugin {

    private static MyPlugin instance;

    public static MyPlugin getInstance() {
        return instance;
    }

    public MyPlugin() {
        super(-1, -1,
                DataManager.class,
                LocaleManager.class,
                CommandManager.class
        );

        instance = this;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    protected List<Class<? extends Manager>> getManagerLoadPriority() {
        return List.of(ExampleManager.class);
    }

    @Override
    protected SettingHolder getRoseConfigSettingHolder() {
        return SettingKey.INSTANCE;
    }

}
