import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Adventure 
{
	public static final int MAX_X = 10;
	public static final int MAX_Y = 10;
	public static short winXPos = 0;
	public static short winYPos = 0;
	public static String winConName = "";
	public static String winConAnnounce = "";

	public static Scanner s = new Scanner(System.in);
	
	
	public static void main(String[] args)
	{
		
		int maxProfiles = 20;
		int numChars = 0;
		String charFile = "../data/characters.csv"; //charFile is the characters file
		String itemFile = "../data/items.csv";
		String winFile = "../data/win.csv";
		Profile[] characters = new Profile[maxProfiles]; //Making an array of characters and profiles, assume worst case scenario for how many you're taking
		

		
		String mapFile = "../data/map.csv";

		boolean playing = true; //Assumes you're playing
		
		MapBlock[][] m = new MapBlock[MAX_X][MAX_Y]; //The mapblock within the restrictions
		
		for(int i = 0; i < MAX_X; i++) //If the mapblock is currently not at the max_x/y from 0,0 it'll increment more until it reaches
		{
			for(int j = 0; j < MAX_Y; j++)
			{
				m[i][j] = new MapBlock();
			}
		}
		init(mapFile, m); //Initializes and verifies the map
		if(verify(m))
		{
			//In order to reference certain actions, you get them through these.
			numChars = init(charFile, characters, m); //load characters, and shows how many characters there are currently
			init(characters,m,itemFile); //load items
			init(m,characters,winFile,numChars); //load the win conditions (finals)
			
			while(playing)
			{
				playing = checkWin(m,characters,winFile,numChars);
				if(playing)
				{
					moveChars(m,characters,numChars); //If there are movable characters, they'll move
					showMap(m,characters); //Tells you what part of the map you are
					showItems(m[characters[0].xpos][characters[0].ypos]); //Shows what items are at your location
					showChars(characters,numChars); //Shows what characters are at your location
					playing = npcCombat(characters,numChars); //Combat
					if(playing) 
					{
						playing  = actionHandler(m,characters,numChars); //Determines what to do after your action
				}
				
			}
		
		}
		System.out.println("Goodbye");
		
			s.close();
		}
		
	}
	private static void init(MapBlock[][] m, Profile[] characters, String winFile, int numChars)
	{
		try 
		{
			FileReader fr = new FileReader(winFile);
			BufferedReader br = new BufferedReader(fr);
		
			String line;
			String splitBy = ",";
		
			String[] data;
			while((line = br.readLine()) != null) //While the reading happens and it's not null, keep reading
			{
				data = line.split(splitBy);
			
				winXPos = Short.parseShort(data[0]);
				winYPos = Short.parseShort(data[1]);
				winConName = data[2];
				winConAnnounce = data[3];
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("File Error: " + winFile);
			e.printStackTrace();
		}
		
	}

	private static boolean checkWin(MapBlock[][] m, Profile[] characters, String winFile, int numChars) 
	{
		boolean playing = true;
		if((m[characters[0].xpos] == m[winXPos]) && (m[characters[0].ypos] == m[winYPos]))
		{
			if(characters[0].inventory.getLast().name.equalsIgnoreCase(winConName))
			{
				playing = false;
				System.out.println("" + winConAnnounce + "\n");
			}
		}
		
		
		return playing;
	}


	private static boolean npcCombat(Profile[] c, int numChar)
	{
		boolean alive = true;
		
		for(int i = 1; i < numChar; i++)
		{
			if(c[0].isHere(c[i]))//c[0] references the main character, where if the x and y pos is the same as something else, where its found in profile
			{
				if(c[i].isCombative())
				{
						System.out.println("Rolliing for Initiative... ");
						if(!rollForInitiative())
						{
							System.out.println(c[i].getName() + " is attacking...");
							if(c[i].hit(c[0])) 
								{
									int damage = c[i].getStrength() + Die.roll(10);
									System.out.println(c[i].getName() + " hits you with " + damage + " damage.");
									alive = c[0].takeHit(damage);
									System.out.println("Your Hitpoints remaining: " + c[0].getHitPoints());
									if(!alive)
									{
										System.out.println("You died...");
									}
								}
							else
							{
								System.out.println("" + c[i].getName() + " missed their attack!");
							}
						}
						
					}
				}
			}
		return alive;
	}

	private static void Combat(Profile[] c, int numChar)
	{
		for(int i = 1; i < numChar; i++)
		{
			if(c[0].isHere(c[i]))//c[0] references the main character, where if the x and y pos is the same as something else, where its found in profile
			{
				if(c[i].isCombative()) //Check if combative
				{
							boolean alive = true;
							System.out.println("You attack " + c[i].getName() + "\n");
							if(c[0].hit(c[i])) 
								{
									int damage = c[0].getStrength() + Die.roll(10);
									System.out.println("You hit " + c[i].getName() + " with " + damage + " damage.");
									alive = c[i].takeHit(damage);
									System.out.println(c[i].getName() + " has " + c[i].getHitPoints() + " Hitpoints remaining\n");
									if(!alive)
									{
										System.out.println(c[i].getName() + " is dead.\n");
										c[i].kill();
										
									}
								}
							else
							{
								System.out.println("You missed your attack!\n");
							}
						}
						
					}
				}
	}
	
	public static boolean rollForInitiative()
	{
		int myRoll = Die.roll(10); //Both have rolls with a max of 10
		int npcRoll = Die.roll(10);
		
		System.out.println("Rolling..." + myRoll + " vs " + npcRoll);
		
		if(myRoll >= npcRoll) //If your roll is greater than their roll, get true
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
		for(int i = 0; i < mb.itemsHere.size(); i++) //Basically the value starts at the first item and keeps going up by one until it reaches the item number that is there
		{
			System.out.println("There is a " + mb.itemsHere.get(i).name + " here.");
		}
		
	}
	private static void moveChars(MapBlock[][] m, Profile[] characters, int numChars)
	{
		for(int i = 1; i < numChars; i++) //Start at one because you don't want the mc to randomly move
		{
			if(characters[i] instanceof Moveable) //Says that if this character is within moveable
			{
				Moveable n = (Moveable)characters[i];
				n.move(m);
			}
		}
		
	}
	private static void showChars(Profile[] c, int numChars) 
	{
		for(int idx = 1; idx < numChars; idx++) //Go through every single available character
		{
			if((c[0].xpos == c[idx].xpos) && (c[0].ypos == c[idx].ypos)) //If the position of the mc is the same as the indicated character
			{
				//same place
				System.out.println(c[idx].getName() + " is here");
			}
		}
		
	}
	private static void init(String filename, MapBlock[][] m) //Loads the map already made
	{//Initialize Map
		try
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line; //Read Line
			String splitBy = ","; //Split by commas
			
			String[] data; //Put into an array
			
			while((line = br.readLine()) !=null)
			{
				data = line.split(splitBy);
				
				int xpos = Integer.parseInt(data[0]); //Xpos and ypos is given from the first two sets of data in the map file
				int ypos = Integer.parseInt(data[1]);
				m[xpos][ypos] = new MapBlock(data[2],
						data[3],
						Integer.parseInt(data[4]),
						Integer.parseInt(data[5]),
						Integer.parseInt(data[6]),
						Integer.parseInt(data[7]));
				//The map basically expects there to be 8 fields
			
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
		
		for(int x= 0; x < MAX_X; x++) //If x and y is below the max positions
		{
			for(int y = 0; y < MAX_Y; y++)
			{
				if(m[x][y].go(direction.NORTH))
				{
					if(y == 0)
					{
						System.out.println("map block [" + x + "][" + y + "] - NORTH from " + m[x][y].getTitle() + "does not exist");
						result = false;
					}
					//x,y - look at y-1. if title is Void, bad map block
					else if(m[x][y-1].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - NORTH from " + m[x][y].getTitle() + "does not exist");
						result = false;
						
					}
				}
				if(m[x][y].go(direction.SOUTH))
				{
					if(y == (MAX_Y - 1))
					{
						System.out.println("map block [" + x + "][" + y + "] - SOUITH from " + m[x][y].getTitle() + "does not exist");
						result = false;
					}
					else if(m[x][y+1].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - SOUTH from " + m[x][y].getTitle() + "does not exist");
						result = false;
						
					}
				}
				if(m[x][y].go(direction.EAST))
				{
					if(x == (MAX_X - 1))
					{
						System.out.println("map block [" + x + "][" + y + "] - EAST from " + m[x][y].getTitle() + "does not exist");
						result = false;
					}
					if(m[x+1][y].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println(m[x+1][y].getTitle());
						System.out.println("map block [" + x + "][" + y + "] - EAST from " + m[x][y].getTitle() + "does not exist");
						result = false;
						
					}
				}
				if(m[x][y].go(direction.WEST))
				{
					if(x == 0)
					{
						System.out.println("map block [" + x + "][" + y + "] - WEST from " + m[x][y].getTitle() + "does not exist");
						result = false;
					}
					if(m[x-1][y].getTitle().equalsIgnoreCase("VOID"))
					{
						System.out.println("map block [" + x + "][" + y + "] - WEST from " + m[x][y].getTitle() + "does not exist");
						result = false;
						
					}
				}
			}
		}
		return result;
	}
	
	public static void showMap(MapBlock[][] m, Profile[] characters)
	{
		//Get the title of the map position and the description of it
		System.out.printf("%s\n%s\n",m[characters[0].xpos][characters[0].ypos].getTitle(),m[characters[0].xpos][characters[0].ypos].getDescription());
		
	}


	public static boolean actionHandler(MapBlock[][] m, Profile[] characters, int numChars)
	{
		boolean playing = true;
		
		String words = ""; //Making it so that this exists past the if splitAt
		String command = "";
		
		while(command.length() == 0)
		{
			System.out.println("\nNext Move: ");
			command  = s.nextLine();//What the user says
		}
		
		command = command.toLowerCase(); //Treats everything as lowercase in commands, which changes N to n
		//Remember that if you get any other case of letters you're going to need to convert
		int splitAt = command.indexOf(' ');
		if(splitAt > 0)
		{
			words = command.substring(splitAt + 1);
		}
		char cmd = command.charAt(0); //Check command and the first position letter, then assign to cmd, to check for first letters in a word instead
		
		
		//i,n,s,e,w,g,d,a,t,u,x 
		switch(cmd) //What to do after getting command
		{
		case 'i':
			Player p = (Player)characters[0];
			p.listInventory();
			break;
		case 'n': //Apostrophes to make sure that we can read a char instead of a string
			if(m[characters[0].xpos][characters[0].ypos].go(direction.NORTH)) //Asking if you can go north
			{	
				characters[0].ypos--; //0,0 is at top of the array
			} 
			else {
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
				System.out.println("Can't go that way..");
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
			for(int i = 0; i < m[characters[0].xpos][characters[0].ypos].itemsHere.size(); i++) //Go one by one through the item list to determine which one it is
			{
				if(words.equalsIgnoreCase(m[characters[0].xpos][characters[0].ypos].itemsHere.get(i).name))
				{
					itemIndex = i;
				}
			}
			//Sentinel value detects if there is an item at that location
			if(itemIndex == -1)
				{
				 System.out.println("This item is not near you!");
				 break;
				}
			getItem(characters[0],m[characters[0].xpos][characters[0].ypos],itemIndex);
			System.out.println("You now have the " + characters[0].inventory.getLast().name); //Showing what the items name that you grabbed was
			break;
		case 'd': //drop item
			itemIndex = -1;
			for(int i = 0; i < characters[0].inventory.size(); i++) 
				//Go one by one through the character's inventory
			{
				if(words.equalsIgnoreCase(characters[0].inventory.get(i).name))
				{
					itemIndex = i;
				}
			}
			
			if (itemIndex >= 0) {
			    dropItem(characters[0],m[characters[0].xpos][characters[0].ypos],itemIndex);
			    System.out.println("You dropped the " + m[characters[0].xpos][characters[0].ypos].itemsHere.getLast().name);
			} else {
			    System.out.println("You don't have that item.");
			}
			break;
		case 'a':
			Combat(characters,numChars);
			break;
		case 't': //Stealing from npc's inventory
			int roll = Die.roll(10);
			for(int i = 1; i < numChars; i++)
			{
				if(characters[0].isHere(characters[i]))
				{
					int totRoll;
					totRoll = roll + characters[0].getDexterity();
					if(totRoll > characters[i].getIntelligence())
					{
						if(characters[i].inventory.isEmpty())
						{
							//Add something that says that if the characters have nothing else, to say they have nothing left to steal
							System.out.println("" + characters[i].getName() + " has nothing left to steal!\n");
						}
						else
						{
						m[characters[i].xpos][characters[i].ypos].itemsHere.add(characters[i].inventory.getLast());
						characters[i].inventory.removeLast();
						characters[0].inventory.add(m[characters[0].xpos][characters[0].ypos].itemsHere.getLast());
						m[characters[0].xpos][characters[0].ypos].itemsHere.removeLast();
						System.out.println("You've stolen " + characters[0].inventory.getLast().name + " from " + characters[i].getName() + "!\n");
						}
					}
					else
					{
						System.out.println("You failed to steal from " + characters[i].getName() + "!\n");
					}
				}
			}
		
			break;
		case 'u':
			//Use Command
			itemIndex = -1;
			for(int i = 0; i < characters[0].inventory.size(); i++)
			{
				if(words.equalsIgnoreCase(characters[0].inventory.get(i).name))
				{
					itemIndex = i;
				}
			}
			if(itemIndex == -1)
			{
			 System.out.println("This item is not in your inventory!");
			 break;
			}
			characters[0].use(characters[0].inventory.get(itemIndex));
			break;
		case 'h': 
		{
			System.out.println("***List of all options***");
			System.out.println("'i' lists items in your inventory.\n"
					+ "'n' goes north.\n"
					+ "'s' goes south.\n"
					+ "'e' goes east.\n"
					+ "'w' goes west.\n"
					+ "'g' enter the name of the item you'd like to pick up near you.\n"
					+ "'d' enter the name of the item you'd like to drop from your inventory.\n"
					+ "'a' attack npc near you.\n"
					+ "'t' steal the last item from an npc.\n"
					+ "'u' name an item in your inventory to equip.\n"
					+ "'x' stop playing.\n");
		}
			break;
		case 'x':
			playing = false; //Stop playing
			break;
		default:
			System.out.println("Not a valid command!\n");
			break;
		}

		
		return playing;
	}
	
	private static void dropItem(Profile c, MapBlock mb, int itemIndex)
	{
		mb.itemsHere.add(c.inventory.get(itemIndex)); //On this mapblock, add the item where the index you got from earlier from the player's inventory
		c.inventory.remove(itemIndex); //Remove the item from the inventory
	}
	
	private static void getItem(Profile c, MapBlock mb, int itemIndex) //How to get an item for any character
	{
		c.inventory.add(mb.itemsHere.get(itemIndex)); //For this item index add to the inventory
		mb.itemsHere.remove(itemIndex); //Remove this item from the mapblock
	}
	
	public static int init(String filename, Profile[] c,MapBlock[][] map)
	{//Initialize Characters
		
		try //Reading the characters.csv
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String splitBy = ",";
			int pCount = 1;
			
			String[] data;
			
			while((line = br.readLine()) !=null) //While the reading happens and it's not null, keep reading
			{
				data = line.split(splitBy);
				
				short xpos = Short.parseShort(data[0]); 
				short ypos = Short.parseShort(data[1]);
				
				short pType = Short.parseShort(data[11]); 
				
				if(map[xpos][ypos].getTitle().equalsIgnoreCase("VOID")) //If the character's position is void, add an error
				{
					System.out.println("Error: Character " + data[2] + " Map Position " + xpos + "," + ypos + " does not exist");
				
				}
				else //If not void
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
							Short.parseShort(data[12])); //Using and incrementing
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
						System.out.println("Invalid Player Type " + data[2]); //Data 2 is the name of the character
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
	
	public static void init(Profile[] c,MapBlock[][] map, String filename)
	{//Initialize Items
		
		try //Reading the items.csv
		{
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			String splitBy = ",";
			
			String[] data;
			
			while((line = br.readLine()) !=null)
			{
				data = line.split(splitBy); //Each line means a new thing
				
				short first = Short.parseShort(data[0]); //Since this exists already, you can substitute it later on.
				
				String name = data[2];
				String desc = data[3];
				short offense = Short.parseShort(data[4]);
				short defense = Short.parseShort(data[5]);
				double value = Double.parseDouble(data[6]);
				
				Item i = new Item(name,desc,offense,defense,value);
				
				
				if(first == -1) //determine if it's on the map or on a player
				{//Given to player
					short playerNum = Short.parseShort(data[1]);
				
					c[playerNum].inventory.add(i);
					
					c[playerNum].use(i);
				}
				else
				{//On the map
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
	
}
