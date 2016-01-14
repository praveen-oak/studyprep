package com.practice.algorithms.core.designpatterns.structural.adapter.player;

import org.apache.log4j.Logger;

public class Mp4Player implements IAdvancedMediaPlayer
{

    private static Logger log = Logger.getLogger(Mp4Player.class);

    @Override
    public void playAvi() {

    }

    @Override
    public void playMp4() {

        log.info("Mp4Player.play  -  Playing mp4 file !!");

    }

}
