public class ITIStringBuffer {

	private SinglyLinkedList<String> list;
	private boolean isReady;
	private String  stringVersion;
	private int size;
    
    public ITIStringBuffer() {
    	this("");
    }

    public ITIStringBuffer(String  firstString){
    	list = new SinglyLinkedList<String>();
    	isReady = false;
    	int size = 0;
    	append(firstString);
    }

    public void append(String nextString){
    	if(nextString == null) {
    		throw new NullPointerException("Cannot have null references in ITI1121StringBuffer");
    	}
    	if(nextString.length() > 0) {
 			list.add(nextString);
 			isReady = false;
 			size += nextString.length();
    	}
    }

    public String toString(){
    	if(!isReady) {
    		char[] temp = new char[size];
    		int cursor = 0;
    		for(String s:list){
    			addToArray(temp, s, cursor);
    			cursor += s.length();
    		}
    		stringVersion = new String(temp);
    		isReady = true;
    	}
    	return stringVersion;
    }

    private void addToArray(char[] temp, String s, int start){
    	char[] c = s.toCharArray();
    	for(int i =0; i < c.length; i++) {
    		temp[start+i] = c[i];
    	} 
    }
 
}
