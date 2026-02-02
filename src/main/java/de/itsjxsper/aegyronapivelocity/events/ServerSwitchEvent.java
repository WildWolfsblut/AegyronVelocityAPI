package de.itsjxsper.aegyronapivelocity.events;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.UUID;

/**
 * Event fired when a player switches between servers.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerSwitchEvent extends VelocityEvent {

    private final UUID playerUUID;
    private final String fromServer;
    private final String toServer;

    public ServerSwitchEvent(
            @NonNull UUID playerUUID,
            @NonNull String fromServer,
            @NonNull String toServer
    ) {
        super();
        this.playerUUID = Objects.requireNonNull(playerUUID, "playerUUID");
        this.fromServer = Objects.requireNonNull(fromServer, "fromServer");
        this.toServer = Objects.requireNonNull(toServer, "toServer");
    }

    /**
     * Gets the UUID of the player who switched servers.
     *
     * @return player UUID
     */
    public @NonNull UUID getPlayerUUID() {
        return playerUUID;
    }

    /**
     * Gets the name of the server the player came from.
     *
     * @return from server name
     */
    public @NonNull String getFromServer() {
        return fromServer;
    }

    /**
     * Gets the name of the server the player is going to.
     *
     * @return to server name
     */
    public @NonNull String getToServer() {
        return toServer;
    }

    @Override
    public String toString() {
        return "ServerSwitchEvent{" +
                "playerUUID=" + playerUUID +
                ", fromServer='" + fromServer + '\'' +
                ", toServer='" + toServer + '\'' +
                ", timestamp=" + getTimestamp() +
                '}';
    }
}