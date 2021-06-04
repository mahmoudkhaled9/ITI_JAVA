import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;


public class Tablesaw {
    public static void main(String args[]) {
        
        String path ="titanic.csv";
       
        //Tablesaw
        Table data;
        try {
            data = Table.read ().csv (path);
            
            System.out.println("Structure of all data :"+ data.structure());
            System.out.println("---------------------------------------------------------\n");
            System.out.println("Summary of all data :"+ data.summary ());
            System.out.println("---------------------------------------------------------\n");
            
            //add new column
            Integer[] column = new Integer[data.column(0).size()];
            for(int i =0 ;i<column.length;i++){
                column[i] = i+1;
            
            }
            IntColumn newColumn = IntColumn.create("newColumn", column);
            data.addColumns(newColumn);
            System.out.println("Structure of all data after adding new column :"+ data.structure());
            System.out.println("---------------------------------------------------------\n");
            
            Table table_1 = data.select("pclass","survived");
            Table table_2 = data.select("name");
            table_1.addColumns(newColumn);
            table_2.addColumns(newColumn);
            
            Table join = table_1.joinOn("newColumn").inner(table_2);
            System.out.println("Structure of join data :"+ join.structure());
            System.out.println("---------------------------------------------------------\n");
            System.out.println("Summary of join data :"+ join.summary ());
            System.out.println("---------------------------------------------------------\n"); 
            
            

        } catch (IOException ex) {
            Logger.getLogger(Tablesaw.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    }

   
}
