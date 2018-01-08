package sahaj.controller.master;

import java.util.List;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.CustomerCategory;
//import sahaj.model.master.Van;
import sahaj.model.master.Van;
import sahaj.service.master.VanService;
import sahaj.serviceimpl.master.CustomerCategoryServiceImpl;

@Controller
public class VanController {
	
	@RequestMapping(value = "/getVanList", method = RequestMethod.GET)
	public @ResponseBody List getVanList () {
	
		VanService vanService=new VanService();
		 List<Van> getVanList = vanService.getVanList();
		 System.out.println("x");
  	 
 
		return getVanList;
	}

	@RequestMapping(value = "/saveVan", method = RequestMethod.POST)
	public @ResponseBody Van saveVan (@RequestBody Van  van) {
		 
		VanService vanService=new VanService();
		vanService.saveVan(van);
		return van;
	}
	
	@RequestMapping(value = "/getVanDetails", method = RequestMethod.POST)
	public @ResponseBody Van  getVanDetails (@RequestBody String  vanId) {
	
		VanService vanService=new VanService();
		Van van = vanService.getVanDetails(vanId);;
		System.out.println("desc:"+van.getDescripton());
		System.out.println("capacity"+van.getVanCapacity());
		return van;
	}
	
	@RequestMapping(value = "/updateVan", method = RequestMethod.POST)
	public @ResponseBody Van updateVan (@RequestBody Van van) {
		System.out.println("update");

		VanService vanService=new VanService();
		vanService.updateVan(van);
		return van;
	}
	
	@RequestMapping(value = "/deleteVan", method = RequestMethod.POST)
	public @ResponseBody List<Van> deleteVan (@RequestBody String vanId) {
            System.out.println("dta:"+vanId);
		VanService vanService=new VanService();
		vanService.deleteVan(vanId);
		 List<Van> getVanList = vanService.getVanList();
		return getVanList;
	}
	
	
	
}