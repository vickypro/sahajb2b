package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.CustomerCategory;
import sahaj.model.master.Sector;
import sahaj.service.master.SectorService;
import sahaj.serviceimpl.master.CustomerCategoryServiceImpl;

@Controller
public class SectorController {
	

	@RequestMapping(value = "/getSectorList", method = RequestMethod.GET)
	public @ResponseBody List getSectorList (ModelMap model) {
		System.out.println("------------------UomController---------------------------");
		SectorService sectorService = new SectorService();
		 List<Sector> sectorList= sectorService.getSectorList();
		return sectorList;
	}
	
	@RequestMapping(value = "/saveSector", method = RequestMethod.POST)
	public @ResponseBody Sector saveSector (@RequestBody Sector sector) {
		SectorService sectorService=new SectorService();
		sectorService.saveSector(sector);
		return sector;
	}
	
	@RequestMapping(value = "/getSectorDetails", method = RequestMethod.POST)
	public @ResponseBody Sector getSectorDetails (@RequestBody int sectorId) {
		SectorService sectorService=new SectorService();
		Sector sector = sectorService.getSectorDetails(sectorId);
		return sector;
	}
	
	@RequestMapping(value = "/updateSector", method = RequestMethod.POST)
	public @ResponseBody Sector updateSector (@RequestBody Sector sector) {
		SectorService sectorService = new SectorService();
		sectorService.updateSector(sector);
		return sector;
	}
	
	@RequestMapping(value = "/deleteSector", method = RequestMethod.POST)
	public @ResponseBody int deleteSector (@RequestBody int sectorId) {
		SectorService sectorService=new SectorService();
		int result = sectorService.deleteSector(sectorId);
		return result;
	}
	

}
