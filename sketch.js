console.log('running sketch.js');


var Twit = require('twit');
var config = require('./config');


var T = new Twit(config);

tweetBot;
setInterval(tweetBot, 1000*60*5*25);

function tweetBot(){
  let r = Math.floor(Math.random()*100);
  let tweet = {
  status: r
}
  T.post('statuses/update', tweet, function(err, data, response) {
    if (err){
      console.log("Post Unsuccessfull");
    } else {
      console.log("Status Posted Successfully");
    }
  });

}



// T.get('search/tweets', { q: 'banana since:2018-07-31', count: 3 }, function(err, data, response) {
//   console.log(data)
// })
