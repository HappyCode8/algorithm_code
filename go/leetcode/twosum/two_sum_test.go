package twosum

//每个单元测试都必须导入testing包，一般测试文件的命名是被测文件_test.go
import (
	"fmt"
	"testing"
)

func Test_twoSum(t *testing.T) {
	nums := []int{2, 7, 11, 15}
	fmt.Println(twoSum(nums, 9))

	nums2 := []int{1, 2, 3, 4}
	fmt.Println(twoSum(nums2, 6))
}
