import java.util.LinkedList;
import java.util.List;

public class FloodFunction {
    private Driver driver;
    //here floodList is declared as a LinkedList
    //it is declared as public (a bad practice), but it is needed by the Driver class
    public List<Coord> floodList = new LinkedList<Coord>();
    
    //constructor  
    public FloodFunction(Driver newDriver) {
        driver = newDriver;
        //when the game starts, only the cell at the left/top corner is filled
        floodList.add(new Coord(0, 0));
        //driver.flood(colorIndex);
    }
    
    //Peyton Reese and Jarod England
    //flood function adds Coords to floodList that need to be included
    public void flood(int colorToFlood) {
    	for (int i =0; i<floodList.size();i++){
    		Coord north = up(floodList.get(i));
    		Coord south = down(floodList.get(i));
    		Coord east = right(floodList.get(i));
    		Coord west = left(floodList.get(i));
			if (inbound(north) &&colorOfCoord(north) == colorToFlood && !(floodList.contains(north))){
    					floodList.add(north);
    			}
			if (inbound(east)&& colorOfCoord(east) == colorToFlood && !(floodList.contains(east))){
    				floodList.add(east);
    			}
    		if (inbound(west) &&colorOfCoord(west) == colorToFlood && !(floodList.contains(west))){
    				floodList.add(west);
    			}
    		if (inbound(south) &&colorOfCoord(south) == colorToFlood && !(floodList.contains(south))){
    				
    				floodList.add(south);
    			}}
    }

    //is input cell (specified by coord) on the board?
    public boolean inbound(final Coord coord) {
        final int x = coord.x;
        final int y = coord.y;
        final int size = this.driver.size;
        return x > -1 && x < size && y > -1 && y < size;
    }
    //return the coordinate of the cell on the top of the given cell (coord) 
    public Coord up(final Coord coord) {
        return new Coord(coord.x, coord.y-1);
    }
    //return the coordinate of the cell below the given cell (coord)
    public Coord down(final Coord coord) {
        return new Coord(coord.x, coord.y+1);
    }
    //return the coordinate of the cell to the left of the given cell (coord)
    public Coord left(final Coord coord) {
        return new Coord(coord.x-1, coord.y);
    }
    //return the coordinate of the cell to the right of the given cell (coord)
    public Coord right(final Coord coord) {
        return new Coord(coord.x + 1, coord.y);
    }
    //get the color of a cell (coord)
    public int colorOfCoord(final Coord coord) {
        return this.driver.getColor(coord);
    }
}