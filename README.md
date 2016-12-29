# WaveSideBar
WavaSideBar——一个自带中英文对应排序的字母导航栏
这是一个自带节假日和滑动的日历控件，欢迎各位拍砖
##效果图<br>
![](https://github.com/nanchen2251/WaveSideBar/blob/master/GIF1.gif)

####⊙开源不易，希望给个star或者fork奖励
##特点
  1、支持手势滑动导航栏<br>
  2、支持自定义设置偏移量和颜色<br>
  3、支持设置字母导航栏设置位置<br>
  4、支持自动匹配中英文<br>
##使用方法
####1、添加依赖<br>
```java
  compile 'com.nanchen.wavesidebarview:WaveSideBar:1.0.1'
```
  或者<br>
  ```java
  <dependency>
  <groupId>com.nanchen.wavesidebarview</groupId>
  <artifactId>WaveSideBar</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```
####2、在xml文件里面使用<br>
```java
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
```
####4、自动匹配中英文<br>
```java
FirstLetterUtil.getFirstLetter(name);
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
##关于作者
    南尘<br>
    四川成都<br>
    [博客园](http://www.cnblogs.com/liushilin/)
