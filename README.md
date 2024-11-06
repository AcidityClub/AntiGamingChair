# AntiGamingChair
AntiGamingChair is an advanced Minecraft anti-cheat that is currently used on Minemen.Club. It has various ways to detect Auto Clicker, Aim Assist, Kill Aura, and way more unfair advantage-giving modifications.

The goal of this project is to build upon an old version of AGC, and try to replicate how the latest version (only used on Minemen) works.

! This isn't anywhere near a perfect replication of latest AntiGamingChair, it just uses ideas from the latest AntiGamingChair and builds upon them !

### Notice
Keep in mind this project was made entirely for educational purposes. I am just trying to create a open-source project people can learn from and use.

Also, this project will need extra contributors, as I may not be able to do everything by myself. Thanks.

## Features
AntiGamingChair has many features that make it stand out against most other anti-cheats.

### Variety of Accurate Detections
AGC has MANY checks to detect even the most subtle cheats. The cheats detected include but are not limited to:

- Auto Clicker: Detects Auto Clicker cheats, including those with heavy randomization.

- Aim Assist: Detects Aim Assist and other aim-related cheats.

- Reach (Range Check): Detects Reach cheats, even if the cheat is giving less than 0.1 blocks of advantage.

- Hit Box: Detects cheats that expand the size of client-sided hitboxes.

- Ping Spoof: Detects cheats that attempt to artifically raise ping.

- Fly: Detects cheats that give a movement advantage, even if it's small.

- Inventory: Detects cheats that are related to Inventory management and such.

Those are just a few of the checks the latest version of AntiGamingChair has.

### Packet Based
Although AGC may be using ClubSpigot as opposed to a library like PacketEvents or ProtocolLib, it still uses packets as it's main way to check for cheats.
