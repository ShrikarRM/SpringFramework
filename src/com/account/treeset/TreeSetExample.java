package com.account.treeset;

import java.util.TreeSet;

public class TreeSetExample {
	private TreeSet<String> months;

	public TreeSetExample(TreeSet<String> months) {
		super();
		this.months = months;
		System.out.println(this.months);
	}

	public TreeSet<String> getMonths() {
		return months;
	}

	public void setMonths(TreeSet<String> months) {
		this.months = months;
	}

}
