import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class main {
    public static void main(String args[]) {
         CityDAO cityDAO = new CityDAO();
        List<String> citiesLines= cityDAO.readDataFromCSV("Cities.csv");
        List<City> cities = cityDAO.createCities(citiesLines);
        
        
        
        CountryDAO countryDAO = new CountryDAO();
        List<String> countryLines = countryDAO.readDataFromCSV("Countries.csv");
        List<Country> countries = countryDAO.createCities(countryLines);
        
       //set of country in cities
       cityDAO.setCountryInCity(cities, countries);
       
       cityDAO.setCitiesOfCountry(cities, countries);
       
        
       
        Map<String, List<City>> map = new HashMap();
        countries.forEach(country -> {
            map.put(country.getName(),country.getCities());
        }); 
        
        map.forEach((k, v) -> 
            System.out.println("Country Name =" + k + ", Cities with sorted =" + v));
    }
    
}
