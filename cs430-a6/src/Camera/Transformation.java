package Camera;

import Dimension.ThirdDimension;
import Matrix.Matrix;

public class Transformation {

	public Matrix TranslateOrigin(double x, double y, double z)
	{
		double[][] origin= {	{1,0,0,x},
							{0,1,0,y},
							{0,0,1,z},
							{0,0,0,1}};
		
		Matrix A = new Matrix(origin);
		
		return A;
	}
	
	//this to to return the matrix of rotated around x
	//use this to multiple against vpn and vup
	//input are vpn coordinates
	public Matrix RotationXAxis(double x, double y, double z)
	{
		//if it's 0, it should return identity. Whole point is to make component equal to zero
		if(y == 0)
			return new Matrix(4,4).identity(4);
				
		//(1,1) in the matrix
		double Rx1 = z/(Math.sqrt((y*y) + (z*z)));
		// (1,2) in the matrix
		double Rx2 = (-y) / ( Math.sqrt((y*y) + (z*z)));
				
		double[][] rotX = 	{	{1, 0, 0, 0},
								{0, Rx1, Rx2, 0},
								{0, -Rx2, Rx1, 0},
								{0,0,0,1}};
		
		return new Matrix(rotX);
	}
	//this to to return the matrix of rotated around y
	//use this to multiple against vpn and vup
	//input are vpn coordinates
	public Matrix RotationYAxis(double x, double y, double z)
	{
		//if it's x = 0, it should matter to rotate since y is already 0 
		if(x == 0)
			return new Matrix(4,4).identity(4);

		double Rx1 = z/(Math.sqrt((x*x) + (z*z)));
		double Rx2 = (-x) / ( Math.sqrt((x*x) + (z*z)));
				
		double[][] rotY = 	{	{Rx1, 0, Rx2, 0},
								{0, 1, 0, 0},
								{-Rx2, 0, Rx1, 0},
								{0,0,0,1}};
		
		return new Matrix(rotY);
	}
	
	//this to to return the matrix of rotated around z
	//use this to multiple against vup
	//input are vup coordinates
	public Matrix RotationZAxis(double x, double y, double z)
	{
		double Rx1 = y/(Math.sqrt((x*x) + (y*y)));
		double Rx2 = (-x) / ( Math.sqrt((x*x) + (y*y)));
				
		double[][] rotZ = 	{	{Rx1, Rx2, 0, 0},
								{-Rx2, Rx1, 0, 0},
								{0, 0, 1, 0},
								{0,0,0,1}};
		
		return new Matrix(rotZ);
	}
	
	public Matrix TranslatePRPOrigin(double x, double y, double z)
	{
		double[][] m = {	{1, 0, 0, -x},
							{0, 1, 0, -y},
							{0, 0, 1, -z},
							{0, 0, 0, 1}};
		
		return new Matrix(m);
	}
	
	//Input are the PRP and VRC window
	//this is use to get the VRP and VRPz
	//VRP = this multiply T(-PRP) multiple 
	public Matrix Shear(double u, double v, double n, double uMax, double uMin, double vMax, double vMin)
	{
		double cwU = (uMin + uMax)/2;
		double cwV = (vMin + vMax)/2;
		
		double DOPx = cwU - u;
		double DOPy = cwV - v;
		double PRPn = n;
		
		double SHx = DOPx/PRPn;
		double SHy = DOPy/PRPn;
		
		double[][] s = {	{1, 0, SHx, 0},
							{0, 1, SHy, 0},
							{0, 0, 1, 0},
							{0, 0, 0, 1}};
		
		return new Matrix(s);
	}
	
	public Matrix Scale(double vrpz, double uMax, double uMin, double vMax, double vMin, double nMax, double nMin)
	{
		double Sx = (2 * Math.abs(vrpz)) / ((uMax - uMin) * (vrpz + nMax));
		double Sy = (2 * Math.abs(vrpz)) / ((vMax - vMin) * (vrpz + nMax));
		double Sz = 1 / (vrpz + nMax);
		
		double[][] scale = {	{Sx, 0, 0, 0},
								{0, Sy, 0, 0},
								{0, 0, Sz, 0},
								{0, 0, 0, 1}};
		
		return new Matrix(scale);
	}
	
}
