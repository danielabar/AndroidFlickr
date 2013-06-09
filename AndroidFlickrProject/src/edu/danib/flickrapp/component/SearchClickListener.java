package edu.danib.flickrapp.component;

import edu.danib.flickrapp.MainActivity;
import edu.danib.flickrapp.task.SearchTask;
import android.view.View;
import android.widget.EditText;

public class SearchClickListener implements View.OnClickListener {

    private MainActivity mainActivity;
    private EditText searchText;

    public SearchClickListener(EditText searchText, MainActivity mainActivity) {
        this.searchText = searchText;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        String query = getSearchText().getText().toString();
        new SearchTask(getMainActivity()).execute(query);
    }

    public EditText getSearchText() {
        return searchText;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

}
