package org.umasankar.jpmsample;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.umasankar.jpmsample.client.MessageProducer;
import org.umasankar.jpmsample.client.MessageReceiver;
import org.umasankar.jpmsample.model.JPMSalesStore;
import org.umasankar.jpmsample.reports.AdjReportGenerator;
import org.umasankar.jpmsample.reports.ReportGenerator;
import org.umasankar.jpmsample.reports.SalesReportGenerator;
import org.umasankar.jpmsample.utils.AdjustmentMessageProcessor;
import org.umasankar.jpmsample.utils.FakeMessageBuilder;
import org.umasankar.jpmsample.utils.SalesMessageProcessor;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.startEngine();
    }

    public void startEngine() {
        startProducer();
        startReceiver();
    }

    private void startProducer() {
        final MessageProducer<String> producer = new MessageProducer<String>(JPMSalesStore.MESSAGE_STORE);
        final Supplier<String> supplier = () -> {
            String message = FakeMessageBuilder.buildMessage();
            //System.out.println("Message -> \n" + message);
            return message;
        };

        //Start MessageProducer Theread
        new Thread(() -> {
            for (int i = 0; i < Constants.MAX_MESSAGES; i++) {
                producer.produce(supplier);
            }
        }).start();
    }

    private void startReceiver() {
        final ReportGenerator salesReportGenerator = new SalesReportGenerator();
        final ReportGenerator adjReportGenerator = new AdjReportGenerator();
        final MessageReceiver<String> receiver =
                new MessageReceiver<>(JPMSalesStore.MESSAGE_STORE, salesReportGenerator, adjReportGenerator);
        final Consumer<String> messageConsumer = (message) -> {
            if (message.contains("Sales")) {
                new SalesMessageProcessor().processMessage(message);
            } else if (message.contains("Adjustment")) {
                new AdjustmentMessageProcessor().processMessage(message);
            }
        };

        //Start the MessageReceiver Thread
        new Thread(() ->{ receiver.receive(messageConsumer); }).start();
		
    }
}
