package main.java.org.prz.java;

import java.util.ArrayList;
import java.util.List;

import org.prz.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private Integer topId = null;
	private List<User> userList = new ArrayList <User>();
	private Integer userIdCounter() {
		if (topId != null)
			return ++topId;
		else
			return topId = 1;
	}

	private void addUser(Integer id, String name, String surname) {
		User user = new User();
		user.setUserId(id);
		user.setUserName(name);
		user.setUserSurname(surname);
		userList.add(user);
		
	}


	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showUsers(ModelMap model) {
		model.addAttribute("list", userList);
		return "users";
	}

	@RequestMapping(value = "/user/{name}/{surname}", method = RequestMethod.GET)
	public String createUser(ModelMap model, @PathVariable String name,
			@PathVariable String surname) {
		userIdCounter();
		addUser(topId, name, surname);
		for (User u: userList){
			System.out.println(u.getUserSurname());
		}
		model.addAttribute("list", userList);
		return "users";
	}
	private void edit(Integer id, String name, String surname){
		User user = new User();
		user.setUserId(id);
		user.setUserName(name);
		user.setUserSurname(surname);
		userList.set(id-1, user);
	}
	@RequestMapping(value = "/user")
	public String editUser(ModelMap model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("surname") String surname){
		edit(Integer.parseInt(id), name, surname);
		model.addAttribute("list", userList);
		
		
		return "users";
		
	}
	
}
