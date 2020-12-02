package com.account.init;

public class Monitor {
	private int height;
	private int width;
	private String modelNo;
	private String mfgDate;

	public Monitor(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		System.out.println("monitor is having dimension " + this.height + " ," + this.width);
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

}
