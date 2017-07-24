package org.umasankar.jpmsample.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.umasankar.jpmsample.Constants;

/**
 * Created by Umasankar on 7/22/17.
 */
public class JPMSalesStore {

    public static final BlockingQueue<String> MESSAGE_STORE
            = new ArrayBlockingQueue<>(Constants.QUEUE_LENGTH);

    public static final List<String> FAILED_MESSAGE_STORE = new ArrayList<>();

    public static final List<SalesMessage> SALES_STORE = new ArrayList<>();

    public static final List<AdjustmentMessage> ADJ_STORE = new ArrayList<>();

}
