package com.thoughtworks;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test(dataProvider = "getTypes")
    public void shouldGetCorrectSubType(String type, List<String> subType) throws Exception {
        App app = new App();
        List<String> subTypes = app.getSubType(type);
        assertEquals(subType,subTypes);


    }

    @DataProvider
    private Object[][] getTypes() {
        Map<String, List<String>> types = (Map<String, List<String>>) loadYaml("/Type.yaml");

        return new Object[][]{
                {
                        "Type1", types.get("Type1")
                }, {
                "Type2", types.get("Type2")
        }
        };
    }




    // load object from yaml file
    private Object loadYaml(String resource) {
        Yaml yaml = new Yaml();
        yaml.setBeanAccess(BeanAccess.FIELD);
        return yaml.load(AppTest.class.getResourceAsStream(resource));
    }

    // convert object to yaml string
    private void dumpYaml(Object object) {
        String dump = new Yaml().dump(object);

    }
}
