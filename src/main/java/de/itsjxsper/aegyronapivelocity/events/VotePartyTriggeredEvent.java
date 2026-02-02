package de.itsjxsper.aegyronapivelocity.events;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

/**
 * Event fired when a vote party is triggered.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class VotePartyTriggeredEvent extends VelocityEvent {

    private final int totalVotes;
    private final int requiredVotes;
    private final UUID triggeredBy;

    public VotePartyTriggeredEvent(
            int totalVotes,
            int requiredVotes,
            @Nullable UUID triggeredBy
    ) {
        super();
        this.totalVotes = totalVotes;
        this.requiredVotes = requiredVotes;
        this.triggeredBy = triggeredBy;
    }

    /**
     * Gets the total number of votes that triggered the party.
     *
     * @return total votes
     */
    public int getTotalVotes() {
        return totalVotes;
    }

    /**
     * Gets the number of votes that were required.
     *
     * @return required votes
     */
    public int getRequiredVotes() {
        return requiredVotes;
    }

    /**
     * Gets the UUID of the player who triggered the party.
     * This will be empty if the party was triggered automatically.
     *
     * @return optional containing the triggering player's UUID
     */
    public @NonNull Optional<UUID> getTriggeredBy() {
        return Optional.ofNullable(triggeredBy);
    }

    /**
     * Checks if the party was triggered manually by an admin.
     *
     * @return true if manually triggered
     */
    public boolean isManualTrigger() {
        return triggeredBy != null;
    }

    @Override
    public String toString() {
        return "VotePartyTriggeredEvent{" +
                "totalVotes=" + totalVotes +
                ", requiredVotes=" + requiredVotes +
                ", triggeredBy=" + triggeredBy +
                ", timestamp=" + getTimestamp() +
                '}';
    }
}