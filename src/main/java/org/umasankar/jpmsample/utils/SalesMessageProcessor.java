package org.umasankar.jpmsample.utils;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.umasankar.jpmsample.model.JPMSalesStore;
import org.umasankar.jpmsample.model.SalesMessage;

/**
 * Created by Umasankar on 7/23/17.
 */
public class SalesMessageProcessor implements MessageProcessor<SalesMessage> {

    public SalesMessage processMessage(String message) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SalesMessage.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SalesMessage salesMessage = (SalesMessage) unmarshaller.unmarshal(new StringReader(message));
//            System.out.println(salesMessage);
            JPMSalesStore.SALES_STORE.add(salesMessage);
            return salesMessage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
