package com.account.jc;

import org.springframework.stereotype.Component;

@Component("annotate")
public class Speaker {
	public Speaker() {
		System.out.println("created " + this.getClass().getSimpleName());
	}
}
