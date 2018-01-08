package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.District;
import sahaj.service.master.DistrictService;
import sahaj.serviceimpl.master.DistrictServiceImpl;

@Controller
public class DistrictController {

	@RequestMapping(value = "/getDistrictList", method = RequestMethod.GET)
	public @ResponseBody List getDistrictList (ModelMap model) {
		DistrictService districtService = new DistrictService();
		 List<District> districtList = districtService.getDistrictList();
		return districtList;
	}
	
	@RequestMapping(value = "/saveDistrict", method = RequestMethod.POST)
	public @ResponseBody int saveDistrict(@RequestBody District district) {
		int returnValue = 0;
		try {

			DistrictServiceImpl districtService = new DistrictServiceImpl();
			returnValue = districtService.saveDistrict(district);
		} catch (Exception e) {
			returnValue = 0;
		}
		return returnValue;
	}

	@RequestMapping(value = "/getDistrictDetails", method = RequestMethod.POST)
	public @ResponseBody District getDistrictDetails(@RequestBody int districtId) {
		DistrictServiceImpl districtService = new DistrictServiceImpl();
		District district = districtService.getDistrictDetails(districtId);
		return district;
	}

	@RequestMapping(value = "/updateDistrict", method = RequestMethod.POST)
	public @ResponseBody int updateDistrict(@RequestBody District district) {
		int returnValue = 0;
		try {
			DistrictServiceImpl districtService = new DistrictServiceImpl();
			returnValue = districtService.updateDistrict(district);
		} catch (Exception e) {
			returnValue = 0;
		}
		return returnValue;
	}
}
