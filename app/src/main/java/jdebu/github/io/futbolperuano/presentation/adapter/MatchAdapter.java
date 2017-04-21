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
import jdebu.github.io.futbolperuano.domain.model.Match;
import jdebu.github.io.futbolperuano.presentation.utils.media.ImageLoaderHelper;

/**
 * Created by jose on 21/04/2017.
 */

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private List<Match> matches;
    private ImageLoaderHelper imageLoaderHelper;

    public MatchAdapter(List<Match> matches) {
        this.matches = matches;
        imageLoaderHelper=new ImageLoaderHelper(ImageLoaderHelper.GLIDE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_match,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Match match=matches.get(position);
        if (match!=null){
            String local=(TextUtils.isEmpty(match.getNameLocal()))?(""):(match.getNameLocal());
            String visit=(TextUtils.isEmpty(match.getNameVisit()))?(""):(match.getNameVisit());
            String imgLocal=(TextUtils.isEmpty(match.getPhotoLocal()))?(""):(match.getPhotoLocal());
            String imgVisit=(TextUtils.isEmpty(match.getPhotoVisit()))?(""):(match.getPhotoVisit());
            String scoreLocal=(TextUtils.isEmpty(match.getScoreLocal()))?(""):(match.getScoreLocal());
            String scoreVisit=(TextUtils.isEmpty(match.getScoreVisit()))?(""):(match.getScoreVisit());
            String dateMatch=(TextUtils.isEmpty(match.getDateMatch()))?(""):(match.getDateMatch());
            String stateMatch=(TextUtils.isEmpty(match.getStateMatch()))?(""):(match.getStateMatch());
            holder.tvLocal.setText(local);
            holder.tvVisit.setText(visit);
            holder.tvScoreLocal.setText(scoreLocal);
            holder.tvScoreVisit.setText(scoreVisit);
            holder.tvDateMatch.setText(dateMatch);
            holder.tvStateMatch.setText(stateMatch);
            imageLoaderHelper.getLoader().load(imgLocal,holder.ivLocal);
            imageLoaderHelper.getLoader().load(imgVisit,holder.ivVisit);
        }
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tvLocal,tvVisit,tvScoreLocal,tvScoreVisit;
        public ImageView ivLocal,ivVisit;
        public TextView tvDateMatch,tvStateMatch;
        public ViewHolder(View itemView) {
            super(itemView);
            tvLocal=(TextView)itemView.findViewById(R.id.tvLocal);
            tvVisit=(TextView)itemView.findViewById(R.id.tvVisit);
            tvScoreLocal=(TextView)itemView.findViewById(R.id.tvScoreLocal);
            tvScoreVisit=(TextView)itemView.findViewById(R.id.tvScoreVisit);
            tvDateMatch=(TextView)itemView.findViewById(R.id.tvDateMatch);
            tvStateMatch=(TextView)itemView.findViewById(R.id.tvStateMatch);
            ivLocal=(ImageView)itemView.findViewById(R.id.ivLocal);
            ivVisit=(ImageView)itemView.findViewById(R.id.ivVisit);
        }
    }
}
