import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CityDAO {
     public List<String> readDataFromCSV(String fileName)
    {
        List<String> lines = new ArrayList<>();
        File f = new File(fileName);
        try {
            lines= Files.readAllLines(f.toPath());
        } catch (IOException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }
    
    public List<City> createCities(List<String> lines)
    {
        List<City> cities = new ArrayList<>();
        for(int i=1 ; i<lines.size();i++ )
        {
            String[] splits = lines.get(i).split(",");
            City city = new City(Integer.parseInt(splits[0]),splits[1],splits[2],splits[3],Integer.parseInt(splits[4]),Integer.parseInt(splits[6]),Boolean.parseBoolean(splits[5]));
            cities.add(city);
            
        }
        return cities;
    }
    
    public void setCountryInCity(List<City> cities, List<Country> countries)
    {
        for(City c : cities){
            for(Country cn : countries)
            {
                if(c.getCountry_id() == cn.getId())
                {
                    c.setCountry(cn);
                    break;
                }
            }
        }
        
        
        
    }
    
    public void setCitiesOfCountry(List<City> cities, List<Country> countries)
    {
        cities.forEach(c -> {
            Country cn = c.getCountry();
            cn.setCities(c);
            c.setCountry(cn);
        });
    }
    
}
