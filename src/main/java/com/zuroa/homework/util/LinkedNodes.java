package com.zuroa.homework.util;

/**
 * Created by scnyig on 9/12/2017.
 */
public class LinkedNodes {
    private LinkedNode head = null;
    private LinkedNode tail = null;
    public LinkedNodes(LinkedNode node) {
        this.head = node;
        this.tail = node;
    }

    public void add(String url) {
        LinkedNode node = new LinkedNode(url);
        this.tail.next = node;
        this.tail = node;
    }

    public LinkedNode getHead() {
        return head;
    }

    public LinkedNode getTail() {
        return tail;
    }
    public void setHead(LinkedNode head) {
        this.head = head;
    }

    public void add(LinkedNode next) {
        this.tail.next = next;
        this.tail = next;
    }
}
