import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PojoConverter;

import java.util.HashMap;
import java.util.Map;

@Epic("UI Tests")
@Feature("Main Page")
@DisplayName("UI Tests")
public class TestAlluerPlugin {

    @Test
    @DisplayName("Test1")
    @Description("Test1")
    @Story("Test1")
    public void test1(){
        System.out.println("Here test 1");
    }

    @Test
    @DisplayName("Test2")
    @Description("Test2")
    @Story("Test2")
    public void test2(){
        System.out.println("Here test 2");
        Map<String,String> myMap = new HashMap<>();
        myMap.put("name","Andrey");
        myMap.put("Age","33");
        PojoConverter.convertPojoToPrettyJsonString(myMap);
    }
}
