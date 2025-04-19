import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CreateChar {

	public static void main(String[] args)
	{
		short xpos;
		short ypos;
		String name;
		String description;
		String race;
		String cClass;
		short pType = -1;

		boolean mainCharQuestion = false;


		boolean another = true;
		Scanner s = new Scanner(System.in);
		String filename = "../data/characters.csv";

		while(another)
		{

			System.out.print("\n\n*******************\nEnter Character Name:>");
			name = s.nextLine();

			if(mainCharQuestion == false)
			{
				System.out.print("Is this the main player? (y/n):>");
				String answer = s.nextLine();
				if(answer.toLowerCase().charAt(0) == 'y')
				{
					pType = 2;
					mainCharQuestion = true;
				}
			}

			System.out.print("Enter Character Description:>");
			description = s.nextLine();

			System.out.print("Enter Character Race:>");
			race = s.nextLine();

			System.out.print("Enter Character Class:>");
			cClass = s.nextLine();

			System.out.print("Enter Starting X Position:>");
			xpos = Short.parseShort(s.nextLine());

			System.out.print("Enter Starting Y Position:>");
			ypos = Short.parseShort(s.nextLine());
			
			if(pType != 2)
			{
				System.out.print("Is Character Moveable? (1 = yes, 0 = no):>");
				pType = Short.parseShort(s.nextLine());
			}


			writeToCSVFile(filename, name, description, race, cClass, xpos, ypos, pType);
			pType = -1;

			System.out.print("*******************\nAnother Character? (Y/N)");
			char choice = s.nextLine().charAt(0);

			if((choice == 'N') || (choice == 'n'))
			{
				another = false;
			}
		}
		System.out.println("GoodBye");
		s.close();
	}


	public static int roll(int die)
	{
		return getRand(1,die);
	}

	public static int getRand(int min, int max)
	{
		if (min >= max)
		{
			System.out.println("Range Error: min greater than max");
			return -1;
		}

		int r = (int)(Math.random() * ((max - min) + 1)) + min;    //.32445768764468876545
		return r;
	}	

	private static void writeToCSVFile(String filename, String name, String description, String race, String cClass, short xpos, short ypos, short pType)
	{
		String outLine = "";
		try
		{
			FileWriter fw = new FileWriter(filename, true);

			outLine = String.format("%d,%d,%s,%s,%s,%s,%d,%d,%d,%d,%d, %d\n",xpos,ypos,name,description,race,cClass,roll(100),roll(20),roll(20),roll(20),roll(20),pType);
			fw.write(outLine);

			fw.close();

		}
		catch(IOException e)
		{
			System.out.println("File Error: " + filename);
		}
	}


}
