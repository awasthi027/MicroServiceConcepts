

 module.exports = [  {

           plugin: require('hapi-rate-limitor'),
           options: {
             redis: {
               port: 6379,
               host: '127.0.0.1'
             },
             namespace: 'hapi-rate-limitor',
             userAttribute: 'id',
             userLimitAttribute: 'rateLimit',
             max: 1000,             // a maximum of 60 requests
             duration: 60 * 1000, // per minute (the value is in milliseconds)

        }
     }
 ];
