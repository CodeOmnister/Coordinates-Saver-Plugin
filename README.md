# About the Plugin
A Minecraft Java plugin for servers in which players can save, recall, and remove coordinates from a list reachable by multiple commands.  I made this because I was too lazy to search through my file of screenshots to find one set of coordinates.

# Installation
1. Download the latest release on the releases page.
2. Install the latest version of Spigot onto your server. [Here](https://paper.readthedocs.io/en/latest/server/getting-started.html) is a great tutorial on how to migrate to Spigot.
3. Move the downloaded file into the plugin folder in your minecraft server folder.
4. Enjoy!

# USAGE
***/seecoords [.CoordinatesName]***: Used to bring up a list of saved coordinates (Optional: You can put in the name of the coordinates you saved as a parameter to search through the list for it.) 

***/savecoords [CoordinatesName, .x, .y, .z]***: Used to save coordinates to a list. (Optional:  If you don't put in any x, y, or z coordinate as a parameter, the plugin will save your current coordinates.)

***/removecoords [CoordinatesName]***:  Will remove the coordinates specified by the parameter (Note: The parameter is not case sensitive).

# MISC.

. = optional

NOTE: The name of the saved coordinates cannot have any spaces in it, but dashes and underscores can work in place of spaces.
