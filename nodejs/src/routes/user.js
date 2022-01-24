
const Joi = require("joi")

const getUserInfo =  {
      method: 'GET',
      path: '/user/{name}',
      handler: function (request, reply) {
      const name = request.params.name ? request.params.name : 'stranger';
      return {message:'Hello ' + name};
       }
}

const greetUser =  {
     method: 'GET',
      path: '/welcome/{id}',
      handler: function (request, reply) {
      const id = request.params.id ? request.params.id : 'stranger';
      return { message:'return second cart ' + id };
         }
    }

  const signUpUser = {
      method: 'POST',
      path: '/user/signup',
      handler: function(request, reply) {
        const payload = request.payload;
        const userName = request.payload.username;
        const password = request.payload.password;
        return { message: 'Sign up has been successful for User: ' + userName + 'and Password: ' + password}
      },
          options: {
           validate: {
                payload: Joi.object({
                      username: Joi.string().min(1).max(20),
                      password: Joi.string().min(7).max(10).messages({

                        'string.mim' : `"password" Min length of password is 7`,
                        'string.max' : `"password" Max length of password is 10`,

                        })
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

module.exports = [
   getUserInfo,
   greetUser,
   signUpUser
];