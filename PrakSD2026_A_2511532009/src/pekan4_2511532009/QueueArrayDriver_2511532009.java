package pekan4_2511532009;

public class QueueArrayDriver_2511532009 {

	public static void main(String[] args) {
		QueueArray_2511532009 queue_2009 = new QueueArray_2511532009(1000);
		queue_2009.enqueue_2009(10);
		queue_2009.enqueue_2009(20);
		queue_2009.enqueue_2009(30);
		queue_2009.enqueue_2009(40);
		System.out.println("Item didepan "+ queue_2009.front_2009());
		System.out.println("Item paling belakang " + queue_2009.rear_2009());
		System.out.println("Tampilakn Queue");
		queue_2009.display();
		System.out.println();
		System.out.println(queue_2009.dequeue_2009() + " dihapus dari queue");
		System.out.println("Item didepan: " + queue_2009.front_2009());
		System.out.println("Item dibelakang: " + queue_2009.rear_2009());
		System.out.println("Tampilan queue setelah satu data dihapus");
		queue_2009.display();
		

	}

}
