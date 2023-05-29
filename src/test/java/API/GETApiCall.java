//package API;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.microsoft.playwright.APIRequest;
//import com.microsoft.playwright.APIRequestContext;
//import com.microsoft.playwright.APIResponse;
//import com.microsoft.playwright.Playwright;
//import com.microsoft.playwright.options.RequestOptions;
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
//import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class GETAPICall {
//
//    APIRequestContext requestContext;
//    APIRequest request;
//    Playwright playwright;
//
//    @BeforeTest
//    public void setup(){
//        playwright = Playwright.create();
//        request = playwright.request();
//        requestContext = request.newContext();
//    }
//
//    @Test
//    public void getSpecificUserAPItest(){
//        APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users",
//                RequestOptions.create()
//                        .setQueryParam("gender", "male")
//                        .setQueryParam("status", "active"));
//        int statusCode = apiResponse.status();
//        System.out.println("response status code:" + statusCode);
//        Assert.assertEquals(statusCode, 200);
//        Assert.assertEquals(apiResponse.ok(), true);
//        String statusText = apiResponse.statusText();
//        System.out.println(statusText);
//        System.out.println("----print api response with text------");
//        System.out.println(apiResponse.text());
//
//    }
//
//
//    @Test
//    public void getUserApiTest() throws IOException {
//
////        GET request
//        Playwright playwright = Playwright.create();
//        APIRequest request = playwright.request();
//        APIRequestContext requestContext = request.newContext();
//        APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users");
//
////        Catch status code
//        int statusCode = apiResponse.status();
//        System.out.println("response status code:" + statusCode);
//        Assert.assertEquals(statusCode, 200);
//
////        Catch status text
//        String statusText = apiResponse.statusText();
//        System.out.println(statusText);
//
//        System.out.println("---- print api response whit plaid text------");
//        System.out.println(apiResponse.text());
//
////        Catch body
//        System.out.println("---print api response----");
//        apiResponse.body();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
//        String jsonPrettyResponse = jsonResponse.toPrettyString();
//        System.out.println(jsonPrettyResponse);
//
////        Catch URL
//        System.out.println("---print api url----");
//        System.out.println(apiResponse.url());
//
////        Catch Headers
//        System.out.println("---print api headers----");
//        Map<String, String> headersMap = apiResponse.headers();
//        System.out.println(headersMap);
//        Assert.assertEquals(headersMap.get("content-type"), "application/json; charset=utf-8");
//
//
//
//    }
//
//}
