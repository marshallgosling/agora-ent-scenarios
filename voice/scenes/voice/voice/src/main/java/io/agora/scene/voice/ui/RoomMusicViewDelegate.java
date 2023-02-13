package io.agora.scene.voice.ui;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import io.agora.scene.voice.imkit.custorm.OnMsgCallBack;
import io.agora.scene.voice.model.MusicBean;
import io.agora.scene.voice.ui.widget.music.OnMusicClickListener;
import io.agora.scene.voice.ui.widget.music.MusicBottomDialog;
import io.agora.scene.voice.viewmodel.VoiceRoomLivingViewModel;
import io.agora.voice.common.utils.ThreadManager;

public class RoomMusicViewDelegate {
    private FragmentActivity activity;
    private MusicBottomDialog dialog;
    private int time = 2;

    private VoiceRoomLivingViewModel roomLivingViewModel;

    RoomMusicViewDelegate(FragmentActivity activity, VoiceRoomLivingViewModel roomLivingViewModel) {
        this.activity = activity;
        this.roomLivingViewModel = roomLivingViewModel;
    }

    public static RoomMusicViewDelegate getInstance(FragmentActivity activity, VoiceRoomLivingViewModel roomLivingViewModel) {
        return new RoomMusicViewDelegate(activity, roomLivingViewModel);
    }

    public void showMusicDialog(OnMsgCallBack msgCallBack) {
        if (activity != null) {
            dialog = (MusicBottomDialog) activity.getSupportFragmentManager().findFragmentByTag("live_music");
            if (dialog == null) {
                dialog = MusicBottomDialog.getNewInstance();
            }
            dialog.show(activity.getSupportFragmentManager(), "live_music");
            dialog.setOnConfirmClickListener(new OnMusicClickListener() {
                @Override
                public void SelectMusic(View view, MusicBean bean, int index) {

                }
            });
        }
    }


    private Handler handler = new Handler();
    private Runnable task;
    private Runnable showTask;

    // 开启倒计时任务
    private void startTask() {
        handler.postDelayed(task = new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);
    }

    // 停止计时任务
    private void stopTask() {
        if (task != null) {
            handler.removeCallbacks(task);
            task = null;
            time = 2;
            //dialog.setSendEnable(true);
        }
    }

}
