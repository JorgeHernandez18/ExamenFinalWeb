package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.edu.ufps.model.User;
import co.edu.ufps.services.UserService;


@Controller
public class ViewController {
	
    @Autowired
	private UserService userService;
	
    
	@GetMapping("/")
	public String login(Model model) {
		return "index";
	}

	@PostMapping("/login")
	public String loginUser(RedirectAttributes att, @RequestParam String email, @RequestParam String clave, Model model) {
		
		
		return "redirect:/";
		}
	
	
	@RequestMapping("/list")
	public String listUsers(Model model) {
		model.addAttribute("list", userService.getAll());
		return "mostrar";
	}
	
	@GetMapping("/show")
	public String showNewForm(Model model) {
		return "register";
	}
	
	@PostMapping("/save")
	public String register(User user, Model model) {
		userService.save(user);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		userService.delete(id);
		return "redirect:/list";
	}
	

}
