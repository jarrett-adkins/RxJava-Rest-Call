package com.example.admin.rxjava;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.rxjava.model.Repo;

import java.util.ArrayList;
import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> {

    List<Repo> repoList = new ArrayList<>();
    Context context;

    public RepoListAdapter(List<Repo> repoList) {
        this.repoList = repoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater
                .from( parent.getContext() )
                .inflate( R.layout.repo_list_item, parent, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = repoList.get( position );

        holder.repoName.setText( repo.getName() );
        Glide.with( context )
                .load( repo.getOwner().getAvatarUrl() )
                .into( holder.avatar );
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView repoName;
        private final ImageView avatar;

        public ViewHolder(View itemView) {
            super(itemView);

            repoName = itemView.findViewById( R.id.tvRepoName );
            avatar = itemView.findViewById( R.id.ivRepoAvatar );
        }
    }
}
