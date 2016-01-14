package com.practice.algorithms.core.designpatterns.structural.adapter.player;

import com.practice.algorithms.core.designpatterns.structural.adapter.CoreAdapter;
import org.apache.log4j.Logger;

public class AudioPlayer implements IMediaPlayer
{

    private static Logger log = Logger.getLogger(AudioPlayer.class);

    private IMediaPlayer adapter;

    public AudioPlayer() {

        adapter = new CoreAdapter();
    }

    @Override
    public void play(String fileFormat) {

        if (fileFormat.equalsIgnoreCase("mp3")) {

            log.info("AudioPlayer.play  -  Playing mp3 file !!");

        } else {

            adapter.play(fileFormat);

        }

    }

}
