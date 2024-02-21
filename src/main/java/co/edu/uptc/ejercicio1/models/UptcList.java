package co.edu.uptc.ejercicio1.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UptcList<T> implements List<T> {

    private Node<T> header = null; // First node of the linked list
    private int size = 0; // Number of elements in the list

    @Override
    public boolean add(T info) { // add new node at the end of the list

        Node<T> temporal = new Node<T>(); // For temporal, new node created
        temporal.setInfo(info);
        temporal.setNext(null);

        if (header == null) { // if the list is empty, then assign it to the header
            header = temporal;
            size++;
            return true;
        } else {
            Node<T> lastOne = header;
            while (lastOne.getNext() != null) {
                lastOne = lastOne.getNext();
            }

            lastOne.setNext(temporal); // Here add the new node
            size++;
            return true;
        }
    }

    public void show() {
        Node<T> helper = header;
        while (helper != null) {
            System.out.println(helper.getInfo());
            helper = helper.getNext(); // The same, if is not null then equals to the next node
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, T element) {
        try {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("The indicated index is invalid");
            }
            
            if (index == 0) { // Adding at the beginning
                Node<T> newNode = new Node<>();
                newNode.setInfo(element);
                newNode.setNext(header);
                header = newNode;
                size++;
            } else {
                Node<T> aux = header;
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getNext(); // aux becomes the one behind where we want to add
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }

    // New ones
    public Node<T> findNode(int index) {
        Node<T> aux = header;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux;
    }

    public Node<T> findNode(Object o) {
        Node<T> aux = header;

        return aux;
    }

}