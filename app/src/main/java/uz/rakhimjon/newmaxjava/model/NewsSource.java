package uz.rakhimjon.newmaxjava.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NewsSource {
    @SerializedName("source")
    public String source;
    @SerializedName("sortBy")
    public String sortBy;
    @SerializedName("articles")
    public List<NewsModel>articles;


}
