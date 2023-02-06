//package hjallad.AddressBook;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/buddyinfo")
//public class BuddyInfoController {
//
//    @Autowired
//    private BuddyInfoRepository repository;
//
//    @GetMapping
//    public List<BuddyInfo> getAllBuddies() {
//        return repository.findAll();
//    }
//
//    @PostMapping
//    public BuddyInfo createBuddy(@RequestBody BuddyInfo buddy) {
//        return repository.save(buddy);
//    }
//
//    @PutMapping("/{id}")
//    public BuddyInfo updateBuddy(@PathVariable Long id, @RequestBody BuddyInfo buddy) {
//        buddy.setId(id);
//        return repository.save(buddy);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteBuddy(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
//}
