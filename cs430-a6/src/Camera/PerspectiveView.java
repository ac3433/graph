package Camera;

import Matrix.Matrix;

public class PerspectiveView extends AbstractCameraType {
	
	public PerspectiveView(double x, double y, double z, double d)
	{
		double[][] perps = new double[][]
		{
			{x/(z/d)},
			{y/(z/d)},
			{d}
		};
		
		setMatrix(new Matrix(perps));
	}
}
