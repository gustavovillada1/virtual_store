package co.edu.icesi.virtualstore;

import co.edu.icesi.virtualstore.model.Role;
import co.edu.icesi.virtualstore.model.User;
import co.edu.icesi.virtualstore.repository.RoleRepository;
import co.edu.icesi.virtualstore.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories
public class VirtualstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualstoreApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner add(UserRepository ur, RoleRepository rr){
//		return (args) -> {
//
//			Role role1 = new Role(UUID.randomUUID(), "admin", "Offers support to the application by creating and updating items, orders and users");
//			Role role2 = new Role(UUID.randomUUID(), "user", "Uses the services provided by the application, its allowed to navigate thru the application, creating and handling its orders");
//
//			rr.save(role1);
//			rr.save(role2);
//
//			 User user1 = new User();
//			 user1.setId(UUID.randomUUID());
//			 user1.setEmail("gustavo@icesi.edu.co");
//			 user1.setPassword("Gustavo.1");
//			 user1.setAddress("Cra 94a");
//			 user1.setPhoneNumber("+573215515680");
//			 user1.setRoleId(role1.getId().toString());
//
//			 ur.save(user1);
//		};
//	}

}
