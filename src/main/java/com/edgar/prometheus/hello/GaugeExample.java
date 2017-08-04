package com.edgar.prometheus.hello;

import io.prometheus.client.Gauge;

class GaugeExample {
  static final Gauge inprogressRequests = Gauge.build()
     .name("inprogress_requests").help("Inprogress requests.").register();
  
  void processRequest() {
    inprogressRequests.inc();
    // Your code here.
    inprogressRequests.dec();

//    inprogressRequests.setToCurrentTime();
  }
}