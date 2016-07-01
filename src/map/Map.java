package map;

/**
 * @author ploskov
 */
public interface Map<K, V> {
	/**
	 * Returns true if this map contains a mapping for the specified key
	 *
	 * @param key
	 *            - key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key
	 */
	boolean containsKey(K key);

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 *
	 * @param value
	 *            - value whose presence in this map is to be tested
	 * @return true if this map maps one or more keys to the specified value
	 */
	boolean containsValue(V value);

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key.
	 *
	 * @param key
	 *            - the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this
	 *         map contains no mapping for the key
	 */
	V get(K key);

	/**
	 * Returns true if this map contains no key-value mappings.
	 *
	 * @return true if this map contains no key-value mappings
	 */
	boolean isEmpty();

	/**
	 * Associates the specified value with the specified key in this map
	 * (optional operation).
	 *
	 * @param key
	 *            - key with which the specified value is to be associated
	 * @param value
	 *            - value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key. (A null return can also indicate that the map
	 *         previously associated null with key, if the implementation
	 *         supports null values.)
	 */
	V put(K key, V value);

	/**
	 * 
	 * @param key
	 * @return
	 */
	V remove(K key);

	/**
	 * 
	 * @return
	 */
	int size();

	/**
	 * 
	 * @return
	 */
	String toString();
}
