package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPASITY = 16;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPASITY);
	}

	@Override
	public boolean add(T obj) {
		if (size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(int index, T obj) {
		if (size == array.length) {
			reallocate();
		}
		if (index > -1 && index <= size) {
			System.arraycopy(array, index, array, index + 1, (array.length - 1) - index);
			array[index] = obj;
			size++;
		}

	}

	@Override
	public T remove(int index) {
		T removedObj = null;
		if (index > -1 && index < size) {
			removedObj = array[index];
			System.arraycopy(array, index + 1, array, index, (array.length - 1) - index);
			size--;
		}
		return removedObj;
	}

	@Override
	public T get(int index) {
		T object = null;
		if (index > -1 && index < size) {
			object = array[index];
		}
		return object;
	}

}
