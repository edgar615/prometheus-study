package com.edgar.prometheus.hello;

import io.prometheus.client.Counter;

class LabelExample1 {
  static final Counter requests = Counter.build()
     .name("my_library_requests_total").help("Total requests.")
     .labelNames("method").register();
  
  void processGetRequest() {
    requests.labels("get").inc();
    // Your code here.
  }
}