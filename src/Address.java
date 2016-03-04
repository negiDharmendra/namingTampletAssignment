public class Address {
    private final String city;
    private final String state;
    private final String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCountryName() {
        return country;
    }

    @Override
    public boolean equals(Object anotherAddress) {
        if (this == anotherAddress) return true;
        if (!(anotherAddress instanceof Address)) return false;
        Address address = (Address) anotherAddress;
        return city.equals(address.city)&&state.equals(address.state)&&country.equals(address.country);
    }
    @Override
    public String toString() {
        return "City : " + city +
                ", State : " + state +
                ", Country : " + country;
    }
}
