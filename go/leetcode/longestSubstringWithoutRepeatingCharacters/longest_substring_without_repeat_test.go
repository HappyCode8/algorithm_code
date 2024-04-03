package longestSubstringWithoutRepeatingCharacters

import (
	"github.com/bytedance/mockey"
	"github.com/smartystreets/goconvey/convey"
	"testing"
)

func Test_lengthOfLongestSubstring(t *testing.T) {
	mockey.PatchConvey("test", t, func() {
		mockey.PatchConvey("testdata case1", func() {
			res := lengthOfLongestSubstring("abcabcbb")
			convey.So(res, convey.ShouldResemble, 3)
		})

		mockey.PatchConvey("testdata case2", func() {
			res := lengthOfLongestSubstring("bbbbb")
			convey.So(res, convey.ShouldResemble, 1)
		})

		mockey.PatchConvey("testdata case3", func() {
			res := lengthOfLongestSubstring("pwwkew")
			convey.So(res, convey.ShouldResemble, 3)
		})

		mockey.PatchConvey("testdata case4", func() {
			res := lengthOfLongestSubstring("")
			convey.So(res, convey.ShouldResemble, 0)
		})
	})
}

func Test_lengthOfLongestSubstringKDistinct(t *testing.T) {
	mockey.PatchConvey("test", t, func() {
		mockey.PatchConvey("testdata case1", func() {
			res := lengthOfLongestSubstringKDistinct("abcabcbb", 1)
			convey.So(2, convey.ShouldResemble, res)
		})
	})
}
