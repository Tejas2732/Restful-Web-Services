package com.tejaspatil.rest.webservices.restful_web_services.helloworld;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
// Rest-Api
@RestController
public class HelloWorldController {
	private MessageSource  messageSource;
	
	public HelloWorldController( MessageSource  messageSource) {
		this.messageSource= messageSource;
	}
	
@GetMapping(path="Hello-World")
	public String helloWorld() {
		return"Tejas Patil";
	}

@GetMapping(path="Hello-World-Bean")
public HelloworldBean helloWorldBean() {
	return new HelloworldBean("The King");
}


@GetMapping(path="Hello-World/Path-Variable/{name}")
public HelloworldBean helloWorldPathVariable(@PathVariable String  name) {
	return new HelloworldBean(String.format(" Tejas Path Variable, %s ", name));
}
 
@GetMapping(path="Hello-World-Internationalized")
public String helloWorldInternationalized() {
	Locale locale = LocaleContextHolder.getLocale();
  return messageSource.getMessage("good.morning.message", null, "Default Message",locale);
	//return"Hello World V2";
}

}