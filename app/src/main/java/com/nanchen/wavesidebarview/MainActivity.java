package com.nanchen.wavesidebarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nanchen.wavesidebar.WaveSideBarView;
import com.nanchen.wavesidebar.WaveSideBarView.OnSelectIndexItemListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ContactModel> mContactModels;
    private RecyclerView mRecyclerView;
    private WaveSideBarView mWaveSideBarView;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        bindView();
    }

    private void bindView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(mToolbar, false, "");

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.registerTypePinnedHeader(1, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                return true;
            }
        });
        mRecyclerView.addItemDecoration(decoration);

        mRecyclerView.setAdapter(new ContactsAdapter(mContactModels));



        mWaveSideBarView = (WaveSideBarView) findViewById(R.id.main_side_bar);
        mWaveSideBarView.setOnSelectIndexItemListener(new OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String letter) {
                for (int i=0; i<mContactModels.size(); i++) {
                    if (mContactModels.get(i).getIndex().equals(letter)) {
                        ((LinearLayoutManager) mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
    }

    /**
     *  初始化 Toolbar
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }


    private void initData() {
        mContactModels = new ArrayList<>();
        mContactModels.addAll(ContactModel.getContacts());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mContactModels != null){
            mContactModels.clear();
            mContactModels = null;
        }
    }
}
