package com.twinai.eventsplatform.model;

import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class EventDetailModel {

	@Json(name = "date")
	private String date;

	@Json(name = "image")
	private String image;

	@Json(name = "city")
	private String city;

	@Json(name = "org_id")
	private Object orgId;

	@Json(name = "name")
	private String name;

	@Json(name = "description")
	private String description;

	@Json(name = "location")
	private String location;

	@Json(name = "id")
	private int id;

	@Json(name = "type")
	private String type;

	@Json(name = "url")
	private String url;

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

	public void setOrgId(Object orgId){
		this.orgId = orgId;
	}

	public Object getOrgId(){
		return orgId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
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

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"EventDetailModel{" +
			"date = '" + date + '\'' + 
			",image = '" + image + '\'' + 
			",city = '" + city + '\'' + 
			",org_id = '" + orgId + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",url = '" + url + '\'' + 
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
	public String getContent(){

		if(getLocation() == null)setLocation("");

		if(getDescription() == null)setDescription("");

		return getLocation() + "\n" + getDescription();
	}
}