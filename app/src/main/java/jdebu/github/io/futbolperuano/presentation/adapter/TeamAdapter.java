package jdebu.github.io.futbolperuano.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jdebu.github.io.futbolperuano.R;
import jdebu.github.io.futbolperuano.domain.model.Team;
import jdebu.github.io.futbolperuano.presentation.utils.media.ImageLoaderHelper;

/**
 * Created by jose on 19/04/2017.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private List<Team> teams;
    private ImageLoaderHelper imageLoaderHelper;

    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
        imageLoaderHelper=new ImageLoaderHelper(ImageLoaderHelper.GLIDE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_team,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team= teams.get(position);
        if (team!=null){
            String name = (TextUtils.isEmpty(team.getName())?(""):(team.getName()));
            String path = team.getPhoto();
            holder.tvName.setText(name);
            imageLoaderHelper.getLoader().load(path,holder.ivTeam);
        }
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivTeam;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName=(TextView) itemView.findViewById(R.id.tvName);
            ivTeam=(ImageView) itemView.findViewById(R.id.ivLogo);
        }
    }
}
