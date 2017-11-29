package Camera;

import Matrix.Matrix;

public class ParallelView extends AbstractCameraType{

	public ParallelView() {
		double[][] orth = new double[][]
			{{1,0,0,0},
			 {0,1,0,0},
			 {0,0,0,0},
			 {0,0,0,1}};
			 
		Matrix A = new Matrix(orth);
		
		setMatrix(A);
	}

}
