package hjallad.AddressBook;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long>{
    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);
}
