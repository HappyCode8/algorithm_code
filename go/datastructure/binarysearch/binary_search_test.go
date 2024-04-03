package binarysearch

import (
	"fmt"
	"github.com/bytedance/mockey"
	"github.com/smartystreets/goconvey/convey"
	"regexp"
	"testing"
)

func TestBinarySearch(t *testing.T) {
	numbers := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
	mockey.PatchConvey("TestBinarySearch", t, func() {
		mockey.PatchConvey("case1", func() {
			index := binarySearch(numbers, 7)
			convey.So(index, convey.ShouldResemble, 6)
		})

		mockey.PatchConvey("case2", func() {
			index := binarySearch(numbers, 11)
			convey.So(index, convey.ShouldResemble, -1)
		})
	})
}

func TestIt(t *testing.T) {
	// jsonStr := `{"gashapon_custom_info":{},"common_config":{"lottery_config":{"lottery_id":7317157653422051347},"play_limit":{"limit_type":0,"play_cost":1,"cost_type":0},"share_config":{"title":"test","desc":"test","share_url_type":0,"share_url":"","pic_url":"https://p6-dcd.byteimg.com/img/motor-img/b5a637b659b36ea3bea5d66859c6246e~300x300.image","share_guide_type":0,"share_guide_pic":"","share_pic_breath":0,"extra":"","show_share":1},"custom":"{\"share_config\":{\"desc\":\"test\",\"title\":\"test\",\"pic_url\":\"https://p6-dcd.byteimg.com/img/motor-img/b5a637b659b36ea3bea5d66859c6246e~300x300.image\",\"share_url_type\":0,\"show_share\":1,\"share_guide_type\":0},\"game_config\":{\"brand_logo\":\"https://p6-dcd.byteimg.com/img/motor-img/cafe5fd27f2b98b61f5b25ace08c63a8~300x300.image\",\"button_text\":\"进入品牌馆\",\"guide_text\":\"活动期间下单和报名成功，即可参与抽奖哦~\",\"activity_title\":\"\",\"inapp_scheme\":\"sslocal://webview?url=https%3A%2F%2Fmotor.bytedance.net%2Fgame%2Fcapsule_machine%2F\u0026back_button_color=white\u0026should_append_common_param=1\u0026enable_resume_pause_js=1\u0026bounce_disable=1\u0026status_bar_color=white\u0026hide_bar=1\u0026hide_status_bar=1\",\"outapp_url\":\"https://motor.bytedance.net/game/capsule_machine/\"},\"page_config\":{\"theme\":{\"theme_id\":\"60a227736f69bf0293d30f19\"},\"custom\":{\"background_image\":\"https://p3.dcarimg.com/img/motor-img/28d457baeadfacbd42b3323a46e868a4~noop.jpg\",\"background_color\":\"#000211\",\"game_background_image\":\"https://p3.dcarimg.com/img/motor-img/1655bd8f634568545e96dc0889d98e08~noop.jpg\",\"game_empty_background_image\":\"https://p3.dcarimg.com/img/motor-img/d3a149884719db8a9a89dff0e0141f4d~noop.jpg\",\"loading_background_image\":\"https://p3.dcarimg.com/obj/motor-img/d7c104260318359302c95e590e28ed94\",\"loading_text_color\":\"#fff\",\"loading_process_background\":\"linear-gradient(to left, #54ccff, #5a00ff)\",\"prize_background\":\"linear-gradient(97deg, #5273ff 4%, #bb20ff 97%)\",\"draw_prize_gif\":\"https://p3.dcarimg.com/obj/motor-img/4fa3c277cbdeaec6a4dc7fcd4828f468\",\"draw_prze_button_image\":\"https://p3.dcarimg.com/obj/motor-img/6dc6f0ffbdca9bb78eb4ec04908b813b\",\"login_button_image\":\"https://p3.dcarimg.com/obj/motor-img/e6cce0e465e2d3cd9ff288cebc561957\",\"draw_prize_video\":\"https://lf3-static.bytednsdoc.com/obj/eden-cn/1ylitbueh7pfuhpanuhf/capsule-machine_2.4.mp4\",\"draw_prize_video_webp\":\"https://lf3-static.bytednsdoc.com/obj/eden-cn/1ylitbueh7pfuhpanuhf/capsule-machine-40.webp\",\"draw_prize_video_poster\":\"https://p3.dcarimg.com/obj/motor-img/a07c2c0b62ee88775258f47225668c5f\",\"close_icon\":\"https://p3.dcarimg.com/obj/motor-img/f8118ff0113183c0f362c05a6b9b3832\",\"ball_background_image\":\"https://p3.dcarimg.com/obj/motor-img/90d46f24a6ab5420013775f7086dac5c\",\"my_prize_background_image\":\"https://p3.dcarimg.com/obj/motor-img/84c548f19faf022c9c2e089e5e86712a\",\"rule_ball_background_image\":\"https://p3.dcarimg.com/obj/motor-img/731b7065aed3b4029c70907aa4c5292e\",\"activity_title_color\":\"#75fbe0\"},\"activity_home\":{\"activity_title_background_image\":\"https://p3.dcarimg.com/obj/motor-img/2aabe4487a9947732a10a368fda0e7bc\",\"kv_title_image\":\"https://p3.dcarimg.com/obj/motor-img/d68d4ec027c65b9c7eff40cffcc75ba8\",\"guide_background_image\":\"https://p3.dcarimg.com/obj/motor-img/7e8d1bea46cc9be935e55a8457507bd7\",\"rule_content\":\"\u003carticle class=\\\"blitz-rich-text\\\"\u003e\u003cp\u003etest\u003c/p\u003e\\n\u003c/article\u003e\"},\"cash_pop_up\":{\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"main_text\":\"恭喜您抽中了\",\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"guide_text\":\"现金红包发放至您的APP-我的钱包\"},\"coupon_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"button_text\":\"立即领取\",\"main_text\":\"恭喜您抽中了\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"guide_text\":\"需点击“立即领取”进行优惠券报名\"},\"real_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"button_text\":\"立即查看\",\"main_text\":\"恭喜您抽中了\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"guide_text\":\"在“我的奖品”中查看实物奖品\"},\"virtual_account_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"main_text\":\"恭喜您抽中了\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"guide_text\":\"虚拟货币已发放\"},\"miss_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"main_text\":\"很遗憾，未中奖\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/9f5c641d18090eb47be333a64cef6c45\",\"guide_text\":\"您离幸运只差一小步，继续加油哦～\"},\"integral_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"main_text\":\"恭喜您抽中了\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"guide_text\":\"积分已发放\"},\"doudian_goods_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"button_text\":\"立即领取\",\"main_text\":\"恭喜您抽中了\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"guide_text\":\"点击“立即领取”进行优惠券报名\"},\"elec_gift_card_pop_up\":{\"button_background\":\"https://p3.dcarimg.com/obj/motor-img/6ff60cc718bc3c8fc5ac5f77f599aacd\",\"button_text\":\"立即查看\",\"main_text\":\"恭喜您抽中了\",\"pop_background\":\"https://p3.dcarimg.com/obj/motor-img/6e62e8850db5cf29974c9df886795122\",\"guide_text\":\"在“我的奖品”中查看奖品\"},\"use_type\":\"page\",\"theme_key\":\"capsule_machine_page\"},\"limit_config\":{\"is_limit\":0,\"limit_tips_text\":\"\"}}","chance_add_config":{"default_draw_chance":0,"cost_type":0,"chance_config":{"1":{"type":1,"cnt":1},"2":{"type":1,"cnt":1}},"virtual_account":{"account":null,"cnt":1}}}}`
	//jsonStr := `https://p6-dcd.byteimg.com/img/motor-img/b5a637b659b36ea3bea5d66859c6246e~300x300.image`
	jsonStr := `{"https://p3-dcd.byteimg.com/img/motor-img/b5a637b659b36ea3bea5d66859c6246e~300x300.image"}`
	re := regexp.MustCompile(`https?://[\w.-/]*motor-img/[\w.~]*`)

	// newStr := re.ReplaceAllStringFunc(jsonStr, Replace)
	newStr := re.FindAllString(jsonStr, 10000)

	fmt.Println(newStr)
}
