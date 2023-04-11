package ohm.softa.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

	public Element head = null;
	public int size = 0;

    private static class Element {
        Element next;
        Object data;

        public Element(Object data)
        {
            this.data = data;
        }	
    }

    @Override
	public Iterator<Object> iterator() {
		return new MyIterator();
	}

    public class MyIterator implements Iterator<Object>{
        public Element current = head;
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Object next() {
            Element elem = current;
            current = current.next;
            return elem.data;
        }
    }   

	public void add(Object item){
		if (head == null){
			head = new Element(item);
		}
		else {
			Element current = head;
			while (current.next != null){
				current = current.next;
			}
			current.next = new Element(item);
		}

		size++;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public SimpleList filter(SimpleFilter filter) {
		SimpleList filteredList = new SimpleListImpl();

        for (Object obj : this) {
            if (filter.include(obj)){
                filteredList.add(obj);
            }
        }

        return filteredList;
	}

}
