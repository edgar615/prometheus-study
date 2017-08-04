package com.edgar.prometheus.hello;

import io.prometheus.client.Summary;

class SummaryExample2 {
  static final Summary requestLatency = Summary.build()
    .quantile(0.5, 0.05)   // Add 50th percentile (= median) with 5% tolerated error
    .quantile(0.9, 0.01)   // Add 90th percentile with 1% tolerated error
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
//    requestLatency.timer(() -> {
//      // Your code here.
//    });
//  }
}