package main.java.org.prz.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	private String showUserList() {
		String temp = new String();
		for (User l : userList) {
			temp = temp + "<tr><td>" + l.getUserId() + "</td><td>"
					+ l.getUserName() + "</td><td>" + l.getUserSurname()
					+ "</td></tr>";
			System.out.println(l.getUserName());
			
		}
		return temp;

	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("list", showUserList());
		return "users";
	}

	@RequestMapping(value = "/user/{name}/{surname}", method = RequestMethod.GET)
	public String welcomeName(ModelMap model, @PathVariable String name,
			@PathVariable String surname) {
		userIdCounter();
		addUser(topId, name, surname);
		model.addAttribute("list", showUserList());
		return "users";
	}
}
