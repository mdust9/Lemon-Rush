package Objects;
import java.util.*;
import java.awt.*;
public class PlayerOLD
{
    private int myLives;
    private Location myLoc;
    private Platform myPlatform;
    private Polygon myPoly;
    
    public PlayerOLD(Platform p)
    {
        myLives = 5;
        myLoc = new Location();
        myPlatform = p;
        myPoly = new Polygon();
        myPoly.addPoint(myLoc.getX(), myLoc.getY());
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY());
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + 2);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + 2);
    }
    
    public Location getLocation()
    {
        return myLoc;
    }
    
    public Platform getPlatform()
    {
        return myPlatform;
    }
    
    public void setLocation(Location l)
    {
        myLoc = l;
        myPoly = new Polygon();
        myPoly.addPoint(myLoc.getX(), myLoc.getY());
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY());
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + 2);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + 2);
    }
    
    public void setPlatform(Platform p)
    {
        myPlatform = p;
    }
    
    public void jump()
    {
        myLoc.changeY(10);
        myPoly = new Polygon();
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + 10);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + 10);
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + 12);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + 12);
    }
    
    public void fall()
    {
        myLoc.changeY(-5);
        myPoly = new Polygon();
        myPoly.addPoint(myLoc.getX(), myLoc.getY() - 5);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() - 5);
        myPoly.addPoint(myLoc.getX(), myLoc.getY() - 3);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() - 3);
    }
    
    public void moveLeft()
    {
        if (myPlatform.getOrientation() == 1)
        {
            myLoc.changeX(-10);
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY() + 2);
        }
        else if (myPlatform.getOrientation() == 0)
        {
            myLoc.changeX(-10);
            myLoc.changeY((int)(10 / Math.sqrt(3)));
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY() + 2);
        }
        else
        {
            myLoc.changeX(-10);
            myLoc.changeY((int)(-10 / Math.sqrt(3)));
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY());
            myPoly.addPoint(myLoc.getX() - 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() - 8, myLoc.getY() + 2);
        }
    }
    
    public void moveRight()
    {
        if (myPlatform.getOrientation() == 1)
        {
            myLoc.changeX(10);
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY() + 2);
        }
        else if (myPlatform.getOrientation() == 0)
        {
            myLoc.changeX(10);
            myLoc.changeY((int)(-10 / Math.sqrt(3)));
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY() + 2);
        }
        else
        {
            myLoc.changeX(10);
            myLoc.changeY((int)(10 / Math.sqrt(3)));
            myPoly = new Polygon();
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY());
            myPoly.addPoint(myLoc.getX() + 10, myLoc.getY() + 2);
            myPoly.addPoint(myLoc.getX() + 12, myLoc.getY() + 2);
        }
    }
    
    public void climb()
    {
        myLoc.changeY(5);
        myPoly = new Polygon();
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + 5);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + 5);
        myPoly.addPoint(myLoc.getX(), myLoc.getY() + 7);
        myPoly.addPoint(myLoc.getX() + 2, myLoc.getY() + 7);
    }
    
    public void loseLife()
    {
        myLives -= 1;
    }
    
    public int getLives()
    {
        return myLives;
    }
    
    public Polygon getPolygon()
    {
        return myPoly;
    }
}