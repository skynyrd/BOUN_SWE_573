@RestController
public class HelloWorld{

	@RequestMapping("/")
	public String home(){
		"Greetings from Spring Boot-Groovy!"
	}
}