package com.somnus.androidhttpdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.somnus.androidhttpdemo.mvp.presenter.BookListPresent;
import com.somnus.androidhttpdemo.mvp.view.BookListView;
import com.somnus.androidhttpdemo.ui.entity.BookListDto;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BookListView {


    private BookListPresent mBookListPresent;
    private int pageIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mBookListPresent = new BookListPresent(this);
        mBookListPresent.LoadData("1", pageIndex, false);
    }


    /**
     * MVP模式的相关状态
     */

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void newDatas(List<BookListDto> newsList) {
        Log.d("tag", newsList.toString());
    }

    @Override
    public void addDatas(List<BookListDto> addList) {

    }

    @Override
    public void showLoadFailMsg() {

    }

    @Override
    public void showLoadCompleteAllData() {

    }

    @Override
    public void showNoData() {

    }
}
