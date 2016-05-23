package Objects;
import java.util.*;
import java.awt.*;
public class Platform extends Element
{
    private Location myLoc;
    private int orientation;
    private Polygon myPoly;
    
    public Platform(Location loc, int o, int length)
    {
        super(loc);
        myLoc = new Location(loc.getX(), loc.getY());
        orientation = o;
        final int height = 4;
        myPoly = new Polygon();
        myPoly.addPoint(loc.getX(), loc.getY());
        myPoly.addPoint(loc.getX() + length / 2, loc.getY());
        myPoly.addPoint(loc.getX(), loc.getY() + (int)(height * 0.15425));
        myPoly.addPoint(loc.getX() + length / 2, loc.getY() + (int)(height * 0.15425));
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public int getOrientation()
    {
        return orientation;
    }
    
    public Polygon getPolygon()
    {
        return myPoly;
    }
}