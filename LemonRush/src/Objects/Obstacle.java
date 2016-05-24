package Objects;
import java.awt.*;
import java.util.*;
public class Obstacle
{
    private Location myLoc;
    private Polygon myPoly;
    private Platform myPlatform;
    
    public Obstacle(Location loc, Platform p)
    {
        myLoc = loc;
        myPlatform = p;
        myPoly = new Polygon();
        myPoly.addPoint(100,100);
        myPoly.addPoint(102,100);
        myPoly.addPoint(100,102);
        myPoly.addPoint(102,102);
    }
    
    public Platform getPlatform()
    {
        return myPlatform;
    }
    
    public void setPlatform(Platform p)
    {
        myPlatform = p;
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public void setLocation(Location l)
    {
        myLoc = l;
    }
    
    public void move()
    {
        int o = myPlatform.getOrientation();
        if (o == 0)
        {
            myLoc.changeX(10);
            myLoc.changeY((int)(-10 / Math.sqrt(3)));
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY() + 2);
        }
        else if (o == 2)
        {
            myLoc.changeX(-10);
            myLoc.changeY((int)(-10 / Math.sqrt(3)));
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY() + 2);
        }
        else
        {
            myLoc.changeX(-10);
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY() + 2);
        }
    }
    
    public Polygon getPolygon()
    {
        return myPoly;
    }
}