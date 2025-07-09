package com.dl.LinkedList;

class Node {
	
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class Insertion {
	
	Node head;
	
	public void insertAtBeginning(int value) {
		Node node = new Node(value);
		node.next = head;
		head=node;
	}
	public void insertAtEnd(int value) {
		
		Node node = new Node(value);
		
		if(head==null) {
			head = node;
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
			System.out.println(temp.data+ "->");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		
		Insertion insert = new Insertion();
		insert.insertAtEnd(12);
		insert.insertAtEnd(13);
		insert.insertAtEnd(14);
		insert.insertAtEnd(15);
		
		insert.insertAtBeginning(11);
		insert.insertAtBeginning(10);

		insert.display();
	}
}
