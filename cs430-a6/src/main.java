import Dimension.*;
import FileInteraction.*;

public class main {

	public static void main(String[] args) {
		ReadFile s = new ReadSMF();
		
		s.readFile(args[0]);
	}

}
