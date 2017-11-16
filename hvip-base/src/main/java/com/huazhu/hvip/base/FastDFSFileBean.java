package com.huazhu.hvip.base;

/**
 * Created by cmy on 2016/8/18.
 */

/**
 * FastDFSFile处理类
 * 功能：根据业务定制的图片处理逻辑，最小修剪后缩放到比例，或者直接匹配到比例  支持连续切割，同比例连续切割,性能更好
 */
public class FastDFSFileBean {
    private static final long serialVersionUID = -996760121932438618L;

    private String name;

    private byte[] content;

    private String ext;

    private String height;

    private String width;

    private String groupName;

    public FastDFSFileBean(String name, byte[] content, String ext, String groupName) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.groupName = groupName;
    }

    public FastDFSFileBean(String name, byte[] content, String ext, String height,
                           String width, String groupName) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.height = height;
        this.width = width;
        this.groupName = groupName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
