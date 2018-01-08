package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.TransporterType;
import sahaj.serviceimpl.master.TransporterTypeServiceImpl;

@Controller
public class TransporterTypeController {

	@RequestMapping(value = "/getTransporterTypeList", method = RequestMethod.GET)
	public @ResponseBody List getTransporterTypeList(ModelMap model) {
		TransporterTypeServiceImpl transporterTypeService = new TransporterTypeServiceImpl();
		List<TransporterType> transporterTypeList = transporterTypeService.getTransporterTypeList();
		return transporterTypeList;
	}
	
	@RequestMapping(value = "/saveTransporterType", method = RequestMethod.POST)
	public @ResponseBody int saveTransporterType(@RequestBody TransporterType transporterType) {
		int returnValue = 0;
		try {

			TransporterTypeServiceImpl transporterTypeService = new TransporterTypeServiceImpl();
			returnValue = transporterTypeService.saveTransporterType(transporterType);
		} catch (Exception e) {
			returnValue = 0;
		}
		return returnValue;
	}
	
	@RequestMapping(value = "/getTransporterTypeDetails", method = RequestMethod.POST)
	public @ResponseBody TransporterType getTransporterTypeDetails(@RequestBody int transporterTypeId) {
		TransporterTypeServiceImpl transporterTypeService = new TransporterTypeServiceImpl();
		TransporterType transporterType = transporterTypeService.getTransporterTypeDetails(transporterTypeId);
		return transporterType;
	}

	@RequestMapping(value = "/updateTransporterType", method = RequestMethod.POST)
	public @ResponseBody int updateTransporterType(@RequestBody TransporterType transporterType) {
		int returnValue = 0;
		try {
			TransporterTypeServiceImpl transporterTypeService = new TransporterTypeServiceImpl();
			returnValue = transporterTypeService.updateTransporterType(transporterType);
		} catch (Exception e) {
			returnValue = 0;
		}
		return returnValue;
	}
}
