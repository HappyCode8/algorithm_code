package twosum

func twoSum(nums []int, target int) []int {
	//定义一个map
	m := make(map[int]int)
	//遍历nums的<位置i，值num>
	for i, num := range nums {
		//在map中找有没有对应的值
		if idx, ok := m[target-num]; ok {
			//先返回idx，再返回当前值
			return []int{idx, i}
		}
		m[num] = i
	}
	return nil
}
