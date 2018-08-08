console.log('running sketch.js');


var Twit = require('twit');
var config = require('./config');
var exec = require('child_process').exec;
var fs = require('fs');




var T = new Twit(config);

tweetBot();
setInterval(tweetBot, 1000*60*60);

function tweetBot(){
  let r = Math.floor(Math.random()*100);
  let r1 = Math.floor(Math.random()*23);
  let x = ['a', 'b', 'c', 'd', 'e','f', 'g', 'j', 'l', 'L', 'm', 'beta', 'boogie', 'carta', 'theta', 'svedanya','aster', '12', 'tango', 'hello', 'lula', 'iris'];
  var cmd = 'processing-java --sketch=`pwd`/test1 --run';
  exec(cmd, processing);

  function processing(){
    var filename = 'test1/output.png';
    var params = {
      encoding: 'base64'
    }
    var b64content = fs.readFileSync(filename, params);
    console.log('processing finished');

    T.post('media/upload', { media_data: b64content }, uploaded );
    function uploaded(err, data, response){
      //this is where i will tweet!
      var id = data.media_id_string;
      let tweet = {
        status: 'tropic' + r + ' ' + x[r1],
        media_ids: [id]
      }
      T.post('statuses/update', tweet, tweeted);
      function tweeted(err, data, response) {
        if (err){
          console.log("Post Unsuccessfull");
        } else {
          console.log("Status Posted Successfully");
        }
      };
    }
  }
}




// T.get('search/tweets', { q: 'banana since:2018-07-31', count: 3 }, function(err, data, response) {
//   console.log(data)
// })
