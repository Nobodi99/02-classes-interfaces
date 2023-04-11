package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

	public Element head = null;
	public int size = 0;

	public void add(Object item){

		Element newElem = new Element(item);

		if (head == null){
			head = newElem;
		}
		else {
			Element current = head;
			while (current.next != null){
				current = current.next;
			}
			current.next = newElem;
		}

		size++;
	}

	private static class Element 
	{
		Element next = null;
		Object data = null;

		public Element(Object data)
		{
			this.data = data;
		}	
	}

	public class MyIterator implements Iterator<Element>{
		private Element current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public Element next() {
			Element data = current;
			current = current.next;
			return data;
		}
	}

	@Override
	public Iterator<Element> iterator() {
		return new MyIterator();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public SimpleList filter(SimpleFilter filter) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'filter'");
	}

}
