# Noren API

This repository contains Java code for interacting with the Noren API to perform various trading operations. It includes methods for placing orders, modifying orders, canceling orders, and exiting orders.

## Description

The `NorenApi` class provides methods for interacting with the Noren API. It includes the following methods:

- `placeOrder`: This method is used to place an order for buying or selling a product. It accepts various parameters such as buy or sell, product type, exchange, trading symbol, quantity, price type, and more.

- `modifyOrder`: This method is used to modify an existing order. It allows the user to change the quantity, price, trigger price, book loss price, book profit price, and trail price.

- `cancelOrder`: This method is used to cancel an existing order. It requires the order number as a parameter.

- `exitOrder`: This method is used to exit an existing order. It takes the order number and product type as parameters.

## Getting Started

To use this code, follow these steps:

1. Clone the repository to your local machine.
2. Set up the necessary configurations for the Noren API.
3. Ensure you have the required dependencies installed.
4. Run the application and use the provided methods to interact with the Noren API.

## Usage

You can use the provided methods to interact with the Noren API and perform various trading operations. Modify the parameters as per your requirements and ensure that the necessary configurations are set up correctly.

## Contributing

Contributions to this project are welcome. If you find any issues or would like to suggest improvements, please feel free to create a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Below is an example of a simple REST API implemented in Java using Spring Boot:

```java
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class NorenApi {
    // ... (rest of the code)

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/hello")
    public String helloWorld() {
        return "{\"message\": \"java, World!\"}";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/endpoint1")
    public String endpoint1() {
        // Implement your logic here.
    }
}
# java_test_api_helper
