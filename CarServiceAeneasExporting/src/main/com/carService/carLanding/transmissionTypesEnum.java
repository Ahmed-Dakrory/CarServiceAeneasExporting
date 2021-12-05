package main.com.carService.carLanding;

public enum transmissionTypesEnum {

	AUTOMATIC(0,"AUTOMATIC"),
	MANUAL(1,"MANUAL"),
	STEPTORNIC(2,"STEPTORNIC");
	
	int type=0;
	
	String name="";
	
	private transmissionTypesEnum(int type,String name) {
		// TODO Auto-generated constructor stub
		this.type=type;
		this.name=name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
