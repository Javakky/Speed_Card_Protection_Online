var client = require("cheerio-httpcli");

var fs = require("fs");

var txt = "";

client.fetch("http://localhost:8001/", { q: "node.js" }, function (err, $) {

	var tr = $("table[id='ui_wikidb_table_458934'] tbody").children();
	for(var i = 0; i < tr.length; i++){
		var str = tr[i+""]["children"][0]["children"][0]["attribs"]["href"] + "\n";
		str = str.substring(1, str.length);
		txt += str;
	}
	console.log(txt);
	fs.appendFile("INCIDENT.txt", (txt));
});
