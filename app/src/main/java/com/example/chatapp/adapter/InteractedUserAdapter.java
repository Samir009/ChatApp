package com.example.chatapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chatapp.R;
import com.example.chatapp.activities.MessageActivity;
import com.example.chatapp.models.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InteractedUserAdapter extends RecyclerView.Adapter<InteractedUserAdapter.ViewHolder> {

    private final Context context;
    private final List<User> mUsers;

    public InteractedUserAdapter(Context context, List<User> mUsers) {
        this.context = context;
        this.mUsers = mUsers;
    }

    @NonNull
    @Override
    public InteractedUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);

        return new InteractedUserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InteractedUserAdapter.ViewHolder holder, int position) {

        final User user = mUsers.get(position);

        ((InteractedUserAdapter.ViewHolder) holder).username.setText(user.getUsername());
        if(user.getImageURL().equals("default")){
            Glide.with(context).load(R.mipmap.ic_launcher).into(((InteractedUserAdapter.ViewHolder) holder).profile_image);
        } else {
            Glide.with(context).load(user.getImageURL()).into(((InteractedUserAdapter.ViewHolder) holder).profile_image);
        }

        ((InteractedUserAdapter.ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("userId", user.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView username;
        CircleImageView profile_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username_of_item);
            profile_image = itemView.findViewById(R.id.profile_image_of_item);

        }
    }
}
