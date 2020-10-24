package m.d.a.m.p.ya.c21035;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskC {
    public static void main(String[] args) {
        // tests();
        run();
    }

    static void run() {
        calc();
    }

    static void calc() {
        new PassportServer().start();
    }

    static class Parser {
        String parse(String a) {
            if (a != null) {
                String v = a.trim();
                if (v.length() == 10) {
                    for (int i = 0; i < v.length(); i++) {
                        if (!Character.isDigit(v.charAt(i))) {
                            return null;
                        }
                    }
                    return v.substring(0, 4) + "-" + v.substring(4, 10);
                } else if (v.length() == 11) {
                    String sub1 = v.substring(0, 4);
                    String sub2 = v.substring(5, 11);
                    String subm = v.substring(4, 5);
                    for (int i = 0; i < sub1.length(); i++) {
                        if (!Character.isDigit(sub1.charAt(i))) {
                            return null;
                        }
                    }
                    for (int i = 0; i < sub2.length(); i++) {
                        if (!Character.isDigit(sub2.charAt(i))) {
                            return null;
                        }
                    }
                    if (subm.equals("-") || subm.equals(" ")) {
                        return sub1 + "-" + sub2;
                    }
                    return null;
                } else if (v.length() == 12) {
                    String sub1 = v.substring(1, 5);
                    String sub2 = v.substring(6, 12);
                    String a1 = v.substring(0, 1);
                    String a2 = v.substring(5, 6);
                    if (a1.equals("(") && a2.equals(")")) {
                        for (int i = 0; i < sub1.length(); i++) {
                            if (!Character.isDigit(sub1.charAt(i))) {
                                return null;
                            }
                        }
                        for (int i = 0; i < sub2.length(); i++) {
                            if (!Character.isDigit(sub2.charAt(i))) {
                                return null;
                            }
                        }
                        return sub1 + "-" + sub2;
                    }
                    return null;
                } else if (v.length() == 13) {
                    String sub1 = v.substring(1, 5);
                    String sub2 = v.substring(7, 13);
                    String sm = v.substring(6, 7);
                    String a1 = v.substring(0, 1);
                    String a2 = v.substring(5, 6);
                    if (!sm.equals(" ")) {
                        return null;
                    }
                    if (a1.equals("(") && a2.equals(")")) {
                        for (int i = 0; i < sub1.length(); i++) {
                            if (!Character.isDigit(sub1.charAt(i))) {
                                return null;
                            }
                        }
                        for (int i = 0; i < sub2.length(); i++) {
                            if (!Character.isDigit(sub2.charAt(i))) {
                                return null;
                            }
                        }
                        return sub1 + "-" + sub2;
                    }
                    return null;
                } else if (v.length() == 14) {
                    String prefix = v.substring(0, 2);
                    String sub1 = v.substring(3, 7);
                    String sub2 = v.substring(8, 14);
                    String a1 = v.substring(2, 3);
                    String a2 = v.substring(7, 8);
                    if (!prefix.equals("PC")) {
                        return null;
                    }
                    if (a1.equals("-") && a2.equals("-")) {
                        for (int i = 0; i < sub1.length(); i++) {
                            if (!Character.isDigit(sub1.charAt(i))) {
                                return null;
                            }
                        }
                        for (int i = 0; i < sub2.length(); i++) {
                            if (!Character.isDigit(sub2.charAt(i))) {
                                return null;
                            }
                        }
                        return sub1 + "-" + sub2;
                    }
                    return null;
                }
            }
            return null;
        }
    }

    static class Answer {
        String create(String normalized) {
            StringBuilder htmlBuilder = new StringBuilder();

            if (normalized != null) {
                htmlBuilder.append("{");
                htmlBuilder.append("\"normalized\": " + "\"" + normalized + "\"" + ", ");
                htmlBuilder.append("\"status\": " + "true");
                htmlBuilder.append("}");
            } else {
                htmlBuilder.append("{");
                htmlBuilder.append("\"status\": " + "false");
                htmlBuilder.append("}");
            }

            return htmlBuilder.toString();
        }
    }

    static class PassportServer {
        HttpServer server;
        ThreadPoolExecutor threadPoolExecutor;

        void start() {
            threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            try {
                server = HttpServer.create(new InetSocketAddress("localhost", 7777), 0);
                server.setExecutor(threadPoolExecutor);
                server.createContext("/ping", new PingHttpHandler());
                server.createContext("/shutdown", new ShutdownHttpHandler(this));
                server.createContext("/validatePassportCode", new ValidatePassportCode());
                server.start();

            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

        void stop() {
            server.stop(0);
            threadPoolExecutor.shutdownNow();
        }

        static class PingHttpHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    OutputStream outputStream = httpExchange.getResponseBody();
                    StringBuilder htmlBuilder = new StringBuilder();
                    String htmlResponse = htmlBuilder.toString();
                    httpExchange.sendResponseHeaders(200, htmlResponse.length());
                    outputStream.write(htmlResponse.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
        }

        static class ShutdownHttpHandler implements HttpHandler {
            PassportServer passportServer;

            ShutdownHttpHandler(PassportServer passportServer) {
                this.passportServer = passportServer;
            }

            @Override
            public void handle(HttpExchange httpExchange) {
                this.passportServer.stop();
            }
        }

        static class ValidatePassportCode implements HttpHandler {
            private static final String HEADER_CONTENT_TYPE = "Content-Type";

            private static final Charset CHARSET = StandardCharsets.UTF_8;

            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    String query = httpExchange.getRequestURI().getQuery();

                    String normalized = null;
                    String passportCodeValue = null;

                    if (query != null && !query.isEmpty()) {
                        String[] pairs = query.split("&");
                        Map<String, String> queryPairs = new LinkedHashMap<String, String>();

                        for (String pair : pairs) {
                            int idx = pair.indexOf("=");
                            queryPairs.put(
                                    URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                                    URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
                        }

                        if (queryPairs.containsKey("passport_code")) {
                            passportCodeValue = queryPairs.get("passport_code");
                        }
                    }

                    if (passportCodeValue != null) {
                        normalized = new Parser().parse(passportCodeValue);
                        StringBuilder htmlBuilder = new StringBuilder();
                        htmlBuilder.append(new Answer().create(normalized));
                        OutputStream outputStream = httpExchange.getResponseBody();
                        String htmlResponse = htmlBuilder.toString();
                        // httpExchange.getRequestHeaders().set(HEADER_CONTENT_TYPE, String.format("application/json; charset=%s", CHARSET));
                        httpExchange.sendResponseHeaders(200, htmlResponse.length());
                        outputStream.write(htmlResponse.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    } else {
                        StringBuilder htmlBuilder = new StringBuilder();
                        OutputStream outputStream = httpExchange.getResponseBody();
                        String htmlResponse = htmlBuilder.toString();
                        httpExchange.sendResponseHeaders(400, htmlResponse.length());
                        outputStream.write(htmlResponse.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                }
            }
        }
    }

    static void tests() {
        //test1();
        test2();
    }

    static void test1() {
        System.out.println(new Parser().parse("1234567890")); // ##########
        System.out.println(new Parser().parse("1234 567890")); // #### ######
        System.out.println(new Parser().parse("1234-567890")); // ####-######
        System.out.println(new Parser().parse("(1234)567890")); // (####) ######
        System.out.println(new Parser().parse("(1234) 567890")); // (####)######
        System.out.println(new Parser().parse("PC-1234-567890")); // PC-####-######
    }

    static void test2() {
        System.out.println(new Answer().create("1234-567890"));
        System.out.println(new Answer().create(null));
    }
}