package CRUDweb.Responses;

import org.json.JSONArray;
import org.json.JSONObject;

public class Responses {
    
    public static JSONObject SuccessResponse(JSONObject data) {
        JSONObject response = new JSONObject();
        response.put("status", "200");
        response.put("success", true);
        response.put("data", data);
        return response;
    }

    public static JSONObject SuccessResponse(String data) {
        JSONObject response = new JSONObject();
        response.put("status", "200");
        response.put("success", true);
        response.put("data", data);
        return response;
    }

    public static JSONObject SuccessResponse(JSONArray data) {
        JSONObject response = new JSONObject();
        response.put("status", "200");
        response.put("success", true);
        response.put("data", data);
        return response;
    }

    public static JSONObject FailResponse() {
        JSONObject response = new JSONObject();
        response.put("status", "500");
        response.put("success", false);
        return response;
    }

    public static JSONObject FailResponse(String reason) {
        JSONObject response = new JSONObject();
        response.put("status", "500");
        response.put("success", false);
        response.put("reason", reason);
        return response;
    }
}
