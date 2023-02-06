package hjallad.AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TemplateViewer {

    @Autowired
    private AddressBookRepository addressBookrepo;

    @GetMapping("/view-buddies")
    public String viewAddressBook(@RequestParam(value = "bookId") Long addressBookId, Model model) {
        Optional<AddressBook> addressBookOptional = addressBookrepo.findById(addressBookId);
        if (!addressBookOptional.isPresent()) {
            return "AddressBook not found";
        }
        AddressBook addressBook = addressBookOptional.get();
        model.addAttribute("buddies", addressBook.getBuddyList());
        return "addressbook-view";
    }
}
