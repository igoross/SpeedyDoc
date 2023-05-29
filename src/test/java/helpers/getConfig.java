package helpers;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.*;
import java.util.stream.Collectors;
import java.io.FileReader;
public class getConfig {

    private String baseUrl;
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    public getConfig(){
        String filePath = "src/test/resources/config/data_config.json";
        try {
            JSONObject jsonObject = new JSONObject(new BufferedReader(new FileReader(filePath)).lines().collect(Collectors.joining(System.lineSeparator())));
            baseUrl = jsonObject.getJSONObject("envs").getString("dev");
            JSONObject users = jsonObject.getJSONObject("users");
            validUsername = users.getJSONObject("validUser").getString("username");
            validPassword = users.getJSONObject("validUser").getString("password");
            invalidUsername = users.getJSONObject("invalidUser").getString("username");
            invalidPassword = users.getJSONObject("invalidUser").getString("password");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getBaseUrl(){
        return baseUrl;
    }
    public String getValidUsername(){
        return validUsername;
    }
    public String getValidPassword(){
        return validPassword;
    }
    public String getInvalidUsername(){
        return invalidUsername;
    }
    public String getInvalidPassword(){
        return invalidPassword;
    }

}