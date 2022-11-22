package io.zipcoder;

import java.util.Arrays;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
        int len = playList.length;
        int closest = 0;

        for (int i = 0; i < len; i++) {
            if (playList[i].equals(selection)) {
                int gapFromBack = len - (i - startIndex); //distance of selection from back a.k.a from beginning counterclockwise
                if (selection.equals(playList[0]) || selection.equals(playList[playList.length - 1])) { //selection isnt last element or first
                    closest = Math.min((i - startIndex), gapFromBack);
                }
            }
        }

        return closest;

        //return null;
    }
}
