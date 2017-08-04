package com.edgar.prometheus.hello;

import io.prometheus.client.Histogram;

class HistogramExample2 {
  static final Histogram requestLatency = Histogram.build()
     .name("requests_latency_seconds").help("Request latency in seconds.").register();
  
//  void processRequest(Request req) {
//    requestLatency.timer(new Runnable() {
//      public abstract void run() {
//        // Your code here.
//      }
//    });
//
//
//    // Or the Java 8 lambda equivalent
//    requestLatency.time(() -> {
//      // Your code here.
//    });
//  }
}