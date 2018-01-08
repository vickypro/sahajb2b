package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.Customer;
import sahaj.model.master.District;
import sahaj.model.master.Magazine;
import sahaj.model.master.Route;
import sahaj.serviceimpl.master.CustomerServiceImpl;
import sahaj.serviceimpl.master.RouteServiceImpl;

@Controller
public class RouteController {

	@RequestMapping(value = "/getRouteList", method = RequestMethod.GET)
	public @ResponseBody List getRouteList(ModelMap model) {
		RouteServiceImpl routeService = new RouteServiceImpl();
		List<Route> routeList = routeService.getRouteList();
		return routeList;
	}
	
	@RequestMapping(value = "/getDistrictId", method = RequestMethod.GET)
	public @ResponseBody District getDistrictId (Model model) {
		RouteServiceImpl routeService = new RouteServiceImpl();
		District district = routeService.getDistrictId();
		return district;
	}
	
	@RequestMapping(value = "/getMagazineListForCustomer", method = RequestMethod.POST)
	public @ResponseBody List getMagazineListForCustomer(@RequestBody int customerId) {
		RouteServiceImpl routeService = new RouteServiceImpl();
		List<Magazine> magazineList = routeService.getMagazineListForCustomer(customerId);
		return magazineList;
	}
	
	@RequestMapping(value = "/saveRoute", method = RequestMethod.POST)
	public @ResponseBody Route saveRoute(@RequestBody Route route) {
		
		try {
			RouteServiceImpl routeService = new RouteServiceImpl();
			routeService.saveRoute(route);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return route;
	}
	
	@RequestMapping(value = "/getRouteDetails", method = RequestMethod.POST)
	public @ResponseBody Route getRouteDetails (@RequestBody int routeId) {
		RouteServiceImpl routeService = new RouteServiceImpl();
		Route route = routeService.getRouteDetails(routeId);
		return route;
	}
	
	@RequestMapping(value = "/updateRoute", method = RequestMethod.POST)
	public @ResponseBody Route updateRoute (@RequestBody Route route) {
		RouteServiceImpl routeService = new RouteServiceImpl();
		routeService.updateRoute(route);
		return route;
	}
}
