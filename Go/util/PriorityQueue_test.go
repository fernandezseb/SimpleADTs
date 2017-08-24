package util

import (
	"fmt"
)

func ExampleQueueIsEmpty() {
	pq := New()
	fmt.Println(pq.IsEmpty())
	// Output: true
}

func ExampleQueueHasSizeZero() {
	pq := New()
	fmt.Println(pq.Size())
	// Output: 0
}

func ExamplePushGivesSizeOne() {
	pq := New()
	pq.Push(10, "hello world")
	fmt.Println(pq.Size())
	// Output: 1
}

func ExamplePushTwoGivesSizeTwo() {
	pq := New()
	pq.Push(10, "hello")
	pq.Push(200, "world")
	fmt.Println(pq.Size())
	// Output: 2
}

func ExamplePushBubblesUp() {
	pq := New()
	pq.Push(3, "hello")
	pq.Push(2, "world")
	fmt.Println(pq.Peek())
	// Output: world <nil>
}

func ExamplePushBubblesUp2() {
	pq := New()
	pq.Push(3, "hello")
	pq.Push(2, "world")
	pq.Push(5, "dag")
	pq.Push(1, "wereld")
	pq.Push(10, "hoi")
	fmt.Println(pq.Peek())
	// Output: wereld <nil>
}

func ExamplePopBubblesDown() {
	pq := New()
	pq.Push(3, "hello")
	pq.Push(2, "world")
	pq.Push(5, "dag")
	pq.Push(1, "wereld")
	pq.Push(10, "oom")
	pq.Pop()
	fmt.Println(pq.Peek())
	// Output: world <nil>
}

func ExamplePopBubblesDown2() {
	pq := New()
	pq.Push(20, "word")
	pq.Push(0, "test")
	pq.Push(3, "hello")
	pq.Push(2, "world")
	pq.Push(5, "dag")
	pq.Push(1, "wereld")
	pq.Push(10, "oom")

	fmt.Println(pq.Pop())
	fmt.Println(pq.Pop())
	fmt.Println(pq.Pop())
	fmt.Println(pq.Pop())
	fmt.Println(pq.Pop())
	fmt.Println(pq.Pop())
	fmt.Println(pq.Pop())

	// Output:
	// test <nil>
	// wereld <nil>
	// world <nil>
	// hello <nil>
	// dag <nil>
	// oom <nil>
	// word <nil>
}

func ExamplePopOnEmptyError() {
	pq := New()
	_, error := pq.Pop()
	fmt.Println(error.Error())
	// Output: Queue is empty
}

func ExamplePeekOnEmptyError() {
	pq := New()
	_, error := pq.Peek()
	fmt.Println(error.Error())
	// Output: Queue is empty
}
