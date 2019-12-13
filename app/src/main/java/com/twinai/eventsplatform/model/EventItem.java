package com.twinai.eventsplatform.model;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class EventItem implements Parcelable{

	@Json(name = "date")
	private String date;

	@Json(name = "image")
	private String image;

	@Json(name = "city")
	private String city;

	@Json(name = "name")
	private String name;

	@Json(name = "description")
	private String description;

	@Json(name = "location")
	private String location;

	@Json(name = "type_")
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
				"EventItem{" +
						"image = '" + image + '\'' +
						",city = '" + city + '\'' +
						",name = '" + name + '\'' +
						",location = '" + location + '\'' +
						",url = '" + url + '\'' +
						"}";
	}
	public String getText(){
		if(getName() == null)setName("");

		if(getCity() == null)setCity("");

		if(getDate() == null)setDate("");

		if(getType() == null)setType("");

		return
				getName() + " " + getCity() +"\n" +getDate() + " " +getType();

	}
	public String getContent(){

		if(getLocation() == null)setLocation("");

		if(getDescription() == null)setDescription("");

		return getLocation() + "\n" + getDescription();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(image);
		parcel.writeString(city);
		parcel.writeString(name);
		parcel.writeString(location);
		parcel.writeString(url);
		parcel.writeString(description);
		parcel.writeString(date);
		parcel.writeString(type);
	}
	public EventItem(Parcel parcel){
		image = parcel.readString();
		city = parcel.readString();
		name = parcel.readString();
		location = parcel.readString();
		url = parcel.readString();
		description = parcel.readString();
		date = parcel.readString();
		type = parcel.readString();
	}
	public static final Parcelable.Creator<EventItem> CREATOR = new Parcelable.Creator<EventItem>(){

		@Override
		public EventItem createFromParcel(Parcel parcel) {
			return new EventItem(parcel);
		}

		@Override
		public EventItem[] newArray(int size) {
			return new EventItem[0];
		}
	};


}