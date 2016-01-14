package com.practice.algorithms.core.designpatterns.structural.adapter.player;

import org.apache.log4j.Logger;

public class AviPlayer implements IAdvancedMediaPlayer
{

    private static Logger log = Logger.getLogger(AviPlayer.class);

    @Override
    public void playAvi() {

        log.info("AviPlayer.play  -  Playing avi file !!");
    }

    @Override
    public void playMp4() {

    }

}
