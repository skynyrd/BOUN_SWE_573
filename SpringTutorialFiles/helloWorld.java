@RestController
public class HelloController{

	@RequestMapping("/")
	public String index(){
		return "Greetings from Spring Boot-Java!"
	}
}