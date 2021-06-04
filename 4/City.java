public class City {
     private int id;
    private String name;
    private String continent;
    private String Surface_Area;
    private int popultion;
    private int country_id;
    private boolean capital;
        
   private Country country;
   
    public City(int id, String name, String continent, String Surface_Area, int popultion, int country_id, boolean capital) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.Surface_Area = Surface_Area;
        this.popultion = popultion;
        this.country_id = country_id;
        this.capital = capital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getSurface_Area() {
        return Surface_Area;
    }

    public void setSurface_Area(String Surface_Area) {
        this.Surface_Area = Surface_Area;
    }

    public int getPopultion() {
        return popultion;
    }

    public void setPopultion(int popultion) {
        this.popultion = popultion;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    @Override
    public String toString() {
        return "Id: "+id+", Name: "+name +", Population: "+ popultion;
    }
    
}
