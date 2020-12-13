package com.andriod.course.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.andriod.course.MySingleton;
import com.andriod.course.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
//        getAllPosts();
        getPostDetails(5);
    }

    private void getAllPosts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , "https://jsonplaceholder.typicode.com/posts", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    Log.d("Total number of Posts", array.length() + "");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        Log.d("userId", jsonObject.getInt("userId") + "");
                        Log.d("id", jsonObject.getInt("id") + "");
                        Log.d("title", jsonObject.getString("title"));
                        Log.d("body", jsonObject.getString("body"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).setGravity(0, 0, 0);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new
                        HashMap<>();
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    private void getPostDetails(int postId) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , "https://jsonplaceholder.typicode.com/posts/" + postId, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d("userId", jsonObject.getInt("userId") + "");
                    Log.d("id", jsonObject.getInt("id") + "");
                    Log.d("title", jsonObject.getString("title"));
                    Log.d("body", jsonObject.getString("body"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).setGravity(0, 0, 0);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new
                        HashMap<>();
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };
        MySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}