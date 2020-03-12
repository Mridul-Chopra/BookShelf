package net.paxcel.bookshelf.test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import net.paxcel.bookshelf.controller.SignUpController;
import net.paxcel.bookshelf.service.SignUpService;

public class ControllerTests {

	@InjectMocks
	SignUpController controller;

	@Mock
	SignUpService signup;
	
	
	@Before
	public void before()
	{
		
	}

	@Test
	public void postSignupTest() throws Exception {
				
		//signup = Mockito.mock(SignUpService.class);
		
		MockitoAnnotations.initMocks(this);

		String email ="test@test.com";
		String password = "123456";
		String hashedPassword = "$2a$10$sqISCkABLBHcbZknBgVAhOd8oQoRaon6tn0rsAltqQ6q9dnGE4J26";
		String address = "qwerty";
		
		when(signup.signup(email, hashedPassword, address)).thenReturn(new String("mocked res"));
		System.out.println(signup.signup(email, password, address));

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();

		mockMvc.perform(post("/signup").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("email", email).param("password", password).param("address", address))

				.andExpect(model().attribute("userForm", hasProperty("email", is(email))))
				.andExpect(model().attribute("userForm", hasProperty("address", is(address))))
				.andExpect(model().attribute("message", is("mocked res")))
				.andExpect(status().isOk()).andExpect(forwardedUrl("/WEB-INF/views/signup.jsp"));

	}
}
