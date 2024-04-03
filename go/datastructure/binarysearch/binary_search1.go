package binarysearch

func binarySearch(nums []int, x int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == x {
			return mid
		} else if nums[mid] < x {
			left = left + 1
		} else {
			right = right - 1
		}
	}
	return -1
}
