
/**
 * A player
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Room currentRoom;
    private String name;
    private Item item;
    private int inventory;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name, Room startRoom)
    {
        this.name = name;
        this.currentRoom = startRoom;
        inventory = 0;
    }

    /**
     * 
     */
    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }
    
    /**
     * 
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * 
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     */
    public void takeItem(Item item) {
        this.item = item;
    }
    
    /**
     * 
     */
    public Item getItem() {
        return item;
    }
    
    /**
     * 
     */
    public void dropItem() {
        System.out.println(item.getItemInfo() + " dropped");
        this.item = null;
    }
    
    /**
     * 
     */
    public void takeItem() {
        items.add(item);
        inventory += item.getWeight();
    }
}
