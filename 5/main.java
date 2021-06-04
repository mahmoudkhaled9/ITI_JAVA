import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class main {
    public static void main(String args[]) {
        String fileName = "pyramids.csv";
        List<Double> dataSorted = readDataFromCSV(fileName).stream().sorted().collect(Collectors.toList());
        int size = dataSorted.size();
        System.out.println("Size of Data = "+size);
        int indexMedian = median(0,size);
        System.out.println("Index of Median = "+indexMedian+ " and Value = "+dataSorted.get(indexMedian) );
        int indexFirstQuartile = median(0, indexMedian);
        System.out.println("Index of first Quartile = " + indexFirstQuartile +" and Value = "+dataSorted.get(indexFirstQuartile));
        int indexSecondQuartile = median(indexMedian+1 , size);
        System.out.println("Index of Second Quartile = " + indexSecondQuartile+" and Value = "+dataSorted.get(indexSecondQuartile));
        System.out.println("InterQuartile = " + (dataSorted.get(indexSecondQuartile)-dataSorted.get(indexFirstQuartile)));
            
     
    }
    
    static List<Double> readDataFromCSV(String fileName)
    {
        File f =new File(fileName);
        List<String> lines;
        List<Double> data = new ArrayList();
        try {
            lines = Files.readAllLines(f.toPath());
            for(int i =1 ; i<lines.size() ;i++)
            {
                String[] splits = lines.get(i).split(",");
                if(!splits[7].isEmpty())
                {
                    data.add(Double.parseDouble(splits[7]));
                } 
            }
        
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
        
    }
    static int median(int StartIndex, int r)
    {
       int n = r - StartIndex + 1;
       n = (n + 1) / 2 - 1;
       return n + StartIndex;
    }
    
}
