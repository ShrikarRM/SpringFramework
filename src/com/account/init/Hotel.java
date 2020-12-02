package com.account.init;

public class Hotel {
private String name;
private boolean type;
private String location;

public Hotel() {
System.out.println(this.getClass().getSimpleName()+ " created");
}

public Hotel(String name) {
System.out.println(this.name=name);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isType() {
	return type;
}

public void setType(boolean type) {
	this.type = type;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}


}
