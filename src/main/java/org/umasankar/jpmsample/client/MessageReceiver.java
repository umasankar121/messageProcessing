package org.umasankar.jpmsample.client;

import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

import org.umasankar.jpmsample.reports.ReportGenerator;

/**
 * Created by Umasankar on 7/23/17.
 */
public class MessageReceiver<T> {

	private static int MessageCount = 0;
	private final ReportGenerator salesReportGenerator;
	private final ReportGenerator adjReportGenerator;
	private BlockingQueue<T> queue;

	public MessageReceiver(BlockingQueue<T> queue, ReportGenerator salesReportGenerator,
			ReportGenerator adjReportGenerator) {
		this.queue = queue;
		this.salesReportGenerator = salesReportGenerator;
		this.adjReportGenerator = adjReportGenerator;
	}

	public void receive(Consumer<T> consumer) {
		while (true) {
			try {
				final T message = this.queue.take();
				// System.out.println("Message Received -> \n" + message);
				consumer.accept(message);
				MessageCount++;
				if ((MessageCount % 10) == 0) {
					// Sales Report
					this.salesReportGenerator.generate();
				}

				if ((MessageCount % 50) == 0) {
					// Adjustment Report
					this.adjReportGenerator.generate();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
