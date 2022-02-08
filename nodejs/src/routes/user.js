
const Joi = require("joi")

var auth = require('../auth/JWT')
var userService = require('../services/userservice')

 const signUpUser = {
      method: 'POST',
      path: '/user/signup',
      handler: userService.createUser,
          options: {
           auth: false,
           description: 'Create user by passing the username, password, age, city',
           notes: 'It will return created user and thier id',
           tags: ['api'], // ADD THIS TAG
           validate: {
                payload: Joi.object({
                      username: Joi.string().required().min(1).max(20).example('testuser').messages({
                        'string.mim' : `"username" Min length of username name is 1`,
                        'string.max' : `"username" Max length of username is 20`,
                          }),
                       password: Joi.string().required().example('test12345').min(8).max(10).messages({
                        'string.mim' : `"password" Min length of password is 7`,
                        'string.max' : `"password" Max length of password is 10`,
                        }),
                        age : Joi.number()
                            .required()
                            .description('user age').example('18'),
                       city: Joi.string().required().example('BLR'),
                   }),
                   failAction: async (request, h, err) => {
                                 //  console.log(err);
                                   throw err;
                               }
               },
           payload: {
             maxBytes: 209715200,
             output: 'data',
             parse: true,
             allow: ['application/json','multipart/form-data']
           }
        }
  }

   const signInUser = {
        method: 'POST',
        path: '/user/signin',
        handler: userService.signInUser,
            options: {
             auth: false,
             description: 'Sign in by username and password',
             notes: 'Return user details with access token',
             tags: ['api'], // ADD THIS TAG
             validate: {
                  payload: Joi.object({
                        username: Joi.string().required().example('testuser'),
                         password: Joi.string().required().example('test12345'),
                     }),
                     failAction: async (request, h, err) => {
                                   //  console.log(err);
                                     throw err;
                                 }
                 },
             payload: {
               maxBytes: 209715200,
               output: 'data',
               parse: true,
               allow: ['application/json','multipart/form-data']
             }

           }
    }

const listUsers =  {
      method: 'GET',
      path: '/user/list',
      handler:  userService.users,
        options: {
               auth: {
                      strategy: 'my_jwt_strategy',
                      //  scope: ['admin'],
                       } ,
               description: 'Get list of user by providing authentication token',
               notes: 'Returns list of users',
               tags: ['api'], // ADD THIS TAG
                validate: {
                    headers: Joi.object({
                        authorization: Joi.string().required()
                    }).options({ allowUnknown: true })
                },
           }
}
const userProfile =  {
      method: 'GET',
      path: '/user/profile/{username}',
      handler:  userService.userProfile,
        options: {
               auth: {
                      strategy: 'my_jwt_strategy',
                      //  scope: ['admin'],
                       } ,
               description: 'Get list of user by providing authentication token',
               notes: 'Returns list of users',
               tags: ['api'], // ADD THIS TAG
                validate: {
                    headers: Joi.object({
                        authorization: Joi.string().required()
                    }).options({ allowUnknown: true }),
                     params: Joi.object({
                                   username : Joi.string()
                                            .required()
                                          .description('Provide username').example('testuser1')})
                },
           }
}

const deleteUserPath =  {
      method: 'DELETE',
      path: '/delete/user/{username}',
      handler:  userService.deleteUser,
        options: {
               auth: {
                    strategy: 'my_jwt_strategy',
                   // scope: ['admin'],
                     },
              description: 'Get user profile with details.',
              notes: 'User information',
              tags: ['api'], // ADD THIS TAG
              validate: {
                   headers: Joi.object({
                      authorization: Joi.string().required()
                               }).options({ allowUnknown: true }),
                               params: Joi.object({
                                    username : Joi.string()
                                           .required()
                                            .description('Provide username').example('testuser1'),
                                        }),
                    },

               plugins: {
                          'hapi-swagger': {
                              responses: {
                                  '200': {  'description' : 'Success',

                                  '401': { 'description': 'Unauthorized error' },
                                  '403': { 'description': 'forbidden' }
                              }
                          },
                 }
              }
           }
}

module.exports = [
   signUpUser,
   signInUser,
   listUsers,
   deleteUserPath,
   userProfile,
];