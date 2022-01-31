'use strict';

const Hapi = require('@hapi/hapi');
const mongoose = require('mongoose');
const DogController =  require('./src/controllers/dog');
const MongoDBUrl = 'mongodb://localhost:27017/dogapi';
const Joi = require('joi');

// Swagger depdendencies
const Inert = require('@hapi/inert');
const Vision = require('@hapi/vision');
const HapiSwagger = require('hapi-swagger');
const Pack = require('./package');

const swaggerOptions = {
    info: {
        title: 'Books API Documentation',
        version: '0.0.1',
    },
    schemes: ['http','https'],
    host: 'ashiapi.com'
};
var Routes = require('./src/routes');

const server = new Hapi.Server({
  port: 3000,
  host: 'localhost'

});

(async () => {
    const server = await new Hapi.Server({
        host: 'localhost',
        port: 3000,
    });

    const swaggerOptions = {
        info: {
                title: 'Test API Documentation',
                version: Pack.version,
            },
        };

    await server.register([
        Inert,
        Vision,
        {
            plugin: HapiSwagger,
            options: swaggerOptions
        }
    ]);

    try {
        await server.start();
        console.log('Server running at:', server.info.uri);
    } catch(err) {
        console.log(err);
    }

    server.route(Routes);
})();







