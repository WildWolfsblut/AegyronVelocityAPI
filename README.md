# Aegyron Velocity API

Public API for integrating with the Aegyron Core Velocity Plugin. This API allows developers to create custom Velocity
plugins that interact with Aegyron's network-wide features.

## Features

- **Messaging API**: Send messages and broadcasts across the network
- **Group API**: Manage and query server groups
- **Vote API**: Interact with the vote system and vote parties
- **Network Player API**: Query player information across servers
- **Server API**: Get server information and find optimal servers
- **Event System**: React to network events in real-time

## Installation

### Gradle

```gradle
repositories {
    maven { url 'https://repo.example.com/releases' }
}

dependencies {
    compileOnly 'de.itsjxsper:aegyron-api-velocity:1.0.0'
}
```

### plugin.json

```json
{
  "id": "my-custom-plugin",
  "name": "MyCustomPlugin",
  "version": "1.0.0",
  "dependencies": [
    {
      "id": "aegyron-velocity",
      "optional": false
    }
  ]
}
```

## Quick Start

### Getting the API Instance

```java
import de.itsjxsper.aegyronapivelocity.api.AegyronVelocityAPI;

public class MyPlugin {

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        AegyronVelocityAPI.getInstance().ifPresent(api -> {
            // API is available!
            getLogger().info("Aegyron API version: " + api.getVersion());
        });
    }
}
```

### Sending Messages

```java
// Send message to specific player
api.messaging().

sendMessage(playerUUID, Component.text("Hello!"));

// Broadcast to all players
        api.

messaging().

broadcastToAll(Component.text("Server restart in 5 minutes"));

// Broadcast to specific group
        api.

messaging().

broadcastToGroup("survival",Component.text("Event starting!"));

// Create interactive message
        api.

messaging().

builder()
    .

text("Click here to join!")
    .

clickCommand("server lobby-1")
    .

hoverText("Teleport to lobby")
    .

broadcast();
```

### Working with Groups

```java
// Get group information
Optional<GroupInfo> group = api.group().getGroup("survival");
group.

ifPresent(g ->{
        logger.

info("Group: "+g.getGroupName());
        logger.

info("Players: "+g.getTotalPlayers() +"/"+g.

getTotalCapacity());
        logger.

info("Servers: "+g.getServers());
        });

// Check if server is in group
boolean inGroup = api.group().isServerInGroup("survival-1", "survival");

// Get online player count
int players = api.group().getOnlinePlayersInGroup("lobby");
```

### Vote System

```java
// Get player vote stats
Optional<VoteStats> stats = api.vote().getVoteStats(playerUUID);
stats.

ifPresent(s ->{
        logger.

info("Total votes: "+s.getTotalVotes());
        logger.

info("Current streak: "+s.getCurrentStreak());
        logger.

info("Has voted today: "+s.hasVotedToday());
        });

// Get vote party status
VotePartyStatus status = api.vote().getVotePartyStatus();
logger.

info("Vote party progress: "+status.getCurrentVotes() +"/"+status.

getRequiredVotes());
        logger.

info("Votes remaining: "+status.getVotesRemaining());

// Trigger vote party (admin command)
        api.

vote().

triggerVoteParty().

thenRun(() ->{
        logger.

info("Vote party triggered!");
});
```

### Server Information

```java
// Get server info
Optional<ServerInfo> server = api.server().getServerInfo("lobby-1");
server.

ifPresent(s ->{
        logger.

info("Server: "+s.getServerName());
        logger.

info("Status: "+s.getStatus());
        logger.

info("Players: "+s.getCurrentPlayers() +"/"+s.

getMaxPlayers());
        logger.

info("Load: "+s.getLoad());
        });

// Find best server to join
Optional<ServerInfo> best = api.server().findBestServer("survival");
best.

ifPresent(s ->{
        logger.

info("Best server: "+s.getServerName());
        // Connect player to this server
        });

// Get all online servers
List<ServerInfo> online = api.server().getOnlineServers();
logger.

info("Online servers: "+online.size());
```

### Network Player Queries

```java
// Get total online players
int online = api.networkPlayer().getOnlineCount();

// Find which server a player is on
Optional<String> server = api.networkPlayer().getPlayerServer(playerUUID);
server.

ifPresent(s ->logger.

info("Player is on: "+s));

// Check if player is online
boolean isOnline = api.networkPlayer().isPlayerOnline(playerUUID);

// Get all players in a group
List<UUID> players = api.networkPlayer().getPlayersInGroup("survival");
```

## Event System

### Listening to Events

Events are fired using Velocity's standard event system. Simply create a listener:

```java
import de.itsjxsper.aegyronapivelocity.events.*;
import com.velocitypowered.api.event.Subscribe;

public class MyEventListener {

    @Subscribe
    public void onServerSwitch(ServerSwitchEvent event) {
        UUID player = event.getPlayerUUID();
        String from = event.getFromServer();
        String to = event.getToServer();

        logger.info("Player " + player + " switched from " + from + " to " + to);
    }

    @Subscribe
    public void onVoteParty(VotePartyTriggeredEvent event) {
        logger.info("Vote party triggered! Total votes: " + event.getTotalVotes());

        if (event.isManualTrigger()) {
            event.getTriggeredBy().ifPresent(uuid -> {
                logger.info("Manually triggered by: " + uuid);
            });
        }
    }

    @Subscribe
    public void onVoteReceived(VoteReceivedEvent event) {
        UUID player = event.getPlayerUUID();
        String service = event.getServiceName();
        int total = event.getNewTotalVotes();
        int streak = event.getCurrentStreak();

        logger.info("Player " + player + " voted on " + service);
        logger.info("Total votes: " + total + ", Streak: " + streak);
    }

    @Subscribe
    public void onAnnouncement(NetworkAnnouncementEvent event) {
        Component message = event.getMessage();
        String type = event.getType();

        if (event.isGroupSpecific()) {
            event.getTargetGroup().ifPresent(group -> {
                logger.info("Announcement for group " + group + ": " + type);
            });
        } else {
            logger.info("Network-wide announcement: " + type);
        }
    }
}
```

### Available Events

- **ServerSwitchEvent**: Fired when a player switches servers
- **VotePartyTriggeredEvent**: Fired when a vote party is triggered
- **VoteReceivedEvent**: Fired when a player votes
- **NetworkAnnouncementEvent**: Fired when a network announcement is made

## Advanced Usage

### Async Operations

Many API methods return `CompletableFuture` for async operations:

```java
// Async vote stats retrieval
api.vote().

getVoteStatsAsync(playerUUID)
    .

thenAccept(stats ->{
        stats.

ifPresent(s ->{
        // Handle stats
        });
        })
        .

exceptionally(throwable ->{
        logger.

error("Failed to get vote stats",throwable);
        return null;
                });

// Async group reload
                api.

group().

reloadAllGroups()
    .

thenRun(() ->logger.

info("All groups reloaded"))
        .

exceptionally(throwable ->{
        logger.

error("Failed to reload groups",throwable);
        return null;
                });
```

### Complex Message Building

```java
Component message = api.messaging().builder()
        .text("Welcome to ")
        .component(Component.text("Aegyron", NamedTextColor.GOLD))
        .text("!")
        .clickUrl("https://example.com")
        .hoverText("Click to visit our website")
        .build();

// Send to specific player
api.

messaging().

builder()
    .

text("Click to teleport")
    .

clickCommand("spawn")
    .

hoverComponent(Component.text("Go to spawn", NamedTextColor.GREEN))
        .

send(playerUUID);
```

### Finding Optimal Servers

```java
// Find best server with custom logic
List<ServerInfo> candidates = api.server().getServersWithCapacity("survival");

Optional<ServerInfo> optimal = candidates.stream()
        .filter(s -> s.getLoad() != ServerLoad.CRITICAL)
        .filter(s -> s.getCurrentPlayers() > 5) // Prefer populated servers
        .min(Comparator.comparingDouble(ServerInfo::getLoadPercentage));

optimal.

ifPresent(server ->{
        // Connect player to optimal server
        });
```

## Best Practices

1. **Always check Optional values** - Don't assume API instances or data are always present
2. **Handle CompletableFuture exceptions** - Use `exceptionally()` to handle errors gracefully
3. **Use events for real-time updates** - Don't poll the API repeatedly
4. **Cache data when appropriate** - Reduce API calls by caching non-critical data
5. **Respect async operations** - Don't block the main thread waiting for futures

## Troubleshooting

### API Not Available

If `AegyronVelocityAPI.getInstance()` returns empty:

1. Ensure Aegyron-Velocity plugin is installed and loaded
2. Check that your plugin depends on Aegyron in plugin.json
3. Verify you're checking the API after ProxyInitializeEvent

### Events Not Firing

1. Make sure you've registered your event listener
2. Check that Aegyron-Velocity is loaded before your plugin
3. Verify event handler methods have `@Subscribe` annotation
