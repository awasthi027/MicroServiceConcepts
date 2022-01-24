'use strict';

const Hapi = require('@hapi/hapi');
const mongoose = require('mongoose');
const DogController =  require('./src/controllers/dog');
const MongoDBUrl = 'mongodb://localhost:27017/dogapi';
const Joi = require('joi');

var routes = require('./src/routes');


const server = new Hapi.Server({
  port: 3000,
  host: 'localhost'
  
});

server.route(routes);

server.route({
  method: 'GET',
  path: '/dogs',
  handler: DogController.list
});

server.route({
  method: 'GET',
  path: '/dogs/{id}',
  handler: DogController.get
});
server.route({
  method: 'POST',
  path: '/dogs',
  handler: DogController.create,
  options: {
     validate: {
            query: Joi.object({
              age: Joi.number().integer().min(1).max(100).default(10)
            })
        },
    payload: {
      maxBytes: 209715200,
      output: 'file',
      parse: true,
      multipart: true     // <-- this fixed the media type error
    }
  }
});

server.route({
  method: 'PUT',
  path: '/dogs/{id}',
  handler: DogController.update,
   options: {
    validate: {
            query: Joi.object({
              age: Joi.number().integer().min(1).max(100).default(10)
            })
        },
    payload: {
      maxBytes: 209715200,
      output: 'file',
      parse: true,
      multipart: true     // <-- this fixed the media type error
    }
  }
});

server.route({
  method: 'DELETE',
  path: '/dogs/{id}',
  handler: DogController.remove
});

(async () => {
  try {  
    await server.start();
    // Once started, connect to Mongo through Mongoose
    mongoose.connect(MongoDBUrl, {}).then(() => { console.log(`Connected to Mongo server`) }, err => { console.log(err) });
    console.log(`Server running at: ${server.info.uri}`);
  }
  catch (err) {  
    console.log(err)
  }
})();
