package map;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
	private Node<K, V> root;
	private int size;

	public TreeMap() {
		root = null;
		size = 0;
	}

	@Override
	public boolean containsKey(K key) {
		if (root == null) {
			return false;
		}

		return root.findKey(key);
	}

	@Override
	public boolean containsValue(V value) {
		if (root == null) {
			return false;
		}

		return root.findValue(value);
	}

	@Override
	public V get(K key) {
		if (root == null) {
			return null;
		}

		return root.getValue(key);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			root = new Node<K, V>(key, value);
			size = 1;
			return null;
		}

		V oldValue = root.putNode(key, value);
		if (oldValue == null) {
			size += 1;
		}
		return oldValue;
	}

	@Override
	public V remove(K key) {
		if (root == null) {
			return null;
		}

		return root.removeNode(key);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (root == null) {
			return "";
		}

		return root.toString();
	}

	private class Node<Key extends Comparable<Key>, Value> {
		private Key k;
		private Value v;
		private Node<Key, Value> parent;
		private Node<Key, Value> left;
		private Node<Key, Value> right;

		public Node(Key k, Value v) {
			this.k = k;
			this.v = v;

			parent = null;
			left = null;
			right = null;
		}

		public Node(Key k, Value v, Node<Key, Value> parent) {
			this.k = k;
			this.v = v;

			this.parent = parent;
			left = null;
			right = null;
		}

		public boolean findKey(Key k) {
			if (k.compareTo(this.k) == 0) {
				return true;
			}

			if (left != null && k.compareTo(this.k) < 0) {
				return left.findKey(k);
			}

			if (right != null) {
				return right.findKey(k);
			}

			return false;
		}

		public boolean findValue(Value v) {
			if (v.equals(this.v)) {
				return true;
			}

			if (left != null && left.findValue(v)) {
				return true;
			}

			if (right != null && right.findValue(v)) {
				return true;
			}

			return false;
		}

		public Value getValue(Key k) {
			if (k.compareTo(this.k) == 0) {
				return this.v;
			}

			if (left != null && k.compareTo(this.k) < 0) {
				return left.getValue(k);
			}

			if (right != null) {
				return right.getValue(k);
			}

			return null;
		}

		public Value putNode(Key k, Value v) {
			if (k.compareTo(this.k) == 0) {
				Value oldValue = this.v;
				this.v = v;
				return oldValue;
			}

			if (k.compareTo(this.k) < 0) {
				if (left != null) {
					return left.putNode(k, v);
				}

				left = new Node<Key, Value>(k, v, this);
				return null;
			}

			if (right != null) {
				return right.putNode(k, v);
			}

			right = new Node<Key, Value>(k, v, this);
			return null;
		}

		public Value removeNode(Key k) {
			if (k.compareTo(this.k) == 0) {
				if (left == null && right == null) {
					if (parent == null) {
						removeRoot();
					} else {
						parent.removeMe(this);
					}
				} else if (left != null && right == null) {
					if (parent == null) {
						removeRoot(left);
					} else {
						parent.removeMe(this, left);
					}
				} else if (left == null && right != null) {
					if (parent == null) {
						removeRoot(right);
					} else {
						parent.removeMe(this, right);
					}
				} else {
					Node<Key, Value> replacement = right.findNextNode();
					replacement.setLeft(left);
					if (parent == null) {
						removeRoot(replacement);
					} else {
						parent.removeMe(this, replacement);
					}
				}

				return v;
			}

			if (left != null && k.compareTo(this.k) < 0) {
				return left.removeNode(k);
			}

			if (right != null) {
				return right.removeNode(k);
			}

			return null;
		}

		private void removeMe(Node<Key, Value> node) {
			if (node == left) {
				left = null;
			} else {
				right = null;
			}
		}

		private void removeRoot() {
			root = null;
		}

		private void removeMe(Node<Key, Value> node, Node<Key, Value> replacement) {
			if (node == left) {
				left = replacement;
			} else {
				right = replacement;
			}
		}

		@SuppressWarnings("unchecked")
		private void removeRoot(Node<Key, Value> replacement) {
			root = (TreeMap<K, V>.Node<K, V>) replacement;
		}

		private Node<Key, Value> findNextNode() {
			if (left == null) {
				return this;
			}

			return left.findNextNode();
		}

		public void setLeft(Node<Key, Value> left) {
			this.left = left;
		}

		public String toString() {
			return k + "->" + v + (left != null ? " (" + left.toString() + ")" : " ()")
					+ (right != null ? " (" + right.toString() + ")" : " ()");
		}
	}
}
