package edu.danib.flickrapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import edu.danib.boilerplate.R;

public class FlickrDetailActivity extends Activity {
	
	private ImageView flickrImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flickr_detail);
		findAllViewsById();
		loadFlickrImage();
	}

	private void loadFlickrImage() {
		String flickrImageUrl = getIntent().getStringExtra(ExtraKeys.FLICKR_IMAGE_URL);
		Log.i(FlickrDetailActivity.class.toString(), "Received image url: " + flickrImageUrl);
		UrlImageViewHelper.setUrlDrawable(flickrImageView, flickrImageUrl, R.drawable.loading);
	}

	private void findAllViewsById() {
		flickrImageView = (ImageView) findViewById(R.id.flickrImageView);		
	}
	
}
