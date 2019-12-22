package com.twinai.eventsplatform.model;

import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class EventItemModel{

	@Json(name = "date")
	private String date;

	@Json(name = "image")
	private String image;

	@Json(name = "city")
	private String city;

	@Json(name = "name")
	private String name;

	@Json(name = "location")
	private String location;

	@Json(name = "id")
	private int id;

	@Json(name = "type")
	private String type;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"EventItemModel{" + 
			"date = '" + date + '\'' + 
			",image = '" + image + '\'' + 
			",city = '" + city + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
	public String getText(){
		if(getName() == null)setName("");

		if(getCity() == null)setCity("");

		if(getDate() == null)setDate("");

		if(getType() == null)setType("");

		return
				getName() + "\n" + getCity() +" " +getDate() + " " +getType();

	}
}