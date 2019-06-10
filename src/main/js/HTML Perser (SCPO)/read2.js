var client = require("cheerio-httpcli");
var fs = require("fs");
var data = process.argv[2];
var str = encodeURI("https://scptcgjpjwiki.gamerch.com/" + data);
var text = "";
client.fetch(str, { q: "node.js" }, function (err, $, res) {
	text += $("h2[id='js_wikidb_main_name']").text() + "\n";

	if(($("div[class='ui_wiki_db_bottom_wrapper '] p span[class='ui_bottom_detail']"))["0"]){
		var t = ($("div[class='ui_wiki_db_bottom_wrapper '] p span[class='ui_bottom_detail']"))["0"]["children"];
		var s = "";
		for(var i = 0; i < t.length; i++){
			if(t[i]["data"]){
				s += t[i]["data"];
			}else if(t[i]["name"] == "a"){
				s += t[i]["attribs"]["title"];
			}
		}
		text += s;
	}

	fs.writeFile(data + ".txt", text);
});