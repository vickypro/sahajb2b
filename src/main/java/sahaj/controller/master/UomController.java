package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.Uom;
import sahaj.service.master.UomService;

@Controller
public class UomController {

	@RequestMapping(value = "/getUomList", method = RequestMethod.GET)
	public @ResponseBody List getUomList(ModelMap model) {
		UomService uomService = new UomService();
		List<Uom> uomList = uomService.getUomList();
		return uomList;
	}

}
