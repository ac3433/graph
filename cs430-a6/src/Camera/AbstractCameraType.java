package Camera;

import Matrix.Matrix;

public abstract class AbstractCameraType {

	protected Matrix A;
	
	protected void setMatrix(Matrix A)
	{
		this.A = A;
	}
	
	public Matrix getMatrix()
	{
		return A;
	}
}
