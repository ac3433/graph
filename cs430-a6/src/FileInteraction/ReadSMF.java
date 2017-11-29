package FileInteraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import Dimension.*;
import Shape.Face;

public class ReadSMF extends ReadFile {

	@Override
	public List<Face> readFile(String path) {
		int linePosition = 1;
		try
		{
			System.out.println("Starting to read file: " + path);
			
			if(checkFileValid(path))
			{
				List<Face> faces = new ArrayList<Face>();
				List<Vertex> vertex = new ArrayList<Vertex>();
				BufferedReader br = new BufferedReader(new FileReader(path));

				for(String line = br.readLine(); line != null; line = br.readLine())
				{
					String[] value = line.split(" ");
					
					//check to make sure value is not null
					if(value == null)
					{
						System.out.println("Cannot read at line #"+ linePosition);
					}
					//check to make sure the correct parameters in the files are 4
					else if(value.length != 4)
					{
						System.out.println("There is/are missing arguments at line #"+ linePosition);
					}
					//start doing the reading here
					else
					{
						//read the vertex
						if(value[0].equals("v"))
						{
							Vertex v = new ThirdDimension();
							
							v.setValuePosition(0, Double.parseDouble((value[1])));
							v.setValuePosition(1, Double.parseDouble((value[2])));
							v.setValuePosition(2, Double.parseDouble((value[3])));
							
							vertex.add(v);
						}
						//read the faces
						else if(value[0].equals("f"))
						{
							Face f = new Face();
							
							f.addVertex(vertex.get(Integer.parseInt(value[1]) - 1));
							f.addVertex(vertex.get(Integer.parseInt(value[2]) - 1));
							f.addVertex(vertex.get(Integer.parseInt(value[3]) - 1));
							
						}
					}
					linePosition++;
				}
				
				System.out.println("Finishing reading file...");
				return faces;
			}
			else
			{
				System.out.println("File path is not valid");
				System.exit(0);
			}
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Cannot convert into numbers in line #"+ linePosition);
		}
		catch(Exception ex)
		{
			System.out.println("Error ReadSMF: line #"+linePosition+"\n" + ex.getMessage());
			System.exit(0);
		}
		
		
		return null;
	}

}
