package com.tap.util;
import java.util.List;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.DAOimpl.RestaurantDAOimpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

public class App {

	public static void main(String[] args) {
		
//		User u1 = new User("Bob", "bob@gmail.com", "bob@123", "6386543213", "HSR Layout", "Customer");
		
//		UserDAOimpl  u = new UserDAOimpl();
		
//		u.addUser(u1);
//		User user= u.getUser(1);
		
		
//		System.out.println(user.getEmail());
//		user.setEmail("alex123@gmail.com");
//		System.out.println(user.getEmail());
//		
//		u.updateUser(user);
//		System.out.println("Updated");
		
//		u.deleteUser(1);
//		System.out.println("Deleted");
		
//		List<User> allUser = u.getAllUser();
//		
//		for(User x: allUser)
//			System.out.println(x);
		
//		Restaurant r = new Restaurant("Rameswaram Cafe", "South Indan",
//				new Timestamp(System.currentTimeMillis()),"Rajajinagar", 1, 4.9, 1);
		
//		RestaurantDAOimpl rest = new RestaurantDAOimpl();
		
//		rest.addRestaurant(r);
		
		
//		List<Restaurant> allRestaurant = rest.getAllRestaurant();
//		
//		for(Restaurant x: allRestaurant)
//			System.out.println(x);
		
//		Menu m1 = new Menu(1, "idli", "2 nos idli", 25.00, 1, "Breakfast");
//		MenuDAOimpl m = new MenuDAOimpl();
		
//		m.addMenu(m1);
		
//		List<Menu> allMenu = m.getAllMenu();
//		
//		for(Menu x: allMenu)
//				System.out.println(x);
		
		MenuDAOimpl Menudao = new MenuDAOimpl();
		List<Menu> menuList = Menudao.getMenuByRestaurantId(2);
		
		for(Menu menu: menuList) {
			System.out.println(menu.getItemName() +" : "+ menu.getPrice());
		}
		
//		OrderTableDAOimpl ot = new OrderTableDAOimpl();
//		OrderTable order1 = new OrderTable(1, 1, 750.00, "Delivered", "UPI");
//		
////		ot.addOrderTable(order1);
//		
//		List<OrderTable> allOT = ot.getAllOrderTable();
//		
//		for(OrderTable o: allOT)
//				System.out.println(o);
		
	}

}
