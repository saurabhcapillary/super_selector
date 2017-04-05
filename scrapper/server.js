var express = require('express');
var fs = require('fs');
var request = require('request');
var cheerio = require('cheerio');
var http = require('http');
var app = express();
var playerMapping = require('./playerMapping.json');

app.get('/scrape', function (req, res) {
    matchId = req.query.matchId;
    cbMatchId = 18187 + parseInt(matchId);
    url = 'http://www.cricbuzz.com/live-cricket-scorecard/' + cbMatchId + '/slug';
    console.log(url);
    request(url, function (error, response, html) {
        if (!error) {
            var $ = cheerio.load(html);
            function merge(obj1, obj2) {
                var obj3 = {};
                for (var attrname in obj1) {
                    obj3[attrname] = obj1[attrname];
                }
                for (var attrname in obj2) {
                    obj3[attrname] = obj2[attrname];
                }
                return obj3;
            }
            pushToMap = function (player) {
                id = player.id;
                player.playerId = playerMapping[id];
                if (json[id] == undefined) {
                    json[id] = player;
                } else {
                    storedPlayer = json[id];
                    json[id] = merge(player, storedPlayer);
                }
            }

            var json = {};

            $('.cb-scrd-itms').filter(function () {
                var data = $(this);
                playerData = {}
                player = data.children('.cb-col-27');
                playerData.name = player.text();
                if (playerData.name === "" || playerData.name.indexOf("Did") !== -1) {
                    player = data.children('.cb-col-40');
                    playerData.name = player.text();
                    playerData.matchId = matchId;
                    if (playerData.name === "") {
                        return;
                    }
                    playerLink = player.children('a').attr('href');
                    playerData.link = playerLink;
                    playerData.id = playerLink !== "" ? playerLink.split("/")[2] : "";
                    scores = data.children();
                    playerData.overs = scores.eq(1).text();
                    playerData.wickets = scores.eq(4).text();
                    playerData.econRate = scores.last().text();
                    pushToMap(playerData);
                    return;
                }
                playerLink = player.children('a').attr('href');
		console.log(playerLink);
                playerData.link = playerLink;
                playerData.id = playerLink !== "" ? playerLink.split("/")[2] : "";
                reason = data.children('.cb-col-33');
                playerData.reason = reason.text();
                scores = data.children('.cb-col-8');
                playerData.runs = scores.eq(0).text();
                //playerData.balls = scores.eq(1).text();
                playerData.fours = scores.eq(2).text();
                playerData.sixes = scores.eq(3).text();
                playerData.strikeRate = scores.eq(4).text();
                pushToMap(playerData);

            });

        }

        var arr = Object.keys(json).map(function (k) {
            return json[k]
        });

        pushToAPI({"matchPoints": arr});
        res.send(JSON.stringify({"matchPoints": arr}, null, 4));

    });
});

pushToAPI = function (data) {
    var bodyString = JSON.stringify(data);

    var headers = {
        'Content-Type': 'application/json',
        'User-Agent': 'shubhra'
    };

    var options = {
        //       host: 'ec2-52-11-41-143.us-west-2.compute.amazonaws.com',
        host: "localhost",
        path: '/v1/team_select/',
        port: 1900,
        method: 'PUT',
        headers: headers
    };

    var req = http.request(options, function (res) {
        console.log(res.statusCode);
    });
    req.write(bodyString);
    req.on('error', function (e) {
        console.log('problem with request: ' + e.message);
    });
};
app.listen('8081')

console.log('Magic happens on port 8081');

exports = module.exports = app;
