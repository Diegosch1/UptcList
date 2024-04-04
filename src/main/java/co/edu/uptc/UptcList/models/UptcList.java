package co.edu.uptc.UptcList.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class UptcList<T> implements List<T> {

    private Node<T> header = null;
    private int size = 0;

    @Override
    public boolean add(T info) {

        Node<T> temporal = new Node<T>();
        temporal.setInfo(info);
        temporal.setNext(null);

        if (header == null) {
            header = temporal;
            size++;
            return true;
        } else {
            Node<T> lastOne = header;
            while (lastOne.getNext() != null) {
                lastOne = lastOne.getNext();
            }

            lastOne.setNext(temporal);
            size++;
            return true;
        }
    }

    public void show() {
        Node<T> helper = header;
        while (helper != null) {
            System.out.println(helper.getInfo());
            helper = helper.getNext();
        }
    }

    public Node<T> getHeader() {
        return header;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        Node<T> aux = header;
        if (aux != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> aux = header;

        if (o == null) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (aux.getInfo().equals(o)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIteratorUptc();
    }

    @Override
    public Object[] toArray() {
        try {
            Object[] aux = new Object[this.size];

            for (int i = 0; i < this.size; i++) {
                aux[i] = this.get(i);
            }
            return aux;
        } catch (ArrayStoreException e) {
            throw new ArrayStoreException(
                    "The runtime type of the array is not a supertype on every element on the list");
        } catch (NullPointerException e) {
            throw new NullPointerException("The defined array is null");
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public boolean remove(Object o) {
        try {
            Node<T> previousNode = header;
            Node<T> targetNode = this.findNode(o);
            Node<T> nextNode;
            // First object validation
            if (targetNode.equals(header)) {
                nextNode = targetNode.getNext();
                header = nextNode;
                size--;
                return true;
            }

            for (int i = 0; i < this.size; i++) {
                if ((previousNode.getNext()).equals(targetNode)) {
                    nextNode = previousNode.getNext().getNext();
                    previousNode.setNext(nextNode);
                    size--;
                    return true;
                }
                previousNode = previousNode.getNext();
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        size = 0;
        header = null;
    }

    @Override
    public T get(int index) {
        try {
            if (index < 0) {
                throw new IndexOutOfBoundsException("There is not such an object with that index");
            }
            Node<T> aux = header;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux.getInfo();

        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("There is not such an object with that index");
        }
    }

    @Override
    public T set(int index, T element) {
        try {
            Node<T> targetNode = this.findNode(index);
            if (targetNode == null) {
                throw new IndexOutOfBoundsException("There is not such an object with that index");
            }
            targetNode.setInfo(element);
            return targetNode.getInfo();
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Invalid index");
        } catch (NullPointerException e) {
            throw new NullPointerException("Null object");
        }
    }

    @Override
    public void add(int index, T element) {
        try {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("The indicated index is invalid");
            }

            if (index == 0) {
                Node<T> newNode = new Node<>();
                newNode.setInfo(element);
                newNode.setNext(header);
                header = newNode;
                size++;
            } else {
                Node<T> aux = header;
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getNext();
                }

                Node<T> holder = new Node<>();
                holder.setInfo(element);
                holder.setNext(aux.getNext());
                aux.setNext(holder);
                size++;
            }
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("The indicated index is invalid");
        }
    }

    @Override
    public T remove(int index) {
        Node<T> previousNode;
        Node<T> targetNode = this.findNode(index);
        Node<T> nextNode;

        // first element validation
        if (index == 0) {
            header = header.getNext();
            size--;
        } else if (index == this.size - 1) { // last element validation
            previousNode = this.findNode(index - 1);
            previousNode.setNext(null);
            size--;
        } else { // mid-elements
            previousNode = this.findNode(index - 1);
            nextNode = this.findNode(index + 1);
            previousNode.setNext(nextNode);
            size--;
        }

        T removedElement = targetNode.getInfo();
        return removedElement;
    }
    @Override
    public int indexOf(Object o) {
        try {
            Node<T> aux = header;
            T result = (T) o;
            for (int i = 0; aux != null; i++) {
                if (aux.getInfo() == result) {
                    return i;
                }
                aux = aux.getNext();
            }
            throw new NullPointerException("The indicated Object is not registered");

        } catch (NullPointerException e) {
            throw new NullPointerException("The indicated Object is not registered");
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            Node<T> aux = header;
            T result = (T) o;
            int position = -1;
            for (int i = 0; aux != null; i++) {
                if (aux.getInfo() == result) {
                    position = i;
                }
                aux = aux.getNext();
            }
            if (position == -1) {
                throw new NullPointerException("The indicated Object is not registered");
            }
            return position;

        } catch (NullPointerException e) {
            throw new NullPointerException("The indicated Object is not registered");
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIteratorUptc();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIteratorUptc();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    public Node<T> findNode(int index) {
        try {
            if (index < 0 || index > this.size()) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            Node<T> aux = header;
            for (int i = 0; i < index; i++) {
                aux = aux.getNext();
            }
            return aux;
        } catch (NullPointerException e) {
            throw new NullPointerException("Null mf");
        }
    }

    public Node<T> findNode(Object o) {
        Node<T> aux = header;
        try {
            for (int i = 0; i < this.size; i++) {
                if (aux.getInfo().equals(o)) {
                    return aux;
                }
                aux = aux.getNext();
            }
            throw new NullPointerException("No such object on list");
        } catch (NullPointerException e) {
            throw new NullPointerException("No such object on list");
        }
    }

    private class ListIteratorUptc implements ListIterator<T> {
        
        private Node<T> aux = header;
        private int index = -1;

        @Override
        public boolean hasNext() {
            return aux!=null;
        }

        @Override
        public T next() {
            try{
                if (!hasNext()) {                    
                    throw new NoSuchElementException("No hay un elemento siguiente del mismo");
                }
                T info = aux.getInfo();
                aux = aux.getNext();    
                index++;                     
                return info;
            } catch (Exception e){
                throw new NullPointerException("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasPrevious'");
        }

        @Override
        public T previous() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'previous'");
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }

        @Override
        public void set(T e) {
            Node<T> aux = findNode(index);
            if (aux != null) {
                aux.setInfo(e);
            }
        }

        @Override
        public void add(T e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }

    }

}