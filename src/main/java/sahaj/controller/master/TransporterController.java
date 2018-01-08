package sahaj.controller.master;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sahaj.model.master.Transporter;

import sahaj.service.master.TransporterService;


@Controller
public class TransporterController {


	@RequestMapping(value = "/saveTransporter", method = RequestMethod.POST)
	public @ResponseBody Transporter saveTransporter (@RequestBody Transporter transporter) {
		TransporterService tr=new TransporterService();
		tr.saveTransporterService(transporter);
		return transporter;
		
	}
	@RequestMapping(value = "/getTransporterList", method = RequestMethod.GET)
	public @ResponseBody List getTransporterList ()  {
		TransporterService tr=new TransporterService();
		
		List<Transporter> transporter = tr.getTransporterList();
		//tr.sendEmail();
		return transporter;
	}
	@RequestMapping(value = "/getTransporterDetails", method = RequestMethod.POST)
	public @ResponseBody Transporter getTransporterDetails (@RequestBody int partyCode) {
		TransporterService transporterService=new TransporterService();
		Transporter transporter =transporterService.getTransporterDetails(partyCode);
		 return transporter;
	}

	@RequestMapping(value = "/newTransporter", method = RequestMethod.POST)
	public @ResponseBody Transporter newAgency () {
		TransporterService transporterService=new TransporterService();
		Transporter transporter =transporterService.NewTransporter();
		return transporter;
	}
	@RequestMapping(value = "/updateTransporter", method = RequestMethod.POST)
	public @ResponseBody Transporter updateTransporter (@RequestBody Transporter transporter) {
		TransporterService transporterService=new TransporterService();
		transporterService.updateTransporter(transporter);
		return transporter;
	}
	@RequestMapping(value = "/deleteTransporter", method = RequestMethod.POST)
	public @ResponseBody List<Transporter> deleteTransporter(@RequestBody int partyCode) {
		
		TransporterService transporterService=new TransporterService();
		transporterService.deleteTransporter(partyCode);;
		List<Transporter> transporter =  transporterService.getTransporterList();
		return transporter;
	}
	@RequestMapping(value = "/SendMail", method = RequestMethod.GET)
	public  void sendMail () throws AddressException, MessagingException  {
		TransporterService tr=new TransporterService();
		tr.sendMail();
		System.out.println("mail");
		
		
	}
	
}

