package com.practice.algorithms.core.designpatterns.structural.adapter;

import com.practice.algorithms.core.designpatterns.structural.adapter.player.AviPlayer;
import com.practice.algorithms.core.designpatterns.structural.adapter.player.IAdvancedMediaPlayer;
import com.practice.algorithms.core.designpatterns.structural.adapter.player.IMediaPlayer;
import com.practice.algorithms.core.designpatterns.structural.adapter.player.Mp4Player;
import org.apache.log4j.Logger;

public class CoreAdapter implements IMediaPlayer
{

    private static Logger log = Logger.getLogger(CoreAdapter.class);

    private IAdvancedMediaPlayer aviPlayer;

    private IAdvancedMediaPlayer mp4Player;

    public CoreAdapter() {

        aviPlayer = new AviPlayer();
        mp4Player = new Mp4Player();

    }

    @Override
    public void play(String fileFormat) {

        if(fileFormat.equalsIgnoreCase("vlc")){

            aviPlayer.playAvi();

        } else if(fileFormat.equalsIgnoreCase("mp4")){

            mp4Player.playMp4();

        } else {

            log.info("CoreAdapter.play  -  Invalid file format passed !!");
        }

    }

}
