package com.sung.digital.bean;

import java.util.Random;

/**
 * Created by sung on 2018/5/4.
 */

public class HomeMultiListItemModel {
    public int mode;

    public HomeMultiListItemModel() {
        mode = new Random().nextInt(3);
    }
}
