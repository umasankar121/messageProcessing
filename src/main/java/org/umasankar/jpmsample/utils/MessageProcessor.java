package org.umasankar.jpmsample.utils;

/**
 * Created by Umasankar on 7/23/17.
 */
public interface MessageProcessor<MessageModel> {

    public MessageModel processMessage(String message);

}
