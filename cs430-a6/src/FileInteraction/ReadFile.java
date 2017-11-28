package FileInteraction;

import java.io.File;
import java.util.List;

import Shape.Face;

public abstract class ReadFile {

	public abstract List<Face> readFile(String path);
	
	protected boolean checkFileValid(String filepath)
	{
		return new File(filepath).isFile();
	}
	
	
}
