package de.itsjxsper.aegyronapivelocity.events;

import org.jspecify.annotations.NonNull;

import java.util.Objects;
import java.util.UUID;

/**
 * Event fired when a player votes for the server.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class VoteReceivedEvent extends VelocityEvent {

    private final UUID playerUUID;
    private final String serviceName;
    private final int newTotalVotes;
    private final int currentStreak;

    public VoteReceivedEvent(
            @NonNull UUID playerUUID,
            @NonNull String serviceName,
            int newTotalVotes,
            int currentStreak
    ) {
        super();
        this.playerUUID = Objects.requireNonNull(playerUUID, "playerUUID");
        this.serviceName = Objects.requireNonNull(serviceName, "serviceName");
        this.newTotalVotes = newTotalVotes;
        this.currentStreak = currentStreak;
    }

    /**
     * Gets the UUID of the player who voted.
     *
     * @return player UUID
     */
    public @NonNull UUID getPlayerUUID() {
        return playerUUID;
    }

    /**
     * Gets the name of the voting service.
     *
     * @return service name (e.g., "MinecraftServers", "TopG")
     */
    public @NonNull String getServiceName() {
        return serviceName;
    }

    /**
     * Gets the player's new total vote count after this vote.
     *
     * @return new total votes
     */
    public int getNewTotalVotes() {
        return newTotalVotes;
    }

    /**
     * Gets the player's current vote streak after this vote.
     *
     * @return current streak
     */
    public int getCurrentStreak() {
        return currentStreak;
    }

    @Override
    public String toString() {
        return "VoteReceivedEvent{" +
                "playerUUID=" + playerUUID +
                ", serviceName='" + serviceName + '\'' +
                ", newTotalVotes=" + newTotalVotes +
                ", currentStreak=" + currentStreak +
                ", timestamp=" + getTimestamp() +
                '}';
    }
}