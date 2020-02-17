package net.paxcel.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentationController {
	
	@RequestMapping("/contents")
	public String contents()
	{
		return "contents";
	}
	
	@RequestMapping("/Introduction")
	public String introduction()
	{
		return "Introduction";
	}
	
	@RequestMapping("/feasabilityStudy")
	public String feasibiltyStudy()
	{
		return "feasabilityStudy";
	}
	@RequestMapping("/requirementAnalysis")
	public String requirementAnalysis()
	{
		return "requirementAnalysis";
	}
	@RequestMapping("/SRS")
	public String srs()
	{
		return "SRS";
	}
	@RequestMapping("/erd")
	public String erd()
	{
		return "erd";
	}
	@RequestMapping("/dfd")
	public String dfd()
	{
		return "dfd";
	}
	@RequestMapping("/testing")
	public String testing()
	{
		return "testing";
	}

}
