import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*	TO DO:
 * Validate map
 * Validate players
 * move players
 * items on map
 * combat
 * characters hold items
 * inventory
 * kill character
 * kill player
 * graphical map
 * steal
 * win
 */

public class Adventure 
{

	public static final int MAX_X = 10;
	public static final int MAX_Y = 10;

	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int maxProfiles = 20;
		int numChars = 0;
		String charFile = "../data/characters.csv";
		String itemFile = "../data/items.csv";
		Profile[] characters = new Profile[maxProfiles];
		//we are characters[0]
		
		String mapFile = "../data/map.csv";

		boolean playing = true;
		
		MapBlock[][] m = new MapBlock[MAX_X][MAX_Y];
		
		for( int i = 0; i < MAX_X; i++)
		{
			for(int j = 0; j < MAX_Y; j++)
			{
				m[i][j] = new MapBlock();
			}
		}
	
		init(mapFile, m);
		if(verify(m))
		{
			numChars = init(charFile,characters,m);  //load characters
			init(characters,m,itemFile);			//load items
			
			while(playing)
			{
				moveChars(m,characters,numChars);
				showMap(m,characters);
				showItems(m[characters[0].xpos][characters[0].ypos]);
				showChars(characters, numChars);
				playing = npcCombat(characters, numChars);
				if(playing)
				{
					playing = actionHandler(m,characters,numChars);
					//add attack functionality
					//check for win
				}
			}
		}
		System.out.println("Goodbye");	
		s.close();
	}
	
	private static boolean npcCombat(Profile[] c, int numChar)
	{
		boolean alive = true;
		
		for(int i = 1; i < numChar; i++)
		{
			if(c[0].isHere(c[i]))
			{//in same block
				if (c[i].isCombative())
				{

					System.out.println("Rolling for Initiative...");
					if(!rollForInitiative())
					{
						System.out.println(c[i].getName() + " is attacking...");
						if(c[i].hit(c[0]))
						{
							//he hit.  determine damage...
							//damage = Attacker strength + roll(10)
							int damage = c[i].getStrength() + Die.roll(10);
							System.out.println(c[i].getName() + " hits with " + damage + " damage.");
							alive =  c[0].takeHit(damage);
							System.out.println("Your Hit Points: " + c[0].getHitPoints());
							if (!alive)
							{
								System.out.println("You are dead. Enjoy the afterlife.");
							}
						}
					}
				}
			}
		}
		return alive;
	}
	
	private static void combat(Profile[] c, int numChar)
	{
	
		for(int i = 1; i < numChar; i++)
		{
			if(c[0].isHere(c[i]))
			{//in same block
				if (c[i].isCombative())
				{
					boolean alive = true;
					System.out.println("You swing at " + c[i].getName());
					if(c[0].hit(c[i]))
					{
						//he hit.  determine damage...
						//damage = Attacker strength + roll(10)
						int damage = c[0].getStrength() + Die.roll(10);
						System.out.println(c[0].getName() + " hits with " + damage + " damage.");
						alive =  c[i].takeHit(damage);
						System.out.println(c[i].getName() + " Hit Points: " + c[i].getHitPoints());
						if (!alive)
						{
							System.out.println(c[i].getName() + " is dead.");
							c[i].kill();
							//drop items
						}
					}
				
				}
			}
		}
	}
	
	private static boolean rollForInitiative()
	{
		int myRoll = Die.roll(10);
		int npcRoll = Die.roll(10);
		
		System.out.println("Rolling...  " + myRoll + " vs " + npcRoll);
		
		if(myRoll >= npcRoll)
		{
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static void showItems(MapBlock mb) 
	{
		for(int i = 0; i < mb.itemsHere.size(); i++)
		{
			System.out.println("There is a " +  mb.itemsHere.get(i).name + " here.");	
		}
		
	}

	private static void moveChars(MapBlock[][] m, Profile[] characters, int numChars)
	{
		for(int i = 1; i< numChars;i++)
		{
			if(characters[i] instanceof Moveable)
			{
				Moveable n = (Moveable)characters[i];
				n.move(m);
			}
		}
	}

	private static void showChars(Profile[] c, int numChars) 
	{
		for(int idx = 1;idx < numChars;idx++)
		{
			if((c[0].xpos == c[idx].xpos) && (c[0].ypos == c[idx].ypos))
			{
				//same place
				System.out.println( c[idx].getName() + " is here");
			}
		}
		
	}
	
	public static void showMap(MapBlock[][] m, Profile[] characters)
	{
		System.out.printf("\n%s\n%s\n",m[characters[0].xpos][characters[0].ypos].getTitle(),m[characters[0].xpos][characters[0].ypos].getDescription());
		
	}

	public static boolean actionHandler(MapBlock[][] m, Profile[] characters, int numChars)
	{
		boolean playing = true;
		
		String words = "";
		String command = "";
		
		while(command.length() == 0)
		{
			System.out.println("Next Move: ");
			command = s.nextLine();
		}
		
		command = command.toLowerCase();
		int splitAt = command.indexOf(' ');
		if (splitAt > 0)
		{
			words = command.substring(splitAt + 1);
		}
		char cmd = command.charAt(0);
		
		//n,s,e,w,g,d,a,x
		switch(cmd)
		{
		case 'i':
			Player p = (Player)characters[0];
			p.listInventory();
			break;
		case 'n':
			if(m[characters[0].xpos][characters[0].ypos].go(direction.NORTH))
			{
				characters[0].ypos--;
			}
			else
			{
				System.out.println("Can't go that way...");
			}
			break;
		case 's':
			if(m[characters[0].xpos][characters[0].ypos].go(direction.SOUTH))
			{
				characters[0].ypos++;
			}
			else
			{
				System.out.println("Can't go that way...");
			}
			break;
		case 'e':
			if(m[characters[0].xpos][characters[0].ypos].go(direction.EAST))
			{
				characters[0].xpos++;
			}
			else
			{
				System.out.println("Can't go that way...");
			}
			break;
		case 'w':
			if(m[characters[0].xpos][characters[0].ypos].go(direction.WEST))
			{
				characters[0].xpos--;
			}
			else
			{
				System.out.println("Can't go that way...");
			}
			break;
		case 'g':
			int itemIndex = -1;
			for(int i = 0; i < m[characters[0].xpos][characters[0].ypos].itemsHere.size(); i++ )
			{
				if(words.equalsIgnoreCase(m[characters[0].xpos][characters[0].ypos].itemsHere.get(i).name))
				{
					itemIndex = i;
				}
			}
			
			if(itemIndex == -1) {
				System.out.println("There is no " + words + " here to get.");
			} else {
				getItem(characters[0],m[characters[0].xpos][characters[0].ypos],itemIndex);
				System.out.println("You now have the " + characters[0].inventory.getLast().name);
			}
			break;
		case 'd':    //drop item
			itemIndex = -1;
			for(int i = 0; i < characters[0].inventory.size(); i++ )
			{
				if(words.equalsIgnoreCase(characters[0].inventory.get(i).name))
				{
					itemIndex = i;
				}
			}
			
			if(itemIndex == -1) {
				System.out.println("You don't have a " + words + " in your inventory.");
			} else {
				Item droppedItem = characters[0].inventory.get(itemIndex);
				dropItem(characters[0],m[characters[0].xpos][characters[0].ypos],itemIndex);
				System.out.println("You have dropped the " + droppedItem.name);
			}
			break;
		case 'a':
			//attack...
			combat(characters,numChars);
			
			
			
			break;
			
			//add i for inventory
		case 'x':
			playing = false;
			break;
		default:
			System.out.println("Not a valid command\n");
			break;
		}
		
		
		return playing;
	}
	
	private static void dropItem(Profile c, MapBlock mb, int itemIndex) 
	{
		mb.itemsHere.add(c.inventory.remove(itemIndex));
	}

	
	private static void getItem(Profile c, MapBlock mb, int itemIndex)
	{
		c.inventory.add(mb.itemsHere.remove(itemIndex));
		
	}
	
	

	public static int init(String filename,Profile[] c,MapBlock[][] map)
	{ //Initialize Characters
		try
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String splitBy = ",";
			int pCount = 1;
			
			String[] data;
			
			
			
			while((line = br.readLine()) != null)
			{
				data = line.split(splitBy);
				
				
				short xpos = Short.parseShort(data[0]);
				short ypos = Short.parseShort(data[1]);
			
				short pType = Short.parseShort(data[11]);
				
				if(map[xpos][ypos].getTitle().equalsIgnoreCase("VOID"))
				{
					System.out.println("ERROR: Character " + data[2] + " Map position " + xpos + "," + ypos + " does not exist.");
				}
				else
				{
					switch(pType)
					{
					case 0:
					
						c[pCount++] = new Immoveable(
								xpos,
								ypos,
								data[2],
								data[3],
								data[4],
								data[5],
								Short.parseShort(data[6]),
								Short.parseShort(data[7]),
								Short.parseShort(data[8]),
								Short.parseShort(data[9]),
								Short.parseShort(data[10]),
								Short.parseShort(data[12]));
							break;
					case 1:
						c[pCount++] = new Moveable(
								xpos,
								ypos,
								data[2],
								data[3],
								data[4],
								data[5],
								Short.parseShort(data[6]),
								Short.parseShort(data[7]),
								Short.parseShort(data[8]),
								Short.parseShort(data[9]),
								Short.parseShort(data[10]),
								Short.parseShort(data[12]));
							break;					
					case 2:
						c[0] = new Player(
								xpos,
								ypos,
								data[2],
								data[3],
								data[4],
								data[5],
								Short.parseShort(data[6]),
								Short.parseShort(data[7]),
								Short.parseShort(data[8]),
								Short.parseShort(data[9]),
								Short.parseShort(data[10]),
								Short.parseShort(data[12]));
							break;		
					default:
						System.out.println("Invalid player type :" + data[2]);
						break;
					}
				}
			}
			
			br.close();
			return pCount;
		}
		catch(IOException e)
		{
			System.out.println("File Error: " + filename);
			e.printStackTrace();
		}
		
		return -1;
	}

	public static void init(Profile[] c,MapBlock[][] map,String filename)
	{ //Initialize Items
		try
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String splitBy = ",";
			
			String[] data;
			
			while((line = br.readLine()) != null)
			{
				data = line.split(splitBy);
				
				
				short first = Short.parseShort(data[0]);
				
				String name = data[2];
				String desc = data[3];
				short offense = Short.parseShort(data[4]);
				short defense = Short.parseShort(data[5]);
				double value = Double.parseDouble(data[6]);
				
				Item i = new Item(name,desc,offense,defense,value);
				
				if(first == -1)   //determine if on map or with player
				{ // give to player
					short playerNum = Short.parseShort(data[1]);
					
					c[playerNum].inventory.add(i);
					
					c[playerNum].disarm();
					c[playerNum].arm(i);
					
				}
				else
				{ // put on map
					short xpos = Short.parseShort(data[0]);
					short ypos = Short.parseShort(data[1]);
					
					map[xpos][ypos].itemsHere.add(i);
				}
				
			}
			
			br.close();
			
		}
		catch(IOException e)
		{
			System.out.println("File Error: " + filename);
			e.printStackTrace();
		}

	}
	
	public static void init(String filename, MapBlock[][] m)
	{ //Initialize Map
		try
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String splitBy = ",";
			
			String[] data;
			
			while((line = br.readLine()) != null)
			{
				data = line.split(splitBy);
				
				int xpos = Integer.parseInt(data[0]);
				int ypos = Integer.parseInt(data[1]);
				
				//System.out.println(xpos + "," + ypos);	
				
				m[xpos][ypos] = new MapBlock(data[2],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7])); 
			}
			
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("File Error: " + filename);
			e.printStackTrace();
		}
	}

	public static boolean verify(MapBlock[][] m)
	{ 
		boolean result = true;
		
		for(int x = 0; x < MAX_X; x++)
		{
			for(int y = 0; y < MAX_Y; y++)
			{
				if(m[x][y].go(direction.NORTH))
				{
					if(y == 0)
					{
						System.out.println("map block [" + x + "][" + y + "] - NORTH from " + m[x][y].getTitle() + " does not exist");
						result = false;
					} 
					else if(m[x][y-1].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - NORTH from " + m[x][y].getTitle() + " does not exist");
						result = false;
					}
				}
				if(m[x][y].go(direction.SOUTH))
				{
					if(y == (MAX_Y - 1))
					{
						System.out.println("map block [" + x + "][" + y + "] - SOUTH from " + m[x][y].getTitle() + " does not exist");
						result = false;
					} 
					else if(m[x][y+1].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - SOUTH from " + m[x][y].getTitle() + " does not exist");
						result = false;
					}
				}
				if(m[x][y].go(direction.EAST))
				{
					if(x == (MAX_X - 1))
					{
						System.out.println("map block [" + x + "][" + y + "] - EAST from " + m[x][y].getTitle() + " does not exist");
						result = false;
					} 
					else if(m[x+1][y].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - EAST from " + m[x][y].getTitle() + " does not exist");
						result = false;
					}
				}
				if(m[x][y].go(direction.WEST))
				{
					if(x == 0)
					{
						System.out.println("map block [" + x + "][" + y + "] - WEST from " + m[x][y].getTitle() + " does not exist");
						result = false;
					} 
					else if(m[x-1][y].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - WEST from " + m[x][y].getTitle() + " does not exist");
						result = false;
					}
				}
			}

		}
		return result;
	}
	
}