package edu.danib.flickrapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import edu.danib.flickrapp.model.SearchResult;

public class FlickrListItemClickListener implements OnItemClickListener {
	
	private Activity parentActivity;
	
	public FlickrListItemClickListener(Activity parentActivity) {
		super();
		this.parentActivity = parentActivity;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = createFlickrDetailIntent(parent, position);
		parentActivity.startActivity(intent);
	}

	private Intent createFlickrDetailIntent(AdapterView<?> parent, int position) {
		Intent intent = new Intent(parentActivity, FlickrDetailActivity.class);
		SearchResult selectedItem = (SearchResult) parent.getItemAtPosition(position);
		intent.putExtra(ExtraKeys.FLICKR_IMAGE_URL, selectedItem.getImgUrl());
		return intent;
	}

}
