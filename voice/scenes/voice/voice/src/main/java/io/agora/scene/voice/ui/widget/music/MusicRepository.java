package io.agora.scene.voice.ui.widget.music;

import android.content.Context;
import android.text.TextUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.agora.scene.voice.model.GiftBean;
import io.agora.scene.voice.model.MusicBean;

/**
 * 用于获取本地礼物信息
 */
public class MusicRepository {
    static int SIZE = 9;
    public static String [] Urls = {
            "/assets/3.aac",
            "/assets/Also_sprach_Zarathustra.mp3",
            "/assets/Never_Gonna_Give_You_Up.mp3"
    };

    public static List<MusicBean> musics;

    public static List<MusicBean> getDefaultMusics() {

        if (musics != null) return musics;
        musics = new ArrayList<>();
        MusicBean bean;
        for(int i = 0; i < Urls.length; i++){
            bean = new MusicBean(Urls[i]);
            if (i==1) bean.setPosition(40000);
            musics.add(bean);
        }
        return musics;
    }

    public static int volume = 50;

}
