public class Hashtable {

	HashNode[] hashtable;
	int numBuckets;
	int size;

	public Hashtable() {
		numBuckets = 10;
		size = 0;
		hashtable = new HashNode[numBuckets];
	}

	private int getBucketIndex(String key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		return index;
	}

	public void put(String key, String val) {
		int bucketIndex = getBucketIndex(key);

		HashNode head = hashtable[bucketIndex];

		while (head != null) {
			if (head.key.equals(key)) {
				head.value = val;
				return;
			}
			head = head.next;
		}
		size++;
		head = hashtable[bucketIndex];
		HashNode newNode = new HashNode(key, val);
		newNode.next = head;
		hashtable[bucketIndex] = newNode;

		if ((1.0 * size) / numBuckets >= 0.7) {
			HashNode[] temp = hashtable;

			numBuckets = 2 * numBuckets;
			size = 0;
			hashtable = new HashNode[numBuckets];
			for (HashNode headNode : temp) {
				while (headNode != null) {
					put(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}

	}

	public Object get(String key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = hashtable[bucketIndex];

		while (head != null) {
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}
		return null;

	}

	public String remove(String key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = hashtable[bucketIndex];

		HashNode prev = null;
		while (head != null) {
			if (head.key.equals(key))
				break;
			prev = head;
			head = head.next;
		}

		if (head == null)
			return null;

		size--;

		if (prev != null)
			prev.next = head.next;
		else
			hashtable[bucketIndex] = head.next;

		return head.value;

	}

	public boolean containsKey(String key) {
		int bucketIndex = getBucketIndex(key);
		HashNode head = hashtable[bucketIndex];

		while (head != null) {
			if (head.value.equals(key)) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

}
