public class Address {
    String street;
    int houseNumber;
    int zipCode;
    int occupants;
    boolean isApartment;
    int aptNumber;

    // String address;

    public Address(String street, int houseNumber, int zipCode,int occupants, boolean isApartment, int aptNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.isApartment = isApartment;
        if (isApartment){
            this.aptNumber = aptNumber;
        } else {
            this.aptNumber = 0;
        }
        this.occupants = occupants;
    }

    /* public String createAddress(String street, int houseNumber, int zipCode, boolean isApartment, int aptNumber) {
        if (isApartment) {
        address = street + " " + houseNumber + ", " + zipCode + ", Korter:" + aptNumber;
        } else {
            address = street + " " + houseNumber + ", " + zipCode;
        }
        return address;
    } */

    public void changeAptNumber(int newNum) {
        if (isApartment) {
            aptNumber = newNum;
        } else {
            System.out.println("Ei saa korteri numbrit muuta mitte korter tüüpi hoones.");
        }
    }
}
