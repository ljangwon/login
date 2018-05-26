package com.example.ljangwon.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagementActivity extends AppCompatActivity {

    private ListView listView;
    private UserListAdapter adapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        Intent intent = getIntent();
        listView  = (ListView) findViewById(R.id.listView);
        userList = new ArrayList<User>();

        userList.add( new User("홍길동", "홍길동", "홍길동", "20"));
        userList.add( new User("이창현", "이창현", "이창현", "11"));
        userList.add( new User("이서현", "이서현", "이서현", "9"));

        adapter = new UserListAdapter(getApplicationContext(), userList);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String userId , userPassword, userName, userAge;
            while( count <jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                userId = object.getString("userId");
                userPassword = object.getString("userPassword");
                userName = object.getString("userName");
                userAge = object.getString("userAge");
                User user = new User(userId, userPassword, userName, userAge);
                userList.add(user);
                count++;
            }

        } catch( Exception e) {
            e.printStackTrace();
        }

        //userListTextView.setText(intent.getStringExtra("userList"));
    }
}