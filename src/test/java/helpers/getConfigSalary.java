package helpers;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class getConfigSalary {
    private String baseURL;

    public getConfigSalary(){
        String filePath = "src/test/resources/config/data_config_salary.json";
        try {
            JSONObject jsonObject = new JSONObject(new BufferedReader(new FileReader(filePath)).lines().collect(Collectors.joining(System.lineSeparator())));
            baseURL = jsonObject.getJSONObject("envs").getString("dev");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public String getBaseURL(){
        return baseURL;
    }
}
