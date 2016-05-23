package Objects;

import java.awt.*;
public class Ladder extends Element
{
    private Location myLoc;
    private int myHeight;
    private Polygon myPoly;
    
    public Ladder(Location l, int h)
    {
        super(l);
        myLoc = new Location(l.getX(), l.getY());
        myHeight = h;
        myPoly = new Polygon();
        myPoly.addPoint(myLoc.getX(), myLoc.getY());
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY());
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + myHeight);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + myHeight);
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public int getHeight()
    {
        return myHeight;
    }
    
    public void setLocation(Location loc)
    {
        myLoc = loc;
    }
    
    public void setHeight(int height)
    {
        myHeight = height;
    }
    
    public Polygon getPolygon()
    {
        return myPoly;
    }
}