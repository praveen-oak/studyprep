package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.structural.adapter.player.AudioPlayer;
import com.practice.algorithms.core.designpatterns.structural.adapter.player.IMediaPlayer;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Adapter implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Adapter.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Adapter.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        IMediaPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3");
        audioPlayer.play("vlc");
        audioPlayer.play("mp4");
        audioPlayer.play("vlc_c");

        return "Check logs for the output !!";
    }
}
