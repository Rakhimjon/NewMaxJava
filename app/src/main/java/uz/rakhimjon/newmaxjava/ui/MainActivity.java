package uz.rakhimjon.newmaxjava.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uz.rakhimjon.newmaxjava.R;
import uz.rakhimjon.newmaxjava.adapter.NewsAdapter;
import uz.rakhimjon.newmaxjava.api.ApiClient;
import uz.rakhimjon.newmaxjava.model.NewsModel;
import uz.rakhimjon.newmaxjava.model.NewsSource;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NewsAdapter adapter;
    List<NewsModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new NewsAdapter();
        recyclerView.setAdapter(adapter);
        setList();
    }

    public void  setList(){
        ApiClient.ApiInterface client = ApiClient.getClient();

        client.getNewsSource().enqueue(new Callback<NewsSource>() {
            @Override
            public void onResponse(Call<NewsSource> call, Response<NewsSource> response) {
              if (response.isSuccessful()){
                  list.addAll(response.body().articles);
                  System.out.println("ress" +response.body());
                  adapter.notifyDataSetChanged();
              }
            }

            @Override
            public void onFailure(Call<NewsSource> call, Throwable t) {
                System.out.println("Ressponse error" +t.getMessage());

            }
        });
    }
}
