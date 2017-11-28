package Camera;

import Matrix.Matrix;

public class PerspectiveView extends AbstractCameraType {
	
	public PerspectiveView(float x, float y, float z, float d)
	{
		float[][] perps = new float[][]
		{
			{x/(z/d)},
			{y/(z/d)},
			{d}
		};
		
		setMatrix(new Matrix(perps));
	}
}
