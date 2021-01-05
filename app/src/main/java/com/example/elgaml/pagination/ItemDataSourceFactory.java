package com.example.elgaml.pagination;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory {

    MutableLiveData<PageKeyedDataSource<Integer,Item>> itemLiveData= new MutableLiveData<>();

    @Override
    public DataSource create() {
        ItemDataSource itemDataSource=new ItemDataSource();
        itemLiveData.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Item>> getItemLiveData() {
        return itemLiveData;
    }
}
