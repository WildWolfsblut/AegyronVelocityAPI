package de.itsjxsper.aegyronapivelocity.models;

import de.itsjxsper.aegyroncommon.enums.server.ServerLoad;
import de.itsjxsper.aegyroncommon.enums.server.ServerStatus;
import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents information about a server.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerInfo {

    private final UUID serverUUID;
    private final String serverName;
    private final UUID groupUUID;
    private final ServerStatus status;
    private final int currentPlayers;
    private final int maxPlayers;
    private final ServerLoad load;
    private final Instant lastHeartbeat;

    public ServerInfo(
            @NonNull UUID serverUUID,
            @NonNull String serverName,
            @NonNull UUID groupUUID,
            @NonNull ServerStatus status,
            int currentPlayers,
            int maxPlayers,
            @NonNull ServerLoad load,
            @NonNull Instant lastHeartbeat
    ) {
        this.serverUUID = Objects.requireNonNull(serverUUID, "serverUUID");
        this.serverName = Objects.requireNonNull(serverName, "serverName");
        this.groupUUID = Objects.requireNonNull(groupUUID, "groupUUID");
        this.status = Objects.requireNonNull(status, "status");
        this.currentPlayers = currentPlayers;
        this.maxPlayers = maxPlayers;
        this.load = Objects.requireNonNull(load, "load");
        this.lastHeartbeat = Objects.requireNonNull(lastHeartbeat, "lastHeartbeat");
    }

    /**
     * Gets the UUID of this server.
     *
     * @return server UUID
     */
    public @NonNull UUID getServerUUID() {
        return serverUUID;
    }

    /**
     * Gets the name of this server.
     *
     * @return server name
     */
    public @NonNull String getServerName() {
        return serverName;
    }

    /**
     * Gets the UUID of the group this server belongs to.
     *
     * @return group UUID
     */
    public @NonNull UUID getGroupUUID() {
        return groupUUID;
    }

    /**
     * Gets the current status of this server.
     *
     * @return server status
     */
    public @NonNull ServerStatus getStatus() {
        return status;
    }

    /**
     * Gets the current number of players on this server.
     *
     * @return current player count
     */
    public int getCurrentPlayers() {
        return currentPlayers;
    }

    /**
     * Gets the maximum number of players allowed on this server.
     *
     * @return maximum player count
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Gets the current load level of this server.
     *
     * @return server load
     */
    public @NonNull ServerLoad getLoad() {
        return load;
    }

    /**
     * Gets the timestamp of the last heartbeat received from this server.
     *
     * @return last heartbeat timestamp
     */
    public @NonNull Instant getLastHeartbeat() {
        return lastHeartbeat;
    }

    /**
     * Checks if this server is online.
     *
     * @return true if server is online
     */
    public boolean isOnline() {
        return status == ServerStatus.ONLINE;
    }

    /**
     * Checks if this server is at full capacity.
     *
     * @return true if server is full
     */
    public boolean isFull() {
        return currentPlayers >= maxPlayers;
    }

    /**
     * Calculates the load percentage of this server.
     *
     * @return load percentage (0.0 to 1.0)
     */
    public double getLoadPercentage() {
        return maxPlayers > 0 ? (double) currentPlayers / maxPlayers : 0.0;
    }

    /**
     * Gets the number of available player slots.
     *
     * @return available slots
     */
    public int getAvailableSlots() {
        return Math.max(0, maxPlayers - currentPlayers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerInfo that)) return false;
        return serverUUID.equals(that.serverUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverUUID);
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "serverName='" + serverName + '\'' +
                ", status=" + status +
                ", players=" + currentPlayers + "/" + maxPlayers +
                ", load=" + load +
                '}';
    }
}