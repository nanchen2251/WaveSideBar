# WaveSideBar
WavaSideBar——一个自带中英文对应排序和检索功能的字母导航栏
##效果图<br>
![](https://github.com/nanchen2251/WaveSideBar/blob/master/GIF.gif)

####⊙开源不易，希望给个star或者fork奖励
##特点
  1、支持手势滑动导航栏<br>
  2、支持自定义设置偏移量和颜色<br>
  3、支持设置字母导航栏设置位置<br>
  4、支持自动匹配中英文<br>
  5、支持拼音和中文搜索<br>
##使用方法
####1、添加依赖<br>
####2017年1月5日后仓库转移到jitpack，添加依赖方式为：
#####Step 1. Add it in your root build.gradle at the end of repositories:
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#####Step 2. Add the dependency
```java
dependencies {
	        compile 'com.github.nanchen2251:WaveSideBar:1.0.6'
	}
```
####2、在xml文件里面使用<br>
```java
  <!--搜索框-->
  <com.nanchen.wavesidebar.SearchEditText
        android:id="@+id/main_search"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_marginLeft="15dp"
        android:layout_marginRight="15dp"
        android:layout_marginTop="5dp"
        android:background="@drawable/search_edit_bg"
        android:drawableLeft="@mipmap/icon_search"
        android:drawablePadding="5dp"
        android:drawableStart="@mipmap/icon_search"
        android:gravity="center_vertical"
        android:hint="@string/search"
        android:imeOptions="actionSearch"
        android:maxLines="1"
        android:padding="5dp"
        android:textSize="16sp"
        app:drawableDel="@mipmap/edit_delete"/>
	
	
  <!--字母导航栏-->
  <com.nanchen.wavesidebar.WaveSideBarView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="8dp"
        android:id="@+id/main_side_bar"
        app:sidebar_text_color="@color/colorAccent"
        app:sidebar_lazy_respond="false"/>
```
####3、在Activity里面使用<br>
```java
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
	        //You can do something in there
                mShowModels.clear();
                for (ContactModel model : mContactModels) {
                    String str = Trans2PinYinUtil.trans2PinYin(model.getName());
                    if (str.contains(s.toString())|| model.getName().contains(s.toString())) {
                        mShowModels.add(model);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
```
####4、自动匹配中英文<br>
```java
FirstLetterUtil.getFirstLetter(name);
```
####5、中文转换成拼音<br>
```java
Trans2PinYinUtil.trans2PinYin(String name);
```
具体请下载查看示例代码
##属性一览
|      Attributes     |   Format |    Default   |           Description          |
| ------------------- |  ------: | :---------:  | :-----------                   |
| sidebar_text_color  |   color  |  Color.GRAY  | Text color.                    |
| sidebar_max_offset  | dimension|      80dp    |Offset of the selected item.   |
| sidebar_position  | enum {right, left}|      right    | Be placed on left or right in the view.  |
| sidebar_text_alignment  | enum {center, left, right}|      center    | Alignment of items.   |
| sidebar_lazy_respond  | boolean|      false    |If true, the listener will not be called until the finger up. If false, the listener will be called when the finger down, move and up.  |

该项目参考了：

* [https://github.com/gjiazhe/WaveSideBar](https://github.com/gjiazhe/WaveSideBar) 
* [https://github.com/Solartisan/WaveSideBar](https://github.com/Solartisan/WaveSideBar)


##关于作者
    南尘<br>
    四川成都<br>
    [其它开源](https://github.com/nanchen2251/)<br>
    [博客园](http://www.cnblogs.com/liushilin/)
