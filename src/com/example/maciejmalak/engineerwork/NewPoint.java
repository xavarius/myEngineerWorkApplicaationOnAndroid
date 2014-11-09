package com.example.maciejmalak.engineerwork;

import java.util.List;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class NewPoint extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_point);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_point, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_new_point,
					container, false);
			return rootView;
		}
	}
	
	public void savePlace (View view) {
		
		EditText et = (EditText)findViewById(R.id.input_place);
		String text = et.getText().toString();
		getLocationFromAddress(text);
	}
	
	public Location getLocationFromAddress(String strAddress){

		Geocoder coder = new Geocoder(this);
		List<Address> address;
		Location currentlyAdding = new Location("New location");

		try {
		    address = coder.getFromLocationName(strAddress,5);
		    if (address == null) { return null; }
		    
		    Address location = address.get(0);
		    currentlyAdding.setLatitude(location.getLatitude());
		    currentlyAdding.setLongitude(location.getLongitude());

		    Toast.makeText(getApplicationContext(),
		    		currentlyAdding.toString() , Toast.LENGTH_SHORT)
	                .show();
		    
		    return currentlyAdding;
		} catch (Exception e) { e.printStackTrace(); 
		} finally {}
		
		return null;
	}
}
