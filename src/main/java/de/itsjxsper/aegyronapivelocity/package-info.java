/**
 * Public API for Aegyron Velocity Plugin.
 *
 * <p>This API allows developers to create custom Velocity plugins that integrate with
 * Aegyron Core's network-wide features. The API provides access to messaging, server groups,
 * voting system, and network player information.</p>
 *
 * <h2>Getting Started</h2>
 *
 * <pre>{@code
 * // Get the API instance
 * Optional<AegyronVelocityAPI> apiOpt = AegyronVelocityAPI.getInstance();
 *
 * // Use the API
 * apiOpt.ifPresent(api -> {
 *     api.messaging().broadcastToAll(Component.text("Hello Network!"));
 * });
 * }</pre>
 *
 * <h2>Main API Interfaces</h2>
 * <ul>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.api.AegyronVelocityAPI} - Main API entry point</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.api.MessageAPI} - Messaging and broadcasts</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.api.GroupAPI} - Server group operations</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.api.VoteAPI} - Vote system</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.api.NetworkPlayerAPI} - Player queries</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.api.ServerAPI} - Server information</li>
 * </ul>
 *
 * <h2>Events</h2>
 * <p>The API provides several events that can be listened to:</p>
 * <ul>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.events.ServerSwitchEvent}</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.events.VotePartyTriggeredEvent}</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.events.VoteReceivedEvent}</li>
 *   <li>{@link de.itsjxsper.aegyronapivelocity.events.NetworkAnnouncementEvent}</li>
 * </ul>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
package de.itsjxsper.aegyronapivelocity;