import java.util.ArrayList;

public class Profile {
	
	public short xpos;
	public short ypos;
	private String name;
	private String description;
	private String race;
	private String cClass;
	private short strength;
	private short intelligence;
	private short dexterity;
	private short armor;
	protected short hitPoints;
	private short combative; // 1 is yes and 2 is no (for now)
	
	private Item armOWith;
	private Item armDWith;
	
	
	ArrayList<Item> inventory = new ArrayList<>();
	
	public Profile()
	{
		
	}
	
	public Profile(short x, short y,String n, String d, String r, String c, short h, short s, short dx, short i, short a, short comb)
	{
		xpos = x;
		ypos = y;
		name = n;
		description = d;
		race = r;
		cClass = c;
		hitPoints = h;
		strength = s;
		dexterity = dx;
		intelligence = i;
		armor = a;
		combative = comb;
		
		armOWith = new Item();
		armDWith = new Item();
	}
	
	public boolean takeHit(int damage)
	{
		boolean alive = true;
		
		hitPoints -= damage;
		if(hitPoints <= 0)
		{
			alive = false;
		}
		
		return alive;
	}
	
	public boolean isHere(Profile p)
	{
		if((xpos == p.xpos) && (ypos == p.ypos))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hit(Profile p)
	{
		int roll = Die.roll(20);
		
		if(roll > p.getArmor())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void kill()
	{
		combative = 0;
		name = "The Body of " + name;
		
	}
	
	public boolean isCombative()
	{
		if(combative == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public void armO(Item i)
	{
		strength += i.offense;
		armOWith = i;
	}
	public void armD(Item i)
	{
		armor += i.defense;
		armDWith = i;
	}
	
	public void disarmO()
	{
		strength -= armOWith.offense;
		
		armOWith = null;
	}
	public void disarmD()
	{
		armor -= armDWith.defense;
		
		armDWith = null;
	}
	public void use(Item i)
	{
		if(i.offense > 0)
		{
			if(armOWith != null)
			{
				strength -= armOWith.offense;
			}
			strength += i.offense;
			armOWith = i;
		}
		if(i.defense > 0)
		{
			if(armDWith != null)
			{
				armor -= armDWith.defense;
			}
			armor += i.defense;
			armDWith = i;
		}
	}
	public void setName(String n)
	{
		name = n;
	}
	
	public void setDesc(String d)
	{
		description = d;
	}
	
	public void setRace(String r)
	{
		race = r;
	}
	
	public void setcClass(String c)
	{
		cClass = c;
	}
	
	public void setHitPoints(short h)
	{
		hitPoints = h;
	}
	
	public void setStrength(short s)
	{
		strength = s;
	}
	
	public void setDexterity(short dx) 
	{
		dexterity = dx;
	}
	
	public void setIntelligence(short i)
	{
		intelligence = i;
	}
	
	public void setArmor(short a)
	{
		armor = a;
	}
	public String getName()
	{
		return name;
	}
	public String getDesc()
	{
		return description;
	}
	public String getRace()
	{
		return race;
	}
	public String getcClass()
	{
		return cClass;
	}
	
	public short getHitPoints()
	{
		return hitPoints;
	}
	public short getStrength()
	{
		return strength;
	}
	public short getDexterity()
	{
		return dexterity;
	}
	public short getIntelligence()
	{
		return intelligence;
	}
	public short getArmor()
	{
		return armor;
	}
}
