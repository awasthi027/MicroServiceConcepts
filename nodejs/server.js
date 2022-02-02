'use strict';

const Hapi = require('@hapi/hapi');
const mongoose = require('mongoose');
const DogController =  require('./src/controllers/dog');
const MongoDBUrl = 'mongodb://localhost:27017/dogapi';
const Joi = require('joi');

const BasicAuth = require('hapi-auth-basic')
const Bcrypt = require('bcrypt')

// swagger depdendencies
const Inert = require('@hapi/inert');
const Vision = require('@hapi/vision');
const HapiSwagger = require('hapi-swagger');
const Pack = require('./package');

var Routes = require('./src/routes');

 const swaggerOptions = {
        info: {
                title: 'Test API Documentation',
                version: Pack.version,
            },
             schemes: ['http','https'],
  };


// hardcoded users object … just for illustration purposes
// API dummy authentication for username: john and password: secret
 const users = {
    john: {
      username: 'john',
      password: '$2a$10$iqJSHD.BGr0E2IxQwYgJmeP3NvhPrXAeLSaGCj6IR/XU5QtjVu5Tm',   // 'secret'
      name: 'John Doe',
      id: '2133d32a'
   }
 };
   // validation function used for hapi-auth-basic
   const validate = async (request, username, password, h) => {

   if (username === 'help') {
       return { response: h.redirect('https://hapijs.com/help') };     // custom response
   }

   const user = users[username];
   if (!user) {
       return { credentials: null, isValid: false };
   }

   const isValid = await Bcrypt.compare(password, user.password);
   const credentials = { id: user.id, name: user.name };

   return { isValid, credentials };
   };

const main = async () => {
    const server = Hapi.server({
    port: 3000,
    host: 'localhost'
     });

await server.register([
    Inert,
    Vision, {
        plugin: HapiSwagger,
        options: swaggerOptions
    }
]);

   // Register rate limiter plugins
      await server.register({
         plugin: require('hapi-rate-limitor'),
         options: {
           redis: {
             port: 6379,
             host: '127.0.0.1'
           },
           namespace: 'hapi-rate-limitor',
           max: 10,             // a maximum of 60 requests
           duration: 60 * 1000, // per minute (the value is in milliseconds)
           enabled: true ,
           pathLimit: true
         }
       })
    await server.register(require('hapi-auth-basic'));
    server.auth.strategy('simple', 'basic', { validate });
    server.auth.default('simple');
    await server.start();
    server.route(Routes);
    return server;
};

main()
.then((server) => console.log(`Server listening on ${server.info.uri}`))
.catch((err) => {
    console.error(err);
    process.exit(1);
})
