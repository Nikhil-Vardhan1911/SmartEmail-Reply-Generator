package com.dl.one;

class Node {
	
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	Node head;
	
	public void insertAtFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
	}
	public void insertAtLast(int value) {
		Node node = new Node(value);
		
		if(head==null) {
			head= node;
			return;
		}
		
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = node;	
	}
	
	public void display() {
		Node temp = head;
		
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		obj.insertAtLast(20);
		obj.insertAtLast(45);
		obj.insertAtLast(34);
		
		obj.insertAtFirst(10);
		
		obj.display();
	}
}
