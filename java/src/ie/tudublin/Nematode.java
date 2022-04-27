package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
public class Nematode 
{
    // All elements of the cvs file
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;
    
    // Table rows
    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs") == 1,
            tr.getString("gender"),
            tr.getInt("eyes") == 1
        );
           
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean getLimbs() {
        return limbs;
    }
    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean getEyes() {
        return eyes;
    }
    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    // toString method (overrided)
    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    
    // Class constructor
    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes)
    {
        this.name = name;
        this.length = length;   
        this.limbs = limbs;   
        this.gender = gender;   
        this.eyes = eyes;   
    }

    // Render
    public void render (NematodeVisualiser pa)
    {
        // map
        // Let eyes be 2 lines and a circle on each end of it
        // Let length be number of segments
        // m : line and circle on last segment
        // f : circle on last segment
        // h : both 
        // n : just segments

        for(int i = 0; i < length; i++)
        {
            // Map y coordinate
            // float y = PApplet.map(i, 1, length, pa.border, (pa.height - pa.border));

            // Map colour (HSB)
            // float colour = PApplet.map(i, 1, length, 0, 360);

            // Circle colour
            pa.stroke(255, 255, 255);
            //pa.stroke((int) colour);
            pa.noFill();

            // x, y, radius (currently goes upwards by 50 pixels)
            pa.circle(pa.width/2, i * 50, 50);

            // If there are limbs
            if(limbs)
            {
                pa.stroke(255,255,255);
                pa.line(x, i*50, x, i*50);
            }


        }

    }
}
