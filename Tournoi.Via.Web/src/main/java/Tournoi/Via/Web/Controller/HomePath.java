
package Tournoi.Via.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class HomePath {
	
	@GetMapping("/")
	public String home() {
		return "login";


}
}