package com.edgar.prometheus.vertx;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.vertx.MetricsHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

//scrape_configs:
//        - job_name: 'http_test'
//        scrape_interval: 3s
//        static_configs:
//        - targets:
//        - 10.4.7.15
//        metrics_path: /metrics
//        params:
//        module: [default]
//        relabel_configs:
//        - source_labels: [__address__]
//        target_label: __param_target
//        - source_labels: [__param_target]
//        target_label: instance
//        - target_label: __address__
//        replacement: 10.4.7.15:8080
/**
 * Created by Edgar on 2017/8/4.
 *
 *
 * @author Edgar  Date 2017/8/4
 */
public class HttpServer extends AbstractVerticle {

  static final Counter requests = Counter.build()
          .name("requests_total").help("Total requests.").register();

  @Override
  public void start() throws Exception {
    Router router = Router.router(vertx);
    router.get("/metrics").handler(new MetricsHandler(CollectorRegistry.defaultRegistry));
    router.get("/ping").handler(rc -> {
      requests.inc();
      rc.response().end("pong");
    });
    vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(8080);
  }

  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(HttpServer.class.getName());
  }
}
