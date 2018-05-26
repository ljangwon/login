package com.example.ljangwon.login;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest {

    final static private String URL= "http://lmath.cafe24.com/Delete.php";
    private Map<String, String> parameters;

    public DeleteRequest(String userId, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userId", userId);

    }

    public Map<String, String> getParams() {
        return parameters;
    }
}
