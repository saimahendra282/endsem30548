package com.jfsd_lab.exp1;
import javax.persistence.*;
@Entity
public class Department {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "Location" ,nullable = false)
	private String Location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getHodName() {
		return HodName;
	}
	public void setHodName(String hodName) {
		HodName = hodName;
	}
	@Column(name = "HodName" ,nullable = false)
	private String HodName;

}
