package cn.edu360.javase35.day11.beans;

public class LabelBean {
	private String name;
	private String behavior;
	public void set(String name, String behavior) {
		
		this.name = name;
		this.behavior = behavior;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBehavior() {
		return behavior;
	}
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	@Override
	public String toString() {
		return "LabelBean [name=" + name + ", behavior=" + behavior + "]";
	}
	

}
