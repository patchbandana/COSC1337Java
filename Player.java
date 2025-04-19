
public class Player extends Profile {

	public Player() {

	}

	public Player(short x, short y, String n, String d, String r, String c, short h, short s, short dx, short i,
			short a, short com) {
		super(x, y, n, d, r, c, h, s, dx, i, a, com);

	}
	
	public void listInventory()
	{
		for(int x = 0; x < inventory.size(); x++)
		{
			System.out.println("You have " + inventory.get(x).name);
		}
	}

}
