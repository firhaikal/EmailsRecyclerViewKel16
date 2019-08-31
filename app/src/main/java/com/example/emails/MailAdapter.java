package com.example.emails;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {
    private List<EmailData> mailData;
    private Context mContext;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mIcon, mSender, mTitle, mDetails, mTime;
        public ImageView mFavorite;

        public ViewHolder(View v){
            super(v);

            mIcon = v.findViewById(R.id.tvIcon);
            mSender = (TextView) v.findViewById(R.id.tvEmailSender);
            mTitle = (TextView) v.findViewById(R.id.tvEmailTitle);
            mDetails = (TextView) v.findViewById(R.id.tvEmailDetails);
            mTime = (TextView) v.findViewById(R.id.tvEmailTime);
            mFavorite = (ImageView) v.findViewById(R.id.ivFavorite);
        }
    }

    public MailAdapter(List<EmailData> list, MainActivity mContext){
        this.mailData = list;
        this.mContext = mContext ;
    }

    @Override
    public MailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_mail_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MailAdapter.ViewHolder holder, int position) {
        Random mRandom = new Random();
        int color = Color.rgb(mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) holder.mIcon.getBackground()).setColor(color);
            EmailData emails = mailData.get(position);
            holder.mIcon.setText(mailData.get(position).getmSender().substring(0,1));
            holder.mSender.setText(emails.getmSender());
            holder.mTitle.setText(emails.getmTitle());
            holder.mDetails.setText(emails.getmDetails());
            holder.mTime.setText(emails.getmTime());
            holder.mFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.mFavorite.getColorFilter() != null){
                        holder.mFavorite.clearColorFilter();
                    }else {
                        holder.mFavorite.setColorFilter(ContextCompat.getColor(mContext,R.color.colorYellow));
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return mailData.size();
    }





}