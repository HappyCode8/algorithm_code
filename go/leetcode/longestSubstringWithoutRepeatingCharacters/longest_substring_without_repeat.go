package longestSubstringWithoutRepeatingCharacters

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}
	m := make(map[byte]int)
	max, left := 0, 0
	for i := 0; i < len(s); i++ {
		if _, ok := m[s[i]]; ok {
			left = maxInt(left, m[s[i]]+1)
		}
		m[s[i]] = i
		max = maxInt(max, i-left+1)
	}
	return max
}

// 最多允许有k个不同字符
func lengthOfLongestSubstringKDistinct(s string, k int) int {
	res := 0
	m := make(map[byte]int)
	left := 0
	for i := 0; i < len(s); i++ {
		m[s[i]] = i
		for len(m) > k {
			if m[s[left]] == left {
				delete(m, s[left])
			}
			left++
		}
		res = maxInt(res, i-left+1)
	}
	return res
}

func maxInt(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
