package Drawing;

import Shape.Line;

public class LineDrawing {

	public Framebuffer drawLine(Framebuffer frame, Line line)
	{
		int yCord;
		int xCord;
		Framebuffer g = frame;
		
		try
		{
			double dx, dy, step;
			
			dx = Math.abs(line.getX2() - line.getX1());
			dy = Math.abs(line.getY2() - line.getY1());
			
			if(dx >= dy)
				step = dx;
			else
				step = dy;
			
			double xc = dx/step;
			double yc = dy/step;
			
			if(line.getX2() < line.getX1())
				xc = xc * -1;
			if(line.getY2() < line.getY1())
				yc = yc * -1;
			
			double xp = line.getX1();
			double yp = line.getY1();			
			
			for(int i = 0; i < step; i++)
			{
				yCord = (g.getSizeY() - 1) - (int) Math.round(yp);
				xCord = (int) Math.round(xp);
				g.getGrid()[ yCord][ xCord] = "1";
				xp+= xc;
				yp+= yc;
			}
		
		}
		catch(Exception e)
		{
			System.out.println("An error in doing DDA calculation. ");
		}
		
		return g;
	}
}
