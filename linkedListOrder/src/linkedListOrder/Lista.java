package linkedListOrder;

import java.util.Iterator;

public class Lista <T extends Comparable<T>>  implements Iterable<T>{//lista interface
    
    public Node <T> first;
    public Node <T> last;
    Node <T> sorted;
    private int totalDeElementos;
     
    
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Node <T> getNode(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posi��o n�o existe");
        }

        Node<T> atual = first;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getNext();
        }
        return atual;
    }
    
    
    public void printlist(Node<T> first) 
    {
        while (first != null) 
        {
            System.out.print(first.elemento + " ");
            first = first.next;
        }
    }
    
    public T getPosNode(int posicao) {
        return this.getNode(posicao).getElemento();
    }
    public void adicionaFirst(T elemento){
      
        if(this.totalDeElementos == 0){
            Node<T> newNode = new Node<T>(elemento, this.first, null);
            this.first = newNode;
            this.last = newNode;
        }else{
         Node<T> newNode = new Node<T>(elemento, this.first, null);
            this.first.setPrevious(newNode); 
            this.first = newNode;
        }
                this.totalDeElementos++;
                
    }

    public void adicionaLast(T elemento){
        if(totalDeElementos == 0){
            adicionaFirst(elemento);
        }else{
                
        Node<T> newNode = new Node<T>(elemento, null, null);
        this.last.setNext(newNode);
        newNode.setPrevious(this.last);
        this.last = newNode;
        this.totalDeElementos++;
        }
        
    }
    
    public void adicionaNapos(int pos, T elemento) {
        if (pos == 0) { // No come�o.
            this.adicionaFirst(elemento);
        } else if (pos == this.totalDeElementos) { // No fim.
            this.adicionaLast(elemento);
        } else {
            Node<T> anterior = this.getNode(pos - 1);
            Node<T> proxima = anterior.getNext();
            Node<T> nova = new Node<T>(elemento, anterior.getNext(), null);
            nova.setPrevious(anterior);
            anterior.setNext(nova);
            proxima.setPrevious(nova);
            this.totalDeElementos++;
        }
    }
    
    
    public void removeFirst() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posi��o n�o existe");
        }

        this.first = this.first.getNext();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.first = null;
            this.last = null;
        }
    }
    
    public void removeLast() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posi��o n�o existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeFirst();
        } else {
            Node <T> penultima = this.last.getPrevious();
            penultima.setNext(null);
            this.last = penultima;
            this.totalDeElementos--;
        }
    }
    

    public int getTotalDeElementos() {
        return totalDeElementos;
    }

    public void setTotalDeElementos(int totalDeElementos) {
        this.totalDeElementos = totalDeElementos;
    }
 

    public void remove(int pos) {
        if (pos == 0) {
            this.removeFirst();
        } else if (pos == this.totalDeElementos - 1) {
            this.removeLast();
        } else {
            Node<T> anterior = this.getNode(pos - 1);
            Node<T> atual = anterior.getNext();
            Node<T> proxima = atual.getNext();

            anterior.setNext(proxima);
            proxima.setPrevious(anterior);
            this.totalDeElementos--;
        }
  
  }
  public int tamanho() {return 0;}
  public boolean contem(T o) {return false;}
  


/*  Referencia de insert sort//
  public void sort(Comparator <T> cmp) {
		if (first == null) return;
		Node novo = first.next;
		while (novo != null) {
			Node current = novo.previous, next = novo.next;
			while (current!=null && cmp.compare((T)current.elemento, (T) novo.elemento) > 0)
				current = current.previous;
			// swap nodes
			swapNodes(novo, current);
			novo = next;
		}
	}
  
  private void swapNodes(Node<T> novo, Node <T>current) {
		if (current != null && current.next == novo)
			return;
		Node <T> previous = novo.previous;
		Node <T> next = novo.next;
		previous.next = next;
		// remove novo
		if (novo == last)
			last = previous;
		novo.remove();
		// Insere depois do current.
		if (current != null) {
			novo.insert(current,current.next);
		} else {
			novo.insert(null,first);
			first = novo;
		}
	}
 */

  //insert Sort 
  public void insertionSort(Node<T> head) 
  {
      // Inicializa node
      sorted = null;
      Node <T> current = first;

      // Node para ordenar
      while (current != null) 
      {
          // Store next for next iteration
          Node <T> next = current.next;
          // inserir Node atual na lista sort
          sortedInsert(current);
          // Atualiza current
          current = next;
      }
      // Update atualiza o ponteiro First 
      first = sorted;
  }


  public void sortedInsert(Node <T> newnode) 
  {
     //Special case for the head end 
      if (sorted == null || sorted.elemento.compareTo((T)newnode.elemento)<=0 ) //Compara dois elementos
      {
    	  System.out.println("aconteceu alguma coisa\n");
          newnode.next = sorted;
          sorted = newnode;
      }
      else
      {
          Node <T> current= sorted;


          //localiza o node depois do ponteiro de insercao e reinsere
          while (current.next != null && current.next.elemento.compareTo((T)newnode.elemento)>0)  //Compara dois elementos
          {
              current = current.next;
          }
          newnode.next = current.next;
          current.next = newnode;
      }
  }

@Override
public Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return null;
}
}
