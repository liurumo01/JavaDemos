package mycollection;

import java.util.Arrays;

public class MyArrayList {
	private Object[] value;
	private int size;

	public MyArrayList() {
		this(10);
	}

	public int size() {
		return size;
	}

	public MyArrayList(int size) {
		if (size < 0) {
			try {
				throw new Exception();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		value = new Object[size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int indexOf(Object obj) {
		if (obj == null) {
			return -1;
		}
		for (int i = 0; i < size; i++) {
			if (obj == value[i]) {
				return i;
			}
		}
		return -1;
	}

	public void add(Object obj) {
		if (size >= value.length) {
			value = Arrays.copyOf(value, value.length * 2 + 2);
		}
		value[size++] = obj;
	}

	public Object get(int index) {
		rangeCheck(index);
		return value[index];
	}

	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object old = value[index];
		value[index] = obj;
		return old;
	}

	public void rangeCheck(int index) {
		if (index < 0 || index > value.length) {
			try {
				throw new Exception();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
