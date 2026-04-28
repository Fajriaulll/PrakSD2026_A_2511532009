package pekan4_2511532009;

public class QueueArray_2511532009 {
	int front_2009, rear_2009, size_2009;
	int capacity_2009;
	int array_2009[];
	
	public QueueArray_2511532009(int capacity_2009) {
		this.capacity_2009 = capacity_2009;
		front_2009 = this.size_2009 = 0;
		rear_2009 = capacity_2009 -1;
		array_2009 = new int[this.capacity_2009];
	}
	
	boolean isFull_2511532009 (QueueArray_2511532009 queue_2009) {
		return (queue_2009.size_2009 == queue_2009.capacity_2009);
	}
	
	boolean isEmpty_2511532009 (QueueArray_2511532009 queue_2009) {
		return (queue_2009.size_2009 == 0);
	}
	
	void enqueue_2009 (int item_2009) {
		if (isFull_2511532009(this))
			return;
		this.rear_2009 = (this.rear_2009 + 1) % this.capacity_2009;
		this.array_2009[this.rear_2009] = item_2009;
		this.size_2009 = this.size_2009 + 1;
		System.out.println(item_2009 + " enqueued to queue");
	}
	
	int dequeue_2009() {
		if (isEmpty_2511532009(this))
			return Integer.MIN_VALUE;
		int item_2009 = this.array_2009[this.front_2009];
		this.front_2009 = (this.front_2009 + 1) % this.capacity_2009;
		this.size_2009 = this.size_2009 - 1;
		return item_2009;
	}
	int front_2009 () {
		if (isEmpty_2511532009(this))
			return Integer.MIN_VALUE;
		return this.array_2009[this.front_2009];
	}
	int rear_2009() {
		if (isEmpty_2511532009(this)) 
			return Integer.MIN_VALUE;
		return this.array_2009[this.rear_2009];
	}
	
	//mencetak elemen antrian
	void display () {
		int i_2009;
		if (front_2009 == rear_2009) {
			System.out.println("\nAntrian Kosong|n");
			return;
		}
		//kunjungi dari belakang dan cetak
		for (i_2009 = front_2009; i_2009 < rear_2009; i_2009++) {
			System.out.printf(" %d <-- ", array_2009[i_2009]);
		}
		return;
	}

}
