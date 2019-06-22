var fs = require("fs");
var dir = "PERSONNEL";
var contents = fs.readFileSync("./" + dir + ".txt", "utf8");
var lines = contents.toString().split("\n");
var exec = require("child_process").exec;
for(var i = 0; i < lines.length; i++){
	var data = lines[i];//.replace(/\r/g,"");
	//data = data.replace("/","");
	console.log("node imag.js \"" + data + "\"");
	exec("node imag.js \"" + data + "\" \"" + dir + "\"");
}
