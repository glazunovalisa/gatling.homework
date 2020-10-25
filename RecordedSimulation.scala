package homework1

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://demo.nopcommerce.com")
		.disableFollowRedirect
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0")

	val headers_0 = Map(
		"Content-Type" -> "text/plain;charset=UTF-8",
		"Origin" -> "null")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Content-Type" -> "text/plain",
		"Origin" -> "https://demo.nopcommerce.com")

	val headers_3 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_6 = Map("If-None-Match" -> "659743217")

	val headers_7 = Map("Accept" -> "image/webp,*/*")

	val headers_9 = Map("If-Modified-Since" -> "Sun, 25 Oct 2020 14:52:50 GMT")

	val headers_10 = Map(
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "https://demo.nopcommerce.com",
		"X-Requested-With" -> "XMLHttpRequest")

    val uri1 = "https://www.google-analytics.com"
    val uri2 = "https://api-public.addthis.com/url/shares.json"
    val uri3 = "https://v1.addthisedge.com/live/boost/nopsolutions/_ate.track.config_resp"
    val uri5 = "https://m.addthis.com/live/red_lojson"

	val scn = scenario("RecordedSimulation")
		// open homepage
		.exec(http("request_0")
			.post(uri5 + "/100eng.json?sh=0&ph=2896&ivh=654&dt=48974&pdt=545&ict=&pct=0&perf=widget%7C545%7C72%2Clojson%7C1092%7C393%2Csh%7C1105%7C164&rndr=render_toolbox%7C1456&cmenu=null&ppd=0&ppl=0&fbe=&xmv=0&xms=0&xmlc=0&jsfw=jquery%2Cgoogleanalytics&jsfwv=jquery-3.4.1%2Cgoogleanalytics-analytics.js&al=men&scr=0&scv=0&apiu=0&ba=3&sid=5f95951c0b4fa5b7&rev=v8.28.7-wp&pub=nopsolutions&dp=demo.nopcommerce.com&fp=apple-macbook-pro-13-inch&pfm=0&icns=addthis%2Cfacebook%2Ctwitter%2Cprint%2Cemail")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/")
			.headers(headers_1),
            http("request_2")
			.post(uri1 + "/j/collect?v=1&_v=j86&a=1932813661&t=pageview&_s=1&dl=https%3A%2F%2Fdemo.nopcommerce.com%2F&ul=ru-ru&de=UTF-8&dt=nopCommerce%20demo%20store&sd=24-bit&sr=1366x768&vp=1349x654&je=0&fl=30.0%20r0&_u=AACAAAABAAAAAC~&jid=958418447&gjid=350537774&cid=410906928.1603127034&tid=UA-7490022-2&_gid=1283064099.1603637542&_r=1&_slc=1&z=325305816")
			.headers(headers_2)))
		.pause(24)
		// search for random product
		.exec(http("request_3")
			.get("/catalog/searchtermautocomplete?term=apple%20")
			.headers(headers_3))
		.pause(21)
		// open random product page
		.exec(http("request_4")
			.get("/catalog/searchtermautocomplete?term=apple")
			.headers(headers_3))
		.pause(1)
		.exec(http("request_5")
			.get("/apple-macbook-pro-13-inch")
			.headers(headers_1)
			.resources(http("request_6")
			.get(uri3)
			.headers(headers_6),
            http("request_7")
			.get(uri1 + "/collect?v=1&_v=j86&a=529181881&t=pageview&_s=1&dl=https%3A%2F%2Fdemo.nopcommerce.com%2Fapple-macbook-pro-13-inch&ul=ru-ru&de=UTF-8&dt=nopCommerce%20demo%20store.%20Apple%20MacBook%20Pro%2013-inch&sd=24-bit&sr=1366x768&vp=1349x654&je=0&fl=30.0%20r0&_u=AACAAAAB~&jid=&gjid=&cid=410906928.1603127034&tid=UA-7490022-2&_gid=1283064099.1603637542&z=862939109")
			.headers(headers_7),
            http("request_8")
			.get(uri5 + "/300lo.json?si=5f959582dd88efa7&bkl=0&bl=1&pdt=815&sid=5f959582dd88efa7&pub=nopsolutions&rev=v8.28.7-wp&ln=en&pc=men&cb=0&ab=-&dp=demo.nopcommerce.com&fp=apple-macbook-pro-13-inch&fr=&of=2&pd=1&irt=1&vcl=1&md=0&ct=1&tct=0&abt=0&cdn=0&pi=1&rb=2&gen=100&chr=UTF-8&mk=open%20source%20ecommerce%2Copen-source%20ecommerce%2CC%23%20shopping%20cart%2CC%23%2Casp.net%20e-commerce%20storefront%2Casp.net%20web%20store%2C.net%20ecommerce%2CC%23%20shopping%20cart%2Cshopping%20cart%2Ce-commerce&colc=1603638658846&jsl=1&uvs=5f95914149e580a1003&skipb=1&callback=addthis.cbs.jsonp__6586281142639370"),
            http("request_9")
			.get(uri2 + "?url=https%3A%2F%2Fdemo.nopcommerce.com%2Fapple-macbook-pro-13-inch&callback=_ate.cbs.sc_httpsdemonopcommercecomapplemacbookpro13inch0")
			.headers(headers_9)))
		.pause(16)
		// add to cart
		.exec(http("request_10")
			.post("/addproducttocart/details/4/1")
			.headers(headers_10)
			.formParam("addtocart_4.EnteredQuantity", "2")
			.formParam("__RequestVerificationToken", "CfDJ8NJzpPdWJDZGtf_4GVVpZ2lIq56lIva_BCXQAgFKyBfxnOnaRHsNYofL-wN3L5FmdCUQacCv25nsfBYT9yDCKz5Kb_Vv0AkeA4JN3YXziCsez9g4YoMuldsDSBrvhdGEEt9_za2iiXlSCgnzXcUsvdo"))
		.pause(17)
		// go to shopping cart
		.exec(http("request_11")
			.post(uri5 + "/100eng.json?sh=1186&ph=2896&ivh=654&dt=33840&pdt=815&ict=&pct=2&perf=widget%7C815%7C78%2Clojson%7C1331%7C183%2Csh%7C1352%7C145&rndr=render_toolbox%7C1389&cmenu=null&ppd=0&ppl=0&fbe=&xmv=0&xms=0&xmlc=0&jsfw=jquery%2Cgoogleanalytics&jsfwv=jquery-3.4.1%2Cgoogleanalytics-analytics.js&al=men&scr=0&scv=0&apiu=0&ba=3&sid=5f959582dd88efa7&rev=v8.28.7-wp&pub=nopsolutions&dp=demo.nopcommerce.com&fp=apple-macbook-pro-13-inch&pfm=0&icns=addthis%2Cfacebook%2Ctwitter%2Cprint%2Cemail")
			.headers(headers_0)
			.resources(http("request_12")
			.get("/cart")
			.headers(headers_1),
            http("request_13")
			.post(uri1 + "/j/collect?v=1&_v=j86&a=965181285&t=pageview&_s=1&dl=https%3A%2F%2Fdemo.nopcommerce.com%2Fcart&ul=ru-ru&de=UTF-8&dt=nopCommerce%20demo%20store.%20Shopping%20Cart&sd=24-bit&sr=1366x768&vp=1349x654&je=0&fl=30.0%20r0&_u=AACAAAABAAAAAC~&jid=1260987026&gjid=1587595691&cid=410906928.1603127034&tid=UA-7490022-2&_gid=1283064099.1603637542&_r=1&_slc=1&z=1813471973")
			.headers(headers_2),
            http("request_14")
			.post("/shoppingcart/checkoutattributechange?isEditable=True")
			.headers(headers_10)
			.formParam("itemquantity11216", "2")
			.formParam("CountryId", "0")
			.formParam("StateProvinceId", "0")
			.formParam("ZipPostalCode", "")
			.formParam("checkout_attribute_1", "1")
			.formParam("discountcouponcode", "")
			.formParam("giftcardcouponcode", "")
			.formParam("__RequestVerificationToken", "CfDJ8NJzpPdWJDZGtf_4GVVpZ2mXDIStuq3nBQmaA_fY2V-MDJDZjuHf5jVclkNcKv56tx2a8Y2BzdvQbSbw2uD_7sn1o6Iuv_7Rew4lqxWkks7tOKUTPRPg6x9yZlxwRUu6G-WDuqfScn33f-8p4DvOAys"),
            http("request_15")
			.post("/shoppingcart/selectshippingoption")
			.headers(headers_10)
			.formParam("itemquantity11216", "2")
			.formParam("CountryId", "0")
			.formParam("StateProvinceId", "0")
			.formParam("ZipPostalCode", "")
			.formParam("checkout_attribute_1", "1")
			.formParam("discountcouponcode", "")
			.formParam("giftcardcouponcode", "")
			.formParam("__RequestVerificationToken", "CfDJ8NJzpPdWJDZGtf_4GVVpZ2mXDIStuq3nBQmaA_fY2V-MDJDZjuHf5jVclkNcKv56tx2a8Y2BzdvQbSbw2uD_7sn1o6Iuv_7Rew4lqxWkks7tOKUTPRPg6x9yZlxwRUu6G-WDuqfScn33f-8p4DvOAys")))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}