"author @ Keane Kelley"

import java.io.PrintStream;

public class ImageDriver {
  public ImageDriver() {}
  
  public static void main(String[] paramArrayOfString) { if (paramArrayOfString.length == 0) {
      System.out.println("Error: file not present");
      System.exit(0);
    }
    


    ImageManipulator localImageManipulator = new ImageManipulator();
    

    localImageManipulator.removePhotobomb(paramArrayOfString[0], "nophotobomb.jpg");
    

    localImageManipulator.zoomMiddle("nophotobomb.jpg", "zoomed.jpg");
  }
}