package hjallad.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;

@SpringBootApplication
public class AddressBookApplication {

	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class);
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}

	private ISpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}

//	@Bean
//	public CommandLineRunner buddyInfoDemo(BuddyInfoRepository repository) {
//		return (args) -> {
//			// save a few buddyinfos
//			repository.save(new BuddyInfo("Hassan", "123 Main St", "613-558-5555"));
//			repository.save(new BuddyInfo("Jack", "48 Bayshore", "613-595-5556"));
//			repository.save(new BuddyInfo("Abdul", "7 Carleton", "613-545-5557"));
//
//			// fetch all buddyinfos
//			log.info("BuddyInfos found with findAll():");
//			log.info("-------------------------------");
//			for (BuddyInfo buddyInfo : repository.findAll()) {
//				log.info(buddyInfo.toString());
//			}
//			log.info("");
//
//			// fetch an individual buddyinfo by ID
//			BuddyInfo buddyInfo = repository.findById(1);
//			log.info("BuddyInfo found with findById(1):");
//			log.info("--------------------------------");
//			log.info(buddyInfo.toString());
//			log.info("");
//
//			// fetch buddyinfos by name
//			log.info("BuddyInfo found with findByName('Jane'):");
//			log.info("---------------------------------------");
//			repository.findByName("Jane").forEach(buddy -> {
//				log.info(buddy.toString());
//			});
//			log.info("");
//		};
//	}
//
//	@Bean
//	public CommandLineRunner addressBookDemo(AddressBookRepository repository) {
//		return (args) -> {
//			// save a few address books
//			AddressBook addressBook1 = new AddressBook();
//			addressBook1.addBuddy(new BuddyInfo("Hassan", "123 Main St", "613-558-5555"));
//			addressBook1.addBuddy(new BuddyInfo("Jack", "48 Bayshore", "613-595-5556"));
//			repository.save(addressBook1);
//
//			AddressBook addressBook2 = new AddressBook();
//			addressBook2.addBuddy(new BuddyInfo("Abdul", "7 Carleton", "613-545-5557"));
//			addressBook2.addBuddy(new BuddyInfo("Jallad", "7 Carleton", "613-545-5557"));
//			repository.save(addressBook2);
//
//			// fetch an individual address book by ID
//			AddressBook addressBook = repository.findById(1L).get();
//			log.info("Address book found with findById(1L):");
//			log.info("-------------------------------------");
//			log.info(addressBook.toString());
//			log.info("");
//		};
	//}

}
