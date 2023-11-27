package com.yvidoes;

public class VideoItem {

    private int videoId;
    private String videoUri;
    private String videoName;

    public VideoItem(int videoId, String videoUri, String videoName) {
        this.videoId = videoId;
        this.videoUri = videoUri;
        this.videoName = videoName;
    }

    public int getVideoId() {
        return videoId;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public String getVideoName() {
        return videoName;
    }
}
