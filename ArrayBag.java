/**
 * A class of bags whose entries are stored in a fixed-size array. INITIAL,
 * INCOMPLETE DEFINITION; no security checks
 * 
 * @author npokhrel
 */

public class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberofEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a desired capacity. */
	public ArrayBag(int desiredCapacity) {
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
		bag = tempBag;
		numberofEntries = 0;
		integrityOK = true;
	} // end constructor

	@Override
	public int getCurrentSize() {
		return numberofEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberofEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		boolean result = true;
		if (isArrayFull()) {
			return false;
		} else {
			bag[numberofEntries] = newEntry;
			numberofEntries++;
		}
		return result;
	}

	private boolean isArrayFull() {
		return numberofEntries >= bag.length;
	}

	@Override
	public T remove() {
		T result = removeEntry(numberofEntries - 1);
		return result;
	}

	private T removeEntry(int index) {
		T result = null;
		if (!isEmpty() && index >= 0) {
			result = bag[index];
			int lastIndex = numberofEntries - 1;
			bag[index] = bag[lastIndex];
			bag[lastIndex] = null;
			numberofEntries--;
		}
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;
		while (!found && (index < numberofEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		return where;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			remove();
		}

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for (int index = 0; index < numberofEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			}
		}
		return counter;
	}


	@Override
	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean found = false;
		int index = 0;
		while (!found && (index < numberofEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
			} // end if
			index++;
		} // end while
		return found;

	}

	private void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException(" ArrayBag object is corrupt.");
	}


	@Override
	public T[] toArray() {
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberofEntries]; // Unchecked cast
		for (int index = 0; index < numberofEntries; index++) {
			result[index] = bag[index];
		} // end for loop
		return result;

	}

}
