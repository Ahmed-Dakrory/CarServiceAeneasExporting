package main.com.carService.carLanding;

public enum categoriesEnum {

	SMALLCARS("SMALL CARS","SMALL CARS"),SUV("SUV","SUV"),
	MotorCycle("MotorCycles","MotorCycles"),JetSkies("JetSkies","JetSkies"),
	SnowMobile("Snow Mobile","Snow Mobile"),HeavyDuties("Heavy Duties","Heavy Duties");
	
	categoriesEnum(String type,String name){
		this.type=type;
		this.name=name;
	}
	
	String type="";
	
	String name="";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
