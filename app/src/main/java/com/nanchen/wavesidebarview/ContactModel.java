package com.nanchen.wavesidebarview;

import com.nanchen.wavesidebar.FirstLetterUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 联系人model实体类
 *
 * @author nanchen
 * @fileName WaveSideBarView
 * @packageName com.nanchen.wavesidebarview
 * @date 2016/12/27  15:35
 * @github https://github.com/nanchen2251
 */

public class ContactModel {
    private String index;
    private String name;

    public ContactModel(String name){
        this.index = FirstLetterUtil.getFirstLetter(name);
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }


    /**
     * 这里只是为了做演示，实际上数据应该从服务器获取
     */
    public static List<ContactModel> getContacts() {
        List<ContactModel> contacts = new ArrayList<>();

        contacts.add(new ContactModel("Andy"));
        contacts.add(new ContactModel("阿姨"));
        contacts.add(new ContactModel("爸爸"));
        contacts.add(new ContactModel("Bear"));
        contacts.add(new ContactModel("BiBi"));
        contacts.add(new ContactModel("CiCi"));
        contacts.add(new ContactModel("刺猬"));
        contacts.add(new ContactModel("Dad"));
        contacts.add(new ContactModel("弟弟"));
        contacts.add(new ContactModel("妈妈"));
        contacts.add(new ContactModel("哥哥"));
        contacts.add(new ContactModel("姐姐"));
        contacts.add(new ContactModel("奶奶"));
        contacts.add(new ContactModel("爷爷"));
        contacts.add(new ContactModel("哈哈"));
        contacts.add(new ContactModel("测试"));
        contacts.add(new ContactModel("自己"));
        contacts.add(new ContactModel("You"));
        contacts.add(new ContactModel("NearLy"));
        contacts.add(new ContactModel("Hear"));
        contacts.add(new ContactModel("Where"));
        contacts.add(new ContactModel("怕"));
        contacts.add(new ContactModel("嘻嘻"));
        contacts.add(new ContactModel("123"));
        contacts.add(new ContactModel("1508022"));
        contacts.add(new ContactModel("2251"));
        contacts.add(new ContactModel("****"));
        contacts.add(new ContactModel("####"));
        contacts.add(new ContactModel("w asad "));
        contacts.add(new ContactModel("我爱你"));
        contacts.add(new ContactModel("一百二十二"));
        contacts.add(new ContactModel("壹"));
        contacts.add(new ContactModel("I"));
        contacts.add(new ContactModel("肆"));
        contacts.add(new ContactModel("王八蛋"));
        contacts.add(new ContactModel("zzz"));
        contacts.add(new ContactModel("呵呵哒"));
        contacts.add(new ContactModel("叹气"));
        contacts.add(new ContactModel("南尘"));
        contacts.add(new ContactModel("欢迎关注"));
        contacts.add(new ContactModel("西西"));
        contacts.add(new ContactModel("东南"));
        contacts.add(new ContactModel("成都"));
        contacts.add(new ContactModel("四川"));
        contacts.add(new ContactModel("爱上学"));
        contacts.add(new ContactModel("爱吖校推"));

        Collections.sort(contacts, new LetterComparator());
        return contacts;
    }
}
