package linkedListOrder;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lista<Integer> l = new Lista<Integer>();
	
		l.adicionaFirst(2);
		l.adicionaFirst(10);
		l.adicionaFirst(8);
		l.adicionaFirst(20);
		l.adicionaFirst(3);
		l.adicionaFirst(11);
		
		

		System.out.println("Total de elementos: "+l.getTotalDeElementos());

		

		System.out.println();
	
		System.out.println("Lista desordenada:");
		l.printlist(l.first);
		
		l.insertionSort(l.first);
		System.out.println("Lista Ordenada:");
		l.printlist(l.first);
		


	
	}


}
