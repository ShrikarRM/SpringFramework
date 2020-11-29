package com.account.part;

public class Festival {
	private String name = "Deepavali";

	public Festival() {
		
		System.out.println(this.getClass().getSimpleName() +this.name+ " created");
	}
	public Festival(String name){
		this.name=name;
		System.out.println("arg1 "+name);
	}
	
	public void celebration(String celebratedBy){
		System.out.println("invoked celebration");
		System.out.println("arg 1 "+celebratedBy);
		System.out.println("Exit:: celebration");
	}
}
