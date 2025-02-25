package com.example.maciejmalak.engineerwork;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;

public class LocalizationCalculationHelper {

	public static LatLng geoPointFromLocalization(Location loc){
		double latitude = loc.getLatitude();
		double longitude =  loc.getLongitude();
		LatLng here = new LatLng(latitude, longitude);
		return here;
	}
	
	public static Location LocalizationFromGeopoint(LatLng pos){
		double latitude = pos.latitude;
		double longitude = pos.longitude;
		Location here = new Location("");
		here.setLatitude(latitude);
		here.setLongitude(longitude);
		return here;
	}
}
