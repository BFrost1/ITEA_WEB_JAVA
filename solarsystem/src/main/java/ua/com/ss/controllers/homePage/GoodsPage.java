package ua.com.ss.controllers.homePage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import ua.com.ss.DAO.DBWorkerDAO;
import ua.com.ss.model.Item;

@Controller
@ComponentScan("ua.com.ss.configurations")
public class GoodsPage {

	Map<Item,Integer> listItems =  new HashMap<Item, Integer>();
	
	@Autowired
	public DBWorkerDAO<Item> itemService;
	
	@RequestMapping(value = "/telescopes", method = RequestMethod.GET)
	public String getGoods(ModelMap modelMap, @RequestParam(required = false) Integer id) throws IOException {	
		if(id == null) {
			modelMap.addAttribute("goods", itemService.getAll());
		}else{	
			List<Item> list = itemService.getAll();
			List<Item> goods = new ArrayList<Item>();
			for(int i = 0 ; i < list.size(); i++) {
				if(list.get(i).getDistanceLevel() >= id) {
					goods.add(list.get(i));
				}
			}
			modelMap.addAttribute("goods", goods);
		}
			return "goods";
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public void filter(@Autowired PrintWriter print, @RequestParam(required = false) Integer id) throws IOException {	
			List<Item> list = itemService.getAll();
			for(int i = 0 ; i < list.size(); i++) {
				if(list.get(i).getDistanceLevel() >= id) {
					print.write("<div class='cell'>"
							+ "<div><img src='./resources/static/img/telescopes/"+list.get(i).getLinkImg() +"'></div>"
							+ "<div><span>" +list.get(i).getName()+ "</span></div>"
							+"<div class='price'>"
							+"<div>" + list.get(i).getPrice() + " $</div>"
							+ "<div><i class='fa fa-shopping-bag p-l-r-5' id='"+ list.get(i).getId() +"'></i></div>"
							+"</div></div>"
							);  
				}
			}

		}
	
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public void addCart(@Autowired PrintWriter print, @RequestParam() Integer id, @Autowired HttpSession session) throws IOException {	
		Item item = itemService.get(id);
		if(listItems.put(item, 1) == null) {
			print.write("<div class = 'cart-cell' id='"+ item.getId() +"'>"+
						"<div><img src='./resources/static/img/telescopes/" + item.getLinkImg()+"'></div>"+
						"<div>"+
						"<div class='price-delete'>"+
						"<div>"+ item.getName() +"</div>"+
						"<div>"+ item.getPrice() +"</div>"+
						"<div><input type='number' class = 'order' value = '1' id='"+ item.getId()+ "' min='1' max='10'></div>"+
						"</div>"+
						"</div>"+
						"<div><i class='fa fa-times' style='color: red;' id='"+ item.getId()+ "'  ></i></div>"+
						"</div>");
			}
			if(session.getAttribute("cart") == null) {
				session.setAttribute("cart", listItems);
			}
		}
	
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public void deleteItem(@Autowired PrintWriter print, @RequestParam() Integer id) throws IOException {	
			Item item = itemService.get(id);
			if(listItems.containsKey(item)) {
				listItems.remove(item);
				print.write("true");
			}
		}
	
		@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
		public void order(ModelMap modelMap, @RequestParam("list1[]") List<Integer> params1, @RequestParam("list2[]") List<Integer> params2, @Autowired HttpSession session) throws IOException {	
				for(int i = 0; i < params1.size(); i++) {
					Item item = itemService.get(params1.get(i));
					if(listItems.containsKey(item)){
						listItems.put(item, params2.get(i));
					}
				}
		}
		
		
		@RequestMapping(value = "/listOrder", method = RequestMethod.GET)
		public String order(ModelMap modelMap, @Autowired HttpSession session) throws IOException {	
				if(listItems.size() != 0) {
					modelMap.addAttribute("list", listItems);
					listItems = new HashMap<Item, Integer>();
					session.setAttribute("cart", listItems);
				}
				return "order";
		}
	
	

	
}

