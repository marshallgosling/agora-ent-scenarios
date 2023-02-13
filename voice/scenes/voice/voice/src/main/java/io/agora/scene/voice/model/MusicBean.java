package io.agora.scene.voice.model;

import java.io.Serializable;

public class MusicBean implements Serializable {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    private Boolean selected;

    public MusicBean() {
        this.selected = false;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    public MusicBean(String url) {
        this.url = url;
        this.selected = false;
        this.position = 0;
    }

}
