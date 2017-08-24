package util

import (
	"errors"
	"math"
)

type item struct {
	Priority int
	Data     interface{}
}

type PriorityQueue struct {
	items []*item
}

func New() *PriorityQueue {
	q := new(PriorityQueue)

	q.items = append(q.items, new(item))

	return q
}

func (q *PriorityQueue) Size() int {
	return len(q.items) - 1
}

func (q *PriorityQueue) IsEmpty() bool {
	return q.Size() == 0
}

func (q *PriorityQueue) Peek() (interface{}, error) {
	if q.IsEmpty() {
		return nil, errors.New("Queue is empty")
	}

	return q.items[1].Data, nil
}

func (q *PriorityQueue) Pop() (interface{}, error) {
	if q.IsEmpty() {
		return nil, errors.New("Queue is empty")
	}

	next := q.items[1].Data

	swapItems(q.items[1], q.items[len(q.items)-1])
	// Delete the last element
	q.items = q.items[:len(q.items)-1]
	q.bubbleDown(1)

	return next, nil
}

func (q *PriorityQueue) Push(priority int, value interface{}) {
	item := new(item)
	item.Data = value
	item.Priority = priority

	q.items = append(q.items, item)
	q.bubbleUp(len(q.items) - 1)
}

func swapItems(l *item, r *item) {
	value := l.Data
	l.Data = r.Data
	r.Data = value

	prio := l.Priority
	l.Priority = r.Priority
	r.Priority = prio
}

func (q *PriorityQueue) bubbleDown(current int) {
	leftIndex := current * 2
	rightIndex := current*2 + 1

	if leftIndex < len(q.items) {
		if q.items[leftIndex].Priority < q.items[current].Priority {
			swapItems(q.items[current], q.items[leftIndex])
		}
		q.bubbleDown(leftIndex)
	}

	if rightIndex < len(q.items) {
		if q.items[rightIndex].Priority < q.items[current].Priority {
			swapItems(q.items[current], q.items[rightIndex])
		}
		q.bubbleDown(rightIndex)
	}
}

func (q *PriorityQueue) bubbleUp(index int) {
	current := q.items[index]
	i := int(math.Floor(float64(index) / 2.0))

	if i >= 1 {
		if current.Priority < q.items[i].Priority {
			swapItems(current, q.items[i])
			q.bubbleUp(i)
		}
	}
}
