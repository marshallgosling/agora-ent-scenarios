package io.agora.scene.voice.ui.widget.music;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.agora.scene.voice.R;
import io.agora.scene.voice.databinding.VoiceDialogMusicLayoutBinding;
import io.agora.scene.voice.model.MusicBean;
import io.agora.scene.voice.rtckit.AgoraRtcEngineController;
import io.agora.voice.common.ui.dialog.BaseSheetDialog;

public class MusicBottomDialog extends BaseSheetDialog<VoiceDialogMusicLayoutBinding> implements View.OnClickListener {
    private int currentIndex = 0;//当前页面,默认首页
    //private GiftFragmentAdapter adapter;
    private OnMusicClickListener listener;
    //private List<GiftBean> list;
    //private int GiftNum = 1;
    //private GiftBean giftBean;
    private VoiceDialogMusicLayoutBinding binding;
    private List<MusicBean> list;
    private int volume = 50;
    public static MusicBottomDialog getNewInstance() {
        return new MusicBottomDialog();
    }

    @Nullable
    @Override
    protected VoiceDialogMusicLayoutBinding getViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return VoiceDialogMusicLayoutBinding.inflate(inflater, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getBinding() != null)
            binding = getBinding();
        setOnApplyWindowInsets(binding.getRoot());
        initData();
        initView();
        initListener();

    }

    public void initView() {
        check();
    }

    public void initData() {
        if (list == null)
            list = MusicRepository.getDefaultMusics();
        volume = MusicRepository.volume;
    }

    public void initListener() {
        binding.mtMusic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    reset(0);
//                    listener.SelectMusic(view, list.get(0), 0);
                    mixMusic(0);
                    check();
                }
            }
        });
        binding.mtMusic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    reset(1);
//                    listener.SelectMusic(view, list.get(1), 1);
                    mixMusic(1);
                    check();
                }
            }
        });
        binding.mtMusic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    reset(2);
                    //listener.SelectMusic(view, list.get(2), 2);
                    mixMusic(2);
                    check();
                }
            }
        });

        binding.pbAgoraMixerVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.mtAgoraMusicVolumeValue.setText(""+seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                volume = seekBar.getProgress();
                AgoraRtcEngineController.get().updateMixerVolume(volume);
                MusicRepository.volume = volume;
            }
        });

    }

    public void setOnConfirmClickListener(OnMusicClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

    }

    public void check()
    {
        binding.mtAgoraMusicVolumeValue.setText(""+volume);
        binding.pbAgoraMixerVolume.setProgress(volume);
        binding.mtMusicIcon1.setVisibility(list.get(0).getSelected()?View.VISIBLE:View.INVISIBLE);
        binding.mtMusicIcon2.setVisibility(list.get(1).getSelected()?View.VISIBLE:View.INVISIBLE);
        binding.mtMusicIcon3.setVisibility(list.get(2).getSelected()?View.VISIBLE:View.INVISIBLE);
    }

    public void mixMusic(int index)
    {
        MusicBean bean = list.get(index);
        String filePath = bean.getUrl();

        if(bean.getSelected()) {
            bean.setSelected(false);
            AgoraRtcEngineController.get().stopMixerMusic();
        }
        else {
            bean.setSelected(true);

            AgoraRtcEngineController.get().mixerMusic(filePath, false, -1, bean.getPosition(), volume);
        }
    }

    public void reset(int index)
    {
        for(int i=0;i<list.size();i++)
        {
            if(i!=index)
                list.get(i).setSelected(false);
        }
    }

}