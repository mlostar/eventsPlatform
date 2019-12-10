package com.twinai.eventsplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class EventItem implements Parcelable {

	@Json(name = "image")
	private String image;

	@Json(name = "city")
	private String city;

	@Json(name = "name")
	private String name;

	@Json(name = "location")
	private String location;

	@Json(name = "url")
	private String url;

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
			return
                    getName() + "/" + getCity() +"\n" +getLocation();

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
	}
	public EventItem(Parcel parcel){
		image = parcel.readString();
		city = parcel.readString();
		name = parcel.readString();
		location = parcel.readString();
		url = parcel.readString();
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