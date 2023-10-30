package Task2;

import java.util.NoSuchElementException;

public class LinkedList {
	public class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	public class SinglyLinkedList<E> {
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size;

		public SinglyLinkedList() {
			super();
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public E first() {
			if (isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
			return head.data;
		}

		public E last() {
			if (isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
			return tail.data;
		}

		public void addFirst(E e) {
			Node<E> newest = new Node<>(e);

			if (isEmpty()) {
				head = newest;
				tail = newest;
			} else {
				newest.next = head;
				head = newest;
			}
			size = size + 1;
		}

		public void addLast(E e) {
			Node<E> newest = new Node<>(e);

			if (isEmpty()) {
				head = newest;
				tail = newest;
			} else {
				newest.next = null;
				tail.next = newest;
				tail = newest;
			}
			size = size + 1;
		}

		public E removeFirst() {
			if (isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}
			E firstRemove = head.data;
			head = head.next;
			size = size - 1;
			return firstRemove;
		}

		public E removeLast() {
			if (isEmpty()) {
				throw new NoSuchElementException("Danh sach dang trong");
			}

			E lastRemove = tail.data;
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				Node<E> current = head;
				while (current != tail) {
					current = current.next;
				}
				current.next = null;
				tail = current;
			}
			size = size - 1;
			return lastRemove;

		}

	}

	public static void main(String[] args) {
		LinkedList linkList = new LinkedList();
		LinkedList.SinglyLinkedList<Integer> list = linkList.new SinglyLinkedList<>();
		list.addFirst(4);
		list.addLast(5);
		list.addFirst(3);
		list.addLast(10);
		list.addFirst(9);
		list.addLast(1);

		System.out.println("Kich thuoc danh sach:" + list.size());
		System.out.println("Phan tu dau tien cua danh sach:" + list.first());
		System.out.println("Phan tu cuoi cung cua danh sach:" + list.last());
		System.out.println("Xoa phan tu dau tien trong danh sach:" + list.removeFirst());
		System.out.println("Xoa phan tu cuoi cung trong danh sach: " + list.removeLast());
	}

}
