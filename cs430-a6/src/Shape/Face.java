package Shape;

import java.util.LinkedList;
import java.util.List;

import Dimension.*;

public class Face {

	private List<Vertex> vertices;
	
	public Face()
	{
		vertices = new LinkedList<Vertex>();
	}
	
	public void addVertex(Vertex v)
	{
		//order of the face shouldn't differ too much since the connecting vertex is the same if it is read backward.
		vertices.add(0, v);
	}
	
	public int getSize() { return vertices.size(); }
	
	public Vertex getVertex(int position)
	{
		try
		{
			return vertices.get(position);
		}
		catch(Exception ex)
		{
			System.out.println("Face Error: Cannot get vertex at this position: " + position);
			System.exit(0);
		}
		
		return null;
	}
}
