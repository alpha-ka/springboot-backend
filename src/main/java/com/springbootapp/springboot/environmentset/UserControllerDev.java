package com.springbootapp.springboot.environmentset;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value="dev")

public class UserControllerDev implements UserConInterface {

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "From Development";
	}

}
