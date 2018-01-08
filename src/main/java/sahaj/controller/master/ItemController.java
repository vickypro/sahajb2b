package sahaj.controller.master;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.CustomerCategory;
import sahaj.model.master.Item;
import sahaj.model.master.ItemSaleRate;
import sahaj.service.master.ItemService;
import sahaj.serviceimpl.master.CustomerCategoryServiceImpl;

@Controller
public class ItemController {

	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public @ResponseBody Item saveItem (@RequestBody Item item) {
		System.out.println("IN ITEM controller==========="+item.toString());
		ItemService itemService=new ItemService();
		itemService.saveItem(item);
		return item;
	}
	
	@RequestMapping(value = "/getItemNameList", method = RequestMethod.GET)
	public @ResponseBody List getItemNameList (ModelMap model) {
		System.out.println("IN ITEM controller===========");
		ItemService itemService=new ItemService();
		 List<Item> itemNameList = itemService.getItemNameList();
		return itemNameList;
	}
	
	@RequestMapping(value = "/getItemList", method = RequestMethod.GET)
	public @ResponseBody List getItemList (ModelMap model) {
	ItemService itemService=new ItemService();
	 List<Item> itemList = itemService.getItemList();
		return itemList;
	}
	
	@RequestMapping(value = "/getItemDetails", method = RequestMethod.POST)
	public @ResponseBody Item getItemDetails (@RequestBody int itemId) {
		System.out.println("IN getItemDetails controller===========");
		ItemService itemService = new ItemService();
		Item item = itemService.getItemDetails(itemId);
		return item;
	}

	
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public @ResponseBody Item updateItem (@RequestBody Item item) {
		System.out.println("IN ITEM controller==========="+item.toString());
		ItemService itemService=new ItemService();
		itemService.updateItem(item);
		return item;
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public @ResponseBody int deleteItem (@RequestBody  int itemId) {
		System.out.println("IN ITEM controller===========");
		ItemService itemService=new ItemService();
		int result = itemService.deleteItem(itemId);
		return result;
	}
	
	
}
