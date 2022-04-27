package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//Arraylist of Nematodes
    ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
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

	public void draw()
	{	
	}
}
