package de.itsjxsper.aegyronapivelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(id = "aegyron_api_velocity", name = "Aegyron API Velocity", version = BuildConstants.VERSION, authors = {"ItsJxsper"})
public class AegyronAPIVelocity {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
