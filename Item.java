
/**
 * Item in each room
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String description;
    private String weight;

    /**
     * @parem itemDescription The item's description.
     * @parem itemWeight The item's weight
     */
    public Item(String description, String weight) 
    {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Returns a string containing the information about the item in the room.
     * 
     */
    public String getItemInfo()
    {
        if(description.equals("")) {
            return "";
        }
        return "There is " + description + ", weight: " + weight;
    }
}
