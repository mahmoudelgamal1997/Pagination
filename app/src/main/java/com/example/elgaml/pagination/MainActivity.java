package com.example.elgaml.pagination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MainViewModel itemViewModel = new MainViewModel();
        final ItemAdapter adapter = new ItemAdapter(this);

        itemViewModel.pagedListLiveData.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(PagedList<Item> items) {
                if ( items!=null){
                    Log.e("eeeeeeeeeeeeeee","loadmore");
                    Log.e("eeeeeeeeeeeeeee",String.valueOf(items.size()));

                adapter.submitList(items);
            }else {
                    Log.e("eeeeeeeeeeeee","Emputy");
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
