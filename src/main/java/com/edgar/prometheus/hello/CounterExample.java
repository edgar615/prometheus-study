package com.edgar.prometheus.hello;

import io.prometheus.client.Counter;

class CounterExample {
  static final Counter requests = Counter.build()
          .name("requests_total").help("Total requests.").register();

  void processRequest() {
    requests.inc();
    // Your code here.
  }
}