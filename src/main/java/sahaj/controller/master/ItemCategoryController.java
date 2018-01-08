package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.ItemCategory;
import sahaj.service.master.ItemCategoryService;

@Controller

public class ItemCategoryController {
	
	@RequestMapping(value = "/getItemCategoryList", method = RequestMethod.GET)
	public @ResponseBody List getItemCategoryList (ModelMap model) {
		//System.out.println("------------------getItemCategoryList---------------------------");
		ItemCategoryService itemcategoryService = new ItemCategoryService();
		 List<ItemCategory> itemCategoryList= itemcategoryService.getItemCategoryList();
		return itemCategoryList;
	}
}
