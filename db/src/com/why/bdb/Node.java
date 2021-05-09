package com.why.bdb;

import java.util.Objects;

/**
 * 该节点是双向循环链表的扩展，就要形成网型数据机构，这样就可以作无限关联了
 */
public class Node {

    /**
     * 根节点，子节点的关联
     */
    private Node root;

    /**
     * 头节点，但是遍历的时候不是从头节点开始的，而是尾，因为这是模仿人的记忆，我们往往是先想起
     * 最近发生的事情，而最新的都是放在尾部的
     */
    private Node head;

    /**
     * 尾节点，循环链表尾
     */
    private Node tail;

    /**
     * 循环链表前驱
     */
    private Node pre;

    /**
     * 循环链表的后继
     */
    private Node next;

    /**
     * 属性，决定节点的遍历的顺序，就像人一样刚刚发生先想起
     */
    private long property;

    /**
     * 节点数据
     */
    private Object data;

    /**
     * 数据的类型
     */
    private int type;

    /**
     * 节点名称
     */
    private String name;

    public Node(Object data) {
        this.data = data;
    }

    public Node() {
    }

    /**
     * 根据传入的数据创建node并与当前节点做关联，即插入根的双向循环链表中
     *
     * @param data
     * @return
     */
    public long connect(Object data) {
        Node node = new Node(data);
        return connect(node);
    }

    /**
     * 把node插入双向循环链表中
     *
     * @param node
     * @return
     */
    public long connect(Node node) {
        long nodeProperty = System.currentTimeMillis();
        node.root = this;
        node.property = nodeProperty;
        if (Objects.isNull(head)) {
            head = node;
            tail = node;
            node.pre = node;
            node.next = node;
        } else {
            //把新的节点插入链表的首尾
            node.pre = tail;
            tail.next = node;
            node.next = head;
            head.pre = node;
        }
        return nodeProperty;
    }

    /**
     * 获取最近数据
     *
     * @return
     */
    public Object getLastedData() {
        return tail.data;
    }

    public Node getNodeByName(String name) {
        Node p = head;
        while (true) {
            if (name.equals(p.getName()))
                return p;
            if (tail == p)
                return null;
            p = p.next;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public Node getHead() {
        return head;
    }
}
