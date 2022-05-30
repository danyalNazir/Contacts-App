package com.example.contacts_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Contact> contactList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=(ListView) findViewById(R.id.listView);
        FloatingActionButton addButton=(FloatingActionButton) findViewById(R.id.addImage);

        ListAdapter listAdapter;
        Intent intent=getIntent();
        if(savedInstanceState == null) {
            if (intent.getExtras() != null) {
                Contact contact = new Contact(intent.getStringExtra("name"), intent.getStringExtra("number"), intent.getStringExtra("city"),
                        intent.getStringExtra("date"), intent.getIntExtra("image", R.drawable.blankimage));
                contactList.add(contact);
            }
            else{
                Contact contact = new Contact("Danyal", "03413517918", "Lahore",
                        "Created: 2022-05-29 07:08", R.drawable.myimage);
                contactList.add(contact);
            }
        }
        listAdapter = (new ListAdapter(MainActivity.this, contactList));
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (contactList.size() >= 1) {
                    Intent intent = new Intent(MainActivity.this, ContactDetailsActivity.class);
                    intent.putExtra("name", contactList.get(i).name);
                    intent.putExtra("number", contactList.get(i).phone);
                    intent.putExtra("city", contactList.get(i).city);
                    intent.putExtra("image", contactList.get(i).imageResource);
                    startActivity(intent);
                }
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outInstanceState) {
        super.onSaveInstanceState(outInstanceState);
        outInstanceState.putInt("value", 1);
    }
}