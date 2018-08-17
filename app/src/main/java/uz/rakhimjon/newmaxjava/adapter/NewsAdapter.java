package uz.rakhimjon.newmaxjava.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import uz.rakhimjon.newmaxjava.R;
import uz.rakhimjon.newmaxjava.model.NewsModel;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<NewsModel> list;
    private Context context;

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        NewsModel model = list.get(position);
        holder.tvNewsAuthor.setText(model.author);
        holder.tvNewsItemTitle.setText(model.title);
        holder.tvListItemDateTime.setText(model.publishedAt);

        Glide.with(context)
                .load(model.urlToImage)
                .into(holder.ivNewsImage);


    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvListItemDateTime;
        TextView tvNewsItemTitle;
        TextView tvNewsAuthor;
        ImageView ivNewsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvListItemDateTime = itemView.findViewById(R.id.tvListItemDateTime);
            tvNewsItemTitle = itemView.findViewById(R.id.tvNewsItemTitle);
            tvNewsAuthor = itemView.findViewById(R.id.tvNewsAuthor);
            ivNewsImage = itemView.findViewById(R.id.ivNewsImage);

        }
    }
}
