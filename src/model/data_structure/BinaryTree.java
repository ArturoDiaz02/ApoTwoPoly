package model.data_structure;

import java.io.Serializable;

public class BinaryTree<E> implements Serializable {

	private static final long serialVersionUID = 7L;
	private Node<E> head;
	private int size;

	public BinaryTree() {
        head = null;
       	size = 0;
    }
    
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<E> getHead() {
		return this.head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public void add(E e){
		if(head == null){
			head = new Node<E>(e);

		}else{
			add(e, head);
		}
		
	}
	
   	private void add(E e, Node<E> temp){//inversamente

		
		
	}

	  
}


