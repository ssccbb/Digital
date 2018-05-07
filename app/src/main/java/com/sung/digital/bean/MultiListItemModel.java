package com.sung.digital.bean;

import java.util.Random;

/**
 * Created by sung on 2018/5/4.
 */

public class MultiListItemModel {
    public int mode;

    public MultiListItemModel() {
        mode = new Random().nextInt(3);
    }
}
