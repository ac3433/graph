package Matrix;
//to help solve matrix computation
//used existing matrix class from 
//https://introcs.cs.princeton.edu/java/95linear/Matrix.java.html
//added additional functions to it to help compute homogeneous matrix
import Dimension.Vertex;

public class Matrix {

	private int m; //row
	private int n; //column
	
	private double[][] data;
	
	public Matrix(int m, int n)
	{
		this.m = m;
		this.n = n;
		data = new double[m][n];
	}
	
	public Matrix(double[][] data)
	{
		m = data.length;
		n = data[0].length;
		this.data = data;
	}
	
	public Matrix(Vertex v)
	{
		this(v.getCoordinateSize(), v.getCoordinateSize());
		for(int i =  0; i < v.getCoordinateSize(); i++)
		{
			data[i][i] = v.getValuePosition(i);
		}
	}
	
	public Matrix(Matrix a)
	{
		this(a.data);
	}
	
	public int getM() { return m;}
	public int getN() { return n;}
	public double[][] getData() { return data; }
	
	public Matrix convertToHomogenous()
	{
		Matrix a = new Matrix(m +1, n + 1);
		
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				a.data[i][j] = data[i][j];
			}
		}		
		return a;
	}
		
	public Matrix multiple(Matrix a)
	{
		Matrix b = this;
		if(b.m != a.n)
			throw new RuntimeException("Illegal matrix dimensions.");
		
		Matrix c = new Matrix(b.m, a.n);
		for (int i = 0; i < c.m; i++)
            for (int j = 0; j < c.n; j++)
                for (int k = 0; k < b.n; k++)
                    c.data[i][j] += (b.data[i][k] * a.data[k][j]);
		
		return c;
	}
	
	public Matrix identity(int n)
	{
		Matrix A = new Matrix(n,n);
		for(int i = 0; i < n; i++)
			A.data[i][i] = 1;
		return A;
	}
}
