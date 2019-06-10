var client = require("cheerio-httpcli");
var fs = require("fs");
var request = require("request");
var data = process.argv[2];
var str = encodeURI("https://scptcgjpjwiki.gamerch.com/" + data);
client.fetch(str, { q: "node.js" }, function (err, $, res) {
	var url = ($("div[id='ui_wikidb_main_img_wrap']").children())["0"]["attribs"]["href"];
	
	request(
		{method: "GET", url: url, encoding: null},
		function (error, response, body){
			if(!error && response.statusCode === 200){
				fs.writeFileSync(data + ".jpg", body, "binary");
			}
		}
	);
});