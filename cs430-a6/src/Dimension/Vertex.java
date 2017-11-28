package Dimension;

public abstract class Vertex {

	protected float[] coordinate;
		
	protected void setCoordinateSize(int size) { this.coordinate = new float[size]; }
	
	public int getCoordinateSize() { return coordinate.length; }
	
	public float getValuePosition(int pos)
	{
		try
		{
			return coordinate[pos];
		}
		catch(NullPointerException ex)
		{
			displayNullError();
		}
		catch(Exception ex)
		{
			displayVertexError(pos);
		}
		return -1;
	}
	
	public void setValuePosition(int pos, float value)
	{
		try
		{
			coordinate[pos] = value;
		}
		catch(NullPointerException ex)
		{
			displayNullError();
		}
		catch(Exception ex)
		{
			displayVertexError(pos);
		}
		
	}
	
	private void displayVertexError(int pos)
	{
		System.out.println("Vertex Error: Cannot get position: " + pos + " from the size " + coordinate.length);
		System.exit(0);
	}
	
	private void displayNullError()
	{
		System.out.println("Vertex Error: Vertex is null. Cannot be accessed");
		System.exit(0);
	}
}
