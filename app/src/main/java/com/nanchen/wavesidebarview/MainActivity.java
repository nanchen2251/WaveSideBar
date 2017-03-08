package com.nanchen.wavesidebarview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

import com.nanchen.wavesidebar.SearchEditText;
import com.nanchen.wavesidebar.Trans2PinYinUtil;
import com.nanchen.wavesidebar.WaveSideBarView;
import com.nanchen.wavesidebar.WaveSideBarView.OnSelectIndexItemListener;

import java.util.ArrayList;
import java.util.List;


/**
 * 主页面
 *
 * @author nanchen
 * @fileName WaveSideBarView
 * @packageName com.nanchen.wavesidebarview
 * @date 2016/12/27  18:12
 * @github https://github.com/nanchen2251
 *
 */

public class MainActivity extends AppCompatActivity {

    private List<ContactModel> mContactModels;
    private List<ContactModel> mShowModels;
    private RecyclerView mRecyclerView;
    private WaveSideBarView mWaveSideBarView;
    private SearchEditText mSearchEditText;
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        bindView();
    }

    private void bindView() {

        mAdapter = new ContactsAdapter(mShowModels);

        // RecyclerView设置相关
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
        mRecyclerView.setAdapter(mAdapter);


        // 侧边设置相关
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


        // 搜索按钮相关
        mSearchEditText = (SearchEditText) findViewById(R.id.main_search);
        mSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mShowModels.clear();
                for (ContactModel model : mContactModels) {
                    String str = Trans2PinYinUtil.trans2PinYin(model.getName());
                    if (str.contains(s.toString()) || model.getName().contains(s.toString())) {
                        mShowModels.add(model);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }


    private void initData() {
        mContactModels = new ArrayList<>();
        mShowModels = new ArrayList<>();
        mContactModels.addAll(ContactModel.getContacts());
        mShowModels.addAll(mContactModels);
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
