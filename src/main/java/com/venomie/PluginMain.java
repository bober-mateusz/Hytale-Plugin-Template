package com.venomie;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

public class PluginMain extends JavaPlugin {

    public  PluginMain(@Nonnull JavaPluginInit init) {
       super(init);
    }

    @Override
    protected void setup(){
        super.setup();
        this.getCommandRegistry().registerCommand(new HelloCommand("Hello", "An example command", false));
    }

}
