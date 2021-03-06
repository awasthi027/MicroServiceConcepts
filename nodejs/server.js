'use strict';

const Hapi = require('@hapi/hapi');
const mongoose = require('mongoose');
const MongoDBUrl = 'mongodb://localhost:27017/dogapi';
const Joi = require('joi');
const Boom = require('boom');
const BasicAuth = require('hapi-auth-basic')
const Bcrypt = require('bcrypt')

const Jwt = require('@hapi/jwt');
// swagger depdendencies
const Inert = require('@hapi/inert');
const Vision = require('@hapi/vision');
const HapiSwagger = require('hapi-swagger');
const Pack = require('./package');

let Routes = require('./src/routes_apis');
let plugins = require('./src/plugins');

let nconf = require('./src/lib/config');

 const swaggerOptions = {
        info: {
                title: 'Test API Documentation',
                version: Pack.version,
            },
            schemes: nconf.get('server:schema'),
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


   // bring your own validation function

const main = async () => {
    const server = Hapi.server({
    port: nconf.get('server:port'),
    host: nconf.get('server:host')
     });

await server.register([
    Inert,
    Vision, {
        plugin: HapiSwagger,
        options: swaggerOptions
    }
]);

   // Register  plugins
    await server.register(plugins)

    await server.register(Jwt);
    server.auth.strategy('my_jwt_strategy', 'jwt', {
        keys: 'some_shared_secret',
        verify: {
                    aud: 'urn:audience:test',
                    iss: 'urn:issuer:test',
                    sub: false,
                    nbf: true,
                    exp: true,
                    maxAgeSec: 14400, // 4 hours
                    timeSkewSec: 15
                },
                validate: (artifacts, request, h) => {
                    return {
                        isValid: true,
                        credentials: { user: artifacts.decoded.payload.user }
                    };
                }
    });
    // Set the strategy
    server.auth.default('my_jwt_strategy');

    await server.register(require('hapi-auth-basic'));
    server.auth.strategy('simple', 'basic', { validate });

    await server.start();
    server.route(Routes);
    return server;
};

main()
.then((server) => {
// Once started, connect to Mongo through Mongoose
  mongoose.connect(MongoDBUrl, {}, (err) => {
    if (err) {
      throw err;
    }
  });
console.log(`Server listening on ${server.info.uri}`)

}).catch((err) => {
    console.error(err);
    process.exit(1);
})
