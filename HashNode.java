

public class HashNode {
	String key;
	String value;
	HashNode next;
	
	@Override
	public String toString() {
		return "HashNode [key=" + key + ", value=" + value + "]";
	}

	public HashNode(String key, String value){
		this.key = key;
		this.value = value;
		next = null;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HashNode getNext() {
		return next;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}


}

