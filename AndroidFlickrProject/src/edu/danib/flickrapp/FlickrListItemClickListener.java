package edu.danib.flickrapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class FlickrListItemClickListener implements OnItemClickListener {
	
	private Activity parentActivity;
	
	public FlickrListItemClickListener(Activity parentActivity) {
		super();
		this.parentActivity = parentActivity;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent(parentActivity, FlickrDetailActivity.class);
		
		//TODO: figure it out from 'selected' value
		intent.putExtra(ExtraKeys.FLICKR_IMAGE_URL, 
				"http://islandsidechronicles.files.wordpress.com/2012/11/hello-kitty-wallpaper1.jpg");
		
		parentActivity.startActivity(intent);
	}

}
