package hjallad.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookrepo;

    @Autowired
    private BuddyInfoRepository buddyRepo;

//    @GetMapping
//    public List<AddressBook> getAllAddressBooks() {
//        return (List<AddressBook>) repo.findAll();
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<AddressBook> getAddressBookById(@PathVariable(value = "id") Long id) {
//        Optional<AddressBook> addressBook = repo.findById(id);
//        if (!addressBook.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(addressBook.get());
//    }

    @RequestMapping("/create")
    public ResponseEntity<AddressBook> createAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBookrepo.save(addressBook);
        return new ResponseEntity<>(addressBook, HttpStatus.CREATED);
    }

    @GetMapping("/addBuddy")
    public ResponseEntity<AddressBook> addBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone, @RequestParam(value = "bookId") Long addressBookId){
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName(name);
        buddy.setPhone(phone);
        buddy.setAddress(address);
        Optional<AddressBook> addressBookOptional = addressBookrepo.findById(addressBookId);
        //check if addressbook object exists
        if (!addressBookOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        buddyRepo.save(buddy);
        AddressBook addressBook = addressBookOptional.get();
        addressBook.addBuddy(buddy);
        addressBookrepo.save(addressBook);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    @GetMapping("/removeBuddy")
    public ResponseEntity<AddressBook> removeBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "bookId") Long addressBookId){
        Optional<AddressBook> addressBookOptional = addressBookrepo.findById(addressBookId);
        //check if addressbook object exists
        if (!addressBookOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        AddressBook addressBook = addressBookOptional.get();
        //check if buddy exists
        List<BuddyInfo> buddyList = buddyRepo.findByName(name);
        if (buddyList.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BuddyInfo buddy = buddyList.get(0);
        addressBook.removeBuddy(buddy);
        addressBookrepo.save(addressBook);
        buddyRepo.delete(buddy);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

}
