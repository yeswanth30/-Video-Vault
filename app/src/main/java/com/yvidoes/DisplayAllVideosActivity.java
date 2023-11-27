package com.yvidoes;

import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



// DisplayAllVideosActivity.java
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// DisplayAllVideosActivity.java
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DisplayAllVideosActivity extends AppCompatActivity {

    private dbhelper databaseHelper;
    private RecyclerView recyclerViewVideos;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_videos);

        recyclerViewVideos = findViewById(R.id.recyclerViewVideos);
        recyclerViewVideos.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter(this, null);
        recyclerViewVideos.setAdapter(videoAdapter);

        databaseHelper = new dbhelper(this);

        displayAllVideos();
    }

    private void displayAllVideos() {
        Cursor cursor = databaseHelper.getAllVideos();
        videoAdapter.swapCursor(cursor);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoAdapter != null) {
            videoAdapter.swapCursor(null); // Close the cursor when the activity is destroyed
        }
    }
}



