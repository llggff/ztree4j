package com.netposa.ztree4j;

import java.util.List;

import com.google.gson.Gson;

/**
 * 树的结点
 * Author: ZhangXiao
 * Created: 2016/9/2
 */
public class TreeNode {

    /**
     * 结点编号
     */
    private Long id;

    /**
     * 结点名称
     */
    private String name;

    /**
     * 是否勾选
     */
    private boolean checked;

    /**
     * 是否禁止勾选
     */
    private boolean chkDisabled;

    /**
     * 是否半选
     */
    private boolean halfCheck;

    /**
     * 是否隐藏
     */
    private boolean hidden;

    /**
     * 是否是父结点
     */
    private boolean parent;

    /**
     * 结点的子结点，如果是父结点，则存在子结点
     */
    private List<TreeNode> children;

    /**
     * 结点点击跳转的地址
     */
    private String url;

    /**
     * 结点点击跳转目标
     */
    private String target;

    /**
     * 结点上的应用数据
     */
    private Object data;

    private TreeNode(Builder builder) {
        this.id = builder.id;
        this.checked = builder.checked;
        this.chkDisabled = builder.chkDisabled;
        this.halfCheck = builder.halfCheck;
        this.hidden = builder.hidden;
        this.parent = builder.parent;
        this.name = builder.name;
        this.url = builder.url;
        this.target = builder.target;
        this.data = builder.data;
        if (this.parent) {
            this.children = builder.children;
        } else {
        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public boolean isChkDisabled() {
        return chkDisabled;
    }

    public boolean isHalfCheck() {
        return halfCheck;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isParent() {
        return parent;
    }

    public String getUrl() {
        return url;
    }

    public String getTarget() {
        return target;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", checked=" + checked +
                ", chkDisabled=" + chkDisabled +
                ", halfCheck=" + halfCheck +
                ", hidden=" + hidden +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                ", data=" + data +
                '}';
    }

    public static final class Builder {
        private Long id;
        private boolean checked;
        private boolean chkDisabled;
        private boolean halfCheck;
        private boolean hidden;
        private boolean parent;
        private List<TreeNode> children;
        private String name;
        private String url;
        private String target;
        private Object data;

        public Builder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public TreeNode build() {
            return new TreeNode(this);
        }

        public Builder checked(boolean checked) {
            this.checked = checked;
            return this;
        }

        public Builder chkDisabled(boolean chkDisabled) {
            this.chkDisabled = chkDisabled;
            return this;
        }

        public Builder halfCheck(boolean halfCheck) {
            this.halfCheck = halfCheck;
            return this;
        }

        public Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public Builder parent(boolean parent) {
            this.parent = parent;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder target(String target) {
            this.target = target;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode.Builder(2L, "jack").build();
        System.out.println(treeNode);

        Gson gson = new Gson();
        System.out.println(gson.toJson(treeNode));
    }
}