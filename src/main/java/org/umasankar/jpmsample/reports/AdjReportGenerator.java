package org.umasankar.jpmsample.reports;

import java.util.List;

import org.umasankar.jpmsample.Constants;
import org.umasankar.jpmsample.model.AdjustmentMessage;
import org.umasankar.jpmsample.model.JPMSalesStore;
import org.umasankar.jpmsample.model.SalesMessage;

/**
 * Created by Umasankar on 7/23/17.
 */
public class AdjReportGenerator implements ReportGenerator {
	@Override
	public void generate() {
		List<AdjustmentMessage> ADJsalesMessageReport = JPMSalesStore.ADJ_STORE;
		List<SalesMessage> salesReport = JPMSalesStore.SALES_STORE;
		int i = Constants.ADJ_START_ELEMENT;
		while (i < ADJsalesMessageReport.size()) {
			AdjustmentMessage adjSalesMessage = ADJsalesMessageReport.get(i);
			for (SalesMessage salesMessage : salesReport) {
				if (salesMessage.getProduct().equals(adjSalesMessage.getProduct())) {
					if (adjSalesMessage.getOperation().equals("add")) {
						salesMessage.setPrice(salesMessage.getPrice() + adjSalesMessage.getUpdateAmount());
						System.out.println("After adjustment the sales message is : " + salesMessage);
					}
					if (adjSalesMessage.getOperation().equals("sub")) {
						salesMessage.setPrice(salesMessage.getPrice() + adjSalesMessage.getUpdateAmount());
						System.out.println("After adjustment the sales message is : " + salesMessage);
					}
					if (adjSalesMessage.getOperation().equals("mul")) {
						salesMessage.setPrice(salesMessage.getPrice() + adjSalesMessage.getUpdateAmount());
						System.out.println("After adjustment the sales message is : " + salesMessage);
					}

				}
			}
			i++;
		}

		Constants.ADJ_START_ELEMENT = i;
	}
}
