package de.itsjxsper.aegyronapivelocity.models;

/**
 * Represents the status of the vote party system.
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public class VotePartyStatus {

    private final int currentVotes;
    private final int requiredVotes;
    private final boolean active;

    public VotePartyStatus(int currentVotes, int requiredVotes, boolean active) {
        this.currentVotes = currentVotes;
        this.requiredVotes = requiredVotes;
        this.active = active;
    }

    /**
     * Gets the current number of votes collected.
     *
     * @return current votes
     */
    public int getCurrentVotes() {
        return currentVotes;
    }

    /**
     * Gets the number of votes required to trigger the party.
     *
     * @return required votes
     */
    public int getRequiredVotes() {
        return requiredVotes;
    }

    /**
     * Checks if the vote party is currently active.
     *
     * @return true if active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Gets the number of votes needed until the party triggers.
     *
     * @return votes remaining
     */
    public int getVotesRemaining() {
        return Math.max(0, requiredVotes - currentVotes);
    }

    /**
     * Calculates the progress percentage towards the vote party.
     *
     * @return progress percentage (0.0 to 1.0)
     */
    public double getProgress() {
        return requiredVotes > 0 ? (double) currentVotes / requiredVotes : 0.0;
    }

    /**
     * Checks if the vote party is ready to trigger.
     *
     * @return true if current votes >= required votes
     */
    public boolean isReady() {
        return currentVotes >= requiredVotes;
    }

    @Override
    public String toString() {
        return "VotePartyStatus{" +
                "currentVotes=" + currentVotes +
                ", requiredVotes=" + requiredVotes +
                ", active=" + active +
                ", progress=" + String.format("%.1f%%", getProgress() * 100) +
                '}';
    }
}