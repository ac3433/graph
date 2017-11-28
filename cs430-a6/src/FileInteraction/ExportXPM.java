package FileInteraction;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Drawing.Framebuffer;

public class ExportXPM {

	public void Export(Framebuffer grid, String filename)
	{
		try
		{
			Path file = Paths.get(filename+".xpm");
			
			List<String> lines = new ArrayList<String>();
			
			lines.add("/* XPM */");
			lines.add("static char * gv_xpm[] = {");
			lines.add("/* width height num_colors chars_per_pixel */");
			lines.add("\"500 500 2 1 \",");
			lines.add("/*colors */");
			lines.add("\"0 c #FFFFFF\",");
			lines.add("\"1 c #000000\",");


			for(int i = 0; i < grid.getSizeX(); i++)
			{
				String line = "\"";
				for(int j = 0; j < grid.getSizeY(); j++)
				{
					String temp = grid.getGrid()[i][j];
					
					if(temp == null)
						line = line.concat("0");
					else
						line = line.concat("1");			
				}
				
				if(i != grid.getSizeX()- 1)
					line = line.concat("\",");
				else
					line = line.concat("\"");
				lines.add(line);
			}
			lines.add("};");
			
			
			Files.write(file, lines);
			
			System.out.println("You can now find your file output here: " + file);
		}
		catch(Exception e)
		{
			System.out.println("Cannot export "+ filename);
		}

	}
}
