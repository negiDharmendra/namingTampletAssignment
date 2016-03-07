public class Address {
    private final String city;
    private final String state;
    private final String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
    public boolean isCountry(String country) {
        return (this.country.toUpperCase()).equals(country.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        boolean isCityMathces=false,isStateMatches=false,isCountryMatches=false;
        if (city != null && city.equals(address.city)) isCityMathces = true;
        if (state != null && state.equals(address.state)) isStateMatches = true;
        if (country != null && country.equals(address.country)) isCountryMatches = true;
        return isCityMathces&&isStateMatches&&isCountryMatches;

    }

    @Override
    public String toString() {
        return "City : " + city +
                ", State : " + state +
                ", Country : " + country;
    }

}
