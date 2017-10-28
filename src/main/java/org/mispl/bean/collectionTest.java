package org.mispl.bean;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;

public class collectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	    Deque<String> dq = new ArrayDeque<String>(5);
        dq.add("java");
        dq.add("c");
        dq.add("c++");
        dq.add("unix");
        dq.add("perl");        
       Queue<String> q = Collections.asLifoQueue(dq);   
        System.out.println("returned queue is: "+q);
	}

}
