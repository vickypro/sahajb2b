package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.Item;
import sahaj.model.master.Sector;
import sahaj.model.master.State;
import sahaj.service.master.ItemService;
import sahaj.service.master.SectorService;
import sahaj.service.master.StateService;
import sahaj.serviceimpl.master.StateServiceImpl;

@Controller
public class StateController {

	@RequestMapping(value = "/getStateList", method = RequestMethod.GET)
	public @ResponseBody List getStateList (ModelMap model) {
		StateServiceImpl stateServiceimpl = new StateServiceImpl();
		 List<State> getStateList = stateServiceimpl.getStateList();
		return getStateList;
	}
	
	@RequestMapping(value = "/saveState", method = RequestMethod.POST)
	public @ResponseBody State saveState (@RequestBody State state) {
		System.out.println("IN State controller==========="+state.toString());
		StateServiceImpl stateServiceimpl=new StateServiceImpl();
		stateServiceimpl.saveState(state);
		return state;
	}
	
	@RequestMapping(value = "/getStateDetails", method = RequestMethod.POST)
	public @ResponseBody State getStateDetails (@RequestBody int stateId) {
		StateServiceImpl stateServiceimpl=new StateServiceImpl();
		State state = stateServiceimpl.getStateDetails(stateId);
		return state;
	}
	
	@RequestMapping(value = "/updateState", method = RequestMethod.POST)
	public @ResponseBody int updateState (@RequestBody State state) {
		StateServiceImpl stateServiceimpl=new StateServiceImpl();
		int result = stateServiceimpl.updateState(state);
		return result;
	}
	
	@RequestMapping(value = "/deleteState", method = RequestMethod.POST)
	public @ResponseBody int deleteState (@RequestBody int stateId) {
		StateServiceImpl stateServiceimpl=new StateServiceImpl();
		int result = stateServiceimpl.deleteState(stateId);
		return result;
	}
	
}
