package test;

import java.util.List;

public class BakeryItems {

	private int id;
	private String type;
	private String name;
	private double ppu;
	private List<Batter> batter;
	private List<Topping> topping;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getPPU() {
		return ppu;
	}
	
	public void setPPU(double ppu) {
		this.ppu=ppu;
	}
	
	
	public List<Batter> getBatter() {
		return batter;
	}
	
	public void setBatter(List<Batter> batter) {
		this.batter=batter;
	}
	
	
	public List<Topping> getTopping() {
		return topping;
	}
	
	public void setTopping(List<Topping> topping) {
		this.topping=topping;
	}
	
	
	
}
