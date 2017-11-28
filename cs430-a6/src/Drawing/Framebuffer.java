package Drawing;

public class Framebuffer {
	
	private String[][] grid;
	
	private int sizeX, sizeY;
		
	public int getSizeX(){ return sizeX; }
	public int getSizeY(){ return sizeY; }
	
	public Framebuffer()
	{
		setDimension(500, 500);
	}
	
	public void setDimension(int sizeX, int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		grid = new String[sizeX][sizeY];
	}
	
	public void setGridElement(int posX, int posY, String value)
	{
		try
		{
			grid[posX][posY] = value;
		}
		catch(Exception e)
		{
			System.out.println("Error in inserting value to grid element with posX:" + posX + " posY: "+ posY + " value:" + value);
		}
	}
	
	public String[][] getGrid()
	{
		return grid;
	}
}
