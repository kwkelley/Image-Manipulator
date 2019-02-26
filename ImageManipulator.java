//author @ Keane Kelley
import java.io.File;
import java.util.Arrays;


public class ImageManipulator
{
  public ImageManipulator() {}
  
  public void removePhotobomb(String paramString1, String paramString2)
  {
    File[] arrayOfFile = new File(paramString1).listFiles();
    

    int i = 0;
    for (int j = 0; j < arrayOfFile.length; j++)
    {

      if (arrayOfFile[j].getName().endsWith(".jpg")) {
        i++;
      }
    }
    
    j = 0;
    Picture[] arrayOfPicture = new Picture[i];
    for (int k = 0; k < arrayOfFile.length; k++) {
      if (arrayOfFile[k].getName().endsWith(".jpg"))
      {



        Picture localPicture1 = new Picture(paramString1 + "/" + arrayOfFile[k].getName());
        
        arrayOfPicture[j] = localPicture1;
        j++;
      }
    }
    

    k = arrayOfPicture[0].getWidth();
    int m = arrayOfPicture[0].getHeight();
    
    Picture localPicture2 = new Picture(k, m);
    

    for (int n = 0; n < k; n++) {
      for (int i1 = 0; i1 < m; i1++)
      {

        int[] arrayOfInt1 = new int[i];
        int[] arrayOfInt2 = new int[i];
        int[] arrayOfInt3 = new int[i];
        
        for (int i2 = 0; i2 < i; i2++) {
          localPixel = arrayOfPicture[i2].getPixel(n, i1);
          

          int i3 = localPixel.getRed();
          int i4 = localPixel.getGreen();
          int i5 = localPixel.getBlue();
          

          arrayOfInt1[i2] = i3;
          arrayOfInt2[i2] = i4;
          arrayOfInt3[i2] = i5;
        }
        


        Arrays.sort(arrayOfInt1);
        Arrays.sort(arrayOfInt2);
        Arrays.sort(arrayOfInt3);
        

        i2 = i / 2;
        

        Pixel localPixel = new Pixel(arrayOfInt1[i2], arrayOfInt2[i2], arrayOfInt3[i2]);
        
        localPicture2.setPixel(n, i1, localPixel);
      }
    }
    localPicture2.store(paramString2);
  }
  
  public void zoomMiddle(String paramString1, String paramString2)
  {
    Picture localPicture1 = new Picture(paramString1);
    
    int i = localPicture1.getWidth();
    int j = localPicture1.getWidth();
    
    int k = i / 4;
    int m = j / 4;
    
    int n = k;
    int i1 = m;
    
    int i2 = i - k;
    int i3 = j - m;
    
    Picture localPicture2 = new Picture(i, j);
    

    for (int i4 = i1; i4 < i3; i4++) {
      for (int i5 = n; i5 < i2; i5++)
      {

        if (((i5 - k) * 2 + 1 < i) && ((i4 - m) * 2 + 1 < j))
        {


          Pixel localPixel = localPicture1.getPixel(i5, i4);
          




          localPicture2.setPixel((i5 - k) * 2, (i4 - m) * 2, localPixel);
          localPicture2.setPixel((i5 - k) * 2, (i4 - m) * 2 + 1, localPixel);
          localPicture2.setPixel((i5 - k) * 2 + 1, (i4 - m) * 2, localPixel);
          localPicture2.setPixel((i5 - k) * 2 + 1, (i4 - m) * 2 + 1, localPixel);
        }
      }
    }
    
    localPicture2.store(paramString2);
  }
}
