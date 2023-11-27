package com.yvidoes;

// VideoViewHolder.java
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

 //   public EditText editTextVideoName;
    public TextView textViewVideoUri;
    public ImageButton btnPlay;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
      //  editTextVideoName = itemView.findViewById(R.id.editTextVideoName);
        textViewVideoUri = itemView.findViewById(R.id.textViewVideoUri);
        btnPlay = itemView.findViewById(R.id.btnPlay);
    }
}

