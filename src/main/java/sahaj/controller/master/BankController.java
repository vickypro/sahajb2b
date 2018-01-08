/**
 * 
 */
package sahaj.controller.master;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.Bank;
import sahaj.serviceimpl.master.BankServiceImpl;

/**
 * @author Amit
 *
 */
@Controller
public class BankController {

	@RequestMapping(value = "/getBankList", method = RequestMethod.GET)
	public @ResponseBody List getBankList(ModelMap model) {
		BankServiceImpl bankService = new BankServiceImpl();
		List<Bank> bankList = bankService.getBankList();
		return bankList;
	}
	
	@RequestMapping(value = "/saveBank", method = RequestMethod.POST)
	public @ResponseBody int saveBank (@RequestBody Bank bank) {
		BankServiceImpl bankService = new BankServiceImpl();
		int returnValue = bankService.saveBank(bank);
		return returnValue;
	}
	
	@RequestMapping(value = "/getBankDetails", method = RequestMethod.POST)
	public @ResponseBody Bank getBankDetails (@RequestBody int bankId) {
		BankServiceImpl bankService = new BankServiceImpl();
		Bank bank = bankService.getBankDetails(bankId);
		return bank;
	}
	
	@RequestMapping(value = "/updateBank", method = RequestMethod.POST)
	public @ResponseBody int updateBank (@RequestBody Bank bank) {
		BankServiceImpl bankService = new BankServiceImpl();
		int returnValue = bankService.updateBank(bank);
		return returnValue;
	}
}
