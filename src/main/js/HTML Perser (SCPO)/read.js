var client = require("cheerio-httpcli");
var fs = require("fs");
var data = process.argv[2];
var str = encodeURI("https://scptcgjpjwiki.gamerch.com/" + data);
var text = "";
client.fetch(str, { q: "node.js" }, function (err, $, res) {
	text += $("h2[id='js_wikidb_main_name']").text() + "\n";
	text += $("div[class='ui_wikidb_top_pc '] p a[class='ui_page_match']").text() + "\n";
	var t = $("div[class='ui_wikidb_top_middle_area'] div[class='ui_wikidb_middle_area ui_clearfix'] div").children();
	var s = t["0"]["children"][1]["data"];
	text += s.substr(1, s.length) + "\n";
	s = t["1"]["children"][1]["data"];
	text += s.substr(1, s.length) + "\n";

	t = ($("div[class='ui_wiki_db_bottom_wrapper '] p span[class='ui_bottom_detail']"))["2"]["children"];
	if(t[0]["data"]){
		text += t[0]["data"].replace(/\s/g, ",") + "\n";
	}

	text += ($("section[id='js_async_main_column_text'] div[class='ui_wiki_db_bottom_wrapper ']").children()[1]["children"][1]["data"].replace(/\s/g, "") + "\n");

	if(($("div[class='ui_wiki_db_bottom_wrapper '] p span[class='ui_bottom_detail']"))["0"]){
		t = ($("div[class='ui_wiki_db_bottom_wrapper '] p span[class='ui_bottom_detail']"))["0"]["children"];
		s = "";
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