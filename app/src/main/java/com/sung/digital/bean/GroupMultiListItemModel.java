package com.sung.digital.bean;

import java.util.Random;

/**
 * Created by sung on 2018/5/4.
 */

public class GroupMultiListItemModel {
    public int mode;

    public GroupMultiListItemModel() {
        mode = new Random().nextInt(4);
    }
}
