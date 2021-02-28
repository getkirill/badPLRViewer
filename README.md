# enhancedPLRViewer
This fork is used to enhance this project by fixing bugs and upgrading stuff.
What this fork currently done:
 - Made [Item](src/one/Item.java) related classes ([InventoryItem](src/one/InventoryItem.java), [ResearchItem](src/one/ResearchItem.java)) extend it.
 - Keeping track on items with [ItemsCsv](src/one/ItemsCsv.java) (Mostly for ResearchItem)
 - **[New 1.2]** [API](src/com/kraskaska/terraria/plr/API.java), which can modify your data! As simple as import library & class into your project, create instance of API, and use `API.getData()` to retrieve [Data](src/com/kraskaska/terraria/plr/API.java) 
# badPLRViewer

A incredibly bad, text-only program that decodes .plr files for Terraria 1.4.1.2.

Works to my knowledge, but there's probably a really shitty fuck-up in there somewhere.

Used in https://youtu.be/OWGErWGZhZI for testing.

You'll need to put in your file paths in src/one/Main.java

License CC BY-NC-SA 3.0

-- Photon
# Licensing
 - Package [`one`](src/one) is licensed by Photon under CC-BY-NC-SA 2.0
 - Package [`com.kraskaska.terraria.plr`](src/com/kraskaska/terraria/plr) is licensed under GPLv3
