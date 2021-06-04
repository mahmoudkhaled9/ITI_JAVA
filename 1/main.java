import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String args[]) {
        PyramidcsvDAO obj = new PyramidcsvDAO();
       List<Pyramid> l;
       l = new ArrayList<>();
       l= obj.readPyramidsFromCSV("pyramids.csv");
       for(Pyramid p : l)
       {
          System.out.println(p);
       }
    }
}
