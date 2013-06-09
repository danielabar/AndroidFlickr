package edu.danib.flickrapp.component;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

public class FlickrItemLongClickListener implements OnItemLongClickListener {
	
	private Activity parentActivity;
	
	public FlickrItemLongClickListener(Activity parentActivity) {
		super();
		this.parentActivity = parentActivity;
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");	//TODO: get text from selected item
		sendIntent.setType("text/plain");
		parentActivity.startActivity(sendIntent);
		return false;	//FIXME: Regardless of return value, going back from Messaging Intent goes to Home, not my app
	}

}
