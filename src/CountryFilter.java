public class CountryFilter implements Filter {

    private String country;
    public CountryFilter() {
    }
    public void addConstrain(Object country){
        this.country = (String)country;
    }
    @Override
    public String filter(Guest guest) {
        if(guest.isResidentOf(country))
                return country;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryFilter that = (CountryFilter) o;

        return country != null ? country.equals(that.country) : that.country == null;

    }

    @Override
    public int hashCode() {
        return country != null ? country.hashCode() : 0;
    }
}
