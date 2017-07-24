package org.umasankar.jpmsample.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.umasankar.jpmsample.model.AdjustmentMessage;
import org.umasankar.jpmsample.model.JPMSalesStore;

import java.io.StringReader;

/**
 * Created by Umasankar on 7/23/17.
 */
public class AdjustmentMessageProcessor implements MessageProcessor<AdjustmentMessage> {

    public AdjustmentMessage processMessage(String message) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AdjustmentMessage.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            AdjustmentMessage adjMessage = (AdjustmentMessage) unmarshaller.unmarshal(new StringReader(message));
//            System.out.println(adjMessage);
            JPMSalesStore.ADJ_STORE.add(adjMessage);
            return adjMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
