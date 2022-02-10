var handlers = require('../services/todohandler');
const Joi = require("joi");


const todoInfo =  {
    method: 'GET',
    path: '/todo/{id}/',
    handler: handlers.get,
    options: {
        auth: 'simple',
        description: 'Get todo',
        notes: 'Returns a todo item by the id passed in the path',
        tags: ['api'], // ADD THIS TAG
        validate: {
            params: Joi.object({
                id : Joi.number()
                        .required()
                        .description('the id for the todo item').example('10'),
            }),
        },
         plugins: {
                    'hapi-swagger': {
                        responses: {
                            '200': {  'description' : 'Success',
                                   'schema': Joi.object({
                                                     title: Joi.string().description('Title Info').required().example('Java Topic'),
                                                     desc: Joi.string().description('Description info').required().example('Java Topic must to learn'),
                                                   }).description('TODO Topic details.'),
                                    },
                            '401': { 'description': 'Unauthorized error' },
                            '403': { 'description': 'forbidden' }
                        }
                    },
                   'hapi-rate-limitor': {
                            max: 100,              // a maximum of 5 requests
                            duration: 60 * 1000, // per minute
                            enabled: true       // but it’s actually not enabled ;-)
                     }

           }
    },
  }

const createTODO =  {
    method: 'POST',
    path: '/todo/',
    handler: handlers.createTODO,
    options: {
        auth: 'simple',
        description: 'Create todo record.',
        notes: 'Returns created record and status',
        tags: ['api'], // ADD THIS TAG
        validate: {
            payload: Joi.object().keys({
                   title: Joi.string().required().description('the id for the todo item').example('10'),
                   desc: Joi.string().required().description('the id for the todo item').example('10'),
              }),
        },
         plugins: {
                    'hapi-swagger': {
                        responses: {
                            '200': {  'description' : 'Success',
                                   'schema': Joi.object({
                                                     title: Joi.string().description('Title Info').required().example('Java Topic'),
                                                     desc: Joi.string().description('Description info').required().example('Java Topic must to learn'),
                                                   }).description('TODO Topic details.'),
                                    },
                            '401': { 'description': 'Unauthorized error' },
                            '403': { 'description': 'forbidden' }
                        }
                    }
                 }
    },
  }
module.exports = [
   todoInfo,
   createTODO,
];