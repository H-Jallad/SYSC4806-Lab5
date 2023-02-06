package hjallad.AddressBook;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyList;

    public AddressBook(){
        buddyList = new ArrayList<>();
    }


    public void addBuddy(BuddyInfo buddy){
        buddyList.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {buddyList.remove(buddy);}
//
//    public void removeBuddy(BuddyInfo buddy){
//        buddyList.remove(buddy);
//    }

    public List<BuddyInfo> getBuddyList() {return buddyList;}

    @Override
    public String toString(){

        String bookInfo = "AddressBook ID: " + id.toString() + "\n";

        for (BuddyInfo buddyInfo : buddyList){
            bookInfo += buddyInfo.toString() + "\n";
        }

        return bookInfo;
    }

//    public void printBuddyList(){
//        for (BuddyInfo buddy : buddyList){
//            System.out.println(buddy.toString());
//        }
//    }

//    public static void main(String[] args) {
//        BuddyInfo buddy1 = new BuddyInfo("abdul", "10 kanata", "613111");
//        BuddyInfo buddy2 = new BuddyInfo("Hassan", "19 kanata", "613222");
//        BuddyInfo buddy3 = new BuddyInfo("Joe", "25 kanata", "613333");
//        AddressBook addressBook = new AddressBook();
//        addressBook.addBuddy(buddy1);
//        addressBook.addBuddy(buddy2);
//        addressBook.addBuddy(buddy3);
//
//        addressBook.printBuddyList();
//    }
}
