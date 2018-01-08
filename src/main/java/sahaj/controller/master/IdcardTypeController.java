package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.IdcardType;
import sahaj.model.master.ItemCategory;
import sahaj.service.master.ItemCategoryService;
import sahaj.serviceimpl.master.IdcardTypeServiceImpl;

@Controller
public class IdcardTypeController {

	@RequestMapping(value = "/getIdcardTypeList", method = RequestMethod.GET)
	public @ResponseBody List getIdcardTypeList(ModelMap model) {
		IdcardTypeServiceImpl idcardTypeService = new IdcardTypeServiceImpl();
		List<IdcardType> idcardTypeList = idcardTypeService.getIdcardTypeList();
		return idcardTypeList;
	}
}
