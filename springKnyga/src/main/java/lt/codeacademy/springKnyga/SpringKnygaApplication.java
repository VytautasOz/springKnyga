package lt.codeacademy.springKnyga;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.springKnyga.service.KnygaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringKnygaApplication {

	private final KnygaService knygaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringKnygaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void commands(){
		knygaService.addTestKnyga();

		knygaService.removeKnyga(1);

		knygaService.printKnygaById(2);
		knygaService.updateVieta(2, "Sodas");
		knygaService.printKnygaById(2);

		knygaService.printAllGenresWithBooks();

		knygaService.getByZanras("Fantastika");
		knygaService.printKnygosByZanras("Fantastika");

	}




}
