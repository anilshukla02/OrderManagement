package com.nirmalyalabs.voicerecognition.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nirmalyalabs.voicerecognition.Entity.ItemMaster;
import com.nirmalyalabs.voicerecognition.Entity.Myuser;
import com.nirmalyalabs.voicerecognition.Entity.OrderMasterDTO;
import com.nirmalyalabs.voicerecognition.Entity.Ordermaster;
import com.nirmalyalabs.voicerecognition.Entity.Customer;
import com.nirmalyalabs.voicerecognition.Entity.CustomerDTO;
import com.nirmalyalabs.voicerecognition.Entity.language;
import com.nirmalyalabs.voicerecognition.Entity.ops;
import com.nirmalyalabs.voicerecognition.Entity.opsDTO;

import com.nirmalyalabs.voicerecognition.Service.CustomerService;
import com.nirmalyalabs.voicerecognition.Service.ItemsService;
import com.nirmalyalabs.voicerecognition.Service.LanguageService;
import com.nirmalyalabs.voicerecognition.Service.MyUserService;
import com.nirmalyalabs.voicerecognition.Service.OrdermasterService;
import com.nirmalyalabs.voicerecognition.Service.opsService;

@Controller
@RequestMapping("/api")
public class ItemController {

	@Autowired
	ItemsService itemsService;

	@Autowired
	MyUserService myUserService;

	@Autowired
	CustomerService customerService;

	@Autowired
	LanguageService languageService;

	@Autowired
	opsService opsservice;

	@Autowired
	OrdermasterService ordermasterService;

	opsDTO myOrderItems;
	Myuser currUser;
	CustomerDTO customerDTO;

	private static final int SIZE = 3;

	public ItemController(ItemsService itemsService, opsService opsservice) {
		super();
		this.itemsService = itemsService;
		this.opsservice = opsservice;
	}

// HOMEPAGE....
	@GetMapping("/index")
	public String landingpage() {
		return "index";
	}

// ITEMS...
	@GetMapping("/items")
	public ModelAndView showItems() {
		ModelAndView mav = new ModelAndView("listitems");
		List<ItemMaster> list = itemsService.getAllItems();
		mav.addObject("items", list);
		return mav;

	}

	@GetMapping("/addItemForm")
	public ModelAndView addItem() {
		ModelAndView mav = new ModelAndView("add-item-form");
		ItemMaster itemMaster = new ItemMaster();
		mav.addObject("item", itemMaster);
		return mav;

	}

	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") ItemMaster itemMaster) {
		itemsService.saveItem(itemMaster);
		return "redirect:/api/items";
	}

	@GetMapping("/showItemUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long itemId) {
		ModelAndView mav = new ModelAndView("add-item-form");

		ItemMaster itemMaster = itemsService.GetItemByID(itemId);
		mav.addObject("item", itemMaster);
		return mav;
	}

	@GetMapping("/showItemDeleteForm")
	public String showDeleteForm(@RequestParam Long itemId) {
		itemsService.DeleteItemByID(itemId);
		return "redirect:/api/items";
	}

	/****
	 * // Save Item
	 * 
	 * @PostMapping public ResponseEntity<ItemMaster> saveItemMaster(@RequestBody
	 *              ItemMaster itemMaster) { return new
	 *              ResponseEntity<ItemMaster>(itemsService.saveItem(itemMaster),
	 *              HttpStatus.CREATED); }
	 ****/

// CUSTOMERS...

	@GetMapping("/customers")
	public ModelAndView showCustomers() {
		ModelAndView mav = new ModelAndView("listcustomers");
		List<Customer> list = customerService.getAllCustomers();
		mav.addObject("customers", list);
		return mav;

	}

	@GetMapping("/addCustomerForm")
	public ModelAndView addCustomer() {
		ModelAndView mav = new ModelAndView("add-customer-form");
		Customer customer = new Customer();
		customer.setCustValid(true);
		mav.addObject("customer", customer);
		return mav;

	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("Anil11 " + customer);
		customerService.saveCustomer(customer);
		return "redirect:/api/customers";
	}

	@GetMapping("/showCustomerUpdateForm")
	public ModelAndView showCustomerUpdateForm(@RequestParam Long custId) {
		ModelAndView mav = new ModelAndView("add-customer-form");

		Customer customer = customerService.GetCustomerByID(custId);
		mav.addObject("customer", customer);
		return mav;
	}

	@GetMapping("/showCustomerDeleteForm")
	public String showCustomerDeleteForm(@RequestParam Long custId) {
		customerService.DeleteCustomerByID(custId);
		return "redirect:/api/customers";
	}

// USERS...	

	@GetMapping("/users")
	public ModelAndView showUsers() {
		ModelAndView mav = new ModelAndView("listusers");
		List<Myuser> list = myUserService.getAllUsers();
		mav.addObject("users", list);
		return mav;

	}

	@GetMapping("/addUserForm")
	public ModelAndView userlogin() {
		ModelAndView mav = new ModelAndView("add-user-form");
		Myuser user = new Myuser();
		mav.addObject("user", user);
		List<language> languages = languageService.getAllLanguages();
		mav.addObject("languages", languages);
		return mav;

	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") Myuser myuser) {
		System.out.println("Sunil User to be saved " + myuser);
		myUserService.saveUser(myuser);
		return "redirect:/api/users";
	}

	@GetMapping("/showUserUpdateForm")
	public ModelAndView showUserUpdateForm(@RequestParam String userid) {
		ModelAndView mav = new ModelAndView("add-user-form");

		Myuser myuser = myUserService.GetUserByID(userid);
		System.out.println("Anil Debug updation: " + myuser);
		mav.addObject("user", myuser);
		List<language> languages = languageService.getAllLanguages();
		mav.addObject("languages", languages);
		return mav;
	}

	@GetMapping("/showUserDeletForm")
	public String showUserDeletForm(@RequestParam String userid, Principal principal) {

		// Check if current user
		if (principal.getName().equals(userid)) {
			return "redirect:/api/users?error";
		} else {
			myUserService.DeleteUserByID(userid);
			return "redirect:/api/users";
		}
	}

// ORDERS....

	@GetMapping("/orders")
	public ModelAndView showOrders() {
		ModelAndView mav = new ModelAndView("listorders");
		List<Ordermaster> allOrders = ordermasterService.getAllOrders();
		List<OrderMasterDTO> list = new ArrayList<>();

		for (Ordermaster ordermaster : allOrders) {
			OrderMasterDTO temp = new OrderMasterDTO();
			temp.setOrdermaster(ordermaster);
			temp.setCustname(customerService.GetCustomerByID(ordermaster.getCustid()).getCustname());
			list.add(temp);
		}

		mav.addObject("orders", list);
		return mav;

	}

	@GetMapping("/addorder")
	public ModelAndView addOrder(@RequestParam(required = false) final String orderId) {

		ModelAndView mav = new ModelAndView("Orderform");

		// List of all customers. For sending we dont need all fields so creating DTO
		List<Customer> custlist = customerService.getAllCustomers();
		List<CustomerDTO> allCustomers = new ArrayList<>();

		if (!(orderId.equals("-1"))) // -1 is a case of new order but that needs correction
		{
			myOrderItems = new opsDTO();
			if ((orderId == null) || (orderId.equals("0"))) {

				for (int i = 0; i < SIZE; i++) {
					myOrderItems.addOrderItem(new ops());
				}

			} else {
				Ordermaster ordermaster = ordermasterService.GetOrdermasterById(Long.parseLong(orderId));
				List<ops> allOrderItems = opsservice.getAllOrdersByOrderId(Long.parseLong(orderId));
				myOrderItems.setOrderedItemlist(allOrderItems);
				myOrderItems.setCustId(ordermaster.getCustid());

			}
		}

		for (Customer customer : custlist) {
			CustomerDTO temp = new CustomerDTO();
			temp.setCustId(customer.getCustId());
			temp.setCustname(customer.getCustname());
			temp.setCustValid(customer.getCustValid());
			if (customer.getCustId() == myOrderItems.getCustId())
				myOrderItems.setCustomername(customer.getCustname());
			allCustomers.add(temp);
		}

		mav.addObject("myorderitems", myOrderItems);
		mav.addObject("allCustomers", allCustomers);
		return mav;

	}

	@PostMapping("/saveorder")
	public String saveOrder(@ModelAttribute("myorderitems") opsDTO myOrderItems, RedirectAttributes redirectAttributes,
			Model model) {

		List<ops> orderItemsList = myOrderItems.getOrderedItemlist();
		this.myOrderItems = new opsDTO(orderItemsList, myOrderItems.getCustId());

		if (opsservice.validateOrderItems(orderItemsList)) {
			// Has all valid items. So save the order.
			opsservice.saveOrder(orderItemsList, myOrderItems.getCustId());
			return "redirect:/api/showOrder";
		} else {
			// show order form with marked invalid items
			redirectAttributes.addAttribute("orderId", "-1");
			return "redirect:/api/addorder";
		}
	}

	@GetMapping("/showOrder")
	public ModelAndView showOrder(@RequestParam(required = false) final String orderId) {

		ModelAndView mav = new ModelAndView("view-order");
		this.myOrderItems.setCustomername(customerService.GetCustomerByID(this.myOrderItems.getCustId()).getCustname());
		mav.addObject("myorderitems", this.myOrderItems);
		return mav;

	}

// LOGINS...
	@GetMapping(value = { "/login", "/" })
	public ModelAndView LoginForm() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView LogoutForm() {
		ModelAndView mav = new ModelAndView("logout");
		return mav;
	}

}
