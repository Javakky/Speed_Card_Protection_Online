var client = require("cheerio-httpcli");
var data = process.argv[2];
var str = encodeURI("http://challenge-server.code-check.io/api/hash");
client.fetch(str, { q: data }, function (err, $, res) {
	console.log(res);
});