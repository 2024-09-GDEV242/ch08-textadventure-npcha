import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private Item item;
    private String itemWeight;
    private String itemDescription;
    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @parem itemDescription The item's description.
     * @parem itemWeight The item's weight
     */
    public Room(String description, String itemDescription, String itemWeight) 
    {
        this.description = description;
        exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.item = new Item(itemDescription, itemWeight);
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Adds an item to the room.
     */
    public void addItem(String itemDescription, String itemWeight) {
        items.add(new Item(itemDescription, itemWeight));
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * Returns a string containing the information about all items in the room.
     */
    public String getItemsInfor() {
        String getItemsInfor = "";
        for(Item item : items) {
            getItemsInfor += item.getItemInfo() + "\n";
        }
        return getItemsInfor;
    }
    
    /**
     * 
     */
    public Item getItem(String itemName) {
        Item item = null;
        for(Item i : items) {
            if (i.getItemInfo().equals(itemName)) {
                item = i;
                break;
            }
            
            if(item == null) {
                System.out.println("There is no such item in this room.");
                return null;
            }
        
            items.remove(item);
            System.out.println(item.getItemInfo() + " taken");
            //return item;
        }
        return item;
    } 
    
    /**
     * 
     */
    public Item dropItem(String itemName) {
        Item item = null;
        for(Item i : items) {
            if (i.getItemInfo().equals(itemName)) {
                item = i;
                break;
            }
            
            if(item == null) {
                System.out.println("There is no such item in this room.");
                return null;
            }
        
            items.remove(item);
            System.out.println(item.getItemInfo() + " dropped");
        }
        return item;
    } 
    
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room, including exists,
     * and the item if there is one.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + item.getItemInfo();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

