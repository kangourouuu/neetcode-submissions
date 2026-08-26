func hasDuplicate(nums []int) bool {
    duplicated := make(map[int]bool) // empty map
	for _, num := range nums { // loop array
		// put value to map
		if duplicated[num] {
			return true
		}
		duplicated[num] = true
	}
	return false
}
