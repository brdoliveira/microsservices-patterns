package io.github.microservicespatterns.bff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demonstrates separate backend responses for mobile and web frontends.
 */
@RestController
public class BackendsForFrontendsExample {
  /**
   * Returns a compact product response for a mobile client.
   *
   * @param id product identifier
   * @return mobile product projection
   */
  @GetMapping("/mobile/products/{id}")
  public MobileProduct mobileProduct(@PathVariable String id) {
    return new MobileProduct(id, "Notebook", true);
  }

  /**
   * Returns a richer product response for a web client.
   *
   * @param id product identifier
   * @return web product projection
   */
  @GetMapping("/web/products/{id}")
  public WebProduct webProduct(@PathVariable String id) {
    return new WebProduct(id, "Notebook", "Office supplies", "Ships today");
  }

  /**
   * Product projection designed for mobile screens.
   *
   * @param id product identifier
   * @param title short title
   * @param buyButtonVisible whether the mobile buy action should be visible
   */
  public record MobileProduct(String id, String title, boolean buyButtonVisible) {}

  /**
   * Product projection designed for desktop web screens.
   *
   * @param id product identifier
   * @param title product title
   * @param category product category
   * @param shippingMessage shipping information shown on the web page
   */
  public record WebProduct(String id, String title, String category, String shippingMessage) {}
}
