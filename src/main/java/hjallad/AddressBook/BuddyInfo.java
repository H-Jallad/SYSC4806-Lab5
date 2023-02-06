package hjallad.AddressBook;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String phone;

    public BuddyInfo(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public BuddyInfo() {
        this.name = "Joe";
        this.address = "Carleton University Drive";
        this.phone = "6132137070";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //public void setAddressBook(AddressBook addressBook) {
//        this.addressBook = addressBook;
//    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString()
    {
        return name + "#" + address + "#"+phone;
    }

//   // public AddressBook getAddressBook() {
//        return addressBook;
//    }
}
