console.log('weird');

var Twit = require('twit');
var config = require('./config');
console.log(config);

var T = new Twit(config);

T.post('statuses/update', { status: 'hello world!' }, function(err, data, response) {
  console.log(data)
});

T.get('search/tweets', { q: 'banana since:2018-07-31', count: 3 }, function(err, data, response) {
  console.log(data)
})
