package in.ashokit;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctxt =
				SpringApplication.run(Application.class, args);
		
		BookRepository repo = ctxt.getBean(BookRepository.class);
		
		Book b = new Book();
		
		b.setBookId(101);
		b.setBookName("SpringBoot");
		b.setBookPrice(1000.00);
		
		repo.save(b);
		
		System.out.println("Record inserted....");
		
		Optional<Book> findById = repo.findById(101);
		System.out.println(findById.get());
		
		
		
		
		
	}

}
