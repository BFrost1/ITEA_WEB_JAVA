package ua.com.ss.controllers.homePage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.ss.DAO.DBWorkerDAO;
import ua.com.ss.model.Country;
import ua.com.ss.model.User;
import ua.com.ss.service.CountryService;

@Controller
@ComponentScan("ua.com.ss.configurations")
public class HomePage {

	@Autowired
	public DBWorkerDAO<User> userService;

	@Autowired
	public DBWorkerDAO<Country> countryService;

	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String doGet(@Autowired HttpServletResponse response, @Autowired HttpServletRequest request) throws IOException {
		return "index";
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public void checkLogin(@RequestParam("loginReg") String loginReg, @Autowired HttpServletResponse response)
			throws IOException {
		if (userService.get("login", loginReg).size() != 0) {
			response.getWriter().write("false");
		} else {
			response.getWriter().write("true");
		}
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public void registration(@RequestParam("list[]") List<String> params, @Autowired HttpServletResponse response)
			throws IOException {
		int amountError = 0;

		if (!params.get(0).matches("^[a-zA-Z0-9]{1,}" + "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*" + "@" + "[a-zA-Z0-9]{1,}"
				+ "((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*" + "\\.[a-zA-Z]{2,}$")) {
			amountError++;
		}

		if (!params.get(1).matches("(?=.*[0-9]{2,})(?=.*[a-z]{2,})(?=.*[A-Z]{2,})[0-9a-zA-Z!@#$%^&*]{8,}")) {
			amountError++;
		}

		if (!params.get(1).equals(params.get(2))) {
			amountError++;
		}

		if (params.get(3).equals("") || !params.get(3).matches("^[a-zA-Z]+$")) {
			amountError++;
		}

		if (params.get(4).equals("") || !params.get(4).matches("^[a-zA-Z]+$")) {
			amountError++;
		}

		try {
			if (params.get(5).equals("") || !(Integer.valueOf(params.get(5)) >= 12)
					|| !(Integer.valueOf(params.get(5)) <= 100)) {
				amountError++;
			}
		} catch (NumberFormatException e) {
			amountError++;
		}

		if (params.get(6).equals("")) {
			amountError++;
		}

		if (params.get(7).equals("") || countryService.get("name", params.get(7)).size() == 0) {
			amountError++;
		}

		if (!params.get(9).equals("on")) {
			amountError++;
		}
		if (amountError == 0) {
			try {
				userService.save(new User(params.get(0), params.get(1), params.get(3), params.get(4),
					Integer.valueOf(params.get(5)), params.get(6), countryService.get("name", params.get(7)).get(0),
					params.get(8), params.get(9)));
					response.getWriter().write("true");
			}catch (Exception e) {
				response.getWriter().write("false");
			}
		} else {
			response.getWriter().write("false");
		}
	}

	@RequestMapping(value = "/authorization", method = RequestMethod.POST)
	public void authorization(@RequestParam("login") String login, @RequestParam("password") String password, @Autowired HttpServletResponse response, @Autowired HttpSession session) throws IOException {
		if(session.getAttribute("user") == null) {
			List<User> user = userService.get("login", login);
			if(user.size() == 1) {
				if(user.get(0).getPassword().equals(password)){
					session.setAttribute("user", user.get(0));
					response.getWriter().write("true");
				}else {
					response.getWriter().write("false");
				}
			}else {
				response.getWriter().write("false");
			}
		}else {
			session.setAttribute("user", null);
			response.getWriter().write("false");
		}
	}

	@RequestMapping(value = "/country", method = RequestMethod.POST)
	public void getCountry(@Autowired HttpServletResponse response) throws IOException {
		List<Country> list = new CountryService().getAll();
		for (int i = 0; i < list.size(); i++) {
			response.getWriter().write("<option>" + list.get(i).getName() + "</option>");
		}
	}
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(@Autowired HttpSession session) throws IOException {
		session.setAttribute("user", null);
	}

	
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String getAccount(@Autowired HttpServletResponse response, @Autowired HttpServletRequest request) throws IOException {
		return "account";
	}
	
	
}
