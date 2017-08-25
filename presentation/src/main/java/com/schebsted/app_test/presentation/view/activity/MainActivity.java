package com.schebsted.app_test.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.schebsted.app_test.presentation.R;
import com.schebsted.app_test.presentation.view.activity.base.CleanActivity;
import com.schebsted.app_test.presentation.view.fragment.NotesFragment;

public class MainActivity extends CleanActivity implements NotesFragment.Listener {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new NotesFragment());
        }
    }

    @Override
    protected boolean useBackToolbar() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.getToolbar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item_settings) {
                    MainActivity.this.displaySettings();
                    return true;
                }
                return false;
            }
        });
        return true;
    }

    public void displaySettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    @Override
    public void diplayNoteCreator() {
        startActivity(new Intent(this, NoteCreateActivity.class));
    }

    @Override
    public void showNote(int noteId) {
        startActivity(NoteDetailActivity.getCallingIntent(this, noteId));
    }
}
