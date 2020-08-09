package com.aga.spring.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private LinkedHashMap<String, String> countryOptions;
	private ArrayList<String> favoriteLanguageArray;
	private ArrayList<String> operatingSystemArray;
	
	public StudentController() {
		
		//set country names
		countryOptions = new LinkedHashMap<>();	
		countryOptions.put(CountryCode.ALBANIA.getCountryCodeA2(), CountryCode.ALBANIA.getCountryName());
		countryOptions.put(CountryCode.FRANCE.getCountryCodeA2(), CountryCode.FRANCE.getCountryName());
		countryOptions.put(CountryCode.BRAZIL.getCountryCodeA2(), CountryCode.BRAZIL.getCountryName());
		countryOptions.put(CountryCode.TURKEY.getCountryCodeA2(), CountryCode.TURKEY.getCountryName());
		countryOptions.put(CountryCode.NETHERLANDS.getCountryCodeA2(), CountryCode.NETHERLANDS.getCountryName());
		
		//set favorite languages
		favoriteLanguageArray = new ArrayList<>();
		favoriteLanguageArray.add(FavoriteLanguage.C_SHARP.getLangName());
		favoriteLanguageArray.add(FavoriteLanguage.JAVA.getLangName());
		favoriteLanguageArray.add(FavoriteLanguage.JAVASCRIPT.getLangName());
		favoriteLanguageArray.add(FavoriteLanguage.PHP.getLangName());
		favoriteLanguageArray.add(FavoriteLanguage.PYTHON.getLangName());
		favoriteLanguageArray.add(FavoriteLanguage.RUBY.getLangName());
		
		//set OS names
		operatingSystemArray = new ArrayList<>();
		operatingSystemArray.add(ExperiencedOS.LINUX.getOsName());
		operatingSystemArray.add(ExperiencedOS.MACOS.getOsName());
		operatingSystemArray.add(ExperiencedOS.WINDOWS.getOsName());
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create a student instance
		Student theStudent = new Student();
		//add student object to model attribute
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countryOptions", countryOptions);
		theModel.addAttribute("favoriteLanguageArray", favoriteLanguageArray);
		theModel.addAttribute("operatingSystemArray", operatingSystemArray);
		
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
