package io.agora.scene.voice.ui.widget.music;

import android.view.View;

import io.agora.scene.voice.model.MusicBean;

public interface OnMusicClickListener {
  void SelectMusic(View view, MusicBean bean, int index);
}
