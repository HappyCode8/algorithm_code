package twosum

//每个单元测试都必须导入testing包，一般测试文件的命名是被测文件_test.go
import (
	"github.com/bytedance/mockey"
	"github.com/smartystreets/goconvey/convey"
	"testing"
)

func Test_twoSum(t *testing.T) {
	mockey.PatchConvey("test", t, func() {
		mockey.PatchConvey("testdata case1", func() {
			nums := []int{2, 7, 11, 15}
			target := 9
			got := twoSum(nums, target)
			//断言方法
			convey.So(got, convey.ShouldResemble, []int{0, 1})
		})

		mockey.PatchConvey("testdata case2", func() {
			nums := []int{1, 2, 3, 4}
			target := 6
			got := twoSum(nums, target)
			//断言方法
			convey.So(got, convey.ShouldResemble, []int{1, 3})
		})
	})
}
