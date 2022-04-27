package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//Arraylist of Nematodes
    ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public float border;
	public int currentNematode;

	public void keyPressed()
	{		
		// Cycle through the array
		if (keyCode == LEFT)
		{
			currentNematode =- 1;
		}		
		if (keyCode == RIGHT)
		{
			currentNematode =+ 1;
		}

		// Restart when reached limits
		if(keyCode < 0)
		{
			currentNematode = 0;	
		}
		if(keyCode > 12)
		{
			currentNematode = 0;
		}
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();		

		currentNematode = 0;
		border = width * 0.1f;

		loadNematodes();
		printNematodes();
	}
	

	public void loadNematodes()
	{
		// Load csv into the rows of the nematode class
		Table table = loadTable("nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
			Nematode n = new Nematode(r);
			nematodes.add(n);
        }
	}

	void printNematodes()
    {
        //For each loop of the array list to print
        for(Nematode n:nematodes)
        {
            System.out.println(n);
        }
    }

	public void drawNematodes()
	{
		// for(Nematode n:nematodes)
		// {
		// 	n.render(this);
		// }

		Nematode n = nematodes.get(3);
		n.render(this);
	}

	public void draw()
	{	
		drawNematodes();
	}
}
