import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


public class main {
    public static void main(String args[]) {
        
        CityDAO cityDAO = new CityDAO();
        List<String> citiesLines= cityDAO.readDataFromCSV("Cities.csv");
        List<City> cities = cityDAO.createCities(citiesLines);
        CountryDAO countryDAO = new CountryDAO();
        List<String> countryLines = countryDAO.readDataFromCSV("Countries.csv");
        List<Country> countries = countryDAO.createCities(countryLines);
        
       cityDAO.setCountryInCity(cities, countries);
       
       cityDAO.setCitiesOfCountry(cities, countries);
     
        
       countries.forEach(country -> {
           int max = country.getCities().stream()
                   .mapToInt(city -> city.getPopultion())
                   .max()
                   .orElse(0);
            System.out.println("Hight population is "+max+" in "+ country.getName());
       });
       

       
        Map<String, List<City>> groups =
                cities.stream().collect(groupingBy( c->c.getContinent(), toList()));
       
    
        
        groups.forEach((k,v)-> {
           System.out.println("Continent is "+k+ " and Highest population city is "+v.stream().mapToInt(c->c.getPopultion()).max().orElse(0));});
       
      
       int max = cities.stream().filter(c->c.isCapital())
               .mapToInt(p->p.getPopultion())
               .max()
               .orElse(0);
       System.out.println("Highest population capital is "+ max);
    }
}
