package com.edgar.prometheus.hello;

import io.prometheus.client.Histogram;

class HistogramExample {
  static final Histogram requestLatency = Histogram.build()
          .name("requests_latency_seconds").help("Request latency in seconds.").register();
//  The default buckets are intended to cover a typical web/rpc request from milliseconds to
// seconds. They can be overridden with the buckets() method on the Histogram.Builder.

//  void processRequest(Request req) {
//    Histogram.Timer requestTimer = requestLatency.startTimer();
//    try {
//      // Your code here.
//    } finally {
//      requestTimer.observeDuration();
//    }
//  }
}