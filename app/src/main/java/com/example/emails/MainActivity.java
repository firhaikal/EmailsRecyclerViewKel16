package com.example.emails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<EmailData> emailData;
    private MailAdapter mailAdapter;

    String[] mSenders = {"Sam","Facebook","Google+","Twitter","Pinterest Weekly","Josh"};

    String[] mTitle = {"Weekend Adventure","James, you have 1 new notification","Top suggested Google+ pages for you","Follow T-Mobile, Samsung Mobile U","Pins you’ll love!","Going lunch"};

    String[] mDetails = {"Let's go fishing with John and others. We will do some barbecue and have soo much fun","A lot has happened on Facebook since","Top suggested Google+ pages for you","James, some people you may know","Have you seen these Pins yet? Pinterest","Don't forget our lunch at 3PM in Pizza hut",};

    String[] mTime = {"10:42am", "16:04pm", "18:44pm", "20:04pm", "09:04am", "01:04am"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));

        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);
        }
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        emailData = new ArrayList<>();

        for (int i = 0; i<mSenders.length; i++){

            EmailData MemailData = new EmailData(mSenders[i],mTitle[i],mDetails[i], mTime[i]);

            emailData.add(MemailData);
        }

        mailAdapter = new MailAdapter(emailData, MainActivity.this);

        mRecyclerView.setAdapter(mailAdapter);
        mailAdapter.notifyDataSetChanged();


    }
}
