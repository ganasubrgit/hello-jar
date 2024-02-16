import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpListener {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server on localhost with port number 8001
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);

        // Define a context for the server
        server.createContext("/", exchange -> {
            // Set the response content type
            exchange.getResponseHeaders().set("Content-Type", "text/plain");

            // Set the response status code
            exchange.sendResponseHeaders(200, 0);

            // Get the response output stream
            OutputStream outputStream = exchange.getResponseBody();

            // Write the "Hello" message to the output stream
            String response = "Hello";
            outputStream.write(response.getBytes());

            // Close the output stream
            outputStream.close();
        });

        // Start the server
        server.start();

        // Print a message to indicate that the server is running
        System.out.println("Server started on http://<hostname>:8080");
    }
}
