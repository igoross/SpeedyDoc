package helpers;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class getConfig {

    private static final  String FILE_PATH = "data_config.json";

    public String baseUrl;
    private String validUsername;
    private String validPassword;
    private String invalidUsername;
    private String invalidPassword;

    public getConfig() {
        try{
            Gson gson = new Gson();
            FileReader reader = new FileReader(FILE_PATH);
            getConfig config = gson.fromJson(reader, getConfig.class);
            this.baseUrl = config.baseUrl;
            this.validUsername = config.validUsername;
            this.validPassword = config.validPassword;
            this.invalidUsername = config.invalidUsername;
            this.invalidPassword = config.invalidPassword;
        } catch (IOException e){
            System.out.println("an error occured: " );
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public String getValidUsername() {
        return validUsername;
    }
    public String getValidPassword() {
        return validPassword;
    }

    public String getInvalidUsername() {
        return invalidUsername;
    }
    public String getInvalidPassword() {
        return invalidPassword;
    }
}