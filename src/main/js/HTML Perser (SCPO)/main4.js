
var client = require("cheerio-httpcli");

var fs = require("fs");

var safe = [];
var euclid = [];
var keter = [];
var Neutralized = [];
var Explained = [];
var Thaumiel = [];
var Unclassed = [];
var Anomalous = [];

client.fetch("http://localhost:8001/", { q: "node.js" }, function (err, $) {
	var txt;
	var tr = $("table[id='ui_wikidb_table_541015'] tbody").children();
	var name;
	for(var i = 0; i < tr.length; i++){
		txt += tr[i+""]["children"][0]["children"][0]["attribs"]["href"] + "\n";
		var str = tr[i+""]["children"][0]["children"][0]["attribs"]["href"];
		name = tr[i+""]["children"][2]["children"][0]["children"][0]["attribs"]["title"];
		fs.appendFile(name + ".txt", str.substring(1, str.length) + "\n");
	}
	
	
});
