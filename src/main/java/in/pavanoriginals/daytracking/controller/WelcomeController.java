package in.pavanoriginals.daytracking.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class WelcomeController {
	
	@GetMapping("/wish")
	public String grettings() {
		return "Welcome to the Day tracking services";
	}
	

}
