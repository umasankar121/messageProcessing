package org.umasankar.jpmsample.reports;

import org.umasankar.jpmsample.Constants;
import org.umasankar.jpmsample.model.JPMSalesStore;
import org.umasankar.jpmsample.model.SalesMessage;

import java.util.List;

/**
 * Created by Umasankar on 7/23/17.
 */
public class SalesReportGenerator implements ReportGenerator {

    @Override
    public void generate() {
        List<SalesMessage> salesMessageReport = JPMSalesStore.SALES_STORE;
        int i = Constants.START_ELEMENT;
        while (i < salesMessageReport.size()) {
            SalesMessage salesMessage = salesMessageReport.get(i);
            
            System.out.println(salesMessage);
            i++;
        }
        Constants.START_ELEMENT=i;
    }
}
