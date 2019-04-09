package com.taf.test.framework.helpers.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JSONUtils {

    public static void updateValueInJSON(String keyName, String overallKeyData,String filePath) throws JSONException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        String key = keyName;

        JSONObject jo = new JSONObject(overallKeyData);
        JSONObject root = mapper.readValue(new File(filePath), JSONObject.class);
        String val_newer = jo.getString(key);
        String val_older = root.getString(key);

        if(!val_newer.equals(val_older))
        {
            root.put(key,val_newer);
            try (FileWriter file = new FileWriter("json_file"))
            {
                file.write(root.toString());
                System.out.println("Successfully updated json object to file...!!");
            }
        }
    }
}
