package linkedListOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luck_
 */
public class Node <T extends Comparable<T>> {
     T elemento;
    public Node<T> next;
    public Node<T> previous;

    public Node(T elemento, Node<T> next, Node<T> previous) {
        this.elemento = elemento;
        this.next = next;
        this.previous = previous;
        
    }
    
  

    public T getElemento() {
        return elemento;
    }
    

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    
    public void insert(Node<T> before, Node<T> after) {
		this.previous = before;
		this.next = after;
		if (before != null)
			before.next = this;
		if (after != null)
			after.previous = this;
	}
    
    
    public void remove() {
		if (previous != null)
			previous.next = next;
		if (next != null)
			next.previous = previous;
		next = null;
		previous = null;
	}
    

     
}
