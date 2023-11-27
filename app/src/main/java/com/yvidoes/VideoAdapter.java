package com.yvidoes;

// VideoAdapter.java
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private Cursor cursor;
    private Context context;

    public VideoAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder holder, int position) {
        if (cursor.moveToPosition(position)) {
            final String videoUri = cursor.getString(cursor.getColumnIndexOrThrow(dbhelper.VIDEOS_URI));
            //String videoName = cursor.getString(cursor.getColumnIndexOrThrow(dbhelper.VIDEOS_NAME));

            //   holder.editTextVideoName.setText(videoName);
            holder.textViewVideoUri.setText(videoUri);

            // Set up click listener for the Play button
            holder.btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playVideo(videoUri);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }

    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged();
    }

    private void playVideo(String videoUri) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUri));
            intent.setDataAndType(Uri.parse(videoUri), "video/*");
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "Error playing video", Toast.LENGTH_SHORT).show();
        }
    }
}
