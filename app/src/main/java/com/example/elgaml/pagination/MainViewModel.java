package com.example.elgaml.pagination;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class MainViewModel extends ViewModel {

    LiveData<PagedList<Item>> pagedListLiveData;
    LiveData<PageKeyedDataSource<Integer,Item>> dataSourceLiveData;

    MainViewModel(){
        ItemDataSourceFactory itemDataSourceFactory=new ItemDataSourceFactory();
        dataSourceLiveData=itemDataSourceFactory.getItemLiveData();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE)
                        .build();

        pagedListLiveData = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
