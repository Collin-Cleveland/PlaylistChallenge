package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
//        int len = playList.length;
//        int gap = 0;
//
//        for (int i = 0; i < len; i++) {
//            if (playList[i].equals(selection)) {
//                gap = len - (i - startIndex);
//                //distance of selection from back a.k.a from beginning counterclockwise
//                if (selection.equals(playList[0]) || selection.equals(playList[playList.length - 1])) {
//                    //selection isnt last element or first
//                    gap = Math.min((i - startIndex), gap);
//                }
//            }
//        }
//
//        return gap;

        Integer smallestGap = 0;

            ArrayList<String> forward = new ArrayList<String>();
            for (int i = startIndex; i < playList.length; i++) {
                forward.add(playList[i]);
            }
            for (int j = 0; j < startIndex; j++) {
                forward.add(playList[j]);

            }
            Integer forwardCount = calculateCount(forward, selection);


            ArrayList<String> backward = new ArrayList<String>();
            for (int i = startIndex; i >= 0; i--) {
                backward.add(playList[i]);
            }
            for (int j = playList.length - 1; j > startIndex; j--) {
                backward.add(playList[j]);
            }
            Integer backwardCount = calculateCount(backward, selection);


            if (forwardCount < backwardCount) {
                smallestGap = forwardCount;
            } else if (forwardCount > backwardCount) {
                smallestGap = backwardCount;
            } else if (forwardCount == backwardCount) {
                smallestGap = forwardCount;
            }

            return smallestGap;
        }

        public Integer calculateCount(ArrayList<String> arrayList, String selection) {
            int count = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                String compare = arrayList.get(i);
                if (compare.equals(selection)) {
                    break;
                } else {
                    count += 1;
                }
            }
            return count;

        //return null;
    }
}
